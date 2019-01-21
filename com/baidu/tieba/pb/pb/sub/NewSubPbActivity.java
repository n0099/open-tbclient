package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.content.Intent;
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
import com.baidu.tbadk.core.dialog.h;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.l;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.pb.PbEditorData;
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
import com.baidu.tieba.e;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.av;
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
/* loaded from: classes6.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.e, com.baidu.tieba.pb.pb.a<NewSubPbActivity> {
    private static final String gkh = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String glA = "tbgametype";
    private View.OnLongClickListener aUa;
    private com.baidu.adp.lib.e.b<GifView> bsA;
    private com.baidu.adp.lib.e.b<ImageView> bsv;
    private com.baidu.adp.lib.e.b<TextView> bsw;
    private com.baidu.adp.lib.e.b<View> bsx;
    private com.baidu.adp.lib.e.b<LinearLayout> bsy;
    private com.baidu.adp.lib.e.b<RelativeLayout> bsz;
    private VoiceManager dLA;
    private h dMm;
    private com.baidu.tieba.pb.pb.report.a fWL;
    private com.baidu.tbadk.baseEditMark.a fWM;
    private com.baidu.tieba.pb.pb.main.b.a fWO;
    private y fWT;
    private b.InterfaceC0158b fXV;
    private com.baidu.adp.base.e fXf;
    private g fXg;
    private av fXj;
    private com.baidu.adp.widget.ImageView.a fXk;
    private String fXl;
    private TbRichTextMemeInfo fXm;
    public aj fiL;
    private com.baidu.tbadk.editortools.pb.g fiT;
    private PostWriteCallBackData gbw;
    private EditText giN;
    private SubPbModel glB;
    private ForumManageModel glC;
    private b glD;
    private AbsListView.OnScrollListener glE;
    private TbRichTextView.i glF;
    private TbRichTextView.h glG;
    private SubPbModel.a glH;
    private com.baidu.adp.base.d glI;
    private BdUniqueId glN;
    private com.baidu.tieba.pb.pb.sub.a glP;
    private com.baidu.tieba.write.b glQ;
    private com.baidu.tieba.pb.d<j> glR;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int fXS = 0;
    PostData fXU = null;
    private a.InterfaceC0154a fXP = null;
    private a glJ = null;
    private a glK = null;
    private boolean glL = false;
    private boolean glM = false;
    private boolean glO = false;
    private boolean aZt = false;
    private com.baidu.tbadk.editortools.pb.c baN = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void MN() {
            NewSubPbActivity.this.glD.bnT();
        }
    };
    private com.baidu.tbadk.editortools.pb.b baO = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean MM() {
            if (!NewSubPbActivity.this.glQ.bOv()) {
                return (NewSubPbActivity.this.fiL == null || NewSubPbActivity.this.glB == null || NewSubPbActivity.this.glB.aBj() == null || NewSubPbActivity.this.fiL.x(NewSubPbActivity.this.glB.aBj().replyPrivateFlag, aj.aCA)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.glQ.bOx());
            if (NewSubPbActivity.this.fiT.Nc()) {
                NewSubPbActivity.this.fiT.a(NewSubPbActivity.this.gbw);
            }
            NewSubPbActivity.this.lO(true);
            return true;
        }
    };
    private NewWriteModel.d glS = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.fiT != null && NewSubPbActivity.this.fiT.Mp() != null) {
                NewSubPbActivity.this.fiT.Mp().hide();
                if (NewSubPbActivity.this.glB.bon()) {
                    TiebaStatic.log(new am("c10367").aB("post_id", NewSubPbActivity.this.glB.MK()));
                }
            }
            if (z) {
                NewSubPbActivity.this.glQ.xK(null);
                NewSubPbActivity.this.glQ.aA(null);
                NewSubPbActivity.this.glQ.ou(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    NewSubPbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.glQ.aA(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.glQ.xK(postWriteCallBackData.getErrorString());
                if (!v.I(NewSubPbActivity.this.glQ.bOt())) {
                    NewSubPbActivity.this.gbw = postWriteCallBackData;
                    if (NewSubPbActivity.this.fiT.Nc()) {
                        NewSubPbActivity.this.fiT.a(NewSubPbActivity.this.gbw);
                    }
                    NewSubPbActivity.this.lO(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.fiL != null) {
                NewSubPbActivity.this.fiL.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.glD.bnU();
        }
    };
    private CustomMessageListener fXI = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.glN) {
                NewSubPbActivity.this.glD.alK();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fXg.e(NewSubPbActivity.this.fXf.getResources().getString(e.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.fXf.getResources().getString(e.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.ij(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bjD();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ao.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.fXf.getResources().getString(e.j.mute_fail);
                    }
                    NewSubPbActivity.this.fXg.f(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fXJ = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.glN) {
                NewSubPbActivity.this.glD.alK();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fXg.e(NewSubPbActivity.this.fXf.getResources().getString(e.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ao.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.fXf.getResources().getString(e.j.un_mute_fail);
                }
                NewSubPbActivity.this.fXg.f(muteMessage);
            }
        }
    };
    private CustomMessageListener fXK = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.glN) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.glD.alK();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.hDP;
                if (aVar.error == 0 && dataRes != null) {
                    boolean z2 = com.baidu.adp.lib.g.b.l(dataRes.is_mute, 0) == 1;
                    sparseArray.put(e.g.tag_user_mute_visible, true);
                    sparseArray.put(e.g.tag_user_mute_msg, dataRes.mute_confirm);
                    z = z2;
                } else {
                    sparseArray.put(e.g.tag_user_mute_visible, false);
                    z = false;
                }
                int intValue = sparseArray.get(e.g.tag_from) instanceof Integer ? ((Integer) sparseArray.get(e.g.tag_from)).intValue() : 0;
                if (intValue == 0) {
                    NewSubPbActivity.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    NewSubPbActivity.this.glD.a(sparseArray, z);
                }
            }
        }
    };
    boolean fXT = false;
    private final b.InterfaceC0158b fXW = new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.fXk != null && !TextUtils.isEmpty(NewSubPbActivity.this.fXl)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.fXm == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.fXl));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.fXl;
                        aVar.pkgId = NewSubPbActivity.this.fXm.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.fXm.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.EG();
                    NewSubPbActivity.this.mPermissionJudgement.c(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.B(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.fXj == null) {
                            NewSubPbActivity.this.fXj = new av(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.fXj.i(NewSubPbActivity.this.fXl, NewSubPbActivity.this.fXk.ow());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.fXk = null;
                NewSubPbActivity.this.fXl = null;
            }
        }
    };
    private CustomMessageListener eME = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener dMJ = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    l lVar = (l) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.glB.boh() != null && NewSubPbActivity.this.glB.boh().big() != null && NewSubPbActivity.this.glB.boh().big().zT() != null && currentAccount.equals(NewSubPbActivity.this.glB.boh().big().zT().getUserId()) && NewSubPbActivity.this.glB.boh().big().zT().getPendantData() != null) {
                        NewSubPbActivity.this.glB.boh().big().zT().getPendantData().es(lVar.yF());
                        NewSubPbActivity.this.glB.boh().big().zT().getPendantData().ap(lVar.LW());
                        NewSubPbActivity.this.glD.a(NewSubPbActivity.this.glB.boh().big(), NewSubPbActivity.this.glB.boh().aUP(), NewSubPbActivity.this.glB.boh().wx(), NewSubPbActivity.this.glB.bhL(), NewSubPbActivity.this.glB.bot() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void m(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        H(bundle);
        if (this.aZt) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.fXf = getPageContext();
        this.glM = true;
        this.glQ = new com.baidu.tieba.write.b();
        this.glQ.xl(e.d.cp_cont_h_alpha85);
        this.glQ.xk(e.d.cp_cont_i);
        aGi();
        bnK();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bnJ();
        this.fXg = new g();
        this.fXg.aHG = 1000L;
        registerListener(this.fXK);
        registerListener(this.fXI);
        registerListener(this.fXJ);
        this.glN = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.glN;
        userMuteAddAndDelCustomMessage.setTag(this.glN);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.glN;
        userMuteCheckCustomMessage.setTag(this.glN);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.fiL = new aj(getPageContext());
        this.fiL.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.fiT.Nh();
                }
            }
        });
        this.fWL = new com.baidu.tieba.pb.pb.report.a(this);
        this.fWL.o(getUniqueId());
        this.fWO = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    private void bnJ() {
        if (this.glD != null && this.glB != null && this.glB.bnM()) {
            this.glP = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.glD.act());
            this.glP.aGn();
            this.glP.a(new a.InterfaceC0290a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
                private boolean dZN = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0290a
                public void aGj() {
                    NewSubPbActivity.this.glD.hm(false);
                    this.dZN = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0290a
                public void aGk() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0290a
                public boolean aGl() {
                    if (!this.dZN) {
                        return NewSubPbActivity.this.glD.aGz() != null && NewSubPbActivity.this.glD.aGz().getTop() == 0;
                    }
                    this.dZN = false;
                    return false;
                }
            });
            this.glD.e(this.glP);
            this.glD.hm(true);
        }
    }

    public void initUI() {
        this.glD = new b(this, this.mCommonClickListener);
        this.glD.a(this.glB);
        setContentView(this.glD.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.glD.setOnScrollListener(this.glE);
        this.glD.a(this);
        this.glD.setOnLinkImageClickListener(this.glF);
        this.glD.setOnImageClickListener(this.glG);
        this.glD.kC(true);
        this.glD.setOnLongClickListener(this.aUa);
        this.glD.c(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.glB != null) {
                    NewSubPbActivity.this.glB.OP();
                }
            }
        });
        this.glD.a(this.glJ);
        this.glD.b(this.glK);
        if (this.glB != null && this.glB.bnM() && !this.glB.bos()) {
            this.glD.bnY().setVisibility(8);
        } else {
            this.glD.bnY().setVisibility(0);
        }
        if (this.glB != null && !this.glB.bnM()) {
            this.glD.setIsFromPb(false);
        }
    }

    private boolean H(Bundle bundle) {
        if (bundle != null) {
            this.aZt = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.aZt = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.aZt;
    }

    public void initData(Bundle bundle) {
        this.glB = new SubPbModel(getPageContext());
        this.glB.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                NewSubPbActivity.this.glD.p(postData);
                NewSubPbActivity.this.glD.a((BdListView.e) null);
            }
        });
        this.glC = new ForumManageModel(getPageContext());
        this.glC.setLoadDataCallBack(this.glI);
        this.dLA = new VoiceManager();
        this.dLA.onCreate(getPageContext());
        this.fWM = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fWM != null) {
            this.fWM.a(this.fXP);
        }
        if (bundle != null) {
            this.glB.initWithBundle(bundle);
        } else {
            this.glB.initWithIntent(getIntent());
        }
        this.glB.a(this.glH);
        if (this.glB.bnM()) {
            this.glB.OP();
        } else {
            this.glB.bom();
        }
    }

    public void bnK() {
        this.glH = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, j jVar) {
                if (NewSubPbActivity.this.glD != null) {
                    NewSubPbActivity.this.glD.bnU();
                }
                if (NewSubPbActivity.this.glP != null && NewSubPbActivity.this.glP.aGo()) {
                    NewSubPbActivity.this.glP.nc(e.d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.ah(i, str);
                    return;
                }
                NewSubPbActivity.this.glD.hideNoDataView();
                if (jVar != null) {
                    if (jVar.big() != null || NewSubPbActivity.this.glB != null) {
                        jVar.big().a(NewSubPbActivity.this.glB.bor());
                    }
                    if (NewSubPbActivity.this.glD != null) {
                        NewSubPbActivity.this.glD.a(jVar, NewSubPbActivity.this.glB.bhL(), NewSubPbActivity.this.glB.bot() != null);
                        if (NewSubPbActivity.this.glM) {
                            NewSubPbActivity.this.bnL();
                            NewSubPbActivity.this.glM = false;
                        }
                    }
                    if (NewSubPbActivity.this.fiT != null) {
                        NewSubPbActivity.this.fiT.a(jVar.aBj());
                    }
                    if (NewSubPbActivity.this.glR == null) {
                        NewSubPbActivity.this.glR = new com.baidu.tieba.pb.d();
                    }
                    NewSubPbActivity.this.glR.setData(jVar);
                    NewSubPbActivity.this.glR.setType(0);
                    NewSubPbActivity.this.fiL.a(NewSubPbActivity.this.glB.bow());
                }
            }
        };
        this.fXP = new a.InterfaceC0154a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0154a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.fWM != null) {
                        NewSubPbActivity.this.fWM.aQ(z2);
                    }
                    MarkData wA = NewSubPbActivity.this.fWM.wA();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setType(2);
                    if (z2) {
                        dVar.setData(wA);
                        if (NewSubPbActivity.this.fWM != null) {
                            if (wA != null) {
                                NewSubPbActivity.this.glB.lQ(true);
                                NewSubPbActivity.this.glB.tK(NewSubPbActivity.this.glB.MK());
                                NewSubPbActivity.this.showToast(e.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(e.j.add_mark));
                            }
                            if (NewSubPbActivity.this.glD != null) {
                                NewSubPbActivity.this.glD.lP(true);
                            }
                        }
                    } else {
                        dVar.setData(null);
                        NewSubPbActivity.this.glB.lQ(false);
                        NewSubPbActivity.this.glB.tK(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(e.j.remove_mark));
                        if (NewSubPbActivity.this.glD != null) {
                            NewSubPbActivity.this.glD.lP(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(e.j.update_mark_failed));
            }
        };
        this.glJ = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.glB.boh() != null && NewSubPbActivity.this.glB.boh().aaq() != null && NewSubPbActivity.this.glB.boh().aaq().zT() != null) {
                    str = String.valueOf(NewSubPbActivity.this.glB.boh().aaq().zT().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.glB.boh().bim().getId(), NewSubPbActivity.this.glB.boh().bim().getName(), NewSubPbActivity.this.glB.boh().aaq().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.glK = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.glC.bFD() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int l = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[1]), 0);
                        boolean g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[2]), false);
                        int l2 = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.glB != null && NewSubPbActivity.this.glB.boh() != null && NewSubPbActivity.this.glB.boh().bim() != null && NewSubPbActivity.this.glB.boh().aaq() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.glC.wc(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.glC.a(NewSubPbActivity.this.glB.boh().bim().getId(), NewSubPbActivity.this.glB.boh().bim().getName(), NewSubPbActivity.this.glB.boh().aaq().getId(), valueOf, l2, l, g);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.glI = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.glD.a(NewSubPbActivity.this.glC.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.glC.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.gmF != 1002 || bVar.eqG) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.glD.a(1, dVar.HZ, dVar.hsd, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean by(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void aGi() {
        registerListener(this.dMJ);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v48, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.glD != null) {
                    if (view == NewSubPbActivity.this.glD.boe()) {
                        NewSubPbActivity.this.glD.bmF();
                        String str = view.getTag(e.g.tag_user_id) instanceof String ? (String) view.getTag(e.g.tag_user_id) : null;
                        String str2 = view.getTag(e.g.tag_user_name) instanceof String ? (String) view.getTag(e.g.tag_user_name) : null;
                        String str3 = view.getTag(e.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(e.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ay.Es().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.glD.aGA()) {
                        if (view != NewSubPbActivity.this.glD.bnX()) {
                            if (view != NewSubPbActivity.this.glD.bnW()) {
                                if (view == NewSubPbActivity.this.glD.bnS()) {
                                    NewSubPbActivity.this.glD.bmF();
                                    if (NewSubPbActivity.this.glB.OP()) {
                                        NewSubPbActivity.this.glD.bnQ();
                                    }
                                } else if (view == NewSubPbActivity.this.glD.bnY() || view == NewSubPbActivity.this.glD.bnZ() || view == NewSubPbActivity.this.glD.bob()) {
                                    if (NewSubPbActivity.this.glO) {
                                        NewSubPbActivity.this.glO = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.glB.bkt(), NewSubPbActivity.this.glB.MK(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.glB.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.glB.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.glD.boc() == null || view != NewSubPbActivity.this.glD.boc().blj()) {
                                    if (NewSubPbActivity.this.glD.boc() == null || view != NewSubPbActivity.this.glD.boc().blm()) {
                                        if (NewSubPbActivity.this.glD.boc() == null || view != NewSubPbActivity.this.glD.boc().blk()) {
                                            if (NewSubPbActivity.this.glD.boc() == null || view != NewSubPbActivity.this.glD.boc().bll()) {
                                                if (NewSubPbActivity.this.glD.boc() == null || view != NewSubPbActivity.this.glD.boc().bln()) {
                                                    if (view == NewSubPbActivity.this.glD.bnV() || view == NewSubPbActivity.this.glD.bob()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.fiT.Nk()) {
                                                                NewSubPbActivity.this.fiT.Nl();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.fiT.ik(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof com.baidu.tieba.pb.pb.main.j)) {
                                                        if (NewSubPbActivity.this.fWT == null || view != NewSubPbActivity.this.fWT.bll()) {
                                                            if (NewSubPbActivity.this.fWT == null || view != NewSubPbActivity.this.fWT.blj()) {
                                                                if (NewSubPbActivity.this.fWT == null || view != NewSubPbActivity.this.fWT.blm()) {
                                                                    if (NewSubPbActivity.this.fWT == null || view != NewSubPbActivity.this.fWT.bln()) {
                                                                        if (NewSubPbActivity.this.fWT == null || view != NewSubPbActivity.this.fWT.blp()) {
                                                                            if (NewSubPbActivity.this.fWT == null || view != NewSubPbActivity.this.fWT.blq()) {
                                                                                if (NewSubPbActivity.this.fWT != null && view == NewSubPbActivity.this.fWT.blk()) {
                                                                                    if (!com.baidu.adp.lib.util.j.kV()) {
                                                                                        NewSubPbActivity.this.showToast(e.j.network_not_available);
                                                                                        return;
                                                                                    }
                                                                                    SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                                                                                    if (sparseArray != null) {
                                                                                        boolean booleanValue = ((Boolean) sparseArray.get(e.g.tag_should_manage_visible)).booleanValue();
                                                                                        boolean booleanValue2 = ((Boolean) sparseArray.get(e.g.tag_should_delete_visible)).booleanValue();
                                                                                        boolean booleanValue3 = ((Boolean) sparseArray.get(e.g.tag_user_mute_visible)).booleanValue();
                                                                                        if (booleanValue) {
                                                                                            if (booleanValue3) {
                                                                                                sparseArray.put(e.g.tag_from, 1);
                                                                                                sparseArray.put(e.g.tag_check_mute_from, 2);
                                                                                                NewSubPbActivity.this.b(sparseArray);
                                                                                                return;
                                                                                            }
                                                                                            sparseArray.put(e.g.tag_check_mute_from, 2);
                                                                                            NewSubPbActivity.this.glD.bF(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.glD.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                            return;
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                int id = view.getId();
                                                                                if (id == e.g.pb_item_tail_content) {
                                                                                    if (ba.bJ(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(e.j.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                            TiebaStatic.log("c10056");
                                                                                            com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else if (id == e.g.richText && (view.getTag() instanceof SparseArray)) {
                                                                                    Object obj = ((SparseArray) view.getTag()).get(e.g.tag_clip_board);
                                                                                    if (obj instanceof PostData) {
                                                                                        PostData postData = (PostData) obj;
                                                                                        if (postData.getType() != PostData.hpF && !TextUtils.isEmpty(postData.getBimg_url()) && i.xR().xV()) {
                                                                                            NewSubPbActivity.this.tH(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.fXk != null && !TextUtils.isEmpty(NewSubPbActivity.this.fXl)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.EG();
                                                                                NewSubPbActivity.this.mPermissionJudgement.c(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.B(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.fXj == null) {
                                                                                        NewSubPbActivity.this.fXj = new av(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.fXj.i(NewSubPbActivity.this.fXl, NewSubPbActivity.this.fXk.ow());
                                                                                    NewSubPbActivity.this.fXk = null;
                                                                                    NewSubPbActivity.this.fXl = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.fXk != null && !TextUtils.isEmpty(NewSubPbActivity.this.fXl)) {
                                                                            if (NewSubPbActivity.this.fXm == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.fXl));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.fXl;
                                                                                aVar.pkgId = NewSubPbActivity.this.fXm.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.fXm.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.fXk = null;
                                                                            NewSubPbActivity.this.fXl = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.fXU != null) {
                                                                        NewSubPbActivity.this.fXU.cZ(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.fXU = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                if (sparseArray2 != null && (sparseArray2.get(e.g.tag_del_post_type) instanceof Integer) && (sparseArray2.get(e.g.tag_del_post_id) instanceof String) && (sparseArray2.get(e.g.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.glD.a(((Integer) sparseArray2.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(e.g.tag_del_post_id), ((Integer) sparseArray2.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.bx(view);
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (!com.baidu.adp.lib.util.j.kV()) {
                                                            NewSubPbActivity.this.showToast(e.j.network_not_available);
                                                            return;
                                                        } else {
                                                            Object tag = view.getTag();
                                                            if (tag instanceof String) {
                                                                NewSubPbActivity.this.tj((String) tag);
                                                                return;
                                                            } else if (tag instanceof SparseArray) {
                                                                SparseArray<Object> sparseArray3 = (SparseArray) tag;
                                                                if ((sparseArray3.get(e.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray3.get(e.g.tag_user_mute_visible)).booleanValue()) {
                                                                    sparseArray3.put(e.g.tag_from, 0);
                                                                    sparseArray3.put(e.g.tag_check_mute_from, 2);
                                                                    NewSubPbActivity.this.b(sparseArray3);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    } else if (ba.bJ(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                        if (NewSubPbActivity.this.glO) {
                                                            NewSubPbActivity.this.glO = false;
                                                            return;
                                                        } else if (NewSubPbActivity.this.fiL == null || NewSubPbActivity.this.glB == null || NewSubPbActivity.this.glB.aBj() == null || NewSubPbActivity.this.fiL.dK(NewSubPbActivity.this.glB.aBj().replyPrivateFlag)) {
                                                            if (NewSubPbActivity.this.glP != null) {
                                                                NewSubPbActivity.this.glP.aGm();
                                                            }
                                                            SparseArray sparseArray4 = (SparseArray) view.getTag(e.g.tag_from);
                                                            if (sparseArray4 != null && (sparseArray4.get(e.g.tag_clip_board) instanceof PostData)) {
                                                                PostData postData2 = (PostData) sparseArray4.get(e.g.tag_clip_board);
                                                                if (postData2 != null && postData2.zT() != null) {
                                                                    MetaData zT = postData2.zT();
                                                                    NewSubPbActivity.this.fiT.setReplyId(zT.getUserId());
                                                                    if (!(sparseArray4.get(e.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray4.get(e.g.tag_is_subpb)).booleanValue() : true)) {
                                                                        NewSubPbActivity.this.fiT.in("");
                                                                    } else {
                                                                        NewSubPbActivity.this.fiT.in(zT.getName_show());
                                                                    }
                                                                }
                                                                NewSubPbActivity.this.glD.bnO();
                                                                return;
                                                            }
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        return;
                                                    }
                                                } else if (view.getTag() != null && (view.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                    if (sparseArray5.get(e.g.tag_clip_board) instanceof PostData) {
                                                        ((PostData) sparseArray5.get(e.g.tag_clip_board)).cZ(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new am("c11739").y("obj_locate", 4));
                                            if (!com.baidu.adp.lib.util.j.kV()) {
                                                NewSubPbActivity.this.showToast(e.j.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.glD.bmF();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.tj(str4);
                                                    return;
                                                }
                                                return;
                                            } else if (tag2 instanceof SparseArray) {
                                                SparseArray<Object> sparseArray6 = (SparseArray) tag2;
                                                if ((sparseArray6.get(e.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray6.get(e.g.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray6.put(e.g.tag_from, 0);
                                                    sparseArray6.put(e.g.tag_check_mute_from, 2);
                                                    NewSubPbActivity.this.b(sparseArray6);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        } else if (com.baidu.adp.lib.util.j.kV()) {
                                            NewSubPbActivity.this.glD.bmF();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.bJ(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(e.j.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.glD.bmF();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.glD.a(((Integer) sparseArray7.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray7.get(e.g.tag_del_post_id), ((Integer) sparseArray7.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(e.g.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new am("c11739").y("obj_locate", 2));
                                    NewSubPbActivity.this.glD.bmF();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.glB.boh() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.glB.boh().big());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.glD.bnN();
                                NewSubPbActivity.this.glD.bnO();
                                if (NewSubPbActivity.this.fiT != null) {
                                    NewSubPbActivity.this.fiT.Nn();
                                    if (NewSubPbActivity.this.glP != null) {
                                        NewSubPbActivity.this.glP.aGm();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.glD.bnN();
                            NewSubPbActivity.this.glD.bnO();
                            if (NewSubPbActivity.this.fiT != null) {
                                NewSubPbActivity.this.fiT.Nm();
                                if (NewSubPbActivity.this.glP != null) {
                                    NewSubPbActivity.this.glP.aGm();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.fiL == null || NewSubPbActivity.this.glB == null || NewSubPbActivity.this.glB.aBj() == null || NewSubPbActivity.this.fiL.dK(NewSubPbActivity.this.glB.aBj().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.fiT.Nc()) {
                                NewSubPbActivity.this.fiT.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.glD.bnN();
                            NewSubPbActivity.this.glD.bnO();
                            if (NewSubPbActivity.this.fiT != null) {
                                NewSubPbActivity.this.fiT.No();
                                if (NewSubPbActivity.this.glP != null) {
                                    NewSubPbActivity.this.glP.aGm();
                                }
                            }
                        }
                    }
                }
            }
        };
        this.glE = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.glD.bmF();
                }
                NewSubPbActivity.this.fiT.Nl();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.glD.bod();
            }
        };
        this.fXV = new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.glB.boh() != null) {
                    postData = NewSubPbActivity.this.glB.boh().big();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.cZ(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.f(postData);
                    }
                }
            }
        };
        this.aUa = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            /* JADX WARN: Removed duplicated region for block: B:111:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
            /* JADX WARN: Removed duplicated region for block: B:92:0x02a3  */
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
                if (sparseArray == null && NewSubPbActivity.this.by(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.fXk = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.fXl = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.fXk != null && !TextUtils.isEmpty(NewSubPbActivity.this.fXl)) {
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.fXm = null;
                            } else {
                                NewSubPbActivity.this.fXm = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                NewSubPbActivity.this.glD.a(NewSubPbActivity.this.fXW, NewSubPbActivity.this.fXk.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                NewSubPbActivity.this.fXU = (PostData) sparseArray2.get(e.g.tag_clip_board);
                                if (NewSubPbActivity.this.fXU != null && NewSubPbActivity.this.fWM != null) {
                                    if (NewSubPbActivity.this.fWM != null) {
                                        NewSubPbActivity.this.fWM.aQ(NewSubPbActivity.this.glB.isMarked());
                                    }
                                    boolean z = NewSubPbActivity.this.fWM.wx() && NewSubPbActivity.this.fXU.getId() != null && NewSubPbActivity.this.fXU.getId().equals(NewSubPbActivity.this.glB.boo());
                                    if (NewSubPbActivity.this.fWT == null) {
                                        NewSubPbActivity.this.fWT = new y(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.mCommonClickListener);
                                        NewSubPbActivity.this.glD.bH(NewSubPbActivity.this.fWT.getView());
                                        NewSubPbActivity.this.fWT.lb(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.fWT.showDialog();
                                    boolean isLogin = NewSubPbActivity.this.isLogin() & NewSubPbActivity.this.kJ(sparseArray2.get(e.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(e.g.tag_del_post_is_self)).booleanValue() : false);
                                    boolean booleanValue = sparseArray2.get(e.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(e.g.tag_is_subpb)).booleanValue() : false;
                                    if (z) {
                                        NewSubPbActivity.this.fWT.blj().setText(e.j.remove_mark);
                                    } else {
                                        NewSubPbActivity.this.fWT.blj().setText(e.j.mark);
                                    }
                                    if (booleanValue) {
                                        NewSubPbActivity.this.fWT.blj().setVisibility(8);
                                    } else {
                                        NewSubPbActivity.this.fWT.blj().setVisibility(0);
                                    }
                                    if (NewSubPbActivity.this.by(view)) {
                                        if (NewSubPbActivity.this.fXk != null && !NewSubPbActivity.this.fXk.isGif()) {
                                            sparseArray2.put(e.g.tag_richtext_image, true);
                                        } else {
                                            sparseArray2.put(e.g.tag_richtext_image, false);
                                        }
                                        sparseArray2.put(e.g.tag_richtext_emotion, true);
                                    } else {
                                        sparseArray2.put(e.g.tag_richtext_image, false);
                                        sparseArray2.put(e.g.tag_richtext_emotion, false);
                                    }
                                    NewSubPbActivity.this.fWT.a(sparseArray2, NewSubPbActivity.this.bhL(), isLogin);
                                    NewSubPbActivity.this.fWT.refreshUI();
                                }
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            NewSubPbActivity.this.fXk = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                NewSubPbActivity.this.fXl = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.fXm = null;
                            } else {
                                NewSubPbActivity.this.fXm = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.fXk = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.fXl = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.fXm = null;
                        } else {
                            NewSubPbActivity.this.fXm = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
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
        this.glF = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void e(View view, String str) {
                NewSubPbActivity.this.n(null, str, "LINK_IMAGE");
            }
        };
        this.glG = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
            /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX DEBUG: Multi-variable search result rejected for r2v44, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
            public void a(View view, String str, int i, boolean z) {
                String str2;
                boolean z2;
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap;
                int i2;
                boolean z3;
                ArrayList<String> arrayList;
                String str3;
                boolean z4;
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2;
                boolean z5;
                try {
                    if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        j boh = NewSubPbActivity.this.glB.boh();
                        TbRichText aM = NewSubPbActivity.this.aM(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (aM != null && aM.Sx() != null) {
                            tbRichTextData = aM.Sx().get(NewSubPbActivity.this.fXS);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.SD().SP()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (boh == null) {
                                    str3 = null;
                                    z4 = false;
                                } else {
                                    if (boh.bim() != null) {
                                        str4 = boh.bim().getName();
                                        str5 = boh.bim().getId();
                                    }
                                    if (boh.aaq() != null) {
                                        str6 = boh.aaq().getId();
                                    }
                                    str3 = str6;
                                    z4 = true;
                                }
                                if (NewSubPbActivity.this.glB.bot() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.glB.bot();
                                    z5 = NewSubPbActivity.this.glB.bov();
                                    arrayList2 = NewSubPbActivity.this.glB.bou();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z5 = z4;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.d(arrayList2, 0));
                                NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                                return;
                            }
                            NewSubPbActivity.this.fXT = false;
                            String str7 = "";
                            TbRichText bEU = boh.big().bEU();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(bEU, aM, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (boh == null) {
                                str2 = null;
                                z2 = false;
                            } else {
                                if (boh.bim() != null) {
                                    str8 = boh.bim().getName();
                                    str9 = boh.bim().getId();
                                }
                                if (boh.aaq() != null) {
                                    str10 = boh.aaq().getId();
                                }
                                str2 = str10;
                                z2 = true;
                            }
                            if (NewSubPbActivity.this.glB.bot() != null) {
                                concurrentHashMap = NewSubPbActivity.this.glB.bot();
                                z3 = NewSubPbActivity.this.glB.bov();
                                arrayList = NewSubPbActivity.this.glB.bou();
                                i2 = a2 + NewSubPbActivity.this.glB.getOffset();
                            } else {
                                concurrentHashMap = concurrentHashMap3;
                                i2 = a2;
                                z3 = z2;
                                arrayList = arrayList2;
                            }
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(v.d(arrayList, i2));
                            NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList4, 0, str8, str9, str2, z3, str7, true, concurrentHashMap, true, false, false)));
                            return;
                        }
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
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
    public void bx(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(e.g.tag_clip_board)) != null) {
            f(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo SD;
        if (tbRichText == tbRichText2) {
            this.fXT = true;
        }
        if (tbRichText != null && tbRichText.Sx() != null) {
            int size = tbRichText.Sx().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Sx().get(i6) != null && tbRichText.Sx().get(i6).getType() == 8) {
                    i5++;
                    int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                    int width = tbRichText.Sx().get(i6).SD().getWidth() * aR;
                    int height = tbRichText.Sx().get(i6).SD().getHeight() * aR;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Sx().get(i6).SD().SP()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Sx().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (SD = tbRichTextData.SD()) != null) {
                            String SS = SD.SS();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = SS;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.fXT) {
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
        if (this.fWT != null) {
            this.fWT.lb(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo SD = tbRichTextData.SD();
        if (SD != null) {
            if (!StringUtils.isNull(SD.SO())) {
                return SD.SO();
            }
            if (SD.getHeight() * SD.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (SD.getHeight() * SD.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (SD.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * SD.getHeight())));
            } else {
                float width = SD.getWidth() / SD.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ao.bx(SD.SQ()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aM(String str, int i) {
        if (this.glB == null || this.glB.boh() == null || str == null || i < 0) {
            return null;
        }
        j boh = this.glB.boh();
        TbRichText a2 = a(boh.big(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(boh.big(), str, i);
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
        TbRichText bEU = postData.bEU();
        if (bEU != null) {
            ArrayList<TbRichTextData> Sx = bEU.Sx();
            int size = Sx.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Sx.get(i3) != null && Sx.get(i3).getType() == 8) {
                    i2++;
                    if (Sx.get(i3).SD().SS().equals(str)) {
                        int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                        int width = Sx.get(i3).SD().getWidth() * aR;
                        int height = Sx.get(i3).SD().getHeight() * aR;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.fXS = i3;
                        return bEU;
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
    public boolean kJ(boolean z) {
        if (this.glB == null) {
            return false;
        }
        return ((bhL() != 0) || this.glB.boh() == null || this.glB.boh().aaq() == null || this.glB.boh().aaq().zT() == null || TextUtils.equals(this.glB.boh().aaq().zT().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Context context, String str, String str2) {
        long templateId = this.glB.boh().big().bFb() != null ? this.glB.boh().big().bFb().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ay.Es().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.glB.boh().bim().getId(), this.glB.boh().bim().getName(), this.glB.boh().aaq().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(int i, String str) {
        if (this.glB.boi()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.ll()) {
            if (i == 4) {
                this.glD.oH(str + "(4)");
            } else {
                this.glD.kf(e.j.no_data_text);
            }
        } else {
            this.glD.kf(e.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.fiT = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().bM(getActivity());
        if (this.fiT != null) {
            this.fiT.setContext(getPageContext());
            this.fiT.b(this.glB);
            this.fiT.b(this.glS);
            this.fiT.a(this.baN);
            this.fiT.a(this.baO);
            this.fiT.Mp().ct(true);
            this.fiT.d(getPageContext());
        }
        if (this.glD != null) {
            this.glD.g(this.fiT);
        }
        if (this.fiT != null && this.glB != null) {
            this.fiT.a(this.glB.aBj());
            this.fiT.Nl();
        }
        if (this.fiT != null) {
            this.giN = this.fiT.Np().getInputView();
            this.giN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.glQ != null) {
                        if (!NewSubPbActivity.this.glQ.bOw()) {
                            NewSubPbActivity.this.lO(false);
                        }
                        NewSubPbActivity.this.glQ.ov(false);
                    }
                }
            });
        }
    }

    public void bnL() {
        if (!TbadkCoreApplication.isLogin()) {
            this.fiT.Nl();
        } else if (!StringUtils.isNull(this.glB.bop())) {
            if (this.glD.bnR() && com.baidu.adp.lib.util.l.ll()) {
                this.glD.ayr();
            } else {
                this.glD.bnU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(e.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(e.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(e.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(e.g.tag_from, 1);
                    b(sparseArray);
                } else {
                    this.glD.bF(view);
                }
            } else if (booleanValue2) {
                this.glD.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.glD.boa(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        final String str;
        if (!(sparseArray.get(e.g.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(e.g.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(e.g.tag_user_mute_visible)).booleanValue()) {
            String[] strArr = new String[1];
            strArr[0] = z ? getResources().getString(e.j.un_mute) : getResources().getString(e.j.mute);
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            bVar.de(e.j.operation);
            bVar.a(strArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    switch (i) {
                        case 0:
                            String str2 = "";
                            String str3 = "";
                            String str4 = "";
                            String str5 = "";
                            String str6 = "";
                            if (sparseArray.get(e.g.tag_user_mute_mute_username) instanceof String) {
                                str2 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
                            }
                            if (sparseArray.get(e.g.tag_user_mute_thread_id) instanceof String) {
                                str3 = (String) sparseArray.get(e.g.tag_user_mute_thread_id);
                            }
                            if (sparseArray.get(e.g.tag_user_mute_post_id) instanceof String) {
                                str4 = (String) sparseArray.get(e.g.tag_user_mute_post_id);
                            }
                            if (sparseArray.get(e.g.tag_user_mute_msg) instanceof String) {
                                str5 = (String) sparseArray.get(e.g.tag_user_mute_msg);
                            }
                            if (sparseArray.get(e.g.tag_user_mute_mute_nameshow) instanceof String) {
                                str6 = (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow);
                            }
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.glN);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.glN);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).BV();
        }
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(e.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(e.g.tag_user_mute_mute_userid);
        }
        this.glD.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.glN;
        userMuteCheckCustomMessage.setTag(this.glN);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.glD.a(0, bVar.HZ, bVar.hsd, z);
            if (bVar.HZ) {
                if (bVar.hsb == 1) {
                    if (this.glD.getListView() instanceof BdTypeListView) {
                        List<com.baidu.adp.widget.ListView.h> data = ((BdTypeListView) this.glD.getListView()).getData();
                        if (!v.I(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            data.remove(i);
                            this.glD.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.hsb == 2) {
                    this.glB.tJ(bVar.mPostId);
                    this.glD.a(this.glB.boh(), this.glB.bhL(), this.glB.bot() != null);
                    if (this.glB.boq()) {
                        this.glB.lR(false);
                        this.glD.bnP();
                        this.glB.OP();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
            }
        }
    }

    public void tj(String str) {
        this.fWL.tF(str);
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.glB.isMarked() && postData.getId() != null && postData.getId().equals(this.glB.boo())) {
                z = true;
            }
            MarkData j = this.glB.j(postData);
            if (j != null) {
                this.glD.bmF();
                if (this.fWM != null) {
                    this.fWM.a(j);
                    if (!z) {
                        this.fWM.wz();
                    } else {
                        this.fWM.wy();
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
        if (bundle != null && this.glB != null) {
            this.glB.G(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.fiT != null) {
            this.fiT.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.fiT.Mp().KM();
        this.fiT.Nl();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.fiT.b(writeData);
                this.fiT.setVoiceModel(pbEditorData.getVoiceModel());
                k fL = this.fiT.Mp().fL(6);
                if (fL != null && fL.aYW != null) {
                    fL.aYW.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.fiT.Nh();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dLA != null) {
            this.dLA.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.glL = true;
        super.onPause();
        if (this.dLA != null) {
            this.dLA.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.eME);
        this.glD.aFm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.glL = false;
        super.onResume();
        if (this.dLA != null) {
            this.dLA.onResume(getPageContext());
        }
        registerListener(this.eME);
        this.glD.aFn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dLA != null) {
            this.dLA.onStop(getPageContext());
        }
        this.fiT.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.glR));
        this.glB.cancelLoadData();
        this.glB.destory();
        this.glC.cancelLoadData();
        if (this.dLA != null) {
            this.dLA.onDestory(getPageContext());
        }
        this.glD.bmF();
        this.glD.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.fXI);
        MessageManager.getInstance().unRegisterListener(this.fXJ);
        MessageManager.getInstance().unRegisterListener(this.fXK);
        MessageManager.getInstance().unRegisterListener(this.glN);
        this.fXf = null;
        this.fXg = null;
        if (this.dMm != null) {
            this.dMm.onDestroy();
        }
        if (this.fiL != null) {
            this.fiL.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.glD.onChangeSkinType(i);
        if (this.dMm != null) {
            this.dMm.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dLA;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bnV = this.glD.bnV();
        if (bnV == null || (findViewWithTag = bnV.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean ty(String str) {
        Map<String, String> gb;
        if (!TextUtils.isEmpty(str) && (gb = ay.gb(ay.gc(str))) != null) {
            this.glO = true;
            String str2 = gb.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return ty(com.baidu.adp.lib.util.k.by(str2));
            }
            String str3 = gb.get(glA);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (ty(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                    kVar.mLink = str;
                    kVar.type = 3;
                    kVar.aYa = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
                }
            } else {
                ay.Es().c(getPageContext(), new String[]{str});
            }
            this.glO = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void al(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.glO = true;
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
    public void k(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.glD != null) {
            return this.glD.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Te() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Tg() {
        if (this.bsw == null) {
            this.bsw = TbRichTextView.n(getPageContext().getPageActivity(), 8);
        }
        return this.bsw;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Th() {
        if (this.bsA == null) {
            this.bsA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bjJ */
                public GifView jz() {
                    return new GifView(NewSubPbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void u(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView v(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView w(GifView gifView) {
                    return gifView;
                }
            }, 20, 0);
        }
        return this.bsA;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Tf() {
        if (this.bsv == null) {
            this.bsv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: amT */
                public ImageView jz() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean xV = i.xR().xV();
                    foreDrawableImageView.setDefaultBg(al.getDrawable(e.d.common_color_10220));
                    if (xV) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(e.f.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public void u(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(e.d.cp_bg_line_c);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: b */
                public ImageView v(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (i.xR().xV()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(e.f.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public ImageView w(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(e.d.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.bsv;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Ti() {
        if (this.bsx == null) {
            this.bsx = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bjK */
                public View jz() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(e.C0210e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bA */
                public void u(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bB */
                public View v(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bC */
                public View w(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.bsx;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Tj() {
        if (this.bsy == null) {
            this.bsy = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bjM */
                public LinearLayout jz() {
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
                public void u(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: e */
                public LinearLayout v(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: f */
                public LinearLayout w(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.bsy;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Tk() {
        this.bsz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bjL */
            public RelativeLayout jz() {
                return new RelativeLayout(NewSubPbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void u(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout v(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout w(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.bsz;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bis() {
        return this.fWO;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bit() {
        return (this.glB == null || this.glB.boh() == null || this.glB.boh().aaq() == null || this.glB.boh().aaq().Be()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String biu() {
        if (this.glB == null || this.glB.boh() == null || this.glB.boh().aaq() == null) {
            return null;
        }
        return this.glB.boh().aaq().zZ();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int biv() {
        if (this.glB == null) {
            return 0;
        }
        return this.glB.bhL();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean tg(String str) {
        if (StringUtils.isNull(str) || this.glB == null || this.glB.boh() == null || this.glB.boh().aaq() == null || this.glB.boh().aaq().zT() == null) {
            return false;
        }
        return str.equals(this.glB.boh().aaq().zT().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.glD.bnR() && com.baidu.adp.lib.util.l.ll()) {
            this.glB.OP();
        } else {
            this.glD.bnU();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (sparseArray.get(e.g.tag_user_mute_mute_username) instanceof String) {
            str3 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(e.g.tag_user_mute_thread_id) instanceof String) {
            str4 = (String) sparseArray.get(e.g.tag_user_mute_thread_id);
        }
        if (!(sparseArray.get(e.g.tag_user_mute_post_id) instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) sparseArray.get(e.g.tag_user_mute_post_id);
        }
        String str7 = sparseArray.get(e.g.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(e.g.tag_user_mute_msg) : str2;
        if (sparseArray.get(e.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(e.g.tag_user_mute_msg);
        }
        if (sparseArray.get(e.g.tag_user_mute_mute_nameshow) instanceof String) {
            str6 = (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.glN);
        userMuteAddAndDelCustomMessage.setTag(this.glN);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tH(String str) {
        if (!StringUtils.isNull(str) && ba.bJ(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("bubble_link", "");
            if (!StringUtils.isNull(string)) {
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                    return;
                }
                com.baidu.tbadk.browser.a.a(getPageContext().getPageActivity(), getResources().getString(e.j.editor_privilege), string + "?props_id=" + str, true, true, true);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ap(Context context, String str) {
        n(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean Pf() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Pg() {
                return com.baidu.tbadk.pageStayDuration.e.Pk().Pm();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.glB != null) {
            if (this.glB.boh() != null && this.glB.boh().bim() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.glB.boh().bim().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.glB.bkt(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.glL;
    }

    public boolean bnM() {
        if (this.glB != null) {
            return this.glB.bnM();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.glD.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fXf.getPageActivity());
        if (ao.isEmpty(str)) {
            aVar.eK(this.fXf.getResources().getString(e.j.block_mute_message_alert, str3));
        } else {
            aVar.eK(str);
        }
        aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.glD.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fXf).BS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ij(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fXf.getPageActivity());
        aVar.eK(str);
        aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fXf).BS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.eK(getResources().getString(e.j.mute_is_super_member_function));
        aVar.a(e.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.fXf).showToast(e.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.fXf.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fXf).BS();
    }

    public int bhL() {
        if (this.glB != null) {
            return this.glB.bhL();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.aZt) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.aZt) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void lO(boolean z) {
        if (this.giN != null && this.giN.getText() != null) {
            int selectionEnd = this.giN.getSelectionEnd();
            SpannableStringBuilder b = this.glQ.b(this.giN.getText());
            if (b != null) {
                this.glQ.ov(true);
                this.giN.setText(b);
                if (z && this.glQ.bOu() >= 0) {
                    this.giN.requestFocus();
                    this.giN.setSelection(this.glQ.bOu());
                } else {
                    this.giN.setSelection(selectionEnd);
                }
                this.glQ.ou(this.glQ.bOu() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.dMm == null) {
            this.dMm = new h(getPageContext());
            this.dMm.a(new h.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void bo(boolean z) {
                    if (z) {
                        TiebaStatic.log(new am("c13061"));
                    }
                }
            });
        }
        this.dMm.a(contriInfo, -1L);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.fiT != null && this.fiT.Mp() != null && this.fiT.Mp().Ms()) {
            this.fiT.Mp().KM();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.k kVar) {
        ad.a(kVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(kVar, getUniqueId(), this);
    }
}
