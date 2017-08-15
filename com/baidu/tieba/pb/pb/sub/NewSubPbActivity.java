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
    private static final String eVD = com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String eWQ = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aRu;
    private com.baidu.adp.lib.e.b<TextView> aRv;
    private com.baidu.adp.lib.e.b<View> aRw;
    private com.baidu.adp.lib.e.b<View> aRx;
    private com.baidu.adp.lib.e.b<LinearLayout> aRy;
    private com.baidu.adp.lib.e.b<GifView> aRz;
    private View.OnLongClickListener awo;
    private View.OnClickListener cNL;
    private VoiceManager cjJ;
    private com.baidu.tbadk.editortools.pb.e dGN;
    private com.baidu.adp.base.e eJA;
    private com.baidu.tbadk.core.view.c eJB;
    private b.InterfaceC0043b eKn;
    private SubPbModel eWR;
    private ForumManageModel eWS;
    private c eWT;
    private AbsListView.OnScrollListener eWU;
    private TbRichTextView.f eWV;
    private TbRichTextView.e eWW;
    private SubPbModel.a eWX;
    private com.baidu.adp.base.d eWY;
    private BdUniqueId eXd;
    private b eXf;
    private com.baidu.tbadk.baseEditMark.a ech;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int eKk = 0;
    private a.InterfaceC0038a eKf = null;
    private a eWZ = null;
    private a eXa = null;
    private boolean eXb = false;
    private boolean eXc = false;
    private boolean eXe = false;
    private boolean eXg = false;
    private com.baidu.tbadk.editortools.pb.b aEf = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.b
        public void Dx() {
            NewSubPbActivity.this.eWT.aVO();
        }
    };
    private NewWriteModel.d eXh = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.dGN != null && NewSubPbActivity.this.dGN.Da() != null) {
                NewSubPbActivity.this.dGN.Da().hide();
                if (NewSubPbActivity.this.eWR.aWi()) {
                    TiebaStatic.log(new aj("c10367").aa("post_id", NewSubPbActivity.this.eWR.Dv()));
                }
            }
            NewSubPbActivity.this.eWT.aVP();
        }
    };
    private CustomMessageListener eJY = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eXd) {
                NewSubPbActivity.this.eWT.Rs();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eJB.c(NewSubPbActivity.this.eJA.getResources().getString(d.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.eJA.getResources().getString(d.l.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.gc(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.aRB();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (al.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.eJA.getResources().getString(d.l.mute_fail);
                    }
                    NewSubPbActivity.this.eJB.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eJZ = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eXd) {
                NewSubPbActivity.this.eWT.Rs();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.eJB.c(NewSubPbActivity.this.eJA.getResources().getString(d.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (al.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.eJA.getResources().getString(d.l.un_mute_fail);
                }
                NewSubPbActivity.this.eJB.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eKa = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.eXd) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.eWT.Rs();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.gwz;
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
                    NewSubPbActivity.this.eWT.a(sparseArray, z);
                }
            }
        }
    };
    boolean eKl = false;
    private CustomMessageListener dko = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a)) {
                b.a aVar = (b.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.b.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    public final TbRichTextView.d eVG = new TbRichTextView.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
        public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONIMAGE, new EmotionImageActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i, i2)));
        }
    };
    CustomMessageListener ckD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof j)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    j jVar = (j) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.eWR.aWb() != null && NewSubPbActivity.this.eWR.aWb().aQy() != null && NewSubPbActivity.this.eWR.aWb().aQy().getAuthor() != null && currentAccount.equals(NewSubPbActivity.this.eWR.aWb().aQy().getAuthor().getUserId()) && NewSubPbActivity.this.eWR.aWb().aQy().getAuthor().getPendantData() != null) {
                        NewSubPbActivity.this.eWR.aWb().aQy().getAuthor().getPendantData().cH(jVar.pV());
                        NewSubPbActivity.this.eWR.aWb().aQy().getAuthor().getPendantData().Q(jVar.CB());
                        NewSubPbActivity.this.eWT.a(NewSubPbActivity.this.eWR.aWb().aQy(), NewSubPbActivity.this.eWR.aWb().axT(), NewSubPbActivity.this.eWR.aWb().nL(), NewSubPbActivity.this.eWR.aQb(), NewSubPbActivity.this.eWR.aWr() != null);
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
        if (this.eXg) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.eJA = getPageContext();
        this.eXc = true;
        aov();
        aVB();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.eWR.aVD()) {
            this.eXf = new b(this, getListView(), this.eWT.afM());
            this.eXf.aVw();
            this.eXf.a(new b.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
                private boolean eXk = false;

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void aVy() {
                    NewSubPbActivity.this.eWT.jZ(false);
                    this.eXk = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public void aVz() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.b.a
                public boolean aVA() {
                    if (!this.eXk) {
                        return NewSubPbActivity.this.eWT.aVG() != null && NewSubPbActivity.this.eWT.aVG().getTop() == 0;
                    }
                    this.eXk = false;
                    return false;
                }
            });
            this.eWT.e(this.eXf);
            this.eWT.jZ(true);
        }
        this.eJB = new com.baidu.tbadk.core.view.c();
        this.eJB.alo = 1000L;
        registerListener(this.eKa);
        registerListener(this.eJY);
        registerListener(this.eJZ);
        this.eXd = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eXd;
        userMuteAddAndDelCustomMessage.setTag(this.eXd);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eXd;
        userMuteCheckCustomMessage.setTag(this.eXd);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.eWT = new c(this, this.cNL);
        this.eWT.a(this.eWR);
        addContentView(this.eWT.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.eWT.setOnScrollListener(this.eWU);
        this.eWT.a(this);
        this.eWT.setOnLinkImageClickListener(this.eWV);
        this.eWT.setOnImageClickListener(this.eWW);
        this.eWT.iS(true);
        this.eWT.setOnLongClickListener(this.awo);
        this.eWT.f(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.eWR != null) {
                    NewSubPbActivity.this.eWR.Fw();
                }
            }
        });
        this.eWT.a(this.eWZ);
        this.eWT.b(this.eXa);
        if (this.eWR != null && this.eWR.aVD() && !this.eWR.aWq()) {
            this.eWT.aVS().setVisibility(8);
        } else {
            this.eWT.aVS().setVisibility(0);
        }
        if (this.eWR != null && !this.eWR.aVD()) {
            this.eWT.setIsFromPb(false);
        }
    }

    private boolean u(Bundle bundle) {
        if (bundle != null) {
            this.eXg = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eXg = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eXg;
    }

    public void initData(Bundle bundle) {
        this.eWR = new SubPbModel(getPageContext());
        this.eWR.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.eWT.n(postData);
                NewSubPbActivity.this.eWT.a((BdListView.e) null);
            }
        });
        this.eWS = new ForumManageModel(this);
        this.eWS.setLoadDataCallBack(this.eWY);
        this.cjJ = new VoiceManager();
        this.cjJ.onCreate(getPageContext());
        this.ech = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.ech != null) {
            this.ech.a(this.eKf);
        }
        if (bundle != null) {
            this.eWR.initWithBundle(bundle);
        } else {
            this.eWR.initWithIntent(getIntent());
        }
        this.eWR.a(this.eWX);
        if (this.eWR.aVD()) {
            this.eWR.Fw();
        } else {
            this.eWR.aWg();
        }
    }

    public void aVB() {
        this.eWX = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, n nVar) {
                if (NewSubPbActivity.this.eWT != null) {
                    NewSubPbActivity.this.eWT.aVP();
                }
                if (NewSubPbActivity.this.eXf != null && NewSubPbActivity.this.eXf.aVx()) {
                    NewSubPbActivity.this.eXf.pI(d.e.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.S(i, str);
                    return;
                }
                NewSubPbActivity.this.eWT.hideNoDataView();
                if (nVar != null) {
                    if (nVar.aQy() != null || NewSubPbActivity.this.eWR != null) {
                        nVar.aQy().a(NewSubPbActivity.this.eWR.aWp());
                    }
                    if (NewSubPbActivity.this.eWT != null) {
                        NewSubPbActivity.this.eWT.a(nVar, NewSubPbActivity.this.eWR.aQb(), NewSubPbActivity.this.eWR.aWr() != null);
                        if (NewSubPbActivity.this.eXc) {
                            NewSubPbActivity.this.aVC();
                            NewSubPbActivity.this.eXc = false;
                        }
                    }
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setData(nVar);
                    if (NewSubPbActivity.this.dGN != null) {
                        NewSubPbActivity.this.dGN.a(nVar.aBC());
                    }
                    eVar.setType(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                }
            }
        };
        this.eKf = new a.InterfaceC0038a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0038a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.ech != null) {
                        NewSubPbActivity.this.ech.ac(z2);
                    }
                    MarkData nO = NewSubPbActivity.this.ech.nO();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(nO);
                        if (NewSubPbActivity.this.ech != null) {
                            if (nO != null) {
                                NewSubPbActivity.this.eWR.jB(true);
                                NewSubPbActivity.this.eWR.pM(NewSubPbActivity.this.eWR.Dv());
                                NewSubPbActivity.this.showToast(d.l.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.add_mark));
                            }
                            if (NewSubPbActivity.this.eWT != null) {
                                NewSubPbActivity.this.eWT.kb(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.eWR.jB(false);
                        NewSubPbActivity.this.eWR.pM(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.remove_mark));
                        if (NewSubPbActivity.this.eWT != null) {
                            NewSubPbActivity.this.eWT.kb(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(d.l.update_mark_failed));
            }
        };
        this.eWZ = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void g(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                if (NewSubPbActivity.this.eWR.aWb() != null && NewSubPbActivity.this.eWR.aWb().MF() != null && NewSubPbActivity.this.eWR.aWb().MF().getAuthor() != null) {
                    str = String.valueOf(NewSubPbActivity.this.eWR.aWb().MF().getAuthor().getUserId());
                }
                String str2 = "";
                if (objArr.length > 1) {
                    str2 = String.valueOf(objArr[1]);
                }
                String str3 = "";
                if (objArr.length > 2) {
                    str3 = String.valueOf(objArr[2]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.eWR.aWb().aQE().getId(), NewSubPbActivity.this.eWR.aWb().aQE().getName(), NewSubPbActivity.this.eWR.aWb().MF().getId(), str, str2, str3)));
            }
        };
        this.eXa = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void g(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.eWS.btS() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                        boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                        int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.eWR != null && NewSubPbActivity.this.eWR.aWb() != null && NewSubPbActivity.this.eWR.aWb().aQE() != null && NewSubPbActivity.this.eWR.aWb().MF() != null) {
                            NewSubPbActivity.this.eWS.a(NewSubPbActivity.this.eWR.aWb().aQE().getId(), NewSubPbActivity.this.eWR.aWb().aQE().getName(), NewSubPbActivity.this.eWR.aWb().MF().getId(), valueOf, g2, g, d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.getPageContext().getString(d.l.login_to_use), true, 11017)));
            }
        };
        this.eWY = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.adp.base.d
            public void g(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.eWT.a(NewSubPbActivity.this.eWS.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.eWS.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.cJK || bVar.eXV <= 0 || bVar.glW == 1) {
                            z = true;
                        } else {
                            com.baidu.tieba.c.a.a(NewSubPbActivity.this.getPageContext(), 3, 1);
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.eWT.a(1, dVar.Co, dVar.glY, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void aov() {
        registerListener(this.ckD);
        this.cNL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.eWT != null) {
                    if (view == NewSubPbActivity.this.eWT.aVY()) {
                        NewSubPbActivity.this.eWT.aBR();
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
                    } else if (view != NewSubPbActivity.this.eWT.aVR()) {
                        if (view == NewSubPbActivity.this.eWT.aVN()) {
                            NewSubPbActivity.this.eWT.aBR();
                            if (NewSubPbActivity.this.eWR.Fw()) {
                                NewSubPbActivity.this.eWT.aVL();
                            }
                        } else if (view == NewSubPbActivity.this.eWT.aVS() || view == NewSubPbActivity.this.eWT.aVT() || view == NewSubPbActivity.this.eWT.aVV()) {
                            if (NewSubPbActivity.this.eXe) {
                                NewSubPbActivity.this.eXe = false;
                                return;
                            }
                            PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.eWR.getThreadID(), NewSubPbActivity.this.eWR.Dv(), "");
                            if (!StringUtils.isNull(NewSubPbActivity.this.eWR.aWu())) {
                                createNormalCfg.setForumId(NewSubPbActivity.this.eWR.aWu());
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } else if (NewSubPbActivity.this.eWT.aVW() == null || view != NewSubPbActivity.this.eWT.aVW().aSM()) {
                            if (NewSubPbActivity.this.eWT.aVW() == null || view != NewSubPbActivity.this.eWT.aVW().aSR()) {
                                if (NewSubPbActivity.this.eWT.aVW() == null || view != NewSubPbActivity.this.eWT.aVW().aSP()) {
                                    if (NewSubPbActivity.this.eWT.aVW() == null || view != NewSubPbActivity.this.eWT.aVW().aSN()) {
                                        if (NewSubPbActivity.this.eWT.aVW() == null || view != NewSubPbActivity.this.eWT.aVW().aSO()) {
                                            if ((view == NewSubPbActivity.this.eWT.aVQ() || view == NewSubPbActivity.this.eWT.aVV()) && NewSubPbActivity.this.checkUpIsLogin()) {
                                                if (NewSubPbActivity.this.dGN.DX()) {
                                                    NewSubPbActivity.this.dGN.DY();
                                                    return;
                                                } else {
                                                    NewSubPbActivity.this.dGN.gd(null);
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
                                        NewSubPbActivity.this.eWT.aBR();
                                        if (tag instanceof String) {
                                            String Dv = NewSubPbActivity.this.eWR.Dv();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.pp(Dv);
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
                                        NewSubPbActivity.this.eWT.aBR();
                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                            NewSubPbActivity.this.bj(view);
                                            return;
                                        }
                                        return;
                                    } else {
                                        NewSubPbActivity.this.showToast(d.l.network_not_available);
                                        return;
                                    }
                                }
                                NewSubPbActivity.this.eWT.aBR();
                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                if (sparseArray2 != null) {
                                    NewSubPbActivity.this.eWT.a(((Integer) sparseArray2.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.h.tag_del_post_id), ((Integer) sparseArray2.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.h.tag_del_post_is_self)).booleanValue());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(new aj("c11739").r("obj_locate", 1));
                            NewSubPbActivity.this.eWT.aBR();
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.dGN.gd(null);
                                if (NewSubPbActivity.this.eXf != null) {
                                    NewSubPbActivity.this.eXf.aVv();
                                }
                            }
                        } else {
                            TiebaStatic.log(new aj("c11739").r("obj_locate", 2));
                            NewSubPbActivity.this.eWT.aBR();
                            if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.eWR.aWb() != null) {
                                NewSubPbActivity.this.h(NewSubPbActivity.this.eWR.aWb().aQy());
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.eWT.aVI();
                        NewSubPbActivity.this.eWT.aVJ();
                        if (NewSubPbActivity.this.dGN != null) {
                            NewSubPbActivity.this.dGN.DZ();
                            if (NewSubPbActivity.this.eXf != null) {
                                NewSubPbActivity.this.eXf.aVv();
                            }
                        }
                    }
                }
            }
        };
        this.eWU = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.eWT.aBR();
                }
                NewSubPbActivity.this.dGN.DY();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.eWT.aVX();
            }
        };
        this.eKn = new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.eWR.aWb() != null) {
                    postData = NewSubPbActivity.this.eWR.aWb().aQy();
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
        this.awo = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
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
                    NewSubPbActivity.this.eWT.b(NewSubPbActivity.this.eKn, NewSubPbActivity.this.eWR.isMarked());
                }
                return true;
            }
        };
        this.eWV = new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void b(View view, String str) {
                NewSubPbActivity.this.j(null, str, "LINK_IMAGE");
            }
        };
        this.eWW = new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                    n aWb = NewSubPbActivity.this.eWR.aWb();
                    TbRichText ao = NewSubPbActivity.this.ao(str, i);
                    TbRichTextData tbRichTextData = null;
                    if (ao != null && ao.Io() != null) {
                        tbRichTextData = ao.Io().get(NewSubPbActivity.this.eKk);
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
                            if (aWb == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (aWb.aQE() != null) {
                                    str4 = aWb.aQE().getName();
                                    str5 = aWb.aQE().getId();
                                }
                                if (aWb.MF() != null) {
                                    str6 = aWb.MF().getId();
                                }
                                str3 = str6;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.eWR.aWr() != null) {
                                concurrentHashMap2 = NewSubPbActivity.this.eWR.aWr();
                                z4 = NewSubPbActivity.this.eWR.aWt();
                                arrayList2 = NewSubPbActivity.this.eWR.aWs();
                            } else {
                                concurrentHashMap2 = concurrentHashMap3;
                                arrayList2 = arrayList3;
                                z4 = z3;
                            }
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str4, str5, str3, z4, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                            return;
                        }
                        NewSubPbActivity.this.eKl = false;
                        String str7 = "";
                        TbRichText aBw = aWb.aQy().aBw();
                        int size = arrayList3.size();
                        int a2 = NewSubPbActivity.this.a(aBw, ao, i, i, arrayList3, concurrentHashMap3);
                        int size2 = arrayList3.size();
                        if (size != size2) {
                            str7 = arrayList3.get(size2 - 1);
                        }
                        String str8 = null;
                        String str9 = null;
                        String str10 = null;
                        if (aWb == null) {
                            str2 = null;
                            z = false;
                        } else {
                            if (aWb.aQE() != null) {
                                str8 = aWb.aQE().getName();
                                str9 = aWb.aQE().getId();
                            }
                            if (aWb.MF() != null) {
                                str10 = aWb.MF().getId();
                            }
                            str2 = str10;
                            z = true;
                        }
                        if (NewSubPbActivity.this.eWR.aWr() != null) {
                            concurrentHashMap = NewSubPbActivity.this.eWR.aWr();
                            z2 = NewSubPbActivity.this.eWR.aWt();
                            arrayList = NewSubPbActivity.this.eWR.aWs();
                            a2 += NewSubPbActivity.this.eWR.getOffset();
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
            this.eKl = true;
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
                        if (!this.eKl) {
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
        if (this.eWR == null || this.eWR.aWb() == null || str == null || i < 0) {
            return null;
        }
        n aWb = this.eWR.aWb();
        TbRichText a2 = a(aWb.aQy(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(aWb.aQy(), str, i);
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
        TbRichText aBw = postData.aBw();
        if (aBw != null) {
            ArrayList<TbRichTextData> Io = aBw.Io();
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
                        this.eKk = i3;
                        return aBw;
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
        long templateId = this.eWR.aWb().aQy().bto() != null ? this.eWR.aWb().aQy().bto().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && at.wf().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.eWR.aWb().aQE().getId(), this.eWR.aWb().aQE().getName(), this.eWR.aWb().MF().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i, String str) {
        if (this.eWR.aWc()) {
            showToast(str);
        } else if (k.hI()) {
            if (i == 4) {
                this.eWT.kq(str + "(4)");
            } else {
                this.eWT.gj(d.l.no_data_text);
            }
        } else {
            this.eWT.gj(d.l.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.dGN = (com.baidu.tbadk.editortools.pb.e) new f().aR(getActivity());
        this.dGN.a(getPageContext());
        this.dGN.b(this.eWR);
        this.dGN.b(this.eXh);
        this.dGN.a(this.aEf);
        this.dGN.Da().bE(true);
        this.dGN.g(getPageContext());
        if (this.eWT != null) {
            this.eWT.f(this.dGN);
        }
        if (this.dGN != null && this.eWR != null) {
            this.dGN.a(this.eWR.aBC());
            this.dGN.DY();
        }
    }

    public void aVC() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dGN.DY();
        } else if (!StringUtils.isNull(this.eWR.aWl())) {
            this.eWT.pI(this.eWR.aWl());
            if (this.eWT.aVM() && k.hI()) {
                this.eWT.adV();
            } else {
                this.eWT.aVP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(View view) {
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
                    this.eWT.bh(view);
                }
            } else if (booleanValue2) {
                this.eWT.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
            }
            g.a(this.eWT.aVU(), getPageContext().getPageActivity());
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
                        NewSubPbActivity.this.eWT.a(intValue, str2, sparseArray.get(d.h.tag_manage_user_identity) instanceof Integer ? ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue() : 0, sparseArray.get(d.h.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue() : false);
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
                        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str5, 1, str6, NewSubPbActivity.this.eXd);
                        userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.eXd);
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
        this.eWT.Rr();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.eXd;
        userMuteCheckCustomMessage.setTag(this.eXd);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.eWT.a(0, bVar.Co, bVar.glY, z);
            if (bVar.Co) {
                if (bVar.glW == 1) {
                    finish();
                } else if (bVar.glW == 2) {
                    this.eWR.pL(bVar.mPostId);
                    this.eWT.a(this.eWR.aWb(), this.eWR.aQb(), this.eWR.aWr() != null);
                    if (this.eWR.aWm()) {
                        this.eWR.ke(false);
                        this.eWT.aVK();
                        this.eWR.Fw();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void pp(String str) {
        if (!StringUtils.isNull(str) && this.eWR != null) {
            String threadID = this.eWR.getThreadID();
            String Dv = this.eWR.Dv();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Dv + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void h(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.eWR.isMarked() && postData.getId() != null && postData.getId().equals(this.eWR.aWj())) {
                z = true;
            }
            MarkData j = this.eWR.j(postData);
            if (j != null) {
                this.eWT.aBR();
                if (this.ech != null) {
                    this.ech.a(j);
                    if (!z) {
                        this.ech.nN();
                    } else {
                        this.ech.nM();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.eWR != null) {
            this.eWR.r(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dGN != null) {
            this.dGN.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cjJ != null) {
            this.cjJ.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.eXb = true;
        super.onPause();
        if (this.cjJ != null) {
            this.cjJ.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dko);
        this.eWT.ahy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eXb = false;
        super.onResume();
        if (this.cjJ != null) {
            this.cjJ.onResume(getPageContext());
        }
        registerListener(this.dko);
        this.eWT.ahz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cjJ != null) {
            this.cjJ.onStop(getPageContext());
        }
        this.dGN.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eWR.cancelLoadData();
        this.eWR.destory();
        this.eWS.cancelLoadData();
        if (this.cjJ != null) {
            this.cjJ.onDestory(getPageContext());
        }
        this.eWT.aBR();
        this.eWT.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.eJY);
        MessageManager.getInstance().unRegisterListener(this.eJZ);
        MessageManager.getInstance().unRegisterListener(this.eKa);
        MessageManager.getInstance().unRegisterListener(this.eXd);
        this.eJA = null;
        this.eJB = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eWT.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cjJ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aVQ = this.eWT.aVQ();
        if (aVQ == null || (findViewWithTag = aVQ.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean pD(String str) {
        Map<String, String> ee;
        if (!TextUtils.isEmpty(str) && (ee = at.ee(at.ef(str))) != null) {
            this.eXe = true;
            String str2 = ee.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pD(com.baidu.adp.lib.util.j.aR(str2));
            }
            String str3 = ee.get(eWQ);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (pD(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            at.wf().c(getPageContext(), new String[]{str});
            this.eXe = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eXe = true;
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
        if (this.eWT != null) {
            return this.eWT.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int IR() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> IT() {
        if (this.aRv == null) {
            this.aRv = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aRv;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> IU() {
        if (this.aRz == null) {
            this.aRz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aRG */
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
        return this.aRz;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> IS() {
        if (this.aRu == null) {
            this.aRu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: TO */
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
        return this.aRu;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IV() {
        if (this.aRx == null) {
            this.aRx = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: amH */
                public View fT() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.f.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: at */
                public void o(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: au */
                public View p(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: av */
                public View q(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.aRx;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> IW() {
        if (this.aRy == null) {
            this.aRy = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aRH */
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
        return this.aRy;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IX() {
        if (this.aRw == null) {
            this.aRw = com.baidu.tieba.graffiti.c.p(getPageContext().getPageActivity(), 8);
        }
        return this.aRw;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eWT.aVM() && k.hI()) {
            this.eWR.Fw();
        } else {
            this.eWT.aVP();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.eXd);
        userMuteAddAndDelCustomMessage.setTag(this.eXd);
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
        if (pageStayDurationItem != null && this.eWR != null) {
            if (this.eWR.aWb() != null && this.eWR.aWb().aQE() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.eWR.aWb().aQE().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.eWR.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean Zx() {
        return this.eXb;
    }

    public boolean aVD() {
        if (this.eWR != null) {
            return this.eWR.aVD();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eWT.Rr();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eJA.getPageActivity());
        if (al.isEmpty(str)) {
            aVar.cT(this.eJA.getResources().getString(d.l.block_mute_message_alert, str2));
        } else {
            aVar.cT(str);
        }
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.eWT.Rr();
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
        aVar.b(this.eJA).tr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eJA.getPageActivity());
        aVar.cT(str);
        aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eJA).tr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cT(getResources().getString(d.l.mute_is_super_member_function));
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.eJA).showToast(d.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.eJA.getPageActivity(), 2, true, 4);
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
        aVar.b(this.eJA).tr();
    }

    public String getThreadId() {
        if (this.eWR != null) {
            return this.eWR.getThreadID();
        }
        return null;
    }

    public String getPostId() {
        if (this.eWR != null) {
            return this.eWR.Dv();
        }
        return null;
    }

    public int aQb() {
        if (this.eWR != null) {
            return this.eWR.aQb();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eXg) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eXg) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }
}
