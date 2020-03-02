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
        String aCt = bjVar.aCt();
        if (bjVar.cUa != null) {
            valueOf = bjVar.cUa.id;
            aCt = bjVar.cUa.ori_fname;
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
        shareItem.readCount = bjVar.aCg();
        shareItem.dqc = str2;
        shareItem.linkUrl = str;
        shareItem.cUB = 2;
        shareItem.extData = tid;
        shareItem.dqf = 3;
        shareItem.fid = valueOf;
        shareItem.fName = aCt;
        shareItem.tid = tid;
        shareItem.dpS = true;
        shareItem.dqe = 6;
        shareItem.dqj = z(bjVar);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.dqm = OriginalThreadInfo.ShareInfo.generateShareInfo(bjVar);
        shareItem.dqn = ShareItem.ForwardInfo.generateForwardInfo(bjVar, 1, null);
        shareItem.dqt = bjVar.getShareImageUrl();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.dqf);
        bundle.putInt("obj_type", shareItem.dqj);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putInt("obj_source", shareItem.cUB);
        shareItem.Y(bundle);
        return shareItem;
    }

    private static String y(bj bjVar) {
        String str;
        if (bjVar == null || bjVar.aCy() == null) {
            return null;
        }
        ArrayList<MediaData> aCy = bjVar.aCy();
        int size = aCy.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aCy.get(i);
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
        if (str == null && bjVar.aCF() != null && !TextUtils.isEmpty(bjVar.aCF().thumbnail_url)) {
            return bjVar.aCF().thumbnail_url;
        }
        return str;
    }

    private static int z(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.aCq()) {
                return 4;
            }
            if (bjVar.aCl() == 1) {
                return 3;
            }
            return bjVar.aDB() ? 2 : 1;
        }
        return 0;
    }

    public static void a(final PbFragment pbFragment, int i, int i2) {
        String cny;
        String str;
        String str2;
        if (pbFragment != null && pbFragment.clB() != null && pbFragment.cmt() != null) {
            final PbModel clB = pbFragment.clB();
            final an cmt = pbFragment.cmt();
            if (clB.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                e pbData = clB.getPbData();
                String title = pbData.cku().getTitle();
                int i3 = clB.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Iw(pbData.getForumId())) {
                        z = true;
                    }
                }
                bj cku = clB.getPbData().cku();
                if (cku.aEi()) {
                    cny = cku.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + cku.getBaijiahaoData().oriUgcType + "&dvid=" + cku.getBaijiahaoData().oriUgcVid + "&nid=" + cku.getBaijiahaoData().oriUgcNid;
                } else {
                    cny = clB.cny();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + cny + str;
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
                if (pbData.ckS() && cku.aCo() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                        str2 = (TextUtils.isEmpty(title) || cku.aEh() || cku.aBe()) ? fj[1] : title;
                        title = MessageFormat.format(string, cku.aCo().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
                if (pbData.ckS()) {
                    shareItem.dqc = cutString2;
                    shareItem.readCount = -1L;
                } else {
                    shareItem.readCount = pbData.ckO();
                }
                shareItem.linkUrl = str3;
                shareItem.dpP = true;
                shareItem.dpX = z;
                shareItem.extData = clB.cny();
                shareItem.dqf = 3;
                shareItem.dqe = i2;
                shareItem.dqg = x(cku);
                shareItem.fid = clB.getForumId();
                shareItem.tid = clB.cny();
                shareItem.dqj = C(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.ckS()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.dqm = OriginalThreadInfo.ShareInfo.generateShareInfo(cku);
                if (pbData != null && pbData.ckw() != null && pbData.ckw().size() > 0) {
                    shareItem.dqn = ShareItem.ForwardInfo.generateForwardInfo(cku, 1, pbData.ckw().get(0));
                } else {
                    shareItem.dqn = ShareItem.ForwardInfo.generateForwardInfo(cku, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (cku != null) {
                    shareItem.dqt = cku.getShareImageUrl();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.dqf);
                bundle.putInt("obj_type", shareItem.dqj);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.Y(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().aHK() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            cmt.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.e.bwm().b(shareDialogConfig);
            }
        }
    }

    private static int x(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aBd()) {
            return 10;
        }
        if (bjVar.aBe()) {
            return 9;
        }
        if (bjVar.aEh()) {
            return 8;
        }
        if (bjVar.aEg()) {
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
        bj cku;
        if (eVar != null && (cku = eVar.cku()) != null) {
            if (cku.aCq()) {
                return 4;
            }
            if (cku.aCl() == 1) {
                return 3;
            }
            if (cku.aDB()) {
                return 2;
            }
            if (cku.aBd()) {
                return 5;
            }
            if (cku.aBe()) {
                return 6;
            }
            if (cku.aEg()) {
                return 7;
            }
            return cku.aEh() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aB(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.clB() == null || pbFragment.cmt() == null) {
            return null;
        }
        PbModel clB = pbFragment.clB();
        an cmt = pbFragment.cmt();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] fj = clB.getPbData().fj(pbFragment.getContext());
        PostData cpn = cmt.cpn();
        String str = "";
        if (cpn != null) {
            str = cpn.getId();
            String fw = cpn.fw(pbFragment.getContext());
            if (!k.isEmpty(fw)) {
                fj[1] = fw;
            }
        }
        String aCE = clB.getPbData().cku().aCE();
        if (aCE != null && aCE.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(fj[1]);
        shareFromPBMsgData.setImageUrl(fj[0]);
        shareFromPBMsgData.setForumName(clB.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(clB.getPbData().cku().getId());
        shareFromPBMsgData.setTitle(clB.getPbData().cku().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel clB = pbFragment.clB();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (clB != null && clB.getPbData() != null && clB.getPbData().cku() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.jZ(1);
                aVar.aO(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            com.baidu.tbadk.core.util.an cy = new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).X("obj_source", 1).X("obj_param1", 3).cy("fid", PbModel.this.getForumId()).cy("tid", PbModel.this.cny());
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
                aVar.b(pbFragment.getPageContext()).aEC();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.am(aB.getImageUrl(), clB.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel clB = pbFragment.clB();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (clB != null && clB.getPbData() != null && clB.getPbData().cku() != null) {
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
                aVar.b(pbFragment.getPageContext()).aEC();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.am(aB.getImageUrl(), clB.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
