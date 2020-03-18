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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.an;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.Thread2GroupShareView;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a {
    public static void a(Context context, bj bjVar, int i) {
        if (bjVar != null && context != null) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i, c(context, bjVar), true));
        }
    }

    private static ShareItem c(Context context, bj bjVar) {
        if (bjVar == null || context == null) {
            return null;
        }
        String valueOf = String.valueOf(bjVar.getFid());
        String aCw = bjVar.aCw();
        if (bjVar.cUo != null) {
            valueOf = bjVar.cUo.id;
            aCw = bjVar.cUo.ori_fname;
        }
        String title = bjVar.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = bjVar.getAbstract();
        }
        String tid = bjVar.getTid();
        String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
        String z = z(bjVar);
        Uri parse = z == null ? null : Uri.parse(z);
        String str2 = bjVar.getAbstract();
        String format = MessageFormat.format(context.getResources().getString(R.string.share_content_tpl), title, str2);
        ShareItem shareItem = new ShareItem();
        shareItem.title = title;
        shareItem.content = format;
        shareItem.readCount = bjVar.aCj();
        shareItem.dqC = str2;
        shareItem.linkUrl = str;
        shareItem.cUP = 2;
        shareItem.extData = tid;
        shareItem.dqF = 3;
        shareItem.fid = valueOf;
        shareItem.fName = aCw;
        shareItem.tid = tid;
        shareItem.dqs = true;
        shareItem.dqE = 6;
        shareItem.dqJ = A(bjVar);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.dqM = OriginalThreadInfo.ShareInfo.generateShareInfo(bjVar);
        shareItem.dqN = ShareItem.ForwardInfo.generateForwardInfo(bjVar, 1, null);
        shareItem.dqT = bjVar.getShareImageUrl();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.dqF);
        bundle.putInt("obj_type", shareItem.dqJ);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putInt("obj_source", shareItem.cUP);
        shareItem.Y(bundle);
        return shareItem;
    }

    private static String z(bj bjVar) {
        String str;
        if (bjVar == null || bjVar.aCB() == null) {
            return null;
        }
        ArrayList<MediaData> aCB = bjVar.aCB();
        int size = aCB.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aCB.get(i);
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
        if (str == null && bjVar.aCI() != null && !TextUtils.isEmpty(bjVar.aCI().thumbnail_url)) {
            return bjVar.aCI().thumbnail_url;
        }
        return str;
    }

    private static int A(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.aCt()) {
                return 4;
            }
            if (bjVar.aCo() == 1) {
                return 3;
            }
            return bjVar.aDF() ? 2 : 1;
        }
        return 0;
    }

    public static void a(final PbFragment pbFragment, int i, int i2) {
        String cnU;
        String str;
        String str2;
        if (pbFragment != null && pbFragment.clX() != null && pbFragment.cmP() != null) {
            final PbModel clX = pbFragment.clX();
            final an cmP = pbFragment.cmP();
            if (clX.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                e pbData = clX.getPbData();
                String title = pbData.ckP().getTitle();
                int i3 = clX.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Iw(pbData.getForumId())) {
                        z = true;
                    }
                }
                bj ckP = clX.getPbData().ckP();
                if (ckP.aEm()) {
                    cnU = ckP.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + ckP.getBaijiahaoData().oriUgcType + "&dvid=" + ckP.getBaijiahaoData().oriUgcVid + "&nid=" + ckP.getBaijiahaoData().oriUgcNid;
                } else {
                    cnU = clX.cnU();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + cnU + str;
                String[] fi = pbData.fi(pbFragment.getContext());
                String str4 = fi[0];
                if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str4 == null ? null : Uri.parse(str4);
                String str5 = fi[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10399").cx("fid", pbData.getForumId()).cx("tid", pbData.getThreadId()).cx("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.cln() && ckP.aCr() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                        str2 = (TextUtils.isEmpty(title) || ckP.aEl() || ckP.aBh()) ? fi[1] : title;
                        title = MessageFormat.format(string, ckP.aCr().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                    } else {
                        str2 = title;
                        title = str5;
                    }
                } else if (aq.isEmpty(str5)) {
                    str2 = title;
                } else {
                    str2 = title;
                    title = str5;
                }
                String cutString = aq.cutString(str2, 100);
                String cutString2 = aq.cutString(title, 100);
                ShareItem shareItem = new ShareItem();
                shareItem.title = cutString;
                shareItem.content = cutString2;
                if (pbData.cln()) {
                    shareItem.dqC = cutString2;
                    shareItem.readCount = -1L;
                } else {
                    shareItem.readCount = pbData.clj();
                }
                shareItem.linkUrl = str3;
                shareItem.dqp = true;
                shareItem.dqx = z;
                shareItem.extData = clX.cnU();
                shareItem.dqF = 3;
                shareItem.dqE = i2;
                shareItem.dqG = y(ckP);
                shareItem.fid = clX.getForumId();
                shareItem.tid = clX.cnU();
                shareItem.dqJ = C(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.cln()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.dqM = OriginalThreadInfo.ShareInfo.generateShareInfo(ckP);
                if (pbData != null && pbData.ckR() != null && pbData.ckR().size() > 0) {
                    shareItem.dqN = ShareItem.ForwardInfo.generateForwardInfo(ckP, 1, pbData.ckR().get(0));
                } else {
                    shareItem.dqN = ShareItem.ForwardInfo.generateForwardInfo(ckP, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (ckP != null) {
                    shareItem.dqT = ckP.getShareImageUrl();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.dqF);
                bundle.putInt("obj_type", shareItem.dqJ);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.Y(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().aHP() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            cmP.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.e.bws().b(shareDialogConfig);
            }
        }
    }

    private static int y(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aBg()) {
            return 10;
        }
        if (bjVar.aBh()) {
            return 9;
        }
        if (bjVar.aEl()) {
            return 8;
        }
        if (bjVar.aEk()) {
            return 7;
        }
        if (bjVar.isShareThread) {
            return 6;
        }
        if (bjVar.threadType == 0) {
            return 1;
        }
        if (bjVar.threadType == 40) {
            return 2;
        }
        if (bjVar.threadType == 49) {
            return 3;
        }
        if (bjVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int C(e eVar) {
        bj ckP;
        if (eVar != null && (ckP = eVar.ckP()) != null) {
            if (ckP.aCt()) {
                return 4;
            }
            if (ckP.aCo() == 1) {
                return 3;
            }
            if (ckP.aDF()) {
                return 2;
            }
            if (ckP.aBg()) {
                return 5;
            }
            if (ckP.aBh()) {
                return 6;
            }
            if (ckP.aEk()) {
                return 7;
            }
            return ckP.aEl() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aB(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.clX() == null || pbFragment.cmP() == null) {
            return null;
        }
        PbModel clX = pbFragment.clX();
        an cmP = pbFragment.cmP();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] fi = clX.getPbData().fi(pbFragment.getContext());
        PostData cpJ = cmP.cpJ();
        String str = "";
        if (cpJ != null) {
            str = cpJ.getId();
            String fv = cpJ.fv(pbFragment.getContext());
            if (!k.isEmpty(fv)) {
                fi[1] = fv;
            }
        }
        String aCH = clX.getPbData().ckP().aCH();
        if (aCH != null && aCH.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(fi[1]);
        shareFromPBMsgData.setImageUrl(fi[0]);
        shareFromPBMsgData.setForumName(clX.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(clX.getPbData().ckP().getId());
        shareFromPBMsgData.setTitle(clX.getPbData().ckP().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel clX = pbFragment.clX();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (clX != null && clX.getPbData() != null && clX.getPbData().ckP() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.jZ(1);
                aVar.aO(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            com.baidu.tbadk.core.util.an cx = new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).X("obj_source", 1).X("obj_param1", 3).cx("fid", PbModel.this.getForumId()).cx("tid", PbModel.this.cnU());
                            if (a.C(PbModel.this.getPbData()) != 0) {
                                cx.X("obj_type", a.C(PbModel.this.getPbData()));
                            }
                            TiebaStatic.log(cx);
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
                aVar.fI(true);
                aVar.b(pbFragment.getPageContext()).aEG();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.am(aB.getImageUrl(), clX.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel clX = pbFragment.clX();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (clX != null && clX.getPbData() != null && clX.getPbData().ckP() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.jZ(1);
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
                aVar.fI(true);
                aVar.b(pbFragment.getPageContext()).aEG();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.am(aB.getImageUrl(), clX.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
