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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.g;
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
    private static final String fZt = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String gaN = "tbgametype";
    private View.OnLongClickListener aPP;
    private com.baidu.adp.lib.e.b<ImageView> bog;
    private com.baidu.adp.lib.e.b<TextView> boh;
    private com.baidu.adp.lib.e.b<View> boi;
    private com.baidu.adp.lib.e.b<LinearLayout> boj;
    private com.baidu.adp.lib.e.b<RelativeLayout> bok;
    private com.baidu.adp.lib.e.b<GifView> bol;
    private com.baidu.tbadk.core.util.b.a bvI;
    private VoiceManager dBD;
    private h dCp;
    public aj eYo;
    private g eYw;
    private com.baidu.tbadk.core.view.g fMA;
    private av fMD;
    private com.baidu.adp.widget.ImageView.a fME;
    private String fMF;
    private TbRichTextMemeInfo fMG;
    private com.baidu.tieba.pb.pb.report.a fMf;
    private com.baidu.tbadk.baseEditMark.a fMg;
    private com.baidu.tieba.pb.pb.main.b.a fMi;
    private y fMn;
    private com.baidu.adp.base.e fMz;
    private b.InterfaceC0148b fNp;
    private PostWriteCallBackData fQQ;
    private EditText fXZ;
    private SubPbModel gaO;
    private ForumManageModel gaP;
    private b gaQ;
    private AbsListView.OnScrollListener gaR;
    private TbRichTextView.i gaS;
    private TbRichTextView.h gaT;
    private SubPbModel.a gaU;
    private com.baidu.adp.base.d gaV;
    private BdUniqueId gba;
    private com.baidu.tieba.pb.pb.sub.a gbc;
    private com.baidu.tieba.write.b gbd;
    private com.baidu.tieba.pb.d<j> gbe;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int fNm = 0;
    PostData fNo = null;
    private a.InterfaceC0144a fNj = null;
    private a gaW = null;
    private a gaX = null;
    private boolean gaY = false;
    private boolean gaZ = false;
    private boolean gbb = false;
    private boolean aVi = false;
    private com.baidu.tbadk.editortools.pb.c aWB = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Lr() {
            NewSubPbActivity.this.gaQ.bkH();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aWC = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Lq() {
            if (!NewSubPbActivity.this.gbd.bKR()) {
                return (NewSubPbActivity.this.eYo == null || NewSubPbActivity.this.gaO == null || NewSubPbActivity.this.gaO.ayn() == null || NewSubPbActivity.this.eYo.w(NewSubPbActivity.this.gaO.ayn().replyPrivateFlag, aj.ayx)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.gbd.bKT());
            if (NewSubPbActivity.this.eYw.LG()) {
                NewSubPbActivity.this.eYw.a(NewSubPbActivity.this.fQQ);
            }
            NewSubPbActivity.this.lI(true);
            return true;
        }
    };
    private NewWriteModel.d gbf = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.eYw != null && NewSubPbActivity.this.eYw.KT() != null) {
                NewSubPbActivity.this.eYw.KT().hide();
                if (NewSubPbActivity.this.gaO.blb()) {
                    TiebaStatic.log(new am("c10367").ax("post_id", NewSubPbActivity.this.gaO.Lo()));
                }
            }
            if (z) {
                NewSubPbActivity.this.gbd.wO(null);
                NewSubPbActivity.this.gbd.az(null);
                NewSubPbActivity.this.gbd.oo(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    NewSubPbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.gbd.az(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.gbd.wO(postWriteCallBackData.getErrorString());
                if (!v.I(NewSubPbActivity.this.gbd.bKP())) {
                    NewSubPbActivity.this.fQQ = postWriteCallBackData;
                    if (NewSubPbActivity.this.eYw.LG()) {
                        NewSubPbActivity.this.eYw.a(NewSubPbActivity.this.fQQ);
                    }
                    NewSubPbActivity.this.lI(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.eYo != null) {
                NewSubPbActivity.this.eYo.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.gaQ.bkI();
        }
    };
    private CustomMessageListener fNc = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.gba) {
                NewSubPbActivity.this.gaQ.ajH();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fMA.e(NewSubPbActivity.this.fMz.getResources().getString(e.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.fMz.getResources().getString(e.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.hC(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bgx();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ao.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.fMz.getResources().getString(e.j.mute_fail);
                    }
                    NewSubPbActivity.this.fMA.f(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fNd = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.gba) {
                NewSubPbActivity.this.gaQ.ajH();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fMA.e(NewSubPbActivity.this.fMz.getResources().getString(e.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ao.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.fMz.getResources().getString(e.j.un_mute_fail);
                }
                NewSubPbActivity.this.fMA.f(muteMessage);
            }
        }
    };
    private CustomMessageListener fNe = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.gba) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.gaQ.ajH();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.hsk;
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
                    NewSubPbActivity.this.gaQ.a(sparseArray, z);
                }
            }
        }
    };
    boolean fNn = false;
    private final b.InterfaceC0148b fNq = new b.InterfaceC0148b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.fME != null && !TextUtils.isEmpty(NewSubPbActivity.this.fMF)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.fMG == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.fMF));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.fMF;
                        aVar.pkgId = NewSubPbActivity.this.fMG.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.fMG.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.bvI == null) {
                        NewSubPbActivity.this.bvI = new com.baidu.tbadk.core.util.b.a();
                    }
                    NewSubPbActivity.this.bvI.Dp();
                    NewSubPbActivity.this.bvI.c(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.bvI.A(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.fMD == null) {
                            NewSubPbActivity.this.fMD = new av(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.fMD.i(NewSubPbActivity.this.fMF, NewSubPbActivity.this.fME.ot());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.fME = null;
                NewSubPbActivity.this.fMF = null;
            }
        }
    };
    private CustomMessageListener eCl = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener dCM = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    com.baidu.tbadk.data.j jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.gaO.bkV() != null && NewSubPbActivity.this.gaO.bkV().bfa() != null && NewSubPbActivity.this.gaO.bkV().bfa().yC() != null && currentAccount.equals(NewSubPbActivity.this.gaO.bkV().bfa().yC().getUserId()) && NewSubPbActivity.this.gaO.bkV().bfa().yC().getPendantData() != null) {
                        NewSubPbActivity.this.gaO.bkV().bfa().yC().getPendantData().dR(jVar.xn());
                        NewSubPbActivity.this.gaO.bkV().bfa().yC().getPendantData().ah(jVar.KA());
                        NewSubPbActivity.this.gaQ.a(NewSubPbActivity.this.gaO.bkV().bfa(), NewSubPbActivity.this.gaO.bkV().aRK(), NewSubPbActivity.this.gaO.bkV().vm(), NewSubPbActivity.this.gaO.beF(), NewSubPbActivity.this.gaO.blh() != null);
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
        E(bundle);
        if (this.aVi) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.fMz = getPageContext();
        this.gaZ = true;
        this.gbd = new com.baidu.tieba.write.b();
        this.gbd.wz(e.d.cp_cont_h_alpha85);
        this.gbd.wy(e.d.cp_cont_i);
        aDk();
        bky();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bkx();
        this.fMA = new com.baidu.tbadk.core.view.g();
        this.fMA.aDC = 1000L;
        registerListener(this.fNe);
        registerListener(this.fNc);
        registerListener(this.fNd);
        this.gba = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.gba;
        userMuteAddAndDelCustomMessage.setTag(this.gba);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.gba;
        userMuteCheckCustomMessage.setTag(this.gba);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eYo = new aj(getPageContext());
        this.eYo.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.eYw.LL();
                }
            }
        });
        this.fMf = new com.baidu.tieba.pb.pb.report.a(this);
        this.fMf.o(getUniqueId());
        this.fMi = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    private void bkx() {
        if (this.gaQ != null && this.gaO != null && this.gaO.bkA()) {
            this.gbc = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.gaQ.aaO());
            this.gbc.aDp();
            this.gbc.a(new a.InterfaceC0279a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
                private boolean dPN = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0279a
                public void aDl() {
                    NewSubPbActivity.this.gaQ.he(false);
                    this.dPN = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0279a
                public void aDm() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0279a
                public boolean aDn() {
                    if (!this.dPN) {
                        return NewSubPbActivity.this.gaQ.aDB() != null && NewSubPbActivity.this.gaQ.aDB().getTop() == 0;
                    }
                    this.dPN = false;
                    return false;
                }
            });
            this.gaQ.e(this.gbc);
            this.gaQ.he(true);
        }
    }

    public void initUI() {
        this.gaQ = new b(this, this.mCommonClickListener);
        this.gaQ.a(this.gaO);
        setContentView(this.gaQ.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.gaQ.setOnScrollListener(this.gaR);
        this.gaQ.a(this);
        this.gaQ.setOnLinkImageClickListener(this.gaS);
        this.gaQ.setOnImageClickListener(this.gaT);
        this.gaQ.kw(true);
        this.gaQ.setOnLongClickListener(this.aPP);
        this.gaQ.c(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.gaO != null) {
                    NewSubPbActivity.this.gaO.Ns();
                }
            }
        });
        this.gaQ.a(this.gaW);
        this.gaQ.b(this.gaX);
        if (this.gaO != null && this.gaO.bkA() && !this.gaO.blg()) {
            this.gaQ.bkM().setVisibility(8);
        } else {
            this.gaQ.bkM().setVisibility(0);
        }
        if (this.gaO != null && !this.gaO.bkA()) {
            this.gaQ.setIsFromPb(false);
        }
    }

    private boolean E(Bundle bundle) {
        if (bundle != null) {
            this.aVi = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.aVi = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.aVi;
    }

    public void initData(Bundle bundle) {
        this.gaO = new SubPbModel(getPageContext());
        this.gaO.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.gaQ.n(postData);
                NewSubPbActivity.this.gaQ.a((BdListView.e) null);
            }
        });
        this.gaP = new ForumManageModel(getPageContext());
        this.gaP.setLoadDataCallBack(this.gaV);
        this.dBD = new VoiceManager();
        this.dBD.onCreate(getPageContext());
        this.fMg = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fMg != null) {
            this.fMg.a(this.fNj);
        }
        if (bundle != null) {
            this.gaO.initWithBundle(bundle);
        } else {
            this.gaO.initWithIntent(getIntent());
        }
        this.gaO.a(this.gaU);
        if (this.gaO.bkA()) {
            this.gaO.Ns();
        } else {
            this.gaO.bla();
        }
    }

    public void bky() {
        this.gaU = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, j jVar) {
                if (NewSubPbActivity.this.gaQ != null) {
                    NewSubPbActivity.this.gaQ.bkI();
                }
                if (NewSubPbActivity.this.gbc != null && NewSubPbActivity.this.gbc.aDq()) {
                    NewSubPbActivity.this.gbc.my(e.d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.ae(i, str);
                    return;
                }
                NewSubPbActivity.this.gaQ.hideNoDataView();
                if (jVar != null) {
                    if (jVar.bfa() != null || NewSubPbActivity.this.gaO != null) {
                        jVar.bfa().a(NewSubPbActivity.this.gaO.blf());
                    }
                    if (NewSubPbActivity.this.gaQ != null) {
                        NewSubPbActivity.this.gaQ.a(jVar, NewSubPbActivity.this.gaO.beF(), NewSubPbActivity.this.gaO.blh() != null);
                        if (NewSubPbActivity.this.gaZ) {
                            NewSubPbActivity.this.bkz();
                            NewSubPbActivity.this.gaZ = false;
                        }
                    }
                    if (NewSubPbActivity.this.eYw != null) {
                        NewSubPbActivity.this.eYw.a(jVar.ayn());
                    }
                    if (NewSubPbActivity.this.gbe == null) {
                        NewSubPbActivity.this.gbe = new com.baidu.tieba.pb.d();
                    }
                    NewSubPbActivity.this.gbe.setData(jVar);
                    NewSubPbActivity.this.gbe.setType(0);
                    NewSubPbActivity.this.eYo.a(NewSubPbActivity.this.gaO.blk());
                }
            }
        };
        this.fNj = new a.InterfaceC0144a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0144a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.fMg != null) {
                        NewSubPbActivity.this.fMg.aO(z2);
                    }
                    MarkData vp = NewSubPbActivity.this.fMg.vp();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setType(2);
                    if (z2) {
                        dVar.setData(vp);
                        if (NewSubPbActivity.this.fMg != null) {
                            if (vp != null) {
                                NewSubPbActivity.this.gaO.lK(true);
                                NewSubPbActivity.this.gaO.sP(NewSubPbActivity.this.gaO.Lo());
                                NewSubPbActivity.this.showToast(e.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(e.j.add_mark));
                            }
                            if (NewSubPbActivity.this.gaQ != null) {
                                NewSubPbActivity.this.gaQ.lJ(true);
                            }
                        }
                    } else {
                        dVar.setData(null);
                        NewSubPbActivity.this.gaO.lK(false);
                        NewSubPbActivity.this.gaO.sP(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(e.j.remove_mark));
                        if (NewSubPbActivity.this.gaQ != null) {
                            NewSubPbActivity.this.gaQ.lJ(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(e.j.update_mark_failed));
            }
        };
        this.gaW = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.gaO.bkV() != null && NewSubPbActivity.this.gaO.bkV().YL() != null && NewSubPbActivity.this.gaO.bkV().YL().yC() != null) {
                    str = String.valueOf(NewSubPbActivity.this.gaO.bkV().YL().yC().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.gaO.bkV().bfg().getId(), NewSubPbActivity.this.gaO.bkV().bfg().getName(), NewSubPbActivity.this.gaO.bkV().YL().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.gaX = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.gaP.bCi() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int l = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[1]), 0);
                        boolean g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[2]), false);
                        int l2 = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.gaO != null && NewSubPbActivity.this.gaO.bkV() != null && NewSubPbActivity.this.gaO.bkV().bfg() != null && NewSubPbActivity.this.gaO.bkV().YL() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.gaP.vi(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.gaP.a(NewSubPbActivity.this.gaO.bkV().bfg().getId(), NewSubPbActivity.this.gaO.bkV().bfg().getName(), NewSubPbActivity.this.gaO.bkV().YL().getId(), valueOf, l2, l, g);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.gaV = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.gaQ.a(NewSubPbActivity.this.gaP.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.gaP.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.gbS != 1002 || bVar.egp) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.gaQ.a(1, dVar.HZ, dVar.hgO, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean bv(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void aDk() {
        registerListener(this.dCM);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v48, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.gaQ != null) {
                    if (view == NewSubPbActivity.this.gaQ.bkS()) {
                        NewSubPbActivity.this.gaQ.bjt();
                        String str = view.getTag(e.g.tag_user_id) instanceof String ? (String) view.getTag(e.g.tag_user_id) : null;
                        String str2 = view.getTag(e.g.tag_user_name) instanceof String ? (String) view.getTag(e.g.tag_user_name) : null;
                        String str3 = view.getTag(e.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(e.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ay.Db().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.gaQ.aDC()) {
                        if (view != NewSubPbActivity.this.gaQ.bkL()) {
                            if (view != NewSubPbActivity.this.gaQ.bkK()) {
                                if (view == NewSubPbActivity.this.gaQ.bkG()) {
                                    NewSubPbActivity.this.gaQ.bjt();
                                    if (NewSubPbActivity.this.gaO.Ns()) {
                                        NewSubPbActivity.this.gaQ.bkE();
                                    }
                                } else if (view == NewSubPbActivity.this.gaQ.bkM() || view == NewSubPbActivity.this.gaQ.bkN() || view == NewSubPbActivity.this.gaQ.bkP()) {
                                    if (NewSubPbActivity.this.gbb) {
                                        NewSubPbActivity.this.gbb = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.gaO.bhm(), NewSubPbActivity.this.gaO.Lo(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.gaO.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.gaO.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.gaQ.bkQ() == null || view != NewSubPbActivity.this.gaQ.bkQ().bhY()) {
                                    if (NewSubPbActivity.this.gaQ.bkQ() == null || view != NewSubPbActivity.this.gaQ.bkQ().bib()) {
                                        if (NewSubPbActivity.this.gaQ.bkQ() == null || view != NewSubPbActivity.this.gaQ.bkQ().bhZ()) {
                                            if (NewSubPbActivity.this.gaQ.bkQ() == null || view != NewSubPbActivity.this.gaQ.bkQ().bia()) {
                                                if (NewSubPbActivity.this.gaQ.bkQ() == null || view != NewSubPbActivity.this.gaQ.bkQ().bic()) {
                                                    if (view == NewSubPbActivity.this.gaQ.bkJ() || view == NewSubPbActivity.this.gaQ.bkP()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.eYw.LO()) {
                                                                NewSubPbActivity.this.eYw.LP();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.eYw.hD(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof com.baidu.tieba.pb.pb.main.j)) {
                                                        if (NewSubPbActivity.this.fMn == null || view != NewSubPbActivity.this.fMn.bia()) {
                                                            if (NewSubPbActivity.this.fMn == null || view != NewSubPbActivity.this.fMn.bhY()) {
                                                                if (NewSubPbActivity.this.fMn == null || view != NewSubPbActivity.this.fMn.bib()) {
                                                                    if (NewSubPbActivity.this.fMn == null || view != NewSubPbActivity.this.fMn.bic()) {
                                                                        if (NewSubPbActivity.this.fMn == null || view != NewSubPbActivity.this.fMn.bie()) {
                                                                            if (NewSubPbActivity.this.fMn == null || view != NewSubPbActivity.this.fMn.bif()) {
                                                                                if (NewSubPbActivity.this.fMn != null && view == NewSubPbActivity.this.fMn.bhZ()) {
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
                                                                                            NewSubPbActivity.this.gaQ.bC(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.gaQ.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                            return;
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                int id = view.getId();
                                                                                if (id == e.g.pb_item_tail_content) {
                                                                                    if (ba.bG(NewSubPbActivity.this.getPageContext().getPageActivity())) {
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
                                                                                        if (postData.getType() != PostData.heu && !TextUtils.isEmpty(postData.getBimg_url()) && i.wA().wE()) {
                                                                                            NewSubPbActivity.this.sM(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.fME != null && !TextUtils.isEmpty(NewSubPbActivity.this.fMF)) {
                                                                                if (NewSubPbActivity.this.bvI == null) {
                                                                                    NewSubPbActivity.this.bvI = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.bvI.Dp();
                                                                                NewSubPbActivity.this.bvI.c(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.bvI.A(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.fMD == null) {
                                                                                        NewSubPbActivity.this.fMD = new av(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.fMD.i(NewSubPbActivity.this.fMF, NewSubPbActivity.this.fME.ot());
                                                                                    NewSubPbActivity.this.fME = null;
                                                                                    NewSubPbActivity.this.fMF = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.fME != null && !TextUtils.isEmpty(NewSubPbActivity.this.fMF)) {
                                                                            if (NewSubPbActivity.this.fMG == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.fMF));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.fMF;
                                                                                aVar.pkgId = NewSubPbActivity.this.fMG.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.fMG.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.fME = null;
                                                                            NewSubPbActivity.this.fMF = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.fNo != null) {
                                                                        NewSubPbActivity.this.fNo.cV(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.fNo = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                if (sparseArray2 != null && (sparseArray2.get(e.g.tag_del_post_type) instanceof Integer) && (sparseArray2.get(e.g.tag_del_post_id) instanceof String) && (sparseArray2.get(e.g.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.gaQ.a(((Integer) sparseArray2.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(e.g.tag_del_post_id), ((Integer) sparseArray2.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.bu(view);
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
                                                                NewSubPbActivity.this.sn((String) tag);
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
                                                    } else if (ba.bG(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                        if (NewSubPbActivity.this.gbb) {
                                                            NewSubPbActivity.this.gbb = false;
                                                            return;
                                                        } else if (NewSubPbActivity.this.eYo == null || NewSubPbActivity.this.gaO == null || NewSubPbActivity.this.gaO.ayn() == null || NewSubPbActivity.this.eYo.dw(NewSubPbActivity.this.gaO.ayn().replyPrivateFlag)) {
                                                            if (NewSubPbActivity.this.gbc != null) {
                                                                NewSubPbActivity.this.gbc.aDo();
                                                            }
                                                            SparseArray sparseArray4 = (SparseArray) view.getTag(e.g.tag_from);
                                                            if (sparseArray4 != null && (sparseArray4.get(e.g.tag_clip_board) instanceof PostData)) {
                                                                PostData postData2 = (PostData) sparseArray4.get(e.g.tag_clip_board);
                                                                if (postData2 != null && postData2.yC() != null) {
                                                                    MetaData yC = postData2.yC();
                                                                    NewSubPbActivity.this.eYw.setReplyId(yC.getUserId());
                                                                    if (!(sparseArray4.get(e.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray4.get(e.g.tag_is_subpb)).booleanValue() : true)) {
                                                                        NewSubPbActivity.this.eYw.hG("");
                                                                    } else {
                                                                        NewSubPbActivity.this.eYw.hG(yC.getName_show());
                                                                    }
                                                                }
                                                                NewSubPbActivity.this.gaQ.bkC();
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
                                                        ((PostData) sparseArray5.get(e.g.tag_clip_board)).cV(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new am("c11739").x("obj_locate", 4));
                                            if (!com.baidu.adp.lib.util.j.kV()) {
                                                NewSubPbActivity.this.showToast(e.j.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.gaQ.bjt();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.sn(str4);
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
                                            NewSubPbActivity.this.gaQ.bjt();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.bG(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(e.j.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.gaQ.bjt();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.gaQ.a(((Integer) sparseArray7.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray7.get(e.g.tag_del_post_id), ((Integer) sparseArray7.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(e.g.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new am("c11739").x("obj_locate", 2));
                                    NewSubPbActivity.this.gaQ.bjt();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.gaO.bkV() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.gaO.bkV().bfa());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.gaQ.bkB();
                                NewSubPbActivity.this.gaQ.bkC();
                                if (NewSubPbActivity.this.eYw != null) {
                                    NewSubPbActivity.this.eYw.LR();
                                    if (NewSubPbActivity.this.gbc != null) {
                                        NewSubPbActivity.this.gbc.aDo();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.gaQ.bkB();
                            NewSubPbActivity.this.gaQ.bkC();
                            if (NewSubPbActivity.this.eYw != null) {
                                NewSubPbActivity.this.eYw.LQ();
                                if (NewSubPbActivity.this.gbc != null) {
                                    NewSubPbActivity.this.gbc.aDo();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.eYo == null || NewSubPbActivity.this.gaO == null || NewSubPbActivity.this.gaO.ayn() == null || NewSubPbActivity.this.eYo.dw(NewSubPbActivity.this.gaO.ayn().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.eYw.LG()) {
                                NewSubPbActivity.this.eYw.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.gaQ.bkB();
                            NewSubPbActivity.this.gaQ.bkC();
                            if (NewSubPbActivity.this.eYw != null) {
                                NewSubPbActivity.this.eYw.LS();
                                if (NewSubPbActivity.this.gbc != null) {
                                    NewSubPbActivity.this.gbc.aDo();
                                }
                            }
                        }
                    }
                }
            }
        };
        this.gaR = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.gaQ.bjt();
                }
                NewSubPbActivity.this.eYw.LP();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.gaQ.bkR();
            }
        };
        this.fNp = new b.InterfaceC0148b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.gaO.bkV() != null) {
                    postData = NewSubPbActivity.this.gaO.bkV().bfa();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.cV(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.f(postData);
                    }
                }
            }
        };
        this.aPP = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                if (sparseArray == null && NewSubPbActivity.this.bv(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.fME = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.fMF = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.fME != null && !TextUtils.isEmpty(NewSubPbActivity.this.fMF)) {
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.fMG = null;
                            } else {
                                NewSubPbActivity.this.fMG = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                NewSubPbActivity.this.gaQ.a(NewSubPbActivity.this.fNq, NewSubPbActivity.this.fME.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                NewSubPbActivity.this.fNo = (PostData) sparseArray2.get(e.g.tag_clip_board);
                                if (NewSubPbActivity.this.fNo != null && NewSubPbActivity.this.fMg != null) {
                                    if (NewSubPbActivity.this.fMg != null) {
                                        NewSubPbActivity.this.fMg.aO(NewSubPbActivity.this.gaO.isMarked());
                                    }
                                    boolean z = NewSubPbActivity.this.fMg.vm() && NewSubPbActivity.this.fNo.getId() != null && NewSubPbActivity.this.fNo.getId().equals(NewSubPbActivity.this.gaO.blc());
                                    if (NewSubPbActivity.this.fMn == null) {
                                        NewSubPbActivity.this.fMn = new y(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.mCommonClickListener);
                                        NewSubPbActivity.this.gaQ.bE(NewSubPbActivity.this.fMn.getView());
                                        NewSubPbActivity.this.fMn.kV(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.fMn.showDialog();
                                    boolean isLogin = NewSubPbActivity.this.isLogin() & NewSubPbActivity.this.kD(sparseArray2.get(e.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(e.g.tag_del_post_is_self)).booleanValue() : false);
                                    boolean booleanValue = sparseArray2.get(e.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(e.g.tag_is_subpb)).booleanValue() : false;
                                    if (z) {
                                        NewSubPbActivity.this.fMn.bhY().setText(e.j.remove_mark);
                                    } else {
                                        NewSubPbActivity.this.fMn.bhY().setText(e.j.mark);
                                    }
                                    if (booleanValue) {
                                        NewSubPbActivity.this.fMn.bhY().setVisibility(8);
                                    } else {
                                        NewSubPbActivity.this.fMn.bhY().setVisibility(0);
                                    }
                                    if (NewSubPbActivity.this.bv(view)) {
                                        if (NewSubPbActivity.this.fME != null && !NewSubPbActivity.this.fME.isGif()) {
                                            sparseArray2.put(e.g.tag_richtext_image, true);
                                        } else {
                                            sparseArray2.put(e.g.tag_richtext_image, false);
                                        }
                                        sparseArray2.put(e.g.tag_richtext_emotion, true);
                                    } else {
                                        sparseArray2.put(e.g.tag_richtext_image, false);
                                        sparseArray2.put(e.g.tag_richtext_emotion, false);
                                    }
                                    NewSubPbActivity.this.fMn.a(sparseArray2, NewSubPbActivity.this.beF(), isLogin);
                                    NewSubPbActivity.this.fMn.refreshUI();
                                }
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            NewSubPbActivity.this.fME = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                NewSubPbActivity.this.fMF = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.fMG = null;
                            } else {
                                NewSubPbActivity.this.fMG = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.fME = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.fMF = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.fMG = null;
                        } else {
                            NewSubPbActivity.this.fMG = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
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
        this.gaS = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void e(View view, String str) {
                NewSubPbActivity.this.l(null, str, "LINK_IMAGE");
            }
        };
        this.gaT = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                        j bkV = NewSubPbActivity.this.gaO.bkV();
                        TbRichText aK = NewSubPbActivity.this.aK(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (aK != null && aK.QT() != null) {
                            tbRichTextData = aK.QT().get(NewSubPbActivity.this.fNm);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.QZ().Rl()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (bkV == null) {
                                    str3 = null;
                                    z4 = false;
                                } else {
                                    if (bkV.bfg() != null) {
                                        str4 = bkV.bfg().getName();
                                        str5 = bkV.bfg().getId();
                                    }
                                    if (bkV.YL() != null) {
                                        str6 = bkV.YL().getId();
                                    }
                                    str3 = str6;
                                    z4 = true;
                                }
                                if (NewSubPbActivity.this.gaO.blh() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.gaO.blh();
                                    z5 = NewSubPbActivity.this.gaO.blj();
                                    arrayList2 = NewSubPbActivity.this.gaO.bli();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z5 = z4;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.d(arrayList2, 0));
                                NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                                return;
                            }
                            NewSubPbActivity.this.fNn = false;
                            String str7 = "";
                            TbRichText bBz = bkV.bfa().bBz();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(bBz, aK, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (bkV == null) {
                                str2 = null;
                                z2 = false;
                            } else {
                                if (bkV.bfg() != null) {
                                    str8 = bkV.bfg().getName();
                                    str9 = bkV.bfg().getId();
                                }
                                if (bkV.YL() != null) {
                                    str10 = bkV.YL().getId();
                                }
                                str2 = str10;
                                z2 = true;
                            }
                            if (NewSubPbActivity.this.gaO.blh() != null) {
                                concurrentHashMap = NewSubPbActivity.this.gaO.blh();
                                z3 = NewSubPbActivity.this.gaO.blj();
                                arrayList = NewSubPbActivity.this.gaO.bli();
                                i2 = a2 + NewSubPbActivity.this.gaO.getOffset();
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
    public void bu(View view) {
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
        TbRichTextImageInfo QZ;
        if (tbRichText == tbRichText2) {
            this.fNn = true;
        }
        if (tbRichText != null && tbRichText.QT() != null) {
            int size = tbRichText.QT().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.QT().get(i6) != null && tbRichText.QT().get(i6).getType() == 8) {
                    i5++;
                    int aR = (int) l.aR(TbadkCoreApplication.getInst());
                    int width = tbRichText.QT().get(i6).QZ().getWidth() * aR;
                    int height = tbRichText.QT().get(i6).QZ().getHeight() * aR;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.QT().get(i6).QZ().Rl()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.QT().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (QZ = tbRichTextData.QZ()) != null) {
                            String Ro = QZ.Ro();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Ro;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.fNn) {
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
        if (this.fMn != null) {
            this.fMn.kV(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo QZ = tbRichTextData.QZ();
        if (QZ != null) {
            if (!StringUtils.isNull(QZ.Rk())) {
                return QZ.Rk();
            }
            if (QZ.getHeight() * QZ.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (QZ.getHeight() * QZ.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (QZ.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * QZ.getHeight())));
            } else {
                float width = QZ.getWidth() / QZ.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ao.bx(QZ.Rm()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aK(String str, int i) {
        if (this.gaO == null || this.gaO.bkV() == null || str == null || i < 0) {
            return null;
        }
        j bkV = this.gaO.bkV();
        TbRichText a2 = a(bkV.bfa(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bkV.bfa(), str, i);
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
        TbRichText bBz = postData.bBz();
        if (bBz != null) {
            ArrayList<TbRichTextData> QT = bBz.QT();
            int size = QT.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (QT.get(i3) != null && QT.get(i3).getType() == 8) {
                    i2++;
                    if (QT.get(i3).QZ().Ro().equals(str)) {
                        int aR = (int) l.aR(TbadkCoreApplication.getInst());
                        int width = QT.get(i3).QZ().getWidth() * aR;
                        int height = QT.get(i3).QZ().getHeight() * aR;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.fNm = i3;
                        return bBz;
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
    public boolean kD(boolean z) {
        if (this.gaO == null) {
            return false;
        }
        return ((beF() != 0) || this.gaO.bkV() == null || this.gaO.bkV().YL() == null || this.gaO.bkV().YL().yC() == null || TextUtils.equals(this.gaO.bkV().YL().yC().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Context context, String str, String str2) {
        long templateId = this.gaO.bkV().bfa().bBG() != null ? this.gaO.bkV().bfa().bBG().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ay.Db().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.gaO.bkV().bfg().getId(), this.gaO.bkV().bfg().getName(), this.gaO.bkV().YL().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(int i, String str) {
        if (this.gaO.bkW()) {
            showToast(str);
        } else if (l.lm()) {
            if (i == 4) {
                this.gaQ.nN(str + "(4)");
            } else {
                this.gaQ.jJ(e.j.no_data_text);
            }
        } else {
            this.gaQ.jJ(e.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.eYw = (g) new com.baidu.tbadk.editortools.pb.h().bJ(getActivity());
        if (this.eYw != null) {
            this.eYw.setContext(getPageContext());
            this.eYw.b(this.gaO);
            this.eYw.b(this.gbf);
            this.eYw.a(this.aWB);
            this.eYw.a(this.aWC);
            this.eYw.KT().cp(true);
            this.eYw.d(getPageContext());
        }
        if (this.gaQ != null) {
            this.gaQ.g(this.eYw);
        }
        if (this.eYw != null && this.gaO != null) {
            this.eYw.a(this.gaO.ayn());
            this.eYw.LP();
        }
        if (this.eYw != null) {
            this.fXZ = this.eYw.LT().getInputView();
            this.fXZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.gbd != null) {
                        if (!NewSubPbActivity.this.gbd.bKS()) {
                            NewSubPbActivity.this.lI(false);
                        }
                        NewSubPbActivity.this.gbd.op(false);
                    }
                }
            });
        }
    }

    public void bkz() {
        if (!TbadkCoreApplication.isLogin()) {
            this.eYw.LP();
        } else if (!StringUtils.isNull(this.gaO.bld())) {
            if (this.gaQ.bkF() && l.lm()) {
                this.gaQ.avu();
            } else {
                this.gaQ.bkI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(View view) {
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
                    this.gaQ.bC(view);
                }
            } else if (booleanValue2) {
                this.gaQ.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.gaQ.bkO(), getPageContext().getPageActivity());
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
            bVar.cQ(e.j.operation);
            bVar.a(strArr, new b.InterfaceC0148b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.gba);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.gba);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).AE();
        }
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(e.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(e.g.tag_user_mute_mute_userid);
        }
        this.gaQ.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.gba;
        userMuteCheckCustomMessage.setTag(this.gba);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.gaQ.a(0, bVar.HZ, bVar.hgO, z);
            if (bVar.HZ) {
                if (bVar.hgM == 1) {
                    if (this.gaQ.getListView() instanceof BdTypeListView) {
                        List<com.baidu.adp.widget.ListView.h> data = ((BdTypeListView) this.gaQ.getListView()).getData();
                        if (!v.I(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            data.remove(i);
                            this.gaQ.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.hgM == 2) {
                    this.gaO.sO(bVar.mPostId);
                    this.gaQ.a(this.gaO.bkV(), this.gaO.beF(), this.gaO.blh() != null);
                    if (this.gaO.ble()) {
                        this.gaO.lL(false);
                        this.gaQ.bkD();
                        this.gaO.Ns();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
            }
        }
    }

    public void sn(String str) {
        this.fMf.sK(str);
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.gaO.isMarked() && postData.getId() != null && postData.getId().equals(this.gaO.blc())) {
                z = true;
            }
            MarkData h = this.gaO.h(postData);
            if (h != null) {
                this.gaQ.bjt();
                if (this.fMg != null) {
                    this.fMg.a(h);
                    if (!z) {
                        this.fMg.vo();
                    } else {
                        this.fMg.vn();
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
        if (bundle != null && this.gaO != null) {
            this.gaO.D(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.eYw != null) {
            this.eYw.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.eYw.KT().Js();
        this.eYw.LP();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eYw.b(writeData);
                this.eYw.setVoiceModel(pbEditorData.getVoiceModel());
                k fw = this.eYw.KT().fw(6);
                if (fw != null && fw.aUL != null) {
                    fw.aUL.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eYw.LL();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dBD != null) {
            this.dBD.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.gaY = true;
        super.onPause();
        if (this.dBD != null) {
            this.dBD.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.eCl);
        this.gaQ.aCo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.gaY = false;
        super.onResume();
        if (this.dBD != null) {
            this.dBD.onResume(getPageContext());
        }
        registerListener(this.eCl);
        this.gaQ.aCp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dBD != null) {
            this.dBD.onStop(getPageContext());
        }
        this.eYw.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.gbe));
        this.gaO.cancelLoadData();
        this.gaO.destory();
        this.gaP.cancelLoadData();
        if (this.dBD != null) {
            this.dBD.onDestory(getPageContext());
        }
        this.gaQ.bjt();
        this.gaQ.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.fNc);
        MessageManager.getInstance().unRegisterListener(this.fNd);
        MessageManager.getInstance().unRegisterListener(this.fNe);
        MessageManager.getInstance().unRegisterListener(this.gba);
        this.fMz = null;
        this.fMA = null;
        if (this.dCp != null) {
            this.dCp.onDestroy();
        }
        if (this.eYo != null) {
            this.eYo.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gaQ.onChangeSkinType(i);
        if (this.dCp != null) {
            this.dCp.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dBD;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bkJ = this.gaQ.bkJ();
        if (bkJ == null || (findViewWithTag = bkJ.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean sD(String str) {
        Map<String, String> fv;
        if (!TextUtils.isEmpty(str) && (fv = ay.fv(ay.fw(str))) != null) {
            this.gbb = true;
            String str2 = fv.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return sD(com.baidu.adp.lib.util.k.by(str2));
            }
            String str3 = fv.get(gaN);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (sD(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
                    iVar.mLink = str;
                    iVar.type = 3;
                    iVar.aTP = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, iVar));
                }
            } else {
                ay.Db().c(getPageContext(), new String[]{str});
            }
            this.gbb = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ak(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.gbb = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void al(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void i(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.gaQ != null) {
            return this.gaQ.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int RA() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> RC() {
        if (this.boh == null) {
            this.boh = TbRichTextView.n(getPageContext().getPageActivity(), 8);
        }
        return this.boh;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> RD() {
        if (this.bol == null) {
            this.bol = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bgC */
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
        return this.bol;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> RB() {
        if (this.bog == null) {
            this.bog = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: akN */
                public ImageView jz() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean wE = i.wA().wE();
                    foreDrawableImageView.setDefaultBg(al.getDrawable(e.d.common_color_10220));
                    if (wE) {
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
                        if (i.wA().wE()) {
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
        return this.bog;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> RE() {
        if (this.boi == null) {
            this.boi = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bgD */
                public View jz() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(e.C0200e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bx */
                public void u(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: by */
                public View v(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bz */
                public View w(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.boi;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> RF() {
        if (this.boj == null) {
            this.boj = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bgF */
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
        return this.boj;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> RG() {
        this.bok = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bgE */
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
        return this.bok;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bfm() {
        return this.fMi;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bfn() {
        return (this.gaO == null || this.gaO.bkV() == null || this.gaO.bkV().YL() == null || this.gaO.bkV().YL().zN()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bfo() {
        if (this.gaO == null || this.gaO.bkV() == null || this.gaO.bkV().YL() == null) {
            return null;
        }
        return this.gaO.bkV().YL().yI();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bfp() {
        if (this.gaO == null) {
            return 0;
        }
        return this.gaO.beF();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean sk(String str) {
        if (StringUtils.isNull(str) || this.gaO == null || this.gaO.bkV() == null || this.gaO.bkV().YL() == null || this.gaO.bkV().YL().yC() == null) {
            return false;
        }
        return str.equals(this.gaO.bkV().YL().yC().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.gaQ.bkF() && l.lm()) {
            this.gaO.Ns();
        } else {
            this.gaQ.bkI();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.gba);
        userMuteAddAndDelCustomMessage.setTag(this.gba);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sM(String str) {
        if (!StringUtils.isNull(str) && ba.bG(getPageContext().getPageActivity())) {
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
    public void ao(Context context, String str) {
        l(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean NI() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int NJ() {
                return com.baidu.tbadk.pageStayDuration.e.NN().NP();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.gaO != null) {
            if (this.gaO.bkV() != null && this.gaO.bkV().bfg() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.gaO.bkV().bfg().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.gaO.bhm(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.gaY;
    }

    public boolean bkA() {
        if (this.gaO != null) {
            return this.gaO.bkA();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.gaQ.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fMz.getPageActivity());
        if (ao.isEmpty(str)) {
            aVar.ej(this.fMz.getResources().getString(e.j.block_mute_message_alert, str3));
        } else {
            aVar.ej(str);
        }
        aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.gaQ.showLoadingDialog();
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
        aVar.b(this.fMz).AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hC(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fMz.getPageActivity());
        aVar.ej(str);
        aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fMz).AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ej(getResources().getString(e.j.mute_is_super_member_function));
        aVar.a(e.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.fMz).showToast(e.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.fMz.getPageActivity(), 2, true, 4);
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
        aVar.b(this.fMz).AB();
    }

    public int beF() {
        if (this.gaO != null) {
            return this.gaO.beF();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.aVi) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.aVi) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void lI(boolean z) {
        if (this.fXZ != null && this.fXZ.getText() != null) {
            int selectionEnd = this.fXZ.getSelectionEnd();
            SpannableStringBuilder b = this.gbd.b(this.fXZ.getText());
            if (b != null) {
                this.gbd.op(true);
                this.fXZ.setText(b);
                if (z && this.gbd.bKQ() >= 0) {
                    this.fXZ.requestFocus();
                    this.fXZ.setSelection(this.gbd.bKQ());
                } else {
                    this.fXZ.setSelection(selectionEnd);
                }
                this.gbd.oo(this.gbd.bKQ() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.dCp == null) {
            this.dCp = new h(getPageContext());
            this.dCp.a(new h.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void bm(boolean z) {
                    if (z) {
                        TiebaStatic.log(new am("c13061"));
                    }
                }
            });
        }
        this.dCp.a(contriInfo, -1L);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.eYw != null && this.eYw.KT() != null && this.eYw.KT().KW()) {
            this.eYw.KT().Js();
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
