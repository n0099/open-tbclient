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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.av;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.Thread2GroupShareView;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a {
    public static void a(Context context, bk bkVar, int i) {
        if (bkVar != null && context != null) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i, c(context, bkVar), true));
        }
    }

    private static ShareItem c(Context context, bk bkVar) {
        if (bkVar == null || context == null) {
            return null;
        }
        String valueOf = String.valueOf(bkVar.getFid());
        String aQC = bkVar.aQC();
        if (bkVar.dHw != null) {
            valueOf = bkVar.dHw.id;
            aQC = bkVar.dHw.ori_fname;
        }
        String title = bkVar.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = bkVar.getAbstract();
        }
        String tid = bkVar.getTid();
        String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
        String A = A(bkVar);
        Uri parse = A == null ? null : Uri.parse(A);
        String str2 = bkVar.getAbstract();
        String format = MessageFormat.format(context.getResources().getString(R.string.share_content_tpl), title, str2);
        ShareItem shareItem = new ShareItem();
        shareItem.title = title;
        shareItem.content = format;
        shareItem.readCount = bkVar.aQp();
        shareItem.eeT = str2;
        shareItem.linkUrl = str;
        shareItem.dHZ = 2;
        shareItem.extData = tid;
        shareItem.eeW = 3;
        shareItem.fid = valueOf;
        shareItem.fName = aQC;
        shareItem.tid = tid;
        shareItem.eeK = true;
        shareItem.eeV = 6;
        shareItem.efa = B(bkVar);
        if (parse != null) {
            shareItem.imageUri = parse;
        }
        shareItem.efd = OriginalThreadInfo.ShareInfo.generateShareInfo(bkVar);
        shareItem.efe = ShareItem.ForwardInfo.generateForwardInfo(bkVar, 1, null);
        shareItem.efk = bkVar.getShareImageUrl();
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.eeW);
        bundle.putInt("obj_type", shareItem.efa);
        bundle.putString("fid", shareItem.fid);
        bundle.putString("tid", shareItem.tid);
        bundle.putInt("obj_source", shareItem.dHZ);
        shareItem.ae(bundle);
        return shareItem;
    }

    private static String A(bk bkVar) {
        String str;
        if (bkVar == null || bkVar.aQH() == null) {
            return null;
        }
        ArrayList<MediaData> aQH = bkVar.aQH();
        int size = aQH.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aQH.get(i);
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
        if (str == null && bkVar.aQQ() != null && !TextUtils.isEmpty(bkVar.aQQ().thumbnail_url)) {
            return bkVar.aQQ().thumbnail_url;
        }
        return str;
    }

    private static int B(bk bkVar) {
        if (bkVar != null) {
            if (bkVar.aQz()) {
                return 4;
            }
            if (bkVar.aQu() == 1) {
                return 3;
            }
            return bkVar.aRQ() ? 2 : 1;
        }
        return 0;
    }

    public static void a(final PbFragment pbFragment, int i, int i2) {
        String cFt;
        String str;
        String str2;
        if (pbFragment != null && pbFragment.cDy() != null && pbFragment.cEo() != null) {
            final PbModel cDy = pbFragment.cDy();
            final av cEo = pbFragment.cEo();
            if (cDy.hasData()) {
                TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
                e pbData = cDy.getPbData();
                String title = pbData.cCi().getTitle();
                int i3 = cDy.getHostMode() ? 1 : 0;
                boolean z = false;
                if (pbData.getForum() != null) {
                    if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.LP(pbData.getForumId())) {
                        z = true;
                    }
                }
                bk cCi = cDy.getPbData().cCi();
                if (cCi.aSx()) {
                    cFt = cCi.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&see_lz=" + i3 + "&dtype=" + cCi.getBaijiahaoData().oriUgcType + "&dvid=" + cCi.getBaijiahaoData().oriUgcVid + "&nid=" + cCi.getBaijiahaoData().oriUgcNid;
                } else {
                    cFt = cDy.cFt();
                    str = "?share=9105&fr=share&see_lz=" + i3;
                }
                String str3 = "http://tieba.baidu.com/p/" + cFt + str;
                String[] fe = pbData.fe(pbFragment.getContext());
                String str4 = fe[0];
                if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                    str4 = str4.substring(TbConfig.URL_IMAGE_PREFIX.length());
                }
                Uri parse = str4 == null ? null : Uri.parse(str4);
                String str5 = fe[1];
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i == 1) {
                    TiebaStatic.log(new an("c10399").dh("fid", pbData.getForumId()).dh("tid", pbData.getThreadId()).dh("uid", currentAccount));
                }
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (pbData.cCJ() && cCi.aQx() != null) {
                    if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                        str2 = (TextUtils.isEmpty(title) || cCi.aSw() || cCi.aPn()) ? fe[1] : title;
                        title = MessageFormat.format(string, cCi.aQx().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
                if (pbData.cCJ()) {
                    shareItem.eeT = cutString2;
                    shareItem.readCount = -1L;
                } else {
                    shareItem.readCount = pbData.cCF();
                }
                shareItem.linkUrl = str3;
                shareItem.eeH = true;
                shareItem.eeO = z;
                shareItem.extData = cDy.cFt();
                shareItem.eeW = 3;
                shareItem.eeV = i2;
                shareItem.eeX = z(cCi);
                shareItem.fid = cDy.getForumId();
                shareItem.tid = cDy.cFt();
                shareItem.efa = E(pbData);
                shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (pbData.cCJ()) {
                    shareItem.canShareBySmartApp = false;
                }
                shareItem.efd = OriginalThreadInfo.ShareInfo.generateShareInfo(cCi);
                if (pbData != null && pbData.cCk() != null && pbData.cCk().size() > 0) {
                    shareItem.efe = ShareItem.ForwardInfo.generateForwardInfo(cCi, 1, pbData.cCk().get(0));
                } else {
                    shareItem.efe = ShareItem.ForwardInfo.generateForwardInfo(cCi, 1, null);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                if (cCi != null) {
                    shareItem.efk = cCi.getShareImageUrl();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.eeW);
                bundle.putInt("obj_type", shareItem.efa);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putString("uid", shareItem.uid);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), shareItem, true, true);
                shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.d.a.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null && PbModel.this.getPbData().aWi() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity())) {
                            cEo.getView().setSystemUiVisibility(4);
                        }
                    }
                });
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                com.baidu.tieba.c.e.bMw().b(shareDialogConfig);
            }
        }
    }

    private static int z(bk bkVar) {
        if (bkVar == null) {
            return 0;
        }
        if (bkVar.aPm()) {
            return 10;
        }
        if (bkVar.aPn()) {
            return 9;
        }
        if (bkVar.aSw()) {
            return 8;
        }
        if (bkVar.aSv()) {
            return 7;
        }
        if (bkVar.isShareThread) {
            return 6;
        }
        if (bkVar.threadType == 0) {
            return 1;
        }
        if (bkVar.threadType == 40) {
            return 2;
        }
        if (bkVar.threadType == 49) {
            return 3;
        }
        if (bkVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int E(e eVar) {
        bk cCi;
        if (eVar != null && (cCi = eVar.cCi()) != null) {
            if (cCi.aQz()) {
                return 4;
            }
            if (cCi.aQu() == 1) {
                return 3;
            }
            if (cCi.aRQ()) {
                return 2;
            }
            if (cCi.aPm()) {
                return 5;
            }
            if (cCi.aPn()) {
                return 6;
            }
            if (cCi.aSv()) {
                return 7;
            }
            return cCi.aSw() ? 8 : 1;
        }
        return 0;
    }

    public static ShareFromPBMsgData aA(PbFragment pbFragment) {
        if (pbFragment == null || pbFragment.cDy() == null || pbFragment.cEo() == null) {
            return null;
        }
        PbModel cDy = pbFragment.cDy();
        av cEo = pbFragment.cEo();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] fe = cDy.getPbData().fe(pbFragment.getContext());
        PostData cHj = cEo.cHj();
        String str = "";
        if (cHj != null) {
            str = cHj.getId();
            String fq = cHj.fq(pbFragment.getContext());
            if (!k.isEmpty(fq)) {
                fe[1] = fq;
            }
        }
        String aQP = cDy.getPbData().cCi().aQP();
        if (aQP != null && aQP.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(fe[1]);
        shareFromPBMsgData.setImageUrl(fe[0]);
        shareFromPBMsgData.setForumName(cDy.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(cDy.getPbData().cCi().getId());
        shareFromPBMsgData.setTitle(cDy.getPbData().cCi().getTitle());
        return shareFromPBMsgData;
    }

    public static void a(PbFragment pbFragment, Intent intent) {
        a(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final String str2, final String str3) {
        if (pbFragment != null) {
            final PbModel cDy = pbFragment.cDy();
            final ShareFromPBMsgData aA = aA(pbFragment);
            if (cDy != null && cDy.getPbData() != null && cDy.getPbData().cCi() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aA);
                aVar.kG(1);
                aVar.aP(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PbModel.this != null && PbModel.this.getPbData() != null) {
                            an dh = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ag("obj_source", 1).ag("obj_param1", 3).dh("fid", PbModel.this.getForumId()).dh("tid", PbModel.this.cFt());
                            if (a.E(PbModel.this.getPbData()) != 0) {
                                dh.ag("obj_type", a.E(PbModel.this.getPbData()));
                            }
                            TiebaStatic.log(dh);
                        }
                        pbFragment.HidenSoftKeyPad((InputMethodManager) pbFragment.getBaseFragmentActivity().getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(pbFragment.getBaseFragmentActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), aA.toChatMessageContent())));
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
                aVar.gX(true);
                aVar.b(pbFragment.getPageContext()).aST();
                if (!k.isEmpty(aA.getImageUrl())) {
                    thread2GroupShareView.aF(aA.getImageUrl(), cDy.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }

    public static void a(final PbFragment pbFragment, final long j, final String str, final long j2) {
        if (pbFragment != null) {
            PbModel cDy = pbFragment.cDy();
            final ShareFromPBMsgData aA = aA(pbFragment);
            if (cDy != null && cDy.getPbData() != null && cDy.getPbData().cCi() != null) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pbFragment.getBaseFragmentActivity());
                final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
                thread2GroupShareView.setData(aA);
                aVar.kG(1);
                aVar.aP(thread2GroupShareView);
                aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.d.a.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        PbFragment.this.HidenSoftKeyPad((InputMethodManager) PbFragment.this.getBaseFragmentActivity().getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(PbFragment.this.getBaseFragmentActivity(), j, str, j2, "from_share", thread2GroupShareView.getLeaveMsg(), aA.toChatMessageContent())));
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
                aVar.gX(true);
                aVar.b(pbFragment.getPageContext()).aST();
                if (!k.isEmpty(aA.getImageUrl())) {
                    thread2GroupShareView.aF(aA.getImageUrl(), cDy.getPbData().getIsNewUrl() == 1);
                }
            }
        }
    }
}
