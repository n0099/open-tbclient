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
import com.baidu.tbadk.coreExtra.data.q;
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
    private static final String eXG = com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String eYZ = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aSm;
    private com.baidu.adp.lib.e.b<TextView> aSn;
    private com.baidu.adp.lib.e.b<View> aSo;
    private com.baidu.adp.lib.e.b<LinearLayout> aSp;
    private com.baidu.adp.lib.e.b<RelativeLayout> aSq;
    private com.baidu.adp.lib.e.b<GifView> aSr;
    private View.OnLongClickListener auR;
    private VoiceManager cxA;
    private f dSd;
    private com.baidu.adp.base.e eKJ;
    private com.baidu.tbadk.core.view.c eKK;
    private b.InterfaceC0047b eLx;
    private EditText eUy;
    private SubPbModel eZa;
    private ForumManageModel eZb;
    private c eZc;
    private AbsListView.OnScrollListener eZd;
    private TbRichTextView.g eZe;
    private TbRichTextView.f eZf;
    private SubPbModel.a eZg;
    private com.baidu.adp.base.d eZh;
    private BdUniqueId eZm;
    private b eZo;
    private com.baidu.tieba.write.b eZq;
    private com.baidu.tieba.pb.e<m> eZr;
    private com.baidu.tbadk.baseEditMark.a enp;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int eLu = 0;
    private a.InterfaceC0042a eLp = null;
    private a eZi = null;
    private a eZj = null;
    private boolean eZk = false;
    private boolean eZl = false;
    private boolean eZn = false;
    private boolean eZp = false;
    private com.baidu.tbadk.editortools.pb.c aDf = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Df() {
            NewSubPbActivity.this.eZc.aWn();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aDg = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean De() {
            if (NewSubPbActivity.this.eZq.bCf()) {
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.eZq.bCh());
                NewSubPbActivity.this.jH(true);
                return true;
            }
            return false;
        }
    };
    private NewWriteModel.d eZs = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.dSd != null && NewSubPbActivity.this.dSd.CI() != null) {
                NewSubPbActivity.this.dSd.CI().hide();
                if (NewSubPbActivity.this.eZa.aWI()) {
                    TiebaStatic.log(new ak("c10367").ac("post_id", NewSubPbActivity.this.eZa.Dc()));
                }
            }
            if (z) {
                NewSubPbActivity.this.eZq.tI(null);
                NewSubPbActivity.this.eZq.aB(null);
                NewSubPbActivity.this.eZq.ni(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.eZq.aB(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.eZq.tI(postWriteCallBackData.getErrorString());
                if (!v.v(NewSubPbActivity.this.eZq.bCd())) {
                    NewSubPbActivity.this.jH(true);
                } else {
                    return;
                }
            }
            NewSubPbActivity.this.eZc.aWo();
        }
    };
    private CustomMessageListener eLi = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eZm) {
                NewSubPbActivity.this.eZc.VG();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eKK.c(NewSubPbActivity.this.eKJ.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.eKJ.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.fZ(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.aRS();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (am.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.eKJ.getResources().getString(d.j.mute_fail);
                    }
                    NewSubPbActivity.this.eKK.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eLj = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eZm) {
                NewSubPbActivity.this.eZc.VG();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eKK.c(NewSubPbActivity.this.eKJ.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (am.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.eKJ.getResources().getString(d.j.un_mute_fail);
                }
                NewSubPbActivity.this.eKK.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eLk = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eZm) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.eZc.VG();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.gCl;
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
                    NewSubPbActivity.this.eZc.a(sparseArray, z);
                }
            }
        }
    };
    boolean eLv = false;
    private CustomMessageListener dvG = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener cyw = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    k kVar = (k) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.eZa.aWB() != null && NewSubPbActivity.this.eZa.aWB().aQy() != null && NewSubPbActivity.this.eZa.aWB().aQy().rt() != null && currentAccount.equals(NewSubPbActivity.this.eZa.aWB().aQy().rt().getUserId()) && NewSubPbActivity.this.eZa.aWB().aQy().rt().getPendantData() != null) {
                        NewSubPbActivity.this.eZa.aWB().aQy().rt().getPendantData().cF(kVar.pQ());
                        NewSubPbActivity.this.eZa.aWB().aQy().rt().getPendantData().Q(kVar.Cj());
                        NewSubPbActivity.this.eZc.a(NewSubPbActivity.this.eZa.aWB().aQy(), NewSubPbActivity.this.eZa.aWB().aAQ(), NewSubPbActivity.this.eZa.aWB().nC(), NewSubPbActivity.this.eZa.aPZ(), NewSubPbActivity.this.eZa.aWR() != null);
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
        if (this.eZp) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.eKJ = getPageContext();
        this.eZl = true;
        this.eZq = new com.baidu.tieba.write.b();
        this.eZq.vd(d.C0080d.cp_cont_h_alpha85);
        this.eZq.vc(d.C0080d.cp_cont_i);
        amI();
        aWd();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.eZa.aWf()) {
            this.eZo = new b(this, getListView(), this.eZc.ajm());
            this.eZo.amN();
            this.eZo.a(new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                private boolean cLJ = false;

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void amJ() {
                    NewSubPbActivity.this.eZc.fa(false);
                    this.cLJ = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void amK() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public boolean amL() {
                    if (!this.cLJ) {
                        return NewSubPbActivity.this.eZc.amZ() != null && NewSubPbActivity.this.eZc.amZ().getTop() == 0;
                    }
                    this.cLJ = false;
                    return false;
                }
            });
            this.eZc.e(this.eZo);
            this.eZc.fa(true);
        }
        this.eKK = new com.baidu.tbadk.core.view.c();
        this.eKK.akR = 1000L;
        registerListener(this.eLk);
        registerListener(this.eLi);
        registerListener(this.eLj);
        this.eZm = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eZm;
        userMuteAddAndDelCustomMessage.setTag(this.eZm);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eZm;
        userMuteCheckCustomMessage.setTag(this.eZm);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.eZc = new c(this, this.mCommonClickListener);
        this.eZc.a(this.eZa);
        addContentView(this.eZc.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.eZc.setOnScrollListener(this.eZd);
        this.eZc.a(this);
        this.eZc.setOnLinkImageClickListener(this.eZe);
        this.eZc.setOnImageClickListener(this.eZf);
        this.eZc.iy(true);
        this.eZc.setOnLongClickListener(this.auR);
        this.eZc.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.eZa != null) {
                    NewSubPbActivity.this.eZa.Ff();
                }
            }
        });
        this.eZc.a(this.eZi);
        this.eZc.b(this.eZj);
        if (this.eZa != null && this.eZa.aWf() && !this.eZa.aWQ()) {
            this.eZc.aWs().setVisibility(8);
        } else {
            this.eZc.aWs().setVisibility(0);
        }
        if (this.eZa != null && !this.eZa.aWf()) {
            this.eZc.setIsFromPb(false);
        }
    }

    private boolean w(Bundle bundle) {
        if (bundle != null) {
            this.eZp = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eZp = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eZp;
    }

    public void initData(Bundle bundle) {
        this.eZa = new SubPbModel(getPageContext());
        this.eZa.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.eZc.n(postData);
                NewSubPbActivity.this.eZc.a((BdListView.e) null);
            }
        });
        this.eZb = new ForumManageModel(this);
        this.eZb.setLoadDataCallBack(this.eZh);
        this.cxA = new VoiceManager();
        this.cxA.onCreate(getPageContext());
        this.enp = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.enp != null) {
            this.enp.a(this.eLp);
        }
        if (bundle != null) {
            this.eZa.initWithBundle(bundle);
        } else {
            this.eZa.initWithIntent(getIntent());
        }
        this.eZa.a(this.eZg);
        if (this.eZa.aWf()) {
            this.eZa.Ff();
        } else {
            this.eZa.aWG();
        }
    }

    public void aWd() {
        this.eZg = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, m mVar) {
                if (NewSubPbActivity.this.eZc != null) {
                    NewSubPbActivity.this.eZc.aWo();
                }
                if (NewSubPbActivity.this.eZo != null && NewSubPbActivity.this.eZo.amO()) {
                    NewSubPbActivity.this.eZo.kd(d.C0080d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.R(i, str);
                    return;
                }
                NewSubPbActivity.this.eZc.hideNoDataView();
                if (mVar != null) {
                    if (mVar.aQy() != null || NewSubPbActivity.this.eZa != null) {
                        mVar.aQy().a(NewSubPbActivity.this.eZa.aWP());
                    }
                    if (NewSubPbActivity.this.eZc != null) {
                        NewSubPbActivity.this.eZc.a(mVar, NewSubPbActivity.this.eZa.aPZ(), NewSubPbActivity.this.eZa.aWR() != null);
                        if (NewSubPbActivity.this.eZl) {
                            NewSubPbActivity.this.aWe();
                            NewSubPbActivity.this.eZl = false;
                        }
                    }
                    if (NewSubPbActivity.this.dSd != null) {
                        NewSubPbActivity.this.dSd.a(mVar.aEB());
                    }
                    if (NewSubPbActivity.this.eZr == null) {
                        NewSubPbActivity.this.eZr = new com.baidu.tieba.pb.e();
                    }
                    NewSubPbActivity.this.eZr.setData(mVar);
                    NewSubPbActivity.this.eZr.setType(0);
                }
            }
        };
        this.eLp = new a.InterfaceC0042a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0042a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.enp != null) {
                        NewSubPbActivity.this.enp.ab(z2);
                    }
                    MarkData nF = NewSubPbActivity.this.enp.nF();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(nF);
                        if (NewSubPbActivity.this.enp != null) {
                            if (nF != null) {
                                NewSubPbActivity.this.eZa.jL(true);
                                NewSubPbActivity.this.eZa.pS(NewSubPbActivity.this.eZa.Dc());
                                NewSubPbActivity.this.showToast(d.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.add_mark));
                            }
                            if (NewSubPbActivity.this.eZc != null) {
                                NewSubPbActivity.this.eZc.jI(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.eZa.jL(false);
                        NewSubPbActivity.this.eZa.pS(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.remove_mark));
                        if (NewSubPbActivity.this.eZc != null) {
                            NewSubPbActivity.this.eZc.jI(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.j.update_mark_failed));
            }
        };
        this.eZi = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.eZa.aWB() != null && NewSubPbActivity.this.eZa.aWB().Np() != null && NewSubPbActivity.this.eZa.aWB().Np().rt() != null) {
                    str = String.valueOf(NewSubPbActivity.this.eZa.aWB().Np().rt().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.eZa.aWB().aQF().getId(), NewSubPbActivity.this.eZa.aWB().aQF().getName(), NewSubPbActivity.this.eZa.aWB().Np().getId(), str, str2, str3)));
            }
        };
        this.eZj = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.eZb.bvg() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.eZa != null && NewSubPbActivity.this.eZa.aWB() != null && NewSubPbActivity.this.eZa.aWB().aQF() != null && NewSubPbActivity.this.eZa.aWB().Np() != null) {
                            NewSubPbActivity.this.eZb.a(NewSubPbActivity.this.eZa.aWB().aQF().getId(), NewSubPbActivity.this.eZa.aWB().aQF().getName(), NewSubPbActivity.this.eZa.aWB().Np().getId(), valueOf, g2, g, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.j.login_to_use), true, 11017)));
            }
        };
        this.eZh = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = true;
                if (obj == null) {
                    NewSubPbActivity.this.eZc.a(NewSubPbActivity.this.eZb.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.eZb.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.daz && bVar.fad > 0 && bVar.gry != 1 && bVar.fad != 1002) {
                            com.baidu.tieba.c.a.a(NewSubPbActivity.this.getPageContext(), 3, 1);
                            z = false;
                        }
                        if (bVar.fad == 1002 && !bVar.daz) {
                            z = false;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.eZc.a(1, dVar.Al, dVar.grA, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void amI() {
        registerListener(this.cyw);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.eZc != null) {
                    if (view == NewSubPbActivity.this.eZc.aWy()) {
                        NewSubPbActivity.this.eZc.aEQ();
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
                    } else if (view != NewSubPbActivity.this.eZc.ana()) {
                        if (view != NewSubPbActivity.this.eZc.aWr()) {
                            if (view != NewSubPbActivity.this.eZc.aWq()) {
                                if (view == NewSubPbActivity.this.eZc.aWm()) {
                                    NewSubPbActivity.this.eZc.aEQ();
                                    if (NewSubPbActivity.this.eZa.Ff()) {
                                        NewSubPbActivity.this.eZc.aWk();
                                    }
                                } else if (view == NewSubPbActivity.this.eZc.aWs() || view == NewSubPbActivity.this.eZc.aWt() || view == NewSubPbActivity.this.eZc.aWv()) {
                                    if (NewSubPbActivity.this.eZn) {
                                        NewSubPbActivity.this.eZn = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.eZa.aSz(), NewSubPbActivity.this.eZa.Dc(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.eZa.aWU())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.eZa.aWU());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                } else if (NewSubPbActivity.this.eZc.aWw() == null || view != NewSubPbActivity.this.eZc.aWw().aTk()) {
                                    if (NewSubPbActivity.this.eZc.aWw() == null || view != NewSubPbActivity.this.eZc.aWw().aTp()) {
                                        if (NewSubPbActivity.this.eZc.aWw() == null || view != NewSubPbActivity.this.eZc.aWw().aTn()) {
                                            if (NewSubPbActivity.this.eZc.aWw() == null || view != NewSubPbActivity.this.eZc.aWw().aTl()) {
                                                if (NewSubPbActivity.this.eZc.aWw() == null || view != NewSubPbActivity.this.eZc.aWw().aTm()) {
                                                    if ((view == NewSubPbActivity.this.eZc.aWp() || view == NewSubPbActivity.this.eZc.aWv()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.dSd.DF()) {
                                                            NewSubPbActivity.this.dSd.DG();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.dSd.ga(null);
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
                                                NewSubPbActivity.this.eZc.aEQ();
                                                if (tag instanceof String) {
                                                    String Dc = NewSubPbActivity.this.eZa.Dc();
                                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                        NewSubPbActivity.this.pq(Dc);
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
                                                NewSubPbActivity.this.eZc.aEQ();
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.br(view);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                NewSubPbActivity.this.showToast(d.j.network_not_available);
                                                return;
                                            }
                                        }
                                        NewSubPbActivity.this.eZc.aEQ();
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.eZc.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new ak("c11739").r("obj_locate", 1));
                                    NewSubPbActivity.this.eZc.aEQ();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.dSd.ga(null);
                                        if (NewSubPbActivity.this.eZo != null) {
                                            NewSubPbActivity.this.eZo.amM();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new ak("c11739").r("obj_locate", 2));
                                    NewSubPbActivity.this.eZc.aEQ();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.eZa.aWB() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.eZa.aWB().aQy());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.eZc.aWh();
                                NewSubPbActivity.this.eZc.aWi();
                                if (NewSubPbActivity.this.dSd != null) {
                                    NewSubPbActivity.this.dSd.DI();
                                    if (NewSubPbActivity.this.eZo != null) {
                                        NewSubPbActivity.this.eZo.amM();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.eZc.aWh();
                            NewSubPbActivity.this.eZc.aWi();
                            if (NewSubPbActivity.this.dSd != null) {
                                NewSubPbActivity.this.dSd.DH();
                                if (NewSubPbActivity.this.eZo != null) {
                                    NewSubPbActivity.this.eZo.amM();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.eZc.aWh();
                        NewSubPbActivity.this.eZc.aWi();
                        if (NewSubPbActivity.this.dSd != null) {
                            NewSubPbActivity.this.dSd.DJ();
                            if (NewSubPbActivity.this.eZo != null) {
                                NewSubPbActivity.this.eZo.amM();
                            }
                        }
                    }
                }
            }
        };
        this.eZd = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.eZc.aEQ();
                }
                NewSubPbActivity.this.dSd.DG();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.eZc.aWx();
            }
        };
        this.eLx = new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.eZa.aWB() != null) {
                    postData = NewSubPbActivity.this.eZa.aWB().aQy();
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
        this.auR = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                    NewSubPbActivity.this.eZc.b(NewSubPbActivity.this.eLx, NewSubPbActivity.this.eZa.isMarked());
                }
                return true;
            }
        };
        this.eZe = new TbRichTextView.g() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
            public void b(View view, String str) {
                NewSubPbActivity.this.j(null, str, "LINK_IMAGE");
            }
        };
        this.eZf = new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
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
                    m aWB = NewSubPbActivity.this.eZa.aWB();
                    TbRichText as = NewSubPbActivity.this.as(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (as != null && as.II() != null) {
                        tbRichTextData = as.II().get(NewSubPbActivity.this.eLu);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.IO().Ja()) {
                            String c = NewSubPbActivity.this.c(tbRichTextData);
                            arrayList2.add(c);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                            concurrentHashMap3.put(c, imageUrlData);
                            String str4 = null;
                            String str5 = null;
                            String str6 = null;
                            if (aWB == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (aWB.aQF() != null) {
                                    str4 = aWB.aQF().getName();
                                    str5 = aWB.aQF().getId();
                                }
                                if (aWB.Np() != null) {
                                    str6 = aWB.Np().getId();
                                }
                                str3 = str6;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.eZa.aWR() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.eZa.aWR();
                                z4 = NewSubPbActivity.this.eZa.aWT();
                                arrayList2 = NewSubPbActivity.this.eZa.aWS();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                z4 = z3;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(v.c(arrayList2, 0));
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z4, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.eLv = false;
                        String str7 = "";
                        TbRichText aEt = aWB.aQy().aEt();
                        int size = arrayList2.size();
                        int a2 = NewSubPbActivity.this.a(aEt, as, i, i, arrayList2, concurrentHashMap3);
                        int size2 = arrayList2.size();
                        if (size != size2) {
                            str7 = arrayList2.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (aWB == null) {
                            str2 = null;
                            z = false;
                        } else {
                            if (aWB.aQF() != null) {
                                str8 = aWB.aQF().getName();
                                str9 = aWB.aQF().getId();
                            }
                            if (aWB.Np() != null) {
                                str10 = aWB.Np().getId();
                            }
                            str2 = str10;
                            z = true;
                        }
                        if (NewSubPbActivity.this.eZa.aWR() != null) {
                            concurrentHashMap = NewSubPbActivity.this.eZa.aWR();
                            z2 = NewSubPbActivity.this.eZa.aWT();
                            arrayList = NewSubPbActivity.this.eZa.aWS();
                            i2 = a2 + NewSubPbActivity.this.eZa.getOffset();
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
        TbRichTextImageInfo IO;
        if (tbRichText == tbRichText2) {
            this.eLv = true;
        }
        if (tbRichText != null && tbRichText.II() != null) {
            int size = tbRichText.II().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.II().get(i6) != null && tbRichText.II().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.II().get(i6).IO().getWidth();
                    int height = tbRichText.II().get(i6).IO().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.II().get(i6).IO().Ja()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.II().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (IO = tbRichTextData.IO()) != null) {
                            String Jc = IO.Jc();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Jc;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.eLv) {
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
        TbRichTextImageInfo IO = tbRichTextData.IO();
        if (IO != null) {
            if (!StringUtils.isNull(IO.IZ())) {
                return IO.IZ();
            }
            if (IO.getHeight() * IO.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (IO.getHeight() * IO.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (IO.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * IO.getHeight())));
            } else {
                float width = IO.getWidth() / IO.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aN(IO.Jb()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText as(String str, int i) {
        if (this.eZa == null || this.eZa.aWB() == null || str == null || i < 0) {
            return null;
        }
        m aWB = this.eZa.aWB();
        TbRichText a2 = a(aWB.aQy(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(aWB.aQy(), str, i);
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
        TbRichText aEt = postData.aEt();
        if (aEt != null) {
            ArrayList<TbRichTextData> II = aEt.II();
            int size = II.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (II.get(i3) != null && II.get(i3).getType() == 8) {
                    i2++;
                    if (II.get(i3).IO().Jc().equals(str)) {
                        int width = II.get(i3).IO().getWidth();
                        int height = II.get(i3).IO().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.eLu = i3;
                        return aEt;
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
        long templateId = this.eZa.aWB().aQy().buC() != null ? this.eZa.aWB().aQy().buC().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && av.vI().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.eZa.aWB().aQF().getId(), this.eZa.aWB().aQF().getName(), this.eZa.aWB().Np().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, String str) {
        if (this.eZa.aWC()) {
            showToast(str);
        } else if (l.hy()) {
            if (i == 4) {
                this.eZc.lc(str + "(4)");
            } else {
                this.eZc.gD(d.j.no_data_text);
            }
        } else {
            this.eZc.gD(d.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.dSd = (f) new g().aW(getActivity());
        this.dSd.a(getPageContext());
        this.dSd.b(this.eZa);
        this.dSd.b(this.eZs);
        this.dSd.a(this.aDf);
        this.dSd.a(this.aDg);
        this.dSd.CI().bw(true);
        this.dSd.e(getPageContext());
        if (this.eZc != null) {
            this.eZc.f(this.dSd);
        }
        if (this.dSd != null && this.eZa != null) {
            this.dSd.a(this.eZa.aEB());
            this.dSd.DG();
        }
        this.eUy = this.dSd.Di().Da();
        this.eUy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (NewSubPbActivity.this.eZq != null) {
                    if (!NewSubPbActivity.this.eZq.bCg()) {
                        NewSubPbActivity.this.jH(false);
                    }
                    NewSubPbActivity.this.eZq.nj(false);
                }
            }
        });
    }

    public void aWe() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dSd.DG();
        } else if (!StringUtils.isNull(this.eZa.aWL())) {
            this.eZc.pO(this.eZa.aWL());
            if (this.eZc.aWl() && l.hy()) {
                this.eZc.agP();
            } else {
                this.eZc.aWo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(View view) {
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
                    this.eZc.bn(view);
                }
            } else if (booleanValue2) {
                this.eZc.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.eZc.aWu(), getPageContext().getPageActivity());
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
                        NewSubPbActivity.this.eZc.a(intValue, str2, sparseArray.get(d.g.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue() : false);
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
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.eZm);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.eZm);
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
        this.eZc.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.eZm;
        userMuteCheckCustomMessage.setTag(this.eZm);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.eZc.a(0, bVar.Al, bVar.grA, z);
            if (bVar.Al) {
                if (bVar.gry == 1) {
                    finish();
                } else if (bVar.gry == 2) {
                    this.eZa.pR(bVar.mPostId);
                    this.eZc.a(this.eZa.aWB(), this.eZa.aPZ(), this.eZa.aWR() != null);
                    if (this.eZa.aWM()) {
                        this.eZa.jM(false);
                        this.eZc.aWj();
                        this.eZa.Ff();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void pq(String str) {
        if (!StringUtils.isNull(str) && this.eZa != null) {
            String aSz = this.eZa.aSz();
            String Dc = this.eZa.Dc();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Dc + "&tid=" + aSz + "&pid=" + str, true)));
        }
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.eZa.isMarked() && postData.getId() != null && postData.getId().equals(this.eZa.aWJ())) {
                z = true;
            }
            MarkData h = this.eZa.h(postData);
            if (h != null) {
                this.eZc.aEQ();
                if (this.enp != null) {
                    this.enp.a(h);
                    if (!z) {
                        this.enp.nE();
                    } else {
                        this.enp.nD();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.eZa != null) {
            this.eZa.t(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dSd != null) {
            this.dSd.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cxA != null) {
            this.cxA.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.eZk = true;
        super.onPause();
        if (this.cxA != null) {
            this.cxA.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dvG);
        this.eZc.alD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eZk = false;
        super.onResume();
        if (this.cxA != null) {
            this.cxA.onResume(getPageContext());
        }
        registerListener(this.dvG);
        this.eZc.alE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cxA != null) {
            this.cxA.onStop(getPageContext());
        }
        this.dSd.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.eZr));
        this.eZa.cancelLoadData();
        this.eZa.destory();
        this.eZb.cancelLoadData();
        if (this.cxA != null) {
            this.cxA.onDestory(getPageContext());
        }
        this.eZc.aEQ();
        this.eZc.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.eLi);
        MessageManager.getInstance().unRegisterListener(this.eLj);
        MessageManager.getInstance().unRegisterListener(this.eLk);
        MessageManager.getInstance().unRegisterListener(this.eZm);
        this.eKJ = null;
        this.eKK = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eZc.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cxA;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aWp = this.eZc.aWp();
        if (aWp == null || (findViewWithTag = aWp.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean pE(String str) {
        Map<String, String> dY;
        if (!TextUtils.isEmpty(str) && (dY = av.dY(av.dZ(str))) != null) {
            this.eZn = true;
            String str2 = dY.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pE(com.baidu.adp.lib.util.k.aO(str2));
            }
            String str3 = dY.get(eYZ);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (pE(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            av.vI().c(getPageContext(), new String[]{str});
            this.eZn = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void U(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eZn = true;
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
        if (this.eZc != null) {
            return this.eZc.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Jn() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Jp() {
        if (this.aSn == null) {
            this.aSn = TbRichTextView.k(getPageContext().getPageActivity(), 8);
        }
        return this.aSn;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Jq() {
        if (this.aSr == null) {
            this.aSr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aRX */
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
        return this.aSr;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Jo() {
        if (this.aSm == null) {
            this.aSm = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: WS */
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
        return this.aSm;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Jr() {
        if (this.aSo == null) {
            this.aSo = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aEy */
                public View fI() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aQ */
                public void n(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aR */
                public View o(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aS */
                public View p(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.aSo;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Js() {
        if (this.aSp == null) {
            this.aSp = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aRZ */
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
        return this.aSp;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Jt() {
        this.aSq = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aRY */
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
        return this.aSq;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eZc.aWl() && l.hy()) {
            this.eZa.Ff();
        } else {
            this.eZc.aWo();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.eZm);
        userMuteAddAndDelCustomMessage.setTag(this.eZm);
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
            public boolean Fx() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Fy() {
                return com.baidu.tbadk.pageStayDuration.e.FD().FF();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.eZa != null) {
            if (this.eZa.aWB() != null && this.eZa.aWB().aQF() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eZa.aWB().aQF().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eZa.aSz(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean acA() {
        return this.eZk;
    }

    public boolean aWf() {
        if (this.eZa != null) {
            return this.eZa.aWf();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eZc.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eKJ.getPageActivity());
        if (am.isEmpty(str)) {
            aVar.cS(this.eKJ.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.cS(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.eZc.showLoadingDialog();
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
        aVar.b(this.eKJ).th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fZ(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eKJ.getPageActivity());
        aVar.cS(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eKJ).th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cS(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.eKJ).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.eKJ.getPageActivity(), 2, true, 4);
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
        aVar.b(this.eKJ).th();
    }

    public String getThreadId() {
        if (this.eZa != null) {
            return this.eZa.aSz();
        }
        return null;
    }

    public String getPostId() {
        if (this.eZa != null) {
            return this.eZa.Dc();
        }
        return null;
    }

    public int aPZ() {
        if (this.eZa != null) {
            return this.eZa.aPZ();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eZp) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eZp) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void jH(boolean z) {
        if (this.eUy != null && this.eUy.getText() != null) {
            int selectionEnd = this.eUy.getSelectionEnd();
            SpannableStringBuilder b = this.eZq.b(this.eUy.getText());
            if (b != null) {
                this.eZq.nj(true);
                this.eUy.setText(b);
                if (z && this.eZq.bCe() >= 0) {
                    this.eUy.requestFocus();
                    this.eUy.setSelection(this.eZq.bCe());
                } else {
                    this.eUy.setSelection(selectionEnd);
                }
                this.eZq.ni(this.eZq.bCe() >= 0);
            }
        }
    }
}
