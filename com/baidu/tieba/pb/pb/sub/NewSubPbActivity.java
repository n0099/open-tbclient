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
import com.baidu.adp.lib.util.k;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.h;
import com.baidu.tbadk.editortools.pb.i;
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
import com.baidu.tieba.pb.data.m;
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
    private static final String fUr = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String fVQ = "tbgametype";
    private com.baidu.adp.lib.e.b<RelativeLayout> bJA;
    private com.baidu.adp.lib.e.b<GifView> bJB;
    private com.baidu.adp.lib.e.b<ImageView> bJw;
    private com.baidu.adp.lib.e.b<TextView> bJx;
    private com.baidu.adp.lib.e.b<View> bJy;
    private com.baidu.adp.lib.e.b<LinearLayout> bJz;
    private View.OnLongClickListener bjX;
    private VoiceManager dBh;
    private h eOI;
    private com.baidu.adp.base.e fHR;
    private com.baidu.tbadk.core.view.e fHS;
    private b.InterfaceC0073b fIH;
    private PostWriteCallBackData fLT;
    private EditText fTd;
    private SubPbModel fVR;
    private ForumManageModel fVS;
    private c fVT;
    private AbsListView.OnScrollListener fVU;
    private TbRichTextView.i fVV;
    private TbRichTextView.h fVW;
    private SubPbModel.a fVX;
    private com.baidu.adp.base.d fVY;
    private BdUniqueId fWd;
    private b fWf;
    private com.baidu.tieba.write.b fWg;
    private com.baidu.tieba.pb.e<m> fWh;
    private com.baidu.tbadk.baseEditMark.a fhR;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int fIE = 0;
    private a.InterfaceC0069a fIA = null;
    private a fVZ = null;
    private a fWa = null;
    private boolean fWb = false;
    private boolean fWc = false;
    private boolean fWe = false;
    private boolean bqx = false;
    private com.baidu.tbadk.editortools.pb.c brR = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void KR() {
            NewSubPbActivity.this.fVT.beW();
        }
    };
    private com.baidu.tbadk.editortools.pb.b brS = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean KQ() {
            if (NewSubPbActivity.this.fWg.bEO()) {
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.fWg.bEQ());
                if (NewSubPbActivity.this.eOI.Lg()) {
                    NewSubPbActivity.this.eOI.a(NewSubPbActivity.this.fLT);
                }
                NewSubPbActivity.this.kS(true);
                return true;
            }
            return false;
        }
    };
    private NewWriteModel.d fWi = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.eOI != null && NewSubPbActivity.this.eOI.Ku() != null) {
                NewSubPbActivity.this.eOI.Ku().hide();
                if (NewSubPbActivity.this.fVR.bfq()) {
                    TiebaStatic.log(new ak("c10367").ab("post_id", NewSubPbActivity.this.fVR.KO()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fWg.tZ(null);
                NewSubPbActivity.this.fWg.av(null);
                NewSubPbActivity.this.fWg.nq(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fWg.av(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fWg.tZ(postWriteCallBackData.getErrorString());
                if (!v.E(NewSubPbActivity.this.fWg.bEM())) {
                    NewSubPbActivity.this.fLT = postWriteCallBackData;
                    if (NewSubPbActivity.this.eOI.Lg()) {
                        NewSubPbActivity.this.eOI.a(NewSubPbActivity.this.fLT);
                    }
                    NewSubPbActivity.this.kS(true);
                } else {
                    return;
                }
            }
            NewSubPbActivity.this.fVT.beX();
        }
    };
    private CustomMessageListener fIt = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fWd) {
                NewSubPbActivity.this.fVT.aeY();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fHS.q(NewSubPbActivity.this.fHR.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.fHR.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.gk(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.baQ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (am.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.fHR.getResources().getString(d.j.mute_fail);
                    }
                    NewSubPbActivity.this.fHS.r(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fIu = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fWd) {
                NewSubPbActivity.this.fVT.aeY();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fHS.q(NewSubPbActivity.this.fHR.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (am.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.fHR.getResources().getString(d.j.un_mute_fail);
                }
                NewSubPbActivity.this.fHS.r(muteMessage);
            }
        }
    };
    private CustomMessageListener fIv = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fWd) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.fVT.aeY();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.hlZ;
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
                    NewSubPbActivity.this.fVT.a(sparseArray, z);
                }
            }
        }
    };
    boolean fIF = false;
    private CustomMessageListener esv = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener dCf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    com.baidu.tbadk.data.h hVar = (com.baidu.tbadk.data.h) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.fVR.bfk() != null && NewSubPbActivity.this.fVR.bfk().aZt() != null && NewSubPbActivity.this.fVR.bfk().aZt().yS() != null && currentAccount.equals(NewSubPbActivity.this.fVR.bfk().aZt().yS().getUserId()) && NewSubPbActivity.this.fVR.bfk().aZt().yS().getPendantData() != null) {
                        NewSubPbActivity.this.fVR.bfk().aZt().yS().getPendantData().cM(hVar.xt());
                        NewSubPbActivity.this.fVR.bfk().aZt().yS().getPendantData().ab(hVar.JW());
                        NewSubPbActivity.this.fVT.a(NewSubPbActivity.this.fVR.bfk().aZt(), NewSubPbActivity.this.fVR.bfk().aJJ(), NewSubPbActivity.this.fVR.bfk().vk(), NewSubPbActivity.this.fVR.aYS(), NewSubPbActivity.this.fVR.bfx() != null);
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
        y(bundle);
        if (this.bqx) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.fHR = getPageContext();
        this.fWc = true;
        this.fWg = new com.baidu.tieba.write.b();
        this.fWg.xh(d.C0107d.cp_cont_h_alpha85);
        this.fWg.xg(d.C0107d.cp_cont_i);
        axc();
        beM();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.fVR.beO()) {
            this.fWf = new b(this, getListView(), this.fVT.aup());
            this.fWf.axh();
            this.fWf.a(new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                private boolean dMr = false;

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void axd() {
                    NewSubPbActivity.this.fVT.fZ(false);
                    this.dMr = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void axe() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public boolean axf() {
                    if (!this.dMr) {
                        return NewSubPbActivity.this.fVT.axt() != null && NewSubPbActivity.this.fVT.axt().getTop() == 0;
                    }
                    this.dMr = false;
                    return false;
                }
            });
            this.fVT.e(this.fWf);
            this.fVT.fZ(true);
        }
        this.fHS = new com.baidu.tbadk.core.view.e();
        this.fHS.aZo = 1000L;
        registerListener(this.fIv);
        registerListener(this.fIt);
        registerListener(this.fIu);
        this.fWd = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fWd;
        userMuteAddAndDelCustomMessage.setTag(this.fWd);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.fWd;
        userMuteCheckCustomMessage.setTag(this.fWd);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.fVT = new c(this, this.mCommonClickListener);
        this.fVT.a(this.fVR);
        addContentView(this.fVT.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.fVT.setOnScrollListener(this.fVU);
        this.fVT.a(this);
        this.fVT.setOnLinkImageClickListener(this.fVV);
        this.fVT.setOnImageClickListener(this.fVW);
        this.fVT.jD(true);
        this.fVT.setOnLongClickListener(this.bjX);
        this.fVT.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.fVR != null) {
                    NewSubPbActivity.this.fVR.MO();
                }
            }
        });
        this.fVT.a(this.fVZ);
        this.fVT.b(this.fWa);
        if (this.fVR != null && this.fVR.beO() && !this.fVR.bfw()) {
            this.fVT.bfb().setVisibility(8);
        } else {
            this.fVT.bfb().setVisibility(0);
        }
        if (this.fVR != null && !this.fVR.beO()) {
            this.fVT.setIsFromPb(false);
        }
    }

    private boolean y(Bundle bundle) {
        if (bundle != null) {
            this.bqx = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.bqx = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.bqx;
    }

    public void initData(Bundle bundle) {
        this.fVR = new SubPbModel(getPageContext());
        this.fVR.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.fVT.n(postData);
                NewSubPbActivity.this.fVT.a((BdListView.e) null);
            }
        });
        this.fVS = new ForumManageModel(this);
        this.fVS.setLoadDataCallBack(this.fVY);
        this.dBh = new VoiceManager();
        this.dBh.onCreate(getPageContext());
        this.fhR = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fhR != null) {
            this.fhR.a(this.fIA);
        }
        if (bundle != null) {
            this.fVR.initWithBundle(bundle);
        } else {
            this.fVR.initWithIntent(getIntent());
        }
        this.fVR.a(this.fVX);
        if (this.fVR.beO()) {
            this.fVR.MO();
        } else {
            this.fVR.bfp();
        }
    }

    public void beM() {
        this.fVX = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, m mVar) {
                if (NewSubPbActivity.this.fVT != null) {
                    NewSubPbActivity.this.fVT.beX();
                }
                if (NewSubPbActivity.this.fWf != null && NewSubPbActivity.this.fWf.axi()) {
                    NewSubPbActivity.this.fWf.nz(d.C0107d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.Z(i, str);
                    return;
                }
                NewSubPbActivity.this.fVT.hideNoDataView();
                if (mVar != null) {
                    if (mVar.aZt() != null || NewSubPbActivity.this.fVR != null) {
                        mVar.aZt().a(NewSubPbActivity.this.fVR.bfv());
                    }
                    if (NewSubPbActivity.this.fVT != null) {
                        NewSubPbActivity.this.fVT.a(mVar, NewSubPbActivity.this.fVR.aYS(), NewSubPbActivity.this.fVR.bfx() != null);
                        if (NewSubPbActivity.this.fWc) {
                            NewSubPbActivity.this.beN();
                            NewSubPbActivity.this.fWc = false;
                        }
                    }
                    if (NewSubPbActivity.this.eOI != null) {
                        NewSubPbActivity.this.eOI.a(mVar.aZB());
                    }
                    if (NewSubPbActivity.this.fWh == null) {
                        NewSubPbActivity.this.fWh = new com.baidu.tieba.pb.e();
                    }
                    NewSubPbActivity.this.fWh.setData(mVar);
                    NewSubPbActivity.this.fWh.setType(0);
                }
            }
        };
        this.fIA = new a.InterfaceC0069a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0069a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.fhR != null) {
                        NewSubPbActivity.this.fhR.aH(z2);
                    }
                    MarkData vn = NewSubPbActivity.this.fhR.vn();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(vn);
                        if (NewSubPbActivity.this.fhR != null) {
                            if (vn != null) {
                                NewSubPbActivity.this.fVR.kW(true);
                                NewSubPbActivity.this.fVR.qw(NewSubPbActivity.this.fVR.KO());
                                NewSubPbActivity.this.showToast(d.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.add_mark));
                            }
                            if (NewSubPbActivity.this.fVT != null) {
                                NewSubPbActivity.this.fVT.kT(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.fVR.kW(false);
                        NewSubPbActivity.this.fVR.qw(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.remove_mark));
                        if (NewSubPbActivity.this.fVT != null) {
                            NewSubPbActivity.this.fVT.kT(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.update_mark_failed));
            }
        };
        this.fVZ = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void ak(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.fVR.bfk() != null && NewSubPbActivity.this.fVR.bfk().VK() != null && NewSubPbActivity.this.fVR.bfk().VK().yS() != null) {
                    str = String.valueOf(NewSubPbActivity.this.fVR.bfk().VK().yS().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.fVR.bfk().aZA().getId(), NewSubPbActivity.this.fVR.bfk().aZA().getName(), NewSubPbActivity.this.fVR.bfk().VK().getId(), str, str2, str3)));
            }
        };
        this.fWa = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void ak(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.fVS.bwv() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int h = com.baidu.adp.lib.g.b.h(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int h2 = com.baidu.adp.lib.g.b.h(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.fVR != null && NewSubPbActivity.this.fVR.bfk() != null && NewSubPbActivity.this.fVR.bfk().aZA() != null && NewSubPbActivity.this.fVR.bfk().VK() != null) {
                            NewSubPbActivity.this.fVS.a(NewSubPbActivity.this.fVR.bfk().aZA().getId(), NewSubPbActivity.this.fVR.bfk().aZA().getName(), NewSubPbActivity.this.fVR.bfk().VK().getId(), valueOf, h2, h, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.j.login_to_use), true, 11017)));
            }
        };
        this.fVY = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                boolean z = true;
                if (obj == null) {
                    NewSubPbActivity.this.fVT.a(NewSubPbActivity.this.fVS.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.fVS.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.dYd && bVar.fWT > 0 && bVar.haA != 1 && bVar.fWT != 1002) {
                            com.baidu.tieba.c.a.a(NewSubPbActivity.this.getPageContext(), 3, 1);
                            z = false;
                        }
                        if (bVar.fWT == 1002 && !bVar.dYd) {
                            z = false;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.fVT.a(1, dVar.aos, dVar.haC, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void axc() {
        registerListener(this.dCf);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.fVT != null) {
                    if (view == NewSubPbActivity.this.fVT.bfh()) {
                        NewSubPbActivity.this.fVT.bdO();
                        String str = view.getTag(d.g.tag_user_id) instanceof String ? (String) view.getTag(d.g.tag_user_id) : null;
                        String str2 = view.getTag(d.g.tag_user_name) instanceof String ? (String) view.getTag(d.g.tag_user_name) : null;
                        String str3 = view.getTag(d.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(d.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                av.CZ().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.fVT.axu()) {
                        if (view != NewSubPbActivity.this.fVT.bfa()) {
                            if (view != NewSubPbActivity.this.fVT.beZ()) {
                                if (view == NewSubPbActivity.this.fVT.beV()) {
                                    NewSubPbActivity.this.fVT.bdO();
                                    if (NewSubPbActivity.this.fVR.MO()) {
                                        NewSubPbActivity.this.fVT.beT();
                                    }
                                } else if (view == NewSubPbActivity.this.fVT.bfb() || view == NewSubPbActivity.this.fVT.bfc() || view == NewSubPbActivity.this.fVT.bfe()) {
                                    if (NewSubPbActivity.this.fWe) {
                                        NewSubPbActivity.this.fWe = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.fVR.bbF(), NewSubPbActivity.this.fVR.KO(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.fVR.bfA())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.fVR.bfA());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                } else if (NewSubPbActivity.this.fVT.bff() == null || view != NewSubPbActivity.this.fVT.bff().bcr()) {
                                    if (NewSubPbActivity.this.fVT.bff() == null || view != NewSubPbActivity.this.fVT.bff().bcw()) {
                                        if (NewSubPbActivity.this.fVT.bff() == null || view != NewSubPbActivity.this.fVT.bff().bcu()) {
                                            if (NewSubPbActivity.this.fVT.bff() == null || view != NewSubPbActivity.this.fVT.bff().bcs()) {
                                                if (NewSubPbActivity.this.fVT.bff() == null || view != NewSubPbActivity.this.fVT.bff().bct()) {
                                                    if ((view == NewSubPbActivity.this.fVT.beY() || view == NewSubPbActivity.this.fVT.bfe()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.eOI.Lo()) {
                                                            NewSubPbActivity.this.eOI.Lp();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.eOI.gl(null);
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                                TiebaStatic.log(new ak("c11739").s("obj_locate", 4));
                                                if (!j.oI()) {
                                                    NewSubPbActivity.this.showToast(d.j.network_not_available);
                                                    return;
                                                }
                                                Object tag = view.getTag();
                                                NewSubPbActivity.this.fVT.bdO();
                                                if (tag instanceof String) {
                                                    String KO = NewSubPbActivity.this.fVR.KO();
                                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                        NewSubPbActivity.this.pW(KO);
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
                                            } else if (j.oI()) {
                                                NewSubPbActivity.this.fVT.bdO();
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.cD(view);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                NewSubPbActivity.this.showToast(d.j.network_not_available);
                                                return;
                                            }
                                        }
                                        NewSubPbActivity.this.fVT.bdO();
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.fVT.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new ak("c11739").s("obj_locate", 1));
                                    NewSubPbActivity.this.fVT.bdO();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.eOI.gl(null);
                                        if (NewSubPbActivity.this.fWf != null) {
                                            NewSubPbActivity.this.fWf.axg();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new ak("c11739").s("obj_locate", 2));
                                    NewSubPbActivity.this.fVT.bdO();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.fVR.bfk() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.fVR.bfk().aZt());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.fVT.beQ();
                                NewSubPbActivity.this.fVT.beR();
                                if (NewSubPbActivity.this.eOI != null) {
                                    NewSubPbActivity.this.eOI.Lr();
                                    if (NewSubPbActivity.this.fWf != null) {
                                        NewSubPbActivity.this.fWf.axg();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.fVT.beQ();
                            NewSubPbActivity.this.fVT.beR();
                            if (NewSubPbActivity.this.eOI != null) {
                                NewSubPbActivity.this.eOI.Lq();
                                if (NewSubPbActivity.this.fWf != null) {
                                    NewSubPbActivity.this.fWf.axg();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.eOI.Lg()) {
                            NewSubPbActivity.this.eOI.a((PostWriteCallBackData) null);
                            return;
                        }
                        NewSubPbActivity.this.fVT.beQ();
                        NewSubPbActivity.this.fVT.beR();
                        if (NewSubPbActivity.this.eOI != null) {
                            NewSubPbActivity.this.eOI.Ls();
                            if (NewSubPbActivity.this.fWf != null) {
                                NewSubPbActivity.this.fWf.axg();
                            }
                        }
                    }
                }
            }
        };
        this.fVU = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.fVT.bdO();
                }
                NewSubPbActivity.this.eOI.Lp();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.fVT.bfg();
            }
        };
        this.fIH = new b.InterfaceC0073b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.fVR.bfk() != null) {
                    postData = NewSubPbActivity.this.fVR.bfk().aZt();
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
        this.bjX = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                    NewSubPbActivity.this.fVT.b(NewSubPbActivity.this.fIH, NewSubPbActivity.this.fVR.isMarked());
                }
                return true;
            }
        };
        this.fVV = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void b(View view, String str) {
                NewSubPbActivity.this.k(null, str, "LINK_IMAGE");
            }
        };
        this.fVW = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
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
                    m bfk = NewSubPbActivity.this.fVR.bfk();
                    TbRichText ay = NewSubPbActivity.this.ay(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (ay != null && ay.QB() != null) {
                        tbRichTextData = ay.QB().get(NewSubPbActivity.this.fIE);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.QH().QT()) {
                            String b = NewSubPbActivity.this.b(tbRichTextData);
                            arrayList2.add(b);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                            concurrentHashMap3.put(b, imageUrlData);
                            String str4 = null;
                            String str5 = null;
                            String str6 = null;
                            if (bfk == null) {
                                str3 = null;
                                z4 = false;
                            } else {
                                if (bfk.aZA() != null) {
                                    str4 = bfk.aZA().getName();
                                    str5 = bfk.aZA().getId();
                                }
                                if (bfk.VK() != null) {
                                    str6 = bfk.VK().getId();
                                }
                                str3 = str6;
                                z4 = true;
                            }
                            if (NewSubPbActivity.this.fVR.bfx() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.fVR.bfx();
                                z5 = NewSubPbActivity.this.fVR.bfz();
                                arrayList2 = NewSubPbActivity.this.fVR.bfy();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z5 = z4;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(v.f(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.fIF = false;
                        String str7 = "";
                        TbRichText bvK = bfk.aZt().bvK();
                        int size = arrayList2.size();
                        int a2 = NewSubPbActivity.this.a(bvK, ay, i, i, arrayList2, concurrentHashMap3);
                        int size2 = arrayList2.size();
                        if (size != size2) {
                            str7 = arrayList2.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (bfk == null) {
                            str2 = null;
                            z2 = false;
                        } else {
                            if (bfk.aZA() != null) {
                                str8 = bfk.aZA().getName();
                                str9 = bfk.aZA().getId();
                            }
                            if (bfk.VK() != null) {
                                str10 = bfk.VK().getId();
                            }
                            str2 = str10;
                            z2 = true;
                        }
                        if (NewSubPbActivity.this.fVR.bfx() != null) {
                            concurrentHashMap = NewSubPbActivity.this.fVR.bfx();
                            z3 = NewSubPbActivity.this.fVR.bfz();
                            arrayList = NewSubPbActivity.this.fVR.bfy();
                            i2 = a2 + NewSubPbActivity.this.fVR.getOffset();
                        } else {
                            concurrentHashMap = concurrentHashMap3;
                            i2 = a2;
                            z3 = z2;
                            arrayList = arrayList2;
                        }
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.add(v.f(arrayList, i2));
                        NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList4, 0, str8, str9, str2, z3, str7, true, concurrentHashMap, true, false, false)));
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
        TbRichTextImageInfo QH;
        if (tbRichText == tbRichText2) {
            this.fIF = true;
        }
        if (tbRichText != null && tbRichText.QB() != null) {
            int size = tbRichText.QB().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.QB().get(i6) != null && tbRichText.QB().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.QB().get(i6).QH().getWidth();
                    int height = tbRichText.QB().get(i6).QH().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.QB().get(i6).QH().QT()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.QB().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (QH = tbRichTextData.QH()) != null) {
                            String QV = QH.QV();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = QV;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.fIF) {
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
        TbRichTextImageInfo QH = tbRichTextData.QH();
        if (QH != null) {
            if (!StringUtils.isNull(QH.QS())) {
                return QH.QS();
            }
            if (QH.getHeight() * QH.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (QH.getHeight() * QH.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (QH.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * QH.getHeight())));
            } else {
                float width = QH.getWidth() / QH.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aV(QH.QU()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText ay(String str, int i) {
        if (this.fVR == null || this.fVR.bfk() == null || str == null || i < 0) {
            return null;
        }
        m bfk = this.fVR.bfk();
        TbRichText a2 = a(bfk.aZt(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bfk.aZt(), str, i);
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
        TbRichText bvK = postData.bvK();
        if (bvK != null) {
            ArrayList<TbRichTextData> QB = bvK.QB();
            int size = QB.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (QB.get(i3) != null && QB.get(i3).getType() == 8) {
                    i2++;
                    if (QB.get(i3).QH().QV().equals(str)) {
                        int width = QB.get(i3).QH().getWidth();
                        int height = QB.get(i3).QH().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.fIE = i3;
                        return bvK;
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
        long templateId = this.fVR.bfk().aZt().bvR() != null ? this.fVR.bfk().aZt().bvR().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && av.CZ().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.fVR.bfk().aZA().getId(), this.fVR.bfk().aZA().getName(), this.fVR.bfk().VK().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i, String str) {
        if (this.fVR.bfl()) {
            showToast(str);
        } else if (l.oZ()) {
            if (i == 4) {
                this.fVT.lA(str + "(4)");
            } else {
                this.fVT.jP(d.j.no_data_text);
            }
        } else {
            this.fVT.jP(d.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.eOI = (h) new i().bh(getActivity());
        if (this.eOI != null) {
            this.eOI.a(getPageContext());
            this.eOI.b(this.fVR);
            this.eOI.b(this.fWi);
            this.eOI.a(this.brR);
            this.eOI.a(this.brS);
            this.eOI.Ku().ca(true);
            this.eOI.e(getPageContext());
        }
        if (this.fVT != null) {
            this.fVT.g(this.eOI);
        }
        if (this.eOI != null && this.fVR != null) {
            this.eOI.a(this.fVR.aZB());
            this.eOI.Lp();
        }
        if (this.eOI != null) {
            this.fTd = this.eOI.Lt().getInputView();
            this.fTd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.fWg != null) {
                        if (!NewSubPbActivity.this.fWg.bEP()) {
                            NewSubPbActivity.this.kS(false);
                        }
                        NewSubPbActivity.this.fWg.nr(false);
                    }
                }
            });
        }
    }

    public void beN() {
        if (!TbadkCoreApplication.isLogin()) {
            this.eOI.Lp();
        } else if (!StringUtils.isNull(this.fVR.bfs())) {
            this.fVT.qs(this.fVR.bfs());
            if (this.fVT.beU() && l.oZ()) {
                this.fVT.arA();
            } else {
                this.fVT.beX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(View view) {
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
                    this.fVT.cz(view);
                }
            } else if (booleanValue2) {
                this.fVT.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            g.a(this.fVT.bfd(), getPageContext().getPageActivity());
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
        bVar.a(strArr, new b.InterfaceC0073b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                switch (i) {
                    case 0:
                        String str2 = "";
                        int intValue = sparseArray.get(d.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue() : 0;
                        if (sparseArray.get(d.g.tag_del_post_id) instanceof String) {
                            str2 = (String) sparseArray.get(d.g.tag_del_post_id);
                        }
                        NewSubPbActivity.this.fVT.a(intValue, str2, sparseArray.get(d.g.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue() : false);
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
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.fWd);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.fWd);
                        NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str6, str3);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext()).AD();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
        }
        this.fVT.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.fWd;
        userMuteCheckCustomMessage.setTag(this.fWd);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.fVT.a(0, bVar.aos, bVar.haC, z);
            if (bVar.aos) {
                if (bVar.haA == 1) {
                    finish();
                } else if (bVar.haA == 2) {
                    this.fVR.qv(bVar.mPostId);
                    this.fVT.a(this.fVR.bfk(), this.fVR.aYS(), this.fVR.bfx() != null);
                    if (this.fVR.bft()) {
                        this.fVR.kX(false);
                        this.fVT.beS();
                        this.fVR.MO();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void pW(String str) {
        if (!StringUtils.isNull(str) && this.fVR != null) {
            String bbF = this.fVR.bbF();
            String KO = this.fVR.KO();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + KO + "&tid=" + bbF + "&pid=" + str, true)));
        }
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.fVR.isMarked() && postData.getId() != null && postData.getId().equals(this.fVR.bfr())) {
                z = true;
            }
            MarkData h = this.fVR.h(postData);
            if (h != null) {
                this.fVT.bdO();
                if (this.fhR != null) {
                    this.fhR.a(h);
                    if (!z) {
                        this.fhR.vm();
                    } else {
                        this.fhR.vl();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.fVR != null) {
            this.fVR.x(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.eOI != null) {
            this.eOI.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.eOI.Ku().IE();
        this.eOI.Lp();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eOI.b(writeData);
                this.eOI.setVoiceModel(pbEditorData.getVoiceModel());
                r hJ = this.eOI.Ku().hJ(6);
                if (hJ != null && hJ.bqa != null) {
                    hJ.bqa.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eOI.Ll();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dBh != null) {
            this.dBh.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.fWb = true;
        super.onPause();
        if (this.dBh != null) {
            this.dBh.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.esv);
        this.fVT.awy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fWb = false;
        super.onResume();
        if (this.dBh != null) {
            this.dBh.onResume(getPageContext());
        }
        registerListener(this.esv);
        this.fVT.awz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dBh != null) {
            this.dBh.onStop(getPageContext());
        }
        this.eOI.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.fWh));
        this.fVR.cancelLoadData();
        this.fVR.destory();
        this.fVS.cancelLoadData();
        if (this.dBh != null) {
            this.dBh.onDestory(getPageContext());
        }
        this.fVT.bdO();
        this.fVT.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.fIt);
        MessageManager.getInstance().unRegisterListener(this.fIu);
        MessageManager.getInstance().unRegisterListener(this.fIv);
        MessageManager.getInstance().unRegisterListener(this.fWd);
        this.fHR = null;
        this.fHS = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fVT.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dBh;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View beY = this.fVT.beY();
        if (beY == null || (findViewWithTag = beY.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean ql(String str) {
        Map<String, String> eh;
        if (!TextUtils.isEmpty(str) && (eh = av.eh(av.ei(str))) != null) {
            this.fWe = true;
            String str2 = eh.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return ql(k.aW(str2));
            }
            String str3 = eh.get(fVQ);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ql(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            av.CZ().c(getPageContext(), new String[]{str});
            this.fWe = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void W(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fWe = true;
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
        if (this.fVT != null) {
            return this.fVT.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Rh() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Rj() {
        if (this.bJx == null) {
            this.bJx = TbRichTextView.x(getPageContext().getPageActivity(), 8);
        }
        return this.bJx;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Rk() {
        if (this.bJB == null) {
            this.bJB = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: baV */
                public GifView nk() {
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
        return this.bJB;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Ri() {
        if (this.bJw == null) {
            this.bJw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: agn */
                public ImageView nk() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean wG = com.baidu.tbadk.core.i.wA().wG();
                    foreDrawableImageView.setDefaultBg(aj.getDrawable(d.C0107d.common_color_10220));
                    if (wG) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0107d.cp_bg_line_c);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView at(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.wA().wG()) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0107d.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.bJw;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Rl() {
        if (this.bJy == null) {
            this.bJy = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: baW */
                public View nk() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cu */
                public void as(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cv */
                public View at(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cw */
                public View au(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.bJy;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Rm() {
        if (this.bJz == null) {
            this.bJz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: baY */
                public LinearLayout nk() {
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
        return this.bJz;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Rn() {
        this.bJA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: baX */
            public RelativeLayout nk() {
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
        return this.bJA;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fVT.beU() && l.oZ()) {
            this.fVR.MO();
        } else {
            this.fVT.beX();
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
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.fWd);
        userMuteAddAndDelCustomMessage.setTag(this.fWd);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ab(Context context, String str) {
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
            public boolean Ne() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Nf() {
                return com.baidu.tbadk.pageStayDuration.e.Nj().Nl();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.fVR != null) {
            if (this.fVR.bfk() != null && this.fVR.bfk().aZA() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fVR.bfk().aZA().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fVR.bbF(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.fWb;
    }

    public boolean beO() {
        if (this.fVR != null) {
            return this.fVR.beO();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.fVT.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fHR.getPageActivity());
        if (am.isEmpty(str)) {
            aVar.cZ(this.fHR.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.cZ(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.fVT.showLoadingDialog();
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
        aVar.b(this.fHR).AA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gk(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fHR.getPageActivity());
        aVar.cZ(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fHR).AA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cZ(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.fHR).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.fHR.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fHR).AA();
    }

    public String getThreadId() {
        if (this.fVR != null) {
            return this.fVR.bbF();
        }
        return null;
    }

    public String getPostId() {
        if (this.fVR != null) {
            return this.fVR.KO();
        }
        return null;
    }

    public int aYS() {
        if (this.fVR != null) {
            return this.fVR.aYS();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.bqx) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.bqx) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void kS(boolean z) {
        if (this.fTd != null && this.fTd.getText() != null) {
            int selectionEnd = this.fTd.getSelectionEnd();
            SpannableStringBuilder b = this.fWg.b(this.fTd.getText());
            if (b != null) {
                this.fWg.nr(true);
                this.fTd.setText(b);
                if (z && this.fWg.bEN() >= 0) {
                    this.fTd.requestFocus();
                    this.fTd.setSelection(this.fWg.bEN());
                } else {
                    this.fTd.setSelection(selectionEnd);
                }
                this.fWg.nq(this.fWg.bEN() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.eOI != null && this.eOI.Ku() != null && this.eOI.Ku().Kx()) {
            this.eOI.Ku().IE();
        } else {
            super.onBackPressed();
        }
    }
}
