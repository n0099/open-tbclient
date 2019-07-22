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
    private static final String hXR = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String hZA = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> cJY;
    private com.baidu.adp.lib.e.b<GifView> cJZ;
    private com.baidu.adp.lib.e.b<TextView> cMN;
    private com.baidu.adp.lib.e.b<View> cMO;
    private com.baidu.adp.lib.e.b<LinearLayout> cMP;
    private com.baidu.adp.lib.e.b<RelativeLayout> cMQ;
    private View.OnLongClickListener cmy;
    private au fVB;
    private VoiceManager ftO;
    private com.baidu.tieba.frs.profession.permission.c fxt;
    public aj gVY;
    private g gWg;
    private com.baidu.tieba.write.b gmt;
    private EditText gmu;
    private com.baidu.tbadk.baseEditMark.a hKA;
    private com.baidu.tieba.pb.pb.main.b.a hKD;
    private com.baidu.adp.base.e hKX;
    private com.baidu.tbadk.core.view.e hKY;
    private com.baidu.tieba.pb.pb.report.a hKz;
    private b.a hLM;
    private com.baidu.adp.widget.ImageView.a hLb;
    private String hLc;
    private TbRichTextMemeInfo hLd;
    private PostWriteCallBackData hPi;
    private String hVM;
    private SubPbModel hZB;
    private ForumManageModel hZC;
    private b hZD;
    private y hZE;
    private AbsListView.OnScrollListener hZF;
    private TbRichTextView.i hZG;
    private TbRichTextView.h hZH;
    private SubPbModel.a hZI;
    private com.baidu.adp.base.d hZJ;
    private BdUniqueId hZN;
    private com.baidu.tieba.pb.pb.sub.a hZP;
    private com.baidu.tieba.pb.e<k> hZQ;
    private boolean hZR;
    private j hZS;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int hLK = 0;
    PostData gnc = null;
    private a.InterfaceC0233a hLH = null;
    private a hZK = null;
    private a hZL = null;
    private boolean dfD = false;
    private boolean hZM = false;
    private boolean hZO = false;
    private boolean csr = false;
    private com.baidu.tbadk.editortools.pb.c ctK = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void asx() {
            NewSubPbActivity.this.hZD.bYX();
        }
    };
    private com.baidu.tbadk.editortools.pb.b ctL = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean asw() {
            if (!NewSubPbActivity.this.gmt.czg()) {
                return (NewSubPbActivity.this.gVY == null || NewSubPbActivity.this.hZB == null || NewSubPbActivity.this.hZB.blb() == null || NewSubPbActivity.this.gVY.U(NewSubPbActivity.this.hZB.blb().replyPrivateFlag, aj.bTi)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.gmt.czi());
            if (NewSubPbActivity.this.gWg.asM()) {
                NewSubPbActivity.this.gWg.a(NewSubPbActivity.this.hPi);
            }
            NewSubPbActivity.this.ly(true);
            return true;
        }
    };
    private NewWriteModel.d gmA = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.gWg != null && NewSubPbActivity.this.gWg.arY() != null) {
                NewSubPbActivity.this.gWg.arY().hide();
                if (NewSubPbActivity.this.hZB.bZt()) {
                    TiebaStatic.log(new an("c10367").bT("post_id", NewSubPbActivity.this.hZB.asu()));
                }
            }
            if (z) {
                NewSubPbActivity.this.gmt.GA(null);
                NewSubPbActivity.this.gmt.aI(null);
                NewSubPbActivity.this.gmt.rZ(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.gmt.aI(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.gmt.GA(postWriteCallBackData.getErrorString());
                if (!v.aa(NewSubPbActivity.this.gmt.cze())) {
                    NewSubPbActivity.this.hPi = postWriteCallBackData;
                    if (NewSubPbActivity.this.gWg.asM()) {
                        NewSubPbActivity.this.gWg.a(NewSubPbActivity.this.hPi);
                    }
                    NewSubPbActivity.this.ly(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.gVY != null) {
                NewSubPbActivity.this.gVY.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.hZD.bYY();
        }
    };
    private CustomMessageListener hLz = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hZN) {
                NewSubPbActivity.this.hZD.aUz();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hKY.i(NewSubPbActivity.this.hKX.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.hKX.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.qv(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bUD();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.hKX.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.hKY.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hLA = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hZN) {
                NewSubPbActivity.this.hZD.aUz();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hKY.i(NewSubPbActivity.this.hKX.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.hKX.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.hKY.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hLB = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hZN) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.hZD.aUz();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.jtn;
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
                    NewSubPbActivity.this.hZD.a(sparseArray, z);
                }
            }
        }
    };
    boolean hLL = false;
    private final b.a hLN = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.hLb != null && !TextUtils.isEmpty(NewSubPbActivity.this.hLc)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.hLd == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hLc));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.hLc;
                        aVar.pkgId = NewSubPbActivity.this.hLd.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hLd.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.ajQ();
                    NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.ad(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.fVB == null) {
                            NewSubPbActivity.this.fVB = new au(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.fVB.h(NewSubPbActivity.this.hLc, NewSubPbActivity.this.hLb.nN());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.hLb = null;
                NewSubPbActivity.this.hLc = null;
            }
        }
    };
    private CustomMessageListener gzX = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener fvj = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    l lVar = (l) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.hZB.bZm() != null && NewSubPbActivity.this.hZB.bZm().bTg() != null && NewSubPbActivity.this.hZB.bZm().bTg().aex() != null && currentAccount.equals(NewSubPbActivity.this.hZB.bZm().bTg().aex().getUserId()) && NewSubPbActivity.this.hZB.bZm().bTg().aex().getPendantData() != null) {
                        NewSubPbActivity.this.hZB.bZm().bTg().aex().getPendantData().mv(lVar.acU());
                        NewSubPbActivity.this.hZB.bZm().bTg().aex().getPendantData().bh(lVar.arC());
                        NewSubPbActivity.this.hZD.a(NewSubPbActivity.this.hZB.bZm().bTg(), NewSubPbActivity.this.hZB.bZm().bFL(), NewSubPbActivity.this.hZB.bZm().aaB(), NewSubPbActivity.this.hZB.bSJ(), NewSubPbActivity.this.hZB.bZz() != null);
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
        if (this.csr) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.hKX = getPageContext();
        this.hZM = true;
        this.gmt = new com.baidu.tieba.write.b();
        this.gmt.CJ(R.color.cp_cont_h_alpha85);
        this.gmt.CI(R.color.cp_btn_a);
        bpT();
        bYN();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bYM();
        this.hKY = new com.baidu.tbadk.core.view.e();
        this.hKY.bYI = 1000L;
        registerListener(this.hLB);
        registerListener(this.hLz);
        registerListener(this.hLA);
        this.hZN = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hZN;
        userMuteAddAndDelCustomMessage.setTag(this.hZN);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hZN;
        userMuteCheckCustomMessage.setTag(this.hZN);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.gVY = new aj(getPageContext());
        this.gVY.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.gWg.asR();
                }
            }
        });
        this.hKz = new com.baidu.tieba.pb.pb.report.a(this);
        this.hKz.r(getUniqueId());
        this.hKD = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    private void bYM() {
        if (this.hZD != null && this.hZB != null && this.hZB.bYP()) {
            this.hZP = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.hZD.aLh());
            this.hZP.bpY();
            this.hZP.a(new a.InterfaceC0379a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
                private boolean fIv = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0379a
                public void bpU() {
                    NewSubPbActivity.this.hZD.kD(false);
                    this.fIv = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0379a
                public void bpV() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0379a
                public boolean bpW() {
                    if (!this.fIv) {
                        return NewSubPbActivity.this.hZD.bqk() != null && NewSubPbActivity.this.hZD.bqk().getTop() == 0;
                    }
                    this.fIv = false;
                    return false;
                }
            });
            this.hZD.e(this.hZP);
            this.hZD.kD(true);
        }
    }

    public void initUI() {
        this.hZD = new b(this, this.mCommonClickListener);
        this.hZD.a(this.hZB);
        setContentView(this.hZD.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.hZD.setOnScrollListener(this.hZF);
        this.hZD.b(this);
        this.hZD.setOnLinkImageClickListener(this.hZG);
        this.hZD.setOnImageClickListener(this.hZH);
        this.hZD.og(true);
        this.hZD.setOnLongClickListener(this.cmy);
        this.hZD.d(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.40
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.hZB != null) {
                    NewSubPbActivity.this.hZB.auD();
                }
            }
        });
        this.hZD.a(this.hZK);
        this.hZD.b(this.hZL);
        if (this.hZB != null && this.hZB.bYP() && !this.hZB.bZy()) {
            this.hZD.bZc().setVisibility(8);
        } else {
            this.hZD.bZc().setVisibility(0);
        }
        if (this.hZB != null && !this.hZB.bYP()) {
            this.hZD.setIsFromPb(false);
        }
    }

    private boolean ac(Bundle bundle) {
        if (bundle != null) {
            this.csr = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.csr = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.csr;
    }

    public void initData(Bundle bundle) {
        this.hZB = new SubPbModel(getPageContext());
        this.hZB.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                NewSubPbActivity.this.hZD.p(postData);
                NewSubPbActivity.this.hZD.b((BdListView.e) null);
            }
        });
        this.hZC = new ForumManageModel(getPageContext());
        this.hZC.setLoadDataCallBack(this.hZJ);
        this.ftO = new VoiceManager();
        this.ftO.onCreate(getPageContext());
        this.hKA = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hKA != null) {
            this.hKA.a(this.hLH);
        }
        if (bundle != null) {
            this.hZB.initWithBundle(bundle);
        } else {
            this.hZB.initWithIntent(getIntent());
        }
        this.hZB.a(this.hZI);
        if (this.hZB.bYP()) {
            this.hZB.auD();
        } else {
            this.hZB.bZr();
        }
    }

    public void bYN() {
        this.hZI = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, k kVar) {
                if (NewSubPbActivity.this.hZD != null) {
                    NewSubPbActivity.this.hZD.bYY();
                }
                if (NewSubPbActivity.this.hZP != null && NewSubPbActivity.this.hZP.bpZ()) {
                    NewSubPbActivity.this.hZP.sl(R.color.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.aC(i, str);
                    return;
                }
                NewSubPbActivity.this.hZD.hideNoDataView();
                if (kVar != null) {
                    if (kVar.bTg() != null || NewSubPbActivity.this.hZB != null) {
                        kVar.bTg().a(NewSubPbActivity.this.hZB.bZx());
                    }
                    if (NewSubPbActivity.this.hZD != null) {
                        NewSubPbActivity.this.hZD.a(kVar, NewSubPbActivity.this.hZB.bSJ(), NewSubPbActivity.this.hZB.bZz() != null);
                        if (NewSubPbActivity.this.hZM) {
                            NewSubPbActivity.this.bYO();
                            NewSubPbActivity.this.hZM = false;
                        }
                    }
                    if (NewSubPbActivity.this.gWg != null) {
                        NewSubPbActivity.this.gWg.a(kVar.blb());
                    }
                    if (NewSubPbActivity.this.hZQ == null) {
                        NewSubPbActivity.this.hZQ = new com.baidu.tieba.pb.e();
                    }
                    NewSubPbActivity.this.hZQ.setData(kVar);
                    NewSubPbActivity.this.hZQ.setType(0);
                    NewSubPbActivity.this.gVY.a(NewSubPbActivity.this.hZB.bZC());
                }
            }
        };
        this.hLH = new a.InterfaceC0233a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0233a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.hKA != null) {
                        NewSubPbActivity.this.hKA.dx(z2);
                    }
                    MarkData aaE = NewSubPbActivity.this.hKA.aaE();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(aaE);
                        if (NewSubPbActivity.this.hKA != null) {
                            if (aaE != null) {
                                NewSubPbActivity.this.hZB.pr(true);
                                NewSubPbActivity.this.hZB.Cr(NewSubPbActivity.this.hZB.asu());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.hZD != null) {
                                NewSubPbActivity.this.hZD.pq(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.hZB.pr(false);
                        NewSubPbActivity.this.hZB.Cr(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.hZD != null) {
                            NewSubPbActivity.this.hZD.pq(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.hZK = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.hZB.bZm() != null && NewSubPbActivity.this.hZB.bZm().acx() != null && NewSubPbActivity.this.hZB.bZm().acx().aex() != null) {
                    str = String.valueOf(NewSubPbActivity.this.hZB.bZm().acx().aex().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.hZB.bZm().bTm().getId(), NewSubPbActivity.this.hZB.bZm().bTm().getName(), NewSubPbActivity.this.hZB.bZm().acx().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.hZL = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.hZC.cqb() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int f = com.baidu.adp.lib.g.b.f(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int f2 = com.baidu.adp.lib.g.b.f(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.hZB != null && NewSubPbActivity.this.hZB.bZm() != null && NewSubPbActivity.this.hZB.bZm().bTm() != null && NewSubPbActivity.this.hZB.bZm().acx() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.hZC.EP(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.hZC.a(NewSubPbActivity.this.hZB.bZm().bTm().getId(), NewSubPbActivity.this.hZB.bZm().bTm().getName(), NewSubPbActivity.this.hZB.bZm().acx().getId(), valueOf, f2, f, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.hZJ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.hZD.a(NewSubPbActivity.this.hZC.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.hZC.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.iaL != 1002 || bVar.fYQ) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.hZD.a(1, dVar.FU, dVar.jhE, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean cx(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void bpT() {
        registerListener(this.fvj);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v63, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.hZD != null) {
                    if (view == NewSubPbActivity.this.hZD.bZi()) {
                        NewSubPbActivity.this.hZD.bXH();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                bb.ajC().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.hZD.bql()) {
                        if (view != NewSubPbActivity.this.hZD.bZb()) {
                            if (view != NewSubPbActivity.this.hZD.bZa()) {
                                if (view == NewSubPbActivity.this.hZD.bYW()) {
                                    NewSubPbActivity.this.hZD.bXH();
                                    if (NewSubPbActivity.this.hZB.auD()) {
                                        NewSubPbActivity.this.hZD.bYU();
                                    }
                                } else if (view == NewSubPbActivity.this.hZD.bZc() || view == NewSubPbActivity.this.hZD.bZd() || view == NewSubPbActivity.this.hZD.bZf()) {
                                    if (NewSubPbActivity.this.hZO) {
                                        NewSubPbActivity.this.hZO = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.hZB.bVv(), NewSubPbActivity.this.hZB.asu(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.hZB.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.hZB.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.hZD.bZg() == null || view != NewSubPbActivity.this.hZD.bZg().bWm()) {
                                    if (NewSubPbActivity.this.hZD.bZg() == null || view != NewSubPbActivity.this.hZD.bZg().bWp()) {
                                        if (NewSubPbActivity.this.hZD.bZg() == null || view != NewSubPbActivity.this.hZD.bZg().bWn()) {
                                            if (NewSubPbActivity.this.hZD.bZg() == null || view != NewSubPbActivity.this.hZD.bZg().bWo()) {
                                                if (NewSubPbActivity.this.hZD.bZg() == null || view != NewSubPbActivity.this.hZD.bZg().bWq()) {
                                                    if (view == NewSubPbActivity.this.hZD.bYZ() || view == NewSubPbActivity.this.hZD.bZf()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.gWg.asU()) {
                                                                NewSubPbActivity.this.gWg.asV();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.gWg.qw(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof j)) {
                                                        if (NewSubPbActivity.this.hZE == null || view != NewSubPbActivity.this.hZE.bWo()) {
                                                            if (NewSubPbActivity.this.hZE == null || view != NewSubPbActivity.this.hZE.bWm()) {
                                                                if (NewSubPbActivity.this.hZE == null || view != NewSubPbActivity.this.hZE.bWp()) {
                                                                    if (NewSubPbActivity.this.hZE == null || view != NewSubPbActivity.this.hZE.bWq()) {
                                                                        if (NewSubPbActivity.this.hZE == null || view != NewSubPbActivity.this.hZE.bWs()) {
                                                                            if (NewSubPbActivity.this.hZE == null || view != NewSubPbActivity.this.hZE.bWt()) {
                                                                                if (NewSubPbActivity.this.hZE != null && view == NewSubPbActivity.this.hZE.bWn()) {
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
                                                                                            NewSubPbActivity.this.hZD.cD(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.hZD.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.ahO().getString("tail_link", "");
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
                                                                                        if (postData.getType() != PostData.jeY && !TextUtils.isEmpty(postData.getBimg_url()) && i.aca().ace()) {
                                                                                            NewSubPbActivity.this.Co(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.hLb != null && !TextUtils.isEmpty(NewSubPbActivity.this.hLc)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.ajQ();
                                                                                NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.ad(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.fVB == null) {
                                                                                        NewSubPbActivity.this.fVB = new au(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.fVB.h(NewSubPbActivity.this.hLc, NewSubPbActivity.this.hLb.nN());
                                                                                    NewSubPbActivity.this.hLb = null;
                                                                                    NewSubPbActivity.this.hLc = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.hLb != null && !TextUtils.isEmpty(NewSubPbActivity.this.hLc)) {
                                                                            if (NewSubPbActivity.this.hLd == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hLc));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.hLc;
                                                                                aVar.pkgId = NewSubPbActivity.this.hLd.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hLd.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.hLb = null;
                                                                            NewSubPbActivity.this.hLc = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.gnc != null) {
                                                                        NewSubPbActivity.this.gnc.el(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.gnc = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.hZD.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.cw(view);
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
                                                                NewSubPbActivity.this.BO((String) tag);
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
                                                        NewSubPbActivity.this.hZS = (j) view.getTag();
                                                        if (bd.cF(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.hZO) {
                                                                NewSubPbActivity.this.hZO = false;
                                                                return;
                                                            } else if (NewSubPbActivity.this.gVY == null || NewSubPbActivity.this.hZB == null || NewSubPbActivity.this.hZB.blb() == null || NewSubPbActivity.this.gVY.m19if(NewSubPbActivity.this.hZB.blb().replyPrivateFlag)) {
                                                                if (NewSubPbActivity.this.hZP != null) {
                                                                    NewSubPbActivity.this.hZP.bpX();
                                                                }
                                                                SparseArray sparseArray4 = (SparseArray) view.getTag(R.id.tag_from);
                                                                if (sparseArray4 != null) {
                                                                    if (sparseArray4.get(R.id.tag_clip_board) instanceof PostData) {
                                                                        PostData postData2 = (PostData) sparseArray4.get(R.id.tag_clip_board);
                                                                        if (postData2 != null && postData2.aex() != null) {
                                                                            MetaData aex = postData2.aex();
                                                                            NewSubPbActivity.this.gWg.setReplyId(aex.getUserId());
                                                                            if (!(sparseArray4.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.tag_is_subpb)).booleanValue() : true)) {
                                                                                NewSubPbActivity.this.gWg.qx("");
                                                                            } else {
                                                                                NewSubPbActivity.this.gWg.qx(aex.getName_show());
                                                                            }
                                                                        }
                                                                        NewSubPbActivity.this.hZD.bYS();
                                                                    }
                                                                    if (NewSubPbActivity.this.hZR) {
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
                                                        ((PostData) sparseArray5.get(R.id.tag_clip_board)).el(NewSubPbActivity.this.getPageContext().getPageActivity());
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
                                            NewSubPbActivity.this.hZD.bXH();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.BO(str4);
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
                                            NewSubPbActivity.this.hZD.bXH();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.cG(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.hZD.bXH();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.hZD.a(((Integer) sparseArray7.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray7.get(R.id.tag_del_post_id), ((Integer) sparseArray7.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new an("c11739").P("obj_locate", 2));
                                    NewSubPbActivity.this.hZD.bXH();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.hZB.bZm() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.hZB.bZm().bTg());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.hZD.bYR();
                                NewSubPbActivity.this.hZD.bYS();
                                if (NewSubPbActivity.this.gWg != null) {
                                    NewSubPbActivity.this.gWg.asX();
                                    if (NewSubPbActivity.this.hZP != null) {
                                        NewSubPbActivity.this.hZP.bpX();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.hZD.bYR();
                            NewSubPbActivity.this.hZD.bYS();
                            if (NewSubPbActivity.this.gWg != null) {
                                NewSubPbActivity.this.gWg.asW();
                                if (NewSubPbActivity.this.hZP != null) {
                                    NewSubPbActivity.this.hZP.bpX();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.bTZ();
                        if (NewSubPbActivity.this.hZB != null && NewSubPbActivity.this.hZB.bZm() != null && NewSubPbActivity.this.hZB.bZm().acx() != null && NewSubPbActivity.this.hZB.bZm().acx().aex() != null) {
                            TiebaStatic.log(new an("c13402").bT("tid", NewSubPbActivity.this.hZB.bVv()).l("fid", NewSubPbActivity.this.hZB.bZm().acx().getFid()).P("obj_locate", 5).bT("uid", NewSubPbActivity.this.hZB.bZm().acx().aex().getUserId()));
                        }
                    }
                }
            }
        };
        this.hZF = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.hZD.bXH();
                }
                NewSubPbActivity.this.gWg.asV();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.hZD.bZh();
            }
        };
        this.hLM = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.hZB.bZm() != null) {
                    postData = NewSubPbActivity.this.hZB.bZm().bTg();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.el(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.f(postData);
                    }
                }
            }
        };
        this.cmy = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                if (sparseArray == null && NewSubPbActivity.this.cx(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.hLb = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.hLc = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.hLb != null && !TextUtils.isEmpty(NewSubPbActivity.this.hLc)) {
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hLd = null;
                            } else {
                                NewSubPbActivity.this.hLd = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                NewSubPbActivity.this.hZD.a(NewSubPbActivity.this.hLN, NewSubPbActivity.this.hLb.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                NewSubPbActivity.this.gnc = (PostData) sparseArray2.get(R.id.tag_clip_board);
                                if (NewSubPbActivity.this.gnc != null && NewSubPbActivity.this.hKA != null) {
                                    if (NewSubPbActivity.this.hKA != null) {
                                        NewSubPbActivity.this.hKA.dx(NewSubPbActivity.this.hZB.bZs());
                                    }
                                    boolean z = NewSubPbActivity.this.hKA.aaB() && NewSubPbActivity.this.gnc.getId() != null && NewSubPbActivity.this.gnc.getId().equals(NewSubPbActivity.this.hZB.bZu());
                                    if (NewSubPbActivity.this.hZE == null) {
                                        NewSubPbActivity.this.hZE = new y(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.mCommonClickListener);
                                        NewSubPbActivity.this.hZD.cH(NewSubPbActivity.this.hZE.getView());
                                        NewSubPbActivity.this.hZE.oG(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.hZE.showDialog();
                                    boolean isLogin = NewSubPbActivity.this.isLogin() & NewSubPbActivity.this.on(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false);
                                    boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                                    if (z) {
                                        NewSubPbActivity.this.hZE.bWm().setText(R.string.remove_mark);
                                    } else {
                                        NewSubPbActivity.this.hZE.bWm().setText(R.string.mark);
                                    }
                                    if (booleanValue) {
                                        NewSubPbActivity.this.hZE.bWm().setVisibility(8);
                                    } else {
                                        NewSubPbActivity.this.hZE.bWm().setVisibility(0);
                                    }
                                    if (NewSubPbActivity.this.cx(view)) {
                                        if (NewSubPbActivity.this.hLb != null && !NewSubPbActivity.this.hLb.isGif()) {
                                            sparseArray2.put(R.id.tag_richtext_image, true);
                                        } else {
                                            sparseArray2.put(R.id.tag_richtext_image, false);
                                        }
                                        sparseArray2.put(R.id.tag_richtext_emotion, true);
                                    } else {
                                        sparseArray2.put(R.id.tag_richtext_image, false);
                                        sparseArray2.put(R.id.tag_richtext_emotion, false);
                                    }
                                    NewSubPbActivity.this.hZE.a(sparseArray2, NewSubPbActivity.this.bSJ(), isLogin);
                                }
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            NewSubPbActivity.this.hLb = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                NewSubPbActivity.this.hLc = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hLd = null;
                            } else {
                                NewSubPbActivity.this.hLd = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.hLb = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.hLc = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.hLd = null;
                        } else {
                            NewSubPbActivity.this.hLd = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
        this.hZG = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void f(View view, String str) {
                NewSubPbActivity.this.r(null, str, "LINK_IMAGE");
            }
        };
        this.hZH = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                        k bZm = NewSubPbActivity.this.hZB.bZm();
                        TbRichText be = NewSubPbActivity.this.be(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (be != null && be.ayL() != null) {
                            tbRichTextData = be.ayL().get(NewSubPbActivity.this.hLK);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.ayS().aze()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (bZm == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (bZm.bTm() != null) {
                                        str4 = bZm.bTm().getName();
                                        str5 = bZm.bTm().getId();
                                    }
                                    if (bZm.acx() != null) {
                                        str6 = bZm.acx().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.hZB.bZz() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.hZB.bZz();
                                    z6 = NewSubPbActivity.this.hZB.bZB();
                                    arrayList2 = NewSubPbActivity.this.hZB.bZA();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.c(arrayList2, 0));
                                NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                                return;
                            }
                            NewSubPbActivity.this.hLL = false;
                            String str7 = "";
                            TbRichText cpr = bZm.bTg().cpr();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(cpr, be, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (bZm == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (bZm.bTm() != null) {
                                    str8 = bZm.bTm().getName();
                                    str9 = bZm.bTm().getId();
                                }
                                if (bZm.acx() != null) {
                                    str10 = bZm.acx().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.hZB.bZz() != null) {
                                concurrentHashMap = NewSubPbActivity.this.hZB.bZz();
                                z4 = NewSubPbActivity.this.hZB.bZB();
                                arrayList = NewSubPbActivity.this.hZB.bZA();
                                i2 = a2 + NewSubPbActivity.this.hZB.getOffset();
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
    public void cw(View view) {
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
        TbRichTextImageInfo ayS;
        if (tbRichText == tbRichText2) {
            this.hLL = true;
        }
        if (tbRichText != null && tbRichText.ayL() != null) {
            int size = tbRichText.ayL().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.ayL().get(i6) != null && tbRichText.ayL().get(i6).getType() == 8) {
                    i5++;
                    int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                    int width = tbRichText.ayL().get(i6).ayS().getWidth() * ai;
                    int height = tbRichText.ayL().get(i6).ayS().getHeight() * ai;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.ayL().get(i6).ayS().aze()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.ayL().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (ayS = tbRichTextData.ayS()) != null) {
                            String azg = ayS.azg();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = azg;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.hLL) {
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
        if (this.hZE != null) {
            this.hZE.oG(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo ayS = tbRichTextData.ayS();
        if (ayS != null) {
            if (!StringUtils.isNull(ayS.azd())) {
                return ayS.azd();
            }
            if (ayS.getHeight() * ayS.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (ayS.getHeight() * ayS.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (ayS.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * ayS.getHeight())));
            } else {
                float width = ayS.getWidth() / ayS.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.bi(ayS.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText be(String str, int i) {
        if (this.hZB == null || this.hZB.bZm() == null || str == null || i < 0) {
            return null;
        }
        k bZm = this.hZB.bZm();
        TbRichText a2 = a(bZm.bTg(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bZm.bTg(), str, i);
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
        TbRichText cpr = postData.cpr();
        if (cpr != null) {
            ArrayList<TbRichTextData> ayL = cpr.ayL();
            int size = ayL.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (ayL.get(i3) != null && ayL.get(i3).getType() == 8) {
                    i2++;
                    if (ayL.get(i3).ayS().azg().equals(str)) {
                        int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                        int width = ayL.get(i3).ayS().getWidth() * ai;
                        int height = ayL.get(i3).ayS().getHeight() * ai;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.hLK = i3;
                        return cpr;
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
    public void bTZ() {
        if (this.fxt == null) {
            this.fxt = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.fxt.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void kf(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void n(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void kg(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.gVY == null || NewSubPbActivity.this.hZB == null || NewSubPbActivity.this.hZB.blb() == null || NewSubPbActivity.this.gVY.m19if(NewSubPbActivity.this.hZB.blb().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.gWg.asM()) {
                                NewSubPbActivity.this.gWg.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.hZD.bYR();
                            NewSubPbActivity.this.hZD.bYS();
                            if (NewSubPbActivity.this.gWg != null) {
                                NewSubPbActivity.this.gWg.asY();
                                if (NewSubPbActivity.this.hZP != null) {
                                    NewSubPbActivity.this.hZP.bpX();
                                }
                            }
                        }
                    }
                }
            });
        }
        if (this.hZB != null && this.hZB.bZm() != null && this.hZB.bZm().bTm() != null) {
            this.fxt.t(this.hZB.bZm().bTm().getId(), com.baidu.adp.lib.g.b.c(this.hZB.bVv(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean on(boolean z) {
        if (this.hZB == null) {
            return false;
        }
        return ((bSJ() != 0) || this.hZB.bZm() == null || this.hZB.bZm().acx() == null || this.hZB.bZm().acx().aex() == null || TextUtils.equals(this.hZB.bZm().acx().aex().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Context context, String str, String str2) {
        long templateId = this.hZB.bZm().bTg().cpy() != null ? this.hZB.bZm().bTg().cpy().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && bb.ajC().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.hZB.bZm().bTm().getId(), this.hZB.bZm().bTm().getName(), this.hZB.bZm().acx().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i, String str) {
        if (this.hZB.bZn()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.kt()) {
            if (i == 4) {
                this.hZD.vp(str + "(4)");
            } else {
                this.hZD.oW(R.string.no_data_text);
            }
        } else {
            this.hZD.oW(R.string.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.gWg = (g) new h().cK(getActivity());
        if (this.gWg != null) {
            this.gWg.a(getPageContext());
            this.gWg.b(this.hZB);
            this.gWg.b(this.gmA);
            this.gWg.a(this.ctK);
            this.gWg.a(this.ctL);
            this.gWg.arY().fh(true);
            this.gWg.e(getPageContext());
        }
        if (this.hZD != null) {
            this.hZD.g(this.gWg);
        }
        if (this.gWg != null && this.hZB != null) {
            this.gWg.a(this.hZB.blb());
            this.gWg.asV();
        }
        if (this.gWg != null) {
            this.gWg.asZ().setDefaultHint(bWW());
            this.gWg.asZ().setHint(bWW());
            this.gmu = this.gWg.asZ().getInputView();
            this.gmu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.gmt != null) {
                        if (!NewSubPbActivity.this.gmt.czh()) {
                            NewSubPbActivity.this.ly(false);
                        }
                        NewSubPbActivity.this.gmt.sa(false);
                    }
                }
            });
        }
    }

    public void bYO() {
        if (!TbadkCoreApplication.isLogin()) {
            this.gWg.asV();
        } else if (!StringUtils.isNull(this.hZB.bZv())) {
            if (this.hZD.bYV() && com.baidu.adp.lib.util.l.kt()) {
                this.hZD.bis();
            } else {
                this.hZD.bYY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cG(View view) {
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
                    this.hZD.cD(view);
                }
            } else if (booleanValue2) {
                this.hZD.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.hZD.bZe(), getPageContext().getPageActivity());
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.hZN);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.hZN);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).agL();
        }
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.hZD.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.hZN;
        userMuteCheckCustomMessage.setTag(this.hZN);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.hZD.a(0, bVar.FU, bVar.jhE, z);
            if (bVar.FU) {
                if (bVar.fau == 1) {
                    if (this.hZD.getListView() instanceof BdTypeListView) {
                        List<m> data = ((BdTypeListView) this.hZD.getListView()).getData();
                        if (!v.aa(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.hZD.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.fau == 2) {
                    this.hZB.Cq(bVar.mPostId);
                    this.hZD.a(this.hZB.bZm(), this.hZB.bSJ(), this.hZB.bZz() != null);
                    if (this.hZB.bZw()) {
                        this.hZB.ps(false);
                        this.hZD.bYT();
                        this.hZB.auD();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, eVar));
            }
        }
    }

    public void BO(String str) {
        this.hKz.Cm(str);
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.hZB.bZs() && postData.getId() != null && postData.getId().equals(this.hZB.bZu())) {
                z = true;
            }
            MarkData j = this.hZB.j(postData);
            if (j != null) {
                this.hZD.bXH();
                if (this.hKA != null) {
                    this.hKA.a(j);
                    if (!z) {
                        this.hKA.aaD();
                    } else {
                        this.hKA.aaC();
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
        if (bundle != null && this.hZB != null) {
            this.hZB.ab(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.gWg != null) {
            this.gWg.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.gWg.arY().aqu();
        this.gWg.asV();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gWg.b(writeData);
                this.gWg.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k kp = this.gWg.arY().kp(6);
                if (kp != null && kp.crT != null) {
                    kp.crT.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gWg.asR();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.ftO != null) {
            this.ftO.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.dfD = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.Zg().Zl();
        if (this.ftO != null) {
            this.ftO.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.gzX);
        this.hZD.bsm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.dfD = false;
        super.onResume();
        bUH();
        if (this.ftO != null) {
            this.ftO.onResume(getPageContext());
        }
        registerListener(this.gzX);
        this.hZD.bsn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ftO != null) {
            this.ftO.onStop(getPageContext());
        }
        this.gWg.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.hZQ));
        this.hZB.cancelLoadData();
        this.hZB.destory();
        this.hZC.cancelLoadData();
        if (this.ftO != null) {
            this.ftO.onDestory(getPageContext());
        }
        this.hZD.bXH();
        this.hZD.aFO();
        MessageManager.getInstance().unRegisterListener(this.hLz);
        MessageManager.getInstance().unRegisterListener(this.hLA);
        MessageManager.getInstance().unRegisterListener(this.hLB);
        MessageManager.getInstance().unRegisterListener(this.hZN);
        this.hKX = null;
        this.hKY = null;
        if (this.gVY != null) {
            this.gVY.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hZD.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.ftO;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bYZ = this.hZD.bYZ();
        if (bYZ == null || (findViewWithTag = bYZ.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Cf(String str) {
        Map<String, String> oo;
        if (!TextUtils.isEmpty(str) && (oo = bb.oo(bb.op(str))) != null) {
            this.hZO = true;
            String str2 = oo.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Cf(com.baidu.adp.lib.util.k.bj(str2));
            }
            String str3 = oo.get(hZA);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void d(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (Cf(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                    kVar.mLink = str;
                    kVar.type = 3;
                    kVar.cqS = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
                }
            } else {
                bb.ajC().c(getPageContext(), new String[]{str});
            }
            this.hZO = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void al(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hZO = true;
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
        if (this.hZD != null) {
            return this.hZD.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int azs() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> azu() {
        if (this.cMN == null) {
            this.cMN = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cMN;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> azv() {
        if (this.cJZ == null) {
            this.cJZ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bUJ */
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
        return this.cJZ;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> azt() {
        if (this.cJY == null) {
            this.cJY = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
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
        return this.cJY;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> azw() {
        if (this.cMO == null) {
            this.cMO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bUK */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cy */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cz */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cA */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.cMO;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> azx() {
        if (this.cMP == null) {
            this.cMP = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bUM */
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
        return this.cMP;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> azy() {
        this.cMQ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bUL */
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
        return this.cMQ;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bTs() {
        return this.hKD;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bTt() {
        return (this.hZB == null || this.hZB.bZm() == null || this.hZB.bZm().acx() == null || this.hZB.bZm().acx().afP()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bTu() {
        if (this.hZB == null || this.hZB.bZm() == null || this.hZB.bZm().acx() == null) {
            return null;
        }
        return this.hZB.bZm().acx().aeC();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bTv() {
        if (this.hZB == null) {
            return 0;
        }
        return this.hZB.bSJ();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean BL(String str) {
        if (StringUtils.isNull(str) || this.hZB == null || this.hZB.bZm() == null || this.hZB.bZm().acx() == null || this.hZB.bZm().acx().aex() == null) {
            return false;
        }
        return str.equals(this.hZB.bZm().acx().aex().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hZD.bYV() && com.baidu.adp.lib.util.l.kt()) {
            this.hZB.auD();
        } else {
            this.hZD.bYY();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.hZN);
        userMuteAddAndDelCustomMessage.setTag(this.hZN);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Co(String str) {
        if (!StringUtils.isNull(str) && bd.cF(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.ahO().getString("bubble_link", "");
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
            public boolean auT() {
                return false;
            }

            @Override // com.baidu.tbadk.o.b
            public int auU() {
                return com.baidu.tbadk.o.e.auZ().avc();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.hZB != null) {
            if (this.hZB.bZm() != null && this.hZB.bZm().bTm() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.hZB.bZm().bTm().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.hZB.bVv(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.dfD;
    }

    public boolean bYP() {
        if (this.hZB != null) {
            return this.hZB.bYP();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hZD.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hKX.getPageActivity());
        if (aq.isEmpty(str)) {
            aVar.mO(this.hKX.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.mO(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.hZD.showLoadingDialog();
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
        aVar.b(this.hKX).agI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qv(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hKX.getPageActivity());
        aVar.mO(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hKX).agI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.mO(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.hKX).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.hKX.getPageActivity(), 2, true, 4);
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
        aVar.b(this.hKX).agI();
    }

    public SubPbModel bYQ() {
        return this.hZB;
    }

    public int bSJ() {
        if (this.hZB != null) {
            return this.hZB.bSJ();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.csr) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.csr) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void ly(boolean z) {
        if (this.gmu != null && this.gmu.getText() != null) {
            int selectionEnd = this.gmu.getSelectionEnd();
            SpannableStringBuilder b = this.gmt.b(this.gmu.getText());
            if (b != null) {
                this.gmt.sa(true);
                this.gmu.setText(b);
                if (z && this.gmt.czf() >= 0) {
                    this.gmu.requestFocus();
                    this.gmu.setSelection(this.gmt.czf());
                } else {
                    this.gmu.setSelection(selectionEnd);
                }
                this.gmt.rZ(this.gmt.czf() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gWg != null && this.gWg.arY() != null && this.gWg.arY().asb()) {
            this.gWg.arY().aqu();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    public String bWW() {
        if (!aq.isEmpty(this.hVM)) {
            return this.hVM;
        }
        this.hVM = getResources().getString(ap.bWO());
        return this.hVM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.hZR = z;
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
        if (this.hZD != null && this.hZD.getListView() != null && this.hZS != null && this.hZS.mPosition != -1) {
            final int headerViewsCount = this.hZS.mPosition + this.hZD.getListView().getHeaderViewsCount();
            if (this.hZS.getView() != null) {
                final int height = this.hZS.getView().getHeight() - ((rect.height() - this.hZD.getNavigationBarHeight()) - this.hZD.bZj());
                if (height > 0) {
                    this.hZD.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.hZD != null && NewSubPbActivity.this.hZD.getListView() != null) {
                                NewSubPbActivity.this.hZD.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.hZD.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.hZD.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.hZD != null && NewSubPbActivity.this.hZD.getListView() != null) {
                                NewSubPbActivity.this.hZD.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.hZD.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }

    private void bUH() {
        if (this.hZB != null && !aq.isEmpty(this.hZB.bVv())) {
            com.baidu.tbadk.BdToken.c.Zg().k(com.baidu.tbadk.BdToken.b.bxN, com.baidu.adp.lib.g.b.c(this.hZB.bVv(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.hZB == null || aq.isEmpty(this.hZB.bVv())) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.c(this.hZB.bVv(), 0L);
    }
}
