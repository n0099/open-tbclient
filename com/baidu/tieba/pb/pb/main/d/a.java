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
        if (bwVar.edP != null) {
            valueOf = bwVar.edP.id;
            beI = bwVar.edP.ori_fname;
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
        shareItem.eEq = str2;
        shareItem.linkUrl = str;
        shareItem.eeB = 2;
        shareItem.extData = tid;
        shareItem.eEt = 3;
        shareItem.fid = valueOf;
        shareItem.fName = beI;
        shareItem.tid = tid;
        shareItem.eEf = true;
        shareItem.eEs = 6;
        shareItem.eEx = getStateThreadType(bwVar);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.eEA = OriginalThreadInfo.ShareInfo.generateShareInfo(bwVar);
        shareItem.eEB = ShareItem.ForwardInfo.generateForwardInfo(bwVar, 1, null);
        shareItem.eEH = bwVar.getShareImageUrl();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.eEt);
        bundle.putInt("obj_type", shareItem.eEx);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putInt("obj_source", shareItem.eeB);
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
        if (pbFragment != null && pbFragment.cWD() != null && pbFragment.cXt() != null) {
            final PbModel cWD = pbFragment.cWD();
            final az cXt = pbFragment.cXt();
            if (cWD.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                ShareItem a = a(pbFragment.getContext(), i, i2, cWD);
                TbadkCoreApplication.getInst().setShareItem(a);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), a, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().cVL() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            cXt.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                shareDialogConfig.shareItem.ae(bundle);
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                f.cdb().b(shareDialogConfig);
            }
        }
    }

    public static ShareItem a(Context context, int i, int i2, PbModel pbModel) {
        String cYB;
        String str;
        String str2;
        com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
        String title = pbData.cVl().getTitle();
        int i3 = pbModel.getHostMode() ? 1 : 0;
        boolean z = false;
        if (pbData.getForum() != null) {
            if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.PX(pbData.getForumId())) {
                z = true;
            }
        }
        bw cVl = pbModel.getPbData().cVl();
        if (cVl.bdo()) {
            cYB = cVl.getBaijiahaoData().oriUgcTid;
            str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + cVl.getBaijiahaoData().oriUgcType + "&dvid=" + cVl.getBaijiahaoData().oriUgcVid + "&nid=" + cVl.getBaijiahaoData().oriUgcNid;
        } else {
            cYB = pbModel.cYB();
            str = "?share=9105&fr=share&see_lz=" + i3;
        }
        String str3 = "http://tieba.baidu.com/p/" + cYB + str;
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
        if (pbData.cVO() && cVl.beE() != null) {
            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                str2 = (TextUtils.isEmpty(title) || cVl.bgA() || cVl.bdn()) ? fv[1] : title;
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
        } else {
            shareItem.readCount = pbData.cVJ();
        }
        shareItem.linkUrl = str3;
        shareItem.eEc = true;
        shareItem.eEl = z;
        shareItem.extData = pbModel.cYB();
        shareItem.eEt = 3;
        shareItem.eEs = i2;
        shareItem.eEu = getShareObjParam2(cVl);
        shareItem.fid = pbModel.getForumId();
        shareItem.tid = pbModel.cYB();
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
        if (cVl != null) {
            shareItem.eEH = cVl.getShareImageUrl();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.eEt);
        bundle.putInt("obj_type", shareItem.eEx);
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
        bw cVl;
        if (fVar != null && (cVl = fVar.cVl()) != null) {
            if (cVl.beG()) {
                return 4;
            }
            if (cVl.beB() == 1) {
                return 3;
            }
            if (cVl.bfW()) {
                return 2;
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
            return cVl.bgA() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aD(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.cWD() == null || pbFragment.cXt() == null) {
            return null;
        }
        PbModel cWD = pbFragment.cWD();
        az cXt = pbFragment.cXt();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] fv = cWD.getPbData().fv(pbFragment.getContext());
        PostData dat = cXt.dat();
        String str = "";
        if (dat != null) {
            str = dat.getId();
            String fG = dat.fG(pbFragment.getContext());
            if (!k.isEmpty(fG)) {
                fv[1] = fG;
            }
        }
        String beV = cWD.getPbData().cVl().beV();
        if (beV != null && beV.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(fv[1]);
        shareFromPBMsgData.setImageUrl(fv[0]);
        shareFromPBMsgData.setForumName(cWD.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(cWD.getPbData().cVl().getId());
        shareFromPBMsgData.setTitle(cWD.getPbData().cVl().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel cWD = pbFragment.cWD();
            final ShareFromPBMsgData aD = aD(pbFragment);
            if (cWD != null && cWD.getPbData() != null && cWD.getPbData().cVl() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aD);
                aVar.nw(1);
                aVar.aX(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            aq ai = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ai("obj_source", 1).ai("obj_param1", 3).dD("fid", PbModel.this.getForumId()).dD("tid", PbModel.this.cYB()).ai("obj_locate", 1);
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
                aVar.ig(true);
                aVar.b(pbFragment.getPageContext()).bhg();
                if (!k.isEmpty(aD.getImageUrl())) {
                    thread2GroupShareView.aJ(aD.getImageUrl(), cWD.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel cWD = pbFragment.cWD();
            final ShareFromPBMsgData aD = aD(pbFragment);
            if (cWD != null && cWD.getPbData() != null && cWD.getPbData().cVl() != null) {
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
                aVar.ig(true);
                aVar.b(pbFragment.getPageContext()).bhg();
                if (!k.isEmpty(aD.getImageUrl())) {
                    thread2GroupShareView.aJ(aD.getImageUrl(), cWD.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
