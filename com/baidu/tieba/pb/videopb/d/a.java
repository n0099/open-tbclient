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
/* loaded from: classes16.dex */
public class a {
    public static void a(final PbActivity pbActivity, int i, int i2) {
        String cYC;
        String str;
        String str2;
        if (pbActivity != null && pbActivity.cWE() != null) {
            final PbModel cWE = pbActivity.cWE();
            final View rootView = pbActivity.getRootView();
            if (cWE.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                f pbData = cWE.getPbData();
                String title = pbData.cVm().getTitle();
                int i3 = cWE.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.PX(pbData.getForumId())) {
                        z = true;
                    }
                }
                bw cVm = cWE.getPbData().cVm();
                if (cVm.bdo()) {
                    cYC = cVm.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + cVm.getBaijiahaoData().oriUgcType + "&dvid=" + cVm.getBaijiahaoData().oriUgcVid + "&nid=" + cVm.getBaijiahaoData().oriUgcNid;
                } else {
                    cYC = cWE.cYC();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + cYC + str;
                String[] fv = pbData.fv(pbActivity);
                String str4 = fv[0];
                if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str4 == null ? null : Uri.parse(str4);
                String str5 = fv[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new aq("c10399").dD("fid", pbData.getForumId()).dD("tid", pbData.getThreadId()).dD("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.cVP() && cVm.beE() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5) || cVm.bgA() || cVm.bdn()) {
                        str2 = TextUtils.isEmpty(title) ? fv[1] : title;
                        title = MessageFormat.format(string, cVm.beE().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
                if (pbData.cVP()) {
                    shareItem.eEu = cutString2;
                    shareItem.readCount = -1L;
                } else if (pbData.cVm() != null && pbData.cVm().beW() != null && !pbData.cVm().bdo()) {
                    shareItem.readCount = pbData.cVm().beW().play_count.intValue();
                }
                shareItem.linkUrl = str3;
                shareItem.eEg = true;
                shareItem.eEp = z;
                shareItem.extData = cWE.cYC();
                shareItem.eEx = 3;
                shareItem.eEw = i2;
                shareItem.fid = cWE.getForumId();
                shareItem.tid = cWE.cYC();
                shareItem.eEB = F(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.cVP()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.eEE = OriginalThreadInfo.ShareInfo.generateShareInfo(cVm);
                if (pbData != null && pbData.cVo() != null && pbData.cVo().size() > 0) {
                    shareItem.eEF = ShareItem.ForwardInfo.generateForwardInfo(cVm, 1, pbData.cVo().get(0));
                } else {
                    shareItem.eEF = ShareItem.ForwardInfo.generateForwardInfo(cVm, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (cVm != null) {
                    shareItem.eEL = cVm.getShareImageUrl();
                }
                shareItem.eEy = getShareObjParam2(cVm);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.eEx);
                bundle.putInt("obj_type", shareItem.eEB);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.videopb.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().cVM() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.f.cdc().b(shareDialogConfig);
            }
        }
    }

    private static int getShareObjParam2(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.bdm()) {
            return 10;
        }
        if (bwVar.bdn()) {
            return 9;
        }
        if (bwVar.bgA()) {
            return 8;
        }
        if (bwVar.bgz()) {
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
        bw cVm;
        if (fVar != null && (cVm = fVar.cVm()) != null) {
            if (cVm.beG()) {
                return 4;
            }
            if (cVm.beB() == 1) {
                return 3;
            }
            if (cVm.bdm()) {
                return 5;
            }
            if (cVm.bdn()) {
                return 6;
            }
            if (cVm.bgz()) {
                return 7;
            }
            if (cVm.bgA()) {
                return 8;
            }
            return cVm.bfW() ? 2 : 1;
        }
        return 0;
    }
}
