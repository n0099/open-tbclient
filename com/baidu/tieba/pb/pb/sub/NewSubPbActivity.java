package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.content.Intent;
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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
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
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.editortools.pb.f;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.c;
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
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.e {
    private static final String eYb = com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String eZu = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aSu;
    private com.baidu.adp.lib.e.b<TextView> aSv;
    private com.baidu.adp.lib.e.b<View> aSw;
    private com.baidu.adp.lib.e.b<LinearLayout> aSx;
    private com.baidu.adp.lib.e.b<RelativeLayout> aSy;
    private com.baidu.adp.lib.e.b<GifView> aSz;
    private View.OnLongClickListener auZ;
    private VoiceManager cxT;
    private f dSh;
    private b.InterfaceC0047b eLR;
    private com.baidu.adp.base.e eLd;
    private com.baidu.tbadk.core.view.c eLe;
    private EditText eUT;
    private TbRichTextView.f eZA;
    private SubPbModel.a eZB;
    private com.baidu.adp.base.d eZC;
    private BdUniqueId eZH;
    private b eZJ;
    private com.baidu.tieba.write.b eZL;
    private com.baidu.tieba.pb.e<m> eZM;
    private SubPbModel eZv;
    private ForumManageModel eZw;
    private c eZx;
    private AbsListView.OnScrollListener eZy;
    private TbRichTextView.g eZz;
    private com.baidu.tbadk.baseEditMark.a ent;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int eLO = 0;
    private a.InterfaceC0042a eLJ = null;
    private a eZD = null;
    private a eZE = null;
    private boolean eZF = false;
    private boolean eZG = false;
    private boolean eZI = false;
    private boolean eZK = false;
    private com.baidu.tbadk.editortools.pb.c aDn = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Dr() {
            NewSubPbActivity.this.eZx.aWv();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aDo = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Dq() {
            if (NewSubPbActivity.this.eZL.bCr()) {
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.eZL.bCt());
                NewSubPbActivity.this.jN(true);
                return true;
            }
            return false;
        }
    };
    private NewWriteModel.d eZN = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.dSh != null && NewSubPbActivity.this.dSh.CU() != null) {
                NewSubPbActivity.this.dSh.CU().hide();
                if (NewSubPbActivity.this.eZv.aWQ()) {
                    TiebaStatic.log(new ak("c10367").ac("post_id", NewSubPbActivity.this.eZv.Do()));
                }
            }
            if (z) {
                NewSubPbActivity.this.eZL.tO(null);
                NewSubPbActivity.this.eZL.aB(null);
                NewSubPbActivity.this.eZL.nq(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.eZL.aB(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.eZL.tO(postWriteCallBackData.getErrorString());
                if (!v.v(NewSubPbActivity.this.eZL.bCp())) {
                    NewSubPbActivity.this.jN(true);
                } else {
                    return;
                }
            }
            NewSubPbActivity.this.eZx.aWw();
        }
    };
    private CustomMessageListener eLC = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eZH) {
                NewSubPbActivity.this.eZx.VR();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eLe.c(NewSubPbActivity.this.eLd.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.eLd.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.ga(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.aSa();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (am.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.eLd.getResources().getString(d.j.mute_fail);
                    }
                    NewSubPbActivity.this.eLe.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eLD = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eZH) {
                NewSubPbActivity.this.eZx.VR();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eLe.c(NewSubPbActivity.this.eLd.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (am.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.eLd.getResources().getString(d.j.un_mute_fail);
                }
                NewSubPbActivity.this.eLe.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eLE = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eZH) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.eZx.VR();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.gDt;
                if (aVar.error == 0 && dataRes != null) {
                    boolean z2 = com.baidu.adp.lib.g.b.g(dataRes.is_mute, 0) == 1;
                    sparseArray.put(d.g.tag_user_mute_visible, true);
                    sparseArray.put(d.g.tag_user_mute_msg, dataRes.mute_confirm);
                    z = z2;
                } else {
                    sparseArray.put(d.g.tag_user_mute_visible, false);
                    z = false;
                }
                int intValue = sparseArray.get(d.g.tag_from) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_from)).intValue() : 0;
                if (intValue == 0) {
                    NewSubPbActivity.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    NewSubPbActivity.this.eZx.a(sparseArray, z);
                }
            }
        }
    };
    boolean eLP = false;
    private CustomMessageListener dwa = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener cyP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    k kVar = (k) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.eZv.aWJ() != null && NewSubPbActivity.this.eZv.aWJ().aQG() != null && NewSubPbActivity.this.eZv.aWJ().aQG().rt() != null && currentAccount.equals(NewSubPbActivity.this.eZv.aWJ().aQG().rt().getUserId()) && NewSubPbActivity.this.eZv.aWJ().aQG().rt().getPendantData() != null) {
                        NewSubPbActivity.this.eZv.aWJ().aQG().rt().getPendantData().cF(kVar.pQ());
                        NewSubPbActivity.this.eZv.aWJ().aQG().rt().getPendantData().Q(kVar.Cv());
                        NewSubPbActivity.this.eZx.a(NewSubPbActivity.this.eZv.aWJ().aQG(), NewSubPbActivity.this.eZv.aWJ().aAU(), NewSubPbActivity.this.eZv.aWJ().nC(), NewSubPbActivity.this.eZv.aQh(), NewSubPbActivity.this.eZv.aWZ() != null);
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
        if (this.eZK) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.eLd = getPageContext();
        this.eZG = true;
        this.eZL = new com.baidu.tieba.write.b();
        this.eZL.vh(d.C0080d.cp_cont_h_alpha85);
        this.eZL.vg(d.C0080d.cp_cont_i);
        amW();
        aWl();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.eZv.aWn()) {
            this.eZJ = new b(this, getListView(), this.eZx.ajA());
            this.eZJ.anb();
            this.eZJ.a(new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                private boolean cMc = false;

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void amX() {
                    NewSubPbActivity.this.eZx.ff(false);
                    this.cMc = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void amY() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public boolean amZ() {
                    if (!this.cMc) {
                        return NewSubPbActivity.this.eZx.ann() != null && NewSubPbActivity.this.eZx.ann().getTop() == 0;
                    }
                    this.cMc = false;
                    return false;
                }
            });
            this.eZx.e(this.eZJ);
            this.eZx.ff(true);
        }
        this.eLe = new com.baidu.tbadk.core.view.c();
        this.eLe.akR = 1000L;
        registerListener(this.eLE);
        registerListener(this.eLC);
        registerListener(this.eLD);
        this.eZH = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eZH;
        userMuteAddAndDelCustomMessage.setTag(this.eZH);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eZH;
        userMuteCheckCustomMessage.setTag(this.eZH);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.eZx = new c(this, this.mCommonClickListener);
        this.eZx.a(this.eZv);
        addContentView(this.eZx.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.eZx.setOnScrollListener(this.eZy);
        this.eZx.a(this);
        this.eZx.setOnLinkImageClickListener(this.eZz);
        this.eZx.setOnImageClickListener(this.eZA);
        this.eZx.iE(true);
        this.eZx.setOnLongClickListener(this.auZ);
        this.eZx.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.eZv != null) {
                    NewSubPbActivity.this.eZv.Fr();
                }
            }
        });
        this.eZx.a(this.eZD);
        this.eZx.b(this.eZE);
        if (this.eZv != null && this.eZv.aWn() && !this.eZv.aWY()) {
            this.eZx.aWA().setVisibility(8);
        } else {
            this.eZx.aWA().setVisibility(0);
        }
        if (this.eZv != null && !this.eZv.aWn()) {
            this.eZx.setIsFromPb(false);
        }
    }

    private boolean w(Bundle bundle) {
        if (bundle != null) {
            this.eZK = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eZK = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eZK;
    }

    public void initData(Bundle bundle) {
        this.eZv = new SubPbModel(getPageContext());
        this.eZv.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.eZx.n(postData);
                NewSubPbActivity.this.eZx.a((BdListView.e) null);
            }
        });
        this.eZw = new ForumManageModel(this);
        this.eZw.setLoadDataCallBack(this.eZC);
        this.cxT = new VoiceManager();
        this.cxT.onCreate(getPageContext());
        this.ent = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.ent != null) {
            this.ent.a(this.eLJ);
        }
        if (bundle != null) {
            this.eZv.initWithBundle(bundle);
        } else {
            this.eZv.initWithIntent(getIntent());
        }
        this.eZv.a(this.eZB);
        if (this.eZv.aWn()) {
            this.eZv.Fr();
        } else {
            this.eZv.aWO();
        }
    }

    public void aWl() {
        this.eZB = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, m mVar) {
                if (NewSubPbActivity.this.eZx != null) {
                    NewSubPbActivity.this.eZx.aWw();
                }
                if (NewSubPbActivity.this.eZJ != null && NewSubPbActivity.this.eZJ.anc()) {
                    NewSubPbActivity.this.eZJ.kc(d.C0080d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.R(i, str);
                    return;
                }
                NewSubPbActivity.this.eZx.hideNoDataView();
                if (mVar != null) {
                    if (mVar.aQG() != null || NewSubPbActivity.this.eZv != null) {
                        mVar.aQG().a(NewSubPbActivity.this.eZv.aWX());
                    }
                    if (NewSubPbActivity.this.eZx != null) {
                        NewSubPbActivity.this.eZx.a(mVar, NewSubPbActivity.this.eZv.aQh(), NewSubPbActivity.this.eZv.aWZ() != null);
                        if (NewSubPbActivity.this.eZG) {
                            NewSubPbActivity.this.aWm();
                            NewSubPbActivity.this.eZG = false;
                        }
                    }
                    if (NewSubPbActivity.this.dSh != null) {
                        NewSubPbActivity.this.dSh.a(mVar.aEF());
                    }
                    if (NewSubPbActivity.this.eZM == null) {
                        NewSubPbActivity.this.eZM = new com.baidu.tieba.pb.e();
                    }
                    NewSubPbActivity.this.eZM.setData(mVar);
                    NewSubPbActivity.this.eZM.setType(0);
                }
            }
        };
        this.eLJ = new a.InterfaceC0042a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0042a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.ent != null) {
                        NewSubPbActivity.this.ent.ab(z2);
                    }
                    MarkData nF = NewSubPbActivity.this.ent.nF();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(nF);
                        if (NewSubPbActivity.this.ent != null) {
                            if (nF != null) {
                                NewSubPbActivity.this.eZv.jR(true);
                                NewSubPbActivity.this.eZv.pW(NewSubPbActivity.this.eZv.Do());
                                NewSubPbActivity.this.showToast(d.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.add_mark));
                            }
                            if (NewSubPbActivity.this.eZx != null) {
                                NewSubPbActivity.this.eZx.jO(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.eZv.jR(false);
                        NewSubPbActivity.this.eZv.pW(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.remove_mark));
                        if (NewSubPbActivity.this.eZx != null) {
                            NewSubPbActivity.this.eZx.jO(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.update_mark_failed));
            }
        };
        this.eZD = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.eZv.aWJ() != null && NewSubPbActivity.this.eZv.aWJ().NA() != null && NewSubPbActivity.this.eZv.aWJ().NA().rt() != null) {
                    str = String.valueOf(NewSubPbActivity.this.eZv.aWJ().NA().rt().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.eZv.aWJ().aQN().getId(), NewSubPbActivity.this.eZv.aWJ().aQN().getName(), NewSubPbActivity.this.eZv.aWJ().NA().getId(), str, str2, str3)));
            }
        };
        this.eZE = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.eZw.bvs() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.eZv != null && NewSubPbActivity.this.eZv.aWJ() != null && NewSubPbActivity.this.eZv.aWJ().aQN() != null && NewSubPbActivity.this.eZv.aWJ().NA() != null) {
                            NewSubPbActivity.this.eZw.a(NewSubPbActivity.this.eZv.aWJ().aQN().getId(), NewSubPbActivity.this.eZv.aWJ().aQN().getName(), NewSubPbActivity.this.eZv.aWJ().NA().getId(), valueOf, g2, g, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.j.login_to_use), true, 11017)));
            }
        };
        this.eZC = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = true;
                if (obj == null) {
                    NewSubPbActivity.this.eZx.a(NewSubPbActivity.this.eZw.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.eZw.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.daT && bVar.fay > 0 && bVar.gsB != 1 && bVar.fay != 1002) {
                            com.baidu.tieba.c.a.a(NewSubPbActivity.this.getPageContext(), 3, 1);
                            z = false;
                        }
                        if (bVar.fay == 1002 && !bVar.daT) {
                            z = false;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.eZx.a(1, dVar.Al, dVar.gsD, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void amW() {
        registerListener(this.cyP);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.eZx != null) {
                    if (view == NewSubPbActivity.this.eZx.aWG()) {
                        NewSubPbActivity.this.eZx.aEU();
                        String str = view.getTag(d.g.tag_user_id) instanceof String ? (String) view.getTag(d.g.tag_user_id) : null;
                        String str2 = view.getTag(d.g.tag_user_name) instanceof String ? (String) view.getTag(d.g.tag_user_name) : null;
                        String str3 = view.getTag(d.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(d.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                av.vI().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.eZx.ano()) {
                        if (view != NewSubPbActivity.this.eZx.aWz()) {
                            if (view != NewSubPbActivity.this.eZx.aWy()) {
                                if (view == NewSubPbActivity.this.eZx.aWu()) {
                                    NewSubPbActivity.this.eZx.aEU();
                                    if (NewSubPbActivity.this.eZv.Fr()) {
                                        NewSubPbActivity.this.eZx.aWs();
                                    }
                                } else if (view == NewSubPbActivity.this.eZx.aWA() || view == NewSubPbActivity.this.eZx.aWB() || view == NewSubPbActivity.this.eZx.aWD()) {
                                    if (NewSubPbActivity.this.eZI) {
                                        NewSubPbActivity.this.eZI = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.eZv.aSH(), NewSubPbActivity.this.eZv.Do(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.eZv.aXc())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.eZv.aXc());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                } else if (NewSubPbActivity.this.eZx.aWE() == null || view != NewSubPbActivity.this.eZx.aWE().aTs()) {
                                    if (NewSubPbActivity.this.eZx.aWE() == null || view != NewSubPbActivity.this.eZx.aWE().aTx()) {
                                        if (NewSubPbActivity.this.eZx.aWE() == null || view != NewSubPbActivity.this.eZx.aWE().aTv()) {
                                            if (NewSubPbActivity.this.eZx.aWE() == null || view != NewSubPbActivity.this.eZx.aWE().aTt()) {
                                                if (NewSubPbActivity.this.eZx.aWE() == null || view != NewSubPbActivity.this.eZx.aWE().aTu()) {
                                                    if ((view == NewSubPbActivity.this.eZx.aWx() || view == NewSubPbActivity.this.eZx.aWD()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.dSh.DR()) {
                                                            NewSubPbActivity.this.dSh.DS();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.dSh.gb(null);
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                                TiebaStatic.log(new ak("c11739").r("obj_locate", 4));
                                                if (!j.hh()) {
                                                    NewSubPbActivity.this.showToast(d.j.network_not_available);
                                                    return;
                                                }
                                                Object tag = view.getTag();
                                                NewSubPbActivity.this.eZx.aEU();
                                                if (tag instanceof String) {
                                                    String Do = NewSubPbActivity.this.eZv.Do();
                                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                        NewSubPbActivity.this.pu(Do);
                                                        return;
                                                    }
                                                    return;
                                                } else if (tag instanceof SparseArray) {
                                                    SparseArray<Object> sparseArray = (SparseArray) tag;
                                                    if ((sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue()) {
                                                        sparseArray.put(d.g.tag_from, 0);
                                                        NewSubPbActivity.this.c(sparseArray);
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else if (j.hh()) {
                                                NewSubPbActivity.this.eZx.aEU();
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.bs(view);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                NewSubPbActivity.this.showToast(d.j.network_not_available);
                                                return;
                                            }
                                        }
                                        NewSubPbActivity.this.eZx.aEU();
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.eZx.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new ak("c11739").r("obj_locate", 1));
                                    NewSubPbActivity.this.eZx.aEU();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.dSh.gb(null);
                                        if (NewSubPbActivity.this.eZJ != null) {
                                            NewSubPbActivity.this.eZJ.ana();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new ak("c11739").r("obj_locate", 2));
                                    NewSubPbActivity.this.eZx.aEU();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.eZv.aWJ() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.eZv.aWJ().aQG());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.eZx.aWp();
                                NewSubPbActivity.this.eZx.aWq();
                                if (NewSubPbActivity.this.dSh != null) {
                                    NewSubPbActivity.this.dSh.DU();
                                    if (NewSubPbActivity.this.eZJ != null) {
                                        NewSubPbActivity.this.eZJ.ana();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.eZx.aWp();
                            NewSubPbActivity.this.eZx.aWq();
                            if (NewSubPbActivity.this.dSh != null) {
                                NewSubPbActivity.this.dSh.DT();
                                if (NewSubPbActivity.this.eZJ != null) {
                                    NewSubPbActivity.this.eZJ.ana();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.eZx.aWp();
                        NewSubPbActivity.this.eZx.aWq();
                        if (NewSubPbActivity.this.dSh != null) {
                            NewSubPbActivity.this.dSh.DV();
                            if (NewSubPbActivity.this.eZJ != null) {
                                NewSubPbActivity.this.eZJ.ana();
                            }
                        }
                    }
                }
            }
        };
        this.eZy = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.eZx.aEU();
                }
                NewSubPbActivity.this.dSh.DS();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.eZx.aWF();
            }
        };
        this.eLR = new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.eZv.aWJ() != null) {
                    postData = NewSubPbActivity.this.eZv.aWJ().aQG();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.bW(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.f(postData);
                    }
                }
            }
        };
        this.auZ = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                    NewSubPbActivity.this.eZx.b(NewSubPbActivity.this.eLR, NewSubPbActivity.this.eZv.isMarked());
                }
                return true;
            }
        };
        this.eZz = new TbRichTextView.g() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
            public void b(View view, String str) {
                NewSubPbActivity.this.j(null, str, "LINK_IMAGE");
            }
        };
        this.eZA = new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
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
                    m aWJ = NewSubPbActivity.this.eZv.aWJ();
                    TbRichText as = NewSubPbActivity.this.as(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (as != null && as.IT() != null) {
                        tbRichTextData = as.IT().get(NewSubPbActivity.this.eLO);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.IZ().Jl()) {
                            String c = NewSubPbActivity.this.c(tbRichTextData);
                            arrayList2.add(c);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                            concurrentHashMap3.put(c, imageUrlData);
                            String str4 = null;
                            String str5 = null;
                            String str6 = null;
                            if (aWJ == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (aWJ.aQN() != null) {
                                    str4 = aWJ.aQN().getName();
                                    str5 = aWJ.aQN().getId();
                                }
                                if (aWJ.NA() != null) {
                                    str6 = aWJ.NA().getId();
                                }
                                str3 = str6;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.eZv.aWZ() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.eZv.aWZ();
                                z4 = NewSubPbActivity.this.eZv.aXb();
                                arrayList2 = NewSubPbActivity.this.eZv.aXa();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z4 = z3;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(v.c(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z4, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.eLP = false;
                        String str7 = "";
                        TbRichText aEx = aWJ.aQG().aEx();
                        int size = arrayList2.size();
                        int a2 = NewSubPbActivity.this.a(aEx, as, i, i, arrayList2, concurrentHashMap3);
                        int size2 = arrayList2.size();
                        if (size != size2) {
                            str7 = arrayList2.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (aWJ == null) {
                            str2 = null;
                            z = false;
                        } else {
                            if (aWJ.aQN() != null) {
                                str8 = aWJ.aQN().getName();
                                str9 = aWJ.aQN().getId();
                            }
                            if (aWJ.NA() != null) {
                                str10 = aWJ.NA().getId();
                            }
                            str2 = str10;
                            z = true;
                        }
                        if (NewSubPbActivity.this.eZv.aWZ() != null) {
                            concurrentHashMap = NewSubPbActivity.this.eZv.aWZ();
                            z2 = NewSubPbActivity.this.eZv.aXb();
                            arrayList = NewSubPbActivity.this.eZv.aXa();
                            i2 = a2 + NewSubPbActivity.this.eZv.getOffset();
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
        TbRichTextImageInfo IZ;
        if (tbRichText == tbRichText2) {
            this.eLP = true;
        }
        if (tbRichText != null && tbRichText.IT() != null) {
            int size = tbRichText.IT().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.IT().get(i6) != null && tbRichText.IT().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.IT().get(i6).IZ().getWidth();
                    int height = tbRichText.IT().get(i6).IZ().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.IT().get(i6).IZ().Jl()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.IT().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (IZ = tbRichTextData.IZ()) != null) {
                            String Jn = IZ.Jn();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Jn;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.eLP) {
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
        TbRichTextImageInfo IZ = tbRichTextData.IZ();
        if (IZ != null) {
            if (!StringUtils.isNull(IZ.Jk())) {
                return IZ.Jk();
            }
            if (IZ.getHeight() * IZ.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (IZ.getHeight() * IZ.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (IZ.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * IZ.getHeight())));
            } else {
                float width = IZ.getWidth() / IZ.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aN(IZ.Jm()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText as(String str, int i) {
        if (this.eZv == null || this.eZv.aWJ() == null || str == null || i < 0) {
            return null;
        }
        m aWJ = this.eZv.aWJ();
        TbRichText a2 = a(aWJ.aQG(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(aWJ.aQG(), str, i);
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
        TbRichText aEx = postData.aEx();
        if (aEx != null) {
            ArrayList<TbRichTextData> IT = aEx.IT();
            int size = IT.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (IT.get(i3) != null && IT.get(i3).getType() == 8) {
                    i2++;
                    if (IT.get(i3).IZ().Jn().equals(str)) {
                        int width = IT.get(i3).IZ().getWidth();
                        int height = IT.get(i3).IZ().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.eLO = i3;
                        return aEx;
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
        long templateId = this.eZv.aWJ().aQG().buO() != null ? this.eZv.aWJ().aQG().buO().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && av.vI().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.eZv.aWJ().aQN().getId(), this.eZv.aWJ().aQN().getName(), this.eZv.aWJ().NA().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, String str) {
        if (this.eZv.aWK()) {
            showToast(str);
        } else if (l.hy()) {
            if (i == 4) {
                this.eZx.ld(str + "(4)");
            } else {
                this.eZx.gC(d.j.no_data_text);
            }
        } else {
            this.eZx.gC(d.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.dSh = (f) new g().aW(getActivity());
        this.dSh.a(getPageContext());
        this.dSh.b(this.eZv);
        this.dSh.b(this.eZN);
        this.dSh.a(this.aDn);
        this.dSh.a(this.aDo);
        this.dSh.CU().bx(true);
        this.dSh.e(getPageContext());
        if (this.eZx != null) {
            this.eZx.f(this.dSh);
        }
        if (this.dSh != null && this.eZv != null) {
            this.dSh.a(this.eZv.aEF());
            this.dSh.DS();
        }
        this.eUT = this.dSh.Du().Dm();
        this.eUT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (NewSubPbActivity.this.eZL != null) {
                    if (!NewSubPbActivity.this.eZL.bCs()) {
                        NewSubPbActivity.this.jN(false);
                    }
                    NewSubPbActivity.this.eZL.nr(false);
                }
            }
        });
    }

    public void aWm() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dSh.DS();
        } else if (!StringUtils.isNull(this.eZv.aWT())) {
            this.eZx.pS(this.eZv.aWT());
            if (this.eZx.aWt() && l.hy()) {
                this.eZx.ahd();
            } else {
                this.eZx.aWw();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(d.g.tag_from, 1);
                    c(sparseArray);
                } else {
                    this.eZx.bo(view);
                }
            } else if (booleanValue2) {
                this.eZx.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.eZx.aWC(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        final String str;
        String[] strArr;
        String string;
        if (!(sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue()) {
            String[] strArr2 = new String[2];
            strArr2[0] = getResources().getString(d.j.delete);
            if (z) {
                string = getResources().getString(d.j.un_mute);
            } else {
                string = getResources().getString(d.j.mute);
            }
            strArr2[1] = string;
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(d.j.delete)};
        }
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.cf(d.j.operation);
        bVar.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                switch (i) {
                    case 0:
                        String str2 = "";
                        int intValue = sparseArray.get(d.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue() : 0;
                        if (sparseArray.get(d.g.tag_del_post_id) instanceof String) {
                            str2 = (String) sparseArray.get(d.g.tag_del_post_id);
                        }
                        NewSubPbActivity.this.eZx.a(intValue, str2, sparseArray.get(d.g.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue() : false);
                        break;
                    case 1:
                        String str3 = "";
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        if (sparseArray.get(d.g.tag_user_mute_mute_username) instanceof String) {
                            str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                        }
                        if (sparseArray.get(d.g.tag_user_mute_thread_id) instanceof String) {
                            str4 = (String) sparseArray.get(d.g.tag_user_mute_thread_id);
                        }
                        if (sparseArray.get(d.g.tag_user_mute_post_id) instanceof String) {
                            str5 = (String) sparseArray.get(d.g.tag_user_mute_post_id);
                        }
                        if (sparseArray.get(d.g.tag_user_mute_msg) instanceof String) {
                            str6 = (String) sparseArray.get(d.g.tag_user_mute_msg);
                        }
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.eZH);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.eZH);
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
        if (sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
        }
        this.eZx.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.eZH;
        userMuteCheckCustomMessage.setTag(this.eZH);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.eZx.a(0, bVar.Al, bVar.gsD, z);
            if (bVar.Al) {
                if (bVar.gsB == 1) {
                    finish();
                } else if (bVar.gsB == 2) {
                    this.eZv.pV(bVar.mPostId);
                    this.eZx.a(this.eZv.aWJ(), this.eZv.aQh(), this.eZv.aWZ() != null);
                    if (this.eZv.aWU()) {
                        this.eZv.jS(false);
                        this.eZx.aWr();
                        this.eZv.Fr();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void pu(String str) {
        if (!StringUtils.isNull(str) && this.eZv != null) {
            String aSH = this.eZv.aSH();
            String Do = this.eZv.Do();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Do + "&tid=" + aSH + "&pid=" + str, true)));
        }
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.eZv.isMarked() && postData.getId() != null && postData.getId().equals(this.eZv.aWR())) {
                z = true;
            }
            MarkData h = this.eZv.h(postData);
            if (h != null) {
                this.eZx.aEU();
                if (this.ent != null) {
                    this.ent.a(h);
                    if (!z) {
                        this.ent.nE();
                    } else {
                        this.ent.nD();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.eZv != null) {
            this.eZv.t(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dSh != null) {
            this.dSh.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cxT != null) {
            this.cxT.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.eZF = true;
        super.onPause();
        if (this.cxT != null) {
            this.cxT.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dwa);
        this.eZx.alR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eZF = false;
        super.onResume();
        if (this.cxT != null) {
            this.cxT.onResume(getPageContext());
        }
        registerListener(this.dwa);
        this.eZx.alS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cxT != null) {
            this.cxT.onStop(getPageContext());
        }
        this.dSh.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.eZM));
        this.eZv.cancelLoadData();
        this.eZv.destory();
        this.eZw.cancelLoadData();
        if (this.cxT != null) {
            this.cxT.onDestory(getPageContext());
        }
        this.eZx.aEU();
        this.eZx.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.eLC);
        MessageManager.getInstance().unRegisterListener(this.eLD);
        MessageManager.getInstance().unRegisterListener(this.eLE);
        MessageManager.getInstance().unRegisterListener(this.eZH);
        this.eLd = null;
        this.eLe = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eZx.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cxT;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aWx = this.eZx.aWx();
        if (aWx == null || (findViewWithTag = aWx.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean pI(String str) {
        Map<String, String> dY;
        if (!TextUtils.isEmpty(str) && (dY = av.dY(av.dZ(str))) != null) {
            this.eZI = true;
            String str2 = dY.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pI(com.baidu.adp.lib.util.k.aO(str2));
            }
            String str3 = dY.get(eZu);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (pI(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            av.vI().c(getPageContext(), new String[]{str});
            this.eZI = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void U(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eZI = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void W(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void g(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.eZx != null) {
            return this.eZx.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Jy() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> JA() {
        if (this.aSv == null) {
            this.aSv = TbRichTextView.k(getPageContext().getPageActivity(), 8);
        }
        return this.aSv;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> JB() {
        if (this.aSz == null) {
            this.aSz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aSf */
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
        return this.aSz;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Jz() {
        if (this.aSu == null) {
            this.aSu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: Xd */
                public ImageView fI() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean oZ = h.oT().oZ();
                    foreDrawableImageView.setDefaultBg(aj.getDrawable(d.C0080d.common_color_10220));
                    if (oZ) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(d.f.icon_click);
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
                        foreDrawableImageView.setDefaultBgResource(d.C0080d.cp_bg_line_c);
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
                            tbImageView.setDefaultResource(d.f.icon_click);
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
                        foreDrawableImageView.setDefaultBgResource(d.C0080d.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.aSu;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> JC() {
        if (this.aSw == null) {
            this.aSw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aEC */
                public View fI() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aR */
                public void n(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aS */
                public View o(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aT */
                public View p(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.aSw;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> JD() {
        if (this.aSx == null) {
            this.aSx = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aSh */
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
                /* renamed from: b */
                public void n(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public LinearLayout o(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public LinearLayout p(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.aSx;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> JE() {
        this.aSy = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aSg */
            public RelativeLayout fI() {
                return new RelativeLayout(NewSubPbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public void n(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout o(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: f */
            public RelativeLayout p(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.aSy;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eZx.aWt() && l.hy()) {
            this.eZv.Fr();
        } else {
            this.eZx.aWw();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (sparseArray.get(d.g.tag_user_mute_mute_username) instanceof String) {
            str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(d.g.tag_user_mute_thread_id) instanceof String) {
            str4 = (String) sparseArray.get(d.g.tag_user_mute_thread_id);
        }
        if (!(sparseArray.get(d.g.tag_user_mute_post_id) instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) sparseArray.get(d.g.tag_user_mute_post_id);
        }
        String str6 = sparseArray.get(d.g.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(d.g.tag_user_mute_msg) : str2;
        if (sparseArray.get(d.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(d.g.tag_user_mute_msg);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.eZH);
        userMuteAddAndDelCustomMessage.setTag(this.eZH);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
        j(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean FJ() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int FK() {
                return com.baidu.tbadk.pageStayDuration.e.FO().FQ();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.eZv != null) {
            if (this.eZv.aWJ() != null && this.eZv.aWJ().aQN() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eZv.aWJ().aQN().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eZv.aSH(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean acM() {
        return this.eZF;
    }

    public boolean aWn() {
        if (this.eZv != null) {
            return this.eZv.aWn();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eZx.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eLd.getPageActivity());
        if (am.isEmpty(str)) {
            aVar.cS(this.eLd.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.cS(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.eZx.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eLd).th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eLd.getPageActivity());
        aVar.cS(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eLd).th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSa() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cS(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.eLd).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.eLd.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eLd).th();
    }

    public String getThreadId() {
        if (this.eZv != null) {
            return this.eZv.aSH();
        }
        return null;
    }

    public String getPostId() {
        if (this.eZv != null) {
            return this.eZv.Do();
        }
        return null;
    }

    public int aQh() {
        if (this.eZv != null) {
            return this.eZv.aQh();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eZK) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eZK) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void jN(boolean z) {
        if (this.eUT != null && this.eUT.getText() != null) {
            int selectionEnd = this.eUT.getSelectionEnd();
            SpannableStringBuilder b = this.eZL.b(this.eUT.getText());
            if (b != null) {
                this.eZL.nr(true);
                this.eUT.setText(b);
                if (z && this.eZL.bCq() >= 0) {
                    this.eUT.requestFocus();
                    this.eUT.setSelection(this.eZL.bCq());
                } else {
                    this.eUT.setSelection(selectionEnd);
                }
                this.eZL.nq(this.eZL.bCq() >= 0);
            }
        }
    }
}
