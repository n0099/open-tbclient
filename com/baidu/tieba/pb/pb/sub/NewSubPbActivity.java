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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
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
    private static final String iaK = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String icv = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> cKV;
    private com.baidu.adp.lib.e.b<GifView> cKW;
    private com.baidu.adp.lib.e.b<TextView> cNK;
    private com.baidu.adp.lib.e.b<View> cNL;
    private com.baidu.adp.lib.e.b<LinearLayout> cNM;
    private com.baidu.adp.lib.e.b<RelativeLayout> cNN;
    private View.OnLongClickListener cnB;
    private au fYi;
    private VoiceManager fwa;
    private com.baidu.tieba.frs.profession.permission.c fzF;
    public aj gYK;
    private g gYS;
    private com.baidu.tieba.write.b gpc;
    private EditText gpd;
    private com.baidu.adp.base.e hNO;
    private com.baidu.tbadk.core.view.e hNP;
    private com.baidu.adp.widget.ImageView.a hNS;
    private String hNT;
    private TbRichTextMemeInfo hNU;
    private com.baidu.tieba.pb.pb.report.a hNq;
    private com.baidu.tbadk.baseEditMark.a hNr;
    private com.baidu.tieba.pb.pb.main.b.a hNu;
    private b.a hOD;
    private PostWriteCallBackData hSa;
    private String hYF;
    private AbsListView.OnScrollListener icA;
    private TbRichTextView.i icB;
    private TbRichTextView.h icC;
    private SubPbModel.a icD;
    private com.baidu.adp.base.d icE;
    private BdUniqueId icI;
    private com.baidu.tieba.pb.pb.sub.a icK;
    private com.baidu.tieba.pb.e<k> icL;
    private boolean icM;
    private j icN;
    private SubPbModel icw;
    private ForumManageModel icx;
    private b icy;
    private y icz;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int hOB = 0;
    PostData gpL = null;
    private a.InterfaceC0247a hOy = null;
    private a icF = null;
    private a icG = null;
    private boolean dhv = false;
    private boolean icH = false;
    private boolean icJ = false;
    private boolean cts = false;
    private com.baidu.tbadk.editortools.pb.c cuO = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void asL() {
            NewSubPbActivity.this.icy.cac();
        }
    };
    private com.baidu.tbadk.editortools.pb.b cuP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean asK() {
            if (!NewSubPbActivity.this.gpc.cAp()) {
                return (NewSubPbActivity.this.gYK == null || NewSubPbActivity.this.icw == null || NewSubPbActivity.this.icw.blT() == null || NewSubPbActivity.this.gYK.U(NewSubPbActivity.this.icw.blT().replyPrivateFlag, aj.bTP)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.gpc.cAr());
            if (NewSubPbActivity.this.gYS.ata()) {
                NewSubPbActivity.this.gYS.a(NewSubPbActivity.this.hSa);
            }
            NewSubPbActivity.this.lB(true);
            return true;
        }
    };
    private NewWriteModel.d gpj = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.y yVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.gYS != null && NewSubPbActivity.this.gYS.asm() != null) {
                NewSubPbActivity.this.gYS.asm().hide();
                if (NewSubPbActivity.this.icw.cay()) {
                    TiebaStatic.log(new an("c10367").bT("post_id", NewSubPbActivity.this.icw.asI()));
                }
            }
            if (z) {
                NewSubPbActivity.this.gpc.Hb(null);
                NewSubPbActivity.this.gpc.aI(null);
                NewSubPbActivity.this.gpc.sd(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.gpc.aI(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.gpc.Hb(postWriteCallBackData.getErrorString());
                if (!v.aa(NewSubPbActivity.this.gpc.cAn())) {
                    NewSubPbActivity.this.hSa = postWriteCallBackData;
                    if (NewSubPbActivity.this.gYS.ata()) {
                        NewSubPbActivity.this.gYS.a(NewSubPbActivity.this.hSa);
                    }
                    NewSubPbActivity.this.lB(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.gYK != null) {
                NewSubPbActivity.this.gYK.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.icy.cad();
        }
    };
    private CustomMessageListener hOq = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.icI) {
                NewSubPbActivity.this.icy.aVf();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hNP.i(NewSubPbActivity.this.hNO.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.hNO.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.qG(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bVF();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.hNO.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.hNP.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hOr = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.icI) {
                NewSubPbActivity.this.icy.aVf();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hNP.i(NewSubPbActivity.this.hNO.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.hNO.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.hNP.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hOs = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.icI) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.icy.aVf();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.jwQ;
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
                    NewSubPbActivity.this.icy.a(sparseArray, z);
                }
            }
        }
    };
    boolean hOC = false;
    private final b.a hOE = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.hNS != null && !TextUtils.isEmpty(NewSubPbActivity.this.hNT)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.hNU == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hNT));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.hNT;
                        aVar.pkgId = NewSubPbActivity.this.hNU.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hNU.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.ake();
                    NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.ad(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.fYi == null) {
                            NewSubPbActivity.this.fYi = new au(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.fYi.h(NewSubPbActivity.this.hNT, NewSubPbActivity.this.hNS.nN());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.hNS = null;
                NewSubPbActivity.this.hNT = null;
            }
        }
    };
    private CustomMessageListener gCG = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener fxv = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    l lVar = (l) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.icw.car() != null && NewSubPbActivity.this.icw.car().bUh() != null && NewSubPbActivity.this.icw.car().bUh().aeC() != null && currentAccount.equals(NewSubPbActivity.this.icw.car().bUh().aeC().getUserId()) && NewSubPbActivity.this.icw.car().bUh().aeC().getPendantData() != null) {
                        NewSubPbActivity.this.icw.car().bUh().aeC().getPendantData().mx(lVar.acZ());
                        NewSubPbActivity.this.icw.car().bUh().aeC().getPendantData().bk(lVar.arQ());
                        NewSubPbActivity.this.icy.a(NewSubPbActivity.this.icw.car().bUh(), NewSubPbActivity.this.icw.car().bGN(), NewSubPbActivity.this.icw.car().aaF(), NewSubPbActivity.this.icw.bTK(), NewSubPbActivity.this.icw.caE() != null);
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
        if (this.cts) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.hNO = getPageContext();
        this.icH = true;
        this.gpc = new com.baidu.tieba.write.b();
        this.gpc.CP(R.color.cp_cont_h_alpha85);
        this.gpc.CO(R.color.cp_cont_a);
        bqS();
        bZS();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bZR();
        this.hNP = new com.baidu.tbadk.core.view.e();
        this.hNP.bZH = 1000L;
        registerListener(this.hOs);
        registerListener(this.hOq);
        registerListener(this.hOr);
        this.icI = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.icI;
        userMuteAddAndDelCustomMessage.setTag(this.icI);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.icI;
        userMuteCheckCustomMessage.setTag(this.icI);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.gYK = new aj(getPageContext());
        this.gYK.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.gYS.atf();
                }
            }
        });
        this.hNq = new com.baidu.tieba.pb.pb.report.a(this);
        this.hNq.r(getUniqueId());
        this.hNu = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    private void bZR() {
        if (this.icy != null && this.icw != null && this.icw.bZU()) {
            this.icK = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.icy.aLN());
            this.icK.bqX();
            this.icK.a(new a.InterfaceC0396a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
                private boolean fKY = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0396a
                public void bqT() {
                    NewSubPbActivity.this.icy.kG(false);
                    this.fKY = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0396a
                public void bqU() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0396a
                public boolean bqV() {
                    if (!this.fKY) {
                        return NewSubPbActivity.this.icy.bgK() != null && NewSubPbActivity.this.icy.bgK().getTop() == 0;
                    }
                    this.fKY = false;
                    return false;
                }
            });
            this.icy.e(this.icK);
            this.icy.kG(true);
        }
    }

    public void initUI() {
        this.icy = new b(this, this.mCommonClickListener);
        this.icy.a(this.icw);
        setContentView(this.icy.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.icy.setOnScrollListener(this.icA);
        this.icy.b(this);
        this.icy.setOnLinkImageClickListener(this.icB);
        this.icy.setOnImageClickListener(this.icC);
        this.icy.ok(true);
        this.icy.setOnLongClickListener(this.cnB);
        this.icy.d(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.40
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.icw != null) {
                    NewSubPbActivity.this.icw.auR();
                }
            }
        });
        this.icy.a(this.icF);
        this.icy.b(this.icG);
        if (this.icw != null && this.icw.bZU() && !this.icw.caD()) {
            this.icy.cah().setVisibility(8);
        } else {
            this.icy.cah().setVisibility(0);
        }
        if (this.icw != null && !this.icw.bZU()) {
            this.icy.setIsFromPb(false);
        }
    }

    private boolean ac(Bundle bundle) {
        if (bundle != null) {
            this.cts = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.cts = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.cts;
    }

    public void initData(Bundle bundle) {
        this.icw = new SubPbModel(getPageContext());
        this.icw.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                NewSubPbActivity.this.icy.p(postData);
                NewSubPbActivity.this.icy.b((BdListView.e) null);
            }
        });
        this.icx = new ForumManageModel(getPageContext());
        this.icx.setLoadDataCallBack(this.icE);
        this.fwa = new VoiceManager();
        this.fwa.onCreate(getPageContext());
        this.hNr = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hNr != null) {
            this.hNr.a(this.hOy);
        }
        if (bundle != null) {
            this.icw.initWithBundle(bundle);
        } else {
            this.icw.initWithIntent(getIntent());
        }
        this.icw.a(this.icD);
        if (this.icw.bZU()) {
            this.icw.auR();
        } else {
            this.icw.caw();
        }
    }

    public void bZS() {
        this.icD = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, k kVar) {
                if (NewSubPbActivity.this.icy != null) {
                    NewSubPbActivity.this.icy.cad();
                }
                if (NewSubPbActivity.this.icK != null && NewSubPbActivity.this.icK.bqY()) {
                    NewSubPbActivity.this.icK.sr(R.color.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.aC(i, str);
                    return;
                }
                NewSubPbActivity.this.icy.hideNoDataView();
                if (kVar != null) {
                    if (kVar.bUh() != null || NewSubPbActivity.this.icw != null) {
                        kVar.bUh().a(NewSubPbActivity.this.icw.caC());
                    }
                    if (NewSubPbActivity.this.icy != null) {
                        NewSubPbActivity.this.icy.a(kVar, NewSubPbActivity.this.icw.bTK(), NewSubPbActivity.this.icw.caE() != null);
                        if (NewSubPbActivity.this.icH) {
                            NewSubPbActivity.this.bZT();
                            NewSubPbActivity.this.icH = false;
                        }
                    }
                    if (NewSubPbActivity.this.gYS != null) {
                        NewSubPbActivity.this.gYS.a(kVar.blT());
                    }
                    if (NewSubPbActivity.this.icL == null) {
                        NewSubPbActivity.this.icL = new com.baidu.tieba.pb.e();
                    }
                    NewSubPbActivity.this.icL.setData(kVar);
                    NewSubPbActivity.this.icL.setType(0);
                    NewSubPbActivity.this.gYK.a(NewSubPbActivity.this.icw.caH());
                }
            }
        };
        this.hOy = new a.InterfaceC0247a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0247a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.hNr != null) {
                        NewSubPbActivity.this.hNr.dx(z2);
                    }
                    MarkData aaI = NewSubPbActivity.this.hNr.aaI();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(aaI);
                        if (NewSubPbActivity.this.hNr != null) {
                            if (aaI != null) {
                                NewSubPbActivity.this.icw.pv(true);
                                NewSubPbActivity.this.icw.CR(NewSubPbActivity.this.icw.asI());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.icy != null) {
                                NewSubPbActivity.this.icy.pu(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.icw.pv(false);
                        NewSubPbActivity.this.icw.CR(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.icy != null) {
                            NewSubPbActivity.this.icy.pu(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.icF = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.icw.car() != null && NewSubPbActivity.this.icw.car().acC() != null && NewSubPbActivity.this.icw.car().acC().aeC() != null) {
                    str = String.valueOf(NewSubPbActivity.this.icw.car().acC().aeC().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.icw.car().bUn().getId(), NewSubPbActivity.this.icw.car().bUn().getName(), NewSubPbActivity.this.icw.car().acC().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.icG = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.icx.crl() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int f = com.baidu.adp.lib.g.b.f(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int f2 = com.baidu.adp.lib.g.b.f(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.icw != null && NewSubPbActivity.this.icw.car() != null && NewSubPbActivity.this.icw.car().bUn() != null && NewSubPbActivity.this.icw.car().acC() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.icx.Fq(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.icx.a(NewSubPbActivity.this.icw.car().bUn().getId(), NewSubPbActivity.this.icw.car().bUn().getName(), NewSubPbActivity.this.icw.car().acC().getId(), valueOf, f2, f, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.icE = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.icy.a(NewSubPbActivity.this.icx.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.icx.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.idK != 1002 || bVar.gbx) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.icy.a(1, dVar.FU, dVar.jlh, true);
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

    public void bqS() {
        registerListener(this.fxv);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v63, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.icy != null) {
                    if (view == NewSubPbActivity.this.icy.can()) {
                        NewSubPbActivity.this.icy.bYL();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ba.ajK().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.icy.brj()) {
                        if (view != NewSubPbActivity.this.icy.cag()) {
                            if (view != NewSubPbActivity.this.icy.caf()) {
                                if (view == NewSubPbActivity.this.icy.cab()) {
                                    NewSubPbActivity.this.icy.bYL();
                                    if (NewSubPbActivity.this.icw.auR()) {
                                        NewSubPbActivity.this.icy.bZZ();
                                    }
                                } else if (view == NewSubPbActivity.this.icy.cah() || view == NewSubPbActivity.this.icy.cai() || view == NewSubPbActivity.this.icy.cak()) {
                                    if (NewSubPbActivity.this.icJ) {
                                        NewSubPbActivity.this.icJ = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.icw.bWy(), NewSubPbActivity.this.icw.asI(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.icw.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.icw.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.icy.cal() == null || view != NewSubPbActivity.this.icy.cal().bXp()) {
                                    if (NewSubPbActivity.this.icy.cal() == null || view != NewSubPbActivity.this.icy.cal().bXs()) {
                                        if (NewSubPbActivity.this.icy.cal() == null || view != NewSubPbActivity.this.icy.cal().bXq()) {
                                            if (NewSubPbActivity.this.icy.cal() == null || view != NewSubPbActivity.this.icy.cal().bXr()) {
                                                if (NewSubPbActivity.this.icy.cal() == null || view != NewSubPbActivity.this.icy.cal().bXt()) {
                                                    if (view == NewSubPbActivity.this.icy.cae() || view == NewSubPbActivity.this.icy.cak()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.gYS.ati()) {
                                                                NewSubPbActivity.this.gYS.atj();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.gYS.qH(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof j)) {
                                                        if (NewSubPbActivity.this.icz == null || view != NewSubPbActivity.this.icz.bXr()) {
                                                            if (NewSubPbActivity.this.icz == null || view != NewSubPbActivity.this.icz.bXp()) {
                                                                if (NewSubPbActivity.this.icz == null || view != NewSubPbActivity.this.icz.bXs()) {
                                                                    if (NewSubPbActivity.this.icz == null || view != NewSubPbActivity.this.icz.bXt()) {
                                                                        if (NewSubPbActivity.this.icz == null || view != NewSubPbActivity.this.icz.bXv()) {
                                                                            if (NewSubPbActivity.this.icz == null || view != NewSubPbActivity.this.icz.bXw()) {
                                                                                if (NewSubPbActivity.this.icz != null && view == NewSubPbActivity.this.icz.bXq()) {
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
                                                                                            NewSubPbActivity.this.icy.cE(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.icy.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                            return;
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                int id = view.getId();
                                                                                if (id == R.id.pb_item_tail_content) {
                                                                                    if (bc.cF(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.ahU().getString("tail_link", "");
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
                                                                                        if (postData.getType() != PostData.jiB && !TextUtils.isEmpty(postData.getBimg_url()) && i.ace().aci()) {
                                                                                            NewSubPbActivity.this.CO(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.hNS != null && !TextUtils.isEmpty(NewSubPbActivity.this.hNT)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.ake();
                                                                                NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.ad(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.fYi == null) {
                                                                                        NewSubPbActivity.this.fYi = new au(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.fYi.h(NewSubPbActivity.this.hNT, NewSubPbActivity.this.hNS.nN());
                                                                                    NewSubPbActivity.this.hNS = null;
                                                                                    NewSubPbActivity.this.hNT = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.hNS != null && !TextUtils.isEmpty(NewSubPbActivity.this.hNT)) {
                                                                            if (NewSubPbActivity.this.hNU == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hNT));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.hNT;
                                                                                aVar.pkgId = NewSubPbActivity.this.hNU.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hNU.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.hNS = null;
                                                                            NewSubPbActivity.this.hNT = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.gpL != null) {
                                                                        NewSubPbActivity.this.gpL.en(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.gpL = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.icy.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                NewSubPbActivity.this.Co((String) tag);
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
                                                        NewSubPbActivity.this.icN = (j) view.getTag();
                                                        if (bc.cF(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.icJ) {
                                                                NewSubPbActivity.this.icJ = false;
                                                                return;
                                                            } else if (NewSubPbActivity.this.gYK == null || NewSubPbActivity.this.icw == null || NewSubPbActivity.this.icw.blT() == null || NewSubPbActivity.this.gYK.m19if(NewSubPbActivity.this.icw.blT().replyPrivateFlag)) {
                                                                if (NewSubPbActivity.this.icK != null) {
                                                                    NewSubPbActivity.this.icK.bqW();
                                                                }
                                                                SparseArray sparseArray4 = (SparseArray) view.getTag(R.id.tag_from);
                                                                if (sparseArray4 != null) {
                                                                    if (sparseArray4.get(R.id.tag_clip_board) instanceof PostData) {
                                                                        PostData postData2 = (PostData) sparseArray4.get(R.id.tag_clip_board);
                                                                        if (postData2 != null && postData2.aeC() != null) {
                                                                            MetaData aeC = postData2.aeC();
                                                                            NewSubPbActivity.this.gYS.setReplyId(aeC.getUserId());
                                                                            if (!(sparseArray4.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.tag_is_subpb)).booleanValue() : true)) {
                                                                                NewSubPbActivity.this.gYS.qI("");
                                                                            } else {
                                                                                NewSubPbActivity.this.gYS.qI(aeC.getName_show());
                                                                            }
                                                                        }
                                                                        NewSubPbActivity.this.icy.bZX();
                                                                    }
                                                                    if (NewSubPbActivity.this.icM) {
                                                                        NewSubPbActivity.this.pt(false);
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
                                                        ((PostData) sparseArray5.get(R.id.tag_clip_board)).en(NewSubPbActivity.this.getPageContext().getPageActivity());
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
                                            NewSubPbActivity.this.icy.bYL();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.Co(str4);
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
                                            NewSubPbActivity.this.icy.bYL();
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
                                    NewSubPbActivity.this.icy.bYL();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.icy.a(((Integer) sparseArray7.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray7.get(R.id.tag_del_post_id), ((Integer) sparseArray7.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new an("c11739").P("obj_locate", 2));
                                    NewSubPbActivity.this.icy.bYL();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.icw.car() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.icw.car().bUh());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.icy.bZW();
                                NewSubPbActivity.this.icy.bZX();
                                if (NewSubPbActivity.this.gYS != null) {
                                    NewSubPbActivity.this.gYS.atl();
                                    if (NewSubPbActivity.this.icK != null) {
                                        NewSubPbActivity.this.icK.bqW();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.icy.bZW();
                            NewSubPbActivity.this.icy.bZX();
                            if (NewSubPbActivity.this.gYS != null) {
                                NewSubPbActivity.this.gYS.atk();
                                if (NewSubPbActivity.this.icK != null) {
                                    NewSubPbActivity.this.icK.bqW();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.bVb();
                        if (NewSubPbActivity.this.icw != null && NewSubPbActivity.this.icw.car() != null && NewSubPbActivity.this.icw.car().acC() != null && NewSubPbActivity.this.icw.car().acC().aeC() != null) {
                            TiebaStatic.log(new an("c13402").bT("tid", NewSubPbActivity.this.icw.bWy()).n("fid", NewSubPbActivity.this.icw.car().acC().getFid()).P("obj_locate", 5).bT("uid", NewSubPbActivity.this.icw.car().acC().aeC().getUserId()));
                        }
                    }
                }
            }
        };
        this.icA = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.icy.bYL();
                }
                NewSubPbActivity.this.gYS.atj();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.icy.cam();
            }
        };
        this.hOD = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.icw.car() != null) {
                    postData = NewSubPbActivity.this.icw.car().bUh();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.en(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.f(postData);
                    }
                }
            }
        };
        this.cnB = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                        NewSubPbActivity.this.hNS = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.hNT = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.hNS != null && !TextUtils.isEmpty(NewSubPbActivity.this.hNT)) {
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hNU = null;
                            } else {
                                NewSubPbActivity.this.hNU = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                NewSubPbActivity.this.icy.a(NewSubPbActivity.this.hOE, NewSubPbActivity.this.hNS.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                NewSubPbActivity.this.gpL = (PostData) sparseArray2.get(R.id.tag_clip_board);
                                if (NewSubPbActivity.this.gpL != null && NewSubPbActivity.this.hNr != null) {
                                    if (NewSubPbActivity.this.hNr != null) {
                                        NewSubPbActivity.this.hNr.dx(NewSubPbActivity.this.icw.cax());
                                    }
                                    boolean z = NewSubPbActivity.this.hNr.aaF() && NewSubPbActivity.this.gpL.getId() != null && NewSubPbActivity.this.gpL.getId().equals(NewSubPbActivity.this.icw.caz());
                                    if (NewSubPbActivity.this.icz == null) {
                                        NewSubPbActivity.this.icz = new y(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.mCommonClickListener);
                                        NewSubPbActivity.this.icy.cJ(NewSubPbActivity.this.icz.getView());
                                        NewSubPbActivity.this.icz.oK(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.icz.showDialog();
                                    boolean isLogin = NewSubPbActivity.this.isLogin() & NewSubPbActivity.this.or(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false);
                                    boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                                    if (z) {
                                        NewSubPbActivity.this.icz.bXp().setText(R.string.remove_mark);
                                    } else {
                                        NewSubPbActivity.this.icz.bXp().setText(R.string.mark);
                                    }
                                    if (booleanValue) {
                                        NewSubPbActivity.this.icz.bXp().setVisibility(8);
                                    } else {
                                        NewSubPbActivity.this.icz.bXp().setVisibility(0);
                                    }
                                    if (NewSubPbActivity.this.cy(view)) {
                                        if (NewSubPbActivity.this.hNS != null && !NewSubPbActivity.this.hNS.isGif()) {
                                            sparseArray2.put(R.id.tag_richtext_image, true);
                                        } else {
                                            sparseArray2.put(R.id.tag_richtext_image, false);
                                        }
                                        sparseArray2.put(R.id.tag_richtext_emotion, true);
                                    } else {
                                        sparseArray2.put(R.id.tag_richtext_image, false);
                                        sparseArray2.put(R.id.tag_richtext_emotion, false);
                                    }
                                    NewSubPbActivity.this.icz.a(sparseArray2, NewSubPbActivity.this.bTK(), isLogin);
                                }
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            NewSubPbActivity.this.hNS = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                NewSubPbActivity.this.hNT = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hNU = null;
                            } else {
                                NewSubPbActivity.this.hNU = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.hNS = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.hNT = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.hNU = null;
                        } else {
                            NewSubPbActivity.this.hNU = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
        this.icB = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void f(View view, String str) {
                NewSubPbActivity.this.r(null, str, "LINK_IMAGE");
            }
        };
        this.icC = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                        k car = NewSubPbActivity.this.icw.car();
                        TbRichText bg = NewSubPbActivity.this.bg(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bg != null && bg.ayZ() != null) {
                            tbRichTextData = bg.ayZ().get(NewSubPbActivity.this.hOB);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.azg().azs()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (car == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (car.bUn() != null) {
                                        str4 = car.bUn().getName();
                                        str5 = car.bUn().getId();
                                    }
                                    if (car.acC() != null) {
                                        str6 = car.acC().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.icw.caE() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.icw.caE();
                                    z6 = NewSubPbActivity.this.icw.caG();
                                    arrayList2 = NewSubPbActivity.this.icw.caF();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.c(arrayList2, 0));
                                NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                                return;
                            }
                            NewSubPbActivity.this.hOC = false;
                            String str7 = "";
                            TbRichText cqB = car.bUh().cqB();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(cqB, bg, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (car == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (car.bUn() != null) {
                                    str8 = car.bUn().getName();
                                    str9 = car.bUn().getId();
                                }
                                if (car.acC() != null) {
                                    str10 = car.acC().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.icw.caE() != null) {
                                concurrentHashMap = NewSubPbActivity.this.icw.caE();
                                z4 = NewSubPbActivity.this.icw.caG();
                                arrayList = NewSubPbActivity.this.icw.caF();
                                i2 = a2 + NewSubPbActivity.this.icw.getOffset();
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
        TbRichTextImageInfo azg;
        if (tbRichText == tbRichText2) {
            this.hOC = true;
        }
        if (tbRichText != null && tbRichText.ayZ() != null) {
            int size = tbRichText.ayZ().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.ayZ().get(i6) != null && tbRichText.ayZ().get(i6).getType() == 8) {
                    i5++;
                    int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                    int width = tbRichText.ayZ().get(i6).azg().getWidth() * ai;
                    int height = tbRichText.ayZ().get(i6).azg().getHeight() * ai;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.ayZ().get(i6).azg().azs()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.ayZ().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (azg = tbRichTextData.azg()) != null) {
                            String azu = azg.azu();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = azu;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.hOC) {
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
        if (this.icz != null) {
            this.icz.oK(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo azg = tbRichTextData.azg();
        if (azg != null) {
            if (!StringUtils.isNull(azg.azr())) {
                return azg.azr();
            }
            if (azg.getHeight() * azg.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (azg.getHeight() * azg.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (azg.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * azg.getHeight())));
            } else {
                float width = azg.getWidth() / azg.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.bi(azg.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bg(String str, int i) {
        if (this.icw == null || this.icw.car() == null || str == null || i < 0) {
            return null;
        }
        k car = this.icw.car();
        TbRichText a2 = a(car.bUh(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(car.bUh(), str, i);
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
        TbRichText cqB = postData.cqB();
        if (cqB != null) {
            ArrayList<TbRichTextData> ayZ = cqB.ayZ();
            int size = ayZ.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (ayZ.get(i3) != null && ayZ.get(i3).getType() == 8) {
                    i2++;
                    if (ayZ.get(i3).azg().azu().equals(str)) {
                        int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                        int width = ayZ.get(i3).azg().getWidth() * ai;
                        int height = ayZ.get(i3).azg().getHeight() * ai;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.hOB = i3;
                        return cqB;
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
    public void bVb() {
        if (this.fzF == null) {
            this.fzF = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.fzF.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void ki(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void n(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void kj(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.gYK == null || NewSubPbActivity.this.icw == null || NewSubPbActivity.this.icw.blT() == null || NewSubPbActivity.this.gYK.m19if(NewSubPbActivity.this.icw.blT().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.gYS.ata()) {
                                NewSubPbActivity.this.gYS.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.icy.bZW();
                            NewSubPbActivity.this.icy.bZX();
                            if (NewSubPbActivity.this.gYS != null) {
                                NewSubPbActivity.this.gYS.atm();
                                if (NewSubPbActivity.this.icK != null) {
                                    NewSubPbActivity.this.icK.bqW();
                                }
                            }
                        }
                    }
                }
            });
        }
        if (this.icw != null && this.icw.car() != null && this.icw.car().bUn() != null) {
            this.fzF.v(this.icw.car().bUn().getId(), com.baidu.adp.lib.g.b.e(this.icw.bWy(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean or(boolean z) {
        if (this.icw == null) {
            return false;
        }
        return ((bTK() != 0) || this.icw.car() == null || this.icw.car().acC() == null || this.icw.car().acC().aeC() == null || TextUtils.equals(this.icw.car().acC().aeC().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Context context, String str, String str2) {
        long templateId = this.icw.car().bUh().cqI() != null ? this.icw.car().bUh().cqI().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ba.ajK().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.icw.car().bUn().getId(), this.icw.car().bUn().getName(), this.icw.car().acC().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i, String str) {
        if (this.icw.cas()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.kt()) {
            if (i == 4) {
                this.icy.vP(str + "(4)");
            } else {
                this.icy.pb(R.string.no_data_text);
            }
        } else {
            this.icy.pb(R.string.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.gYS = (g) new h().cK(getActivity());
        if (this.gYS != null) {
            this.gYS.a(getPageContext());
            this.gYS.b(this.icw);
            this.gYS.b(this.gpj);
            this.gYS.a(this.cuO);
            this.gYS.a(this.cuP);
            this.gYS.asm().fk(true);
            this.gYS.e(getPageContext());
        }
        if (this.icy != null) {
            this.icy.g(this.gYS);
        }
        if (this.gYS != null && this.icw != null) {
            this.gYS.a(this.icw.blT());
            this.gYS.atj();
        }
        if (this.gYS != null) {
            this.gYS.atn().setDefaultHint(bYa());
            this.gYS.atn().setHint(bYa());
            this.gpd = this.gYS.atn().getInputView();
            this.gpd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.gpc != null) {
                        if (!NewSubPbActivity.this.gpc.cAq()) {
                            NewSubPbActivity.this.lB(false);
                        }
                        NewSubPbActivity.this.gpc.se(false);
                    }
                }
            });
        }
    }

    public void bZT() {
        if (!TbadkCoreApplication.isLogin()) {
            this.gYS.atj();
        } else if (!StringUtils.isNull(this.icw.caA())) {
            if (this.icy.caa() && com.baidu.adp.lib.util.l.kt()) {
                this.icy.bjk();
            } else {
                this.icy.cad();
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
                    this.icy.cE(view);
                }
            } else if (booleanValue2) {
                this.icy.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.icy.caj(), getPageContext().getPageActivity());
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
            bVar.hz(R.string.operation);
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.icI);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.icI);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).agR();
        }
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.icy.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.e(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.e(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.icI;
        userMuteCheckCustomMessage.setTag(this.icI);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.icy.a(0, bVar.FU, bVar.jlh, z);
            if (bVar.FU) {
                if (bVar.fco == 1) {
                    if (this.icy.getListView() instanceof BdTypeListView) {
                        List<m> data = ((BdTypeListView) this.icy.getListView()).getData();
                        if (!v.aa(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.icy.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.fco == 2) {
                    this.icw.CQ(bVar.mPostId);
                    this.icy.a(this.icw.car(), this.icw.bTK(), this.icw.caE() != null);
                    if (this.icw.caB()) {
                        this.icw.pw(false);
                        this.icy.bZY();
                        this.icw.auR();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
            }
        }
    }

    public void Co(String str) {
        this.hNq.CM(str);
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.icw.cax() && postData.getId() != null && postData.getId().equals(this.icw.caz())) {
                z = true;
            }
            MarkData j = this.icw.j(postData);
            if (j != null) {
                this.icy.bYL();
                if (this.hNr != null) {
                    this.hNr.a(j);
                    if (!z) {
                        this.hNr.aaH();
                    } else {
                        this.hNr.aaG();
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
        if (bundle != null && this.icw != null) {
            this.icw.ab(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.gYS != null) {
            this.gYS.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.gYS.asm().aqI();
        this.gYS.atj();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gYS.b(writeData);
                this.gYS.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k kt = this.gYS.asm().kt(6);
                if (kt != null && kt.csV != null) {
                    kt.csV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gYS.atf();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fwa != null) {
            this.fwa.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.dhv = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.Zk().Zp();
        if (this.fwa != null) {
            this.fwa.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.gCG);
        this.icy.btm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.dhv = false;
        super.onResume();
        bVJ();
        if (this.fwa != null) {
            this.fwa.onResume(getPageContext());
        }
        registerListener(this.gCG);
        this.icy.btn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fwa != null) {
            this.fwa.onStop(getPageContext());
        }
        this.gYS.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.icL));
        this.icw.cancelLoadData();
        this.icw.destory();
        this.icx.cancelLoadData();
        if (this.fwa != null) {
            this.fwa.onDestory(getPageContext());
        }
        this.icy.bYL();
        this.icy.aGu();
        MessageManager.getInstance().unRegisterListener(this.hOq);
        MessageManager.getInstance().unRegisterListener(this.hOr);
        MessageManager.getInstance().unRegisterListener(this.hOs);
        MessageManager.getInstance().unRegisterListener(this.icI);
        this.hNO = null;
        this.hNP = null;
        if (this.gYK != null) {
            this.gYK.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.icy.onChangeSkinType(i);
        if (this.icK != null && this.icK.bqY()) {
            this.icK.sr(R.color.cp_mask_b_alpha66);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.fwa;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View cae = this.icy.cae();
        if (cae == null || (findViewWithTag = cae.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean CF(String str) {
        Map<String, String> oq;
        if (!TextUtils.isEmpty(str) && (oq = ba.oq(ba.or(str))) != null) {
            this.icJ = true;
            String str2 = oq.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return CF(com.baidu.adp.lib.util.k.bj(str2));
            }
            String str3 = oq.get(icv);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void d(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (CF(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                    kVar.mLink = str;
                    kVar.type = 3;
                    kVar.crU = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
                }
            } else {
                ba.ajK().c(getPageContext(), new String[]{str});
            }
            this.icJ = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void al(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.icJ = true;
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
        if (this.icy != null) {
            return this.icy.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int azG() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> azI() {
        if (this.cNK == null) {
            this.cNK = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cNK;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> azJ() {
        if (this.cKW == null) {
            this.cKW = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bVM */
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
        return this.cKW;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> azH() {
        if (this.cKV == null) {
            this.cKV = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.adp.lib.e.c
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean aci = i.ace().aci();
                    foreDrawableImageView.setDefaultBg(am.getDrawable(R.color.common_color_10220));
                    if (aci) {
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
                        if (i.ace().aci()) {
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
        return this.cKV;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> azK() {
        if (this.cNL == null) {
            this.cNL = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bVN */
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
        return this.cNL;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> azL() {
        if (this.cNM == null) {
            this.cNM = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bVP */
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
        return this.cNM;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> azM() {
        this.cNN = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bVO */
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
        return this.cNN;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bUt() {
        return this.hNu;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bUu() {
        return (this.icw == null || this.icw.car() == null || this.icw.car().acC() == null || this.icw.car().acC().afU()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bUv() {
        if (this.icw == null || this.icw.car() == null || this.icw.car().acC() == null) {
            return null;
        }
        return this.icw.car().acC().aeH();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bUw() {
        if (this.icw == null) {
            return 0;
        }
        return this.icw.bTK();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Cl(String str) {
        if (StringUtils.isNull(str) || this.icw == null || this.icw.car() == null || this.icw.car().acC() == null || this.icw.car().acC().aeC() == null) {
            return false;
        }
        return str.equals(this.icw.car().acC().aeC().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.icy.caa() && com.baidu.adp.lib.util.l.kt()) {
            this.icw.auR();
        } else {
            this.icy.cad();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.icI);
        userMuteAddAndDelCustomMessage.setTag(this.icI);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CO(String str) {
        if (!StringUtils.isNull(str) && bc.cF(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("bubble_link", "");
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
            public boolean avh() {
                return false;
            }

            @Override // com.baidu.tbadk.o.b
            public int avi() {
                return com.baidu.tbadk.o.e.avn().avq();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.icw != null) {
            if (this.icw.car() != null && this.icw.car().bUn() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.e(this.icw.car().bUn().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.e(this.icw.bWy(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.dhv;
    }

    public boolean bZU() {
        if (this.icw != null) {
            return this.icw.bZU();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.icy.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hNO.getPageActivity());
        if (aq.isEmpty(str)) {
            aVar.mQ(this.hNO.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.mQ(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.icy.showLoadingDialog();
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
        aVar.b(this.hNO).agO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qG(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hNO.getPageActivity());
        aVar.mQ(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hNO).agO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.mQ(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.hNO).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.hNO.getPageActivity(), 2, true, 4);
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
        aVar.b(this.hNO).agO();
    }

    public SubPbModel bZV() {
        return this.icw;
    }

    public int bTK() {
        if (this.icw != null) {
            return this.icw.bTK();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.cts) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.cts) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void lB(boolean z) {
        if (this.gpd != null && this.gpd.getText() != null) {
            int selectionEnd = this.gpd.getSelectionEnd();
            SpannableStringBuilder b = this.gpc.b(this.gpd.getText());
            if (b != null) {
                this.gpc.se(true);
                this.gpd.setText(b);
                if (z && this.gpc.cAo() >= 0) {
                    this.gpd.requestFocus();
                    this.gpd.setSelection(this.gpc.cAo());
                } else {
                    this.gpd.setSelection(selectionEnd);
                }
                this.gpc.sd(this.gpc.cAo() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gYS != null && this.gYS.asm() != null && this.gYS.asm().asp()) {
            this.gYS.asm().aqI();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.d.a(pVar, getUniqueId(), this);
    }

    public String bYa() {
        if (!aq.isEmpty(this.hYF)) {
            return this.hYF;
        }
        this.hYF = getResources().getString(ap.bXS());
        return this.hYF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.icM = z;
        pt(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pt(boolean z) {
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
        if (this.icy != null && this.icy.getListView() != null && this.icN != null && this.icN.mPosition != -1) {
            final int headerViewsCount = this.icN.mPosition + this.icy.getListView().getHeaderViewsCount();
            if (this.icN.getView() != null) {
                final int height = this.icN.getView().getHeight() - ((rect.height() - this.icy.getNavigationBarHeight()) - this.icy.cao());
                if (height > 0) {
                    this.icy.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.icy != null && NewSubPbActivity.this.icy.getListView() != null) {
                                NewSubPbActivity.this.icy.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.icy.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.icy.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.icy != null && NewSubPbActivity.this.icy.getListView() != null) {
                                NewSubPbActivity.this.icy.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.icy.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }

    private void bVJ() {
        if (this.icw != null && !aq.isEmpty(this.icw.bWy())) {
            com.baidu.tbadk.BdToken.c.Zk().k(com.baidu.tbadk.BdToken.b.byl, com.baidu.adp.lib.g.b.e(this.icw.bWy(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.icw == null || aq.isEmpty(this.icw.bWy())) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.e(this.icw.bWy(), 0L);
    }
}
