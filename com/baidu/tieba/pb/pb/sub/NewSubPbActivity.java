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
/* loaded from: classes7.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, h, com.baidu.tieba.pb.pb.a<NewSubPbActivity> {
    private static String iTc = "tbgametype";
    private View.OnClickListener ain;
    private com.baidu.adp.lib.d.b<ImageView> dIh;
    private com.baidu.adp.lib.d.b<GifView> dIi;
    private com.baidu.adp.lib.d.b<TextView> dKV;
    private com.baidu.adp.lib.d.b<View> dKW;
    private com.baidu.adp.lib.d.b<LinearLayout> dKX;
    private com.baidu.adp.lib.d.b<RelativeLayout> dKY;
    private au gOz;
    private VoiceManager gmi;
    private com.baidu.tieba.frs.profession.permission.c gpJ;
    private com.baidu.tbadk.editortools.pb.h hNH;
    public aj hNy;
    private com.baidu.tieba.write.c heO;
    private EditText heP;
    private com.baidu.tieba.pb.pb.main.b.a iCz;
    private com.baidu.tieba.pb.pb.report.a iFU;
    private com.baidu.tbadk.baseEditMark.a iFV;
    private e iGq;
    private com.baidu.tbadk.core.view.d iGr;
    private com.baidu.adp.widget.ImageView.a iGu;
    private String iGv;
    private TbRichTextMemeInfo iGw;
    private PostWriteCallBackData iHZ;
    private String iNW;
    private SubPbModel iTd;
    private ForumManageModel iTe;
    private com.baidu.tieba.pb.pb.sub.a iTf;
    private z iTg;
    private AbsListView.OnScrollListener iTh;
    private TbRichTextView.i iTi;
    private SubPbModel.a iTj;
    private com.baidu.adp.base.d iTk;
    private BdUniqueId iTo;
    private f<m> iTq;
    private boolean iTr;
    private l iTs;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int iHc = 0;
    PostData hfx = null;
    private a.InterfaceC0364a iGZ = null;
    private a iTl = null;
    private a iTm = null;
    private boolean eap = false;
    private boolean iTn = false;
    private boolean iTp = false;
    private boolean dsP = false;
    private com.baidu.tbadk.editortools.pb.c dum = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aMt() {
            NewSubPbActivity.this.iTf.cqd();
        }
    };
    private int iBL = 0;
    private boolean aWz = false;
    private com.baidu.tbadk.editortools.pb.b dun = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aMs() {
            if (!NewSubPbActivity.this.heO.cSM()) {
                return (NewSubPbActivity.this.hNy == null || NewSubPbActivity.this.iTd == null || NewSubPbActivity.this.iTd.bBu() == null || NewSubPbActivity.this.hNy.ax(NewSubPbActivity.this.iTd.bBu().replyPrivateFlag, aj.cVU)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.heO.cSO());
            if (NewSubPbActivity.this.hNH.aMJ()) {
                NewSubPbActivity.this.hNH.a(NewSubPbActivity.this.iHZ);
            }
            NewSubPbActivity.this.mN(true);
            return true;
        }
    };
    private NewWriteModel.d heV = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.z zVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.hNH != null && NewSubPbActivity.this.hNH.aLV() != null) {
                NewSubPbActivity.this.hNH.aLV().hide();
                if (NewSubPbActivity.this.iTd.cqB()) {
                    TiebaStatic.log(new an("c10367").cp("post_id", NewSubPbActivity.this.iTd.aMq()));
                }
            }
            if (z) {
                NewSubPbActivity.this.heO.Kx(null);
                NewSubPbActivity.this.heO.aV(null);
                NewSubPbActivity.this.heO.tC(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.heO.aV(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.heO.Kx(postWriteCallBackData.getErrorString());
                if (!v.isEmpty(NewSubPbActivity.this.heO.cSK())) {
                    NewSubPbActivity.this.iHZ = postWriteCallBackData;
                    if (NewSubPbActivity.this.hNH.aMJ()) {
                        NewSubPbActivity.this.hNH.a(NewSubPbActivity.this.iHZ);
                    }
                    NewSubPbActivity.this.mN(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.hNy != null) {
                NewSubPbActivity.this.hNy.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.iTf.cqe();
        }
    };
    private CustomMessageListener iGR = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iTo) {
                NewSubPbActivity.this.iTf.boJ();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.iGr.showSuccessToast(NewSubPbActivity.this.iGq.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.iGq.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.uZ(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.clF();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.iGq.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.iGr.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener iGS = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iTo) {
                NewSubPbActivity.this.iTf.boJ();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.iGr.showSuccessToast(NewSubPbActivity.this.iGq.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.iGq.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.iGr.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener iGT = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iTo) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.iTf.boJ();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.ktC;
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
                    NewSubPbActivity.this.iTf.a(sparseArray, z);
                }
            }
        }
    };
    boolean iHd = false;
    private final b.a iHf = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.iGu != null && !TextUtils.isEmpty(NewSubPbActivity.this.iGv)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.iGw == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.iGv));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.iGv;
                        aVar.pkgId = NewSubPbActivity.this.iGw.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.iGw.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.gOz == null) {
                            NewSubPbActivity.this.gOz = new au(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.gOz.j(NewSubPbActivity.this.iGv, NewSubPbActivity.this.iGu.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.iGu = null;
                NewSubPbActivity.this.iGv = null;
            }
        }
    };
    private CustomMessageListener hrx = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener gnx = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    com.baidu.tbadk.data.m mVar = (com.baidu.tbadk.data.m) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.iTd.cqu() != null && NewSubPbActivity.this.iTd.cqu().cjF() != null && NewSubPbActivity.this.iTd.cqu().cjF().azX() != null && currentAccount.equals(NewSubPbActivity.this.iTd.cqu().cjF().azX().getUserId()) && NewSubPbActivity.this.iTd.cqu().cjF().azX().getPendantData() != null) {
                        NewSubPbActivity.this.iTd.cqu().cjF().azX().getPendantData().sk(mVar.ayq());
                        NewSubPbActivity.this.iTd.cqu().cjF().azX().getPendantData().bE(mVar.aLA());
                        NewSubPbActivity.this.iTf.a(NewSubPbActivity.this.iTd.cqu(), NewSubPbActivity.this.iTd.cqu().cjF(), NewSubPbActivity.this.iTd.cqu().bVR(), NewSubPbActivity.this.iTd.cqu().aww(), NewSubPbActivity.this.iTd.cje(), NewSubPbActivity.this.iTd.cqH() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void callback(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        av(bundle);
        if (getIntent() != null) {
            this.aWz = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_FROM_SCHEMA, false);
        }
        super.onCreate(bundle);
        this.iGq = getPageContext();
        this.iTn = true;
        this.heO = new com.baidu.tieba.write.c();
        this.heO.DV(R.color.cp_cont_h_alpha85);
        this.heO.DU(R.color.cp_cont_a);
        initListeners();
        cpT();
        initData(bundle);
        initUI();
        ((SubPbView) this.iTf.getRootView()).show();
        oh(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.iTf.qI(this.aWz);
        this.iGr = new com.baidu.tbadk.core.view.d();
        this.iGr.toastTime = 1000L;
        registerListener(this.iGT);
        registerListener(this.iGR);
        registerListener(this.iGS);
        this.iTo = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.iTo;
        userMuteAddAndDelCustomMessage.setTag(this.iTo);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.iTo;
        userMuteCheckCustomMessage.setTag(this.iTo);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.hNy = new aj(getPageContext());
        this.hNy.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tbadk.core.util.aj.a
            public void k(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.hNH.aMQ();
                }
            }
        });
        this.iFU = new com.baidu.tieba.pb.pb.report.a(this);
        this.iFU.t(getUniqueId());
        this.iCz = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.iTf = new com.baidu.tieba.pb.pb.sub.a(this, this.ain);
        this.iTf.a(this.iTd);
        setContentView(this.iTf.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.iTf.setOnScrollListener(this.iTh);
        this.iTf.b(this);
        this.iTf.setOnImageClickListener(this.iTi);
        this.iTf.setOnLongClickListener(this.mOnLongClickListener);
        this.iTf.f(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.iTd != null) {
                    NewSubPbActivity.this.iTd.loadData();
                }
            }
        });
        this.iTf.a(this.iTl);
        this.iTf.b(this.iTm);
        if (this.iTd != null && this.iTd.cpV() && !this.iTd.cqG()) {
            this.iTf.cqj().setVisibility(8);
        } else {
            this.iTf.cqj().setVisibility(0);
        }
        if (this.iTd != null && !this.iTd.cpV()) {
            this.iTf.setIsFromPb(false);
        }
    }

    private boolean av(Bundle bundle) {
        if (bundle != null) {
            this.dsP = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.dsP = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.dsP;
    }

    public void initData(Bundle bundle) {
        this.iTd = new SubPbModel(getPageContext());
        this.iTd.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void q(PostData postData) {
                NewSubPbActivity.this.iTf.s(postData);
                NewSubPbActivity.this.iTf.b((BdListView.e) null);
            }
        });
        this.iTe = new ForumManageModel(getPageContext());
        this.iTe.setLoadDataCallBack(this.iTk);
        this.gmi = new VoiceManager();
        this.gmi.onCreate(getPageContext());
        this.iFV = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.iFV != null) {
            this.iFV.a(this.iGZ);
        }
        if (bundle != null) {
            this.iTd.initWithBundle(bundle);
        } else {
            this.iTd.initWithIntent(getIntent());
        }
        this.iTd.a(this.iTj);
        if (this.iTd.cpV()) {
            this.iTd.loadData();
        } else {
            this.iTd.cqz();
        }
    }

    public void cpT() {
        this.iTj = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, m mVar) {
                if (NewSubPbActivity.this.iTf != null) {
                    NewSubPbActivity.this.iTf.cqe();
                    if (!z) {
                        NewSubPbActivity.this.aX(i, str);
                        return;
                    }
                    NewSubPbActivity.this.iTf.hideNoDataView();
                    if (mVar != null) {
                        if (mVar.cjF() != null || NewSubPbActivity.this.iTd != null) {
                            mVar.cjF().a(NewSubPbActivity.this.iTd.cqF());
                        }
                        if (NewSubPbActivity.this.iTf != null) {
                            NewSubPbActivity.this.oh(mVar.axQ() != null && mVar.axQ().isBjh());
                            if (NewSubPbActivity.this.hNH != null && NewSubPbActivity.this.hNH.aLV() != null) {
                                NewSubPbActivity.this.hNH.aLV().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.iTf.a(mVar, NewSubPbActivity.this.iTd.cje(), NewSubPbActivity.this.iTd.cqH() != null);
                            if (NewSubPbActivity.this.iTn) {
                                NewSubPbActivity.this.cpU();
                                NewSubPbActivity.this.iTn = false;
                            }
                        }
                        if (NewSubPbActivity.this.hNH != null) {
                            NewSubPbActivity.this.hNH.a(mVar.bBu());
                            NewSubPbActivity.this.hNH.setThreadData(mVar.axQ());
                        }
                        if (NewSubPbActivity.this.iTq == null) {
                            NewSubPbActivity.this.iTq = new com.baidu.tieba.pb.f();
                        }
                        NewSubPbActivity.this.iTq.setData(mVar);
                        NewSubPbActivity.this.iTq.setType(0);
                        NewSubPbActivity.this.hNy.a(NewSubPbActivity.this.iTd.cqK());
                    }
                }
            }
        };
        this.iGZ = new a.InterfaceC0364a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0364a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.iFV != null) {
                        NewSubPbActivity.this.iFV.ff(z2);
                    }
                    MarkData awz = NewSubPbActivity.this.iFV.awz();
                    com.baidu.tieba.pb.f fVar = new com.baidu.tieba.pb.f();
                    fVar.setType(2);
                    if (z2) {
                        fVar.setData(awz);
                        if (NewSubPbActivity.this.iFV != null) {
                            if (awz != null) {
                                NewSubPbActivity.this.iTd.qK(true);
                                NewSubPbActivity.this.iTd.Ge(NewSubPbActivity.this.iTd.aMq());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.iTf != null) {
                                NewSubPbActivity.this.iTf.qJ(true);
                            }
                        }
                    } else {
                        fVar.setData(null);
                        NewSubPbActivity.this.iTd.qK(false);
                        NewSubPbActivity.this.iTd.Ge(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.iTf != null) {
                            NewSubPbActivity.this.iTf.qJ(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, fVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.iTl = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.iTd.cqu() != null && NewSubPbActivity.this.iTd.cqu().axQ() != null && NewSubPbActivity.this.iTd.cqu().axQ().azX() != null) {
                    str = String.valueOf(NewSubPbActivity.this.iTd.cqu().axQ().azX().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.iTd.cqu().aMO().getId(), NewSubPbActivity.this.iTd.cqu().aMO().getName(), NewSubPbActivity.this.iTd.cqu().axQ().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.iTm = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.iTe.cKm() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.iTd != null && NewSubPbActivity.this.iTd.cqu() != null && NewSubPbActivity.this.iTd.cqu().aMO() != null && NewSubPbActivity.this.iTd.cqu().axQ() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.iTe.IT(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.iTe.a(NewSubPbActivity.this.iTd.cqu().aMO().getId(), NewSubPbActivity.this.iTd.cqu().aMO().getName(), NewSubPbActivity.this.iTd.cqu().axQ().getId(), valueOf, i2, i, z, NewSubPbActivity.this.iTd.cqu().axQ().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.iTk = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.iTf.a(NewSubPbActivity.this.iTe.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.iTe.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.iUl != 1002 || bVar.eHK) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.iTf.a(1, dVar.mSuccess, dVar.khZ, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean cw(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void initListeners() {
        registerListener(this.gnx);
        this.ain = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v65, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray sparseArray;
                if (view != null || NewSubPbActivity.this.iTf != null) {
                    if (view == NewSubPbActivity.this.iTf.cqp()) {
                        NewSubPbActivity.this.iTf.coF();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ba.aEt().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.iTf.bGK()) {
                        if (view != NewSubPbActivity.this.iTf.cqi()) {
                            if (view != NewSubPbActivity.this.iTf.cqh()) {
                                if (view == NewSubPbActivity.this.iTf.cqc()) {
                                    NewSubPbActivity.this.iTf.coF();
                                    if (NewSubPbActivity.this.iTd.loadData()) {
                                        NewSubPbActivity.this.iTf.cqa();
                                    }
                                } else if (view == NewSubPbActivity.this.iTf.cqj() || view == NewSubPbActivity.this.iTf.cqk() || view == NewSubPbActivity.this.iTf.cqm()) {
                                    if (NewSubPbActivity.this.iTp) {
                                        NewSubPbActivity.this.iTp = false;
                                        return;
                                    }
                                    if ((NewSubPbActivity.this.iTd.cqu() == null || NewSubPbActivity.this.iTd.cqu().axQ() == null) ? false : com.baidu.tbadk.core.util.au.a(NewSubPbActivity.this.iTd.cqu().axQ().getBaijiahaoData())) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.iTd.cmc(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.iTd.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.iTd.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.iTd.cqu() != null && NewSubPbActivity.this.iTd.cqu().axQ() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.iTd.cqu().axQ().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.iTd.cmc(), NewSubPbActivity.this.iTd.aMq(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.iTd.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.iTd.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.iTf.cqn() == null || view != NewSubPbActivity.this.iTf.cqn().cnc()) {
                                    if (NewSubPbActivity.this.iTf.cqn() == null || view != NewSubPbActivity.this.iTf.cqn().cnf()) {
                                        if (NewSubPbActivity.this.iTf.cqn() == null || view != NewSubPbActivity.this.iTf.cqn().cnd()) {
                                            if (NewSubPbActivity.this.iTf.cqn() == null || view != NewSubPbActivity.this.iTf.cqn().cne()) {
                                                if (NewSubPbActivity.this.iTf.cqn() == null || view != NewSubPbActivity.this.iTf.cqn().cng()) {
                                                    if (view == NewSubPbActivity.this.iTf.cqg() || view == NewSubPbActivity.this.iTf.cqm()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.hNH.aMT()) {
                                                                NewSubPbActivity.this.hNH.aMU();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.hNH.va(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof l)) {
                                                        if (NewSubPbActivity.this.iTg == null || view != NewSubPbActivity.this.iTg.cne()) {
                                                            if (NewSubPbActivity.this.iTg == null || view != NewSubPbActivity.this.iTg.cnc()) {
                                                                if (NewSubPbActivity.this.iTg == null || view != NewSubPbActivity.this.iTg.cnf()) {
                                                                    if (NewSubPbActivity.this.iTg == null || view != NewSubPbActivity.this.iTg.cng()) {
                                                                        if (NewSubPbActivity.this.iTg == null || view != NewSubPbActivity.this.iTg.cni()) {
                                                                            if (NewSubPbActivity.this.iTg == null || view != NewSubPbActivity.this.iTg.cnj()) {
                                                                                if (NewSubPbActivity.this.iTg != null && view == NewSubPbActivity.this.iTg.cnd()) {
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
                                                                                            NewSubPbActivity.this.iTf.cB(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.iTf.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.aDr().getString("tail_link", "");
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
                                                                                        if (postData.getType() != PostData.kfn && !TextUtils.isEmpty(postData.getBimg_url()) && i.axy().isShowImages()) {
                                                                                            NewSubPbActivity.this.Gb(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.iGu != null && !TextUtils.isEmpty(NewSubPbActivity.this.iGv)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.gOz == null) {
                                                                                        NewSubPbActivity.this.gOz = new au(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.gOz.j(NewSubPbActivity.this.iGv, NewSubPbActivity.this.iGu.getImageByte());
                                                                                    NewSubPbActivity.this.iGu = null;
                                                                                    NewSubPbActivity.this.iGv = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.iGu != null && !TextUtils.isEmpty(NewSubPbActivity.this.iGv)) {
                                                                            if (NewSubPbActivity.this.iGw == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.iGv));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.iGv;
                                                                                aVar.pkgId = NewSubPbActivity.this.iGw.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.iGw.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.iGu = null;
                                                                            NewSubPbActivity.this.iGv = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.hfx != null) {
                                                                        NewSubPbActivity.this.hfx.fv(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.hfx = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.iTf.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.cv(view);
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
                                                                NewSubPbActivity.this.FA((String) tag);
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
                                                        NewSubPbActivity.this.iTs = (l) view.getTag();
                                                        if (bc.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.iTp) {
                                                                NewSubPbActivity.this.iTp = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.hNy == null || NewSubPbActivity.this.iTd == null || NewSubPbActivity.this.iTd.bBu() == null || NewSubPbActivity.this.hNy.kb(NewSubPbActivity.this.iTd.bBu().replyPrivateFlag)) && (sparseArray = (SparseArray) view.getTag(R.id.tag_from)) != null) {
                                                                if (sparseArray.get(R.id.tag_clip_board) instanceof PostData) {
                                                                    PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                    if (postData2 != null && postData2.azX() != null) {
                                                                        MetaData azX = postData2.azX();
                                                                        NewSubPbActivity.this.hNH.setReplyId(azX.getUserId());
                                                                        if (!(sparseArray.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue() : true)) {
                                                                            NewSubPbActivity.this.hNH.vb("");
                                                                        } else {
                                                                            NewSubPbActivity.this.hNH.vb(azX.getName_show());
                                                                        }
                                                                    }
                                                                    NewSubPbActivity.this.iTf.cpY();
                                                                }
                                                                if (NewSubPbActivity.this.iTr) {
                                                                    NewSubPbActivity.this.qH(false);
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
                                            TiebaStatic.log(new an("c11739").Z("obj_locate", 4));
                                            if (!j.isNetWorkAvailable()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.iTf.coF();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.FA(str4);
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
                                            NewSubPbActivity.this.iTf.coF();
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
                                    NewSubPbActivity.this.iTf.coF();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.iTf.a(((Integer) sparseArray7.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray7.get(R.id.tag_del_post_id), ((Integer) sparseArray7.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new an("c11739").Z("obj_locate", 2));
                                    NewSubPbActivity.this.iTf.coF();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.iTd.cqu() != null) {
                                        NewSubPbActivity.this.k(NewSubPbActivity.this.iTd.cqu().cjF());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.iTf.cpX();
                                NewSubPbActivity.this.iTf.cpY();
                                if (NewSubPbActivity.this.hNH != null) {
                                    NewSubPbActivity.this.hNH.aMW();
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.iTf.cpX();
                            NewSubPbActivity.this.iTf.cpY();
                            if (NewSubPbActivity.this.hNH != null) {
                                NewSubPbActivity.this.hNH.aMV();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.clc();
                        if (NewSubPbActivity.this.iTd != null && NewSubPbActivity.this.iTd.cqu() != null && NewSubPbActivity.this.iTd.cqu().axQ() != null && NewSubPbActivity.this.iTd.cqu().axQ().azX() != null) {
                            TiebaStatic.log(new an("c13402").cp("tid", NewSubPbActivity.this.iTd.cmc()).s("fid", NewSubPbActivity.this.iTd.cqu().axQ().getFid()).Z("obj_locate", 5).cp("uid", NewSubPbActivity.this.iTd.cqu().axQ().azX().getUserId()));
                        }
                    }
                }
            }
        };
        this.iTh = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.iTf.coF();
                    if (NewSubPbActivity.this.iBL != 2 && NewSubPbActivity.this.iBL != 1) {
                        NewSubPbActivity.this.iTf.cqr();
                    }
                }
                NewSubPbActivity.this.hNH.aMU();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.iTf.cqo();
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
                if (NewSubPbActivity.this.iTf != null && NewSubPbActivity.this.iTf.cqf()) {
                    return false;
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null && NewSubPbActivity.this.cw(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.iGu = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.iGv = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.iGu == null || TextUtils.isEmpty(NewSubPbActivity.this.iGv)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.iGw = null;
                        } else {
                            NewSubPbActivity.this.iGw = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.iGu = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.iGv = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.iGw = null;
                        } else {
                            NewSubPbActivity.this.iGw = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.iGu = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.iGv = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.iGw = null;
                        } else {
                            NewSubPbActivity.this.iGw = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.iTf.a(NewSubPbActivity.this.iHf, NewSubPbActivity.this.iGu.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.hfx = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.hfx == null || NewSubPbActivity.this.iFV == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.iFV != null) {
                            NewSubPbActivity.this.iFV.ff(NewSubPbActivity.this.iTd.cqA());
                        }
                        boolean z = NewSubPbActivity.this.iFV.aww() && NewSubPbActivity.this.hfx.getId() != null && NewSubPbActivity.this.hfx.getId().equals(NewSubPbActivity.this.iTd.cqC());
                        if (NewSubPbActivity.this.iTg == null) {
                            NewSubPbActivity.this.iTg = new z(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.ain);
                            NewSubPbActivity.this.iTf.cF(NewSubPbActivity.this.iTg.getView());
                            NewSubPbActivity.this.iTg.pV(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.iTg.showDialog();
                        boolean z2 = NewSubPbActivity.this.pI(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z3 = (NewSubPbActivity.this.iTd.cqu() == null || NewSubPbActivity.this.iTd.cqu().axQ() == null || !NewSubPbActivity.this.iTd.cqu().axQ().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z) {
                            NewSubPbActivity.this.iTg.cnc().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.iTg.cnc().setText(R.string.mark);
                        }
                        if (booleanValue || z3) {
                            NewSubPbActivity.this.iTg.cnc().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.iTg.cnc().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.cw(view)) {
                            if (NewSubPbActivity.this.iGu != null && !NewSubPbActivity.this.iGu.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        NewSubPbActivity.this.iTg.a(sparseArray2, NewSubPbActivity.this.cje(), z2);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.iTi = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                        m cqu = NewSubPbActivity.this.iTd.cqu();
                        TbRichText bl = NewSubPbActivity.this.bl(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bl != null && bl.aRz() != null) {
                            tbRichTextData = bl.aRz().get(NewSubPbActivity.this.iHc);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.aRF().aRR()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (cqu == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (cqu.aMO() != null) {
                                        str4 = cqu.aMO().getName();
                                        str5 = cqu.aMO().getId();
                                    }
                                    if (cqu.axQ() != null) {
                                        str6 = cqu.axQ().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.iTd.cqH() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.iTd.cqH();
                                    z6 = NewSubPbActivity.this.iTd.cqJ();
                                    arrayList2 = NewSubPbActivity.this.iTd.cqI();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.getItem(arrayList2, 0));
                                ImageViewerConfig createConfig = new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false);
                                createConfig.setPostId(String.valueOf(bl.getPostId()));
                                createConfig.setThreadData(NewSubPbActivity.this.axQ());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                                return;
                            }
                            NewSubPbActivity.this.iHd = false;
                            String str7 = "";
                            TbRichText cJz = cqu.cjF().cJz();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(cJz, bl, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (cqu == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (cqu.aMO() != null) {
                                    str8 = cqu.aMO().getName();
                                    str9 = cqu.aMO().getId();
                                }
                                if (cqu.axQ() != null) {
                                    str10 = cqu.axQ().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.iTd.cqH() != null) {
                                concurrentHashMap = NewSubPbActivity.this.iTd.cqH();
                                z4 = NewSubPbActivity.this.iTd.cqJ();
                                arrayList = NewSubPbActivity.this.iTd.cqI();
                                i2 = a2 + NewSubPbActivity.this.iTd.getOffset();
                            } else {
                                concurrentHashMap = concurrentHashMap3;
                                i2 = a2;
                                z4 = z3;
                                arrayList = arrayList2;
                            }
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(v.getItem(arrayList, i2));
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList4, 0, str8, str9, str2, z4, str7, true, concurrentHashMap, true, false, false);
                            createConfig2.setThreadData(NewSubPbActivity.this.axQ());
                            createConfig2.setPostId(String.valueOf(bl.getPostId()));
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
    public bj axQ() {
        if (this.iTd == null || this.iTd.cqu() == null) {
            return null;
        }
        return this.iTd.cqu().axQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(View view) {
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
        TbRichTextImageInfo aRF;
        if (tbRichText == tbRichText2) {
            this.iHd = true;
        }
        if (tbRichText != null && tbRichText.aRz() != null) {
            int size = tbRichText.aRz().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.aRz().get(i6) != null && tbRichText.aRz().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.aRz().get(i6).aRF().getWidth() * equipmentDensity;
                    int height = tbRichText.aRz().get(i6).aRF().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.aRz().get(i6).aRF().aRR()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.aRz().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (aRF = tbRichTextData.aRF()) != null) {
                            String aRT = aRF.aRT();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = aRT;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.iHd) {
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
        if (this.iTg != null) {
            this.iTg.pV(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo aRF = tbRichTextData.aRF();
        if (aRF != null) {
            if (!StringUtils.isNull(aRF.aRQ())) {
                return aRF.aRQ();
            }
            if (aRF.getHeight() * aRF.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (aRF.getHeight() * aRF.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (aRF.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * aRF.getHeight())));
            } else {
                float width = aRF.getWidth() / aRF.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(aRF.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bl(String str, int i) {
        if (this.iTd == null || this.iTd.cqu() == null || str == null || i < 0) {
            return null;
        }
        m cqu = this.iTd.cqu();
        TbRichText a2 = a(cqu.cjF(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(cqu.cjF(), str, i);
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
        TbRichText cJz = postData.cJz();
        if (cJz != null) {
            ArrayList<TbRichTextData> aRz = cJz.aRz();
            int size = aRz.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (aRz.get(i3) != null && aRz.get(i3).getType() == 8) {
                    i2++;
                    if (aRz.get(i3).aRF().aRT().equals(str)) {
                        int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = aRz.get(i3).aRF().getWidth() * equipmentDensity;
                        int height = aRz.get(i3).aRF().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.iHc = i3;
                        return cJz;
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
    public void clc() {
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false) {
            if (this.hNy == null || this.iTd == null || this.iTd.bBu() == null || this.hNy.kb(this.iTd.bBu().replyPrivateFlag)) {
                if (this.hNH.aMJ()) {
                    this.hNH.a((PostWriteCallBackData) null);
                    return;
                }
                this.iTf.cpX();
                this.iTf.cpY();
                if (this.hNH != null) {
                    this.hNH.aMX();
                    return;
                }
                return;
            }
            return;
        }
        if (this.gpJ == null) {
            this.gpJ = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.gpJ.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lt(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void s(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lu(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.hNy == null || NewSubPbActivity.this.iTd == null || NewSubPbActivity.this.iTd.bBu() == null || NewSubPbActivity.this.hNy.kb(NewSubPbActivity.this.iTd.bBu().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.hNH.aMJ()) {
                                NewSubPbActivity.this.hNH.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.iTf.cpX();
                            NewSubPbActivity.this.iTf.cpY();
                            if (NewSubPbActivity.this.hNH != null) {
                                NewSubPbActivity.this.hNH.aMX();
                            }
                        }
                    }
                }
            });
        }
        if (this.iTd != null && this.iTd.cqu() != null && this.iTd.cqu().aMO() != null) {
            this.gpJ.C(this.iTd.cqu().aMO().getId(), com.baidu.adp.lib.f.b.toLong(this.iTd.cmc(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pI(boolean z) {
        if (this.iTd == null) {
            return false;
        }
        return ((cje() != 0) || this.iTd.cqu() == null || this.iTd.cqu().axQ() == null || this.iTd.cqu().axQ().azX() == null || this.iTd.cqu().axQ().aBV() || TextUtils.equals(this.iTd.cqu().axQ().azX().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private void t(Context context, String str, String str2) {
        long templateId = this.iTd.cqu().cjF().cJG() != null ? this.iTd.cqu().cjF().cJG().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ba.aEt().b(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.iTd.cqu().aMO().getId(), this.iTd.cqu().aMO().getName(), this.iTd.cqu().axQ().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(int i, String str) {
        if (this.iTd.cqv()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.isNetOk()) {
            if (i == 4) {
                this.iTf.zw(str + "(4)");
            } else {
                this.iTf.wi(R.string.no_data_text);
            }
        } else {
            this.iTf.wi(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oh(boolean z) {
        this.hNH = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dR(getActivity());
        if (this.hNH != null) {
            this.hNH.a(getPageContext());
            this.hNH.b(this.iTd);
            this.hNH.b(this.heV);
            this.hNH.a(this.dum);
            this.hNH.a(this.dun);
            this.hNH.aLV().gu(true);
            this.hNH.g(getPageContext());
        }
        if (this.iTf != null) {
            this.iTf.i(this.hNH);
        }
        if (this.hNH != null && this.iTd != null) {
            this.hNH.a(this.iTd.bBu());
            this.hNH.aMU();
        }
        if (this.hNH != null) {
            this.hNH.aMY().setDefaultHint(cnT());
            this.hNH.aMY().setHint(cnT());
            this.heP = this.hNH.aMY().getInputView();
            this.heP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.heO != null) {
                        if (!NewSubPbActivity.this.heO.cSN()) {
                            NewSubPbActivity.this.mN(false);
                        }
                        NewSubPbActivity.this.heO.tD(false);
                    }
                }
            });
        }
    }

    public void cpU() {
        if (!TbadkCoreApplication.isLogin()) {
            this.hNH.aMU();
        } else if (!StringUtils.isNull(this.iTd.cqD())) {
            if (this.iTf.cqb() && com.baidu.adp.lib.util.l.isNetOk()) {
                this.iTf.bzy();
            } else {
                this.iTf.cqe();
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
                    this.iTf.cB(view);
                }
            } else if (booleanValue2) {
                this.iTf.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.iTf.cql(), getPageContext().getPageActivity());
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.iTo);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.iTo);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).aCq();
        }
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.iTf.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.iTo;
        userMuteCheckCustomMessage.setTag(this.iTo);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.iTf.a(0, bVar.mSuccess, bVar.khZ, z);
            if (bVar.mSuccess) {
                if (bVar.fVU == 1) {
                    if (this.iTf.getListView() instanceof BdTypeListView) {
                        List<com.baidu.adp.widget.ListView.m> data = ((BdTypeListView) this.iTf.getListView()).getData();
                        if (!v.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.iTf.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.fVU == 2) {
                    this.iTd.Gd(bVar.mPostId);
                    this.iTf.a(this.iTd.cqu(), this.iTd.cje(), this.iTd.cqH() != null);
                    if (this.iTd.cqE()) {
                        this.iTd.qL(false);
                        this.iTf.cpZ();
                        this.iTd.loadData();
                    }
                }
                com.baidu.tieba.pb.f fVar = new com.baidu.tieba.pb.f();
                fVar.setData(bVar);
                fVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, fVar));
            }
        }
    }

    public void FA(String str) {
        if (this.iTd != null && this.iTd.cqu() != null && this.iTd.cqu().axQ() != null && this.iTd.cqu().axQ().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.iTd.cmc(), str);
            bj axQ = this.iTd.cqu().axQ();
            if (axQ.ayL()) {
                format = format + "&channelid=33833";
            } else if (axQ.aBR()) {
                format = format + "&channelid=33842";
            } else if (axQ.aBS()) {
                format = format + "&channelid=33840";
            }
            FB(format);
            return;
        }
        this.iFU.Ga(str);
    }

    private void FB(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void k(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.iTd.cqA() && postData.getId() != null && postData.getId().equals(this.iTd.cqC())) {
                z = true;
            }
            MarkData l = this.iTd.l(postData);
            if (l != null) {
                this.iTf.coF();
                if (this.iFV != null) {
                    this.iFV.a(l);
                    if (!z) {
                        this.iFV.awy();
                    } else {
                        this.iFV.awx();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.iTd != null) {
            this.iTd.au(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.hNH != null) {
            this.hNH.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.hNH.aLV().aKs();
        this.hNH.aMU();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.hNH.b(writeData);
                this.hNH.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l lX = this.hNH.aLV().lX(6);
                if (lX != null && lX.dss != null) {
                    lX.dss.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.hNH.aMQ();
                }
                this.iTf.cqr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gmi != null) {
            this.gmi.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.eap = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.avj().avo();
        if (this.gmi != null) {
            this.gmi.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.hrx);
        this.iTf.bIL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eap = false;
        super.onResume();
        clI();
        if (this.gmi != null) {
            this.gmi.onResume(getPageContext());
        }
        registerListener(this.hrx);
        this.iTf.bIM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gmi != null) {
            this.gmi.onStop(getPageContext());
        }
        this.hNH.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.iTq));
        this.iTd.cancelLoadData();
        this.iTd.destory();
        this.iTe.cancelLoadData();
        if (this.gmi != null) {
            this.gmi.onDestory(getPageContext());
        }
        this.iTf.coF();
        this.iTf.ags();
        MessageManager.getInstance().unRegisterListener(this.iGR);
        MessageManager.getInstance().unRegisterListener(this.iGS);
        MessageManager.getInstance().unRegisterListener(this.iGT);
        MessageManager.getInstance().unRegisterListener(this.iTo);
        this.iGq = null;
        this.iGr = null;
        if (this.hNy != null) {
            this.hNy.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iTf.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gmi;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View cqg = this.iTf.cqg();
        if (cqg == null || (findViewWithTag = cqg.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean FT(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = ba.getParamPair(ba.getParamStr(str))) != null) {
            this.iTp = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return FT(k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(iTc);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (FT(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                    lVar.mLink = str;
                    lVar.type = 3;
                    lVar.drv = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
                }
            } else {
                ba.aEt().b(getPageContext(), new String[]{str});
            }
            this.iTp = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aC(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iTp = true;
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
        if (this.iTf != null) {
            return this.iTf.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int aSg() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> aSi() {
        if (this.dKV == null) {
            this.dKV = TbRichTextView.z(getPageContext().getPageActivity(), 8);
        }
        return this.dKV;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> aSj() {
        if (this.dIi == null) {
            this.dIi = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bFv */
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
        return this.dIi;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> aSh() {
        if (this.dIh == null) {
            this.dIh = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aSt */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.axy().isShowImages();
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
                        if (i.axy().isShowImages()) {
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
        return this.dIh;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> aSk() {
        if (this.dKW == null) {
            this.dKW = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: clP */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(NewSubPbActivity.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cx */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cy */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cz */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.dKW;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> aSl() {
        if (this.dKX == null) {
            this.dKX = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: clR */
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
        return this.dKX;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> aSm() {
        this.dKY = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: clQ */
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
        return this.dKY;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cjQ() {
        return this.iCz;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cjR() {
        return (this.iTd == null || this.iTd.cqu() == null || this.iTd.cqu().axQ() == null || this.iTd.cqu().axQ().aBr()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cjS() {
        if (this.iTd == null || this.iTd.cqu() == null || this.iTd.cqu().axQ() == null) {
            return null;
        }
        return this.iTd.cqu().axQ().aAc();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cjT() {
        if (this.iTd == null) {
            return 0;
        }
        return this.iTd.cje();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Fv(String str) {
        if (StringUtils.isNull(str) || this.iTd == null || this.iTd.cqu() == null || this.iTd.cqu().axQ() == null || this.iTd.cqu().axQ().azX() == null) {
            return false;
        }
        return str.equals(this.iTd.cqu().axQ().azX().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.iTf.cqb() && com.baidu.adp.lib.util.l.isNetOk()) {
            this.iTd.loadData();
        } else {
            this.iTf.cqe();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.iTo);
        userMuteAddAndDelCustomMessage.setTag(this.iTo);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gb(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString("bubble_link", "");
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
                return com.baidu.tbadk.m.e.aOF().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.iTd != null) {
            if (this.iTd.cqu() != null && this.iTd.cqu().aMO() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.iTd.cqu().aMO().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.iTd.cmc(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.eap;
    }

    public boolean cpV() {
        if (this.iTd != null) {
            return this.iTd.cpV();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.iTf.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iGq.getPageActivity());
        if (aq.isEmpty(str)) {
            aVar.sC(this.iGq.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.sC(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.iTf.showLoadingDialog();
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
        aVar.b(this.iGq).aCp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uZ(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iGq.getPageActivity());
        aVar.sC(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.iGq).aCp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.sC(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.iGq).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.iGq.getPageActivity(), 2, true, 4);
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
        aVar.b(this.iGq).aCp();
    }

    public SubPbModel cpW() {
        return this.iTd;
    }

    public int cje() {
        if (this.iTd != null) {
            return this.iTd.cje();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.dsP && !this.aWz) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.dsP && !this.aWz) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void mN(boolean z) {
        if (this.heP != null && this.heP.getText() != null) {
            int selectionEnd = this.heP.getSelectionEnd();
            SpannableStringBuilder a2 = this.heO.a(this.heP.getText());
            if (a2 != null) {
                this.heO.tD(true);
                this.heP.setText(a2);
                if (z && this.heO.cSL() >= 0) {
                    this.heP.requestFocus();
                    this.heP.setSelection(this.heO.cSL());
                } else {
                    this.heP.setSelection(selectionEnd);
                }
                this.heO.tC(this.heO.cSL() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hNH != null && this.hNH.aLV() != null && this.hNH.aLV().aLX()) {
            this.hNH.aLV().aKs();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.d.a(pVar, getUniqueId(), this);
    }

    public String cnT() {
        if (!aq.isEmpty(this.iNW)) {
            return this.iNW;
        }
        this.iNW = getResources().getString(ap.cnI());
        return this.iNW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.iTr = z;
        qH(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qH(boolean z) {
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
        if (this.iTf != null && this.iTf.getListView() != null && this.iTs != null && this.iTs.mPosition != -1) {
            final int headerViewsCount = this.iTs.mPosition + this.iTf.getListView().getHeaderViewsCount();
            if (this.iTs.getView() != null) {
                final int height = this.iTs.getView().getHeight() - ((rect.height() - this.iTf.getNavigationBarHeight()) - this.iTf.cqq());
                if (height > 0) {
                    this.iTf.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.iTf != null && NewSubPbActivity.this.iTf.getListView() != null) {
                                NewSubPbActivity.this.iTf.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.iTf.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.iTf.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.iTf != null && NewSubPbActivity.this.iTf.getListView() != null) {
                                NewSubPbActivity.this.iTf.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.iTf.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }

    private void clI() {
        if (this.iTd != null && !aq.isEmpty(this.iTd.cmc())) {
            com.baidu.tbadk.BdToken.c.avj().o(com.baidu.tbadk.BdToken.b.cCM, com.baidu.adp.lib.f.b.toLong(this.iTd.cmc(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.iTd == null || aq.isEmpty(this.iTd.cmc())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.iTd.cmc(), 0L);
    }
}
