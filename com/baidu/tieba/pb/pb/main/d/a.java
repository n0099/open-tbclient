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
        String bmE = bwVar.bmE();
        if (bwVar.eGy != null) {
            valueOf = bwVar.eGy.id;
            bmE = bwVar.eGy.ori_fname;
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
        shareItem.readCount = bwVar.bms();
        shareItem.fgU = str2;
        shareItem.linkUrl = str;
        shareItem.eHo = 2;
        shareItem.extData = tid;
        shareItem.fgX = 3;
        shareItem.fid = valueOf;
        shareItem.fName = bmE;
        shareItem.tid = tid;
        shareItem.fgJ = true;
        shareItem.fgW = 6;
        shareItem.fhb = getStateThreadType(bwVar);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.fhe = OriginalThreadInfo.ShareInfo.generateShareInfo(bwVar);
        shareItem.fhf = ShareItem.ForwardInfo.generateForwardInfo(bwVar, 1, null);
        shareItem.fhl = bwVar.getShareImageUrl();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.fgX);
        bundle.putInt("obj_type", shareItem.fhb);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putInt("obj_source", shareItem.eHo);
        shareItem.ae(bundle);
        return shareItem;
    }

    private static String getShareImageUrl(bw bwVar) {
        String str;
        if (bwVar == null || bwVar.bmJ() == null) {
            return null;
        }
        ArrayList<MediaData> bmJ = bwVar.bmJ();
        int size = bmJ.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = bmJ.get(i);
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
        if (str == null && bwVar.bmS() != null && !TextUtils.isEmpty(bwVar.bmS().thumbnail_url)) {
            return bwVar.bmS().thumbnail_url;
        }
        return str;
    }

    private static int getStateThreadType(bw bwVar) {
        if (bwVar != null) {
            if (bwVar.bmC()) {
                return 4;
            }
            if (bwVar.bmx() == 1) {
                return 3;
            }
            return bwVar.bnS() ? 2 : 1;
        }
        return 0;
    }

    public static void a(final PbFragment pbFragment, int i, int i2) {
        if (pbFragment != null && pbFragment.djz() != null && pbFragment.dkp() != null) {
            final PbModel djz = pbFragment.djz();
            final az dkp = pbFragment.dkp();
            if (djz.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                ShareItem a2 = a(pbFragment.getContext(), i, i2, djz);
                TbadkCoreApplication.getInst().setShareItem(a2);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), a2, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().diK() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            dkp.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                shareDialogConfig.shareItem.ae(bundle);
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                f.cpv().b(shareDialogConfig);
            }
        }
    }

    public static ShareItem a(Context context, int i, int i2, PbModel pbModel) {
        String dlx;
        String str;
        String str2;
        com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
        String title = pbData.dik().getTitle();
        int i3 = pbModel.getHostMode() ? 1 : 0;
        boolean z = false;
        if (pbData.getForum() != null) {
            if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Sb(pbData.getForumId())) {
                z = true;
            }
        }
        bw dik = pbModel.getPbData().dik();
        if (dik.blk()) {
            dlx = dik.getBaijiahaoData().oriUgcTid;
            str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + dik.getBaijiahaoData().oriUgcType + "&dvid=" + dik.getBaijiahaoData().oriUgcVid + "&nid=" + dik.getBaijiahaoData().oriUgcNid;
        } else {
            dlx = pbModel.dlx();
            str = "?share=9105&fr=share&see_lz=" + i3;
        }
        String str3 = "http://tieba.baidu.com/p/" + dlx + (str + "&share_from=post");
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
        if (pbData.diN() && dik.bmA() != null) {
            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                str2 = (TextUtils.isEmpty(title) || dik.bow() || dik.blj()) ? fJ[1] : title;
                title = MessageFormat.format(string, dik.bmA().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
        if (pbData.diN()) {
            shareItem.fgU = cutString2;
            shareItem.readCount = -1L;
        } else {
            shareItem.readCount = pbData.diI();
        }
        shareItem.linkUrl = str3;
        shareItem.fgG = true;
        shareItem.fgP = z;
        shareItem.extData = pbModel.dlx();
        shareItem.fgX = 3;
        shareItem.fgW = i2;
        shareItem.fgY = getShareObjParam2(dik);
        shareItem.fid = pbModel.getForumId();
        shareItem.tid = pbModel.dlx();
        shareItem.fhb = F(pbData);
        shareItem.uid = TbadkCoreApplication.getCurrentAccount();
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        if (pbData.diN()) {
            shareItem.canShareBySmartApp = false;
        }
        shareItem.fhe = OriginalThreadInfo.ShareInfo.generateShareInfo(dik);
        if (pbData != null && pbData.dim() != null && pbData.dim().size() > 0) {
            shareItem.fhf = ShareItem.ForwardInfo.generateForwardInfo(dik, 1, pbData.dim().get(0));
        } else {
            shareItem.fhf = ShareItem.ForwardInfo.generateForwardInfo(dik, 1, null);
        }
        if (dik != null) {
            shareItem.fhl = dik.getShareImageUrl();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.fgX);
        bundle.putInt("obj_type", shareItem.fhb);
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
        if (bwVar.bli()) {
            return 10;
        }
        if (bwVar.blj()) {
            return 9;
        }
        if (bwVar.bow()) {
            return 8;
        }
        if (bwVar.bov()) {
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
        bw dik;
        if (fVar != null && (dik = fVar.dik()) != null) {
            if (dik.bmC()) {
                return 4;
            }
            if (dik.bmx() == 1) {
                return 3;
            }
            if (dik.bnS()) {
                return 2;
            }
            if (dik.bli()) {
                return 5;
            }
            if (dik.blj()) {
                return 6;
            }
            if (dik.bov()) {
                return 7;
            }
            return dik.bow() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aE(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.djz() == null || pbFragment.dkp() == null) {
            return null;
        }
        PbModel djz = pbFragment.djz();
        az dkp = pbFragment.dkp();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] fJ = djz.getPbData().fJ(pbFragment.getContext());
        PostData dnp = dkp.dnp();
        String str = "";
        if (dnp != null) {
            str = dnp.getId();
            String fU = dnp.fU(pbFragment.getContext());
            if (!k.isEmpty(fU)) {
                fJ[1] = fU;
            }
        }
        String bmR = djz.getPbData().dik().bmR();
        if (bmR != null && bmR.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(fJ[1]);
        shareFromPBMsgData.setImageUrl(fJ[0]);
        shareFromPBMsgData.setForumName(djz.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(djz.getPbData().dik().getId());
        shareFromPBMsgData.setTitle(djz.getPbData().dik().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel djz = pbFragment.djz();
            final ShareFromPBMsgData aE = aE(pbFragment);
            if (djz != null && djz.getPbData() != null && djz.getPbData().dik() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aE);
                aVar.oz(1);
                aVar.bf(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            aq al = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).al("obj_source", 1).al("obj_param1", 3).dR("fid", PbModel.this.getForumId()).dR("tid", PbModel.this.dlx()).al("obj_locate", 1);
                            if (a.F(PbModel.this.getPbData()) != 0) {
                                al.al("obj_type", a.F(PbModel.this.getPbData()));
                            }
                            TiebaStatic.log(al);
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
                aVar.iW(true);
                aVar.b(pbFragment.getPageContext()).bpc();
                if (!k.isEmpty(aE.getImageUrl())) {
                    thread2GroupShareView.aP(aE.getImageUrl(), djz.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel djz = pbFragment.djz();
            final ShareFromPBMsgData aE = aE(pbFragment);
            if (djz != null && djz.getPbData() != null && djz.getPbData().dik() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aE);
                aVar.oz(1);
                aVar.bf(thread2GroupShareView);
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
                aVar.iW(true);
                aVar.b(pbFragment.getPageContext()).bpc();
                if (!k.isEmpty(aE.getImageUrl())) {
                    thread2GroupShareView.aP(aE.getImageUrl(), djz.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
