package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.p;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.l;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.editortools.pb.h;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.au;
import com.baidu.tieba.pb.pb.main.j;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.y;
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
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes4.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.e, com.baidu.tieba.pb.pb.a<NewSubPbActivity> {
    private static final String hRA = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String hTj = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> cID;
    private com.baidu.adp.lib.e.b<GifView> cIE;
    private com.baidu.adp.lib.e.b<TextView> cLs;
    private com.baidu.adp.lib.e.b<View> cLt;
    private com.baidu.adp.lib.e.b<LinearLayout> cLu;
    private com.baidu.adp.lib.e.b<RelativeLayout> cLv;
    private View.OnLongClickListener clk;
    private au fQB;
    private VoiceManager foO;
    private com.baidu.tieba.frs.profession.permission.c fsw;
    public aj gPK;
    private g gPS;
    private com.baidu.tieba.write.b ggd;
    private EditText gge;
    private com.baidu.adp.base.e hEG;
    private com.baidu.tbadk.core.view.e hEH;
    private com.baidu.adp.widget.ImageView.a hEK;
    private String hEL;
    private TbRichTextMemeInfo hEM;
    private com.baidu.tieba.pb.pb.report.a hEi;
    private com.baidu.tbadk.baseEditMark.a hEj;
    private com.baidu.tieba.pb.pb.main.b.a hEm;
    private b.a hFv;
    private PostWriteCallBackData hIR;
    private String hPv;
    private boolean hTA;
    private j hTB;
    private SubPbModel hTk;
    private ForumManageModel hTl;
    private b hTm;
    private y hTn;
    private AbsListView.OnScrollListener hTo;
    private TbRichTextView.i hTp;
    private TbRichTextView.h hTq;
    private SubPbModel.a hTr;
    private com.baidu.adp.base.d hTs;
    private BdUniqueId hTw;
    private com.baidu.tieba.pb.pb.sub.a hTy;
    private com.baidu.tieba.pb.e<k> hTz;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int hFt = 0;
    PostData ggM = null;
    private a.InterfaceC0236a hFq = null;
    private a hTt = null;
    private a hTu = null;
    private boolean ddX = false;
    private boolean hTv = false;
    private boolean hTx = false;
    private boolean crd = false;
    private com.baidu.tbadk.editortools.pb.c csw = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void arr() {
            NewSubPbActivity.this.hTm.bWf();
        }
    };
    private com.baidu.tbadk.editortools.pb.b csx = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean arq() {
            if (!NewSubPbActivity.this.ggd.cwe()) {
                return (NewSubPbActivity.this.gPK == null || NewSubPbActivity.this.hTk == null || NewSubPbActivity.this.hTk.biW() == null || NewSubPbActivity.this.gPK.R(NewSubPbActivity.this.hTk.biW().replyPrivateFlag, aj.bSh)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.ggd.cwg());
            if (NewSubPbActivity.this.gPS.arG()) {
                NewSubPbActivity.this.gPS.a(NewSubPbActivity.this.hIR);
            }
            NewSubPbActivity.this.lj(true);
            return true;
        }
    };
    private NewWriteModel.d ggk = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.gPS != null && NewSubPbActivity.this.gPS.aqS() != null) {
                NewSubPbActivity.this.gPS.aqS().hide();
                if (NewSubPbActivity.this.hTk.bWA()) {
                    TiebaStatic.log(new am("c10367").bT("post_id", NewSubPbActivity.this.hTk.aro()));
                }
            }
            if (z) {
                NewSubPbActivity.this.ggd.FE(null);
                NewSubPbActivity.this.ggd.aI(null);
                NewSubPbActivity.this.ggd.rJ(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.ggd.aI(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.ggd.FE(postWriteCallBackData.getErrorString());
                if (!v.aa(NewSubPbActivity.this.ggd.cwc())) {
                    NewSubPbActivity.this.hIR = postWriteCallBackData;
                    if (NewSubPbActivity.this.gPS.arG()) {
                        NewSubPbActivity.this.gPS.a(NewSubPbActivity.this.hIR);
                    }
                    NewSubPbActivity.this.lj(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.gPK != null) {
                NewSubPbActivity.this.gPK.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.hTm.bWg();
        }
    };
    private CustomMessageListener hFi = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hTw) {
                NewSubPbActivity.this.hTm.aSD();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hEH.i(NewSubPbActivity.this.hEG.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.hEG.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.qf(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bRN();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ap.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.hEG.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.hEH.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hFj = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hTw) {
                NewSubPbActivity.this.hTm.aSD();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hEH.i(NewSubPbActivity.this.hEG.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ap.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.hEG.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.hEH.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hFk = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hTw) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.hTm.aSD();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.jnb;
                if (aVar.error == 0 && dataRes != null) {
                    boolean z2 = com.baidu.adp.lib.g.b.f(dataRes.is_mute, 0) == 1;
                    sparseArray.put(R.id.tag_user_mute_visible, true);
                    sparseArray.put(R.id.tag_user_mute_msg, dataRes.mute_confirm);
                    z = z2;
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, false);
                    z = false;
                }
                int intValue = sparseArray.get(R.id.tag_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_from)).intValue() : 0;
                if (intValue == 0) {
                    NewSubPbActivity.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    NewSubPbActivity.this.hTm.a(sparseArray, z);
                }
            }
        }
    };
    boolean hFu = false;
    private final b.a hFw = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.hEK != null && !TextUtils.isEmpty(NewSubPbActivity.this.hEL)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.hEM == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hEL));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.hEL;
                        aVar.pkgId = NewSubPbActivity.this.hEM.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hEM.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.aiM();
                    NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.aa(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.fQB == null) {
                            NewSubPbActivity.this.fQB = new au(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.fQB.h(NewSubPbActivity.this.hEL, NewSubPbActivity.this.hEK.nv());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.hEK = null;
                NewSubPbActivity.this.hEL = null;
            }
        }
    };
    private CustomMessageListener gtJ = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener fqk = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    l lVar = (l) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.hTk.bWu() != null && NewSubPbActivity.this.hTk.bWu().bQr() != null && NewSubPbActivity.this.hTk.bWu().bQr().adv() != null && currentAccount.equals(NewSubPbActivity.this.hTk.bWu().bQr().adv().getUserId()) && NewSubPbActivity.this.hTk.bWu().bQr().adv().getPendantData() != null) {
                        NewSubPbActivity.this.hTk.bWu().bQr().adv().getPendantData().ml(lVar.abS());
                        NewSubPbActivity.this.hTk.bWu().bQr().adv().getPendantData().bg(lVar.aqx());
                        NewSubPbActivity.this.hTm.a(NewSubPbActivity.this.hTk.bWu().bQr(), NewSubPbActivity.this.hTk.bWu().bDa(), NewSubPbActivity.this.hTk.bWu().ZC(), NewSubPbActivity.this.hTk.bPU(), NewSubPbActivity.this.hTk.bWG() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void m(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ac(bundle);
        if (this.crd) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.hEG = getPageContext();
        this.hTv = true;
        this.ggd = new com.baidu.tieba.write.b();
        this.ggd.Cc(R.color.cp_cont_h_alpha85);
        this.ggd.Cb(R.color.cp_btn_a);
        bnP();
        bVV();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bVU();
        this.hEH = new com.baidu.tbadk.core.view.e();
        this.hEH.bXF = 1000L;
        registerListener(this.hFk);
        registerListener(this.hFi);
        registerListener(this.hFj);
        this.hTw = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hTw;
        userMuteAddAndDelCustomMessage.setTag(this.hTw);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hTw;
        userMuteCheckCustomMessage.setTag(this.hTw);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.gPK = new aj(getPageContext());
        this.gPK.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.gPS.arL();
                }
            }
        });
        this.hEi = new com.baidu.tieba.pb.pb.report.a(this);
        this.hEi.r(getUniqueId());
        this.hEm = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    private void bVU() {
        if (this.hTm != null && this.hTk != null && this.hTk.bVX()) {
            this.hTy = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.hTm.aJz());
            this.hTy.bnU();
            this.hTy.a(new a.InterfaceC0380a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
                private boolean fDw = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0380a
                public void bnQ() {
                    NewSubPbActivity.this.hTm.kt(false);
                    this.fDw = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0380a
                public void bnR() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0380a
                public boolean bnS() {
                    if (!this.fDw) {
                        return NewSubPbActivity.this.hTm.bog() != null && NewSubPbActivity.this.hTm.bog().getTop() == 0;
                    }
                    this.fDw = false;
                    return false;
                }
            });
            this.hTm.e(this.hTy);
            this.hTm.kt(true);
        }
    }

    public void initUI() {
        this.hTm = new b(this, this.mCommonClickListener);
        this.hTm.a(this.hTk);
        setContentView(this.hTm.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.hTm.setOnScrollListener(this.hTo);
        this.hTm.b(this);
        this.hTm.setOnLinkImageClickListener(this.hTp);
        this.hTm.setOnImageClickListener(this.hTq);
        this.hTm.nR(true);
        this.hTm.setOnLongClickListener(this.clk);
        this.hTm.d(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.40
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.hTk != null) {
                    NewSubPbActivity.this.hTk.atv();
                }
            }
        });
        this.hTm.a(this.hTt);
        this.hTm.b(this.hTu);
        if (this.hTk != null && this.hTk.bVX() && !this.hTk.bWF()) {
            this.hTm.bWk().setVisibility(8);
        } else {
            this.hTm.bWk().setVisibility(0);
        }
        if (this.hTk != null && !this.hTk.bVX()) {
            this.hTm.setIsFromPb(false);
        }
    }

    private boolean ac(Bundle bundle) {
        if (bundle != null) {
            this.crd = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.crd = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.crd;
    }

    public void initData(Bundle bundle) {
        this.hTk = new SubPbModel(getPageContext());
        this.hTk.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                NewSubPbActivity.this.hTm.p(postData);
                NewSubPbActivity.this.hTm.b((BdListView.e) null);
            }
        });
        this.hTl = new ForumManageModel(getPageContext());
        this.hTl.setLoadDataCallBack(this.hTs);
        this.foO = new VoiceManager();
        this.foO.onCreate(getPageContext());
        this.hEj = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hEj != null) {
            this.hEj.a(this.hFq);
        }
        if (bundle != null) {
            this.hTk.initWithBundle(bundle);
        } else {
            this.hTk.initWithIntent(getIntent());
        }
        this.hTk.a(this.hTr);
        if (this.hTk.bVX()) {
            this.hTk.atv();
        } else {
            this.hTk.bWz();
        }
    }

    public void bVV() {
        this.hTr = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, k kVar) {
                if (NewSubPbActivity.this.hTm != null) {
                    NewSubPbActivity.this.hTm.bWg();
                }
                if (NewSubPbActivity.this.hTy != null && NewSubPbActivity.this.hTy.bnV()) {
                    NewSubPbActivity.this.hTy.rT(R.color.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.aC(i, str);
                    return;
                }
                NewSubPbActivity.this.hTm.hideNoDataView();
                if (kVar != null) {
                    if (kVar.bQr() != null || NewSubPbActivity.this.hTk != null) {
                        kVar.bQr().a(NewSubPbActivity.this.hTk.bWE());
                    }
                    if (NewSubPbActivity.this.hTm != null) {
                        NewSubPbActivity.this.hTm.a(kVar, NewSubPbActivity.this.hTk.bPU(), NewSubPbActivity.this.hTk.bWG() != null);
                        if (NewSubPbActivity.this.hTv) {
                            NewSubPbActivity.this.bVW();
                            NewSubPbActivity.this.hTv = false;
                        }
                    }
                    if (NewSubPbActivity.this.gPS != null) {
                        NewSubPbActivity.this.gPS.a(kVar.biW());
                    }
                    if (NewSubPbActivity.this.hTz == null) {
                        NewSubPbActivity.this.hTz = new com.baidu.tieba.pb.e();
                    }
                    NewSubPbActivity.this.hTz.setData(kVar);
                    NewSubPbActivity.this.hTz.setType(0);
                    NewSubPbActivity.this.gPK.a(NewSubPbActivity.this.hTk.bWJ());
                }
            }
        };
        this.hFq = new a.InterfaceC0236a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0236a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.hEj != null) {
                        NewSubPbActivity.this.hEj.ds(z2);
                    }
                    MarkData ZF = NewSubPbActivity.this.hEj.ZF();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(ZF);
                        if (NewSubPbActivity.this.hEj != null) {
                            if (ZF != null) {
                                NewSubPbActivity.this.hTk.pc(true);
                                NewSubPbActivity.this.hTk.BD(NewSubPbActivity.this.hTk.aro());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.hTm != null) {
                                NewSubPbActivity.this.hTm.pb(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.hTk.pc(false);
                        NewSubPbActivity.this.hTk.BD(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.hTm != null) {
                            NewSubPbActivity.this.hTm.pb(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.hTt = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.hTk.bWu() != null && NewSubPbActivity.this.hTk.bWu().abv() != null && NewSubPbActivity.this.hTk.bWu().abv().adv() != null) {
                    str = String.valueOf(NewSubPbActivity.this.hTk.bWu().abv().adv().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.hTk.bWu().bQx().getId(), NewSubPbActivity.this.hTk.bWu().bQx().getName(), NewSubPbActivity.this.hTk.bWu().abv().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.hTu = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.hTl.cnf() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int f = com.baidu.adp.lib.g.b.f(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int f2 = com.baidu.adp.lib.g.b.f(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.hTk != null && NewSubPbActivity.this.hTk.bWu() != null && NewSubPbActivity.this.hTk.bWu().bQx() != null && NewSubPbActivity.this.hTk.bWu().abv() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.hTl.Ea(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.hTl.a(NewSubPbActivity.this.hTk.bWu().bQx().getId(), NewSubPbActivity.this.hTk.bWu().bQx().getName(), NewSubPbActivity.this.hTk.bWu().abv().getId(), valueOf, f2, f, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.hTs = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.hTm.a(NewSubPbActivity.this.hTl.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.hTl.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.hUu != 1002 || bVar.fTQ) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.hTm.a(1, dVar.FN, dVar.jbh, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean cu(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void bnP() {
        registerListener(this.fqk);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v63, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.hTm != null) {
                    if (view == NewSubPbActivity.this.hTm.bWq()) {
                        NewSubPbActivity.this.hTm.bUP();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ba.aiz().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.hTm.boh()) {
                        if (view != NewSubPbActivity.this.hTm.bWj()) {
                            if (view != NewSubPbActivity.this.hTm.bWi()) {
                                if (view == NewSubPbActivity.this.hTm.bWe()) {
                                    NewSubPbActivity.this.hTm.bUP();
                                    if (NewSubPbActivity.this.hTk.atv()) {
                                        NewSubPbActivity.this.hTm.bWc();
                                    }
                                } else if (view == NewSubPbActivity.this.hTm.bWk() || view == NewSubPbActivity.this.hTm.bWl() || view == NewSubPbActivity.this.hTm.bWn()) {
                                    if (NewSubPbActivity.this.hTx) {
                                        NewSubPbActivity.this.hTx = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.hTk.bSF(), NewSubPbActivity.this.hTk.aro(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.hTk.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.hTk.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.hTm.bWo() == null || view != NewSubPbActivity.this.hTm.bWo().bTv()) {
                                    if (NewSubPbActivity.this.hTm.bWo() == null || view != NewSubPbActivity.this.hTm.bWo().bTy()) {
                                        if (NewSubPbActivity.this.hTm.bWo() == null || view != NewSubPbActivity.this.hTm.bWo().bTw()) {
                                            if (NewSubPbActivity.this.hTm.bWo() == null || view != NewSubPbActivity.this.hTm.bWo().bTx()) {
                                                if (NewSubPbActivity.this.hTm.bWo() == null || view != NewSubPbActivity.this.hTm.bWo().bTz()) {
                                                    if (view == NewSubPbActivity.this.hTm.bWh() || view == NewSubPbActivity.this.hTm.bWn()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.gPS.arO()) {
                                                                NewSubPbActivity.this.gPS.arP();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.gPS.qg(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof j)) {
                                                        if (NewSubPbActivity.this.hTn == null || view != NewSubPbActivity.this.hTn.bTx()) {
                                                            if (NewSubPbActivity.this.hTn == null || view != NewSubPbActivity.this.hTn.bTv()) {
                                                                if (NewSubPbActivity.this.hTn == null || view != NewSubPbActivity.this.hTn.bTy()) {
                                                                    if (NewSubPbActivity.this.hTn == null || view != NewSubPbActivity.this.hTn.bTz()) {
                                                                        if (NewSubPbActivity.this.hTn == null || view != NewSubPbActivity.this.hTn.bTB()) {
                                                                            if (NewSubPbActivity.this.hTn == null || view != NewSubPbActivity.this.hTn.bTC()) {
                                                                                if (NewSubPbActivity.this.hTn != null && view == NewSubPbActivity.this.hTn.bTw()) {
                                                                                    if (!com.baidu.adp.lib.util.j.jS()) {
                                                                                        NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                                                        return;
                                                                                    }
                                                                                    SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                                                                                    if (sparseArray != null) {
                                                                                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                        boolean booleanValue2 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                        boolean booleanValue3 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                        if (booleanValue) {
                                                                                            if (booleanValue3) {
                                                                                                sparseArray.put(R.id.tag_from, 1);
                                                                                                sparseArray.put(R.id.tag_check_mute_from, 2);
                                                                                                NewSubPbActivity.this.c(sparseArray);
                                                                                                return;
                                                                                            }
                                                                                            sparseArray.put(R.id.tag_check_mute_from, 2);
                                                                                            NewSubPbActivity.this.hTm.cA(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.hTm.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                            return;
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                int id = view.getId();
                                                                                if (id == R.id.pb_item_tail_content) {
                                                                                    if (bc.cE(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.agM().getString("tail_link", "");
                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                            TiebaStatic.log("c10056");
                                                                                            com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else if (id == R.id.richText && (view.getTag() instanceof SparseArray)) {
                                                                                    Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
                                                                                    if (obj instanceof PostData) {
                                                                                        PostData postData = (PostData) obj;
                                                                                        if (postData.getType() != PostData.iYB && !TextUtils.isEmpty(postData.getBimg_url()) && i.abb().abf()) {
                                                                                            NewSubPbActivity.this.BA(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.hEK != null && !TextUtils.isEmpty(NewSubPbActivity.this.hEL)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.aiM();
                                                                                NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.aa(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.fQB == null) {
                                                                                        NewSubPbActivity.this.fQB = new au(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.fQB.h(NewSubPbActivity.this.hEL, NewSubPbActivity.this.hEK.nv());
                                                                                    NewSubPbActivity.this.hEK = null;
                                                                                    NewSubPbActivity.this.hEL = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.hEK != null && !TextUtils.isEmpty(NewSubPbActivity.this.hEL)) {
                                                                            if (NewSubPbActivity.this.hEM == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hEL));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.hEL;
                                                                                aVar.pkgId = NewSubPbActivity.this.hEM.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hEM.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.hEK = null;
                                                                            NewSubPbActivity.this.hEL = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.ggM != null) {
                                                                        NewSubPbActivity.this.ggM.ek(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.ggM = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.hTm.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.ct(view);
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (!com.baidu.adp.lib.util.j.jS()) {
                                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                            return;
                                                        } else {
                                                            Object tag = view.getTag();
                                                            if (tag instanceof String) {
                                                                NewSubPbActivity.this.Ba((String) tag);
                                                                return;
                                                            } else if (tag instanceof SparseArray) {
                                                                SparseArray<Object> sparseArray3 = (SparseArray) tag;
                                                                if ((sparseArray3.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray3.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                                    sparseArray3.put(R.id.tag_from, 0);
                                                                    sparseArray3.put(R.id.tag_check_mute_from, 2);
                                                                    NewSubPbActivity.this.c(sparseArray3);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        NewSubPbActivity.this.hTB = (j) view.getTag();
                                                        if (bc.cE(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.hTx) {
                                                                NewSubPbActivity.this.hTx = false;
                                                                return;
                                                            } else if (NewSubPbActivity.this.gPK == null || NewSubPbActivity.this.hTk == null || NewSubPbActivity.this.hTk.biW() == null || NewSubPbActivity.this.gPK.hZ(NewSubPbActivity.this.hTk.biW().replyPrivateFlag)) {
                                                                if (NewSubPbActivity.this.hTy != null) {
                                                                    NewSubPbActivity.this.hTy.bnT();
                                                                }
                                                                SparseArray sparseArray4 = (SparseArray) view.getTag(R.id.tag_from);
                                                                if (sparseArray4 != null) {
                                                                    if (sparseArray4.get(R.id.tag_clip_board) instanceof PostData) {
                                                                        PostData postData2 = (PostData) sparseArray4.get(R.id.tag_clip_board);
                                                                        if (postData2 != null && postData2.adv() != null) {
                                                                            MetaData adv = postData2.adv();
                                                                            NewSubPbActivity.this.gPS.setReplyId(adv.getUserId());
                                                                            if (!(sparseArray4.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.tag_is_subpb)).booleanValue() : true)) {
                                                                                NewSubPbActivity.this.gPS.qh("");
                                                                            } else {
                                                                                NewSubPbActivity.this.gPS.qh(adv.getName_show());
                                                                            }
                                                                        }
                                                                        NewSubPbActivity.this.hTm.bWa();
                                                                    }
                                                                    if (NewSubPbActivity.this.hTA) {
                                                                        NewSubPbActivity.this.pa(false);
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    }
                                                } else if (view.getTag() != null && (view.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                    if (sparseArray5.get(R.id.tag_clip_board) instanceof PostData) {
                                                        ((PostData) sparseArray5.get(R.id.tag_clip_board)).ek(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new am("c11739").P("obj_locate", 4));
                                            if (!com.baidu.adp.lib.util.j.jS()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.hTm.bUP();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.Ba(str4);
                                                    return;
                                                }
                                                return;
                                            } else if (tag2 instanceof SparseArray) {
                                                SparseArray<Object> sparseArray6 = (SparseArray) tag2;
                                                if ((sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray6.put(R.id.tag_from, 0);
                                                    sparseArray6.put(R.id.tag_check_mute_from, 2);
                                                    NewSubPbActivity.this.c(sparseArray6);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        } else if (com.baidu.adp.lib.util.j.jS()) {
                                            NewSubPbActivity.this.hTm.bUP();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.cD(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.hTm.bUP();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.hTm.a(((Integer) sparseArray7.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray7.get(R.id.tag_del_post_id), ((Integer) sparseArray7.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new am("c11739").P("obj_locate", 2));
                                    NewSubPbActivity.this.hTm.bUP();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.hTk.bWu() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.hTk.bWu().bQr());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.hTm.bVZ();
                                NewSubPbActivity.this.hTm.bWa();
                                if (NewSubPbActivity.this.gPS != null) {
                                    NewSubPbActivity.this.gPS.arR();
                                    if (NewSubPbActivity.this.hTy != null) {
                                        NewSubPbActivity.this.hTy.bnT();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.hTm.bVZ();
                            NewSubPbActivity.this.hTm.bWa();
                            if (NewSubPbActivity.this.gPS != null) {
                                NewSubPbActivity.this.gPS.arQ();
                                if (NewSubPbActivity.this.hTy != null) {
                                    NewSubPbActivity.this.hTy.bnT();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.bRj();
                        if (NewSubPbActivity.this.hTk != null && NewSubPbActivity.this.hTk.bWu() != null && NewSubPbActivity.this.hTk.bWu().abv() != null && NewSubPbActivity.this.hTk.bWu().abv().adv() != null) {
                            TiebaStatic.log(new am("c13402").bT("tid", NewSubPbActivity.this.hTk.bSF()).l("fid", NewSubPbActivity.this.hTk.bWu().abv().getFid()).P("obj_locate", 5).bT("uid", NewSubPbActivity.this.hTk.bWu().abv().adv().getUserId()));
                        }
                    }
                }
            }
        };
        this.hTo = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.hTm.bUP();
                }
                NewSubPbActivity.this.gPS.arP();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.hTm.bWp();
            }
        };
        this.hFv = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.hTk.bWu() != null) {
                    postData = NewSubPbActivity.this.hTk.bWu().bQr();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.ek(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.f(postData);
                    }
                }
            }
        };
        this.clk = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            /* JADX WARN: Removed duplicated region for block: B:111:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
            /* JADX WARN: Removed duplicated region for block: B:92:0x0293  */
            @Override // android.view.View.OnLongClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onLongClick(View view) {
                SparseArray<Object> sparseArray;
                SparseArray<Object> sparseArray2;
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null && NewSubPbActivity.this.cu(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.hEK = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.hEL = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.hEK != null && !TextUtils.isEmpty(NewSubPbActivity.this.hEL)) {
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hEM = null;
                            } else {
                                NewSubPbActivity.this.hEM = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                NewSubPbActivity.this.hTm.a(NewSubPbActivity.this.hFw, NewSubPbActivity.this.hEK.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                NewSubPbActivity.this.ggM = (PostData) sparseArray2.get(R.id.tag_clip_board);
                                if (NewSubPbActivity.this.ggM != null && NewSubPbActivity.this.hEj != null) {
                                    if (NewSubPbActivity.this.hEj != null) {
                                        NewSubPbActivity.this.hEj.ds(NewSubPbActivity.this.hTk.isMarked());
                                    }
                                    boolean z = NewSubPbActivity.this.hEj.ZC() && NewSubPbActivity.this.ggM.getId() != null && NewSubPbActivity.this.ggM.getId().equals(NewSubPbActivity.this.hTk.bWB());
                                    if (NewSubPbActivity.this.hTn == null) {
                                        NewSubPbActivity.this.hTn = new y(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.mCommonClickListener);
                                        NewSubPbActivity.this.hTm.cE(NewSubPbActivity.this.hTn.getView());
                                        NewSubPbActivity.this.hTn.or(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.hTn.showDialog();
                                    boolean isLogin = NewSubPbActivity.this.isLogin() & NewSubPbActivity.this.nY(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false);
                                    boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                                    if (z) {
                                        NewSubPbActivity.this.hTn.bTv().setText(R.string.remove_mark);
                                    } else {
                                        NewSubPbActivity.this.hTn.bTv().setText(R.string.mark);
                                    }
                                    if (booleanValue) {
                                        NewSubPbActivity.this.hTn.bTv().setVisibility(8);
                                    } else {
                                        NewSubPbActivity.this.hTn.bTv().setVisibility(0);
                                    }
                                    if (NewSubPbActivity.this.cu(view)) {
                                        if (NewSubPbActivity.this.hEK != null && !NewSubPbActivity.this.hEK.isGif()) {
                                            sparseArray2.put(R.id.tag_richtext_image, true);
                                        } else {
                                            sparseArray2.put(R.id.tag_richtext_image, false);
                                        }
                                        sparseArray2.put(R.id.tag_richtext_emotion, true);
                                    } else {
                                        sparseArray2.put(R.id.tag_richtext_image, false);
                                        sparseArray2.put(R.id.tag_richtext_emotion, false);
                                    }
                                    NewSubPbActivity.this.hTn.a(sparseArray2, NewSubPbActivity.this.bPU(), isLogin);
                                }
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            NewSubPbActivity.this.hEK = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                NewSubPbActivity.this.hEL = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hEM = null;
                            } else {
                                NewSubPbActivity.this.hEM = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.hEK = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.hEL = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.hEM = null;
                        } else {
                            NewSubPbActivity.this.hEM = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    }
                    if (!(view.getParent() instanceof TbRichTextView)) {
                    }
                    if (sparseArray2 != null) {
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 != null) {
                }
                return true;
            }
        };
        this.hTp = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void f(View view, String str) {
                NewSubPbActivity.this.r(null, str, "LINK_IMAGE");
            }
        };
        this.hTq = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
            /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX DEBUG: Multi-variable search result rejected for r2v44, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
            public void a(View view, String str, int i, boolean z, boolean z2) {
                String str2;
                boolean z3;
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap;
                int i2;
                boolean z4;
                ArrayList<String> arrayList;
                String str3;
                boolean z5;
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2;
                boolean z6;
                try {
                    if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        k bWu = NewSubPbActivity.this.hTk.bWu();
                        TbRichText bd = NewSubPbActivity.this.bd(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bd != null && bd.axy() != null) {
                            tbRichTextData = bd.axy().get(NewSubPbActivity.this.hFt);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.axF().axR()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (bWu == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (bWu.bQx() != null) {
                                        str4 = bWu.bQx().getName();
                                        str5 = bWu.bQx().getId();
                                    }
                                    if (bWu.abv() != null) {
                                        str6 = bWu.abv().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.hTk.bWG() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.hTk.bWG();
                                    z6 = NewSubPbActivity.this.hTk.bWI();
                                    arrayList2 = NewSubPbActivity.this.hTk.bWH();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.c(arrayList2, 0));
                                NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                                return;
                            }
                            NewSubPbActivity.this.hFu = false;
                            String str7 = "";
                            TbRichText cmw = bWu.bQr().cmw();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(cmw, bd, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (bWu == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (bWu.bQx() != null) {
                                    str8 = bWu.bQx().getName();
                                    str9 = bWu.bQx().getId();
                                }
                                if (bWu.abv() != null) {
                                    str10 = bWu.abv().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.hTk.bWG() != null) {
                                concurrentHashMap = NewSubPbActivity.this.hTk.bWG();
                                z4 = NewSubPbActivity.this.hTk.bWI();
                                arrayList = NewSubPbActivity.this.hTk.bWH();
                                i2 = a2 + NewSubPbActivity.this.hTk.getOffset();
                            } else {
                                concurrentHashMap = concurrentHashMap3;
                                i2 = a2;
                                z4 = z3;
                                arrayList = arrayList2;
                            }
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(v.c(arrayList, i2));
                            NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList4, 0, str8, str9, str2, z4, str7, true, concurrentHashMap, true, false, false)));
                            return;
                        }
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            f(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo axF;
        if (tbRichText == tbRichText2) {
            this.hFu = true;
        }
        if (tbRichText != null && tbRichText.axy() != null) {
            int size = tbRichText.axy().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.axy().get(i6) != null && tbRichText.axy().get(i6).getType() == 8) {
                    i5++;
                    int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                    int width = tbRichText.axy().get(i6).axF().getWidth() * ai;
                    int height = tbRichText.axy().get(i6).axF().getHeight() * ai;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.axy().get(i6).axF().axR()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.axy().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (axF = tbRichTextData.axF()) != null) {
                            String axT = axF.axT();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = axT;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.hFu) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (this.hTn != null) {
            this.hTn.or(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo axF = tbRichTextData.axF();
        if (axF != null) {
            if (!StringUtils.isNull(axF.axQ())) {
                return axF.axQ();
            }
            if (axF.getHeight() * axF.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (axF.getHeight() * axF.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (axF.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * axF.getHeight())));
            } else {
                float width = axF.getWidth() / axF.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ap.bh(axF.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bd(String str, int i) {
        if (this.hTk == null || this.hTk.bWu() == null || str == null || i < 0) {
            return null;
        }
        k bWu = this.hTk.bWu();
        TbRichText a2 = a(bWu.bQr(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bWu.bQr(), str, i);
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
        TbRichText cmw = postData.cmw();
        if (cmw != null) {
            ArrayList<TbRichTextData> axy = cmw.axy();
            int size = axy.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (axy.get(i3) != null && axy.get(i3).getType() == 8) {
                    i2++;
                    if (axy.get(i3).axF().axT().equals(str)) {
                        int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                        int width = axy.get(i3).axF().getWidth() * ai;
                        int height = axy.get(i3).axF().getHeight() * ai;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.hFt = i3;
                        return cmw;
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
    public void bRj() {
        if (this.fsw == null) {
            this.fsw = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.fsw.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jV(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void n(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jW(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.gPK == null || NewSubPbActivity.this.hTk == null || NewSubPbActivity.this.hTk.biW() == null || NewSubPbActivity.this.gPK.hZ(NewSubPbActivity.this.hTk.biW().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.gPS.arG()) {
                                NewSubPbActivity.this.gPS.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.hTm.bVZ();
                            NewSubPbActivity.this.hTm.bWa();
                            if (NewSubPbActivity.this.gPS != null) {
                                NewSubPbActivity.this.gPS.arS();
                                if (NewSubPbActivity.this.hTy != null) {
                                    NewSubPbActivity.this.hTy.bnT();
                                }
                            }
                        }
                    }
                }
            });
        }
        if (this.hTk != null && this.hTk.bWu() != null && this.hTk.bWu().bQx() != null) {
            this.fsw.t(this.hTk.bWu().bQx().getId(), com.baidu.adp.lib.g.b.c(this.hTk.bSF(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nY(boolean z) {
        if (this.hTk == null) {
            return false;
        }
        return ((bPU() != 0) || this.hTk.bWu() == null || this.hTk.bWu().abv() == null || this.hTk.bWu().abv().adv() == null || TextUtils.equals(this.hTk.bWu().abv().adv().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Context context, String str, String str2) {
        long templateId = this.hTk.bWu().bQr().cmD() != null ? this.hTk.bWu().bQr().cmD().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ba.aiz().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.hTk.bWu().bQx().getId(), this.hTk.bWu().bQx().getName(), this.hTk.bWu().abv().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i, String str) {
        if (this.hTk.bWv()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.ki()) {
            if (i == 4) {
                this.hTm.uL(str + "(4)");
            } else {
                this.hTm.oH(R.string.no_data_text);
            }
        } else {
            this.hTm.oH(R.string.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.gPS = (g) new h().cJ(getActivity());
        if (this.gPS != null) {
            this.gPS.a(getPageContext());
            this.gPS.b(this.hTk);
            this.gPS.b(this.ggk);
            this.gPS.a(this.csw);
            this.gPS.a(this.csx);
            this.gPS.aqS().fd(true);
            this.gPS.e(getPageContext());
        }
        if (this.hTm != null) {
            this.hTm.g(this.gPS);
        }
        if (this.gPS != null && this.hTk != null) {
            this.gPS.a(this.hTk.biW());
            this.gPS.arP();
        }
        if (this.gPS != null) {
            this.gPS.arT().setDefaultHint(bUf());
            this.gPS.arT().setHint(bUf());
            this.gge = this.gPS.arT().getInputView();
            this.gge.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.ggd != null) {
                        if (!NewSubPbActivity.this.ggd.cwf()) {
                            NewSubPbActivity.this.lj(false);
                        }
                        NewSubPbActivity.this.ggd.rK(false);
                    }
                }
            });
        }
    }

    public void bVW() {
        if (!TbadkCoreApplication.isLogin()) {
            this.gPS.arP();
        } else if (!StringUtils.isNull(this.hTk.bWC())) {
            if (this.hTm.bWd() && com.baidu.adp.lib.util.l.ki()) {
                this.hTm.bgm();
            } else {
                this.hTm.bWg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(R.id.tag_from, 1);
                    c(sparseArray);
                } else {
                    this.hTm.cA(view);
                }
            } else if (booleanValue2) {
                this.hTm.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.hTm.bWm(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        final String str;
        if (!(sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
            String[] strArr = new String[1];
            strArr[0] = z ? getResources().getString(R.string.un_mute) : getResources().getString(R.string.mute);
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            bVar.hs(R.string.operation);
            bVar.a(strArr, new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    switch (i) {
                        case 0:
                            String str2 = "";
                            String str3 = "";
                            String str4 = "";
                            String str5 = "";
                            String str6 = "";
                            if (sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String) {
                                str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            }
                            if (sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String) {
                                str3 = (String) sparseArray.get(R.id.tag_user_mute_thread_id);
                            }
                            if (sparseArray.get(R.id.tag_user_mute_post_id) instanceof String) {
                                str4 = (String) sparseArray.get(R.id.tag_user_mute_post_id);
                            }
                            if (sparseArray.get(R.id.tag_user_mute_msg) instanceof String) {
                                str5 = (String) sparseArray.get(R.id.tag_user_mute_msg);
                            }
                            if (sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String) {
                                str6 = (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow);
                            }
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.hTw);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.hTw);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).afJ();
        }
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.hTm.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.hTw;
        userMuteCheckCustomMessage.setTag(this.hTw);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.hTm.a(0, bVar.FN, bVar.jbh, z);
            if (bVar.FN) {
                if (bVar.eVs == 1) {
                    if (this.hTm.getListView() instanceof BdTypeListView) {
                        List<m> data = ((BdTypeListView) this.hTm.getListView()).getData();
                        if (!v.aa(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.hTm.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.eVs == 2) {
                    this.hTk.BC(bVar.mPostId);
                    this.hTm.a(this.hTk.bWu(), this.hTk.bPU(), this.hTk.bWG() != null);
                    if (this.hTk.bWD()) {
                        this.hTk.pd(false);
                        this.hTm.bWb();
                        this.hTk.atv();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
            }
        }
    }

    public void Ba(String str) {
        this.hEi.By(str);
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.hTk.isMarked() && postData.getId() != null && postData.getId().equals(this.hTk.bWB())) {
                z = true;
            }
            MarkData j = this.hTk.j(postData);
            if (j != null) {
                this.hTm.bUP();
                if (this.hEj != null) {
                    this.hEj.a(j);
                    if (!z) {
                        this.hEj.ZE();
                    } else {
                        this.hEj.ZD();
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.hTk != null) {
            this.hTk.ab(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.gPS != null) {
            this.gPS.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.gPS.aqS().app();
        this.gPS.arP();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gPS.b(writeData);
                this.gPS.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k kj = this.gPS.aqS().kj(6);
                if (kj != null && kj.cqE != null) {
                    kj.cqE.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gPS.arL();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.foO != null) {
            this.foO.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.ddX = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.Yk().Yp();
        if (this.foO != null) {
            this.foO.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.gtJ);
        this.hTm.bqg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.ddX = false;
        super.onResume();
        bRR();
        if (this.foO != null) {
            this.foO.onResume(getPageContext());
        }
        registerListener(this.gtJ);
        this.hTm.bqh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.foO != null) {
            this.foO.onStop(getPageContext());
        }
        this.gPS.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.hTz));
        this.hTk.cancelLoadData();
        this.hTk.destory();
        this.hTl.cancelLoadData();
        if (this.foO != null) {
            this.foO.onDestory(getPageContext());
        }
        this.hTm.bUP();
        this.hTm.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.hFi);
        MessageManager.getInstance().unRegisterListener(this.hFj);
        MessageManager.getInstance().unRegisterListener(this.hFk);
        MessageManager.getInstance().unRegisterListener(this.hTw);
        this.hEG = null;
        this.hEH = null;
        if (this.gPK != null) {
            this.gPK.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hTm.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.foO;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bWh = this.hTm.bWh();
        if (bWh == null || (findViewWithTag = bWh.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Br(String str) {
        Map<String, String> nW;
        if (!TextUtils.isEmpty(str) && (nW = ba.nW(ba.nX(str))) != null) {
            this.hTx = true;
            String str2 = nW.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Br(com.baidu.adp.lib.util.k.bi(str2));
            }
            String str3 = nW.get(hTj);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void d(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (Br(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                    kVar.mLink = str;
                    kVar.type = 3;
                    kVar.cpF = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
                }
            } else {
                ba.aiz().c(getPageContext(), new String[]{str});
            }
            this.hTx = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hTx = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ap(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void n(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.hTm != null) {
            return this.hTm.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int ayf() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> ayh() {
        if (this.cLs == null) {
            this.cLs = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cLs;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> ayi() {
        if (this.cIE == null) {
            this.cIE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bRT */
                public GifView makeObject() {
                    return new GifView(NewSubPbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void destroyObject(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView activateObject(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView passivateObject(GifView gifView) {
                    return gifView;
                }
            }, 20, 0);
        }
        return this.cIE;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> ayg() {
        if (this.cID == null) {
            this.cID = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.adp.lib.e.c
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean abf = i.abb().abf();
                    foreDrawableImageView.setDefaultBg(al.getDrawable(R.color.common_color_10220));
                    if (abf) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                public void destroyObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.cp_bg_line_c);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (i.abb().abf()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(R.drawable.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                public ImageView passivateObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.cID;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> ayj() {
        if (this.cLt == null) {
            this.cLt = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bRU */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cv */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cw */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cx */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.cLt;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> ayk() {
        if (this.cLu == null) {
            this.cLu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bRW */
                public LinearLayout makeObject() {
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
                /* renamed from: d */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: e */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: f */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.cLu;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> ayl() {
        this.cLv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bRV */
            public RelativeLayout makeObject() {
                return new RelativeLayout(NewSubPbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void destroyObject(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout activateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout passivateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.cLv;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bQD() {
        return this.hEm;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bQE() {
        return (this.hTk == null || this.hTk.bWu() == null || this.hTk.bWu().abv() == null || this.hTk.bWu().abv().aeN()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bQF() {
        if (this.hTk == null || this.hTk.bWu() == null || this.hTk.bWu().abv() == null) {
            return null;
        }
        return this.hTk.bWu().abv().adA();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bQG() {
        if (this.hTk == null) {
            return 0;
        }
        return this.hTk.bPU();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean AX(String str) {
        if (StringUtils.isNull(str) || this.hTk == null || this.hTk.bWu() == null || this.hTk.bWu().abv() == null || this.hTk.bWu().abv().adv() == null) {
            return false;
        }
        return str.equals(this.hTk.bWu().abv().adv().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hTm.bWd() && com.baidu.adp.lib.util.l.ki()) {
            this.hTk.atv();
        } else {
            this.hTm.bWg();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String) {
            str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
        }
        if (sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String) {
            str4 = (String) sparseArray.get(R.id.tag_user_mute_thread_id);
        }
        if (!(sparseArray.get(R.id.tag_user_mute_post_id) instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) sparseArray.get(R.id.tag_user_mute_post_id);
        }
        String str7 = sparseArray.get(R.id.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_msg) : str2;
        if (sparseArray.get(R.id.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(R.id.tag_user_mute_msg);
        }
        if (sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String) {
            str6 = (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.hTw);
        userMuteAddAndDelCustomMessage.setTag(this.hTw);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BA(String str) {
        if (!StringUtils.isNull(str) && bc.cE(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("bubble_link", "");
            if (!StringUtils.isNull(string)) {
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                    return;
                }
                com.baidu.tbadk.browser.a.a(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), string + "?props_id=" + str, true, true, true);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aq(Context context, String str) {
        r(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public com.baidu.tbadk.o.b getPageStayFilter() {
        return new com.baidu.tbadk.o.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.o.b
            public boolean atL() {
                return false;
            }

            @Override // com.baidu.tbadk.o.b
            public int atM() {
                return com.baidu.tbadk.o.e.atQ().atT();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.hTk != null) {
            if (this.hTk.bWu() != null && this.hTk.bWu().bQx() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.hTk.bWu().bQx().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.hTk.bSF(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.ddX;
    }

    public boolean bVX() {
        if (this.hTk != null) {
            return this.hTk.bVX();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hTm.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hEG.getPageActivity());
        if (ap.isEmpty(str)) {
            aVar.mE(this.hEG.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.mE(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.hTm.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hEG).afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qf(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hEG.getPageActivity());
        aVar.mE(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hEG).afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRN() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.mE(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.hEG).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.hEG.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hEG).afG();
    }

    public SubPbModel bVY() {
        return this.hTk;
    }

    public int bPU() {
        if (this.hTk != null) {
            return this.hTk.bPU();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.crd) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.crd) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void lj(boolean z) {
        if (this.gge != null && this.gge.getText() != null) {
            int selectionEnd = this.gge.getSelectionEnd();
            SpannableStringBuilder b = this.ggd.b(this.gge.getText());
            if (b != null) {
                this.ggd.rK(true);
                this.gge.setText(b);
                if (z && this.ggd.cwd() >= 0) {
                    this.gge.requestFocus();
                    this.gge.setSelection(this.ggd.cwd());
                } else {
                    this.gge.setSelection(selectionEnd);
                }
                this.ggd.rJ(this.ggd.cwd() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gPS != null && this.gPS.aqS() != null && this.gPS.aqS().aqV()) {
            this.gPS.aqS().app();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    public String bUf() {
        if (!ap.isEmpty(this.hPv)) {
            return this.hPv;
        }
        this.hPv = getResources().getString(com.baidu.tieba.pb.pb.main.ap.bTX());
        return this.hPv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.hTA = z;
        pa(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pa(boolean z) {
        View childAt;
        Rect rect = new Rect();
        FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
        if (frameLayout != null && (childAt = frameLayout.getChildAt(0)) != null) {
            frameLayout.getWindowVisibleDisplayFrame(rect);
            if (z) {
                ((FrameLayout.LayoutParams) childAt.getLayoutParams()).height = rect.height();
                childAt.requestLayout();
            }
        }
        if (this.hTm != null && this.hTm.getListView() != null && this.hTB != null && this.hTB.mPosition != -1) {
            final int headerViewsCount = this.hTB.mPosition + this.hTm.getListView().getHeaderViewsCount();
            if (this.hTB.getView() != null) {
                final int height = this.hTB.getView().getHeight() - ((rect.height() - this.hTm.getNavigationBarHeight()) - this.hTm.bWr());
                if (height > 0) {
                    this.hTm.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.hTm != null && NewSubPbActivity.this.hTm.getListView() != null) {
                                NewSubPbActivity.this.hTm.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.hTm.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.hTm.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.hTm != null && NewSubPbActivity.this.hTm.getListView() != null) {
                                NewSubPbActivity.this.hTm.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.hTm.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }

    private void bRR() {
        if (this.hTk != null && !ap.isEmpty(this.hTk.bSF())) {
            com.baidu.tbadk.BdToken.c.Yk().k(com.baidu.tbadk.BdToken.b.bwW, com.baidu.adp.lib.g.b.c(this.hTk.bSF(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.hTk == null || ap.isEmpty(this.hTk.bSF())) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.c(this.hTk.bSF(), 0L);
    }
}
