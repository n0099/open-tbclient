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
    private static final String ffW = com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String fhq = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aVA;
    private com.baidu.adp.lib.e.b<TextView> aVB;
    private com.baidu.adp.lib.e.b<View> aVC;
    private com.baidu.adp.lib.e.b<LinearLayout> aVD;
    private com.baidu.adp.lib.e.b<RelativeLayout> aVE;
    private com.baidu.adp.lib.e.b<GifView> aVF;
    private View.OnLongClickListener avI;
    private VoiceManager cHl;
    private com.baidu.adp.base.e eTQ;
    private com.baidu.tbadk.core.view.d eTR;
    private b.InterfaceC0060b eUF;
    private PostWriteCallBackData eXF;
    private h ebg;
    private com.baidu.tbadk.baseEditMark.a eus;
    private EditText feK;
    private BdUniqueId fhD;
    private b fhF;
    private com.baidu.tieba.write.b fhG;
    private com.baidu.tieba.pb.e<m> fhH;
    private SubPbModel fhr;
    private ForumManageModel fhs;
    private c fht;
    private AbsListView.OnScrollListener fhu;
    private TbRichTextView.h fhv;
    private TbRichTextView.g fhw;
    private SubPbModel.a fhx;
    private com.baidu.adp.base.d fhy;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int eUC = 0;
    private a.InterfaceC0056a eUy = null;
    private a fhz = null;
    private a fhA = null;
    private boolean fhB = false;
    private boolean fhC = false;
    private boolean fhE = false;
    private boolean aCt = false;
    private com.baidu.tbadk.editortools.pb.c aDO = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void DB() {
            NewSubPbActivity.this.fht.aXC();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aDP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean DA() {
            if (NewSubPbActivity.this.fhG.bFG()) {
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.fhG.bFI());
                if (NewSubPbActivity.this.ebg.DQ()) {
                    NewSubPbActivity.this.ebg.a(NewSubPbActivity.this.eXF);
                }
                NewSubPbActivity.this.km(true);
                return true;
            }
            return false;
        }
    };
    private NewWriteModel.d fhI = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.ebg != null && NewSubPbActivity.this.ebg.De() != null) {
                NewSubPbActivity.this.ebg.De().hide();
                if (NewSubPbActivity.this.fhr.aXX()) {
                    TiebaStatic.log(new ak("c10367").ac("post_id", NewSubPbActivity.this.fhr.Dy()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fhG.uB(null);
                NewSubPbActivity.this.fhG.aC(null);
                NewSubPbActivity.this.fhG.nT(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fhG.aC(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fhG.uB(postWriteCallBackData.getErrorString());
                if (!v.w(NewSubPbActivity.this.fhG.bFE())) {
                    NewSubPbActivity.this.eXF = postWriteCallBackData;
                    if (NewSubPbActivity.this.ebg.DQ()) {
                        NewSubPbActivity.this.ebg.a(NewSubPbActivity.this.eXF);
                    }
                    NewSubPbActivity.this.km(true);
                } else {
                    return;
                }
            }
            NewSubPbActivity.this.fht.aXD();
        }
    };
    private CustomMessageListener eUr = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fhD) {
                NewSubPbActivity.this.fht.XC();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eTR.c(NewSubPbActivity.this.eTQ.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.eTQ.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.gc(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.aTA();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (am.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.eTQ.getResources().getString(d.j.mute_fail);
                    }
                    NewSubPbActivity.this.eTR.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eUs = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fhD) {
                NewSubPbActivity.this.fht.XC();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eTR.c(NewSubPbActivity.this.eTQ.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (am.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.eTQ.getResources().getString(d.j.un_mute_fail);
                }
                NewSubPbActivity.this.eTR.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eUt = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fhD) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.fht.XC();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.gPy;
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
                    NewSubPbActivity.this.fht.a(sparseArray, z);
                }
            }
        }
    };
    boolean eUD = false;
    private CustomMessageListener dEV = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener cIh = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    k kVar = (k) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.fhr.aXQ() != null && NewSubPbActivity.this.fhr.aXQ().aSc() != null && NewSubPbActivity.this.fhr.aXQ().aSc().rv() != null && currentAccount.equals(NewSubPbActivity.this.fhr.aXQ().aSc().rv().getUserId()) && NewSubPbActivity.this.fhr.aXQ().aSc().rv().getPendantData() != null) {
                        NewSubPbActivity.this.fhr.aXQ().aSc().rv().getPendantData().cF(kVar.pR());
                        NewSubPbActivity.this.fhr.aXQ().aSc().rv().getPendantData().T(kVar.CF());
                        NewSubPbActivity.this.fht.a(NewSubPbActivity.this.fhr.aXQ().aSc(), NewSubPbActivity.this.fhr.aXQ().aCD(), NewSubPbActivity.this.fhr.aXQ().nH(), NewSubPbActivity.this.fhr.aRB(), NewSubPbActivity.this.fhr.aYg() != null);
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
        if (this.aCt) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.eTQ = getPageContext();
        this.fhC = true;
        this.fhG = new com.baidu.tieba.write.b();
        this.fhG.vN(d.C0095d.cp_cont_h_alpha85);
        this.fhG.vM(d.C0095d.cp_cont_i);
        aoZ();
        aXs();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.fhr.aXu()) {
            this.fhF = new b(this, getListView(), this.fht.alD());
            this.fhF.ape();
            this.fhF.a(new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                private boolean cVF = false;

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void apa() {
                    NewSubPbActivity.this.fht.fx(false);
                    this.cVF = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void apb() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public boolean apc() {
                    if (!this.cVF) {
                        return NewSubPbActivity.this.fht.apq() != null && NewSubPbActivity.this.fht.apq().getTop() == 0;
                    }
                    this.cVF = false;
                    return false;
                }
            });
            this.fht.e(this.fhF);
            this.fht.fx(true);
        }
        this.eTR = new com.baidu.tbadk.core.view.d();
        this.eTR.alo = 1000L;
        registerListener(this.eUt);
        registerListener(this.eUr);
        registerListener(this.eUs);
        this.fhD = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fhD;
        userMuteAddAndDelCustomMessage.setTag(this.fhD);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.fhD;
        userMuteCheckCustomMessage.setTag(this.fhD);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.fht = new c(this, this.mCommonClickListener);
        this.fht.a(this.fhr);
        addContentView(this.fht.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.fht.setOnScrollListener(this.fhu);
        this.fht.a(this);
        this.fht.setOnLinkImageClickListener(this.fhv);
        this.fht.setOnImageClickListener(this.fhw);
        this.fht.iY(true);
        this.fht.setOnLongClickListener(this.avI);
        this.fht.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.fhr != null) {
                    NewSubPbActivity.this.fhr.Fz();
                }
            }
        });
        this.fht.a(this.fhz);
        this.fht.b(this.fhA);
        if (this.fhr != null && this.fhr.aXu() && !this.fhr.aYf()) {
            this.fht.aXH().setVisibility(8);
        } else {
            this.fht.aXH().setVisibility(0);
        }
        if (this.fhr != null && !this.fhr.aXu()) {
            this.fht.setIsFromPb(false);
        }
    }

    private boolean v(Bundle bundle) {
        if (bundle != null) {
            this.aCt = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.aCt = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.aCt;
    }

    public void initData(Bundle bundle) {
        this.fhr = new SubPbModel(getPageContext());
        this.fhr.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.fht.n(postData);
                NewSubPbActivity.this.fht.a((BdListView.e) null);
            }
        });
        this.fhs = new ForumManageModel(this);
        this.fhs.setLoadDataCallBack(this.fhy);
        this.cHl = new VoiceManager();
        this.cHl.onCreate(getPageContext());
        this.eus = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.eus != null) {
            this.eus.a(this.eUy);
        }
        if (bundle != null) {
            this.fhr.initWithBundle(bundle);
        } else {
            this.fhr.initWithIntent(getIntent());
        }
        this.fhr.a(this.fhx);
        if (this.fhr.aXu()) {
            this.fhr.Fz();
        } else {
            this.fhr.aXV();
        }
    }

    public void aXs() {
        this.fhx = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, m mVar) {
                if (NewSubPbActivity.this.fht != null) {
                    NewSubPbActivity.this.fht.aXD();
                }
                if (NewSubPbActivity.this.fhF != null && NewSubPbActivity.this.fhF.apf()) {
                    NewSubPbActivity.this.fhF.kC(d.C0095d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.X(i, str);
                    return;
                }
                NewSubPbActivity.this.fht.hideNoDataView();
                if (mVar != null) {
                    if (mVar.aSc() != null || NewSubPbActivity.this.fhr != null) {
                        mVar.aSc().a(NewSubPbActivity.this.fhr.aYe());
                    }
                    if (NewSubPbActivity.this.fht != null) {
                        NewSubPbActivity.this.fht.a(mVar, NewSubPbActivity.this.fhr.aRB(), NewSubPbActivity.this.fhr.aYg() != null);
                        if (NewSubPbActivity.this.fhC) {
                            NewSubPbActivity.this.aXt();
                            NewSubPbActivity.this.fhC = false;
                        }
                    }
                    if (NewSubPbActivity.this.ebg != null) {
                        NewSubPbActivity.this.ebg.a(mVar.aSk());
                    }
                    if (NewSubPbActivity.this.fhH == null) {
                        NewSubPbActivity.this.fhH = new com.baidu.tieba.pb.e();
                    }
                    NewSubPbActivity.this.fhH.setData(mVar);
                    NewSubPbActivity.this.fhH.setType(0);
                }
            }
        };
        this.eUy = new a.InterfaceC0056a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0056a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.eus != null) {
                        NewSubPbActivity.this.eus.ab(z2);
                    }
                    MarkData nK = NewSubPbActivity.this.eus.nK();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(nK);
                        if (NewSubPbActivity.this.eus != null) {
                            if (nK != null) {
                                NewSubPbActivity.this.fhr.kq(true);
                                NewSubPbActivity.this.fhr.qj(NewSubPbActivity.this.fhr.Dy());
                                NewSubPbActivity.this.showToast(d.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.add_mark));
                            }
                            if (NewSubPbActivity.this.fht != null) {
                                NewSubPbActivity.this.fht.kn(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.fhr.kq(false);
                        NewSubPbActivity.this.fhr.qj(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.remove_mark));
                        if (NewSubPbActivity.this.fht != null) {
                            NewSubPbActivity.this.fht.kn(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.update_mark_failed));
            }
        };
        this.fhz = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.fhr.aXQ() != null && NewSubPbActivity.this.fhr.aXQ().Ox() != null && NewSubPbActivity.this.fhr.aXQ().Ox().rv() != null) {
                    str = String.valueOf(NewSubPbActivity.this.fhr.aXQ().Ox().rv().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.fhr.aXQ().aSj().getId(), NewSubPbActivity.this.fhr.aXQ().aSj().getName(), NewSubPbActivity.this.fhr.aXQ().Ox().getId(), str, str2, str3)));
            }
        };
        this.fhA = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.fhs.bxJ() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.fhr != null && NewSubPbActivity.this.fhr.aXQ() != null && NewSubPbActivity.this.fhr.aXQ().aSj() != null && NewSubPbActivity.this.fhr.aXQ().Ox() != null) {
                            NewSubPbActivity.this.fhs.a(NewSubPbActivity.this.fhr.aXQ().aSj().getId(), NewSubPbActivity.this.fhr.aXQ().aSj().getName(), NewSubPbActivity.this.fhr.aXQ().Ox().getId(), valueOf, g2, g, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.j.login_to_use), true, 11017)));
            }
        };
        this.fhy = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = true;
                if (obj == null) {
                    NewSubPbActivity.this.fht.a(NewSubPbActivity.this.fhs.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.fhs.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.dkJ && bVar.fiu > 0 && bVar.gEl != 1 && bVar.fiu != 1002) {
                            com.baidu.tieba.c.a.a(NewSubPbActivity.this.getPageContext(), 3, 1);
                            z = false;
                        }
                        if (bVar.fiu == 1002 && !bVar.dkJ) {
                            z = false;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.fht.a(1, dVar.Aj, dVar.gEn, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void aoZ() {
        registerListener(this.cIh);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.fht != null) {
                    if (view == NewSubPbActivity.this.fht.aXN()) {
                        NewSubPbActivity.this.fht.aWx();
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
                    } else if (view != NewSubPbActivity.this.fht.apr()) {
                        if (view != NewSubPbActivity.this.fht.aXG()) {
                            if (view != NewSubPbActivity.this.fht.aXF()) {
                                if (view == NewSubPbActivity.this.fht.aXB()) {
                                    NewSubPbActivity.this.fht.aWx();
                                    if (NewSubPbActivity.this.fhr.Fz()) {
                                        NewSubPbActivity.this.fht.aXz();
                                    }
                                } else if (view == NewSubPbActivity.this.fht.aXH() || view == NewSubPbActivity.this.fht.aXI() || view == NewSubPbActivity.this.fht.aXK()) {
                                    if (NewSubPbActivity.this.fhE) {
                                        NewSubPbActivity.this.fhE = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.fhr.aUn(), NewSubPbActivity.this.fhr.Dy(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.fhr.aYj())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.fhr.aYj());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                } else if (NewSubPbActivity.this.fht.aXL() == null || view != NewSubPbActivity.this.fht.aXL().aVa()) {
                                    if (NewSubPbActivity.this.fht.aXL() == null || view != NewSubPbActivity.this.fht.aXL().aVf()) {
                                        if (NewSubPbActivity.this.fht.aXL() == null || view != NewSubPbActivity.this.fht.aXL().aVd()) {
                                            if (NewSubPbActivity.this.fht.aXL() == null || view != NewSubPbActivity.this.fht.aXL().aVb()) {
                                                if (NewSubPbActivity.this.fht.aXL() == null || view != NewSubPbActivity.this.fht.aXL().aVc()) {
                                                    if ((view == NewSubPbActivity.this.fht.aXE() || view == NewSubPbActivity.this.fht.aXK()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.ebg.DZ()) {
                                                            NewSubPbActivity.this.ebg.Ea();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.ebg.gd(null);
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
                                                NewSubPbActivity.this.fht.aWx();
                                                if (tag instanceof String) {
                                                    String Dy = NewSubPbActivity.this.fhr.Dy();
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
                                                NewSubPbActivity.this.fht.aWx();
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
                                        NewSubPbActivity.this.fht.aWx();
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.fht.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new ak("c11739").r("obj_locate", 1));
                                    NewSubPbActivity.this.fht.aWx();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.ebg.gd(null);
                                        if (NewSubPbActivity.this.fhF != null) {
                                            NewSubPbActivity.this.fhF.apd();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new ak("c11739").r("obj_locate", 2));
                                    NewSubPbActivity.this.fht.aWx();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.fhr.aXQ() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.fhr.aXQ().aSc());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.fht.aXw();
                                NewSubPbActivity.this.fht.aXx();
                                if (NewSubPbActivity.this.ebg != null) {
                                    NewSubPbActivity.this.ebg.Ec();
                                    if (NewSubPbActivity.this.fhF != null) {
                                        NewSubPbActivity.this.fhF.apd();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.fht.aXw();
                            NewSubPbActivity.this.fht.aXx();
                            if (NewSubPbActivity.this.ebg != null) {
                                NewSubPbActivity.this.ebg.Eb();
                                if (NewSubPbActivity.this.fhF != null) {
                                    NewSubPbActivity.this.fhF.apd();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.ebg.DQ()) {
                            NewSubPbActivity.this.ebg.a((PostWriteCallBackData) null);
                            return;
                        }
                        NewSubPbActivity.this.fht.aXw();
                        NewSubPbActivity.this.fht.aXx();
                        if (NewSubPbActivity.this.ebg != null) {
                            NewSubPbActivity.this.ebg.Ed();
                            if (NewSubPbActivity.this.fhF != null) {
                                NewSubPbActivity.this.fhF.apd();
                            }
                        }
                    }
                }
            }
        };
        this.fhu = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.fht.aWx();
                }
                NewSubPbActivity.this.ebg.Ea();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.fht.aXM();
            }
        };
        this.eUF = new b.InterfaceC0060b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0060b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.fhr.aXQ() != null) {
                    postData = NewSubPbActivity.this.fhr.aXQ().aSc();
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
        this.avI = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                    NewSubPbActivity.this.fht.b(NewSubPbActivity.this.eUF, NewSubPbActivity.this.fhr.isMarked());
                }
                return true;
            }
        };
        this.fhv = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
            public void b(View view, String str) {
                NewSubPbActivity.this.i(null, str, "LINK_IMAGE");
            }
        };
        this.fhw = new TbRichTextView.g() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
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
                    m aXQ = NewSubPbActivity.this.fhr.aXQ();
                    TbRichText au = NewSubPbActivity.this.au(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (au != null && au.Jr() != null) {
                        tbRichTextData = au.Jr().get(NewSubPbActivity.this.eUC);
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
                            if (aXQ == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (aXQ.aSj() != null) {
                                    str4 = aXQ.aSj().getName();
                                    str5 = aXQ.aSj().getId();
                                }
                                if (aXQ.Ox() != null) {
                                    str6 = aXQ.Ox().getId();
                                }
                                str3 = str6;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.fhr.aYg() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.fhr.aYg();
                                z4 = NewSubPbActivity.this.fhr.aYi();
                                arrayList2 = NewSubPbActivity.this.fhr.aYh();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z4 = z3;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(v.c(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z4, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.eUD = false;
                        String str7 = "";
                        TbRichText bwY = aXQ.aSc().bwY();
                        int size = arrayList2.size();
                        int a2 = NewSubPbActivity.this.a(bwY, au, i, i, arrayList2, concurrentHashMap3);
                        int size2 = arrayList2.size();
                        if (size != size2) {
                            str7 = arrayList2.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (aXQ == null) {
                            str2 = null;
                            z = false;
                        } else {
                            if (aXQ.aSj() != null) {
                                str8 = aXQ.aSj().getName();
                                str9 = aXQ.aSj().getId();
                            }
                            if (aXQ.Ox() != null) {
                                str10 = aXQ.Ox().getId();
                            }
                            str2 = str10;
                            z = true;
                        }
                        if (NewSubPbActivity.this.fhr.aYg() != null) {
                            concurrentHashMap = NewSubPbActivity.this.fhr.aYg();
                            z2 = NewSubPbActivity.this.fhr.aYi();
                            arrayList = NewSubPbActivity.this.fhr.aYh();
                            i2 = a2 + NewSubPbActivity.this.fhr.getOffset();
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
            this.eUD = true;
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
                        if (!this.eUD) {
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
        if (this.fhr == null || this.fhr.aXQ() == null || str == null || i < 0) {
            return null;
        }
        m aXQ = this.fhr.aXQ();
        TbRichText a2 = a(aXQ.aSc(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(aXQ.aSc(), str, i);
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
        TbRichText bwY = postData.bwY();
        if (bwY != null) {
            ArrayList<TbRichTextData> Jr = bwY.Jr();
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
                        this.eUC = i3;
                        return bwY;
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
        long templateId = this.fhr.aXQ().aSc().bxe() != null ? this.fhr.aXQ().aSc().bxe().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && av.vI().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.fhr.aXQ().aSj().getId(), this.fhr.aXQ().aSj().getName(), this.fhr.aXQ().Ox().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i, String str) {
        if (this.fhr.aXR()) {
            showToast(str);
        } else if (l.hy()) {
            if (i == 4) {
                this.fht.ll(str + "(4)");
            } else {
                this.fht.gV(d.j.no_data_text);
            }
        } else {
            this.fht.gV(d.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.ebg = (h) new i().aV(getActivity());
        if (this.ebg != null) {
            this.ebg.a(getPageContext());
            this.ebg.b(this.fhr);
            this.ebg.b(this.fhI);
            this.ebg.a(this.aDO);
            this.ebg.a(this.aDP);
            this.ebg.De().by(true);
            this.ebg.e(getPageContext());
        }
        if (this.fht != null) {
            this.fht.g(this.ebg);
        }
        if (this.ebg != null && this.fhr != null) {
            this.ebg.a(this.fhr.aSk());
            this.ebg.Ea();
        }
        if (this.ebg != null) {
            this.feK = this.ebg.Ee().getInputView();
            this.feK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.fhG != null) {
                        if (!NewSubPbActivity.this.fhG.bFH()) {
                            NewSubPbActivity.this.km(false);
                        }
                        NewSubPbActivity.this.fhG.nU(false);
                    }
                }
            });
        }
    }

    public void aXt() {
        if (!TbadkCoreApplication.isLogin()) {
            this.ebg.Ea();
        } else if (!StringUtils.isNull(this.fhr.aYa())) {
            this.fht.qf(this.fhr.aYa());
            if (this.fht.aXA() && l.hy()) {
                this.fht.aiX();
            } else {
                this.fht.aXD();
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
                    this.fht.bm(view);
                }
            } else if (booleanValue2) {
                this.fht.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            g.a(this.fht.aXJ(), getPageContext().getPageActivity());
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
        bVar.a(strArr, new b.InterfaceC0060b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0060b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                switch (i) {
                    case 0:
                        String str2 = "";
                        int intValue = sparseArray.get(d.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue() : 0;
                        if (sparseArray.get(d.g.tag_del_post_id) instanceof String) {
                            str2 = (String) sparseArray.get(d.g.tag_del_post_id);
                        }
                        NewSubPbActivity.this.fht.a(intValue, str2, sparseArray.get(d.g.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue() : false);
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
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.fhD);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.fhD);
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
        this.fht.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.fhD;
        userMuteCheckCustomMessage.setTag(this.fhD);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.fht.a(0, bVar.Aj, bVar.gEn, z);
            if (bVar.Aj) {
                if (bVar.gEl == 1) {
                    finish();
                } else if (bVar.gEl == 2) {
                    this.fhr.qi(bVar.mPostId);
                    this.fht.a(this.fhr.aXQ(), this.fhr.aRB(), this.fhr.aYg() != null);
                    if (this.fhr.aYb()) {
                        this.fhr.kr(false);
                        this.fht.aXy();
                        this.fhr.Fz();
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
        if (!StringUtils.isNull(str) && this.fhr != null) {
            String aUn = this.fhr.aUn();
            String Dy = this.fhr.Dy();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Dy + "&tid=" + aUn + "&pid=" + str, true)));
        }
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.fhr.isMarked() && postData.getId() != null && postData.getId().equals(this.fhr.aXY())) {
                z = true;
            }
            MarkData h = this.fhr.h(postData);
            if (h != null) {
                this.fht.aWx();
                if (this.eus != null) {
                    this.eus.a(h);
                    if (!z) {
                        this.eus.nJ();
                    } else {
                        this.eus.nI();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.fhr != null) {
            this.fhr.u(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.ebg != null) {
            this.ebg.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.ebg.De().Bn();
        this.ebg.Ea();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.ebg.b(writeData);
                this.ebg.setVoiceModel(pbEditorData.getVoiceModel());
                r eP = this.ebg.De().eP(6);
                if (eP != null && eP.aBW != null) {
                    eP.aBW.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.ebg.DW();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cHl != null) {
            this.cHl.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.fhB = true;
        super.onPause();
        if (this.cHl != null) {
            this.cHl.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dEV);
        this.fht.anV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fhB = false;
        super.onResume();
        if (this.cHl != null) {
            this.cHl.onResume(getPageContext());
        }
        registerListener(this.dEV);
        this.fht.anW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cHl != null) {
            this.cHl.onStop(getPageContext());
        }
        this.ebg.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.fhH));
        this.fhr.cancelLoadData();
        this.fhr.destory();
        this.fhs.cancelLoadData();
        if (this.cHl != null) {
            this.cHl.onDestory(getPageContext());
        }
        this.fht.aWx();
        this.fht.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.eUr);
        MessageManager.getInstance().unRegisterListener(this.eUs);
        MessageManager.getInstance().unRegisterListener(this.eUt);
        MessageManager.getInstance().unRegisterListener(this.fhD);
        this.eTQ = null;
        this.eTR = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fht.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cHl;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aXE = this.fht.aXE();
        if (aXE == null || (findViewWithTag = aXE.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean pY(String str) {
        Map<String, String> ea;
        if (!TextUtils.isEmpty(str) && (ea = av.ea(av.eb(str))) != null) {
            this.fhE = true;
            String str2 = ea.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pY(com.baidu.adp.lib.util.k.aO(str2));
            }
            String str3 = ea.get(fhq);
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
            this.fhE = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void U(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fhE = true;
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
        if (this.fht != null) {
            return this.fht.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int JW() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> JY() {
        if (this.aVB == null) {
            this.aVB = TbRichTextView.k(getPageContext().getPageActivity(), 8);
        }
        return this.aVB;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> JZ() {
        if (this.aVF == null) {
            this.aVF = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aTF */
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
        return this.aVF;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> JX() {
        if (this.aVA == null) {
            this.aVA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: YR */
                public ImageView fI() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean pe = com.baidu.tbadk.core.h.oY().pe();
                    foreDrawableImageView.setDefaultBg(aj.getDrawable(d.C0095d.common_color_10220));
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
                        foreDrawableImageView.setDefaultBgResource(d.C0095d.cp_bg_line_c);
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
                        foreDrawableImageView.setDefaultBgResource(d.C0095d.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.aVA;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Ka() {
        if (this.aVC == null) {
            this.aVC = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aTG */
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
        return this.aVC;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Kb() {
        if (this.aVD == null) {
            this.aVD = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aTI */
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
        return this.aVD;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Kc() {
        this.aVE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aTH */
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
        return this.aVE;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fht.aXA() && l.hy()) {
            this.fhr.Fz();
        } else {
            this.fht.aXD();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.fhD);
        userMuteAddAndDelCustomMessage.setTag(this.fhD);
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
        if (pageStayDurationItem != null && this.fhr != null) {
            if (this.fhr.aXQ() != null && this.fhr.aXQ().aSj() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fhr.aXQ().aSj().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fhr.aUn(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aeF() {
        return this.fhB;
    }

    public boolean aXu() {
        if (this.fhr != null) {
            return this.fhr.aXu();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.fht.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eTQ.getPageActivity());
        if (am.isEmpty(str)) {
            aVar.cS(this.eTQ.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.cS(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.fht.showLoadingDialog();
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
        aVar.b(this.eTQ).th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eTQ.getPageActivity());
        aVar.cS(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eTQ).th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cS(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.eTQ).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.eTQ.getPageActivity(), 2, true, 4);
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
        aVar.b(this.eTQ).th();
    }

    public String getThreadId() {
        if (this.fhr != null) {
            return this.fhr.aUn();
        }
        return null;
    }

    public String getPostId() {
        if (this.fhr != null) {
            return this.fhr.Dy();
        }
        return null;
    }

    public int aRB() {
        if (this.fhr != null) {
            return this.fhr.aRB();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.aCt) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.aCt) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void km(boolean z) {
        if (this.feK != null && this.feK.getText() != null) {
            int selectionEnd = this.feK.getSelectionEnd();
            SpannableStringBuilder b = this.fhG.b(this.feK.getText());
            if (b != null) {
                this.fhG.nU(true);
                this.feK.setText(b);
                if (z && this.fhG.bFF() >= 0) {
                    this.feK.requestFocus();
                    this.feK.setSelection(this.fhG.bFF());
                } else {
                    this.feK.setSelection(selectionEnd);
                }
                this.fhG.nT(this.fhG.bFF() >= 0);
            }
        }
    }
}
