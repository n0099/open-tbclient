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
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.r;
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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
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
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.i;
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
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.main.ad;
import com.baidu.tieba.pb.pb.main.az;
import com.baidu.tieba.pb.pb.main.l;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
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
    private static String jZk = "tbgametype";
    private View.OnClickListener aIH;
    private com.baidu.adp.lib.d.b<ImageView> eBC;
    private com.baidu.adp.lib.d.b<GifView> eBD;
    private com.baidu.adp.lib.d.b<TextView> eEq;
    private com.baidu.adp.lib.d.b<View> eEr;
    private com.baidu.adp.lib.d.b<LinearLayout> eEs;
    private com.baidu.adp.lib.d.b<RelativeLayout> eEt;
    private az hRB;
    private VoiceManager hns;
    private com.baidu.tieba.frs.profession.permission.c hra;
    public aj iQC;
    private com.baidu.tbadk.editortools.pb.h iQN;
    private com.baidu.tieba.write.c ihP;
    private EditText ihQ;
    private com.baidu.tieba.pb.pb.main.b.a jHX;
    private com.baidu.tieba.pb.pb.report.a jLC;
    private com.baidu.tbadk.baseEditMark.a jLD;
    private e jLY;
    private com.baidu.tbadk.core.view.c jLZ;
    private com.baidu.adp.widget.ImageView.a jMc;
    private String jMd;
    private TbRichTextMemeInfo jMe;
    private PostWriteCallBackData jNG;
    private String jTV;
    private l jZA;
    private SubPbModel jZl;
    private ForumManageModel jZm;
    private com.baidu.tieba.pb.pb.sub.a jZn;
    private ad jZo;
    private AbsListView.OnScrollListener jZp;
    private TbRichTextView.i jZq;
    private SubPbModel.a jZr;
    private com.baidu.adp.base.d jZs;
    private BdUniqueId jZw;
    private com.baidu.tieba.pb.e<n> jZy;
    private boolean jZz;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int jML = 0;
    PostData iiy = null;
    private a.InterfaceC0471a jMH = null;
    private a jZt = null;
    private a jZu = null;
    private boolean mIsPaused = false;
    private boolean jZv = false;
    private boolean jZx = false;
    private boolean elr = false;
    private com.baidu.tbadk.editortools.pb.c emO = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bdv() {
            NewSubPbActivity.this.jZn.cJK();
        }
    };
    private int jHt = 0;
    private boolean mIsFromSchema = false;
    private com.baidu.tbadk.editortools.pb.b emP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bdu() {
            if (!NewSubPbActivity.this.ihP.dmx()) {
                return (NewSubPbActivity.this.iQC == null || NewSubPbActivity.this.jZl == null || NewSubPbActivity.this.jZl.bUc() == null || NewSubPbActivity.this.iQC.aD(NewSubPbActivity.this.jZl.bUc().replyPrivateFlag, aj.dNH)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.ihP.dmz());
            if (NewSubPbActivity.this.iQN.bdL()) {
                NewSubPbActivity.this.iQN.a(NewSubPbActivity.this.jNG);
            }
            NewSubPbActivity.this.ov(true);
            return true;
        }
    };
    private NewWriteModel.d ihW = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ab abVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.iQN != null && NewSubPbActivity.this.iQN.bcX() != null) {
                NewSubPbActivity.this.iQN.bcX().hide();
                if (NewSubPbActivity.this.jZl.cKj()) {
                    TiebaStatic.log(new an("c10367").dh("post_id", NewSubPbActivity.this.jZl.bds()));
                }
            }
            if (z) {
                NewSubPbActivity.this.ihP.Og(null);
                NewSubPbActivity.this.ihP.aX(null);
                NewSubPbActivity.this.ihP.vm(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.ihP.aX(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.ihP.Og(postWriteCallBackData.getErrorString());
                if (!v.isEmpty(NewSubPbActivity.this.ihP.dmv())) {
                    NewSubPbActivity.this.jNG = postWriteCallBackData;
                    if (NewSubPbActivity.this.iQN.bdL()) {
                        NewSubPbActivity.this.iQN.a(NewSubPbActivity.this.jNG);
                    }
                    NewSubPbActivity.this.ov(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.iQC != null) {
                NewSubPbActivity.this.iQC.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.jZn.cJL();
        }
    };
    private CustomMessageListener jMy = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.jZw) {
                NewSubPbActivity.this.jZn.bGh();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.jLZ.showSuccessToast(NewSubPbActivity.this.jLY.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.jLY.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.yo(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.cFl();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.jLY.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.jLZ.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener jMz = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.jZw) {
                NewSubPbActivity.this.jZn.bGh();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.jLZ.showSuccessToast(NewSubPbActivity.this.jLY.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.jLY.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.jLZ.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener jMA = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.jZw) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.jZn.bGh();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.lAC;
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
                    NewSubPbActivity.this.jZn.a(sparseArray, z);
                }
            }
        }
    };
    boolean jMM = false;
    private final b.a jMO = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.jMc != null && !TextUtils.isEmpty(NewSubPbActivity.this.jMd)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.jMe == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.jMd));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.jMd;
                        aVar.pkgId = NewSubPbActivity.this.jMe.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.jMe.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.hRB == null) {
                            NewSubPbActivity.this.hRB = new az(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.hRB.j(NewSubPbActivity.this.jMd, NewSubPbActivity.this.jMc.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.jMc = null;
                NewSubPbActivity.this.jMd = null;
            }
        }
    };
    private CustomMessageListener iuz = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener hoJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    com.baidu.tbadk.data.l lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.jZl.cKc() != null && NewSubPbActivity.this.jZl.cKc().cDs() != null && NewSubPbActivity.this.jZl.cKc().cDs().aQx() != null && currentAccount.equals(NewSubPbActivity.this.jZl.cKc().cDs().aQx().getUserId()) && NewSubPbActivity.this.jZl.cKc().cDs().aQx().getPendantData() != null) {
                        NewSubPbActivity.this.jZl.cKc().cDs().aQx().getPendantData().vx(lVar.aOP());
                        NewSubPbActivity.this.jZl.cKc().cDs().aQx().getPendantData().cr(lVar.bcC());
                        NewSubPbActivity.this.jZn.a(NewSubPbActivity.this.jZl.cKc(), NewSubPbActivity.this.jZl.cKc().cDs(), NewSubPbActivity.this.jZl.cKc().coT(), NewSubPbActivity.this.jZl.cKc().aML(), NewSubPbActivity.this.jZl.cCN(), NewSubPbActivity.this.jZl.cKp() != null);
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
        aB(bundle);
        if (getIntent() != null) {
            this.mIsFromSchema = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_FROM_SCHEMA, false);
        }
        super.onCreate(bundle);
        this.jLY = getPageContext();
        this.jZv = true;
        this.ihP = new com.baidu.tieba.write.c();
        this.ihP.Fw(R.color.cp_cont_h_alpha85);
        this.ihP.Fv(R.color.cp_cont_a);
        bwC();
        cJA();
        initData(bundle);
        initUI();
        ((SubPbView) this.jZn.getRootView()).show();
        pP(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jZn.ss(this.mIsFromSchema);
        this.jLZ = new com.baidu.tbadk.core.view.c();
        this.jLZ.toastTime = 1000L;
        registerListener(this.jMA);
        registerListener(this.jMy);
        registerListener(this.jMz);
        this.jZw = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.jZw;
        userMuteAddAndDelCustomMessage.setTag(this.jZw);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.jZw;
        userMuteCheckCustomMessage.setTag(this.jZw);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.iQC = new aj(getPageContext());
        this.iQC.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tbadk.core.util.aj.a
            public void q(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.iQN.bdS();
                }
            }
        });
        this.jLC = new com.baidu.tieba.pb.pb.report.a(this);
        this.jLC.w(getUniqueId());
        this.jHX = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.jZn = new com.baidu.tieba.pb.pb.sub.a(this, this.aIH);
        this.jZn.a(this.jZl);
        setContentView(this.jZn.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.jZn.setOnScrollListener(this.jZp);
        this.jZn.b(this);
        this.jZn.setOnImageClickListener(this.jZq);
        this.jZn.setOnLongClickListener(this.mOnLongClickListener);
        this.jZn.f(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.jZl != null) {
                    NewSubPbActivity.this.jZl.loadData();
                }
            }
        });
        this.jZn.a(this.jZt);
        this.jZn.b(this.jZu);
        if (this.jZl != null && this.jZl.cJC() && !this.jZl.cKo()) {
            this.jZn.cJQ().setVisibility(8);
        } else {
            this.jZn.cJQ().setVisibility(0);
        }
        if (this.jZl != null && !this.jZl.cJC()) {
            this.jZn.setIsFromPb(false);
        }
    }

    private boolean aB(Bundle bundle) {
        if (bundle != null) {
            this.elr = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.elr = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.elr;
    }

    public void initData(Bundle bundle) {
        this.jZl = new SubPbModel(getPageContext());
        this.jZl.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                NewSubPbActivity.this.jZn.u(postData);
                NewSubPbActivity.this.jZn.b((BdListView.e) null);
            }
        });
        this.jZm = new ForumManageModel(getPageContext());
        this.jZm.setLoadDataCallBack(this.jZs);
        this.hns = new VoiceManager();
        this.hns.onCreate(getPageContext());
        this.jLD = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.jLD != null) {
            this.jLD.a(this.jMH);
        }
        if (bundle != null) {
            this.jZl.initWithBundle(bundle);
        } else {
            this.jZl.initWithIntent(getIntent());
        }
        this.jZl.a(this.jZr);
        if (this.jZl.cJC()) {
            this.jZl.loadData();
        } else {
            this.jZl.cKh();
        }
    }

    public void cJA() {
        this.jZr = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, n nVar) {
                if (NewSubPbActivity.this.jZn != null) {
                    NewSubPbActivity.this.jZn.cJL();
                    if (!z) {
                        NewSubPbActivity.this.br(i, str);
                        return;
                    }
                    NewSubPbActivity.this.jZn.hideNoDataView();
                    if (nVar != null) {
                        if (nVar.cDs() != null || NewSubPbActivity.this.jZl != null) {
                            nVar.cDs().a(NewSubPbActivity.this.jZl.cKn());
                        }
                        if (NewSubPbActivity.this.jZn != null) {
                            NewSubPbActivity.this.pP(nVar.aOi() != null && nVar.aOi().isBjh());
                            if (NewSubPbActivity.this.iQN != null && NewSubPbActivity.this.iQN.bcX() != null) {
                                NewSubPbActivity.this.iQN.bcX().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.jZn.a(nVar, NewSubPbActivity.this.jZl.cCN(), NewSubPbActivity.this.jZl.cKp() != null);
                            if (NewSubPbActivity.this.jZv) {
                                NewSubPbActivity.this.jZn.getListView().setSelectionFromTop(NewSubPbActivity.this.jZn.getListView().getHeaderViewsCount() + 1, -com.baidu.adp.lib.util.l.getDimens(NewSubPbActivity.this, R.dimen.tbds18));
                                NewSubPbActivity.this.cJB();
                                NewSubPbActivity.this.jZv = false;
                            }
                        }
                        if (NewSubPbActivity.this.iQN != null) {
                            NewSubPbActivity.this.iQN.a(nVar.bUc());
                            NewSubPbActivity.this.iQN.setThreadData(nVar.aOi());
                        }
                        if (NewSubPbActivity.this.jZy == null) {
                            NewSubPbActivity.this.jZy = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.jZy.setData(nVar);
                        NewSubPbActivity.this.jZy.setType(0);
                        NewSubPbActivity.this.iQC.a(NewSubPbActivity.this.jZl.cKs());
                    }
                }
            }
        };
        this.jMH = new a.InterfaceC0471a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0471a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.jLD != null) {
                        NewSubPbActivity.this.jLD.gC(z2);
                    }
                    MarkData aMO = NewSubPbActivity.this.jLD.aMO();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(aMO);
                        if (NewSubPbActivity.this.jLD != null) {
                            if (aMO != null) {
                                NewSubPbActivity.this.jZl.su(true);
                                NewSubPbActivity.this.jZl.JR(NewSubPbActivity.this.jZl.bds());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.jZn != null) {
                                NewSubPbActivity.this.jZn.st(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.jZl.su(false);
                        NewSubPbActivity.this.jZl.JR(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.jZn != null) {
                            NewSubPbActivity.this.jZn.st(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.jZt = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.jZl.cKc() != null && NewSubPbActivity.this.jZl.cKc().aOi() != null && NewSubPbActivity.this.jZl.cKc().aOi().aQx() != null) {
                    str = String.valueOf(NewSubPbActivity.this.jZl.cKc().aOi().aQx().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.jZl.cKc().bdQ().getId(), NewSubPbActivity.this.jZl.cKc().bdQ().getName(), NewSubPbActivity.this.jZl.cKc().aOi().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.jZu = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.jZm.dez() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.jZl != null && NewSubPbActivity.this.jZl.cKc() != null && NewSubPbActivity.this.jZl.cKc().bdQ() != null && NewSubPbActivity.this.jZl.cKc().aOi() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.jZm.MH(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.jZm.a(NewSubPbActivity.this.jZl.cKc().bdQ().getId(), NewSubPbActivity.this.jZl.cKc().bdQ().getName(), NewSubPbActivity.this.jZl.cKc().aOi().getId(), valueOf, i2, i, z, NewSubPbActivity.this.jZl.cKc().aOi().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.jZs = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.jZn.a(NewSubPbActivity.this.jZm.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.jZm.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.kaw != 1002 || bVar.fEQ) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.jZn.a(1, dVar.OU, dVar.loP, true);
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

    public void bwC() {
        registerListener(this.hoJ);
        this.aIH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v85, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostData postData;
                SparseArray sparseArray;
                boolean z = false;
                if (view != null || NewSubPbActivity.this.jZn != null) {
                    if (view == NewSubPbActivity.this.jZn.cJW()) {
                        NewSubPbActivity.this.jZn.cIk();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ba.aVa().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.jZn.bZC()) {
                        if (view != NewSubPbActivity.this.jZn.cJP()) {
                            if (view != NewSubPbActivity.this.jZn.cJO()) {
                                if (view == NewSubPbActivity.this.jZn.cJJ()) {
                                    NewSubPbActivity.this.jZn.cIk();
                                    if (NewSubPbActivity.this.jZl.loadData()) {
                                        NewSubPbActivity.this.jZn.cJH();
                                    }
                                } else if (view == NewSubPbActivity.this.jZn.cJQ() || view == NewSubPbActivity.this.jZn.cJR() || view == NewSubPbActivity.this.jZn.cJT()) {
                                    if (NewSubPbActivity.this.jZx) {
                                        NewSubPbActivity.this.jZx = false;
                                        return;
                                    }
                                    if (NewSubPbActivity.this.jZl.cKc() != null && NewSubPbActivity.this.jZl.cKc().aOi() != null) {
                                        z = au.a(NewSubPbActivity.this.jZl.cKc().aOi().getBaijiahaoData());
                                    }
                                    if (z) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.jZl.cFJ(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.jZl.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.jZl.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.jZl.cKc() != null && NewSubPbActivity.this.jZl.cKc().aOi() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.jZl.cKc().aOi().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.jZl.cFJ(), NewSubPbActivity.this.jZl.bds(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.jZl.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.jZl.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.jZn.cJU() == null || view != NewSubPbActivity.this.jZn.cJU().cGI()) {
                                    if (NewSubPbActivity.this.jZn.cJU() == null || view != NewSubPbActivity.this.jZn.cJU().cGL()) {
                                        if (NewSubPbActivity.this.jZn.cJU() == null || view != NewSubPbActivity.this.jZn.cJU().cGJ()) {
                                            if (NewSubPbActivity.this.jZn.cJU() == null || view != NewSubPbActivity.this.jZn.cJU().cGK()) {
                                                if (NewSubPbActivity.this.jZn.cJU() == null || view != NewSubPbActivity.this.jZn.cJU().cGM()) {
                                                    if (view == NewSubPbActivity.this.jZn.cJN() || view == NewSubPbActivity.this.jZn.cJT()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.iQN.bdV()) {
                                                                NewSubPbActivity.this.iQN.bdW();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.iQN.yp(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view != null && (view.getTag() instanceof l)) {
                                                        NewSubPbActivity.this.jZA = (l) view.getTag();
                                                        if (bc.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.jZx) {
                                                                NewSubPbActivity.this.jZx = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.iQC == null || NewSubPbActivity.this.jZl == null || NewSubPbActivity.this.jZl.bUc() == null || NewSubPbActivity.this.iQC.lb(NewSubPbActivity.this.jZl.bUc().replyPrivateFlag)) && (sparseArray = (SparseArray) view.getTag(R.id.tag_from)) != null) {
                                                                if (sparseArray.get(R.id.tag_clip_board) instanceof PostData) {
                                                                    PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                    if (postData2 != null && postData2.aQx() != null) {
                                                                        MetaData aQx = postData2.aQx();
                                                                        NewSubPbActivity.this.iQN.setReplyId(aQx.getUserId());
                                                                        boolean booleanValue = sparseArray.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue() : true;
                                                                        if (!(view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) || view.getTag(R.id.tag_subpb_ban_display_keyboard) != Boolean.TRUE) {
                                                                            r6 = false;
                                                                        }
                                                                        if (!booleanValue) {
                                                                            if (!r6) {
                                                                                NewSubPbActivity.this.iQN.yq("");
                                                                            }
                                                                        } else if (!r6) {
                                                                            NewSubPbActivity.this.iQN.yq(aQx.getName_show());
                                                                        }
                                                                    }
                                                                    NewSubPbActivity.this.jZn.cJF();
                                                                }
                                                                if (NewSubPbActivity.this.jZz) {
                                                                    NewSubPbActivity.this.sr(false);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || view.getId() != R.id.post_info_commont_img) {
                                                        if (NewSubPbActivity.this.jZo == null || view != NewSubPbActivity.this.jZo.cGK()) {
                                                            if (NewSubPbActivity.this.jZo == null || view != NewSubPbActivity.this.jZo.cGI()) {
                                                                if (NewSubPbActivity.this.jZo == null || view != NewSubPbActivity.this.jZo.cGL()) {
                                                                    if (NewSubPbActivity.this.jZo == null || view != NewSubPbActivity.this.jZo.cGM()) {
                                                                        if (NewSubPbActivity.this.jZo == null || view != NewSubPbActivity.this.jZo.cGO()) {
                                                                            if (NewSubPbActivity.this.jZo == null || view != NewSubPbActivity.this.jZo.cGP()) {
                                                                                if (NewSubPbActivity.this.jZo != null && view == NewSubPbActivity.this.jZo.cGJ()) {
                                                                                    if (!j.isNetWorkAvailable()) {
                                                                                        NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                                                        return;
                                                                                    }
                                                                                    SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                                                                                    if (sparseArray2 != null) {
                                                                                        boolean booleanValue2 = ((Boolean) sparseArray2.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                        boolean booleanValue3 = ((Boolean) sparseArray2.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                        boolean booleanValue4 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                        if (booleanValue2) {
                                                                                            if (booleanValue4) {
                                                                                                sparseArray2.put(R.id.tag_from, 1);
                                                                                                sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                                                                NewSubPbActivity.this.c(sparseArray2);
                                                                                                return;
                                                                                            }
                                                                                            sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                                                            NewSubPbActivity.this.jZn.cI(view);
                                                                                            return;
                                                                                        } else if (booleanValue3) {
                                                                                            NewSubPbActivity.this.jZn.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.aTX().getString("tail_link", "");
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
                                                                                        PostData postData3 = (PostData) obj;
                                                                                        if (postData3.getType() != PostData.llT && !TextUtils.isEmpty(postData3.getBimg_url()) && k.aNQ().isShowImages()) {
                                                                                            NewSubPbActivity.this.JO(postData3.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.jMc != null && !TextUtils.isEmpty(NewSubPbActivity.this.jMd)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.hRB == null) {
                                                                                        NewSubPbActivity.this.hRB = new az(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.hRB.j(NewSubPbActivity.this.jMd, NewSubPbActivity.this.jMc.getImageByte());
                                                                                    NewSubPbActivity.this.jMc = null;
                                                                                    NewSubPbActivity.this.jMd = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.jMc != null && !TextUtils.isEmpty(NewSubPbActivity.this.jMd)) {
                                                                            if (NewSubPbActivity.this.jMe == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.jMd));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.jMd;
                                                                                aVar.pkgId = NewSubPbActivity.this.jMe.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.jMe.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.jMc = null;
                                                                            NewSubPbActivity.this.jMd = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.iiy != null) {
                                                                        NewSubPbActivity.this.iiy.fp(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.iiy = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.jZn.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                NewSubPbActivity.this.Jm((String) tag);
                                                                return;
                                                            } else if (tag instanceof SparseArray) {
                                                                SparseArray<Object> sparseArray4 = (SparseArray) tag;
                                                                if ((sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                                    sparseArray4.put(R.id.tag_from, 0);
                                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                                    NewSubPbActivity.this.c(sparseArray4);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    } else if (NewSubPbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                        SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                        if ((sparseArray5.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray5.get(R.id.tag_load_sub_data)) != null) {
                                                            if (NewSubPbActivity.this.jZl != null) {
                                                                TiebaStatic.log(new an("c13700").dh("tid", NewSubPbActivity.this.jZl.cFK()).dh("fid", NewSubPbActivity.this.jZl.getFromForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dh("post_id", postData.getId()).ag("obj_type", 3));
                                                            }
                                                            if (postData.aQx() != null) {
                                                                MetaData aQx2 = postData.aQx();
                                                                NewSubPbActivity.this.iQN.setReplyId(aQx2.getUserId());
                                                                if (!(sparseArray5.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray5.get(R.id.tag_is_subpb)).booleanValue() : true)) {
                                                                    NewSubPbActivity.this.iQN.yq("");
                                                                } else {
                                                                    NewSubPbActivity.this.iQN.yq(aQx2.getName_show());
                                                                }
                                                            }
                                                            NewSubPbActivity.this.jZn.cJF();
                                                            if (NewSubPbActivity.this.jZz) {
                                                                NewSubPbActivity.this.sr(false);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (view.getTag() != null && (view.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                    if (sparseArray6.get(R.id.tag_clip_board) instanceof PostData) {
                                                        ((PostData) sparseArray6.get(R.id.tag_clip_board)).fp(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new an("c11739").ag("obj_locate", 4));
                                            if (!j.isNetWorkAvailable()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.jZn.cIk();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.Jm(str4);
                                                    return;
                                                }
                                                return;
                                            } else if (tag2 instanceof SparseArray) {
                                                SparseArray<Object> sparseArray7 = (SparseArray) tag2;
                                                if ((sparseArray7.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray7.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray7.put(R.id.tag_from, 0);
                                                    sparseArray7.put(R.id.tag_check_mute_from, 2);
                                                    NewSubPbActivity.this.c(sparseArray7);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        } else if (j.isNetWorkAvailable()) {
                                            NewSubPbActivity.this.jZn.cIk();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.cM(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.jZn.cIk();
                                    SparseArray sparseArray8 = (SparseArray) view.getTag();
                                    if (sparseArray8 != null) {
                                        NewSubPbActivity.this.jZn.a(((Integer) sparseArray8.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray8.get(R.id.tag_del_post_id), ((Integer) sparseArray8.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray8.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new an("c11739").ag("obj_locate", 2));
                                    NewSubPbActivity.this.jZn.cIk();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.jZl.cKc() != null) {
                                        NewSubPbActivity.this.n(NewSubPbActivity.this.jZl.cKc().cDs());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.jZn.cJE();
                                NewSubPbActivity.this.jZn.cJF();
                                if (NewSubPbActivity.this.iQN != null) {
                                    NewSubPbActivity.this.iQN.bdY();
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.jZn.cJE();
                            NewSubPbActivity.this.jZn.cJF();
                            if (NewSubPbActivity.this.iQN != null) {
                                NewSubPbActivity.this.iQN.bdX();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.cEK();
                        if (NewSubPbActivity.this.jZl != null && NewSubPbActivity.this.jZl.cKc() != null && NewSubPbActivity.this.jZl.cKc().aOi() != null && NewSubPbActivity.this.jZl.cKc().aOi().aQx() != null) {
                            TiebaStatic.log(new an("c13402").dh("tid", NewSubPbActivity.this.jZl.cFJ()).s("fid", NewSubPbActivity.this.jZl.cKc().aOi().getFid()).ag("obj_locate", 5).dh("uid", NewSubPbActivity.this.jZl.cKc().aOi().aQx().getUserId()));
                        }
                    }
                }
            }
        };
        this.jZp = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.jZn.cIk();
                    if (NewSubPbActivity.this.jHt != 2 && NewSubPbActivity.this.jHt != 1) {
                        NewSubPbActivity.this.jZn.cJZ();
                    }
                }
                NewSubPbActivity.this.iQN.bdW();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.jZn.cJV();
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
                if (NewSubPbActivity.this.jZn != null && NewSubPbActivity.this.jZn.cJM()) {
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
                        NewSubPbActivity.this.jMc = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.jMd = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.jMc == null || TextUtils.isEmpty(NewSubPbActivity.this.jMd)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.jMe = null;
                        } else {
                            NewSubPbActivity.this.jMe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.jMc = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.jMd = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.jMe = null;
                        } else {
                            NewSubPbActivity.this.jMe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.jMc = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.jMd = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.jMe = null;
                        } else {
                            NewSubPbActivity.this.jMe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.jZn.a(NewSubPbActivity.this.jMO, NewSubPbActivity.this.jMc.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.iiy = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.iiy == null || NewSubPbActivity.this.jLD == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.jLD != null) {
                            NewSubPbActivity.this.jLD.gC(NewSubPbActivity.this.jZl.cKi());
                        }
                        boolean z = NewSubPbActivity.this.jLD.aML() && NewSubPbActivity.this.iiy.getId() != null && NewSubPbActivity.this.iiy.getId().equals(NewSubPbActivity.this.jZl.cKk());
                        if (NewSubPbActivity.this.jZo == null) {
                            NewSubPbActivity.this.jZo = new ad(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aIH);
                            NewSubPbActivity.this.jZn.cN(NewSubPbActivity.this.jZo.getView());
                            NewSubPbActivity.this.jZo.rH(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.jZo.showDialog();
                        boolean z2 = NewSubPbActivity.this.ru(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z3 = (NewSubPbActivity.this.jZl.cKc() == null || NewSubPbActivity.this.jZl.cKc().aOi() == null || !NewSubPbActivity.this.jZl.cKc().aOi().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z) {
                            NewSubPbActivity.this.jZo.cGI().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.jZo.cGI().setText(R.string.mark);
                        }
                        if (booleanValue || z3) {
                            NewSubPbActivity.this.jZo.cGI().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.jZo.cGI().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.cD(view)) {
                            if (NewSubPbActivity.this.jMc != null && !NewSubPbActivity.this.jMc.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        NewSubPbActivity.this.jZo.a(sparseArray2, NewSubPbActivity.this.cCN(), z2);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.jZq = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                        n cKc = NewSubPbActivity.this.jZl.cKc();
                        TbRichText bu = NewSubPbActivity.this.bu(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bu != null && bu.bis() != null) {
                            tbRichTextData = bu.bis().get(NewSubPbActivity.this.jML);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.biy().biJ()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (cKc == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (cKc.bdQ() != null) {
                                        str4 = cKc.bdQ().getName();
                                        str5 = cKc.bdQ().getId();
                                    }
                                    if (cKc.aOi() != null) {
                                        str6 = cKc.aOi().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.jZl.cKp() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.jZl.cKp();
                                    z6 = NewSubPbActivity.this.jZl.cKr();
                                    arrayList2 = NewSubPbActivity.this.jZl.cKq();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.getItem(arrayList2, 0));
                                ImageViewerConfig createConfig = new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false);
                                createConfig.setPostId(String.valueOf(bu.getPostId()));
                                createConfig.setThreadData(NewSubPbActivity.this.aOi());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                                return;
                            }
                            NewSubPbActivity.this.jMM = false;
                            String str7 = "";
                            TbRichText ddL = cKc.cDs().ddL();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(ddL, bu, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (cKc == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (cKc.bdQ() != null) {
                                    str8 = cKc.bdQ().getName();
                                    str9 = cKc.bdQ().getId();
                                }
                                if (cKc.aOi() != null) {
                                    str10 = cKc.aOi().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.jZl.cKp() != null) {
                                concurrentHashMap = NewSubPbActivity.this.jZl.cKp();
                                z4 = NewSubPbActivity.this.jZl.cKr();
                                arrayList = NewSubPbActivity.this.jZl.cKq();
                                i2 = a2 + NewSubPbActivity.this.jZl.getOffset();
                            } else {
                                concurrentHashMap = concurrentHashMap3;
                                i2 = a2;
                                z4 = z3;
                                arrayList = arrayList2;
                            }
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(v.getItem(arrayList, i2));
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList4, 0, str8, str9, str2, z4, str7, true, concurrentHashMap, true, false, false);
                            createConfig2.setThreadData(NewSubPbActivity.this.aOi());
                            createConfig2.setPostId(String.valueOf(bu.getPostId()));
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
    public bk aOi() {
        if (this.jZl == null || this.jZl.cKc() == null) {
            return null;
        }
        return this.jZl.cKc().aOi();
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
            n(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo biy;
        if (tbRichText == tbRichText2) {
            this.jMM = true;
        }
        if (tbRichText != null && tbRichText.bis() != null) {
            int size = tbRichText.bis().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.bis().get(i6) != null && tbRichText.bis().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.bis().get(i6).biy().getWidth() * equipmentDensity;
                    int height = tbRichText.bis().get(i6).biy().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.bis().get(i6).biy().biJ()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.bis().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (biy = tbRichTextData.biy()) != null) {
                            String biL = biy.biL();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = biL;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.jMM) {
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
        if (this.jZo != null) {
            this.jZo.rH(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo biy = tbRichTextData.biy();
        if (biy != null) {
            if (!StringUtils.isNull(biy.biI())) {
                return biy.biI();
            }
            if (biy.getHeight() * biy.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (biy.getHeight() * biy.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (biy.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * biy.getHeight())));
            } else {
                float width = biy.getWidth() / biy.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(biy.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bu(String str, int i) {
        if (this.jZl == null || this.jZl.cKc() == null || str == null || i < 0) {
            return null;
        }
        n cKc = this.jZl.cKc();
        TbRichText a2 = a(cKc.cDs(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(cKc.cDs(), str, i);
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
        TbRichText ddL = postData.ddL();
        if (ddL != null) {
            ArrayList<TbRichTextData> bis = ddL.bis();
            int size = bis.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (bis.get(i3) != null && bis.get(i3).getType() == 8) {
                    i2++;
                    if (bis.get(i3).biy().biL().equals(str)) {
                        int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = bis.get(i3).biy().getWidth() * equipmentDensity;
                        int height = bis.get(i3).biy().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.jML = i3;
                        return ddL;
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
    public void cEK() {
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false) {
            if (this.iQC == null || this.jZl == null || this.jZl.bUc() == null || this.iQC.lb(this.jZl.bUc().replyPrivateFlag)) {
                if (this.iQN.bdL()) {
                    this.iQN.a((PostWriteCallBackData) null);
                    return;
                }
                this.jZn.cJE();
                this.jZn.cJF();
                if (this.iQN != null) {
                    this.iQN.bdZ();
                    return;
                }
                return;
            }
            return;
        }
        if (this.hra == null) {
            this.hra = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.hra.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void na(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void x(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void nb(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.iQC == null || NewSubPbActivity.this.jZl == null || NewSubPbActivity.this.jZl.bUc() == null || NewSubPbActivity.this.iQC.lb(NewSubPbActivity.this.jZl.bUc().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.iQN.bdL()) {
                                NewSubPbActivity.this.iQN.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.jZn.cJE();
                            NewSubPbActivity.this.jZn.cJF();
                            if (NewSubPbActivity.this.iQN != null) {
                                NewSubPbActivity.this.iQN.bdZ();
                            }
                        }
                    }
                }
            });
        }
        if (this.jZl != null && this.jZl.cKc() != null && this.jZl.cKc().bdQ() != null) {
            this.hra.D(this.jZl.cKc().bdQ().getId(), com.baidu.adp.lib.f.b.toLong(this.jZl.cFJ(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ru(boolean z) {
        if (this.jZl == null) {
            return false;
        }
        return ((cCN() != 0) || this.jZl.cKc() == null || this.jZl.cKc().aOi() == null || this.jZl.cKc().aOi().aQx() == null || this.jZl.cKc().aOi().aSx() || TextUtils.equals(this.jZl.cKc().aOi().aQx().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(int i, String str) {
        if (this.jZl.cKd()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.isNetOk()) {
            if (i == 4) {
                this.jZn.Dh(str + "(4)");
            } else {
                this.jZn.xC(R.string.no_data_text);
            }
        } else {
            this.jZn.xC(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pP(boolean z) {
        this.iQN = (com.baidu.tbadk.editortools.pb.h) new i(z).dN(getActivity());
        if (this.iQN != null) {
            this.iQN.a(getPageContext());
            this.iQN.b(this.jZl);
            this.iQN.b(this.ihW);
            this.iQN.a(this.emO);
            this.iQN.a(this.emP);
            this.iQN.bcX().hW(true);
            this.iQN.h(getPageContext());
        }
        if (this.jZn != null) {
            this.jZn.i(this.iQN);
        }
        if (this.iQN != null && this.jZl != null) {
            this.iQN.a(this.jZl.bUc());
            this.iQN.bdW();
        }
        if (this.iQN != null) {
            this.iQN.bea().setDefaultHint(cHy());
            this.iQN.bea().setHint(cHy());
            this.ihQ = this.iQN.bea().getInputView();
            this.ihQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.ihP != null) {
                        if (!NewSubPbActivity.this.ihP.dmy()) {
                            NewSubPbActivity.this.ov(false);
                        }
                        NewSubPbActivity.this.ihP.vn(false);
                    }
                }
            });
        }
    }

    public void cJB() {
        if (!TbadkCoreApplication.isLogin()) {
            this.iQN.bdW();
        } else if (!StringUtils.isNull(this.jZl.cKl())) {
            if (this.jZn.cJI() && com.baidu.adp.lib.util.l.isNetOk()) {
                this.jZn.bSf();
            } else {
                this.jZn.cJL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(R.id.tag_from, 1);
                    c(sparseArray);
                } else {
                    this.jZn.cI(view);
                }
            } else if (booleanValue2) {
                this.jZn.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.jZn.cJS(), getPageContext().getPageActivity());
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
            bVar.kJ(R.string.operation);
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.jZw);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.jZw);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).aSU();
        }
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.jZn.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.jZw;
        userMuteCheckCustomMessage.setTag(this.jZw);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.jZn.a(0, bVar.OU, bVar.loP, z);
            if (bVar.OU) {
                if (bVar.gUw == 1) {
                    if (this.jZn.getListView() instanceof BdTypeListView) {
                        List<o> data = ((BdTypeListView) this.jZn.getListView()).getData();
                        if (!v.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.jZn.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.gUw == 2) {
                    this.jZl.JQ(bVar.mPostId);
                    this.jZn.a(this.jZl.cKc(), this.jZl.cCN(), this.jZl.cKp() != null);
                    if (this.jZl.cKm()) {
                        this.jZl.sv(false);
                        this.jZn.cJG();
                        this.jZl.loadData();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void Jm(String str) {
        if (this.jZl != null && this.jZl.cKc() != null && this.jZl.cKc().aOi() != null && this.jZl.cKc().aOi().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.jZl.cFJ(), str);
            bk aOi = this.jZl.cKc().aOi();
            if (aOi.aPm()) {
                format = format + "&channelid=33833";
            } else if (aOi.aSu()) {
                format = format + "&channelid=33842";
            } else if (aOi.aPn()) {
                format = format + "&channelid=33840";
            }
            Jn(format);
            return;
        }
        this.jLC.JN(str);
    }

    private void Jn(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void n(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.jZl.cKi() && postData.getId() != null && postData.getId().equals(this.jZl.cKk())) {
                z = true;
            }
            MarkData o = this.jZl.o(postData);
            if (o != null) {
                this.jZn.cIk();
                if (this.jLD != null) {
                    this.jLD.a(o);
                    if (!z) {
                        this.jLD.aMN();
                    } else {
                        this.jLD.aMM();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.jZl != null) {
            this.jZl.aA(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.iQN != null) {
            this.iQN.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.iQN.bcX().bbA();
        this.iQN.bdW();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.iQN.b(writeData);
                this.iQN.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l nh = this.iQN.bcX().nh(6);
                if (nh != null && nh.ekV != null) {
                    nh.ekV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.iQN.bdS();
                }
                this.jZn.cJZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hns != null) {
            this.hns.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.aLi().aLn();
        if (this.hns != null) {
            this.hns.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.iuz);
        this.jZn.cbH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
        cFo();
        if (this.hns != null) {
            this.hns.onResume(getPageContext());
        }
        registerListener(this.iuz);
        this.jZn.cbI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hns != null) {
            this.hns.onStop(getPageContext());
        }
        this.iQN.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.jZy));
        this.jZl.cancelLoadData();
        this.jZl.destory();
        this.jZm.cancelLoadData();
        if (this.hns != null) {
            this.hns.onDestory(getPageContext());
        }
        this.jZn.cIk();
        this.jZn.bZX();
        MessageManager.getInstance().unRegisterListener(this.jMy);
        MessageManager.getInstance().unRegisterListener(this.jMz);
        MessageManager.getInstance().unRegisterListener(this.jMA);
        MessageManager.getInstance().unRegisterListener(this.jZw);
        this.jLY = null;
        this.jLZ = null;
        if (this.iQC != null) {
            this.iQC.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jZn.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hns;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View cJN = this.jZn.cJN();
        if (cJN == null || (findViewWithTag = cJN.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean JF(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = ba.getParamPair(ba.getParamStr(str))) != null) {
            this.jZx = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return JF(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(jZk);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void f(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (JF(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                    kVar.mLink = str;
                    kVar.type = 3;
                    kVar.ejY = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
                }
            } else {
                ba.aVa().b(getPageContext(), new String[]{str});
            }
            this.jZx = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void al(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.jZx = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void am(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void an(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void s(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        if (this.jZn != null) {
            return this.jZn.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int biZ() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bjb() {
        if (this.eEq == null) {
            this.eEq = TbRichTextView.u(getPageContext().getPageActivity(), 8);
        }
        return this.eEq;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bjc() {
        if (this.eBD == null) {
            this.eBD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bPQ */
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
        return this.eBD;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bja() {
        if (this.eBC == null) {
            this.eBC = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bjm */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = k.aNQ().isShowImages();
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
                        if (k.aNQ().isShowImages()) {
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
        return this.eBC;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bjd() {
        if (this.eEr == null) {
            this.eEr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cFv */
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
        return this.eEr;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bje() {
        if (this.eEs == null) {
            this.eEs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cFx */
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
        return this.eEs;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bjf() {
        this.eEt = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFw */
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
        return this.eEt;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cDD() {
        return this.jHX;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cDE() {
        return (this.jZl == null || this.jZl.cKc() == null || this.jZl.cKc().aOi() == null || this.jZl.cKc().aOi().aRV()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cDF() {
        if (this.jZl == null || this.jZl.cKc() == null || this.jZl.cKc().aOi() == null) {
            return null;
        }
        return this.jZl.cKc().aOi().aQC();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cDG() {
        if (this.jZl == null) {
            return 0;
        }
        return this.jZl.cCN();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Jh(String str) {
        if (StringUtils.isNull(str) || this.jZl == null || this.jZl.cKc() == null || this.jZl.cKc().aOi() == null || this.jZl.cKc().aOi().aQx() == null) {
            return false;
        }
        return str.equals(this.jZl.cKc().aOi().aQx().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.jZn.cJI() && com.baidu.adp.lib.util.l.isNetOk()) {
            this.jZl.loadData();
        } else {
            this.jZn.cJL();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.jZw);
        userMuteAddAndDelCustomMessage.setTag(this.jZw);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JO(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("bubble_link", "");
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
    public void ap(Context context, String str) {
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
                return com.baidu.tbadk.m.e.bfv().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.jZl != null) {
            if (this.jZl.cKc() != null && this.jZl.cKc().bdQ() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.jZl.cKc().bdQ().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.jZl.cFJ(), 0L));
            if (this.jZl.cKc() != null && this.jZl.cKc().aOi() != null) {
                pageStayDurationItem.setNid(this.jZl.cKc().aOi().getNid());
            }
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public boolean cJC() {
        if (this.jZl != null) {
            return this.jZl.cJC();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.jZn.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jLY.getPageActivity());
        if (aq.isEmpty(str)) {
            aVar.vO(this.jLY.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.vO(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.jZn.showLoadingDialog();
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
        aVar.b(this.jLY).aST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yo(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jLY.getPageActivity());
        aVar.vO(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.jLY).aST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFl() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.vO(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.jLY).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.jLY.getPageActivity(), 2, true, 4);
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
        aVar.b(this.jLY).aST();
    }

    public SubPbModel cJD() {
        return this.jZl;
    }

    public int cCN() {
        if (this.jZl != null) {
            return this.jZl.cCN();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.elr && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.elr && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void ov(boolean z) {
        if (this.ihQ != null && this.ihQ.getText() != null) {
            int selectionEnd = this.ihQ.getSelectionEnd();
            SpannableStringBuilder a2 = this.ihP.a(this.ihQ.getText());
            if (a2 != null) {
                this.ihP.vn(true);
                this.ihQ.setText(a2);
                if (z && this.ihP.dmw() >= 0) {
                    this.ihQ.requestFocus();
                    this.ihQ.setSelection(this.ihP.dmw());
                } else {
                    this.ihQ.setSelection(selectionEnd);
                }
                this.ihP.vm(this.ihP.dmw() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.iQN != null && this.iQN.bcX() != null && this.iQN.bcX().bcZ()) {
            this.iQN.bcX().bbA();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(r rVar) {
        com.baidu.tbadk.core.util.ad.a(rVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.d.a(rVar, getUniqueId(), this);
    }

    public String cHy() {
        if (!aq.isEmpty(this.jTV)) {
            return this.jTV;
        }
        this.jTV = getResources().getString(com.baidu.tieba.pb.pb.main.au.cHn());
        return this.jTV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.jZz = z;
        sr(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sr(boolean z) {
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
        if (this.jZn != null && this.jZn.getListView() != null && this.jZA != null && this.jZA.mPosition != -1) {
            final int headerViewsCount = this.jZA.mPosition + this.jZn.getListView().getHeaderViewsCount();
            if (this.jZA.getView() != null) {
                final int height = this.jZA.getView().getHeight();
                final int height2 = ((rect.height() - this.jZn.cJY()) - this.jZn.getNavigationBarHeight()) - this.jZn.cJX();
                final int i = height - height2;
                if (i > 0) {
                    this.jZn.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.jZn != null && NewSubPbActivity.this.jZn.getListView() != null) {
                                NewSubPbActivity.this.jZn.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.jZn.getNavigationBarHeight() - i);
                            }
                        }
                    });
                } else {
                    this.jZn.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.jZn != null && NewSubPbActivity.this.jZn.getListView() != null) {
                                NewSubPbActivity.this.jZn.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.jZn.getNavigationBarHeight() + (height2 - height));
                            }
                        }
                    });
                }
            }
        }
    }

    private void cFo() {
        if (this.jZl != null && !aq.isEmpty(this.jZl.cFJ())) {
            com.baidu.tbadk.BdToken.c.aLi().o(com.baidu.tbadk.BdToken.b.dtS, com.baidu.adp.lib.f.b.toLong(this.jZl.cFJ(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.jZl == null || aq.isEmpty(this.jZl.cFJ())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.jZl.cFJ(), 0L);
    }
}
