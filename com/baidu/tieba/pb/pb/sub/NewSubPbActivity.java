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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.u;
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
import com.baidu.tieba.f;
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
    private static final String fIN = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String fKl = "tbgametype";
    private View.OnLongClickListener aHj;
    private com.baidu.adp.lib.e.b<ImageView> bfV;
    private com.baidu.adp.lib.e.b<TextView> bfW;
    private com.baidu.adp.lib.e.b<View> bfX;
    private com.baidu.adp.lib.e.b<LinearLayout> bfY;
    private com.baidu.adp.lib.e.b<RelativeLayout> bfZ;
    private com.baidu.adp.lib.e.b<GifView> bga;
    private VoiceManager dmn;
    private h dna;
    public ak eHX;
    private g eIf;
    private PostWriteCallBackData fAg;
    private EditText fHz;
    private com.baidu.tieba.pb.pb.sub.a fKA;
    private com.baidu.tieba.write.b fKB;
    private com.baidu.tieba.pb.d<k> fKC;
    private SubPbModel fKm;
    private ForumManageModel fKn;
    private b fKo;
    private AbsListView.OnScrollListener fKp;
    private TbRichTextView.i fKq;
    private TbRichTextView.h fKr;
    private SubPbModel.a fKs;
    private com.baidu.adp.base.d fKt;
    private BdUniqueId fKy;
    private com.baidu.adp.base.e fvG;
    private com.baidu.tbadk.core.view.d fvH;
    private com.baidu.tieba.pb.pb.report.a fvm;
    private com.baidu.tbadk.baseEditMark.a fvn;
    private b.InterfaceC0101b fwx;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int fwu = 0;
    private a.InterfaceC0097a fwq = null;
    private a fKu = null;
    private a fKv = null;
    private boolean fKw = false;
    private boolean fKx = false;
    private boolean fKz = false;
    private boolean aMz = false;
    private com.baidu.tbadk.editortools.pb.c aNS = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void HR() {
            NewSubPbActivity.this.fKo.bfv();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aNT = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean HQ() {
            if (!NewSubPbActivity.this.fKB.bFp()) {
                return (NewSubPbActivity.this.eHX == null || NewSubPbActivity.this.fKm == null || NewSubPbActivity.this.fKm.Cb() == null || NewSubPbActivity.this.eHX.u(NewSubPbActivity.this.fKm.Cb().replyPrivateFlag, ak.aqB)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.fKB.bFr());
            if (NewSubPbActivity.this.eIf.Ig()) {
                NewSubPbActivity.this.eIf.a(NewSubPbActivity.this.fAg);
            }
            NewSubPbActivity.this.kI(true);
            return true;
        }
    };
    private NewWriteModel.d fKD = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, u uVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.eIf != null && NewSubPbActivity.this.eIf.Ht() != null) {
                NewSubPbActivity.this.eIf.Ht().hide();
                if (NewSubPbActivity.this.fKm.bfP()) {
                    TiebaStatic.log(new an("c10367").ae("post_id", NewSubPbActivity.this.fKm.HO()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fKB.vz(null);
                NewSubPbActivity.this.fKB.az(null);
                NewSubPbActivity.this.fKB.nn(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    NewSubPbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fKB.az(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fKB.vz(postWriteCallBackData.getErrorString());
                if (!w.z(NewSubPbActivity.this.fKB.bFn())) {
                    NewSubPbActivity.this.fAg = postWriteCallBackData;
                    if (NewSubPbActivity.this.eIf.Ig()) {
                        NewSubPbActivity.this.eIf.a(NewSubPbActivity.this.fAg);
                    }
                    NewSubPbActivity.this.kI(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.eHX != null) {
                NewSubPbActivity.this.eHX.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.fKo.bfw();
        }
    };
    private CustomMessageListener fwj = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fKy) {
                NewSubPbActivity.this.fKo.aeR();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fvH.e(NewSubPbActivity.this.fvG.getResources().getString(f.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.fvG.getResources().getString(f.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.gR(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bbm();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ap.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.fvG.getResources().getString(f.j.mute_fail);
                    }
                    NewSubPbActivity.this.fvH.f(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fwk = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fKy) {
                NewSubPbActivity.this.fKo.aeR();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fvH.e(NewSubPbActivity.this.fvG.getResources().getString(f.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ap.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.fvG.getResources().getString(f.j.un_mute_fail);
                }
                NewSubPbActivity.this.fvH.f(muteMessage);
            }
        }
    };
    private CustomMessageListener fwl = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fKy) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.fKo.aeR();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.hbs;
                if (aVar.error == 0 && dataRes != null) {
                    boolean z2 = com.baidu.adp.lib.g.b.g(dataRes.is_mute, 0) == 1;
                    sparseArray.put(f.g.tag_user_mute_visible, true);
                    sparseArray.put(f.g.tag_user_mute_msg, dataRes.mute_confirm);
                    z = z2;
                } else {
                    sparseArray.put(f.g.tag_user_mute_visible, false);
                    z = false;
                }
                int intValue = sparseArray.get(f.g.tag_from) instanceof Integer ? ((Integer) sparseArray.get(f.g.tag_from)).intValue() : 0;
                if (intValue == 0) {
                    NewSubPbActivity.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    NewSubPbActivity.this.fKo.a(sparseArray, z);
                }
            }
        }
    };
    boolean fwv = false;
    private CustomMessageListener elH = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener dnw = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.fKm.bfJ() != null && NewSubPbActivity.this.fKm.bfJ().aZU() != null && NewSubPbActivity.this.fKm.bfJ().aZU().vj() != null && currentAccount.equals(NewSubPbActivity.this.fKm.bfJ().aZU().vj().getUserId()) && NewSubPbActivity.this.fKm.bfJ().aZU().vj().getPendantData() != null) {
                        NewSubPbActivity.this.fKm.bfJ().aZU().vj().getPendantData().dj(iVar.tT());
                        NewSubPbActivity.this.fKm.bfJ().aZU().vj().getPendantData().Z(iVar.GZ());
                        NewSubPbActivity.this.fKo.a(NewSubPbActivity.this.fKm.bfJ().aZU(), NewSubPbActivity.this.fKm.bfJ().aMK(), NewSubPbActivity.this.fKm.bfJ().rL(), NewSubPbActivity.this.fKm.aZu(), NewSubPbActivity.this.fKm.bfW() != null);
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
        if (this.aMz) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.fvG = getPageContext();
        this.fKx = true;
        this.fKB = new com.baidu.tieba.write.b();
        this.fKB.vj(f.d.cp_cont_h_alpha85);
        this.fKB.vi(f.d.cp_cont_i);
        ayh();
        bfm();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bfl();
        this.fvH = new com.baidu.tbadk.core.view.d();
        this.fvH.auR = 1000L;
        registerListener(this.fwl);
        registerListener(this.fwj);
        registerListener(this.fwk);
        this.fKy = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fKy;
        userMuteAddAndDelCustomMessage.setTag(this.fKy);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fKy;
        userMuteCheckCustomMessage.setTag(this.fKy);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eHX = new ak(getPageContext());
        this.eHX.a(new ak.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tbadk.core.util.ak.a
            public void c(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.eIf.Il();
                }
            }
        });
        this.fvm = new com.baidu.tieba.pb.pb.report.a(this);
        this.fvm.o(getUniqueId());
    }

    private void bfl() {
        if (this.fKo != null && this.fKm != null && this.fKm.bfo()) {
            this.fKA = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.fKo.Vj());
            this.fKA.aym();
            this.fKA.a(new a.InterfaceC0213a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
                private boolean dAb = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0213a
                public void ayi() {
                    NewSubPbActivity.this.fKo.gf(false);
                    this.dAb = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0213a
                public void ayj() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0213a
                public boolean ayk() {
                    if (!this.dAb) {
                        return NewSubPbActivity.this.fKo.ayy() != null && NewSubPbActivity.this.fKo.ayy().getTop() == 0;
                    }
                    this.dAb = false;
                    return false;
                }
            });
            this.fKo.e(this.fKA);
            this.fKo.gf(true);
        }
    }

    public void initUI() {
        this.fKo = new b(this, this.mCommonClickListener);
        this.fKo.a(this.fKm);
        setContentView(this.fKo.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.fKo.setOnScrollListener(this.fKp);
        this.fKo.a(this);
        this.fKo.setOnLinkImageClickListener(this.fKq);
        this.fKo.setOnImageClickListener(this.fKr);
        this.fKo.jt(true);
        this.fKo.setOnLongClickListener(this.aHj);
        this.fKo.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.fKm != null) {
                    NewSubPbActivity.this.fKm.JV();
                }
            }
        });
        this.fKo.a(this.fKu);
        this.fKo.b(this.fKv);
        if (this.fKm != null && this.fKm.bfo() && !this.fKm.bfV()) {
            this.fKo.bfA().setVisibility(8);
        } else {
            this.fKo.bfA().setVisibility(0);
        }
        if (this.fKm != null && !this.fKm.bfo()) {
            this.fKo.setIsFromPb(false);
        }
    }

    private boolean A(Bundle bundle) {
        if (bundle != null) {
            this.aMz = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.aMz = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.aMz;
    }

    public void initData(Bundle bundle) {
        this.fKm = new SubPbModel(getPageContext());
        this.fKm.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void k(PostData postData) {
                NewSubPbActivity.this.fKo.m(postData);
                NewSubPbActivity.this.fKo.a((BdListView.e) null);
            }
        });
        this.fKn = new ForumManageModel(this);
        this.fKn.setLoadDataCallBack(this.fKt);
        this.dmn = new VoiceManager();
        this.dmn.onCreate(getPageContext());
        this.fvn = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fvn != null) {
            this.fvn.a(this.fwq);
        }
        if (bundle != null) {
            this.fKm.initWithBundle(bundle);
        } else {
            this.fKm.initWithIntent(getIntent());
        }
        this.fKm.a(this.fKs);
        if (this.fKm.bfo()) {
            this.fKm.JV();
        } else {
            this.fKm.bfO();
        }
    }

    public void bfm() {
        this.fKs = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, k kVar) {
                if (NewSubPbActivity.this.fKo != null) {
                    NewSubPbActivity.this.fKo.bfw();
                }
                if (NewSubPbActivity.this.fKA != null && NewSubPbActivity.this.fKA.ayn()) {
                    NewSubPbActivity.this.fKA.lg(f.d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.ah(i, str);
                    return;
                }
                NewSubPbActivity.this.fKo.hideNoDataView();
                if (kVar != null) {
                    if (kVar.aZU() != null || NewSubPbActivity.this.fKm != null) {
                        kVar.aZU().a(NewSubPbActivity.this.fKm.bfU());
                    }
                    if (NewSubPbActivity.this.fKo != null) {
                        NewSubPbActivity.this.fKo.a(kVar, NewSubPbActivity.this.fKm.aZu(), NewSubPbActivity.this.fKm.bfW() != null);
                        if (NewSubPbActivity.this.fKx) {
                            NewSubPbActivity.this.bfn();
                            NewSubPbActivity.this.fKx = false;
                        }
                    }
                    if (NewSubPbActivity.this.eIf != null) {
                        NewSubPbActivity.this.eIf.a(kVar.Cb());
                    }
                    if (NewSubPbActivity.this.fKC == null) {
                        NewSubPbActivity.this.fKC = new com.baidu.tieba.pb.d();
                    }
                    NewSubPbActivity.this.fKC.setData(kVar);
                    NewSubPbActivity.this.fKC.setType(0);
                    NewSubPbActivity.this.eHX.a(NewSubPbActivity.this.fKm.bfZ());
                }
            }
        };
        this.fwq = new a.InterfaceC0097a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0097a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.fvn != null) {
                        NewSubPbActivity.this.fvn.ae(z2);
                    }
                    MarkData rO = NewSubPbActivity.this.fvn.rO();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setType(2);
                    if (z2) {
                        dVar.setData(rO);
                        if (NewSubPbActivity.this.fvn != null) {
                            if (rO != null) {
                                NewSubPbActivity.this.fKm.kM(true);
                                NewSubPbActivity.this.fKm.rH(NewSubPbActivity.this.fKm.HO());
                                NewSubPbActivity.this.showToast(f.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(f.j.add_mark));
                            }
                            if (NewSubPbActivity.this.fKo != null) {
                                NewSubPbActivity.this.fKo.kJ(true);
                            }
                        }
                    } else {
                        dVar.setData(null);
                        NewSubPbActivity.this.fKm.kM(false);
                        NewSubPbActivity.this.fKm.rH(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(f.j.remove_mark));
                        if (NewSubPbActivity.this.fKo != null) {
                            NewSubPbActivity.this.fKo.kJ(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(f.j.update_mark_failed));
            }
        };
        this.fKu = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void i(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.fKm.bfJ() != null && NewSubPbActivity.this.fKm.bfJ().Tg() != null && NewSubPbActivity.this.fKm.bfJ().Tg().vj() != null) {
                    str = String.valueOf(NewSubPbActivity.this.fKm.bfJ().Tg().vj().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.fKm.bfJ().bab().getId(), NewSubPbActivity.this.fKm.bfJ().bab().getName(), NewSubPbActivity.this.fKm.bfJ().Tg().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.fKv = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void i(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.fKn.bwU() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                        boolean c = com.baidu.adp.lib.g.b.c(String.valueOf(objArr[2]), false);
                        int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.fKm != null && NewSubPbActivity.this.fKm.bfJ() != null && NewSubPbActivity.this.fKm.bfJ().bab() != null && NewSubPbActivity.this.fKm.bfJ().Tg() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.fKn.tU(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.fKn.a(NewSubPbActivity.this.fKm.bfJ().bab().getId(), NewSubPbActivity.this.fKm.bfJ().bab().getName(), NewSubPbActivity.this.fKm.bfJ().Tg().getId(), valueOf, g2, g, c);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.fKt = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.fKo.a(NewSubPbActivity.this.fKn.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.fKn.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.fLp != 1002 || bVar.dPJ) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.fKo.a(1, dVar.EX, dVar.gQs, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void ayh() {
        registerListener(this.dnw);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.fKo != null) {
                    if (view == NewSubPbActivity.this.fKo.bfG()) {
                        NewSubPbActivity.this.fKo.bel();
                        String str = view.getTag(f.g.tag_user_id) instanceof String ? (String) view.getTag(f.g.tag_user_id) : null;
                        String str2 = view.getTag(f.g.tag_user_name) instanceof String ? (String) view.getTag(f.g.tag_user_name) : null;
                        String str3 = view.getTag(f.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(f.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                az.zI().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.fKo.ayz()) {
                        if (view != NewSubPbActivity.this.fKo.bfz()) {
                            if (view != NewSubPbActivity.this.fKo.bfy()) {
                                if (view == NewSubPbActivity.this.fKo.bfu()) {
                                    NewSubPbActivity.this.fKo.bel();
                                    if (NewSubPbActivity.this.fKm.JV()) {
                                        NewSubPbActivity.this.fKo.bfs();
                                    }
                                } else if (view == NewSubPbActivity.this.fKo.bfA() || view == NewSubPbActivity.this.fKo.bfB() || view == NewSubPbActivity.this.fKo.bfD()) {
                                    if (NewSubPbActivity.this.fKz) {
                                        NewSubPbActivity.this.fKz = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.fKm.bcd(), NewSubPbActivity.this.fKm.HO(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.fKm.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.fKm.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.fKo.bfE() == null || view != NewSubPbActivity.this.fKo.bfE().bcP()) {
                                    if (NewSubPbActivity.this.fKo.bfE() == null || view != NewSubPbActivity.this.fKo.bfE().bcU()) {
                                        if (NewSubPbActivity.this.fKo.bfE() == null || view != NewSubPbActivity.this.fKo.bfE().bcS()) {
                                            if (NewSubPbActivity.this.fKo.bfE() == null || view != NewSubPbActivity.this.fKo.bfE().bcQ()) {
                                                if (NewSubPbActivity.this.fKo.bfE() == null || view != NewSubPbActivity.this.fKo.bfE().bcR()) {
                                                    if ((view == NewSubPbActivity.this.fKo.bfx() || view == NewSubPbActivity.this.fKo.bfD()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.eIf.Io()) {
                                                            NewSubPbActivity.this.eIf.Ip();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.eIf.gS(null);
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                                TiebaStatic.log(new an("c11739").r("obj_locate", 4));
                                                if (!j.jE()) {
                                                    NewSubPbActivity.this.showToast(f.j.network_not_available);
                                                    return;
                                                }
                                                Object tag = view.getTag();
                                                NewSubPbActivity.this.fKo.bel();
                                                if (tag instanceof String) {
                                                    String HO = NewSubPbActivity.this.fKm.HO();
                                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                        NewSubPbActivity.this.rf(HO);
                                                        return;
                                                    }
                                                    return;
                                                } else if (tag instanceof SparseArray) {
                                                    SparseArray<Object> sparseArray = (SparseArray) tag;
                                                    if ((sparseArray.get(f.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(f.g.tag_user_mute_visible)).booleanValue()) {
                                                        sparseArray.put(f.g.tag_from, 0);
                                                        NewSubPbActivity.this.b(sparseArray);
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else if (j.jE()) {
                                                NewSubPbActivity.this.fKo.bel();
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.bp(view);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                NewSubPbActivity.this.showToast(f.j.network_not_available);
                                                return;
                                            }
                                        }
                                        NewSubPbActivity.this.fKo.bel();
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.fKo.a(((Integer) sparseArray2.get(f.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(f.g.tag_del_post_id), ((Integer) sparseArray2.get(f.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(f.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new an("c11739").r("obj_locate", 1));
                                    NewSubPbActivity.this.fKo.bel();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.eIf.gS(null);
                                        if (NewSubPbActivity.this.fKA != null) {
                                            NewSubPbActivity.this.fKA.ayl();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new an("c11739").r("obj_locate", 2));
                                    NewSubPbActivity.this.fKo.bel();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.fKm.bfJ() != null) {
                                        NewSubPbActivity.this.e(NewSubPbActivity.this.fKm.bfJ().aZU());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.fKo.bfp();
                                NewSubPbActivity.this.fKo.bfq();
                                if (NewSubPbActivity.this.eIf != null) {
                                    NewSubPbActivity.this.eIf.Ir();
                                    if (NewSubPbActivity.this.fKA != null) {
                                        NewSubPbActivity.this.fKA.ayl();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.fKo.bfp();
                            NewSubPbActivity.this.fKo.bfq();
                            if (NewSubPbActivity.this.eIf != null) {
                                NewSubPbActivity.this.eIf.Iq();
                                if (NewSubPbActivity.this.fKA != null) {
                                    NewSubPbActivity.this.fKA.ayl();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.eHX == null || NewSubPbActivity.this.fKm == null || NewSubPbActivity.this.fKm.Cb() == null || NewSubPbActivity.this.eHX.cP(NewSubPbActivity.this.fKm.Cb().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.eIf.Ig()) {
                                NewSubPbActivity.this.eIf.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.fKo.bfp();
                            NewSubPbActivity.this.fKo.bfq();
                            if (NewSubPbActivity.this.eIf != null) {
                                NewSubPbActivity.this.eIf.Is();
                                if (NewSubPbActivity.this.fKA != null) {
                                    NewSubPbActivity.this.fKA.ayl();
                                }
                            }
                        }
                    }
                }
            }
        };
        this.fKp = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.fKo.bel();
                }
                NewSubPbActivity.this.eIf.Ip();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.fKo.bfF();
            }
        };
        this.fwx = new b.InterfaceC0101b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.fKm.bfJ() != null) {
                    postData = NewSubPbActivity.this.fKm.bfJ().aZU();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.ch(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.e(postData);
                    }
                }
            }
        };
        this.aHj = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                    NewSubPbActivity.this.fKo.b(NewSubPbActivity.this.fwx, NewSubPbActivity.this.fKm.isMarked());
                }
                return true;
            }
        };
        this.fKq = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void b(View view, String str) {
                NewSubPbActivity.this.j(null, str, "LINK_IMAGE");
            }
        };
        this.fKr = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                    k bfJ = NewSubPbActivity.this.fKm.bfJ();
                    TbRichText aB = NewSubPbActivity.this.aB(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (aB != null && aB.Nw() != null) {
                        tbRichTextData = aB.Nw().get(NewSubPbActivity.this.fwu);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.NC().NO()) {
                            String b = NewSubPbActivity.this.b(tbRichTextData);
                            arrayList2.add(b);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                            concurrentHashMap3.put(b, imageUrlData);
                            String str4 = null;
                            String str5 = null;
                            String str6 = null;
                            if (bfJ == null) {
                                str3 = null;
                                z4 = false;
                            } else {
                                if (bfJ.bab() != null) {
                                    str4 = bfJ.bab().getName();
                                    str5 = bfJ.bab().getId();
                                }
                                if (bfJ.Tg() != null) {
                                    str6 = bfJ.Tg().getId();
                                }
                                str3 = str6;
                                z4 = true;
                            }
                            if (NewSubPbActivity.this.fKm.bfW() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.fKm.bfW();
                                z5 = NewSubPbActivity.this.fKm.bfY();
                                arrayList2 = NewSubPbActivity.this.fKm.bfX();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z5 = z4;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(w.d(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.fwv = false;
                        String str7 = "";
                        TbRichText bwi = bfJ.aZU().bwi();
                        int size = arrayList2.size();
                        int a2 = NewSubPbActivity.this.a(bwi, aB, i, i, arrayList2, concurrentHashMap3);
                        int size2 = arrayList2.size();
                        if (size != size2) {
                            str7 = arrayList2.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (bfJ == null) {
                            str2 = null;
                            z2 = false;
                        } else {
                            if (bfJ.bab() != null) {
                                str8 = bfJ.bab().getName();
                                str9 = bfJ.bab().getId();
                            }
                            if (bfJ.Tg() != null) {
                                str10 = bfJ.Tg().getId();
                            }
                            str2 = str10;
                            z2 = true;
                        }
                        if (NewSubPbActivity.this.fKm.bfW() != null) {
                            concurrentHashMap = NewSubPbActivity.this.fKm.bfW();
                            z3 = NewSubPbActivity.this.fKm.bfY();
                            arrayList = NewSubPbActivity.this.fKm.bfX();
                            i2 = a2 + NewSubPbActivity.this.fKm.getOffset();
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
        TbRichTextImageInfo NC;
        if (tbRichText == tbRichText2) {
            this.fwv = true;
        }
        if (tbRichText != null && tbRichText.Nw() != null) {
            int size = tbRichText.Nw().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Nw().get(i6) != null && tbRichText.Nw().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.Nw().get(i6).NC().getWidth();
                    int height = tbRichText.Nw().get(i6).NC().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Nw().get(i6).NC().NO()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Nw().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (NC = tbRichTextData.NC()) != null) {
                            String NR = NC.NR();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = NR;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.fwv) {
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
        TbRichTextImageInfo NC = tbRichTextData.NC();
        if (NC != null) {
            if (!StringUtils.isNull(NC.NN())) {
                return NC.NN();
            }
            if (NC.getHeight() * NC.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (NC.getHeight() * NC.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (NC.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * NC.getHeight())));
            } else {
                float width = NC.getWidth() / NC.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ap.bh(NC.NP()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aB(String str, int i) {
        if (this.fKm == null || this.fKm.bfJ() == null || str == null || i < 0) {
            return null;
        }
        k bfJ = this.fKm.bfJ();
        TbRichText a2 = a(bfJ.aZU(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bfJ.aZU(), str, i);
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
        TbRichText bwi = postData.bwi();
        if (bwi != null) {
            ArrayList<TbRichTextData> Nw = bwi.Nw();
            int size = Nw.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Nw.get(i3) != null && Nw.get(i3).getType() == 8) {
                    i2++;
                    if (Nw.get(i3).NC().NR().equals(str)) {
                        int width = Nw.get(i3).NC().getWidth();
                        int height = Nw.get(i3).NC().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.fwu = i3;
                        return bwi;
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
        long templateId = this.fKm.bfJ().aZU().bwp() != null ? this.fKm.bfJ().aZU().bwp().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && az.zI().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.fKm.bfJ().bab().getId(), this.fKm.bfJ().bab().getName(), this.fKm.bfJ().Tg().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(int i, String str) {
        if (this.fKm.bfK()) {
            showToast(str);
        } else if (l.jV()) {
            if (i == 4) {
                this.fKo.mH(str + "(4)");
            } else {
                this.fKo.is(f.j.no_data_text);
            }
        } else {
            this.fKo.is(f.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.eIf = (g) new com.baidu.tbadk.editortools.pb.h().aY(getActivity());
        if (this.eIf != null) {
            this.eIf.setContext(getPageContext());
            this.eIf.b(this.fKm);
            this.eIf.b(this.fKD);
            this.eIf.a(this.aNS);
            this.eIf.a(this.aNT);
            this.eIf.Ht().bD(true);
            this.eIf.d(getPageContext());
        }
        if (this.fKo != null) {
            this.fKo.g(this.eIf);
        }
        if (this.eIf != null && this.fKm != null) {
            this.eIf.a(this.fKm.Cb());
            this.eIf.Ip();
        }
        if (this.eIf != null) {
            this.fHz = this.eIf.It().getInputView();
            this.fHz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.fKB != null) {
                        if (!NewSubPbActivity.this.fKB.bFq()) {
                            NewSubPbActivity.this.kI(false);
                        }
                        NewSubPbActivity.this.fKB.no(false);
                    }
                }
            });
        }
    }

    public void bfn() {
        if (!TbadkCoreApplication.isLogin()) {
            this.eIf.Ip();
        } else if (!StringUtils.isNull(this.fKm.bfR())) {
            this.fKo.rD(this.fKm.bfR());
            if (this.fKo.bft() && l.jV()) {
                this.fKo.aqL();
            } else {
                this.fKo.bfw();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(f.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(f.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(f.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(f.g.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(f.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(f.g.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(f.g.tag_from, 1);
                    b(sparseArray);
                } else {
                    this.fKo.bl(view);
                }
            } else if (booleanValue2) {
                this.fKo.a(((Integer) sparseArray.get(f.g.tag_del_post_type)).intValue(), (String) sparseArray.get(f.g.tag_del_post_id), ((Integer) sparseArray.get(f.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(f.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.fKo.bfC(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        final String str;
        String[] strArr;
        String string;
        if (!(sparseArray.get(f.g.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(f.g.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(f.g.tag_user_mute_visible)).booleanValue()) {
            String[] strArr2 = new String[2];
            strArr2[0] = getResources().getString(f.j.delete);
            if (z) {
                string = getResources().getString(f.j.un_mute);
            } else {
                string = getResources().getString(f.j.mute);
            }
            strArr2[1] = string;
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(f.j.delete)};
        }
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.ci(f.j.operation);
        bVar.a(strArr, new b.InterfaceC0101b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                switch (i) {
                    case 0:
                        String str2 = "";
                        int intValue = sparseArray.get(f.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(f.g.tag_del_post_type)).intValue() : 0;
                        if (sparseArray.get(f.g.tag_del_post_id) instanceof String) {
                            str2 = (String) sparseArray.get(f.g.tag_del_post_id);
                        }
                        NewSubPbActivity.this.fKo.a(intValue, str2, sparseArray.get(f.g.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(f.g.tag_manage_user_identity)).intValue() : 0, sparseArray.get(f.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(f.g.tag_del_post_is_self)).booleanValue() : false);
                        break;
                    case 1:
                        String str3 = "";
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        if (sparseArray.get(f.g.tag_user_mute_mute_username) instanceof String) {
                            str3 = (String) sparseArray.get(f.g.tag_user_mute_mute_username);
                        }
                        if (sparseArray.get(f.g.tag_user_mute_thread_id) instanceof String) {
                            str4 = (String) sparseArray.get(f.g.tag_user_mute_thread_id);
                        }
                        if (sparseArray.get(f.g.tag_user_mute_post_id) instanceof String) {
                            str5 = (String) sparseArray.get(f.g.tag_user_mute_post_id);
                        }
                        if (sparseArray.get(f.g.tag_user_mute_msg) instanceof String) {
                            str6 = (String) sparseArray.get(f.g.tag_user_mute_msg);
                        }
                        if (sparseArray.get(f.g.tag_user_mute_mute_nameshow) instanceof String) {
                            str7 = (String) sparseArray.get(f.g.tag_user_mute_mute_nameshow);
                        }
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.fKy);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.fKy);
                        NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str6, str3, str7);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext()).xh();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(f.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(f.g.tag_user_mute_mute_userid);
        }
        this.fKo.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.fKy;
        userMuteCheckCustomMessage.setTag(this.fKy);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.fKo.a(0, bVar.EX, bVar.gQs, z);
            if (bVar.EX) {
                if (bVar.gQq == 1) {
                    finish();
                } else if (bVar.gQq == 2) {
                    this.fKm.rG(bVar.mPostId);
                    this.fKo.a(this.fKm.bfJ(), this.fKm.aZu(), this.fKm.bfW() != null);
                    if (this.fKm.bfS()) {
                        this.fKm.kN(false);
                        this.fKo.bfr();
                        this.fKm.JV();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
            }
        }
    }

    public void rf(String str) {
        this.fvm.rB(str);
    }

    public void e(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.fKm.isMarked() && postData.getId() != null && postData.getId().equals(this.fKm.bfQ())) {
                z = true;
            }
            MarkData g = this.fKm.g(postData);
            if (g != null) {
                this.fKo.bel();
                if (this.fvn != null) {
                    this.fvn.a(g);
                    if (!z) {
                        this.fvn.rN();
                    } else {
                        this.fvn.rM();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.fKm != null) {
            this.fKm.z(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.eIf != null) {
            this.eIf.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.eIf.Ht().FP();
        this.eIf.Ip();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eIf.b(writeData);
                this.eIf.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k eN = this.eIf.Ht().eN(6);
                if (eN != null && eN.aMc != null) {
                    eN.aMc.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eIf.Il();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dmn != null) {
            this.dmn.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.fKw = true;
        super.onPause();
        if (this.dmn != null) {
            this.dmn.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.elH);
        this.fKo.axn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fKw = false;
        super.onResume();
        if (this.dmn != null) {
            this.dmn.onResume(getPageContext());
        }
        registerListener(this.elH);
        this.fKo.axo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dmn != null) {
            this.dmn.onStop(getPageContext());
        }
        this.eIf.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.fKC));
        this.fKm.cancelLoadData();
        this.fKm.destory();
        this.fKn.cancelLoadData();
        if (this.dmn != null) {
            this.dmn.onDestory(getPageContext());
        }
        this.fKo.bel();
        this.fKo.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.fwj);
        MessageManager.getInstance().unRegisterListener(this.fwk);
        MessageManager.getInstance().unRegisterListener(this.fwl);
        MessageManager.getInstance().unRegisterListener(this.fKy);
        this.fvG = null;
        this.fvH = null;
        if (this.dna != null) {
            this.dna.onDestroy();
        }
        if (this.eHX != null) {
            this.eHX.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fKo.onChangeSkinType(i);
        if (this.dna != null) {
            this.dna.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dmn;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bfx = this.fKo.bfx();
        if (bfx == null || (findViewWithTag = bfx.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean ru(String str) {
        Map<String, String> eP;
        if (!TextUtils.isEmpty(str) && (eP = az.eP(az.eQ(str))) != null) {
            this.fKz = true;
            String str2 = eP.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return ru(com.baidu.adp.lib.util.k.bi(str2));
            }
            String str3 = eP.get(fKl);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void d(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (ru(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
                    hVar.mLink = str;
                    hVar.type = 3;
                    hVar.aLf = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, hVar));
                }
            } else {
                az.zI().c(getPageContext(), new String[]{str});
            }
            this.fKz = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fKz = true;
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
        if (this.fKo != null) {
            return this.fKo.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Od() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Of() {
        if (this.bfW == null) {
            this.bfW = TbRichTextView.k(getPageContext().getPageActivity(), 8);
        }
        return this.bfW;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Og() {
        if (this.bga == null) {
            this.bga = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bbs */
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
        return this.bga;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Oe() {
        if (this.bfV == null) {
            this.bfV = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aga */
                public ImageView ig() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean tj = com.baidu.tbadk.core.i.td().tj();
                    foreDrawableImageView.setDefaultBg(am.getDrawable(f.d.common_color_10220));
                    if (tj) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(f.C0146f.icon_click);
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
                        foreDrawableImageView.setDefaultBgResource(f.d.cp_bg_line_c);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView r(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.td().tj()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(f.C0146f.icon_click);
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
                        foreDrawableImageView.setDefaultBgResource(f.d.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.bfV;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Oh() {
        if (this.bfX == null) {
            this.bfX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bbt */
                public View ig() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(f.e.fontsize28);
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
        return this.bfX;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Oi() {
        if (this.bfY == null) {
            this.bfY = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bbv */
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
        return this.bfY;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Oj() {
        this.bfZ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bbu */
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
        return this.bfZ;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fKo.bft() && l.jV()) {
            this.fKm.JV();
        } else {
            this.fKo.bfw();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (sparseArray.get(f.g.tag_user_mute_mute_username) instanceof String) {
            str3 = (String) sparseArray.get(f.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(f.g.tag_user_mute_thread_id) instanceof String) {
            str4 = (String) sparseArray.get(f.g.tag_user_mute_thread_id);
        }
        if (!(sparseArray.get(f.g.tag_user_mute_post_id) instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) sparseArray.get(f.g.tag_user_mute_post_id);
        }
        String str7 = sparseArray.get(f.g.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(f.g.tag_user_mute_msg) : str2;
        if (sparseArray.get(f.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(f.g.tag_user_mute_msg);
        }
        if (sparseArray.get(f.g.tag_user_mute_mute_nameshow) instanceof String) {
            str6 = (String) sparseArray.get(f.g.tag_user_mute_mute_nameshow);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.fKy);
        userMuteAddAndDelCustomMessage.setTag(this.fKy);
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
            public boolean Kl() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Km() {
                return com.baidu.tbadk.pageStayDuration.e.Kq().Ks();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.fKm != null) {
            if (this.fKm.bfJ() != null && this.fKm.bfJ().bab() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fKm.bfJ().bab().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fKm.bcd(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.fKw;
    }

    public boolean bfo() {
        if (this.fKm != null) {
            return this.fKm.bfo();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.fKo.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fvG.getPageActivity());
        if (ap.isEmpty(str)) {
            aVar.dB(this.fvG.getResources().getString(f.j.block_mute_message_alert, str3));
        } else {
            aVar.dB(str);
        }
        aVar.a(f.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.fKo.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fvG).xe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gR(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fvG.getPageActivity());
        aVar.dB(str);
        aVar.b(f.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fvG).xe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbm() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dB(getResources().getString(f.j.mute_is_super_member_function));
        aVar.a(f.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.fvG).showToast(f.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.fvG.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fvG).xe();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.aMz) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.aMz) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void kI(boolean z) {
        if (this.fHz != null && this.fHz.getText() != null) {
            int selectionEnd = this.fHz.getSelectionEnd();
            SpannableStringBuilder b = this.fKB.b(this.fHz.getText());
            if (b != null) {
                this.fKB.no(true);
                this.fHz.setText(b);
                if (z && this.fKB.bFo() >= 0) {
                    this.fHz.requestFocus();
                    this.fHz.setSelection(this.fKB.bFo());
                } else {
                    this.fHz.setSelection(selectionEnd);
                }
                this.fKB.nn(this.fKB.bFo() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.dna == null) {
            this.dna = new h(getPageContext());
            this.dna.a(new h.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void aD(boolean z) {
                    if (z) {
                        TiebaStatic.log(new an("c13061"));
                    }
                }
            });
        }
        this.dna.a(contriInfo, -1L);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.eIf != null && this.eIf.Ht() != null && this.eIf.Ht().Hw()) {
            this.eIf.Ht().FP();
        } else {
            super.onBackPressed();
        }
    }
}
