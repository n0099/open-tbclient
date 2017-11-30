package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.content.Intent;
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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
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
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.h;
import com.baidu.tbadk.editortools.pb.i;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.pb.pb.sub.b;
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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.e {
    private static final String feQ = com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String fgn = "tbgametype";
    private com.baidu.adp.lib.e.b<GifView> aVA;
    private com.baidu.adp.lib.e.b<ImageView> aVv;
    private com.baidu.adp.lib.e.b<TextView> aVw;
    private com.baidu.adp.lib.e.b<View> aVx;
    private com.baidu.adp.lib.e.b<LinearLayout> aVy;
    private com.baidu.adp.lib.e.b<RelativeLayout> aVz;
    private View.OnLongClickListener avA;
    private VoiceManager cGZ;
    private h dZX;
    private com.baidu.adp.base.e eSI;
    private com.baidu.tbadk.core.view.c eSJ;
    private b.InterfaceC0047b eTx;
    private PostWriteCallBackData eWx;
    private com.baidu.tbadk.baseEditMark.a etk;
    private EditText fdE;
    private BdUniqueId fgA;
    private b fgC;
    private com.baidu.tieba.write.b fgD;
    private com.baidu.tieba.pb.e<m> fgE;
    private SubPbModel fgo;
    private ForumManageModel fgp;
    private c fgq;
    private AbsListView.OnScrollListener fgr;
    private TbRichTextView.g fgs;
    private TbRichTextView.f fgt;
    private SubPbModel.a fgu;
    private com.baidu.adp.base.d fgv;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int eTu = 0;
    private a.InterfaceC0043a eTq = null;
    private a fgw = null;
    private a fgx = null;
    private boolean fgy = false;
    private boolean fgz = false;
    private boolean fgB = false;
    private boolean aCl = false;
    private com.baidu.tbadk.editortools.pb.c aDG = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void DA() {
            NewSubPbActivity.this.fgq.aXu();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aDH = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Dz() {
            if (NewSubPbActivity.this.fgD.bEU()) {
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.fgD.bEW());
                if (NewSubPbActivity.this.dZX.DP()) {
                    NewSubPbActivity.this.dZX.a(NewSubPbActivity.this.eWx);
                }
                NewSubPbActivity.this.kl(true);
                return true;
            }
            return false;
        }
    };
    private NewWriteModel.d fgF = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.dZX != null && NewSubPbActivity.this.dZX.Dd() != null) {
                NewSubPbActivity.this.dZX.Dd().hide();
                if (NewSubPbActivity.this.fgo.aXP()) {
                    TiebaStatic.log(new ak("c10367").ac("post_id", NewSubPbActivity.this.fgo.Dx()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fgD.uw(null);
                NewSubPbActivity.this.fgD.aB(null);
                NewSubPbActivity.this.fgD.nS(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fgD.aB(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fgD.uw(postWriteCallBackData.getErrorString());
                if (!v.w(NewSubPbActivity.this.fgD.bES())) {
                    NewSubPbActivity.this.eWx = postWriteCallBackData;
                    if (NewSubPbActivity.this.dZX.DP()) {
                        NewSubPbActivity.this.dZX.a(NewSubPbActivity.this.eWx);
                    }
                    NewSubPbActivity.this.kl(true);
                } else {
                    return;
                }
            }
            NewSubPbActivity.this.fgq.aXv();
        }
    };
    private CustomMessageListener eTj = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fgA) {
                NewSubPbActivity.this.fgq.XB();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eSJ.c(NewSubPbActivity.this.eSI.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.eSI.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.gd(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.aTr();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (am.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.eSI.getResources().getString(d.j.mute_fail);
                    }
                    NewSubPbActivity.this.eSJ.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eTk = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fgA) {
                NewSubPbActivity.this.fgq.XB();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eSJ.c(NewSubPbActivity.this.eSI.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (am.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.eSI.getResources().getString(d.j.un_mute_fail);
                }
                NewSubPbActivity.this.eSJ.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eTl = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fgA) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.fgq.XB();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.gML;
                if (aVar.error == 0 && dataRes != null) {
                    boolean z2 = com.baidu.adp.lib.g.b.g(dataRes.is_mute, 0) == 1;
                    sparseArray.put(d.g.tag_user_mute_visible, true);
                    sparseArray.put(d.g.tag_user_mute_msg, dataRes.mute_confirm);
                    z = z2;
                } else {
                    sparseArray.put(d.g.tag_user_mute_visible, false);
                    z = false;
                }
                int intValue = sparseArray.get(d.g.tag_from) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_from)).intValue() : 0;
                if (intValue == 0) {
                    NewSubPbActivity.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    NewSubPbActivity.this.fgq.a(sparseArray, z);
                }
            }
        }
    };
    boolean eTv = false;
    private CustomMessageListener dDN = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener cHU = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    k kVar = (k) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.fgo.aXI() != null && NewSubPbActivity.this.fgo.aXI().aRT() != null && NewSubPbActivity.this.fgo.aXI().aRT().rx() != null && currentAccount.equals(NewSubPbActivity.this.fgo.aXI().aRT().rx().getUserId()) && NewSubPbActivity.this.fgo.aXI().aRT().rx().getPendantData() != null) {
                        NewSubPbActivity.this.fgo.aXI().aRT().rx().getPendantData().cF(kVar.pT());
                        NewSubPbActivity.this.fgo.aXI().aRT().rx().getPendantData().T(kVar.CE());
                        NewSubPbActivity.this.fgq.a(NewSubPbActivity.this.fgo.aXI().aRT(), NewSubPbActivity.this.fgo.aXI().aCu(), NewSubPbActivity.this.fgo.aXI().nJ(), NewSubPbActivity.this.fgo.aRs(), NewSubPbActivity.this.fgo.aXY() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void f(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        v(bundle);
        if (this.aCl) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.eSI = getPageContext();
        this.fgz = true;
        this.fgD = new com.baidu.tieba.write.b();
        this.fgD.vB(d.C0082d.cp_cont_h_alpha85);
        this.fgD.vA(d.C0082d.cp_cont_i);
        aoQ();
        aXk();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.fgo.aXm()) {
            this.fgC = new b(this, getListView(), this.fgq.alu());
            this.fgC.aoV();
            this.fgC.a(new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                private boolean cVq = false;

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void aoR() {
                    NewSubPbActivity.this.fgq.fw(false);
                    this.cVq = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void aoS() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public boolean aoT() {
                    if (!this.cVq) {
                        return NewSubPbActivity.this.fgq.aph() != null && NewSubPbActivity.this.fgq.aph().getTop() == 0;
                    }
                    this.cVq = false;
                    return false;
                }
            });
            this.fgq.e(this.fgC);
            this.fgq.fw(true);
        }
        this.eSJ = new com.baidu.tbadk.core.view.c();
        this.eSJ.alo = 1000L;
        registerListener(this.eTl);
        registerListener(this.eTj);
        registerListener(this.eTk);
        this.fgA = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fgA;
        userMuteAddAndDelCustomMessage.setTag(this.fgA);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.fgA;
        userMuteCheckCustomMessage.setTag(this.fgA);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.fgq = new c(this, this.mCommonClickListener);
        this.fgq.a(this.fgo);
        addContentView(this.fgq.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.fgq.setOnScrollListener(this.fgr);
        this.fgq.a(this);
        this.fgq.setOnLinkImageClickListener(this.fgs);
        this.fgq.setOnImageClickListener(this.fgt);
        this.fgq.iX(true);
        this.fgq.setOnLongClickListener(this.avA);
        this.fgq.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.fgo != null) {
                    NewSubPbActivity.this.fgo.Fy();
                }
            }
        });
        this.fgq.a(this.fgw);
        this.fgq.b(this.fgx);
        if (this.fgo != null && this.fgo.aXm() && !this.fgo.aXX()) {
            this.fgq.aXz().setVisibility(8);
        } else {
            this.fgq.aXz().setVisibility(0);
        }
        if (this.fgo != null && !this.fgo.aXm()) {
            this.fgq.setIsFromPb(false);
        }
    }

    private boolean v(Bundle bundle) {
        if (bundle != null) {
            this.aCl = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.aCl = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.aCl;
    }

    public void initData(Bundle bundle) {
        this.fgo = new SubPbModel(getPageContext());
        this.fgo.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.fgq.n(postData);
                NewSubPbActivity.this.fgq.a((BdListView.e) null);
            }
        });
        this.fgp = new ForumManageModel(this);
        this.fgp.setLoadDataCallBack(this.fgv);
        this.cGZ = new VoiceManager();
        this.cGZ.onCreate(getPageContext());
        this.etk = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.etk != null) {
            this.etk.a(this.eTq);
        }
        if (bundle != null) {
            this.fgo.initWithBundle(bundle);
        } else {
            this.fgo.initWithIntent(getIntent());
        }
        this.fgo.a(this.fgu);
        if (this.fgo.aXm()) {
            this.fgo.Fy();
        } else {
            this.fgo.aXN();
        }
    }

    public void aXk() {
        this.fgu = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, m mVar) {
                if (NewSubPbActivity.this.fgq != null) {
                    NewSubPbActivity.this.fgq.aXv();
                }
                if (NewSubPbActivity.this.fgC != null && NewSubPbActivity.this.fgC.aoW()) {
                    NewSubPbActivity.this.fgC.kA(d.C0082d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.X(i, str);
                    return;
                }
                NewSubPbActivity.this.fgq.hideNoDataView();
                if (mVar != null) {
                    if (mVar.aRT() != null || NewSubPbActivity.this.fgo != null) {
                        mVar.aRT().a(NewSubPbActivity.this.fgo.aXW());
                    }
                    if (NewSubPbActivity.this.fgq != null) {
                        NewSubPbActivity.this.fgq.a(mVar, NewSubPbActivity.this.fgo.aRs(), NewSubPbActivity.this.fgo.aXY() != null);
                        if (NewSubPbActivity.this.fgz) {
                            NewSubPbActivity.this.aXl();
                            NewSubPbActivity.this.fgz = false;
                        }
                    }
                    if (NewSubPbActivity.this.dZX != null) {
                        NewSubPbActivity.this.dZX.a(mVar.aSb());
                    }
                    if (NewSubPbActivity.this.fgE == null) {
                        NewSubPbActivity.this.fgE = new com.baidu.tieba.pb.e();
                    }
                    NewSubPbActivity.this.fgE.setData(mVar);
                    NewSubPbActivity.this.fgE.setType(0);
                }
            }
        };
        this.eTq = new a.InterfaceC0043a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0043a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.etk != null) {
                        NewSubPbActivity.this.etk.ab(z2);
                    }
                    MarkData nM = NewSubPbActivity.this.etk.nM();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(nM);
                        if (NewSubPbActivity.this.etk != null) {
                            if (nM != null) {
                                NewSubPbActivity.this.fgo.kp(true);
                                NewSubPbActivity.this.fgo.qj(NewSubPbActivity.this.fgo.Dx());
                                NewSubPbActivity.this.showToast(d.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.add_mark));
                            }
                            if (NewSubPbActivity.this.fgq != null) {
                                NewSubPbActivity.this.fgq.km(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.fgo.kp(false);
                        NewSubPbActivity.this.fgo.qj(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.remove_mark));
                        if (NewSubPbActivity.this.fgq != null) {
                            NewSubPbActivity.this.fgq.km(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.update_mark_failed));
            }
        };
        this.fgw = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.fgo.aXI() != null && NewSubPbActivity.this.fgo.aXI().Ox() != null && NewSubPbActivity.this.fgo.aXI().Ox().rx() != null) {
                    str = String.valueOf(NewSubPbActivity.this.fgo.aXI().Ox().rx().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.fgo.aXI().aSa().getId(), NewSubPbActivity.this.fgo.aXI().aSa().getName(), NewSubPbActivity.this.fgo.aXI().Ox().getId(), str, str2, str3)));
            }
        };
        this.fgx = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.fgp.bxc() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.fgo != null && NewSubPbActivity.this.fgo.aXI() != null && NewSubPbActivity.this.fgo.aXI().aSa() != null && NewSubPbActivity.this.fgo.aXI().Ox() != null) {
                            NewSubPbActivity.this.fgp.a(NewSubPbActivity.this.fgo.aXI().aSa().getId(), NewSubPbActivity.this.fgo.aXI().aSa().getName(), NewSubPbActivity.this.fgo.aXI().Ox().getId(), valueOf, g2, g, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.j.login_to_use), true, 11017)));
            }
        };
        this.fgv = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = true;
                if (obj == null) {
                    NewSubPbActivity.this.fgq.a(NewSubPbActivity.this.fgp.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.fgp.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.djA && bVar.fhq > 0 && bVar.gBx != 1 && bVar.fhq != 1002) {
                            com.baidu.tieba.c.a.a(NewSubPbActivity.this.getPageContext(), 3, 1);
                            z = false;
                        }
                        if (bVar.fhq == 1002 && !bVar.djA) {
                            z = false;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.fgq.a(1, dVar.Al, dVar.gBz, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void aoQ() {
        registerListener(this.cHU);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.fgq != null) {
                    if (view == NewSubPbActivity.this.fgq.aXF()) {
                        NewSubPbActivity.this.fgq.aWo();
                        String str = view.getTag(d.g.tag_user_id) instanceof String ? (String) view.getTag(d.g.tag_user_id) : null;
                        String str2 = view.getTag(d.g.tag_user_name) instanceof String ? (String) view.getTag(d.g.tag_user_name) : null;
                        String str3 = view.getTag(d.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(d.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                av.vL().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.fgq.api()) {
                        if (view != NewSubPbActivity.this.fgq.aXy()) {
                            if (view != NewSubPbActivity.this.fgq.aXx()) {
                                if (view == NewSubPbActivity.this.fgq.aXt()) {
                                    NewSubPbActivity.this.fgq.aWo();
                                    if (NewSubPbActivity.this.fgo.Fy()) {
                                        NewSubPbActivity.this.fgq.aXr();
                                    }
                                } else if (view == NewSubPbActivity.this.fgq.aXz() || view == NewSubPbActivity.this.fgq.aXA() || view == NewSubPbActivity.this.fgq.aXC()) {
                                    if (NewSubPbActivity.this.fgB) {
                                        NewSubPbActivity.this.fgB = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.fgo.aUe(), NewSubPbActivity.this.fgo.Dx(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.fgo.aYb())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.fgo.aYb());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                } else if (NewSubPbActivity.this.fgq.aXD() == null || view != NewSubPbActivity.this.fgq.aXD().aUR()) {
                                    if (NewSubPbActivity.this.fgq.aXD() == null || view != NewSubPbActivity.this.fgq.aXD().aUW()) {
                                        if (NewSubPbActivity.this.fgq.aXD() == null || view != NewSubPbActivity.this.fgq.aXD().aUU()) {
                                            if (NewSubPbActivity.this.fgq.aXD() == null || view != NewSubPbActivity.this.fgq.aXD().aUS()) {
                                                if (NewSubPbActivity.this.fgq.aXD() == null || view != NewSubPbActivity.this.fgq.aXD().aUT()) {
                                                    if ((view == NewSubPbActivity.this.fgq.aXw() || view == NewSubPbActivity.this.fgq.aXC()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.dZX.DY()) {
                                                            NewSubPbActivity.this.dZX.DZ();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.dZX.ge(null);
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                                TiebaStatic.log(new ak("c11739").r("obj_locate", 4));
                                                if (!j.hh()) {
                                                    NewSubPbActivity.this.showToast(d.j.network_not_available);
                                                    return;
                                                }
                                                Object tag = view.getTag();
                                                NewSubPbActivity.this.fgq.aWo();
                                                if (tag instanceof String) {
                                                    String Dx = NewSubPbActivity.this.fgo.Dx();
                                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                        NewSubPbActivity.this.pJ(Dx);
                                                        return;
                                                    }
                                                    return;
                                                } else if (tag instanceof SparseArray) {
                                                    SparseArray<Object> sparseArray = (SparseArray) tag;
                                                    if ((sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue()) {
                                                        sparseArray.put(d.g.tag_from, 0);
                                                        NewSubPbActivity.this.c(sparseArray);
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else if (j.hh()) {
                                                NewSubPbActivity.this.fgq.aWo();
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.bm(view);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                NewSubPbActivity.this.showToast(d.j.network_not_available);
                                                return;
                                            }
                                        }
                                        NewSubPbActivity.this.fgq.aWo();
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.fgq.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new ak("c11739").r("obj_locate", 1));
                                    NewSubPbActivity.this.fgq.aWo();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.dZX.ge(null);
                                        if (NewSubPbActivity.this.fgC != null) {
                                            NewSubPbActivity.this.fgC.aoU();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new ak("c11739").r("obj_locate", 2));
                                    NewSubPbActivity.this.fgq.aWo();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.fgo.aXI() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.fgo.aXI().aRT());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.fgq.aXo();
                                NewSubPbActivity.this.fgq.aXp();
                                if (NewSubPbActivity.this.dZX != null) {
                                    NewSubPbActivity.this.dZX.Eb();
                                    if (NewSubPbActivity.this.fgC != null) {
                                        NewSubPbActivity.this.fgC.aoU();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.fgq.aXo();
                            NewSubPbActivity.this.fgq.aXp();
                            if (NewSubPbActivity.this.dZX != null) {
                                NewSubPbActivity.this.dZX.Ea();
                                if (NewSubPbActivity.this.fgC != null) {
                                    NewSubPbActivity.this.fgC.aoU();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.dZX.DP()) {
                            NewSubPbActivity.this.dZX.a((PostWriteCallBackData) null);
                            return;
                        }
                        NewSubPbActivity.this.fgq.aXo();
                        NewSubPbActivity.this.fgq.aXp();
                        if (NewSubPbActivity.this.dZX != null) {
                            NewSubPbActivity.this.dZX.Ec();
                            if (NewSubPbActivity.this.fgC != null) {
                                NewSubPbActivity.this.fgC.aoU();
                            }
                        }
                    }
                }
            }
        };
        this.fgr = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.fgq.aWo();
                }
                NewSubPbActivity.this.dZX.DZ();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.fgq.aXE();
            }
        };
        this.eTx = new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.fgo.aXI() != null) {
                    postData = NewSubPbActivity.this.fgo.aXI().aRT();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.ce(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.f(postData);
                    }
                }
            }
        };
        this.avA = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SparseArray sparseArray;
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    NewSubPbActivity.this.fgq.b(NewSubPbActivity.this.eTx, NewSubPbActivity.this.fgo.isMarked());
                }
                return true;
            }
        };
        this.fgs = new TbRichTextView.g() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
            public void b(View view, String str) {
                NewSubPbActivity.this.j(null, str, "LINK_IMAGE");
            }
        };
        this.fgt = new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            /* JADX DEBUG: Multi-variable search result rejected for r2v17, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX DEBUG: Multi-variable search result rejected for r2v42, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void a(View view, String str, int i) {
                String str2;
                boolean z;
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap;
                int i2;
                boolean z2;
                ArrayList<String> arrayList;
                String str3;
                boolean z3;
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2;
                boolean z4;
                try {
                    m aXI = NewSubPbActivity.this.fgo.aXI();
                    TbRichText at = NewSubPbActivity.this.at(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (at != null && at.Jq() != null) {
                        tbRichTextData = at.Jq().get(NewSubPbActivity.this.eTu);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.Jw().JI()) {
                            String b = NewSubPbActivity.this.b(tbRichTextData);
                            arrayList2.add(b);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                            concurrentHashMap3.put(b, imageUrlData);
                            String str4 = null;
                            String str5 = null;
                            String str6 = null;
                            if (aXI == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (aXI.aSa() != null) {
                                    str4 = aXI.aSa().getName();
                                    str5 = aXI.aSa().getId();
                                }
                                if (aXI.Ox() != null) {
                                    str6 = aXI.Ox().getId();
                                }
                                str3 = str6;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.fgo.aXY() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.fgo.aXY();
                                z4 = NewSubPbActivity.this.fgo.aYa();
                                arrayList2 = NewSubPbActivity.this.fgo.aXZ();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z4 = z3;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(v.c(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z4, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.eTv = false;
                        String str7 = "";
                        TbRichText bwr = aXI.aRT().bwr();
                        int size = arrayList2.size();
                        int a2 = NewSubPbActivity.this.a(bwr, at, i, i, arrayList2, concurrentHashMap3);
                        int size2 = arrayList2.size();
                        if (size != size2) {
                            str7 = arrayList2.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (aXI == null) {
                            str2 = null;
                            z = false;
                        } else {
                            if (aXI.aSa() != null) {
                                str8 = aXI.aSa().getName();
                                str9 = aXI.aSa().getId();
                            }
                            if (aXI.Ox() != null) {
                                str10 = aXI.Ox().getId();
                            }
                            str2 = str10;
                            z = true;
                        }
                        if (NewSubPbActivity.this.fgo.aXY() != null) {
                            concurrentHashMap = NewSubPbActivity.this.fgo.aXY();
                            z2 = NewSubPbActivity.this.fgo.aYa();
                            arrayList = NewSubPbActivity.this.fgo.aXZ();
                            i2 = a2 + NewSubPbActivity.this.fgo.getOffset();
                        } else {
                            concurrentHashMap = concurrentHashMap3;
                            i2 = a2;
                            z2 = z;
                            arrayList = arrayList2;
                        }
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.add(v.c(arrayList, i2));
                        NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList4, 0, str8, str9, str2, z2, str7, true, concurrentHashMap, true, false, false)));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo Jw;
        if (tbRichText == tbRichText2) {
            this.eTv = true;
        }
        if (tbRichText != null && tbRichText.Jq() != null) {
            int size = tbRichText.Jq().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Jq().get(i6) != null && tbRichText.Jq().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.Jq().get(i6).Jw().getWidth();
                    int height = tbRichText.Jq().get(i6).Jw().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Jq().get(i6).Jw().JI()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Jq().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (Jw = tbRichTextData.Jw()) != null) {
                            String JK = Jw.JK();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = JK;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.eTv) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo Jw = tbRichTextData.Jw();
        if (Jw != null) {
            if (!StringUtils.isNull(Jw.JH())) {
                return Jw.JH();
            }
            if (Jw.getHeight() * Jw.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Jw.getHeight() * Jw.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Jw.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Jw.getHeight())));
            } else {
                float width = Jw.getWidth() / Jw.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aN(Jw.JJ()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText at(String str, int i) {
        if (this.fgo == null || this.fgo.aXI() == null || str == null || i < 0) {
            return null;
        }
        m aXI = this.fgo.aXI();
        TbRichText a2 = a(aXI.aRT(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(aXI.aRT(), str, i);
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
        TbRichText bwr = postData.bwr();
        if (bwr != null) {
            ArrayList<TbRichTextData> Jq = bwr.Jq();
            int size = Jq.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Jq.get(i3) != null && Jq.get(i3).getType() == 8) {
                    i2++;
                    if (Jq.get(i3).Jw().JK().equals(str)) {
                        int width = Jq.get(i3).Jw().getWidth();
                        int height = Jq.get(i3).Jw().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.eTu = i3;
                        return bwr;
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
    public void j(Context context, String str, String str2) {
        long templateId = this.fgo.aXI().aRT().bwx() != null ? this.fgo.aXI().aRT().bwx().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && av.vL().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.fgo.aXI().aSa().getId(), this.fgo.aXI().aSa().getName(), this.fgo.aXI().Ox().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i, String str) {
        if (this.fgo.aXJ()) {
            showToast(str);
        } else if (l.hy()) {
            if (i == 4) {
                this.fgq.lm(str + "(4)");
            } else {
                this.fgq.gV(d.j.no_data_text);
            }
        } else {
            this.fgq.gV(d.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.dZX = (h) new i().aY(getActivity());
        if (this.dZX != null) {
            this.dZX.a(getPageContext());
            this.dZX.b(this.fgo);
            this.dZX.b(this.fgF);
            this.dZX.a(this.aDG);
            this.dZX.a(this.aDH);
            this.dZX.Dd().bx(true);
            this.dZX.e(getPageContext());
        }
        if (this.fgq != null) {
            this.fgq.g(this.dZX);
        }
        if (this.dZX != null && this.fgo != null) {
            this.dZX.a(this.fgo.aSb());
            this.dZX.DZ();
        }
        if (this.dZX != null) {
            this.fdE = this.dZX.Ed().getInputView();
            this.fdE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.fgD != null) {
                        if (!NewSubPbActivity.this.fgD.bEV()) {
                            NewSubPbActivity.this.kl(false);
                        }
                        NewSubPbActivity.this.fgD.nT(false);
                    }
                }
            });
        }
    }

    public void aXl() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dZX.DZ();
        } else if (!StringUtils.isNull(this.fgo.aXS())) {
            this.fgq.qf(this.fgo.aXS());
            if (this.fgq.aXs() && l.hy()) {
                this.fgq.aiQ();
            } else {
                this.fgq.aXv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(d.g.tag_from, 1);
                    c(sparseArray);
                } else {
                    this.fgq.bi(view);
                }
            } else if (booleanValue2) {
                this.fgq.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            g.a(this.fgq.aXB(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        final String str;
        String[] strArr;
        String string;
        if (!(sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue()) {
            String[] strArr2 = new String[2];
            strArr2[0] = getResources().getString(d.j.delete);
            if (z) {
                string = getResources().getString(d.j.un_mute);
            } else {
                string = getResources().getString(d.j.mute);
            }
            strArr2[1] = string;
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(d.j.delete)};
        }
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.cg(d.j.operation);
        bVar.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                switch (i) {
                    case 0:
                        String str2 = "";
                        int intValue = sparseArray.get(d.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue() : 0;
                        if (sparseArray.get(d.g.tag_del_post_id) instanceof String) {
                            str2 = (String) sparseArray.get(d.g.tag_del_post_id);
                        }
                        NewSubPbActivity.this.fgq.a(intValue, str2, sparseArray.get(d.g.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue() : false);
                        break;
                    case 1:
                        String str3 = "";
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        if (sparseArray.get(d.g.tag_user_mute_mute_username) instanceof String) {
                            str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                        }
                        if (sparseArray.get(d.g.tag_user_mute_thread_id) instanceof String) {
                            str4 = (String) sparseArray.get(d.g.tag_user_mute_thread_id);
                        }
                        if (sparseArray.get(d.g.tag_user_mute_post_id) instanceof String) {
                            str5 = (String) sparseArray.get(d.g.tag_user_mute_post_id);
                        }
                        if (sparseArray.get(d.g.tag_user_mute_msg) instanceof String) {
                            str6 = (String) sparseArray.get(d.g.tag_user_mute_msg);
                        }
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.fgA);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.fgA);
                        NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str6, str3);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext()).to();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
        }
        this.fgq.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.fgA;
        userMuteCheckCustomMessage.setTag(this.fgA);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.fgq.a(0, bVar.Al, bVar.gBz, z);
            if (bVar.Al) {
                if (bVar.gBx == 1) {
                    finish();
                } else if (bVar.gBx == 2) {
                    this.fgo.qi(bVar.mPostId);
                    this.fgq.a(this.fgo.aXI(), this.fgo.aRs(), this.fgo.aXY() != null);
                    if (this.fgo.aXT()) {
                        this.fgo.kq(false);
                        this.fgq.aXq();
                        this.fgo.Fy();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void pJ(String str) {
        if (!StringUtils.isNull(str) && this.fgo != null) {
            String aUe = this.fgo.aUe();
            String Dx = this.fgo.Dx();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Dx + "&tid=" + aUe + "&pid=" + str, true)));
        }
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.fgo.isMarked() && postData.getId() != null && postData.getId().equals(this.fgo.aXQ())) {
                z = true;
            }
            MarkData h = this.fgo.h(postData);
            if (h != null) {
                this.fgq.aWo();
                if (this.etk != null) {
                    this.etk.a(h);
                    if (!z) {
                        this.etk.nL();
                    } else {
                        this.etk.nK();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.fgo != null) {
            this.fgo.u(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.dZX != null) {
            this.dZX.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.dZX.Dd().Bm();
        this.dZX.DZ();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.dZX.b(writeData);
                this.dZX.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.r eP = this.dZX.Dd().eP(6);
                if (eP != null && eP.aBO != null) {
                    eP.aBO.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.dZX.DV();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cGZ != null) {
            this.cGZ.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.fgy = true;
        super.onPause();
        if (this.cGZ != null) {
            this.cGZ.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dDN);
        this.fgq.anM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fgy = false;
        super.onResume();
        if (this.cGZ != null) {
            this.cGZ.onResume(getPageContext());
        }
        registerListener(this.dDN);
        this.fgq.anN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cGZ != null) {
            this.cGZ.onStop(getPageContext());
        }
        this.dZX.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.fgE));
        this.fgo.cancelLoadData();
        this.fgo.destory();
        this.fgp.cancelLoadData();
        if (this.cGZ != null) {
            this.cGZ.onDestory(getPageContext());
        }
        this.fgq.aWo();
        this.fgq.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.eTj);
        MessageManager.getInstance().unRegisterListener(this.eTk);
        MessageManager.getInstance().unRegisterListener(this.eTl);
        MessageManager.getInstance().unRegisterListener(this.fgA);
        this.eSI = null;
        this.eSJ = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fgq.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cGZ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aXw = this.fgq.aXw();
        if (aXw == null || (findViewWithTag = aXw.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean pY(String str) {
        Map<String, String> ea;
        if (!TextUtils.isEmpty(str) && (ea = av.ea(av.eb(str))) != null) {
            this.fgB = true;
            String str2 = ea.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pY(com.baidu.adp.lib.util.k.aO(str2));
            }
            String str3 = ea.get(fgn);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void W(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (pY(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            av.vL().c(getPageContext(), new String[]{str});
            this.fgB = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fgB = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void g(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.fgq != null) {
            return this.fgq.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int JV() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> JX() {
        if (this.aVw == null) {
            this.aVw = TbRichTextView.k(getPageContext().getPageActivity(), 8);
        }
        return this.aVw;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> JY() {
        if (this.aVA == null) {
            this.aVA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aTw */
                public GifView fI() {
                    return new GifView(NewSubPbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void n(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView o(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView p(GifView gifView) {
                    return gifView;
                }
            }, 20, 0);
        }
        return this.aVA;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> JW() {
        if (this.aVv == null) {
            this.aVv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: YQ */
                public ImageView fI() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean pg = com.baidu.tbadk.core.h.pa().pg();
                    foreDrawableImageView.setDefaultBg(aj.getDrawable(d.C0082d.common_color_10220));
                    if (pg) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(d.f.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public void n(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.C0082d.cp_bg_line_c);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView o(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.h.pa().pg()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(d.f.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: e */
                public ImageView p(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.C0082d.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.aVv;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> JZ() {
        if (this.aVx == null) {
            this.aVx = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aTx */
                public View fI() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bd */
                public void n(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: be */
                public View o(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bf */
                public View p(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.aVx;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Ka() {
        if (this.aVy == null) {
            this.aVy = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aTz */
                public LinearLayout fI() {
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
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: b */
                public void n(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public LinearLayout o(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public LinearLayout p(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.aVy;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Kb() {
        this.aVz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aTy */
            public RelativeLayout fI() {
                return new RelativeLayout(NewSubPbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void n(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout o(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout p(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.aVz;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fgq.aXs() && l.hy()) {
            this.fgo.Fy();
        } else {
            this.fgq.aXv();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (sparseArray.get(d.g.tag_user_mute_mute_username) instanceof String) {
            str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(d.g.tag_user_mute_thread_id) instanceof String) {
            str4 = (String) sparseArray.get(d.g.tag_user_mute_thread_id);
        }
        if (!(sparseArray.get(d.g.tag_user_mute_post_id) instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) sparseArray.get(d.g.tag_user_mute_post_id);
        }
        String str6 = sparseArray.get(d.g.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(d.g.tag_user_mute_msg) : str2;
        if (sparseArray.get(d.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(d.g.tag_user_mute_msg);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.fgA);
        userMuteAddAndDelCustomMessage.setTag(this.fgA);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aa(Context context, String str) {
        j(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean FQ() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int FR() {
                return com.baidu.tbadk.pageStayDuration.e.FV().FX();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.fgo != null) {
            if (this.fgo.aXI() != null && this.fgo.aXI().aSa() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fgo.aXI().aSa().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fgo.aUe(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aey() {
        return this.fgy;
    }

    public boolean aXm() {
        if (this.fgo != null) {
            return this.fgo.aXm();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.fgq.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eSI.getPageActivity());
        if (am.isEmpty(str)) {
            aVar.cS(this.eSI.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.cS(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.fgq.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eSI).tk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gd(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eSI.getPageActivity());
        aVar.cS(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eSI).tk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cS(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.eSI).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.eSI.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eSI).tk();
    }

    public String getThreadId() {
        if (this.fgo != null) {
            return this.fgo.aUe();
        }
        return null;
    }

    public String getPostId() {
        if (this.fgo != null) {
            return this.fgo.Dx();
        }
        return null;
    }

    public int aRs() {
        if (this.fgo != null) {
            return this.fgo.aRs();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.aCl) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.aCl) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void kl(boolean z) {
        if (this.fdE != null && this.fdE.getText() != null) {
            int selectionEnd = this.fdE.getSelectionEnd();
            SpannableStringBuilder b = this.fgD.b(this.fdE.getText());
            if (b != null) {
                this.fgD.nT(true);
                this.fdE.setText(b);
                if (z && this.fgD.bET() >= 0) {
                    this.fdE.requestFocus();
                    this.fdE.setSelection(this.fgD.bET());
                } else {
                    this.fdE.setSelection(selectionEnd);
                }
                this.fgD.nS(this.fgD.bET() >= 0);
            }
        }
    }
}
