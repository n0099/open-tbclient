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
/* loaded from: classes2.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.e, com.baidu.tieba.pb.pb.a<NewSubPbActivity> {
    private static final String fQt = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String fRQ = "tbgametype";
    private View.OnLongClickListener aKx;
    private com.baidu.adp.lib.e.b<ImageView> bjq;
    private com.baidu.adp.lib.e.b<TextView> bjr;
    private com.baidu.adp.lib.e.b<View> bjs;
    private com.baidu.adp.lib.e.b<LinearLayout> bjt;
    private com.baidu.adp.lib.e.b<RelativeLayout> bju;
    private com.baidu.adp.lib.e.b<GifView> bjv;
    private com.baidu.tbadk.core.util.b.a bqO;
    private h dsX;
    private VoiceManager dsk;
    public aj ePn;
    private g ePv;
    private av fDC;
    private com.baidu.adp.widget.ImageView.a fDD;
    private String fDE;
    private TbRichTextMemeInfo fDF;
    private com.baidu.tieba.pb.pb.report.a fDe;
    private com.baidu.tbadk.baseEditMark.a fDf;
    private com.baidu.tieba.pb.pb.main.b.a fDh;
    private y fDm;
    private com.baidu.adp.base.e fDy;
    private com.baidu.tbadk.core.view.g fDz;
    private b.InterfaceC0100b fEo;
    private PostWriteCallBackData fHP;
    private EditText fOZ;
    private SubPbModel fRR;
    private ForumManageModel fRS;
    private b fRT;
    private AbsListView.OnScrollListener fRU;
    private TbRichTextView.i fRV;
    private TbRichTextView.h fRW;
    private SubPbModel.a fRX;
    private com.baidu.adp.base.d fRY;
    private BdUniqueId fSd;
    private com.baidu.tieba.pb.pb.sub.a fSf;
    private com.baidu.tieba.write.b fSg;
    private com.baidu.tieba.pb.d<j> fSh;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int fEl = 0;
    PostData fEn = null;
    private a.InterfaceC0096a fEi = null;
    private a fRZ = null;
    private a fSa = null;
    private boolean fSb = false;
    private boolean fSc = false;
    private boolean fSe = false;
    private boolean aPR = false;
    private com.baidu.tbadk.editortools.pb.c aRk = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Jh() {
            NewSubPbActivity.this.fRT.bhZ();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aRl = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Jg() {
            if (!NewSubPbActivity.this.fSg.bIg()) {
                return (NewSubPbActivity.this.ePn == null || NewSubPbActivity.this.fRR == null || NewSubPbActivity.this.fRR.avt() == null || NewSubPbActivity.this.ePn.w(NewSubPbActivity.this.fRR.avt().replyPrivateFlag, aj.asZ)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.fSg.bIi());
            if (NewSubPbActivity.this.ePv.Jw()) {
                NewSubPbActivity.this.ePv.a(NewSubPbActivity.this.fHP);
            }
            NewSubPbActivity.this.lg(true);
            return true;
        }
    };
    private NewWriteModel.d fSi = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.ePv != null && NewSubPbActivity.this.ePv.IJ() != null) {
                NewSubPbActivity.this.ePv.IJ().hide();
                if (NewSubPbActivity.this.fRR.bit()) {
                    TiebaStatic.log(new am("c10367").al("post_id", NewSubPbActivity.this.fRR.Je()));
                }
            }
            if (z) {
                NewSubPbActivity.this.fSg.wi(null);
                NewSubPbActivity.this.fSg.aA(null);
                NewSubPbActivity.this.fSg.nK(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    NewSubPbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.fSg.aA(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.fSg.wi(postWriteCallBackData.getErrorString());
                if (!com.baidu.tbadk.core.util.v.z(NewSubPbActivity.this.fSg.bIe())) {
                    NewSubPbActivity.this.fHP = postWriteCallBackData;
                    if (NewSubPbActivity.this.ePv.Jw()) {
                        NewSubPbActivity.this.ePv.a(NewSubPbActivity.this.fHP);
                    }
                    NewSubPbActivity.this.lg(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.ePn != null) {
                NewSubPbActivity.this.ePn.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.fRT.bia();
        }
    };
    private CustomMessageListener fEb = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fSd) {
                NewSubPbActivity.this.fRT.agD();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fDz.e(NewSubPbActivity.this.fDy.getResources().getString(e.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.fDy.getResources().getString(e.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.hn(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bdO();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ao.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.fDy.getResources().getString(e.j.mute_fail);
                    }
                    NewSubPbActivity.this.fDz.f(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fEc = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fSd) {
                NewSubPbActivity.this.fRT.agD();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fDz.e(NewSubPbActivity.this.fDy.getResources().getString(e.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ao.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.fDy.getResources().getString(e.j.un_mute_fail);
                }
                NewSubPbActivity.this.fDz.f(muteMessage);
            }
        }
    };
    private CustomMessageListener fEd = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.fSd) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.fRT.agD();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.hjk;
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
                    NewSubPbActivity.this.fRT.a(sparseArray, z);
                }
            }
        }
    };
    boolean fEm = false;
    private final b.InterfaceC0100b fEp = new b.InterfaceC0100b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.fDD != null && !TextUtils.isEmpty(NewSubPbActivity.this.fDE)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.fDF == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.fDE));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.fDE;
                        aVar.pkgId = NewSubPbActivity.this.fDF.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.fDF.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.bqO == null) {
                        NewSubPbActivity.this.bqO = new com.baidu.tbadk.core.util.b.a();
                    }
                    NewSubPbActivity.this.bqO.Bb();
                    NewSubPbActivity.this.bqO.c(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.bqO.x(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.fDC == null) {
                            NewSubPbActivity.this.fDC = new av(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.fDC.i(NewSubPbActivity.this.fDE, NewSubPbActivity.this.fDD.ok());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.fDD = null;
                NewSubPbActivity.this.fDE = null;
            }
        }
    };
    private CustomMessageListener etb = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener dtu = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    com.baidu.tbadk.data.j jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.fRR.bin() != null && NewSubPbActivity.this.fRR.bin().bcq() != null && NewSubPbActivity.this.fRR.bin().bcq().wm() != null && currentAccount.equals(NewSubPbActivity.this.fRR.bin().bcq().wm().getUserId()) && NewSubPbActivity.this.fRR.bin().bcq().wm().getPendantData() != null) {
                        NewSubPbActivity.this.fRR.bin().bcq().wm().getPendantData().dB(jVar.uW());
                        NewSubPbActivity.this.fRR.bin().bcq().wm().getPendantData().ad(jVar.Ip());
                        NewSubPbActivity.this.fRT.a(NewSubPbActivity.this.fRR.bin().bcq(), NewSubPbActivity.this.fRR.bin().aOZ(), NewSubPbActivity.this.fRR.bin().sR(), NewSubPbActivity.this.fRR.bbV(), NewSubPbActivity.this.fRR.biz() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void j(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        A(bundle);
        if (this.aPR) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.fDy = getPageContext();
        this.fSc = true;
        this.fSg = new com.baidu.tieba.write.b();
        this.fSg.vJ(e.d.cp_cont_h_alpha85);
        this.fSg.vI(e.d.cp_cont_i);
        aAw();
        bhQ();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bhP();
        this.fDz = new com.baidu.tbadk.core.view.g();
        this.fDz.ayd = 1000L;
        registerListener(this.fEd);
        registerListener(this.fEb);
        registerListener(this.fEc);
        this.fSd = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fSd;
        userMuteAddAndDelCustomMessage.setTag(this.fSd);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fSd;
        userMuteCheckCustomMessage.setTag(this.fSd);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.ePn = new aj(getPageContext());
        this.ePn.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.ePv.JB();
                }
            }
        });
        this.fDe = new com.baidu.tieba.pb.pb.report.a(this);
        this.fDe.o(getUniqueId());
        this.fDh = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    private void bhP() {
        if (this.fRT != null && this.fRR != null && this.fRR.bhS()) {
            this.fSf = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.fRT.WW());
            this.fSf.aAB();
            this.fSf.a(new a.InterfaceC0218a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
                private boolean dGL = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0218a
                public void aAx() {
                    NewSubPbActivity.this.fRT.gD(false);
                    this.dGL = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0218a
                public void aAy() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0218a
                public boolean aAz() {
                    if (!this.dGL) {
                        return NewSubPbActivity.this.fRT.aAN() != null && NewSubPbActivity.this.fRT.aAN().getTop() == 0;
                    }
                    this.dGL = false;
                    return false;
                }
            });
            this.fRT.e(this.fSf);
            this.fRT.gD(true);
        }
    }

    public void initUI() {
        this.fRT = new b(this, this.mCommonClickListener);
        this.fRT.a(this.fRR);
        setContentView(this.fRT.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.fRT.setOnScrollListener(this.fRU);
        this.fRT.a(this);
        this.fRT.setOnLinkImageClickListener(this.fRV);
        this.fRT.setOnImageClickListener(this.fRW);
        this.fRT.jU(true);
        this.fRT.setOnLongClickListener(this.aKx);
        this.fRT.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.fRR != null) {
                    NewSubPbActivity.this.fRR.Ll();
                }
            }
        });
        this.fRT.a(this.fRZ);
        this.fRT.b(this.fSa);
        if (this.fRR != null && this.fRR.bhS() && !this.fRR.biy()) {
            this.fRT.bie().setVisibility(8);
        } else {
            this.fRT.bie().setVisibility(0);
        }
        if (this.fRR != null && !this.fRR.bhS()) {
            this.fRT.setIsFromPb(false);
        }
    }

    private boolean A(Bundle bundle) {
        if (bundle != null) {
            this.aPR = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.aPR = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.aPR;
    }

    public void initData(Bundle bundle) {
        this.fRR = new SubPbModel(getPageContext());
        this.fRR.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.fRT.n(postData);
                NewSubPbActivity.this.fRT.a((BdListView.e) null);
            }
        });
        this.fRS = new ForumManageModel(getPageContext());
        this.fRS.setLoadDataCallBack(this.fRY);
        this.dsk = new VoiceManager();
        this.dsk.onCreate(getPageContext());
        this.fDf = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fDf != null) {
            this.fDf.a(this.fEi);
        }
        if (bundle != null) {
            this.fRR.initWithBundle(bundle);
        } else {
            this.fRR.initWithIntent(getIntent());
        }
        this.fRR.a(this.fRX);
        if (this.fRR.bhS()) {
            this.fRR.Ll();
        } else {
            this.fRR.bis();
        }
    }

    public void bhQ() {
        this.fRX = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, j jVar) {
                if (NewSubPbActivity.this.fRT != null) {
                    NewSubPbActivity.this.fRT.bia();
                }
                if (NewSubPbActivity.this.fSf != null && NewSubPbActivity.this.fSf.aAC()) {
                    NewSubPbActivity.this.fSf.lJ(e.d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.ai(i, str);
                    return;
                }
                NewSubPbActivity.this.fRT.hideNoDataView();
                if (jVar != null) {
                    if (jVar.bcq() != null || NewSubPbActivity.this.fRR != null) {
                        jVar.bcq().a(NewSubPbActivity.this.fRR.bix());
                    }
                    if (NewSubPbActivity.this.fRT != null) {
                        NewSubPbActivity.this.fRT.a(jVar, NewSubPbActivity.this.fRR.bbV(), NewSubPbActivity.this.fRR.biz() != null);
                        if (NewSubPbActivity.this.fSc) {
                            NewSubPbActivity.this.bhR();
                            NewSubPbActivity.this.fSc = false;
                        }
                    }
                    if (NewSubPbActivity.this.ePv != null) {
                        NewSubPbActivity.this.ePv.a(jVar.avt());
                    }
                    if (NewSubPbActivity.this.fSh == null) {
                        NewSubPbActivity.this.fSh = new com.baidu.tieba.pb.d();
                    }
                    NewSubPbActivity.this.fSh.setData(jVar);
                    NewSubPbActivity.this.fSh.setType(0);
                    NewSubPbActivity.this.ePn.a(NewSubPbActivity.this.fRR.biC());
                }
            }
        };
        this.fEi = new a.InterfaceC0096a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0096a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.fDf != null) {
                        NewSubPbActivity.this.fDf.an(z2);
                    }
                    MarkData sU = NewSubPbActivity.this.fDf.sU();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setType(2);
                    if (z2) {
                        dVar.setData(sU);
                        if (NewSubPbActivity.this.fDf != null) {
                            if (sU != null) {
                                NewSubPbActivity.this.fRR.li(true);
                                NewSubPbActivity.this.fRR.sn(NewSubPbActivity.this.fRR.Je());
                                NewSubPbActivity.this.showToast(e.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(e.j.add_mark));
                            }
                            if (NewSubPbActivity.this.fRT != null) {
                                NewSubPbActivity.this.fRT.lh(true);
                            }
                        }
                    } else {
                        dVar.setData(null);
                        NewSubPbActivity.this.fRR.li(false);
                        NewSubPbActivity.this.fRR.sn(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(e.j.remove_mark));
                        if (NewSubPbActivity.this.fRT != null) {
                            NewSubPbActivity.this.fRT.lh(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(e.j.update_mark_failed));
            }
        };
        this.fRZ = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void j(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.fRR.bin() != null && NewSubPbActivity.this.fRR.bin().UT() != null && NewSubPbActivity.this.fRR.bin().UT().wm() != null) {
                    str = String.valueOf(NewSubPbActivity.this.fRR.bin().UT().wm().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.fRR.bin().bcx().getId(), NewSubPbActivity.this.fRR.bin().bcx().getName(), NewSubPbActivity.this.fRR.bin().UT().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.fSa = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void j(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.fRS.bzy() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int l = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int l2 = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.fRR != null && NewSubPbActivity.this.fRR.bin() != null && NewSubPbActivity.this.fRR.bin().bcx() != null && NewSubPbActivity.this.fRR.bin().UT() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.fRS.uB(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.fRS.a(NewSubPbActivity.this.fRR.bin().bcx().getId(), NewSubPbActivity.this.fRR.bin().bcx().getName(), NewSubPbActivity.this.fRR.bin().UT().getId(), valueOf, l2, l, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.fRY = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void j(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.fRT.a(NewSubPbActivity.this.fRS.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.fRS.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.fSV != 1002 || bVar.dXb) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.fRT.a(1, dVar.Hs, dVar.gXX, true);
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

    public void aAw() {
        registerListener(this.dtu);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v48, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.fRT != null) {
                    if (view == NewSubPbActivity.this.fRT.bik()) {
                        NewSubPbActivity.this.fRT.bgK();
                        String str = view.getTag(e.g.tag_user_id) instanceof String ? (String) view.getTag(e.g.tag_user_id) : null;
                        String str2 = view.getTag(e.g.tag_user_name) instanceof String ? (String) view.getTag(e.g.tag_user_name) : null;
                        String str3 = view.getTag(e.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(e.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ay.AN().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.fRT.aAO()) {
                        if (view != NewSubPbActivity.this.fRT.bid()) {
                            if (view != NewSubPbActivity.this.fRT.bic()) {
                                if (view == NewSubPbActivity.this.fRT.bhY()) {
                                    NewSubPbActivity.this.fRT.bgK();
                                    if (NewSubPbActivity.this.fRR.Ll()) {
                                        NewSubPbActivity.this.fRT.bhW();
                                    }
                                } else if (view == NewSubPbActivity.this.fRT.bie() || view == NewSubPbActivity.this.fRT.bif() || view == NewSubPbActivity.this.fRT.bih()) {
                                    if (NewSubPbActivity.this.fSe) {
                                        NewSubPbActivity.this.fSe = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.fRR.beD(), NewSubPbActivity.this.fRR.Je(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.fRR.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.fRR.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.fRT.bii() == null || view != NewSubPbActivity.this.fRT.bii().bfp()) {
                                    if (NewSubPbActivity.this.fRT.bii() == null || view != NewSubPbActivity.this.fRT.bii().bfs()) {
                                        if (NewSubPbActivity.this.fRT.bii() == null || view != NewSubPbActivity.this.fRT.bii().bfq()) {
                                            if (NewSubPbActivity.this.fRT.bii() == null || view != NewSubPbActivity.this.fRT.bii().bfr()) {
                                                if (NewSubPbActivity.this.fRT.bii() == null || view != NewSubPbActivity.this.fRT.bii().bft()) {
                                                    if (view == NewSubPbActivity.this.fRT.bib() || view == NewSubPbActivity.this.fRT.bih()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.ePv.JE()) {
                                                                NewSubPbActivity.this.ePv.JF();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.ePv.ho(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof com.baidu.tieba.pb.pb.main.j)) {
                                                        if (NewSubPbActivity.this.fDm == null || view != NewSubPbActivity.this.fDm.bfr()) {
                                                            if (NewSubPbActivity.this.fDm == null || view != NewSubPbActivity.this.fDm.bfp()) {
                                                                if (NewSubPbActivity.this.fDm == null || view != NewSubPbActivity.this.fDm.bfs()) {
                                                                    if (NewSubPbActivity.this.fDm == null || view != NewSubPbActivity.this.fDm.bft()) {
                                                                        if (NewSubPbActivity.this.fDm == null || view != NewSubPbActivity.this.fDm.bfv()) {
                                                                            if (NewSubPbActivity.this.fDm == null || view != NewSubPbActivity.this.fDm.bfw()) {
                                                                                if (NewSubPbActivity.this.fDm != null && view == NewSubPbActivity.this.fDm.bfq()) {
                                                                                    if (!com.baidu.adp.lib.util.j.kK()) {
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
                                                                                            NewSubPbActivity.this.fRT.bA(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.fRT.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                            return;
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                int id = view.getId();
                                                                                if (id == e.g.pb_item_tail_content) {
                                                                                    if (ba.bA(NewSubPbActivity.this.getPageContext().getPageActivity())) {
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
                                                                                        if (postData.getType() != PostData.gVB && !TextUtils.isEmpty(postData.getBimg_url()) && i.uj().un()) {
                                                                                            NewSubPbActivity.this.sk(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.fDD != null && !TextUtils.isEmpty(NewSubPbActivity.this.fDE)) {
                                                                                if (NewSubPbActivity.this.bqO == null) {
                                                                                    NewSubPbActivity.this.bqO = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.bqO.Bb();
                                                                                NewSubPbActivity.this.bqO.c(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.bqO.x(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.fDC == null) {
                                                                                        NewSubPbActivity.this.fDC = new av(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.fDC.i(NewSubPbActivity.this.fDE, NewSubPbActivity.this.fDD.ok());
                                                                                    NewSubPbActivity.this.fDD = null;
                                                                                    NewSubPbActivity.this.fDE = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.fDD != null && !TextUtils.isEmpty(NewSubPbActivity.this.fDE)) {
                                                                            if (NewSubPbActivity.this.fDF == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.fDE));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.fDE;
                                                                                aVar.pkgId = NewSubPbActivity.this.fDF.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.fDF.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.fDD = null;
                                                                            NewSubPbActivity.this.fDE = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.fEn != null) {
                                                                        NewSubPbActivity.this.fEn.cO(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.fEn = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                if (sparseArray2 != null && (sparseArray2.get(e.g.tag_del_post_type) instanceof Integer) && (sparseArray2.get(e.g.tag_del_post_id) instanceof String) && (sparseArray2.get(e.g.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.fRT.a(((Integer) sparseArray2.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(e.g.tag_del_post_id), ((Integer) sparseArray2.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.bs(view);
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (!com.baidu.adp.lib.util.j.kK()) {
                                                            NewSubPbActivity.this.showToast(e.j.network_not_available);
                                                            return;
                                                        } else {
                                                            Object tag = view.getTag();
                                                            if (tag instanceof String) {
                                                                NewSubPbActivity.this.rM((String) tag);
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
                                                    } else if (ba.bA(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                        if (NewSubPbActivity.this.fSe) {
                                                            NewSubPbActivity.this.fSe = false;
                                                            return;
                                                        } else if (NewSubPbActivity.this.ePn == null || NewSubPbActivity.this.fRR == null || NewSubPbActivity.this.fRR.avt() == null || NewSubPbActivity.this.ePn.cY(NewSubPbActivity.this.fRR.avt().replyPrivateFlag)) {
                                                            if (NewSubPbActivity.this.fSf != null) {
                                                                NewSubPbActivity.this.fSf.aAA();
                                                            }
                                                            SparseArray sparseArray4 = (SparseArray) view.getTag(e.g.tag_from);
                                                            if (sparseArray4 != null && (sparseArray4.get(e.g.tag_clip_board) instanceof PostData)) {
                                                                PostData postData2 = (PostData) sparseArray4.get(e.g.tag_clip_board);
                                                                if (postData2 != null && postData2.wm() != null) {
                                                                    MetaData wm = postData2.wm();
                                                                    NewSubPbActivity.this.ePv.setReplyId(wm.getUserId());
                                                                    if (!(sparseArray4.get(e.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray4.get(e.g.tag_is_subpb)).booleanValue() : true)) {
                                                                        NewSubPbActivity.this.ePv.hr("");
                                                                    } else {
                                                                        NewSubPbActivity.this.ePv.hr(wm.getName_show());
                                                                    }
                                                                }
                                                                NewSubPbActivity.this.fRT.bhU();
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
                                                        ((PostData) sparseArray5.get(e.g.tag_clip_board)).cO(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new am("c11739").w("obj_locate", 4));
                                            if (!com.baidu.adp.lib.util.j.kK()) {
                                                NewSubPbActivity.this.showToast(e.j.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.fRT.bgK();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.rM(str4);
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
                                        } else if (com.baidu.adp.lib.util.j.kK()) {
                                            NewSubPbActivity.this.fRT.bgK();
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
                                    NewSubPbActivity.this.fRT.bgK();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.fRT.a(((Integer) sparseArray7.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray7.get(e.g.tag_del_post_id), ((Integer) sparseArray7.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(e.g.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new am("c11739").w("obj_locate", 2));
                                    NewSubPbActivity.this.fRT.bgK();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.fRR.bin() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.fRR.bin().bcq());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.fRT.bhT();
                                NewSubPbActivity.this.fRT.bhU();
                                if (NewSubPbActivity.this.ePv != null) {
                                    NewSubPbActivity.this.ePv.JH();
                                    if (NewSubPbActivity.this.fSf != null) {
                                        NewSubPbActivity.this.fSf.aAA();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.fRT.bhT();
                            NewSubPbActivity.this.fRT.bhU();
                            if (NewSubPbActivity.this.ePv != null) {
                                NewSubPbActivity.this.ePv.JG();
                                if (NewSubPbActivity.this.fSf != null) {
                                    NewSubPbActivity.this.fSf.aAA();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.ePn == null || NewSubPbActivity.this.fRR == null || NewSubPbActivity.this.fRR.avt() == null || NewSubPbActivity.this.ePn.cY(NewSubPbActivity.this.fRR.avt().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.ePv.Jw()) {
                                NewSubPbActivity.this.ePv.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.fRT.bhT();
                            NewSubPbActivity.this.fRT.bhU();
                            if (NewSubPbActivity.this.ePv != null) {
                                NewSubPbActivity.this.ePv.JI();
                                if (NewSubPbActivity.this.fSf != null) {
                                    NewSubPbActivity.this.fSf.aAA();
                                }
                            }
                        }
                    }
                }
            }
        };
        this.fRU = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.fRT.bgK();
                }
                NewSubPbActivity.this.ePv.JF();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.fRT.bij();
            }
        };
        this.fEo = new b.InterfaceC0100b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.fRR.bin() != null) {
                    postData = NewSubPbActivity.this.fRR.bin().bcq();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.cO(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.f(postData);
                    }
                }
            }
        };
        this.aKx = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                        NewSubPbActivity.this.fDD = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.fDE = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.fDD != null && !TextUtils.isEmpty(NewSubPbActivity.this.fDE)) {
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.fDF = null;
                            } else {
                                NewSubPbActivity.this.fDF = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                NewSubPbActivity.this.fRT.a(NewSubPbActivity.this.fEp, NewSubPbActivity.this.fDD.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                NewSubPbActivity.this.fEn = (PostData) sparseArray2.get(e.g.tag_clip_board);
                                if (NewSubPbActivity.this.fEn != null && NewSubPbActivity.this.fDf != null) {
                                    if (NewSubPbActivity.this.fDf != null) {
                                        NewSubPbActivity.this.fDf.an(NewSubPbActivity.this.fRR.isMarked());
                                    }
                                    boolean z = NewSubPbActivity.this.fDf.sR() && NewSubPbActivity.this.fEn.getId() != null && NewSubPbActivity.this.fEn.getId().equals(NewSubPbActivity.this.fRR.biu());
                                    if (NewSubPbActivity.this.fDm == null) {
                                        NewSubPbActivity.this.fDm = new y(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.mCommonClickListener);
                                        NewSubPbActivity.this.fRT.bC(NewSubPbActivity.this.fDm.getView());
                                        NewSubPbActivity.this.fDm.kt(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.fDm.showDialog();
                                    boolean isLogin = NewSubPbActivity.this.isLogin() & NewSubPbActivity.this.kb(sparseArray2.get(e.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(e.g.tag_del_post_is_self)).booleanValue() : false);
                                    boolean booleanValue = sparseArray2.get(e.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(e.g.tag_is_subpb)).booleanValue() : false;
                                    if (z) {
                                        NewSubPbActivity.this.fDm.bfp().setText(e.j.remove_mark);
                                    } else {
                                        NewSubPbActivity.this.fDm.bfp().setText(e.j.mark);
                                    }
                                    if (booleanValue) {
                                        NewSubPbActivity.this.fDm.bfp().setVisibility(8);
                                    } else {
                                        NewSubPbActivity.this.fDm.bfp().setVisibility(0);
                                    }
                                    if (NewSubPbActivity.this.bt(view)) {
                                        if (NewSubPbActivity.this.fDD != null && !NewSubPbActivity.this.fDD.isGif()) {
                                            sparseArray2.put(e.g.tag_richtext_image, true);
                                        } else {
                                            sparseArray2.put(e.g.tag_richtext_image, false);
                                        }
                                        sparseArray2.put(e.g.tag_richtext_emotion, true);
                                    } else {
                                        sparseArray2.put(e.g.tag_richtext_image, false);
                                        sparseArray2.put(e.g.tag_richtext_emotion, false);
                                    }
                                    NewSubPbActivity.this.fDm.a(sparseArray2, NewSubPbActivity.this.bbV(), isLogin);
                                    NewSubPbActivity.this.fDm.refreshUI();
                                }
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            NewSubPbActivity.this.fDD = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                NewSubPbActivity.this.fDE = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.fDF = null;
                            } else {
                                NewSubPbActivity.this.fDF = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.fDD = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.fDE = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.fDF = null;
                        } else {
                            NewSubPbActivity.this.fDF = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
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
        this.fRV = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void e(View view, String str) {
                NewSubPbActivity.this.k(null, str, "LINK_IMAGE");
            }
        };
        this.fRW = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                        j bin = NewSubPbActivity.this.fRR.bin();
                        TbRichText aG = NewSubPbActivity.this.aG(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (aG != null && aG.OP() != null) {
                            tbRichTextData = aG.OP().get(NewSubPbActivity.this.fEl);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.OV().Ph()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (bin == null) {
                                    str3 = null;
                                    z4 = false;
                                } else {
                                    if (bin.bcx() != null) {
                                        str4 = bin.bcx().getName();
                                        str5 = bin.bcx().getId();
                                    }
                                    if (bin.UT() != null) {
                                        str6 = bin.UT().getId();
                                    }
                                    str3 = str6;
                                    z4 = true;
                                }
                                if (NewSubPbActivity.this.fRR.biz() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.fRR.biz();
                                    z5 = NewSubPbActivity.this.fRR.biB();
                                    arrayList2 = NewSubPbActivity.this.fRR.biA();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z5 = z4;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(com.baidu.tbadk.core.util.v.d(arrayList2, 0));
                                NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                                return;
                            }
                            NewSubPbActivity.this.fEm = false;
                            String str7 = "";
                            TbRichText byO = bin.bcq().byO();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(byO, aG, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (bin == null) {
                                str2 = null;
                                z2 = false;
                            } else {
                                if (bin.bcx() != null) {
                                    str8 = bin.bcx().getName();
                                    str9 = bin.bcx().getId();
                                }
                                if (bin.UT() != null) {
                                    str10 = bin.UT().getId();
                                }
                                str2 = str10;
                                z2 = true;
                            }
                            if (NewSubPbActivity.this.fRR.biz() != null) {
                                concurrentHashMap = NewSubPbActivity.this.fRR.biz();
                                z3 = NewSubPbActivity.this.fRR.biB();
                                arrayList = NewSubPbActivity.this.fRR.biA();
                                i2 = a2 + NewSubPbActivity.this.fRR.getOffset();
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
        TbRichTextImageInfo OV;
        if (tbRichText == tbRichText2) {
            this.fEm = true;
        }
        if (tbRichText != null && tbRichText.OP() != null) {
            int size = tbRichText.OP().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.OP().get(i6) != null && tbRichText.OP().get(i6).getType() == 8) {
                    i5++;
                    int aR = (int) l.aR(TbadkCoreApplication.getInst());
                    int width = tbRichText.OP().get(i6).OV().getWidth() * aR;
                    int height = tbRichText.OP().get(i6).OV().getHeight() * aR;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.OP().get(i6).OV().Ph()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.OP().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (OV = tbRichTextData.OV()) != null) {
                            String Pk = OV.Pk();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Pk;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.fEm) {
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
        if (this.fDm != null) {
            this.fDm.kt(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo OV = tbRichTextData.OV();
        if (OV != null) {
            if (!StringUtils.isNull(OV.Pg())) {
                return OV.Pg();
            }
            if (OV.getHeight() * OV.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (OV.getHeight() * OV.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (OV.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * OV.getHeight())));
            } else {
                float width = OV.getWidth() / OV.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ao.by(OV.Pi()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aG(String str, int i) {
        if (this.fRR == null || this.fRR.bin() == null || str == null || i < 0) {
            return null;
        }
        j bin = this.fRR.bin();
        TbRichText a2 = a(bin.bcq(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bin.bcq(), str, i);
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
        TbRichText byO = postData.byO();
        if (byO != null) {
            ArrayList<TbRichTextData> OP = byO.OP();
            int size = OP.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (OP.get(i3) != null && OP.get(i3).getType() == 8) {
                    i2++;
                    if (OP.get(i3).OV().Pk().equals(str)) {
                        int aR = (int) l.aR(TbadkCoreApplication.getInst());
                        int width = OP.get(i3).OV().getWidth() * aR;
                        int height = OP.get(i3).OV().getHeight() * aR;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.fEl = i3;
                        return byO;
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
    public boolean kb(boolean z) {
        if (this.fRR == null) {
            return false;
        }
        return ((bbV() != 0) || this.fRR.bin() == null || this.fRR.bin().UT() == null || this.fRR.bin().UT().wm() == null || TextUtils.equals(this.fRR.bin().UT().wm().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Context context, String str, String str2) {
        long templateId = this.fRR.bin().bcq().byV() != null ? this.fRR.bin().bcq().byV().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ay.AN().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.fRR.bin().bcx().getId(), this.fRR.bin().bcx().getName(), this.fRR.bin().UT().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(int i, String str) {
        if (this.fRR.bio()) {
            showToast(str);
        } else if (l.lb()) {
            if (i == 4) {
                this.fRT.nk(str + "(4)");
            } else {
                this.fRT.iR(e.j.no_data_text);
            }
        } else {
            this.fRT.iR(e.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.ePv = (g) new com.baidu.tbadk.editortools.pb.h().bE(getActivity());
        if (this.ePv != null) {
            this.ePv.setContext(getPageContext());
            this.ePv.b(this.fRR);
            this.ePv.b(this.fSi);
            this.ePv.a(this.aRk);
            this.ePv.a(this.aRl);
            this.ePv.IJ().bP(true);
            this.ePv.d(getPageContext());
        }
        if (this.fRT != null) {
            this.fRT.g(this.ePv);
        }
        if (this.ePv != null && this.fRR != null) {
            this.ePv.a(this.fRR.avt());
            this.ePv.JF();
        }
        if (this.ePv != null) {
            this.fOZ = this.ePv.JJ().getInputView();
            this.fOZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.fSg != null) {
                        if (!NewSubPbActivity.this.fSg.bIh()) {
                            NewSubPbActivity.this.lg(false);
                        }
                        NewSubPbActivity.this.fSg.nL(false);
                    }
                }
            });
        }
    }

    public void bhR() {
        if (!TbadkCoreApplication.isLogin()) {
            this.ePv.JF();
        } else if (!StringUtils.isNull(this.fRR.biv())) {
            if (this.fRT.bhX() && l.lb()) {
                this.fRT.asz();
            } else {
                this.fRT.bia();
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
                    this.fRT.bA(view);
                }
            } else if (booleanValue2) {
                this.fRT.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.fRT.big(), getPageContext().getPageActivity());
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
            bVar.cs(e.j.operation);
            bVar.a(strArr, new b.InterfaceC0100b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.fSd);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.fSd);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).yo();
        }
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(e.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(e.g.tag_user_mute_mute_userid);
        }
        this.fRT.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.fSd;
        userMuteCheckCustomMessage.setTag(this.fSd);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.fRT.a(0, bVar.Hs, bVar.gXX, z);
            if (bVar.Hs) {
                if (bVar.gXV == 1) {
                    if (this.fRT.getListView() instanceof BdTypeListView) {
                        List<com.baidu.adp.widget.ListView.h> data = ((BdTypeListView) this.fRT.getListView()).getData();
                        if (!com.baidu.tbadk.core.util.v.z(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            data.remove(i);
                            this.fRT.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.gXV == 2) {
                    this.fRR.sm(bVar.mPostId);
                    this.fRT.a(this.fRR.bin(), this.fRR.bbV(), this.fRR.biz() != null);
                    if (this.fRR.biw()) {
                        this.fRR.lj(false);
                        this.fRT.bhV();
                        this.fRR.Ll();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
            }
        }
    }

    public void rM(String str) {
        this.fDe.si(str);
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.fRR.isMarked() && postData.getId() != null && postData.getId().equals(this.fRR.biu())) {
                z = true;
            }
            MarkData h = this.fRR.h(postData);
            if (h != null) {
                this.fRT.bgK();
                if (this.fDf != null) {
                    this.fDf.a(h);
                    if (!z) {
                        this.fDf.sT();
                    } else {
                        this.fDf.sS();
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
        if (bundle != null && this.fRR != null) {
            this.fRR.z(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.ePv != null) {
            this.ePv.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.ePv.IJ().Hf();
        this.ePv.JF();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.ePv.b(writeData);
                this.ePv.setVoiceModel(pbEditorData.getVoiceModel());
                k eZ = this.ePv.IJ().eZ(6);
                if (eZ != null && eZ.aPu != null) {
                    eZ.aPu.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.ePv.JB();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dsk != null) {
            this.dsk.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.fSb = true;
        super.onPause();
        if (this.dsk != null) {
            this.dsk.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.etb);
        this.fRT.azA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fSb = false;
        super.onResume();
        if (this.dsk != null) {
            this.dsk.onResume(getPageContext());
        }
        registerListener(this.etb);
        this.fRT.azB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dsk != null) {
            this.dsk.onStop(getPageContext());
        }
        this.ePv.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.fSh));
        this.fRR.cancelLoadData();
        this.fRR.destory();
        this.fRS.cancelLoadData();
        if (this.dsk != null) {
            this.dsk.onDestory(getPageContext());
        }
        this.fRT.bgK();
        this.fRT.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.fEb);
        MessageManager.getInstance().unRegisterListener(this.fEc);
        MessageManager.getInstance().unRegisterListener(this.fEd);
        MessageManager.getInstance().unRegisterListener(this.fSd);
        this.fDy = null;
        this.fDz = null;
        if (this.dsX != null) {
            this.dsX.onDestroy();
        }
        if (this.ePn != null) {
            this.ePn.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fRT.onChangeSkinType(i);
        if (this.dsX != null) {
            this.dsX.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dsk;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bib = this.fRT.bib();
        if (bib == null || (findViewWithTag = bib.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean sb(String str) {
        Map<String, String> fh;
        if (!TextUtils.isEmpty(str) && (fh = ay.fh(ay.fi(str))) != null) {
            this.fSe = true;
            String str2 = fh.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return sb(com.baidu.adp.lib.util.k.bz(str2));
            }
            String str3 = fh.get(fRQ);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (sb(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
                    iVar.mLink = str;
                    iVar.type = 3;
                    iVar.aOx = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, iVar));
                }
            } else {
                ay.AN().c(getPageContext(), new String[]{str});
            }
            this.fSe = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fSe = true;
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
        if (this.fRT != null) {
            return this.fRT.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Pw() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Py() {
        if (this.bjr == null) {
            this.bjr = TbRichTextView.m(getPageContext().getPageActivity(), 8);
        }
        return this.bjr;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Pz() {
        if (this.bjv == null) {
            this.bjv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bdT */
                public GifView jm() {
                    return new GifView(NewSubPbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void r(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView s(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView t(GifView gifView) {
                    return gifView;
                }
            }, 20, 0);
        }
        return this.bjv;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Px() {
        if (this.bjq == null) {
            this.bjq = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: ahM */
                public ImageView jm() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean un = i.uj().un();
                    foreDrawableImageView.setDefaultBg(al.getDrawable(e.d.common_color_10220));
                    if (un) {
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
                public void r(ImageView imageView) {
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
                public ImageView s(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (i.uj().un()) {
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
                public ImageView t(ImageView imageView) {
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
        return this.bjq;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> PA() {
        if (this.bjs == null) {
            this.bjs = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bdU */
                public View jm() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(e.C0141e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bv */
                public void r(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bw */
                public View s(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bx */
                public View t(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.bjs;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> PB() {
        if (this.bjt == null) {
            this.bjt = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bdW */
                public LinearLayout jm() {
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
                public void r(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: e */
                public LinearLayout s(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: f */
                public LinearLayout t(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.bjt;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> PC() {
        this.bju = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bdV */
            public RelativeLayout jm() {
                return new RelativeLayout(NewSubPbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void r(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout s(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout t(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.bju;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bcD() {
        return this.fDh;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bcE() {
        return (this.fRR == null || this.fRR.bin() == null || this.fRR.bin().UT() == null || this.fRR.bin().UT().xx()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bcF() {
        if (this.fRR == null || this.fRR.bin() == null || this.fRR.bin().UT() == null) {
            return null;
        }
        return this.fRR.bin().UT().ws();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bcG() {
        if (this.fRR == null) {
            return 0;
        }
        return this.fRR.bbV();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean rJ(String str) {
        if (StringUtils.isNull(str) || this.fRR == null || this.fRR.bin() == null || this.fRR.bin().UT() == null || this.fRR.bin().UT().wm() == null) {
            return false;
        }
        return str.equals(this.fRR.bin().UT().wm().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fRT.bhX() && l.lb()) {
            this.fRR.Ll();
        } else {
            this.fRT.bia();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.fSd);
        userMuteAddAndDelCustomMessage.setTag(this.fSd);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sk(String str) {
        if (!StringUtils.isNull(str) && ba.bA(getPageContext().getPageActivity())) {
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
        k(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean LB() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int LC() {
                return com.baidu.tbadk.pageStayDuration.e.LG().LI();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.fRR != null) {
            if (this.fRR.bin() != null && this.fRR.bin().bcx() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.fRR.bin().bcx().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.fRR.beD(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.fSb;
    }

    public boolean bhS() {
        if (this.fRR != null) {
            return this.fRR.bhS();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.fRT.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fDy.getPageActivity());
        if (ao.isEmpty(str)) {
            aVar.dT(this.fDy.getResources().getString(e.j.block_mute_message_alert, str3));
        } else {
            aVar.dT(str);
        }
        aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.fRT.showLoadingDialog();
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
        aVar.b(this.fDy).yl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fDy.getPageActivity());
        aVar.dT(str);
        aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fDy).yl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdO() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dT(getResources().getString(e.j.mute_is_super_member_function));
        aVar.a(e.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.fDy).showToast(e.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.fDy.getPageActivity(), 2, true, 4);
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
        aVar.b(this.fDy).yl();
    }

    public int bbV() {
        if (this.fRR != null) {
            return this.fRR.bbV();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.aPR) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.aPR) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void lg(boolean z) {
        if (this.fOZ != null && this.fOZ.getText() != null) {
            int selectionEnd = this.fOZ.getSelectionEnd();
            SpannableStringBuilder b = this.fSg.b(this.fOZ.getText());
            if (b != null) {
                this.fSg.nL(true);
                this.fOZ.setText(b);
                if (z && this.fSg.bIf() >= 0) {
                    this.fOZ.requestFocus();
                    this.fOZ.setSelection(this.fSg.bIf());
                } else {
                    this.fOZ.setSelection(selectionEnd);
                }
                this.fSg.nK(this.fSg.bIf() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.dsX == null) {
            this.dsX = new h(getPageContext());
            this.dsX.a(new h.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void aM(boolean z) {
                    if (z) {
                        TiebaStatic.log(new am("c13061"));
                    }
                }
            });
        }
        this.dsX.a(contriInfo, -1L);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.ePv != null && this.ePv.IJ() != null && this.ePv.IJ().IM()) {
            this.ePv.IJ().Hf();
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
