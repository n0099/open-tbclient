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
        String doJ;
        String str;
        String str2;
        String str3;
        if (pbActivity != null && pbActivity.dmG() != null) {
            final PbModel dmG = pbActivity.dmG();
            final View rootView = pbActivity.getRootView();
            if (dmG.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                f pbData = dmG.getPbData();
                String title = pbData.dlp().getTitle();
                int i3 = dmG.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.SG(pbData.getForumId())) {
                        z = true;
                    }
                }
                cb dlp = dmG.getPbData().dlp();
                if (dlp.bmB()) {
                    doJ = dlp.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + dlp.getBaijiahaoData().oriUgcType + "&dvid=" + dlp.getBaijiahaoData().oriUgcVid + "&nid=" + dlp.getBaijiahaoData().oriUgcNid;
                } else {
                    doJ = dmG.doJ();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str4 = "http://tieba.baidu.com/p/" + doJ + (str + "&share_from=post");
                String[] gK = pbData.gK(pbActivity);
                String str5 = gK[0];
                if (!StringUtils.isNull(str5) && str5.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str5 = str5.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str5 == null ? null : Uri.parse(str5);
                String str6 = gK[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new ar("c10399").dR("fid", pbData.getForumId()).dR("tid", pbData.getThreadId()).dR("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.dlS() && dlp.bnS() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str6) || dlp.bpQ() || dlp.bmA()) {
                        String str7 = TextUtils.isEmpty(title) ? gK[1] : title;
                        str2 = MessageFormat.format(string, dlp.bnS().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
                if (pbData.dlS()) {
                    shareItem.fwu = cutString2;
                    shareItem.readCount = -1L;
                } else if (pbData.dlp() != null && pbData.dlp().boj() != null && !pbData.dlp().bmB()) {
                    shareItem.readCount = pbData.dlp().boj().play_count.intValue();
                }
                shareItem.linkUrl = str4;
                shareItem.fwg = true;
                shareItem.fwp = z;
                shareItem.extData = dmG.doJ();
                shareItem.fwx = 3;
                shareItem.fww = i2;
                shareItem.fid = dmG.getForumId();
                shareItem.tid = dmG.doJ();
                shareItem.fwB = I(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.dlS()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.fwE = OriginalThreadInfo.ShareInfo.generateShareInfo(dlp);
                if (pbData != null && pbData.dlr() != null && pbData.dlr().size() > 0) {
                    shareItem.fwF = ShareItem.ForwardInfo.generateForwardInfo(dlp, 1, pbData.dlr().get(0));
                } else {
                    shareItem.fwF = ShareItem.ForwardInfo.generateForwardInfo(dlp, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (dlp != null) {
                    shareItem.fwL = dlp.getShareImageUrl();
                }
                shareItem.fwy = getShareObjParam2(dlp);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.fwx);
                bundle.putInt("obj_type", shareItem.fwB);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.videopb.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().dlP() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.f.ctM().b(shareDialogConfig);
            }
        }
    }

    private static int getShareObjParam2(cb cbVar) {
        if (cbVar == null) {
            return 0;
        }
        if (cbVar.bmz()) {
            return 10;
        }
        if (cbVar.bmA()) {
            return 9;
        }
        if (cbVar.bpQ()) {
            return 8;
        }
        if (cbVar.bpP()) {
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
        cb dlp;
        if (fVar != null && (dlp = fVar.dlp()) != null) {
            if (dlp.bnU()) {
                return 4;
            }
            if (dlp.bnP() == 1) {
                return 3;
            }
            if (dlp.bmz()) {
                return 5;
            }
            if (dlp.bmA()) {
                return 6;
            }
            if (dlp.bpP()) {
                return 7;
            }
            if (dlp.bpQ()) {
                return 8;
            }
            return dlp.bpm() ? 2 : 1;
        }
        return 0;
    }
}
