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
        String cYB;
        String str;
        String str2;
        if (pbActivity != null && pbActivity.cWD() != null) {
            final PbModel cWD = pbActivity.cWD();
            final View rootView = pbActivity.getRootView();
            if (cWD.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                f pbData = cWD.getPbData();
                String title = pbData.cVl().getTitle();
                int i3 = cWD.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.PX(pbData.getForumId())) {
                        z = true;
                    }
                }
                bw cVl = cWD.getPbData().cVl();
                if (cVl.bdo()) {
                    cYB = cVl.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + cVl.getBaijiahaoData().oriUgcType + "&dvid=" + cVl.getBaijiahaoData().oriUgcVid + "&nid=" + cVl.getBaijiahaoData().oriUgcNid;
                } else {
                    cYB = cWD.cYB();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + cYB + str;
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
                if (pbData.cVO() && cVl.beE() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5) || cVl.bgA() || cVl.bdn()) {
                        str2 = TextUtils.isEmpty(title) ? fv[1] : title;
                        title = MessageFormat.format(string, cVl.beE().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
                if (pbData.cVO()) {
                    shareItem.eEq = cutString2;
                    shareItem.readCount = -1L;
                } else if (pbData.cVl() != null && pbData.cVl().beW() != null && !pbData.cVl().bdo()) {
                    shareItem.readCount = pbData.cVl().beW().play_count.intValue();
                }
                shareItem.linkUrl = str3;
                shareItem.eEc = true;
                shareItem.eEl = z;
                shareItem.extData = cWD.cYB();
                shareItem.eEt = 3;
                shareItem.eEs = i2;
                shareItem.fid = cWD.getForumId();
                shareItem.tid = cWD.cYB();
                shareItem.eEx = F(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.cVO()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.eEA = OriginalThreadInfo.ShareInfo.generateShareInfo(cVl);
                if (pbData != null && pbData.cVn() != null && pbData.cVn().size() > 0) {
                    shareItem.eEB = ShareItem.ForwardInfo.generateForwardInfo(cVl, 1, pbData.cVn().get(0));
                } else {
                    shareItem.eEB = ShareItem.ForwardInfo.generateForwardInfo(cVl, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (cVl != null) {
                    shareItem.eEH = cVl.getShareImageUrl();
                }
                shareItem.eEu = getShareObjParam2(cVl);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.eEt);
                bundle.putInt("obj_type", shareItem.eEx);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.videopb.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().cVL() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.f.cdb().b(shareDialogConfig);
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
        bw cVl;
        if (fVar != null && (cVl = fVar.cVl()) != null) {
            if (cVl.beG()) {
                return 4;
            }
            if (cVl.beB() == 1) {
                return 3;
            }
            if (cVl.bdm()) {
                return 5;
            }
            if (cVl.bdn()) {
                return 6;
            }
            if (cVl.bgz()) {
                return 7;
            }
            if (cVl.bgA()) {
                return 8;
            }
            return cVl.bfW() ? 2 : 1;
        }
        return 0;
    }
}
