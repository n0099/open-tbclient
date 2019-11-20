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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.l;
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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.au;
import com.baidu.tieba.pb.pb.main.j;
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
    private static final String USER_ICON_WEBVIEW = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW;
    private static String iam = "tbgametype";
    private View.OnClickListener ZF;
    private com.baidu.adp.lib.e.b<ImageView> cTE;
    private com.baidu.adp.lib.e.b<GifView> cTF;
    private com.baidu.adp.lib.e.b<TextView> cWl;
    private com.baidu.adp.lib.e.b<View> cWm;
    private com.baidu.adp.lib.e.b<LinearLayout> cWn;
    private com.baidu.adp.lib.e.b<RelativeLayout> cWo;
    private au fWM;
    private VoiceManager fuw;
    private com.baidu.tieba.frs.profession.permission.c fyd;
    public aj gVU;
    private g gWc;
    private com.baidu.tieba.write.b gnK;
    private EditText gnL;
    private com.baidu.adp.base.e hLA;
    private com.baidu.tbadk.core.view.e hLB;
    private com.baidu.adp.widget.ImageView.a hLE;
    private String hLF;
    private TbRichTextMemeInfo hLG;
    private com.baidu.tieba.pb.pb.report.a hLc;
    private com.baidu.tbadk.baseEditMark.a hLd;
    private com.baidu.tieba.pb.pb.main.b.a hLg;
    private b.a hMq;
    private PostWriteCallBackData hPO;
    private String hWx;
    private com.baidu.tieba.pb.pb.sub.a iaB;
    private com.baidu.tieba.pb.e<k> iaC;
    private boolean iaD;
    private j iaE;
    private SubPbModel ian;
    private ForumManageModel iao;
    private b iap;
    private y iaq;
    private AbsListView.OnScrollListener iar;
    private TbRichTextView.i ias;
    private TbRichTextView.h iat;
    private SubPbModel.a iau;
    private com.baidu.adp.base.d iav;
    private BdUniqueId iaz;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int hMo = 0;
    PostData got = null;
    private a.InterfaceC0279a hMl = null;
    private a iaw = null;
    private a iax = null;
    private boolean dpZ = false;
    private boolean iay = false;
    private boolean iaA = false;
    private boolean cEK = false;
    private com.baidu.tbadk.editortools.pb.c cGh = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void auv() {
            NewSubPbActivity.this.iap.bXd();
        }
    };
    private com.baidu.tbadk.editortools.pb.b cGi = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean auu() {
            if (!NewSubPbActivity.this.gnK.cxy()) {
                return (NewSubPbActivity.this.gVU == null || NewSubPbActivity.this.ian == null || NewSubPbActivity.this.ian.biX() == null || NewSubPbActivity.this.gVU.Y(NewSubPbActivity.this.ian.biX().replyPrivateFlag, aj.cja)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.gnK.cxA());
            if (NewSubPbActivity.this.gWc.auK()) {
                NewSubPbActivity.this.gWc.a(NewSubPbActivity.this.hPO);
            }
            NewSubPbActivity.this.lp(true);
            return true;
        }
    };
    private NewWriteModel.d gnR = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.y yVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.gWc != null && NewSubPbActivity.this.gWc.atX() != null) {
                NewSubPbActivity.this.gWc.atX().hide();
                if (NewSubPbActivity.this.ian.bXz()) {
                    TiebaStatic.log(new an("c10367").bS("post_id", NewSubPbActivity.this.ian.aus()));
                }
            }
            if (z) {
                NewSubPbActivity.this.gnK.Fv(null);
                NewSubPbActivity.this.gnK.aM(null);
                NewSubPbActivity.this.gnK.rK(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.gnK.aM(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.gnK.Fv(postWriteCallBackData.getErrorString());
                if (!v.isEmpty(NewSubPbActivity.this.gnK.cxw())) {
                    NewSubPbActivity.this.hPO = postWriteCallBackData;
                    if (NewSubPbActivity.this.gWc.auK()) {
                        NewSubPbActivity.this.gWc.a(NewSubPbActivity.this.hPO);
                    }
                    NewSubPbActivity.this.lp(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.gVU != null) {
                NewSubPbActivity.this.gVU.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.iap.bXe();
        }
    };
    private CustomMessageListener hMd = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iaz) {
                NewSubPbActivity.this.iap.aVU();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hLB.showSuccessToast(NewSubPbActivity.this.hLA.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.hLA.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.pP(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bSE();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.hLA.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.hLB.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hMe = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iaz) {
                NewSubPbActivity.this.iap.aVU();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hLB.showSuccessToast(NewSubPbActivity.this.hLA.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.hLA.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.hLB.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener hMf = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iaz) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.iap.aVU();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.jvR;
                if (aVar.error == 0 && dataRes != null) {
                    boolean z2 = com.baidu.adp.lib.g.b.toInt(dataRes.is_mute, 0) == 1;
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
                    NewSubPbActivity.this.iap.a(sparseArray, z);
                }
            }
        }
    };
    boolean hMp = false;
    private final b.a hMr = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.hLE != null && !TextUtils.isEmpty(NewSubPbActivity.this.hLF)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.hLG == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.hLF));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.hLF;
                        aVar.pkgId = NewSubPbActivity.this.hLG.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hLG.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.fWM == null) {
                            NewSubPbActivity.this.fWM = new au(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.fWM.g(NewSubPbActivity.this.hLF, NewSubPbActivity.this.hLE.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.hLE = null;
                NewSubPbActivity.this.hLF = null;
            }
        }
    };
    private CustomMessageListener gzO = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener fvS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    l lVar = (l) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.ian.bXs() != null && NewSubPbActivity.this.ian.bXs().bRg() != null && NewSubPbActivity.this.ian.bXs().bRg().aiE() != null && currentAccount.equals(NewSubPbActivity.this.ian.bXs().bRg().aiE().getUserId()) && NewSubPbActivity.this.ian.bXs().bRg().aiE().getPendantData() != null) {
                        NewSubPbActivity.this.ian.bXs().bRg().aiE().getPendantData().mU(lVar.ahd());
                        NewSubPbActivity.this.ian.bXs().bRg().aiE().getPendantData().aZ(lVar.atC());
                        NewSubPbActivity.this.iap.a(NewSubPbActivity.this.ian.bXs().bRg(), NewSubPbActivity.this.ian.bXs().bDw(), NewSubPbActivity.this.ian.bXs().afk(), NewSubPbActivity.this.ian.bQJ(), NewSubPbActivity.this.ian.bXF() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void callback(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ab(bundle);
        if (this.cEK) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.hLA = getPageContext();
        this.iay = true;
        this.gnK = new com.baidu.tieba.write.b();
        this.gnK.Bs(R.color.cp_cont_h_alpha85);
        this.gnK.Br(R.color.cp_cont_a);
        aNb();
        bWS();
        initData(bundle);
        initUI();
        bLK();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bWR();
        this.hLB = new com.baidu.tbadk.core.view.e();
        this.hLB.toastTime = 1000L;
        registerListener(this.hMf);
        registerListener(this.hMd);
        registerListener(this.hMe);
        this.iaz = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.iaz;
        userMuteAddAndDelCustomMessage.setTag(this.iaz);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.iaz;
        userMuteCheckCustomMessage.setTag(this.iaz);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.gVU = new aj(getPageContext());
        this.gVU.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
            @Override // com.baidu.tbadk.core.util.aj.a
            public void f(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.gWc.auP();
                }
            }
        });
        this.hLc = new com.baidu.tieba.pb.pb.report.a(this);
        this.hLc.s(getUniqueId());
        this.hLg = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    private void bWR() {
        if (this.iap != null && this.ian != null && this.ian.bWU()) {
            this.iaB = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.iap.aKP());
            this.iaB.bnZ();
            this.iaB.a(new a.InterfaceC0490a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
                private boolean fJB = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0490a
                public void bnV() {
                    NewSubPbActivity.this.iap.kt(false);
                    this.fJB = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0490a
                public void bnW() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0490a
                public boolean bnX() {
                    if (!this.fJB) {
                        return NewSubPbActivity.this.iap.beB() != null && NewSubPbActivity.this.iap.beB().getTop() == 0;
                    }
                    this.fJB = false;
                    return false;
                }
            });
            this.iap.e(this.iaB);
            this.iap.kt(true);
        }
    }

    public void initUI() {
        this.iap = new b(this, this.ZF);
        this.iap.a(this.ian);
        setContentView(this.iap.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.iap.setOnScrollListener(this.iar);
        this.iap.b(this);
        this.iap.setOnLinkImageClickListener(this.ias);
        this.iap.setOnImageClickListener(this.iat);
        this.iap.nT(true);
        this.iap.setOnLongClickListener(this.mOnLongClickListener);
        this.iap.e(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.40
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.ian != null) {
                    NewSubPbActivity.this.ian.loadData();
                }
            }
        });
        this.iap.a(this.iaw);
        this.iap.b(this.iax);
        if (this.ian != null && this.ian.bWU() && !this.ian.bXE()) {
            this.iap.bXi().setVisibility(8);
        } else {
            this.iap.bXi().setVisibility(0);
        }
        if (this.ian != null && !this.ian.bWU()) {
            this.iap.setIsFromPb(false);
        }
    }

    private boolean ab(Bundle bundle) {
        if (bundle != null) {
            this.cEK = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.cEK = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.cEK;
    }

    public void initData(Bundle bundle) {
        this.ian = new SubPbModel(getPageContext());
        this.ian.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                NewSubPbActivity.this.iap.p(postData);
                NewSubPbActivity.this.iap.b((BdListView.e) null);
            }
        });
        this.iao = new ForumManageModel(getPageContext());
        this.iao.setLoadDataCallBack(this.iav);
        this.fuw = new VoiceManager();
        this.fuw.onCreate(getPageContext());
        this.hLd = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hLd != null) {
            this.hLd.a(this.hMl);
        }
        if (bundle != null) {
            this.ian.initWithBundle(bundle);
        } else {
            this.ian.initWithIntent(getIntent());
        }
        this.ian.a(this.iau);
        if (this.ian.bWU()) {
            this.ian.loadData();
        } else {
            this.ian.bXx();
        }
    }

    public void bWS() {
        this.iau = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, k kVar) {
                if (NewSubPbActivity.this.iap != null) {
                    NewSubPbActivity.this.iap.bXe();
                }
                if (NewSubPbActivity.this.iaB != null && NewSubPbActivity.this.iaB.boa()) {
                    NewSubPbActivity.this.iaB.rj(R.color.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.aB(i, str);
                    return;
                }
                NewSubPbActivity.this.iap.hideNoDataView();
                if (kVar != null) {
                    if (kVar.bRg() != null || NewSubPbActivity.this.ian != null) {
                        kVar.bRg().a(NewSubPbActivity.this.ian.bXD());
                    }
                    if (NewSubPbActivity.this.iap != null) {
                        NewSubPbActivity.this.iap.a(kVar, NewSubPbActivity.this.ian.bQJ(), NewSubPbActivity.this.ian.bXF() != null);
                        if (NewSubPbActivity.this.iay) {
                            NewSubPbActivity.this.bWT();
                            NewSubPbActivity.this.iay = false;
                        }
                    }
                    if (NewSubPbActivity.this.gWc != null) {
                        NewSubPbActivity.this.gWc.a(kVar.biX());
                    }
                    if (NewSubPbActivity.this.iaC == null) {
                        NewSubPbActivity.this.iaC = new com.baidu.tieba.pb.e();
                    }
                    NewSubPbActivity.this.iaC.setData(kVar);
                    NewSubPbActivity.this.iaC.setType(0);
                    NewSubPbActivity.this.gVU.a(NewSubPbActivity.this.ian.bXI());
                }
            }
        };
        this.hMl = new a.InterfaceC0279a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0279a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.hLd != null) {
                        NewSubPbActivity.this.hLd.dO(z2);
                    }
                    MarkData afn = NewSubPbActivity.this.hLd.afn();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(afn);
                        if (NewSubPbActivity.this.hLd != null) {
                            if (afn != null) {
                                NewSubPbActivity.this.ian.pe(true);
                                NewSubPbActivity.this.ian.Bk(NewSubPbActivity.this.ian.aus());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.iap != null) {
                                NewSubPbActivity.this.iap.pd(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.ian.pe(false);
                        NewSubPbActivity.this.ian.Bk(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.iap != null) {
                            NewSubPbActivity.this.iap.pd(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.iaw = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.ian.bXs() != null && NewSubPbActivity.this.ian.bXs().agG() != null && NewSubPbActivity.this.ian.bXs().agG().aiE() != null) {
                    str = String.valueOf(NewSubPbActivity.this.ian.bXs().agG().aiE().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.ian.bXs().bRm().getId(), NewSubPbActivity.this.ian.bXs().bRm().getName(), NewSubPbActivity.this.ian.bXs().agG().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.iax = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.iao.cpc() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.g.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.g.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.g.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.ian != null && NewSubPbActivity.this.ian.bXs() != null && NewSubPbActivity.this.ian.bXs().bRm() != null && NewSubPbActivity.this.ian.bXs().agG() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.iao.DU(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.iao.a(NewSubPbActivity.this.ian.bXs().bRm().getId(), NewSubPbActivity.this.ian.bXs().bRm().getName(), NewSubPbActivity.this.ian.bXs().agG().getId(), valueOf, i2, i, z);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.iav = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.iap.a(NewSubPbActivity.this.iao.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.iao.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.iby != 1002 || bVar.dQT) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.iap.a(1, dVar.sF, dVar.jkg, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean cu(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void aNb() {
        registerListener(this.fvS);
        this.ZF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v63, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.iap != null) {
                    if (view == NewSubPbActivity.this.iap.bXo()) {
                        NewSubPbActivity.this.iap.bVL();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ba.amO().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.iap.bol()) {
                        if (view != NewSubPbActivity.this.iap.bXh()) {
                            if (view != NewSubPbActivity.this.iap.bXg()) {
                                if (view == NewSubPbActivity.this.iap.bXc()) {
                                    NewSubPbActivity.this.iap.bVL();
                                    if (NewSubPbActivity.this.ian.loadData()) {
                                        NewSubPbActivity.this.iap.bXa();
                                    }
                                } else if (view == NewSubPbActivity.this.iap.bXi() || view == NewSubPbActivity.this.iap.bXj() || view == NewSubPbActivity.this.iap.bXl()) {
                                    if (NewSubPbActivity.this.iaA) {
                                        NewSubPbActivity.this.iaA = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.ian.bTy(), NewSubPbActivity.this.ian.aus(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.ian.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.ian.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                } else if (NewSubPbActivity.this.iap.bXm() == null || view != NewSubPbActivity.this.iap.bXm().bUp()) {
                                    if (NewSubPbActivity.this.iap.bXm() == null || view != NewSubPbActivity.this.iap.bXm().bUs()) {
                                        if (NewSubPbActivity.this.iap.bXm() == null || view != NewSubPbActivity.this.iap.bXm().bUq()) {
                                            if (NewSubPbActivity.this.iap.bXm() == null || view != NewSubPbActivity.this.iap.bXm().bUr()) {
                                                if (NewSubPbActivity.this.iap.bXm() == null || view != NewSubPbActivity.this.iap.bXm().bUt()) {
                                                    if (view == NewSubPbActivity.this.iap.bXf() || view == NewSubPbActivity.this.iap.bXl()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.gWc.auS()) {
                                                                NewSubPbActivity.this.gWc.auT();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.gWc.pQ(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof j)) {
                                                        if (NewSubPbActivity.this.iaq == null || view != NewSubPbActivity.this.iaq.bUr()) {
                                                            if (NewSubPbActivity.this.iaq == null || view != NewSubPbActivity.this.iaq.bUp()) {
                                                                if (NewSubPbActivity.this.iaq == null || view != NewSubPbActivity.this.iaq.bUs()) {
                                                                    if (NewSubPbActivity.this.iaq == null || view != NewSubPbActivity.this.iaq.bUt()) {
                                                                        if (NewSubPbActivity.this.iaq == null || view != NewSubPbActivity.this.iaq.bUv()) {
                                                                            if (NewSubPbActivity.this.iaq == null || view != NewSubPbActivity.this.iaq.bUw()) {
                                                                                if (NewSubPbActivity.this.iaq != null && view == NewSubPbActivity.this.iaq.bUq()) {
                                                                                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                                        NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                                                        return;
                                                                                    }
                                                                                    SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                                                                                    if (sparseArray != null) {
                                                                                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                        boolean booleanValue2 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                        boolean booleanValue3 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                        if (booleanValue) {
                                                                                            if (booleanValue3) {
                                                                                                sparseArray.put(R.id.tag_from, 1);
                                                                                                sparseArray.put(R.id.tag_check_mute_from, 2);
                                                                                                NewSubPbActivity.this.b(sparseArray);
                                                                                                return;
                                                                                            }
                                                                                            sparseArray.put(R.id.tag_check_mute_from, 2);
                                                                                            NewSubPbActivity.this.iap.cA(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.iap.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.alP().getString("tail_link", "");
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
                                                                                        if (postData.getType() != PostData.jhx && !TextUtils.isEmpty(postData.getBimg_url()) && i.ago().isShowImages()) {
                                                                                            NewSubPbActivity.this.Bh(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.hLE != null && !TextUtils.isEmpty(NewSubPbActivity.this.hLF)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.fWM == null) {
                                                                                        NewSubPbActivity.this.fWM = new au(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.fWM.g(NewSubPbActivity.this.hLF, NewSubPbActivity.this.hLE.getImageByte());
                                                                                    NewSubPbActivity.this.hLE = null;
                                                                                    NewSubPbActivity.this.hLF = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.hLE != null && !TextUtils.isEmpty(NewSubPbActivity.this.hLF)) {
                                                                            if (NewSubPbActivity.this.hLG == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.hLF));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.hLF;
                                                                                aVar.pkgId = NewSubPbActivity.this.hLG.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hLG.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.hLE = null;
                                                                            NewSubPbActivity.this.hLF = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.got != null) {
                                                                        NewSubPbActivity.this.got.ec(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.got = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.iap.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.ct(view);
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                            return;
                                                        } else {
                                                            Object tag = view.getTag();
                                                            if (tag instanceof String) {
                                                                NewSubPbActivity.this.AH((String) tag);
                                                                return;
                                                            } else if (tag instanceof SparseArray) {
                                                                SparseArray<Object> sparseArray3 = (SparseArray) tag;
                                                                if ((sparseArray3.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray3.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                                    sparseArray3.put(R.id.tag_from, 0);
                                                                    sparseArray3.put(R.id.tag_check_mute_from, 2);
                                                                    NewSubPbActivity.this.b(sparseArray3);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        NewSubPbActivity.this.iaE = (j) view.getTag();
                                                        if (bc.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.iaA) {
                                                                NewSubPbActivity.this.iaA = false;
                                                                return;
                                                            } else if (NewSubPbActivity.this.gVU == null || NewSubPbActivity.this.ian == null || NewSubPbActivity.this.ian.biX() == null || NewSubPbActivity.this.gVU.ip(NewSubPbActivity.this.ian.biX().replyPrivateFlag)) {
                                                                if (NewSubPbActivity.this.iaB != null) {
                                                                    NewSubPbActivity.this.iaB.bnY();
                                                                }
                                                                SparseArray sparseArray4 = (SparseArray) view.getTag(R.id.tag_from);
                                                                if (sparseArray4 != null) {
                                                                    if (sparseArray4.get(R.id.tag_clip_board) instanceof PostData) {
                                                                        PostData postData2 = (PostData) sparseArray4.get(R.id.tag_clip_board);
                                                                        if (postData2 != null && postData2.aiE() != null) {
                                                                            MetaData aiE = postData2.aiE();
                                                                            NewSubPbActivity.this.gWc.setReplyId(aiE.getUserId());
                                                                            if (!(sparseArray4.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.tag_is_subpb)).booleanValue() : true)) {
                                                                                NewSubPbActivity.this.gWc.pR("");
                                                                            } else {
                                                                                NewSubPbActivity.this.gWc.pR(aiE.getName_show());
                                                                            }
                                                                        }
                                                                        NewSubPbActivity.this.iap.bWY();
                                                                    }
                                                                    if (NewSubPbActivity.this.iaD) {
                                                                        NewSubPbActivity.this.pc(false);
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
                                                    if (sparseArray5.get(R.id.tag_clip_board) instanceof PostData) {
                                                        ((PostData) sparseArray5.get(R.id.tag_clip_board)).ec(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new an("c11739").O("obj_locate", 4));
                                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.iap.bVL();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.AH(str4);
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
                                        } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            NewSubPbActivity.this.iap.bVL();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.cE(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.iap.bVL();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.iap.a(((Integer) sparseArray7.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray7.get(R.id.tag_del_post_id), ((Integer) sparseArray7.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new an("c11739").O("obj_locate", 2));
                                    NewSubPbActivity.this.iap.bVL();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.ian.bXs() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.ian.bXs().bRg());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.iap.bWX();
                                NewSubPbActivity.this.iap.bWY();
                                if (NewSubPbActivity.this.gWc != null) {
                                    NewSubPbActivity.this.gWc.auV();
                                    if (NewSubPbActivity.this.iaB != null) {
                                        NewSubPbActivity.this.iaB.bnY();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.iap.bWX();
                            NewSubPbActivity.this.iap.bWY();
                            if (NewSubPbActivity.this.gWc != null) {
                                NewSubPbActivity.this.gWc.auU();
                                if (NewSubPbActivity.this.iaB != null) {
                                    NewSubPbActivity.this.iaB.bnY();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.bSa();
                        if (NewSubPbActivity.this.ian != null && NewSubPbActivity.this.ian.bXs() != null && NewSubPbActivity.this.ian.bXs().agG() != null && NewSubPbActivity.this.ian.bXs().agG().aiE() != null) {
                            TiebaStatic.log(new an("c13402").bS("tid", NewSubPbActivity.this.ian.bTy()).p("fid", NewSubPbActivity.this.ian.bXs().agG().getFid()).O("obj_locate", 5).bS("uid", NewSubPbActivity.this.ian.bXs().agG().aiE().getUserId()));
                        }
                    }
                }
            }
        };
        this.iar = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.iap.bVL();
                }
                NewSubPbActivity.this.gWc.auT();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.iap.bXn();
            }
        };
        this.hMq = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.ian.bXs() != null) {
                    postData = NewSubPbActivity.this.ian.bXs().bRg();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.ec(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.f(postData);
                    }
                }
            }
        };
        this.mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            /* JADX WARN: Removed duplicated region for block: B:111:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
            /* JADX WARN: Removed duplicated region for block: B:92:0x0293  */
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
                if (sparseArray == null && NewSubPbActivity.this.cu(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.hLE = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.hLF = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.hLE != null && !TextUtils.isEmpty(NewSubPbActivity.this.hLF)) {
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hLG = null;
                            } else {
                                NewSubPbActivity.this.hLG = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                NewSubPbActivity.this.iap.a(NewSubPbActivity.this.hMr, NewSubPbActivity.this.hLE.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                NewSubPbActivity.this.got = (PostData) sparseArray2.get(R.id.tag_clip_board);
                                if (NewSubPbActivity.this.got != null && NewSubPbActivity.this.hLd != null) {
                                    if (NewSubPbActivity.this.hLd != null) {
                                        NewSubPbActivity.this.hLd.dO(NewSubPbActivity.this.ian.bXy());
                                    }
                                    boolean z = NewSubPbActivity.this.hLd.afk() && NewSubPbActivity.this.got.getId() != null && NewSubPbActivity.this.got.getId().equals(NewSubPbActivity.this.ian.bXA());
                                    if (NewSubPbActivity.this.iaq == null) {
                                        NewSubPbActivity.this.iaq = new y(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.ZF);
                                        NewSubPbActivity.this.iap.cF(NewSubPbActivity.this.iaq.getView());
                                        NewSubPbActivity.this.iaq.ot(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.iaq.showDialog();
                                    boolean isLogin = NewSubPbActivity.this.isLogin() & NewSubPbActivity.this.oa(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false);
                                    boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                                    if (z) {
                                        NewSubPbActivity.this.iaq.bUp().setText(R.string.remove_mark);
                                    } else {
                                        NewSubPbActivity.this.iaq.bUp().setText(R.string.mark);
                                    }
                                    if (booleanValue) {
                                        NewSubPbActivity.this.iaq.bUp().setVisibility(8);
                                    } else {
                                        NewSubPbActivity.this.iaq.bUp().setVisibility(0);
                                    }
                                    if (NewSubPbActivity.this.cu(view)) {
                                        if (NewSubPbActivity.this.hLE != null && !NewSubPbActivity.this.hLE.isGif()) {
                                            sparseArray2.put(R.id.tag_richtext_image, true);
                                        } else {
                                            sparseArray2.put(R.id.tag_richtext_image, false);
                                        }
                                        sparseArray2.put(R.id.tag_richtext_emotion, true);
                                    } else {
                                        sparseArray2.put(R.id.tag_richtext_image, false);
                                        sparseArray2.put(R.id.tag_richtext_emotion, false);
                                    }
                                    NewSubPbActivity.this.iaq.a(sparseArray2, NewSubPbActivity.this.bQJ(), isLogin);
                                }
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            NewSubPbActivity.this.hLE = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                NewSubPbActivity.this.hLF = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hLG = null;
                            } else {
                                NewSubPbActivity.this.hLG = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.hLE = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.hLF = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.hLG = null;
                        } else {
                            NewSubPbActivity.this.hLG = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
        this.ias = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void e(View view, String str) {
                NewSubPbActivity.this.s(null, str, "LINK_IMAGE");
            }
        };
        this.iat = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                    if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        k bXs = NewSubPbActivity.this.ian.bXs();
                        TbRichText bb = NewSubPbActivity.this.bb(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bb != null && bb.azf() != null) {
                            tbRichTextData = bb.azf().get(NewSubPbActivity.this.hMo);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.azn().azz()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (bXs == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (bXs.bRm() != null) {
                                        str4 = bXs.bRm().getName();
                                        str5 = bXs.bRm().getId();
                                    }
                                    if (bXs.agG() != null) {
                                        str6 = bXs.agG().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.ian.bXF() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.ian.bXF();
                                    z6 = NewSubPbActivity.this.ian.bXH();
                                    arrayList2 = NewSubPbActivity.this.ian.bXG();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.getItem(arrayList2, 0));
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                                return;
                            }
                            NewSubPbActivity.this.hMp = false;
                            String str7 = "";
                            TbRichText cop = bXs.bRg().cop();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(cop, bb, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (bXs == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (bXs.bRm() != null) {
                                    str8 = bXs.bRm().getName();
                                    str9 = bXs.bRm().getId();
                                }
                                if (bXs.agG() != null) {
                                    str10 = bXs.agG().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.ian.bXF() != null) {
                                concurrentHashMap = NewSubPbActivity.this.ian.bXF();
                                z4 = NewSubPbActivity.this.ian.bXH();
                                arrayList = NewSubPbActivity.this.ian.bXG();
                                i2 = a2 + NewSubPbActivity.this.ian.getOffset();
                            } else {
                                concurrentHashMap = concurrentHashMap3;
                                i2 = a2;
                                z4 = z3;
                                arrayList = arrayList2;
                            }
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(v.getItem(arrayList, i2));
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList4, 0, str8, str9, str2, z4, str7, true, concurrentHashMap, true, false, false)));
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
    public void ct(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            f(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo azn;
        if (tbRichText == tbRichText2) {
            this.hMp = true;
        }
        if (tbRichText != null && tbRichText.azf() != null) {
            int size = tbRichText.azf().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.azf().get(i6) != null && tbRichText.azf().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.azf().get(i6).azn().getWidth() * equipmentDensity;
                    int height = tbRichText.azf().get(i6).azn().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.azf().get(i6).azn().azz()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.azf().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (azn = tbRichTextData.azn()) != null) {
                            String azB = azn.azB();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = azB;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.hMp) {
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
        if (this.iaq != null) {
            this.iaq.ot(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo azn = tbRichTextData.azn();
        if (azn != null) {
            if (!StringUtils.isNull(azn.azy())) {
                return azn.azy();
            }
            if (azn.getHeight() * azn.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (azn.getHeight() * azn.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (azn.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * azn.getHeight())));
            } else {
                float width = azn.getWidth() / azn.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(azn.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bb(String str, int i) {
        if (this.ian == null || this.ian.bXs() == null || str == null || i < 0) {
            return null;
        }
        k bXs = this.ian.bXs();
        TbRichText a2 = a(bXs.bRg(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bXs.bRg(), str, i);
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
        TbRichText cop = postData.cop();
        if (cop != null) {
            ArrayList<TbRichTextData> azf = cop.azf();
            int size = azf.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (azf.get(i3) != null && azf.get(i3).getType() == 8) {
                    i2++;
                    if (azf.get(i3).azn().azB().equals(str)) {
                        int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = azf.get(i3).azn().getWidth() * equipmentDensity;
                        int height = azf.get(i3).azn().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.hMo = i3;
                        return cop;
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
    public void bSa() {
        if (this.fyd == null) {
            this.fyd = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.fyd.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jW(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void o(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jX(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.gVU == null || NewSubPbActivity.this.ian == null || NewSubPbActivity.this.ian.biX() == null || NewSubPbActivity.this.gVU.ip(NewSubPbActivity.this.ian.biX().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.gWc.auK()) {
                                NewSubPbActivity.this.gWc.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.iap.bWX();
                            NewSubPbActivity.this.iap.bWY();
                            if (NewSubPbActivity.this.gWc != null) {
                                NewSubPbActivity.this.gWc.auW();
                                if (NewSubPbActivity.this.iaB != null) {
                                    NewSubPbActivity.this.iaB.bnY();
                                }
                            }
                        }
                    }
                }
            });
        }
        if (this.ian != null && this.ian.bXs() != null && this.ian.bXs().bRm() != null) {
            this.fyd.z(this.ian.bXs().bRm().getId(), com.baidu.adp.lib.g.b.toLong(this.ian.bTy(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oa(boolean z) {
        if (this.ian == null) {
            return false;
        }
        return ((bQJ() != 0) || this.ian.bXs() == null || this.ian.bXs().agG() == null || this.ian.bXs().agG().aiE() == null || TextUtils.equals(this.ian.bXs().agG().aiE().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Context context, String str, String str2) {
        long templateId = this.ian.bXs().bRg().cow() != null ? this.ian.bXs().bRg().cow().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ba.amO().b(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.ian.bXs().bRm().getId(), this.ian.bXs().bRm().getName(), this.ian.bXs().agG().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(int i, String str) {
        if (this.ian.bXt()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.isNetOk()) {
            if (i == 4) {
                this.iap.us(str + "(4)");
            } else {
                this.iap.ub(R.string.no_data_text);
            }
        } else {
            this.iap.ub(R.string.recommend_pb_no_net_text);
        }
    }

    private void bLK() {
        this.gWc = (g) new h().cw(getActivity());
        if (this.gWc != null) {
            this.gWc.a(getPageContext());
            this.gWc.b(this.ian);
            this.gWc.b(this.gnR);
            this.gWc.a(this.cGh);
            this.gWc.a(this.cGi);
            this.gWc.atX().fe(true);
            this.gWc.e(getPageContext());
        }
        if (this.iap != null) {
            this.iap.g(this.gWc);
        }
        if (this.gWc != null && this.ian != null) {
            this.gWc.a(this.ian.biX());
            this.gWc.auT();
        }
        if (this.gWc != null) {
            this.gWc.auX().setDefaultHint(bVa());
            this.gWc.auX().setHint(bVa());
            this.gnL = this.gWc.auX().getInputView();
            this.gnL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.gnK != null) {
                        if (!NewSubPbActivity.this.gnK.cxz()) {
                            NewSubPbActivity.this.lp(false);
                        }
                        NewSubPbActivity.this.gnK.rL(false);
                    }
                }
            });
        }
    }

    public void bWT() {
        if (!TbadkCoreApplication.isLogin()) {
            this.gWc.auT();
        } else if (!StringUtils.isNull(this.ian.bXB())) {
            if (this.iap.bXb() && com.baidu.adp.lib.util.l.isNetOk()) {
                this.iap.bhb();
            } else {
                this.iap.bXe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE(View view) {
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
                    this.iap.cA(view);
                }
            } else if (booleanValue2) {
                this.iap.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.dismissPopupWindow(this.iap.bXk(), getPageContext().getPageActivity());
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
            bVar.hX(R.string.operation);
            bVar.a(strArr, new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.iaz);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.iaz);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).akN();
        }
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.iap.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.iaz;
        userMuteCheckCustomMessage.setTag(this.iaz);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.iap.a(0, bVar.sF, bVar.jkg, z);
            if (bVar.sF) {
                if (bVar.fei == 1) {
                    if (this.iap.getListView() instanceof BdTypeListView) {
                        List<m> data = ((BdTypeListView) this.iap.getListView()).getData();
                        if (!v.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.iap.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.fei == 2) {
                    this.ian.Bj(bVar.mPostId);
                    this.iap.a(this.ian.bXs(), this.ian.bQJ(), this.ian.bXF() != null);
                    if (this.ian.bXC()) {
                        this.ian.pf(false);
                        this.iap.bWZ();
                        this.ian.loadData();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void AH(String str) {
        this.hLc.Bf(str);
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.ian.bXy() && postData.getId() != null && postData.getId().equals(this.ian.bXA())) {
                z = true;
            }
            MarkData j = this.ian.j(postData);
            if (j != null) {
                this.iap.bVL();
                if (this.hLd != null) {
                    this.hLd.a(j);
                    if (!z) {
                        this.hLd.afm();
                    } else {
                        this.hLd.afl();
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
        if (bundle != null && this.ian != null) {
            this.ian.aa(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.gWc != null) {
            this.gWc.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.gWc.atX().asA();
        this.gWc.auT();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gWc.b(writeData);
                this.gWc.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k jK = this.gWc.atX().jK(6);
                if (jK != null && jK.cEn != null) {
                    jK.cEn.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gWc.auP();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fuw != null) {
            this.fuw.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.dpZ = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.adX().aec();
        if (this.fuw != null) {
            this.fuw.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.gzO);
        this.iap.bqn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.dpZ = false;
        super.onResume();
        bSI();
        if (this.fuw != null) {
            this.fuw.onResume(getPageContext());
        }
        registerListener(this.gzO);
        this.iap.bqo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fuw != null) {
            this.fuw.onStop(getPageContext());
        }
        this.gWc.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.iaC));
        this.ian.cancelLoadData();
        this.ian.destory();
        this.iao.cancelLoadData();
        if (this.fuw != null) {
            this.fuw.onDestory(getPageContext());
        }
        this.iap.bVL();
        this.iap.aGF();
        MessageManager.getInstance().unRegisterListener(this.hMd);
        MessageManager.getInstance().unRegisterListener(this.hMe);
        MessageManager.getInstance().unRegisterListener(this.hMf);
        MessageManager.getInstance().unRegisterListener(this.iaz);
        this.hLA = null;
        this.hLB = null;
        if (this.gVU != null) {
            this.gVU.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iap.onChangeSkinType(i);
        if (this.iaB != null && this.iaB.boa()) {
            this.iaB.rj(R.color.cp_mask_b_alpha66);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.fuw;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bXf = this.iap.bXf();
        if (bXf == null || (findViewWithTag = bXf.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean AY(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = ba.getParamPair(ba.getParamStr(str))) != null) {
            this.iaA = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return AY(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(iam);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void d(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (AY(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                    kVar.mLink = str;
                    kVar.type = 3;
                    kVar.cDn = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
                }
            } else {
                ba.amO().b(getPageContext(), new String[]{str});
            }
            this.iaA = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ai(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iaA = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aj(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ak(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void al(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void o(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.iap != null) {
            return this.iap.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int azN() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> azP() {
        if (this.cWl == null) {
            this.cWl = TbRichTextView.q(getPageContext().getPageActivity(), 8);
        }
        return this.cWl;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> azQ() {
        if (this.cTF == null) {
            this.cTF = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bSM */
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
        return this.cTF;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> azO() {
        if (this.cTE == null) {
            this.cTE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bSL */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.ago().isShowImages();
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
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: b */
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
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (i.ago().isShowImages()) {
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
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
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
        return this.cTE;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> azR() {
        if (this.cWm == null) {
            this.cWm = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bSN */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cv */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cw */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cx */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.cWm;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> azS() {
        if (this.cWn == null) {
            this.cWn = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bSP */
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
        return this.cWn;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> azT() {
        this.cWo = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bSO */
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
        return this.cWo;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bRs() {
        return this.hLg;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bRt() {
        return (this.ian == null || this.ian.bXs() == null || this.ian.bXs().agG() == null || this.ian.bXs().agG().ajV()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bRu() {
        if (this.ian == null || this.ian.bXs() == null || this.ian.bXs().agG() == null) {
            return null;
        }
        return this.ian.bXs().agG().aiJ();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bRv() {
        if (this.ian == null) {
            return 0;
        }
        return this.ian.bQJ();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean AE(String str) {
        if (StringUtils.isNull(str) || this.ian == null || this.ian.bXs() == null || this.ian.bXs().agG() == null || this.ian.bXs().agG().aiE() == null) {
            return false;
        }
        return str.equals(this.ian.bXs().agG().aiE().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.iap.bXb() && com.baidu.adp.lib.util.l.isNetOk()) {
            this.ian.loadData();
        } else {
            this.iap.bXe();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.iaz);
        userMuteAddAndDelCustomMessage.setTag(this.iaz);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bh(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.alP().getString("bubble_link", "");
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

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
        s(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB_FLOOR;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public com.baidu.tbadk.o.b getPageStayFilter() {
        return new com.baidu.tbadk.o.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.o.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.o.b
            public int getMaxCost() {
                return com.baidu.tbadk.o.e.awx().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.ian != null) {
            if (this.ian.bXs() != null && this.ian.bXs().bRm() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.toLong(this.ian.bXs().bRm().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.toLong(this.ian.bTy(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.dpZ;
    }

    public boolean bWU() {
        if (this.ian != null) {
            return this.ian.bWU();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.iap.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hLA.getPageActivity());
        if (aq.isEmpty(str)) {
            aVar.nn(this.hLA.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.nn(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.iap.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hLA).akM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pP(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hLA.getPageActivity());
        aVar.nn(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hLA).akM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSE() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nn(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.hLA).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.hLA.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hLA).akM();
    }

    public SubPbModel bWV() {
        return this.ian;
    }

    public int bQJ() {
        if (this.ian != null) {
            return this.ian.bQJ();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.cEK) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.cEK) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void lp(boolean z) {
        if (this.gnL != null && this.gnL.getText() != null) {
            int selectionEnd = this.gnL.getSelectionEnd();
            SpannableStringBuilder a2 = this.gnK.a(this.gnL.getText());
            if (a2 != null) {
                this.gnK.rL(true);
                this.gnL.setText(a2);
                if (z && this.gnK.cxx() >= 0) {
                    this.gnL.requestFocus();
                    this.gnL.setSelection(this.gnK.cxx());
                } else {
                    this.gnL.setSelection(selectionEnd);
                }
                this.gnK.rK(this.gnK.cxx() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gWc != null && this.gWc.atX() != null && this.gWc.atX().atZ()) {
            this.gWc.atX().asA();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.d.a(pVar, getUniqueId(), this);
    }

    public String bVa() {
        if (!aq.isEmpty(this.hWx)) {
            return this.hWx;
        }
        this.hWx = getResources().getString(ap.bUS());
        return this.hWx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.iaD = z;
        pc(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pc(boolean z) {
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
        if (this.iap != null && this.iap.getListView() != null && this.iaE != null && this.iaE.mPosition != -1) {
            final int headerViewsCount = this.iaE.mPosition + this.iap.getListView().getHeaderViewsCount();
            if (this.iaE.getView() != null) {
                final int height = this.iaE.getView().getHeight() - ((rect.height() - this.iap.getNavigationBarHeight()) - this.iap.bXp());
                if (height > 0) {
                    this.iap.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.iap != null && NewSubPbActivity.this.iap.getListView() != null) {
                                NewSubPbActivity.this.iap.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.iap.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.iap.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.iap != null && NewSubPbActivity.this.iap.getListView() != null) {
                                NewSubPbActivity.this.iap.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.iap.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }

    private void bSI() {
        if (this.ian != null && !aq.isEmpty(this.ian.bTy())) {
            com.baidu.tbadk.BdToken.c.adX().i(com.baidu.tbadk.BdToken.b.bQa, com.baidu.adp.lib.g.b.toLong(this.ian.bTy(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.ian == null || aq.isEmpty(this.ian.bTy())) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.toLong(this.ian.bTy(), 0L);
    }
}
