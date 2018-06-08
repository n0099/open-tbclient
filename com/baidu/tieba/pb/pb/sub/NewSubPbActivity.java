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
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.h;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.i;
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
    private static final String fEE = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String fGd = "tbgametype";
    private View.OnLongClickListener aGs;
    private com.baidu.adp.lib.e.b<ImageView> beu;
    private com.baidu.adp.lib.e.b<TextView> bev;
    private com.baidu.adp.lib.e.b<View> bew;
    private com.baidu.adp.lib.e.b<LinearLayout> bex;
    private com.baidu.adp.lib.e.b<RelativeLayout> bey;
    private com.baidu.adp.lib.e.b<GifView> bez;
    private VoiceManager dhB;
    private h dio;
    private g eAA;
    public aj eAs;
    private com.baidu.tbadk.baseEditMark.a eSU;
    private EditText fDq;
    private SubPbModel fGe;
    private ForumManageModel fGf;
    private b fGg;
    private AbsListView.OnScrollListener fGh;
    private TbRichTextView.i fGi;
    private TbRichTextView.h fGj;
    private SubPbModel.a fGk;
    private com.baidu.adp.base.d fGl;
    private BdUniqueId fGq;
    private com.baidu.tieba.pb.pb.sub.a fGs;
    private com.baidu.tieba.write.b fGt;
    private com.baidu.tieba.pb.d<k> fGu;
    private com.baidu.adp.base.e frJ;
    private com.baidu.tbadk.core.view.c frK;
    private com.baidu.tieba.pb.pb.report.a frp;
    private b.InterfaceC0103b fsA;
    private PostWriteCallBackData fwa;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int fsx = 0;
    private a.InterfaceC0099a fst = null;
    private a fGm = null;
    private a fGn = null;
    private boolean fGo = false;
    private boolean fGp = false;
    private boolean fGr = false;
    private boolean aLG = false;
    private com.baidu.tbadk.editortools.pb.c aNa = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void HE() {
            NewSubPbActivity.this.fGg.bgA();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aNb = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean HD() {
            if (!NewSubPbActivity.this.fGt.bGa()) {
                return (NewSubPbActivity.this.eAs == null || NewSubPbActivity.this.fGe == null || NewSubPbActivity.this.fGe.bbg() == null || NewSubPbActivity.this.eAs.u(NewSubPbActivity.this.fGe.bbg().replyPrivateFlag, aj.aqw)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.fGt.bGc());
            if (NewSubPbActivity.this.eAA.HT()) {
                NewSubPbActivity.this.eAA.a(NewSubPbActivity.this.fwa);
            }
            NewSubPbActivity.this.kM(true);
            return true;
        }
    };
    private NewWriteModel.d fGv = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.eAA != null && NewSubPbActivity.this.eAA.Hg() != null) {
                NewSubPbActivity.this.eAA.Hg().hide();
                if (NewSubPbActivity.this.fGe.bgU()) {
                    TiebaStatic.log(new am("c10367").ah("post_id", NewSubPbActivity.this.fGe.HB()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fGt.vy(null);
                NewSubPbActivity.this.fGt.ax(null);
                NewSubPbActivity.this.fGt.nr(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    NewSubPbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fGt.ax(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fGt.vy(postWriteCallBackData.getErrorString());
                if (!w.z(NewSubPbActivity.this.fGt.bFY())) {
                    NewSubPbActivity.this.fwa = postWriteCallBackData;
                    if (NewSubPbActivity.this.eAA.HT()) {
                        NewSubPbActivity.this.eAA.a(NewSubPbActivity.this.fwa);
                    }
                    NewSubPbActivity.this.kM(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.eAs != null) {
                NewSubPbActivity.this.eAs.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.fGg.bgB();
        }
    };
    private CustomMessageListener fsm = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fGq) {
                NewSubPbActivity.this.fGg.adT();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.frK.i(NewSubPbActivity.this.frJ.getResources().getString(d.k.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.frJ.getResources().getString(d.k.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.gR(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bcr();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ao.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.frJ.getResources().getString(d.k.mute_fail);
                    }
                    NewSubPbActivity.this.frK.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fsn = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fGq) {
                NewSubPbActivity.this.fGg.adT();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.frK.i(NewSubPbActivity.this.frJ.getResources().getString(d.k.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ao.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.frJ.getResources().getString(d.k.un_mute_fail);
                }
                NewSubPbActivity.this.frK.j(muteMessage);
            }
        }
    };
    private CustomMessageListener fso = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fGq) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.fGg.adT();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.gWd;
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
                    NewSubPbActivity.this.fGg.a(sparseArray, z);
                }
            }
        }
    };
    boolean fsy = false;
    private CustomMessageListener eeb = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener diH = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.fGe.bgO() != null && NewSubPbActivity.this.fGe.bgO().baY() != null && NewSubPbActivity.this.fGe.bgO().baY().vm() != null && currentAccount.equals(NewSubPbActivity.this.fGe.bgO().baY().vm().getUserId()) && NewSubPbActivity.this.fGe.bgO().baY().vm().getPendantData() != null) {
                        NewSubPbActivity.this.fGe.bgO().baY().vm().getPendantData().dj(iVar.ub());
                        NewSubPbActivity.this.fGe.bgO().baY().vm().getPendantData().W(iVar.GL());
                        NewSubPbActivity.this.fGg.a(NewSubPbActivity.this.fGe.bgO().baY(), NewSubPbActivity.this.fGe.bgO().aLg(), NewSubPbActivity.this.fGe.bgO().sc(), NewSubPbActivity.this.fGe.baA(), NewSubPbActivity.this.fGe.bhb() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void i(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        A(bundle);
        if (this.aLG) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.frJ = getPageContext();
        this.fGp = true;
        this.fGt = new com.baidu.tieba.write.b();
        this.fGt.vb(d.C0141d.cp_cont_h_alpha85);
        this.fGt.va(d.C0141d.cp_cont_i);
        axa();
        bgq();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bgp();
        this.frK = new com.baidu.tbadk.core.view.c();
        this.frK.auA = 1000L;
        registerListener(this.fso);
        registerListener(this.fsm);
        registerListener(this.fsn);
        this.fGq = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fGq;
        userMuteAddAndDelCustomMessage.setTag(this.fGq);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fGq;
        userMuteCheckCustomMessage.setTag(this.fGq);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eAs = new aj(getPageContext());
        this.eAs.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.eAA.HY();
                }
            }
        });
        this.frp = new com.baidu.tieba.pb.pb.report.a(this);
        this.frp.o(getUniqueId());
    }

    private void bgp() {
        if (this.fGg != null && this.fGe != null && this.fGe.bgs()) {
            this.fGs = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.fGg.UB());
            this.fGs.axf();
            this.fGs.a(new a.InterfaceC0212a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
                private boolean duj = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0212a
                public void axb() {
                    NewSubPbActivity.this.fGg.fV(false);
                    this.duj = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0212a
                public void axc() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0212a
                public boolean axd() {
                    if (!this.duj) {
                        return NewSubPbActivity.this.fGg.axr() != null && NewSubPbActivity.this.fGg.axr().getTop() == 0;
                    }
                    this.duj = false;
                    return false;
                }
            });
            this.fGg.e(this.fGs);
            this.fGg.fV(true);
        }
    }

    public void initUI() {
        this.fGg = new b(this, this.mCommonClickListener);
        this.fGg.a(this.fGe);
        setContentView(this.fGg.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.fGg.setOnScrollListener(this.fGh);
        this.fGg.a(this);
        this.fGg.setOnLinkImageClickListener(this.fGi);
        this.fGg.setOnImageClickListener(this.fGj);
        this.fGg.jx(true);
        this.fGg.setOnLongClickListener(this.aGs);
        this.fGg.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.fGe != null) {
                    NewSubPbActivity.this.fGe.JE();
                }
            }
        });
        this.fGg.a(this.fGm);
        this.fGg.b(this.fGn);
        if (this.fGe != null && this.fGe.bgs() && !this.fGe.bha()) {
            this.fGg.bgF().setVisibility(8);
        } else {
            this.fGg.bgF().setVisibility(0);
        }
        if (this.fGe != null && !this.fGe.bgs()) {
            this.fGg.setIsFromPb(false);
        }
    }

    private boolean A(Bundle bundle) {
        if (bundle != null) {
            this.aLG = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.aLG = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.aLG;
    }

    public void initData(Bundle bundle) {
        this.fGe = new SubPbModel(getPageContext());
        this.fGe.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void k(PostData postData) {
                NewSubPbActivity.this.fGg.m(postData);
                NewSubPbActivity.this.fGg.a((BdListView.e) null);
            }
        });
        this.fGf = new ForumManageModel(this);
        this.fGf.setLoadDataCallBack(this.fGl);
        this.dhB = new VoiceManager();
        this.dhB.onCreate(getPageContext());
        this.eSU = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.eSU != null) {
            this.eSU.a(this.fst);
        }
        if (bundle != null) {
            this.fGe.initWithBundle(bundle);
        } else {
            this.fGe.initWithIntent(getIntent());
        }
        this.fGe.a(this.fGk);
        if (this.fGe.bgs()) {
            this.fGe.JE();
        } else {
            this.fGe.bgT();
        }
    }

    public void bgq() {
        this.fGk = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, k kVar) {
                if (NewSubPbActivity.this.fGg != null) {
                    NewSubPbActivity.this.fGg.bgB();
                }
                if (NewSubPbActivity.this.fGs != null && NewSubPbActivity.this.fGs.axg()) {
                    NewSubPbActivity.this.fGs.kP(d.C0141d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.ai(i, str);
                    return;
                }
                NewSubPbActivity.this.fGg.hideNoDataView();
                if (kVar != null) {
                    if (kVar.baY() != null || NewSubPbActivity.this.fGe != null) {
                        kVar.baY().a(NewSubPbActivity.this.fGe.bgZ());
                    }
                    if (NewSubPbActivity.this.fGg != null) {
                        NewSubPbActivity.this.fGg.a(kVar, NewSubPbActivity.this.fGe.baA(), NewSubPbActivity.this.fGe.bhb() != null);
                        if (NewSubPbActivity.this.fGp) {
                            NewSubPbActivity.this.bgr();
                            NewSubPbActivity.this.fGp = false;
                        }
                    }
                    if (NewSubPbActivity.this.eAA != null) {
                        NewSubPbActivity.this.eAA.a(kVar.bbg());
                    }
                    if (NewSubPbActivity.this.fGu == null) {
                        NewSubPbActivity.this.fGu = new com.baidu.tieba.pb.d();
                    }
                    NewSubPbActivity.this.fGu.setData(kVar);
                    NewSubPbActivity.this.fGu.setType(0);
                    NewSubPbActivity.this.eAs.a(NewSubPbActivity.this.fGe.bhf());
                }
            }
        };
        this.fst = new a.InterfaceC0099a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0099a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.eSU != null) {
                        NewSubPbActivity.this.eSU.ah(z2);
                    }
                    MarkData sf = NewSubPbActivity.this.eSU.sf();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setType(2);
                    if (z2) {
                        dVar.setData(sf);
                        if (NewSubPbActivity.this.eSU != null) {
                            if (sf != null) {
                                NewSubPbActivity.this.fGe.kQ(true);
                                NewSubPbActivity.this.fGe.rL(NewSubPbActivity.this.fGe.HB());
                                NewSubPbActivity.this.showToast(d.k.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.k.add_mark));
                            }
                            if (NewSubPbActivity.this.fGg != null) {
                                NewSubPbActivity.this.fGg.kN(true);
                            }
                        }
                    } else {
                        dVar.setData(null);
                        NewSubPbActivity.this.fGe.kQ(false);
                        NewSubPbActivity.this.fGe.rL(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.k.remove_mark));
                        if (NewSubPbActivity.this.fGg != null) {
                            NewSubPbActivity.this.fGg.kN(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.k.update_mark_failed));
            }
        };
        this.fGm = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void i(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                if (NewSubPbActivity.this.fGe.bgO() != null && NewSubPbActivity.this.fGe.bgO().Sz() != null && NewSubPbActivity.this.fGe.bgO().Sz().vm() != null) {
                    str = String.valueOf(NewSubPbActivity.this.fGe.bgO().Sz().vm().getUserId());
                }
                String str3 = "";
                if (objArr.length > 1) {
                    str3 = String.valueOf(objArr[1]);
                }
                String str4 = "";
                if (objArr.length > 2) {
                    str4 = String.valueOf(objArr[2]);
                }
                if (objArr.length > 3) {
                    str2 = String.valueOf(objArr[3]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.fGe.bgO().bbf().getId(), NewSubPbActivity.this.fGe.bgO().bbf().getName(), NewSubPbActivity.this.fGe.bgO().Sz().getId(), str, str3, str2, str4)));
            }
        };
        this.fGn = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void i(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.fGf.bxN() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.fGe != null && NewSubPbActivity.this.fGe.bgO() != null && NewSubPbActivity.this.fGe.bgO().bbf() != null && NewSubPbActivity.this.fGe.bgO().Sz() != null) {
                            NewSubPbActivity.this.fGf.a(NewSubPbActivity.this.fGe.bgO().bbf().getId(), NewSubPbActivity.this.fGe.bgO().bbf().getName(), NewSubPbActivity.this.fGe.bgO().Sz().getId(), valueOf, g2, g, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.k.login_to_use), true, 11017)));
            }
        };
        this.fGl = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.fGg.a(NewSubPbActivity.this.fGf.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.fGf.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.fHh != 1002 || bVar.dJI) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.fGg.a(1, dVar.EY, dVar.gLr, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void axa() {
        registerListener(this.diH);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.fGg != null) {
                    if (view == NewSubPbActivity.this.fGg.bgL()) {
                        NewSubPbActivity.this.fGg.bfp();
                        String str = view.getTag(d.g.tag_user_id) instanceof String ? (String) view.getTag(d.g.tag_user_id) : null;
                        String str2 = view.getTag(d.g.tag_user_name) instanceof String ? (String) view.getTag(d.g.tag_user_name) : null;
                        String str3 = view.getTag(d.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(d.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ay.zG().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.fGg.axs()) {
                        if (view != NewSubPbActivity.this.fGg.bgE()) {
                            if (view != NewSubPbActivity.this.fGg.bgD()) {
                                if (view == NewSubPbActivity.this.fGg.bgz()) {
                                    NewSubPbActivity.this.fGg.bfp();
                                    if (NewSubPbActivity.this.fGe.JE()) {
                                        NewSubPbActivity.this.fGg.bgx();
                                    }
                                } else if (view == NewSubPbActivity.this.fGg.bgF() || view == NewSubPbActivity.this.fGg.bgG() || view == NewSubPbActivity.this.fGg.bgI()) {
                                    if (NewSubPbActivity.this.fGr) {
                                        NewSubPbActivity.this.fGr = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.fGe.bdh(), NewSubPbActivity.this.fGe.HB(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.fGe.bhe())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.fGe.bhe());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.fGg.bgJ() == null || view != NewSubPbActivity.this.fGg.bgJ().bdT()) {
                                    if (NewSubPbActivity.this.fGg.bgJ() == null || view != NewSubPbActivity.this.fGg.bgJ().bdY()) {
                                        if (NewSubPbActivity.this.fGg.bgJ() == null || view != NewSubPbActivity.this.fGg.bgJ().bdW()) {
                                            if (NewSubPbActivity.this.fGg.bgJ() == null || view != NewSubPbActivity.this.fGg.bgJ().bdU()) {
                                                if (NewSubPbActivity.this.fGg.bgJ() == null || view != NewSubPbActivity.this.fGg.bgJ().bdV()) {
                                                    if ((view == NewSubPbActivity.this.fGg.bgC() || view == NewSubPbActivity.this.fGg.bgI()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.eAA.Ib()) {
                                                            NewSubPbActivity.this.eAA.Ic();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.eAA.gS(null);
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                                TiebaStatic.log(new am("c11739").r("obj_locate", 4));
                                                if (!j.jD()) {
                                                    NewSubPbActivity.this.showToast(d.k.network_not_available);
                                                    return;
                                                }
                                                Object tag = view.getTag();
                                                NewSubPbActivity.this.fGg.bfp();
                                                if (tag instanceof String) {
                                                    String HB = NewSubPbActivity.this.fGe.HB();
                                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                        NewSubPbActivity.this.rj(HB);
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
                                            } else if (j.jD()) {
                                                NewSubPbActivity.this.fGg.bfp();
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.bl(view);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                NewSubPbActivity.this.showToast(d.k.network_not_available);
                                                return;
                                            }
                                        }
                                        NewSubPbActivity.this.fGg.bfp();
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.fGg.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new am("c11739").r("obj_locate", 1));
                                    NewSubPbActivity.this.fGg.bfp();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.eAA.gS(null);
                                        if (NewSubPbActivity.this.fGs != null) {
                                            NewSubPbActivity.this.fGs.axe();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new am("c11739").r("obj_locate", 2));
                                    NewSubPbActivity.this.fGg.bfp();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.fGe.bgO() != null) {
                                        NewSubPbActivity.this.e(NewSubPbActivity.this.fGe.bgO().baY());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.fGg.bgu();
                                NewSubPbActivity.this.fGg.bgv();
                                if (NewSubPbActivity.this.eAA != null) {
                                    NewSubPbActivity.this.eAA.Ie();
                                    if (NewSubPbActivity.this.fGs != null) {
                                        NewSubPbActivity.this.fGs.axe();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.fGg.bgu();
                            NewSubPbActivity.this.fGg.bgv();
                            if (NewSubPbActivity.this.eAA != null) {
                                NewSubPbActivity.this.eAA.Id();
                                if (NewSubPbActivity.this.fGs != null) {
                                    NewSubPbActivity.this.fGs.axe();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.eAs == null || NewSubPbActivity.this.fGe == null || NewSubPbActivity.this.fGe.bbg() == null || NewSubPbActivity.this.eAs.cM(NewSubPbActivity.this.fGe.bbg().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.eAA.HT()) {
                                NewSubPbActivity.this.eAA.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.fGg.bgu();
                            NewSubPbActivity.this.fGg.bgv();
                            if (NewSubPbActivity.this.eAA != null) {
                                NewSubPbActivity.this.eAA.If();
                                if (NewSubPbActivity.this.fGs != null) {
                                    NewSubPbActivity.this.fGs.axe();
                                }
                            }
                        }
                    }
                }
            }
        };
        this.fGh = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.fGg.bfp();
                }
                NewSubPbActivity.this.eAA.Ic();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.fGg.bgK();
            }
        };
        this.fsA = new b.InterfaceC0103b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.fGe.bgO() != null) {
                    postData = NewSubPbActivity.this.fGe.bgO().baY();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.cj(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.e(postData);
                    }
                }
            }
        };
        this.aGs = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                    NewSubPbActivity.this.fGg.b(NewSubPbActivity.this.fsA, NewSubPbActivity.this.fGe.isMarked());
                }
                return true;
            }
        };
        this.fGi = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void b(View view, String str) {
                NewSubPbActivity.this.j(null, str, "LINK_IMAGE");
            }
        };
        this.fGj = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                    k bgO = NewSubPbActivity.this.fGe.bgO();
                    TbRichText aE = NewSubPbActivity.this.aE(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (aE != null && aE.Ng() != null) {
                        tbRichTextData = aE.Ng().get(NewSubPbActivity.this.fsx);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.Nm().Ny()) {
                            String b = NewSubPbActivity.this.b(tbRichTextData);
                            arrayList2.add(b);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                            concurrentHashMap3.put(b, imageUrlData);
                            String str4 = null;
                            String str5 = null;
                            String str6 = null;
                            if (bgO == null) {
                                str3 = null;
                                z4 = false;
                            } else {
                                if (bgO.bbf() != null) {
                                    str4 = bgO.bbf().getName();
                                    str5 = bgO.bbf().getId();
                                }
                                if (bgO.Sz() != null) {
                                    str6 = bgO.Sz().getId();
                                }
                                str3 = str6;
                                z4 = true;
                            }
                            if (NewSubPbActivity.this.fGe.bhb() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.fGe.bhb();
                                z5 = NewSubPbActivity.this.fGe.bhd();
                                arrayList2 = NewSubPbActivity.this.fGe.bhc();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z5 = z4;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(w.c(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.fsy = false;
                        String str7 = "";
                        TbRichText bxb = bgO.baY().bxb();
                        int size = arrayList2.size();
                        int a2 = NewSubPbActivity.this.a(bxb, aE, i, i, arrayList2, concurrentHashMap3);
                        int size2 = arrayList2.size();
                        if (size != size2) {
                            str7 = arrayList2.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (bgO == null) {
                            str2 = null;
                            z2 = false;
                        } else {
                            if (bgO.bbf() != null) {
                                str8 = bgO.bbf().getName();
                                str9 = bgO.bbf().getId();
                            }
                            if (bgO.Sz() != null) {
                                str10 = bgO.Sz().getId();
                            }
                            str2 = str10;
                            z2 = true;
                        }
                        if (NewSubPbActivity.this.fGe.bhb() != null) {
                            concurrentHashMap = NewSubPbActivity.this.fGe.bhb();
                            z3 = NewSubPbActivity.this.fGe.bhd();
                            arrayList = NewSubPbActivity.this.fGe.bhc();
                            i2 = a2 + NewSubPbActivity.this.fGe.getOffset();
                        } else {
                            concurrentHashMap = concurrentHashMap3;
                            i2 = a2;
                            z3 = z2;
                            arrayList = arrayList2;
                        }
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.add(w.c(arrayList, i2));
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
        TbRichTextImageInfo Nm;
        if (tbRichText == tbRichText2) {
            this.fsy = true;
        }
        if (tbRichText != null && tbRichText.Ng() != null) {
            int size = tbRichText.Ng().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Ng().get(i6) != null && tbRichText.Ng().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.Ng().get(i6).Nm().getWidth();
                    int height = tbRichText.Ng().get(i6).Nm().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Ng().get(i6).Nm().Ny()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Ng().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (Nm = tbRichTextData.Nm()) != null) {
                            String Nz = Nm.Nz();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Nz;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.fsy) {
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
        TbRichTextImageInfo Nm = tbRichTextData.Nm();
        if (Nm != null) {
            if (!StringUtils.isNull(Nm.Nx())) {
                return Nm.Nx();
            }
            if (Nm.getHeight() * Nm.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Nm.getHeight() * Nm.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Nm.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Nm.getHeight())));
            } else {
                float width = Nm.getWidth() / Nm.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ao.be(Nm.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aE(String str, int i) {
        if (this.fGe == null || this.fGe.bgO() == null || str == null || i < 0) {
            return null;
        }
        k bgO = this.fGe.bgO();
        TbRichText a2 = a(bgO.baY(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bgO.baY(), str, i);
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
        TbRichText bxb = postData.bxb();
        if (bxb != null) {
            ArrayList<TbRichTextData> Ng = bxb.Ng();
            int size = Ng.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Ng.get(i3) != null && Ng.get(i3).getType() == 8) {
                    i2++;
                    if (Ng.get(i3).Nm().Nz().equals(str)) {
                        int width = Ng.get(i3).Nm().getWidth();
                        int height = Ng.get(i3).Nm().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.fsx = i3;
                        return bxb;
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
        long templateId = this.fGe.bgO().baY().bxi() != null ? this.fGe.bgO().baY().bxi().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ay.zG().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.fGe.bgO().bbf().getId(), this.fGe.bgO().bbf().getName(), this.fGe.bgO().Sz().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(int i, String str) {
        if (this.fGe.bgP()) {
            showToast(str);
        } else if (l.jU()) {
            if (i == 4) {
                this.fGg.mG(str + "(4)");
            } else {
                this.fGg.ij(d.k.no_data_text);
            }
        } else {
            this.fGg.ij(d.k.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.eAA = (g) new com.baidu.tbadk.editortools.pb.h().aY(getActivity());
        if (this.eAA != null) {
            this.eAA.setContext(getPageContext());
            this.eAA.b(this.fGe);
            this.eAA.b(this.fGv);
            this.eAA.a(this.aNa);
            this.eAA.a(this.aNb);
            this.eAA.Hg().bB(true);
            this.eAA.d(getPageContext());
        }
        if (this.fGg != null) {
            this.fGg.g(this.eAA);
        }
        if (this.eAA != null && this.fGe != null) {
            this.eAA.a(this.fGe.bbg());
            this.eAA.Ic();
        }
        if (this.eAA != null) {
            this.fDq = this.eAA.Ig().getInputView();
            this.fDq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.fGt != null) {
                        if (!NewSubPbActivity.this.fGt.bGb()) {
                            NewSubPbActivity.this.kM(false);
                        }
                        NewSubPbActivity.this.fGt.ns(false);
                    }
                }
            });
        }
    }

    public void bgr() {
        if (!TbadkCoreApplication.isLogin()) {
            this.eAA.Ic();
        } else if (!StringUtils.isNull(this.fGe.bgW())) {
            this.fGg.rH(this.fGe.bgW());
            if (this.fGg.bgy() && l.jU()) {
                this.fGg.aqQ();
            } else {
                this.fGg.bgB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(d.g.tag_from, 1);
                    b(sparseArray);
                } else {
                    this.fGg.bh(view);
                }
            } else if (booleanValue2) {
                this.fGg.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.fGg.bgH(), getPageContext().getPageActivity());
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
        bVar.cf(d.k.operation);
        bVar.a(strArr, new b.InterfaceC0103b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                switch (i) {
                    case 0:
                        String str2 = "";
                        int intValue = sparseArray.get(d.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue() : 0;
                        if (sparseArray.get(d.g.tag_del_post_id) instanceof String) {
                            str2 = (String) sparseArray.get(d.g.tag_del_post_id);
                        }
                        NewSubPbActivity.this.fGg.a(intValue, str2, sparseArray.get(d.g.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue() : false);
                        break;
                    case 1:
                        String str3 = "";
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
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
                        if (sparseArray.get(d.g.tag_user_mute_mute_nameshow) instanceof String) {
                            str7 = (String) sparseArray.get(d.g.tag_user_mute_mute_nameshow);
                        }
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.fGq);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.fGq);
                        NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str6, str3, str7);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext()).xd();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
        }
        this.fGg.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.fGq;
        userMuteCheckCustomMessage.setTag(this.fGq);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.fGg.a(0, bVar.EY, bVar.gLr, z);
            if (bVar.EY) {
                if (bVar.gLp == 1) {
                    finish();
                } else if (bVar.gLp == 2) {
                    this.fGe.rK(bVar.mPostId);
                    this.fGg.a(this.fGe.bgO(), this.fGe.baA(), this.fGe.bhb() != null);
                    if (this.fGe.bgX()) {
                        this.fGe.kR(false);
                        this.fGg.bgw();
                        this.fGe.JE();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
            }
        }
    }

    public void rj(String str) {
        this.frp.rF(str);
    }

    public void e(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.fGe.isMarked() && postData.getId() != null && postData.getId().equals(this.fGe.bgV())) {
                z = true;
            }
            MarkData g = this.fGe.g(postData);
            if (g != null) {
                this.fGg.bfp();
                if (this.eSU != null) {
                    this.eSU.a(g);
                    if (!z) {
                        this.eSU.se();
                    } else {
                        this.eSU.sd();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.fGe != null) {
            this.fGe.z(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.eAA != null) {
            this.eAA.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.eAA.Hg().FB();
        this.eAA.Ic();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eAA.b(writeData);
                this.eAA.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k eM = this.eAA.Hg().eM(6);
                if (eM != null && eM.aLj != null) {
                    eM.aLj.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eAA.HY();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dhB != null) {
            this.dhB.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.fGo = true;
        super.onPause();
        if (this.dhB != null) {
            this.dhB.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.eeb);
        this.fGg.awf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fGo = false;
        super.onResume();
        if (this.dhB != null) {
            this.dhB.onResume(getPageContext());
        }
        registerListener(this.eeb);
        this.fGg.awg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dhB != null) {
            this.dhB.onStop(getPageContext());
        }
        this.eAA.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.fGu));
        this.fGe.cancelLoadData();
        this.fGe.destory();
        this.fGf.cancelLoadData();
        if (this.dhB != null) {
            this.dhB.onDestory(getPageContext());
        }
        this.fGg.bfp();
        this.fGg.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.fsm);
        MessageManager.getInstance().unRegisterListener(this.fsn);
        MessageManager.getInstance().unRegisterListener(this.fso);
        MessageManager.getInstance().unRegisterListener(this.fGq);
        this.frJ = null;
        this.frK = null;
        if (this.dio != null) {
            this.dio.onDestroy();
        }
        if (this.eAs != null) {
            this.eAs.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fGg.onChangeSkinType(i);
        if (this.dio != null) {
            this.dio.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dhB;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bgC = this.fGg.bgC();
        if (bgC == null || (findViewWithTag = bgC.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean ry(String str) {
        Map<String, String> eO;
        if (!TextUtils.isEmpty(str) && (eO = ay.eO(ay.eP(str))) != null) {
            this.fGr = true;
            String str2 = eO.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return ry(com.baidu.adp.lib.util.k.bf(str2));
            }
            String str3 = eO.get(fGd);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void f(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (ry(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
                    hVar.mLink = str;
                    hVar.type = 3;
                    hVar.aKf = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, hVar));
                }
            } else {
                ay.zG().c(getPageContext(), new String[]{str});
            }
            this.fGr = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fGr = true;
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
    public void h(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.fGg != null) {
            return this.fGg.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int NL() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> NN() {
        if (this.bev == null) {
            this.bev = TbRichTextView.j(getPageContext().getPageActivity(), 8);
        }
        return this.bev;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> NO() {
        if (this.bez == null) {
            this.bez = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bcx */
                public GifView mo9if() {
                    return new GifView(NewSubPbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void q(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView r(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView s(GifView gifView) {
                    return gifView;
                }
            }, 20, 0);
        }
        return this.bez;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> NM() {
        if (this.beu == null) {
            this.beu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aeW */
                public ImageView mo9if() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean tz = com.baidu.tbadk.core.i.tt().tz();
                    foreDrawableImageView.setDefaultBg(al.getDrawable(d.C0141d.common_color_10220));
                    if (tz) {
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
                public void q(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.C0141d.cp_bg_line_c);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView r(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.tt().tz()) {
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
                public ImageView s(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.C0141d.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.beu;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> NP() {
        if (this.bew == null) {
            this.bew = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bcy */
                public View mo9if() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bc */
                public void q(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bd */
                public View r(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: be */
                public View s(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.bew;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> NQ() {
        if (this.bex == null) {
            this.bex = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bcA */
                public LinearLayout mo9if() {
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
                /* renamed from: c */
                public void q(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public LinearLayout r(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: e */
                public LinearLayout s(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.bex;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> NR() {
        this.bey = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bcz */
            public RelativeLayout mo9if() {
                return new RelativeLayout(NewSubPbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void q(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout r(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout s(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.bey;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fGg.bgy() && l.jU()) {
            this.fGe.JE();
        } else {
            this.fGg.bgB();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
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
        if (!(sparseArray.get(d.g.tag_user_mute_post_id) instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) sparseArray.get(d.g.tag_user_mute_post_id);
        }
        String str7 = sparseArray.get(d.g.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(d.g.tag_user_mute_msg) : str2;
        if (sparseArray.get(d.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(d.g.tag_user_mute_msg);
        }
        if (sparseArray.get(d.g.tag_user_mute_mute_nameshow) instanceof String) {
            str6 = (String) sparseArray.get(d.g.tag_user_mute_mute_nameshow);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.fGq);
        userMuteAddAndDelCustomMessage.setTag(this.fGq);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
        j(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean JU() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int JV() {
                return com.baidu.tbadk.pageStayDuration.e.JZ().Kb();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.fGe != null) {
            if (this.fGe.bgO() != null && this.fGe.bgO().bbf() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fGe.bgO().bbf().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fGe.bdh(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.fGo;
    }

    public boolean bgs() {
        if (this.fGe != null) {
            return this.fGe.bgs();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.fGg.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.frJ.getPageActivity());
        if (ao.isEmpty(str)) {
            aVar.dB(this.frJ.getResources().getString(d.k.block_mute_message_alert, str3));
        } else {
            aVar.dB(str);
        }
        aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.fGg.showLoadingDialog();
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
        aVar.b(this.frJ).xa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gR(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.frJ.getPageActivity());
        aVar.dB(str);
        aVar.b(d.k.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.frJ).xa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dB(getResources().getString(d.k.mute_is_super_member_function));
        aVar.a(d.k.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.frJ).showToast(d.k.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.frJ.getPageActivity(), 2, true, 4);
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
        aVar.b(this.frJ).xa();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.aLG) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.aLG) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void kM(boolean z) {
        if (this.fDq != null && this.fDq.getText() != null) {
            int selectionEnd = this.fDq.getSelectionEnd();
            SpannableStringBuilder b = this.fGt.b(this.fDq.getText());
            if (b != null) {
                this.fGt.ns(true);
                this.fDq.setText(b);
                if (z && this.fGt.bFZ() >= 0) {
                    this.fDq.requestFocus();
                    this.fDq.setSelection(this.fGt.bFZ());
                } else {
                    this.fDq.setSelection(selectionEnd);
                }
                this.fGt.nr(this.fGt.bFZ() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.dio == null) {
            this.dio = new h(getPageContext());
            this.dio.a(new h.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void aC(boolean z) {
                    if (z) {
                        TiebaStatic.log(new am("c13061"));
                    }
                }
            });
        }
        this.dio.a(contriInfo, -1L);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.eAA != null && this.eAA.Hg() != null && this.eAA.Hg().Hj()) {
            this.eAA.Hg().FB();
        } else {
            super.onBackPressed();
        }
    }
}
