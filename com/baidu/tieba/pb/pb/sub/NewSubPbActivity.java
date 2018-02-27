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
    private static final String fXN = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String fZi = "tbgametype";
    private com.baidu.adp.lib.e.b<RelativeLayout> bLA;
    private com.baidu.adp.lib.e.b<GifView> bLB;
    private com.baidu.adp.lib.e.b<ImageView> bLw;
    private com.baidu.adp.lib.e.b<TextView> bLx;
    private com.baidu.adp.lib.e.b<View> bLy;
    private com.baidu.adp.lib.e.b<LinearLayout> bLz;
    private View.OnLongClickListener bmh;
    private i dEU;
    private VoiceManager dEk;
    private h eTj;
    private com.baidu.adp.base.e fLk;
    private com.baidu.tbadk.core.view.e fLl;
    private b.InterfaceC0097b fMb;
    private PostWriteCallBackData fPm;
    private EditText fWz;
    private SubPbModel fZj;
    private ForumManageModel fZk;
    private c fZl;
    private AbsListView.OnScrollListener fZm;
    private TbRichTextView.i fZn;
    private TbRichTextView.h fZo;
    private SubPbModel.a fZp;
    private com.baidu.adp.base.d fZq;
    private BdUniqueId fZv;
    private b fZx;
    private com.baidu.tieba.write.b fZy;
    private com.baidu.tieba.pb.e<k> fZz;
    private com.baidu.tbadk.baseEditMark.a flD;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int fLY = 0;
    private a.InterfaceC0093a fLU = null;
    private a fZr = null;
    private a fZs = null;
    private boolean fZt = false;
    private boolean fZu = false;
    private boolean fZw = false;
    private boolean bsG = false;
    private com.baidu.tbadk.editortools.pb.c bub = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Lz() {
            NewSubPbActivity.this.fZl.bgA();
        }
    };
    private com.baidu.tbadk.editortools.pb.b buc = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Ly() {
            if (NewSubPbActivity.this.fZy.bFD()) {
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.fZy.bFF());
                if (NewSubPbActivity.this.eTj.LN()) {
                    NewSubPbActivity.this.eTj.a(NewSubPbActivity.this.fPm);
                }
                NewSubPbActivity.this.ld(true);
                return true;
            }
            return false;
        }
    };
    private NewWriteModel.d fZA = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.eTj != null && NewSubPbActivity.this.eTj.Lb() != null) {
                NewSubPbActivity.this.eTj.Lb().hide();
                if (NewSubPbActivity.this.fZj.bgU()) {
                    TiebaStatic.log(new ak("c10367").ab("post_id", NewSubPbActivity.this.fZj.Lw()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fZy.un(null);
                NewSubPbActivity.this.fZy.aw(null);
                NewSubPbActivity.this.fZy.nA(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    NewSubPbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fZy.aw(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fZy.un(postWriteCallBackData.getErrorString());
                if (!v.E(NewSubPbActivity.this.fZy.bFB())) {
                    NewSubPbActivity.this.fPm = postWriteCallBackData;
                    if (NewSubPbActivity.this.eTj.LN()) {
                        NewSubPbActivity.this.eTj.a(NewSubPbActivity.this.fPm);
                    }
                    NewSubPbActivity.this.ld(true);
                } else {
                    return;
                }
            }
            NewSubPbActivity.this.fZl.bgB();
        }
    };
    private CustomMessageListener fLN = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fZv) {
                NewSubPbActivity.this.fZl.agf();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fLl.q(NewSubPbActivity.this.fLk.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.fLk.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.gC(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bcw();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (am.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.fLk.getResources().getString(d.j.mute_fail);
                    }
                    NewSubPbActivity.this.fLl.r(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fLO = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fZv) {
                NewSubPbActivity.this.fZl.agf();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fLl.q(NewSubPbActivity.this.fLk.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (am.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.fLk.getResources().getString(d.j.un_mute_fail);
                }
                NewSubPbActivity.this.fLl.r(muteMessage);
            }
        }
    };
    private CustomMessageListener fLP = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fZv) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.fZl.agf();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.hnv;
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
                    NewSubPbActivity.this.fZl.a(sparseArray, z);
                }
            }
        }
    };
    boolean fLZ = false;
    private CustomMessageListener ewO = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener dFm = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    com.baidu.tbadk.data.h hVar = (com.baidu.tbadk.data.h) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.fZj.bgO() != null && NewSubPbActivity.this.fZj.bgO().bbc() != null && NewSubPbActivity.this.fZj.bgO().bbc().zn() != null && currentAccount.equals(NewSubPbActivity.this.fZj.bgO().bbc().zn().getUserId()) && NewSubPbActivity.this.fZj.bgO().bbc().zn().getPendantData() != null) {
                        NewSubPbActivity.this.fZj.bgO().bbc().zn().getPendantData().cX(hVar.ya());
                        NewSubPbActivity.this.fZj.bgO().bbc().zn().getPendantData().ab(hVar.KD());
                        NewSubPbActivity.this.fZl.a(NewSubPbActivity.this.fZj.bgO().bbc(), NewSubPbActivity.this.fZj.bgO().aLp(), NewSubPbActivity.this.fZj.bgO().vX(), NewSubPbActivity.this.fZj.baF(), NewSubPbActivity.this.fZj.bhb() != null);
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
        if (this.bsG) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.fLk = getPageContext();
        this.fZu = true;
        this.fZy = new com.baidu.tieba.write.b();
        this.fZy.xh(d.C0141d.cp_cont_h_alpha85);
        this.fZy.xg(d.C0141d.cp_cont_i);
        aye();
        bgq();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.fZj.bgs()) {
            this.fZx = new b(this, getListView(), this.fZl.avj());
            this.fZx.ayj();
            this.fZx.a(new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                private boolean dPy = false;

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void ayf() {
                    NewSubPbActivity.this.fZl.gj(false);
                    this.dPy = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void ayg() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public boolean ayh() {
                    if (!this.dPy) {
                        return NewSubPbActivity.this.fZl.ayv() != null && NewSubPbActivity.this.fZl.ayv().getTop() == 0;
                    }
                    this.dPy = false;
                    return false;
                }
            });
            this.fZl.e(this.fZx);
            this.fZl.gj(true);
        }
        this.fLl = new com.baidu.tbadk.core.view.e();
        this.fLl.baV = 1000L;
        registerListener(this.fLP);
        registerListener(this.fLN);
        registerListener(this.fLO);
        this.fZv = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fZv;
        userMuteAddAndDelCustomMessage.setTag(this.fZv);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fZv;
        userMuteCheckCustomMessage.setTag(this.fZv);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.fZl = new c(this, this.mCommonClickListener);
        this.fZl.a(this.fZj);
        addContentView(this.fZl.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.fZl.setOnScrollListener(this.fZm);
        this.fZl.a(this);
        this.fZl.setOnLinkImageClickListener(this.fZn);
        this.fZl.setOnImageClickListener(this.fZo);
        this.fZl.jP(true);
        this.fZl.setOnLongClickListener(this.bmh);
        this.fZl.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.fZj != null) {
                    NewSubPbActivity.this.fZj.Nv();
                }
            }
        });
        this.fZl.a(this.fZr);
        this.fZl.b(this.fZs);
        if (this.fZj != null && this.fZj.bgs() && !this.fZj.bha()) {
            this.fZl.bgF().setVisibility(8);
        } else {
            this.fZl.bgF().setVisibility(0);
        }
        if (this.fZj != null && !this.fZj.bgs()) {
            this.fZl.setIsFromPb(false);
        }
    }

    private boolean E(Bundle bundle) {
        if (bundle != null) {
            this.bsG = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.bsG = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.bsG;
    }

    public void initData(Bundle bundle) {
        this.fZj = new SubPbModel(getPageContext());
        this.fZj.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.fZl.n(postData);
                NewSubPbActivity.this.fZl.a((BdListView.e) null);
            }
        });
        this.fZk = new ForumManageModel(this);
        this.fZk.setLoadDataCallBack(this.fZq);
        this.dEk = new VoiceManager();
        this.dEk.onCreate(getPageContext());
        this.flD = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.flD != null) {
            this.flD.a(this.fLU);
        }
        if (bundle != null) {
            this.fZj.initWithBundle(bundle);
        } else {
            this.fZj.initWithIntent(getIntent());
        }
        this.fZj.a(this.fZp);
        if (this.fZj.bgs()) {
            this.fZj.Nv();
        } else {
            this.fZj.bgT();
        }
    }

    public void bgq() {
        this.fZp = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, k kVar) {
                if (NewSubPbActivity.this.fZl != null) {
                    NewSubPbActivity.this.fZl.bgB();
                }
                if (NewSubPbActivity.this.fZx != null && NewSubPbActivity.this.fZx.ayk()) {
                    NewSubPbActivity.this.fZx.nx(d.C0141d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.ab(i, str);
                    return;
                }
                NewSubPbActivity.this.fZl.hideNoDataView();
                if (kVar != null) {
                    if (kVar.bbc() != null || NewSubPbActivity.this.fZj != null) {
                        kVar.bbc().a(NewSubPbActivity.this.fZj.bgZ());
                    }
                    if (NewSubPbActivity.this.fZl != null) {
                        NewSubPbActivity.this.fZl.a(kVar, NewSubPbActivity.this.fZj.baF(), NewSubPbActivity.this.fZj.bhb() != null);
                        if (NewSubPbActivity.this.fZu) {
                            NewSubPbActivity.this.bgr();
                            NewSubPbActivity.this.fZu = false;
                        }
                    }
                    if (NewSubPbActivity.this.eTj != null) {
                        NewSubPbActivity.this.eTj.a(kVar.bbk());
                    }
                    if (NewSubPbActivity.this.fZz == null) {
                        NewSubPbActivity.this.fZz = new com.baidu.tieba.pb.e();
                    }
                    NewSubPbActivity.this.fZz.setData(kVar);
                    NewSubPbActivity.this.fZz.setType(0);
                }
            }
        };
        this.fLU = new a.InterfaceC0093a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0093a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.flD != null) {
                        NewSubPbActivity.this.flD.aL(z2);
                    }
                    MarkData wa = NewSubPbActivity.this.flD.wa();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(wa);
                        if (NewSubPbActivity.this.flD != null) {
                            if (wa != null) {
                                NewSubPbActivity.this.fZj.lh(true);
                                NewSubPbActivity.this.fZj.qM(NewSubPbActivity.this.fZj.Lw());
                                NewSubPbActivity.this.showToast(d.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.add_mark));
                            }
                            if (NewSubPbActivity.this.fZl != null) {
                                NewSubPbActivity.this.fZl.le(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.fZj.lh(false);
                        NewSubPbActivity.this.fZj.qM(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.remove_mark));
                        if (NewSubPbActivity.this.fZl != null) {
                            NewSubPbActivity.this.fZl.le(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.update_mark_failed));
            }
        };
        this.fZr = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void ak(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.fZj.bgO() != null && NewSubPbActivity.this.fZj.bgO().WD() != null && NewSubPbActivity.this.fZj.bgO().WD().zn() != null) {
                    str = String.valueOf(NewSubPbActivity.this.fZj.bgO().WD().zn().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.fZj.bgO().bbj().getId(), NewSubPbActivity.this.fZj.bgO().bbj().getName(), NewSubPbActivity.this.fZj.bgO().WD().getId(), str, str2, str3)));
            }
        };
        this.fZs = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void ak(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.fZk.bxF() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int h = com.baidu.adp.lib.g.b.h(String.valueOf(objArr[1]), 0);
                        boolean c = com.baidu.adp.lib.g.b.c(String.valueOf(objArr[2]), false);
                        int h2 = com.baidu.adp.lib.g.b.h(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.fZj != null && NewSubPbActivity.this.fZj.bgO() != null && NewSubPbActivity.this.fZj.bgO().bbj() != null && NewSubPbActivity.this.fZj.bgO().WD() != null) {
                            NewSubPbActivity.this.fZk.a(NewSubPbActivity.this.fZj.bgO().bbj().getId(), NewSubPbActivity.this.fZj.bgO().bbj().getName(), NewSubPbActivity.this.fZj.bgO().WD().getId(), valueOf, h2, h, c);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.j.login_to_use), true, 11017)));
            }
        };
        this.fZq = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.fZl.a(NewSubPbActivity.this.fZk.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.fZk.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.gal != 1002 || bVar.ecy) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.fZl.a(1, dVar.aoo, dVar.hcV, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void aye() {
        registerListener(this.dFm);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.fZl != null) {
                    if (view == NewSubPbActivity.this.fZl.bgL()) {
                        NewSubPbActivity.this.fZl.bfu();
                        String str = view.getTag(d.g.tag_user_id) instanceof String ? (String) view.getTag(d.g.tag_user_id) : null;
                        String str2 = view.getTag(d.g.tag_user_name) instanceof String ? (String) view.getTag(d.g.tag_user_name) : null;
                        String str3 = view.getTag(d.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(d.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                aw.Dt().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.fZl.ayw()) {
                        if (view != NewSubPbActivity.this.fZl.bgE()) {
                            if (view != NewSubPbActivity.this.fZl.bgD()) {
                                if (view == NewSubPbActivity.this.fZl.bgz()) {
                                    NewSubPbActivity.this.fZl.bfu();
                                    if (NewSubPbActivity.this.fZj.Nv()) {
                                        NewSubPbActivity.this.fZl.bgx();
                                    }
                                } else if (view == NewSubPbActivity.this.fZl.bgF() || view == NewSubPbActivity.this.fZl.bgG() || view == NewSubPbActivity.this.fZl.bgI()) {
                                    if (NewSubPbActivity.this.fZw) {
                                        NewSubPbActivity.this.fZw = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.fZj.bdl(), NewSubPbActivity.this.fZj.Lw(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.fZj.bhe())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.fZj.bhe());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.fZl.bgJ() == null || view != NewSubPbActivity.this.fZl.bgJ().bdX()) {
                                    if (NewSubPbActivity.this.fZl.bgJ() == null || view != NewSubPbActivity.this.fZl.bgJ().bec()) {
                                        if (NewSubPbActivity.this.fZl.bgJ() == null || view != NewSubPbActivity.this.fZl.bgJ().bea()) {
                                            if (NewSubPbActivity.this.fZl.bgJ() == null || view != NewSubPbActivity.this.fZl.bgJ().bdY()) {
                                                if (NewSubPbActivity.this.fZl.bgJ() == null || view != NewSubPbActivity.this.fZl.bgJ().bdZ()) {
                                                    if ((view == NewSubPbActivity.this.fZl.bgC() || view == NewSubPbActivity.this.fZl.bgI()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.eTj.LV()) {
                                                            NewSubPbActivity.this.eTj.LW();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.eTj.gD(null);
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
                                                NewSubPbActivity.this.fZl.bfu();
                                                if (tag instanceof String) {
                                                    String Lw = NewSubPbActivity.this.fZj.Lw();
                                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                        NewSubPbActivity.this.qm(Lw);
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
                                                NewSubPbActivity.this.fZl.bfu();
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
                                        NewSubPbActivity.this.fZl.bfu();
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.fZl.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new ak("c11739").s("obj_locate", 1));
                                    NewSubPbActivity.this.fZl.bfu();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.eTj.gD(null);
                                        if (NewSubPbActivity.this.fZx != null) {
                                            NewSubPbActivity.this.fZx.ayi();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new ak("c11739").s("obj_locate", 2));
                                    NewSubPbActivity.this.fZl.bfu();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.fZj.bgO() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.fZj.bgO().bbc());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.fZl.bgu();
                                NewSubPbActivity.this.fZl.bgv();
                                if (NewSubPbActivity.this.eTj != null) {
                                    NewSubPbActivity.this.eTj.LY();
                                    if (NewSubPbActivity.this.fZx != null) {
                                        NewSubPbActivity.this.fZx.ayi();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.fZl.bgu();
                            NewSubPbActivity.this.fZl.bgv();
                            if (NewSubPbActivity.this.eTj != null) {
                                NewSubPbActivity.this.eTj.LX();
                                if (NewSubPbActivity.this.fZx != null) {
                                    NewSubPbActivity.this.fZx.ayi();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.eTj.LN()) {
                            NewSubPbActivity.this.eTj.a((PostWriteCallBackData) null);
                            return;
                        }
                        NewSubPbActivity.this.fZl.bgu();
                        NewSubPbActivity.this.fZl.bgv();
                        if (NewSubPbActivity.this.eTj != null) {
                            NewSubPbActivity.this.eTj.LZ();
                            if (NewSubPbActivity.this.fZx != null) {
                                NewSubPbActivity.this.fZx.ayi();
                            }
                        }
                    }
                }
            }
        };
        this.fZm = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.fZl.bfu();
                }
                NewSubPbActivity.this.eTj.LW();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.fZl.bgK();
            }
        };
        this.fMb = new b.InterfaceC0097b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.fZj.bgO() != null) {
                    postData = NewSubPbActivity.this.fZj.bgO().bbc();
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
        this.bmh = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                    NewSubPbActivity.this.fZl.b(NewSubPbActivity.this.fMb, NewSubPbActivity.this.fZj.isMarked());
                }
                return true;
            }
        };
        this.fZn = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void b(View view, String str) {
                NewSubPbActivity.this.k(null, str, "LINK_IMAGE");
            }
        };
        this.fZo = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
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
                    k bgO = NewSubPbActivity.this.fZj.bgO();
                    TbRichText az = NewSubPbActivity.this.az(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (az != null && az.Rh() != null) {
                        tbRichTextData = az.Rh().get(NewSubPbActivity.this.fLY);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.Rn().Rz()) {
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
                                if (bgO.bbj() != null) {
                                    str4 = bgO.bbj().getName();
                                    str5 = bgO.bbj().getId();
                                }
                                if (bgO.WD() != null) {
                                    str6 = bgO.WD().getId();
                                }
                                str3 = str6;
                                z4 = true;
                            }
                            if (NewSubPbActivity.this.fZj.bhb() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.fZj.bhb();
                                z5 = NewSubPbActivity.this.fZj.bhd();
                                arrayList2 = NewSubPbActivity.this.fZj.bhc();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z5 = z4;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(v.f(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.fLZ = false;
                        String str7 = "";
                        TbRichText bwW = bgO.bbc().bwW();
                        int size = arrayList2.size();
                        int a2 = NewSubPbActivity.this.a(bwW, az, i, i, arrayList2, concurrentHashMap3);
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
                            if (bgO.bbj() != null) {
                                str8 = bgO.bbj().getName();
                                str9 = bgO.bbj().getId();
                            }
                            if (bgO.WD() != null) {
                                str10 = bgO.WD().getId();
                            }
                            str2 = str10;
                            z2 = true;
                        }
                        if (NewSubPbActivity.this.fZj.bhb() != null) {
                            concurrentHashMap = NewSubPbActivity.this.fZj.bhb();
                            z3 = NewSubPbActivity.this.fZj.bhd();
                            arrayList = NewSubPbActivity.this.fZj.bhc();
                            i2 = a2 + NewSubPbActivity.this.fZj.getOffset();
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
        TbRichTextImageInfo Rn;
        if (tbRichText == tbRichText2) {
            this.fLZ = true;
        }
        if (tbRichText != null && tbRichText.Rh() != null) {
            int size = tbRichText.Rh().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Rh().get(i6) != null && tbRichText.Rh().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.Rh().get(i6).Rn().getWidth();
                    int height = tbRichText.Rh().get(i6).Rn().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Rh().get(i6).Rn().Rz()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Rh().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (Rn = tbRichTextData.Rn()) != null) {
                            String RB = Rn.RB();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = RB;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.fLZ) {
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
        TbRichTextImageInfo Rn = tbRichTextData.Rn();
        if (Rn != null) {
            if (!StringUtils.isNull(Rn.Ry())) {
                return Rn.Ry();
            }
            if (Rn.getHeight() * Rn.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Rn.getHeight() * Rn.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Rn.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Rn.getHeight())));
            } else {
                float width = Rn.getWidth() / Rn.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aV(Rn.RA()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText az(String str, int i) {
        if (this.fZj == null || this.fZj.bgO() == null || str == null || i < 0) {
            return null;
        }
        k bgO = this.fZj.bgO();
        TbRichText a2 = a(bgO.bbc(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bgO.bbc(), str, i);
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
        TbRichText bwW = postData.bwW();
        if (bwW != null) {
            ArrayList<TbRichTextData> Rh = bwW.Rh();
            int size = Rh.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Rh.get(i3) != null && Rh.get(i3).getType() == 8) {
                    i2++;
                    if (Rh.get(i3).Rn().RB().equals(str)) {
                        int width = Rh.get(i3).Rn().getWidth();
                        int height = Rh.get(i3).Rn().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.fLY = i3;
                        return bwW;
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
        long templateId = this.fZj.bgO().bbc().bxd() != null ? this.fZj.bgO().bbc().bxd().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && aw.Dt().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.fZj.bgO().bbj().getId(), this.fZj.bgO().bbj().getName(), this.fZj.bgO().WD().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, String str) {
        if (this.fZj.bgP()) {
            showToast(str);
        } else if (l.pa()) {
            if (i == 4) {
                this.fZl.lS(str + "(4)");
            } else {
                this.fZl.lc(d.j.no_data_text);
            }
        } else {
            this.fZl.lc(d.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.eTj = (h) new com.baidu.tbadk.editortools.pb.i().bd(getActivity());
        if (this.eTj != null) {
            this.eTj.setContext(getPageContext());
            this.eTj.b(this.fZj);
            this.eTj.b(this.fZA);
            this.eTj.a(this.bub);
            this.eTj.a(this.buc);
            this.eTj.Lb().cf(true);
            this.eTj.d(getPageContext());
        }
        if (this.fZl != null) {
            this.fZl.g(this.eTj);
        }
        if (this.eTj != null && this.fZj != null) {
            this.eTj.a(this.fZj.bbk());
            this.eTj.LW();
        }
        if (this.eTj != null) {
            this.fWz = this.eTj.Ma().getInputView();
            this.fWz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.fZy != null) {
                        if (!NewSubPbActivity.this.fZy.bFE()) {
                            NewSubPbActivity.this.ld(false);
                        }
                        NewSubPbActivity.this.fZy.nB(false);
                    }
                }
            });
        }
    }

    public void bgr() {
        if (!TbadkCoreApplication.isLogin()) {
            this.eTj.LW();
        } else if (!StringUtils.isNull(this.fZj.bgW())) {
            this.fZl.qI(this.fZj.bgW());
            if (this.fZl.bgy() && l.pa()) {
                this.fZl.asu();
            } else {
                this.fZl.bgB();
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
                    this.fZl.cy(view);
                }
            } else if (booleanValue2) {
                this.fZl.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            g.a(this.fZl.bgH(), getPageContext().getPageActivity());
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
                        NewSubPbActivity.this.fZl.a(intValue, str2, sparseArray.get(d.g.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue() : false);
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
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.fZv);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.fZv);
                        NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str6, str3);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext()).AX();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
        }
        this.fZl.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.fZv;
        userMuteCheckCustomMessage.setTag(this.fZv);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.fZl.a(0, bVar.aoo, bVar.hcV, z);
            if (bVar.aoo) {
                if (bVar.hcT == 1) {
                    finish();
                } else if (bVar.hcT == 2) {
                    this.fZj.qL(bVar.mPostId);
                    this.fZl.a(this.fZj.bgO(), this.fZj.baF(), this.fZj.bhb() != null);
                    if (this.fZj.bgX()) {
                        this.fZj.li(false);
                        this.fZl.bgw();
                        this.fZj.Nv();
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
        if (!StringUtils.isNull(str) && this.fZj != null) {
            String bdl = this.fZj.bdl();
            String Lw = this.fZj.Lw();
            sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Lw + "&tid=" + bdl + "&pid=" + str, true)));
        }
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.fZj.isMarked() && postData.getId() != null && postData.getId().equals(this.fZj.bgV())) {
                z = true;
            }
            MarkData h = this.fZj.h(postData);
            if (h != null) {
                this.fZl.bfu();
                if (this.flD != null) {
                    this.flD.a(h);
                    if (!z) {
                        this.flD.vZ();
                    } else {
                        this.flD.vY();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.fZj != null) {
            this.fZj.D(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.eTj != null) {
            this.eTj.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.eTj.Lb().Jl();
        this.eTj.LW();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eTj.b(writeData);
                this.eTj.setVoiceModel(pbEditorData.getVoiceModel());
                r hI = this.eTj.Lb().hI(6);
                if (hI != null && hI.bsj != null) {
                    hI.bsj.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eTj.LS();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dEk != null) {
            this.dEk.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.fZt = true;
        super.onPause();
        if (this.dEk != null) {
            this.dEk.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.ewO);
        this.fZl.axB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fZt = false;
        super.onResume();
        if (this.dEk != null) {
            this.dEk.onResume(getPageContext());
        }
        registerListener(this.ewO);
        this.fZl.axC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dEk != null) {
            this.dEk.onStop(getPageContext());
        }
        this.eTj.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.fZz));
        this.fZj.cancelLoadData();
        this.fZj.destory();
        this.fZk.cancelLoadData();
        if (this.dEk != null) {
            this.dEk.onDestory(getPageContext());
        }
        this.fZl.bfu();
        this.fZl.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.fLN);
        MessageManager.getInstance().unRegisterListener(this.fLO);
        MessageManager.getInstance().unRegisterListener(this.fLP);
        MessageManager.getInstance().unRegisterListener(this.fZv);
        this.fLk = null;
        this.fLl = null;
        if (this.dEU != null) {
            this.dEU.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fZl.onChangeSkinType(i);
        if (this.dEU != null) {
            this.dEU.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dEk;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bgC = this.fZl.bgC();
        if (bgC == null || (findViewWithTag = bgC.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean qB(String str) {
        Map<String, String> ex;
        if (!TextUtils.isEmpty(str) && (ex = aw.ex(aw.ey(str))) != null) {
            this.fZw = true;
            String str2 = ex.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return qB(com.baidu.adp.lib.util.k.aW(str2));
            }
            String str3 = ex.get(fZi);
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
            aw.Dt().c(getPageContext(), new String[]{str});
            this.fZw = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fZw = true;
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
        if (this.fZl != null) {
            return this.fZl.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int RN() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> RP() {
        if (this.bLx == null) {
            this.bLx = TbRichTextView.y(getPageContext().getPageActivity(), 8);
        }
        return this.bLx;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> RQ() {
        if (this.bLB == null) {
            this.bLB = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bcB */
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
        return this.bLB;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> RO() {
        if (this.bLw == null) {
            this.bLw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: ahp */
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
        return this.bLw;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> RR() {
        if (this.bLy == null) {
            this.bLy = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bcC */
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
        return this.bLy;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> RS() {
        if (this.bLz == null) {
            this.bLz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bcE */
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
        return this.bLz;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> RT() {
        this.bLA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bcD */
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
        return this.bLA;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fZl.bgy() && l.pa()) {
            this.fZj.Nv();
        } else {
            this.fZl.bgB();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.fZv);
        userMuteAddAndDelCustomMessage.setTag(this.fZv);
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
            public boolean NL() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int NM() {
                return com.baidu.tbadk.pageStayDuration.e.NQ().NS();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.fZj != null) {
            if (this.fZj.bgO() != null && this.fZj.bgO().bbj() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fZj.bgO().bbj().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fZj.bdl(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.fZt;
    }

    public boolean bgs() {
        if (this.fZj != null) {
            return this.fZj.bgs();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.fZl.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fLk.getPageActivity());
        if (am.isEmpty(str)) {
            aVar.dk(this.fLk.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.dk(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.fZl.showLoadingDialog();
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
        aVar.b(this.fLk).AU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fLk.getPageActivity());
        aVar.dk(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fLk).AU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcw() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dk(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.fLk).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.fLk.getPageActivity(), 2, true, 4);
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
        aVar.b(this.fLk).AU();
    }

    public String getThreadId() {
        if (this.fZj != null) {
            return this.fZj.bdl();
        }
        return null;
    }

    public String getPostId() {
        if (this.fZj != null) {
            return this.fZj.Lw();
        }
        return null;
    }

    public int baF() {
        if (this.fZj != null) {
            return this.fZj.baF();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.bsG) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.bsG) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void ld(boolean z) {
        if (this.fWz != null && this.fWz.getText() != null) {
            int selectionEnd = this.fWz.getSelectionEnd();
            SpannableStringBuilder b = this.fZy.b(this.fWz.getText());
            if (b != null) {
                this.fZy.nB(true);
                this.fWz.setText(b);
                if (z && this.fZy.bFC() >= 0) {
                    this.fWz.requestFocus();
                    this.fWz.setSelection(this.fZy.bFC());
                } else {
                    this.fWz.setSelection(selectionEnd);
                }
                this.fZy.nA(this.fZy.bFC() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.dEU == null) {
            this.dEU = new i(getPageContext());
        }
        this.dEU.a(contriInfo, -1L);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.eTj != null && this.eTj.Lb() != null && this.eTj.Lb().Le()) {
            this.eTj.Lb().Jl();
        } else {
            super.onBackPressed();
        }
    }
}
