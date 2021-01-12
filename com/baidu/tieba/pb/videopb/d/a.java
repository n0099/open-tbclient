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
import com.baidu.tbadk.core.data.bz;
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
/* loaded from: classes2.dex */
public class a {
    public static void a(final PbActivity pbActivity, int i, int i2) {
        String dme;
        String str;
        String str2;
        String str3;
        if (pbActivity != null && pbActivity.dkd() != null) {
            final PbModel dkd = pbActivity.dkd();
            final View rootView = pbActivity.getRootView();
            if (dkd.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                f pbData = dkd.getPbData();
                String title = pbData.diN().getTitle();
                int i3 = dkd.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Rq(pbData.getForumId())) {
                        z = true;
                    }
                }
                bz diN = dkd.getPbData().diN();
                if (diN.bmg()) {
                    dme = diN.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + diN.getBaijiahaoData().oriUgcType + "&dvid=" + diN.getBaijiahaoData().oriUgcVid + "&nid=" + diN.getBaijiahaoData().oriUgcNid;
                } else {
                    dme = dkd.dme();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str4 = "http://tieba.baidu.com/p/" + dme + (str + "&share_from=post");
                String[] gI = pbData.gI(pbActivity);
                String str5 = gI[0];
                if (!StringUtils.isNull(str5) && str5.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str5 = str5.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str5 == null ? null : Uri.parse(str5);
                String str6 = gI[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new aq("c10399").dW("fid", pbData.getForumId()).dW("tid", pbData.getThreadId()).dW("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.djq() && diN.bnx() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str6) || diN.bpw() || diN.bmf()) {
                        String str7 = TextUtils.isEmpty(title) ? gI[1] : title;
                        str2 = MessageFormat.format(string, diN.bnx().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                        str3 = str7;
                    } else {
                        str2 = str6;
                        str3 = title;
                    }
                } else if (at.isEmpty(str6)) {
                    str2 = title;
                    str3 = title;
                } else {
                    str2 = str6;
                    str3 = title;
                }
                String cutString = at.cutString(str3, 100);
                String cutString2 = at.cutString(str2, 100);
                ShareItem shareItem = new ShareItem();
                shareItem.title = cutString;
                shareItem.content = cutString2;
                if (pbData.djq()) {
                    shareItem.fsD = cutString2;
                    shareItem.readCount = -1L;
                } else if (pbData.diN() != null && pbData.diN().bnO() != null && !pbData.diN().bmg()) {
                    shareItem.readCount = pbData.diN().bnO().play_count.intValue();
                }
                shareItem.linkUrl = str4;
                shareItem.fsp = true;
                shareItem.fsy = z;
                shareItem.extData = dkd.dme();
                shareItem.fsG = 3;
                shareItem.fsF = i2;
                shareItem.fid = dkd.getForumId();
                shareItem.tid = dkd.dme();
                shareItem.fsK = I(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.djq()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.fsN = OriginalThreadInfo.ShareInfo.generateShareInfo(diN);
                if (pbData != null && pbData.diP() != null && pbData.diP().size() > 0) {
                    shareItem.fsO = ShareItem.ForwardInfo.generateForwardInfo(diN, 1, pbData.diP().get(0));
                } else {
                    shareItem.fsO = ShareItem.ForwardInfo.generateForwardInfo(diN, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (diN != null) {
                    shareItem.fsU = diN.getShareImageUrl();
                }
                shareItem.fsH = getShareObjParam2(diN);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.fsG);
                bundle.putInt("obj_type", shareItem.fsK);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.videopb.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().djn() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.f.csn().b(shareDialogConfig);
            }
        }
    }

    private static int getShareObjParam2(bz bzVar) {
        if (bzVar == null) {
            return 0;
        }
        if (bzVar.bme()) {
            return 10;
        }
        if (bzVar.bmf()) {
            return 9;
        }
        if (bzVar.bpw()) {
            return 8;
        }
        if (bzVar.bpv()) {
            return 7;
        }
        if (bzVar.isShareThread) {
            return 6;
        }
        if (bzVar.threadType == 0) {
            return 1;
        }
        if (bzVar.threadType == 40) {
            return 2;
        }
        if (bzVar.threadType == 49) {
            return 3;
        }
        if (bzVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    private static int I(f fVar) {
        bz diN;
        if (fVar != null && (diN = fVar.diN()) != null) {
            if (diN.bnz()) {
                return 4;
            }
            if (diN.bnu() == 1) {
                return 3;
            }
            if (diN.bme()) {
                return 5;
            }
            if (diN.bmf()) {
                return 6;
            }
            if (diN.bpv()) {
                return 7;
            }
            if (diN.bpw()) {
                return 8;
            }
            return diN.boS() ? 2 : 1;
        }
        return 0;
    }
}
