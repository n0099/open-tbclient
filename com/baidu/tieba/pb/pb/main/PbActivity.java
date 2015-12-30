package com.baidu.tieba.pb.pb.main;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.cf;
import com.baidu.tieba.tbadkCore.f.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.i;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, com.baidu.tbadk.widget.richText.l {
    public static boolean cEZ = false;
    private static String cFg = "tbgametype";
    private com.baidu.adp.lib.f.b<ImageView> aEW;
    private com.baidu.adp.lib.f.b<TextView> aEX;
    private com.baidu.adp.lib.f.b<View> aEY;
    private com.baidu.adp.lib.f.b<LinearLayout> aEZ;
    private com.baidu.adp.lib.f.b<GifView> aFa;
    private com.baidu.adp.lib.f.b<TbImageView> agI;
    private String cEO;
    private com.baidu.tbadk.core.dialog.a cFi;
    private cm cFu;
    private boolean cFv;
    private com.baidu.tieba.tbadkCore.data.e cFw;
    private com.baidu.tbadk.editortools.d.e cFx;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private VoiceManager mVoiceManager;
    private boolean cFa = false;
    private boolean cBJ = false;
    private com.baidu.tbadk.core.dialog.a cFb = null;
    private String cFc = null;
    private String aYr = null;
    private String cFd = null;
    private String cFe = null;
    private String mPackageName = null;
    private int cFf = 0;
    private com.baidu.tbadk.core.dialog.c cFh = null;
    SparseArray<String> bdF = null;
    private long aUp = -1;
    private long azV = 0;
    private long createTime = 0;
    private long azW = 0;
    private boolean cFj = false;
    private com.baidu.tbadk.performanceLog.e cFk = null;
    private String auj = null;
    private final Handler mHandler = new Handler(new d(this));
    private cf cFl = null;
    private com.baidu.tbadk.baseEditMark.a cFm = null;
    private com.baidu.tieba.tbadkCore.f.a cFn = null;
    private UserMuteAddAndDelModel cFo = null;
    private com.baidu.tieba.usermute.i cFp = null;
    private dk cFq = null;
    public final com.baidu.tieba.pb.pb.main.a.a cFr = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean cFs = false;
    private boolean cFt = false;
    private boolean bcZ = false;
    private com.baidu.tbadk.editortools.d.c aun = new o(this);
    private CustomMessageListener bpm = new z(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener bcb = new ak(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener cFy = new av(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener cFz = new be(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener richTextIntentClickListener = new bg(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private HttpMessageListener cFA = new bh(this, CmdConfigHttp.PB_LOTTERY_HTTP_CMD);
    private cf.b cFB = new br(this);
    private View.OnClickListener cFC = new e(this);
    private CustomMessageListener cFD = new f(this, CmdConfigCustom.CMD_SEND_GIFT_SUCCESS);
    private boolean bbT = false;
    private com.baidu.tieba.tbadkCore.af bce = new com.baidu.tieba.tbadkCore.af(getPageContext(), new g(this));
    private long bco = 0;
    private boolean bcp = true;
    private com.baidu.tieba.pb.b.c cDu = new com.baidu.tieba.pb.b.c(new h(this));
    private UserMuteAddAndDelModel.a cFE = new i(this);
    private i.a cFF = new j(this);
    public a.b cyi = new k(this);
    public final View.OnClickListener bgT = new l(this);
    private final a.d aut = new m(this);
    private final cf.c cFG = new n(this);
    private final a.InterfaceC0040a cFH = new p(this);
    private final AbsListView.OnScrollListener Ik = new q(this);
    private final com.baidu.adp.base.g cFI = new r(this);
    private final b cFJ = new s(this);
    private final r.a aKt = new t(this);
    private final BdListView.e cFK = new u(this);
    private final BdListView.h cFL = new v(this);
    private int cFM = 0;
    private final TbRichTextView.d aFq = new w(this);
    boolean cFN = false;
    com.baidu.tieba.tbadkCore.data.r cFO = null;
    private final c.b cFP = new x(this);
    private final View.OnLongClickListener amQ = new y(this);
    private final NoNetworkView.a bbw = new aa(this);
    private String cFQ = null;
    private final cf.a cFR = new ab(this);

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* loaded from: classes.dex */
    public interface b {
        void fa(boolean z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.d.e alf() {
        return this.cFx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km(int i) {
        if (this.cFl != null && this.cFl.getPbData() != null && this.cFl.getPbData().akG() != null) {
            this.cFl.getPbData().akG().setLike(i);
            com.baidu.tieba.tbadkCore.y yVar = new com.baidu.tieba.tbadkCore.y();
            yVar.setLike(i);
            yVar.gO(-1);
            yVar.setLevelName("");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, yVar));
        }
    }

    public void b(com.baidu.tieba.pb.a.d dVar) {
        if (dVar.akS() != null) {
            String id = dVar.akS().getId();
            ArrayList<com.baidu.tieba.tbadkCore.data.r> akI = this.cFl.getPbData().akI();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= akI.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.r rVar = akI.get(i2);
                if (rVar.getId() == null || !rVar.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.data.r> akW = dVar.akW();
                    rVar.mX(dVar.getTotalCount());
                    if (rVar.aFm() != null) {
                        rVar.aFm().clear();
                        rVar.aFm().addAll(akW);
                    }
                }
            }
            this.cFq.i(this.cFl.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alg() {
        com.baidu.tieba.pb.a.c pbData;
        com.baidu.tbadk.core.data.z akH;
        if (!this.bbT) {
            if (!com.baidu.adp.lib.util.k.jh()) {
                showToast(n.j.no_network_guide);
            } else if (this.bcp) {
                this.bbT = true;
                if (this.cFl != null && (pbData = this.cFl.getPbData()) != null && (akH = pbData.akH()) != null) {
                    int isLike = akH.getPraise() == null ? 0 : akH.getPraise().getIsLike();
                    if (this.bce != null) {
                        this.bce.a(akH.sD(), akH.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        if ((sparseArray.get(n.g.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(n.g.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(n.g.tag_check_mute_from) instanceof Integer)) {
            String str = (String) sparseArray.get(n.g.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(n.g.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
                cVar.bJ(n.j.operation);
                int i = -1;
                if (sparseArray.get(n.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(n.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(n.j.delete);
                    strArr[1] = z ? getResources().getString(n.j.un_mute) : getResources().getString(n.j.mute);
                    cVar.a(strArr, new ac(this, sparseArray, z, str));
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(n.j.un_mute) : getResources().getString(n.j.mute);
                    cVar.a(strArr2, new ad(this, sparseArray, z, str));
                }
                cVar.d(getPageContext()).tj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(int i) {
        com.baidu.tbadk.core.data.z akH;
        String sb;
        String x;
        if (this.cFl != null && this.cFl.getPbData() != null && (akH = this.cFl.getPbData().akH()) != null) {
            if (i == 1) {
                PraiseData praise = akH.getPraise();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (praise == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        akH.setPraise(praiseData);
                    } else {
                        akH.getPraise().getUser().add(0, metaData);
                        akH.getPraise().setNum(akH.getPraise().getNum() + 1);
                        akH.getPraise().setIsLike(i);
                    }
                }
                if (akH.getPraise() != null) {
                    if (akH.getPraise().getNum() < 1) {
                        x = getResources().getString(n.j.frs_item_praise_text);
                    } else {
                        x = com.baidu.tbadk.core.util.ax.x(akH.getPraise().getNum());
                    }
                    this.cFq.D(x, true);
                }
            } else if (akH.getPraise() != null) {
                akH.getPraise().setIsLike(i);
                akH.getPraise().setNum(akH.getPraise().getNum() - 1);
                ArrayList<MetaData> user = akH.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            akH.getPraise().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (akH.getPraise().getNum() < 1) {
                    sb = getResources().getString(n.j.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(akH.getPraise().getNum())).toString();
                }
                this.cFq.D(sb, false);
            }
            if (this.cFl.alM()) {
                this.cFq.amE().notifyDataSetChanged();
            } else {
                this.cFq.j(this.cFl.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cFl.saveToBundle(bundle);
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.cFx.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.aUp = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aUp = System.currentTimeMillis();
        }
        this.cFf = 0;
        g(bundle);
        initUI();
        this.cFq.cIi = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.d.n nVar = new com.baidu.tbadk.editortools.d.n();
        nVar.setForumName(this.cFl.alL());
        if (this.cFl.getPbData() != null && this.cFl.getPbData().akG() != null) {
            nVar.setForumId(this.cFl.getPbData().akG().getId());
        }
        nVar.setFrom("pb");
        nVar.a(this.cFl);
        this.cFx = (com.baidu.tbadk.editortools.d.e) nVar.ak(getActivity());
        this.cFx.d(this);
        this.cFx.a(this.aut);
        this.cFx.a(this.aun);
        this.cFx.a(this, bundle);
        this.cFx.Bj().c(new com.baidu.tbadk.editortools.x(getActivity()));
        eV(true);
        this.cFq.setEditorTools(this.cFx.Bj());
        this.cFx.a(this.cFl.alT(), this.cFl.getThreadID(), this.cFl.alI());
        registerListener(this.bcb);
        if (!this.cFl.alQ()) {
            this.cFx.ft(this.cFl.getThreadID());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.aUp;
        registerListener(this.bpm);
        registerListener(this.cFy);
        registerListener(this.cFz);
        this.cFA.setSelfListener(true);
        registerListener(this.cFA);
        this.cFw = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.dGC);
        this.cFw.aEO();
        registerListener(this.cFD);
        if (this.cFl != null) {
            this.cFl.amd();
        }
    }

    private void eV(boolean z) {
        this.cFx.bl(z);
        this.cFx.bm(z);
        this.cFx.bn(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStart(getPageContext());
        }
    }

    public dk alh() {
        return this.cFq;
    }

    public cf ali() {
        return this.cFl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.cFa = true;
        super.onPause();
        BdListView listView = getListView();
        this.cFf = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.cFf == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
        if (this.cFq != null) {
            this.cFq.onPause();
        }
        if (!this.cFl.alQ()) {
            this.cFx.fs(this.cFl.getThreadID());
        }
        MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.cFa = false;
        super.onResume();
        if (this.cFq != null && this.cFq.getView() != null) {
            if (!this.cBJ) {
                showLoadingView(this.cFq.getView(), true);
            } else {
                hideLoadingView(this.cFq.getView());
            }
        }
        if (this.cFf == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.cFq != null) {
            noNetworkView = this.cFq.amx();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.iQ()) {
            noNetworkView.aw(false);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
        registerListener(this.richTextIntentClickListener);
        this.cFv = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.cFq.fm(z);
        if (this.cFu != null) {
            this.cFu.fg(z);
        }
        if (z && this.cFv) {
            this.cFq.amL();
            this.cFl.fc(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cFx != null && this.cFx.Bj() != null && this.cFx.Bj().getVisibility() != 0) {
            this.cFx.BX();
        }
        if (this.cFq.cIl != null && !this.cFq.cIl.anp()) {
            this.cFq.cIl.afQ();
        }
        if (this.cFl != null && this.cFl.getPbData() != null && this.cFl.getPbData().akG() != null && this.cFl.getPbData().akH() != null) {
            com.baidu.tbadk.distribute.a.AV().a(getPageContext().getPageActivity(), "pb", this.cFl.getPbData().akG().getId(), com.baidu.adp.lib.h.b.c(this.cFl.getPbData().akH().getId(), 0L));
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
        if (this.cFl != null) {
            this.cFl.ame();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (!this.cFj) {
            this.cFj = true;
            this.cFq.and();
        }
        this.cFp.onDestroy();
        this.cFl.cancelLoadData();
        this.cFl.destory();
        this.cFx.onDestroy();
        this.cFn.cancelLoadData();
        this.cFq.onDestroy();
        if (this.cFq.cIl != null) {
            this.cFq.cIl.afQ();
        }
        if (this.cFk != null) {
            this.cFk.onDestroy();
        }
        super.onDestroy();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cFq.onChangeSkinType(i);
        if (this.cFx != null && this.cFx.Bj() != null) {
            this.cFx.Bj().onChangeSkinType(i);
        }
        if (this.cFq.amx() != null) {
            this.cFq.amx().onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alj() {
        this.cFu = new cm(getPageContext(), this.bgT);
        this.cFu.fg(this.mIsLogin);
    }

    private void initUI() {
        this.cFq = new dk(this, this.bgT, this.cDu);
        this.cFq.setOnScrollListener(this.Ik);
        this.cFq.c(this.cFK);
        this.cFq.a(this.cFL);
        this.cFq.a(this.aKt);
        this.cFq.eS(com.baidu.tbadk.core.m.qQ().qW());
        this.cFq.eU(com.baidu.tbadk.core.m.qQ().qS());
        this.cFq.setOnImageClickListener(this.aFq);
        this.cFq.a(this.amQ);
        this.cFq.f(this.bbw);
        this.cFq.a(this.cFJ);
        this.cFq.fm(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ah(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(n.g.tag_clip_board);
            if (obj instanceof com.baidu.tieba.tbadkCore.data.r) {
                com.baidu.tieba.tbadkCore.data.r rVar = (com.baidu.tieba.tbadkCore.data.r) obj;
                if (TextUtils.isEmpty(rVar.getBimg_url()) || !com.baidu.tbadk.core.m.qQ().qW()) {
                    return false;
                }
                return kB(rVar.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.cFq != null) {
            if (z && !this.cBJ) {
                showLoadingView(this.cFq.getView(), true);
            } else {
                hideLoadingView(this.cFq.getView());
            }
        }
    }

    private void alk() {
        if (this.cFh == null) {
            this.cFh = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.cFh.a(new String[]{getPageContext().getString(n.j.call_phone), getPageContext().getString(n.j.sms_phone), getPageContext().getString(n.j.search_in_baidu)}, new ae(this)).bK(c.a.Yo).bL(17).d(getPageContext());
        }
    }

    private void g(Bundle bundle) {
        this.cFl = new cf(this);
        this.cFl.a(this.cFG);
        this.cFl.a(this.cFR);
        this.cFl.a(this.cFB);
        this.cFl.amb();
        if (bundle != null) {
            this.cFl.initWithBundle(bundle);
        } else {
            this.cFl.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra("request_code", -1) == 18003) {
            this.cFl.ff(true);
        }
        dd.amq().C(this.cFl.alK(), this.cFl.getIsFromMark());
        if (StringUtils.isNull(this.cFl.getThreadID())) {
            finish();
        } else {
            this.cFl.Dy();
        }
    }

    private void initData(Bundle bundle) {
        this.cFm = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.cFm != null) {
            this.cFm.a(this.cFH);
        }
        this.cFn = new com.baidu.tieba.tbadkCore.f.a(this);
        this.cFn.setLoadDataCallBack(this.cFI);
        this.cFo = new UserMuteAddAndDelModel(getPageContext());
        this.cFo.a(this.cFE);
        this.cFp = new com.baidu.tieba.usermute.i(getPageContext(), this.cFF);
        this.cFq.a(new af(this));
        this.bce.setUniqueId(getUniqueId());
        this.bce.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = (String) sparseArray.get(n.g.tag_user_mute_mute_userid);
        this.cFq.adL();
        this.cFp.a(com.baidu.adp.lib.h.b.c(currentAccount, 0L), com.baidu.adp.lib.h.b.c(str, 0L), sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int all() {
        if (this.cFl.getPbData() == null || this.cFl.getPbData().akH() == null) {
            return -1;
        }
        return this.cFl.getPbData().akH().sI();
    }

    public boolean eW(boolean z) {
        return z && this.cFq.amQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eX(boolean z) {
        if (this.cFl == null || this.cFl.getPbData() == null) {
            return false;
        }
        return ((this.cFl.getPbData().akL() != 0) || this.cFl.getPbData().akH() == null || this.cFl.getPbData().akH().getAuthor() == null || TextUtils.equals(this.cFl.getPbData().akH().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void alm() {
        if (this.cFl != null && this.cFl.getPbData() != null && this.cFl.getPbData().akH() != null && this.cFl.getPbData().akH().getAuthor() != null) {
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.cFl.getPbData().akH().getAuthor().getUserId());
            this.cFq.cIl.a(this.cFl.alM(), this.cFm != null ? this.cFm.pN() : false, eX(equals), eW(equals));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.tbadkCore.data.r rVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (rVar = (com.baidu.tieba.tbadkCore.data.r) sparseArray.get(n.g.tag_clip_board)) != null) {
            c(rVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        alw();
    }

    public void a(boolean z, MarkData markData) {
        this.cFq.amN();
        this.cFl.fe(z);
        if (this.cFm != null) {
            this.cFm.Y(z);
            if (markData != null) {
                this.cFm.a(markData);
            }
        }
        if (this.cFl.pN()) {
            alr();
        } else {
            this.cFq.i(this.cFl.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kv(String str) {
        if (!StringUtils.isNull(str) && this.cFl != null) {
            String threadID = this.cFl.getThreadID();
            String id = this.cFl.getPbData().akG().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(n.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.cFl.alQ()) {
                    antiData.setBlock_forum_name(this.cFl.getPbData().akG().getName());
                    antiData.setBlock_forum_id(this.cFl.getPbData().akG().getId());
                    antiData.setUser_name(this.cFl.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.cFl.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.e.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.ne(i)) {
            AntiHelper.Q(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            this.cFo.fy(str);
        } else {
            this.cFq.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        int i = 0;
        if (bVar != null) {
            this.cFq.a(0, bVar.Av, bVar.dJa, true);
            if (bVar.Av) {
                if (bVar.dIY == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.r> akI = this.cFl.getPbData().akI();
                    int size = akI.size();
                    while (true) {
                        if (i < size) {
                            if (!bVar.mPostId.equals(akI.get(i).getId())) {
                                i++;
                            } else {
                                akI.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.cFq.i(this.cFl.getPbData());
                } else if (bVar.dIY == 0) {
                    aln();
                } else if (bVar.dIY == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.r> akI2 = this.cFl.getPbData().akI();
                    int size2 = akI2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < akI2.get(i2).aFm().size()) {
                                if (!bVar.mPostId.equals(akI2.get(i2).aFm().get(i3).getId())) {
                                    i3++;
                                } else {
                                    akI2.get(i2).aFm().remove(i3);
                                    akI2.get(i2).aFo();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData akO = this.cFl.getPbData().akO();
                        com.baidu.tieba.tbadkCore.data.r rVar = akI2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.data.r> aFp = rVar.aFp();
                        int size3 = aFp.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!bVar.mPostId.equals(akI2.get(i2).aFp().get(i4).getId())) {
                                    i4++;
                                } else {
                                    aFp.remove(i4);
                                    akO.decreaseAlreadyCount();
                                    if (rVar.aFw() > aFp.size()) {
                                        rVar.mZ(aFp.size());
                                    }
                                    if (aFp.size() > 0) {
                                        com.baidu.tieba.tbadkCore.data.r rVar2 = aFp.get(aFp.size() - 1);
                                        akO.setLastAdditionTime(rVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a aFr = rVar2.aFr();
                                        String str = "";
                                        if (aFr != null) {
                                            str = aFr.toString();
                                        }
                                        akO.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a aFr2 = rVar.aFr();
                                        String str2 = "";
                                        if (aFr2 != null) {
                                            str2 = aFr2.toString();
                                        }
                                        akO.setLastAdditionContent(str2);
                                    }
                                    alx();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.cFq.i(this.cFl.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.d dVar) {
        this.cFq.a(1, dVar.Av, dVar.dJa, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.f fVar) {
        this.cFq.a(this.cFn.getLoadDataMode(), fVar.Av, fVar.dJa, false);
        this.cFq.W(fVar.dJc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, a.f fVar) {
        if (fVar != null) {
            this.cFq.a(this.cFn.getLoadDataMode(), fVar.Av, fVar.dJa, true);
            if (fVar.Av) {
                this.cFt = true;
                if (i == 2) {
                    this.cFl.getPbData().akH().bD(1);
                    this.cFl.setIsGood(1);
                } else if (i == 3) {
                    this.cFl.getPbData().akH().bD(0);
                    this.cFl.setIsGood(0);
                } else if (i == 4) {
                    this.cFl.getPbData().akH().bC(1);
                    this.cFl.kp(1);
                } else if (i == 5) {
                    this.cFl.getPbData().akH().bC(0);
                    this.cFl.kp(0);
                }
                this.cFq.a(this.cFl.getPbData(), this.cFl.alM(), true);
            }
        }
    }

    private void aln() {
        if (this.cFl.alN()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.cFl.getThreadID());
            setResult(-1, intent);
        }
        if (als()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alo() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.cFq != null) {
            this.cFq.ana();
        }
        if (this.cFl != null && this.cFl.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.cFl.getPbData().akH().getId();
            historyMessage.forumName = this.cFl.getPbData().akG().getName();
            historyMessage.threadName = this.cFl.getPbData().akH().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.data.r> akI = this.cFl.getPbData().akI();
            int amP = this.cFq != null ? this.cFq.amP() : 0;
            if (akI != null && amP >= 0 && amP < akI.size()) {
                historyMessage.postID = akI.get(amP).getId();
            }
            historyMessage.isHostOnly = this.cFl.getHostMode();
            historyMessage.isSquence = this.cFl.alM();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.cFl != null && this.cFl.alN()) {
            Intent intent = new Intent();
            if (this.cFt) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.cFl.getThreadID());
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.cFl.alP());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.cFl.getIsGood());
            }
            setResult(-1, intent);
        }
        if (als()) {
            if (this.cFl != null && this.cFq != null && this.cFq.getListView() != null) {
                com.baidu.tieba.pb.a.c pbData = this.cFl.getPbData();
                if (pbData != null && pbData.getUserData() != null) {
                    pbData.getUserData().setBimg_url(TbadkCoreApplication.m411getInst().getDefaultBubble());
                }
                dd.amq().a(this.cFl.getPbData(), this.cFq.getListView().onSaveInstanceState(), this.cFl.alM(), this.cFl.getHostMode());
            } else {
                dd.amq().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                finish();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kn(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(n.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.cFx.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    alq();
                    return;
                case 13008:
                    dd.amq().reset();
                    this.mHandler.postDelayed(new ag(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.cFl != null) {
                        a(alp(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    M(intent);
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12002:
                if (intent != null && alh() != null && alf() != null && alh().amA() && com.baidu.tbadk.editortools.d.b.BK().getStatus() == 1) {
                    com.baidu.tbadk.editortools.d.b.BK().setStatus(0);
                    if (this.cFq != null) {
                        this.cFq.amz();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private ShareFromPBMsgData alp() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] aD = this.cFl.getPbData().aD(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.data.r amB = this.cFq.amB();
        String str = "";
        if (amB != null) {
            str = amB.getId();
            String aS = amB.aS(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(aS)) {
                aD[1] = aS;
            }
        }
        String sD = this.cFl.getPbData().akH().sD();
        if (sD != null && sD.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(aD[1]);
        shareFromPBMsgData.setImageUrl(aD[0]);
        shareFromPBMsgData.setForumName(this.cFl.getPbData().akG().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.cFl.getPbData().akH().getId());
        shareFromPBMsgData.setTitle(this.cFl.getPbData().akH().getTitle());
        return shareFromPBMsgData;
    }

    private void M(Intent intent) {
        a(alp(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.cFl != null && this.cFl.getPbData() != null && this.cFl.getPbData().akH() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            ep epVar = new ep(getPageContext().getPageActivity());
            epVar.setData(shareFromPBMsgData);
            aVar.bI(1);
            aVar.m(epVar);
            aVar.a(n.j.share, new ah(this, epVar, j, str, str2, shareFromPBMsgData));
            aVar.b(n.j.alert_no_button, new ai(this, epVar));
            aVar.aj(true);
            aVar.b(getPageContext()).tf();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                epVar.x(shareFromPBMsgData.getImageUrl(), this.cFl.getPbData().akM() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.cFl != null && this.cFl.getPbData() != null && this.cFl.getPbData().akH() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            ep epVar = new ep(getPageContext().getPageActivity());
            epVar.setData(shareFromPBMsgData);
            aVar.bI(1);
            aVar.m(epVar);
            aVar.a(n.j.share, new aj(this, epVar, i, str, j, shareFromPBMsgData));
            aVar.b(n.j.alert_no_button, new al(this, epVar));
            aVar.aj(true);
            aVar.b(getPageContext()).tf();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                epVar.x(shareFromPBMsgData.getImageUrl(), this.cFl.getPbData().akM() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alq() {
        MarkData kw;
        if (this.cFm != null && (kw = this.cFl.kw(this.cFq.amP())) != null) {
            if (!kw.isApp() || (kw = this.cFl.kw(this.cFq.amP() + 1)) != null) {
                this.cFq.amJ();
                this.cFm.a(kw);
                if (!this.cFm.pN()) {
                    this.cFm.pP();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.cFm.pO();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alr() {
        com.baidu.tieba.pb.a.c pbData = this.cFl.getPbData();
        this.cFl.fe(true);
        pbData.kt(this.cFm.pM());
        this.cFq.i(pbData);
    }

    private boolean als() {
        if (this.cFl == null) {
            return true;
        }
        if (this.cFl.pN()) {
            MarkData alX = this.cFl.alX();
            if (alX == null || !this.cFl.getIsFromMark()) {
                return true;
            }
            MarkData kw = this.cFl.kw(this.cFq.amP());
            if (kw == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, alX);
                setResult(-1, intent);
                return true;
            } else if (kw.getPostId() == null || kw.getPostId().equals(alX.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, alX);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cF(String.format(getPageContext().getString(n.j.alert_update_mark), Integer.valueOf(kw.getFloor())));
                aVar.a(n.j.alert_yes_btn, new am(this, kw, alX, aVar));
                aVar.b(n.j.alert_no_button, new an(this, alX, aVar));
                aVar.a(new ao(this, alX, aVar));
                aVar.b(getPageContext());
                aVar.tf();
                return false;
            }
        } else if (this.cFl.getPbData() == null || this.cFl.getPbData().akI() == null || this.cFl.getPbData().akI().size() <= 0 || !this.cFl.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.cFq == null) {
            return null;
        }
        return this.cFq.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public int getRichTextViewId() {
        if (this.cFq == null) {
            return 0;
        }
        return this.cFq.amU();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vU() {
        if (this.cFq == null) {
            return 0;
        }
        return this.cFq.Oc();
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<ImageView> getImageViewPool() {
        if (this.aEW == null) {
            this.aEW = new com.baidu.adp.lib.f.b<>(new ap(this), 8, 0);
        }
        return this.aEW;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<TextView> getTextViewPool() {
        if (this.aEX == null) {
            this.aEX = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.aEX;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<GifView> getGifViewPool() {
        if (this.aFa == null) {
            this.aFa = new com.baidu.adp.lib.f.b<>(new aq(this), 20, 0);
        }
        return this.aFa;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<View> getVoiceViewPool() {
        if (this.aEY == null) {
            this.aEY = new com.baidu.adp.lib.f.b<>(new ar(this), 8, 0);
        }
        return this.aEY;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> vV() {
        if (this.agI == null) {
            this.agI = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.agI;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    public boolean kw(String str) {
        Map<String, String> dE;
        if (!TextUtils.isEmpty(str) && (dE = com.baidu.tbadk.core.util.bf.dE(com.baidu.tbadk.core.util.bf.dF(str))) != null) {
            String str2 = dE.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return kw(com.baidu.adp.lib.util.j.aU(str2));
            }
            String str3 = dE.get(cFg);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onLinkClicked(Context context, String str) {
        P(context, str);
    }

    private void P(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (ky(str) || z) {
                boolean v = com.baidu.adp.lib.util.k.v(context, "com.qiyi.video");
                kz(str);
                if (v) {
                    alt();
                } else {
                    alu();
                }
            } else if (kw(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else if (kx(str)) {
                com.baidu.tbadk.core.util.bf.vn().a(getPageContext(), new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.bf.vn().b(getPageContext(), new String[]{str});
            }
        }
    }

    private boolean kx(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }

    private boolean ky(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }

    private void kz(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.cFd = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.cFe = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.aYr = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.cFc = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void alt() {
        if (TextUtils.isEmpty(this.cFd) || TextUtils.isEmpty(this.cFe) || TextUtils.isEmpty(this.mPackageName)) {
            if (!TextUtils.isEmpty(this.cFc)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.cFc);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(this.cFd));
        intent.setAction(this.cFe);
        intent.setPackage(this.mPackageName);
        if (intent.resolveActivity(getPageContext().getPageActivity().getPackageManager()) != null) {
            if (!com.baidu.adp.lib.h.i.e(getPageContext().getPageActivity(), intent) && !TextUtils.isEmpty(this.cFc)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.cFc);
            }
        } else if (!TextUtils.isEmpty(this.cFc)) {
            com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.cFc);
        }
    }

    private void alu() {
        if (!com.baidu.adp.lib.util.i.iR()) {
            if (!TextUtils.isEmpty(this.cFc)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.cFc);
                return;
            }
            return;
        }
        if (this.cFb == null) {
            this.cFb = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.cFb.bG(n.j.download_iqiyi_app_dialog);
            this.cFb.a(n.j.install_app, new as(this));
            this.cFb.b(n.j.webpage_play, new at(this));
            this.cFb.aj(false);
        }
        this.cFb.b(getPageContext()).tf();
    }

    private com.baidu.tbadk.core.dialog.a alv() {
        if (this.cFi == null) {
            this.cFi = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.cFi.cE(getPageContext().getString(n.j.download_baidu_video_dialog));
            this.cFi.a(getPageContext().getString(n.j.install), new au(this));
            this.cFi.b(getPageContext().getString(n.j.cancel), new aw(this));
            this.cFi.ai(true);
            this.cFi.b(getPageContext());
            this.cFi.aj(false);
        }
        this.cFi.tf();
        return this.cFi;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onVideoClicked(Context context, String str) {
        P(context, str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onVideoP2PClicked(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra("title", "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            alv();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onSongClicked(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.FF() == null) {
            return null;
        }
        return cVar.FF().FS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long c(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.FF() == null) {
            return 0L;
        }
        return cVar.FF().getOriginalSize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.f FF;
        if (aVar == aVar2) {
            this.cFN = true;
        }
        if (aVar != null) {
            int size = aVar.FA().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.FA().get(i6) == null || aVar.FA().get(i6).getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int width = aVar.FA().get(i6).FF().getWidth();
                    int height = aVar.FA().get(i6).FF().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.FA().get(i6).FF().FP()) {
                        if (aVar == aVar2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.FA().get(i6);
                        String d = d(cVar);
                        arrayList.add(d);
                        if (!TextUtils.isEmpty(d) && cVar != null && (FF = cVar.FF()) != null) {
                            String FQ = FF.FQ();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = FQ;
                            int i9 = this.mIsFromCDN ? 17 : 18;
                            imageUrlData.urlType = i9;
                            imageUrlData.urlType = i9;
                            imageUrlData.originalUrl = b(cVar);
                            imageUrlData.originalSize = c(cVar);
                            imageUrlData.postId = aVar.getPostId();
                            imageUrlData.threadId = com.baidu.adp.lib.h.b.c(this.cFl.getThreadID(), -1L);
                            imageUrlData.mIsReserver = this.cFl.alW();
                            imageUrlData.mIsSeeHost = this.cFl.getHostMode();
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(d, imageUrlData);
                            }
                        }
                        if (!this.cFN) {
                            i4 = i7 + 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    }
                }
                i6++;
                i7 = i4;
                i5 = i3;
            }
            return i7;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tieba.tbadkCore.data.r rVar, int i, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        ArrayList<com.baidu.tieba.tbadkCore.data.j> aER;
        if (rVar != null && arrayList != null && concurrentHashMap != null && (aER = rVar.aFA().aER()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == aER.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = aER.get(i3);
                if (jVar != null) {
                    String aEW = jVar.aEW();
                    if (!com.baidu.tbadk.core.util.ax.isEmpty(aEW)) {
                        arrayList.add(aEW);
                        if (!this.cFN) {
                            i++;
                        }
                    }
                }
                i2 = i3 + 1;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tieba.tbadkCore.data.r rVar) {
        if (rVar != null) {
            boolean z = false;
            if (rVar.getId() != null && rVar.getId().equals(this.cFl.sz())) {
                z = true;
            }
            MarkData d = this.cFl.d(rVar);
            if (d != null) {
                this.cFq.amJ();
                if (this.cFm != null) {
                    this.cFm.a(d);
                    if (!z) {
                        this.cFm.pP();
                    } else {
                        this.cFm.pO();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a ac(String str, int i) {
        if (this.cFl == null || this.cFl.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.a.c pbData = this.cFl.getPbData();
        com.baidu.tbadk.widget.richText.a a2 = a(pbData.akI(), str, i);
        if (a2 == null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.r> akI = pbData.akI();
            int size = akI.size();
            for (int i2 = 0; i2 < size; i2++) {
                a2 = a(akI.get(i2).aFp(), str, i);
                if (a2 != null) {
                    return a2;
                }
            }
            return a2;
        }
        return a2;
    }

    private long kA(String str) {
        ArrayList<com.baidu.tieba.tbadkCore.data.r> akI;
        com.baidu.tieba.pb.a.c pbData = this.cFl.getPbData();
        if (pbData != null && (akI = pbData.akI()) != null && !akI.isEmpty()) {
            Iterator<com.baidu.tieba.tbadkCore.data.r> it = akI.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.r next = it.next();
                com.baidu.tieba.tbadkCore.data.h aFA = next.aFA();
                if (aFA != null && aFA.dGJ) {
                    Iterator<com.baidu.tbadk.widget.richText.c> it2 = next.aFr().FA().iterator();
                    while (it2.hasNext()) {
                        com.baidu.tbadk.widget.richText.c next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.FN().getLink().equals(str)) {
                            return aFA.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.data.r> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> FA;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a aFr = arrayList.get(i2).aFr();
            if (aFr != null && (FA = aFr.FA()) != null) {
                int size = FA.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (FA.get(i4) != null && FA.get(i4).getType() == 8) {
                        i3++;
                        if (FA.get(i4).FF().FQ().equals(str)) {
                            int width = FA.get(i4).FF().getWidth();
                            int height = FA.get(i4).FF().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.cFM = i4;
                            return aFr;
                        } else if (i3 <= i) {
                        }
                    }
                    i4++;
                    i3 = i3;
                }
                continue;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        com.baidu.tbadk.widget.richText.f FF = cVar.FF();
        if (FF != null) {
            if (!StringUtils.isNull(FF.FO())) {
                return FF.FO();
            }
            if (FF.getHeight() * FF.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (FF.getHeight() * FF.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (FF.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * FF.getHeight())));
            } else {
                float width = FF.getWidth() / FF.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.ax.aT(FF.getSrc()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onPhoneClicked(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.cEO = str;
            if (this.cFh == null) {
                alk();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.cFh.bN(1).setVisibility(8);
            } else {
                this.cFh.bN(1).setVisibility(0);
            }
            this.cFh.tj();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alw() {
        hideNetRefreshView(this.cFq.getView());
        showLoadingView(this.cFq.getView(), true);
        if (this.cFl.Dy()) {
            this.cFq.amJ();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVoice() {
        if (this.mVoiceManager != null) {
            this.mVoiceManager.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showShareDialog() {
        if (this.cFl.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.a.c pbData = this.cFl.getPbData();
            String name = pbData.akG().getName();
            String title = pbData.akH().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.cFl.getThreadID() + "?share=9105&fr=share";
            String[] aD = pbData.aD(getPageContext().getPageActivity());
            String str2 = aD[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = aD[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (all() == 1) {
                if (pbData != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10399").aa(ImageViewerConfig.FORUM_ID, pbData.getForumId()).aa("tid", pbData.getThreadId()).aa("uid", currentAccount));
                }
            } else if (all() == 2 && pbData != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10406").aa(ImageViewerConfig.FORUM_ID, pbData.getForumId()).aa("tid", pbData.getThreadId()).aa("uid", currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(n.j.share_content_tpl), title, name, str3);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.linkUrl = str;
            fVar.alO = true;
            fVar.extData = this.cFl.getThreadID();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true, qo());
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(n.j.share_tieba_qunzu, n.f.icon_unite_share_qunzu, new ax(this));
            shareDialogConfig.addOutsideTextView(n.j.forum_friend, n.f.icon_unite_share_baf, new ay(this));
            shareDialogConfig.setCopyLinkListener(new az(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private SparseArray<String> qo() {
        if (this.bdF == null) {
            this.bdF = new SparseArray<>(7);
            this.bdF.put(2, "pb_wx_timeline");
            this.bdF.put(3, "pb_wx_friend");
            this.bdF.put(4, "pb_qq_zone");
            this.bdF.put(5, "pb_tencent_weibo");
            this.bdF.put(6, "pb_sina_weibo");
            this.bdF.put(7, "pb_renren");
        }
        return this.bdF;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<LinearLayout> getTextVoiceViewPool() {
        if (this.aEZ == null) {
            this.aEZ = new com.baidu.adp.lib.f.b<>(new ba(this), 15, 0);
        }
        return this.aEZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alx() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.pb.a.c pbData = this.cFl.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.rI().isIfAddition();
            AdditionData akO = pbData.akO();
            boolean z3 = akO == null ? false : isIfAddition;
            if (z3) {
                z = akO.getAlreadyCount() != akO.getTotalCount();
                if (!TextUtils.isEmpty(akO.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.pb.main.b.c cVar = this.cFq.cIl;
            if (!z3 || !z) {
                z2 = false;
            }
            cVar.fw(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.cFq.amD() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10517").r("obj_locate", 2).aa(ImageViewerConfig.FORUM_ID, this.cFl.getPbData().getForumId()));
            } else {
                com.baidu.tbadk.core.data.z akH = this.cFl.getPbData().akH();
                if (view != null) {
                    boolean z = akH.getPraise() == null || akH.getPraise().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.bco > 1000) {
                            this.bcp = true;
                            F(view);
                        } else {
                            this.bcp = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            d(view, this.bcp);
                        } else {
                            c(view, this.bcp);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        c(view, this.bcp);
                    } else if (motionEvent.getAction() == 3) {
                        c(view, this.bcp);
                    }
                }
            }
        }
        return false;
    }

    private void c(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), n.a.praise_animation_scale2));
            new Handler().postDelayed(new bb(this), 200L);
        }
    }

    private void d(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), n.a.praise_animation_scale3));
            new Handler().postDelayed(new bc(this), 600L);
        }
    }

    private void F(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), n.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void Nm() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(n.j.login_to_use), true, 11017)));
        } else if (aVar.th() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.th();
            int intValue = ((Integer) sparseArray.get(dk.cJK)).intValue();
            if (intValue == dk.cJL) {
                if (!this.cFn.aGg()) {
                    this.cFq.amG();
                    int intValue2 = ((Integer) sparseArray.get(n.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(n.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(n.g.tag_del_post_type)).intValue();
                    this.cFn.a(this.cFl.getPbData().akG().getId(), this.cFl.getPbData().akG().getName(), this.cFl.getPbData().akH().getId(), (String) sparseArray.get(n.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == dk.cJM || intValue == dk.cJO) {
                this.cFl.kx(cf.cHs);
                if (intValue == dk.cJM) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == dk.cJN) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.cFQ).rf()));
            }
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (sparseArray.get(n.g.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(n.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(n.g.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(n.g.tag_user_mute_thread_id);
        }
        if (sparseArray.get(n.g.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(n.g.tag_user_mute_post_id);
        }
        this.cFo.a(z, str, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
    }

    private boolean kB(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bj.ah(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.tJ().getString("bubble_link", ""))) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(n.j.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void eY(boolean z) {
        this.cFv = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aly() {
        ArrayList<com.baidu.tieba.tbadkCore.data.r> akI;
        int l;
        if (this.cFl == null || this.cFl.getPbData() == null || this.cFl.getPbData().akI() == null || (l = com.baidu.tbadk.core.util.y.l((akI = this.cFl.getPbData().akI()))) == 0) {
            return "";
        }
        int amP = this.cFq.amP();
        com.baidu.tieba.tbadkCore.data.r rVar = (com.baidu.tieba.tbadkCore.data.r) com.baidu.tbadk.core.util.y.b(akI, amP);
        if (rVar == null || rVar.getAuthor() == null) {
            return "";
        }
        if (this.cFl.kF(rVar.getAuthor().getUserId())) {
            return rVar.getId();
        }
        for (int i = amP - 1; i != 0; i--) {
            com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) com.baidu.tbadk.core.util.y.b(akI, i);
            if (rVar2 == null || rVar2.getAuthor() == null || rVar2.getAuthor().getUserId() == null) {
                break;
            } else if (this.cFl.kF(rVar2.getAuthor().getUserId())) {
                return rVar2.getId();
            }
        }
        for (int i2 = amP + 1; i2 < l; i2++) {
            com.baidu.tieba.tbadkCore.data.r rVar3 = (com.baidu.tieba.tbadkCore.data.r) com.baidu.tbadk.core.util.y.b(akI, i2);
            if (rVar3 == null || rVar3.getAuthor() == null || rVar3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.cFl.kF(rVar3.getAuthor().getUserId())) {
                return rVar3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onLinkButtonClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bf.vn().b(getPageContext(), new String[]{str})) {
            com.baidu.tieba.pb.a.a(kA(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.cFl.getPbData().akG().getId(), this.cFl.getPbData().akG().getName(), this.cFl.getPbData().akH().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, String str2, String str3, String str4) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.cF(getResources().getString(n.j.make_sure_hide));
        aVar.a(getResources().getString(n.j.alert_yes_button), new bd(this, j, str, str2, str3, str4));
        aVar.b(getResources().getString(n.j.alert_no_button), new bf(this, j, str, str2, str3, str4));
        aVar.aj(false);
        aVar.b(getPageContext());
        aVar.tf();
    }
}
