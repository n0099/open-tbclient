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
    private static final String eOO = com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String eQn = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aRQ;
    private com.baidu.adp.lib.e.b<TextView> aRR;
    private com.baidu.adp.lib.e.b<View> aRS;
    private com.baidu.adp.lib.e.b<LinearLayout> aRT;
    private com.baidu.adp.lib.e.b<RelativeLayout> aRU;
    private com.baidu.adp.lib.e.b<GifView> aRV;
    private View.OnLongClickListener auu;
    private VoiceManager cqg;
    private com.baidu.tbadk.editortools.pb.e dKr;
    private com.baidu.adp.base.e eBT;
    private com.baidu.tbadk.core.view.c eBU;
    private b.InterfaceC0047b eCF;
    private BdUniqueId eQA;
    private b eQC;
    private SubPbModel eQo;
    private ForumManageModel eQp;
    private c eQq;
    private AbsListView.OnScrollListener eQr;
    private TbRichTextView.g eQs;
    private TbRichTextView.f eQt;
    private SubPbModel.a eQu;
    private com.baidu.adp.base.d eQv;
    private com.baidu.tbadk.baseEditMark.a efH;
    private View.OnClickListener ezS;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int eCC = 0;
    private a.InterfaceC0042a eCx = null;
    private a eQw = null;
    private a eQx = null;
    private boolean eQy = false;
    private boolean eQz = false;
    private boolean eQB = false;
    private boolean eQD = false;
    private com.baidu.tbadk.editortools.pb.b aCw = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.b
        public void CQ() {
            NewSubPbActivity.this.eQq.aTk();
        }
    };
    private NewWriteModel.d eQE = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.dKr != null && NewSubPbActivity.this.dKr.Ct() != null) {
                NewSubPbActivity.this.dKr.Ct().hide();
                if (NewSubPbActivity.this.eQo.aTG()) {
                    TiebaStatic.log(new ak("c10367").ac("post_id", NewSubPbActivity.this.eQo.CO()));
                }
            }
            NewSubPbActivity.this.eQq.aTl();
        }
    };
    private CustomMessageListener eCr = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eQA) {
                NewSubPbActivity.this.eQq.Sr();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eBU.c(NewSubPbActivity.this.eBT.getResources().getString(d.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.eBT.getResources().getString(d.l.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.fS(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.aOL();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (am.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.eBT.getResources().getString(d.l.mute_fail);
                    }
                    NewSubPbActivity.this.eBU.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eCs = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eQA) {
                NewSubPbActivity.this.eQq.Sr();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eBU.c(NewSubPbActivity.this.eBT.getResources().getString(d.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (am.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.eBT.getResources().getString(d.l.un_mute_fail);
                }
                NewSubPbActivity.this.eBU.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eCt = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eQA) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.eQq.Sr();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.gtz;
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
                    NewSubPbActivity.this.eQq.a(sparseArray, z);
                }
            }
        }
    };
    boolean eCD = false;
    private CustomMessageListener dnQ = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a)) {
                b.a aVar = (b.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.b.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    public final TbRichTextView.e eOR = new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
        public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONIMAGE, new EmotionImageActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i, i2)));
        }
    };
    CustomMessageListener cra = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.eQo.aTz() != null && NewSubPbActivity.this.eQo.aTz().aNF() != null && NewSubPbActivity.this.eQo.aTz().aNF().getAuthor() != null && currentAccount.equals(NewSubPbActivity.this.eQo.aTz().aNF().getAuthor().getUserId()) && NewSubPbActivity.this.eQo.aTz().aNF().getAuthor().getPendantData() != null) {
                        NewSubPbActivity.this.eQo.aTz().aNF().getAuthor().getPendantData().cz(iVar.pL());
                        NewSubPbActivity.this.eQo.aTz().aNF().getAuthor().getPendantData().Q(iVar.BU());
                        NewSubPbActivity.this.eQq.a(NewSubPbActivity.this.eQo.aTz().aNF(), NewSubPbActivity.this.eQo.aTz().ayv(), NewSubPbActivity.this.eQo.aTz().nz(), NewSubPbActivity.this.eQo.aNh(), NewSubPbActivity.this.eQo.aTP() != null);
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
        if (this.eQD) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.eBT = getPageContext();
        this.eQz = true;
        aoH();
        aSX();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.eQo.aSZ()) {
            this.eQC = new b(this, getListView(), this.eQq.ahe());
            this.eQC.aSS();
            this.eQC.a(new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
                private boolean eQH = false;

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void aSU() {
                    NewSubPbActivity.this.eQq.jN(false);
                    this.eQH = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void aSV() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public boolean aSW() {
                    if (!this.eQH) {
                        return NewSubPbActivity.this.eQq.aTc() != null && NewSubPbActivity.this.eQq.aTc().getTop() == 0;
                    }
                    this.eQH = false;
                    return false;
                }
            });
            this.eQq.e(this.eQC);
            this.eQq.jN(true);
        }
        this.eBU = new com.baidu.tbadk.core.view.c();
        this.eBU.akv = 1000L;
        registerListener(this.eCt);
        registerListener(this.eCr);
        registerListener(this.eCs);
        this.eQA = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eQA;
        userMuteAddAndDelCustomMessage.setTag(this.eQA);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eQA;
        userMuteCheckCustomMessage.setTag(this.eQA);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.eQq = new c(this, this.ezS);
        this.eQq.a(this.eQo);
        addContentView(this.eQq.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.eQq.setOnScrollListener(this.eQr);
        this.eQq.a(this);
        this.eQq.setOnLinkImageClickListener(this.eQs);
        this.eQq.setOnImageClickListener(this.eQt);
        this.eQq.iD(true);
        this.eQq.setOnLongClickListener(this.auu);
        this.eQq.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.eQo != null) {
                    NewSubPbActivity.this.eQo.ET();
                }
            }
        });
        this.eQq.a(this.eQw);
        this.eQq.b(this.eQx);
        if (this.eQo != null && this.eQo.aSZ() && !this.eQo.aTO()) {
            this.eQq.aTq().setVisibility(8);
        } else {
            this.eQq.aTq().setVisibility(0);
        }
        if (this.eQo != null && !this.eQo.aSZ()) {
            this.eQq.setIsFromPb(false);
        }
    }

    private boolean x(Bundle bundle) {
        if (bundle != null) {
            this.eQD = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eQD = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eQD;
    }

    public void initData(Bundle bundle) {
        this.eQo = new SubPbModel(getPageContext());
        this.eQo.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void m(PostData postData) {
                NewSubPbActivity.this.eQq.o(postData);
                NewSubPbActivity.this.eQq.a((BdListView.e) null);
            }
        });
        this.eQp = new ForumManageModel(this);
        this.eQp.setLoadDataCallBack(this.eQv);
        this.cqg = new VoiceManager();
        this.cqg.onCreate(getPageContext());
        this.efH = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.efH != null) {
            this.efH.a(this.eCx);
        }
        if (bundle != null) {
            this.eQo.initWithBundle(bundle);
        } else {
            this.eQo.initWithIntent(getIntent());
        }
        this.eQo.a(this.eQu);
        if (this.eQo.aSZ()) {
            this.eQo.ET();
        } else {
            this.eQo.aTE();
        }
    }

    public void aSX() {
        this.eQu = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, m mVar) {
                if (NewSubPbActivity.this.eQq != null) {
                    NewSubPbActivity.this.eQq.aTl();
                }
                if (NewSubPbActivity.this.eQC != null && NewSubPbActivity.this.eQC.aST()) {
                    NewSubPbActivity.this.eQC.pH(d.e.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.P(i, str);
                    return;
                }
                NewSubPbActivity.this.eQq.hideNoDataView();
                if (mVar != null) {
                    if (mVar.aNF() != null || NewSubPbActivity.this.eQo != null) {
                        mVar.aNF().a(NewSubPbActivity.this.eQo.aTN());
                    }
                    if (NewSubPbActivity.this.eQq != null) {
                        NewSubPbActivity.this.eQq.a(mVar, NewSubPbActivity.this.eQo.aNh(), NewSubPbActivity.this.eQo.aTP() != null);
                        if (NewSubPbActivity.this.eQz) {
                            NewSubPbActivity.this.aSY();
                            NewSubPbActivity.this.eQz = false;
                        }
                    }
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setData(mVar);
                    if (NewSubPbActivity.this.dKr != null) {
                        NewSubPbActivity.this.dKr.a(mVar.aCg());
                    }
                    eVar.setType(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                }
            }
        };
        this.eCx = new a.InterfaceC0042a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0042a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.efH != null) {
                        NewSubPbActivity.this.efH.ac(z2);
                    }
                    MarkData nC = NewSubPbActivity.this.efH.nC();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(nC);
                        if (NewSubPbActivity.this.efH != null) {
                            if (nC != null) {
                                NewSubPbActivity.this.eQo.jS(true);
                                NewSubPbActivity.this.eQo.pn(NewSubPbActivity.this.eQo.CO());
                                NewSubPbActivity.this.showToast(d.l.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.add_mark));
                            }
                            if (NewSubPbActivity.this.eQq != null) {
                                NewSubPbActivity.this.eQq.jP(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.eQo.jS(false);
                        NewSubPbActivity.this.eQo.pn(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.remove_mark));
                        if (NewSubPbActivity.this.eQq != null) {
                            NewSubPbActivity.this.eQq.jP(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.update_mark_failed));
            }
        };
        this.eQw = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.eQo.aTz() != null && NewSubPbActivity.this.eQo.aTz().Nd() != null && NewSubPbActivity.this.eQo.aTz().Nd().getAuthor() != null) {
                    str = String.valueOf(NewSubPbActivity.this.eQo.aTz().Nd().getAuthor().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.eQo.aTz().aNM().getId(), NewSubPbActivity.this.eQo.aTz().aNM().getName(), NewSubPbActivity.this.eQo.aTz().Nd().getId(), str, str2, str3)));
            }
        };
        this.eQx = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.eQp.bsc() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.eQo != null && NewSubPbActivity.this.eQo.aTz() != null && NewSubPbActivity.this.eQo.aTz().aNM() != null && NewSubPbActivity.this.eQo.aTz().Nd() != null) {
                            NewSubPbActivity.this.eQp.a(NewSubPbActivity.this.eQo.aTz().aNM().getId(), NewSubPbActivity.this.eQo.aTz().aNM().getName(), NewSubPbActivity.this.eQo.aTz().Nd().getId(), valueOf, g2, g, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.l.login_to_use), true, 11017)));
            }
        };
        this.eQv = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = true;
                if (obj == null) {
                    NewSubPbActivity.this.eQq.a(NewSubPbActivity.this.eQp.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.eQp.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.cRI && bVar.eRv > 0 && bVar.giN != 1 && bVar.eRv != 1002) {
                            com.baidu.tieba.c.a.a(NewSubPbActivity.this.getPageContext(), 3, 1);
                            z = false;
                        }
                        if (bVar.eRv == 1002 && !bVar.cRI) {
                            z = false;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.eQq.a(1, dVar.Al, dVar.giP, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void aoH() {
        registerListener(this.cra);
        this.ezS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.eQq != null) {
                    if (view == NewSubPbActivity.this.eQq.aTw()) {
                        NewSubPbActivity.this.eQq.aCv();
                        String str = view.getTag(d.h.tag_user_id) instanceof String ? (String) view.getTag(d.h.tag_user_id) : null;
                        String str2 = view.getTag(d.h.tag_user_name) instanceof String ? (String) view.getTag(d.h.tag_user_name) : null;
                        String str3 = view.getTag(d.h.tag_virtual_user_url) instanceof String ? (String) view.getTag(d.h.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                av.vA().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.eQq.aTn()) {
                        if (view != NewSubPbActivity.this.eQq.aTp()) {
                            if (view != NewSubPbActivity.this.eQq.aTo()) {
                                if (view == NewSubPbActivity.this.eQq.aTj()) {
                                    NewSubPbActivity.this.eQq.aCv();
                                    if (NewSubPbActivity.this.eQo.ET()) {
                                        NewSubPbActivity.this.eQq.aTh();
                                    }
                                } else if (view == NewSubPbActivity.this.eQq.aTq() || view == NewSubPbActivity.this.eQq.aTr() || view == NewSubPbActivity.this.eQq.aTt()) {
                                    if (NewSubPbActivity.this.eQB) {
                                        NewSubPbActivity.this.eQB = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.eQo.getThreadID(), NewSubPbActivity.this.eQo.CO(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.eQo.aTS())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.eQo.aTS());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                } else if (NewSubPbActivity.this.eQq.aTu() == null || view != NewSubPbActivity.this.eQq.aTu().aQc()) {
                                    if (NewSubPbActivity.this.eQq.aTu() == null || view != NewSubPbActivity.this.eQq.aTu().aQh()) {
                                        if (NewSubPbActivity.this.eQq.aTu() == null || view != NewSubPbActivity.this.eQq.aTu().aQf()) {
                                            if (NewSubPbActivity.this.eQq.aTu() == null || view != NewSubPbActivity.this.eQq.aTu().aQd()) {
                                                if (NewSubPbActivity.this.eQq.aTu() == null || view != NewSubPbActivity.this.eQq.aTu().aQe()) {
                                                    if ((view == NewSubPbActivity.this.eQq.aTm() || view == NewSubPbActivity.this.eQq.aTt()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.dKr.Dq()) {
                                                            NewSubPbActivity.this.dKr.Dr();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.dKr.fT(null);
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
                                                NewSubPbActivity.this.eQq.aCv();
                                                if (tag instanceof String) {
                                                    String CO = NewSubPbActivity.this.eQo.CO();
                                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                        NewSubPbActivity.this.oL(CO);
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
                                                NewSubPbActivity.this.eQq.aCv();
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
                                        NewSubPbActivity.this.eQq.aCv();
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.eQq.a(((Integer) sparseArray2.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.h.tag_del_post_id), ((Integer) sparseArray2.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.h.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new ak("c11739").r("obj_locate", 1));
                                    NewSubPbActivity.this.eQq.aCv();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.dKr.fT(null);
                                        if (NewSubPbActivity.this.eQC != null) {
                                            NewSubPbActivity.this.eQC.aSR();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new ak("c11739").r("obj_locate", 2));
                                    NewSubPbActivity.this.eQq.aCv();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.eQo.aTz() != null) {
                                        NewSubPbActivity.this.g(NewSubPbActivity.this.eQo.aTz().aNF());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.eQq.aTe();
                                NewSubPbActivity.this.eQq.aTf();
                                if (NewSubPbActivity.this.dKr != null) {
                                    NewSubPbActivity.this.dKr.Dt();
                                    if (NewSubPbActivity.this.eQC != null) {
                                        NewSubPbActivity.this.eQC.aSR();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.eQq.aTe();
                            NewSubPbActivity.this.eQq.aTf();
                            if (NewSubPbActivity.this.dKr != null) {
                                NewSubPbActivity.this.dKr.Ds();
                                if (NewSubPbActivity.this.eQC != null) {
                                    NewSubPbActivity.this.eQC.aSR();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.eQq.aTe();
                        NewSubPbActivity.this.eQq.aTf();
                        if (NewSubPbActivity.this.dKr != null) {
                            NewSubPbActivity.this.dKr.Du();
                            if (NewSubPbActivity.this.eQC != null) {
                                NewSubPbActivity.this.eQC.aSR();
                            }
                        }
                    }
                }
            }
        };
        this.eQr = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.eQq.aCv();
                }
                NewSubPbActivity.this.dKr.Dr();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.eQq.aTv();
            }
        };
        this.eCF = new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.eQo.aTz() != null) {
                    postData = NewSubPbActivity.this.eQo.aTz().aNF();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.bW(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.g(postData);
                    }
                }
            }
        };
        this.auu = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
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
                    NewSubPbActivity.this.eQq.b(NewSubPbActivity.this.eCF, NewSubPbActivity.this.eQo.isMarked());
                }
                return true;
            }
        };
        this.eQs = new TbRichTextView.g() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
            public void b(View view, String str) {
                NewSubPbActivity.this.j(null, str, "LINK_IMAGE");
            }
        };
        this.eQt = new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                    m aTz = NewSubPbActivity.this.eQo.aTz();
                    TbRichText am = NewSubPbActivity.this.am(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (am != null && am.Ix() != null) {
                        tbRichTextData = am.Ix().get(NewSubPbActivity.this.eCC);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.ID().IP()) {
                            String c = NewSubPbActivity.this.c(tbRichTextData);
                            arrayList2.add(c);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                            concurrentHashMap3.put(c, imageUrlData);
                            String str4 = null;
                            String str5 = null;
                            String str6 = null;
                            if (aTz == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (aTz.aNM() != null) {
                                    str4 = aTz.aNM().getName();
                                    str5 = aTz.aNM().getId();
                                }
                                if (aTz.Nd() != null) {
                                    str6 = aTz.Nd().getId();
                                }
                                str3 = str6;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.eQo.aTP() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.eQo.aTP();
                                z4 = NewSubPbActivity.this.eQo.aTR();
                                arrayList2 = NewSubPbActivity.this.eQo.aTQ();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z4 = z3;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(v.c(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z4, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.eCD = false;
                        String str7 = "";
                        TbRichText aBY = aTz.aNF().aBY();
                        int size = arrayList2.size();
                        int a2 = NewSubPbActivity.this.a(aBY, am, i, i, arrayList2, concurrentHashMap3);
                        int size2 = arrayList2.size();
                        if (size != size2) {
                            str7 = arrayList2.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (aTz == null) {
                            str2 = null;
                            z = false;
                        } else {
                            if (aTz.aNM() != null) {
                                str8 = aTz.aNM().getName();
                                str9 = aTz.aNM().getId();
                            }
                            if (aTz.Nd() != null) {
                                str10 = aTz.Nd().getId();
                            }
                            str2 = str10;
                            z = true;
                        }
                        if (NewSubPbActivity.this.eQo.aTP() != null) {
                            concurrentHashMap = NewSubPbActivity.this.eQo.aTP();
                            z2 = NewSubPbActivity.this.eQo.aTR();
                            arrayList = NewSubPbActivity.this.eQo.aTQ();
                            i2 = a2 + NewSubPbActivity.this.eQo.getOffset();
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
        TbRichTextImageInfo ID;
        if (tbRichText == tbRichText2) {
            this.eCD = true;
        }
        if (tbRichText != null && tbRichText.Ix() != null) {
            int size = tbRichText.Ix().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Ix().get(i6) != null && tbRichText.Ix().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.Ix().get(i6).ID().getWidth();
                    int height = tbRichText.Ix().get(i6).ID().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Ix().get(i6).ID().IP()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Ix().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (ID = tbRichTextData.ID()) != null) {
                            String IR = ID.IR();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = IR;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.eCD) {
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
        TbRichTextImageInfo ID = tbRichTextData.ID();
        if (ID != null) {
            if (!StringUtils.isNull(ID.IO())) {
                return ID.IO();
            }
            if (ID.getHeight() * ID.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (ID.getHeight() * ID.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (ID.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * ID.getHeight())));
            } else {
                float width = ID.getWidth() / ID.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aN(ID.IQ()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText am(String str, int i) {
        if (this.eQo == null || this.eQo.aTz() == null || str == null || i < 0) {
            return null;
        }
        m aTz = this.eQo.aTz();
        TbRichText a2 = a(aTz.aNF(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(aTz.aNF(), str, i);
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
        TbRichText aBY = postData.aBY();
        if (aBY != null) {
            ArrayList<TbRichTextData> Ix = aBY.Ix();
            int size = Ix.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Ix.get(i3) != null && Ix.get(i3).getType() == 8) {
                    i2++;
                    if (Ix.get(i3).ID().IR().equals(str)) {
                        int width = Ix.get(i3).ID().getWidth();
                        int height = Ix.get(i3).ID().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.eCC = i3;
                        return aBY;
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
        long templateId = this.eQo.aTz().aNF().bry() != null ? this.eQo.aTz().aNF().bry().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && av.vA().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.eQo.aTz().aNM().getId(), this.eQo.aTz().aNM().getName(), this.eQo.aTz().Nd().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i, String str) {
        if (this.eQo.aTA()) {
            showToast(str);
        } else if (l.hy()) {
            if (i == 4) {
                this.eQq.kF(str + "(4)");
            } else {
                this.eQq.gz(d.l.no_data_text);
            }
        } else {
            this.eQq.gz(d.l.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.dKr = (com.baidu.tbadk.editortools.pb.e) new f().aW(getActivity());
        this.dKr.a(getPageContext());
        this.dKr.b(this.eQo);
        this.dKr.b(this.eQE);
        this.dKr.a(this.aCw);
        this.dKr.Ct().bB(true);
        this.dKr.e(getPageContext());
        if (this.eQq != null) {
            this.eQq.f(this.dKr);
        }
        if (this.dKr != null && this.eQo != null) {
            this.dKr.a(this.eQo.aCg());
            this.dKr.Dr();
        }
    }

    public void aSY() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dKr.Dr();
        } else if (!StringUtils.isNull(this.eQo.aTJ())) {
            this.eQq.pj(this.eQo.aTJ());
            if (this.eQq.aTi() && l.hy()) {
                this.eQq.aeI();
            } else {
                this.eQq.aTl();
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
                    this.eQq.bk(view);
                }
            } else if (booleanValue2) {
                this.eQq.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
            }
            g.a(this.eQq.aTs(), getPageContext().getPageActivity());
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
        bVar.cf(d.l.operation);
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
                        NewSubPbActivity.this.eQq.a(intValue, str2, sparseArray.get(d.h.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.h.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue() : false);
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
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.eQA);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.eQA);
                        NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str6, str3);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext()).te();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(d.h.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.h.tag_user_mute_mute_userid);
        }
        this.eQq.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.eQA;
        userMuteCheckCustomMessage.setTag(this.eQA);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.eQq.a(0, bVar.Al, bVar.giP, z);
            if (bVar.Al) {
                if (bVar.giN == 1) {
                    finish();
                } else if (bVar.giN == 2) {
                    this.eQo.pm(bVar.mPostId);
                    this.eQq.a(this.eQo.aTz(), this.eQo.aNh(), this.eQo.aTP() != null);
                    if (this.eQo.aTK()) {
                        this.eQo.jT(false);
                        this.eQq.aTg();
                        this.eQo.ET();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void oL(String str) {
        if (!StringUtils.isNull(str) && this.eQo != null) {
            String threadID = this.eQo.getThreadID();
            String CO = this.eQo.CO();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + CO + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void g(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.eQo.isMarked() && postData.getId() != null && postData.getId().equals(this.eQo.aTH())) {
                z = true;
            }
            MarkData i = this.eQo.i(postData);
            if (i != null) {
                this.eQq.aCv();
                if (this.efH != null) {
                    this.efH.a(i);
                    if (!z) {
                        this.efH.nB();
                    } else {
                        this.efH.nA();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.eQo != null) {
            this.eQo.u(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dKr != null) {
            this.dKr.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cqg != null) {
            this.cqg.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.eQy = true;
        super.onPause();
        if (this.cqg != null) {
            this.cqg.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dnQ);
        this.eQq.ajq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eQy = false;
        super.onResume();
        if (this.cqg != null) {
            this.cqg.onResume(getPageContext());
        }
        registerListener(this.dnQ);
        this.eQq.ajr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cqg != null) {
            this.cqg.onStop(getPageContext());
        }
        this.dKr.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eQo.cancelLoadData();
        this.eQo.destory();
        this.eQp.cancelLoadData();
        if (this.cqg != null) {
            this.cqg.onDestory(getPageContext());
        }
        this.eQq.aCv();
        this.eQq.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.eCr);
        MessageManager.getInstance().unRegisterListener(this.eCs);
        MessageManager.getInstance().unRegisterListener(this.eCt);
        MessageManager.getInstance().unRegisterListener(this.eQA);
        this.eBT = null;
        this.eBU = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eQq.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cqg;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aTm = this.eQq.aTm();
        if (aTm == null || (findViewWithTag = aTm.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean oZ(String str) {
        Map<String, String> dS;
        if (!TextUtils.isEmpty(str) && (dS = av.dS(av.dT(str))) != null) {
            this.eQB = true;
            String str2 = dS.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return oZ(k.aO(str2));
            }
            String str3 = dS.get(eQn);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void V(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (oZ(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            av.vA().c(getPageContext(), new String[]{str});
            this.eQB = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void U(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eQB = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void W(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void X(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Y(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void g(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public ListView getListView() {
        if (this.eQq != null) {
            return this.eQq.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int Jc() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> Je() {
        if (this.aRR == null) {
            this.aRR = TbRichTextView.k(getPageContext().getPageActivity(), 8);
        }
        return this.aRR;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> Jf() {
        if (this.aRV == null) {
            this.aRV = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aOQ */
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
        return this.aRV;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> Jd() {
        if (this.aRQ == null) {
            this.aRQ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: UY */
                public ImageView fI() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean oS = h.oM().oS();
                    foreDrawableImageView.setDefaultBg(aj.getDrawable(d.e.common_color_10220));
                    if (oS) {
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
                        if (h.oM().oS()) {
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
        return this.aRQ;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Jg() {
        if (this.aRS == null) {
            this.aRS = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aCd */
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
        return this.aRS;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> Jh() {
        if (this.aRT == null) {
            this.aRT = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aOS */
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
        return this.aRT;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<RelativeLayout> Ji() {
        this.aRU = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aOR */
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
        return this.aRU;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eQq.aTi() && l.hy()) {
            this.eQo.ET();
        } else {
            this.eQq.aTl();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.eQA);
        userMuteAddAndDelCustomMessage.setTag(this.eQA);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
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
            public boolean Fl() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Fm() {
                return com.baidu.tbadk.pageStayDuration.e.Fr().Ft();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.eQo != null) {
            if (this.eQo.aTz() != null && this.eQo.aTz().aNM() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eQo.aTz().aNM().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eQo.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aar() {
        return this.eQy;
    }

    public boolean aSZ() {
        if (this.eQo != null) {
            return this.eQo.aSZ();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eQq.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eBT.getPageActivity());
        if (am.isEmpty(str)) {
            aVar.cL(this.eBT.getResources().getString(d.l.block_mute_message_alert, str2));
        } else {
            aVar.cL(str);
        }
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.eQq.showLoadingDialog();
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
        aVar.b(this.eBT).tb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fS(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eBT.getPageActivity());
        aVar.cL(str);
        aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eBT).tb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOL() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cL(getResources().getString(d.l.mute_is_super_member_function));
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.eBT).showToast(d.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.eBT.getPageActivity(), 2, true, 4);
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
        aVar.b(this.eBT).tb();
    }

    public String getThreadId() {
        if (this.eQo != null) {
            return this.eQo.getThreadID();
        }
        return null;
    }

    public String getPostId() {
        if (this.eQo != null) {
            return this.eQo.CO();
        }
        return null;
    }

    public int aNh() {
        if (this.eQo != null) {
            return this.eQo.aNh();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eQD) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eQD) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }
}
