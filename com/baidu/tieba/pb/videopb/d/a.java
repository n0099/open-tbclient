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
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes22.dex */
public class a {
    public static void a(final PbActivity pbActivity, int i, int i2) {
        String dqj;
        String str;
        String str2;
        if (pbActivity != null && pbActivity.dok() != null) {
            final PbModel dok = pbActivity.dok();
            final View rootView = pbActivity.getRootView();
            if (dok.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                f pbData = dok.getPbData();
                String title = pbData.dmT().getTitle();
                int i3 = dok.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.SQ(pbData.getForumId())) {
                        z = true;
                    }
                }
                by dmT = dok.getPbData().dmT();
                if (dmT.bnz()) {
                    dqj = dmT.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + dmT.getBaijiahaoData().oriUgcType + "&dvid=" + dmT.getBaijiahaoData().oriUgcVid + "&nid=" + dmT.getBaijiahaoData().oriUgcNid;
                } else {
                    dqj = dok.dqj();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + dqj + (str + "&share_from=post");
                String[] gr = pbData.gr(pbActivity);
                String str4 = gr[0];
                if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str4 == null ? null : Uri.parse(str4);
                String str5 = gr[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new ar("c10399").dY("fid", pbData.getForumId()).dY("tid", pbData.getThreadId()).dY("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.dnx() && dmT.boP() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5) || dmT.bqN() || dmT.bny()) {
                        str2 = TextUtils.isEmpty(title) ? gr[1] : title;
                        title = MessageFormat.format(string, dmT.boP().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                    } else {
                        str2 = title;
                        title = str5;
                    }
                } else if (au.isEmpty(str5)) {
                    str2 = title;
                } else {
                    str2 = title;
                    title = str5;
                }
                String cutString = au.cutString(str2, 100);
                String cutString2 = au.cutString(title, 100);
                ShareItem shareItem = new ShareItem();
                shareItem.title = cutString;
                shareItem.content = cutString2;
                if (pbData.dnx()) {
                    shareItem.fnC = cutString2;
                    shareItem.readCount = -1L;
                } else if (pbData.dmT() != null && pbData.dmT().bph() != null && !pbData.dmT().bnz()) {
                    shareItem.readCount = pbData.dmT().bph().play_count.intValue();
                }
                shareItem.linkUrl = str3;
                shareItem.fno = true;
                shareItem.fnx = z;
                shareItem.extData = dok.dqj();
                shareItem.fnF = 3;
                shareItem.fnE = i2;
                shareItem.fid = dok.getForumId();
                shareItem.tid = dok.dqj();
                shareItem.fnJ = I(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.dnx()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.fnM = OriginalThreadInfo.ShareInfo.generateShareInfo(dmT);
                if (pbData != null && pbData.dmV() != null && pbData.dmV().size() > 0) {
                    shareItem.fnN = ShareItem.ForwardInfo.generateForwardInfo(dmT, 1, pbData.dmV().get(0));
                } else {
                    shareItem.fnN = ShareItem.ForwardInfo.generateForwardInfo(dmT, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (dmT != null) {
                    shareItem.fnT = dmT.getShareImageUrl();
                }
                shareItem.fnG = getShareObjParam2(dmT);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.fnF);
                bundle.putInt("obj_type", shareItem.fnJ);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.videopb.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().dnu() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.d.f.ctk().b(shareDialogConfig);
            }
        }
    }

    private static int getShareObjParam2(by byVar) {
        if (byVar == null) {
            return 0;
        }
        if (byVar.bnx()) {
            return 10;
        }
        if (byVar.bny()) {
            return 9;
        }
        if (byVar.bqN()) {
            return 8;
        }
        if (byVar.bqM()) {
            return 7;
        }
        if (byVar.isShareThread) {
            return 6;
        }
        if (byVar.threadType == 0) {
            return 1;
        }
        if (byVar.threadType == 40) {
            return 2;
        }
        if (byVar.threadType == 49) {
            return 3;
        }
        if (byVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    private static int I(f fVar) {
        by dmT;
        if (fVar != null && (dmT = fVar.dmT()) != null) {
            if (dmT.boR()) {
                return 4;
            }
            if (dmT.boM() == 1) {
                return 3;
            }
            if (dmT.bnx()) {
                return 5;
            }
            if (dmT.bny()) {
                return 6;
            }
            if (dmT.bqM()) {
                return 7;
            }
            if (dmT.bqN()) {
                return 8;
            }
            return dmT.bqj() ? 2 : 1;
        }
        return 0;
    }
}
