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
        String aKJ = bjVar.aKJ();
        if (bjVar.dtz != null) {
            valueOf = bjVar.dtz.id;
            aKJ = bjVar.dtz.ori_fname;
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
        shareItem.readCount = bjVar.aKw();
        shareItem.dQv = str2;
        shareItem.linkUrl = str;
        shareItem.dua = 2;
        shareItem.extData = tid;
        shareItem.dQy = 3;
        shareItem.fid = valueOf;
        shareItem.fName = aKJ;
        shareItem.tid = tid;
        shareItem.dQl = true;
        shareItem.dQx = 6;
        shareItem.dQC = A(bjVar);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.dQF = OriginalThreadInfo.ShareInfo.generateShareInfo(bjVar);
        shareItem.dQG = ShareItem.ForwardInfo.generateForwardInfo(bjVar, 1, null);
        shareItem.dQM = bjVar.getShareImageUrl();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.dQy);
        bundle.putInt("obj_type", shareItem.dQC);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putInt("obj_source", shareItem.dua);
        shareItem.Y(bundle);
        return shareItem;
    }

    private static String z(bj bjVar) {
        String str;
        if (bjVar == null || bjVar.aKO() == null) {
            return null;
        }
        ArrayList<MediaData> aKO = bjVar.aKO();
        int size = aKO.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aKO.get(i);
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
        if (str == null && bjVar.aKV() != null && !TextUtils.isEmpty(bjVar.aKV().thumbnail_url)) {
            return bjVar.aKV().thumbnail_url;
        }
        return str;
    }

    private static int A(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.aKG()) {
                return 4;
            }
            if (bjVar.aKB() == 1) {
                return 3;
            }
            return bjVar.aLT() ? 2 : 1;
        }
        return 0;
    }

    public static void a(final PbFragment pbFragment, int i, int i2) {
        String cyA;
        String str;
        String str2;
        if (pbFragment != null && pbFragment.cwD() != null && pbFragment.cxv() != null) {
            final PbModel cwD = pbFragment.cwD();
            final an cxv = pbFragment.cxv();
            if (cwD.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                e pbData = cwD.getPbData();
                String title = pbData.cvu().getTitle();
                int i3 = cwD.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Ka(pbData.getForumId())) {
                        z = true;
                    }
                }
                bj cvu = cwD.getPbData().cvu();
                if (cvu.aMA()) {
                    cyA = cvu.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + cvu.getBaijiahaoData().oriUgcType + "&dvid=" + cvu.getBaijiahaoData().oriUgcVid + "&nid=" + cvu.getBaijiahaoData().oriUgcNid;
                } else {
                    cyA = cwD.cyA();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + cyA + str;
                String[] fb = pbData.fb(pbFragment.getContext());
                String str4 = fb[0];
                if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str4 == null ? null : Uri.parse(str4);
                String str5 = fb[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10399").cI("fid", pbData.getForumId()).cI("tid", pbData.getThreadId()).cI("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.cvS() && cvu.aKE() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                        str2 = (TextUtils.isEmpty(title) || cvu.aMz() || cvu.aJu()) ? fb[1] : title;
                        title = MessageFormat.format(string, cvu.aKE().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
                if (pbData.cvS()) {
                    shareItem.dQv = cutString2;
                    shareItem.readCount = -1L;
                } else {
                    shareItem.readCount = pbData.cvO();
                }
                shareItem.linkUrl = str3;
                shareItem.dQi = true;
                shareItem.dQq = z;
                shareItem.extData = cwD.cyA();
                shareItem.dQy = 3;
                shareItem.dQx = i2;
                shareItem.dQz = y(cvu);
                shareItem.fid = cwD.getForumId();
                shareItem.tid = cwD.cyA();
                shareItem.dQC = C(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.cvS()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.dQF = OriginalThreadInfo.ShareInfo.generateShareInfo(cvu);
                if (pbData != null && pbData.cvw() != null && pbData.cvw().size() > 0) {
                    shareItem.dQG = ShareItem.ForwardInfo.generateForwardInfo(cvu, 1, pbData.cvw().get(0));
                } else {
                    shareItem.dQG = ShareItem.ForwardInfo.generateForwardInfo(cvu, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (cvu != null) {
                    shareItem.dQM = cvu.getShareImageUrl();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.dQy);
                bundle.putInt("obj_type", shareItem.dQC);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.Y(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().aQh() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            cxv.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.e.bGe().b(shareDialogConfig);
            }
        }
    }

    private static int y(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aJt()) {
            return 10;
        }
        if (bjVar.aJu()) {
            return 9;
        }
        if (bjVar.aMz()) {
            return 8;
        }
        if (bjVar.aMy()) {
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
        bj cvu;
        if (eVar != null && (cvu = eVar.cvu()) != null) {
            if (cvu.aKG()) {
                return 4;
            }
            if (cvu.aKB() == 1) {
                return 3;
            }
            if (cvu.aLT()) {
                return 2;
            }
            if (cvu.aJt()) {
                return 5;
            }
            if (cvu.aJu()) {
                return 6;
            }
            if (cvu.aMy()) {
                return 7;
            }
            return cvu.aMz() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aB(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.cwD() == null || pbFragment.cxv() == null) {
            return null;
        }
        PbModel cwD = pbFragment.cwD();
        an cxv = pbFragment.cxv();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] fb = cwD.getPbData().fb(pbFragment.getContext());
        PostData cAp = cxv.cAp();
        String str = "";
        if (cAp != null) {
            str = cAp.getId();
            String fn = cAp.fn(pbFragment.getContext());
            if (!k.isEmpty(fn)) {
                fb[1] = fn;
            }
        }
        String aKU = cwD.getPbData().cvu().aKU();
        if (aKU != null && aKU.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(fb[1]);
        shareFromPBMsgData.setImageUrl(fb[0]);
        shareFromPBMsgData.setForumName(cwD.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(cwD.getPbData().cvu().getId());
        shareFromPBMsgData.setTitle(cwD.getPbData().cvu().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel cwD = pbFragment.cwD();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (cwD != null && cwD.getPbData() != null && cwD.getPbData().cvu() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aB);
                aVar.kg(1);
                aVar.aP(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            com.baidu.tbadk.core.util.an cI = new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).af("obj_source", 1).af("obj_param1", 3).cI("fid", PbModel.this.getForumId()).cI("tid", PbModel.this.cyA());
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
                aVar.b(pbFragment.getPageContext()).aMU();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.as(aB.getImageUrl(), cwD.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel cwD = pbFragment.cwD();
            final ShareFromPBMsgData aB = aB(pbFragment);
            if (cwD != null && cwD.getPbData() != null && cwD.getPbData().cvu() != null) {
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
                aVar.b(pbFragment.getPageContext()).aMU();
                if (!k.isEmpty(aB.getImageUrl())) {
                    thread2GroupShareView.as(aB.getImageUrl(), cwD.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
