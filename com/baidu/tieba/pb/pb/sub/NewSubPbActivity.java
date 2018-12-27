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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
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
    private static final String gjd = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String gkw = "tbgametype";
    private View.OnLongClickListener aTr;
    private com.baidu.adp.lib.e.b<ImageView> brG;
    private com.baidu.adp.lib.e.b<TextView> brH;
    private com.baidu.adp.lib.e.b<View> brI;
    private com.baidu.adp.lib.e.b<LinearLayout> brJ;
    private com.baidu.adp.lib.e.b<RelativeLayout> brK;
    private com.baidu.adp.lib.e.b<GifView> brL;
    private com.baidu.tbadk.core.util.b.a bzi;
    private VoiceManager dKQ;
    private h dLC;
    private com.baidu.tieba.pb.pb.report.a fVN;
    private com.baidu.tbadk.baseEditMark.a fVO;
    private com.baidu.tieba.pb.pb.main.b.a fVQ;
    private y fVV;
    private b.InterfaceC0158b fWX;
    private com.baidu.adp.base.e fWh;
    private g fWi;
    private av fWl;
    private com.baidu.adp.widget.ImageView.a fWm;
    private String fWn;
    private TbRichTextMemeInfo fWo;
    public aj fhU;
    private com.baidu.tbadk.editortools.pb.g fic;
    private PostWriteCallBackData gay;
    private EditText ghI;
    private AbsListView.OnScrollListener gkA;
    private TbRichTextView.i gkB;
    private TbRichTextView.h gkC;
    private SubPbModel.a gkD;
    private com.baidu.adp.base.d gkE;
    private BdUniqueId gkJ;
    private com.baidu.tieba.pb.pb.sub.a gkL;
    private com.baidu.tieba.write.b gkM;
    private com.baidu.tieba.pb.d<j> gkN;
    private SubPbModel gkx;
    private ForumManageModel gky;
    private b gkz;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int fWU = 0;
    PostData fWW = null;
    private a.InterfaceC0154a fWR = null;
    private a gkF = null;
    private a gkG = null;
    private boolean gkH = false;
    private boolean gkI = false;
    private boolean gkK = false;
    private boolean aYI = false;
    private com.baidu.tbadk.editortools.pb.c bab = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Mw() {
            NewSubPbActivity.this.gkz.bnl();
        }
    };
    private com.baidu.tbadk.editortools.pb.b bac = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Mv() {
            if (!NewSubPbActivity.this.gkM.bNN()) {
                return (NewSubPbActivity.this.fhU == null || NewSubPbActivity.this.gkx == null || NewSubPbActivity.this.gkx.aAM() == null || NewSubPbActivity.this.fhU.x(NewSubPbActivity.this.gkx.aAM().replyPrivateFlag, aj.aBX)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.gkM.bNP());
            if (NewSubPbActivity.this.fic.ML()) {
                NewSubPbActivity.this.fic.a(NewSubPbActivity.this.gay);
            }
            NewSubPbActivity.this.lO(true);
            return true;
        }
    };
    private NewWriteModel.d gkO = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.fic != null && NewSubPbActivity.this.fic.LY() != null) {
                NewSubPbActivity.this.fic.LY().hide();
                if (NewSubPbActivity.this.gkx.bnF()) {
                    TiebaStatic.log(new am("c10367").aA("post_id", NewSubPbActivity.this.gkx.Mt()));
                }
            }
            if (z) {
                NewSubPbActivity.this.gkM.xu(null);
                NewSubPbActivity.this.gkM.aA(null);
                NewSubPbActivity.this.gkM.ot(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    NewSubPbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.gkM.aA(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.gkM.xu(postWriteCallBackData.getErrorString());
                if (!v.I(NewSubPbActivity.this.gkM.bNL())) {
                    NewSubPbActivity.this.gay = postWriteCallBackData;
                    if (NewSubPbActivity.this.fic.ML()) {
                        NewSubPbActivity.this.fic.a(NewSubPbActivity.this.gay);
                    }
                    NewSubPbActivity.this.lO(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.fhU != null) {
                NewSubPbActivity.this.fhU.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.gkz.bnm();
        }
    };
    private CustomMessageListener fWK = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.gkJ) {
                NewSubPbActivity.this.gkz.aln();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fWi.e(NewSubPbActivity.this.fWh.getResources().getString(e.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.fWh.getResources().getString(e.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.hU(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.biZ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ao.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.fWh.getResources().getString(e.j.mute_fail);
                    }
                    NewSubPbActivity.this.fWi.f(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fWL = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.gkJ) {
                NewSubPbActivity.this.gkz.aln();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fWi.e(NewSubPbActivity.this.fWh.getResources().getString(e.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ao.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.fWh.getResources().getString(e.j.un_mute_fail);
                }
                NewSubPbActivity.this.fWi.f(muteMessage);
            }
        }
    };
    private CustomMessageListener fWM = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.gkJ) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.gkz.aln();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.hCH;
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
                    NewSubPbActivity.this.gkz.a(sparseArray, z);
                }
            }
        }
    };
    boolean fWV = false;
    private final b.InterfaceC0158b fWY = new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.fWm != null && !TextUtils.isEmpty(NewSubPbActivity.this.fWn)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.fWo == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.fWn));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.fWn;
                        aVar.pkgId = NewSubPbActivity.this.fWo.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.fWo.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.bzi == null) {
                        NewSubPbActivity.this.bzi = new com.baidu.tbadk.core.util.b.a();
                    }
                    NewSubPbActivity.this.bzi.Et();
                    NewSubPbActivity.this.bzi.c(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.bzi.A(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.fWl == null) {
                            NewSubPbActivity.this.fWl = new av(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.fWl.i(NewSubPbActivity.this.fWn, NewSubPbActivity.this.fWm.os());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.fWm = null;
                NewSubPbActivity.this.fWn = null;
            }
        }
    };
    private CustomMessageListener eLR = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener dLZ = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    com.baidu.tbadk.data.j jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.gkx.bnz() != null && NewSubPbActivity.this.gkx.bnz().bhC() != null && NewSubPbActivity.this.gkx.bnz().bhC().zG() != null && currentAccount.equals(NewSubPbActivity.this.gkx.bnz().bhC().zG().getUserId()) && NewSubPbActivity.this.gkx.bnz().bhC().zG().getPendantData() != null) {
                        NewSubPbActivity.this.gkx.bnz().bhC().zG().getPendantData().ej(jVar.ys());
                        NewSubPbActivity.this.gkx.bnz().bhC().zG().getPendantData().ap(jVar.LF());
                        NewSubPbActivity.this.gkz.a(NewSubPbActivity.this.gkx.bnz().bhC(), NewSubPbActivity.this.gkx.bnz().aUp(), NewSubPbActivity.this.gkx.bnz().wq(), NewSubPbActivity.this.gkx.bhh(), NewSubPbActivity.this.gkx.bnL() != null);
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
        if (this.aYI) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.fWh = getPageContext();
        this.gkI = true;
        this.gkM = new com.baidu.tieba.write.b();
        this.gkM.xj(e.d.cp_cont_h_alpha85);
        this.gkM.xi(e.d.cp_cont_i);
        aFL();
        bnc();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bnb();
        this.fWi = new g();
        this.fWi.aHd = 1000L;
        registerListener(this.fWM);
        registerListener(this.fWK);
        registerListener(this.fWL);
        this.gkJ = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.gkJ;
        userMuteAddAndDelCustomMessage.setTag(this.gkJ);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.gkJ;
        userMuteCheckCustomMessage.setTag(this.gkJ);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.fhU = new aj(getPageContext());
        this.fhU.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.fic.MQ();
                }
            }
        });
        this.fVN = new com.baidu.tieba.pb.pb.report.a(this);
        this.fVN.o(getUniqueId());
        this.fVQ = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    private void bnb() {
        if (this.gkz != null && this.gkx != null && this.gkx.bne()) {
            this.gkL = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.gkz.abW());
            this.gkL.aFQ();
            this.gkL.a(new a.InterfaceC0290a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
                private boolean dZg = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0290a
                public void aFM() {
                    NewSubPbActivity.this.gkz.hj(false);
                    this.dZg = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0290a
                public void aFN() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0290a
                public boolean aFO() {
                    if (!this.dZg) {
                        return NewSubPbActivity.this.gkz.aGc() != null && NewSubPbActivity.this.gkz.aGc().getTop() == 0;
                    }
                    this.dZg = false;
                    return false;
                }
            });
            this.gkz.e(this.gkL);
            this.gkz.hj(true);
        }
    }

    public void initUI() {
        this.gkz = new b(this, this.mCommonClickListener);
        this.gkz.a(this.gkx);
        setContentView(this.gkz.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.gkz.setOnScrollListener(this.gkA);
        this.gkz.a(this);
        this.gkz.setOnLinkImageClickListener(this.gkB);
        this.gkz.setOnImageClickListener(this.gkC);
        this.gkz.kC(true);
        this.gkz.setOnLongClickListener(this.aTr);
        this.gkz.c(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.gkx != null) {
                    NewSubPbActivity.this.gkx.Ox();
                }
            }
        });
        this.gkz.a(this.gkF);
        this.gkz.b(this.gkG);
        if (this.gkx != null && this.gkx.bne() && !this.gkx.bnK()) {
            this.gkz.bnq().setVisibility(8);
        } else {
            this.gkz.bnq().setVisibility(0);
        }
        if (this.gkx != null && !this.gkx.bne()) {
            this.gkz.setIsFromPb(false);
        }
    }

    private boolean H(Bundle bundle) {
        if (bundle != null) {
            this.aYI = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.aYI = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.aYI;
    }

    public void initData(Bundle bundle) {
        this.gkx = new SubPbModel(getPageContext());
        this.gkx.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.gkz.n(postData);
                NewSubPbActivity.this.gkz.a((BdListView.e) null);
            }
        });
        this.gky = new ForumManageModel(getPageContext());
        this.gky.setLoadDataCallBack(this.gkE);
        this.dKQ = new VoiceManager();
        this.dKQ.onCreate(getPageContext());
        this.fVO = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fVO != null) {
            this.fVO.a(this.fWR);
        }
        if (bundle != null) {
            this.gkx.initWithBundle(bundle);
        } else {
            this.gkx.initWithIntent(getIntent());
        }
        this.gkx.a(this.gkD);
        if (this.gkx.bne()) {
            this.gkx.Ox();
        } else {
            this.gkx.bnE();
        }
    }

    public void bnc() {
        this.gkD = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, j jVar) {
                if (NewSubPbActivity.this.gkz != null) {
                    NewSubPbActivity.this.gkz.bnm();
                }
                if (NewSubPbActivity.this.gkL != null && NewSubPbActivity.this.gkL.aFR()) {
                    NewSubPbActivity.this.gkL.nb(e.d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.af(i, str);
                    return;
                }
                NewSubPbActivity.this.gkz.hideNoDataView();
                if (jVar != null) {
                    if (jVar.bhC() != null || NewSubPbActivity.this.gkx != null) {
                        jVar.bhC().a(NewSubPbActivity.this.gkx.bnJ());
                    }
                    if (NewSubPbActivity.this.gkz != null) {
                        NewSubPbActivity.this.gkz.a(jVar, NewSubPbActivity.this.gkx.bhh(), NewSubPbActivity.this.gkx.bnL() != null);
                        if (NewSubPbActivity.this.gkI) {
                            NewSubPbActivity.this.bnd();
                            NewSubPbActivity.this.gkI = false;
                        }
                    }
                    if (NewSubPbActivity.this.fic != null) {
                        NewSubPbActivity.this.fic.a(jVar.aAM());
                    }
                    if (NewSubPbActivity.this.gkN == null) {
                        NewSubPbActivity.this.gkN = new com.baidu.tieba.pb.d();
                    }
                    NewSubPbActivity.this.gkN.setData(jVar);
                    NewSubPbActivity.this.gkN.setType(0);
                    NewSubPbActivity.this.fhU.a(NewSubPbActivity.this.gkx.bnO());
                }
            }
        };
        this.fWR = new a.InterfaceC0154a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0154a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.fVO != null) {
                        NewSubPbActivity.this.fVO.aP(z2);
                    }
                    MarkData wt = NewSubPbActivity.this.fVO.wt();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setType(2);
                    if (z2) {
                        dVar.setData(wt);
                        if (NewSubPbActivity.this.fVO != null) {
                            if (wt != null) {
                                NewSubPbActivity.this.gkx.lQ(true);
                                NewSubPbActivity.this.gkx.tu(NewSubPbActivity.this.gkx.Mt());
                                NewSubPbActivity.this.showToast(e.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(e.j.add_mark));
                            }
                            if (NewSubPbActivity.this.gkz != null) {
                                NewSubPbActivity.this.gkz.lP(true);
                            }
                        }
                    } else {
                        dVar.setData(null);
                        NewSubPbActivity.this.gkx.lQ(false);
                        NewSubPbActivity.this.gkx.tu(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(e.j.remove_mark));
                        if (NewSubPbActivity.this.gkz != null) {
                            NewSubPbActivity.this.gkz.lP(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(e.j.update_mark_failed));
            }
        };
        this.gkF = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.gkx.bnz() != null && NewSubPbActivity.this.gkx.bnz().ZT() != null && NewSubPbActivity.this.gkx.bnz().ZT().zG() != null) {
                    str = String.valueOf(NewSubPbActivity.this.gkx.bnz().ZT().zG().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.gkx.bnz().bhI().getId(), NewSubPbActivity.this.gkx.bnz().bhI().getName(), NewSubPbActivity.this.gkx.bnz().ZT().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.gkG = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.gky.bEU() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int l = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[1]), 0);
                        boolean g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[2]), false);
                        int l2 = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.gkx != null && NewSubPbActivity.this.gkx.bnz() != null && NewSubPbActivity.this.gkx.bnz().bhI() != null && NewSubPbActivity.this.gkx.bnz().ZT() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.gky.vM(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.gky.a(NewSubPbActivity.this.gkx.bnz().bhI().getId(), NewSubPbActivity.this.gkx.bnz().bhI().getName(), NewSubPbActivity.this.gkx.bnz().ZT().getId(), valueOf, l2, l, g);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.gkE = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.gkz.a(NewSubPbActivity.this.gky.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.gky.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.glB != 1002 || bVar.epZ) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.gkz.a(1, dVar.HZ, dVar.hqU, true);
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

    public void aFL() {
        registerListener(this.dLZ);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v48, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.gkz != null) {
                    if (view == NewSubPbActivity.this.gkz.bnw()) {
                        NewSubPbActivity.this.gkz.blX();
                        String str = view.getTag(e.g.tag_user_id) instanceof String ? (String) view.getTag(e.g.tag_user_id) : null;
                        String str2 = view.getTag(e.g.tag_user_name) instanceof String ? (String) view.getTag(e.g.tag_user_name) : null;
                        String str3 = view.getTag(e.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(e.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ay.Ef().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.gkz.aGd()) {
                        if (view != NewSubPbActivity.this.gkz.bnp()) {
                            if (view != NewSubPbActivity.this.gkz.bno()) {
                                if (view == NewSubPbActivity.this.gkz.bnk()) {
                                    NewSubPbActivity.this.gkz.blX();
                                    if (NewSubPbActivity.this.gkx.Ox()) {
                                        NewSubPbActivity.this.gkz.bni();
                                    }
                                } else if (view == NewSubPbActivity.this.gkz.bnq() || view == NewSubPbActivity.this.gkz.bnr() || view == NewSubPbActivity.this.gkz.bnt()) {
                                    if (NewSubPbActivity.this.gkK) {
                                        NewSubPbActivity.this.gkK = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.gkx.bjP(), NewSubPbActivity.this.gkx.Mt(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.gkx.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.gkx.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.gkz.bnu() == null || view != NewSubPbActivity.this.gkz.bnu().bkB()) {
                                    if (NewSubPbActivity.this.gkz.bnu() == null || view != NewSubPbActivity.this.gkz.bnu().bkE()) {
                                        if (NewSubPbActivity.this.gkz.bnu() == null || view != NewSubPbActivity.this.gkz.bnu().bkC()) {
                                            if (NewSubPbActivity.this.gkz.bnu() == null || view != NewSubPbActivity.this.gkz.bnu().bkD()) {
                                                if (NewSubPbActivity.this.gkz.bnu() == null || view != NewSubPbActivity.this.gkz.bnu().bkF()) {
                                                    if (view == NewSubPbActivity.this.gkz.bnn() || view == NewSubPbActivity.this.gkz.bnt()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.fic.MT()) {
                                                                NewSubPbActivity.this.fic.MU();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.fic.hV(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof com.baidu.tieba.pb.pb.main.j)) {
                                                        if (NewSubPbActivity.this.fVV == null || view != NewSubPbActivity.this.fVV.bkD()) {
                                                            if (NewSubPbActivity.this.fVV == null || view != NewSubPbActivity.this.fVV.bkB()) {
                                                                if (NewSubPbActivity.this.fVV == null || view != NewSubPbActivity.this.fVV.bkE()) {
                                                                    if (NewSubPbActivity.this.fVV == null || view != NewSubPbActivity.this.fVV.bkF()) {
                                                                        if (NewSubPbActivity.this.fVV == null || view != NewSubPbActivity.this.fVV.bkH()) {
                                                                            if (NewSubPbActivity.this.fVV == null || view != NewSubPbActivity.this.fVV.bkI()) {
                                                                                if (NewSubPbActivity.this.fVV != null && view == NewSubPbActivity.this.fVV.bkC()) {
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
                                                                                            NewSubPbActivity.this.gkz.bF(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.gkz.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
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
                                                                                        if (postData.getType() != PostData.hoz && !TextUtils.isEmpty(postData.getBimg_url()) && i.xE().xI()) {
                                                                                            NewSubPbActivity.this.tr(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.fWm != null && !TextUtils.isEmpty(NewSubPbActivity.this.fWn)) {
                                                                                if (NewSubPbActivity.this.bzi == null) {
                                                                                    NewSubPbActivity.this.bzi = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.bzi.Et();
                                                                                NewSubPbActivity.this.bzi.c(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.bzi.A(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.fWl == null) {
                                                                                        NewSubPbActivity.this.fWl = new av(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.fWl.i(NewSubPbActivity.this.fWn, NewSubPbActivity.this.fWm.os());
                                                                                    NewSubPbActivity.this.fWm = null;
                                                                                    NewSubPbActivity.this.fWn = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.fWm != null && !TextUtils.isEmpty(NewSubPbActivity.this.fWn)) {
                                                                            if (NewSubPbActivity.this.fWo == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.fWn));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.fWn;
                                                                                aVar.pkgId = NewSubPbActivity.this.fWo.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.fWo.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.fWm = null;
                                                                            NewSubPbActivity.this.fWn = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.fWW != null) {
                                                                        NewSubPbActivity.this.fWW.cZ(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.fWW = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                if (sparseArray2 != null && (sparseArray2.get(e.g.tag_del_post_type) instanceof Integer) && (sparseArray2.get(e.g.tag_del_post_id) instanceof String) && (sparseArray2.get(e.g.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.gkz.a(((Integer) sparseArray2.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(e.g.tag_del_post_id), ((Integer) sparseArray2.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(e.g.tag_del_post_is_self)).booleanValue());
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
                                                                NewSubPbActivity.this.sT((String) tag);
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
                                                        if (NewSubPbActivity.this.gkK) {
                                                            NewSubPbActivity.this.gkK = false;
                                                            return;
                                                        } else if (NewSubPbActivity.this.fhU == null || NewSubPbActivity.this.gkx == null || NewSubPbActivity.this.gkx.aAM() == null || NewSubPbActivity.this.fhU.dK(NewSubPbActivity.this.gkx.aAM().replyPrivateFlag)) {
                                                            if (NewSubPbActivity.this.gkL != null) {
                                                                NewSubPbActivity.this.gkL.aFP();
                                                            }
                                                            SparseArray sparseArray4 = (SparseArray) view.getTag(e.g.tag_from);
                                                            if (sparseArray4 != null && (sparseArray4.get(e.g.tag_clip_board) instanceof PostData)) {
                                                                PostData postData2 = (PostData) sparseArray4.get(e.g.tag_clip_board);
                                                                if (postData2 != null && postData2.zG() != null) {
                                                                    MetaData zG = postData2.zG();
                                                                    NewSubPbActivity.this.fic.setReplyId(zG.getUserId());
                                                                    if (!(sparseArray4.get(e.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray4.get(e.g.tag_is_subpb)).booleanValue() : true)) {
                                                                        NewSubPbActivity.this.fic.hY("");
                                                                    } else {
                                                                        NewSubPbActivity.this.fic.hY(zG.getName_show());
                                                                    }
                                                                }
                                                                NewSubPbActivity.this.gkz.bng();
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
                                            TiebaStatic.log(new am("c11739").x("obj_locate", 4));
                                            if (!com.baidu.adp.lib.util.j.kV()) {
                                                NewSubPbActivity.this.showToast(e.j.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.gkz.blX();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.sT(str4);
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
                                            NewSubPbActivity.this.gkz.blX();
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
                                    NewSubPbActivity.this.gkz.blX();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.gkz.a(((Integer) sparseArray7.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray7.get(e.g.tag_del_post_id), ((Integer) sparseArray7.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(e.g.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new am("c11739").x("obj_locate", 2));
                                    NewSubPbActivity.this.gkz.blX();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.gkx.bnz() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.gkx.bnz().bhC());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.gkz.bnf();
                                NewSubPbActivity.this.gkz.bng();
                                if (NewSubPbActivity.this.fic != null) {
                                    NewSubPbActivity.this.fic.MW();
                                    if (NewSubPbActivity.this.gkL != null) {
                                        NewSubPbActivity.this.gkL.aFP();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.gkz.bnf();
                            NewSubPbActivity.this.gkz.bng();
                            if (NewSubPbActivity.this.fic != null) {
                                NewSubPbActivity.this.fic.MV();
                                if (NewSubPbActivity.this.gkL != null) {
                                    NewSubPbActivity.this.gkL.aFP();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.fhU == null || NewSubPbActivity.this.gkx == null || NewSubPbActivity.this.gkx.aAM() == null || NewSubPbActivity.this.fhU.dK(NewSubPbActivity.this.gkx.aAM().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.fic.ML()) {
                                NewSubPbActivity.this.fic.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.gkz.bnf();
                            NewSubPbActivity.this.gkz.bng();
                            if (NewSubPbActivity.this.fic != null) {
                                NewSubPbActivity.this.fic.MX();
                                if (NewSubPbActivity.this.gkL != null) {
                                    NewSubPbActivity.this.gkL.aFP();
                                }
                            }
                        }
                    }
                }
            }
        };
        this.gkA = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.gkz.blX();
                }
                NewSubPbActivity.this.fic.MU();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.gkz.bnv();
            }
        };
        this.fWX = new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.gkx.bnz() != null) {
                    postData = NewSubPbActivity.this.gkx.bnz().bhC();
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
        this.aTr = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                        NewSubPbActivity.this.fWm = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.fWn = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.fWm != null && !TextUtils.isEmpty(NewSubPbActivity.this.fWn)) {
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.fWo = null;
                            } else {
                                NewSubPbActivity.this.fWo = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                NewSubPbActivity.this.gkz.a(NewSubPbActivity.this.fWY, NewSubPbActivity.this.fWm.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                NewSubPbActivity.this.fWW = (PostData) sparseArray2.get(e.g.tag_clip_board);
                                if (NewSubPbActivity.this.fWW != null && NewSubPbActivity.this.fVO != null) {
                                    if (NewSubPbActivity.this.fVO != null) {
                                        NewSubPbActivity.this.fVO.aP(NewSubPbActivity.this.gkx.isMarked());
                                    }
                                    boolean z = NewSubPbActivity.this.fVO.wq() && NewSubPbActivity.this.fWW.getId() != null && NewSubPbActivity.this.fWW.getId().equals(NewSubPbActivity.this.gkx.bnG());
                                    if (NewSubPbActivity.this.fVV == null) {
                                        NewSubPbActivity.this.fVV = new y(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.mCommonClickListener);
                                        NewSubPbActivity.this.gkz.bH(NewSubPbActivity.this.fVV.getView());
                                        NewSubPbActivity.this.fVV.lb(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.fVV.showDialog();
                                    boolean isLogin = NewSubPbActivity.this.isLogin() & NewSubPbActivity.this.kJ(sparseArray2.get(e.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(e.g.tag_del_post_is_self)).booleanValue() : false);
                                    boolean booleanValue = sparseArray2.get(e.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(e.g.tag_is_subpb)).booleanValue() : false;
                                    if (z) {
                                        NewSubPbActivity.this.fVV.bkB().setText(e.j.remove_mark);
                                    } else {
                                        NewSubPbActivity.this.fVV.bkB().setText(e.j.mark);
                                    }
                                    if (booleanValue) {
                                        NewSubPbActivity.this.fVV.bkB().setVisibility(8);
                                    } else {
                                        NewSubPbActivity.this.fVV.bkB().setVisibility(0);
                                    }
                                    if (NewSubPbActivity.this.by(view)) {
                                        if (NewSubPbActivity.this.fWm != null && !NewSubPbActivity.this.fWm.isGif()) {
                                            sparseArray2.put(e.g.tag_richtext_image, true);
                                        } else {
                                            sparseArray2.put(e.g.tag_richtext_image, false);
                                        }
                                        sparseArray2.put(e.g.tag_richtext_emotion, true);
                                    } else {
                                        sparseArray2.put(e.g.tag_richtext_image, false);
                                        sparseArray2.put(e.g.tag_richtext_emotion, false);
                                    }
                                    NewSubPbActivity.this.fVV.a(sparseArray2, NewSubPbActivity.this.bhh(), isLogin);
                                    NewSubPbActivity.this.fVV.refreshUI();
                                }
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            NewSubPbActivity.this.fWm = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                NewSubPbActivity.this.fWn = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.fWo = null;
                            } else {
                                NewSubPbActivity.this.fWo = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.fWm = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.fWn = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.fWo = null;
                        } else {
                            NewSubPbActivity.this.fWo = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
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
        this.gkB = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void e(View view, String str) {
                NewSubPbActivity.this.l(null, str, "LINK_IMAGE");
            }
        };
        this.gkC = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                        j bnz = NewSubPbActivity.this.gkx.bnz();
                        TbRichText aM = NewSubPbActivity.this.aM(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (aM != null && aM.Sb() != null) {
                            tbRichTextData = aM.Sb().get(NewSubPbActivity.this.fWU);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.Sh().St()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (bnz == null) {
                                    str3 = null;
                                    z4 = false;
                                } else {
                                    if (bnz.bhI() != null) {
                                        str4 = bnz.bhI().getName();
                                        str5 = bnz.bhI().getId();
                                    }
                                    if (bnz.ZT() != null) {
                                        str6 = bnz.ZT().getId();
                                    }
                                    str3 = str6;
                                    z4 = true;
                                }
                                if (NewSubPbActivity.this.gkx.bnL() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.gkx.bnL();
                                    z5 = NewSubPbActivity.this.gkx.bnN();
                                    arrayList2 = NewSubPbActivity.this.gkx.bnM();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z5 = z4;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.d(arrayList2, 0));
                                NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                                return;
                            }
                            NewSubPbActivity.this.fWV = false;
                            String str7 = "";
                            TbRichText bEl = bnz.bhC().bEl();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(bEl, aM, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (bnz == null) {
                                str2 = null;
                                z2 = false;
                            } else {
                                if (bnz.bhI() != null) {
                                    str8 = bnz.bhI().getName();
                                    str9 = bnz.bhI().getId();
                                }
                                if (bnz.ZT() != null) {
                                    str10 = bnz.ZT().getId();
                                }
                                str2 = str10;
                                z2 = true;
                            }
                            if (NewSubPbActivity.this.gkx.bnL() != null) {
                                concurrentHashMap = NewSubPbActivity.this.gkx.bnL();
                                z3 = NewSubPbActivity.this.gkx.bnN();
                                arrayList = NewSubPbActivity.this.gkx.bnM();
                                i2 = a2 + NewSubPbActivity.this.gkx.getOffset();
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
        TbRichTextImageInfo Sh;
        if (tbRichText == tbRichText2) {
            this.fWV = true;
        }
        if (tbRichText != null && tbRichText.Sb() != null) {
            int size = tbRichText.Sb().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Sb().get(i6) != null && tbRichText.Sb().get(i6).getType() == 8) {
                    i5++;
                    int aR = (int) l.aR(TbadkCoreApplication.getInst());
                    int width = tbRichText.Sb().get(i6).Sh().getWidth() * aR;
                    int height = tbRichText.Sb().get(i6).Sh().getHeight() * aR;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Sb().get(i6).Sh().St()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Sb().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (Sh = tbRichTextData.Sh()) != null) {
                            String Sw = Sh.Sw();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Sw;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.fWV) {
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
        if (this.fVV != null) {
            this.fVV.lb(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo Sh = tbRichTextData.Sh();
        if (Sh != null) {
            if (!StringUtils.isNull(Sh.Ss())) {
                return Sh.Ss();
            }
            if (Sh.getHeight() * Sh.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Sh.getHeight() * Sh.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Sh.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Sh.getHeight())));
            } else {
                float width = Sh.getWidth() / Sh.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ao.bx(Sh.Su()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aM(String str, int i) {
        if (this.gkx == null || this.gkx.bnz() == null || str == null || i < 0) {
            return null;
        }
        j bnz = this.gkx.bnz();
        TbRichText a2 = a(bnz.bhC(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bnz.bhC(), str, i);
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
        TbRichText bEl = postData.bEl();
        if (bEl != null) {
            ArrayList<TbRichTextData> Sb = bEl.Sb();
            int size = Sb.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Sb.get(i3) != null && Sb.get(i3).getType() == 8) {
                    i2++;
                    if (Sb.get(i3).Sh().Sw().equals(str)) {
                        int aR = (int) l.aR(TbadkCoreApplication.getInst());
                        int width = Sb.get(i3).Sh().getWidth() * aR;
                        int height = Sb.get(i3).Sh().getHeight() * aR;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.fWU = i3;
                        return bEl;
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
        if (this.gkx == null) {
            return false;
        }
        return ((bhh() != 0) || this.gkx.bnz() == null || this.gkx.bnz().ZT() == null || this.gkx.bnz().ZT().zG() == null || TextUtils.equals(this.gkx.bnz().ZT().zG().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Context context, String str, String str2) {
        long templateId = this.gkx.bnz().bhC().bEs() != null ? this.gkx.bnz().bhC().bEs().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ay.Ef().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.gkx.bnz().bhI().getId(), this.gkx.bnz().bhI().getName(), this.gkx.bnz().ZT().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(int i, String str) {
        if (this.gkx.bnA()) {
            showToast(str);
        } else if (l.ll()) {
            if (i == 4) {
                this.gkz.or(str + "(4)");
            } else {
                this.gkz.kf(e.j.no_data_text);
            }
        } else {
            this.gkz.kf(e.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.fic = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().bM(getActivity());
        if (this.fic != null) {
            this.fic.setContext(getPageContext());
            this.fic.b(this.gkx);
            this.fic.b(this.gkO);
            this.fic.a(this.bab);
            this.fic.a(this.bac);
            this.fic.LY().cq(true);
            this.fic.d(getPageContext());
        }
        if (this.gkz != null) {
            this.gkz.g(this.fic);
        }
        if (this.fic != null && this.gkx != null) {
            this.fic.a(this.gkx.aAM());
            this.fic.MU();
        }
        if (this.fic != null) {
            this.ghI = this.fic.MY().getInputView();
            this.ghI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.gkM != null) {
                        if (!NewSubPbActivity.this.gkM.bNO()) {
                            NewSubPbActivity.this.lO(false);
                        }
                        NewSubPbActivity.this.gkM.ou(false);
                    }
                }
            });
        }
    }

    public void bnd() {
        if (!TbadkCoreApplication.isLogin()) {
            this.fic.MU();
        } else if (!StringUtils.isNull(this.gkx.bnH())) {
            if (this.gkz.bnj() && l.ll()) {
                this.gkz.axU();
            } else {
                this.gkz.bnm();
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
                    this.gkz.bF(view);
                }
            } else if (booleanValue2) {
                this.gkz.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.gkz.bns(), getPageContext().getPageActivity());
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.gkJ);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.gkJ);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).BI();
        }
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(e.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(e.g.tag_user_mute_mute_userid);
        }
        this.gkz.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.gkJ;
        userMuteCheckCustomMessage.setTag(this.gkJ);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.gkz.a(0, bVar.HZ, bVar.hqU, z);
            if (bVar.HZ) {
                if (bVar.hqS == 1) {
                    if (this.gkz.getListView() instanceof BdTypeListView) {
                        List<com.baidu.adp.widget.ListView.h> data = ((BdTypeListView) this.gkz.getListView()).getData();
                        if (!v.I(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            data.remove(i);
                            this.gkz.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.hqS == 2) {
                    this.gkx.tt(bVar.mPostId);
                    this.gkz.a(this.gkx.bnz(), this.gkx.bhh(), this.gkx.bnL() != null);
                    if (this.gkx.bnI()) {
                        this.gkx.lR(false);
                        this.gkz.bnh();
                        this.gkx.Ox();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
            }
        }
    }

    public void sT(String str) {
        this.fVN.tp(str);
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.gkx.isMarked() && postData.getId() != null && postData.getId().equals(this.gkx.bnG())) {
                z = true;
            }
            MarkData h = this.gkx.h(postData);
            if (h != null) {
                this.gkz.blX();
                if (this.fVO != null) {
                    this.fVO.a(h);
                    if (!z) {
                        this.fVO.ws();
                    } else {
                        this.fVO.wr();
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
        if (bundle != null && this.gkx != null) {
            this.gkx.G(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.fic != null) {
            this.fic.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.fic.LY().Kx();
        this.fic.MU();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.fic.b(writeData);
                this.fic.setVoiceModel(pbEditorData.getVoiceModel());
                k fL = this.fic.LY().fL(6);
                if (fL != null && fL.aYl != null) {
                    fL.aYl.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.fic.MQ();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dKQ != null) {
            this.dKQ.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.gkH = true;
        super.onPause();
        if (this.dKQ != null) {
            this.dKQ.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.eLR);
        this.gkz.aEP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.gkH = false;
        super.onResume();
        if (this.dKQ != null) {
            this.dKQ.onResume(getPageContext());
        }
        registerListener(this.eLR);
        this.gkz.aEQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dKQ != null) {
            this.dKQ.onStop(getPageContext());
        }
        this.fic.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.gkN));
        this.gkx.cancelLoadData();
        this.gkx.destory();
        this.gky.cancelLoadData();
        if (this.dKQ != null) {
            this.dKQ.onDestory(getPageContext());
        }
        this.gkz.blX();
        this.gkz.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.fWK);
        MessageManager.getInstance().unRegisterListener(this.fWL);
        MessageManager.getInstance().unRegisterListener(this.fWM);
        MessageManager.getInstance().unRegisterListener(this.gkJ);
        this.fWh = null;
        this.fWi = null;
        if (this.dLC != null) {
            this.dLC.onDestroy();
        }
        if (this.fhU != null) {
            this.fhU.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gkz.onChangeSkinType(i);
        if (this.dLC != null) {
            this.dLC.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dKQ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bnn = this.gkz.bnn();
        if (bnn == null || (findViewWithTag = bnn.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean ti(String str) {
        Map<String, String> fO;
        if (!TextUtils.isEmpty(str) && (fO = ay.fO(ay.fP(str))) != null) {
            this.gkK = true;
            String str2 = fO.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return ti(com.baidu.adp.lib.util.k.by(str2));
            }
            String str3 = fO.get(gkw);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (ti(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
                    iVar.mLink = str;
                    iVar.type = 3;
                    iVar.aXp = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, iVar));
                }
            } else {
                ay.Ef().c(getPageContext(), new String[]{str});
            }
            this.gkK = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.gkK = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ap(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aq(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void i(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.gkz != null) {
            return this.gkz.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int SI() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> SK() {
        if (this.brH == null) {
            this.brH = TbRichTextView.n(getPageContext().getPageActivity(), 8);
        }
        return this.brH;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> SL() {
        if (this.brL == null) {
            this.brL = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bjf */
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
        return this.brL;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> SJ() {
        if (this.brG == null) {
            this.brG = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: amw */
                public ImageView jz() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean xI = i.xE().xI();
                    foreDrawableImageView.setDefaultBg(al.getDrawable(e.d.common_color_10220));
                    if (xI) {
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
                        if (i.xE().xI()) {
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
        return this.brG;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> SM() {
        if (this.brI == null) {
            this.brI = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bjg */
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
        return this.brI;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> SN() {
        if (this.brJ == null) {
            this.brJ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bji */
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
        return this.brJ;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> SO() {
        this.brK = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bjh */
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
        return this.brK;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bhO() {
        return this.fVQ;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bhP() {
        return (this.gkx == null || this.gkx.bnz() == null || this.gkx.bnz().ZT() == null || this.gkx.bnz().ZT().AR()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bhQ() {
        if (this.gkx == null || this.gkx.bnz() == null || this.gkx.bnz().ZT() == null) {
            return null;
        }
        return this.gkx.bnz().ZT().zM();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bhR() {
        if (this.gkx == null) {
            return 0;
        }
        return this.gkx.bhh();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean sQ(String str) {
        if (StringUtils.isNull(str) || this.gkx == null || this.gkx.bnz() == null || this.gkx.bnz().ZT() == null || this.gkx.bnz().ZT().zG() == null) {
            return false;
        }
        return str.equals(this.gkx.bnz().ZT().zG().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.gkz.bnj() && l.ll()) {
            this.gkx.Ox();
        } else {
            this.gkz.bnm();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.gkJ);
        userMuteAddAndDelCustomMessage.setTag(this.gkJ);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tr(String str) {
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
    public void ar(Context context, String str) {
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
            public boolean ON() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int OO() {
                return com.baidu.tbadk.pageStayDuration.e.OS().OU();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.gkx != null) {
            if (this.gkx.bnz() != null && this.gkx.bnz().bhI() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.gkx.bnz().bhI().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.gkx.bjP(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.gkH;
    }

    public boolean bne() {
        if (this.gkx != null) {
            return this.gkx.bne();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.gkz.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fWh.getPageActivity());
        if (ao.isEmpty(str)) {
            aVar.eB(this.fWh.getResources().getString(e.j.block_mute_message_alert, str3));
        } else {
            aVar.eB(str);
        }
        aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.gkz.showLoadingDialog();
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
        aVar.b(this.fWh).BF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hU(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fWh.getPageActivity());
        aVar.eB(str);
        aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fWh).BF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.eB(getResources().getString(e.j.mute_is_super_member_function));
        aVar.a(e.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.fWh).showToast(e.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.fWh.getPageActivity(), 2, true, 4);
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
        aVar.b(this.fWh).BF();
    }

    public int bhh() {
        if (this.gkx != null) {
            return this.gkx.bhh();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.aYI) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.aYI) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void lO(boolean z) {
        if (this.ghI != null && this.ghI.getText() != null) {
            int selectionEnd = this.ghI.getSelectionEnd();
            SpannableStringBuilder b = this.gkM.b(this.ghI.getText());
            if (b != null) {
                this.gkM.ou(true);
                this.ghI.setText(b);
                if (z && this.gkM.bNM() >= 0) {
                    this.ghI.requestFocus();
                    this.ghI.setSelection(this.gkM.bNM());
                } else {
                    this.ghI.setSelection(selectionEnd);
                }
                this.gkM.ot(this.gkM.bNM() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.dLC == null) {
            this.dLC = new h(getPageContext());
            this.dLC.a(new h.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void bn(boolean z) {
                    if (z) {
                        TiebaStatic.log(new am("c13061"));
                    }
                }
            });
        }
        this.dLC.a(contriInfo, -1L);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.fic != null && this.fic.LY() != null && this.fic.LY().Mb()) {
            this.fic.LY().Kx();
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
