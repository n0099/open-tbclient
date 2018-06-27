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
    private static final String fIF = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String fKe = "tbgametype";
    private View.OnLongClickListener aHk;
    private com.baidu.adp.lib.e.b<ImageView> bfI;
    private com.baidu.adp.lib.e.b<TextView> bfJ;
    private com.baidu.adp.lib.e.b<View> bfK;
    private com.baidu.adp.lib.e.b<LinearLayout> bfL;
    private com.baidu.adp.lib.e.b<RelativeLayout> bfM;
    private com.baidu.adp.lib.e.b<GifView> bfN;
    private VoiceManager djz;
    private h dkm;
    public ak eEi;
    private g eEq;
    private com.baidu.tbadk.baseEditMark.a eWM;
    private PostWriteCallBackData fAb;
    private EditText fHr;
    private SubPbModel fKf;
    private ForumManageModel fKg;
    private b fKh;
    private AbsListView.OnScrollListener fKi;
    private TbRichTextView.i fKj;
    private TbRichTextView.h fKk;
    private SubPbModel.a fKl;
    private com.baidu.adp.base.d fKm;
    private BdUniqueId fKr;
    private com.baidu.tieba.pb.pb.sub.a fKt;
    private com.baidu.tieba.write.b fKu;
    private com.baidu.tieba.pb.d<k> fKv;
    private com.baidu.adp.base.e fvB;
    private com.baidu.tbadk.core.view.d fvC;
    private com.baidu.tieba.pb.pb.report.a fvi;
    private b.InterfaceC0104b fws;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int fwp = 0;
    private a.InterfaceC0100a fwl = null;
    private a fKn = null;
    private a fKo = null;
    private boolean fKp = false;
    private boolean fKq = false;
    private boolean fKs = false;
    private boolean aMC = false;
    private com.baidu.tbadk.editortools.pb.c aNW = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void HW() {
            NewSubPbActivity.this.fKh.bhh();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aNX = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean HV() {
            if (!NewSubPbActivity.this.fKu.bGA()) {
                return (NewSubPbActivity.this.eEi == null || NewSubPbActivity.this.fKf == null || NewSubPbActivity.this.fKf.Cm() == null || NewSubPbActivity.this.eEi.u(NewSubPbActivity.this.fKf.Cm().replyPrivateFlag, ak.aqZ)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.fKu.bGC());
            if (NewSubPbActivity.this.eEq.Il()) {
                NewSubPbActivity.this.eEq.a(NewSubPbActivity.this.fAb);
            }
            NewSubPbActivity.this.kW(true);
            return true;
        }
    };
    private NewWriteModel.d fKw = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.eEq != null && NewSubPbActivity.this.eEq.Hy() != null) {
                NewSubPbActivity.this.eEq.Hy().hide();
                if (NewSubPbActivity.this.fKf.bhB()) {
                    TiebaStatic.log(new an("c10367").ah("post_id", NewSubPbActivity.this.fKf.HT()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fKu.vu(null);
                NewSubPbActivity.this.fKu.aB(null);
                NewSubPbActivity.this.fKu.nz(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    NewSubPbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fKu.aB(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fKu.vu(postWriteCallBackData.getErrorString());
                if (!w.A(NewSubPbActivity.this.fKu.bGy())) {
                    NewSubPbActivity.this.fAb = postWriteCallBackData;
                    if (NewSubPbActivity.this.eEq.Il()) {
                        NewSubPbActivity.this.eEq.a(NewSubPbActivity.this.fAb);
                    }
                    NewSubPbActivity.this.kW(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.eEi != null) {
                NewSubPbActivity.this.eEi.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.fKh.bhi();
        }
    };
    private CustomMessageListener fwe = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fKr) {
                NewSubPbActivity.this.fKh.aeB();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fvC.i(NewSubPbActivity.this.fvB.getResources().getString(d.k.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.fvB.getResources().getString(d.k.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.gV(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bcY();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ap.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.fvB.getResources().getString(d.k.mute_fail);
                    }
                    NewSubPbActivity.this.fvC.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fwf = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fKr) {
                NewSubPbActivity.this.fKh.aeB();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fvC.i(NewSubPbActivity.this.fvB.getResources().getString(d.k.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ap.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.fvB.getResources().getString(d.k.un_mute_fail);
                }
                NewSubPbActivity.this.fvC.j(muteMessage);
            }
        }
    };
    private CustomMessageListener fwg = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fKr) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.fKh.aeB();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.hai;
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
                    NewSubPbActivity.this.fKh.a(sparseArray, z);
                }
            }
        }
    };
    boolean fwq = false;
    private CustomMessageListener ehV = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener dkI = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.fKf.bhv() != null && NewSubPbActivity.this.fKf.bhv().bbG() != null && NewSubPbActivity.this.fKf.bhv().bbG().vw() != null && currentAccount.equals(NewSubPbActivity.this.fKf.bhv().bbG().vw().getUserId()) && NewSubPbActivity.this.fKf.bhv().bbG().vw().getPendantData() != null) {
                        NewSubPbActivity.this.fKf.bhv().bbG().vw().getPendantData().dm(iVar.uh());
                        NewSubPbActivity.this.fKf.bhv().bbG().vw().getPendantData().X(iVar.Hd());
                        NewSubPbActivity.this.fKh.a(NewSubPbActivity.this.fKf.bhv().bbG(), NewSubPbActivity.this.fKf.bhv().aLM(), NewSubPbActivity.this.fKf.bhv().sc(), NewSubPbActivity.this.fKf.bbh(), NewSubPbActivity.this.fKf.bhI() != null);
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
        this.fvB = getPageContext();
        this.fKq = true;
        this.fKu = new com.baidu.tieba.write.b();
        this.fKu.vk(d.C0142d.cp_cont_h_alpha85);
        this.fKu.vj(d.C0142d.cp_cont_i);
        axE();
        bgY();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bgX();
        this.fvC = new com.baidu.tbadk.core.view.d();
        this.fvC.avm = 1000L;
        registerListener(this.fwg);
        registerListener(this.fwe);
        registerListener(this.fwf);
        this.fKr = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fKr;
        userMuteAddAndDelCustomMessage.setTag(this.fKr);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fKr;
        userMuteCheckCustomMessage.setTag(this.fKr);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eEi = new ak(getPageContext());
        this.eEi.a(new ak.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tbadk.core.util.ak.a
            public void c(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.eEq.Iq();
                }
            }
        });
        this.fvi = new com.baidu.tieba.pb.pb.report.a(this);
        this.fvi.o(getUniqueId());
    }

    private void bgX() {
        if (this.fKh != null && this.fKf != null && this.fKf.bha()) {
            this.fKt = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.fKh.UW());
            this.fKt.axJ();
            this.fKt.a(new a.InterfaceC0214a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
                private boolean dxs = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0214a
                public void axF() {
                    NewSubPbActivity.this.fKh.gd(false);
                    this.dxs = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0214a
                public void axG() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0214a
                public boolean axH() {
                    if (!this.dxs) {
                        return NewSubPbActivity.this.fKh.axV() != null && NewSubPbActivity.this.fKh.axV().getTop() == 0;
                    }
                    this.dxs = false;
                    return false;
                }
            });
            this.fKh.e(this.fKt);
            this.fKh.gd(true);
        }
    }

    public void initUI() {
        this.fKh = new b(this, this.mCommonClickListener);
        this.fKh.a(this.fKf);
        setContentView(this.fKh.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.fKh.setOnScrollListener(this.fKi);
        this.fKh.a(this);
        this.fKh.setOnLinkImageClickListener(this.fKj);
        this.fKh.setOnImageClickListener(this.fKk);
        this.fKh.jH(true);
        this.fKh.setOnLongClickListener(this.aHk);
        this.fKh.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.fKf != null) {
                    NewSubPbActivity.this.fKf.JW();
                }
            }
        });
        this.fKh.a(this.fKn);
        this.fKh.b(this.fKo);
        if (this.fKf != null && this.fKf.bha() && !this.fKf.bhH()) {
            this.fKh.bhm().setVisibility(8);
        } else {
            this.fKh.bhm().setVisibility(0);
        }
        if (this.fKf != null && !this.fKf.bha()) {
            this.fKh.setIsFromPb(false);
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
        this.fKf = new SubPbModel(getPageContext());
        this.fKf.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void k(PostData postData) {
                NewSubPbActivity.this.fKh.m(postData);
                NewSubPbActivity.this.fKh.a((BdListView.e) null);
            }
        });
        this.fKg = new ForumManageModel(this);
        this.fKg.setLoadDataCallBack(this.fKm);
        this.djz = new VoiceManager();
        this.djz.onCreate(getPageContext());
        this.eWM = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.eWM != null) {
            this.eWM.a(this.fwl);
        }
        if (bundle != null) {
            this.fKf.initWithBundle(bundle);
        } else {
            this.fKf.initWithIntent(getIntent());
        }
        this.fKf.a(this.fKl);
        if (this.fKf.bha()) {
            this.fKf.JW();
        } else {
            this.fKf.bhA();
        }
    }

    public void bgY() {
        this.fKl = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, k kVar) {
                if (NewSubPbActivity.this.fKh != null) {
                    NewSubPbActivity.this.fKh.bhi();
                }
                if (NewSubPbActivity.this.fKt != null && NewSubPbActivity.this.fKt.axK()) {
                    NewSubPbActivity.this.fKt.kW(d.C0142d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.af(i, str);
                    return;
                }
                NewSubPbActivity.this.fKh.hideNoDataView();
                if (kVar != null) {
                    if (kVar.bbG() != null || NewSubPbActivity.this.fKf != null) {
                        kVar.bbG().a(NewSubPbActivity.this.fKf.bhG());
                    }
                    if (NewSubPbActivity.this.fKh != null) {
                        NewSubPbActivity.this.fKh.a(kVar, NewSubPbActivity.this.fKf.bbh(), NewSubPbActivity.this.fKf.bhI() != null);
                        if (NewSubPbActivity.this.fKq) {
                            NewSubPbActivity.this.bgZ();
                            NewSubPbActivity.this.fKq = false;
                        }
                    }
                    if (NewSubPbActivity.this.eEq != null) {
                        NewSubPbActivity.this.eEq.a(kVar.Cm());
                    }
                    if (NewSubPbActivity.this.fKv == null) {
                        NewSubPbActivity.this.fKv = new com.baidu.tieba.pb.d();
                    }
                    NewSubPbActivity.this.fKv.setData(kVar);
                    NewSubPbActivity.this.fKv.setType(0);
                    NewSubPbActivity.this.eEi.a(NewSubPbActivity.this.fKf.bhL());
                }
            }
        };
        this.fwl = new a.InterfaceC0100a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0100a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.eWM != null) {
                        NewSubPbActivity.this.eWM.ah(z2);
                    }
                    MarkData sf = NewSubPbActivity.this.eWM.sf();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setType(2);
                    if (z2) {
                        dVar.setData(sf);
                        if (NewSubPbActivity.this.eWM != null) {
                            if (sf != null) {
                                NewSubPbActivity.this.fKf.la(true);
                                NewSubPbActivity.this.fKf.rK(NewSubPbActivity.this.fKf.HT());
                                NewSubPbActivity.this.showToast(d.k.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.k.add_mark));
                            }
                            if (NewSubPbActivity.this.fKh != null) {
                                NewSubPbActivity.this.fKh.kX(true);
                            }
                        }
                    } else {
                        dVar.setData(null);
                        NewSubPbActivity.this.fKf.la(false);
                        NewSubPbActivity.this.fKf.rK(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.k.remove_mark));
                        if (NewSubPbActivity.this.fKh != null) {
                            NewSubPbActivity.this.fKh.kX(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.k.update_mark_failed));
            }
        };
        this.fKn = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void i(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.fKf.bhv() != null && NewSubPbActivity.this.fKf.bhv().SV() != null && NewSubPbActivity.this.fKf.bhv().SV().vw() != null) {
                    str = String.valueOf(NewSubPbActivity.this.fKf.bhv().SV().vw().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.fKf.bhv().bbN().getId(), NewSubPbActivity.this.fKf.bhv().bbN().getName(), NewSubPbActivity.this.fKf.bhv().SV().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.fKo = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void i(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.fKg.byq() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.fKf != null && NewSubPbActivity.this.fKf.bhv() != null && NewSubPbActivity.this.fKf.bhv().bbN() != null && NewSubPbActivity.this.fKf.bhv().SV() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.fKg.tS(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.fKg.a(NewSubPbActivity.this.fKf.bhv().bbN().getId(), NewSubPbActivity.this.fKf.bhv().bbN().getName(), NewSubPbActivity.this.fKf.bhv().SV().getId(), valueOf, g2, g, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.fKm = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.fKh.a(NewSubPbActivity.this.fKg.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.fKg.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.fLi != 1002 || bVar.dNa) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.fKh.a(1, dVar.Fa, dVar.gPt, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void axE() {
        registerListener(this.dkI);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.fKh != null) {
                    if (view == NewSubPbActivity.this.fKh.bhs()) {
                        NewSubPbActivity.this.fKh.bfX();
                        String str = view.getTag(d.g.tag_user_id) instanceof String ? (String) view.getTag(d.g.tag_user_id) : null;
                        String str2 = view.getTag(d.g.tag_user_name) instanceof String ? (String) view.getTag(d.g.tag_user_name) : null;
                        String str3 = view.getTag(d.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(d.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                az.zV().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.fKh.axW()) {
                        if (view != NewSubPbActivity.this.fKh.bhl()) {
                            if (view != NewSubPbActivity.this.fKh.bhk()) {
                                if (view == NewSubPbActivity.this.fKh.bhg()) {
                                    NewSubPbActivity.this.fKh.bfX();
                                    if (NewSubPbActivity.this.fKf.JW()) {
                                        NewSubPbActivity.this.fKh.bhe();
                                    }
                                } else if (view == NewSubPbActivity.this.fKh.bhm() || view == NewSubPbActivity.this.fKh.bhn() || view == NewSubPbActivity.this.fKh.bhp()) {
                                    if (NewSubPbActivity.this.fKs) {
                                        NewSubPbActivity.this.fKs = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.fKf.bdP(), NewSubPbActivity.this.fKf.HT(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.fKf.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.fKf.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.fKh.bhq() == null || view != NewSubPbActivity.this.fKh.bhq().beB()) {
                                    if (NewSubPbActivity.this.fKh.bhq() == null || view != NewSubPbActivity.this.fKh.bhq().beG()) {
                                        if (NewSubPbActivity.this.fKh.bhq() == null || view != NewSubPbActivity.this.fKh.bhq().beE()) {
                                            if (NewSubPbActivity.this.fKh.bhq() == null || view != NewSubPbActivity.this.fKh.bhq().beC()) {
                                                if (NewSubPbActivity.this.fKh.bhq() == null || view != NewSubPbActivity.this.fKh.bhq().beD()) {
                                                    if ((view == NewSubPbActivity.this.fKh.bhj() || view == NewSubPbActivity.this.fKh.bhp()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.eEq.It()) {
                                                            NewSubPbActivity.this.eEq.Iu();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.eEq.gW(null);
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                                TiebaStatic.log(new an("c11739").r("obj_locate", 4));
                                                if (!j.jD()) {
                                                    NewSubPbActivity.this.showToast(d.k.network_not_available);
                                                    return;
                                                }
                                                Object tag = view.getTag();
                                                NewSubPbActivity.this.fKh.bfX();
                                                if (tag instanceof String) {
                                                    String HT = NewSubPbActivity.this.fKf.HT();
                                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                        NewSubPbActivity.this.ri(HT);
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
                                                NewSubPbActivity.this.fKh.bfX();
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.bm(view);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                NewSubPbActivity.this.showToast(d.k.network_not_available);
                                                return;
                                            }
                                        }
                                        NewSubPbActivity.this.fKh.bfX();
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.fKh.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new an("c11739").r("obj_locate", 1));
                                    NewSubPbActivity.this.fKh.bfX();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.eEq.gW(null);
                                        if (NewSubPbActivity.this.fKt != null) {
                                            NewSubPbActivity.this.fKt.axI();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new an("c11739").r("obj_locate", 2));
                                    NewSubPbActivity.this.fKh.bfX();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.fKf.bhv() != null) {
                                        NewSubPbActivity.this.e(NewSubPbActivity.this.fKf.bhv().bbG());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.fKh.bhb();
                                NewSubPbActivity.this.fKh.bhc();
                                if (NewSubPbActivity.this.eEq != null) {
                                    NewSubPbActivity.this.eEq.Iw();
                                    if (NewSubPbActivity.this.fKt != null) {
                                        NewSubPbActivity.this.fKt.axI();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.fKh.bhb();
                            NewSubPbActivity.this.fKh.bhc();
                            if (NewSubPbActivity.this.eEq != null) {
                                NewSubPbActivity.this.eEq.Iv();
                                if (NewSubPbActivity.this.fKt != null) {
                                    NewSubPbActivity.this.fKt.axI();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.eEi == null || NewSubPbActivity.this.fKf == null || NewSubPbActivity.this.fKf.Cm() == null || NewSubPbActivity.this.eEi.cN(NewSubPbActivity.this.fKf.Cm().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.eEq.Il()) {
                                NewSubPbActivity.this.eEq.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.fKh.bhb();
                            NewSubPbActivity.this.fKh.bhc();
                            if (NewSubPbActivity.this.eEq != null) {
                                NewSubPbActivity.this.eEq.Ix();
                                if (NewSubPbActivity.this.fKt != null) {
                                    NewSubPbActivity.this.fKt.axI();
                                }
                            }
                        }
                    }
                }
            }
        };
        this.fKi = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.fKh.bfX();
                }
                NewSubPbActivity.this.eEq.Iu();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.fKh.bhr();
            }
        };
        this.fws = new b.InterfaceC0104b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.fKf.bhv() != null) {
                    postData = NewSubPbActivity.this.fKf.bhv().bbG();
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
                    NewSubPbActivity.this.fKh.b(NewSubPbActivity.this.fws, NewSubPbActivity.this.fKf.isMarked());
                }
                return true;
            }
        };
        this.fKj = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void b(View view, String str) {
                NewSubPbActivity.this.j(null, str, "LINK_IMAGE");
            }
        };
        this.fKk = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                    k bhv = NewSubPbActivity.this.fKf.bhv();
                    TbRichText aF = NewSubPbActivity.this.aF(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (aF != null && aF.Nz() != null) {
                        tbRichTextData = aF.Nz().get(NewSubPbActivity.this.fwp);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.NF().NR()) {
                            String b = NewSubPbActivity.this.b(tbRichTextData);
                            arrayList2.add(b);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                            concurrentHashMap3.put(b, imageUrlData);
                            String str4 = null;
                            String str5 = null;
                            String str6 = null;
                            if (bhv == null) {
                                str3 = null;
                                z4 = false;
                            } else {
                                if (bhv.bbN() != null) {
                                    str4 = bhv.bbN().getName();
                                    str5 = bhv.bbN().getId();
                                }
                                if (bhv.SV() != null) {
                                    str6 = bhv.SV().getId();
                                }
                                str3 = str6;
                                z4 = true;
                            }
                            if (NewSubPbActivity.this.fKf.bhI() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.fKf.bhI();
                                z5 = NewSubPbActivity.this.fKf.bhK();
                                arrayList2 = NewSubPbActivity.this.fKf.bhJ();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z5 = z4;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(w.d(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.fwq = false;
                        String str7 = "";
                        TbRichText bxE = bhv.bbG().bxE();
                        int size = arrayList2.size();
                        int a2 = NewSubPbActivity.this.a(bxE, aF, i, i, arrayList2, concurrentHashMap3);
                        int size2 = arrayList2.size();
                        if (size != size2) {
                            str7 = arrayList2.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (bhv == null) {
                            str2 = null;
                            z2 = false;
                        } else {
                            if (bhv.bbN() != null) {
                                str8 = bhv.bbN().getName();
                                str9 = bhv.bbN().getId();
                            }
                            if (bhv.SV() != null) {
                                str10 = bhv.SV().getId();
                            }
                            str2 = str10;
                            z2 = true;
                        }
                        if (NewSubPbActivity.this.fKf.bhI() != null) {
                            concurrentHashMap = NewSubPbActivity.this.fKf.bhI();
                            z3 = NewSubPbActivity.this.fKf.bhK();
                            arrayList = NewSubPbActivity.this.fKf.bhJ();
                            i2 = a2 + NewSubPbActivity.this.fKf.getOffset();
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
        TbRichTextImageInfo NF;
        if (tbRichText == tbRichText2) {
            this.fwq = true;
        }
        if (tbRichText != null && tbRichText.Nz() != null) {
            int size = tbRichText.Nz().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Nz().get(i6) != null && tbRichText.Nz().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.Nz().get(i6).NF().getWidth();
                    int height = tbRichText.Nz().get(i6).NF().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Nz().get(i6).NF().NR()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Nz().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (NF = tbRichTextData.NF()) != null) {
                            String NS = NF.NS();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = NS;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.fwq) {
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
        TbRichTextImageInfo NF = tbRichTextData.NF();
        if (NF != null) {
            if (!StringUtils.isNull(NF.NQ())) {
                return NF.NQ();
            }
            if (NF.getHeight() * NF.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (NF.getHeight() * NF.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (NF.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * NF.getHeight())));
            } else {
                float width = NF.getWidth() / NF.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ap.bg(NF.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aF(String str, int i) {
        if (this.fKf == null || this.fKf.bhv() == null || str == null || i < 0) {
            return null;
        }
        k bhv = this.fKf.bhv();
        TbRichText a2 = a(bhv.bbG(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bhv.bbG(), str, i);
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
        TbRichText bxE = postData.bxE();
        if (bxE != null) {
            ArrayList<TbRichTextData> Nz = bxE.Nz();
            int size = Nz.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Nz.get(i3) != null && Nz.get(i3).getType() == 8) {
                    i2++;
                    if (Nz.get(i3).NF().NS().equals(str)) {
                        int width = Nz.get(i3).NF().getWidth();
                        int height = Nz.get(i3).NF().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.fwp = i3;
                        return bxE;
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
        long templateId = this.fKf.bhv().bbG().bxL() != null ? this.fKf.bhv().bbG().bxL().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && az.zV().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.fKf.bhv().bbN().getId(), this.fKf.bhv().bbN().getName(), this.fKf.bhv().SV().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(int i, String str) {
        if (this.fKf.bhw()) {
            showToast(str);
        } else if (l.jU()) {
            if (i == 4) {
                this.fKh.mG(str + "(4)");
            } else {
                this.fKh.il(d.k.no_data_text);
            }
        } else {
            this.fKh.il(d.k.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.eEq = (g) new com.baidu.tbadk.editortools.pb.h().aY(getActivity());
        if (this.eEq != null) {
            this.eEq.setContext(getPageContext());
            this.eEq.b(this.fKf);
            this.eEq.b(this.fKw);
            this.eEq.a(this.aNW);
            this.eEq.a(this.aNX);
            this.eEq.Hy().bE(true);
            this.eEq.d(getPageContext());
        }
        if (this.fKh != null) {
            this.fKh.g(this.eEq);
        }
        if (this.eEq != null && this.fKf != null) {
            this.eEq.a(this.fKf.Cm());
            this.eEq.Iu();
        }
        if (this.eEq != null) {
            this.fHr = this.eEq.Iy().getInputView();
            this.fHr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.fKu != null) {
                        if (!NewSubPbActivity.this.fKu.bGB()) {
                            NewSubPbActivity.this.kW(false);
                        }
                        NewSubPbActivity.this.fKu.nA(false);
                    }
                }
            });
        }
    }

    public void bgZ() {
        if (!TbadkCoreApplication.isLogin()) {
            this.eEq.Iu();
        } else if (!StringUtils.isNull(this.fKf.bhD())) {
            this.fKh.rG(this.fKf.bhD());
            if (this.fKh.bhf() && l.jU()) {
                this.fKh.aql();
            } else {
                this.fKh.bhi();
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
                    b(sparseArray);
                } else {
                    this.fKh.bi(view);
                }
            } else if (booleanValue2) {
                this.fKh.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.fKh.bho(), getPageContext().getPageActivity());
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
        bVar.cg(d.k.operation);
        bVar.a(strArr, new b.InterfaceC0104b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                switch (i) {
                    case 0:
                        String str2 = "";
                        int intValue = sparseArray.get(d.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue() : 0;
                        if (sparseArray.get(d.g.tag_del_post_id) instanceof String) {
                            str2 = (String) sparseArray.get(d.g.tag_del_post_id);
                        }
                        NewSubPbActivity.this.fKh.a(intValue, str2, sparseArray.get(d.g.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue() : false);
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
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.fKr);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.fKr);
                        NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str6, str3, str7);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext()).xq();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
        }
        this.fKh.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.fKr;
        userMuteCheckCustomMessage.setTag(this.fKr);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.fKh.a(0, bVar.Fa, bVar.gPt, z);
            if (bVar.Fa) {
                if (bVar.gPr == 1) {
                    finish();
                } else if (bVar.gPr == 2) {
                    this.fKf.rJ(bVar.mPostId);
                    this.fKh.a(this.fKf.bhv(), this.fKf.bbh(), this.fKf.bhI() != null);
                    if (this.fKf.bhE()) {
                        this.fKf.lb(false);
                        this.fKh.bhd();
                        this.fKf.JW();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
            }
        }
    }

    public void ri(String str) {
        this.fvi.rE(str);
    }

    public void e(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.fKf.isMarked() && postData.getId() != null && postData.getId().equals(this.fKf.bhC())) {
                z = true;
            }
            MarkData g = this.fKf.g(postData);
            if (g != null) {
                this.fKh.bfX();
                if (this.eWM != null) {
                    this.eWM.a(g);
                    if (!z) {
                        this.eWM.se();
                    } else {
                        this.eWM.sd();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.fKf != null) {
            this.fKf.z(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.eEq != null) {
            this.eEq.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.eEq.Hy().FT();
        this.eEq.Iu();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eEq.b(writeData);
                this.eEq.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k eN = this.eEq.Hy().eN(6);
                if (eN != null && eN.aMf != null) {
                    eN.aMf.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eEq.Iq();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.djz != null) {
            this.djz.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.fKp = true;
        super.onPause();
        if (this.djz != null) {
            this.djz.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.ehV);
        this.fKh.awJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fKp = false;
        super.onResume();
        if (this.djz != null) {
            this.djz.onResume(getPageContext());
        }
        registerListener(this.ehV);
        this.fKh.awK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.djz != null) {
            this.djz.onStop(getPageContext());
        }
        this.eEq.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.fKv));
        this.fKf.cancelLoadData();
        this.fKf.destory();
        this.fKg.cancelLoadData();
        if (this.djz != null) {
            this.djz.onDestory(getPageContext());
        }
        this.fKh.bfX();
        this.fKh.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.fwe);
        MessageManager.getInstance().unRegisterListener(this.fwf);
        MessageManager.getInstance().unRegisterListener(this.fwg);
        MessageManager.getInstance().unRegisterListener(this.fKr);
        this.fvB = null;
        this.fvC = null;
        if (this.dkm != null) {
            this.dkm.onDestroy();
        }
        if (this.eEi != null) {
            this.eEi.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fKh.onChangeSkinType(i);
        if (this.dkm != null) {
            this.dkm.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.djz;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bhj = this.fKh.bhj();
        if (bhj == null || (findViewWithTag = bhj.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean rx(String str) {
        Map<String, String> eR;
        if (!TextUtils.isEmpty(str) && (eR = az.eR(az.eS(str))) != null) {
            this.fKs = true;
            String str2 = eR.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return rx(com.baidu.adp.lib.util.k.bh(str2));
            }
            String str3 = eR.get(fKe);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void f(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (rx(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
                    hVar.mLink = str;
                    hVar.type = 3;
                    hVar.aLc = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, hVar));
                }
            } else {
                az.zV().c(getPageContext(), new String[]{str});
            }
            this.fKs = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fKs = true;
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
        if (this.fKh != null) {
            return this.fKh.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Oe() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Og() {
        if (this.bfJ == null) {
            this.bfJ = TbRichTextView.j(getPageContext().getPageActivity(), 8);
        }
        return this.bfJ;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Oh() {
        if (this.bfN == null) {
            this.bfN = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bde */
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
        return this.bfN;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Of() {
        if (this.bfI == null) {
            this.bfI = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: afE */
                public ImageView mo9if() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean tz = com.baidu.tbadk.core.i.tt().tz();
                    foreDrawableImageView.setDefaultBg(am.getDrawable(d.C0142d.common_color_10220));
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
                        foreDrawableImageView.setDefaultBgResource(d.C0142d.cp_bg_line_c);
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
                        foreDrawableImageView.setDefaultBgResource(d.C0142d.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.bfI;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Oi() {
        if (this.bfK == null) {
            this.bfK = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bdf */
                public View mo9if() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bd */
                public void q(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: be */
                public View r(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bf */
                public View s(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.bfK;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Oj() {
        if (this.bfL == null) {
            this.bfL = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bdh */
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
        return this.bfL;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Ok() {
        this.bfM = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bdg */
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
        return this.bfM;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fKh.bhf() && l.jU()) {
            this.fKf.JW();
        } else {
            this.fKh.bhi();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.fKr);
        userMuteAddAndDelCustomMessage.setTag(this.fKr);
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
            public boolean Km() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Kn() {
                return com.baidu.tbadk.pageStayDuration.e.Kr().Kt();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.fKf != null) {
            if (this.fKf.bhv() != null && this.fKf.bhv().bbN() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fKf.bhv().bbN().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fKf.bdP(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.fKp;
    }

    public boolean bha() {
        if (this.fKf != null) {
            return this.fKf.bha();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.fKh.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fvB.getPageActivity());
        if (ap.isEmpty(str)) {
            aVar.dE(this.fvB.getResources().getString(d.k.block_mute_message_alert, str3));
        } else {
            aVar.dE(str);
        }
        aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.fKh.showLoadingDialog();
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
        aVar.b(this.fvB).xn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gV(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fvB.getPageActivity());
        aVar.dE(str);
        aVar.b(d.k.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fvB).xn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dE(getResources().getString(d.k.mute_is_super_member_function));
        aVar.a(d.k.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.fvB).showToast(d.k.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.fvB.getPageActivity(), 2, true, 4);
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
        aVar.b(this.fvB).xn();
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

    public void kW(boolean z) {
        if (this.fHr != null && this.fHr.getText() != null) {
            int selectionEnd = this.fHr.getSelectionEnd();
            SpannableStringBuilder b = this.fKu.b(this.fHr.getText());
            if (b != null) {
                this.fKu.nA(true);
                this.fHr.setText(b);
                if (z && this.fKu.bGz() >= 0) {
                    this.fHr.requestFocus();
                    this.fHr.setSelection(this.fKu.bGz());
                } else {
                    this.fHr.setSelection(selectionEnd);
                }
                this.fKu.nz(this.fKu.bGz() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.dkm == null) {
            this.dkm = new h(getPageContext());
            this.dkm.a(new h.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void aE(boolean z) {
                    if (z) {
                        TiebaStatic.log(new an("c13061"));
                    }
                }
            });
        }
        this.dkm.a(contriInfo, -1L);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.eEq != null && this.eEq.Hy() != null && this.eEq.Hy().HB()) {
            this.eEq.Hy().FT();
        } else {
            super.onBackPressed();
        }
    }
}
