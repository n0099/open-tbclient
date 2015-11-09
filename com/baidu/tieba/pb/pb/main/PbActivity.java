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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
import com.baidu.tieba.pb.pb.main.ca;
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
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, com.baidu.tbadk.widget.richText.l {
    private static String cje = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aAL;
    private com.baidu.adp.lib.e.b<TextView> aAM;
    private com.baidu.adp.lib.e.b<View> aAN;
    private com.baidu.adp.lib.e.b<LinearLayout> aAO;
    private com.baidu.adp.lib.e.b<GifView> aAP;
    private com.baidu.adp.lib.e.b<TbImageView> aeN;
    private boolean asi;
    private String ciN;
    private com.baidu.tbadk.core.dialog.a cjg;
    private boolean cju;
    private com.baidu.tieba.tbadkCore.data.e cjv;
    private com.baidu.tbadk.editortools.c.e cjw;
    private boolean mIsFromCDN;
    private VoiceManager mVoiceManager;
    private boolean ciY = false;
    private boolean bgC = true;
    private boolean cfC = false;
    private com.baidu.tbadk.core.dialog.a ciZ = null;
    private String cja = null;
    private String aPn = null;
    private String cjb = null;
    private String cjc = null;
    private String mPackageName = null;
    private int cjd = 0;
    private com.baidu.tbadk.core.dialog.c cjf = null;
    SparseArray<String> aUw = null;
    private long aLR = -1;
    private long awn = 0;
    private long createTime = 0;
    private long awo = 0;
    private boolean cjh = false;
    private com.baidu.tbadk.performanceLog.e cji = null;
    private String aqB = null;
    private final Handler mHandler = new Handler(new d(this));
    private ca cjj = null;
    private com.baidu.tbadk.baseEditMark.a cjk = null;
    private com.baidu.tieba.tbadkCore.h.a cjl = null;
    private UserMuteAddAndDelModel<PbActivity> cjm = null;
    private com.baidu.tieba.usermute.i cjn = null;
    private ct cjo = null;
    public final com.baidu.tieba.pb.pb.main.a.a cjp = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean cjq = false;
    private boolean cjr = false;
    private MorePopupWindow cjs = null;
    private cr cjt = null;
    private boolean aTP = false;
    private com.baidu.tbadk.editortools.c.c aqG = new o(this);
    private CustomMessageListener beR = new z(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener aSO = new ak(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener cjx = new av(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener cjy = new ba(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener richTextIntentClickListener = new bb(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private HttpMessageListener cjz = new bc(this, CmdConfigHttp.PB_LOTTERY_HTTP_CMD);
    private View.OnClickListener cjA = new bm(this);
    private boolean aSF = false;
    private com.baidu.tieba.tbadkCore.ae aSR = new com.baidu.tieba.tbadkCore.ae(getPageContext(), new e(this));
    private long aTb = 0;
    private boolean aTc = true;
    private com.baidu.tieba.pb.b.c chs = new com.baidu.tieba.pb.b.c(new f(this));
    private UserMuteAddAndDelModel.a cjB = new g(this);
    private i.a cjC = new h(this);
    public a.b cch = new i(this);
    public final View.OnClickListener aWY = new j(this);
    private final a.d aqM = new k(this);
    private final ca.a cjD = new l(this);
    private final a.InterfaceC0039a cjE = new m(this);
    private final AbsListView.OnScrollListener HD = new n(this);
    private final com.baidu.adp.base.g cjF = new p(this);
    private final b cjG = new q(this);
    private final p.a aFW = new r(this);
    private final BdListView.e cjH = new s(this);
    private final BdListView.h cjI = new t(this);
    private int cjJ = 0;
    private final TbRichTextView.d aBf = new u(this);
    boolean cjK = false;
    com.baidu.tieba.tbadkCore.data.o cjL = null;
    private final c.b cjM = new v(this);
    private final View.OnLongClickListener ajZ = new w(this);
    private final NoNetworkView.a aSi = new x(this);

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* loaded from: classes.dex */
    public interface b {
        void ey(boolean z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.c.e afG() {
        return this.cjw;
    }

    public void iX(int i) {
        if (this.cjj != null && this.cjj.getPbData() != null && this.cjj.getPbData().afg() != null) {
            this.cjj.getPbData().afg().setLike(i);
            com.baidu.tieba.tbadkCore.x xVar = new com.baidu.tieba.tbadkCore.x();
            xVar.setLike(i);
            xVar.kT(-1);
            xVar.setLevelName("");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, xVar));
        }
    }

    public void b(com.baidu.tieba.pb.a.d dVar) {
        if (dVar.afs() != null) {
            String id = dVar.afs().getId();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> afi = this.cjj.getPbData().afi();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= afi.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.o oVar = afi.get(i2);
                if (oVar.getId() == null || !oVar.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.data.o> afw = dVar.afw();
                    oVar.lj(dVar.getTotalCount());
                    if (oVar.axp() != null) {
                        oVar.axp().clear();
                        oVar.axp().addAll(afw);
                    }
                }
            }
            this.cjo.h(this.cjj.getPbData());
        }
    }

    public void afH() {
        com.baidu.tieba.pb.a.c pbData;
        com.baidu.tbadk.core.data.w afh;
        if (!this.aSF) {
            if (!com.baidu.adp.lib.util.k.je()) {
                showToast(i.h.no_network_guide);
            } else if (this.aTc) {
                this.aSF = true;
                if (this.cjj != null && (pbData = this.cjj.getPbData()) != null && (afh = pbData.afh()) != null) {
                    int isLike = afh.getPraise() == null ? 0 : afh.getPraise().getIsLike();
                    if (this.aSR != null) {
                        this.aSR.a(afh.ss(), afh.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

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
        cVar.a(strArr, new y(this, sparseArray, z, str));
        cVar.d(getPageContext()).sU();
    }

    public void fx(int i) {
        com.baidu.tbadk.core.data.w afh;
        String sb;
        String q;
        if (this.cjj != null && this.cjj.getPbData() != null && (afh = this.cjj.getPbData().afh()) != null) {
            if (i == 1) {
                PraiseData praise = afh.getPraise();
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
                        afh.setPraise(praiseData);
                    } else {
                        afh.getPraise().getUser().add(0, metaData);
                        afh.getPraise().setNum(afh.getPraise().getNum() + 1);
                        afh.getPraise().setIsLike(i);
                    }
                }
                if (afh.getPraise() != null) {
                    if (afh.getPraise().getNum() < 1) {
                        q = getResources().getString(i.h.frs_item_praise_text);
                    } else {
                        q = com.baidu.tbadk.core.util.as.q(afh.getPraise().getNum());
                    }
                    this.cjo.C(q, true);
                }
            } else if (afh.getPraise() != null) {
                afh.getPraise().setIsLike(i);
                afh.getPraise().setNum(afh.getPraise().getNum() - 1);
                ArrayList<MetaData> user = afh.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            afh.getPraise().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (afh.getPraise().getNum() < 1) {
                    sb = getResources().getString(i.h.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(afh.getPraise().getNum())).toString();
                }
                this.cjo.C(sb, false);
            }
            if (this.cjj.agm()) {
                this.cjo.agU().notifyDataSetChanged();
            } else {
                this.cjo.i(this.cjj.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cjj.saveToBundle(bundle);
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.cjw.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.aLR = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aLR = System.currentTimeMillis();
        }
        this.cjd = 0;
        initUI();
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.c.n nVar = new com.baidu.tbadk.editortools.c.n();
        nVar.setForumName(this.cjj.agl());
        if (this.cjj.getPbData() != null && this.cjj.getPbData().afg() != null) {
            nVar.setForumId(this.cjj.getPbData().afg().getId());
        }
        nVar.setFrom("pb");
        nVar.a(this.cjj);
        this.cjw = (com.baidu.tbadk.editortools.c.e) nVar.ak(getActivity());
        this.cjw.b(this);
        this.cjw.a(this.aqM);
        this.cjw.a(this.aqG);
        this.cjw.a(this, bundle);
        this.cjw.Az().c(new com.baidu.tbadk.editortools.v(getActivity()));
        eu(true);
        this.cjo.setEditorTools(this.cjw.Az());
        registerListener(this.aSO);
        if (!this.cjj.agq()) {
            this.cjw.fa(this.cjj.getThreadID());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.aLR;
        registerListener(this.beR);
        registerListener(this.cjx);
        registerListener(this.cjy);
        this.cjz.setSelfListener(true);
        registerListener(this.cjz);
        this.cjv = new com.baidu.tieba.tbadkCore.data.e("pb");
    }

    private void eu(boolean z) {
        this.cjw.bg(z);
        this.cjw.bh(z);
        this.cjw.bi(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStart(getPageContext());
        }
    }

    public ct afI() {
        return this.cjo;
    }

    public ca afJ() {
        return this.cjj;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.ciY = true;
        super.onPause();
        BdListView listView = getListView();
        this.cjd = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.cjd == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
        if (this.cjo != null) {
            this.cjo.onPause();
        }
        if (!this.cjj.agq()) {
            this.cjw.eZ(this.cjj.getThreadID());
        }
        MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.ciY = false;
        super.onResume();
        if (this.cjo != null && this.cjo.getView() != null) {
            if (!this.cfC) {
                showLoadingView(this.cjo.getView(), true);
            } else {
                hideLoadingView(this.cjo.getView());
            }
        }
        if (this.cjd == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.cjo != null) {
            noNetworkView = this.cjo.agN();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.iN()) {
            noNetworkView.aw(false);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
        registerListener(this.richTextIntentClickListener);
        this.cju = false;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.cjo.eJ(z);
        if (this.cjt != null) {
            this.cjt.eG(z);
        }
        if (z && this.cju) {
            this.cjo.ahb();
            this.cjj.eA(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cjw != null && this.cjw.Az() != null && this.cjw.Az().getVisibility() != 0) {
            this.cjw.Bi();
        }
        if (this.cjo.cly != null && !this.cjo.cly.ahz()) {
            this.cjo.cly.abb();
        }
        if (this.cjj != null && this.cjj.getPbData() != null && this.cjj.getPbData().afg() != null && this.cjj.getPbData().afh() != null) {
            com.baidu.tbadk.distribute.a.Ai().a(getPageContext().getPageActivity(), "pb", this.cjj.getPbData().afg().getId(), com.baidu.adp.lib.g.b.c(this.cjj.getPbData().afh().getId(), 0L));
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (!this.cjh) {
            this.cjh = true;
            this.cjo.ahr();
        }
        this.cjn.onDestroy();
        this.cjj.cancelLoadData();
        this.cjj.destory();
        this.cjw.onDestroy();
        this.cjl.cancelLoadData();
        this.cjo.onDestroy();
        if (this.cjo.cly != null) {
            this.cjo.cly.abb();
        }
        if (this.cji != null) {
            this.cji.onDestroy();
        }
        super.onDestroy();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cjo.onChangeSkinType(i);
        if (this.cjw != null && this.cjw.Az() != null) {
            this.cjw.Az().onChangeSkinType(i);
        }
        if (this.cjs != null) {
            this.cjs.onChangeSkinType(this, i, com.baidu.tbadk.core.util.an.getDrawable(i.e.bg_collect));
        }
        if (this.cjo.agN() != null) {
            this.cjo.agN().onChangeSkinType(getPageContext(), i);
        }
    }

    public void afK() {
        this.cjt = new cr(getPageContext(), this.aWY);
        this.cjt.eG(this.mIsLogin);
        this.cjs = new MorePopupWindow(getPageContext().getPageActivity(), this.cjt.getView(), getResources().getDrawable(i.e.bg_collect), null);
        this.cjs.setTouchInterceptor(new aa(this));
        this.cjs.onChangeSkinType(this, TbadkCoreApplication.m411getInst().getSkinType(), com.baidu.tbadk.core.util.an.getDrawable(i.e.bg_collect));
    }

    private void initUI() {
        this.cjo = new ct(this, this.aWY, this.chs);
        this.cjo.setOnScrollListener(this.HD);
        this.cjo.c(this.cjH);
        this.cjo.a(this.cjI);
        this.cjo.a(this.aFW);
        this.cjo.er(com.baidu.tbadk.core.m.qV().qZ());
        this.cjo.et(com.baidu.tbadk.core.m.qV().qX());
        this.cjo.setOnImageClickListener(this.aBf);
        this.cjo.a(this.ajZ);
        this.cjo.g(this.aSi);
        this.cjo.a(this.cjG);
        this.cjo.eJ(this.mIsLogin);
    }

    public boolean V(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(i.f.tag_clip_board);
            if (obj instanceof com.baidu.tieba.tbadkCore.data.o) {
                com.baidu.tieba.tbadkCore.data.o oVar = (com.baidu.tieba.tbadkCore.data.o) obj;
                if (TextUtils.isEmpty(oVar.getBimg_url()) || !com.baidu.tbadk.core.m.qV().qZ()) {
                    return false;
                }
                return jP(oVar.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.cjo != null) {
            if (z && !this.cfC) {
                if (this.bgC) {
                    this.bgC = false;
                    showLoadingView(this.cjo.getView(), true);
                    return;
                }
                return;
            }
            hideLoadingView(this.cjo.getView());
        }
    }

    private void afL() {
        if (this.cjf == null) {
            this.cjf = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.cjf.a(new String[]{getPageContext().getString(i.h.call_phone), getPageContext().getString(i.h.sms_phone), getPageContext().getString(i.h.search_in_baidu)}, new ab(this)).bJ(c.a.WY).bK(17).d(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        this.cjj = new ca(this);
        this.cjj.a(this.cjD);
        this.cjk = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.cjk != null) {
            this.cjk.a(this.cjE);
        }
        this.cjl = new com.baidu.tieba.tbadkCore.h.a(this);
        this.cjl.setLoadDataCallBack(this.cjF);
        this.cjm = new UserMuteAddAndDelModel<>(this);
        this.cjm.a(this.cjB);
        this.cjn = new com.baidu.tieba.usermute.i(getPageContext(), this.cjC);
        if (bundle != null) {
            this.cjj.initWithBundle(bundle);
        } else {
            this.cjj.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra("request_code", -1) == 18003) {
            this.cjj.eD(true);
        }
        cm.agF().B(this.cjj.agk(), this.cjj.getIsFromMark());
        this.cjo.agZ();
        if (StringUtils.isNull(this.cjj.getThreadID())) {
            finish();
            return;
        }
        this.cjj.CI();
        this.cjo.a(new ac(this));
        this.aSR.setUniqueId(getUniqueId());
        this.aSR.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = (String) sparseArray.get(i.f.tag_disable_reply_mute_userid);
        this.cjo.Zw();
        this.cjn.a(com.baidu.adp.lib.g.b.c(currentAccount, 0L), com.baidu.adp.lib.g.b.c(str, 0L), sparseArray);
    }

    public int afM() {
        if (this.cjj.getPbData() == null || this.cjj.getPbData().afh() == null) {
            return -1;
        }
        return this.cjj.getPbData().afh().sx();
    }

    public boolean ev(boolean z) {
        if (this.cjj == null || this.cjj.getPbData() == null) {
            return false;
        }
        return ((this.cjj.getPbData().afl() != 0) || this.cjj.getPbData().afh() == null || this.cjj.getPbData().afh().getAuthor() == null || TextUtils.equals(this.cjj.getPbData().afh().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void afN() {
        if (this.cjj != null && this.cjj.getPbData() != null && this.cjj.getPbData().afh() != null && this.cjj.getPbData().afh().getAuthor() != null) {
            this.cjo.cly.c(this.cjj.agm(), this.cjk != null ? this.cjk.qi() : false, ev(TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.cjj.getPbData().afh().getAuthor().getUserId())));
        }
    }

    public void W(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.tbadkCore.data.o oVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (oVar = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(i.f.tag_clip_board)) != null) {
            c(oVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        afX();
    }

    public void a(boolean z, MarkData markData) {
        this.cjo.ahd();
        this.cjj.eC(z);
        if (this.cjk != null) {
            this.cjk.ab(z);
            if (markData != null) {
                this.cjk.a(markData);
            }
        }
        if (this.cjj.qi()) {
            afS();
        } else {
            this.cjo.h(this.cjj.getPbData());
        }
    }

    public void jK(String str) {
        if (!StringUtils.isNull(str) && this.cjj != null) {
            String threadID = this.cjj.getThreadID();
            String id = this.cjj.getPbData().afg().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(i.h.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData)) {
                if (!this.cjj.agq()) {
                    antiData.setBlock_forum_name(this.cjj.getPbData().afg().getName());
                    antiData.setBlock_forum_id(this.cjj.getPbData().afg().getId());
                    antiData.setUser_name(this.cjj.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.cjj.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.e.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.lr(i)) {
            AntiHelper.Q(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            this.cjm.ff(str);
        } else {
            this.cjo.showToast(str);
        }
    }

    public void a(a.b bVar) {
        int i = 0;
        if (bVar != null) {
            this.cjo.a(0, bVar.An, bVar.ddm, true);
            if (bVar.An) {
                if (bVar.ddk == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.o> afi = this.cjj.getPbData().afi();
                    int size = afi.size();
                    while (true) {
                        if (i < size) {
                            if (!bVar.mPostId.equals(afi.get(i).getId())) {
                                i++;
                            } else {
                                afi.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.cjo.h(this.cjj.getPbData());
                } else if (bVar.ddk == 0) {
                    afO();
                } else if (bVar.ddk == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.o> afi2 = this.cjj.getPbData().afi();
                    int size2 = afi2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < afi2.get(i2).axp().size()) {
                                if (!bVar.mPostId.equals(afi2.get(i2).axp().get(i3).getId())) {
                                    i3++;
                                } else {
                                    afi2.get(i2).axp().remove(i3);
                                    afi2.get(i2).axr();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData afo = this.cjj.getPbData().afo();
                        com.baidu.tieba.tbadkCore.data.o oVar = afi2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.data.o> axs = oVar.axs();
                        int size3 = axs.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!bVar.mPostId.equals(afi2.get(i2).axs().get(i4).getId())) {
                                    i4++;
                                } else {
                                    axs.remove(i4);
                                    afo.decreaseAlreadyCount();
                                    if (oVar.axz() > axs.size()) {
                                        oVar.ll(axs.size());
                                    }
                                    if (axs.size() > 0) {
                                        com.baidu.tieba.tbadkCore.data.o oVar2 = axs.get(axs.size() - 1);
                                        afo.setLastAdditionTime(oVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a axu = oVar2.axu();
                                        String str = "";
                                        if (axu != null) {
                                            str = axu.toString();
                                        }
                                        afo.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a axu2 = oVar.axu();
                                        String str2 = "";
                                        if (axu2 != null) {
                                            str2 = axu2.toString();
                                        }
                                        afo.setLastAdditionContent(str2);
                                    }
                                    afY();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.cjo.h(this.cjj.getPbData());
                    }
                }
            }
        }
    }

    public void a(a.d dVar) {
        this.cjo.a(1, dVar.An, dVar.ddm, true);
    }

    public void a(a.f fVar) {
        this.cjo.a(this.cjl.getLoadDataMode(), fVar.An, fVar.ddm, false);
        this.cjo.R(fVar.ddo);
    }

    public void a(int i, a.f fVar) {
        if (fVar != null) {
            this.cjo.a(this.cjl.getLoadDataMode(), fVar.An, fVar.ddm, true);
            if (fVar.An) {
                this.cjr = true;
                if (i == 2) {
                    this.cjj.getPbData().afh().bB(1);
                    this.cjj.setIsGood(1);
                } else if (i == 3) {
                    this.cjj.getPbData().afh().bB(0);
                    this.cjj.setIsGood(0);
                } else if (i == 4) {
                    this.cjj.getPbData().afh().bA(1);
                    this.cjj.ja(1);
                } else if (i == 5) {
                    this.cjj.getPbData().afh().bA(0);
                    this.cjj.ja(0);
                }
                this.cjo.a(this.cjj.getPbData(), this.cjj.agm(), true);
            }
        }
    }

    private void afO() {
        if (this.cjj.agn()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.cjj.getThreadID());
            setResult(-1, intent);
        }
        if (afT()) {
            super.finish();
        }
    }

    public void afP() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        this.cjo.aho();
        if (this.cjj != null && this.cjj.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.cjj.getPbData().afh().getId();
            historyMessage.forumName = this.cjj.getPbData().afg().getName();
            historyMessage.threadName = this.cjj.getPbData().afh().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> afi = this.cjj.getPbData().afi();
            int ahf = this.cjo.ahf();
            if (afi != null && ahf >= 0 && ahf < afi.size()) {
                historyMessage.postID = afi.get(ahf).getId();
            }
            historyMessage.isHostOnly = this.cjj.getHostMode();
            historyMessage.isSquence = this.cjj.agm();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.cjj != null && this.cjj.agn()) {
            Intent intent = new Intent();
            if (this.cjr) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.cjj.getThreadID());
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.cjj.agp());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.cjj.getIsGood());
            }
            setResult(-1, intent);
        }
        if (afT()) {
            if (this.cjj != null && this.cjo != null && this.cjo.getListView() != null) {
                com.baidu.tieba.pb.a.c pbData = this.cjj.getPbData();
                if (pbData != null && pbData.getUserData() != null) {
                    pbData.getUserData().setBimg_url(TbadkCoreApplication.m411getInst().getDefaultBubble());
                }
                cm.agF().a(this.cjj.getPbData(), this.cjo.getListView().onSaveInstanceState(), this.cjj.agm(), this.cjj.getHostMode());
            } else {
                cm.agF().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.cjs != null) {
                    com.baidu.adp.lib.g.j.a(this.cjs, getPageContext().getPageActivity());
                }
                finish();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean iY(int i) {
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
        this.cjw.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    afR();
                    return;
                case 13008:
                    cm.agF().reset();
                    this.mHandler.postDelayed(new ad(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.cjj != null) {
                        a(afQ(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
        switch (i) {
            case 12002:
                if (intent != null && afI() != null && afG() != null && afI().agQ() && com.baidu.tbadk.editortools.c.b.AW().getStatus() == 1) {
                    com.baidu.tbadk.editortools.c.b.AW().setStatus(0);
                    if (this.cjo != null) {
                        this.cjo.agP();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private ShareFromPBMsgData afQ() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] aD = this.cjj.getPbData().aD(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.data.o agR = this.cjo.agR();
        String str = "";
        if (agR != null) {
            str = agR.getId();
            String aS = agR.aS(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(aS)) {
                aD[1] = aS;
            }
        }
        String ss = this.cjj.getPbData().afh().ss();
        if (ss != null && ss.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(aD[1]);
        shareFromPBMsgData.setImageUrl(aD[0]);
        shareFromPBMsgData.setForumName(this.cjj.getPbData().afg().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.cjj.getPbData().afh().getId());
        shareFromPBMsgData.setTitle(this.cjj.getPbData().afh().getTitle());
        return shareFromPBMsgData;
    }

    private void N(Intent intent) {
        a(afQ(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.cjj != null && this.cjj.getPbData() != null && this.cjj.getPbData().afh() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            dp dpVar = new dp(getPageContext().getPageActivity());
            dpVar.setData(shareFromPBMsgData);
            aVar.bH(1);
            aVar.m(dpVar);
            aVar.a(i.h.share, new ae(this, dpVar, j, str, str2, shareFromPBMsgData));
            aVar.b(i.h.alert_no_button, new af(this, dpVar));
            aVar.ak(false);
            aVar.b(getPageContext()).sR();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                dpVar.w(shareFromPBMsgData.getImageUrl(), this.cjj.getPbData().afm() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.cjj != null && this.cjj.getPbData() != null && this.cjj.getPbData().afh() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            dp dpVar = new dp(getPageContext().getPageActivity());
            dpVar.setData(shareFromPBMsgData);
            aVar.bH(1);
            aVar.m(dpVar);
            aVar.a(i.h.share, new ag(this, dpVar, i, str, j, shareFromPBMsgData));
            aVar.b(i.h.alert_no_button, new ah(this, dpVar));
            aVar.ak(false);
            aVar.b(getPageContext()).sR();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                dpVar.w(shareFromPBMsgData.getImageUrl(), this.cjj.getPbData().afm() == 1);
            }
        }
    }

    public void afR() {
        MarkData jh;
        if (this.cjk != null && (jh = this.cjj.jh(this.cjo.ahf())) != null) {
            if (!jh.isApp() || (jh = this.cjj.jh(this.cjo.ahf() + 1)) != null) {
                this.cjo.agZ();
                this.cjk.a(jh);
                if (!this.cjk.qi()) {
                    this.cjk.qk();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.cjk.qj();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    public void afS() {
        com.baidu.tieba.pb.a.c pbData = this.cjj.getPbData();
        this.cjj.eC(true);
        pbData.jI(this.cjk.qh());
        this.cjo.h(pbData);
    }

    private boolean afT() {
        if (this.cjj == null) {
            return true;
        }
        if (this.cjj.qi()) {
            MarkData agw = this.cjj.agw();
            if (agw == null || !this.cjj.getIsFromMark()) {
                return true;
            }
            MarkData jh = this.cjj.jh(this.cjo.ahf());
            if (jh == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, agw);
                setResult(-1, intent);
                return true;
            } else if (jh.getPostId() == null || jh.getPostId().equals(agw.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, agw);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cu(String.format(getPageContext().getString(i.h.alert_update_mark), Integer.valueOf(jh.getFloor())));
                aVar.a(i.h.alert_yes_btn, new ai(this, jh, agw, aVar));
                aVar.b(i.h.alert_no_button, new aj(this, agw, aVar));
                aVar.a(new al(this, agw, aVar));
                aVar.b(getPageContext());
                aVar.sR();
                return false;
            }
        } else if (this.cjj.getPbData() == null || this.cjj.getPbData().afi() == null || this.cjj.getPbData().afi().size() <= 0 || !this.cjj.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.cjo == null) {
            return null;
        }
        return this.cjo.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public int getRichTextViewId() {
        if (this.cjo == null) {
            return 0;
        }
        return this.cjo.ahi();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vE() {
        if (this.cjo == null) {
            return 0;
        }
        return this.cjo.Mi();
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.e.b<ImageView> getImageViewPool() {
        if (this.aAL == null) {
            this.aAL = new com.baidu.adp.lib.e.b<>(new am(this), 8, 0);
        }
        return this.aAL;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.e.b<TextView> getTextViewPool() {
        if (this.aAM == null) {
            this.aAM = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.aAM;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.e.b<GifView> getGifViewPool() {
        if (this.aAP == null) {
            this.aAP = new com.baidu.adp.lib.e.b<>(new an(this), 20, 0);
        }
        return this.aAP;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.e.b<View> getVoiceViewPool() {
        if (this.aAN == null) {
            this.aAN = new com.baidu.adp.lib.e.b<>(new ao(this), 8, 0);
        }
        return this.aAN;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> vF() {
        if (this.aeN == null) {
            this.aeN = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.aeN;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    public boolean jL(String str) {
        Map<String, String> dr;
        if (!TextUtils.isEmpty(str) && (dr = com.baidu.tbadk.core.util.az.dr(com.baidu.tbadk.core.util.az.ds(str))) != null) {
            String str2 = dr.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return jL(com.baidu.adp.lib.util.j.aQ(str2));
            }
            String str3 = dr.get(cje);
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
            if (jM(str) || z) {
                boolean v = com.baidu.adp.lib.util.k.v(context, "com.qiyi.video");
                jN(str);
                if (v) {
                    afU();
                } else {
                    afV();
                }
            } else if (jL(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                com.baidu.tbadk.core.util.az.uX().b(getPageContext(), new String[]{str});
            }
        }
    }

    private boolean jM(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }

    private void jN(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(";")) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.cjb = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.cjc = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.aPn = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.cja = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void afU() {
        if (TextUtils.isEmpty(this.cjb) || TextUtils.isEmpty(this.cjc) || TextUtils.isEmpty(this.mPackageName)) {
            if (!TextUtils.isEmpty(this.cja)) {
                com.baidu.tbadk.browser.g.b(getPageContext().getPageActivity(), false, this.cja);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(this.cjb));
        intent.setAction(this.cjc);
        intent.setPackage(this.mPackageName);
        if (intent.resolveActivity(getPageContext().getPageActivity().getPackageManager()) != null) {
            if (!com.baidu.adp.lib.g.i.e(getPageContext().getPageActivity(), intent) && !TextUtils.isEmpty(this.cja)) {
                com.baidu.tbadk.browser.g.b(getPageContext().getPageActivity(), false, this.cja);
            }
        } else if (!TextUtils.isEmpty(this.cja)) {
            com.baidu.tbadk.browser.g.b(getPageContext().getPageActivity(), false, this.cja);
        }
    }

    private void afV() {
        if (!com.baidu.adp.lib.util.i.iO()) {
            if (!TextUtils.isEmpty(this.cja)) {
                com.baidu.tbadk.browser.g.b(getPageContext().getPageActivity(), false, this.cja);
                return;
            }
            return;
        }
        if (this.ciZ == null) {
            this.ciZ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.ciZ.bF(i.h.download_iqiyi_app_dialog);
            this.ciZ.a(i.h.install_app, new ap(this));
            this.ciZ.b(i.h.webpage_play, new aq(this));
            this.ciZ.ak(false);
        }
        this.ciZ.b(getPageContext()).sR();
    }

    private com.baidu.tbadk.core.dialog.a afW() {
        if (this.cjg == null) {
            this.cjg = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.cjg.ct(getPageContext().getString(i.h.download_baidu_video_dialog));
            this.cjg.a(getPageContext().getString(i.h.install), new ar(this));
            this.cjg.b(getPageContext().getString(i.h.cancel), new as(this));
            this.cjg.aj(true);
            this.cjg.b(getPageContext());
            this.cjg.ak(false);
        }
        this.cjg.sR();
        return this.cjg;
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
            afW();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onSongClicked(Context context, String str) {
    }

    public String b(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.EN() == null) {
            return null;
        }
        return cVar.EN().Fa();
    }

    public long c(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.EN() == null) {
            return 0L;
        }
        return cVar.EN().getOriginalSize();
    }

    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, HashMap<String, ImageUrlData> hashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.f EN;
        if (aVar == aVar2) {
            this.cjK = true;
        }
        if (aVar != null) {
            int size = aVar.EI().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.EI().get(i6) == null || aVar.EI().get(i6).getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int width = aVar.EI().get(i6).EN().getWidth();
                    int height = aVar.EI().get(i6).EN().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.EI().get(i6).EN().EX()) {
                        if (aVar == aVar2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.EI().get(i6);
                        String d = d(cVar);
                        arrayList.add(d);
                        if (!TextUtils.isEmpty(d) && cVar != null && (EN = cVar.EN()) != null) {
                            String EY = EN.EY();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = EY;
                            int i9 = this.mIsFromCDN ? 17 : 18;
                            imageUrlData.urlType = i9;
                            imageUrlData.urlType = i9;
                            imageUrlData.originalUrl = b(cVar);
                            imageUrlData.originalSize = c(cVar);
                            if (hashMap != null) {
                                hashMap.put(d, imageUrlData);
                            }
                        }
                        if (!this.cjK) {
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

    public void c(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (oVar != null) {
            boolean z = false;
            if (oVar.getId() != null && oVar.getId().equals(this.cjj.sn())) {
                z = true;
            }
            MarkData d = this.cjj.d(oVar);
            if (d != null) {
                this.cjo.agZ();
                if (this.cjk != null) {
                    this.cjk.a(d);
                    if (!z) {
                        this.cjk.qk();
                    } else {
                        this.cjk.qj();
                    }
                }
            }
        }
    }

    public com.baidu.tbadk.widget.richText.a W(String str, int i) {
        if (this.cjj == null || this.cjj.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.a.c pbData = this.cjj.getPbData();
        com.baidu.tbadk.widget.richText.a a2 = a(pbData.afi(), str, i);
        if (a2 == null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.o> afi = pbData.afi();
            int size = afi.size();
            for (int i2 = 0; i2 < size; i2++) {
                a2 = a(afi.get(i2).axs(), str, i);
                if (a2 != null) {
                    return a2;
                }
            }
            return a2;
        }
        return a2;
    }

    private long jO(String str) {
        ArrayList<com.baidu.tieba.tbadkCore.data.o> afi;
        com.baidu.tieba.pb.a.c pbData = this.cjj.getPbData();
        if (pbData != null && (afi = pbData.afi()) != null && !afi.isEmpty()) {
            Iterator<com.baidu.tieba.tbadkCore.data.o> it = afi.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.o next = it.next();
                com.baidu.tieba.tbadkCore.data.g axC = next.axC();
                if (axC != null && axC.daD) {
                    Iterator<com.baidu.tbadk.widget.richText.c> it2 = next.axu().EI().iterator();
                    while (it2.hasNext()) {
                        com.baidu.tbadk.widget.richText.c next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.EV().getLink().equals(str)) {
                            return axC.awX();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.data.o> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> EI;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a axu = arrayList.get(i2).axu();
            if (axu != null && (EI = axu.EI()) != null) {
                int size = EI.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (EI.get(i4) != null && EI.get(i4).getType() == 8) {
                        i3++;
                        if (EI.get(i4).EN().EY().equals(str)) {
                            int width = EI.get(i4).EN().getWidth();
                            int height = EI.get(i4).EN().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.cjJ = i4;
                            return axu;
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

    public String d(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        com.baidu.tbadk.widget.richText.f EN = cVar.EN();
        if (EN != null) {
            if (!StringUtils.isNull(EN.EW())) {
                return EN.EW();
            }
            if (EN.getHeight() * EN.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (EN.getHeight() * EN.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (EN.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * EN.getHeight())));
            } else {
                float width = EN.getWidth() / EN.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.as.aP(EN.getSrc()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onPhoneClicked(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.ciN = str;
            if (this.cjf == null) {
                afL();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.cjf.bM(1).setVisibility(8);
            } else {
                this.cjf.bM(1).setVisibility(0);
            }
            this.cjf.sU();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    public void afX() {
        hideNetRefreshView(this.cjo.getView());
        showLoadingView(this.cjo.getView(), true);
        if (this.cjj.CI()) {
            this.cjo.agZ();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void stopVoice() {
        if (this.mVoiceManager != null) {
            this.mVoiceManager.stopPlay();
        }
    }

    public void showShareDialog() {
        if (this.cjj.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.a.c pbData = this.cjj.getPbData();
            String name = pbData.afg().getName();
            String title = pbData.afh().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.cjj.getThreadID() + "?share=9105&fr=share";
            String[] aD = pbData.aD(getPageContext().getPageActivity());
            String str2 = aD[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = aD[1];
            if (afM() == 1) {
                if (pbData != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10399").ae(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ae("tid", pbData.getThreadId()));
                }
            } else if (afM() == 2 && pbData != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10406").ae(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ae("tid", pbData.getThreadId()));
            }
            String format = MessageFormat.format(getResources().getString(i.h.share_content_tpl), title, name, str3);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.linkUrl = str;
            fVar.aiU = true;
            fVar.extData = this.cjj.getThreadID();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true, qt());
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(i.h.share_tieba_qunzu, i.e.icon_unite_share_qunzu, new at(this));
            shareDialogConfig.addOutsideTextView(i.h.forum_friend, i.e.icon_unite_share_baf, new au(this));
            shareDialogConfig.setCopyLinkListener(new aw(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private SparseArray<String> qt() {
        if (this.aUw == null) {
            this.aUw = new SparseArray<>(7);
            this.aUw.put(2, "pb_wx_timeline");
            this.aUw.put(3, "pb_wx_friend");
            this.aUw.put(4, "pb_qq_zone");
            this.aUw.put(5, "pb_tencent_weibo");
            this.aUw.put(6, "pb_sina_weibo");
            this.aUw.put(7, "pb_renren");
        }
        return this.aUw;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool() {
        if (this.aAO == null) {
            this.aAO = new com.baidu.adp.lib.e.b<>(new ax(this), 15, 0);
        }
        return this.aAO;
    }

    public void afY() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.pb.a.c pbData = this.cjj.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.rE().isIfAddition();
            AdditionData afo = pbData.afo();
            boolean z3 = afo == null ? false : isIfAddition;
            if (z3) {
                z = afo.getAlreadyCount() != afo.getTotalCount();
                if (!TextUtils.isEmpty(afo.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.pb.main.b.c cVar = this.cjo.cly;
            if (!z3 || !z) {
                z2 = false;
            }
            cVar.eT(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.cjo.agT() == view && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.core.data.w afh = this.cjj.getPbData().afh();
            if (view != null) {
                boolean z = afh.getPraise() == null || afh.getPraise().getIsLike() == 0;
                if (motionEvent.getAction() == 0) {
                    if (System.currentTimeMillis() - this.aTb > 1000) {
                        this.aTc = true;
                        z(view);
                    } else {
                        this.aTc = false;
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (z) {
                        d(view, this.aTc);
                    } else {
                        c(view, this.aTc);
                    }
                } else if (motionEvent.getAction() == 2) {
                    c(view, this.aTc);
                } else if (motionEvent.getAction() == 3) {
                    c(view, this.aTc);
                }
            }
        }
        return false;
    }

    private void c(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), i.a.praise_animation_scale2));
            new Handler().postDelayed(new ay(this), 200L);
        }
    }

    private void d(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), i.a.praise_animation_scale3));
            new Handler().postDelayed(new az(this), 600L);
        }
    }

    private void z(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), i.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void Ls() {
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
        } else if (!this.cjl.ayB()) {
            this.cjo.agW();
            if (aVar.sS() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.sS();
                int intValue = ((Integer) sparseArray.get(i.f.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(i.f.tag_del_post_is_self)).booleanValue();
                int intValue2 = ((Integer) sparseArray.get(i.f.tag_del_post_type)).intValue();
                this.cjl.a(this.cjj.getPbData().afg().getId(), this.cjj.getPbData().afg().getName(), this.cjj.getPbData().afh().getId(), (String) sparseArray.get(i.f.tag_del_post_id), intValue2, intValue, booleanValue);
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
        this.cjm.a(z, str, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
    }

    private boolean jP(String str) {
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

    public void ew(boolean z) {
        this.cju = z;
    }

    public String afZ() {
        ArrayList<com.baidu.tieba.tbadkCore.data.o> afi;
        int m;
        if (this.cjj == null || this.cjj.getPbData() == null || this.cjj.getPbData().afi() == null || (m = com.baidu.tbadk.core.util.u.m((afi = this.cjj.getPbData().afi()))) == 0) {
            return "";
        }
        int ahf = this.cjo.ahf();
        com.baidu.tieba.tbadkCore.data.o oVar = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tbadk.core.util.u.b(afi, ahf);
        if (oVar == null || oVar.getAuthor() == null) {
            return "";
        }
        if (this.cjj.jR(oVar.getAuthor().getUserId())) {
            return oVar.getId();
        }
        for (int i = ahf - 1; i != 0; i--) {
            com.baidu.tieba.tbadkCore.data.o oVar2 = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tbadk.core.util.u.b(afi, i);
            if (oVar2 == null || oVar2.getAuthor() == null || oVar2.getAuthor().getUserId() == null) {
                break;
            } else if (this.cjj.jR(oVar2.getAuthor().getUserId())) {
                return oVar2.getId();
            }
        }
        for (int i2 = ahf + 1; i2 < m; i2++) {
            com.baidu.tieba.tbadkCore.data.o oVar3 = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tbadk.core.util.u.b(afi, i2);
            if (oVar3 == null || oVar3.getAuthor() == null || oVar3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.cjj.jR(oVar3.getAuthor().getUserId())) {
                return oVar3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onLinkButtonClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.az.uX().b(getPageContext(), new String[]{str})) {
            com.baidu.tieba.pb.a.a(jO(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.cjj.getPbData().afg().getId(), this.cjj.getPbData().afg().getName(), this.cjj.getPbData().afh().getTid());
        }
    }
}
