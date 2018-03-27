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
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.h;
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
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.data.k;
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
    private static final String fYd = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String fZy = "tbgametype";
    private com.baidu.adp.lib.e.b<TextView> bLA;
    private com.baidu.adp.lib.e.b<View> bLB;
    private com.baidu.adp.lib.e.b<LinearLayout> bLC;
    private com.baidu.adp.lib.e.b<RelativeLayout> bLD;
    private com.baidu.adp.lib.e.b<GifView> bLE;
    private com.baidu.adp.lib.e.b<ImageView> bLz;
    private View.OnLongClickListener bmk;
    private i dEX;
    private VoiceManager dEn;
    private h eTy;
    private com.baidu.adp.base.e fLA;
    private com.baidu.tbadk.core.view.e fLB;
    private b.InterfaceC0097b fMr;
    private PostWriteCallBackData fPC;
    private EditText fWP;
    private ForumManageModel fZA;
    private c fZB;
    private AbsListView.OnScrollListener fZC;
    private TbRichTextView.i fZD;
    private TbRichTextView.h fZE;
    private SubPbModel.a fZF;
    private com.baidu.adp.base.d fZG;
    private BdUniqueId fZL;
    private b fZN;
    private com.baidu.tieba.write.b fZO;
    private com.baidu.tieba.pb.e<k> fZP;
    private SubPbModel fZz;
    private com.baidu.tbadk.baseEditMark.a flT;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int fMo = 0;
    private a.InterfaceC0093a fMk = null;
    private a fZH = null;
    private a fZI = null;
    private boolean fZJ = false;
    private boolean fZK = false;
    private boolean fZM = false;
    private boolean bsJ = false;
    private com.baidu.tbadk.editortools.pb.c bue = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void LA() {
            NewSubPbActivity.this.fZB.bgB();
        }
    };
    private com.baidu.tbadk.editortools.pb.b bug = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Lz() {
            if (NewSubPbActivity.this.fZO.bFI()) {
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.fZO.bFK());
                if (NewSubPbActivity.this.eTy.LO()) {
                    NewSubPbActivity.this.eTy.a(NewSubPbActivity.this.fPC);
                }
                NewSubPbActivity.this.li(true);
                return true;
            }
            return false;
        }
    };
    private NewWriteModel.d fZQ = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.eTy != null && NewSubPbActivity.this.eTy.Lc() != null) {
                NewSubPbActivity.this.eTy.Lc().hide();
                if (NewSubPbActivity.this.fZz.bgV()) {
                    TiebaStatic.log(new ak("c10367").ab("post_id", NewSubPbActivity.this.fZz.Lx()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fZO.un(null);
                NewSubPbActivity.this.fZO.aw(null);
                NewSubPbActivity.this.fZO.nF(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    NewSubPbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fZO.aw(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fZO.un(postWriteCallBackData.getErrorString());
                if (!v.E(NewSubPbActivity.this.fZO.bFG())) {
                    NewSubPbActivity.this.fPC = postWriteCallBackData;
                    if (NewSubPbActivity.this.eTy.LO()) {
                        NewSubPbActivity.this.eTy.a(NewSubPbActivity.this.fPC);
                    }
                    NewSubPbActivity.this.li(true);
                } else {
                    return;
                }
            }
            NewSubPbActivity.this.fZB.bgC();
        }
    };
    private CustomMessageListener fMd = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fZL) {
                NewSubPbActivity.this.fZB.agg();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fLB.q(NewSubPbActivity.this.fLA.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.fLA.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.gC(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bcx();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (am.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.fLA.getResources().getString(d.j.mute_fail);
                    }
                    NewSubPbActivity.this.fLB.r(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fMe = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fZL) {
                NewSubPbActivity.this.fZB.agg();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fLB.q(NewSubPbActivity.this.fLA.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (am.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.fLA.getResources().getString(d.j.un_mute_fail);
                }
                NewSubPbActivity.this.fLB.r(muteMessage);
            }
        }
    };
    private CustomMessageListener fMf = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fZL) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.fZB.agg();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.hnT;
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
                    NewSubPbActivity.this.fZB.a(sparseArray, z);
                }
            }
        }
    };
    boolean fMp = false;
    private CustomMessageListener exe = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener dFq = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    com.baidu.tbadk.data.h hVar = (com.baidu.tbadk.data.h) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.fZz.bgP() != null && NewSubPbActivity.this.fZz.bgP().bbd() != null && NewSubPbActivity.this.fZz.bgP().bbd().zn() != null && currentAccount.equals(NewSubPbActivity.this.fZz.bgP().bbd().zn().getUserId()) && NewSubPbActivity.this.fZz.bgP().bbd().zn().getPendantData() != null) {
                        NewSubPbActivity.this.fZz.bgP().bbd().zn().getPendantData().cX(hVar.ya());
                        NewSubPbActivity.this.fZz.bgP().bbd().zn().getPendantData().ab(hVar.KE());
                        NewSubPbActivity.this.fZB.a(NewSubPbActivity.this.fZz.bgP().bbd(), NewSubPbActivity.this.fZz.bgP().aLq(), NewSubPbActivity.this.fZz.bgP().vX(), NewSubPbActivity.this.fZz.baG(), NewSubPbActivity.this.fZz.bhc() != null);
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
        E(bundle);
        if (this.bsJ) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.fLA = getPageContext();
        this.fZK = true;
        this.fZO = new com.baidu.tieba.write.b();
        this.fZO.xh(d.C0141d.cp_cont_h_alpha85);
        this.fZO.xg(d.C0141d.cp_cont_i);
        ayg();
        bgr();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.fZz.bgt()) {
            this.fZN = new b(this, getListView(), this.fZB.avk());
            this.fZN.ayl();
            this.fZN.a(new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                private boolean dPD = false;

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void ayh() {
                    NewSubPbActivity.this.fZB.gk(false);
                    this.dPD = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void ayi() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public boolean ayj() {
                    if (!this.dPD) {
                        return NewSubPbActivity.this.fZB.ayx() != null && NewSubPbActivity.this.fZB.ayx().getTop() == 0;
                    }
                    this.dPD = false;
                    return false;
                }
            });
            this.fZB.e(this.fZN);
            this.fZB.gk(true);
        }
        this.fLB = new com.baidu.tbadk.core.view.e();
        this.fLB.baX = 1000L;
        registerListener(this.fMf);
        registerListener(this.fMd);
        registerListener(this.fMe);
        this.fZL = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fZL;
        userMuteAddAndDelCustomMessage.setTag(this.fZL);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fZL;
        userMuteCheckCustomMessage.setTag(this.fZL);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.fZB = new c(this, this.mCommonClickListener);
        this.fZB.a(this.fZz);
        addContentView(this.fZB.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.fZB.setOnScrollListener(this.fZC);
        this.fZB.a(this);
        this.fZB.setOnLinkImageClickListener(this.fZD);
        this.fZB.setOnImageClickListener(this.fZE);
        this.fZB.jU(true);
        this.fZB.setOnLongClickListener(this.bmk);
        this.fZB.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.fZz != null) {
                    NewSubPbActivity.this.fZz.Nw();
                }
            }
        });
        this.fZB.a(this.fZH);
        this.fZB.b(this.fZI);
        if (this.fZz != null && this.fZz.bgt() && !this.fZz.bhb()) {
            this.fZB.bgG().setVisibility(8);
        } else {
            this.fZB.bgG().setVisibility(0);
        }
        if (this.fZz != null && !this.fZz.bgt()) {
            this.fZB.setIsFromPb(false);
        }
    }

    private boolean E(Bundle bundle) {
        if (bundle != null) {
            this.bsJ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.bsJ = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.bsJ;
    }

    public void initData(Bundle bundle) {
        this.fZz = new SubPbModel(getPageContext());
        this.fZz.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.fZB.n(postData);
                NewSubPbActivity.this.fZB.a((BdListView.e) null);
            }
        });
        this.fZA = new ForumManageModel(this);
        this.fZA.setLoadDataCallBack(this.fZG);
        this.dEn = new VoiceManager();
        this.dEn.onCreate(getPageContext());
        this.flT = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.flT != null) {
            this.flT.a(this.fMk);
        }
        if (bundle != null) {
            this.fZz.initWithBundle(bundle);
        } else {
            this.fZz.initWithIntent(getIntent());
        }
        this.fZz.a(this.fZF);
        if (this.fZz.bgt()) {
            this.fZz.Nw();
        } else {
            this.fZz.bgU();
        }
    }

    public void bgr() {
        this.fZF = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, k kVar) {
                if (NewSubPbActivity.this.fZB != null) {
                    NewSubPbActivity.this.fZB.bgC();
                }
                if (NewSubPbActivity.this.fZN != null && NewSubPbActivity.this.fZN.aym()) {
                    NewSubPbActivity.this.fZN.nx(d.C0141d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.ab(i, str);
                    return;
                }
                NewSubPbActivity.this.fZB.hideNoDataView();
                if (kVar != null) {
                    if (kVar.bbd() != null || NewSubPbActivity.this.fZz != null) {
                        kVar.bbd().a(NewSubPbActivity.this.fZz.bha());
                    }
                    if (NewSubPbActivity.this.fZB != null) {
                        NewSubPbActivity.this.fZB.a(kVar, NewSubPbActivity.this.fZz.baG(), NewSubPbActivity.this.fZz.bhc() != null);
                        if (NewSubPbActivity.this.fZK) {
                            NewSubPbActivity.this.bgs();
                            NewSubPbActivity.this.fZK = false;
                        }
                    }
                    if (NewSubPbActivity.this.eTy != null) {
                        NewSubPbActivity.this.eTy.a(kVar.bbl());
                    }
                    if (NewSubPbActivity.this.fZP == null) {
                        NewSubPbActivity.this.fZP = new com.baidu.tieba.pb.e();
                    }
                    NewSubPbActivity.this.fZP.setData(kVar);
                    NewSubPbActivity.this.fZP.setType(0);
                }
            }
        };
        this.fMk = new a.InterfaceC0093a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0093a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.flT != null) {
                        NewSubPbActivity.this.flT.aL(z2);
                    }
                    MarkData wa = NewSubPbActivity.this.flT.wa();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(wa);
                        if (NewSubPbActivity.this.flT != null) {
                            if (wa != null) {
                                NewSubPbActivity.this.fZz.lm(true);
                                NewSubPbActivity.this.fZz.qM(NewSubPbActivity.this.fZz.Lx());
                                NewSubPbActivity.this.showToast(d.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.add_mark));
                            }
                            if (NewSubPbActivity.this.fZB != null) {
                                NewSubPbActivity.this.fZB.lj(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.fZz.lm(false);
                        NewSubPbActivity.this.fZz.qM(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.remove_mark));
                        if (NewSubPbActivity.this.fZB != null) {
                            NewSubPbActivity.this.fZB.lj(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.update_mark_failed));
            }
        };
        this.fZH = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void ak(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.fZz.bgP() != null && NewSubPbActivity.this.fZz.bgP().WE() != null && NewSubPbActivity.this.fZz.bgP().WE().zn() != null) {
                    str = String.valueOf(NewSubPbActivity.this.fZz.bgP().WE().zn().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.fZz.bgP().bbk().getId(), NewSubPbActivity.this.fZz.bgP().bbk().getName(), NewSubPbActivity.this.fZz.bgP().WE().getId(), str, str2, str3)));
            }
        };
        this.fZI = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void ak(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.fZA.bxK() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int h = com.baidu.adp.lib.g.b.h(String.valueOf(objArr[1]), 0);
                        boolean c = com.baidu.adp.lib.g.b.c(String.valueOf(objArr[2]), false);
                        int h2 = com.baidu.adp.lib.g.b.h(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.fZz != null && NewSubPbActivity.this.fZz.bgP() != null && NewSubPbActivity.this.fZz.bgP().bbk() != null && NewSubPbActivity.this.fZz.bgP().WE() != null) {
                            NewSubPbActivity.this.fZA.a(NewSubPbActivity.this.fZz.bgP().bbk().getId(), NewSubPbActivity.this.fZz.bgP().bbk().getName(), NewSubPbActivity.this.fZz.bgP().WE().getId(), valueOf, h2, h, c);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.j.login_to_use), true, 11017)));
            }
        };
        this.fZG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.fZB.a(NewSubPbActivity.this.fZA.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.fZA.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.gaB != 1002 || bVar.ecO) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.fZB.a(1, dVar.aoo, dVar.hdt, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void ayg() {
        registerListener(this.dFq);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.fZB != null) {
                    if (view == NewSubPbActivity.this.fZB.bgM()) {
                        NewSubPbActivity.this.fZB.bfv();
                        String str = view.getTag(d.g.tag_user_id) instanceof String ? (String) view.getTag(d.g.tag_user_id) : null;
                        String str2 = view.getTag(d.g.tag_user_name) instanceof String ? (String) view.getTag(d.g.tag_user_name) : null;
                        String str3 = view.getTag(d.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(d.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                aw.Du().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.fZB.ayy()) {
                        if (view != NewSubPbActivity.this.fZB.bgF()) {
                            if (view != NewSubPbActivity.this.fZB.bgE()) {
                                if (view == NewSubPbActivity.this.fZB.bgA()) {
                                    NewSubPbActivity.this.fZB.bfv();
                                    if (NewSubPbActivity.this.fZz.Nw()) {
                                        NewSubPbActivity.this.fZB.bgy();
                                    }
                                } else if (view == NewSubPbActivity.this.fZB.bgG() || view == NewSubPbActivity.this.fZB.bgH() || view == NewSubPbActivity.this.fZB.bgJ()) {
                                    if (NewSubPbActivity.this.fZM) {
                                        NewSubPbActivity.this.fZM = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.fZz.bdm(), NewSubPbActivity.this.fZz.Lx(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.fZz.bhf())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.fZz.bhf());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.fZB.bgK() == null || view != NewSubPbActivity.this.fZB.bgK().bdY()) {
                                    if (NewSubPbActivity.this.fZB.bgK() == null || view != NewSubPbActivity.this.fZB.bgK().bed()) {
                                        if (NewSubPbActivity.this.fZB.bgK() == null || view != NewSubPbActivity.this.fZB.bgK().beb()) {
                                            if (NewSubPbActivity.this.fZB.bgK() == null || view != NewSubPbActivity.this.fZB.bgK().bdZ()) {
                                                if (NewSubPbActivity.this.fZB.bgK() == null || view != NewSubPbActivity.this.fZB.bgK().bea()) {
                                                    if ((view == NewSubPbActivity.this.fZB.bgD() || view == NewSubPbActivity.this.fZB.bgJ()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.eTy.LW()) {
                                                            NewSubPbActivity.this.eTy.LX();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.eTy.gD(null);
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                                TiebaStatic.log(new ak("c11739").s("obj_locate", 4));
                                                if (!j.oJ()) {
                                                    NewSubPbActivity.this.showToast(d.j.network_not_available);
                                                    return;
                                                }
                                                Object tag = view.getTag();
                                                NewSubPbActivity.this.fZB.bfv();
                                                if (tag instanceof String) {
                                                    String Lx = NewSubPbActivity.this.fZz.Lx();
                                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                        NewSubPbActivity.this.qm(Lx);
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
                                            } else if (j.oJ()) {
                                                NewSubPbActivity.this.fZB.bfv();
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.cC(view);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                NewSubPbActivity.this.showToast(d.j.network_not_available);
                                                return;
                                            }
                                        }
                                        NewSubPbActivity.this.fZB.bfv();
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.fZB.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new ak("c11739").s("obj_locate", 1));
                                    NewSubPbActivity.this.fZB.bfv();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.eTy.gD(null);
                                        if (NewSubPbActivity.this.fZN != null) {
                                            NewSubPbActivity.this.fZN.ayk();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new ak("c11739").s("obj_locate", 2));
                                    NewSubPbActivity.this.fZB.bfv();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.fZz.bgP() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.fZz.bgP().bbd());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.fZB.bgv();
                                NewSubPbActivity.this.fZB.bgw();
                                if (NewSubPbActivity.this.eTy != null) {
                                    NewSubPbActivity.this.eTy.LZ();
                                    if (NewSubPbActivity.this.fZN != null) {
                                        NewSubPbActivity.this.fZN.ayk();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.fZB.bgv();
                            NewSubPbActivity.this.fZB.bgw();
                            if (NewSubPbActivity.this.eTy != null) {
                                NewSubPbActivity.this.eTy.LY();
                                if (NewSubPbActivity.this.fZN != null) {
                                    NewSubPbActivity.this.fZN.ayk();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.eTy.LO()) {
                            NewSubPbActivity.this.eTy.a((PostWriteCallBackData) null);
                            return;
                        }
                        NewSubPbActivity.this.fZB.bgv();
                        NewSubPbActivity.this.fZB.bgw();
                        if (NewSubPbActivity.this.eTy != null) {
                            NewSubPbActivity.this.eTy.Ma();
                            if (NewSubPbActivity.this.fZN != null) {
                                NewSubPbActivity.this.fZN.ayk();
                            }
                        }
                    }
                }
            }
        };
        this.fZC = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.fZB.bfv();
                }
                NewSubPbActivity.this.eTy.LX();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.fZB.bgL();
            }
        };
        this.fMr = new b.InterfaceC0097b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.fZz.bgP() != null) {
                    postData = NewSubPbActivity.this.fZz.bgP().bbd();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.ck(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.f(postData);
                    }
                }
            }
        };
        this.bmk = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                    NewSubPbActivity.this.fZB.b(NewSubPbActivity.this.fMr, NewSubPbActivity.this.fZz.isMarked());
                }
                return true;
            }
        };
        this.fZD = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void b(View view, String str) {
                NewSubPbActivity.this.k(null, str, "LINK_IMAGE");
            }
        };
        this.fZE = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
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
                    k bgP = NewSubPbActivity.this.fZz.bgP();
                    TbRichText az = NewSubPbActivity.this.az(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (az != null && az.Ri() != null) {
                        tbRichTextData = az.Ri().get(NewSubPbActivity.this.fMo);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.Ro().RA()) {
                            String b = NewSubPbActivity.this.b(tbRichTextData);
                            arrayList2.add(b);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                            concurrentHashMap3.put(b, imageUrlData);
                            String str4 = null;
                            String str5 = null;
                            String str6 = null;
                            if (bgP == null) {
                                str3 = null;
                                z4 = false;
                            } else {
                                if (bgP.bbk() != null) {
                                    str4 = bgP.bbk().getName();
                                    str5 = bgP.bbk().getId();
                                }
                                if (bgP.WE() != null) {
                                    str6 = bgP.WE().getId();
                                }
                                str3 = str6;
                                z4 = true;
                            }
                            if (NewSubPbActivity.this.fZz.bhc() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.fZz.bhc();
                                z5 = NewSubPbActivity.this.fZz.bhe();
                                arrayList2 = NewSubPbActivity.this.fZz.bhd();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z5 = z4;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(v.f(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.fMp = false;
                        String str7 = "";
                        TbRichText bxb = bgP.bbd().bxb();
                        int size = arrayList2.size();
                        int a2 = NewSubPbActivity.this.a(bxb, az, i, i, arrayList2, concurrentHashMap3);
                        int size2 = arrayList2.size();
                        if (size != size2) {
                            str7 = arrayList2.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (bgP == null) {
                            str2 = null;
                            z2 = false;
                        } else {
                            if (bgP.bbk() != null) {
                                str8 = bgP.bbk().getName();
                                str9 = bgP.bbk().getId();
                            }
                            if (bgP.WE() != null) {
                                str10 = bgP.WE().getId();
                            }
                            str2 = str10;
                            z2 = true;
                        }
                        if (NewSubPbActivity.this.fZz.bhc() != null) {
                            concurrentHashMap = NewSubPbActivity.this.fZz.bhc();
                            z3 = NewSubPbActivity.this.fZz.bhe();
                            arrayList = NewSubPbActivity.this.fZz.bhd();
                            i2 = a2 + NewSubPbActivity.this.fZz.getOffset();
                        } else {
                            concurrentHashMap = concurrentHashMap3;
                            i2 = a2;
                            z3 = z2;
                            arrayList = arrayList2;
                        }
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.add(v.f(arrayList, i2));
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
        TbRichTextImageInfo Ro;
        if (tbRichText == tbRichText2) {
            this.fMp = true;
        }
        if (tbRichText != null && tbRichText.Ri() != null) {
            int size = tbRichText.Ri().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Ri().get(i6) != null && tbRichText.Ri().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.Ri().get(i6).Ro().getWidth();
                    int height = tbRichText.Ri().get(i6).Ro().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Ri().get(i6).Ro().RA()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Ri().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (Ro = tbRichTextData.Ro()) != null) {
                            String RC = Ro.RC();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = RC;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.fMp) {
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
        TbRichTextImageInfo Ro = tbRichTextData.Ro();
        if (Ro != null) {
            if (!StringUtils.isNull(Ro.Rz())) {
                return Ro.Rz();
            }
            if (Ro.getHeight() * Ro.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Ro.getHeight() * Ro.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Ro.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Ro.getHeight())));
            } else {
                float width = Ro.getWidth() / Ro.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aV(Ro.RB()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText az(String str, int i) {
        if (this.fZz == null || this.fZz.bgP() == null || str == null || i < 0) {
            return null;
        }
        k bgP = this.fZz.bgP();
        TbRichText a2 = a(bgP.bbd(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bgP.bbd(), str, i);
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
            ArrayList<TbRichTextData> Ri = bxb.Ri();
            int size = Ri.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Ri.get(i3) != null && Ri.get(i3).getType() == 8) {
                    i2++;
                    if (Ri.get(i3).Ro().RC().equals(str)) {
                        int width = Ri.get(i3).Ro().getWidth();
                        int height = Ri.get(i3).Ro().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.fMo = i3;
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
    public void k(Context context, String str, String str2) {
        long templateId = this.fZz.bgP().bbd().bxi() != null ? this.fZz.bgP().bbd().bxi().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && aw.Du().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.fZz.bgP().bbk().getId(), this.fZz.bgP().bbk().getName(), this.fZz.bgP().WE().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, String str) {
        if (this.fZz.bgQ()) {
            showToast(str);
        } else if (l.pa()) {
            if (i == 4) {
                this.fZB.lS(str + "(4)");
            } else {
                this.fZB.lc(d.j.no_data_text);
            }
        } else {
            this.fZB.lc(d.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.eTy = (h) new com.baidu.tbadk.editortools.pb.i().bd(getActivity());
        if (this.eTy != null) {
            this.eTy.setContext(getPageContext());
            this.eTy.b(this.fZz);
            this.eTy.b(this.fZQ);
            this.eTy.a(this.bue);
            this.eTy.a(this.bug);
            this.eTy.Lc().cf(true);
            this.eTy.d(getPageContext());
        }
        if (this.fZB != null) {
            this.fZB.g(this.eTy);
        }
        if (this.eTy != null && this.fZz != null) {
            this.eTy.a(this.fZz.bbl());
            this.eTy.LX();
        }
        if (this.eTy != null) {
            this.fWP = this.eTy.Mb().getInputView();
            this.fWP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.fZO != null) {
                        if (!NewSubPbActivity.this.fZO.bFJ()) {
                            NewSubPbActivity.this.li(false);
                        }
                        NewSubPbActivity.this.fZO.nG(false);
                    }
                }
            });
        }
    }

    public void bgs() {
        if (!TbadkCoreApplication.isLogin()) {
            this.eTy.LX();
        } else if (!StringUtils.isNull(this.fZz.bgX())) {
            this.fZB.qI(this.fZz.bgX());
            if (this.fZB.bgz() && l.pa()) {
                this.fZB.asv();
            } else {
                this.fZB.bgC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cC(View view) {
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
                    this.fZB.cy(view);
                }
            } else if (booleanValue2) {
                this.fZB.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            g.a(this.fZB.bgI(), getPageContext().getPageActivity());
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
        bVar.fe(d.j.operation);
        bVar.a(strArr, new b.InterfaceC0097b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                switch (i) {
                    case 0:
                        String str2 = "";
                        int intValue = sparseArray.get(d.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue() : 0;
                        if (sparseArray.get(d.g.tag_del_post_id) instanceof String) {
                            str2 = (String) sparseArray.get(d.g.tag_del_post_id);
                        }
                        NewSubPbActivity.this.fZB.a(intValue, str2, sparseArray.get(d.g.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue() : false);
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
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.fZL);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.fZL);
                        NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str6, str3);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext()).AY();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
        }
        this.fZB.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.fZL;
        userMuteCheckCustomMessage.setTag(this.fZL);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.fZB.a(0, bVar.aoo, bVar.hdt, z);
            if (bVar.aoo) {
                if (bVar.hdr == 1) {
                    finish();
                } else if (bVar.hdr == 2) {
                    this.fZz.qL(bVar.mPostId);
                    this.fZB.a(this.fZz.bgP(), this.fZz.baG(), this.fZz.bhc() != null);
                    if (this.fZz.bgY()) {
                        this.fZz.ln(false);
                        this.fZB.bgx();
                        this.fZz.Nw();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
            }
        }
    }

    public void qm(String str) {
        if (!StringUtils.isNull(str) && this.fZz != null) {
            String bdm = this.fZz.bdm();
            String Lx = this.fZz.Lx();
            sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Lx + "&tid=" + bdm + "&pid=" + str, true)));
        }
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.fZz.isMarked() && postData.getId() != null && postData.getId().equals(this.fZz.bgW())) {
                z = true;
            }
            MarkData h = this.fZz.h(postData);
            if (h != null) {
                this.fZB.bfv();
                if (this.flT != null) {
                    this.flT.a(h);
                    if (!z) {
                        this.flT.vZ();
                    } else {
                        this.flT.vY();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.fZz != null) {
            this.fZz.D(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.eTy != null) {
            this.eTy.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.eTy.Lc().Jm();
        this.eTy.LX();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eTy.b(writeData);
                this.eTy.setVoiceModel(pbEditorData.getVoiceModel());
                r hI = this.eTy.Lc().hI(6);
                if (hI != null && hI.bsm != null) {
                    hI.bsm.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eTy.LT();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dEn != null) {
            this.dEn.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.fZJ = true;
        super.onPause();
        if (this.dEn != null) {
            this.dEn.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.exe);
        this.fZB.axD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fZJ = false;
        super.onResume();
        if (this.dEn != null) {
            this.dEn.onResume(getPageContext());
        }
        registerListener(this.exe);
        this.fZB.axE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dEn != null) {
            this.dEn.onStop(getPageContext());
        }
        this.eTy.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.fZP));
        this.fZz.cancelLoadData();
        this.fZz.destory();
        this.fZA.cancelLoadData();
        if (this.dEn != null) {
            this.dEn.onDestory(getPageContext());
        }
        this.fZB.bfv();
        this.fZB.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.fMd);
        MessageManager.getInstance().unRegisterListener(this.fMe);
        MessageManager.getInstance().unRegisterListener(this.fMf);
        MessageManager.getInstance().unRegisterListener(this.fZL);
        this.fLA = null;
        this.fLB = null;
        if (this.dEX != null) {
            this.dEX.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fZB.onChangeSkinType(i);
        if (this.dEX != null) {
            this.dEX.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dEn;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bgD = this.fZB.bgD();
        if (bgD == null || (findViewWithTag = bgD.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean qB(String str) {
        Map<String, String> ex;
        if (!TextUtils.isEmpty(str) && (ex = aw.ex(aw.ey(str))) != null) {
            this.fZM = true;
            String str2 = ex.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return qB(com.baidu.adp.lib.util.k.aW(str2));
            }
            String str3 = ex.get(fZy);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (qB(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            aw.Du().c(getPageContext(), new String[]{str});
            this.fZM = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fZM = true;
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
        if (this.fZB != null) {
            return this.fZB.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int RO() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> RQ() {
        if (this.bLA == null) {
            this.bLA = TbRichTextView.y(getPageContext().getPageActivity(), 8);
        }
        return this.bLA;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> RR() {
        if (this.bLE == null) {
            this.bLE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bcC */
                public GifView nl() {
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
        return this.bLE;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> RP() {
        if (this.bLz == null) {
            this.bLz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: ahq */
                public ImageView nl() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean xu = com.baidu.tbadk.core.i.xo().xu();
                    foreDrawableImageView.setDefaultBg(aj.getDrawable(d.C0141d.common_color_10220));
                    if (xu) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0141d.cp_bg_line_c);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView at(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.xo().xu()) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0141d.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.bLz;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> RS() {
        if (this.bLB == null) {
            this.bLB = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bcD */
                public View nl() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: ct */
                public void as(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cu */
                public View at(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cv */
                public View au(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.bLB;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> RT() {
        if (this.bLC == null) {
            this.bLC = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bcF */
                public LinearLayout nl() {
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
        return this.bLC;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> RU() {
        this.bLD = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bcE */
            public RelativeLayout nl() {
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
        return this.bLD;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fZB.bgz() && l.pa()) {
            this.fZz.Nw();
        } else {
            this.fZB.bgC();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.fZL);
        userMuteAddAndDelCustomMessage.setTag(this.fZL);
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
            public boolean NM() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int NN() {
                return com.baidu.tbadk.pageStayDuration.e.NR().NT();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.fZz != null) {
            if (this.fZz.bgP() != null && this.fZz.bgP().bbk() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fZz.bgP().bbk().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fZz.bdm(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.fZJ;
    }

    public boolean bgt() {
        if (this.fZz != null) {
            return this.fZz.bgt();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.fZB.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fLA.getPageActivity());
        if (am.isEmpty(str)) {
            aVar.dk(this.fLA.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.dk(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.fZB.showLoadingDialog();
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
        aVar.b(this.fLA).AV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fLA.getPageActivity());
        aVar.dk(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fLA).AV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dk(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.fLA).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.fLA.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fLA).AV();
    }

    public String getThreadId() {
        if (this.fZz != null) {
            return this.fZz.bdm();
        }
        return null;
    }

    public String getPostId() {
        if (this.fZz != null) {
            return this.fZz.Lx();
        }
        return null;
    }

    public int baG() {
        if (this.fZz != null) {
            return this.fZz.baG();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.bsJ) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.bsJ) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void li(boolean z) {
        if (this.fWP != null && this.fWP.getText() != null) {
            int selectionEnd = this.fWP.getSelectionEnd();
            SpannableStringBuilder b = this.fZO.b(this.fWP.getText());
            if (b != null) {
                this.fZO.nG(true);
                this.fWP.setText(b);
                if (z && this.fZO.bFH() >= 0) {
                    this.fWP.requestFocus();
                    this.fWP.setSelection(this.fZO.bFH());
                } else {
                    this.fWP.setSelection(selectionEnd);
                }
                this.fZO.nF(this.fZO.bFH() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.dEX == null) {
            this.dEX = new i(getPageContext());
        }
        this.dEX.a(contriInfo, -1L);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.eTy != null && this.eTy.Lc() != null && this.eTy.Lc().Lf()) {
            this.eTy.Lc().Jm();
        } else {
            super.onBackPressed();
        }
    }
}
