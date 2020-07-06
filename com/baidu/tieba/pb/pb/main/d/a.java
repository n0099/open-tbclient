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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.c.f;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.av;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.Thread2GroupShareView;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a {
    public static void a(Context context, bu buVar, int i) {
        if (buVar != null && context != null) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i, c(context, buVar), true));
        }
    }

    private static ShareItem c(Context context, bu buVar) {
        if (buVar == null || context == null) {
            return null;
        }
        String valueOf = String.valueOf(buVar.getFid());
        String aSt = buVar.aSt();
        if (buVar.dOi != null) {
            valueOf = buVar.dOi.id;
            aSt = buVar.dOi.ori_fname;
        }
        String title = buVar.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = buVar.getAbstract();
        }
        String tid = buVar.getTid();
        String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
        String A = A(buVar);
        Uri parse = A == null ? null : Uri.parse(A);
        String str2 = buVar.getAbstract();
        String format = MessageFormat.format(context.getResources().getString(R.string.share_content_tpl), title, str2);
        ShareItem shareItem = new ShareItem();
        shareItem.title = title;
        shareItem.content = format;
        shareItem.readCount = buVar.aSh();
        shareItem.enE = str2;
        shareItem.linkUrl = str;
        shareItem.dOP = 2;
        shareItem.extData = tid;
        shareItem.enH = 3;
        shareItem.fid = valueOf;
        shareItem.fName = aSt;
        shareItem.tid = tid;
        shareItem.enu = true;
        shareItem.enG = 6;
        shareItem.enL = B(buVar);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.enO = OriginalThreadInfo.ShareInfo.generateShareInfo(buVar);
        shareItem.enP = ShareItem.ForwardInfo.generateForwardInfo(buVar, 1, null);
        shareItem.enV = buVar.getShareImageUrl();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.enH);
        bundle.putInt("obj_type", shareItem.enL);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putInt("obj_source", shareItem.dOP);
        shareItem.ae(bundle);
        return shareItem;
    }

    private static String A(bu buVar) {
        String str;
        if (buVar == null || buVar.aSy() == null) {
            return null;
        }
        ArrayList<MediaData> aSy = buVar.aSy();
        int size = aSy.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aSy.get(i);
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
        if (str == null && buVar.aSH() != null && !TextUtils.isEmpty(buVar.aSH().thumbnail_url)) {
            return buVar.aSH().thumbnail_url;
        }
        return str;
    }

    private static int B(bu buVar) {
        if (buVar != null) {
            if (buVar.aSr()) {
                return 4;
            }
            if (buVar.aSm() == 1) {
                return 3;
            }
            return buVar.aTH() ? 2 : 1;
        }
        return 0;
    }

    public static void a(final PbFragment pbFragment, int i, int i2) {
        if (pbFragment != null && pbFragment.cIf() != null && pbFragment.cIV() != null) {
            final PbModel cIf = pbFragment.cIf();
            final av cIV = pbFragment.cIV();
            if (cIf.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                ShareItem a = a(pbFragment.getContext(), i, i2, cIf);
                TbadkCoreApplication.getInst().setShareItem(a);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), a, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().cHn() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            cIV.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                f.bPE().b(shareDialogConfig);
            }
        }
    }

    public static ShareItem a(Context context, int i, int i2, PbModel pbModel) {
        String cKa;
        String str;
        String str2;
        e pbData = pbModel.getPbData();
        String title = pbData.cGO().getTitle();
        int i3 = pbModel.getHostMode() ? 1 : 0;
        boolean z = false;
        if (pbData.getForum() != null) {
            if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Mr(pbData.getForumId())) {
                z = true;
            }
        }
        bu cGO = pbModel.getPbData().cGO();
        if (cGO.aQZ()) {
            cKa = cGO.getBaijiahaoData().oriUgcTid;
            str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + cGO.getBaijiahaoData().oriUgcType + "&dvid=" + cGO.getBaijiahaoData().oriUgcVid + "&nid=" + cGO.getBaijiahaoData().oriUgcNid;
        } else {
            cKa = pbModel.cKa();
            str = "?share=9105&fr=share&see_lz=" + i3;
        }
        String str3 = "http://tieba.baidu.com/p/" + cKa + str;
        String[] fe = pbData.fe(context);
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
            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                str2 = (TextUtils.isEmpty(title) || cGO.aUm() || cGO.aQY()) ? fe[1] : title;
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
        } else {
            shareItem.readCount = pbData.cHl();
        }
        shareItem.linkUrl = str3;
        shareItem.enr = true;
        shareItem.enz = z;
        shareItem.extData = pbModel.cKa();
        shareItem.enH = 3;
        shareItem.enG = i2;
        shareItem.enI = z(cGO);
        shareItem.fid = pbModel.getForumId();
        shareItem.tid = pbModel.cKa();
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
        if (cGO != null) {
            shareItem.enV = cGO.getShareImageUrl();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.enH);
        bundle.putInt("obj_type", shareItem.enL);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putString("uid", shareItem.uid);
        shareItem.ae(bundle);
        return shareItem;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static int F(e eVar) {
        bu cGO;
        if (eVar != null && (cGO = eVar.cGO()) != null) {
            if (cGO.aSr()) {
                return 4;
            }
            if (cGO.aSm() == 1) {
                return 3;
            }
            if (cGO.aTH()) {
                return 2;
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
            return cGO.aUm() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aB(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.cIf() == null || pbFragment.cIV() == null) {
            return null;
        }
        PbModel cIf = pbFragment.cIf();
        av cIV = pbFragment.cIV();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] fe = cIf.getPbData().fe(pbFragment.getContext());
        PostData cLR = cIV.cLR();
        String str = "";
        if (cLR != null) {
            str = cLR.getId();
            String fq = cLR.fq(pbFragment.getContext());
            if (!k.isEmpty(fq)) {
                fe[1] = fq;
            }
        }
        String aSG = cIf.getPbData().cGO().aSG();
        if (aSG != null && aSG.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(fe[1]);
        shareFromPBMsgData.setImageUrl(fe[0]);
        shareFromPBMsgData.setForumName(cIf.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(cIf.getPbData().cGO().getId());
        shareFromPBMsgData.setTitle(cIf.getPbData().cGO().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel cIf = pbFragment.cIf();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (cIf != null && cIf.getPbData() != null && cIf.getPbData().cGO() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.kW(1);
                aVar.aP(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            ao dk = new ao(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ag("obj_source", 1).ag("obj_param1", 3).dk("fid", PbModel.this.getForumId()).dk("tid", PbModel.this.cKa());
                            if (a.F(PbModel.this.getPbData()) != 0) {
                                dk.ag("obj_type", a.F(PbModel.this.getPbData()));
                            }
                            TiebaStatic.log(dk);
                        }
                        pbFragment.HidenSoftKeyPad((InputMethodManager) pbFragment.getBaseFragmentActivity().getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(pbFragment.getBaseFragmentActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), aB.toChatMessageContent())));
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
                aVar.hg(true);
                aVar.b(pbFragment.getPageContext()).aUN();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.aH(aB.getImageUrl(), cIf.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel cIf = pbFragment.cIf();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (cIf != null && cIf.getPbData() != null && cIf.getPbData().cGO() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.kW(1);
                aVar.aP(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        PbFragment.this.HidenSoftKeyPad((InputMethodManager) PbFragment.this.getBaseFragmentActivity().getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(PbFragment.this.getBaseFragmentActivity(), j, str, j2, "from_share", thread2GroupShareView.getLeaveMsg(), aB.toChatMessageContent())));
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
                aVar.hg(true);
                aVar.b(pbFragment.getPageContext()).aUN();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.aH(aB.getImageUrl(), cIf.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
