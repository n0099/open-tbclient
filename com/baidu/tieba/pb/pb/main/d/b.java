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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
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
    public static void a(Context context, cb cbVar, int i) {
        if (cbVar != null && context != null) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i, c(context, cbVar), true));
        }
    }

    private static ShareItem c(Context context, cb cbVar) {
        if (cbVar == null || context == null) {
            return null;
        }
        String valueOf = String.valueOf(cbVar.getFid());
        String bnU = cbVar.bnU();
        if (cbVar.eTn != null) {
            valueOf = cbVar.eTn.id;
            bnU = cbVar.eTn.ori_fname;
        }
        String title = cbVar.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = cbVar.getAbstract();
        }
        String tid = cbVar.getTid();
        String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
        String shareImageUrl = getShareImageUrl(cbVar);
        Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
        String str2 = cbVar.getAbstract();
        String format = MessageFormat.format(context.getResources().getString(R.string.share_content_tpl), title, str2);
        ShareItem shareItem = new ShareItem();
        shareItem.title = title;
        shareItem.content = format;
        shareItem.readCount = cbVar.bnI();
        shareItem.fuV = str2;
        shareItem.linkUrl = str;
        shareItem.eUk = 2;
        shareItem.extData = tid;
        shareItem.fuY = 3;
        shareItem.fid = valueOf;
        shareItem.fName = bnU;
        shareItem.tid = tid;
        shareItem.fuK = true;
        shareItem.fuX = 6;
        shareItem.fvc = getStateThreadType(cbVar);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.fvf = OriginalThreadInfo.ShareInfo.generateShareInfo(cbVar);
        shareItem.fvg = ShareItem.ForwardInfo.generateForwardInfo(cbVar, 1, null);
        shareItem.fvm = cbVar.getShareImageUrl();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.fuY);
        bundle.putInt("obj_type", shareItem.fvc);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putInt("obj_source", shareItem.eUk);
        shareItem.ae(bundle);
        return shareItem;
    }

    private static String getShareImageUrl(cb cbVar) {
        String str;
        if (cbVar == null || cbVar.bnZ() == null) {
            return null;
        }
        ArrayList<MediaData> bnZ = cbVar.bnZ();
        int size = bnZ.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = bnZ.get(i);
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
        if (str == null && cbVar.boh() != null && !TextUtils.isEmpty(cbVar.boh().thumbnail_url)) {
            return cbVar.boh().thumbnail_url;
        }
        return str;
    }

    private static int getStateThreadType(cb cbVar) {
        if (cbVar != null) {
            if (cbVar.bnS()) {
                return 4;
            }
            if (cbVar.bnN() == 1) {
                return 3;
            }
            return cbVar.bpk() ? 2 : 1;
        }
        return 0;
    }

    public static void a(final PbFragment pbFragment, int i, int i2) {
        if (pbFragment != null && pbFragment.dmx() != null && pbFragment.dnr() != null) {
            final PbModel dmx = pbFragment.dmx();
            final ap dnr = pbFragment.dnr();
            if (dmx.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                ShareItem a2 = a(pbFragment.getContext(), i, i2, dmx);
                TbadkCoreApplication.getInst().setShareItem(a2);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), a2, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.b.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().dlG() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            dnr.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                shareDialogConfig.shareItem.ae(bundle);
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                f.ctG().b(shareDialogConfig);
            }
        }
    }

    public static ShareItem a(Context context, int i, int i2, PbModel pbModel) {
        String doA;
        String str;
        String str2;
        String str3;
        com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
        String title = pbData.dlg().getTitle();
        int i3 = pbModel.getHostMode() ? 1 : 0;
        boolean z = false;
        if (pbData.getForum() != null) {
            if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.SA(pbData.getForumId())) {
                z = true;
            }
        }
        cb dlg = pbModel.getPbData().dlg();
        if (dlg.bmz()) {
            doA = dlg.getBaijiahaoData().oriUgcTid;
            str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + dlg.getBaijiahaoData().oriUgcType + "&dvid=" + dlg.getBaijiahaoData().oriUgcVid + "&nid=" + dlg.getBaijiahaoData().oriUgcNid;
        } else {
            doA = pbModel.doA();
            str = "?share=9105&fr=share&see_lz=" + i3;
        }
        String str4 = "http://tieba.baidu.com/p/" + doA + (str + "&share_from=post");
        String[] gL = pbData.gL(context);
        String str5 = gL[0];
        if (!StringUtils.isNull(str5) && str5.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
            str5 = str5.substring(TbConfig.URL_IMAGE_PREFIX.length());
        }
        Uri parse = str5 == null ? null : Uri.parse(str5);
        String str6 = gL[1];
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (i == 1) {
            TiebaStatic.log(new ar("c10399").dR("fid", pbData.getForumId()).dR("tid", pbData.getThreadId()).dR("uid", currentAccount));
        }
        String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
        if (pbData.dlJ() && dlg.bnQ() != null) {
            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str6)) {
                String str7 = (TextUtils.isEmpty(title) || dlg.bpO() || dlg.bmy()) ? gL[1] : title;
                str2 = MessageFormat.format(string, dlg.bnQ().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                str3 = str7;
            } else {
                str2 = str6;
                str3 = title;
            }
        } else if (au.isEmpty(str6)) {
            str2 = title;
            str3 = title;
        } else {
            str2 = str6;
            str3 = title;
        }
        String cutString = au.cutString(str3, 100);
        String cutString2 = au.cutString(str2, 100);
        ShareItem shareItem = new ShareItem();
        shareItem.title = cutString;
        shareItem.content = cutString2;
        if (pbData.dlJ()) {
            shareItem.fuV = cutString2;
            shareItem.readCount = -1L;
        } else {
            shareItem.readCount = pbData.dlE();
        }
        shareItem.linkUrl = str4;
        shareItem.fuH = true;
        shareItem.fuQ = z;
        shareItem.extData = pbModel.doA();
        shareItem.fuY = 3;
        shareItem.fuX = i2;
        shareItem.fuZ = getShareObjParam2(dlg);
        shareItem.fid = pbModel.getForumId();
        shareItem.tid = pbModel.doA();
        shareItem.fvc = I(pbData);
        shareItem.uid = TbadkCoreApplication.getCurrentAccount();
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        if (pbData.dlJ()) {
            shareItem.canShareBySmartApp = false;
        }
        shareItem.fvf = OriginalThreadInfo.ShareInfo.generateShareInfo(dlg);
        if (pbData != null && pbData.dli() != null && pbData.dli().size() > 0) {
            shareItem.fvg = ShareItem.ForwardInfo.generateForwardInfo(dlg, 1, pbData.dli().get(0));
        } else {
            shareItem.fvg = ShareItem.ForwardInfo.generateForwardInfo(dlg, 1, null);
        }
        if (dlg != null) {
            shareItem.fvm = dlg.getShareImageUrl();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.fuY);
        bundle.putInt("obj_type", shareItem.fvc);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putString("uid", shareItem.uid);
        shareItem.ae(bundle);
        return shareItem;
    }

    private static int getShareObjParam2(cb cbVar) {
        if (cbVar == null) {
            return 0;
        }
        if (cbVar.bmx()) {
            return 10;
        }
        if (cbVar.bmy()) {
            return 9;
        }
        if (cbVar.bpO()) {
            return 8;
        }
        if (cbVar.bpN()) {
            return 7;
        }
        if (cbVar.isShareThread) {
            return 6;
        }
        if (cbVar.threadType == 0) {
            return 1;
        }
        if (cbVar.threadType == 40) {
            return 2;
        }
        if (cbVar.threadType == 49) {
            return 3;
        }
        if (cbVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int I(com.baidu.tieba.pb.data.f fVar) {
        cb dlg;
        if (fVar != null && (dlg = fVar.dlg()) != null) {
            if (dlg.bnS()) {
                return 4;
            }
            if (dlg.bnN() == 1) {
                return 3;
            }
            if (dlg.bpk()) {
                return 2;
            }
            if (dlg.bmx()) {
                return 5;
            }
            if (dlg.bmy()) {
                return 6;
            }
            if (dlg.bpN()) {
                return 7;
            }
            return dlg.bpO() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aB(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.dmx() == null || pbFragment.dnr() == null) {
            return null;
        }
        PbModel dmx = pbFragment.dmx();
        ap dnr = pbFragment.dnr();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] gL = dmx.getPbData().gL(pbFragment.getContext());
        PostData dqv = dnr.dqv();
        String str = "";
        if (dqv != null) {
            str = dqv.getId();
            String gX = dqv.gX(pbFragment.getContext());
            if (!k.isEmpty(gX)) {
                gL[1] = gX;
            }
        }
        String bog = dmx.getPbData().dlg().bog();
        if (bog != null && bog.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(gL[1]);
        shareFromPBMsgData.setImageUrl(gL[0]);
        shareFromPBMsgData.setForumName(dmx.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(dmx.getPbData().dlg().getId());
        shareFromPBMsgData.setTitle(dmx.getPbData().dlg().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel dmx = pbFragment.dmx();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (dmx != null && dmx.getPbData() != null && dmx.getPbData().dlg() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.nA(1);
                aVar.bn(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.b.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            ar ap = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ap("obj_source", 1).ap("obj_param1", 3).dR("fid", PbModel.this.getForumId()).dR("tid", PbModel.this.doA()).ap("obj_locate", 1);
                            if (b.I(PbModel.this.getPbData()) != 0) {
                                ap.ap("obj_type", b.I(PbModel.this.getPbData()));
                            }
                            TiebaStatic.log(ap);
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
                aVar.jG(true);
                aVar.b(pbFragment.getPageContext()).bqx();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.aP(aB.getImageUrl(), dmx.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel dmx = pbFragment.dmx();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (dmx != null && dmx.getPbData() != null && dmx.getPbData().dlg() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.nA(1);
                aVar.bn(thread2GroupShareView);
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
                aVar.jG(true);
                aVar.b(pbFragment.getPageContext()).bqx();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.aP(aB.getImageUrl(), dmx.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
