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
    private static final String fsg = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String ftB = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aWn;
    private com.baidu.adp.lib.e.b<TextView> aWo;
    private com.baidu.adp.lib.e.b<View> aWp;
    private com.baidu.adp.lib.e.b<LinearLayout> aWq;
    private com.baidu.adp.lib.e.b<RelativeLayout> aWr;
    private com.baidu.adp.lib.e.b<GifView> aWs;
    private View.OnLongClickListener axW;
    private i cXQ;
    private VoiceManager cXg;
    private com.baidu.tbadk.baseEditMark.a eGt;
    public ai enS;
    private g eoa;
    private b.InterfaceC0086b ffU;
    private com.baidu.adp.base.e ffd;
    private com.baidu.tbadk.core.view.b ffe;
    private PostWriteCallBackData fjy;
    private EditText fqR;
    private SubPbModel ftC;
    private ForumManageModel ftD;
    private b ftE;
    private AbsListView.OnScrollListener ftF;
    private TbRichTextView.i ftG;
    private TbRichTextView.h ftH;
    private SubPbModel.a ftI;
    private com.baidu.adp.base.d ftJ;
    private BdUniqueId ftO;
    private com.baidu.tieba.pb.pb.sub.a ftQ;
    private com.baidu.tieba.write.b ftR;
    private com.baidu.tieba.pb.d<k> ftS;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int ffR = 0;
    private a.InterfaceC0082a ffN = null;
    private a ftK = null;
    private a ftL = null;
    private boolean ftM = false;
    private boolean ftN = false;
    private boolean ftP = false;
    private boolean aDj = false;
    private com.baidu.tbadk.editortools.pb.c aED = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Ed() {
            NewSubPbActivity.this.ftE.bbA();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aEE = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Ec() {
            if (!NewSubPbActivity.this.ftR.bAW()) {
                return (NewSubPbActivity.this.enS == null || NewSubPbActivity.this.ftC == null || NewSubPbActivity.this.ftC.aWk() == null || NewSubPbActivity.this.enS.t(NewSubPbActivity.this.ftC.aWk().replyPrivateFlag, ai.aip)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.ftR.bAY());
            if (NewSubPbActivity.this.eoa.Er()) {
                NewSubPbActivity.this.eoa.a(NewSubPbActivity.this.fjy);
            }
            NewSubPbActivity.this.kF(true);
            return true;
        }
    };
    private NewWriteModel.d ftT = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.eoa != null && NewSubPbActivity.this.eoa.DF() != null) {
                NewSubPbActivity.this.eoa.DF().hide();
                if (NewSubPbActivity.this.ftC.bbU()) {
                    TiebaStatic.log(new al("c10367").ac("post_id", NewSubPbActivity.this.ftC.Ea()));
                }
            }
            if (z) {
                NewSubPbActivity.this.ftR.uB(null);
                NewSubPbActivity.this.ftR.ax(null);
                NewSubPbActivity.this.ftR.ni(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    NewSubPbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.ftR.ax(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.ftR.uB(postWriteCallBackData.getErrorString());
                if (!v.w(NewSubPbActivity.this.ftR.bAU())) {
                    NewSubPbActivity.this.fjy = postWriteCallBackData;
                    if (NewSubPbActivity.this.eoa.Er()) {
                        NewSubPbActivity.this.eoa.a(NewSubPbActivity.this.fjy);
                    }
                    NewSubPbActivity.this.kF(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.enS != null) {
                NewSubPbActivity.this.enS.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.ftE.bbB();
        }
    };
    private CustomMessageListener ffG = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.ftO) {
                NewSubPbActivity.this.ftE.aas();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.ffe.i(NewSubPbActivity.this.ffd.getResources().getString(d.k.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.ffd.getResources().getString(d.k.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.gt(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.aXv();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (an.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.ffd.getResources().getString(d.k.mute_fail);
                    }
                    NewSubPbActivity.this.ffe.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener ffH = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.ftO) {
                NewSubPbActivity.this.ftE.aas();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.ffe.i(NewSubPbActivity.this.ffd.getResources().getString(d.k.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (an.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.ffd.getResources().getString(d.k.un_mute_fail);
                }
                NewSubPbActivity.this.ffe.j(muteMessage);
            }
        }
    };
    private CustomMessageListener ffI = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.ftO) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.ftE.aas();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.gJy;
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
                    NewSubPbActivity.this.ftE.a(sparseArray, z);
                }
            }
        }
    };
    boolean ffS = false;
    private CustomMessageListener dRH = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener cYi = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    h hVar = (h) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.ftC.bbO() != null && NewSubPbActivity.this.ftC.bbO().aWc() != null && NewSubPbActivity.this.ftC.bbO().aWc().rQ() != null && currentAccount.equals(NewSubPbActivity.this.ftC.bbO().aWc().rQ().getUserId()) && NewSubPbActivity.this.ftC.bbO().aWc().rQ().getPendantData() != null) {
                        NewSubPbActivity.this.ftC.bbO().aWc().rQ().getPendantData().cL(hVar.qG());
                        NewSubPbActivity.this.ftC.bbO().aWc().rQ().getPendantData().T(hVar.Dk());
                        NewSubPbActivity.this.ftE.a(NewSubPbActivity.this.ftC.bbO().aWc(), NewSubPbActivity.this.ftC.bbO().aGn(), NewSubPbActivity.this.ftC.bbO().oI(), NewSubPbActivity.this.ftC.aVE(), NewSubPbActivity.this.ftC.bcb() != null);
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
        this.ffd = getPageContext();
        this.ftN = true;
        this.ftR = new com.baidu.tieba.write.b();
        this.ftR.uL(d.C0126d.cp_cont_h_alpha85);
        this.ftR.uK(d.C0126d.cp_cont_i);
        asV();
        bbq();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bbp();
        this.ffe = new com.baidu.tbadk.core.view.b();
        this.ffe.ams = 1000L;
        registerListener(this.ffI);
        registerListener(this.ffG);
        registerListener(this.ffH);
        this.ftO = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.ftO;
        userMuteAddAndDelCustomMessage.setTag(this.ftO);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.ftO;
        userMuteCheckCustomMessage.setTag(this.ftO);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.enS = new ai(getPageContext());
        this.enS.a(new ai.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
            @Override // com.baidu.tbadk.core.util.ai.a
            public void c(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.eoa.Ew();
                }
            }
        });
    }

    private void bbp() {
        if (this.ftE != null && this.ftC != null && this.ftC.bbs()) {
            this.ftQ = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.ftE.Rg());
            this.ftQ.ata();
            this.ftQ.a(new a.InterfaceC0196a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                private boolean djO = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0196a
                public void asW() {
                    NewSubPbActivity.this.ftE.fP(false);
                    this.djO = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0196a
                public void asX() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0196a
                public boolean asY() {
                    if (!this.djO) {
                        return NewSubPbActivity.this.ftE.atm() != null && NewSubPbActivity.this.ftE.atm().getTop() == 0;
                    }
                    this.djO = false;
                    return false;
                }
            });
            this.ftE.e(this.ftQ);
            this.ftE.fP(true);
        }
    }

    public void initUI() {
        this.ftE = new b(this, this.mCommonClickListener);
        this.ftE.a(this.ftC);
        setContentView(this.ftE.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.ftE.setOnScrollListener(this.ftF);
        this.ftE.a(this);
        this.ftE.setOnLinkImageClickListener(this.ftG);
        this.ftE.setOnImageClickListener(this.ftH);
        this.ftE.jq(true);
        this.ftE.setOnLongClickListener(this.axW);
        this.ftE.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (NewSubPbActivity.this.ftC != null) {
                    NewSubPbActivity.this.ftC.FY();
                }
            }
        });
        this.ftE.a(this.ftK);
        this.ftE.b(this.ftL);
        if (this.ftC != null && this.ftC.bbs() && !this.ftC.bca()) {
            this.ftE.bbF().setVisibility(8);
        } else {
            this.ftE.bbF().setVisibility(0);
        }
        if (this.ftC != null && !this.ftC.bbs()) {
            this.ftE.setIsFromPb(false);
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
        this.ftC = new SubPbModel(getPageContext());
        this.ftC.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void k(PostData postData) {
                NewSubPbActivity.this.ftE.m(postData);
                NewSubPbActivity.this.ftE.a((BdListView.e) null);
            }
        });
        this.ftD = new ForumManageModel(this);
        this.ftD.setLoadDataCallBack(this.ftJ);
        this.cXg = new VoiceManager();
        this.cXg.onCreate(getPageContext());
        this.eGt = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.eGt != null) {
            this.eGt.a(this.ffN);
        }
        if (bundle != null) {
            this.ftC.initWithBundle(bundle);
        } else {
            this.ftC.initWithIntent(getIntent());
        }
        this.ftC.a(this.ftI);
        if (this.ftC.bbs()) {
            this.ftC.FY();
        } else {
            this.ftC.bbT();
        }
    }

    public void bbq() {
        this.ftI = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, k kVar) {
                if (NewSubPbActivity.this.ftE != null) {
                    NewSubPbActivity.this.ftE.bbB();
                }
                if (NewSubPbActivity.this.ftQ != null && NewSubPbActivity.this.ftQ.atb()) {
                    NewSubPbActivity.this.ftQ.kL(d.C0126d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.ai(i, str);
                    return;
                }
                NewSubPbActivity.this.ftE.hideNoDataView();
                if (kVar != null) {
                    if (kVar.aWc() != null || NewSubPbActivity.this.ftC != null) {
                        kVar.aWc().a(NewSubPbActivity.this.ftC.bbZ());
                    }
                    if (NewSubPbActivity.this.ftE != null) {
                        NewSubPbActivity.this.ftE.a(kVar, NewSubPbActivity.this.ftC.aVE(), NewSubPbActivity.this.ftC.bcb() != null);
                        if (NewSubPbActivity.this.ftN) {
                            NewSubPbActivity.this.bbr();
                            NewSubPbActivity.this.ftN = false;
                        }
                    }
                    if (NewSubPbActivity.this.eoa != null) {
                        NewSubPbActivity.this.eoa.a(kVar.aWk());
                    }
                    if (NewSubPbActivity.this.ftS == null) {
                        NewSubPbActivity.this.ftS = new com.baidu.tieba.pb.d();
                    }
                    NewSubPbActivity.this.ftS.setData(kVar);
                    NewSubPbActivity.this.ftS.setType(0);
                    NewSubPbActivity.this.enS.a(NewSubPbActivity.this.ftC.bcf());
                }
            }
        };
        this.ffN = new a.InterfaceC0082a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0082a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.eGt != null) {
                        NewSubPbActivity.this.eGt.ae(z2);
                    }
                    MarkData oL = NewSubPbActivity.this.eGt.oL();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setType(2);
                    if (z2) {
                        dVar.setData(oL);
                        if (NewSubPbActivity.this.eGt != null) {
                            if (oL != null) {
                                NewSubPbActivity.this.ftC.kJ(true);
                                NewSubPbActivity.this.ftC.qS(NewSubPbActivity.this.ftC.Ea());
                                NewSubPbActivity.this.showToast(d.k.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.k.add_mark));
                            }
                            if (NewSubPbActivity.this.ftE != null) {
                                NewSubPbActivity.this.ftE.kG(true);
                            }
                        }
                    } else {
                        dVar.setData(null);
                        NewSubPbActivity.this.ftC.kJ(false);
                        NewSubPbActivity.this.ftC.qS(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.k.remove_mark));
                        if (NewSubPbActivity.this.ftE != null) {
                            NewSubPbActivity.this.ftE.kG(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.k.update_mark_failed));
            }
        };
        this.ftK = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.ftC.bbO() != null && NewSubPbActivity.this.ftC.bbO().Pe() != null && NewSubPbActivity.this.ftC.bbO().Pe().rQ() != null) {
                    str = String.valueOf(NewSubPbActivity.this.ftC.bbO().Pe().rQ().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.ftC.bbO().aWj().getId(), NewSubPbActivity.this.ftC.bbO().aWj().getName(), NewSubPbActivity.this.ftC.bbO().Pe().getId(), str, str2, str3)));
            }
        };
        this.ftL = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.ftD.bsK() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.ftC != null && NewSubPbActivity.this.ftC.bbO() != null && NewSubPbActivity.this.ftC.bbO().aWj() != null && NewSubPbActivity.this.ftC.bbO().Pe() != null) {
                            NewSubPbActivity.this.ftD.a(NewSubPbActivity.this.ftC.bbO().aWj().getId(), NewSubPbActivity.this.ftC.bbO().aWj().getName(), NewSubPbActivity.this.ftC.bbO().Pe().getId(), valueOf, g2, g, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.k.login_to_use), true, 11017)));
            }
        };
        this.ftJ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.ftE.a(NewSubPbActivity.this.ftD.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.ftD.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.fuG != 1002 || bVar.dxr) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.ftE.a(1, dVar.yR, dVar.gyL, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void asV() {
        registerListener(this.cYi);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 != null || NewSubPbActivity.this.ftE != null) {
                    if (view2 == NewSubPbActivity.this.ftE.bbL()) {
                        NewSubPbActivity.this.ftE.bar();
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
                    } else if (view2 != NewSubPbActivity.this.ftE.atn()) {
                        if (view2 != NewSubPbActivity.this.ftE.bbE()) {
                            if (view2 != NewSubPbActivity.this.ftE.bbD()) {
                                if (view2 == NewSubPbActivity.this.ftE.bbz()) {
                                    NewSubPbActivity.this.ftE.bar();
                                    if (NewSubPbActivity.this.ftC.FY()) {
                                        NewSubPbActivity.this.ftE.bbx();
                                    }
                                } else if (view2 == NewSubPbActivity.this.ftE.bbF() || view2 == NewSubPbActivity.this.ftE.bbG() || view2 == NewSubPbActivity.this.ftE.bbI()) {
                                    if (NewSubPbActivity.this.ftP) {
                                        NewSubPbActivity.this.ftP = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.ftC.aYj(), NewSubPbActivity.this.ftC.Ea(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.ftC.bce())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.ftC.bce());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.ftE.bbJ() == null || view2 != NewSubPbActivity.this.ftE.bbJ().aYV()) {
                                    if (NewSubPbActivity.this.ftE.bbJ() == null || view2 != NewSubPbActivity.this.ftE.bbJ().aZa()) {
                                        if (NewSubPbActivity.this.ftE.bbJ() == null || view2 != NewSubPbActivity.this.ftE.bbJ().aYY()) {
                                            if (NewSubPbActivity.this.ftE.bbJ() == null || view2 != NewSubPbActivity.this.ftE.bbJ().aYW()) {
                                                if (NewSubPbActivity.this.ftE.bbJ() == null || view2 != NewSubPbActivity.this.ftE.bbJ().aYX()) {
                                                    if ((view2 == NewSubPbActivity.this.ftE.bbC() || view2 == NewSubPbActivity.this.ftE.bbI()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.eoa.Ez()) {
                                                            NewSubPbActivity.this.eoa.EA();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.eoa.gu(null);
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
                                                NewSubPbActivity.this.ftE.bar();
                                                if (tag instanceof String) {
                                                    String Ea = NewSubPbActivity.this.ftC.Ea();
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
                                                NewSubPbActivity.this.ftE.bar();
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
                                        NewSubPbActivity.this.ftE.bar();
                                        SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.ftE.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new al("c11739").r("obj_locate", 1));
                                    NewSubPbActivity.this.ftE.bar();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.eoa.gu(null);
                                        if (NewSubPbActivity.this.ftQ != null) {
                                            NewSubPbActivity.this.ftQ.asZ();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new al("c11739").r("obj_locate", 2));
                                    NewSubPbActivity.this.ftE.bar();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.ftC.bbO() != null) {
                                        NewSubPbActivity.this.e(NewSubPbActivity.this.ftC.bbO().aWc());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.ftE.bbu();
                                NewSubPbActivity.this.ftE.bbv();
                                if (NewSubPbActivity.this.eoa != null) {
                                    NewSubPbActivity.this.eoa.EC();
                                    if (NewSubPbActivity.this.ftQ != null) {
                                        NewSubPbActivity.this.ftQ.asZ();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.ftE.bbu();
                            NewSubPbActivity.this.ftE.bbv();
                            if (NewSubPbActivity.this.eoa != null) {
                                NewSubPbActivity.this.eoa.EB();
                                if (NewSubPbActivity.this.ftQ != null) {
                                    NewSubPbActivity.this.ftQ.asZ();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.enS == null || NewSubPbActivity.this.ftC == null || NewSubPbActivity.this.ftC.aWk() == null || NewSubPbActivity.this.enS.cJ(NewSubPbActivity.this.ftC.aWk().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.eoa.Er()) {
                                NewSubPbActivity.this.eoa.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.ftE.bbu();
                            NewSubPbActivity.this.ftE.bbv();
                            if (NewSubPbActivity.this.eoa != null) {
                                NewSubPbActivity.this.eoa.ED();
                                if (NewSubPbActivity.this.ftQ != null) {
                                    NewSubPbActivity.this.ftQ.asZ();
                                }
                            }
                        }
                    }
                }
            }
        };
        this.ftF = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.ftE.bar();
                }
                NewSubPbActivity.this.eoa.EA();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.ftE.bbK();
            }
        };
        this.ffU = new b.InterfaceC0086b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.ftC.bbO() != null) {
                    postData = NewSubPbActivity.this.ftC.bbO().aWc();
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
                    NewSubPbActivity.this.ftE.b(NewSubPbActivity.this.ffU, NewSubPbActivity.this.ftC.isMarked());
                }
                return true;
            }
        };
        this.ftG = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void b(View view2, String str) {
                NewSubPbActivity.this.k(null, str, "LINK_IMAGE");
            }
        };
        this.ftH = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                    k bbO = NewSubPbActivity.this.ftC.bbO();
                    TbRichText aB = NewSubPbActivity.this.aB(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (aB != null && aB.JJ() != null) {
                        tbRichTextData = aB.JJ().get(NewSubPbActivity.this.ffR);
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
                            if (NewSubPbActivity.this.ftC.bcb() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.ftC.bcb();
                                z5 = NewSubPbActivity.this.ftC.bcd();
                                arrayList2 = NewSubPbActivity.this.ftC.bcc();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z5 = z4;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(v.c(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.ffS = false;
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
                        if (NewSubPbActivity.this.ftC.bcb() != null) {
                            concurrentHashMap = NewSubPbActivity.this.ftC.bcb();
                            z3 = NewSubPbActivity.this.ftC.bcd();
                            arrayList = NewSubPbActivity.this.ftC.bcc();
                            i2 = a2 + NewSubPbActivity.this.ftC.getOffset();
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
            this.ffS = true;
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
                        if (!this.ffS) {
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
        if (this.ftC == null || this.ftC.bbO() == null || str == null || i < 0) {
            return null;
        }
        k bbO = this.ftC.bbO();
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
                        this.ffR = i3;
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
        long templateId = this.ftC.bbO().aWc().bsi() != null ? this.ftC.bbO().aWc().bsi().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ax.wg().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.ftC.bbO().aWj().getId(), this.ftC.bbO().aWj().getName(), this.ftC.bbO().Pe().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(int i, String str) {
        if (this.ftC.bbP()) {
            showToast(str);
        } else if (l.hg()) {
            if (i == 4) {
                this.ftE.lW(str + "(4)");
            } else {
                this.ftE.ij(d.k.no_data_text);
            }
        } else {
            this.ftE.ij(d.k.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.eoa = (g) new com.baidu.tbadk.editortools.pb.h().aO(getActivity());
        if (this.eoa != null) {
            this.eoa.setContext(getPageContext());
            this.eoa.b(this.ftC);
            this.eoa.b(this.ftT);
            this.eoa.a(this.aED);
            this.eoa.a(this.aEE);
            this.eoa.DF().bx(true);
            this.eoa.d(getPageContext());
        }
        if (this.ftE != null) {
            this.ftE.g(this.eoa);
        }
        if (this.eoa != null && this.ftC != null) {
            this.eoa.a(this.ftC.aWk());
            this.eoa.EA();
        }
        if (this.eoa != null) {
            this.fqR = this.eoa.EE().getInputView();
            this.fqR.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.ftR != null) {
                        if (!NewSubPbActivity.this.ftR.bAX()) {
                            NewSubPbActivity.this.kF(false);
                        }
                        NewSubPbActivity.this.ftR.nj(false);
                    }
                }
            });
        }
    }

    public void bbr() {
        if (!TbadkCoreApplication.isLogin()) {
            this.eoa.EA();
        } else if (!StringUtils.isNull(this.ftC.bbW())) {
            this.ftE.qO(this.ftC.bbW());
            if (this.ftE.bby() && l.hg()) {
                this.ftE.amL();
            } else {
                this.ftE.bbB();
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
                    this.ftE.be(view2);
                }
            } else if (booleanValue2) {
                this.ftE.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.ftE.bbH(), getPageContext().getPageActivity());
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
        bVar.cc(d.k.operation);
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
                        NewSubPbActivity.this.ftE.a(intValue, str2, sparseArray.get(d.g.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue() : false);
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
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.ftO);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.ftO);
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
        this.ftE.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.ftO;
        userMuteCheckCustomMessage.setTag(this.ftO);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.ftE.a(0, bVar.yR, bVar.gyL, z);
            if (bVar.yR) {
                if (bVar.gyJ == 1) {
                    finish();
                } else if (bVar.gyJ == 2) {
                    this.ftC.qR(bVar.mPostId);
                    this.ftE.a(this.ftC.bbO(), this.ftC.aVE(), this.ftC.bcb() != null);
                    if (this.ftC.bbX()) {
                        this.ftC.kK(false);
                        this.ftE.bbw();
                        this.ftC.FY();
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
        if (!StringUtils.isNull(str) && this.ftC != null) {
            String aYj = this.ftC.aYj();
            String Ea = this.ftC.Ea();
            sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.k.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Ea + "&tid=" + aYj + "&pid=" + str, true)));
        }
    }

    public void e(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.ftC.isMarked() && postData.getId() != null && postData.getId().equals(this.ftC.bbV())) {
                z = true;
            }
            MarkData g = this.ftC.g(postData);
            if (g != null) {
                this.ftE.bar();
                if (this.eGt != null) {
                    this.eGt.a(g);
                    if (!z) {
                        this.eGt.oK();
                    } else {
                        this.eGt.oJ();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.ftC != null) {
            this.ftC.y(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.eoa != null) {
            this.eoa.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.eoa.DF().Ca();
        this.eoa.EA();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eoa.b(writeData);
                this.eoa.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k eH = this.eoa.DF().eH(6);
                if (eH != null && eH.aCM != null) {
                    eH.aCM.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eoa.Ew();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cXg != null) {
            this.cXg.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.ftM = true;
        super.onPause();
        if (this.cXg != null) {
            this.cXg.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dRH);
        this.ftE.asb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.ftM = false;
        super.onResume();
        if (this.cXg != null) {
            this.cXg.onResume(getPageContext());
        }
        registerListener(this.dRH);
        this.ftE.asc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cXg != null) {
            this.cXg.onStop(getPageContext());
        }
        this.eoa.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.ftS));
        this.ftC.cancelLoadData();
        this.ftC.destory();
        this.ftD.cancelLoadData();
        if (this.cXg != null) {
            this.cXg.onDestory(getPageContext());
        }
        this.ftE.bar();
        this.ftE.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.ffG);
        MessageManager.getInstance().unRegisterListener(this.ffH);
        MessageManager.getInstance().unRegisterListener(this.ffI);
        MessageManager.getInstance().unRegisterListener(this.ftO);
        this.ffd = null;
        this.ffe = null;
        if (this.cXQ != null) {
            this.cXQ.onDestroy();
        }
        if (this.enS != null) {
            this.enS.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ftE.onChangeSkinType(i);
        if (this.cXQ != null) {
            this.cXQ.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cXg;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bbC = this.ftE.bbC();
        if (bbC == null || (findViewWithTag = bbC.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean qH(String str) {
        Map<String, String> ep;
        if (!TextUtils.isEmpty(str) && (ep = ax.ep(ax.eq(str))) != null) {
            this.ftP = true;
            String str2 = ep.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return qH(com.baidu.adp.lib.util.k.aT(str2));
            }
            String str3 = ep.get(ftB);
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
            this.ftP = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void S(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.ftP = true;
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
        if (this.ftE != null) {
            return this.ftE.getListView();
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
        if (this.ftE.bby() && l.hg()) {
            this.ftC.FY();
        } else {
            this.ftE.bbB();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.ftO);
        userMuteAddAndDelCustomMessage.setTag(this.ftO);
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
        if (pageStayDurationItem != null && this.ftC != null) {
            if (this.ftC.bbO() != null && this.ftC.bbO().aWj() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.ftC.bbO().aWj().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.ftC.aYj(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.ftM;
    }

    public boolean bbs() {
        if (this.ftC != null) {
            return this.ftC.bbs();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.ftE.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ffd.getPageActivity());
        if (an.isEmpty(str)) {
            aVar.dc(this.ffd.getResources().getString(d.k.block_mute_message_alert, str2));
        } else {
            aVar.dc(str);
        }
        aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.ftE.showLoadingDialog();
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
        aVar.b(this.ffd).tD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gt(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ffd.getPageActivity());
        aVar.dc(str);
        aVar.b(d.k.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.ffd).tD();
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
                    ((TbPageContext) NewSubPbActivity.this.ffd).showToast(d.k.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.ffd.getPageActivity(), 2, true, 4);
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
        aVar.b(this.ffd).tD();
    }

    public String getThreadId() {
        if (this.ftC != null) {
            return this.ftC.aYj();
        }
        return null;
    }

    public String getPostId() {
        if (this.ftC != null) {
            return this.ftC.Ea();
        }
        return null;
    }

    public int aVE() {
        if (this.ftC != null) {
            return this.ftC.aVE();
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
        if (this.fqR != null && this.fqR.getText() != null) {
            int selectionEnd = this.fqR.getSelectionEnd();
            SpannableStringBuilder b = this.ftR.b(this.fqR.getText());
            if (b != null) {
                this.ftR.nj(true);
                this.fqR.setText(b);
                if (z && this.ftR.bAV() >= 0) {
                    this.fqR.requestFocus();
                    this.fqR.setSelection(this.ftR.bAV());
                } else {
                    this.fqR.setSelection(selectionEnd);
                }
                this.ftR.ni(this.ftR.bAV() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.cXQ == null) {
            this.cXQ = new i(getPageContext());
        }
        this.cXQ.a(contriInfo, -1L);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.eoa != null && this.eoa.DF() != null && this.eoa.DF().DI()) {
            this.eoa.DF().Ca();
        } else {
            super.onBackPressed();
        }
    }
}
