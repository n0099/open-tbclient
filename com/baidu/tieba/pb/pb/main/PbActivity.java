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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
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
import com.baidu.tbadk.core.atomData.ReadPbServiceConfig;
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
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.b.a;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.cm;
import com.baidu.tieba.t;
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
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, com.baidu.tbadk.widget.richText.l {
    public static boolean cMq = false;
    private static String cMz = "tbgametype";
    private com.baidu.adp.lib.f.b<ImageView> aFO;
    private com.baidu.adp.lib.f.b<TextView> aFP;
    private com.baidu.adp.lib.f.b<View> aFQ;
    private com.baidu.adp.lib.f.b<LinearLayout> aFR;
    private com.baidu.adp.lib.f.b<GifView> aFS;
    private com.baidu.adp.lib.f.b<TbImageView> ahx;
    private VoiceManager ben;
    private com.baidu.tbadk.core.dialog.a cMB;
    private ct cMO;
    private boolean cMS;
    private com.baidu.tieba.tbadkCore.data.e cMT;
    private com.baidu.tbadk.editortools.d.e cMU;
    private String cMf;
    private com.baidu.tieba.b.a cMr;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean cMs = false;
    private boolean cMt = false;
    private boolean cIp = false;
    private com.baidu.tbadk.core.dialog.a cMu = null;
    private String cMv = null;
    private String baG = null;
    private String cMw = null;
    private String cMx = null;
    private String mPackageName = null;
    private int cMy = 0;
    private com.baidu.tbadk.core.dialog.c cMA = null;
    SparseArray<String> bfX = null;
    private long aWx = -1;
    private long aAK = 0;
    private long createTime = 0;
    private long aAL = 0;
    private boolean cMC = false;
    private com.baidu.tbadk.performanceLog.e cMD = null;
    private long cME = 0;
    private String avb = null;
    private final Handler mHandler = new Handler(new d(this));
    private cm cMF = null;
    private com.baidu.tbadk.baseEditMark.a cMG = null;
    private com.baidu.tieba.tbadkCore.f.a cMH = null;
    private UserMuteAddAndDelModel cMI = null;
    private com.baidu.tieba.usermute.i cMJ = null;
    private dz cMK = null;
    public final com.baidu.tieba.pb.pb.main.a.a cML = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean cMM = false;
    private boolean cMN = false;
    private boolean cMP = false;
    private boolean cMQ = false;
    private boolean cMR = false;
    private boolean bfq = false;
    private boolean cMV = false;
    private com.baidu.tbadk.editortools.d.c avf = new o(this);
    private CustomMessageListener bsq = new z(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener bem = new ak(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener crw = new av(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener cMW = new bg(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener bPU = new bn(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private HttpMessageListener cMX = new bo(this, CmdConfigHttp.PB_LOTTERY_HTTP_CMD);
    private cm.b cMY = new by(this);
    private View.OnClickListener cqV = new e(this);
    private CustomMessageListener cMZ = new f(this, CmdConfigCustom.CMD_SEND_GIFT_SUCCESS);
    private boolean bee = false;
    private com.baidu.tieba.tbadkCore.ae beq = new com.baidu.tieba.tbadkCore.ae(getPageContext(), new g(this));
    private long beD = 0;
    private boolean beE = true;
    private CustomMessageListener bgl = new h(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener cNa = new i(this, CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED);
    private com.baidu.tieba.pb.b.c cKb = new com.baidu.tieba.pb.b.c(new j(this));
    private UserMuteAddAndDelModel.a cNb = new k(this);
    private i.a cNc = new l(this);
    public a.b cEP = new m(this);
    public final View.OnClickListener bjG = new n(this);
    private final a.d avl = new p(this);
    private final cm.c cNd = new q(this);
    private CustomMessageListener cNe = new r(this, CmdConfigCustom.CMD_TTS_OPTION_PB);
    private final a.InterfaceC0041a cNf = new s(this);
    private final AbsListView.OnScrollListener Ix = new t(this);
    private final com.baidu.adp.base.g cNg = new u(this);
    private final c cNh = new v(this);
    private final r.a aLy = new w(this);
    private final BdListView.e cNi = new x(this);
    private final BdListView.h cNj = new y(this);
    private int cNk = 0;
    private final TbRichTextView.d aGi = new aa(this);
    boolean cNl = false;
    com.baidu.tieba.tbadkCore.data.r cNm = null;
    private final c.b cNn = new ab(this);
    private final View.OnLongClickListener anJ = new ac(this);
    private final NoNetworkView.a bdG = new ad(this);
    public View.OnTouchListener bjS = new ae(this);
    private a.InterfaceC0059a aUx = new af(this);
    private String cNo = null;
    private final cm.a cNp = new ag(this);

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> cNG;
        public ConcurrentHashMap<String, ImageUrlData> cNH;
        public boolean cNJ;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean cNI = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes.dex */
    public interface c {
        void fp(boolean z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.d.e aph() {
        return this.cMU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kM(int i) {
        if (this.cMF != null && this.cMF.getPbData() != null && this.cMF.getPbData().aoE() != null) {
            this.cMF.getPbData().aoE().setLike(i);
            com.baidu.tieba.tbadkCore.x xVar = new com.baidu.tieba.tbadkCore.x();
            xVar.setLike(i);
            xVar.setUserLevel(-1);
            xVar.setLevelName("");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, xVar));
        }
    }

    public void b(com.baidu.tieba.pb.a.d dVar) {
        if (dVar.aoQ() != null) {
            String id = dVar.aoQ().getId();
            ArrayList<com.baidu.tieba.tbadkCore.data.r> aoG = this.cMF.getPbData().aoG();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aoG.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.r rVar = aoG.get(i2);
                if (rVar.getId() == null || !rVar.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.data.r> aoU = dVar.aoU();
                    rVar.oi(dVar.getTotalCount());
                    if (rVar.aMs() != null) {
                        rVar.aMs().clear();
                        rVar.aMs().addAll(aoU);
                    }
                }
            }
            this.cMK.j(this.cMF.getPbData());
        }
    }

    public void api() {
        com.baidu.tieba.pb.a.c pbData;
        com.baidu.tbadk.core.data.ah aoF;
        if (!this.bee) {
            if (!com.baidu.adp.lib.util.k.jq()) {
                showToast(t.j.no_network_guide);
            } else if (this.beE) {
                this.bee = true;
                if (this.cMF != null && (pbData = this.cMF.getPbData()) != null && (aoF = pbData.aoF()) != null) {
                    int isLike = aoF.getPraise() == null ? 0 : aoF.getPraise().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10796").aa("tid", aoF.getId()));
                    }
                    if (this.beq != null) {
                        this.beq.a(aoF.ty(), aoF.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        if ((sparseArray.get(t.g.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(t.g.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(t.g.tag_check_mute_from) instanceof Integer)) {
            String str = (String) sparseArray.get(t.g.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(t.g.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
                cVar.cb(t.j.operation);
                int i = -1;
                if (sparseArray.get(t.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(t.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(t.j.delete);
                    strArr[1] = z ? getResources().getString(t.j.un_mute) : getResources().getString(t.j.mute);
                    cVar.a(strArr, new ah(this, sparseArray, z, str));
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(t.j.un_mute) : getResources().getString(t.j.mute);
                    cVar.a(strArr2, new ai(this, sparseArray, z, str));
                }
                cVar.d(getPageContext()).un();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gl(int i) {
        com.baidu.tbadk.core.data.ah aoF;
        String sb;
        String y;
        if (this.cMF != null && this.cMF.getPbData() != null && (aoF = this.cMF.getPbData().aoF()) != null) {
            if (i == 1) {
                PraiseData praise = aoF.getPraise();
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
                        aoF.setPraise(praiseData);
                    } else {
                        aoF.getPraise().getUser().add(0, metaData);
                        aoF.getPraise().setNum(aoF.getPraise().getNum() + 1);
                        aoF.getPraise().setIsLike(i);
                    }
                }
                if (aoF.getPraise() != null) {
                    if (aoF.getPraise().getNum() < 1) {
                        y = getResources().getString(t.j.frs_item_praise_text);
                    } else {
                        y = com.baidu.tbadk.core.util.aw.y(aoF.getPraise().getNum());
                    }
                    this.cMK.D(y, true);
                }
            } else if (aoF.getPraise() != null) {
                aoF.getPraise().setIsLike(i);
                aoF.getPraise().setNum(aoF.getPraise().getNum() - 1);
                ArrayList<MetaData> user = aoF.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aoF.getPraise().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aoF.getPraise().getNum() < 1) {
                    sb = getResources().getString(t.j.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(aoF.getPraise().getNum())).toString();
                }
                this.cMK.D(sb, false);
            }
            if (this.cMF.apP()) {
                this.cMK.arb().notifyDataSetChanged();
            } else {
                this.cMK.k(this.cMF.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.tieba.tbadkCore.data.r a2;
        if (this.cMF != null && this.cMF.getPbData() != null && (a2 = a(this.cMF.getPbData(), this.cMF.apP(), this.cMF.aqe())) != null) {
            a(a2, updateAttentionMessage);
            if (this.cMK != null && this.cMF != null) {
                this.cMK.c(this.cMF.getPbData(), this.cMF.apP(), this.cMF.aqe());
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.r rVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        int i2;
        if (rVar != null && rVar.getAuthor() != null && rVar.getAuthor().getUserId() != null && rVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = rVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
                i2 = 1;
            } else {
                i = fansNum - 1;
                i2 = 0;
            }
            rVar.getAuthor().setFansNum(i);
            if (rVar.getAuthor().getGodUserData() != null) {
                rVar.getAuthor().getGodUserData().setFollowed(i2);
                rVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }

    private com.baidu.tieba.tbadkCore.data.r a(com.baidu.tieba.pb.a.c cVar, boolean z, int i) {
        if (z) {
            if (cVar == null || cVar.aoG() == null || cVar.aoG().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.r rVar = cVar.aoG().get(0);
            if (rVar.aMw() != 1) {
                return b(cVar);
            }
            return rVar;
        }
        return b(cVar);
    }

    private com.baidu.tieba.tbadkCore.data.r b(com.baidu.tieba.pb.a.c cVar) {
        MetaData metaData;
        if (cVar == null || cVar.aoF() == null || cVar.aoF().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.r rVar = new com.baidu.tieba.tbadkCore.data.r();
        MetaData author = cVar.aoF().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = cVar.aoF().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        rVar.oj(1);
        rVar.setId(cVar.aoF().ty());
        rVar.setTitle(cVar.aoF().getTitle());
        rVar.setTime(cVar.aoF().getCreateTime());
        rVar.setAuthor(metaData);
        return rVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cMF.m(bundle);
        if (this.ben != null) {
            this.ben.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.cMU.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.aWx = intent.getLongExtra("TibaStatic.StartTime", -1L);
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(intent.getStringExtra("from"))) {
                this.cMs = true;
            }
            this.cMQ = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
        } else {
            this.aWx = System.currentTimeMillis();
        }
        super.onCreate(bundle);
        this.cMy = 0;
        n(bundle);
        qD();
        if (intent != null && this.cMK != null) {
            this.cMK.cQk = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
        }
        this.ben = new VoiceManager();
        this.ben.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.d.n nVar = new com.baidu.tbadk.editortools.d.n();
        nVar.setForumName(this.cMF.apO());
        if (this.cMF.getPbData() != null && this.cMF.getPbData().aoE() != null) {
            nVar.setForumId(this.cMF.getPbData().aoE().getId());
        }
        nVar.setFrom("pb");
        nVar.a(this.cMF);
        this.cMU = (com.baidu.tbadk.editortools.d.e) nVar.ak(getActivity());
        this.cMU.d(this);
        this.cMU.a(this.avl);
        this.cMU.a(this.avf);
        this.cMU.a(this, bundle);
        this.cMU.Cz().c(new com.baidu.tbadk.editortools.x(getActivity()));
        fj(true);
        this.cMK.setEditorTools(this.cMU.Cz());
        this.cMU.a(this.cMF.apW(), this.cMF.getThreadID(), this.cMF.apL());
        registerListener(this.bem);
        if (!this.cMF.apT()) {
            this.cMU.fr(this.cMF.getThreadID());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.aWx;
        registerListener(this.bsq);
        registerListener(this.crw);
        registerListener(this.cMW);
        this.cMX.setSelfListener(true);
        registerListener(this.cMX);
        this.cMT = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.dWx);
        this.cMT.aLU();
        registerListener(this.cMZ);
        registerListener(this.bgl);
        if (this.cMF != null) {
            this.cMF.aqh();
        }
        if (TbadkCoreApplication.m411getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.cNa);
        registerListener(this.cNe);
    }

    private void fj(boolean z) {
        this.cMU.bn(z);
        this.cMU.bo(z);
        this.cMU.bp(z);
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
        if (this.ben != null) {
            this.ben.onStart(getPageContext());
        }
    }

    public dz apj() {
        return this.cMK;
    }

    public cm apk() {
        return this.cMF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.m411getInst().isReadMenuDialogOnTop()) {
            this.cMt = false;
        } else {
            this.cMt = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.cMy = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.cMy == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.ben != null) {
            this.ben.onPause(getPageContext());
        }
        if (this.cMK != null) {
            this.cMK.onPause();
        }
        if (!this.cMF.apT()) {
            this.cMU.fq(this.cMF.getThreadID());
        }
        if (this.cMF != null) {
            this.cMF.aqi();
        }
        MessageManager.getInstance().unRegisterListener(this.bPU);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
    }

    private boolean apl() {
        com.baidu.tieba.tbadkCore.data.r a2 = a(this.cMF.getPbData(), this.cMF.apP(), this.cMF.aqe());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.cMt = false;
        super.onResume();
        if (apl()) {
            this.cME = System.currentTimeMillis();
        } else {
            this.cME = -1L;
        }
        if (this.cMK != null && this.cMK.getView() != null) {
            if (!this.cIp) {
                showLoadingView(this.cMK.getView(), true);
            } else {
                hideLoadingView(this.cMK.getView());
            }
        }
        if (this.cMy == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.cMK != null) {
            noNetworkView = this.cMK.aqR();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.iZ()) {
            noNetworkView.ax(false);
        }
        if (this.ben != null) {
            this.ben.onResume(getPageContext());
        }
        registerListener(this.bPU);
        this.cMS = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.cMK.fC(z);
        if (this.cMO != null) {
            this.cMO.fv(z);
        }
        if (z && this.cMS) {
            this.cMK.ari();
            this.cMF.fr(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cME > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10804").aa("obj_duration", new StringBuilder(String.valueOf(System.currentTimeMillis() - this.cME)).toString()));
            this.cME = 0L;
        }
        if (this.cMU != null && this.cMU.Cz() != null && this.cMU.Cz().getVisibility() != 0) {
            this.cMU.Dn();
        }
        if (this.cMK.cQn != null && !this.cMK.cQn.arP()) {
            this.cMK.cQn.ajS();
        }
        if (this.cMF != null && this.cMF.getPbData() != null && this.cMF.getPbData().aoE() != null && this.cMF.getPbData().aoF() != null) {
            com.baidu.tbadk.distribute.a.Cl().b(getPageContext().getPageActivity(), "pb", this.cMF.getPbData().aoE().getId(), com.baidu.adp.lib.h.b.c(this.cMF.getPbData().aoF().getId(), 0L));
        }
        if (this.ben != null) {
            this.ben.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cMP && this.cMF != null) {
            a(this.cMF.getPbData(), -2, false, false);
        }
        if (!this.cMC) {
            this.cMC = true;
            this.cMK.arB();
        }
        this.cMJ.onDestroy();
        this.cMF.cancelLoadData();
        this.cMF.destory();
        this.cMU.onDestroy();
        this.cMH.cancelLoadData();
        this.cMK.onDestroy();
        if (this.cMK.cQn != null) {
            this.cMK.cQn.ajS();
        }
        if (this.cMD != null) {
            this.cMD.onDestroy();
        }
        super.onDestroy();
        if (this.ben != null) {
            this.ben.onDestory(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cMK.onChangeSkinType(i);
        if (this.cMU != null && this.cMU.Cz() != null) {
            this.cMU.Cz().onChangeSkinType(i);
        }
        if (this.cMK.aqR() != null) {
            this.cMK.aqR().onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apm() {
        this.cMO = new ct(getPageContext(), this.bjG);
        this.cMO.fv(this.mIsLogin);
    }

    private void qD() {
        this.cMK = new dz(this, this.bjG, this.cKb);
        this.cMr = new com.baidu.tieba.b.a();
        this.cMr.a(this.aUx);
        this.cMK.setOnScrollListener(this.Ix);
        this.cMK.c(this.cNi);
        this.cMK.a(this.cNj);
        this.cMK.a(this.aLy);
        this.cMK.fg(com.baidu.tbadk.core.l.rn().rt());
        this.cMK.fh(com.baidu.tbadk.core.l.rn().rp());
        this.cMK.setOnImageClickListener(this.aGi);
        this.cMK.a(this.anJ);
        this.cMK.f(this.bdG);
        this.cMK.a(this.cNh);
        this.cMK.fC(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aA(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(t.g.tag_clip_board);
            if (obj instanceof com.baidu.tieba.tbadkCore.data.r) {
                com.baidu.tieba.tbadkCore.data.r rVar = (com.baidu.tieba.tbadkCore.data.r) obj;
                if (TextUtils.isEmpty(rVar.getBimg_url()) || !com.baidu.tbadk.core.l.rn().rt()) {
                    return false;
                }
                return kG(rVar.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.cMK != null) {
            if (z && !this.cIp) {
                showLoadingView(this.cMK.getView(), true);
            } else {
                hideLoadingView(this.cMK.getView());
            }
        }
    }

    private void apn() {
        if (this.cMA == null) {
            this.cMA = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.cMA.a(new String[]{getPageContext().getString(t.j.call_phone), getPageContext().getString(t.j.sms_phone), getPageContext().getString(t.j.search_in_baidu)}, new aj(this)).cc(c.a.YC).cd(17).d(getPageContext());
        }
    }

    private void n(Bundle bundle) {
        this.cMF = new cm(this);
        this.cMF.a(this.cNd);
        this.cMF.a(this.cNp);
        this.cMF.a(this.cMY);
        this.cMF.aqf();
        if (bundle != null) {
            this.cMF.initWithBundle(bundle);
        } else {
            this.cMF.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra("request_code", -1) == 18003) {
            this.cMF.fu(true);
        }
        ds.aqK().C(this.cMF.apN(), this.cMF.getIsFromMark());
        if (StringUtils.isNull(this.cMF.getThreadID())) {
            finish();
        } else {
            this.cMF.ET();
        }
    }

    private void initData(Bundle bundle) {
        this.cMG = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.cMG != null) {
            this.cMG.a(this.cNf);
        }
        this.cMH = new com.baidu.tieba.tbadkCore.f.a(this);
        this.cMH.setLoadDataCallBack(this.cNg);
        this.cMI = new UserMuteAddAndDelModel(getPageContext());
        this.cMI.a(this.cNb);
        this.cMJ = new com.baidu.tieba.usermute.i(getPageContext(), this.cNc);
        this.cMK.a(new al(this));
        this.beq.setUniqueId(getUniqueId());
        this.beq.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = (String) sparseArray.get(t.g.tag_user_mute_mute_userid);
        this.cMK.agV();
        this.cMJ.a(com.baidu.adp.lib.h.b.c(currentAccount, 0L), com.baidu.adp.lib.h.b.c(str, 0L), sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apo() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.bX(t.j.go_setting_float_window_permission);
        aVar.bY(t.j.step_to_setting_float_permission);
        aVar.a(t.j.go_and_setting, new am(this));
        aVar.b(t.j.cancel, new an(this));
        aVar.b(getPageContext()).uj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int app() {
        if (this.cMF.getPbData() == null || this.cMF.getPbData().aoF() == null) {
            return -1;
        }
        return this.cMF.getPbData().aoF().tE();
    }

    public boolean fk(boolean z) {
        return z && this.cMK.arp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fl(boolean z) {
        if (this.cMF == null || this.cMF.getPbData() == null) {
            return false;
        }
        return ((this.cMF.getPbData().aoJ() != 0) || this.cMF.getPbData().aoF() == null || this.cMF.getPbData().aoF().getAuthor() == null || TextUtils.equals(this.cMF.getPbData().aoF().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void apq() {
        if (this.cMF != null && this.cMF.getPbData() != null && this.cMF.getPbData().aoF() != null && this.cMF.getPbData().aoF().getAuthor() != null) {
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.cMF.getPbData().aoF().getAuthor().getUserId());
            this.cMK.cQn.a(this.cMF.apP(), this.cMG != null ? this.cMG.qg() : false, fl(equals), fk(equals));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.tbadkCore.data.r rVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (rVar = (com.baidu.tieba.tbadkCore.data.r) sparseArray.get(t.g.tag_clip_board)) != null) {
            d(rVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.a.c cVar, int i, boolean z, boolean z2) {
        if (cVar != null && this.cMF != null) {
            dm dmVar = new dm(getUniqueId());
            dmVar.pbData = cVar;
            dmVar.threadId = this.cMF.getThreadID();
            dmVar.postId = this.cMF.getPostId();
            dmVar.cPN = i;
            dmVar.cPM = this.cMF.getHostMode();
            dmVar.cJN = this.cMF.qg();
            dmVar.isSquence = this.cMF.apP();
            dmVar.loadType = this.cMF.aqk();
            dmVar.cPO = z;
            dmVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, dmVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.a.c cVar, int i, boolean z, boolean z2) {
        if (cVar != null && this.cMF != null) {
            dm dmVar = new dm(getUniqueId());
            dmVar.pbData = cVar;
            dmVar.threadId = this.cMF.getThreadID();
            dmVar.postId = this.cMF.getPostId();
            dmVar.cPN = i;
            dmVar.cPM = this.cMF.getHostMode();
            dmVar.cJN = this.cMF.qg();
            dmVar.isSquence = this.cMF.apP();
            dmVar.loadType = this.cMF.aqk();
            dmVar.cPO = z;
            dmVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, dmVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        aiX();
    }

    public void a(boolean z, MarkData markData) {
        this.cMK.ark();
        this.cMF.ft(z);
        if (this.cMG != null) {
            this.cMG.Y(z);
            if (markData != null) {
                this.cMG.a(markData);
            }
        }
        if (this.cMF.qg()) {
            apv();
        } else {
            this.cMK.j(this.cMF.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kA(String str) {
        if (!StringUtils.isNull(str) && this.cMF != null) {
            String threadID = this.cMF.getThreadID();
            String id = this.cMF.getPbData().aoE().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(t.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.cMF.apT()) {
                    antiData.setBlock_forum_name(this.cMF.getPbData().aoE().getName());
                    antiData.setBlock_forum_id(this.cMF.getPbData().aoE().getId());
                    antiData.setUser_name(this.cMF.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.cMF.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.e.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.or(i)) {
            AntiHelper.X(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            this.cMI.fw(str);
        } else {
            this.cMK.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        int i = 0;
        if (bVar != null) {
            this.cMK.a(0, bVar.AD, bVar.dZa, true);
            if (bVar.AD) {
                if (bVar.dYY == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.r> aoG = this.cMF.getPbData().aoG();
                    int size = aoG.size();
                    while (true) {
                        if (i < size) {
                            if (!bVar.mPostId.equals(aoG.get(i).getId())) {
                                i++;
                            } else {
                                aoG.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.cMK.j(this.cMF.getPbData());
                } else if (bVar.dYY == 0) {
                    apr();
                } else if (bVar.dYY == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.r> aoG2 = this.cMF.getPbData().aoG();
                    int size2 = aoG2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < aoG2.get(i2).aMs().size()) {
                                if (!bVar.mPostId.equals(aoG2.get(i2).aMs().get(i3).getId())) {
                                    i3++;
                                } else {
                                    aoG2.get(i2).aMs().remove(i3);
                                    aoG2.get(i2).aMu();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData aoM = this.cMF.getPbData().aoM();
                        com.baidu.tieba.tbadkCore.data.r rVar = aoG2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.data.r> aMv = rVar.aMv();
                        int size3 = aMv.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!bVar.mPostId.equals(aoG2.get(i2).aMv().get(i4).getId())) {
                                    i4++;
                                } else {
                                    aMv.remove(i4);
                                    aoM.decreaseAlreadyCount();
                                    if (rVar.aMB() > aMv.size()) {
                                        rVar.ok(aMv.size());
                                    }
                                    if (aMv.size() > 0) {
                                        com.baidu.tieba.tbadkCore.data.r rVar2 = aMv.get(aMv.size() - 1);
                                        aoM.setLastAdditionTime(rVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a aiT = rVar2.aiT();
                                        String str = "";
                                        if (aiT != null) {
                                            str = aiT.toString();
                                        }
                                        aoM.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a aiT2 = rVar.aiT();
                                        String str2 = "";
                                        if (aiT2 != null) {
                                            str2 = aiT2.toString();
                                        }
                                        aoM.setLastAdditionContent(str2);
                                    }
                                    apA();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.cMK.j(this.cMF.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.d dVar) {
        this.cMK.a(1, dVar.AD, dVar.dZa, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.f fVar) {
        this.cMK.a(this.cMH.getLoadDataMode(), fVar.AD, fVar.dZa, false);
        this.cMK.X(fVar.dZc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, a.f fVar) {
        if (fVar != null) {
            this.cMK.a(this.cMH.getLoadDataMode(), fVar.AD, fVar.dZa, true);
            if (fVar.AD) {
                this.cMN = true;
                if (i == 2) {
                    this.cMF.getPbData().aoF().bV(1);
                    this.cMF.setIsGood(1);
                } else if (i == 3) {
                    this.cMF.getPbData().aoF().bV(0);
                    this.cMF.setIsGood(0);
                } else if (i == 4) {
                    this.cMF.getPbData().aoF().bU(1);
                    this.cMF.kP(1);
                } else if (i == 5) {
                    this.cMF.getPbData().aoF().bU(0);
                    this.cMF.kP(0);
                }
                this.cMK.a(this.cMF.getPbData(), this.cMF.apP(), true);
            }
        }
    }

    private void apr() {
        if (this.cMF.apQ()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.cMF.getThreadID());
            setResult(-1, intent);
        }
        if (apw()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aps() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.cMK != null) {
            this.cMK.ajp();
        }
        if (this.cMF != null && this.cMF.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.cMF.getPbData().aoF().getId();
            historyMessage.forumName = this.cMF.getPbData().aoE().getName();
            historyMessage.threadName = this.cMF.getPbData().aoF().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.data.r> aoG = this.cMF.getPbData().aoG();
            int arm = this.cMK != null ? this.cMK.arm() : 0;
            if (aoG != null && arm >= 0 && arm < aoG.size()) {
                historyMessage.postID = aoG.get(arm).getId();
            }
            historyMessage.isHostOnly = this.cMF.getHostMode();
            historyMessage.isSquence = this.cMF.apP();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.cMF != null && this.cMF.apQ()) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.cMF.getThreadID());
            if (this.cMN) {
                intent.putExtra("type", 2);
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.cMF.apS());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.cMF.getIsGood());
            }
            setResult(-1, intent);
        }
        if (apw()) {
            if (this.cMF != null && this.cMK != null && this.cMK.KM() != null) {
                com.baidu.tieba.pb.a.c pbData = this.cMF.getPbData();
                if (pbData != null && pbData.getUserData() != null) {
                    pbData.getUserData().setBimg_url(TbadkCoreApplication.m411getInst().getDefaultBubble());
                }
                ds.aqK().a(this.cMF.getPbData(), this.cMK.KM().onSaveInstanceState(), this.cMF.apP(), this.cMF.getHostMode());
            } else {
                ds.aqK().reset();
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
    public boolean kN(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.cMU.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    apu();
                    return;
                case 13008:
                    ds.aqK().reset();
                    this.mHandler.postDelayed(new ao(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.cMF != null) {
                        a(apt(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                if (intent != null && apj() != null && aph() != null && apj().aqU() && com.baidu.tbadk.editortools.d.b.Da().getStatus() == 1) {
                    com.baidu.tbadk.editortools.d.b.Da().setStatus(0);
                    if (this.cMK != null) {
                        this.cMK.aqT();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private ShareFromPBMsgData apt() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] aE = this.cMF.getPbData().aE(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.data.r aqV = this.cMK.aqV();
        String str = "";
        if (aqV != null) {
            str = aqV.getId();
            String aU = aqV.aU(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(aU)) {
                aE[1] = aU;
            }
        }
        String ty = this.cMF.getPbData().aoF().ty();
        if (ty != null && ty.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(aE[1]);
        shareFromPBMsgData.setImageUrl(aE[0]);
        shareFromPBMsgData.setForumName(this.cMF.getPbData().aoE().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.cMF.getPbData().aoF().getId());
        shareFromPBMsgData.setTitle(this.cMF.getPbData().aoF().getTitle());
        return shareFromPBMsgData;
    }

    private void M(Intent intent) {
        a(apt(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.cMF != null && this.cMF.getPbData() != null && this.cMF.getPbData().aoF() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            fm fmVar = new fm(getPageContext().getPageActivity());
            fmVar.setData(shareFromPBMsgData);
            aVar.ca(1);
            aVar.z(fmVar);
            aVar.a(t.j.share, new ap(this, fmVar, j, str, str2, shareFromPBMsgData));
            aVar.b(t.j.alert_no_button, new aq(this, fmVar));
            aVar.ak(true);
            aVar.b(getPageContext()).uj();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                fmVar.x(shareFromPBMsgData.getImageUrl(), this.cMF.getPbData().aoK() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.cMF != null && this.cMF.getPbData() != null && this.cMF.getPbData().aoF() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            fm fmVar = new fm(getPageContext().getPageActivity());
            fmVar.setData(shareFromPBMsgData);
            aVar.ca(1);
            aVar.z(fmVar);
            aVar.a(t.j.share, new ar(this, fmVar, i, str, j, shareFromPBMsgData));
            aVar.b(t.j.alert_no_button, new as(this, fmVar));
            aVar.ak(true);
            aVar.b(getPageContext()).uj();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                fmVar.x(shareFromPBMsgData.getImageUrl(), this.cMF.getPbData().aoK() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apu() {
        MarkData kW;
        if (this.cMG != null && (kW = this.cMF.kW(this.cMK.arn())) != null) {
            if (!kW.isApp() || (kW = this.cMF.kW(this.cMK.arn() + 1)) != null) {
                this.cMK.arh();
                this.cMG.a(kW);
                if (!this.cMG.qg()) {
                    this.cMG.qi();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.cMG.qh();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apv() {
        com.baidu.tieba.pb.a.c pbData = this.cMF.getPbData();
        this.cMF.ft(true);
        pbData.kx(this.cMG.qf());
        this.cMK.j(pbData);
    }

    private boolean apw() {
        if (this.cMF == null) {
            return true;
        }
        if (this.cMF.qg()) {
            MarkData aqa = this.cMF.aqa();
            if (aqa == null || !this.cMF.getIsFromMark()) {
                return true;
            }
            MarkData kW = this.cMF.kW(this.cMK.arn());
            if (kW == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aqa);
                setResult(-1, intent);
                return true;
            } else if (kW.getPostId() == null || kW.getPostId().equals(aqa.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aqa);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cE(String.format(getPageContext().getString(t.j.alert_update_mark), Integer.valueOf(kW.getFloor())));
                aVar.a(t.j.alert_yes_btn, new at(this, kW, aqa, aVar));
                aVar.b(t.j.alert_no_button, new au(this, aqa, aVar));
                aVar.a(new aw(this, aqa, aVar));
                aVar.b(getPageContext());
                aVar.uj();
                return false;
            }
        } else if (this.cMF.getPbData() == null || this.cMF.getPbData().aoG() == null || this.cMF.getPbData().aoG().size() <= 0 || !this.cMF.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: KM */
    public BdListView getListView() {
        if (this.cMK == null) {
            return null;
        }
        return this.cMK.KM();
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public int Hr() {
        if (this.cMK == null) {
            return 0;
        }
        return this.cMK.art();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int xi() {
        if (this.cMK == null) {
            return 0;
        }
        return this.cMK.Qc();
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<ImageView> Hs() {
        if (this.aFO == null) {
            this.aFO = new com.baidu.adp.lib.f.b<>(new ax(this), 8, 0);
        }
        return this.aFO;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<TextView> Ht() {
        if (this.aFP == null) {
            this.aFP = TbRichTextView.g(getPageContext().getPageActivity(), 8);
        }
        return this.aFP;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<GifView> Hu() {
        if (this.aFS == null) {
            this.aFS = new com.baidu.adp.lib.f.b<>(new ay(this), 20, 0);
        }
        return this.aFS;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<View> Hv() {
        if (this.aFQ == null) {
            this.aFQ = new com.baidu.adp.lib.f.b<>(new az(this), 8, 0);
        }
        return this.aFQ;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> xj() {
        if (this.ahx == null) {
            this.ahx = UserIconBox.e(getPageContext().getPageActivity(), 8);
        }
        return this.ahx;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void H(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    public boolean kB(String str) {
        Map<String, String> dB;
        if (!TextUtils.isEmpty(str) && (dB = com.baidu.tbadk.core.util.be.dB(com.baidu.tbadk.core.util.be.dC(str))) != null) {
            String str2 = dB.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return kB(com.baidu.adp.lib.util.j.aT(str2));
            }
            String str3 = dB.get(cMz);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void I(Context context, String str) {
        V(context, str);
    }

    private void V(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (kD(str) || z) {
                boolean v = com.baidu.adp.lib.util.k.v(context, "com.qiyi.video");
                kE(str);
                if (v) {
                    apx();
                } else {
                    apy();
                }
            } else if (kB(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else if (kC(str)) {
                com.baidu.tbadk.core.util.be.wt().a(getPageContext(), new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.be.wt().c(getPageContext(), new String[]{str});
            }
        }
    }

    private boolean kC(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }

    private boolean kD(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }

    private void kE(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.cMw = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.cMx = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.baG = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.cMv = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void apx() {
        if (TextUtils.isEmpty(this.cMw) || TextUtils.isEmpty(this.cMx) || TextUtils.isEmpty(this.mPackageName)) {
            if (!TextUtils.isEmpty(this.cMv)) {
                com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), false, this.cMv);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(this.cMw));
        intent.setAction(this.cMx);
        intent.setPackage(this.mPackageName);
        if (intent.resolveActivity(getPageContext().getPageActivity().getPackageManager()) != null) {
            if (!com.baidu.adp.lib.h.i.e(getPageContext().getPageActivity(), intent) && !TextUtils.isEmpty(this.cMv)) {
                com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), false, this.cMv);
            }
        } else if (!TextUtils.isEmpty(this.cMv)) {
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), false, this.cMv);
        }
    }

    private void apy() {
        if (!com.baidu.adp.lib.util.i.ja()) {
            if (!TextUtils.isEmpty(this.cMv)) {
                com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), false, this.cMv);
                return;
            }
            return;
        }
        if (this.cMu == null) {
            this.cMu = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.cMu.bY(t.j.download_iqiyi_app_dialog);
            this.cMu.a(t.j.install_app, new ba(this));
            this.cMu.b(t.j.webpage_play, new bb(this));
            this.cMu.ak(false);
        }
        this.cMu.b(getPageContext()).uj();
    }

    private com.baidu.tbadk.core.dialog.a apz() {
        if (this.cMB == null) {
            this.cMB = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.cMB.cD(getPageContext().getString(t.j.download_baidu_video_dialog));
            this.cMB.a(getPageContext().getString(t.j.install), new bc(this));
            this.cMB.b(getPageContext().getString(t.j.cancel), new bd(this));
            this.cMB.aj(true);
            this.cMB.b(getPageContext());
            this.cMB.ak(false);
        }
        this.cMB.uj();
        return this.cMB;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void J(Context context, String str) {
        V(context, str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void L(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra("title", "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            apz();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void K(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        com.baidu.tbadk.widget.richText.c cVar;
        int a2;
        if (bVar != null) {
            com.baidu.tieba.pb.a.c pbData = this.cMF.getPbData();
            com.baidu.tbadk.widget.richText.a ae = ae(str, i);
            if (ae != null && (cVar = ae.GS().get(this.cNk)) != null) {
                bVar.cNG = new ArrayList<>();
                bVar.cNH = new ConcurrentHashMap<>();
                if (!cVar.GX().Hh()) {
                    bVar.cNJ = false;
                    String e = e(cVar);
                    bVar.cNG.add(e);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = c(cVar);
                    imageUrlData.originalSize = d(cVar);
                    imageUrlData.postId = ae.getPostId();
                    imageUrlData.mIsReserver = this.cMF.apZ();
                    imageUrlData.mIsSeeHost = this.cMF.getHostMode();
                    bVar.cNH.put(e, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aoE() != null) {
                            bVar.forumName = pbData.aoE().getName();
                            bVar.forumId = pbData.aoE().getId();
                        }
                        if (pbData.aoF() != null) {
                            bVar.threadId = pbData.aoF().getId();
                        }
                        bVar.cNI = pbData.aoK() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.cNJ = true;
                int size = pbData.aoG().size();
                this.cNl = false;
                bVar.index = -1;
                int i2 = i;
                for (int i3 = 0; i3 < size; i3++) {
                    com.baidu.tieba.tbadkCore.data.r rVar = pbData.aoG().get(i3);
                    com.baidu.tbadk.widget.richText.a aiT = rVar.aiT();
                    if (!dy.g(rVar)) {
                        a2 = a(aiT, ae, i2, i, bVar.cNG, bVar.cNH);
                    } else {
                        a2 = a(rVar, i2, bVar.cNG, bVar.cNH);
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.r> aMv = rVar.aMv();
                    i2 = a2;
                    for (int i4 = 0; i4 < aMv.size(); i4++) {
                        i2 = a(aMv.get(i4).aiT(), ae, i2, i, bVar.cNG, bVar.cNH);
                    }
                }
                if (bVar.cNG.size() > 0) {
                    bVar.lastId = bVar.cNG.get(bVar.cNG.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aoE() != null) {
                        bVar.forumName = pbData.aoE().getName();
                        bVar.forumId = pbData.aoE().getId();
                    }
                    if (pbData.aoF() != null) {
                        bVar.threadId = pbData.aoF().getId();
                    }
                    bVar.cNI = pbData.aoK() == 1;
                }
                bVar.index = i2;
            }
        }
    }

    private String c(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.GX() == null) {
            return null;
        }
        return cVar.GX().Hk();
    }

    private long d(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.GX() == null) {
            return 0L;
        }
        return cVar.GX().getOriginalSize();
    }

    private int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.f GX;
        if (aVar == aVar2) {
            this.cNl = true;
        }
        if (aVar != null) {
            int size = aVar.GS().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.GS().get(i6) == null || aVar.GS().get(i6).getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int width = aVar.GS().get(i6).GX().getWidth();
                    int height = aVar.GS().get(i6).GX().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.GS().get(i6).GX().Hh()) {
                        if (aVar == aVar2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.GS().get(i6);
                        String e = e(cVar);
                        arrayList.add(e);
                        if (!TextUtils.isEmpty(e) && cVar != null && (GX = cVar.GX()) != null) {
                            String Hi = GX.Hi();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Hi;
                            int i9 = this.mIsFromCDN ? 17 : 18;
                            imageUrlData.urlType = i9;
                            imageUrlData.urlType = i9;
                            imageUrlData.originalUrl = c(cVar);
                            imageUrlData.originalSize = d(cVar);
                            imageUrlData.postId = aVar.getPostId();
                            imageUrlData.threadId = com.baidu.adp.lib.h.b.c(this.cMF.getThreadID(), -1L);
                            imageUrlData.mIsReserver = this.cMF.apZ();
                            imageUrlData.mIsSeeHost = this.cMF.getHostMode();
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(e, imageUrlData);
                            }
                        }
                        if (!this.cNl) {
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

    private int a(com.baidu.tieba.tbadkCore.data.r rVar, int i, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        ArrayList<com.baidu.tieba.tbadkCore.data.j> aLX;
        if (rVar != null && arrayList != null && concurrentHashMap != null && (aLX = rVar.aMF().aLX()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == aLX.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = aLX.get(i3);
                if (jVar != null) {
                    String aMc = jVar.aMc();
                    if (!com.baidu.tbadk.core.util.aw.isEmpty(aMc)) {
                        arrayList.add(aMc);
                        if (!this.cNl) {
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
    public void d(com.baidu.tieba.tbadkCore.data.r rVar) {
        if (rVar != null) {
            boolean z = false;
            if (rVar.getId() != null && rVar.getId().equals(this.cMF.ts())) {
                z = true;
            }
            MarkData e = this.cMF.e(rVar);
            if (e != null) {
                this.cMK.arh();
                if (this.cMG != null) {
                    this.cMG.a(e);
                    if (!z) {
                        this.cMG.qi();
                    } else {
                        this.cMG.qh();
                    }
                }
            }
        }
    }

    private com.baidu.tbadk.widget.richText.a ae(String str, int i) {
        if (this.cMF == null || this.cMF.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.a.c pbData = this.cMF.getPbData();
        com.baidu.tbadk.widget.richText.a a2 = a(pbData.aoG(), str, i);
        if (a2 == null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.r> aoG = pbData.aoG();
            int size = aoG.size();
            for (int i2 = 0; i2 < size; i2++) {
                a2 = a(aoG.get(i2).aMv(), str, i);
                if (a2 != null) {
                    return a2;
                }
            }
            return a2;
        }
        return a2;
    }

    private long kF(String str) {
        ArrayList<com.baidu.tieba.tbadkCore.data.r> aoG;
        com.baidu.tieba.pb.a.c pbData = this.cMF.getPbData();
        if (pbData != null && (aoG = pbData.aoG()) != null && !aoG.isEmpty()) {
            Iterator<com.baidu.tieba.tbadkCore.data.r> it = aoG.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.r next = it.next();
                com.baidu.tieba.tbadkCore.data.h aMF = next.aMF();
                if (aMF != null && aMF.dWF) {
                    Iterator<com.baidu.tbadk.widget.richText.c> it2 = next.aiT().GS().iterator();
                    while (it2.hasNext()) {
                        com.baidu.tbadk.widget.richText.c next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.Hf().getLink().equals(str)) {
                            return aMF.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.data.r> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> GS;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a aiT = arrayList.get(i2).aiT();
            if (aiT != null && (GS = aiT.GS()) != null) {
                int size = GS.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (GS.get(i4) != null && GS.get(i4).getType() == 8) {
                        i3++;
                        if (GS.get(i4).GX().Hi().equals(str)) {
                            int width = GS.get(i4).GX().getWidth();
                            int height = GS.get(i4).GX().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.cNk = i4;
                            return aiT;
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

    private String e(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        com.baidu.tbadk.widget.richText.f GX = cVar.GX();
        if (GX != null) {
            if (!StringUtils.isNull(GX.Hg())) {
                return GX.Hg();
            }
            if (GX.getHeight() * GX.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (GX.getHeight() * GX.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (GX.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * GX.getHeight())));
            } else {
                float width = GX.getWidth() / GX.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.aw.aS(GX.getSrc()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void g(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.cMf = str;
            if (this.cMA == null) {
                apn();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.cMA.cf(1).setVisibility(8);
            } else {
                this.cMA.cf(1).setVisibility(0);
            }
            this.cMA.un();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.ben;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiX() {
        hideNetRefreshView(this.cMK.getView());
        showLoadingView(this.cMK.getView(), true);
        if (this.cMF.ET()) {
            this.cMK.arh();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oy() {
        if (this.ben != null) {
            this.ben.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pq() {
        if (this.cMF.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.a.c pbData = this.cMF.getPbData();
            String name = pbData.aoE().getName();
            String title = pbData.aoF().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.cMF.getThreadID() + "?share=9105&fr=share";
            String[] aE = pbData.aE(getPageContext().getPageActivity());
            String str2 = aE[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = aE[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (app() == 1) {
                if (pbData != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10399").aa(ImageViewerConfig.FORUM_ID, pbData.getForumId()).aa("tid", pbData.getThreadId()).aa("uid", currentAccount));
                }
            } else if (app() == 2 && pbData != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10406").aa(ImageViewerConfig.FORUM_ID, pbData.getForumId()).aa("tid", pbData.getThreadId()).aa("uid", currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(t.j.share_content_tpl), title, name, str3);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.linkUrl = str;
            fVar.amG = true;
            fVar.extData = this.cMF.getThreadID();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true, qJ());
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(t.j.share_tieba_qunzu, t.f.icon_unite_share_qunzu, new be(this));
            shareDialogConfig.addOutsideTextView(t.j.forum_friend, t.f.icon_unite_share_baf, new bf(this));
            shareDialogConfig.setCopyLinkListener(new bh(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private SparseArray<String> qJ() {
        if (this.bfX == null) {
            this.bfX = new SparseArray<>(7);
            this.bfX.put(2, "pb_wx_timeline");
            this.bfX.put(3, "pb_wx_friend");
            this.bfX.put(4, "pb_qq_zone");
            this.bfX.put(5, "pb_tencent_weibo");
            this.bfX.put(6, "pb_sina_weibo");
            this.bfX.put(7, "pb_renren");
        }
        return this.bfX;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<LinearLayout> Hw() {
        if (this.aFR == null) {
            this.aFR = new com.baidu.adp.lib.f.b<>(new bi(this), 15, 0);
        }
        return this.aFR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apA() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.pb.a.c pbData = this.cMF.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.so().isIfAddition();
            AdditionData aoM = pbData.aoM();
            boolean z3 = aoM == null ? false : isIfAddition;
            if (z3) {
                z = aoM.getAlreadyCount() != aoM.getTotalCount();
                if (!TextUtils.isEmpty(aoM.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.pb.main.b.c cVar = this.cMK.cQn;
            if (!z3 || !z) {
                z2 = false;
            }
            cVar.fL(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.cMK.ara() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10517").r("obj_locate", 2).aa(ImageViewerConfig.FORUM_ID, this.cMF.getPbData().getForumId()));
            } else {
                com.baidu.tbadk.core.data.ah aoF = this.cMF.getPbData().aoF();
                if (view != null) {
                    boolean z = aoF.getPraise() == null || aoF.getPraise().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.beD > 1000) {
                            this.beE = true;
                            T(view);
                        } else {
                            this.beE = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            e(view, this.beE);
                        } else {
                            d(view, this.beE);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        d(view, this.beE);
                    } else if (motionEvent.getAction() == 3) {
                        d(view, this.beE);
                    }
                }
            }
        }
        return false;
    }

    private void d(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), t.a.praise_animation_scale2));
            new Handler().postDelayed(new bj(this), 200L);
        }
    }

    private void e(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), t.a.praise_animation_scale3));
            new Handler().postDelayed(new bk(this), 600L);
        }
    }

    private void T(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), t.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void Pj() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, 11017)));
        } else if (aVar.ul() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.ul();
            int intValue = ((Integer) sparseArray.get(dz.cRP)).intValue();
            if (intValue == dz.cRQ) {
                if (!this.cMH.aNl()) {
                    this.cMK.are();
                    int intValue2 = ((Integer) sparseArray.get(t.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(t.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(t.g.tag_del_post_type)).intValue();
                    this.cMH.a(this.cMF.getPbData().aoE().getId(), this.cMF.getPbData().aoE().getName(), this.cMF.getPbData().aoF().getId(), (String) sparseArray.get(t.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == dz.cRR || intValue == dz.cRT) {
                this.cMF.kX(cm.cPa);
                if (intValue == dz.cRR) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == dz.cRS) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.cNo).rC()));
            }
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (sparseArray.get(t.g.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(t.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(t.g.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(t.g.tag_user_mute_thread_id);
        }
        if (sparseArray.get(t.g.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(t.g.tag_user_mute_post_id);
        }
        this.cMI.a(z, str, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
    }

    private boolean kG(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bi.ah(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.uO().getString("bubble_link", ""))) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(t.j.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void fm(boolean z) {
        this.cMS = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String apB() {
        ArrayList<com.baidu.tieba.tbadkCore.data.r> aoG;
        int o;
        if (this.cMF == null || this.cMF.getPbData() == null || this.cMF.getPbData().aoG() == null || (o = com.baidu.tbadk.core.util.x.o((aoG = this.cMF.getPbData().aoG()))) == 0) {
            return "";
        }
        int arm = this.cMK.arm();
        com.baidu.tieba.tbadkCore.data.r rVar = (com.baidu.tieba.tbadkCore.data.r) com.baidu.tbadk.core.util.x.b(aoG, arm);
        if (rVar == null || rVar.getAuthor() == null) {
            return "";
        }
        if (this.cMF.kL(rVar.getAuthor().getUserId())) {
            return rVar.getId();
        }
        for (int i = arm - 1; i != 0; i--) {
            com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) com.baidu.tbadk.core.util.x.b(aoG, i);
            if (rVar2 == null || rVar2.getAuthor() == null || rVar2.getAuthor().getUserId() == null) {
                break;
            } else if (this.cMF.kL(rVar2.getAuthor().getUserId())) {
                return rVar2.getId();
            }
        }
        for (int i2 = arm + 1; i2 < o; i2++) {
            com.baidu.tieba.tbadkCore.data.r rVar3 = (com.baidu.tieba.tbadkCore.data.r) com.baidu.tbadk.core.util.x.b(aoG, i2);
            if (rVar3 == null || rVar3.getAuthor() == null || rVar3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.cMF.kL(rVar3.getAuthor().getUserId())) {
                return rVar3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void M(Context context, String str) {
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.be.wt().c(getPageContext(), new String[]{str})) {
            com.baidu.tieba.pb.a.a(kF(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.cMF.getPbData().aoE().getId(), this.cMF.getPbData().aoE().getName(), this.cMF.getPbData().aoF().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, String str2, String str3, String str4) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.cE(getResources().getString(t.j.make_sure_hide));
        aVar.a(getResources().getString(t.j.alert_yes_button), new bl(this, j, str, str2, str3, str4));
        aVar.b(getResources().getString(t.j.alert_no_button), new bm(this, j, str, str2, str3, str4));
        aVar.ak(false);
        aVar.b(getPageContext());
        aVar.uj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b kH(String str) {
        String str2;
        if (this.cMF.getPbData() == null || this.cMF.getPbData().aoG() == null || this.cMF.getPbData().aoG().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i < this.cMF.getPbData().aoG().size()) {
                if (str.equals(this.cMF.getPbData().aoG().get(i).getId())) {
                    break;
                }
                i++;
            } else {
                i = 0;
                break;
            }
        }
        com.baidu.tieba.tbadkCore.data.r rVar = this.cMF.getPbData().aoG().get(i);
        if (rVar.aiT() == null || rVar.aiT().GS() == null) {
            return null;
        }
        Iterator<com.baidu.tbadk.widget.richText.c> it = rVar.aiT().GS().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.GX() != null) {
                    str2 = next.GX().Hi();
                }
            }
        }
        a(str2, 0, bVar);
        return bVar;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.cMs) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.cMs = false;
            return;
        }
        super.enterExitAnimation();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.cMs) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.cMs = false;
            return;
        }
        super.closeAnimation();
    }

    public boolean apC() {
        return this.cMV;
    }

    public void fn(boolean z) {
        this.cMV = z;
    }
}
