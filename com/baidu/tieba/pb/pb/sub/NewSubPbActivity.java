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
    private static final String hRE = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String hTn = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> cIE;
    private com.baidu.adp.lib.e.b<GifView> cIF;
    private com.baidu.adp.lib.e.b<TextView> cLt;
    private com.baidu.adp.lib.e.b<View> cLu;
    private com.baidu.adp.lib.e.b<LinearLayout> cLv;
    private com.baidu.adp.lib.e.b<RelativeLayout> cLw;
    private View.OnLongClickListener cll;
    private au fQE;
    private VoiceManager foP;
    private com.baidu.tieba.frs.profession.permission.c fsx;
    public aj gPO;
    private g gPW;
    private com.baidu.tieba.write.b ggg;
    private EditText ggh;
    private com.baidu.adp.base.e hEK;
    private com.baidu.tbadk.core.view.e hEL;
    private com.baidu.adp.widget.ImageView.a hEO;
    private String hEP;
    private TbRichTextMemeInfo hEQ;
    private com.baidu.tieba.pb.pb.report.a hEm;
    private com.baidu.tbadk.baseEditMark.a hEn;
    private com.baidu.tieba.pb.pb.main.b.a hEq;
    private b.a hFz;
    private PostWriteCallBackData hIV;
    private String hPz;
    private BdUniqueId hTA;
    private com.baidu.tieba.pb.pb.sub.a hTC;
    private com.baidu.tieba.pb.e<k> hTD;
    private boolean hTE;
    private j hTF;
    private SubPbModel hTo;
    private ForumManageModel hTp;
    private b hTq;
    private y hTr;
    private AbsListView.OnScrollListener hTs;
    private TbRichTextView.i hTt;
    private TbRichTextView.h hTu;
    private SubPbModel.a hTv;
    private com.baidu.adp.base.d hTw;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int hFx = 0;
    PostData ggP = null;
    private a.InterfaceC0236a hFu = null;
    private a hTx = null;
    private a hTy = null;
    private boolean ddZ = false;
    private boolean hTz = false;
    private boolean hTB = false;
    private boolean cre = false;
    private com.baidu.tbadk.editortools.pb.c csx = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void arr() {
            NewSubPbActivity.this.hTq.bWj();
        }
    };
    private com.baidu.tbadk.editortools.pb.b csy = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean arq() {
            if (!NewSubPbActivity.this.ggg.cwf()) {
                return (NewSubPbActivity.this.gPO == null || NewSubPbActivity.this.hTo == null || NewSubPbActivity.this.hTo.biZ() == null || NewSubPbActivity.this.gPO.R(NewSubPbActivity.this.hTo.biZ().replyPrivateFlag, aj.bSi)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.ggg.cwh());
            if (NewSubPbActivity.this.gPW.arG()) {
                NewSubPbActivity.this.gPW.a(NewSubPbActivity.this.hIV);
            }
            NewSubPbActivity.this.lk(true);
            return true;
        }
    };
    private NewWriteModel.d ggn = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.gPW != null && NewSubPbActivity.this.gPW.aqS() != null) {
                NewSubPbActivity.this.gPW.aqS().hide();
                if (NewSubPbActivity.this.hTo.bWE()) {
                    TiebaStatic.log(new am("c10367").bT("post_id", NewSubPbActivity.this.hTo.aro()));
                }
            }
            if (z) {
                NewSubPbActivity.this.ggg.FG(null);
                NewSubPbActivity.this.ggg.aI(null);
                NewSubPbActivity.this.ggg.rK(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.ggg.aI(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.ggg.FG(postWriteCallBackData.getErrorString());
                if (!v.aa(NewSubPbActivity.this.ggg.cwd())) {
                    NewSubPbActivity.this.hIV = postWriteCallBackData;
                    if (NewSubPbActivity.this.gPW.arG()) {
                        NewSubPbActivity.this.gPW.a(NewSubPbActivity.this.hIV);
                    }
                    NewSubPbActivity.this.lk(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.gPO != null) {
                NewSubPbActivity.this.gPO.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.hTq.bWk();
        }
    };
    private CustomMessageListener hFm = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hTA) {
                NewSubPbActivity.this.hTq.aSG();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hEL.i(NewSubPbActivity.this.hEK.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.hEK.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.qe(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bRR();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ap.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.hEK.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.hEL.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hFn = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hTA) {
                NewSubPbActivity.this.hTq.aSG();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hEL.i(NewSubPbActivity.this.hEK.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ap.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.hEK.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.hEL.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hFo = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hTA) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.hTq.aSG();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.jng;
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
                    NewSubPbActivity.this.hTq.a(sparseArray, z);
                }
            }
        }
    };
    boolean hFy = false;
    private final b.a hFA = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.hEO != null && !TextUtils.isEmpty(NewSubPbActivity.this.hEP)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.hEQ == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hEP));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.hEP;
                        aVar.pkgId = NewSubPbActivity.this.hEQ.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hEQ.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.aiM();
                    NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.aa(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.fQE == null) {
                            NewSubPbActivity.this.fQE = new au(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.fQE.h(NewSubPbActivity.this.hEP, NewSubPbActivity.this.hEO.nv());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.hEO = null;
                NewSubPbActivity.this.hEP = null;
            }
        }
    };
    private CustomMessageListener gtM = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
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
                    if (NewSubPbActivity.this.hTo.bWy() != null && NewSubPbActivity.this.hTo.bWy().bQv() != null && NewSubPbActivity.this.hTo.bWy().bQv().adv() != null && currentAccount.equals(NewSubPbActivity.this.hTo.bWy().bQv().adv().getUserId()) && NewSubPbActivity.this.hTo.bWy().bQv().adv().getPendantData() != null) {
                        NewSubPbActivity.this.hTo.bWy().bQv().adv().getPendantData().mk(lVar.abS());
                        NewSubPbActivity.this.hTo.bWy().bQv().adv().getPendantData().bg(lVar.aqx());
                        NewSubPbActivity.this.hTq.a(NewSubPbActivity.this.hTo.bWy().bQv(), NewSubPbActivity.this.hTo.bWy().bDe(), NewSubPbActivity.this.hTo.bWy().ZC(), NewSubPbActivity.this.hTo.bPY(), NewSubPbActivity.this.hTo.bWK() != null);
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
        if (this.cre) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.hEK = getPageContext();
        this.hTz = true;
        this.ggg = new com.baidu.tieba.write.b();
        this.ggg.Cc(R.color.cp_cont_h_alpha85);
        this.ggg.Cb(R.color.cp_btn_a);
        bnS();
        bVZ();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bVY();
        this.hEL = new com.baidu.tbadk.core.view.e();
        this.hEL.bXG = 1000L;
        registerListener(this.hFo);
        registerListener(this.hFm);
        registerListener(this.hFn);
        this.hTA = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hTA;
        userMuteAddAndDelCustomMessage.setTag(this.hTA);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hTA;
        userMuteCheckCustomMessage.setTag(this.hTA);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.gPO = new aj(getPageContext());
        this.gPO.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.gPW.arL();
                }
            }
        });
        this.hEm = new com.baidu.tieba.pb.pb.report.a(this);
        this.hEm.r(getUniqueId());
        this.hEq = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    private void bVY() {
        if (this.hTq != null && this.hTo != null && this.hTo.bWb()) {
            this.hTC = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.hTq.aJC());
            this.hTC.bnX();
            this.hTC.a(new a.InterfaceC0380a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
                private boolean fDx = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0380a
                public void bnT() {
                    NewSubPbActivity.this.hTq.kt(false);
                    this.fDx = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0380a
                public void bnU() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0380a
                public boolean bnV() {
                    if (!this.fDx) {
                        return NewSubPbActivity.this.hTq.boj() != null && NewSubPbActivity.this.hTq.boj().getTop() == 0;
                    }
                    this.fDx = false;
                    return false;
                }
            });
            this.hTq.e(this.hTC);
            this.hTq.kt(true);
        }
    }

    public void initUI() {
        this.hTq = new b(this, this.mCommonClickListener);
        this.hTq.a(this.hTo);
        setContentView(this.hTq.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.hTq.setOnScrollListener(this.hTs);
        this.hTq.b(this);
        this.hTq.setOnLinkImageClickListener(this.hTt);
        this.hTq.setOnImageClickListener(this.hTu);
        this.hTq.nS(true);
        this.hTq.setOnLongClickListener(this.cll);
        this.hTq.d(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.40
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.hTo != null) {
                    NewSubPbActivity.this.hTo.atv();
                }
            }
        });
        this.hTq.a(this.hTx);
        this.hTq.b(this.hTy);
        if (this.hTo != null && this.hTo.bWb() && !this.hTo.bWJ()) {
            this.hTq.bWo().setVisibility(8);
        } else {
            this.hTq.bWo().setVisibility(0);
        }
        if (this.hTo != null && !this.hTo.bWb()) {
            this.hTq.setIsFromPb(false);
        }
    }

    private boolean ac(Bundle bundle) {
        if (bundle != null) {
            this.cre = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.cre = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.cre;
    }

    public void initData(Bundle bundle) {
        this.hTo = new SubPbModel(getPageContext());
        this.hTo.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                NewSubPbActivity.this.hTq.p(postData);
                NewSubPbActivity.this.hTq.b((BdListView.e) null);
            }
        });
        this.hTp = new ForumManageModel(getPageContext());
        this.hTp.setLoadDataCallBack(this.hTw);
        this.foP = new VoiceManager();
        this.foP.onCreate(getPageContext());
        this.hEn = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hEn != null) {
            this.hEn.a(this.hFu);
        }
        if (bundle != null) {
            this.hTo.initWithBundle(bundle);
        } else {
            this.hTo.initWithIntent(getIntent());
        }
        this.hTo.a(this.hTv);
        if (this.hTo.bWb()) {
            this.hTo.atv();
        } else {
            this.hTo.bWD();
        }
    }

    public void bVZ() {
        this.hTv = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, k kVar) {
                if (NewSubPbActivity.this.hTq != null) {
                    NewSubPbActivity.this.hTq.bWk();
                }
                if (NewSubPbActivity.this.hTC != null && NewSubPbActivity.this.hTC.bnY()) {
                    NewSubPbActivity.this.hTC.rT(R.color.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.aC(i, str);
                    return;
                }
                NewSubPbActivity.this.hTq.hideNoDataView();
                if (kVar != null) {
                    if (kVar.bQv() != null || NewSubPbActivity.this.hTo != null) {
                        kVar.bQv().a(NewSubPbActivity.this.hTo.bWI());
                    }
                    if (NewSubPbActivity.this.hTq != null) {
                        NewSubPbActivity.this.hTq.a(kVar, NewSubPbActivity.this.hTo.bPY(), NewSubPbActivity.this.hTo.bWK() != null);
                        if (NewSubPbActivity.this.hTz) {
                            NewSubPbActivity.this.bWa();
                            NewSubPbActivity.this.hTz = false;
                        }
                    }
                    if (NewSubPbActivity.this.gPW != null) {
                        NewSubPbActivity.this.gPW.a(kVar.biZ());
                    }
                    if (NewSubPbActivity.this.hTD == null) {
                        NewSubPbActivity.this.hTD = new com.baidu.tieba.pb.e();
                    }
                    NewSubPbActivity.this.hTD.setData(kVar);
                    NewSubPbActivity.this.hTD.setType(0);
                    NewSubPbActivity.this.gPO.a(NewSubPbActivity.this.hTo.bWN());
                }
            }
        };
        this.hFu = new a.InterfaceC0236a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0236a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.hEn != null) {
                        NewSubPbActivity.this.hEn.ds(z2);
                    }
                    MarkData ZF = NewSubPbActivity.this.hEn.ZF();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(ZF);
                        if (NewSubPbActivity.this.hEn != null) {
                            if (ZF != null) {
                                NewSubPbActivity.this.hTo.pd(true);
                                NewSubPbActivity.this.hTo.BF(NewSubPbActivity.this.hTo.aro());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.hTq != null) {
                                NewSubPbActivity.this.hTq.pc(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.hTo.pd(false);
                        NewSubPbActivity.this.hTo.BF(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.hTq != null) {
                            NewSubPbActivity.this.hTq.pc(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.hTx = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.hTo.bWy() != null && NewSubPbActivity.this.hTo.bWy().abv() != null && NewSubPbActivity.this.hTo.bWy().abv().adv() != null) {
                    str = String.valueOf(NewSubPbActivity.this.hTo.bWy().abv().adv().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.hTo.bWy().bQB().getId(), NewSubPbActivity.this.hTo.bWy().bQB().getName(), NewSubPbActivity.this.hTo.bWy().abv().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.hTy = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.hTp.cni() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int f = com.baidu.adp.lib.g.b.f(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int f2 = com.baidu.adp.lib.g.b.f(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.hTo != null && NewSubPbActivity.this.hTo.bWy() != null && NewSubPbActivity.this.hTo.bWy().bQB() != null && NewSubPbActivity.this.hTo.bWy().abv() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.hTp.Ec(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.hTp.a(NewSubPbActivity.this.hTo.bWy().bQB().getId(), NewSubPbActivity.this.hTo.bWy().bQB().getName(), NewSubPbActivity.this.hTo.bWy().abv().getId(), valueOf, f2, f, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.hTw = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.hTq.a(NewSubPbActivity.this.hTp.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.hTp.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.hUy != 1002 || bVar.fTT) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.hTq.a(1, dVar.FM, dVar.jbn, true);
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
                if (view != null || NewSubPbActivity.this.hTq != null) {
                    if (view == NewSubPbActivity.this.hTq.bWu()) {
                        NewSubPbActivity.this.hTq.bUT();
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
                    } else if (view != NewSubPbActivity.this.hTq.bok()) {
                        if (view != NewSubPbActivity.this.hTq.bWn()) {
                            if (view != NewSubPbActivity.this.hTq.bWm()) {
                                if (view == NewSubPbActivity.this.hTq.bWi()) {
                                    NewSubPbActivity.this.hTq.bUT();
                                    if (NewSubPbActivity.this.hTo.atv()) {
                                        NewSubPbActivity.this.hTq.bWg();
                                    }
                                } else if (view == NewSubPbActivity.this.hTq.bWo() || view == NewSubPbActivity.this.hTq.bWp() || view == NewSubPbActivity.this.hTq.bWr()) {
                                    if (NewSubPbActivity.this.hTB) {
                                        NewSubPbActivity.this.hTB = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.hTo.bSJ(), NewSubPbActivity.this.hTo.aro(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.hTo.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.hTo.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.hTq.bWs() == null || view != NewSubPbActivity.this.hTq.bWs().bTz()) {
                                    if (NewSubPbActivity.this.hTq.bWs() == null || view != NewSubPbActivity.this.hTq.bWs().bTC()) {
                                        if (NewSubPbActivity.this.hTq.bWs() == null || view != NewSubPbActivity.this.hTq.bWs().bTA()) {
                                            if (NewSubPbActivity.this.hTq.bWs() == null || view != NewSubPbActivity.this.hTq.bWs().bTB()) {
                                                if (NewSubPbActivity.this.hTq.bWs() == null || view != NewSubPbActivity.this.hTq.bWs().bTD()) {
                                                    if (view == NewSubPbActivity.this.hTq.bWl() || view == NewSubPbActivity.this.hTq.bWr()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.gPW.arO()) {
                                                                NewSubPbActivity.this.gPW.arP();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.gPW.qf(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof j)) {
                                                        if (NewSubPbActivity.this.hTr == null || view != NewSubPbActivity.this.hTr.bTB()) {
                                                            if (NewSubPbActivity.this.hTr == null || view != NewSubPbActivity.this.hTr.bTz()) {
                                                                if (NewSubPbActivity.this.hTr == null || view != NewSubPbActivity.this.hTr.bTC()) {
                                                                    if (NewSubPbActivity.this.hTr == null || view != NewSubPbActivity.this.hTr.bTD()) {
                                                                        if (NewSubPbActivity.this.hTr == null || view != NewSubPbActivity.this.hTr.bTF()) {
                                                                            if (NewSubPbActivity.this.hTr == null || view != NewSubPbActivity.this.hTr.bTG()) {
                                                                                if (NewSubPbActivity.this.hTr != null && view == NewSubPbActivity.this.hTr.bTA()) {
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
                                                                                            NewSubPbActivity.this.hTq.cA(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.hTq.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                        if (postData.getType() != PostData.iYH && !TextUtils.isEmpty(postData.getBimg_url()) && i.abb().abf()) {
                                                                                            NewSubPbActivity.this.BC(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.hEO != null && !TextUtils.isEmpty(NewSubPbActivity.this.hEP)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.aiM();
                                                                                NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.aa(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.fQE == null) {
                                                                                        NewSubPbActivity.this.fQE = new au(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.fQE.h(NewSubPbActivity.this.hEP, NewSubPbActivity.this.hEO.nv());
                                                                                    NewSubPbActivity.this.hEO = null;
                                                                                    NewSubPbActivity.this.hEP = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.hEO != null && !TextUtils.isEmpty(NewSubPbActivity.this.hEP)) {
                                                                            if (NewSubPbActivity.this.hEQ == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hEP));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.hEP;
                                                                                aVar.pkgId = NewSubPbActivity.this.hEQ.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hEQ.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.hEO = null;
                                                                            NewSubPbActivity.this.hEP = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.ggP != null) {
                                                                        NewSubPbActivity.this.ggP.ek(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.ggP = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.hTq.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                NewSubPbActivity.this.Bc((String) tag);
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
                                                        NewSubPbActivity.this.hTF = (j) view.getTag();
                                                        if (bc.cE(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.hTB) {
                                                                NewSubPbActivity.this.hTB = false;
                                                                return;
                                                            } else if (NewSubPbActivity.this.gPO == null || NewSubPbActivity.this.hTo == null || NewSubPbActivity.this.hTo.biZ() == null || NewSubPbActivity.this.gPO.hZ(NewSubPbActivity.this.hTo.biZ().replyPrivateFlag)) {
                                                                if (NewSubPbActivity.this.hTC != null) {
                                                                    NewSubPbActivity.this.hTC.bnW();
                                                                }
                                                                SparseArray sparseArray4 = (SparseArray) view.getTag(R.id.tag_from);
                                                                if (sparseArray4 != null) {
                                                                    if (sparseArray4.get(R.id.tag_clip_board) instanceof PostData) {
                                                                        PostData postData2 = (PostData) sparseArray4.get(R.id.tag_clip_board);
                                                                        if (postData2 != null && postData2.adv() != null) {
                                                                            MetaData adv = postData2.adv();
                                                                            NewSubPbActivity.this.gPW.setReplyId(adv.getUserId());
                                                                            if (!(sparseArray4.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.tag_is_subpb)).booleanValue() : true)) {
                                                                                NewSubPbActivity.this.gPW.qg("");
                                                                            } else {
                                                                                NewSubPbActivity.this.gPW.qg(adv.getName_show());
                                                                            }
                                                                        }
                                                                        NewSubPbActivity.this.hTq.bWe();
                                                                    }
                                                                    if (NewSubPbActivity.this.hTE) {
                                                                        NewSubPbActivity.this.pb(false);
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
                                            NewSubPbActivity.this.hTq.bUT();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.Bc(str4);
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
                                            NewSubPbActivity.this.hTq.bUT();
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
                                    NewSubPbActivity.this.hTq.bUT();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.hTq.a(((Integer) sparseArray7.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray7.get(R.id.tag_del_post_id), ((Integer) sparseArray7.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new am("c11739").P("obj_locate", 2));
                                    NewSubPbActivity.this.hTq.bUT();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.hTo.bWy() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.hTo.bWy().bQv());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.hTq.bWd();
                                NewSubPbActivity.this.hTq.bWe();
                                if (NewSubPbActivity.this.gPW != null) {
                                    NewSubPbActivity.this.gPW.arR();
                                    if (NewSubPbActivity.this.hTC != null) {
                                        NewSubPbActivity.this.hTC.bnW();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.hTq.bWd();
                            NewSubPbActivity.this.hTq.bWe();
                            if (NewSubPbActivity.this.gPW != null) {
                                NewSubPbActivity.this.gPW.arQ();
                                if (NewSubPbActivity.this.hTC != null) {
                                    NewSubPbActivity.this.hTC.bnW();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.bRn();
                        if (NewSubPbActivity.this.hTo != null && NewSubPbActivity.this.hTo.bWy() != null && NewSubPbActivity.this.hTo.bWy().abv() != null && NewSubPbActivity.this.hTo.bWy().abv().adv() != null) {
                            TiebaStatic.log(new am("c13402").bT("tid", NewSubPbActivity.this.hTo.bSJ()).l("fid", NewSubPbActivity.this.hTo.bWy().abv().getFid()).P("obj_locate", 5).bT("uid", NewSubPbActivity.this.hTo.bWy().abv().adv().getUserId()));
                        }
                    }
                }
            }
        };
        this.hTs = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.hTq.bUT();
                }
                NewSubPbActivity.this.gPW.arP();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.hTq.bWt();
            }
        };
        this.hFz = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.hTo.bWy() != null) {
                    postData = NewSubPbActivity.this.hTo.bWy().bQv();
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
        this.cll = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                        NewSubPbActivity.this.hEO = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.hEP = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.hEO != null && !TextUtils.isEmpty(NewSubPbActivity.this.hEP)) {
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hEQ = null;
                            } else {
                                NewSubPbActivity.this.hEQ = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                NewSubPbActivity.this.hTq.a(NewSubPbActivity.this.hFA, NewSubPbActivity.this.hEO.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                NewSubPbActivity.this.ggP = (PostData) sparseArray2.get(R.id.tag_clip_board);
                                if (NewSubPbActivity.this.ggP != null && NewSubPbActivity.this.hEn != null) {
                                    if (NewSubPbActivity.this.hEn != null) {
                                        NewSubPbActivity.this.hEn.ds(NewSubPbActivity.this.hTo.isMarked());
                                    }
                                    boolean z = NewSubPbActivity.this.hEn.ZC() && NewSubPbActivity.this.ggP.getId() != null && NewSubPbActivity.this.ggP.getId().equals(NewSubPbActivity.this.hTo.bWF());
                                    if (NewSubPbActivity.this.hTr == null) {
                                        NewSubPbActivity.this.hTr = new y(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.mCommonClickListener);
                                        NewSubPbActivity.this.hTq.cE(NewSubPbActivity.this.hTr.getView());
                                        NewSubPbActivity.this.hTr.os(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.hTr.showDialog();
                                    boolean isLogin = NewSubPbActivity.this.isLogin() & NewSubPbActivity.this.nZ(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false);
                                    boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                                    if (z) {
                                        NewSubPbActivity.this.hTr.bTz().setText(R.string.remove_mark);
                                    } else {
                                        NewSubPbActivity.this.hTr.bTz().setText(R.string.mark);
                                    }
                                    if (booleanValue) {
                                        NewSubPbActivity.this.hTr.bTz().setVisibility(8);
                                    } else {
                                        NewSubPbActivity.this.hTr.bTz().setVisibility(0);
                                    }
                                    if (NewSubPbActivity.this.cu(view)) {
                                        if (NewSubPbActivity.this.hEO != null && !NewSubPbActivity.this.hEO.isGif()) {
                                            sparseArray2.put(R.id.tag_richtext_image, true);
                                        } else {
                                            sparseArray2.put(R.id.tag_richtext_image, false);
                                        }
                                        sparseArray2.put(R.id.tag_richtext_emotion, true);
                                    } else {
                                        sparseArray2.put(R.id.tag_richtext_image, false);
                                        sparseArray2.put(R.id.tag_richtext_emotion, false);
                                    }
                                    NewSubPbActivity.this.hTr.a(sparseArray2, NewSubPbActivity.this.bPY(), isLogin);
                                }
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            NewSubPbActivity.this.hEO = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                NewSubPbActivity.this.hEP = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hEQ = null;
                            } else {
                                NewSubPbActivity.this.hEQ = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.hEO = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.hEP = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.hEQ = null;
                        } else {
                            NewSubPbActivity.this.hEQ = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
        this.hTt = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void f(View view, String str) {
                NewSubPbActivity.this.r(null, str, "LINK_IMAGE");
            }
        };
        this.hTu = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                        k bWy = NewSubPbActivity.this.hTo.bWy();
                        TbRichText bd = NewSubPbActivity.this.bd(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bd != null && bd.axz() != null) {
                            tbRichTextData = bd.axz().get(NewSubPbActivity.this.hFx);
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
                                if (bWy == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (bWy.bQB() != null) {
                                        str4 = bWy.bQB().getName();
                                        str5 = bWy.bQB().getId();
                                    }
                                    if (bWy.abv() != null) {
                                        str6 = bWy.abv().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.hTo.bWK() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.hTo.bWK();
                                    z6 = NewSubPbActivity.this.hTo.bWM();
                                    arrayList2 = NewSubPbActivity.this.hTo.bWL();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.c(arrayList2, 0));
                                NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                                return;
                            }
                            NewSubPbActivity.this.hFy = false;
                            String str7 = "";
                            TbRichText cmz = bWy.bQv().cmz();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(cmz, bd, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (bWy == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (bWy.bQB() != null) {
                                    str8 = bWy.bQB().getName();
                                    str9 = bWy.bQB().getId();
                                }
                                if (bWy.abv() != null) {
                                    str10 = bWy.abv().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.hTo.bWK() != null) {
                                concurrentHashMap = NewSubPbActivity.this.hTo.bWK();
                                z4 = NewSubPbActivity.this.hTo.bWM();
                                arrayList = NewSubPbActivity.this.hTo.bWL();
                                i2 = a2 + NewSubPbActivity.this.hTo.getOffset();
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
            this.hFy = true;
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
                        if (!this.hFy) {
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
        if (this.hTr != null) {
            this.hTr.os(z);
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
        if (this.hTo == null || this.hTo.bWy() == null || str == null || i < 0) {
            return null;
        }
        k bWy = this.hTo.bWy();
        TbRichText a2 = a(bWy.bQv(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bWy.bQv(), str, i);
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
        TbRichText cmz = postData.cmz();
        if (cmz != null) {
            ArrayList<TbRichTextData> axz = cmz.axz();
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
                        this.hFx = i3;
                        return cmz;
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
    public void bRn() {
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
                        if (NewSubPbActivity.this.gPO == null || NewSubPbActivity.this.hTo == null || NewSubPbActivity.this.hTo.biZ() == null || NewSubPbActivity.this.gPO.hZ(NewSubPbActivity.this.hTo.biZ().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.gPW.arG()) {
                                NewSubPbActivity.this.gPW.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.hTq.bWd();
                            NewSubPbActivity.this.hTq.bWe();
                            if (NewSubPbActivity.this.gPW != null) {
                                NewSubPbActivity.this.gPW.arS();
                                if (NewSubPbActivity.this.hTC != null) {
                                    NewSubPbActivity.this.hTC.bnW();
                                }
                            }
                        }
                    }
                }
            });
        }
        if (this.hTo != null && this.hTo.bWy() != null && this.hTo.bWy().bQB() != null) {
            this.fsx.t(this.hTo.bWy().bQB().getId(), com.baidu.adp.lib.g.b.c(this.hTo.bSJ(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nZ(boolean z) {
        if (this.hTo == null) {
            return false;
        }
        return ((bPY() != 0) || this.hTo.bWy() == null || this.hTo.bWy().abv() == null || this.hTo.bWy().abv().adv() == null || TextUtils.equals(this.hTo.bWy().abv().adv().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Context context, String str, String str2) {
        long templateId = this.hTo.bWy().bQv().cmG() != null ? this.hTo.bWy().bQv().cmG().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ba.aiz().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.hTo.bWy().bQB().getId(), this.hTo.bWy().bQB().getName(), this.hTo.bWy().abv().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i, String str) {
        if (this.hTo.bWz()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.ki()) {
            if (i == 4) {
                this.hTq.uK(str + "(4)");
            } else {
                this.hTq.oH(R.string.no_data_text);
            }
        } else {
            this.hTq.oH(R.string.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.gPW = (g) new h().cJ(getActivity());
        if (this.gPW != null) {
            this.gPW.a(getPageContext());
            this.gPW.b(this.hTo);
            this.gPW.b(this.ggn);
            this.gPW.a(this.csx);
            this.gPW.a(this.csy);
            this.gPW.aqS().fd(true);
            this.gPW.e(getPageContext());
        }
        if (this.hTq != null) {
            this.hTq.g(this.gPW);
        }
        if (this.gPW != null && this.hTo != null) {
            this.gPW.a(this.hTo.biZ());
            this.gPW.arP();
        }
        if (this.gPW != null) {
            this.gPW.arT().setDefaultHint(bUj());
            this.gPW.arT().setHint(bUj());
            this.ggh = this.gPW.arT().getInputView();
            this.ggh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.ggg != null) {
                        if (!NewSubPbActivity.this.ggg.cwg()) {
                            NewSubPbActivity.this.lk(false);
                        }
                        NewSubPbActivity.this.ggg.rL(false);
                    }
                }
            });
        }
    }

    public void bWa() {
        if (!TbadkCoreApplication.isLogin()) {
            this.gPW.arP();
        } else if (!StringUtils.isNull(this.hTo.bWG())) {
            if (this.hTq.bWh() && com.baidu.adp.lib.util.l.ki()) {
                this.hTq.bgp();
            } else {
                this.hTq.bWk();
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
                    this.hTq.cA(view);
                }
            } else if (booleanValue2) {
                this.hTq.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.hTq.bWq(), getPageContext().getPageActivity());
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.hTA);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.hTA);
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
        this.hTq.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.hTA;
        userMuteCheckCustomMessage.setTag(this.hTA);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.hTq.a(0, bVar.FM, bVar.jbn, z);
            if (bVar.FM) {
                if (bVar.eVt == 1) {
                    if (this.hTq.getListView() instanceof BdTypeListView) {
                        List<m> data = ((BdTypeListView) this.hTq.getListView()).getData();
                        if (!v.aa(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.hTq.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.eVt == 2) {
                    this.hTo.BE(bVar.mPostId);
                    this.hTq.a(this.hTo.bWy(), this.hTo.bPY(), this.hTo.bWK() != null);
                    if (this.hTo.bWH()) {
                        this.hTo.pe(false);
                        this.hTq.bWf();
                        this.hTo.atv();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
            }
        }
    }

    public void Bc(String str) {
        this.hEm.BA(str);
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.hTo.isMarked() && postData.getId() != null && postData.getId().equals(this.hTo.bWF())) {
                z = true;
            }
            MarkData j = this.hTo.j(postData);
            if (j != null) {
                this.hTq.bUT();
                if (this.hEn != null) {
                    this.hEn.a(j);
                    if (!z) {
                        this.hEn.ZE();
                    } else {
                        this.hEn.ZD();
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
        if (bundle != null && this.hTo != null) {
            this.hTo.ab(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.gPW != null) {
            this.gPW.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.gPW.aqS().app();
        this.gPW.arP();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gPW.b(writeData);
                this.gPW.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k kj = this.gPW.aqS().kj(6);
                if (kj != null && kj.cqF != null) {
                    kj.cqF.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gPW.arL();
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
        this.ddZ = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.Yk().Yp();
        if (this.foP != null) {
            this.foP.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.gtM);
        this.hTq.bql();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.ddZ = false;
        super.onResume();
        bRV();
        if (this.foP != null) {
            this.foP.onResume(getPageContext());
        }
        registerListener(this.gtM);
        this.hTq.bqm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.foP != null) {
            this.foP.onStop(getPageContext());
        }
        this.gPW.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.hTD));
        this.hTo.cancelLoadData();
        this.hTo.destory();
        this.hTp.cancelLoadData();
        if (this.foP != null) {
            this.foP.onDestory(getPageContext());
        }
        this.hTq.bUT();
        this.hTq.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.hFm);
        MessageManager.getInstance().unRegisterListener(this.hFn);
        MessageManager.getInstance().unRegisterListener(this.hFo);
        MessageManager.getInstance().unRegisterListener(this.hTA);
        this.hEK = null;
        this.hEL = null;
        if (this.gPO != null) {
            this.gPO.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hTq.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.foP;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bWl = this.hTq.bWl();
        if (bWl == null || (findViewWithTag = bWl.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Bt(String str) {
        Map<String, String> nV;
        if (!TextUtils.isEmpty(str) && (nV = ba.nV(ba.nW(str))) != null) {
            this.hTB = true;
            String str2 = nV.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Bt(com.baidu.adp.lib.util.k.bi(str2));
            }
            String str3 = nV.get(hTn);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void d(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (Bt(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                    kVar.mLink = str;
                    kVar.type = 3;
                    kVar.cpG = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
                }
            } else {
                ba.aiz().c(getPageContext(), new String[]{str});
            }
            this.hTB = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hTB = true;
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
        if (this.hTq != null) {
            return this.hTq.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int ayg() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> ayi() {
        if (this.cLt == null) {
            this.cLt = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cLt;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> ayj() {
        if (this.cIF == null) {
            this.cIF = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bRX */
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
        return this.cIF;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> ayh() {
        if (this.cIE == null) {
            this.cIE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
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
        return this.cIE;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> ayk() {
        if (this.cLu == null) {
            this.cLu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bRY */
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
        return this.cLu;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> ayl() {
        if (this.cLv == null) {
            this.cLv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bSa */
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
        return this.cLv;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> aym() {
        this.cLw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bRZ */
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
        return this.cLw;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bQH() {
        return this.hEq;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bQI() {
        return (this.hTo == null || this.hTo.bWy() == null || this.hTo.bWy().abv() == null || this.hTo.bWy().abv().aeN()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bQJ() {
        if (this.hTo == null || this.hTo.bWy() == null || this.hTo.bWy().abv() == null) {
            return null;
        }
        return this.hTo.bWy().abv().adA();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bQK() {
        if (this.hTo == null) {
            return 0;
        }
        return this.hTo.bPY();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean AZ(String str) {
        if (StringUtils.isNull(str) || this.hTo == null || this.hTo.bWy() == null || this.hTo.bWy().abv() == null || this.hTo.bWy().abv().adv() == null) {
            return false;
        }
        return str.equals(this.hTo.bWy().abv().adv().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hTq.bWh() && com.baidu.adp.lib.util.l.ki()) {
            this.hTo.atv();
        } else {
            this.hTq.bWk();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.hTA);
        userMuteAddAndDelCustomMessage.setTag(this.hTA);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BC(String str) {
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
        if (pageStayDurationItem != null && this.hTo != null) {
            if (this.hTo.bWy() != null && this.hTo.bWy().bQB() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.hTo.bWy().bQB().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.hTo.bSJ(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.ddZ;
    }

    public boolean bWb() {
        if (this.hTo != null) {
            return this.hTo.bWb();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hTq.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hEK.getPageActivity());
        if (ap.isEmpty(str)) {
            aVar.mD(this.hEK.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.mD(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.hTq.showLoadingDialog();
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
        aVar.b(this.hEK).afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qe(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hEK.getPageActivity());
        aVar.mD(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hEK).afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.mD(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.hEK).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.hEK.getPageActivity(), 2, true, 4);
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
        aVar.b(this.hEK).afG();
    }

    public SubPbModel bWc() {
        return this.hTo;
    }

    public int bPY() {
        if (this.hTo != null) {
            return this.hTo.bPY();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.cre) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.cre) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void lk(boolean z) {
        if (this.ggh != null && this.ggh.getText() != null) {
            int selectionEnd = this.ggh.getSelectionEnd();
            SpannableStringBuilder b = this.ggg.b(this.ggh.getText());
            if (b != null) {
                this.ggg.rL(true);
                this.ggh.setText(b);
                if (z && this.ggg.cwe() >= 0) {
                    this.ggh.requestFocus();
                    this.ggh.setSelection(this.ggg.cwe());
                } else {
                    this.ggh.setSelection(selectionEnd);
                }
                this.ggg.rK(this.ggg.cwe() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gPW != null && this.gPW.aqS() != null && this.gPW.aqS().aqV()) {
            this.gPW.aqS().app();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    public String bUj() {
        if (!ap.isEmpty(this.hPz)) {
            return this.hPz;
        }
        this.hPz = getResources().getString(com.baidu.tieba.pb.pb.main.ap.bUb());
        return this.hPz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.hTE = z;
        pb(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pb(boolean z) {
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
        if (this.hTq != null && this.hTq.getListView() != null && this.hTF != null && this.hTF.mPosition != -1) {
            final int headerViewsCount = this.hTF.mPosition + this.hTq.getListView().getHeaderViewsCount();
            if (this.hTF.getView() != null) {
                final int height = this.hTF.getView().getHeight() - ((rect.height() - this.hTq.getNavigationBarHeight()) - this.hTq.bWv());
                if (height > 0) {
                    this.hTq.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.hTq != null && NewSubPbActivity.this.hTq.getListView() != null) {
                                NewSubPbActivity.this.hTq.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.hTq.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.hTq.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.hTq != null && NewSubPbActivity.this.hTq.getListView() != null) {
                                NewSubPbActivity.this.hTq.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.hTq.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }

    private void bRV() {
        if (this.hTo != null && !ap.isEmpty(this.hTo.bSJ())) {
            com.baidu.tbadk.BdToken.c.Yk().k(com.baidu.tbadk.BdToken.b.bwW, com.baidu.adp.lib.g.b.c(this.hTo.bSJ(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.hTo == null || ap.isEmpty(this.hTo.bSJ())) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.c(this.hTo.bSJ(), 0L);
    }
}
