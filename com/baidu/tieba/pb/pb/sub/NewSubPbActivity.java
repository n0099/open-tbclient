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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.at;
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
import com.baidu.tieba.pb.data.n;
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
    private static final String eSx = com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String eTK = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aQg;
    private com.baidu.adp.lib.e.b<TextView> aQh;
    private com.baidu.adp.lib.e.b<View> aQi;
    private com.baidu.adp.lib.e.b<View> aQj;
    private com.baidu.adp.lib.e.b<LinearLayout> aQk;
    private com.baidu.adp.lib.e.b<GifView> aQl;
    private View.OnLongClickListener auW;
    private View.OnClickListener cKt;
    private VoiceManager chP;
    private com.baidu.tbadk.editortools.pb.e dDz;
    private com.baidu.tbadk.baseEditMark.a dYU;
    private com.baidu.adp.base.e eGt;
    private com.baidu.tbadk.core.view.c eGu;
    private b.InterfaceC0043b eHg;
    private SubPbModel eTL;
    private ForumManageModel eTM;
    private c eTN;
    private AbsListView.OnScrollListener eTO;
    private TbRichTextView.f eTP;
    private TbRichTextView.e eTQ;
    private SubPbModel.a eTR;
    private com.baidu.adp.base.d eTS;
    private BdUniqueId eTX;
    private b eTZ;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int eHd = 0;
    private a.InterfaceC0038a eGY = null;
    private a eTT = null;
    private a eTU = null;
    private boolean eTV = false;
    private boolean eTW = false;
    private boolean eTY = false;
    private boolean eUa = false;
    private com.baidu.tbadk.editortools.pb.b aCO = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.b
        public void Dp() {
            NewSubPbActivity.this.eTN.aUW();
        }
    };
    private NewWriteModel.d eUb = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.dDz != null && NewSubPbActivity.this.dDz.CS() != null) {
                NewSubPbActivity.this.dDz.CS().hide();
                if (NewSubPbActivity.this.eTL.aVq()) {
                    TiebaStatic.log(new aj("c10367").aa("post_id", NewSubPbActivity.this.eTL.Dn()));
                }
            }
            NewSubPbActivity.this.eTN.aUX();
        }
    };
    private CustomMessageListener eGR = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eTX) {
                NewSubPbActivity.this.eTN.QT();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eGu.c(NewSubPbActivity.this.eGt.getResources().getString(d.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.eGt.getResources().getString(d.l.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.fW(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.aQJ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (al.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.eGt.getResources().getString(d.l.mute_fail);
                    }
                    NewSubPbActivity.this.eGu.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eGS = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eTX) {
                NewSubPbActivity.this.eTN.QT();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eGu.c(NewSubPbActivity.this.eGt.getResources().getString(d.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (al.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.eGt.getResources().getString(d.l.un_mute_fail);
                }
                NewSubPbActivity.this.eGu.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eGT = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eTX) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.eTN.QT();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.gtw;
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
                    NewSubPbActivity.this.eTN.a(sparseArray, z);
                }
            }
        }
    };
    boolean eHe = false;
    private CustomMessageListener dgZ = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a)) {
                b.a aVar = (b.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.b.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    public final TbRichTextView.d eSA = new TbRichTextView.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
        public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONIMAGE, new EmotionImageActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i, i2)));
        }
    };
    CustomMessageListener ciK = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof j)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    j jVar = (j) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.eTL.aVj() != null && NewSubPbActivity.this.eTL.aVj().aPG() != null && NewSubPbActivity.this.eTL.aVj().aPG().getAuthor() != null && currentAccount.equals(NewSubPbActivity.this.eTL.aVj().aPG().getAuthor().getUserId()) && NewSubPbActivity.this.eTL.aVj().aPG().getAuthor().getPendantData() != null) {
                        NewSubPbActivity.this.eTL.aVj().aPG().getAuthor().getPendantData().cB(jVar.pL());
                        NewSubPbActivity.this.eTL.aVj().aPG().getAuthor().getPendantData().Q(jVar.Ct());
                        NewSubPbActivity.this.eTN.a(NewSubPbActivity.this.eTL.aVj().aPG(), NewSubPbActivity.this.eTL.aVj().axb(), NewSubPbActivity.this.eTL.aVj().nB(), NewSubPbActivity.this.eTL.aPj(), NewSubPbActivity.this.eTL.aVz() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        u(bundle);
        if (this.eUa) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.eGt = getPageContext();
        this.eTW = true;
        anC();
        aUJ();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.eTL.aUL()) {
            this.eTZ = new b(this, getListView(), this.eTN.afl());
            this.eTZ.aUE();
            this.eTZ.a(new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
                private boolean eUe = false;

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void aUG() {
                    NewSubPbActivity.this.eTN.jW(false);
                    this.eUe = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void aUH() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public boolean aUI() {
                    if (!this.eUe) {
                        return NewSubPbActivity.this.eTN.aUO() != null && NewSubPbActivity.this.eTN.aUO().getTop() == 0;
                    }
                    this.eUe = false;
                    return false;
                }
            });
            this.eTN.e(this.eTZ);
            this.eTN.jW(true);
        }
        this.eGu = new com.baidu.tbadk.core.view.c();
        this.eGu.ajS = 1000L;
        registerListener(this.eGT);
        registerListener(this.eGR);
        registerListener(this.eGS);
        this.eTX = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eTX;
        userMuteAddAndDelCustomMessage.setTag(this.eTX);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eTX;
        userMuteCheckCustomMessage.setTag(this.eTX);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.eTN = new c(this, this.cKt);
        this.eTN.a(this.eTL);
        addContentView(this.eTN.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.eTN.setOnScrollListener(this.eTO);
        this.eTN.a(this);
        this.eTN.setOnLinkImageClickListener(this.eTP);
        this.eTN.setOnImageClickListener(this.eTQ);
        this.eTN.iP(true);
        this.eTN.setOnLongClickListener(this.auW);
        this.eTN.f(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.eTL != null) {
                    NewSubPbActivity.this.eTL.Fo();
                }
            }
        });
        this.eTN.a(this.eTT);
        this.eTN.b(this.eTU);
        if (this.eTL != null && this.eTL.aUL() && !this.eTL.aVy()) {
            this.eTN.aVa().setVisibility(8);
        } else {
            this.eTN.aVa().setVisibility(0);
        }
        if (this.eTL != null && !this.eTL.aUL()) {
            this.eTN.setIsFromPb(false);
        }
    }

    private boolean u(Bundle bundle) {
        if (bundle != null) {
            this.eUa = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eUa = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eUa;
    }

    public void initData(Bundle bundle) {
        this.eTL = new SubPbModel(getPageContext());
        this.eTL.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.eTN.n(postData);
                NewSubPbActivity.this.eTN.a((BdListView.e) null);
            }
        });
        this.eTM = new ForumManageModel(this);
        this.eTM.setLoadDataCallBack(this.eTS);
        this.chP = new VoiceManager();
        this.chP.onCreate(getPageContext());
        this.dYU = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dYU != null) {
            this.dYU.a(this.eGY);
        }
        if (bundle != null) {
            this.eTL.initWithBundle(bundle);
        } else {
            this.eTL.initWithIntent(getIntent());
        }
        this.eTL.a(this.eTR);
        if (this.eTL.aUL()) {
            this.eTL.Fo();
        } else {
            this.eTL.aVo();
        }
    }

    public void aUJ() {
        this.eTR = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, n nVar) {
                if (NewSubPbActivity.this.eTN != null) {
                    NewSubPbActivity.this.eTN.aUX();
                }
                if (NewSubPbActivity.this.eTZ != null && NewSubPbActivity.this.eTZ.aUF()) {
                    NewSubPbActivity.this.eTZ.py(d.e.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.S(i, str);
                    return;
                }
                NewSubPbActivity.this.eTN.hideNoDataView();
                if (nVar != null) {
                    if (nVar.aPG() != null || NewSubPbActivity.this.eTL != null) {
                        nVar.aPG().a(NewSubPbActivity.this.eTL.aVx());
                    }
                    if (NewSubPbActivity.this.eTN != null) {
                        NewSubPbActivity.this.eTN.a(nVar, NewSubPbActivity.this.eTL.aPj(), NewSubPbActivity.this.eTL.aVz() != null);
                        if (NewSubPbActivity.this.eTW) {
                            NewSubPbActivity.this.aUK();
                            NewSubPbActivity.this.eTW = false;
                        }
                    }
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setData(nVar);
                    if (NewSubPbActivity.this.dDz != null) {
                        NewSubPbActivity.this.dDz.a(nVar.aAK());
                    }
                    eVar.setType(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                }
            }
        };
        this.eGY = new a.InterfaceC0038a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0038a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.dYU != null) {
                        NewSubPbActivity.this.dYU.ac(z2);
                    }
                    MarkData nE = NewSubPbActivity.this.dYU.nE();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(nE);
                        if (NewSubPbActivity.this.dYU != null) {
                            if (nE != null) {
                                NewSubPbActivity.this.eTL.jy(true);
                                NewSubPbActivity.this.eTL.pF(NewSubPbActivity.this.eTL.Dn());
                                NewSubPbActivity.this.showToast(d.l.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.add_mark));
                            }
                            if (NewSubPbActivity.this.eTN != null) {
                                NewSubPbActivity.this.eTN.jY(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.eTL.jy(false);
                        NewSubPbActivity.this.eTL.pF(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.remove_mark));
                        if (NewSubPbActivity.this.eTN != null) {
                            NewSubPbActivity.this.eTN.jY(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.update_mark_failed));
            }
        };
        this.eTT = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void g(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.eTL.aVj() != null && NewSubPbActivity.this.eTL.aVj().MA() != null && NewSubPbActivity.this.eTL.aVj().MA().getAuthor() != null) {
                    str = String.valueOf(NewSubPbActivity.this.eTL.aVj().MA().getAuthor().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.eTL.aVj().aPM().getId(), NewSubPbActivity.this.eTL.aVj().aPM().getName(), NewSubPbActivity.this.eTL.aVj().MA().getId(), str, str2, str3)));
            }
        };
        this.eTU = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void g(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.eTM.btd() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.eTL != null && NewSubPbActivity.this.eTL.aVj() != null && NewSubPbActivity.this.eTL.aVj().aPM() != null && NewSubPbActivity.this.eTL.aVj().MA() != null) {
                            NewSubPbActivity.this.eTM.a(NewSubPbActivity.this.eTL.aVj().aPM().getId(), NewSubPbActivity.this.eTL.aVj().aPM().getName(), NewSubPbActivity.this.eTL.aVj().MA().getId(), valueOf, g2, g, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.l.login_to_use), true, 11017)));
            }
        };
        this.eTS = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.adp.base.d
            public void g(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.eTN.a(NewSubPbActivity.this.eTM.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.eTM.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.cGs || bVar.eUP <= 0 || bVar.giT == 1) {
                            z = true;
                        } else {
                            com.baidu.tieba.c.a.a(NewSubPbActivity.this.getPageContext(), 3, 1);
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.eTN.a(1, dVar.AM, dVar.giV, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void anC() {
        registerListener(this.ciK);
        this.cKt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.eTN != null) {
                    if (view == NewSubPbActivity.this.eTN.aVg()) {
                        NewSubPbActivity.this.eTN.aAZ();
                        String str = view.getTag(d.h.tag_user_id) instanceof String ? (String) view.getTag(d.h.tag_user_id) : null;
                        String str2 = view.getTag(d.h.tag_user_name) instanceof String ? (String) view.getTag(d.h.tag_user_name) : null;
                        String str3 = view.getTag(d.h.tag_virtual_user_url) instanceof String ? (String) view.getTag(d.h.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                at.vV().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.eTN.aUZ()) {
                        if (view == NewSubPbActivity.this.eTN.aUV()) {
                            NewSubPbActivity.this.eTN.aAZ();
                            if (NewSubPbActivity.this.eTL.Fo()) {
                                NewSubPbActivity.this.eTN.aUT();
                            }
                        } else if (view == NewSubPbActivity.this.eTN.aVa() || view == NewSubPbActivity.this.eTN.aVb() || view == NewSubPbActivity.this.eTN.aVd()) {
                            if (NewSubPbActivity.this.eTY) {
                                NewSubPbActivity.this.eTY = false;
                                return;
                            }
                            PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.eTL.getThreadID(), NewSubPbActivity.this.eTL.Dn(), "");
                            if (!StringUtils.isNull(NewSubPbActivity.this.eTL.aVC())) {
                                createNormalCfg.setForumId(NewSubPbActivity.this.eTL.aVC());
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } else if (NewSubPbActivity.this.eTN.aVe() == null || view != NewSubPbActivity.this.eTN.aVe().aRU()) {
                            if (NewSubPbActivity.this.eTN.aVe() == null || view != NewSubPbActivity.this.eTN.aVe().aRZ()) {
                                if (NewSubPbActivity.this.eTN.aVe() == null || view != NewSubPbActivity.this.eTN.aVe().aRX()) {
                                    if (NewSubPbActivity.this.eTN.aVe() == null || view != NewSubPbActivity.this.eTN.aVe().aRV()) {
                                        if (NewSubPbActivity.this.eTN.aVe() == null || view != NewSubPbActivity.this.eTN.aVe().aRW()) {
                                            if ((view == NewSubPbActivity.this.eTN.aUY() || view == NewSubPbActivity.this.eTN.aVd()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                if (NewSubPbActivity.this.dDz.DP()) {
                                                    NewSubPbActivity.this.dDz.DQ();
                                                    return;
                                                } else {
                                                    NewSubPbActivity.this.dDz.fX(null);
                                                    return;
                                                }
                                            }
                                            return;
                                        }
                                        TiebaStatic.log(new aj("c11739").r("obj_locate", 4));
                                        if (!i.hh()) {
                                            NewSubPbActivity.this.showToast(d.l.network_not_available);
                                            return;
                                        }
                                        Object tag = view.getTag();
                                        NewSubPbActivity.this.eTN.aAZ();
                                        if (tag instanceof String) {
                                            String Dn = NewSubPbActivity.this.eTL.Dn();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.ph(Dn);
                                                return;
                                            }
                                            return;
                                        } else if (tag instanceof SparseArray) {
                                            SparseArray<Object> sparseArray = (SparseArray) tag;
                                            if ((sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue()) {
                                                sparseArray.put(d.h.tag_from, 0);
                                                NewSubPbActivity.this.d(sparseArray);
                                                return;
                                            }
                                            return;
                                        } else {
                                            return;
                                        }
                                    } else if (i.hh()) {
                                        NewSubPbActivity.this.eTN.aAZ();
                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                            NewSubPbActivity.this.bh(view);
                                            return;
                                        }
                                        return;
                                    } else {
                                        NewSubPbActivity.this.showToast(d.l.network_not_available);
                                        return;
                                    }
                                }
                                NewSubPbActivity.this.eTN.aAZ();
                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                if (sparseArray2 != null) {
                                    NewSubPbActivity.this.eTN.a(((Integer) sparseArray2.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.h.tag_del_post_id), ((Integer) sparseArray2.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.h.tag_del_post_is_self)).booleanValue());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(new aj("c11739").r("obj_locate", 1));
                            NewSubPbActivity.this.eTN.aAZ();
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.dDz.fX(null);
                                if (NewSubPbActivity.this.eTZ != null) {
                                    NewSubPbActivity.this.eTZ.aUD();
                                }
                            }
                        } else {
                            TiebaStatic.log(new aj("c11739").r("obj_locate", 2));
                            NewSubPbActivity.this.eTN.aAZ();
                            if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.eTL.aVj() != null) {
                                NewSubPbActivity.this.h(NewSubPbActivity.this.eTL.aVj().aPG());
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.eTN.aUQ();
                        NewSubPbActivity.this.eTN.aUR();
                        if (NewSubPbActivity.this.dDz != null) {
                            NewSubPbActivity.this.dDz.DR();
                            if (NewSubPbActivity.this.eTZ != null) {
                                NewSubPbActivity.this.eTZ.aUD();
                            }
                        }
                    }
                }
            }
        };
        this.eTO = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.eTN.aAZ();
                }
                NewSubPbActivity.this.dDz.DQ();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.eTN.aVf();
            }
        };
        this.eHg = new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.eTL.aVj() != null) {
                    postData = NewSubPbActivity.this.eTL.aVj().aPG();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.bO(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.h(postData);
                    }
                }
            }
        };
        this.auW = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
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
                    NewSubPbActivity.this.eTN.b(NewSubPbActivity.this.eHg, NewSubPbActivity.this.eTL.isMarked());
                }
                return true;
            }
        };
        this.eTP = new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void b(View view, String str) {
                NewSubPbActivity.this.j(null, str, "LINK_IMAGE");
            }
        };
        this.eTQ = new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                    n aVj = NewSubPbActivity.this.eTL.aVj();
                    TbRichText ao = NewSubPbActivity.this.ao(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (ao != null && ao.Ig() != null) {
                        tbRichTextData = ao.Ig().get(NewSubPbActivity.this.eHd);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList3 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.Im().Iz()) {
                            String c = NewSubPbActivity.this.c(tbRichTextData);
                            arrayList3.add(c);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                            concurrentHashMap3.put(c, imageUrlData);
                            String str4 = null;
                            String str5 = null;
                            String str6 = null;
                            if (aVj == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (aVj.aPM() != null) {
                                    str4 = aVj.aPM().getName();
                                    str5 = aVj.aPM().getId();
                                }
                                if (aVj.MA() != null) {
                                    str6 = aVj.MA().getId();
                                }
                                str3 = str6;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.eTL.aVz() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.eTL.aVz();
                                z4 = NewSubPbActivity.this.eTL.aVB();
                                arrayList2 = NewSubPbActivity.this.eTL.aVA();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                arrayList2 = arrayList3;
                                z4 = z3;
                            }
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str4, str5, str3, z4, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.eHe = false;
                        String str7 = "";
                        TbRichText aAE = aVj.aPG().aAE();
                        int size = arrayList3.size();
                        int a2 = NewSubPbActivity.this.a(aAE, ao, i, i, arrayList3, concurrentHashMap3);
                        int size2 = arrayList3.size();
                        if (size != size2) {
                            str7 = arrayList3.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (aVj == null) {
                            str2 = null;
                            z = false;
                        } else {
                            if (aVj.aPM() != null) {
                                str8 = aVj.aPM().getName();
                                str9 = aVj.aPM().getId();
                            }
                            if (aVj.MA() != null) {
                                str10 = aVj.MA().getId();
                            }
                            str2 = str10;
                            z = true;
                        }
                        if (NewSubPbActivity.this.eTL.aVz() != null) {
                            concurrentHashMap = NewSubPbActivity.this.eTL.aVz();
                            z2 = NewSubPbActivity.this.eTL.aVB();
                            arrayList = NewSubPbActivity.this.eTL.aVA();
                            a2 += NewSubPbActivity.this.eTL.getOffset();
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
        TbRichTextImageInfo Im;
        if (tbRichText == tbRichText2) {
            this.eHe = true;
        }
        if (tbRichText != null && tbRichText.Ig() != null) {
            int size = tbRichText.Ig().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Ig().get(i6) != null && tbRichText.Ig().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.Ig().get(i6).Im().getWidth();
                    int height = tbRichText.Ig().get(i6).Im().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Ig().get(i6).Im().Iz()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Ig().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (Im = tbRichTextData.Im()) != null) {
                            String IB = Im.IB();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = IB;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.eHe) {
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
        TbRichTextImageInfo Im = tbRichTextData.Im();
        if (Im != null) {
            if (!StringUtils.isNull(Im.Iy())) {
                return Im.Iy();
            }
            if (Im.getHeight() * Im.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Im.getHeight() * Im.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Im.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Im.getHeight())));
            } else {
                float width = Im.getWidth() / Im.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(al.aK(Im.IA()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText ao(String str, int i) {
        if (this.eTL == null || this.eTL.aVj() == null || str == null || i < 0) {
            return null;
        }
        n aVj = this.eTL.aVj();
        TbRichText a2 = a(aVj.aPG(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(aVj.aPG(), str, i);
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
        TbRichText aAE = postData.aAE();
        if (aAE != null) {
            ArrayList<TbRichTextData> Ig = aAE.Ig();
            int size = Ig.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Ig.get(i3) != null && Ig.get(i3).getType() == 8) {
                    i2++;
                    if (Ig.get(i3).Im().IB().equals(str)) {
                        int width = Ig.get(i3).Im().getWidth();
                        int height = Ig.get(i3).Im().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.eHd = i3;
                        return aAE;
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
        long templateId = this.eTL.aVj().aPG().bsz() != null ? this.eTL.aVj().aPG().bsz().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && at.vV().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.eTL.aVj().aPM().getId(), this.eTL.aVj().aPM().getName(), this.eTL.aVj().MA().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i, String str) {
        if (this.eTL.aVk()) {
            showToast(str);
        } else if (k.hy()) {
            if (i == 4) {
                this.eTN.pA(str + "(4)");
            } else {
                this.eTN.gh(d.l.no_data_text);
            }
        } else {
            this.eTN.gh(d.l.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.dDz = (com.baidu.tbadk.editortools.pb.e) new f().aQ(getActivity());
        this.dDz.a(getPageContext());
        this.dDz.b(this.eTL);
        this.dDz.b(this.eUb);
        this.dDz.a(this.aCO);
        this.dDz.CS().bE(true);
        this.dDz.g(getPageContext());
        if (this.eTN != null) {
            this.eTN.f(this.dDz);
        }
        if (this.dDz != null && this.eTL != null) {
            this.dDz.a(this.eTL.aAK());
            this.dDz.DQ();
        }
    }

    public void aUK() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dDz.DQ();
        } else if (!StringUtils.isNull(this.eTL.aVt())) {
            this.eTN.pB(this.eTL.aVt());
            if (this.eTN.aUU() && k.hy()) {
                this.eTN.adv();
            } else {
                this.eTN.aUX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bh(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(d.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(d.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(d.h.tag_from, 1);
                    d(sparseArray);
                } else {
                    this.eTN.bf(view);
                }
            } else if (booleanValue2) {
                this.eTN.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
            }
            g.a(this.eTN.aVc(), getPageContext().getPageActivity());
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
        bVar.cd(d.l.operation);
        bVar.a(strArr, new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                switch (i) {
                    case 0:
                        String str2 = "";
                        int intValue = sparseArray.get(d.h.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue() : 0;
                        if (sparseArray.get(d.h.tag_del_post_id) instanceof String) {
                            str2 = (String) sparseArray.get(d.h.tag_del_post_id);
                        }
                        NewSubPbActivity.this.eTN.a(intValue, str2, sparseArray.get(d.h.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.h.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue() : false);
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
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.eTX);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.eTX);
                        NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str6, str3);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext()).tk();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(d.h.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.h.tag_user_mute_mute_userid);
        }
        this.eTN.QS();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.eTX;
        userMuteCheckCustomMessage.setTag(this.eTX);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.eTN.a(0, bVar.AM, bVar.giV, z);
            if (bVar.AM) {
                if (bVar.giT == 1) {
                    finish();
                } else if (bVar.giT == 2) {
                    this.eTL.pE(bVar.mPostId);
                    this.eTN.a(this.eTL.aVj(), this.eTL.aPj(), this.eTL.aVz() != null);
                    if (this.eTL.aVu()) {
                        this.eTL.kb(false);
                        this.eTN.aUS();
                        this.eTL.Fo();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void ph(String str) {
        if (!StringUtils.isNull(str) && this.eTL != null) {
            String threadID = this.eTL.getThreadID();
            String Dn = this.eTL.Dn();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Dn + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void h(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.eTL.isMarked() && postData.getId() != null && postData.getId().equals(this.eTL.aVr())) {
                z = true;
            }
            MarkData j = this.eTL.j(postData);
            if (j != null) {
                this.eTN.aAZ();
                if (this.dYU != null) {
                    this.dYU.a(j);
                    if (!z) {
                        this.dYU.nD();
                    } else {
                        this.dYU.nC();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.eTL != null) {
            this.eTL.r(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dDz != null) {
            this.dDz.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.chP != null) {
            this.chP.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.eTV = true;
        super.onPause();
        if (this.chP != null) {
            this.chP.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dgZ);
        this.eTN.agW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eTV = false;
        super.onResume();
        if (this.chP != null) {
            this.chP.onResume(getPageContext());
        }
        registerListener(this.dgZ);
        this.eTN.agX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.chP != null) {
            this.chP.onStop(getPageContext());
        }
        this.dDz.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eTL.cancelLoadData();
        this.eTL.destory();
        this.eTM.cancelLoadData();
        if (this.chP != null) {
            this.chP.onDestory(getPageContext());
        }
        this.eTN.aAZ();
        this.eTN.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.eGR);
        MessageManager.getInstance().unRegisterListener(this.eGS);
        MessageManager.getInstance().unRegisterListener(this.eGT);
        MessageManager.getInstance().unRegisterListener(this.eTX);
        this.eGt = null;
        this.eGu = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eTN.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.chP;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aUY = this.eTN.aUY();
        if (aUY == null || (findViewWithTag = aUY.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean pv(String str) {
        Map<String, String> dY;
        if (!TextUtils.isEmpty(str) && (dY = at.dY(at.dZ(str))) != null) {
            this.eTY = true;
            String str2 = dY.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pv(com.baidu.adp.lib.util.j.aL(str2));
            }
            String str3 = dY.get(eTK);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (pv(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            at.vV().c(getPageContext(), new String[]{str});
            this.eTY = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eTY = true;
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
        if (this.eTN != null) {
            return this.eTN.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int IK() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> IM() {
        if (this.aQh == null) {
            this.aQh = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aQh;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> IN() {
        if (this.aQl == null) {
            this.aQl = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aQO */
                public GifView fI() {
                    return new GifView(NewSubPbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void o(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView p(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView q(GifView gifView) {
                    return gifView;
                }
            }, 20, 0);
        }
        return this.aQl;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> IL() {
        if (this.aQg == null) {
            this.aQg = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: Tn */
                public ImageView fI() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean oT = h.oN().oT();
                    foreDrawableImageView.setDefaultBg(ai.getDrawable(d.e.common_color_10220));
                    if (oT) {
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
                /* renamed from: g */
                public void o(ImageView imageView) {
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
                /* renamed from: f */
                public ImageView p(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (h.oN().oT()) {
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
                /* renamed from: h */
                public ImageView q(ImageView imageView) {
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
        return this.aQg;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IO() {
        if (this.aQj == null) {
            this.aQj = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: alO */
                public View fI() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.f.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: ar */
                public void o(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: as */
                public View p(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: at */
                public View q(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.aQj;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> IP() {
        if (this.aQk == null) {
            this.aQk = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aQP */
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
                public void o(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public LinearLayout p(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public LinearLayout q(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.aQk;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IQ() {
        if (this.aQi == null) {
            this.aQi = com.baidu.tieba.graffiti.c.p(getPageContext().getPageActivity(), 8);
        }
        return this.aQi;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eTN.aUU() && k.hy()) {
            this.eTL.Fo();
        } else {
            this.eTN.aUX();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.eTX);
        userMuteAddAndDelCustomMessage.setTag(this.eTX);
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
            public boolean FG() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int FH() {
                return com.baidu.tbadk.pageStayDuration.e.FM().FO();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.eTL != null) {
            if (this.eTL.aVj() != null && this.eTL.aVj().aPM() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eTL.aVj().aPM().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eTL.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean YX() {
        return this.eTV;
    }

    public boolean aUL() {
        if (this.eTL != null) {
            return this.eTL.aUL();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eTN.QS();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGt.getPageActivity());
        if (al.isEmpty(str)) {
            aVar.cN(this.eGt.getResources().getString(d.l.block_mute_message_alert, str2));
        } else {
            aVar.cN(str);
        }
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.eTN.QS();
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
        aVar.b(this.eGt).th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGt.getPageActivity());
        aVar.cN(str);
        aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eGt).th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQJ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cN(getResources().getString(d.l.mute_is_super_member_function));
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.eGt).showToast(d.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.eGt.getPageActivity(), 2, true, 4);
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
        aVar.b(this.eGt).th();
    }

    public String getThreadId() {
        if (this.eTL != null) {
            return this.eTL.getThreadID();
        }
        return null;
    }

    public String getPostId() {
        if (this.eTL != null) {
            return this.eTL.Dn();
        }
        return null;
    }

    public int aPj() {
        if (this.eTL != null) {
            return this.eTL.aPj();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eUa) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eUa) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }
}
