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
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.j;
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
    private static final String eUg = com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String eVy = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aRe;
    private com.baidu.adp.lib.e.b<TextView> aRf;
    private com.baidu.adp.lib.e.b<View> aRg;
    private com.baidu.adp.lib.e.b<View> aRh;
    private com.baidu.adp.lib.e.b<LinearLayout> aRi;
    private com.baidu.adp.lib.e.b<GifView> aRj;
    private View.OnLongClickListener avB;
    private View.OnClickListener cUc;
    private VoiceManager cpd;
    private com.baidu.tbadk.editortools.pb.e dNt;
    private com.baidu.adp.base.e eHS;
    private com.baidu.tbadk.core.view.c eHT;
    private b.InterfaceC0047b eIC;
    private ForumManageModel eVA;
    private c eVB;
    private AbsListView.OnScrollListener eVC;
    private TbRichTextView.f eVD;
    private TbRichTextView.e eVE;
    private SubPbModel.a eVF;
    private com.baidu.adp.base.d eVG;
    private BdUniqueId eVL;
    private b eVN;
    private SubPbModel eVz;
    private com.baidu.tbadk.baseEditMark.a eiQ;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int eIz = 0;
    private a.InterfaceC0042a eIu = null;
    private a eVH = null;
    private a eVI = null;
    private boolean eVJ = false;
    private boolean eVK = false;
    private boolean eVM = false;
    private boolean eVO = false;
    private com.baidu.tbadk.editortools.pb.b aDx = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.b
        public void Ds() {
            NewSubPbActivity.this.eVB.aUV();
        }
    };
    private NewWriteModel.d eVP = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.dNt != null && NewSubPbActivity.this.dNt.CV() != null) {
                NewSubPbActivity.this.dNt.CV().hide();
                if (NewSubPbActivity.this.eVz.aVr()) {
                    TiebaStatic.log(new ak("c10367").ad("post_id", NewSubPbActivity.this.eVz.Dq()));
                }
            }
            NewSubPbActivity.this.eVB.aUW();
        }
    };
    private CustomMessageListener eIo = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eVL) {
                NewSubPbActivity.this.eVB.RV();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eHT.c(NewSubPbActivity.this.eHS.getResources().getString(d.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.eHS.getResources().getString(d.l.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.ga(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.aQK();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (am.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.eHS.getResources().getString(d.l.mute_fail);
                    }
                    NewSubPbActivity.this.eHT.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eIp = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eVL) {
                NewSubPbActivity.this.eVB.RV();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eHT.c(NewSubPbActivity.this.eHS.getResources().getString(d.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (am.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.eHS.getResources().getString(d.l.un_mute_fail);
                }
                NewSubPbActivity.this.eHT.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eIq = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eVL) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.eVB.RV();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.gva;
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
                    NewSubPbActivity.this.eVB.a(sparseArray, z);
                }
            }
        }
    };
    boolean eIA = false;
    private CustomMessageListener dqT = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a)) {
                b.a aVar = (b.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.b.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    public final TbRichTextView.d eUj = new TbRichTextView.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
        public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONIMAGE, new EmotionImageActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i, i2)));
        }
    };
    CustomMessageListener cpX = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof j)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    j jVar = (j) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.eVz.aVk() != null && NewSubPbActivity.this.eVz.aVk().aPF() != null && NewSubPbActivity.this.eVz.aVk().aPF().getAuthor() != null && currentAccount.equals(NewSubPbActivity.this.eVz.aVk().aPF().getAuthor().getUserId()) && NewSubPbActivity.this.eVz.aVk().aPF().getAuthor().getPendantData() != null) {
                        NewSubPbActivity.this.eVz.aVk().aPF().getAuthor().getPendantData().cA(jVar.pR());
                        NewSubPbActivity.this.eVz.aVk().aPF().getAuthor().getPendantData().P(jVar.Cw());
                        NewSubPbActivity.this.eVB.a(NewSubPbActivity.this.eVz.aVk().aPF(), NewSubPbActivity.this.eVz.aVk().azD(), NewSubPbActivity.this.eVz.aVk().nG(), NewSubPbActivity.this.eVz.aPi(), NewSubPbActivity.this.eVz.aVA() != null);
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
        w(bundle);
        if (this.eVO) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.eHS = getPageContext();
        this.eVK = true;
        apY();
        aUI();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.eVz.aUK()) {
            this.eVN = new b(this, getListView(), this.eVB.ahe());
            this.eVN.aUD();
            this.eVN.a(new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
                private boolean eVS = false;

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void aUF() {
                    NewSubPbActivity.this.eVB.jY(false);
                    this.eVS = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void aUG() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public boolean aUH() {
                    if (!this.eVS) {
                        return NewSubPbActivity.this.eVB.aUN() != null && NewSubPbActivity.this.eVB.aUN().getTop() == 0;
                    }
                    this.eVS = false;
                    return false;
                }
            });
            this.eVB.e(this.eVN);
            this.eVB.jY(true);
        }
        this.eHT = new com.baidu.tbadk.core.view.c();
        this.eHT.akH = 1000L;
        registerListener(this.eIq);
        registerListener(this.eIo);
        registerListener(this.eIp);
        this.eVL = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eVL;
        userMuteAddAndDelCustomMessage.setTag(this.eVL);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eVL;
        userMuteCheckCustomMessage.setTag(this.eVL);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.eVB = new c(this, this.cUc);
        this.eVB.a(this.eVz);
        addContentView(this.eVB.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.eVB.setOnScrollListener(this.eVC);
        this.eVB.a(this);
        this.eVB.setOnLinkImageClickListener(this.eVD);
        this.eVB.setOnImageClickListener(this.eVE);
        this.eVB.iS(true);
        this.eVB.setOnLongClickListener(this.avB);
        this.eVB.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.eVz != null) {
                    NewSubPbActivity.this.eVz.Fu();
                }
            }
        });
        this.eVB.a(this.eVH);
        this.eVB.b(this.eVI);
        if (this.eVz != null && this.eVz.aUK() && !this.eVz.aVz()) {
            this.eVB.aVb().setVisibility(8);
        } else {
            this.eVB.aVb().setVisibility(0);
        }
        if (this.eVz != null && !this.eVz.aUK()) {
            this.eVB.setIsFromPb(false);
        }
    }

    private boolean w(Bundle bundle) {
        if (bundle != null) {
            this.eVO = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eVO = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eVO;
    }

    public void initData(Bundle bundle) {
        this.eVz = new SubPbModel(getPageContext());
        this.eVz.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.eVB.n(postData);
                NewSubPbActivity.this.eVB.a((BdListView.e) null);
            }
        });
        this.eVA = new ForumManageModel(this);
        this.eVA.setLoadDataCallBack(this.eVG);
        this.cpd = new VoiceManager();
        this.cpd.onCreate(getPageContext());
        this.eiQ = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.eiQ != null) {
            this.eiQ.a(this.eIu);
        }
        if (bundle != null) {
            this.eVz.initWithBundle(bundle);
        } else {
            this.eVz.initWithIntent(getIntent());
        }
        this.eVz.a(this.eVF);
        if (this.eVz.aUK()) {
            this.eVz.Fu();
        } else {
            this.eVz.aVp();
        }
    }

    public void aUI() {
        this.eVF = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, m mVar) {
                if (NewSubPbActivity.this.eVB != null) {
                    NewSubPbActivity.this.eVB.aUW();
                }
                if (NewSubPbActivity.this.eVN != null && NewSubPbActivity.this.eVN.aUE()) {
                    NewSubPbActivity.this.eVN.pL(d.e.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.R(i, str);
                    return;
                }
                NewSubPbActivity.this.eVB.hideNoDataView();
                if (mVar != null) {
                    if (mVar.aPF() != null || NewSubPbActivity.this.eVz != null) {
                        mVar.aPF().a(NewSubPbActivity.this.eVz.aVy());
                    }
                    if (NewSubPbActivity.this.eVB != null) {
                        NewSubPbActivity.this.eVB.a(mVar, NewSubPbActivity.this.eVz.aPi(), NewSubPbActivity.this.eVz.aVA() != null);
                        if (NewSubPbActivity.this.eVK) {
                            NewSubPbActivity.this.aUJ();
                            NewSubPbActivity.this.eVK = false;
                        }
                    }
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setData(mVar);
                    if (NewSubPbActivity.this.dNt != null) {
                        NewSubPbActivity.this.dNt.a(mVar.aDm());
                    }
                    eVar.setType(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                }
            }
        };
        this.eIu = new a.InterfaceC0042a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0042a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.eiQ != null) {
                        NewSubPbActivity.this.eiQ.ac(z2);
                    }
                    MarkData nJ = NewSubPbActivity.this.eiQ.nJ();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(nJ);
                        if (NewSubPbActivity.this.eiQ != null) {
                            if (nJ != null) {
                                NewSubPbActivity.this.eVz.kd(true);
                                NewSubPbActivity.this.eVz.pD(NewSubPbActivity.this.eVz.Dq());
                                NewSubPbActivity.this.showToast(d.l.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.add_mark));
                            }
                            if (NewSubPbActivity.this.eVB != null) {
                                NewSubPbActivity.this.eVB.ka(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.eVz.kd(false);
                        NewSubPbActivity.this.eVz.pD(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.remove_mark));
                        if (NewSubPbActivity.this.eVB != null) {
                            NewSubPbActivity.this.eVB.ka(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.update_mark_failed));
            }
        };
        this.eVH = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.eVz.aVk() != null && NewSubPbActivity.this.eVz.aVk().MR() != null && NewSubPbActivity.this.eVz.aVk().MR().getAuthor() != null) {
                    str = String.valueOf(NewSubPbActivity.this.eVz.aVk().MR().getAuthor().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.eVz.aVk().aPM().getId(), NewSubPbActivity.this.eVz.aVk().aPM().getName(), NewSubPbActivity.this.eVz.aVk().MR().getId(), str, str2, str3)));
            }
        };
        this.eVI = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.eVA.bta() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.eVz != null && NewSubPbActivity.this.eVz.aVk() != null && NewSubPbActivity.this.eVz.aVk().aPM() != null && NewSubPbActivity.this.eVz.aVk().MR() != null) {
                            NewSubPbActivity.this.eVA.a(NewSubPbActivity.this.eVz.aVk().aPM().getId(), NewSubPbActivity.this.eVz.aVk().aPM().getName(), NewSubPbActivity.this.eVz.aVk().MR().getId(), valueOf, g2, g, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.l.login_to_use), true, 11017)));
            }
        };
        this.eVG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.eVB.a(NewSubPbActivity.this.eVA.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.eVA.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.cPZ || bVar.eWG <= 0 || bVar.gky == 1) {
                            z = true;
                        } else {
                            com.baidu.tieba.c.a.a(NewSubPbActivity.this.getPageContext(), 3, 1);
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.eVB.a(1, dVar.Ai, dVar.gkA, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void apY() {
        registerListener(this.cpX);
        this.cUc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.eVB != null) {
                    if (view == NewSubPbActivity.this.eVB.aVh()) {
                        NewSubPbActivity.this.eVB.aDB();
                        String str = view.getTag(d.h.tag_user_id) instanceof String ? (String) view.getTag(d.h.tag_user_id) : null;
                        String str2 = view.getTag(d.h.tag_user_name) instanceof String ? (String) view.getTag(d.h.tag_user_name) : null;
                        String str3 = view.getTag(d.h.tag_virtual_user_url) instanceof String ? (String) view.getTag(d.h.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                au.wd().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.eVB.aUY()) {
                        if (view != NewSubPbActivity.this.eVB.aVa()) {
                            if (view != NewSubPbActivity.this.eVB.aUZ()) {
                                if (view == NewSubPbActivity.this.eVB.aUU()) {
                                    NewSubPbActivity.this.eVB.aDB();
                                    if (NewSubPbActivity.this.eVz.Fu()) {
                                        NewSubPbActivity.this.eVB.aUS();
                                    }
                                } else if (view == NewSubPbActivity.this.eVB.aVb() || view == NewSubPbActivity.this.eVB.aVc() || view == NewSubPbActivity.this.eVB.aVe()) {
                                    if (NewSubPbActivity.this.eVM) {
                                        NewSubPbActivity.this.eVM = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.eVz.getThreadID(), NewSubPbActivity.this.eVz.Dq(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.eVz.aVD())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.eVz.aVD());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                } else if (NewSubPbActivity.this.eVB.aVf() == null || view != NewSubPbActivity.this.eVB.aVf().aRZ()) {
                                    if (NewSubPbActivity.this.eVB.aVf() == null || view != NewSubPbActivity.this.eVB.aVf().aSe()) {
                                        if (NewSubPbActivity.this.eVB.aVf() == null || view != NewSubPbActivity.this.eVB.aVf().aSc()) {
                                            if (NewSubPbActivity.this.eVB.aVf() == null || view != NewSubPbActivity.this.eVB.aVf().aSa()) {
                                                if (NewSubPbActivity.this.eVB.aVf() == null || view != NewSubPbActivity.this.eVB.aVf().aSb()) {
                                                    if ((view == NewSubPbActivity.this.eVB.aUX() || view == NewSubPbActivity.this.eVB.aVe()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.dNt.DS()) {
                                                            NewSubPbActivity.this.dNt.DT();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.dNt.gb(null);
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                                TiebaStatic.log(new ak("c11739").r("obj_locate", 4));
                                                if (!i.hi()) {
                                                    NewSubPbActivity.this.showToast(d.l.network_not_available);
                                                    return;
                                                }
                                                Object tag = view.getTag();
                                                NewSubPbActivity.this.eVB.aDB();
                                                if (tag instanceof String) {
                                                    String Dq = NewSubPbActivity.this.eVz.Dq();
                                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                        NewSubPbActivity.this.pg(Dq);
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
                                            } else if (i.hi()) {
                                                NewSubPbActivity.this.eVB.aDB();
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.bp(view);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                NewSubPbActivity.this.showToast(d.l.network_not_available);
                                                return;
                                            }
                                        }
                                        NewSubPbActivity.this.eVB.aDB();
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.eVB.a(((Integer) sparseArray2.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.h.tag_del_post_id), ((Integer) sparseArray2.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.h.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new ak("c11739").r("obj_locate", 1));
                                    NewSubPbActivity.this.eVB.aDB();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.dNt.gb(null);
                                        if (NewSubPbActivity.this.eVN != null) {
                                            NewSubPbActivity.this.eVN.aUC();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new ak("c11739").r("obj_locate", 2));
                                    NewSubPbActivity.this.eVB.aDB();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.eVz.aVk() != null) {
                                        NewSubPbActivity.this.h(NewSubPbActivity.this.eVz.aVk().aPF());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.eVB.aUP();
                                NewSubPbActivity.this.eVB.aUQ();
                                if (NewSubPbActivity.this.dNt != null) {
                                    NewSubPbActivity.this.dNt.DV();
                                    if (NewSubPbActivity.this.eVN != null) {
                                        NewSubPbActivity.this.eVN.aUC();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.eVB.aUP();
                            NewSubPbActivity.this.eVB.aUQ();
                            if (NewSubPbActivity.this.dNt != null) {
                                NewSubPbActivity.this.dNt.DU();
                                if (NewSubPbActivity.this.eVN != null) {
                                    NewSubPbActivity.this.eVN.aUC();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.eVB.aUP();
                        NewSubPbActivity.this.eVB.aUQ();
                        if (NewSubPbActivity.this.dNt != null) {
                            NewSubPbActivity.this.dNt.DW();
                            if (NewSubPbActivity.this.eVN != null) {
                                NewSubPbActivity.this.eVN.aUC();
                            }
                        }
                    }
                }
            }
        };
        this.eVC = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.eVB.aDB();
                }
                NewSubPbActivity.this.dNt.DT();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.eVB.aVg();
            }
        };
        this.eIC = new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.eVz.aVk() != null) {
                    postData = NewSubPbActivity.this.eVz.aVk().aPF();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.bY(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.h(postData);
                    }
                }
            }
        };
        this.avB = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
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
                    NewSubPbActivity.this.eVB.b(NewSubPbActivity.this.eIC, NewSubPbActivity.this.eVz.isMarked());
                }
                return true;
            }
        };
        this.eVD = new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void b(View view, String str) {
                NewSubPbActivity.this.i(null, str, "LINK_IMAGE");
            }
        };
        this.eVE = new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
            public void a(View view, String str, int i) {
                String str2;
                boolean z;
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap;
                ArrayList<String> arrayList;
                boolean z2;
                String str3;
                boolean z3;
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2;
                ArrayList<String> arrayList2;
                boolean z4;
                try {
                    m aVk = NewSubPbActivity.this.eVz.aVk();
                    TbRichText an = NewSubPbActivity.this.an(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (an != null && an.Iv() != null) {
                        tbRichTextData = an.Iv().get(NewSubPbActivity.this.eIz);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList3 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.IB().IO()) {
                            String c = NewSubPbActivity.this.c(tbRichTextData);
                            arrayList3.add(c);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                            concurrentHashMap3.put(c, imageUrlData);
                            String str4 = null;
                            String str5 = null;
                            String str6 = null;
                            if (aVk == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (aVk.aPM() != null) {
                                    str4 = aVk.aPM().getName();
                                    str5 = aVk.aPM().getId();
                                }
                                if (aVk.MR() != null) {
                                    str6 = aVk.MR().getId();
                                }
                                str3 = str6;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.eVz.aVA() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.eVz.aVA();
                                z4 = NewSubPbActivity.this.eVz.aVC();
                                arrayList2 = NewSubPbActivity.this.eVz.aVB();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                arrayList2 = arrayList3;
                                z4 = z3;
                            }
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str4, str5, str3, z4, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.eIA = false;
                        String str7 = "";
                        TbRichText aDg = aVk.aPF().aDg();
                        int size = arrayList3.size();
                        int a2 = NewSubPbActivity.this.a(aDg, an, i, i, arrayList3, concurrentHashMap3);
                        int size2 = arrayList3.size();
                        if (size != size2) {
                            str7 = arrayList3.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (aVk == null) {
                            str2 = null;
                            z = false;
                        } else {
                            if (aVk.aPM() != null) {
                                str8 = aVk.aPM().getName();
                                str9 = aVk.aPM().getId();
                            }
                            if (aVk.MR() != null) {
                                str10 = aVk.MR().getId();
                            }
                            str2 = str10;
                            z = true;
                        }
                        if (NewSubPbActivity.this.eVz.aVA() != null) {
                            concurrentHashMap = NewSubPbActivity.this.eVz.aVA();
                            z2 = NewSubPbActivity.this.eVz.aVC();
                            arrayList = NewSubPbActivity.this.eVz.aVB();
                            a2 += NewSubPbActivity.this.eVz.getOffset();
                        } else {
                            concurrentHashMap = concurrentHashMap3;
                            arrayList = arrayList3;
                            z2 = z;
                        }
                        NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, a2, str8, str9, str2, z2, str7, true, concurrentHashMap, true, false, false)));
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
        TbRichTextImageInfo IB;
        if (tbRichText == tbRichText2) {
            this.eIA = true;
        }
        if (tbRichText != null && tbRichText.Iv() != null) {
            int size = tbRichText.Iv().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Iv().get(i6) != null && tbRichText.Iv().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.Iv().get(i6).IB().getWidth();
                    int height = tbRichText.Iv().get(i6).IB().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Iv().get(i6).IB().IO()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Iv().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (IB = tbRichTextData.IB()) != null) {
                            String IQ = IB.IQ();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = IQ;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.eIA) {
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
        TbRichTextImageInfo IB = tbRichTextData.IB();
        if (IB != null) {
            if (!StringUtils.isNull(IB.IN())) {
                return IB.IN();
            }
            if (IB.getHeight() * IB.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (IB.getHeight() * IB.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (IB.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * IB.getHeight())));
            } else {
                float width = IB.getWidth() / IB.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aN(IB.IP()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText an(String str, int i) {
        if (this.eVz == null || this.eVz.aVk() == null || str == null || i < 0) {
            return null;
        }
        m aVk = this.eVz.aVk();
        TbRichText a2 = a(aVk.aPF(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(aVk.aPF(), str, i);
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
        TbRichText aDg = postData.aDg();
        if (aDg != null) {
            ArrayList<TbRichTextData> Iv = aDg.Iv();
            int size = Iv.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Iv.get(i3) != null && Iv.get(i3).getType() == 8) {
                    i2++;
                    if (Iv.get(i3).IB().IQ().equals(str)) {
                        int width = Iv.get(i3).IB().getWidth();
                        int height = Iv.get(i3).IB().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.eIz = i3;
                        return aDg;
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
    public void i(Context context, String str, String str2) {
        long templateId = this.eVz.aVk().aPF().bsw() != null ? this.eVz.aVk().aPF().bsw().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && au.wd().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.eVz.aVk().aPM().getId(), this.eVz.aVk().aPM().getName(), this.eVz.aVk().MR().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, String str) {
        if (this.eVz.aVl()) {
            showToast(str);
        } else if (k.hz()) {
            if (i == 4) {
                this.eVB.kJ(str + "(4)");
            } else {
                this.eVB.gm(d.l.no_data_text);
            }
        } else {
            this.eVB.gm(d.l.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.dNt = (com.baidu.tbadk.editortools.pb.e) new f().aW(getActivity());
        this.dNt.a(getPageContext());
        this.dNt.b(this.eVz);
        this.dNt.b(this.eVP);
        this.dNt.a(this.aDx);
        this.dNt.CV().bD(true);
        this.dNt.g(getPageContext());
        if (this.eVB != null) {
            this.eVB.f(this.dNt);
        }
        if (this.dNt != null && this.eVz != null) {
            this.dNt.a(this.eVz.aDm());
            this.dNt.DT();
        }
    }

    public void aUJ() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dNt.DT();
        } else if (!StringUtils.isNull(this.eVz.aVu())) {
            this.eVB.pz(this.eVz.aVu());
            if (this.eVB.aUT() && k.hz()) {
                this.eVB.aeV();
            } else {
                this.eVB.aUW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(View view) {
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
                    this.eVB.bn(view);
                }
            } else if (booleanValue2) {
                this.eVB.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
            }
            g.a(this.eVB.aVd(), getPageContext().getPageActivity());
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
                        NewSubPbActivity.this.eVB.a(intValue, str2, sparseArray.get(d.h.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.h.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue() : false);
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
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.eVL);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.eVL);
                        NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str6, str3);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext()).tr();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(d.h.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.h.tag_user_mute_mute_userid);
        }
        this.eVB.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.eVL;
        userMuteCheckCustomMessage.setTag(this.eVL);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.eVB.a(0, bVar.Ai, bVar.gkA, z);
            if (bVar.Ai) {
                if (bVar.gky == 1) {
                    finish();
                } else if (bVar.gky == 2) {
                    this.eVz.pC(bVar.mPostId);
                    this.eVB.a(this.eVz.aVk(), this.eVz.aPi(), this.eVz.aVA() != null);
                    if (this.eVz.aVv()) {
                        this.eVz.ke(false);
                        this.eVB.aUR();
                        this.eVz.Fu();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void pg(String str) {
        if (!StringUtils.isNull(str) && this.eVz != null) {
            String threadID = this.eVz.getThreadID();
            String Dq = this.eVz.Dq();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Dq + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void h(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.eVz.isMarked() && postData.getId() != null && postData.getId().equals(this.eVz.aVs())) {
                z = true;
            }
            MarkData j = this.eVz.j(postData);
            if (j != null) {
                this.eVB.aDB();
                if (this.eiQ != null) {
                    this.eiQ.a(j);
                    if (!z) {
                        this.eiQ.nI();
                    } else {
                        this.eiQ.nH();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.eVz != null) {
            this.eVz.t(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dNt != null) {
            this.dNt.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cpd != null) {
            this.cpd.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.eVJ = true;
        super.onPause();
        if (this.cpd != null) {
            this.cpd.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dqT);
        this.eVB.ajf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eVJ = false;
        super.onResume();
        if (this.cpd != null) {
            this.cpd.onResume(getPageContext());
        }
        registerListener(this.dqT);
        this.eVB.ajg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cpd != null) {
            this.cpd.onStop(getPageContext());
        }
        this.dNt.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eVz.cancelLoadData();
        this.eVz.destory();
        this.eVA.cancelLoadData();
        if (this.cpd != null) {
            this.cpd.onDestory(getPageContext());
        }
        this.eVB.aDB();
        this.eVB.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.eIo);
        MessageManager.getInstance().unRegisterListener(this.eIp);
        MessageManager.getInstance().unRegisterListener(this.eIq);
        MessageManager.getInstance().unRegisterListener(this.eVL);
        this.eHS = null;
        this.eHT = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eVB.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cpd;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aUX = this.eVB.aUX();
        if (aUX == null || (findViewWithTag = aUX.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean pu(String str) {
        Map<String, String> ea;
        if (!TextUtils.isEmpty(str) && (ea = au.ea(au.eb(str))) != null) {
            this.eVM = true;
            String str2 = ea.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pu(com.baidu.adp.lib.util.j.aO(str2));
            }
            String str3 = ea.get(eVy);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (pu(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            au.wd().c(getPageContext(), new String[]{str});
            this.eVM = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eVM = true;
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
    public void f(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public ListView getListView() {
        if (this.eVB != null) {
            return this.eVB.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int IZ() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> Jb() {
        if (this.aRf == null) {
            this.aRf = TbRichTextView.m(getPageContext().getPageActivity(), 8);
        }
        return this.aRf;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> Jc() {
        if (this.aRj == null) {
            this.aRj = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aQP */
                public GifView fJ() {
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
        return this.aRj;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> Ja() {
        if (this.aRe == null) {
            this.aRe = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: Uy */
                public ImageView fJ() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean oY = h.oS().oY();
                    foreDrawableImageView.setDefaultBg(aj.getDrawable(d.e.common_color_10220));
                    if (oY) {
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
                        if (h.oS().oY()) {
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
        return this.aRe;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Jd() {
        if (this.aRh == null) {
            this.aRh = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aoj */
                public View fJ() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.f.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aA */
                public void n(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aB */
                public View o(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aC */
                public View p(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.aRh;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> Je() {
        if (this.aRi == null) {
            this.aRi = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aQQ */
                public LinearLayout fJ() {
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
        return this.aRi;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Jf() {
        if (this.aRg == null) {
            this.aRg = com.baidu.tieba.graffiti.c.q(getPageContext().getPageActivity(), 8);
        }
        return this.aRg;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eVB.aUT() && k.hz()) {
            this.eVz.Fu();
        } else {
            this.eVB.aUW();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.eVL);
        userMuteAddAndDelCustomMessage.setTag(this.eVL);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ae(Context context, String str) {
        i(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean FM() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int FN() {
                return com.baidu.tbadk.pageStayDuration.e.FS().FU();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.eVz != null) {
            if (this.eVz.aVk() != null && this.eVz.aVk().aPM() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eVz.aVk().aPM().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eVz.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aax() {
        return this.eVJ;
    }

    public boolean aUK() {
        if (this.eVz != null) {
            return this.eVz.aUK();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eVB.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eHS.getPageActivity());
        if (am.isEmpty(str)) {
            aVar.cM(this.eHS.getResources().getString(d.l.block_mute_message_alert, str2));
        } else {
            aVar.cM(str);
        }
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.eVB.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eHS).to();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eHS.getPageActivity());
        aVar.cM(str);
        aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eHS).to();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQK() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cM(getResources().getString(d.l.mute_is_super_member_function));
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.eHS).showToast(d.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.eHS.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eHS).to();
    }

    public String getThreadId() {
        if (this.eVz != null) {
            return this.eVz.getThreadID();
        }
        return null;
    }

    public String getPostId() {
        if (this.eVz != null) {
            return this.eVz.Dq();
        }
        return null;
    }

    public int aPi() {
        if (this.eVz != null) {
            return this.eVz.aPi();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eVO) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eVO) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }
}
