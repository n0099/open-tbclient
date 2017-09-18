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
    private static final String eVa = com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String eWs = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aRb;
    private com.baidu.adp.lib.e.b<TextView> aRc;
    private com.baidu.adp.lib.e.b<View> aRd;
    private com.baidu.adp.lib.e.b<View> aRe;
    private com.baidu.adp.lib.e.b<LinearLayout> aRf;
    private com.baidu.adp.lib.e.b<GifView> aRg;
    private View.OnLongClickListener avy;
    private View.OnClickListener cUW;
    private VoiceManager cpV;
    private com.baidu.tbadk.editortools.pb.e dOn;
    private com.baidu.adp.base.e eIM;
    private com.baidu.tbadk.core.view.c eIN;
    private b.InterfaceC0046b eJw;
    private com.baidu.adp.base.d eWA;
    private BdUniqueId eWF;
    private b eWH;
    private SubPbModel eWt;
    private ForumManageModel eWu;
    private c eWv;
    private AbsListView.OnScrollListener eWw;
    private TbRichTextView.f eWx;
    private TbRichTextView.e eWy;
    private SubPbModel.a eWz;
    private com.baidu.tbadk.baseEditMark.a ejK;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int eJt = 0;
    private a.InterfaceC0041a eJo = null;
    private a eWB = null;
    private a eWC = null;
    private boolean eWD = false;
    private boolean eWE = false;
    private boolean eWG = false;
    private boolean eWI = false;
    private com.baidu.tbadk.editortools.pb.b aDu = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.b
        public void Ds() {
            NewSubPbActivity.this.eWv.aVg();
        }
    };
    private NewWriteModel.d eWJ = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.dOn != null && NewSubPbActivity.this.dOn.CV() != null) {
                NewSubPbActivity.this.dOn.CV().hide();
                if (NewSubPbActivity.this.eWt.aVC()) {
                    TiebaStatic.log(new ak("c10367").ad("post_id", NewSubPbActivity.this.eWt.Dq()));
                }
            }
            NewSubPbActivity.this.eWv.aVh();
        }
    };
    private CustomMessageListener eJi = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eWF) {
                NewSubPbActivity.this.eWv.Sb();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eIN.c(NewSubPbActivity.this.eIM.getResources().getString(d.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.eIM.getResources().getString(d.l.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.ga(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.aQV();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (am.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.eIM.getResources().getString(d.l.mute_fail);
                    }
                    NewSubPbActivity.this.eIN.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eJj = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eWF) {
                NewSubPbActivity.this.eWv.Sb();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eIN.c(NewSubPbActivity.this.eIM.getResources().getString(d.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (am.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.eIM.getResources().getString(d.l.un_mute_fail);
                }
                NewSubPbActivity.this.eIN.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eJk = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eWF) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.eWv.Sb();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.gvU;
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
                    NewSubPbActivity.this.eWv.a(sparseArray, z);
                }
            }
        }
    };
    boolean eJu = false;
    private CustomMessageListener drO = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a)) {
                b.a aVar = (b.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.b.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    public final TbRichTextView.d eVd = new TbRichTextView.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
        public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONIMAGE, new EmotionImageActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i, i2)));
        }
    };
    CustomMessageListener cqP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof j)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    j jVar = (j) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.eWt.aVv() != null && NewSubPbActivity.this.eWt.aVv().aPQ() != null && NewSubPbActivity.this.eWt.aVv().aPQ().getAuthor() != null && currentAccount.equals(NewSubPbActivity.this.eWt.aVv().aPQ().getAuthor().getUserId()) && NewSubPbActivity.this.eWt.aVv().aPQ().getAuthor().getPendantData() != null) {
                        NewSubPbActivity.this.eWt.aVv().aPQ().getAuthor().getPendantData().cA(jVar.pR());
                        NewSubPbActivity.this.eWt.aVv().aPQ().getAuthor().getPendantData().P(jVar.Cw());
                        NewSubPbActivity.this.eWv.a(NewSubPbActivity.this.eWt.aVv().aPQ(), NewSubPbActivity.this.eWt.aVv().azO(), NewSubPbActivity.this.eWt.aVv().nG(), NewSubPbActivity.this.eWt.aPt(), NewSubPbActivity.this.eWt.aVL() != null);
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
        if (this.eWI) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.eIM = getPageContext();
        this.eWE = true;
        aqj();
        aUT();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.eWt.aUV()) {
            this.eWH = new b(this, getListView(), this.eWv.ahp());
            this.eWH.aUO();
            this.eWH.a(new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
                private boolean eWM = false;

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void aUQ() {
                    NewSubPbActivity.this.eWv.jZ(false);
                    this.eWM = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void aUR() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public boolean aUS() {
                    if (!this.eWM) {
                        return NewSubPbActivity.this.eWv.aUY() != null && NewSubPbActivity.this.eWv.aUY().getTop() == 0;
                    }
                    this.eWM = false;
                    return false;
                }
            });
            this.eWv.e(this.eWH);
            this.eWv.jZ(true);
        }
        this.eIN = new com.baidu.tbadk.core.view.c();
        this.eIN.akG = 1000L;
        registerListener(this.eJk);
        registerListener(this.eJi);
        registerListener(this.eJj);
        this.eWF = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eWF;
        userMuteAddAndDelCustomMessage.setTag(this.eWF);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eWF;
        userMuteCheckCustomMessage.setTag(this.eWF);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.eWv = new c(this, this.cUW);
        this.eWv.a(this.eWt);
        addContentView(this.eWv.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.eWv.setOnScrollListener(this.eWw);
        this.eWv.a(this);
        this.eWv.setOnLinkImageClickListener(this.eWx);
        this.eWv.setOnImageClickListener(this.eWy);
        this.eWv.iT(true);
        this.eWv.setOnLongClickListener(this.avy);
        this.eWv.b(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.eWt != null) {
                    NewSubPbActivity.this.eWt.Fu();
                }
            }
        });
        this.eWv.a(this.eWB);
        this.eWv.b(this.eWC);
        if (this.eWt != null && this.eWt.aUV() && !this.eWt.aVK()) {
            this.eWv.aVm().setVisibility(8);
        } else {
            this.eWv.aVm().setVisibility(0);
        }
        if (this.eWt != null && !this.eWt.aUV()) {
            this.eWv.setIsFromPb(false);
        }
    }

    private boolean w(Bundle bundle) {
        if (bundle != null) {
            this.eWI = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eWI = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eWI;
    }

    public void initData(Bundle bundle) {
        this.eWt = new SubPbModel(getPageContext());
        this.eWt.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.eWv.n(postData);
                NewSubPbActivity.this.eWv.a((BdListView.e) null);
            }
        });
        this.eWu = new ForumManageModel(this);
        this.eWu.setLoadDataCallBack(this.eWA);
        this.cpV = new VoiceManager();
        this.cpV.onCreate(getPageContext());
        this.ejK = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.ejK != null) {
            this.ejK.a(this.eJo);
        }
        if (bundle != null) {
            this.eWt.initWithBundle(bundle);
        } else {
            this.eWt.initWithIntent(getIntent());
        }
        this.eWt.a(this.eWz);
        if (this.eWt.aUV()) {
            this.eWt.Fu();
        } else {
            this.eWt.aVA();
        }
    }

    public void aUT() {
        this.eWz = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, m mVar) {
                if (NewSubPbActivity.this.eWv != null) {
                    NewSubPbActivity.this.eWv.aVh();
                }
                if (NewSubPbActivity.this.eWH != null && NewSubPbActivity.this.eWH.aUP()) {
                    NewSubPbActivity.this.eWH.pN(d.e.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.R(i, str);
                    return;
                }
                NewSubPbActivity.this.eWv.hideNoDataView();
                if (mVar != null) {
                    if (mVar.aPQ() != null || NewSubPbActivity.this.eWt != null) {
                        mVar.aPQ().a(NewSubPbActivity.this.eWt.aVJ());
                    }
                    if (NewSubPbActivity.this.eWv != null) {
                        NewSubPbActivity.this.eWv.a(mVar, NewSubPbActivity.this.eWt.aPt(), NewSubPbActivity.this.eWt.aVL() != null);
                        if (NewSubPbActivity.this.eWE) {
                            NewSubPbActivity.this.aUU();
                            NewSubPbActivity.this.eWE = false;
                        }
                    }
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setData(mVar);
                    if (NewSubPbActivity.this.dOn != null) {
                        NewSubPbActivity.this.dOn.a(mVar.aDx());
                    }
                    eVar.setType(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                }
            }
        };
        this.eJo = new a.InterfaceC0041a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0041a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.ejK != null) {
                        NewSubPbActivity.this.ejK.ac(z2);
                    }
                    MarkData nJ = NewSubPbActivity.this.ejK.nJ();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(nJ);
                        if (NewSubPbActivity.this.ejK != null) {
                            if (nJ != null) {
                                NewSubPbActivity.this.eWt.ke(true);
                                NewSubPbActivity.this.eWt.pF(NewSubPbActivity.this.eWt.Dq());
                                NewSubPbActivity.this.showToast(d.l.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.add_mark));
                            }
                            if (NewSubPbActivity.this.eWv != null) {
                                NewSubPbActivity.this.eWv.kb(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.eWt.ke(false);
                        NewSubPbActivity.this.eWt.pF(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.remove_mark));
                        if (NewSubPbActivity.this.eWv != null) {
                            NewSubPbActivity.this.eWv.kb(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.update_mark_failed));
            }
        };
        this.eWB = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.eWt.aVv() != null && NewSubPbActivity.this.eWt.aVv().MR() != null && NewSubPbActivity.this.eWt.aVv().MR().getAuthor() != null) {
                    str = String.valueOf(NewSubPbActivity.this.eWt.aVv().MR().getAuthor().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.eWt.aVv().aPX().getId(), NewSubPbActivity.this.eWt.aVv().aPX().getName(), NewSubPbActivity.this.eWt.aVv().MR().getId(), str, str2, str3)));
            }
        };
        this.eWC = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void f(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.eWu.btl() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.eWt != null && NewSubPbActivity.this.eWt.aVv() != null && NewSubPbActivity.this.eWt.aVv().aPX() != null && NewSubPbActivity.this.eWt.aVv().MR() != null) {
                            NewSubPbActivity.this.eWu.a(NewSubPbActivity.this.eWt.aVv().aPX().getId(), NewSubPbActivity.this.eWt.aVv().aPX().getName(), NewSubPbActivity.this.eWt.aVv().MR().getId(), valueOf, g2, g, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.l.login_to_use), true, 11017)));
            }
        };
        this.eWA = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.eWv.a(NewSubPbActivity.this.eWu.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.eWu.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.cQT || bVar.eXA <= 0 || bVar.gls == 1) {
                            z = true;
                        } else {
                            com.baidu.tieba.c.a.a(NewSubPbActivity.this.getPageContext(), 3, 1);
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.eWv.a(1, dVar.Ai, dVar.glu, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void aqj() {
        registerListener(this.cqP);
        this.cUW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.eWv != null) {
                    if (view == NewSubPbActivity.this.eWv.aVs()) {
                        NewSubPbActivity.this.eWv.aDM();
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
                    } else if (view != NewSubPbActivity.this.eWv.aVj()) {
                        if (view != NewSubPbActivity.this.eWv.aVl()) {
                            if (view != NewSubPbActivity.this.eWv.aVk()) {
                                if (view == NewSubPbActivity.this.eWv.aVf()) {
                                    NewSubPbActivity.this.eWv.aDM();
                                    if (NewSubPbActivity.this.eWt.Fu()) {
                                        NewSubPbActivity.this.eWv.aVd();
                                    }
                                } else if (view == NewSubPbActivity.this.eWv.aVm() || view == NewSubPbActivity.this.eWv.aVn() || view == NewSubPbActivity.this.eWv.aVp()) {
                                    if (NewSubPbActivity.this.eWG) {
                                        NewSubPbActivity.this.eWG = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.eWt.getThreadID(), NewSubPbActivity.this.eWt.Dq(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.eWt.aVO())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.eWt.aVO());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                } else if (NewSubPbActivity.this.eWv.aVq() == null || view != NewSubPbActivity.this.eWv.aVq().aSk()) {
                                    if (NewSubPbActivity.this.eWv.aVq() == null || view != NewSubPbActivity.this.eWv.aVq().aSp()) {
                                        if (NewSubPbActivity.this.eWv.aVq() == null || view != NewSubPbActivity.this.eWv.aVq().aSn()) {
                                            if (NewSubPbActivity.this.eWv.aVq() == null || view != NewSubPbActivity.this.eWv.aVq().aSl()) {
                                                if (NewSubPbActivity.this.eWv.aVq() == null || view != NewSubPbActivity.this.eWv.aVq().aSm()) {
                                                    if ((view == NewSubPbActivity.this.eWv.aVi() || view == NewSubPbActivity.this.eWv.aVp()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                        if (NewSubPbActivity.this.dOn.DS()) {
                                                            NewSubPbActivity.this.dOn.DT();
                                                            return;
                                                        } else {
                                                            NewSubPbActivity.this.dOn.gb(null);
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
                                                NewSubPbActivity.this.eWv.aDM();
                                                if (tag instanceof String) {
                                                    String Dq = NewSubPbActivity.this.eWt.Dq();
                                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                        NewSubPbActivity.this.pi(Dq);
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
                                                NewSubPbActivity.this.eWv.aDM();
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
                                        NewSubPbActivity.this.eWv.aDM();
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null) {
                                            NewSubPbActivity.this.eWv.a(((Integer) sparseArray2.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.h.tag_del_post_id), ((Integer) sparseArray2.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.h.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(new ak("c11739").r("obj_locate", 1));
                                    NewSubPbActivity.this.eWv.aDM();
                                    if (NewSubPbActivity.this.checkUpIsLogin()) {
                                        NewSubPbActivity.this.dOn.gb(null);
                                        if (NewSubPbActivity.this.eWH != null) {
                                            NewSubPbActivity.this.eWH.aUN();
                                        }
                                    }
                                } else {
                                    TiebaStatic.log(new ak("c11739").r("obj_locate", 2));
                                    NewSubPbActivity.this.eWv.aDM();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.eWt.aVv() != null) {
                                        NewSubPbActivity.this.h(NewSubPbActivity.this.eWt.aVv().aPQ());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.eWv.aVa();
                                NewSubPbActivity.this.eWv.aVb();
                                if (NewSubPbActivity.this.dOn != null) {
                                    NewSubPbActivity.this.dOn.DV();
                                    if (NewSubPbActivity.this.eWH != null) {
                                        NewSubPbActivity.this.eWH.aUN();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.eWv.aVa();
                            NewSubPbActivity.this.eWv.aVb();
                            if (NewSubPbActivity.this.dOn != null) {
                                NewSubPbActivity.this.dOn.DU();
                                if (NewSubPbActivity.this.eWH != null) {
                                    NewSubPbActivity.this.eWH.aUN();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.eWv.aVa();
                        NewSubPbActivity.this.eWv.aVb();
                        if (NewSubPbActivity.this.dOn != null) {
                            NewSubPbActivity.this.dOn.DW();
                            if (NewSubPbActivity.this.eWH != null) {
                                NewSubPbActivity.this.eWH.aUN();
                            }
                        }
                    }
                }
            }
        };
        this.eWw = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.eWv.aDM();
                }
                NewSubPbActivity.this.dOn.DT();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.eWv.aVr();
            }
        };
        this.eJw = new b.InterfaceC0046b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.eWt.aVv() != null) {
                    postData = NewSubPbActivity.this.eWt.aVv().aPQ();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.bZ(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.h(postData);
                    }
                }
            }
        };
        this.avy = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
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
                    NewSubPbActivity.this.eWv.b(NewSubPbActivity.this.eJw, NewSubPbActivity.this.eWt.isMarked());
                }
                return true;
            }
        };
        this.eWx = new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void b(View view, String str) {
                NewSubPbActivity.this.j(null, str, "LINK_IMAGE");
            }
        };
        this.eWy = new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                    m aVv = NewSubPbActivity.this.eWt.aVv();
                    TbRichText an = NewSubPbActivity.this.an(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (an != null && an.Iv() != null) {
                        tbRichTextData = an.Iv().get(NewSubPbActivity.this.eJt);
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
                            if (aVv == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (aVv.aPX() != null) {
                                    str4 = aVv.aPX().getName();
                                    str5 = aVv.aPX().getId();
                                }
                                if (aVv.MR() != null) {
                                    str6 = aVv.MR().getId();
                                }
                                str3 = str6;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.eWt.aVL() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.eWt.aVL();
                                z4 = NewSubPbActivity.this.eWt.aVN();
                                arrayList2 = NewSubPbActivity.this.eWt.aVM();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                arrayList2 = arrayList3;
                                z4 = z3;
                            }
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str4, str5, str3, z4, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.eJu = false;
                        String str7 = "";
                        TbRichText aDr = aVv.aPQ().aDr();
                        int size = arrayList3.size();
                        int a2 = NewSubPbActivity.this.a(aDr, an, i, i, arrayList3, concurrentHashMap3);
                        int size2 = arrayList3.size();
                        if (size != size2) {
                            str7 = arrayList3.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (aVv == null) {
                            str2 = null;
                            z = false;
                        } else {
                            if (aVv.aPX() != null) {
                                str8 = aVv.aPX().getName();
                                str9 = aVv.aPX().getId();
                            }
                            if (aVv.MR() != null) {
                                str10 = aVv.MR().getId();
                            }
                            str2 = str10;
                            z = true;
                        }
                        if (NewSubPbActivity.this.eWt.aVL() != null) {
                            concurrentHashMap = NewSubPbActivity.this.eWt.aVL();
                            z2 = NewSubPbActivity.this.eWt.aVN();
                            arrayList = NewSubPbActivity.this.eWt.aVM();
                            a2 += NewSubPbActivity.this.eWt.getOffset();
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
            this.eJu = true;
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
                        if (!this.eJu) {
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
        if (this.eWt == null || this.eWt.aVv() == null || str == null || i < 0) {
            return null;
        }
        m aVv = this.eWt.aVv();
        TbRichText a2 = a(aVv.aPQ(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(aVv.aPQ(), str, i);
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
        TbRichText aDr = postData.aDr();
        if (aDr != null) {
            ArrayList<TbRichTextData> Iv = aDr.Iv();
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
                        this.eJt = i3;
                        return aDr;
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
        long templateId = this.eWt.aVv().aPQ().bsH() != null ? this.eWt.aVv().aPQ().bsH().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && au.wd().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.eWt.aVv().aPX().getId(), this.eWt.aVv().aPX().getName(), this.eWt.aVv().MR().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, String str) {
        if (this.eWt.aVw()) {
            showToast(str);
        } else if (k.hz()) {
            if (i == 4) {
                this.eWv.kL(str + "(4)");
            } else {
                this.eWv.gm(d.l.no_data_text);
            }
        } else {
            this.eWv.gm(d.l.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.dOn = (com.baidu.tbadk.editortools.pb.e) new f().aX(getActivity());
        this.dOn.a(getPageContext());
        this.dOn.b(this.eWt);
        this.dOn.b(this.eWJ);
        this.dOn.a(this.aDu);
        this.dOn.CV().bD(true);
        this.dOn.g(getPageContext());
        if (this.eWv != null) {
            this.eWv.f(this.dOn);
        }
        if (this.dOn != null && this.eWt != null) {
            this.dOn.a(this.eWt.aDx());
            this.dOn.DT();
        }
    }

    public void aUU() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dOn.DT();
        } else if (!StringUtils.isNull(this.eWt.aVF())) {
            this.eWv.pB(this.eWt.aVF());
            if (this.eWv.aVe() && k.hz()) {
                this.eWv.afg();
            } else {
                this.eWv.aVh();
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
                    this.eWv.bn(view);
                }
            } else if (booleanValue2) {
                this.eWv.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
            }
            g.a(this.eWv.aVo(), getPageContext().getPageActivity());
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
        bVar.a(strArr, new b.InterfaceC0046b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                switch (i) {
                    case 0:
                        String str2 = "";
                        int intValue = sparseArray.get(d.h.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue() : 0;
                        if (sparseArray.get(d.h.tag_del_post_id) instanceof String) {
                            str2 = (String) sparseArray.get(d.h.tag_del_post_id);
                        }
                        NewSubPbActivity.this.eWv.a(intValue, str2, sparseArray.get(d.h.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.h.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue() : false);
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
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.eWF);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.eWF);
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
        this.eWv.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.eWF;
        userMuteCheckCustomMessage.setTag(this.eWF);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.eWv.a(0, bVar.Ai, bVar.glu, z);
            if (bVar.Ai) {
                if (bVar.gls == 1) {
                    finish();
                } else if (bVar.gls == 2) {
                    this.eWt.pE(bVar.mPostId);
                    this.eWv.a(this.eWt.aVv(), this.eWt.aPt(), this.eWt.aVL() != null);
                    if (this.eWt.aVG()) {
                        this.eWt.kf(false);
                        this.eWv.aVc();
                        this.eWt.Fu();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void pi(String str) {
        if (!StringUtils.isNull(str) && this.eWt != null) {
            String threadID = this.eWt.getThreadID();
            String Dq = this.eWt.Dq();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Dq + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void h(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.eWt.isMarked() && postData.getId() != null && postData.getId().equals(this.eWt.aVD())) {
                z = true;
            }
            MarkData j = this.eWt.j(postData);
            if (j != null) {
                this.eWv.aDM();
                if (this.ejK != null) {
                    this.ejK.a(j);
                    if (!z) {
                        this.ejK.nI();
                    } else {
                        this.ejK.nH();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.eWt != null) {
            this.eWt.t(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dOn != null) {
            this.dOn.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cpV != null) {
            this.cpV.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.eWD = true;
        super.onPause();
        if (this.cpV != null) {
            this.cpV.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.drO);
        this.eWv.ajq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eWD = false;
        super.onResume();
        if (this.cpV != null) {
            this.cpV.onResume(getPageContext());
        }
        registerListener(this.drO);
        this.eWv.ajr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cpV != null) {
            this.cpV.onStop(getPageContext());
        }
        this.dOn.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eWt.cancelLoadData();
        this.eWt.destory();
        this.eWu.cancelLoadData();
        if (this.cpV != null) {
            this.cpV.onDestory(getPageContext());
        }
        this.eWv.aDM();
        this.eWv.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.eJi);
        MessageManager.getInstance().unRegisterListener(this.eJj);
        MessageManager.getInstance().unRegisterListener(this.eJk);
        MessageManager.getInstance().unRegisterListener(this.eWF);
        this.eIM = null;
        this.eIN = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eWv.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cpV;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aVi = this.eWv.aVi();
        if (aVi == null || (findViewWithTag = aVi.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean pw(String str) {
        Map<String, String> ea;
        if (!TextUtils.isEmpty(str) && (ea = au.ea(au.eb(str))) != null) {
            this.eWG = true;
            String str2 = ea.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pw(com.baidu.adp.lib.util.j.aO(str2));
            }
            String str3 = ea.get(eWs);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (pw(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            au.wd().c(getPageContext(), new String[]{str});
            this.eWG = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eWG = true;
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
        if (this.eWv != null) {
            return this.eWv.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int IZ() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> Jb() {
        if (this.aRc == null) {
            this.aRc = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aRc;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> Jc() {
        if (this.aRg == null) {
            this.aRg = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aRa */
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
        return this.aRg;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> Ja() {
        if (this.aRb == null) {
            this.aRb = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: UI */
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
        return this.aRb;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Jd() {
        if (this.aRe == null) {
            this.aRe = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aou */
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
        return this.aRe;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> Je() {
        if (this.aRf == null) {
            this.aRf = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aRb */
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
        return this.aRf;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Jf() {
        if (this.aRd == null) {
            this.aRd = com.baidu.tieba.graffiti.c.p(getPageContext().getPageActivity(), 8);
        }
        return this.aRd;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eWv.aVe() && k.hz()) {
            this.eWt.Fu();
        } else {
            this.eWv.aVh();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.eWF);
        userMuteAddAndDelCustomMessage.setTag(this.eWF);
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
        if (pageStayDurationItem != null && this.eWt != null) {
            if (this.eWt.aVv() != null && this.eWt.aVv().aPX() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eWt.aVv().aPX().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eWt.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aaI() {
        return this.eWD;
    }

    public boolean aUV() {
        if (this.eWt != null) {
            return this.eWt.aUV();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eWv.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIM.getPageActivity());
        if (am.isEmpty(str)) {
            aVar.cM(this.eIM.getResources().getString(d.l.block_mute_message_alert, str2));
        } else {
            aVar.cM(str);
        }
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.eWv.showLoadingDialog();
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
        aVar.b(this.eIM).to();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIM.getPageActivity());
        aVar.cM(str);
        aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eIM).to();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQV() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cM(getResources().getString(d.l.mute_is_super_member_function));
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.eIM).showToast(d.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.eIM.getPageActivity(), 2, true, 4);
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
        aVar.b(this.eIM).to();
    }

    public String getThreadId() {
        if (this.eWt != null) {
            return this.eWt.getThreadID();
        }
        return null;
    }

    public String getPostId() {
        if (this.eWt != null) {
            return this.eWt.Dq();
        }
        return null;
    }

    public int aPt() {
        if (this.eWt != null) {
            return this.eWt.aPt();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eWI) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eWI) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }
}
