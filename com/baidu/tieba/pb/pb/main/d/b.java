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
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes22.dex */
public class b {
    public static void a(Context context, by byVar, int i) {
        if (byVar != null && context != null) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i, c(context, byVar), true));
        }
    }

    private static ShareItem c(Context context, by byVar) {
        if (byVar == null || context == null) {
            return null;
        }
        String valueOf = String.valueOf(byVar.getFid());
        String boT = byVar.boT();
        if (byVar.eLS != null) {
            valueOf = byVar.eLS.id;
            boT = byVar.eLS.ori_fname;
        }
        String title = byVar.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = byVar.getAbstract();
        }
        String tid = byVar.getTid();
        String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
        String shareImageUrl = getShareImageUrl(byVar);
        Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
        String str2 = byVar.getAbstract();
        String format = MessageFormat.format(context.getResources().getString(R.string.share_content_tpl), title, str2);
        ShareItem shareItem = new ShareItem();
        shareItem.title = title;
        shareItem.content = format;
        shareItem.readCount = byVar.boH();
        shareItem.fnC = str2;
        shareItem.linkUrl = str;
        shareItem.eMJ = 2;
        shareItem.extData = tid;
        shareItem.fnF = 3;
        shareItem.fid = valueOf;
        shareItem.fName = boT;
        shareItem.tid = tid;
        shareItem.fnr = true;
        shareItem.fnE = 6;
        shareItem.fnJ = getStateThreadType(byVar);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.fnM = OriginalThreadInfo.ShareInfo.generateShareInfo(byVar);
        shareItem.fnN = ShareItem.ForwardInfo.generateForwardInfo(byVar, 1, null);
        shareItem.fnT = byVar.getShareImageUrl();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.fnF);
        bundle.putInt("obj_type", shareItem.fnJ);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putInt("obj_source", shareItem.eMJ);
        shareItem.ae(bundle);
        return shareItem;
    }

    private static String getShareImageUrl(by byVar) {
        String str;
        if (byVar == null || byVar.boY() == null) {
            return null;
        }
        ArrayList<MediaData> boY = byVar.boY();
        int size = boY.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = boY.get(i);
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
        if (str == null && byVar.bph() != null && !TextUtils.isEmpty(byVar.bph().thumbnail_url)) {
            return byVar.bph().thumbnail_url;
        }
        return str;
    }

    private static int getStateThreadType(by byVar) {
        if (byVar != null) {
            if (byVar.boR()) {
                return 4;
            }
            if (byVar.boM() == 1) {
                return 3;
            }
            return byVar.bqj() ? 2 : 1;
        }
        return 0;
    }

    public static void a(final PbFragment pbFragment, int i, int i2) {
        if (pbFragment != null && pbFragment.dok() != null && pbFragment.dpb() != null) {
            final PbModel dok = pbFragment.dok();
            final az dpb = pbFragment.dpb();
            if (dok.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                ShareItem a2 = a(pbFragment.getContext(), i, i2, dok);
                TbadkCoreApplication.getInst().setShareItem(a2);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), a2, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.b.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().dnu() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            dpb.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                shareDialogConfig.shareItem.ae(bundle);
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                f.ctk().b(shareDialogConfig);
            }
        }
    }

    public static ShareItem a(Context context, int i, int i2, PbModel pbModel) {
        String dqj;
        String str;
        String str2;
        com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
        String title = pbData.dmT().getTitle();
        int i3 = pbModel.getHostMode() ? 1 : 0;
        boolean z = false;
        if (pbData.getForum() != null) {
            if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.SQ(pbData.getForumId())) {
                z = true;
            }
        }
        by dmT = pbModel.getPbData().dmT();
        if (dmT.bnz()) {
            dqj = dmT.getBaijiahaoData().oriUgcTid;
            str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + dmT.getBaijiahaoData().oriUgcType + "&dvid=" + dmT.getBaijiahaoData().oriUgcVid + "&nid=" + dmT.getBaijiahaoData().oriUgcNid;
        } else {
            dqj = pbModel.dqj();
            str = "?share=9105&fr=share&see_lz=" + i3;
        }
        String str3 = "http://tieba.baidu.com/p/" + dqj + (str + "&share_from=post");
        String[] gr = pbData.gr(context);
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
            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                str2 = (TextUtils.isEmpty(title) || dmT.bqN() || dmT.bny()) ? gr[1] : title;
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
        } else {
            shareItem.readCount = pbData.dnr();
        }
        shareItem.linkUrl = str3;
        shareItem.fno = true;
        shareItem.fnx = z;
        shareItem.extData = pbModel.dqj();
        shareItem.fnF = 3;
        shareItem.fnE = i2;
        shareItem.fnG = getShareObjParam2(dmT);
        shareItem.fid = pbModel.getForumId();
        shareItem.tid = pbModel.dqj();
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
        if (dmT != null) {
            shareItem.fnT = dmT.getShareImageUrl();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.fnF);
        bundle.putInt("obj_type", shareItem.fnJ);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putString("uid", shareItem.uid);
        shareItem.ae(bundle);
        return shareItem;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static int I(com.baidu.tieba.pb.data.f fVar) {
        by dmT;
        if (fVar != null && (dmT = fVar.dmT()) != null) {
            if (dmT.boR()) {
                return 4;
            }
            if (dmT.boM() == 1) {
                return 3;
            }
            if (dmT.bqj()) {
                return 2;
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
            return dmT.bqN() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aB(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.dok() == null || pbFragment.dpb() == null) {
            return null;
        }
        PbModel dok = pbFragment.dok();
        az dpb = pbFragment.dpb();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] gr = dok.getPbData().gr(pbFragment.getContext());
        PostData dse = dpb.dse();
        String str = "";
        if (dse != null) {
            str = dse.getId();
            String gE = dse.gE(pbFragment.getContext());
            if (!k.isEmpty(gE)) {
                gr[1] = gE;
            }
        }
        String bpg = dok.getPbData().dmT().bpg();
        if (bpg != null && bpg.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(gr[1]);
        shareFromPBMsgData.setImageUrl(gr[0]);
        shareFromPBMsgData.setForumName(dok.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(dok.getPbData().dmT().getId());
        shareFromPBMsgData.setTitle(dok.getPbData().dmT().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel dok = pbFragment.dok();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (dok != null && dok.getPbData() != null && dok.getPbData().dmT() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.oT(1);
                aVar.bi(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.b.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            ar al = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).al("obj_source", 1).al("obj_param1", 3).dY("fid", PbModel.this.getForumId()).dY("tid", PbModel.this.dqj()).al("obj_locate", 1);
                            if (b.I(PbModel.this.getPbData()) != 0) {
                                al.al("obj_type", b.I(PbModel.this.getPbData()));
                            }
                            TiebaStatic.log(al);
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
                aVar.jm(true);
                aVar.b(pbFragment.getPageContext()).brv();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.aQ(aB.getImageUrl(), dok.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel dok = pbFragment.dok();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (dok != null && dok.getPbData() != null && dok.getPbData().dmT() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.oT(1);
                aVar.bi(thread2GroupShareView);
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
                aVar.jm(true);
                aVar.b(pbFragment.getPageContext()).brv();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.aQ(aB.getImageUrl(), dok.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
