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
        String bke = bwVar.bke();
        if (bwVar.eAJ != null) {
            valueOf = bwVar.eAJ.id;
            bke = bwVar.eAJ.ori_fname;
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
        shareItem.readCount = bwVar.bjS();
        shareItem.fbd = str2;
        shareItem.linkUrl = str;
        shareItem.eBz = 2;
        shareItem.extData = tid;
        shareItem.fbg = 3;
        shareItem.fid = valueOf;
        shareItem.fName = bke;
        shareItem.tid = tid;
        shareItem.faS = true;
        shareItem.fbf = 6;
        shareItem.fbk = getStateThreadType(bwVar);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.fbn = OriginalThreadInfo.ShareInfo.generateShareInfo(bwVar);
        shareItem.fbo = ShareItem.ForwardInfo.generateForwardInfo(bwVar, 1, null);
        shareItem.fbu = bwVar.getShareImageUrl();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.fbg);
        bundle.putInt("obj_type", shareItem.fbk);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putInt("obj_source", shareItem.eBz);
        shareItem.ae(bundle);
        return shareItem;
    }

    private static String getShareImageUrl(bw bwVar) {
        String str;
        if (bwVar == null || bwVar.bkj() == null) {
            return null;
        }
        ArrayList<MediaData> bkj = bwVar.bkj();
        int size = bkj.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = bkj.get(i);
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
        if (str == null && bwVar.bks() != null && !TextUtils.isEmpty(bwVar.bks().thumbnail_url)) {
            return bwVar.bks().thumbnail_url;
        }
        return str;
    }

    private static int getStateThreadType(bw bwVar) {
        if (bwVar != null) {
            if (bwVar.bkc()) {
                return 4;
            }
            if (bwVar.bjX() == 1) {
                return 3;
            }
            return bwVar.bls() ? 2 : 1;
        }
        return 0;
    }

    public static void a(final PbFragment pbFragment, int i, int i2) {
        if (pbFragment != null && pbFragment.dgX() != null && pbFragment.dhN() != null) {
            final PbModel dgX = pbFragment.dgX();
            final az dhN = pbFragment.dhN();
            if (dgX.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                ShareItem a2 = a(pbFragment.getContext(), i, i2, dgX);
                TbadkCoreApplication.getInst().setShareItem(a2);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), a2, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().dgi() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            dhN.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                shareDialogConfig.shareItem.ae(bundle);
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                f.cmU().b(shareDialogConfig);
            }
        }
    }

    public static ShareItem a(Context context, int i, int i2, PbModel pbModel) {
        String diV;
        String str;
        String str2;
        com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
        String title = pbData.dfI().getTitle();
        int i3 = pbModel.getHostMode() ? 1 : 0;
        boolean z = false;
        if (pbData.getForum() != null) {
            if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.RK(pbData.getForumId())) {
                z = true;
            }
        }
        bw dfI = pbModel.getPbData().dfI();
        if (dfI.biK()) {
            diV = dfI.getBaijiahaoData().oriUgcTid;
            str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + dfI.getBaijiahaoData().oriUgcType + "&dvid=" + dfI.getBaijiahaoData().oriUgcVid + "&nid=" + dfI.getBaijiahaoData().oriUgcNid;
        } else {
            diV = pbModel.diV();
            str = "?share=9105&fr=share&see_lz=" + i3;
        }
        String str3 = "http://tieba.baidu.com/p/" + diV + (str + "&share_from=post");
        String[] fJ = pbData.fJ(context);
        String str4 = fJ[0];
        if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
            str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
        }
        Uri parse = str4 == null ? null : Uri.parse(str4);
        String str5 = fJ[1];
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (i == 1) {
            TiebaStatic.log(new aq("c10399").dR("fid", pbData.getForumId()).dR("tid", pbData.getThreadId()).dR("uid", currentAccount));
        }
        String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
        if (pbData.dgl() && dfI.bka() != null) {
            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                str2 = (TextUtils.isEmpty(title) || dfI.blW() || dfI.biJ()) ? fJ[1] : title;
                title = MessageFormat.format(string, dfI.bka().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
        if (pbData.dgl()) {
            shareItem.fbd = cutString2;
            shareItem.readCount = -1L;
        } else {
            shareItem.readCount = pbData.dgg();
        }
        shareItem.linkUrl = str3;
        shareItem.faP = true;
        shareItem.faY = z;
        shareItem.extData = pbModel.diV();
        shareItem.fbg = 3;
        shareItem.fbf = i2;
        shareItem.fbh = getShareObjParam2(dfI);
        shareItem.fid = pbModel.getForumId();
        shareItem.tid = pbModel.diV();
        shareItem.fbk = F(pbData);
        shareItem.uid = TbadkCoreApplication.getCurrentAccount();
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        if (pbData.dgl()) {
            shareItem.canShareBySmartApp = false;
        }
        shareItem.fbn = OriginalThreadInfo.ShareInfo.generateShareInfo(dfI);
        if (pbData != null && pbData.dfK() != null && pbData.dfK().size() > 0) {
            shareItem.fbo = ShareItem.ForwardInfo.generateForwardInfo(dfI, 1, pbData.dfK().get(0));
        } else {
            shareItem.fbo = ShareItem.ForwardInfo.generateForwardInfo(dfI, 1, null);
        }
        if (dfI != null) {
            shareItem.fbu = dfI.getShareImageUrl();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.fbg);
        bundle.putInt("obj_type", shareItem.fbk);
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
        if (bwVar.biI()) {
            return 10;
        }
        if (bwVar.biJ()) {
            return 9;
        }
        if (bwVar.blW()) {
            return 8;
        }
        if (bwVar.blV()) {
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
        bw dfI;
        if (fVar != null && (dfI = fVar.dfI()) != null) {
            if (dfI.bkc()) {
                return 4;
            }
            if (dfI.bjX() == 1) {
                return 3;
            }
            if (dfI.bls()) {
                return 2;
            }
            if (dfI.biI()) {
                return 5;
            }
            if (dfI.biJ()) {
                return 6;
            }
            if (dfI.blV()) {
                return 7;
            }
            return dfI.blW() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aE(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.dgX() == null || pbFragment.dhN() == null) {
            return null;
        }
        PbModel dgX = pbFragment.dgX();
        az dhN = pbFragment.dhN();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] fJ = dgX.getPbData().fJ(pbFragment.getContext());
        PostData dkN = dhN.dkN();
        String str = "";
        if (dkN != null) {
            str = dkN.getId();
            String fU = dkN.fU(pbFragment.getContext());
            if (!k.isEmpty(fU)) {
                fJ[1] = fU;
            }
        }
        String bkr = dgX.getPbData().dfI().bkr();
        if (bkr != null && bkr.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(fJ[1]);
        shareFromPBMsgData.setImageUrl(fJ[0]);
        shareFromPBMsgData.setForumName(dgX.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(dgX.getPbData().dfI().getId());
        shareFromPBMsgData.setTitle(dgX.getPbData().dfI().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel dgX = pbFragment.dgX();
            final ShareFromPBMsgData aE = aE(pbFragment);
            if (dgX != null && dgX.getPbData() != null && dgX.getPbData().dfI() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aE);
                aVar.op(1);
                aVar.bb(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            aq aj = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).aj("obj_source", 1).aj("obj_param1", 3).dR("fid", PbModel.this.getForumId()).dR("tid", PbModel.this.diV()).aj("obj_locate", 1);
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
                aVar.iN(true);
                aVar.b(pbFragment.getPageContext()).bmC();
                if (!k.isEmpty(aE.getImageUrl())) {
                    thread2GroupShareView.aP(aE.getImageUrl(), dgX.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel dgX = pbFragment.dgX();
            final ShareFromPBMsgData aE = aE(pbFragment);
            if (dgX != null && dgX.getPbData() != null && dgX.getPbData().dfI() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aE);
                aVar.op(1);
                aVar.bb(thread2GroupShareView);
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
                aVar.iN(true);
                aVar.b(pbFragment.getPageContext()).bmC();
                if (!k.isEmpty(aE.getImageUrl())) {
                    thread2GroupShareView.aP(aE.getImageUrl(), dgX.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
