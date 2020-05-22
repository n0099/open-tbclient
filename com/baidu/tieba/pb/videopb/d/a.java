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
import com.baidu.tbadk.core.data.bk;
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
        String cFt;
        String str;
        String str2;
        if (pbActivity != null && pbActivity.cDy() != null) {
            final PbModel cDy = pbActivity.cDy();
            final View rootView = pbActivity.getRootView();
            if (cDy.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                e pbData = cDy.getPbData();
                String title = pbData.cCi().getTitle();
                int i3 = cDy.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.LP(pbData.getForumId())) {
                        z = true;
                    }
                }
                bk cCi = cDy.getPbData().cCi();
                if (cCi.aSx()) {
                    cFt = cCi.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + cCi.getBaijiahaoData().oriUgcType + "&dvid=" + cCi.getBaijiahaoData().oriUgcVid + "&nid=" + cCi.getBaijiahaoData().oriUgcNid;
                } else {
                    cFt = cDy.cFt();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + cFt + str;
                String[] fe = pbData.fe(pbActivity);
                String str4 = fe[0];
                if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str4 == null ? null : Uri.parse(str4);
                String str5 = fe[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new an("c10399").dh("fid", pbData.getForumId()).dh("tid", pbData.getThreadId()).dh("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.cCJ() && cCi.aQx() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5) || cCi.aSw() || cCi.aPn()) {
                        str2 = TextUtils.isEmpty(title) ? fe[1] : title;
                        title = MessageFormat.format(string, cCi.aQx().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
                if (pbData.cCJ()) {
                    shareItem.eeT = cutString2;
                    shareItem.readCount = -1L;
                } else if (pbData.cCi() != null && pbData.cCi().aQQ() != null && !pbData.cCi().aSx()) {
                    shareItem.readCount = pbData.cCi().aQQ().play_count.intValue();
                }
                shareItem.linkUrl = str3;
                shareItem.eeH = true;
                shareItem.eeO = z;
                shareItem.extData = cDy.cFt();
                shareItem.eeW = 3;
                shareItem.eeV = i2;
                shareItem.fid = cDy.getForumId();
                shareItem.tid = cDy.cFt();
                shareItem.efa = E(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.cCJ()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.efd = OriginalThreadInfo.ShareInfo.generateShareInfo(cCi);
                if (pbData != null && pbData.cCk() != null && pbData.cCk().size() > 0) {
                    shareItem.efe = ShareItem.ForwardInfo.generateForwardInfo(cCi, 1, pbData.cCk().get(0));
                } else {
                    shareItem.efe = ShareItem.ForwardInfo.generateForwardInfo(cCi, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (cCi != null) {
                    shareItem.efk = cCi.getShareImageUrl();
                }
                shareItem.eeX = z(cCi);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.eeW);
                bundle.putInt("obj_type", shareItem.efa);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.videopb.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().aWi() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.e.bMw().b(shareDialogConfig);
            }
        }
    }

    private static int z(bk bkVar) {
        if (bkVar == null) {
            return 0;
        }
        if (bkVar.aPm()) {
            return 10;
        }
        if (bkVar.aPn()) {
            return 9;
        }
        if (bkVar.aSw()) {
            return 8;
        }
        if (bkVar.aSv()) {
            return 7;
        }
        if (bkVar.isShareThread) {
            return 6;
        }
        if (bkVar.threadType == 0) {
            return 1;
        }
        if (bkVar.threadType == 40) {
            return 2;
        }
        if (bkVar.threadType == 49) {
            return 3;
        }
        if (bkVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    private static int E(e eVar) {
        bk cCi;
        if (eVar != null && (cCi = eVar.cCi()) != null) {
            if (cCi.aQz()) {
                return 4;
            }
            if (cCi.aQu() == 1) {
                return 3;
            }
            if (cCi.aPm()) {
                return 5;
            }
            if (cCi.aPn()) {
                return 6;
            }
            if (cCi.aSv()) {
                return 7;
            }
            if (cCi.aSw()) {
                return 8;
            }
            return cCi.aRQ() ? 2 : 1;
        }
        return 0;
    }
}
