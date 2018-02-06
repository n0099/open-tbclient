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
    private static final String fXY = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String fZt = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> bLJ;
    private com.baidu.adp.lib.e.b<TextView> bLK;
    private com.baidu.adp.lib.e.b<View> bLL;
    private com.baidu.adp.lib.e.b<LinearLayout> bLM;
    private com.baidu.adp.lib.e.b<RelativeLayout> bLN;
    private com.baidu.adp.lib.e.b<GifView> bLO;
    private View.OnLongClickListener bmu;
    private VoiceManager dEw;
    private i dFg;
    private h eTv;
    private com.baidu.adp.base.e fLv;
    private com.baidu.tbadk.core.view.e fLw;
    private b.InterfaceC0096b fMm;
    private PostWriteCallBackData fPx;
    private EditText fWK;
    private SubPbModel.a fZA;
    private com.baidu.adp.base.d fZB;
    private BdUniqueId fZG;
    private b fZI;
    private com.baidu.tieba.write.b fZJ;
    private com.baidu.tieba.pb.e<k> fZK;
    private SubPbModel fZu;
    private ForumManageModel fZv;
    private c fZw;
    private AbsListView.OnScrollListener fZx;
    private TbRichTextView.i fZy;
    private TbRichTextView.h fZz;
    private com.baidu.tbadk.baseEditMark.a flP;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int fMj = 0;
    private a.InterfaceC0092a fMf = null;
    private a fZC = null;
    private a fZD = null;
    private boolean fZE = false;
    private boolean fZF = false;
    private boolean fZH = false;
    private boolean bsT = false;
    private com.baidu.tbadk.editortools.pb.c bup = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void LA() {
            NewSubPbActivity.this.fZw.bgB();
        }
    };
    private com.baidu.tbadk.editortools.pb.b buq = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Lz() {
            if (NewSubPbActivity.this.fZJ.bFE()) {
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.fZJ.bFG());
                if (NewSubPbActivity.this.eTv.LO()) {
                    NewSubPbActivity.this.eTv.a(NewSubPbActivity.this.fPx);
                }
                NewSubPbActivity.this.ld(true);
                return true;
            }
            return false;
        }
    };
    private NewWriteModel.d fZL = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.eTv != null && NewSubPbActivity.this.eTv.Lc() != null) {
                NewSubPbActivity.this.eTv.Lc().hide();
                if (NewSubPbActivity.this.fZu.bgV()) {
                    TiebaStatic.log(new ak("c10367").ab("post_id", NewSubPbActivity.this.fZu.Lx()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fZJ.un(null);
                NewSubPbActivity.this.fZJ.aw(null);
                NewSubPbActivity.this.fZJ.nA(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    NewSubPbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fZJ.aw(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fZJ.un(postWriteCallBackData.getErrorString());
                if (!v.E(NewSubPbActivity.this.fZJ.bFC())) {
                    NewSubPbActivity.this.fPx = postWriteCallBackData;
                    if (NewSubPbActivity.this.eTv.LO()) {
                        NewSubPbActivity.this.eTv.a(NewSubPbActivity.this.fPx);
                    }
                    NewSubPbActivity.this.ld(true);
                } else {
                    return;
                }
            }
            NewSubPbActivity.this.fZw.bgC();
        }
    };
    private CustomMessageListener fLY = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fZG) {
                NewSubPbActivity.this.fZw.agg();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fLw.q(NewSubPbActivity.this.fLv.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.fLv.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.gC(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bcx();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (am.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.fLv.getResources().getString(d.j.mute_fail);
                    }
                    NewSubPbActivity.this.fLw.r(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fLZ = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fZG) {
                NewSubPbActivity.this.fZw.agg();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fLw.q(NewSubPbActivity.this.fLv.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (am.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.fLv.getResources().getString(d.j.un_mute_fail);
                }
                NewSubPbActivity.this.fLw.r(muteMessage);
            }
        }
    };
    private CustomMessageListener fMa = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fZG) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.fZw.agg();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.hnI;
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
                    NewSubPbActivity.this.fZw.a(sparseArray, z);
                }
            }
        }
    };
    boolean fMk = false;
    private CustomMessageListener exa = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener dFy = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    com.baidu.tbadk.data.h hVar = (com.baidu.tbadk.data.h) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.fZu.bgP() != null && NewSubPbActivity.this.fZu.bgP().bbd() != null && NewSubPbActivity.this.fZu.bgP().bbd().zn() != null && currentAccount.equals(NewSubPbActivity.this.fZu.bgP().bbd().zn().getUserId()) && NewSubPbActivity.this.fZu.bgP().bbd().zn().getPendantData() != null) {
                        NewSubPbActivity.this.fZu.bgP().bbd().zn().getPendantData().cX(hVar.ya());
                        NewSubPbActivity.this.fZu.bgP().bbd().zn().getPendantData().ab(hVar.KE());
                        NewSubPbActivity.this.fZw.a(NewSubPbActivity.this.fZu.bgP().bbd(), NewSubPbActivity.this.fZu.bgP().aLq(), NewSubPbActivity.this.fZu.bgP().vX(), NewSubPbActivity.this.fZu.baG(), NewSubPbActivity.this.fZu.bhc() != null);
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
        if (this.bsT) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.fLv = getPageContext();
        this.fZF = true;
        this.fZJ = new com.baidu.tieba.write.b();
        this.fZJ.xg(d.C0140d.cp_cont_h_alpha85);
        this.fZJ.xf(d.C0140d.cp_cont_i);
        ayf();
        bgr();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.fZu.bgt()) {
            this.fZI = new b(this, getListView(), this.fZw.avk());
            this.fZI.ayk();
            this.fZI.a(new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                private boolean dPK = false;

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void ayg() {
                    NewSubPbActivity.this.fZw.gj(false);
                    this.dPK = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void ayh() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public boolean ayi() {
                    if (!this.dPK) {
                        return NewSubPbActivity.this.fZw.ayw() != null && NewSubPbActivity.this.fZw.ayw().getTop() == 0;
                    }
                    this.dPK = false;
                    return false;
                }
            });
            this.fZw.e(this.fZI);
            this.fZw.gj(true);
        }
        this.fLw = new com.baidu.tbadk.core.view.e();
        this.fLw.bbh = 1000L;
        registerListener(this.fMa);
        registerListener(this.fLY);
        registerListener(this.fLZ);
        this.fZG = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fZG;
        userMuteAddAndDelCustomMessage.setTag(this.fZG);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fZG;
        userMuteCheckCustomMessage.setTag(this.fZG);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.fZw = new c(this, this.mCommonClickListener);
        this.fZw.a(this.fZu);
        addContentView(this.fZw.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.fZw.setOnScrollListener(this.fZx);
        this.fZw.a(this);
        this.fZw.setOnLinkImageClickListener(this.fZy);
        this.fZw.setOnImageClickListener(this.fZz);
        this.fZw.jP(true);
        this.fZw.setOnLongClickListener(this.bmu);
        this.fZw.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.fZu != null) {
                    NewSubPbActivity.this.fZu.Nw();
                }
            }
        });
        this.fZw.a(this.fZC);
        this.fZw.b(this.fZD);
        if (this.fZu != null && this.fZu.bgt() && !this.fZu.bhb()) {
            this.fZw.bgG().setVisibility(8);
        } else {
            this.fZw.bgG().setVisibility(0);
        }
        if (this.fZu != null && !this.fZu.bgt()) {
            this.fZw.setIsFromPb(false);
        }
    }

    private boolean E(Bundle bundle) {
        if (bundle != null) {
            this.bsT = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.bsT = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.bsT;
    }

    public void initData(Bundle bundle) {
        this.fZu = new SubPbModel(getPageContext());
        this.fZu.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.fZw.n(postData);
                NewSubPbActivity.this.fZw.a((BdListView.e) null);
            }
        });
        this.fZv = new ForumManageModel(this);
        this.fZv.setLoadDataCallBack(this.fZB);
        this.dEw = new VoiceManager();
        this.dEw.onCreate(getPageContext());
        this.flP = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.flP != null) {
            this.flP.a(this.fMf);
        }
        if (bundle != null) {
            this.fZu.initWithBundle(bundle);
        } else {
            this.fZu.initWithIntent(getIntent());
        }
        this.fZu.a(this.fZA);
        if (this.fZu.bgt()) {
            this.fZu.Nw();
        } else {
            this.fZu.bgU();
        }
    }

    public void bgr() {
        this.fZA = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, k kVar) {
                if (NewSubPbActivity.this.fZw != null) {
                    NewSubPbActivity.this.fZw.bgC();
                }
                if (NewSubPbActivity.this.fZI != null && NewSubPbActivity.this.fZI.ayl()) {
                    NewSubPbActivity.this.fZI.nx(d.C0140d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.ab(i, str);
                    return;
                }
                NewSubPbActivity.this.fZw.hideNoDataView();
                if (kVar != null) {
                    if (kVar.bbd() != null || NewSubPbActivity.this.fZu != null) {
                        kVar.bbd().a(NewSubPbActivity.this.fZu.bha());
                    }
                    if (NewSubPbActivity.this.fZw != null) {
                        NewSubPbActivity.this.fZw.a(kVar, NewSubPbActivity.this.fZu.baG(), NewSubPbActivity.this.fZu.bhc() != null);
                        if (NewSubPbActivity.this.fZF) {
                            NewSubPbActivity.this.bgs();
                            NewSubPbActivity.this.fZF = false;
                        }
                    }
                    if (NewSubPbActivity.this.eTv != null) {
                        NewSubPbActivity.this.eTv.a(kVar.bbl());
                    }
                    if (NewSubPbActivity.this.fZK == null) {
                        NewSubPbActivity.this.fZK = new com.baidu.tieba.pb.e();
                    }
                    NewSubPbActivity.this.fZK.setData(kVar);
                    NewSubPbActivity.this.fZK.setType(0);
                }
            }
        };
        this.fMf = new a.InterfaceC0092a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0092a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.flP != null) {
                        NewSubPbActivity.this.flP.aL(z2);
                    }
                    MarkData wa = NewSubPbActivity.this.flP.wa();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(wa);
                        if (NewSubPbActivity.this.flP != null) {
                            if (wa != null) {
                                NewSubPbActivity.this.fZu.lh(true);
                                NewSubPbActivity.this.fZu.qM(NewSubPbActivity.this.fZu.Lx());
                                NewSubPbActivity.this.showToast(d.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.add_mark));
                            }
                            if (NewSubPbActivity.this.fZw != null) {
                                NewSubPbActivity.this.fZw.le(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.fZu.lh(false);
                        NewSubPbActivity.this.fZu.qM(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.remove_mark));
                        if (NewSubPbActivity.this.fZw != null) {
                            NewSubPbActivity.this.fZw.le(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.update_mark_failed));
            }
        };
        this.fZC = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void ak(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.fZu.bgP() != null && NewSubPbActivity.this.fZu.bgP().WE() != null && NewSubPbActivity.this.fZu.bgP().WE().zn() != null) {
                    str = String.valueOf(NewSubPbActivity.this.fZu.bgP().WE().zn().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.fZu.bgP().bbk().getId(), NewSubPbActivity.this.fZu.bgP().bbk().getName(), NewSubPbActivity.this.fZu.bgP().WE().getId(), str, str2, str3)));
            }
        };
        this.fZD = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void ak(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.fZv.bxG() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int h = com.baidu.adp.lib.g.b.h(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int h2 = com.baidu.adp.lib.g.b.h(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.fZu != null && NewSubPbActivity.this.fZu.bgP() != null && NewSubPbActivity.this.fZu.bgP().bbk() != null && NewSubPbActivity.this.fZu.bgP().WE() != null) {
                            NewSubPbActivity.this.fZv.a(NewSubPbActivity.this.fZu.bgP().bbk().getId(), NewSubPbActivity.this.fZu.bgP().bbk().getName(), NewSubPbActivity.this.fZu.bgP().WE().getId(), valueOf, h2, h, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.j.login_to_use), true, 11017)));
            }
        };
        this.fZB = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.fZw.a(NewSubPbActivity.this.fZv.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.fZv.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.gaw != 1002 || bVar.ecK) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.fZw.a(1, dVar.aou, dVar.hdk, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void ayf() {
        registerListener(this.dFy);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.fZw != null) {
                    if (view == NewSubPbActivity.this.fZw.bgM()) {
                        NewSubPbActivity.this.fZw.bfv();
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
                    } else if (view != NewSubPbActivity.this.fZw.ayx()) {
                        if (view != NewSubPbActivity.this.fZw.bgF()) {
                            if (view != NewSubPbActivity.this.fZw.bgE()) {
                                if (view == NewSubPbActivity.this.fZw.bgA()) {
                                    NewSubPbActivity.this.fZw.bfv();
                                    if (NewSubPbActivity.this.fZu.Nw()) {
                                        NewSubPbActivity.this.fZw.bgy();
                                    }
                                } else if (view == NewSubPbActivity.this.fZw.bgG() || view == NewSubPbActivity.this.fZw.bgH() || view == NewSubPbActivity.this.fZw.bgJ()) {
                                    if (NewSubPbActivity.this.fZH) {
                                        NewSubPbActivity.this.fZH = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.fZu.bdm(), NewSubPbActivity.this.fZu.Lx(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.fZu.bhf())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.fZu.bhf());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.fZw.bgK() == null || view != NewSubPbActivity.this.fZw.bgK().bdY()) {
                                    if (NewSubPbActivity.this.fZw.bgK() == null || view != NewSubPbActivity.this.fZw.bgK().bed()) {
                                        if (NewSubPbActivity.this.fZw.bgK() == null || view != NewSubPbActivity.this.fZw.bgK().beb()) {
                                            if (NewSubPbActivity.this.fZw.bgK() == null || view != NewSubPbActivity.this.fZw.bgK().bdZ()) {
                                                if (NewSubPbActivity.this.fZw.bgK() == null || view != NewSubPbActivity.this.fZw.bgK().bea()) {
                                                    if ((view == NewSubPbActivity.this.fZw.bgD() || view == NewSubPbActivity.this.fZw.bgJ()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.eTv.LW()) {
                                                            NewSubPbActivity.this.eTv.LX();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.eTv.gD(null);
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
                                                NewSubPbActivity.this.fZw.bfv();
                                                if (tag instanceof String) {
                                                    String Lx = NewSubPbActivity.this.fZu.Lx();
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
                                                NewSubPbActivity.this.fZw.bfv();
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
                                        NewSubPbActivity.this.fZw.bfv();
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.fZw.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new ak("c11739").s("obj_locate", 1));
                                    NewSubPbActivity.this.fZw.bfv();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.eTv.gD(null);
                                        if (NewSubPbActivity.this.fZI != null) {
                                            NewSubPbActivity.this.fZI.ayj();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new ak("c11739").s("obj_locate", 2));
                                    NewSubPbActivity.this.fZw.bfv();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.fZu.bgP() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.fZu.bgP().bbd());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.fZw.bgv();
                                NewSubPbActivity.this.fZw.bgw();
                                if (NewSubPbActivity.this.eTv != null) {
                                    NewSubPbActivity.this.eTv.LZ();
                                    if (NewSubPbActivity.this.fZI != null) {
                                        NewSubPbActivity.this.fZI.ayj();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.fZw.bgv();
                            NewSubPbActivity.this.fZw.bgw();
                            if (NewSubPbActivity.this.eTv != null) {
                                NewSubPbActivity.this.eTv.LY();
                                if (NewSubPbActivity.this.fZI != null) {
                                    NewSubPbActivity.this.fZI.ayj();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.eTv.LO()) {
                            NewSubPbActivity.this.eTv.a((PostWriteCallBackData) null);
                            return;
                        }
                        NewSubPbActivity.this.fZw.bgv();
                        NewSubPbActivity.this.fZw.bgw();
                        if (NewSubPbActivity.this.eTv != null) {
                            NewSubPbActivity.this.eTv.Ma();
                            if (NewSubPbActivity.this.fZI != null) {
                                NewSubPbActivity.this.fZI.ayj();
                            }
                        }
                    }
                }
            }
        };
        this.fZx = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.fZw.bfv();
                }
                NewSubPbActivity.this.eTv.LX();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.fZw.bgL();
            }
        };
        this.fMm = new b.InterfaceC0096b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.fZu.bgP() != null) {
                    postData = NewSubPbActivity.this.fZu.bgP().bbd();
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
        this.bmu = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                    NewSubPbActivity.this.fZw.b(NewSubPbActivity.this.fMm, NewSubPbActivity.this.fZu.isMarked());
                }
                return true;
            }
        };
        this.fZy = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void b(View view, String str) {
                NewSubPbActivity.this.k(null, str, "LINK_IMAGE");
            }
        };
        this.fZz = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
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
                    k bgP = NewSubPbActivity.this.fZu.bgP();
                    TbRichText az = NewSubPbActivity.this.az(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (az != null && az.Ri() != null) {
                        tbRichTextData = az.Ri().get(NewSubPbActivity.this.fMj);
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
                            if (NewSubPbActivity.this.fZu.bhc() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.fZu.bhc();
                                z5 = NewSubPbActivity.this.fZu.bhe();
                                arrayList2 = NewSubPbActivity.this.fZu.bhd();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z5 = z4;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(v.f(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.fMk = false;
                        String str7 = "";
                        TbRichText bwX = bgP.bbd().bwX();
                        int size = arrayList2.size();
                        int a2 = NewSubPbActivity.this.a(bwX, az, i, i, arrayList2, concurrentHashMap3);
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
                        if (NewSubPbActivity.this.fZu.bhc() != null) {
                            concurrentHashMap = NewSubPbActivity.this.fZu.bhc();
                            z3 = NewSubPbActivity.this.fZu.bhe();
                            arrayList = NewSubPbActivity.this.fZu.bhd();
                            i2 = a2 + NewSubPbActivity.this.fZu.getOffset();
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
            this.fMk = true;
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
                        if (!this.fMk) {
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
        if (this.fZu == null || this.fZu.bgP() == null || str == null || i < 0) {
            return null;
        }
        k bgP = this.fZu.bgP();
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
        TbRichText bwX = postData.bwX();
        if (bwX != null) {
            ArrayList<TbRichTextData> Ri = bwX.Ri();
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
                        this.fMj = i3;
                        return bwX;
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
        long templateId = this.fZu.bgP().bbd().bxe() != null ? this.fZu.bgP().bbd().bxe().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && aw.Du().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.fZu.bgP().bbk().getId(), this.fZu.bgP().bbk().getName(), this.fZu.bgP().WE().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, String str) {
        if (this.fZu.bgQ()) {
            showToast(str);
        } else if (l.pa()) {
            if (i == 4) {
                this.fZw.lS(str + "(4)");
            } else {
                this.fZw.lc(d.j.no_data_text);
            }
        } else {
            this.fZw.lc(d.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.eTv = (h) new com.baidu.tbadk.editortools.pb.i().bd(getActivity());
        if (this.eTv != null) {
            this.eTv.setContext(getPageContext());
            this.eTv.b(this.fZu);
            this.eTv.b(this.fZL);
            this.eTv.a(this.bup);
            this.eTv.a(this.buq);
            this.eTv.Lc().cf(true);
            this.eTv.d(getPageContext());
        }
        if (this.fZw != null) {
            this.fZw.g(this.eTv);
        }
        if (this.eTv != null && this.fZu != null) {
            this.eTv.a(this.fZu.bbl());
            this.eTv.LX();
        }
        if (this.eTv != null) {
            this.fWK = this.eTv.Mb().getInputView();
            this.fWK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.fZJ != null) {
                        if (!NewSubPbActivity.this.fZJ.bFF()) {
                            NewSubPbActivity.this.ld(false);
                        }
                        NewSubPbActivity.this.fZJ.nB(false);
                    }
                }
            });
        }
    }

    public void bgs() {
        if (!TbadkCoreApplication.isLogin()) {
            this.eTv.LX();
        } else if (!StringUtils.isNull(this.fZu.bgX())) {
            this.fZw.qI(this.fZu.bgX());
            if (this.fZw.bgz() && l.pa()) {
                this.fZw.asv();
            } else {
                this.fZw.bgC();
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
                    this.fZw.cy(view);
                }
            } else if (booleanValue2) {
                this.fZw.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            g.a(this.fZw.bgI(), getPageContext().getPageActivity());
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
        bVar.a(strArr, new b.InterfaceC0096b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                switch (i) {
                    case 0:
                        String str2 = "";
                        int intValue = sparseArray.get(d.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue() : 0;
                        if (sparseArray.get(d.g.tag_del_post_id) instanceof String) {
                            str2 = (String) sparseArray.get(d.g.tag_del_post_id);
                        }
                        NewSubPbActivity.this.fZw.a(intValue, str2, sparseArray.get(d.g.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue() : false);
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
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.fZG);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.fZG);
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
        this.fZw.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.fZG;
        userMuteCheckCustomMessage.setTag(this.fZG);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.fZw.a(0, bVar.aou, bVar.hdk, z);
            if (bVar.aou) {
                if (bVar.hdi == 1) {
                    finish();
                } else if (bVar.hdi == 2) {
                    this.fZu.qL(bVar.mPostId);
                    this.fZw.a(this.fZu.bgP(), this.fZu.baG(), this.fZu.bhc() != null);
                    if (this.fZu.bgY()) {
                        this.fZu.li(false);
                        this.fZw.bgx();
                        this.fZu.Nw();
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
        if (!StringUtils.isNull(str) && this.fZu != null) {
            String bdm = this.fZu.bdm();
            String Lx = this.fZu.Lx();
            sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Lx + "&tid=" + bdm + "&pid=" + str, true)));
        }
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.fZu.isMarked() && postData.getId() != null && postData.getId().equals(this.fZu.bgW())) {
                z = true;
            }
            MarkData h = this.fZu.h(postData);
            if (h != null) {
                this.fZw.bfv();
                if (this.flP != null) {
                    this.flP.a(h);
                    if (!z) {
                        this.flP.vZ();
                    } else {
                        this.flP.vY();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.fZu != null) {
            this.fZu.D(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.eTv != null) {
            this.eTv.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.eTv.Lc().Jm();
        this.eTv.LX();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eTv.b(writeData);
                this.eTv.setVoiceModel(pbEditorData.getVoiceModel());
                r hI = this.eTv.Lc().hI(6);
                if (hI != null && hI.bsw != null) {
                    hI.bsw.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eTv.LT();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dEw != null) {
            this.dEw.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.fZE = true;
        super.onPause();
        if (this.dEw != null) {
            this.dEw.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.exa);
        this.fZw.axC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fZE = false;
        super.onResume();
        if (this.dEw != null) {
            this.dEw.onResume(getPageContext());
        }
        registerListener(this.exa);
        this.fZw.axD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dEw != null) {
            this.dEw.onStop(getPageContext());
        }
        this.eTv.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.fZK));
        this.fZu.cancelLoadData();
        this.fZu.destory();
        this.fZv.cancelLoadData();
        if (this.dEw != null) {
            this.dEw.onDestory(getPageContext());
        }
        this.fZw.bfv();
        this.fZw.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.fLY);
        MessageManager.getInstance().unRegisterListener(this.fLZ);
        MessageManager.getInstance().unRegisterListener(this.fMa);
        MessageManager.getInstance().unRegisterListener(this.fZG);
        this.fLv = null;
        this.fLw = null;
        if (this.dFg != null) {
            this.dFg.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fZw.onChangeSkinType(i);
        if (this.dFg != null) {
            this.dFg.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dEw;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bgD = this.fZw.bgD();
        if (bgD == null || (findViewWithTag = bgD.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean qB(String str) {
        Map<String, String> ex;
        if (!TextUtils.isEmpty(str) && (ex = aw.ex(aw.ey(str))) != null) {
            this.fZH = true;
            String str2 = ex.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return qB(com.baidu.adp.lib.util.k.aW(str2));
            }
            String str3 = ex.get(fZt);
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
            this.fZH = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fZH = true;
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
        if (this.fZw != null) {
            return this.fZw.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int RO() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> RQ() {
        if (this.bLK == null) {
            this.bLK = TbRichTextView.y(getPageContext().getPageActivity(), 8);
        }
        return this.bLK;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> RR() {
        if (this.bLO == null) {
            this.bLO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
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
        return this.bLO;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> RP() {
        if (this.bLJ == null) {
            this.bLJ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: ahq */
                public ImageView nl() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean xu = com.baidu.tbadk.core.i.xo().xu();
                    foreDrawableImageView.setDefaultBg(aj.getDrawable(d.C0140d.common_color_10220));
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
                        foreDrawableImageView.setDefaultBgResource(d.C0140d.cp_bg_line_c);
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
                        foreDrawableImageView.setDefaultBgResource(d.C0140d.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.bLJ;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> RS() {
        if (this.bLL == null) {
            this.bLL = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
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
        return this.bLL;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> RT() {
        if (this.bLM == null) {
            this.bLM = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
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
        return this.bLM;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> RU() {
        this.bLN = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
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
        return this.bLN;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fZw.bgz() && l.pa()) {
            this.fZu.Nw();
        } else {
            this.fZw.bgC();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.fZG);
        userMuteAddAndDelCustomMessage.setTag(this.fZG);
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
        if (pageStayDurationItem != null && this.fZu != null) {
            if (this.fZu.bgP() != null && this.fZu.bgP().bbk() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fZu.bgP().bbk().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fZu.bdm(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.fZE;
    }

    public boolean bgt() {
        if (this.fZu != null) {
            return this.fZu.bgt();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.fZw.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fLv.getPageActivity());
        if (am.isEmpty(str)) {
            aVar.dk(this.fLv.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.dk(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.fZw.showLoadingDialog();
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
        aVar.b(this.fLv).AU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fLv.getPageActivity());
        aVar.dk(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fLv).AU();
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
                    ((TbPageContext) NewSubPbActivity.this.fLv).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.fLv.getPageActivity(), 2, true, 4);
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
        aVar.b(this.fLv).AU();
    }

    public String getThreadId() {
        if (this.fZu != null) {
            return this.fZu.bdm();
        }
        return null;
    }

    public String getPostId() {
        if (this.fZu != null) {
            return this.fZu.Lx();
        }
        return null;
    }

    public int baG() {
        if (this.fZu != null) {
            return this.fZu.baG();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.bsT) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.bsT) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void ld(boolean z) {
        if (this.fWK != null && this.fWK.getText() != null) {
            int selectionEnd = this.fWK.getSelectionEnd();
            SpannableStringBuilder b = this.fZJ.b(this.fWK.getText());
            if (b != null) {
                this.fZJ.nB(true);
                this.fWK.setText(b);
                if (z && this.fZJ.bFD() >= 0) {
                    this.fWK.requestFocus();
                    this.fWK.setSelection(this.fZJ.bFD());
                } else {
                    this.fWK.setSelection(selectionEnd);
                }
                this.fZJ.nA(this.fZJ.bFD() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.dFg == null) {
            this.dFg = new i(getPageContext());
        }
        this.dFg.a(contriInfo, -1L);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.eTv != null && this.eTv.Lc() != null && this.eTv.Lc().Lf()) {
            this.eTv.Lc().Jm();
        } else {
            super.onBackPressed();
        }
    }
}
