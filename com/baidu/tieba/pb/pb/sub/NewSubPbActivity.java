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
import com.baidu.tbadk.coreExtra.data.aa;
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
    private static String jYe = "tbgametype";
    private View.OnClickListener aIH;
    private com.baidu.adp.lib.d.b<ImageView> eBr;
    private com.baidu.adp.lib.d.b<GifView> eBs;
    private com.baidu.adp.lib.d.b<TextView> eEf;
    private com.baidu.adp.lib.d.b<View> eEg;
    private com.baidu.adp.lib.d.b<LinearLayout> eEh;
    private com.baidu.adp.lib.d.b<RelativeLayout> eEi;
    private az hQO;
    private VoiceManager hnh;
    private com.baidu.tieba.frs.profession.permission.c hqP;
    public aj iPP;
    private com.baidu.tbadk.editortools.pb.h iQa;
    private com.baidu.tieba.write.c ihc;
    private EditText ihd;
    private com.baidu.tieba.pb.pb.main.b.a jGR;
    private e jKS;
    private com.baidu.tbadk.core.view.c jKT;
    private com.baidu.adp.widget.ImageView.a jKW;
    private String jKX;
    private TbRichTextMemeInfo jKY;
    private com.baidu.tieba.pb.pb.report.a jKw;
    private com.baidu.tbadk.baseEditMark.a jKx;
    private PostWriteCallBackData jMA;
    private String jSP;
    private SubPbModel jYf;
    private ForumManageModel jYg;
    private com.baidu.tieba.pb.pb.sub.a jYh;
    private ad jYi;
    private AbsListView.OnScrollListener jYj;
    private TbRichTextView.i jYk;
    private SubPbModel.a jYl;
    private com.baidu.adp.base.d jYm;
    private BdUniqueId jYq;
    private com.baidu.tieba.pb.e<n> jYs;
    private boolean jYt;
    private l jYu;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int jLF = 0;
    PostData ihL = null;
    private a.InterfaceC0471a jLB = null;
    private a jYn = null;
    private a jYo = null;
    private boolean mIsPaused = false;
    private boolean jYp = false;
    private boolean jYr = false;
    private boolean elr = false;
    private com.baidu.tbadk.editortools.pb.c emO = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bdu() {
            NewSubPbActivity.this.jYh.cJu();
        }
    };
    private int jGn = 0;
    private boolean mIsFromSchema = false;
    private com.baidu.tbadk.editortools.pb.b emP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bdt() {
            if (!NewSubPbActivity.this.ihc.dmi()) {
                return (NewSubPbActivity.this.iPP == null || NewSubPbActivity.this.jYf == null || NewSubPbActivity.this.jYf.bUa() == null || NewSubPbActivity.this.iPP.aD(NewSubPbActivity.this.jYf.bUa().replyPrivateFlag, aj.dNH)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.ihc.dmk());
            if (NewSubPbActivity.this.iQa.bdK()) {
                NewSubPbActivity.this.iQa.a(NewSubPbActivity.this.jMA);
            }
            NewSubPbActivity.this.ov(true);
            return true;
        }
    };
    private NewWriteModel.d ihj = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.iQa != null && NewSubPbActivity.this.iQa.bcW() != null) {
                NewSubPbActivity.this.iQa.bcW().hide();
                if (NewSubPbActivity.this.jYf.cJT()) {
                    TiebaStatic.log(new an("c10367").dh("post_id", NewSubPbActivity.this.jYf.bdr()));
                }
            }
            if (z) {
                NewSubPbActivity.this.ihc.Of(null);
                NewSubPbActivity.this.ihc.aX(null);
                NewSubPbActivity.this.ihc.vl(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.ihc.aX(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.ihc.Of(postWriteCallBackData.getErrorString());
                if (!v.isEmpty(NewSubPbActivity.this.ihc.dmg())) {
                    NewSubPbActivity.this.jMA = postWriteCallBackData;
                    if (NewSubPbActivity.this.iQa.bdK()) {
                        NewSubPbActivity.this.iQa.a(NewSubPbActivity.this.jMA);
                    }
                    NewSubPbActivity.this.ov(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.iPP != null) {
                NewSubPbActivity.this.iPP.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.jYh.cJv();
        }
    };
    private CustomMessageListener jLs = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.jYq) {
                NewSubPbActivity.this.jYh.bGf();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.jKT.showSuccessToast(NewSubPbActivity.this.jKS.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.jKS.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.yo(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.cEV();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.jKS.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.jKT.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener jLt = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.jYq) {
                NewSubPbActivity.this.jYh.bGf();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.jKT.showSuccessToast(NewSubPbActivity.this.jKS.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.jKS.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.jKT.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener jLu = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.jYq) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.jYh.bGf();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.lzt;
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
                    NewSubPbActivity.this.jYh.a(sparseArray, z);
                }
            }
        }
    };
    boolean jLG = false;
    private final b.a jLI = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.jKW != null && !TextUtils.isEmpty(NewSubPbActivity.this.jKX)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.jKY == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.jKX));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.jKX;
                        aVar.pkgId = NewSubPbActivity.this.jKY.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.jKY.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.hQO == null) {
                            NewSubPbActivity.this.hQO = new az(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.hQO.j(NewSubPbActivity.this.jKX, NewSubPbActivity.this.jKW.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.jKW = null;
                NewSubPbActivity.this.jKX = null;
            }
        }
    };
    private CustomMessageListener itM = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener hoy = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    com.baidu.tbadk.data.l lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.jYf.cJM() != null && NewSubPbActivity.this.jYf.cJM().cDc() != null && NewSubPbActivity.this.jYf.cJM().cDc().aQx() != null && currentAccount.equals(NewSubPbActivity.this.jYf.cJM().cDc().aQx().getUserId()) && NewSubPbActivity.this.jYf.cJM().cDc().aQx().getPendantData() != null) {
                        NewSubPbActivity.this.jYf.cJM().cDc().aQx().getPendantData().vx(lVar.aOP());
                        NewSubPbActivity.this.jYf.cJM().cDc().aQx().getPendantData().cr(lVar.bcB());
                        NewSubPbActivity.this.jYh.a(NewSubPbActivity.this.jYf.cJM(), NewSubPbActivity.this.jYf.cJM().cDc(), NewSubPbActivity.this.jYf.cJM().coK(), NewSubPbActivity.this.jYf.cJM().aML(), NewSubPbActivity.this.jYf.cCx(), NewSubPbActivity.this.jYf.cJZ() != null);
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
        this.jKS = getPageContext();
        this.jYp = true;
        this.ihc = new com.baidu.tieba.write.c();
        this.ihc.Fu(R.color.cp_cont_h_alpha85);
        this.ihc.Ft(R.color.cp_cont_a);
        bwA();
        cJk();
        initData(bundle);
        initUI();
        ((SubPbView) this.jYh.getRootView()).show();
        pP(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jYh.ss(this.mIsFromSchema);
        this.jKT = new com.baidu.tbadk.core.view.c();
        this.jKT.toastTime = 1000L;
        registerListener(this.jLu);
        registerListener(this.jLs);
        registerListener(this.jLt);
        this.jYq = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.jYq;
        userMuteAddAndDelCustomMessage.setTag(this.jYq);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.jYq;
        userMuteCheckCustomMessage.setTag(this.jYq);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.iPP = new aj(getPageContext());
        this.iPP.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tbadk.core.util.aj.a
            public void q(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.iQa.bdR();
                }
            }
        });
        this.jKw = new com.baidu.tieba.pb.pb.report.a(this);
        this.jKw.w(getUniqueId());
        this.jGR = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.jYh = new com.baidu.tieba.pb.pb.sub.a(this, this.aIH);
        this.jYh.a(this.jYf);
        setContentView(this.jYh.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.jYh.setOnScrollListener(this.jYj);
        this.jYh.b(this);
        this.jYh.setOnImageClickListener(this.jYk);
        this.jYh.setOnLongClickListener(this.mOnLongClickListener);
        this.jYh.f(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.jYf != null) {
                    NewSubPbActivity.this.jYf.loadData();
                }
            }
        });
        this.jYh.a(this.jYn);
        this.jYh.b(this.jYo);
        if (this.jYf != null && this.jYf.cJm() && !this.jYf.cJY()) {
            this.jYh.cJA().setVisibility(8);
        } else {
            this.jYh.cJA().setVisibility(0);
        }
        if (this.jYf != null && !this.jYf.cJm()) {
            this.jYh.setIsFromPb(false);
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
        this.jYf = new SubPbModel(getPageContext());
        this.jYf.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                NewSubPbActivity.this.jYh.u(postData);
                NewSubPbActivity.this.jYh.b((BdListView.e) null);
            }
        });
        this.jYg = new ForumManageModel(getPageContext());
        this.jYg.setLoadDataCallBack(this.jYm);
        this.hnh = new VoiceManager();
        this.hnh.onCreate(getPageContext());
        this.jKx = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.jKx != null) {
            this.jKx.a(this.jLB);
        }
        if (bundle != null) {
            this.jYf.initWithBundle(bundle);
        } else {
            this.jYf.initWithIntent(getIntent());
        }
        this.jYf.a(this.jYl);
        if (this.jYf.cJm()) {
            this.jYf.loadData();
        } else {
            this.jYf.cJR();
        }
    }

    public void cJk() {
        this.jYl = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, n nVar) {
                if (NewSubPbActivity.this.jYh != null) {
                    NewSubPbActivity.this.jYh.cJv();
                    if (!z) {
                        NewSubPbActivity.this.br(i, str);
                        return;
                    }
                    NewSubPbActivity.this.jYh.hideNoDataView();
                    if (nVar != null) {
                        if (nVar.cDc() != null || NewSubPbActivity.this.jYf != null) {
                            nVar.cDc().a(NewSubPbActivity.this.jYf.cJX());
                        }
                        if (NewSubPbActivity.this.jYh != null) {
                            NewSubPbActivity.this.pP(nVar.aOi() != null && nVar.aOi().isBjh());
                            if (NewSubPbActivity.this.iQa != null && NewSubPbActivity.this.iQa.bcW() != null) {
                                NewSubPbActivity.this.iQa.bcW().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.jYh.a(nVar, NewSubPbActivity.this.jYf.cCx(), NewSubPbActivity.this.jYf.cJZ() != null);
                            if (NewSubPbActivity.this.jYp) {
                                NewSubPbActivity.this.jYh.getListView().setSelectionFromTop(NewSubPbActivity.this.jYh.getListView().getHeaderViewsCount() + 1, -com.baidu.adp.lib.util.l.getDimens(NewSubPbActivity.this, R.dimen.tbds18));
                                NewSubPbActivity.this.cJl();
                                NewSubPbActivity.this.jYp = false;
                            }
                        }
                        if (NewSubPbActivity.this.iQa != null) {
                            NewSubPbActivity.this.iQa.a(nVar.bUa());
                            NewSubPbActivity.this.iQa.setThreadData(nVar.aOi());
                        }
                        if (NewSubPbActivity.this.jYs == null) {
                            NewSubPbActivity.this.jYs = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.jYs.setData(nVar);
                        NewSubPbActivity.this.jYs.setType(0);
                        NewSubPbActivity.this.iPP.a(NewSubPbActivity.this.jYf.cKc());
                    }
                }
            }
        };
        this.jLB = new a.InterfaceC0471a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0471a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.jKx != null) {
                        NewSubPbActivity.this.jKx.gC(z2);
                    }
                    MarkData aMO = NewSubPbActivity.this.jKx.aMO();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(aMO);
                        if (NewSubPbActivity.this.jKx != null) {
                            if (aMO != null) {
                                NewSubPbActivity.this.jYf.su(true);
                                NewSubPbActivity.this.jYf.JQ(NewSubPbActivity.this.jYf.bdr());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.jYh != null) {
                                NewSubPbActivity.this.jYh.st(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.jYf.su(false);
                        NewSubPbActivity.this.jYf.JQ(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.jYh != null) {
                            NewSubPbActivity.this.jYh.st(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.jYn = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.jYf.cJM() != null && NewSubPbActivity.this.jYf.cJM().aOi() != null && NewSubPbActivity.this.jYf.cJM().aOi().aQx() != null) {
                    str = String.valueOf(NewSubPbActivity.this.jYf.cJM().aOi().aQx().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.jYf.cJM().bdP().getId(), NewSubPbActivity.this.jYf.cJM().bdP().getName(), NewSubPbActivity.this.jYf.cJM().aOi().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.jYo = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.jYg.dek() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.jYf != null && NewSubPbActivity.this.jYf.cJM() != null && NewSubPbActivity.this.jYf.cJM().bdP() != null && NewSubPbActivity.this.jYf.cJM().aOi() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.jYg.MG(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.jYg.a(NewSubPbActivity.this.jYf.cJM().bdP().getId(), NewSubPbActivity.this.jYf.cJM().bdP().getName(), NewSubPbActivity.this.jYf.cJM().aOi().getId(), valueOf, i2, i, z, NewSubPbActivity.this.jYf.cJM().aOi().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.jYm = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.jYh.a(NewSubPbActivity.this.jYg.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.jYg.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.jZp != 1002 || bVar.fEF) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.jYh.a(1, dVar.OU, dVar.lnC, true);
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

    public void bwA() {
        registerListener(this.hoy);
        this.aIH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v85, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostData postData;
                SparseArray sparseArray;
                boolean z = false;
                if (view != null || NewSubPbActivity.this.jYh != null) {
                    if (view == NewSubPbActivity.this.jYh.cJG()) {
                        NewSubPbActivity.this.jYh.cHU();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ba.aUZ().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.jYh.bZu()) {
                        if (view != NewSubPbActivity.this.jYh.cJz()) {
                            if (view != NewSubPbActivity.this.jYh.cJy()) {
                                if (view == NewSubPbActivity.this.jYh.cJt()) {
                                    NewSubPbActivity.this.jYh.cHU();
                                    if (NewSubPbActivity.this.jYf.loadData()) {
                                        NewSubPbActivity.this.jYh.cJr();
                                    }
                                } else if (view == NewSubPbActivity.this.jYh.cJA() || view == NewSubPbActivity.this.jYh.cJB() || view == NewSubPbActivity.this.jYh.cJD()) {
                                    if (NewSubPbActivity.this.jYr) {
                                        NewSubPbActivity.this.jYr = false;
                                        return;
                                    }
                                    if (NewSubPbActivity.this.jYf.cJM() != null && NewSubPbActivity.this.jYf.cJM().aOi() != null) {
                                        z = au.a(NewSubPbActivity.this.jYf.cJM().aOi().getBaijiahaoData());
                                    }
                                    if (z) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.jYf.cFt(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.jYf.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.jYf.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.jYf.cJM() != null && NewSubPbActivity.this.jYf.cJM().aOi() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.jYf.cJM().aOi().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.jYf.cFt(), NewSubPbActivity.this.jYf.bdr(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.jYf.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.jYf.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.jYh.cJE() == null || view != NewSubPbActivity.this.jYh.cJE().cGs()) {
                                    if (NewSubPbActivity.this.jYh.cJE() == null || view != NewSubPbActivity.this.jYh.cJE().cGv()) {
                                        if (NewSubPbActivity.this.jYh.cJE() == null || view != NewSubPbActivity.this.jYh.cJE().cGt()) {
                                            if (NewSubPbActivity.this.jYh.cJE() == null || view != NewSubPbActivity.this.jYh.cJE().cGu()) {
                                                if (NewSubPbActivity.this.jYh.cJE() == null || view != NewSubPbActivity.this.jYh.cJE().cGw()) {
                                                    if (view == NewSubPbActivity.this.jYh.cJx() || view == NewSubPbActivity.this.jYh.cJD()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.iQa.bdU()) {
                                                                NewSubPbActivity.this.iQa.bdV();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.iQa.yp(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view != null && (view.getTag() instanceof l)) {
                                                        NewSubPbActivity.this.jYu = (l) view.getTag();
                                                        if (bc.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.jYr) {
                                                                NewSubPbActivity.this.jYr = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.iPP == null || NewSubPbActivity.this.jYf == null || NewSubPbActivity.this.jYf.bUa() == null || NewSubPbActivity.this.iPP.kZ(NewSubPbActivity.this.jYf.bUa().replyPrivateFlag)) && (sparseArray = (SparseArray) view.getTag(R.id.tag_from)) != null) {
                                                                if (sparseArray.get(R.id.tag_clip_board) instanceof PostData) {
                                                                    PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                    if (postData2 != null && postData2.aQx() != null) {
                                                                        MetaData aQx = postData2.aQx();
                                                                        NewSubPbActivity.this.iQa.setReplyId(aQx.getUserId());
                                                                        boolean booleanValue = sparseArray.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue() : true;
                                                                        if (!(view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) || view.getTag(R.id.tag_subpb_ban_display_keyboard) != Boolean.TRUE) {
                                                                            r6 = false;
                                                                        }
                                                                        if (!booleanValue) {
                                                                            if (!r6) {
                                                                                NewSubPbActivity.this.iQa.yq("");
                                                                            }
                                                                        } else if (!r6) {
                                                                            NewSubPbActivity.this.iQa.yq(aQx.getName_show());
                                                                        }
                                                                    }
                                                                    NewSubPbActivity.this.jYh.cJp();
                                                                }
                                                                if (NewSubPbActivity.this.jYt) {
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
                                                        if (NewSubPbActivity.this.jYi == null || view != NewSubPbActivity.this.jYi.cGu()) {
                                                            if (NewSubPbActivity.this.jYi == null || view != NewSubPbActivity.this.jYi.cGs()) {
                                                                if (NewSubPbActivity.this.jYi == null || view != NewSubPbActivity.this.jYi.cGv()) {
                                                                    if (NewSubPbActivity.this.jYi == null || view != NewSubPbActivity.this.jYi.cGw()) {
                                                                        if (NewSubPbActivity.this.jYi == null || view != NewSubPbActivity.this.jYi.cGy()) {
                                                                            if (NewSubPbActivity.this.jYi == null || view != NewSubPbActivity.this.jYi.cGz()) {
                                                                                if (NewSubPbActivity.this.jYi != null && view == NewSubPbActivity.this.jYi.cGt()) {
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
                                                                                            NewSubPbActivity.this.jYh.cI(view);
                                                                                            return;
                                                                                        } else if (booleanValue3) {
                                                                                            NewSubPbActivity.this.jYh.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                        if (postData3.getType() != PostData.lkK && !TextUtils.isEmpty(postData3.getBimg_url()) && k.aNQ().isShowImages()) {
                                                                                            NewSubPbActivity.this.JN(postData3.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.jKW != null && !TextUtils.isEmpty(NewSubPbActivity.this.jKX)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.hQO == null) {
                                                                                        NewSubPbActivity.this.hQO = new az(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.hQO.j(NewSubPbActivity.this.jKX, NewSubPbActivity.this.jKW.getImageByte());
                                                                                    NewSubPbActivity.this.jKW = null;
                                                                                    NewSubPbActivity.this.jKX = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.jKW != null && !TextUtils.isEmpty(NewSubPbActivity.this.jKX)) {
                                                                            if (NewSubPbActivity.this.jKY == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.jKX));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.jKX;
                                                                                aVar.pkgId = NewSubPbActivity.this.jKY.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.jKY.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.jKW = null;
                                                                            NewSubPbActivity.this.jKX = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.ihL != null) {
                                                                        NewSubPbActivity.this.ihL.fp(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.ihL = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.jYh.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                NewSubPbActivity.this.Jl((String) tag);
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
                                                            if (NewSubPbActivity.this.jYf != null) {
                                                                TiebaStatic.log(new an("c13700").dh("tid", NewSubPbActivity.this.jYf.cFu()).dh("fid", NewSubPbActivity.this.jYf.getFromForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dh("post_id", postData.getId()).ag("obj_type", 3));
                                                            }
                                                            if (postData.aQx() != null) {
                                                                MetaData aQx2 = postData.aQx();
                                                                NewSubPbActivity.this.iQa.setReplyId(aQx2.getUserId());
                                                                if (!(sparseArray5.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray5.get(R.id.tag_is_subpb)).booleanValue() : true)) {
                                                                    NewSubPbActivity.this.iQa.yq("");
                                                                } else {
                                                                    NewSubPbActivity.this.iQa.yq(aQx2.getName_show());
                                                                }
                                                            }
                                                            NewSubPbActivity.this.jYh.cJp();
                                                            if (NewSubPbActivity.this.jYt) {
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
                                            NewSubPbActivity.this.jYh.cHU();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.Jl(str4);
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
                                            NewSubPbActivity.this.jYh.cHU();
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
                                    NewSubPbActivity.this.jYh.cHU();
                                    SparseArray sparseArray8 = (SparseArray) view.getTag();
                                    if (sparseArray8 != null) {
                                        NewSubPbActivity.this.jYh.a(((Integer) sparseArray8.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray8.get(R.id.tag_del_post_id), ((Integer) sparseArray8.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray8.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new an("c11739").ag("obj_locate", 2));
                                    NewSubPbActivity.this.jYh.cHU();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.jYf.cJM() != null) {
                                        NewSubPbActivity.this.n(NewSubPbActivity.this.jYf.cJM().cDc());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.jYh.cJo();
                                NewSubPbActivity.this.jYh.cJp();
                                if (NewSubPbActivity.this.iQa != null) {
                                    NewSubPbActivity.this.iQa.bdX();
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.jYh.cJo();
                            NewSubPbActivity.this.jYh.cJp();
                            if (NewSubPbActivity.this.iQa != null) {
                                NewSubPbActivity.this.iQa.bdW();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.cEu();
                        if (NewSubPbActivity.this.jYf != null && NewSubPbActivity.this.jYf.cJM() != null && NewSubPbActivity.this.jYf.cJM().aOi() != null && NewSubPbActivity.this.jYf.cJM().aOi().aQx() != null) {
                            TiebaStatic.log(new an("c13402").dh("tid", NewSubPbActivity.this.jYf.cFt()).s("fid", NewSubPbActivity.this.jYf.cJM().aOi().getFid()).ag("obj_locate", 5).dh("uid", NewSubPbActivity.this.jYf.cJM().aOi().aQx().getUserId()));
                        }
                    }
                }
            }
        };
        this.jYj = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.jYh.cHU();
                    if (NewSubPbActivity.this.jGn != 2 && NewSubPbActivity.this.jGn != 1) {
                        NewSubPbActivity.this.jYh.cJJ();
                    }
                }
                NewSubPbActivity.this.iQa.bdV();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.jYh.cJF();
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
                if (NewSubPbActivity.this.jYh != null && NewSubPbActivity.this.jYh.cJw()) {
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
                        NewSubPbActivity.this.jKW = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.jKX = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.jKW == null || TextUtils.isEmpty(NewSubPbActivity.this.jKX)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.jKY = null;
                        } else {
                            NewSubPbActivity.this.jKY = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.jKW = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.jKX = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.jKY = null;
                        } else {
                            NewSubPbActivity.this.jKY = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.jKW = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.jKX = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.jKY = null;
                        } else {
                            NewSubPbActivity.this.jKY = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.jYh.a(NewSubPbActivity.this.jLI, NewSubPbActivity.this.jKW.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.ihL = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.ihL == null || NewSubPbActivity.this.jKx == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.jKx != null) {
                            NewSubPbActivity.this.jKx.gC(NewSubPbActivity.this.jYf.cJS());
                        }
                        boolean z = NewSubPbActivity.this.jKx.aML() && NewSubPbActivity.this.ihL.getId() != null && NewSubPbActivity.this.ihL.getId().equals(NewSubPbActivity.this.jYf.cJU());
                        if (NewSubPbActivity.this.jYi == null) {
                            NewSubPbActivity.this.jYi = new ad(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aIH);
                            NewSubPbActivity.this.jYh.cN(NewSubPbActivity.this.jYi.getView());
                            NewSubPbActivity.this.jYi.rH(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.jYi.showDialog();
                        boolean z2 = NewSubPbActivity.this.ru(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z3 = (NewSubPbActivity.this.jYf.cJM() == null || NewSubPbActivity.this.jYf.cJM().aOi() == null || !NewSubPbActivity.this.jYf.cJM().aOi().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z) {
                            NewSubPbActivity.this.jYi.cGs().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.jYi.cGs().setText(R.string.mark);
                        }
                        if (booleanValue || z3) {
                            NewSubPbActivity.this.jYi.cGs().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.jYi.cGs().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.cD(view)) {
                            if (NewSubPbActivity.this.jKW != null && !NewSubPbActivity.this.jKW.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        NewSubPbActivity.this.jYi.a(sparseArray2, NewSubPbActivity.this.cCx(), z2);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.jYk = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                        n cJM = NewSubPbActivity.this.jYf.cJM();
                        TbRichText bu = NewSubPbActivity.this.bu(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bu != null && bu.biq() != null) {
                            tbRichTextData = bu.biq().get(NewSubPbActivity.this.jLF);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.biw().biH()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (cJM == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (cJM.bdP() != null) {
                                        str4 = cJM.bdP().getName();
                                        str5 = cJM.bdP().getId();
                                    }
                                    if (cJM.aOi() != null) {
                                        str6 = cJM.aOi().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.jYf.cJZ() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.jYf.cJZ();
                                    z6 = NewSubPbActivity.this.jYf.cKb();
                                    arrayList2 = NewSubPbActivity.this.jYf.cKa();
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
                            NewSubPbActivity.this.jLG = false;
                            String str7 = "";
                            TbRichText ddw = cJM.cDc().ddw();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(ddw, bu, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (cJM == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (cJM.bdP() != null) {
                                    str8 = cJM.bdP().getName();
                                    str9 = cJM.bdP().getId();
                                }
                                if (cJM.aOi() != null) {
                                    str10 = cJM.aOi().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.jYf.cJZ() != null) {
                                concurrentHashMap = NewSubPbActivity.this.jYf.cJZ();
                                z4 = NewSubPbActivity.this.jYf.cKb();
                                arrayList = NewSubPbActivity.this.jYf.cKa();
                                i2 = a2 + NewSubPbActivity.this.jYf.getOffset();
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
        if (this.jYf == null || this.jYf.cJM() == null) {
            return null;
        }
        return this.jYf.cJM().aOi();
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
        TbRichTextImageInfo biw;
        if (tbRichText == tbRichText2) {
            this.jLG = true;
        }
        if (tbRichText != null && tbRichText.biq() != null) {
            int size = tbRichText.biq().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.biq().get(i6) != null && tbRichText.biq().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.biq().get(i6).biw().getWidth() * equipmentDensity;
                    int height = tbRichText.biq().get(i6).biw().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.biq().get(i6).biw().biH()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.biq().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (biw = tbRichTextData.biw()) != null) {
                            String biJ = biw.biJ();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = biJ;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.jLG) {
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
        if (this.jYi != null) {
            this.jYi.rH(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo biw = tbRichTextData.biw();
        if (biw != null) {
            if (!StringUtils.isNull(biw.biG())) {
                return biw.biG();
            }
            if (biw.getHeight() * biw.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (biw.getHeight() * biw.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (biw.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * biw.getHeight())));
            } else {
                float width = biw.getWidth() / biw.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(biw.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bu(String str, int i) {
        if (this.jYf == null || this.jYf.cJM() == null || str == null || i < 0) {
            return null;
        }
        n cJM = this.jYf.cJM();
        TbRichText a2 = a(cJM.cDc(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(cJM.cDc(), str, i);
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
        TbRichText ddw = postData.ddw();
        if (ddw != null) {
            ArrayList<TbRichTextData> biq = ddw.biq();
            int size = biq.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (biq.get(i3) != null && biq.get(i3).getType() == 8) {
                    i2++;
                    if (biq.get(i3).biw().biJ().equals(str)) {
                        int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = biq.get(i3).biw().getWidth() * equipmentDensity;
                        int height = biq.get(i3).biw().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.jLF = i3;
                        return ddw;
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
    public void cEu() {
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false) {
            if (this.iPP == null || this.jYf == null || this.jYf.bUa() == null || this.iPP.kZ(this.jYf.bUa().replyPrivateFlag)) {
                if (this.iQa.bdK()) {
                    this.iQa.a((PostWriteCallBackData) null);
                    return;
                }
                this.jYh.cJo();
                this.jYh.cJp();
                if (this.iQa != null) {
                    this.iQa.bdY();
                    return;
                }
                return;
            }
            return;
        }
        if (this.hqP == null) {
            this.hqP = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.hqP.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void na(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void x(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void nb(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.iPP == null || NewSubPbActivity.this.jYf == null || NewSubPbActivity.this.jYf.bUa() == null || NewSubPbActivity.this.iPP.kZ(NewSubPbActivity.this.jYf.bUa().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.iQa.bdK()) {
                                NewSubPbActivity.this.iQa.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.jYh.cJo();
                            NewSubPbActivity.this.jYh.cJp();
                            if (NewSubPbActivity.this.iQa != null) {
                                NewSubPbActivity.this.iQa.bdY();
                            }
                        }
                    }
                }
            });
        }
        if (this.jYf != null && this.jYf.cJM() != null && this.jYf.cJM().bdP() != null) {
            this.hqP.D(this.jYf.cJM().bdP().getId(), com.baidu.adp.lib.f.b.toLong(this.jYf.cFt(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ru(boolean z) {
        if (this.jYf == null) {
            return false;
        }
        return ((cCx() != 0) || this.jYf.cJM() == null || this.jYf.cJM().aOi() == null || this.jYf.cJM().aOi().aQx() == null || this.jYf.cJM().aOi().aSx() || TextUtils.equals(this.jYf.cJM().aOi().aQx().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(int i, String str) {
        if (this.jYf.cJN()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.isNetOk()) {
            if (i == 4) {
                this.jYh.Dh(str + "(4)");
            } else {
                this.jYh.xA(R.string.no_data_text);
            }
        } else {
            this.jYh.xA(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pP(boolean z) {
        this.iQa = (com.baidu.tbadk.editortools.pb.h) new i(z).dN(getActivity());
        if (this.iQa != null) {
            this.iQa.a(getPageContext());
            this.iQa.b(this.jYf);
            this.iQa.b(this.ihj);
            this.iQa.a(this.emO);
            this.iQa.a(this.emP);
            this.iQa.bcW().hW(true);
            this.iQa.h(getPageContext());
        }
        if (this.jYh != null) {
            this.jYh.i(this.iQa);
        }
        if (this.iQa != null && this.jYf != null) {
            this.iQa.a(this.jYf.bUa());
            this.iQa.bdV();
        }
        if (this.iQa != null) {
            this.iQa.bdZ().setDefaultHint(cHi());
            this.iQa.bdZ().setHint(cHi());
            this.ihd = this.iQa.bdZ().getInputView();
            this.ihd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.ihc != null) {
                        if (!NewSubPbActivity.this.ihc.dmj()) {
                            NewSubPbActivity.this.ov(false);
                        }
                        NewSubPbActivity.this.ihc.vm(false);
                    }
                }
            });
        }
    }

    public void cJl() {
        if (!TbadkCoreApplication.isLogin()) {
            this.iQa.bdV();
        } else if (!StringUtils.isNull(this.jYf.cJV())) {
            if (this.jYh.cJs() && com.baidu.adp.lib.util.l.isNetOk()) {
                this.jYh.bSd();
            } else {
                this.jYh.cJv();
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
                    this.jYh.cI(view);
                }
            } else if (booleanValue2) {
                this.jYh.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.jYh.cJC(), getPageContext().getPageActivity());
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
            bVar.kH(R.string.operation);
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.jYq);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.jYq);
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
        this.jYh.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.jYq;
        userMuteCheckCustomMessage.setTag(this.jYq);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.jYh.a(0, bVar.OU, bVar.lnC, z);
            if (bVar.OU) {
                if (bVar.gUl == 1) {
                    if (this.jYh.getListView() instanceof BdTypeListView) {
                        List<o> data = ((BdTypeListView) this.jYh.getListView()).getData();
                        if (!v.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.jYh.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.gUl == 2) {
                    this.jYf.JP(bVar.mPostId);
                    this.jYh.a(this.jYf.cJM(), this.jYf.cCx(), this.jYf.cJZ() != null);
                    if (this.jYf.cJW()) {
                        this.jYf.sv(false);
                        this.jYh.cJq();
                        this.jYf.loadData();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void Jl(String str) {
        if (this.jYf != null && this.jYf.cJM() != null && this.jYf.cJM().aOi() != null && this.jYf.cJM().aOi().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.jYf.cFt(), str);
            bk aOi = this.jYf.cJM().aOi();
            if (aOi.aPm()) {
                format = format + "&channelid=33833";
            } else if (aOi.aSu()) {
                format = format + "&channelid=33842";
            } else if (aOi.aPn()) {
                format = format + "&channelid=33840";
            }
            Jm(format);
            return;
        }
        this.jKw.JM(str);
    }

    private void Jm(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void n(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.jYf.cJS() && postData.getId() != null && postData.getId().equals(this.jYf.cJU())) {
                z = true;
            }
            MarkData o = this.jYf.o(postData);
            if (o != null) {
                this.jYh.cHU();
                if (this.jKx != null) {
                    this.jKx.a(o);
                    if (!z) {
                        this.jKx.aMN();
                    } else {
                        this.jKx.aMM();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.jYf != null) {
            this.jYf.aA(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.iQa != null) {
            this.iQa.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.iQa.bcW().bbz();
        this.iQa.bdV();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.iQa.b(writeData);
                this.iQa.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l nf = this.iQa.bcW().nf(6);
                if (nf != null && nf.ekV != null) {
                    nf.ekV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.iQa.bdR();
                }
                this.jYh.cJJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hnh != null) {
            this.hnh.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.aLi().aLn();
        if (this.hnh != null) {
            this.hnh.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.itM);
        this.jYh.cbz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
        cEY();
        if (this.hnh != null) {
            this.hnh.onResume(getPageContext());
        }
        registerListener(this.itM);
        this.jYh.cbA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hnh != null) {
            this.hnh.onStop(getPageContext());
        }
        this.iQa.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.jYs));
        this.jYf.cancelLoadData();
        this.jYf.destory();
        this.jYg.cancelLoadData();
        if (this.hnh != null) {
            this.hnh.onDestory(getPageContext());
        }
        this.jYh.cHU();
        this.jYh.bZP();
        MessageManager.getInstance().unRegisterListener(this.jLs);
        MessageManager.getInstance().unRegisterListener(this.jLt);
        MessageManager.getInstance().unRegisterListener(this.jLu);
        MessageManager.getInstance().unRegisterListener(this.jYq);
        this.jKS = null;
        this.jKT = null;
        if (this.iPP != null) {
            this.iPP.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jYh.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hnh;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View cJx = this.jYh.cJx();
        if (cJx == null || (findViewWithTag = cJx.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean JE(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = ba.getParamPair(ba.getParamStr(str))) != null) {
            this.jYr = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return JE(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(jYe);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void f(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (JE(str)) {
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
                ba.aUZ().b(getPageContext(), new String[]{str});
            }
            this.jYr = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void al(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.jYr = true;
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
        if (this.jYh != null) {
            return this.jYh.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int biX() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> biZ() {
        if (this.eEf == null) {
            this.eEf = TbRichTextView.u(getPageContext().getPageActivity(), 8);
        }
        return this.eEf;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bja() {
        if (this.eBs == null) {
            this.eBs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bPO */
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
        return this.eBs;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> biY() {
        if (this.eBr == null) {
            this.eBr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bjk */
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
        return this.eBr;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bjb() {
        if (this.eEg == null) {
            this.eEg = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cFf */
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
        return this.eEg;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bjc() {
        if (this.eEh == null) {
            this.eEh = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cFh */
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
        return this.eEh;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bjd() {
        this.eEi = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFg */
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
        return this.eEi;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cDn() {
        return this.jGR;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cDo() {
        return (this.jYf == null || this.jYf.cJM() == null || this.jYf.cJM().aOi() == null || this.jYf.cJM().aOi().aRV()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cDp() {
        if (this.jYf == null || this.jYf.cJM() == null || this.jYf.cJM().aOi() == null) {
            return null;
        }
        return this.jYf.cJM().aOi().aQC();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cDq() {
        if (this.jYf == null) {
            return 0;
        }
        return this.jYf.cCx();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Jg(String str) {
        if (StringUtils.isNull(str) || this.jYf == null || this.jYf.cJM() == null || this.jYf.cJM().aOi() == null || this.jYf.cJM().aOi().aQx() == null) {
            return false;
        }
        return str.equals(this.jYf.cJM().aOi().aQx().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.jYh.cJs() && com.baidu.adp.lib.util.l.isNetOk()) {
            this.jYf.loadData();
        } else {
            this.jYh.cJv();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.jYq);
        userMuteAddAndDelCustomMessage.setTag(this.jYq);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JN(String str) {
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
                return com.baidu.tbadk.m.e.bfu().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.jYf != null) {
            if (this.jYf.cJM() != null && this.jYf.cJM().bdP() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.jYf.cJM().bdP().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.jYf.cFt(), 0L));
            if (this.jYf.cJM() != null && this.jYf.cJM().aOi() != null) {
                pageStayDurationItem.setNid(this.jYf.cJM().aOi().getNid());
            }
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public boolean cJm() {
        if (this.jYf != null) {
            return this.jYf.cJm();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.jYh.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jKS.getPageActivity());
        if (aq.isEmpty(str)) {
            aVar.vO(this.jKS.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.vO(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.jYh.showLoadingDialog();
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
        aVar.b(this.jKS).aST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yo(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jKS.getPageActivity());
        aVar.vO(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.jKS).aST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEV() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.vO(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.jKS).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.jKS.getPageActivity(), 2, true, 4);
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
        aVar.b(this.jKS).aST();
    }

    public SubPbModel cJn() {
        return this.jYf;
    }

    public int cCx() {
        if (this.jYf != null) {
            return this.jYf.cCx();
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
        if (this.ihd != null && this.ihd.getText() != null) {
            int selectionEnd = this.ihd.getSelectionEnd();
            SpannableStringBuilder a2 = this.ihc.a(this.ihd.getText());
            if (a2 != null) {
                this.ihc.vm(true);
                this.ihd.setText(a2);
                if (z && this.ihc.dmh() >= 0) {
                    this.ihd.requestFocus();
                    this.ihd.setSelection(this.ihc.dmh());
                } else {
                    this.ihd.setSelection(selectionEnd);
                }
                this.ihc.vl(this.ihc.dmh() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.iQa != null && this.iQa.bcW() != null && this.iQa.bcW().bcY()) {
            this.iQa.bcW().bbz();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(r rVar) {
        com.baidu.tbadk.core.util.ad.a(rVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.d.a(rVar, getUniqueId(), this);
    }

    public String cHi() {
        if (!aq.isEmpty(this.jSP)) {
            return this.jSP;
        }
        this.jSP = getResources().getString(com.baidu.tieba.pb.pb.main.au.cGX());
        return this.jSP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.jYt = z;
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
        if (this.jYh != null && this.jYh.getListView() != null && this.jYu != null && this.jYu.mPosition != -1) {
            final int headerViewsCount = this.jYu.mPosition + this.jYh.getListView().getHeaderViewsCount();
            if (this.jYu.getView() != null) {
                final int height = this.jYu.getView().getHeight();
                final int height2 = ((rect.height() - this.jYh.cJI()) - this.jYh.getNavigationBarHeight()) - this.jYh.cJH();
                final int i = height - height2;
                if (i > 0) {
                    this.jYh.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.jYh != null && NewSubPbActivity.this.jYh.getListView() != null) {
                                NewSubPbActivity.this.jYh.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.jYh.getNavigationBarHeight() - i);
                            }
                        }
                    });
                } else {
                    this.jYh.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.jYh != null && NewSubPbActivity.this.jYh.getListView() != null) {
                                NewSubPbActivity.this.jYh.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.jYh.getNavigationBarHeight() + (height2 - height));
                            }
                        }
                    });
                }
            }
        }
    }

    private void cEY() {
        if (this.jYf != null && !aq.isEmpty(this.jYf.cFt())) {
            com.baidu.tbadk.BdToken.c.aLi().o(com.baidu.tbadk.BdToken.b.dtS, com.baidu.adp.lib.f.b.toLong(this.jYf.cFt(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.jYf == null || aq.isEmpty(this.jYf.cFt())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.jYf.cFt(), 0L);
    }
}
