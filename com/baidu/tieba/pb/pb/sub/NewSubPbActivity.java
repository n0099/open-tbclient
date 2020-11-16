package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.t;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.m;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.i;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tbadk.widget.richText.h;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.ah;
import com.baidu.tieba.pb.pb.main.ay;
import com.baidu.tieba.pb.pb.main.bd;
import com.baidu.tieba.pb.pb.main.n;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.e;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes21.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, h, com.baidu.tieba.pb.pb.a<NewSubPbActivity> {
    private static String lIm = "tbgametype";
    private View.OnClickListener aYm;
    private e ePS;
    private com.baidu.tbadk.core.message.a eQi;
    private bd euQ;
    private com.baidu.adp.lib.d.b<ImageView> fFn;
    private com.baidu.adp.lib.d.b<GifView> fFo;
    private com.baidu.adp.lib.d.b<TextView> fIE;
    private com.baidu.adp.lib.d.b<View> fIF;
    private com.baidu.adp.lib.d.b<LinearLayout> fIG;
    private com.baidu.adp.lib.d.b<RelativeLayout> fIH;
    private VoiceManager iIc;
    private com.baidu.tieba.frs.profession.permission.c iMx;
    private com.baidu.tieba.write.c jKS;
    private EditText jKT;
    public am kwi;
    private com.baidu.tbadk.editortools.pb.h kwo;
    private String lDb;
    private com.baidu.tieba.pb.e<p> lIA;
    private boolean lIB;
    private n lIC;
    private SubPbModel lIn;
    private ForumManageModel lIo;
    private com.baidu.tieba.pb.pb.sub.a lIp;
    private ah lIq;
    private AbsListView.OnScrollListener lIr;
    private TbRichTextView.i lIs;
    private SubPbModel.a lIt;
    private com.baidu.adp.base.d lIu;
    private BdUniqueId lIy;
    private com.baidu.tieba.pb.pb.main.b.a lqj;
    private com.baidu.tbadk.core.view.c luA;
    private com.baidu.adp.widget.ImageView.a luD;
    private String luE;
    private TbRichTextMemeInfo luF;
    private com.baidu.tieba.pb.pb.report.a lue;
    private com.baidu.tbadk.baseEditMark.a luf;
    private com.baidu.adp.base.e luz;
    private PostWriteCallBackData lwm;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int lvp = 0;
    PostData jLA = null;
    private a.InterfaceC0571a lvl = null;
    private a lIv = null;
    private a lIw = null;
    private boolean mIsPaused = false;
    private boolean lIx = false;
    private boolean lIz = false;
    private boolean fmT = false;
    private com.baidu.tbadk.editortools.pb.c foW = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bzs() {
            NewSubPbActivity.this.lIp.dpd();
        }
    };
    private int lpF = 0;
    private boolean mIsFromSchema = false;
    private BdUniqueId lID = BdUniqueId.gen();
    private boolean lrD = com.baidu.tbadk.a.d.bhn();
    private boolean lIE = true;
    private com.baidu.tbadk.editortools.pb.b foX = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bzr() {
            if (!NewSubPbActivity.this.jKS.dSU()) {
                return (NewSubPbActivity.this.kwi == null || NewSubPbActivity.this.lIn == null || NewSubPbActivity.this.lIn.cwP() == null || NewSubPbActivity.this.kwi.aO(NewSubPbActivity.this.lIn.cwP().replyPrivateFlag, am.eMm)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.jKS.dSW());
            if (NewSubPbActivity.this.kwo.bzJ()) {
                NewSubPbActivity.this.kwo.a(NewSubPbActivity.this.lwm);
            }
            NewSubPbActivity.this.rk(true);
            return true;
        }
    };
    private CustomMessageListener lIF = new CustomMessageListener(2921481) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && NewSubPbActivity.this.lIn != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && au.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), NewSubPbActivity.this.lIn.dkU())) {
                if (NewSubPbActivity.this.jKS != null) {
                    NewSubPbActivity.this.jKS.Ul(null);
                    NewSubPbActivity.this.jKS.bl(null);
                    NewSubPbActivity.this.jKS.yw(false);
                }
                if (NewSubPbActivity.this.kwo != null) {
                    NewSubPbActivity.this.kwo.bzT();
                    NewSubPbActivity.this.kwo.reset();
                }
                NewSubPbActivity.this.lIn.bzo();
            }
        }
    };
    private NewWriteModel.d jKZ = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.kwo != null && NewSubPbActivity.this.kwo.byN() != null) {
                NewSubPbActivity.this.kwo.byN().hide();
                if (NewSubPbActivity.this.lIn.dpD()) {
                    TiebaStatic.log(new ar("c10367").dR("post_id", NewSubPbActivity.this.lIn.bzp()));
                }
            }
            if (z) {
                NewSubPbActivity.this.jKS.Ul(null);
                NewSubPbActivity.this.jKS.bl(null);
                NewSubPbActivity.this.jKS.yw(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(NewSubPbActivity.this.getPageContext(), postWriteCallBackData);
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.jKS.bl(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.jKS.Ul(postWriteCallBackData.getErrorString());
                if (!y.isEmpty(NewSubPbActivity.this.jKS.dSS())) {
                    NewSubPbActivity.this.lwm = postWriteCallBackData;
                    if (NewSubPbActivity.this.kwo.bzJ()) {
                        NewSubPbActivity.this.kwo.a(NewSubPbActivity.this.lwm);
                    }
                    NewSubPbActivity.this.rk(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(NewSubPbActivity.this.getActivity(), NewSubPbActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(NewSubPbActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(NewSubPbActivity.this.getActivity());
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.AJ(NewSubPbActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.AJ(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(NewSubPbActivity.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new ar("c13746").ak("obj_locate", 1).ak("obj_type", 2));
                    }
                });
                aVar.b(NewSubPbActivity.this.getPageContext()).bog();
                TiebaStatic.log(new ar("c13745").ak("obj_locate", 1).ak("obj_type", 2));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.kwi != null) {
                NewSubPbActivity.this.kwi.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.lIp.dpe();
        }
    };
    private CustomMessageListener lva = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lIy) {
                NewSubPbActivity.this.lIp.cgz();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.luA.showSuccessToast(NewSubPbActivity.this.luz.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.luz.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.Ds(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.dkt();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (au.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.luz.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.luA.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lvb = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lIy) {
                NewSubPbActivity.this.lIp.cgz();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.luA.showSuccessToast(NewSubPbActivity.this.luz.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (au.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.luz.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.luA.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener lvc = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lIy) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.lIp.cgz();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.nmH;
                if (aVar.error == 0 && dataRes != null) {
                    boolean z2 = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0) == 1;
                    sparseArray.put(R.id.tag_user_mute_visible, true);
                    sparseArray.put(R.id.tag_user_mute_msg, dataRes.mute_confirm);
                    z = z2;
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, false);
                    z = false;
                }
                int intValue = sparseArray.get(R.id.tag_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_from)).intValue() : 0;
                if (intValue == 0) {
                    NewSubPbActivity.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    NewSubPbActivity.this.lIp.a(sparseArray, z);
                }
            }
        }
    };
    private final f.c gpT = new f.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (NewSubPbActivity.this.lIn != null) {
                NewSubPbActivity.this.lIn.dpB();
            }
        }
    };
    boolean lvq = false;
    private final b.InterfaceC0574b lvs = new b.InterfaceC0574b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0574b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.luD != null && !TextUtils.isEmpty(NewSubPbActivity.this.luE)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.luF == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.luE));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.luE;
                        aVar.pkgId = NewSubPbActivity.this.luF.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.luF.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.euQ == null) {
                            NewSubPbActivity.this.euQ = new bd(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.euQ.j(NewSubPbActivity.this.luE, NewSubPbActivity.this.luD.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.luD = null;
                NewSubPbActivity.this.luE = null;
            }
        }
    };
    private CustomMessageListener jXy = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener iJI = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    m mVar = (m) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.lIn.dpv() != null && NewSubPbActivity.this.lIn.dpv().dix() != null && NewSubPbActivity.this.lIn.dpv().dix().blC() != null && currentAccount.equals(NewSubPbActivity.this.lIn.dpv().dix().blC().getUserId()) && NewSubPbActivity.this.lIn.dpv().dix().blC().getPendantData() != null) {
                        NewSubPbActivity.this.lIn.dpv().dix().blC().getPendantData().As(mVar.bjy());
                        NewSubPbActivity.this.lIn.dpv().dix().blC().getPendantData().dF(mVar.bym());
                        NewSubPbActivity.this.lIp.a(NewSubPbActivity.this.lIn.dpv(), NewSubPbActivity.this.lIn.dpv().dix(), NewSubPbActivity.this.lIn.dpv().VH(), NewSubPbActivity.this.lIn.dpv().bhP(), NewSubPbActivity.this.lIn.dhW(), NewSubPbActivity.this.lIn.dpJ() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void callback(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        aD(bundle);
        if (getIntent() != null) {
            this.mIsFromSchema = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_FROM_SCHEMA, false);
        }
        super.onCreate(bundle);
        this.luz = getPageContext();
        this.lIx = true;
        this.jKS = new com.baidu.tieba.write.c();
        this.jKS.LK(R.color.cp_cont_h_alpha85);
        this.jKS.LJ(R.color.CAM_X0101);
        bVF();
        doT();
        initData(bundle);
        initUI();
        ((SubPbView) this.lIp.getRootView()).show();
        sG(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lIp.vp(this.mIsFromSchema);
        this.luA = new com.baidu.tbadk.core.view.c();
        this.luA.toastTime = 1000L;
        registerListener(this.lvc);
        registerListener(this.lva);
        registerListener(this.lvb);
        registerListener(this.lIF);
        this.lIy = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.lIy;
        userMuteAddAndDelCustomMessage.setTag(this.lIy);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.lIy;
        userMuteCheckCustomMessage.setTag(this.lIy);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.kwi = new am(getPageContext());
        this.kwi.a(new am.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.kwo.bzR();
                }
            }
        });
        this.lue = new com.baidu.tieba.pb.pb.report.a(this);
        this.lue.w(getUniqueId());
        this.lqj = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.lIp = new com.baidu.tieba.pb.pb.sub.a(this, this.aYm);
        this.lIp.a(this.lIn);
        setContentView(this.lIp.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.lIp.setOnScrollListener(this.lIr);
        this.lIp.b(this);
        this.lIp.setOnImageClickListener(this.lIs);
        this.lIp.setOnLongClickListener(this.mOnLongClickListener);
        this.lIp.g(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.lIn != null) {
                    NewSubPbActivity.this.lIn.loadData();
                }
            }
        });
        this.lIp.a(this.lIv);
        this.lIp.b(this.lIw);
        this.lIp.setListPullRefreshListener(this.gpT);
        if (this.lIn != null && this.lIn.doV() && !this.lIn.dpI()) {
            this.lIp.dpj().setVisibility(8);
        } else {
            this.lIp.dpj().setVisibility(0);
        }
        if (this.lIn != null && !this.lIn.doV()) {
            this.lIp.setIsFromPb(false);
        }
    }

    private boolean aD(Bundle bundle) {
        if (bundle != null) {
            this.fmT = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.fmT = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.fmT;
    }

    public void initData(Bundle bundle) {
        this.lIn = new SubPbModel(getPageContext());
        this.lIn.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                NewSubPbActivity.this.lIp.u(postData);
                NewSubPbActivity.this.lIp.b((BdListView.e) null);
            }
        });
        this.lIo = new ForumManageModel(getPageContext());
        this.lIo.setLoadDataCallBack(this.lIu);
        this.iIc = new VoiceManager();
        this.iIc.onCreate(getPageContext());
        this.luf = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.luf != null) {
            this.luf.a(this.lvl);
        }
        if (bundle != null) {
            this.lIn.initWithBundle(bundle);
        } else {
            this.lIn.initWithIntent(getIntent());
        }
        this.lIn.a(this.lIt);
        if (this.lIn.doV() && !this.lIn.dpO()) {
            this.lIn.loadData();
        } else {
            this.lIn.dpA();
        }
    }

    public void doT() {
        this.lIt = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, final p pVar) {
                if (NewSubPbActivity.this.lIp != null) {
                    NewSubPbActivity.this.lIp.dpe();
                    if (!z) {
                        NewSubPbActivity.this.bK(i, str);
                        return;
                    }
                    NewSubPbActivity.this.lIp.hideNoDataView();
                    if (pVar != null) {
                        if (pVar.dix() != null || NewSubPbActivity.this.lIn != null) {
                            pVar.dix().a(NewSubPbActivity.this.lIn.dpH());
                        }
                        if (NewSubPbActivity.this.lIp != null) {
                            NewSubPbActivity.this.sG(pVar.bjd() != null && pVar.bjd().isBjh());
                            if (NewSubPbActivity.this.kwo != null && NewSubPbActivity.this.kwo.byN() != null) {
                                NewSubPbActivity.this.kwo.byN().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.lIp.a(pVar, NewSubPbActivity.this.lIn.dhW(), NewSubPbActivity.this.lIn.dpJ() != null, NewSubPbActivity.this.lIx);
                            if (NewSubPbActivity.this.lIx) {
                                NewSubPbActivity.this.lIp.getListView().setSelectionFromTop(NewSubPbActivity.this.lIp.getListView().getHeaderViewsCount() + 1, -l.getDimens(NewSubPbActivity.this, R.dimen.tbds18));
                                NewSubPbActivity.this.doU();
                                NewSubPbActivity.this.lIx = false;
                            }
                        }
                        if (NewSubPbActivity.this.kwo != null) {
                            NewSubPbActivity.this.kwo.a(pVar.cwP());
                            NewSubPbActivity.this.kwo.setThreadData(pVar.bjd());
                            if (NewSubPbActivity.this.getIntent() != null && NewSubPbActivity.this.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && NewSubPbActivity.this.lIE) {
                                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NewSubPbActivity.this.lIE = false;
                                        NewSubPbActivity.this.c(pVar.dix(), false);
                                    }
                                }, 200L);
                            }
                        }
                        if (NewSubPbActivity.this.lIA == null) {
                            NewSubPbActivity.this.lIA = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.lIA.setData(pVar);
                        NewSubPbActivity.this.lIA.setType(0);
                        NewSubPbActivity.this.kwi.a(NewSubPbActivity.this.lIn.dpM());
                    }
                }
            }
        };
        this.lvl = new a.InterfaceC0571a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0571a
            public void d(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.luf != null) {
                        NewSubPbActivity.this.luf.is(z2);
                    }
                    MarkData bhS = NewSubPbActivity.this.luf.bhS();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(bhS);
                        if (NewSubPbActivity.this.luf != null) {
                            if (bhS != null) {
                                NewSubPbActivity.this.lIn.vr(true);
                                NewSubPbActivity.this.lIn.PC(NewSubPbActivity.this.lIn.bzp());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.lIp != null) {
                                NewSubPbActivity.this.lIp.vq(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.lIn.vr(false);
                        NewSubPbActivity.this.lIn.PC(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.lIp != null) {
                            NewSubPbActivity.this.lIp.vq(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.lIv = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.lIn.dpv() != null && NewSubPbActivity.this.lIn.dpv().bjd() != null && NewSubPbActivity.this.lIn.dpv().bjd().blC() != null) {
                    str = String.valueOf(NewSubPbActivity.this.lIn.dpv().bjd().blC().getUserId());
                }
                String str4 = "";
                if (objArr.length > 1) {
                    str4 = String.valueOf(objArr[1]);
                }
                String str5 = "";
                if (objArr.length > 2) {
                    str5 = String.valueOf(objArr[2]);
                }
                if (objArr.length > 3) {
                    str2 = String.valueOf(objArr[3]);
                }
                if (objArr.length > 4) {
                    str3 = String.valueOf(objArr[4]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.lIn.dpv().bzP().getId(), NewSubPbActivity.this.lIn.dpv().bzP().getName(), NewSubPbActivity.this.lIn.dpv().bjd().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.lIw = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.lIo.dKJ() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.lIn != null && NewSubPbActivity.this.lIn.dpv() != null && NewSubPbActivity.this.lIn.dpv().bzP() != null && NewSubPbActivity.this.lIn.dpv().bjd() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.lIo.SE(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.lIo.a(NewSubPbActivity.this.lIn.dpv().bzP().getId(), NewSubPbActivity.this.lIn.dpv().bzP().getName(), NewSubPbActivity.this.lIn.dpv().bjd().getId(), valueOf, i2, i, z, NewSubPbActivity.this.lIn.dpv().bjd().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.lIu = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.lIp.a(NewSubPbActivity.this.lIo.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.lIo.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.lJC != 1002 || bVar.gQe) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.lIp.a(1, dVar.QR, dVar.naF, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    /* renamed from: do  reason: not valid java name */
    public boolean m43do(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void bVF() {
        registerListener(this.iJI);
        this.aYm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            /* JADX DEBUG: Multi-variable search result rejected for r2v67, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostData postData;
                SparseArray sparseArray;
                SparseArray sparseArray2;
                boolean z = true;
                boolean z2 = false;
                SparseArray<Object> sparseArray3 = null;
                if (view != null || NewSubPbActivity.this.lIp != null) {
                    if (view == NewSubPbActivity.this.lIp.dpp()) {
                        NewSubPbActivity.this.lIp.dnA();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                bf.bqF().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.lIp.cCQ()) {
                        if (view != NewSubPbActivity.this.lIp.dpi()) {
                            if (view == NewSubPbActivity.this.lIp.dph()) {
                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                    NewSubPbActivity.this.lIp.doX();
                                    NewSubPbActivity.this.lIp.doY();
                                    if (NewSubPbActivity.this.kwo != null) {
                                        NewSubPbActivity.this.kwo.bzX();
                                    }
                                }
                            } else if (view.getId() != R.id.pb_floor_feedback) {
                                if (view == NewSubPbActivity.this.lIp.dpc()) {
                                    NewSubPbActivity.this.lIp.dnA();
                                    if (NewSubPbActivity.this.lIn.loadData()) {
                                        NewSubPbActivity.this.lIp.dpa();
                                    }
                                } else if (view == NewSubPbActivity.this.lIp.dpj() || view == NewSubPbActivity.this.lIp.dpk() || view == NewSubPbActivity.this.lIp.dpm()) {
                                    if (NewSubPbActivity.this.lIz) {
                                        NewSubPbActivity.this.lIz = false;
                                        return;
                                    }
                                    if (NewSubPbActivity.this.lIn.dpv() != null && NewSubPbActivity.this.lIn.dpv().bjd() != null) {
                                        z2 = az.a(NewSubPbActivity.this.lIn.dpv().bjd().getBaijiahaoData());
                                    }
                                    if (z2) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.lIn.dkU(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.lIn.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.lIn.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.lIn.dpv() != null && NewSubPbActivity.this.lIn.dpv().bjd() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.lIn.dpv().bjd().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.lIn.dkU(), NewSubPbActivity.this.lIn.bzp(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.lIn.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.lIn.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.lIp.dpn() == null || view != NewSubPbActivity.this.lIp.dpn().dlT()) {
                                    if (NewSubPbActivity.this.lIp.dpn() == null || view != NewSubPbActivity.this.lIp.dpn().dlW()) {
                                        if (NewSubPbActivity.this.lIp.dpn() == null || view != NewSubPbActivity.this.lIp.dpn().dlU()) {
                                            if (NewSubPbActivity.this.lIp.dpn() == null || view != NewSubPbActivity.this.lIp.dpn().dlV()) {
                                                if (NewSubPbActivity.this.lIp.dpn() == null || view != NewSubPbActivity.this.lIp.dpn().dlX()) {
                                                    if (view == NewSubPbActivity.this.lIp.dpg() || view == NewSubPbActivity.this.lIp.dpm()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.kwo.bzU()) {
                                                                NewSubPbActivity.this.kwo.bzV();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.kwo.Dt(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view != null && (view.getTag() instanceof n)) {
                                                        NewSubPbActivity.this.lIC = (n) view.getTag();
                                                        if (bh.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.lIz) {
                                                                NewSubPbActivity.this.lIz = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.kwi == null || NewSubPbActivity.this.lIn == null || NewSubPbActivity.this.lIn.cwP() == null || NewSubPbActivity.this.kwi.pp(NewSubPbActivity.this.lIn.cwP().replyPrivateFlag)) && (sparseArray2 = (SparseArray) view.getTag(R.id.tag_from)) != null) {
                                                                if (!(view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) || view.getTag(R.id.tag_subpb_ban_display_keyboard) != Boolean.TRUE) {
                                                                    z = false;
                                                                }
                                                                NewSubPbActivity.this.b(sparseArray2, z);
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view.getId() != R.id.post_info_commont_img && view.getId() != R.id.pb_floor_comment_container) {
                                                        if (NewSubPbActivity.this.lIq == null || view != NewSubPbActivity.this.lIq.dlV()) {
                                                            if (NewSubPbActivity.this.lIq == null || view != NewSubPbActivity.this.lIq.dlT()) {
                                                                if (NewSubPbActivity.this.lIq == null || view != NewSubPbActivity.this.lIq.dlW()) {
                                                                    if (NewSubPbActivity.this.lIq == null || view != NewSubPbActivity.this.lIq.dlX()) {
                                                                        if (NewSubPbActivity.this.lIq == null || view != NewSubPbActivity.this.lIq.dlZ()) {
                                                                            if (NewSubPbActivity.this.lIq == null || view != NewSubPbActivity.this.lIq.dma()) {
                                                                                if (NewSubPbActivity.this.lIq == null || view != NewSubPbActivity.this.lIq.dmb()) {
                                                                                    if (NewSubPbActivity.this.lIq != null && view == NewSubPbActivity.this.lIq.dlU()) {
                                                                                        if (!j.isNetWorkAvailable()) {
                                                                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                                                            return;
                                                                                        }
                                                                                        SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                                                                                        if (sparseArray4 != null) {
                                                                                            boolean booleanValue = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                            boolean booleanValue2 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                            boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                            if (booleanValue) {
                                                                                                if (booleanValue3) {
                                                                                                    sparseArray4.put(R.id.tag_from, 1);
                                                                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                                                                    NewSubPbActivity.this.c(sparseArray4);
                                                                                                    return;
                                                                                                }
                                                                                                sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                                                                NewSubPbActivity.this.lIp.dt(view);
                                                                                                return;
                                                                                            } else if (booleanValue2) {
                                                                                                NewSubPbActivity.this.lIp.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                                return;
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    int id = view.getId();
                                                                                    if (id == R.id.pb_item_tail_content) {
                                                                                        if (bh.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                            String string2 = com.baidu.tbadk.core.sharedPref.b.bpu().getString("tail_link", "");
                                                                                            if (!StringUtils.isNull(string2)) {
                                                                                                TiebaStatic.log("c10056");
                                                                                                com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    } else if (id == R.id.richText && (view.getTag() instanceof SparseArray)) {
                                                                                        Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
                                                                                        if (obj instanceof PostData) {
                                                                                            PostData postData2 = (PostData) obj;
                                                                                            if (postData2.getType() != PostData.eCj && !TextUtils.isEmpty(postData2.getBimg_url()) && k.biL().isShowImages()) {
                                                                                                NewSubPbActivity.this.Pz(postData2.getId());
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (NewSubPbActivity.this.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                                                                                    PostData postData3 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                                    if (postData3.bnv() != null) {
                                                                                        NewSubPbActivity.this.d(postData3.bnv());
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.luD != null && !TextUtils.isEmpty(NewSubPbActivity.this.luE)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.euQ == null) {
                                                                                        NewSubPbActivity.this.euQ = new bd(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.euQ.j(NewSubPbActivity.this.luE, NewSubPbActivity.this.luD.getImageByte());
                                                                                    NewSubPbActivity.this.luD = null;
                                                                                    NewSubPbActivity.this.luE = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.luD != null && !TextUtils.isEmpty(NewSubPbActivity.this.luE)) {
                                                                            if (NewSubPbActivity.this.luF == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.luE));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.luE;
                                                                                aVar.pkgId = NewSubPbActivity.this.luF.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.luF.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.luD = null;
                                                                            NewSubPbActivity.this.luE = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.jLA != null) {
                                                                        NewSubPbActivity.this.jLA.fS(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.jLA = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                if (sparseArray5 != null && (sparseArray5.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_id) instanceof String) && (sparseArray5.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.lIp.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.dn(view);
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (!j.isNetWorkAvailable()) {
                                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                            return;
                                                        } else {
                                                            Object tag = view.getTag();
                                                            if (tag instanceof String) {
                                                                NewSubPbActivity.this.OW((String) tag);
                                                                return;
                                                            } else if (tag instanceof SparseArray) {
                                                                SparseArray<Object> sparseArray6 = (SparseArray) tag;
                                                                if ((sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                                    sparseArray6.put(R.id.tag_from, 0);
                                                                    sparseArray6.put(R.id.tag_check_mute_from, 2);
                                                                    NewSubPbActivity.this.c(sparseArray6);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    } else if (NewSubPbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                        SparseArray sparseArray7 = (SparseArray) view.getTag();
                                                        if ((sparseArray7.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray7.get(R.id.tag_load_sub_data)) != null) {
                                                            if (NewSubPbActivity.this.lIn != null) {
                                                                TiebaStatic.log(new ar("c13700").dR("tid", NewSubPbActivity.this.lIn.dkV()).dR("fid", NewSubPbActivity.this.lIn.getFromForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).ak("obj_type", 3));
                                                            }
                                                            if (!(view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) || view.getTag(R.id.tag_subpb_ban_display_keyboard) != Boolean.TRUE) {
                                                                z = false;
                                                            }
                                                            NewSubPbActivity.this.c(postData, z);
                                                            return;
                                                        }
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (view.getTag() != null && (view.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                    if (sparseArray8.get(R.id.tag_clip_board) instanceof PostData) {
                                                        ((PostData) sparseArray8.get(R.id.tag_clip_board)).fS(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new ar("c11739").ak("obj_locate", 4));
                                            if (!j.isNetWorkAvailable()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.lIp.dnA();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.OW(str4);
                                                    return;
                                                }
                                                return;
                                            } else if (tag2 instanceof SparseArray) {
                                                SparseArray<Object> sparseArray9 = (SparseArray) tag2;
                                                if ((sparseArray9.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray9.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray9.put(R.id.tag_from, 0);
                                                    sparseArray9.put(R.id.tag_check_mute_from, 2);
                                                    NewSubPbActivity.this.c(sparseArray9);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        } else if (j.isNetWorkAvailable()) {
                                            NewSubPbActivity.this.lIp.dnA();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.dw(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.lIp.dnA();
                                    SparseArray sparseArray10 = (SparseArray) view.getTag();
                                    if (sparseArray10 != null) {
                                        NewSubPbActivity.this.lIp.a(((Integer) sparseArray10.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray10.get(R.id.tag_del_post_id), ((Integer) sparseArray10.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new ar("c11739").ak("obj_locate", 2));
                                    NewSubPbActivity.this.lIp.dnA();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.lIn.dpv() != null) {
                                        NewSubPbActivity.this.n(NewSubPbActivity.this.lIn.dpv().dix());
                                    }
                                }
                            } else {
                                try {
                                    sparseArray3 = (SparseArray) view.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                }
                                if (sparseArray3 != null && ((PostData) sparseArray3.get(R.id.tag_clip_board)) != null) {
                                    if (NewSubPbActivity.this.lIq == null) {
                                        NewSubPbActivity.this.lIq = new ah(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aYm);
                                        NewSubPbActivity.this.lIp.dx(NewSubPbActivity.this.lIq.getView());
                                        NewSubPbActivity.this.lIq.uB(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.lIq.PA();
                                    if (NewSubPbActivity.this.um(sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin()) {
                                        z2 = true;
                                    }
                                    NewSubPbActivity.this.lIq.a(sparseArray3, NewSubPbActivity.this.dhW(), z2);
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.lIp.doX();
                            NewSubPbActivity.this.lIp.doY();
                            if (NewSubPbActivity.this.kwo != null) {
                                NewSubPbActivity.this.kwo.bzW();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.djS();
                        if (NewSubPbActivity.this.lIn != null && NewSubPbActivity.this.lIn.dpv() != null && NewSubPbActivity.this.lIn.dpv().bjd() != null && NewSubPbActivity.this.lIn.dpv().bjd().blC() != null) {
                            TiebaStatic.log(new ar("c13402").dR("tid", NewSubPbActivity.this.lIn.dkU()).w("fid", NewSubPbActivity.this.lIn.dpv().bjd().getFid()).ak("obj_locate", 5).dR("uid", NewSubPbActivity.this.lIn.dpv().bjd().blC().getUserId()));
                        }
                    }
                }
            }
        };
        this.lIr = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.lIp.dnA();
                    if (NewSubPbActivity.this.lpF != 2 && NewSubPbActivity.this.lpF != 1) {
                        NewSubPbActivity.this.lIp.dps();
                    }
                }
                NewSubPbActivity.this.kwo.bzV();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.lIp.dpo();
            }
        };
        this.mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
            @Override // android.view.View.OnLongClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onLongClick(View view) {
                SparseArray<Object> sparseArray;
                SparseArray<Object> sparseArray2;
                boolean z = false;
                if (NewSubPbActivity.this.lIp != null && NewSubPbActivity.this.lIp.dpf()) {
                    return false;
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null && NewSubPbActivity.this.m43do(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.luD = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.luE = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.luD == null || TextUtils.isEmpty(NewSubPbActivity.this.luE)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.luF = null;
                        } else {
                            NewSubPbActivity.this.luF = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.luD = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.luE = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.luF = null;
                        } else {
                            NewSubPbActivity.this.luF = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.luD = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.luE = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.luF = null;
                        } else {
                            NewSubPbActivity.this.luF = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    }
                    if (view.getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                        } catch (ClassCastException e2) {
                            e2.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                        NewSubPbActivity.this.lIp.a(NewSubPbActivity.this.lvs, NewSubPbActivity.this.luD.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.jLA = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.jLA == null || NewSubPbActivity.this.luf == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.luf != null) {
                            NewSubPbActivity.this.luf.is(NewSubPbActivity.this.lIn.dpC());
                        }
                        boolean z2 = NewSubPbActivity.this.luf.bhP() && NewSubPbActivity.this.jLA.getId() != null && NewSubPbActivity.this.jLA.getId().equals(NewSubPbActivity.this.lIn.dpE());
                        if (NewSubPbActivity.this.lIq == null) {
                            NewSubPbActivity.this.lIq = new ah(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aYm);
                            NewSubPbActivity.this.lIp.dx(NewSubPbActivity.this.lIq.getView());
                            NewSubPbActivity.this.lIq.uB(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.lIq.PA();
                        boolean z3 = NewSubPbActivity.this.um(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z4 = (NewSubPbActivity.this.lIn.dpv() == null || NewSubPbActivity.this.lIn.dpv().bjd() == null || !NewSubPbActivity.this.lIn.dpv().bjd().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z2) {
                            NewSubPbActivity.this.lIq.dlT().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.lIq.dlT().setText(R.string.mark);
                        }
                        if (booleanValue || z4) {
                            NewSubPbActivity.this.lIq.dlT().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.lIq.dlT().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.m43do(view)) {
                            if (NewSubPbActivity.this.luD != null && !NewSubPbActivity.this.luD.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        ah ahVar = NewSubPbActivity.this.lIq;
                        int dhW = NewSubPbActivity.this.dhW();
                        if (NewSubPbActivity.this.lrD && NewSubPbActivity.this.jLA.mYG) {
                            z = true;
                        }
                        ahVar.a(sparseArray2, dhW, z3, z);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.lIs = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
            /* JADX DEBUG: Multi-variable search result rejected for r8v6, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i, boolean z, boolean z2) {
                String str2;
                String str3;
                boolean z3;
                String str4;
                boolean z4;
                try {
                    if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        p dpv = NewSubPbActivity.this.lIn.dpv();
                        TbRichText by = NewSubPbActivity.this.by(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (by != null && by.bFb() != null) {
                            tbRichTextData = by.bFb().get(NewSubPbActivity.this.lvp);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!tbRichTextData.bFh().bFv()) {
                                String c = NewSubPbActivity.this.c(tbRichTextData);
                                arrayList.add(c);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap.put(c, imageUrlData);
                                String str5 = null;
                                String str6 = null;
                                String str7 = null;
                                if (dpv == null) {
                                    str4 = null;
                                    z4 = false;
                                } else {
                                    if (dpv.bzP() != null) {
                                        str5 = dpv.bzP().getName();
                                        str6 = dpv.bzP().getId();
                                    }
                                    if (dpv.bjd() != null) {
                                        str7 = dpv.bjd().getId();
                                    }
                                    str4 = str7;
                                    z4 = true;
                                }
                                if (NewSubPbActivity.this.lIn.dpJ() != null) {
                                    concurrentHashMap = NewSubPbActivity.this.lIn.dpJ();
                                    z4 = NewSubPbActivity.this.lIn.dpL();
                                    arrayList = NewSubPbActivity.this.lIn.dpK();
                                }
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(y.getItem(arrayList, 0));
                                ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                                aVar.x(arrayList2).zZ(str5).Aa(str6).Ab(str4).iy(z4).Ac(arrayList.get(0)).iz(true).a(concurrentHashMap).iA(true).iB(false).iC(false).s(NewSubPbActivity.this.bjd()).Ad(String.valueOf(by.getPostId())).Ae(NewSubPbActivity.this.lIn.getFromForumId());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar.dU(NewSubPbActivity.this.getPageContext().getPageActivity())));
                                return;
                            }
                            NewSubPbActivity.this.lvq = false;
                            TbRichText dJS = dpv.dix().dJS();
                            int size = arrayList.size();
                            int a2 = NewSubPbActivity.this.a(dJS, by, i, i, arrayList, concurrentHashMap);
                            int size2 = arrayList.size();
                            if (size == size2) {
                                str2 = "";
                            } else {
                                str2 = arrayList.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (dpv == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (dpv.bzP() != null) {
                                    str8 = dpv.bzP().getName();
                                    str9 = dpv.bzP().getId();
                                }
                                if (dpv.bjd() != null) {
                                    str10 = dpv.bjd().getId();
                                }
                                str3 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.lIn.dpJ() != null) {
                                concurrentHashMap = NewSubPbActivity.this.lIn.dpJ();
                                z3 = NewSubPbActivity.this.lIn.dpL();
                                arrayList = NewSubPbActivity.this.lIn.dpK();
                                a2 += NewSubPbActivity.this.lIn.getOffset();
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(y.getItem(arrayList, a2));
                            ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                            aVar2.x(arrayList3).zZ(str8).Aa(str9).Ab(str3).iy(z3).Ac(str2).iz(true).a(concurrentHashMap).iA(true).iB(false).iC(false).s(NewSubPbActivity.this.bjd()).Ad(String.valueOf(by.getPostId())).Ae(NewSubPbActivity.this.lIn.getFromForumId());
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar2.dU(NewSubPbActivity.this.getPageContext().getPageActivity())));
                            return;
                        }
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS, isGif)));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public bx bjd() {
        if (this.lIn == null || this.lIn.dpv() == null) {
            return null;
        }
        return this.lIn.dpv().bjd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            n(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SparseArray<Object> sparseArray, boolean z) {
        if (sparseArray != null) {
            if (sparseArray.get(R.id.tag_clip_board) instanceof PostData) {
                c((PostData) sparseArray.get(R.id.tag_clip_board), z);
            } else {
                c((PostData) null, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostData postData, boolean z) {
        if (postData != null) {
            if (postData.blC() != null) {
                MetaData blC = postData.blC();
                this.kwo.setReplyId(blC.getUserId());
                boolean z2 = postData.mYG;
                String str = "";
                if (postData.dJS() != null) {
                    str = postData.dJS().toString();
                }
                this.kwo.Dv(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.blC().getName_show(), str));
                if (z2) {
                    if (!z) {
                        this.kwo.Du("");
                    }
                } else if (!z) {
                    this.kwo.Du(blC.getName_show());
                }
            }
            this.lIp.doY();
        }
        if (this.lIB) {
            vo(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eQi == null) {
                this.eQi = new com.baidu.tbadk.core.message.a();
            }
            if (this.ePS == null) {
                this.ePS = new e();
                this.ePS.uniqueId = this.lID;
            }
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.exI = 12;
            dVar.exO = 9;
            dVar.exN = 3;
            if (doW() != null) {
                dVar.exM = doW().dpN();
            }
            if (dVar != null) {
                dVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (dVar != null) {
                        dVar.exP = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (dVar != null) {
                        dVar.exP = 1;
                        i = 0;
                    }
                }
                this.eQi.a(agreeData, i, getUniqueId(), false);
                this.eQi.a(agreeData, this.ePS);
                if (doW() == null && doW().dpv() != null) {
                    this.eQi.a(this, dVar, agreeData, doW().dpv().bjd());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (dVar != null) {
                dVar.exP = 1;
            }
            i = 0;
            this.eQi.a(agreeData, i, getUniqueId(), false);
            this.eQi.a(agreeData, this.ePS);
            if (doW() == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bFh;
        if (tbRichText == tbRichText2) {
            this.lvq = true;
        }
        if (tbRichText != null && tbRichText.bFb() != null) {
            int size = tbRichText.bFb().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.bFb().get(i6) != null && tbRichText.bFb().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.bFb().get(i6).bFh().getWidth() * equipmentDensity;
                    int height = tbRichText.bFb().get(i6).bFh().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.bFb().get(i6).bFh().bFv()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.bFb().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (bFh = tbRichTextData.bFh()) != null) {
                            String bFx = bFh.bFx();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = bFx;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.lvq) {
                            i4 = i7 + 1;
                            i3 = i5;
                        }
                    }
                    i6++;
                    i7 = i4;
                    i5 = i3;
                }
                i3 = i5;
                i4 = i7;
                i6++;
                i7 = i4;
                i5 = i3;
            }
            return i7;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (this.lIq != null) {
            this.lIq.uB(z);
        }
        if (this.lIp != null) {
            this.lIp.uB(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bFh = tbRichTextData.bFh();
        if (bFh != null) {
            if (!StringUtils.isNull(bFh.bFu())) {
                return bFh.bFu();
            }
            if (bFh.getHeight() * bFh.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bFh.getHeight() * bFh.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bFh.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bFh.getHeight())));
            } else {
                float width = bFh.getWidth() / bFh.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(au.getUrlEncode(bFh.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText by(String str, int i) {
        if (this.lIn == null || this.lIn.dpv() == null || str == null || i < 0) {
            return null;
        }
        p dpv = this.lIn.dpv();
        TbRichText a2 = a(dpv.dix(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(dpv.dix(), str, i);
            if (a3 != null) {
            }
            return a3;
        }
        return a2;
    }

    private TbRichText a(PostData postData, String str, int i) {
        if (postData == null) {
            return null;
        }
        TbRichText dJS = postData.dJS();
        if (dJS != null) {
            ArrayList<TbRichTextData> bFb = dJS.bFb();
            int size = bFb.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (bFb.get(i3) != null && bFb.get(i3).getType() == 8) {
                    i2++;
                    if (bFb.get(i3).bFh().bFx().equals(str)) {
                        int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = bFb.get(i3).bFh().getWidth() * equipmentDensity;
                        int height = bFb.get(i3).bFh().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.lvp = i3;
                        return dJS;
                    } else if (i2 > i) {
                        break;
                    }
                }
                i3++;
                i2 = i2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djS() {
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false) {
            if (this.kwi == null || this.lIn == null || this.lIn.cwP() == null || this.kwi.pp(this.lIn.cwP().replyPrivateFlag)) {
                if (this.kwo.bzJ()) {
                    this.kwo.a((PostWriteCallBackData) null);
                    return;
                }
                this.lIp.doX();
                this.lIp.doY();
                if (this.kwo != null) {
                    this.kwo.bzY();
                    return;
                }
                return;
            }
            return;
        }
        if (this.iMx == null) {
            this.iMx = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.iMx.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void pL(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void C(boolean z, int i) {
                }

                /* JADX WARN: Removed duplicated region for block: B:26:0x00bf  */
                /* JADX WARN: Removed duplicated region for block: B:27:0x00ca  */
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void pM(boolean z) {
                    String str;
                    if (z) {
                        if (NewSubPbActivity.this.kwi == null || NewSubPbActivity.this.lIn == null || NewSubPbActivity.this.lIn.cwP() == null || NewSubPbActivity.this.kwi.pp(NewSubPbActivity.this.lIn.cwP().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.lIn != null && NewSubPbActivity.this.lIn.dpv() != null && NewSubPbActivity.this.lIn.dpv().dix() != null) {
                                PostData dix = NewSubPbActivity.this.lIn.dpv().dix();
                                if (dix.dJS() != null && dix.blC() != null) {
                                    str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), dix.blC().getName_show(), dix.dJS().toString());
                                    NewSubPbActivity.this.kwo.byN().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                                    if (!NewSubPbActivity.this.kwo.bzJ()) {
                                        NewSubPbActivity.this.kwo.a((PostWriteCallBackData) null);
                                        return;
                                    }
                                    NewSubPbActivity.this.lIp.doX();
                                    NewSubPbActivity.this.lIp.doY();
                                    if (NewSubPbActivity.this.kwo != null) {
                                        NewSubPbActivity.this.kwo.bzY();
                                        return;
                                    }
                                    return;
                                }
                            }
                            str = null;
                            NewSubPbActivity.this.kwo.byN().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                            if (!NewSubPbActivity.this.kwo.bzJ()) {
                            }
                        }
                    }
                }
            });
        }
        if (this.lIn != null && this.lIn.dpv() != null && this.lIn.dpv().bzP() != null) {
            this.iMx.G(this.lIn.dpv().bzP().getId(), com.baidu.adp.lib.f.b.toLong(this.lIn.dkU(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean um(boolean z) {
        if (this.lIn == null) {
            return false;
        }
        return ((dhW() != 0) || this.lIn.dpv() == null || this.lIn.dpv().bjd() == null || this.lIn.dpv().bjd().blC() == null || this.lIn.dpv().bjd().bkm() || TextUtils.equals(this.lIn.dpv().bjd().blC().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(int i, String str) {
        if (this.lIn.dpw()) {
            showToast(str);
        } else if (l.isNetOk()) {
            if (i == 4) {
                this.lIp.Iu(str + "(4)");
            } else {
                this.lIp.Do(R.string.no_data_text);
            }
        } else {
            this.lIp.Do(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sG(boolean z) {
        this.kwo = (com.baidu.tbadk.editortools.pb.h) new i(z).ei(getActivity());
        if (this.kwo != null) {
            this.kwo.a(getPageContext());
            this.kwo.b(this.lIn);
            this.kwo.b(this.jKZ);
            this.kwo.setFrom(2);
            this.kwo.a(this.foW);
            this.kwo.a(this.foX);
            this.kwo.byN().kc(true);
            this.kwo.j(getPageContext());
        }
        if (this.lIp != null) {
            this.lIp.i(this.kwo);
        }
        if (this.kwo != null && this.lIn != null) {
            this.kwo.a(this.lIn.cwP());
            this.kwo.bzV();
        }
        if (this.kwo != null) {
            this.kwo.bzZ().setDefaultHint(dmM());
            this.kwo.bzZ().setHint(dmM());
            this.jKT = this.kwo.bzZ().getInputView();
            this.jKT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.jKS != null) {
                        if (!NewSubPbActivity.this.jKS.dSV()) {
                            NewSubPbActivity.this.rk(false);
                        }
                        NewSubPbActivity.this.jKS.yx(false);
                    }
                }
            });
        }
    }

    public void doU() {
        if (!TbadkCoreApplication.isLogin()) {
            this.kwo.bzV();
        } else if (!StringUtils.isNull(this.lIn.dpF())) {
            if (this.lIp.dpb() && l.isNetOk()) {
                this.lIp.cuO();
            } else {
                this.lIp.dpe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dw(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(R.id.tag_from, 1);
                    c(sparseArray);
                } else {
                    this.lIp.dt(view);
                }
            } else if (booleanValue2) {
                this.lIp.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.lIp.dpl(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        final String str;
        if (!(sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
            String[] strArr = new String[1];
            strArr[0] = z ? getResources().getString(R.string.un_mute) : getResources().getString(R.string.mute);
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            bVar.ox(R.string.operation);
            bVar.a(strArr, new b.InterfaceC0574b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0574b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    switch (i) {
                        case 0:
                            String str2 = "";
                            String str3 = "";
                            String str4 = "";
                            String str5 = "";
                            String str6 = "";
                            if (sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String) {
                                str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            }
                            if (sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String) {
                                str3 = (String) sparseArray.get(R.id.tag_user_mute_thread_id);
                            }
                            if (sparseArray.get(R.id.tag_user_mute_post_id) instanceof String) {
                                str4 = (String) sparseArray.get(R.id.tag_user_mute_post_id);
                            }
                            if (sparseArray.get(R.id.tag_user_mute_msg) instanceof String) {
                                str5 = (String) sparseArray.get(R.id.tag_user_mute_msg);
                            }
                            if (sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String) {
                                str6 = (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow);
                            }
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.lIy);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.lIy);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).boi();
        }
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.lIp.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.lIy;
        userMuteCheckCustomMessage.setTag(this.lIy);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.lIp.a(0, bVar.QR, bVar.naF, z);
            if (bVar.QR) {
                if (bVar.ioW == 1) {
                    if (this.lIp.getListView() instanceof BdTypeListView) {
                        List<q> data = ((BdTypeListView) this.lIp.getListView()).getData();
                        if (!y.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.lIp.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.ioW == 2) {
                    this.lIn.PB(bVar.mPostId);
                    this.lIp.a(this.lIn.dpv(), this.lIn.dhW(), this.lIn.dpJ() != null, false);
                    if (this.lIn.dpG()) {
                        this.lIn.vs(false);
                        this.lIp.doZ();
                        this.lIn.loadData();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void OW(String str) {
        if (this.lIn != null && this.lIn.dpv() != null && this.lIn.dpv().bjd() != null && this.lIn.dpv().bjd().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lIn.dkU(), str);
            bx bjd = this.lIn.dpv().bjd();
            if (bjd.bkk()) {
                format = format + "&channelid=33833";
            } else if (bjd.bny()) {
                format = format + "&channelid=33842";
            } else if (bjd.bkl()) {
                format = format + "&channelid=33840";
            }
            OX(format);
            return;
        }
        this.lue.Px(str);
    }

    private void OX(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void n(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.lIn.dpC() && postData.getId() != null && postData.getId().equals(this.lIn.dpE())) {
                z = true;
            }
            MarkData o = this.lIn.o(postData);
            if (o != null) {
                this.lIp.dnA();
                if (this.luf != null) {
                    this.luf.a(o);
                    if (!z) {
                        this.luf.bhR();
                    } else {
                        this.luf.bhQ();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.lIn != null) {
            this.lIn.aC(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.kwo != null) {
            this.kwo.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.kwo.byN().bxk();
        this.kwo.bzV();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kwo.b(writeData);
                this.kwo.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.m rI = this.kwo.byN().rI(6);
                if (rI != null && rI.fmx != null) {
                    rI.fmx.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kwo.bzR();
                }
                this.lIp.dps();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iIc != null) {
            this.iIc.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.bfy().bfJ();
        if (this.iIc != null) {
            this.iIc.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.jXy);
        this.lIp.cFf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
        dkx();
        if (this.iIc != null) {
            this.iIc.onResume(getPageContext());
        }
        registerListener(this.jXy);
        this.lIp.cFg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.iIc != null) {
            this.iIc.onStop(getPageContext());
        }
        this.kwo.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.lIA));
        this.lIn.cancelLoadData();
        this.lIn.destory();
        this.lIo.cancelLoadData();
        if (this.iIc != null) {
            this.iIc.onDestory(getPageContext());
        }
        this.lIp.dnA();
        this.lIp.cDp();
        MessageManager.getInstance().unRegisterListener(this.lva);
        MessageManager.getInstance().unRegisterListener(this.lvb);
        MessageManager.getInstance().unRegisterListener(this.lvc);
        MessageManager.getInstance().unRegisterListener(this.lIy);
        this.luz = null;
        this.luA = null;
        if (this.kwi != null) {
            this.kwi.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lIp.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iIc;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View dpg = this.lIp.dpg();
        if (dpg == null || (findViewWithTag = dpg.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Pp(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = bf.getParamPair(bf.getParamStr(str))) != null) {
            this.lIz = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Pp(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(lIm);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void f(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (Pp(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                    lVar.mLink = str;
                    lVar.type = 3;
                    lVar.flv = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
                }
            } else {
                bf.bqF().b(getPageContext(), new String[]{str});
            }
            this.lIz = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void au(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lIz = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void av(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aw(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ax(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void u(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        if (this.lIp != null) {
            return this.lIp.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bFM() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bFO() {
        if (this.fIE == null) {
            this.fIE = TbRichTextView.A(getPageContext().getPageActivity(), 8);
        }
        return this.fIE;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bFP() {
        if (this.fFo == null) {
            this.fFo = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: csv */
                public GifView makeObject() {
                    return new GifView(NewSubPbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: g */
                public void destroyObject(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: h */
                public GifView activateObject(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: i */
                public GifView passivateObject(GifView gifView) {
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fFo;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bFN() {
        if (this.fFn == null) {
            this.fFn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bFZ */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = k.biL().isShowImages();
                    foreDrawableImageView.setDefaultBg(ap.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: a */
                public void destroyObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: b */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (k.biL().isShowImages()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(R.drawable.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: c */
                public ImageView passivateObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.fFn;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bFQ() {
        if (this.fIF == null) {
            this.fIF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dkE */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(NewSubPbActivity.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dp */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dq */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dr */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fIF;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bFR() {
        if (this.fIG == null) {
            this.fIG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dkG */
                public LinearLayout makeObject() {
                    LinearLayout linearLayout = new LinearLayout(NewSubPbActivity.this.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setGravity(16);
                    linearLayout.setBaselineAligned(true);
                    linearLayout.setOrientation(1);
                    linearLayout.setLayoutParams(layoutParams);
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: f */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.fIG;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bFS() {
        this.fIH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dkF */
            public RelativeLayout makeObject() {
                return new RelativeLayout(NewSubPbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public RelativeLayout activateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public RelativeLayout passivateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.fIH;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a diM() {
        return this.lqj;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean diN() {
        return (this.lIn == null || this.lIn.dpv() == null || this.lIn.dpv().bjd() == null || this.lIn.dpv().bjd().bnb()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String diO() {
        if (this.lIn == null || this.lIn.dpv() == null || this.lIn.dpv().bjd() == null) {
            return null;
        }
        return this.lIn.dpv().bjd().blG();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int diP() {
        if (this.lIn == null) {
            return 0;
        }
        return this.lIn.dhW();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean OQ(String str) {
        if (StringUtils.isNull(str) || this.lIn == null || this.lIn.dpv() == null || this.lIn.dpv().bjd() == null || this.lIn.dpv().bjd().blC() == null) {
            return false;
        }
        return str.equals(this.lIn.dpv().bjd().blC().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.lIp.dpb() && l.isNetOk()) {
            this.lIn.loadData();
        } else {
            this.lIp.dpe();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String) {
            str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
        }
        if (sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String) {
            str4 = (String) sparseArray.get(R.id.tag_user_mute_thread_id);
        }
        if (!(sparseArray.get(R.id.tag_user_mute_post_id) instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) sparseArray.get(R.id.tag_user_mute_post_id);
        }
        String str7 = sparseArray.get(R.id.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_msg) : str2;
        if (sparseArray.get(R.id.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(R.id.tag_user_mute_msg);
        }
        if (sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String) {
            str6 = (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.lIy);
        userMuteAddAndDelCustomMessage.setTag(this.lIy);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pz(String str) {
        if (!StringUtils.isNull(str) && bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bpu().getString("bubble_link", "");
            if (!StringUtils.isNull(string)) {
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                    return;
                }
                com.baidu.tbadk.browser.a.startWebActivity(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), string + "?props_id=" + str, true, true, true);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ay(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB_FLOOR;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.bBw().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.lIn != null) {
            if (this.lIn.dpv() != null && this.lIn.dpv().bzP() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.lIn.dpv().bzP().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.lIn.dkU(), 0L));
            if (this.lIn.dpv() != null && this.lIn.dpv().bjd() != null) {
                pageStayDurationItem.setNid(this.lIn.dpv().bjd().getNid());
            }
            pageStayDurationItem.setPid(com.baidu.adp.lib.f.b.toLong(this.lIn.bzp(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public boolean doV() {
        if (this.lIn != null) {
            return this.lIn.doV();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.lIp.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.luz.getPageActivity());
        if (au.isEmpty(str)) {
            aVar.AJ(this.luz.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.AJ(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.lIp.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.luz).bog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ds(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.luz.getPageActivity());
        aVar.AJ(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.luz).bog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkt() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.AJ(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.luz).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.luz.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.luz).bog();
    }

    public SubPbModel doW() {
        return this.lIn;
    }

    public int dhW() {
        if (this.lIn != null) {
            return this.lIn.dhW();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.fmT && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fmT && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void rk(boolean z) {
        if (this.jKT != null && this.jKT.getText() != null) {
            int selectionEnd = this.jKT.getSelectionEnd();
            SpannableStringBuilder c = this.jKS.c(this.jKT.getText());
            if (c != null) {
                this.jKS.yx(true);
                this.jKT.setText(c);
                if (z && this.jKS.dST() >= 0) {
                    this.jKT.requestFocus();
                    this.jKT.setSelection(this.jKS.dST());
                } else {
                    this.jKT.setSelection(selectionEnd);
                }
                this.jKS.yw(this.jKS.dST() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kwo != null && this.kwo.byN() != null && this.kwo.byN().byR()) {
            this.kwo.byN().bxk();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        ag.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    public String dmM() {
        if (!au.isEmpty(this.lDb)) {
            return this.lDb;
        }
        this.lDb = getResources().getString(ay.dmC());
        return this.lDb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.lIB = z;
        vo(true);
    }

    private void vo(boolean z) {
        View childAt;
        Rect rect = new Rect();
        FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
        if (frameLayout != null && (childAt = frameLayout.getChildAt(0)) != null) {
            frameLayout.getWindowVisibleDisplayFrame(rect);
            if (z) {
                ((FrameLayout.LayoutParams) childAt.getLayoutParams()).height = rect.height();
                childAt.requestLayout();
            }
        }
        if (this.lIp != null && this.lIp.getListView() != null && this.lIC != null && this.lIC.mPosition != -1) {
            final int headerViewsCount = this.lIC.mPosition + this.lIp.getListView().getHeaderViewsCount();
            if (this.lIC.getView() != null) {
                final int height = this.lIC.getView().getHeight();
                final int height2 = ((rect.height() - this.lIp.dpr()) - this.lIp.getNavigationBarHeight()) - this.lIp.dpq();
                final int i = height - height2;
                if (i > 0) {
                    this.lIp.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.lIp != null && NewSubPbActivity.this.lIp.getListView() != null) {
                                NewSubPbActivity.this.lIp.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.lIp.getNavigationBarHeight() - i);
                            }
                        }
                    });
                } else {
                    this.lIp.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.lIp != null && NewSubPbActivity.this.lIp.getListView() != null) {
                                NewSubPbActivity.this.lIp.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.lIp.getNavigationBarHeight() + (height2 - height));
                            }
                        }
                    });
                }
            }
        }
    }

    private void dkx() {
        if (this.lIn != null && !au.isEmpty(this.lIn.dkU())) {
            com.baidu.tbadk.BdToken.c.bfy().p(com.baidu.tbadk.BdToken.b.eow, com.baidu.adp.lib.f.b.toLong(this.lIn.dkU(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.lIn == null || au.isEmpty(this.lIn.dkU())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.lIn.dkU(), 0L);
    }
}
