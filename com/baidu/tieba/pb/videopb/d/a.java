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
/* loaded from: classes22.dex */
public class a {
    public static void a(final PbActivity pbActivity, int i, int i2) {
        String dfO;
        String str;
        String str2;
        if (pbActivity != null && pbActivity.ddQ() != null) {
            final PbModel ddQ = pbActivity.ddQ();
            final View rootView = pbActivity.getRootView();
            if (ddQ.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                f pbData = ddQ.getPbData();
                String title = pbData.dcA().getTitle();
                int i3 = ddQ.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Rl(pbData.getForumId())) {
                        z = true;
                    }
                }
                bw dcA = ddQ.getPbData().dcA();
                if (dcA.bgR()) {
                    dfO = dcA.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + dcA.getBaijiahaoData().oriUgcType + "&dvid=" + dcA.getBaijiahaoData().oriUgcVid + "&nid=" + dcA.getBaijiahaoData().oriUgcNid;
                } else {
                    dfO = ddQ.dfO();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + dfO + (str + "&share_from=post");
                String[] fI = pbData.fI(pbActivity);
                String str4 = fI[0];
                if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str4 == null ? null : Uri.parse(str4);
                String str5 = fI[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new aq("c10399").dK("fid", pbData.getForumId()).dK("tid", pbData.getThreadId()).dK("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.ddd() && dcA.bih() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5) || dcA.bkd() || dcA.bgQ()) {
                        str2 = TextUtils.isEmpty(title) ? fI[1] : title;
                        title = MessageFormat.format(string, dcA.bih().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
                if (pbData.ddd()) {
                    shareItem.eSH = cutString2;
                    shareItem.readCount = -1L;
                } else if (pbData.dcA() != null && pbData.dcA().biz() != null && !pbData.dcA().bgR()) {
                    shareItem.readCount = pbData.dcA().biz().play_count.intValue();
                }
                shareItem.linkUrl = str3;
                shareItem.eSt = true;
                shareItem.eSC = z;
                shareItem.extData = ddQ.dfO();
                shareItem.eSK = 3;
                shareItem.eSJ = i2;
                shareItem.fid = ddQ.getForumId();
                shareItem.tid = ddQ.dfO();
                shareItem.eSO = F(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.ddd()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.eSR = OriginalThreadInfo.ShareInfo.generateShareInfo(dcA);
                if (pbData != null && pbData.dcC() != null && pbData.dcC().size() > 0) {
                    shareItem.eSS = ShareItem.ForwardInfo.generateForwardInfo(dcA, 1, pbData.dcC().get(0));
                } else {
                    shareItem.eSS = ShareItem.ForwardInfo.generateForwardInfo(dcA, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (dcA != null) {
                    shareItem.eSY = dcA.getShareImageUrl();
                }
                shareItem.eSL = getShareObjParam2(dcA);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.eSK);
                bundle.putInt("obj_type", shareItem.eSO);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.videopb.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().dda() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.f.cjN().b(shareDialogConfig);
            }
        }
    }

    private static int getShareObjParam2(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.bgP()) {
            return 10;
        }
        if (bwVar.bgQ()) {
            return 9;
        }
        if (bwVar.bkd()) {
            return 8;
        }
        if (bwVar.bkc()) {
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
        bw dcA;
        if (fVar != null && (dcA = fVar.dcA()) != null) {
            if (dcA.bij()) {
                return 4;
            }
            if (dcA.bie() == 1) {
                return 3;
            }
            if (dcA.bgP()) {
                return 5;
            }
            if (dcA.bgQ()) {
                return 6;
            }
            if (dcA.bkc()) {
                return 7;
            }
            if (dcA.bkd()) {
                return 8;
            }
            return dcA.bjz() ? 2 : 1;
        }
        return 0;
    }
}
