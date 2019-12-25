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
/* loaded from: classes6.dex */
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
        String azJ = bjVar.azJ();
        if (bjVar.cPN != null) {
            valueOf = bjVar.cPN.id;
            azJ = bjVar.cPN.ori_fname;
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
        shareItem.dlC = str2;
        shareItem.linkUrl = str;
        shareItem.cQo = 2;
        shareItem.extData = tid;
        shareItem.dlF = 3;
        shareItem.fid = valueOf;
        shareItem.fName = azJ;
        shareItem.tid = tid;
        shareItem.dlt = true;
        shareItem.dlE = 6;
        shareItem.dlJ = y(bjVar);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.dlM = OriginalThreadInfo.ShareInfo.generateShareInfo(bjVar);
        shareItem.dlN = ShareItem.ForwardInfo.generateForwardInfo(bjVar, 1, null);
        shareItem.dlT = bjVar.getShareImageUrl();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.dlF);
        bundle.putInt("obj_type", shareItem.dlJ);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putInt("obj_source", shareItem.cQo);
        shareItem.Y(bundle);
        return shareItem;
    }

    private static String x(bj bjVar) {
        String str;
        if (bjVar == null || bjVar.azO() == null) {
            return null;
        }
        ArrayList<MediaData> azO = bjVar.azO();
        int size = azO.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = azO.get(i);
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
        if (str == null && bjVar.azV() != null && !TextUtils.isEmpty(bjVar.azV().thumbnail_url)) {
            return bjVar.azV().thumbnail_url;
        }
        return str;
    }

    private static int y(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.azG()) {
                return 4;
            }
            if (bjVar.azB() == 1) {
                return 3;
            }
            return bjVar.aAT() ? 2 : 1;
        }
        return 0;
    }

    public static void a(final PbFragment pbFragment, int i, int i2) {
        if (pbFragment != null && pbFragment.ciU() != null && pbFragment.cjP() != null) {
            final PbModel ciU = pbFragment.ciU();
            final aq cjP = pbFragment.cjP();
            if (ciU.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                f pbData = ciU.getPbData();
                if (pbData.cik() && !TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(pbFragment.getContext());
                    return;
                }
                String title = pbData.chK().getTitle();
                int i3 = ciU.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.HY(pbData.getForumId())) {
                        z = true;
                    }
                }
                String str = "http://tieba.baidu.com/p/" + ciU.ckU() + "?share=9105&fr=share&see_lz=" + i3;
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
                shareItem.dlq = true;
                shareItem.dlx = z;
                shareItem.extData = ciU.ckU();
                shareItem.dlF = 3;
                shareItem.dlE = i2;
                shareItem.fid = ciU.getForumId();
                shareItem.tid = ciU.ckU();
                shareItem.dlJ = B(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.cik()) {
                    shareItem.dlP = false;
                    shareItem.canShareBySmartApp = false;
                }
                bj chK = ciU.getPbData().chK();
                shareItem.dlM = OriginalThreadInfo.ShareInfo.generateShareInfo(chK);
                if (pbData != null && pbData.chM() != null && pbData.chM().size() > 0) {
                    shareItem.dlN = ShareItem.ForwardInfo.generateForwardInfo(chK, 1, pbData.chM().get(0));
                } else {
                    shareItem.dlN = ShareItem.ForwardInfo.generateForwardInfo(chK, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (chK != null) {
                    shareItem.dlT = chK.getShareImageUrl();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.dlF);
                bundle.putInt("obj_type", shareItem.dlJ);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.Y(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().cih() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            cjP.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                e.btE().a(shareDialogConfig);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int B(f fVar) {
        bj chK;
        if (fVar != null && (chK = fVar.chK()) != null) {
            if (chK.azG()) {
                return 4;
            }
            if (chK.azB() == 1) {
                return 3;
            }
            if (chK.aAT()) {
                return 2;
            }
            if (chK.ays()) {
                return 5;
            }
            if (chK.aBz()) {
                return 6;
            }
            if (chK.aBA()) {
                return 7;
            }
            return chK.aBB() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aB(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.ciU() == null || pbFragment.cjP() == null) {
            return null;
        }
        PbModel ciU = pbFragment.ciU();
        aq cjP = pbFragment.cjP();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] fg = ciU.getPbData().fg(pbFragment.getContext());
        PostData cmN = cjP.cmN();
        String str = "";
        if (cmN != null) {
            str = cmN.getId();
            String fv = cmN.fv(pbFragment.getContext());
            if (!k.isEmpty(fv)) {
                fg[1] = fv;
            }
        }
        String azU = ciU.getPbData().chK().azU();
        if (azU != null && azU.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(fg[1]);
        shareFromPBMsgData.setImageUrl(fg[0]);
        shareFromPBMsgData.setForumName(ciU.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(ciU.getPbData().chK().getId());
        shareFromPBMsgData.setTitle(ciU.getPbData().chK().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel ciU = pbFragment.ciU();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (ciU != null && ciU.getPbData() != null && ciU.getPbData().chK() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.jI(1);
                aVar.aK(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            an cp = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).Z("obj_source", 1).Z("obj_param1", 3).cp("fid", PbModel.this.getForumId()).cp("tid", PbModel.this.ckU());
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
                aVar.fv(true);
                aVar.b(pbFragment.getPageContext()).aBW();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.am(aB.getImageUrl(), ciU.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel ciU = pbFragment.ciU();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (ciU != null && ciU.getPbData() != null && ciU.getPbData().chK() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.jI(1);
                aVar.aK(thread2GroupShareView);
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
                aVar.fv(true);
                aVar.b(pbFragment.getPageContext()).aBW();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.am(aB.getImageUrl(), ciU.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
