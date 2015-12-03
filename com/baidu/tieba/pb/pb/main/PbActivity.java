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
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.cc;
import com.baidu.tieba.tbadkCore.f.a;
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
    private com.baidu.adp.lib.f.b<LinearLayout> aDA;
    private com.baidu.adp.lib.f.b<GifView> aDB;
    private com.baidu.adp.lib.f.b<ImageView> aDx;
    private com.baidu.adp.lib.f.b<TextView> aDy;
    private com.baidu.adp.lib.f.b<View> aDz;
    private com.baidu.adp.lib.f.b<TbImageView> afK;
    private com.baidu.tbadk.core.dialog.a cBD;
    private ci cBP;
    private boolean cBQ;
    private com.baidu.tieba.tbadkCore.data.e cBR;
    private com.baidu.tbadk.editortools.d.e cBS;
    private String cBj;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private VoiceManager mVoiceManager;
    public static boolean cBu = false;
    private static String cBB = "tbgametype";
    private boolean cBv = false;
    private boolean bno = true;
    private boolean cyc = false;
    private com.baidu.tbadk.core.dialog.a cBw = null;
    private String cBx = null;
    private String aUq = null;
    private String cBy = null;
    private String cBz = null;
    private String mPackageName = null;
    private int cBA = 0;
    private com.baidu.tbadk.core.dialog.c cBC = null;
    SparseArray<String> aZJ = null;
    private long aQy = -1;
    private long ays = 0;
    private long createTime = 0;
    private long ayt = 0;
    private boolean cBE = false;
    private com.baidu.tbadk.performanceLog.e cBF = null;
    private String asF = null;
    private final Handler mHandler = new Handler(new d(this));
    private cc cBG = null;
    private com.baidu.tbadk.baseEditMark.a cBH = null;
    private com.baidu.tieba.tbadkCore.f.a cBI = null;
    private UserMuteAddAndDelModel cBJ = null;
    private com.baidu.tieba.usermute.i cBK = null;
    private da cBL = null;
    public final com.baidu.tieba.pb.pb.main.a.a cBM = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean cBN = false;
    private boolean cBO = false;
    private boolean aZd = false;
    private com.baidu.tbadk.editortools.d.c asJ = new o(this);
    private CustomMessageListener blv = new z(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener aYc = new ak(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener cBT = new av(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener cBU = new bc(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener richTextIntentClickListener = new bd(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private HttpMessageListener cBV = new be(this, CmdConfigHttp.PB_LOTTERY_HTTP_CMD);
    private View.OnClickListener cBW = new bo(this);
    private CustomMessageListener cBX = new e(this, CmdConfigCustom.CMD_SEND_GIFT_SUCCESS);
    private boolean aXT = false;
    private com.baidu.tieba.tbadkCore.af aYf = new com.baidu.tieba.tbadkCore.af(getPageContext(), new f(this));
    private long aYp = 0;
    private boolean aYq = true;
    private com.baidu.tieba.pb.b.c czP = new com.baidu.tieba.pb.b.c(new g(this));
    private UserMuteAddAndDelModel.a cBY = new h(this);
    private i.a cBZ = new i(this);
    public a.b cuh = new j(this);
    public final View.OnClickListener bcT = new k(this);
    private final a.d asP = new l(this);
    private final cc.b cCa = new m(this);
    private final a.InterfaceC0040a cCb = new n(this);
    private final AbsListView.OnScrollListener HU = new p(this);
    private final com.baidu.adp.base.g cCc = new q(this);
    private final b cCd = new r(this);
    private final q.a aIV = new s(this);
    private final BdListView.e cCe = new t(this);
    private final BdListView.h cCf = new u(this);
    private int cCg = 0;
    private final TbRichTextView.d aDR = new v(this);
    boolean cCh = false;
    com.baidu.tieba.tbadkCore.data.o cCi = null;
    private final c.b cCj = new w(this);
    private final View.OnLongClickListener alK = new x(this);
    private final NoNetworkView.a aXw = new y(this);
    private String cCk = null;
    private final cc.a cCl = new aa(this);

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* loaded from: classes.dex */
    public interface b {
        void fb(boolean z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.d.e ajY() {
        return this.cBS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jP(int i) {
        if (this.cBG != null && this.cBG.getPbData() != null && this.cBG.getPbData().ajy() != null) {
            this.cBG.getPbData().ajy().setLike(i);
            com.baidu.tieba.tbadkCore.y yVar = new com.baidu.tieba.tbadkCore.y();
            yVar.setLike(i);
            yVar.gV(-1);
            yVar.setLevelName("");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, yVar));
        }
    }

    public void b(com.baidu.tieba.pb.a.d dVar) {
        if (dVar.ajK() != null) {
            String id = dVar.ajK().getId();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> ajA = this.cBG.getPbData().ajA();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ajA.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.o oVar = ajA.get(i2);
                if (oVar.getId() == null || !oVar.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.data.o> ajO = dVar.ajO();
                    oVar.mv(dVar.getTotalCount());
                    if (oVar.aCZ() != null) {
                        oVar.aCZ().clear();
                        oVar.aCZ().addAll(ajO);
                    }
                }
            }
            this.cBL.i(this.cBG.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajZ() {
        com.baidu.tieba.pb.a.c pbData;
        com.baidu.tbadk.core.data.z ajz;
        if (!this.aXT) {
            if (!com.baidu.adp.lib.util.k.jg()) {
                showToast(n.i.no_network_guide);
            } else if (this.aYq) {
                this.aXT = true;
                if (this.cBG != null && (pbData = this.cBG.getPbData()) != null && (ajz = pbData.ajz()) != null) {
                    int isLike = ajz.getPraise() == null ? 0 : ajz.getPraise().getIsLike();
                    if (this.aYf != null) {
                        this.aYf.a(ajz.sT(), ajz.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        if ((sparseArray.get(n.f.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(n.f.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(n.f.tag_check_mute_from) instanceof Integer)) {
            String str = (String) sparseArray.get(n.f.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(n.f.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
                cVar.bQ(n.i.operation);
                int i = -1;
                if (sparseArray.get(n.f.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(n.f.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(n.i.delete);
                    strArr[1] = z ? getResources().getString(n.i.un_mute) : getResources().getString(n.i.mute);
                    cVar.a(strArr, new ab(this, sparseArray, z, str));
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(n.i.un_mute) : getResources().getString(n.i.mute);
                    cVar.a(strArr2, new ac(this, sparseArray, z, str));
                }
                cVar.d(getPageContext()).tz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fU(int i) {
        com.baidu.tbadk.core.data.z ajz;
        String sb;
        String w;
        if (this.cBG != null && this.cBG.getPbData() != null && (ajz = this.cBG.getPbData().ajz()) != null) {
            if (i == 1) {
                PraiseData praise = ajz.getPraise();
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
                        ajz.setPraise(praiseData);
                    } else {
                        ajz.getPraise().getUser().add(0, metaData);
                        ajz.getPraise().setNum(ajz.getPraise().getNum() + 1);
                        ajz.getPraise().setIsLike(i);
                    }
                }
                if (ajz.getPraise() != null) {
                    if (ajz.getPraise().getNum() < 1) {
                        w = getResources().getString(n.i.frs_item_praise_text);
                    } else {
                        w = com.baidu.tbadk.core.util.ax.w(ajz.getPraise().getNum());
                    }
                    this.cBL.E(w, true);
                }
            } else if (ajz.getPraise() != null) {
                ajz.getPraise().setIsLike(i);
                ajz.getPraise().setNum(ajz.getPraise().getNum() - 1);
                ArrayList<MetaData> user = ajz.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            ajz.getPraise().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (ajz.getPraise().getNum() < 1) {
                    sb = getResources().getString(n.i.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(ajz.getPraise().getNum())).toString();
                }
                this.cBL.E(sb, false);
            }
            if (this.cBG.akF()) {
                this.cBL.als().notifyDataSetChanged();
            } else {
                this.cBL.j(this.cBG.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cBG.saveToBundle(bundle);
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.cBS.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.aQy = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aQy = System.currentTimeMillis();
        }
        this.cBA = 0;
        k(bundle);
        initUI();
        this.cBL.cEj = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.d.n nVar = new com.baidu.tbadk.editortools.d.n();
        nVar.setForumName(this.cBG.akE());
        if (this.cBG.getPbData() != null && this.cBG.getPbData().ajy() != null) {
            nVar.setForumId(this.cBG.getPbData().ajy().getId());
        }
        nVar.setFrom("pb");
        nVar.a(this.cBG);
        this.cBS = (com.baidu.tbadk.editortools.d.e) nVar.al(getActivity());
        this.cBS.b(this);
        this.cBS.a(this.asP);
        this.cBS.a(this.asJ);
        this.cBS.a(this, bundle);
        this.cBS.Bu().c(new com.baidu.tbadk.editortools.x(getActivity()));
        eW(true);
        this.cBL.setEditorTools(this.cBS.Bu());
        this.cBS.a(this.cBG.akM(), this.cBG.getThreadID(), this.cBG.akB());
        registerListener(this.aYc);
        if (!this.cBG.akJ()) {
            this.cBS.fp(this.cBG.getThreadID());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.aQy;
        registerListener(this.blv);
        registerListener(this.cBT);
        registerListener(this.cBU);
        this.cBV.setSelfListener(true);
        registerListener(this.cBV);
        this.cBR = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.dzi);
        this.cBR.aCH();
        registerListener(this.cBX);
    }

    private void eW(boolean z) {
        this.cBS.bl(z);
        this.cBS.bm(z);
        this.cBS.bn(z);
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

    public da aka() {
        return this.cBL;
    }

    public cc akb() {
        return this.cBG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.cBv = true;
        super.onPause();
        BdListView listView = getListView();
        this.cBA = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.cBA == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
        if (this.cBL != null) {
            this.cBL.onPause();
        }
        if (!this.cBG.akJ()) {
            this.cBS.fo(this.cBG.getThreadID());
        }
        MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.cBv = false;
        super.onResume();
        if (this.cBL != null && this.cBL.getView() != null) {
            if (!this.cyc) {
                showLoadingView(this.cBL.getView(), true);
            } else {
                hideLoadingView(this.cBL.getView());
            }
        }
        if (this.cBA == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.cBL != null) {
            noNetworkView = this.cBL.all();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.iP()) {
            noNetworkView.az(false);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
        registerListener(this.richTextIntentClickListener);
        this.cBQ = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.cBL.fn(z);
        if (this.cBP != null) {
            this.cBP.fh(z);
        }
        if (z && this.cBQ) {
            this.cBL.alz();
            this.cBG.fd(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cBS != null && this.cBS.Bu() != null && this.cBS.Bu().getVisibility() != 0) {
            this.cBS.Ci();
        }
        if (this.cBL.cEm != null && !this.cBL.cEm.amd()) {
            this.cBL.cEm.aeH();
        }
        if (this.cBG != null && this.cBG.getPbData() != null && this.cBG.getPbData().ajy() != null && this.cBG.getPbData().ajz() != null) {
            com.baidu.tbadk.distribute.a.Bf().a(getPageContext().getPageActivity(), "pb", this.cBG.getPbData().ajy().getId(), com.baidu.adp.lib.h.b.c(this.cBG.getPbData().ajz().getId(), 0L));
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (!this.cBE) {
            this.cBE = true;
            this.cBL.alR();
        }
        this.cBK.onDestroy();
        this.cBG.cancelLoadData();
        this.cBG.destory();
        this.cBS.onDestroy();
        this.cBI.cancelLoadData();
        this.cBL.onDestroy();
        if (this.cBL.cEm != null) {
            this.cBL.cEm.aeH();
        }
        if (this.cBF != null) {
            this.cBF.onDestroy();
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
        this.cBL.onChangeSkinType(i);
        if (this.cBS != null && this.cBS.Bu() != null) {
            this.cBS.Bu().onChangeSkinType(i);
        }
        if (this.cBL.all() != null) {
            this.cBL.all().onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akc() {
        this.cBP = new ci(getPageContext(), this.bcT);
        this.cBP.fh(this.mIsLogin);
    }

    private void initUI() {
        this.cBL = new da(this, this.bcT, this.czP);
        this.cBL.setOnScrollListener(this.HU);
        this.cBL.d(this.cCe);
        this.cBL.a(this.cCf);
        this.cBL.a(this.aIV);
        this.cBL.eT(com.baidu.tbadk.core.m.rh().rn());
        this.cBL.eV(com.baidu.tbadk.core.m.rh().rj());
        this.cBL.setOnImageClickListener(this.aDR);
        this.cBL.a(this.alK);
        this.cBL.f(this.aXw);
        this.cBL.a(this.cCd);
        this.cBL.fn(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ac(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(n.f.tag_clip_board);
            if (obj instanceof com.baidu.tieba.tbadkCore.data.o) {
                com.baidu.tieba.tbadkCore.data.o oVar = (com.baidu.tieba.tbadkCore.data.o) obj;
                if (TextUtils.isEmpty(oVar.getBimg_url()) || !com.baidu.tbadk.core.m.rh().rn()) {
                    return false;
                }
                return kE(oVar.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.cBL != null) {
            if (z && !this.cyc) {
                if (this.bno) {
                    this.bno = false;
                    showLoadingView(this.cBL.getView(), true);
                    return;
                }
                return;
            }
            hideLoadingView(this.cBL.getView());
        }
    }

    private void akd() {
        if (this.cBC == null) {
            this.cBC = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.cBC.a(new String[]{getPageContext().getString(n.i.call_phone), getPageContext().getString(n.i.sms_phone), getPageContext().getString(n.i.search_in_baidu)}, new ad(this)).bR(c.a.XL).bS(17).d(getPageContext());
        }
    }

    private void k(Bundle bundle) {
        this.cBG = new cc(this);
        this.cBG.a(this.cCa);
        this.cBG.a(this.cCl);
        if (bundle != null) {
            this.cBG.initWithBundle(bundle);
        } else {
            this.cBG.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra("request_code", -1) == 18003) {
            this.cBG.fg(true);
        }
        ct.ale().D(this.cBG.akD(), this.cBG.getIsFromMark());
        if (StringUtils.isNull(this.cBG.getThreadID())) {
            finish();
        } else {
            this.cBG.DJ();
        }
    }

    private void initData(Bundle bundle) {
        this.cBH = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.cBH != null) {
            this.cBH.a(this.cCb);
        }
        this.cBI = new com.baidu.tieba.tbadkCore.f.a(this);
        this.cBI.setLoadDataCallBack(this.cCc);
        this.cBJ = new UserMuteAddAndDelModel(getPageContext());
        this.cBJ.a(this.cBY);
        this.cBK = new com.baidu.tieba.usermute.i(getPageContext(), this.cBZ);
        this.cBL.a(new ae(this));
        this.aYf.setUniqueId(getUniqueId());
        this.aYf.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = (String) sparseArray.get(n.f.tag_user_mute_mute_userid);
        this.cBL.acC();
        this.cBK.a(com.baidu.adp.lib.h.b.c(currentAccount, 0L), com.baidu.adp.lib.h.b.c(str, 0L), sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ake() {
        if (this.cBG.getPbData() == null || this.cBG.getPbData().ajz() == null) {
            return -1;
        }
        return this.cBG.getPbData().ajz().sY();
    }

    public boolean eX(boolean z) {
        return z && this.cBL.alE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eY(boolean z) {
        if (this.cBG == null || this.cBG.getPbData() == null) {
            return false;
        }
        return ((this.cBG.getPbData().ajD() != 0) || this.cBG.getPbData().ajz() == null || this.cBG.getPbData().ajz().getAuthor() == null || TextUtils.equals(this.cBG.getPbData().ajz().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void akf() {
        if (this.cBG != null && this.cBG.getPbData() != null && this.cBG.getPbData().ajz() != null && this.cBG.getPbData().ajz().getAuthor() != null) {
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.cBG.getPbData().ajz().getAuthor().getUserId());
            this.cBL.cEm.a(this.cBG.akF(), this.cBH != null ? this.cBH.qp() : false, eY(equals), eX(equals));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.tbadkCore.data.o oVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (oVar = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(n.f.tag_clip_board)) != null) {
            c(oVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        akp();
    }

    public void a(boolean z, MarkData markData) {
        this.cBL.alB();
        this.cBG.ff(z);
        if (this.cBH != null) {
            this.cBH.ab(z);
            if (markData != null) {
                this.cBH.a(markData);
            }
        }
        if (this.cBG.qp()) {
            akk();
        } else {
            this.cBL.i(this.cBG.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kz(String str) {
        if (!StringUtils.isNull(str) && this.cBG != null) {
            String threadID = this.cBG.getThreadID();
            String id = this.cBG.getPbData().ajy().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(n.i.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.cBG.akJ()) {
                    antiData.setBlock_forum_name(this.cBG.getPbData().ajy().getName());
                    antiData.setBlock_forum_id(this.cBG.getPbData().ajy().getId());
                    antiData.setUser_name(this.cBG.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.cBG.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.e.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.mC(i)) {
            AntiHelper.Q(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            this.cBJ.fu(str);
        } else {
            this.cBL.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        int i = 0;
        if (bVar != null) {
            this.cBL.a(0, bVar.At, bVar.dBx, true);
            if (bVar.At) {
                if (bVar.dBv == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.o> ajA = this.cBG.getPbData().ajA();
                    int size = ajA.size();
                    while (true) {
                        if (i < size) {
                            if (!bVar.mPostId.equals(ajA.get(i).getId())) {
                                i++;
                            } else {
                                ajA.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.cBL.i(this.cBG.getPbData());
                } else if (bVar.dBv == 0) {
                    akg();
                } else if (bVar.dBv == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.o> ajA2 = this.cBG.getPbData().ajA();
                    int size2 = ajA2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < ajA2.get(i2).aCZ().size()) {
                                if (!bVar.mPostId.equals(ajA2.get(i2).aCZ().get(i3).getId())) {
                                    i3++;
                                } else {
                                    ajA2.get(i2).aCZ().remove(i3);
                                    ajA2.get(i2).aDb();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData ajG = this.cBG.getPbData().ajG();
                        com.baidu.tieba.tbadkCore.data.o oVar = ajA2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.data.o> aDc = oVar.aDc();
                        int size3 = aDc.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!bVar.mPostId.equals(ajA2.get(i2).aDc().get(i4).getId())) {
                                    i4++;
                                } else {
                                    aDc.remove(i4);
                                    ajG.decreaseAlreadyCount();
                                    if (oVar.aDj() > aDc.size()) {
                                        oVar.mx(aDc.size());
                                    }
                                    if (aDc.size() > 0) {
                                        com.baidu.tieba.tbadkCore.data.o oVar2 = aDc.get(aDc.size() - 1);
                                        ajG.setLastAdditionTime(oVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a aDe = oVar2.aDe();
                                        String str = "";
                                        if (aDe != null) {
                                            str = aDe.toString();
                                        }
                                        ajG.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a aDe2 = oVar.aDe();
                                        String str2 = "";
                                        if (aDe2 != null) {
                                            str2 = aDe2.toString();
                                        }
                                        ajG.setLastAdditionContent(str2);
                                    }
                                    akq();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.cBL.i(this.cBG.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.d dVar) {
        this.cBL.a(1, dVar.At, dVar.dBx, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.f fVar) {
        this.cBL.a(this.cBI.getLoadDataMode(), fVar.At, fVar.dBx, false);
        this.cBL.X(fVar.dBz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, a.f fVar) {
        if (fVar != null) {
            this.cBL.a(this.cBI.getLoadDataMode(), fVar.At, fVar.dBx, true);
            if (fVar.At) {
                this.cBO = true;
                if (i == 2) {
                    this.cBG.getPbData().ajz().bK(1);
                    this.cBG.setIsGood(1);
                } else if (i == 3) {
                    this.cBG.getPbData().ajz().bK(0);
                    this.cBG.setIsGood(0);
                } else if (i == 4) {
                    this.cBG.getPbData().ajz().bJ(1);
                    this.cBG.jS(1);
                } else if (i == 5) {
                    this.cBG.getPbData().ajz().bJ(0);
                    this.cBG.jS(0);
                }
                this.cBL.a(this.cBG.getPbData(), this.cBG.akF(), true);
            }
        }
    }

    private void akg() {
        if (this.cBG.akG()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.cBG.getThreadID());
            setResult(-1, intent);
        }
        if (akl()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akh() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        this.cBL.alO();
        if (this.cBG != null && this.cBG.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.cBG.getPbData().ajz().getId();
            historyMessage.forumName = this.cBG.getPbData().ajy().getName();
            historyMessage.threadName = this.cBG.getPbData().ajz().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> ajA = this.cBG.getPbData().ajA();
            int alD = this.cBL.alD();
            if (ajA != null && alD >= 0 && alD < ajA.size()) {
                historyMessage.postID = ajA.get(alD).getId();
            }
            historyMessage.isHostOnly = this.cBG.getHostMode();
            historyMessage.isSquence = this.cBG.akF();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.cBG != null && this.cBG.akG()) {
            Intent intent = new Intent();
            if (this.cBO) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.cBG.getThreadID());
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.cBG.akI());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.cBG.getIsGood());
            }
            setResult(-1, intent);
        }
        if (akl()) {
            if (this.cBG != null && this.cBL != null && this.cBL.getListView() != null) {
                com.baidu.tieba.pb.a.c pbData = this.cBG.getPbData();
                if (pbData != null && pbData.getUserData() != null) {
                    pbData.getUserData().setBimg_url(TbadkCoreApplication.m411getInst().getDefaultBubble());
                }
                ct.ale().a(this.cBG.getPbData(), this.cBL.getListView().onSaveInstanceState(), this.cBG.akF(), this.cBG.getHostMode());
            } else {
                ct.ale().reset();
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
    public boolean jQ(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(n.i.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.cBS.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    akj();
                    return;
                case 13008:
                    ct.ale().reset();
                    this.mHandler.postDelayed(new af(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.cBG != null) {
                        a(aki(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                if (intent != null && aka() != null && ajY() != null && aka().alo() && com.baidu.tbadk.editortools.d.b.BV().getStatus() == 1) {
                    com.baidu.tbadk.editortools.d.b.BV().setStatus(0);
                    if (this.cBL != null) {
                        this.cBL.aln();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private ShareFromPBMsgData aki() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] aD = this.cBG.getPbData().aD(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.data.o alp = this.cBL.alp();
        String str = "";
        if (alp != null) {
            str = alp.getId();
            String aR = alp.aR(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(aR)) {
                aD[1] = aR;
            }
        }
        String sT = this.cBG.getPbData().ajz().sT();
        if (sT != null && sT.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(aD[1]);
        shareFromPBMsgData.setImageUrl(aD[0]);
        shareFromPBMsgData.setForumName(this.cBG.getPbData().ajy().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.cBG.getPbData().ajz().getId());
        shareFromPBMsgData.setTitle(this.cBG.getPbData().ajz().getTitle());
        return shareFromPBMsgData;
    }

    private void N(Intent intent) {
        a(aki(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.cBG != null && this.cBG.getPbData() != null && this.cBG.getPbData().ajz() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            ef efVar = new ef(getPageContext().getPageActivity());
            efVar.setData(shareFromPBMsgData);
            aVar.bP(1);
            aVar.m(efVar);
            aVar.a(n.i.share, new ag(this, efVar, j, str, str2, shareFromPBMsgData));
            aVar.b(n.i.alert_no_button, new ah(this, efVar));
            aVar.am(false);
            aVar.b(getPageContext()).tv();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                efVar.x(shareFromPBMsgData.getImageUrl(), this.cBG.getPbData().ajE() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.cBG != null && this.cBG.getPbData() != null && this.cBG.getPbData().ajz() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            ef efVar = new ef(getPageContext().getPageActivity());
            efVar.setData(shareFromPBMsgData);
            aVar.bP(1);
            aVar.m(efVar);
            aVar.a(n.i.share, new ai(this, efVar, i, str, j, shareFromPBMsgData));
            aVar.b(n.i.alert_no_button, new aj(this, efVar));
            aVar.am(false);
            aVar.b(getPageContext()).tv();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                efVar.x(shareFromPBMsgData.getImageUrl(), this.cBG.getPbData().ajE() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akj() {
        MarkData jZ;
        if (this.cBH != null && (jZ = this.cBG.jZ(this.cBL.alD())) != null) {
            if (!jZ.isApp() || (jZ = this.cBG.jZ(this.cBL.alD() + 1)) != null) {
                this.cBL.alx();
                this.cBH.a(jZ);
                if (!this.cBH.qp()) {
                    this.cBH.qr();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.cBH.qq();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akk() {
        com.baidu.tieba.pb.a.c pbData = this.cBG.getPbData();
        this.cBG.ff(true);
        pbData.kx(this.cBH.qo());
        this.cBL.i(pbData);
    }

    private boolean akl() {
        if (this.cBG == null) {
            return true;
        }
        if (this.cBG.qp()) {
            MarkData akQ = this.cBG.akQ();
            if (akQ == null || !this.cBG.getIsFromMark()) {
                return true;
            }
            MarkData jZ = this.cBG.jZ(this.cBL.alD());
            if (jZ == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, akQ);
                setResult(-1, intent);
                return true;
            } else if (jZ.getPostId() == null || jZ.getPostId().equals(akQ.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, akQ);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cC(String.format(getPageContext().getString(n.i.alert_update_mark), Integer.valueOf(jZ.getFloor())));
                aVar.a(n.i.alert_yes_btn, new al(this, jZ, akQ, aVar));
                aVar.b(n.i.alert_no_button, new am(this, akQ, aVar));
                aVar.a(new an(this, akQ, aVar));
                aVar.b(getPageContext());
                aVar.tv();
                return false;
            }
        } else if (this.cBG.getPbData() == null || this.cBG.getPbData().ajA() == null || this.cBG.getPbData().ajA().size() <= 0 || !this.cBG.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.cBL == null) {
            return null;
        }
        return this.cBL.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public int getRichTextViewId() {
        if (this.cBL == null) {
            return 0;
        }
        return this.cBL.alI();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int wk() {
        if (this.cBL == null) {
            return 0;
        }
        return this.cBL.NJ();
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<ImageView> getImageViewPool() {
        if (this.aDx == null) {
            this.aDx = new com.baidu.adp.lib.f.b<>(new ao(this), 8, 0);
        }
        return this.aDx;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<TextView> getTextViewPool() {
        if (this.aDy == null) {
            this.aDy = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.aDy;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<GifView> getGifViewPool() {
        if (this.aDB == null) {
            this.aDB = new com.baidu.adp.lib.f.b<>(new ap(this), 20, 0);
        }
        return this.aDB;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<View> getVoiceViewPool() {
        if (this.aDz == null) {
            this.aDz = new com.baidu.adp.lib.f.b<>(new aq(this), 8, 0);
        }
        return this.aDz;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> wl() {
        if (this.afK == null) {
            this.afK = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.afK;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    public boolean kA(String str) {
        Map<String, String> dB;
        if (!TextUtils.isEmpty(str) && (dB = com.baidu.tbadk.core.util.bf.dB(com.baidu.tbadk.core.util.bf.dC(str))) != null) {
            String str2 = dB.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return kA(com.baidu.adp.lib.util.j.aU(str2));
            }
            String str3 = dB.get(cBB);
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
            if (kB(str) || z) {
                boolean v = com.baidu.adp.lib.util.k.v(context, "com.qiyi.video");
                kC(str);
                if (v) {
                    akm();
                } else {
                    akn();
                }
            } else if (kA(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                com.baidu.tbadk.core.util.bf.vD().b(getPageContext(), new String[]{str});
            }
        }
    }

    private boolean kB(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }

    private void kC(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(";")) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.cBy = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.cBz = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.aUq = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.cBx = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void akm() {
        if (TextUtils.isEmpty(this.cBy) || TextUtils.isEmpty(this.cBz) || TextUtils.isEmpty(this.mPackageName)) {
            if (!TextUtils.isEmpty(this.cBx)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.cBx);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(this.cBy));
        intent.setAction(this.cBz);
        intent.setPackage(this.mPackageName);
        if (intent.resolveActivity(getPageContext().getPageActivity().getPackageManager()) != null) {
            if (!com.baidu.adp.lib.h.i.e(getPageContext().getPageActivity(), intent) && !TextUtils.isEmpty(this.cBx)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.cBx);
            }
        } else if (!TextUtils.isEmpty(this.cBx)) {
            com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.cBx);
        }
    }

    private void akn() {
        if (!com.baidu.adp.lib.util.i.iQ()) {
            if (!TextUtils.isEmpty(this.cBx)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.cBx);
                return;
            }
            return;
        }
        if (this.cBw == null) {
            this.cBw = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.cBw.bN(n.i.download_iqiyi_app_dialog);
            this.cBw.a(n.i.install_app, new ar(this));
            this.cBw.b(n.i.webpage_play, new as(this));
            this.cBw.am(false);
        }
        this.cBw.b(getPageContext()).tv();
    }

    private com.baidu.tbadk.core.dialog.a ako() {
        if (this.cBD == null) {
            this.cBD = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.cBD.cB(getPageContext().getString(n.i.download_baidu_video_dialog));
            this.cBD.a(getPageContext().getString(n.i.install), new at(this));
            this.cBD.b(getPageContext().getString(n.i.cancel), new au(this));
            this.cBD.al(true);
            this.cBD.b(getPageContext());
            this.cBD.am(false);
        }
        this.cBD.tv();
        return this.cBD;
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
            ako();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onSongClicked(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.FQ() == null) {
            return null;
        }
        return cVar.FQ().Gd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long c(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.FQ() == null) {
            return 0L;
        }
        return cVar.FQ().getOriginalSize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, HashMap<String, ImageUrlData> hashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.f FQ;
        if (aVar == aVar2) {
            this.cCh = true;
        }
        if (aVar != null) {
            int size = aVar.FL().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.FL().get(i6) == null || aVar.FL().get(i6).getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int width = aVar.FL().get(i6).FQ().getWidth();
                    int height = aVar.FL().get(i6).FQ().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.FL().get(i6).FQ().Ga()) {
                        if (aVar == aVar2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.FL().get(i6);
                        String d = d(cVar);
                        arrayList.add(d);
                        if (!TextUtils.isEmpty(d) && cVar != null && (FQ = cVar.FQ()) != null) {
                            String Gb = FQ.Gb();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Gb;
                            int i9 = this.mIsFromCDN ? 17 : 18;
                            imageUrlData.urlType = i9;
                            imageUrlData.urlType = i9;
                            imageUrlData.originalUrl = b(cVar);
                            imageUrlData.originalSize = c(cVar);
                            if (hashMap != null) {
                                hashMap.put(d, imageUrlData);
                            }
                        }
                        if (!this.cCh) {
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
    public void c(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (oVar != null) {
            boolean z = false;
            if (oVar.getId() != null && oVar.getId().equals(this.cBG.sP())) {
                z = true;
            }
            MarkData d = this.cBG.d(oVar);
            if (d != null) {
                this.cBL.alx();
                if (this.cBH != null) {
                    this.cBH.a(d);
                    if (!z) {
                        this.cBH.qr();
                    } else {
                        this.cBH.qq();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a ac(String str, int i) {
        if (this.cBG == null || this.cBG.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.a.c pbData = this.cBG.getPbData();
        com.baidu.tbadk.widget.richText.a a2 = a(pbData.ajA(), str, i);
        if (a2 == null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.o> ajA = pbData.ajA();
            int size = ajA.size();
            for (int i2 = 0; i2 < size; i2++) {
                a2 = a(ajA.get(i2).aDc(), str, i);
                if (a2 != null) {
                    return a2;
                }
            }
            return a2;
        }
        return a2;
    }

    private long kD(String str) {
        ArrayList<com.baidu.tieba.tbadkCore.data.o> ajA;
        com.baidu.tieba.pb.a.c pbData = this.cBG.getPbData();
        if (pbData != null && (ajA = pbData.ajA()) != null && !ajA.isEmpty()) {
            Iterator<com.baidu.tieba.tbadkCore.data.o> it = ajA.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.o next = it.next();
                com.baidu.tieba.tbadkCore.data.g aDn = next.aDn();
                if (aDn != null && aDn.dzp) {
                    Iterator<com.baidu.tbadk.widget.richText.c> it2 = next.aDe().FL().iterator();
                    while (it2.hasNext()) {
                        com.baidu.tbadk.widget.richText.c next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.FY().getLink().equals(str)) {
                            return aDn.aCJ();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.data.o> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> FL;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a aDe = arrayList.get(i2).aDe();
            if (aDe != null && (FL = aDe.FL()) != null) {
                int size = FL.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (FL.get(i4) != null && FL.get(i4).getType() == 8) {
                        i3++;
                        if (FL.get(i4).FQ().Gb().equals(str)) {
                            int width = FL.get(i4).FQ().getWidth();
                            int height = FL.get(i4).FQ().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.cCg = i4;
                            return aDe;
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
        com.baidu.tbadk.widget.richText.f FQ = cVar.FQ();
        if (FQ != null) {
            if (!StringUtils.isNull(FQ.FZ())) {
                return FQ.FZ();
            }
            if (FQ.getHeight() * FQ.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (FQ.getHeight() * FQ.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (FQ.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * FQ.getHeight())));
            } else {
                float width = FQ.getWidth() / FQ.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.ax.aT(FQ.getSrc()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onPhoneClicked(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.cBj = str;
            if (this.cBC == null) {
                akd();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.cBC.bU(1).setVisibility(8);
            } else {
                this.cBC.bU(1).setVisibility(0);
            }
            this.cBC.tz();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akp() {
        hideNetRefreshView(this.cBL.getView());
        showLoadingView(this.cBL.getView(), true);
        if (this.cBG.DJ()) {
            this.cBL.alx();
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
        if (this.cBG.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.a.c pbData = this.cBG.getPbData();
            String name = pbData.ajy().getName();
            String title = pbData.ajz().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.cBG.getThreadID() + "?share=9105&fr=share";
            String[] aD = pbData.aD(getPageContext().getPageActivity());
            String str2 = aD[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = aD[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (ake() == 1) {
                if (pbData != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10399").ab(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ab("tid", pbData.getThreadId()).ab("uid", currentAccount));
                }
            } else if (ake() == 2 && pbData != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10406").ab(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ab("tid", pbData.getThreadId()).ab("uid", currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(n.i.share_content_tpl), title, name, str3);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.linkUrl = str;
            fVar.akI = true;
            fVar.extData = this.cBG.getThreadID();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true, qF());
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(n.i.share_tieba_qunzu, n.e.icon_unite_share_qunzu, new aw(this));
            shareDialogConfig.addOutsideTextView(n.i.forum_friend, n.e.icon_unite_share_baf, new ax(this));
            shareDialogConfig.setCopyLinkListener(new ay(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private SparseArray<String> qF() {
        if (this.aZJ == null) {
            this.aZJ = new SparseArray<>(7);
            this.aZJ.put(2, "pb_wx_timeline");
            this.aZJ.put(3, "pb_wx_friend");
            this.aZJ.put(4, "pb_qq_zone");
            this.aZJ.put(5, "pb_tencent_weibo");
            this.aZJ.put(6, "pb_sina_weibo");
            this.aZJ.put(7, "pb_renren");
        }
        return this.aZJ;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<LinearLayout> getTextVoiceViewPool() {
        if (this.aDA == null) {
            this.aDA = new com.baidu.adp.lib.f.b<>(new az(this), 15, 0);
        }
        return this.aDA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akq() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.pb.a.c pbData = this.cBG.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.rZ().isIfAddition();
            AdditionData ajG = pbData.ajG();
            boolean z3 = ajG == null ? false : isIfAddition;
            if (z3) {
                z = ajG.getAlreadyCount() != ajG.getTotalCount();
                if (!TextUtils.isEmpty(ajG.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.pb.main.b.c cVar = this.cBL.cEm;
            if (!z3 || !z) {
                z2 = false;
            }
            cVar.fx(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.cBL.alr() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10517").r("obj_locate", 2).ab(ImageViewerConfig.FORUM_ID, this.cBG.getPbData().getForumId()));
            } else {
                com.baidu.tbadk.core.data.z ajz = this.cBG.getPbData().ajz();
                if (view != null) {
                    boolean z = ajz.getPraise() == null || ajz.getPraise().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.aYp > 1000) {
                            this.aYq = true;
                            E(view);
                        } else {
                            this.aYq = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            d(view, this.aYq);
                        } else {
                            c(view, this.aYq);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        c(view, this.aYq);
                    } else if (motionEvent.getAction() == 3) {
                        c(view, this.aYq);
                    }
                }
            }
        }
        return false;
    }

    private void c(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), n.a.praise_animation_scale2));
            new Handler().postDelayed(new ba(this), 200L);
        }
    }

    private void d(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), n.a.praise_animation_scale3));
            new Handler().postDelayed(new bb(this), 600L);
        }
    }

    private void E(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), n.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void MS() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(n.i.login_to_use), true, 11017)));
        } else if (aVar.tx() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.tx();
            int intValue = ((Integer) sparseArray.get(da.cFL)).intValue();
            if (intValue == da.cFM) {
                if (!this.cBI.aDT()) {
                    this.cBL.alu();
                    int intValue2 = ((Integer) sparseArray.get(n.f.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(n.f.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(n.f.tag_del_post_type)).intValue();
                    this.cBI.a(this.cBG.getPbData().ajy().getId(), this.cBG.getPbData().ajy().getName(), this.cBG.getPbData().ajz().getId(), (String) sparseArray.get(n.f.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == da.cFN || intValue == da.cFP) {
                this.cBG.ka(cc.cDA);
                if (intValue == da.cFN) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == da.cFO) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.cCk).rw()));
            }
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (sparseArray.get(n.f.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(n.f.tag_user_mute_mute_username);
        }
        if (sparseArray.get(n.f.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(n.f.tag_user_mute_thread_id);
        }
        if (sparseArray.get(n.f.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(n.f.tag_user_mute_post_id);
        }
        this.cBJ.a(z, str, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
    }

    private boolean kE(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bj.ah(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.tZ().getString("bubble_link", ""))) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(n.i.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void eZ(boolean z) {
        this.cBQ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String akr() {
        ArrayList<com.baidu.tieba.tbadkCore.data.o> ajA;
        int k;
        if (this.cBG == null || this.cBG.getPbData() == null || this.cBG.getPbData().ajA() == null || (k = com.baidu.tbadk.core.util.y.k((ajA = this.cBG.getPbData().ajA()))) == 0) {
            return "";
        }
        int alD = this.cBL.alD();
        com.baidu.tieba.tbadkCore.data.o oVar = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tbadk.core.util.y.b(ajA, alD);
        if (oVar == null || oVar.getAuthor() == null) {
            return "";
        }
        if (this.cBG.kI(oVar.getAuthor().getUserId())) {
            return oVar.getId();
        }
        for (int i = alD - 1; i != 0; i--) {
            com.baidu.tieba.tbadkCore.data.o oVar2 = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tbadk.core.util.y.b(ajA, i);
            if (oVar2 == null || oVar2.getAuthor() == null || oVar2.getAuthor().getUserId() == null) {
                break;
            } else if (this.cBG.kI(oVar2.getAuthor().getUserId())) {
                return oVar2.getId();
            }
        }
        for (int i2 = alD + 1; i2 < k; i2++) {
            com.baidu.tieba.tbadkCore.data.o oVar3 = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tbadk.core.util.y.b(ajA, i2);
            if (oVar3 == null || oVar3.getAuthor() == null || oVar3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.cBG.kI(oVar3.getAuthor().getUserId())) {
                return oVar3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onLinkButtonClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bf.vD().b(getPageContext(), new String[]{str})) {
            com.baidu.tieba.pb.a.a(kD(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.cBG.getPbData().ajy().getId(), this.cBG.getPbData().ajy().getName(), this.cBG.getPbData().ajz().getTid());
        }
    }
}
