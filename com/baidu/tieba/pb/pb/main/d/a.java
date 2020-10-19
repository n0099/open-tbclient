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
/* loaded from: classes22.dex */
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
        String bil = bwVar.bil();
        if (bwVar.esj != null) {
            valueOf = bwVar.esj.id;
            bil = bwVar.esj.ori_fname;
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
        shareItem.readCount = bwVar.bhZ();
        shareItem.eSH = str2;
        shareItem.linkUrl = str;
        shareItem.esZ = 2;
        shareItem.extData = tid;
        shareItem.eSK = 3;
        shareItem.fid = valueOf;
        shareItem.fName = bil;
        shareItem.tid = tid;
        shareItem.eSw = true;
        shareItem.eSJ = 6;
        shareItem.eSO = getStateThreadType(bwVar);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.eSR = OriginalThreadInfo.ShareInfo.generateShareInfo(bwVar);
        shareItem.eSS = ShareItem.ForwardInfo.generateForwardInfo(bwVar, 1, null);
        shareItem.eSY = bwVar.getShareImageUrl();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.eSK);
        bundle.putInt("obj_type", shareItem.eSO);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putInt("obj_source", shareItem.esZ);
        shareItem.ae(bundle);
        return shareItem;
    }

    private static String getShareImageUrl(bw bwVar) {
        String str;
        if (bwVar == null || bwVar.biq() == null) {
            return null;
        }
        ArrayList<MediaData> biq = bwVar.biq();
        int size = biq.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = biq.get(i);
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
        if (str == null && bwVar.biz() != null && !TextUtils.isEmpty(bwVar.biz().thumbnail_url)) {
            return bwVar.biz().thumbnail_url;
        }
        return str;
    }

    private static int getStateThreadType(bw bwVar) {
        if (bwVar != null) {
            if (bwVar.bij()) {
                return 4;
            }
            if (bwVar.bie() == 1) {
                return 3;
            }
            return bwVar.bjz() ? 2 : 1;
        }
        return 0;
    }

    public static void a(final PbFragment pbFragment, int i, int i2) {
        if (pbFragment != null && pbFragment.ddQ() != null && pbFragment.deG() != null) {
            final PbModel ddQ = pbFragment.ddQ();
            final az deG = pbFragment.deG();
            if (ddQ.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                ShareItem a2 = a(pbFragment.getContext(), i, i2, ddQ);
                TbadkCoreApplication.getInst().setShareItem(a2);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), a2, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().dda() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            deG.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                shareDialogConfig.shareItem.ae(bundle);
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                f.cjN().b(shareDialogConfig);
            }
        }
    }

    public static ShareItem a(Context context, int i, int i2, PbModel pbModel) {
        String dfO;
        String str;
        String str2;
        com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
        String title = pbData.dcA().getTitle();
        int i3 = pbModel.getHostMode() ? 1 : 0;
        boolean z = false;
        if (pbData.getForum() != null) {
            if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Rl(pbData.getForumId())) {
                z = true;
            }
        }
        bw dcA = pbModel.getPbData().dcA();
        if (dcA.bgR()) {
            dfO = dcA.getBaijiahaoData().oriUgcTid;
            str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + dcA.getBaijiahaoData().oriUgcType + "&dvid=" + dcA.getBaijiahaoData().oriUgcVid + "&nid=" + dcA.getBaijiahaoData().oriUgcNid;
        } else {
            dfO = pbModel.dfO();
            str = "?share=9105&fr=share&see_lz=" + i3;
        }
        String str3 = "http://tieba.baidu.com/p/" + dfO + (str + "&share_from=post");
        String[] fI = pbData.fI(context);
        String str4 = fI[0];
        if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
            str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
        }
        Uri parse = str4 == null ? null : Uri.parse(str4);
        String str5 = fI[1];
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (i == 1) {
            TiebaStatic.log(new aq("c10399").dK("fid", pbData.getForumId()).dK("tid", pbData.getThreadId()).dK("uid", currentAccount));
        }
        String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
        if (pbData.ddd() && dcA.bih() != null) {
            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                str2 = (TextUtils.isEmpty(title) || dcA.bkd() || dcA.bgQ()) ? fI[1] : title;
                title = MessageFormat.format(string, dcA.bih().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
        if (pbData.ddd()) {
            shareItem.eSH = cutString2;
            shareItem.readCount = -1L;
        } else {
            shareItem.readCount = pbData.dcY();
        }
        shareItem.linkUrl = str3;
        shareItem.eSt = true;
        shareItem.eSC = z;
        shareItem.extData = pbModel.dfO();
        shareItem.eSK = 3;
        shareItem.eSJ = i2;
        shareItem.eSL = getShareObjParam2(dcA);
        shareItem.fid = pbModel.getForumId();
        shareItem.tid = pbModel.dfO();
        shareItem.eSO = F(pbData);
        shareItem.uid = TbadkCoreApplication.getCurrentAccount();
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        if (pbData.ddd()) {
            shareItem.canShareBySmartApp = false;
        }
        shareItem.eSR = OriginalThreadInfo.ShareInfo.generateShareInfo(dcA);
        if (pbData != null && pbData.dcC() != null && pbData.dcC().size() > 0) {
            shareItem.eSS = ShareItem.ForwardInfo.generateForwardInfo(dcA, 1, pbData.dcC().get(0));
        } else {
            shareItem.eSS = ShareItem.ForwardInfo.generateForwardInfo(dcA, 1, null);
        }
        if (dcA != null) {
            shareItem.eSY = dcA.getShareImageUrl();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.eSK);
        bundle.putInt("obj_type", shareItem.eSO);
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
        if (bwVar.bgP()) {
            return 10;
        }
        if (bwVar.bgQ()) {
            return 9;
        }
        if (bwVar.bkd()) {
            return 8;
        }
        if (bwVar.bkc()) {
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
        bw dcA;
        if (fVar != null && (dcA = fVar.dcA()) != null) {
            if (dcA.bij()) {
                return 4;
            }
            if (dcA.bie() == 1) {
                return 3;
            }
            if (dcA.bjz()) {
                return 2;
            }
            if (dcA.bgP()) {
                return 5;
            }
            if (dcA.bgQ()) {
                return 6;
            }
            if (dcA.bkc()) {
                return 7;
            }
            return dcA.bkd() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aE(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.ddQ() == null || pbFragment.deG() == null) {
            return null;
        }
        PbModel ddQ = pbFragment.ddQ();
        az deG = pbFragment.deG();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] fI = ddQ.getPbData().fI(pbFragment.getContext());
        PostData dhG = deG.dhG();
        String str = "";
        if (dhG != null) {
            str = dhG.getId();
            String fT = dhG.fT(pbFragment.getContext());
            if (!k.isEmpty(fT)) {
                fI[1] = fT;
            }
        }
        String biy = ddQ.getPbData().dcA().biy();
        if (biy != null && biy.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(fI[1]);
        shareFromPBMsgData.setImageUrl(fI[0]);
        shareFromPBMsgData.setForumName(ddQ.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(ddQ.getPbData().dcA().getId());
        shareFromPBMsgData.setTitle(ddQ.getPbData().dcA().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel ddQ = pbFragment.ddQ();
            final ShareFromPBMsgData aE = aE(pbFragment);
            if (ddQ != null && ddQ.getPbData() != null && ddQ.getPbData().dcA() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aE);
                aVar.oe(1);
                aVar.ba(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            aq aj = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).aj("obj_source", 1).aj("obj_param1", 3).dK("fid", PbModel.this.getForumId()).dK("tid", PbModel.this.dfO()).aj("obj_locate", 1);
                            if (a.F(PbModel.this.getPbData()) != 0) {
                                aj.aj("obj_type", a.F(PbModel.this.getPbData()));
                            }
                            TiebaStatic.log(aj);
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
                aVar.iA(true);
                aVar.b(pbFragment.getPageContext()).bkJ();
                if (!k.isEmpty(aE.getImageUrl())) {
                    thread2GroupShareView.aN(aE.getImageUrl(), ddQ.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel ddQ = pbFragment.ddQ();
            final ShareFromPBMsgData aE = aE(pbFragment);
            if (ddQ != null && ddQ.getPbData() != null && ddQ.getPbData().dcA() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aE);
                aVar.oe(1);
                aVar.ba(thread2GroupShareView);
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
                aVar.iA(true);
                aVar.b(pbFragment.getPageContext()).bkJ();
                if (!k.isEmpty(aE.getImageUrl())) {
                    thread2GroupShareView.aN(aE.getImageUrl(), ddQ.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
