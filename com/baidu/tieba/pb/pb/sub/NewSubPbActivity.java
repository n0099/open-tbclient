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
    private static final String hAd = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String hBv = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> cAs;
    private com.baidu.adp.lib.e.b<GifView> cAt;
    private com.baidu.adp.lib.e.b<TextView> cDh;
    private com.baidu.adp.lib.e.b<View> cDi;
    private com.baidu.adp.lib.e.b<LinearLayout> cDj;
    private com.baidu.adp.lib.e.b<RelativeLayout> cDk;
    private View.OnLongClickListener cdd;
    private VoiceManager eYR;
    private com.baidu.tieba.write.b fPi;
    private EditText fPj;
    private com.baidu.tieba.frs.profession.permission.c fcv;
    private au fzR;
    public aj gyK;
    private g gyS;
    private AbsListView.OnScrollListener hBA;
    private TbRichTextView.i hBB;
    private TbRichTextView.h hBC;
    private SubPbModel.a hBD;
    private com.baidu.adp.base.d hBE;
    private BdUniqueId hBJ;
    private com.baidu.tieba.pb.pb.sub.a hBL;
    private com.baidu.tieba.pb.d<j> hBM;
    private boolean hBN;
    private com.baidu.tieba.pb.pb.main.j hBO;
    private SubPbModel hBw;
    private ForumManageModel hBx;
    private b hBy;
    private y hBz;
    private com.baidu.tieba.pb.pb.report.a hmU;
    private com.baidu.tbadk.baseEditMark.a hmV;
    private com.baidu.tieba.pb.pb.main.b.a hmX;
    private com.baidu.adp.base.e hnr;
    private com.baidu.tbadk.core.view.e hns;
    private com.baidu.adp.widget.ImageView.a hnv;
    private String hnw;
    private TbRichTextMemeInfo hnx;
    private b.InterfaceC0225b hof;
    private PostWriteCallBackData hrz;
    private String hya;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int hod = 0;
    PostData fPQ = null;
    private a.InterfaceC0221a hoa = null;
    private a hBF = null;
    private a hBG = null;
    private boolean hBH = false;
    private boolean hBI = false;
    private boolean hBK = false;
    private boolean ciS = false;
    private com.baidu.tbadk.editortools.pb.c ckl = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void amr() {
            NewSubPbActivity.this.hBy.bOp();
        }
    };
    private com.baidu.tbadk.editortools.pb.b ckm = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean amq() {
            if (!NewSubPbActivity.this.fPi.coa()) {
                return (NewSubPbActivity.this.gyK == null || NewSubPbActivity.this.hBw == null || NewSubPbActivity.this.hBw.bbI() == null || NewSubPbActivity.this.gyK.S(NewSubPbActivity.this.hBw.bbI().replyPrivateFlag, aj.bKu)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.fPi.coc());
            if (NewSubPbActivity.this.gyS.amG()) {
                NewSubPbActivity.this.gyS.a(NewSubPbActivity.this.hrz);
            }
            NewSubPbActivity.this.kt(true);
            return true;
        }
    };
    private NewWriteModel.d fPp = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.gyS != null && NewSubPbActivity.this.gyS.alS() != null) {
                NewSubPbActivity.this.gyS.alS().hide();
                if (NewSubPbActivity.this.hBw.bOK()) {
                    TiebaStatic.log(new am("c10367").bJ("post_id", NewSubPbActivity.this.hBw.amo()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fPi.Ej(null);
                NewSubPbActivity.this.fPi.aE(null);
                NewSubPbActivity.this.fPi.qU(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fPi.aE(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fPi.Ej(postWriteCallBackData.getErrorString());
                if (!v.T(NewSubPbActivity.this.fPi.cnY())) {
                    NewSubPbActivity.this.hrz = postWriteCallBackData;
                    if (NewSubPbActivity.this.gyS.amG()) {
                        NewSubPbActivity.this.gyS.a(NewSubPbActivity.this.hrz);
                    }
                    NewSubPbActivity.this.kt(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.gyK != null) {
                NewSubPbActivity.this.gyK.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.hBy.bOq();
        }
    };
    private CustomMessageListener hnT = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hBJ) {
                NewSubPbActivity.this.hBy.aME();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hns.i(NewSubPbActivity.this.hnr.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.hnr.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.oW(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bJZ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ap.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.hnr.getResources().getString(d.j.mute_fail);
                    }
                    NewSubPbActivity.this.hns.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hnU = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hBJ) {
                NewSubPbActivity.this.hBy.aME();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hns.i(NewSubPbActivity.this.hnr.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ap.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.hnr.getResources().getString(d.j.un_mute_fail);
                }
                NewSubPbActivity.this.hns.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hnV = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.hBJ) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.hBy.aME();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.iUp;
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
                    NewSubPbActivity.this.hBy.a(sparseArray, z);
                }
            }
        }
    };
    boolean hoe = false;
    private final b.InterfaceC0225b hog = new b.InterfaceC0225b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.hnv != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnw)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.hnx == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hnw));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.hnw;
                        aVar.pkgId = NewSubPbActivity.this.hnx.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hnx.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.adQ();
                    NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.Y(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.fzR == null) {
                            NewSubPbActivity.this.fzR = new au(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.fzR.h(NewSubPbActivity.this.hnw, NewSubPbActivity.this.hnv.oB());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.hnv = null;
                NewSubPbActivity.this.hnw = null;
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
    CustomMessageListener faj = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    l lVar = (l) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.hBw.bOE() != null && NewSubPbActivity.this.hBw.bOE().bID() != null && NewSubPbActivity.this.hBw.bOE().bID().YR() != null && currentAccount.equals(NewSubPbActivity.this.hBw.bOE().bID().YR().getUserId()) && NewSubPbActivity.this.hBw.bOE().bID().YR().getPendantData() != null) {
                        NewSubPbActivity.this.hBw.bOE().bID().YR().getPendantData().lf(lVar.Xn());
                        NewSubPbActivity.this.hBw.bOE().bID().YR().getPendantData().aR(lVar.alx());
                        NewSubPbActivity.this.hBy.a(NewSubPbActivity.this.hBw.bOE().bID(), NewSubPbActivity.this.hBw.bOE().bvu(), NewSubPbActivity.this.hBw.bOE().Vb(), NewSubPbActivity.this.hBw.bIl(), NewSubPbActivity.this.hBw.bOQ() != null);
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
        this.hnr = getPageContext();
        this.hBI = true;
        this.fPi = new com.baidu.tieba.write.b();
        this.fPi.AX(d.C0277d.cp_cont_h_alpha85);
        this.fPi.AW(d.C0277d.cp_btn_a);
        bgA();
        bOf();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bOe();
        this.hns = new com.baidu.tbadk.core.view.e();
        this.hns.bPO = 1000L;
        registerListener(this.hnV);
        registerListener(this.hnT);
        registerListener(this.hnU);
        this.hBJ = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hBJ;
        userMuteAddAndDelCustomMessage.setTag(this.hBJ);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hBJ;
        userMuteCheckCustomMessage.setTag(this.hBJ);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.gyK = new aj(getPageContext());
        this.gyK.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.gyS.amL();
                }
            }
        });
        this.hmU = new com.baidu.tieba.pb.pb.report.a(this);
        this.hmU.p(getUniqueId());
        this.hmX = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    private void bOe() {
        if (this.hBy != null && this.hBw != null && this.hBw.bOh()) {
            this.hBL = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.hBy.aDp());
            this.hBL.bgF();
            this.hBL.a(new a.InterfaceC0361a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
                private boolean fnp = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0361a
                public void bgB() {
                    NewSubPbActivity.this.hBy.jH(false);
                    this.fnp = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0361a
                public void bgC() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0361a
                public boolean bgD() {
                    if (!this.fnp) {
                        return NewSubPbActivity.this.hBy.bgR() != null && NewSubPbActivity.this.hBy.bgR().getTop() == 0;
                    }
                    this.fnp = false;
                    return false;
                }
            });
            this.hBy.e(this.hBL);
            this.hBy.jH(true);
        }
    }

    public void initUI() {
        this.hBy = new b(this, this.mCommonClickListener);
        this.hBy.a(this.hBw);
        setContentView(this.hBy.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.hBy.setOnScrollListener(this.hBA);
        this.hBy.b(this);
        this.hBy.setOnLinkImageClickListener(this.hBB);
        this.hBy.setOnImageClickListener(this.hBC);
        this.hBy.nc(true);
        this.hBy.setOnLongClickListener(this.cdd);
        this.hBy.d(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.40
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.hBw != null) {
                    NewSubPbActivity.this.hBw.aou();
                }
            }
        });
        this.hBy.a(this.hBF);
        this.hBy.b(this.hBG);
        if (this.hBw != null && this.hBw.bOh() && !this.hBw.bOP()) {
            this.hBy.bOu().setVisibility(8);
        } else {
            this.hBy.bOu().setVisibility(0);
        }
        if (this.hBw != null && !this.hBw.bOh()) {
            this.hBy.setIsFromPb(false);
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
        this.hBw = new SubPbModel(getPageContext());
        this.hBw.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                NewSubPbActivity.this.hBy.p(postData);
                NewSubPbActivity.this.hBy.b((BdListView.e) null);
            }
        });
        this.hBx = new ForumManageModel(getPageContext());
        this.hBx.setLoadDataCallBack(this.hBE);
        this.eYR = new VoiceManager();
        this.eYR.onCreate(getPageContext());
        this.hmV = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hmV != null) {
            this.hmV.a(this.hoa);
        }
        if (bundle != null) {
            this.hBw.initWithBundle(bundle);
        } else {
            this.hBw.initWithIntent(getIntent());
        }
        this.hBw.a(this.hBD);
        if (this.hBw.bOh()) {
            this.hBw.aou();
        } else {
            this.hBw.bOJ();
        }
    }

    public void bOf() {
        this.hBD = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, j jVar) {
                if (NewSubPbActivity.this.hBy != null) {
                    NewSubPbActivity.this.hBy.bOq();
                }
                if (NewSubPbActivity.this.hBL != null && NewSubPbActivity.this.hBL.bgG()) {
                    NewSubPbActivity.this.hBL.qP(d.C0277d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.ax(i, str);
                    return;
                }
                NewSubPbActivity.this.hBy.hideNoDataView();
                if (jVar != null) {
                    if (jVar.bID() != null || NewSubPbActivity.this.hBw != null) {
                        jVar.bID().a(NewSubPbActivity.this.hBw.bOO());
                    }
                    if (NewSubPbActivity.this.hBy != null) {
                        NewSubPbActivity.this.hBy.a(jVar, NewSubPbActivity.this.hBw.bIl(), NewSubPbActivity.this.hBw.bOQ() != null);
                        if (NewSubPbActivity.this.hBI) {
                            NewSubPbActivity.this.bOg();
                            NewSubPbActivity.this.hBI = false;
                        }
                    }
                    if (NewSubPbActivity.this.gyS != null) {
                        NewSubPbActivity.this.gyS.a(jVar.bbI());
                    }
                    if (NewSubPbActivity.this.hBM == null) {
                        NewSubPbActivity.this.hBM = new com.baidu.tieba.pb.d();
                    }
                    NewSubPbActivity.this.hBM.setData(jVar);
                    NewSubPbActivity.this.hBM.setType(0);
                    NewSubPbActivity.this.gyK.a(NewSubPbActivity.this.hBw.bOT());
                }
            }
        };
        this.hoa = new a.InterfaceC0221a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0221a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.hmV != null) {
                        NewSubPbActivity.this.hmV.cZ(z2);
                    }
                    MarkData Ve = NewSubPbActivity.this.hmV.Ve();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setType(2);
                    if (z2) {
                        dVar.setData(Ve);
                        if (NewSubPbActivity.this.hmV != null) {
                            if (Ve != null) {
                                NewSubPbActivity.this.hBw.on(true);
                                NewSubPbActivity.this.hBw.Ao(NewSubPbActivity.this.hBw.amo());
                                NewSubPbActivity.this.showToast(d.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.add_mark));
                            }
                            if (NewSubPbActivity.this.hBy != null) {
                                NewSubPbActivity.this.hBy.om(true);
                            }
                        }
                    } else {
                        dVar.setData(null);
                        NewSubPbActivity.this.hBw.on(false);
                        NewSubPbActivity.this.hBw.Ao(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.remove_mark));
                        if (NewSubPbActivity.this.hBy != null) {
                            NewSubPbActivity.this.hBy.om(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.update_mark_failed));
            }
        };
        this.hBF = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.hBw.bOE() != null && NewSubPbActivity.this.hBw.bOE().WR() != null && NewSubPbActivity.this.hBw.bOE().WR().YR() != null) {
                    str = String.valueOf(NewSubPbActivity.this.hBw.bOE().WR().YR().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.hBw.bOE().bIJ().getId(), NewSubPbActivity.this.hBw.bOE().bIJ().getName(), NewSubPbActivity.this.hBw.bOE().WR().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.hBG = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.hBx.cff() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int l = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[1]), 0);
                        boolean e = com.baidu.adp.lib.g.b.e(String.valueOf(objArr[2]), false);
                        int l2 = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.hBw != null && NewSubPbActivity.this.hBw.bOE() != null && NewSubPbActivity.this.hBw.bOE().bIJ() != null && NewSubPbActivity.this.hBw.bOE().WR() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.hBx.CF(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.hBx.a(NewSubPbActivity.this.hBw.bOE().bIJ().getId(), NewSubPbActivity.this.hBw.bOE().bIJ().getName(), NewSubPbActivity.this.hBw.bOE().WR().getId(), valueOf, l2, l, e);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.hBE = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.hBy.a(NewSubPbActivity.this.hBx.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.hBx.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.hCH != 1002 || bVar.fDf) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.hBy.a(1, dVar.Id, dVar.iIC, true);
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
        registerListener(this.faj);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v63, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.hBy != null) {
                    if (view == NewSubPbActivity.this.hBy.bOA()) {
                        NewSubPbActivity.this.hBy.bNa();
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
                    } else if (view != NewSubPbActivity.this.hBy.bgS()) {
                        if (view != NewSubPbActivity.this.hBy.bOt()) {
                            if (view != NewSubPbActivity.this.hBy.bOs()) {
                                if (view == NewSubPbActivity.this.hBy.bOo()) {
                                    NewSubPbActivity.this.hBy.bNa();
                                    if (NewSubPbActivity.this.hBw.aou()) {
                                        NewSubPbActivity.this.hBy.bOm();
                                    }
                                } else if (view == NewSubPbActivity.this.hBy.bOu() || view == NewSubPbActivity.this.hBy.bOv() || view == NewSubPbActivity.this.hBy.bOx()) {
                                    if (NewSubPbActivity.this.hBK) {
                                        NewSubPbActivity.this.hBK = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.hBw.bKR(), NewSubPbActivity.this.hBw.amo(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.hBw.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.hBw.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.hBy.bOy() == null || view != NewSubPbActivity.this.hBy.bOy().bLH()) {
                                    if (NewSubPbActivity.this.hBy.bOy() == null || view != NewSubPbActivity.this.hBy.bOy().bLK()) {
                                        if (NewSubPbActivity.this.hBy.bOy() == null || view != NewSubPbActivity.this.hBy.bOy().bLI()) {
                                            if (NewSubPbActivity.this.hBy.bOy() == null || view != NewSubPbActivity.this.hBy.bOy().bLJ()) {
                                                if (NewSubPbActivity.this.hBy.bOy() == null || view != NewSubPbActivity.this.hBy.bOy().bLL()) {
                                                    if (view == NewSubPbActivity.this.hBy.bOr() || view == NewSubPbActivity.this.hBy.bOx()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.gyS.amO()) {
                                                                NewSubPbActivity.this.gyS.amP();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.gyS.oX(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof com.baidu.tieba.pb.pb.main.j)) {
                                                        if (NewSubPbActivity.this.hBz == null || view != NewSubPbActivity.this.hBz.bLJ()) {
                                                            if (NewSubPbActivity.this.hBz == null || view != NewSubPbActivity.this.hBz.bLH()) {
                                                                if (NewSubPbActivity.this.hBz == null || view != NewSubPbActivity.this.hBz.bLK()) {
                                                                    if (NewSubPbActivity.this.hBz == null || view != NewSubPbActivity.this.hBz.bLL()) {
                                                                        if (NewSubPbActivity.this.hBz == null || view != NewSubPbActivity.this.hBz.bLN()) {
                                                                            if (NewSubPbActivity.this.hBz == null || view != NewSubPbActivity.this.hBz.bLO()) {
                                                                                if (NewSubPbActivity.this.hBz != null && view == NewSubPbActivity.this.hBz.bLI()) {
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
                                                                                            NewSubPbActivity.this.hBy.cs(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.hBy.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
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
                                                                                        if (postData.getType() != PostData.iGd && !TextUtils.isEmpty(postData.getBimg_url()) && i.Wy().WC()) {
                                                                                            NewSubPbActivity.this.Al(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.hnv != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnw)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.adQ();
                                                                                NewSubPbActivity.this.mPermissionJudgement.e(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.Y(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.fzR == null) {
                                                                                        NewSubPbActivity.this.fzR = new au(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.fzR.h(NewSubPbActivity.this.hnw, NewSubPbActivity.this.hnv.oB());
                                                                                    NewSubPbActivity.this.hnv = null;
                                                                                    NewSubPbActivity.this.hnw = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.hnv != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnw)) {
                                                                            if (NewSubPbActivity.this.hnx == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.hnw));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.hnw;
                                                                                aVar.pkgId = NewSubPbActivity.this.hnx.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hnx.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.hnv = null;
                                                                            NewSubPbActivity.this.hnw = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.fPQ != null) {
                                                                        NewSubPbActivity.this.fPQ.eu(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.fPQ = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                if (sparseArray2 != null && (sparseArray2.get(d.g.tag_del_post_type) instanceof Integer) && (sparseArray2.get(d.g.tag_del_post_id) instanceof String) && (sparseArray2.get(d.g.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(d.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.hBy.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
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
                                                                NewSubPbActivity.this.zL((String) tag);
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
                                                        NewSubPbActivity.this.hBO = (com.baidu.tieba.pb.pb.main.j) view.getTag();
                                                        if (bc.cZ(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.hBK) {
                                                                NewSubPbActivity.this.hBK = false;
                                                                return;
                                                            } else if (NewSubPbActivity.this.gyK == null || NewSubPbActivity.this.hBw == null || NewSubPbActivity.this.hBw.bbI() == null || NewSubPbActivity.this.gyK.hm(NewSubPbActivity.this.hBw.bbI().replyPrivateFlag)) {
                                                                if (NewSubPbActivity.this.hBL != null) {
                                                                    NewSubPbActivity.this.hBL.bgE();
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
                                                                        NewSubPbActivity.this.hBy.bOk();
                                                                    }
                                                                    if (NewSubPbActivity.this.hBN) {
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
                                            NewSubPbActivity.this.hBy.bNa();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.zL(str4);
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
                                            NewSubPbActivity.this.hBy.bNa();
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
                                    NewSubPbActivity.this.hBy.bNa();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.hBy.a(((Integer) sparseArray7.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray7.get(d.g.tag_del_post_id), ((Integer) sparseArray7.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(d.g.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new am("c11739").T("obj_locate", 2));
                                    NewSubPbActivity.this.hBy.bNa();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.hBw.bOE() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.hBw.bOE().bID());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.hBy.bOj();
                                NewSubPbActivity.this.hBy.bOk();
                                if (NewSubPbActivity.this.gyS != null) {
                                    NewSubPbActivity.this.gyS.amR();
                                    if (NewSubPbActivity.this.hBL != null) {
                                        NewSubPbActivity.this.hBL.bgE();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.hBy.bOj();
                            NewSubPbActivity.this.hBy.bOk();
                            if (NewSubPbActivity.this.gyS != null) {
                                NewSubPbActivity.this.gyS.amQ();
                                if (NewSubPbActivity.this.hBL != null) {
                                    NewSubPbActivity.this.hBL.bgE();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.bJv();
                        if (NewSubPbActivity.this.hBw != null && NewSubPbActivity.this.hBw.bOE() != null && NewSubPbActivity.this.hBw.bOE().WR() != null && NewSubPbActivity.this.hBw.bOE().WR().YR() != null) {
                            TiebaStatic.log(new am("c13402").bJ("tid", NewSubPbActivity.this.hBw.bKR()).k(ImageViewerConfig.FORUM_ID, NewSubPbActivity.this.hBw.bOE().WR().getFid()).T("obj_locate", 5).bJ("uid", NewSubPbActivity.this.hBw.bOE().WR().YR().getUserId()));
                        }
                    }
                }
            }
        };
        this.hBA = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.hBy.bNa();
                }
                NewSubPbActivity.this.gyS.amP();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.hBy.bOz();
            }
        };
        this.hof = new b.InterfaceC0225b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.hBw.bOE() != null) {
                    postData = NewSubPbActivity.this.hBw.bOE().bID();
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
                        NewSubPbActivity.this.hnv = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.hnw = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.hnv != null && !TextUtils.isEmpty(NewSubPbActivity.this.hnw)) {
                            if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hnx = null;
                            } else {
                                NewSubPbActivity.this.hnx = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                NewSubPbActivity.this.hBy.a(NewSubPbActivity.this.hog, NewSubPbActivity.this.hnv.isGif());
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
                                if (NewSubPbActivity.this.fPQ != null && NewSubPbActivity.this.hmV != null) {
                                    if (NewSubPbActivity.this.hmV != null) {
                                        NewSubPbActivity.this.hmV.cZ(NewSubPbActivity.this.hBw.isMarked());
                                    }
                                    boolean z = NewSubPbActivity.this.hmV.Vb() && NewSubPbActivity.this.fPQ.getId() != null && NewSubPbActivity.this.fPQ.getId().equals(NewSubPbActivity.this.hBw.bOL());
                                    if (NewSubPbActivity.this.hBz == null) {
                                        NewSubPbActivity.this.hBz = new y(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.mCommonClickListener);
                                        NewSubPbActivity.this.hBy.cw(NewSubPbActivity.this.hBz.getView());
                                        NewSubPbActivity.this.hBz.nC(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.hBz.showDialog();
                                    boolean isLogin = NewSubPbActivity.this.isLogin() & NewSubPbActivity.this.nj(sparseArray2.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue() : false);
                                    boolean booleanValue = sparseArray2.get(d.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(d.g.tag_is_subpb)).booleanValue() : false;
                                    if (z) {
                                        NewSubPbActivity.this.hBz.bLH().setText(d.j.remove_mark);
                                    } else {
                                        NewSubPbActivity.this.hBz.bLH().setText(d.j.mark);
                                    }
                                    if (booleanValue) {
                                        NewSubPbActivity.this.hBz.bLH().setVisibility(8);
                                    } else {
                                        NewSubPbActivity.this.hBz.bLH().setVisibility(0);
                                    }
                                    if (NewSubPbActivity.this.cm(view)) {
                                        if (NewSubPbActivity.this.hnv != null && !NewSubPbActivity.this.hnv.isGif()) {
                                            sparseArray2.put(d.g.tag_richtext_image, true);
                                        } else {
                                            sparseArray2.put(d.g.tag_richtext_image, false);
                                        }
                                        sparseArray2.put(d.g.tag_richtext_emotion, true);
                                    } else {
                                        sparseArray2.put(d.g.tag_richtext_image, false);
                                        sparseArray2.put(d.g.tag_richtext_emotion, false);
                                    }
                                    NewSubPbActivity.this.hBz.a(sparseArray2, NewSubPbActivity.this.bIl(), isLogin);
                                }
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            NewSubPbActivity.this.hnv = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                NewSubPbActivity.this.hnw = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hnx = null;
                            } else {
                                NewSubPbActivity.this.hnx = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.hnv = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.hnw = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.hnx = null;
                        } else {
                            NewSubPbActivity.this.hnx = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
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
        this.hBB = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void f(View view, String str) {
                NewSubPbActivity.this.o(null, str, "LINK_IMAGE");
            }
        };
        this.hBC = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                        j bOE = NewSubPbActivity.this.hBw.bOE();
                        TbRichText bh = NewSubPbActivity.this.bh(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bh != null && bh.asw() != null) {
                            tbRichTextData = bh.asw().get(NewSubPbActivity.this.hod);
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
                                if (bOE == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (bOE.bIJ() != null) {
                                        str4 = bOE.bIJ().getName();
                                        str5 = bOE.bIJ().getId();
                                    }
                                    if (bOE.WR() != null) {
                                        str6 = bOE.WR().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.hBw.bOQ() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.hBw.bOQ();
                                    z6 = NewSubPbActivity.this.hBw.bOS();
                                    arrayList2 = NewSubPbActivity.this.hBw.bOR();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.c(arrayList2, 0));
                                NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                                return;
                            }
                            NewSubPbActivity.this.hoe = false;
                            String str7 = "";
                            TbRichText cev = bOE.bID().cev();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(cev, bh, i, i, arrayList2, concurrentHashMap3);
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
                                if (bOE.bIJ() != null) {
                                    str8 = bOE.bIJ().getName();
                                    str9 = bOE.bIJ().getId();
                                }
                                if (bOE.WR() != null) {
                                    str10 = bOE.WR().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.hBw.bOQ() != null) {
                                concurrentHashMap = NewSubPbActivity.this.hBw.bOQ();
                                z4 = NewSubPbActivity.this.hBw.bOS();
                                arrayList = NewSubPbActivity.this.hBw.bOR();
                                i2 = a2 + NewSubPbActivity.this.hBw.getOffset();
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
            this.hoe = true;
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
                        if (!this.hoe) {
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
        if (this.hBz != null) {
            this.hBz.nC(z);
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
        if (this.hBw == null || this.hBw.bOE() == null || str == null || i < 0) {
            return null;
        }
        j bOE = this.hBw.bOE();
        TbRichText a2 = a(bOE.bID(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bOE.bID(), str, i);
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
        TbRichText cev = postData.cev();
        if (cev != null) {
            ArrayList<TbRichTextData> asw = cev.asw();
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
                        this.hod = i3;
                        return cev;
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
        if (this.fcv == null) {
            this.fcv = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.fcv.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jl(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void n(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jm(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.gyK == null || NewSubPbActivity.this.hBw == null || NewSubPbActivity.this.hBw.bbI() == null || NewSubPbActivity.this.gyK.hm(NewSubPbActivity.this.hBw.bbI().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.gyS.amG()) {
                                NewSubPbActivity.this.gyS.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.hBy.bOj();
                            NewSubPbActivity.this.hBy.bOk();
                            if (NewSubPbActivity.this.gyS != null) {
                                NewSubPbActivity.this.gyS.amS();
                                if (NewSubPbActivity.this.hBL != null) {
                                    NewSubPbActivity.this.hBL.bgE();
                                }
                            }
                        }
                    }
                }
            });
        }
        if (this.hBw != null && this.hBw.bOE() != null && this.hBw.bOE().bIJ() != null) {
            this.fcv.q(this.hBw.bOE().bIJ().getId(), com.baidu.adp.lib.g.b.d(this.hBw.bKR(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nj(boolean z) {
        if (this.hBw == null) {
            return false;
        }
        return ((bIl() != 0) || this.hBw.bOE() == null || this.hBw.bOE().WR() == null || this.hBw.bOE().WR().YR() == null || TextUtils.equals(this.hBw.bOE().WR().YR().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Context context, String str, String str2) {
        long templateId = this.hBw.bOE().bID().ceC() != null ? this.hBw.bOE().bID().ceC().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ba.adD().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.hBw.bOE().bIJ().getId(), this.hBw.bOE().bIJ().getName(), this.hBw.bOE().WR().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(int i, String str) {
        if (this.hBw.bOF()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.lo()) {
            if (i == 4) {
                this.hBy.vk(str + "(4)");
            } else {
                this.hBy.nS(d.j.no_data_text);
            }
        } else {
            this.hBy.nS(d.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.gyS = (g) new h().dd(getActivity());
        if (this.gyS != null) {
            this.gyS.a(getPageContext());
            this.gyS.b(this.hBw);
            this.gyS.b(this.fPp);
            this.gyS.a(this.ckl);
            this.gyS.a(this.ckm);
            this.gyS.alS().eH(true);
            this.gyS.e(getPageContext());
        }
        if (this.hBy != null) {
            this.hBy.g(this.gyS);
        }
        if (this.gyS != null && this.hBw != null) {
            this.gyS.a(this.hBw.bbI());
            this.gyS.amP();
        }
        if (this.gyS != null) {
            this.gyS.amT().setDefaultHint(bMr());
            this.gyS.amT().setHint(bMr());
            this.fPj = this.gyS.amT().getInputView();
            this.fPj.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.fPi != null) {
                        if (!NewSubPbActivity.this.fPi.cob()) {
                            NewSubPbActivity.this.kt(false);
                        }
                        NewSubPbActivity.this.fPi.qV(false);
                    }
                }
            });
        }
    }

    public void bOg() {
        if (!TbadkCoreApplication.isLogin()) {
            this.gyS.amP();
        } else if (!StringUtils.isNull(this.hBw.bOM())) {
            if (this.hBy.bOn() && com.baidu.adp.lib.util.l.lo()) {
                this.hBy.aYV();
            } else {
                this.hBy.bOq();
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
                    this.hBy.cs(view);
                }
            } else if (booleanValue2) {
                this.hBy.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.hBy.bOw(), getPageContext().getPageActivity());
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.hBJ);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.hBJ);
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
        this.hBy.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.hBJ;
        userMuteCheckCustomMessage.setTag(this.hBJ);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.hBy.a(0, bVar.Id, bVar.iIC, z);
            if (bVar.Id) {
                if (bVar.eFN == 1) {
                    if (this.hBy.getListView() instanceof BdTypeListView) {
                        List<m> data = ((BdTypeListView) this.hBy.getListView()).getData();
                        if (!v.T(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            data.remove(i);
                            this.hBy.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.eFN == 2) {
                    this.hBw.An(bVar.mPostId);
                    this.hBy.a(this.hBw.bOE(), this.hBw.bIl(), this.hBw.bOQ() != null);
                    if (this.hBw.bON()) {
                        this.hBw.oo(false);
                        this.hBy.bOl();
                        this.hBw.aou();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
            }
        }
    }

    public void zL(String str) {
        this.hmU.Aj(str);
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.hBw.isMarked() && postData.getId() != null && postData.getId().equals(this.hBw.bOL())) {
                z = true;
            }
            MarkData j = this.hBw.j(postData);
            if (j != null) {
                this.hBy.bNa();
                if (this.hmV != null) {
                    this.hmV.a(j);
                    if (!z) {
                        this.hmV.Vd();
                    } else {
                        this.hmV.Vc();
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
        if (bundle != null && this.hBw != null) {
            this.hBw.aa(bundle);
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
        this.gyS.alS().akp();
        this.gyS.amP();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gyS.b(writeData);
                this.gyS.setVoiceModel(pbEditorData.getVoiceModel());
                k jw = this.gyS.alS().jw(6);
                if (jw != null && jw.ciu != null) {
                    jw.ciu.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gyS.amL();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.eYR != null) {
            this.eYR.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.hBH = true;
        super.onPause();
        if (this.eYR != null) {
            this.eYR.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.gcF);
        this.hBy.biQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.hBH = false;
        super.onResume();
        if (this.eYR != null) {
            this.eYR.onResume(getPageContext());
        }
        registerListener(this.gcF);
        this.hBy.biR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eYR != null) {
            this.eYR.onStop(getPageContext());
        }
        this.gyS.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.hBM));
        this.hBw.cancelLoadData();
        this.hBw.destory();
        this.hBx.cancelLoadData();
        if (this.eYR != null) {
            this.eYR.onDestory(getPageContext());
        }
        this.hBy.bNa();
        this.hBy.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.hnT);
        MessageManager.getInstance().unRegisterListener(this.hnU);
        MessageManager.getInstance().unRegisterListener(this.hnV);
        MessageManager.getInstance().unRegisterListener(this.hBJ);
        this.hnr = null;
        this.hns = null;
        if (this.gyK != null) {
            this.gyK.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hBy.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.eYR;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bOr = this.hBy.bOr();
        if (bOr == null || (findViewWithTag = bOr.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Ac(String str) {
        Map<String, String> mN;
        if (!TextUtils.isEmpty(str) && (mN = ba.mN(ba.mO(str))) != null) {
            this.hBK = true;
            String str2 = mN.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Ac(com.baidu.adp.lib.util.k.by(str2));
            }
            String str3 = mN.get(hBv);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (Ac(str)) {
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
            this.hBK = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ay(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hBK = true;
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
        if (this.hBy != null) {
            return this.hBy.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int atd() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> atf() {
        if (this.cDh == null) {
            this.cDh = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cDh;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> atg() {
        if (this.cAt == null) {
            this.cAt = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
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
        return this.cAt;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> ate() {
        if (this.cAs == null) {
            this.cAs = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.adp.lib.e.c
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean WC = i.Wy().WC();
                    foreDrawableImageView.setDefaultBg(al.getDrawable(d.C0277d.common_color_10220));
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
                        foreDrawableImageView.setDefaultBgResource(d.C0277d.cp_bg_line_c);
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
                        foreDrawableImageView.setDefaultBgResource(d.C0277d.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.cAs;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> ath() {
        if (this.cDi == null) {
            this.cDi = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
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
        return this.cDi;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> ati() {
        if (this.cDj == null) {
            this.cDj = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
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
        return this.cDj;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> atj() {
        this.cDk = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
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
        return this.cDk;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bIP() {
        return this.hmX;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bIQ() {
        return (this.hBw == null || this.hBw.bOE() == null || this.hBw.bOE().WR() == null || this.hBw.bOE().WR().aaj()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bIR() {
        if (this.hBw == null || this.hBw.bOE() == null || this.hBw.bOE().WR() == null) {
            return null;
        }
        return this.hBw.bOE().WR().YW();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bIS() {
        if (this.hBw == null) {
            return 0;
        }
        return this.hBw.bIl();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean zI(String str) {
        if (StringUtils.isNull(str) || this.hBw == null || this.hBw.bOE() == null || this.hBw.bOE().WR() == null || this.hBw.bOE().WR().YR() == null) {
            return false;
        }
        return str.equals(this.hBw.bOE().WR().YR().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hBy.bOn() && com.baidu.adp.lib.util.l.lo()) {
            this.hBw.aou();
        } else {
            this.hBy.bOq();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.hBJ);
        userMuteAddAndDelCustomMessage.setTag(this.hBJ);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Al(String str) {
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
            public boolean aoK() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int aoL() {
                return com.baidu.tbadk.pageStayDuration.e.aoP().aoS();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.hBw != null) {
            if (this.hBw.bOE() != null && this.hBw.bOE().bIJ() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.hBw.bOE().bIJ().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.hBw.bKR(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.hBH;
    }

    public boolean bOh() {
        if (this.hBw != null) {
            return this.hBw.bOh();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hBy.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hnr.getPageActivity());
        if (ap.isEmpty(str)) {
            aVar.ly(this.hnr.getResources().getString(d.j.block_mute_message_alert, str3));
        } else {
            aVar.ly(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.hBy.showLoadingDialog();
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
        aVar.b(this.hnr).aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oW(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hnr.getPageActivity());
        aVar.ly(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hnr).aaZ();
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
                    ((TbPageContext) NewSubPbActivity.this.hnr).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.hnr.getPageActivity(), 2, true, 4);
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
        aVar.b(this.hnr).aaZ();
    }

    public SubPbModel bOi() {
        return this.hBw;
    }

    public int bIl() {
        if (this.hBw != null) {
            return this.hBw.bIl();
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
        if (this.fPj != null && this.fPj.getText() != null) {
            int selectionEnd = this.fPj.getSelectionEnd();
            SpannableStringBuilder b = this.fPi.b(this.fPj.getText());
            if (b != null) {
                this.fPi.qV(true);
                this.fPj.setText(b);
                if (z && this.fPi.cnZ() >= 0) {
                    this.fPj.requestFocus();
                    this.fPj.setSelection(this.fPi.cnZ());
                } else {
                    this.fPj.setSelection(selectionEnd);
                }
                this.fPi.qU(this.fPi.cnZ() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gyS != null && this.gyS.alS() != null && this.gyS.alS().alV()) {
            this.gyS.alS().akp();
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
        if (!ap.isEmpty(this.hya)) {
            return this.hya;
        }
        this.hya = getResources().getString(com.baidu.tieba.pb.pb.main.ap.bMj());
        return this.hya;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.hBN = z;
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
        if (this.hBy != null && this.hBy.getListView() != null && this.hBO != null && this.hBO.mPosition != -1) {
            final int headerViewsCount = this.hBO.mPosition + this.hBy.getListView().getHeaderViewsCount();
            if (this.hBO.getView() != null) {
                final int height = this.hBO.getView().getHeight() - ((rect.height() - this.hBy.getNavigationBarHeight()) - this.hBy.bOB());
                if (height > 0) {
                    this.hBy.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.hBy != null && NewSubPbActivity.this.hBy.getListView() != null) {
                                NewSubPbActivity.this.hBy.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.hBy.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.hBy.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.hBy != null && NewSubPbActivity.this.hBy.getListView() != null) {
                                NewSubPbActivity.this.hBy.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.hBy.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }
}
