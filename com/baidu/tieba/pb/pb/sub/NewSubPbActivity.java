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
import com.baidu.adp.widget.ListView.p;
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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.m;
import com.baidu.tbadk.editortools.pb.PbEditorData;
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
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.w;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes9.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, h, com.baidu.tieba.pb.pb.a<NewSubPbActivity> {
    private static String iWl = "tbgametype";
    private View.OnClickListener akE;
    private com.baidu.adp.lib.d.b<ImageView> dMQ;
    private com.baidu.adp.lib.d.b<GifView> dMR;
    private com.baidu.adp.lib.d.b<TextView> dPF;
    private com.baidu.adp.lib.d.b<View> dPG;
    private com.baidu.adp.lib.d.b<LinearLayout> dPH;
    private com.baidu.adp.lib.d.b<RelativeLayout> dPI;
    private ar gRU;
    private VoiceManager gpi;
    private com.baidu.tieba.frs.profession.permission.c gsJ;
    public aj hRk;
    private com.baidu.tbadk.editortools.pb.h hRt;
    private com.baidu.tieba.write.c hiD;
    private EditText hiE;
    private com.baidu.tieba.pb.pb.main.b.a iFX;
    private e iJJ;
    private com.baidu.tbadk.core.view.d iJK;
    private com.baidu.adp.widget.ImageView.a iJN;
    private String iJO;
    private TbRichTextMemeInfo iJP;
    private com.baidu.tieba.pb.pb.report.a iJn;
    private com.baidu.tbadk.baseEditMark.a iJo;
    private PostWriteCallBackData iLo;
    private String iRg;
    private boolean iWA;
    private k iWB;
    private SubPbModel iWm;
    private ForumManageModel iWn;
    private com.baidu.tieba.pb.pb.sub.a iWo;
    private w iWp;
    private AbsListView.OnScrollListener iWq;
    private TbRichTextView.i iWr;
    private SubPbModel.a iWs;
    private com.baidu.adp.base.d iWt;
    private BdUniqueId iWx;
    private com.baidu.tieba.pb.e<l> iWz;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int iKu = 0;
    PostData hjm = null;
    private a.InterfaceC0374a iKr = null;
    private a iWu = null;
    private a iWv = null;
    private boolean eeW = false;
    private boolean iWw = false;
    private boolean iWy = false;
    private boolean dxw = false;
    private com.baidu.tbadk.editortools.pb.c dyT = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aOW() {
            NewSubPbActivity.this.iWo.crT();
        }
    };
    private int iFt = 0;
    private boolean mIsFromSchema = false;
    private com.baidu.tbadk.editortools.pb.b dyU = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOV() {
            if (!NewSubPbActivity.this.hiD.cUz()) {
                return (NewSubPbActivity.this.hRk == null || NewSubPbActivity.this.iWm == null || NewSubPbActivity.this.iWm.bDg() == null || NewSubPbActivity.this.hRk.ax(NewSubPbActivity.this.iWm.bDg().replyPrivateFlag, aj.dal)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.hiD.cUB());
            if (NewSubPbActivity.this.hRt.aPm()) {
                NewSubPbActivity.this.hRt.a(NewSubPbActivity.this.iLo);
            }
            NewSubPbActivity.this.mV(true);
            return true;
        }
    };
    private NewWriteModel.d hiK = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.hRt != null && NewSubPbActivity.this.hRt.aOy() != null) {
                NewSubPbActivity.this.hRt.aOy().hide();
                if (NewSubPbActivity.this.iWm.csr()) {
                    TiebaStatic.log(new an("c10367").cx("post_id", NewSubPbActivity.this.iWm.aOT()));
                }
            }
            if (z) {
                NewSubPbActivity.this.hiD.KK(null);
                NewSubPbActivity.this.hiD.aU(null);
                NewSubPbActivity.this.hiD.tN(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.hiD.aU(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.hiD.KK(postWriteCallBackData.getErrorString());
                if (!v.isEmpty(NewSubPbActivity.this.hiD.cUx())) {
                    NewSubPbActivity.this.iLo = postWriteCallBackData;
                    if (NewSubPbActivity.this.hRt.aPm()) {
                        NewSubPbActivity.this.hRt.a(NewSubPbActivity.this.iLo);
                    }
                    NewSubPbActivity.this.mV(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.hRk != null) {
                NewSubPbActivity.this.hRk.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.iWo.crU();
        }
    };
    private CustomMessageListener iKj = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iWx) {
                NewSubPbActivity.this.iWo.bqx();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.iJK.showSuccessToast(NewSubPbActivity.this.iJJ.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.iJJ.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.vq(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.cnx();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.iJJ.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.iJK.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener iKk = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iWx) {
                NewSubPbActivity.this.iWo.bqx();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.iJK.showSuccessToast(NewSubPbActivity.this.iJJ.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.iJJ.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.iJK.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener iKl = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iWx) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.iWo.bqx();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.kww;
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
                    NewSubPbActivity.this.iWo.a(sparseArray, z);
                }
            }
        }
    };
    boolean iKv = false;
    private final b.a iKx = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.iJN != null && !TextUtils.isEmpty(NewSubPbActivity.this.iJO)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.iJP == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.iJO));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.iJO;
                        aVar.pkgId = NewSubPbActivity.this.iJP.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.iJP.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.gRU == null) {
                            NewSubPbActivity.this.gRU = new ar(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.gRU.j(NewSubPbActivity.this.iJO, NewSubPbActivity.this.iJN.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.iJN = null;
                NewSubPbActivity.this.iJO = null;
            }
        }
    };
    private CustomMessageListener hvk = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener gqx = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    m mVar = (m) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.iWm.csk() != null && NewSubPbActivity.this.iWm.csk().clB() != null && NewSubPbActivity.this.iWm.csk().clB().aCr() != null && currentAccount.equals(NewSubPbActivity.this.iWm.csk().clB().aCr().getUserId()) && NewSubPbActivity.this.iWm.csk().clB().aCr().getPendantData() != null) {
                        NewSubPbActivity.this.iWm.csk().clB().aCr().getPendantData().sA(mVar.aAJ());
                        NewSubPbActivity.this.iWm.csk().clB().aCr().getPendantData().bI(mVar.aOd());
                        NewSubPbActivity.this.iWo.a(NewSubPbActivity.this.iWm.csk(), NewSubPbActivity.this.iWm.csk().clB(), NewSubPbActivity.this.iWm.csk().bXN(), NewSubPbActivity.this.iWm.csk().ayO(), NewSubPbActivity.this.iWm.clb(), NewSubPbActivity.this.iWm.csx() != null);
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
        av(bundle);
        if (getIntent() != null) {
            this.mIsFromSchema = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_FROM_SCHEMA, false);
        }
        super.onCreate(bundle);
        this.iJJ = getPageContext();
        this.iWw = true;
        this.hiD = new com.baidu.tieba.write.c();
        this.hiD.Ei(R.color.cp_cont_h_alpha85);
        this.hiD.Eh(R.color.cp_cont_a);
        initListeners();
        crJ();
        initData(bundle);
        initUI();
        ((SubPbView) this.iWo.getRootView()).show();
        op(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.iWo.qQ(this.mIsFromSchema);
        this.iJK = new com.baidu.tbadk.core.view.d();
        this.iJK.toastTime = 1000L;
        registerListener(this.iKl);
        registerListener(this.iKj);
        registerListener(this.iKk);
        this.iWx = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.iWx;
        userMuteAddAndDelCustomMessage.setTag(this.iWx);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.iWx;
        userMuteCheckCustomMessage.setTag(this.iWx);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.hRk = new aj(getPageContext());
        this.hRk.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tbadk.core.util.aj.a
            public void l(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.hRt.aPt();
                }
            }
        });
        this.iJn = new com.baidu.tieba.pb.pb.report.a(this);
        this.iJn.t(getUniqueId());
        this.iFX = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.iWo = new com.baidu.tieba.pb.pb.sub.a(this, this.akE);
        this.iWo.a(this.iWm);
        setContentView(this.iWo.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.iWo.setOnScrollListener(this.iWq);
        this.iWo.b(this);
        this.iWo.setOnImageClickListener(this.iWr);
        this.iWo.setOnLongClickListener(this.mOnLongClickListener);
        this.iWo.f(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.iWm != null) {
                    NewSubPbActivity.this.iWm.loadData();
                }
            }
        });
        this.iWo.a(this.iWu);
        this.iWo.b(this.iWv);
        if (this.iWm != null && this.iWm.crL() && !this.iWm.csw()) {
            this.iWo.crZ().setVisibility(8);
        } else {
            this.iWo.crZ().setVisibility(0);
        }
        if (this.iWm != null && !this.iWm.crL()) {
            this.iWo.setIsFromPb(false);
        }
    }

    private boolean av(Bundle bundle) {
        if (bundle != null) {
            this.dxw = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.dxw = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.dxw;
    }

    public void initData(Bundle bundle) {
        this.iWm = new SubPbModel(getPageContext());
        this.iWm.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void p(PostData postData) {
                NewSubPbActivity.this.iWo.r(postData);
                NewSubPbActivity.this.iWo.b((BdListView.e) null);
            }
        });
        this.iWn = new ForumManageModel(getPageContext());
        this.iWn.setLoadDataCallBack(this.iWt);
        this.gpi = new VoiceManager();
        this.gpi.onCreate(getPageContext());
        this.iJo = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.iJo != null) {
            this.iJo.a(this.iKr);
        }
        if (bundle != null) {
            this.iWm.initWithBundle(bundle);
        } else {
            this.iWm.initWithIntent(getIntent());
        }
        this.iWm.a(this.iWs);
        if (this.iWm.crL()) {
            this.iWm.loadData();
        } else {
            this.iWm.csp();
        }
    }

    public void crJ() {
        this.iWs = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, l lVar) {
                if (NewSubPbActivity.this.iWo != null) {
                    NewSubPbActivity.this.iWo.crU();
                    if (!z) {
                        NewSubPbActivity.this.aX(i, str);
                        return;
                    }
                    NewSubPbActivity.this.iWo.hideNoDataView();
                    if (lVar != null) {
                        if (lVar.clB() != null || NewSubPbActivity.this.iWm != null) {
                            lVar.clB().a(NewSubPbActivity.this.iWm.csv());
                        }
                        if (NewSubPbActivity.this.iWo != null) {
                            NewSubPbActivity.this.op(lVar.aAj() != null && lVar.aAj().isBjh());
                            if (NewSubPbActivity.this.hRt != null && NewSubPbActivity.this.hRt.aOy() != null) {
                                NewSubPbActivity.this.hRt.aOy().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.iWo.a(lVar, NewSubPbActivity.this.iWm.clb(), NewSubPbActivity.this.iWm.csx() != null);
                            if (NewSubPbActivity.this.iWw) {
                                NewSubPbActivity.this.crK();
                                NewSubPbActivity.this.iWw = false;
                            }
                        }
                        if (NewSubPbActivity.this.hRt != null) {
                            NewSubPbActivity.this.hRt.a(lVar.bDg());
                            NewSubPbActivity.this.hRt.setThreadData(lVar.aAj());
                        }
                        if (NewSubPbActivity.this.iWz == null) {
                            NewSubPbActivity.this.iWz = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.iWz.setData(lVar);
                        NewSubPbActivity.this.iWz.setType(0);
                        NewSubPbActivity.this.hRk.a(NewSubPbActivity.this.iWm.csA());
                    }
                }
            }
        };
        this.iKr = new a.InterfaceC0374a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0374a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.iJo != null) {
                        NewSubPbActivity.this.iJo.fn(z2);
                    }
                    MarkData ayR = NewSubPbActivity.this.iJo.ayR();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(ayR);
                        if (NewSubPbActivity.this.iJo != null) {
                            if (ayR != null) {
                                NewSubPbActivity.this.iWm.qS(true);
                                NewSubPbActivity.this.iWm.Gt(NewSubPbActivity.this.iWm.aOT());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.iWo != null) {
                                NewSubPbActivity.this.iWo.qR(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.iWm.qS(false);
                        NewSubPbActivity.this.iWm.Gt(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.iWo != null) {
                            NewSubPbActivity.this.iWo.qR(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.iWu = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.iWm.csk() != null && NewSubPbActivity.this.iWm.csk().aAj() != null && NewSubPbActivity.this.iWm.csk().aAj().aCr() != null) {
                    str = String.valueOf(NewSubPbActivity.this.iWm.csk().aAj().aCr().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.iWm.csk().aPr().getId(), NewSubPbActivity.this.iWm.csk().aPr().getName(), NewSubPbActivity.this.iWm.csk().aAj().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.iWv = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.iWn.cMj() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.iWm != null && NewSubPbActivity.this.iWm.csk() != null && NewSubPbActivity.this.iWm.csk().aPr() != null && NewSubPbActivity.this.iWm.csk().aAj() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.iWn.Jg(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.iWn.a(NewSubPbActivity.this.iWm.csk().aPr().getId(), NewSubPbActivity.this.iWm.csk().aPr().getName(), NewSubPbActivity.this.iWm.csk().aAj().getId(), valueOf, i2, i, z, NewSubPbActivity.this.iWm.csk().aAj().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.iWt = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.iWo.a(NewSubPbActivity.this.iWn.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.iWn.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.iXu != 1002 || bVar.eMo) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.iWo.a(1, dVar.mSuccess, dVar.kkW, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean cv(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void initListeners() {
        registerListener(this.gqx);
        this.akE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v65, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray sparseArray;
                if (view != null || NewSubPbActivity.this.iWo != null) {
                    if (view == NewSubPbActivity.this.iWo.csf()) {
                        NewSubPbActivity.this.iWo.cqu();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ba.aGK().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.iWo.bIB()) {
                        if (view != NewSubPbActivity.this.iWo.crY()) {
                            if (view != NewSubPbActivity.this.iWo.crX()) {
                                if (view == NewSubPbActivity.this.iWo.crS()) {
                                    NewSubPbActivity.this.iWo.cqu();
                                    if (NewSubPbActivity.this.iWm.loadData()) {
                                        NewSubPbActivity.this.iWo.crQ();
                                    }
                                } else if (view == NewSubPbActivity.this.iWo.crZ() || view == NewSubPbActivity.this.iWo.csa() || view == NewSubPbActivity.this.iWo.csc()) {
                                    if (NewSubPbActivity.this.iWy) {
                                        NewSubPbActivity.this.iWy = false;
                                        return;
                                    }
                                    if ((NewSubPbActivity.this.iWm.csk() == null || NewSubPbActivity.this.iWm.csk().aAj() == null) ? false : au.a(NewSubPbActivity.this.iWm.csk().aAj().getBaijiahaoData())) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.iWm.cnU(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.iWm.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.iWm.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.iWm.csk() != null && NewSubPbActivity.this.iWm.csk().aAj() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.iWm.csk().aAj().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.iWm.cnU(), NewSubPbActivity.this.iWm.aOT(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.iWm.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.iWm.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.iWo.csd() == null || view != NewSubPbActivity.this.iWo.csd().coS()) {
                                    if (NewSubPbActivity.this.iWo.csd() == null || view != NewSubPbActivity.this.iWo.csd().coV()) {
                                        if (NewSubPbActivity.this.iWo.csd() == null || view != NewSubPbActivity.this.iWo.csd().coT()) {
                                            if (NewSubPbActivity.this.iWo.csd() == null || view != NewSubPbActivity.this.iWo.csd().coU()) {
                                                if (NewSubPbActivity.this.iWo.csd() == null || view != NewSubPbActivity.this.iWo.csd().coW()) {
                                                    if (view == NewSubPbActivity.this.iWo.crW() || view == NewSubPbActivity.this.iWo.csc()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.hRt.aPw()) {
                                                                NewSubPbActivity.this.hRt.aPx();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.hRt.vr(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof k)) {
                                                        if (NewSubPbActivity.this.iWp == null || view != NewSubPbActivity.this.iWp.coU()) {
                                                            if (NewSubPbActivity.this.iWp == null || view != NewSubPbActivity.this.iWp.coS()) {
                                                                if (NewSubPbActivity.this.iWp == null || view != NewSubPbActivity.this.iWp.coV()) {
                                                                    if (NewSubPbActivity.this.iWp == null || view != NewSubPbActivity.this.iWp.coW()) {
                                                                        if (NewSubPbActivity.this.iWp == null || view != NewSubPbActivity.this.iWp.coY()) {
                                                                            if (NewSubPbActivity.this.iWp == null || view != NewSubPbActivity.this.iWp.coZ()) {
                                                                                if (NewSubPbActivity.this.iWp != null && view == NewSubPbActivity.this.iWp.coT()) {
                                                                                    if (!j.isNetWorkAvailable()) {
                                                                                        NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                                                        return;
                                                                                    }
                                                                                    SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                                                                                    if (sparseArray2 != null) {
                                                                                        boolean booleanValue = ((Boolean) sparseArray2.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                        boolean booleanValue2 = ((Boolean) sparseArray2.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                        boolean booleanValue3 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                        if (booleanValue) {
                                                                                            if (booleanValue3) {
                                                                                                sparseArray2.put(R.id.tag_from, 1);
                                                                                                sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                                                                NewSubPbActivity.this.b(sparseArray2);
                                                                                                return;
                                                                                            }
                                                                                            sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                                                            NewSubPbActivity.this.iWo.cA(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.iWo.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                            return;
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                int id = view.getId();
                                                                                if (id == R.id.pb_item_tail_content) {
                                                                                    if (bc.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.aFH().getString("tail_link", "");
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
                                                                                        PostData postData = (PostData) obj;
                                                                                        if (postData.getType() != PostData.kij && !TextUtils.isEmpty(postData.getBimg_url()) && i.azR().isShowImages()) {
                                                                                            NewSubPbActivity.this.Gq(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.iJN != null && !TextUtils.isEmpty(NewSubPbActivity.this.iJO)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.gRU == null) {
                                                                                        NewSubPbActivity.this.gRU = new ar(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.gRU.j(NewSubPbActivity.this.iJO, NewSubPbActivity.this.iJN.getImageByte());
                                                                                    NewSubPbActivity.this.iJN = null;
                                                                                    NewSubPbActivity.this.iJO = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.iJN != null && !TextUtils.isEmpty(NewSubPbActivity.this.iJO)) {
                                                                            if (NewSubPbActivity.this.iJP == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.iJO));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.iJO;
                                                                                aVar.pkgId = NewSubPbActivity.this.iJP.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.iJP.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.iJN = null;
                                                                            NewSubPbActivity.this.iJO = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.hjm != null) {
                                                                        NewSubPbActivity.this.hjm.fu(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.hjm = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.iWo.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.cu(view);
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
                                                                NewSubPbActivity.this.FP((String) tag);
                                                                return;
                                                            } else if (tag instanceof SparseArray) {
                                                                SparseArray<Object> sparseArray4 = (SparseArray) tag;
                                                                if ((sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                                    sparseArray4.put(R.id.tag_from, 0);
                                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                                    NewSubPbActivity.this.b(sparseArray4);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        NewSubPbActivity.this.iWB = (k) view.getTag();
                                                        if (bc.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.iWy) {
                                                                NewSubPbActivity.this.iWy = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.hRk == null || NewSubPbActivity.this.iWm == null || NewSubPbActivity.this.iWm.bDg() == null || NewSubPbActivity.this.hRk.ks(NewSubPbActivity.this.iWm.bDg().replyPrivateFlag)) && (sparseArray = (SparseArray) view.getTag(R.id.tag_from)) != null) {
                                                                if (sparseArray.get(R.id.tag_clip_board) instanceof PostData) {
                                                                    PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                    if (postData2 != null && postData2.aCr() != null) {
                                                                        MetaData aCr = postData2.aCr();
                                                                        NewSubPbActivity.this.hRt.setReplyId(aCr.getUserId());
                                                                        if (!(sparseArray.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue() : true)) {
                                                                            NewSubPbActivity.this.hRt.vs("");
                                                                        } else {
                                                                            NewSubPbActivity.this.hRt.vs(aCr.getName_show());
                                                                        }
                                                                    }
                                                                    NewSubPbActivity.this.iWo.crO();
                                                                }
                                                                if (NewSubPbActivity.this.iWA) {
                                                                    NewSubPbActivity.this.qP(false);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    }
                                                } else if (view.getTag() != null && (view.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                    if (sparseArray5.get(R.id.tag_clip_board) instanceof PostData) {
                                                        ((PostData) sparseArray5.get(R.id.tag_clip_board)).fu(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new an("c11739").X("obj_locate", 4));
                                            if (!j.isNetWorkAvailable()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.iWo.cqu();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.FP(str4);
                                                    return;
                                                }
                                                return;
                                            } else if (tag2 instanceof SparseArray) {
                                                SparseArray<Object> sparseArray6 = (SparseArray) tag2;
                                                if ((sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray6.put(R.id.tag_from, 0);
                                                    sparseArray6.put(R.id.tag_check_mute_from, 2);
                                                    NewSubPbActivity.this.b(sparseArray6);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        } else if (j.isNetWorkAvailable()) {
                                            NewSubPbActivity.this.iWo.cqu();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.cD(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.iWo.cqu();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.iWo.a(((Integer) sparseArray7.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray7.get(R.id.tag_del_post_id), ((Integer) sparseArray7.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new an("c11739").X("obj_locate", 2));
                                    NewSubPbActivity.this.iWo.cqu();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.iWm.csk() != null) {
                                        NewSubPbActivity.this.k(NewSubPbActivity.this.iWm.csk().clB());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.iWo.crN();
                                NewSubPbActivity.this.iWo.crO();
                                if (NewSubPbActivity.this.hRt != null) {
                                    NewSubPbActivity.this.hRt.aPz();
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.iWo.crN();
                            NewSubPbActivity.this.iWo.crO();
                            if (NewSubPbActivity.this.hRt != null) {
                                NewSubPbActivity.this.hRt.aPy();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.cmV();
                        if (NewSubPbActivity.this.iWm != null && NewSubPbActivity.this.iWm.csk() != null && NewSubPbActivity.this.iWm.csk().aAj() != null && NewSubPbActivity.this.iWm.csk().aAj().aCr() != null) {
                            TiebaStatic.log(new an("c13402").cx("tid", NewSubPbActivity.this.iWm.cnU()).s("fid", NewSubPbActivity.this.iWm.csk().aAj().getFid()).X("obj_locate", 5).cx("uid", NewSubPbActivity.this.iWm.csk().aAj().aCr().getUserId()));
                        }
                    }
                }
            }
        };
        this.iWq = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.iWo.cqu();
                    if (NewSubPbActivity.this.iFt != 2 && NewSubPbActivity.this.iFt != 1) {
                        NewSubPbActivity.this.iWo.csh();
                    }
                }
                NewSubPbActivity.this.hRt.aPx();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.iWo.cse();
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
                if (NewSubPbActivity.this.iWo != null && NewSubPbActivity.this.iWo.crV()) {
                    return false;
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null && NewSubPbActivity.this.cv(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.iJN = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.iJO = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.iJN == null || TextUtils.isEmpty(NewSubPbActivity.this.iJO)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.iJP = null;
                        } else {
                            NewSubPbActivity.this.iJP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.iJN = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.iJO = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.iJP = null;
                        } else {
                            NewSubPbActivity.this.iJP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.iJN = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.iJO = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.iJP = null;
                        } else {
                            NewSubPbActivity.this.iJP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.iWo.a(NewSubPbActivity.this.iKx, NewSubPbActivity.this.iJN.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.hjm = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.hjm == null || NewSubPbActivity.this.iJo == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.iJo != null) {
                            NewSubPbActivity.this.iJo.fn(NewSubPbActivity.this.iWm.csq());
                        }
                        boolean z = NewSubPbActivity.this.iJo.ayO() && NewSubPbActivity.this.hjm.getId() != null && NewSubPbActivity.this.hjm.getId().equals(NewSubPbActivity.this.iWm.css());
                        if (NewSubPbActivity.this.iWp == null) {
                            NewSubPbActivity.this.iWp = new w(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.akE);
                            NewSubPbActivity.this.iWo.cE(NewSubPbActivity.this.iWp.getView());
                            NewSubPbActivity.this.iWp.qe(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.iWp.showDialog();
                        boolean z2 = NewSubPbActivity.this.pR(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z3 = (NewSubPbActivity.this.iWm.csk() == null || NewSubPbActivity.this.iWm.csk().aAj() == null || !NewSubPbActivity.this.iWm.csk().aAj().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z) {
                            NewSubPbActivity.this.iWp.coS().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.iWp.coS().setText(R.string.mark);
                        }
                        if (booleanValue || z3) {
                            NewSubPbActivity.this.iWp.coS().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.iWp.coS().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.cv(view)) {
                            if (NewSubPbActivity.this.iJN != null && !NewSubPbActivity.this.iJN.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        NewSubPbActivity.this.iWp.a(sparseArray2, NewSubPbActivity.this.clb(), z2);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.iWr = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                        l csk = NewSubPbActivity.this.iWm.csk();
                        TbRichText bj = NewSubPbActivity.this.bj(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bj != null && bj.aTX() != null) {
                            tbRichTextData = bj.aTX().get(NewSubPbActivity.this.iKu);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.aUd().aUo()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (csk == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (csk.aPr() != null) {
                                        str4 = csk.aPr().getName();
                                        str5 = csk.aPr().getId();
                                    }
                                    if (csk.aAj() != null) {
                                        str6 = csk.aAj().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.iWm.csx() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.iWm.csx();
                                    z6 = NewSubPbActivity.this.iWm.csz();
                                    arrayList2 = NewSubPbActivity.this.iWm.csy();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.getItem(arrayList2, 0));
                                ImageViewerConfig createConfig = new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false);
                                createConfig.setPostId(String.valueOf(bj.getPostId()));
                                createConfig.setThreadData(NewSubPbActivity.this.aAj());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                                return;
                            }
                            NewSubPbActivity.this.iKv = false;
                            String str7 = "";
                            TbRichText cLx = csk.clB().cLx();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(cLx, bj, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (csk == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (csk.aPr() != null) {
                                    str8 = csk.aPr().getName();
                                    str9 = csk.aPr().getId();
                                }
                                if (csk.aAj() != null) {
                                    str10 = csk.aAj().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.iWm.csx() != null) {
                                concurrentHashMap = NewSubPbActivity.this.iWm.csx();
                                z4 = NewSubPbActivity.this.iWm.csz();
                                arrayList = NewSubPbActivity.this.iWm.csy();
                                i2 = a2 + NewSubPbActivity.this.iWm.getOffset();
                            } else {
                                concurrentHashMap = concurrentHashMap3;
                                i2 = a2;
                                z4 = z3;
                                arrayList = arrayList2;
                            }
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(v.getItem(arrayList, i2));
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList4, 0, str8, str9, str2, z4, str7, true, concurrentHashMap, true, false, false);
                            createConfig2.setThreadData(NewSubPbActivity.this.aAj());
                            createConfig2.setPostId(String.valueOf(bj.getPostId()));
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
    public bj aAj() {
        if (this.iWm == null || this.iWm.csk() == null) {
            return null;
        }
        return this.iWm.csk().aAj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            k(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo aUd;
        if (tbRichText == tbRichText2) {
            this.iKv = true;
        }
        if (tbRichText != null && tbRichText.aTX() != null) {
            int size = tbRichText.aTX().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.aTX().get(i6) != null && tbRichText.aTX().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.aTX().get(i6).aUd().getWidth() * equipmentDensity;
                    int height = tbRichText.aTX().get(i6).aUd().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.aTX().get(i6).aUd().aUo()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.aTX().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (aUd = tbRichTextData.aUd()) != null) {
                            String aUq = aUd.aUq();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = aUq;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.iKv) {
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
        if (this.iWp != null) {
            this.iWp.qe(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo aUd = tbRichTextData.aUd();
        if (aUd != null) {
            if (!StringUtils.isNull(aUd.aUn())) {
                return aUd.aUn();
            }
            if (aUd.getHeight() * aUd.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (aUd.getHeight() * aUd.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (aUd.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * aUd.getHeight())));
            } else {
                float width = aUd.getWidth() / aUd.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(aUd.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bj(String str, int i) {
        if (this.iWm == null || this.iWm.csk() == null || str == null || i < 0) {
            return null;
        }
        l csk = this.iWm.csk();
        TbRichText a2 = a(csk.clB(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(csk.clB(), str, i);
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
        TbRichText cLx = postData.cLx();
        if (cLx != null) {
            ArrayList<TbRichTextData> aTX = cLx.aTX();
            int size = aTX.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (aTX.get(i3) != null && aTX.get(i3).getType() == 8) {
                    i2++;
                    if (aTX.get(i3).aUd().aUq().equals(str)) {
                        int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = aTX.get(i3).aUd().getWidth() * equipmentDensity;
                        int height = aTX.get(i3).aUd().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.iKu = i3;
                        return cLx;
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
    public void cmV() {
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false) {
            if (this.hRk == null || this.iWm == null || this.iWm.bDg() == null || this.hRk.ks(this.iWm.bDg().replyPrivateFlag)) {
                if (this.hRt.aPm()) {
                    this.hRt.a((PostWriteCallBackData) null);
                    return;
                }
                this.iWo.crN();
                this.iWo.crO();
                if (this.hRt != null) {
                    this.hRt.aPA();
                    return;
                }
                return;
            }
            return;
        }
        if (this.gsJ == null) {
            this.gsJ = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.gsJ.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lC(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void t(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lD(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.hRk == null || NewSubPbActivity.this.iWm == null || NewSubPbActivity.this.iWm.bDg() == null || NewSubPbActivity.this.hRk.ks(NewSubPbActivity.this.iWm.bDg().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.hRt.aPm()) {
                                NewSubPbActivity.this.hRt.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.iWo.crN();
                            NewSubPbActivity.this.iWo.crO();
                            if (NewSubPbActivity.this.hRt != null) {
                                NewSubPbActivity.this.hRt.aPA();
                            }
                        }
                    }
                }
            });
        }
        if (this.iWm != null && this.iWm.csk() != null && this.iWm.csk().aPr() != null) {
            this.gsJ.C(this.iWm.csk().aPr().getId(), com.baidu.adp.lib.f.b.toLong(this.iWm.cnU(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pR(boolean z) {
        if (this.iWm == null) {
            return false;
        }
        return ((clb() != 0) || this.iWm.csk() == null || this.iWm.csk().aAj() == null || this.iWm.csk().aAj().aCr() == null || this.iWm.csk().aAj().aEm() || TextUtils.equals(this.iWm.csk().aAj().aCr().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(int i, String str) {
        if (this.iWm.csl()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.isNetOk()) {
            if (i == 4) {
                this.iWo.zO(str + "(4)");
            } else {
                this.iWo.ww(R.string.no_data_text);
            }
        } else {
            this.iWo.ww(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void op(boolean z) {
        this.hRt = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dU(getActivity());
        if (this.hRt != null) {
            this.hRt.a(getPageContext());
            this.hRt.b(this.iWm);
            this.hRt.b(this.hiK);
            this.hRt.a(this.dyT);
            this.hRt.a(this.dyU);
            this.hRt.aOy().gC(true);
            this.hRt.g(getPageContext());
        }
        if (this.iWo != null) {
            this.iWo.i(this.hRt);
        }
        if (this.hRt != null && this.iWm != null) {
            this.hRt.a(this.iWm.bDg());
            this.hRt.aPx();
        }
        if (this.hRt != null) {
            this.hRt.aPB().setDefaultHint(cpI());
            this.hRt.aPB().setHint(cpI());
            this.hiE = this.hRt.aPB().getInputView();
            this.hiE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.hiD != null) {
                        if (!NewSubPbActivity.this.hiD.cUA()) {
                            NewSubPbActivity.this.mV(false);
                        }
                        NewSubPbActivity.this.hiD.tO(false);
                    }
                }
            });
        }
    }

    public void crK() {
        if (!TbadkCoreApplication.isLogin()) {
            this.hRt.aPx();
        } else if (!StringUtils.isNull(this.iWm.cst())) {
            if (this.iWo.crR() && com.baidu.adp.lib.util.l.isNetOk()) {
                this.iWo.bBj();
            } else {
                this.iWo.crU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(R.id.tag_from, 1);
                    b(sparseArray);
                } else {
                    this.iWo.cA(view);
                }
            } else if (booleanValue2) {
                this.iWo.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.iWo.csb(), getPageContext().getPageActivity());
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
            bVar.ka(R.string.operation);
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.iWx);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.iWx);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).aEH();
        }
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.iWo.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.iWx;
        userMuteCheckCustomMessage.setTag(this.iWx);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.iWo.a(0, bVar.mSuccess, bVar.kkW, z);
            if (bVar.mSuccess) {
                if (bVar.fYS == 1) {
                    if (this.iWo.getListView() instanceof BdTypeListView) {
                        List<com.baidu.adp.widget.ListView.m> data = ((BdTypeListView) this.iWo.getListView()).getData();
                        if (!v.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.iWo.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.fYS == 2) {
                    this.iWm.Gs(bVar.mPostId);
                    this.iWo.a(this.iWm.csk(), this.iWm.clb(), this.iWm.csx() != null);
                    if (this.iWm.csu()) {
                        this.iWm.qT(false);
                        this.iWo.crP();
                        this.iWm.loadData();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void FP(String str) {
        if (this.iWm != null && this.iWm.csk() != null && this.iWm.csk().aAj() != null && this.iWm.csk().aAj().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.iWm.cnU(), str);
            bj aAj = this.iWm.csk().aAj();
            if (aAj.aBg()) {
                format = format + "&channelid=33833";
            } else if (aAj.aEj()) {
                format = format + "&channelid=33842";
            } else if (aAj.aBh()) {
                format = format + "&channelid=33840";
            }
            FQ(format);
            return;
        }
        this.iJn.Gp(str);
    }

    private void FQ(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void k(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.iWm.csq() && postData.getId() != null && postData.getId().equals(this.iWm.css())) {
                z = true;
            }
            MarkData l = this.iWm.l(postData);
            if (l != null) {
                this.iWo.cqu();
                if (this.iJo != null) {
                    this.iJo.a(l);
                    if (!z) {
                        this.iJo.ayQ();
                    } else {
                        this.iJo.ayP();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.iWm != null) {
            this.iWm.au(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.hRt != null) {
            this.hRt.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.hRt.aOy().aMV();
        this.hRt.aPx();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.hRt.b(writeData);
                this.hRt.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l mr = this.hRt.aOy().mr(6);
                if (mr != null && mr.dxa != null) {
                    mr.dxa.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.hRt.aPt();
                }
                this.iWo.csh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gpi != null) {
            this.gpi.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.eeW = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.axC().axH();
        if (this.gpi != null) {
            this.gpi.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.hvk);
        this.iWo.bKD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eeW = false;
        super.onResume();
        cnA();
        if (this.gpi != null) {
            this.gpi.onResume(getPageContext());
        }
        registerListener(this.hvk);
        this.iWo.bKE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gpi != null) {
            this.gpi.onStop(getPageContext());
        }
        this.hRt.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.iWz));
        this.iWm.cancelLoadData();
        this.iWm.destory();
        this.iWn.cancelLoadData();
        if (this.gpi != null) {
            this.gpi.onDestory(getPageContext());
        }
        this.iWo.cqu();
        this.iWo.aiL();
        MessageManager.getInstance().unRegisterListener(this.iKj);
        MessageManager.getInstance().unRegisterListener(this.iKk);
        MessageManager.getInstance().unRegisterListener(this.iKl);
        MessageManager.getInstance().unRegisterListener(this.iWx);
        this.iJJ = null;
        this.iJK = null;
        if (this.hRk != null) {
            this.hRk.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iWo.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gpi;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View crW = this.iWo.crW();
        if (crW == null || (findViewWithTag = crW.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Gi(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = ba.getParamPair(ba.getParamStr(str))) != null) {
            this.iWy = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Gi(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(iWl);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void e(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (Gi(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                    lVar.mLink = str;
                    lVar.type = 3;
                    lVar.dwd = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
                }
            } else {
                ba.aGK().b(getPageContext(), new String[]{str});
            }
            this.iWy = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aC(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iWy = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aD(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void r(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        if (this.iWo != null) {
            return this.iWo.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int aUE() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> aUG() {
        if (this.dPF == null) {
            this.dPF = TbRichTextView.z(getPageContext().getPageActivity(), 8);
        }
        return this.dPF;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> aUH() {
        if (this.dMR == null) {
            this.dMR = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bHp */
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
        return this.dMR;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> aUF() {
        if (this.dMQ == null) {
            this.dMQ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aUR */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.azR().isShowImages();
                    foreDrawableImageView.setDefaultBg(am.getDrawable(R.color.common_color_10220));
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
                        if (i.azR().isShowImages()) {
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
        return this.dMQ;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> aUI() {
        if (this.dPG == null) {
            this.dPG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnH */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(NewSubPbActivity.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cw */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cx */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cy */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.dPG;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> aUJ() {
        if (this.dPH == null) {
            this.dPH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnJ */
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
                /* renamed from: c */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.dPH;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> aUK() {
        this.dPI = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cnI */
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
        return this.dPI;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a clM() {
        return this.iFX;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean clN() {
        return (this.iWm == null || this.iWm.csk() == null || this.iWm.csk().aAj() == null || this.iWm.csk().aAj().aDK()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String clO() {
        if (this.iWm == null || this.iWm.csk() == null || this.iWm.csk().aAj() == null) {
            return null;
        }
        return this.iWm.csk().aAj().aCw();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int clP() {
        if (this.iWm == null) {
            return 0;
        }
        return this.iWm.clb();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean FK(String str) {
        if (StringUtils.isNull(str) || this.iWm == null || this.iWm.csk() == null || this.iWm.csk().aAj() == null || this.iWm.csk().aAj().aCr() == null) {
            return false;
        }
        return str.equals(this.iWm.csk().aAj().aCr().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.iWo.crR() && com.baidu.adp.lib.util.l.isNetOk()) {
            this.iWm.loadData();
        } else {
            this.iWo.crU();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.iWx);
        userMuteAddAndDelCustomMessage.setTag(this.iWx);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gq(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aFH().getString("bubble_link", "");
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
    public void aG(Context context, String str) {
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
                return com.baidu.tbadk.m.e.aRc().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.iWm != null) {
            if (this.iWm.csk() != null && this.iWm.csk().aPr() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.iWm.csk().aPr().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.iWm.cnU(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.eeW;
    }

    public boolean crL() {
        if (this.iWm != null) {
            return this.iWm.crL();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.iWo.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iJJ.getPageActivity());
        if (aq.isEmpty(str)) {
            aVar.sR(this.iJJ.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.sR(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.iWo.showLoadingDialog();
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
        aVar.b(this.iJJ).aEG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vq(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iJJ.getPageActivity());
        aVar.sR(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.iJJ).aEG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.sR(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.iJJ).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.iJJ.getPageActivity(), 2, true, 4);
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
        aVar.b(this.iJJ).aEG();
    }

    public SubPbModel crM() {
        return this.iWm;
    }

    public int clb() {
        if (this.iWm != null) {
            return this.iWm.clb();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.dxw && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.dxw && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void mV(boolean z) {
        if (this.hiE != null && this.hiE.getText() != null) {
            int selectionEnd = this.hiE.getSelectionEnd();
            SpannableStringBuilder a2 = this.hiD.a(this.hiE.getText());
            if (a2 != null) {
                this.hiD.tO(true);
                this.hiE.setText(a2);
                if (z && this.hiD.cUy() >= 0) {
                    this.hiE.requestFocus();
                    this.hiE.setSelection(this.hiD.cUy());
                } else {
                    this.hiE.setSelection(selectionEnd);
                }
                this.hiD.tN(this.hiD.cUy() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hRt != null && this.hRt.aOy() != null && this.hRt.aOy().aOA()) {
            this.hRt.aOy().aMV();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.d.a(pVar, getUniqueId(), this);
    }

    public String cpI() {
        if (!aq.isEmpty(this.iRg)) {
            return this.iRg;
        }
        this.iRg = getResources().getString(com.baidu.tieba.pb.pb.main.am.cpx());
        return this.iRg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.iWA = z;
        qP(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qP(boolean z) {
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
        if (this.iWo != null && this.iWo.getListView() != null && this.iWB != null && this.iWB.mPosition != -1) {
            final int headerViewsCount = this.iWB.mPosition + this.iWo.getListView().getHeaderViewsCount();
            if (this.iWB.getView() != null) {
                final int height = this.iWB.getView().getHeight() - ((rect.height() - this.iWo.getNavigationBarHeight()) - this.iWo.csg());
                if (height > 0) {
                    this.iWo.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.iWo != null && NewSubPbActivity.this.iWo.getListView() != null) {
                                NewSubPbActivity.this.iWo.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.iWo.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.iWo.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.iWo != null && NewSubPbActivity.this.iWo.getListView() != null) {
                                NewSubPbActivity.this.iWo.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.iWo.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }

    private void cnA() {
        if (this.iWm != null && !aq.isEmpty(this.iWm.cnU())) {
            com.baidu.tbadk.BdToken.c.axC().o(com.baidu.tbadk.BdToken.b.cGX, com.baidu.adp.lib.f.b.toLong(this.iWm.cnU(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.iWm == null || aq.isEmpty(this.iWm.cnU())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.iWm.cnU(), 0L);
    }
}
