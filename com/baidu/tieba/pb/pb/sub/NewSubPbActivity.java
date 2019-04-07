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
import com.baidu.tbadk.editortools.k;
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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.profession.permission.c;
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
    private com.baidu.adp.lib.e.b<ImageView> cAu;
    private com.baidu.adp.lib.e.b<GifView> cAv;
    private com.baidu.adp.lib.e.b<TextView> cDj;
    private com.baidu.adp.lib.e.b<View> cDk;
    private com.baidu.adp.lib.e.b<LinearLayout> cDl;
    private com.baidu.adp.lib.e.b<RelativeLayout> cDm;
    private View.OnLongClickListener cdf;
    private VoiceManager eYD;
    private com.baidu.tieba.write.b fOW;
    private EditText fOX;
    private com.baidu.tieba.frs.profession.permission.c fci;
    private au fzF;
    private g gyF;
    public aj gyx;
    private j hBA;
    private SubPbModel hBi;
    private ForumManageModel hBj;
    private b hBk;
    private y hBl;
    private AbsListView.OnScrollListener hBm;
    private TbRichTextView.i hBn;
    private TbRichTextView.h hBo;
    private SubPbModel.a hBp;
    private com.baidu.adp.base.d hBq;
    private BdUniqueId hBv;
    private com.baidu.tieba.pb.pb.sub.a hBx;
    private com.baidu.tieba.pb.d<com.baidu.tieba.pb.data.j> hBy;
    private boolean hBz;
    private com.baidu.tieba.pb.pb.report.a hmH;
    private com.baidu.tbadk.baseEditMark.a hmI;
    private com.baidu.tieba.pb.pb.main.b.a hmK;
    private b.InterfaceC0225b hnS;
    private com.baidu.adp.base.e hne;
    private com.baidu.tbadk.core.view.e hnf;
    private com.baidu.adp.widget.ImageView.a hni;
    private String hnj;
    private TbRichTextMemeInfo hnk;
    private PostWriteCallBackData hrm;
    private String hxM;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private static final String hzP = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String hBh = "tbgametype";
    private boolean mIsFromCDN = true;
    private int hnQ = 0;
    PostData fPE = null;
    private a.InterfaceC0221a hnN = null;
    private a hBr = null;
    private a hBs = null;
    private boolean hBt = false;
    private boolean hBu = false;
    private boolean hBw = false;
    private boolean ciU = false;
    private com.baidu.tbadk.editortools.pb.c ckn = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void amo() {
            NewSubPbActivity.this.hBk.bOm();
        }
    };
    private com.baidu.tbadk.editortools.pb.b cko = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean amn() {
            if (!NewSubPbActivity.this.fOW.cnY()) {
                return (NewSubPbActivity.this.gyx == null || NewSubPbActivity.this.hBi == null || NewSubPbActivity.this.hBi.bbG() == null || NewSubPbActivity.this.gyx.S(NewSubPbActivity.this.hBi.bbG().replyPrivateFlag, aj.bKw)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.fOW.coa());
            if (NewSubPbActivity.this.gyF.amD()) {
                NewSubPbActivity.this.gyF.a(NewSubPbActivity.this.hrm);
            }
            NewSubPbActivity.this.kt(true);
            return true;
        }
    };
    private NewWriteModel.d fPd = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.gyF != null && NewSubPbActivity.this.gyF.alP() != null) {
                NewSubPbActivity.this.gyF.alP().hide();
                if (NewSubPbActivity.this.hBi.bOH()) {
                    TiebaStatic.log(new am("c10367").bJ("post_id", NewSubPbActivity.this.hBi.aml()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fOW.Ei(null);
                NewSubPbActivity.this.fOW.aE(null);
                NewSubPbActivity.this.fOW.qU(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fOW.aE(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fOW.Ei(postWriteCallBackData.getErrorString());
                if (!v.T(NewSubPbActivity.this.fOW.cnW())) {
                    NewSubPbActivity.this.hrm = postWriteCallBackData;
                    if (NewSubPbActivity.this.gyF.amD()) {
                        NewSubPbActivity.this.gyF.a(NewSubPbActivity.this.hrm);
                    }
                    NewSubPbActivity.this.kt(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.gyx != null) {
                NewSubPbActivity.this.gyx.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.hBk.bOn();
        }
    };
    private CustomMessageListener hnG = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hBv) {
                NewSubPbActivity.this.hBk.aMt();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hnf.i(NewSubPbActivity.this.hne.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.hne.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.oX(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bJW();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ap.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.hne.getResources().getString(d.j.mute_fail);
                    }
                    NewSubPbActivity.this.hnf.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hnH = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hBv) {
                NewSubPbActivity.this.hBk.aMt();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hnf.i(NewSubPbActivity.this.hne.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ap.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.hne.getResources().getString(d.j.un_mute_fail);
                }
                NewSubPbActivity.this.hnf.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hnI = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hBv) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.hBk.aMt();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.iUd;
                if (aVar.error == 0 && dataRes != null) {
                    boolean z2 = com.baidu.adp.lib.g.b.l(dataRes.is_mute, 0) == 1;
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
                    NewSubPbActivity.this.hBk.a(sparseArray, z);
                }
            }
        }
    };
    boolean hnR = false;
    private final b.InterfaceC0225b hnT = new b.InterfaceC0225b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.hni != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnj)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.hnk == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hnj));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.hnj;
                        aVar.pkgId = NewSubPbActivity.this.hnk.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hnk.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.adN();
                    NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.Y(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.fzF == null) {
                            NewSubPbActivity.this.fzF = new au(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.fzF.h(NewSubPbActivity.this.hnj, NewSubPbActivity.this.hni.oB());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.hni = null;
                NewSubPbActivity.this.hnj = null;
            }
        }
    };
    private CustomMessageListener gct = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener eZV = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    l lVar = (l) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.hBi.bOB() != null && NewSubPbActivity.this.hBi.bOB().bIA() != null && NewSubPbActivity.this.hBi.bOB().bIA().YO() != null && currentAccount.equals(NewSubPbActivity.this.hBi.bOB().bIA().YO().getUserId()) && NewSubPbActivity.this.hBi.bOB().bIA().YO().getPendantData() != null) {
                        NewSubPbActivity.this.hBi.bOB().bIA().YO().getPendantData().lg(lVar.Xk());
                        NewSubPbActivity.this.hBi.bOB().bIA().YO().getPendantData().aR(lVar.alu());
                        NewSubPbActivity.this.hBk.a(NewSubPbActivity.this.hBi.bOB().bIA(), NewSubPbActivity.this.hBi.bOB().bvr(), NewSubPbActivity.this.hBi.bOB().UY(), NewSubPbActivity.this.hBi.bIi(), NewSubPbActivity.this.hBi.bON() != null);
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
        ab(bundle);
        if (this.ciU) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.hne = getPageContext();
        this.hBu = true;
        this.fOW = new com.baidu.tieba.write.b();
        this.fOW.AT(d.C0277d.cp_cont_h_alpha85);
        this.fOW.AS(d.C0277d.cp_btn_a);
        bgy();
        bOc();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bOb();
        this.hnf = new com.baidu.tbadk.core.view.e();
        this.hnf.bPQ = 1000L;
        registerListener(this.hnI);
        registerListener(this.hnG);
        registerListener(this.hnH);
        this.hBv = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hBv;
        userMuteAddAndDelCustomMessage.setTag(this.hBv);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hBv;
        userMuteCheckCustomMessage.setTag(this.hBv);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.gyx = new aj(getPageContext());
        this.gyx.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.gyF.amI();
                }
            }
        });
        this.hmH = new com.baidu.tieba.pb.pb.report.a(this);
        this.hmH.p(getUniqueId());
        this.hmK = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    private void bOb() {
        if (this.hBk != null && this.hBi != null && this.hBi.bOe()) {
            this.hBx = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.hBk.aDm());
            this.hBx.bgD();
            this.hBx.a(new a.InterfaceC0361a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
                private boolean fnb = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0361a
                public void bgz() {
                    NewSubPbActivity.this.hBk.jH(false);
                    this.fnb = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0361a
                public void bgA() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0361a
                public boolean bgB() {
                    if (!this.fnb) {
                        return NewSubPbActivity.this.hBk.bgP() != null && NewSubPbActivity.this.hBk.bgP().getTop() == 0;
                    }
                    this.fnb = false;
                    return false;
                }
            });
            this.hBk.e(this.hBx);
            this.hBk.jH(true);
        }
    }

    public void initUI() {
        this.hBk = new b(this, this.mCommonClickListener);
        this.hBk.a(this.hBi);
        setContentView(this.hBk.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.hBk.setOnScrollListener(this.hBm);
        this.hBk.b(this);
        this.hBk.setOnLinkImageClickListener(this.hBn);
        this.hBk.setOnImageClickListener(this.hBo);
        this.hBk.nc(true);
        this.hBk.setOnLongClickListener(this.cdf);
        this.hBk.d(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.40
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.hBi != null) {
                    NewSubPbActivity.this.hBi.aor();
                }
            }
        });
        this.hBk.a(this.hBr);
        this.hBk.b(this.hBs);
        if (this.hBi != null && this.hBi.bOe() && !this.hBi.bOM()) {
            this.hBk.bOr().setVisibility(8);
        } else {
            this.hBk.bOr().setVisibility(0);
        }
        if (this.hBi != null && !this.hBi.bOe()) {
            this.hBk.setIsFromPb(false);
        }
    }

    private boolean ab(Bundle bundle) {
        if (bundle != null) {
            this.ciU = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.ciU = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.ciU;
    }

    public void initData(Bundle bundle) {
        this.hBi = new SubPbModel(getPageContext());
        this.hBi.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                NewSubPbActivity.this.hBk.p(postData);
                NewSubPbActivity.this.hBk.b((BdListView.e) null);
            }
        });
        this.hBj = new ForumManageModel(getPageContext());
        this.hBj.setLoadDataCallBack(this.hBq);
        this.eYD = new VoiceManager();
        this.eYD.onCreate(getPageContext());
        this.hmI = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hmI != null) {
            this.hmI.a(this.hnN);
        }
        if (bundle != null) {
            this.hBi.initWithBundle(bundle);
        } else {
            this.hBi.initWithIntent(getIntent());
        }
        this.hBi.a(this.hBp);
        if (this.hBi.bOe()) {
            this.hBi.aor();
        } else {
            this.hBi.bOG();
        }
    }

    public void bOc() {
        this.hBp = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, com.baidu.tieba.pb.data.j jVar) {
                if (NewSubPbActivity.this.hBk != null) {
                    NewSubPbActivity.this.hBk.bOn();
                }
                if (NewSubPbActivity.this.hBx != null && NewSubPbActivity.this.hBx.bgE()) {
                    NewSubPbActivity.this.hBx.qL(d.C0277d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.az(i, str);
                    return;
                }
                NewSubPbActivity.this.hBk.hideNoDataView();
                if (jVar != null) {
                    if (jVar.bIA() != null || NewSubPbActivity.this.hBi != null) {
                        jVar.bIA().a(NewSubPbActivity.this.hBi.bOL());
                    }
                    if (NewSubPbActivity.this.hBk != null) {
                        NewSubPbActivity.this.hBk.a(jVar, NewSubPbActivity.this.hBi.bIi(), NewSubPbActivity.this.hBi.bON() != null);
                        if (NewSubPbActivity.this.hBu) {
                            NewSubPbActivity.this.bOd();
                            NewSubPbActivity.this.hBu = false;
                        }
                    }
                    if (NewSubPbActivity.this.gyF != null) {
                        NewSubPbActivity.this.gyF.a(jVar.bbG());
                    }
                    if (NewSubPbActivity.this.hBy == null) {
                        NewSubPbActivity.this.hBy = new com.baidu.tieba.pb.d();
                    }
                    NewSubPbActivity.this.hBy.setData(jVar);
                    NewSubPbActivity.this.hBy.setType(0);
                    NewSubPbActivity.this.gyx.a(NewSubPbActivity.this.hBi.bOQ());
                }
            }
        };
        this.hnN = new a.InterfaceC0221a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0221a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.hmI != null) {
                        NewSubPbActivity.this.hmI.cZ(z2);
                    }
                    MarkData Vb = NewSubPbActivity.this.hmI.Vb();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setType(2);
                    if (z2) {
                        dVar.setData(Vb);
                        if (NewSubPbActivity.this.hmI != null) {
                            if (Vb != null) {
                                NewSubPbActivity.this.hBi.on(true);
                                NewSubPbActivity.this.hBi.An(NewSubPbActivity.this.hBi.aml());
                                NewSubPbActivity.this.showToast(d.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.add_mark));
                            }
                            if (NewSubPbActivity.this.hBk != null) {
                                NewSubPbActivity.this.hBk.om(true);
                            }
                        }
                    } else {
                        dVar.setData(null);
                        NewSubPbActivity.this.hBi.on(false);
                        NewSubPbActivity.this.hBi.An(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.remove_mark));
                        if (NewSubPbActivity.this.hBk != null) {
                            NewSubPbActivity.this.hBk.om(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.update_mark_failed));
            }
        };
        this.hBr = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.hBi.bOB() != null && NewSubPbActivity.this.hBi.bOB().WO() != null && NewSubPbActivity.this.hBi.bOB().WO().YO() != null) {
                    str = String.valueOf(NewSubPbActivity.this.hBi.bOB().WO().YO().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.hBi.bOB().bIG().getId(), NewSubPbActivity.this.hBi.bOB().bIG().getName(), NewSubPbActivity.this.hBi.bOB().WO().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.hBs = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.hBj.cfb() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int l = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[1]), 0);
                        boolean e = com.baidu.adp.lib.g.b.e(String.valueOf(objArr[2]), false);
                        int l2 = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.hBi != null && NewSubPbActivity.this.hBi.bOB() != null && NewSubPbActivity.this.hBi.bOB().bIG() != null && NewSubPbActivity.this.hBi.bOB().WO() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.hBj.CE(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.hBj.a(NewSubPbActivity.this.hBi.bOB().bIG().getId(), NewSubPbActivity.this.hBi.bOB().bIG().getName(), NewSubPbActivity.this.hBi.bOB().WO().getId(), valueOf, l2, l, e);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.hBq = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.hBk.a(NewSubPbActivity.this.hBj.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.hBj.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.hCt != 1002 || bVar.fCT) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.hBk.a(1, dVar.Id, dVar.iIn, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean cm(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void bgy() {
        registerListener(this.eZV);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v63, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.hBk != null) {
                    if (view == NewSubPbActivity.this.hBk.bOx()) {
                        NewSubPbActivity.this.hBk.bMX();
                        String str = view.getTag(d.g.tag_user_id) instanceof String ? (String) view.getTag(d.g.tag_user_id) : null;
                        String str2 = view.getTag(d.g.tag_user_name) instanceof String ? (String) view.getTag(d.g.tag_user_name) : null;
                        String str3 = view.getTag(d.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(d.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ba.adA().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.hBk.bgQ()) {
                        if (view != NewSubPbActivity.this.hBk.bOq()) {
                            if (view != NewSubPbActivity.this.hBk.bOp()) {
                                if (view == NewSubPbActivity.this.hBk.bOl()) {
                                    NewSubPbActivity.this.hBk.bMX();
                                    if (NewSubPbActivity.this.hBi.aor()) {
                                        NewSubPbActivity.this.hBk.bOj();
                                    }
                                } else if (view == NewSubPbActivity.this.hBk.bOr() || view == NewSubPbActivity.this.hBk.bOs() || view == NewSubPbActivity.this.hBk.bOu()) {
                                    if (NewSubPbActivity.this.hBw) {
                                        NewSubPbActivity.this.hBw = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.hBi.bKO(), NewSubPbActivity.this.hBi.aml(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.hBi.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.hBi.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.hBk.bOv() == null || view != NewSubPbActivity.this.hBk.bOv().bLE()) {
                                    if (NewSubPbActivity.this.hBk.bOv() == null || view != NewSubPbActivity.this.hBk.bOv().bLH()) {
                                        if (NewSubPbActivity.this.hBk.bOv() == null || view != NewSubPbActivity.this.hBk.bOv().bLF()) {
                                            if (NewSubPbActivity.this.hBk.bOv() == null || view != NewSubPbActivity.this.hBk.bOv().bLG()) {
                                                if (NewSubPbActivity.this.hBk.bOv() == null || view != NewSubPbActivity.this.hBk.bOv().bLI()) {
                                                    if (view == NewSubPbActivity.this.hBk.bOo() || view == NewSubPbActivity.this.hBk.bOu()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.gyF.amL()) {
                                                                NewSubPbActivity.this.gyF.amM();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.gyF.oY(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof j)) {
                                                        if (NewSubPbActivity.this.hBl == null || view != NewSubPbActivity.this.hBl.bLG()) {
                                                            if (NewSubPbActivity.this.hBl == null || view != NewSubPbActivity.this.hBl.bLE()) {
                                                                if (NewSubPbActivity.this.hBl == null || view != NewSubPbActivity.this.hBl.bLH()) {
                                                                    if (NewSubPbActivity.this.hBl == null || view != NewSubPbActivity.this.hBl.bLI()) {
                                                                        if (NewSubPbActivity.this.hBl == null || view != NewSubPbActivity.this.hBl.bLK()) {
                                                                            if (NewSubPbActivity.this.hBl == null || view != NewSubPbActivity.this.hBl.bLL()) {
                                                                                if (NewSubPbActivity.this.hBl != null && view == NewSubPbActivity.this.hBl.bLF()) {
                                                                                    if (!com.baidu.adp.lib.util.j.kY()) {
                                                                                        NewSubPbActivity.this.showToast(d.j.network_not_available);
                                                                                        return;
                                                                                    }
                                                                                    SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                                                                                    if (sparseArray != null) {
                                                                                        boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue();
                                                                                        boolean booleanValue2 = ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue();
                                                                                        boolean booleanValue3 = ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue();
                                                                                        if (booleanValue) {
                                                                                            if (booleanValue3) {
                                                                                                sparseArray.put(d.g.tag_from, 1);
                                                                                                sparseArray.put(d.g.tag_check_mute_from, 2);
                                                                                                NewSubPbActivity.this.c(sparseArray);
                                                                                                return;
                                                                                            }
                                                                                            sparseArray.put(d.g.tag_check_mute_from, 2);
                                                                                            NewSubPbActivity.this.hBk.cs(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.hBk.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                            return;
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                int id = view.getId();
                                                                                if (id == d.g.pb_item_tail_content) {
                                                                                    if (bc.cZ(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(d.j.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                            TiebaStatic.log("c10056");
                                                                                            com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else if (id == d.g.richText && (view.getTag() instanceof SparseArray)) {
                                                                                    Object obj = ((SparseArray) view.getTag()).get(d.g.tag_clip_board);
                                                                                    if (obj instanceof PostData) {
                                                                                        PostData postData = (PostData) obj;
                                                                                        if (postData.getType() != PostData.iFN && !TextUtils.isEmpty(postData.getBimg_url()) && i.Wv().Wz()) {
                                                                                            NewSubPbActivity.this.Ak(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.hni != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnj)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.adN();
                                                                                NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.Y(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.fzF == null) {
                                                                                        NewSubPbActivity.this.fzF = new au(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.fzF.h(NewSubPbActivity.this.hnj, NewSubPbActivity.this.hni.oB());
                                                                                    NewSubPbActivity.this.hni = null;
                                                                                    NewSubPbActivity.this.hnj = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.hni != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnj)) {
                                                                            if (NewSubPbActivity.this.hnk == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hnj));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.hnj;
                                                                                aVar.pkgId = NewSubPbActivity.this.hnk.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hnk.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.hni = null;
                                                                            NewSubPbActivity.this.hnj = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.fPE != null) {
                                                                        NewSubPbActivity.this.fPE.eu(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.fPE = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                if (sparseArray2 != null && (sparseArray2.get(d.g.tag_del_post_type) instanceof Integer) && (sparseArray2.get(d.g.tag_del_post_id) instanceof String) && (sparseArray2.get(d.g.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(d.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.hBk.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.cl(view);
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (!com.baidu.adp.lib.util.j.kY()) {
                                                            NewSubPbActivity.this.showToast(d.j.network_not_available);
                                                            return;
                                                        } else {
                                                            Object tag = view.getTag();
                                                            if (tag instanceof String) {
                                                                NewSubPbActivity.this.zK((String) tag);
                                                                return;
                                                            } else if (tag instanceof SparseArray) {
                                                                SparseArray<Object> sparseArray3 = (SparseArray) tag;
                                                                if ((sparseArray3.get(d.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray3.get(d.g.tag_user_mute_visible)).booleanValue()) {
                                                                    sparseArray3.put(d.g.tag_from, 0);
                                                                    sparseArray3.put(d.g.tag_check_mute_from, 2);
                                                                    NewSubPbActivity.this.c(sparseArray3);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        NewSubPbActivity.this.hBA = (j) view.getTag();
                                                        if (bc.cZ(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.hBw) {
                                                                NewSubPbActivity.this.hBw = false;
                                                                return;
                                                            } else if (NewSubPbActivity.this.gyx == null || NewSubPbActivity.this.hBi == null || NewSubPbActivity.this.hBi.bbG() == null || NewSubPbActivity.this.gyx.hl(NewSubPbActivity.this.hBi.bbG().replyPrivateFlag)) {
                                                                if (NewSubPbActivity.this.hBx != null) {
                                                                    NewSubPbActivity.this.hBx.bgC();
                                                                }
                                                                SparseArray sparseArray4 = (SparseArray) view.getTag(d.g.tag_from);
                                                                if (sparseArray4 != null) {
                                                                    if (sparseArray4.get(d.g.tag_clip_board) instanceof PostData) {
                                                                        PostData postData2 = (PostData) sparseArray4.get(d.g.tag_clip_board);
                                                                        if (postData2 != null && postData2.YO() != null) {
                                                                            MetaData YO = postData2.YO();
                                                                            NewSubPbActivity.this.gyF.setReplyId(YO.getUserId());
                                                                            if (!(sparseArray4.get(d.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray4.get(d.g.tag_is_subpb)).booleanValue() : true)) {
                                                                                NewSubPbActivity.this.gyF.oZ("");
                                                                            } else {
                                                                                NewSubPbActivity.this.gyF.oZ(YO.getName_show());
                                                                            }
                                                                        }
                                                                        NewSubPbActivity.this.hBk.bOh();
                                                                    }
                                                                    if (NewSubPbActivity.this.hBz) {
                                                                        NewSubPbActivity.this.ol(false);
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
                                                    if (sparseArray5.get(d.g.tag_clip_board) instanceof PostData) {
                                                        ((PostData) sparseArray5.get(d.g.tag_clip_board)).eu(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new am("c11739").T("obj_locate", 4));
                                            if (!com.baidu.adp.lib.util.j.kY()) {
                                                NewSubPbActivity.this.showToast(d.j.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.hBk.bMX();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.zK(str4);
                                                    return;
                                                }
                                                return;
                                            } else if (tag2 instanceof SparseArray) {
                                                SparseArray<Object> sparseArray6 = (SparseArray) tag2;
                                                if ((sparseArray6.get(d.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray6.get(d.g.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray6.put(d.g.tag_from, 0);
                                                    sparseArray6.put(d.g.tag_check_mute_from, 2);
                                                    NewSubPbActivity.this.c(sparseArray6);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        } else if (com.baidu.adp.lib.util.j.kY()) {
                                            NewSubPbActivity.this.hBk.bMX();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.cv(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(d.j.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.hBk.bMX();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.hBk.a(((Integer) sparseArray7.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray7.get(d.g.tag_del_post_id), ((Integer) sparseArray7.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(d.g.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new am("c11739").T("obj_locate", 2));
                                    NewSubPbActivity.this.hBk.bMX();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.hBi.bOB() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.hBi.bOB().bIA());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.hBk.bOg();
                                NewSubPbActivity.this.hBk.bOh();
                                if (NewSubPbActivity.this.gyF != null) {
                                    NewSubPbActivity.this.gyF.amO();
                                    if (NewSubPbActivity.this.hBx != null) {
                                        NewSubPbActivity.this.hBx.bgC();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.hBk.bOg();
                            NewSubPbActivity.this.hBk.bOh();
                            if (NewSubPbActivity.this.gyF != null) {
                                NewSubPbActivity.this.gyF.amN();
                                if (NewSubPbActivity.this.hBx != null) {
                                    NewSubPbActivity.this.hBx.bgC();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.bJs();
                        if (NewSubPbActivity.this.hBi != null && NewSubPbActivity.this.hBi.bOB() != null && NewSubPbActivity.this.hBi.bOB().WO() != null && NewSubPbActivity.this.hBi.bOB().WO().YO() != null) {
                            TiebaStatic.log(new am("c13402").bJ("tid", NewSubPbActivity.this.hBi.bKO()).k(ImageViewerConfig.FORUM_ID, NewSubPbActivity.this.hBi.bOB().WO().getFid()).T("obj_locate", 5).bJ("uid", NewSubPbActivity.this.hBi.bOB().WO().YO().getUserId()));
                        }
                    }
                }
            }
        };
        this.hBm = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.hBk.bMX();
                }
                NewSubPbActivity.this.gyF.amM();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.hBk.bOw();
            }
        };
        this.hnS = new b.InterfaceC0225b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.hBi.bOB() != null) {
                    postData = NewSubPbActivity.this.hBi.bOB().bIA();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.eu(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.f(postData);
                    }
                }
            }
        };
        this.cdf = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            /* JADX WARN: Removed duplicated region for block: B:107:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
            /* JADX WARN: Removed duplicated region for block: B:92:0x029a  */
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
                if (sparseArray == null && NewSubPbActivity.this.cm(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.hni = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.hnj = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.hni != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnj)) {
                            if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hnk = null;
                            } else {
                                NewSubPbActivity.this.hnk = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                NewSubPbActivity.this.hBk.a(NewSubPbActivity.this.hnT, NewSubPbActivity.this.hni.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                NewSubPbActivity.this.fPE = (PostData) sparseArray2.get(d.g.tag_clip_board);
                                if (NewSubPbActivity.this.fPE != null && NewSubPbActivity.this.hmI != null) {
                                    if (NewSubPbActivity.this.hmI != null) {
                                        NewSubPbActivity.this.hmI.cZ(NewSubPbActivity.this.hBi.isMarked());
                                    }
                                    boolean z = NewSubPbActivity.this.hmI.UY() && NewSubPbActivity.this.fPE.getId() != null && NewSubPbActivity.this.fPE.getId().equals(NewSubPbActivity.this.hBi.bOI());
                                    if (NewSubPbActivity.this.hBl == null) {
                                        NewSubPbActivity.this.hBl = new y(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.mCommonClickListener);
                                        NewSubPbActivity.this.hBk.cw(NewSubPbActivity.this.hBl.getView());
                                        NewSubPbActivity.this.hBl.nC(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.hBl.showDialog();
                                    boolean isLogin = NewSubPbActivity.this.isLogin() & NewSubPbActivity.this.nj(sparseArray2.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue() : false);
                                    boolean booleanValue = sparseArray2.get(d.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(d.g.tag_is_subpb)).booleanValue() : false;
                                    if (z) {
                                        NewSubPbActivity.this.hBl.bLE().setText(d.j.remove_mark);
                                    } else {
                                        NewSubPbActivity.this.hBl.bLE().setText(d.j.mark);
                                    }
                                    if (booleanValue) {
                                        NewSubPbActivity.this.hBl.bLE().setVisibility(8);
                                    } else {
                                        NewSubPbActivity.this.hBl.bLE().setVisibility(0);
                                    }
                                    if (NewSubPbActivity.this.cm(view)) {
                                        if (NewSubPbActivity.this.hni != null && !NewSubPbActivity.this.hni.isGif()) {
                                            sparseArray2.put(d.g.tag_richtext_image, true);
                                        } else {
                                            sparseArray2.put(d.g.tag_richtext_image, false);
                                        }
                                        sparseArray2.put(d.g.tag_richtext_emotion, true);
                                    } else {
                                        sparseArray2.put(d.g.tag_richtext_image, false);
                                        sparseArray2.put(d.g.tag_richtext_emotion, false);
                                    }
                                    NewSubPbActivity.this.hBl.a(sparseArray2, NewSubPbActivity.this.bIi(), isLogin);
                                }
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            NewSubPbActivity.this.hni = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                NewSubPbActivity.this.hnj = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hnk = null;
                            } else {
                                NewSubPbActivity.this.hnk = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.hni = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.hnj = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.hnk = null;
                        } else {
                            NewSubPbActivity.this.hnk = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
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
        this.hBn = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void f(View view, String str) {
                NewSubPbActivity.this.o(null, str, "LINK_IMAGE");
            }
        };
        this.hBo = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        com.baidu.tieba.pb.data.j bOB = NewSubPbActivity.this.hBi.bOB();
                        TbRichText bh = NewSubPbActivity.this.bh(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bh != null && bh.ast() != null) {
                            tbRichTextData = bh.ast().get(NewSubPbActivity.this.hnQ);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.asA().asM()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (bOB == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (bOB.bIG() != null) {
                                        str4 = bOB.bIG().getName();
                                        str5 = bOB.bIG().getId();
                                    }
                                    if (bOB.WO() != null) {
                                        str6 = bOB.WO().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.hBi.bON() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.hBi.bON();
                                    z6 = NewSubPbActivity.this.hBi.bOP();
                                    arrayList2 = NewSubPbActivity.this.hBi.bOO();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.c(arrayList2, 0));
                                NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                                return;
                            }
                            NewSubPbActivity.this.hnR = false;
                            String str7 = "";
                            TbRichText cer = bOB.bIA().cer();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(cer, bh, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (bOB == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (bOB.bIG() != null) {
                                    str8 = bOB.bIG().getName();
                                    str9 = bOB.bIG().getId();
                                }
                                if (bOB.WO() != null) {
                                    str10 = bOB.WO().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.hBi.bON() != null) {
                                concurrentHashMap = NewSubPbActivity.this.hBi.bON();
                                z4 = NewSubPbActivity.this.hBi.bOP();
                                arrayList = NewSubPbActivity.this.hBi.bOO();
                                i2 = a2 + NewSubPbActivity.this.hBi.getOffset();
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
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
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
    public void cl(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null) {
            f(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo asA;
        if (tbRichText == tbRichText2) {
            this.hnR = true;
        }
        if (tbRichText != null && tbRichText.ast() != null) {
            int size = tbRichText.ast().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.ast().get(i6) != null && tbRichText.ast().get(i6).getType() == 8) {
                    i5++;
                    int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                    int width = tbRichText.ast().get(i6).asA().getWidth() * aR;
                    int height = tbRichText.ast().get(i6).asA().getHeight() * aR;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.ast().get(i6).asA().asM()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.ast().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (asA = tbRichTextData.asA()) != null) {
                            String asO = asA.asO();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = asO;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.hnR) {
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
        if (this.hBl != null) {
            this.hBl.nC(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo asA = tbRichTextData.asA();
        if (asA != null) {
            if (!StringUtils.isNull(asA.asL())) {
                return asA.asL();
            }
            if (asA.getHeight() * asA.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (asA.getHeight() * asA.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (asA.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * asA.getHeight())));
            } else {
                float width = asA.getWidth() / asA.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ap.bx(asA.Nv()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bh(String str, int i) {
        if (this.hBi == null || this.hBi.bOB() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.j bOB = this.hBi.bOB();
        TbRichText a2 = a(bOB.bIA(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bOB.bIA(), str, i);
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
        TbRichText cer = postData.cer();
        if (cer != null) {
            ArrayList<TbRichTextData> ast = cer.ast();
            int size = ast.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (ast.get(i3) != null && ast.get(i3).getType() == 8) {
                    i2++;
                    if (ast.get(i3).asA().asO().equals(str)) {
                        int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                        int width = ast.get(i3).asA().getWidth() * aR;
                        int height = ast.get(i3).asA().getHeight() * aR;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.hnQ = i3;
                        return cer;
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
    public void bJs() {
        if (this.fci == null) {
            this.fci = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.fci.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jl(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void n(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jm(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.gyx == null || NewSubPbActivity.this.hBi == null || NewSubPbActivity.this.hBi.bbG() == null || NewSubPbActivity.this.gyx.hl(NewSubPbActivity.this.hBi.bbG().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.gyF.amD()) {
                                NewSubPbActivity.this.gyF.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.hBk.bOg();
                            NewSubPbActivity.this.hBk.bOh();
                            if (NewSubPbActivity.this.gyF != null) {
                                NewSubPbActivity.this.gyF.amP();
                                if (NewSubPbActivity.this.hBx != null) {
                                    NewSubPbActivity.this.hBx.bgC();
                                }
                            }
                        }
                    }
                }
            });
        }
        if (this.hBi != null && this.hBi.bOB() != null && this.hBi.bOB().bIG() != null) {
            this.fci.q(this.hBi.bOB().bIG().getId(), com.baidu.adp.lib.g.b.d(this.hBi.bKO(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nj(boolean z) {
        if (this.hBi == null) {
            return false;
        }
        return ((bIi() != 0) || this.hBi.bOB() == null || this.hBi.bOB().WO() == null || this.hBi.bOB().WO().YO() == null || TextUtils.equals(this.hBi.bOB().WO().YO().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Context context, String str, String str2) {
        long templateId = this.hBi.bOB().bIA().cey() != null ? this.hBi.bOB().bIA().cey().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ba.adA().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.hBi.bOB().bIG().getId(), this.hBi.bOB().bIG().getName(), this.hBi.bOB().WO().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(int i, String str) {
        if (this.hBi.bOC()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.lo()) {
            if (i == 4) {
                this.hBk.vj(str + "(4)");
            } else {
                this.hBk.nQ(d.j.no_data_text);
            }
        } else {
            this.hBk.nQ(d.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.gyF = (g) new h().dd(getActivity());
        if (this.gyF != null) {
            this.gyF.a(getPageContext());
            this.gyF.b(this.hBi);
            this.gyF.b(this.fPd);
            this.gyF.a(this.ckn);
            this.gyF.a(this.cko);
            this.gyF.alP().eH(true);
            this.gyF.e(getPageContext());
        }
        if (this.hBk != null) {
            this.hBk.g(this.gyF);
        }
        if (this.gyF != null && this.hBi != null) {
            this.gyF.a(this.hBi.bbG());
            this.gyF.amM();
        }
        if (this.gyF != null) {
            this.gyF.amQ().setDefaultHint(bMo());
            this.gyF.amQ().setHint(bMo());
            this.fOX = this.gyF.amQ().getInputView();
            this.fOX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.fOW != null) {
                        if (!NewSubPbActivity.this.fOW.cnZ()) {
                            NewSubPbActivity.this.kt(false);
                        }
                        NewSubPbActivity.this.fOW.qV(false);
                    }
                }
            });
        }
    }

    public void bOd() {
        if (!TbadkCoreApplication.isLogin()) {
            this.gyF.amM();
        } else if (!StringUtils.isNull(this.hBi.bOJ())) {
            if (this.hBk.bOk() && com.baidu.adp.lib.util.l.lo()) {
                this.hBk.aYS();
            } else {
                this.hBk.bOn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(View view) {
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
                    this.hBk.cs(view);
                }
            } else if (booleanValue2) {
                this.hBk.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.hBk.bOt(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        final String str;
        if (!(sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue()) {
            String[] strArr = new String[1];
            strArr[0] = z ? getResources().getString(d.j.un_mute) : getResources().getString(d.j.mute);
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            bVar.gF(d.j.operation);
            bVar.a(strArr, new b.InterfaceC0225b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    switch (i) {
                        case 0:
                            String str2 = "";
                            String str3 = "";
                            String str4 = "";
                            String str5 = "";
                            String str6 = "";
                            if (sparseArray.get(d.g.tag_user_mute_mute_username) instanceof String) {
                                str2 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                            }
                            if (sparseArray.get(d.g.tag_user_mute_thread_id) instanceof String) {
                                str3 = (String) sparseArray.get(d.g.tag_user_mute_thread_id);
                            }
                            if (sparseArray.get(d.g.tag_user_mute_post_id) instanceof String) {
                                str4 = (String) sparseArray.get(d.g.tag_user_mute_post_id);
                            }
                            if (sparseArray.get(d.g.tag_user_mute_msg) instanceof String) {
                                str5 = (String) sparseArray.get(d.g.tag_user_mute_msg);
                            }
                            if (sparseArray.get(d.g.tag_user_mute_mute_nameshow) instanceof String) {
                                str6 = (String) sparseArray.get(d.g.tag_user_mute_mute_nameshow);
                            }
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.hBv);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.hBv);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).aaZ();
        }
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
        }
        this.hBk.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.hBv;
        userMuteCheckCustomMessage.setTag(this.hBv);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.hBk.a(0, bVar.Id, bVar.iIn, z);
            if (bVar.Id) {
                if (bVar.eFy == 1) {
                    if (this.hBk.getListView() instanceof BdTypeListView) {
                        List<m> data = ((BdTypeListView) this.hBk.getListView()).getData();
                        if (!v.T(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.hBk.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.eFy == 2) {
                    this.hBi.Am(bVar.mPostId);
                    this.hBk.a(this.hBi.bOB(), this.hBi.bIi(), this.hBi.bON() != null);
                    if (this.hBi.bOK()) {
                        this.hBi.oo(false);
                        this.hBk.bOi();
                        this.hBi.aor();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
            }
        }
    }

    public void zK(String str) {
        this.hmH.Ai(str);
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.hBi.isMarked() && postData.getId() != null && postData.getId().equals(this.hBi.bOI())) {
                z = true;
            }
            MarkData j = this.hBi.j(postData);
            if (j != null) {
                this.hBk.bMX();
                if (this.hmI != null) {
                    this.hmI.a(j);
                    if (!z) {
                        this.hmI.Va();
                    } else {
                        this.hmI.UZ();
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
        if (bundle != null && this.hBi != null) {
            this.hBi.aa(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.gyF != null) {
            this.gyF.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.gyF.alP().akm();
        this.gyF.amM();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gyF.b(writeData);
                this.gyF.setVoiceModel(pbEditorData.getVoiceModel());
                k jv = this.gyF.alP().jv(6);
                if (jv != null && jv.ciw != null) {
                    jv.ciw.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gyF.amI();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.eYD != null) {
            this.eYD.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.hBt = true;
        super.onPause();
        if (this.eYD != null) {
            this.eYD.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.gct);
        this.hBk.biO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.hBt = false;
        super.onResume();
        if (this.eYD != null) {
            this.eYD.onResume(getPageContext());
        }
        registerListener(this.gct);
        this.hBk.biP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eYD != null) {
            this.eYD.onStop(getPageContext());
        }
        this.gyF.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.hBy));
        this.hBi.cancelLoadData();
        this.hBi.destory();
        this.hBj.cancelLoadData();
        if (this.eYD != null) {
            this.eYD.onDestory(getPageContext());
        }
        this.hBk.bMX();
        this.hBk.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.hnG);
        MessageManager.getInstance().unRegisterListener(this.hnH);
        MessageManager.getInstance().unRegisterListener(this.hnI);
        MessageManager.getInstance().unRegisterListener(this.hBv);
        this.hne = null;
        this.hnf = null;
        if (this.gyx != null) {
            this.gyx.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hBk.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.eYD;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bOo = this.hBk.bOo();
        if (bOo == null || (findViewWithTag = bOo.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Ab(String str) {
        Map<String, String> mO;
        if (!TextUtils.isEmpty(str) && (mO = ba.mO(ba.mP(str))) != null) {
            this.hBw = true;
            String str2 = mO.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Ab(com.baidu.adp.lib.util.k.by(str2));
            }
            String str3 = mO.get(hBh);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (Ab(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                    kVar.mLink = str;
                    kVar.type = 3;
                    kVar.chw = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
                }
            } else {
                ba.adA().c(getPageContext(), new String[]{str});
            }
            this.hBw = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ay(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hBw = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void az(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aA(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aB(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void k(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.hBk != null) {
            return this.hBk.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int ata() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> atc() {
        if (this.cDj == null) {
            this.cDj = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cDj;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> atd() {
        if (this.cAv == null) {
            this.cAv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bKc */
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
        return this.cAv;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> atb() {
        if (this.cAu == null) {
            this.cAu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.adp.lib.e.c
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean Wz = i.Wv().Wz();
                    foreDrawableImageView.setDefaultBg(al.getDrawable(d.C0277d.common_color_10220));
                    if (Wz) {
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
                public void destroyObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.C0277d.cp_bg_line_c);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (i.Wv().Wz()) {
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
                public ImageView passivateObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.C0277d.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.cAu;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> ate() {
        if (this.cDk == null) {
            this.cDk = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bKd */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cn */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: co */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cp */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.cDk;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> atf() {
        if (this.cDl == null) {
            this.cDl = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bKf */
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
        return this.cDl;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> atg() {
        this.cDm = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bKe */
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
        return this.cDm;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bIM() {
        return this.hmK;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bIN() {
        return (this.hBi == null || this.hBi.bOB() == null || this.hBi.bOB().WO() == null || this.hBi.bOB().WO().aag()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bIO() {
        if (this.hBi == null || this.hBi.bOB() == null || this.hBi.bOB().WO() == null) {
            return null;
        }
        return this.hBi.bOB().WO().YT();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bIP() {
        if (this.hBi == null) {
            return 0;
        }
        return this.hBi.bIi();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean zH(String str) {
        if (StringUtils.isNull(str) || this.hBi == null || this.hBi.bOB() == null || this.hBi.bOB().WO() == null || this.hBi.bOB().WO().YO() == null) {
            return false;
        }
        return str.equals(this.hBi.bOB().WO().YO().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hBk.bOk() && com.baidu.adp.lib.util.l.lo()) {
            this.hBi.aor();
        } else {
            this.hBk.bOn();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.hBv);
        userMuteAddAndDelCustomMessage.setTag(this.hBv);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ak(String str) {
        if (!StringUtils.isNull(str) && bc.cZ(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("bubble_link", "");
            if (!StringUtils.isNull(string)) {
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                    return;
                }
                com.baidu.tbadk.browser.a.a(getPageContext().getPageActivity(), getResources().getString(d.j.editor_privilege), string + "?props_id=" + str, true, true, true);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aC(Context context, String str) {
        o(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean aoH() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int aoI() {
                return com.baidu.tbadk.pageStayDuration.e.aoM().aoP();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.hBi != null) {
            if (this.hBi.bOB() != null && this.hBi.bOB().bIG() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.hBi.bOB().bIG().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.hBi.bKO(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.hBt;
    }

    public boolean bOe() {
        if (this.hBi != null) {
            return this.hBi.bOe();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hBk.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hne.getPageActivity());
        if (ap.isEmpty(str)) {
            aVar.lz(this.hne.getResources().getString(d.j.block_mute_message_alert, str3));
        } else {
            aVar.lz(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.hBk.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hne).aaW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oX(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hne.getPageActivity());
        aVar.lz(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hne).aaW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.lz(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.hne).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.hne.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hne).aaW();
    }

    public SubPbModel bOf() {
        return this.hBi;
    }

    public int bIi() {
        if (this.hBi != null) {
            return this.hBi.bIi();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.ciU) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.ciU) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void kt(boolean z) {
        if (this.fOX != null && this.fOX.getText() != null) {
            int selectionEnd = this.fOX.getSelectionEnd();
            SpannableStringBuilder b = this.fOW.b(this.fOX.getText());
            if (b != null) {
                this.fOW.qV(true);
                this.fOX.setText(b);
                if (z && this.fOW.cnX() >= 0) {
                    this.fOX.requestFocus();
                    this.fOX.setSelection(this.fOW.cnX());
                } else {
                    this.fOX.setSelection(selectionEnd);
                }
                this.fOW.qU(this.fOW.cnX() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gyF != null && this.gyF.alP() != null && this.gyF.alP().alS()) {
            this.gyF.alP().akm();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    public String bMo() {
        if (!ap.isEmpty(this.hxM)) {
            return this.hxM;
        }
        this.hxM = getResources().getString(com.baidu.tieba.pb.pb.main.ap.bMg());
        return this.hxM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.hBz = z;
        ol(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ol(boolean z) {
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
        if (this.hBk != null && this.hBk.getListView() != null && this.hBA != null && this.hBA.mPosition != -1) {
            final int headerViewsCount = this.hBA.mPosition + this.hBk.getListView().getHeaderViewsCount();
            if (this.hBA.getView() != null) {
                final int height = this.hBA.getView().getHeight() - ((rect.height() - this.hBk.getNavigationBarHeight()) - this.hBk.bOy());
                if (height > 0) {
                    this.hBk.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.hBk != null && NewSubPbActivity.this.hBk.getListView() != null) {
                                NewSubPbActivity.this.hBk.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.hBk.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.hBk.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.hBk != null && NewSubPbActivity.this.hBk.getListView() != null) {
                                NewSubPbActivity.this.hBk.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.hBk.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }
}
