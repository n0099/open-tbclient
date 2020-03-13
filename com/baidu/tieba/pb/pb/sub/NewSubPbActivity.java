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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.m;
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
    private static String iUK = "tbgametype";
    private View.OnClickListener aku;
    private com.baidu.adp.lib.d.b<ImageView> dMA;
    private com.baidu.adp.lib.d.b<GifView> dMB;
    private com.baidu.adp.lib.d.b<TextView> dPo;
    private com.baidu.adp.lib.d.b<View> dPp;
    private com.baidu.adp.lib.d.b<LinearLayout> dPq;
    private com.baidu.adp.lib.d.b<RelativeLayout> dPr;
    private ar gQN;
    private VoiceManager goy;
    private com.baidu.tieba.frs.profession.permission.c grZ;
    public aj hPK;
    private com.baidu.tbadk.editortools.pb.h hPT;
    private com.baidu.tieba.write.c hhc;
    private EditText hhd;
    private com.baidu.tieba.pb.pb.main.b.a iEw;
    private com.baidu.tieba.pb.pb.report.a iHM;
    private com.baidu.tbadk.baseEditMark.a iHN;
    private e iIi;
    private com.baidu.tbadk.core.view.d iIj;
    private com.baidu.adp.widget.ImageView.a iIm;
    private String iIn;
    private TbRichTextMemeInfo iIo;
    private PostWriteCallBackData iJN;
    private String iPF;
    private SubPbModel iUL;
    private ForumManageModel iUM;
    private com.baidu.tieba.pb.pb.sub.a iUN;
    private w iUO;
    private AbsListView.OnScrollListener iUP;
    private TbRichTextView.i iUQ;
    private SubPbModel.a iUR;
    private com.baidu.adp.base.d iUS;
    private BdUniqueId iUW;
    private com.baidu.tieba.pb.e<l> iUY;
    private boolean iUZ;
    private k iVa;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int iIT = 0;
    PostData hhL = null;
    private a.InterfaceC0374a iIQ = null;
    private a iUT = null;
    private a iUU = null;
    private boolean eeG = false;
    private boolean iUV = false;
    private boolean iUX = false;
    private boolean dxj = false;
    private com.baidu.tbadk.editortools.pb.c dyG = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aOS() {
            NewSubPbActivity.this.iUN.cry();
        }
    };
    private int iDS = 0;
    private boolean mIsFromSchema = false;
    private com.baidu.tbadk.editortools.pb.b dyH = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOR() {
            if (!NewSubPbActivity.this.hhc.cUf()) {
                return (NewSubPbActivity.this.hPK == null || NewSubPbActivity.this.iUL == null || NewSubPbActivity.this.iUL.bCZ() == null || NewSubPbActivity.this.hPK.ax(NewSubPbActivity.this.iUL.bCZ().replyPrivateFlag, aj.cZY)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.hhc.cUh());
            if (NewSubPbActivity.this.hPT.aPi()) {
                NewSubPbActivity.this.hPT.a(NewSubPbActivity.this.iJN);
            }
            NewSubPbActivity.this.mP(true);
            return true;
        }
    };
    private NewWriteModel.d hhj = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.hPT != null && NewSubPbActivity.this.hPT.aOu() != null) {
                NewSubPbActivity.this.hPT.aOu().hide();
                if (NewSubPbActivity.this.iUL.crW()) {
                    TiebaStatic.log(new an("c10367").cy("post_id", NewSubPbActivity.this.iUL.aOP()));
                }
            }
            if (z) {
                NewSubPbActivity.this.hhc.KL(null);
                NewSubPbActivity.this.hhc.aU(null);
                NewSubPbActivity.this.hhc.tG(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.hhc.aU(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.hhc.KL(postWriteCallBackData.getErrorString());
                if (!v.isEmpty(NewSubPbActivity.this.hhc.cUd())) {
                    NewSubPbActivity.this.iJN = postWriteCallBackData;
                    if (NewSubPbActivity.this.hPT.aPi()) {
                        NewSubPbActivity.this.hPT.a(NewSubPbActivity.this.iJN);
                    }
                    NewSubPbActivity.this.mP(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.hPK != null) {
                NewSubPbActivity.this.hPK.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.iUN.crz();
        }
    };
    private CustomMessageListener iII = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iUW) {
                NewSubPbActivity.this.iUN.bqs();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.iIj.showSuccessToast(NewSubPbActivity.this.iIi.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.iIi.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.vr(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.cnc();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.iIi.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.iIj.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener iIJ = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iUW) {
                NewSubPbActivity.this.iUN.bqs();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.iIj.showSuccessToast(NewSubPbActivity.this.iIi.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.iIi.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.iIj.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener iIK = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iUW) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.iUN.bqs();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.kuS;
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
                    NewSubPbActivity.this.iUN.a(sparseArray, z);
                }
            }
        }
    };
    boolean iIU = false;
    private final b.a iIW = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.iIm != null && !TextUtils.isEmpty(NewSubPbActivity.this.iIn)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.iIo == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.iIn));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.iIn;
                        aVar.pkgId = NewSubPbActivity.this.iIo.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.iIo.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.gQN == null) {
                            NewSubPbActivity.this.gQN = new ar(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.gQN.j(NewSubPbActivity.this.iIn, NewSubPbActivity.this.iIm.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.iIm = null;
                NewSubPbActivity.this.iIn = null;
            }
        }
    };
    private CustomMessageListener htK = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener gpN = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    m mVar = (m) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.iUL.crP() != null && NewSubPbActivity.this.iUL.crP().clg() != null && NewSubPbActivity.this.iUL.crP().clg().aCo() != null && currentAccount.equals(NewSubPbActivity.this.iUL.crP().clg().aCo().getUserId()) && NewSubPbActivity.this.iUL.crP().clg().aCo().getPendantData() != null) {
                        NewSubPbActivity.this.iUL.crP().clg().aCo().getPendantData().sB(mVar.aAG());
                        NewSubPbActivity.this.iUL.crP().clg().aCo().getPendantData().bI(mVar.aNZ());
                        NewSubPbActivity.this.iUN.a(NewSubPbActivity.this.iUL.crP(), NewSubPbActivity.this.iUL.crP().clg(), NewSubPbActivity.this.iUL.crP().bXv(), NewSubPbActivity.this.iUL.crP().ayL(), NewSubPbActivity.this.iUL.ckH(), NewSubPbActivity.this.iUL.csc() != null);
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
        this.iIi = getPageContext();
        this.iUV = true;
        this.hhc = new com.baidu.tieba.write.c();
        this.hhc.Ea(R.color.cp_cont_h_alpha85);
        this.hhc.DZ(R.color.cp_cont_a);
        initListeners();
        cro();
        initData(bundle);
        initUI();
        ((SubPbView) this.iUN.getRootView()).show();
        oj(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.iUN.qK(this.mIsFromSchema);
        this.iIj = new com.baidu.tbadk.core.view.d();
        this.iIj.toastTime = 1000L;
        registerListener(this.iIK);
        registerListener(this.iII);
        registerListener(this.iIJ);
        this.iUW = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.iUW;
        userMuteAddAndDelCustomMessage.setTag(this.iUW);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.iUW;
        userMuteCheckCustomMessage.setTag(this.iUW);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.hPK = new aj(getPageContext());
        this.hPK.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tbadk.core.util.aj.a
            public void l(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.hPT.aPp();
                }
            }
        });
        this.iHM = new com.baidu.tieba.pb.pb.report.a(this);
        this.iHM.t(getUniqueId());
        this.iEw = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.iUN = new com.baidu.tieba.pb.pb.sub.a(this, this.aku);
        this.iUN.a(this.iUL);
        setContentView(this.iUN.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.iUN.setOnScrollListener(this.iUP);
        this.iUN.b(this);
        this.iUN.setOnImageClickListener(this.iUQ);
        this.iUN.setOnLongClickListener(this.mOnLongClickListener);
        this.iUN.f(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.iUL != null) {
                    NewSubPbActivity.this.iUL.loadData();
                }
            }
        });
        this.iUN.a(this.iUT);
        this.iUN.b(this.iUU);
        if (this.iUL != null && this.iUL.crq() && !this.iUL.csb()) {
            this.iUN.crE().setVisibility(8);
        } else {
            this.iUN.crE().setVisibility(0);
        }
        if (this.iUL != null && !this.iUL.crq()) {
            this.iUN.setIsFromPb(false);
        }
    }

    private boolean av(Bundle bundle) {
        if (bundle != null) {
            this.dxj = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.dxj = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.dxj;
    }

    public void initData(Bundle bundle) {
        this.iUL = new SubPbModel(getPageContext());
        this.iUL.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void p(PostData postData) {
                NewSubPbActivity.this.iUN.r(postData);
                NewSubPbActivity.this.iUN.b((BdListView.e) null);
            }
        });
        this.iUM = new ForumManageModel(getPageContext());
        this.iUM.setLoadDataCallBack(this.iUS);
        this.goy = new VoiceManager();
        this.goy.onCreate(getPageContext());
        this.iHN = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.iHN != null) {
            this.iHN.a(this.iIQ);
        }
        if (bundle != null) {
            this.iUL.initWithBundle(bundle);
        } else {
            this.iUL.initWithIntent(getIntent());
        }
        this.iUL.a(this.iUR);
        if (this.iUL.crq()) {
            this.iUL.loadData();
        } else {
            this.iUL.crU();
        }
    }

    public void cro() {
        this.iUR = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, l lVar) {
                if (NewSubPbActivity.this.iUN != null) {
                    NewSubPbActivity.this.iUN.crz();
                    if (!z) {
                        NewSubPbActivity.this.aX(i, str);
                        return;
                    }
                    NewSubPbActivity.this.iUN.hideNoDataView();
                    if (lVar != null) {
                        if (lVar.clg() != null || NewSubPbActivity.this.iUL != null) {
                            lVar.clg().a(NewSubPbActivity.this.iUL.csa());
                        }
                        if (NewSubPbActivity.this.iUN != null) {
                            NewSubPbActivity.this.oj(lVar.aAg() != null && lVar.aAg().isBjh());
                            if (NewSubPbActivity.this.hPT != null && NewSubPbActivity.this.hPT.aOu() != null) {
                                NewSubPbActivity.this.hPT.aOu().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.iUN.a(lVar, NewSubPbActivity.this.iUL.ckH(), NewSubPbActivity.this.iUL.csc() != null);
                            if (NewSubPbActivity.this.iUV) {
                                NewSubPbActivity.this.crp();
                                NewSubPbActivity.this.iUV = false;
                            }
                        }
                        if (NewSubPbActivity.this.hPT != null) {
                            NewSubPbActivity.this.hPT.a(lVar.bCZ());
                            NewSubPbActivity.this.hPT.setThreadData(lVar.aAg());
                        }
                        if (NewSubPbActivity.this.iUY == null) {
                            NewSubPbActivity.this.iUY = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.iUY.setData(lVar);
                        NewSubPbActivity.this.iUY.setType(0);
                        NewSubPbActivity.this.hPK.a(NewSubPbActivity.this.iUL.csf());
                    }
                }
            }
        };
        this.iIQ = new a.InterfaceC0374a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0374a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.iHN != null) {
                        NewSubPbActivity.this.iHN.fm(z2);
                    }
                    MarkData ayO = NewSubPbActivity.this.iHN.ayO();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(ayO);
                        if (NewSubPbActivity.this.iHN != null) {
                            if (ayO != null) {
                                NewSubPbActivity.this.iUL.qM(true);
                                NewSubPbActivity.this.iUL.Gu(NewSubPbActivity.this.iUL.aOP());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.iUN != null) {
                                NewSubPbActivity.this.iUN.qL(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.iUL.qM(false);
                        NewSubPbActivity.this.iUL.Gu(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.iUN != null) {
                            NewSubPbActivity.this.iUN.qL(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.iUT = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.iUL.crP() != null && NewSubPbActivity.this.iUL.crP().aAg() != null && NewSubPbActivity.this.iUL.crP().aAg().aCo() != null) {
                    str = String.valueOf(NewSubPbActivity.this.iUL.crP().aAg().aCo().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.iUL.crP().aPn().getId(), NewSubPbActivity.this.iUL.crP().aPn().getName(), NewSubPbActivity.this.iUL.crP().aAg().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.iUU = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.iUM.cLP() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.iUL != null && NewSubPbActivity.this.iUL.crP() != null && NewSubPbActivity.this.iUL.crP().aPn() != null && NewSubPbActivity.this.iUL.crP().aAg() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.iUM.Jh(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.iUM.a(NewSubPbActivity.this.iUL.crP().aPn().getId(), NewSubPbActivity.this.iUL.crP().aPn().getName(), NewSubPbActivity.this.iUL.crP().aAg().getId(), valueOf, i2, i, z, NewSubPbActivity.this.iUL.crP().aAg().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.iUS = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.iUN.a(NewSubPbActivity.this.iUM.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.iUM.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.iVT != 1002 || bVar.eLS) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.iUN.a(1, dVar.mSuccess, dVar.kju, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean cv(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void initListeners() {
        registerListener(this.gpN);
        this.aku = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v65, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray sparseArray;
                if (view != null || NewSubPbActivity.this.iUN != null) {
                    if (view == NewSubPbActivity.this.iUN.crK()) {
                        NewSubPbActivity.this.iUN.cpZ();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ba.aGG().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.iUN.bIp()) {
                        if (view != NewSubPbActivity.this.iUN.crD()) {
                            if (view != NewSubPbActivity.this.iUN.crC()) {
                                if (view == NewSubPbActivity.this.iUN.crx()) {
                                    NewSubPbActivity.this.iUN.cpZ();
                                    if (NewSubPbActivity.this.iUL.loadData()) {
                                        NewSubPbActivity.this.iUN.crv();
                                    }
                                } else if (view == NewSubPbActivity.this.iUN.crE() || view == NewSubPbActivity.this.iUN.crF() || view == NewSubPbActivity.this.iUN.crH()) {
                                    if (NewSubPbActivity.this.iUX) {
                                        NewSubPbActivity.this.iUX = false;
                                        return;
                                    }
                                    if ((NewSubPbActivity.this.iUL.crP() == null || NewSubPbActivity.this.iUL.crP().aAg() == null) ? false : au.a(NewSubPbActivity.this.iUL.crP().aAg().getBaijiahaoData())) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.iUL.cnz(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.iUL.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.iUL.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.iUL.crP() != null && NewSubPbActivity.this.iUL.crP().aAg() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.iUL.crP().aAg().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.iUL.cnz(), NewSubPbActivity.this.iUL.aOP(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.iUL.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.iUL.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.iUN.crI() == null || view != NewSubPbActivity.this.iUN.crI().cox()) {
                                    if (NewSubPbActivity.this.iUN.crI() == null || view != NewSubPbActivity.this.iUN.crI().coA()) {
                                        if (NewSubPbActivity.this.iUN.crI() == null || view != NewSubPbActivity.this.iUN.crI().coy()) {
                                            if (NewSubPbActivity.this.iUN.crI() == null || view != NewSubPbActivity.this.iUN.crI().coz()) {
                                                if (NewSubPbActivity.this.iUN.crI() == null || view != NewSubPbActivity.this.iUN.crI().coB()) {
                                                    if (view == NewSubPbActivity.this.iUN.crB() || view == NewSubPbActivity.this.iUN.crH()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.hPT.aPs()) {
                                                                NewSubPbActivity.this.hPT.aPt();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.hPT.vs(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof k)) {
                                                        if (NewSubPbActivity.this.iUO == null || view != NewSubPbActivity.this.iUO.coz()) {
                                                            if (NewSubPbActivity.this.iUO == null || view != NewSubPbActivity.this.iUO.cox()) {
                                                                if (NewSubPbActivity.this.iUO == null || view != NewSubPbActivity.this.iUO.coA()) {
                                                                    if (NewSubPbActivity.this.iUO == null || view != NewSubPbActivity.this.iUO.coB()) {
                                                                        if (NewSubPbActivity.this.iUO == null || view != NewSubPbActivity.this.iUO.coD()) {
                                                                            if (NewSubPbActivity.this.iUO == null || view != NewSubPbActivity.this.iUO.coE()) {
                                                                                if (NewSubPbActivity.this.iUO != null && view == NewSubPbActivity.this.iUO.coy()) {
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
                                                                                            NewSubPbActivity.this.iUN.cA(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.iUN.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.aFD().getString("tail_link", "");
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
                                                                                        if (postData.getType() != PostData.kgG && !TextUtils.isEmpty(postData.getBimg_url()) && i.azO().isShowImages()) {
                                                                                            NewSubPbActivity.this.Gr(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.iIm != null && !TextUtils.isEmpty(NewSubPbActivity.this.iIn)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.gQN == null) {
                                                                                        NewSubPbActivity.this.gQN = new ar(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.gQN.j(NewSubPbActivity.this.iIn, NewSubPbActivity.this.iIm.getImageByte());
                                                                                    NewSubPbActivity.this.iIm = null;
                                                                                    NewSubPbActivity.this.iIn = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.iIm != null && !TextUtils.isEmpty(NewSubPbActivity.this.iIn)) {
                                                                            if (NewSubPbActivity.this.iIo == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.iIn));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.iIn;
                                                                                aVar.pkgId = NewSubPbActivity.this.iIo.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.iIo.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.iIm = null;
                                                                            NewSubPbActivity.this.iIn = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.hhL != null) {
                                                                        NewSubPbActivity.this.hhL.fv(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.hhL = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.iUN.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.cu(view);
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
                                                                NewSubPbActivity.this.FQ((String) tag);
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
                                                        NewSubPbActivity.this.iVa = (k) view.getTag();
                                                        if (bc.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.iUX) {
                                                                NewSubPbActivity.this.iUX = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.hPK == null || NewSubPbActivity.this.iUL == null || NewSubPbActivity.this.iUL.bCZ() == null || NewSubPbActivity.this.hPK.ks(NewSubPbActivity.this.iUL.bCZ().replyPrivateFlag)) && (sparseArray = (SparseArray) view.getTag(R.id.tag_from)) != null) {
                                                                if (sparseArray.get(R.id.tag_clip_board) instanceof PostData) {
                                                                    PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                    if (postData2 != null && postData2.aCo() != null) {
                                                                        MetaData aCo = postData2.aCo();
                                                                        NewSubPbActivity.this.hPT.setReplyId(aCo.getUserId());
                                                                        if (!(sparseArray.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue() : true)) {
                                                                            NewSubPbActivity.this.hPT.vt("");
                                                                        } else {
                                                                            NewSubPbActivity.this.hPT.vt(aCo.getName_show());
                                                                        }
                                                                    }
                                                                    NewSubPbActivity.this.iUN.crt();
                                                                }
                                                                if (NewSubPbActivity.this.iUZ) {
                                                                    NewSubPbActivity.this.qJ(false);
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
                                                        ((PostData) sparseArray5.get(R.id.tag_clip_board)).fv(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new an("c11739").X("obj_locate", 4));
                                            if (!j.isNetWorkAvailable()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.iUN.cpZ();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.FQ(str4);
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
                                            NewSubPbActivity.this.iUN.cpZ();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.cD(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.iUN.cpZ();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.iUN.a(((Integer) sparseArray7.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray7.get(R.id.tag_del_post_id), ((Integer) sparseArray7.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new an("c11739").X("obj_locate", 2));
                                    NewSubPbActivity.this.iUN.cpZ();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.iUL.crP() != null) {
                                        NewSubPbActivity.this.k(NewSubPbActivity.this.iUL.crP().clg());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.iUN.crs();
                                NewSubPbActivity.this.iUN.crt();
                                if (NewSubPbActivity.this.hPT != null) {
                                    NewSubPbActivity.this.hPT.aPv();
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.iUN.crs();
                            NewSubPbActivity.this.iUN.crt();
                            if (NewSubPbActivity.this.hPT != null) {
                                NewSubPbActivity.this.hPT.aPu();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.cmA();
                        if (NewSubPbActivity.this.iUL != null && NewSubPbActivity.this.iUL.crP() != null && NewSubPbActivity.this.iUL.crP().aAg() != null && NewSubPbActivity.this.iUL.crP().aAg().aCo() != null) {
                            TiebaStatic.log(new an("c13402").cy("tid", NewSubPbActivity.this.iUL.cnz()).s("fid", NewSubPbActivity.this.iUL.crP().aAg().getFid()).X("obj_locate", 5).cy("uid", NewSubPbActivity.this.iUL.crP().aAg().aCo().getUserId()));
                        }
                    }
                }
            }
        };
        this.iUP = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.iUN.cpZ();
                    if (NewSubPbActivity.this.iDS != 2 && NewSubPbActivity.this.iDS != 1) {
                        NewSubPbActivity.this.iUN.crM();
                    }
                }
                NewSubPbActivity.this.hPT.aPt();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.iUN.crJ();
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
                if (NewSubPbActivity.this.iUN != null && NewSubPbActivity.this.iUN.crA()) {
                    return false;
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null && NewSubPbActivity.this.cv(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.iIm = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.iIn = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.iIm == null || TextUtils.isEmpty(NewSubPbActivity.this.iIn)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.iIo = null;
                        } else {
                            NewSubPbActivity.this.iIo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.iIm = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.iIn = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.iIo = null;
                        } else {
                            NewSubPbActivity.this.iIo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.iIm = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.iIn = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.iIo = null;
                        } else {
                            NewSubPbActivity.this.iIo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.iUN.a(NewSubPbActivity.this.iIW, NewSubPbActivity.this.iIm.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.hhL = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.hhL == null || NewSubPbActivity.this.iHN == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.iHN != null) {
                            NewSubPbActivity.this.iHN.fm(NewSubPbActivity.this.iUL.crV());
                        }
                        boolean z = NewSubPbActivity.this.iHN.ayL() && NewSubPbActivity.this.hhL.getId() != null && NewSubPbActivity.this.hhL.getId().equals(NewSubPbActivity.this.iUL.crX());
                        if (NewSubPbActivity.this.iUO == null) {
                            NewSubPbActivity.this.iUO = new w(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aku);
                            NewSubPbActivity.this.iUN.cE(NewSubPbActivity.this.iUO.getView());
                            NewSubPbActivity.this.iUO.pY(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.iUO.showDialog();
                        boolean z2 = NewSubPbActivity.this.pL(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z3 = (NewSubPbActivity.this.iUL.crP() == null || NewSubPbActivity.this.iUL.crP().aAg() == null || !NewSubPbActivity.this.iUL.crP().aAg().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z) {
                            NewSubPbActivity.this.iUO.cox().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.iUO.cox().setText(R.string.mark);
                        }
                        if (booleanValue || z3) {
                            NewSubPbActivity.this.iUO.cox().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.iUO.cox().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.cv(view)) {
                            if (NewSubPbActivity.this.iIm != null && !NewSubPbActivity.this.iIm.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        NewSubPbActivity.this.iUO.a(sparseArray2, NewSubPbActivity.this.ckH(), z2);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.iUQ = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                        l crP = NewSubPbActivity.this.iUL.crP();
                        TbRichText bj = NewSubPbActivity.this.bj(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bj != null && bj.aTT() != null) {
                            tbRichTextData = bj.aTT().get(NewSubPbActivity.this.iIT);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.aTZ().aUk()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (crP == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (crP.aPn() != null) {
                                        str4 = crP.aPn().getName();
                                        str5 = crP.aPn().getId();
                                    }
                                    if (crP.aAg() != null) {
                                        str6 = crP.aAg().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.iUL.csc() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.iUL.csc();
                                    z6 = NewSubPbActivity.this.iUL.cse();
                                    arrayList2 = NewSubPbActivity.this.iUL.csd();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.getItem(arrayList2, 0));
                                ImageViewerConfig createConfig = new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false);
                                createConfig.setPostId(String.valueOf(bj.getPostId()));
                                createConfig.setThreadData(NewSubPbActivity.this.aAg());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                                return;
                            }
                            NewSubPbActivity.this.iIU = false;
                            String str7 = "";
                            TbRichText cLd = crP.clg().cLd();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(cLd, bj, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (crP == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (crP.aPn() != null) {
                                    str8 = crP.aPn().getName();
                                    str9 = crP.aPn().getId();
                                }
                                if (crP.aAg() != null) {
                                    str10 = crP.aAg().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.iUL.csc() != null) {
                                concurrentHashMap = NewSubPbActivity.this.iUL.csc();
                                z4 = NewSubPbActivity.this.iUL.cse();
                                arrayList = NewSubPbActivity.this.iUL.csd();
                                i2 = a2 + NewSubPbActivity.this.iUL.getOffset();
                            } else {
                                concurrentHashMap = concurrentHashMap3;
                                i2 = a2;
                                z4 = z3;
                                arrayList = arrayList2;
                            }
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(v.getItem(arrayList, i2));
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList4, 0, str8, str9, str2, z4, str7, true, concurrentHashMap, true, false, false);
                            createConfig2.setThreadData(NewSubPbActivity.this.aAg());
                            createConfig2.setPostId(String.valueOf(bj.getPostId()));
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
    public bj aAg() {
        if (this.iUL == null || this.iUL.crP() == null) {
            return null;
        }
        return this.iUL.crP().aAg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(View view) {
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
        TbRichTextImageInfo aTZ;
        if (tbRichText == tbRichText2) {
            this.iIU = true;
        }
        if (tbRichText != null && tbRichText.aTT() != null) {
            int size = tbRichText.aTT().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.aTT().get(i6) != null && tbRichText.aTT().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.aTT().get(i6).aTZ().getWidth() * equipmentDensity;
                    int height = tbRichText.aTT().get(i6).aTZ().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.aTT().get(i6).aTZ().aUk()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.aTT().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (aTZ = tbRichTextData.aTZ()) != null) {
                            String aUm = aTZ.aUm();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = aUm;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.iIU) {
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
        if (this.iUO != null) {
            this.iUO.pY(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo aTZ = tbRichTextData.aTZ();
        if (aTZ != null) {
            if (!StringUtils.isNull(aTZ.aUj())) {
                return aTZ.aUj();
            }
            if (aTZ.getHeight() * aTZ.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (aTZ.getHeight() * aTZ.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (aTZ.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * aTZ.getHeight())));
            } else {
                float width = aTZ.getWidth() / aTZ.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(aTZ.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bj(String str, int i) {
        if (this.iUL == null || this.iUL.crP() == null || str == null || i < 0) {
            return null;
        }
        l crP = this.iUL.crP();
        TbRichText a2 = a(crP.clg(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(crP.clg(), str, i);
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
        TbRichText cLd = postData.cLd();
        if (cLd != null) {
            ArrayList<TbRichTextData> aTT = cLd.aTT();
            int size = aTT.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (aTT.get(i3) != null && aTT.get(i3).getType() == 8) {
                    i2++;
                    if (aTT.get(i3).aTZ().aUm().equals(str)) {
                        int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = aTT.get(i3).aTZ().getWidth() * equipmentDensity;
                        int height = aTT.get(i3).aTZ().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.iIT = i3;
                        return cLd;
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
    public void cmA() {
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false) {
            if (this.hPK == null || this.iUL == null || this.iUL.bCZ() == null || this.hPK.ks(this.iUL.bCZ().replyPrivateFlag)) {
                if (this.hPT.aPi()) {
                    this.hPT.a((PostWriteCallBackData) null);
                    return;
                }
                this.iUN.crs();
                this.iUN.crt();
                if (this.hPT != null) {
                    this.hPT.aPw();
                    return;
                }
                return;
            }
            return;
        }
        if (this.grZ == null) {
            this.grZ = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.grZ.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lw(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void t(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lx(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.hPK == null || NewSubPbActivity.this.iUL == null || NewSubPbActivity.this.iUL.bCZ() == null || NewSubPbActivity.this.hPK.ks(NewSubPbActivity.this.iUL.bCZ().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.hPT.aPi()) {
                                NewSubPbActivity.this.hPT.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.iUN.crs();
                            NewSubPbActivity.this.iUN.crt();
                            if (NewSubPbActivity.this.hPT != null) {
                                NewSubPbActivity.this.hPT.aPw();
                            }
                        }
                    }
                }
            });
        }
        if (this.iUL != null && this.iUL.crP() != null && this.iUL.crP().aPn() != null) {
            this.grZ.C(this.iUL.crP().aPn().getId(), com.baidu.adp.lib.f.b.toLong(this.iUL.cnz(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pL(boolean z) {
        if (this.iUL == null) {
            return false;
        }
        return ((ckH() != 0) || this.iUL.crP() == null || this.iUL.crP().aAg() == null || this.iUL.crP().aAg().aCo() == null || this.iUL.crP().aAg().aEi() || TextUtils.equals(this.iUL.crP().aAg().aCo().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(int i, String str) {
        if (this.iUL.crQ()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.isNetOk()) {
            if (i == 4) {
                this.iUN.zN(str + "(4)");
            } else {
                this.iUN.wo(R.string.no_data_text);
            }
        } else {
            this.iUN.wo(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(boolean z) {
        this.hPT = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dV(getActivity());
        if (this.hPT != null) {
            this.hPT.a(getPageContext());
            this.hPT.b(this.iUL);
            this.hPT.b(this.hhj);
            this.hPT.a(this.dyG);
            this.hPT.a(this.dyH);
            this.hPT.aOu().gB(true);
            this.hPT.g(getPageContext());
        }
        if (this.iUN != null) {
            this.iUN.i(this.hPT);
        }
        if (this.hPT != null && this.iUL != null) {
            this.hPT.a(this.iUL.bCZ());
            this.hPT.aPt();
        }
        if (this.hPT != null) {
            this.hPT.aPx().setDefaultHint(cpn());
            this.hPT.aPx().setHint(cpn());
            this.hhd = this.hPT.aPx().getInputView();
            this.hhd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.hhc != null) {
                        if (!NewSubPbActivity.this.hhc.cUg()) {
                            NewSubPbActivity.this.mP(false);
                        }
                        NewSubPbActivity.this.hhc.tH(false);
                    }
                }
            });
        }
    }

    public void crp() {
        if (!TbadkCoreApplication.isLogin()) {
            this.hPT.aPt();
        } else if (!StringUtils.isNull(this.iUL.crY())) {
            if (this.iUN.crw() && com.baidu.adp.lib.util.l.isNetOk()) {
                this.iUN.bBd();
            } else {
                this.iUN.crz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(View view) {
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
                    this.iUN.cA(view);
                }
            } else if (booleanValue2) {
                this.iUN.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.iUN.crG(), getPageContext().getPageActivity());
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
            bVar.ka(R.string.operation);
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.iUW);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.iUW);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).aED();
        }
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.iUN.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.iUW;
        userMuteCheckCustomMessage.setTag(this.iUW);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.iUN.a(0, bVar.mSuccess, bVar.kju, z);
            if (bVar.mSuccess) {
                if (bVar.fYk == 1) {
                    if (this.iUN.getListView() instanceof BdTypeListView) {
                        List<com.baidu.adp.widget.ListView.m> data = ((BdTypeListView) this.iUN.getListView()).getData();
                        if (!v.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.iUN.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.fYk == 2) {
                    this.iUL.Gt(bVar.mPostId);
                    this.iUN.a(this.iUL.crP(), this.iUL.ckH(), this.iUL.csc() != null);
                    if (this.iUL.crZ()) {
                        this.iUL.qN(false);
                        this.iUN.cru();
                        this.iUL.loadData();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void FQ(String str) {
        if (this.iUL != null && this.iUL.crP() != null && this.iUL.crP().aAg() != null && this.iUL.crP().aAg().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.iUL.cnz(), str);
            bj aAg = this.iUL.crP().aAg();
            if (aAg.aBd()) {
                format = format + "&channelid=33833";
            } else if (aAg.aEf()) {
                format = format + "&channelid=33842";
            } else if (aAg.aBe()) {
                format = format + "&channelid=33840";
            }
            FR(format);
            return;
        }
        this.iHM.Gq(str);
    }

    private void FR(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void k(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.iUL.crV() && postData.getId() != null && postData.getId().equals(this.iUL.crX())) {
                z = true;
            }
            MarkData l = this.iUL.l(postData);
            if (l != null) {
                this.iUN.cpZ();
                if (this.iHN != null) {
                    this.iHN.a(l);
                    if (!z) {
                        this.iHN.ayN();
                    } else {
                        this.iHN.ayM();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.iUL != null) {
            this.iUL.au(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.hPT != null) {
            this.hPT.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.hPT.aOu().aMR();
        this.hPT.aPt();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.hPT.b(writeData);
                this.hPT.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l mp = this.hPT.aOu().mp(6);
                if (mp != null && mp.dwN != null) {
                    mp.dwN.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.hPT.aPp();
                }
                this.iUN.crM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.goy != null) {
            this.goy.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.eeG = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.axz().axE();
        if (this.goy != null) {
            this.goy.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.htK);
        this.iUN.bKq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eeG = false;
        super.onResume();
        cnf();
        if (this.goy != null) {
            this.goy.onResume(getPageContext());
        }
        registerListener(this.htK);
        this.iUN.bKr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.goy != null) {
            this.goy.onStop(getPageContext());
        }
        this.hPT.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.iUY));
        this.iUL.cancelLoadData();
        this.iUL.destory();
        this.iUM.cancelLoadData();
        if (this.goy != null) {
            this.goy.onDestory(getPageContext());
        }
        this.iUN.cpZ();
        this.iUN.aiI();
        MessageManager.getInstance().unRegisterListener(this.iII);
        MessageManager.getInstance().unRegisterListener(this.iIJ);
        MessageManager.getInstance().unRegisterListener(this.iIK);
        MessageManager.getInstance().unRegisterListener(this.iUW);
        this.iIi = null;
        this.iIj = null;
        if (this.hPK != null) {
            this.hPK.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iUN.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.goy;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View crB = this.iUN.crB();
        if (crB == null || (findViewWithTag = crB.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Gj(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = ba.getParamPair(ba.getParamStr(str))) != null) {
            this.iUX = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Gj(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(iUK);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (Gj(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                    lVar.mLink = str;
                    lVar.type = 3;
                    lVar.dvQ = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
                }
            } else {
                ba.aGG().b(getPageContext(), new String[]{str});
            }
            this.iUX = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aC(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iUX = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aD(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void r(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        if (this.iUN != null) {
            return this.iUN.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int aUA() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> aUC() {
        if (this.dPo == null) {
            this.dPo = TbRichTextView.z(getPageContext().getPageActivity(), 8);
        }
        return this.dPo;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> aUD() {
        if (this.dMB == null) {
            this.dMB = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bHa */
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
        return this.dMB;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> aUB() {
        if (this.dMA == null) {
            this.dMA = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aUN */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.azO().isShowImages();
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
                        if (i.azO().isShowImages()) {
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
        return this.dMA;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> aUE() {
        if (this.dPp == null) {
            this.dPp = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnm */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(NewSubPbActivity.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cw */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cx */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cy */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.dPp;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> aUF() {
        if (this.dPq == null) {
            this.dPq = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cno */
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
        return this.dPq;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> aUG() {
        this.dPr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cnn */
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
        return this.dPr;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a clr() {
        return this.iEw;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cls() {
        return (this.iUL == null || this.iUL.crP() == null || this.iUL.crP().aAg() == null || this.iUL.crP().aAg().aDG()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String clt() {
        if (this.iUL == null || this.iUL.crP() == null || this.iUL.crP().aAg() == null) {
            return null;
        }
        return this.iUL.crP().aAg().aCt();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int clu() {
        if (this.iUL == null) {
            return 0;
        }
        return this.iUL.ckH();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean FL(String str) {
        if (StringUtils.isNull(str) || this.iUL == null || this.iUL.crP() == null || this.iUL.crP().aAg() == null || this.iUL.crP().aAg().aCo() == null) {
            return false;
        }
        return str.equals(this.iUL.crP().aAg().aCo().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.iUN.crw() && com.baidu.adp.lib.util.l.isNetOk()) {
            this.iUL.loadData();
        } else {
            this.iUN.crz();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.iUW);
        userMuteAddAndDelCustomMessage.setTag(this.iUW);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gr(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("bubble_link", "");
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
    public void aG(Context context, String str) {
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
                return com.baidu.tbadk.m.e.aQY().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.iUL != null) {
            if (this.iUL.crP() != null && this.iUL.crP().aPn() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.iUL.crP().aPn().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.iUL.cnz(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.eeG;
    }

    public boolean crq() {
        if (this.iUL != null) {
            return this.iUL.crq();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.iUN.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iIi.getPageActivity());
        if (aq.isEmpty(str)) {
            aVar.sS(this.iIi.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.sS(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.iUN.showLoadingDialog();
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
        aVar.b(this.iIi).aEC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vr(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iIi.getPageActivity());
        aVar.sS(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.iIi).aEC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.sS(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.iIi).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.iIi.getPageActivity(), 2, true, 4);
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
        aVar.b(this.iIi).aEC();
    }

    public SubPbModel crr() {
        return this.iUL;
    }

    public int ckH() {
        if (this.iUL != null) {
            return this.iUL.ckH();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.dxj && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.dxj && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void mP(boolean z) {
        if (this.hhd != null && this.hhd.getText() != null) {
            int selectionEnd = this.hhd.getSelectionEnd();
            SpannableStringBuilder a2 = this.hhc.a(this.hhd.getText());
            if (a2 != null) {
                this.hhc.tH(true);
                this.hhd.setText(a2);
                if (z && this.hhc.cUe() >= 0) {
                    this.hhd.requestFocus();
                    this.hhd.setSelection(this.hhc.cUe());
                } else {
                    this.hhd.setSelection(selectionEnd);
                }
                this.hhc.tG(this.hhc.cUe() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hPT != null && this.hPT.aOu() != null && this.hPT.aOu().aOw()) {
            this.hPT.aOu().aMR();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.d.a(pVar, getUniqueId(), this);
    }

    public String cpn() {
        if (!aq.isEmpty(this.iPF)) {
            return this.iPF;
        }
        this.iPF = getResources().getString(com.baidu.tieba.pb.pb.main.am.cpc());
        return this.iPF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.iUZ = z;
        qJ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qJ(boolean z) {
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
        if (this.iUN != null && this.iUN.getListView() != null && this.iVa != null && this.iVa.mPosition != -1) {
            final int headerViewsCount = this.iVa.mPosition + this.iUN.getListView().getHeaderViewsCount();
            if (this.iVa.getView() != null) {
                final int height = this.iVa.getView().getHeight() - ((rect.height() - this.iUN.getNavigationBarHeight()) - this.iUN.crL());
                if (height > 0) {
                    this.iUN.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.iUN != null && NewSubPbActivity.this.iUN.getListView() != null) {
                                NewSubPbActivity.this.iUN.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.iUN.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.iUN.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.iUN != null && NewSubPbActivity.this.iUN.getListView() != null) {
                                NewSubPbActivity.this.iUN.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.iUN.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }

    private void cnf() {
        if (this.iUL != null && !aq.isEmpty(this.iUL.cnz())) {
            com.baidu.tbadk.BdToken.c.axz().o(com.baidu.tbadk.BdToken.b.cGM, com.baidu.adp.lib.f.b.toLong(this.iUL.cnz(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.iUL == null || aq.isEmpty(this.iUL.cnz())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.iUL.cnz(), 0L);
    }
}
