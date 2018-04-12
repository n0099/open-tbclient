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
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.h;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tbadk.widget.richText.e;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.pb.pb.sub.a;
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
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, e {
    private static final String fsj = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String ftE = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aWn;
    private com.baidu.adp.lib.e.b<TextView> aWo;
    private com.baidu.adp.lib.e.b<View> aWp;
    private com.baidu.adp.lib.e.b<LinearLayout> aWq;
    private com.baidu.adp.lib.e.b<RelativeLayout> aWr;
    private com.baidu.adp.lib.e.b<GifView> aWs;
    private View.OnLongClickListener axW;
    private i cXT;
    private VoiceManager cXj;
    private com.baidu.tbadk.baseEditMark.a eGw;
    public ai enV;
    private g eod;
    private b.InterfaceC0086b ffX;
    private com.baidu.adp.base.e ffg;
    private com.baidu.tbadk.core.view.b ffh;
    private PostWriteCallBackData fjB;
    private EditText fqU;
    private SubPbModel ftF;
    private ForumManageModel ftG;
    private b ftH;
    private AbsListView.OnScrollListener ftI;
    private TbRichTextView.i ftJ;
    private TbRichTextView.h ftK;
    private SubPbModel.a ftL;
    private com.baidu.adp.base.d ftM;
    private BdUniqueId ftR;
    private com.baidu.tieba.pb.pb.sub.a ftT;
    private com.baidu.tieba.write.b ftU;
    private com.baidu.tieba.pb.d<k> ftV;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int ffU = 0;
    private a.InterfaceC0082a ffQ = null;
    private a ftN = null;
    private a ftO = null;
    private boolean ftP = false;
    private boolean ftQ = false;
    private boolean ftS = false;
    private boolean aDj = false;
    private com.baidu.tbadk.editortools.pb.c aED = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Ed() {
            NewSubPbActivity.this.ftH.bbA();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aEE = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Ec() {
            if (!NewSubPbActivity.this.ftU.bAW()) {
                return (NewSubPbActivity.this.enV == null || NewSubPbActivity.this.ftF == null || NewSubPbActivity.this.ftF.aWk() == null || NewSubPbActivity.this.enV.t(NewSubPbActivity.this.ftF.aWk().replyPrivateFlag, ai.aip)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.ftU.bAY());
            if (NewSubPbActivity.this.eod.Er()) {
                NewSubPbActivity.this.eod.a(NewSubPbActivity.this.fjB);
            }
            NewSubPbActivity.this.kF(true);
            return true;
        }
    };
    private NewWriteModel.d ftW = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.eod != null && NewSubPbActivity.this.eod.DF() != null) {
                NewSubPbActivity.this.eod.DF().hide();
                if (NewSubPbActivity.this.ftF.bbU()) {
                    TiebaStatic.log(new al("c10367").ac("post_id", NewSubPbActivity.this.ftF.Ea()));
                }
            }
            if (z) {
                NewSubPbActivity.this.ftU.uB(null);
                NewSubPbActivity.this.ftU.ax(null);
                NewSubPbActivity.this.ftU.ni(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    NewSubPbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.ftU.ax(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.ftU.uB(postWriteCallBackData.getErrorString());
                if (!v.w(NewSubPbActivity.this.ftU.bAU())) {
                    NewSubPbActivity.this.fjB = postWriteCallBackData;
                    if (NewSubPbActivity.this.eod.Er()) {
                        NewSubPbActivity.this.eod.a(NewSubPbActivity.this.fjB);
                    }
                    NewSubPbActivity.this.kF(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.enV != null) {
                NewSubPbActivity.this.enV.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.ftH.bbB();
        }
    };
    private CustomMessageListener ffJ = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.ftR) {
                NewSubPbActivity.this.ftH.aas();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.ffh.i(NewSubPbActivity.this.ffg.getResources().getString(d.k.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.ffg.getResources().getString(d.k.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.gt(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.aXv();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (an.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.ffg.getResources().getString(d.k.mute_fail);
                    }
                    NewSubPbActivity.this.ffh.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener ffK = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.ftR) {
                NewSubPbActivity.this.ftH.aas();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.ffh.i(NewSubPbActivity.this.ffg.getResources().getString(d.k.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (an.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.ffg.getResources().getString(d.k.un_mute_fail);
                }
                NewSubPbActivity.this.ffh.j(muteMessage);
            }
        }
    };
    private CustomMessageListener ffL = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.ftR) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.ftH.aas();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.gJB;
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
                    NewSubPbActivity.this.ftH.a(sparseArray, z);
                }
            }
        }
    };
    boolean ffV = false;
    private CustomMessageListener dRK = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener cYl = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    h hVar = (h) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.ftF.bbO() != null && NewSubPbActivity.this.ftF.bbO().aWc() != null && NewSubPbActivity.this.ftF.bbO().aWc().rQ() != null && currentAccount.equals(NewSubPbActivity.this.ftF.bbO().aWc().rQ().getUserId()) && NewSubPbActivity.this.ftF.bbO().aWc().rQ().getPendantData() != null) {
                        NewSubPbActivity.this.ftF.bbO().aWc().rQ().getPendantData().cL(hVar.qG());
                        NewSubPbActivity.this.ftF.bbO().aWc().rQ().getPendantData().T(hVar.Dk());
                        NewSubPbActivity.this.ftH.a(NewSubPbActivity.this.ftF.bbO().aWc(), NewSubPbActivity.this.ftF.bbO().aGn(), NewSubPbActivity.this.ftF.bbO().oI(), NewSubPbActivity.this.ftF.aVE(), NewSubPbActivity.this.ftF.bcb() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void f(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        z(bundle);
        if (this.aDj) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.ffg = getPageContext();
        this.ftQ = true;
        this.ftU = new com.baidu.tieba.write.b();
        this.ftU.uM(d.C0126d.cp_cont_h_alpha85);
        this.ftU.uL(d.C0126d.cp_cont_i);
        asV();
        bbq();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bbp();
        this.ffh = new com.baidu.tbadk.core.view.b();
        this.ffh.ams = 1000L;
        registerListener(this.ffL);
        registerListener(this.ffJ);
        registerListener(this.ffK);
        this.ftR = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.ftR;
        userMuteAddAndDelCustomMessage.setTag(this.ftR);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.ftR;
        userMuteCheckCustomMessage.setTag(this.ftR);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.enV = new ai(getPageContext());
        this.enV.a(new ai.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
            @Override // com.baidu.tbadk.core.util.ai.a
            public void c(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.eod.Ew();
                }
            }
        });
    }

    private void bbp() {
        if (this.ftH != null && this.ftF != null && this.ftF.bbs()) {
            this.ftT = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.ftH.Rg());
            this.ftT.ata();
            this.ftT.a(new a.InterfaceC0196a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                private boolean djR = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0196a
                public void asW() {
                    NewSubPbActivity.this.ftH.fP(false);
                    this.djR = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0196a
                public void asX() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0196a
                public boolean asY() {
                    if (!this.djR) {
                        return NewSubPbActivity.this.ftH.atm() != null && NewSubPbActivity.this.ftH.atm().getTop() == 0;
                    }
                    this.djR = false;
                    return false;
                }
            });
            this.ftH.e(this.ftT);
            this.ftH.fP(true);
        }
    }

    public void initUI() {
        this.ftH = new b(this, this.mCommonClickListener);
        this.ftH.a(this.ftF);
        setContentView(this.ftH.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.ftH.setOnScrollListener(this.ftI);
        this.ftH.a(this);
        this.ftH.setOnLinkImageClickListener(this.ftJ);
        this.ftH.setOnImageClickListener(this.ftK);
        this.ftH.jq(true);
        this.ftH.setOnLongClickListener(this.axW);
        this.ftH.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (NewSubPbActivity.this.ftF != null) {
                    NewSubPbActivity.this.ftF.FY();
                }
            }
        });
        this.ftH.a(this.ftN);
        this.ftH.b(this.ftO);
        if (this.ftF != null && this.ftF.bbs() && !this.ftF.bca()) {
            this.ftH.bbF().setVisibility(8);
        } else {
            this.ftH.bbF().setVisibility(0);
        }
        if (this.ftF != null && !this.ftF.bbs()) {
            this.ftH.setIsFromPb(false);
        }
    }

    private boolean z(Bundle bundle) {
        if (bundle != null) {
            this.aDj = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.aDj = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.aDj;
    }

    public void initData(Bundle bundle) {
        this.ftF = new SubPbModel(getPageContext());
        this.ftF.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void k(PostData postData) {
                NewSubPbActivity.this.ftH.m(postData);
                NewSubPbActivity.this.ftH.a((BdListView.e) null);
            }
        });
        this.ftG = new ForumManageModel(this);
        this.ftG.setLoadDataCallBack(this.ftM);
        this.cXj = new VoiceManager();
        this.cXj.onCreate(getPageContext());
        this.eGw = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.eGw != null) {
            this.eGw.a(this.ffQ);
        }
        if (bundle != null) {
            this.ftF.initWithBundle(bundle);
        } else {
            this.ftF.initWithIntent(getIntent());
        }
        this.ftF.a(this.ftL);
        if (this.ftF.bbs()) {
            this.ftF.FY();
        } else {
            this.ftF.bbT();
        }
    }

    public void bbq() {
        this.ftL = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, k kVar) {
                if (NewSubPbActivity.this.ftH != null) {
                    NewSubPbActivity.this.ftH.bbB();
                }
                if (NewSubPbActivity.this.ftT != null && NewSubPbActivity.this.ftT.atb()) {
                    NewSubPbActivity.this.ftT.kM(d.C0126d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.ai(i, str);
                    return;
                }
                NewSubPbActivity.this.ftH.hideNoDataView();
                if (kVar != null) {
                    if (kVar.aWc() != null || NewSubPbActivity.this.ftF != null) {
                        kVar.aWc().a(NewSubPbActivity.this.ftF.bbZ());
                    }
                    if (NewSubPbActivity.this.ftH != null) {
                        NewSubPbActivity.this.ftH.a(kVar, NewSubPbActivity.this.ftF.aVE(), NewSubPbActivity.this.ftF.bcb() != null);
                        if (NewSubPbActivity.this.ftQ) {
                            NewSubPbActivity.this.bbr();
                            NewSubPbActivity.this.ftQ = false;
                        }
                    }
                    if (NewSubPbActivity.this.eod != null) {
                        NewSubPbActivity.this.eod.a(kVar.aWk());
                    }
                    if (NewSubPbActivity.this.ftV == null) {
                        NewSubPbActivity.this.ftV = new com.baidu.tieba.pb.d();
                    }
                    NewSubPbActivity.this.ftV.setData(kVar);
                    NewSubPbActivity.this.ftV.setType(0);
                    NewSubPbActivity.this.enV.a(NewSubPbActivity.this.ftF.bcf());
                }
            }
        };
        this.ffQ = new a.InterfaceC0082a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0082a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.eGw != null) {
                        NewSubPbActivity.this.eGw.ae(z2);
                    }
                    MarkData oL = NewSubPbActivity.this.eGw.oL();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setType(2);
                    if (z2) {
                        dVar.setData(oL);
                        if (NewSubPbActivity.this.eGw != null) {
                            if (oL != null) {
                                NewSubPbActivity.this.ftF.kJ(true);
                                NewSubPbActivity.this.ftF.qS(NewSubPbActivity.this.ftF.Ea());
                                NewSubPbActivity.this.showToast(d.k.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.k.add_mark));
                            }
                            if (NewSubPbActivity.this.ftH != null) {
                                NewSubPbActivity.this.ftH.kG(true);
                            }
                        }
                    } else {
                        dVar.setData(null);
                        NewSubPbActivity.this.ftF.kJ(false);
                        NewSubPbActivity.this.ftF.qS(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.k.remove_mark));
                        if (NewSubPbActivity.this.ftH != null) {
                            NewSubPbActivity.this.ftH.kG(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.k.update_mark_failed));
            }
        };
        this.ftN = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.ftF.bbO() != null && NewSubPbActivity.this.ftF.bbO().Pe() != null && NewSubPbActivity.this.ftF.bbO().Pe().rQ() != null) {
                    str = String.valueOf(NewSubPbActivity.this.ftF.bbO().Pe().rQ().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.ftF.bbO().aWj().getId(), NewSubPbActivity.this.ftF.bbO().aWj().getName(), NewSubPbActivity.this.ftF.bbO().Pe().getId(), str, str2, str3)));
            }
        };
        this.ftO = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.ftG.bsK() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.ftF != null && NewSubPbActivity.this.ftF.bbO() != null && NewSubPbActivity.this.ftF.bbO().aWj() != null && NewSubPbActivity.this.ftF.bbO().Pe() != null) {
                            NewSubPbActivity.this.ftG.a(NewSubPbActivity.this.ftF.bbO().aWj().getId(), NewSubPbActivity.this.ftF.bbO().aWj().getName(), NewSubPbActivity.this.ftF.bbO().Pe().getId(), valueOf, g2, g, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.k.login_to_use), true, 11017)));
            }
        };
        this.ftM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.ftH.a(NewSubPbActivity.this.ftG.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.ftG.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.fuJ != 1002 || bVar.dxu) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.ftH.a(1, dVar.yR, dVar.gyO, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void asV() {
        registerListener(this.cYl);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 != null || NewSubPbActivity.this.ftH != null) {
                    if (view2 == NewSubPbActivity.this.ftH.bbL()) {
                        NewSubPbActivity.this.ftH.bar();
                        String str = view2.getTag(d.g.tag_user_id) instanceof String ? (String) view2.getTag(d.g.tag_user_id) : null;
                        String str2 = view2.getTag(d.g.tag_user_name) instanceof String ? (String) view2.getTag(d.g.tag_user_name) : null;
                        String str3 = view2.getTag(d.g.tag_virtual_user_url) instanceof String ? (String) view2.getTag(d.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ax.wg().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view2 != NewSubPbActivity.this.ftH.atn()) {
                        if (view2 != NewSubPbActivity.this.ftH.bbE()) {
                            if (view2 != NewSubPbActivity.this.ftH.bbD()) {
                                if (view2 == NewSubPbActivity.this.ftH.bbz()) {
                                    NewSubPbActivity.this.ftH.bar();
                                    if (NewSubPbActivity.this.ftF.FY()) {
                                        NewSubPbActivity.this.ftH.bbx();
                                    }
                                } else if (view2 == NewSubPbActivity.this.ftH.bbF() || view2 == NewSubPbActivity.this.ftH.bbG() || view2 == NewSubPbActivity.this.ftH.bbI()) {
                                    if (NewSubPbActivity.this.ftS) {
                                        NewSubPbActivity.this.ftS = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.ftF.aYj(), NewSubPbActivity.this.ftF.Ea(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.ftF.bce())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.ftF.bce());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.ftH.bbJ() == null || view2 != NewSubPbActivity.this.ftH.bbJ().aYV()) {
                                    if (NewSubPbActivity.this.ftH.bbJ() == null || view2 != NewSubPbActivity.this.ftH.bbJ().aZa()) {
                                        if (NewSubPbActivity.this.ftH.bbJ() == null || view2 != NewSubPbActivity.this.ftH.bbJ().aYY()) {
                                            if (NewSubPbActivity.this.ftH.bbJ() == null || view2 != NewSubPbActivity.this.ftH.bbJ().aYW()) {
                                                if (NewSubPbActivity.this.ftH.bbJ() == null || view2 != NewSubPbActivity.this.ftH.bbJ().aYX()) {
                                                    if ((view2 == NewSubPbActivity.this.ftH.bbC() || view2 == NewSubPbActivity.this.ftH.bbI()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.eod.Ez()) {
                                                            NewSubPbActivity.this.eod.EA();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.eod.gu(null);
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                                TiebaStatic.log(new al("c11739").r("obj_locate", 4));
                                                if (!j.gP()) {
                                                    NewSubPbActivity.this.showToast(d.k.network_not_available);
                                                    return;
                                                }
                                                Object tag = view2.getTag();
                                                NewSubPbActivity.this.ftH.bar();
                                                if (tag instanceof String) {
                                                    String Ea = NewSubPbActivity.this.ftF.Ea();
                                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                        NewSubPbActivity.this.qs(Ea);
                                                        return;
                                                    }
                                                    return;
                                                } else if (tag instanceof SparseArray) {
                                                    SparseArray<Object> sparseArray = (SparseArray) tag;
                                                    if ((sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue()) {
                                                        sparseArray.put(d.g.tag_from, 0);
                                                        NewSubPbActivity.this.b(sparseArray);
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else if (j.gP()) {
                                                NewSubPbActivity.this.ftH.bar();
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.bi(view2);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                NewSubPbActivity.this.showToast(d.k.network_not_available);
                                                return;
                                            }
                                        }
                                        NewSubPbActivity.this.ftH.bar();
                                        SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.ftH.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new al("c11739").r("obj_locate", 1));
                                    NewSubPbActivity.this.ftH.bar();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.eod.gu(null);
                                        if (NewSubPbActivity.this.ftT != null) {
                                            NewSubPbActivity.this.ftT.asZ();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new al("c11739").r("obj_locate", 2));
                                    NewSubPbActivity.this.ftH.bar();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.ftF.bbO() != null) {
                                        NewSubPbActivity.this.e(NewSubPbActivity.this.ftF.bbO().aWc());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.ftH.bbu();
                                NewSubPbActivity.this.ftH.bbv();
                                if (NewSubPbActivity.this.eod != null) {
                                    NewSubPbActivity.this.eod.EC();
                                    if (NewSubPbActivity.this.ftT != null) {
                                        NewSubPbActivity.this.ftT.asZ();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.ftH.bbu();
                            NewSubPbActivity.this.ftH.bbv();
                            if (NewSubPbActivity.this.eod != null) {
                                NewSubPbActivity.this.eod.EB();
                                if (NewSubPbActivity.this.ftT != null) {
                                    NewSubPbActivity.this.ftT.asZ();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.enV == null || NewSubPbActivity.this.ftF == null || NewSubPbActivity.this.ftF.aWk() == null || NewSubPbActivity.this.enV.cK(NewSubPbActivity.this.ftF.aWk().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.eod.Er()) {
                                NewSubPbActivity.this.eod.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.ftH.bbu();
                            NewSubPbActivity.this.ftH.bbv();
                            if (NewSubPbActivity.this.eod != null) {
                                NewSubPbActivity.this.eod.ED();
                                if (NewSubPbActivity.this.ftT != null) {
                                    NewSubPbActivity.this.ftT.asZ();
                                }
                            }
                        }
                    }
                }
            }
        };
        this.ftI = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.ftH.bar();
                }
                NewSubPbActivity.this.eod.EA();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.ftH.bbK();
            }
        };
        this.ffX = new b.InterfaceC0086b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.ftF.bbO() != null) {
                    postData = NewSubPbActivity.this.ftF.bbO().aWc();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.bY(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.e(postData);
                    }
                }
            }
        };
        this.axW = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                SparseArray sparseArray;
                try {
                    sparseArray = (SparseArray) view2.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    NewSubPbActivity.this.ftH.b(NewSubPbActivity.this.ffX, NewSubPbActivity.this.ftF.isMarked());
                }
                return true;
            }
        };
        this.ftJ = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void b(View view2, String str) {
                NewSubPbActivity.this.k(null, str, "LINK_IMAGE");
            }
        };
        this.ftK = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
            /* JADX DEBUG: Multi-variable search result rejected for r2v17, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX DEBUG: Multi-variable search result rejected for r2v42, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
            public void a(View view2, String str, int i, boolean z) {
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
                    k bbO = NewSubPbActivity.this.ftF.bbO();
                    TbRichText aB = NewSubPbActivity.this.aB(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (aB != null && aB.JJ() != null) {
                        tbRichTextData = aB.JJ().get(NewSubPbActivity.this.ffU);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.JP().Kb()) {
                            String b = NewSubPbActivity.this.b(tbRichTextData);
                            arrayList2.add(b);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                            concurrentHashMap3.put(b, imageUrlData);
                            String str4 = null;
                            String str5 = null;
                            String str6 = null;
                            if (bbO == null) {
                                str3 = null;
                                z4 = false;
                            } else {
                                if (bbO.aWj() != null) {
                                    str4 = bbO.aWj().getName();
                                    str5 = bbO.aWj().getId();
                                }
                                if (bbO.Pe() != null) {
                                    str6 = bbO.Pe().getId();
                                }
                                str3 = str6;
                                z4 = true;
                            }
                            if (NewSubPbActivity.this.ftF.bcb() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.ftF.bcb();
                                z5 = NewSubPbActivity.this.ftF.bcd();
                                arrayList2 = NewSubPbActivity.this.ftF.bcc();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z5 = z4;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(v.c(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.ffV = false;
                        String str7 = "";
                        TbRichText bsb = bbO.aWc().bsb();
                        int size = arrayList2.size();
                        int a2 = NewSubPbActivity.this.a(bsb, aB, i, i, arrayList2, concurrentHashMap3);
                        int size2 = arrayList2.size();
                        if (size != size2) {
                            str7 = arrayList2.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (bbO == null) {
                            str2 = null;
                            z2 = false;
                        } else {
                            if (bbO.aWj() != null) {
                                str8 = bbO.aWj().getName();
                                str9 = bbO.aWj().getId();
                            }
                            if (bbO.Pe() != null) {
                                str10 = bbO.Pe().getId();
                            }
                            str2 = str10;
                            z2 = true;
                        }
                        if (NewSubPbActivity.this.ftF.bcb() != null) {
                            concurrentHashMap = NewSubPbActivity.this.ftF.bcb();
                            z3 = NewSubPbActivity.this.ftF.bcd();
                            arrayList = NewSubPbActivity.this.ftF.bcc();
                            i2 = a2 + NewSubPbActivity.this.ftF.getOffset();
                        } else {
                            concurrentHashMap = concurrentHashMap3;
                            i2 = a2;
                            z3 = z2;
                            arrayList = arrayList2;
                        }
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.add(v.c(arrayList, i2));
                        NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList4, 0, str8, str9, str2, z3, str7, true, concurrentHashMap, true, false, false)));
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
        TbRichTextImageInfo JP;
        if (tbRichText == tbRichText2) {
            this.ffV = true;
        }
        if (tbRichText != null && tbRichText.JJ() != null) {
            int size = tbRichText.JJ().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.JJ().get(i6) != null && tbRichText.JJ().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.JJ().get(i6).JP().getWidth();
                    int height = tbRichText.JJ().get(i6).JP().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.JJ().get(i6).JP().Kb()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.JJ().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (JP = tbRichTextData.JP()) != null) {
                            String Kc = JP.Kc();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Kc;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.ffV) {
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
        TbRichTextImageInfo JP = tbRichTextData.JP();
        if (JP != null) {
            if (!StringUtils.isNull(JP.Ka())) {
                return JP.Ka();
            }
            if (JP.getHeight() * JP.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (JP.getHeight() * JP.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (JP.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * JP.getHeight())));
            } else {
                float width = JP.getWidth() / JP.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(an.aS(JP.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aB(String str, int i) {
        if (this.ftF == null || this.ftF.bbO() == null || str == null || i < 0) {
            return null;
        }
        k bbO = this.ftF.bbO();
        TbRichText a2 = a(bbO.aWc(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bbO.aWc(), str, i);
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
        TbRichText bsb = postData.bsb();
        if (bsb != null) {
            ArrayList<TbRichTextData> JJ = bsb.JJ();
            int size = JJ.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (JJ.get(i3) != null && JJ.get(i3).getType() == 8) {
                    i2++;
                    if (JJ.get(i3).JP().Kc().equals(str)) {
                        int width = JJ.get(i3).JP().getWidth();
                        int height = JJ.get(i3).JP().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.ffU = i3;
                        return bsb;
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
        long templateId = this.ftF.bbO().aWc().bsi() != null ? this.ftF.bbO().aWc().bsi().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ax.wg().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.ftF.bbO().aWj().getId(), this.ftF.bbO().aWj().getName(), this.ftF.bbO().Pe().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(int i, String str) {
        if (this.ftF.bbP()) {
            showToast(str);
        } else if (l.hg()) {
            if (i == 4) {
                this.ftH.lW(str + "(4)");
            } else {
                this.ftH.ik(d.k.no_data_text);
            }
        } else {
            this.ftH.ik(d.k.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.eod = (g) new com.baidu.tbadk.editortools.pb.h().aO(getActivity());
        if (this.eod != null) {
            this.eod.setContext(getPageContext());
            this.eod.b(this.ftF);
            this.eod.b(this.ftW);
            this.eod.a(this.aED);
            this.eod.a(this.aEE);
            this.eod.DF().bx(true);
            this.eod.d(getPageContext());
        }
        if (this.ftH != null) {
            this.ftH.g(this.eod);
        }
        if (this.eod != null && this.ftF != null) {
            this.eod.a(this.ftF.aWk());
            this.eod.EA();
        }
        if (this.eod != null) {
            this.fqU = this.eod.EE().getInputView();
            this.fqU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.ftU != null) {
                        if (!NewSubPbActivity.this.ftU.bAX()) {
                            NewSubPbActivity.this.kF(false);
                        }
                        NewSubPbActivity.this.ftU.nj(false);
                    }
                }
            });
        }
    }

    public void bbr() {
        if (!TbadkCoreApplication.isLogin()) {
            this.eod.EA();
        } else if (!StringUtils.isNull(this.ftF.bbW())) {
            this.ftH.qO(this.ftF.bbW());
            if (this.ftH.bby() && l.hg()) {
                this.ftH.amL();
            } else {
                this.ftH.bbB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(View view2) {
        SparseArray<Object> sparseArray;
        if (view2 != null && (sparseArray = (SparseArray) view2.getTag()) != null) {
            boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(d.g.tag_from, 1);
                    b(sparseArray);
                } else {
                    this.ftH.be(view2);
                }
            } else if (booleanValue2) {
                this.ftH.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.ftH.bbH(), getPageContext().getPageActivity());
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
            strArr2[0] = getResources().getString(d.k.delete);
            if (z) {
                string = getResources().getString(d.k.un_mute);
            } else {
                string = getResources().getString(d.k.mute);
            }
            strArr2[1] = string;
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(d.k.delete)};
        }
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.cd(d.k.operation);
        bVar.a(strArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view2) {
                switch (i) {
                    case 0:
                        String str2 = "";
                        int intValue = sparseArray.get(d.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue() : 0;
                        if (sparseArray.get(d.g.tag_del_post_id) instanceof String) {
                            str2 = (String) sparseArray.get(d.g.tag_del_post_id);
                        }
                        NewSubPbActivity.this.ftH.a(intValue, str2, sparseArray.get(d.g.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue() : false);
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
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.ftR);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.ftR);
                        NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str6, str3);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext()).tG();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
        }
        this.ftH.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.ftR;
        userMuteCheckCustomMessage.setTag(this.ftR);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.ftH.a(0, bVar.yR, bVar.gyO, z);
            if (bVar.yR) {
                if (bVar.gyM == 1) {
                    finish();
                } else if (bVar.gyM == 2) {
                    this.ftF.qR(bVar.mPostId);
                    this.ftH.a(this.ftF.bbO(), this.ftF.aVE(), this.ftF.bcb() != null);
                    if (this.ftF.bbX()) {
                        this.ftF.kK(false);
                        this.ftH.bbw();
                        this.ftF.FY();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
            }
        }
    }

    public void qs(String str) {
        if (!StringUtils.isNull(str) && this.ftF != null) {
            String aYj = this.ftF.aYj();
            String Ea = this.ftF.Ea();
            sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.k.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Ea + "&tid=" + aYj + "&pid=" + str, true)));
        }
    }

    public void e(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.ftF.isMarked() && postData.getId() != null && postData.getId().equals(this.ftF.bbV())) {
                z = true;
            }
            MarkData g = this.ftF.g(postData);
            if (g != null) {
                this.ftH.bar();
                if (this.eGw != null) {
                    this.eGw.a(g);
                    if (!z) {
                        this.eGw.oK();
                    } else {
                        this.eGw.oJ();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.ftF != null) {
            this.ftF.y(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.eod != null) {
            this.eod.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.eod.DF().Ca();
        this.eod.EA();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eod.b(writeData);
                this.eod.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k eI = this.eod.DF().eI(6);
                if (eI != null && eI.aCM != null) {
                    eI.aCM.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eod.Ew();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cXj != null) {
            this.cXj.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.ftP = true;
        super.onPause();
        if (this.cXj != null) {
            this.cXj.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dRK);
        this.ftH.asb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.ftP = false;
        super.onResume();
        if (this.cXj != null) {
            this.cXj.onResume(getPageContext());
        }
        registerListener(this.dRK);
        this.ftH.asc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cXj != null) {
            this.cXj.onStop(getPageContext());
        }
        this.eod.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.ftV));
        this.ftF.cancelLoadData();
        this.ftF.destory();
        this.ftG.cancelLoadData();
        if (this.cXj != null) {
            this.cXj.onDestory(getPageContext());
        }
        this.ftH.bar();
        this.ftH.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.ffJ);
        MessageManager.getInstance().unRegisterListener(this.ffK);
        MessageManager.getInstance().unRegisterListener(this.ffL);
        MessageManager.getInstance().unRegisterListener(this.ftR);
        this.ffg = null;
        this.ffh = null;
        if (this.cXT != null) {
            this.cXT.onDestroy();
        }
        if (this.enV != null) {
            this.enV.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ftH.onChangeSkinType(i);
        if (this.cXT != null) {
            this.cXT.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cXj;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bbC = this.ftH.bbC();
        if (bbC == null || (findViewWithTag = bbC.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean qH(String str) {
        Map<String, String> ep;
        if (!TextUtils.isEmpty(str) && (ep = ax.ep(ax.eq(str))) != null) {
            this.ftS = true;
            String str2 = ep.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return qH(com.baidu.adp.lib.util.k.aT(str2));
            }
            String str3 = ep.get(ftE);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void T(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (qH(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            ax.wg().c(getPageContext(), new String[]{str});
            this.ftS = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void S(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.ftS = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void U(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void W(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void g(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.ftH != null) {
            return this.ftH.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Ko() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Kq() {
        if (this.aWo == null) {
            this.aWo = TbRichTextView.j(getPageContext().getPageActivity(), 8);
        }
        return this.aWo;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Kr() {
        if (this.aWs == null) {
            this.aWs = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aXA */
                public GifView fo() {
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
        return this.aWs;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Kp() {
        if (this.aWn == null) {
            this.aWn = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: abw */
                public ImageView fo() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean qe = com.baidu.tbadk.core.i.pY().qe();
                    foreDrawableImageView.setDefaultBg(ak.getDrawable(d.C0126d.common_color_10220));
                    if (qe) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0126d.cp_bg_line_c);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView o(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.pY().qe()) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0126d.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.aWn;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Ks() {
        if (this.aWp == null) {
            this.aWp = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aXB */
                public View fo() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aZ */
                public void n(View view2) {
                    ((PlayVoiceBntNew) view2).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: ba */
                public View o(View view2) {
                    return view2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bb */
                public View p(View view2) {
                    ((PlayVoiceBntNew) view2).reset();
                    return view2;
                }
            }, 8, 0);
        }
        return this.aWp;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Kt() {
        if (this.aWq == null) {
            this.aWq = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aXD */
                public LinearLayout fo() {
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
        return this.aWq;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Ku() {
        this.aWr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aXC */
            public RelativeLayout fo() {
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
        return this.aWr;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.ftH.bby() && l.hg()) {
            this.ftF.FY();
        } else {
            this.ftH.bbB();
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
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.ftR);
        userMuteAddAndDelCustomMessage.setTag(this.ftR);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
        k(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean Go() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Gp() {
                return com.baidu.tbadk.pageStayDuration.e.Gt().Gv();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.ftF != null) {
            if (this.ftF.bbO() != null && this.ftF.bbO().aWj() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.ftF.bbO().aWj().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.ftF.aYj(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.ftP;
    }

    public boolean bbs() {
        if (this.ftF != null) {
            return this.ftF.bbs();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.ftH.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ffg.getPageActivity());
        if (an.isEmpty(str)) {
            aVar.dc(this.ffg.getResources().getString(d.k.block_mute_message_alert, str2));
        } else {
            aVar.dc(str);
        }
        aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.ftH.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.ffg).tD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gt(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ffg.getPageActivity());
        aVar.dc(str);
        aVar.b(d.k.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.ffg).tD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXv() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dc(getResources().getString(d.k.mute_is_super_member_function));
        aVar.a(d.k.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.ffg).showToast(d.k.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.ffg.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.ffg).tD();
    }

    public String getThreadId() {
        if (this.ftF != null) {
            return this.ftF.aYj();
        }
        return null;
    }

    public String getPostId() {
        if (this.ftF != null) {
            return this.ftF.Ea();
        }
        return null;
    }

    public int aVE() {
        if (this.ftF != null) {
            return this.ftF.aVE();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.aDj) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.aDj) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void kF(boolean z) {
        if (this.fqU != null && this.fqU.getText() != null) {
            int selectionEnd = this.fqU.getSelectionEnd();
            SpannableStringBuilder b = this.ftU.b(this.fqU.getText());
            if (b != null) {
                this.ftU.nj(true);
                this.fqU.setText(b);
                if (z && this.ftU.bAV() >= 0) {
                    this.fqU.requestFocus();
                    this.fqU.setSelection(this.ftU.bAV());
                } else {
                    this.fqU.setSelection(selectionEnd);
                }
                this.ftU.ni(this.ftU.bAV() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.cXT == null) {
            this.cXT = new i(getPageContext());
        }
        this.cXT.a(contriInfo, -1L);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.eod != null && this.eod.DF() != null && this.eod.DF().DI()) {
            this.eod.DF().Ca();
        } else {
            super.onBackPressed();
        }
    }
}
