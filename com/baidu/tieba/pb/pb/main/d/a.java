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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.c.f;
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
/* loaded from: classes16.dex */
public class a {
    public static void a(Context context, bw bwVar, int i) {
        if (bwVar != null && context != null) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i, c(context, bwVar), true));
        }
    }

    private static ShareItem c(Context context, bw bwVar) {
        if (bwVar == null || context == null) {
            return null;
        }
        String valueOf = String.valueOf(bwVar.getFid());
        String beI = bwVar.beI();
        if (bwVar.edT != null) {
            valueOf = bwVar.edT.id;
            beI = bwVar.edT.ori_fname;
        }
        String title = bwVar.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = bwVar.getAbstract();
        }
        String tid = bwVar.getTid();
        String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
        String shareImageUrl = getShareImageUrl(bwVar);
        Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
        String str2 = bwVar.getAbstract();
        String format = MessageFormat.format(context.getResources().getString(R.string.share_content_tpl), title, str2);
        ShareItem shareItem = new ShareItem();
        shareItem.title = title;
        shareItem.content = format;
        shareItem.readCount = bwVar.bew();
        shareItem.eEu = str2;
        shareItem.linkUrl = str;
        shareItem.eeF = 2;
        shareItem.extData = tid;
        shareItem.eEx = 3;
        shareItem.fid = valueOf;
        shareItem.fName = beI;
        shareItem.tid = tid;
        shareItem.eEj = true;
        shareItem.eEw = 6;
        shareItem.eEB = getStateThreadType(bwVar);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.eEE = OriginalThreadInfo.ShareInfo.generateShareInfo(bwVar);
        shareItem.eEF = ShareItem.ForwardInfo.generateForwardInfo(bwVar, 1, null);
        shareItem.eEL = bwVar.getShareImageUrl();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.eEx);
        bundle.putInt("obj_type", shareItem.eEB);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putInt("obj_source", shareItem.eeF);
        shareItem.ae(bundle);
        return shareItem;
    }

    private static String getShareImageUrl(bw bwVar) {
        String str;
        if (bwVar == null || bwVar.beN() == null) {
            return null;
        }
        ArrayList<MediaData> beN = bwVar.beN();
        int size = beN.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = beN.get(i);
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
        if (str == null && bwVar.beW() != null && !TextUtils.isEmpty(bwVar.beW().thumbnail_url)) {
            return bwVar.beW().thumbnail_url;
        }
        return str;
    }

    private static int getStateThreadType(bw bwVar) {
        if (bwVar != null) {
            if (bwVar.beG()) {
                return 4;
            }
            if (bwVar.beB() == 1) {
                return 3;
            }
            return bwVar.bfW() ? 2 : 1;
        }
        return 0;
    }

    public static void a(final PbFragment pbFragment, int i, int i2) {
        if (pbFragment != null && pbFragment.cWE() != null && pbFragment.cXu() != null) {
            final PbModel cWE = pbFragment.cWE();
            final az cXu = pbFragment.cXu();
            if (cWE.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                ShareItem a = a(pbFragment.getContext(), i, i2, cWE);
                TbadkCoreApplication.getInst().setShareItem(a);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), a, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().cVM() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            cXu.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                shareDialogConfig.shareItem.ae(bundle);
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                f.cdc().b(shareDialogConfig);
            }
        }
    }

    public static ShareItem a(Context context, int i, int i2, PbModel pbModel) {
        String cYC;
        String str;
        String str2;
        com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
        String title = pbData.cVm().getTitle();
        int i3 = pbModel.getHostMode() ? 1 : 0;
        boolean z = false;
        if (pbData.getForum() != null) {
            if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.PX(pbData.getForumId())) {
                z = true;
            }
        }
        bw cVm = pbModel.getPbData().cVm();
        if (cVm.bdo()) {
            cYC = cVm.getBaijiahaoData().oriUgcTid;
            str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + cVm.getBaijiahaoData().oriUgcType + "&dvid=" + cVm.getBaijiahaoData().oriUgcVid + "&nid=" + cVm.getBaijiahaoData().oriUgcNid;
        } else {
            cYC = pbModel.cYC();
            str = "?share=9105&fr=share&see_lz=" + i3;
        }
        String str3 = "http://tieba.baidu.com/p/" + cYC + str;
        String[] fv = pbData.fv(context);
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
            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                str2 = (TextUtils.isEmpty(title) || cVm.bgA() || cVm.bdn()) ? fv[1] : title;
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
        } else {
            shareItem.readCount = pbData.cVK();
        }
        shareItem.linkUrl = str3;
        shareItem.eEg = true;
        shareItem.eEp = z;
        shareItem.extData = pbModel.cYC();
        shareItem.eEx = 3;
        shareItem.eEw = i2;
        shareItem.eEy = getShareObjParam2(cVm);
        shareItem.fid = pbModel.getForumId();
        shareItem.tid = pbModel.cYC();
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
        if (cVm != null) {
            shareItem.eEL = cVm.getShareImageUrl();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.eEx);
        bundle.putInt("obj_type", shareItem.eEB);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putString("uid", shareItem.uid);
        shareItem.ae(bundle);
        return shareItem;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static int F(com.baidu.tieba.pb.data.f fVar) {
        bw cVm;
        if (fVar != null && (cVm = fVar.cVm()) != null) {
            if (cVm.beG()) {
                return 4;
            }
            if (cVm.beB() == 1) {
                return 3;
            }
            if (cVm.bfW()) {
                return 2;
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
            return cVm.bgA() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aD(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.cWE() == null || pbFragment.cXu() == null) {
            return null;
        }
        PbModel cWE = pbFragment.cWE();
        az cXu = pbFragment.cXu();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] fv = cWE.getPbData().fv(pbFragment.getContext());
        PostData dau = cXu.dau();
        String str = "";
        if (dau != null) {
            str = dau.getId();
            String fG = dau.fG(pbFragment.getContext());
            if (!k.isEmpty(fG)) {
                fv[1] = fG;
            }
        }
        String beV = cWE.getPbData().cVm().beV();
        if (beV != null && beV.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(fv[1]);
        shareFromPBMsgData.setImageUrl(fv[0]);
        shareFromPBMsgData.setForumName(cWE.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(cWE.getPbData().cVm().getId());
        shareFromPBMsgData.setTitle(cWE.getPbData().cVm().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel cWE = pbFragment.cWE();
            final ShareFromPBMsgData aD = aD(pbFragment);
            if (cWE != null && cWE.getPbData() != null && cWE.getPbData().cVm() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aD);
                aVar.nw(1);
                aVar.aX(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            aq ai = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ai("obj_source", 1).ai("obj_param1", 3).dD("fid", PbModel.this.getForumId()).dD("tid", PbModel.this.cYC()).ai("obj_locate", 1);
                            if (a.F(PbModel.this.getPbData()) != 0) {
                                ai.ai("obj_type", a.F(PbModel.this.getPbData()));
                            }
                            TiebaStatic.log(ai);
                        }
                        pbFragment.HidenSoftKeyPad((InputMethodManager) pbFragment.getBaseFragmentActivity().getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(pbFragment.getBaseFragmentActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), aD.toChatMessageContent())));
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
                aVar.ih(true);
                aVar.b(pbFragment.getPageContext()).bhg();
                if (!k.isEmpty(aD.getImageUrl())) {
                    thread2GroupShareView.aJ(aD.getImageUrl(), cWE.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel cWE = pbFragment.cWE();
            final ShareFromPBMsgData aD = aD(pbFragment);
            if (cWE != null && cWE.getPbData() != null && cWE.getPbData().cVm() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aD);
                aVar.nw(1);
                aVar.aX(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        PbFragment.this.HidenSoftKeyPad((InputMethodManager) PbFragment.this.getBaseFragmentActivity().getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(PbFragment.this.getBaseFragmentActivity(), j, str, j2, "from_share", thread2GroupShareView.getLeaveMsg(), aD.toChatMessageContent())));
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
                aVar.ih(true);
                aVar.b(pbFragment.getPageContext()).bhg();
                if (!k.isEmpty(aD.getImageUrl())) {
                    thread2GroupShareView.aJ(aD.getImageUrl(), cWE.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
