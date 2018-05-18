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
    private static final String ftn = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String fuI = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aWo;
    private com.baidu.adp.lib.e.b<TextView> aWp;
    private com.baidu.adp.lib.e.b<View> aWq;
    private com.baidu.adp.lib.e.b<LinearLayout> aWr;
    private com.baidu.adp.lib.e.b<RelativeLayout> aWs;
    private com.baidu.adp.lib.e.b<GifView> aWt;
    private View.OnLongClickListener axX;
    private i cYX;
    private VoiceManager cYn;
    private com.baidu.tbadk.baseEditMark.a eHB;
    public ai epb;
    private g epj;
    private com.baidu.adp.base.e fgk;
    private com.baidu.tbadk.core.view.b fgl;
    private b.InterfaceC0086b fhb;
    private PostWriteCallBackData fkF;
    private EditText frZ;
    private SubPbModel fuJ;
    private ForumManageModel fuK;
    private b fuL;
    private AbsListView.OnScrollListener fuM;
    private TbRichTextView.i fuN;
    private TbRichTextView.h fuO;
    private SubPbModel.a fuP;
    private com.baidu.adp.base.d fuQ;
    private BdUniqueId fuV;
    private com.baidu.tieba.pb.pb.sub.a fuX;
    private com.baidu.tieba.write.b fuY;
    private com.baidu.tieba.pb.d<k> fuZ;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int fgY = 0;
    private a.InterfaceC0082a fgU = null;
    private a fuR = null;
    private a fuS = null;
    private boolean fuT = false;
    private boolean fuU = false;
    private boolean fuW = false;
    private boolean aDk = false;
    private com.baidu.tbadk.editortools.pb.c aEE = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Eb() {
            NewSubPbActivity.this.fuL.bbA();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aEF = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Ea() {
            if (!NewSubPbActivity.this.fuY.bAU()) {
                return (NewSubPbActivity.this.epb == null || NewSubPbActivity.this.fuJ == null || NewSubPbActivity.this.fuJ.aWk() == null || NewSubPbActivity.this.epb.t(NewSubPbActivity.this.fuJ.aWk().replyPrivateFlag, ai.aip)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.fuY.bAW());
            if (NewSubPbActivity.this.epj.Ep()) {
                NewSubPbActivity.this.epj.a(NewSubPbActivity.this.fkF);
            }
            NewSubPbActivity.this.kG(true);
            return true;
        }
    };
    private NewWriteModel.d fva = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.epj != null && NewSubPbActivity.this.epj.DD() != null) {
                NewSubPbActivity.this.epj.DD().hide();
                if (NewSubPbActivity.this.fuJ.bbU()) {
                    TiebaStatic.log(new al("c10367").ac("post_id", NewSubPbActivity.this.fuJ.DY()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fuY.uE(null);
                NewSubPbActivity.this.fuY.ax(null);
                NewSubPbActivity.this.fuY.nj(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    NewSubPbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fuY.ax(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fuY.uE(postWriteCallBackData.getErrorString());
                if (!v.w(NewSubPbActivity.this.fuY.bAS())) {
                    NewSubPbActivity.this.fkF = postWriteCallBackData;
                    if (NewSubPbActivity.this.epj.Ep()) {
                        NewSubPbActivity.this.epj.a(NewSubPbActivity.this.fkF);
                    }
                    NewSubPbActivity.this.kG(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.epb != null) {
                NewSubPbActivity.this.epb.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.fuL.bbB();
        }
    };
    private CustomMessageListener fgN = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fuV) {
                NewSubPbActivity.this.fuL.aav();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fgl.i(NewSubPbActivity.this.fgk.getResources().getString(d.k.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.fgk.getResources().getString(d.k.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.gt(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.aXv();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (an.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.fgk.getResources().getString(d.k.mute_fail);
                    }
                    NewSubPbActivity.this.fgl.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fgO = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fuV) {
                NewSubPbActivity.this.fuL.aav();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fgl.i(NewSubPbActivity.this.fgk.getResources().getString(d.k.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (an.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.fgk.getResources().getString(d.k.un_mute_fail);
                }
                NewSubPbActivity.this.fgl.j(muteMessage);
            }
        }
    };
    private CustomMessageListener fgP = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fuV) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.fuL.aav();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.gKB;
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
                    NewSubPbActivity.this.fuL.a(sparseArray, z);
                }
            }
        }
    };
    boolean fgZ = false;
    private CustomMessageListener dSO = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener cZp = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    h hVar = (h) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.fuJ.bbO() != null && NewSubPbActivity.this.fuJ.bbO().aWc() != null && NewSubPbActivity.this.fuJ.bbO().aWc().rP() != null && currentAccount.equals(NewSubPbActivity.this.fuJ.bbO().aWc().rP().getUserId()) && NewSubPbActivity.this.fuJ.bbO().aWc().rP().getPendantData() != null) {
                        NewSubPbActivity.this.fuJ.bbO().aWc().rP().getPendantData().cL(hVar.qF());
                        NewSubPbActivity.this.fuJ.bbO().aWc().rP().getPendantData().T(hVar.Di());
                        NewSubPbActivity.this.fuL.a(NewSubPbActivity.this.fuJ.bbO().aWc(), NewSubPbActivity.this.fuJ.bbO().aGl(), NewSubPbActivity.this.fuJ.bbO().oH(), NewSubPbActivity.this.fuJ.aVE(), NewSubPbActivity.this.fuJ.bcb() != null);
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
        if (this.aDk) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.fgk = getPageContext();
        this.fuU = true;
        this.fuY = new com.baidu.tieba.write.b();
        this.fuY.uK(d.C0126d.cp_cont_h_alpha85);
        this.fuY.uJ(d.C0126d.cp_cont_i);
        asU();
        bbq();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bbp();
        this.fgl = new com.baidu.tbadk.core.view.b();
        this.fgl.ams = 1000L;
        registerListener(this.fgP);
        registerListener(this.fgN);
        registerListener(this.fgO);
        this.fuV = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fuV;
        userMuteAddAndDelCustomMessage.setTag(this.fuV);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fuV;
        userMuteCheckCustomMessage.setTag(this.fuV);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.epb = new ai(getPageContext());
        this.epb.a(new ai.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
            @Override // com.baidu.tbadk.core.util.ai.a
            public void c(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.epj.Eu();
                }
            }
        });
    }

    private void bbp() {
        if (this.fuL != null && this.fuJ != null && this.fuJ.bbs()) {
            this.fuX = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.fuL.Rd());
            this.fuX.asZ();
            this.fuX.a(new a.InterfaceC0196a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                private boolean dkV = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0196a
                public void asV() {
                    NewSubPbActivity.this.fuL.fQ(false);
                    this.dkV = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0196a
                public void asW() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0196a
                public boolean asX() {
                    if (!this.dkV) {
                        return NewSubPbActivity.this.fuL.atl() != null && NewSubPbActivity.this.fuL.atl().getTop() == 0;
                    }
                    this.dkV = false;
                    return false;
                }
            });
            this.fuL.e(this.fuX);
            this.fuL.fQ(true);
        }
    }

    public void initUI() {
        this.fuL = new b(this, this.mCommonClickListener);
        this.fuL.a(this.fuJ);
        setContentView(this.fuL.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.fuL.setOnScrollListener(this.fuM);
        this.fuL.a(this);
        this.fuL.setOnLinkImageClickListener(this.fuN);
        this.fuL.setOnImageClickListener(this.fuO);
        this.fuL.jr(true);
        this.fuL.setOnLongClickListener(this.axX);
        this.fuL.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (NewSubPbActivity.this.fuJ != null) {
                    NewSubPbActivity.this.fuJ.FW();
                }
            }
        });
        this.fuL.a(this.fuR);
        this.fuL.b(this.fuS);
        if (this.fuJ != null && this.fuJ.bbs() && !this.fuJ.bca()) {
            this.fuL.bbF().setVisibility(8);
        } else {
            this.fuL.bbF().setVisibility(0);
        }
        if (this.fuJ != null && !this.fuJ.bbs()) {
            this.fuL.setIsFromPb(false);
        }
    }

    private boolean z(Bundle bundle) {
        if (bundle != null) {
            this.aDk = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.aDk = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.aDk;
    }

    public void initData(Bundle bundle) {
        this.fuJ = new SubPbModel(getPageContext());
        this.fuJ.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void k(PostData postData) {
                NewSubPbActivity.this.fuL.m(postData);
                NewSubPbActivity.this.fuL.a((BdListView.e) null);
            }
        });
        this.fuK = new ForumManageModel(this);
        this.fuK.setLoadDataCallBack(this.fuQ);
        this.cYn = new VoiceManager();
        this.cYn.onCreate(getPageContext());
        this.eHB = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.eHB != null) {
            this.eHB.a(this.fgU);
        }
        if (bundle != null) {
            this.fuJ.initWithBundle(bundle);
        } else {
            this.fuJ.initWithIntent(getIntent());
        }
        this.fuJ.a(this.fuP);
        if (this.fuJ.bbs()) {
            this.fuJ.FW();
        } else {
            this.fuJ.bbT();
        }
    }

    public void bbq() {
        this.fuP = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, k kVar) {
                if (NewSubPbActivity.this.fuL != null) {
                    NewSubPbActivity.this.fuL.bbB();
                }
                if (NewSubPbActivity.this.fuX != null && NewSubPbActivity.this.fuX.ata()) {
                    NewSubPbActivity.this.fuX.kK(d.C0126d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.ai(i, str);
                    return;
                }
                NewSubPbActivity.this.fuL.hideNoDataView();
                if (kVar != null) {
                    if (kVar.aWc() != null || NewSubPbActivity.this.fuJ != null) {
                        kVar.aWc().a(NewSubPbActivity.this.fuJ.bbZ());
                    }
                    if (NewSubPbActivity.this.fuL != null) {
                        NewSubPbActivity.this.fuL.a(kVar, NewSubPbActivity.this.fuJ.aVE(), NewSubPbActivity.this.fuJ.bcb() != null);
                        if (NewSubPbActivity.this.fuU) {
                            NewSubPbActivity.this.bbr();
                            NewSubPbActivity.this.fuU = false;
                        }
                    }
                    if (NewSubPbActivity.this.epj != null) {
                        NewSubPbActivity.this.epj.a(kVar.aWk());
                    }
                    if (NewSubPbActivity.this.fuZ == null) {
                        NewSubPbActivity.this.fuZ = new com.baidu.tieba.pb.d();
                    }
                    NewSubPbActivity.this.fuZ.setData(kVar);
                    NewSubPbActivity.this.fuZ.setType(0);
                    NewSubPbActivity.this.epb.a(NewSubPbActivity.this.fuJ.bcf());
                }
            }
        };
        this.fgU = new a.InterfaceC0082a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0082a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.eHB != null) {
                        NewSubPbActivity.this.eHB.ae(z2);
                    }
                    MarkData oK = NewSubPbActivity.this.eHB.oK();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setType(2);
                    if (z2) {
                        dVar.setData(oK);
                        if (NewSubPbActivity.this.eHB != null) {
                            if (oK != null) {
                                NewSubPbActivity.this.fuJ.kK(true);
                                NewSubPbActivity.this.fuJ.qV(NewSubPbActivity.this.fuJ.DY());
                                NewSubPbActivity.this.showToast(d.k.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.k.add_mark));
                            }
                            if (NewSubPbActivity.this.fuL != null) {
                                NewSubPbActivity.this.fuL.kH(true);
                            }
                        }
                    } else {
                        dVar.setData(null);
                        NewSubPbActivity.this.fuJ.kK(false);
                        NewSubPbActivity.this.fuJ.qV(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.k.remove_mark));
                        if (NewSubPbActivity.this.fuL != null) {
                            NewSubPbActivity.this.fuL.kH(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.k.update_mark_failed));
            }
        };
        this.fuR = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.fuJ.bbO() != null && NewSubPbActivity.this.fuJ.bbO().Pb() != null && NewSubPbActivity.this.fuJ.bbO().Pb().rP() != null) {
                    str = String.valueOf(NewSubPbActivity.this.fuJ.bbO().Pb().rP().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.fuJ.bbO().aWj().getId(), NewSubPbActivity.this.fuJ.bbO().aWj().getName(), NewSubPbActivity.this.fuJ.bbO().Pb().getId(), str, str2, str3)));
            }
        };
        this.fuS = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.fuK.bsI() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.fuJ != null && NewSubPbActivity.this.fuJ.bbO() != null && NewSubPbActivity.this.fuJ.bbO().aWj() != null && NewSubPbActivity.this.fuJ.bbO().Pb() != null) {
                            NewSubPbActivity.this.fuK.a(NewSubPbActivity.this.fuJ.bbO().aWj().getId(), NewSubPbActivity.this.fuJ.bbO().aWj().getName(), NewSubPbActivity.this.fuJ.bbO().Pb().getId(), valueOf, g2, g, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.k.login_to_use), true, 11017)));
            }
        };
        this.fuQ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.fuL.a(NewSubPbActivity.this.fuK.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.fuK.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.fvM != 1002 || bVar.dyy) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.fuL.a(1, dVar.yQ, dVar.gzP, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void asU() {
        registerListener(this.cZp);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 != null || NewSubPbActivity.this.fuL != null) {
                    if (view2 == NewSubPbActivity.this.fuL.bbL()) {
                        NewSubPbActivity.this.fuL.bar();
                        String str = view2.getTag(d.g.tag_user_id) instanceof String ? (String) view2.getTag(d.g.tag_user_id) : null;
                        String str2 = view2.getTag(d.g.tag_user_name) instanceof String ? (String) view2.getTag(d.g.tag_user_name) : null;
                        String str3 = view2.getTag(d.g.tag_virtual_user_url) instanceof String ? (String) view2.getTag(d.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ax.wf().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view2 != NewSubPbActivity.this.fuL.atm()) {
                        if (view2 != NewSubPbActivity.this.fuL.bbE()) {
                            if (view2 != NewSubPbActivity.this.fuL.bbD()) {
                                if (view2 == NewSubPbActivity.this.fuL.bbz()) {
                                    NewSubPbActivity.this.fuL.bar();
                                    if (NewSubPbActivity.this.fuJ.FW()) {
                                        NewSubPbActivity.this.fuL.bbx();
                                    }
                                } else if (view2 == NewSubPbActivity.this.fuL.bbF() || view2 == NewSubPbActivity.this.fuL.bbG() || view2 == NewSubPbActivity.this.fuL.bbI()) {
                                    if (NewSubPbActivity.this.fuW) {
                                        NewSubPbActivity.this.fuW = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.fuJ.aYj(), NewSubPbActivity.this.fuJ.DY(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.fuJ.bce())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.fuJ.bce());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.fuL.bbJ() == null || view2 != NewSubPbActivity.this.fuL.bbJ().aYV()) {
                                    if (NewSubPbActivity.this.fuL.bbJ() == null || view2 != NewSubPbActivity.this.fuL.bbJ().aZa()) {
                                        if (NewSubPbActivity.this.fuL.bbJ() == null || view2 != NewSubPbActivity.this.fuL.bbJ().aYY()) {
                                            if (NewSubPbActivity.this.fuL.bbJ() == null || view2 != NewSubPbActivity.this.fuL.bbJ().aYW()) {
                                                if (NewSubPbActivity.this.fuL.bbJ() == null || view2 != NewSubPbActivity.this.fuL.bbJ().aYX()) {
                                                    if ((view2 == NewSubPbActivity.this.fuL.bbC() || view2 == NewSubPbActivity.this.fuL.bbI()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.epj.Ex()) {
                                                            NewSubPbActivity.this.epj.Ey();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.epj.gu(null);
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
                                                NewSubPbActivity.this.fuL.bar();
                                                if (tag instanceof String) {
                                                    String DY = NewSubPbActivity.this.fuJ.DY();
                                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                        NewSubPbActivity.this.qv(DY);
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
                                                NewSubPbActivity.this.fuL.bar();
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
                                        NewSubPbActivity.this.fuL.bar();
                                        SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.fuL.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new al("c11739").r("obj_locate", 1));
                                    NewSubPbActivity.this.fuL.bar();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.epj.gu(null);
                                        if (NewSubPbActivity.this.fuX != null) {
                                            NewSubPbActivity.this.fuX.asY();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new al("c11739").r("obj_locate", 2));
                                    NewSubPbActivity.this.fuL.bar();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.fuJ.bbO() != null) {
                                        NewSubPbActivity.this.e(NewSubPbActivity.this.fuJ.bbO().aWc());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.fuL.bbu();
                                NewSubPbActivity.this.fuL.bbv();
                                if (NewSubPbActivity.this.epj != null) {
                                    NewSubPbActivity.this.epj.EA();
                                    if (NewSubPbActivity.this.fuX != null) {
                                        NewSubPbActivity.this.fuX.asY();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.fuL.bbu();
                            NewSubPbActivity.this.fuL.bbv();
                            if (NewSubPbActivity.this.epj != null) {
                                NewSubPbActivity.this.epj.Ez();
                                if (NewSubPbActivity.this.fuX != null) {
                                    NewSubPbActivity.this.fuX.asY();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.epb == null || NewSubPbActivity.this.fuJ == null || NewSubPbActivity.this.fuJ.aWk() == null || NewSubPbActivity.this.epb.cK(NewSubPbActivity.this.fuJ.aWk().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.epj.Ep()) {
                                NewSubPbActivity.this.epj.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.fuL.bbu();
                            NewSubPbActivity.this.fuL.bbv();
                            if (NewSubPbActivity.this.epj != null) {
                                NewSubPbActivity.this.epj.EB();
                                if (NewSubPbActivity.this.fuX != null) {
                                    NewSubPbActivity.this.fuX.asY();
                                }
                            }
                        }
                    }
                }
            }
        };
        this.fuM = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.fuL.bar();
                }
                NewSubPbActivity.this.epj.Ey();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.fuL.bbK();
            }
        };
        this.fhb = new b.InterfaceC0086b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.fuJ.bbO() != null) {
                    postData = NewSubPbActivity.this.fuJ.bbO().aWc();
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
        this.axX = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                    NewSubPbActivity.this.fuL.b(NewSubPbActivity.this.fhb, NewSubPbActivity.this.fuJ.isMarked());
                }
                return true;
            }
        };
        this.fuN = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void b(View view2, String str) {
                NewSubPbActivity.this.k(null, str, "LINK_IMAGE");
            }
        };
        this.fuO = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                    k bbO = NewSubPbActivity.this.fuJ.bbO();
                    TbRichText aB = NewSubPbActivity.this.aB(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (aB != null && aB.JH() != null) {
                        tbRichTextData = aB.JH().get(NewSubPbActivity.this.fgY);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.JN().JZ()) {
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
                                if (bbO.Pb() != null) {
                                    str6 = bbO.Pb().getId();
                                }
                                str3 = str6;
                                z4 = true;
                            }
                            if (NewSubPbActivity.this.fuJ.bcb() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.fuJ.bcb();
                                z5 = NewSubPbActivity.this.fuJ.bcd();
                                arrayList2 = NewSubPbActivity.this.fuJ.bcc();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z5 = z4;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(v.c(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.fgZ = false;
                        String str7 = "";
                        TbRichText brZ = bbO.aWc().brZ();
                        int size = arrayList2.size();
                        int a2 = NewSubPbActivity.this.a(brZ, aB, i, i, arrayList2, concurrentHashMap3);
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
                            if (bbO.Pb() != null) {
                                str10 = bbO.Pb().getId();
                            }
                            str2 = str10;
                            z2 = true;
                        }
                        if (NewSubPbActivity.this.fuJ.bcb() != null) {
                            concurrentHashMap = NewSubPbActivity.this.fuJ.bcb();
                            z3 = NewSubPbActivity.this.fuJ.bcd();
                            arrayList = NewSubPbActivity.this.fuJ.bcc();
                            i2 = a2 + NewSubPbActivity.this.fuJ.getOffset();
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
        TbRichTextImageInfo JN;
        if (tbRichText == tbRichText2) {
            this.fgZ = true;
        }
        if (tbRichText != null && tbRichText.JH() != null) {
            int size = tbRichText.JH().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.JH().get(i6) != null && tbRichText.JH().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.JH().get(i6).JN().getWidth();
                    int height = tbRichText.JH().get(i6).JN().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.JH().get(i6).JN().JZ()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.JH().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (JN = tbRichTextData.JN()) != null) {
                            String Ka = JN.Ka();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Ka;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.fgZ) {
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
        TbRichTextImageInfo JN = tbRichTextData.JN();
        if (JN != null) {
            if (!StringUtils.isNull(JN.JY())) {
                return JN.JY();
            }
            if (JN.getHeight() * JN.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (JN.getHeight() * JN.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (JN.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * JN.getHeight())));
            } else {
                float width = JN.getWidth() / JN.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(an.aS(JN.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aB(String str, int i) {
        if (this.fuJ == null || this.fuJ.bbO() == null || str == null || i < 0) {
            return null;
        }
        k bbO = this.fuJ.bbO();
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
        TbRichText brZ = postData.brZ();
        if (brZ != null) {
            ArrayList<TbRichTextData> JH = brZ.JH();
            int size = JH.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (JH.get(i3) != null && JH.get(i3).getType() == 8) {
                    i2++;
                    if (JH.get(i3).JN().Ka().equals(str)) {
                        int width = JH.get(i3).JN().getWidth();
                        int height = JH.get(i3).JN().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.fgY = i3;
                        return brZ;
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
        long templateId = this.fuJ.bbO().aWc().bsg() != null ? this.fuJ.bbO().aWc().bsg().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ax.wf().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.fuJ.bbO().aWj().getId(), this.fuJ.bbO().aWj().getName(), this.fuJ.bbO().Pb().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(int i, String str) {
        if (this.fuJ.bbP()) {
            showToast(str);
        } else if (l.hg()) {
            if (i == 4) {
                this.fuL.lZ(str + "(4)");
            } else {
                this.fuL.ii(d.k.no_data_text);
            }
        } else {
            this.fuL.ii(d.k.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.epj = (g) new com.baidu.tbadk.editortools.pb.h().aO(getActivity());
        if (this.epj != null) {
            this.epj.setContext(getPageContext());
            this.epj.b(this.fuJ);
            this.epj.b(this.fva);
            this.epj.a(this.aEE);
            this.epj.a(this.aEF);
            this.epj.DD().bx(true);
            this.epj.d(getPageContext());
        }
        if (this.fuL != null) {
            this.fuL.g(this.epj);
        }
        if (this.epj != null && this.fuJ != null) {
            this.epj.a(this.fuJ.aWk());
            this.epj.Ey();
        }
        if (this.epj != null) {
            this.frZ = this.epj.EC().getInputView();
            this.frZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.fuY != null) {
                        if (!NewSubPbActivity.this.fuY.bAV()) {
                            NewSubPbActivity.this.kG(false);
                        }
                        NewSubPbActivity.this.fuY.nk(false);
                    }
                }
            });
        }
    }

    public void bbr() {
        if (!TbadkCoreApplication.isLogin()) {
            this.epj.Ey();
        } else if (!StringUtils.isNull(this.fuJ.bbW())) {
            this.fuL.qR(this.fuJ.bbW());
            if (this.fuL.bby() && l.hg()) {
                this.fuL.amK();
            } else {
                this.fuL.bbB();
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
                    this.fuL.be(view2);
                }
            } else if (booleanValue2) {
                this.fuL.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.fuL.bbH(), getPageContext().getPageActivity());
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
                        NewSubPbActivity.this.fuL.a(intValue, str2, sparseArray.get(d.g.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue() : false);
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
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.fuV);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.fuV);
                        NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str6, str3);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext()).tF();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
        }
        this.fuL.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.fuV;
        userMuteCheckCustomMessage.setTag(this.fuV);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.fuL.a(0, bVar.yQ, bVar.gzP, z);
            if (bVar.yQ) {
                if (bVar.gzN == 1) {
                    finish();
                } else if (bVar.gzN == 2) {
                    this.fuJ.qU(bVar.mPostId);
                    this.fuL.a(this.fuJ.bbO(), this.fuJ.aVE(), this.fuJ.bcb() != null);
                    if (this.fuJ.bbX()) {
                        this.fuJ.kL(false);
                        this.fuL.bbw();
                        this.fuJ.FW();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
            }
        }
    }

    public void qv(String str) {
        if (!StringUtils.isNull(str) && this.fuJ != null) {
            String aYj = this.fuJ.aYj();
            String DY = this.fuJ.DY();
            sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.k.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + DY + "&tid=" + aYj + "&pid=" + str, true)));
        }
    }

    public void e(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.fuJ.isMarked() && postData.getId() != null && postData.getId().equals(this.fuJ.bbV())) {
                z = true;
            }
            MarkData g = this.fuJ.g(postData);
            if (g != null) {
                this.fuL.bar();
                if (this.eHB != null) {
                    this.eHB.a(g);
                    if (!z) {
                        this.eHB.oJ();
                    } else {
                        this.eHB.oI();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.fuJ != null) {
            this.fuJ.y(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.epj != null) {
            this.epj.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.epj.DD().BY();
        this.epj.Ey();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.epj.b(writeData);
                this.epj.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k eI = this.epj.DD().eI(6);
                if (eI != null && eI.aCN != null) {
                    eI.aCN.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.epj.Eu();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cYn != null) {
            this.cYn.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.fuT = true;
        super.onPause();
        if (this.cYn != null) {
            this.cYn.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dSO);
        this.fuL.asa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fuT = false;
        super.onResume();
        if (this.cYn != null) {
            this.cYn.onResume(getPageContext());
        }
        registerListener(this.dSO);
        this.fuL.asb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cYn != null) {
            this.cYn.onStop(getPageContext());
        }
        this.epj.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.fuZ));
        this.fuJ.cancelLoadData();
        this.fuJ.destory();
        this.fuK.cancelLoadData();
        if (this.cYn != null) {
            this.cYn.onDestory(getPageContext());
        }
        this.fuL.bar();
        this.fuL.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.fgN);
        MessageManager.getInstance().unRegisterListener(this.fgO);
        MessageManager.getInstance().unRegisterListener(this.fgP);
        MessageManager.getInstance().unRegisterListener(this.fuV);
        this.fgk = null;
        this.fgl = null;
        if (this.cYX != null) {
            this.cYX.onDestroy();
        }
        if (this.epb != null) {
            this.epb.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fuL.onChangeSkinType(i);
        if (this.cYX != null) {
            this.cYX.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cYn;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bbC = this.fuL.bbC();
        if (bbC == null || (findViewWithTag = bbC.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean qK(String str) {
        Map<String, String> ep;
        if (!TextUtils.isEmpty(str) && (ep = ax.ep(ax.eq(str))) != null) {
            this.fuW = true;
            String str2 = ep.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return qK(com.baidu.adp.lib.util.k.aT(str2));
            }
            String str3 = ep.get(fuI);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void T(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (qK(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            ax.wf().c(getPageContext(), new String[]{str});
            this.fuW = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void S(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fuW = true;
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
        if (this.fuL != null) {
            return this.fuL.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Km() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Ko() {
        if (this.aWp == null) {
            this.aWp = TbRichTextView.j(getPageContext().getPageActivity(), 8);
        }
        return this.aWp;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Kp() {
        if (this.aWt == null) {
            this.aWt = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
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
        return this.aWt;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Kn() {
        if (this.aWo == null) {
            this.aWo = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aby */
                public ImageView fo() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean qd = com.baidu.tbadk.core.i.pX().qd();
                    foreDrawableImageView.setDefaultBg(ak.getDrawable(d.C0126d.common_color_10220));
                    if (qd) {
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
                        if (com.baidu.tbadk.core.i.pX().qd()) {
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
        return this.aWo;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Kq() {
        if (this.aWq == null) {
            this.aWq = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
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
        return this.aWq;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Kr() {
        if (this.aWr == null) {
            this.aWr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
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
        return this.aWr;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Ks() {
        this.aWs = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
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
        return this.aWs;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fuL.bby() && l.hg()) {
            this.fuJ.FW();
        } else {
            this.fuL.bbB();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.fuV);
        userMuteAddAndDelCustomMessage.setTag(this.fuV);
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
            public boolean Gm() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Gn() {
                return com.baidu.tbadk.pageStayDuration.e.Gr().Gt();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.fuJ != null) {
            if (this.fuJ.bbO() != null && this.fuJ.bbO().aWj() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fuJ.bbO().aWj().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fuJ.aYj(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.fuT;
    }

    public boolean bbs() {
        if (this.fuJ != null) {
            return this.fuJ.bbs();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.fuL.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fgk.getPageActivity());
        if (an.isEmpty(str)) {
            aVar.dc(this.fgk.getResources().getString(d.k.block_mute_message_alert, str2));
        } else {
            aVar.dc(str);
        }
        aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.fuL.showLoadingDialog();
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
        aVar.b(this.fgk).tC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gt(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fgk.getPageActivity());
        aVar.dc(str);
        aVar.b(d.k.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fgk).tC();
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
                    ((TbPageContext) NewSubPbActivity.this.fgk).showToast(d.k.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.fgk.getPageActivity(), 2, true, 4);
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
        aVar.b(this.fgk).tC();
    }

    public String getThreadId() {
        if (this.fuJ != null) {
            return this.fuJ.aYj();
        }
        return null;
    }

    public String getPostId() {
        if (this.fuJ != null) {
            return this.fuJ.DY();
        }
        return null;
    }

    public int aVE() {
        if (this.fuJ != null) {
            return this.fuJ.aVE();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.aDk) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.aDk) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void kG(boolean z) {
        if (this.frZ != null && this.frZ.getText() != null) {
            int selectionEnd = this.frZ.getSelectionEnd();
            SpannableStringBuilder b = this.fuY.b(this.frZ.getText());
            if (b != null) {
                this.fuY.nk(true);
                this.frZ.setText(b);
                if (z && this.fuY.bAT() >= 0) {
                    this.frZ.requestFocus();
                    this.frZ.setSelection(this.fuY.bAT());
                } else {
                    this.frZ.setSelection(selectionEnd);
                }
                this.fuY.nj(this.fuY.bAT() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.cYX == null) {
            this.cYX = new i(getPageContext());
        }
        this.cYX.a(contriInfo, -1L);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.epj != null && this.epj.DD() != null && this.epj.DD().DG()) {
            this.epj.DD().BY();
        } else {
            super.onBackPressed();
        }
    }
}
