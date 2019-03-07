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
    private static final String hAi = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String hBA = "tbgametype";
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
    public aj gyK;
    private g gyS;
    private SubPbModel hBB;
    private ForumManageModel hBC;
    private b hBD;
    private y hBE;
    private AbsListView.OnScrollListener hBF;
    private TbRichTextView.i hBG;
    private TbRichTextView.h hBH;
    private SubPbModel.a hBI;
    private com.baidu.adp.base.d hBJ;
    private BdUniqueId hBO;
    private com.baidu.tieba.pb.pb.sub.a hBQ;
    private com.baidu.tieba.pb.d<j> hBR;
    private boolean hBS;
    private com.baidu.tieba.pb.pb.main.j hBT;
    private com.baidu.adp.widget.ImageView.a hnB;
    private String hnC;
    private TbRichTextMemeInfo hnD;
    private com.baidu.tieba.pb.pb.report.a hna;
    private com.baidu.tbadk.baseEditMark.a hnb;
    private com.baidu.tieba.pb.pb.main.b.a hnd;
    private com.baidu.adp.base.e hnx;
    private com.baidu.tbadk.core.view.e hny;
    private b.InterfaceC0191b hol;
    private PostWriteCallBackData hrF;
    private String hyf;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int hoj = 0;
    PostData fPQ = null;
    private a.InterfaceC0187a hog = null;
    private a hBK = null;
    private a hBL = null;
    private boolean hBM = false;
    private boolean hBN = false;
    private boolean hBP = false;
    private boolean ciS = false;
    private com.baidu.tbadk.editortools.pb.c ckl = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void ams() {
            NewSubPbActivity.this.hBD.bOo();
        }
    };
    private com.baidu.tbadk.editortools.pb.b ckm = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean amr() {
            if (!NewSubPbActivity.this.fPj.cnN()) {
                return (NewSubPbActivity.this.gyK == null || NewSubPbActivity.this.hBB == null || NewSubPbActivity.this.hBB.bbI() == null || NewSubPbActivity.this.gyK.S(NewSubPbActivity.this.hBB.bbI().replyPrivateFlag, aj.bKt)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.fPj.cnP());
            if (NewSubPbActivity.this.gyS.amH()) {
                NewSubPbActivity.this.gyS.a(NewSubPbActivity.this.hrF);
            }
            NewSubPbActivity.this.kt(true);
            return true;
        }
    };
    private NewWriteModel.d fPp = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.gyS != null && NewSubPbActivity.this.gyS.alT() != null) {
                NewSubPbActivity.this.gyS.alT().hide();
                if (NewSubPbActivity.this.hBB.bOJ()) {
                    TiebaStatic.log(new am("c10367").bJ("post_id", NewSubPbActivity.this.hBB.amp()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fPj.Ei(null);
                NewSubPbActivity.this.fPj.aE(null);
                NewSubPbActivity.this.fPj.qU(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fPj.aE(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fPj.Ei(postWriteCallBackData.getErrorString());
                if (!v.T(NewSubPbActivity.this.fPj.cnL())) {
                    NewSubPbActivity.this.hrF = postWriteCallBackData;
                    if (NewSubPbActivity.this.gyS.amH()) {
                        NewSubPbActivity.this.gyS.a(NewSubPbActivity.this.hrF);
                    }
                    NewSubPbActivity.this.kt(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.gyK != null) {
                NewSubPbActivity.this.gyK.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.hBD.bOp();
        }
    };
    private CustomMessageListener hnZ = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hBO) {
                NewSubPbActivity.this.hBD.aME();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hny.i(NewSubPbActivity.this.hnx.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.hnx.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.oW(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bJZ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ap.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.hnx.getResources().getString(d.j.mute_fail);
                    }
                    NewSubPbActivity.this.hny.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hoa = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hBO) {
                NewSubPbActivity.this.hBD.aME();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hny.i(NewSubPbActivity.this.hnx.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ap.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.hnx.getResources().getString(d.j.un_mute_fail);
                }
                NewSubPbActivity.this.hny.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hob = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hBO) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.hBD.aME();
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
                    NewSubPbActivity.this.hBD.a(sparseArray, z);
                }
            }
        }
    };
    boolean hok = false;
    private final b.InterfaceC0191b hom = new b.InterfaceC0191b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0191b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.hnB != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnC)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.hnD == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hnC));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.hnC;
                        aVar.pkgId = NewSubPbActivity.this.hnD.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hnD.memeInfo.pck_id;
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
                        NewSubPbActivity.this.fzS.h(NewSubPbActivity.this.hnC, NewSubPbActivity.this.hnB.oB());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.hnB = null;
                NewSubPbActivity.this.hnC = null;
            }
        }
    };
    private CustomMessageListener gcF = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
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
                    if (NewSubPbActivity.this.hBB.bOD() != null && NewSubPbActivity.this.hBB.bOD().bID() != null && NewSubPbActivity.this.hBB.bOD().bID().YR() != null && currentAccount.equals(NewSubPbActivity.this.hBB.bOD().bID().YR().getUserId()) && NewSubPbActivity.this.hBB.bOD().bID().YR().getPendantData() != null) {
                        NewSubPbActivity.this.hBB.bOD().bID().YR().getPendantData().lf(lVar.Xn());
                        NewSubPbActivity.this.hBB.bOD().bID().YR().getPendantData().aR(lVar.aly());
                        NewSubPbActivity.this.hBD.a(NewSubPbActivity.this.hBB.bOD().bID(), NewSubPbActivity.this.hBB.bOD().bvu(), NewSubPbActivity.this.hBB.bOD().Vb(), NewSubPbActivity.this.hBB.bIl(), NewSubPbActivity.this.hBB.bOP() != null);
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
        this.hnx = getPageContext();
        this.hBN = true;
        this.fPj = new com.baidu.tieba.write.b();
        this.fPj.AW(d.C0236d.cp_cont_h_alpha85);
        this.fPj.AV(d.C0236d.cp_btn_a);
        bgA();
        bOe();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bOd();
        this.hny = new com.baidu.tbadk.core.view.e();
        this.hny.bPN = 1000L;
        registerListener(this.hob);
        registerListener(this.hnZ);
        registerListener(this.hoa);
        this.hBO = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hBO;
        userMuteAddAndDelCustomMessage.setTag(this.hBO);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hBO;
        userMuteCheckCustomMessage.setTag(this.hBO);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.gyK = new aj(getPageContext());
        this.gyK.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.gyS.amM();
                }
            }
        });
        this.hna = new com.baidu.tieba.pb.pb.report.a(this);
        this.hna.p(getUniqueId());
        this.hnd = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    private void bOd() {
        if (this.hBD != null && this.hBB != null && this.hBB.bOg()) {
            this.hBQ = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.hBD.aDp());
            this.hBQ.bgF();
            this.hBQ.a(new a.InterfaceC0288a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
                private boolean fnq = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0288a
                public void bgB() {
                    NewSubPbActivity.this.hBD.jH(false);
                    this.fnq = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0288a
                public void bgC() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0288a
                public boolean bgD() {
                    if (!this.fnq) {
                        return NewSubPbActivity.this.hBD.bgR() != null && NewSubPbActivity.this.hBD.bgR().getTop() == 0;
                    }
                    this.fnq = false;
                    return false;
                }
            });
            this.hBD.e(this.hBQ);
            this.hBD.jH(true);
        }
    }

    public void initUI() {
        this.hBD = new b(this, this.mCommonClickListener);
        this.hBD.a(this.hBB);
        setContentView(this.hBD.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.hBD.setOnScrollListener(this.hBF);
        this.hBD.b(this);
        this.hBD.setOnLinkImageClickListener(this.hBG);
        this.hBD.setOnImageClickListener(this.hBH);
        this.hBD.nc(true);
        this.hBD.setOnLongClickListener(this.cdd);
        this.hBD.d(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.40
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.hBB != null) {
                    NewSubPbActivity.this.hBB.aov();
                }
            }
        });
        this.hBD.a(this.hBK);
        this.hBD.b(this.hBL);
        if (this.hBB != null && this.hBB.bOg() && !this.hBB.bOO()) {
            this.hBD.bOt().setVisibility(8);
        } else {
            this.hBD.bOt().setVisibility(0);
        }
        if (this.hBB != null && !this.hBB.bOg()) {
            this.hBD.setIsFromPb(false);
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
        this.hBB = new SubPbModel(getPageContext());
        this.hBB.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                NewSubPbActivity.this.hBD.p(postData);
                NewSubPbActivity.this.hBD.b((BdListView.e) null);
            }
        });
        this.hBC = new ForumManageModel(getPageContext());
        this.hBC.setLoadDataCallBack(this.hBJ);
        this.eYS = new VoiceManager();
        this.eYS.onCreate(getPageContext());
        this.hnb = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hnb != null) {
            this.hnb.a(this.hog);
        }
        if (bundle != null) {
            this.hBB.initWithBundle(bundle);
        } else {
            this.hBB.initWithIntent(getIntent());
        }
        this.hBB.a(this.hBI);
        if (this.hBB.bOg()) {
            this.hBB.aov();
        } else {
            this.hBB.bOI();
        }
    }

    public void bOe() {
        this.hBI = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, j jVar) {
                if (NewSubPbActivity.this.hBD != null) {
                    NewSubPbActivity.this.hBD.bOp();
                }
                if (NewSubPbActivity.this.hBQ != null && NewSubPbActivity.this.hBQ.bgG()) {
                    NewSubPbActivity.this.hBQ.qP(d.C0236d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.ax(i, str);
                    return;
                }
                NewSubPbActivity.this.hBD.hideNoDataView();
                if (jVar != null) {
                    if (jVar.bID() != null || NewSubPbActivity.this.hBB != null) {
                        jVar.bID().a(NewSubPbActivity.this.hBB.bON());
                    }
                    if (NewSubPbActivity.this.hBD != null) {
                        NewSubPbActivity.this.hBD.a(jVar, NewSubPbActivity.this.hBB.bIl(), NewSubPbActivity.this.hBB.bOP() != null);
                        if (NewSubPbActivity.this.hBN) {
                            NewSubPbActivity.this.bOf();
                            NewSubPbActivity.this.hBN = false;
                        }
                    }
                    if (NewSubPbActivity.this.gyS != null) {
                        NewSubPbActivity.this.gyS.a(jVar.bbI());
                    }
                    if (NewSubPbActivity.this.hBR == null) {
                        NewSubPbActivity.this.hBR = new com.baidu.tieba.pb.d();
                    }
                    NewSubPbActivity.this.hBR.setData(jVar);
                    NewSubPbActivity.this.hBR.setType(0);
                    NewSubPbActivity.this.gyK.a(NewSubPbActivity.this.hBB.bOS());
                }
            }
        };
        this.hog = new a.InterfaceC0187a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0187a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.hnb != null) {
                        NewSubPbActivity.this.hnb.cZ(z2);
                    }
                    MarkData Ve = NewSubPbActivity.this.hnb.Ve();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setType(2);
                    if (z2) {
                        dVar.setData(Ve);
                        if (NewSubPbActivity.this.hnb != null) {
                            if (Ve != null) {
                                NewSubPbActivity.this.hBB.on(true);
                                NewSubPbActivity.this.hBB.Ap(NewSubPbActivity.this.hBB.amp());
                                NewSubPbActivity.this.showToast(d.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.add_mark));
                            }
                            if (NewSubPbActivity.this.hBD != null) {
                                NewSubPbActivity.this.hBD.om(true);
                            }
                        }
                    } else {
                        dVar.setData(null);
                        NewSubPbActivity.this.hBB.on(false);
                        NewSubPbActivity.this.hBB.Ap(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.remove_mark));
                        if (NewSubPbActivity.this.hBD != null) {
                            NewSubPbActivity.this.hBD.om(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.update_mark_failed));
            }
        };
        this.hBK = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.hBB.bOD() != null && NewSubPbActivity.this.hBB.bOD().WR() != null && NewSubPbActivity.this.hBB.bOD().WR().YR() != null) {
                    str = String.valueOf(NewSubPbActivity.this.hBB.bOD().WR().YR().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.hBB.bOD().bIJ().getId(), NewSubPbActivity.this.hBB.bOD().bIJ().getName(), NewSubPbActivity.this.hBB.bOD().WR().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.hBL = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.hBC.cfc() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int l = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[1]), 0);
                        boolean e = com.baidu.adp.lib.g.b.e(String.valueOf(objArr[2]), false);
                        int l2 = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.hBB != null && NewSubPbActivity.this.hBB.bOD() != null && NewSubPbActivity.this.hBB.bOD().bIJ() != null && NewSubPbActivity.this.hBB.bOD().WR() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.hBC.CG(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.hBC.a(NewSubPbActivity.this.hBB.bOD().bIJ().getId(), NewSubPbActivity.this.hBB.bOD().bIJ().getName(), NewSubPbActivity.this.hBB.bOD().WR().getId(), valueOf, l2, l, e);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.hBJ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.hBD.a(NewSubPbActivity.this.hBC.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.hBC.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.hCM != 1002 || bVar.fDg) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.hBD.a(1, dVar.Id, dVar.iIJ, true);
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

    public void bgA() {
        registerListener(this.fak);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v63, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.hBD != null) {
                    if (view == NewSubPbActivity.this.hBD.bOz()) {
                        NewSubPbActivity.this.hBD.bMZ();
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
                    } else if (view != NewSubPbActivity.this.hBD.bgS()) {
                        if (view != NewSubPbActivity.this.hBD.bOs()) {
                            if (view != NewSubPbActivity.this.hBD.bOr()) {
                                if (view == NewSubPbActivity.this.hBD.bOn()) {
                                    NewSubPbActivity.this.hBD.bMZ();
                                    if (NewSubPbActivity.this.hBB.aov()) {
                                        NewSubPbActivity.this.hBD.bOl();
                                    }
                                } else if (view == NewSubPbActivity.this.hBD.bOt() || view == NewSubPbActivity.this.hBD.bOu() || view == NewSubPbActivity.this.hBD.bOw()) {
                                    if (NewSubPbActivity.this.hBP) {
                                        NewSubPbActivity.this.hBP = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.hBB.bKR(), NewSubPbActivity.this.hBB.amp(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.hBB.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.hBB.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.hBD.bOx() == null || view != NewSubPbActivity.this.hBD.bOx().bLH()) {
                                    if (NewSubPbActivity.this.hBD.bOx() == null || view != NewSubPbActivity.this.hBD.bOx().bLK()) {
                                        if (NewSubPbActivity.this.hBD.bOx() == null || view != NewSubPbActivity.this.hBD.bOx().bLI()) {
                                            if (NewSubPbActivity.this.hBD.bOx() == null || view != NewSubPbActivity.this.hBD.bOx().bLJ()) {
                                                if (NewSubPbActivity.this.hBD.bOx() == null || view != NewSubPbActivity.this.hBD.bOx().bLL()) {
                                                    if (view == NewSubPbActivity.this.hBD.bOq() || view == NewSubPbActivity.this.hBD.bOw()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.gyS.amP()) {
                                                                NewSubPbActivity.this.gyS.amQ();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.gyS.oX(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof com.baidu.tieba.pb.pb.main.j)) {
                                                        if (NewSubPbActivity.this.hBE == null || view != NewSubPbActivity.this.hBE.bLJ()) {
                                                            if (NewSubPbActivity.this.hBE == null || view != NewSubPbActivity.this.hBE.bLH()) {
                                                                if (NewSubPbActivity.this.hBE == null || view != NewSubPbActivity.this.hBE.bLK()) {
                                                                    if (NewSubPbActivity.this.hBE == null || view != NewSubPbActivity.this.hBE.bLL()) {
                                                                        if (NewSubPbActivity.this.hBE == null || view != NewSubPbActivity.this.hBE.bLN()) {
                                                                            if (NewSubPbActivity.this.hBE == null || view != NewSubPbActivity.this.hBE.bLO()) {
                                                                                if (NewSubPbActivity.this.hBE != null && view == NewSubPbActivity.this.hBE.bLI()) {
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
                                                                                            NewSubPbActivity.this.hBD.cs(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.hBD.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
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
                                                                                        if (postData.getType() != PostData.iGk && !TextUtils.isEmpty(postData.getBimg_url()) && i.Wy().WC()) {
                                                                                            NewSubPbActivity.this.Am(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.hnB != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnC)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.adQ();
                                                                                NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.Y(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.fzS == null) {
                                                                                        NewSubPbActivity.this.fzS = new au(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.fzS.h(NewSubPbActivity.this.hnC, NewSubPbActivity.this.hnB.oB());
                                                                                    NewSubPbActivity.this.hnB = null;
                                                                                    NewSubPbActivity.this.hnC = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.hnB != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnC)) {
                                                                            if (NewSubPbActivity.this.hnD == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hnC));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.hnC;
                                                                                aVar.pkgId = NewSubPbActivity.this.hnD.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hnD.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.hnB = null;
                                                                            NewSubPbActivity.this.hnC = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.fPQ != null) {
                                                                        NewSubPbActivity.this.fPQ.ev(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.fPQ = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                if (sparseArray2 != null && (sparseArray2.get(d.g.tag_del_post_type) instanceof Integer) && (sparseArray2.get(d.g.tag_del_post_id) instanceof String) && (sparseArray2.get(d.g.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(d.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.hBD.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
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
                                                                NewSubPbActivity.this.zM((String) tag);
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
                                                        NewSubPbActivity.this.hBT = (com.baidu.tieba.pb.pb.main.j) view.getTag();
                                                        if (bc.cZ(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.hBP) {
                                                                NewSubPbActivity.this.hBP = false;
                                                                return;
                                                            } else if (NewSubPbActivity.this.gyK == null || NewSubPbActivity.this.hBB == null || NewSubPbActivity.this.hBB.bbI() == null || NewSubPbActivity.this.gyK.hm(NewSubPbActivity.this.hBB.bbI().replyPrivateFlag)) {
                                                                if (NewSubPbActivity.this.hBQ != null) {
                                                                    NewSubPbActivity.this.hBQ.bgE();
                                                                }
                                                                SparseArray sparseArray4 = (SparseArray) view.getTag(d.g.tag_from);
                                                                if (sparseArray4 != null) {
                                                                    if (sparseArray4.get(d.g.tag_clip_board) instanceof PostData) {
                                                                        PostData postData2 = (PostData) sparseArray4.get(d.g.tag_clip_board);
                                                                        if (postData2 != null && postData2.YR() != null) {
                                                                            MetaData YR = postData2.YR();
                                                                            NewSubPbActivity.this.gyS.setReplyId(YR.getUserId());
                                                                            if (!(sparseArray4.get(d.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray4.get(d.g.tag_is_subpb)).booleanValue() : true)) {
                                                                                NewSubPbActivity.this.gyS.oY("");
                                                                            } else {
                                                                                NewSubPbActivity.this.gyS.oY(YR.getName_show());
                                                                            }
                                                                        }
                                                                        NewSubPbActivity.this.hBD.bOj();
                                                                    }
                                                                    if (NewSubPbActivity.this.hBS) {
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
                                            NewSubPbActivity.this.hBD.bMZ();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.zM(str4);
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
                                            NewSubPbActivity.this.hBD.bMZ();
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
                                    NewSubPbActivity.this.hBD.bMZ();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.hBD.a(((Integer) sparseArray7.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray7.get(d.g.tag_del_post_id), ((Integer) sparseArray7.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(d.g.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new am("c11739").T("obj_locate", 2));
                                    NewSubPbActivity.this.hBD.bMZ();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.hBB.bOD() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.hBB.bOD().bID());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.hBD.bOi();
                                NewSubPbActivity.this.hBD.bOj();
                                if (NewSubPbActivity.this.gyS != null) {
                                    NewSubPbActivity.this.gyS.amS();
                                    if (NewSubPbActivity.this.hBQ != null) {
                                        NewSubPbActivity.this.hBQ.bgE();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.hBD.bOi();
                            NewSubPbActivity.this.hBD.bOj();
                            if (NewSubPbActivity.this.gyS != null) {
                                NewSubPbActivity.this.gyS.amR();
                                if (NewSubPbActivity.this.hBQ != null) {
                                    NewSubPbActivity.this.hBQ.bgE();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.bJv();
                        if (NewSubPbActivity.this.hBB != null && NewSubPbActivity.this.hBB.bOD() != null && NewSubPbActivity.this.hBB.bOD().WR() != null && NewSubPbActivity.this.hBB.bOD().WR().YR() != null) {
                            TiebaStatic.log(new am("c13402").bJ("tid", NewSubPbActivity.this.hBB.bKR()).k(ImageViewerConfig.FORUM_ID, NewSubPbActivity.this.hBB.bOD().WR().getFid()).T("obj_locate", 5).bJ("uid", NewSubPbActivity.this.hBB.bOD().WR().YR().getUserId()));
                        }
                    }
                }
            }
        };
        this.hBF = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.hBD.bMZ();
                }
                NewSubPbActivity.this.gyS.amQ();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.hBD.bOy();
            }
        };
        this.hol = new b.InterfaceC0191b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0191b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.hBB.bOD() != null) {
                    postData = NewSubPbActivity.this.hBB.bOD().bID();
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
                        NewSubPbActivity.this.hnB = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.hnC = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.hnB != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnC)) {
                            if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hnD = null;
                            } else {
                                NewSubPbActivity.this.hnD = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                NewSubPbActivity.this.hBD.a(NewSubPbActivity.this.hom, NewSubPbActivity.this.hnB.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                NewSubPbActivity.this.fPQ = (PostData) sparseArray2.get(d.g.tag_clip_board);
                                if (NewSubPbActivity.this.fPQ != null && NewSubPbActivity.this.hnb != null) {
                                    if (NewSubPbActivity.this.hnb != null) {
                                        NewSubPbActivity.this.hnb.cZ(NewSubPbActivity.this.hBB.isMarked());
                                    }
                                    boolean z = NewSubPbActivity.this.hnb.Vb() && NewSubPbActivity.this.fPQ.getId() != null && NewSubPbActivity.this.fPQ.getId().equals(NewSubPbActivity.this.hBB.bOK());
                                    if (NewSubPbActivity.this.hBE == null) {
                                        NewSubPbActivity.this.hBE = new y(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.mCommonClickListener);
                                        NewSubPbActivity.this.hBD.cw(NewSubPbActivity.this.hBE.getView());
                                        NewSubPbActivity.this.hBE.nC(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.hBE.showDialog();
                                    boolean isLogin = NewSubPbActivity.this.isLogin() & NewSubPbActivity.this.nj(sparseArray2.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue() : false);
                                    boolean booleanValue = sparseArray2.get(d.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(d.g.tag_is_subpb)).booleanValue() : false;
                                    if (z) {
                                        NewSubPbActivity.this.hBE.bLH().setText(d.j.remove_mark);
                                    } else {
                                        NewSubPbActivity.this.hBE.bLH().setText(d.j.mark);
                                    }
                                    if (booleanValue) {
                                        NewSubPbActivity.this.hBE.bLH().setVisibility(8);
                                    } else {
                                        NewSubPbActivity.this.hBE.bLH().setVisibility(0);
                                    }
                                    if (NewSubPbActivity.this.cm(view)) {
                                        if (NewSubPbActivity.this.hnB != null && !NewSubPbActivity.this.hnB.isGif()) {
                                            sparseArray2.put(d.g.tag_richtext_image, true);
                                        } else {
                                            sparseArray2.put(d.g.tag_richtext_image, false);
                                        }
                                        sparseArray2.put(d.g.tag_richtext_emotion, true);
                                    } else {
                                        sparseArray2.put(d.g.tag_richtext_image, false);
                                        sparseArray2.put(d.g.tag_richtext_emotion, false);
                                    }
                                    NewSubPbActivity.this.hBE.a(sparseArray2, NewSubPbActivity.this.bIl(), isLogin);
                                }
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            NewSubPbActivity.this.hnB = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                NewSubPbActivity.this.hnC = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hnD = null;
                            } else {
                                NewSubPbActivity.this.hnD = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.hnB = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.hnC = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.hnD = null;
                        } else {
                            NewSubPbActivity.this.hnD = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
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
        this.hBG = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void f(View view, String str) {
                NewSubPbActivity.this.o(null, str, "LINK_IMAGE");
            }
        };
        this.hBH = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                        j bOD = NewSubPbActivity.this.hBB.bOD();
                        TbRichText bh = NewSubPbActivity.this.bh(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bh != null && bh.asw() != null) {
                            tbRichTextData = bh.asw().get(NewSubPbActivity.this.hoj);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.asD().asP()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (bOD == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (bOD.bIJ() != null) {
                                        str4 = bOD.bIJ().getName();
                                        str5 = bOD.bIJ().getId();
                                    }
                                    if (bOD.WR() != null) {
                                        str6 = bOD.WR().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.hBB.bOP() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.hBB.bOP();
                                    z6 = NewSubPbActivity.this.hBB.bOR();
                                    arrayList2 = NewSubPbActivity.this.hBB.bOQ();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.c(arrayList2, 0));
                                NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                                return;
                            }
                            NewSubPbActivity.this.hok = false;
                            String str7 = "";
                            TbRichText ces = bOD.bID().ces();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(ces, bh, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (bOD == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (bOD.bIJ() != null) {
                                    str8 = bOD.bIJ().getName();
                                    str9 = bOD.bIJ().getId();
                                }
                                if (bOD.WR() != null) {
                                    str10 = bOD.WR().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.hBB.bOP() != null) {
                                concurrentHashMap = NewSubPbActivity.this.hBB.bOP();
                                z4 = NewSubPbActivity.this.hBB.bOR();
                                arrayList = NewSubPbActivity.this.hBB.bOQ();
                                i2 = a2 + NewSubPbActivity.this.hBB.getOffset();
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
        TbRichTextImageInfo asD;
        if (tbRichText == tbRichText2) {
            this.hok = true;
        }
        if (tbRichText != null && tbRichText.asw() != null) {
            int size = tbRichText.asw().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.asw().get(i6) != null && tbRichText.asw().get(i6).getType() == 8) {
                    i5++;
                    int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                    int width = tbRichText.asw().get(i6).asD().getWidth() * aR;
                    int height = tbRichText.asw().get(i6).asD().getHeight() * aR;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.asw().get(i6).asD().asP()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.asw().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (asD = tbRichTextData.asD()) != null) {
                            String asR = asD.asR();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = asR;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.hok) {
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
        if (this.hBE != null) {
            this.hBE.nC(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo asD = tbRichTextData.asD();
        if (asD != null) {
            if (!StringUtils.isNull(asD.asO())) {
                return asD.asO();
            }
            if (asD.getHeight() * asD.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (asD.getHeight() * asD.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (asD.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * asD.getHeight())));
            } else {
                float width = asD.getWidth() / asD.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ap.bx(asD.Nx()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bh(String str, int i) {
        if (this.hBB == null || this.hBB.bOD() == null || str == null || i < 0) {
            return null;
        }
        j bOD = this.hBB.bOD();
        TbRichText a2 = a(bOD.bID(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bOD.bID(), str, i);
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
        TbRichText ces = postData.ces();
        if (ces != null) {
            ArrayList<TbRichTextData> asw = ces.asw();
            int size = asw.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (asw.get(i3) != null && asw.get(i3).getType() == 8) {
                    i2++;
                    if (asw.get(i3).asD().asR().equals(str)) {
                        int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                        int width = asw.get(i3).asD().getWidth() * aR;
                        int height = asw.get(i3).asD().getHeight() * aR;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.hoj = i3;
                        return ces;
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
    public void bJv() {
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
                        if (NewSubPbActivity.this.gyK == null || NewSubPbActivity.this.hBB == null || NewSubPbActivity.this.hBB.bbI() == null || NewSubPbActivity.this.gyK.hm(NewSubPbActivity.this.hBB.bbI().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.gyS.amH()) {
                                NewSubPbActivity.this.gyS.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.hBD.bOi();
                            NewSubPbActivity.this.hBD.bOj();
                            if (NewSubPbActivity.this.gyS != null) {
                                NewSubPbActivity.this.gyS.amT();
                                if (NewSubPbActivity.this.hBQ != null) {
                                    NewSubPbActivity.this.hBQ.bgE();
                                }
                            }
                        }
                    }
                }
            });
        }
        if (this.hBB != null && this.hBB.bOD() != null && this.hBB.bOD().bIJ() != null) {
            this.fcw.q(this.hBB.bOD().bIJ().getId(), com.baidu.adp.lib.g.b.d(this.hBB.bKR(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nj(boolean z) {
        if (this.hBB == null) {
            return false;
        }
        return ((bIl() != 0) || this.hBB.bOD() == null || this.hBB.bOD().WR() == null || this.hBB.bOD().WR().YR() == null || TextUtils.equals(this.hBB.bOD().WR().YR().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Context context, String str, String str2) {
        long templateId = this.hBB.bOD().bID().cez() != null ? this.hBB.bOD().bID().cez().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ba.adD().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.hBB.bOD().bIJ().getId(), this.hBB.bOD().bIJ().getName(), this.hBB.bOD().WR().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(int i, String str) {
        if (this.hBB.bOE()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.lo()) {
            if (i == 4) {
                this.hBD.vl(str + "(4)");
            } else {
                this.hBD.nS(d.j.no_data_text);
            }
        } else {
            this.hBD.nS(d.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.gyS = (g) new h().dd(getActivity());
        if (this.gyS != null) {
            this.gyS.a(getPageContext());
            this.gyS.b(this.hBB);
            this.gyS.b(this.fPp);
            this.gyS.a(this.ckl);
            this.gyS.a(this.ckm);
            this.gyS.alT().eH(true);
            this.gyS.e(getPageContext());
        }
        if (this.hBD != null) {
            this.hBD.g(this.gyS);
        }
        if (this.gyS != null && this.hBB != null) {
            this.gyS.a(this.hBB.bbI());
            this.gyS.amQ();
        }
        if (this.gyS != null) {
            this.gyS.amU().setDefaultHint(bMr());
            this.gyS.amU().setHint(bMr());
            this.fPk = this.gyS.amU().getInputView();
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
                        if (!NewSubPbActivity.this.fPj.cnO()) {
                            NewSubPbActivity.this.kt(false);
                        }
                        NewSubPbActivity.this.fPj.qV(false);
                    }
                }
            });
        }
    }

    public void bOf() {
        if (!TbadkCoreApplication.isLogin()) {
            this.gyS.amQ();
        } else if (!StringUtils.isNull(this.hBB.bOL())) {
            if (this.hBD.bOm() && com.baidu.adp.lib.util.l.lo()) {
                this.hBD.aYV();
            } else {
                this.hBD.bOp();
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
                    this.hBD.cs(view);
                }
            } else if (booleanValue2) {
                this.hBD.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.hBD.bOv(), getPageContext().getPageActivity());
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.hBO);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.hBO);
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
        this.hBD.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.hBO;
        userMuteCheckCustomMessage.setTag(this.hBO);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.hBD.a(0, bVar.Id, bVar.iIJ, z);
            if (bVar.Id) {
                if (bVar.eFR == 1) {
                    if (this.hBD.getListView() instanceof BdTypeListView) {
                        List<m> data = ((BdTypeListView) this.hBD.getListView()).getData();
                        if (!v.T(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            data.remove(i);
                            this.hBD.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.eFR == 2) {
                    this.hBB.Ao(bVar.mPostId);
                    this.hBD.a(this.hBB.bOD(), this.hBB.bIl(), this.hBB.bOP() != null);
                    if (this.hBB.bOM()) {
                        this.hBB.oo(false);
                        this.hBD.bOk();
                        this.hBB.aov();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
            }
        }
    }

    public void zM(String str) {
        this.hna.Ak(str);
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.hBB.isMarked() && postData.getId() != null && postData.getId().equals(this.hBB.bOK())) {
                z = true;
            }
            MarkData j = this.hBB.j(postData);
            if (j != null) {
                this.hBD.bMZ();
                if (this.hnb != null) {
                    this.hnb.a(j);
                    if (!z) {
                        this.hnb.Vd();
                    } else {
                        this.hnb.Vc();
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
        if (bundle != null && this.hBB != null) {
            this.hBB.aa(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.gyS != null) {
            this.gyS.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.gyS.alT().akq();
        this.gyS.amQ();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gyS.b(writeData);
                this.gyS.setVoiceModel(pbEditorData.getVoiceModel());
                k jw = this.gyS.alT().jw(6);
                if (jw != null && jw.ciu != null) {
                    jw.ciu.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gyS.amM();
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
        this.hBM = true;
        super.onPause();
        if (this.eYS != null) {
            this.eYS.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.gcF);
        this.hBD.biQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.hBM = false;
        super.onResume();
        if (this.eYS != null) {
            this.eYS.onResume(getPageContext());
        }
        registerListener(this.gcF);
        this.hBD.biR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eYS != null) {
            this.eYS.onStop(getPageContext());
        }
        this.gyS.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.hBR));
        this.hBB.cancelLoadData();
        this.hBB.destory();
        this.hBC.cancelLoadData();
        if (this.eYS != null) {
            this.eYS.onDestory(getPageContext());
        }
        this.hBD.bMZ();
        this.hBD.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.hnZ);
        MessageManager.getInstance().unRegisterListener(this.hoa);
        MessageManager.getInstance().unRegisterListener(this.hob);
        MessageManager.getInstance().unRegisterListener(this.hBO);
        this.hnx = null;
        this.hny = null;
        if (this.gyK != null) {
            this.gyK.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hBD.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.eYS;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bOq = this.hBD.bOq();
        if (bOq == null || (findViewWithTag = bOq.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Ad(String str) {
        Map<String, String> mN;
        if (!TextUtils.isEmpty(str) && (mN = ba.mN(ba.mO(str))) != null) {
            this.hBP = true;
            String str2 = mN.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Ad(com.baidu.adp.lib.util.k.by(str2));
            }
            String str3 = mN.get(hBA);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (Ad(str)) {
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
            this.hBP = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void az(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hBP = true;
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
        if (this.hBD != null) {
            return this.hBD.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int atd() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> atf() {
        if (this.cDk == null) {
            this.cDk = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cDk;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> atg() {
        if (this.cAw == null) {
            this.cAw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bKf */
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
    public com.baidu.adp.lib.e.b<ImageView> ate() {
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
    public com.baidu.adp.lib.e.b<View> ath() {
        if (this.cDl == null) {
            this.cDl = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bKg */
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
    public com.baidu.adp.lib.e.b<LinearLayout> ati() {
        if (this.cDm == null) {
            this.cDm = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bKi */
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
    public com.baidu.adp.lib.e.b<RelativeLayout> atj() {
        this.cDn = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bKh */
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
    public com.baidu.tieba.pb.pb.main.b.a bIP() {
        return this.hnd;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bIQ() {
        return (this.hBB == null || this.hBB.bOD() == null || this.hBB.bOD().WR() == null || this.hBB.bOD().WR().aaj()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bIR() {
        if (this.hBB == null || this.hBB.bOD() == null || this.hBB.bOD().WR() == null) {
            return null;
        }
        return this.hBB.bOD().WR().YW();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bIS() {
        if (this.hBB == null) {
            return 0;
        }
        return this.hBB.bIl();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean zJ(String str) {
        if (StringUtils.isNull(str) || this.hBB == null || this.hBB.bOD() == null || this.hBB.bOD().WR() == null || this.hBB.bOD().WR().YR() == null) {
            return false;
        }
        return str.equals(this.hBB.bOD().WR().YR().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hBD.bOm() && com.baidu.adp.lib.util.l.lo()) {
            this.hBB.aov();
        } else {
            this.hBD.bOp();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.hBO);
        userMuteAddAndDelCustomMessage.setTag(this.hBO);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Am(String str) {
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
        if (pageStayDurationItem != null && this.hBB != null) {
            if (this.hBB.bOD() != null && this.hBB.bOD().bIJ() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.hBB.bOD().bIJ().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.hBB.bKR(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.hBM;
    }

    public boolean bOg() {
        if (this.hBB != null) {
            return this.hBB.bOg();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hBD.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hnx.getPageActivity());
        if (ap.isEmpty(str)) {
            aVar.ly(this.hnx.getResources().getString(d.j.block_mute_message_alert, str3));
        } else {
            aVar.ly(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.hBD.showLoadingDialog();
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
        aVar.b(this.hnx).aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oW(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hnx.getPageActivity());
        aVar.ly(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hnx).aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ly(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.hnx).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.hnx.getPageActivity(), 2, true, 4);
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
        aVar.b(this.hnx).aaZ();
    }

    public SubPbModel bOh() {
        return this.hBB;
    }

    public int bIl() {
        if (this.hBB != null) {
            return this.hBB.bIl();
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
                if (z && this.fPj.cnM() >= 0) {
                    this.fPk.requestFocus();
                    this.fPk.setSelection(this.fPj.cnM());
                } else {
                    this.fPk.setSelection(selectionEnd);
                }
                this.fPj.qU(this.fPj.cnM() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gyS != null && this.gyS.alT() != null && this.gyS.alT().alW()) {
            this.gyS.alT().akq();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    public String bMr() {
        if (!ap.isEmpty(this.hyf)) {
            return this.hyf;
        }
        this.hyf = getResources().getString(com.baidu.tieba.pb.pb.main.ap.bMj());
        return this.hyf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.hBS = z;
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
        if (this.hBD != null && this.hBD.getListView() != null && this.hBT != null && this.hBT.mPosition != -1) {
            final int headerViewsCount = this.hBT.mPosition + this.hBD.getListView().getHeaderViewsCount();
            if (this.hBT.getView() != null) {
                final int height = this.hBT.getView().getHeight() - ((rect.height() - this.hBD.getNavigationBarHeight()) - this.hBD.bOA());
                if (height > 0) {
                    this.hBD.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.hBD != null && NewSubPbActivity.this.hBD.getListView() != null) {
                                NewSubPbActivity.this.hBD.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.hBD.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.hBD.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.hBD != null && NewSubPbActivity.this.hBD.getListView() != null) {
                                NewSubPbActivity.this.hBD.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.hBD.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }
}
