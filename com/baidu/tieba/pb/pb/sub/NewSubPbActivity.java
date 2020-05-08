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
    private static String jGx = "tbgametype";
    private View.OnClickListener aDi;
    private com.baidu.adp.lib.d.b<ImageView> emM;
    private com.baidu.adp.lib.d.b<GifView> emN;
    private com.baidu.adp.lib.d.b<TextView> epE;
    private com.baidu.adp.lib.d.b<View> epF;
    private com.baidu.adp.lib.d.b<LinearLayout> epG;
    private com.baidu.adp.lib.d.b<RelativeLayout> epH;
    private VoiceManager gYv;
    private ar hCb;
    private com.baidu.tieba.write.c hSs;
    private EditText hSt;
    private com.baidu.tieba.frs.profession.permission.c hcb;
    public aj iBh;
    private com.baidu.tbadk.editortools.pb.h iBq;
    private String jBt;
    private com.baidu.tieba.pb.pb.sub.a jGA;
    private w jGB;
    private AbsListView.OnScrollListener jGC;
    private TbRichTextView.i jGD;
    private SubPbModel.a jGE;
    private com.baidu.adp.base.d jGF;
    private BdUniqueId jGJ;
    private e<l> jGL;
    private boolean jGM;
    private k jGN;
    private SubPbModel jGy;
    private ForumManageModel jGz;
    private com.baidu.tieba.pb.pb.main.b.a jqi;
    private com.baidu.adp.base.e jtU;
    private com.baidu.tbadk.core.view.d jtV;
    private com.baidu.adp.widget.ImageView.a jtY;
    private String jtZ;
    private com.baidu.tieba.pb.pb.report.a jty;
    private com.baidu.tbadk.baseEditMark.a jtz;
    private TbRichTextMemeInfo jua;
    private PostWriteCallBackData jvB;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int juG = 0;
    PostData hTb = null;
    private a.InterfaceC0425a juC = null;
    private a jGG = null;
    private a jGH = null;
    private boolean mIsPaused = false;
    private boolean jGI = false;
    private boolean jGK = false;
    private boolean dXi = false;
    private com.baidu.tbadk.editortools.pb.c dYF = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aXl() {
            NewSubPbActivity.this.jGA.cCw();
        }
    };
    private int jpE = 0;
    private boolean mIsFromSchema = false;
    private com.baidu.tbadk.editortools.pb.b dYG = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aXk() {
            if (!NewSubPbActivity.this.hSs.deR()) {
                return (NewSubPbActivity.this.iBh == null || NewSubPbActivity.this.jGy == null || NewSubPbActivity.this.jGy.bNE() == null || NewSubPbActivity.this.iBh.aA(NewSubPbActivity.this.jGy.bNE().replyPrivateFlag, aj.dzD)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.hSs.deT());
            if (NewSubPbActivity.this.iBq.aXB()) {
                NewSubPbActivity.this.iBq.a(NewSubPbActivity.this.jvB);
            }
            NewSubPbActivity.this.nZ(true);
            return true;
        }
    };
    private NewWriteModel.d hSz = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.iBq != null && NewSubPbActivity.this.iBq.aWN() != null) {
                NewSubPbActivity.this.iBq.aWN().hide();
                if (NewSubPbActivity.this.jGy.cCU()) {
                    TiebaStatic.log(new an("c10367").cI("post_id", NewSubPbActivity.this.jGy.aXi()));
                }
            }
            if (z) {
                NewSubPbActivity.this.hSs.Ms(null);
                NewSubPbActivity.this.hSs.aW(null);
                NewSubPbActivity.this.hSs.uN(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.hSs.aW(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.hSs.Ms(postWriteCallBackData.getErrorString());
                if (!v.isEmpty(NewSubPbActivity.this.hSs.deP())) {
                    NewSubPbActivity.this.jvB = postWriteCallBackData;
                    if (NewSubPbActivity.this.iBq.aXB()) {
                        NewSubPbActivity.this.iBq.a(NewSubPbActivity.this.jvB);
                    }
                    NewSubPbActivity.this.nZ(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.iBh != null) {
                NewSubPbActivity.this.iBh.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.jGA.cCx();
        }
    };
    private CustomMessageListener juu = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.jGJ) {
                NewSubPbActivity.this.jGA.bzS();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.jtV.showSuccessToast(NewSubPbActivity.this.jtU.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.jtU.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.wI(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.cya();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.jtU.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.jtV.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener juv = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.jGJ) {
                NewSubPbActivity.this.jGA.bzS();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.jtV.showSuccessToast(NewSubPbActivity.this.jtU.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.jtU.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.jtV.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener juw = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.jGJ) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.jGA.bzS();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.lgI;
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
                    NewSubPbActivity.this.jGA.a(sparseArray, z);
                }
            }
        }
    };
    boolean juH = false;
    private final b.a juJ = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.jtY != null && !TextUtils.isEmpty(NewSubPbActivity.this.jtZ)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.jua == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.jtZ));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.jtZ;
                        aVar.pkgId = NewSubPbActivity.this.jua.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.jua.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.hCb == null) {
                            NewSubPbActivity.this.hCb = new ar(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.hCb.j(NewSubPbActivity.this.jtZ, NewSubPbActivity.this.jtY.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.jtY = null;
                NewSubPbActivity.this.jtZ = null;
            }
        }
    };
    private CustomMessageListener ifd = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener gZK = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    com.baidu.tbadk.data.k kVar = (com.baidu.tbadk.data.k) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.jGy.cCN() != null && NewSubPbActivity.this.jGy.cCN().cwe() != null && NewSubPbActivity.this.jGy.cCN().cwe().aKC() != null && currentAccount.equals(NewSubPbActivity.this.jGy.cCN().cwe().aKC().getUserId()) && NewSubPbActivity.this.jGy.cCN().cwe().aKC().getPendantData() != null) {
                        NewSubPbActivity.this.jGy.cCN().cwe().aKC().getPendantData().tR(kVar.aIU());
                        NewSubPbActivity.this.jGy.cCN().cwe().aKC().getPendantData().cp(kVar.aWs());
                        NewSubPbActivity.this.jGA.a(NewSubPbActivity.this.jGy.cCN(), NewSubPbActivity.this.jGy.cCN().cwe(), NewSubPbActivity.this.jGy.cCN().cim(), NewSubPbActivity.this.jGy.cCN().aGX(), NewSubPbActivity.this.jGy.cvD(), NewSubPbActivity.this.jGy.cDa() != null);
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
        this.jtU = getPageContext();
        this.jGI = true;
        this.hSs = new com.baidu.tieba.write.c();
        this.hSs.EJ(R.color.cp_cont_h_alpha85);
        this.hSs.EI(R.color.cp_cont_a);
        bqI();
        cCm();
        initData(bundle);
        initUI();
        ((SubPbView) this.jGA.getRootView()).show();
        pt(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jGA.rU(this.mIsFromSchema);
        this.jtV = new com.baidu.tbadk.core.view.d();
        this.jtV.toastTime = 1000L;
        registerListener(this.juw);
        registerListener(this.juu);
        registerListener(this.juv);
        this.jGJ = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.jGJ;
        userMuteAddAndDelCustomMessage.setTag(this.jGJ);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.jGJ;
        userMuteCheckCustomMessage.setTag(this.jGJ);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.iBh = new aj(getPageContext());
        this.iBh.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tbadk.core.util.aj.a
            public void m(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.iBq.aXI();
                }
            }
        });
        this.jty = new com.baidu.tieba.pb.pb.report.a(this);
        this.jty.t(getUniqueId());
        this.jqi = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.jGA = new com.baidu.tieba.pb.pb.sub.a(this, this.aDi);
        this.jGA.a(this.jGy);
        setContentView(this.jGA.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.jGA.setOnScrollListener(this.jGC);
        this.jGA.b(this);
        this.jGA.setOnImageClickListener(this.jGD);
        this.jGA.setOnLongClickListener(this.mOnLongClickListener);
        this.jGA.f(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.jGy != null) {
                    NewSubPbActivity.this.jGy.loadData();
                }
            }
        });
        this.jGA.a(this.jGG);
        this.jGA.b(this.jGH);
        if (this.jGy != null && this.jGy.cCo() && !this.jGy.cCZ()) {
            this.jGA.cCC().setVisibility(8);
        } else {
            this.jGA.cCC().setVisibility(0);
        }
        if (this.jGy != null && !this.jGy.cCo()) {
            this.jGA.setIsFromPb(false);
        }
    }

    private boolean av(Bundle bundle) {
        if (bundle != null) {
            this.dXi = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.dXi = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.dXi;
    }

    public void initData(Bundle bundle) {
        this.jGy = new SubPbModel(getPageContext());
        this.jGy.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void p(PostData postData) {
                NewSubPbActivity.this.jGA.r(postData);
                NewSubPbActivity.this.jGA.b((BdListView.e) null);
            }
        });
        this.jGz = new ForumManageModel(getPageContext());
        this.jGz.setLoadDataCallBack(this.jGF);
        this.gYv = new VoiceManager();
        this.gYv.onCreate(getPageContext());
        this.jtz = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.jtz != null) {
            this.jtz.a(this.juC);
        }
        if (bundle != null) {
            this.jGy.initWithBundle(bundle);
        } else {
            this.jGy.initWithIntent(getIntent());
        }
        this.jGy.a(this.jGE);
        if (this.jGy.cCo()) {
            this.jGy.loadData();
        } else {
            this.jGy.cCS();
        }
    }

    public void cCm() {
        this.jGE = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, l lVar) {
                if (NewSubPbActivity.this.jGA != null) {
                    NewSubPbActivity.this.jGA.cCx();
                    if (!z) {
                        NewSubPbActivity.this.bm(i, str);
                        return;
                    }
                    NewSubPbActivity.this.jGA.hideNoDataView();
                    if (lVar != null) {
                        if (lVar.cwe() != null || NewSubPbActivity.this.jGy != null) {
                            lVar.cwe().a(NewSubPbActivity.this.jGy.cCY());
                        }
                        if (NewSubPbActivity.this.jGA != null) {
                            NewSubPbActivity.this.pt(lVar.aIu() != null && lVar.aIu().isBjh());
                            if (NewSubPbActivity.this.iBq != null && NewSubPbActivity.this.iBq.aWN() != null) {
                                NewSubPbActivity.this.iBq.aWN().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.jGA.a(lVar, NewSubPbActivity.this.jGy.cvD(), NewSubPbActivity.this.jGy.cDa() != null);
                            if (NewSubPbActivity.this.jGI) {
                                NewSubPbActivity.this.cCn();
                                NewSubPbActivity.this.jGI = false;
                            }
                        }
                        if (NewSubPbActivity.this.iBq != null) {
                            NewSubPbActivity.this.iBq.a(lVar.bNE());
                            NewSubPbActivity.this.iBq.setThreadData(lVar.aIu());
                        }
                        if (NewSubPbActivity.this.jGL == null) {
                            NewSubPbActivity.this.jGL = new e();
                        }
                        NewSubPbActivity.this.jGL.setData(lVar);
                        NewSubPbActivity.this.jGL.setType(0);
                        NewSubPbActivity.this.iBh.a(NewSubPbActivity.this.jGy.cDd());
                    }
                }
            }
        };
        this.juC = new a.InterfaceC0425a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0425a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.jtz != null) {
                        NewSubPbActivity.this.jtz.gk(z2);
                    }
                    MarkData aHa = NewSubPbActivity.this.jtz.aHa();
                    e eVar = new e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(aHa);
                        if (NewSubPbActivity.this.jtz != null) {
                            if (aHa != null) {
                                NewSubPbActivity.this.jGy.rW(true);
                                NewSubPbActivity.this.jGy.Ie(NewSubPbActivity.this.jGy.aXi());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.jGA != null) {
                                NewSubPbActivity.this.jGA.rV(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.jGy.rW(false);
                        NewSubPbActivity.this.jGy.Ie(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.jGA != null) {
                            NewSubPbActivity.this.jGA.rV(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.jGG = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.jGy.cCN() != null && NewSubPbActivity.this.jGy.cCN().aIu() != null && NewSubPbActivity.this.jGy.cCN().aIu().aKC() != null) {
                    str = String.valueOf(NewSubPbActivity.this.jGy.cCN().aIu().aKC().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.jGy.cCN().aXG().getId(), NewSubPbActivity.this.jGy.cCN().aXG().getName(), NewSubPbActivity.this.jGy.cCN().aIu().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.jGH = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.jGz.cXc() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.jGy != null && NewSubPbActivity.this.jGy.cCN() != null && NewSubPbActivity.this.jGy.cCN().aXG() != null && NewSubPbActivity.this.jGy.cCN().aIu() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.jGz.KT(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.jGz.a(NewSubPbActivity.this.jGy.cCN().aXG().getId(), NewSubPbActivity.this.jGy.cCN().aXG().getName(), NewSubPbActivity.this.jGy.cCN().aIu().getId(), valueOf, i2, i, z, NewSubPbActivity.this.jGy.cCN().aIu().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.jGF = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.jGA.a(NewSubPbActivity.this.jGz.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.jGz.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.jHG != 1002 || bVar.fqL) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.jGA.a(1, dVar.OL, dVar.kVg, true);
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

    public void bqI() {
        registerListener(this.gZK);
        this.aDi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v70, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray sparseArray;
                boolean z = true;
                boolean z2 = false;
                if (view != null || NewSubPbActivity.this.jGA != null) {
                    if (view == NewSubPbActivity.this.jGA.cCI()) {
                        NewSubPbActivity.this.jGA.cAX();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ba.aOV().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.jGA.bSY()) {
                        if (view != NewSubPbActivity.this.jGA.cCB()) {
                            if (view != NewSubPbActivity.this.jGA.cCA()) {
                                if (view == NewSubPbActivity.this.jGA.cCv()) {
                                    NewSubPbActivity.this.jGA.cAX();
                                    if (NewSubPbActivity.this.jGy.loadData()) {
                                        NewSubPbActivity.this.jGA.cCt();
                                    }
                                } else if (view == NewSubPbActivity.this.jGA.cCC() || view == NewSubPbActivity.this.jGA.cCD() || view == NewSubPbActivity.this.jGA.cCF()) {
                                    if (NewSubPbActivity.this.jGK) {
                                        NewSubPbActivity.this.jGK = false;
                                        return;
                                    }
                                    if (NewSubPbActivity.this.jGy.cCN() != null && NewSubPbActivity.this.jGy.cCN().aIu() != null) {
                                        z2 = au.a(NewSubPbActivity.this.jGy.cCN().aIu().getBaijiahaoData());
                                    }
                                    if (z2) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.jGy.cyx(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.jGy.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.jGy.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.jGy.cCN() != null && NewSubPbActivity.this.jGy.cCN().aIu() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.jGy.cCN().aIu().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.jGy.cyx(), NewSubPbActivity.this.jGy.aXi(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.jGy.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.jGy.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.jGA.cCG() == null || view != NewSubPbActivity.this.jGA.cCG().czv()) {
                                    if (NewSubPbActivity.this.jGA.cCG() == null || view != NewSubPbActivity.this.jGA.cCG().czy()) {
                                        if (NewSubPbActivity.this.jGA.cCG() == null || view != NewSubPbActivity.this.jGA.cCG().czw()) {
                                            if (NewSubPbActivity.this.jGA.cCG() == null || view != NewSubPbActivity.this.jGA.cCG().czx()) {
                                                if (NewSubPbActivity.this.jGA.cCG() == null || view != NewSubPbActivity.this.jGA.cCG().czz()) {
                                                    if (view == NewSubPbActivity.this.jGA.cCz() || view == NewSubPbActivity.this.jGA.cCF()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.iBq.aXL()) {
                                                                NewSubPbActivity.this.iBq.aXM();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.iBq.wJ(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof k)) {
                                                        if (NewSubPbActivity.this.jGB == null || view != NewSubPbActivity.this.jGB.czx()) {
                                                            if (NewSubPbActivity.this.jGB == null || view != NewSubPbActivity.this.jGB.czv()) {
                                                                if (NewSubPbActivity.this.jGB == null || view != NewSubPbActivity.this.jGB.czy()) {
                                                                    if (NewSubPbActivity.this.jGB == null || view != NewSubPbActivity.this.jGB.czz()) {
                                                                        if (NewSubPbActivity.this.jGB == null || view != NewSubPbActivity.this.jGB.czB()) {
                                                                            if (NewSubPbActivity.this.jGB == null || view != NewSubPbActivity.this.jGB.czC()) {
                                                                                if (NewSubPbActivity.this.jGB != null && view == NewSubPbActivity.this.jGB.czw()) {
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
                                                                                            NewSubPbActivity.this.jGA.cI(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.jGA.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.aNT().getString("tail_link", "");
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
                                                                                        if (postData.getType() != PostData.kSt && !TextUtils.isEmpty(postData.getBimg_url()) && i.aIc().isShowImages()) {
                                                                                            NewSubPbActivity.this.Ib(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.jtY != null && !TextUtils.isEmpty(NewSubPbActivity.this.jtZ)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.hCb == null) {
                                                                                        NewSubPbActivity.this.hCb = new ar(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.hCb.j(NewSubPbActivity.this.jtZ, NewSubPbActivity.this.jtY.getImageByte());
                                                                                    NewSubPbActivity.this.jtY = null;
                                                                                    NewSubPbActivity.this.jtZ = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.jtY != null && !TextUtils.isEmpty(NewSubPbActivity.this.jtZ)) {
                                                                            if (NewSubPbActivity.this.jua == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.jtZ));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.jtZ;
                                                                                aVar.pkgId = NewSubPbActivity.this.jua.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.jua.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.jtY = null;
                                                                            NewSubPbActivity.this.jtZ = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.hTb != null) {
                                                                        NewSubPbActivity.this.hTb.fa(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.hTb = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.jGA.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                NewSubPbActivity.this.HA((String) tag);
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
                                                        NewSubPbActivity.this.jGN = (k) view.getTag();
                                                        if (bc.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.jGK) {
                                                                NewSubPbActivity.this.jGK = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.iBh == null || NewSubPbActivity.this.jGy == null || NewSubPbActivity.this.jGy.bNE() == null || NewSubPbActivity.this.iBh.kz(NewSubPbActivity.this.jGy.bNE().replyPrivateFlag)) && (sparseArray = (SparseArray) view.getTag(R.id.tag_from)) != null) {
                                                                if (sparseArray.get(R.id.tag_clip_board) instanceof PostData) {
                                                                    PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                    if (postData2 != null && postData2.aKC() != null) {
                                                                        MetaData aKC = postData2.aKC();
                                                                        NewSubPbActivity.this.iBq.setReplyId(aKC.getUserId());
                                                                        boolean booleanValue4 = sparseArray.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue() : true;
                                                                        if (!(view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) || view.getTag(R.id.tag_subpb_ban_display_keyboard) != Boolean.TRUE) {
                                                                            z = false;
                                                                        }
                                                                        if (!booleanValue4) {
                                                                            if (!z) {
                                                                                NewSubPbActivity.this.iBq.wK("");
                                                                            }
                                                                        } else if (!z) {
                                                                            NewSubPbActivity.this.iBq.wK(aKC.getName_show());
                                                                        }
                                                                    }
                                                                    NewSubPbActivity.this.jGA.cCr();
                                                                }
                                                                if (NewSubPbActivity.this.jGM) {
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
                                                        ((PostData) sparseArray5.get(R.id.tag_clip_board)).fa(NewSubPbActivity.this.getPageContext().getPageActivity());
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
                                            NewSubPbActivity.this.jGA.cAX();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.HA(str4);
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
                                            NewSubPbActivity.this.jGA.cAX();
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
                                    NewSubPbActivity.this.jGA.cAX();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.jGA.a(((Integer) sparseArray7.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray7.get(R.id.tag_del_post_id), ((Integer) sparseArray7.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new an("c11739").af("obj_locate", 2));
                                    NewSubPbActivity.this.jGA.cAX();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.jGy.cCN() != null) {
                                        NewSubPbActivity.this.k(NewSubPbActivity.this.jGy.cCN().cwe());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.jGA.cCq();
                                NewSubPbActivity.this.jGA.cCr();
                                if (NewSubPbActivity.this.iBq != null) {
                                    NewSubPbActivity.this.iBq.aXO();
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.jGA.cCq();
                            NewSubPbActivity.this.jGA.cCr();
                            if (NewSubPbActivity.this.iBq != null) {
                                NewSubPbActivity.this.iBq.aXN();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.cxy();
                        if (NewSubPbActivity.this.jGy != null && NewSubPbActivity.this.jGy.cCN() != null && NewSubPbActivity.this.jGy.cCN().aIu() != null && NewSubPbActivity.this.jGy.cCN().aIu().aKC() != null) {
                            TiebaStatic.log(new an("c13402").cI("tid", NewSubPbActivity.this.jGy.cyx()).t("fid", NewSubPbActivity.this.jGy.cCN().aIu().getFid()).af("obj_locate", 5).cI("uid", NewSubPbActivity.this.jGy.cCN().aIu().aKC().getUserId()));
                        }
                    }
                }
            }
        };
        this.jGC = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.jGA.cAX();
                    if (NewSubPbActivity.this.jpE != 2 && NewSubPbActivity.this.jpE != 1) {
                        NewSubPbActivity.this.jGA.cCK();
                    }
                }
                NewSubPbActivity.this.iBq.aXM();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.jGA.cCH();
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
                if (NewSubPbActivity.this.jGA != null && NewSubPbActivity.this.jGA.cCy()) {
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
                        NewSubPbActivity.this.jtY = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.jtZ = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.jtY == null || TextUtils.isEmpty(NewSubPbActivity.this.jtZ)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.jua = null;
                        } else {
                            NewSubPbActivity.this.jua = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.jtY = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.jtZ = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.jua = null;
                        } else {
                            NewSubPbActivity.this.jua = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.jtY = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.jtZ = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.jua = null;
                        } else {
                            NewSubPbActivity.this.jua = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.jGA.a(NewSubPbActivity.this.juJ, NewSubPbActivity.this.jtY.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.hTb = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.hTb == null || NewSubPbActivity.this.jtz == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.jtz != null) {
                            NewSubPbActivity.this.jtz.gk(NewSubPbActivity.this.jGy.cCT());
                        }
                        boolean z = NewSubPbActivity.this.jtz.aGX() && NewSubPbActivity.this.hTb.getId() != null && NewSubPbActivity.this.hTb.getId().equals(NewSubPbActivity.this.jGy.cCV());
                        if (NewSubPbActivity.this.jGB == null) {
                            NewSubPbActivity.this.jGB = new w(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aDi);
                            NewSubPbActivity.this.jGA.cM(NewSubPbActivity.this.jGB.getView());
                            NewSubPbActivity.this.jGB.ri(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.jGB.showDialog();
                        boolean z2 = NewSubPbActivity.this.qV(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z3 = (NewSubPbActivity.this.jGy.cCN() == null || NewSubPbActivity.this.jGy.cCN().aIu() == null || !NewSubPbActivity.this.jGy.cCN().aIu().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z) {
                            NewSubPbActivity.this.jGB.czv().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.jGB.czv().setText(R.string.mark);
                        }
                        if (booleanValue || z3) {
                            NewSubPbActivity.this.jGB.czv().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.jGB.czv().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.cD(view)) {
                            if (NewSubPbActivity.this.jtY != null && !NewSubPbActivity.this.jtY.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        NewSubPbActivity.this.jGB.a(sparseArray2, NewSubPbActivity.this.cvD(), z2);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.jGD = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                        l cCN = NewSubPbActivity.this.jGy.cCN();
                        TbRichText bt = NewSubPbActivity.this.bt(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bt != null && bt.bcf() != null) {
                            tbRichTextData = bt.bcf().get(NewSubPbActivity.this.juG);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.bcl().bcw()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (cCN == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (cCN.aXG() != null) {
                                        str4 = cCN.aXG().getName();
                                        str5 = cCN.aXG().getId();
                                    }
                                    if (cCN.aIu() != null) {
                                        str6 = cCN.aIu().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.jGy.cDa() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.jGy.cDa();
                                    z6 = NewSubPbActivity.this.jGy.cDc();
                                    arrayList2 = NewSubPbActivity.this.jGy.cDb();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.getItem(arrayList2, 0));
                                ImageViewerConfig createConfig = new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false);
                                createConfig.setPostId(String.valueOf(bt.getPostId()));
                                createConfig.setThreadData(NewSubPbActivity.this.aIu());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                                return;
                            }
                            NewSubPbActivity.this.juH = false;
                            String str7 = "";
                            TbRichText cWq = cCN.cwe().cWq();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(cWq, bt, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (cCN == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (cCN.aXG() != null) {
                                    str8 = cCN.aXG().getName();
                                    str9 = cCN.aXG().getId();
                                }
                                if (cCN.aIu() != null) {
                                    str10 = cCN.aIu().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.jGy.cDa() != null) {
                                concurrentHashMap = NewSubPbActivity.this.jGy.cDa();
                                z4 = NewSubPbActivity.this.jGy.cDc();
                                arrayList = NewSubPbActivity.this.jGy.cDb();
                                i2 = a2 + NewSubPbActivity.this.jGy.getOffset();
                            } else {
                                concurrentHashMap = concurrentHashMap3;
                                i2 = a2;
                                z4 = z3;
                                arrayList = arrayList2;
                            }
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(v.getItem(arrayList, i2));
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList4, 0, str8, str9, str2, z4, str7, true, concurrentHashMap, true, false, false);
                            createConfig2.setThreadData(NewSubPbActivity.this.aIu());
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
    public bj aIu() {
        if (this.jGy == null || this.jGy.cCN() == null) {
            return null;
        }
        return this.jGy.cCN().aIu();
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
        TbRichTextImageInfo bcl;
        if (tbRichText == tbRichText2) {
            this.juH = true;
        }
        if (tbRichText != null && tbRichText.bcf() != null) {
            int size = tbRichText.bcf().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.bcf().get(i6) != null && tbRichText.bcf().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.bcf().get(i6).bcl().getWidth() * equipmentDensity;
                    int height = tbRichText.bcf().get(i6).bcl().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.bcf().get(i6).bcl().bcw()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.bcf().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (bcl = tbRichTextData.bcl()) != null) {
                            String bcy = bcl.bcy();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = bcy;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.juH) {
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
        if (this.jGB != null) {
            this.jGB.ri(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bcl = tbRichTextData.bcl();
        if (bcl != null) {
            if (!StringUtils.isNull(bcl.bcv())) {
                return bcl.bcv();
            }
            if (bcl.getHeight() * bcl.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bcl.getHeight() * bcl.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bcl.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bcl.getHeight())));
            } else {
                float width = bcl.getWidth() / bcl.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(bcl.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bt(String str, int i) {
        if (this.jGy == null || this.jGy.cCN() == null || str == null || i < 0) {
            return null;
        }
        l cCN = this.jGy.cCN();
        TbRichText a2 = a(cCN.cwe(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(cCN.cwe(), str, i);
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
        TbRichText cWq = postData.cWq();
        if (cWq != null) {
            ArrayList<TbRichTextData> bcf = cWq.bcf();
            int size = bcf.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (bcf.get(i3) != null && bcf.get(i3).getType() == 8) {
                    i2++;
                    if (bcf.get(i3).bcl().bcy().equals(str)) {
                        int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = bcf.get(i3).bcl().getWidth() * equipmentDensity;
                        int height = bcf.get(i3).bcl().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.juG = i3;
                        return cWq;
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
    public void cxy() {
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false) {
            if (this.iBh == null || this.jGy == null || this.jGy.bNE() == null || this.iBh.kz(this.jGy.bNE().replyPrivateFlag)) {
                if (this.iBq.aXB()) {
                    this.iBq.a((PostWriteCallBackData) null);
                    return;
                }
                this.jGA.cCq();
                this.jGA.cCr();
                if (this.iBq != null) {
                    this.iBq.aXP();
                    return;
                }
                return;
            }
            return;
        }
        if (this.hcb == null) {
            this.hcb = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.hcb.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void mF(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void u(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void mG(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.iBh == null || NewSubPbActivity.this.jGy == null || NewSubPbActivity.this.jGy.bNE() == null || NewSubPbActivity.this.iBh.kz(NewSubPbActivity.this.jGy.bNE().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.iBq.aXB()) {
                                NewSubPbActivity.this.iBq.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.jGA.cCq();
                            NewSubPbActivity.this.jGA.cCr();
                            if (NewSubPbActivity.this.iBq != null) {
                                NewSubPbActivity.this.iBq.aXP();
                            }
                        }
                    }
                }
            });
        }
        if (this.jGy != null && this.jGy.cCN() != null && this.jGy.cCN().aXG() != null) {
            this.hcb.E(this.jGy.cCN().aXG().getId(), com.baidu.adp.lib.f.b.toLong(this.jGy.cyx(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qV(boolean z) {
        if (this.jGy == null) {
            return false;
        }
        return ((cvD() != 0) || this.jGy.cCN() == null || this.jGy.cCN().aIu() == null || this.jGy.cCN().aIu().aKC() == null || this.jGy.cCN().aIu().aMy() || TextUtils.equals(this.jGy.cCN().aIu().aKC().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(int i, String str) {
        if (this.jGy.cCO()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.isNetOk()) {
            if (i == 4) {
                this.jGA.By(str + "(4)");
            } else {
                this.jGA.wU(R.string.no_data_text);
            }
        } else {
            this.jGA.wU(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pt(boolean z) {
        this.iBq = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dw(getActivity());
        if (this.iBq != null) {
            this.iBq.a(getPageContext());
            this.iBq.b(this.jGy);
            this.iBq.b(this.hSz);
            this.iBq.a(this.dYF);
            this.iBq.a(this.dYG);
            this.iBq.aWN().hA(true);
            this.iBq.j(getPageContext());
        }
        if (this.jGA != null) {
            this.jGA.i(this.iBq);
        }
        if (this.iBq != null && this.jGy != null) {
            this.iBq.a(this.jGy.bNE());
            this.iBq.aXM();
        }
        if (this.iBq != null) {
            this.iBq.aXQ().setDefaultHint(cAl());
            this.iBq.aXQ().setHint(cAl());
            this.hSt = this.iBq.aXQ().getInputView();
            this.hSt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.hSs != null) {
                        if (!NewSubPbActivity.this.hSs.deS()) {
                            NewSubPbActivity.this.nZ(false);
                        }
                        NewSubPbActivity.this.hSs.uO(false);
                    }
                }
            });
        }
    }

    public void cCn() {
        if (!TbadkCoreApplication.isLogin()) {
            this.iBq.aXM();
        } else if (!StringUtils.isNull(this.jGy.cCW())) {
            if (this.jGA.cCu() && com.baidu.adp.lib.util.l.isNetOk()) {
                this.jGA.bLH();
            } else {
                this.jGA.cCx();
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
                    this.jGA.cI(view);
                }
            } else if (booleanValue2) {
                this.jGA.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.jGA.cCE(), getPageContext().getPageActivity());
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.jGJ);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.jGJ);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).aMT();
        }
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.jGA.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.jGJ;
        userMuteCheckCustomMessage.setTag(this.jGJ);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.jGA.a(0, bVar.OL, bVar.kVg, z);
            if (bVar.OL) {
                if (bVar.gFD == 1) {
                    if (this.jGA.getListView() instanceof BdTypeListView) {
                        List<m> data = ((BdTypeListView) this.jGA.getListView()).getData();
                        if (!v.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.jGA.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.gFD == 2) {
                    this.jGy.Id(bVar.mPostId);
                    this.jGA.a(this.jGy.cCN(), this.jGy.cvD(), this.jGy.cDa() != null);
                    if (this.jGy.cCX()) {
                        this.jGy.rX(false);
                        this.jGA.cCs();
                        this.jGy.loadData();
                    }
                }
                e eVar = new e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void HA(String str) {
        if (this.jGy != null && this.jGy.cCN() != null && this.jGy.cCN().aIu() != null && this.jGy.cCN().aIu().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.jGy.cyx(), str);
            bj aIu = this.jGy.cCN().aIu();
            if (aIu.aJr()) {
                format = format + "&channelid=33833";
            } else if (aIu.aMv()) {
                format = format + "&channelid=33842";
            } else if (aIu.aJs()) {
                format = format + "&channelid=33840";
            }
            HB(format);
            return;
        }
        this.jty.Ia(str);
    }

    private void HB(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void k(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.jGy.cCT() && postData.getId() != null && postData.getId().equals(this.jGy.cCV())) {
                z = true;
            }
            MarkData l = this.jGy.l(postData);
            if (l != null) {
                this.jGA.cAX();
                if (this.jtz != null) {
                    this.jtz.a(l);
                    if (!z) {
                        this.jtz.aGZ();
                    } else {
                        this.jtz.aGY();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.jGy != null) {
            this.jGy.au(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.iBq != null) {
            this.iBq.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.iBq.aWN().aVq();
        this.iBq.aXM();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.iBq.b(writeData);
                this.iBq.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l mD = this.iBq.aWN().mD(6);
                if (mD != null && mD.dWM != null) {
                    mD.dWM.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.iBq.aXI();
                }
                this.jGA.cCK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gYv != null) {
            this.gYv.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.aFN().aFS();
        if (this.gYv != null) {
            this.gYv.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.ifd);
        this.jGA.bVb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
        cyd();
        if (this.gYv != null) {
            this.gYv.onResume(getPageContext());
        }
        registerListener(this.ifd);
        this.jGA.bVc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gYv != null) {
            this.gYv.onStop(getPageContext());
        }
        this.iBq.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.jGL));
        this.jGy.cancelLoadData();
        this.jGy.destory();
        this.jGz.cancelLoadData();
        if (this.gYv != null) {
            this.gYv.onDestory(getPageContext());
        }
        this.jGA.cAX();
        this.jGA.aqS();
        MessageManager.getInstance().unRegisterListener(this.juu);
        MessageManager.getInstance().unRegisterListener(this.juv);
        MessageManager.getInstance().unRegisterListener(this.juw);
        MessageManager.getInstance().unRegisterListener(this.jGJ);
        this.jtU = null;
        this.jtV = null;
        if (this.iBh != null) {
            this.iBh.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jGA.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gYv;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View cCz = this.jGA.cCz();
        if (cCz == null || (findViewWithTag = cCz.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean HT(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = ba.getParamPair(ba.getParamStr(str))) != null) {
            this.jGK = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return HT(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(jGx);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void e(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (HT(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                    jVar.mLink = str;
                    jVar.type = 3;
                    jVar.dVP = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, jVar));
                }
            } else {
                ba.aOV().b(getPageContext(), new String[]{str});
            }
            this.jGK = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ak(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.jGK = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void al(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void am(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void an(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void t(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        if (this.jGA != null) {
            return this.jGA.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bcM() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bcO() {
        if (this.epE == null) {
            this.epE = TbRichTextView.u(getPageContext().getPageActivity(), 8);
        }
        return this.epE;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bcP() {
        if (this.emN == null) {
            this.emN = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bJu */
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
        return this.emN;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bcN() {
        if (this.emM == null) {
            this.emM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bcZ */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.aIc().isShowImages();
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
                        if (i.aIc().isShowImages()) {
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
        return this.emM;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bcQ() {
        if (this.epF == null) {
            this.epF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cyk */
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
        return this.epF;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bcR() {
        if (this.epG == null) {
            this.epG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cym */
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
        return this.epG;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bcS() {
        this.epH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cyl */
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
        return this.epH;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cwp() {
        return this.jqi;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cwq() {
        return (this.jGy == null || this.jGy.cCN() == null || this.jGy.cCN().aIu() == null || this.jGy.cCN().aIu().aLW()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cwr() {
        if (this.jGy == null || this.jGy.cCN() == null || this.jGy.cCN().aIu() == null) {
            return null;
        }
        return this.jGy.cCN().aIu().aKH();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cws() {
        if (this.jGy == null) {
            return 0;
        }
        return this.jGy.cvD();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Hv(String str) {
        if (StringUtils.isNull(str) || this.jGy == null || this.jGy.cCN() == null || this.jGy.cCN().aIu() == null || this.jGy.cCN().aIu().aKC() == null) {
            return false;
        }
        return str.equals(this.jGy.cCN().aIu().aKC().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.jGA.cCu() && com.baidu.adp.lib.util.l.isNetOk()) {
            this.jGy.loadData();
        } else {
            this.jGA.cCx();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.jGJ);
        userMuteAddAndDelCustomMessage.setTag(this.jGJ);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ib(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString("bubble_link", "");
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
    public void ao(Context context, String str) {
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
                return com.baidu.tbadk.m.e.aZk().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.jGy != null) {
            if (this.jGy.cCN() != null && this.jGy.cCN().aXG() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.jGy.cCN().aXG().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.jGy.cyx(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public boolean cCo() {
        if (this.jGy != null) {
            return this.jGy.cCo();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.jGA.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jtU.getPageActivity());
        if (aq.isEmpty(str)) {
            aVar.ui(this.jtU.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.ui(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.jGA.showLoadingDialog();
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
        aVar.b(this.jtU).aMS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wI(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jtU.getPageActivity());
        aVar.ui(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.jtU).aMS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cya() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ui(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.jtU).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.jtU.getPageActivity(), 2, true, 4);
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
        aVar.b(this.jtU).aMS();
    }

    public SubPbModel cCp() {
        return this.jGy;
    }

    public int cvD() {
        if (this.jGy != null) {
            return this.jGy.cvD();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.dXi && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.dXi && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void nZ(boolean z) {
        if (this.hSt != null && this.hSt.getText() != null) {
            int selectionEnd = this.hSt.getSelectionEnd();
            SpannableStringBuilder a2 = this.hSs.a(this.hSt.getText());
            if (a2 != null) {
                this.hSs.uO(true);
                this.hSt.setText(a2);
                if (z && this.hSs.deQ() >= 0) {
                    this.hSt.requestFocus();
                    this.hSt.setSelection(this.hSs.deQ());
                } else {
                    this.hSt.setSelection(selectionEnd);
                }
                this.hSs.uN(this.hSs.deQ() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.iBq != null && this.iBq.aWN() != null && this.iBq.aWN().aWP()) {
            this.iBq.aWN().aVq();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.d.a(pVar, getUniqueId(), this);
    }

    public String cAl() {
        if (!aq.isEmpty(this.jBt)) {
            return this.jBt;
        }
        this.jBt = getResources().getString(com.baidu.tieba.pb.pb.main.am.cAa());
        return this.jBt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.jGM = z;
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
        if (this.jGA != null && this.jGA.getListView() != null && this.jGN != null && this.jGN.mPosition != -1) {
            final int headerViewsCount = this.jGN.mPosition + this.jGA.getListView().getHeaderViewsCount();
            if (this.jGN.getView() != null) {
                final int height = this.jGN.getView().getHeight() - ((rect.height() - this.jGA.getNavigationBarHeight()) - this.jGA.cCJ());
                if (height > 0) {
                    this.jGA.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.jGA != null && NewSubPbActivity.this.jGA.getListView() != null) {
                                NewSubPbActivity.this.jGA.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.jGA.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.jGA.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.jGA != null && NewSubPbActivity.this.jGA.getListView() != null) {
                                NewSubPbActivity.this.jGA.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.jGA.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }

    private void cyd() {
        if (this.jGy != null && !aq.isEmpty(this.jGy.cyx())) {
            com.baidu.tbadk.BdToken.c.aFN().o(com.baidu.tbadk.BdToken.b.dgd, com.baidu.adp.lib.f.b.toLong(this.jGy.cyx(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.jGy == null || aq.isEmpty(this.jGy.cyx())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.jGy.cyx(), 0L);
    }
}
