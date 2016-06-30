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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.ReadPbServiceConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d.c;
import com.baidu.tieba.pb.pb.main.a.f;
import com.baidu.tieba.pb.pb.main.cp;
import com.baidu.tieba.pb.pb.main.cs;
import com.baidu.tieba.pb.pb.main.dg;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.f.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.togetherhi.TogetherHiLivingView;
import com.baidu.tieba.u;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, com.baidu.tbadk.widget.richText.m {
    private com.baidu.adp.lib.f.b<ImageView> aFj;
    private com.baidu.adp.lib.f.b<TextView> aFk;
    private com.baidu.adp.lib.f.b<View> aFl;
    private com.baidu.adp.lib.f.b<View> aFm;
    private com.baidu.adp.lib.f.b<LinearLayout> aFn;
    private com.baidu.adp.lib.f.b<GifView> aFo;
    private com.baidu.adp.lib.f.b<View> aFp;
    private com.baidu.adp.lib.f.b<TbImageView> adT;
    private VoiceManager bBm;
    private com.baidu.tieba.d.c bCX;
    private com.baidu.tbadk.e.a bDd;
    private com.baidu.tbadk.core.dialog.a dOC;
    private com.baidu.tieba.pb.pb.main.b dOI;
    private dn dOR;
    private boolean dOV;
    private com.baidu.tieba.tbadkCore.data.f dOW;
    private com.baidu.tbadk.editortools.d.e dOX;
    private String dOd;
    private com.baidu.tieba.pb.pb.main.a.f dOx;
    private String dPD;
    private com.baidu.tbadk.core.data.l dPE;
    private com.baidu.adp.base.h dPa;
    private com.baidu.tbadk.core.view.h dPb;
    private BdUniqueId dPc;
    private boolean dPs;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean dOw = false;
    private boolean dOy = false;
    private boolean dOz = false;
    private boolean dyP = false;
    private int dOA = 0;
    private com.baidu.tbadk.core.dialog.c dOB = null;
    private long btl = -1;
    private long ayu = 0;
    private long dOD = 0;
    private long createTime = 0;
    private long aym = 0;
    private boolean dOE = false;
    private com.baidu.tbadk.performanceLog.e dOF = null;
    private long dOG = 0;
    private boolean dOH = false;
    private String asq = null;
    private String dOJ = "";
    private boolean dOK = true;
    private boolean dOL = false;
    private String source = "";
    private PbInterviewStatusView.a dOM = new i(this);
    private final Handler mHandler = new Handler(new t(this));
    private dg dOf = null;
    private com.baidu.tbadk.baseEditMark.a dvH = null;
    private com.baidu.tieba.tbadkCore.f.a dON = null;
    private es dOO = null;
    public final com.baidu.tieba.pb.pb.main.a.a dOP = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean dOQ = false;
    private boolean dOS = false;
    private boolean dOT = false;
    private boolean dOU = false;
    private boolean bCo = false;
    private boolean dOY = false;
    private com.baidu.tbadk.editortools.d.c asu = new ae(this);
    private boolean dOZ = false;
    private int cuW = -1;
    private final CustomMessageListener dPd = new ap(this, CmdConfigCustom.PB_RESET_EDITOR_TOOL);
    private CustomMessageListener bVf = new ba(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener bBl = new bl(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener diu = new bu(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener dPe = new cc(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener aGe = new cd(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
    private CustomMessageListener cGb = new j(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private HttpMessageListener bbn = new k(this, CmdConfigHttp.PB_ECOMM_RECOMMEND_HTTP_CMD);
    private cp.a dPf = new l(this);
    private View.OnClickListener dhS = new m(this);
    private CustomMessageListener dPg = new n(this, CmdConfigCustom.CMD_SEND_GIFT_SUCCESS);
    private boolean bBd = false;
    private com.baidu.tieba.tbadkCore.aj bBp = new com.baidu.tieba.tbadkCore.aj(getPageContext(), new o(this));
    private long bBB = 0;
    private boolean bBC = true;
    private f.a dPh = new p(this);
    private CustomMessageListener bbo = new q(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener dPi = new r(this, CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED);
    private com.baidu.tieba.pb.a.d dME = new com.baidu.tieba.pb.a.d(new s(this));
    private CustomMessageListener dPj = new u(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener dPk = new v(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener dPl = new w(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    public a.b dHf = new x(this);
    public final View.OnClickListener bFi = new y(this);
    private final a.d asA = new z(this);
    private final dg.a dPm = new aa(this);
    private CustomMessageListener dPn = new ab(this, CmdConfigCustom.CMD_WX_SHARE_SUCCESS);
    private CustomMessageListener dPo = new ac(this, CmdConfigCustom.CMD_TTS_OPTION_PB);
    private final a.InterfaceC0032a dPp = new ad(this);
    private final AbsListView.OnScrollListener yV = new af(this);
    private final com.baidu.adp.base.g dPq = new ag(this);
    private final c dPr = new ah(this);
    private final t.b aOb = new ai(this);
    private final BdListView.e dPt = new aj(this);
    private int dPu = 0;
    private final TbRichTextView.d aFF = new ak(this);
    boolean dPv = false;
    com.baidu.tieba.tbadkCore.data.s dPw = null;
    private final c.b dPx = new al(this);
    private final View.OnLongClickListener aku = new am(this);
    private final NoNetworkView.a bAH = new an(this);
    public View.OnTouchListener aGb = new ao(this);
    private c.InterfaceC0054c aYC = new aq(this);
    private final c.a dPy = new ar(this);
    private String dPz = null;
    private final cs.a dPA = new as(this);
    private int dPB = -1;
    private int dPC = -1;

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> dPT;
        public ConcurrentHashMap<String, ImageUrlData> dPU;
        public boolean dPW;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean dPV = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes.dex */
    public interface c {
        void hu(boolean z);
    }

    public void hl(boolean z) {
        this.dOH = z;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.d.e aEz() {
        return this.dOX;
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        if (mVar.aEe() != null) {
            String id = mVar.aEe().getId();
            ArrayList<com.baidu.tieba.tbadkCore.data.s> aDP = this.dOf.getPbData().aDP();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aDP.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.s sVar = aDP.get(i2);
                if (sVar.getId() == null || !sVar.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> aEi = mVar.aEi();
                    sVar.qC(mVar.getTotalCount());
                    if (sVar.bci() != null) {
                        sVar.bci().clear();
                        sVar.bci().addAll(aEi);
                    }
                }
            }
            this.dOO.j(this.dOf.getPbData());
        }
    }

    public void aEA() {
        com.baidu.tieba.pb.data.h pbData;
        com.baidu.tbadk.core.data.az aDO;
        if (!this.bBd) {
            if (!com.baidu.adp.lib.util.k.fI()) {
                showToast(u.j.no_network_guide);
            } else if (this.bBC) {
                this.bBd = true;
                if (this.dOf != null && (pbData = this.dOf.getPbData()) != null && (aDO = pbData.aDO()) != null) {
                    int isLike = aDO.getPraise() == null ? 0 : aDO.getPraise().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10796").ab("tid", aDO.getId()));
                    }
                    if (this.bBp != null) {
                        this.bBp.a(aDO.qV(), aDO.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        String string;
        if ((sparseArray.get(u.g.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(u.g.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(u.g.tag_check_mute_from) instanceof Integer)) {
            String str = (String) sparseArray.get(u.g.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(u.g.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(u.g.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
                cVar.bP(u.j.operation);
                int i = -1;
                if (sparseArray.get(u.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(u.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(u.j.delete);
                    if (z) {
                        string = getResources().getString(u.j.un_mute);
                    } else {
                        string = getResources().getString(u.j.mute);
                    }
                    strArr[1] = string;
                    cVar.a(strArr, new at(this, sparseArray, z, str2, str));
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(u.j.un_mute) : getResources().getString(u.j.mute);
                    cVar.a(strArr2, new au(this, sparseArray, z, str2, str));
                }
                cVar.d(getPageContext()).rW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hi(int i) {
        com.baidu.tbadk.core.data.az aDO;
        String sb;
        String D;
        if (this.dOf != null && this.dOf.getPbData() != null && (aDO = this.dOf.getPbData().aDO()) != null) {
            if (i == 1) {
                PraiseData praise = aDO.getPraise();
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
                        aDO.setPraise(praiseData);
                    } else {
                        aDO.getPraise().getUser().add(0, metaData);
                        aDO.getPraise().setNum(aDO.getPraise().getNum() + 1);
                        aDO.getPraise().setIsLike(i);
                    }
                }
                if (aDO.getPraise() != null) {
                    if (aDO.getPraise().getNum() < 1) {
                        D = getResources().getString(u.j.frs_item_praise_text);
                    } else {
                        D = com.baidu.tbadk.core.util.ba.D(aDO.getPraise().getNum());
                    }
                    this.dOO.I(D, true);
                }
            } else if (aDO.getPraise() != null) {
                aDO.getPraise().setIsLike(i);
                aDO.getPraise().setNum(aDO.getPraise().getNum() - 1);
                ArrayList<MetaData> user = aDO.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aDO.getPraise().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aDO.getPraise().getNum() < 1) {
                    sb = getResources().getString(u.j.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(aDO.getPraise().getNum())).toString();
                }
                this.dOO.I(sb, false);
            }
            if (this.dOf.aFM()) {
                this.dOO.aHh().notifyDataSetChanged();
            } else {
                this.dOO.k(this.dOf.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.tieba.tbadkCore.data.s a2;
        if (this.dOf != null && this.dOf.getPbData() != null && (a2 = com.baidu.tieba.pb.data.i.a(this.dOf.getPbData(), this.dOf.aFM(), this.dOf.aGb())) != null) {
            com.baidu.tieba.pb.data.i.a(a2, updateAttentionMessage);
            if (this.dOO != null && this.dOf != null) {
                this.dOO.c(this.dOf.getPbData(), this.dOf.aFM(), this.dOf.aGb());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bDd == null) {
                this.bDd = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bDd.ap(updateAttentionMessage.getData().toUid, this.dOf.getPbData().getForumId());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.dOf.q(bundle);
        if (this.bBm != null) {
            this.bBm.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.dOX.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.dPa = getPageContext();
        Intent intent = getIntent();
        if (intent != null) {
            this.btl = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.dOJ = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.dOJ)) {
                this.dOy = true;
            }
            this.dPB = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.dPC = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.dPD = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            if (aEV()) {
                setUseStyleImmersiveSticky(false);
            }
            this.dOT = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ba.isEmpty(this.source) ? "" : this.source;
        } else {
            this.btl = System.currentTimeMillis();
        }
        this.dOD = System.currentTimeMillis();
        this.aym = this.dOD - this.btl;
        super.onCreate(bundle);
        this.dOA = 0;
        r(bundle);
        nl();
        if (intent != null && this.dOO != null) {
            this.dOO.dTn = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
        }
        this.bBm = new VoiceManager();
        this.bBm.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.d.n nVar = new com.baidu.tbadk.editortools.d.n();
        nVar.setForumName(this.dOf.aFL());
        if (this.dOf.getPbData() != null && this.dOf.getPbData().aDN() != null) {
            nVar.setForumId(this.dOf.getPbData().aDN().getId());
        }
        nVar.setFrom("pb");
        nVar.a(this.dOf);
        this.dOX = (com.baidu.tbadk.editortools.d.e) nVar.af(getActivity());
        this.dOX.d(this);
        this.dOX.a(this.asA);
        this.dOX.a(this.asu);
        this.dOX.a(this, bundle);
        this.dOX.Bl().c(new com.baidu.tbadk.editortools.z(getActivity()));
        this.dOX.Bl().bu(true);
        hn(true);
        this.dOO.setEditorTools(this.dOX.Bl());
        this.dOX.a(this.dOf.aFS(), this.dOf.getThreadID(), this.dOf.aFI());
        registerListener(this.bBl);
        registerListener(this.bbn);
        if (!this.dOf.aFP()) {
            this.dOX.fC(this.dOf.getThreadID());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.dOD;
        registerListener(this.bVf);
        registerListener(this.diu);
        registerListener(this.dPe);
        registerListener(this.aGe);
        registerListener(this.dPd);
        this.dOW = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.eXd);
        this.dOW.bbJ();
        registerListener(this.dPg);
        registerListener(this.bbo);
        if (this.dOf != null) {
            this.dOf.aGd();
        }
        if (TbadkCoreApplication.m9getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.dPi);
        registerListener(this.dPo);
        registerListener(this.dPn);
        this.dOI = new com.baidu.tieba.pb.pb.main.b(this.dOf, this);
        if (this.dOO != null && this.dOO.aHT() != null && this.dOO.aHU() != null) {
            this.dOx = new com.baidu.tieba.pb.pb.main.a.f(getActivity(), this.dOO.aHT(), this.dOO.aHU());
            this.dOx.a(this.dPh);
            this.dOx.hW(this.dOO.aHZ());
        }
        if (aEV() && this.dOO != null && this.dOO.aHU() != null) {
            this.dOO.aHU().setVisibility(8);
        }
        this.dPb = new com.baidu.tbadk.core.view.h();
        this.dPb.abh = 1000L;
        registerListener(this.dPl);
        registerListener(this.dPj);
        registerListener(this.dPk);
        this.dPc = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.dPc;
        userMuteAddAndDelCustomMessage.setTag(this.dPc);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.dPc;
        userMuteCheckCustomMessage.setTag(this.dPc);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public String aEB() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.f aEC() {
        return this.dOx;
    }

    private void hn(boolean z) {
        this.dOX.bx(z);
        this.dOX.by(z);
        this.dOX.bz(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
        if (this.dOX != null && this.dOX.Bl() != null) {
            this.dOX.Bl().Bx();
        }
        if (this.dOO != null) {
            this.dOO.Bx();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bBm != null) {
            this.bBm.onStart(getPageContext());
        }
    }

    public es aED() {
        return this.dOO;
    }

    public dg aEE() {
        return this.dOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.m9getInst().isReadMenuDialogOnTop()) {
            this.dOz = false;
        } else {
            this.dOz = true;
        }
        super.onPause();
        if (this.dOO.aGQ() != null && this.dOO.aGQ().aEw() != null) {
            this.dOO.aGQ().aEw().onPause();
        }
        BdListView listView = getListView();
        this.dOA = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.dOA == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.bBm != null) {
            this.bBm.onPause(getPageContext());
        }
        if (this.dOO != null) {
            this.dOO.onPause();
        }
        if (!this.dOf.aFP()) {
            this.dOX.fB(this.dOf.getThreadID());
        }
        if (this.dOf != null) {
            this.dOf.aGe();
        }
        MessageManager.getInstance().unRegisterListener(this.cGb);
        aiV();
        MessageManager.getInstance().unRegisterListener(this.dPj);
        MessageManager.getInstance().unRegisterListener(this.dPk);
        MessageManager.getInstance().unRegisterListener(this.dPl);
    }

    private boolean aEF() {
        com.baidu.tieba.tbadkCore.data.s a2 = com.baidu.tieba.pb.data.i.a(this.dOf.getPbData(), this.dOf.aFM(), this.dOf.aGb());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.dOz = false;
        super.onResume();
        if (this.dOL) {
            this.dOL = false;
            aFb();
        }
        if (this.dOO.aGQ() != null && this.dOO.aGQ().aEw() != null) {
            this.dOO.aGQ().aEw().onResume();
        }
        if (aEF()) {
            this.dOG = System.currentTimeMillis();
        } else {
            this.dOG = -1L;
        }
        if (this.dOO != null && this.dOO.getView() != null) {
            if (!this.dyP) {
                aES();
            } else {
                hideLoadingView(this.dOO.getView());
            }
            this.dOO.onResume();
        }
        if (this.dOA == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.dOO != null) {
            noNetworkView = this.dOO.aGR();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.fr()) {
            noNetworkView.aC(false);
        }
        if (this.bBm != null) {
            this.bBm.onResume(getPageContext());
        }
        registerListener(this.cGb);
        this.dOV = false;
        aFa();
        registerListener(this.dPj);
        registerListener(this.dPk);
        registerListener(this.dPl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.dOO.hI(z);
        if (this.dOR != null) {
            this.dOR.hA(z);
        }
        if (z && this.dOV) {
            this.dOO.aHo();
            this.dOf.hw(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dOG > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10804").ab("obj_duration", new StringBuilder(String.valueOf(System.currentTimeMillis() - this.dOG)).toString()));
            this.dOG = 0L;
        }
        if (this.dOX != null && this.dOX.Bl() != null && this.dOX.Bl().getVisibility() != 0) {
            this.dOX.BZ();
        }
        if (this.dOO.dTq != null && !this.dOO.dTq.aIf()) {
            this.dOO.dTq.avw();
        }
        if (this.dOf != null && this.dOf.getPbData() != null && this.dOf.getPbData().aDN() != null && this.dOf.getPbData().aDO() != null) {
            com.baidu.tbadk.distribute.a.AU().b(getPageContext().getPageActivity(), "pb", this.dOf.getPbData().aDN().getId(), com.baidu.adp.lib.h.b.c(this.dOf.getPbData().aDO().getId(), 0L));
        }
        if (this.bBm != null) {
            this.bBm.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dOI != null) {
            this.dOI.destroy();
        }
        if (this.dOS && this.dOf != null) {
            a(this.dOf.getPbData(), -2, 0, false, false);
        }
        if (!this.dOE && this.dOO != null) {
            this.dOE = true;
            this.dOO.aHI();
        }
        if (this.dOf != null) {
            this.dOf.cancelLoadData();
            this.dOf.destory();
        }
        if (this.dOX != null) {
            this.dOX.onDestroy();
        }
        if (this.dON != null) {
            this.dON.cancelLoadData();
        }
        if (this.dOO != null) {
            this.dOO.onDestroy();
            if (this.dOO.dTq != null) {
                this.dOO.dTq.avw();
            }
        }
        if (this.dOF != null) {
            this.dOF.onDestroy();
        }
        if (this.dOx != null) {
            this.dOx.Xh();
        }
        super.onDestroy();
        if (this.bBm != null) {
            this.bBm.onDestory(getPageContext());
        }
        if (this.bDd != null) {
            this.bDd.destory();
        }
        this.dOO.avf();
        MessageManager.getInstance().unRegisterListener(this.dPj);
        MessageManager.getInstance().unRegisterListener(this.dPk);
        MessageManager.getInstance().unRegisterListener(this.dPl);
        MessageManager.getInstance().unRegisterListener(this.dPc);
        this.dPa = null;
        this.dPb = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dOO.onChangeSkinType(i);
        if (this.dOX != null && this.dOX.Bl() != null) {
            this.dOX.Bl().onChangeSkinType(i);
        }
        if (this.dOO.aGR() != null) {
            this.dOO.aGR().onChangeSkinType(getPageContext(), i);
        }
    }

    private void nl() {
        this.dOO = new es(this, this.bFi, this.dME);
        this.bCX = new com.baidu.tieba.d.c(getActivity());
        this.bCX.a(this.dPy);
        this.bCX.a(this.aYC);
        this.dOO.setOnScrollListener(this.yV);
        this.dOO.c(this.dPt);
        this.dOO.a(this.aOb);
        this.dOO.hg(com.baidu.tbadk.core.l.nW().oc());
        this.dOO.hh(com.baidu.tbadk.core.l.nW().nY());
        this.dOO.setOnImageClickListener(this.aFF);
        this.dOO.a(this.aku);
        this.dOO.g(this.bAH);
        this.dOO.a(this.dPr);
        this.dOO.hI(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aV(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(u.g.tag_clip_board);
            if (obj instanceof com.baidu.tieba.tbadkCore.data.s) {
                com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) obj;
                if (TextUtils.isEmpty(sVar.getBimg_url()) || !com.baidu.tbadk.core.l.nW().oc()) {
                    return false;
                }
                return nu(sVar.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.dOO != null) {
            if (z && (!this.dyP || this.dOZ)) {
                aES();
            } else {
                hideLoadingView(this.dOO.getView());
            }
            this.dOZ = false;
        }
    }

    private void aEG() {
        if (this.dOB == null) {
            this.dOB = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.dOB.a(new String[]{getPageContext().getString(u.j.call_phone), getPageContext().getString(u.j.sms_phone), getPageContext().getString(u.j.search_in_baidu)}, new av(this)).bQ(c.a.Sz).bR(17).d(getPageContext());
        }
    }

    private void r(Bundle bundle) {
        this.dOf = new dg(this);
        this.dOf.a(this.dPm);
        if (this.dOf.aGj() != null) {
            this.dOf.aGj().a(this.dPA);
        }
        if (this.dOf.aGi() != null) {
            this.dOf.aGi().a(this.dPf);
        }
        if (bundle != null) {
            this.dOf.initWithBundle(bundle);
        } else {
            this.dOf.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra("request_code", -1) == 18003) {
            this.dOf.hz(true);
        }
        el.aGM().H(this.dOf.aFK(), this.dOf.getIsFromMark());
        if (StringUtils.isNull(this.dOf.getThreadID())) {
            finish();
        } else {
            this.dOf.DH();
        }
    }

    private void initData(Bundle bundle) {
        this.dvH = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dvH != null) {
            this.dvH.a(this.dPp);
        }
        this.dON = new com.baidu.tieba.tbadkCore.f.a(this);
        this.dON.setLoadDataCallBack(this.dPq);
        this.dOO.a(new aw(this));
        this.bBp.setUniqueId(getUniqueId());
        this.bBp.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.dOO.asK();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.h.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.h.b.c((String) sparseArray.get(u.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.dPc;
        userMuteCheckCustomMessage.setTag(this.dPc);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEH() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.bL(u.j.go_setting_float_window_permission);
        aVar.bM(u.j.step_to_setting_float_permission);
        aVar.a(u.j.go_and_setting, new ax(this));
        aVar.b(u.j.cancel, new ay(this));
        aVar.b(getPageContext()).rT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        com.baidu.tieba.tbadkCore.data.s sVar;
        ArrayList<IconData> arrayList;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(u.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.s) && (sVar = (com.baidu.tieba.tbadkCore.data.s) sparseArray.get(u.g.tag_clip_board)) != null && this.dOf != null && this.dOf.getPbData() != null && sVar.bcm() > 1) {
            String threadID = this.dOf.getThreadID();
            String id = sVar.getId();
            int i = 0;
            if (this.dOf.getPbData() != null) {
                i = this.dOf.getPbData().aDU();
            }
            b nv = nv(id);
            if (nv != null) {
                SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
                SmallTailInfo aIV = sVar.aIV();
                AntiData pt = this.dOf.getPbData().pt();
                if (sVar.getAuthor() != null) {
                    arrayList = sVar.getAuthor().getIconInfo();
                } else {
                    arrayList = null;
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i, aIV, pt, false, arrayList).addBigImageData(nv.dPT, nv.dPU, nv.dPV, nv.index)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aEI() {
        if (this.dOf.getPbData() == null || this.dOf.getPbData().aDO() == null) {
            return -1;
        }
        return this.dOf.getPbData().aDO().rd();
    }

    private boolean ho(boolean z) {
        if (this.dOf == null || this.dOf.getPbData() == null) {
            return false;
        }
        return (this.dOf.getPbData().aDU() != 0) && !z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hp(boolean z) {
        if (this.dOf == null || this.dOf.getPbData() == null) {
            return false;
        }
        return ((this.dOf.getPbData().aDU() != 0) || this.dOf.getPbData().aDO() == null || this.dOf.getPbData().aDO().getAuthor() == null || TextUtils.equals(this.dOf.getPbData().aDO().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void aEJ() {
        if (this.dOf != null && this.dOf.getPbData() != null && this.dOf.getPbData().aDO() != null && this.dOf.getPbData().aDO().getAuthor() != null) {
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.dOf.getPbData().aDO().getAuthor().getUserId());
            boolean hp = hp(equals);
            boolean ho = ho(equals);
            this.dOO.dTq.c(this.dOf.aFM(), this.dvH != null ? this.dvH.mK() : false, hp, equals && this.dOO.aHw(), ho);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.tbadkCore.data.s sVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (sVar = (com.baidu.tieba.tbadkCore.data.s) sparseArray.get(u.g.tag_clip_board)) != null) {
            c(sVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.h hVar, int i, int i2, boolean z, boolean z2) {
        if (hVar != null && this.dOf != null) {
            ef efVar = new ef(getUniqueId());
            efVar.pbData = hVar;
            efVar.threadId = this.dOf.getThreadID();
            efVar.postId = this.dOf.getPostId();
            efVar.dST = i;
            efVar.dSU = i2;
            efVar.dSS = this.dOf.getHostMode();
            efVar.dMr = this.dOf.mK();
            efVar.isSquence = this.dOf.aFM();
            efVar.loadType = this.dOf.aGg();
            efVar.dSV = z;
            efVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, efVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, boolean z2) {
        if (hVar != null && this.dOf != null) {
            ef efVar = new ef(getUniqueId());
            efVar.pbData = hVar;
            efVar.threadId = this.dOf.getThreadID();
            efVar.postId = this.dOf.getPostId();
            efVar.dST = i;
            efVar.dSS = this.dOf.getHostMode();
            efVar.dMr = this.dOf.mK();
            efVar.isSquence = this.dOf.aFM();
            efVar.loadType = this.dOf.aGg();
            efVar.dSV = z;
            efVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, efVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        OQ();
    }

    public void a(boolean z, MarkData markData) {
        this.dOO.aHq();
        this.dOf.hy(z);
        if (this.dvH != null) {
            this.dvH.Z(z);
            if (markData != null) {
                this.dvH.a(markData);
            }
        }
        if (this.dOf.mK()) {
            aEP();
        } else {
            this.dOO.j(this.dOf.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ng(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ns(String str) {
        if (!StringUtils.isNull(str) && this.dOf != null) {
            String threadID = this.dOf.getThreadID();
            String id = this.dOf.getPbData().aDN().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(u.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData)) {
                if (!this.dOf.aFP()) {
                    antiData.setBlock_forum_name(this.dOf.getPbData().aDN().getName());
                    antiData.setBlock_forum_id(this.dOf.getPbData().aDN().getId());
                    antiData.setUser_name(this.dOf.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.dOf.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.qL(i)) {
            AntiHelper.O(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            fH(str);
        } else {
            this.dOO.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        int i = 0;
        if (bVar != null) {
            this.dOO.a(0, bVar.rg, bVar.eZR, true);
            if (bVar.rg) {
                if (bVar.eZP == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> aDP = this.dOf.getPbData().aDP();
                    int size = aDP.size();
                    while (true) {
                        if (i < size) {
                            if (!bVar.mPostId.equals(aDP.get(i).getId())) {
                                i++;
                            } else {
                                aDP.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.dOO.j(this.dOf.getPbData());
                } else if (bVar.eZP == 0) {
                    aEK();
                } else if (bVar.eZP == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> aDP2 = this.dOf.getPbData().aDP();
                    int size2 = aDP2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < aDP2.get(i2).bci().size()) {
                                if (!bVar.mPostId.equals(aDP2.get(i2).bci().get(i3).getId())) {
                                    i3++;
                                } else {
                                    aDP2.get(i2).bci().remove(i3);
                                    aDP2.get(i2).bck();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData aDX = this.dOf.getPbData().aDX();
                        com.baidu.tieba.tbadkCore.data.s sVar = aDP2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.data.s> bcl = sVar.bcl();
                        int size3 = bcl.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!bVar.mPostId.equals(aDP2.get(i2).bcl().get(i4).getId())) {
                                    i4++;
                                } else {
                                    bcl.remove(i4);
                                    aDX.decreaseAlreadyCount();
                                    if (sVar.bcs() > bcl.size()) {
                                        sVar.qE(bcl.size());
                                    }
                                    if (bcl.size() > 0) {
                                        com.baidu.tieba.tbadkCore.data.s sVar2 = bcl.get(bcl.size() - 1);
                                        aDX.setLastAdditionTime(sVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a auL = sVar2.auL();
                                        String str = "";
                                        if (auL != null) {
                                            str = auL.toString();
                                        }
                                        aDX.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a auL2 = sVar.auL();
                                        String str2 = "";
                                        if (auL2 != null) {
                                            str2 = auL2.toString();
                                        }
                                        aDX.setLastAdditionContent(str2);
                                    }
                                    aET();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.dOO.j(this.dOf.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, a.f fVar) {
        if (fVar != null) {
            this.dOO.a(this.dON.getLoadDataMode(), fVar.rg, fVar.eZR, true);
            if (fVar.rg) {
                this.dOQ = true;
                if (i == 2) {
                    this.dOf.getPbData().aDO().bJ(1);
                    this.dOf.setIsGood(1);
                } else if (i == 3) {
                    this.dOf.getPbData().aDO().bJ(0);
                    this.dOf.setIsGood(0);
                } else if (i == 4) {
                    this.dOf.getPbData().aDO().bI(1);
                    this.dOf.nl(1);
                } else if (i == 5) {
                    this.dOf.getPbData().aDO().bI(0);
                    this.dOf.nl(0);
                }
                this.dOO.a(this.dOf.getPbData(), this.dOf.aFM(), true);
            }
        }
    }

    private void aEK() {
        if (this.dOf.aFN()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.dOf.getThreadID());
            setResult(-1, intent);
        }
        if (aEQ()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEL() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dOO != null) {
            this.dOO.avf();
        }
        if (this.dOf != null && this.dOf.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.dOf.getPbData().aDO().getId();
            historyMessage.forumName = this.dOf.getPbData().aDN().getName();
            historyMessage.threadName = this.dOf.getPbData().aDO().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.data.s> aDP = this.dOf.getPbData().aDP();
            int aHt = this.dOO != null ? this.dOO.aHt() : 0;
            if (aDP != null && aHt >= 0 && aHt < aDP.size()) {
                historyMessage.postID = aDP.get(aHt).getId();
            }
            historyMessage.isHostOnly = this.dOf.getHostMode();
            historyMessage.isSquence = this.dOf.aFM();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.dOX != null) {
            this.dOX.onDestroy();
        }
        if (this.dOf != null && this.dOf.aFN()) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.dOf.getThreadID());
            if (this.dOQ) {
                intent.putExtra("type", 2);
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.dOf.auW());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.dOf.getIsGood());
            }
            setResult(-1, intent);
        }
        if (aEQ()) {
            if (this.dOf != null && this.dOO != null && this.dOO.LO() != null) {
                com.baidu.tieba.pb.data.h pbData = this.dOf.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.m9getInst().getDefaultBubble());
                    }
                    if (!pbData.aDT()) {
                        el.aGM().a(this.dOf.getPbData(), this.dOO.LO().onSaveInstanceState(), this.dOf.aFM(), this.dOf.getHostMode());
                    }
                }
            } else {
                el.aGM().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.dOO != null && this.dOO.aFE()) {
                    this.dOO.aFG();
                    return true;
                }
                finish();
                break;
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nh(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(u.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.dOX.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aEO();
                    return;
                case 13008:
                    el.aGM().reset();
                    this.mHandler.postDelayed(new az(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.dOf != null) {
                        a(aEN(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    v(intent);
                    return;
                case 24006:
                    u(intent);
                    return;
                case 24007:
                    if (aEI() == 1) {
                        aEM();
                        return;
                    }
                    return;
                case 24008:
                    this.dOO.hm(false);
                    if (this.dOf.getPbData() != null && this.dOf.getPbData().aDO() != null && this.dOf.getPbData().aDO().qY() != null) {
                        this.dOf.getPbData().aDO().qY().setStatus(2);
                        break;
                    }
                    break;
                case 25001:
                    break;
                default:
                    return;
            }
            if (this.dOI != null) {
                this.dOI.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aED() != null && aEz() != null && aED().aGU() && com.baidu.tbadk.editortools.d.b.BM().getStatus() == 1) {
                    com.baidu.tbadk.editortools.d.b.BM().setStatus(0);
                    if (this.dOO != null) {
                        this.dOO.aGT();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEM() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.dOf.getPbData() != null && this.dOf.getPbData().aDO() != null && this.dOf.getPbData().aDO().qQ() != null && this.dOf.getPbData().aDO().qQ().size() > 0 && this.dOf.getPbData().aDO().qQ().get(0) != null) {
            this.mAwardActId = this.dOf.getPbData().aDO().qQ().get(0).oq();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.h.b.c(this.dOf.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void u(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra("key_action", 0)) {
                case 1:
                    aaO();
                    return;
                case 2:
                    this.dOO.aHe();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aEN() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] aM = this.dOf.getPbData().aM(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.data.s aGV = this.dOO.aGV();
        String str = "";
        if (aGV != null) {
            str = aGV.getId();
            String aW = aGV.aW(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(aW)) {
                aM[1] = aW;
            }
        }
        String qV = this.dOf.getPbData().aDO().qV();
        if (qV != null && qV.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(aM[1]);
        shareFromPBMsgData.setImageUrl(aM[0]);
        shareFromPBMsgData.setForumName(this.dOf.getPbData().aDN().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.dOf.getPbData().aDO().getId());
        shareFromPBMsgData.setTitle(this.dOf.getPbData().aDO().getTitle());
        return shareFromPBMsgData;
    }

    private void v(Intent intent) {
        a(aEN(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.dOf != null && this.dOf.getPbData() != null && this.dOf.getPbData().aDO() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gh ghVar = new gh(getPageContext().getPageActivity());
            ghVar.setData(shareFromPBMsgData);
            aVar.bO(1);
            aVar.y(ghVar);
            aVar.a(u.j.share, new bb(this, ghVar, j, str, str2, shareFromPBMsgData));
            aVar.b(u.j.alert_no_button, new bc(this, ghVar));
            aVar.ao(true);
            aVar.b(getPageContext()).rT();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                ghVar.A(shareFromPBMsgData.getImageUrl(), this.dOf.getPbData().aDV() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.dOf != null && this.dOf.getPbData() != null && this.dOf.getPbData().aDO() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gh ghVar = new gh(getPageContext().getPageActivity());
            ghVar.setData(shareFromPBMsgData);
            aVar.bO(1);
            aVar.y(ghVar);
            aVar.a(u.j.share, new bd(this, ghVar, i, str, j, shareFromPBMsgData));
            aVar.b(u.j.alert_no_button, new be(this, ghVar));
            aVar.ao(true);
            aVar.b(getPageContext()).rT();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                ghVar.A(shareFromPBMsgData.getImageUrl(), this.dOf.getPbData().aDV() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEO() {
        MarkData ns;
        if (this.dvH != null && (ns = this.dOf.ns(this.dOO.aHu())) != null) {
            if (!ns.isApp() || (ns = this.dOf.ns(this.dOO.aHu() + 1)) != null) {
                this.dOO.aHn();
                this.dvH.a(ns);
                if (!this.dvH.mK()) {
                    this.dvH.mM();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.dvH.mL();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEP() {
        com.baidu.tieba.pb.data.h pbData = this.dOf.getPbData();
        this.dOf.hy(true);
        pbData.np(this.dvH.mJ());
        this.dOO.j(pbData);
    }

    private boolean aEQ() {
        if (this.dOf == null) {
            return true;
        }
        if (this.dOf.mK()) {
            MarkData aFX = this.dOf.aFX();
            if (aFX == null || !this.dOf.getIsFromMark()) {
                return true;
            }
            MarkData ns = this.dOf.ns(this.dOO.aHu());
            if (ns == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aFX);
                setResult(-1, intent);
                return true;
            } else if (ns.getPostId() == null || ns.getPostId().equals(aFX.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aFX);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cz(String.format(getPageContext().getString(u.j.alert_update_mark), Integer.valueOf(ns.getFloor())));
                aVar.a(u.j.alert_yes_btn, new bf(this, ns, aFX, aVar));
                aVar.b(u.j.alert_no_button, new bg(this, aFX, aVar));
                aVar.a(new bh(this, aFX, aVar));
                aVar.b(getPageContext());
                aVar.rT();
                return false;
            }
        } else if (this.dOf.getPbData() == null || this.dOf.getPbData().aDP() == null || this.dOf.getPbData().aDP().size() <= 0 || !this.dOf.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: LO */
    public BdListView getListView() {
        if (this.dOO == null) {
            return null;
        }
        return this.dOO.LO();
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public int Hg() {
        if (this.dOO == null) {
            return 0;
        }
        return this.dOO.aHA();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vA() {
        if (this.dOO == null) {
            return 0;
        }
        return this.dOO.Ws();
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<ImageView> Hh() {
        if (this.aFj == null) {
            this.aFj = new com.baidu.adp.lib.f.b<>(new bi(this), 8, 0);
        }
        return this.aFj;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<TextView> Hi() {
        if (this.aFk == null) {
            this.aFk = TbRichTextView.h(getPageContext().getPageActivity(), 8);
        }
        return this.aFk;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<GifView> Hj() {
        if (this.aFo == null) {
            this.aFo = new com.baidu.adp.lib.f.b<>(new bj(this), 20, 0);
        }
        return this.aFo;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> Hk() {
        if (this.aFm == null) {
            this.aFm = new com.baidu.adp.lib.f.b<>(new bk(this), 8, 0);
        }
        return this.aFm;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> Hm() {
        if (this.aFl == null) {
            this.aFl = com.baidu.tieba.graffiti.e.createGraffitiViewPool(getPageContext().getPageActivity(), 6);
        }
        return this.aFl;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> fk(int i) {
        if (this.aFp == null) {
            if (i == 1) {
                this.aFp = com.baidu.tieba.togetherhi.ds.createGraffitiViewPool(getPageContext().getPageActivity(), 6);
            } else {
                this.aFp = TogetherHiLivingView.createGraffitiViewPool(getPageContext().getPageActivity(), 6);
            }
        }
        return this.aFp;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> vB() {
        if (this.adT == null) {
            this.adT = UserIconBox.e(getPageContext().getPageActivity(), 8);
        }
        return this.adT;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void A(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void B(Context context, String str) {
        gi.aIa().g(getPageContext(), str);
    }

    private com.baidu.tbadk.core.dialog.a aER() {
        if (this.dOC == null) {
            this.dOC = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.dOC.cy(getPageContext().getString(u.j.download_baidu_video_dialog));
            this.dOC.a(getPageContext().getString(u.j.install), new bm(this));
            this.dOC.b(getPageContext().getString(u.j.cancel), new bn(this));
            this.dOC.an(true);
            this.dOC.b(getPageContext());
            this.dOC.ao(false);
        }
        this.dOC.rT();
        return this.dOC;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void C(Context context, String str) {
        gi.aIa().g(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void E(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra("title", "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            aER();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void D(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        com.baidu.tbadk.widget.richText.c cVar;
        int a2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.h pbData = this.dOf.getPbData();
            com.baidu.tbadk.widget.richText.a ay = ay(str, i);
            if (ay != null && (cVar = ay.GF().get(this.dPu)) != null) {
                bVar.dPT = new ArrayList<>();
                bVar.dPU = new ConcurrentHashMap<>();
                if (!cVar.GK().GW()) {
                    bVar.dPW = false;
                    String c2 = com.baidu.tieba.pb.data.i.c(cVar);
                    bVar.dPT.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(cVar);
                    imageUrlData.originalSize = e(cVar);
                    imageUrlData.postId = ay.getPostId();
                    imageUrlData.mIsReserver = this.dOf.aFW();
                    imageUrlData.mIsSeeHost = this.dOf.getHostMode();
                    bVar.dPU.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aDN() != null) {
                            bVar.forumName = pbData.aDN().getName();
                            bVar.forumId = pbData.aDN().getId();
                        }
                        if (pbData.aDO() != null) {
                            bVar.threadId = pbData.aDO().getId();
                        }
                        bVar.dPV = pbData.aDV() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.dPW = true;
                int size = pbData.aDP().size();
                this.dPv = false;
                bVar.index = -1;
                int i2 = i;
                for (int i3 = 0; i3 < size; i3++) {
                    com.baidu.tieba.tbadkCore.data.s sVar = pbData.aDP().get(i3);
                    com.baidu.tbadk.widget.richText.a auL = sVar.auL();
                    if (!er.f(sVar)) {
                        a2 = a(auL, ay, i2, i, bVar.dPT, bVar.dPU);
                    } else {
                        a2 = a(sVar, i2, bVar.dPT, bVar.dPU);
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> bcl = sVar.bcl();
                    i2 = a2;
                    for (int i4 = 0; i4 < bcl.size(); i4++) {
                        i2 = a(bcl.get(i4).auL(), ay, i2, i, bVar.dPT, bVar.dPU);
                    }
                }
                if (bVar.dPT.size() > 0) {
                    bVar.lastId = bVar.dPT.get(bVar.dPT.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aDN() != null) {
                        bVar.forumName = pbData.aDN().getName();
                        bVar.forumId = pbData.aDN().getId();
                    }
                    if (pbData.aDO() != null) {
                        bVar.threadId = pbData.aDO().getId();
                    }
                    bVar.dPV = pbData.aDV() == 1;
                }
                bVar.index = i2;
            }
        }
    }

    private String d(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.GK() == null) {
            return null;
        }
        return cVar.GK().GZ();
    }

    private long e(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.GK() == null) {
            return 0L;
        }
        return cVar.GK().getOriginalSize();
    }

    private int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.g GK;
        if (aVar == aVar2) {
            this.dPv = true;
        }
        if (aVar != null) {
            int size = aVar.GF().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.GF().get(i6) == null || aVar.GF().get(i6).getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int width = aVar.GF().get(i6).GK().getWidth();
                    int height = aVar.GF().get(i6).GK().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.GF().get(i6).GK().GW()) {
                        if (aVar == aVar2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.GF().get(i6);
                        String c2 = com.baidu.tieba.pb.data.i.c(cVar);
                        if (!TextUtils.isEmpty(c2)) {
                            arrayList.add(c2);
                            if (cVar != null && (GK = cVar.GK()) != null) {
                                String GX = GK.GX();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = GX;
                                int i9 = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.urlType = i9;
                                imageUrlData.urlType = i9;
                                imageUrlData.originalUrl = d(cVar);
                                imageUrlData.originalSize = e(cVar);
                                imageUrlData.postId = aVar.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.h.b.c(this.dOf.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.dOf.aFW();
                                imageUrlData.mIsSeeHost = this.dOf.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.dPv) {
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

    private int a(com.baidu.tieba.tbadkCore.data.s sVar, int i, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        ArrayList<com.baidu.tieba.tbadkCore.data.k> bbM;
        if (sVar != null && arrayList != null && concurrentHashMap != null && (bbM = sVar.bcw().bbM()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bbM.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = bbM.get(i3);
                if (kVar != null) {
                    String bbT = kVar.bbT();
                    if (!com.baidu.tbadk.core.util.ba.isEmpty(bbT)) {
                        arrayList.add(bbT);
                        if (!this.dPv) {
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
    public void c(com.baidu.tieba.tbadkCore.data.s sVar) {
        if (sVar != null) {
            boolean z = false;
            if (sVar.getId() != null && sVar.getId().equals(this.dOf.qP())) {
                z = true;
            }
            MarkData d = this.dOf.d(sVar);
            if (d != null) {
                this.dOO.aHn();
                if (this.dvH != null) {
                    this.dvH.a(d);
                    if (!z) {
                        this.dvH.mM();
                    } else {
                        this.dvH.mL();
                    }
                }
            }
        }
    }

    private com.baidu.tbadk.widget.richText.a ay(String str, int i) {
        if (this.dOf == null || this.dOf.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.h pbData = this.dOf.getPbData();
        com.baidu.tbadk.widget.richText.a a2 = a(pbData.aDP(), str, i);
        if (a2 == null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.s> aDP = pbData.aDP();
            int size = aDP.size();
            for (int i2 = 0; i2 < size; i2++) {
                a2 = a(aDP.get(i2).bcl(), str, i);
                if (a2 != null) {
                    return a2;
                }
            }
            return a2;
        }
        return a2;
    }

    private long nt(String str) {
        ArrayList<com.baidu.tieba.tbadkCore.data.s> aDP;
        com.baidu.tieba.pb.data.h pbData = this.dOf.getPbData();
        if (pbData != null && (aDP = pbData.aDP()) != null && !aDP.isEmpty()) {
            Iterator<com.baidu.tieba.tbadkCore.data.s> it = aDP.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.s next = it.next();
                com.baidu.tieba.tbadkCore.data.i bcw = next.bcw();
                if (bcw != null && bcw.eXl) {
                    Iterator<com.baidu.tbadk.widget.richText.c> it2 = next.auL().GF().iterator();
                    while (it2.hasNext()) {
                        com.baidu.tbadk.widget.richText.c next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.GS().getLink().equals(str)) {
                            return bcw.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> GF;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a auL = arrayList.get(i2).auL();
            if (auL != null && (GF = auL.GF()) != null) {
                int size = GF.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (GF.get(i4) != null && GF.get(i4).getType() == 8) {
                        i3++;
                        if (GF.get(i4).GK().GX().equals(str)) {
                            int width = GF.get(i4).GK().getWidth();
                            int height = GF.get(i4).GK().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.dPu = i4;
                            return auL;
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

    @Override // com.baidu.tbadk.widget.richText.m
    public void d(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.dOd = str;
            if (this.dOB == null) {
                aEG();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.dOB.bT(1).setVisibility(8);
            } else {
                this.dOB.bT(1).setVisibility(0);
            }
            this.dOB.rW();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bBm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OQ() {
        hideNetRefreshView(this.dOO.getView());
        aES();
        if (this.dOf.DH()) {
            this.dOO.aHn();
        }
    }

    private void aES() {
        showLoadingView(this.dOO.getView(), false, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds400));
        View Dh = getLoadingView().Dh();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Dh.getLayoutParams();
        layoutParams.addRule(3, this.dOO.aHT().getId());
        Dh.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UR() {
        if (this.bBm != null) {
            this.bBm.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ni(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaO() {
        if (this.dOf.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.h pbData = this.dOf.getPbData();
            String name = pbData.aDN().getName();
            String title = pbData.aDO().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.dOf.getThreadID() + "?share=9105&fr=share";
            String[] aM = pbData.aM(getPageContext().getPageActivity());
            String str2 = aM[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = aM[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (aEI() == 1) {
                if (pbData != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10399").ab("fid", pbData.getForumId()).ab("tid", pbData.getThreadId()).ab("uid", currentAccount));
                }
            } else if (aEI() == 2 && pbData != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10406").ab("fid", pbData.getForumId()).ab("tid", pbData.getThreadId()).ab("uid", currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(u.j.share_content_tpl), title, name, str3);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.linkUrl = str;
            fVar.ajq = true;
            fVar.extData = this.dOf.getThreadID();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(u.j.share_tieba_qunzu, u.f.icon_unite_share_qunzu, new bo(this));
            shareDialogConfig.addOutsideTextView(u.j.forum_friend, u.f.icon_unite_share_baf, new bp(this));
            shareDialogConfig.setCopyLinkListener(new bq(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<LinearLayout> Hl() {
        if (this.aFn == null) {
            this.aFn = new com.baidu.adp.lib.f.b<>(new br(this), 15, 0);
        }
        return this.aFn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aET() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.pb.data.h pbData = this.dOf.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.pt().isIfAddition();
            AdditionData aDX = pbData.aDX();
            boolean z3 = aDX == null ? false : isIfAddition;
            if (z3) {
                z = aDX.getAlreadyCount() != aDX.getTotalCount();
                if (!TextUtils.isEmpty(aDX.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.pb.main.b.e eVar = this.dOO.dTq;
            if (!z3 || !z) {
                z2 = false;
            }
            eVar.hX(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.dOO.aHg() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10517").s("obj_locate", 2).ab("fid", this.dOf.getPbData().getForumId()));
            } else {
                com.baidu.tbadk.core.data.az aDO = this.dOf.getPbData().aDO();
                if (view != null) {
                    boolean z = aDO.getPraise() == null || aDO.getPraise().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.bBB > 1000) {
                            this.bBC = true;
                            ac(view);
                        } else {
                            this.bBC = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            e(view, this.bBC);
                        } else {
                            d(view, this.bBC);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        d(view, this.bBC);
                    } else if (motionEvent.getAction() == 3) {
                        d(view, this.bBC);
                    }
                }
            }
        }
        return false;
    }

    private void d(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), u.a.praise_animation_scale2));
            new Handler().postDelayed(new bs(this), 200L);
        }
    }

    private void e(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), u.a.praise_animation_scale3));
            new Handler().postDelayed(new bt(this), 600L);
        }
    }

    private void ac(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), u.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void VB() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.a(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(u.j.login_to_use), true, 11017)));
        } else if (aVar.rV() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.rV();
            int intValue = ((Integer) sparseArray.get(es.dVi)).intValue();
            if (intValue == es.dVj) {
                if (!this.dON.bdc()) {
                    this.dOO.aHk();
                    int intValue2 = ((Integer) sparseArray.get(u.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(u.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(u.g.tag_del_post_type)).intValue();
                    this.dON.a(this.dOf.getPbData().aDN().getId(), this.dOf.getPbData().aDN().getName(), this.dOf.getPbData().aDO().getId(), (String) sparseArray.get(u.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == es.dVk || intValue == es.dVm) {
                if (this.dOf.aGj() != null) {
                    this.dOf.aGj().nk(dg.dQN);
                }
                if (intValue == es.dVk) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == es.dVl) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.dPz).ol()));
            }
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (sparseArray.get(u.g.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(u.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(u.g.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(u.g.tag_user_mute_thread_id);
        }
        if (sparseArray.get(u.g.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(u.g.tag_user_mute_post_id);
        }
        if (sparseArray.get(u.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(u.g.tag_user_mute_msg);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.dPc);
        userMuteAddAndDelCustomMessage.setTag(this.dPc);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean nu(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bn.ab(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.sO().getString("bubble_link", ""))) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(u.j.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void hq(boolean z) {
        this.dOV = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aEU() {
        ArrayList<com.baidu.tieba.tbadkCore.data.s> aDP;
        int s;
        if (this.dOf == null || this.dOf.getPbData() == null || this.dOf.getPbData().aDP() == null || (s = com.baidu.tbadk.core.util.y.s((aDP = this.dOf.getPbData().aDP()))) == 0) {
            return "";
        }
        int aHt = this.dOO.aHt();
        com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(aDP, aHt);
        if (sVar == null || sVar.getAuthor() == null) {
            return "";
        }
        if (this.dOf.nz(sVar.getAuthor().getUserId())) {
            return sVar.getId();
        }
        for (int i = aHt - 1; i != 0; i--) {
            com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(aDP, i);
            if (sVar2 == null || sVar2.getAuthor() == null || sVar2.getAuthor().getUserId() == null) {
                break;
            } else if (this.dOf.nz(sVar2.getAuthor().getUserId())) {
                return sVar2.getId();
            }
        }
        for (int i2 = aHt + 1; i2 < s; i2++) {
            com.baidu.tieba.tbadkCore.data.s sVar3 = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(aDP, i2);
            if (sVar3 == null || sVar3.getAuthor() == null || sVar3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.dOf.nz(sVar3.getAuthor().getUserId())) {
                return sVar3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void F(Context context, String str) {
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bi.us().c(getPageContext(), new String[]{str})) {
            com.baidu.tieba.pb.b.a(nt(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.dOf.getPbData().aDN().getId(), this.dOf.getPbData().aDN().getName(), this.dOf.getPbData().aDO().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, String str2, String str3, String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cz(getResources().getString(u.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cz(getResources().getString(u.j.make_sure_hide));
        }
        aVar.a(getResources().getString(u.j.alert_yes_button), new bv(this, j, str, str2, str3, str4));
        aVar.b(getResources().getString(u.j.alert_no_button), new bw(this, j, str, str2, str3, str4));
        aVar.ao(false);
        aVar.b(getPageContext());
        aVar.rT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b nv(String str) {
        String str2;
        if (this.dOf.getPbData() == null || this.dOf.getPbData().aDP() == null || this.dOf.getPbData().aDP().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i < this.dOf.getPbData().aDP().size()) {
                if (str.equals(this.dOf.getPbData().aDP().get(i).getId())) {
                    break;
                }
                i++;
            } else {
                i = 0;
                break;
            }
        }
        com.baidu.tieba.tbadkCore.data.s sVar = this.dOf.getPbData().aDP().get(i);
        if (sVar.auL() == null || sVar.auL().GF() == null) {
            return null;
        }
        Iterator<com.baidu.tbadk.widget.richText.c> it = sVar.auL().GF().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.GK() != null) {
                    str2 = next.GK().GX();
                }
            }
        }
        a(str2, 0, bVar);
        com.baidu.tieba.pb.data.i.a(sVar, bVar);
        return bVar;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.dOy) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.dOy = false;
        } else if (aEV()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.dOy) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.dOy = false;
        } else if (aEV()) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void hr(boolean z) {
        this.dOY = z;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a005";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.dOf != null) {
            if (this.dOf.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(this.dOf.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.h.b.c(this.dOf.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aEV() {
        return (!this.dOw && this.dPB == -1 && this.dPC == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.l lVar) {
        if (lVar != null) {
            this.dPE = lVar;
            this.dOw = true;
            this.dOO.aGW();
            this.dOO.nE(this.dPD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEW() {
        if (this.dPE != null) {
            if (this.dPB == -1) {
                showToast(u.j.pb_manga_not_prev_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.dPE.getCartoonId(), this.dPB, 0)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEX() {
        if (this.dPE != null) {
            if (this.dPC == -1) {
                showToast(u.j.pb_manga_not_next_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.dPE.getCartoonId(), this.dPC, 0)));
            finish();
        }
    }

    public int aEY() {
        return this.dPB;
    }

    public int aEZ() {
        return this.dPC;
    }

    private void aiV() {
        if (this.dOf != null && this.dOf.getPbData() != null && this.dOf.getPbData().aDO() != null && this.dOf.getPbData().aDO().rj()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFa() {
        if (this.dOf != null && this.dOf.getPbData() != null && this.dOf.getPbData().aDO() != null && this.dOf.getPbData().aDO().rj()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aFb() {
        if (this.dOz) {
            this.dOL = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.dOf.getPbData() != null && this.dOf.getPbData().aDO() != null && this.dOf.getPbData().aDO().qy() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.dOf.getPbData().aDO().qy().getThreadId(), this.dOf.getPbData().aDO().qy().getTaskId(), this.dOf.getPbData().aDO().qy().getForumId(), this.dOf.getPbData().aDO().qy().getForumName(), this.dOf.getPbData().aDO().getIs_top(), this.dOf.getPbData().aDO().getIs_good())));
            this.dOy = true;
            finish();
        }
    }

    public boolean aFc() {
        return this.dOz;
    }

    public String aFd() {
        return this.dOJ;
    }

    public PbInterviewStatusView.a aFe() {
        return this.dOM;
    }

    public void hs(boolean z) {
        this.dOK = z;
    }

    public boolean aFf() {
        if (this.dOf != null) {
            return this.dOf.aFN();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFg() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cz(getResources().getString(u.j.mute_is_super_member_function));
        aVar.a(u.j.open_now, new bx(this));
        aVar.b(u.j.cancel, new by(this));
        aVar.b(this.dPa).rT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fH(String str) {
        if (str == null) {
            str = "";
        }
        if (this.dPa != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPa.getPageActivity());
            aVar.cz(str);
            aVar.b(u.j.know, new bz(this));
            aVar.b(this.dPa).rT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.dOO.asK();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPa.getPageActivity());
        if (com.baidu.tbadk.core.util.ba.isEmpty(str)) {
            aVar.cz(this.dPa.getResources().getString(u.j.block_mute_message_alert, str2));
        } else {
            aVar.cz(str);
        }
        aVar.a(u.j.confirm, new ca(this, userMuteAddAndDelCustomMessage));
        aVar.b(u.j.cancel, new cb(this));
        aVar.b(this.dPa).rT();
    }
}
