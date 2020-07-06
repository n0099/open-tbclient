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
import com.baidu.adp.base.e;
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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
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
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.main.ad;
import com.baidu.tieba.pb.pb.main.au;
import com.baidu.tieba.pb.pb.main.az;
import com.baidu.tieba.pb.pb.main.l;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.tbadkCore.data.PostData;
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
/* loaded from: classes9.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, i, com.baidu.tieba.pb.pb.a<NewSubPbActivity> {
    private static String ktc = "tbgametype";
    private View.OnClickListener aLl;
    private az dEN;
    private com.baidu.adp.lib.d.b<ImageView> eLl;
    private com.baidu.adp.lib.d.b<GifView> eLm;
    private com.baidu.adp.lib.d.b<TextView> eOC;
    private com.baidu.adp.lib.d.b<View> eOD;
    private com.baidu.adp.lib.d.b<LinearLayout> eOE;
    private com.baidu.adp.lib.d.b<RelativeLayout> eOF;
    private com.baidu.tieba.frs.profession.permission.c hDN;
    private VoiceManager hzJ;
    private com.baidu.tieba.write.c iyU;
    private EditText iyV;
    public ak jhL;
    private h jhW;
    private com.baidu.tieba.pb.pb.main.b.a kbH;
    private e kfJ;
    private com.baidu.tbadk.core.view.c kfK;
    private com.baidu.adp.widget.ImageView.a kfN;
    private String kfO;
    private TbRichTextMemeInfo kfP;
    private com.baidu.tieba.pb.pb.report.a kfn;
    private com.baidu.tbadk.baseEditMark.a kfo;
    private PostWriteCallBackData khu;
    private String knL;
    private SubPbModel ktd;
    private ForumManageModel kte;
    private com.baidu.tieba.pb.pb.sub.a ktf;
    private ad ktg;
    private AbsListView.OnScrollListener kth;
    private TbRichTextView.i kti;
    private SubPbModel.a ktj;
    private com.baidu.adp.base.d ktk;
    private BdUniqueId kto;
    private com.baidu.tieba.pb.e<n> ktq;
    private boolean ktr;
    private l kts;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int kgw = 0;
    PostData izC = null;
    private a.InterfaceC0477a kgs = null;
    private a ktl = null;
    private a ktm = null;
    private boolean mIsPaused = false;
    private boolean ktn = false;
    private boolean ktp = false;
    private boolean eud = false;
    private com.baidu.tbadk.editortools.pb.c evE = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bfz() {
            NewSubPbActivity.this.ktf.cOc();
        }
    };
    private int kbd = 0;
    private boolean mIsFromSchema = false;
    private com.baidu.tbadk.editortools.pb.b evF = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bfy() {
            if (!NewSubPbActivity.this.iyU.dqO()) {
                return (NewSubPbActivity.this.jhL == null || NewSubPbActivity.this.ktd == null || NewSubPbActivity.this.ktd.bXe() == null || NewSubPbActivity.this.jhL.aF(NewSubPbActivity.this.ktd.bXe().replyPrivateFlag, ak.dUx)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.iyU.dqQ());
            if (NewSubPbActivity.this.jhW.bfQ()) {
                NewSubPbActivity.this.jhW.a(NewSubPbActivity.this.khu);
            }
            NewSubPbActivity.this.oF(true);
            return true;
        }
    };
    private NewWriteModel.d izb = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ad adVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.jhW != null && NewSubPbActivity.this.jhW.bfa() != null) {
                NewSubPbActivity.this.jhW.bfa().hide();
                if (NewSubPbActivity.this.ktd.cOB()) {
                    TiebaStatic.log(new ao("c10367").dk("post_id", NewSubPbActivity.this.ktd.bfw()));
                }
            }
            if (z) {
                NewSubPbActivity.this.iyU.ON(null);
                NewSubPbActivity.this.iyU.aY(null);
                NewSubPbActivity.this.iyU.vE(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.iyU.aY(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.iyU.ON(postWriteCallBackData.getErrorString());
                if (!w.isEmpty(NewSubPbActivity.this.iyU.dqM())) {
                    NewSubPbActivity.this.khu = postWriteCallBackData;
                    if (NewSubPbActivity.this.jhW.bfQ()) {
                        NewSubPbActivity.this.jhW.a(NewSubPbActivity.this.khu);
                    }
                    NewSubPbActivity.this.oF(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (ar.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(NewSubPbActivity.this.getActivity(), NewSubPbActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(NewSubPbActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(NewSubPbActivity.this.getActivity());
                if (ar.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.we(NewSubPbActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.we(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(NewSubPbActivity.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new ao("c13746").ag("obj_locate", 1).ag("obj_type", 2));
                    }
                });
                aVar.b(NewSubPbActivity.this.getPageContext()).aUN();
                TiebaStatic.log(new ao("c13745").ag("obj_locate", 1).ag("obj_type", 2));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.jhL != null) {
                NewSubPbActivity.this.jhL.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.ktf.cOd();
        }
    };
    private CustomMessageListener kgj = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.kto) {
                NewSubPbActivity.this.ktf.bJn();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.kfK.showSuccessToast(NewSubPbActivity.this.kfJ.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.kfJ.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.yH(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.cJC();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ar.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.kfJ.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.kfK.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener kgk = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.kto) {
                NewSubPbActivity.this.ktf.bJn();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.kfK.showSuccessToast(NewSubPbActivity.this.kfJ.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ar.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.kfJ.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.kfK.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener kgl = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.kto) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.ktf.bJn();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.lUk;
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
                    NewSubPbActivity.this.ktf.a(sparseArray, z);
                }
            }
        }
    };
    boolean kgx = false;
    private final b.a kgz = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.kfN != null && !TextUtils.isEmpty(NewSubPbActivity.this.kfO)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.kfP == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.kfO));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.kfO;
                        aVar.pkgId = NewSubPbActivity.this.kfP.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.kfP.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.dEN == null) {
                            NewSubPbActivity.this.dEN = new az(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.dEN.j(NewSubPbActivity.this.kfO, NewSubPbActivity.this.kfN.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.kfN = null;
                NewSubPbActivity.this.kfO = null;
            }
        }
    };
    private CustomMessageListener iLF = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener hBj = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    com.baidu.tbadk.data.l lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.ktd.cOu() != null && NewSubPbActivity.this.ktd.cOu().cHJ() != null && NewSubPbActivity.this.ktd.cOu().cHJ().aSp() != null && currentAccount.equals(NewSubPbActivity.this.ktd.cOu().cHJ().aSp().getUserId()) && NewSubPbActivity.this.ktd.cOu().cHJ().aSp().getPendantData() != null) {
                        NewSubPbActivity.this.ktd.cOu().cHJ().aSp().getPendantData().vN(lVar.aQl());
                        NewSubPbActivity.this.ktd.cOu().cHJ().aSp().getPendantData().ct(lVar.beE());
                        NewSubPbActivity.this.ktf.a(NewSubPbActivity.this.ktd.cOu(), NewSubPbActivity.this.ktd.cOu().cHJ(), NewSubPbActivity.this.ktd.cOu().csJ(), NewSubPbActivity.this.ktd.cOu().aOo(), NewSubPbActivity.this.ktd.cHd(), NewSubPbActivity.this.ktd.cOH() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes9.dex */
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
        this.kfJ = getPageContext();
        this.ktn = true;
        this.iyU = new com.baidu.tieba.write.c();
        this.iyU.GA(R.color.cp_cont_h_alpha85);
        this.iyU.Gz(R.color.cp_cont_a);
        bzy();
        cNS();
        initData(bundle);
        initUI();
        ((SubPbView) this.ktf.getRootView()).show();
        pZ(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.ktf.sG(this.mIsFromSchema);
        this.kfK = new com.baidu.tbadk.core.view.c();
        this.kfK.toastTime = 1000L;
        registerListener(this.kgl);
        registerListener(this.kgj);
        registerListener(this.kgk);
        this.kto = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.kto;
        userMuteAddAndDelCustomMessage.setTag(this.kto);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.kto;
        userMuteCheckCustomMessage.setTag(this.kto);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.jhL = new ak(getPageContext());
        this.jhL.a(new ak.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tbadk.core.util.ak.a
            public void q(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.jhW.bfX();
                }
            }
        });
        this.kfn = new com.baidu.tieba.pb.pb.report.a(this);
        this.kfn.w(getUniqueId());
        this.kbH = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.ktf = new com.baidu.tieba.pb.pb.sub.a(this, this.aLl);
        this.ktf.a(this.ktd);
        setContentView(this.ktf.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.ktf.setOnScrollListener(this.kth);
        this.ktf.b(this);
        this.ktf.setOnImageClickListener(this.kti);
        this.ktf.setOnLongClickListener(this.mOnLongClickListener);
        this.ktf.f(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.ktd != null) {
                    NewSubPbActivity.this.ktd.loadData();
                }
            }
        });
        this.ktf.a(this.ktl);
        this.ktf.b(this.ktm);
        if (this.ktd != null && this.ktd.cNU() && !this.ktd.cOG()) {
            this.ktf.cOi().setVisibility(8);
        } else {
            this.ktf.cOi().setVisibility(0);
        }
        if (this.ktd != null && !this.ktd.cNU()) {
            this.ktf.setIsFromPb(false);
        }
    }

    private boolean aD(Bundle bundle) {
        if (bundle != null) {
            this.eud = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eud = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eud;
    }

    public void initData(Bundle bundle) {
        this.ktd = new SubPbModel(getPageContext());
        this.ktd.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                NewSubPbActivity.this.ktf.u(postData);
                NewSubPbActivity.this.ktf.b((BdListView.e) null);
            }
        });
        this.kte = new ForumManageModel(getPageContext());
        this.kte.setLoadDataCallBack(this.ktk);
        this.hzJ = new VoiceManager();
        this.hzJ.onCreate(getPageContext());
        this.kfo = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.kfo != null) {
            this.kfo.a(this.kgs);
        }
        if (bundle != null) {
            this.ktd.initWithBundle(bundle);
        } else {
            this.ktd.initWithIntent(getIntent());
        }
        this.ktd.a(this.ktj);
        if (this.ktd.cNU()) {
            this.ktd.loadData();
        } else {
            this.ktd.cOz();
        }
    }

    public void cNS() {
        this.ktj = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, n nVar) {
                if (NewSubPbActivity.this.ktf != null) {
                    NewSubPbActivity.this.ktf.cOd();
                    if (!z) {
                        NewSubPbActivity.this.bv(i, str);
                        return;
                    }
                    NewSubPbActivity.this.ktf.hideNoDataView();
                    if (nVar != null) {
                        if (nVar.cHJ() != null || NewSubPbActivity.this.ktd != null) {
                            nVar.cHJ().a(NewSubPbActivity.this.ktd.cOF());
                        }
                        if (NewSubPbActivity.this.ktf != null) {
                            NewSubPbActivity.this.pZ(nVar.aPS() != null && nVar.aPS().isBjh());
                            if (NewSubPbActivity.this.jhW != null && NewSubPbActivity.this.jhW.bfa() != null) {
                                NewSubPbActivity.this.jhW.bfa().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.ktf.a(nVar, NewSubPbActivity.this.ktd.cHd(), NewSubPbActivity.this.ktd.cOH() != null);
                            if (NewSubPbActivity.this.ktn) {
                                NewSubPbActivity.this.ktf.getListView().setSelectionFromTop(NewSubPbActivity.this.ktf.getListView().getHeaderViewsCount() + 1, -com.baidu.adp.lib.util.l.getDimens(NewSubPbActivity.this, R.dimen.tbds18));
                                NewSubPbActivity.this.cNT();
                                NewSubPbActivity.this.ktn = false;
                            }
                        }
                        if (NewSubPbActivity.this.jhW != null) {
                            NewSubPbActivity.this.jhW.a(nVar.bXe());
                            NewSubPbActivity.this.jhW.setThreadData(nVar.aPS());
                        }
                        if (NewSubPbActivity.this.ktq == null) {
                            NewSubPbActivity.this.ktq = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.ktq.setData(nVar);
                        NewSubPbActivity.this.ktq.setType(0);
                        NewSubPbActivity.this.jhL.a(NewSubPbActivity.this.ktd.cOK());
                    }
                }
            }
        };
        this.kgs = new a.InterfaceC0477a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0477a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.kfo != null) {
                        NewSubPbActivity.this.kfo.gJ(z2);
                    }
                    MarkData aOr = NewSubPbActivity.this.kfo.aOr();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(aOr);
                        if (NewSubPbActivity.this.kfo != null) {
                            if (aOr != null) {
                                NewSubPbActivity.this.ktd.sI(true);
                                NewSubPbActivity.this.ktd.Kt(NewSubPbActivity.this.ktd.bfw());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.ktf != null) {
                                NewSubPbActivity.this.ktf.sH(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.ktd.sI(false);
                        NewSubPbActivity.this.ktd.Kt(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.ktf != null) {
                            NewSubPbActivity.this.ktf.sH(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.ktl = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.ktd.cOu() != null && NewSubPbActivity.this.ktd.cOu().aPS() != null && NewSubPbActivity.this.ktd.cOu().aPS().aSp() != null) {
                    str = String.valueOf(NewSubPbActivity.this.ktd.cOu().aPS().aSp().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.ktd.cOu().bfV().getId(), NewSubPbActivity.this.ktd.cOu().bfV().getName(), NewSubPbActivity.this.ktd.cOu().aPS().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.ktm = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.kte.diM() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.ktd != null && NewSubPbActivity.this.ktd.cOu() != null && NewSubPbActivity.this.ktd.cOu().bfV() != null && NewSubPbActivity.this.ktd.cOu().aPS() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.kte.Nj(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.kte.a(NewSubPbActivity.this.ktd.cOu().bfV().getId(), NewSubPbActivity.this.ktd.cOu().bfV().getName(), NewSubPbActivity.this.ktd.cOu().aPS().getId(), valueOf, i2, i, z, NewSubPbActivity.this.ktd.cOu().aPS().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.ktk = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.ktf.a(NewSubPbActivity.this.kte.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.kte.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.kun != 1002 || bVar.fPZ) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.ktf.a(1, dVar.Pv, dVar.lIA, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean cE(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void bzy() {
        registerListener(this.hBj);
        this.aLl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v85, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostData postData;
                SparseArray sparseArray;
                boolean z = false;
                if (view != null || NewSubPbActivity.this.ktf != null) {
                    if (view == NewSubPbActivity.this.ktf.cOo()) {
                        NewSubPbActivity.this.ktf.cMC();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                bc.aWU().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.ktf.ccQ()) {
                        if (view != NewSubPbActivity.this.ktf.cOh()) {
                            if (view != NewSubPbActivity.this.ktf.cOg()) {
                                if (view == NewSubPbActivity.this.ktf.cOb()) {
                                    NewSubPbActivity.this.ktf.cMC();
                                    if (NewSubPbActivity.this.ktd.loadData()) {
                                        NewSubPbActivity.this.ktf.cNZ();
                                    }
                                } else if (view == NewSubPbActivity.this.ktf.cOi() || view == NewSubPbActivity.this.ktf.cOj() || view == NewSubPbActivity.this.ktf.cOl()) {
                                    if (NewSubPbActivity.this.ktp) {
                                        NewSubPbActivity.this.ktp = false;
                                        return;
                                    }
                                    if (NewSubPbActivity.this.ktd.cOu() != null && NewSubPbActivity.this.ktd.cOu().aPS() != null) {
                                        z = aw.a(NewSubPbActivity.this.ktd.cOu().aPS().getBaijiahaoData());
                                    }
                                    if (z) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.ktd.cKa(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.ktd.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.ktd.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.ktd.cOu() != null && NewSubPbActivity.this.ktd.cOu().aPS() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.ktd.cOu().aPS().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.ktd.cKa(), NewSubPbActivity.this.ktd.bfw(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.ktd.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.ktd.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.ktf.cOm() == null || view != NewSubPbActivity.this.ktf.cOm().cKZ()) {
                                    if (NewSubPbActivity.this.ktf.cOm() == null || view != NewSubPbActivity.this.ktf.cOm().cLc()) {
                                        if (NewSubPbActivity.this.ktf.cOm() == null || view != NewSubPbActivity.this.ktf.cOm().cLa()) {
                                            if (NewSubPbActivity.this.ktf.cOm() == null || view != NewSubPbActivity.this.ktf.cOm().cLb()) {
                                                if (NewSubPbActivity.this.ktf.cOm() == null || view != NewSubPbActivity.this.ktf.cOm().cLd()) {
                                                    if (view == NewSubPbActivity.this.ktf.cOf() || view == NewSubPbActivity.this.ktf.cOl()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.jhW.bga()) {
                                                                NewSubPbActivity.this.jhW.bgb();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.jhW.yI(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view != null && (view.getTag() instanceof l)) {
                                                        NewSubPbActivity.this.kts = (l) view.getTag();
                                                        if (be.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.ktp) {
                                                                NewSubPbActivity.this.ktp = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.jhL == null || NewSubPbActivity.this.ktd == null || NewSubPbActivity.this.ktd.bXe() == null || NewSubPbActivity.this.jhL.lp(NewSubPbActivity.this.ktd.bXe().replyPrivateFlag)) && (sparseArray = (SparseArray) view.getTag(R.id.tag_from)) != null) {
                                                                if (sparseArray.get(R.id.tag_clip_board) instanceof PostData) {
                                                                    PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                    if (postData2 != null && postData2.aSp() != null) {
                                                                        MetaData aSp = postData2.aSp();
                                                                        NewSubPbActivity.this.jhW.setReplyId(aSp.getUserId());
                                                                        boolean booleanValue = sparseArray.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue() : true;
                                                                        if (!(view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) || view.getTag(R.id.tag_subpb_ban_display_keyboard) != Boolean.TRUE) {
                                                                            r6 = false;
                                                                        }
                                                                        if (!booleanValue) {
                                                                            if (!r6) {
                                                                                NewSubPbActivity.this.jhW.yJ("");
                                                                            }
                                                                        } else if (!r6) {
                                                                            NewSubPbActivity.this.jhW.yJ(aSp.getName_show());
                                                                        }
                                                                    }
                                                                    NewSubPbActivity.this.ktf.cNX();
                                                                }
                                                                if (NewSubPbActivity.this.ktr) {
                                                                    NewSubPbActivity.this.sF(false);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || view.getId() != R.id.post_info_commont_img) {
                                                        if (NewSubPbActivity.this.ktg == null || view != NewSubPbActivity.this.ktg.cLb()) {
                                                            if (NewSubPbActivity.this.ktg == null || view != NewSubPbActivity.this.ktg.cKZ()) {
                                                                if (NewSubPbActivity.this.ktg == null || view != NewSubPbActivity.this.ktg.cLc()) {
                                                                    if (NewSubPbActivity.this.ktg == null || view != NewSubPbActivity.this.ktg.cLd()) {
                                                                        if (NewSubPbActivity.this.ktg == null || view != NewSubPbActivity.this.ktg.cLf()) {
                                                                            if (NewSubPbActivity.this.ktg == null || view != NewSubPbActivity.this.ktg.cLg()) {
                                                                                if (NewSubPbActivity.this.ktg != null && view == NewSubPbActivity.this.ktg.cLa()) {
                                                                                    if (!j.isNetWorkAvailable()) {
                                                                                        NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                                                        return;
                                                                                    }
                                                                                    SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                                                                                    if (sparseArray2 != null) {
                                                                                        boolean booleanValue2 = ((Boolean) sparseArray2.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                        boolean booleanValue3 = ((Boolean) sparseArray2.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                        boolean booleanValue4 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                        if (booleanValue2) {
                                                                                            if (booleanValue4) {
                                                                                                sparseArray2.put(R.id.tag_from, 1);
                                                                                                sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                                                                NewSubPbActivity.this.c(sparseArray2);
                                                                                                return;
                                                                                            }
                                                                                            sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                                                            NewSubPbActivity.this.ktf.cJ(view);
                                                                                            return;
                                                                                        } else if (booleanValue3) {
                                                                                            NewSubPbActivity.this.ktf.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                            return;
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                int id = view.getId();
                                                                                if (id == R.id.pb_item_tail_content) {
                                                                                    if (be.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.aVP().getString("tail_link", "");
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
                                                                                        PostData postData3 = (PostData) obj;
                                                                                        if (postData3.getType() != PostData.dLC && !TextUtils.isEmpty(postData3.getBimg_url()) && k.aPA().isShowImages()) {
                                                                                            NewSubPbActivity.this.Kq(postData3.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.kfN != null && !TextUtils.isEmpty(NewSubPbActivity.this.kfO)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.dEN == null) {
                                                                                        NewSubPbActivity.this.dEN = new az(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.dEN.j(NewSubPbActivity.this.kfO, NewSubPbActivity.this.kfN.getImageByte());
                                                                                    NewSubPbActivity.this.kfN = null;
                                                                                    NewSubPbActivity.this.kfO = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.kfN != null && !TextUtils.isEmpty(NewSubPbActivity.this.kfO)) {
                                                                            if (NewSubPbActivity.this.kfP == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.kfO));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.kfO;
                                                                                aVar.pkgId = NewSubPbActivity.this.kfP.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.kfP.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.kfN = null;
                                                                            NewSubPbActivity.this.kfO = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.izC != null) {
                                                                        NewSubPbActivity.this.izC.fp(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.izC = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.ktf.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.cD(view);
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
                                                                NewSubPbActivity.this.JO((String) tag);
                                                                return;
                                                            } else if (tag instanceof SparseArray) {
                                                                SparseArray<Object> sparseArray4 = (SparseArray) tag;
                                                                if ((sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                                    sparseArray4.put(R.id.tag_from, 0);
                                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                                    NewSubPbActivity.this.c(sparseArray4);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    } else if (NewSubPbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                        SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                        if ((sparseArray5.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray5.get(R.id.tag_load_sub_data)) != null) {
                                                            if (NewSubPbActivity.this.ktd != null) {
                                                                TiebaStatic.log(new ao("c13700").dk("tid", NewSubPbActivity.this.ktd.cKb()).dk("fid", NewSubPbActivity.this.ktd.getFromForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dk("post_id", postData.getId()).ag("obj_type", 3));
                                                            }
                                                            if (postData.aSp() != null) {
                                                                MetaData aSp2 = postData.aSp();
                                                                NewSubPbActivity.this.jhW.setReplyId(aSp2.getUserId());
                                                                if (!(sparseArray5.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray5.get(R.id.tag_is_subpb)).booleanValue() : true)) {
                                                                    NewSubPbActivity.this.jhW.yJ("");
                                                                } else {
                                                                    NewSubPbActivity.this.jhW.yJ(aSp2.getName_show());
                                                                }
                                                            }
                                                            NewSubPbActivity.this.ktf.cNX();
                                                            if (NewSubPbActivity.this.ktr) {
                                                                NewSubPbActivity.this.sF(false);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (view.getTag() != null && (view.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                    if (sparseArray6.get(R.id.tag_clip_board) instanceof PostData) {
                                                        ((PostData) sparseArray6.get(R.id.tag_clip_board)).fp(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new ao("c11739").ag("obj_locate", 4));
                                            if (!j.isNetWorkAvailable()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.ktf.cMC();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.JO(str4);
                                                    return;
                                                }
                                                return;
                                            } else if (tag2 instanceof SparseArray) {
                                                SparseArray<Object> sparseArray7 = (SparseArray) tag2;
                                                if ((sparseArray7.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray7.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray7.put(R.id.tag_from, 0);
                                                    sparseArray7.put(R.id.tag_check_mute_from, 2);
                                                    NewSubPbActivity.this.c(sparseArray7);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        } else if (j.isNetWorkAvailable()) {
                                            NewSubPbActivity.this.ktf.cMC();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.cN(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.ktf.cMC();
                                    SparseArray sparseArray8 = (SparseArray) view.getTag();
                                    if (sparseArray8 != null) {
                                        NewSubPbActivity.this.ktf.a(((Integer) sparseArray8.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray8.get(R.id.tag_del_post_id), ((Integer) sparseArray8.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray8.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new ao("c11739").ag("obj_locate", 2));
                                    NewSubPbActivity.this.ktf.cMC();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.ktd.cOu() != null) {
                                        NewSubPbActivity.this.n(NewSubPbActivity.this.ktd.cOu().cHJ());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.ktf.cNW();
                                NewSubPbActivity.this.ktf.cNX();
                                if (NewSubPbActivity.this.jhW != null) {
                                    NewSubPbActivity.this.jhW.bgd();
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.ktf.cNW();
                            NewSubPbActivity.this.ktf.cNX();
                            if (NewSubPbActivity.this.jhW != null) {
                                NewSubPbActivity.this.jhW.bgc();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.cJb();
                        if (NewSubPbActivity.this.ktd != null && NewSubPbActivity.this.ktd.cOu() != null && NewSubPbActivity.this.ktd.cOu().aPS() != null && NewSubPbActivity.this.ktd.cOu().aPS().aSp() != null) {
                            TiebaStatic.log(new ao("c13402").dk("tid", NewSubPbActivity.this.ktd.cKa()).s("fid", NewSubPbActivity.this.ktd.cOu().aPS().getFid()).ag("obj_locate", 5).dk("uid", NewSubPbActivity.this.ktd.cOu().aPS().aSp().getUserId()));
                        }
                    }
                }
            }
        };
        this.kth = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.ktf.cMC();
                    if (NewSubPbActivity.this.kbd != 2 && NewSubPbActivity.this.kbd != 1) {
                        NewSubPbActivity.this.ktf.cOr();
                    }
                }
                NewSubPbActivity.this.jhW.bgb();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.ktf.cOn();
            }
        };
        this.mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
            @Override // android.view.View.OnLongClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onLongClick(View view) {
                SparseArray<Object> sparseArray;
                SparseArray<Object> sparseArray2;
                if (NewSubPbActivity.this.ktf != null && NewSubPbActivity.this.ktf.cOe()) {
                    return false;
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null && NewSubPbActivity.this.cE(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.kfN = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.kfO = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.kfN == null || TextUtils.isEmpty(NewSubPbActivity.this.kfO)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.kfP = null;
                        } else {
                            NewSubPbActivity.this.kfP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.kfN = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.kfO = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.kfP = null;
                        } else {
                            NewSubPbActivity.this.kfP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.kfN = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.kfO = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.kfP = null;
                        } else {
                            NewSubPbActivity.this.kfP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.ktf.a(NewSubPbActivity.this.kgz, NewSubPbActivity.this.kfN.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.izC = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.izC == null || NewSubPbActivity.this.kfo == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.kfo != null) {
                            NewSubPbActivity.this.kfo.gJ(NewSubPbActivity.this.ktd.cOA());
                        }
                        boolean z = NewSubPbActivity.this.kfo.aOo() && NewSubPbActivity.this.izC.getId() != null && NewSubPbActivity.this.izC.getId().equals(NewSubPbActivity.this.ktd.cOC());
                        if (NewSubPbActivity.this.ktg == null) {
                            NewSubPbActivity.this.ktg = new ad(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aLl);
                            NewSubPbActivity.this.ktf.cO(NewSubPbActivity.this.ktg.getView());
                            NewSubPbActivity.this.ktg.rU(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.ktg.showDialog();
                        boolean z2 = NewSubPbActivity.this.rH(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z3 = (NewSubPbActivity.this.ktd.cOu() == null || NewSubPbActivity.this.ktd.cOu().aPS() == null || !NewSubPbActivity.this.ktd.cOu().aPS().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z) {
                            NewSubPbActivity.this.ktg.cKZ().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.ktg.cKZ().setText(R.string.mark);
                        }
                        if (booleanValue || z3) {
                            NewSubPbActivity.this.ktg.cKZ().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.ktg.cKZ().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.cE(view)) {
                            if (NewSubPbActivity.this.kfN != null && !NewSubPbActivity.this.kfN.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        NewSubPbActivity.this.ktg.a(sparseArray2, NewSubPbActivity.this.cHd(), z2);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.kti = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX DEBUG: Multi-variable search result rejected for r2v44, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i, boolean z, boolean z2) {
                String str2;
                boolean z3;
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap;
                int i2;
                boolean z4;
                ArrayList<String> arrayList;
                String str3;
                boolean z5;
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2;
                boolean z6;
                try {
                    if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        n cOu = NewSubPbActivity.this.ktd.cOu();
                        TbRichText bt = NewSubPbActivity.this.bt(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bt != null && bt.bkP() != null) {
                            tbRichTextData = bt.bkP().get(NewSubPbActivity.this.kgw);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.bkV().bli()) {
                                String c = NewSubPbActivity.this.c(tbRichTextData);
                                arrayList2.add(c);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(c, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (cOu == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (cOu.bfV() != null) {
                                        str4 = cOu.bfV().getName();
                                        str5 = cOu.bfV().getId();
                                    }
                                    if (cOu.aPS() != null) {
                                        str6 = cOu.aPS().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.ktd.cOH() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.ktd.cOH();
                                    z6 = NewSubPbActivity.this.ktd.cOJ();
                                    arrayList2 = NewSubPbActivity.this.ktd.cOI();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(w.getItem(arrayList2, 0));
                                ImageViewerConfig createConfig = new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false);
                                createConfig.setPostId(String.valueOf(bt.getPostId()));
                                createConfig.setThreadData(NewSubPbActivity.this.aPS());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                                return;
                            }
                            NewSubPbActivity.this.kgx = false;
                            String str7 = "";
                            TbRichText dib = cOu.cHJ().dib();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(dib, bt, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (cOu == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (cOu.bfV() != null) {
                                    str8 = cOu.bfV().getName();
                                    str9 = cOu.bfV().getId();
                                }
                                if (cOu.aPS() != null) {
                                    str10 = cOu.aPS().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.ktd.cOH() != null) {
                                concurrentHashMap = NewSubPbActivity.this.ktd.cOH();
                                z4 = NewSubPbActivity.this.ktd.cOJ();
                                arrayList = NewSubPbActivity.this.ktd.cOI();
                                i2 = a2 + NewSubPbActivity.this.ktd.getOffset();
                            } else {
                                concurrentHashMap = concurrentHashMap3;
                                i2 = a2;
                                z4 = z3;
                                arrayList = arrayList2;
                            }
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(w.getItem(arrayList, i2));
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList4, 0, str8, str9, str2, z4, str7, true, concurrentHashMap, true, false, false);
                            createConfig2.setThreadData(NewSubPbActivity.this.aPS());
                            createConfig2.setPostId(String.valueOf(bt.getPostId()));
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
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
    public bu aPS() {
        if (this.ktd == null || this.ktd.cOu() == null) {
            return null;
        }
        return this.ktd.cOu().aPS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(View view) {
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
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bkV;
        if (tbRichText == tbRichText2) {
            this.kgx = true;
        }
        if (tbRichText != null && tbRichText.bkP() != null) {
            int size = tbRichText.bkP().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.bkP().get(i6) != null && tbRichText.bkP().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.bkP().get(i6).bkV().getWidth() * equipmentDensity;
                    int height = tbRichText.bkP().get(i6).bkV().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.bkP().get(i6).bkV().bli()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.bkP().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (bkV = tbRichTextData.bkV()) != null) {
                            String blk = bkV.blk();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = blk;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.kgx) {
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
        if (this.ktg != null) {
            this.ktg.rU(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bkV = tbRichTextData.bkV();
        if (bkV != null) {
            if (!StringUtils.isNull(bkV.blh())) {
                return bkV.blh();
            }
            if (bkV.getHeight() * bkV.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bkV.getHeight() * bkV.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bkV.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bkV.getHeight())));
            } else {
                float width = bkV.getWidth() / bkV.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ar.getUrlEncode(bkV.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bt(String str, int i) {
        if (this.ktd == null || this.ktd.cOu() == null || str == null || i < 0) {
            return null;
        }
        n cOu = this.ktd.cOu();
        TbRichText a2 = a(cOu.cHJ(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(cOu.cHJ(), str, i);
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
        TbRichText dib = postData.dib();
        if (dib != null) {
            ArrayList<TbRichTextData> bkP = dib.bkP();
            int size = bkP.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (bkP.get(i3) != null && bkP.get(i3).getType() == 8) {
                    i2++;
                    if (bkP.get(i3).bkV().blk().equals(str)) {
                        int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = bkP.get(i3).bkV().getWidth() * equipmentDensity;
                        int height = bkP.get(i3).bkV().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.kgw = i3;
                        return dib;
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
    public void cJb() {
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false) {
            if (this.jhL == null || this.ktd == null || this.ktd.bXe() == null || this.jhL.lp(this.ktd.bXe().replyPrivateFlag)) {
                if (this.jhW.bfQ()) {
                    this.jhW.a((PostWriteCallBackData) null);
                    return;
                }
                this.ktf.cNW();
                this.ktf.cNX();
                if (this.jhW != null) {
                    this.jhW.bge();
                    return;
                }
                return;
            }
            return;
        }
        if (this.hDN == null) {
            this.hDN = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.hDN.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void nl(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void z(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void nm(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.jhL == null || NewSubPbActivity.this.ktd == null || NewSubPbActivity.this.ktd.bXe() == null || NewSubPbActivity.this.jhL.lp(NewSubPbActivity.this.ktd.bXe().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.jhW.bfQ()) {
                                NewSubPbActivity.this.jhW.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.ktf.cNW();
                            NewSubPbActivity.this.ktf.cNX();
                            if (NewSubPbActivity.this.jhW != null) {
                                NewSubPbActivity.this.jhW.bge();
                            }
                        }
                    }
                }
            });
        }
        if (this.ktd != null && this.ktd.cOu() != null && this.ktd.cOu().bfV() != null) {
            this.hDN.D(this.ktd.cOu().bfV().getId(), com.baidu.adp.lib.f.b.toLong(this.ktd.cKa(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rH(boolean z) {
        if (this.ktd == null) {
            return false;
        }
        return ((cHd() != 0) || this.ktd.cOu() == null || this.ktd.cOu().aPS() == null || this.ktd.cOu().aPS().aSp() == null || this.ktd.cOu().aPS().aQZ() || TextUtils.equals(this.ktd.cOu().aPS().aSp().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(int i, String str) {
        if (this.ktd.cOv()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.isNetOk()) {
            if (i == 4) {
                this.ktf.DI(str + "(4)");
            } else {
                this.ktf.ym(R.string.no_data_text);
            }
        } else {
            this.ktf.ym(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pZ(boolean z) {
        this.jhW = (h) new com.baidu.tbadk.editortools.pb.i(z).dO(getActivity());
        if (this.jhW != null) {
            this.jhW.a(getPageContext());
            this.jhW.b(this.ktd);
            this.jhW.b(this.izb);
            this.jhW.a(this.evE);
            this.jhW.a(this.evF);
            this.jhW.bfa().m32if(true);
            this.jhW.k(getPageContext());
        }
        if (this.ktf != null) {
            this.ktf.i(this.jhW);
        }
        if (this.jhW != null && this.ktd != null) {
            this.jhW.a(this.ktd.bXe());
            this.jhW.bgb();
        }
        if (this.jhW != null) {
            this.jhW.bgf().setDefaultHint(cLQ());
            this.jhW.bgf().setHint(cLQ());
            this.iyV = this.jhW.bgf().getInputView();
            this.iyV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.iyU != null) {
                        if (!NewSubPbActivity.this.iyU.dqP()) {
                            NewSubPbActivity.this.oF(false);
                        }
                        NewSubPbActivity.this.iyU.vF(false);
                    }
                }
            });
        }
    }

    public void cNT() {
        if (!TbadkCoreApplication.isLogin()) {
            this.jhW.bgb();
        } else if (!StringUtils.isNull(this.ktd.cOD())) {
            if (this.ktf.cOa() && com.baidu.adp.lib.util.l.isNetOk()) {
                this.ktf.bVc();
            } else {
                this.ktf.cOd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(View view) {
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
                    this.ktf.cJ(view);
                }
            } else if (booleanValue2) {
                this.ktf.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.ktf.cOk(), getPageContext().getPageActivity());
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
            bVar.kX(R.string.operation);
            bVar.a(strArr, new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                @Override // com.baidu.tbadk.core.dialog.b.a
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.kto);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.kto);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).aUO();
        }
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.ktf.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.kto;
        userMuteCheckCustomMessage.setTag(this.kto);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.ktf.a(0, bVar.Pv, bVar.lIA, z);
            if (bVar.Pv) {
                if (bVar.hhf == 1) {
                    if (this.ktf.getListView() instanceof BdTypeListView) {
                        List<q> data = ((BdTypeListView) this.ktf.getListView()).getData();
                        if (!w.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.ktf.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.hhf == 2) {
                    this.ktd.Ks(bVar.mPostId);
                    this.ktf.a(this.ktd.cOu(), this.ktd.cHd(), this.ktd.cOH() != null);
                    if (this.ktd.cOE()) {
                        this.ktd.sJ(false);
                        this.ktf.cNY();
                        this.ktd.loadData();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void JO(String str) {
        if (this.ktd != null && this.ktd.cOu() != null && this.ktd.cOu().aPS() != null && this.ktd.cOu().aPS().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.ktd.cKa(), str);
            bu aPS = this.ktd.cOu().aPS();
            if (aPS.aQX()) {
                format = format + "&channelid=33833";
            } else if (aPS.aUk()) {
                format = format + "&channelid=33842";
            } else if (aPS.aQY()) {
                format = format + "&channelid=33840";
            }
            JP(format);
            return;
        }
        this.kfn.Kp(str);
    }

    private void JP(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void n(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.ktd.cOA() && postData.getId() != null && postData.getId().equals(this.ktd.cOC())) {
                z = true;
            }
            MarkData o = this.ktd.o(postData);
            if (o != null) {
                this.ktf.cMC();
                if (this.kfo != null) {
                    this.kfo.a(o);
                    if (!z) {
                        this.kfo.aOq();
                    } else {
                        this.kfo.aOp();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.ktd != null) {
            this.ktd.aC(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.jhW != null) {
            this.jhW.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.jhW.bfa().bdC();
        this.jhW.bgb();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.jhW.b(writeData);
                this.jhW.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l nB = this.jhW.bfa().nB(6);
                if (nB != null && nB.etH != null) {
                    nB.etH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.jhW.bfX();
                }
                this.ktf.cOr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hzJ != null) {
            this.hzJ.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.aMo().aMy();
        if (this.hzJ != null) {
            this.hzJ.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.iLF);
        this.ktf.cfa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
        cJF();
        if (this.hzJ != null) {
            this.hzJ.onResume(getPageContext());
        }
        registerListener(this.iLF);
        this.ktf.cfb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hzJ != null) {
            this.hzJ.onStop(getPageContext());
        }
        this.jhW.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.ktq));
        this.ktd.cancelLoadData();
        this.ktd.destory();
        this.kte.cancelLoadData();
        if (this.hzJ != null) {
            this.hzJ.onDestory(getPageContext());
        }
        this.ktf.cMC();
        this.ktf.cdm();
        MessageManager.getInstance().unRegisterListener(this.kgj);
        MessageManager.getInstance().unRegisterListener(this.kgk);
        MessageManager.getInstance().unRegisterListener(this.kgl);
        MessageManager.getInstance().unRegisterListener(this.kto);
        this.kfJ = null;
        this.kfK = null;
        if (this.jhL != null) {
            this.jhL.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ktf.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hzJ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View cOf = this.ktf.cOf();
        if (cOf == null || (findViewWithTag = cOf.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Kh(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = bc.getParamPair(bc.getParamStr(str))) != null) {
            this.ktp = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Kh(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(ktc);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (Kh(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                    kVar.mLink = str;
                    kVar.type = 3;
                    kVar.esJ = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
                }
            } else {
                bc.aWU().b(getPageContext(), new String[]{str});
            }
            this.ktp = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void al(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.ktp = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void am(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void an(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void s(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView getListView() {
        if (this.ktf != null) {
            return this.ktf.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int blz() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> blB() {
        if (this.eOC == null) {
            this.eOC = TbRichTextView.v(getPageContext().getPageActivity(), 8);
        }
        return this.eOC;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> blC() {
        if (this.eLm == null) {
            this.eLm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bSU */
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
        return this.eLm;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> blA() {
        if (this.eLl == null) {
            this.eLl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: blM */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = k.aPA().isShowImages();
                    foreDrawableImageView.setDefaultBg(an.getDrawable(R.color.common_color_10220));
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
                        if (k.aPA().isShowImages()) {
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
        return this.eLl;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> blD() {
        if (this.eOD == null) {
            this.eOD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cJM */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(NewSubPbActivity.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cF */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cG */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cH */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.eOD;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> blE() {
        if (this.eOE == null) {
            this.eOE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cJO */
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
        return this.eOE;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> blF() {
        this.eOF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cJN */
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
        return this.eOF;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cHU() {
        return this.kbH;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cHV() {
        return (this.ktd == null || this.ktd.cOu() == null || this.ktd.cOu().aPS() == null || this.ktd.cOu().aPS().aTM()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cHW() {
        if (this.ktd == null || this.ktd.cOu() == null || this.ktd.cOu().aPS() == null) {
            return null;
        }
        return this.ktd.cOu().aPS().aSt();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cHX() {
        if (this.ktd == null) {
            return 0;
        }
        return this.ktd.cHd();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean JJ(String str) {
        if (StringUtils.isNull(str) || this.ktd == null || this.ktd.cOu() == null || this.ktd.cOu().aPS() == null || this.ktd.cOu().aPS().aSp() == null) {
            return false;
        }
        return str.equals(this.ktd.cOu().aPS().aSp().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.ktf.cOa() && com.baidu.adp.lib.util.l.isNetOk()) {
            this.ktd.loadData();
        } else {
            this.ktf.cOd();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.kto);
        userMuteAddAndDelCustomMessage.setTag(this.kto);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kq(String str) {
        if (!StringUtils.isNull(str) && be.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString("bubble_link", "");
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
    public void ap(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB_FLOOR;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.bhB().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.ktd != null) {
            if (this.ktd.cOu() != null && this.ktd.cOu().bfV() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.ktd.cOu().bfV().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.ktd.cKa(), 0L));
            if (this.ktd.cOu() != null && this.ktd.cOu().aPS() != null) {
                pageStayDurationItem.setNid(this.ktd.cOu().aPS().getNid());
            }
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public boolean cNU() {
        if (this.ktd != null) {
            return this.ktd.cNU();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.ktf.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kfJ.getPageActivity());
        if (ar.isEmpty(str)) {
            aVar.we(this.kfJ.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.we(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.ktf.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.kfJ).aUN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yH(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kfJ.getPageActivity());
        aVar.we(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.kfJ).aUN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJC() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.we(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.kfJ).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.kfJ.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.kfJ).aUN();
    }

    public SubPbModel cNV() {
        return this.ktd;
    }

    public int cHd() {
        if (this.ktd != null) {
            return this.ktd.cHd();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eud && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eud && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void oF(boolean z) {
        if (this.iyV != null && this.iyV.getText() != null) {
            int selectionEnd = this.iyV.getSelectionEnd();
            SpannableStringBuilder d = this.iyU.d(this.iyV.getText());
            if (d != null) {
                this.iyU.vF(true);
                this.iyV.setText(d);
                if (z && this.iyU.dqN() >= 0) {
                    this.iyV.requestFocus();
                    this.iyV.setSelection(this.iyU.dqN());
                } else {
                    this.iyV.setSelection(selectionEnd);
                }
                this.iyU.vE(this.iyU.dqN() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jhW != null && this.jhW.bfa() != null && this.jhW.bfa().bfc()) {
            this.jhW.bfa().bdC();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        ae.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.d.a(tVar, getUniqueId(), this);
    }

    public String cLQ() {
        if (!ar.isEmpty(this.knL)) {
            return this.knL;
        }
        this.knL = getResources().getString(au.cLF());
        return this.knL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.ktr = z;
        sF(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sF(boolean z) {
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
        if (this.ktf != null && this.ktf.getListView() != null && this.kts != null && this.kts.mPosition != -1) {
            final int headerViewsCount = this.kts.mPosition + this.ktf.getListView().getHeaderViewsCount();
            if (this.kts.getView() != null) {
                final int height = this.kts.getView().getHeight();
                final int height2 = ((rect.height() - this.ktf.cOq()) - this.ktf.getNavigationBarHeight()) - this.ktf.cOp();
                final int i = height - height2;
                if (i > 0) {
                    this.ktf.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.ktf != null && NewSubPbActivity.this.ktf.getListView() != null) {
                                NewSubPbActivity.this.ktf.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.ktf.getNavigationBarHeight() - i);
                            }
                        }
                    });
                } else {
                    this.ktf.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.ktf != null && NewSubPbActivity.this.ktf.getListView() != null) {
                                NewSubPbActivity.this.ktf.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.ktf.getNavigationBarHeight() + (height2 - height));
                            }
                        }
                    });
                }
            }
        }
    }

    private void cJF() {
        if (this.ktd != null && !ar.isEmpty(this.ktd.cKa())) {
            com.baidu.tbadk.BdToken.c.aMo().p(com.baidu.tbadk.BdToken.b.dyB, com.baidu.adp.lib.f.b.toLong(this.ktd.cKa(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.ktd == null || ar.isEmpty(this.ktd.cKa())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.ktd.cKa(), 0L);
    }
}
