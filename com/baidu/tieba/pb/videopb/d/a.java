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
        String diV;
        String str;
        String str2;
        if (pbActivity != null && pbActivity.dgX() != null) {
            final PbModel dgX = pbActivity.dgX();
            final View rootView = pbActivity.getRootView();
            if (dgX.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                f pbData = dgX.getPbData();
                String title = pbData.dfI().getTitle();
                int i3 = dgX.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.RK(pbData.getForumId())) {
                        z = true;
                    }
                }
                bw dfI = dgX.getPbData().dfI();
                if (dfI.biK()) {
                    diV = dfI.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + dfI.getBaijiahaoData().oriUgcType + "&dvid=" + dfI.getBaijiahaoData().oriUgcVid + "&nid=" + dfI.getBaijiahaoData().oriUgcNid;
                } else {
                    diV = dgX.diV();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + diV + (str + "&share_from=post");
                String[] fJ = pbData.fJ(pbActivity);
                String str4 = fJ[0];
                if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str4 == null ? null : Uri.parse(str4);
                String str5 = fJ[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new aq("c10399").dR("fid", pbData.getForumId()).dR("tid", pbData.getThreadId()).dR("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.dgl() && dfI.bka() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5) || dfI.blW() || dfI.biJ()) {
                        str2 = TextUtils.isEmpty(title) ? fJ[1] : title;
                        title = MessageFormat.format(string, dfI.bka().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
                if (pbData.dgl()) {
                    shareItem.fbd = cutString2;
                    shareItem.readCount = -1L;
                } else if (pbData.dfI() != null && pbData.dfI().bks() != null && !pbData.dfI().biK()) {
                    shareItem.readCount = pbData.dfI().bks().play_count.intValue();
                }
                shareItem.linkUrl = str3;
                shareItem.faP = true;
                shareItem.faY = z;
                shareItem.extData = dgX.diV();
                shareItem.fbg = 3;
                shareItem.fbf = i2;
                shareItem.fid = dgX.getForumId();
                shareItem.tid = dgX.diV();
                shareItem.fbk = F(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.dgl()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.fbn = OriginalThreadInfo.ShareInfo.generateShareInfo(dfI);
                if (pbData != null && pbData.dfK() != null && pbData.dfK().size() > 0) {
                    shareItem.fbo = ShareItem.ForwardInfo.generateForwardInfo(dfI, 1, pbData.dfK().get(0));
                } else {
                    shareItem.fbo = ShareItem.ForwardInfo.generateForwardInfo(dfI, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (dfI != null) {
                    shareItem.fbu = dfI.getShareImageUrl();
                }
                shareItem.fbh = getShareObjParam2(dfI);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.fbg);
                bundle.putInt("obj_type", shareItem.fbk);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.videopb.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().dgi() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.f.cmU().b(shareDialogConfig);
            }
        }
    }

    private static int getShareObjParam2(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.biI()) {
            return 10;
        }
        if (bwVar.biJ()) {
            return 9;
        }
        if (bwVar.blW()) {
            return 8;
        }
        if (bwVar.blV()) {
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
        bw dfI;
        if (fVar != null && (dfI = fVar.dfI()) != null) {
            if (dfI.bkc()) {
                return 4;
            }
            if (dfI.bjX() == 1) {
                return 3;
            }
            if (dfI.biI()) {
                return 5;
            }
            if (dfI.biJ()) {
                return 6;
            }
            if (dfI.blV()) {
                return 7;
            }
            if (dfI.blW()) {
                return 8;
            }
            return dfI.bls() ? 2 : 1;
        }
        return 0;
    }
}
