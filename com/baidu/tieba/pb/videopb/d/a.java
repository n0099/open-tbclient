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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.AddExperiencedModel;
import java.text.MessageFormat;
/* loaded from: classes9.dex */
public class a {
    public static void a(final PbActivity pbActivity, int i, int i2) {
        String cyy;
        String str;
        String str2;
        if (pbActivity != null && pbActivity.cwB() != null) {
            final PbModel cwB = pbActivity.cwB();
            final View rootView = pbActivity.getRootView();
            if (cwB.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                e pbData = cwB.getPbData();
                String title = pbData.cvs().getTitle();
                int i3 = cwB.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Kd(pbData.getForumId())) {
                        z = true;
                    }
                }
                bj cvs = cwB.getPbData().cvs();
                if (cvs.aMy()) {
                    cyy = cvs.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + cvs.getBaijiahaoData().oriUgcType + "&dvid=" + cvs.getBaijiahaoData().oriUgcVid + "&nid=" + cvs.getBaijiahaoData().oriUgcNid;
                } else {
                    cyy = cwB.cyy();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + cyy + str;
                String[] eP = pbData.eP(pbActivity);
                String str4 = eP[0];
                if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str4 == null ? null : Uri.parse(str4);
                String str5 = eP[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new an("c10399").cI("fid", pbData.getForumId()).cI("tid", pbData.getThreadId()).cI("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.cvQ() && cvs.aKC() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5) || cvs.aMx() || cvs.aJs()) {
                        str2 = TextUtils.isEmpty(title) ? eP[1] : title;
                        title = MessageFormat.format(string, cvs.aKC().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                    } else {
                        str2 = title;
                        title = str5;
                    }
                } else if (aq.isEmpty(str5)) {
                    str2 = title;
                } else {
                    str2 = title;
                    title = str5;
                }
                String cutString = aq.cutString(str2, 100);
                String cutString2 = aq.cutString(title, 100);
                ShareItem shareItem = new ShareItem();
                shareItem.title = cutString;
                shareItem.content = cutString2;
                if (pbData.cvQ()) {
                    shareItem.dQA = cutString2;
                    shareItem.readCount = -1L;
                } else if (pbData.cvs() != null && pbData.cvs().aKT() != null && !pbData.cvs().aMy()) {
                    shareItem.readCount = pbData.cvs().aKT().play_count.intValue();
                }
                shareItem.linkUrl = str3;
                shareItem.dQn = true;
                shareItem.dQv = z;
                shareItem.extData = cwB.cyy();
                shareItem.dQD = 3;
                shareItem.dQC = i2;
                shareItem.fid = cwB.getForumId();
                shareItem.tid = cwB.cyy();
                shareItem.dQH = C(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.cvQ()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.dQK = OriginalThreadInfo.ShareInfo.generateShareInfo(cvs);
                if (pbData != null && pbData.cvu() != null && pbData.cvu().size() > 0) {
                    shareItem.dQL = ShareItem.ForwardInfo.generateForwardInfo(cvs, 1, pbData.cvu().get(0));
                } else {
                    shareItem.dQL = ShareItem.ForwardInfo.generateForwardInfo(cvs, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (cvs != null) {
                    shareItem.dQR = cvs.getShareImageUrl();
                }
                shareItem.dQE = y(cvs);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.dQD);
                bundle.putInt("obj_type", shareItem.dQH);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.Y(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.videopb.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().aQe() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.e.bGd().b(shareDialogConfig);
            }
        }
    }

    private static int y(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aJr()) {
            return 10;
        }
        if (bjVar.aJs()) {
            return 9;
        }
        if (bjVar.aMx()) {
            return 8;
        }
        if (bjVar.aMw()) {
            return 7;
        }
        if (bjVar.isShareThread) {
            return 6;
        }
        if (bjVar.threadType == 0) {
            return 1;
        }
        if (bjVar.threadType == 40) {
            return 2;
        }
        if (bjVar.threadType == 49) {
            return 3;
        }
        if (bjVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    private static int C(e eVar) {
        bj cvs;
        if (eVar != null && (cvs = eVar.cvs()) != null) {
            if (cvs.aKE()) {
                return 4;
            }
            if (cvs.aKz() == 1) {
                return 3;
            }
            if (cvs.aJr()) {
                return 5;
            }
            if (cvs.aJs()) {
                return 6;
            }
            if (cvs.aMw()) {
                return 7;
            }
            if (cvs.aMx()) {
                return 8;
            }
            return cvs.aLR() ? 2 : 1;
        }
        return 0;
    }
}
