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
import com.baidu.tbadk.core.data.bz;
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
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.Thread2GroupShareView;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {
    public static void a(Context context, bz bzVar, int i) {
        if (bzVar != null && context != null) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i, c(context, bzVar), true));
        }
    }

    private static ShareItem c(Context context, bz bzVar) {
        if (bzVar == null || context == null) {
            return null;
        }
        String valueOf = String.valueOf(bzVar.getFid());
        String brv = bzVar.brv();
        if (bzVar.eVM != null) {
            valueOf = bzVar.eVM.id;
            brv = bzVar.eVM.ori_fname;
        }
        String title = bzVar.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = bzVar.getAbstract();
        }
        String tid = bzVar.getTid();
        String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
        String shareImageUrl = getShareImageUrl(bzVar);
        Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
        String str2 = bzVar.getAbstract();
        String format = MessageFormat.format(context.getResources().getString(R.string.share_content_tpl), title, str2);
        ShareItem shareItem = new ShareItem();
        shareItem.title = title;
        shareItem.content = format;
        shareItem.readCount = bzVar.brj();
        shareItem.fxm = str2;
        shareItem.linkUrl = str;
        shareItem.eWH = 2;
        shareItem.extData = tid;
        shareItem.fxp = 3;
        shareItem.fid = valueOf;
        shareItem.fName = brv;
        shareItem.tid = tid;
        shareItem.fxb = true;
        shareItem.fxo = 6;
        shareItem.fxt = getStateThreadType(bzVar);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.fxw = OriginalThreadInfo.ShareInfo.generateShareInfo(bzVar);
        shareItem.fxx = ShareItem.ForwardInfo.generateForwardInfo(bzVar, 1, null);
        shareItem.fxD = bzVar.getShareImageUrl();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.fxp);
        bundle.putInt("obj_type", shareItem.fxt);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putInt("obj_source", shareItem.eWH);
        shareItem.ae(bundle);
        return shareItem;
    }

    private static String getShareImageUrl(bz bzVar) {
        String str;
        if (bzVar == null || bzVar.brA() == null) {
            return null;
        }
        ArrayList<MediaData> brA = bzVar.brA();
        int size = brA.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = brA.get(i);
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
        if (str == null && bzVar.brI() != null && !TextUtils.isEmpty(bzVar.brI().thumbnail_url)) {
            return bzVar.brI().thumbnail_url;
        }
        return str;
    }

    private static int getStateThreadType(bz bzVar) {
        if (bzVar != null) {
            if (bzVar.brt()) {
                return 4;
            }
            if (bzVar.bro() == 1) {
                return 3;
            }
            return bzVar.bsM() ? 2 : 1;
        }
        return 0;
    }

    public static void a(final PbFragment pbFragment, int i, int i2) {
        if (pbFragment != null && pbFragment.dnW() != null && pbFragment.doP() != null) {
            final PbModel dnW = pbFragment.dnW();
            final ap doP = pbFragment.doP();
            if (dnW.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                ShareItem a2 = a(pbFragment.getContext(), i, i2, dnW);
                TbadkCoreApplication.getInst().setShareItem(a2);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), a2, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.b.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().dnf() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            doP.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                shareDialogConfig.shareItem.ae(bundle);
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                f.cwf().b(shareDialogConfig);
            }
        }
    }

    public static ShareItem a(Context context, int i, int i2, PbModel pbModel) {
        String dpX;
        String str;
        String str2;
        String str3;
        com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
        String title = pbData.dmF().getTitle();
        int i3 = pbModel.getHostMode() ? 1 : 0;
        boolean z = false;
        if (pbData.getForum() != null) {
            if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Sy(pbData.getForumId())) {
                z = true;
            }
        }
        bz dmF = pbModel.getPbData().dmF();
        if (dmF.bqa()) {
            dpX = dmF.getBaijiahaoData().oriUgcTid;
            str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + dmF.getBaijiahaoData().oriUgcType + "&dvid=" + dmF.getBaijiahaoData().oriUgcVid + "&nid=" + dmF.getBaijiahaoData().oriUgcNid;
        } else {
            dpX = pbModel.dpX();
            str = "?share=9105&fr=share&see_lz=" + i3;
        }
        String str4 = "http://tieba.baidu.com/p/" + dpX + (str + "&share_from=post");
        String[] gK = pbData.gK(context);
        String str5 = gK[0];
        if (!StringUtils.isNull(str5) && str5.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
            str5 = str5.substring(TbConfig.URL_IMAGE_PREFIX.length());
        }
        Uri parse = str5 == null ? null : Uri.parse(str5);
        String str6 = gK[1];
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (i == 1) {
            TiebaStatic.log(new aq("c10399").dX("fid", pbData.getForumId()).dX("tid", pbData.getThreadId()).dX("uid", currentAccount));
        }
        String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
        if (pbData.dni() && dmF.brr() != null) {
            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str6)) {
                String str7 = (TextUtils.isEmpty(title) || dmF.btq() || dmF.bpZ()) ? gK[1] : title;
                str2 = MessageFormat.format(string, dmF.brr().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                str3 = str7;
            } else {
                str2 = str6;
                str3 = title;
            }
        } else if (at.isEmpty(str6)) {
            str2 = title;
            str3 = title;
        } else {
            str2 = str6;
            str3 = title;
        }
        String cutString = at.cutString(str3, 100);
        String cutString2 = at.cutString(str2, 100);
        ShareItem shareItem = new ShareItem();
        shareItem.title = cutString;
        shareItem.content = cutString2;
        if (pbData.dni()) {
            shareItem.fxm = cutString2;
            shareItem.readCount = -1L;
        } else {
            shareItem.readCount = pbData.dnd();
        }
        shareItem.linkUrl = str4;
        shareItem.fwY = true;
        shareItem.fxh = z;
        shareItem.extData = pbModel.dpX();
        shareItem.fxp = 3;
        shareItem.fxo = i2;
        shareItem.fxq = getShareObjParam2(dmF);
        shareItem.fid = pbModel.getForumId();
        shareItem.tid = pbModel.dpX();
        shareItem.fxt = I(pbData);
        shareItem.uid = TbadkCoreApplication.getCurrentAccount();
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        if (pbData.dni()) {
            shareItem.canShareBySmartApp = false;
        }
        shareItem.fxw = OriginalThreadInfo.ShareInfo.generateShareInfo(dmF);
        if (pbData != null && pbData.dmH() != null && pbData.dmH().size() > 0) {
            shareItem.fxx = ShareItem.ForwardInfo.generateForwardInfo(dmF, 1, pbData.dmH().get(0));
        } else {
            shareItem.fxx = ShareItem.ForwardInfo.generateForwardInfo(dmF, 1, null);
        }
        if (dmF != null) {
            shareItem.fxD = dmF.getShareImageUrl();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.fxp);
        bundle.putInt("obj_type", shareItem.fxt);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putString("uid", shareItem.uid);
        shareItem.ae(bundle);
        return shareItem;
    }

    private static int getShareObjParam2(bz bzVar) {
        if (bzVar == null) {
            return 0;
        }
        if (bzVar.bpY()) {
            return 10;
        }
        if (bzVar.bpZ()) {
            return 9;
        }
        if (bzVar.btq()) {
            return 8;
        }
        if (bzVar.btp()) {
            return 7;
        }
        if (bzVar.isShareThread) {
            return 6;
        }
        if (bzVar.threadType == 0) {
            return 1;
        }
        if (bzVar.threadType == 40) {
            return 2;
        }
        if (bzVar.threadType == 49) {
            return 3;
        }
        if (bzVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int I(com.baidu.tieba.pb.data.f fVar) {
        bz dmF;
        if (fVar != null && (dmF = fVar.dmF()) != null) {
            if (dmF.brt()) {
                return 4;
            }
            if (dmF.bro() == 1) {
                return 3;
            }
            if (dmF.bsM()) {
                return 2;
            }
            if (dmF.bpY()) {
                return 5;
            }
            if (dmF.bpZ()) {
                return 6;
            }
            if (dmF.btp()) {
                return 7;
            }
            return dmF.btq() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aB(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.dnW() == null || pbFragment.doP() == null) {
            return null;
        }
        PbModel dnW = pbFragment.dnW();
        ap doP = pbFragment.doP();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] gK = dnW.getPbData().gK(pbFragment.getContext());
        PostData drS = doP.drS();
        String str = "";
        if (drS != null) {
            str = drS.getId();
            String gW = drS.gW(pbFragment.getContext());
            if (!k.isEmpty(gW)) {
                gK[1] = gW;
            }
        }
        String brH = dnW.getPbData().dmF().brH();
        if (brH != null && brH.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(gK[1]);
        shareFromPBMsgData.setImageUrl(gK[0]);
        shareFromPBMsgData.setForumName(dnW.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(dnW.getPbData().dmF().getId());
        shareFromPBMsgData.setTitle(dnW.getPbData().dmF().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel dnW = pbFragment.dnW();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (dnW != null && dnW.getPbData() != null && dnW.getPbData().dmF() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.pd(1);
                aVar.br(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.b.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            aq an = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).an("obj_source", 1).an("obj_param1", 3).dX("fid", PbModel.this.getForumId()).dX("tid", PbModel.this.dpX()).an("obj_locate", 1);
                            if (b.I(PbModel.this.getPbData()) != 0) {
                                an.an("obj_type", b.I(PbModel.this.getPbData()));
                            }
                            TiebaStatic.log(an);
                        }
                        pbFragment.HidenSoftKeyPad((InputMethodManager) pbFragment.getBaseFragmentActivity().getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(pbFragment.getBaseFragmentActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), aB.toChatMessageContent())));
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.b.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        PbFragment.this.HidenSoftKeyPad((InputMethodManager) PbFragment.this.getBaseFragmentActivity().getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                        aVar2.dismiss();
                    }
                });
                aVar.jI(true);
                aVar.b(pbFragment.getPageContext()).btY();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.aQ(aB.getImageUrl(), dnW.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel dnW = pbFragment.dnW();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (dnW != null && dnW.getPbData() != null && dnW.getPbData().dmF() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.pd(1);
                aVar.br(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.b.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        PbFragment.this.HidenSoftKeyPad((InputMethodManager) PbFragment.this.getBaseFragmentActivity().getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(PbFragment.this.getBaseFragmentActivity(), j, str, j2, "from_share", thread2GroupShareView.getLeaveMsg(), aB.toChatMessageContent())));
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.b.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        PbFragment.this.HidenSoftKeyPad((InputMethodManager) PbFragment.this.getBaseFragmentActivity().getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                        aVar2.dismiss();
                    }
                });
                aVar.jI(true);
                aVar.b(pbFragment.getPageContext()).btY();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.aQ(aB.getImageUrl(), dnW.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
