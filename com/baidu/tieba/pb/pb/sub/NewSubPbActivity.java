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
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.p;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
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
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bj;
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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
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
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tbadk.widget.richText.h;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.e;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.w;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
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
/* loaded from: classes9.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, h, com.baidu.tieba.pb.pb.a<NewSubPbActivity> {
    private static String jGt = "tbgametype";
    private View.OnClickListener aDc;
    private com.baidu.adp.lib.d.b<ImageView> emH;
    private com.baidu.adp.lib.d.b<GifView> emI;
    private com.baidu.adp.lib.d.b<View> epA;
    private com.baidu.adp.lib.d.b<LinearLayout> epB;
    private com.baidu.adp.lib.d.b<RelativeLayout> epC;
    private com.baidu.adp.lib.d.b<TextView> epz;
    private VoiceManager gYp;
    private ar hBV;
    private com.baidu.tieba.write.c hSm;
    private EditText hSn;
    private com.baidu.tieba.frs.profession.permission.c hbV;
    public aj iBb;
    private com.baidu.tbadk.editortools.pb.h iBk;
    private String jBp;
    private SubPbModel.a jGA;
    private com.baidu.adp.base.d jGB;
    private BdUniqueId jGF;
    private e<l> jGH;
    private boolean jGI;
    private k jGJ;
    private SubPbModel jGu;
    private ForumManageModel jGv;
    private com.baidu.tieba.pb.pb.sub.a jGw;
    private w jGx;
    private AbsListView.OnScrollListener jGy;
    private TbRichTextView.i jGz;
    private com.baidu.tieba.pb.pb.main.b.a jqe;
    private com.baidu.adp.base.e jtQ;
    private com.baidu.tbadk.core.view.d jtR;
    private com.baidu.adp.widget.ImageView.a jtU;
    private String jtV;
    private TbRichTextMemeInfo jtW;
    private com.baidu.tieba.pb.pb.report.a jtu;
    private com.baidu.tbadk.baseEditMark.a jtv;
    private PostWriteCallBackData jvx;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int juC = 0;
    PostData hSV = null;
    private a.InterfaceC0404a juy = null;
    private a jGC = null;
    private a jGD = null;
    private boolean mIsPaused = false;
    private boolean jGE = false;
    private boolean jGG = false;
    private boolean dXd = false;
    private com.baidu.tbadk.editortools.pb.c dYA = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aXn() {
            NewSubPbActivity.this.jGw.cCz();
        }
    };
    private int jpA = 0;
    private boolean mIsFromSchema = false;
    private com.baidu.tbadk.editortools.pb.b dYB = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aXm() {
            if (!NewSubPbActivity.this.hSm.deU()) {
                return (NewSubPbActivity.this.iBb == null || NewSubPbActivity.this.jGu == null || NewSubPbActivity.this.jGu.bNG() == null || NewSubPbActivity.this.iBb.aA(NewSubPbActivity.this.jGu.bNG().replyPrivateFlag, aj.dzz)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.hSm.deW());
            if (NewSubPbActivity.this.iBk.aXD()) {
                NewSubPbActivity.this.iBk.a(NewSubPbActivity.this.jvx);
            }
            NewSubPbActivity.this.nZ(true);
            return true;
        }
    };
    private NewWriteModel.d hSt = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.iBk != null && NewSubPbActivity.this.iBk.aWP() != null) {
                NewSubPbActivity.this.iBk.aWP().hide();
                if (NewSubPbActivity.this.jGu.cCX()) {
                    TiebaStatic.log(new an("c10367").cI("post_id", NewSubPbActivity.this.jGu.aXk()));
                }
            }
            if (z) {
                NewSubPbActivity.this.hSm.Mp(null);
                NewSubPbActivity.this.hSm.aW(null);
                NewSubPbActivity.this.hSm.uN(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.hSm.aW(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.hSm.Mp(postWriteCallBackData.getErrorString());
                if (!v.isEmpty(NewSubPbActivity.this.hSm.deS())) {
                    NewSubPbActivity.this.jvx = postWriteCallBackData;
                    if (NewSubPbActivity.this.iBk.aXD()) {
                        NewSubPbActivity.this.iBk.a(NewSubPbActivity.this.jvx);
                    }
                    NewSubPbActivity.this.nZ(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.iBb != null) {
                NewSubPbActivity.this.iBb.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.jGw.cCA();
        }
    };
    private CustomMessageListener juq = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.jGF) {
                NewSubPbActivity.this.jGw.bzU();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.jtR.showSuccessToast(NewSubPbActivity.this.jtQ.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.jtQ.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.wF(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.cyd();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.jtQ.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.jtR.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener jur = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.jGF) {
                NewSubPbActivity.this.jGw.bzU();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.jtR.showSuccessToast(NewSubPbActivity.this.jtQ.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.jtQ.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.jtR.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener jus = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.jGF) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.jGw.bzU();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.lgE;
                if (aVar.error == 0 && dataRes != null) {
                    boolean z2 = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0) == 1;
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
                    NewSubPbActivity.this.jGw.a(sparseArray, z);
                }
            }
        }
    };
    boolean juD = false;
    private final b.a juF = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.jtU != null && !TextUtils.isEmpty(NewSubPbActivity.this.jtV)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.jtW == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.jtV));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.jtV;
                        aVar.pkgId = NewSubPbActivity.this.jtW.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.jtW.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.hBV == null) {
                            NewSubPbActivity.this.hBV = new ar(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.hBV.j(NewSubPbActivity.this.jtV, NewSubPbActivity.this.jtU.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.jtU = null;
                NewSubPbActivity.this.jtV = null;
            }
        }
    };
    private CustomMessageListener ieX = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener gZE = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    com.baidu.tbadk.data.k kVar = (com.baidu.tbadk.data.k) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.jGu.cCQ() != null && NewSubPbActivity.this.jGu.cCQ().cwh() != null && NewSubPbActivity.this.jGu.cCQ().cwh().aKE() != null && currentAccount.equals(NewSubPbActivity.this.jGu.cCQ().cwh().aKE().getUserId()) && NewSubPbActivity.this.jGu.cCQ().cwh().aKE().getPendantData() != null) {
                        NewSubPbActivity.this.jGu.cCQ().cwh().aKE().getPendantData().tO(kVar.aIW());
                        NewSubPbActivity.this.jGu.cCQ().cwh().aKE().getPendantData().cp(kVar.aWu());
                        NewSubPbActivity.this.jGw.a(NewSubPbActivity.this.jGu.cCQ(), NewSubPbActivity.this.jGu.cCQ().cwh(), NewSubPbActivity.this.jGu.cCQ().cio(), NewSubPbActivity.this.jGu.cCQ().aGZ(), NewSubPbActivity.this.jGu.cvG(), NewSubPbActivity.this.jGu.cDd() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void callback(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        av(bundle);
        if (getIntent() != null) {
            this.mIsFromSchema = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_FROM_SCHEMA, false);
        }
        super.onCreate(bundle);
        this.jtQ = getPageContext();
        this.jGE = true;
        this.hSm = new com.baidu.tieba.write.c();
        this.hSm.EJ(R.color.cp_cont_h_alpha85);
        this.hSm.EI(R.color.cp_cont_a);
        bqK();
        cCp();
        initData(bundle);
        initUI();
        ((SubPbView) this.jGw.getRootView()).show();
        pt(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jGw.rU(this.mIsFromSchema);
        this.jtR = new com.baidu.tbadk.core.view.d();
        this.jtR.toastTime = 1000L;
        registerListener(this.jus);
        registerListener(this.juq);
        registerListener(this.jur);
        this.jGF = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.jGF;
        userMuteAddAndDelCustomMessage.setTag(this.jGF);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.jGF;
        userMuteCheckCustomMessage.setTag(this.jGF);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.iBb = new aj(getPageContext());
        this.iBb.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tbadk.core.util.aj.a
            public void m(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.iBk.aXK();
                }
            }
        });
        this.jtu = new com.baidu.tieba.pb.pb.report.a(this);
        this.jtu.t(getUniqueId());
        this.jqe = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.jGw = new com.baidu.tieba.pb.pb.sub.a(this, this.aDc);
        this.jGw.a(this.jGu);
        setContentView(this.jGw.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.jGw.setOnScrollListener(this.jGy);
        this.jGw.b(this);
        this.jGw.setOnImageClickListener(this.jGz);
        this.jGw.setOnLongClickListener(this.mOnLongClickListener);
        this.jGw.f(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.jGu != null) {
                    NewSubPbActivity.this.jGu.loadData();
                }
            }
        });
        this.jGw.a(this.jGC);
        this.jGw.b(this.jGD);
        if (this.jGu != null && this.jGu.cCr() && !this.jGu.cDc()) {
            this.jGw.cCF().setVisibility(8);
        } else {
            this.jGw.cCF().setVisibility(0);
        }
        if (this.jGu != null && !this.jGu.cCr()) {
            this.jGw.setIsFromPb(false);
        }
    }

    private boolean av(Bundle bundle) {
        if (bundle != null) {
            this.dXd = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.dXd = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.dXd;
    }

    public void initData(Bundle bundle) {
        this.jGu = new SubPbModel(getPageContext());
        this.jGu.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void p(PostData postData) {
                NewSubPbActivity.this.jGw.r(postData);
                NewSubPbActivity.this.jGw.b((BdListView.e) null);
            }
        });
        this.jGv = new ForumManageModel(getPageContext());
        this.jGv.setLoadDataCallBack(this.jGB);
        this.gYp = new VoiceManager();
        this.gYp.onCreate(getPageContext());
        this.jtv = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.jtv != null) {
            this.jtv.a(this.juy);
        }
        if (bundle != null) {
            this.jGu.initWithBundle(bundle);
        } else {
            this.jGu.initWithIntent(getIntent());
        }
        this.jGu.a(this.jGA);
        if (this.jGu.cCr()) {
            this.jGu.loadData();
        } else {
            this.jGu.cCV();
        }
    }

    public void cCp() {
        this.jGA = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, l lVar) {
                if (NewSubPbActivity.this.jGw != null) {
                    NewSubPbActivity.this.jGw.cCA();
                    if (!z) {
                        NewSubPbActivity.this.bm(i, str);
                        return;
                    }
                    NewSubPbActivity.this.jGw.hideNoDataView();
                    if (lVar != null) {
                        if (lVar.cwh() != null || NewSubPbActivity.this.jGu != null) {
                            lVar.cwh().a(NewSubPbActivity.this.jGu.cDb());
                        }
                        if (NewSubPbActivity.this.jGw != null) {
                            NewSubPbActivity.this.pt(lVar.aIw() != null && lVar.aIw().isBjh());
                            if (NewSubPbActivity.this.iBk != null && NewSubPbActivity.this.iBk.aWP() != null) {
                                NewSubPbActivity.this.iBk.aWP().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.jGw.a(lVar, NewSubPbActivity.this.jGu.cvG(), NewSubPbActivity.this.jGu.cDd() != null);
                            if (NewSubPbActivity.this.jGE) {
                                NewSubPbActivity.this.cCq();
                                NewSubPbActivity.this.jGE = false;
                            }
                        }
                        if (NewSubPbActivity.this.iBk != null) {
                            NewSubPbActivity.this.iBk.a(lVar.bNG());
                            NewSubPbActivity.this.iBk.setThreadData(lVar.aIw());
                        }
                        if (NewSubPbActivity.this.jGH == null) {
                            NewSubPbActivity.this.jGH = new e();
                        }
                        NewSubPbActivity.this.jGH.setData(lVar);
                        NewSubPbActivity.this.jGH.setType(0);
                        NewSubPbActivity.this.iBb.a(NewSubPbActivity.this.jGu.cDg());
                    }
                }
            }
        };
        this.juy = new a.InterfaceC0404a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0404a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.jtv != null) {
                        NewSubPbActivity.this.jtv.gk(z2);
                    }
                    MarkData aHc = NewSubPbActivity.this.jtv.aHc();
                    e eVar = new e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(aHc);
                        if (NewSubPbActivity.this.jtv != null) {
                            if (aHc != null) {
                                NewSubPbActivity.this.jGu.rW(true);
                                NewSubPbActivity.this.jGu.Ib(NewSubPbActivity.this.jGu.aXk());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.jGw != null) {
                                NewSubPbActivity.this.jGw.rV(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.jGu.rW(false);
                        NewSubPbActivity.this.jGu.Ib(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.jGw != null) {
                            NewSubPbActivity.this.jGw.rV(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.jGC = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.jGu.cCQ() != null && NewSubPbActivity.this.jGu.cCQ().aIw() != null && NewSubPbActivity.this.jGu.cCQ().aIw().aKE() != null) {
                    str = String.valueOf(NewSubPbActivity.this.jGu.cCQ().aIw().aKE().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.jGu.cCQ().aXI().getId(), NewSubPbActivity.this.jGu.cCQ().aXI().getName(), NewSubPbActivity.this.jGu.cCQ().aIw().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.jGD = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.jGv.cXf() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.jGu != null && NewSubPbActivity.this.jGu.cCQ() != null && NewSubPbActivity.this.jGu.cCQ().aXI() != null && NewSubPbActivity.this.jGu.cCQ().aIw() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.jGv.KQ(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.jGv.a(NewSubPbActivity.this.jGu.cCQ().aXI().getId(), NewSubPbActivity.this.jGu.cCQ().aXI().getName(), NewSubPbActivity.this.jGu.cCQ().aIw().getId(), valueOf, i2, i, z, NewSubPbActivity.this.jGu.cCQ().aIw().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.jGB = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.jGw.a(NewSubPbActivity.this.jGv.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.jGv.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.jHC != 1002 || bVar.fqG) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.jGw.a(1, dVar.OG, dVar.kVc, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean cD(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void bqK() {
        registerListener(this.gZE);
        this.aDc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v70, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray sparseArray;
                boolean z = true;
                boolean z2 = false;
                if (view != null || NewSubPbActivity.this.jGw != null) {
                    if (view == NewSubPbActivity.this.jGw.cCL()) {
                        NewSubPbActivity.this.jGw.cBa();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ba.aOY().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.jGw.bTa()) {
                        if (view != NewSubPbActivity.this.jGw.cCE()) {
                            if (view != NewSubPbActivity.this.jGw.cCD()) {
                                if (view == NewSubPbActivity.this.jGw.cCy()) {
                                    NewSubPbActivity.this.jGw.cBa();
                                    if (NewSubPbActivity.this.jGu.loadData()) {
                                        NewSubPbActivity.this.jGw.cCw();
                                    }
                                } else if (view == NewSubPbActivity.this.jGw.cCF() || view == NewSubPbActivity.this.jGw.cCG() || view == NewSubPbActivity.this.jGw.cCI()) {
                                    if (NewSubPbActivity.this.jGG) {
                                        NewSubPbActivity.this.jGG = false;
                                        return;
                                    }
                                    if (NewSubPbActivity.this.jGu.cCQ() != null && NewSubPbActivity.this.jGu.cCQ().aIw() != null) {
                                        z2 = au.a(NewSubPbActivity.this.jGu.cCQ().aIw().getBaijiahaoData());
                                    }
                                    if (z2) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.jGu.cyA(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.jGu.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.jGu.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.jGu.cCQ() != null && NewSubPbActivity.this.jGu.cCQ().aIw() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.jGu.cCQ().aIw().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.jGu.cyA(), NewSubPbActivity.this.jGu.aXk(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.jGu.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.jGu.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.jGw.cCJ() == null || view != NewSubPbActivity.this.jGw.cCJ().czy()) {
                                    if (NewSubPbActivity.this.jGw.cCJ() == null || view != NewSubPbActivity.this.jGw.cCJ().czB()) {
                                        if (NewSubPbActivity.this.jGw.cCJ() == null || view != NewSubPbActivity.this.jGw.cCJ().czz()) {
                                            if (NewSubPbActivity.this.jGw.cCJ() == null || view != NewSubPbActivity.this.jGw.cCJ().czA()) {
                                                if (NewSubPbActivity.this.jGw.cCJ() == null || view != NewSubPbActivity.this.jGw.cCJ().czC()) {
                                                    if (view == NewSubPbActivity.this.jGw.cCC() || view == NewSubPbActivity.this.jGw.cCI()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.iBk.aXN()) {
                                                                NewSubPbActivity.this.iBk.aXO();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.iBk.wG(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof k)) {
                                                        if (NewSubPbActivity.this.jGx == null || view != NewSubPbActivity.this.jGx.czA()) {
                                                            if (NewSubPbActivity.this.jGx == null || view != NewSubPbActivity.this.jGx.czy()) {
                                                                if (NewSubPbActivity.this.jGx == null || view != NewSubPbActivity.this.jGx.czB()) {
                                                                    if (NewSubPbActivity.this.jGx == null || view != NewSubPbActivity.this.jGx.czC()) {
                                                                        if (NewSubPbActivity.this.jGx == null || view != NewSubPbActivity.this.jGx.czE()) {
                                                                            if (NewSubPbActivity.this.jGx == null || view != NewSubPbActivity.this.jGx.czF()) {
                                                                                if (NewSubPbActivity.this.jGx != null && view == NewSubPbActivity.this.jGx.czz()) {
                                                                                    if (!j.isNetWorkAvailable()) {
                                                                                        NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                                                        return;
                                                                                    }
                                                                                    SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                                                                                    if (sparseArray2 != null) {
                                                                                        boolean booleanValue = ((Boolean) sparseArray2.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                        boolean booleanValue2 = ((Boolean) sparseArray2.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                        boolean booleanValue3 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                        if (booleanValue) {
                                                                                            if (booleanValue3) {
                                                                                                sparseArray2.put(R.id.tag_from, 1);
                                                                                                sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                                                                NewSubPbActivity.this.b(sparseArray2);
                                                                                                return;
                                                                                            }
                                                                                            sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                                                            NewSubPbActivity.this.jGw.cI(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.jGw.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                            return;
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                int id = view.getId();
                                                                                if (id == R.id.pb_item_tail_content) {
                                                                                    if (bc.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.aNV().getString("tail_link", "");
                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                            TiebaStatic.log("c10056");
                                                                                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else if (id == R.id.richText && (view.getTag() instanceof SparseArray)) {
                                                                                    Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
                                                                                    if (obj instanceof PostData) {
                                                                                        PostData postData = (PostData) obj;
                                                                                        if (postData.getType() != PostData.kSp && !TextUtils.isEmpty(postData.getBimg_url()) && i.aIe().isShowImages()) {
                                                                                            NewSubPbActivity.this.HY(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.jtU != null && !TextUtils.isEmpty(NewSubPbActivity.this.jtV)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.hBV == null) {
                                                                                        NewSubPbActivity.this.hBV = new ar(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.hBV.j(NewSubPbActivity.this.jtV, NewSubPbActivity.this.jtU.getImageByte());
                                                                                    NewSubPbActivity.this.jtU = null;
                                                                                    NewSubPbActivity.this.jtV = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.jtU != null && !TextUtils.isEmpty(NewSubPbActivity.this.jtV)) {
                                                                            if (NewSubPbActivity.this.jtW == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.jtV));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.jtV;
                                                                                aVar.pkgId = NewSubPbActivity.this.jtW.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.jtW.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.jtU = null;
                                                                            NewSubPbActivity.this.jtV = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.hSV != null) {
                                                                        NewSubPbActivity.this.hSV.fm(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.hSV = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.jGw.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.cC(view);
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (!j.isNetWorkAvailable()) {
                                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                            return;
                                                        } else {
                                                            Object tag = view.getTag();
                                                            if (tag instanceof String) {
                                                                NewSubPbActivity.this.Hx((String) tag);
                                                                return;
                                                            } else if (tag instanceof SparseArray) {
                                                                SparseArray<Object> sparseArray4 = (SparseArray) tag;
                                                                if ((sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                                    sparseArray4.put(R.id.tag_from, 0);
                                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                                    NewSubPbActivity.this.b(sparseArray4);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        NewSubPbActivity.this.jGJ = (k) view.getTag();
                                                        if (bc.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.jGG) {
                                                                NewSubPbActivity.this.jGG = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.iBb == null || NewSubPbActivity.this.jGu == null || NewSubPbActivity.this.jGu.bNG() == null || NewSubPbActivity.this.iBb.kz(NewSubPbActivity.this.jGu.bNG().replyPrivateFlag)) && (sparseArray = (SparseArray) view.getTag(R.id.tag_from)) != null) {
                                                                if (sparseArray.get(R.id.tag_clip_board) instanceof PostData) {
                                                                    PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                    if (postData2 != null && postData2.aKE() != null) {
                                                                        MetaData aKE = postData2.aKE();
                                                                        NewSubPbActivity.this.iBk.setReplyId(aKE.getUserId());
                                                                        boolean booleanValue4 = sparseArray.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue() : true;
                                                                        if (!(view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) || view.getTag(R.id.tag_subpb_ban_display_keyboard) != Boolean.TRUE) {
                                                                            z = false;
                                                                        }
                                                                        if (!booleanValue4) {
                                                                            if (!z) {
                                                                                NewSubPbActivity.this.iBk.wH("");
                                                                            }
                                                                        } else if (!z) {
                                                                            NewSubPbActivity.this.iBk.wH(aKE.getName_show());
                                                                        }
                                                                    }
                                                                    NewSubPbActivity.this.jGw.cCu();
                                                                }
                                                                if (NewSubPbActivity.this.jGI) {
                                                                    NewSubPbActivity.this.rT(false);
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
                                                        ((PostData) sparseArray5.get(R.id.tag_clip_board)).fm(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new an("c11739").af("obj_locate", 4));
                                            if (!j.isNetWorkAvailable()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.jGw.cBa();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.Hx(str4);
                                                    return;
                                                }
                                                return;
                                            } else if (tag2 instanceof SparseArray) {
                                                SparseArray<Object> sparseArray6 = (SparseArray) tag2;
                                                if ((sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray6.put(R.id.tag_from, 0);
                                                    sparseArray6.put(R.id.tag_check_mute_from, 2);
                                                    NewSubPbActivity.this.b(sparseArray6);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        } else if (j.isNetWorkAvailable()) {
                                            NewSubPbActivity.this.jGw.cBa();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.cL(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.jGw.cBa();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.jGw.a(((Integer) sparseArray7.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray7.get(R.id.tag_del_post_id), ((Integer) sparseArray7.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new an("c11739").af("obj_locate", 2));
                                    NewSubPbActivity.this.jGw.cBa();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.jGu.cCQ() != null) {
                                        NewSubPbActivity.this.k(NewSubPbActivity.this.jGu.cCQ().cwh());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.jGw.cCt();
                                NewSubPbActivity.this.jGw.cCu();
                                if (NewSubPbActivity.this.iBk != null) {
                                    NewSubPbActivity.this.iBk.aXQ();
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.jGw.cCt();
                            NewSubPbActivity.this.jGw.cCu();
                            if (NewSubPbActivity.this.iBk != null) {
                                NewSubPbActivity.this.iBk.aXP();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.cxB();
                        if (NewSubPbActivity.this.jGu != null && NewSubPbActivity.this.jGu.cCQ() != null && NewSubPbActivity.this.jGu.cCQ().aIw() != null && NewSubPbActivity.this.jGu.cCQ().aIw().aKE() != null) {
                            TiebaStatic.log(new an("c13402").cI("tid", NewSubPbActivity.this.jGu.cyA()).t("fid", NewSubPbActivity.this.jGu.cCQ().aIw().getFid()).af("obj_locate", 5).cI("uid", NewSubPbActivity.this.jGu.cCQ().aIw().aKE().getUserId()));
                        }
                    }
                }
            }
        };
        this.jGy = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.jGw.cBa();
                    if (NewSubPbActivity.this.jpA != 2 && NewSubPbActivity.this.jpA != 1) {
                        NewSubPbActivity.this.jGw.cCN();
                    }
                }
                NewSubPbActivity.this.iBk.aXO();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.jGw.cCK();
            }
        };
        this.mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
            @Override // android.view.View.OnLongClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onLongClick(View view) {
                SparseArray<Object> sparseArray;
                SparseArray<Object> sparseArray2;
                if (NewSubPbActivity.this.jGw != null && NewSubPbActivity.this.jGw.cCB()) {
                    return false;
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null && NewSubPbActivity.this.cD(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.jtU = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.jtV = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.jtU == null || TextUtils.isEmpty(NewSubPbActivity.this.jtV)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.jtW = null;
                        } else {
                            NewSubPbActivity.this.jtW = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.jtU = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.jtV = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.jtW = null;
                        } else {
                            NewSubPbActivity.this.jtW = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.jtU = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.jtV = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.jtW = null;
                        } else {
                            NewSubPbActivity.this.jtW = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    }
                    if (view.getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                        } catch (ClassCastException e2) {
                            e2.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                        NewSubPbActivity.this.jGw.a(NewSubPbActivity.this.juF, NewSubPbActivity.this.jtU.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.hSV = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.hSV == null || NewSubPbActivity.this.jtv == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.jtv != null) {
                            NewSubPbActivity.this.jtv.gk(NewSubPbActivity.this.jGu.cCW());
                        }
                        boolean z = NewSubPbActivity.this.jtv.aGZ() && NewSubPbActivity.this.hSV.getId() != null && NewSubPbActivity.this.hSV.getId().equals(NewSubPbActivity.this.jGu.cCY());
                        if (NewSubPbActivity.this.jGx == null) {
                            NewSubPbActivity.this.jGx = new w(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aDc);
                            NewSubPbActivity.this.jGw.cM(NewSubPbActivity.this.jGx.getView());
                            NewSubPbActivity.this.jGx.ri(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.jGx.showDialog();
                        boolean z2 = NewSubPbActivity.this.qV(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z3 = (NewSubPbActivity.this.jGu.cCQ() == null || NewSubPbActivity.this.jGu.cCQ().aIw() == null || !NewSubPbActivity.this.jGu.cCQ().aIw().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z) {
                            NewSubPbActivity.this.jGx.czy().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.jGx.czy().setText(R.string.mark);
                        }
                        if (booleanValue || z3) {
                            NewSubPbActivity.this.jGx.czy().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.jGx.czy().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.cD(view)) {
                            if (NewSubPbActivity.this.jtU != null && !NewSubPbActivity.this.jtU.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        NewSubPbActivity.this.jGx.a(sparseArray2, NewSubPbActivity.this.cvG(), z2);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.jGz = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX DEBUG: Multi-variable search result rejected for r2v44, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
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
                        l cCQ = NewSubPbActivity.this.jGu.cCQ();
                        TbRichText bt = NewSubPbActivity.this.bt(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bt != null && bt.bch() != null) {
                            tbRichTextData = bt.bch().get(NewSubPbActivity.this.juC);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.bcn().bcy()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (cCQ == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (cCQ.aXI() != null) {
                                        str4 = cCQ.aXI().getName();
                                        str5 = cCQ.aXI().getId();
                                    }
                                    if (cCQ.aIw() != null) {
                                        str6 = cCQ.aIw().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.jGu.cDd() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.jGu.cDd();
                                    z6 = NewSubPbActivity.this.jGu.cDf();
                                    arrayList2 = NewSubPbActivity.this.jGu.cDe();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.getItem(arrayList2, 0));
                                ImageViewerConfig createConfig = new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false);
                                createConfig.setPostId(String.valueOf(bt.getPostId()));
                                createConfig.setThreadData(NewSubPbActivity.this.aIw());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                                return;
                            }
                            NewSubPbActivity.this.juD = false;
                            String str7 = "";
                            TbRichText cWt = cCQ.cwh().cWt();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(cWt, bt, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (cCQ == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (cCQ.aXI() != null) {
                                    str8 = cCQ.aXI().getName();
                                    str9 = cCQ.aXI().getId();
                                }
                                if (cCQ.aIw() != null) {
                                    str10 = cCQ.aIw().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.jGu.cDd() != null) {
                                concurrentHashMap = NewSubPbActivity.this.jGu.cDd();
                                z4 = NewSubPbActivity.this.jGu.cDf();
                                arrayList = NewSubPbActivity.this.jGu.cDe();
                                i2 = a2 + NewSubPbActivity.this.jGu.getOffset();
                            } else {
                                concurrentHashMap = concurrentHashMap3;
                                i2 = a2;
                                z4 = z3;
                                arrayList = arrayList2;
                            }
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(v.getItem(arrayList, i2));
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList4, 0, str8, str9, str2, z4, str7, true, concurrentHashMap, true, false, false);
                            createConfig2.setThreadData(NewSubPbActivity.this.aIw());
                            createConfig2.setPostId(String.valueOf(bt.getPostId()));
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                            return;
                        }
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS, isGif)));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public bj aIw() {
        if (this.jGu == null || this.jGu.cCQ() == null) {
            return null;
        }
        return this.jGu.cCQ().aIw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cC(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            k(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bcn;
        if (tbRichText == tbRichText2) {
            this.juD = true;
        }
        if (tbRichText != null && tbRichText.bch() != null) {
            int size = tbRichText.bch().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.bch().get(i6) != null && tbRichText.bch().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.bch().get(i6).bcn().getWidth() * equipmentDensity;
                    int height = tbRichText.bch().get(i6).bcn().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.bch().get(i6).bcn().bcy()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.bch().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (bcn = tbRichTextData.bcn()) != null) {
                            String bcA = bcn.bcA();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = bcA;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.juD) {
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
        if (this.jGx != null) {
            this.jGx.ri(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bcn = tbRichTextData.bcn();
        if (bcn != null) {
            if (!StringUtils.isNull(bcn.bcx())) {
                return bcn.bcx();
            }
            if (bcn.getHeight() * bcn.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bcn.getHeight() * bcn.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bcn.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bcn.getHeight())));
            } else {
                float width = bcn.getWidth() / bcn.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(bcn.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bt(String str, int i) {
        if (this.jGu == null || this.jGu.cCQ() == null || str == null || i < 0) {
            return null;
        }
        l cCQ = this.jGu.cCQ();
        TbRichText a2 = a(cCQ.cwh(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(cCQ.cwh(), str, i);
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
        TbRichText cWt = postData.cWt();
        if (cWt != null) {
            ArrayList<TbRichTextData> bch = cWt.bch();
            int size = bch.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (bch.get(i3) != null && bch.get(i3).getType() == 8) {
                    i2++;
                    if (bch.get(i3).bcn().bcA().equals(str)) {
                        int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = bch.get(i3).bcn().getWidth() * equipmentDensity;
                        int height = bch.get(i3).bcn().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.juC = i3;
                        return cWt;
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
    public void cxB() {
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false) {
            if (this.iBb == null || this.jGu == null || this.jGu.bNG() == null || this.iBb.kz(this.jGu.bNG().replyPrivateFlag)) {
                if (this.iBk.aXD()) {
                    this.iBk.a((PostWriteCallBackData) null);
                    return;
                }
                this.jGw.cCt();
                this.jGw.cCu();
                if (this.iBk != null) {
                    this.iBk.aXR();
                    return;
                }
                return;
            }
            return;
        }
        if (this.hbV == null) {
            this.hbV = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.hbV.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void mF(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void u(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void mG(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.iBb == null || NewSubPbActivity.this.jGu == null || NewSubPbActivity.this.jGu.bNG() == null || NewSubPbActivity.this.iBb.kz(NewSubPbActivity.this.jGu.bNG().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.iBk.aXD()) {
                                NewSubPbActivity.this.iBk.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.jGw.cCt();
                            NewSubPbActivity.this.jGw.cCu();
                            if (NewSubPbActivity.this.iBk != null) {
                                NewSubPbActivity.this.iBk.aXR();
                            }
                        }
                    }
                }
            });
        }
        if (this.jGu != null && this.jGu.cCQ() != null && this.jGu.cCQ().aXI() != null) {
            this.hbV.E(this.jGu.cCQ().aXI().getId(), com.baidu.adp.lib.f.b.toLong(this.jGu.cyA(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qV(boolean z) {
        if (this.jGu == null) {
            return false;
        }
        return ((cvG() != 0) || this.jGu.cCQ() == null || this.jGu.cCQ().aIw() == null || this.jGu.cCQ().aIw().aKE() == null || this.jGu.cCQ().aIw().aMA() || TextUtils.equals(this.jGu.cCQ().aIw().aKE().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(int i, String str) {
        if (this.jGu.cCR()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.isNetOk()) {
            if (i == 4) {
                this.jGw.Bv(str + "(4)");
            } else {
                this.jGw.wU(R.string.no_data_text);
            }
        } else {
            this.jGw.wU(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pt(boolean z) {
        this.iBk = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dI(getActivity());
        if (this.iBk != null) {
            this.iBk.a(getPageContext());
            this.iBk.b(this.jGu);
            this.iBk.b(this.hSt);
            this.iBk.a(this.dYA);
            this.iBk.a(this.dYB);
            this.iBk.aWP().hA(true);
            this.iBk.j(getPageContext());
        }
        if (this.jGw != null) {
            this.jGw.i(this.iBk);
        }
        if (this.iBk != null && this.jGu != null) {
            this.iBk.a(this.jGu.bNG());
            this.iBk.aXO();
        }
        if (this.iBk != null) {
            this.iBk.aXS().setDefaultHint(cAo());
            this.iBk.aXS().setHint(cAo());
            this.hSn = this.iBk.aXS().getInputView();
            this.hSn.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.hSm != null) {
                        if (!NewSubPbActivity.this.hSm.deV()) {
                            NewSubPbActivity.this.nZ(false);
                        }
                        NewSubPbActivity.this.hSm.uO(false);
                    }
                }
            });
        }
    }

    public void cCq() {
        if (!TbadkCoreApplication.isLogin()) {
            this.iBk.aXO();
        } else if (!StringUtils.isNull(this.jGu.cCZ())) {
            if (this.jGw.cCx() && com.baidu.adp.lib.util.l.isNetOk()) {
                this.jGw.bLJ();
            } else {
                this.jGw.cCA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(R.id.tag_from, 1);
                    b(sparseArray);
                } else {
                    this.jGw.cI(view);
                }
            } else if (booleanValue2) {
                this.jGw.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.jGw.cCH(), getPageContext().getPageActivity());
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
            bVar.kh(R.string.operation);
            bVar.a(strArr, new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
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
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.jGF);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.jGF);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).aMV();
        }
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.jGw.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.jGF;
        userMuteCheckCustomMessage.setTag(this.jGF);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.jGw.a(0, bVar.OG, bVar.kVc, z);
            if (bVar.OG) {
                if (bVar.gFx == 1) {
                    if (this.jGw.getListView() instanceof BdTypeListView) {
                        List<m> data = ((BdTypeListView) this.jGw.getListView()).getData();
                        if (!v.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.jGw.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.gFx == 2) {
                    this.jGu.Ia(bVar.mPostId);
                    this.jGw.a(this.jGu.cCQ(), this.jGu.cvG(), this.jGu.cDd() != null);
                    if (this.jGu.cDa()) {
                        this.jGu.rX(false);
                        this.jGw.cCv();
                        this.jGu.loadData();
                    }
                }
                e eVar = new e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void Hx(String str) {
        if (this.jGu != null && this.jGu.cCQ() != null && this.jGu.cCQ().aIw() != null && this.jGu.cCQ().aIw().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.jGu.cyA(), str);
            bj aIw = this.jGu.cCQ().aIw();
            if (aIw.aJt()) {
                format = format + "&channelid=33833";
            } else if (aIw.aMx()) {
                format = format + "&channelid=33842";
            } else if (aIw.aJu()) {
                format = format + "&channelid=33840";
            }
            Hy(format);
            return;
        }
        this.jtu.HX(str);
    }

    private void Hy(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void k(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.jGu.cCW() && postData.getId() != null && postData.getId().equals(this.jGu.cCY())) {
                z = true;
            }
            MarkData l = this.jGu.l(postData);
            if (l != null) {
                this.jGw.cBa();
                if (this.jtv != null) {
                    this.jtv.a(l);
                    if (!z) {
                        this.jtv.aHb();
                    } else {
                        this.jtv.aHa();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.jGu != null) {
            this.jGu.au(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.iBk != null) {
            this.iBk.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.iBk.aWP().aVs();
        this.iBk.aXO();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.iBk.b(writeData);
                this.iBk.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l mD = this.iBk.aWP().mD(6);
                if (mD != null && mD.dWH != null) {
                    mD.dWH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.iBk.aXK();
                }
                this.jGw.cCN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gYp != null) {
            this.gYp.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.aFN().aFS();
        if (this.gYp != null) {
            this.gYp.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.ieX);
        this.jGw.bVd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
        cyg();
        if (this.gYp != null) {
            this.gYp.onResume(getPageContext());
        }
        registerListener(this.ieX);
        this.jGw.bVe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gYp != null) {
            this.gYp.onStop(getPageContext());
        }
        this.iBk.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.jGH));
        this.jGu.cancelLoadData();
        this.jGu.destory();
        this.jGv.cancelLoadData();
        if (this.gYp != null) {
            this.gYp.onDestory(getPageContext());
        }
        this.jGw.cBa();
        this.jGw.aqT();
        MessageManager.getInstance().unRegisterListener(this.juq);
        MessageManager.getInstance().unRegisterListener(this.jur);
        MessageManager.getInstance().unRegisterListener(this.jus);
        MessageManager.getInstance().unRegisterListener(this.jGF);
        this.jtQ = null;
        this.jtR = null;
        if (this.iBb != null) {
            this.iBb.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jGw.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gYp;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View cCC = this.jGw.cCC();
        if (cCC == null || (findViewWithTag = cCC.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean HQ(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = ba.getParamPair(ba.getParamStr(str))) != null) {
            this.jGG = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return HQ(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(jGt);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void e(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (HQ(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                    jVar.mLink = str;
                    jVar.type = 3;
                    jVar.dVK = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, jVar));
                }
            } else {
                ba.aOY().b(getPageContext(), new String[]{str});
            }
            this.jGG = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aw(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.jGG = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ax(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ay(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void az(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void r(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        if (this.jGw != null) {
            return this.jGw.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bcO() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bcQ() {
        if (this.epz == null) {
            this.epz = TbRichTextView.u(getPageContext().getPageActivity(), 8);
        }
        return this.epz;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bcR() {
        if (this.emI == null) {
            this.emI = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bJw */
                public GifView makeObject() {
                    return new GifView(NewSubPbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: g */
                public void destroyObject(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: h */
                public GifView activateObject(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: i */
                public GifView passivateObject(GifView gifView) {
                    return gifView;
                }
            }, 20, 0);
        }
        return this.emI;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bcP() {
        if (this.emH == null) {
            this.emH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bdb */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.aIe().isShowImages();
                    foreDrawableImageView.setDefaultBg(am.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
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
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: a */
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
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: b */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (i.aIe().isShowImages()) {
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
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: c */
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
        return this.emH;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bcS() {
        if (this.epA == null) {
            this.epA = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cyn */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(NewSubPbActivity.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cE */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cF */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cG */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.epA;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bcT() {
        if (this.epB == null) {
            this.epB = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cyp */
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
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: c */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.epB;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bcU() {
        this.epC = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cyo */
            public RelativeLayout makeObject() {
                return new RelativeLayout(NewSubPbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public RelativeLayout activateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public RelativeLayout passivateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.epC;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cws() {
        return this.jqe;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cwt() {
        return (this.jGu == null || this.jGu.cCQ() == null || this.jGu.cCQ().aIw() == null || this.jGu.cCQ().aIw().aLY()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cwu() {
        if (this.jGu == null || this.jGu.cCQ() == null || this.jGu.cCQ().aIw() == null) {
            return null;
        }
        return this.jGu.cCQ().aIw().aKJ();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cwv() {
        if (this.jGu == null) {
            return 0;
        }
        return this.jGu.cvG();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Hs(String str) {
        if (StringUtils.isNull(str) || this.jGu == null || this.jGu.cCQ() == null || this.jGu.cCQ().aIw() == null || this.jGu.cCQ().aIw().aKE() == null) {
            return false;
        }
        return str.equals(this.jGu.cCQ().aIw().aKE().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.jGw.cCx() && com.baidu.adp.lib.util.l.isNetOk()) {
            this.jGu.loadData();
        } else {
            this.jGw.cCA();
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
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.jGF);
        userMuteAddAndDelCustomMessage.setTag(this.jGF);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HY(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString("bubble_link", "");
            if (!StringUtils.isNull(string)) {
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                    return;
                }
                com.baidu.tbadk.browser.a.startWebActivity(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), string + "?props_id=" + str, true, true, true);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aA(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB_FLOOR;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.aZm().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.jGu != null) {
            if (this.jGu.cCQ() != null && this.jGu.cCQ().aXI() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.jGu.cCQ().aXI().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.jGu.cyA(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public boolean cCr() {
        if (this.jGu != null) {
            return this.jGu.cCr();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.jGw.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jtQ.getPageActivity());
        if (aq.isEmpty(str)) {
            aVar.uf(this.jtQ.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.uf(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.jGw.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.jtQ).aMU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wF(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jtQ.getPageActivity());
        aVar.uf(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.jtQ).aMU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyd() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.uf(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.jtQ).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.jtQ.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.jtQ).aMU();
    }

    public SubPbModel cCs() {
        return this.jGu;
    }

    public int cvG() {
        if (this.jGu != null) {
            return this.jGu.cvG();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.dXd && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.dXd && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void nZ(boolean z) {
        if (this.hSn != null && this.hSn.getText() != null) {
            int selectionEnd = this.hSn.getSelectionEnd();
            SpannableStringBuilder a2 = this.hSm.a(this.hSn.getText());
            if (a2 != null) {
                this.hSm.uO(true);
                this.hSn.setText(a2);
                if (z && this.hSm.deT() >= 0) {
                    this.hSn.requestFocus();
                    this.hSn.setSelection(this.hSm.deT());
                } else {
                    this.hSn.setSelection(selectionEnd);
                }
                this.hSm.uN(this.hSm.deT() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.iBk != null && this.iBk.aWP() != null && this.iBk.aWP().aWR()) {
            this.iBk.aWP().aVs();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.d.a(pVar, getUniqueId(), this);
    }

    public String cAo() {
        if (!aq.isEmpty(this.jBp)) {
            return this.jBp;
        }
        this.jBp = getResources().getString(com.baidu.tieba.pb.pb.main.am.cAd());
        return this.jBp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.jGI = z;
        rT(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rT(boolean z) {
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
        if (this.jGw != null && this.jGw.getListView() != null && this.jGJ != null && this.jGJ.mPosition != -1) {
            final int headerViewsCount = this.jGJ.mPosition + this.jGw.getListView().getHeaderViewsCount();
            if (this.jGJ.getView() != null) {
                final int height = this.jGJ.getView().getHeight() - ((rect.height() - this.jGw.getNavigationBarHeight()) - this.jGw.cCM());
                if (height > 0) {
                    this.jGw.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.jGw != null && NewSubPbActivity.this.jGw.getListView() != null) {
                                NewSubPbActivity.this.jGw.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.jGw.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.jGw.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.jGw != null && NewSubPbActivity.this.jGw.getListView() != null) {
                                NewSubPbActivity.this.jGw.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.jGw.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }

    private void cyg() {
        if (this.jGu != null && !aq.isEmpty(this.jGu.cyA())) {
            com.baidu.tbadk.BdToken.c.aFN().o(com.baidu.tbadk.BdToken.b.dfY, com.baidu.adp.lib.f.b.toLong(this.jGu.cyA(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.jGu == null || aq.isEmpty(this.jGu.cyA())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.jGu.cyA(), 0L);
    }
}
