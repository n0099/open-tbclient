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
    private static final String fUM = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String fWl = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> bJE;
    private com.baidu.adp.lib.e.b<TextView> bJF;
    private com.baidu.adp.lib.e.b<View> bJG;
    private com.baidu.adp.lib.e.b<LinearLayout> bJH;
    private com.baidu.adp.lib.e.b<RelativeLayout> bJI;
    private com.baidu.adp.lib.e.b<GifView> bJJ;
    private View.OnLongClickListener bkf;
    private VoiceManager dBC;
    private h ePd;
    private com.baidu.adp.base.e fIm;
    private com.baidu.tbadk.core.view.e fIn;
    private b.InterfaceC0073b fJc;
    private PostWriteCallBackData fMo;
    private EditText fTy;
    private b fWA;
    private com.baidu.tieba.write.b fWB;
    private com.baidu.tieba.pb.e<m> fWC;
    private SubPbModel fWm;
    private ForumManageModel fWn;
    private c fWo;
    private AbsListView.OnScrollListener fWp;
    private TbRichTextView.i fWq;
    private TbRichTextView.h fWr;
    private SubPbModel.a fWs;
    private com.baidu.adp.base.d fWt;
    private BdUniqueId fWy;
    private com.baidu.tbadk.baseEditMark.a fin;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int fIZ = 0;
    private a.InterfaceC0069a fIV = null;
    private a fWu = null;
    private a fWv = null;
    private boolean fWw = false;
    private boolean fWx = false;
    private boolean fWz = false;
    private boolean bqG = false;
    private com.baidu.tbadk.editortools.pb.c bsa = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void KT() {
            NewSubPbActivity.this.fWo.bfb();
        }
    };
    private com.baidu.tbadk.editortools.pb.b bsb = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean KS() {
            if (NewSubPbActivity.this.fWB.bEQ()) {
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.fWB.bES());
                if (NewSubPbActivity.this.ePd.Li()) {
                    NewSubPbActivity.this.ePd.a(NewSubPbActivity.this.fMo);
                }
                NewSubPbActivity.this.kV(true);
                return true;
            }
            return false;
        }
    };
    private NewWriteModel.d fWD = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.ePd != null && NewSubPbActivity.this.ePd.Kw() != null) {
                NewSubPbActivity.this.ePd.Kw().hide();
                if (NewSubPbActivity.this.fWm.bfv()) {
                    TiebaStatic.log(new ak("c10367").aa("post_id", NewSubPbActivity.this.fWm.KQ()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fWB.uh(null);
                NewSubPbActivity.this.fWB.av(null);
                NewSubPbActivity.this.fWB.nt(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fWB.av(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fWB.uh(postWriteCallBackData.getErrorString());
                if (!v.E(NewSubPbActivity.this.fWB.bEO())) {
                    NewSubPbActivity.this.fMo = postWriteCallBackData;
                    if (NewSubPbActivity.this.ePd.Li()) {
                        NewSubPbActivity.this.ePd.a(NewSubPbActivity.this.fMo);
                    }
                    NewSubPbActivity.this.kV(true);
                } else {
                    return;
                }
            }
            NewSubPbActivity.this.fWo.bfc();
        }
    };
    private CustomMessageListener fIO = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fWy) {
                NewSubPbActivity.this.fWo.afb();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fIn.q(NewSubPbActivity.this.fIm.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.fIm.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.gt(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.baV();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (am.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.fIm.getResources().getString(d.j.mute_fail);
                    }
                    NewSubPbActivity.this.fIn.r(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fIP = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fWy) {
                NewSubPbActivity.this.fWo.afb();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fIn.q(NewSubPbActivity.this.fIm.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (am.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.fIm.getResources().getString(d.j.un_mute_fail);
                }
                NewSubPbActivity.this.fIn.r(muteMessage);
            }
        }
    };
    private CustomMessageListener fIQ = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fWy) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.fWo.afb();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.hmt;
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
                    NewSubPbActivity.this.fWo.a(sparseArray, z);
                }
            }
        }
    };
    boolean fJa = false;
    private CustomMessageListener esQ = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener dCA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    com.baidu.tbadk.data.h hVar = (com.baidu.tbadk.data.h) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.fWm.bfp() != null && NewSubPbActivity.this.fWm.bfp().aZy() != null && NewSubPbActivity.this.fWm.bfp().aZy().yT() != null && currentAccount.equals(NewSubPbActivity.this.fWm.bfp().aZy().yT().getUserId()) && NewSubPbActivity.this.fWm.bfp().aZy().yT().getPendantData() != null) {
                        NewSubPbActivity.this.fWm.bfp().aZy().yT().getPendantData().cM(hVar.xu());
                        NewSubPbActivity.this.fWm.bfp().aZy().yT().getPendantData().ab(hVar.JY());
                        NewSubPbActivity.this.fWo.a(NewSubPbActivity.this.fWm.bfp().aZy(), NewSubPbActivity.this.fWm.bfp().aJO(), NewSubPbActivity.this.fWm.bfp().vl(), NewSubPbActivity.this.fWm.aYX(), NewSubPbActivity.this.fWm.bfC() != null);
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
        if (this.bqG) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.fIm = getPageContext();
        this.fWx = true;
        this.fWB = new com.baidu.tieba.write.b();
        this.fWB.xh(d.C0108d.cp_cont_h_alpha85);
        this.fWB.xg(d.C0108d.cp_cont_i);
        axh();
        beR();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.fWm.beT()) {
            this.fWA = new b(this, getListView(), this.fWo.auu());
            this.fWA.axm();
            this.fWA.a(new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                private boolean dMM = false;

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void axi() {
                    NewSubPbActivity.this.fWo.gc(false);
                    this.dMM = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void axj() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public boolean axk() {
                    if (!this.dMM) {
                        return NewSubPbActivity.this.fWo.axy() != null && NewSubPbActivity.this.fWo.axy().getTop() == 0;
                    }
                    this.dMM = false;
                    return false;
                }
            });
            this.fWo.e(this.fWA);
            this.fWo.gc(true);
        }
        this.fIn = new com.baidu.tbadk.core.view.e();
        this.fIn.aZw = 1000L;
        registerListener(this.fIQ);
        registerListener(this.fIO);
        registerListener(this.fIP);
        this.fWy = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fWy;
        userMuteAddAndDelCustomMessage.setTag(this.fWy);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.fWy;
        userMuteCheckCustomMessage.setTag(this.fWy);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.fWo = new c(this, this.mCommonClickListener);
        this.fWo.a(this.fWm);
        addContentView(this.fWo.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.fWo.setOnScrollListener(this.fWp);
        this.fWo.a(this);
        this.fWo.setOnLinkImageClickListener(this.fWq);
        this.fWo.setOnImageClickListener(this.fWr);
        this.fWo.jG(true);
        this.fWo.setOnLongClickListener(this.bkf);
        this.fWo.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.fWm != null) {
                    NewSubPbActivity.this.fWm.MQ();
                }
            }
        });
        this.fWo.a(this.fWu);
        this.fWo.b(this.fWv);
        if (this.fWm != null && this.fWm.beT() && !this.fWm.bfB()) {
            this.fWo.bfg().setVisibility(8);
        } else {
            this.fWo.bfg().setVisibility(0);
        }
        if (this.fWm != null && !this.fWm.beT()) {
            this.fWo.setIsFromPb(false);
        }
    }

    private boolean y(Bundle bundle) {
        if (bundle != null) {
            this.bqG = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.bqG = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.bqG;
    }

    public void initData(Bundle bundle) {
        this.fWm = new SubPbModel(getPageContext());
        this.fWm.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.fWo.n(postData);
                NewSubPbActivity.this.fWo.a((BdListView.e) null);
            }
        });
        this.fWn = new ForumManageModel(this);
        this.fWn.setLoadDataCallBack(this.fWt);
        this.dBC = new VoiceManager();
        this.dBC.onCreate(getPageContext());
        this.fin = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fin != null) {
            this.fin.a(this.fIV);
        }
        if (bundle != null) {
            this.fWm.initWithBundle(bundle);
        } else {
            this.fWm.initWithIntent(getIntent());
        }
        this.fWm.a(this.fWs);
        if (this.fWm.beT()) {
            this.fWm.MQ();
        } else {
            this.fWm.bfu();
        }
    }

    public void beR() {
        this.fWs = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, m mVar) {
                if (NewSubPbActivity.this.fWo != null) {
                    NewSubPbActivity.this.fWo.bfc();
                }
                if (NewSubPbActivity.this.fWA != null && NewSubPbActivity.this.fWA.axn()) {
                    NewSubPbActivity.this.fWA.nz(d.C0108d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.ab(i, str);
                    return;
                }
                NewSubPbActivity.this.fWo.hideNoDataView();
                if (mVar != null) {
                    if (mVar.aZy() != null || NewSubPbActivity.this.fWm != null) {
                        mVar.aZy().a(NewSubPbActivity.this.fWm.bfA());
                    }
                    if (NewSubPbActivity.this.fWo != null) {
                        NewSubPbActivity.this.fWo.a(mVar, NewSubPbActivity.this.fWm.aYX(), NewSubPbActivity.this.fWm.bfC() != null);
                        if (NewSubPbActivity.this.fWx) {
                            NewSubPbActivity.this.beS();
                            NewSubPbActivity.this.fWx = false;
                        }
                    }
                    if (NewSubPbActivity.this.ePd != null) {
                        NewSubPbActivity.this.ePd.a(mVar.aZG());
                    }
                    if (NewSubPbActivity.this.fWC == null) {
                        NewSubPbActivity.this.fWC = new com.baidu.tieba.pb.e();
                    }
                    NewSubPbActivity.this.fWC.setData(mVar);
                    NewSubPbActivity.this.fWC.setType(0);
                }
            }
        };
        this.fIV = new a.InterfaceC0069a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0069a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.fin != null) {
                        NewSubPbActivity.this.fin.aI(z2);
                    }
                    MarkData vo = NewSubPbActivity.this.fin.vo();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(vo);
                        if (NewSubPbActivity.this.fin != null) {
                            if (vo != null) {
                                NewSubPbActivity.this.fWm.kZ(true);
                                NewSubPbActivity.this.fWm.qE(NewSubPbActivity.this.fWm.KQ());
                                NewSubPbActivity.this.showToast(d.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.add_mark));
                            }
                            if (NewSubPbActivity.this.fWo != null) {
                                NewSubPbActivity.this.fWo.kW(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.fWm.kZ(false);
                        NewSubPbActivity.this.fWm.qE(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.remove_mark));
                        if (NewSubPbActivity.this.fWo != null) {
                            NewSubPbActivity.this.fWo.kW(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.update_mark_failed));
            }
        };
        this.fWu = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void ak(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.fWm.bfp() != null && NewSubPbActivity.this.fWm.bfp().VM() != null && NewSubPbActivity.this.fWm.bfp().VM().yT() != null) {
                    str = String.valueOf(NewSubPbActivity.this.fWm.bfp().VM().yT().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.fWm.bfp().aZF().getId(), NewSubPbActivity.this.fWm.bfp().aZF().getName(), NewSubPbActivity.this.fWm.bfp().VM().getId(), str, str2, str3)));
            }
        };
        this.fWv = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void ak(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.fWn.bwx() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int h = com.baidu.adp.lib.g.b.h(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int h2 = com.baidu.adp.lib.g.b.h(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.fWm != null && NewSubPbActivity.this.fWm.bfp() != null && NewSubPbActivity.this.fWm.bfp().aZF() != null && NewSubPbActivity.this.fWm.bfp().VM() != null) {
                            NewSubPbActivity.this.fWn.a(NewSubPbActivity.this.fWm.bfp().aZF().getId(), NewSubPbActivity.this.fWm.bfp().aZF().getName(), NewSubPbActivity.this.fWm.bfp().VM().getId(), valueOf, h2, h, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.j.login_to_use), true, 11017)));
            }
        };
        this.fWt = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                boolean z = true;
                if (obj == null) {
                    NewSubPbActivity.this.fWo.a(NewSubPbActivity.this.fWn.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.fWn.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.dYy && bVar.fXo > 0 && bVar.haU != 1 && bVar.fXo != 1002) {
                            com.baidu.tieba.c.a.a(NewSubPbActivity.this.getPageContext(), 3, 1);
                            z = false;
                        }
                        if (bVar.fXo == 1002 && !bVar.dYy) {
                            z = false;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.fWo.a(1, dVar.aov, dVar.haW, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void axh() {
        registerListener(this.dCA);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.fWo != null) {
                    if (view == NewSubPbActivity.this.fWo.bfm()) {
                        NewSubPbActivity.this.fWo.bdT();
                        String str = view.getTag(d.g.tag_user_id) instanceof String ? (String) view.getTag(d.g.tag_user_id) : null;
                        String str2 = view.getTag(d.g.tag_user_name) instanceof String ? (String) view.getTag(d.g.tag_user_name) : null;
                        String str3 = view.getTag(d.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(d.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                av.Da().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.fWo.axz()) {
                        if (view != NewSubPbActivity.this.fWo.bff()) {
                            if (view != NewSubPbActivity.this.fWo.bfe()) {
                                if (view == NewSubPbActivity.this.fWo.bfa()) {
                                    NewSubPbActivity.this.fWo.bdT();
                                    if (NewSubPbActivity.this.fWm.MQ()) {
                                        NewSubPbActivity.this.fWo.beY();
                                    }
                                } else if (view == NewSubPbActivity.this.fWo.bfg() || view == NewSubPbActivity.this.fWo.bfh() || view == NewSubPbActivity.this.fWo.bfj()) {
                                    if (NewSubPbActivity.this.fWz) {
                                        NewSubPbActivity.this.fWz = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.fWm.bbK(), NewSubPbActivity.this.fWm.KQ(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.fWm.bfF())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.fWm.bfF());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                } else if (NewSubPbActivity.this.fWo.bfk() == null || view != NewSubPbActivity.this.fWo.bfk().bcw()) {
                                    if (NewSubPbActivity.this.fWo.bfk() == null || view != NewSubPbActivity.this.fWo.bfk().bcB()) {
                                        if (NewSubPbActivity.this.fWo.bfk() == null || view != NewSubPbActivity.this.fWo.bfk().bcz()) {
                                            if (NewSubPbActivity.this.fWo.bfk() == null || view != NewSubPbActivity.this.fWo.bfk().bcx()) {
                                                if (NewSubPbActivity.this.fWo.bfk() == null || view != NewSubPbActivity.this.fWo.bfk().bcy()) {
                                                    if ((view == NewSubPbActivity.this.fWo.bfd() || view == NewSubPbActivity.this.fWo.bfj()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.ePd.Lq()) {
                                                            NewSubPbActivity.this.ePd.Lr();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.ePd.gu(null);
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
                                                NewSubPbActivity.this.fWo.bdT();
                                                if (tag instanceof String) {
                                                    String KQ = NewSubPbActivity.this.fWm.KQ();
                                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                        NewSubPbActivity.this.qe(KQ);
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
                                                NewSubPbActivity.this.fWo.bdT();
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
                                        NewSubPbActivity.this.fWo.bdT();
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.fWo.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new ak("c11739").s("obj_locate", 1));
                                    NewSubPbActivity.this.fWo.bdT();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.ePd.gu(null);
                                        if (NewSubPbActivity.this.fWA != null) {
                                            NewSubPbActivity.this.fWA.axl();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new ak("c11739").s("obj_locate", 2));
                                    NewSubPbActivity.this.fWo.bdT();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.fWm.bfp() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.fWm.bfp().aZy());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.fWo.beV();
                                NewSubPbActivity.this.fWo.beW();
                                if (NewSubPbActivity.this.ePd != null) {
                                    NewSubPbActivity.this.ePd.Lt();
                                    if (NewSubPbActivity.this.fWA != null) {
                                        NewSubPbActivity.this.fWA.axl();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.fWo.beV();
                            NewSubPbActivity.this.fWo.beW();
                            if (NewSubPbActivity.this.ePd != null) {
                                NewSubPbActivity.this.ePd.Ls();
                                if (NewSubPbActivity.this.fWA != null) {
                                    NewSubPbActivity.this.fWA.axl();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.ePd.Li()) {
                            NewSubPbActivity.this.ePd.a((PostWriteCallBackData) null);
                            return;
                        }
                        NewSubPbActivity.this.fWo.beV();
                        NewSubPbActivity.this.fWo.beW();
                        if (NewSubPbActivity.this.ePd != null) {
                            NewSubPbActivity.this.ePd.Lu();
                            if (NewSubPbActivity.this.fWA != null) {
                                NewSubPbActivity.this.fWA.axl();
                            }
                        }
                    }
                }
            }
        };
        this.fWp = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.fWo.bdT();
                }
                NewSubPbActivity.this.ePd.Lr();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.fWo.bfl();
            }
        };
        this.fJc = new b.InterfaceC0073b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.fWm.bfp() != null) {
                    postData = NewSubPbActivity.this.fWm.bfp().aZy();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.ch(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.f(postData);
                    }
                }
            }
        };
        this.bkf = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                    NewSubPbActivity.this.fWo.b(NewSubPbActivity.this.fJc, NewSubPbActivity.this.fWm.isMarked());
                }
                return true;
            }
        };
        this.fWq = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void b(View view, String str) {
                NewSubPbActivity.this.k(null, str, "LINK_IMAGE");
            }
        };
        this.fWr = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
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
                    m bfp = NewSubPbActivity.this.fWm.bfp();
                    TbRichText ay = NewSubPbActivity.this.ay(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (ay != null && ay.QD() != null) {
                        tbRichTextData = ay.QD().get(NewSubPbActivity.this.fIZ);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.QJ().QV()) {
                            String b = NewSubPbActivity.this.b(tbRichTextData);
                            arrayList2.add(b);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                            concurrentHashMap3.put(b, imageUrlData);
                            String str4 = null;
                            String str5 = null;
                            String str6 = null;
                            if (bfp == null) {
                                str3 = null;
                                z4 = false;
                            } else {
                                if (bfp.aZF() != null) {
                                    str4 = bfp.aZF().getName();
                                    str5 = bfp.aZF().getId();
                                }
                                if (bfp.VM() != null) {
                                    str6 = bfp.VM().getId();
                                }
                                str3 = str6;
                                z4 = true;
                            }
                            if (NewSubPbActivity.this.fWm.bfC() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.fWm.bfC();
                                z5 = NewSubPbActivity.this.fWm.bfE();
                                arrayList2 = NewSubPbActivity.this.fWm.bfD();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z5 = z4;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(v.f(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.fJa = false;
                        String str7 = "";
                        TbRichText bvM = bfp.aZy().bvM();
                        int size = arrayList2.size();
                        int a2 = NewSubPbActivity.this.a(bvM, ay, i, i, arrayList2, concurrentHashMap3);
                        int size2 = arrayList2.size();
                        if (size != size2) {
                            str7 = arrayList2.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (bfp == null) {
                            str2 = null;
                            z2 = false;
                        } else {
                            if (bfp.aZF() != null) {
                                str8 = bfp.aZF().getName();
                                str9 = bfp.aZF().getId();
                            }
                            if (bfp.VM() != null) {
                                str10 = bfp.VM().getId();
                            }
                            str2 = str10;
                            z2 = true;
                        }
                        if (NewSubPbActivity.this.fWm.bfC() != null) {
                            concurrentHashMap = NewSubPbActivity.this.fWm.bfC();
                            z3 = NewSubPbActivity.this.fWm.bfE();
                            arrayList = NewSubPbActivity.this.fWm.bfD();
                            i2 = a2 + NewSubPbActivity.this.fWm.getOffset();
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
        TbRichTextImageInfo QJ;
        if (tbRichText == tbRichText2) {
            this.fJa = true;
        }
        if (tbRichText != null && tbRichText.QD() != null) {
            int size = tbRichText.QD().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.QD().get(i6) != null && tbRichText.QD().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.QD().get(i6).QJ().getWidth();
                    int height = tbRichText.QD().get(i6).QJ().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.QD().get(i6).QJ().QV()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.QD().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (QJ = tbRichTextData.QJ()) != null) {
                            String QX = QJ.QX();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = QX;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.fJa) {
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
        TbRichTextImageInfo QJ = tbRichTextData.QJ();
        if (QJ != null) {
            if (!StringUtils.isNull(QJ.QU())) {
                return QJ.QU();
            }
            if (QJ.getHeight() * QJ.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (QJ.getHeight() * QJ.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (QJ.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * QJ.getHeight())));
            } else {
                float width = QJ.getWidth() / QJ.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aV(QJ.QW()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText ay(String str, int i) {
        if (this.fWm == null || this.fWm.bfp() == null || str == null || i < 0) {
            return null;
        }
        m bfp = this.fWm.bfp();
        TbRichText a2 = a(bfp.aZy(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bfp.aZy(), str, i);
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
        TbRichText bvM = postData.bvM();
        if (bvM != null) {
            ArrayList<TbRichTextData> QD = bvM.QD();
            int size = QD.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (QD.get(i3) != null && QD.get(i3).getType() == 8) {
                    i2++;
                    if (QD.get(i3).QJ().QX().equals(str)) {
                        int width = QD.get(i3).QJ().getWidth();
                        int height = QD.get(i3).QJ().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.fIZ = i3;
                        return bvM;
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
        long templateId = this.fWm.bfp().aZy().bvT() != null ? this.fWm.bfp().aZy().bvT().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && av.Da().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.fWm.bfp().aZF().getId(), this.fWm.bfp().aZF().getName(), this.fWm.bfp().VM().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, String str) {
        if (this.fWm.bfq()) {
            showToast(str);
        } else if (l.pa()) {
            if (i == 4) {
                this.fWo.lI(str + "(4)");
            } else {
                this.fWo.jP(d.j.no_data_text);
            }
        } else {
            this.fWo.jP(d.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.ePd = (h) new i().be(getActivity());
        if (this.ePd != null) {
            this.ePd.a(getPageContext());
            this.ePd.b(this.fWm);
            this.ePd.b(this.fWD);
            this.ePd.a(this.bsa);
            this.ePd.a(this.bsb);
            this.ePd.Kw().cb(true);
            this.ePd.e(getPageContext());
        }
        if (this.fWo != null) {
            this.fWo.g(this.ePd);
        }
        if (this.ePd != null && this.fWm != null) {
            this.ePd.a(this.fWm.aZG());
            this.ePd.Lr();
        }
        if (this.ePd != null) {
            this.fTy = this.ePd.Lv().getInputView();
            this.fTy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.fWB != null) {
                        if (!NewSubPbActivity.this.fWB.bER()) {
                            NewSubPbActivity.this.kV(false);
                        }
                        NewSubPbActivity.this.fWB.nu(false);
                    }
                }
            });
        }
    }

    public void beS() {
        if (!TbadkCoreApplication.isLogin()) {
            this.ePd.Lr();
        } else if (!StringUtils.isNull(this.fWm.bfx())) {
            this.fWo.qA(this.fWm.bfx());
            if (this.fWo.beZ() && l.pa()) {
                this.fWo.arF();
            } else {
                this.fWo.bfc();
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
                    this.fWo.cz(view);
                }
            } else if (booleanValue2) {
                this.fWo.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            g.a(this.fWo.bfi(), getPageContext().getPageActivity());
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
                        NewSubPbActivity.this.fWo.a(intValue, str2, sparseArray.get(d.g.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue() : false);
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
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.fWy);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.fWy);
                        NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str6, str3);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext()).AE();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
        }
        this.fWo.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.fWy;
        userMuteCheckCustomMessage.setTag(this.fWy);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.fWo.a(0, bVar.aov, bVar.haW, z);
            if (bVar.aov) {
                if (bVar.haU == 1) {
                    finish();
                } else if (bVar.haU == 2) {
                    this.fWm.qD(bVar.mPostId);
                    this.fWo.a(this.fWm.bfp(), this.fWm.aYX(), this.fWm.bfC() != null);
                    if (this.fWm.bfy()) {
                        this.fWm.la(false);
                        this.fWo.beX();
                        this.fWm.MQ();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void qe(String str) {
        if (!StringUtils.isNull(str) && this.fWm != null) {
            String bbK = this.fWm.bbK();
            String KQ = this.fWm.KQ();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + KQ + "&tid=" + bbK + "&pid=" + str, true)));
        }
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.fWm.isMarked() && postData.getId() != null && postData.getId().equals(this.fWm.bfw())) {
                z = true;
            }
            MarkData h = this.fWm.h(postData);
            if (h != null) {
                this.fWo.bdT();
                if (this.fin != null) {
                    this.fin.a(h);
                    if (!z) {
                        this.fin.vn();
                    } else {
                        this.fin.vm();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.fWm != null) {
            this.fWm.x(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.ePd != null) {
            this.ePd.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.ePd.Kw().IG();
        this.ePd.Lr();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.ePd.b(writeData);
                this.ePd.setVoiceModel(pbEditorData.getVoiceModel());
                r hJ = this.ePd.Kw().hJ(6);
                if (hJ != null && hJ.bqj != null) {
                    hJ.bqj.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.ePd.Ln();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dBC != null) {
            this.dBC.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.fWw = true;
        super.onPause();
        if (this.dBC != null) {
            this.dBC.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.esQ);
        this.fWo.awD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fWw = false;
        super.onResume();
        if (this.dBC != null) {
            this.dBC.onResume(getPageContext());
        }
        registerListener(this.esQ);
        this.fWo.awE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dBC != null) {
            this.dBC.onStop(getPageContext());
        }
        this.ePd.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.fWC));
        this.fWm.cancelLoadData();
        this.fWm.destory();
        this.fWn.cancelLoadData();
        if (this.dBC != null) {
            this.dBC.onDestory(getPageContext());
        }
        this.fWo.bdT();
        this.fWo.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.fIO);
        MessageManager.getInstance().unRegisterListener(this.fIP);
        MessageManager.getInstance().unRegisterListener(this.fIQ);
        MessageManager.getInstance().unRegisterListener(this.fWy);
        this.fIm = null;
        this.fIn = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fWo.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dBC;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bfd = this.fWo.bfd();
        if (bfd == null || (findViewWithTag = bfd.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean qt(String str) {
        Map<String, String> em;
        if (!TextUtils.isEmpty(str) && (em = av.em(av.en(str))) != null) {
            this.fWz = true;
            String str2 = em.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return qt(k.aW(str2));
            }
            String str3 = em.get(fWl);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void W(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (qt(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            av.Da().c(getPageContext(), new String[]{str});
            this.fWz = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fWz = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void h(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.fWo != null) {
            return this.fWo.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Rj() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Rl() {
        if (this.bJF == null) {
            this.bJF = TbRichTextView.x(getPageContext().getPageActivity(), 8);
        }
        return this.bJF;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Rm() {
        if (this.bJJ == null) {
            this.bJJ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bba */
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
        return this.bJJ;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Rk() {
        if (this.bJE == null) {
            this.bJE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: agq */
                public ImageView nl() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean wH = com.baidu.tbadk.core.i.wB().wH();
                    foreDrawableImageView.setDefaultBg(aj.getDrawable(d.C0108d.common_color_10220));
                    if (wH) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0108d.cp_bg_line_c);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView at(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.wB().wH()) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0108d.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.bJE;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Rn() {
        if (this.bJG == null) {
            this.bJG = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bbb */
                public View nl() {
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
        return this.bJG;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Ro() {
        if (this.bJH == null) {
            this.bJH = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bbd */
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
        return this.bJH;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Rp() {
        this.bJI = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bbc */
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
        return this.bJI;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fWo.beZ() && l.pa()) {
            this.fWm.MQ();
        } else {
            this.fWo.bfc();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.fWy);
        userMuteAddAndDelCustomMessage.setTag(this.fWy);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aa(Context context, String str) {
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
            public boolean Ng() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Nh() {
                return com.baidu.tbadk.pageStayDuration.e.Nl().Nn();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.fWm != null) {
            if (this.fWm.bfp() != null && this.fWm.bfp().aZF() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fWm.bfp().aZF().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fWm.bbK(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.fWw;
    }

    public boolean beT() {
        if (this.fWm != null) {
            return this.fWm.beT();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.fWo.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fIm.getPageActivity());
        if (am.isEmpty(str)) {
            aVar.cZ(this.fIm.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.cZ(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.fWo.showLoadingDialog();
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
        aVar.b(this.fIm).AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gt(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fIm.getPageActivity());
        aVar.cZ(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fIm).AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baV() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cZ(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.fIm).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.fIm.getPageActivity(), 2, true, 4);
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
        aVar.b(this.fIm).AB();
    }

    public String getThreadId() {
        if (this.fWm != null) {
            return this.fWm.bbK();
        }
        return null;
    }

    public String getPostId() {
        if (this.fWm != null) {
            return this.fWm.KQ();
        }
        return null;
    }

    public int aYX() {
        if (this.fWm != null) {
            return this.fWm.aYX();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.bqG) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.bqG) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void kV(boolean z) {
        if (this.fTy != null && this.fTy.getText() != null) {
            int selectionEnd = this.fTy.getSelectionEnd();
            SpannableStringBuilder b = this.fWB.b(this.fTy.getText());
            if (b != null) {
                this.fWB.nu(true);
                this.fTy.setText(b);
                if (z && this.fWB.bEP() >= 0) {
                    this.fTy.requestFocus();
                    this.fTy.setSelection(this.fWB.bEP());
                } else {
                    this.fTy.setSelection(selectionEnd);
                }
                this.fWB.nt(this.fWB.bEP() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.ePd != null && this.ePd.Kw() != null && this.ePd.Kw().Kz()) {
            this.ePd.Kw().IG();
        } else {
            super.onBackPressed();
        }
    }
}
