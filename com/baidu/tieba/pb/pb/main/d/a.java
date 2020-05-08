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
        String aKH = bjVar.aKH();
        if (bjVar.dtD != null) {
            valueOf = bjVar.dtD.id;
            aKH = bjVar.dtD.ori_fname;
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
        shareItem.readCount = bjVar.aKu();
        shareItem.dQA = str2;
        shareItem.linkUrl = str;
        shareItem.due = 2;
        shareItem.extData = tid;
        shareItem.dQD = 3;
        shareItem.fid = valueOf;
        shareItem.fName = aKH;
        shareItem.tid = tid;
        shareItem.dQq = true;
        shareItem.dQC = 6;
        shareItem.dQH = A(bjVar);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.dQK = OriginalThreadInfo.ShareInfo.generateShareInfo(bjVar);
        shareItem.dQL = ShareItem.ForwardInfo.generateForwardInfo(bjVar, 1, null);
        shareItem.dQR = bjVar.getShareImageUrl();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.dQD);
        bundle.putInt("obj_type", shareItem.dQH);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putInt("obj_source", shareItem.due);
        shareItem.Y(bundle);
        return shareItem;
    }

    private static String z(bj bjVar) {
        String str;
        if (bjVar == null || bjVar.aKM() == null) {
            return null;
        }
        ArrayList<MediaData> aKM = bjVar.aKM();
        int size = aKM.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aKM.get(i);
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
        if (str == null && bjVar.aKT() != null && !TextUtils.isEmpty(bjVar.aKT().thumbnail_url)) {
            return bjVar.aKT().thumbnail_url;
        }
        return str;
    }

    private static int A(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.aKE()) {
                return 4;
            }
            if (bjVar.aKz() == 1) {
                return 3;
            }
            return bjVar.aLR() ? 2 : 1;
        }
        return 0;
    }

    public static void a(final PbFragment pbFragment, int i, int i2) {
        String cyx;
        String str;
        String str2;
        if (pbFragment != null && pbFragment.cwA() != null && pbFragment.cxs() != null) {
            final PbModel cwA = pbFragment.cwA();
            final an cxs = pbFragment.cxs();
            if (cwA.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                e pbData = cwA.getPbData();
                String title = pbData.cvr().getTitle();
                int i3 = cwA.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Kd(pbData.getForumId())) {
                        z = true;
                    }
                }
                bj cvr = cwA.getPbData().cvr();
                if (cvr.aMy()) {
                    cyx = cvr.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + cvr.getBaijiahaoData().oriUgcType + "&dvid=" + cvr.getBaijiahaoData().oriUgcVid + "&nid=" + cvr.getBaijiahaoData().oriUgcNid;
                } else {
                    cyx = cwA.cyx();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + cyx + str;
                String[] eP = pbData.eP(pbFragment.getContext());
                String str4 = eP[0];
                if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str4 == null ? null : Uri.parse(str4);
                String str5 = eP[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10399").cI("fid", pbData.getForumId()).cI("tid", pbData.getThreadId()).cI("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.cvP() && cvr.aKC() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                        str2 = (TextUtils.isEmpty(title) || cvr.aMx() || cvr.aJs()) ? eP[1] : title;
                        title = MessageFormat.format(string, cvr.aKC().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
                if (pbData.cvP()) {
                    shareItem.dQA = cutString2;
                    shareItem.readCount = -1L;
                } else {
                    shareItem.readCount = pbData.cvL();
                }
                shareItem.linkUrl = str3;
                shareItem.dQn = true;
                shareItem.dQv = z;
                shareItem.extData = cwA.cyx();
                shareItem.dQD = 3;
                shareItem.dQC = i2;
                shareItem.dQE = y(cvr);
                shareItem.fid = cwA.getForumId();
                shareItem.tid = cwA.cyx();
                shareItem.dQH = C(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.cvP()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.dQK = OriginalThreadInfo.ShareInfo.generateShareInfo(cvr);
                if (pbData != null && pbData.cvt() != null && pbData.cvt().size() > 0) {
                    shareItem.dQL = ShareItem.ForwardInfo.generateForwardInfo(cvr, 1, pbData.cvt().get(0));
                } else {
                    shareItem.dQL = ShareItem.ForwardInfo.generateForwardInfo(cvr, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (cvr != null) {
                    shareItem.dQR = cvr.getShareImageUrl();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.dQD);
                bundle.putInt("obj_type", shareItem.dQH);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.Y(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().aQe() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            cxs.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.e.bGc().b(shareDialogConfig);
            }
        }
    }

    private static int y(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aJr()) {
            return 10;
        }
        if (bjVar.aJs()) {
            return 9;
        }
        if (bjVar.aMx()) {
            return 8;
        }
        if (bjVar.aMw()) {
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
        bj cvr;
        if (eVar != null && (cvr = eVar.cvr()) != null) {
            if (cvr.aKE()) {
                return 4;
            }
            if (cvr.aKz() == 1) {
                return 3;
            }
            if (cvr.aLR()) {
                return 2;
            }
            if (cvr.aJr()) {
                return 5;
            }
            if (cvr.aJs()) {
                return 6;
            }
            if (cvr.aMw()) {
                return 7;
            }
            return cvr.aMx() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aB(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.cwA() == null || pbFragment.cxs() == null) {
            return null;
        }
        PbModel cwA = pbFragment.cwA();
        an cxs = pbFragment.cxs();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] eP = cwA.getPbData().eP(pbFragment.getContext());
        PostData cAm = cxs.cAm();
        String str = "";
        if (cAm != null) {
            str = cAm.getId();
            String fb = cAm.fb(pbFragment.getContext());
            if (!k.isEmpty(fb)) {
                eP[1] = fb;
            }
        }
        String aKS = cwA.getPbData().cvr().aKS();
        if (aKS != null && aKS.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(eP[1]);
        shareFromPBMsgData.setImageUrl(eP[0]);
        shareFromPBMsgData.setForumName(cwA.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(cwA.getPbData().cvr().getId());
        shareFromPBMsgData.setTitle(cwA.getPbData().cvr().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel cwA = pbFragment.cwA();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (cwA != null && cwA.getPbData() != null && cwA.getPbData().cvr() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.kg(1);
                aVar.aP(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            com.baidu.tbadk.core.util.an cI = new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).af("obj_source", 1).af("obj_param1", 3).cI("fid", PbModel.this.getForumId()).cI("tid", PbModel.this.cyx());
                            if (a.C(PbModel.this.getPbData()) != 0) {
                                cI.af("obj_type", a.C(PbModel.this.getPbData()));
                            }
                            TiebaStatic.log(cI);
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
                aVar.gF(true);
                aVar.b(pbFragment.getPageContext()).aMS();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.as(aB.getImageUrl(), cwA.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel cwA = pbFragment.cwA();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (cwA != null && cwA.getPbData() != null && cwA.getPbData().cvr() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.kg(1);
                aVar.aP(thread2GroupShareView);
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
                aVar.gF(true);
                aVar.b(pbFragment.getPageContext()).aMS();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.as(aB.getImageUrl(), cwA.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
