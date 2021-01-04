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
        String bru = bzVar.bru();
        if (bzVar.eVM != null) {
            valueOf = bzVar.eVM.id;
            bru = bzVar.eVM.ori_fname;
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
        shareItem.readCount = bzVar.bri();
        shareItem.fxm = str2;
        shareItem.linkUrl = str;
        shareItem.eWH = 2;
        shareItem.extData = tid;
        shareItem.fxp = 3;
        shareItem.fid = valueOf;
        shareItem.fName = bru;
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
        if (bzVar == null || bzVar.brz() == null) {
            return null;
        }
        ArrayList<MediaData> brz = bzVar.brz();
        int size = brz.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = brz.get(i);
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
        if (str == null && bzVar.brH() != null && !TextUtils.isEmpty(bzVar.brH().thumbnail_url)) {
            return bzVar.brH().thumbnail_url;
        }
        return str;
    }

    private static int getStateThreadType(bz bzVar) {
        if (bzVar != null) {
            if (bzVar.brs()) {
                return 4;
            }
            if (bzVar.brn() == 1) {
                return 3;
            }
            return bzVar.bsL() ? 2 : 1;
        }
        return 0;
    }

    public static void a(final PbFragment pbFragment, int i, int i2) {
        if (pbFragment != null && pbFragment.dnV() != null && pbFragment.doO() != null) {
            final PbModel dnV = pbFragment.dnV();
            final ap doO = pbFragment.doO();
            if (dnV.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                ShareItem a2 = a(pbFragment.getContext(), i, i2, dnV);
                TbadkCoreApplication.getInst().setShareItem(a2);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), a2, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.b.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().dne() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            doO.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                shareDialogConfig.shareItem.ae(bundle);
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                f.cwe().b(shareDialogConfig);
            }
        }
    }

    public static ShareItem a(Context context, int i, int i2, PbModel pbModel) {
        String dpW;
        String str;
        String str2;
        String str3;
        com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
        String title = pbData.dmE().getTitle();
        int i3 = pbModel.getHostMode() ? 1 : 0;
        boolean z = false;
        if (pbData.getForum() != null) {
            if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Sz(pbData.getForumId())) {
                z = true;
            }
        }
        bz dmE = pbModel.getPbData().dmE();
        if (dmE.bpZ()) {
            dpW = dmE.getBaijiahaoData().oriUgcTid;
            str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + dmE.getBaijiahaoData().oriUgcType + "&dvid=" + dmE.getBaijiahaoData().oriUgcVid + "&nid=" + dmE.getBaijiahaoData().oriUgcNid;
        } else {
            dpW = pbModel.dpW();
            str = "?share=9105&fr=share&see_lz=" + i3;
        }
        String str4 = "http://tieba.baidu.com/p/" + dpW + (str + "&share_from=post");
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
        if (pbData.dnh() && dmE.brq() != null) {
            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str6)) {
                String str7 = (TextUtils.isEmpty(title) || dmE.btp() || dmE.bpY()) ? gK[1] : title;
                str2 = MessageFormat.format(string, dmE.brq().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
        if (pbData.dnh()) {
            shareItem.fxm = cutString2;
            shareItem.readCount = -1L;
        } else {
            shareItem.readCount = pbData.dnc();
        }
        shareItem.linkUrl = str4;
        shareItem.fwY = true;
        shareItem.fxh = z;
        shareItem.extData = pbModel.dpW();
        shareItem.fxp = 3;
        shareItem.fxo = i2;
        shareItem.fxq = getShareObjParam2(dmE);
        shareItem.fid = pbModel.getForumId();
        shareItem.tid = pbModel.dpW();
        shareItem.fxt = I(pbData);
        shareItem.uid = TbadkCoreApplication.getCurrentAccount();
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        if (pbData.dnh()) {
            shareItem.canShareBySmartApp = false;
        }
        shareItem.fxw = OriginalThreadInfo.ShareInfo.generateShareInfo(dmE);
        if (pbData != null && pbData.dmG() != null && pbData.dmG().size() > 0) {
            shareItem.fxx = ShareItem.ForwardInfo.generateForwardInfo(dmE, 1, pbData.dmG().get(0));
        } else {
            shareItem.fxx = ShareItem.ForwardInfo.generateForwardInfo(dmE, 1, null);
        }
        if (dmE != null) {
            shareItem.fxD = dmE.getShareImageUrl();
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
        if (bzVar.bpX()) {
            return 10;
        }
        if (bzVar.bpY()) {
            return 9;
        }
        if (bzVar.btp()) {
            return 8;
        }
        if (bzVar.bto()) {
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
        bz dmE;
        if (fVar != null && (dmE = fVar.dmE()) != null) {
            if (dmE.brs()) {
                return 4;
            }
            if (dmE.brn() == 1) {
                return 3;
            }
            if (dmE.bsL()) {
                return 2;
            }
            if (dmE.bpX()) {
                return 5;
            }
            if (dmE.bpY()) {
                return 6;
            }
            if (dmE.bto()) {
                return 7;
            }
            return dmE.btp() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aB(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.dnV() == null || pbFragment.doO() == null) {
            return null;
        }
        PbModel dnV = pbFragment.dnV();
        ap doO = pbFragment.doO();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] gK = dnV.getPbData().gK(pbFragment.getContext());
        PostData drR = doO.drR();
        String str = "";
        if (drR != null) {
            str = drR.getId();
            String gW = drR.gW(pbFragment.getContext());
            if (!k.isEmpty(gW)) {
                gK[1] = gW;
            }
        }
        String brG = dnV.getPbData().dmE().brG();
        if (brG != null && brG.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(gK[1]);
        shareFromPBMsgData.setImageUrl(gK[0]);
        shareFromPBMsgData.setForumName(dnV.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(dnV.getPbData().dmE().getId());
        shareFromPBMsgData.setTitle(dnV.getPbData().dmE().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel dnV = pbFragment.dnV();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (dnV != null && dnV.getPbData() != null && dnV.getPbData().dmE() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.pd(1);
                aVar.br(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.b.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            aq an = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).an("obj_source", 1).an("obj_param1", 3).dX("fid", PbModel.this.getForumId()).dX("tid", PbModel.this.dpW()).an("obj_locate", 1);
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
                aVar.b(pbFragment.getPageContext()).btX();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.aQ(aB.getImageUrl(), dnV.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel dnV = pbFragment.dnV();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (dnV != null && dnV.getPbData() != null && dnV.getPbData().dmE() != null) {
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
                aVar.b(pbFragment.getPageContext()).btX();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.aQ(aB.getImageUrl(), dnV.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
