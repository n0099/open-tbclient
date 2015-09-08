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
    private static String cbB = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aDn;
    private com.baidu.adp.lib.e.b<TextView> aDo;
    private com.baidu.adp.lib.e.b<View> aDp;
    private com.baidu.adp.lib.e.b<LinearLayout> aDq;
    private com.baidu.adp.lib.e.b<GifView> aDr;
    private com.baidu.adp.lib.e.b<TbImageView> afu;
    private boolean auW;
    private com.baidu.tbadk.core.dialog.a cbD;
    private boolean cbR;
    private com.baidu.tbadk.editortools.c.d cbS;
    private String cbt;
    private boolean mIsFromCDN;
    private VoiceManager mVoiceManager;
    private boolean cbv = false;
    private boolean bfy = true;
    private boolean bZI = false;
    private com.baidu.tbadk.core.dialog.a cbw = null;
    private String cbx = null;
    private String aPZ = null;
    private String cby = null;
    private String cbz = null;
    private String mPackageName = null;
    private int cbA = 0;
    private com.baidu.tbadk.core.dialog.c cbC = null;
    SparseArray<String> beE = null;
    private long aMD = -1;
    private long ayY = 0;
    private long createTime = 0;
    private long ayZ = 0;
    private boolean cbE = false;
    private com.baidu.tbadk.performanceLog.e cbF = null;
    private String atE = null;
    private final Handler mHandler = new Handler(new com.baidu.tieba.pb.pb.main.b(this));
    private bk cbG = null;
    private com.baidu.tbadk.baseEditMark.a cbH = null;
    private com.baidu.tieba.tbadkCore.h.a cbI = null;
    private UserMuteAddAndDelModel<PbActivity> cbJ = null;
    private com.baidu.tieba.usermute.i cbK = null;
    private cb cbL = null;
    public final com.baidu.tieba.pb.pb.main.a.a cbM = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean cbN = false;
    private boolean cbO = false;
    private MorePopupWindow cbP = null;
    private bz cbQ = null;
    private boolean aUA = false;
    private com.baidu.tbadk.editortools.c.b atJ = new m(this);
    private CustomMessageListener bdN = new x(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener aTz = new ai(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener cbT = new at(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener cbU = new ax(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener richTextIntentClickListener = new ay(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private View.OnClickListener cbV = new az(this);
    private boolean aTq = false;
    private com.baidu.tieba.tbadkCore.ae aTC = new com.baidu.tieba.tbadkCore.ae(getPageContext(), new ba(this));
    private long aTM = 0;
    private boolean aTN = true;
    private com.baidu.tieba.pb.b.c cbW = new com.baidu.tieba.pb.b.c(new c(this));
    private UserMuteAddAndDelModel.a cbX = new d(this);
    private i.a cbY = new e(this);
    public a.b bXJ = new f(this);
    public final View.OnClickListener aXl = new g(this);
    private final a.d atM = new h(this);
    private final bk.a cbZ = new i(this);
    private final a.InterfaceC0039a cca = new j(this);
    private final AbsListView.OnScrollListener HB = new k(this);
    private final com.baidu.adp.base.g ccb = new l(this);
    private final b ccc = new n(this);
    private final x.a aHY = new o(this);
    private final BdListView.e ccd = new p(this);
    private final BdListView.h cce = new q(this);
    private int ccf = 0;
    private final TbRichTextView.c aDG = new r(this);
    boolean ccg = false;
    com.baidu.tieba.tbadkCore.data.i cch = null;
    private final c.b cci = new s(this);
    private final View.OnLongClickListener alb = new t(this);
    private final NoNetworkView.a aST = new u(this);

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* loaded from: classes.dex */
    public interface b {
        void en(boolean z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    public void b(com.baidu.tieba.pb.a.c cVar) {
        if (cVar.adb() != null) {
            String id = cVar.adb().getId();
            ArrayList<com.baidu.tieba.tbadkCore.data.i> acR = this.cbG.getPbData().acR();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= acR.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.i iVar = acR.get(i2);
                if (iVar.getId() == null || !iVar.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.data.i> adf = cVar.adf();
                    iVar.ks(cVar.getTotalCount());
                    if (iVar.auf() != null) {
                        iVar.auf().clear();
                        iVar.auf().addAll(adf);
                    }
                }
            }
            this.cbL.h(this.cbG.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adl() {
        com.baidu.tieba.pb.a.b pbData;
        com.baidu.tbadk.core.data.x acQ;
        if (!this.aTq) {
            if (!com.baidu.adp.lib.util.k.jc()) {
                showToast(i.h.no_network_guide);
            } else if (this.aTN) {
                this.aTq = true;
                if (this.cbG != null && (pbData = this.cbG.getPbData()) != null && (acQ = pbData.acQ()) != null) {
                    int isLike = acQ.getPraise() == null ? 0 : acQ.getPraise().getIsLike();
                    if (this.aTC != null) {
                        this.aTC.a(acQ.sx(), acQ.getId(), isLike, "pb");
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
            strArr2[0] = getResources().getString(i.h.delete);
            strArr2[1] = z ? getResources().getString(i.h.un_mute) : getResources().getString(i.h.mute);
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(i.h.delete)};
        }
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bI(i.h.operation);
        cVar.a(strArr, new v(this, sparseArray, z, str));
        cVar.d(getPageContext()).sX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fk(int i) {
        com.baidu.tbadk.core.data.x acQ;
        String sb;
        String o;
        if (this.cbG != null && this.cbG.getPbData() != null && (acQ = this.cbG.getPbData().acQ()) != null) {
            if (i == 1) {
                PraiseData praise = acQ.getPraise();
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
                        acQ.setPraise(praiseData);
                    } else {
                        acQ.getPraise().getUser().add(0, metaData);
                        acQ.getPraise().setNum(acQ.getPraise().getNum() + 1);
                        acQ.getPraise().setIsLike(i);
                    }
                }
                if (acQ.getPraise() != null) {
                    if (acQ.getPraise().getNum() < 1) {
                        o = getResources().getString(i.h.frs_item_praise_text);
                    } else {
                        o = com.baidu.tbadk.core.util.aq.o(acQ.getPraise().getNum());
                    }
                    this.cbL.B(o, true);
                }
            } else if (acQ.getPraise() != null) {
                acQ.getPraise().setIsLike(i);
                acQ.getPraise().setNum(acQ.getPraise().getNum() - 1);
                ArrayList<MetaData> user = acQ.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            acQ.getPraise().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (acQ.getPraise().getNum() < 1) {
                    sb = getResources().getString(i.h.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(acQ.getPraise().getNum())).toString();
                }
                this.cbL.B(sb, false);
            }
            if (this.cbG.adM()) {
                this.cbL.aeu().notifyDataSetChanged();
            } else {
                this.cbL.i(this.cbG.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cbG.saveToBundle(bundle);
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.cbS.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.aMD = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aMD = System.currentTimeMillis();
        }
        this.cbA = 0;
        initUI();
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.c.l lVar = new com.baidu.tbadk.editortools.c.l();
        lVar.setForumName(this.cbG.adL());
        lVar.a(this.cbG);
        this.cbS = (com.baidu.tbadk.editortools.c.d) lVar.al(getActivity());
        this.cbS.b(this);
        this.cbS.a(this.atM);
        this.cbS.a(this.atJ);
        this.cbS.a(this, bundle);
        this.cbL.setEditorTools(this.cbS.AL());
        registerListener(this.aTz);
        if (!this.cbG.adP()) {
            this.cbS.eT(this.cbG.getThreadID());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.aMD;
        registerListener(this.bdN);
        registerListener(this.cbT);
        registerListener(this.cbU);
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

    public bk adm() {
        return this.cbG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.cbv = true;
        super.onPause();
        BdListView listView = getListView();
        this.cbA = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.cbA == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
        if (this.cbL != null) {
            this.cbL.onPause();
        }
        if (!this.cbG.adP()) {
            this.cbS.eS(this.cbG.getThreadID());
        }
        MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.cbv = false;
        super.onResume();
        if (this.cbA == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView aeo = this.cbL.aeo();
        if (aeo != null && aeo.getVisibility() == 0 && com.baidu.adp.lib.util.i.iL()) {
            aeo.ax(false);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
        registerListener(this.richTextIntentClickListener);
        this.cbR = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.cbL.eB(z);
        if (this.cbQ != null) {
            this.cbQ.ey(z);
        }
        if (z && this.cbR) {
            this.cbL.aeB();
            this.cbG.es(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cbS != null && this.cbS.AL() != null && this.cbS.AL().getVisibility() != 0) {
            this.cbS.BH();
        }
        if (this.cbL.ceJ != null && !this.cbL.ceJ.aeY()) {
            this.cbL.ceJ.ZA();
        }
        if (this.cbG != null && this.cbG.getPbData() != null && this.cbG.getPbData().acP() != null && this.cbG.getPbData().acQ() != null) {
            com.baidu.tbadk.distribute.a.Av().a(getPageContext().getPageActivity(), "pb", this.cbG.getPbData().acP().getId(), com.baidu.adp.lib.g.b.c(this.cbG.getPbData().acQ().getId(), 0L));
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (!this.cbE) {
            this.cbE = true;
            this.cbL.aeR();
        }
        this.cbK.onDestroy();
        this.cbG.cancelLoadData();
        this.cbG.destory();
        this.cbS.onDestroy();
        this.cbI.cancelLoadData();
        this.cbL.onDestroy();
        if (this.cbL.ceJ != null) {
            this.cbL.ceJ.ZA();
        }
        if (this.cbF != null) {
            this.cbF.onDestroy();
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
        this.cbL.onChangeSkinType(i);
        if (this.cbS != null && this.cbS.AL() != null) {
            this.cbS.AL().onChangeSkinType(i);
        }
        if (this.cbP != null) {
            this.cbP.onChangeSkinType(this, i, com.baidu.tbadk.core.util.al.getDrawable(i.e.bg_collect));
        }
        if (this.cbL.aeo() != null) {
            this.cbL.aeo().onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adn() {
        this.cbQ = new bz(getPageContext(), this.aXl);
        this.cbQ.ey(this.mIsLogin);
        this.cbP = new MorePopupWindow(getPageContext().getPageActivity(), this.cbQ.getView(), getResources().getDrawable(i.e.bg_collect), null);
        this.cbP.setTouchInterceptor(new w(this));
        this.cbP.onChangeSkinType(this, TbadkCoreApplication.m411getInst().getSkinType(), com.baidu.tbadk.core.util.al.getDrawable(i.e.bg_collect));
    }

    private void initUI() {
        this.cbL = new cb(this, this.aXl, this.cbW);
        this.cbL.setOnScrollListener(this.HB);
        this.cbL.c(this.ccd);
        this.cbL.a(this.cce);
        this.cbL.a(this.aHY);
        this.cbL.eo(com.baidu.tbadk.core.m.rb().rf());
        this.cbL.ep(com.baidu.tbadk.core.m.rb().rd());
        this.cbL.setOnImageClickListener(this.aDG);
        this.cbL.a(this.alb);
        this.cbL.g(this.aST);
        this.cbL.a(this.ccc);
        this.cbL.eB(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean U(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(i.f.tag_clip_board);
            if (obj instanceof com.baidu.tieba.tbadkCore.data.i) {
                com.baidu.tieba.tbadkCore.data.i iVar = (com.baidu.tieba.tbadkCore.data.i) obj;
                if (TextUtils.isEmpty(iVar.getBimg_url()) || !com.baidu.tbadk.core.m.rb().rf()) {
                    return false;
                }
                return jt(iVar.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.cbL != null) {
            if (z && !this.bZI) {
                if (this.bfy) {
                    this.bfy = false;
                    showLoadingView(this.cbL.getView(), true);
                    return;
                }
                return;
            }
            hideLoadingView(this.cbL.getView());
        }
    }

    private void ado() {
        if (this.cbC == null) {
            this.cbC = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.cbC.a(new String[]{getPageContext().getString(i.h.call_phone), getPageContext().getString(i.h.sms_phone), getPageContext().getString(i.h.search_in_baidu)}, new y(this)).bJ(c.a.Xb).bK(17).d(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        this.cbG = new bk(this);
        this.cbG.a(this.cbZ);
        this.cbH = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.cbH != null) {
            this.cbH.a(this.cca);
        }
        this.cbI = new com.baidu.tieba.tbadkCore.h.a(this);
        this.cbI.setLoadDataCallBack(this.ccb);
        this.cbJ = new UserMuteAddAndDelModel<>(this);
        this.cbJ.a(this.cbX);
        this.cbK = new com.baidu.tieba.usermute.i(getPageContext(), this.cbY);
        if (bundle != null) {
            this.cbG.initWithBundle(bundle);
        } else {
            this.cbG.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra("request_code", -1) == 18003) {
            this.cbG.ev(true);
        }
        bw.aeg().A(this.cbG.adK(), this.cbG.getIsFromMark());
        this.cbL.aez();
        this.cbG.Df();
        this.cbL.a(new z(this));
        this.aTC.setUniqueId(getUniqueId());
        this.aTC.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = (String) sparseArray.get(i.f.tag_disable_reply_mute_userid);
        this.cbL.Yx();
        this.cbK.a(com.baidu.adp.lib.g.b.c(currentAccount, 0L), com.baidu.adp.lib.g.b.c(str, 0L), sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ek(boolean z) {
        if (this.cbG == null || this.cbG.getPbData() == null) {
            return false;
        }
        return ((this.cbG.getPbData().acU() != 0) || this.cbG.getPbData().acQ() == null || this.cbG.getPbData().acQ().getAuthor() == null || TextUtils.equals(this.cbG.getPbData().acQ().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void adp() {
        if (this.cbG != null && this.cbG.getPbData() != null && this.cbG.getPbData().acQ() != null && this.cbG.getPbData().acQ().getAuthor() != null) {
            this.cbL.ceJ.c(this.cbG.adM(), this.cbH != null ? this.cbH.qo() : false, ek(TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.cbG.getPbData().acQ().getAuthor().getUserId())));
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
        adz();
    }

    public void a(boolean z, MarkData markData) {
        this.cbL.aeD();
        this.cbG.eu(z);
        if (this.cbH != null) {
            this.cbH.ab(z);
            if (markData != null) {
                this.cbH.a(markData);
            }
        }
        if (this.cbG.qo()) {
            adu();
        } else {
            this.cbL.h(this.cbG.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jp(String str) {
        if (!StringUtils.isNull(str) && this.cbG != null) {
            String threadID = this.cbG.getThreadID();
            String id = this.cbG.getPbData().acP().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(i.h.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.cbG.adP()) {
                    antiData.setBlock_forum_name(this.cbG.getPbData().acP().getName());
                    antiData.setBlock_forum_id(this.cbG.getPbData().acP().getId());
                    antiData.setUser_name(this.cbG.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.cbG.getPbData().getUserData().getUserId());
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
            if (!this.cbG.adP()) {
                antiData.setBlock_forum_name(this.cbG.getPbData().acP().getName());
                antiData.setBlock_forum_id(this.cbG.getPbData().acP().getId());
                antiData.setUser_name(this.cbG.getPbData().getUserData().getUserName());
                antiData.setUser_id(this.cbG.getPbData().getUserData().getUserId());
            }
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        } else if (i == 230277) {
            this.cbJ.eY(str);
        } else {
            this.cbL.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        int i = 0;
        if (bVar != null) {
            this.cbL.a(0, bVar.Am, bVar.cSW, true);
            if (bVar.Am) {
                if (bVar.cSU == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.i> acR = this.cbG.getPbData().acR();
                    int size = acR.size();
                    while (true) {
                        if (i < size) {
                            if (!bVar.mPostId.equals(acR.get(i).getId())) {
                                i++;
                            } else {
                                acR.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.cbL.h(this.cbG.getPbData());
                } else if (bVar.cSU == 0) {
                    adq();
                } else if (bVar.cSU == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.i> acR2 = this.cbG.getPbData().acR();
                    int size2 = acR2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < acR2.get(i2).auf().size()) {
                                if (!bVar.mPostId.equals(acR2.get(i2).auf().get(i3).getId())) {
                                    i3++;
                                } else {
                                    acR2.get(i2).auf().remove(i3);
                                    acR2.get(i2).auh();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData acX = this.cbG.getPbData().acX();
                        com.baidu.tieba.tbadkCore.data.i iVar = acR2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.data.i> aui = iVar.aui();
                        int size3 = aui.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!bVar.mPostId.equals(acR2.get(i2).aui().get(i4).getId())) {
                                    i4++;
                                } else {
                                    aui.remove(i4);
                                    acX.decreaseAlreadyCount();
                                    if (iVar.aup() > aui.size()) {
                                        iVar.ku(aui.size());
                                    }
                                    if (aui.size() > 0) {
                                        com.baidu.tieba.tbadkCore.data.i iVar2 = aui.get(aui.size() - 1);
                                        acX.setLastAdditionTime(iVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a auk = iVar2.auk();
                                        String str = "";
                                        if (auk != null) {
                                            str = auk.toString();
                                        }
                                        acX.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a auk2 = iVar.auk();
                                        String str2 = "";
                                        if (auk2 != null) {
                                            str2 = auk2.toString();
                                        }
                                        acX.setLastAdditionContent(str2);
                                    }
                                    adA();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.cbL.h(this.cbG.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.d dVar) {
        this.cbL.a(1, dVar.Am, dVar.cSW, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.f fVar) {
        this.cbL.a(this.cbI.getLoadDataMode(), fVar.Am, fVar.cSW, false);
        this.cbL.Q(fVar.cSY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, a.f fVar) {
        if (fVar != null) {
            this.cbL.a(this.cbI.getLoadDataMode(), fVar.Am, fVar.cSW, true);
            if (fVar.Am) {
                this.cbO = true;
                if (i == 2) {
                    this.cbG.getPbData().acQ().bB(1);
                    this.cbG.setIsGood(1);
                } else if (i == 3) {
                    this.cbG.getPbData().acQ().bB(0);
                    this.cbG.setIsGood(0);
                } else if (i == 4) {
                    this.cbG.getPbData().acQ().bA(1);
                    this.cbG.iB(1);
                } else if (i == 5) {
                    this.cbG.getPbData().acQ().bA(0);
                    this.cbG.iB(0);
                }
                this.cbL.a(this.cbG.getPbData(), this.cbG.adM(), true);
            }
        }
    }

    private void adq() {
        if (this.cbG.adN()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.cbG.getThreadID());
            setResult(-1, intent);
        }
        if (adv()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adr() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        this.cbL.aeO();
        if (this.cbG != null && this.cbG.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.cbG.getPbData().acQ().getId();
            historyMessage.forumName = this.cbG.getPbData().acP().getName();
            historyMessage.threadName = this.cbG.getPbData().acQ().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.data.i> acR = this.cbG.getPbData().acR();
            int aeF = this.cbL.aeF();
            if (acR != null && aeF >= 0 && aeF < acR.size()) {
                historyMessage.postID = acR.get(aeF).getId();
            }
            historyMessage.isHostOnly = this.cbG.getHostMode();
            historyMessage.isSquence = this.cbG.adM();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.cbG != null && this.cbG.adN()) {
            Intent intent = new Intent();
            if (this.cbO) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.cbG.getThreadID());
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.cbG.adO());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.cbG.getIsGood());
            }
            setResult(-1, intent);
        }
        if (adv()) {
            if (this.cbG != null && this.cbL != null && this.cbL.getListView() != null) {
                com.baidu.tieba.pb.a.b pbData = this.cbG.getPbData();
                if (pbData != null && pbData.getUserData() != null) {
                    pbData.getUserData().setBimg_url(TbadkCoreApplication.m411getInst().getDefaultBubble());
                }
                bw.aeg().a(this.cbG.getPbData(), this.cbL.getListView().onSaveInstanceState(), this.cbG.adM(), this.cbG.getHostMode());
            } else {
                bw.aeg().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.cbP != null) {
                    com.baidu.adp.lib.g.j.a(this.cbP, getPageContext().getPageActivity());
                }
                finish();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iz(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.h.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.cbS.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    adt();
                    return;
                case 13008:
                    bw.aeg().reset();
                    this.mHandler.postDelayed(new aa(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.cbG != null) {
                        a(ads(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    Q(intent);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData ads() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] aF = this.cbG.getPbData().aF(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.data.i aer = this.cbL.aer();
        String str = "";
        if (aer != null) {
            str = aer.getId();
            String aU = aer.aU(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(aU)) {
                aF[1] = aU;
            }
        }
        String sx = this.cbG.getPbData().acQ().sx();
        if (sx != null && sx.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(aF[1]);
        shareFromPBMsgData.setImageUrl(aF[0]);
        shareFromPBMsgData.setForumName(this.cbG.getPbData().acP().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.cbG.getPbData().acQ().getId());
        shareFromPBMsgData.setTitle(this.cbG.getPbData().acQ().getTitle());
        return shareFromPBMsgData;
    }

    private void Q(Intent intent) {
        a(ads(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.cbG != null && this.cbG.getPbData() != null && this.cbG.getPbData().acQ() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            cw cwVar = new cw(getPageContext().getPageActivity());
            cwVar.setData(shareFromPBMsgData);
            aVar.bH(1);
            aVar.m(cwVar);
            aVar.a(i.h.share, new ab(this, cwVar, j, str, str2, shareFromPBMsgData));
            aVar.b(i.h.alert_no_button, new ac(this, cwVar));
            aVar.ak(false);
            aVar.b(getPageContext()).sU();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                cwVar.x(shareFromPBMsgData.getImageUrl(), this.cbG.getPbData().acV() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.cbG != null && this.cbG.getPbData() != null && this.cbG.getPbData().acQ() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            cw cwVar = new cw(getPageContext().getPageActivity());
            cwVar.setData(shareFromPBMsgData);
            aVar.bH(1);
            aVar.m(cwVar);
            aVar.a(i.h.share, new ad(this, cwVar, i, str, j, shareFromPBMsgData));
            aVar.b(i.h.alert_no_button, new ae(this, cwVar));
            aVar.ak(false);
            aVar.b(getPageContext()).sU();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                cwVar.x(shareFromPBMsgData.getImageUrl(), this.cbG.getPbData().acV() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adt() {
        MarkData iI;
        if (this.cbH != null && (iI = this.cbG.iI(this.cbL.aeF())) != null) {
            if (!iI.isApp() || (iI = this.cbG.iI(this.cbL.aeF() + 1)) != null) {
                this.cbL.aez();
                this.cbH.a(iI);
                if (!this.cbH.qo()) {
                    this.cbH.qq();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.cbH.qp();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adu() {
        com.baidu.tieba.pb.a.b pbData = this.cbG.getPbData();
        this.cbG.eu(true);
        pbData.jo(this.cbH.qn());
        this.cbL.h(pbData);
    }

    private boolean adv() {
        if (this.cbG == null) {
            return true;
        }
        if (this.cbG.qo()) {
            MarkData adX = this.cbG.adX();
            if (adX == null || !this.cbG.getIsFromMark()) {
                return true;
            }
            MarkData iI = this.cbG.iI(this.cbL.aeF());
            if (iI == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, adX);
                setResult(-1, intent);
                return true;
            } else if (iI.getPostId() == null || iI.getPostId().equals(adX.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, adX);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.ct(String.format(getPageContext().getString(i.h.alert_update_mark), Integer.valueOf(iI.getFloor())));
                aVar.a(i.h.alert_yes_btn, new af(this, iI, adX));
                aVar.b(i.h.alert_no_button, new ag(this, adX));
                aVar.a(new ah(this, adX));
                aVar.b(getPageContext());
                aVar.sU();
                return false;
            }
        } else if (this.cbG.getPbData() == null || this.cbG.getPbData().acR() == null || this.cbG.getPbData().acR().size() <= 0 || !this.cbG.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.cbL == null) {
            return null;
        }
        return this.cbL.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int getRichTextViewId() {
        if (this.cbL == null) {
            return 0;
        }
        return this.cbL.aeI();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vL() {
        if (this.cbL == null) {
            return 0;
        }
        return this.cbL.LX();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<ImageView> getImageViewPool() {
        if (this.aDn == null) {
            this.aDn = new com.baidu.adp.lib.e.b<>(new aj(this), 8, 0);
        }
        return this.aDn;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<TextView> getTextViewPool() {
        if (this.aDo == null) {
            this.aDo = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.aDo;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<GifView> getGifViewPool() {
        if (this.aDr == null) {
            this.aDr = new com.baidu.adp.lib.e.b<>(new ak(this), 20, 0);
        }
        return this.aDr;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<View> getVoiceViewPool() {
        if (this.aDp == null) {
            this.aDp = new com.baidu.adp.lib.e.b<>(new al(this), 8, 0);
        }
        return this.aDp;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> vM() {
        if (this.afu == null) {
            this.afu = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.afu;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    public boolean jq(String str) {
        Map<String, String> dl;
        if (!TextUtils.isEmpty(str) && (dl = com.baidu.tbadk.core.util.ax.dl(com.baidu.tbadk.core.util.ax.dm(str))) != null) {
            String str2 = dl.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return jq(com.baidu.adp.lib.util.j.aS(str2));
            }
            String str3 = dl.get(cbB);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onLinkClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (jr(str) || z) {
                boolean v = com.baidu.adp.lib.util.k.v(context, "com.qiyi.video");
                js(str);
                if (v) {
                    adw();
                } else {
                    adx();
                }
            } else if (jq(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                com.baidu.tbadk.core.util.ax.uX().b(getPageContext(), new String[]{str});
            }
        }
    }

    private boolean jr(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }

    private void js(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(";")) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.cby = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.cbz = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.aPZ = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.cbx = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void adw() {
        if (TextUtils.isEmpty(this.cby) || TextUtils.isEmpty(this.cbz) || TextUtils.isEmpty(this.mPackageName)) {
            if (!TextUtils.isEmpty(this.cbx)) {
                com.baidu.tbadk.browser.g.b(getPageContext().getPageActivity(), false, this.cbx);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(this.cby));
        intent.setAction(this.cbz);
        intent.setPackage(this.mPackageName);
        if (intent.resolveActivity(getPageContext().getPageActivity().getPackageManager()) != null) {
            if (!com.baidu.adp.lib.g.i.e(getPageContext().getPageActivity(), intent) && !TextUtils.isEmpty(this.cbx)) {
                com.baidu.tbadk.browser.g.b(getPageContext().getPageActivity(), false, this.cbx);
            }
        } else if (!TextUtils.isEmpty(this.cbx)) {
            com.baidu.tbadk.browser.g.b(getPageContext().getPageActivity(), false, this.cbx);
        }
    }

    private void adx() {
        if (!com.baidu.adp.lib.util.i.iM()) {
            if (!TextUtils.isEmpty(this.cbx)) {
                com.baidu.tbadk.browser.g.b(getPageContext().getPageActivity(), false, this.cbx);
                return;
            }
            return;
        }
        if (this.cbw == null) {
            this.cbw = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.cbw.bF(i.h.download_iqiyi_app_dialog);
            this.cbw.a(i.h.install_app, new am(this));
            this.cbw.b(i.h.webpage_play, new an(this));
            this.cbw.ak(false);
        }
        this.cbw.b(getPageContext()).sU();
    }

    private com.baidu.tbadk.core.dialog.a ady() {
        if (this.cbD == null) {
            this.cbD = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.cbD.cs(getPageContext().getString(i.h.download_baidu_video_dialog));
            this.cbD.a(getPageContext().getString(i.h.install), new ao(this));
            this.cbD.b(getPageContext().getString(i.h.cancel), new ap(this));
            this.cbD.aj(true);
            this.cbD.b(getPageContext());
            this.cbD.ak(false);
        }
        this.cbD.sU();
        return this.cbD;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onVideoClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (jr(str) || z) {
                boolean v = com.baidu.adp.lib.util.k.v(context, "com.qiyi.video");
                js(str);
                if (v) {
                    adw();
                    return;
                } else {
                    adx();
                    return;
                }
            }
            com.baidu.tbadk.core.util.ax.uX().b(getPageContext(), new String[]{str});
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
            ady();
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
        com.baidu.tbadk.widget.richText.f Fl;
        if (aVar == aVar2) {
            this.ccg = true;
        }
        if (aVar != null) {
            int size = aVar.Fg().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.Fg().get(i6) != null && aVar.Fg().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.Fg().get(i6).Fl().getWidth();
                    int height = aVar.Fg().get(i6).Fl().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.Fg().get(i6).Fl().Ft()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.Fg().get(i6);
                        String b2 = b(cVar);
                        arrayList.add(b2);
                        if (!TextUtils.isEmpty(b2) && cVar != null && (Fl = cVar.Fl()) != null) {
                            String Fu = Fl.Fu();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Fu;
                            int i8 = this.mIsFromCDN ? 17 : 18;
                            imageUrlData.urlType = i8;
                            imageUrlData.urlType = i8;
                            if (hashMap != null) {
                                hashMap.put(b2, imageUrlData);
                            }
                        }
                        if (!this.ccg) {
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
            if (iVar.getId() != null && iVar.getId().equals(this.cbG.ss())) {
                z = true;
            }
            MarkData c = this.cbG.c(iVar);
            if (c != null) {
                this.cbL.aez();
                if (this.cbH != null) {
                    this.cbH.a(c);
                    if (!z) {
                        this.cbH.qq();
                    } else {
                        this.cbH.qp();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a T(String str, int i) {
        if (this.cbG == null || this.cbG.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.a.b pbData = this.cbG.getPbData();
        com.baidu.tbadk.widget.richText.a a2 = a(pbData.acR(), str, i);
        if (a2 == null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.i> acR = pbData.acR();
            int size = acR.size();
            for (int i2 = 0; i2 < size; i2++) {
                a2 = a(acR.get(i2).aui(), str, i);
                if (a2 != null) {
                    return a2;
                }
            }
            return a2;
        }
        return a2;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.data.i> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> Fg;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a auk = arrayList.get(i2).auk();
            if (auk != null && (Fg = auk.Fg()) != null) {
                int size = Fg.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Fg.get(i4) != null && Fg.get(i4).getType() == 8) {
                        i3++;
                        if (Fg.get(i4).Fl().Fu().equals(str)) {
                            int width = Fg.get(i4).Fl().getWidth();
                            int height = Fg.get(i4).Fl().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.ccf = i4;
                            return auk;
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
        com.baidu.tbadk.widget.richText.f Fl = cVar.Fl();
        if (Fl != null) {
            if (!StringUtils.isNull(Fl.Fs())) {
                return Fl.Fs();
            }
            if (Fl.getHeight() * Fl.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Fl.getHeight() * Fl.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Fl.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Fl.getHeight())));
            } else {
                float width = Fl.getWidth() / Fl.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.aq.aR(Fl.getSrc()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onPhoneClicked(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.cbt = str;
            if (this.cbC == null) {
                ado();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.cbC.bM(1).setVisibility(8);
            } else {
                this.cbC.bM(1).setVisibility(0);
            }
            this.cbC.sX();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adz() {
        hideNetRefreshView(this.cbL.getView());
        showLoadingView(this.cbL.getView(), true);
        if (this.cbG.Df()) {
            this.cbL.aez();
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
        if (this.cbG.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.a.b pbData = this.cbG.getPbData();
            String name = pbData.acP().getName();
            String title = pbData.acQ().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.cbG.getThreadID() + "?share=9105&fr=share";
            String[] aF = pbData.aF(getPageContext().getPageActivity());
            String str2 = aF[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String format = MessageFormat.format(getResources().getString(i.h.share_content_tpl), title, name, aF[1]);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.linkUrl = str;
            if (parse != null) {
                fVar.imageUri = parse;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10125").af("tid", this.cbG.getThreadID()));
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true, qz());
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(i.h.share_tieba_qunzu, i.e.icon_unite_share_qunzu, new aq(this));
            shareDialogConfig.addOutsideTextView(i.h.forum_friend, i.e.icon_unite_share_baf, new ar(this));
            shareDialogConfig.setCopyLinkListener(new as(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private SparseArray<String> qz() {
        if (this.beE == null) {
            this.beE = new SparseArray<>(7);
            this.beE.put(2, "pb_wx_timeline");
            this.beE.put(3, "pb_wx_friend");
            this.beE.put(4, "pb_qq_zone");
            this.beE.put(5, "pb_tencent_weibo");
            this.beE.put(6, "pb_sina_weibo");
            this.beE.put(7, "pb_renren");
        }
        return this.beE;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool() {
        if (this.aDq == null) {
            this.aDq = new com.baidu.adp.lib.e.b<>(new au(this), 15, 0);
        }
        return this.aDq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adA() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.pb.a.b pbData = this.cbG.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.rK().isIfAddition();
            AdditionData acX = pbData.acX();
            boolean z3 = acX == null ? false : isIfAddition;
            if (z3) {
                z = acX.getAlreadyCount() != acX.getTotalCount();
                if (!TextUtils.isEmpty(acX.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.pb.main.b.a aVar = this.cbL.ceJ;
            if (!z3 || !z) {
                z2 = false;
            }
            aVar.eL(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.cbL.aet() == view && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.core.data.x acQ = this.cbG.getPbData().acQ();
            if (view != null) {
                boolean z = acQ.getPraise() == null || acQ.getPraise().getIsLike() == 0;
                if (motionEvent.getAction() == 0) {
                    if (System.currentTimeMillis() - this.aTM > 1000) {
                        this.aTN = true;
                        y(view);
                    } else {
                        this.aTN = false;
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (z) {
                        d(view, this.aTN);
                    } else {
                        c(view, this.aTN);
                    }
                } else if (motionEvent.getAction() == 2) {
                    c(view, this.aTN);
                } else if (motionEvent.getAction() == 3) {
                    c(view, this.aTN);
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

    public void Lk() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.h.login_to_use), true, 11017)));
        } else if (!this.cbI.avb()) {
            this.cbL.aew();
            if (aVar.sV() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.sV();
                int intValue = ((Integer) sparseArray.get(i.f.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(i.f.tag_del_post_is_self)).booleanValue();
                int intValue2 = ((Integer) sparseArray.get(i.f.tag_del_post_type)).intValue();
                this.cbI.a(this.cbG.getPbData().acP().getId(), this.cbG.getPbData().acP().getName(), this.cbG.getPbData().acQ().getId(), (String) sparseArray.get(i.f.tag_del_post_id), intValue2, intValue, booleanValue);
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
        this.cbJ.a(z, str, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
    }

    private boolean jt(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bb.ah(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.tx().getString("bubble_link", ""))) {
                return false;
            }
            com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), getResources().getString(i.h.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void el(boolean z) {
        this.cbR = z;
    }
}
