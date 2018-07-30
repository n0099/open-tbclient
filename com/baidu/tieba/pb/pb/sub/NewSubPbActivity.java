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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
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
    private static final String fIU = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String fKs = "tbgametype";
    private View.OnLongClickListener aHk;
    private com.baidu.adp.lib.e.b<ImageView> bfU;
    private com.baidu.adp.lib.e.b<TextView> bfV;
    private com.baidu.adp.lib.e.b<View> bfW;
    private com.baidu.adp.lib.e.b<LinearLayout> bfX;
    private com.baidu.adp.lib.e.b<RelativeLayout> bfY;
    private com.baidu.adp.lib.e.b<GifView> bfZ;
    private VoiceManager dmp;
    private h dnc;
    public ak eIc;
    private g eIk;
    private PostWriteCallBackData fAn;
    private EditText fHG;
    private com.baidu.adp.base.d fKA;
    private BdUniqueId fKF;
    private com.baidu.tieba.pb.pb.sub.a fKH;
    private com.baidu.tieba.write.b fKI;
    private com.baidu.tieba.pb.d<k> fKJ;
    private SubPbModel fKt;
    private ForumManageModel fKu;
    private b fKv;
    private AbsListView.OnScrollListener fKw;
    private TbRichTextView.i fKx;
    private TbRichTextView.h fKy;
    private SubPbModel.a fKz;
    private com.baidu.adp.base.e fvN;
    private com.baidu.tbadk.core.view.d fvO;
    private com.baidu.tieba.pb.pb.report.a fvt;
    private com.baidu.tbadk.baseEditMark.a fvu;
    private b.InterfaceC0101b fwE;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int fwB = 0;
    private a.InterfaceC0097a fwx = null;
    private a fKB = null;
    private a fKC = null;
    private boolean fKD = false;
    private boolean fKE = false;
    private boolean fKG = false;
    private boolean aMC = false;
    private com.baidu.tbadk.editortools.pb.c aNV = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void HR() {
            NewSubPbActivity.this.fKv.bfA();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aNW = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean HQ() {
            if (!NewSubPbActivity.this.fKI.bFl()) {
                return (NewSubPbActivity.this.eIc == null || NewSubPbActivity.this.fKt == null || NewSubPbActivity.this.fKt.Ce() == null || NewSubPbActivity.this.eIc.u(NewSubPbActivity.this.fKt.Ce().replyPrivateFlag, ak.aqA)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.fKI.bFn());
            if (NewSubPbActivity.this.eIk.Ig()) {
                NewSubPbActivity.this.eIk.a(NewSubPbActivity.this.fAn);
            }
            NewSubPbActivity.this.kI(true);
            return true;
        }
    };
    private NewWriteModel.d fKK = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.eIk != null && NewSubPbActivity.this.eIk.Ht() != null) {
                NewSubPbActivity.this.eIk.Ht().hide();
                if (NewSubPbActivity.this.fKt.bfU()) {
                    TiebaStatic.log(new an("c10367").af("post_id", NewSubPbActivity.this.fKt.HO()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fKI.vv(null);
                NewSubPbActivity.this.fKI.az(null);
                NewSubPbActivity.this.fKI.nn(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    NewSubPbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fKI.az(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fKI.vv(postWriteCallBackData.getErrorString());
                if (!w.z(NewSubPbActivity.this.fKI.bFj())) {
                    NewSubPbActivity.this.fAn = postWriteCallBackData;
                    if (NewSubPbActivity.this.eIk.Ig()) {
                        NewSubPbActivity.this.eIk.a(NewSubPbActivity.this.fAn);
                    }
                    NewSubPbActivity.this.kI(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.eIc != null) {
                NewSubPbActivity.this.eIc.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.fKv.bfB();
        }
    };
    private CustomMessageListener fwq = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fKF) {
                NewSubPbActivity.this.fKv.aeP();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fvO.e(NewSubPbActivity.this.fvN.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.fvN.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.gR(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bbr();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ap.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.fvN.getResources().getString(d.j.mute_fail);
                    }
                    NewSubPbActivity.this.fvO.f(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fwr = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fKF) {
                NewSubPbActivity.this.fKv.aeP();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fvO.e(NewSubPbActivity.this.fvN.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ap.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.fvN.getResources().getString(d.j.un_mute_fail);
                }
                NewSubPbActivity.this.fvO.f(muteMessage);
            }
        }
    };
    private CustomMessageListener fws = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fKF) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.fKv.aeP();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.hbr;
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
                    NewSubPbActivity.this.fKv.a(sparseArray, z);
                }
            }
        }
    };
    boolean fwC = false;
    private CustomMessageListener elL = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener dny = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.fKt.bfO() != null && NewSubPbActivity.this.fKt.bfO().aZZ() != null && NewSubPbActivity.this.fKt.bfO().aZZ().vk() != null && currentAccount.equals(NewSubPbActivity.this.fKt.bfO().aZZ().vk().getUserId()) && NewSubPbActivity.this.fKt.bfO().aZZ().vk().getPendantData() != null) {
                        NewSubPbActivity.this.fKt.bfO().aZZ().vk().getPendantData().dj(iVar.tU());
                        NewSubPbActivity.this.fKt.bfO().aZZ().vk().getPendantData().Z(iVar.GZ());
                        NewSubPbActivity.this.fKv.a(NewSubPbActivity.this.fKt.bfO().aZZ(), NewSubPbActivity.this.fKt.bfO().aMN(), NewSubPbActivity.this.fKt.bfO().rN(), NewSubPbActivity.this.fKt.aZz(), NewSubPbActivity.this.fKt.bgb() != null);
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
        if (this.aMC) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.fvN = getPageContext();
        this.fKE = true;
        this.fKI = new com.baidu.tieba.write.b();
        this.fKI.vj(d.C0140d.cp_cont_h_alpha85);
        this.fKI.vi(d.C0140d.cp_cont_i);
        ayj();
        bfr();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bfq();
        this.fvO = new com.baidu.tbadk.core.view.d();
        this.fvO.auS = 1000L;
        registerListener(this.fws);
        registerListener(this.fwq);
        registerListener(this.fwr);
        this.fKF = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fKF;
        userMuteAddAndDelCustomMessage.setTag(this.fKF);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fKF;
        userMuteCheckCustomMessage.setTag(this.fKF);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eIc = new ak(getPageContext());
        this.eIc.a(new ak.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tbadk.core.util.ak.a
            public void c(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.eIk.Il();
                }
            }
        });
        this.fvt = new com.baidu.tieba.pb.pb.report.a(this);
        this.fvt.o(getUniqueId());
    }

    private void bfq() {
        if (this.fKv != null && this.fKt != null && this.fKt.bft()) {
            this.fKH = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.fKv.Vf());
            this.fKH.ayo();
            this.fKH.a(new a.InterfaceC0213a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
                private boolean dAe = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0213a
                public void ayk() {
                    NewSubPbActivity.this.fKv.gf(false);
                    this.dAe = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0213a
                public void ayl() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0213a
                public boolean aym() {
                    if (!this.dAe) {
                        return NewSubPbActivity.this.fKv.ayA() != null && NewSubPbActivity.this.fKv.ayA().getTop() == 0;
                    }
                    this.dAe = false;
                    return false;
                }
            });
            this.fKv.e(this.fKH);
            this.fKv.gf(true);
        }
    }

    public void initUI() {
        this.fKv = new b(this, this.mCommonClickListener);
        this.fKv.a(this.fKt);
        setContentView(this.fKv.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.fKv.setOnScrollListener(this.fKw);
        this.fKv.a(this);
        this.fKv.setOnLinkImageClickListener(this.fKx);
        this.fKv.setOnImageClickListener(this.fKy);
        this.fKv.jt(true);
        this.fKv.setOnLongClickListener(this.aHk);
        this.fKv.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.fKt != null) {
                    NewSubPbActivity.this.fKt.JR();
                }
            }
        });
        this.fKv.a(this.fKB);
        this.fKv.b(this.fKC);
        if (this.fKt != null && this.fKt.bft() && !this.fKt.bga()) {
            this.fKv.bfF().setVisibility(8);
        } else {
            this.fKv.bfF().setVisibility(0);
        }
        if (this.fKt != null && !this.fKt.bft()) {
            this.fKv.setIsFromPb(false);
        }
    }

    private boolean A(Bundle bundle) {
        if (bundle != null) {
            this.aMC = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.aMC = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.aMC;
    }

    public void initData(Bundle bundle) {
        this.fKt = new SubPbModel(getPageContext());
        this.fKt.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void k(PostData postData) {
                NewSubPbActivity.this.fKv.m(postData);
                NewSubPbActivity.this.fKv.a((BdListView.e) null);
            }
        });
        this.fKu = new ForumManageModel(this);
        this.fKu.setLoadDataCallBack(this.fKA);
        this.dmp = new VoiceManager();
        this.dmp.onCreate(getPageContext());
        this.fvu = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fvu != null) {
            this.fvu.a(this.fwx);
        }
        if (bundle != null) {
            this.fKt.initWithBundle(bundle);
        } else {
            this.fKt.initWithIntent(getIntent());
        }
        this.fKt.a(this.fKz);
        if (this.fKt.bft()) {
            this.fKt.JR();
        } else {
            this.fKt.bfT();
        }
    }

    public void bfr() {
        this.fKz = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, k kVar) {
                if (NewSubPbActivity.this.fKv != null) {
                    NewSubPbActivity.this.fKv.bfB();
                }
                if (NewSubPbActivity.this.fKH != null && NewSubPbActivity.this.fKH.ayp()) {
                    NewSubPbActivity.this.fKH.lh(d.C0140d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.ah(i, str);
                    return;
                }
                NewSubPbActivity.this.fKv.hideNoDataView();
                if (kVar != null) {
                    if (kVar.aZZ() != null || NewSubPbActivity.this.fKt != null) {
                        kVar.aZZ().a(NewSubPbActivity.this.fKt.bfZ());
                    }
                    if (NewSubPbActivity.this.fKv != null) {
                        NewSubPbActivity.this.fKv.a(kVar, NewSubPbActivity.this.fKt.aZz(), NewSubPbActivity.this.fKt.bgb() != null);
                        if (NewSubPbActivity.this.fKE) {
                            NewSubPbActivity.this.bfs();
                            NewSubPbActivity.this.fKE = false;
                        }
                    }
                    if (NewSubPbActivity.this.eIk != null) {
                        NewSubPbActivity.this.eIk.a(kVar.Ce());
                    }
                    if (NewSubPbActivity.this.fKJ == null) {
                        NewSubPbActivity.this.fKJ = new com.baidu.tieba.pb.d();
                    }
                    NewSubPbActivity.this.fKJ.setData(kVar);
                    NewSubPbActivity.this.fKJ.setType(0);
                    NewSubPbActivity.this.eIc.a(NewSubPbActivity.this.fKt.bge());
                }
            }
        };
        this.fwx = new a.InterfaceC0097a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0097a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.fvu != null) {
                        NewSubPbActivity.this.fvu.ad(z2);
                    }
                    MarkData rQ = NewSubPbActivity.this.fvu.rQ();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setType(2);
                    if (z2) {
                        dVar.setData(rQ);
                        if (NewSubPbActivity.this.fvu != null) {
                            if (rQ != null) {
                                NewSubPbActivity.this.fKt.kM(true);
                                NewSubPbActivity.this.fKt.rE(NewSubPbActivity.this.fKt.HO());
                                NewSubPbActivity.this.showToast(d.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.add_mark));
                            }
                            if (NewSubPbActivity.this.fKv != null) {
                                NewSubPbActivity.this.fKv.kJ(true);
                            }
                        }
                    } else {
                        dVar.setData(null);
                        NewSubPbActivity.this.fKt.kM(false);
                        NewSubPbActivity.this.fKt.rE(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.remove_mark));
                        if (NewSubPbActivity.this.fKv != null) {
                            NewSubPbActivity.this.fKv.kJ(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.update_mark_failed));
            }
        };
        this.fKB = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void i(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.fKt.bfO() != null && NewSubPbActivity.this.fKt.bfO().Td() != null && NewSubPbActivity.this.fKt.bfO().Td().vk() != null) {
                    str = String.valueOf(NewSubPbActivity.this.fKt.bfO().Td().vk().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.fKt.bfO().bag().getId(), NewSubPbActivity.this.fKt.bfO().bag().getName(), NewSubPbActivity.this.fKt.bfO().Td().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.fKC = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void i(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.fKu.bwT() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                        boolean c = com.baidu.adp.lib.g.b.c(String.valueOf(objArr[2]), false);
                        int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.fKt != null && NewSubPbActivity.this.fKt.bfO() != null && NewSubPbActivity.this.fKt.bfO().bag() != null && NewSubPbActivity.this.fKt.bfO().Td() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.fKu.tQ(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.fKu.a(NewSubPbActivity.this.fKt.bfO().bag().getId(), NewSubPbActivity.this.fKt.bfO().bag().getName(), NewSubPbActivity.this.fKt.bfO().Td().getId(), valueOf, g2, g, c);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.fKA = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.fKv.a(NewSubPbActivity.this.fKu.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.fKu.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.fLw != 1002 || bVar.dPN) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.fKv.a(1, dVar.EX, dVar.gQr, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void ayj() {
        registerListener(this.dny);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.fKv != null) {
                    if (view == NewSubPbActivity.this.fKv.bfL()) {
                        NewSubPbActivity.this.fKv.beq();
                        String str = view.getTag(d.g.tag_user_id) instanceof String ? (String) view.getTag(d.g.tag_user_id) : null;
                        String str2 = view.getTag(d.g.tag_user_name) instanceof String ? (String) view.getTag(d.g.tag_user_name) : null;
                        String str3 = view.getTag(d.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(d.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ay.zK().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.fKv.ayB()) {
                        if (view != NewSubPbActivity.this.fKv.bfE()) {
                            if (view != NewSubPbActivity.this.fKv.bfD()) {
                                if (view == NewSubPbActivity.this.fKv.bfz()) {
                                    NewSubPbActivity.this.fKv.beq();
                                    if (NewSubPbActivity.this.fKt.JR()) {
                                        NewSubPbActivity.this.fKv.bfx();
                                    }
                                } else if (view == NewSubPbActivity.this.fKv.bfF() || view == NewSubPbActivity.this.fKv.bfG() || view == NewSubPbActivity.this.fKv.bfI()) {
                                    if (NewSubPbActivity.this.fKG) {
                                        NewSubPbActivity.this.fKG = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.fKt.bci(), NewSubPbActivity.this.fKt.HO(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.fKt.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.fKt.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.fKv.bfJ() == null || view != NewSubPbActivity.this.fKv.bfJ().bcU()) {
                                    if (NewSubPbActivity.this.fKv.bfJ() == null || view != NewSubPbActivity.this.fKv.bfJ().bcZ()) {
                                        if (NewSubPbActivity.this.fKv.bfJ() == null || view != NewSubPbActivity.this.fKv.bfJ().bcX()) {
                                            if (NewSubPbActivity.this.fKv.bfJ() == null || view != NewSubPbActivity.this.fKv.bfJ().bcV()) {
                                                if (NewSubPbActivity.this.fKv.bfJ() == null || view != NewSubPbActivity.this.fKv.bfJ().bcW()) {
                                                    if ((view == NewSubPbActivity.this.fKv.bfC() || view == NewSubPbActivity.this.fKv.bfI()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.eIk.Io()) {
                                                            NewSubPbActivity.this.eIk.Ip();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.eIk.gS(null);
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                                TiebaStatic.log(new an("c11739").r("obj_locate", 4));
                                                if (!j.jE()) {
                                                    NewSubPbActivity.this.showToast(d.j.network_not_available);
                                                    return;
                                                }
                                                Object tag = view.getTag();
                                                NewSubPbActivity.this.fKv.beq();
                                                if (tag instanceof String) {
                                                    String HO = NewSubPbActivity.this.fKt.HO();
                                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                        NewSubPbActivity.this.rc(HO);
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
                                            } else if (j.jE()) {
                                                NewSubPbActivity.this.fKv.beq();
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.bp(view);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                NewSubPbActivity.this.showToast(d.j.network_not_available);
                                                return;
                                            }
                                        }
                                        NewSubPbActivity.this.fKv.beq();
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.fKv.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new an("c11739").r("obj_locate", 1));
                                    NewSubPbActivity.this.fKv.beq();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.eIk.gS(null);
                                        if (NewSubPbActivity.this.fKH != null) {
                                            NewSubPbActivity.this.fKH.ayn();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new an("c11739").r("obj_locate", 2));
                                    NewSubPbActivity.this.fKv.beq();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.fKt.bfO() != null) {
                                        NewSubPbActivity.this.e(NewSubPbActivity.this.fKt.bfO().aZZ());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.fKv.bfu();
                                NewSubPbActivity.this.fKv.bfv();
                                if (NewSubPbActivity.this.eIk != null) {
                                    NewSubPbActivity.this.eIk.Ir();
                                    if (NewSubPbActivity.this.fKH != null) {
                                        NewSubPbActivity.this.fKH.ayn();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.fKv.bfu();
                            NewSubPbActivity.this.fKv.bfv();
                            if (NewSubPbActivity.this.eIk != null) {
                                NewSubPbActivity.this.eIk.Iq();
                                if (NewSubPbActivity.this.fKH != null) {
                                    NewSubPbActivity.this.fKH.ayn();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.eIc == null || NewSubPbActivity.this.fKt == null || NewSubPbActivity.this.fKt.Ce() == null || NewSubPbActivity.this.eIc.cP(NewSubPbActivity.this.fKt.Ce().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.eIk.Ig()) {
                                NewSubPbActivity.this.eIk.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.fKv.bfu();
                            NewSubPbActivity.this.fKv.bfv();
                            if (NewSubPbActivity.this.eIk != null) {
                                NewSubPbActivity.this.eIk.Is();
                                if (NewSubPbActivity.this.fKH != null) {
                                    NewSubPbActivity.this.fKH.ayn();
                                }
                            }
                        }
                    }
                }
            }
        };
        this.fKw = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.fKv.beq();
                }
                NewSubPbActivity.this.eIk.Ip();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.fKv.bfK();
            }
        };
        this.fwE = new b.InterfaceC0101b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.fKt.bfO() != null) {
                    postData = NewSubPbActivity.this.fKt.bfO().aZZ();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.ci(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.e(postData);
                    }
                }
            }
        };
        this.aHk = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                    NewSubPbActivity.this.fKv.b(NewSubPbActivity.this.fwE, NewSubPbActivity.this.fKt.isMarked());
                }
                return true;
            }
        };
        this.fKx = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void b(View view, String str) {
                NewSubPbActivity.this.j(null, str, "LINK_IMAGE");
            }
        };
        this.fKy = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                    k bfO = NewSubPbActivity.this.fKt.bfO();
                    TbRichText aB = NewSubPbActivity.this.aB(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (aB != null && aB.Nx() != null) {
                        tbRichTextData = aB.Nx().get(NewSubPbActivity.this.fwB);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.ND().NP()) {
                            String b = NewSubPbActivity.this.b(tbRichTextData);
                            arrayList2.add(b);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                            concurrentHashMap3.put(b, imageUrlData);
                            String str4 = null;
                            String str5 = null;
                            String str6 = null;
                            if (bfO == null) {
                                str3 = null;
                                z4 = false;
                            } else {
                                if (bfO.bag() != null) {
                                    str4 = bfO.bag().getName();
                                    str5 = bfO.bag().getId();
                                }
                                if (bfO.Td() != null) {
                                    str6 = bfO.Td().getId();
                                }
                                str3 = str6;
                                z4 = true;
                            }
                            if (NewSubPbActivity.this.fKt.bgb() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.fKt.bgb();
                                z5 = NewSubPbActivity.this.fKt.bgd();
                                arrayList2 = NewSubPbActivity.this.fKt.bgc();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z5 = z4;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(w.d(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.fwC = false;
                        String str7 = "";
                        TbRichText bwh = bfO.aZZ().bwh();
                        int size = arrayList2.size();
                        int a2 = NewSubPbActivity.this.a(bwh, aB, i, i, arrayList2, concurrentHashMap3);
                        int size2 = arrayList2.size();
                        if (size != size2) {
                            str7 = arrayList2.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (bfO == null) {
                            str2 = null;
                            z2 = false;
                        } else {
                            if (bfO.bag() != null) {
                                str8 = bfO.bag().getName();
                                str9 = bfO.bag().getId();
                            }
                            if (bfO.Td() != null) {
                                str10 = bfO.Td().getId();
                            }
                            str2 = str10;
                            z2 = true;
                        }
                        if (NewSubPbActivity.this.fKt.bgb() != null) {
                            concurrentHashMap = NewSubPbActivity.this.fKt.bgb();
                            z3 = NewSubPbActivity.this.fKt.bgd();
                            arrayList = NewSubPbActivity.this.fKt.bgc();
                            i2 = a2 + NewSubPbActivity.this.fKt.getOffset();
                        } else {
                            concurrentHashMap = concurrentHashMap3;
                            i2 = a2;
                            z3 = z2;
                            arrayList = arrayList2;
                        }
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.add(w.d(arrayList, i2));
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
        TbRichTextImageInfo ND;
        if (tbRichText == tbRichText2) {
            this.fwC = true;
        }
        if (tbRichText != null && tbRichText.Nx() != null) {
            int size = tbRichText.Nx().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Nx().get(i6) != null && tbRichText.Nx().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.Nx().get(i6).ND().getWidth();
                    int height = tbRichText.Nx().get(i6).ND().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Nx().get(i6).ND().NP()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Nx().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (ND = tbRichTextData.ND()) != null) {
                            String NS = ND.NS();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = NS;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.fwC) {
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
        TbRichTextImageInfo ND = tbRichTextData.ND();
        if (ND != null) {
            if (!StringUtils.isNull(ND.NO())) {
                return ND.NO();
            }
            if (ND.getHeight() * ND.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (ND.getHeight() * ND.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (ND.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * ND.getHeight())));
            } else {
                float width = ND.getWidth() / ND.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ap.bh(ND.NQ()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aB(String str, int i) {
        if (this.fKt == null || this.fKt.bfO() == null || str == null || i < 0) {
            return null;
        }
        k bfO = this.fKt.bfO();
        TbRichText a2 = a(bfO.aZZ(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bfO.aZZ(), str, i);
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
        TbRichText bwh = postData.bwh();
        if (bwh != null) {
            ArrayList<TbRichTextData> Nx = bwh.Nx();
            int size = Nx.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Nx.get(i3) != null && Nx.get(i3).getType() == 8) {
                    i2++;
                    if (Nx.get(i3).ND().NS().equals(str)) {
                        int width = Nx.get(i3).ND().getWidth();
                        int height = Nx.get(i3).ND().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.fwB = i3;
                        return bwh;
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
        long templateId = this.fKt.bfO().aZZ().bwo() != null ? this.fKt.bfO().aZZ().bwo().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ay.zK().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.fKt.bfO().bag().getId(), this.fKt.bfO().bag().getName(), this.fKt.bfO().Td().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(int i, String str) {
        if (this.fKt.bfP()) {
            showToast(str);
        } else if (l.jV()) {
            if (i == 4) {
                this.fKv.mF(str + "(4)");
            } else {
                this.fKv.it(d.j.no_data_text);
            }
        } else {
            this.fKv.it(d.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.eIk = (g) new com.baidu.tbadk.editortools.pb.h().aZ(getActivity());
        if (this.eIk != null) {
            this.eIk.setContext(getPageContext());
            this.eIk.b(this.fKt);
            this.eIk.b(this.fKK);
            this.eIk.a(this.aNV);
            this.eIk.a(this.aNW);
            this.eIk.Ht().bC(true);
            this.eIk.d(getPageContext());
        }
        if (this.fKv != null) {
            this.fKv.g(this.eIk);
        }
        if (this.eIk != null && this.fKt != null) {
            this.eIk.a(this.fKt.Ce());
            this.eIk.Ip();
        }
        if (this.eIk != null) {
            this.fHG = this.eIk.It().getInputView();
            this.fHG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.fKI != null) {
                        if (!NewSubPbActivity.this.fKI.bFm()) {
                            NewSubPbActivity.this.kI(false);
                        }
                        NewSubPbActivity.this.fKI.no(false);
                    }
                }
            });
        }
    }

    public void bfs() {
        if (!TbadkCoreApplication.isLogin()) {
            this.eIk.Ip();
        } else if (!StringUtils.isNull(this.fKt.bfW())) {
            this.fKv.rA(this.fKt.bfW());
            if (this.fKv.bfy() && l.jV()) {
                this.fKv.aqL();
            } else {
                this.fKv.bfB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(View view) {
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
                    this.fKv.bl(view);
                }
            } else if (booleanValue2) {
                this.fKv.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.fKv.bfH(), getPageContext().getPageActivity());
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
        bVar.ci(d.j.operation);
        bVar.a(strArr, new b.InterfaceC0101b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                switch (i) {
                    case 0:
                        String str2 = "";
                        int intValue = sparseArray.get(d.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue() : 0;
                        if (sparseArray.get(d.g.tag_del_post_id) instanceof String) {
                            str2 = (String) sparseArray.get(d.g.tag_del_post_id);
                        }
                        NewSubPbActivity.this.fKv.a(intValue, str2, sparseArray.get(d.g.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue() : false);
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
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.fKF);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.fKF);
                        NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str6, str3, str7);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext()).xi();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
        }
        this.fKv.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.fKF;
        userMuteCheckCustomMessage.setTag(this.fKF);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.fKv.a(0, bVar.EX, bVar.gQr, z);
            if (bVar.EX) {
                if (bVar.gQp == 1) {
                    finish();
                } else if (bVar.gQp == 2) {
                    this.fKt.rD(bVar.mPostId);
                    this.fKv.a(this.fKt.bfO(), this.fKt.aZz(), this.fKt.bgb() != null);
                    if (this.fKt.bfX()) {
                        this.fKt.kN(false);
                        this.fKv.bfw();
                        this.fKt.JR();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
            }
        }
    }

    public void rc(String str) {
        this.fvt.ry(str);
    }

    public void e(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.fKt.isMarked() && postData.getId() != null && postData.getId().equals(this.fKt.bfV())) {
                z = true;
            }
            MarkData g = this.fKt.g(postData);
            if (g != null) {
                this.fKv.beq();
                if (this.fvu != null) {
                    this.fvu.a(g);
                    if (!z) {
                        this.fvu.rP();
                    } else {
                        this.fvu.rO();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.fKt != null) {
            this.fKt.z(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.eIk != null) {
            this.eIk.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.eIk.Ht().FP();
        this.eIk.Ip();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eIk.b(writeData);
                this.eIk.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k eO = this.eIk.Ht().eO(6);
                if (eO != null && eO.aMf != null) {
                    eO.aMf.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eIk.Il();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dmp != null) {
            this.dmp.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.fKD = true;
        super.onPause();
        if (this.dmp != null) {
            this.dmp.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.elL);
        this.fKv.axo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fKD = false;
        super.onResume();
        if (this.dmp != null) {
            this.dmp.onResume(getPageContext());
        }
        registerListener(this.elL);
        this.fKv.axp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dmp != null) {
            this.dmp.onStop(getPageContext());
        }
        this.eIk.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.fKJ));
        this.fKt.cancelLoadData();
        this.fKt.destory();
        this.fKu.cancelLoadData();
        if (this.dmp != null) {
            this.dmp.onDestory(getPageContext());
        }
        this.fKv.beq();
        this.fKv.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.fwq);
        MessageManager.getInstance().unRegisterListener(this.fwr);
        MessageManager.getInstance().unRegisterListener(this.fws);
        MessageManager.getInstance().unRegisterListener(this.fKF);
        this.fvN = null;
        this.fvO = null;
        if (this.dnc != null) {
            this.dnc.onDestroy();
        }
        if (this.eIc != null) {
            this.eIc.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fKv.onChangeSkinType(i);
        if (this.dnc != null) {
            this.dnc.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dmp;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bfC = this.fKv.bfC();
        if (bfC == null || (findViewWithTag = bfC.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean rr(String str) {
        Map<String, String> eP;
        if (!TextUtils.isEmpty(str) && (eP = ay.eP(ay.eQ(str))) != null) {
            this.fKG = true;
            String str2 = eP.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return rr(com.baidu.adp.lib.util.k.bi(str2));
            }
            String str3 = eP.get(fKs);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void f(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (rr(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
                    hVar.mLink = str;
                    hVar.type = 3;
                    hVar.aLi = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, hVar));
                }
            } else {
                ay.zK().c(getPageContext(), new String[]{str});
            }
            this.fKG = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fKG = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aa(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void h(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.fKv != null) {
            return this.fKv.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Oe() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Og() {
        if (this.bfV == null) {
            this.bfV = TbRichTextView.k(getPageContext().getPageActivity(), 8);
        }
        return this.bfV;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Oh() {
        if (this.bfZ == null) {
            this.bfZ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bbx */
                public GifView ig() {
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
        return this.bfZ;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Of() {
        if (this.bfU == null) {
            this.bfU = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: afY */
                public ImageView ig() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean tk = com.baidu.tbadk.core.i.te().tk();
                    foreDrawableImageView.setDefaultBg(am.getDrawable(d.C0140d.common_color_10220));
                    if (tk) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0140d.cp_bg_line_c);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView r(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.te().tk()) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0140d.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.bfU;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Oi() {
        if (this.bfW == null) {
            this.bfW = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bby */
                public View ig() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bg */
                public void q(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bh */
                public View r(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bi */
                public View s(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.bfW;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Oj() {
        if (this.bfX == null) {
            this.bfX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bbA */
                public LinearLayout ig() {
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
        return this.bfX;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Ok() {
        this.bfY = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bbz */
            public RelativeLayout ig() {
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
        return this.bfY;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fKv.bfy() && l.jV()) {
            this.fKt.JR();
        } else {
            this.fKv.bfB();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.fKF);
        userMuteAddAndDelCustomMessage.setTag(this.fKF);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ab(Context context, String str) {
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
            public boolean Kh() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Ki() {
                return com.baidu.tbadk.pageStayDuration.e.Km().Ko();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.fKt != null) {
            if (this.fKt.bfO() != null && this.fKt.bfO().bag() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fKt.bfO().bag().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fKt.bci(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.fKD;
    }

    public boolean bft() {
        if (this.fKt != null) {
            return this.fKt.bft();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.fKv.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fvN.getPageActivity());
        if (ap.isEmpty(str)) {
            aVar.dB(this.fvN.getResources().getString(d.j.block_mute_message_alert, str3));
        } else {
            aVar.dB(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.fKv.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fvN).xf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gR(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fvN.getPageActivity());
        aVar.dB(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fvN).xf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dB(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.fvN).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.fvN.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fvN).xf();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.aMC) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.aMC) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void kI(boolean z) {
        if (this.fHG != null && this.fHG.getText() != null) {
            int selectionEnd = this.fHG.getSelectionEnd();
            SpannableStringBuilder b = this.fKI.b(this.fHG.getText());
            if (b != null) {
                this.fKI.no(true);
                this.fHG.setText(b);
                if (z && this.fKI.bFk() >= 0) {
                    this.fHG.requestFocus();
                    this.fHG.setSelection(this.fKI.bFk());
                } else {
                    this.fHG.setSelection(selectionEnd);
                }
                this.fKI.nn(this.fKI.bFk() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.dnc == null) {
            this.dnc = new h(getPageContext());
            this.dnc.a(new h.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void aC(boolean z) {
                    if (z) {
                        TiebaStatic.log(new an("c13061"));
                    }
                }
            });
        }
        this.dnc.a(contriInfo, -1L);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.eIk != null && this.eIk.Ht() != null && this.eIk.Ht().Hw()) {
            this.eIk.Ht().FP();
        } else {
            super.onBackPressed();
        }
    }
}
