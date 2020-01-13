package com.baidu.tieba.pb.videopb.d;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.c.e;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.AddExperiencedModel;
/* loaded from: classes7.dex */
public class a {
    public static void a(final PbActivity pbActivity, int i, int i2) {
        if (pbActivity != null && pbActivity.ckc() != null) {
            final PbModel ckc = pbActivity.ckc();
            final View rootView = pbActivity.getRootView();
            if (ckc.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                f pbData = ckc.getPbData();
                if (pbData.cjs() && !TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(pbActivity);
                    return;
                }
                String title = pbData.ciS().getTitle();
                int i3 = ckc.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Ii(pbData.getForumId())) {
                        z = true;
                    }
                }
                String str = "http://tieba.baidu.com/p/" + ckc.cmc() + "?share=9105&fr=share&see_lz=" + i3;
                String[] fg = pbData.fg(pbActivity);
                String str2 = fg[0];
                if (!StringUtils.isNull(str2) && str2.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str2 = str2.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str2 == null ? null : Uri.parse(str2);
                String str3 = fg[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new an("c10399").cp("fid", pbData.getForumId()).cp("tid", pbData.getThreadId()).cp("uid", currentAccount));
                }
                if (aq.isEmpty(str3)) {
                    str3 = title;
                }
                ShareItem shareItem = new ShareItem();
                shareItem.title = title;
                shareItem.content = str3;
                shareItem.linkUrl = str;
                shareItem.dlG = true;
                shareItem.dlN = z;
                shareItem.extData = ckc.cmc();
                shareItem.dlV = 3;
                shareItem.dlU = i2;
                shareItem.fid = ckc.getForumId();
                shareItem.tid = ckc.cmc();
                shareItem.dlZ = B(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.cjs()) {
                    shareItem.dmf = false;
                    shareItem.canShareBySmartApp = false;
                }
                bj ciS = ckc.getPbData().ciS();
                shareItem.dmc = OriginalThreadInfo.ShareInfo.generateShareInfo(ciS);
                if (pbData != null && pbData.ciU() != null && pbData.ciU().size() > 0) {
                    shareItem.dmd = ShareItem.ForwardInfo.generateForwardInfo(ciS, 1, pbData.ciU().get(0));
                } else {
                    shareItem.dmd = ShareItem.ForwardInfo.generateForwardInfo(ciS, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (ciS != null) {
                    shareItem.dmj = ciS.getShareImageUrl();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.dlV);
                bundle.putInt("obj_type", shareItem.dlZ);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.Y(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.videopb.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().cjp() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                e.buG().b(shareDialogConfig);
            }
        }
    }

    private static int B(f fVar) {
        bj ciS;
        if (fVar != null && (ciS = fVar.ciS()) != null) {
            if (ciS.azZ()) {
                return 4;
            }
            if (ciS.azU() == 1) {
                return 3;
            }
            if (ciS.aBm()) {
                return 2;
            }
            if (ciS.ayL()) {
                return 5;
            }
            if (ciS.aBS()) {
                return 6;
            }
            if (ciS.aBT()) {
                return 7;
            }
            return ciS.aBU() ? 8 : 1;
        }
        return 0;
    }
}
