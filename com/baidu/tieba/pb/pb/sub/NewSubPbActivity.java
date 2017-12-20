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
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.k;
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
/* loaded from: classes.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.e {
    private static final String ffR = com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String fhl = "tbgametype";
    private com.baidu.adp.lib.e.b<LinearLayout> aVA;
    private com.baidu.adp.lib.e.b<RelativeLayout> aVB;
    private com.baidu.adp.lib.e.b<GifView> aVC;
    private com.baidu.adp.lib.e.b<ImageView> aVx;
    private com.baidu.adp.lib.e.b<TextView> aVy;
    private com.baidu.adp.lib.e.b<View> aVz;
    private View.OnLongClickListener avF;
    private VoiceManager cHh;
    private com.baidu.adp.base.e eTL;
    private com.baidu.tbadk.core.view.d eTM;
    private b.InterfaceC0061b eUA;
    private PostWriteCallBackData eXA;
    private h ebc;
    private com.baidu.tbadk.baseEditMark.a euo;
    private EditText feF;
    private b fhA;
    private com.baidu.tieba.write.b fhB;
    private com.baidu.tieba.pb.e<m> fhC;
    private SubPbModel fhm;
    private ForumManageModel fhn;
    private c fho;
    private AbsListView.OnScrollListener fhp;
    private TbRichTextView.h fhq;
    private TbRichTextView.g fhr;
    private SubPbModel.a fhs;
    private com.baidu.adp.base.d fht;
    private BdUniqueId fhy;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int eUx = 0;
    private a.InterfaceC0057a eUt = null;
    private a fhu = null;
    private a fhv = null;
    private boolean fhw = false;
    private boolean fhx = false;
    private boolean fhz = false;
    private boolean aCq = false;
    private com.baidu.tbadk.editortools.pb.c aDL = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void DB() {
            NewSubPbActivity.this.fho.aXB();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aDM = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean DA() {
            if (NewSubPbActivity.this.fhB.bFF()) {
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.fhB.bFH());
                if (NewSubPbActivity.this.ebc.DQ()) {
                    NewSubPbActivity.this.ebc.a(NewSubPbActivity.this.eXA);
                }
                NewSubPbActivity.this.km(true);
                return true;
            }
            return false;
        }
    };
    private NewWriteModel.d fhD = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.ebc != null && NewSubPbActivity.this.ebc.De() != null) {
                NewSubPbActivity.this.ebc.De().hide();
                if (NewSubPbActivity.this.fhm.aXW()) {
                    TiebaStatic.log(new ak("c10367").ac("post_id", NewSubPbActivity.this.fhm.Dy()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fhB.uB(null);
                NewSubPbActivity.this.fhB.aC(null);
                NewSubPbActivity.this.fhB.nT(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fhB.aC(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fhB.uB(postWriteCallBackData.getErrorString());
                if (!v.w(NewSubPbActivity.this.fhB.bFD())) {
                    NewSubPbActivity.this.eXA = postWriteCallBackData;
                    if (NewSubPbActivity.this.ebc.DQ()) {
                        NewSubPbActivity.this.ebc.a(NewSubPbActivity.this.eXA);
                    }
                    NewSubPbActivity.this.km(true);
                } else {
                    return;
                }
            }
            NewSubPbActivity.this.fho.aXC();
        }
    };
    private CustomMessageListener eUm = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fhy) {
                NewSubPbActivity.this.fho.XC();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eTM.c(NewSubPbActivity.this.eTL.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.eTL.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.gc(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.aTz();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (am.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.eTL.getResources().getString(d.j.mute_fail);
                    }
                    NewSubPbActivity.this.eTM.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eUn = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fhy) {
                NewSubPbActivity.this.fho.XC();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eTM.c(NewSubPbActivity.this.eTL.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (am.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.eTL.getResources().getString(d.j.un_mute_fail);
                }
                NewSubPbActivity.this.eTM.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eUo = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fhy) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.fho.XC();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.gPt;
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
                    NewSubPbActivity.this.fho.a(sparseArray, z);
                }
            }
        }
    };
    boolean eUy = false;
    private CustomMessageListener dER = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener cId = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    k kVar = (k) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.fhm.aXP() != null && NewSubPbActivity.this.fhm.aXP().aSb() != null && NewSubPbActivity.this.fhm.aXP().aSb().rv() != null && currentAccount.equals(NewSubPbActivity.this.fhm.aXP().aSb().rv().getUserId()) && NewSubPbActivity.this.fhm.aXP().aSb().rv().getPendantData() != null) {
                        NewSubPbActivity.this.fhm.aXP().aSb().rv().getPendantData().cF(kVar.pR());
                        NewSubPbActivity.this.fhm.aXP().aSb().rv().getPendantData().T(kVar.CF());
                        NewSubPbActivity.this.fho.a(NewSubPbActivity.this.fhm.aXP().aSb(), NewSubPbActivity.this.fhm.aXP().aCC(), NewSubPbActivity.this.fhm.aXP().nH(), NewSubPbActivity.this.fhm.aRA(), NewSubPbActivity.this.fhm.aYf() != null);
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
        if (this.aCq) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.eTL = getPageContext();
        this.fhx = true;
        this.fhB = new com.baidu.tieba.write.b();
        this.fhB.vN(d.C0096d.cp_cont_h_alpha85);
        this.fhB.vM(d.C0096d.cp_cont_i);
        aoY();
        aXr();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.fhm.aXt()) {
            this.fhA = new b(this, getListView(), this.fho.alD());
            this.fhA.apd();
            this.fhA.a(new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                private boolean cVB = false;

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void aoZ() {
                    NewSubPbActivity.this.fho.fx(false);
                    this.cVB = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void apa() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public boolean apb() {
                    if (!this.cVB) {
                        return NewSubPbActivity.this.fho.app() != null && NewSubPbActivity.this.fho.app().getTop() == 0;
                    }
                    this.cVB = false;
                    return false;
                }
            });
            this.fho.e(this.fhA);
            this.fho.fx(true);
        }
        this.eTM = new com.baidu.tbadk.core.view.d();
        this.eTM.alk = 1000L;
        registerListener(this.eUo);
        registerListener(this.eUm);
        registerListener(this.eUn);
        this.fhy = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fhy;
        userMuteAddAndDelCustomMessage.setTag(this.fhy);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.fhy;
        userMuteCheckCustomMessage.setTag(this.fhy);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.fho = new c(this, this.mCommonClickListener);
        this.fho.a(this.fhm);
        addContentView(this.fho.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.fho.setOnScrollListener(this.fhp);
        this.fho.a(this);
        this.fho.setOnLinkImageClickListener(this.fhq);
        this.fho.setOnImageClickListener(this.fhr);
        this.fho.iY(true);
        this.fho.setOnLongClickListener(this.avF);
        this.fho.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.fhm != null) {
                    NewSubPbActivity.this.fhm.Fz();
                }
            }
        });
        this.fho.a(this.fhu);
        this.fho.b(this.fhv);
        if (this.fhm != null && this.fhm.aXt() && !this.fhm.aYe()) {
            this.fho.aXG().setVisibility(8);
        } else {
            this.fho.aXG().setVisibility(0);
        }
        if (this.fhm != null && !this.fhm.aXt()) {
            this.fho.setIsFromPb(false);
        }
    }

    private boolean v(Bundle bundle) {
        if (bundle != null) {
            this.aCq = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.aCq = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.aCq;
    }

    public void initData(Bundle bundle) {
        this.fhm = new SubPbModel(getPageContext());
        this.fhm.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.fho.n(postData);
                NewSubPbActivity.this.fho.a((BdListView.e) null);
            }
        });
        this.fhn = new ForumManageModel(this);
        this.fhn.setLoadDataCallBack(this.fht);
        this.cHh = new VoiceManager();
        this.cHh.onCreate(getPageContext());
        this.euo = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.euo != null) {
            this.euo.a(this.eUt);
        }
        if (bundle != null) {
            this.fhm.initWithBundle(bundle);
        } else {
            this.fhm.initWithIntent(getIntent());
        }
        this.fhm.a(this.fhs);
        if (this.fhm.aXt()) {
            this.fhm.Fz();
        } else {
            this.fhm.aXU();
        }
    }

    public void aXr() {
        this.fhs = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, m mVar) {
                if (NewSubPbActivity.this.fho != null) {
                    NewSubPbActivity.this.fho.aXC();
                }
                if (NewSubPbActivity.this.fhA != null && NewSubPbActivity.this.fhA.ape()) {
                    NewSubPbActivity.this.fhA.kC(d.C0096d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.X(i, str);
                    return;
                }
                NewSubPbActivity.this.fho.hideNoDataView();
                if (mVar != null) {
                    if (mVar.aSb() != null || NewSubPbActivity.this.fhm != null) {
                        mVar.aSb().a(NewSubPbActivity.this.fhm.aYd());
                    }
                    if (NewSubPbActivity.this.fho != null) {
                        NewSubPbActivity.this.fho.a(mVar, NewSubPbActivity.this.fhm.aRA(), NewSubPbActivity.this.fhm.aYf() != null);
                        if (NewSubPbActivity.this.fhx) {
                            NewSubPbActivity.this.aXs();
                            NewSubPbActivity.this.fhx = false;
                        }
                    }
                    if (NewSubPbActivity.this.ebc != null) {
                        NewSubPbActivity.this.ebc.a(mVar.aSj());
                    }
                    if (NewSubPbActivity.this.fhC == null) {
                        NewSubPbActivity.this.fhC = new com.baidu.tieba.pb.e();
                    }
                    NewSubPbActivity.this.fhC.setData(mVar);
                    NewSubPbActivity.this.fhC.setType(0);
                }
            }
        };
        this.eUt = new a.InterfaceC0057a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0057a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.euo != null) {
                        NewSubPbActivity.this.euo.ab(z2);
                    }
                    MarkData nK = NewSubPbActivity.this.euo.nK();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(nK);
                        if (NewSubPbActivity.this.euo != null) {
                            if (nK != null) {
                                NewSubPbActivity.this.fhm.kq(true);
                                NewSubPbActivity.this.fhm.qj(NewSubPbActivity.this.fhm.Dy());
                                NewSubPbActivity.this.showToast(d.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.add_mark));
                            }
                            if (NewSubPbActivity.this.fho != null) {
                                NewSubPbActivity.this.fho.kn(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.fhm.kq(false);
                        NewSubPbActivity.this.fhm.qj(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.remove_mark));
                        if (NewSubPbActivity.this.fho != null) {
                            NewSubPbActivity.this.fho.kn(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.update_mark_failed));
            }
        };
        this.fhu = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.fhm.aXP() != null && NewSubPbActivity.this.fhm.aXP().Ox() != null && NewSubPbActivity.this.fhm.aXP().Ox().rv() != null) {
                    str = String.valueOf(NewSubPbActivity.this.fhm.aXP().Ox().rv().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.fhm.aXP().aSi().getId(), NewSubPbActivity.this.fhm.aXP().aSi().getName(), NewSubPbActivity.this.fhm.aXP().Ox().getId(), str, str2, str3)));
            }
        };
        this.fhv = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.fhn.bxI() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.fhm != null && NewSubPbActivity.this.fhm.aXP() != null && NewSubPbActivity.this.fhm.aXP().aSi() != null && NewSubPbActivity.this.fhm.aXP().Ox() != null) {
                            NewSubPbActivity.this.fhn.a(NewSubPbActivity.this.fhm.aXP().aSi().getId(), NewSubPbActivity.this.fhm.aXP().aSi().getName(), NewSubPbActivity.this.fhm.aXP().Ox().getId(), valueOf, g2, g, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.j.login_to_use), true, 11017)));
            }
        };
        this.fht = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = true;
                if (obj == null) {
                    NewSubPbActivity.this.fho.a(NewSubPbActivity.this.fhn.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.fhn.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.dkF && bVar.fip > 0 && bVar.gEg != 1 && bVar.fip != 1002) {
                            com.baidu.tieba.c.a.a(NewSubPbActivity.this.getPageContext(), 3, 1);
                            z = false;
                        }
                        if (bVar.fip == 1002 && !bVar.dkF) {
                            z = false;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.fho.a(1, dVar.Ai, dVar.gEi, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void aoY() {
        registerListener(this.cId);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.fho != null) {
                    if (view == NewSubPbActivity.this.fho.aXM()) {
                        NewSubPbActivity.this.fho.aWw();
                        String str = view.getTag(d.g.tag_user_id) instanceof String ? (String) view.getTag(d.g.tag_user_id) : null;
                        String str2 = view.getTag(d.g.tag_user_name) instanceof String ? (String) view.getTag(d.g.tag_user_name) : null;
                        String str3 = view.getTag(d.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(d.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                av.vI().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.fho.apq()) {
                        if (view != NewSubPbActivity.this.fho.aXF()) {
                            if (view != NewSubPbActivity.this.fho.aXE()) {
                                if (view == NewSubPbActivity.this.fho.aXA()) {
                                    NewSubPbActivity.this.fho.aWw();
                                    if (NewSubPbActivity.this.fhm.Fz()) {
                                        NewSubPbActivity.this.fho.aXy();
                                    }
                                } else if (view == NewSubPbActivity.this.fho.aXG() || view == NewSubPbActivity.this.fho.aXH() || view == NewSubPbActivity.this.fho.aXJ()) {
                                    if (NewSubPbActivity.this.fhz) {
                                        NewSubPbActivity.this.fhz = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.fhm.aUm(), NewSubPbActivity.this.fhm.Dy(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.fhm.aYi())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.fhm.aYi());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                } else if (NewSubPbActivity.this.fho.aXK() == null || view != NewSubPbActivity.this.fho.aXK().aUZ()) {
                                    if (NewSubPbActivity.this.fho.aXK() == null || view != NewSubPbActivity.this.fho.aXK().aVe()) {
                                        if (NewSubPbActivity.this.fho.aXK() == null || view != NewSubPbActivity.this.fho.aXK().aVc()) {
                                            if (NewSubPbActivity.this.fho.aXK() == null || view != NewSubPbActivity.this.fho.aXK().aVa()) {
                                                if (NewSubPbActivity.this.fho.aXK() == null || view != NewSubPbActivity.this.fho.aXK().aVb()) {
                                                    if ((view == NewSubPbActivity.this.fho.aXD() || view == NewSubPbActivity.this.fho.aXJ()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.ebc.DZ()) {
                                                            NewSubPbActivity.this.ebc.Ea();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.ebc.gd(null);
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
                                                NewSubPbActivity.this.fho.aWw();
                                                if (tag instanceof String) {
                                                    String Dy = NewSubPbActivity.this.fhm.Dy();
                                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                        NewSubPbActivity.this.pJ(Dy);
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
                                                NewSubPbActivity.this.fho.aWw();
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.bq(view);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                NewSubPbActivity.this.showToast(d.j.network_not_available);
                                                return;
                                            }
                                        }
                                        NewSubPbActivity.this.fho.aWw();
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.fho.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new ak("c11739").r("obj_locate", 1));
                                    NewSubPbActivity.this.fho.aWw();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.ebc.gd(null);
                                        if (NewSubPbActivity.this.fhA != null) {
                                            NewSubPbActivity.this.fhA.apc();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new ak("c11739").r("obj_locate", 2));
                                    NewSubPbActivity.this.fho.aWw();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.fhm.aXP() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.fhm.aXP().aSb());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.fho.aXv();
                                NewSubPbActivity.this.fho.aXw();
                                if (NewSubPbActivity.this.ebc != null) {
                                    NewSubPbActivity.this.ebc.Ec();
                                    if (NewSubPbActivity.this.fhA != null) {
                                        NewSubPbActivity.this.fhA.apc();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.fho.aXv();
                            NewSubPbActivity.this.fho.aXw();
                            if (NewSubPbActivity.this.ebc != null) {
                                NewSubPbActivity.this.ebc.Eb();
                                if (NewSubPbActivity.this.fhA != null) {
                                    NewSubPbActivity.this.fhA.apc();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.ebc.DQ()) {
                            NewSubPbActivity.this.ebc.a((PostWriteCallBackData) null);
                            return;
                        }
                        NewSubPbActivity.this.fho.aXv();
                        NewSubPbActivity.this.fho.aXw();
                        if (NewSubPbActivity.this.ebc != null) {
                            NewSubPbActivity.this.ebc.Ed();
                            if (NewSubPbActivity.this.fhA != null) {
                                NewSubPbActivity.this.fhA.apc();
                            }
                        }
                    }
                }
            }
        };
        this.fhp = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.fho.aWw();
                }
                NewSubPbActivity.this.ebc.Ea();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.fho.aXL();
            }
        };
        this.eUA = new b.InterfaceC0061b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0061b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.fhm.aXP() != null) {
                    postData = NewSubPbActivity.this.fhm.aXP().aSb();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.cd(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.f(postData);
                    }
                }
            }
        };
        this.avF = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                    NewSubPbActivity.this.fho.b(NewSubPbActivity.this.eUA, NewSubPbActivity.this.fhm.isMarked());
                }
                return true;
            }
        };
        this.fhq = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
            public void b(View view, String str) {
                NewSubPbActivity.this.i(null, str, "LINK_IMAGE");
            }
        };
        this.fhr = new TbRichTextView.g() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            /* JADX DEBUG: Multi-variable search result rejected for r2v17, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX DEBUG: Multi-variable search result rejected for r2v42, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
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
                    m aXP = NewSubPbActivity.this.fhm.aXP();
                    TbRichText au = NewSubPbActivity.this.au(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (au != null && au.Jr() != null) {
                        tbRichTextData = au.Jr().get(NewSubPbActivity.this.eUx);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.Jx().JJ()) {
                            String b = NewSubPbActivity.this.b(tbRichTextData);
                            arrayList2.add(b);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                            concurrentHashMap3.put(b, imageUrlData);
                            String str4 = null;
                            String str5 = null;
                            String str6 = null;
                            if (aXP == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (aXP.aSi() != null) {
                                    str4 = aXP.aSi().getName();
                                    str5 = aXP.aSi().getId();
                                }
                                if (aXP.Ox() != null) {
                                    str6 = aXP.Ox().getId();
                                }
                                str3 = str6;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.fhm.aYf() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.fhm.aYf();
                                z4 = NewSubPbActivity.this.fhm.aYh();
                                arrayList2 = NewSubPbActivity.this.fhm.aYg();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z4 = z3;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(v.c(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z4, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.eUy = false;
                        String str7 = "";
                        TbRichText bwX = aXP.aSb().bwX();
                        int size = arrayList2.size();
                        int a2 = NewSubPbActivity.this.a(bwX, au, i, i, arrayList2, concurrentHashMap3);
                        int size2 = arrayList2.size();
                        if (size != size2) {
                            str7 = arrayList2.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (aXP == null) {
                            str2 = null;
                            z = false;
                        } else {
                            if (aXP.aSi() != null) {
                                str8 = aXP.aSi().getName();
                                str9 = aXP.aSi().getId();
                            }
                            if (aXP.Ox() != null) {
                                str10 = aXP.Ox().getId();
                            }
                            str2 = str10;
                            z = true;
                        }
                        if (NewSubPbActivity.this.fhm.aYf() != null) {
                            concurrentHashMap = NewSubPbActivity.this.fhm.aYf();
                            z2 = NewSubPbActivity.this.fhm.aYh();
                            arrayList = NewSubPbActivity.this.fhm.aYg();
                            i2 = a2 + NewSubPbActivity.this.fhm.getOffset();
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
        TbRichTextImageInfo Jx;
        if (tbRichText == tbRichText2) {
            this.eUy = true;
        }
        if (tbRichText != null && tbRichText.Jr() != null) {
            int size = tbRichText.Jr().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Jr().get(i6) != null && tbRichText.Jr().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.Jr().get(i6).Jx().getWidth();
                    int height = tbRichText.Jr().get(i6).Jx().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Jr().get(i6).Jx().JJ()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Jr().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (Jx = tbRichTextData.Jx()) != null) {
                            String JL = Jx.JL();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = JL;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.eUy) {
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
        TbRichTextImageInfo Jx = tbRichTextData.Jx();
        if (Jx != null) {
            if (!StringUtils.isNull(Jx.JI())) {
                return Jx.JI();
            }
            if (Jx.getHeight() * Jx.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Jx.getHeight() * Jx.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Jx.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Jx.getHeight())));
            } else {
                float width = Jx.getWidth() / Jx.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aN(Jx.JK()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText au(String str, int i) {
        if (this.fhm == null || this.fhm.aXP() == null || str == null || i < 0) {
            return null;
        }
        m aXP = this.fhm.aXP();
        TbRichText a2 = a(aXP.aSb(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(aXP.aSb(), str, i);
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
        TbRichText bwX = postData.bwX();
        if (bwX != null) {
            ArrayList<TbRichTextData> Jr = bwX.Jr();
            int size = Jr.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Jr.get(i3) != null && Jr.get(i3).getType() == 8) {
                    i2++;
                    if (Jr.get(i3).Jx().JL().equals(str)) {
                        int width = Jr.get(i3).Jx().getWidth();
                        int height = Jr.get(i3).Jx().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.eUx = i3;
                        return bwX;
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
    public void i(Context context, String str, String str2) {
        long templateId = this.fhm.aXP().aSb().bxd() != null ? this.fhm.aXP().aSb().bxd().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && av.vI().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.fhm.aXP().aSi().getId(), this.fhm.aXP().aSi().getName(), this.fhm.aXP().Ox().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i, String str) {
        if (this.fhm.aXQ()) {
            showToast(str);
        } else if (l.hy()) {
            if (i == 4) {
                this.fho.ll(str + "(4)");
            } else {
                this.fho.gV(d.j.no_data_text);
            }
        } else {
            this.fho.gV(d.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.ebc = (h) new i().aV(getActivity());
        if (this.ebc != null) {
            this.ebc.a(getPageContext());
            this.ebc.b(this.fhm);
            this.ebc.b(this.fhD);
            this.ebc.a(this.aDL);
            this.ebc.a(this.aDM);
            this.ebc.De().by(true);
            this.ebc.e(getPageContext());
        }
        if (this.fho != null) {
            this.fho.g(this.ebc);
        }
        if (this.ebc != null && this.fhm != null) {
            this.ebc.a(this.fhm.aSj());
            this.ebc.Ea();
        }
        if (this.ebc != null) {
            this.feF = this.ebc.Ee().getInputView();
            this.feF.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.fhB != null) {
                        if (!NewSubPbActivity.this.fhB.bFG()) {
                            NewSubPbActivity.this.km(false);
                        }
                        NewSubPbActivity.this.fhB.nU(false);
                    }
                }
            });
        }
    }

    public void aXs() {
        if (!TbadkCoreApplication.isLogin()) {
            this.ebc.Ea();
        } else if (!StringUtils.isNull(this.fhm.aXZ())) {
            this.fho.qf(this.fhm.aXZ());
            if (this.fho.aXz() && l.hy()) {
                this.fho.aiX();
            } else {
                this.fho.aXC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(View view) {
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
                    this.fho.bm(view);
                }
            } else if (booleanValue2) {
                this.fho.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            g.a(this.fho.aXI(), getPageContext().getPageActivity());
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
        bVar.a(strArr, new b.InterfaceC0061b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0061b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                switch (i) {
                    case 0:
                        String str2 = "";
                        int intValue = sparseArray.get(d.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue() : 0;
                        if (sparseArray.get(d.g.tag_del_post_id) instanceof String) {
                            str2 = (String) sparseArray.get(d.g.tag_del_post_id);
                        }
                        NewSubPbActivity.this.fho.a(intValue, str2, sparseArray.get(d.g.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue() : false);
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
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.fhy);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.fhy);
                        NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str6, str3);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext()).tl();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
        }
        this.fho.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.fhy;
        userMuteCheckCustomMessage.setTag(this.fhy);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.fho.a(0, bVar.Ai, bVar.gEi, z);
            if (bVar.Ai) {
                if (bVar.gEg == 1) {
                    finish();
                } else if (bVar.gEg == 2) {
                    this.fhm.qi(bVar.mPostId);
                    this.fho.a(this.fhm.aXP(), this.fhm.aRA(), this.fhm.aYf() != null);
                    if (this.fhm.aYa()) {
                        this.fhm.kr(false);
                        this.fho.aXx();
                        this.fhm.Fz();
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
        if (!StringUtils.isNull(str) && this.fhm != null) {
            String aUm = this.fhm.aUm();
            String Dy = this.fhm.Dy();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Dy + "&tid=" + aUm + "&pid=" + str, true)));
        }
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.fhm.isMarked() && postData.getId() != null && postData.getId().equals(this.fhm.aXX())) {
                z = true;
            }
            MarkData h = this.fhm.h(postData);
            if (h != null) {
                this.fho.aWw();
                if (this.euo != null) {
                    this.euo.a(h);
                    if (!z) {
                        this.euo.nJ();
                    } else {
                        this.euo.nI();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.fhm != null) {
            this.fhm.u(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.ebc != null) {
            this.ebc.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.ebc.De().Bn();
        this.ebc.Ea();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.ebc.b(writeData);
                this.ebc.setVoiceModel(pbEditorData.getVoiceModel());
                r eP = this.ebc.De().eP(6);
                if (eP != null && eP.aBT != null) {
                    eP.aBT.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.ebc.DW();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cHh != null) {
            this.cHh.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.fhw = true;
        super.onPause();
        if (this.cHh != null) {
            this.cHh.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dER);
        this.fho.anU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fhw = false;
        super.onResume();
        if (this.cHh != null) {
            this.cHh.onResume(getPageContext());
        }
        registerListener(this.dER);
        this.fho.anV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cHh != null) {
            this.cHh.onStop(getPageContext());
        }
        this.ebc.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.fhC));
        this.fhm.cancelLoadData();
        this.fhm.destory();
        this.fhn.cancelLoadData();
        if (this.cHh != null) {
            this.cHh.onDestory(getPageContext());
        }
        this.fho.aWw();
        this.fho.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.eUm);
        MessageManager.getInstance().unRegisterListener(this.eUn);
        MessageManager.getInstance().unRegisterListener(this.eUo);
        MessageManager.getInstance().unRegisterListener(this.fhy);
        this.eTL = null;
        this.eTM = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fho.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cHh;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aXD = this.fho.aXD();
        if (aXD == null || (findViewWithTag = aXD.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean pY(String str) {
        Map<String, String> ea;
        if (!TextUtils.isEmpty(str) && (ea = av.ea(av.eb(str))) != null) {
            this.fhz = true;
            String str2 = ea.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pY(com.baidu.adp.lib.util.k.aO(str2));
            }
            String str3 = ea.get(fhl);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (pY(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            av.vI().c(getPageContext(), new String[]{str});
            this.fhz = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void U(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fhz = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void W(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void f(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.fho != null) {
            return this.fho.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int JW() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> JY() {
        if (this.aVy == null) {
            this.aVy = TbRichTextView.k(getPageContext().getPageActivity(), 8);
        }
        return this.aVy;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> JZ() {
        if (this.aVC == null) {
            this.aVC = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aTE */
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
        return this.aVC;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> JX() {
        if (this.aVx == null) {
            this.aVx = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: YR */
                public ImageView fI() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean pe = com.baidu.tbadk.core.h.oY().pe();
                    foreDrawableImageView.setDefaultBg(aj.getDrawable(d.C0096d.common_color_10220));
                    if (pe) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0096d.cp_bg_line_c);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView o(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.h.oY().pe()) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0096d.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.aVx;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Ka() {
        if (this.aVz == null) {
            this.aVz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aTF */
                public View fI() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bh */
                public void n(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bi */
                public View o(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bj */
                public View p(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.aVz;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Kb() {
        if (this.aVA == null) {
            this.aVA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aTH */
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
        return this.aVA;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Kc() {
        this.aVB = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aTG */
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
        return this.aVB;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fho.aXz() && l.hy()) {
            this.fhm.Fz();
        } else {
            this.fho.aXC();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.fhy);
        userMuteAddAndDelCustomMessage.setTag(this.fhy);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
        i(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean FR() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int FS() {
                return com.baidu.tbadk.pageStayDuration.e.FW().FY();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.fhm != null) {
            if (this.fhm.aXP() != null && this.fhm.aXP().aSi() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fhm.aXP().aSi().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fhm.aUm(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aeF() {
        return this.fhw;
    }

    public boolean aXt() {
        if (this.fhm != null) {
            return this.fhm.aXt();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.fho.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eTL.getPageActivity());
        if (am.isEmpty(str)) {
            aVar.cS(this.eTL.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.cS(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.fho.showLoadingDialog();
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
        aVar.b(this.eTL).th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eTL.getPageActivity());
        aVar.cS(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eTL).th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cS(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.eTL).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.eTL.getPageActivity(), 2, true, 4);
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
        aVar.b(this.eTL).th();
    }

    public String getThreadId() {
        if (this.fhm != null) {
            return this.fhm.aUm();
        }
        return null;
    }

    public String getPostId() {
        if (this.fhm != null) {
            return this.fhm.Dy();
        }
        return null;
    }

    public int aRA() {
        if (this.fhm != null) {
            return this.fhm.aRA();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.aCq) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.aCq) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void km(boolean z) {
        if (this.feF != null && this.feF.getText() != null) {
            int selectionEnd = this.feF.getSelectionEnd();
            SpannableStringBuilder b = this.fhB.b(this.feF.getText());
            if (b != null) {
                this.fhB.nU(true);
                this.feF.setText(b);
                if (z && this.fhB.bFE() >= 0) {
                    this.feF.requestFocus();
                    this.feF.setSelection(this.fhB.bFE());
                } else {
                    this.feF.setSelection(selectionEnd);
                }
                this.fhB.nT(this.fhB.bFE() >= 0);
            }
        }
    }
}
