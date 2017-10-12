package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView;
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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.editortools.pb.f;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.b;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.d {
    private static final String ePc = com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String eQB = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aSd;
    private com.baidu.adp.lib.e.b<TextView> aSe;
    private com.baidu.adp.lib.e.b<View> aSf;
    private com.baidu.adp.lib.e.b<LinearLayout> aSg;
    private com.baidu.adp.lib.e.b<RelativeLayout> aSh;
    private com.baidu.adp.lib.e.b<GifView> aSi;
    private View.OnLongClickListener auG;
    private VoiceManager cqs;
    private com.baidu.tbadk.editortools.pb.e dKF;
    private View.OnClickListener eAg;
    private b.InterfaceC0047b eCT;
    private com.baidu.adp.base.e eCh;
    private com.baidu.tbadk.core.view.c eCi;
    private SubPbModel eQC;
    private ForumManageModel eQD;
    private c eQE;
    private AbsListView.OnScrollListener eQF;
    private TbRichTextView.g eQG;
    private TbRichTextView.f eQH;
    private SubPbModel.a eQI;
    private com.baidu.adp.base.d eQJ;
    private BdUniqueId eQO;
    private b eQQ;
    private com.baidu.tbadk.baseEditMark.a efV;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int eCQ = 0;
    private a.InterfaceC0042a eCL = null;
    private a eQK = null;
    private a eQL = null;
    private boolean eQM = false;
    private boolean eQN = false;
    private boolean eQP = false;
    private boolean eQR = false;
    private com.baidu.tbadk.editortools.pb.b aCJ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.b
        public void CW() {
            NewSubPbActivity.this.eQE.aTp();
        }
    };
    private NewWriteModel.d eQS = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.dKF != null && NewSubPbActivity.this.dKF.Cz() != null) {
                NewSubPbActivity.this.dKF.Cz().hide();
                if (NewSubPbActivity.this.eQC.aTL()) {
                    TiebaStatic.log(new ak("c10367").ad("post_id", NewSubPbActivity.this.eQC.CU()));
                }
            }
            NewSubPbActivity.this.eQE.aTq();
        }
    };
    private CustomMessageListener eCF = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eQO) {
                NewSubPbActivity.this.eQE.Sv();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eCi.c(NewSubPbActivity.this.eCh.getResources().getString(d.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.eCh.getResources().getString(d.l.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.fT(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.aOQ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (am.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.eCh.getResources().getString(d.l.mute_fail);
                    }
                    NewSubPbActivity.this.eCi.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eCG = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eQO) {
                NewSubPbActivity.this.eQE.Sv();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eCi.c(NewSubPbActivity.this.eCh.getResources().getString(d.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (am.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.eCh.getResources().getString(d.l.un_mute_fail);
                }
                NewSubPbActivity.this.eCi.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eCH = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eQO) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.eQE.Sv();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.gtN;
                if (aVar.error == 0 && dataRes != null) {
                    boolean z2 = com.baidu.adp.lib.g.b.g(dataRes.is_mute, 0) == 1;
                    sparseArray.put(d.h.tag_user_mute_visible, true);
                    sparseArray.put(d.h.tag_user_mute_msg, dataRes.mute_confirm);
                    z = z2;
                } else {
                    sparseArray.put(d.h.tag_user_mute_visible, false);
                    z = false;
                }
                int intValue = sparseArray.get(d.h.tag_from) instanceof Integer ? ((Integer) sparseArray.get(d.h.tag_from)).intValue() : 0;
                if (intValue == 0) {
                    NewSubPbActivity.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    NewSubPbActivity.this.eQE.a(sparseArray, z);
                }
            }
        }
    };
    boolean eCR = false;
    private CustomMessageListener doe = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a)) {
                b.a aVar = (b.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.b.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    public final TbRichTextView.e ePf = new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
        public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONIMAGE, new EmotionImageActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i, i2)));
        }
    };
    CustomMessageListener crn = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.eQC.aTE() != null && NewSubPbActivity.this.eQC.aTE().aNK() != null && NewSubPbActivity.this.eQC.aTE().aNK().getAuthor() != null && currentAccount.equals(NewSubPbActivity.this.eQC.aTE().aNK().getAuthor().getUserId()) && NewSubPbActivity.this.eQC.aTE().aNK().getAuthor().getPendantData() != null) {
                        NewSubPbActivity.this.eQC.aTE().aNK().getAuthor().getPendantData().cA(iVar.pS());
                        NewSubPbActivity.this.eQC.aTE().aNK().getAuthor().getPendantData().P(iVar.Ca());
                        NewSubPbActivity.this.eQE.a(NewSubPbActivity.this.eQC.aTE().aNK(), NewSubPbActivity.this.eQC.aTE().ayA(), NewSubPbActivity.this.eQC.aTE().nG(), NewSubPbActivity.this.eQC.aNm(), NewSubPbActivity.this.eQC.aTU() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void f(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        x(bundle);
        if (this.eQR) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.eCh = getPageContext();
        this.eQN = true;
        aoM();
        aTc();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.eQC.aTe()) {
            this.eQQ = new b(this, getListView(), this.eQE.ahj());
            this.eQQ.aSX();
            this.eQQ.a(new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
                private boolean eQV = false;

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void aSZ() {
                    NewSubPbActivity.this.eQE.jO(false);
                    this.eQV = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void aTa() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public boolean aTb() {
                    if (!this.eQV) {
                        return NewSubPbActivity.this.eQE.aTh() != null && NewSubPbActivity.this.eQE.aTh().getTop() == 0;
                    }
                    this.eQV = false;
                    return false;
                }
            });
            this.eQE.e(this.eQQ);
            this.eQE.jO(true);
        }
        this.eCi = new com.baidu.tbadk.core.view.c();
        this.eCi.akH = 1000L;
        registerListener(this.eCH);
        registerListener(this.eCF);
        registerListener(this.eCG);
        this.eQO = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eQO;
        userMuteAddAndDelCustomMessage.setTag(this.eQO);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eQO;
        userMuteCheckCustomMessage.setTag(this.eQO);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.eQE = new c(this, this.eAg);
        this.eQE.a(this.eQC);
        addContentView(this.eQE.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.eQE.setOnScrollListener(this.eQF);
        this.eQE.a(this);
        this.eQE.setOnLinkImageClickListener(this.eQG);
        this.eQE.setOnImageClickListener(this.eQH);
        this.eQE.iE(true);
        this.eQE.setOnLongClickListener(this.auG);
        this.eQE.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.eQC != null) {
                    NewSubPbActivity.this.eQC.EZ();
                }
            }
        });
        this.eQE.a(this.eQK);
        this.eQE.b(this.eQL);
        if (this.eQC != null && this.eQC.aTe() && !this.eQC.aTT()) {
            this.eQE.aTv().setVisibility(8);
        } else {
            this.eQE.aTv().setVisibility(0);
        }
        if (this.eQC != null && !this.eQC.aTe()) {
            this.eQE.setIsFromPb(false);
        }
    }

    private boolean x(Bundle bundle) {
        if (bundle != null) {
            this.eQR = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eQR = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eQR;
    }

    public void initData(Bundle bundle) {
        this.eQC = new SubPbModel(getPageContext());
        this.eQC.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void m(PostData postData) {
                NewSubPbActivity.this.eQE.o(postData);
                NewSubPbActivity.this.eQE.a((BdListView.e) null);
            }
        });
        this.eQD = new ForumManageModel(this);
        this.eQD.setLoadDataCallBack(this.eQJ);
        this.cqs = new VoiceManager();
        this.cqs.onCreate(getPageContext());
        this.efV = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.efV != null) {
            this.efV.a(this.eCL);
        }
        if (bundle != null) {
            this.eQC.initWithBundle(bundle);
        } else {
            this.eQC.initWithIntent(getIntent());
        }
        this.eQC.a(this.eQI);
        if (this.eQC.aTe()) {
            this.eQC.EZ();
        } else {
            this.eQC.aTJ();
        }
    }

    public void aTc() {
        this.eQI = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, m mVar) {
                if (NewSubPbActivity.this.eQE != null) {
                    NewSubPbActivity.this.eQE.aTq();
                }
                if (NewSubPbActivity.this.eQQ != null && NewSubPbActivity.this.eQQ.aSY()) {
                    NewSubPbActivity.this.eQQ.pI(d.e.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.P(i, str);
                    return;
                }
                NewSubPbActivity.this.eQE.hideNoDataView();
                if (mVar != null) {
                    if (mVar.aNK() != null || NewSubPbActivity.this.eQC != null) {
                        mVar.aNK().a(NewSubPbActivity.this.eQC.aTS());
                    }
                    if (NewSubPbActivity.this.eQE != null) {
                        NewSubPbActivity.this.eQE.a(mVar, NewSubPbActivity.this.eQC.aNm(), NewSubPbActivity.this.eQC.aTU() != null);
                        if (NewSubPbActivity.this.eQN) {
                            NewSubPbActivity.this.aTd();
                            NewSubPbActivity.this.eQN = false;
                        }
                    }
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setData(mVar);
                    if (NewSubPbActivity.this.dKF != null) {
                        NewSubPbActivity.this.dKF.a(mVar.aCl());
                    }
                    eVar.setType(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                }
            }
        };
        this.eCL = new a.InterfaceC0042a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0042a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.efV != null) {
                        NewSubPbActivity.this.efV.ad(z2);
                    }
                    MarkData nJ = NewSubPbActivity.this.efV.nJ();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(nJ);
                        if (NewSubPbActivity.this.efV != null) {
                            if (nJ != null) {
                                NewSubPbActivity.this.eQC.jT(true);
                                NewSubPbActivity.this.eQC.po(NewSubPbActivity.this.eQC.CU());
                                NewSubPbActivity.this.showToast(d.l.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.add_mark));
                            }
                            if (NewSubPbActivity.this.eQE != null) {
                                NewSubPbActivity.this.eQE.jQ(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.eQC.jT(false);
                        NewSubPbActivity.this.eQC.po(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.remove_mark));
                        if (NewSubPbActivity.this.eQE != null) {
                            NewSubPbActivity.this.eQE.jQ(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.update_mark_failed));
            }
        };
        this.eQK = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.eQC.aTE() != null && NewSubPbActivity.this.eQC.aTE().Nj() != null && NewSubPbActivity.this.eQC.aTE().Nj().getAuthor() != null) {
                    str = String.valueOf(NewSubPbActivity.this.eQC.aTE().Nj().getAuthor().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.eQC.aTE().aNR().getId(), NewSubPbActivity.this.eQC.aTE().aNR().getName(), NewSubPbActivity.this.eQC.aTE().Nj().getId(), str, str2, str3)));
            }
        };
        this.eQL = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.eQD.bsj() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.eQC != null && NewSubPbActivity.this.eQC.aTE() != null && NewSubPbActivity.this.eQC.aTE().aNR() != null && NewSubPbActivity.this.eQC.aTE().Nj() != null) {
                            NewSubPbActivity.this.eQD.a(NewSubPbActivity.this.eQC.aTE().aNR().getId(), NewSubPbActivity.this.eQC.aTE().aNR().getName(), NewSubPbActivity.this.eQC.aTE().Nj().getId(), valueOf, g2, g, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.l.login_to_use), true, 11017)));
            }
        };
        this.eQJ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = true;
                if (obj == null) {
                    NewSubPbActivity.this.eQE.a(NewSubPbActivity.this.eQD.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.eQD.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.cRU && bVar.eRJ > 0 && bVar.gjb != 1 && bVar.eRJ != 1002) {
                            com.baidu.tieba.c.a.a(NewSubPbActivity.this.getPageContext(), 3, 1);
                            z = false;
                        }
                        if (bVar.eRJ == 1002 && !bVar.cRU) {
                            z = false;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.eQE.a(1, dVar.Ak, dVar.gjd, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void aoM() {
        registerListener(this.crn);
        this.eAg = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.eQE != null) {
                    if (view == NewSubPbActivity.this.eQE.aTB()) {
                        NewSubPbActivity.this.eQE.aCA();
                        String str = view.getTag(d.h.tag_user_id) instanceof String ? (String) view.getTag(d.h.tag_user_id) : null;
                        String str2 = view.getTag(d.h.tag_user_name) instanceof String ? (String) view.getTag(d.h.tag_user_name) : null;
                        String str3 = view.getTag(d.h.tag_virtual_user_url) instanceof String ? (String) view.getTag(d.h.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                av.vH().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.eQE.aTs()) {
                        if (view != NewSubPbActivity.this.eQE.aTu()) {
                            if (view != NewSubPbActivity.this.eQE.aTt()) {
                                if (view == NewSubPbActivity.this.eQE.aTo()) {
                                    NewSubPbActivity.this.eQE.aCA();
                                    if (NewSubPbActivity.this.eQC.EZ()) {
                                        NewSubPbActivity.this.eQE.aTm();
                                    }
                                } else if (view == NewSubPbActivity.this.eQE.aTv() || view == NewSubPbActivity.this.eQE.aTw() || view == NewSubPbActivity.this.eQE.aTy()) {
                                    if (NewSubPbActivity.this.eQP) {
                                        NewSubPbActivity.this.eQP = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.eQC.getThreadID(), NewSubPbActivity.this.eQC.CU(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.eQC.aTX())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.eQC.aTX());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                } else if (NewSubPbActivity.this.eQE.aTz() == null || view != NewSubPbActivity.this.eQE.aTz().aQh()) {
                                    if (NewSubPbActivity.this.eQE.aTz() == null || view != NewSubPbActivity.this.eQE.aTz().aQm()) {
                                        if (NewSubPbActivity.this.eQE.aTz() == null || view != NewSubPbActivity.this.eQE.aTz().aQk()) {
                                            if (NewSubPbActivity.this.eQE.aTz() == null || view != NewSubPbActivity.this.eQE.aTz().aQi()) {
                                                if (NewSubPbActivity.this.eQE.aTz() == null || view != NewSubPbActivity.this.eQE.aTz().aQj()) {
                                                    if ((view == NewSubPbActivity.this.eQE.aTr() || view == NewSubPbActivity.this.eQE.aTy()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.dKF.Dw()) {
                                                            NewSubPbActivity.this.dKF.Dx();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.dKF.fU(null);
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                                TiebaStatic.log(new ak("c11739").r("obj_locate", 4));
                                                if (!j.hh()) {
                                                    NewSubPbActivity.this.showToast(d.l.network_not_available);
                                                    return;
                                                }
                                                Object tag = view.getTag();
                                                NewSubPbActivity.this.eQE.aCA();
                                                if (tag instanceof String) {
                                                    String CU = NewSubPbActivity.this.eQC.CU();
                                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                        NewSubPbActivity.this.oM(CU);
                                                        return;
                                                    }
                                                    return;
                                                } else if (tag instanceof SparseArray) {
                                                    SparseArray<Object> sparseArray = (SparseArray) tag;
                                                    if ((sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue()) {
                                                        sparseArray.put(d.h.tag_from, 0);
                                                        NewSubPbActivity.this.c(sparseArray);
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else if (j.hh()) {
                                                NewSubPbActivity.this.eQE.aCA();
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.bn(view);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                NewSubPbActivity.this.showToast(d.l.network_not_available);
                                                return;
                                            }
                                        }
                                        NewSubPbActivity.this.eQE.aCA();
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.eQE.a(((Integer) sparseArray2.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.h.tag_del_post_id), ((Integer) sparseArray2.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.h.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new ak("c11739").r("obj_locate", 1));
                                    NewSubPbActivity.this.eQE.aCA();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.dKF.fU(null);
                                        if (NewSubPbActivity.this.eQQ != null) {
                                            NewSubPbActivity.this.eQQ.aSW();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new ak("c11739").r("obj_locate", 2));
                                    NewSubPbActivity.this.eQE.aCA();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.eQC.aTE() != null) {
                                        NewSubPbActivity.this.g(NewSubPbActivity.this.eQC.aTE().aNK());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.eQE.aTj();
                                NewSubPbActivity.this.eQE.aTk();
                                if (NewSubPbActivity.this.dKF != null) {
                                    NewSubPbActivity.this.dKF.Dz();
                                    if (NewSubPbActivity.this.eQQ != null) {
                                        NewSubPbActivity.this.eQQ.aSW();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.eQE.aTj();
                            NewSubPbActivity.this.eQE.aTk();
                            if (NewSubPbActivity.this.dKF != null) {
                                NewSubPbActivity.this.dKF.Dy();
                                if (NewSubPbActivity.this.eQQ != null) {
                                    NewSubPbActivity.this.eQQ.aSW();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.eQE.aTj();
                        NewSubPbActivity.this.eQE.aTk();
                        if (NewSubPbActivity.this.dKF != null) {
                            NewSubPbActivity.this.dKF.DA();
                            if (NewSubPbActivity.this.eQQ != null) {
                                NewSubPbActivity.this.eQQ.aSW();
                            }
                        }
                    }
                }
            }
        };
        this.eQF = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.eQE.aCA();
                }
                NewSubPbActivity.this.dKF.Dx();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.eQE.aTA();
            }
        };
        this.eCT = new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.eQC.aTE() != null) {
                    postData = NewSubPbActivity.this.eQC.aTE().aNK();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.bX(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.g(postData);
                    }
                }
            }
        };
        this.auG = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SparseArray sparseArray;
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    NewSubPbActivity.this.eQE.b(NewSubPbActivity.this.eCT, NewSubPbActivity.this.eQC.isMarked());
                }
                return true;
            }
        };
        this.eQG = new TbRichTextView.g() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
            public void b(View view, String str) {
                NewSubPbActivity.this.j(null, str, "LINK_IMAGE");
            }
        };
        this.eQH = new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            /* JADX DEBUG: Multi-variable search result rejected for r2v17, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX DEBUG: Multi-variable search result rejected for r2v42, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void a(View view, String str, int i) {
                String str2;
                boolean z;
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap;
                int i2;
                boolean z2;
                ArrayList<String> arrayList;
                String str3;
                boolean z3;
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2;
                boolean z4;
                try {
                    m aTE = NewSubPbActivity.this.eQC.aTE();
                    TbRichText am = NewSubPbActivity.this.am(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (am != null && am.ID() != null) {
                        tbRichTextData = am.ID().get(NewSubPbActivity.this.eCQ);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.IJ().IV()) {
                            String c = NewSubPbActivity.this.c(tbRichTextData);
                            arrayList2.add(c);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                            concurrentHashMap3.put(c, imageUrlData);
                            String str4 = null;
                            String str5 = null;
                            String str6 = null;
                            if (aTE == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (aTE.aNR() != null) {
                                    str4 = aTE.aNR().getName();
                                    str5 = aTE.aNR().getId();
                                }
                                if (aTE.Nj() != null) {
                                    str6 = aTE.Nj().getId();
                                }
                                str3 = str6;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.eQC.aTU() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.eQC.aTU();
                                z4 = NewSubPbActivity.this.eQC.aTW();
                                arrayList2 = NewSubPbActivity.this.eQC.aTV();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z4 = z3;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(v.c(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z4, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.eCR = false;
                        String str7 = "";
                        TbRichText aCd = aTE.aNK().aCd();
                        int size = arrayList2.size();
                        int a2 = NewSubPbActivity.this.a(aCd, am, i, i, arrayList2, concurrentHashMap3);
                        int size2 = arrayList2.size();
                        if (size != size2) {
                            str7 = arrayList2.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (aTE == null) {
                            str2 = null;
                            z = false;
                        } else {
                            if (aTE.aNR() != null) {
                                str8 = aTE.aNR().getName();
                                str9 = aTE.aNR().getId();
                            }
                            if (aTE.Nj() != null) {
                                str10 = aTE.Nj().getId();
                            }
                            str2 = str10;
                            z = true;
                        }
                        if (NewSubPbActivity.this.eQC.aTU() != null) {
                            concurrentHashMap = NewSubPbActivity.this.eQC.aTU();
                            z2 = NewSubPbActivity.this.eQC.aTW();
                            arrayList = NewSubPbActivity.this.eQC.aTV();
                            i2 = a2 + NewSubPbActivity.this.eQC.getOffset();
                        } else {
                            concurrentHashMap = concurrentHashMap3;
                            i2 = a2;
                            z2 = z;
                            arrayList = arrayList2;
                        }
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.add(v.c(arrayList, i2));
                        NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList4, 0, str8, str9, str2, z2, str7, true, concurrentHashMap, true, false, false)));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo IJ;
        if (tbRichText == tbRichText2) {
            this.eCR = true;
        }
        if (tbRichText != null && tbRichText.ID() != null) {
            int size = tbRichText.ID().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.ID().get(i6) != null && tbRichText.ID().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.ID().get(i6).IJ().getWidth();
                    int height = tbRichText.ID().get(i6).IJ().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.ID().get(i6).IJ().IV()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.ID().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (IJ = tbRichTextData.IJ()) != null) {
                            String IX = IJ.IX();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = IX;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.eCR) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo IJ = tbRichTextData.IJ();
        if (IJ != null) {
            if (!StringUtils.isNull(IJ.IU())) {
                return IJ.IU();
            }
            if (IJ.getHeight() * IJ.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (IJ.getHeight() * IJ.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (IJ.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * IJ.getHeight())));
            } else {
                float width = IJ.getWidth() / IJ.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aN(IJ.IW()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText am(String str, int i) {
        if (this.eQC == null || this.eQC.aTE() == null || str == null || i < 0) {
            return null;
        }
        m aTE = this.eQC.aTE();
        TbRichText a2 = a(aTE.aNK(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(aTE.aNK(), str, i);
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
        TbRichText aCd = postData.aCd();
        if (aCd != null) {
            ArrayList<TbRichTextData> ID = aCd.ID();
            int size = ID.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (ID.get(i3) != null && ID.get(i3).getType() == 8) {
                    i2++;
                    if (ID.get(i3).IJ().IX().equals(str)) {
                        int width = ID.get(i3).IJ().getWidth();
                        int height = ID.get(i3).IJ().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.eCQ = i3;
                        return aCd;
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
    public void j(Context context, String str, String str2) {
        long templateId = this.eQC.aTE().aNK().brF() != null ? this.eQC.aTE().aNK().brF().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && av.vH().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.eQC.aTE().aNR().getId(), this.eQC.aTE().aNR().getName(), this.eQC.aTE().Nj().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i, String str) {
        if (this.eQC.aTF()) {
            showToast(str);
        } else if (l.hy()) {
            if (i == 4) {
                this.eQE.kG(str + "(4)");
            } else {
                this.eQE.gA(d.l.no_data_text);
            }
        } else {
            this.eQE.gA(d.l.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.dKF = (com.baidu.tbadk.editortools.pb.e) new f().aX(getActivity());
        this.dKF.a(getPageContext());
        this.dKF.b(this.eQC);
        this.dKF.b(this.eQS);
        this.dKF.a(this.aCJ);
        this.dKF.Cz().bC(true);
        this.dKF.e(getPageContext());
        if (this.eQE != null) {
            this.eQE.f(this.dKF);
        }
        if (this.dKF != null && this.eQC != null) {
            this.dKF.a(this.eQC.aCl());
            this.dKF.Dx();
        }
    }

    public void aTd() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dKF.Dx();
        } else if (!StringUtils.isNull(this.eQC.aTO())) {
            this.eQE.pk(this.eQC.aTO());
            if (this.eQE.aTn() && l.hy()) {
                this.eQE.aeN();
            } else {
                this.eQE.aTq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(d.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(d.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(d.h.tag_from, 1);
                    c(sparseArray);
                } else {
                    this.eQE.bk(view);
                }
            } else if (booleanValue2) {
                this.eQE.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
            }
            g.a(this.eQE.aTx(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        final String str;
        String[] strArr;
        String string;
        if (!(sparseArray.get(d.h.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(d.h.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue()) {
            String[] strArr2 = new String[2];
            strArr2[0] = getResources().getString(d.l.delete);
            if (z) {
                string = getResources().getString(d.l.un_mute);
            } else {
                string = getResources().getString(d.l.mute);
            }
            strArr2[1] = string;
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(d.l.delete)};
        }
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.cg(d.l.operation);
        bVar.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                switch (i) {
                    case 0:
                        String str2 = "";
                        int intValue = sparseArray.get(d.h.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue() : 0;
                        if (sparseArray.get(d.h.tag_del_post_id) instanceof String) {
                            str2 = (String) sparseArray.get(d.h.tag_del_post_id);
                        }
                        NewSubPbActivity.this.eQE.a(intValue, str2, sparseArray.get(d.h.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.h.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue() : false);
                        break;
                    case 1:
                        String str3 = "";
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        if (sparseArray.get(d.h.tag_user_mute_mute_username) instanceof String) {
                            str3 = (String) sparseArray.get(d.h.tag_user_mute_mute_username);
                        }
                        if (sparseArray.get(d.h.tag_user_mute_thread_id) instanceof String) {
                            str4 = (String) sparseArray.get(d.h.tag_user_mute_thread_id);
                        }
                        if (sparseArray.get(d.h.tag_user_mute_post_id) instanceof String) {
                            str5 = (String) sparseArray.get(d.h.tag_user_mute_post_id);
                        }
                        if (sparseArray.get(d.h.tag_user_mute_msg) instanceof String) {
                            str6 = (String) sparseArray.get(d.h.tag_user_mute_msg);
                        }
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.eQO);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.eQO);
                        NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str6, str3);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext()).tl();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(d.h.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.h.tag_user_mute_mute_userid);
        }
        this.eQE.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.eQO;
        userMuteCheckCustomMessage.setTag(this.eQO);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.eQE.a(0, bVar.Ak, bVar.gjd, z);
            if (bVar.Ak) {
                if (bVar.gjb == 1) {
                    finish();
                } else if (bVar.gjb == 2) {
                    this.eQC.pn(bVar.mPostId);
                    this.eQE.a(this.eQC.aTE(), this.eQC.aNm(), this.eQC.aTU() != null);
                    if (this.eQC.aTP()) {
                        this.eQC.jU(false);
                        this.eQE.aTl();
                        this.eQC.EZ();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void oM(String str) {
        if (!StringUtils.isNull(str) && this.eQC != null) {
            String threadID = this.eQC.getThreadID();
            String CU = this.eQC.CU();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + CU + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void g(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.eQC.isMarked() && postData.getId() != null && postData.getId().equals(this.eQC.aTM())) {
                z = true;
            }
            MarkData i = this.eQC.i(postData);
            if (i != null) {
                this.eQE.aCA();
                if (this.efV != null) {
                    this.efV.a(i);
                    if (!z) {
                        this.efV.nI();
                    } else {
                        this.efV.nH();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.eQC != null) {
            this.eQC.u(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dKF != null) {
            this.dKF.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cqs != null) {
            this.cqs.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.eQM = true;
        super.onPause();
        if (this.cqs != null) {
            this.cqs.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.doe);
        this.eQE.ajv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eQM = false;
        super.onResume();
        if (this.cqs != null) {
            this.cqs.onResume(getPageContext());
        }
        registerListener(this.doe);
        this.eQE.ajw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cqs != null) {
            this.cqs.onStop(getPageContext());
        }
        this.dKF.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eQC.cancelLoadData();
        this.eQC.destory();
        this.eQD.cancelLoadData();
        if (this.cqs != null) {
            this.cqs.onDestory(getPageContext());
        }
        this.eQE.aCA();
        this.eQE.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.eCF);
        MessageManager.getInstance().unRegisterListener(this.eCG);
        MessageManager.getInstance().unRegisterListener(this.eCH);
        MessageManager.getInstance().unRegisterListener(this.eQO);
        this.eCh = null;
        this.eCi = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eQE.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cqs;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aTr = this.eQE.aTr();
        if (aTr == null || (findViewWithTag = aTr.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean pa(String str) {
        Map<String, String> dT;
        if (!TextUtils.isEmpty(str) && (dT = av.dT(av.dU(str))) != null) {
            this.eQP = true;
            String str2 = dT.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pa(k.aO(str2));
            }
            String str3 = dT.get(eQB);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (pa(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            av.vH().c(getPageContext(), new String[]{str});
            this.eQP = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eQP = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ab(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ac(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ad(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void g(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public ListView getListView() {
        if (this.eQE != null) {
            return this.eQE.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int Ji() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> Jk() {
        if (this.aSe == null) {
            this.aSe = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aSe;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> Jl() {
        if (this.aSi == null) {
            this.aSi = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aOV */
                public GifView fI() {
                    return new GifView(NewSubPbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void n(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView o(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView p(GifView gifView) {
                    return gifView;
                }
            }, 20, 0);
        }
        return this.aSi;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> Jj() {
        if (this.aSd == null) {
            this.aSd = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: Vc */
                public ImageView fI() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean oZ = h.oT().oZ();
                    foreDrawableImageView.setDefaultBg(aj.getDrawable(d.e.common_color_10220));
                    if (oZ) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(d.g.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public void n(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.e.cp_bg_line_c);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView o(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (h.oT().oZ()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(d.g.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: e */
                public ImageView p(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.e.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.aSd;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Jm() {
        if (this.aSf == null) {
            this.aSf = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aCi */
                public View fI() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.f.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aM */
                public void n(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aN */
                public View o(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aO */
                public View p(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.aSf;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> Jn() {
        if (this.aSg == null) {
            this.aSg = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aOX */
                public LinearLayout fI() {
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
                /* renamed from: a */
                public void n(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: b */
                public LinearLayout o(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public LinearLayout p(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.aSg;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<RelativeLayout> Jo() {
        this.aSh = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aOW */
            public RelativeLayout fI() {
                return new RelativeLayout(NewSubPbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void n(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout o(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout p(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.aSh;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eQE.aTn() && l.hy()) {
            this.eQC.EZ();
        } else {
            this.eQE.aTq();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (sparseArray.get(d.h.tag_user_mute_mute_username) instanceof String) {
            str3 = (String) sparseArray.get(d.h.tag_user_mute_mute_username);
        }
        if (sparseArray.get(d.h.tag_user_mute_thread_id) instanceof String) {
            str4 = (String) sparseArray.get(d.h.tag_user_mute_thread_id);
        }
        if (!(sparseArray.get(d.h.tag_user_mute_post_id) instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) sparseArray.get(d.h.tag_user_mute_post_id);
        }
        String str6 = sparseArray.get(d.h.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(d.h.tag_user_mute_msg) : str2;
        if (sparseArray.get(d.h.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(d.h.tag_user_mute_msg);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.eQO);
        userMuteAddAndDelCustomMessage.setTag(this.eQO);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ae(Context context, String str) {
        j(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean Fr() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Fs() {
                return com.baidu.tbadk.pageStayDuration.e.Fx().Fz();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.eQC != null) {
            if (this.eQC.aTE() != null && this.eQC.aTE().aNR() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eQC.aTE().aNR().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eQC.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aav() {
        return this.eQM;
    }

    public boolean aTe() {
        if (this.eQC != null) {
            return this.eQC.aTe();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eQE.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eCh.getPageActivity());
        if (am.isEmpty(str)) {
            aVar.cM(this.eCh.getResources().getString(d.l.block_mute_message_alert, str2));
        } else {
            aVar.cM(str);
        }
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.eQE.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eCh).ti();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fT(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eCh.getPageActivity());
        aVar.cM(str);
        aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eCh).ti();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cM(getResources().getString(d.l.mute_is_super_member_function));
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.eCh).showToast(d.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.eCh.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eCh).ti();
    }

    public String getThreadId() {
        if (this.eQC != null) {
            return this.eQC.getThreadID();
        }
        return null;
    }

    public String getPostId() {
        if (this.eQC != null) {
            return this.eQC.CU();
        }
        return null;
    }

    public int aNm() {
        if (this.eQC != null) {
            return this.eQC.aNm();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eQR) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eQR) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }
}
