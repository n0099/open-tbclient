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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.c.e;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.aq;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.Thread2GroupShareView;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class a {
    public static void a(Context context, bj bjVar, int i) {
        if (bjVar != null && context != null) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i, d(context, bjVar), true));
        }
    }

    private static ShareItem d(Context context, bj bjVar) {
        if (bjVar == null || context == null) {
            return null;
        }
        String valueOf = String.valueOf(bjVar.getFid());
        String aAc = bjVar.aAc();
        if (bjVar.cPX != null) {
            valueOf = bjVar.cPX.id;
            aAc = bjVar.cPX.ori_fname;
        }
        String title = bjVar.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = bjVar.getAbstract();
        }
        String tid = bjVar.getTid();
        String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
        String x = x(bjVar);
        Uri parse = x == null ? null : Uri.parse(x);
        String str2 = bjVar.getAbstract();
        String format = MessageFormat.format(context.getResources().getString(R.string.share_content_tpl), title, str2);
        ShareItem shareItem = new ShareItem();
        shareItem.title = title;
        shareItem.content = format;
        shareItem.dlS = str2;
        shareItem.linkUrl = str;
        shareItem.cQy = 2;
        shareItem.extData = tid;
        shareItem.dlV = 3;
        shareItem.fid = valueOf;
        shareItem.fName = aAc;
        shareItem.tid = tid;
        shareItem.dlJ = true;
        shareItem.dlU = 6;
        shareItem.dlZ = y(bjVar);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.dmc = OriginalThreadInfo.ShareInfo.generateShareInfo(bjVar);
        shareItem.dmd = ShareItem.ForwardInfo.generateForwardInfo(bjVar, 1, null);
        shareItem.dmj = bjVar.getShareImageUrl();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.dlV);
        bundle.putInt("obj_type", shareItem.dlZ);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putInt("obj_source", shareItem.cQy);
        shareItem.Y(bundle);
        return shareItem;
    }

    private static String x(bj bjVar) {
        String str;
        if (bjVar == null || bjVar.aAh() == null) {
            return null;
        }
        ArrayList<MediaData> aAh = bjVar.aAh();
        int size = aAh.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aAh.get(i);
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
        if (str == null && bjVar.aAo() != null && !TextUtils.isEmpty(bjVar.aAo().thumbnail_url)) {
            return bjVar.aAo().thumbnail_url;
        }
        return str;
    }

    private static int y(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.azZ()) {
                return 4;
            }
            if (bjVar.azU() == 1) {
                return 3;
            }
            return bjVar.aBm() ? 2 : 1;
        }
        return 0;
    }

    public static void a(final PbFragment pbFragment, int i, int i2) {
        if (pbFragment != null && pbFragment.ckc() != null && pbFragment.ckX() != null) {
            final PbModel ckc = pbFragment.ckc();
            final aq ckX = pbFragment.ckX();
            if (ckc.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                f pbData = ckc.getPbData();
                if (pbData.cjs() && !TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(pbFragment.getContext());
                    return;
                }
                String title = pbData.ciS().getTitle();
                int i3 = ckc.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Ii(pbData.getForumId())) {
                        z = true;
                    }
                }
                String str = "http://tieba.baidu.com/p/" + ckc.cmc() + "?share=9105&fr=share&see_lz=" + i3;
                String[] fg = pbData.fg(pbFragment.getContext());
                String str2 = fg[0];
                if (!StringUtils.isNull(str2) && str2.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str2 = str2.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str2 == null ? null : Uri.parse(str2);
                String str3 = fg[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new an("c10399").cp("fid", pbData.getForumId()).cp("tid", pbData.getThreadId()).cp("uid", currentAccount));
                }
                if (com.baidu.tbadk.core.util.aq.isEmpty(str3)) {
                    str3 = title;
                }
                ShareItem shareItem = new ShareItem();
                shareItem.title = title;
                shareItem.content = str3;
                shareItem.linkUrl = str;
                shareItem.dlG = true;
                shareItem.dlN = z;
                shareItem.extData = ckc.cmc();
                shareItem.dlV = 3;
                shareItem.dlU = i2;
                shareItem.fid = ckc.getForumId();
                shareItem.tid = ckc.cmc();
                shareItem.dlZ = B(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.cjs()) {
                    shareItem.dmf = false;
                    shareItem.canShareBySmartApp = false;
                }
                bj ciS = ckc.getPbData().ciS();
                shareItem.dmc = OriginalThreadInfo.ShareInfo.generateShareInfo(ciS);
                if (pbData != null && pbData.ciU() != null && pbData.ciU().size() > 0) {
                    shareItem.dmd = ShareItem.ForwardInfo.generateForwardInfo(ciS, 1, pbData.ciU().get(0));
                } else {
                    shareItem.dmd = ShareItem.ForwardInfo.generateForwardInfo(ciS, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (ciS != null) {
                    shareItem.dmj = ciS.getShareImageUrl();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.dlV);
                bundle.putInt("obj_type", shareItem.dlZ);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.Y(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().cjp() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            ckX.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                e.buG().b(shareDialogConfig);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int B(f fVar) {
        bj ciS;
        if (fVar != null && (ciS = fVar.ciS()) != null) {
            if (ciS.azZ()) {
                return 4;
            }
            if (ciS.azU() == 1) {
                return 3;
            }
            if (ciS.aBm()) {
                return 2;
            }
            if (ciS.ayL()) {
                return 5;
            }
            if (ciS.aBS()) {
                return 6;
            }
            if (ciS.aBT()) {
                return 7;
            }
            return ciS.aBU() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aB(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.ckc() == null || pbFragment.ckX() == null) {
            return null;
        }
        PbModel ckc = pbFragment.ckc();
        aq ckX = pbFragment.ckX();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] fg = ckc.getPbData().fg(pbFragment.getContext());
        PostData cnU = ckX.cnU();
        String str = "";
        if (cnU != null) {
            str = cnU.getId();
            String fw = cnU.fw(pbFragment.getContext());
            if (!k.isEmpty(fw)) {
                fg[1] = fw;
            }
        }
        String aAn = ckc.getPbData().ciS().aAn();
        if (aAn != null && aAn.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(fg[1]);
        shareFromPBMsgData.setImageUrl(fg[0]);
        shareFromPBMsgData.setForumName(ckc.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(ckc.getPbData().ciS().getId());
        shareFromPBMsgData.setTitle(ckc.getPbData().ciS().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel ckc = pbFragment.ckc();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (ckc != null && ckc.getPbData() != null && ckc.getPbData().ciS() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.jI(1);
                aVar.aO(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            an cp = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).Z("obj_source", 1).Z("obj_param1", 3).cp("fid", PbModel.this.getForumId()).cp("tid", PbModel.this.cmc());
                            if (a.B(PbModel.this.getPbData()) != 0) {
                                cp.Z("obj_type", a.B(PbModel.this.getPbData()));
                            }
                            TiebaStatic.log(cp);
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
                aVar.fA(true);
                aVar.b(pbFragment.getPageContext()).aCp();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.am(aB.getImageUrl(), ckc.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel ckc = pbFragment.ckc();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (ckc != null && ckc.getPbData() != null && ckc.getPbData().ciS() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.jI(1);
                aVar.aO(thread2GroupShareView);
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
                aVar.fA(true);
                aVar.b(pbFragment.getPageContext()).aCp();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.am(aB.getImageUrl(), ckc.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
