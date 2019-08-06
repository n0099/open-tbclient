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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
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
import com.baidu.tieba.pb.pb.main.ap;
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
    private static final String hYN = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String iax = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> cKf;
    private com.baidu.adp.lib.e.b<GifView> cKg;
    private com.baidu.adp.lib.e.b<TextView> cMU;
    private com.baidu.adp.lib.e.b<View> cMV;
    private com.baidu.adp.lib.e.b<LinearLayout> cMW;
    private com.baidu.adp.lib.e.b<RelativeLayout> cMX;
    private View.OnLongClickListener cmF;
    private au fWr;
    private VoiceManager fun;
    private com.baidu.tieba.frs.profession.permission.c fxS;
    public aj gWQ;
    private g gWY;
    private com.baidu.tieba.write.b gnl;
    private EditText gnm;
    private com.baidu.adp.base.e hLR;
    private com.baidu.tbadk.core.view.e hLS;
    private com.baidu.adp.widget.ImageView.a hLV;
    private String hLW;
    private TbRichTextMemeInfo hLX;
    private com.baidu.tieba.pb.pb.report.a hLt;
    private com.baidu.tbadk.baseEditMark.a hLu;
    private com.baidu.tieba.pb.pb.main.b.a hLx;
    private b.a hMG;
    private PostWriteCallBackData hQd;
    private String hWI;
    private b iaA;
    private y iaB;
    private AbsListView.OnScrollListener iaC;
    private TbRichTextView.i iaD;
    private TbRichTextView.h iaE;
    private SubPbModel.a iaF;
    private com.baidu.adp.base.d iaG;
    private BdUniqueId iaK;
    private com.baidu.tieba.pb.pb.sub.a iaM;
    private com.baidu.tieba.pb.e<k> iaN;
    private boolean iaO;
    private j iaP;
    private SubPbModel iay;
    private ForumManageModel iaz;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int hME = 0;
    PostData gnU = null;
    private a.InterfaceC0238a hMB = null;
    private a iaH = null;
    private a iaI = null;
    private boolean dfK = false;
    private boolean iaJ = false;
    private boolean iaL = false;
    private boolean csy = false;
    private com.baidu.tbadk.editortools.pb.c ctR = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void asz() {
            NewSubPbActivity.this.iaA.bZo();
        }
    };
    private com.baidu.tbadk.editortools.pb.b ctS = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean asy() {
            if (!NewSubPbActivity.this.gnl.czB()) {
                return (NewSubPbActivity.this.gWQ == null || NewSubPbActivity.this.iay == null || NewSubPbActivity.this.iay.bli() == null || NewSubPbActivity.this.gWQ.U(NewSubPbActivity.this.iay.bli().replyPrivateFlag, aj.bTo)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.gnl.czD());
            if (NewSubPbActivity.this.gWY.asO()) {
                NewSubPbActivity.this.gWY.a(NewSubPbActivity.this.hQd);
            }
            NewSubPbActivity.this.ly(true);
            return true;
        }
    };
    private NewWriteModel.d gns = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.gWY != null && NewSubPbActivity.this.gWY.asa() != null) {
                NewSubPbActivity.this.gWY.asa().hide();
                if (NewSubPbActivity.this.iay.bZK()) {
                    TiebaStatic.log(new an("c10367").bT("post_id", NewSubPbActivity.this.iay.asw()));
                }
            }
            if (z) {
                NewSubPbActivity.this.gnl.GB(null);
                NewSubPbActivity.this.gnl.aI(null);
                NewSubPbActivity.this.gnl.sa(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.gnl.aI(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.gnl.GB(postWriteCallBackData.getErrorString());
                if (!v.aa(NewSubPbActivity.this.gnl.czz())) {
                    NewSubPbActivity.this.hQd = postWriteCallBackData;
                    if (NewSubPbActivity.this.gWY.asO()) {
                        NewSubPbActivity.this.gWY.a(NewSubPbActivity.this.hQd);
                    }
                    NewSubPbActivity.this.ly(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.gWQ != null) {
                NewSubPbActivity.this.gWQ.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.iaA.bZp();
        }
    };
    private CustomMessageListener hMt = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iaK) {
                NewSubPbActivity.this.iaA.aUB();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hLS.i(NewSubPbActivity.this.hLR.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.hLR.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.qv(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bUS();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.hLR.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.hLS.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hMu = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iaK) {
                NewSubPbActivity.this.iaA.aUB();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hLS.i(NewSubPbActivity.this.hLR.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.hLR.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.hLS.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hMv = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iaK) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.iaA.aUB();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.juu;
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
                    NewSubPbActivity.this.iaA.a(sparseArray, z);
                }
            }
        }
    };
    boolean hMF = false;
    private final b.a hMH = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.hLV != null && !TextUtils.isEmpty(NewSubPbActivity.this.hLW)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.hLX == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hLW));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.hLW;
                        aVar.pkgId = NewSubPbActivity.this.hLX.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hLX.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.ajS();
                    NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.ad(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.fWr == null) {
                            NewSubPbActivity.this.fWr = new au(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.fWr.h(NewSubPbActivity.this.hLW, NewSubPbActivity.this.hLV.nN());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.hLV = null;
                NewSubPbActivity.this.hLW = null;
            }
        }
    };
    private CustomMessageListener gAP = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener fvI = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    l lVar = (l) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.iay.bZD() != null && NewSubPbActivity.this.iay.bZD().bTu() != null && NewSubPbActivity.this.iay.bZD().bTu().aey() != null && currentAccount.equals(NewSubPbActivity.this.iay.bZD().bTu().aey().getUserId()) && NewSubPbActivity.this.iay.bZD().bTu().aey().getPendantData() != null) {
                        NewSubPbActivity.this.iay.bZD().bTu().aey().getPendantData().mv(lVar.acV());
                        NewSubPbActivity.this.iay.bZD().bTu().aey().getPendantData().bh(lVar.arE());
                        NewSubPbActivity.this.iaA.a(NewSubPbActivity.this.iay.bZD().bTu(), NewSubPbActivity.this.iay.bZD().bFZ(), NewSubPbActivity.this.iay.bZD().aaB(), NewSubPbActivity.this.iay.bSX(), NewSubPbActivity.this.iay.bZQ() != null);
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
        if (this.csy) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.hLR = getPageContext();
        this.iaJ = true;
        this.gnl = new com.baidu.tieba.write.b();
        this.gnl.CL(R.color.cp_cont_h_alpha85);
        this.gnl.CK(R.color.cp_btn_a);
        bqg();
        bZe();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bZd();
        this.hLS = new com.baidu.tbadk.core.view.e();
        this.hLS.bYO = 1000L;
        registerListener(this.hMv);
        registerListener(this.hMt);
        registerListener(this.hMu);
        this.iaK = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.iaK;
        userMuteAddAndDelCustomMessage.setTag(this.iaK);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.iaK;
        userMuteCheckCustomMessage.setTag(this.iaK);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.gWQ = new aj(getPageContext());
        this.gWQ.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.gWY.asT();
                }
            }
        });
        this.hLt = new com.baidu.tieba.pb.pb.report.a(this);
        this.hLt.r(getUniqueId());
        this.hLx = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    private void bZd() {
        if (this.iaA != null && this.iay != null && this.iay.bZg()) {
            this.iaM = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.iaA.aLj());
            this.iaM.bql();
            this.iaM.a(new a.InterfaceC0385a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
                private boolean fJj = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0385a
                public void bqh() {
                    NewSubPbActivity.this.iaA.kD(false);
                    this.fJj = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0385a
                public void bqi() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0385a
                public boolean bqj() {
                    if (!this.fJj) {
                        return NewSubPbActivity.this.iaA.bqx() != null && NewSubPbActivity.this.iaA.bqx().getTop() == 0;
                    }
                    this.fJj = false;
                    return false;
                }
            });
            this.iaA.e(this.iaM);
            this.iaA.kD(true);
        }
    }

    public void initUI() {
        this.iaA = new b(this, this.mCommonClickListener);
        this.iaA.a(this.iay);
        setContentView(this.iaA.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.iaA.setOnScrollListener(this.iaC);
        this.iaA.b(this);
        this.iaA.setOnLinkImageClickListener(this.iaD);
        this.iaA.setOnImageClickListener(this.iaE);
        this.iaA.og(true);
        this.iaA.setOnLongClickListener(this.cmF);
        this.iaA.d(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.40
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.iay != null) {
                    NewSubPbActivity.this.iay.auF();
                }
            }
        });
        this.iaA.a(this.iaH);
        this.iaA.b(this.iaI);
        if (this.iay != null && this.iay.bZg() && !this.iay.bZP()) {
            this.iaA.bZt().setVisibility(8);
        } else {
            this.iaA.bZt().setVisibility(0);
        }
        if (this.iay != null && !this.iay.bZg()) {
            this.iaA.setIsFromPb(false);
        }
    }

    private boolean ac(Bundle bundle) {
        if (bundle != null) {
            this.csy = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.csy = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.csy;
    }

    public void initData(Bundle bundle) {
        this.iay = new SubPbModel(getPageContext());
        this.iay.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                NewSubPbActivity.this.iaA.p(postData);
                NewSubPbActivity.this.iaA.b((BdListView.e) null);
            }
        });
        this.iaz = new ForumManageModel(getPageContext());
        this.iaz.setLoadDataCallBack(this.iaG);
        this.fun = new VoiceManager();
        this.fun.onCreate(getPageContext());
        this.hLu = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hLu != null) {
            this.hLu.a(this.hMB);
        }
        if (bundle != null) {
            this.iay.initWithBundle(bundle);
        } else {
            this.iay.initWithIntent(getIntent());
        }
        this.iay.a(this.iaF);
        if (this.iay.bZg()) {
            this.iay.auF();
        } else {
            this.iay.bZI();
        }
    }

    public void bZe() {
        this.iaF = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, k kVar) {
                if (NewSubPbActivity.this.iaA != null) {
                    NewSubPbActivity.this.iaA.bZp();
                }
                if (NewSubPbActivity.this.iaM != null && NewSubPbActivity.this.iaM.bqm()) {
                    NewSubPbActivity.this.iaM.sn(R.color.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.aC(i, str);
                    return;
                }
                NewSubPbActivity.this.iaA.hideNoDataView();
                if (kVar != null) {
                    if (kVar.bTu() != null || NewSubPbActivity.this.iay != null) {
                        kVar.bTu().a(NewSubPbActivity.this.iay.bZO());
                    }
                    if (NewSubPbActivity.this.iaA != null) {
                        NewSubPbActivity.this.iaA.a(kVar, NewSubPbActivity.this.iay.bSX(), NewSubPbActivity.this.iay.bZQ() != null);
                        if (NewSubPbActivity.this.iaJ) {
                            NewSubPbActivity.this.bZf();
                            NewSubPbActivity.this.iaJ = false;
                        }
                    }
                    if (NewSubPbActivity.this.gWY != null) {
                        NewSubPbActivity.this.gWY.a(kVar.bli());
                    }
                    if (NewSubPbActivity.this.iaN == null) {
                        NewSubPbActivity.this.iaN = new com.baidu.tieba.pb.e();
                    }
                    NewSubPbActivity.this.iaN.setData(kVar);
                    NewSubPbActivity.this.iaN.setType(0);
                    NewSubPbActivity.this.gWQ.a(NewSubPbActivity.this.iay.bZT());
                }
            }
        };
        this.hMB = new a.InterfaceC0238a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0238a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.hLu != null) {
                        NewSubPbActivity.this.hLu.dx(z2);
                    }
                    MarkData aaE = NewSubPbActivity.this.hLu.aaE();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(aaE);
                        if (NewSubPbActivity.this.hLu != null) {
                            if (aaE != null) {
                                NewSubPbActivity.this.iay.pr(true);
                                NewSubPbActivity.this.iay.Cs(NewSubPbActivity.this.iay.asw());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.iaA != null) {
                                NewSubPbActivity.this.iaA.pq(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.iay.pr(false);
                        NewSubPbActivity.this.iay.Cs(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.iaA != null) {
                            NewSubPbActivity.this.iaA.pq(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.iaH = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.iay.bZD() != null && NewSubPbActivity.this.iay.bZD().acy() != null && NewSubPbActivity.this.iay.bZD().acy().aey() != null) {
                    str = String.valueOf(NewSubPbActivity.this.iay.bZD().acy().aey().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.iay.bZD().bTA().getId(), NewSubPbActivity.this.iay.bZD().bTA().getName(), NewSubPbActivity.this.iay.bZD().acy().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.iaI = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.iaz.cqx() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int f = com.baidu.adp.lib.g.b.f(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int f2 = com.baidu.adp.lib.g.b.f(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.iay != null && NewSubPbActivity.this.iay.bZD() != null && NewSubPbActivity.this.iay.bZD().bTA() != null && NewSubPbActivity.this.iay.bZD().acy() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.iaz.EQ(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.iaz.a(NewSubPbActivity.this.iay.bZD().bTA().getId(), NewSubPbActivity.this.iay.bZD().bTA().getName(), NewSubPbActivity.this.iay.bZD().acy().getId(), valueOf, f2, f, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.iaG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.iaA.a(NewSubPbActivity.this.iaz.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.iaz.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.ibI != 1002 || bVar.fZG) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.iaA.a(1, dVar.FU, dVar.jiM, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean cy(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void bqg() {
        registerListener(this.fvI);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v63, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.iaA != null) {
                    if (view == NewSubPbActivity.this.iaA.bZz()) {
                        NewSubPbActivity.this.iaA.bXY();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                bb.ajE().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.iaA.bqy()) {
                        if (view != NewSubPbActivity.this.iaA.bZs()) {
                            if (view != NewSubPbActivity.this.iaA.bZr()) {
                                if (view == NewSubPbActivity.this.iaA.bZn()) {
                                    NewSubPbActivity.this.iaA.bXY();
                                    if (NewSubPbActivity.this.iay.auF()) {
                                        NewSubPbActivity.this.iaA.bZl();
                                    }
                                } else if (view == NewSubPbActivity.this.iaA.bZt() || view == NewSubPbActivity.this.iaA.bZu() || view == NewSubPbActivity.this.iaA.bZw()) {
                                    if (NewSubPbActivity.this.iaL) {
                                        NewSubPbActivity.this.iaL = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.iay.bVL(), NewSubPbActivity.this.iay.asw(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.iay.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.iay.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.iaA.bZx() == null || view != NewSubPbActivity.this.iaA.bZx().bWC()) {
                                    if (NewSubPbActivity.this.iaA.bZx() == null || view != NewSubPbActivity.this.iaA.bZx().bWF()) {
                                        if (NewSubPbActivity.this.iaA.bZx() == null || view != NewSubPbActivity.this.iaA.bZx().bWD()) {
                                            if (NewSubPbActivity.this.iaA.bZx() == null || view != NewSubPbActivity.this.iaA.bZx().bWE()) {
                                                if (NewSubPbActivity.this.iaA.bZx() == null || view != NewSubPbActivity.this.iaA.bZx().bWG()) {
                                                    if (view == NewSubPbActivity.this.iaA.bZq() || view == NewSubPbActivity.this.iaA.bZw()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.gWY.asW()) {
                                                                NewSubPbActivity.this.gWY.asX();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.gWY.qw(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof j)) {
                                                        if (NewSubPbActivity.this.iaB == null || view != NewSubPbActivity.this.iaB.bWE()) {
                                                            if (NewSubPbActivity.this.iaB == null || view != NewSubPbActivity.this.iaB.bWC()) {
                                                                if (NewSubPbActivity.this.iaB == null || view != NewSubPbActivity.this.iaB.bWF()) {
                                                                    if (NewSubPbActivity.this.iaB == null || view != NewSubPbActivity.this.iaB.bWG()) {
                                                                        if (NewSubPbActivity.this.iaB == null || view != NewSubPbActivity.this.iaB.bWI()) {
                                                                            if (NewSubPbActivity.this.iaB == null || view != NewSubPbActivity.this.iaB.bWJ()) {
                                                                                if (NewSubPbActivity.this.iaB != null && view == NewSubPbActivity.this.iaB.bWD()) {
                                                                                    if (!com.baidu.adp.lib.util.j.kc()) {
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
                                                                                            NewSubPbActivity.this.iaA.cE(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.iaA.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                            return;
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                int id = view.getId();
                                                                                if (id == R.id.pb_item_tail_content) {
                                                                                    if (bd.cF(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("tail_link", "");
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
                                                                                        if (postData.getType() != PostData.jgf && !TextUtils.isEmpty(postData.getBimg_url()) && i.aca().ace()) {
                                                                                            NewSubPbActivity.this.Cp(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.hLV != null && !TextUtils.isEmpty(NewSubPbActivity.this.hLW)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.ajS();
                                                                                NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.ad(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.fWr == null) {
                                                                                        NewSubPbActivity.this.fWr = new au(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.fWr.h(NewSubPbActivity.this.hLW, NewSubPbActivity.this.hLV.nN());
                                                                                    NewSubPbActivity.this.hLV = null;
                                                                                    NewSubPbActivity.this.hLW = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.hLV != null && !TextUtils.isEmpty(NewSubPbActivity.this.hLW)) {
                                                                            if (NewSubPbActivity.this.hLX == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hLW));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.hLW;
                                                                                aVar.pkgId = NewSubPbActivity.this.hLX.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hLX.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.hLV = null;
                                                                            NewSubPbActivity.this.hLW = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.gnU != null) {
                                                                        NewSubPbActivity.this.gnU.em(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.gnU = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.iaA.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.cx(view);
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (!com.baidu.adp.lib.util.j.kc()) {
                                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                            return;
                                                        } else {
                                                            Object tag = view.getTag();
                                                            if (tag instanceof String) {
                                                                NewSubPbActivity.this.BP((String) tag);
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
                                                        NewSubPbActivity.this.iaP = (j) view.getTag();
                                                        if (bd.cF(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.iaL) {
                                                                NewSubPbActivity.this.iaL = false;
                                                                return;
                                                            } else if (NewSubPbActivity.this.gWQ == null || NewSubPbActivity.this.iay == null || NewSubPbActivity.this.iay.bli() == null || NewSubPbActivity.this.gWQ.m19if(NewSubPbActivity.this.iay.bli().replyPrivateFlag)) {
                                                                if (NewSubPbActivity.this.iaM != null) {
                                                                    NewSubPbActivity.this.iaM.bqk();
                                                                }
                                                                SparseArray sparseArray4 = (SparseArray) view.getTag(R.id.tag_from);
                                                                if (sparseArray4 != null) {
                                                                    if (sparseArray4.get(R.id.tag_clip_board) instanceof PostData) {
                                                                        PostData postData2 = (PostData) sparseArray4.get(R.id.tag_clip_board);
                                                                        if (postData2 != null && postData2.aey() != null) {
                                                                            MetaData aey = postData2.aey();
                                                                            NewSubPbActivity.this.gWY.setReplyId(aey.getUserId());
                                                                            if (!(sparseArray4.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.tag_is_subpb)).booleanValue() : true)) {
                                                                                NewSubPbActivity.this.gWY.qx("");
                                                                            } else {
                                                                                NewSubPbActivity.this.gWY.qx(aey.getName_show());
                                                                            }
                                                                        }
                                                                        NewSubPbActivity.this.iaA.bZj();
                                                                    }
                                                                    if (NewSubPbActivity.this.iaO) {
                                                                        NewSubPbActivity.this.pp(false);
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
                                                        ((PostData) sparseArray5.get(R.id.tag_clip_board)).em(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new an("c11739").P("obj_locate", 4));
                                            if (!com.baidu.adp.lib.util.j.kc()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.iaA.bXY();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.BP(str4);
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
                                        } else if (com.baidu.adp.lib.util.j.kc()) {
                                            NewSubPbActivity.this.iaA.bXY();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.cI(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.iaA.bXY();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.iaA.a(((Integer) sparseArray7.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray7.get(R.id.tag_del_post_id), ((Integer) sparseArray7.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new an("c11739").P("obj_locate", 2));
                                    NewSubPbActivity.this.iaA.bXY();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.iay.bZD() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.iay.bZD().bTu());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.iaA.bZi();
                                NewSubPbActivity.this.iaA.bZj();
                                if (NewSubPbActivity.this.gWY != null) {
                                    NewSubPbActivity.this.gWY.asZ();
                                    if (NewSubPbActivity.this.iaM != null) {
                                        NewSubPbActivity.this.iaM.bqk();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.iaA.bZi();
                            NewSubPbActivity.this.iaA.bZj();
                            if (NewSubPbActivity.this.gWY != null) {
                                NewSubPbActivity.this.gWY.asY();
                                if (NewSubPbActivity.this.iaM != null) {
                                    NewSubPbActivity.this.iaM.bqk();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.bUo();
                        if (NewSubPbActivity.this.iay != null && NewSubPbActivity.this.iay.bZD() != null && NewSubPbActivity.this.iay.bZD().acy() != null && NewSubPbActivity.this.iay.bZD().acy().aey() != null) {
                            TiebaStatic.log(new an("c13402").bT("tid", NewSubPbActivity.this.iay.bVL()).l("fid", NewSubPbActivity.this.iay.bZD().acy().getFid()).P("obj_locate", 5).bT("uid", NewSubPbActivity.this.iay.bZD().acy().aey().getUserId()));
                        }
                    }
                }
            }
        };
        this.iaC = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.iaA.bXY();
                }
                NewSubPbActivity.this.gWY.asX();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.iaA.bZy();
            }
        };
        this.hMG = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.iay.bZD() != null) {
                    postData = NewSubPbActivity.this.iay.bZD().bTu();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.em(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.f(postData);
                    }
                }
            }
        };
        this.cmF = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                if (sparseArray == null && NewSubPbActivity.this.cy(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.hLV = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.hLW = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.hLV != null && !TextUtils.isEmpty(NewSubPbActivity.this.hLW)) {
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hLX = null;
                            } else {
                                NewSubPbActivity.this.hLX = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                NewSubPbActivity.this.iaA.a(NewSubPbActivity.this.hMH, NewSubPbActivity.this.hLV.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                NewSubPbActivity.this.gnU = (PostData) sparseArray2.get(R.id.tag_clip_board);
                                if (NewSubPbActivity.this.gnU != null && NewSubPbActivity.this.hLu != null) {
                                    if (NewSubPbActivity.this.hLu != null) {
                                        NewSubPbActivity.this.hLu.dx(NewSubPbActivity.this.iay.bZJ());
                                    }
                                    boolean z = NewSubPbActivity.this.hLu.aaB() && NewSubPbActivity.this.gnU.getId() != null && NewSubPbActivity.this.gnU.getId().equals(NewSubPbActivity.this.iay.bZL());
                                    if (NewSubPbActivity.this.iaB == null) {
                                        NewSubPbActivity.this.iaB = new y(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.mCommonClickListener);
                                        NewSubPbActivity.this.iaA.cJ(NewSubPbActivity.this.iaB.getView());
                                        NewSubPbActivity.this.iaB.oG(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.iaB.showDialog();
                                    boolean isLogin = NewSubPbActivity.this.isLogin() & NewSubPbActivity.this.on(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false);
                                    boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                                    if (z) {
                                        NewSubPbActivity.this.iaB.bWC().setText(R.string.remove_mark);
                                    } else {
                                        NewSubPbActivity.this.iaB.bWC().setText(R.string.mark);
                                    }
                                    if (booleanValue) {
                                        NewSubPbActivity.this.iaB.bWC().setVisibility(8);
                                    } else {
                                        NewSubPbActivity.this.iaB.bWC().setVisibility(0);
                                    }
                                    if (NewSubPbActivity.this.cy(view)) {
                                        if (NewSubPbActivity.this.hLV != null && !NewSubPbActivity.this.hLV.isGif()) {
                                            sparseArray2.put(R.id.tag_richtext_image, true);
                                        } else {
                                            sparseArray2.put(R.id.tag_richtext_image, false);
                                        }
                                        sparseArray2.put(R.id.tag_richtext_emotion, true);
                                    } else {
                                        sparseArray2.put(R.id.tag_richtext_image, false);
                                        sparseArray2.put(R.id.tag_richtext_emotion, false);
                                    }
                                    NewSubPbActivity.this.iaB.a(sparseArray2, NewSubPbActivity.this.bSX(), isLogin);
                                }
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            NewSubPbActivity.this.hLV = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                NewSubPbActivity.this.hLW = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hLX = null;
                            } else {
                                NewSubPbActivity.this.hLX = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.hLV = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.hLW = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.hLX = null;
                        } else {
                            NewSubPbActivity.this.hLX = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
        this.iaD = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void f(View view, String str) {
                NewSubPbActivity.this.r(null, str, "LINK_IMAGE");
            }
        };
        this.iaE = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                        k bZD = NewSubPbActivity.this.iay.bZD();
                        TbRichText be = NewSubPbActivity.this.be(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (be != null && be.ayN() != null) {
                            tbRichTextData = be.ayN().get(NewSubPbActivity.this.hME);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.ayU().azg()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (bZD == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (bZD.bTA() != null) {
                                        str4 = bZD.bTA().getName();
                                        str5 = bZD.bTA().getId();
                                    }
                                    if (bZD.acy() != null) {
                                        str6 = bZD.acy().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.iay.bZQ() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.iay.bZQ();
                                    z6 = NewSubPbActivity.this.iay.bZS();
                                    arrayList2 = NewSubPbActivity.this.iay.bZR();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.c(arrayList2, 0));
                                NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                                return;
                            }
                            NewSubPbActivity.this.hMF = false;
                            String str7 = "";
                            TbRichText cpN = bZD.bTu().cpN();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(cpN, be, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (bZD == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (bZD.bTA() != null) {
                                    str8 = bZD.bTA().getName();
                                    str9 = bZD.bTA().getId();
                                }
                                if (bZD.acy() != null) {
                                    str10 = bZD.acy().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.iay.bZQ() != null) {
                                concurrentHashMap = NewSubPbActivity.this.iay.bZQ();
                                z4 = NewSubPbActivity.this.iay.bZS();
                                arrayList = NewSubPbActivity.this.iay.bZR();
                                i2 = a2 + NewSubPbActivity.this.iay.getOffset();
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
    public void cx(View view) {
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
        TbRichTextImageInfo ayU;
        if (tbRichText == tbRichText2) {
            this.hMF = true;
        }
        if (tbRichText != null && tbRichText.ayN() != null) {
            int size = tbRichText.ayN().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.ayN().get(i6) != null && tbRichText.ayN().get(i6).getType() == 8) {
                    i5++;
                    int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                    int width = tbRichText.ayN().get(i6).ayU().getWidth() * ai;
                    int height = tbRichText.ayN().get(i6).ayU().getHeight() * ai;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.ayN().get(i6).ayU().azg()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.ayN().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (ayU = tbRichTextData.ayU()) != null) {
                            String azi = ayU.azi();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = azi;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.hMF) {
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
        if (this.iaB != null) {
            this.iaB.oG(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo ayU = tbRichTextData.ayU();
        if (ayU != null) {
            if (!StringUtils.isNull(ayU.azf())) {
                return ayU.azf();
            }
            if (ayU.getHeight() * ayU.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (ayU.getHeight() * ayU.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (ayU.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * ayU.getHeight())));
            } else {
                float width = ayU.getWidth() / ayU.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.bi(ayU.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText be(String str, int i) {
        if (this.iay == null || this.iay.bZD() == null || str == null || i < 0) {
            return null;
        }
        k bZD = this.iay.bZD();
        TbRichText a2 = a(bZD.bTu(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bZD.bTu(), str, i);
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
        TbRichText cpN = postData.cpN();
        if (cpN != null) {
            ArrayList<TbRichTextData> ayN = cpN.ayN();
            int size = ayN.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (ayN.get(i3) != null && ayN.get(i3).getType() == 8) {
                    i2++;
                    if (ayN.get(i3).ayU().azi().equals(str)) {
                        int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                        int width = ayN.get(i3).ayU().getWidth() * ai;
                        int height = ayN.get(i3).ayU().getHeight() * ai;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.hME = i3;
                        return cpN;
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
    public void bUo() {
        if (this.fxS == null) {
            this.fxS = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.fxS.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void kf(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void n(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void kg(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.gWQ == null || NewSubPbActivity.this.iay == null || NewSubPbActivity.this.iay.bli() == null || NewSubPbActivity.this.gWQ.m19if(NewSubPbActivity.this.iay.bli().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.gWY.asO()) {
                                NewSubPbActivity.this.gWY.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.iaA.bZi();
                            NewSubPbActivity.this.iaA.bZj();
                            if (NewSubPbActivity.this.gWY != null) {
                                NewSubPbActivity.this.gWY.ata();
                                if (NewSubPbActivity.this.iaM != null) {
                                    NewSubPbActivity.this.iaM.bqk();
                                }
                            }
                        }
                    }
                }
            });
        }
        if (this.iay != null && this.iay.bZD() != null && this.iay.bZD().bTA() != null) {
            this.fxS.t(this.iay.bZD().bTA().getId(), com.baidu.adp.lib.g.b.c(this.iay.bVL(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean on(boolean z) {
        if (this.iay == null) {
            return false;
        }
        return ((bSX() != 0) || this.iay.bZD() == null || this.iay.bZD().acy() == null || this.iay.bZD().acy().aey() == null || TextUtils.equals(this.iay.bZD().acy().aey().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Context context, String str, String str2) {
        long templateId = this.iay.bZD().bTu().cpU() != null ? this.iay.bZD().bTu().cpU().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && bb.ajE().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.iay.bZD().bTA().getId(), this.iay.bZD().bTA().getName(), this.iay.bZD().acy().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i, String str) {
        if (this.iay.bZE()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.kt()) {
            if (i == 4) {
                this.iaA.vq(str + "(4)");
            } else {
                this.iaA.oX(R.string.no_data_text);
            }
        } else {
            this.iaA.oX(R.string.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.gWY = (g) new h().cK(getActivity());
        if (this.gWY != null) {
            this.gWY.a(getPageContext());
            this.gWY.b(this.iay);
            this.gWY.b(this.gns);
            this.gWY.a(this.ctR);
            this.gWY.a(this.ctS);
            this.gWY.asa().fh(true);
            this.gWY.e(getPageContext());
        }
        if (this.iaA != null) {
            this.iaA.g(this.gWY);
        }
        if (this.gWY != null && this.iay != null) {
            this.gWY.a(this.iay.bli());
            this.gWY.asX();
        }
        if (this.gWY != null) {
            this.gWY.atb().setDefaultHint(bXn());
            this.gWY.atb().setHint(bXn());
            this.gnm = this.gWY.atb().getInputView();
            this.gnm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.gnl != null) {
                        if (!NewSubPbActivity.this.gnl.czC()) {
                            NewSubPbActivity.this.ly(false);
                        }
                        NewSubPbActivity.this.gnl.sb(false);
                    }
                }
            });
        }
    }

    public void bZf() {
        if (!TbadkCoreApplication.isLogin()) {
            this.gWY.asX();
        } else if (!StringUtils.isNull(this.iay.bZM())) {
            if (this.iaA.bZm() && com.baidu.adp.lib.util.l.kt()) {
                this.iaA.biz();
            } else {
                this.iaA.bZp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(View view) {
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
                    this.iaA.cE(view);
                }
            } else if (booleanValue2) {
                this.iaA.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.iaA.bZv(), getPageContext().getPageActivity());
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
            bVar.hy(R.string.operation);
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.iaK);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.iaK);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).agN();
        }
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.iaA.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.iaK;
        userMuteCheckCustomMessage.setTag(this.iaK);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.iaA.a(0, bVar.FU, bVar.jiM, z);
            if (bVar.FU) {
                if (bVar.faI == 1) {
                    if (this.iaA.getListView() instanceof BdTypeListView) {
                        List<m> data = ((BdTypeListView) this.iaA.getListView()).getData();
                        if (!v.aa(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.iaA.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.faI == 2) {
                    this.iay.Cr(bVar.mPostId);
                    this.iaA.a(this.iay.bZD(), this.iay.bSX(), this.iay.bZQ() != null);
                    if (this.iay.bZN()) {
                        this.iay.ps(false);
                        this.iaA.bZk();
                        this.iay.auF();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
            }
        }
    }

    public void BP(String str) {
        this.hLt.Cn(str);
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.iay.bZJ() && postData.getId() != null && postData.getId().equals(this.iay.bZL())) {
                z = true;
            }
            MarkData j = this.iay.j(postData);
            if (j != null) {
                this.iaA.bXY();
                if (this.hLu != null) {
                    this.hLu.a(j);
                    if (!z) {
                        this.hLu.aaD();
                    } else {
                        this.hLu.aaC();
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
        if (bundle != null && this.iay != null) {
            this.iay.ab(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.gWY != null) {
            this.gWY.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.gWY.asa().aqw();
        this.gWY.asX();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gWY.b(writeData);
                this.gWY.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k kq = this.gWY.asa().kq(6);
                if (kq != null && kq.csa != null) {
                    kq.csa.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gWY.asT();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fun != null) {
            this.fun.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.dfK = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.Zg().Zl();
        if (this.fun != null) {
            this.fun.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.gAP);
        this.iaA.bsz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.dfK = false;
        super.onResume();
        bUW();
        if (this.fun != null) {
            this.fun.onResume(getPageContext());
        }
        registerListener(this.gAP);
        this.iaA.bsA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fun != null) {
            this.fun.onStop(getPageContext());
        }
        this.gWY.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.iaN));
        this.iay.cancelLoadData();
        this.iay.destory();
        this.iaz.cancelLoadData();
        if (this.fun != null) {
            this.fun.onDestory(getPageContext());
        }
        this.iaA.bXY();
        this.iaA.aFQ();
        MessageManager.getInstance().unRegisterListener(this.hMt);
        MessageManager.getInstance().unRegisterListener(this.hMu);
        MessageManager.getInstance().unRegisterListener(this.hMv);
        MessageManager.getInstance().unRegisterListener(this.iaK);
        this.hLR = null;
        this.hLS = null;
        if (this.gWQ != null) {
            this.gWQ.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iaA.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.fun;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bZq = this.iaA.bZq();
        if (bZq == null || (findViewWithTag = bZq.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Cg(String str) {
        Map<String, String> oo;
        if (!TextUtils.isEmpty(str) && (oo = bb.oo(bb.op(str))) != null) {
            this.iaL = true;
            String str2 = oo.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Cg(com.baidu.adp.lib.util.k.bj(str2));
            }
            String str3 = oo.get(iax);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void d(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (Cg(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                    kVar.mLink = str;
                    kVar.type = 3;
                    kVar.cqZ = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
                }
            } else {
                bb.ajE().c(getPageContext(), new String[]{str});
            }
            this.iaL = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void al(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iaL = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void n(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.iaA != null) {
            return this.iaA.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int azu() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> azw() {
        if (this.cMU == null) {
            this.cMU = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cMU;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> azx() {
        if (this.cKg == null) {
            this.cKg = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bUZ */
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
        return this.cKg;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> azv() {
        if (this.cKf == null) {
            this.cKf = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.adp.lib.e.c
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean ace = i.aca().ace();
                    foreDrawableImageView.setDefaultBg(am.getDrawable(R.color.common_color_10220));
                    if (ace) {
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
                        if (i.aca().ace()) {
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
        return this.cKf;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> azy() {
        if (this.cMV == null) {
            this.cMV = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bVa */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cz */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cA */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cB */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.cMV;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> azz() {
        if (this.cMW == null) {
            this.cMW = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bVc */
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
        return this.cMW;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> azA() {
        this.cMX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bVb */
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
        return this.cMX;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bTG() {
        return this.hLx;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bTH() {
        return (this.iay == null || this.iay.bZD() == null || this.iay.bZD().acy() == null || this.iay.bZD().acy().afQ()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bTI() {
        if (this.iay == null || this.iay.bZD() == null || this.iay.bZD().acy() == null) {
            return null;
        }
        return this.iay.bZD().acy().aeD();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bTJ() {
        if (this.iay == null) {
            return 0;
        }
        return this.iay.bSX();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean BM(String str) {
        if (StringUtils.isNull(str) || this.iay == null || this.iay.bZD() == null || this.iay.bZD().acy() == null || this.iay.bZD().acy().aey() == null) {
            return false;
        }
        return str.equals(this.iay.bZD().acy().aey().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.iaA.bZm() && com.baidu.adp.lib.util.l.kt()) {
            this.iay.auF();
        } else {
            this.iaA.bZp();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.iaK);
        userMuteAddAndDelCustomMessage.setTag(this.iaK);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cp(String str) {
        if (!StringUtils.isNull(str) && bd.cF(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("bubble_link", "");
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
    public void ap(Context context, String str) {
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
            public boolean auV() {
                return false;
            }

            @Override // com.baidu.tbadk.o.b
            public int auW() {
                return com.baidu.tbadk.o.e.avb().ave();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.iay != null) {
            if (this.iay.bZD() != null && this.iay.bZD().bTA() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.iay.bZD().bTA().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.iay.bVL(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.dfK;
    }

    public boolean bZg() {
        if (this.iay != null) {
            return this.iay.bZg();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.iaA.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hLR.getPageActivity());
        if (aq.isEmpty(str)) {
            aVar.mO(this.hLR.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.mO(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.iaA.showLoadingDialog();
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
        aVar.b(this.hLR).agK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qv(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hLR.getPageActivity());
        aVar.mO(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hLR).agK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.mO(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.hLR).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.hLR.getPageActivity(), 2, true, 4);
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
        aVar.b(this.hLR).agK();
    }

    public SubPbModel bZh() {
        return this.iay;
    }

    public int bSX() {
        if (this.iay != null) {
            return this.iay.bSX();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.csy) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.csy) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void ly(boolean z) {
        if (this.gnm != null && this.gnm.getText() != null) {
            int selectionEnd = this.gnm.getSelectionEnd();
            SpannableStringBuilder b = this.gnl.b(this.gnm.getText());
            if (b != null) {
                this.gnl.sb(true);
                this.gnm.setText(b);
                if (z && this.gnl.czA() >= 0) {
                    this.gnm.requestFocus();
                    this.gnm.setSelection(this.gnl.czA());
                } else {
                    this.gnm.setSelection(selectionEnd);
                }
                this.gnl.sa(this.gnl.czA() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gWY != null && this.gWY.asa() != null && this.gWY.asa().asd()) {
            this.gWY.asa().aqw();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    public String bXn() {
        if (!aq.isEmpty(this.hWI)) {
            return this.hWI;
        }
        this.hWI = getResources().getString(ap.bXf());
        return this.hWI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.iaO = z;
        pp(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pp(boolean z) {
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
        if (this.iaA != null && this.iaA.getListView() != null && this.iaP != null && this.iaP.mPosition != -1) {
            final int headerViewsCount = this.iaP.mPosition + this.iaA.getListView().getHeaderViewsCount();
            if (this.iaP.getView() != null) {
                final int height = this.iaP.getView().getHeight() - ((rect.height() - this.iaA.getNavigationBarHeight()) - this.iaA.bZA());
                if (height > 0) {
                    this.iaA.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.iaA != null && NewSubPbActivity.this.iaA.getListView() != null) {
                                NewSubPbActivity.this.iaA.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.iaA.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.iaA.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.iaA != null && NewSubPbActivity.this.iaA.getListView() != null) {
                                NewSubPbActivity.this.iaA.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.iaA.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }

    private void bUW() {
        if (this.iay != null && !aq.isEmpty(this.iay.bVL())) {
            com.baidu.tbadk.BdToken.c.Zg().k(com.baidu.tbadk.BdToken.b.bxN, com.baidu.adp.lib.g.b.c(this.iay.bVL(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.iay == null || aq.isEmpty(this.iay.bVL())) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.c(this.iay.bVL(), 0L);
    }
}
