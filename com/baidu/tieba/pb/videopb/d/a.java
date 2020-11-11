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
        String dlx;
        String str;
        String str2;
        if (pbActivity != null && pbActivity.djz() != null) {
            final PbModel djz = pbActivity.djz();
            final View rootView = pbActivity.getRootView();
            if (djz.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                f pbData = djz.getPbData();
                String title = pbData.dik().getTitle();
                int i3 = djz.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Sb(pbData.getForumId())) {
                        z = true;
                    }
                }
                bw dik = djz.getPbData().dik();
                if (dik.blk()) {
                    dlx = dik.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + dik.getBaijiahaoData().oriUgcType + "&dvid=" + dik.getBaijiahaoData().oriUgcVid + "&nid=" + dik.getBaijiahaoData().oriUgcNid;
                } else {
                    dlx = djz.dlx();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + dlx + (str + "&share_from=post");
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
                if (pbData.diN() && dik.bmA() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5) || dik.bow() || dik.blj()) {
                        str2 = TextUtils.isEmpty(title) ? fJ[1] : title;
                        title = MessageFormat.format(string, dik.bmA().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
                if (pbData.diN()) {
                    shareItem.fgU = cutString2;
                    shareItem.readCount = -1L;
                } else if (pbData.dik() != null && pbData.dik().bmS() != null && !pbData.dik().blk()) {
                    shareItem.readCount = pbData.dik().bmS().play_count.intValue();
                }
                shareItem.linkUrl = str3;
                shareItem.fgG = true;
                shareItem.fgP = z;
                shareItem.extData = djz.dlx();
                shareItem.fgX = 3;
                shareItem.fgW = i2;
                shareItem.fid = djz.getForumId();
                shareItem.tid = djz.dlx();
                shareItem.fhb = F(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.diN()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.fhe = OriginalThreadInfo.ShareInfo.generateShareInfo(dik);
                if (pbData != null && pbData.dim() != null && pbData.dim().size() > 0) {
                    shareItem.fhf = ShareItem.ForwardInfo.generateForwardInfo(dik, 1, pbData.dim().get(0));
                } else {
                    shareItem.fhf = ShareItem.ForwardInfo.generateForwardInfo(dik, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (dik != null) {
                    shareItem.fhl = dik.getShareImageUrl();
                }
                shareItem.fgY = getShareObjParam2(dik);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.fgX);
                bundle.putInt("obj_type", shareItem.fhb);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.videopb.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().diK() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.f.cpv().b(shareDialogConfig);
            }
        }
    }

    private static int getShareObjParam2(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.bli()) {
            return 10;
        }
        if (bwVar.blj()) {
            return 9;
        }
        if (bwVar.bow()) {
            return 8;
        }
        if (bwVar.bov()) {
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
        bw dik;
        if (fVar != null && (dik = fVar.dik()) != null) {
            if (dik.bmC()) {
                return 4;
            }
            if (dik.bmx() == 1) {
                return 3;
            }
            if (dik.bli()) {
                return 5;
            }
            if (dik.blj()) {
                return 6;
            }
            if (dik.bov()) {
                return 7;
            }
            if (dik.bow()) {
                return 8;
            }
            return dik.bnS() ? 2 : 1;
        }
        return 0;
    }
}
