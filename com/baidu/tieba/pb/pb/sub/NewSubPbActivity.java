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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.l;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.h;
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
import com.baidu.tbadk.widget.richText.i;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.ah;
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
/* loaded from: classes16.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, i, com.baidu.tieba.pb.pb.a<NewSubPbActivity> {
    private static String kRx = "tbgametype";
    private View.OnClickListener aRU;
    private bd dTS;
    private e enZ;
    private com.baidu.tbadk.core.message.a eoq;
    private com.baidu.adp.lib.d.b<ImageView> fcm;
    private com.baidu.adp.lib.d.b<GifView> fcn;
    private com.baidu.adp.lib.d.b<TextView> ffF;
    private com.baidu.adp.lib.d.b<View> ffG;
    private com.baidu.adp.lib.d.b<LinearLayout> ffH;
    private com.baidu.adp.lib.d.b<RelativeLayout> ffI;
    private VoiceManager hSO;
    private com.baidu.tieba.frs.profession.permission.c hXk;
    private com.baidu.tieba.write.c iTY;
    private EditText iTZ;
    private h jFD;
    public am jFx;
    private com.baidu.adp.base.e kDR;
    private com.baidu.tbadk.core.view.c kDS;
    private com.baidu.adp.widget.ImageView.a kDV;
    private String kDW;
    private TbRichTextMemeInfo kDX;
    private com.baidu.tieba.pb.pb.report.a kDw;
    private com.baidu.tbadk.baseEditMark.a kDx;
    private PostWriteCallBackData kFE;
    private String kMp;
    private com.baidu.tieba.pb.pb.sub.a kRA;
    private ah kRB;
    private AbsListView.OnScrollListener kRC;
    private TbRichTextView.i kRD;
    private SubPbModel.a kRE;
    private com.baidu.adp.base.d kRF;
    private BdUniqueId kRJ;
    private com.baidu.tieba.pb.e<p> kRL;
    private boolean kRM;
    private n kRN;
    private SubPbModel kRy;
    private ForumManageModel kRz;
    private com.baidu.tieba.pb.pb.main.b.a kzF;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int kEH = 0;
    PostData iUG = null;
    private a.InterfaceC0535a kED = null;
    private a kRG = null;
    private a kRH = null;
    private boolean mIsPaused = false;
    private boolean kRI = false;
    private boolean kRK = false;
    private boolean eKT = false;
    private com.baidu.tbadk.editortools.pb.c eMw = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void brV() {
            NewSubPbActivity.this.kRA.dcF();
        }
    };
    private int kzb = 0;
    private boolean mIsFromSchema = false;
    private BdUniqueId kRO = BdUniqueId.gen();
    private boolean kAY = com.baidu.tbadk.a.d.baf();
    private boolean kRP = true;
    private com.baidu.tbadk.editortools.pb.b eMx = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean brU() {
            if (!NewSubPbActivity.this.iTY.dFw()) {
                return (NewSubPbActivity.this.jFx == null || NewSubPbActivity.this.kRy == null || NewSubPbActivity.this.kRy.ckT() == null || NewSubPbActivity.this.jFx.aN(NewSubPbActivity.this.kRy.ckT().replyPrivateFlag, am.ekz)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.iTY.dFy());
            if (NewSubPbActivity.this.jFD.bsm()) {
                NewSubPbActivity.this.jFD.a(NewSubPbActivity.this.kFE);
            }
            NewSubPbActivity.this.pQ(true);
            return true;
        }
    };
    private CustomMessageListener kRQ = new CustomMessageListener(2921481) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && NewSubPbActivity.this.kRy != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && at.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), NewSubPbActivity.this.kRy.cYB())) {
                if (NewSubPbActivity.this.iTY != null) {
                    NewSubPbActivity.this.iTY.Sw(null);
                    NewSubPbActivity.this.iTY.bf(null);
                    NewSubPbActivity.this.iTY.wX(false);
                }
                if (NewSubPbActivity.this.jFD != null) {
                    NewSubPbActivity.this.jFD.bsw();
                    NewSubPbActivity.this.jFD.reset();
                }
                NewSubPbActivity.this.kRy.brR();
            }
        }
    };
    private NewWriteModel.d iUf = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.jFD != null && NewSubPbActivity.this.jFD.brv() != null) {
                NewSubPbActivity.this.jFD.brv().hide();
                if (NewSubPbActivity.this.kRy.ddf()) {
                    TiebaStatic.log(new aq("c10367").dD("post_id", NewSubPbActivity.this.kRy.brS()));
                }
            }
            if (z) {
                NewSubPbActivity.this.iTY.Sw(null);
                NewSubPbActivity.this.iTY.bf(null);
                NewSubPbActivity.this.iTY.wX(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.iTY.bf(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.iTY.Sw(postWriteCallBackData.getErrorString());
                if (!y.isEmpty(NewSubPbActivity.this.iTY.dFu())) {
                    NewSubPbActivity.this.kFE = postWriteCallBackData;
                    if (NewSubPbActivity.this.jFD.bsm()) {
                        NewSubPbActivity.this.jFD.a(NewSubPbActivity.this.kFE);
                    }
                    NewSubPbActivity.this.pQ(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(NewSubPbActivity.this.getActivity(), NewSubPbActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(NewSubPbActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(NewSubPbActivity.this.getActivity());
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.zz(NewSubPbActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.zz(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new aq("c13746").ai("obj_locate", 1).ai("obj_type", 2));
                    }
                });
                aVar.b(NewSubPbActivity.this.getPageContext()).bhg();
                TiebaStatic.log(new aq("c13745").ai("obj_locate", 1).ai("obj_type", 2));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.jFx != null) {
                NewSubPbActivity.this.jFx.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.kRA.dcG();
        }
    };
    private CustomMessageListener kEs = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.kRJ) {
                NewSubPbActivity.this.kRA.bWq();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.kDS.showSuccessToast(NewSubPbActivity.this.kDR.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.kDR.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.Cd(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.cYa();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (at.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.kDR.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.kDS.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener kEt = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.kRJ) {
                NewSubPbActivity.this.kRA.bWq();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.kDS.showSuccessToast(NewSubPbActivity.this.kDR.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (at.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.kDR.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.kDS.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener kEu = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.kRJ) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.kRA.bWq();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.mtn;
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
                    NewSubPbActivity.this.kRA.a(sparseArray, z);
                }
            }
        }
    };
    private final f.c fKL = new f.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (NewSubPbActivity.this.kRy != null) {
                NewSubPbActivity.this.kRy.ddd();
            }
        }
    };
    boolean kEI = false;
    private final b.InterfaceC0538b kEK = new b.InterfaceC0538b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.kDV != null && !TextUtils.isEmpty(NewSubPbActivity.this.kDW)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.kDX == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.kDW));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.kDW;
                        aVar.pkgId = NewSubPbActivity.this.kDX.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.kDX.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.dTS == null) {
                            NewSubPbActivity.this.dTS = new bd(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.dTS.j(NewSubPbActivity.this.kDW, NewSubPbActivity.this.kDV.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.kDV = null;
                NewSubPbActivity.this.kDW = null;
            }
        }
    };
    private CustomMessageListener jgJ = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener hUu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    l lVar = (l) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.kRy.dcX() != null && NewSubPbActivity.this.kRy.dcX().cWh() != null && NewSubPbActivity.this.kRy.dcX().cWh().beE() != null && currentAccount.equals(NewSubPbActivity.this.kRy.dcX().cWh().beE().getUserId()) && NewSubPbActivity.this.kRy.dcX().cWh().beE().getPendantData() != null) {
                        NewSubPbActivity.this.kRy.dcX().cWh().beE().getPendantData().zi(lVar.bcA());
                        NewSubPbActivity.this.kRy.dcX().cWh().beE().getPendantData().cY(lVar.bqZ());
                        NewSubPbActivity.this.kRA.a(NewSubPbActivity.this.kRy.dcX(), NewSubPbActivity.this.kRy.dcX().cWh(), NewSubPbActivity.this.kRy.dcX().cHC(), NewSubPbActivity.this.kRy.dcX().baA(), NewSubPbActivity.this.kRy.cVA(), NewSubPbActivity.this.kRy.ddl() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes16.dex */
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
        this.kDR = getPageContext();
        this.kRI = true;
        this.iTY = new com.baidu.tieba.write.c();
        this.iTY.Js(R.color.cp_cont_h_alpha85);
        this.iTY.Jr(R.color.cp_cont_a);
        bMg();
        dcv();
        initData(bundle);
        initUI();
        ((SubPbView) this.kRA.getRootView()).show();
        rm(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kRA.tV(this.mIsFromSchema);
        this.kDS = new com.baidu.tbadk.core.view.c();
        this.kDS.toastTime = 1000L;
        registerListener(this.kEu);
        registerListener(this.kEs);
        registerListener(this.kEt);
        registerListener(this.kRQ);
        this.kRJ = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.kRJ;
        userMuteAddAndDelCustomMessage.setTag(this.kRJ);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.kRJ;
        userMuteCheckCustomMessage.setTag(this.kRJ);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.jFx = new am(getPageContext());
        this.jFx.a(new am.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.jFD.bsu();
                }
            }
        });
        this.kDw = new com.baidu.tieba.pb.pb.report.a(this);
        this.kDw.x(getUniqueId());
        this.kzF = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.kRA = new com.baidu.tieba.pb.pb.sub.a(this, this.aRU);
        this.kRA.a(this.kRy);
        setContentView(this.kRA.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.kRA.setOnScrollListener(this.kRC);
        this.kRA.b(this);
        this.kRA.setOnImageClickListener(this.kRD);
        this.kRA.setOnLongClickListener(this.mOnLongClickListener);
        this.kRA.f(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.kRy != null) {
                    NewSubPbActivity.this.kRy.loadData();
                }
            }
        });
        this.kRA.a(this.kRG);
        this.kRA.b(this.kRH);
        this.kRA.setListPullRefreshListener(this.fKL);
        if (this.kRy != null && this.kRy.dcx() && !this.kRy.ddk()) {
            this.kRA.dcL().setVisibility(8);
        } else {
            this.kRA.dcL().setVisibility(0);
        }
        if (this.kRy != null && !this.kRy.dcx()) {
            this.kRA.setIsFromPb(false);
        }
    }

    private boolean aD(Bundle bundle) {
        if (bundle != null) {
            this.eKT = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eKT = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eKT;
    }

    public void initData(Bundle bundle) {
        this.kRy = new SubPbModel(getPageContext());
        this.kRy.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                NewSubPbActivity.this.kRA.u(postData);
                NewSubPbActivity.this.kRA.b((BdListView.e) null);
            }
        });
        this.kRz = new ForumManageModel(getPageContext());
        this.kRz.setLoadDataCallBack(this.kRF);
        this.hSO = new VoiceManager();
        this.hSO.onCreate(getPageContext());
        this.kDx = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.kDx != null) {
            this.kDx.a(this.kED);
        }
        if (bundle != null) {
            this.kRy.initWithBundle(bundle);
        } else {
            this.kRy.initWithIntent(getIntent());
        }
        this.kRy.a(this.kRE);
        if (this.kRy.dcx() && !this.kRy.ddq()) {
            this.kRy.loadData();
        } else {
            this.kRy.ddc();
        }
    }

    public void dcv() {
        this.kRE = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, final p pVar) {
                if (NewSubPbActivity.this.kRA != null) {
                    NewSubPbActivity.this.kRA.dcG();
                    if (!z) {
                        NewSubPbActivity.this.bu(i, str);
                        return;
                    }
                    NewSubPbActivity.this.kRA.hideNoDataView();
                    if (pVar != null) {
                        if (pVar.cWh() != null || NewSubPbActivity.this.kRy != null) {
                            pVar.cWh().a(NewSubPbActivity.this.kRy.ddj());
                        }
                        if (NewSubPbActivity.this.kRA != null) {
                            NewSubPbActivity.this.rm(pVar.bce() != null && pVar.bce().isBjh());
                            if (NewSubPbActivity.this.jFD != null && NewSubPbActivity.this.jFD.brv() != null) {
                                NewSubPbActivity.this.jFD.brv().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.kRA.a(pVar, NewSubPbActivity.this.kRy.cVA(), NewSubPbActivity.this.kRy.ddl() != null, NewSubPbActivity.this.kRI);
                            if (NewSubPbActivity.this.kRI) {
                                NewSubPbActivity.this.kRA.getListView().setSelectionFromTop(NewSubPbActivity.this.kRA.getListView().getHeaderViewsCount() + 1, -com.baidu.adp.lib.util.l.getDimens(NewSubPbActivity.this, R.dimen.tbds18));
                                NewSubPbActivity.this.dcw();
                                NewSubPbActivity.this.kRI = false;
                            }
                        }
                        if (NewSubPbActivity.this.jFD != null) {
                            NewSubPbActivity.this.jFD.a(pVar.ckT());
                            NewSubPbActivity.this.jFD.setThreadData(pVar.bce());
                            if (NewSubPbActivity.this.getIntent() != null && NewSubPbActivity.this.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && NewSubPbActivity.this.kRP) {
                                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NewSubPbActivity.this.kRP = false;
                                        NewSubPbActivity.this.c(pVar.cWh(), false);
                                    }
                                }, 200L);
                            }
                        }
                        if (NewSubPbActivity.this.kRL == null) {
                            NewSubPbActivity.this.kRL = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.kRL.setData(pVar);
                        NewSubPbActivity.this.kRL.setType(0);
                        NewSubPbActivity.this.jFx.a(NewSubPbActivity.this.kRy.ddo());
                    }
                }
            }
        };
        this.kED = new a.InterfaceC0535a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0535a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.kDx != null) {
                        NewSubPbActivity.this.kDx.hA(z2);
                    }
                    MarkData baD = NewSubPbActivity.this.kDx.baD();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(baD);
                        if (NewSubPbActivity.this.kDx != null) {
                            if (baD != null) {
                                NewSubPbActivity.this.kRy.tX(true);
                                NewSubPbActivity.this.kRy.Oa(NewSubPbActivity.this.kRy.brS());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.kRA != null) {
                                NewSubPbActivity.this.kRA.tW(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.kRy.tX(false);
                        NewSubPbActivity.this.kRy.Oa(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.kRA != null) {
                            NewSubPbActivity.this.kRA.tW(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.kRG = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.kRy.dcX() != null && NewSubPbActivity.this.kRy.dcX().bce() != null && NewSubPbActivity.this.kRy.dcX().bce().beE() != null) {
                    str = String.valueOf(NewSubPbActivity.this.kRy.dcX().bce().beE().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.kRy.dcX().bss().getId(), NewSubPbActivity.this.kRy.dcX().bss().getName(), NewSubPbActivity.this.kRy.dcX().bce().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.kRH = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.kRz.dxq() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.kRy != null && NewSubPbActivity.this.kRy.dcX() != null && NewSubPbActivity.this.kRy.dcX().bss() != null && NewSubPbActivity.this.kRy.dcX().bce() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.kRz.QP(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.kRz.a(NewSubPbActivity.this.kRy.dcX().bss().getId(), NewSubPbActivity.this.kRy.dcX().bss().getName(), NewSubPbActivity.this.kRy.dcX().bce().getId(), valueOf, i2, i, z, NewSubPbActivity.this.kRy.dcX().bce().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.kRF = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.kRA.a(NewSubPbActivity.this.kRz.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.kRz.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.kSN != 1002 || bVar.ghr) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.kRA.a(1, dVar.Qf, dVar.mhz, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean cO(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void bMg() {
        registerListener(this.hUu);
        this.aRU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
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
                if (view != null || NewSubPbActivity.this.kRA != null) {
                    if (view == NewSubPbActivity.this.kRA.dcR()) {
                        NewSubPbActivity.this.kRA.dbe();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                be.bju().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.kRA.cqT()) {
                        if (view != NewSubPbActivity.this.kRA.dcK()) {
                            if (view == NewSubPbActivity.this.kRA.dcJ()) {
                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                    NewSubPbActivity.this.kRA.dcz();
                                    NewSubPbActivity.this.kRA.dcA();
                                    if (NewSubPbActivity.this.jFD != null) {
                                        NewSubPbActivity.this.jFD.bsA();
                                    }
                                }
                            } else if (view.getId() != R.id.pb_floor_feedback) {
                                if (view == NewSubPbActivity.this.kRA.dcE()) {
                                    NewSubPbActivity.this.kRA.dbe();
                                    if (NewSubPbActivity.this.kRy.loadData()) {
                                        NewSubPbActivity.this.kRA.dcC();
                                    }
                                } else if (view == NewSubPbActivity.this.kRA.dcL() || view == NewSubPbActivity.this.kRA.dcM() || view == NewSubPbActivity.this.kRA.dcO()) {
                                    if (NewSubPbActivity.this.kRK) {
                                        NewSubPbActivity.this.kRK = false;
                                        return;
                                    }
                                    if (NewSubPbActivity.this.kRy.dcX() != null && NewSubPbActivity.this.kRy.dcX().bce() != null) {
                                        z2 = ay.a(NewSubPbActivity.this.kRy.dcX().bce().getBaijiahaoData());
                                    }
                                    if (z2) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.kRy.cYB(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.kRy.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.kRy.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.kRy.dcX() != null && NewSubPbActivity.this.kRy.dcX().bce() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.kRy.dcX().bce().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.kRy.cYB(), NewSubPbActivity.this.kRy.brS(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.kRy.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.kRy.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.kRA.dcP() == null || view != NewSubPbActivity.this.kRA.dcP().cZA()) {
                                    if (NewSubPbActivity.this.kRA.dcP() == null || view != NewSubPbActivity.this.kRA.dcP().cZD()) {
                                        if (NewSubPbActivity.this.kRA.dcP() == null || view != NewSubPbActivity.this.kRA.dcP().cZB()) {
                                            if (NewSubPbActivity.this.kRA.dcP() == null || view != NewSubPbActivity.this.kRA.dcP().cZC()) {
                                                if (NewSubPbActivity.this.kRA.dcP() == null || view != NewSubPbActivity.this.kRA.dcP().cZE()) {
                                                    if (view == NewSubPbActivity.this.kRA.dcI() || view == NewSubPbActivity.this.kRA.dcO()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.jFD.bsx()) {
                                                                NewSubPbActivity.this.jFD.bsy();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.jFD.Ce(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view != null && (view.getTag() instanceof n)) {
                                                        NewSubPbActivity.this.kRN = (n) view.getTag();
                                                        if (bg.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.kRK) {
                                                                NewSubPbActivity.this.kRK = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.jFx == null || NewSubPbActivity.this.kRy == null || NewSubPbActivity.this.kRy.ckT() == null || NewSubPbActivity.this.jFx.nP(NewSubPbActivity.this.kRy.ckT().replyPrivateFlag)) && (sparseArray2 = (SparseArray) view.getTag(R.id.tag_from)) != null) {
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
                                                        if (NewSubPbActivity.this.kRB == null || view != NewSubPbActivity.this.kRB.cZC()) {
                                                            if (NewSubPbActivity.this.kRB == null || view != NewSubPbActivity.this.kRB.cZA()) {
                                                                if (NewSubPbActivity.this.kRB == null || view != NewSubPbActivity.this.kRB.cZD()) {
                                                                    if (NewSubPbActivity.this.kRB == null || view != NewSubPbActivity.this.kRB.cZE()) {
                                                                        if (NewSubPbActivity.this.kRB == null || view != NewSubPbActivity.this.kRB.cZG()) {
                                                                            if (NewSubPbActivity.this.kRB == null || view != NewSubPbActivity.this.kRB.cZH()) {
                                                                                if (NewSubPbActivity.this.kRB == null || view != NewSubPbActivity.this.kRB.cZI()) {
                                                                                    if (NewSubPbActivity.this.kRB != null && view == NewSubPbActivity.this.kRB.cZB()) {
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
                                                                                                NewSubPbActivity.this.kRA.cT(view);
                                                                                                return;
                                                                                            } else if (booleanValue2) {
                                                                                                NewSubPbActivity.this.kRA.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                                return;
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    int id = view.getId();
                                                                                    if (id == R.id.pb_item_tail_content) {
                                                                                        if (bg.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                            String string2 = com.baidu.tbadk.core.sharedPref.b.bik().getString("tail_link", "");
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
                                                                                            if (postData2.getType() != PostData.ebj && !TextUtils.isEmpty(postData2.getBimg_url()) && k.bbM().isShowImages()) {
                                                                                                NewSubPbActivity.this.NX(postData2.getId());
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
                                                                                    if (postData3.bgv() != null) {
                                                                                        NewSubPbActivity.this.d(postData3.bgv());
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.kDV != null && !TextUtils.isEmpty(NewSubPbActivity.this.kDW)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.dTS == null) {
                                                                                        NewSubPbActivity.this.dTS = new bd(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.dTS.j(NewSubPbActivity.this.kDW, NewSubPbActivity.this.kDV.getImageByte());
                                                                                    NewSubPbActivity.this.kDV = null;
                                                                                    NewSubPbActivity.this.kDW = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.kDV != null && !TextUtils.isEmpty(NewSubPbActivity.this.kDW)) {
                                                                            if (NewSubPbActivity.this.kDX == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.kDW));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.kDW;
                                                                                aVar.pkgId = NewSubPbActivity.this.kDX.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.kDX.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.kDV = null;
                                                                            NewSubPbActivity.this.kDW = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.iUG != null) {
                                                                        NewSubPbActivity.this.iUG.fF(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.iUG = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                if (sparseArray5 != null && (sparseArray5.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_id) instanceof String) && (sparseArray5.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.kRA.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.cN(view);
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
                                                                NewSubPbActivity.this.Nu((String) tag);
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
                                                            if (NewSubPbActivity.this.kRy != null) {
                                                                TiebaStatic.log(new aq("c13700").dD("tid", NewSubPbActivity.this.kRy.cYC()).dD("fid", NewSubPbActivity.this.kRy.getFromForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", postData.getId()).ai("obj_type", 3));
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
                                                        ((PostData) sparseArray8.get(R.id.tag_clip_board)).fF(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new aq("c11739").ai("obj_locate", 4));
                                            if (!j.isNetWorkAvailable()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.kRA.dbe();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.Nu(str4);
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
                                            NewSubPbActivity.this.kRA.dbe();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.cX(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.kRA.dbe();
                                    SparseArray sparseArray10 = (SparseArray) view.getTag();
                                    if (sparseArray10 != null) {
                                        NewSubPbActivity.this.kRA.a(((Integer) sparseArray10.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray10.get(R.id.tag_del_post_id), ((Integer) sparseArray10.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new aq("c11739").ai("obj_locate", 2));
                                    NewSubPbActivity.this.kRA.dbe();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.kRy.dcX() != null) {
                                        NewSubPbActivity.this.n(NewSubPbActivity.this.kRy.dcX().cWh());
                                    }
                                }
                            } else {
                                try {
                                    sparseArray3 = (SparseArray) view.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                }
                                if (sparseArray3 != null && ((PostData) sparseArray3.get(R.id.tag_clip_board)) != null) {
                                    if (NewSubPbActivity.this.kRB == null) {
                                        NewSubPbActivity.this.kRB = new ah(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aRU);
                                        NewSubPbActivity.this.kRA.cY(NewSubPbActivity.this.kRB.getView());
                                        NewSubPbActivity.this.kRB.ti(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.kRB.Nv();
                                    if (NewSubPbActivity.this.sT(sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin()) {
                                        z2 = true;
                                    }
                                    NewSubPbActivity.this.kRB.a(sparseArray3, NewSubPbActivity.this.cVA(), z2);
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.kRA.dcz();
                            NewSubPbActivity.this.kRA.dcA();
                            if (NewSubPbActivity.this.jFD != null) {
                                NewSubPbActivity.this.jFD.bsz();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.cXz();
                        if (NewSubPbActivity.this.kRy != null && NewSubPbActivity.this.kRy.dcX() != null && NewSubPbActivity.this.kRy.dcX().bce() != null && NewSubPbActivity.this.kRy.dcX().bce().beE() != null) {
                            TiebaStatic.log(new aq("c13402").dD("tid", NewSubPbActivity.this.kRy.cYB()).u("fid", NewSubPbActivity.this.kRy.dcX().bce().getFid()).ai("obj_locate", 5).dD("uid", NewSubPbActivity.this.kRy.dcX().bce().beE().getUserId()));
                        }
                    }
                }
            }
        };
        this.kRC = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.kRA.dbe();
                    if (NewSubPbActivity.this.kzb != 2 && NewSubPbActivity.this.kzb != 1) {
                        NewSubPbActivity.this.kRA.dcU();
                    }
                }
                NewSubPbActivity.this.jFD.bsy();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.kRA.dcQ();
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
                if (NewSubPbActivity.this.kRA != null && NewSubPbActivity.this.kRA.dcH()) {
                    return false;
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null && NewSubPbActivity.this.cO(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.kDV = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.kDW = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.kDV == null || TextUtils.isEmpty(NewSubPbActivity.this.kDW)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.kDX = null;
                        } else {
                            NewSubPbActivity.this.kDX = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.kDV = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.kDW = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.kDX = null;
                        } else {
                            NewSubPbActivity.this.kDX = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.kDV = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.kDW = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.kDX = null;
                        } else {
                            NewSubPbActivity.this.kDX = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.kRA.a(NewSubPbActivity.this.kEK, NewSubPbActivity.this.kDV.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.iUG = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.iUG == null || NewSubPbActivity.this.kDx == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.kDx != null) {
                            NewSubPbActivity.this.kDx.hA(NewSubPbActivity.this.kRy.dde());
                        }
                        boolean z2 = NewSubPbActivity.this.kDx.baA() && NewSubPbActivity.this.iUG.getId() != null && NewSubPbActivity.this.iUG.getId().equals(NewSubPbActivity.this.kRy.ddg());
                        if (NewSubPbActivity.this.kRB == null) {
                            NewSubPbActivity.this.kRB = new ah(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aRU);
                            NewSubPbActivity.this.kRA.cY(NewSubPbActivity.this.kRB.getView());
                            NewSubPbActivity.this.kRB.ti(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.kRB.Nv();
                        boolean z3 = NewSubPbActivity.this.sT(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z4 = (NewSubPbActivity.this.kRy.dcX() == null || NewSubPbActivity.this.kRy.dcX().bce() == null || !NewSubPbActivity.this.kRy.dcX().bce().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z2) {
                            NewSubPbActivity.this.kRB.cZA().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.kRB.cZA().setText(R.string.mark);
                        }
                        if (booleanValue || z4) {
                            NewSubPbActivity.this.kRB.cZA().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.kRB.cZA().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.cO(view)) {
                            if (NewSubPbActivity.this.kDV != null && !NewSubPbActivity.this.kDV.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        ah ahVar = NewSubPbActivity.this.kRB;
                        int cVA = NewSubPbActivity.this.cVA();
                        if (NewSubPbActivity.this.kAY && NewSubPbActivity.this.iUG.mfK) {
                            z = true;
                        }
                        ahVar.a(sparseArray2, cVA, z3, z);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.kRD = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
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
                        p dcX = NewSubPbActivity.this.kRy.dcX();
                        TbRichText bv = NewSubPbActivity.this.bv(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bv != null && bv.bxw() != null) {
                            tbRichTextData = bv.bxw().get(NewSubPbActivity.this.kEH);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!tbRichTextData.bxC().bxQ()) {
                                String c = NewSubPbActivity.this.c(tbRichTextData);
                                arrayList.add(c);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap.put(c, imageUrlData);
                                String str5 = null;
                                String str6 = null;
                                String str7 = null;
                                if (dcX == null) {
                                    str4 = null;
                                    z4 = false;
                                } else {
                                    if (dcX.bss() != null) {
                                        str5 = dcX.bss().getName();
                                        str6 = dcX.bss().getId();
                                    }
                                    if (dcX.bce() != null) {
                                        str7 = dcX.bce().getId();
                                    }
                                    str4 = str7;
                                    z4 = true;
                                }
                                if (NewSubPbActivity.this.kRy.ddl() != null) {
                                    concurrentHashMap = NewSubPbActivity.this.kRy.ddl();
                                    z4 = NewSubPbActivity.this.kRy.ddn();
                                    arrayList = NewSubPbActivity.this.kRy.ddm();
                                }
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(y.getItem(arrayList, 0));
                                ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                                aVar.x(arrayList2).yP(str5).yQ(str6).yR(str4).hH(z4).yS(arrayList.get(0)).hI(true).a(concurrentHashMap).hJ(true).hK(false).hL(false).r(NewSubPbActivity.this.bce()).yT(String.valueOf(bv.getPostId())).yU(NewSubPbActivity.this.kRy.getFromForumId());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar.dP(NewSubPbActivity.this.getPageContext().getPageActivity())));
                                return;
                            }
                            NewSubPbActivity.this.kEI = false;
                            TbRichText dwH = dcX.cWh().dwH();
                            int size = arrayList.size();
                            int a2 = NewSubPbActivity.this.a(dwH, bv, i, i, arrayList, concurrentHashMap);
                            int size2 = arrayList.size();
                            if (size == size2) {
                                str2 = "";
                            } else {
                                str2 = arrayList.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (dcX == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (dcX.bss() != null) {
                                    str8 = dcX.bss().getName();
                                    str9 = dcX.bss().getId();
                                }
                                if (dcX.bce() != null) {
                                    str10 = dcX.bce().getId();
                                }
                                str3 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.kRy.ddl() != null) {
                                concurrentHashMap = NewSubPbActivity.this.kRy.ddl();
                                z3 = NewSubPbActivity.this.kRy.ddn();
                                arrayList = NewSubPbActivity.this.kRy.ddm();
                                a2 += NewSubPbActivity.this.kRy.getOffset();
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(y.getItem(arrayList, a2));
                            ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                            aVar2.x(arrayList3).yP(str8).yQ(str9).yR(str3).hH(z3).yS(str2).hI(true).a(concurrentHashMap).hJ(true).hK(false).hL(false).r(NewSubPbActivity.this.bce()).yT(String.valueOf(bv.getPostId())).yU(NewSubPbActivity.this.kRy.getFromForumId());
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar2.dP(NewSubPbActivity.this.getPageContext().getPageActivity())));
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
    public bw bce() {
        if (this.kRy == null || this.kRy.dcX() == null) {
            return null;
        }
        return this.kRy.dcX().bce();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(View view) {
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
            if (postData.beE() != null) {
                MetaData beE = postData.beE();
                this.jFD.setReplyId(beE.getUserId());
                boolean z2 = postData.mfK;
                String str = "";
                if (postData.dwH() != null) {
                    str = postData.dwH().toString();
                }
                this.jFD.Cg(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.beE().getName_show(), str));
                if (z2) {
                    if (!z) {
                        this.jFD.Cf("");
                    }
                } else if (!z) {
                    this.jFD.Cf(beE.getName_show());
                }
            }
            this.kRA.dcA();
        }
        if (this.kRM) {
            tU(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eoq == null) {
                this.eoq = new com.baidu.tbadk.core.message.a();
            }
            if (this.enZ == null) {
                this.enZ = new e();
                this.enZ.uniqueId = this.kRO;
            }
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dWK = 12;
            cVar.dWQ = 9;
            cVar.dWP = 3;
            if (dcy() != null) {
                cVar.dWO = dcy().ddp();
            }
            if (cVar != null) {
                cVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.dWR = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.dWR = 1;
                        i = 0;
                    }
                }
                this.eoq.a(agreeData, i, getUniqueId(), false);
                this.eoq.a(agreeData, this.enZ);
                if (dcy() == null && dcy().dcX() != null) {
                    this.eoq.a(this, cVar, agreeData, dcy().dcX().bce());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.dWR = 1;
            }
            i = 0;
            this.eoq.a(agreeData, i, getUniqueId(), false);
            this.eoq.a(agreeData, this.enZ);
            if (dcy() == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bxC;
        if (tbRichText == tbRichText2) {
            this.kEI = true;
        }
        if (tbRichText != null && tbRichText.bxw() != null) {
            int size = tbRichText.bxw().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.bxw().get(i6) != null && tbRichText.bxw().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.bxw().get(i6).bxC().getWidth() * equipmentDensity;
                    int height = tbRichText.bxw().get(i6).bxC().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.bxw().get(i6).bxC().bxQ()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.bxw().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (bxC = tbRichTextData.bxC()) != null) {
                            String bxS = bxC.bxS();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = bxS;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.kEI) {
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
        if (this.kRB != null) {
            this.kRB.ti(z);
        }
        if (this.kRA != null) {
            this.kRA.ti(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bxC = tbRichTextData.bxC();
        if (bxC != null) {
            if (!StringUtils.isNull(bxC.bxP())) {
                return bxC.bxP();
            }
            if (bxC.getHeight() * bxC.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bxC.getHeight() * bxC.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bxC.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bxC.getHeight())));
            } else {
                float width = bxC.getWidth() / bxC.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(at.getUrlEncode(bxC.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bv(String str, int i) {
        if (this.kRy == null || this.kRy.dcX() == null || str == null || i < 0) {
            return null;
        }
        p dcX = this.kRy.dcX();
        TbRichText a2 = a(dcX.cWh(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(dcX.cWh(), str, i);
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
        TbRichText dwH = postData.dwH();
        if (dwH != null) {
            ArrayList<TbRichTextData> bxw = dwH.bxw();
            int size = bxw.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (bxw.get(i3) != null && bxw.get(i3).getType() == 8) {
                    i2++;
                    if (bxw.get(i3).bxC().bxS().equals(str)) {
                        int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = bxw.get(i3).bxC().getWidth() * equipmentDensity;
                        int height = bxw.get(i3).bxC().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.kEH = i3;
                        return dwH;
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
    public void cXz() {
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false) {
            if (this.jFx == null || this.kRy == null || this.kRy.ckT() == null || this.jFx.nP(this.kRy.ckT().replyPrivateFlag)) {
                if (this.jFD.bsm()) {
                    this.jFD.a((PostWriteCallBackData) null);
                    return;
                }
                this.kRA.dcz();
                this.kRA.dcA();
                if (this.jFD != null) {
                    this.jFD.bsB();
                    return;
                }
                return;
            }
            return;
        }
        if (this.hXk == null) {
            this.hXk = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.hXk.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void ou(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void z(boolean z, int i) {
                }

                /* JADX WARN: Removed duplicated region for block: B:26:0x00bf  */
                /* JADX WARN: Removed duplicated region for block: B:27:0x00ca  */
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void ov(boolean z) {
                    String str;
                    if (z) {
                        if (NewSubPbActivity.this.jFx == null || NewSubPbActivity.this.kRy == null || NewSubPbActivity.this.kRy.ckT() == null || NewSubPbActivity.this.jFx.nP(NewSubPbActivity.this.kRy.ckT().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.kRy != null && NewSubPbActivity.this.kRy.dcX() != null && NewSubPbActivity.this.kRy.dcX().cWh() != null) {
                                PostData cWh = NewSubPbActivity.this.kRy.dcX().cWh();
                                if (cWh.dwH() != null && cWh.beE() != null) {
                                    str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), cWh.beE().getName_show(), cWh.dwH().toString());
                                    NewSubPbActivity.this.jFD.brv().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                                    if (!NewSubPbActivity.this.jFD.bsm()) {
                                        NewSubPbActivity.this.jFD.a((PostWriteCallBackData) null);
                                        return;
                                    }
                                    NewSubPbActivity.this.kRA.dcz();
                                    NewSubPbActivity.this.kRA.dcA();
                                    if (NewSubPbActivity.this.jFD != null) {
                                        NewSubPbActivity.this.jFD.bsB();
                                        return;
                                    }
                                    return;
                                }
                            }
                            str = null;
                            NewSubPbActivity.this.jFD.brv().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                            if (!NewSubPbActivity.this.jFD.bsm()) {
                            }
                        }
                    }
                }
            });
        }
        if (this.kRy != null && this.kRy.dcX() != null && this.kRy.dcX().bss() != null) {
            this.hXk.C(this.kRy.dcX().bss().getId(), com.baidu.adp.lib.f.b.toLong(this.kRy.cYB(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sT(boolean z) {
        if (this.kRy == null) {
            return false;
        }
        return ((cVA() != 0) || this.kRy.dcX() == null || this.kRy.dcX().bce() == null || this.kRy.dcX().bce().beE() == null || this.kRy.dcX().bce().bdo() || TextUtils.equals(this.kRy.dcX().bce().beE().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(int i, String str) {
        if (this.kRy.dcY()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.isNetOk()) {
            if (i == 4) {
                this.kRA.GS(str + "(4)");
            } else {
                this.kRA.Bd(R.string.no_data_text);
            }
        } else {
            this.kRA.Bd(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rm(boolean z) {
        this.jFD = (h) new com.baidu.tbadk.editortools.pb.i(z).ec(getActivity());
        if (this.jFD != null) {
            this.jFD.a(getPageContext());
            this.jFD.b(this.kRy);
            this.jFD.b(this.iUf);
            this.jFD.a(this.eMw);
            this.jFD.a(this.eMx);
            this.jFD.brv().jh(true);
            this.jFD.j(getPageContext());
        }
        if (this.kRA != null) {
            this.kRA.i(this.jFD);
        }
        if (this.jFD != null && this.kRy != null) {
            this.jFD.a(this.kRy.ckT());
            this.jFD.bsy();
        }
        if (this.jFD != null) {
            this.jFD.bsC().setDefaultHint(das());
            this.jFD.bsC().setHint(das());
            this.iTZ = this.jFD.bsC().getInputView();
            this.iTZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.iTY != null) {
                        if (!NewSubPbActivity.this.iTY.dFx()) {
                            NewSubPbActivity.this.pQ(false);
                        }
                        NewSubPbActivity.this.iTY.wY(false);
                    }
                }
            });
        }
    }

    public void dcw() {
        if (!TbadkCoreApplication.isLogin()) {
            this.jFD.bsy();
        } else if (!StringUtils.isNull(this.kRy.ddh())) {
            if (this.kRA.dcD() && com.baidu.adp.lib.util.l.isNetOk()) {
                this.kRA.ciR();
            } else {
                this.kRA.dcG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cX(View view) {
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
                    this.kRA.cT(view);
                }
            } else if (booleanValue2) {
                this.kRA.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.kRA.dcN(), getPageContext().getPageActivity());
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
            bVar.nx(R.string.operation);
            bVar.a(strArr, new b.InterfaceC0538b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.kRJ);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.kRJ);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).bhi();
        }
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.kRA.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.kRJ;
        userMuteCheckCustomMessage.setTag(this.kRJ);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.kRA.a(0, bVar.Qf, bVar.mhz, z);
            if (bVar.Qf) {
                if (bVar.hzG == 1) {
                    if (this.kRA.getListView() instanceof BdTypeListView) {
                        List<q> data = ((BdTypeListView) this.kRA.getListView()).getData();
                        if (!y.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.kRA.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.hzG == 2) {
                    this.kRy.NZ(bVar.mPostId);
                    this.kRA.a(this.kRy.dcX(), this.kRy.cVA(), this.kRy.ddl() != null, false);
                    if (this.kRy.ddi()) {
                        this.kRy.tY(false);
                        this.kRA.dcB();
                        this.kRy.loadData();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void Nu(String str) {
        if (this.kRy != null && this.kRy.dcX() != null && this.kRy.dcX().bce() != null && this.kRy.dcX().bce().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.kRy.cYB(), str);
            bw bce = this.kRy.dcX().bce();
            if (bce.bdm()) {
                format = format + "&channelid=33833";
            } else if (bce.bgy()) {
                format = format + "&channelid=33842";
            } else if (bce.bdn()) {
                format = format + "&channelid=33840";
            }
            Nv(format);
            return;
        }
        this.kDw.NV(str);
    }

    private void Nv(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void n(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.kRy.dde() && postData.getId() != null && postData.getId().equals(this.kRy.ddg())) {
                z = true;
            }
            MarkData o = this.kRy.o(postData);
            if (o != null) {
                this.kRA.dbe();
                if (this.kDx != null) {
                    this.kDx.a(o);
                    if (!z) {
                        this.kDx.baC();
                    } else {
                        this.kDx.baB();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.kRy != null) {
            this.kRy.aC(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.jFD != null) {
            this.jFD.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.jFD.brv().bpX();
        this.jFD.bsy();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.jFD.b(writeData);
                this.jFD.setVoiceModel(pbEditorData.getVoiceModel());
                m qe = this.jFD.brv().qe(6);
                if (qe != null && qe.eKx != null) {
                    qe.eKx.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.jFD.bsu();
                }
                this.kRA.dcU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hSO != null) {
            this.hSO.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.aYs().aYC();
        if (this.hSO != null) {
            this.hSO.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.jgJ);
        this.kRA.ctd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
        cYe();
        if (this.hSO != null) {
            this.hSO.onResume(getPageContext());
        }
        registerListener(this.jgJ);
        this.kRA.cte();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hSO != null) {
            this.hSO.onStop(getPageContext());
        }
        this.jFD.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.kRL));
        this.kRy.cancelLoadData();
        this.kRy.destory();
        this.kRz.cancelLoadData();
        if (this.hSO != null) {
            this.hSO.onDestory(getPageContext());
        }
        this.kRA.dbe();
        this.kRA.crq();
        MessageManager.getInstance().unRegisterListener(this.kEs);
        MessageManager.getInstance().unRegisterListener(this.kEt);
        MessageManager.getInstance().unRegisterListener(this.kEu);
        MessageManager.getInstance().unRegisterListener(this.kRJ);
        this.kDR = null;
        this.kDS = null;
        if (this.jFx != null) {
            this.jFx.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kRA.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hSO;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View dcI = this.kRA.dcI();
        if (dcI == null || (findViewWithTag = dcI.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean NN(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = be.getParamPair(be.getParamStr(str))) != null) {
            this.kRK = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return NN(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(kRx);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (NN(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                    kVar.mLink = str;
                    kVar.type = 3;
                    kVar.eJB = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
                }
            } else {
                be.bju().b(getPageContext(), new String[]{str});
            }
            this.kRK = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aq(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.kRK = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ar(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void as(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void at(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void r(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView getListView() {
        if (this.kRA != null) {
            return this.kRA.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int byh() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> byj() {
        if (this.ffF == null) {
            this.ffF = TbRichTextView.y(getPageContext().getPageActivity(), 8);
        }
        return this.ffF;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> byk() {
        if (this.fcn == null) {
            this.fcn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cgy */
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
        return this.fcn;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> byi() {
        if (this.fcm == null) {
            this.fcm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: byu */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = k.bbM().isShowImages();
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
                        foreDrawableImageView.setDefaultBgResource(R.color.cp_bg_line_c);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: b */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (k.bbM().isShowImages()) {
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
                        foreDrawableImageView.setDefaultBgResource(R.color.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.fcm;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> byl() {
        if (this.ffG == null) {
            this.ffG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cYl */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(NewSubPbActivity.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cP */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cQ */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cR */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.ffG;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bym() {
        if (this.ffH == null) {
            this.ffH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cYn */
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
        return this.ffH;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> byn() {
        this.ffI = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cYm */
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
        return this.ffI;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cWs() {
        return this.kzF;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cWt() {
        return (this.kRy == null || this.kRy.dcX() == null || this.kRy.dcX().bce() == null || this.kRy.dcX().bce().bgb()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cWu() {
        if (this.kRy == null || this.kRy.dcX() == null || this.kRy.dcX().bce() == null) {
            return null;
        }
        return this.kRy.dcX().bce().beI();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cWv() {
        if (this.kRy == null) {
            return 0;
        }
        return this.kRy.cVA();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean No(String str) {
        if (StringUtils.isNull(str) || this.kRy == null || this.kRy.dcX() == null || this.kRy.dcX().bce() == null || this.kRy.dcX().bce().beE() == null) {
            return false;
        }
        return str.equals(this.kRy.dcX().bce().beE().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.kRA.dcD() && com.baidu.adp.lib.util.l.isNetOk()) {
            this.kRy.loadData();
        } else {
            this.kRA.dcG();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.kRJ);
        userMuteAddAndDelCustomMessage.setTag(this.kRJ);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NX(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bik().getString("bubble_link", "");
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

    @Override // com.baidu.tbadk.widget.richText.i
    public void au(Context context, String str) {
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
                return com.baidu.tbadk.m.e.btZ().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.kRy != null) {
            if (this.kRy.dcX() != null && this.kRy.dcX().bss() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.kRy.dcX().bss().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.kRy.cYB(), 0L));
            if (this.kRy.dcX() != null && this.kRy.dcX().bce() != null) {
                pageStayDurationItem.setNid(this.kRy.dcX().bce().getNid());
            }
            pageStayDurationItem.setPid(com.baidu.adp.lib.f.b.toLong(this.kRy.brS(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public boolean dcx() {
        if (this.kRy != null) {
            return this.kRy.dcx();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.kRA.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kDR.getPageActivity());
        if (at.isEmpty(str)) {
            aVar.zz(this.kDR.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.zz(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.kRA.showLoadingDialog();
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
        aVar.b(this.kDR).bhg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cd(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kDR.getPageActivity());
        aVar.zz(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.kDR).bhg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYa() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.zz(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.kDR).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.kDR.getPageActivity(), 2, true, 4);
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
        aVar.b(this.kDR).bhg();
    }

    public SubPbModel dcy() {
        return this.kRy;
    }

    public int cVA() {
        if (this.kRy != null) {
            return this.kRy.cVA();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eKT && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eKT && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void pQ(boolean z) {
        if (this.iTZ != null && this.iTZ.getText() != null) {
            int selectionEnd = this.iTZ.getSelectionEnd();
            SpannableStringBuilder c = this.iTY.c(this.iTZ.getText());
            if (c != null) {
                this.iTY.wY(true);
                this.iTZ.setText(c);
                if (z && this.iTY.dFv() >= 0) {
                    this.iTZ.requestFocus();
                    this.iTZ.setSelection(this.iTY.dFv());
                } else {
                    this.iTZ.setSelection(selectionEnd);
                }
                this.iTY.wX(this.iTY.dFv() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jFD != null && this.jFD.brv() != null && this.jFD.brv().brx()) {
            this.jFD.brv().bpX();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        com.baidu.tbadk.core.util.ag.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    public String das() {
        if (!at.isEmpty(this.kMp)) {
            return this.kMp;
        }
        this.kMp = getResources().getString(com.baidu.tieba.pb.pb.main.ay.dah());
        return this.kMp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.kRM = z;
        tU(true);
    }

    private void tU(boolean z) {
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
        if (this.kRA != null && this.kRA.getListView() != null && this.kRN != null && this.kRN.mPosition != -1) {
            final int headerViewsCount = this.kRN.mPosition + this.kRA.getListView().getHeaderViewsCount();
            if (this.kRN.getView() != null) {
                final int height = this.kRN.getView().getHeight();
                final int height2 = ((rect.height() - this.kRA.dcT()) - this.kRA.getNavigationBarHeight()) - this.kRA.dcS();
                final int i = height - height2;
                if (i > 0) {
                    this.kRA.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.kRA != null && NewSubPbActivity.this.kRA.getListView() != null) {
                                NewSubPbActivity.this.kRA.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.kRA.getNavigationBarHeight() - i);
                            }
                        }
                    });
                } else {
                    this.kRA.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.kRA != null && NewSubPbActivity.this.kRA.getListView() != null) {
                                NewSubPbActivity.this.kRA.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.kRA.getNavigationBarHeight() + (height2 - height));
                            }
                        }
                    });
                }
            }
        }
    }

    private void cYe() {
        if (this.kRy != null && !at.isEmpty(this.kRy.cYB())) {
            com.baidu.tbadk.BdToken.c.aYs().p(com.baidu.tbadk.BdToken.b.dNF, com.baidu.adp.lib.f.b.toLong(this.kRy.cYB(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.kRy == null || at.isEmpty(this.kRy.cYB())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.kRy.cYB(), 0L);
    }
}
