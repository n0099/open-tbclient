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
    private com.baidu.adp.lib.e.b<ImageView> cAv;
    private com.baidu.adp.lib.e.b<GifView> cAw;
    private com.baidu.adp.lib.e.b<TextView> cDk;
    private com.baidu.adp.lib.e.b<View> cDl;
    private com.baidu.adp.lib.e.b<LinearLayout> cDm;
    private com.baidu.adp.lib.e.b<RelativeLayout> cDn;
    private View.OnLongClickListener cdg;
    private VoiceManager eYE;
    private com.baidu.tieba.write.b fOW;
    private EditText fOX;
    private com.baidu.tieba.frs.profession.permission.c fci;
    private au fzF;
    private g gyG;
    public aj gyy;
    private boolean hBA;
    private j hBB;
    private SubPbModel hBj;
    private ForumManageModel hBk;
    private b hBl;
    private y hBm;
    private AbsListView.OnScrollListener hBn;
    private TbRichTextView.i hBo;
    private TbRichTextView.h hBp;
    private SubPbModel.a hBq;
    private com.baidu.adp.base.d hBr;
    private BdUniqueId hBw;
    private com.baidu.tieba.pb.pb.sub.a hBy;
    private com.baidu.tieba.pb.d<com.baidu.tieba.pb.data.j> hBz;
    private com.baidu.tieba.pb.pb.report.a hmI;
    private com.baidu.tbadk.baseEditMark.a hmJ;
    private com.baidu.tieba.pb.pb.main.b.a hmL;
    private b.InterfaceC0225b hnT;
    private com.baidu.adp.base.e hnf;
    private com.baidu.tbadk.core.view.e hng;
    private com.baidu.adp.widget.ImageView.a hnj;
    private String hnk;
    private TbRichTextMemeInfo hnl;
    private PostWriteCallBackData hrn;
    private String hxN;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private static final String hzQ = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String hBi = "tbgametype";
    private boolean mIsFromCDN = true;
    private int hnR = 0;
    PostData fPE = null;
    private a.InterfaceC0221a hnO = null;
    private a hBs = null;
    private a hBt = null;
    private boolean hBu = false;
    private boolean hBv = false;
    private boolean hBx = false;
    private boolean ciV = false;
    private com.baidu.tbadk.editortools.pb.c cko = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void amo() {
            NewSubPbActivity.this.hBl.bOm();
        }
    };
    private com.baidu.tbadk.editortools.pb.b ckp = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean amn() {
            if (!NewSubPbActivity.this.fOW.cnY()) {
                return (NewSubPbActivity.this.gyy == null || NewSubPbActivity.this.hBj == null || NewSubPbActivity.this.hBj.bbG() == null || NewSubPbActivity.this.gyy.S(NewSubPbActivity.this.hBj.bbG().replyPrivateFlag, aj.bKx)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.fOW.coa());
            if (NewSubPbActivity.this.gyG.amD()) {
                NewSubPbActivity.this.gyG.a(NewSubPbActivity.this.hrn);
            }
            NewSubPbActivity.this.kt(true);
            return true;
        }
    };
    private NewWriteModel.d fPd = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.gyG != null && NewSubPbActivity.this.gyG.alP() != null) {
                NewSubPbActivity.this.gyG.alP().hide();
                if (NewSubPbActivity.this.hBj.bOH()) {
                    TiebaStatic.log(new am("c10367").bJ("post_id", NewSubPbActivity.this.hBj.aml()));
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
                    NewSubPbActivity.this.hrn = postWriteCallBackData;
                    if (NewSubPbActivity.this.gyG.amD()) {
                        NewSubPbActivity.this.gyG.a(NewSubPbActivity.this.hrn);
                    }
                    NewSubPbActivity.this.kt(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.gyy != null) {
                NewSubPbActivity.this.gyy.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.hBl.bOn();
        }
    };
    private CustomMessageListener hnH = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hBw) {
                NewSubPbActivity.this.hBl.aMt();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hng.i(NewSubPbActivity.this.hnf.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.hnf.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.oX(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bJW();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ap.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.hnf.getResources().getString(d.j.mute_fail);
                    }
                    NewSubPbActivity.this.hng.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hnI = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hBw) {
                NewSubPbActivity.this.hBl.aMt();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hng.i(NewSubPbActivity.this.hnf.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ap.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.hnf.getResources().getString(d.j.un_mute_fail);
                }
                NewSubPbActivity.this.hng.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hnJ = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hBw) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.hBl.aMt();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.iUe;
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
                    NewSubPbActivity.this.hBl.a(sparseArray, z);
                }
            }
        }
    };
    boolean hnS = false;
    private final b.InterfaceC0225b hnU = new b.InterfaceC0225b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.hnj != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnk)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.hnl == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hnk));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.hnk;
                        aVar.pkgId = NewSubPbActivity.this.hnl.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hnl.memeInfo.pck_id;
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
                        NewSubPbActivity.this.fzF.h(NewSubPbActivity.this.hnk, NewSubPbActivity.this.hnj.oB());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.hnj = null;
                NewSubPbActivity.this.hnk = null;
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
    CustomMessageListener eZW = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    l lVar = (l) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.hBj.bOB() != null && NewSubPbActivity.this.hBj.bOB().bIA() != null && NewSubPbActivity.this.hBj.bOB().bIA().YO() != null && currentAccount.equals(NewSubPbActivity.this.hBj.bOB().bIA().YO().getUserId()) && NewSubPbActivity.this.hBj.bOB().bIA().YO().getPendantData() != null) {
                        NewSubPbActivity.this.hBj.bOB().bIA().YO().getPendantData().lg(lVar.Xk());
                        NewSubPbActivity.this.hBj.bOB().bIA().YO().getPendantData().aR(lVar.alu());
                        NewSubPbActivity.this.hBl.a(NewSubPbActivity.this.hBj.bOB().bIA(), NewSubPbActivity.this.hBj.bOB().bvr(), NewSubPbActivity.this.hBj.bOB().UY(), NewSubPbActivity.this.hBj.bIi(), NewSubPbActivity.this.hBj.bON() != null);
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
        if (this.ciV) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.hnf = getPageContext();
        this.hBv = true;
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
        this.hng = new com.baidu.tbadk.core.view.e();
        this.hng.bPR = 1000L;
        registerListener(this.hnJ);
        registerListener(this.hnH);
        registerListener(this.hnI);
        this.hBw = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hBw;
        userMuteAddAndDelCustomMessage.setTag(this.hBw);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hBw;
        userMuteCheckCustomMessage.setTag(this.hBw);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.gyy = new aj(getPageContext());
        this.gyy.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.gyG.amI();
                }
            }
        });
        this.hmI = new com.baidu.tieba.pb.pb.report.a(this);
        this.hmI.p(getUniqueId());
        this.hmL = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    private void bOb() {
        if (this.hBl != null && this.hBj != null && this.hBj.bOe()) {
            this.hBy = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.hBl.aDm());
            this.hBy.bgD();
            this.hBy.a(new a.InterfaceC0361a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
                private boolean fnb = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0361a
                public void bgz() {
                    NewSubPbActivity.this.hBl.jH(false);
                    this.fnb = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0361a
                public void bgA() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0361a
                public boolean bgB() {
                    if (!this.fnb) {
                        return NewSubPbActivity.this.hBl.bgP() != null && NewSubPbActivity.this.hBl.bgP().getTop() == 0;
                    }
                    this.fnb = false;
                    return false;
                }
            });
            this.hBl.e(this.hBy);
            this.hBl.jH(true);
        }
    }

    public void initUI() {
        this.hBl = new b(this, this.mCommonClickListener);
        this.hBl.a(this.hBj);
        setContentView(this.hBl.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.hBl.setOnScrollListener(this.hBn);
        this.hBl.b(this);
        this.hBl.setOnLinkImageClickListener(this.hBo);
        this.hBl.setOnImageClickListener(this.hBp);
        this.hBl.nc(true);
        this.hBl.setOnLongClickListener(this.cdg);
        this.hBl.d(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.40
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.hBj != null) {
                    NewSubPbActivity.this.hBj.aor();
                }
            }
        });
        this.hBl.a(this.hBs);
        this.hBl.b(this.hBt);
        if (this.hBj != null && this.hBj.bOe() && !this.hBj.bOM()) {
            this.hBl.bOr().setVisibility(8);
        } else {
            this.hBl.bOr().setVisibility(0);
        }
        if (this.hBj != null && !this.hBj.bOe()) {
            this.hBl.setIsFromPb(false);
        }
    }

    private boolean ab(Bundle bundle) {
        if (bundle != null) {
            this.ciV = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.ciV = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.ciV;
    }

    public void initData(Bundle bundle) {
        this.hBj = new SubPbModel(getPageContext());
        this.hBj.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                NewSubPbActivity.this.hBl.p(postData);
                NewSubPbActivity.this.hBl.b((BdListView.e) null);
            }
        });
        this.hBk = new ForumManageModel(getPageContext());
        this.hBk.setLoadDataCallBack(this.hBr);
        this.eYE = new VoiceManager();
        this.eYE.onCreate(getPageContext());
        this.hmJ = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hmJ != null) {
            this.hmJ.a(this.hnO);
        }
        if (bundle != null) {
            this.hBj.initWithBundle(bundle);
        } else {
            this.hBj.initWithIntent(getIntent());
        }
        this.hBj.a(this.hBq);
        if (this.hBj.bOe()) {
            this.hBj.aor();
        } else {
            this.hBj.bOG();
        }
    }

    public void bOc() {
        this.hBq = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, com.baidu.tieba.pb.data.j jVar) {
                if (NewSubPbActivity.this.hBl != null) {
                    NewSubPbActivity.this.hBl.bOn();
                }
                if (NewSubPbActivity.this.hBy != null && NewSubPbActivity.this.hBy.bgE()) {
                    NewSubPbActivity.this.hBy.qL(d.C0277d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.az(i, str);
                    return;
                }
                NewSubPbActivity.this.hBl.hideNoDataView();
                if (jVar != null) {
                    if (jVar.bIA() != null || NewSubPbActivity.this.hBj != null) {
                        jVar.bIA().a(NewSubPbActivity.this.hBj.bOL());
                    }
                    if (NewSubPbActivity.this.hBl != null) {
                        NewSubPbActivity.this.hBl.a(jVar, NewSubPbActivity.this.hBj.bIi(), NewSubPbActivity.this.hBj.bON() != null);
                        if (NewSubPbActivity.this.hBv) {
                            NewSubPbActivity.this.bOd();
                            NewSubPbActivity.this.hBv = false;
                        }
                    }
                    if (NewSubPbActivity.this.gyG != null) {
                        NewSubPbActivity.this.gyG.a(jVar.bbG());
                    }
                    if (NewSubPbActivity.this.hBz == null) {
                        NewSubPbActivity.this.hBz = new com.baidu.tieba.pb.d();
                    }
                    NewSubPbActivity.this.hBz.setData(jVar);
                    NewSubPbActivity.this.hBz.setType(0);
                    NewSubPbActivity.this.gyy.a(NewSubPbActivity.this.hBj.bOQ());
                }
            }
        };
        this.hnO = new a.InterfaceC0221a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0221a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.hmJ != null) {
                        NewSubPbActivity.this.hmJ.cZ(z2);
                    }
                    MarkData Vb = NewSubPbActivity.this.hmJ.Vb();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setType(2);
                    if (z2) {
                        dVar.setData(Vb);
                        if (NewSubPbActivity.this.hmJ != null) {
                            if (Vb != null) {
                                NewSubPbActivity.this.hBj.on(true);
                                NewSubPbActivity.this.hBj.An(NewSubPbActivity.this.hBj.aml());
                                NewSubPbActivity.this.showToast(d.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.add_mark));
                            }
                            if (NewSubPbActivity.this.hBl != null) {
                                NewSubPbActivity.this.hBl.om(true);
                            }
                        }
                    } else {
                        dVar.setData(null);
                        NewSubPbActivity.this.hBj.on(false);
                        NewSubPbActivity.this.hBj.An(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.remove_mark));
                        if (NewSubPbActivity.this.hBl != null) {
                            NewSubPbActivity.this.hBl.om(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.update_mark_failed));
            }
        };
        this.hBs = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.hBj.bOB() != null && NewSubPbActivity.this.hBj.bOB().WO() != null && NewSubPbActivity.this.hBj.bOB().WO().YO() != null) {
                    str = String.valueOf(NewSubPbActivity.this.hBj.bOB().WO().YO().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.hBj.bOB().bIG().getId(), NewSubPbActivity.this.hBj.bOB().bIG().getName(), NewSubPbActivity.this.hBj.bOB().WO().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.hBt = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.hBk.cfb() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int l = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[1]), 0);
                        boolean e = com.baidu.adp.lib.g.b.e(String.valueOf(objArr[2]), false);
                        int l2 = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.hBj != null && NewSubPbActivity.this.hBj.bOB() != null && NewSubPbActivity.this.hBj.bOB().bIG() != null && NewSubPbActivity.this.hBj.bOB().WO() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.hBk.CE(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.hBk.a(NewSubPbActivity.this.hBj.bOB().bIG().getId(), NewSubPbActivity.this.hBj.bOB().bIG().getName(), NewSubPbActivity.this.hBj.bOB().WO().getId(), valueOf, l2, l, e);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.hBr = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.hBl.a(NewSubPbActivity.this.hBk.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.hBk.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.hCu != 1002 || bVar.fCT) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.hBl.a(1, dVar.Id, dVar.iIo, true);
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
        registerListener(this.eZW);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v63, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.hBl != null) {
                    if (view == NewSubPbActivity.this.hBl.bOx()) {
                        NewSubPbActivity.this.hBl.bMX();
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
                    } else if (view != NewSubPbActivity.this.hBl.bgQ()) {
                        if (view != NewSubPbActivity.this.hBl.bOq()) {
                            if (view != NewSubPbActivity.this.hBl.bOp()) {
                                if (view == NewSubPbActivity.this.hBl.bOl()) {
                                    NewSubPbActivity.this.hBl.bMX();
                                    if (NewSubPbActivity.this.hBj.aor()) {
                                        NewSubPbActivity.this.hBl.bOj();
                                    }
                                } else if (view == NewSubPbActivity.this.hBl.bOr() || view == NewSubPbActivity.this.hBl.bOs() || view == NewSubPbActivity.this.hBl.bOu()) {
                                    if (NewSubPbActivity.this.hBx) {
                                        NewSubPbActivity.this.hBx = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.hBj.bKO(), NewSubPbActivity.this.hBj.aml(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.hBj.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.hBj.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.hBl.bOv() == null || view != NewSubPbActivity.this.hBl.bOv().bLE()) {
                                    if (NewSubPbActivity.this.hBl.bOv() == null || view != NewSubPbActivity.this.hBl.bOv().bLH()) {
                                        if (NewSubPbActivity.this.hBl.bOv() == null || view != NewSubPbActivity.this.hBl.bOv().bLF()) {
                                            if (NewSubPbActivity.this.hBl.bOv() == null || view != NewSubPbActivity.this.hBl.bOv().bLG()) {
                                                if (NewSubPbActivity.this.hBl.bOv() == null || view != NewSubPbActivity.this.hBl.bOv().bLI()) {
                                                    if (view == NewSubPbActivity.this.hBl.bOo() || view == NewSubPbActivity.this.hBl.bOu()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.gyG.amL()) {
                                                                NewSubPbActivity.this.gyG.amM();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.gyG.oY(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof j)) {
                                                        if (NewSubPbActivity.this.hBm == null || view != NewSubPbActivity.this.hBm.bLG()) {
                                                            if (NewSubPbActivity.this.hBm == null || view != NewSubPbActivity.this.hBm.bLE()) {
                                                                if (NewSubPbActivity.this.hBm == null || view != NewSubPbActivity.this.hBm.bLH()) {
                                                                    if (NewSubPbActivity.this.hBm == null || view != NewSubPbActivity.this.hBm.bLI()) {
                                                                        if (NewSubPbActivity.this.hBm == null || view != NewSubPbActivity.this.hBm.bLK()) {
                                                                            if (NewSubPbActivity.this.hBm == null || view != NewSubPbActivity.this.hBm.bLL()) {
                                                                                if (NewSubPbActivity.this.hBm != null && view == NewSubPbActivity.this.hBm.bLF()) {
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
                                                                                            NewSubPbActivity.this.hBl.cs(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.hBl.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
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
                                                                                        if (postData.getType() != PostData.iFO && !TextUtils.isEmpty(postData.getBimg_url()) && i.Wv().Wz()) {
                                                                                            NewSubPbActivity.this.Ak(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.hnj != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnk)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.adN();
                                                                                NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.Y(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.fzF == null) {
                                                                                        NewSubPbActivity.this.fzF = new au(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.fzF.h(NewSubPbActivity.this.hnk, NewSubPbActivity.this.hnj.oB());
                                                                                    NewSubPbActivity.this.hnj = null;
                                                                                    NewSubPbActivity.this.hnk = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.hnj != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnk)) {
                                                                            if (NewSubPbActivity.this.hnl == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hnk));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.hnk;
                                                                                aVar.pkgId = NewSubPbActivity.this.hnl.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hnl.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.hnj = null;
                                                                            NewSubPbActivity.this.hnk = null;
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
                                                                    NewSubPbActivity.this.hBl.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
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
                                                        NewSubPbActivity.this.hBB = (j) view.getTag();
                                                        if (bc.cZ(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.hBx) {
                                                                NewSubPbActivity.this.hBx = false;
                                                                return;
                                                            } else if (NewSubPbActivity.this.gyy == null || NewSubPbActivity.this.hBj == null || NewSubPbActivity.this.hBj.bbG() == null || NewSubPbActivity.this.gyy.hl(NewSubPbActivity.this.hBj.bbG().replyPrivateFlag)) {
                                                                if (NewSubPbActivity.this.hBy != null) {
                                                                    NewSubPbActivity.this.hBy.bgC();
                                                                }
                                                                SparseArray sparseArray4 = (SparseArray) view.getTag(d.g.tag_from);
                                                                if (sparseArray4 != null) {
                                                                    if (sparseArray4.get(d.g.tag_clip_board) instanceof PostData) {
                                                                        PostData postData2 = (PostData) sparseArray4.get(d.g.tag_clip_board);
                                                                        if (postData2 != null && postData2.YO() != null) {
                                                                            MetaData YO = postData2.YO();
                                                                            NewSubPbActivity.this.gyG.setReplyId(YO.getUserId());
                                                                            if (!(sparseArray4.get(d.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray4.get(d.g.tag_is_subpb)).booleanValue() : true)) {
                                                                                NewSubPbActivity.this.gyG.oZ("");
                                                                            } else {
                                                                                NewSubPbActivity.this.gyG.oZ(YO.getName_show());
                                                                            }
                                                                        }
                                                                        NewSubPbActivity.this.hBl.bOh();
                                                                    }
                                                                    if (NewSubPbActivity.this.hBA) {
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
                                            NewSubPbActivity.this.hBl.bMX();
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
                                            NewSubPbActivity.this.hBl.bMX();
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
                                    NewSubPbActivity.this.hBl.bMX();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.hBl.a(((Integer) sparseArray7.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray7.get(d.g.tag_del_post_id), ((Integer) sparseArray7.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(d.g.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new am("c11739").T("obj_locate", 2));
                                    NewSubPbActivity.this.hBl.bMX();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.hBj.bOB() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.hBj.bOB().bIA());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.hBl.bOg();
                                NewSubPbActivity.this.hBl.bOh();
                                if (NewSubPbActivity.this.gyG != null) {
                                    NewSubPbActivity.this.gyG.amO();
                                    if (NewSubPbActivity.this.hBy != null) {
                                        NewSubPbActivity.this.hBy.bgC();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.hBl.bOg();
                            NewSubPbActivity.this.hBl.bOh();
                            if (NewSubPbActivity.this.gyG != null) {
                                NewSubPbActivity.this.gyG.amN();
                                if (NewSubPbActivity.this.hBy != null) {
                                    NewSubPbActivity.this.hBy.bgC();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.bJs();
                        if (NewSubPbActivity.this.hBj != null && NewSubPbActivity.this.hBj.bOB() != null && NewSubPbActivity.this.hBj.bOB().WO() != null && NewSubPbActivity.this.hBj.bOB().WO().YO() != null) {
                            TiebaStatic.log(new am("c13402").bJ("tid", NewSubPbActivity.this.hBj.bKO()).k(ImageViewerConfig.FORUM_ID, NewSubPbActivity.this.hBj.bOB().WO().getFid()).T("obj_locate", 5).bJ("uid", NewSubPbActivity.this.hBj.bOB().WO().YO().getUserId()));
                        }
                    }
                }
            }
        };
        this.hBn = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.hBl.bMX();
                }
                NewSubPbActivity.this.gyG.amM();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.hBl.bOw();
            }
        };
        this.hnT = new b.InterfaceC0225b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.hBj.bOB() != null) {
                    postData = NewSubPbActivity.this.hBj.bOB().bIA();
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
        this.cdg = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                        NewSubPbActivity.this.hnj = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.hnk = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.hnj != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnk)) {
                            if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hnl = null;
                            } else {
                                NewSubPbActivity.this.hnl = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                NewSubPbActivity.this.hBl.a(NewSubPbActivity.this.hnU, NewSubPbActivity.this.hnj.isGif());
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
                                if (NewSubPbActivity.this.fPE != null && NewSubPbActivity.this.hmJ != null) {
                                    if (NewSubPbActivity.this.hmJ != null) {
                                        NewSubPbActivity.this.hmJ.cZ(NewSubPbActivity.this.hBj.isMarked());
                                    }
                                    boolean z = NewSubPbActivity.this.hmJ.UY() && NewSubPbActivity.this.fPE.getId() != null && NewSubPbActivity.this.fPE.getId().equals(NewSubPbActivity.this.hBj.bOI());
                                    if (NewSubPbActivity.this.hBm == null) {
                                        NewSubPbActivity.this.hBm = new y(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.mCommonClickListener);
                                        NewSubPbActivity.this.hBl.cw(NewSubPbActivity.this.hBm.getView());
                                        NewSubPbActivity.this.hBm.nC(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.hBm.showDialog();
                                    boolean isLogin = NewSubPbActivity.this.isLogin() & NewSubPbActivity.this.nj(sparseArray2.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue() : false);
                                    boolean booleanValue = sparseArray2.get(d.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(d.g.tag_is_subpb)).booleanValue() : false;
                                    if (z) {
                                        NewSubPbActivity.this.hBm.bLE().setText(d.j.remove_mark);
                                    } else {
                                        NewSubPbActivity.this.hBm.bLE().setText(d.j.mark);
                                    }
                                    if (booleanValue) {
                                        NewSubPbActivity.this.hBm.bLE().setVisibility(8);
                                    } else {
                                        NewSubPbActivity.this.hBm.bLE().setVisibility(0);
                                    }
                                    if (NewSubPbActivity.this.cm(view)) {
                                        if (NewSubPbActivity.this.hnj != null && !NewSubPbActivity.this.hnj.isGif()) {
                                            sparseArray2.put(d.g.tag_richtext_image, true);
                                        } else {
                                            sparseArray2.put(d.g.tag_richtext_image, false);
                                        }
                                        sparseArray2.put(d.g.tag_richtext_emotion, true);
                                    } else {
                                        sparseArray2.put(d.g.tag_richtext_image, false);
                                        sparseArray2.put(d.g.tag_richtext_emotion, false);
                                    }
                                    NewSubPbActivity.this.hBm.a(sparseArray2, NewSubPbActivity.this.bIi(), isLogin);
                                }
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            NewSubPbActivity.this.hnj = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                NewSubPbActivity.this.hnk = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hnl = null;
                            } else {
                                NewSubPbActivity.this.hnl = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.hnj = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.hnk = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.hnl = null;
                        } else {
                            NewSubPbActivity.this.hnl = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
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
        this.hBo = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void f(View view, String str) {
                NewSubPbActivity.this.o(null, str, "LINK_IMAGE");
            }
        };
        this.hBp = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                        com.baidu.tieba.pb.data.j bOB = NewSubPbActivity.this.hBj.bOB();
                        TbRichText bh = NewSubPbActivity.this.bh(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bh != null && bh.ast() != null) {
                            tbRichTextData = bh.ast().get(NewSubPbActivity.this.hnR);
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
                                if (NewSubPbActivity.this.hBj.bON() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.hBj.bON();
                                    z6 = NewSubPbActivity.this.hBj.bOP();
                                    arrayList2 = NewSubPbActivity.this.hBj.bOO();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.c(arrayList2, 0));
                                NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                                return;
                            }
                            NewSubPbActivity.this.hnS = false;
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
                            if (NewSubPbActivity.this.hBj.bON() != null) {
                                concurrentHashMap = NewSubPbActivity.this.hBj.bON();
                                z4 = NewSubPbActivity.this.hBj.bOP();
                                arrayList = NewSubPbActivity.this.hBj.bOO();
                                i2 = a2 + NewSubPbActivity.this.hBj.getOffset();
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
            this.hnS = true;
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
                        if (!this.hnS) {
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
        if (this.hBm != null) {
            this.hBm.nC(z);
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
        if (this.hBj == null || this.hBj.bOB() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.j bOB = this.hBj.bOB();
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
                        this.hnR = i3;
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
                        if (NewSubPbActivity.this.gyy == null || NewSubPbActivity.this.hBj == null || NewSubPbActivity.this.hBj.bbG() == null || NewSubPbActivity.this.gyy.hl(NewSubPbActivity.this.hBj.bbG().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.gyG.amD()) {
                                NewSubPbActivity.this.gyG.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.hBl.bOg();
                            NewSubPbActivity.this.hBl.bOh();
                            if (NewSubPbActivity.this.gyG != null) {
                                NewSubPbActivity.this.gyG.amP();
                                if (NewSubPbActivity.this.hBy != null) {
                                    NewSubPbActivity.this.hBy.bgC();
                                }
                            }
                        }
                    }
                }
            });
        }
        if (this.hBj != null && this.hBj.bOB() != null && this.hBj.bOB().bIG() != null) {
            this.fci.q(this.hBj.bOB().bIG().getId(), com.baidu.adp.lib.g.b.d(this.hBj.bKO(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nj(boolean z) {
        if (this.hBj == null) {
            return false;
        }
        return ((bIi() != 0) || this.hBj.bOB() == null || this.hBj.bOB().WO() == null || this.hBj.bOB().WO().YO() == null || TextUtils.equals(this.hBj.bOB().WO().YO().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Context context, String str, String str2) {
        long templateId = this.hBj.bOB().bIA().cey() != null ? this.hBj.bOB().bIA().cey().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ba.adA().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.hBj.bOB().bIG().getId(), this.hBj.bOB().bIG().getName(), this.hBj.bOB().WO().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(int i, String str) {
        if (this.hBj.bOC()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.lo()) {
            if (i == 4) {
                this.hBl.vj(str + "(4)");
            } else {
                this.hBl.nQ(d.j.no_data_text);
            }
        } else {
            this.hBl.nQ(d.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.gyG = (g) new h().dd(getActivity());
        if (this.gyG != null) {
            this.gyG.a(getPageContext());
            this.gyG.b(this.hBj);
            this.gyG.b(this.fPd);
            this.gyG.a(this.cko);
            this.gyG.a(this.ckp);
            this.gyG.alP().eH(true);
            this.gyG.e(getPageContext());
        }
        if (this.hBl != null) {
            this.hBl.g(this.gyG);
        }
        if (this.gyG != null && this.hBj != null) {
            this.gyG.a(this.hBj.bbG());
            this.gyG.amM();
        }
        if (this.gyG != null) {
            this.gyG.amQ().setDefaultHint(bMo());
            this.gyG.amQ().setHint(bMo());
            this.fOX = this.gyG.amQ().getInputView();
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
            this.gyG.amM();
        } else if (!StringUtils.isNull(this.hBj.bOJ())) {
            if (this.hBl.bOk() && com.baidu.adp.lib.util.l.lo()) {
                this.hBl.aYS();
            } else {
                this.hBl.bOn();
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
                    this.hBl.cs(view);
                }
            } else if (booleanValue2) {
                this.hBl.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.hBl.bOt(), getPageContext().getPageActivity());
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.hBw);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.hBw);
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
        this.hBl.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.hBw;
        userMuteCheckCustomMessage.setTag(this.hBw);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.hBl.a(0, bVar.Id, bVar.iIo, z);
            if (bVar.Id) {
                if (bVar.eFz == 1) {
                    if (this.hBl.getListView() instanceof BdTypeListView) {
                        List<m> data = ((BdTypeListView) this.hBl.getListView()).getData();
                        if (!v.T(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.hBl.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.eFz == 2) {
                    this.hBj.Am(bVar.mPostId);
                    this.hBl.a(this.hBj.bOB(), this.hBj.bIi(), this.hBj.bON() != null);
                    if (this.hBj.bOK()) {
                        this.hBj.oo(false);
                        this.hBl.bOi();
                        this.hBj.aor();
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
        this.hmI.Ai(str);
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.hBj.isMarked() && postData.getId() != null && postData.getId().equals(this.hBj.bOI())) {
                z = true;
            }
            MarkData j = this.hBj.j(postData);
            if (j != null) {
                this.hBl.bMX();
                if (this.hmJ != null) {
                    this.hmJ.a(j);
                    if (!z) {
                        this.hmJ.Va();
                    } else {
                        this.hmJ.UZ();
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
        if (bundle != null && this.hBj != null) {
            this.hBj.aa(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.gyG != null) {
            this.gyG.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.gyG.alP().akm();
        this.gyG.amM();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gyG.b(writeData);
                this.gyG.setVoiceModel(pbEditorData.getVoiceModel());
                k jv = this.gyG.alP().jv(6);
                if (jv != null && jv.cix != null) {
                    jv.cix.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gyG.amI();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.eYE != null) {
            this.eYE.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.hBu = true;
        super.onPause();
        if (this.eYE != null) {
            this.eYE.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.gct);
        this.hBl.biO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.hBu = false;
        super.onResume();
        if (this.eYE != null) {
            this.eYE.onResume(getPageContext());
        }
        registerListener(this.gct);
        this.hBl.biP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eYE != null) {
            this.eYE.onStop(getPageContext());
        }
        this.gyG.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.hBz));
        this.hBj.cancelLoadData();
        this.hBj.destory();
        this.hBk.cancelLoadData();
        if (this.eYE != null) {
            this.eYE.onDestory(getPageContext());
        }
        this.hBl.bMX();
        this.hBl.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.hnH);
        MessageManager.getInstance().unRegisterListener(this.hnI);
        MessageManager.getInstance().unRegisterListener(this.hnJ);
        MessageManager.getInstance().unRegisterListener(this.hBw);
        this.hnf = null;
        this.hng = null;
        if (this.gyy != null) {
            this.gyy.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hBl.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.eYE;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bOo = this.hBl.bOo();
        if (bOo == null || (findViewWithTag = bOo.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Ab(String str) {
        Map<String, String> mO;
        if (!TextUtils.isEmpty(str) && (mO = ba.mO(ba.mP(str))) != null) {
            this.hBx = true;
            String str2 = mO.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Ab(com.baidu.adp.lib.util.k.by(str2));
            }
            String str3 = mO.get(hBi);
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
                    kVar.chx = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
                }
            } else {
                ba.adA().c(getPageContext(), new String[]{str});
            }
            this.hBx = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ay(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hBx = true;
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
        if (this.hBl != null) {
            return this.hBl.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int ata() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> atc() {
        if (this.cDk == null) {
            this.cDk = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cDk;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> atd() {
        if (this.cAw == null) {
            this.cAw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
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
        return this.cAw;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> atb() {
        if (this.cAv == null) {
            this.cAv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
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
        return this.cAv;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> ate() {
        if (this.cDl == null) {
            this.cDl = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
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
        return this.cDl;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> atf() {
        if (this.cDm == null) {
            this.cDm = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
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
        return this.cDm;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> atg() {
        this.cDn = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
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
        return this.cDn;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bIM() {
        return this.hmL;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bIN() {
        return (this.hBj == null || this.hBj.bOB() == null || this.hBj.bOB().WO() == null || this.hBj.bOB().WO().aag()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bIO() {
        if (this.hBj == null || this.hBj.bOB() == null || this.hBj.bOB().WO() == null) {
            return null;
        }
        return this.hBj.bOB().WO().YT();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bIP() {
        if (this.hBj == null) {
            return 0;
        }
        return this.hBj.bIi();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean zH(String str) {
        if (StringUtils.isNull(str) || this.hBj == null || this.hBj.bOB() == null || this.hBj.bOB().WO() == null || this.hBj.bOB().WO().YO() == null) {
            return false;
        }
        return str.equals(this.hBj.bOB().WO().YO().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hBl.bOk() && com.baidu.adp.lib.util.l.lo()) {
            this.hBj.aor();
        } else {
            this.hBl.bOn();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.hBw);
        userMuteAddAndDelCustomMessage.setTag(this.hBw);
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
        if (pageStayDurationItem != null && this.hBj != null) {
            if (this.hBj.bOB() != null && this.hBj.bOB().bIG() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.hBj.bOB().bIG().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.hBj.bKO(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.hBu;
    }

    public boolean bOe() {
        if (this.hBj != null) {
            return this.hBj.bOe();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hBl.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hnf.getPageActivity());
        if (ap.isEmpty(str)) {
            aVar.lz(this.hnf.getResources().getString(d.j.block_mute_message_alert, str3));
        } else {
            aVar.lz(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.hBl.showLoadingDialog();
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
        aVar.b(this.hnf).aaW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oX(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hnf.getPageActivity());
        aVar.lz(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hnf).aaW();
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
                    ((TbPageContext) NewSubPbActivity.this.hnf).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.hnf.getPageActivity(), 2, true, 4);
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
        aVar.b(this.hnf).aaW();
    }

    public SubPbModel bOf() {
        return this.hBj;
    }

    public int bIi() {
        if (this.hBj != null) {
            return this.hBj.bIi();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.ciV) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.ciV) {
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
        if (this.gyG != null && this.gyG.alP() != null && this.gyG.alP().alS()) {
            this.gyG.alP().akm();
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
        if (!ap.isEmpty(this.hxN)) {
            return this.hxN;
        }
        this.hxN = getResources().getString(com.baidu.tieba.pb.pb.main.ap.bMg());
        return this.hxN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.hBA = z;
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
        if (this.hBl != null && this.hBl.getListView() != null && this.hBB != null && this.hBB.mPosition != -1) {
            final int headerViewsCount = this.hBB.mPosition + this.hBl.getListView().getHeaderViewsCount();
            if (this.hBB.getView() != null) {
                final int height = this.hBB.getView().getHeight() - ((rect.height() - this.hBl.getNavigationBarHeight()) - this.hBl.bOy());
                if (height > 0) {
                    this.hBl.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.hBl != null && NewSubPbActivity.this.hBl.getListView() != null) {
                                NewSubPbActivity.this.hBl.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.hBl.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.hBl.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.hBl != null && NewSubPbActivity.this.hBl.getListView() != null) {
                                NewSubPbActivity.this.hBl.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.hBl.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }
}
