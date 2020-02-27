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
    private static String iUw = "tbgametype";
    private View.OnClickListener akt;
    private com.baidu.adp.lib.d.b<ImageView> dMm;
    private com.baidu.adp.lib.d.b<GifView> dMn;
    private com.baidu.adp.lib.d.b<TextView> dPa;
    private com.baidu.adp.lib.d.b<View> dPb;
    private com.baidu.adp.lib.d.b<LinearLayout> dPc;
    private com.baidu.adp.lib.d.b<RelativeLayout> dPd;
    private ar gQz;
    private VoiceManager goj;
    private com.baidu.tieba.frs.profession.permission.c grK;
    private com.baidu.tbadk.editortools.pb.h hPF;
    public aj hPw;
    private com.baidu.tieba.write.c hgO;
    private EditText hgP;
    private com.baidu.tieba.pb.pb.main.b.a iEi;
    private e iHU;
    private com.baidu.tbadk.core.view.d iHV;
    private com.baidu.adp.widget.ImageView.a iHY;
    private String iHZ;
    private com.baidu.tieba.pb.pb.report.a iHy;
    private com.baidu.tbadk.baseEditMark.a iHz;
    private TbRichTextMemeInfo iIa;
    private PostWriteCallBackData iJz;
    private String iPr;
    private w iUA;
    private AbsListView.OnScrollListener iUB;
    private TbRichTextView.i iUC;
    private SubPbModel.a iUD;
    private com.baidu.adp.base.d iUE;
    private BdUniqueId iUI;
    private com.baidu.tieba.pb.e<l> iUK;
    private boolean iUL;
    private k iUM;
    private SubPbModel iUx;
    private ForumManageModel iUy;
    private com.baidu.tieba.pb.pb.sub.a iUz;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int iIF = 0;
    PostData hhx = null;
    private a.InterfaceC0374a iIC = null;
    private a iUF = null;
    private a iUG = null;
    private boolean ees = false;
    private boolean iUH = false;
    private boolean iUJ = false;
    private boolean dwV = false;
    private com.baidu.tbadk.editortools.pb.c dys = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aOP() {
            NewSubPbActivity.this.iUz.crv();
        }
    };
    private int iDE = 0;
    private boolean mIsFromSchema = false;
    private com.baidu.tbadk.editortools.pb.b dyt = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOO() {
            if (!NewSubPbActivity.this.hgO.cUc()) {
                return (NewSubPbActivity.this.hPw == null || NewSubPbActivity.this.iUx == null || NewSubPbActivity.this.iUx.bCW() == null || NewSubPbActivity.this.hPw.ax(NewSubPbActivity.this.iUx.bCW().replyPrivateFlag, aj.cZW)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.hgO.cUe());
            if (NewSubPbActivity.this.hPF.aPf()) {
                NewSubPbActivity.this.hPF.a(NewSubPbActivity.this.iJz);
            }
            NewSubPbActivity.this.mP(true);
            return true;
        }
    };
    private NewWriteModel.d hgV = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.hPF != null && NewSubPbActivity.this.hPF.aOr() != null) {
                NewSubPbActivity.this.hPF.aOr().hide();
                if (NewSubPbActivity.this.iUx.crT()) {
                    TiebaStatic.log(new an("c10367").cy("post_id", NewSubPbActivity.this.iUx.aOM()));
                }
            }
            if (z) {
                NewSubPbActivity.this.hgO.KK(null);
                NewSubPbActivity.this.hgO.aU(null);
                NewSubPbActivity.this.hgO.tG(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.hgO.aU(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.hgO.KK(postWriteCallBackData.getErrorString());
                if (!v.isEmpty(NewSubPbActivity.this.hgO.cUa())) {
                    NewSubPbActivity.this.iJz = postWriteCallBackData;
                    if (NewSubPbActivity.this.hPF.aPf()) {
                        NewSubPbActivity.this.hPF.a(NewSubPbActivity.this.iJz);
                    }
                    NewSubPbActivity.this.mP(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.hPw != null) {
                NewSubPbActivity.this.hPw.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.iUz.crw();
        }
    };
    private CustomMessageListener iIu = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iUI) {
                NewSubPbActivity.this.iUz.bqp();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.iHV.showSuccessToast(NewSubPbActivity.this.iHU.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.iHU.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.vq(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.cmZ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.iHU.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.iHV.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener iIv = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iUI) {
                NewSubPbActivity.this.iUz.bqp();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.iHV.showSuccessToast(NewSubPbActivity.this.iHU.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.iHU.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.iHV.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener iIw = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.iUI) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.iUz.bqp();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.kuE;
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
                    NewSubPbActivity.this.iUz.a(sparseArray, z);
                }
            }
        }
    };
    boolean iIG = false;
    private final b.a iII = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.iHY != null && !TextUtils.isEmpty(NewSubPbActivity.this.iHZ)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.iIa == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.iHZ));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.iHZ;
                        aVar.pkgId = NewSubPbActivity.this.iIa.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.iIa.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.gQz == null) {
                            NewSubPbActivity.this.gQz = new ar(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.gQz.j(NewSubPbActivity.this.iHZ, NewSubPbActivity.this.iHY.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.iHY = null;
                NewSubPbActivity.this.iHZ = null;
            }
        }
    };
    private CustomMessageListener htw = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener gpy = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    m mVar = (m) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.iUx.crM() != null && NewSubPbActivity.this.iUx.crM().cld() != null && NewSubPbActivity.this.iUx.crM().cld().aCm() != null && currentAccount.equals(NewSubPbActivity.this.iUx.crM().cld().aCm().getUserId()) && NewSubPbActivity.this.iUx.crM().cld().aCm().getPendantData() != null) {
                        NewSubPbActivity.this.iUx.crM().cld().aCm().getPendantData().sB(mVar.aAE());
                        NewSubPbActivity.this.iUx.crM().cld().aCm().getPendantData().bI(mVar.aNW());
                        NewSubPbActivity.this.iUz.a(NewSubPbActivity.this.iUx.crM(), NewSubPbActivity.this.iUx.crM().cld(), NewSubPbActivity.this.iUx.crM().bXs(), NewSubPbActivity.this.iUx.crM().ayJ(), NewSubPbActivity.this.iUx.ckE(), NewSubPbActivity.this.iUx.crZ() != null);
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
        this.iHU = getPageContext();
        this.iUH = true;
        this.hgO = new com.baidu.tieba.write.c();
        this.hgO.Ea(R.color.cp_cont_h_alpha85);
        this.hgO.DZ(R.color.cp_cont_a);
        initListeners();
        crl();
        initData(bundle);
        initUI();
        ((SubPbView) this.iUz.getRootView()).show();
        oj(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.iUz.qK(this.mIsFromSchema);
        this.iHV = new com.baidu.tbadk.core.view.d();
        this.iHV.toastTime = 1000L;
        registerListener(this.iIw);
        registerListener(this.iIu);
        registerListener(this.iIv);
        this.iUI = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.iUI;
        userMuteAddAndDelCustomMessage.setTag(this.iUI);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.iUI;
        userMuteCheckCustomMessage.setTag(this.iUI);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.hPw = new aj(getPageContext());
        this.hPw.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tbadk.core.util.aj.a
            public void l(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.hPF.aPm();
                }
            }
        });
        this.iHy = new com.baidu.tieba.pb.pb.report.a(this);
        this.iHy.t(getUniqueId());
        this.iEi = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.iUz = new com.baidu.tieba.pb.pb.sub.a(this, this.akt);
        this.iUz.a(this.iUx);
        setContentView(this.iUz.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.iUz.setOnScrollListener(this.iUB);
        this.iUz.b(this);
        this.iUz.setOnImageClickListener(this.iUC);
        this.iUz.setOnLongClickListener(this.mOnLongClickListener);
        this.iUz.f(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.iUx != null) {
                    NewSubPbActivity.this.iUx.loadData();
                }
            }
        });
        this.iUz.a(this.iUF);
        this.iUz.b(this.iUG);
        if (this.iUx != null && this.iUx.crn() && !this.iUx.crY()) {
            this.iUz.crB().setVisibility(8);
        } else {
            this.iUz.crB().setVisibility(0);
        }
        if (this.iUx != null && !this.iUx.crn()) {
            this.iUz.setIsFromPb(false);
        }
    }

    private boolean av(Bundle bundle) {
        if (bundle != null) {
            this.dwV = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.dwV = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.dwV;
    }

    public void initData(Bundle bundle) {
        this.iUx = new SubPbModel(getPageContext());
        this.iUx.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void p(PostData postData) {
                NewSubPbActivity.this.iUz.r(postData);
                NewSubPbActivity.this.iUz.b((BdListView.e) null);
            }
        });
        this.iUy = new ForumManageModel(getPageContext());
        this.iUy.setLoadDataCallBack(this.iUE);
        this.goj = new VoiceManager();
        this.goj.onCreate(getPageContext());
        this.iHz = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.iHz != null) {
            this.iHz.a(this.iIC);
        }
        if (bundle != null) {
            this.iUx.initWithBundle(bundle);
        } else {
            this.iUx.initWithIntent(getIntent());
        }
        this.iUx.a(this.iUD);
        if (this.iUx.crn()) {
            this.iUx.loadData();
        } else {
            this.iUx.crR();
        }
    }

    public void crl() {
        this.iUD = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, l lVar) {
                if (NewSubPbActivity.this.iUz != null) {
                    NewSubPbActivity.this.iUz.crw();
                    if (!z) {
                        NewSubPbActivity.this.aX(i, str);
                        return;
                    }
                    NewSubPbActivity.this.iUz.hideNoDataView();
                    if (lVar != null) {
                        if (lVar.cld() != null || NewSubPbActivity.this.iUx != null) {
                            lVar.cld().a(NewSubPbActivity.this.iUx.crX());
                        }
                        if (NewSubPbActivity.this.iUz != null) {
                            NewSubPbActivity.this.oj(lVar.aAe() != null && lVar.aAe().isBjh());
                            if (NewSubPbActivity.this.hPF != null && NewSubPbActivity.this.hPF.aOr() != null) {
                                NewSubPbActivity.this.hPF.aOr().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.iUz.a(lVar, NewSubPbActivity.this.iUx.ckE(), NewSubPbActivity.this.iUx.crZ() != null);
                            if (NewSubPbActivity.this.iUH) {
                                NewSubPbActivity.this.crm();
                                NewSubPbActivity.this.iUH = false;
                            }
                        }
                        if (NewSubPbActivity.this.hPF != null) {
                            NewSubPbActivity.this.hPF.a(lVar.bCW());
                            NewSubPbActivity.this.hPF.setThreadData(lVar.aAe());
                        }
                        if (NewSubPbActivity.this.iUK == null) {
                            NewSubPbActivity.this.iUK = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.iUK.setData(lVar);
                        NewSubPbActivity.this.iUK.setType(0);
                        NewSubPbActivity.this.hPw.a(NewSubPbActivity.this.iUx.csc());
                    }
                }
            }
        };
        this.iIC = new a.InterfaceC0374a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0374a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.iHz != null) {
                        NewSubPbActivity.this.iHz.fm(z2);
                    }
                    MarkData ayM = NewSubPbActivity.this.iHz.ayM();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(ayM);
                        if (NewSubPbActivity.this.iHz != null) {
                            if (ayM != null) {
                                NewSubPbActivity.this.iUx.qM(true);
                                NewSubPbActivity.this.iUx.Gt(NewSubPbActivity.this.iUx.aOM());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.iUz != null) {
                                NewSubPbActivity.this.iUz.qL(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.iUx.qM(false);
                        NewSubPbActivity.this.iUx.Gt(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.iUz != null) {
                            NewSubPbActivity.this.iUz.qL(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.iUF = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.iUx.crM() != null && NewSubPbActivity.this.iUx.crM().aAe() != null && NewSubPbActivity.this.iUx.crM().aAe().aCm() != null) {
                    str = String.valueOf(NewSubPbActivity.this.iUx.crM().aAe().aCm().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.iUx.crM().aPk().getId(), NewSubPbActivity.this.iUx.crM().aPk().getName(), NewSubPbActivity.this.iUx.crM().aAe().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.iUG = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.iUy.cLM() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.iUx != null && NewSubPbActivity.this.iUx.crM() != null && NewSubPbActivity.this.iUx.crM().aPk() != null && NewSubPbActivity.this.iUx.crM().aAe() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.iUy.Jg(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.iUy.a(NewSubPbActivity.this.iUx.crM().aPk().getId(), NewSubPbActivity.this.iUx.crM().aPk().getName(), NewSubPbActivity.this.iUx.crM().aAe().getId(), valueOf, i2, i, z, NewSubPbActivity.this.iUx.crM().aAe().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.iUE = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.iUz.a(NewSubPbActivity.this.iUy.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.iUy.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.iVF != 1002 || bVar.eLE) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.iUz.a(1, dVar.mSuccess, dVar.kjg, true);
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
        registerListener(this.gpy);
        this.akt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v65, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray sparseArray;
                if (view != null || NewSubPbActivity.this.iUz != null) {
                    if (view == NewSubPbActivity.this.iUz.crH()) {
                        NewSubPbActivity.this.iUz.cpW();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ba.aGE().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.iUz.bIm()) {
                        if (view != NewSubPbActivity.this.iUz.crA()) {
                            if (view != NewSubPbActivity.this.iUz.crz()) {
                                if (view == NewSubPbActivity.this.iUz.cru()) {
                                    NewSubPbActivity.this.iUz.cpW();
                                    if (NewSubPbActivity.this.iUx.loadData()) {
                                        NewSubPbActivity.this.iUz.crs();
                                    }
                                } else if (view == NewSubPbActivity.this.iUz.crB() || view == NewSubPbActivity.this.iUz.crC() || view == NewSubPbActivity.this.iUz.crE()) {
                                    if (NewSubPbActivity.this.iUJ) {
                                        NewSubPbActivity.this.iUJ = false;
                                        return;
                                    }
                                    if ((NewSubPbActivity.this.iUx.crM() == null || NewSubPbActivity.this.iUx.crM().aAe() == null) ? false : au.a(NewSubPbActivity.this.iUx.crM().aAe().getBaijiahaoData())) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.iUx.cnw(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.iUx.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.iUx.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.iUx.crM() != null && NewSubPbActivity.this.iUx.crM().aAe() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.iUx.crM().aAe().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.iUx.cnw(), NewSubPbActivity.this.iUx.aOM(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.iUx.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.iUx.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.iUz.crF() == null || view != NewSubPbActivity.this.iUz.crF().cou()) {
                                    if (NewSubPbActivity.this.iUz.crF() == null || view != NewSubPbActivity.this.iUz.crF().cox()) {
                                        if (NewSubPbActivity.this.iUz.crF() == null || view != NewSubPbActivity.this.iUz.crF().cov()) {
                                            if (NewSubPbActivity.this.iUz.crF() == null || view != NewSubPbActivity.this.iUz.crF().cow()) {
                                                if (NewSubPbActivity.this.iUz.crF() == null || view != NewSubPbActivity.this.iUz.crF().coy()) {
                                                    if (view == NewSubPbActivity.this.iUz.cry() || view == NewSubPbActivity.this.iUz.crE()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.hPF.aPp()) {
                                                                NewSubPbActivity.this.hPF.aPq();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.hPF.vr(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof k)) {
                                                        if (NewSubPbActivity.this.iUA == null || view != NewSubPbActivity.this.iUA.cow()) {
                                                            if (NewSubPbActivity.this.iUA == null || view != NewSubPbActivity.this.iUA.cou()) {
                                                                if (NewSubPbActivity.this.iUA == null || view != NewSubPbActivity.this.iUA.cox()) {
                                                                    if (NewSubPbActivity.this.iUA == null || view != NewSubPbActivity.this.iUA.coy()) {
                                                                        if (NewSubPbActivity.this.iUA == null || view != NewSubPbActivity.this.iUA.coA()) {
                                                                            if (NewSubPbActivity.this.iUA == null || view != NewSubPbActivity.this.iUA.coB()) {
                                                                                if (NewSubPbActivity.this.iUA != null && view == NewSubPbActivity.this.iUA.cov()) {
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
                                                                                            NewSubPbActivity.this.iUz.cA(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.iUz.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.aFB().getString("tail_link", "");
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
                                                                                        if (postData.getType() != PostData.kgs && !TextUtils.isEmpty(postData.getBimg_url()) && i.azM().isShowImages()) {
                                                                                            NewSubPbActivity.this.Gq(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.iHY != null && !TextUtils.isEmpty(NewSubPbActivity.this.iHZ)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.gQz == null) {
                                                                                        NewSubPbActivity.this.gQz = new ar(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.gQz.j(NewSubPbActivity.this.iHZ, NewSubPbActivity.this.iHY.getImageByte());
                                                                                    NewSubPbActivity.this.iHY = null;
                                                                                    NewSubPbActivity.this.iHZ = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.iHY != null && !TextUtils.isEmpty(NewSubPbActivity.this.iHZ)) {
                                                                            if (NewSubPbActivity.this.iIa == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.iHZ));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.iHZ;
                                                                                aVar.pkgId = NewSubPbActivity.this.iIa.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.iIa.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.iHY = null;
                                                                            NewSubPbActivity.this.iHZ = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.hhx != null) {
                                                                        NewSubPbActivity.this.hhx.fv(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.hhx = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.iUz.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                        NewSubPbActivity.this.iUM = (k) view.getTag();
                                                        if (bc.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.iUJ) {
                                                                NewSubPbActivity.this.iUJ = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.hPw == null || NewSubPbActivity.this.iUx == null || NewSubPbActivity.this.iUx.bCW() == null || NewSubPbActivity.this.hPw.ks(NewSubPbActivity.this.iUx.bCW().replyPrivateFlag)) && (sparseArray = (SparseArray) view.getTag(R.id.tag_from)) != null) {
                                                                if (sparseArray.get(R.id.tag_clip_board) instanceof PostData) {
                                                                    PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                    if (postData2 != null && postData2.aCm() != null) {
                                                                        MetaData aCm = postData2.aCm();
                                                                        NewSubPbActivity.this.hPF.setReplyId(aCm.getUserId());
                                                                        if (!(sparseArray.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue() : true)) {
                                                                            NewSubPbActivity.this.hPF.vs("");
                                                                        } else {
                                                                            NewSubPbActivity.this.hPF.vs(aCm.getName_show());
                                                                        }
                                                                    }
                                                                    NewSubPbActivity.this.iUz.crq();
                                                                }
                                                                if (NewSubPbActivity.this.iUL) {
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
                                            NewSubPbActivity.this.iUz.cpW();
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
                                            NewSubPbActivity.this.iUz.cpW();
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
                                    NewSubPbActivity.this.iUz.cpW();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.iUz.a(((Integer) sparseArray7.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray7.get(R.id.tag_del_post_id), ((Integer) sparseArray7.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new an("c11739").X("obj_locate", 2));
                                    NewSubPbActivity.this.iUz.cpW();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.iUx.crM() != null) {
                                        NewSubPbActivity.this.k(NewSubPbActivity.this.iUx.crM().cld());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.iUz.crp();
                                NewSubPbActivity.this.iUz.crq();
                                if (NewSubPbActivity.this.hPF != null) {
                                    NewSubPbActivity.this.hPF.aPs();
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.iUz.crp();
                            NewSubPbActivity.this.iUz.crq();
                            if (NewSubPbActivity.this.hPF != null) {
                                NewSubPbActivity.this.hPF.aPr();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.cmx();
                        if (NewSubPbActivity.this.iUx != null && NewSubPbActivity.this.iUx.crM() != null && NewSubPbActivity.this.iUx.crM().aAe() != null && NewSubPbActivity.this.iUx.crM().aAe().aCm() != null) {
                            TiebaStatic.log(new an("c13402").cy("tid", NewSubPbActivity.this.iUx.cnw()).s("fid", NewSubPbActivity.this.iUx.crM().aAe().getFid()).X("obj_locate", 5).cy("uid", NewSubPbActivity.this.iUx.crM().aAe().aCm().getUserId()));
                        }
                    }
                }
            }
        };
        this.iUB = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.iUz.cpW();
                    if (NewSubPbActivity.this.iDE != 2 && NewSubPbActivity.this.iDE != 1) {
                        NewSubPbActivity.this.iUz.crJ();
                    }
                }
                NewSubPbActivity.this.hPF.aPq();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.iUz.crG();
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
                if (NewSubPbActivity.this.iUz != null && NewSubPbActivity.this.iUz.crx()) {
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
                        NewSubPbActivity.this.iHY = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.iHZ = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.iHY == null || TextUtils.isEmpty(NewSubPbActivity.this.iHZ)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.iIa = null;
                        } else {
                            NewSubPbActivity.this.iIa = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.iHY = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.iHZ = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.iIa = null;
                        } else {
                            NewSubPbActivity.this.iIa = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.iHY = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.iHZ = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.iIa = null;
                        } else {
                            NewSubPbActivity.this.iIa = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.iUz.a(NewSubPbActivity.this.iII, NewSubPbActivity.this.iHY.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.hhx = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.hhx == null || NewSubPbActivity.this.iHz == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.iHz != null) {
                            NewSubPbActivity.this.iHz.fm(NewSubPbActivity.this.iUx.crS());
                        }
                        boolean z = NewSubPbActivity.this.iHz.ayJ() && NewSubPbActivity.this.hhx.getId() != null && NewSubPbActivity.this.hhx.getId().equals(NewSubPbActivity.this.iUx.crU());
                        if (NewSubPbActivity.this.iUA == null) {
                            NewSubPbActivity.this.iUA = new w(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.akt);
                            NewSubPbActivity.this.iUz.cE(NewSubPbActivity.this.iUA.getView());
                            NewSubPbActivity.this.iUA.pY(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.iUA.showDialog();
                        boolean z2 = NewSubPbActivity.this.pL(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z3 = (NewSubPbActivity.this.iUx.crM() == null || NewSubPbActivity.this.iUx.crM().aAe() == null || !NewSubPbActivity.this.iUx.crM().aAe().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z) {
                            NewSubPbActivity.this.iUA.cou().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.iUA.cou().setText(R.string.mark);
                        }
                        if (booleanValue || z3) {
                            NewSubPbActivity.this.iUA.cou().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.iUA.cou().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.cv(view)) {
                            if (NewSubPbActivity.this.iHY != null && !NewSubPbActivity.this.iHY.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        NewSubPbActivity.this.iUA.a(sparseArray2, NewSubPbActivity.this.ckE(), z2);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.iUC = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                        l crM = NewSubPbActivity.this.iUx.crM();
                        TbRichText bj = NewSubPbActivity.this.bj(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bj != null && bj.aTQ() != null) {
                            tbRichTextData = bj.aTQ().get(NewSubPbActivity.this.iIF);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.aTW().aUh()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (crM == null) {
                                    str3 = null;
                                    z5 = false;
                                } else {
                                    if (crM.aPk() != null) {
                                        str4 = crM.aPk().getName();
                                        str5 = crM.aPk().getId();
                                    }
                                    if (crM.aAe() != null) {
                                        str6 = crM.aAe().getId();
                                    }
                                    str3 = str6;
                                    z5 = true;
                                }
                                if (NewSubPbActivity.this.iUx.crZ() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.iUx.crZ();
                                    z6 = NewSubPbActivity.this.iUx.csb();
                                    arrayList2 = NewSubPbActivity.this.iUx.csa();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z6 = z5;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.getItem(arrayList2, 0));
                                ImageViewerConfig createConfig = new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z6, arrayList2.get(0), true, concurrentHashMap2, true, false, false);
                                createConfig.setPostId(String.valueOf(bj.getPostId()));
                                createConfig.setThreadData(NewSubPbActivity.this.aAe());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                                return;
                            }
                            NewSubPbActivity.this.iIG = false;
                            String str7 = "";
                            TbRichText cLa = crM.cld().cLa();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(cLa, bj, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (crM == null) {
                                str2 = null;
                                z3 = false;
                            } else {
                                if (crM.aPk() != null) {
                                    str8 = crM.aPk().getName();
                                    str9 = crM.aPk().getId();
                                }
                                if (crM.aAe() != null) {
                                    str10 = crM.aAe().getId();
                                }
                                str2 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.iUx.crZ() != null) {
                                concurrentHashMap = NewSubPbActivity.this.iUx.crZ();
                                z4 = NewSubPbActivity.this.iUx.csb();
                                arrayList = NewSubPbActivity.this.iUx.csa();
                                i2 = a2 + NewSubPbActivity.this.iUx.getOffset();
                            } else {
                                concurrentHashMap = concurrentHashMap3;
                                i2 = a2;
                                z4 = z3;
                                arrayList = arrayList2;
                            }
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(v.getItem(arrayList, i2));
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList4, 0, str8, str9, str2, z4, str7, true, concurrentHashMap, true, false, false);
                            createConfig2.setThreadData(NewSubPbActivity.this.aAe());
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
    public bj aAe() {
        if (this.iUx == null || this.iUx.crM() == null) {
            return null;
        }
        return this.iUx.crM().aAe();
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
        TbRichTextImageInfo aTW;
        if (tbRichText == tbRichText2) {
            this.iIG = true;
        }
        if (tbRichText != null && tbRichText.aTQ() != null) {
            int size = tbRichText.aTQ().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.aTQ().get(i6) != null && tbRichText.aTQ().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.aTQ().get(i6).aTW().getWidth() * equipmentDensity;
                    int height = tbRichText.aTQ().get(i6).aTW().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.aTQ().get(i6).aTW().aUh()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.aTQ().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (aTW = tbRichTextData.aTW()) != null) {
                            String aUj = aTW.aUj();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = aUj;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.iIG) {
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
        if (this.iUA != null) {
            this.iUA.pY(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo aTW = tbRichTextData.aTW();
        if (aTW != null) {
            if (!StringUtils.isNull(aTW.aUg())) {
                return aTW.aUg();
            }
            if (aTW.getHeight() * aTW.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (aTW.getHeight() * aTW.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (aTW.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * aTW.getHeight())));
            } else {
                float width = aTW.getWidth() / aTW.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(aTW.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bj(String str, int i) {
        if (this.iUx == null || this.iUx.crM() == null || str == null || i < 0) {
            return null;
        }
        l crM = this.iUx.crM();
        TbRichText a2 = a(crM.cld(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(crM.cld(), str, i);
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
        TbRichText cLa = postData.cLa();
        if (cLa != null) {
            ArrayList<TbRichTextData> aTQ = cLa.aTQ();
            int size = aTQ.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (aTQ.get(i3) != null && aTQ.get(i3).getType() == 8) {
                    i2++;
                    if (aTQ.get(i3).aTW().aUj().equals(str)) {
                        int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = aTQ.get(i3).aTW().getWidth() * equipmentDensity;
                        int height = aTQ.get(i3).aTW().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.iIF = i3;
                        return cLa;
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
    public void cmx() {
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false) {
            if (this.hPw == null || this.iUx == null || this.iUx.bCW() == null || this.hPw.ks(this.iUx.bCW().replyPrivateFlag)) {
                if (this.hPF.aPf()) {
                    this.hPF.a((PostWriteCallBackData) null);
                    return;
                }
                this.iUz.crp();
                this.iUz.crq();
                if (this.hPF != null) {
                    this.hPF.aPt();
                    return;
                }
                return;
            }
            return;
        }
        if (this.grK == null) {
            this.grK = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.grK.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lw(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void t(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lx(boolean z) {
                    if (z) {
                        if (NewSubPbActivity.this.hPw == null || NewSubPbActivity.this.iUx == null || NewSubPbActivity.this.iUx.bCW() == null || NewSubPbActivity.this.hPw.ks(NewSubPbActivity.this.iUx.bCW().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.hPF.aPf()) {
                                NewSubPbActivity.this.hPF.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.iUz.crp();
                            NewSubPbActivity.this.iUz.crq();
                            if (NewSubPbActivity.this.hPF != null) {
                                NewSubPbActivity.this.hPF.aPt();
                            }
                        }
                    }
                }
            });
        }
        if (this.iUx != null && this.iUx.crM() != null && this.iUx.crM().aPk() != null) {
            this.grK.C(this.iUx.crM().aPk().getId(), com.baidu.adp.lib.f.b.toLong(this.iUx.cnw(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pL(boolean z) {
        if (this.iUx == null) {
            return false;
        }
        return ((ckE() != 0) || this.iUx.crM() == null || this.iUx.crM().aAe() == null || this.iUx.crM().aAe().aCm() == null || this.iUx.crM().aAe().aEg() || TextUtils.equals(this.iUx.crM().aAe().aCm().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(int i, String str) {
        if (this.iUx.crN()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.isNetOk()) {
            if (i == 4) {
                this.iUz.zM(str + "(4)");
            } else {
                this.iUz.wo(R.string.no_data_text);
            }
        } else {
            this.iUz.wo(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(boolean z) {
        this.hPF = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dV(getActivity());
        if (this.hPF != null) {
            this.hPF.a(getPageContext());
            this.hPF.b(this.iUx);
            this.hPF.b(this.hgV);
            this.hPF.a(this.dys);
            this.hPF.a(this.dyt);
            this.hPF.aOr().gB(true);
            this.hPF.g(getPageContext());
        }
        if (this.iUz != null) {
            this.iUz.i(this.hPF);
        }
        if (this.hPF != null && this.iUx != null) {
            this.hPF.a(this.iUx.bCW());
            this.hPF.aPq();
        }
        if (this.hPF != null) {
            this.hPF.aPu().setDefaultHint(cpk());
            this.hPF.aPu().setHint(cpk());
            this.hgP = this.hPF.aPu().getInputView();
            this.hgP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.hgO != null) {
                        if (!NewSubPbActivity.this.hgO.cUd()) {
                            NewSubPbActivity.this.mP(false);
                        }
                        NewSubPbActivity.this.hgO.tH(false);
                    }
                }
            });
        }
    }

    public void crm() {
        if (!TbadkCoreApplication.isLogin()) {
            this.hPF.aPq();
        } else if (!StringUtils.isNull(this.iUx.crV())) {
            if (this.iUz.crt() && com.baidu.adp.lib.util.l.isNetOk()) {
                this.iUz.bBa();
            } else {
                this.iUz.crw();
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
                    this.iUz.cA(view);
                }
            } else if (booleanValue2) {
                this.iUz.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.iUz.crD(), getPageContext().getPageActivity());
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.iUI);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.iUI);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).aEB();
        }
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.iUz.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.iUI;
        userMuteCheckCustomMessage.setTag(this.iUI);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.iUz.a(0, bVar.mSuccess, bVar.kjg, z);
            if (bVar.mSuccess) {
                if (bVar.fXV == 1) {
                    if (this.iUz.getListView() instanceof BdTypeListView) {
                        List<com.baidu.adp.widget.ListView.m> data = ((BdTypeListView) this.iUz.getListView()).getData();
                        if (!v.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.iUz.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.fXV == 2) {
                    this.iUx.Gs(bVar.mPostId);
                    this.iUz.a(this.iUx.crM(), this.iUx.ckE(), this.iUx.crZ() != null);
                    if (this.iUx.crW()) {
                        this.iUx.qN(false);
                        this.iUz.crr();
                        this.iUx.loadData();
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
        if (this.iUx != null && this.iUx.crM() != null && this.iUx.crM().aAe() != null && this.iUx.crM().aAe().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.iUx.cnw(), str);
            bj aAe = this.iUx.crM().aAe();
            if (aAe.aBb()) {
                format = format + "&channelid=33833";
            } else if (aAe.aEd()) {
                format = format + "&channelid=33842";
            } else if (aAe.aBc()) {
                format = format + "&channelid=33840";
            }
            FQ(format);
            return;
        }
        this.iHy.Gp(str);
    }

    private void FQ(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void k(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.iUx.crS() && postData.getId() != null && postData.getId().equals(this.iUx.crU())) {
                z = true;
            }
            MarkData l = this.iUx.l(postData);
            if (l != null) {
                this.iUz.cpW();
                if (this.iHz != null) {
                    this.iHz.a(l);
                    if (!z) {
                        this.iHz.ayL();
                    } else {
                        this.iHz.ayK();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.iUx != null) {
            this.iUx.au(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.hPF != null) {
            this.hPF.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.hPF.aOr().aMO();
        this.hPF.aPq();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.hPF.b(writeData);
                this.hPF.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l mp = this.hPF.aOr().mp(6);
                if (mp != null && mp.dwz != null) {
                    mp.dwz.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.hPF.aPm();
                }
                this.iUz.crJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.goj != null) {
            this.goj.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.ees = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.axx().axC();
        if (this.goj != null) {
            this.goj.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.htw);
        this.iUz.bKn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.ees = false;
        super.onResume();
        cnc();
        if (this.goj != null) {
            this.goj.onResume(getPageContext());
        }
        registerListener(this.htw);
        this.iUz.bKo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.goj != null) {
            this.goj.onStop(getPageContext());
        }
        this.hPF.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.iUK));
        this.iUx.cancelLoadData();
        this.iUx.destory();
        this.iUy.cancelLoadData();
        if (this.goj != null) {
            this.goj.onDestory(getPageContext());
        }
        this.iUz.cpW();
        this.iUz.aiG();
        MessageManager.getInstance().unRegisterListener(this.iIu);
        MessageManager.getInstance().unRegisterListener(this.iIv);
        MessageManager.getInstance().unRegisterListener(this.iIw);
        MessageManager.getInstance().unRegisterListener(this.iUI);
        this.iHU = null;
        this.iHV = null;
        if (this.hPw != null) {
            this.hPw.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iUz.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.goj;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View cry = this.iUz.cry();
        if (cry == null || (findViewWithTag = cry.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Gi(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = ba.getParamPair(ba.getParamStr(str))) != null) {
            this.iUJ = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Gi(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(iUw);
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
                    lVar.dvC = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
                }
            } else {
                ba.aGE().b(getPageContext(), new String[]{str});
            }
            this.iUJ = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aC(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iUJ = true;
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
        if (this.iUz != null) {
            return this.iUz.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int aUx() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> aUz() {
        if (this.dPa == null) {
            this.dPa = TbRichTextView.z(getPageContext().getPageActivity(), 8);
        }
        return this.dPa;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> aUA() {
        if (this.dMn == null) {
            this.dMn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bGX */
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
        return this.dMn;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> aUy() {
        if (this.dMm == null) {
            this.dMm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aUK */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.azM().isShowImages();
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
                        if (i.azM().isShowImages()) {
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
        return this.dMm;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> aUB() {
        if (this.dPb == null) {
            this.dPb = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnj */
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
        return this.dPb;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> aUC() {
        if (this.dPc == null) {
            this.dPc = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnl */
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
        return this.dPc;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> aUD() {
        this.dPd = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cnk */
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
        return this.dPd;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a clo() {
        return this.iEi;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean clp() {
        return (this.iUx == null || this.iUx.crM() == null || this.iUx.crM().aAe() == null || this.iUx.crM().aAe().aDE()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String clq() {
        if (this.iUx == null || this.iUx.crM() == null || this.iUx.crM().aAe() == null) {
            return null;
        }
        return this.iUx.crM().aAe().aCr();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int clr() {
        if (this.iUx == null) {
            return 0;
        }
        return this.iUx.ckE();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean FK(String str) {
        if (StringUtils.isNull(str) || this.iUx == null || this.iUx.crM() == null || this.iUx.crM().aAe() == null || this.iUx.crM().aAe().aCm() == null) {
            return false;
        }
        return str.equals(this.iUx.crM().aAe().aCm().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.iUz.crt() && com.baidu.adp.lib.util.l.isNetOk()) {
            this.iUx.loadData();
        } else {
            this.iUz.crw();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.iUI);
        userMuteAddAndDelCustomMessage.setTag(this.iUI);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gq(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aFB().getString("bubble_link", "");
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
                return com.baidu.tbadk.m.e.aQV().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.iUx != null) {
            if (this.iUx.crM() != null && this.iUx.crM().aPk() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.iUx.crM().aPk().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.iUx.cnw(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.ees;
    }

    public boolean crn() {
        if (this.iUx != null) {
            return this.iUx.crn();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.iUz.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iHU.getPageActivity());
        if (aq.isEmpty(str)) {
            aVar.sS(this.iHU.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.sS(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.iUz.showLoadingDialog();
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
        aVar.b(this.iHU).aEA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vq(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iHU.getPageActivity());
        aVar.sS(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.iHU).aEA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.sS(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.iHU).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.iHU.getPageActivity(), 2, true, 4);
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
        aVar.b(this.iHU).aEA();
    }

    public SubPbModel cro() {
        return this.iUx;
    }

    public int ckE() {
        if (this.iUx != null) {
            return this.iUx.ckE();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.dwV && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.dwV && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void mP(boolean z) {
        if (this.hgP != null && this.hgP.getText() != null) {
            int selectionEnd = this.hgP.getSelectionEnd();
            SpannableStringBuilder a2 = this.hgO.a(this.hgP.getText());
            if (a2 != null) {
                this.hgO.tH(true);
                this.hgP.setText(a2);
                if (z && this.hgO.cUb() >= 0) {
                    this.hgP.requestFocus();
                    this.hgP.setSelection(this.hgO.cUb());
                } else {
                    this.hgP.setSelection(selectionEnd);
                }
                this.hgO.tG(this.hgO.cUb() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hPF != null && this.hPF.aOr() != null && this.hPF.aOr().aOt()) {
            this.hPF.aOr().aMO();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.d.a(pVar, getUniqueId(), this);
    }

    public String cpk() {
        if (!aq.isEmpty(this.iPr)) {
            return this.iPr;
        }
        this.iPr = getResources().getString(com.baidu.tieba.pb.pb.main.am.coZ());
        return this.iPr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.iUL = z;
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
        if (this.iUz != null && this.iUz.getListView() != null && this.iUM != null && this.iUM.mPosition != -1) {
            final int headerViewsCount = this.iUM.mPosition + this.iUz.getListView().getHeaderViewsCount();
            if (this.iUM.getView() != null) {
                final int height = this.iUM.getView().getHeight() - ((rect.height() - this.iUz.getNavigationBarHeight()) - this.iUz.crI());
                if (height > 0) {
                    this.iUz.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.iUz != null && NewSubPbActivity.this.iUz.getListView() != null) {
                                NewSubPbActivity.this.iUz.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.iUz.getNavigationBarHeight() - height);
                            }
                        }
                    });
                } else {
                    this.iUz.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.iUz != null && NewSubPbActivity.this.iUz.getListView() != null) {
                                NewSubPbActivity.this.iUz.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.iUz.getNavigationBarHeight());
                            }
                        }
                    });
                }
            }
        }
    }

    private void cnc() {
        if (this.iUx != null && !aq.isEmpty(this.iUx.cnw())) {
            com.baidu.tbadk.BdToken.c.axx().o(com.baidu.tbadk.BdToken.b.cGK, com.baidu.adp.lib.f.b.toLong(this.iUx.cnw(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.iUx == null || aq.isEmpty(this.iUx.cnw())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.iUx.cnw(), 0L);
    }
}
