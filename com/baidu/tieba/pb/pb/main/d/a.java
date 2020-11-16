package com.baidu.tieba.pb.pb.main.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.d.f;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.az;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.Thread2GroupShareView;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class a {
    public static void a(Context context, bx bxVar, int i) {
        if (bxVar != null && context != null) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i, c(context, bxVar), true));
        }
    }

    private static ShareItem c(Context context, bx bxVar) {
        if (bxVar == null || context == null) {
            return null;
        }
        String valueOf = String.valueOf(bxVar.getFid());
        String blG = bxVar.blG();
        if (bxVar.eEQ != null) {
            valueOf = bxVar.eEQ.id;
            blG = bxVar.eEQ.ori_fname;
        }
        String title = bxVar.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = bxVar.getAbstract();
        }
        String tid = bxVar.getTid();
        String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
        String shareImageUrl = getShareImageUrl(bxVar);
        Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
        String str2 = bxVar.getAbstract();
        String format = MessageFormat.format(context.getResources().getString(R.string.share_content_tpl), title, str2);
        ShareItem shareItem = new ShareItem();
        shareItem.title = title;
        shareItem.content = format;
        shareItem.readCount = bxVar.blu();
        shareItem.fgc = str2;
        shareItem.linkUrl = str;
        shareItem.eFG = 2;
        shareItem.extData = tid;
        shareItem.fgf = 3;
        shareItem.fid = valueOf;
        shareItem.fName = blG;
        shareItem.tid = tid;
        shareItem.ffR = true;
        shareItem.fge = 6;
        shareItem.fgj = getStateThreadType(bxVar);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.fgm = OriginalThreadInfo.ShareInfo.generateShareInfo(bxVar);
        shareItem.fgn = ShareItem.ForwardInfo.generateForwardInfo(bxVar, 1, null);
        shareItem.fgt = bxVar.getShareImageUrl();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.fgf);
        bundle.putInt("obj_type", shareItem.fgj);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putInt("obj_source", shareItem.eFG);
        shareItem.ae(bundle);
        return shareItem;
    }

    private static String getShareImageUrl(bx bxVar) {
        String str;
        if (bxVar == null || bxVar.blL() == null) {
            return null;
        }
        ArrayList<MediaData> blL = bxVar.blL();
        int size = blL.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = blL.get(i);
            if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                    str = mediaData.getThumbnails_url();
                    break;
                } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                    str = mediaData.getPicUrl();
                    break;
                }
            }
            i++;
        }
        if (str == null && bxVar.blU() != null && !TextUtils.isEmpty(bxVar.blU().thumbnail_url)) {
            return bxVar.blU().thumbnail_url;
        }
        return str;
    }

    private static int getStateThreadType(bx bxVar) {
        if (bxVar != null) {
            if (bxVar.blE()) {
                return 4;
            }
            if (bxVar.blz() == 1) {
                return 3;
            }
            return bxVar.bmW() ? 2 : 1;
        }
        return 0;
    }

    public static void a(final PbFragment pbFragment, int i, int i2) {
        if (pbFragment != null && pbFragment.diV() != null && pbFragment.djM() != null) {
            final PbModel diV = pbFragment.diV();
            final az djM = pbFragment.djM();
            if (diV.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                ShareItem a2 = a(pbFragment.getContext(), i, i2, diV);
                TbadkCoreApplication.getInst().setShareItem(a2);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), a2, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().dih() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            djM.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                shareDialogConfig.shareItem.ae(bundle);
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                f.coW().b(shareDialogConfig);
            }
        }
    }

    public static ShareItem a(Context context, int i, int i2, PbModel pbModel) {
        String dkU;
        String str;
        String str2;
        com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
        String title = pbData.dhH().getTitle();
        int i3 = pbModel.getHostMode() ? 1 : 0;
        boolean z = false;
        if (pbData.getForum() != null) {
            if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.RC(pbData.getForumId())) {
                z = true;
            }
        }
        bx dhH = pbModel.getPbData().dhH();
        if (dhH.bkm()) {
            dkU = dhH.getBaijiahaoData().oriUgcTid;
            str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + dhH.getBaijiahaoData().oriUgcType + "&dvid=" + dhH.getBaijiahaoData().oriUgcVid + "&nid=" + dhH.getBaijiahaoData().oriUgcNid;
        } else {
            dkU = pbModel.dkU();
            str = "?share=9105&fr=share&see_lz=" + i3;
        }
        String str3 = "http://tieba.baidu.com/p/" + dkU + (str + "&share_from=post");
        String[] fI = pbData.fI(context);
        String str4 = fI[0];
        if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
            str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
        }
        Uri parse = str4 == null ? null : Uri.parse(str4);
        String str5 = fI[1];
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (i == 1) {
            TiebaStatic.log(new ar("c10399").dR("fid", pbData.getForumId()).dR("tid", pbData.getThreadId()).dR("uid", currentAccount));
        }
        String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
        if (pbData.dik() && dhH.blC() != null) {
            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                str2 = (TextUtils.isEmpty(title) || dhH.bnA() || dhH.bkl()) ? fI[1] : title;
                title = MessageFormat.format(string, dhH.blC().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
        if (pbData.dik()) {
            shareItem.fgc = cutString2;
            shareItem.readCount = -1L;
        } else {
            shareItem.readCount = pbData.dif();
        }
        shareItem.linkUrl = str3;
        shareItem.ffO = true;
        shareItem.ffX = z;
        shareItem.extData = pbModel.dkU();
        shareItem.fgf = 3;
        shareItem.fge = i2;
        shareItem.fgg = getShareObjParam2(dhH);
        shareItem.fid = pbModel.getForumId();
        shareItem.tid = pbModel.dkU();
        shareItem.fgj = H(pbData);
        shareItem.uid = TbadkCoreApplication.getCurrentAccount();
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        if (pbData.dik()) {
            shareItem.canShareBySmartApp = false;
        }
        shareItem.fgm = OriginalThreadInfo.ShareInfo.generateShareInfo(dhH);
        if (pbData != null && pbData.dhJ() != null && pbData.dhJ().size() > 0) {
            shareItem.fgn = ShareItem.ForwardInfo.generateForwardInfo(dhH, 1, pbData.dhJ().get(0));
        } else {
            shareItem.fgn = ShareItem.ForwardInfo.generateForwardInfo(dhH, 1, null);
        }
        if (dhH != null) {
            shareItem.fgt = dhH.getShareImageUrl();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.fgf);
        bundle.putInt("obj_type", shareItem.fgj);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putString("uid", shareItem.uid);
        shareItem.ae(bundle);
        return shareItem;
    }

    private static int getShareObjParam2(bx bxVar) {
        if (bxVar == null) {
            return 0;
        }
        if (bxVar.bkk()) {
            return 10;
        }
        if (bxVar.bkl()) {
            return 9;
        }
        if (bxVar.bnA()) {
            return 8;
        }
        if (bxVar.bnz()) {
            return 7;
        }
        if (bxVar.isShareThread) {
            return 6;
        }
        if (bxVar.threadType == 0) {
            return 1;
        }
        if (bxVar.threadType == 40) {
            return 2;
        }
        if (bxVar.threadType == 49) {
            return 3;
        }
        if (bxVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int H(com.baidu.tieba.pb.data.f fVar) {
        bx dhH;
        if (fVar != null && (dhH = fVar.dhH()) != null) {
            if (dhH.blE()) {
                return 4;
            }
            if (dhH.blz() == 1) {
                return 3;
            }
            if (dhH.bmW()) {
                return 2;
            }
            if (dhH.bkk()) {
                return 5;
            }
            if (dhH.bkl()) {
                return 6;
            }
            if (dhH.bnz()) {
                return 7;
            }
            return dhH.bnA() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aE(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.diV() == null || pbFragment.djM() == null) {
            return null;
        }
        PbModel diV = pbFragment.diV();
        az djM = pbFragment.djM();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] fI = diV.getPbData().fI(pbFragment.getContext());
        PostData dmN = djM.dmN();
        String str = "";
        if (dmN != null) {
            str = dmN.getId();
            String fT = dmN.fT(pbFragment.getContext());
            if (!k.isEmpty(fT)) {
                fI[1] = fT;
            }
        }
        String blT = diV.getPbData().dhH().blT();
        if (blT != null && blT.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(fI[1]);
        shareFromPBMsgData.setImageUrl(fI[0]);
        shareFromPBMsgData.setForumName(diV.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(diV.getPbData().dhH().getId());
        shareFromPBMsgData.setTitle(diV.getPbData().dhH().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel diV = pbFragment.diV();
            final ShareFromPBMsgData aE = aE(pbFragment);
            if (diV != null && diV.getPbData() != null && diV.getPbData().dhH() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aE);
                aVar.ov(1);
                aVar.bg(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            ar ak = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ak("obj_source", 1).ak("obj_param1", 3).dR("fid", PbModel.this.getForumId()).dR("tid", PbModel.this.dkU()).ak("obj_locate", 1);
                            if (a.H(PbModel.this.getPbData()) != 0) {
                                ak.ak("obj_type", a.H(PbModel.this.getPbData()));
                            }
                            TiebaStatic.log(ak);
                        }
                        pbFragment.HidenSoftKeyPad((InputMethodManager) pbFragment.getBaseFragmentActivity().getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(pbFragment.getBaseFragmentActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), aE.toChatMessageContent())));
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        PbFragment.this.HidenSoftKeyPad((InputMethodManager) PbFragment.this.getBaseFragmentActivity().getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                        aVar2.dismiss();
                    }
                });
                aVar.iX(true);
                aVar.b(pbFragment.getPageContext()).bog();
                if (!k.isEmpty(aE.getImageUrl())) {
                    thread2GroupShareView.aP(aE.getImageUrl(), diV.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel diV = pbFragment.diV();
            final ShareFromPBMsgData aE = aE(pbFragment);
            if (diV != null && diV.getPbData() != null && diV.getPbData().dhH() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aE);
                aVar.ov(1);
                aVar.bg(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        PbFragment.this.HidenSoftKeyPad((InputMethodManager) PbFragment.this.getBaseFragmentActivity().getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(PbFragment.this.getBaseFragmentActivity(), j, str, j2, "from_share", thread2GroupShareView.getLeaveMsg(), aE.toChatMessageContent())));
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        PbFragment.this.HidenSoftKeyPad((InputMethodManager) PbFragment.this.getBaseFragmentActivity().getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                        aVar2.dismiss();
                    }
                });
                aVar.iX(true);
                aVar.b(pbFragment.getPageContext()).bog();
                if (!k.isEmpty(aE.getImageUrl())) {
                    thread2GroupShareView.aP(aE.getImageUrl(), diV.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
