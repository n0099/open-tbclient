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
        String dpX;
        String str;
        String str2;
        String str3;
        if (pbActivity != null && pbActivity.dnW() != null) {
            final PbModel dnW = pbActivity.dnW();
            final View rootView = pbActivity.getRootView();
            if (dnW.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                f pbData = dnW.getPbData();
                String title = pbData.dmF().getTitle();
                int i3 = dnW.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Sy(pbData.getForumId())) {
                        z = true;
                    }
                }
                bz dmF = dnW.getPbData().dmF();
                if (dmF.bqa()) {
                    dpX = dmF.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + dmF.getBaijiahaoData().oriUgcType + "&dvid=" + dmF.getBaijiahaoData().oriUgcVid + "&nid=" + dmF.getBaijiahaoData().oriUgcNid;
                } else {
                    dpX = dnW.dpX();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str4 = "http://tieba.baidu.com/p/" + dpX + (str + "&share_from=post");
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
                if (pbData.dni() && dmF.brr() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str6) || dmF.btq() || dmF.bpZ()) {
                        String str7 = TextUtils.isEmpty(title) ? gK[1] : title;
                        str2 = MessageFormat.format(string, dmF.brr().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
                if (pbData.dni()) {
                    shareItem.fxm = cutString2;
                    shareItem.readCount = -1L;
                } else if (pbData.dmF() != null && pbData.dmF().brI() != null && !pbData.dmF().bqa()) {
                    shareItem.readCount = pbData.dmF().brI().play_count.intValue();
                }
                shareItem.linkUrl = str4;
                shareItem.fwY = true;
                shareItem.fxh = z;
                shareItem.extData = dnW.dpX();
                shareItem.fxp = 3;
                shareItem.fxo = i2;
                shareItem.fid = dnW.getForumId();
                shareItem.tid = dnW.dpX();
                shareItem.fxt = I(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.dni()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.fxw = OriginalThreadInfo.ShareInfo.generateShareInfo(dmF);
                if (pbData != null && pbData.dmH() != null && pbData.dmH().size() > 0) {
                    shareItem.fxx = ShareItem.ForwardInfo.generateForwardInfo(dmF, 1, pbData.dmH().get(0));
                } else {
                    shareItem.fxx = ShareItem.ForwardInfo.generateForwardInfo(dmF, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (dmF != null) {
                    shareItem.fxD = dmF.getShareImageUrl();
                }
                shareItem.fxq = getShareObjParam2(dmF);
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
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().dnf() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.f.cwf().b(shareDialogConfig);
            }
        }
    }

    private static int getShareObjParam2(bz bzVar) {
        if (bzVar == null) {
            return 0;
        }
        if (bzVar.bpY()) {
            return 10;
        }
        if (bzVar.bpZ()) {
            return 9;
        }
        if (bzVar.btq()) {
            return 8;
        }
        if (bzVar.btp()) {
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
        bz dmF;
        if (fVar != null && (dmF = fVar.dmF()) != null) {
            if (dmF.brt()) {
                return 4;
            }
            if (dmF.bro() == 1) {
                return 3;
            }
            if (dmF.bpY()) {
                return 5;
            }
            if (dmF.bpZ()) {
                return 6;
            }
            if (dmF.btp()) {
                return 7;
            }
            if (dmF.btq()) {
                return 8;
            }
            return dmF.bsM() ? 2 : 1;
        }
        return 0;
    }
}
