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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.AddExperiencedModel;
import java.text.MessageFormat;
/* loaded from: classes21.dex */
public class a {
    public static void a(final PbActivity pbActivity, int i, int i2) {
        String dcf;
        String str;
        String str2;
        if (pbActivity != null && pbActivity.dah() != null) {
            final PbModel dah = pbActivity.dah();
            final View rootView = pbActivity.getRootView();
            if (dah.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                f pbData = dah.getPbData();
                String title = pbData.cYR().getTitle();
                int i3 = dah.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Qx(pbData.getForumId())) {
                        z = true;
                    }
                }
                bw cYR = dah.getPbData().cYR();
                if (cYR.bei()) {
                    dcf = cYR.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + cYR.getBaijiahaoData().oriUgcType + "&dvid=" + cYR.getBaijiahaoData().oriUgcVid + "&nid=" + cYR.getBaijiahaoData().oriUgcNid;
                } else {
                    dcf = dah.dcf();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + dcf + (str + "&share_from=post");
                String[] fB = pbData.fB(pbActivity);
                String str4 = fB[0];
                if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str4 == null ? null : Uri.parse(str4);
                String str5 = fB[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new aq("c10399").dF("fid", pbData.getForumId()).dF("tid", pbData.getThreadId()).dF("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.cZu() && cYR.bfy() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5) || cYR.bhu() || cYR.beh()) {
                        str2 = TextUtils.isEmpty(title) ? fB[1] : title;
                        title = MessageFormat.format(string, cYR.bfy().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                    } else {
                        str2 = title;
                        title = str5;
                    }
                } else if (at.isEmpty(str5)) {
                    str2 = title;
                } else {
                    str2 = title;
                    title = str5;
                }
                String cutString = at.cutString(str2, 100);
                String cutString2 = at.cutString(title, 100);
                ShareItem shareItem = new ShareItem();
                shareItem.title = cutString;
                shareItem.content = cutString2;
                if (pbData.cZu()) {
                    shareItem.eGA = cutString2;
                    shareItem.readCount = -1L;
                } else if (pbData.cYR() != null && pbData.cYR().bfQ() != null && !pbData.cYR().bei()) {
                    shareItem.readCount = pbData.cYR().bfQ().play_count.intValue();
                }
                shareItem.linkUrl = str3;
                shareItem.eGm = true;
                shareItem.eGv = z;
                shareItem.extData = dah.dcf();
                shareItem.eGD = 3;
                shareItem.eGC = i2;
                shareItem.fid = dah.getForumId();
                shareItem.tid = dah.dcf();
                shareItem.eGH = F(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.cZu()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.eGK = OriginalThreadInfo.ShareInfo.generateShareInfo(cYR);
                if (pbData != null && pbData.cYT() != null && pbData.cYT().size() > 0) {
                    shareItem.eGL = ShareItem.ForwardInfo.generateForwardInfo(cYR, 1, pbData.cYT().get(0));
                } else {
                    shareItem.eGL = ShareItem.ForwardInfo.generateForwardInfo(cYR, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (cYR != null) {
                    shareItem.eGR = cYR.getShareImageUrl();
                }
                shareItem.eGE = getShareObjParam2(cYR);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.eGD);
                bundle.putInt("obj_type", shareItem.eGH);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.videopb.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().cZr() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.f.cgr().b(shareDialogConfig);
            }
        }
    }

    private static int getShareObjParam2(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.beg()) {
            return 10;
        }
        if (bwVar.beh()) {
            return 9;
        }
        if (bwVar.bhu()) {
            return 8;
        }
        if (bwVar.bht()) {
            return 7;
        }
        if (bwVar.isShareThread) {
            return 6;
        }
        if (bwVar.threadType == 0) {
            return 1;
        }
        if (bwVar.threadType == 40) {
            return 2;
        }
        if (bwVar.threadType == 49) {
            return 3;
        }
        if (bwVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    private static int F(f fVar) {
        bw cYR;
        if (fVar != null && (cYR = fVar.cYR()) != null) {
            if (cYR.bfA()) {
                return 4;
            }
            if (cYR.bfv() == 1) {
                return 3;
            }
            if (cYR.beg()) {
                return 5;
            }
            if (cYR.beh()) {
                return 6;
            }
            if (cYR.bht()) {
                return 7;
            }
            if (cYR.bhu()) {
                return 8;
            }
            return cYR.bgQ() ? 2 : 1;
        }
        return 0;
    }
}
