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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.c.f;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.AddExperiencedModel;
import java.text.MessageFormat;
/* loaded from: classes9.dex */
public class a {
    public static void a(final PbActivity pbActivity, int i, int i2) {
        String cKa;
        String str;
        String str2;
        if (pbActivity != null && pbActivity.cIf() != null) {
            final PbModel cIf = pbActivity.cIf();
            final View rootView = pbActivity.getRootView();
            if (cIf.hasData()) {
                TiebaStatic.eventStat(pbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                e pbData = cIf.getPbData();
                String title = pbData.cGO().getTitle();
                int i3 = cIf.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Mr(pbData.getForumId())) {
                        z = true;
                    }
                }
                bu cGO = cIf.getPbData().cGO();
                if (cGO.aQZ()) {
                    cKa = cGO.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + cGO.getBaijiahaoData().oriUgcType + "&dvid=" + cGO.getBaijiahaoData().oriUgcVid + "&nid=" + cGO.getBaijiahaoData().oriUgcNid;
                } else {
                    cKa = cIf.cKa();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + cKa + str;
                String[] fe = pbData.fe(pbActivity);
                String str4 = fe[0];
                if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str4 == null ? null : Uri.parse(str4);
                String str5 = fe[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new ao("c10399").dk("fid", pbData.getForumId()).dk("tid", pbData.getThreadId()).dk("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.cHq() && cGO.aSp() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5) || cGO.aUm() || cGO.aQY()) {
                        str2 = TextUtils.isEmpty(title) ? fe[1] : title;
                        title = MessageFormat.format(string, cGO.aSp().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                    } else {
                        str2 = title;
                        title = str5;
                    }
                } else if (ar.isEmpty(str5)) {
                    str2 = title;
                } else {
                    str2 = title;
                    title = str5;
                }
                String cutString = ar.cutString(str2, 100);
                String cutString2 = ar.cutString(title, 100);
                ShareItem shareItem = new ShareItem();
                shareItem.title = cutString;
                shareItem.content = cutString2;
                if (pbData.cHq()) {
                    shareItem.enE = cutString2;
                    shareItem.readCount = -1L;
                } else if (pbData.cGO() != null && pbData.cGO().aSH() != null && !pbData.cGO().aQZ()) {
                    shareItem.readCount = pbData.cGO().aSH().play_count.intValue();
                }
                shareItem.linkUrl = str3;
                shareItem.enr = true;
                shareItem.enz = z;
                shareItem.extData = cIf.cKa();
                shareItem.enH = 3;
                shareItem.enG = i2;
                shareItem.fid = cIf.getForumId();
                shareItem.tid = cIf.cKa();
                shareItem.enL = F(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.cHq()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.enO = OriginalThreadInfo.ShareInfo.generateShareInfo(cGO);
                if (pbData != null && pbData.cGQ() != null && pbData.cGQ().size() > 0) {
                    shareItem.enP = ShareItem.ForwardInfo.generateForwardInfo(cGO, 1, pbData.cGQ().get(0));
                } else {
                    shareItem.enP = ShareItem.ForwardInfo.generateForwardInfo(cGO, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (cGO != null) {
                    shareItem.enV = cGO.getShareImageUrl();
                }
                shareItem.enI = z(cGO);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.enH);
                bundle.putInt("obj_type", shareItem.enL);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) pbActivity, shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.videopb.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().cHn() && !TbSingleton.getInstance().isNotchScreen(pbActivity) && !TbSingleton.getInstance().isCutoutScreen(pbActivity) && rootView != null) {
                            rootView.setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                f.bPE().b(shareDialogConfig);
            }
        }
    }

    private static int z(bu buVar) {
        if (buVar == null) {
            return 0;
        }
        if (buVar.aQX()) {
            return 10;
        }
        if (buVar.aQY()) {
            return 9;
        }
        if (buVar.aUm()) {
            return 8;
        }
        if (buVar.aUl()) {
            return 7;
        }
        if (buVar.isShareThread) {
            return 6;
        }
        if (buVar.threadType == 0) {
            return 1;
        }
        if (buVar.threadType == 40) {
            return 2;
        }
        if (buVar.threadType == 49) {
            return 3;
        }
        if (buVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    private static int F(e eVar) {
        bu cGO;
        if (eVar != null && (cGO = eVar.cGO()) != null) {
            if (cGO.aSr()) {
                return 4;
            }
            if (cGO.aSm() == 1) {
                return 3;
            }
            if (cGO.aQX()) {
                return 5;
            }
            if (cGO.aQY()) {
                return 6;
            }
            if (cGO.aUl()) {
                return 7;
            }
            if (cGO.aUm()) {
                return 8;
            }
            return cGO.aTH() ? 2 : 1;
        }
        return 0;
    }
}
