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
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.v;
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
    private static final String fXT = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String fZq = "tbgametype";
    private View.OnLongClickListener aOZ;
    private com.baidu.adp.lib.e.b<ImageView> bnu;
    private com.baidu.adp.lib.e.b<TextView> bnv;
    private com.baidu.adp.lib.e.b<View> bnw;
    private com.baidu.adp.lib.e.b<LinearLayout> bnx;
    private com.baidu.adp.lib.e.b<RelativeLayout> bny;
    private com.baidu.adp.lib.e.b<GifView> bnz;
    private com.baidu.tbadk.core.util.b.a buX;
    private h dAY;
    private VoiceManager dAm;
    public aj eWV;
    private g eXd;
    private com.baidu.tieba.pb.pb.report.a fKF;
    private com.baidu.tbadk.baseEditMark.a fKG;
    private com.baidu.tieba.pb.pb.main.b.a fKI;
    private y fKN;
    private com.baidu.adp.base.e fKZ;
    private b.InterfaceC0124b fLP;
    private com.baidu.tbadk.core.view.g fLa;
    private av fLd;
    private com.baidu.adp.widget.ImageView.a fLe;
    private String fLf;
    private TbRichTextMemeInfo fLg;
    private PostWriteCallBackData fPq;
    private EditText fWz;
    private BdUniqueId fZD;
    private com.baidu.tieba.pb.pb.sub.a fZF;
    private com.baidu.tieba.write.b fZG;
    private com.baidu.tieba.pb.d<j> fZH;
    private SubPbModel fZr;
    private ForumManageModel fZs;
    private b fZt;
    private AbsListView.OnScrollListener fZu;
    private TbRichTextView.i fZv;
    private TbRichTextView.h fZw;
    private SubPbModel.a fZx;
    private com.baidu.adp.base.d fZy;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int fLM = 0;
    PostData fLO = null;
    private a.InterfaceC0120a fLJ = null;
    private a fZz = null;
    private a fZA = null;
    private boolean fZB = false;
    private boolean fZC = false;
    private boolean fZE = false;
    private boolean aUs = false;
    private com.baidu.tbadk.editortools.pb.c aVL = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Lf() {
            NewSubPbActivity.this.fZt.bll();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aVM = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Le() {
            if (!NewSubPbActivity.this.fZG.bLs()) {
                return (NewSubPbActivity.this.eWV == null || NewSubPbActivity.this.fZr == null || NewSubPbActivity.this.fZr.ayP() == null || NewSubPbActivity.this.eWV.w(NewSubPbActivity.this.fZr.ayP().replyPrivateFlag, aj.axK)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.fZG.bLu());
            if (NewSubPbActivity.this.eXd.Lu()) {
                NewSubPbActivity.this.eXd.a(NewSubPbActivity.this.fPq);
            }
            NewSubPbActivity.this.lx(true);
            return true;
        }
    };
    private NewWriteModel.d fZI = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.eXd != null && NewSubPbActivity.this.eXd.KH() != null) {
                NewSubPbActivity.this.eXd.KH().hide();
                if (NewSubPbActivity.this.fZr.blF()) {
                    TiebaStatic.log(new am("c10367").ax("post_id", NewSubPbActivity.this.fZr.Lc()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fZG.wJ(null);
                NewSubPbActivity.this.fZG.aA(null);
                NewSubPbActivity.this.fZG.oa(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    NewSubPbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fZG.aA(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fZG.wJ(postWriteCallBackData.getErrorString());
                if (!com.baidu.tbadk.core.util.v.J(NewSubPbActivity.this.fZG.bLq())) {
                    NewSubPbActivity.this.fPq = postWriteCallBackData;
                    if (NewSubPbActivity.this.eXd.Lu()) {
                        NewSubPbActivity.this.eXd.a(NewSubPbActivity.this.fPq);
                    }
                    NewSubPbActivity.this.lx(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.eWV != null) {
                NewSubPbActivity.this.eWV.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.fZt.blm();
        }
    };
    private CustomMessageListener fLC = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fZD) {
                NewSubPbActivity.this.fZt.akj();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fLa.e(NewSubPbActivity.this.fKZ.getResources().getString(e.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.fKZ.getResources().getString(e.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.hB(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bha();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ao.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.fKZ.getResources().getString(e.j.mute_fail);
                    }
                    NewSubPbActivity.this.fLa.f(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fLD = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fZD) {
                NewSubPbActivity.this.fZt.akj();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fLa.e(NewSubPbActivity.this.fKZ.getResources().getString(e.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ao.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.fKZ.getResources().getString(e.j.un_mute_fail);
                }
                NewSubPbActivity.this.fLa.f(muteMessage);
            }
        }
    };
    private CustomMessageListener fLE = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fZD) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.fZt.akj();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.hqA;
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
                    NewSubPbActivity.this.fZt.a(sparseArray, z);
                }
            }
        }
    };
    boolean fLN = false;
    private final b.InterfaceC0124b fLQ = new b.InterfaceC0124b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.fLe != null && !TextUtils.isEmpty(NewSubPbActivity.this.fLf)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.fLg == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.fLf));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.fLf;
                        aVar.pkgId = NewSubPbActivity.this.fLg.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.fLg.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.buX == null) {
                        NewSubPbActivity.this.buX = new com.baidu.tbadk.core.util.b.a();
                    }
                    NewSubPbActivity.this.buX.Di();
                    NewSubPbActivity.this.buX.c(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.buX.z(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.fLd == null) {
                            NewSubPbActivity.this.fLd = new av(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.fLd.i(NewSubPbActivity.this.fLf, NewSubPbActivity.this.fLe.ov());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.fLe = null;
                NewSubPbActivity.this.fLf = null;
            }
        }
    };
    private CustomMessageListener eAR = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener dBv = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    com.baidu.tbadk.data.j jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.fZr.blz() != null && NewSubPbActivity.this.fZr.blz().bfC() != null && NewSubPbActivity.this.fZr.blz().bfC().yv() != null && currentAccount.equals(NewSubPbActivity.this.fZr.blz().bfC().yv().getUserId()) && NewSubPbActivity.this.fZr.blz().bfC().yv().getPendantData() != null) {
                        NewSubPbActivity.this.fZr.blz().bfC().yv().getPendantData().dR(jVar.xf());
                        NewSubPbActivity.this.fZr.blz().bfC().yv().getPendantData().af(jVar.Ko());
                        NewSubPbActivity.this.fZt.a(NewSubPbActivity.this.fZr.blz().bfC(), NewSubPbActivity.this.fZr.blz().aSn(), NewSubPbActivity.this.fZr.blz().vc(), NewSubPbActivity.this.fZr.bfh(), NewSubPbActivity.this.fZr.blL() != null);
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
        B(bundle);
        if (this.aUs) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.fKZ = getPageContext();
        this.fZC = true;
        this.fZG = new com.baidu.tieba.write.b();
        this.fZG.wg(e.d.cp_cont_h_alpha85);
        this.fZG.wf(e.d.cp_cont_i);
        aDP();
        blc();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        blb();
        this.fLa = new com.baidu.tbadk.core.view.g();
        this.fLa.aCM = 1000L;
        registerListener(this.fLE);
        registerListener(this.fLC);
        registerListener(this.fLD);
        this.fZD = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fZD;
        userMuteAddAndDelCustomMessage.setTag(this.fZD);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fZD;
        userMuteCheckCustomMessage.setTag(this.fZD);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eWV = new aj(getPageContext());
        this.eWV.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.eXd.Lz();
                }
            }
        });
        this.fKF = new com.baidu.tieba.pb.pb.report.a(this);
        this.fKF.o(getUniqueId());
        this.fKI = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    private void blb() {
        if (this.fZt != null && this.fZr != null && this.fZr.ble()) {
            this.fZF = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.fZt.aaD());
            this.fZF.aDU();
            this.fZF.a(new a.InterfaceC0252a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
                private boolean dOK = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0252a
                public void aDQ() {
                    NewSubPbActivity.this.fZt.gV(false);
                    this.dOK = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0252a
                public void aDR() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0252a
                public boolean aDS() {
                    if (!this.dOK) {
                        return NewSubPbActivity.this.fZt.aEg() != null && NewSubPbActivity.this.fZt.aEg().getTop() == 0;
                    }
                    this.dOK = false;
                    return false;
                }
            });
            this.fZt.e(this.fZF);
            this.fZt.gV(true);
        }
    }

    public void initUI() {
        this.fZt = new b(this, this.mCommonClickListener);
        this.fZt.a(this.fZr);
        setContentView(this.fZt.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.fZt.setOnScrollListener(this.fZu);
        this.fZt.a(this);
        this.fZt.setOnLinkImageClickListener(this.fZv);
        this.fZt.setOnImageClickListener(this.fZw);
        this.fZt.kl(true);
        this.fZt.setOnLongClickListener(this.aOZ);
        this.fZt.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.fZr != null) {
                    NewSubPbActivity.this.fZr.Nj();
                }
            }
        });
        this.fZt.a(this.fZz);
        this.fZt.b(this.fZA);
        if (this.fZr != null && this.fZr.ble() && !this.fZr.blK()) {
            this.fZt.blq().setVisibility(8);
        } else {
            this.fZt.blq().setVisibility(0);
        }
        if (this.fZr != null && !this.fZr.ble()) {
            this.fZt.setIsFromPb(false);
        }
    }

    private boolean B(Bundle bundle) {
        if (bundle != null) {
            this.aUs = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.aUs = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.aUs;
    }

    public void initData(Bundle bundle) {
        this.fZr = new SubPbModel(getPageContext());
        this.fZr.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.fZt.n(postData);
                NewSubPbActivity.this.fZt.a((BdListView.e) null);
            }
        });
        this.fZs = new ForumManageModel(getPageContext());
        this.fZs.setLoadDataCallBack(this.fZy);
        this.dAm = new VoiceManager();
        this.dAm.onCreate(getPageContext());
        this.fKG = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fKG != null) {
            this.fKG.a(this.fLJ);
        }
        if (bundle != null) {
            this.fZr.initWithBundle(bundle);
        } else {
            this.fZr.initWithIntent(getIntent());
        }
        this.fZr.a(this.fZx);
        if (this.fZr.ble()) {
            this.fZr.Nj();
        } else {
            this.fZr.blE();
        }
    }

    public void blc() {
        this.fZx = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, j jVar) {
                if (NewSubPbActivity.this.fZt != null) {
                    NewSubPbActivity.this.fZt.blm();
                }
                if (NewSubPbActivity.this.fZF != null && NewSubPbActivity.this.fZF.aDV()) {
                    NewSubPbActivity.this.fZF.mh(e.d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.ai(i, str);
                    return;
                }
                NewSubPbActivity.this.fZt.hideNoDataView();
                if (jVar != null) {
                    if (jVar.bfC() != null || NewSubPbActivity.this.fZr != null) {
                        jVar.bfC().a(NewSubPbActivity.this.fZr.blJ());
                    }
                    if (NewSubPbActivity.this.fZt != null) {
                        NewSubPbActivity.this.fZt.a(jVar, NewSubPbActivity.this.fZr.bfh(), NewSubPbActivity.this.fZr.blL() != null);
                        if (NewSubPbActivity.this.fZC) {
                            NewSubPbActivity.this.bld();
                            NewSubPbActivity.this.fZC = false;
                        }
                    }
                    if (NewSubPbActivity.this.eXd != null) {
                        NewSubPbActivity.this.eXd.a(jVar.ayP());
                    }
                    if (NewSubPbActivity.this.fZH == null) {
                        NewSubPbActivity.this.fZH = new com.baidu.tieba.pb.d();
                    }
                    NewSubPbActivity.this.fZH.setData(jVar);
                    NewSubPbActivity.this.fZH.setType(0);
                    NewSubPbActivity.this.eWV.a(NewSubPbActivity.this.fZr.blO());
                }
            }
        };
        this.fLJ = new a.InterfaceC0120a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0120a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.fKG != null) {
                        NewSubPbActivity.this.fKG.ay(z2);
                    }
                    MarkData vf = NewSubPbActivity.this.fKG.vf();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setType(2);
                    if (z2) {
                        dVar.setData(vf);
                        if (NewSubPbActivity.this.fKG != null) {
                            if (vf != null) {
                                NewSubPbActivity.this.fZr.lz(true);
                                NewSubPbActivity.this.fZr.sO(NewSubPbActivity.this.fZr.Lc());
                                NewSubPbActivity.this.showToast(e.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(e.j.add_mark));
                            }
                            if (NewSubPbActivity.this.fZt != null) {
                                NewSubPbActivity.this.fZt.ly(true);
                            }
                        }
                    } else {
                        dVar.setData(null);
                        NewSubPbActivity.this.fZr.lz(false);
                        NewSubPbActivity.this.fZr.sO(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(e.j.remove_mark));
                        if (NewSubPbActivity.this.fZt != null) {
                            NewSubPbActivity.this.fZt.ly(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(e.j.update_mark_failed));
            }
        };
        this.fZz = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.fZr.blz() != null && NewSubPbActivity.this.fZr.blz().YA() != null && NewSubPbActivity.this.fZr.blz().YA().yv() != null) {
                    str = String.valueOf(NewSubPbActivity.this.fZr.blz().YA().yv().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.fZr.blz().bfJ().getId(), NewSubPbActivity.this.fZr.blz().bfJ().getName(), NewSubPbActivity.this.fZr.blz().YA().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.fZA = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.fZs.bCN() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int l = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[1]), 0);
                        boolean g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[2]), false);
                        int l2 = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.fZr != null && NewSubPbActivity.this.fZr.blz() != null && NewSubPbActivity.this.fZr.blz().bfJ() != null && NewSubPbActivity.this.fZr.blz().YA() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.fZs.vd(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.fZs.a(NewSubPbActivity.this.fZr.blz().bfJ().getId(), NewSubPbActivity.this.fZr.blz().bfJ().getName(), NewSubPbActivity.this.fZr.blz().YA().getId(), valueOf, l2, l, g);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.fZy = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.fZt.a(NewSubPbActivity.this.fZs.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.fZs.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.gav != 1002 || bVar.eeU) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.fZt.a(1, dVar.HV, dVar.hfq, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean bt(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void aDP() {
        registerListener(this.dBv);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v48, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.fZt != null) {
                    if (view == NewSubPbActivity.this.fZt.blw()) {
                        NewSubPbActivity.this.fZt.bjW();
                        String str = view.getTag(e.g.tag_user_id) instanceof String ? (String) view.getTag(e.g.tag_user_id) : null;
                        String str2 = view.getTag(e.g.tag_user_name) instanceof String ? (String) view.getTag(e.g.tag_user_name) : null;
                        String str3 = view.getTag(e.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(e.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ay.CU().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.fZt.aEh()) {
                        if (view != NewSubPbActivity.this.fZt.blp()) {
                            if (view != NewSubPbActivity.this.fZt.blo()) {
                                if (view == NewSubPbActivity.this.fZt.blk()) {
                                    NewSubPbActivity.this.fZt.bjW();
                                    if (NewSubPbActivity.this.fZr.Nj()) {
                                        NewSubPbActivity.this.fZt.bli();
                                    }
                                } else if (view == NewSubPbActivity.this.fZt.blq() || view == NewSubPbActivity.this.fZt.blr() || view == NewSubPbActivity.this.fZt.blt()) {
                                    if (NewSubPbActivity.this.fZE) {
                                        NewSubPbActivity.this.fZE = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.fZr.bhP(), NewSubPbActivity.this.fZr.Lc(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.fZr.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.fZr.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.fZt.blu() == null || view != NewSubPbActivity.this.fZt.blu().biB()) {
                                    if (NewSubPbActivity.this.fZt.blu() == null || view != NewSubPbActivity.this.fZt.blu().biE()) {
                                        if (NewSubPbActivity.this.fZt.blu() == null || view != NewSubPbActivity.this.fZt.blu().biC()) {
                                            if (NewSubPbActivity.this.fZt.blu() == null || view != NewSubPbActivity.this.fZt.blu().biD()) {
                                                if (NewSubPbActivity.this.fZt.blu() == null || view != NewSubPbActivity.this.fZt.blu().biF()) {
                                                    if (view == NewSubPbActivity.this.fZt.bln() || view == NewSubPbActivity.this.fZt.blt()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.eXd.LC()) {
                                                                NewSubPbActivity.this.eXd.LD();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.eXd.hC(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof com.baidu.tieba.pb.pb.main.j)) {
                                                        if (NewSubPbActivity.this.fKN == null || view != NewSubPbActivity.this.fKN.biD()) {
                                                            if (NewSubPbActivity.this.fKN == null || view != NewSubPbActivity.this.fKN.biB()) {
                                                                if (NewSubPbActivity.this.fKN == null || view != NewSubPbActivity.this.fKN.biE()) {
                                                                    if (NewSubPbActivity.this.fKN == null || view != NewSubPbActivity.this.fKN.biF()) {
                                                                        if (NewSubPbActivity.this.fKN == null || view != NewSubPbActivity.this.fKN.biH()) {
                                                                            if (NewSubPbActivity.this.fKN == null || view != NewSubPbActivity.this.fKN.biI()) {
                                                                                if (NewSubPbActivity.this.fKN != null && view == NewSubPbActivity.this.fKN.biC()) {
                                                                                    if (!com.baidu.adp.lib.util.j.kX()) {
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
                                                                                            NewSubPbActivity.this.fZt.bA(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.fZt.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                            return;
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                int id = view.getId();
                                                                                if (id == e.g.pb_item_tail_content) {
                                                                                    if (ba.bI(NewSubPbActivity.this.getPageContext().getPageActivity())) {
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
                                                                                        if (postData.getType() != PostData.hcW && !TextUtils.isEmpty(postData.getBimg_url()) && i.ws().ww()) {
                                                                                            NewSubPbActivity.this.sL(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.fLe != null && !TextUtils.isEmpty(NewSubPbActivity.this.fLf)) {
                                                                                if (NewSubPbActivity.this.buX == null) {
                                                                                    NewSubPbActivity.this.buX = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.buX.Di();
                                                                                NewSubPbActivity.this.buX.c(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.buX.z(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.fLd == null) {
                                                                                        NewSubPbActivity.this.fLd = new av(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.fLd.i(NewSubPbActivity.this.fLf, NewSubPbActivity.this.fLe.ov());
                                                                                    NewSubPbActivity.this.fLe = null;
                                                                                    NewSubPbActivity.this.fLf = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.fLe != null && !TextUtils.isEmpty(NewSubPbActivity.this.fLf)) {
                                                                            if (NewSubPbActivity.this.fLg == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.fLf));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.fLf;
                                                                                aVar.pkgId = NewSubPbActivity.this.fLg.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.fLg.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.fLe = null;
                                                                            NewSubPbActivity.this.fLf = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.fLO != null) {
                                                                        NewSubPbActivity.this.fLO.da(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.fLO = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                if (sparseArray2 != null && (sparseArray2.get(e.g.tag_del_post_type) instanceof Integer) && (sparseArray2.get(e.g.tag_del_post_id) instanceof String) && (sparseArray2.get(e.g.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.fZt.a(((Integer) sparseArray2.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(e.g.tag_del_post_id), ((Integer) sparseArray2.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.bs(view);
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (!com.baidu.adp.lib.util.j.kX()) {
                                                            NewSubPbActivity.this.showToast(e.j.network_not_available);
                                                            return;
                                                        } else {
                                                            Object tag = view.getTag();
                                                            if (tag instanceof String) {
                                                                NewSubPbActivity.this.sm((String) tag);
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
                                                    } else if (ba.bI(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                        if (NewSubPbActivity.this.fZE) {
                                                            NewSubPbActivity.this.fZE = false;
                                                            return;
                                                        } else if (NewSubPbActivity.this.eWV == null || NewSubPbActivity.this.fZr == null || NewSubPbActivity.this.fZr.ayP() == null || NewSubPbActivity.this.eWV.di(NewSubPbActivity.this.fZr.ayP().replyPrivateFlag)) {
                                                            if (NewSubPbActivity.this.fZF != null) {
                                                                NewSubPbActivity.this.fZF.aDT();
                                                            }
                                                            SparseArray sparseArray4 = (SparseArray) view.getTag(e.g.tag_from);
                                                            if (sparseArray4 != null && (sparseArray4.get(e.g.tag_clip_board) instanceof PostData)) {
                                                                PostData postData2 = (PostData) sparseArray4.get(e.g.tag_clip_board);
                                                                if (postData2 != null && postData2.yv() != null) {
                                                                    MetaData yv = postData2.yv();
                                                                    NewSubPbActivity.this.eXd.setReplyId(yv.getUserId());
                                                                    if (!(sparseArray4.get(e.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray4.get(e.g.tag_is_subpb)).booleanValue() : true)) {
                                                                        NewSubPbActivity.this.eXd.hF("");
                                                                    } else {
                                                                        NewSubPbActivity.this.eXd.hF(yv.getName_show());
                                                                    }
                                                                }
                                                                NewSubPbActivity.this.fZt.blg();
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
                                                        ((PostData) sparseArray5.get(e.g.tag_clip_board)).da(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new am("c11739").x("obj_locate", 4));
                                            if (!com.baidu.adp.lib.util.j.kX()) {
                                                NewSubPbActivity.this.showToast(e.j.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.fZt.bjW();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.sm(str4);
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
                                        } else if (com.baidu.adp.lib.util.j.kX()) {
                                            NewSubPbActivity.this.fZt.bjW();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.bE(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(e.j.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.fZt.bjW();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.fZt.a(((Integer) sparseArray7.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray7.get(e.g.tag_del_post_id), ((Integer) sparseArray7.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(e.g.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new am("c11739").x("obj_locate", 2));
                                    NewSubPbActivity.this.fZt.bjW();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.fZr.blz() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.fZr.blz().bfC());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.fZt.blf();
                                NewSubPbActivity.this.fZt.blg();
                                if (NewSubPbActivity.this.eXd != null) {
                                    NewSubPbActivity.this.eXd.LF();
                                    if (NewSubPbActivity.this.fZF != null) {
                                        NewSubPbActivity.this.fZF.aDT();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.fZt.blf();
                            NewSubPbActivity.this.fZt.blg();
                            if (NewSubPbActivity.this.eXd != null) {
                                NewSubPbActivity.this.eXd.LE();
                                if (NewSubPbActivity.this.fZF != null) {
                                    NewSubPbActivity.this.fZF.aDT();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.eWV == null || NewSubPbActivity.this.fZr == null || NewSubPbActivity.this.fZr.ayP() == null || NewSubPbActivity.this.eWV.di(NewSubPbActivity.this.fZr.ayP().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.eXd.Lu()) {
                                NewSubPbActivity.this.eXd.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.fZt.blf();
                            NewSubPbActivity.this.fZt.blg();
                            if (NewSubPbActivity.this.eXd != null) {
                                NewSubPbActivity.this.eXd.LG();
                                if (NewSubPbActivity.this.fZF != null) {
                                    NewSubPbActivity.this.fZF.aDT();
                                }
                            }
                        }
                    }
                }
            }
        };
        this.fZu = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.fZt.bjW();
                }
                NewSubPbActivity.this.eXd.LD();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.fZt.blv();
            }
        };
        this.fLP = new b.InterfaceC0124b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.fZr.blz() != null) {
                    postData = NewSubPbActivity.this.fZr.blz().bfC();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.da(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.f(postData);
                    }
                }
            }
        };
        this.aOZ = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                if (sparseArray == null && NewSubPbActivity.this.bt(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.fLe = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.fLf = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.fLe != null && !TextUtils.isEmpty(NewSubPbActivity.this.fLf)) {
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.fLg = null;
                            } else {
                                NewSubPbActivity.this.fLg = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                NewSubPbActivity.this.fZt.a(NewSubPbActivity.this.fLQ, NewSubPbActivity.this.fLe.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                NewSubPbActivity.this.fLO = (PostData) sparseArray2.get(e.g.tag_clip_board);
                                if (NewSubPbActivity.this.fLO != null && NewSubPbActivity.this.fKG != null) {
                                    if (NewSubPbActivity.this.fKG != null) {
                                        NewSubPbActivity.this.fKG.ay(NewSubPbActivity.this.fZr.isMarked());
                                    }
                                    boolean z = NewSubPbActivity.this.fKG.vc() && NewSubPbActivity.this.fLO.getId() != null && NewSubPbActivity.this.fLO.getId().equals(NewSubPbActivity.this.fZr.blG());
                                    if (NewSubPbActivity.this.fKN == null) {
                                        NewSubPbActivity.this.fKN = new y(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.mCommonClickListener);
                                        NewSubPbActivity.this.fZt.bC(NewSubPbActivity.this.fKN.getView());
                                        NewSubPbActivity.this.fKN.kK(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.fKN.showDialog();
                                    boolean isLogin = NewSubPbActivity.this.isLogin() & NewSubPbActivity.this.ks(sparseArray2.get(e.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(e.g.tag_del_post_is_self)).booleanValue() : false);
                                    boolean booleanValue = sparseArray2.get(e.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(e.g.tag_is_subpb)).booleanValue() : false;
                                    if (z) {
                                        NewSubPbActivity.this.fKN.biB().setText(e.j.remove_mark);
                                    } else {
                                        NewSubPbActivity.this.fKN.biB().setText(e.j.mark);
                                    }
                                    if (booleanValue) {
                                        NewSubPbActivity.this.fKN.biB().setVisibility(8);
                                    } else {
                                        NewSubPbActivity.this.fKN.biB().setVisibility(0);
                                    }
                                    if (NewSubPbActivity.this.bt(view)) {
                                        if (NewSubPbActivity.this.fLe != null && !NewSubPbActivity.this.fLe.isGif()) {
                                            sparseArray2.put(e.g.tag_richtext_image, true);
                                        } else {
                                            sparseArray2.put(e.g.tag_richtext_image, false);
                                        }
                                        sparseArray2.put(e.g.tag_richtext_emotion, true);
                                    } else {
                                        sparseArray2.put(e.g.tag_richtext_image, false);
                                        sparseArray2.put(e.g.tag_richtext_emotion, false);
                                    }
                                    NewSubPbActivity.this.fKN.a(sparseArray2, NewSubPbActivity.this.bfh(), isLogin);
                                    NewSubPbActivity.this.fKN.refreshUI();
                                }
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            NewSubPbActivity.this.fLe = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                NewSubPbActivity.this.fLf = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.fLg = null;
                            } else {
                                NewSubPbActivity.this.fLg = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.fLe = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.fLf = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.fLg = null;
                        } else {
                            NewSubPbActivity.this.fLg = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
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
        this.fZv = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void e(View view, String str) {
                NewSubPbActivity.this.l(null, str, "LINK_IMAGE");
            }
        };
        this.fZw = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                        j blz = NewSubPbActivity.this.fZr.blz();
                        TbRichText aK = NewSubPbActivity.this.aK(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (aK != null && aK.QK() != null) {
                            tbRichTextData = aK.QK().get(NewSubPbActivity.this.fLM);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.QQ().Rc()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (blz == null) {
                                    str3 = null;
                                    z4 = false;
                                } else {
                                    if (blz.bfJ() != null) {
                                        str4 = blz.bfJ().getName();
                                        str5 = blz.bfJ().getId();
                                    }
                                    if (blz.YA() != null) {
                                        str6 = blz.YA().getId();
                                    }
                                    str3 = str6;
                                    z4 = true;
                                }
                                if (NewSubPbActivity.this.fZr.blL() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.fZr.blL();
                                    z5 = NewSubPbActivity.this.fZr.blN();
                                    arrayList2 = NewSubPbActivity.this.fZr.blM();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z5 = z4;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(com.baidu.tbadk.core.util.v.d(arrayList2, 0));
                                NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                                return;
                            }
                            NewSubPbActivity.this.fLN = false;
                            String str7 = "";
                            TbRichText bCd = blz.bfC().bCd();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(bCd, aK, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (blz == null) {
                                str2 = null;
                                z2 = false;
                            } else {
                                if (blz.bfJ() != null) {
                                    str8 = blz.bfJ().getName();
                                    str9 = blz.bfJ().getId();
                                }
                                if (blz.YA() != null) {
                                    str10 = blz.YA().getId();
                                }
                                str2 = str10;
                                z2 = true;
                            }
                            if (NewSubPbActivity.this.fZr.blL() != null) {
                                concurrentHashMap = NewSubPbActivity.this.fZr.blL();
                                z3 = NewSubPbActivity.this.fZr.blN();
                                arrayList = NewSubPbActivity.this.fZr.blM();
                                i2 = a2 + NewSubPbActivity.this.fZr.getOffset();
                            } else {
                                concurrentHashMap = concurrentHashMap3;
                                i2 = a2;
                                z3 = z2;
                                arrayList = arrayList2;
                            }
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(com.baidu.tbadk.core.util.v.d(arrayList, i2));
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
    public void bs(View view) {
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
        TbRichTextImageInfo QQ;
        if (tbRichText == tbRichText2) {
            this.fLN = true;
        }
        if (tbRichText != null && tbRichText.QK() != null) {
            int size = tbRichText.QK().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.QK().get(i6) != null && tbRichText.QK().get(i6).getType() == 8) {
                    i5++;
                    int aR = (int) l.aR(TbadkCoreApplication.getInst());
                    int width = tbRichText.QK().get(i6).QQ().getWidth() * aR;
                    int height = tbRichText.QK().get(i6).QQ().getHeight() * aR;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.QK().get(i6).QQ().Rc()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.QK().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (QQ = tbRichTextData.QQ()) != null) {
                            String Rf = QQ.Rf();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Rf;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.fLN) {
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
        if (this.fKN != null) {
            this.fKN.kK(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo QQ = tbRichTextData.QQ();
        if (QQ != null) {
            if (!StringUtils.isNull(QQ.Rb())) {
                return QQ.Rb();
            }
            if (QQ.getHeight() * QQ.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (QQ.getHeight() * QQ.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (QQ.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * QQ.getHeight())));
            } else {
                float width = QQ.getWidth() / QQ.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ao.bx(QQ.Rd()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aK(String str, int i) {
        if (this.fZr == null || this.fZr.blz() == null || str == null || i < 0) {
            return null;
        }
        j blz = this.fZr.blz();
        TbRichText a2 = a(blz.bfC(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(blz.bfC(), str, i);
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
        TbRichText bCd = postData.bCd();
        if (bCd != null) {
            ArrayList<TbRichTextData> QK = bCd.QK();
            int size = QK.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (QK.get(i3) != null && QK.get(i3).getType() == 8) {
                    i2++;
                    if (QK.get(i3).QQ().Rf().equals(str)) {
                        int aR = (int) l.aR(TbadkCoreApplication.getInst());
                        int width = QK.get(i3).QQ().getWidth() * aR;
                        int height = QK.get(i3).QQ().getHeight() * aR;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.fLM = i3;
                        return bCd;
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
    public boolean ks(boolean z) {
        if (this.fZr == null) {
            return false;
        }
        return ((bfh() != 0) || this.fZr.blz() == null || this.fZr.blz().YA() == null || this.fZr.blz().YA().yv() == null || TextUtils.equals(this.fZr.blz().YA().yv().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Context context, String str, String str2) {
        long templateId = this.fZr.blz().bfC().bCk() != null ? this.fZr.blz().bfC().bCk().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ay.CU().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.fZr.blz().bfJ().getId(), this.fZr.blz().bfJ().getName(), this.fZr.blz().YA().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(int i, String str) {
        if (this.fZr.blA()) {
            showToast(str);
        } else if (l.lo()) {
            if (i == 4) {
                this.fZt.nM(str + "(4)");
            } else {
                this.fZt.jq(e.j.no_data_text);
            }
        } else {
            this.fZt.jq(e.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.eXd = (g) new com.baidu.tbadk.editortools.pb.h().bM(getActivity());
        if (this.eXd != null) {
            this.eXd.setContext(getPageContext());
            this.eXd.b(this.fZr);
            this.eXd.b(this.fZI);
            this.eXd.a(this.aVL);
            this.eXd.a(this.aVM);
            this.eXd.KH().bY(true);
            this.eXd.d(getPageContext());
        }
        if (this.fZt != null) {
            this.fZt.g(this.eXd);
        }
        if (this.eXd != null && this.fZr != null) {
            this.eXd.a(this.fZr.ayP());
            this.eXd.LD();
        }
        if (this.eXd != null) {
            this.fWz = this.eXd.LH().getInputView();
            this.fWz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.fZG != null) {
                        if (!NewSubPbActivity.this.fZG.bLt()) {
                            NewSubPbActivity.this.lx(false);
                        }
                        NewSubPbActivity.this.fZG.ob(false);
                    }
                }
            });
        }
    }

    public void bld() {
        if (!TbadkCoreApplication.isLogin()) {
            this.eXd.LD();
        } else if (!StringUtils.isNull(this.fZr.blH())) {
            if (this.fZt.blj() && l.lo()) {
                this.fZt.avV();
            } else {
                this.fZt.blm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(View view) {
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
                    this.fZt.bA(view);
                }
            } else if (booleanValue2) {
                this.fZt.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.fZt.bls(), getPageContext().getPageActivity());
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
            bVar.cC(e.j.operation);
            bVar.a(strArr, new b.InterfaceC0124b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.fZD);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.fZD);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).Ax();
        }
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(e.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(e.g.tag_user_mute_mute_userid);
        }
        this.fZt.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.fZD;
        userMuteCheckCustomMessage.setTag(this.fZD);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.fZt.a(0, bVar.HV, bVar.hfq, z);
            if (bVar.HV) {
                if (bVar.hfo == 1) {
                    if (this.fZt.getListView() instanceof BdTypeListView) {
                        List<com.baidu.adp.widget.ListView.h> data = ((BdTypeListView) this.fZt.getListView()).getData();
                        if (!com.baidu.tbadk.core.util.v.J(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            data.remove(i);
                            this.fZt.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.hfo == 2) {
                    this.fZr.sN(bVar.mPostId);
                    this.fZt.a(this.fZr.blz(), this.fZr.bfh(), this.fZr.blL() != null);
                    if (this.fZr.blI()) {
                        this.fZr.lA(false);
                        this.fZt.blh();
                        this.fZr.Nj();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
            }
        }
    }

    public void sm(String str) {
        this.fKF.sJ(str);
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.fZr.isMarked() && postData.getId() != null && postData.getId().equals(this.fZr.blG())) {
                z = true;
            }
            MarkData h = this.fZr.h(postData);
            if (h != null) {
                this.fZt.bjW();
                if (this.fKG != null) {
                    this.fKG.a(h);
                    if (!z) {
                        this.fKG.ve();
                    } else {
                        this.fKG.vd();
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
        if (bundle != null && this.fZr != null) {
            this.fZr.A(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.eXd != null) {
            this.eXd.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.eXd.KH().Jg();
        this.eXd.LD();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eXd.b(writeData);
                this.eXd.setVoiceModel(pbEditorData.getVoiceModel());
                k fi = this.eXd.KH().fi(6);
                if (fi != null && fi.aTV != null) {
                    fi.aTV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eXd.Lz();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dAm != null) {
            this.dAm.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.fZB = true;
        super.onPause();
        if (this.dAm != null) {
            this.dAm.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.eAR);
        this.fZt.aCT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fZB = false;
        super.onResume();
        if (this.dAm != null) {
            this.dAm.onResume(getPageContext());
        }
        registerListener(this.eAR);
        this.fZt.aCU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dAm != null) {
            this.dAm.onStop(getPageContext());
        }
        this.eXd.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.fZH));
        this.fZr.cancelLoadData();
        this.fZr.destory();
        this.fZs.cancelLoadData();
        if (this.dAm != null) {
            this.dAm.onDestory(getPageContext());
        }
        this.fZt.bjW();
        this.fZt.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.fLC);
        MessageManager.getInstance().unRegisterListener(this.fLD);
        MessageManager.getInstance().unRegisterListener(this.fLE);
        MessageManager.getInstance().unRegisterListener(this.fZD);
        this.fKZ = null;
        this.fLa = null;
        if (this.dAY != null) {
            this.dAY.onDestroy();
        }
        if (this.eWV != null) {
            this.eWV.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fZt.onChangeSkinType(i);
        if (this.dAY != null) {
            this.dAY.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dAm;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bln = this.fZt.bln();
        if (bln == null || (findViewWithTag = bln.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean sC(String str) {
        Map<String, String> fv;
        if (!TextUtils.isEmpty(str) && (fv = ay.fv(ay.fw(str))) != null) {
            this.fZE = true;
            String str2 = fv.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return sC(com.baidu.adp.lib.util.k.by(str2));
            }
            String str3 = fv.get(fZq);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (sC(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
                    iVar.mLink = str;
                    iVar.type = 3;
                    iVar.aSZ = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, iVar));
                }
            } else {
                ay.CU().c(getPageContext(), new String[]{str});
            }
            this.fZE = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fZE = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ap(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void i(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.fZt != null) {
            return this.fZt.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Rr() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Rt() {
        if (this.bnv == null) {
            this.bnv = TbRichTextView.n(getPageContext().getPageActivity(), 8);
        }
        return this.bnv;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Ru() {
        if (this.bnz == null) {
            this.bnz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bhf */
                public GifView jB() {
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
        return this.bnz;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Rs() {
        if (this.bnu == null) {
            this.bnu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: alr */
                public ImageView jB() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean ww = i.ws().ww();
                    foreDrawableImageView.setDefaultBg(al.getDrawable(e.d.common_color_10220));
                    if (ww) {
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
                        if (i.ws().ww()) {
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
        return this.bnu;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Rv() {
        if (this.bnw == null) {
            this.bnw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bhg */
                public View jB() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(e.C0175e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bv */
                public void u(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bw */
                public View v(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bx */
                public View w(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.bnw;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Rw() {
        if (this.bnx == null) {
            this.bnx = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bhi */
                public LinearLayout jB() {
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
        return this.bnx;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Rx() {
        this.bny = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bhh */
            public RelativeLayout jB() {
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
        return this.bny;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bfP() {
        return this.fKI;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bfQ() {
        return (this.fZr == null || this.fZr.blz() == null || this.fZr.blz().YA() == null || this.fZr.blz().YA().zG()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bfR() {
        if (this.fZr == null || this.fZr.blz() == null || this.fZr.blz().YA() == null) {
            return null;
        }
        return this.fZr.blz().YA().yB();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bfS() {
        if (this.fZr == null) {
            return 0;
        }
        return this.fZr.bfh();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean sj(String str) {
        if (StringUtils.isNull(str) || this.fZr == null || this.fZr.blz() == null || this.fZr.blz().YA() == null || this.fZr.blz().YA().yv() == null) {
            return false;
        }
        return str.equals(this.fZr.blz().YA().yv().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fZt.blj() && l.lo()) {
            this.fZr.Nj();
        } else {
            this.fZt.blm();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.fZD);
        userMuteAddAndDelCustomMessage.setTag(this.fZD);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sL(String str) {
        if (!StringUtils.isNull(str) && ba.bI(getPageContext().getPageActivity())) {
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
    public void aq(Context context, String str) {
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
            public boolean Nz() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int NA() {
                return com.baidu.tbadk.pageStayDuration.e.NE().NG();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.fZr != null) {
            if (this.fZr.blz() != null && this.fZr.blz().bfJ() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.fZr.blz().bfJ().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.fZr.bhP(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.fZB;
    }

    public boolean ble() {
        if (this.fZr != null) {
            return this.fZr.ble();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.fZt.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fKZ.getPageActivity());
        if (ao.isEmpty(str)) {
            aVar.ej(this.fKZ.getResources().getString(e.j.block_mute_message_alert, str3));
        } else {
            aVar.ej(str);
        }
        aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.fZt.showLoadingDialog();
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
        aVar.b(this.fKZ).Au();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hB(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fKZ.getPageActivity());
        aVar.ej(str);
        aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fKZ).Au();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bha() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ej(getResources().getString(e.j.mute_is_super_member_function));
        aVar.a(e.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.fKZ).showToast(e.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.fKZ.getPageActivity(), 2, true, 4);
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
        aVar.b(this.fKZ).Au();
    }

    public int bfh() {
        if (this.fZr != null) {
            return this.fZr.bfh();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.aUs) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.aUs) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void lx(boolean z) {
        if (this.fWz != null && this.fWz.getText() != null) {
            int selectionEnd = this.fWz.getSelectionEnd();
            SpannableStringBuilder b = this.fZG.b(this.fWz.getText());
            if (b != null) {
                this.fZG.ob(true);
                this.fWz.setText(b);
                if (z && this.fZG.bLr() >= 0) {
                    this.fWz.requestFocus();
                    this.fWz.setSelection(this.fZG.bLr());
                } else {
                    this.fWz.setSelection(selectionEnd);
                }
                this.fZG.oa(this.fZG.bLr() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.dAY == null) {
            this.dAY = new h(getPageContext());
            this.dAY.a(new h.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void aW(boolean z) {
                    if (z) {
                        TiebaStatic.log(new am("c13061"));
                    }
                }
            });
        }
        this.dAY.a(contriInfo, -1L);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.eXd != null && this.eXd.KH() != null && this.eXd.KH().KK()) {
            this.eXd.KH().Jg();
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
