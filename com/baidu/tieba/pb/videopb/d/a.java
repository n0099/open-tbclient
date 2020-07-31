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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
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
        String cNL;
        String str;
        String str2;
        if (pbActivity != null && pbActivity.cLP() != null) {
            final PbModel cLP = pbActivity.cLP();
            final View rootView = pbActivity.getRootView();
            if (cLP.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                f pbData = cLP.getPbData();
                String title = pbData.cKx().getTitle();
                int i3 = cLP.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.MZ(pbData.getForumId())) {
                        z = true;
                    }
                }
                bv cKx = cLP.getPbData().cKx();
                if (cKx.aUV()) {
                    cNL = cKx.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + cKx.getBaijiahaoData().oriUgcType + "&dvid=" + cKx.getBaijiahaoData().oriUgcVid + "&nid=" + cKx.getBaijiahaoData().oriUgcNid;
                } else {
                    cNL = cLP.cNL();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + cNL + str;
                String[] fi = pbData.fi(pbActivity);
                String str4 = fi[0];
                if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str4 == null ? null : Uri.parse(str4);
                String str5 = fi[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new ap("c10399").dn("fid", pbData.getForumId()).dn("tid", pbData.getThreadId()).dn("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.cLa() && cKx.aWl() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5) || cKx.aYh() || cKx.aUU()) {
                        str2 = TextUtils.isEmpty(title) ? fi[1] : title;
                        title = MessageFormat.format(string, cKx.aWl().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                    } else {
                        str2 = title;
                        title = str5;
                    }
                } else if (as.isEmpty(str5)) {
                    str2 = title;
                } else {
                    str2 = title;
                    title = str5;
                }
                String cutString = as.cutString(str2, 100);
                String cutString2 = as.cutString(title, 100);
                ShareItem shareItem = new ShareItem();
                shareItem.title = cutString;
                shareItem.content = cutString2;
                if (pbData.cLa()) {
                    shareItem.etQ = cutString2;
                    shareItem.readCount = -1L;
                } else if (pbData.cKx() != null && pbData.cKx().aWD() != null && !pbData.cKx().aUV()) {
                    shareItem.readCount = pbData.cKx().aWD().play_count.intValue();
                }
                shareItem.linkUrl = str3;
                shareItem.etE = true;
                shareItem.etL = z;
                shareItem.extData = cLP.cNL();
                shareItem.etT = 3;
                shareItem.etS = i2;
                shareItem.fid = cLP.getForumId();
                shareItem.tid = cLP.cNL();
                shareItem.etX = F(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.cLa()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.eua = OriginalThreadInfo.ShareInfo.generateShareInfo(cKx);
                if (pbData != null && pbData.cKz() != null && pbData.cKz().size() > 0) {
                    shareItem.eub = ShareItem.ForwardInfo.generateForwardInfo(cKx, 1, pbData.cKz().get(0));
                } else {
                    shareItem.eub = ShareItem.ForwardInfo.generateForwardInfo(cKx, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (cKx != null) {
                    shareItem.euh = cKx.getShareImageUrl();
                }
                shareItem.etU = getShareObjParam2(cKx);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.etT);
                bundle.putInt("obj_type", shareItem.etX);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.af(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.videopb.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().cKX() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.f.bSP().b(shareDialogConfig);
            }
        }
    }

    private static int getShareObjParam2(bv bvVar) {
        if (bvVar == null) {
            return 0;
        }
        if (bvVar.aUT()) {
            return 10;
        }
        if (bvVar.aUU()) {
            return 9;
        }
        if (bvVar.aYh()) {
            return 8;
        }
        if (bvVar.aYg()) {
            return 7;
        }
        if (bvVar.isShareThread) {
            return 6;
        }
        if (bvVar.threadType == 0) {
            return 1;
        }
        if (bvVar.threadType == 40) {
            return 2;
        }
        if (bvVar.threadType == 49) {
            return 3;
        }
        if (bvVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    private static int F(f fVar) {
        bv cKx;
        if (fVar != null && (cKx = fVar.cKx()) != null) {
            if (cKx.aWn()) {
                return 4;
            }
            if (cKx.aWi() == 1) {
                return 3;
            }
            if (cKx.aUT()) {
                return 5;
            }
            if (cKx.aUU()) {
                return 6;
            }
            if (cKx.aYg()) {
                return 7;
            }
            if (cKx.aYh()) {
                return 8;
            }
            return cKx.aXD() ? 2 : 1;
        }
        return 0;
    }
}
