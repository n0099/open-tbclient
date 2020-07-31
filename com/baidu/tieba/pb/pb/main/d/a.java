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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
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
    public static void a(Context context, bv bvVar, int i) {
        if (bvVar != null && context != null) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i, c(context, bvVar), true));
        }
    }

    private static ShareItem c(Context context, bv bvVar) {
        if (bvVar == null || context == null) {
            return null;
        }
        String valueOf = String.valueOf(bvVar.getFid());
        String aWp = bvVar.aWp();
        if (bvVar.dUt != null) {
            valueOf = bvVar.dUt.id;
            aWp = bvVar.dUt.ori_fname;
        }
        String title = bvVar.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = bvVar.getAbstract();
        }
        String tid = bvVar.getTid();
        String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
        String shareImageUrl = getShareImageUrl(bvVar);
        Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
        String str2 = bvVar.getAbstract();
        String format = MessageFormat.format(context.getResources().getString(R.string.share_content_tpl), title, str2);
        ShareItem shareItem = new ShareItem();
        shareItem.title = title;
        shareItem.content = format;
        shareItem.readCount = bvVar.aWd();
        shareItem.etQ = str2;
        shareItem.linkUrl = str;
        shareItem.dVb = 2;
        shareItem.extData = tid;
        shareItem.etT = 3;
        shareItem.fid = valueOf;
        shareItem.fName = aWp;
        shareItem.tid = tid;
        shareItem.etH = true;
        shareItem.etS = 6;
        shareItem.etX = getStateThreadType(bvVar);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.eua = OriginalThreadInfo.ShareInfo.generateShareInfo(bvVar);
        shareItem.eub = ShareItem.ForwardInfo.generateForwardInfo(bvVar, 1, null);
        shareItem.euh = bvVar.getShareImageUrl();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.etT);
        bundle.putInt("obj_type", shareItem.etX);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putInt("obj_source", shareItem.dVb);
        shareItem.af(bundle);
        return shareItem;
    }

    private static String getShareImageUrl(bv bvVar) {
        String str;
        if (bvVar == null || bvVar.aWu() == null) {
            return null;
        }
        ArrayList<MediaData> aWu = bvVar.aWu();
        int size = aWu.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aWu.get(i);
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
        if (str == null && bvVar.aWD() != null && !TextUtils.isEmpty(bvVar.aWD().thumbnail_url)) {
            return bvVar.aWD().thumbnail_url;
        }
        return str;
    }

    private static int getStateThreadType(bv bvVar) {
        if (bvVar != null) {
            if (bvVar.aWn()) {
                return 4;
            }
            if (bvVar.aWi() == 1) {
                return 3;
            }
            return bvVar.aXD() ? 2 : 1;
        }
        return 0;
    }

    public static void a(final PbFragment pbFragment, int i, int i2) {
        if (pbFragment != null && pbFragment.cLP() != null && pbFragment.cMF() != null) {
            final PbModel cLP = pbFragment.cLP();
            final az cMF = pbFragment.cMF();
            if (cLP.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                ShareItem a = a(pbFragment.getContext(), i, i2, cLP);
                TbadkCoreApplication.getInst().setShareItem(a);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), a, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().cKX() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            cMF.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                f.bSP().b(shareDialogConfig);
            }
        }
    }

    public static ShareItem a(Context context, int i, int i2, PbModel pbModel) {
        String cNL;
        String str;
        String str2;
        com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
        String title = pbData.cKx().getTitle();
        int i3 = pbModel.getHostMode() ? 1 : 0;
        boolean z = false;
        if (pbData.getForum() != null) {
            if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.MZ(pbData.getForumId())) {
                z = true;
            }
        }
        bv cKx = pbModel.getPbData().cKx();
        if (cKx.aUV()) {
            cNL = cKx.getBaijiahaoData().oriUgcTid;
            str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + cKx.getBaijiahaoData().oriUgcType + "&dvid=" + cKx.getBaijiahaoData().oriUgcVid + "&nid=" + cKx.getBaijiahaoData().oriUgcNid;
        } else {
            cNL = pbModel.cNL();
            str = "?share=9105&fr=share&see_lz=" + i3;
        }
        String str3 = "http://tieba.baidu.com/p/" + cNL + str;
        String[] fi = pbData.fi(context);
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
            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                str2 = (TextUtils.isEmpty(title) || cKx.aYh() || cKx.aUU()) ? fi[1] : title;
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
        } else {
            shareItem.readCount = pbData.cKV();
        }
        shareItem.linkUrl = str3;
        shareItem.etE = true;
        shareItem.etL = z;
        shareItem.extData = pbModel.cNL();
        shareItem.etT = 3;
        shareItem.etS = i2;
        shareItem.etU = getShareObjParam2(cKx);
        shareItem.fid = pbModel.getForumId();
        shareItem.tid = pbModel.cNL();
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
        if (cKx != null) {
            shareItem.euh = cKx.getShareImageUrl();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.etT);
        bundle.putInt("obj_type", shareItem.etX);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putString("uid", shareItem.uid);
        shareItem.af(bundle);
        return shareItem;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static int F(com.baidu.tieba.pb.data.f fVar) {
        bv cKx;
        if (fVar != null && (cKx = fVar.cKx()) != null) {
            if (cKx.aWn()) {
                return 4;
            }
            if (cKx.aWi() == 1) {
                return 3;
            }
            if (cKx.aXD()) {
                return 2;
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
            return cKx.aYh() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aD(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.cLP() == null || pbFragment.cMF() == null) {
            return null;
        }
        PbModel cLP = pbFragment.cLP();
        az cMF = pbFragment.cMF();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] fi = cLP.getPbData().fi(pbFragment.getContext());
        PostData cPD = cMF.cPD();
        String str = "";
        if (cPD != null) {
            str = cPD.getId();
            String ft = cPD.ft(pbFragment.getContext());
            if (!k.isEmpty(ft)) {
                fi[1] = ft;
            }
        }
        String aWC = cLP.getPbData().cKx().aWC();
        if (aWC != null && aWC.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(fi[1]);
        shareFromPBMsgData.setImageUrl(fi[0]);
        shareFromPBMsgData.setForumName(cLP.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(cLP.getPbData().cKx().getId());
        shareFromPBMsgData.setTitle(cLP.getPbData().cKx().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel cLP = pbFragment.cLP();
            final ShareFromPBMsgData aD = aD(pbFragment);
            if (cLP != null && cLP.getPbData() != null && cLP.getPbData().cKx() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aD);
                aVar.lq(1);
                aVar.aV(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            ap dn = new ap(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ah("obj_source", 1).ah("obj_param1", 3).dn("fid", PbModel.this.getForumId()).dn("tid", PbModel.this.cNL());
                            if (a.F(PbModel.this.getPbData()) != 0) {
                                dn.ah("obj_type", a.F(PbModel.this.getPbData()));
                            }
                            TiebaStatic.log(dn);
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
                aVar.hK(true);
                aVar.b(pbFragment.getPageContext()).aYL();
                if (!k.isEmpty(aD.getImageUrl())) {
                    thread2GroupShareView.aF(aD.getImageUrl(), cLP.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel cLP = pbFragment.cLP();
            final ShareFromPBMsgData aD = aD(pbFragment);
            if (cLP != null && cLP.getPbData() != null && cLP.getPbData().cKx() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aD);
                aVar.lq(1);
                aVar.aV(thread2GroupShareView);
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
                aVar.hK(true);
                aVar.b(pbFragment.getPageContext()).aYL();
                if (!k.isEmpty(aD.getImageUrl())) {
                    thread2GroupShareView.aF(aD.getImageUrl(), cLP.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
