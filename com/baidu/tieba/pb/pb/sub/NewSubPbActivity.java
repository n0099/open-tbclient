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
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.au;
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
    private static final String hAj = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String hBB = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> cAv;
    private com.baidu.adp.lib.e.b<GifView> cAw;
    private com.baidu.adp.lib.e.b<TextView> cDk;
    private com.baidu.adp.lib.e.b<View> cDl;
    private com.baidu.adp.lib.e.b<LinearLayout> cDm;
    private com.baidu.adp.lib.e.b<RelativeLayout> cDn;
    private View.OnLongClickListener cdd;
    private VoiceManager eYS;
    private com.baidu.tieba.write.b fPj;
    private EditText fPk;
    private com.baidu.tieba.frs.profession.permission.c fcw;
    private au fzS;
    public aj gyL;
    private g gyT;
    private SubPbModel hBC;
    private ForumManageModel hBD;
    private b hBE;
    private y hBF;
    private AbsListView.OnScrollListener hBG;
    private TbRichTextView.i hBH;
    private TbRichTextView.h hBI;
    private SubPbModel.a hBJ;
    private com.baidu.adp.base.d hBK;
    private BdUniqueId hBP;
    private com.baidu.tieba.pb.pb.sub.a hBR;
    private com.baidu.tieba.pb.d<j> hBS;
    private boolean hBT;
    private com.baidu.tieba.pb.pb.main.j hBU;
    private com.baidu.adp.widget.ImageView.a hnC;
    private String hnD;
    private TbRichTextMemeInfo hnE;
    private com.baidu.tieba.pb.pb.report.a hnb;
    private com.baidu.tbadk.baseEditMark.a hnc;
    private com.baidu.tieba.pb.pb.main.b.a hne;
    private com.baidu.adp.base.e hny;
    private com.baidu.tbadk.core.view.e hnz;
    private b.InterfaceC0191b hom;
    private PostWriteCallBackData hrG;
    private String hyg;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int hok = 0;
    PostData fPR = null;
    private a.InterfaceC0187a hoh = null;
    private a hBL = null;
    private a hBM = null;
    private boolean hBN = false;
    private boolean hBO = false;
    private boolean hBQ = false;
    private boolean ciS = false;
    private com.baidu.tbadk.editortools.pb.c ckl = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void ams() {
            NewSubPbActivity.this.hBE.bOp();
        }
    };
    private com.baidu.tbadk.editortools.pb.b ckm = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean amr() {
            if (!NewSubPbActivity.this.fPj.cnX()) {
                return (NewSubPbActivity.this.gyL == null || NewSubPbActivity.this.hBC == null || NewSubPbActivity.this.hBC.bbJ() == null || NewSubPbActivity.this.gyL.S(NewSubPbActivity.this.hBC.bbJ().replyPrivateFlag, aj.bKt)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.fPj.cnZ());
            if (NewSubPbActivity.this.gyT.amH()) {
                NewSubPbActivity.this.gyT.a(NewSubPbActivity.this.hrG);
            }
            NewSubPbActivity.this.kt(true);
            return true;
        }
    };
    private NewWriteModel.d fPq = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.gyT != null && NewSubPbActivity.this.gyT.alT() != null) {
                NewSubPbActivity.this.gyT.alT().hide();
                if (NewSubPbActivity.this.hBC.bOK()) {
                    TiebaStatic.log(new am("c10367").bJ("post_id", NewSubPbActivity.this.hBC.amp()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fPj.El(null);
                NewSubPbActivity.this.fPj.aE(null);
                NewSubPbActivity.this.fPj.qU(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fPj.aE(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fPj.El(postWriteCallBackData.getErrorString());
                if (!v.T(NewSubPbActivity.this.fPj.cnV())) {
                    NewSubPbActivity.this.hrG = postWriteCallBackData;
                    if (NewSubPbActivity.this.gyT.amH()) {
                        NewSubPbActivity.this.gyT.a(NewSubPbActivity.this.hrG);
                    }
                    NewSubPbActivity.this.kt(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.gyL != null) {
                NewSubPbActivity.this.gyL.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.hBE.bOq();
        }
    };
    private CustomMessageListener hoa = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hBP) {
                NewSubPbActivity.this.hBE.aMF();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hnz.i(NewSubPbActivity.this.hny.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.hny.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.oW(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bKa();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ap.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.hny.getResources().getString(d.j.mute_fail);
                    }
                    NewSubPbActivity.this.hnz.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hob = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hBP) {
                NewSubPbActivity.this.hBE.aMF();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hnz.i(NewSubPbActivity.this.hny.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ap.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.hny.getResources().getString(d.j.un_mute_fail);
                }
                NewSubPbActivity.this.hnz.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hoc = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hBP) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.hBE.aMF();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.iUx;
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
                    NewSubPbActivity.this.hBE.a(sparseArray, z);
                }
            }
        }
    };
    boolean hol = false;
    private final b.InterfaceC0191b hon = new b.InterfaceC0191b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0191b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.hnC != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnD)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.hnE == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hnD));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.hnD;
                        aVar.pkgId = NewSubPbActivity.this.hnE.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hnE.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.adQ();
                    NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.Y(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.fzS == null) {
                            NewSubPbActivity.this.fzS = new au(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.fzS.h(NewSubPbActivity.this.hnD, NewSubPbActivity.this.hnC.oB());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.hnC = null;
                NewSubPbActivity.this.hnD = null;
            }
        }
    };
    private CustomMessageListener gcG = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener fak = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    l lVar = (l) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.hBC.bOE() != null && NewSubPbActivity.this.hBC.bOE().bIE() != null && NewSubPbActivity.this.hBC.bOE().bIE().YR() != null && currentAccount.equals(NewSubPbActivity.this.hBC.bOE().bIE().YR().getUserId()) && NewSubPbActivity.this.hBC.bOE().bIE().YR().getPendantData() != null) {
                        NewSubPbActivity.this.hBC.bOE().bIE().YR().getPendantData().lf(lVar.Xn());
                        NewSubPbActivity.this.hBC.bOE().bIE().YR().getPendantData().aR(lVar.aly());
                        NewSubPbActivity.this.hBE.a(NewSubPbActivity.this.hBC.bOE().bIE(), NewSubPbActivity.this.hBC.bOE().bvv(), NewSubPbActivity.this.hBC.bOE().Vb(), NewSubPbActivity.this.hBC.bIm(), NewSubPbActivity.this.hBC.bOQ() != null);
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
        if (this.ciS) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.hny = getPageContext();
        this.hBO = true;
        this.fPj = new com.baidu.tieba.write.b();
        this.fPj.AX(d.C0236d.cp_cont_h_alpha85);
        this.fPj.AW(d.C0236d.cp_btn_a);
        bgB();
        bOf();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bOe();
        this.hnz = new com.baidu.tbadk.core.view.e();
        this.hnz.bPN = 1000L;
        registerListener(this.hoc);
        registerListener(this.hoa);
        registerListener(this.hob);
        this.hBP = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hBP;
        userMuteAddAndDelCustomMessage.setTag(this.hBP);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hBP;
        userMuteCheckCustomMessage.setTag(this.hBP);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.gyL = new aj(getPageContext());
        this.gyL.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.gyT.amM();
                }
            }
        });
        this.hnb = new com.baidu.tieba.pb.pb.report.a(this);
        this.hnb.p(getUniqueId());
        this.hne = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    private void bOe() {
        if (this.hBE != null && this.hBC != null && this.hBC.bOh()) {
            this.hBR = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.hBE.aDq());
            this.hBR.bgG();
            this.hBR.a(new a.InterfaceC0288a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
                private boolean fnq = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0288a
                public void bgC() {
                    NewSubPbActivity.this.hBE.jH(false);
                    this.fnq = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0288a
                public void bgD() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0288a
                public boolean bgE() {
                    if (!this.fnq) {
                        return NewSubPbActivity.this.hBE.bgS() != null && NewSubPbActivity.this.hBE.bgS().getTop() == 0;
                    }
                    this.fnq = false;
                    return false;
                }
            });
            this.hBE.e(this.hBR);
            this.hBE.jH(true);
        }
    }

    public void initUI() {
        this.hBE = new b(this, this.mCommonClickListener);
        this.hBE.a(this.hBC);
        setContentView(this.hBE.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.hBE.setOnScrollListener(this.hBG);
        this.hBE.b(this);
        this.hBE.setOnLinkImageClickListener(this.hBH);
        this.hBE.setOnImageClickListener(this.hBI);
        this.hBE.nc(true);
        this.hBE.setOnLongClickListener(this.cdd);
        this.hBE.d(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.40
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.hBC != null) {
                    NewSubPbActivity.this.hBC.aov();
                }
            }
        });
        this.hBE.a(this.hBL);
        this.hBE.b(this.hBM);
        if (this.hBC != null && this.hBC.bOh() && !this.hBC.bOP()) {
            this.hBE.bOu().setVisibility(8);
        } else {
            this.hBE.bOu().setVisibility(0);
        }
        if (this.hBC != null && !this.hBC.bOh()) {
            this.hBE.setIsFromPb(false);
        }
    }

    private boolean ab(Bundle bundle) {
        if (bundle != null) {
            this.ciS = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.ciS = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.ciS;
    }

    public void initData(Bundle bundle) {
        this.hBC = new SubPbModel(getPageContext());
        this.hBC.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                NewSubPbActivity.this.hBE.p(postData);
                NewSubPbActivity.this.hBE.b((BdListView.e) null);
            }
        });
        this.hBD = new ForumManageModel(getPageContext());
        this.hBD.setLoadDataCallBack(this.hBK);
        this.eYS = new VoiceManager();
        this.eYS.onCreate(getPageContext());
        this.hnc = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hnc != null) {
            this.hnc.a(this.hoh);
        }
        if (bundle != null) {
            this.hBC.initWithBundle(bundle);
        } else {
            this.hBC.initWithIntent(getIntent());
        }
        this.hBC.a(this.hBJ);
        if (this.hBC.bOh()) {
            this.hBC.aov();
        } else {
            this.hBC.bOJ();
        }
    }

    public void bOf() {
        this.hBJ = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, j jVar) {
                if (NewSubPbActivity.this.hBE != null) {
                    NewSubPbActivity.this.hBE.bOq();
                }
                if (NewSubPbActivity.this.hBR != null && NewSubPbActivity.this.hBR.bgH()) {
                    NewSubPbActivity.this.hBR.qP(d.C0236d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.ax(i, str);
                    return;
                }
                NewSubPbActivity.this.hBE.hideNoDataView();
                if (jVar != null) {
                    if (jVar.bIE() != null || NewSubPbActivity.this.hBC != null) {
                        jVar.bIE().a(NewSubPbActivity.this.hBC.bOO());
                    }
                    if (NewSubPbActivity.this.hBE != null) {
                        NewSubPbActivity.this.hBE.a(jVar, NewSubPbActivity.this.hBC.bIm(), NewSubPbActivity.this.hBC.bOQ() != null);
                        if (NewSubPbActivity.this.hBO) {
                            NewSubPbActivity.this.bOg();
                            NewSubPbActivity.this.hBO = false;
                        }
                    }
                    if (NewSubPbActivity.this.gyT != null) {
                        NewSubPbActivity.this.gyT.a(jVar.bbJ());
                    }
                    if (NewSubPbActivity.this.hBS == null) {
                        NewSubPbActivity.this.hBS = new com.baidu.tieba.pb.d();
                    }
                    NewSubPbActivity.this.hBS.setData(jVar);
                    NewSubPbActivity.this.hBS.setType(0);
                    NewSubPbActivity.this.gyL.a(NewSubPbActivity.this.hBC.bOT());
                }
            }
        };
        this.hoh = new a.InterfaceC0187a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0187a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.hnc != null) {
                        NewSubPbActivity.this.hnc.cZ(z2);
                    }
                    MarkData Ve = NewSubPbActivity.this.hnc.Ve();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setType(2);
                    if (z2) {
                        dVar.setData(Ve);
                        if (NewSubPbActivity.this.hnc != null) {
                            if (Ve != null) {
                                NewSubPbActivity.this.hBC.on(true);
                                NewSubPbActivity.this.hBC.Aq(NewSubPbActivity.this.hBC.amp());
                                NewSubPbActivity.this.showToast(d.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.add_mark));
                            }
                            if (NewSubPbActivity.this.hBE != null) {
                                NewSubPbActivity.this.hBE.om(true);
                            }
                        }
                    } else {
                        dVar.setData(null);
                        NewSubPbActivity.this.hBC.on(false);
                        NewSubPbActivity.this.hBC.Aq(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.remove_mark));
                        if (NewSubPbActivity.this.hBE != null) {
                            NewSubPbActivity.this.hBE.om(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.update_mark_failed));
            }
        };
        this.hBL = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.hBC.bOE() != null && NewSubPbActivity.this.hBC.bOE().WR() != null && NewSubPbActivity.this.hBC.bOE().WR().YR() != null) {
                    str = String.valueOf(NewSubPbActivity.this.hBC.bOE().WR().YR().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.hBC.bOE().bIK().getId(), NewSubPbActivity.this.hBC.bOE().bIK().getName(), NewSubPbActivity.this.hBC.bOE().WR().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.hBM = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.hBD.cfd() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int l = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[1]), 0);
                        boolean e = com.baidu.adp.lib.g.b.e(String.valueOf(objArr[2]), false);
                        int l2 = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.hBC != null && NewSubPbActivity.this.hBC.bOE() != null && NewSubPbActivity.this.hBC.bOE().bIK() != null && NewSubPbActivity.this.hBC.bOE().WR() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.hBD.CH(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.hBD.a(NewSubPbActivity.this.hBC.bOE().bIK().getId(), NewSubPbActivity.this.hBC.bOE().bIK().getName(), NewSubPbActivity.this.hBC.bOE().WR().getId(), valueOf, l2, l, e);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.hBK = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.hBE.a(NewSubPbActivity.this.hBD.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.hBD.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.hCN != 1002 || bVar.fDg) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.hBE.a(1, dVar.Id, dVar.iIK, true);
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

    public void bgB() {
        registerListener(this.fak);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v63, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.hBE != null) {
                    if (view == NewSubPbActivity.this.hBE.bOA()) {
                        NewSubPbActivity.this.hBE.bNa();
                        String str = view.getTag(d.g.tag_user_id) instanceof String ? (String) view.getTag(d.g.tag_user_id) : null;
                        String str2 = view.getTag(d.g.tag_user_name) instanceof String ? (String) view.getTag(d.g.tag_user_name) : null;
                        String str3 = view.getTag(d.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(d.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ba.adD().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.hBE.bgT()) {
                        if (view != NewSubPbActivity.this.hBE.bOt()) {
                            if (view != NewSubPbActivity.this.hBE.bOs()) {
                                if (view == NewSubPbActivity.this.hBE.bOo()) {
                                    NewSubPbActivity.this.hBE.bNa();
                                    if (NewSubPbActivity.this.hBC.aov()) {
                                        NewSubPbActivity.this.hBE.bOm();
                                    }
                                } else if (view == NewSubPbActivity.this.hBE.bOu() || view == NewSubPbActivity.this.hBE.bOv() || view == NewSubPbActivity.this.hBE.bOx()) {
                                    if (NewSubPbActivity.this.hBQ) {
                                        NewSubPbActivity.this.hBQ = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.hBC.bKS(), NewSubPbActivity.this.hBC.amp(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.hBC.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.hBC.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.hBE.bOy() == null || view != NewSubPbActivity.this.hBE.bOy().bLI()) {
                                    if (NewSubPbActivity.this.hBE.bOy() == null || view != NewSubPbActivity.this.hBE.bOy().bLL()) {
                                        if (NewSubPbActivity.this.hBE.bOy() == null || view != NewSubPbActivity.this.hBE.bOy().bLJ()) {
                                            if (NewSubPbActivity.this.hBE.bOy() == null || view != NewSubPbActivity.this.hBE.bOy().bLK()) {
                                                if (NewSubPbActivity.this.hBE.bOy() == null || view != NewSubPbActivity.this.hBE.bOy().bLM()) {
                                                    if (view == NewSubPbActivity.this.hBE.bOr() || view == NewSubPbActivity.this.hBE.bOx()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.gyT.amP()) {
                                                                NewSubPbActivity.this.gyT.amQ();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.gyT.oX(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof com.baidu.tieba.pb.pb.main.j)) {
                                                        if (NewSubPbActivity.this.hBF == null || view != NewSubPbActivity.this.hBF.bLK()) {
                                                            if (NewSubPbActivity.this.hBF == null || view != NewSubPbActivity.this.hBF.bLI()) {
                                                                if (NewSubPbActivity.this.hBF == null || view != NewSubPbActivity.this.hBF.bLL()) {
                                                                    if (NewSubPbActivity.this.hBF == null || view != NewSubPbActivity.this.hBF.bLM()) {
                                                                        if (NewSubPbActivity.this.hBF == null || view != NewSubPbActivity.this.hBF.bLO()) {
                                                                            if (NewSubPbActivity.this.hBF == null || view != NewSubPbActivity.this.hBF.bLP()) {
                                                                                if (NewSubPbActivity.this.hBF != null && view == NewSubPbActivity.this.hBF.bLJ()) {
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
                                                                                            NewSubPbActivity.this.hBE.cs(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.hBE.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
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
                                                                                        if (postData.getType() != PostData.iGl && !TextUtils.isEmpty(postData.getBimg_url()) && i.Wy().WC()) {
                                                                                            NewSubPbActivity.this.An(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.hnC != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnD)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.adQ();
                                                                                NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.Y(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.fzS == null) {
                                                                                        NewSubPbActivity.this.fzS = new au(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.fzS.h(NewSubPbActivity.this.hnD, NewSubPbActivity.this.hnC.oB());
                                                                                    NewSubPbActivity.this.hnC = null;
                                                                                    NewSubPbActivity.this.hnD = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.hnC != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnD)) {
                                                                            if (NewSubPbActivity.this.hnE == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hnD));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.hnD;
                                                                                aVar.pkgId = NewSubPbActivity.this.hnE.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hnE.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.hnC = null;
                                                                            NewSubPbActivity.this.hnD = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.fPR != null) {
                                                                        NewSubPbActivity.this.fPR.ev(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.fPR = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                if (sparseArray2 != null && (sparseArray2.get(d.g.tag_del_post_type) instanceof Integer) && (sparseArray2.get(d.g.tag_del_post_id) instanceof String) && (sparseArray2.get(d.g.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(d.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.hBE.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
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
                                                                NewSubPbActivity.this.zN((String) tag);
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
                                                        NewSubPbActivity.this.hBU = (com.baidu.tieba.pb.pb.main.j) view.getTag();
                                                        if (bc.cZ(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.hBQ) {
                                                                NewSubPbActivity.this.hBQ = false;
                                                                return;
                                                            } else if (NewSubPbActivity.this.gyL == null || NewSubPbActivity.this.hBC == null || NewSubPbActivity.this.hBC.bbJ() == null || NewSubPbActivity.this.gyL.hm(NewSubPbActivity.this.hBC.bbJ().replyPrivateFlag)) {
                                                                if (NewSubPbActivity.this.hBR != null) {
                                                                    NewSubPbActivity.this.hBR.bgF();
                                                                }
                                                                SparseArray sparseArray4 = (SparseArray) view.getTag(d.g.tag_from);
                                                                if (sparseArray4 != null) {
                                                                    if (sparseArray4.get(d.g.tag_clip_board) instanceof PostData) {
                                                                        PostData postData2 = (PostData) sparseArray4.get(d.g.tag_clip_board);
                                                                        if (postData2 != null && postData2.YR() != null) {
                                                                            MetaData YR = postData2.YR();
                                                                            NewSubPbActivity.this.gyT.setReplyId(YR.getUserId());
                                                                            if (!(sparseArray4.get(d.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray4.get(d.g.tag_is_subpb)).booleanValue() : true)) {
                                                                                NewSubPbActivity.this.gyT.oY("");
                                                                            } else {
                                                                                NewSubPbActivity.this.gyT.oY(YR.getName_show());
                                                                            }
                                                                        }
                                                                        NewSubPbActivity.this.hBE.bOk();
                                                                    }
                                                                    if (NewSubPbActivity.this.hBT) {
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
                                                        ((PostData) sparseArray5.get(d.g.tag_clip_board)).ev(NewSubPbActivity.this.getPageContext().getPageActivity());
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
                                            NewSubPbActivity.this.hBE.bNa();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.zN(str4);
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
                                            NewSubPbActivity.this.hBE.bNa();
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
                                    NewSubPbActivity.this.hBE.bNa();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.hBE.a(((Integer) sparseArray7.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray7.get(d.g.tag_del_post_id), ((Integer) sparseArray7.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(d.g.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new am("c11739").T("obj_locate", 2));
                                    NewSubPbActivity.this.hBE.bNa();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.hBC.bOE() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.hBC.bOE().bIE());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.hBE.bOj();
                                NewSubPbActivity.this.hBE.bOk();
                                if (NewSubPbActivity.this.gyT != null) {
                                    NewSubPbActivity.this.gyT.amS();
                                    if (NewSubPbActivity.this.hBR != null) {
                                        NewSubPbActivity.this.hBR.bgF();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.hBE.bOj();
                            NewSubPbActivity.this.hBE.bOk();
                            if (NewSubPbActivity.this.gyT != null) {
                                NewSubPbActivity.this.gyT.amR();
                                if (NewSubPbActivity.this.hBR != null) {
                                    NewSubPbActivity.this.hBR.bgF();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.bJw();
                        if (NewSubPbActivity.this.hBC != null && NewSubPbActivity.this.hBC.bOE() != null && NewSubPbActivity.this.hBC.bOE().WR() != null && NewSubPbActivity.this.hBC.bOE().WR().YR() != null) {
                            TiebaStatic.log(new am("c13402").bJ("tid", NewSubPbActivity.this.hBC.bKS()).k(ImageViewerConfig.FORUM_ID, NewSubPbActivity.this.hBC.bOE().WR().getFid()).T("obj_locate", 5).bJ("uid", NewSubPbActivity.this.hBC.bOE().WR().YR().getUserId()));
                        }
                    }
                }
            }
        };
        this.hBG = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.hBE.bNa();
                }
                NewSubPbActivity.this.gyT.amQ();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.hBE.bOz();
            }
        };
        this.hom = new b.InterfaceC0191b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0191b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.hBC.bOE() != null) {
                    postData = NewSubPbActivity.this.hBC.bOE().bIE();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.ev(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.f(postData);
                    }
                }
            }
        };
        this.cdd = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                        NewSubPbActivity.this.hnC = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.hnD = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.hnC != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnD)) {
                            if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hnE = null;
                            } else {
                                NewSubPbActivity.this.hnE = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                NewSubPbActivity.this.hBE.a(NewSubPbActivity.this.hon, NewSubPbActivity.this.hnC.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                NewSubPbActivity.this.fPR = (PostData) sparseArray2.get(d.g.tag_clip_board);
                                if (NewSubPbActivity.this.fPR != null && NewSubPbActivity.this.hnc != null) {
                                    if (NewSubPbActivity.this.hnc != null) {
                                        NewSubPbActivity.this.hnc.cZ(NewSubPbActivity.this.hBC.isMarked());
                                    }
                                    boolean z = NewSubPbActivity.this.hnc.Vb() && NewSubPbActivity.this.fPR.getId() != null && NewSubPbActivity.this.fPR.getId().equals(NewSubPbActivity.this.hBC.bOL());
                                    if (NewSubPbActivity.this.hBF == null) {
                                        NewSubPbActivity.this.hBF = new y(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.mCommonClickListener);
                                        NewSubPbActivity.this.hBE.cw(NewSubPbActivity.this.hBF.getView());
                                        NewSubPbActivity.this.hBF.nC(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.hBF.showDialog();
                                    boolean isLogin = NewSubPbActivity.this.isLogin() & NewSubPbActivity.this.nj(sparseArray2.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue() : false);
                                    boolean booleanValue = sparseArray2.get(d.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(d.g.tag_is_subpb)).booleanValue() : false;
                                    if (z) {
                                        NewSubPbActivity.this.hBF.bLI().setText(d.j.remove_mark);
                                    } else {
                                        NewSubPbActivity.this.hBF.bLI().setText(d.j.mark);
                                    }
                                    if (booleanValue) {
                                        NewSubPbActivity.this.hBF.bLI().setVisibility(8);
                                    } else {
                                        NewSubPbActivity.this.hBF.bLI().setVisibility(0);
                                    }
                                    if (NewSubPbActivity.this.cm(view)) {
                                        if (NewSubPbActivity.this.hnC != null && !NewSubPbActivity.this.hnC.isGif()) {
                                            sparseArray2.put(d.g.tag_richtext_image, true);
                                        } else {
                                            sparseArray2.put(d.g.tag_richtext_image, false);
                                        }
                                        sparseArray2.put(d.g.tag_richtext_emotion, true);
                                    } else {
                                        sparseArray2.put(d.g.tag_richtext_image, false);
                                        sparseArray2.put(d.g.tag_richtext_emotion, false);
                                    }
                                    NewSubPbActivity.this.hBF.a(sparseArray2, NewSubPbActivity.this.bIm(), isLogin);
                                }
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            NewSubPbActivity.this.hnC = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                NewSubPbActivity.this.hnD = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hnE = null;
                            } else {
                                NewSubPbActivity.this.hnE = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.hnC = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.hnD = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.hnE = null;
                        } else {
                            NewSubPbActivity.this.hnE = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
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
        this.hBH = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void f(View view, String str) {
                NewSubPbActivity.this.o(null, str, "LINK_IMAGE");
            }
        };
        this.hBI = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                        j bOE = NewSubPbActivity.this.hBC.bOE();
                        TbRichText bh = NewSubPbActivity.this.bh(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bh != null && bh.asx() != null) {
                            tbRichTextData = bh.asx().get(NewSubPbActivity.this.hok);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.asE().asQ()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (bOE == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (bOE.bIK() != null) {
                                        str4 = bOE.bIK().getName();
                                        str5 = bOE.bIK().getId();
                                    }
                                    if (bOE.WR() != null) {
                                        str6 = bOE.WR().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.hBC.bOQ() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.hBC.bOQ();
                                    z6 = NewSubPbActivity.this.hBC.bOS();
                                    arrayList2 = NewSubPbActivity.this.hBC.bOR();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.c(arrayList2, 0));
                                NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                                return;
                            }
                            NewSubPbActivity.this.hol = false;
                            String str7 = "";
                            TbRichText cet = bOE.bIE().cet();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(cet, bh, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (bOE == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (bOE.bIK() != null) {
                                    str8 = bOE.bIK().getName();
                                    str9 = bOE.bIK().getId();
                                }
                                if (bOE.WR() != null) {
                                    str10 = bOE.WR().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.hBC.bOQ() != null) {
                                concurrentHashMap = NewSubPbActivity.this.hBC.bOQ();
                                z4 = NewSubPbActivity.this.hBC.bOS();
                                arrayList = NewSubPbActivity.this.hBC.bOR();
                                i2 = a2 + NewSubPbActivity.this.hBC.getOffset();
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
        TbRichTextImageInfo asE;
        if (tbRichText == tbRichText2) {
            this.hol = true;
        }
        if (tbRichText != null && tbRichText.asx() != null) {
            int size = tbRichText.asx().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.asx().get(i6) != null && tbRichText.asx().get(i6).getType() == 8) {
                    i5++;
                    int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                    int width = tbRichText.asx().get(i6).asE().getWidth() * aR;
                    int height = tbRichText.asx().get(i6).asE().getHeight() * aR;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.asx().get(i6).asE().asQ()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.asx().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (asE = tbRichTextData.asE()) != null) {
                            String asS = asE.asS();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = asS;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.hol) {
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
        if (this.hBF != null) {
            this.hBF.nC(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo asE = tbRichTextData.asE();
        if (asE != null) {
            if (!StringUtils.isNull(asE.asP())) {
                return asE.asP();
            }
            if (asE.getHeight() * asE.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (asE.getHeight() * asE.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (asE.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * asE.getHeight())));
            } else {
                float width = asE.getWidth() / asE.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ap.bx(asE.Nx()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bh(String str, int i) {
        if (this.hBC == null || this.hBC.bOE() == null || str == null || i < 0) {
            return null;
        }
        j bOE = this.hBC.bOE();
        TbRichText a2 = a(bOE.bIE(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bOE.bIE(), str, i);
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
        TbRichText cet = postData.cet();
        if (cet != null) {
            ArrayList<TbRichTextData> asx = cet.asx();
            int size = asx.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (asx.get(i3) != null && asx.get(i3).getType() == 8) {
                    i2++;
                    if (asx.get(i3).asE().asS().equals(str)) {
                        int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                        int width = asx.get(i3).asE().getWidth() * aR;
                        int height = asx.get(i3).asE().getHeight() * aR;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.hok = i3;
                        return cet;
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
    public void bJw() {
        if (this.fcw == null) {
            this.fcw = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.fcw.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jl(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void n(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jm(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.gyL == null || NewSubPbActivity.this.hBC == null || NewSubPbActivity.this.hBC.bbJ() == null || NewSubPbActivity.this.gyL.hm(NewSubPbActivity.this.hBC.bbJ().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.gyT.amH()) {
                                NewSubPbActivity.this.gyT.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.hBE.bOj();
                            NewSubPbActivity.this.hBE.bOk();
                            if (NewSubPbActivity.this.gyT != null) {
                                NewSubPbActivity.this.gyT.amT();
                                if (NewSubPbActivity.this.hBR != null) {
                                    NewSubPbActivity.this.hBR.bgF();
                                }
                            }
                        }
                    }
                }
            });
        }
        if (this.hBC != null && this.hBC.bOE() != null && this.hBC.bOE().bIK() != null) {
            this.fcw.q(this.hBC.bOE().bIK().getId(), com.baidu.adp.lib.g.b.d(this.hBC.bKS(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nj(boolean z) {
        if (this.hBC == null) {
            return false;
        }
        return ((bIm() != 0) || this.hBC.bOE() == null || this.hBC.bOE().WR() == null || this.hBC.bOE().WR().YR() == null || TextUtils.equals(this.hBC.bOE().WR().YR().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Context context, String str, String str2) {
        long templateId = this.hBC.bOE().bIE().ceA() != null ? this.hBC.bOE().bIE().ceA().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ba.adD().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.hBC.bOE().bIK().getId(), this.hBC.bOE().bIK().getName(), this.hBC.bOE().WR().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(int i, String str) {
        if (this.hBC.bOF()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.lo()) {
            if (i == 4) {
                this.hBE.vm(str + "(4)");
            } else {
                this.hBE.nS(d.j.no_data_text);
            }
        } else {
            this.hBE.nS(d.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.gyT = (g) new h().dd(getActivity());
        if (this.gyT != null) {
            this.gyT.a(getPageContext());
            this.gyT.b(this.hBC);
            this.gyT.b(this.fPq);
            this.gyT.a(this.ckl);
            this.gyT.a(this.ckm);
            this.gyT.alT().eH(true);
            this.gyT.e(getPageContext());
        }
        if (this.hBE != null) {
            this.hBE.g(this.gyT);
        }
        if (this.gyT != null && this.hBC != null) {
            this.gyT.a(this.hBC.bbJ());
            this.gyT.amQ();
        }
        if (this.gyT != null) {
            this.gyT.amU().setDefaultHint(bMs());
            this.gyT.amU().setHint(bMs());
            this.fPk = this.gyT.amU().getInputView();
            this.fPk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.fPj != null) {
                        if (!NewSubPbActivity.this.fPj.cnY()) {
                            NewSubPbActivity.this.kt(false);
                        }
                        NewSubPbActivity.this.fPj.qV(false);
                    }
                }
            });
        }
    }

    public void bOg() {
        if (!TbadkCoreApplication.isLogin()) {
            this.gyT.amQ();
        } else if (!StringUtils.isNull(this.hBC.bOM())) {
            if (this.hBE.bOn() && com.baidu.adp.lib.util.l.lo()) {
                this.hBE.aYW();
            } else {
                this.hBE.bOq();
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
                    this.hBE.cs(view);
                }
            } else if (booleanValue2) {
                this.hBE.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.hBE.bOw(), getPageContext().getPageActivity());
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
            bVar.gG(d.j.operation);
            bVar.a(strArr, new b.InterfaceC0191b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0191b
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.hBP);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.hBP);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).abc();
        }
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
        }
        this.hBE.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.hBP;
        userMuteCheckCustomMessage.setTag(this.hBP);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.hBE.a(0, bVar.Id, bVar.iIK, z);
            if (bVar.Id) {
                if (bVar.eFR == 1) {
                    if (this.hBE.getListView() instanceof BdTypeListView) {
                        List<m> data = ((BdTypeListView) this.hBE.getListView()).getData();
                        if (!v.T(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            data.remove(i);
                            this.hBE.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.eFR == 2) {
                    this.hBC.Ap(bVar.mPostId);
                    this.hBE.a(this.hBC.bOE(), this.hBC.bIm(), this.hBC.bOQ() != null);
                    if (this.hBC.bON()) {
                        this.hBC.oo(false);
                        this.hBE.bOl();
                        this.hBC.aov();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
            }
        }
    }

    public void zN(String str) {
        this.hnb.Al(str);
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.hBC.isMarked() && postData.getId() != null && postData.getId().equals(this.hBC.bOL())) {
                z = true;
            }
            MarkData j = this.hBC.j(postData);
            if (j != null) {
                this.hBE.bNa();
                if (this.hnc != null) {
                    this.hnc.a(j);
                    if (!z) {
                        this.hnc.Vd();
                    } else {
                        this.hnc.Vc();
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
        if (bundle != null && this.hBC != null) {
            this.hBC.aa(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.gyT != null) {
            this.gyT.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.gyT.alT().akq();
        this.gyT.amQ();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gyT.b(writeData);
                this.gyT.setVoiceModel(pbEditorData.getVoiceModel());
                k jw = this.gyT.alT().jw(6);
                if (jw != null && jw.ciu != null) {
                    jw.ciu.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gyT.amM();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.eYS != null) {
            this.eYS.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.hBN = true;
        super.onPause();
        if (this.eYS != null) {
            this.eYS.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.gcG);
        this.hBE.biR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.hBN = false;
        super.onResume();
        if (this.eYS != null) {
            this.eYS.onResume(getPageContext());
        }
        registerListener(this.gcG);
        this.hBE.biS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eYS != null) {
            this.eYS.onStop(getPageContext());
        }
        this.gyT.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.hBS));
        this.hBC.cancelLoadData();
        this.hBC.destory();
        this.hBD.cancelLoadData();
        if (this.eYS != null) {
            this.eYS.onDestory(getPageContext());
        }
        this.hBE.bNa();
        this.hBE.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.hoa);
        MessageManager.getInstance().unRegisterListener(this.hob);
        MessageManager.getInstance().unRegisterListener(this.hoc);
        MessageManager.getInstance().unRegisterListener(this.hBP);
        this.hny = null;
        this.hnz = null;
        if (this.gyL != null) {
            this.gyL.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hBE.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.eYS;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bOr = this.hBE.bOr();
        if (bOr == null || (findViewWithTag = bOr.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Ae(String str) {
        Map<String, String> mN;
        if (!TextUtils.isEmpty(str) && (mN = ba.mN(ba.mO(str))) != null) {
            this.hBQ = true;
            String str2 = mN.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Ae(com.baidu.adp.lib.util.k.by(str2));
            }
            String str3 = mN.get(hBB);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (Ae(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                    kVar.mLink = str;
                    kVar.type = 3;
                    kVar.chu = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
                }
            } else {
                ba.adD().c(getPageContext(), new String[]{str});
            }
            this.hBQ = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void az(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hBQ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aA(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aB(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aC(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void k(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.hBE != null) {
            return this.hBE.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int ate() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> atg() {
        if (this.cDk == null) {
            this.cDk = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cDk;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> ath() {
        if (this.cAw == null) {
            this.cAw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bKg */
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
    public com.baidu.adp.lib.e.b<ImageView> atf() {
        if (this.cAv == null) {
            this.cAv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.adp.lib.e.c
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean WC = i.Wy().WC();
                    foreDrawableImageView.setDefaultBg(al.getDrawable(d.C0236d.common_color_10220));
                    if (WC) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0236d.cp_bg_line_c);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (i.Wy().WC()) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0236d.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.cAv;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> ati() {
        if (this.cDl == null) {
            this.cDl = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bKh */
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
    public com.baidu.adp.lib.e.b<LinearLayout> atj() {
        if (this.cDm == null) {
            this.cDm = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bKj */
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
    public com.baidu.adp.lib.e.b<RelativeLayout> atk() {
        this.cDn = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bKi */
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
    public com.baidu.tieba.pb.pb.main.b.a bIQ() {
        return this.hne;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bIR() {
        return (this.hBC == null || this.hBC.bOE() == null || this.hBC.bOE().WR() == null || this.hBC.bOE().WR().aaj()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bIS() {
        if (this.hBC == null || this.hBC.bOE() == null || this.hBC.bOE().WR() == null) {
            return null;
        }
        return this.hBC.bOE().WR().YW();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bIT() {
        if (this.hBC == null) {
            return 0;
        }
        return this.hBC.bIm();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean zK(String str) {
        if (StringUtils.isNull(str) || this.hBC == null || this.hBC.bOE() == null || this.hBC.bOE().WR() == null || this.hBC.bOE().WR().YR() == null) {
            return false;
        }
        return str.equals(this.hBC.bOE().WR().YR().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hBE.bOn() && com.baidu.adp.lib.util.l.lo()) {
            this.hBC.aov();
        } else {
            this.hBE.bOq();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.hBP);
        userMuteAddAndDelCustomMessage.setTag(this.hBP);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void An(String str) {
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
    public void aD(Context context, String str) {
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
            public boolean aoL() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int aoM() {
                return com.baidu.tbadk.pageStayDuration.e.aoQ().aoT();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.hBC != null) {
            if (this.hBC.bOE() != null && this.hBC.bOE().bIK() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.hBC.bOE().bIK().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.hBC.bKS(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.hBN;
    }

    public boolean bOh() {
        if (this.hBC != null) {
            return this.hBC.bOh();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hBE.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hny.getPageActivity());
        if (ap.isEmpty(str)) {
            aVar.ly(this.hny.getResources().getString(d.j.block_mute_message_alert, str3));
        } else {
            aVar.ly(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.hBE.showLoadingDialog();
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
        aVar.b(this.hny).aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oW(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hny.getPageActivity());
        aVar.ly(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hny).aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKa() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ly(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.hny).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.hny.getPageActivity(), 2, true, 4);
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
        aVar.b(this.hny).aaZ();
    }

    public SubPbModel bOi() {
        return this.hBC;
    }

    public int bIm() {
        if (this.hBC != null) {
            return this.hBC.bIm();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.ciS) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.ciS) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void kt(boolean z) {
        if (this.fPk != null && this.fPk.getText() != null) {
            int selectionEnd = this.fPk.getSelectionEnd();
            SpannableStringBuilder b = this.fPj.b(this.fPk.getText());
            if (b != null) {
                this.fPj.qV(true);
                this.fPk.setText(b);
                if (z && this.fPj.cnW() >= 0) {
                    this.fPk.requestFocus();
                    this.fPk.setSelection(this.fPj.cnW());
                } else {
                    this.fPk.setSelection(selectionEnd);
                }
                this.fPj.qU(this.fPj.cnW() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gyT != null && this.gyT.alT() != null && this.gyT.alT().alW()) {
            this.gyT.alT().akq();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    public String bMs() {
        if (!ap.isEmpty(this.hyg)) {
            return this.hyg;
        }
        this.hyg = getResources().getString(com.baidu.tieba.pb.pb.main.ap.bMk());
        return this.hyg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.hBT = z;
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
        if (this.hBE != null && this.hBE.getListView() != null && this.hBU != null && this.hBU.mPosition != -1) {
            final int headerViewsCount = this.hBU.mPosition + this.hBE.getListView().getHeaderViewsCount();
            if (this.hBU.getView() != null) {
                final int height = this.hBU.getView().getHeight() - ((rect.height() - this.hBE.getNavigationBarHeight()) - this.hBE.bOB());
                if (height > 0) {
                    this.hBE.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.hBE != null && NewSubPbActivity.this.hBE.getListView() != null) {
                                NewSubPbActivity.this.hBE.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.hBE.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.hBE.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.hBE != null && NewSubPbActivity.this.hBE.getListView() != null) {
                                NewSubPbActivity.this.hBE.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.hBE.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }
}
