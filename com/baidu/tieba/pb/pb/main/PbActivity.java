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
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.bl;
import com.baidu.tieba.tbadkCore.g.a;
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
    private static String cib = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aBT;
    private com.baidu.adp.lib.e.b<TextView> aBU;
    private com.baidu.adp.lib.e.b<View> aBV;
    private com.baidu.adp.lib.e.b<LinearLayout> aBW;
    private com.baidu.adp.lib.e.b<GifView> aBX;
    private com.baidu.adp.lib.e.b<TbImageView> aeI;
    private boolean atu;
    private String chT;
    private com.baidu.tbadk.core.dialog.a cie;
    private boolean cis;
    private com.baidu.tieba.tbadkCore.data.b cit;
    private com.baidu.tbadk.editortools.c.d ciu;
    private boolean mIsFromCDN;
    private VoiceManager mVoiceManager;
    private boolean chV = false;
    private boolean bfW = true;
    private boolean cfb = false;
    private com.baidu.tbadk.core.dialog.a chW = null;
    private String chX = null;
    private String aPf = null;
    private String chY = null;
    private String chZ = null;
    private String mPackageName = null;
    private int cia = 0;
    private com.baidu.tbadk.core.dialog.c cic = null;
    SparseArray<String> aUo = null;
    private long aLJ = -1;
    private long axy = 0;
    private long createTime = 0;
    private long axz = 0;
    private boolean cif = false;
    private com.baidu.tbadk.performanceLog.e cig = null;
    private String asc = null;
    private final Handler mHandler = new Handler(new com.baidu.tieba.pb.pb.main.b(this));
    private bl cih = null;
    private com.baidu.tbadk.baseEditMark.a cii = null;
    private com.baidu.tieba.tbadkCore.g.a cij = null;
    private UserMuteAddAndDelModel<PbActivity> cik = null;
    private com.baidu.tieba.usermute.i cil = null;
    private cc cim = null;
    public final com.baidu.tieba.pb.pb.main.a.a cin = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean cio = false;
    private boolean cip = false;
    private MorePopupWindow ciq = null;
    private ca cir = null;
    private boolean aTH = false;
    private com.baidu.tbadk.editortools.c.b ash = new m(this);
    private CustomMessageListener bel = new x(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener aSG = new ai(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener civ = new at(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener ciw = new ax(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener richTextIntentClickListener = new ay(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private View.OnClickListener cix = new az(this);
    private boolean aSx = false;
    private com.baidu.tieba.tbadkCore.ae aSJ = new com.baidu.tieba.tbadkCore.ae(getPageContext(), new ba(this));
    private long aST = 0;
    private boolean aSU = true;
    private com.baidu.tieba.pb.b.c cgS = new com.baidu.tieba.pb.b.c(new c(this));
    private UserMuteAddAndDelModel.a ciy = new d(this);
    private i.a ciz = new e(this);
    public a.b cbG = new f(this);
    public final View.OnClickListener aWQ = new g(this);
    private final a.d ask = new h(this);
    private final bl.a ciA = new i(this);
    private final a.InterfaceC0039a ciB = new j(this);
    private final AbsListView.OnScrollListener HC = new k(this);
    private final com.baidu.adp.base.g ciC = new l(this);
    private final b ciD = new n(this);
    private final p.a aHc = new o(this);
    private final BdListView.e ciE = new p(this);
    private final BdListView.h ciF = new q(this);
    private int ciG = 0;
    private final TbRichTextView.c aCn = new r(this);
    boolean ciH = false;
    com.baidu.tieba.tbadkCore.data.k ciI = null;
    private final c.b ciJ = new s(this);
    private final View.OnLongClickListener ajU = new t(this);
    private final NoNetworkView.a aSa = new u(this);

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* loaded from: classes.dex */
    public interface b {
        void ev(boolean z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    public void b(com.baidu.tieba.pb.a.c cVar) {
        if (cVar.aeZ() != null) {
            String id = cVar.aeZ().getId();
            ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP = this.cih.getPbData().aeP();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aeP.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = aeP.get(i2);
                if (kVar.getId() == null || !kVar.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.data.k> afd = cVar.afd();
                    kVar.kV(cVar.getTotalCount());
                    if (kVar.awE() != null) {
                        kVar.awE().clear();
                        kVar.awE().addAll(afd);
                    }
                }
            }
            this.cim.h(this.cih.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afj() {
        com.baidu.tieba.pb.a.b pbData;
        com.baidu.tbadk.core.data.w aeO;
        if (!this.aSx) {
            if (!com.baidu.adp.lib.util.k.jd()) {
                showToast(i.h.no_network_guide);
            } else if (this.aSU) {
                this.aSx = true;
                if (this.cih != null && (pbData = this.cih.getPbData()) != null && (aeO = pbData.aeO()) != null) {
                    int isLike = aeO.getPraise() == null ? 0 : aeO.getPraise().getIsLike();
                    if (this.aSJ != null) {
                        this.aSJ.a(aeO.ss(), aeO.getId(), isLike, "pb");
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
        cVar.d(getPageContext()).sU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(int i) {
        com.baidu.tbadk.core.data.w aeO;
        String sb;
        String s;
        if (this.cih != null && this.cih.getPbData() != null && (aeO = this.cih.getPbData().aeO()) != null) {
            if (i == 1) {
                PraiseData praise = aeO.getPraise();
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
                        aeO.setPraise(praiseData);
                    } else {
                        aeO.getPraise().getUser().add(0, metaData);
                        aeO.getPraise().setNum(aeO.getPraise().getNum() + 1);
                        aeO.getPraise().setIsLike(i);
                    }
                }
                if (aeO.getPraise() != null) {
                    if (aeO.getPraise().getNum() < 1) {
                        s = getResources().getString(i.h.frs_item_praise_text);
                    } else {
                        s = com.baidu.tbadk.core.util.as.s(aeO.getPraise().getNum());
                    }
                    this.cim.C(s, true);
                }
            } else if (aeO.getPraise() != null) {
                aeO.getPraise().setIsLike(i);
                aeO.getPraise().setNum(aeO.getPraise().getNum() - 1);
                ArrayList<MetaData> user = aeO.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aeO.getPraise().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aeO.getPraise().getNum() < 1) {
                    sb = getResources().getString(i.h.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(aeO.getPraise().getNum())).toString();
                }
                this.cim.C(sb, false);
            }
            if (this.cih.afL()) {
                this.cim.ags().notifyDataSetChanged();
            } else {
                this.cim.i(this.cih.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cih.saveToBundle(bundle);
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.ciu.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.aLJ = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aLJ = System.currentTimeMillis();
        }
        this.cia = 0;
        initUI();
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.c.l lVar = new com.baidu.tbadk.editortools.c.l();
        lVar.setForumName(this.cih.afK());
        if (this.cih.getPbData() != null && this.cih.getPbData().aeN() != null) {
            lVar.setForumId(this.cih.getPbData().aeN().getId());
        }
        lVar.setFrom("pb");
        lVar.a(this.cih);
        this.ciu = (com.baidu.tbadk.editortools.c.d) lVar.ak(getActivity());
        this.ciu.b(this);
        this.ciu.a(this.ask);
        this.ciu.a(this.ash);
        this.ciu.a(this, bundle);
        this.cim.setEditorTools(this.ciu.Ax());
        registerListener(this.aSG);
        if (!this.cih.afP()) {
            this.ciu.eY(this.cih.getThreadID());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.aLJ;
        registerListener(this.bel);
        registerListener(this.civ);
        registerListener(this.ciw);
        this.cit = new com.baidu.tieba.tbadkCore.data.b("pb");
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

    public bl afk() {
        return this.cih;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.chV = true;
        super.onPause();
        BdListView listView = getListView();
        this.cia = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.cia == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
        if (this.cim != null) {
            this.cim.onPause();
        }
        if (!this.cih.afP()) {
            this.ciu.eX(this.cih.getThreadID());
        }
        MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.chV = false;
        super.onResume();
        if (this.cim != null && this.cim.getView() != null) {
            if (!this.cfb) {
                showLoadingView(this.cim.getView(), true);
            } else {
                hideLoadingView(this.cim.getView());
            }
        }
        if (this.cia == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView agm = this.cim.agm();
        if (agm != null && agm.getVisibility() == 0 && com.baidu.adp.lib.util.i.iM()) {
            agm.aw(false);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
        registerListener(this.richTextIntentClickListener);
        this.cis = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.cim.eG(z);
        if (this.cir != null) {
            this.cir.eD(z);
        }
        if (z && this.cis) {
            this.cim.agz();
            this.cih.ex(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ciu != null && this.ciu.Ax() != null && this.ciu.Ax().getVisibility() != 0) {
            this.ciu.Bu();
        }
        if (this.cim.ckl != null && !this.cim.ckl.agX()) {
            this.cim.ckl.aaK();
        }
        if (this.cih != null && this.cih.getPbData() != null && this.cih.getPbData().aeN() != null && this.cih.getPbData().aeO() != null) {
            com.baidu.tbadk.distribute.a.Ag().a(getPageContext().getPageActivity(), "pb", this.cih.getPbData().aeN().getId(), com.baidu.adp.lib.g.b.c(this.cih.getPbData().aeO().getId(), 0L));
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (!this.cif) {
            this.cif = true;
            this.cim.agP();
        }
        this.cil.onDestroy();
        this.cih.cancelLoadData();
        this.cih.destory();
        this.ciu.onDestroy();
        this.cij.cancelLoadData();
        this.cim.onDestroy();
        if (this.cim.ckl != null) {
            this.cim.ckl.aaK();
        }
        if (this.cig != null) {
            this.cig.onDestroy();
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
        this.cim.onChangeSkinType(i);
        if (this.ciu != null && this.ciu.Ax() != null) {
            this.ciu.Ax().onChangeSkinType(i);
        }
        if (this.ciq != null) {
            this.ciq.onChangeSkinType(this, i, com.baidu.tbadk.core.util.an.getDrawable(i.e.bg_collect));
        }
        if (this.cim.agm() != null) {
            this.cim.agm().onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afl() {
        this.cir = new ca(getPageContext(), this.aWQ);
        this.cir.eD(this.mIsLogin);
        this.ciq = new MorePopupWindow(getPageContext().getPageActivity(), this.cir.getView(), getResources().getDrawable(i.e.bg_collect), null);
        this.ciq.setTouchInterceptor(new w(this));
        this.ciq.onChangeSkinType(this, TbadkCoreApplication.m411getInst().getSkinType(), com.baidu.tbadk.core.util.an.getDrawable(i.e.bg_collect));
    }

    private void initUI() {
        this.cim = new cc(this, this.aWQ, this.cgS);
        this.cim.setOnScrollListener(this.HC);
        this.cim.c(this.ciE);
        this.cim.a(this.ciF);
        this.cim.a(this.aHc);
        this.cim.ep(com.baidu.tbadk.core.m.qX().rb());
        this.cim.eq(com.baidu.tbadk.core.m.qX().qZ());
        this.cim.setOnImageClickListener(this.aCn);
        this.cim.a(this.ajU);
        this.cim.g(this.aSa);
        this.cim.a(this.ciD);
        this.cim.eG(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean W(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(i.f.tag_clip_board);
            if (obj instanceof com.baidu.tieba.tbadkCore.data.k) {
                com.baidu.tieba.tbadkCore.data.k kVar = (com.baidu.tieba.tbadkCore.data.k) obj;
                if (TextUtils.isEmpty(kVar.getBimg_url()) || !com.baidu.tbadk.core.m.qX().rb()) {
                    return false;
                }
                return jM(kVar.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.cim != null) {
            if (z && !this.cfb) {
                if (this.bfW) {
                    this.bfW = false;
                    showLoadingView(this.cim.getView(), true);
                    return;
                }
                return;
            }
            hideLoadingView(this.cim.getView());
        }
    }

    private void afm() {
        if (this.cic == null) {
            this.cic = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.cic.a(new String[]{getPageContext().getString(i.h.call_phone), getPageContext().getString(i.h.sms_phone), getPageContext().getString(i.h.search_in_baidu)}, new y(this)).bJ(c.a.WV).bK(17).d(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        this.cih = new bl(this);
        this.cih.a(this.ciA);
        this.cii = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.cii != null) {
            this.cii.a(this.ciB);
        }
        this.cij = new com.baidu.tieba.tbadkCore.g.a(this);
        this.cij.setLoadDataCallBack(this.ciC);
        this.cik = new UserMuteAddAndDelModel<>(this);
        this.cik.a(this.ciy);
        this.cil = new com.baidu.tieba.usermute.i(getPageContext(), this.ciz);
        if (bundle != null) {
            this.cih.initWithBundle(bundle);
        } else {
            this.cih.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra("request_code", -1) == 18003) {
            this.cih.eA(true);
        }
        bx.age().B(this.cih.afJ(), this.cih.getIsFromMark());
        this.cim.agx();
        if (StringUtils.isNull(this.cih.getThreadID())) {
            finish();
            return;
        }
        this.cih.CS();
        this.cim.a(new z(this));
        this.aSJ.setUniqueId(getUniqueId());
        this.aSJ.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = (String) sparseArray.get(i.f.tag_disable_reply_mute_userid);
        this.cim.Zf();
        this.cil.a(com.baidu.adp.lib.g.b.c(currentAccount, 0L), com.baidu.adp.lib.g.b.c(str, 0L), sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean es(boolean z) {
        if (this.cih == null || this.cih.getPbData() == null) {
            return false;
        }
        return ((this.cih.getPbData().aeS() != 0) || this.cih.getPbData().aeO() == null || this.cih.getPbData().aeO().getAuthor() == null || TextUtils.equals(this.cih.getPbData().aeO().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void afn() {
        if (this.cih != null && this.cih.getPbData() != null && this.cih.getPbData().aeO() != null && this.cih.getPbData().aeO().getAuthor() != null) {
            this.cim.ckl.c(this.cih.afL(), this.cii != null ? this.cii.qk() : false, es(TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.cih.getPbData().aeO().getAuthor().getUserId())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.tbadkCore.data.k kVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (kVar = (com.baidu.tieba.tbadkCore.data.k) sparseArray.get(i.f.tag_clip_board)) != null) {
            c(kVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        afx();
    }

    public void a(boolean z, MarkData markData) {
        this.cim.agB();
        this.cih.ez(z);
        if (this.cii != null) {
            this.cii.ab(z);
            if (markData != null) {
                this.cii.a(markData);
            }
        }
        if (this.cih.qk()) {
            afs();
        } else {
            this.cim.h(this.cih.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jI(String str) {
        if (!StringUtils.isNull(str) && this.cih != null) {
            String threadID = this.cih.getThreadID();
            String id = this.cih.getPbData().aeN().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(i.h.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData)) {
                if (!this.cih.afP()) {
                    antiData.setBlock_forum_name(this.cih.getPbData().aeN().getName());
                    antiData.setBlock_forum_id(this.cih.getPbData().aeN().getId());
                    antiData.setUser_name(this.cih.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.cih.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.e.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.lc(i)) {
            AntiHelper.P(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            this.cik.fd(str);
        } else {
            this.cim.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        int i = 0;
        if (bVar != null) {
            this.cim.a(0, bVar.An, bVar.dbb, true);
            if (bVar.An) {
                if (bVar.daZ == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP = this.cih.getPbData().aeP();
                    int size = aeP.size();
                    while (true) {
                        if (i < size) {
                            if (!bVar.mPostId.equals(aeP.get(i).getId())) {
                                i++;
                            } else {
                                aeP.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.cim.h(this.cih.getPbData());
                } else if (bVar.daZ == 0) {
                    afo();
                } else if (bVar.daZ == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP2 = this.cih.getPbData().aeP();
                    int size2 = aeP2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < aeP2.get(i2).awE().size()) {
                                if (!bVar.mPostId.equals(aeP2.get(i2).awE().get(i3).getId())) {
                                    i3++;
                                } else {
                                    aeP2.get(i2).awE().remove(i3);
                                    aeP2.get(i2).awG();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData aeV = this.cih.getPbData().aeV();
                        com.baidu.tieba.tbadkCore.data.k kVar = aeP2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.data.k> awH = kVar.awH();
                        int size3 = awH.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!bVar.mPostId.equals(aeP2.get(i2).awH().get(i4).getId())) {
                                    i4++;
                                } else {
                                    awH.remove(i4);
                                    aeV.decreaseAlreadyCount();
                                    if (kVar.awO() > awH.size()) {
                                        kVar.kX(awH.size());
                                    }
                                    if (awH.size() > 0) {
                                        com.baidu.tieba.tbadkCore.data.k kVar2 = awH.get(awH.size() - 1);
                                        aeV.setLastAdditionTime(kVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a awJ = kVar2.awJ();
                                        String str = "";
                                        if (awJ != null) {
                                            str = awJ.toString();
                                        }
                                        aeV.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a awJ2 = kVar.awJ();
                                        String str2 = "";
                                        if (awJ2 != null) {
                                            str2 = awJ2.toString();
                                        }
                                        aeV.setLastAdditionContent(str2);
                                    }
                                    afy();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.cim.h(this.cih.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.d dVar) {
        this.cim.a(1, dVar.An, dVar.dbb, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.f fVar) {
        this.cim.a(this.cij.getLoadDataMode(), fVar.An, fVar.dbb, false);
        this.cim.R(fVar.dbd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, a.f fVar) {
        if (fVar != null) {
            this.cim.a(this.cij.getLoadDataMode(), fVar.An, fVar.dbb, true);
            if (fVar.An) {
                this.cip = true;
                if (i == 2) {
                    this.cih.getPbData().aeO().bB(1);
                    this.cih.setIsGood(1);
                } else if (i == 3) {
                    this.cih.getPbData().aeO().bB(0);
                    this.cih.setIsGood(0);
                } else if (i == 4) {
                    this.cih.getPbData().aeO().bA(1);
                    this.cih.iL(1);
                } else if (i == 5) {
                    this.cih.getPbData().aeO().bA(0);
                    this.cih.iL(0);
                }
                this.cim.a(this.cih.getPbData(), this.cih.afL(), true);
            }
        }
    }

    private void afo() {
        if (this.cih.afM()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.cih.getThreadID());
            setResult(-1, intent);
        }
        if (aft()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afp() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        this.cim.agM();
        if (this.cih != null && this.cih.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.cih.getPbData().aeO().getId();
            historyMessage.forumName = this.cih.getPbData().aeN().getName();
            historyMessage.threadName = this.cih.getPbData().aeO().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP = this.cih.getPbData().aeP();
            int agD = this.cim.agD();
            if (aeP != null && agD >= 0 && agD < aeP.size()) {
                historyMessage.postID = aeP.get(agD).getId();
            }
            historyMessage.isHostOnly = this.cih.getHostMode();
            historyMessage.isSquence = this.cih.afL();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.cih != null && this.cih.afM()) {
            Intent intent = new Intent();
            if (this.cip) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.cih.getThreadID());
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.cih.afO());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.cih.getIsGood());
            }
            setResult(-1, intent);
        }
        if (aft()) {
            if (this.cih != null && this.cim != null && this.cim.getListView() != null) {
                com.baidu.tieba.pb.a.b pbData = this.cih.getPbData();
                if (pbData != null && pbData.getUserData() != null) {
                    pbData.getUserData().setBimg_url(TbadkCoreApplication.m411getInst().getDefaultBubble());
                }
                bx.age().a(this.cih.getPbData(), this.cim.getListView().onSaveInstanceState(), this.cih.afL(), this.cih.getHostMode());
            } else {
                bx.age().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.ciq != null) {
                    com.baidu.adp.lib.g.j.a(this.ciq, getPageContext().getPageActivity());
                }
                finish();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iJ(int i) {
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
        this.ciu.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    afr();
                    return;
                case 13008:
                    bx.age().reset();
                    this.mHandler.postDelayed(new aa(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.cih != null) {
                        a(afq(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    N(intent);
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData afq() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] aE = this.cih.getPbData().aE(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.data.k agp = this.cim.agp();
        String str = "";
        if (agp != null) {
            str = agp.getId();
            String aT = agp.aT(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(aT)) {
                aE[1] = aT;
            }
        }
        String ss = this.cih.getPbData().aeO().ss();
        if (ss != null && ss.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(aE[1]);
        shareFromPBMsgData.setImageUrl(aE[0]);
        shareFromPBMsgData.setForumName(this.cih.getPbData().aeN().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.cih.getPbData().aeO().getId());
        shareFromPBMsgData.setTitle(this.cih.getPbData().aeO().getTitle());
        return shareFromPBMsgData;
    }

    private void N(Intent intent) {
        a(afq(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.cih != null && this.cih.getPbData() != null && this.cih.getPbData().aeO() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            cx cxVar = new cx(getPageContext().getPageActivity());
            cxVar.setData(shareFromPBMsgData);
            aVar.bH(1);
            aVar.m(cxVar);
            aVar.a(i.h.share, new ab(this, cxVar, j, str, str2, shareFromPBMsgData));
            aVar.b(i.h.alert_no_button, new ac(this, cxVar));
            aVar.ak(false);
            aVar.b(getPageContext()).sR();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                cxVar.w(shareFromPBMsgData.getImageUrl(), this.cih.getPbData().aeT() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.cih != null && this.cih.getPbData() != null && this.cih.getPbData().aeO() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            cx cxVar = new cx(getPageContext().getPageActivity());
            cxVar.setData(shareFromPBMsgData);
            aVar.bH(1);
            aVar.m(cxVar);
            aVar.a(i.h.share, new ad(this, cxVar, i, str, j, shareFromPBMsgData));
            aVar.b(i.h.alert_no_button, new ae(this, cxVar));
            aVar.ak(false);
            aVar.b(getPageContext()).sR();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                cxVar.w(shareFromPBMsgData.getImageUrl(), this.cih.getPbData().aeT() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afr() {
        MarkData iS;
        if (this.cii != null && (iS = this.cih.iS(this.cim.agD())) != null) {
            if (!iS.isApp() || (iS = this.cih.iS(this.cim.agD() + 1)) != null) {
                this.cim.agx();
                this.cii.a(iS);
                if (!this.cii.qk()) {
                    this.cii.qm();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.cii.ql();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afs() {
        com.baidu.tieba.pb.a.b pbData = this.cih.getPbData();
        this.cih.ez(true);
        pbData.jG(this.cii.qj());
        this.cim.h(pbData);
    }

    private boolean aft() {
        if (this.cih == null) {
            return true;
        }
        if (this.cih.qk()) {
            MarkData afV = this.cih.afV();
            if (afV == null || !this.cih.getIsFromMark()) {
                return true;
            }
            MarkData iS = this.cih.iS(this.cim.agD());
            if (iS == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, afV);
                setResult(-1, intent);
                return true;
            } else if (iS.getPostId() == null || iS.getPostId().equals(afV.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, afV);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cu(String.format(getPageContext().getString(i.h.alert_update_mark), Integer.valueOf(iS.getFloor())));
                aVar.a(i.h.alert_yes_btn, new af(this, iS, afV, aVar));
                aVar.b(i.h.alert_no_button, new ag(this, afV, aVar));
                aVar.a(new ah(this, afV, aVar));
                aVar.b(getPageContext());
                aVar.sR();
                return false;
            }
        } else if (this.cih.getPbData() == null || this.cih.getPbData().aeP() == null || this.cih.getPbData().aeP().size() <= 0 || !this.cih.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.cim == null) {
            return null;
        }
        return this.cim.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int getRichTextViewId() {
        if (this.cim == null) {
            return 0;
        }
        return this.cim.agG();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vD() {
        if (this.cim == null) {
            return 0;
        }
        return this.cim.LW();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<ImageView> getImageViewPool() {
        if (this.aBT == null) {
            this.aBT = new com.baidu.adp.lib.e.b<>(new aj(this), 8, 0);
        }
        return this.aBT;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<TextView> getTextViewPool() {
        if (this.aBU == null) {
            this.aBU = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.aBU;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<GifView> getGifViewPool() {
        if (this.aBX == null) {
            this.aBX = new com.baidu.adp.lib.e.b<>(new ak(this), 20, 0);
        }
        return this.aBX;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<View> getVoiceViewPool() {
        if (this.aBV == null) {
            this.aBV = new com.baidu.adp.lib.e.b<>(new al(this), 8, 0);
        }
        return this.aBV;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> vE() {
        if (this.aeI == null) {
            this.aeI = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.aeI;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    public boolean jJ(String str) {
        Map<String, String> dr;
        if (!TextUtils.isEmpty(str) && (dr = com.baidu.tbadk.core.util.az.dr(com.baidu.tbadk.core.util.az.ds(str))) != null) {
            String str2 = dr.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return jJ(com.baidu.adp.lib.util.j.aS(str2));
            }
            String str3 = dr.get(cib);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onLinkClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (jK(str) || z) {
                boolean v = com.baidu.adp.lib.util.k.v(context, "com.qiyi.video");
                jL(str);
                if (v) {
                    afu();
                } else {
                    afv();
                }
            } else if (jJ(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                com.baidu.tbadk.core.util.az.uW().b(getPageContext(), new String[]{str});
            }
        }
    }

    private boolean jK(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }

    private void jL(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(";")) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.chY = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.chZ = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.aPf = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.chX = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void afu() {
        if (TextUtils.isEmpty(this.chY) || TextUtils.isEmpty(this.chZ) || TextUtils.isEmpty(this.mPackageName)) {
            if (!TextUtils.isEmpty(this.chX)) {
                com.baidu.tbadk.browser.g.b(getPageContext().getPageActivity(), false, this.chX);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(this.chY));
        intent.setAction(this.chZ);
        intent.setPackage(this.mPackageName);
        if (intent.resolveActivity(getPageContext().getPageActivity().getPackageManager()) != null) {
            if (!com.baidu.adp.lib.g.i.e(getPageContext().getPageActivity(), intent) && !TextUtils.isEmpty(this.chX)) {
                com.baidu.tbadk.browser.g.b(getPageContext().getPageActivity(), false, this.chX);
            }
        } else if (!TextUtils.isEmpty(this.chX)) {
            com.baidu.tbadk.browser.g.b(getPageContext().getPageActivity(), false, this.chX);
        }
    }

    private void afv() {
        if (!com.baidu.adp.lib.util.i.iN()) {
            if (!TextUtils.isEmpty(this.chX)) {
                com.baidu.tbadk.browser.g.b(getPageContext().getPageActivity(), false, this.chX);
                return;
            }
            return;
        }
        if (this.chW == null) {
            this.chW = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.chW.bF(i.h.download_iqiyi_app_dialog);
            this.chW.a(i.h.install_app, new am(this));
            this.chW.b(i.h.webpage_play, new an(this));
            this.chW.ak(false);
        }
        this.chW.b(getPageContext()).sR();
    }

    private com.baidu.tbadk.core.dialog.a afw() {
        if (this.cie == null) {
            this.cie = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.cie.ct(getPageContext().getString(i.h.download_baidu_video_dialog));
            this.cie.a(getPageContext().getString(i.h.install), new ao(this));
            this.cie.b(getPageContext().getString(i.h.cancel), new ap(this));
            this.cie.aj(true);
            this.cie.b(getPageContext());
            this.cie.ak(false);
        }
        this.cie.sR();
        return this.cie;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onVideoClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (jK(str) || z) {
                boolean v = com.baidu.adp.lib.util.k.v(context, "com.qiyi.video");
                jL(str);
                if (v) {
                    afu();
                    return;
                } else {
                    afv();
                    return;
                }
            }
            com.baidu.tbadk.core.util.az.uW().b(getPageContext(), new String[]{str});
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
            afw();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onSongClicked(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.EY() == null) {
            return null;
        }
        return cVar.EY().Fj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long c(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.EY() == null) {
            return 0L;
        }
        return cVar.EY().getOriginalSize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, HashMap<String, ImageUrlData> hashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.f EY;
        if (aVar == aVar2) {
            this.ciH = true;
        }
        if (aVar != null) {
            int size = aVar.ET().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.ET().get(i6) == null || aVar.ET().get(i6).getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int width = aVar.ET().get(i6).EY().getWidth();
                    int height = aVar.ET().get(i6).EY().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.ET().get(i6).EY().Fg()) {
                        if (aVar == aVar2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.ET().get(i6);
                        String d = d(cVar);
                        arrayList.add(d);
                        if (!TextUtils.isEmpty(d) && cVar != null && (EY = cVar.EY()) != null) {
                            String Fh = EY.Fh();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Fh;
                            int i9 = this.mIsFromCDN ? 17 : 18;
                            imageUrlData.urlType = i9;
                            imageUrlData.urlType = i9;
                            imageUrlData.originalUrl = b(cVar);
                            imageUrlData.originalSize = c(cVar);
                            if (hashMap != null) {
                                hashMap.put(d, imageUrlData);
                            }
                        }
                        if (!this.ciH) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tieba.tbadkCore.data.k kVar) {
        if (kVar != null) {
            boolean z = false;
            if (kVar.getId() != null && kVar.getId().equals(this.cih.sn())) {
                z = true;
            }
            MarkData d = this.cih.d(kVar);
            if (d != null) {
                this.cim.agx();
                if (this.cii != null) {
                    this.cii.a(d);
                    if (!z) {
                        this.cii.qm();
                    } else {
                        this.cii.ql();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a W(String str, int i) {
        if (this.cih == null || this.cih.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.a.b pbData = this.cih.getPbData();
        com.baidu.tbadk.widget.richText.a a2 = a(pbData.aeP(), str, i);
        if (a2 == null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP = pbData.aeP();
            int size = aeP.size();
            for (int i2 = 0; i2 < size; i2++) {
                a2 = a(aeP.get(i2).awH(), str, i);
                if (a2 != null) {
                    return a2;
                }
            }
            return a2;
        }
        return a2;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.data.k> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> ET;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a awJ = arrayList.get(i2).awJ();
            if (awJ != null && (ET = awJ.ET()) != null) {
                int size = ET.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (ET.get(i4) != null && ET.get(i4).getType() == 8) {
                        i3++;
                        if (ET.get(i4).EY().Fh().equals(str)) {
                            int width = ET.get(i4).EY().getWidth();
                            int height = ET.get(i4).EY().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.ciG = i4;
                            return awJ;
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
        StringBuilder sb = new StringBuilder((int) SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        com.baidu.tbadk.widget.richText.f EY = cVar.EY();
        if (EY != null) {
            if (!StringUtils.isNull(EY.Ff())) {
                return EY.Ff();
            }
            if (EY.getHeight() * EY.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (EY.getHeight() * EY.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (EY.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * EY.getHeight())));
            } else {
                float width = EY.getWidth() / EY.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.as.aR(EY.getSrc()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onPhoneClicked(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.chT = str;
            if (this.cic == null) {
                afm();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.cic.bM(1).setVisibility(8);
            } else {
                this.cic.bM(1).setVisibility(0);
            }
            this.cic.sU();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afx() {
        hideNetRefreshView(this.cim.getView());
        showLoadingView(this.cim.getView(), true);
        if (this.cih.CS()) {
            this.cim.agx();
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
        if (this.cih.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.a.b pbData = this.cih.getPbData();
            String name = pbData.aeN().getName();
            String title = pbData.aeO().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.cih.getThreadID() + "?share=9105&fr=share";
            String[] aE = pbData.aE(getPageContext().getPageActivity());
            String str2 = aE[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String format = MessageFormat.format(getResources().getString(i.h.share_content_tpl), title, name, aE[1]);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.linkUrl = str;
            fVar.aiP = true;
            fVar.extData = this.cih.getThreadID();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true, qv());
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(i.h.share_tieba_qunzu, i.e.icon_unite_share_qunzu, new aq(this));
            shareDialogConfig.addOutsideTextView(i.h.forum_friend, i.e.icon_unite_share_baf, new ar(this));
            shareDialogConfig.setCopyLinkListener(new as(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private SparseArray<String> qv() {
        if (this.aUo == null) {
            this.aUo = new SparseArray<>(7);
            this.aUo.put(2, "pb_wx_timeline");
            this.aUo.put(3, "pb_wx_friend");
            this.aUo.put(4, "pb_qq_zone");
            this.aUo.put(5, "pb_tencent_weibo");
            this.aUo.put(6, "pb_sina_weibo");
            this.aUo.put(7, "pb_renren");
        }
        return this.aUo;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool() {
        if (this.aBW == null) {
            this.aBW = new com.baidu.adp.lib.e.b<>(new au(this), 15, 0);
        }
        return this.aBW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afy() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.pb.a.b pbData = this.cih.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.rF().isIfAddition();
            AdditionData aeV = pbData.aeV();
            boolean z3 = aeV == null ? false : isIfAddition;
            if (z3) {
                z = aeV.getAlreadyCount() != aeV.getTotalCount();
                if (!TextUtils.isEmpty(aeV.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.pb.main.b.c cVar = this.cim.ckl;
            if (!z3 || !z) {
                z2 = false;
            }
            cVar.eQ(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.cim.agr() == view && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.core.data.w aeO = this.cih.getPbData().aeO();
            if (view != null) {
                boolean z = aeO.getPraise() == null || aeO.getPraise().getIsLike() == 0;
                if (motionEvent.getAction() == 0) {
                    if (System.currentTimeMillis() - this.aST > 1000) {
                        this.aSU = true;
                        y(view);
                    } else {
                        this.aSU = false;
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (z) {
                        d(view, this.aSU);
                    } else {
                        c(view, this.aSU);
                    }
                } else if (motionEvent.getAction() == 2) {
                    c(view, this.aSU);
                } else if (motionEvent.getAction() == 3) {
                    c(view, this.aSU);
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

    public void Lg() {
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
        } else if (!this.cij.axw()) {
            this.cim.agu();
            if (aVar.sS() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.sS();
                int intValue = ((Integer) sparseArray.get(i.f.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(i.f.tag_del_post_is_self)).booleanValue();
                int intValue2 = ((Integer) sparseArray.get(i.f.tag_del_post_type)).intValue();
                this.cij.a(this.cih.getPbData().aeN().getId(), this.cih.getPbData().aeN().getName(), this.cih.getPbData().aeO().getId(), (String) sparseArray.get(i.f.tag_del_post_id), intValue2, intValue, booleanValue);
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
        this.cik.a(z, str, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
    }

    private boolean jM(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bd.ah(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.tu().getString("bubble_link", ""))) {
                return false;
            }
            TiebaStatic.log("c10051");
            com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), getResources().getString(i.h.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void et(boolean z) {
        this.cis = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String afz() {
        ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP;
        int l;
        if (this.cih == null || this.cih.getPbData() == null || this.cih.getPbData().aeP() == null || (l = com.baidu.tbadk.core.util.u.l((aeP = this.cih.getPbData().aeP()))) == 0) {
            return "";
        }
        int agD = this.cim.agD();
        com.baidu.tieba.tbadkCore.data.k kVar = (com.baidu.tieba.tbadkCore.data.k) com.baidu.tbadk.core.util.u.b(aeP, agD);
        if (kVar == null || kVar.getAuthor() == null) {
            return "";
        }
        if (this.cih.jO(kVar.getAuthor().getUserId())) {
            return kVar.getId();
        }
        for (int i = agD - 1; i != 0; i--) {
            com.baidu.tieba.tbadkCore.data.k kVar2 = (com.baidu.tieba.tbadkCore.data.k) com.baidu.tbadk.core.util.u.b(aeP, i);
            if (kVar2 == null || kVar2.getAuthor() == null || kVar2.getAuthor().getUserId() == null) {
                break;
            } else if (this.cih.jO(kVar2.getAuthor().getUserId())) {
                return kVar2.getId();
            }
        }
        for (int i2 = agD + 1; i2 < l; i2++) {
            com.baidu.tieba.tbadkCore.data.k kVar3 = (com.baidu.tieba.tbadkCore.data.k) com.baidu.tbadk.core.util.u.b(aeP, i2);
            if (kVar3 == null || kVar3.getAuthor() == null || kVar3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.cih.jO(kVar3.getAuthor().getUserId())) {
                return kVar3.getId();
            }
        }
        return "";
    }
}
