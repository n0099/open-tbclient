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
import com.baidu.tbadk.core.data.cb;
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
/* loaded from: classes2.dex */
public class a {
    public static void a(final PbActivity pbActivity, int i, int i2) {
        String dot;
        String str;
        String str2;
        String str3;
        if (pbActivity != null && pbActivity.dmq() != null) {
            final PbModel dmq = pbActivity.dmq();
            final View rootView = pbActivity.getRootView();
            if (dmq.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                f pbData = dmq.getPbData();
                String title = pbData.dkZ().getTitle();
                int i3 = dmq.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.So(pbData.getForumId())) {
                        z = true;
                    }
                }
                cb dkZ = dmq.getPbData().dkZ();
                if (dkZ.bmz()) {
                    dot = dkZ.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + dkZ.getBaijiahaoData().oriUgcType + "&dvid=" + dkZ.getBaijiahaoData().oriUgcVid + "&nid=" + dkZ.getBaijiahaoData().oriUgcNid;
                } else {
                    dot = dmq.dot();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str4 = "http://tieba.baidu.com/p/" + dot + (str + "&share_from=post");
                String[] gL = pbData.gL(pbActivity);
                String str5 = gL[0];
                if (!StringUtils.isNull(str5) && str5.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str5 = str5.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str5 == null ? null : Uri.parse(str5);
                String str6 = gL[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new ar("c10399").dR("fid", pbData.getForumId()).dR("tid", pbData.getThreadId()).dR("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.dlC() && dkZ.bnQ() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str6) || dkZ.bpO() || dkZ.bmy()) {
                        String str7 = TextUtils.isEmpty(title) ? gL[1] : title;
                        str2 = MessageFormat.format(string, dkZ.bnQ().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                        str3 = str7;
                    } else {
                        str2 = str6;
                        str3 = title;
                    }
                } else if (au.isEmpty(str6)) {
                    str2 = title;
                    str3 = title;
                } else {
                    str2 = str6;
                    str3 = title;
                }
                String cutString = au.cutString(str3, 100);
                String cutString2 = au.cutString(str2, 100);
                ShareItem shareItem = new ShareItem();
                shareItem.title = cutString;
                shareItem.content = cutString2;
                if (pbData.dlC()) {
                    shareItem.fuV = cutString2;
                    shareItem.readCount = -1L;
                } else if (pbData.dkZ() != null && pbData.dkZ().boh() != null && !pbData.dkZ().bmz()) {
                    shareItem.readCount = pbData.dkZ().boh().play_count.intValue();
                }
                shareItem.linkUrl = str4;
                shareItem.fuH = true;
                shareItem.fuQ = z;
                shareItem.extData = dmq.dot();
                shareItem.fuY = 3;
                shareItem.fuX = i2;
                shareItem.fid = dmq.getForumId();
                shareItem.tid = dmq.dot();
                shareItem.fvc = I(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.dlC()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.fvf = OriginalThreadInfo.ShareInfo.generateShareInfo(dkZ);
                if (pbData != null && pbData.dlb() != null && pbData.dlb().size() > 0) {
                    shareItem.fvg = ShareItem.ForwardInfo.generateForwardInfo(dkZ, 1, pbData.dlb().get(0));
                } else {
                    shareItem.fvg = ShareItem.ForwardInfo.generateForwardInfo(dkZ, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (dkZ != null) {
                    shareItem.fvm = dkZ.getShareImageUrl();
                }
                shareItem.fuZ = getShareObjParam2(dkZ);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.fuY);
                bundle.putInt("obj_type", shareItem.fvc);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.videopb.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().dlz() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.f.ctz().b(shareDialogConfig);
            }
        }
    }

    private static int getShareObjParam2(cb cbVar) {
        if (cbVar == null) {
            return 0;
        }
        if (cbVar.bmx()) {
            return 10;
        }
        if (cbVar.bmy()) {
            return 9;
        }
        if (cbVar.bpO()) {
            return 8;
        }
        if (cbVar.bpN()) {
            return 7;
        }
        if (cbVar.isShareThread) {
            return 6;
        }
        if (cbVar.threadType == 0) {
            return 1;
        }
        if (cbVar.threadType == 40) {
            return 2;
        }
        if (cbVar.threadType == 49) {
            return 3;
        }
        if (cbVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    private static int I(f fVar) {
        cb dkZ;
        if (fVar != null && (dkZ = fVar.dkZ()) != null) {
            if (dkZ.bnS()) {
                return 4;
            }
            if (dkZ.bnN() == 1) {
                return 3;
            }
            if (dkZ.bmx()) {
                return 5;
            }
            if (dkZ.bmy()) {
                return 6;
            }
            if (dkZ.bpN()) {
                return 7;
            }
            if (dkZ.bpO()) {
                return 8;
            }
            return dkZ.bpk() ? 2 : 1;
        }
        return 0;
    }
}
