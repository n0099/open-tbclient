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
    private static String ibd = "tbgametype";
    private View.OnClickListener ZX;
    private com.baidu.adp.lib.e.b<ImageView> cUv;
    private com.baidu.adp.lib.e.b<GifView> cUw;
    private com.baidu.adp.lib.e.b<TextView> cXc;
    private com.baidu.adp.lib.e.b<View> cXd;
    private com.baidu.adp.lib.e.b<LinearLayout> cXe;
    private com.baidu.adp.lib.e.b<RelativeLayout> cXf;
    private au fXD;
    private VoiceManager fvn;
    private com.baidu.tieba.frs.profession.permission.c fyU;
    public aj gWL;
    private g gWT;
    private com.baidu.tieba.write.b goB;
    private EditText goC;
    private com.baidu.tieba.pb.pb.report.a hLT;
    private com.baidu.tbadk.baseEditMark.a hLU;
    private com.baidu.tieba.pb.pb.main.b.a hLX;
    private com.baidu.adp.base.e hMr;
    private com.baidu.tbadk.core.view.e hMs;
    private com.baidu.adp.widget.ImageView.a hMv;
    private String hMw;
    private TbRichTextMemeInfo hMx;
    private b.a hNh;
    private PostWriteCallBackData hQF;
    private String hXo;
    private SubPbModel ibe;
    private ForumManageModel ibf;
    private b ibg;
    private y ibh;
    private AbsListView.OnScrollListener ibi;
    private TbRichTextView.i ibj;
    private TbRichTextView.h ibk;
    private SubPbModel.a ibl;
    private com.baidu.adp.base.d ibm;
    private BdUniqueId ibq;
    private com.baidu.tieba.pb.pb.sub.a ibs;
    private com.baidu.tieba.pb.e<k> ibt;
    private boolean ibu;
    private j ibv;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int hNf = 0;
    PostData gpk = null;
    private a.InterfaceC0279a hNc = null;
    private a ibn = null;
    private a ibo = null;
    private boolean dqQ = false;
    private boolean ibp = false;
    private boolean ibr = false;
    private boolean cFB = false;
    private com.baidu.tbadk.editortools.pb.c cGY = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aux() {
            NewSubPbActivity.this.ibg.bXf();
        }
    };
    private com.baidu.tbadk.editortools.pb.b cGZ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean auw() {
            if (!NewSubPbActivity.this.goB.cxA()) {
                return (NewSubPbActivity.this.gWL == null || NewSubPbActivity.this.ibe == null || NewSubPbActivity.this.ibe.biZ() == null || NewSubPbActivity.this.gWL.aa(NewSubPbActivity.this.ibe.biZ().replyPrivateFlag, aj.cjR)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.goB.cxC());
            if (NewSubPbActivity.this.gWT.auM()) {
                NewSubPbActivity.this.gWT.a(NewSubPbActivity.this.hQF);
            }
            NewSubPbActivity.this.lp(true);
            return true;
        }
    };
    private NewWriteModel.d goI = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.y yVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.gWT != null && NewSubPbActivity.this.gWT.atZ() != null) {
                NewSubPbActivity.this.gWT.atZ().hide();
                if (NewSubPbActivity.this.ibe.bXB()) {
                    TiebaStatic.log(new an("c10367").bS("post_id", NewSubPbActivity.this.ibe.auu()));
                }
            }
            if (z) {
                NewSubPbActivity.this.goB.Fv(null);
                NewSubPbActivity.this.goB.aM(null);
                NewSubPbActivity.this.goB.rK(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.goB.aM(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.goB.Fv(postWriteCallBackData.getErrorString());
                if (!v.isEmpty(NewSubPbActivity.this.goB.cxy())) {
                    NewSubPbActivity.this.hQF = postWriteCallBackData;
                    if (NewSubPbActivity.this.gWT.auM()) {
                        NewSubPbActivity.this.gWT.a(NewSubPbActivity.this.hQF);
                    }
                    NewSubPbActivity.this.lp(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.gWL != null) {
                NewSubPbActivity.this.gWL.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.ibg.bXg();
        }
    };
    private CustomMessageListener hMU = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.ibq) {
                NewSubPbActivity.this.ibg.aVW();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hMs.showSuccessToast(NewSubPbActivity.this.hMr.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.hMr.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.pP(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bSG();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.hMr.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.hMs.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hMV = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.ibq) {
                NewSubPbActivity.this.ibg.aVW();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.hMs.showSuccessToast(NewSubPbActivity.this.hMr.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.hMr.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.hMs.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener hMW = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.ibq) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.ibg.aVW();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.jwI;
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
                    NewSubPbActivity.this.ibg.a(sparseArray, z);
                }
            }
        }
    };
    boolean hNg = false;
    private final b.a hNi = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.hMv != null && !TextUtils.isEmpty(NewSubPbActivity.this.hMw)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.hMx == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.hMw));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.hMw;
                        aVar.pkgId = NewSubPbActivity.this.hMx.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hMx.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.fXD == null) {
                            NewSubPbActivity.this.fXD = new au(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.fXD.g(NewSubPbActivity.this.hMw, NewSubPbActivity.this.hMv.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.hMv = null;
                NewSubPbActivity.this.hMw = null;
            }
        }
    };
    private CustomMessageListener gAF = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener fwJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    l lVar = (l) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.ibe.bXu() != null && NewSubPbActivity.this.ibe.bXu().bRi() != null && NewSubPbActivity.this.ibe.bXu().bRi().aiG() != null && currentAccount.equals(NewSubPbActivity.this.ibe.bXu().bRi().aiG().getUserId()) && NewSubPbActivity.this.ibe.bXu().bRi().aiG().getPendantData() != null) {
                        NewSubPbActivity.this.ibe.bXu().bRi().aiG().getPendantData().mU(lVar.ahf());
                        NewSubPbActivity.this.ibe.bXu().bRi().aiG().getPendantData().ba(lVar.atE());
                        NewSubPbActivity.this.ibg.a(NewSubPbActivity.this.ibe.bXu().bRi(), NewSubPbActivity.this.ibe.bXu().bDy(), NewSubPbActivity.this.ibe.bXu().afm(), NewSubPbActivity.this.ibe.bQL(), NewSubPbActivity.this.ibe.bXH() != null);
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
        if (this.cFB) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.hMr = getPageContext();
        this.ibp = true;
        this.goB = new com.baidu.tieba.write.b();
        this.goB.Bt(R.color.cp_cont_h_alpha85);
        this.goB.Bs(R.color.cp_cont_a);
        aNd();
        bWU();
        initData(bundle);
        initUI();
        bLM();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bWT();
        this.hMs = new com.baidu.tbadk.core.view.e();
        this.hMs.toastTime = 1000L;
        registerListener(this.hMW);
        registerListener(this.hMU);
        registerListener(this.hMV);
        this.ibq = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.ibq;
        userMuteAddAndDelCustomMessage.setTag(this.ibq);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.ibq;
        userMuteCheckCustomMessage.setTag(this.ibq);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.gWL = new aj(getPageContext());
        this.gWL.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
            @Override // com.baidu.tbadk.core.util.aj.a
            public void f(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.gWT.auR();
                }
            }
        });
        this.hLT = new com.baidu.tieba.pb.pb.report.a(this);
        this.hLT.s(getUniqueId());
        this.hLX = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    private void bWT() {
        if (this.ibg != null && this.ibe != null && this.ibe.bWW()) {
            this.ibs = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.ibg.aKR());
            this.ibs.bob();
            this.ibs.a(new a.InterfaceC0490a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
                private boolean fKs = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0490a
                public void bnX() {
                    NewSubPbActivity.this.ibg.kt(false);
                    this.fKs = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0490a
                public void bnY() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0490a
                public boolean bnZ() {
                    if (!this.fKs) {
                        return NewSubPbActivity.this.ibg.beD() != null && NewSubPbActivity.this.ibg.beD().getTop() == 0;
                    }
                    this.fKs = false;
                    return false;
                }
            });
            this.ibg.e(this.ibs);
            this.ibg.kt(true);
        }
    }

    public void initUI() {
        this.ibg = new b(this, this.ZX);
        this.ibg.a(this.ibe);
        setContentView(this.ibg.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.ibg.setOnScrollListener(this.ibi);
        this.ibg.b(this);
        this.ibg.setOnLinkImageClickListener(this.ibj);
        this.ibg.setOnImageClickListener(this.ibk);
        this.ibg.nT(true);
        this.ibg.setOnLongClickListener(this.mOnLongClickListener);
        this.ibg.e(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.40
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.ibe != null) {
                    NewSubPbActivity.this.ibe.loadData();
                }
            }
        });
        this.ibg.a(this.ibn);
        this.ibg.b(this.ibo);
        if (this.ibe != null && this.ibe.bWW() && !this.ibe.bXG()) {
            this.ibg.bXk().setVisibility(8);
        } else {
            this.ibg.bXk().setVisibility(0);
        }
        if (this.ibe != null && !this.ibe.bWW()) {
            this.ibg.setIsFromPb(false);
        }
    }

    private boolean ab(Bundle bundle) {
        if (bundle != null) {
            this.cFB = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.cFB = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.cFB;
    }

    public void initData(Bundle bundle) {
        this.ibe = new SubPbModel(getPageContext());
        this.ibe.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                NewSubPbActivity.this.ibg.p(postData);
                NewSubPbActivity.this.ibg.b((BdListView.e) null);
            }
        });
        this.ibf = new ForumManageModel(getPageContext());
        this.ibf.setLoadDataCallBack(this.ibm);
        this.fvn = new VoiceManager();
        this.fvn.onCreate(getPageContext());
        this.hLU = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hLU != null) {
            this.hLU.a(this.hNc);
        }
        if (bundle != null) {
            this.ibe.initWithBundle(bundle);
        } else {
            this.ibe.initWithIntent(getIntent());
        }
        this.ibe.a(this.ibl);
        if (this.ibe.bWW()) {
            this.ibe.loadData();
        } else {
            this.ibe.bXz();
        }
    }

    public void bWU() {
        this.ibl = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, k kVar) {
                if (NewSubPbActivity.this.ibg != null) {
                    NewSubPbActivity.this.ibg.bXg();
                }
                if (NewSubPbActivity.this.ibs != null && NewSubPbActivity.this.ibs.boc()) {
                    NewSubPbActivity.this.ibs.rk(R.color.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.aC(i, str);
                    return;
                }
                NewSubPbActivity.this.ibg.hideNoDataView();
                if (kVar != null) {
                    if (kVar.bRi() != null || NewSubPbActivity.this.ibe != null) {
                        kVar.bRi().a(NewSubPbActivity.this.ibe.bXF());
                    }
                    if (NewSubPbActivity.this.ibg != null) {
                        NewSubPbActivity.this.ibg.a(kVar, NewSubPbActivity.this.ibe.bQL(), NewSubPbActivity.this.ibe.bXH() != null);
                        if (NewSubPbActivity.this.ibp) {
                            NewSubPbActivity.this.bWV();
                            NewSubPbActivity.this.ibp = false;
                        }
                    }
                    if (NewSubPbActivity.this.gWT != null) {
                        NewSubPbActivity.this.gWT.a(kVar.biZ());
                    }
                    if (NewSubPbActivity.this.ibt == null) {
                        NewSubPbActivity.this.ibt = new com.baidu.tieba.pb.e();
                    }
                    NewSubPbActivity.this.ibt.setData(kVar);
                    NewSubPbActivity.this.ibt.setType(0);
                    NewSubPbActivity.this.gWL.a(NewSubPbActivity.this.ibe.bXK());
                }
            }
        };
        this.hNc = new a.InterfaceC0279a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0279a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.hLU != null) {
                        NewSubPbActivity.this.hLU.dO(z2);
                    }
                    MarkData afp = NewSubPbActivity.this.hLU.afp();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(afp);
                        if (NewSubPbActivity.this.hLU != null) {
                            if (afp != null) {
                                NewSubPbActivity.this.ibe.pe(true);
                                NewSubPbActivity.this.ibe.Bk(NewSubPbActivity.this.ibe.auu());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.ibg != null) {
                                NewSubPbActivity.this.ibg.pd(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.ibe.pe(false);
                        NewSubPbActivity.this.ibe.Bk(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.ibg != null) {
                            NewSubPbActivity.this.ibg.pd(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.ibn = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.ibe.bXu() != null && NewSubPbActivity.this.ibe.bXu().agI() != null && NewSubPbActivity.this.ibe.bXu().agI().aiG() != null) {
                    str = String.valueOf(NewSubPbActivity.this.ibe.bXu().agI().aiG().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.ibe.bXu().bRo().getId(), NewSubPbActivity.this.ibe.bXu().bRo().getName(), NewSubPbActivity.this.ibe.bXu().agI().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.ibo = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.ibf.cpe() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.g.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.g.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.g.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.ibe != null && NewSubPbActivity.this.ibe.bXu() != null && NewSubPbActivity.this.ibe.bXu().bRo() != null && NewSubPbActivity.this.ibe.bXu().agI() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.ibf.DU(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.ibf.a(NewSubPbActivity.this.ibe.bXu().bRo().getId(), NewSubPbActivity.this.ibe.bXu().bRo().getName(), NewSubPbActivity.this.ibe.bXu().agI().getId(), valueOf, i2, i, z);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.ibm = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.ibg.a(NewSubPbActivity.this.ibf.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.ibf.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.icp != 1002 || bVar.dRK) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.ibg.a(1, dVar.tf, dVar.jkX, true);
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

    public void aNd() {
        registerListener(this.fwJ);
        this.ZX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v63, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.ibg != null) {
                    if (view == NewSubPbActivity.this.ibg.bXq()) {
                        NewSubPbActivity.this.ibg.bVN();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ba.amQ().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.ibg.bon()) {
                        if (view != NewSubPbActivity.this.ibg.bXj()) {
                            if (view != NewSubPbActivity.this.ibg.bXi()) {
                                if (view == NewSubPbActivity.this.ibg.bXe()) {
                                    NewSubPbActivity.this.ibg.bVN();
                                    if (NewSubPbActivity.this.ibe.loadData()) {
                                        NewSubPbActivity.this.ibg.bXc();
                                    }
                                } else if (view == NewSubPbActivity.this.ibg.bXk() || view == NewSubPbActivity.this.ibg.bXl() || view == NewSubPbActivity.this.ibg.bXn()) {
                                    if (NewSubPbActivity.this.ibr) {
                                        NewSubPbActivity.this.ibr = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.ibe.bTA(), NewSubPbActivity.this.ibe.auu(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.ibe.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.ibe.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                } else if (NewSubPbActivity.this.ibg.bXo() == null || view != NewSubPbActivity.this.ibg.bXo().bUr()) {
                                    if (NewSubPbActivity.this.ibg.bXo() == null || view != NewSubPbActivity.this.ibg.bXo().bUu()) {
                                        if (NewSubPbActivity.this.ibg.bXo() == null || view != NewSubPbActivity.this.ibg.bXo().bUs()) {
                                            if (NewSubPbActivity.this.ibg.bXo() == null || view != NewSubPbActivity.this.ibg.bXo().bUt()) {
                                                if (NewSubPbActivity.this.ibg.bXo() == null || view != NewSubPbActivity.this.ibg.bXo().bUv()) {
                                                    if (view == NewSubPbActivity.this.ibg.bXh() || view == NewSubPbActivity.this.ibg.bXn()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.gWT.auU()) {
                                                                NewSubPbActivity.this.gWT.auV();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.gWT.pQ(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof j)) {
                                                        if (NewSubPbActivity.this.ibh == null || view != NewSubPbActivity.this.ibh.bUt()) {
                                                            if (NewSubPbActivity.this.ibh == null || view != NewSubPbActivity.this.ibh.bUr()) {
                                                                if (NewSubPbActivity.this.ibh == null || view != NewSubPbActivity.this.ibh.bUu()) {
                                                                    if (NewSubPbActivity.this.ibh == null || view != NewSubPbActivity.this.ibh.bUv()) {
                                                                        if (NewSubPbActivity.this.ibh == null || view != NewSubPbActivity.this.ibh.bUx()) {
                                                                            if (NewSubPbActivity.this.ibh == null || view != NewSubPbActivity.this.ibh.bUy()) {
                                                                                if (NewSubPbActivity.this.ibh != null && view == NewSubPbActivity.this.ibh.bUs()) {
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
                                                                                            NewSubPbActivity.this.ibg.cA(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.ibg.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.alR().getString("tail_link", "");
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
                                                                                        if (postData.getType() != PostData.jip && !TextUtils.isEmpty(postData.getBimg_url()) && i.agq().isShowImages()) {
                                                                                            NewSubPbActivity.this.Bh(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.hMv != null && !TextUtils.isEmpty(NewSubPbActivity.this.hMw)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.fXD == null) {
                                                                                        NewSubPbActivity.this.fXD = new au(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.fXD.g(NewSubPbActivity.this.hMw, NewSubPbActivity.this.hMv.getImageByte());
                                                                                    NewSubPbActivity.this.hMv = null;
                                                                                    NewSubPbActivity.this.hMw = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.hMv != null && !TextUtils.isEmpty(NewSubPbActivity.this.hMw)) {
                                                                            if (NewSubPbActivity.this.hMx == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.hMw));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.hMw;
                                                                                aVar.pkgId = NewSubPbActivity.this.hMx.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.hMx.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.hMv = null;
                                                                            NewSubPbActivity.this.hMw = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.gpk != null) {
                                                                        NewSubPbActivity.this.gpk.ec(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.gpk = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.ibg.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                        NewSubPbActivity.this.ibv = (j) view.getTag();
                                                        if (bc.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.ibr) {
                                                                NewSubPbActivity.this.ibr = false;
                                                                return;
                                                            } else if (NewSubPbActivity.this.gWL == null || NewSubPbActivity.this.ibe == null || NewSubPbActivity.this.ibe.biZ() == null || NewSubPbActivity.this.gWL.iq(NewSubPbActivity.this.ibe.biZ().replyPrivateFlag)) {
                                                                if (NewSubPbActivity.this.ibs != null) {
                                                                    NewSubPbActivity.this.ibs.boa();
                                                                }
                                                                SparseArray sparseArray4 = (SparseArray) view.getTag(R.id.tag_from);
                                                                if (sparseArray4 != null) {
                                                                    if (sparseArray4.get(R.id.tag_clip_board) instanceof PostData) {
                                                                        PostData postData2 = (PostData) sparseArray4.get(R.id.tag_clip_board);
                                                                        if (postData2 != null && postData2.aiG() != null) {
                                                                            MetaData aiG = postData2.aiG();
                                                                            NewSubPbActivity.this.gWT.setReplyId(aiG.getUserId());
                                                                            if (!(sparseArray4.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.tag_is_subpb)).booleanValue() : true)) {
                                                                                NewSubPbActivity.this.gWT.pR("");
                                                                            } else {
                                                                                NewSubPbActivity.this.gWT.pR(aiG.getName_show());
                                                                            }
                                                                        }
                                                                        NewSubPbActivity.this.ibg.bXa();
                                                                    }
                                                                    if (NewSubPbActivity.this.ibu) {
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
                                            NewSubPbActivity.this.ibg.bVN();
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
                                            NewSubPbActivity.this.ibg.bVN();
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
                                    NewSubPbActivity.this.ibg.bVN();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.ibg.a(((Integer) sparseArray7.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray7.get(R.id.tag_del_post_id), ((Integer) sparseArray7.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new an("c11739").O("obj_locate", 2));
                                    NewSubPbActivity.this.ibg.bVN();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.ibe.bXu() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.ibe.bXu().bRi());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.ibg.bWZ();
                                NewSubPbActivity.this.ibg.bXa();
                                if (NewSubPbActivity.this.gWT != null) {
                                    NewSubPbActivity.this.gWT.auX();
                                    if (NewSubPbActivity.this.ibs != null) {
                                        NewSubPbActivity.this.ibs.boa();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.ibg.bWZ();
                            NewSubPbActivity.this.ibg.bXa();
                            if (NewSubPbActivity.this.gWT != null) {
                                NewSubPbActivity.this.gWT.auW();
                                if (NewSubPbActivity.this.ibs != null) {
                                    NewSubPbActivity.this.ibs.boa();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.bSc();
                        if (NewSubPbActivity.this.ibe != null && NewSubPbActivity.this.ibe.bXu() != null && NewSubPbActivity.this.ibe.bXu().agI() != null && NewSubPbActivity.this.ibe.bXu().agI().aiG() != null) {
                            TiebaStatic.log(new an("c13402").bS("tid", NewSubPbActivity.this.ibe.bTA()).p("fid", NewSubPbActivity.this.ibe.bXu().agI().getFid()).O("obj_locate", 5).bS("uid", NewSubPbActivity.this.ibe.bXu().agI().aiG().getUserId()));
                        }
                    }
                }
            }
        };
        this.ibi = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.ibg.bVN();
                }
                NewSubPbActivity.this.gWT.auV();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.ibg.bXp();
            }
        };
        this.hNh = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.ibe.bXu() != null) {
                    postData = NewSubPbActivity.this.ibe.bXu().bRi();
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
                        NewSubPbActivity.this.hMv = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.hMw = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.hMv != null && !TextUtils.isEmpty(NewSubPbActivity.this.hMw)) {
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hMx = null;
                            } else {
                                NewSubPbActivity.this.hMx = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                NewSubPbActivity.this.ibg.a(NewSubPbActivity.this.hNi, NewSubPbActivity.this.hMv.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                NewSubPbActivity.this.gpk = (PostData) sparseArray2.get(R.id.tag_clip_board);
                                if (NewSubPbActivity.this.gpk != null && NewSubPbActivity.this.hLU != null) {
                                    if (NewSubPbActivity.this.hLU != null) {
                                        NewSubPbActivity.this.hLU.dO(NewSubPbActivity.this.ibe.bXA());
                                    }
                                    boolean z = NewSubPbActivity.this.hLU.afm() && NewSubPbActivity.this.gpk.getId() != null && NewSubPbActivity.this.gpk.getId().equals(NewSubPbActivity.this.ibe.bXC());
                                    if (NewSubPbActivity.this.ibh == null) {
                                        NewSubPbActivity.this.ibh = new y(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.ZX);
                                        NewSubPbActivity.this.ibg.cF(NewSubPbActivity.this.ibh.getView());
                                        NewSubPbActivity.this.ibh.ot(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.ibh.showDialog();
                                    boolean isLogin = NewSubPbActivity.this.isLogin() & NewSubPbActivity.this.oa(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false);
                                    boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                                    if (z) {
                                        NewSubPbActivity.this.ibh.bUr().setText(R.string.remove_mark);
                                    } else {
                                        NewSubPbActivity.this.ibh.bUr().setText(R.string.mark);
                                    }
                                    if (booleanValue) {
                                        NewSubPbActivity.this.ibh.bUr().setVisibility(8);
                                    } else {
                                        NewSubPbActivity.this.ibh.bUr().setVisibility(0);
                                    }
                                    if (NewSubPbActivity.this.cu(view)) {
                                        if (NewSubPbActivity.this.hMv != null && !NewSubPbActivity.this.hMv.isGif()) {
                                            sparseArray2.put(R.id.tag_richtext_image, true);
                                        } else {
                                            sparseArray2.put(R.id.tag_richtext_image, false);
                                        }
                                        sparseArray2.put(R.id.tag_richtext_emotion, true);
                                    } else {
                                        sparseArray2.put(R.id.tag_richtext_image, false);
                                        sparseArray2.put(R.id.tag_richtext_emotion, false);
                                    }
                                    NewSubPbActivity.this.ibh.a(sparseArray2, NewSubPbActivity.this.bQL(), isLogin);
                                }
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            NewSubPbActivity.this.hMv = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                NewSubPbActivity.this.hMw = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.hMx = null;
                            } else {
                                NewSubPbActivity.this.hMx = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.hMv = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.hMw = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.hMx = null;
                        } else {
                            NewSubPbActivity.this.hMx = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
        this.ibj = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void e(View view, String str) {
                NewSubPbActivity.this.s(null, str, "LINK_IMAGE");
            }
        };
        this.ibk = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                        k bXu = NewSubPbActivity.this.ibe.bXu();
                        TbRichText bb = NewSubPbActivity.this.bb(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bb != null && bb.azh() != null) {
                            tbRichTextData = bb.azh().get(NewSubPbActivity.this.hNf);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.azp().azB()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (bXu == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (bXu.bRo() != null) {
                                        str4 = bXu.bRo().getName();
                                        str5 = bXu.bRo().getId();
                                    }
                                    if (bXu.agI() != null) {
                                        str6 = bXu.agI().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.ibe.bXH() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.ibe.bXH();
                                    z6 = NewSubPbActivity.this.ibe.bXJ();
                                    arrayList2 = NewSubPbActivity.this.ibe.bXI();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.getItem(arrayList2, 0));
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                                return;
                            }
                            NewSubPbActivity.this.hNg = false;
                            String str7 = "";
                            TbRichText cor = bXu.bRi().cor();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(cor, bb, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (bXu == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (bXu.bRo() != null) {
                                    str8 = bXu.bRo().getName();
                                    str9 = bXu.bRo().getId();
                                }
                                if (bXu.agI() != null) {
                                    str10 = bXu.agI().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.ibe.bXH() != null) {
                                concurrentHashMap = NewSubPbActivity.this.ibe.bXH();
                                z4 = NewSubPbActivity.this.ibe.bXJ();
                                arrayList = NewSubPbActivity.this.ibe.bXI();
                                i2 = a2 + NewSubPbActivity.this.ibe.getOffset();
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
        TbRichTextImageInfo azp;
        if (tbRichText == tbRichText2) {
            this.hNg = true;
        }
        if (tbRichText != null && tbRichText.azh() != null) {
            int size = tbRichText.azh().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.azh().get(i6) != null && tbRichText.azh().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.azh().get(i6).azp().getWidth() * equipmentDensity;
                    int height = tbRichText.azh().get(i6).azp().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.azh().get(i6).azp().azB()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.azh().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (azp = tbRichTextData.azp()) != null) {
                            String azD = azp.azD();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = azD;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.hNg) {
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
        if (this.ibh != null) {
            this.ibh.ot(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo azp = tbRichTextData.azp();
        if (azp != null) {
            if (!StringUtils.isNull(azp.azA())) {
                return azp.azA();
            }
            if (azp.getHeight() * azp.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (azp.getHeight() * azp.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (azp.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * azp.getHeight())));
            } else {
                float width = azp.getWidth() / azp.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(azp.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bb(String str, int i) {
        if (this.ibe == null || this.ibe.bXu() == null || str == null || i < 0) {
            return null;
        }
        k bXu = this.ibe.bXu();
        TbRichText a2 = a(bXu.bRi(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bXu.bRi(), str, i);
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
        TbRichText cor = postData.cor();
        if (cor != null) {
            ArrayList<TbRichTextData> azh = cor.azh();
            int size = azh.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (azh.get(i3) != null && azh.get(i3).getType() == 8) {
                    i2++;
                    if (azh.get(i3).azp().azD().equals(str)) {
                        int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = azh.get(i3).azp().getWidth() * equipmentDensity;
                        int height = azh.get(i3).azp().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.hNf = i3;
                        return cor;
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
    public void bSc() {
        if (this.fyU == null) {
            this.fyU = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.fyU.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jW(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void o(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jX(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.gWL == null || NewSubPbActivity.this.ibe == null || NewSubPbActivity.this.ibe.biZ() == null || NewSubPbActivity.this.gWL.iq(NewSubPbActivity.this.ibe.biZ().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.gWT.auM()) {
                                NewSubPbActivity.this.gWT.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.ibg.bWZ();
                            NewSubPbActivity.this.ibg.bXa();
                            if (NewSubPbActivity.this.gWT != null) {
                                NewSubPbActivity.this.gWT.auY();
                                if (NewSubPbActivity.this.ibs != null) {
                                    NewSubPbActivity.this.ibs.boa();
                                }
                            }
                        }
                    }
                }
            });
        }
        if (this.ibe != null && this.ibe.bXu() != null && this.ibe.bXu().bRo() != null) {
            this.fyU.z(this.ibe.bXu().bRo().getId(), com.baidu.adp.lib.g.b.toLong(this.ibe.bTA(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oa(boolean z) {
        if (this.ibe == null) {
            return false;
        }
        return ((bQL() != 0) || this.ibe.bXu() == null || this.ibe.bXu().agI() == null || this.ibe.bXu().agI().aiG() == null || TextUtils.equals(this.ibe.bXu().agI().aiG().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Context context, String str, String str2) {
        long templateId = this.ibe.bXu().bRi().coy() != null ? this.ibe.bXu().bRi().coy().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ba.amQ().b(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.ibe.bXu().bRo().getId(), this.ibe.bXu().bRo().getName(), this.ibe.bXu().agI().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i, String str) {
        if (this.ibe.bXv()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.isNetOk()) {
            if (i == 4) {
                this.ibg.us(str + "(4)");
            } else {
                this.ibg.uc(R.string.no_data_text);
            }
        } else {
            this.ibg.uc(R.string.recommend_pb_no_net_text);
        }
    }

    private void bLM() {
        this.gWT = (g) new h().cw(getActivity());
        if (this.gWT != null) {
            this.gWT.a(getPageContext());
            this.gWT.b(this.ibe);
            this.gWT.b(this.goI);
            this.gWT.a(this.cGY);
            this.gWT.a(this.cGZ);
            this.gWT.atZ().fe(true);
            this.gWT.e(getPageContext());
        }
        if (this.ibg != null) {
            this.ibg.g(this.gWT);
        }
        if (this.gWT != null && this.ibe != null) {
            this.gWT.a(this.ibe.biZ());
            this.gWT.auV();
        }
        if (this.gWT != null) {
            this.gWT.auZ().setDefaultHint(bVc());
            this.gWT.auZ().setHint(bVc());
            this.goC = this.gWT.auZ().getInputView();
            this.goC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.goB != null) {
                        if (!NewSubPbActivity.this.goB.cxB()) {
                            NewSubPbActivity.this.lp(false);
                        }
                        NewSubPbActivity.this.goB.rL(false);
                    }
                }
            });
        }
    }

    public void bWV() {
        if (!TbadkCoreApplication.isLogin()) {
            this.gWT.auV();
        } else if (!StringUtils.isNull(this.ibe.bXD())) {
            if (this.ibg.bXd() && com.baidu.adp.lib.util.l.isNetOk()) {
                this.ibg.bhd();
            } else {
                this.ibg.bXg();
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
                    this.ibg.cA(view);
                }
            } else if (booleanValue2) {
                this.ibg.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.dismissPopupWindow(this.ibg.bXm(), getPageContext().getPageActivity());
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
            bVar.hY(R.string.operation);
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.ibq);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.ibq);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).akP();
        }
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.ibg.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.ibq;
        userMuteCheckCustomMessage.setTag(this.ibq);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.ibg.a(0, bVar.tf, bVar.jkX, z);
            if (bVar.tf) {
                if (bVar.feZ == 1) {
                    if (this.ibg.getListView() instanceof BdTypeListView) {
                        List<m> data = ((BdTypeListView) this.ibg.getListView()).getData();
                        if (!v.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.ibg.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.feZ == 2) {
                    this.ibe.Bj(bVar.mPostId);
                    this.ibg.a(this.ibe.bXu(), this.ibe.bQL(), this.ibe.bXH() != null);
                    if (this.ibe.bXE()) {
                        this.ibe.pf(false);
                        this.ibg.bXb();
                        this.ibe.loadData();
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
        this.hLT.Bf(str);
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.ibe.bXA() && postData.getId() != null && postData.getId().equals(this.ibe.bXC())) {
                z = true;
            }
            MarkData j = this.ibe.j(postData);
            if (j != null) {
                this.ibg.bVN();
                if (this.hLU != null) {
                    this.hLU.a(j);
                    if (!z) {
                        this.hLU.afo();
                    } else {
                        this.hLU.afn();
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
        if (bundle != null && this.ibe != null) {
            this.ibe.aa(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.gWT != null) {
            this.gWT.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.gWT.atZ().asC();
        this.gWT.auV();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gWT.b(writeData);
                this.gWT.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k jL = this.gWT.atZ().jL(6);
                if (jL != null && jL.cFe != null) {
                    jL.cFe.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gWT.auR();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fvn != null) {
            this.fvn.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.dqQ = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.adZ().aee();
        if (this.fvn != null) {
            this.fvn.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.gAF);
        this.ibg.bqp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.dqQ = false;
        super.onResume();
        bSK();
        if (this.fvn != null) {
            this.fvn.onResume(getPageContext());
        }
        registerListener(this.gAF);
        this.ibg.bqq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fvn != null) {
            this.fvn.onStop(getPageContext());
        }
        this.gWT.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.ibt));
        this.ibe.cancelLoadData();
        this.ibe.destory();
        this.ibf.cancelLoadData();
        if (this.fvn != null) {
            this.fvn.onDestory(getPageContext());
        }
        this.ibg.bVN();
        this.ibg.aGH();
        MessageManager.getInstance().unRegisterListener(this.hMU);
        MessageManager.getInstance().unRegisterListener(this.hMV);
        MessageManager.getInstance().unRegisterListener(this.hMW);
        MessageManager.getInstance().unRegisterListener(this.ibq);
        this.hMr = null;
        this.hMs = null;
        if (this.gWL != null) {
            this.gWL.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ibg.onChangeSkinType(i);
        if (this.ibs != null && this.ibs.boc()) {
            this.ibs.rk(R.color.cp_mask_b_alpha66);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.fvn;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bXh = this.ibg.bXh();
        if (bXh == null || (findViewWithTag = bXh.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean AY(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = ba.getParamPair(ba.getParamStr(str))) != null) {
            this.ibr = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return AY(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(ibd);
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
                    kVar.cEe = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
                }
            } else {
                ba.amQ().b(getPageContext(), new String[]{str});
            }
            this.ibr = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ai(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.ibr = true;
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
        if (this.ibg != null) {
            return this.ibg.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int azP() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> azR() {
        if (this.cXc == null) {
            this.cXc = TbRichTextView.q(getPageContext().getPageActivity(), 8);
        }
        return this.cXc;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> azS() {
        if (this.cUw == null) {
            this.cUw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bSO */
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
        return this.cUw;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> azQ() {
        if (this.cUv == null) {
            this.cUv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bSN */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.agq().isShowImages();
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
                        if (i.agq().isShowImages()) {
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
        return this.cUv;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> azT() {
        if (this.cXd == null) {
            this.cXd = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bSP */
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
        return this.cXd;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> azU() {
        if (this.cXe == null) {
            this.cXe = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bSR */
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
        return this.cXe;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> azV() {
        this.cXf = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bSQ */
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
        return this.cXf;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bRu() {
        return this.hLX;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bRv() {
        return (this.ibe == null || this.ibe.bXu() == null || this.ibe.bXu().agI() == null || this.ibe.bXu().agI().ajX()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bRw() {
        if (this.ibe == null || this.ibe.bXu() == null || this.ibe.bXu().agI() == null) {
            return null;
        }
        return this.ibe.bXu().agI().aiL();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bRx() {
        if (this.ibe == null) {
            return 0;
        }
        return this.ibe.bQL();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean AE(String str) {
        if (StringUtils.isNull(str) || this.ibe == null || this.ibe.bXu() == null || this.ibe.bXu().agI() == null || this.ibe.bXu().agI().aiG() == null) {
            return false;
        }
        return str.equals(this.ibe.bXu().agI().aiG().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.ibg.bXd() && com.baidu.adp.lib.util.l.isNetOk()) {
            this.ibe.loadData();
        } else {
            this.ibg.bXg();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.ibq);
        userMuteAddAndDelCustomMessage.setTag(this.ibq);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bh(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.alR().getString("bubble_link", "");
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
                return com.baidu.tbadk.o.e.awz().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.ibe != null) {
            if (this.ibe.bXu() != null && this.ibe.bXu().bRo() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.toLong(this.ibe.bXu().bRo().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.toLong(this.ibe.bTA(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.dqQ;
    }

    public boolean bWW() {
        if (this.ibe != null) {
            return this.ibe.bWW();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.ibg.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hMr.getPageActivity());
        if (aq.isEmpty(str)) {
            aVar.nn(this.hMr.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.nn(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.ibg.showLoadingDialog();
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
        aVar.b(this.hMr).akO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pP(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hMr.getPageActivity());
        aVar.nn(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hMr).akO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSG() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nn(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.hMr).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.hMr.getPageActivity(), 2, true, 4);
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
        aVar.b(this.hMr).akO();
    }

    public SubPbModel bWX() {
        return this.ibe;
    }

    public int bQL() {
        if (this.ibe != null) {
            return this.ibe.bQL();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.cFB) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.cFB) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void lp(boolean z) {
        if (this.goC != null && this.goC.getText() != null) {
            int selectionEnd = this.goC.getSelectionEnd();
            SpannableStringBuilder a2 = this.goB.a(this.goC.getText());
            if (a2 != null) {
                this.goB.rL(true);
                this.goC.setText(a2);
                if (z && this.goB.cxz() >= 0) {
                    this.goC.requestFocus();
                    this.goC.setSelection(this.goB.cxz());
                } else {
                    this.goC.setSelection(selectionEnd);
                }
                this.goB.rK(this.goB.cxz() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gWT != null && this.gWT.atZ() != null && this.gWT.atZ().aub()) {
            this.gWT.atZ().asC();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.d.a(pVar, getUniqueId(), this);
    }

    public String bVc() {
        if (!aq.isEmpty(this.hXo)) {
            return this.hXo;
        }
        this.hXo = getResources().getString(ap.bUU());
        return this.hXo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.ibu = z;
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
        if (this.ibg != null && this.ibg.getListView() != null && this.ibv != null && this.ibv.mPosition != -1) {
            final int headerViewsCount = this.ibv.mPosition + this.ibg.getListView().getHeaderViewsCount();
            if (this.ibv.getView() != null) {
                final int height = this.ibv.getView().getHeight() - ((rect.height() - this.ibg.getNavigationBarHeight()) - this.ibg.bXr());
                if (height > 0) {
                    this.ibg.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.ibg != null && NewSubPbActivity.this.ibg.getListView() != null) {
                                NewSubPbActivity.this.ibg.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.ibg.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.ibg.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.ibg != null && NewSubPbActivity.this.ibg.getListView() != null) {
                                NewSubPbActivity.this.ibg.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.ibg.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }

    private void bSK() {
        if (this.ibe != null && !aq.isEmpty(this.ibe.bTA())) {
            com.baidu.tbadk.BdToken.c.adZ().k(com.baidu.tbadk.BdToken.b.bQR, com.baidu.adp.lib.g.b.toLong(this.ibe.bTA(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.ibe == null || aq.isEmpty(this.ibe.bTA())) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.toLong(this.ibe.bTA(), 0L);
    }
}
