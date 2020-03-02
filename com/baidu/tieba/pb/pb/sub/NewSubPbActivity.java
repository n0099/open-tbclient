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
    private static String iUy = "tbgametype";
    private View.OnClickListener akt;
    private com.baidu.adp.lib.d.b<ImageView> dMn;
    private com.baidu.adp.lib.d.b<GifView> dMo;
    private com.baidu.adp.lib.d.b<TextView> dPb;
    private com.baidu.adp.lib.d.b<View> dPc;
    private com.baidu.adp.lib.d.b<LinearLayout> dPd;
    private com.baidu.adp.lib.d.b<RelativeLayout> dPe;
    private ar gQB;
    private VoiceManager gol;
    private com.baidu.tieba.frs.profession.permission.c grM;
    private com.baidu.tbadk.editortools.pb.h hPH;
    public aj hPy;
    private com.baidu.tieba.write.c hgQ;
    private EditText hgR;
    private com.baidu.tieba.pb.pb.main.b.a iEk;
    private com.baidu.tieba.pb.pb.report.a iHA;
    private com.baidu.tbadk.baseEditMark.a iHB;
    private e iHW;
    private com.baidu.tbadk.core.view.d iHX;
    private com.baidu.adp.widget.ImageView.a iIa;
    private String iIb;
    private TbRichTextMemeInfo iIc;
    private PostWriteCallBackData iJB;
    private String iPt;
    private ForumManageModel iUA;
    private com.baidu.tieba.pb.pb.sub.a iUB;
    private w iUC;
    private AbsListView.OnScrollListener iUD;
    private TbRichTextView.i iUE;
    private SubPbModel.a iUF;
    private com.baidu.adp.base.d iUG;
    private BdUniqueId iUK;
    private com.baidu.tieba.pb.e<l> iUM;
    private boolean iUN;
    private k iUO;
    private SubPbModel iUz;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int iIH = 0;
    PostData hhz = null;
    private a.InterfaceC0374a iIE = null;
    private a iUH = null;
    private a iUI = null;
    private boolean eet = false;
    private boolean iUJ = false;
    private boolean iUL = false;
    private boolean dwW = false;
    private com.baidu.tbadk.editortools.pb.c dyt = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aOR() {
            NewSubPbActivity.this.iUB.crx();
        }
    };
    private int iDG = 0;
    private boolean mIsFromSchema = false;
    private com.baidu.tbadk.editortools.pb.b dyu = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOQ() {
            if (!NewSubPbActivity.this.hgQ.cUe()) {
                return (NewSubPbActivity.this.hPy == null || NewSubPbActivity.this.iUz == null || NewSubPbActivity.this.iUz.bCY() == null || NewSubPbActivity.this.hPy.ax(NewSubPbActivity.this.iUz.bCY().replyPrivateFlag, aj.cZX)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.hgQ.cUg());
            if (NewSubPbActivity.this.hPH.aPh()) {
                NewSubPbActivity.this.hPH.a(NewSubPbActivity.this.iJB);
            }
            NewSubPbActivity.this.mP(true);
            return true;
        }
    };
    private NewWriteModel.d hgX = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.hPH != null && NewSubPbActivity.this.hPH.aOt() != null) {
                NewSubPbActivity.this.hPH.aOt().hide();
                if (NewSubPbActivity.this.iUz.crV()) {
                    TiebaStatic.log(new an("c10367").cy("post_id", NewSubPbActivity.this.iUz.aOO()));
                }
            }
            if (z) {
                NewSubPbActivity.this.hgQ.KK(null);
                NewSubPbActivity.this.hgQ.aU(null);
                NewSubPbActivity.this.hgQ.tG(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.hgQ.aU(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.hgQ.KK(postWriteCallBackData.getErrorString());
                if (!v.isEmpty(NewSubPbActivity.this.hgQ.cUc())) {
                    NewSubPbActivity.this.iJB = postWriteCallBackData;
                    if (NewSubPbActivity.this.hPH.aPh()) {
                        NewSubPbActivity.this.hPH.a(NewSubPbActivity.this.iJB);
                    }
                    NewSubPbActivity.this.mP(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.hPy != null) {
                NewSubPbActivity.this.hPy.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.iUB.cry();
        }
    };
    private CustomMessageListener iIw = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iUK) {
                NewSubPbActivity.this.iUB.bqr();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.iHX.showSuccessToast(NewSubPbActivity.this.iHW.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.iHW.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.vq(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.cnb();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.iHW.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.iHX.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener iIx = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iUK) {
                NewSubPbActivity.this.iUB.bqr();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.iHX.showSuccessToast(NewSubPbActivity.this.iHW.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.iHW.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.iHX.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener iIy = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iUK) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.iUB.bqr();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.kuG;
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
                    NewSubPbActivity.this.iUB.a(sparseArray, z);
                }
            }
        }
    };
    boolean iII = false;
    private final b.a iIK = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.iIa != null && !TextUtils.isEmpty(NewSubPbActivity.this.iIb)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.iIc == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.iIb));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.iIb;
                        aVar.pkgId = NewSubPbActivity.this.iIc.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.iIc.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.gQB == null) {
                            NewSubPbActivity.this.gQB = new ar(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.gQB.j(NewSubPbActivity.this.iIb, NewSubPbActivity.this.iIa.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.iIa = null;
                NewSubPbActivity.this.iIb = null;
            }
        }
    };
    private CustomMessageListener hty = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener gpA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    m mVar = (m) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.iUz.crO() != null && NewSubPbActivity.this.iUz.crO().clf() != null && NewSubPbActivity.this.iUz.crO().clf().aCo() != null && currentAccount.equals(NewSubPbActivity.this.iUz.crO().clf().aCo().getUserId()) && NewSubPbActivity.this.iUz.crO().clf().aCo().getPendantData() != null) {
                        NewSubPbActivity.this.iUz.crO().clf().aCo().getPendantData().sB(mVar.aAG());
                        NewSubPbActivity.this.iUz.crO().clf().aCo().getPendantData().bI(mVar.aNY());
                        NewSubPbActivity.this.iUB.a(NewSubPbActivity.this.iUz.crO(), NewSubPbActivity.this.iUz.crO().clf(), NewSubPbActivity.this.iUz.crO().bXu(), NewSubPbActivity.this.iUz.crO().ayL(), NewSubPbActivity.this.iUz.ckG(), NewSubPbActivity.this.iUz.csb() != null);
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
        this.iHW = getPageContext();
        this.iUJ = true;
        this.hgQ = new com.baidu.tieba.write.c();
        this.hgQ.Ea(R.color.cp_cont_h_alpha85);
        this.hgQ.DZ(R.color.cp_cont_a);
        initListeners();
        crn();
        initData(bundle);
        initUI();
        ((SubPbView) this.iUB.getRootView()).show();
        oj(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.iUB.qK(this.mIsFromSchema);
        this.iHX = new com.baidu.tbadk.core.view.d();
        this.iHX.toastTime = 1000L;
        registerListener(this.iIy);
        registerListener(this.iIw);
        registerListener(this.iIx);
        this.iUK = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.iUK;
        userMuteAddAndDelCustomMessage.setTag(this.iUK);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.iUK;
        userMuteCheckCustomMessage.setTag(this.iUK);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.hPy = new aj(getPageContext());
        this.hPy.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tbadk.core.util.aj.a
            public void l(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.hPH.aPo();
                }
            }
        });
        this.iHA = new com.baidu.tieba.pb.pb.report.a(this);
        this.iHA.t(getUniqueId());
        this.iEk = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.iUB = new com.baidu.tieba.pb.pb.sub.a(this, this.akt);
        this.iUB.a(this.iUz);
        setContentView(this.iUB.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.iUB.setOnScrollListener(this.iUD);
        this.iUB.b(this);
        this.iUB.setOnImageClickListener(this.iUE);
        this.iUB.setOnLongClickListener(this.mOnLongClickListener);
        this.iUB.f(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.iUz != null) {
                    NewSubPbActivity.this.iUz.loadData();
                }
            }
        });
        this.iUB.a(this.iUH);
        this.iUB.b(this.iUI);
        if (this.iUz != null && this.iUz.crp() && !this.iUz.csa()) {
            this.iUB.crD().setVisibility(8);
        } else {
            this.iUB.crD().setVisibility(0);
        }
        if (this.iUz != null && !this.iUz.crp()) {
            this.iUB.setIsFromPb(false);
        }
    }

    private boolean av(Bundle bundle) {
        if (bundle != null) {
            this.dwW = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.dwW = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.dwW;
    }

    public void initData(Bundle bundle) {
        this.iUz = new SubPbModel(getPageContext());
        this.iUz.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void p(PostData postData) {
                NewSubPbActivity.this.iUB.r(postData);
                NewSubPbActivity.this.iUB.b((BdListView.e) null);
            }
        });
        this.iUA = new ForumManageModel(getPageContext());
        this.iUA.setLoadDataCallBack(this.iUG);
        this.gol = new VoiceManager();
        this.gol.onCreate(getPageContext());
        this.iHB = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.iHB != null) {
            this.iHB.a(this.iIE);
        }
        if (bundle != null) {
            this.iUz.initWithBundle(bundle);
        } else {
            this.iUz.initWithIntent(getIntent());
        }
        this.iUz.a(this.iUF);
        if (this.iUz.crp()) {
            this.iUz.loadData();
        } else {
            this.iUz.crT();
        }
    }

    public void crn() {
        this.iUF = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, l lVar) {
                if (NewSubPbActivity.this.iUB != null) {
                    NewSubPbActivity.this.iUB.cry();
                    if (!z) {
                        NewSubPbActivity.this.aX(i, str);
                        return;
                    }
                    NewSubPbActivity.this.iUB.hideNoDataView();
                    if (lVar != null) {
                        if (lVar.clf() != null || NewSubPbActivity.this.iUz != null) {
                            lVar.clf().a(NewSubPbActivity.this.iUz.crZ());
                        }
                        if (NewSubPbActivity.this.iUB != null) {
                            NewSubPbActivity.this.oj(lVar.aAg() != null && lVar.aAg().isBjh());
                            if (NewSubPbActivity.this.hPH != null && NewSubPbActivity.this.hPH.aOt() != null) {
                                NewSubPbActivity.this.hPH.aOt().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.iUB.a(lVar, NewSubPbActivity.this.iUz.ckG(), NewSubPbActivity.this.iUz.csb() != null);
                            if (NewSubPbActivity.this.iUJ) {
                                NewSubPbActivity.this.cro();
                                NewSubPbActivity.this.iUJ = false;
                            }
                        }
                        if (NewSubPbActivity.this.hPH != null) {
                            NewSubPbActivity.this.hPH.a(lVar.bCY());
                            NewSubPbActivity.this.hPH.setThreadData(lVar.aAg());
                        }
                        if (NewSubPbActivity.this.iUM == null) {
                            NewSubPbActivity.this.iUM = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.iUM.setData(lVar);
                        NewSubPbActivity.this.iUM.setType(0);
                        NewSubPbActivity.this.hPy.a(NewSubPbActivity.this.iUz.cse());
                    }
                }
            }
        };
        this.iIE = new a.InterfaceC0374a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0374a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.iHB != null) {
                        NewSubPbActivity.this.iHB.fm(z2);
                    }
                    MarkData ayO = NewSubPbActivity.this.iHB.ayO();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(ayO);
                        if (NewSubPbActivity.this.iHB != null) {
                            if (ayO != null) {
                                NewSubPbActivity.this.iUz.qM(true);
                                NewSubPbActivity.this.iUz.Gt(NewSubPbActivity.this.iUz.aOO());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.iUB != null) {
                                NewSubPbActivity.this.iUB.qL(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.iUz.qM(false);
                        NewSubPbActivity.this.iUz.Gt(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.iUB != null) {
                            NewSubPbActivity.this.iUB.qL(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.iUH = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.iUz.crO() != null && NewSubPbActivity.this.iUz.crO().aAg() != null && NewSubPbActivity.this.iUz.crO().aAg().aCo() != null) {
                    str = String.valueOf(NewSubPbActivity.this.iUz.crO().aAg().aCo().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.iUz.crO().aPm().getId(), NewSubPbActivity.this.iUz.crO().aPm().getName(), NewSubPbActivity.this.iUz.crO().aAg().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.iUI = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.iUA.cLO() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.iUz != null && NewSubPbActivity.this.iUz.crO() != null && NewSubPbActivity.this.iUz.crO().aPm() != null && NewSubPbActivity.this.iUz.crO().aAg() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.iUA.Jg(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.iUA.a(NewSubPbActivity.this.iUz.crO().aPm().getId(), NewSubPbActivity.this.iUz.crO().aPm().getName(), NewSubPbActivity.this.iUz.crO().aAg().getId(), valueOf, i2, i, z, NewSubPbActivity.this.iUz.crO().aAg().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.iUG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.iUB.a(NewSubPbActivity.this.iUA.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.iUA.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.iVH != 1002 || bVar.eLF) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.iUB.a(1, dVar.mSuccess, dVar.kji, true);
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
        registerListener(this.gpA);
        this.akt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v65, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray sparseArray;
                if (view != null || NewSubPbActivity.this.iUB != null) {
                    if (view == NewSubPbActivity.this.iUB.crJ()) {
                        NewSubPbActivity.this.iUB.cpY();
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
                    } else if (view != NewSubPbActivity.this.iUB.bIo()) {
                        if (view != NewSubPbActivity.this.iUB.crC()) {
                            if (view != NewSubPbActivity.this.iUB.crB()) {
                                if (view == NewSubPbActivity.this.iUB.crw()) {
                                    NewSubPbActivity.this.iUB.cpY();
                                    if (NewSubPbActivity.this.iUz.loadData()) {
                                        NewSubPbActivity.this.iUB.cru();
                                    }
                                } else if (view == NewSubPbActivity.this.iUB.crD() || view == NewSubPbActivity.this.iUB.crE() || view == NewSubPbActivity.this.iUB.crG()) {
                                    if (NewSubPbActivity.this.iUL) {
                                        NewSubPbActivity.this.iUL = false;
                                        return;
                                    }
                                    if ((NewSubPbActivity.this.iUz.crO() == null || NewSubPbActivity.this.iUz.crO().aAg() == null) ? false : au.a(NewSubPbActivity.this.iUz.crO().aAg().getBaijiahaoData())) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.iUz.cny(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.iUz.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.iUz.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.iUz.crO() != null && NewSubPbActivity.this.iUz.crO().aAg() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.iUz.crO().aAg().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.iUz.cny(), NewSubPbActivity.this.iUz.aOO(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.iUz.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.iUz.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.iUB.crH() == null || view != NewSubPbActivity.this.iUB.crH().cow()) {
                                    if (NewSubPbActivity.this.iUB.crH() == null || view != NewSubPbActivity.this.iUB.crH().coz()) {
                                        if (NewSubPbActivity.this.iUB.crH() == null || view != NewSubPbActivity.this.iUB.crH().cox()) {
                                            if (NewSubPbActivity.this.iUB.crH() == null || view != NewSubPbActivity.this.iUB.crH().coy()) {
                                                if (NewSubPbActivity.this.iUB.crH() == null || view != NewSubPbActivity.this.iUB.crH().coA()) {
                                                    if (view == NewSubPbActivity.this.iUB.crA() || view == NewSubPbActivity.this.iUB.crG()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.hPH.aPr()) {
                                                                NewSubPbActivity.this.hPH.aPs();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.hPH.vr(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof k)) {
                                                        if (NewSubPbActivity.this.iUC == null || view != NewSubPbActivity.this.iUC.coy()) {
                                                            if (NewSubPbActivity.this.iUC == null || view != NewSubPbActivity.this.iUC.cow()) {
                                                                if (NewSubPbActivity.this.iUC == null || view != NewSubPbActivity.this.iUC.coz()) {
                                                                    if (NewSubPbActivity.this.iUC == null || view != NewSubPbActivity.this.iUC.coA()) {
                                                                        if (NewSubPbActivity.this.iUC == null || view != NewSubPbActivity.this.iUC.coC()) {
                                                                            if (NewSubPbActivity.this.iUC == null || view != NewSubPbActivity.this.iUC.coD()) {
                                                                                if (NewSubPbActivity.this.iUC != null && view == NewSubPbActivity.this.iUC.cox()) {
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
                                                                                            NewSubPbActivity.this.iUB.cA(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.iUB.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                        if (postData.getType() != PostData.kgu && !TextUtils.isEmpty(postData.getBimg_url()) && i.azO().isShowImages()) {
                                                                                            NewSubPbActivity.this.Gq(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.iIa != null && !TextUtils.isEmpty(NewSubPbActivity.this.iIb)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.gQB == null) {
                                                                                        NewSubPbActivity.this.gQB = new ar(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.gQB.j(NewSubPbActivity.this.iIb, NewSubPbActivity.this.iIa.getImageByte());
                                                                                    NewSubPbActivity.this.iIa = null;
                                                                                    NewSubPbActivity.this.iIb = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.iIa != null && !TextUtils.isEmpty(NewSubPbActivity.this.iIb)) {
                                                                            if (NewSubPbActivity.this.iIc == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.iIb));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.iIb;
                                                                                aVar.pkgId = NewSubPbActivity.this.iIc.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.iIc.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.iIa = null;
                                                                            NewSubPbActivity.this.iIb = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.hhz != null) {
                                                                        NewSubPbActivity.this.hhz.fv(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.hhz = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.iUB.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                NewSubPbActivity.this.FP((String) tag);
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
                                                        NewSubPbActivity.this.iUO = (k) view.getTag();
                                                        if (bc.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.iUL) {
                                                                NewSubPbActivity.this.iUL = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.hPy == null || NewSubPbActivity.this.iUz == null || NewSubPbActivity.this.iUz.bCY() == null || NewSubPbActivity.this.hPy.ks(NewSubPbActivity.this.iUz.bCY().replyPrivateFlag)) && (sparseArray = (SparseArray) view.getTag(R.id.tag_from)) != null) {
                                                                if (sparseArray.get(R.id.tag_clip_board) instanceof PostData) {
                                                                    PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                    if (postData2 != null && postData2.aCo() != null) {
                                                                        MetaData aCo = postData2.aCo();
                                                                        NewSubPbActivity.this.hPH.setReplyId(aCo.getUserId());
                                                                        if (!(sparseArray.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue() : true)) {
                                                                            NewSubPbActivity.this.hPH.vs("");
                                                                        } else {
                                                                            NewSubPbActivity.this.hPH.vs(aCo.getName_show());
                                                                        }
                                                                    }
                                                                    NewSubPbActivity.this.iUB.crs();
                                                                }
                                                                if (NewSubPbActivity.this.iUN) {
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
                                            NewSubPbActivity.this.iUB.cpY();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.FP(str4);
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
                                            NewSubPbActivity.this.iUB.cpY();
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
                                    NewSubPbActivity.this.iUB.cpY();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.iUB.a(((Integer) sparseArray7.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray7.get(R.id.tag_del_post_id), ((Integer) sparseArray7.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new an("c11739").X("obj_locate", 2));
                                    NewSubPbActivity.this.iUB.cpY();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.iUz.crO() != null) {
                                        NewSubPbActivity.this.k(NewSubPbActivity.this.iUz.crO().clf());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.iUB.crr();
                                NewSubPbActivity.this.iUB.crs();
                                if (NewSubPbActivity.this.hPH != null) {
                                    NewSubPbActivity.this.hPH.aPu();
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.iUB.crr();
                            NewSubPbActivity.this.iUB.crs();
                            if (NewSubPbActivity.this.hPH != null) {
                                NewSubPbActivity.this.hPH.aPt();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.cmz();
                        if (NewSubPbActivity.this.iUz != null && NewSubPbActivity.this.iUz.crO() != null && NewSubPbActivity.this.iUz.crO().aAg() != null && NewSubPbActivity.this.iUz.crO().aAg().aCo() != null) {
                            TiebaStatic.log(new an("c13402").cy("tid", NewSubPbActivity.this.iUz.cny()).s("fid", NewSubPbActivity.this.iUz.crO().aAg().getFid()).X("obj_locate", 5).cy("uid", NewSubPbActivity.this.iUz.crO().aAg().aCo().getUserId()));
                        }
                    }
                }
            }
        };
        this.iUD = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.iUB.cpY();
                    if (NewSubPbActivity.this.iDG != 2 && NewSubPbActivity.this.iDG != 1) {
                        NewSubPbActivity.this.iUB.crL();
                    }
                }
                NewSubPbActivity.this.hPH.aPs();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.iUB.crI();
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
                if (NewSubPbActivity.this.iUB != null && NewSubPbActivity.this.iUB.crz()) {
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
                        NewSubPbActivity.this.iIa = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.iIb = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.iIa == null || TextUtils.isEmpty(NewSubPbActivity.this.iIb)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.iIc = null;
                        } else {
                            NewSubPbActivity.this.iIc = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.iIa = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.iIb = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.iIc = null;
                        } else {
                            NewSubPbActivity.this.iIc = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.iIa = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.iIb = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.iIc = null;
                        } else {
                            NewSubPbActivity.this.iIc = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.iUB.a(NewSubPbActivity.this.iIK, NewSubPbActivity.this.iIa.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.hhz = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.hhz == null || NewSubPbActivity.this.iHB == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.iHB != null) {
                            NewSubPbActivity.this.iHB.fm(NewSubPbActivity.this.iUz.crU());
                        }
                        boolean z = NewSubPbActivity.this.iHB.ayL() && NewSubPbActivity.this.hhz.getId() != null && NewSubPbActivity.this.hhz.getId().equals(NewSubPbActivity.this.iUz.crW());
                        if (NewSubPbActivity.this.iUC == null) {
                            NewSubPbActivity.this.iUC = new w(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.akt);
                            NewSubPbActivity.this.iUB.cE(NewSubPbActivity.this.iUC.getView());
                            NewSubPbActivity.this.iUC.pY(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.iUC.showDialog();
                        boolean z2 = NewSubPbActivity.this.pL(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z3 = (NewSubPbActivity.this.iUz.crO() == null || NewSubPbActivity.this.iUz.crO().aAg() == null || !NewSubPbActivity.this.iUz.crO().aAg().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z) {
                            NewSubPbActivity.this.iUC.cow().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.iUC.cow().setText(R.string.mark);
                        }
                        if (booleanValue || z3) {
                            NewSubPbActivity.this.iUC.cow().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.iUC.cow().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.cv(view)) {
                            if (NewSubPbActivity.this.iIa != null && !NewSubPbActivity.this.iIa.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        NewSubPbActivity.this.iUC.a(sparseArray2, NewSubPbActivity.this.ckG(), z2);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.iUE = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                        l crO = NewSubPbActivity.this.iUz.crO();
                        TbRichText bj = NewSubPbActivity.this.bj(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bj != null && bj.aTS() != null) {
                            tbRichTextData = bj.aTS().get(NewSubPbActivity.this.iIH);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.aTY().aUj()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (crO == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (crO.aPm() != null) {
                                        str4 = crO.aPm().getName();
                                        str5 = crO.aPm().getId();
                                    }
                                    if (crO.aAg() != null) {
                                        str6 = crO.aAg().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.iUz.csb() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.iUz.csb();
                                    z6 = NewSubPbActivity.this.iUz.csd();
                                    arrayList2 = NewSubPbActivity.this.iUz.csc();
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
                            NewSubPbActivity.this.iII = false;
                            String str7 = "";
                            TbRichText cLc = crO.clf().cLc();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(cLc, bj, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (crO == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (crO.aPm() != null) {
                                    str8 = crO.aPm().getName();
                                    str9 = crO.aPm().getId();
                                }
                                if (crO.aAg() != null) {
                                    str10 = crO.aAg().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.iUz.csb() != null) {
                                concurrentHashMap = NewSubPbActivity.this.iUz.csb();
                                z4 = NewSubPbActivity.this.iUz.csd();
                                arrayList = NewSubPbActivity.this.iUz.csc();
                                i2 = a2 + NewSubPbActivity.this.iUz.getOffset();
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
        if (this.iUz == null || this.iUz.crO() == null) {
            return null;
        }
        return this.iUz.crO().aAg();
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
        TbRichTextImageInfo aTY;
        if (tbRichText == tbRichText2) {
            this.iII = true;
        }
        if (tbRichText != null && tbRichText.aTS() != null) {
            int size = tbRichText.aTS().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.aTS().get(i6) != null && tbRichText.aTS().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.aTS().get(i6).aTY().getWidth() * equipmentDensity;
                    int height = tbRichText.aTS().get(i6).aTY().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.aTS().get(i6).aTY().aUj()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.aTS().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (aTY = tbRichTextData.aTY()) != null) {
                            String aUl = aTY.aUl();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = aUl;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.iII) {
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
        if (this.iUC != null) {
            this.iUC.pY(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo aTY = tbRichTextData.aTY();
        if (aTY != null) {
            if (!StringUtils.isNull(aTY.aUi())) {
                return aTY.aUi();
            }
            if (aTY.getHeight() * aTY.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (aTY.getHeight() * aTY.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (aTY.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * aTY.getHeight())));
            } else {
                float width = aTY.getWidth() / aTY.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(aTY.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bj(String str, int i) {
        if (this.iUz == null || this.iUz.crO() == null || str == null || i < 0) {
            return null;
        }
        l crO = this.iUz.crO();
        TbRichText a2 = a(crO.clf(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(crO.clf(), str, i);
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
        TbRichText cLc = postData.cLc();
        if (cLc != null) {
            ArrayList<TbRichTextData> aTS = cLc.aTS();
            int size = aTS.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (aTS.get(i3) != null && aTS.get(i3).getType() == 8) {
                    i2++;
                    if (aTS.get(i3).aTY().aUl().equals(str)) {
                        int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = aTS.get(i3).aTY().getWidth() * equipmentDensity;
                        int height = aTS.get(i3).aTY().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.iIH = i3;
                        return cLc;
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
    public void cmz() {
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false) {
            if (this.hPy == null || this.iUz == null || this.iUz.bCY() == null || this.hPy.ks(this.iUz.bCY().replyPrivateFlag)) {
                if (this.hPH.aPh()) {
                    this.hPH.a((PostWriteCallBackData) null);
                    return;
                }
                this.iUB.crr();
                this.iUB.crs();
                if (this.hPH != null) {
                    this.hPH.aPv();
                    return;
                }
                return;
            }
            return;
        }
        if (this.grM == null) {
            this.grM = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.grM.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lw(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void t(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lx(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.hPy == null || NewSubPbActivity.this.iUz == null || NewSubPbActivity.this.iUz.bCY() == null || NewSubPbActivity.this.hPy.ks(NewSubPbActivity.this.iUz.bCY().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.hPH.aPh()) {
                                NewSubPbActivity.this.hPH.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.iUB.crr();
                            NewSubPbActivity.this.iUB.crs();
                            if (NewSubPbActivity.this.hPH != null) {
                                NewSubPbActivity.this.hPH.aPv();
                            }
                        }
                    }
                }
            });
        }
        if (this.iUz != null && this.iUz.crO() != null && this.iUz.crO().aPm() != null) {
            this.grM.C(this.iUz.crO().aPm().getId(), com.baidu.adp.lib.f.b.toLong(this.iUz.cny(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pL(boolean z) {
        if (this.iUz == null) {
            return false;
        }
        return ((ckG() != 0) || this.iUz.crO() == null || this.iUz.crO().aAg() == null || this.iUz.crO().aAg().aCo() == null || this.iUz.crO().aAg().aEi() || TextUtils.equals(this.iUz.crO().aAg().aCo().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(int i, String str) {
        if (this.iUz.crP()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.isNetOk()) {
            if (i == 4) {
                this.iUB.zM(str + "(4)");
            } else {
                this.iUB.wo(R.string.no_data_text);
            }
        } else {
            this.iUB.wo(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(boolean z) {
        this.hPH = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dV(getActivity());
        if (this.hPH != null) {
            this.hPH.a(getPageContext());
            this.hPH.b(this.iUz);
            this.hPH.b(this.hgX);
            this.hPH.a(this.dyt);
            this.hPH.a(this.dyu);
            this.hPH.aOt().gB(true);
            this.hPH.g(getPageContext());
        }
        if (this.iUB != null) {
            this.iUB.i(this.hPH);
        }
        if (this.hPH != null && this.iUz != null) {
            this.hPH.a(this.iUz.bCY());
            this.hPH.aPs();
        }
        if (this.hPH != null) {
            this.hPH.aPw().setDefaultHint(cpm());
            this.hPH.aPw().setHint(cpm());
            this.hgR = this.hPH.aPw().getInputView();
            this.hgR.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.hgQ != null) {
                        if (!NewSubPbActivity.this.hgQ.cUf()) {
                            NewSubPbActivity.this.mP(false);
                        }
                        NewSubPbActivity.this.hgQ.tH(false);
                    }
                }
            });
        }
    }

    public void cro() {
        if (!TbadkCoreApplication.isLogin()) {
            this.hPH.aPs();
        } else if (!StringUtils.isNull(this.iUz.crX())) {
            if (this.iUB.crv() && com.baidu.adp.lib.util.l.isNetOk()) {
                this.iUB.bBc();
            } else {
                this.iUB.cry();
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
                    this.iUB.cA(view);
                }
            } else if (booleanValue2) {
                this.iUB.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.iUB.crF(), getPageContext().getPageActivity());
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.iUK);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.iUK);
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
        this.iUB.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.iUK;
        userMuteCheckCustomMessage.setTag(this.iUK);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.iUB.a(0, bVar.mSuccess, bVar.kji, z);
            if (bVar.mSuccess) {
                if (bVar.fXX == 1) {
                    if (this.iUB.getListView() instanceof BdTypeListView) {
                        List<com.baidu.adp.widget.ListView.m> data = ((BdTypeListView) this.iUB.getListView()).getData();
                        if (!v.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.iUB.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.fXX == 2) {
                    this.iUz.Gs(bVar.mPostId);
                    this.iUB.a(this.iUz.crO(), this.iUz.ckG(), this.iUz.csb() != null);
                    if (this.iUz.crY()) {
                        this.iUz.qN(false);
                        this.iUB.crt();
                        this.iUz.loadData();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void FP(String str) {
        if (this.iUz != null && this.iUz.crO() != null && this.iUz.crO().aAg() != null && this.iUz.crO().aAg().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.iUz.cny(), str);
            bj aAg = this.iUz.crO().aAg();
            if (aAg.aBd()) {
                format = format + "&channelid=33833";
            } else if (aAg.aEf()) {
                format = format + "&channelid=33842";
            } else if (aAg.aBe()) {
                format = format + "&channelid=33840";
            }
            FQ(format);
            return;
        }
        this.iHA.Gp(str);
    }

    private void FQ(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void k(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.iUz.crU() && postData.getId() != null && postData.getId().equals(this.iUz.crW())) {
                z = true;
            }
            MarkData l = this.iUz.l(postData);
            if (l != null) {
                this.iUB.cpY();
                if (this.iHB != null) {
                    this.iHB.a(l);
                    if (!z) {
                        this.iHB.ayN();
                    } else {
                        this.iHB.ayM();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.iUz != null) {
            this.iUz.au(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.hPH != null) {
            this.hPH.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.hPH.aOt().aMQ();
        this.hPH.aPs();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.hPH.b(writeData);
                this.hPH.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l mp = this.hPH.aOt().mp(6);
                if (mp != null && mp.dwA != null) {
                    mp.dwA.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.hPH.aPo();
                }
                this.iUB.crL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gol != null) {
            this.gol.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.eet = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.axz().axE();
        if (this.gol != null) {
            this.gol.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.hty);
        this.iUB.bKp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eet = false;
        super.onResume();
        cne();
        if (this.gol != null) {
            this.gol.onResume(getPageContext());
        }
        registerListener(this.hty);
        this.iUB.bKq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gol != null) {
            this.gol.onStop(getPageContext());
        }
        this.hPH.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.iUM));
        this.iUz.cancelLoadData();
        this.iUz.destory();
        this.iUA.cancelLoadData();
        if (this.gol != null) {
            this.gol.onDestory(getPageContext());
        }
        this.iUB.cpY();
        this.iUB.aiI();
        MessageManager.getInstance().unRegisterListener(this.iIw);
        MessageManager.getInstance().unRegisterListener(this.iIx);
        MessageManager.getInstance().unRegisterListener(this.iIy);
        MessageManager.getInstance().unRegisterListener(this.iUK);
        this.iHW = null;
        this.iHX = null;
        if (this.hPy != null) {
            this.hPy.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iUB.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gol;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View crA = this.iUB.crA();
        if (crA == null || (findViewWithTag = crA.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Gi(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = ba.getParamPair(ba.getParamStr(str))) != null) {
            this.iUL = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Gi(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(iUy);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (Gi(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                    lVar.mLink = str;
                    lVar.type = 3;
                    lVar.dvD = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
                }
            } else {
                ba.aGG().b(getPageContext(), new String[]{str});
            }
            this.iUL = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aC(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iUL = true;
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
        if (this.iUB != null) {
            return this.iUB.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int aUz() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> aUB() {
        if (this.dPb == null) {
            this.dPb = TbRichTextView.z(getPageContext().getPageActivity(), 8);
        }
        return this.dPb;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> aUC() {
        if (this.dMo == null) {
            this.dMo = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bGZ */
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
        return this.dMo;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> aUA() {
        if (this.dMn == null) {
            this.dMn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aUM */
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
        return this.dMn;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> aUD() {
        if (this.dPc == null) {
            this.dPc = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnl */
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
        return this.dPc;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> aUE() {
        if (this.dPd == null) {
            this.dPd = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnn */
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
        return this.dPd;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> aUF() {
        this.dPe = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cnm */
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
        return this.dPe;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a clq() {
        return this.iEk;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean clr() {
        return (this.iUz == null || this.iUz.crO() == null || this.iUz.crO().aAg() == null || this.iUz.crO().aAg().aDG()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cls() {
        if (this.iUz == null || this.iUz.crO() == null || this.iUz.crO().aAg() == null) {
            return null;
        }
        return this.iUz.crO().aAg().aCt();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int clt() {
        if (this.iUz == null) {
            return 0;
        }
        return this.iUz.ckG();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean FK(String str) {
        if (StringUtils.isNull(str) || this.iUz == null || this.iUz.crO() == null || this.iUz.crO().aAg() == null || this.iUz.crO().aAg().aCo() == null) {
            return false;
        }
        return str.equals(this.iUz.crO().aAg().aCo().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.iUB.crv() && com.baidu.adp.lib.util.l.isNetOk()) {
            this.iUz.loadData();
        } else {
            this.iUB.cry();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.iUK);
        userMuteAddAndDelCustomMessage.setTag(this.iUK);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gq(String str) {
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
                return com.baidu.tbadk.m.e.aQX().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.iUz != null) {
            if (this.iUz.crO() != null && this.iUz.crO().aPm() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.iUz.crO().aPm().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.iUz.cny(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.eet;
    }

    public boolean crp() {
        if (this.iUz != null) {
            return this.iUz.crp();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.iUB.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iHW.getPageActivity());
        if (aq.isEmpty(str)) {
            aVar.sS(this.iHW.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.sS(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.iUB.showLoadingDialog();
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
        aVar.b(this.iHW).aEC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vq(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iHW.getPageActivity());
        aVar.sS(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.iHW).aEC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnb() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.sS(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.iHW).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.iHW.getPageActivity(), 2, true, 4);
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
        aVar.b(this.iHW).aEC();
    }

    public SubPbModel crq() {
        return this.iUz;
    }

    public int ckG() {
        if (this.iUz != null) {
            return this.iUz.ckG();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.dwW && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.dwW && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void mP(boolean z) {
        if (this.hgR != null && this.hgR.getText() != null) {
            int selectionEnd = this.hgR.getSelectionEnd();
            SpannableStringBuilder a2 = this.hgQ.a(this.hgR.getText());
            if (a2 != null) {
                this.hgQ.tH(true);
                this.hgR.setText(a2);
                if (z && this.hgQ.cUd() >= 0) {
                    this.hgR.requestFocus();
                    this.hgR.setSelection(this.hgQ.cUd());
                } else {
                    this.hgR.setSelection(selectionEnd);
                }
                this.hgQ.tG(this.hgQ.cUd() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hPH != null && this.hPH.aOt() != null && this.hPH.aOt().aOv()) {
            this.hPH.aOt().aMQ();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.d.a(pVar, getUniqueId(), this);
    }

    public String cpm() {
        if (!aq.isEmpty(this.iPt)) {
            return this.iPt;
        }
        this.iPt = getResources().getString(com.baidu.tieba.pb.pb.main.am.cpb());
        return this.iPt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.iUN = z;
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
        if (this.iUB != null && this.iUB.getListView() != null && this.iUO != null && this.iUO.mPosition != -1) {
            final int headerViewsCount = this.iUO.mPosition + this.iUB.getListView().getHeaderViewsCount();
            if (this.iUO.getView() != null) {
                final int height = this.iUO.getView().getHeight() - ((rect.height() - this.iUB.getNavigationBarHeight()) - this.iUB.crK());
                if (height > 0) {
                    this.iUB.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.iUB != null && NewSubPbActivity.this.iUB.getListView() != null) {
                                NewSubPbActivity.this.iUB.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.iUB.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.iUB.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.iUB != null && NewSubPbActivity.this.iUB.getListView() != null) {
                                NewSubPbActivity.this.iUB.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.iUB.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }

    private void cne() {
        if (this.iUz != null && !aq.isEmpty(this.iUz.cny())) {
            com.baidu.tbadk.BdToken.c.axz().o(com.baidu.tbadk.BdToken.b.cGL, com.baidu.adp.lib.f.b.toLong(this.iUz.cny(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.iUz == null || aq.isEmpty(this.iUz.cny())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.iUz.cny(), 0L);
    }
}
