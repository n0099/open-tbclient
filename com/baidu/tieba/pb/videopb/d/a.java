package com.baidu.tieba.pb.videopb.d;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.AddExperiencedModel;
import java.text.MessageFormat;
/* loaded from: classes9.dex */
public class a {
    public static void a(final PbActivity pbActivity, int i, int i2) {
        String cny;
        String str;
        String str2;
        if (pbActivity != null && pbActivity.clB() != null) {
            final PbModel clB = pbActivity.clB();
            final View rootView = pbActivity.getRootView();
            if (clB.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                e pbData = clB.getPbData();
                String title = pbData.cku().getTitle();
                int i3 = clB.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Iw(pbData.getForumId())) {
                        z = true;
                    }
                }
                bj cku = clB.getPbData().cku();
                if (cku.aEi()) {
                    cny = cku.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + cku.getBaijiahaoData().oriUgcType + "&dvid=" + cku.getBaijiahaoData().oriUgcVid + "&nid=" + cku.getBaijiahaoData().oriUgcNid;
                } else {
                    cny = clB.cny();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + cny + str;
                String[] fj = pbData.fj(pbActivity);
                String str4 = fj[0];
                if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str4 == null ? null : Uri.parse(str4);
                String str5 = fj[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new an("c10399").cy("fid", pbData.getForumId()).cy("tid", pbData.getThreadId()).cy("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.ckS() && cku.aCo() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5) || cku.aEh() || cku.aBe()) {
                        str2 = TextUtils.isEmpty(title) ? fj[1] : title;
                        title = MessageFormat.format(string, cku.aCo().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                    } else {
                        str2 = title;
                        title = str5;
                    }
                } else if (aq.isEmpty(str5)) {
                    str2 = title;
                } else {
                    str2 = title;
                    title = str5;
                }
                String cutString = aq.cutString(str2, 100);
                String cutString2 = aq.cutString(title, 100);
                ShareItem shareItem = new ShareItem();
                shareItem.title = cutString;
                shareItem.content = cutString2;
                if (pbData.ckS()) {
                    shareItem.dqc = cutString2;
                    shareItem.readCount = -1L;
                } else if (pbData.cku() != null && pbData.cku().aCF() != null && !pbData.cku().aEi()) {
                    shareItem.readCount = pbData.cku().aCF().play_count.intValue();
                }
                shareItem.linkUrl = str3;
                shareItem.dpP = true;
                shareItem.dpX = z;
                shareItem.extData = clB.cny();
                shareItem.dqf = 3;
                shareItem.dqe = i2;
                shareItem.fid = clB.getForumId();
                shareItem.tid = clB.cny();
                shareItem.dqj = C(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.ckS()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.dqm = OriginalThreadInfo.ShareInfo.generateShareInfo(cku);
                if (pbData != null && pbData.ckw() != null && pbData.ckw().size() > 0) {
                    shareItem.dqn = ShareItem.ForwardInfo.generateForwardInfo(cku, 1, pbData.ckw().get(0));
                } else {
                    shareItem.dqn = ShareItem.ForwardInfo.generateForwardInfo(cku, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (cku != null) {
                    shareItem.dqt = cku.getShareImageUrl();
                }
                shareItem.dqg = x(cku);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.dqf);
                bundle.putInt("obj_type", shareItem.dqj);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.Y(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.videopb.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().aHK() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.e.bwm().b(shareDialogConfig);
            }
        }
    }

    private static int x(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aBd()) {
            return 10;
        }
        if (bjVar.aBe()) {
            return 9;
        }
        if (bjVar.aEh()) {
            return 8;
        }
        if (bjVar.aEg()) {
            return 7;
        }
        if (bjVar.isShareThread) {
            return 6;
        }
        if (bjVar.threadType == 0) {
            return 1;
        }
        if (bjVar.threadType == 40) {
            return 2;
        }
        if (bjVar.threadType == 49) {
            return 3;
        }
        if (bjVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    private static int C(e eVar) {
        bj cku;
        if (eVar != null && (cku = eVar.cku()) != null) {
            if (cku.aCq()) {
                return 4;
            }
            if (cku.aCl() == 1) {
                return 3;
            }
            if (cku.aBd()) {
                return 5;
            }
            if (cku.aBe()) {
                return 6;
            }
            if (cku.aEg()) {
                return 7;
            }
            if (cku.aEh()) {
                return 8;
            }
            return cku.aDB() ? 2 : 1;
        }
        return 0;
    }
}
