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
        String cnU;
        String str;
        String str2;
        if (pbActivity != null && pbActivity.clX() != null) {
            final PbModel clX = pbActivity.clX();
            final View rootView = pbActivity.getRootView();
            if (clX.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                e pbData = clX.getPbData();
                String title = pbData.ckP().getTitle();
                int i3 = clX.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Iw(pbData.getForumId())) {
                        z = true;
                    }
                }
                bj ckP = clX.getPbData().ckP();
                if (ckP.aEm()) {
                    cnU = ckP.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + ckP.getBaijiahaoData().oriUgcType + "&dvid=" + ckP.getBaijiahaoData().oriUgcVid + "&nid=" + ckP.getBaijiahaoData().oriUgcNid;
                } else {
                    cnU = clX.cnU();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + cnU + str;
                String[] fi = pbData.fi(pbActivity);
                String str4 = fi[0];
                if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str4 == null ? null : Uri.parse(str4);
                String str5 = fi[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new an("c10399").cx("fid", pbData.getForumId()).cx("tid", pbData.getThreadId()).cx("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.cln() && ckP.aCr() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5) || ckP.aEl() || ckP.aBh()) {
                        str2 = TextUtils.isEmpty(title) ? fi[1] : title;
                        title = MessageFormat.format(string, ckP.aCr().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
                if (pbData.cln()) {
                    shareItem.dqC = cutString2;
                    shareItem.readCount = -1L;
                } else if (pbData.ckP() != null && pbData.ckP().aCI() != null && !pbData.ckP().aEm()) {
                    shareItem.readCount = pbData.ckP().aCI().play_count.intValue();
                }
                shareItem.linkUrl = str3;
                shareItem.dqp = true;
                shareItem.dqx = z;
                shareItem.extData = clX.cnU();
                shareItem.dqF = 3;
                shareItem.dqE = i2;
                shareItem.fid = clX.getForumId();
                shareItem.tid = clX.cnU();
                shareItem.dqJ = C(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.cln()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.dqM = OriginalThreadInfo.ShareInfo.generateShareInfo(ckP);
                if (pbData != null && pbData.ckR() != null && pbData.ckR().size() > 0) {
                    shareItem.dqN = ShareItem.ForwardInfo.generateForwardInfo(ckP, 1, pbData.ckR().get(0));
                } else {
                    shareItem.dqN = ShareItem.ForwardInfo.generateForwardInfo(ckP, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (ckP != null) {
                    shareItem.dqT = ckP.getShareImageUrl();
                }
                shareItem.dqG = y(ckP);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.dqF);
                bundle.putInt("obj_type", shareItem.dqJ);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.Y(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.videopb.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().aHP() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.e.bws().b(shareDialogConfig);
            }
        }
    }

    private static int y(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aBg()) {
            return 10;
        }
        if (bjVar.aBh()) {
            return 9;
        }
        if (bjVar.aEl()) {
            return 8;
        }
        if (bjVar.aEk()) {
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
        bj ckP;
        if (eVar != null && (ckP = eVar.ckP()) != null) {
            if (ckP.aCt()) {
                return 4;
            }
            if (ckP.aCo() == 1) {
                return 3;
            }
            if (ckP.aBg()) {
                return 5;
            }
            if (ckP.aBh()) {
                return 6;
            }
            if (ckP.aEk()) {
                return 7;
            }
            if (ckP.aEl()) {
                return 8;
            }
            return ckP.aDF() ? 2 : 1;
        }
        return 0;
    }
}
