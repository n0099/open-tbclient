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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
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
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.bk;
import com.baidu.tieba.tbadkCore.h.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.i;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, com.baidu.tbadk.widget.richText.i {
    private static String caG = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aBF;
    private com.baidu.adp.lib.e.b<TextView> aBG;
    private com.baidu.adp.lib.e.b<View> aBH;
    private com.baidu.adp.lib.e.b<LinearLayout> aBI;
    private com.baidu.adp.lib.e.b<GifView> aBJ;
    private com.baidu.adp.lib.e.b<TbImageView> afk;
    private boolean atm;
    private com.baidu.tbadk.core.dialog.a caI;
    private boolean caW;
    private com.baidu.tbadk.editortools.c.d caX;
    private String cay;
    private boolean mIsFromCDN;
    private VoiceManager mVoiceManager;
    private boolean caA = false;
    private boolean bfd = true;
    private boolean bYO = false;
    private com.baidu.tbadk.core.dialog.a caB = null;
    private String caC = null;
    private String aPL = null;
    private String caD = null;
    private String caE = null;
    private String mPackageName = null;
    private int caF = 0;
    private com.baidu.tbadk.core.dialog.c caH = null;
    SparseArray<String> bei = null;
    private long aMq = -1;
    private long axq = 0;
    private long createTime = 0;
    private long axr = 0;
    private boolean caJ = false;
    private com.baidu.tbadk.performanceLog.e caK = null;
    private String arU = null;
    private final Handler mHandler = new Handler(new com.baidu.tieba.pb.pb.main.b(this));
    private bk caL = null;
    private com.baidu.tbadk.baseEditMark.a caM = null;
    private com.baidu.tieba.tbadkCore.h.a caN = null;
    private UserMuteAddAndDelModel<PbActivity> caO = null;
    private com.baidu.tieba.usermute.i caP = null;
    private cb caQ = null;
    public final com.baidu.tieba.pb.pb.main.a.a caR = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean caS = false;
    private boolean caT = false;
    private MorePopupWindow caU = null;
    private bz caV = null;
    private boolean aUm = false;
    private com.baidu.tbadk.editortools.c.b arZ = new m(this);
    private CustomMessageListener bds = new x(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener aTl = new ai(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener caY = new at(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener caZ = new ax(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener richTextIntentClickListener = new ay(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private View.OnClickListener cba = new az(this);
    private boolean aTc = false;
    private com.baidu.tieba.tbadkCore.ad aTo = new com.baidu.tieba.tbadkCore.ad(getPageContext(), new ba(this));
    private long aTy = 0;
    private boolean aTz = true;
    private com.baidu.tieba.pb.b.c cbb = new com.baidu.tieba.pb.b.c(new c(this));
    private UserMuteAddAndDelModel.a cbc = new d(this);
    private i.a cbd = new e(this);
    public a.b bWS = new f(this);
    public final View.OnClickListener aXl = new g(this);
    private final a.d asc = new h(this);
    private final bk.a cbe = new i(this);
    private final a.InterfaceC0039a cbf = new j(this);
    private final AbsListView.OnScrollListener HB = new k(this);
    private final com.baidu.adp.base.g cbg = new l(this);
    private final b cbh = new n(this);
    private final x.a aHL = new o(this);
    private final BdListView.e cbi = new p(this);
    private final BdListView.h cbj = new q(this);
    private int cbk = 0;
    private final TbRichTextView.c aBY = new r(this);
    boolean cbl = false;
    com.baidu.tieba.tbadkCore.data.i cbm = null;
    private final c.b cbn = new s(this);
    private final View.OnLongClickListener akJ = new t(this);
    private final NoNetworkView.a aSF = new u(this);

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* loaded from: classes.dex */
    public interface b {
        void eg(boolean z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        if (cVar.acQ() != null) {
            String id = cVar.acQ().getId();
            ArrayList<com.baidu.tieba.tbadkCore.data.i> acI = this.caL.getPbData().acI();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= acI.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.i iVar = acI.get(i2);
                if (iVar.getId() == null || !iVar.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.data.i> acS = cVar.acS();
                    iVar.jH(cVar.getTotalCount());
                    if (iVar.apS() != null) {
                        iVar.apS().clear();
                        iVar.apS().addAll(acS);
                    }
                }
            }
            this.caQ.h(this.caL.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acY() {
        com.baidu.tieba.pb.a.b pbData;
        com.baidu.tbadk.core.data.v acH;
        if (!this.aTc) {
            if (!com.baidu.adp.lib.util.k.jf()) {
                showToast(i.C0057i.no_network_guide);
            } else if (this.aTz) {
                this.aTc = true;
                if (this.caL != null && (pbData = this.caL.getPbData()) != null && (acH = pbData.acH()) != null) {
                    int isLike = acH.getPraise() == null ? 0 : acH.getPraise().getIsLike();
                    if (this.aTo != null) {
                        this.aTo.a(acH.sv(), acH.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        String[] strArr;
        String str = (String) sparseArray.get(i.f.tag_disable_reply_mute_userid);
        if (((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue()) {
            String[] strArr2 = new String[2];
            strArr2[0] = getResources().getString(i.C0057i.delete);
            strArr2[1] = z ? getResources().getString(i.C0057i.un_mute) : getResources().getString(i.C0057i.mute);
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(i.C0057i.delete)};
        }
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bF(i.C0057i.operation);
        cVar.a(strArr, new v(this, sparseArray, z, str));
        cVar.d(getPageContext()).sS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd(int i) {
        com.baidu.tbadk.core.data.v acH;
        String sb;
        String o;
        if (this.caL != null && this.caL.getPbData() != null && (acH = this.caL.getPbData().acH()) != null) {
            if (i == 1) {
                PraiseData praise = acH.getPraise();
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
                        acH.setPraise(praiseData);
                    } else {
                        acH.getPraise().getUser().add(0, metaData);
                        acH.getPraise().setNum(acH.getPraise().getNum() + 1);
                        acH.getPraise().setIsLike(i);
                    }
                }
                if (acH.getPraise() != null) {
                    if (acH.getPraise().getNum() < 1) {
                        o = getResources().getString(i.C0057i.frs_item_praise_text);
                    } else {
                        o = com.baidu.tbadk.core.util.aq.o(acH.getPraise().getNum());
                    }
                    this.caQ.z(o, true);
                }
            } else if (acH.getPraise() != null) {
                acH.getPraise().setIsLike(i);
                acH.getPraise().setNum(acH.getPraise().getNum() - 1);
                ArrayList<MetaData> user = acH.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            acH.getPraise().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (acH.getPraise().getNum() < 1) {
                    sb = getResources().getString(i.C0057i.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(acH.getPraise().getNum())).toString();
                }
                this.caQ.z(sb, false);
            }
            if (this.caL.ady()) {
                this.caQ.aeg().notifyDataSetChanged();
            } else {
                this.caQ.i(this.caL.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.caL.saveToBundle(bundle);
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.caX.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.aMq = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aMq = System.currentTimeMillis();
        }
        this.caF = 0;
        initUI();
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.c.l lVar = new com.baidu.tbadk.editortools.c.l();
        lVar.setForumName(this.caL.adx());
        lVar.a(this.caL);
        this.caX = (com.baidu.tbadk.editortools.c.d) lVar.al(getActivity());
        this.caX.b(this);
        this.caX.a(this.asc);
        this.caX.a(this.arZ);
        this.caX.a(this, bundle);
        this.caQ.setEditorTools(this.caX.Ay());
        registerListener(this.aTl);
        if (!this.caL.adB()) {
            this.caX.eL(this.caL.getThreadID());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.aMq;
        registerListener(this.bds);
        registerListener(this.caY);
        registerListener(this.caZ);
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

    public bk acZ() {
        return this.caL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.caA = true;
        super.onPause();
        BdListView listView = getListView();
        this.caF = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.caF == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
        if (this.caQ != null) {
            this.caQ.onPause();
        }
        if (!this.caL.adB()) {
            this.caX.eK(this.caL.getThreadID());
        }
        MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.caA = false;
        super.onResume();
        if (this.caF == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView aea = this.caQ.aea();
        if (aea != null && aea.getVisibility() == 0 && com.baidu.adp.lib.util.i.iO()) {
            aea.ax(false);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
        registerListener(this.richTextIntentClickListener);
        this.caW = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.caQ.et(z);
        if (this.caV != null) {
            this.caV.eq(z);
        }
        if (z && this.caW) {
            this.caQ.aen();
            this.caL.ek(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.caX != null && this.caX.Ay() != null && this.caX.Ay().getVisibility() != 0) {
            this.caX.Bu();
        }
        if (this.caQ.cdM != null && !this.caQ.cdM.aeK()) {
            this.caQ.cdM.Zw();
        }
        if (this.caL != null && this.caL.getPbData() != null && this.caL.getPbData().acG() != null && this.caL.getPbData().acH() != null) {
            com.baidu.tbadk.distribute.a.Ai().a(getPageContext().getPageActivity(), "pb", this.caL.getPbData().acG().getId(), com.baidu.adp.lib.g.b.c(this.caL.getPbData().acH().getId(), 0L));
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (!this.caJ) {
            this.caJ = true;
            this.caQ.aeD();
        }
        this.caP.onDestroy();
        this.caL.cancelLoadData();
        this.caL.destory();
        this.caX.onDestroy();
        this.caN.cancelLoadData();
        this.caQ.onDestroy();
        if (this.caQ.cdM != null) {
            this.caQ.cdM.Zw();
        }
        if (this.caK != null) {
            this.caK.onDestroy();
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
        this.caQ.onChangeSkinType(i);
        if (this.caX != null && this.caX.Ay() != null) {
            this.caX.Ay().onChangeSkinType(i);
        }
        if (this.caU != null) {
            this.caU.onChangeSkinType(this, i, com.baidu.tbadk.core.util.al.getDrawable(i.e.bg_collect));
        }
        if (this.caQ.aea() != null) {
            this.caQ.aea().onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ada() {
        this.caV = new bz(getPageContext(), this.aXl);
        this.caV.eq(this.mIsLogin);
        this.caU = new MorePopupWindow(getPageContext().getPageActivity(), this.caV.getView(), getResources().getDrawable(i.e.bg_collect), null);
        this.caU.setTouchInterceptor(new w(this));
        this.caU.onChangeSkinType(this, TbadkCoreApplication.m411getInst().getSkinType(), com.baidu.tbadk.core.util.al.getDrawable(i.e.bg_collect));
    }

    private void initUI() {
        this.caQ = new cb(this, this.aXl, this.cbb);
        this.caQ.setOnScrollListener(this.HB);
        this.caQ.c(this.cbi);
        this.caQ.a(this.cbj);
        this.caQ.a(this.aHL);
        this.caQ.eh(com.baidu.tbadk.core.m.rd().rh());
        this.caQ.ei(com.baidu.tbadk.core.m.rd().rf());
        this.caQ.setOnImageClickListener(this.aBY);
        this.caQ.a(this.akJ);
        this.caQ.g(this.aSF);
        this.caQ.a(this.cbh);
        this.caQ.et(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean U(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(i.f.tag_clip_board);
            if (obj instanceof com.baidu.tieba.tbadkCore.data.i) {
                com.baidu.tieba.tbadkCore.data.i iVar = (com.baidu.tieba.tbadkCore.data.i) obj;
                if (TextUtils.isEmpty(iVar.getBimg_url()) || !com.baidu.tbadk.core.m.rd().rh()) {
                    return false;
                }
                return jl(iVar.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.caQ != null) {
            if (z && !this.bYO) {
                if (this.bfd) {
                    this.bfd = false;
                    showLoadingView(this.caQ.getView(), true);
                    return;
                }
                return;
            }
            hideLoadingView(this.caQ.getView());
        }
    }

    private void adb() {
        if (this.caH == null) {
            this.caH = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.caH.a(new String[]{getPageContext().getString(i.C0057i.call_phone), getPageContext().getString(i.C0057i.sms_phone), getPageContext().getString(i.C0057i.search_in_baidu)}, new y(this)).bG(c.a.WS).bH(17).d(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        this.caL = new bk(this);
        this.caL.a(this.cbe);
        this.caM = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.caM != null) {
            this.caM.a(this.cbf);
        }
        this.caN = new com.baidu.tieba.tbadkCore.h.a(this);
        this.caN.setLoadDataCallBack(this.cbg);
        this.caO = new UserMuteAddAndDelModel<>(this);
        this.caO.a(this.cbc);
        this.caP = new com.baidu.tieba.usermute.i(getPageContext(), this.cbd);
        if (bundle != null) {
            this.caL.initWithBundle(bundle);
        } else {
            this.caL.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra("request_code", -1) == 18003) {
            this.caL.en(true);
        }
        bw.adS().y(this.caL.adw(), this.caL.getIsFromMark());
        this.caQ.ael();
        this.caL.CV();
        this.caQ.a(new z(this));
        this.aTo.setUniqueId(getUniqueId());
        this.aTo.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = (String) sparseArray.get(i.f.tag_disable_reply_mute_userid);
        this.caQ.Yv();
        this.caP.a(com.baidu.adp.lib.g.b.c(currentAccount, 0L), com.baidu.adp.lib.g.b.c(str, 0L), sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ed(boolean z) {
        if (this.caL == null || this.caL.getPbData() == null) {
            return false;
        }
        return ((this.caL.getPbData().acK() != 0) || this.caL.getPbData().acH() == null || this.caL.getPbData().acH().getAuthor() == null || TextUtils.equals(this.caL.getPbData().acH().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void adc() {
        if (this.caL != null && this.caL.getPbData() != null && this.caL.getPbData().acH() != null && this.caL.getPbData().acH().getAuthor() != null) {
            this.caQ.cdM.c(this.caL.ady(), this.caM != null ? this.caM.qr() : false, ed(TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.caL.getPbData().acH().getAuthor().getUserId())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.tbadkCore.data.i iVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (iVar = (com.baidu.tieba.tbadkCore.data.i) sparseArray.get(i.f.tag_clip_board)) != null) {
            b(iVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        adm();
    }

    public void a(boolean z, MarkData markData) {
        this.caQ.aep();
        this.caL.em(z);
        if (this.caM != null) {
            this.caM.ab(z);
            if (markData != null) {
                this.caM.a(markData);
            }
        }
        if (this.caL.qr()) {
            adh();
        } else {
            this.caQ.h(this.caL.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jh(String str) {
        if (!StringUtils.isNull(str) && this.caL != null) {
            String threadID = this.caL.getThreadID();
            String id = this.caL.getPbData().acG().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(i.C0057i.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.caL.adB()) {
                    antiData.setBlock_forum_name(this.caL.getPbData().acG().getName());
                    antiData.setBlock_forum_id(this.caL.getPbData().acG().getId());
                    antiData.setUser_name(this.caL.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.caL.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
            if (!this.caL.adB()) {
                antiData.setBlock_forum_name(this.caL.getPbData().acG().getName());
                antiData.setBlock_forum_id(this.caL.getPbData().acG().getId());
                antiData.setUser_name(this.caL.getPbData().getUserData().getUserName());
                antiData.setUser_id(this.caL.getPbData().getUserData().getUserId());
            }
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        } else if (i == 230277) {
            this.caO.eQ(str);
        } else {
            this.caQ.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        int i = 0;
        if (bVar != null) {
            this.caQ.a(0, bVar.Ao, bVar.cKw, true);
            if (bVar.Ao) {
                if (bVar.cKu == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.i> acI = this.caL.getPbData().acI();
                    int size = acI.size();
                    while (true) {
                        if (i < size) {
                            if (!bVar.mPostId.equals(acI.get(i).getId())) {
                                i++;
                            } else {
                                acI.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.caQ.h(this.caL.getPbData());
                } else if (bVar.cKu == 0) {
                    add();
                } else if (bVar.cKu == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.i> acI2 = this.caL.getPbData().acI();
                    int size2 = acI2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < acI2.get(i2).apS().size()) {
                                if (!bVar.mPostId.equals(acI2.get(i2).apS().get(i3).getId())) {
                                    i3++;
                                } else {
                                    acI2.get(i2).apS().remove(i3);
                                    acI2.get(i2).apT();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData acN = this.caL.getPbData().acN();
                        com.baidu.tieba.tbadkCore.data.i iVar = acI2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.data.i> apU = iVar.apU();
                        int size3 = apU.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!bVar.mPostId.equals(acI2.get(i2).apU().get(i4).getId())) {
                                    i4++;
                                } else {
                                    apU.remove(i4);
                                    acN.decreaseAlreadyCount();
                                    if (iVar.aqb() > apU.size()) {
                                        iVar.jJ(apU.size());
                                    }
                                    if (apU.size() > 0) {
                                        com.baidu.tieba.tbadkCore.data.i iVar2 = apU.get(apU.size() - 1);
                                        acN.setLastAdditionTime(iVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a apW = iVar2.apW();
                                        String str = "";
                                        if (apW != null) {
                                            str = apW.toString();
                                        }
                                        acN.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a apW2 = iVar.apW();
                                        String str2 = "";
                                        if (apW2 != null) {
                                            str2 = apW2.toString();
                                        }
                                        acN.setLastAdditionContent(str2);
                                    }
                                    adn();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.caQ.h(this.caL.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.d dVar) {
        this.caQ.a(1, dVar.Ao, dVar.cKw, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.f fVar) {
        this.caQ.a(this.caN.getLoadDataMode(), fVar.Ao, fVar.cKw, false);
        this.caQ.Q(fVar.cKy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, a.f fVar) {
        if (fVar != null) {
            this.caQ.a(this.caN.getLoadDataMode(), fVar.Ao, fVar.cKw, true);
            if (fVar.Ao) {
                this.caT = true;
                if (i == 2) {
                    this.caL.getPbData().acH().bA(1);
                    this.caL.setIsGood(1);
                } else if (i == 3) {
                    this.caL.getPbData().acH().bA(0);
                    this.caL.setIsGood(0);
                } else if (i == 4) {
                    this.caL.getPbData().acH().bz(1);
                    this.caL.iq(1);
                } else if (i == 5) {
                    this.caL.getPbData().acH().bz(0);
                    this.caL.iq(0);
                }
                this.caQ.a(this.caL.getPbData(), this.caL.ady(), true);
            }
        }
    }

    private void add() {
        if (this.caL.adz()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.caL.getThreadID());
            setResult(-1, intent);
        }
        if (adi()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ade() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        this.caQ.aeA();
        if (this.caL != null && this.caL.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.caL.getPbData().acH().getId();
            historyMessage.forumName = this.caL.getPbData().acG().getName();
            historyMessage.threadName = this.caL.getPbData().acH().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.data.i> acI = this.caL.getPbData().acI();
            int aer = this.caQ.aer();
            if (acI != null && aer >= 0 && aer < acI.size()) {
                historyMessage.postID = acI.get(aer).getId();
            }
            historyMessage.isHostOnly = this.caL.getHostMode();
            historyMessage.isSquence = this.caL.ady();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.caL != null && this.caL.adz()) {
            Intent intent = new Intent();
            if (this.caT) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.caL.getThreadID());
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.caL.adA());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.caL.getIsGood());
            }
            setResult(-1, intent);
        }
        if (adi()) {
            if (this.caL != null && this.caQ != null && this.caQ.getListView() != null) {
                com.baidu.tieba.pb.a.b pbData = this.caL.getPbData();
                if (pbData != null && pbData.getUserData() != null) {
                    pbData.getUserData().setBimg_url(TbadkCoreApplication.m411getInst().getDefaultBubble());
                }
                bw.adS().a(this.caL.getPbData(), this.caQ.getListView().onSaveInstanceState(), this.caL.ady(), this.caL.getHostMode());
            } else {
                bw.adS().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.caU != null) {
                    com.baidu.adp.lib.g.j.a(this.caU, getPageContext().getPageActivity());
                }
                finish();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean io(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.C0057i.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.caX.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    adg();
                    return;
                case 13008:
                    bw.adS().reset();
                    this.mHandler.postDelayed(new aa(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.caL != null) {
                        a(adf(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    P(intent);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData adf() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] aG = this.caL.getPbData().aG(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.data.i aed = this.caQ.aed();
        String str = "";
        if (aed != null) {
            str = aed.getId();
            String aR = aed.aR(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(aR)) {
                aG[1] = aR;
            }
        }
        String sv = this.caL.getPbData().acH().sv();
        if (sv != null && sv.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(aG[1]);
        shareFromPBMsgData.setImageUrl(aG[0]);
        shareFromPBMsgData.setForumName(this.caL.getPbData().acG().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.caL.getPbData().acH().getId());
        shareFromPBMsgData.setTitle(this.caL.getPbData().acH().getTitle());
        return shareFromPBMsgData;
    }

    private void P(Intent intent) {
        a(adf(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.caL != null && this.caL.getPbData() != null && this.caL.getPbData().acH() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            cw cwVar = new cw(getPageContext().getPageActivity());
            cwVar.setData(shareFromPBMsgData);
            aVar.bE(1);
            aVar.m(cwVar);
            aVar.a(i.C0057i.share, new ab(this, cwVar, j, str, str2, shareFromPBMsgData));
            aVar.b(i.C0057i.alert_no_button, new ac(this, cwVar));
            aVar.ak(false);
            aVar.b(getPageContext()).sP();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                cwVar.v(shareFromPBMsgData.getImageUrl(), this.caL.getPbData().acL() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.caL != null && this.caL.getPbData() != null && this.caL.getPbData().acH() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            cw cwVar = new cw(getPageContext().getPageActivity());
            cwVar.setData(shareFromPBMsgData);
            aVar.bE(1);
            aVar.m(cwVar);
            aVar.a(i.C0057i.share, new ad(this, cwVar, i, str, j, shareFromPBMsgData));
            aVar.b(i.C0057i.alert_no_button, new ae(this, cwVar));
            aVar.ak(false);
            aVar.b(getPageContext()).sP();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                cwVar.v(shareFromPBMsgData.getImageUrl(), this.caL.getPbData().acL() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adg() {
        MarkData iw;
        if (this.caM != null && (iw = this.caL.iw(this.caQ.aer())) != null) {
            if (!iw.isApp() || (iw = this.caL.iw(this.caQ.aer() + 1)) != null) {
                this.caQ.ael();
                this.caM.a(iw);
                if (!this.caM.qr()) {
                    this.caM.qt();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.caM.qs();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adh() {
        com.baidu.tieba.pb.a.b pbData = this.caL.getPbData();
        this.caL.em(true);
        pbData.jg(this.caM.qq());
        this.caQ.h(pbData);
    }

    private boolean adi() {
        if (this.caL == null) {
            return true;
        }
        if (this.caL.qr()) {
            MarkData adJ = this.caL.adJ();
            if (adJ == null || !this.caL.getIsFromMark()) {
                return true;
            }
            MarkData iw = this.caL.iw(this.caQ.aer());
            if (iw == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, adJ);
                setResult(-1, intent);
                return true;
            } else if (iw.getPostId() == null || iw.getPostId().equals(adJ.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, adJ);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cn(String.format(getPageContext().getString(i.C0057i.alert_update_mark), Integer.valueOf(iw.getFloor())));
                aVar.a(i.C0057i.alert_yes_btn, new af(this, iw, adJ));
                aVar.b(i.C0057i.alert_no_button, new ag(this, adJ));
                aVar.a(new ah(this, adJ));
                aVar.b(getPageContext());
                aVar.sP();
                return false;
            }
        } else if (this.caL.getPbData() == null || this.caL.getPbData().acI() == null || this.caL.getPbData().acI().size() <= 0 || !this.caL.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.caQ == null) {
            return null;
        }
        return this.caQ.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int getRichTextViewId() {
        if (this.caQ == null) {
            return 0;
        }
        return this.caQ.aeu();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vG() {
        if (this.caQ == null) {
            return 0;
        }
        return this.caQ.Mg();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<ImageView> getImageViewPool() {
        if (this.aBF == null) {
            this.aBF = new com.baidu.adp.lib.e.b<>(new aj(this), 8, 0);
        }
        return this.aBF;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<TextView> getTextViewPool() {
        if (this.aBG == null) {
            this.aBG = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.aBG;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<GifView> getGifViewPool() {
        if (this.aBJ == null) {
            this.aBJ = new com.baidu.adp.lib.e.b<>(new ak(this), 20, 0);
        }
        return this.aBJ;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<View> getVoiceViewPool() {
        if (this.aBH == null) {
            this.aBH = new com.baidu.adp.lib.e.b<>(new al(this), 8, 0);
        }
        return this.aBH;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> vH() {
        if (this.afk == null) {
            this.afk = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.afk;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    public boolean ji(String str) {
        Map<String, String> df;
        if (!TextUtils.isEmpty(str) && (df = com.baidu.tbadk.core.util.ax.df(com.baidu.tbadk.core.util.ax.dg(str))) != null) {
            String str2 = df.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return ji(com.baidu.adp.lib.util.j.aS(str2));
            }
            String str3 = df.get(caG);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onLinkClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (jj(str) || z) {
                boolean v = com.baidu.adp.lib.util.k.v(context, "com.qiyi.video");
                jk(str);
                if (v) {
                    adj();
                } else {
                    adk();
                }
            } else if (ji(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                com.baidu.tbadk.core.util.ax.uR().b(getPageContext(), new String[]{str});
            }
        }
    }

    private boolean jj(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }

    private void jk(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(";")) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.caD = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.caE = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.aPL = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.caC = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void adj() {
        if (TextUtils.isEmpty(this.caD) || TextUtils.isEmpty(this.caE) || TextUtils.isEmpty(this.mPackageName)) {
            if (!TextUtils.isEmpty(this.caC)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.caC);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(this.caD));
        intent.setAction(this.caE);
        intent.setPackage(this.mPackageName);
        if (intent.resolveActivity(getPageContext().getPageActivity().getPackageManager()) != null) {
            if (!com.baidu.adp.lib.g.i.e(getPageContext().getPageActivity(), intent) && !TextUtils.isEmpty(this.caC)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.caC);
            }
        } else if (!TextUtils.isEmpty(this.caC)) {
            com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.caC);
        }
    }

    private void adk() {
        if (!com.baidu.adp.lib.util.i.iP()) {
            if (!TextUtils.isEmpty(this.caC)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.caC);
                return;
            }
            return;
        }
        if (this.caB == null) {
            this.caB = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.caB.bC(i.C0057i.download_iqiyi_app_dialog);
            this.caB.a(i.C0057i.install_app, new am(this));
            this.caB.b(i.C0057i.webpage_play, new an(this));
            this.caB.ak(false);
        }
        this.caB.b(getPageContext()).sP();
    }

    private com.baidu.tbadk.core.dialog.a adl() {
        if (this.caI == null) {
            this.caI = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.caI.cm(getPageContext().getString(i.C0057i.download_baidu_video_dialog));
            this.caI.a(getPageContext().getString(i.C0057i.install), new ao(this));
            this.caI.b(getPageContext().getString(i.C0057i.cancel), new ap(this));
            this.caI.aj(true);
            this.caI.b(getPageContext());
            this.caI.ak(false);
        }
        this.caI.sP();
        return this.caI;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onVideoClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (jj(str) || z) {
                boolean v = com.baidu.adp.lib.util.k.v(context, "com.qiyi.video");
                jk(str);
                if (v) {
                    adj();
                    return;
                } else {
                    adk();
                    return;
                }
            }
            com.baidu.tbadk.core.util.ax.uR().b(getPageContext(), new String[]{str});
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onVideoP2PClicked(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra("title", "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            adl();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onSongClicked(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, HashMap<String, ImageUrlData> hashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.f Fb;
        if (aVar == aVar2) {
            this.cbl = true;
        }
        if (aVar != null) {
            int size = aVar.EW().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.EW().get(i6) != null && aVar.EW().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.EW().get(i6).Fb().getWidth();
                    int height = aVar.EW().get(i6).Fb().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.EW().get(i6).Fb().Fj()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.EW().get(i6);
                        String b2 = b(cVar);
                        arrayList.add(b2);
                        if (!TextUtils.isEmpty(b2) && cVar != null && (Fb = cVar.Fb()) != null) {
                            String Fk = Fb.Fk();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Fk;
                            int i8 = this.mIsFromCDN ? 17 : 18;
                            imageUrlData.urlType = i8;
                            imageUrlData.urlType = i8;
                            if (hashMap != null) {
                                hashMap.put(b2, imageUrlData);
                            }
                        }
                        if (!this.cbl) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tieba.tbadkCore.data.i iVar) {
        if (iVar != null) {
            boolean z = false;
            if (iVar.getId() != null && iVar.getId().equals(this.caL.sr())) {
                z = true;
            }
            MarkData c = this.caL.c(iVar);
            if (c != null) {
                this.caQ.ael();
                if (this.caM != null) {
                    this.caM.a(c);
                    if (!z) {
                        this.caM.qt();
                    } else {
                        this.caM.qs();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a S(String str, int i) {
        if (this.caL == null || this.caL.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.a.b pbData = this.caL.getPbData();
        com.baidu.tbadk.widget.richText.a a2 = a(pbData.acI(), str, i);
        if (a2 == null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.i> acI = pbData.acI();
            int size = acI.size();
            for (int i2 = 0; i2 < size; i2++) {
                a2 = a(acI.get(i2).apU(), str, i);
                if (a2 != null) {
                    return a2;
                }
            }
            return a2;
        }
        return a2;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.data.i> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> EW;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a apW = arrayList.get(i2).apW();
            if (apW != null && (EW = apW.EW()) != null) {
                int size = EW.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (EW.get(i4) != null && EW.get(i4).getType() == 8) {
                        i3++;
                        if (EW.get(i4).Fb().Fk().equals(str)) {
                            int width = EW.get(i4).Fb().getWidth();
                            int height = EW.get(i4).Fb().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.cbk = i4;
                            return apW;
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
    public String b(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        com.baidu.tbadk.widget.richText.f Fb = cVar.Fb();
        if (Fb != null) {
            if (!StringUtils.isNull(Fb.Fi())) {
                return Fb.Fi();
            }
            if (Fb.getHeight() * Fb.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Fb.getHeight() * Fb.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Fb.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Fb.getHeight())));
            } else {
                float width = Fb.getWidth() / Fb.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.aq.aR(Fb.getSrc()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onPhoneClicked(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.cay = str;
            if (this.caH == null) {
                adb();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.caH.bJ(1).setVisibility(8);
            } else {
                this.caH.bJ(1).setVisibility(0);
            }
            this.caH.sS();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adm() {
        hideNetRefreshView(this.caQ.getView());
        showLoadingView(this.caQ.getView(), true);
        if (this.caL.CV()) {
            this.caQ.ael();
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
        if (this.caL.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.a.b pbData = this.caL.getPbData();
            String name = pbData.acG().getName();
            String title = pbData.acH().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.caL.getThreadID() + "?share=9105&fr=share";
            String[] aG = pbData.aG(getPageContext().getPageActivity());
            String str2 = aG[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String format = MessageFormat.format(getResources().getString(i.C0057i.share_content_tpl), title, name, aG[1]);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.linkUrl = str;
            if (parse != null) {
                fVar.imageUri = parse;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10125").af("tid", this.caL.getThreadID()));
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true, qC());
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(i.C0057i.share_tieba_qunzu, i.e.icon_unite_share_qunzu, new aq(this));
            shareDialogConfig.addOutsideTextView(i.C0057i.forum_friend, i.e.icon_unite_share_baf, new ar(this));
            shareDialogConfig.setCopyLinkListener(new as(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private SparseArray<String> qC() {
        if (this.bei == null) {
            this.bei = new SparseArray<>(7);
            this.bei.put(2, "pb_wx_timeline");
            this.bei.put(3, "pb_wx_friend");
            this.bei.put(4, "pb_qq_zone");
            this.bei.put(5, "pb_tencent_weibo");
            this.bei.put(6, "pb_sina_weibo");
            this.bei.put(7, "pb_renren");
        }
        return this.bei;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool() {
        if (this.aBI == null) {
            this.aBI = new com.baidu.adp.lib.e.b<>(new au(this), 15, 0);
        }
        return this.aBI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adn() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.pb.a.b pbData = this.caL.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.rM().isIfAddition();
            AdditionData acN = pbData.acN();
            boolean z3 = acN == null ? false : isIfAddition;
            if (z3) {
                z = acN.getAlreadyCount() != acN.getTotalCount();
                if (!TextUtils.isEmpty(acN.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.pb.main.b.a aVar = this.caQ.cdM;
            if (!z3 || !z) {
                z2 = false;
            }
            aVar.eD(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.caQ.aef() == view && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.core.data.v acH = this.caL.getPbData().acH();
            if (view != null) {
                boolean z = acH.getPraise() == null || acH.getPraise().getIsLike() == 0;
                if (motionEvent.getAction() == 0) {
                    if (System.currentTimeMillis() - this.aTy > 1000) {
                        this.aTz = true;
                        y(view);
                    } else {
                        this.aTz = false;
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (z) {
                        d(view, this.aTz);
                    } else {
                        c(view, this.aTz);
                    }
                } else if (motionEvent.getAction() == 2) {
                    c(view, this.aTz);
                } else if (motionEvent.getAction() == 3) {
                    c(view, this.aTz);
                }
            }
        }
        return false;
    }

    private void c(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), i.a.praise_animation_scale2));
            new Handler().postDelayed(new av(this), 200L);
        }
    }

    private void d(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), i.a.praise_animation_scale3));
            new Handler().postDelayed(new aw(this), 600L);
        }
    }

    private void y(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), i.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void Lt() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.C0057i.login_to_use), true, 11017)));
        } else if (!this.caN.aqN()) {
            this.caQ.aei();
            if (aVar.sQ() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.sQ();
                int intValue = ((Integer) sparseArray.get(i.f.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(i.f.tag_del_post_is_self)).booleanValue();
                int intValue2 = ((Integer) sparseArray.get(i.f.tag_del_post_type)).intValue();
                this.caN.a(this.caL.getPbData().acG().getId(), this.caL.getPbData().acG().getName(), this.caL.getPbData().acH().getId(), (String) sparseArray.get(i.f.tag_del_post_id), intValue2, intValue, booleanValue);
            }
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (sparseArray.get(i.f.tag_disable_reply_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(i.f.tag_disable_reply_mute_username);
        }
        if (sparseArray.get(i.f.tag_disable_reply_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(i.f.tag_disable_reply_thread_id);
        }
        if (sparseArray.get(i.f.tag_disable_reply_post_id) instanceof String) {
            str4 = (String) sparseArray.get(i.f.tag_disable_reply_post_id);
        }
        this.caO.a(z, str, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
    }

    private boolean jl(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bb.ah(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.ts().getString("bubble_link", ""))) {
                return false;
            }
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(i.C0057i.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void ee(boolean z) {
        this.caW = z;
    }
}
