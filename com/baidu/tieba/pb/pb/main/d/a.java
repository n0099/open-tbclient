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
        String aCr = bjVar.aCr();
        if (bjVar.cTZ != null) {
            valueOf = bjVar.cTZ.id;
            aCr = bjVar.cTZ.ori_fname;
        }
        String title = bjVar.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = bjVar.getAbstract();
        }
        String tid = bjVar.getTid();
        String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
        String y = y(bjVar);
        Uri parse = y == null ? null : Uri.parse(y);
        String str2 = bjVar.getAbstract();
        String format = MessageFormat.format(context.getResources().getString(R.string.share_content_tpl), title, str2);
        ShareItem shareItem = new ShareItem();
        shareItem.title = title;
        shareItem.content = format;
        shareItem.readCount = bjVar.aCe();
        shareItem.dqb = str2;
        shareItem.linkUrl = str;
        shareItem.cUA = 2;
        shareItem.extData = tid;
        shareItem.dqe = 3;
        shareItem.fid = valueOf;
        shareItem.fName = aCr;
        shareItem.tid = tid;
        shareItem.dpR = true;
        shareItem.dqd = 6;
        shareItem.dqi = z(bjVar);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.dql = OriginalThreadInfo.ShareInfo.generateShareInfo(bjVar);
        shareItem.dqm = ShareItem.ForwardInfo.generateForwardInfo(bjVar, 1, null);
        shareItem.dqs = bjVar.getShareImageUrl();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.dqe);
        bundle.putInt("obj_type", shareItem.dqi);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putInt("obj_source", shareItem.cUA);
        shareItem.Y(bundle);
        return shareItem;
    }

    private static String y(bj bjVar) {
        String str;
        if (bjVar == null || bjVar.aCw() == null) {
            return null;
        }
        ArrayList<MediaData> aCw = bjVar.aCw();
        int size = aCw.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aCw.get(i);
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
        if (str == null && bjVar.aCD() != null && !TextUtils.isEmpty(bjVar.aCD().thumbnail_url)) {
            return bjVar.aCD().thumbnail_url;
        }
        return str;
    }

    private static int z(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.aCo()) {
                return 4;
            }
            if (bjVar.aCj() == 1) {
                return 3;
            }
            return bjVar.aDz() ? 2 : 1;
        }
        return 0;
    }

    public static void a(final PbFragment pbFragment, int i, int i2) {
        String cnw;
        String str;
        String str2;
        if (pbFragment != null && pbFragment.clz() != null && pbFragment.cmr() != null) {
            final PbModel clz = pbFragment.clz();
            final an cmr = pbFragment.cmr();
            if (clz.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                e pbData = clz.getPbData();
                String title = pbData.cks().getTitle();
                int i3 = clz.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Iw(pbData.getForumId())) {
                        z = true;
                    }
                }
                bj cks = clz.getPbData().cks();
                if (cks.aEg()) {
                    cnw = cks.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + cks.getBaijiahaoData().oriUgcType + "&dvid=" + cks.getBaijiahaoData().oriUgcVid + "&nid=" + cks.getBaijiahaoData().oriUgcNid;
                } else {
                    cnw = clz.cnw();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + cnw + str;
                String[] fj = pbData.fj(pbFragment.getContext());
                String str4 = fj[0];
                if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str4 == null ? null : Uri.parse(str4);
                String str5 = fj[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10399").cy("fid", pbData.getForumId()).cy("tid", pbData.getThreadId()).cy("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.ckQ() && cks.aCm() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                        str2 = (TextUtils.isEmpty(title) || cks.aEf() || cks.aBc()) ? fj[1] : title;
                        title = MessageFormat.format(string, cks.aCm().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
                if (pbData.ckQ()) {
                    shareItem.dqb = cutString2;
                    shareItem.readCount = -1L;
                } else {
                    shareItem.readCount = pbData.ckM();
                }
                shareItem.linkUrl = str3;
                shareItem.dpO = true;
                shareItem.dpW = z;
                shareItem.extData = clz.cnw();
                shareItem.dqe = 3;
                shareItem.dqd = i2;
                shareItem.dqf = x(cks);
                shareItem.fid = clz.getForumId();
                shareItem.tid = clz.cnw();
                shareItem.dqi = C(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.ckQ()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.dql = OriginalThreadInfo.ShareInfo.generateShareInfo(cks);
                if (pbData != null && pbData.cku() != null && pbData.cku().size() > 0) {
                    shareItem.dqm = ShareItem.ForwardInfo.generateForwardInfo(cks, 1, pbData.cku().get(0));
                } else {
                    shareItem.dqm = ShareItem.ForwardInfo.generateForwardInfo(cks, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (cks != null) {
                    shareItem.dqs = cks.getShareImageUrl();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.dqe);
                bundle.putInt("obj_type", shareItem.dqi);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.Y(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().aHI() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            cmr.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.e.bwk().b(shareDialogConfig);
            }
        }
    }

    private static int x(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aBb()) {
            return 10;
        }
        if (bjVar.aBc()) {
            return 9;
        }
        if (bjVar.aEf()) {
            return 8;
        }
        if (bjVar.aEe()) {
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
        bj cks;
        if (eVar != null && (cks = eVar.cks()) != null) {
            if (cks.aCo()) {
                return 4;
            }
            if (cks.aCj() == 1) {
                return 3;
            }
            if (cks.aDz()) {
                return 2;
            }
            if (cks.aBb()) {
                return 5;
            }
            if (cks.aBc()) {
                return 6;
            }
            if (cks.aEe()) {
                return 7;
            }
            return cks.aEf() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aB(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.clz() == null || pbFragment.cmr() == null) {
            return null;
        }
        PbModel clz = pbFragment.clz();
        an cmr = pbFragment.cmr();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] fj = clz.getPbData().fj(pbFragment.getContext());
        PostData cpl = cmr.cpl();
        String str = "";
        if (cpl != null) {
            str = cpl.getId();
            String fw = cpl.fw(pbFragment.getContext());
            if (!k.isEmpty(fw)) {
                fj[1] = fw;
            }
        }
        String aCC = clz.getPbData().cks().aCC();
        if (aCC != null && aCC.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(fj[1]);
        shareFromPBMsgData.setImageUrl(fj[0]);
        shareFromPBMsgData.setForumName(clz.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(clz.getPbData().cks().getId());
        shareFromPBMsgData.setTitle(clz.getPbData().cks().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel clz = pbFragment.clz();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (clz != null && clz.getPbData() != null && clz.getPbData().cks() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.jZ(1);
                aVar.aO(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            com.baidu.tbadk.core.util.an cy = new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).X("obj_source", 1).X("obj_param1", 3).cy("fid", PbModel.this.getForumId()).cy("tid", PbModel.this.cnw());
                            if (a.C(PbModel.this.getPbData()) != 0) {
                                cy.X("obj_type", a.C(PbModel.this.getPbData()));
                            }
                            TiebaStatic.log(cy);
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
                aVar.fH(true);
                aVar.b(pbFragment.getPageContext()).aEA();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.am(aB.getImageUrl(), clz.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel clz = pbFragment.clz();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (clz != null && clz.getPbData() != null && clz.getPbData().cks() != null) {
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
                aVar.fH(true);
                aVar.b(pbFragment.getPageContext()).aEA();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.am(aB.getImageUrl(), clz.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
