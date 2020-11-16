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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
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
        String dkU;
        String str;
        String str2;
        if (pbActivity != null && pbActivity.diV() != null) {
            final PbModel diV = pbActivity.diV();
            final View rootView = pbActivity.getRootView();
            if (diV.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                f pbData = diV.getPbData();
                String title = pbData.dhH().getTitle();
                int i3 = diV.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.RC(pbData.getForumId())) {
                        z = true;
                    }
                }
                bx dhH = diV.getPbData().dhH();
                if (dhH.bkm()) {
                    dkU = dhH.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + dhH.getBaijiahaoData().oriUgcType + "&dvid=" + dhH.getBaijiahaoData().oriUgcVid + "&nid=" + dhH.getBaijiahaoData().oriUgcNid;
                } else {
                    dkU = diV.dkU();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + dkU + (str + "&share_from=post");
                String[] fI = pbData.fI(pbActivity);
                String str4 = fI[0];
                if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str4 == null ? null : Uri.parse(str4);
                String str5 = fI[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new ar("c10399").dR("fid", pbData.getForumId()).dR("tid", pbData.getThreadId()).dR("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.dik() && dhH.blC() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5) || dhH.bnA() || dhH.bkl()) {
                        str2 = TextUtils.isEmpty(title) ? fI[1] : title;
                        title = MessageFormat.format(string, dhH.blC().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                    } else {
                        str2 = title;
                        title = str5;
                    }
                } else if (au.isEmpty(str5)) {
                    str2 = title;
                } else {
                    str2 = title;
                    title = str5;
                }
                String cutString = au.cutString(str2, 100);
                String cutString2 = au.cutString(title, 100);
                ShareItem shareItem = new ShareItem();
                shareItem.title = cutString;
                shareItem.content = cutString2;
                if (pbData.dik()) {
                    shareItem.fgc = cutString2;
                    shareItem.readCount = -1L;
                } else if (pbData.dhH() != null && pbData.dhH().blU() != null && !pbData.dhH().bkm()) {
                    shareItem.readCount = pbData.dhH().blU().play_count.intValue();
                }
                shareItem.linkUrl = str3;
                shareItem.ffO = true;
                shareItem.ffX = z;
                shareItem.extData = diV.dkU();
                shareItem.fgf = 3;
                shareItem.fge = i2;
                shareItem.fid = diV.getForumId();
                shareItem.tid = diV.dkU();
                shareItem.fgj = H(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.dik()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.fgm = OriginalThreadInfo.ShareInfo.generateShareInfo(dhH);
                if (pbData != null && pbData.dhJ() != null && pbData.dhJ().size() > 0) {
                    shareItem.fgn = ShareItem.ForwardInfo.generateForwardInfo(dhH, 1, pbData.dhJ().get(0));
                } else {
                    shareItem.fgn = ShareItem.ForwardInfo.generateForwardInfo(dhH, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (dhH != null) {
                    shareItem.fgt = dhH.getShareImageUrl();
                }
                shareItem.fgg = getShareObjParam2(dhH);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.fgf);
                bundle.putInt("obj_type", shareItem.fgj);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.videopb.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().dih() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.d.f.coW().b(shareDialogConfig);
            }
        }
    }

    private static int getShareObjParam2(bx bxVar) {
        if (bxVar == null) {
            return 0;
        }
        if (bxVar.bkk()) {
            return 10;
        }
        if (bxVar.bkl()) {
            return 9;
        }
        if (bxVar.bnA()) {
            return 8;
        }
        if (bxVar.bnz()) {
            return 7;
        }
        if (bxVar.isShareThread) {
            return 6;
        }
        if (bxVar.threadType == 0) {
            return 1;
        }
        if (bxVar.threadType == 40) {
            return 2;
        }
        if (bxVar.threadType == 49) {
            return 3;
        }
        if (bxVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    private static int H(f fVar) {
        bx dhH;
        if (fVar != null && (dhH = fVar.dhH()) != null) {
            if (dhH.blE()) {
                return 4;
            }
            if (dhH.blz() == 1) {
                return 3;
            }
            if (dhH.bkk()) {
                return 5;
            }
            if (dhH.bkl()) {
                return 6;
            }
            if (dhH.bnz()) {
                return 7;
            }
            if (dhH.bnA()) {
                return 8;
            }
            return dhH.bmW() ? 2 : 1;
        }
        return 0;
    }
}
