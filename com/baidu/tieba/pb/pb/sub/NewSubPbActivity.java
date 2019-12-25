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
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.y;
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
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.f;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.au;
import com.baidu.tieba.pb.pb.main.l;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.z;
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
/* loaded from: classes6.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, h, com.baidu.tieba.pb.pb.a<NewSubPbActivity> {
    private static String iPy = "tbgametype";
    private View.OnClickListener ahD;
    private com.baidu.adp.lib.d.b<ImageView> dHY;
    private com.baidu.adp.lib.d.b<GifView> dHZ;
    private com.baidu.adp.lib.d.b<TextView> dKO;
    private com.baidu.adp.lib.d.b<View> dKP;
    private com.baidu.adp.lib.d.b<LinearLayout> dKQ;
    private com.baidu.adp.lib.d.b<RelativeLayout> dKR;
    private au gLl;
    private VoiceManager giZ;
    private com.baidu.tieba.frs.profession.permission.c gmA;
    public aj hJV;
    private com.baidu.tbadk.editortools.pb.h hKe;
    private com.baidu.tieba.write.c hbl;
    private EditText hbm;
    private e iCM;
    private com.baidu.tbadk.core.view.d iCN;
    private com.baidu.adp.widget.ImageView.a iCQ;
    private String iCR;
    private TbRichTextMemeInfo iCS;
    private com.baidu.tieba.pb.pb.report.a iCq;
    private com.baidu.tbadk.baseEditMark.a iCr;
    private PostWriteCallBackData iEv;
    private String iKs;
    private ForumManageModel iPA;
    private com.baidu.tieba.pb.pb.sub.a iPB;
    private z iPC;
    private AbsListView.OnScrollListener iPD;
    private TbRichTextView.i iPE;
    private SubPbModel.a iPF;
    private com.baidu.adp.base.d iPG;
    private BdUniqueId iPK;
    private f<m> iPM;
    private boolean iPN;
    private l iPO;
    private SubPbModel iPz;
    private com.baidu.tieba.pb.pb.main.b.a iyV;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int iDy = 0;
    PostData hbU = null;
    private a.InterfaceC0362a iDv = null;
    private a iPH = null;
    private a iPI = null;
    private boolean eag = false;
    private boolean iPJ = false;
    private boolean iPL = false;
    private boolean dsE = false;
    private com.baidu.tbadk.editortools.pb.c dub = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aMa() {
            NewSubPbActivity.this.iPB.coW();
        }
    };
    private int iyh = 0;
    private boolean aVH = false;
    private com.baidu.tbadk.editortools.pb.b duc = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aLZ() {
            if (!NewSubPbActivity.this.hbl.cRJ()) {
                return (NewSubPbActivity.this.hJV == null || NewSubPbActivity.this.iPz == null || NewSubPbActivity.this.iPz.bAs() == null || NewSubPbActivity.this.hJV.at(NewSubPbActivity.this.iPz.bAs().replyPrivateFlag, aj.cVK)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.hbl.cRL());
            if (NewSubPbActivity.this.hKe.aMq()) {
                NewSubPbActivity.this.hKe.a(NewSubPbActivity.this.iEv);
            }
            NewSubPbActivity.this.mC(true);
            return true;
        }
    };
    private NewWriteModel.d hbs = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.hKe != null && NewSubPbActivity.this.hKe.aLC() != null) {
                NewSubPbActivity.this.hKe.aLC().hide();
                if (NewSubPbActivity.this.iPz.cpu()) {
                    TiebaStatic.log(new an("c10367").cp("post_id", NewSubPbActivity.this.iPz.aLX()));
                }
            }
            if (z) {
                NewSubPbActivity.this.hbl.Kn(null);
                NewSubPbActivity.this.hbl.aV(null);
                NewSubPbActivity.this.hbl.tq(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.hbl.aV(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.hbl.Kn(postWriteCallBackData.getErrorString());
                if (!v.isEmpty(NewSubPbActivity.this.hbl.cRH())) {
                    NewSubPbActivity.this.iEv = postWriteCallBackData;
                    if (NewSubPbActivity.this.hKe.aMq()) {
                        NewSubPbActivity.this.hKe.a(NewSubPbActivity.this.iEv);
                    }
                    NewSubPbActivity.this.mC(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.hJV != null) {
                NewSubPbActivity.this.hJV.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.iPB.coX();
        }
    };
    private CustomMessageListener iDn = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iPK) {
                NewSubPbActivity.this.iPB.bnJ();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.iCN.showSuccessToast(NewSubPbActivity.this.iCM.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.iCM.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.uU(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.ckx();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.iCM.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.iCN.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener iDo = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iPK) {
                NewSubPbActivity.this.iPB.bnJ();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.iCN.showSuccessToast(NewSubPbActivity.this.iCM.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.iCM.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.iCN.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener iDp = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iPK) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.iPB.bnJ();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.kpZ;
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
                    NewSubPbActivity.this.iPB.a(sparseArray, z);
                }
            }
        }
    };
    boolean iDz = false;
    private final b.a iDB = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.iCQ != null && !TextUtils.isEmpty(NewSubPbActivity.this.iCR)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.iCS == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.iCR));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.iCR;
                        aVar.pkgId = NewSubPbActivity.this.iCS.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.iCS.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.gLl == null) {
                            NewSubPbActivity.this.gLl = new au(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.gLl.j(NewSubPbActivity.this.iCR, NewSubPbActivity.this.iCQ.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.iCQ = null;
                NewSubPbActivity.this.iCR = null;
            }
        }
    };
    private CustomMessageListener hnU = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener gko = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    com.baidu.tbadk.data.m mVar = (com.baidu.tbadk.data.m) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.iPz.cpn() != null && NewSubPbActivity.this.iPz.cpn().cix() != null && NewSubPbActivity.this.iPz.cpn().cix().azE() != null && currentAccount.equals(NewSubPbActivity.this.iPz.cpn().cix().azE().getUserId()) && NewSubPbActivity.this.iPz.cpn().cix().azE().getPendantData() != null) {
                        NewSubPbActivity.this.iPz.cpn().cix().azE().getPendantData().sh(mVar.axX());
                        NewSubPbActivity.this.iPz.cpn().cix().azE().getPendantData().bB(mVar.aLh());
                        NewSubPbActivity.this.iPB.a(NewSubPbActivity.this.iPz.cpn(), NewSubPbActivity.this.iPz.cpn().cix(), NewSubPbActivity.this.iPz.cpn().bUI(), NewSubPbActivity.this.iPz.cpn().awd(), NewSubPbActivity.this.iPz.chW(), NewSubPbActivity.this.iPz.cpA() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void callback(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        av(bundle);
        if (getIntent() != null) {
            this.aVH = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_FROM_SCHEMA, false);
        }
        if (this.dsE && !this.aVH) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.iCM = getPageContext();
        this.iPJ = true;
        this.hbl = new com.baidu.tieba.write.c();
        this.hbl.DP(R.color.cp_cont_h_alpha85);
        this.hbl.DO(R.color.cp_cont_a);
        initListeners();
        coM();
        initData(bundle);
        initUI();
        nV(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.iPB.qw(this.aVH);
        this.iCN = new com.baidu.tbadk.core.view.d();
        this.iCN.toastTime = 1000L;
        registerListener(this.iDp);
        registerListener(this.iDn);
        registerListener(this.iDo);
        this.iPK = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.iPK;
        userMuteAddAndDelCustomMessage.setTag(this.iPK);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.iPK;
        userMuteCheckCustomMessage.setTag(this.iPK);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.hJV = new aj(getPageContext());
        this.hJV.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tbadk.core.util.aj.a
            public void j(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.hKe.aMx();
                }
            }
        });
        this.iCq = new com.baidu.tieba.pb.pb.report.a(this);
        this.iCq.t(getUniqueId());
        this.iyV = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.iPB = new com.baidu.tieba.pb.pb.sub.a(this, this.ahD);
        this.iPB.a(this.iPz);
        setContentView(this.iPB.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.iPB.setOnScrollListener(this.iPD);
        this.iPB.b(this);
        this.iPB.setOnImageClickListener(this.iPE);
        this.iPB.setOnLongClickListener(this.mOnLongClickListener);
        this.iPB.g(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.iPz != null) {
                    NewSubPbActivity.this.iPz.loadData();
                }
            }
        });
        this.iPB.a(this.iPH);
        this.iPB.b(this.iPI);
        if (this.iPz != null && this.iPz.coO() && !this.iPz.cpz()) {
            this.iPB.cpc().setVisibility(8);
        } else {
            this.iPB.cpc().setVisibility(0);
        }
        if (this.iPz != null && !this.iPz.coO()) {
            this.iPB.setIsFromPb(false);
        }
    }

    private boolean av(Bundle bundle) {
        if (bundle != null) {
            this.dsE = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.dsE = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.dsE;
    }

    public void initData(Bundle bundle) {
        this.iPz = new SubPbModel(getPageContext());
        this.iPz.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void q(PostData postData) {
                NewSubPbActivity.this.iPB.s(postData);
                NewSubPbActivity.this.iPB.b((BdListView.e) null);
            }
        });
        this.iPA = new ForumManageModel(getPageContext());
        this.iPA.setLoadDataCallBack(this.iPG);
        this.giZ = new VoiceManager();
        this.giZ.onCreate(getPageContext());
        this.iCr = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.iCr != null) {
            this.iCr.a(this.iDv);
        }
        if (bundle != null) {
            this.iPz.initWithBundle(bundle);
        } else {
            this.iPz.initWithIntent(getIntent());
        }
        this.iPz.a(this.iPF);
        if (this.iPz.coO()) {
            this.iPz.loadData();
        } else {
            this.iPz.cps();
        }
    }

    public void coM() {
        this.iPF = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, m mVar) {
                if (NewSubPbActivity.this.iPB != null) {
                    NewSubPbActivity.this.iPB.coX();
                }
                if (!z) {
                    NewSubPbActivity.this.aR(i, str);
                    return;
                }
                NewSubPbActivity.this.iPB.hideNoDataView();
                if (mVar != null) {
                    if (mVar.cix() != null || NewSubPbActivity.this.iPz != null) {
                        mVar.cix().a(NewSubPbActivity.this.iPz.cpy());
                    }
                    if (NewSubPbActivity.this.iPB != null) {
                        NewSubPbActivity.this.nV(mVar.axx() != null && mVar.axx().isBjh());
                        if (NewSubPbActivity.this.hKe != null && NewSubPbActivity.this.hKe.aLC() != null) {
                            NewSubPbActivity.this.hKe.aLC().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                        }
                        NewSubPbActivity.this.iPB.a(mVar, NewSubPbActivity.this.iPz.chW(), NewSubPbActivity.this.iPz.cpA() != null);
                        if (NewSubPbActivity.this.iPJ) {
                            NewSubPbActivity.this.coN();
                            NewSubPbActivity.this.iPJ = false;
                        }
                    }
                    if (NewSubPbActivity.this.hKe != null) {
                        NewSubPbActivity.this.hKe.a(mVar.bAs());
                        NewSubPbActivity.this.hKe.setThreadData(mVar.axx());
                    }
                    if (NewSubPbActivity.this.iPM == null) {
                        NewSubPbActivity.this.iPM = new com.baidu.tieba.pb.f();
                    }
                    NewSubPbActivity.this.iPM.setData(mVar);
                    NewSubPbActivity.this.iPM.setType(0);
                    NewSubPbActivity.this.hJV.a(NewSubPbActivity.this.iPz.cpD());
                }
            }
        };
        this.iDv = new a.InterfaceC0362a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0362a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.iCr != null) {
                        NewSubPbActivity.this.iCr.fa(z2);
                    }
                    MarkData awg = NewSubPbActivity.this.iCr.awg();
                    com.baidu.tieba.pb.f fVar = new com.baidu.tieba.pb.f();
                    fVar.setType(2);
                    if (z2) {
                        fVar.setData(awg);
                        if (NewSubPbActivity.this.iCr != null) {
                            if (awg != null) {
                                NewSubPbActivity.this.iPz.qy(true);
                                NewSubPbActivity.this.iPz.FU(NewSubPbActivity.this.iPz.aLX());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.iPB != null) {
                                NewSubPbActivity.this.iPB.qx(true);
                            }
                        }
                    } else {
                        fVar.setData(null);
                        NewSubPbActivity.this.iPz.qy(false);
                        NewSubPbActivity.this.iPz.FU(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.iPB != null) {
                            NewSubPbActivity.this.iPB.qx(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, fVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.iPH = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.iPz.cpn() != null && NewSubPbActivity.this.iPz.cpn().axx() != null && NewSubPbActivity.this.iPz.cpn().axx().azE() != null) {
                    str = String.valueOf(NewSubPbActivity.this.iPz.cpn().axx().azE().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.iPz.cpn().aMv().getId(), NewSubPbActivity.this.iPz.cpn().aMv().getName(), NewSubPbActivity.this.iPz.cpn().axx().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.iPI = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.iPA.cJi() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.iPz != null && NewSubPbActivity.this.iPz.cpn() != null && NewSubPbActivity.this.iPz.cpn().aMv() != null && NewSubPbActivity.this.iPz.cpn().axx() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.iPA.IJ(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.iPA.a(NewSubPbActivity.this.iPz.cpn().aMv().getId(), NewSubPbActivity.this.iPz.cpn().aMv().getName(), NewSubPbActivity.this.iPz.cpn().axx().getId(), valueOf, i2, i, z, NewSubPbActivity.this.iPz.cpn().axx().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.iPG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.iPB.a(NewSubPbActivity.this.iPA.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.iPA.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.iQH != 1002 || bVar.eGA) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.iPB.a(1, dVar.mSuccess, dVar.kew, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean cr(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void initListeners() {
        registerListener(this.gko);
        this.ahD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v65, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray sparseArray;
                if (view != null || NewSubPbActivity.this.iPB != null) {
                    if (view == NewSubPbActivity.this.iPB.cpi()) {
                        NewSubPbActivity.this.iPB.cny();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ba.aEa().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.iPB.bFI()) {
                        if (view != NewSubPbActivity.this.iPB.cpb()) {
                            if (view != NewSubPbActivity.this.iPB.cpa()) {
                                if (view == NewSubPbActivity.this.iPB.coV()) {
                                    NewSubPbActivity.this.iPB.cny();
                                    if (NewSubPbActivity.this.iPz.loadData()) {
                                        NewSubPbActivity.this.iPB.coT();
                                    }
                                } else if (view == NewSubPbActivity.this.iPB.cpc() || view == NewSubPbActivity.this.iPB.cpd() || view == NewSubPbActivity.this.iPB.cpf()) {
                                    if (NewSubPbActivity.this.iPL) {
                                        NewSubPbActivity.this.iPL = false;
                                        return;
                                    }
                                    if ((NewSubPbActivity.this.iPz.cpn() == null || NewSubPbActivity.this.iPz.cpn().axx() == null) ? false : com.baidu.tbadk.core.util.au.a(NewSubPbActivity.this.iPz.cpn().axx().getBaijiahaoData())) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.iPz.ckU(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.iPz.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.iPz.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.iPz.cpn() != null && NewSubPbActivity.this.iPz.cpn().axx() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.iPz.cpn().axx().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.iPz.ckU(), NewSubPbActivity.this.iPz.aLX(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.iPz.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.iPz.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.iPB.cpg() == null || view != NewSubPbActivity.this.iPB.cpg().clV()) {
                                    if (NewSubPbActivity.this.iPB.cpg() == null || view != NewSubPbActivity.this.iPB.cpg().clY()) {
                                        if (NewSubPbActivity.this.iPB.cpg() == null || view != NewSubPbActivity.this.iPB.cpg().clW()) {
                                            if (NewSubPbActivity.this.iPB.cpg() == null || view != NewSubPbActivity.this.iPB.cpg().clX()) {
                                                if (NewSubPbActivity.this.iPB.cpg() == null || view != NewSubPbActivity.this.iPB.cpg().clZ()) {
                                                    if (view == NewSubPbActivity.this.iPB.coZ() || view == NewSubPbActivity.this.iPB.cpf()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.hKe.aMA()) {
                                                                NewSubPbActivity.this.hKe.aMB();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.hKe.uV(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof l)) {
                                                        if (NewSubPbActivity.this.iPC == null || view != NewSubPbActivity.this.iPC.clX()) {
                                                            if (NewSubPbActivity.this.iPC == null || view != NewSubPbActivity.this.iPC.clV()) {
                                                                if (NewSubPbActivity.this.iPC == null || view != NewSubPbActivity.this.iPC.clY()) {
                                                                    if (NewSubPbActivity.this.iPC == null || view != NewSubPbActivity.this.iPC.clZ()) {
                                                                        if (NewSubPbActivity.this.iPC == null || view != NewSubPbActivity.this.iPC.cmb()) {
                                                                            if (NewSubPbActivity.this.iPC == null || view != NewSubPbActivity.this.iPC.cmc()) {
                                                                                if (NewSubPbActivity.this.iPC != null && view == NewSubPbActivity.this.iPC.clW()) {
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
                                                                                            NewSubPbActivity.this.iPB.cw(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.iPB.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.aCY().getString("tail_link", "");
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
                                                                                        if (postData.getType() != PostData.kbK && !TextUtils.isEmpty(postData.getBimg_url()) && i.axf().isShowImages()) {
                                                                                            NewSubPbActivity.this.FR(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.iCQ != null && !TextUtils.isEmpty(NewSubPbActivity.this.iCR)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.gLl == null) {
                                                                                        NewSubPbActivity.this.gLl = new au(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.gLl.j(NewSubPbActivity.this.iCR, NewSubPbActivity.this.iCQ.getImageByte());
                                                                                    NewSubPbActivity.this.iCQ = null;
                                                                                    NewSubPbActivity.this.iCR = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.iCQ != null && !TextUtils.isEmpty(NewSubPbActivity.this.iCR)) {
                                                                            if (NewSubPbActivity.this.iCS == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.iCR));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.iCR;
                                                                                aVar.pkgId = NewSubPbActivity.this.iCS.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.iCS.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.iCQ = null;
                                                                            NewSubPbActivity.this.iCR = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.hbU != null) {
                                                                        NewSubPbActivity.this.hbU.fu(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.hbU = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.iPB.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.cq(view);
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
                                                                NewSubPbActivity.this.Fq((String) tag);
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
                                                        NewSubPbActivity.this.iPO = (l) view.getTag();
                                                        if (bc.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.iPL) {
                                                                NewSubPbActivity.this.iPL = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.hJV == null || NewSubPbActivity.this.iPz == null || NewSubPbActivity.this.iPz.bAs() == null || NewSubPbActivity.this.hJV.kb(NewSubPbActivity.this.iPz.bAs().replyPrivateFlag)) && (sparseArray = (SparseArray) view.getTag(R.id.tag_from)) != null) {
                                                                if (sparseArray.get(R.id.tag_clip_board) instanceof PostData) {
                                                                    PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                    if (postData2 != null && postData2.azE() != null) {
                                                                        MetaData azE = postData2.azE();
                                                                        NewSubPbActivity.this.hKe.setReplyId(azE.getUserId());
                                                                        if (!(sparseArray.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue() : true)) {
                                                                            NewSubPbActivity.this.hKe.uW("");
                                                                        } else {
                                                                            NewSubPbActivity.this.hKe.uW(azE.getName_show());
                                                                        }
                                                                    }
                                                                    NewSubPbActivity.this.iPB.coR();
                                                                }
                                                                if (NewSubPbActivity.this.iPN) {
                                                                    NewSubPbActivity.this.qv(false);
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
                                                        ((PostData) sparseArray5.get(R.id.tag_clip_board)).fu(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new an("c11739").Z("obj_locate", 4));
                                            if (!j.isNetWorkAvailable()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.iPB.cny();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.Fq(str4);
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
                                            NewSubPbActivity.this.iPB.cny();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.cz(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.iPB.cny();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.iPB.a(((Integer) sparseArray7.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray7.get(R.id.tag_del_post_id), ((Integer) sparseArray7.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new an("c11739").Z("obj_locate", 2));
                                    NewSubPbActivity.this.iPB.cny();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.iPz.cpn() != null) {
                                        NewSubPbActivity.this.k(NewSubPbActivity.this.iPz.cpn().cix());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.iPB.coQ();
                                NewSubPbActivity.this.iPB.coR();
                                if (NewSubPbActivity.this.hKe != null) {
                                    NewSubPbActivity.this.hKe.aMD();
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.iPB.coQ();
                            NewSubPbActivity.this.iPB.coR();
                            if (NewSubPbActivity.this.hKe != null) {
                                NewSubPbActivity.this.hKe.aMC();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.cjU();
                        if (NewSubPbActivity.this.iPz != null && NewSubPbActivity.this.iPz.cpn() != null && NewSubPbActivity.this.iPz.cpn().axx() != null && NewSubPbActivity.this.iPz.cpn().axx().azE() != null) {
                            TiebaStatic.log(new an("c13402").cp("tid", NewSubPbActivity.this.iPz.ckU()).s("fid", NewSubPbActivity.this.iPz.cpn().axx().getFid()).Z("obj_locate", 5).cp("uid", NewSubPbActivity.this.iPz.cpn().axx().azE().getUserId()));
                        }
                    }
                }
            }
        };
        this.iPD = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.iPB.cny();
                    if (NewSubPbActivity.this.iyh != 2 && NewSubPbActivity.this.iyh != 1) {
                        NewSubPbActivity.this.iPB.cpk();
                    }
                }
                NewSubPbActivity.this.hKe.aMB();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.iPB.cph();
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
                if (NewSubPbActivity.this.iPB != null && NewSubPbActivity.this.iPB.coY()) {
                    return false;
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null && NewSubPbActivity.this.cr(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.iCQ = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.iCR = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.iCQ == null || TextUtils.isEmpty(NewSubPbActivity.this.iCR)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.iCS = null;
                        } else {
                            NewSubPbActivity.this.iCS = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.iCQ = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.iCR = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.iCS = null;
                        } else {
                            NewSubPbActivity.this.iCS = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.iCQ = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.iCR = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.iCS = null;
                        } else {
                            NewSubPbActivity.this.iCS = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.iPB.a(NewSubPbActivity.this.iDB, NewSubPbActivity.this.iCQ.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.hbU = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.hbU == null || NewSubPbActivity.this.iCr == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.iCr != null) {
                            NewSubPbActivity.this.iCr.fa(NewSubPbActivity.this.iPz.cpt());
                        }
                        boolean z = NewSubPbActivity.this.iCr.awd() && NewSubPbActivity.this.hbU.getId() != null && NewSubPbActivity.this.hbU.getId().equals(NewSubPbActivity.this.iPz.cpv());
                        if (NewSubPbActivity.this.iPC == null) {
                            NewSubPbActivity.this.iPC = new z(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.ahD);
                            NewSubPbActivity.this.iPB.cA(NewSubPbActivity.this.iPC.getView());
                            NewSubPbActivity.this.iPC.pJ(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.iPC.showDialog();
                        boolean z2 = NewSubPbActivity.this.pw(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z3 = (NewSubPbActivity.this.iPz.cpn() == null || NewSubPbActivity.this.iPz.cpn().axx() == null || !NewSubPbActivity.this.iPz.cpn().axx().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z) {
                            NewSubPbActivity.this.iPC.clV().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.iPC.clV().setText(R.string.mark);
                        }
                        if (booleanValue || z3) {
                            NewSubPbActivity.this.iPC.clV().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.iPC.clV().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.cr(view)) {
                            if (NewSubPbActivity.this.iCQ != null && !NewSubPbActivity.this.iCQ.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        NewSubPbActivity.this.iPC.a(sparseArray2, NewSubPbActivity.this.chW(), z2);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.iPE = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                        m cpn = NewSubPbActivity.this.iPz.cpn();
                        TbRichText bk = NewSubPbActivity.this.bk(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bk != null && bk.aRf() != null) {
                            tbRichTextData = bk.aRf().get(NewSubPbActivity.this.iDy);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.aRl().aRx()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (cpn == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (cpn.aMv() != null) {
                                        str4 = cpn.aMv().getName();
                                        str5 = cpn.aMv().getId();
                                    }
                                    if (cpn.axx() != null) {
                                        str6 = cpn.axx().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.iPz.cpA() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.iPz.cpA();
                                    z6 = NewSubPbActivity.this.iPz.cpC();
                                    arrayList2 = NewSubPbActivity.this.iPz.cpB();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.getItem(arrayList2, 0));
                                ImageViewerConfig createConfig = new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false);
                                createConfig.setPostId(String.valueOf(bk.getPostId()));
                                createConfig.setThreadData(NewSubPbActivity.this.axx());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                                return;
                            }
                            NewSubPbActivity.this.iDz = false;
                            String str7 = "";
                            TbRichText cIv = cpn.cix().cIv();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(cIv, bk, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (cpn == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (cpn.aMv() != null) {
                                    str8 = cpn.aMv().getName();
                                    str9 = cpn.aMv().getId();
                                }
                                if (cpn.axx() != null) {
                                    str10 = cpn.axx().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.iPz.cpA() != null) {
                                concurrentHashMap = NewSubPbActivity.this.iPz.cpA();
                                z4 = NewSubPbActivity.this.iPz.cpC();
                                arrayList = NewSubPbActivity.this.iPz.cpB();
                                i2 = a2 + NewSubPbActivity.this.iPz.getOffset();
                            } else {
                                concurrentHashMap = concurrentHashMap3;
                                i2 = a2;
                                z4 = z3;
                                arrayList = arrayList2;
                            }
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(v.getItem(arrayList, i2));
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList4, 0, str8, str9, str2, z4, str7, true, concurrentHashMap, true, false, false);
                            createConfig2.setThreadData(NewSubPbActivity.this.axx());
                            createConfig2.setPostId(String.valueOf(bk.getPostId()));
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
    public bj axx() {
        if (this.iPz == null || this.iPz.cpn() == null) {
            return null;
        }
        return this.iPz.cpn().axx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(View view) {
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
        TbRichTextImageInfo aRl;
        if (tbRichText == tbRichText2) {
            this.iDz = true;
        }
        if (tbRichText != null && tbRichText.aRf() != null) {
            int size = tbRichText.aRf().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.aRf().get(i6) != null && tbRichText.aRf().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.aRf().get(i6).aRl().getWidth() * equipmentDensity;
                    int height = tbRichText.aRf().get(i6).aRl().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.aRf().get(i6).aRl().aRx()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.aRf().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (aRl = tbRichTextData.aRl()) != null) {
                            String aRz = aRl.aRz();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = aRz;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.iDz) {
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
        if (this.iPC != null) {
            this.iPC.pJ(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo aRl = tbRichTextData.aRl();
        if (aRl != null) {
            if (!StringUtils.isNull(aRl.aRw())) {
                return aRl.aRw();
            }
            if (aRl.getHeight() * aRl.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (aRl.getHeight() * aRl.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (aRl.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * aRl.getHeight())));
            } else {
                float width = aRl.getWidth() / aRl.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(aRl.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bk(String str, int i) {
        if (this.iPz == null || this.iPz.cpn() == null || str == null || i < 0) {
            return null;
        }
        m cpn = this.iPz.cpn();
        TbRichText a2 = a(cpn.cix(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(cpn.cix(), str, i);
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
        TbRichText cIv = postData.cIv();
        if (cIv != null) {
            ArrayList<TbRichTextData> aRf = cIv.aRf();
            int size = aRf.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (aRf.get(i3) != null && aRf.get(i3).getType() == 8) {
                    i2++;
                    if (aRf.get(i3).aRl().aRz().equals(str)) {
                        int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = aRf.get(i3).aRl().getWidth() * equipmentDensity;
                        int height = aRf.get(i3).aRl().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.iDy = i3;
                        return cIv;
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
    public void cjU() {
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false) {
            if (this.hJV == null || this.iPz == null || this.iPz.bAs() == null || this.hJV.kb(this.iPz.bAs().replyPrivateFlag)) {
                if (this.hKe.aMq()) {
                    this.hKe.a((PostWriteCallBackData) null);
                    return;
                }
                this.iPB.coQ();
                this.iPB.coR();
                if (this.hKe != null) {
                    this.hKe.aME();
                    return;
                }
                return;
            }
            return;
        }
        if (this.gmA == null) {
            this.gmA = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.gmA.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void li(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void r(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lj(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.hJV == null || NewSubPbActivity.this.iPz == null || NewSubPbActivity.this.iPz.bAs() == null || NewSubPbActivity.this.hJV.kb(NewSubPbActivity.this.iPz.bAs().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.hKe.aMq()) {
                                NewSubPbActivity.this.hKe.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.iPB.coQ();
                            NewSubPbActivity.this.iPB.coR();
                            if (NewSubPbActivity.this.hKe != null) {
                                NewSubPbActivity.this.hKe.aME();
                            }
                        }
                    }
                }
            });
        }
        if (this.iPz != null && this.iPz.cpn() != null && this.iPz.cpn().aMv() != null) {
            this.gmA.B(this.iPz.cpn().aMv().getId(), com.baidu.adp.lib.f.b.toLong(this.iPz.ckU(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pw(boolean z) {
        if (this.iPz == null) {
            return false;
        }
        return ((chW() != 0) || this.iPz.cpn() == null || this.iPz.cpn().axx() == null || this.iPz.cpn().axx().azE() == null || this.iPz.cpn().axx().aBC() || TextUtils.equals(this.iPz.cpn().axx().azE().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private void t(Context context, String str, String str2) {
        long templateId = this.iPz.cpn().cix().cIC() != null ? this.iPz.cpn().cix().cIC().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ba.aEa().b(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.iPz.cpn().aMv().getId(), this.iPz.cpn().aMv().getName(), this.iPz.cpn().axx().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(int i, String str) {
        if (this.iPz.cpo()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.isNetOk()) {
            if (i == 4) {
                this.iPB.zm(str + "(4)");
            } else {
                this.iPB.wd(R.string.no_data_text);
            }
        } else {
            this.iPB.wd(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nV(boolean z) {
        this.hKe = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dR(getActivity());
        if (this.hKe != null) {
            this.hKe.a(getPageContext());
            this.hKe.b(this.iPz);
            this.hKe.b(this.hbs);
            this.hKe.a(this.dub);
            this.hKe.a(this.duc);
            this.hKe.aLC().gp(true);
            this.hKe.g(getPageContext());
        }
        if (this.iPB != null) {
            this.iPB.i(this.hKe);
        }
        if (this.hKe != null && this.iPz != null) {
            this.hKe.a(this.iPz.bAs());
            this.hKe.aMB();
        }
        if (this.hKe != null) {
            this.hKe.aMF().setDefaultHint(cmM());
            this.hKe.aMF().setHint(cmM());
            this.hbm = this.hKe.aMF().getInputView();
            this.hbm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.hbl != null) {
                        if (!NewSubPbActivity.this.hbl.cRK()) {
                            NewSubPbActivity.this.mC(false);
                        }
                        NewSubPbActivity.this.hbl.tr(false);
                    }
                }
            });
        }
    }

    public void coN() {
        if (!TbadkCoreApplication.isLogin()) {
            this.hKe.aMB();
        } else if (!StringUtils.isNull(this.iPz.cpw())) {
            if (this.iPB.coU() && com.baidu.adp.lib.util.l.isNetOk()) {
                this.iPB.byw();
            } else {
                this.iPB.coX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(View view) {
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
                    this.iPB.cw(view);
                }
            } else if (booleanValue2) {
                this.iPB.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.iPB.cpe(), getPageContext().getPageActivity());
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
            bVar.jJ(R.string.operation);
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.iPK);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.iPK);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).aBX();
        }
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.iPB.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.iPK;
        userMuteCheckCustomMessage.setTag(this.iPK);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.iPB.a(0, bVar.mSuccess, bVar.kew, z);
            if (bVar.mSuccess) {
                if (bVar.fSL == 1) {
                    if (this.iPB.getListView() instanceof BdTypeListView) {
                        List<com.baidu.adp.widget.ListView.m> data = ((BdTypeListView) this.iPB.getListView()).getData();
                        if (!v.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.iPB.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.fSL == 2) {
                    this.iPz.FT(bVar.mPostId);
                    this.iPB.a(this.iPz.cpn(), this.iPz.chW(), this.iPz.cpA() != null);
                    if (this.iPz.cpx()) {
                        this.iPz.qz(false);
                        this.iPB.coS();
                        this.iPz.loadData();
                    }
                }
                com.baidu.tieba.pb.f fVar = new com.baidu.tieba.pb.f();
                fVar.setData(bVar);
                fVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, fVar));
            }
        }
    }

    public void Fq(String str) {
        if (this.iPz != null && this.iPz.cpn() != null && this.iPz.cpn().axx() != null && this.iPz.cpn().axx().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.iPz.ckU(), str);
            bj axx = this.iPz.cpn().axx();
            if (axx.ays()) {
                format = format + "&channelid=33833";
            } else if (axx.aBy()) {
                format = format + "&channelid=33842";
            } else if (axx.aBz()) {
                format = format + "&channelid=33840";
            }
            Fr(format);
            return;
        }
        this.iCq.FQ(str);
    }

    private void Fr(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void k(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.iPz.cpt() && postData.getId() != null && postData.getId().equals(this.iPz.cpv())) {
                z = true;
            }
            MarkData l = this.iPz.l(postData);
            if (l != null) {
                this.iPB.cny();
                if (this.iCr != null) {
                    this.iCr.a(l);
                    if (!z) {
                        this.iCr.awf();
                    } else {
                        this.iCr.awe();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.iPz != null) {
            this.iPz.au(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.hKe != null) {
            this.hKe.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.hKe.aLC().aJZ();
        this.hKe.aMB();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.hKe.b(writeData);
                this.hKe.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l lX = this.hKe.aLC().lX(6);
                if (lX != null && lX.dsh != null) {
                    lX.dsh.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.hKe.aMx();
                }
                this.iPB.cpk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.giZ != null) {
            this.giZ.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.eag = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.auQ().auV();
        if (this.giZ != null) {
            this.giZ.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.hnU);
        this.iPB.bHJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eag = false;
        super.onResume();
        ckA();
        if (this.giZ != null) {
            this.giZ.onResume(getPageContext());
        }
        registerListener(this.hnU);
        this.iPB.bHK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.giZ != null) {
            this.giZ.onStop(getPageContext());
        }
        this.hKe.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.iPM));
        this.iPz.cancelLoadData();
        this.iPz.destory();
        this.iPA.cancelLoadData();
        if (this.giZ != null) {
            this.giZ.onDestory(getPageContext());
        }
        this.iPB.cny();
        this.iPB.afZ();
        MessageManager.getInstance().unRegisterListener(this.iDn);
        MessageManager.getInstance().unRegisterListener(this.iDo);
        MessageManager.getInstance().unRegisterListener(this.iDp);
        MessageManager.getInstance().unRegisterListener(this.iPK);
        this.iCM = null;
        this.iCN = null;
        if (this.hJV != null) {
            this.hJV.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iPB.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.giZ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View coZ = this.iPB.coZ();
        if (coZ == null || (findViewWithTag = coZ.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean FJ(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = ba.getParamPair(ba.getParamStr(str))) != null) {
            this.iPL = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return FJ(k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(iPy);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (FJ(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                    lVar.mLink = str;
                    lVar.type = 3;
                    lVar.drj = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
                }
            } else {
                ba.aEa().b(getPageContext(), new String[]{str});
            }
            this.iPL = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aB(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iPL = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aC(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aD(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void r(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        if (this.iPB != null) {
            return this.iPB.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int aRM() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> aRO() {
        if (this.dKO == null) {
            this.dKO = TbRichTextView.z(getPageContext().getPageActivity(), 8);
        }
        return this.dKO;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> aRP() {
        if (this.dHZ == null) {
            this.dHZ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bEt */
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
        return this.dHZ;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> aRN() {
        if (this.dHY == null) {
            this.dHY = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aRZ */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.axf().isShowImages();
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
                        if (i.axf().isShowImages()) {
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
        return this.dHY;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> aRQ() {
        if (this.dKP == null) {
            this.dKP = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: ckH */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(NewSubPbActivity.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cs */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: ct */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cu */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.dKP;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> aRR() {
        if (this.dKQ == null) {
            this.dKQ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: ckJ */
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
        return this.dKQ;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> aRS() {
        this.dKR = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: ckI */
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
        return this.dKR;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a ciI() {
        return this.iyV;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean ciJ() {
        return (this.iPz == null || this.iPz.cpn() == null || this.iPz.cpn().axx() == null || this.iPz.cpn().axx().aAY()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String ciK() {
        if (this.iPz == null || this.iPz.cpn() == null || this.iPz.cpn().axx() == null) {
            return null;
        }
        return this.iPz.cpn().axx().azJ();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int ciL() {
        if (this.iPz == null) {
            return 0;
        }
        return this.iPz.chW();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Fl(String str) {
        if (StringUtils.isNull(str) || this.iPz == null || this.iPz.cpn() == null || this.iPz.cpn().axx() == null || this.iPz.cpn().axx().azE() == null) {
            return false;
        }
        return str.equals(this.iPz.cpn().axx().azE().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.iPB.coU() && com.baidu.adp.lib.util.l.isNetOk()) {
            this.iPz.loadData();
        } else {
            this.iPB.coX();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.iPK);
        userMuteAddAndDelCustomMessage.setTag(this.iPK);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FR(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aCY().getString("bubble_link", "");
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
    public void aF(Context context, String str) {
        t(context, str, "BUTTON");
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
                return com.baidu.tbadk.m.e.aOm().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.iPz != null) {
            if (this.iPz.cpn() != null && this.iPz.cpn().aMv() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.iPz.cpn().aMv().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.iPz.ckU(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.eag;
    }

    public boolean coO() {
        if (this.iPz != null) {
            return this.iPz.coO();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.iPB.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iCM.getPageActivity());
        if (aq.isEmpty(str)) {
            aVar.sz(this.iCM.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.sz(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.iPB.showLoadingDialog();
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
        aVar.b(this.iCM).aBW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uU(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iCM.getPageActivity());
        aVar.sz(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.iCM).aBW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.sz(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.iCM).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.iCM.getPageActivity(), 2, true, 4);
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
        aVar.b(this.iCM).aBW();
    }

    public SubPbModel coP() {
        return this.iPz;
    }

    public int chW() {
        if (this.iPz != null) {
            return this.iPz.chW();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.dsE && !this.aVH) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.dsE && !this.aVH) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void mC(boolean z) {
        if (this.hbm != null && this.hbm.getText() != null) {
            int selectionEnd = this.hbm.getSelectionEnd();
            SpannableStringBuilder a2 = this.hbl.a(this.hbm.getText());
            if (a2 != null) {
                this.hbl.tr(true);
                this.hbm.setText(a2);
                if (z && this.hbl.cRI() >= 0) {
                    this.hbm.requestFocus();
                    this.hbm.setSelection(this.hbl.cRI());
                } else {
                    this.hbm.setSelection(selectionEnd);
                }
                this.hbl.tq(this.hbl.cRI() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hKe != null && this.hKe.aLC() != null && this.hKe.aLC().aLE()) {
            this.hKe.aLC().aJZ();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.d.a(pVar, getUniqueId(), this);
    }

    public String cmM() {
        if (!aq.isEmpty(this.iKs)) {
            return this.iKs;
        }
        this.iKs = getResources().getString(ap.cmB());
        return this.iKs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.iPN = z;
        qv(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qv(boolean z) {
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
        if (this.iPB != null && this.iPB.getListView() != null && this.iPO != null && this.iPO.mPosition != -1) {
            final int headerViewsCount = this.iPO.mPosition + this.iPB.getListView().getHeaderViewsCount();
            if (this.iPO.getView() != null) {
                final int height = this.iPO.getView().getHeight() - ((rect.height() - this.iPB.getNavigationBarHeight()) - this.iPB.cpj());
                if (height > 0) {
                    this.iPB.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.iPB != null && NewSubPbActivity.this.iPB.getListView() != null) {
                                NewSubPbActivity.this.iPB.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.iPB.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.iPB.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.iPB != null && NewSubPbActivity.this.iPB.getListView() != null) {
                                NewSubPbActivity.this.iPB.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.iPB.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }

    private void ckA() {
        if (this.iPz != null && !aq.isEmpty(this.iPz.ckU())) {
            com.baidu.tbadk.BdToken.c.auQ().o(com.baidu.tbadk.BdToken.b.cCB, com.baidu.adp.lib.f.b.toLong(this.iPz.ckU(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.iPz == null || aq.isEmpty(this.iPz.ckU())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.iPz.ckU(), 0L);
    }
}
