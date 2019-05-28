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
    private static final String hRD = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String hTm = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> cID;
    private com.baidu.adp.lib.e.b<GifView> cIE;
    private com.baidu.adp.lib.e.b<TextView> cLs;
    private com.baidu.adp.lib.e.b<View> cLt;
    private com.baidu.adp.lib.e.b<LinearLayout> cLu;
    private com.baidu.adp.lib.e.b<RelativeLayout> cLv;
    private View.OnLongClickListener clk;
    private au fQC;
    private VoiceManager foP;
    private com.baidu.tieba.frs.profession.permission.c fsx;
    public aj gPM;
    private g gPU;
    private com.baidu.tieba.write.b gge;
    private EditText ggf;
    private com.baidu.adp.base.e hEJ;
    private com.baidu.tbadk.core.view.e hEK;
    private com.baidu.adp.widget.ImageView.a hEN;
    private String hEO;
    private TbRichTextMemeInfo hEP;
    private com.baidu.tieba.pb.pb.report.a hEl;
    private com.baidu.tbadk.baseEditMark.a hEm;
    private com.baidu.tieba.pb.pb.main.b.a hEp;
    private b.a hFy;
    private PostWriteCallBackData hIU;
    private String hPy;
    private com.baidu.tieba.pb.pb.sub.a hTB;
    private com.baidu.tieba.pb.e<k> hTC;
    private boolean hTD;
    private j hTE;
    private SubPbModel hTn;
    private ForumManageModel hTo;
    private b hTp;
    private y hTq;
    private AbsListView.OnScrollListener hTr;
    private TbRichTextView.i hTs;
    private TbRichTextView.h hTt;
    private SubPbModel.a hTu;
    private com.baidu.adp.base.d hTv;
    private BdUniqueId hTz;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int hFw = 0;
    PostData ggN = null;
    private a.InterfaceC0236a hFt = null;
    private a hTw = null;
    private a hTx = null;
    private boolean ddY = false;
    private boolean hTy = false;
    private boolean hTA = false;
    private boolean crd = false;
    private com.baidu.tbadk.editortools.pb.c csw = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void arr() {
            NewSubPbActivity.this.hTp.bWi();
        }
    };
    private com.baidu.tbadk.editortools.pb.b csx = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean arq() {
            if (!NewSubPbActivity.this.gge.cwg()) {
                return (NewSubPbActivity.this.gPM == null || NewSubPbActivity.this.hTn == null || NewSubPbActivity.this.hTn.biZ() == null || NewSubPbActivity.this.gPM.R(NewSubPbActivity.this.hTn.biZ().replyPrivateFlag, aj.bSh)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.gge.cwi());
            if (NewSubPbActivity.this.gPU.arG()) {
                NewSubPbActivity.this.gPU.a(NewSubPbActivity.this.hIU);
            }
            NewSubPbActivity.this.lj(true);
            return true;
        }
    };
    private NewWriteModel.d ggl = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.gPU != null && NewSubPbActivity.this.gPU.aqS() != null) {
                NewSubPbActivity.this.gPU.aqS().hide();
                if (NewSubPbActivity.this.hTn.bWD()) {
                    TiebaStatic.log(new am("c10367").bT("post_id", NewSubPbActivity.this.hTn.aro()));
                }
            }
            if (z) {
                NewSubPbActivity.this.gge.FE(null);
                NewSubPbActivity.this.gge.aI(null);
                NewSubPbActivity.this.gge.rJ(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.gge.aI(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.gge.FE(postWriteCallBackData.getErrorString());
                if (!v.aa(NewSubPbActivity.this.gge.cwe())) {
                    NewSubPbActivity.this.hIU = postWriteCallBackData;
                    if (NewSubPbActivity.this.gPU.arG()) {
                        NewSubPbActivity.this.gPU.a(NewSubPbActivity.this.hIU);
                    }
                    NewSubPbActivity.this.lj(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.gPM != null) {
                NewSubPbActivity.this.gPM.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.hTp.bWj();
        }
    };
    private CustomMessageListener hFl = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hTz) {
                NewSubPbActivity.this.hTp.aSG();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hEK.i(NewSubPbActivity.this.hEJ.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.hEJ.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.qf(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bRQ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ap.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.hEJ.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.hEK.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hFm = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hTz) {
                NewSubPbActivity.this.hTp.aSG();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hEK.i(NewSubPbActivity.this.hEJ.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ap.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.hEJ.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.hEK.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hFn = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hTz) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.hTp.aSG();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.jnc;
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
                    NewSubPbActivity.this.hTp.a(sparseArray, z);
                }
            }
        }
    };
    boolean hFx = false;
    private final b.a hFz = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.hEN != null && !TextUtils.isEmpty(NewSubPbActivity.this.hEO)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.hEP == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hEO));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.hEO;
                        aVar.pkgId = NewSubPbActivity.this.hEP.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hEP.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.aiM();
                    NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.aa(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.fQC == null) {
                            NewSubPbActivity.this.fQC = new au(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.fQC.h(NewSubPbActivity.this.hEO, NewSubPbActivity.this.hEN.nv());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.hEN = null;
                NewSubPbActivity.this.hEO = null;
            }
        }
    };
    private CustomMessageListener gtK = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener fql = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    l lVar = (l) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.hTn.bWx() != null && NewSubPbActivity.this.hTn.bWx().bQu() != null && NewSubPbActivity.this.hTn.bWx().bQu().adv() != null && currentAccount.equals(NewSubPbActivity.this.hTn.bWx().bQu().adv().getUserId()) && NewSubPbActivity.this.hTn.bWx().bQu().adv().getPendantData() != null) {
                        NewSubPbActivity.this.hTn.bWx().bQu().adv().getPendantData().ml(lVar.abS());
                        NewSubPbActivity.this.hTn.bWx().bQu().adv().getPendantData().bg(lVar.aqx());
                        NewSubPbActivity.this.hTp.a(NewSubPbActivity.this.hTn.bWx().bQu(), NewSubPbActivity.this.hTn.bWx().bDd(), NewSubPbActivity.this.hTn.bWx().ZC(), NewSubPbActivity.this.hTn.bPX(), NewSubPbActivity.this.hTn.bWJ() != null);
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
        this.hEJ = getPageContext();
        this.hTy = true;
        this.gge = new com.baidu.tieba.write.b();
        this.gge.Cc(R.color.cp_cont_h_alpha85);
        this.gge.Cb(R.color.cp_btn_a);
        bnS();
        bVY();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bVX();
        this.hEK = new com.baidu.tbadk.core.view.e();
        this.hEK.bXF = 1000L;
        registerListener(this.hFn);
        registerListener(this.hFl);
        registerListener(this.hFm);
        this.hTz = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hTz;
        userMuteAddAndDelCustomMessage.setTag(this.hTz);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hTz;
        userMuteCheckCustomMessage.setTag(this.hTz);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.gPM = new aj(getPageContext());
        this.gPM.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.gPU.arL();
                }
            }
        });
        this.hEl = new com.baidu.tieba.pb.pb.report.a(this);
        this.hEl.r(getUniqueId());
        this.hEp = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    private void bVX() {
        if (this.hTp != null && this.hTn != null && this.hTn.bWa()) {
            this.hTB = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.hTp.aJC());
            this.hTB.bnX();
            this.hTB.a(new a.InterfaceC0380a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
                private boolean fDx = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0380a
                public void bnT() {
                    NewSubPbActivity.this.hTp.kt(false);
                    this.fDx = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0380a
                public void bnU() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0380a
                public boolean bnV() {
                    if (!this.fDx) {
                        return NewSubPbActivity.this.hTp.boj() != null && NewSubPbActivity.this.hTp.boj().getTop() == 0;
                    }
                    this.fDx = false;
                    return false;
                }
            });
            this.hTp.e(this.hTB);
            this.hTp.kt(true);
        }
    }

    public void initUI() {
        this.hTp = new b(this, this.mCommonClickListener);
        this.hTp.a(this.hTn);
        setContentView(this.hTp.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.hTp.setOnScrollListener(this.hTr);
        this.hTp.b(this);
        this.hTp.setOnLinkImageClickListener(this.hTs);
        this.hTp.setOnImageClickListener(this.hTt);
        this.hTp.nR(true);
        this.hTp.setOnLongClickListener(this.clk);
        this.hTp.d(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.40
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.hTn != null) {
                    NewSubPbActivity.this.hTn.atv();
                }
            }
        });
        this.hTp.a(this.hTw);
        this.hTp.b(this.hTx);
        if (this.hTn != null && this.hTn.bWa() && !this.hTn.bWI()) {
            this.hTp.bWn().setVisibility(8);
        } else {
            this.hTp.bWn().setVisibility(0);
        }
        if (this.hTn != null && !this.hTn.bWa()) {
            this.hTp.setIsFromPb(false);
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
        this.hTn = new SubPbModel(getPageContext());
        this.hTn.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                NewSubPbActivity.this.hTp.p(postData);
                NewSubPbActivity.this.hTp.b((BdListView.e) null);
            }
        });
        this.hTo = new ForumManageModel(getPageContext());
        this.hTo.setLoadDataCallBack(this.hTv);
        this.foP = new VoiceManager();
        this.foP.onCreate(getPageContext());
        this.hEm = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hEm != null) {
            this.hEm.a(this.hFt);
        }
        if (bundle != null) {
            this.hTn.initWithBundle(bundle);
        } else {
            this.hTn.initWithIntent(getIntent());
        }
        this.hTn.a(this.hTu);
        if (this.hTn.bWa()) {
            this.hTn.atv();
        } else {
            this.hTn.bWC();
        }
    }

    public void bVY() {
        this.hTu = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, k kVar) {
                if (NewSubPbActivity.this.hTp != null) {
                    NewSubPbActivity.this.hTp.bWj();
                }
                if (NewSubPbActivity.this.hTB != null && NewSubPbActivity.this.hTB.bnY()) {
                    NewSubPbActivity.this.hTB.rT(R.color.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.aC(i, str);
                    return;
                }
                NewSubPbActivity.this.hTp.hideNoDataView();
                if (kVar != null) {
                    if (kVar.bQu() != null || NewSubPbActivity.this.hTn != null) {
                        kVar.bQu().a(NewSubPbActivity.this.hTn.bWH());
                    }
                    if (NewSubPbActivity.this.hTp != null) {
                        NewSubPbActivity.this.hTp.a(kVar, NewSubPbActivity.this.hTn.bPX(), NewSubPbActivity.this.hTn.bWJ() != null);
                        if (NewSubPbActivity.this.hTy) {
                            NewSubPbActivity.this.bVZ();
                            NewSubPbActivity.this.hTy = false;
                        }
                    }
                    if (NewSubPbActivity.this.gPU != null) {
                        NewSubPbActivity.this.gPU.a(kVar.biZ());
                    }
                    if (NewSubPbActivity.this.hTC == null) {
                        NewSubPbActivity.this.hTC = new com.baidu.tieba.pb.e();
                    }
                    NewSubPbActivity.this.hTC.setData(kVar);
                    NewSubPbActivity.this.hTC.setType(0);
                    NewSubPbActivity.this.gPM.a(NewSubPbActivity.this.hTn.bWM());
                }
            }
        };
        this.hFt = new a.InterfaceC0236a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0236a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.hEm != null) {
                        NewSubPbActivity.this.hEm.ds(z2);
                    }
                    MarkData ZF = NewSubPbActivity.this.hEm.ZF();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(ZF);
                        if (NewSubPbActivity.this.hEm != null) {
                            if (ZF != null) {
                                NewSubPbActivity.this.hTn.pc(true);
                                NewSubPbActivity.this.hTn.BD(NewSubPbActivity.this.hTn.aro());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.hTp != null) {
                                NewSubPbActivity.this.hTp.pb(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.hTn.pc(false);
                        NewSubPbActivity.this.hTn.BD(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.hTp != null) {
                            NewSubPbActivity.this.hTp.pb(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.hTw = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.hTn.bWx() != null && NewSubPbActivity.this.hTn.bWx().abv() != null && NewSubPbActivity.this.hTn.bWx().abv().adv() != null) {
                    str = String.valueOf(NewSubPbActivity.this.hTn.bWx().abv().adv().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.hTn.bWx().bQA().getId(), NewSubPbActivity.this.hTn.bWx().bQA().getName(), NewSubPbActivity.this.hTn.bWx().abv().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.hTx = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.hTo.cnh() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int f = com.baidu.adp.lib.g.b.f(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int f2 = com.baidu.adp.lib.g.b.f(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.hTn != null && NewSubPbActivity.this.hTn.bWx() != null && NewSubPbActivity.this.hTn.bWx().bQA() != null && NewSubPbActivity.this.hTn.bWx().abv() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.hTo.Ea(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.hTo.a(NewSubPbActivity.this.hTn.bWx().bQA().getId(), NewSubPbActivity.this.hTn.bWx().bQA().getName(), NewSubPbActivity.this.hTn.bWx().abv().getId(), valueOf, f2, f, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.hTv = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.hTp.a(NewSubPbActivity.this.hTo.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.hTo.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.hUx != 1002 || bVar.fTR) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.hTp.a(1, dVar.FN, dVar.jbj, true);
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

    public void bnS() {
        registerListener(this.fql);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v63, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.hTp != null) {
                    if (view == NewSubPbActivity.this.hTp.bWt()) {
                        NewSubPbActivity.this.hTp.bUS();
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
                    } else if (view != NewSubPbActivity.this.hTp.bok()) {
                        if (view != NewSubPbActivity.this.hTp.bWm()) {
                            if (view != NewSubPbActivity.this.hTp.bWl()) {
                                if (view == NewSubPbActivity.this.hTp.bWh()) {
                                    NewSubPbActivity.this.hTp.bUS();
                                    if (NewSubPbActivity.this.hTn.atv()) {
                                        NewSubPbActivity.this.hTp.bWf();
                                    }
                                } else if (view == NewSubPbActivity.this.hTp.bWn() || view == NewSubPbActivity.this.hTp.bWo() || view == NewSubPbActivity.this.hTp.bWq()) {
                                    if (NewSubPbActivity.this.hTA) {
                                        NewSubPbActivity.this.hTA = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.hTn.bSI(), NewSubPbActivity.this.hTn.aro(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.hTn.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.hTn.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.hTp.bWr() == null || view != NewSubPbActivity.this.hTp.bWr().bTy()) {
                                    if (NewSubPbActivity.this.hTp.bWr() == null || view != NewSubPbActivity.this.hTp.bWr().bTB()) {
                                        if (NewSubPbActivity.this.hTp.bWr() == null || view != NewSubPbActivity.this.hTp.bWr().bTz()) {
                                            if (NewSubPbActivity.this.hTp.bWr() == null || view != NewSubPbActivity.this.hTp.bWr().bTA()) {
                                                if (NewSubPbActivity.this.hTp.bWr() == null || view != NewSubPbActivity.this.hTp.bWr().bTC()) {
                                                    if (view == NewSubPbActivity.this.hTp.bWk() || view == NewSubPbActivity.this.hTp.bWq()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.gPU.arO()) {
                                                                NewSubPbActivity.this.gPU.arP();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.gPU.qg(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof j)) {
                                                        if (NewSubPbActivity.this.hTq == null || view != NewSubPbActivity.this.hTq.bTA()) {
                                                            if (NewSubPbActivity.this.hTq == null || view != NewSubPbActivity.this.hTq.bTy()) {
                                                                if (NewSubPbActivity.this.hTq == null || view != NewSubPbActivity.this.hTq.bTB()) {
                                                                    if (NewSubPbActivity.this.hTq == null || view != NewSubPbActivity.this.hTq.bTC()) {
                                                                        if (NewSubPbActivity.this.hTq == null || view != NewSubPbActivity.this.hTq.bTE()) {
                                                                            if (NewSubPbActivity.this.hTq == null || view != NewSubPbActivity.this.hTq.bTF()) {
                                                                                if (NewSubPbActivity.this.hTq != null && view == NewSubPbActivity.this.hTq.bTz()) {
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
                                                                                            NewSubPbActivity.this.hTp.cA(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.hTp.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                        if (postData.getType() != PostData.iYD && !TextUtils.isEmpty(postData.getBimg_url()) && i.abb().abf()) {
                                                                                            NewSubPbActivity.this.BA(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.hEN != null && !TextUtils.isEmpty(NewSubPbActivity.this.hEO)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.aiM();
                                                                                NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.aa(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.fQC == null) {
                                                                                        NewSubPbActivity.this.fQC = new au(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.fQC.h(NewSubPbActivity.this.hEO, NewSubPbActivity.this.hEN.nv());
                                                                                    NewSubPbActivity.this.hEN = null;
                                                                                    NewSubPbActivity.this.hEO = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.hEN != null && !TextUtils.isEmpty(NewSubPbActivity.this.hEO)) {
                                                                            if (NewSubPbActivity.this.hEP == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hEO));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.hEO;
                                                                                aVar.pkgId = NewSubPbActivity.this.hEP.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hEP.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.hEN = null;
                                                                            NewSubPbActivity.this.hEO = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.ggN != null) {
                                                                        NewSubPbActivity.this.ggN.ek(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.ggN = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.hTp.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                        NewSubPbActivity.this.hTE = (j) view.getTag();
                                                        if (bc.cE(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.hTA) {
                                                                NewSubPbActivity.this.hTA = false;
                                                                return;
                                                            } else if (NewSubPbActivity.this.gPM == null || NewSubPbActivity.this.hTn == null || NewSubPbActivity.this.hTn.biZ() == null || NewSubPbActivity.this.gPM.hZ(NewSubPbActivity.this.hTn.biZ().replyPrivateFlag)) {
                                                                if (NewSubPbActivity.this.hTB != null) {
                                                                    NewSubPbActivity.this.hTB.bnW();
                                                                }
                                                                SparseArray sparseArray4 = (SparseArray) view.getTag(R.id.tag_from);
                                                                if (sparseArray4 != null) {
                                                                    if (sparseArray4.get(R.id.tag_clip_board) instanceof PostData) {
                                                                        PostData postData2 = (PostData) sparseArray4.get(R.id.tag_clip_board);
                                                                        if (postData2 != null && postData2.adv() != null) {
                                                                            MetaData adv = postData2.adv();
                                                                            NewSubPbActivity.this.gPU.setReplyId(adv.getUserId());
                                                                            if (!(sparseArray4.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.tag_is_subpb)).booleanValue() : true)) {
                                                                                NewSubPbActivity.this.gPU.qh("");
                                                                            } else {
                                                                                NewSubPbActivity.this.gPU.qh(adv.getName_show());
                                                                            }
                                                                        }
                                                                        NewSubPbActivity.this.hTp.bWd();
                                                                    }
                                                                    if (NewSubPbActivity.this.hTD) {
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
                                            NewSubPbActivity.this.hTp.bUS();
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
                                            NewSubPbActivity.this.hTp.bUS();
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
                                    NewSubPbActivity.this.hTp.bUS();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.hTp.a(((Integer) sparseArray7.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray7.get(R.id.tag_del_post_id), ((Integer) sparseArray7.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new am("c11739").P("obj_locate", 2));
                                    NewSubPbActivity.this.hTp.bUS();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.hTn.bWx() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.hTn.bWx().bQu());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.hTp.bWc();
                                NewSubPbActivity.this.hTp.bWd();
                                if (NewSubPbActivity.this.gPU != null) {
                                    NewSubPbActivity.this.gPU.arR();
                                    if (NewSubPbActivity.this.hTB != null) {
                                        NewSubPbActivity.this.hTB.bnW();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.hTp.bWc();
                            NewSubPbActivity.this.hTp.bWd();
                            if (NewSubPbActivity.this.gPU != null) {
                                NewSubPbActivity.this.gPU.arQ();
                                if (NewSubPbActivity.this.hTB != null) {
                                    NewSubPbActivity.this.hTB.bnW();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.bRm();
                        if (NewSubPbActivity.this.hTn != null && NewSubPbActivity.this.hTn.bWx() != null && NewSubPbActivity.this.hTn.bWx().abv() != null && NewSubPbActivity.this.hTn.bWx().abv().adv() != null) {
                            TiebaStatic.log(new am("c13402").bT("tid", NewSubPbActivity.this.hTn.bSI()).l("fid", NewSubPbActivity.this.hTn.bWx().abv().getFid()).P("obj_locate", 5).bT("uid", NewSubPbActivity.this.hTn.bWx().abv().adv().getUserId()));
                        }
                    }
                }
            }
        };
        this.hTr = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.hTp.bUS();
                }
                NewSubPbActivity.this.gPU.arP();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.hTp.bWs();
            }
        };
        this.hFy = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.hTn.bWx() != null) {
                    postData = NewSubPbActivity.this.hTn.bWx().bQu();
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
                        NewSubPbActivity.this.hEN = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.hEO = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.hEN != null && !TextUtils.isEmpty(NewSubPbActivity.this.hEO)) {
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hEP = null;
                            } else {
                                NewSubPbActivity.this.hEP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                NewSubPbActivity.this.hTp.a(NewSubPbActivity.this.hFz, NewSubPbActivity.this.hEN.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                NewSubPbActivity.this.ggN = (PostData) sparseArray2.get(R.id.tag_clip_board);
                                if (NewSubPbActivity.this.ggN != null && NewSubPbActivity.this.hEm != null) {
                                    if (NewSubPbActivity.this.hEm != null) {
                                        NewSubPbActivity.this.hEm.ds(NewSubPbActivity.this.hTn.isMarked());
                                    }
                                    boolean z = NewSubPbActivity.this.hEm.ZC() && NewSubPbActivity.this.ggN.getId() != null && NewSubPbActivity.this.ggN.getId().equals(NewSubPbActivity.this.hTn.bWE());
                                    if (NewSubPbActivity.this.hTq == null) {
                                        NewSubPbActivity.this.hTq = new y(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.mCommonClickListener);
                                        NewSubPbActivity.this.hTp.cE(NewSubPbActivity.this.hTq.getView());
                                        NewSubPbActivity.this.hTq.or(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.hTq.showDialog();
                                    boolean isLogin = NewSubPbActivity.this.isLogin() & NewSubPbActivity.this.nY(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false);
                                    boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                                    if (z) {
                                        NewSubPbActivity.this.hTq.bTy().setText(R.string.remove_mark);
                                    } else {
                                        NewSubPbActivity.this.hTq.bTy().setText(R.string.mark);
                                    }
                                    if (booleanValue) {
                                        NewSubPbActivity.this.hTq.bTy().setVisibility(8);
                                    } else {
                                        NewSubPbActivity.this.hTq.bTy().setVisibility(0);
                                    }
                                    if (NewSubPbActivity.this.cu(view)) {
                                        if (NewSubPbActivity.this.hEN != null && !NewSubPbActivity.this.hEN.isGif()) {
                                            sparseArray2.put(R.id.tag_richtext_image, true);
                                        } else {
                                            sparseArray2.put(R.id.tag_richtext_image, false);
                                        }
                                        sparseArray2.put(R.id.tag_richtext_emotion, true);
                                    } else {
                                        sparseArray2.put(R.id.tag_richtext_image, false);
                                        sparseArray2.put(R.id.tag_richtext_emotion, false);
                                    }
                                    NewSubPbActivity.this.hTq.a(sparseArray2, NewSubPbActivity.this.bPX(), isLogin);
                                }
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            NewSubPbActivity.this.hEN = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                NewSubPbActivity.this.hEO = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hEP = null;
                            } else {
                                NewSubPbActivity.this.hEP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.hEN = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.hEO = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.hEP = null;
                        } else {
                            NewSubPbActivity.this.hEP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
        this.hTs = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void f(View view, String str) {
                NewSubPbActivity.this.r(null, str, "LINK_IMAGE");
            }
        };
        this.hTt = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                        k bWx = NewSubPbActivity.this.hTn.bWx();
                        TbRichText bd = NewSubPbActivity.this.bd(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bd != null && bd.axz() != null) {
                            tbRichTextData = bd.axz().get(NewSubPbActivity.this.hFw);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.axG().axS()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (bWx == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (bWx.bQA() != null) {
                                        str4 = bWx.bQA().getName();
                                        str5 = bWx.bQA().getId();
                                    }
                                    if (bWx.abv() != null) {
                                        str6 = bWx.abv().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.hTn.bWJ() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.hTn.bWJ();
                                    z6 = NewSubPbActivity.this.hTn.bWL();
                                    arrayList2 = NewSubPbActivity.this.hTn.bWK();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.c(arrayList2, 0));
                                NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                                return;
                            }
                            NewSubPbActivity.this.hFx = false;
                            String str7 = "";
                            TbRichText cmy = bWx.bQu().cmy();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(cmy, bd, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (bWx == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (bWx.bQA() != null) {
                                    str8 = bWx.bQA().getName();
                                    str9 = bWx.bQA().getId();
                                }
                                if (bWx.abv() != null) {
                                    str10 = bWx.abv().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.hTn.bWJ() != null) {
                                concurrentHashMap = NewSubPbActivity.this.hTn.bWJ();
                                z4 = NewSubPbActivity.this.hTn.bWL();
                                arrayList = NewSubPbActivity.this.hTn.bWK();
                                i2 = a2 + NewSubPbActivity.this.hTn.getOffset();
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
        TbRichTextImageInfo axG;
        if (tbRichText == tbRichText2) {
            this.hFx = true;
        }
        if (tbRichText != null && tbRichText.axz() != null) {
            int size = tbRichText.axz().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.axz().get(i6) != null && tbRichText.axz().get(i6).getType() == 8) {
                    i5++;
                    int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                    int width = tbRichText.axz().get(i6).axG().getWidth() * ai;
                    int height = tbRichText.axz().get(i6).axG().getHeight() * ai;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.axz().get(i6).axG().axS()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.axz().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (axG = tbRichTextData.axG()) != null) {
                            String axU = axG.axU();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = axU;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.hFx) {
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
        if (this.hTq != null) {
            this.hTq.or(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo axG = tbRichTextData.axG();
        if (axG != null) {
            if (!StringUtils.isNull(axG.axR())) {
                return axG.axR();
            }
            if (axG.getHeight() * axG.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (axG.getHeight() * axG.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (axG.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * axG.getHeight())));
            } else {
                float width = axG.getWidth() / axG.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ap.bh(axG.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bd(String str, int i) {
        if (this.hTn == null || this.hTn.bWx() == null || str == null || i < 0) {
            return null;
        }
        k bWx = this.hTn.bWx();
        TbRichText a2 = a(bWx.bQu(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bWx.bQu(), str, i);
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
        TbRichText cmy = postData.cmy();
        if (cmy != null) {
            ArrayList<TbRichTextData> axz = cmy.axz();
            int size = axz.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (axz.get(i3) != null && axz.get(i3).getType() == 8) {
                    i2++;
                    if (axz.get(i3).axG().axU().equals(str)) {
                        int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                        int width = axz.get(i3).axG().getWidth() * ai;
                        int height = axz.get(i3).axG().getHeight() * ai;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.hFw = i3;
                        return cmy;
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
    public void bRm() {
        if (this.fsx == null) {
            this.fsx = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.fsx.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jV(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void n(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jW(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.gPM == null || NewSubPbActivity.this.hTn == null || NewSubPbActivity.this.hTn.biZ() == null || NewSubPbActivity.this.gPM.hZ(NewSubPbActivity.this.hTn.biZ().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.gPU.arG()) {
                                NewSubPbActivity.this.gPU.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.hTp.bWc();
                            NewSubPbActivity.this.hTp.bWd();
                            if (NewSubPbActivity.this.gPU != null) {
                                NewSubPbActivity.this.gPU.arS();
                                if (NewSubPbActivity.this.hTB != null) {
                                    NewSubPbActivity.this.hTB.bnW();
                                }
                            }
                        }
                    }
                }
            });
        }
        if (this.hTn != null && this.hTn.bWx() != null && this.hTn.bWx().bQA() != null) {
            this.fsx.t(this.hTn.bWx().bQA().getId(), com.baidu.adp.lib.g.b.c(this.hTn.bSI(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nY(boolean z) {
        if (this.hTn == null) {
            return false;
        }
        return ((bPX() != 0) || this.hTn.bWx() == null || this.hTn.bWx().abv() == null || this.hTn.bWx().abv().adv() == null || TextUtils.equals(this.hTn.bWx().abv().adv().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Context context, String str, String str2) {
        long templateId = this.hTn.bWx().bQu().cmF() != null ? this.hTn.bWx().bQu().cmF().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ba.aiz().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.hTn.bWx().bQA().getId(), this.hTn.bWx().bQA().getName(), this.hTn.bWx().abv().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i, String str) {
        if (this.hTn.bWy()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.ki()) {
            if (i == 4) {
                this.hTp.uL(str + "(4)");
            } else {
                this.hTp.oH(R.string.no_data_text);
            }
        } else {
            this.hTp.oH(R.string.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.gPU = (g) new h().cJ(getActivity());
        if (this.gPU != null) {
            this.gPU.a(getPageContext());
            this.gPU.b(this.hTn);
            this.gPU.b(this.ggl);
            this.gPU.a(this.csw);
            this.gPU.a(this.csx);
            this.gPU.aqS().fd(true);
            this.gPU.e(getPageContext());
        }
        if (this.hTp != null) {
            this.hTp.g(this.gPU);
        }
        if (this.gPU != null && this.hTn != null) {
            this.gPU.a(this.hTn.biZ());
            this.gPU.arP();
        }
        if (this.gPU != null) {
            this.gPU.arT().setDefaultHint(bUi());
            this.gPU.arT().setHint(bUi());
            this.ggf = this.gPU.arT().getInputView();
            this.ggf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.gge != null) {
                        if (!NewSubPbActivity.this.gge.cwh()) {
                            NewSubPbActivity.this.lj(false);
                        }
                        NewSubPbActivity.this.gge.rK(false);
                    }
                }
            });
        }
    }

    public void bVZ() {
        if (!TbadkCoreApplication.isLogin()) {
            this.gPU.arP();
        } else if (!StringUtils.isNull(this.hTn.bWF())) {
            if (this.hTp.bWg() && com.baidu.adp.lib.util.l.ki()) {
                this.hTp.bgp();
            } else {
                this.hTp.bWj();
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
                    this.hTp.cA(view);
                }
            } else if (booleanValue2) {
                this.hTp.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.hTp.bWp(), getPageContext().getPageActivity());
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.hTz);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.hTz);
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
        this.hTp.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.hTz;
        userMuteCheckCustomMessage.setTag(this.hTz);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.hTp.a(0, bVar.FN, bVar.jbj, z);
            if (bVar.FN) {
                if (bVar.eVt == 1) {
                    if (this.hTp.getListView() instanceof BdTypeListView) {
                        List<m> data = ((BdTypeListView) this.hTp.getListView()).getData();
                        if (!v.aa(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.hTp.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.eVt == 2) {
                    this.hTn.BC(bVar.mPostId);
                    this.hTp.a(this.hTn.bWx(), this.hTn.bPX(), this.hTn.bWJ() != null);
                    if (this.hTn.bWG()) {
                        this.hTn.pd(false);
                        this.hTp.bWe();
                        this.hTn.atv();
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
        this.hEl.By(str);
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.hTn.isMarked() && postData.getId() != null && postData.getId().equals(this.hTn.bWE())) {
                z = true;
            }
            MarkData j = this.hTn.j(postData);
            if (j != null) {
                this.hTp.bUS();
                if (this.hEm != null) {
                    this.hEm.a(j);
                    if (!z) {
                        this.hEm.ZE();
                    } else {
                        this.hEm.ZD();
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
        if (bundle != null && this.hTn != null) {
            this.hTn.ab(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.gPU != null) {
            this.gPU.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.gPU.aqS().app();
        this.gPU.arP();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gPU.b(writeData);
                this.gPU.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k kj = this.gPU.aqS().kj(6);
                if (kj != null && kj.cqE != null) {
                    kj.cqE.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gPU.arL();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.foP != null) {
            this.foP.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.ddY = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.Yk().Yp();
        if (this.foP != null) {
            this.foP.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.gtK);
        this.hTp.bqj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.ddY = false;
        super.onResume();
        bRU();
        if (this.foP != null) {
            this.foP.onResume(getPageContext());
        }
        registerListener(this.gtK);
        this.hTp.bqk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.foP != null) {
            this.foP.onStop(getPageContext());
        }
        this.gPU.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.hTC));
        this.hTn.cancelLoadData();
        this.hTn.destory();
        this.hTo.cancelLoadData();
        if (this.foP != null) {
            this.foP.onDestory(getPageContext());
        }
        this.hTp.bUS();
        this.hTp.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.hFl);
        MessageManager.getInstance().unRegisterListener(this.hFm);
        MessageManager.getInstance().unRegisterListener(this.hFn);
        MessageManager.getInstance().unRegisterListener(this.hTz);
        this.hEJ = null;
        this.hEK = null;
        if (this.gPM != null) {
            this.gPM.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hTp.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.foP;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bWk = this.hTp.bWk();
        if (bWk == null || (findViewWithTag = bWk.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Br(String str) {
        Map<String, String> nW;
        if (!TextUtils.isEmpty(str) && (nW = ba.nW(ba.nX(str))) != null) {
            this.hTA = true;
            String str2 = nW.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Br(com.baidu.adp.lib.util.k.bi(str2));
            }
            String str3 = nW.get(hTm);
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
            this.hTA = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hTA = true;
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
        if (this.hTp != null) {
            return this.hTp.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int ayg() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> ayi() {
        if (this.cLs == null) {
            this.cLs = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cLs;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> ayj() {
        if (this.cIE == null) {
            this.cIE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bRW */
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
    public com.baidu.adp.lib.e.b<ImageView> ayh() {
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
    public com.baidu.adp.lib.e.b<View> ayk() {
        if (this.cLt == null) {
            this.cLt = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bRX */
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
    public com.baidu.adp.lib.e.b<LinearLayout> ayl() {
        if (this.cLu == null) {
            this.cLu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bRZ */
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
    public com.baidu.adp.lib.e.b<RelativeLayout> aym() {
        this.cLv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bRY */
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
    public com.baidu.tieba.pb.pb.main.b.a bQG() {
        return this.hEp;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bQH() {
        return (this.hTn == null || this.hTn.bWx() == null || this.hTn.bWx().abv() == null || this.hTn.bWx().abv().aeN()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bQI() {
        if (this.hTn == null || this.hTn.bWx() == null || this.hTn.bWx().abv() == null) {
            return null;
        }
        return this.hTn.bWx().abv().adA();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bQJ() {
        if (this.hTn == null) {
            return 0;
        }
        return this.hTn.bPX();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean AX(String str) {
        if (StringUtils.isNull(str) || this.hTn == null || this.hTn.bWx() == null || this.hTn.bWx().abv() == null || this.hTn.bWx().abv().adv() == null) {
            return false;
        }
        return str.equals(this.hTn.bWx().abv().adv().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hTp.bWg() && com.baidu.adp.lib.util.l.ki()) {
            this.hTn.atv();
        } else {
            this.hTp.bWj();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.hTz);
        userMuteAddAndDelCustomMessage.setTag(this.hTz);
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
        if (pageStayDurationItem != null && this.hTn != null) {
            if (this.hTn.bWx() != null && this.hTn.bWx().bQA() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.hTn.bWx().bQA().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.hTn.bSI(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.ddY;
    }

    public boolean bWa() {
        if (this.hTn != null) {
            return this.hTn.bWa();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hTp.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hEJ.getPageActivity());
        if (ap.isEmpty(str)) {
            aVar.mE(this.hEJ.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.mE(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.hTp.showLoadingDialog();
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
        aVar.b(this.hEJ).afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qf(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hEJ.getPageActivity());
        aVar.mE(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hEJ).afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.mE(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.hEJ).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.hEJ.getPageActivity(), 2, true, 4);
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
        aVar.b(this.hEJ).afG();
    }

    public SubPbModel bWb() {
        return this.hTn;
    }

    public int bPX() {
        if (this.hTn != null) {
            return this.hTn.bPX();
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
        if (this.ggf != null && this.ggf.getText() != null) {
            int selectionEnd = this.ggf.getSelectionEnd();
            SpannableStringBuilder b = this.gge.b(this.ggf.getText());
            if (b != null) {
                this.gge.rK(true);
                this.ggf.setText(b);
                if (z && this.gge.cwf() >= 0) {
                    this.ggf.requestFocus();
                    this.ggf.setSelection(this.gge.cwf());
                } else {
                    this.ggf.setSelection(selectionEnd);
                }
                this.gge.rJ(this.gge.cwf() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gPU != null && this.gPU.aqS() != null && this.gPU.aqS().aqV()) {
            this.gPU.aqS().app();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    public String bUi() {
        if (!ap.isEmpty(this.hPy)) {
            return this.hPy;
        }
        this.hPy = getResources().getString(com.baidu.tieba.pb.pb.main.ap.bUa());
        return this.hPy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.hTD = z;
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
        if (this.hTp != null && this.hTp.getListView() != null && this.hTE != null && this.hTE.mPosition != -1) {
            final int headerViewsCount = this.hTE.mPosition + this.hTp.getListView().getHeaderViewsCount();
            if (this.hTE.getView() != null) {
                final int height = this.hTE.getView().getHeight() - ((rect.height() - this.hTp.getNavigationBarHeight()) - this.hTp.bWu());
                if (height > 0) {
                    this.hTp.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.hTp != null && NewSubPbActivity.this.hTp.getListView() != null) {
                                NewSubPbActivity.this.hTp.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.hTp.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.hTp.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.hTp != null && NewSubPbActivity.this.hTp.getListView() != null) {
                                NewSubPbActivity.this.hTp.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.hTp.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }

    private void bRU() {
        if (this.hTn != null && !ap.isEmpty(this.hTn.bSI())) {
            com.baidu.tbadk.BdToken.c.Yk().k(com.baidu.tbadk.BdToken.b.bwW, com.baidu.adp.lib.g.b.c(this.hTn.bSI(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.hTn == null || ap.isEmpty(this.hTn.bSI())) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.c(this.hTn.bSI(), 0L);
    }
}
