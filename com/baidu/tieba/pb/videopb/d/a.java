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
        String dpW;
        String str;
        String str2;
        String str3;
        if (pbActivity != null && pbActivity.dnV() != null) {
            final PbModel dnV = pbActivity.dnV();
            final View rootView = pbActivity.getRootView();
            if (dnV.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                f pbData = dnV.getPbData();
                String title = pbData.dmE().getTitle();
                int i3 = dnV.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Sz(pbData.getForumId())) {
                        z = true;
                    }
                }
                bz dmE = dnV.getPbData().dmE();
                if (dmE.bpZ()) {
                    dpW = dmE.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + dmE.getBaijiahaoData().oriUgcType + "&dvid=" + dmE.getBaijiahaoData().oriUgcVid + "&nid=" + dmE.getBaijiahaoData().oriUgcNid;
                } else {
                    dpW = dnV.dpW();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str4 = "http://tieba.baidu.com/p/" + dpW + (str + "&share_from=post");
                String[] gK = pbData.gK(pbActivity);
                String str5 = gK[0];
                if (!StringUtils.isNull(str5) && str5.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str5 = str5.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str5 == null ? null : Uri.parse(str5);
                String str6 = gK[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new aq("c10399").dX("fid", pbData.getForumId()).dX("tid", pbData.getThreadId()).dX("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.dnh() && dmE.brq() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str6) || dmE.btp() || dmE.bpY()) {
                        String str7 = TextUtils.isEmpty(title) ? gK[1] : title;
                        str2 = MessageFormat.format(string, dmE.brq().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
                if (pbData.dnh()) {
                    shareItem.fxm = cutString2;
                    shareItem.readCount = -1L;
                } else if (pbData.dmE() != null && pbData.dmE().brH() != null && !pbData.dmE().bpZ()) {
                    shareItem.readCount = pbData.dmE().brH().play_count.intValue();
                }
                shareItem.linkUrl = str4;
                shareItem.fwY = true;
                shareItem.fxh = z;
                shareItem.extData = dnV.dpW();
                shareItem.fxp = 3;
                shareItem.fxo = i2;
                shareItem.fid = dnV.getForumId();
                shareItem.tid = dnV.dpW();
                shareItem.fxt = I(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.dnh()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.fxw = OriginalThreadInfo.ShareInfo.generateShareInfo(dmE);
                if (pbData != null && pbData.dmG() != null && pbData.dmG().size() > 0) {
                    shareItem.fxx = ShareItem.ForwardInfo.generateForwardInfo(dmE, 1, pbData.dmG().get(0));
                } else {
                    shareItem.fxx = ShareItem.ForwardInfo.generateForwardInfo(dmE, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (dmE != null) {
                    shareItem.fxD = dmE.getShareImageUrl();
                }
                shareItem.fxq = getShareObjParam2(dmE);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.fxp);
                bundle.putInt("obj_type", shareItem.fxt);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.videopb.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().dne() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.f.cwe().b(shareDialogConfig);
            }
        }
    }

    private static int getShareObjParam2(bz bzVar) {
        if (bzVar == null) {
            return 0;
        }
        if (bzVar.bpX()) {
            return 10;
        }
        if (bzVar.bpY()) {
            return 9;
        }
        if (bzVar.btp()) {
            return 8;
        }
        if (bzVar.bto()) {
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
        bz dmE;
        if (fVar != null && (dmE = fVar.dmE()) != null) {
            if (dmE.brs()) {
                return 4;
            }
            if (dmE.brn() == 1) {
                return 3;
            }
            if (dmE.bpX()) {
                return 5;
            }
            if (dmE.bpY()) {
                return 6;
            }
            if (dmE.bto()) {
                return 7;
            }
            if (dmE.btp()) {
                return 8;
            }
            return dmE.bsL() ? 2 : 1;
        }
        return 0;
    }
}
