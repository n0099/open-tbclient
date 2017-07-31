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
    private static final String eTK = com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String eUX = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aRt;
    private com.baidu.adp.lib.e.b<TextView> aRu;
    private com.baidu.adp.lib.e.b<View> aRv;
    private com.baidu.adp.lib.e.b<View> aRw;
    private com.baidu.adp.lib.e.b<LinearLayout> aRx;
    private com.baidu.adp.lib.e.b<GifView> aRy;
    private View.OnLongClickListener awn;
    private View.OnClickListener cLO;
    private VoiceManager ciW;
    private com.baidu.tbadk.editortools.pb.e dEQ;
    private com.baidu.adp.base.e eHG;
    private com.baidu.tbadk.core.view.c eHH;
    private b.InterfaceC0043b eIt;
    private SubPbModel eUY;
    private ForumManageModel eUZ;
    private c eVa;
    private AbsListView.OnScrollListener eVb;
    private TbRichTextView.f eVc;
    private TbRichTextView.e eVd;
    private SubPbModel.a eVe;
    private com.baidu.adp.base.d eVf;
    private BdUniqueId eVk;
    private b eVm;
    private com.baidu.tbadk.baseEditMark.a eal;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int eIq = 0;
    private a.InterfaceC0038a eIl = null;
    private a eVg = null;
    private a eVh = null;
    private boolean eVi = false;
    private boolean eVj = false;
    private boolean eVl = false;
    private boolean eVn = false;
    private com.baidu.tbadk.editortools.pb.b aEe = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.b
        public void Dx() {
            NewSubPbActivity.this.eVa.aVh();
        }
    };
    private NewWriteModel.d eVo = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.dEQ != null && NewSubPbActivity.this.dEQ.Da() != null) {
                NewSubPbActivity.this.dEQ.Da().hide();
                if (NewSubPbActivity.this.eUY.aVB()) {
                    TiebaStatic.log(new aj("c10367").aa("post_id", NewSubPbActivity.this.eUY.Dv()));
                }
            }
            NewSubPbActivity.this.eVa.aVi();
        }
    };
    private CustomMessageListener eIe = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eVk) {
                NewSubPbActivity.this.eVa.QY();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eHH.c(NewSubPbActivity.this.eHG.getResources().getString(d.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.eHG.getResources().getString(d.l.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.gc(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.aQU();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (al.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.eHG.getResources().getString(d.l.mute_fail);
                    }
                    NewSubPbActivity.this.eHH.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eIf = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eVk) {
                NewSubPbActivity.this.eVa.QY();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eHH.c(NewSubPbActivity.this.eHG.getResources().getString(d.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (al.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.eHG.getResources().getString(d.l.un_mute_fail);
                }
                NewSubPbActivity.this.eHH.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eIg = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eVk) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.eVa.QY();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.guH;
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
                    NewSubPbActivity.this.eVa.a(sparseArray, z);
                }
            }
        }
    };
    boolean eIr = false;
    private CustomMessageListener dir = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a)) {
                b.a aVar = (b.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.b.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    public final TbRichTextView.d eTN = new TbRichTextView.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
        public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONIMAGE, new EmotionImageActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i, i2)));
        }
    };
    CustomMessageListener cjQ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof j)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    j jVar = (j) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.eUY.aVu() != null && NewSubPbActivity.this.eUY.aVu().aPR() != null && NewSubPbActivity.this.eUY.aVu().aPR().getAuthor() != null && currentAccount.equals(NewSubPbActivity.this.eUY.aVu().aPR().getAuthor().getUserId()) && NewSubPbActivity.this.eUY.aVu().aPR().getAuthor().getPendantData() != null) {
                        NewSubPbActivity.this.eUY.aVu().aPR().getAuthor().getPendantData().cH(jVar.pV());
                        NewSubPbActivity.this.eUY.aVu().aPR().getAuthor().getPendantData().Q(jVar.CB());
                        NewSubPbActivity.this.eVa.a(NewSubPbActivity.this.eUY.aVu().aPR(), NewSubPbActivity.this.eUY.aVu().axm(), NewSubPbActivity.this.eUY.aVu().nL(), NewSubPbActivity.this.eUY.aPu(), NewSubPbActivity.this.eUY.aVK() != null);
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
        if (this.eVn) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.eHG = getPageContext();
        this.eVj = true;
        anP();
        aUU();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.eUY.aUW()) {
            this.eVm = new b(this, getListView(), this.eVa.afq());
            this.eVm.aUP();
            this.eVm.a(new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
                private boolean eVr = false;

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void aUR() {
                    NewSubPbActivity.this.eVa.jW(false);
                    this.eVr = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void aUS() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public boolean aUT() {
                    if (!this.eVr) {
                        return NewSubPbActivity.this.eVa.aUZ() != null && NewSubPbActivity.this.eVa.aUZ().getTop() == 0;
                    }
                    this.eVr = false;
                    return false;
                }
            });
            this.eVa.e(this.eVm);
            this.eVa.jW(true);
        }
        this.eHH = new com.baidu.tbadk.core.view.c();
        this.eHH.alm = 1000L;
        registerListener(this.eIg);
        registerListener(this.eIe);
        registerListener(this.eIf);
        this.eVk = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eVk;
        userMuteAddAndDelCustomMessage.setTag(this.eVk);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eVk;
        userMuteCheckCustomMessage.setTag(this.eVk);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.eVa = new c(this, this.cLO);
        this.eVa.a(this.eUY);
        addContentView(this.eVa.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.eVa.setOnScrollListener(this.eVb);
        this.eVa.a(this);
        this.eVa.setOnLinkImageClickListener(this.eVc);
        this.eVa.setOnImageClickListener(this.eVd);
        this.eVa.iP(true);
        this.eVa.setOnLongClickListener(this.awn);
        this.eVa.f(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.eUY != null) {
                    NewSubPbActivity.this.eUY.Fw();
                }
            }
        });
        this.eVa.a(this.eVg);
        this.eVa.b(this.eVh);
        if (this.eUY != null && this.eUY.aUW() && !this.eUY.aVJ()) {
            this.eVa.aVl().setVisibility(8);
        } else {
            this.eVa.aVl().setVisibility(0);
        }
        if (this.eUY != null && !this.eUY.aUW()) {
            this.eVa.setIsFromPb(false);
        }
    }

    private boolean u(Bundle bundle) {
        if (bundle != null) {
            this.eVn = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eVn = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eVn;
    }

    public void initData(Bundle bundle) {
        this.eUY = new SubPbModel(getPageContext());
        this.eUY.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.eVa.n(postData);
                NewSubPbActivity.this.eVa.a((BdListView.e) null);
            }
        });
        this.eUZ = new ForumManageModel(this);
        this.eUZ.setLoadDataCallBack(this.eVf);
        this.ciW = new VoiceManager();
        this.ciW.onCreate(getPageContext());
        this.eal = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.eal != null) {
            this.eal.a(this.eIl);
        }
        if (bundle != null) {
            this.eUY.initWithBundle(bundle);
        } else {
            this.eUY.initWithIntent(getIntent());
        }
        this.eUY.a(this.eVe);
        if (this.eUY.aUW()) {
            this.eUY.Fw();
        } else {
            this.eUY.aVz();
        }
    }

    public void aUU() {
        this.eVe = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, n nVar) {
                if (NewSubPbActivity.this.eVa != null) {
                    NewSubPbActivity.this.eVa.aVi();
                }
                if (NewSubPbActivity.this.eVm != null && NewSubPbActivity.this.eVm.aUQ()) {
                    NewSubPbActivity.this.eVm.py(d.e.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.T(i, str);
                    return;
                }
                NewSubPbActivity.this.eVa.hideNoDataView();
                if (nVar != null) {
                    if (nVar.aPR() != null || NewSubPbActivity.this.eUY != null) {
                        nVar.aPR().a(NewSubPbActivity.this.eUY.aVI());
                    }
                    if (NewSubPbActivity.this.eVa != null) {
                        NewSubPbActivity.this.eVa.a(nVar, NewSubPbActivity.this.eUY.aPu(), NewSubPbActivity.this.eUY.aVK() != null);
                        if (NewSubPbActivity.this.eVj) {
                            NewSubPbActivity.this.aUV();
                            NewSubPbActivity.this.eVj = false;
                        }
                    }
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setData(nVar);
                    if (NewSubPbActivity.this.dEQ != null) {
                        NewSubPbActivity.this.dEQ.a(nVar.aAV());
                    }
                    dVar.setType(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
                }
            }
        };
        this.eIl = new a.InterfaceC0038a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0038a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.eal != null) {
                        NewSubPbActivity.this.eal.ac(z2);
                    }
                    MarkData nO = NewSubPbActivity.this.eal.nO();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setType(2);
                    if (z2) {
                        dVar.setData(nO);
                        if (NewSubPbActivity.this.eal != null) {
                            if (nO != null) {
                                NewSubPbActivity.this.eUY.jy(true);
                                NewSubPbActivity.this.eUY.pK(NewSubPbActivity.this.eUY.Dv());
                                NewSubPbActivity.this.showToast(d.l.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.add_mark));
                            }
                            if (NewSubPbActivity.this.eVa != null) {
                                NewSubPbActivity.this.eVa.jY(true);
                            }
                        }
                    } else {
                        dVar.setData(null);
                        NewSubPbActivity.this.eUY.jy(false);
                        NewSubPbActivity.this.eUY.pK(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.remove_mark));
                        if (NewSubPbActivity.this.eVa != null) {
                            NewSubPbActivity.this.eVa.jY(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.update_mark_failed));
            }
        };
        this.eVg = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void g(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.eUY.aVu() != null && NewSubPbActivity.this.eUY.aVu().MF() != null && NewSubPbActivity.this.eUY.aVu().MF().getAuthor() != null) {
                    str = String.valueOf(NewSubPbActivity.this.eUY.aVu().MF().getAuthor().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.eUY.aVu().aPX().getId(), NewSubPbActivity.this.eUY.aVu().aPX().getName(), NewSubPbActivity.this.eUY.aVu().MF().getId(), str, str2, str3)));
            }
        };
        this.eVh = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void g(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.eUZ.btk() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.eUY != null && NewSubPbActivity.this.eUY.aVu() != null && NewSubPbActivity.this.eUY.aVu().aPX() != null && NewSubPbActivity.this.eUY.aVu().MF() != null) {
                            NewSubPbActivity.this.eUZ.a(NewSubPbActivity.this.eUY.aVu().aPX().getId(), NewSubPbActivity.this.eUY.aVu().aPX().getName(), NewSubPbActivity.this.eUY.aVu().MF().getId(), valueOf, g2, g, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.l.login_to_use), true, 11017)));
            }
        };
        this.eVf = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.adp.base.d
            public void g(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.eVa.a(NewSubPbActivity.this.eUZ.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.eUZ.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.cHN || bVar.eWc <= 0 || bVar.gke == 1) {
                            z = true;
                        } else {
                            com.baidu.tieba.c.a.a(NewSubPbActivity.this.getPageContext(), 3, 1);
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.eVa.a(1, dVar.Cm, dVar.gkg, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void anP() {
        registerListener(this.cjQ);
        this.cLO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.eVa != null) {
                    if (view == NewSubPbActivity.this.eVa.aVr()) {
                        NewSubPbActivity.this.eVa.aBk();
                        String str = view.getTag(d.h.tag_user_id) instanceof String ? (String) view.getTag(d.h.tag_user_id) : null;
                        String str2 = view.getTag(d.h.tag_user_name) instanceof String ? (String) view.getTag(d.h.tag_user_name) : null;
                        String str3 = view.getTag(d.h.tag_virtual_user_url) instanceof String ? (String) view.getTag(d.h.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                at.wf().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.eVa.aVk()) {
                        if (view == NewSubPbActivity.this.eVa.aVg()) {
                            NewSubPbActivity.this.eVa.aBk();
                            if (NewSubPbActivity.this.eUY.Fw()) {
                                NewSubPbActivity.this.eVa.aVe();
                            }
                        } else if (view == NewSubPbActivity.this.eVa.aVl() || view == NewSubPbActivity.this.eVa.aVm() || view == NewSubPbActivity.this.eVa.aVo()) {
                            if (NewSubPbActivity.this.eVl) {
                                NewSubPbActivity.this.eVl = false;
                                return;
                            }
                            PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.eUY.getThreadID(), NewSubPbActivity.this.eUY.Dv(), "");
                            if (!StringUtils.isNull(NewSubPbActivity.this.eUY.aVN())) {
                                createNormalCfg.setForumId(NewSubPbActivity.this.eUY.aVN());
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } else if (NewSubPbActivity.this.eVa.aVp() == null || view != NewSubPbActivity.this.eVa.aVp().aSf()) {
                            if (NewSubPbActivity.this.eVa.aVp() == null || view != NewSubPbActivity.this.eVa.aVp().aSk()) {
                                if (NewSubPbActivity.this.eVa.aVp() == null || view != NewSubPbActivity.this.eVa.aVp().aSi()) {
                                    if (NewSubPbActivity.this.eVa.aVp() == null || view != NewSubPbActivity.this.eVa.aVp().aSg()) {
                                        if (NewSubPbActivity.this.eVa.aVp() == null || view != NewSubPbActivity.this.eVa.aVp().aSh()) {
                                            if ((view == NewSubPbActivity.this.eVa.aVj() || view == NewSubPbActivity.this.eVa.aVo()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                if (NewSubPbActivity.this.dEQ.DX()) {
                                                    NewSubPbActivity.this.dEQ.DY();
                                                    return;
                                                } else {
                                                    NewSubPbActivity.this.dEQ.gd(null);
                                                    return;
                                                }
                                            }
                                            return;
                                        }
                                        TiebaStatic.log(new aj("c11739").r("obj_locate", 4));
                                        if (!i.hr()) {
                                            NewSubPbActivity.this.showToast(d.l.network_not_available);
                                            return;
                                        }
                                        Object tag = view.getTag();
                                        NewSubPbActivity.this.eVa.aBk();
                                        if (tag instanceof String) {
                                            String Dv = NewSubPbActivity.this.eUY.Dv();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.pl(Dv);
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
                                    } else if (i.hr()) {
                                        NewSubPbActivity.this.eVa.aBk();
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
                                NewSubPbActivity.this.eVa.aBk();
                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                if (sparseArray2 != null) {
                                    NewSubPbActivity.this.eVa.a(((Integer) sparseArray2.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.h.tag_del_post_id), ((Integer) sparseArray2.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.h.tag_del_post_is_self)).booleanValue());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(new aj("c11739").r("obj_locate", 1));
                            NewSubPbActivity.this.eVa.aBk();
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.dEQ.gd(null);
                                if (NewSubPbActivity.this.eVm != null) {
                                    NewSubPbActivity.this.eVm.aUO();
                                }
                            }
                        } else {
                            TiebaStatic.log(new aj("c11739").r("obj_locate", 2));
                            NewSubPbActivity.this.eVa.aBk();
                            if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.eUY.aVu() != null) {
                                NewSubPbActivity.this.h(NewSubPbActivity.this.eUY.aVu().aPR());
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.eVa.aVb();
                        NewSubPbActivity.this.eVa.aVc();
                        if (NewSubPbActivity.this.dEQ != null) {
                            NewSubPbActivity.this.dEQ.DZ();
                            if (NewSubPbActivity.this.eVm != null) {
                                NewSubPbActivity.this.eVm.aUO();
                            }
                        }
                    }
                }
            }
        };
        this.eVb = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.eVa.aBk();
                }
                NewSubPbActivity.this.dEQ.DY();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.eVa.aVq();
            }
        };
        this.eIt = new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.eUY.aVu() != null) {
                    postData = NewSubPbActivity.this.eUY.aVu().aPR();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.bN(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.h(postData);
                    }
                }
            }
        };
        this.awn = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
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
                    NewSubPbActivity.this.eVa.b(NewSubPbActivity.this.eIt, NewSubPbActivity.this.eUY.isMarked());
                }
                return true;
            }
        };
        this.eVc = new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void b(View view, String str) {
                NewSubPbActivity.this.j(null, str, "LINK_IMAGE");
            }
        };
        this.eVd = new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                    n aVu = NewSubPbActivity.this.eUY.aVu();
                    TbRichText ao = NewSubPbActivity.this.ao(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (ao != null && ao.Io() != null) {
                        tbRichTextData = ao.Io().get(NewSubPbActivity.this.eIq);
                    }
                    if (tbRichTextData != null) {
                        ArrayList<String> arrayList3 = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!tbRichTextData.It().IG()) {
                            String c = NewSubPbActivity.this.c(tbRichTextData);
                            arrayList3.add(c);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                            concurrentHashMap3.put(c, imageUrlData);
                            String str4 = null;
                            String str5 = null;
                            String str6 = null;
                            if (aVu == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (aVu.aPX() != null) {
                                    str4 = aVu.aPX().getName();
                                    str5 = aVu.aPX().getId();
                                }
                                if (aVu.MF() != null) {
                                    str6 = aVu.MF().getId();
                                }
                                str3 = str6;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.eUY.aVK() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.eUY.aVK();
                                z4 = NewSubPbActivity.this.eUY.aVM();
                                arrayList2 = NewSubPbActivity.this.eUY.aVL();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                arrayList2 = arrayList3;
                                z4 = z3;
                            }
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str4, str5, str3, z4, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.eIr = false;
                        String str7 = "";
                        TbRichText aAP = aVu.aPR().aAP();
                        int size = arrayList3.size();
                        int a2 = NewSubPbActivity.this.a(aAP, ao, i, i, arrayList3, concurrentHashMap3);
                        int size2 = arrayList3.size();
                        if (size != size2) {
                            str7 = arrayList3.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (aVu == null) {
                            str2 = null;
                            z = false;
                        } else {
                            if (aVu.aPX() != null) {
                                str8 = aVu.aPX().getName();
                                str9 = aVu.aPX().getId();
                            }
                            if (aVu.MF() != null) {
                                str10 = aVu.MF().getId();
                            }
                            str2 = str10;
                            z = true;
                        }
                        if (NewSubPbActivity.this.eUY.aVK() != null) {
                            concurrentHashMap = NewSubPbActivity.this.eUY.aVK();
                            z2 = NewSubPbActivity.this.eUY.aVM();
                            arrayList = NewSubPbActivity.this.eUY.aVL();
                            a2 += NewSubPbActivity.this.eUY.getOffset();
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
        TbRichTextImageInfo It;
        if (tbRichText == tbRichText2) {
            this.eIr = true;
        }
        if (tbRichText != null && tbRichText.Io() != null) {
            int size = tbRichText.Io().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Io().get(i6) != null && tbRichText.Io().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.Io().get(i6).It().getWidth();
                    int height = tbRichText.Io().get(i6).It().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Io().get(i6).It().IG()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Io().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (It = tbRichTextData.It()) != null) {
                            String II = It.II();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = II;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.eIr) {
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
        TbRichTextImageInfo It = tbRichTextData.It();
        if (It != null) {
            if (!StringUtils.isNull(It.IF())) {
                return It.IF();
            }
            if (It.getHeight() * It.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (It.getHeight() * It.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (It.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * It.getHeight())));
            } else {
                float width = It.getWidth() / It.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(al.aQ(It.IH()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText ao(String str, int i) {
        if (this.eUY == null || this.eUY.aVu() == null || str == null || i < 0) {
            return null;
        }
        n aVu = this.eUY.aVu();
        TbRichText a2 = a(aVu.aPR(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(aVu.aPR(), str, i);
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
        TbRichText aAP = postData.aAP();
        if (aAP != null) {
            ArrayList<TbRichTextData> Io = aAP.Io();
            int size = Io.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Io.get(i3) != null && Io.get(i3).getType() == 8) {
                    i2++;
                    if (Io.get(i3).It().II().equals(str)) {
                        int width = Io.get(i3).It().getWidth();
                        int height = Io.get(i3).It().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.eIq = i3;
                        return aAP;
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
        long templateId = this.eUY.aVu().aPR().bsG() != null ? this.eUY.aVu().aPR().bsG().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && at.wf().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.eUY.aVu().aPX().getId(), this.eUY.aVu().aPX().getName(), this.eUY.aVu().MF().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i, String str) {
        if (this.eUY.aVv()) {
            showToast(str);
        } else if (k.hI()) {
            if (i == 4) {
                this.eVa.pF(str + "(4)");
            } else {
                this.eVa.gj(d.l.no_data_text);
            }
        } else {
            this.eVa.gj(d.l.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.dEQ = (com.baidu.tbadk.editortools.pb.e) new f().aR(getActivity());
        this.dEQ.a(getPageContext());
        this.dEQ.b(this.eUY);
        this.dEQ.b(this.eVo);
        this.dEQ.a(this.aEe);
        this.dEQ.Da().bE(true);
        this.dEQ.g(getPageContext());
        if (this.eVa != null) {
            this.eVa.f(this.dEQ);
        }
        if (this.dEQ != null && this.eUY != null) {
            this.dEQ.a(this.eUY.aAV());
            this.dEQ.DY();
        }
    }

    public void aUV() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dEQ.DY();
        } else if (!StringUtils.isNull(this.eUY.aVE())) {
            this.eVa.pG(this.eUY.aVE());
            if (this.eVa.aVf() && k.hI()) {
                this.eVa.adA();
            } else {
                this.eVa.aVi();
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
                    this.eVa.bf(view);
                }
            } else if (booleanValue2) {
                this.eVa.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
            }
            g.a(this.eVa.aVn(), getPageContext().getPageActivity());
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
                        NewSubPbActivity.this.eVa.a(intValue, str2, sparseArray.get(d.h.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.h.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue() : false);
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
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.eVk);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.eVk);
                        NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str6, str3);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext()).tu();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(d.h.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(d.h.tag_user_mute_mute_userid);
        }
        this.eVa.QX();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.eVk;
        userMuteCheckCustomMessage.setTag(this.eVk);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.eVa.a(0, bVar.Cm, bVar.gkg, z);
            if (bVar.Cm) {
                if (bVar.gke == 1) {
                    finish();
                } else if (bVar.gke == 2) {
                    this.eUY.pJ(bVar.mPostId);
                    this.eVa.a(this.eUY.aVu(), this.eUY.aPu(), this.eUY.aVK() != null);
                    if (this.eUY.aVF()) {
                        this.eUY.kb(false);
                        this.eVa.aVd();
                        this.eUY.Fw();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
            }
        }
    }

    public void pl(String str) {
        if (!StringUtils.isNull(str) && this.eUY != null) {
            String threadID = this.eUY.getThreadID();
            String Dv = this.eUY.Dv();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Dv + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void h(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.eUY.isMarked() && postData.getId() != null && postData.getId().equals(this.eUY.aVC())) {
                z = true;
            }
            MarkData j = this.eUY.j(postData);
            if (j != null) {
                this.eVa.aBk();
                if (this.eal != null) {
                    this.eal.a(j);
                    if (!z) {
                        this.eal.nN();
                    } else {
                        this.eal.nM();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.eUY != null) {
            this.eUY.r(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dEQ != null) {
            this.dEQ.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.ciW != null) {
            this.ciW.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.eVi = true;
        super.onPause();
        if (this.ciW != null) {
            this.ciW.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dir);
        this.eVa.ahd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eVi = false;
        super.onResume();
        if (this.ciW != null) {
            this.ciW.onResume(getPageContext());
        }
        registerListener(this.dir);
        this.eVa.ahe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ciW != null) {
            this.ciW.onStop(getPageContext());
        }
        this.dEQ.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eUY.cancelLoadData();
        this.eUY.destory();
        this.eUZ.cancelLoadData();
        if (this.ciW != null) {
            this.ciW.onDestory(getPageContext());
        }
        this.eVa.aBk();
        this.eVa.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.eIe);
        MessageManager.getInstance().unRegisterListener(this.eIf);
        MessageManager.getInstance().unRegisterListener(this.eIg);
        MessageManager.getInstance().unRegisterListener(this.eVk);
        this.eHG = null;
        this.eHH = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eVa.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.ciW;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aVj = this.eVa.aVj();
        if (aVj == null || (findViewWithTag = aVj.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean pA(String str) {
        Map<String, String> ee;
        if (!TextUtils.isEmpty(str) && (ee = at.ee(at.ef(str))) != null) {
            this.eVl = true;
            String str2 = ee.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pA(com.baidu.adp.lib.util.j.aR(str2));
            }
            String str3 = ee.get(eUX);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (pA(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            at.wf().c(getPageContext(), new String[]{str});
            this.eVl = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eVl = true;
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
        if (this.eVa != null) {
            return this.eVa.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int IR() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> IT() {
        if (this.aRu == null) {
            this.aRu = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aRu;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> IU() {
        if (this.aRy == null) {
            this.aRy = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aQZ */
                public GifView fT() {
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
        return this.aRy;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> IS() {
        if (this.aRt == null) {
            this.aRt = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: Ts */
                public ImageView fT() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean pd = h.oX().pd();
                    foreDrawableImageView.setDefaultBg(ai.getDrawable(d.e.common_color_10220));
                    if (pd) {
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
                        if (h.oX().pd()) {
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
        return this.aRt;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IV() {
        if (this.aRw == null) {
            this.aRw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: amb */
                public View fT() {
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
        return this.aRw;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> IW() {
        if (this.aRx == null) {
            this.aRx = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aRa */
                public LinearLayout fT() {
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
        return this.aRx;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IX() {
        if (this.aRv == null) {
            this.aRv = com.baidu.tieba.graffiti.c.p(getPageContext().getPageActivity(), 8);
        }
        return this.aRv;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eVa.aVf() && k.hI()) {
            this.eUY.Fw();
        } else {
            this.eVa.aVi();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.eVk);
        userMuteAddAndDelCustomMessage.setTag(this.eVk);
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
            public boolean FO() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int FP() {
                return com.baidu.tbadk.pageStayDuration.e.FU().FW();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.eUY != null) {
            if (this.eUY.aVu() != null && this.eUY.aVu().aPX() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.eUY.aVu().aPX().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.eUY.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean Zc() {
        return this.eVi;
    }

    public boolean aUW() {
        if (this.eUY != null) {
            return this.eUY.aUW();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eVa.QX();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eHG.getPageActivity());
        if (al.isEmpty(str)) {
            aVar.cT(this.eHG.getResources().getString(d.l.block_mute_message_alert, str2));
        } else {
            aVar.cT(str);
        }
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.eVa.QX();
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
        aVar.b(this.eHG).tr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eHG.getPageActivity());
        aVar.cT(str);
        aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eHG).tr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQU() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cT(getResources().getString(d.l.mute_is_super_member_function));
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.eHG).showToast(d.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.eHG.getPageActivity(), 2, true, 4);
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
        aVar.b(this.eHG).tr();
    }

    public String getThreadId() {
        if (this.eUY != null) {
            return this.eUY.getThreadID();
        }
        return null;
    }

    public String getPostId() {
        if (this.eUY != null) {
            return this.eUY.Dv();
        }
        return null;
    }

    public int aPu() {
        if (this.eUY != null) {
            return this.eUY.aPu();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eVn) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eVn) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }
}
