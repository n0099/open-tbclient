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
import com.baidu.adp.lib.util.k;
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
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.h;
import com.baidu.tbadk.editortools.pb.i;
import com.baidu.tbadk.editortools.r;
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
/* loaded from: classes2.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.e {
    private static final String fSR = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String fUq = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> bJo;
    private com.baidu.adp.lib.e.b<TextView> bJp;
    private com.baidu.adp.lib.e.b<View> bJq;
    private com.baidu.adp.lib.e.b<LinearLayout> bJr;
    private com.baidu.adp.lib.e.b<RelativeLayout> bJs;
    private com.baidu.adp.lib.e.b<GifView> bJt;
    private View.OnLongClickListener bjN;
    private VoiceManager dwG;
    private h eNj;
    private com.baidu.adp.base.e fGr;
    private com.baidu.tbadk.core.view.d fGs;
    private b.InterfaceC0074b fHh;
    private PostWriteCallBackData fKt;
    private EditText fRD;
    private BdUniqueId fUD;
    private b fUF;
    private com.baidu.tieba.write.b fUG;
    private com.baidu.tieba.pb.e<m> fUH;
    private SubPbModel fUr;
    private ForumManageModel fUs;
    private c fUt;
    private AbsListView.OnScrollListener fUu;
    private TbRichTextView.i fUv;
    private TbRichTextView.h fUw;
    private SubPbModel.a fUx;
    private com.baidu.adp.base.d fUy;
    private com.baidu.tbadk.baseEditMark.a fgs;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int fHe = 0;
    private a.InterfaceC0070a fHa = null;
    private a fUz = null;
    private a fUA = null;
    private boolean fUB = false;
    private boolean fUC = false;
    private boolean fUE = false;
    private boolean bqo = false;
    private com.baidu.tbadk.editortools.pb.c brI = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Lc() {
            NewSubPbActivity.this.fUt.beS();
        }
    };
    private com.baidu.tbadk.editortools.pb.b brJ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Lb() {
            if (NewSubPbActivity.this.fUG.bLo()) {
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.fUG.bLq());
                if (NewSubPbActivity.this.eNj.Lr()) {
                    NewSubPbActivity.this.eNj.a(NewSubPbActivity.this.fKt);
                }
                NewSubPbActivity.this.kP(true);
                return true;
            }
            return false;
        }
    };
    private NewWriteModel.d fUI = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.eNj != null && NewSubPbActivity.this.eNj.KF() != null) {
                NewSubPbActivity.this.eNj.KF().hide();
                if (NewSubPbActivity.this.fUr.bfn()) {
                    TiebaStatic.log(new ak("c10367").ab("post_id", NewSubPbActivity.this.fUr.KZ()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fUG.uE(null);
                NewSubPbActivity.this.fUG.aB(null);
                NewSubPbActivity.this.fUG.on(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fUG.aB(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fUG.uE(postWriteCallBackData.getErrorString());
                if (!v.G(NewSubPbActivity.this.fUG.bLm())) {
                    NewSubPbActivity.this.fKt = postWriteCallBackData;
                    if (NewSubPbActivity.this.eNj.Lr()) {
                        NewSubPbActivity.this.eNj.a(NewSubPbActivity.this.fKt);
                    }
                    NewSubPbActivity.this.kP(true);
                } else {
                    return;
                }
            }
            NewSubPbActivity.this.fUt.beT();
        }
    };
    private CustomMessageListener fGT = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fUD) {
                NewSubPbActivity.this.fUt.afk();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fGs.q(NewSubPbActivity.this.fGr.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.fGr.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.gj(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.baM();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (am.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.fGr.getResources().getString(d.j.mute_fail);
                    }
                    NewSubPbActivity.this.fGs.r(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fGU = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fUD) {
                NewSubPbActivity.this.fUt.afk();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fGs.q(NewSubPbActivity.this.fGr.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (am.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.fGr.getResources().getString(d.j.un_mute_fail);
                }
                NewSubPbActivity.this.fGs.r(muteMessage);
            }
        }
    };
    private CustomMessageListener fGV = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fUD) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.fUt.afk();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.hww;
                if (aVar.error == 0 && dataRes != null) {
                    boolean z2 = com.baidu.adp.lib.g.b.h(dataRes.is_mute, 0) == 1;
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
                    NewSubPbActivity.this.fUt.a(sparseArray, z);
                }
            }
        }
    };
    boolean fHf = false;
    private CustomMessageListener eqX = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener dxE = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    com.baidu.tbadk.data.h hVar = (com.baidu.tbadk.data.h) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.fUr.bfg() != null && NewSubPbActivity.this.fUr.bfg().aZp() != null && NewSubPbActivity.this.fUr.bfg().aZp().yX() != null && currentAccount.equals(NewSubPbActivity.this.fUr.bfg().aZp().yX().getUserId()) && NewSubPbActivity.this.fUr.bfg().aZp().yX().getPendantData() != null) {
                        NewSubPbActivity.this.fUr.bfg().aZp().yX().getPendantData().cM(hVar.xu());
                        NewSubPbActivity.this.fUr.bfg().aZp().yX().getPendantData().ab(hVar.Kh());
                        NewSubPbActivity.this.fUt.a(NewSubPbActivity.this.fUr.bfg().aZp(), NewSubPbActivity.this.fUr.bfg().aJE(), NewSubPbActivity.this.fUr.bfg().vk(), NewSubPbActivity.this.fUr.aYN(), NewSubPbActivity.this.fUr.bfw() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void ak(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        y(bundle);
        if (this.bqo) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.fGr = getPageContext();
        this.fUC = true;
        this.fUG = new com.baidu.tieba.write.b();
        this.fUG.yE(d.C0108d.cp_cont_h_alpha85);
        this.fUG.yD(d.C0108d.cp_cont_i);
        avZ();
        beI();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.fUr.beK()) {
            this.fUF = new b(this, getListView(), this.fUt.atm());
            this.fUF.awe();
            this.fUF.a(new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                private boolean dHQ = false;

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void awa() {
                    NewSubPbActivity.this.fUt.fV(false);
                    this.dHQ = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void awb() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public boolean awc() {
                    if (!this.dHQ) {
                        return NewSubPbActivity.this.fUt.awq() != null && NewSubPbActivity.this.fUt.awq().getTop() == 0;
                    }
                    this.dHQ = false;
                    return false;
                }
            });
            this.fUt.e(this.fUF);
            this.fUt.fV(true);
        }
        this.fGs = new com.baidu.tbadk.core.view.d();
        this.fGs.aZp = 1000L;
        registerListener(this.fGV);
        registerListener(this.fGT);
        registerListener(this.fGU);
        this.fUD = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fUD;
        userMuteAddAndDelCustomMessage.setTag(this.fUD);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.fUD;
        userMuteCheckCustomMessage.setTag(this.fUD);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.fUt = new c(this, this.mCommonClickListener);
        this.fUt.a(this.fUr);
        addContentView(this.fUt.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.fUt.setOnScrollListener(this.fUu);
        this.fUt.a(this);
        this.fUt.setOnLinkImageClickListener(this.fUv);
        this.fUt.setOnImageClickListener(this.fUw);
        this.fUt.jA(true);
        this.fUt.setOnLongClickListener(this.bjN);
        this.fUt.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.fUr != null) {
                    NewSubPbActivity.this.fUr.Na();
                }
            }
        });
        this.fUt.a(this.fUz);
        this.fUt.b(this.fUA);
        if (this.fUr != null && this.fUr.beK() && !this.fUr.bfv()) {
            this.fUt.beX().setVisibility(8);
        } else {
            this.fUt.beX().setVisibility(0);
        }
        if (this.fUr != null && !this.fUr.beK()) {
            this.fUt.setIsFromPb(false);
        }
    }

    private boolean y(Bundle bundle) {
        if (bundle != null) {
            this.bqo = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.bqo = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.bqo;
    }

    public void initData(Bundle bundle) {
        this.fUr = new SubPbModel(getPageContext());
        this.fUr.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.fUt.n(postData);
                NewSubPbActivity.this.fUt.a((BdListView.e) null);
            }
        });
        this.fUs = new ForumManageModel(this);
        this.fUs.setLoadDataCallBack(this.fUy);
        this.dwG = new VoiceManager();
        this.dwG.onCreate(getPageContext());
        this.fgs = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fgs != null) {
            this.fgs.a(this.fHa);
        }
        if (bundle != null) {
            this.fUr.initWithBundle(bundle);
        } else {
            this.fUr.initWithIntent(getIntent());
        }
        this.fUr.a(this.fUx);
        if (this.fUr.beK()) {
            this.fUr.Na();
        } else {
            this.fUr.bfl();
        }
    }

    public void beI() {
        this.fUx = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, m mVar) {
                if (NewSubPbActivity.this.fUt != null) {
                    NewSubPbActivity.this.fUt.beT();
                }
                if (NewSubPbActivity.this.fUF != null && NewSubPbActivity.this.fUF.awf()) {
                    NewSubPbActivity.this.fUF.nw(d.C0108d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.X(i, str);
                    return;
                }
                NewSubPbActivity.this.fUt.hideNoDataView();
                if (mVar != null) {
                    if (mVar.aZp() != null || NewSubPbActivity.this.fUr != null) {
                        mVar.aZp().a(NewSubPbActivity.this.fUr.bfu());
                    }
                    if (NewSubPbActivity.this.fUt != null) {
                        NewSubPbActivity.this.fUt.a(mVar, NewSubPbActivity.this.fUr.aYN(), NewSubPbActivity.this.fUr.bfw() != null);
                        if (NewSubPbActivity.this.fUC) {
                            NewSubPbActivity.this.beJ();
                            NewSubPbActivity.this.fUC = false;
                        }
                    }
                    if (NewSubPbActivity.this.eNj != null) {
                        NewSubPbActivity.this.eNj.a(mVar.aZx());
                    }
                    if (NewSubPbActivity.this.fUH == null) {
                        NewSubPbActivity.this.fUH = new com.baidu.tieba.pb.e();
                    }
                    NewSubPbActivity.this.fUH.setData(mVar);
                    NewSubPbActivity.this.fUH.setType(0);
                }
            }
        };
        this.fHa = new a.InterfaceC0070a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0070a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.fgs != null) {
                        NewSubPbActivity.this.fgs.aH(z2);
                    }
                    MarkData vn = NewSubPbActivity.this.fgs.vn();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(vn);
                        if (NewSubPbActivity.this.fgs != null) {
                            if (vn != null) {
                                NewSubPbActivity.this.fUr.kT(true);
                                NewSubPbActivity.this.fUr.qu(NewSubPbActivity.this.fUr.KZ());
                                NewSubPbActivity.this.showToast(d.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.add_mark));
                            }
                            if (NewSubPbActivity.this.fUt != null) {
                                NewSubPbActivity.this.fUt.kQ(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.fUr.kT(false);
                        NewSubPbActivity.this.fUr.qu(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.remove_mark));
                        if (NewSubPbActivity.this.fUt != null) {
                            NewSubPbActivity.this.fUt.kQ(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.update_mark_failed));
            }
        };
        this.fUz = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void ak(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.fUr.bfg() != null && NewSubPbActivity.this.fUr.bfg().VW() != null && NewSubPbActivity.this.fUr.bfg().VW().yX() != null) {
                    str = String.valueOf(NewSubPbActivity.this.fUr.bfg().VW().yX().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.fUr.bfg().aZw().getId(), NewSubPbActivity.this.fUr.bfg().aZw().getName(), NewSubPbActivity.this.fUr.bfg().VW().getId(), str, str2, str3)));
            }
        };
        this.fUA = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void ak(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.fUs.bCZ() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int h = com.baidu.adp.lib.g.b.h(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int h2 = com.baidu.adp.lib.g.b.h(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.fUr != null && NewSubPbActivity.this.fUr.bfg() != null && NewSubPbActivity.this.fUr.bfg().aZw() != null && NewSubPbActivity.this.fUr.bfg().VW() != null) {
                            NewSubPbActivity.this.fUs.a(NewSubPbActivity.this.fUr.bfg().aZw().getId(), NewSubPbActivity.this.fUr.bfg().aZw().getName(), NewSubPbActivity.this.fUr.bfg().VW().getId(), valueOf, h2, h, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.j.login_to_use), true, 11017)));
            }
        };
        this.fUy = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                boolean z = true;
                if (obj == null) {
                    NewSubPbActivity.this.fUt.a(NewSubPbActivity.this.fUs.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.fUs.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.dWS && bVar.fVt > 0 && bVar.hkZ != 1 && bVar.fVt != 1002) {
                            com.baidu.tieba.c.a.a(NewSubPbActivity.this.getPageContext(), 3, 1);
                            z = false;
                        }
                        if (bVar.fVt == 1002 && !bVar.dWS) {
                            z = false;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.fUt.a(1, dVar.aot, dVar.hlb, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void avZ() {
        registerListener(this.dxE);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.fUt != null) {
                    if (view == NewSubPbActivity.this.fUt.bfd()) {
                        NewSubPbActivity.this.fUt.bdK();
                        String str = view.getTag(d.g.tag_user_id) instanceof String ? (String) view.getTag(d.g.tag_user_id) : null;
                        String str2 = view.getTag(d.g.tag_user_name) instanceof String ? (String) view.getTag(d.g.tag_user_name) : null;
                        String str3 = view.getTag(d.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(d.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                av.Di().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.fUt.awr()) {
                        if (view != NewSubPbActivity.this.fUt.beW()) {
                            if (view != NewSubPbActivity.this.fUt.beV()) {
                                if (view == NewSubPbActivity.this.fUt.beR()) {
                                    NewSubPbActivity.this.fUt.bdK();
                                    if (NewSubPbActivity.this.fUr.Na()) {
                                        NewSubPbActivity.this.fUt.beP();
                                    }
                                } else if (view == NewSubPbActivity.this.fUt.beX() || view == NewSubPbActivity.this.fUt.beY() || view == NewSubPbActivity.this.fUt.bfa()) {
                                    if (NewSubPbActivity.this.fUE) {
                                        NewSubPbActivity.this.fUE = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.fUr.bbB(), NewSubPbActivity.this.fUr.KZ(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.fUr.bfz())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.fUr.bfz());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                } else if (NewSubPbActivity.this.fUt.bfb() == null || view != NewSubPbActivity.this.fUt.bfb().bcn()) {
                                    if (NewSubPbActivity.this.fUt.bfb() == null || view != NewSubPbActivity.this.fUt.bfb().bcs()) {
                                        if (NewSubPbActivity.this.fUt.bfb() == null || view != NewSubPbActivity.this.fUt.bfb().bcq()) {
                                            if (NewSubPbActivity.this.fUt.bfb() == null || view != NewSubPbActivity.this.fUt.bfb().bco()) {
                                                if (NewSubPbActivity.this.fUt.bfb() == null || view != NewSubPbActivity.this.fUt.bfb().bcp()) {
                                                    if ((view == NewSubPbActivity.this.fUt.beU() || view == NewSubPbActivity.this.fUt.bfa()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.eNj.LA()) {
                                                            NewSubPbActivity.this.eNj.LB();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.eNj.gk(null);
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                                TiebaStatic.log(new ak("c11739").s("obj_locate", 4));
                                                if (!j.oI()) {
                                                    NewSubPbActivity.this.showToast(d.j.network_not_available);
                                                    return;
                                                }
                                                Object tag = view.getTag();
                                                NewSubPbActivity.this.fUt.bdK();
                                                if (tag instanceof String) {
                                                    String KZ = NewSubPbActivity.this.fUr.KZ();
                                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                        NewSubPbActivity.this.pT(KZ);
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
                                            } else if (j.oI()) {
                                                NewSubPbActivity.this.fUt.bdK();
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.cB(view);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                NewSubPbActivity.this.showToast(d.j.network_not_available);
                                                return;
                                            }
                                        }
                                        NewSubPbActivity.this.fUt.bdK();
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.fUt.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new ak("c11739").s("obj_locate", 1));
                                    NewSubPbActivity.this.fUt.bdK();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.eNj.gk(null);
                                        if (NewSubPbActivity.this.fUF != null) {
                                            NewSubPbActivity.this.fUF.awd();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new ak("c11739").s("obj_locate", 2));
                                    NewSubPbActivity.this.fUt.bdK();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.fUr.bfg() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.fUr.bfg().aZp());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.fUt.beM();
                                NewSubPbActivity.this.fUt.beN();
                                if (NewSubPbActivity.this.eNj != null) {
                                    NewSubPbActivity.this.eNj.LD();
                                    if (NewSubPbActivity.this.fUF != null) {
                                        NewSubPbActivity.this.fUF.awd();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.fUt.beM();
                            NewSubPbActivity.this.fUt.beN();
                            if (NewSubPbActivity.this.eNj != null) {
                                NewSubPbActivity.this.eNj.LC();
                                if (NewSubPbActivity.this.fUF != null) {
                                    NewSubPbActivity.this.fUF.awd();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.eNj.Lr()) {
                            NewSubPbActivity.this.eNj.a((PostWriteCallBackData) null);
                            return;
                        }
                        NewSubPbActivity.this.fUt.beM();
                        NewSubPbActivity.this.fUt.beN();
                        if (NewSubPbActivity.this.eNj != null) {
                            NewSubPbActivity.this.eNj.LE();
                            if (NewSubPbActivity.this.fUF != null) {
                                NewSubPbActivity.this.fUF.awd();
                            }
                        }
                    }
                }
            }
        };
        this.fUu = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.fUt.bdK();
                }
                NewSubPbActivity.this.eNj.LB();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.fUt.bfc();
            }
        };
        this.fHh = new b.InterfaceC0074b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0074b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.fUr.bfg() != null) {
                    postData = NewSubPbActivity.this.fUr.bfg().aZp();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.co(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.f(postData);
                    }
                }
            }
        };
        this.bjN = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                    NewSubPbActivity.this.fUt.b(NewSubPbActivity.this.fHh, NewSubPbActivity.this.fUr.isMarked());
                }
                return true;
            }
        };
        this.fUv = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void b(View view, String str) {
                NewSubPbActivity.this.k(null, str, "LINK_IMAGE");
            }
        };
        this.fUw = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            /* JADX DEBUG: Multi-variable search result rejected for r2v17, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX DEBUG: Multi-variable search result rejected for r2v42, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
            public void a(View view, String str, int i, boolean z) {
                String str2;
                boolean z2;
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap;
                int i2;
                boolean z3;
                ArrayList<String> arrayList;
                String str3;
                boolean z4;
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2;
                boolean z5;
                try {
                    m bfg = NewSubPbActivity.this.fUr.bfg();
                    TbRichText aw = NewSubPbActivity.this.aw(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (aw != null && aw.QN() != null) {
                        tbRichTextData = aw.QN().get(NewSubPbActivity.this.fHe);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.QT().Rf()) {
                            String b = NewSubPbActivity.this.b(tbRichTextData);
                            arrayList2.add(b);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                            concurrentHashMap3.put(b, imageUrlData);
                            String str4 = null;
                            String str5 = null;
                            String str6 = null;
                            if (bfg == null) {
                                str3 = null;
                                z4 = false;
                            } else {
                                if (bfg.aZw() != null) {
                                    str4 = bfg.aZw().getName();
                                    str5 = bfg.aZw().getId();
                                }
                                if (bfg.VW() != null) {
                                    str6 = bfg.VW().getId();
                                }
                                str3 = str6;
                                z4 = true;
                            }
                            if (NewSubPbActivity.this.fUr.bfw() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.fUr.bfw();
                                z5 = NewSubPbActivity.this.fUr.bfy();
                                arrayList2 = NewSubPbActivity.this.fUr.bfx();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z5 = z4;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(v.f(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.fHf = false;
                        String str7 = "";
                        TbRichText bCo = bfg.aZp().bCo();
                        int size = arrayList2.size();
                        int a2 = NewSubPbActivity.this.a(bCo, aw, i, i, arrayList2, concurrentHashMap3);
                        int size2 = arrayList2.size();
                        if (size != size2) {
                            str7 = arrayList2.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (bfg == null) {
                            str2 = null;
                            z2 = false;
                        } else {
                            if (bfg.aZw() != null) {
                                str8 = bfg.aZw().getName();
                                str9 = bfg.aZw().getId();
                            }
                            if (bfg.VW() != null) {
                                str10 = bfg.VW().getId();
                            }
                            str2 = str10;
                            z2 = true;
                        }
                        if (NewSubPbActivity.this.fUr.bfw() != null) {
                            concurrentHashMap = NewSubPbActivity.this.fUr.bfw();
                            z3 = NewSubPbActivity.this.fUr.bfy();
                            arrayList = NewSubPbActivity.this.fUr.bfx();
                            i2 = a2 + NewSubPbActivity.this.fUr.getOffset();
                        } else {
                            concurrentHashMap = concurrentHashMap3;
                            i2 = a2;
                            z3 = z2;
                            arrayList = arrayList2;
                        }
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.add(v.f(arrayList, i2));
                        NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList4, 0, str8, str9, str2, z3, str7, true, concurrentHashMap, true, false, false)));
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
        TbRichTextImageInfo QT;
        if (tbRichText == tbRichText2) {
            this.fHf = true;
        }
        if (tbRichText != null && tbRichText.QN() != null) {
            int size = tbRichText.QN().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.QN().get(i6) != null && tbRichText.QN().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.QN().get(i6).QT().getWidth();
                    int height = tbRichText.QN().get(i6).QT().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.QN().get(i6).QT().Rf()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.QN().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (QT = tbRichTextData.QT()) != null) {
                            String Rh = QT.Rh();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Rh;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.fHf) {
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
        TbRichTextImageInfo QT = tbRichTextData.QT();
        if (QT != null) {
            if (!StringUtils.isNull(QT.Re())) {
                return QT.Re();
            }
            if (QT.getHeight() * QT.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (QT.getHeight() * QT.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (QT.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * QT.getHeight())));
            } else {
                float width = QT.getWidth() / QT.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aV(QT.Rg()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aw(String str, int i) {
        if (this.fUr == null || this.fUr.bfg() == null || str == null || i < 0) {
            return null;
        }
        m bfg = this.fUr.bfg();
        TbRichText a2 = a(bfg.aZp(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bfg.aZp(), str, i);
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
        TbRichText bCo = postData.bCo();
        if (bCo != null) {
            ArrayList<TbRichTextData> QN = bCo.QN();
            int size = QN.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (QN.get(i3) != null && QN.get(i3).getType() == 8) {
                    i2++;
                    if (QN.get(i3).QT().Rh().equals(str)) {
                        int width = QN.get(i3).QT().getWidth();
                        int height = QN.get(i3).QT().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.fHe = i3;
                        return bCo;
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
    public void k(Context context, String str, String str2) {
        long templateId = this.fUr.bfg().aZp().bCv() != null ? this.fUr.bfg().aZp().bCv().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && av.Di().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.fUr.bfg().aZw().getId(), this.fUr.bfg().aZw().getName(), this.fUr.bfg().VW().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i, String str) {
        if (this.fUr.bfh()) {
            showToast(str);
        } else if (l.oZ()) {
            if (i == 4) {
                this.fUt.ls(str + "(4)");
            } else {
                this.fUt.jT(d.j.no_data_text);
            }
        } else {
            this.fUt.jT(d.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.eNj = (h) new i().bh(getActivity());
        if (this.eNj != null) {
            this.eNj.a(getPageContext());
            this.eNj.b(this.fUr);
            this.eNj.b(this.fUI);
            this.eNj.a(this.brI);
            this.eNj.a(this.brJ);
            this.eNj.KF().cc(true);
            this.eNj.e(getPageContext());
        }
        if (this.fUt != null) {
            this.fUt.g(this.eNj);
        }
        if (this.eNj != null && this.fUr != null) {
            this.eNj.a(this.fUr.aZx());
            this.eNj.LB();
        }
        if (this.eNj != null) {
            this.fRD = this.eNj.LF().getInputView();
            this.fRD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.fUG != null) {
                        if (!NewSubPbActivity.this.fUG.bLp()) {
                            NewSubPbActivity.this.kP(false);
                        }
                        NewSubPbActivity.this.fUG.oo(false);
                    }
                }
            });
        }
    }

    public void beJ() {
        if (!TbadkCoreApplication.isLogin()) {
            this.eNj.LB();
        } else if (!StringUtils.isNull(this.fUr.bfq())) {
            this.fUt.qq(this.fUr.bfq());
            if (this.fUt.beQ() && l.oZ()) {
                this.fUt.aqx();
            } else {
                this.fUt.beT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(View view) {
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
                    this.fUt.cx(view);
                }
            } else if (booleanValue2) {
                this.fUt.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            g.a(this.fUt.beZ(), getPageContext().getPageActivity());
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
        bVar.fg(d.j.operation);
        bVar.a(strArr, new b.InterfaceC0074b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0074b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                switch (i) {
                    case 0:
                        String str2 = "";
                        int intValue = sparseArray.get(d.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue() : 0;
                        if (sparseArray.get(d.g.tag_del_post_id) instanceof String) {
                            str2 = (String) sparseArray.get(d.g.tag_del_post_id);
                        }
                        NewSubPbActivity.this.fUt.a(intValue, str2, sparseArray.get(d.g.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue() : false);
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
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.fUD);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.fUD);
                        NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str6, str3);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext()).AL();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
        }
        this.fUt.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.fUD;
        userMuteCheckCustomMessage.setTag(this.fUD);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.fUt.a(0, bVar.aot, bVar.hlb, z);
            if (bVar.aot) {
                if (bVar.hkZ == 1) {
                    finish();
                } else if (bVar.hkZ == 2) {
                    this.fUr.qt(bVar.mPostId);
                    this.fUt.a(this.fUr.bfg(), this.fUr.aYN(), this.fUr.bfw() != null);
                    if (this.fUr.bfr()) {
                        this.fUr.kU(false);
                        this.fUt.beO();
                        this.fUr.Na();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void pT(String str) {
        if (!StringUtils.isNull(str) && this.fUr != null) {
            String bbB = this.fUr.bbB();
            String KZ = this.fUr.KZ();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + KZ + "&tid=" + bbB + "&pid=" + str, true)));
        }
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.fUr.isMarked() && postData.getId() != null && postData.getId().equals(this.fUr.bfo())) {
                z = true;
            }
            MarkData h = this.fUr.h(postData);
            if (h != null) {
                this.fUt.bdK();
                if (this.fgs != null) {
                    this.fgs.a(h);
                    if (!z) {
                        this.fgs.vm();
                    } else {
                        this.fgs.vl();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.fUr != null) {
            this.fUr.x(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.eNj != null) {
            this.eNj.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.eNj.KF().IP();
        this.eNj.LB();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eNj.b(writeData);
                this.eNj.setVoiceModel(pbEditorData.getVoiceModel());
                r hN = this.eNj.KF().hN(6);
                if (hN != null && hN.bpR != null) {
                    hN.bpR.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eNj.Lx();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dwG != null) {
            this.dwG.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.fUB = true;
        super.onPause();
        if (this.dwG != null) {
            this.dwG.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.eqX);
        this.fUt.avv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fUB = false;
        super.onResume();
        if (this.dwG != null) {
            this.dwG.onResume(getPageContext());
        }
        registerListener(this.eqX);
        this.fUt.avw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dwG != null) {
            this.dwG.onStop(getPageContext());
        }
        this.eNj.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.fUH));
        this.fUr.cancelLoadData();
        this.fUr.destory();
        this.fUs.cancelLoadData();
        if (this.dwG != null) {
            this.dwG.onDestory(getPageContext());
        }
        this.fUt.bdK();
        this.fUt.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.fGT);
        MessageManager.getInstance().unRegisterListener(this.fGU);
        MessageManager.getInstance().unRegisterListener(this.fGV);
        MessageManager.getInstance().unRegisterListener(this.fUD);
        this.fGr = null;
        this.fGs = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fUt.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dwG;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View beU = this.fUt.beU();
        if (beU == null || (findViewWithTag = beU.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean qj(String str) {
        Map<String, String> eh;
        if (!TextUtils.isEmpty(str) && (eh = av.eh(av.ei(str))) != null) {
            this.fUE = true;
            String str2 = eh.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return qj(k.aW(str2));
            }
            String str3 = eh.get(fUq);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (qj(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            av.Di().c(getPageContext(), new String[]{str});
            this.fUE = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fUE = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aa(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ab(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void h(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.fUt != null) {
            return this.fUt.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Rt() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Rv() {
        if (this.bJp == null) {
            this.bJp = TbRichTextView.x(getPageContext().getPageActivity(), 8);
        }
        return this.bJp;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Rw() {
        if (this.bJt == null) {
            this.bJt = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: baR */
                public GifView nk() {
                    return new GifView(NewSubPbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void as(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView at(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView au(GifView gifView) {
                    return gifView;
                }
            }, 20, 0);
        }
        return this.bJt;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Ru() {
        if (this.bJo == null) {
            this.bJo = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: agz */
                public ImageView nk() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean wH = com.baidu.tbadk.core.i.wB().wH();
                    foreDrawableImageView.setDefaultBg(aj.getDrawable(d.C0108d.common_color_10220));
                    if (wH) {
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
                public void as(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.C0108d.cp_bg_line_c);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView at(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.wB().wH()) {
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
                public ImageView au(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.C0108d.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.bJo;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Rx() {
        if (this.bJq == null) {
            this.bJq = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: baS */
                public View nk() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cs */
                public void as(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: ct */
                public View at(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cu */
                public View au(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.bJq;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Ry() {
        if (this.bJr == null) {
            this.bJr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: baU */
                public LinearLayout nk() {
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
                public void as(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public LinearLayout at(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public LinearLayout au(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.bJr;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Rz() {
        this.bJs = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: baT */
            public RelativeLayout nk() {
                return new RelativeLayout(NewSubPbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void as(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout at(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout au(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.bJs;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fUt.beQ() && l.oZ()) {
            this.fUr.Na();
        } else {
            this.fUt.beT();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.fUD);
        userMuteAddAndDelCustomMessage.setTag(this.fUD);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ac(Context context, String str) {
        k(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean Nq() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Nr() {
                return com.baidu.tbadk.pageStayDuration.e.Nv().Nx();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.fUr != null) {
            if (this.fUr.bfg() != null && this.fUr.bfg().aZw() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fUr.bfg().aZw().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fUr.bbB(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.fUB;
    }

    public boolean beK() {
        if (this.fUr != null) {
            return this.fUr.beK();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.fUt.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fGr.getPageActivity());
        if (am.isEmpty(str)) {
            aVar.cZ(this.fGr.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.cZ(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.fUt.showLoadingDialog();
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
        aVar.b(this.fGr).AI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gj(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fGr.getPageActivity());
        aVar.cZ(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fGr).AI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baM() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cZ(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.fGr).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.fGr.getPageActivity(), 2, true, 4);
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
        aVar.b(this.fGr).AI();
    }

    public String getThreadId() {
        if (this.fUr != null) {
            return this.fUr.bbB();
        }
        return null;
    }

    public String getPostId() {
        if (this.fUr != null) {
            return this.fUr.KZ();
        }
        return null;
    }

    public int aYN() {
        if (this.fUr != null) {
            return this.fUr.aYN();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.bqo) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.bqo) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void kP(boolean z) {
        if (this.fRD != null && this.fRD.getText() != null) {
            int selectionEnd = this.fRD.getSelectionEnd();
            SpannableStringBuilder b = this.fUG.b(this.fRD.getText());
            if (b != null) {
                this.fUG.oo(true);
                this.fRD.setText(b);
                if (z && this.fUG.bLn() >= 0) {
                    this.fRD.requestFocus();
                    this.fRD.setSelection(this.fUG.bLn());
                } else {
                    this.fRD.setSelection(selectionEnd);
                }
                this.fUG.on(this.fUG.bLn() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.eNj != null && this.eNj.KF() != null && this.eNj.KF().KI()) {
            this.eNj.KF().IP();
        } else {
            super.onBackPressed();
        }
    }
}
