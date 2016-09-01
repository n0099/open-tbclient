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
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
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
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.e.a;
import com.baidu.tieba.e.c;
import com.baidu.tieba.pb.pb.main.a.f;
import com.baidu.tieba.pb.pb.main.cq;
import com.baidu.tieba.pb.pb.main.ct;
import com.baidu.tieba.pb.pb.main.dh;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.f.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
import com.baidu.tieba.togetherhi.TogetherHiLivingView;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, com.baidu.tbadk.widget.richText.m {
    private com.baidu.adp.lib.f.b<ImageView> aJm;
    private com.baidu.adp.lib.f.b<TextView> aJn;
    private com.baidu.adp.lib.f.b<View> aJo;
    private com.baidu.adp.lib.f.b<View> aJp;
    private com.baidu.adp.lib.f.b<LinearLayout> aJq;
    private com.baidu.adp.lib.f.b<GifView> aJr;
    private com.baidu.adp.lib.f.b<View> aJs;
    private com.baidu.adp.lib.f.b<TbImageView> ahC;
    private com.baidu.tieba.e.c bPI;
    private com.baidu.tbadk.f.a bPO;
    private VoiceManager bQi;
    private com.baidu.tieba.pb.pb.main.a.f emP;
    private com.baidu.tbadk.core.dialog.a emU;
    private String emv;
    private boolean enO;
    private String enZ;
    private com.baidu.tieba.pb.pb.main.b ena;
    private Cdo enm;
    private boolean enq;
    private com.baidu.tieba.tbadkCore.data.f enr;
    private com.baidu.tbadk.editortools.d.e ens;
    private com.baidu.adp.base.h env;
    private com.baidu.tbadk.core.view.h enw;
    private BdUniqueId enx;
    private com.baidu.tbadk.core.data.m eoa;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean emO = false;
    private boolean emQ = false;
    private boolean emR = false;
    private boolean dOK = false;
    private int emS = 0;
    private com.baidu.tbadk.core.dialog.c emT = null;
    private long bGO = -1;
    private long aCr = 0;
    private long emV = 0;
    private long createTime = 0;
    private long aCj = 0;
    private boolean emW = false;
    private com.baidu.tbadk.performanceLog.e emX = null;
    private long emY = 0;
    private boolean emZ = false;
    private String awm = null;
    private String enb = "";
    private boolean enc = true;
    private boolean ene = false;
    private String source = "";
    private PbInterviewStatusView.a enf = new i(this);
    private final Handler mHandler = new Handler(new t(this));
    private dh emx = null;
    private com.baidu.tbadk.baseEditMark.a dKY = null;
    private com.baidu.tieba.tbadkCore.f.a eng = null;
    private ex enh = null;
    public final com.baidu.tieba.pb.pb.main.a.a eni = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean enj = false;
    private boolean enk = false;
    private boolean enl = false;
    private boolean enn = false;
    private boolean eno = false;
    private boolean enp = false;
    private boolean bOZ = false;
    private boolean ent = false;
    private com.baidu.tbadk.editortools.d.c awq = new ae(this);
    private boolean enu = false;
    private int cJq = -1;
    private final CustomMessageListener eny = new ap(this, CmdConfigCustom.PB_RESET_EDITOR_TOOL);
    CustomMessageListener bPX = new ba(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private CustomMessageListener ciq = new bl(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener dwz = new bu(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener dxb = new ce(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener enz = new cf(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener aKh = new j(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
    private CustomMessageListener cUv = new k(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private HttpMessageListener bnH = new l(this, CmdConfigHttp.PB_ECOMM_RECOMMEND_HTTP_CMD);
    private cq.a enA = new m(this);
    private View.OnClickListener dwy = new n(this);
    private CustomMessageListener enB = new o(this, CmdConfigCustom.CMD_SEND_GIFT_SUCCESS);
    private boolean enC = false;
    private com.baidu.tieba.tbadkCore.ai bQh = new com.baidu.tieba.tbadkCore.ai(getPageContext(), new p(this));
    private long ekS = 0;
    private boolean ekT = true;
    private f.a enD = new q(this);
    private CustomMessageListener bnI = new r(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener enE = new s(this, CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED);
    private com.baidu.tieba.pb.a.d ekU = new com.baidu.tieba.pb.a.d(new u(this));
    private CustomMessageListener enF = new v(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener enG = new w(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener enH = new x(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    public a.b dXo = new y(this);
    public final View.OnClickListener bRE = new z(this);
    private final b.d aww = new aa(this);
    private final dh.a enI = new ab(this);
    private CustomMessageListener enJ = new ac(this, CmdConfigCustom.CMD_WX_SHARE_SUCCESS);
    private CustomMessageListener enK = new ad(this, CmdConfigCustom.CMD_TTS_OPTION_PB);
    private final a.InterfaceC0032a enL = new af(this);
    private final AbsListView.OnScrollListener BL = new ag(this);
    private final com.baidu.adp.base.g enM = new ah(this);
    private final c enN = new ai(this);
    private final t.b aUp = new aj(this);
    private final BdListView.e enP = new ak(this);
    private int enQ = 0;
    private final TbRichTextView.d aJI = new al(this);
    boolean enR = false;
    com.baidu.tieba.tbadkCore.data.q enS = null;
    private final c.b enT = new am(this);
    private final View.OnLongClickListener aoq = new an(this);
    private final NoNetworkView.a bOz = new ao(this);
    public View.OnTouchListener aKe = new aq(this);
    private a.InterfaceC0055a aQg = new ar(this);
    private final c.a enU = new as(this);
    private String enV = null;
    private final ct.a enW = new at(this);
    private int enX = -1;
    private int enY = -1;
    private final CustomMessageListener bQa = new au(this, CmdConfigCustom.CMD_JUDGE_TO_HOTTOPIC_FROM_PB);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> eoq;
        public ConcurrentHashMap<String, ImageUrlData> eor;
        public boolean eot;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean eos = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes.dex */
    public interface c {
        void ia(boolean z);
    }

    public void hS(boolean z) {
        this.emZ = z;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.d.e aMB() {
        return this.ens;
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        if (mVar.aMh() != null) {
            String id = mVar.aMh().getId();
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aLR = this.emx.getPbData().aLR();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aLR.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.q qVar = aLR.get(i2);
                if (qVar.getId() == null || !qVar.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.data.q> aMl = mVar.aMl();
                    qVar.rx(mVar.getTotalCount());
                    if (qVar.biY() != null) {
                        qVar.biY().clear();
                        qVar.biY().addAll(aMl);
                    }
                }
            }
            this.enh.j(this.emx.getPbData());
        }
    }

    public void aMC() {
        com.baidu.tieba.pb.data.h pbData;
        com.baidu.tbadk.core.data.bg aLQ;
        if (!this.enC) {
            if (!com.baidu.adp.lib.util.k.gD()) {
                showToast(t.j.no_network_guide);
            } else if (this.ekT) {
                this.enC = true;
                if (this.emx != null && (pbData = this.emx.getPbData()) != null && (aLQ = pbData.aLQ()) != null) {
                    int isLike = aLQ.rt() == null ? 0 : aLQ.rt().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10796").ab("tid", aLQ.getId()));
                    }
                    if (this.bQh != null) {
                        this.bQh.a(aLQ.rQ(), aLQ.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        String string;
        if ((sparseArray.get(t.g.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(t.g.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(t.g.tag_check_mute_from) instanceof Integer)) {
            String str = (String) sparseArray.get(t.g.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(t.g.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(t.g.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
                cVar.cc(t.j.operation);
                int i = -1;
                if (sparseArray.get(t.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(t.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(t.j.delete);
                    if (z) {
                        string = getResources().getString(t.j.un_mute);
                    } else {
                        string = getResources().getString(t.j.mute);
                    }
                    strArr[1] = string;
                    cVar.a(strArr, new av(this, sparseArray, z, str2, str));
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(t.j.un_mute) : getResources().getString(t.j.mute);
                    cVar.a(strArr2, new aw(this, sparseArray, z, str2, str));
                }
                cVar.d(getPageContext()).ta();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(int i) {
        com.baidu.tbadk.core.data.bg aLQ;
        String sb;
        String y;
        if (this.emx != null && this.emx.getPbData() != null && (aLQ = this.emx.getPbData().aLQ()) != null) {
            if (i == 1) {
                PraiseData rt = aLQ.rt();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rt == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aLQ.a(praiseData);
                    } else {
                        aLQ.rt().getUser().add(0, metaData);
                        aLQ.rt().setNum(aLQ.rt().getNum() + 1);
                        aLQ.rt().setIsLike(i);
                    }
                }
                if (aLQ.rt() != null) {
                    if (aLQ.rt().getNum() < 1) {
                        y = getResources().getString(t.j.frs_item_praise_text);
                    } else {
                        y = com.baidu.tbadk.core.util.ba.y(aLQ.rt().getNum());
                    }
                    this.enh.M(y, true);
                }
            } else if (aLQ.rt() != null) {
                aLQ.rt().setIsLike(i);
                aLQ.rt().setNum(aLQ.rt().getNum() - 1);
                ArrayList<MetaData> user = aLQ.rt().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aLQ.rt().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aLQ.rt().getNum() < 1) {
                    sb = getResources().getString(t.j.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(aLQ.rt().getNum())).toString();
                }
                this.enh.M(sb, false);
            }
            if (this.emx.aNO()) {
                this.enh.aPj().notifyDataSetChanged();
            } else {
                this.enh.k(this.emx.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.tieba.tbadkCore.data.q a2;
        if (this.emx != null && this.emx.getPbData() != null && (a2 = com.baidu.tieba.pb.data.i.a(this.emx.getPbData(), this.emx.aNO(), this.emx.aOd())) != null) {
            com.baidu.tieba.pb.data.i.a(a2, updateAttentionMessage);
            if (this.enh != null && this.emx != null) {
                this.enh.c(this.emx.getPbData(), this.emx.aNO(), this.emx.aOd());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bPO == null) {
                this.bPO = new com.baidu.tbadk.f.a(getPageContext());
            }
            this.bPO.ap(updateAttentionMessage.getData().toUid, this.emx.getPbData().getForumId());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.emx.n(bundle);
        if (this.bQi != null) {
            this.bQi.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.ens.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.env = getPageContext();
        Intent intent = getIntent();
        if (intent != null) {
            this.bGO = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.enb = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.enb)) {
                this.emQ = true;
            }
            this.enX = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.enY = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.enZ = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            if (aMY()) {
                setUseStyleImmersiveSticky(false);
            }
            this.eno = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ba.isEmpty(this.source) ? "" : this.source;
        } else {
            this.bGO = System.currentTimeMillis();
        }
        this.emV = System.currentTimeMillis();
        this.aCj = this.emV - this.bGO;
        super.onCreate(bundle);
        this.emS = 0;
        p(bundle);
        if (this.emx != null && this.emx.getPbData() != null) {
            this.emx.getPbData().hf(this.source);
        }
        initUI();
        if (intent != null && this.enh != null) {
            this.enh.erU = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
        }
        this.bQi = new VoiceManager();
        this.bQi.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.d.n nVar = new com.baidu.tbadk.editortools.d.n();
        nVar.setForumName(this.emx.aNN());
        if (this.emx.getPbData() != null && this.emx.getPbData().aLP() != null) {
            nVar.setForumId(this.emx.getPbData().aLP().getId());
        }
        nVar.setFrom("pb");
        nVar.a(this.emx);
        this.ens = (com.baidu.tbadk.editortools.d.e) nVar.ap(getActivity());
        this.ens.d(this);
        this.ens.a(this.aww);
        this.ens.a(this.awq);
        this.ens.a(this, bundle);
        this.ens.CG().c(new com.baidu.tbadk.editortools.z(getActivity()));
        this.ens.CG().bz(true);
        hU(true);
        this.enh.setEditorTools(this.ens.CG());
        this.ens.a(this.emx.aNU(), this.emx.getThreadID(), this.emx.aNK());
        registerListener(this.dwz);
        registerListener(this.bQa);
        registerListener(this.bnH);
        if (!this.emx.aNR()) {
            this.ens.fD(this.emx.getThreadID());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.emV;
        registerListener(this.ciq);
        registerListener(this.dxb);
        registerListener(this.enz);
        registerListener(this.aKh);
        registerListener(this.bPX);
        registerListener(this.eny);
        this.enr = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.frZ);
        this.enr.biD();
        registerListener(this.enB);
        registerListener(this.bnI);
        if (this.emx != null) {
            this.emx.aOf();
        }
        if (TbadkCoreApplication.m9getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.enE);
        registerListener(this.enK);
        registerListener(this.enJ);
        this.ena = new com.baidu.tieba.pb.pb.main.b(this.emx, this);
        if (this.enh != null && this.enh.aPU() != null && this.enh.aPV() != null) {
            this.emP = new com.baidu.tieba.pb.pb.main.a.f(getActivity(), this.enh.aPU(), this.enh.aPV());
            this.emP.a(this.enD);
            this.emP.iD(this.enh.aQa());
        }
        if (aMY() && this.enh != null && this.enh.aPV() != null) {
            this.enh.aPV().setVisibility(8);
        }
        this.enw = new com.baidu.tbadk.core.view.h();
        this.enw.aeI = 1000L;
        registerListener(this.enH);
        registerListener(this.enF);
        registerListener(this.enG);
        this.enx = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.enx;
        userMuteAddAndDelCustomMessage.setTag(this.enx);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.enx;
        userMuteCheckCustomMessage.setTag(this.enx);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public String aMD() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.f aME() {
        return this.emP;
    }

    private void hU(boolean z) {
        this.ens.bC(z);
        this.ens.bD(z);
        this.ens.bE(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
        if (this.ens != null && this.ens.CG() != null) {
            this.ens.CG().CS();
        }
        if (this.enh != null) {
            this.enh.CS();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bQi != null) {
            this.bQi.onStart(getPageContext());
        }
    }

    public ex aMF() {
        return this.enh;
    }

    public dh aMG() {
        return this.emx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.m9getInst().isReadMenuDialogOnTop()) {
            this.emR = false;
        } else {
            this.emR = true;
        }
        super.onPause();
        if (this.enh.aOU() != null && this.enh.aOU().aMy() != null) {
            this.enh.aOU().aMy().onPause();
        }
        BdListView listView = getListView();
        this.emS = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.emS == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.bQi != null) {
            this.bQi.onPause(getPageContext());
        }
        if (this.enh != null) {
            this.enh.onPause();
        }
        if (!this.emx.aNR()) {
            this.ens.fC(this.emx.getThreadID());
        }
        if (this.emx != null) {
            this.emx.aOg();
        }
        MessageManager.getInstance().unRegisterListener(this.cUv);
        aot();
        MessageManager.getInstance().unRegisterListener(this.enF);
        MessageManager.getInstance().unRegisterListener(this.enG);
        MessageManager.getInstance().unRegisterListener(this.enH);
    }

    private boolean aMH() {
        com.baidu.tieba.tbadkCore.data.q a2 = com.baidu.tieba.pb.data.i.a(this.emx.getPbData(), this.emx.aNO(), this.emx.aOd());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.emR = false;
        super.onResume();
        if (this.ene) {
            this.ene = false;
            aNe();
        }
        if (this.enh.aOU() != null && this.enh.aOU().aMy() != null) {
            this.enh.aOU().aMy().onResume();
        }
        if (aMH()) {
            this.emY = System.currentTimeMillis();
        } else {
            this.emY = -1L;
        }
        if (this.enh != null && this.enh.getView() != null) {
            if (!this.dOK) {
                aMV();
            } else {
                hideLoadingView(this.enh.getView());
            }
            this.enh.onResume();
        }
        if (this.emS == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.enh != null) {
            noNetworkView = this.enh.aOV();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.gm()) {
            noNetworkView.aG(false);
        }
        if (this.bQi != null) {
            this.bQi.onResume(getPageContext());
        }
        registerListener(this.cUv);
        this.enq = false;
        aNd();
        registerListener(this.enF);
        registerListener(this.enG);
        registerListener(this.enH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.enh.ip(z);
        if (this.enm != null) {
            this.enm.ig(z);
        }
        if (z && this.enq) {
            this.enh.aPq();
            this.emx.ic(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.emY > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10804").ab("obj_duration", new StringBuilder(String.valueOf(System.currentTimeMillis() - this.emY)).toString()));
            this.emY = 0L;
        }
        if (this.ens != null && this.ens.CG() != null && this.ens.CG().getVisibility() != 0) {
            this.ens.Du();
        }
        if (this.enh.erX != null && !this.enh.erX.aQh()) {
            this.enh.erX.aAV();
        }
        if (this.emx != null && this.emx.getPbData() != null && this.emx.getPbData().aLP() != null && this.emx.getPbData().aLQ() != null) {
            com.baidu.tbadk.distribute.a.Cp().b(getPageContext().getPageActivity(), "pb", this.emx.getPbData().aLP().getId(), com.baidu.adp.lib.h.b.c(this.emx.getPbData().aLQ().getId(), 0L));
        }
        if (this.bQi != null) {
            this.bQi.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ena != null) {
            this.ena.destroy();
        }
        if (this.enn && this.emx != null) {
            a(this.emx.getPbData(), -2, 0, false, false);
        }
        if (!this.emW && this.enh != null) {
            this.emW = true;
            this.enh.aPK();
        }
        if (this.emx != null) {
            this.emx.cancelLoadData();
            this.emx.destory();
        }
        if (this.ens != null) {
            this.ens.onDestroy();
        }
        if (this.eng != null) {
            this.eng.cancelLoadData();
        }
        if (this.enh != null) {
            this.enh.onDestroy();
            if (this.enh.erX != null) {
                this.enh.erX.aAV();
            }
        }
        if (this.emX != null) {
            this.emX.onDestroy();
        }
        if (this.emP != null) {
            this.emP.aco();
        }
        super.onDestroy();
        if (this.bQi != null) {
            this.bQi.onDestory(getPageContext());
        }
        if (this.bPO != null) {
            this.bPO.destory();
        }
        this.enh.aAE();
        MessageManager.getInstance().unRegisterListener(this.enF);
        MessageManager.getInstance().unRegisterListener(this.enG);
        MessageManager.getInstance().unRegisterListener(this.enH);
        MessageManager.getInstance().unRegisterListener(this.enx);
        this.env = null;
        this.enw = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.enh.onChangeSkinType(i);
        if (this.ens != null && this.ens.CG() != null) {
            this.ens.CG().onChangeSkinType(i);
        }
        if (this.enh.aOV() != null) {
            this.enh.aOV().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.enh = new ex(this, this.bRE, this.ekU);
        this.bPI = new com.baidu.tieba.e.c(getActivity());
        this.bPI.a(this.enU);
        this.bPI.a(this.aQg);
        this.enh.setOnScrollListener(this.BL);
        this.enh.c(this.enP);
        this.enh.a(this.aUp);
        this.enh.hN(com.baidu.tbadk.core.l.oG().oM());
        this.enh.hO(com.baidu.tbadk.core.l.oG().oI());
        this.enh.setOnImageClickListener(this.aJI);
        this.enh.a(this.aoq);
        this.enh.g(this.bOz);
        this.enh.a(this.enN);
        this.enh.ip(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aV(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(t.g.tag_clip_board);
            if (obj instanceof com.baidu.tieba.tbadkCore.data.q) {
                com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) obj;
                if (com.baidu.tieba.tbadkCore.data.q.fsC == qVar.getType() || TextUtils.isEmpty(qVar.getBimg_url()) || !com.baidu.tbadk.core.l.oG().oM()) {
                    return false;
                }
                return oQ(qVar.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.enh != null) {
            if (z && (!this.dOK || this.enu)) {
                aMV();
            } else {
                hideLoadingView(this.enh.getView());
            }
            this.enu = false;
        }
    }

    private void aMI() {
        if (this.emT == null) {
            this.emT = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.emT.a(new String[]{getPageContext().getString(t.j.call_phone), getPageContext().getString(t.j.sms_phone), getPageContext().getString(t.j.search_in_baidu)}, new ax(this)).cd(c.a.VX).ce(17).d(getPageContext());
        }
    }

    private void p(Bundle bundle) {
        this.emx = new dh(this);
        this.emx.a(this.enI);
        if (this.emx.aOl() != null) {
            this.emx.aOl().a(this.enW);
        }
        if (this.emx.aOk() != null) {
            this.emx.aOk().a(this.enA);
        }
        if (bundle != null) {
            this.emx.initWithBundle(bundle);
        } else {
            this.emx.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra("request_code", -1) == 18003) {
            this.emx.m17if(true);
        }
        ep.aOQ().L(this.emx.aNM(), this.emx.getIsFromMark());
        if (StringUtils.isNull(this.emx.getThreadID())) {
            finish();
        } else {
            this.emx.Fa();
        }
    }

    private void initData(Bundle bundle) {
        this.dKY = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dKY != null) {
            this.dKY.a(this.enL);
        }
        this.eng = new com.baidu.tieba.tbadkCore.f.a(this);
        this.eng.setLoadDataCallBack(this.enM);
        this.enh.a(new ay(this));
        this.bQh.setUniqueId(getUniqueId());
        this.bQh.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.enh.ayk();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.h.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.h.b.c((String) sparseArray.get(t.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.enx;
        userMuteCheckCustomMessage.setTag(this.enx);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMJ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.bY(t.j.go_setting_float_window_permission);
        aVar.bZ(t.j.step_to_setting_float_permission);
        aVar.a(t.j.go_and_setting, new az(this));
        aVar.b(t.j.cancel, new bb(this));
        aVar.b(getPageContext()).sX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aMK() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.emx != null && this.emx.getPbData() != null) {
            com.baidu.tieba.pb.data.h pbData = this.emx.getPbData();
            if (pbData.aLP() != null) {
                sb.append("forum_name=").append(oN(pbData.aLP().getName()));
                sb.append("&");
            }
            if (pbData.aLQ() != null) {
                com.baidu.tbadk.core.data.bg aLQ = pbData.aLQ();
                sb.append("thread_id=").append(aLQ.getId());
                sb.append("&");
                sb.append("thread_title=").append(oN(aLQ.getTitle()));
                if (aLQ.getAuthor() != null && aLQ.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aLQ.getAuthor().getPortrait());
                }
            }
        }
        return sb.toString();
    }

    private String oN(String str) {
        return URLEncoder.encode(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        com.baidu.tieba.tbadkCore.data.q qVar;
        ArrayList<IconData> arrayList;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(t.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.q) && (qVar = (com.baidu.tieba.tbadkCore.data.q) sparseArray.get(t.g.tag_clip_board)) != null && this.emx != null && this.emx.getPbData() != null && qVar.bjc() > 1) {
            String threadID = this.emx.getThreadID();
            String id = qVar.getId();
            int i = 0;
            if (this.emx.getPbData() != null) {
                i = this.emx.getPbData().aLX();
            }
            b oR = oR(id);
            if (oR != null) {
                SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
                SmallTailInfo aQY = qVar.aQY();
                AntiData qf = this.emx.getPbData().qf();
                if (qVar.getAuthor() != null) {
                    arrayList = qVar.getAuthor().getIconInfo();
                } else {
                    arrayList = null;
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i, aQY, qf, false, arrayList).addBigImageData(oR.eoq, oR.eor, oR.eos, oR.index)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aML() {
        if (this.emx.getPbData() == null || this.emx.getPbData().aLQ() == null) {
            return -1;
        }
        return this.emx.getPbData().aLQ().se();
    }

    private boolean hV(boolean z) {
        if (this.emx == null || this.emx.getPbData() == null) {
            return false;
        }
        return (this.emx.getPbData().aLX() != 0) && !z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hW(boolean z) {
        if (this.emx == null || this.emx.getPbData() == null) {
            return false;
        }
        return ((this.emx.getPbData().aLX() != 0) || this.emx.getPbData().aLQ() == null || this.emx.getPbData().aLQ().getAuthor() == null || TextUtils.equals(this.emx.getPbData().aLQ().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void aMM() {
        if (this.emx != null && this.emx.getPbData() != null && this.emx.getPbData().aLQ() != null && this.emx.getPbData().aLQ().getAuthor() != null) {
            com.baidu.tbadk.core.data.bg aLQ = this.emx.getPbData().aLQ();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aLQ.getAuthor().getUserId());
            boolean hW = hW(equals);
            boolean hV = hV(equals);
            boolean z = equals && this.enh.aPy();
            GodUserData godUserData = aLQ.getAuthor().getGodUserData();
            this.enh.erX.a(this.emx.aNO(), this.dKY != null ? this.dKY.nv() : false, hW, z, hV, equals && godUserData != null && godUserData.isCanSendCall());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.tbadkCore.data.q qVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (qVar = (com.baidu.tieba.tbadkCore.data.q) sparseArray.get(t.g.tag_clip_board)) != null) {
            d(qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.h hVar, int i, int i2, boolean z, boolean z2) {
        if (hVar != null && this.emx != null) {
            eg egVar = new eg(getUniqueId());
            egVar.pbData = hVar;
            egVar.threadId = this.emx.getThreadID();
            egVar.postId = this.emx.getPostId();
            egVar.erp = i;
            egVar.erq = i2;
            egVar.ero = this.emx.getHostMode();
            egVar.ekF = this.emx.nv();
            egVar.isSquence = this.emx.aNO();
            egVar.loadType = this.emx.aOi();
            egVar.err = z;
            egVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, egVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, boolean z2) {
        if (hVar != null && this.emx != null) {
            eg egVar = new eg(getUniqueId());
            egVar.pbData = hVar;
            egVar.threadId = this.emx.getThreadID();
            egVar.postId = this.emx.getPostId();
            egVar.erp = i;
            egVar.ero = this.emx.getHostMode();
            egVar.ekF = this.emx.nv();
            egVar.isSquence = this.emx.aNO();
            egVar.loadType = this.emx.aOi();
            egVar.err = z;
            egVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, egVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        Ug();
    }

    public void a(boolean z, MarkData markData) {
        this.enh.aPs();
        this.emx.ie(z);
        if (this.dKY != null) {
            this.dKY.ad(z);
            if (markData != null) {
                this.dKY.a(markData);
            }
        }
        if (this.emx.nv()) {
            aMS();
        } else {
            this.enh.j(this.emx.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ob(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oO(String str) {
        if (!StringUtils.isNull(str) && this.emx != null) {
            String threadID = this.emx.getThreadID();
            String id = this.emx.getPbData().aLP().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(t.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData)) {
                if (!this.emx.aNR()) {
                    antiData.setBlock_forum_name(this.emx.getPbData().aLP().getName());
                    antiData.setBlock_forum_id(this.emx.getPbData().aLP().getId());
                    antiData.setUser_name(this.emx.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.emx.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.f.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.rG(i)) {
            AntiHelper.R(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            fI(str);
        } else {
            this.enh.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar, boolean z) {
        if (bVar != null) {
            this.enh.a(0, bVar.ub, bVar.fuO, z);
            if (bVar.ub) {
                if (bVar.fuM == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.q> aLR = this.emx.getPbData().aLR();
                    int size = aLR.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (!bVar.mPostId.equals(aLR.get(i).getId())) {
                                i++;
                            } else {
                                aLR.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.enh.j(this.emx.getPbData());
                } else if (bVar.fuM == 0) {
                    aMN();
                } else if (bVar.fuM == 2) {
                    boolean z2 = false;
                    ArrayList<com.baidu.tieba.tbadkCore.data.q> aLR2 = this.emx.getPbData().aLR();
                    int size2 = aLR2.size();
                    for (int i2 = 0; i2 < size2 && !z2; i2++) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 < aLR2.get(i2).biY().size()) {
                                if (!bVar.mPostId.equals(aLR2.get(i2).biY().get(i4).getId())) {
                                    i3 = i4 + 1;
                                } else {
                                    aLR2.get(i2).biY().remove(i4);
                                    aLR2.get(i2).bja();
                                    z2 = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData aMa = this.emx.getPbData().aMa();
                        com.baidu.tieba.tbadkCore.data.q qVar = aLR2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.data.q> bjb = qVar.bjb();
                        int size3 = bjb.size();
                        int i5 = 0;
                        while (true) {
                            if (i5 < size3) {
                                if (!bVar.mPostId.equals(aLR2.get(i2).bjb().get(i5).getId())) {
                                    i5++;
                                } else {
                                    bjb.remove(i5);
                                    aMa.decreaseAlreadyCount();
                                    if (qVar.bji() > bjb.size()) {
                                        qVar.rz(bjb.size());
                                    }
                                    if (bjb.size() > 0) {
                                        com.baidu.tieba.tbadkCore.data.q qVar2 = bjb.get(bjb.size() - 1);
                                        aMa.setLastAdditionTime(qVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a aAk = qVar2.aAk();
                                        String str = "";
                                        if (aAk != null) {
                                            str = aAk.toString();
                                        }
                                        aMa.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a aAk2 = qVar.aAk();
                                        String str2 = "";
                                        if (aAk2 != null) {
                                            str2 = aAk2.toString();
                                        }
                                        aMa.setLastAdditionContent(str2);
                                    }
                                    aMW();
                                    z2 = true;
                                }
                            }
                        }
                    }
                    if (z2) {
                        this.enh.j(this.emx.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, a.f fVar) {
        if (fVar != null) {
            this.enh.a(this.eng.getLoadDataMode(), fVar.ub, fVar.fuO, false);
            if (fVar.ub) {
                this.enj = true;
                if (i == 2 || i == 3) {
                    this.enk = true;
                    this.enl = false;
                } else if (i == 4 || i == 5) {
                    this.enk = false;
                    this.enl = true;
                }
                if (i == 2) {
                    this.emx.getPbData().aLQ().bW(1);
                    this.emx.setIsGood(1);
                } else if (i == 3) {
                    this.emx.getPbData().aLQ().bW(0);
                    this.emx.setIsGood(0);
                } else if (i == 4) {
                    this.emx.getPbData().aLQ().bV(1);
                    this.emx.oh(1);
                } else if (i == 5) {
                    this.emx.getPbData().aLQ().bV(0);
                    this.emx.oh(0);
                }
                this.enh.a(this.emx.getPbData(), this.emx.aNO(), true);
                com.baidu.tieba.c.a.a(getPageContext(), 2, i);
            }
        }
    }

    private void aMN() {
        if (this.emx.aNP()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.emx.getThreadID());
            setResult(-1, intent);
        }
        if (aMT()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMO() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.enh != null) {
            this.enh.aAE();
        }
        if (this.emx != null && this.emx.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.emx.getPbData().aLQ().getId();
            historyMessage.forumName = this.emx.getPbData().aLP().getName();
            historyMessage.threadName = this.emx.getPbData().aLQ().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aLR = this.emx.getPbData().aLR();
            int aPv = this.enh != null ? this.enh.aPv() : 0;
            if (aLR != null && aPv >= 0 && aPv < aLR.size()) {
                historyMessage.postID = aLR.get(aPv).getId();
            }
            historyMessage.isHostOnly = this.emx.getHostMode();
            historyMessage.isSquence = this.emx.aNO();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.ens != null) {
            this.ens.onDestroy();
        }
        if (this.emx != null && this.emx.aNP()) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.emx.getThreadID());
            if (this.enj) {
                if (this.enl) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.emx.aAv());
                }
                if (this.enk) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.emx.getIsGood());
                }
            }
            setResult(-1, intent);
        }
        if (aMT()) {
            if (this.emx != null && this.enh != null && this.enh.Os() != null) {
                com.baidu.tieba.pb.data.h pbData = this.emx.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.m9getInst().getDefaultBubble());
                    }
                    if (!pbData.aLW()) {
                        ep.aOQ().a(this.emx.getPbData(), this.enh.Os().onSaveInstanceState(), this.emx.aNO(), this.emx.getHostMode());
                    }
                }
            } else {
                ep.aOQ().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.enh != null && this.enh.aNG()) {
                    this.enh.aNI();
                    return true;
                }
                return super.onKeyDown(i, keyEvent);
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oc(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.ens.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aMR();
                    return;
                case 13008:
                    ep.aOQ().reset();
                    this.mHandler.postDelayed(new bc(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.emx != null) {
                        a(aMQ(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    w(intent);
                    return;
                case 24006:
                    v(intent);
                    return;
                case 24007:
                    if (aML() == 1) {
                        aMP();
                        return;
                    }
                    return;
                case 24008:
                    this.enh.hT(false);
                    if (this.emx.getPbData() != null && this.emx.getPbData().aLQ() != null && this.emx.getPbData().aLQ().rT() != null) {
                        this.emx.getPbData().aLQ().rT().setStatus(2);
                        break;
                    }
                    break;
                case 25001:
                    break;
                default:
                    return;
            }
            if (this.ena != null) {
                this.ena.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aMF() != null && aMB() != null && aMF().aOY() && com.baidu.tbadk.editortools.d.b.Dh().getStatus() == 1) {
                    com.baidu.tbadk.editortools.d.b.Dh().setStatus(0);
                    if (this.enh != null) {
                        this.enh.aOX();
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
    public void aMP() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.emx.getPbData() != null && this.emx.getPbData().aLQ() != null && this.emx.getPbData().aLQ().rL() != null && this.emx.getPbData().aLQ().rL().size() > 0 && this.emx.getPbData().aLQ().rL().get(0) != null) {
            this.mAwardActId = this.emx.getPbData().aLQ().rL().get(0).pb();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.h.b.c(this.emx.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void v(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra("key_action", 0)) {
                case 1:
                    agb();
                    return;
                case 2:
                    this.enh.aPg();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aMQ() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] aY = this.emx.getPbData().aY(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.data.q aOZ = this.enh.aOZ();
        String str = "";
        if (aOZ != null) {
            str = aOZ.getId();
            String bj = aOZ.bj(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(bj)) {
                aY[1] = bj;
            }
        }
        String rQ = this.emx.getPbData().aLQ().rQ();
        if (rQ != null && rQ.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(aY[1]);
        shareFromPBMsgData.setImageUrl(aY[0]);
        shareFromPBMsgData.setForumName(this.emx.getPbData().aLP().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.emx.getPbData().aLQ().getId());
        shareFromPBMsgData.setTitle(this.emx.getPbData().aLQ().getTitle());
        return shareFromPBMsgData;
    }

    private void w(Intent intent) {
        a(aMQ(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.emx != null && this.emx.getPbData() != null && this.emx.getPbData().aLQ() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gm gmVar = new gm(getPageContext().getPageActivity());
            gmVar.setData(shareFromPBMsgData);
            aVar.cb(1);
            aVar.z(gmVar);
            aVar.a(t.j.share, new bd(this, gmVar, j, str, str2, shareFromPBMsgData));
            aVar.b(t.j.alert_no_button, new be(this, gmVar));
            aVar.ar(true);
            aVar.b(getPageContext()).sX();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                gmVar.E(shareFromPBMsgData.getImageUrl(), this.emx.getPbData().aLY() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.emx != null && this.emx.getPbData() != null && this.emx.getPbData().aLQ() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gm gmVar = new gm(getPageContext().getPageActivity());
            gmVar.setData(shareFromPBMsgData);
            aVar.cb(1);
            aVar.z(gmVar);
            aVar.a(t.j.share, new bf(this, gmVar, i, str, j, shareFromPBMsgData));
            aVar.b(t.j.alert_no_button, new bg(this, gmVar));
            aVar.ar(true);
            aVar.b(getPageContext()).sX();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                gmVar.E(shareFromPBMsgData.getImageUrl(), this.emx.getPbData().aLY() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMR() {
        MarkData oo;
        if (this.dKY != null && (oo = this.emx.oo(this.enh.aPw())) != null) {
            if (!oo.isApp() || (oo = this.emx.oo(this.enh.aPw() + 1)) != null) {
                this.enh.aPp();
                this.dKY.a(oo);
                if (!this.dKY.nv()) {
                    this.dKY.nx();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.dKY.nw();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMS() {
        com.baidu.tieba.pb.data.h pbData = this.emx.getPbData();
        this.emx.ie(true);
        pbData.oK(this.dKY.nu());
        this.enh.j(pbData);
    }

    private boolean aMT() {
        if (this.emx == null) {
            return true;
        }
        if (this.emx.nv()) {
            MarkData aNZ = this.emx.aNZ();
            if (aNZ == null || !this.emx.getIsFromMark()) {
                return true;
            }
            MarkData oo = this.emx.oo(this.enh.aPw());
            if (oo == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aNZ);
                setResult(-1, intent);
                return true;
            } else if (oo.getPostId() == null || oo.getPostId().equals(aNZ.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aNZ);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cB(String.format(getPageContext().getString(t.j.alert_update_mark), Integer.valueOf(oo.getFloor())));
                aVar.a(t.j.alert_yes_btn, new bh(this, oo, aNZ, aVar));
                aVar.b(t.j.alert_no_button, new bi(this, aNZ, aVar));
                aVar.a(new bj(this, aNZ, aVar));
                aVar.b(getPageContext());
                aVar.sX();
                return false;
            }
        } else if (this.emx.getPbData() == null || this.emx.getPbData().aLR() == null || this.emx.getPbData().aLR().size() <= 0 || !this.emx.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: Os */
    public BdListView getListView() {
        if (this.enh == null) {
            return null;
        }
        return this.enh.Os();
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public int ID() {
        if (this.enh == null) {
            return 0;
        }
        return this.enh.aPC();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int wE() {
        if (this.enh == null) {
            return 0;
        }
        return this.enh.abF();
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<ImageView> IE() {
        if (this.aJm == null) {
            this.aJm = new com.baidu.adp.lib.f.b<>(new bk(this), 8, 0);
        }
        return this.aJm;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<TextView> IF() {
        if (this.aJn == null) {
            this.aJn = TbRichTextView.j(getPageContext().getPageActivity(), 8);
        }
        return this.aJn;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<GifView> IG() {
        if (this.aJr == null) {
            this.aJr = new com.baidu.adp.lib.f.b<>(new bm(this), 20, 0);
        }
        return this.aJr;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> IH() {
        if (this.aJp == null) {
            this.aJp = new com.baidu.adp.lib.f.b<>(new bn(this), 8, 0);
        }
        return this.aJp;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> IJ() {
        if (this.aJo == null) {
            this.aJo = com.baidu.tieba.graffiti.e.createGraffitiViewPool(getPageContext().getPageActivity(), 6);
        }
        return this.aJo;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> fz(int i) {
        if (this.aJs == null) {
            if (i == 1) {
                this.aJs = com.baidu.tieba.togetherhi.ds.createGraffitiViewPool(getPageContext().getPageActivity(), 6);
            } else {
                this.aJs = TogetherHiLivingView.createGraffitiViewPool(getPageContext().getPageActivity(), 6);
            }
        }
        return this.aJs;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> wF() {
        if (this.ahC == null) {
            this.ahC = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.ahC;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void A(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void B(Context context, String str) {
        gn.aQc().h(getPageContext(), str);
    }

    private com.baidu.tbadk.core.dialog.a aMU() {
        if (this.emU == null) {
            this.emU = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.emU.cA(getPageContext().getString(t.j.download_baidu_video_dialog));
            this.emU.a(getPageContext().getString(t.j.install), new bo(this));
            this.emU.b(getPageContext().getString(t.j.cancel), new bp(this));
            this.emU.aq(true);
            this.emU.b(getPageContext());
            this.emU.ar(false);
        }
        this.emU.sX();
        return this.emU;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void C(Context context, String str) {
        gn.aQc().h(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void E(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra(VrPlayerActivityConfig.TITLE, "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            aMU();
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
            com.baidu.tieba.pb.data.h pbData = this.emx.getPbData();
            com.baidu.tbadk.widget.richText.a az = az(str, i);
            if (az != null && (cVar = az.Ia().get(this.enQ)) != null) {
                bVar.eoq = new ArrayList<>();
                bVar.eor = new ConcurrentHashMap<>();
                if (!cVar.If().Is()) {
                    bVar.eot = false;
                    String c2 = com.baidu.tieba.pb.data.i.c(cVar);
                    bVar.eoq.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(cVar);
                    imageUrlData.originalSize = e(cVar);
                    imageUrlData.postId = az.getPostId();
                    imageUrlData.mIsReserver = this.emx.aNY();
                    imageUrlData.mIsSeeHost = this.emx.getHostMode();
                    bVar.eor.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aLP() != null) {
                            bVar.forumName = pbData.aLP().getName();
                            bVar.forumId = pbData.aLP().getId();
                        }
                        if (pbData.aLQ() != null) {
                            bVar.threadId = pbData.aLQ().getId();
                        }
                        bVar.eos = pbData.aLY() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.eot = true;
                int size = pbData.aLR().size();
                this.enR = false;
                bVar.index = -1;
                int i2 = i;
                for (int i3 = 0; i3 < size; i3++) {
                    com.baidu.tieba.tbadkCore.data.q qVar = pbData.aLR().get(i3);
                    com.baidu.tbadk.widget.richText.a aAk = qVar.aAk();
                    if (!ew.g(qVar)) {
                        a2 = a(aAk, az, i2, i, bVar.eoq, bVar.eor);
                    } else {
                        a2 = a(qVar, i2, bVar.eoq, bVar.eor);
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.q> bjb = qVar.bjb();
                    i2 = a2;
                    for (int i4 = 0; i4 < bjb.size(); i4++) {
                        i2 = a(bjb.get(i4).aAk(), az, i2, i, bVar.eoq, bVar.eor);
                    }
                }
                if (bVar.eoq.size() > 0) {
                    bVar.lastId = bVar.eoq.get(bVar.eoq.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aLP() != null) {
                        bVar.forumName = pbData.aLP().getName();
                        bVar.forumId = pbData.aLP().getId();
                    }
                    if (pbData.aLQ() != null) {
                        bVar.threadId = pbData.aLQ().getId();
                    }
                    bVar.eos = pbData.aLY() == 1;
                }
                bVar.index = i2;
            }
        }
    }

    private String d(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.If() == null) {
            return null;
        }
        return cVar.If().Iw();
    }

    private long e(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.If() == null) {
            return 0L;
        }
        return cVar.If().getOriginalSize();
    }

    private int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.g If;
        if (aVar == aVar2) {
            this.enR = true;
        }
        if (aVar != null) {
            int size = aVar.Ia().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.Ia().get(i6) == null || aVar.Ia().get(i6).getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int width = aVar.Ia().get(i6).If().getWidth();
                    int height = aVar.Ia().get(i6).If().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.Ia().get(i6).If().Is()) {
                        if (aVar == aVar2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.Ia().get(i6);
                        String c2 = com.baidu.tieba.pb.data.i.c(cVar);
                        if (!TextUtils.isEmpty(c2)) {
                            arrayList.add(c2);
                            if (cVar != null && (If = cVar.If()) != null) {
                                String Iu = If.Iu();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = Iu;
                                int i9 = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.urlType = i9;
                                imageUrlData.urlType = i9;
                                imageUrlData.originalUrl = d(cVar);
                                imageUrlData.originalSize = e(cVar);
                                imageUrlData.postId = aVar.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.h.b.c(this.emx.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.emx.aNY();
                                imageUrlData.mIsSeeHost = this.emx.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.enR) {
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

    private int a(com.baidu.tieba.tbadkCore.data.q qVar, int i, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        ArrayList<com.baidu.tieba.tbadkCore.data.k> biG;
        if (qVar != null && arrayList != null && concurrentHashMap != null && (biG = qVar.bjm().biG()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == biG.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = biG.get(i3);
                if (kVar != null) {
                    String biN = kVar.biN();
                    if (!com.baidu.tbadk.core.util.ba.isEmpty(biN)) {
                        arrayList.add(biN);
                        if (!this.enR) {
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
    public void d(com.baidu.tieba.tbadkCore.data.q qVar) {
        if (qVar != null) {
            boolean z = false;
            if (qVar.getId() != null && qVar.getId().equals(this.emx.rJ())) {
                z = true;
            }
            MarkData e = this.emx.e(qVar);
            if (e != null) {
                this.enh.aPp();
                if (this.dKY != null) {
                    this.dKY.a(e);
                    if (!z) {
                        this.dKY.nx();
                    } else {
                        this.dKY.nw();
                    }
                }
            }
        }
    }

    private com.baidu.tbadk.widget.richText.a az(String str, int i) {
        if (this.emx == null || this.emx.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.h pbData = this.emx.getPbData();
        com.baidu.tbadk.widget.richText.a a2 = a(pbData.aLR(), str, i);
        if (a2 == null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aLR = pbData.aLR();
            int size = aLR.size();
            for (int i2 = 0; i2 < size; i2++) {
                a2 = a(aLR.get(i2).bjb(), str, i);
                if (a2 != null) {
                    return a2;
                }
            }
            return a2;
        }
        return a2;
    }

    private long oP(String str) {
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aLR;
        com.baidu.tieba.pb.data.h pbData = this.emx.getPbData();
        if (pbData != null && (aLR = pbData.aLR()) != null && !aLR.isEmpty()) {
            Iterator<com.baidu.tieba.tbadkCore.data.q> it = aLR.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.q next = it.next();
                com.baidu.tieba.tbadkCore.data.i bjm = next.bjm();
                if (bjm != null && bjm.fsh) {
                    Iterator<com.baidu.tbadk.widget.richText.c> it2 = next.aAk().Ia().iterator();
                    while (it2.hasNext()) {
                        com.baidu.tbadk.widget.richText.c next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.In().getLink().equals(str)) {
                            return bjm.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> Ia;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a aAk = arrayList.get(i2).aAk();
            if (aAk != null && (Ia = aAk.Ia()) != null) {
                int size = Ia.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Ia.get(i4) != null && Ia.get(i4).getType() == 8) {
                        i3++;
                        if (Ia.get(i4).If().Iu().equals(str)) {
                            int width = Ia.get(i4).If().getWidth();
                            int height = Ia.get(i4).If().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.enQ = i4;
                            return aAk;
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
            this.emv = str;
            if (this.emT == null) {
                aMI();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.emT.cg(1).setVisibility(8);
            } else {
                this.emT.cg(1).setVisibility(0);
            }
            this.emT.ta();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bQi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ug() {
        hideNetRefreshView(this.enh.getView());
        aMV();
        if (this.emx.Fa()) {
            this.enh.aPp();
        }
    }

    private void aMV() {
        showLoadingView(this.enh.getView(), false, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds400));
        View EA = getLoadingView().EA();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EA.getLayoutParams();
        layoutParams.addRule(3, this.enh.aPU().getId());
        EA.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaO() {
        if (this.bQi != null) {
            this.bQi.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void od(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agb() {
        if (this.emx.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.h pbData = this.emx.getPbData();
            String name = pbData.aLP().getName();
            String title = pbData.aLQ().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.emx.getThreadID() + "?share=9105&fr=share";
            String[] aY = pbData.aY(getPageContext().getPageActivity());
            String str2 = aY[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = aY[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (aML() == 1) {
                if (pbData != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10399").ab("fid", pbData.getForumId()).ab("tid", pbData.getThreadId()).ab("uid", currentAccount));
                }
            } else if (aML() == 2 && pbData != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10406").ab("fid", pbData.getForumId()).ab("tid", pbData.getThreadId()).ab("uid", currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(t.j.share_content_tpl), title, name, str3);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.linkUrl = str;
            fVar.ank = true;
            fVar.extData = this.emx.getThreadID();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(t.j.share_tieba_qunzu, t.f.icon_unite_share_qunzu, new bq(this));
            shareDialogConfig.addOutsideTextView(t.j.forum_friend, t.f.icon_unite_share_baf, new br(this));
            shareDialogConfig.setCopyLinkListener(new bs(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<LinearLayout> II() {
        if (this.aJq == null) {
            this.aJq = new com.baidu.adp.lib.f.b<>(new bt(this), 15, 0);
        }
        return this.aJq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMW() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.pb.data.h pbData = this.emx.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.qf().isIfAddition();
            AdditionData aMa = pbData.aMa();
            boolean z3 = aMa == null ? false : isIfAddition;
            if (z3) {
                z = aMa.getAlreadyCount() != aMa.getTotalCount();
                if (!TextUtils.isEmpty(aMa.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.pb.main.b.e eVar = this.enh.erX;
            if (!z3 || !z) {
                z2 = false;
            }
            eVar.iE(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.enh.aPi() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10517").s("obj_locate", 2).ab("fid", this.emx.getPbData().getForumId()));
            } else {
                com.baidu.tbadk.core.data.bg aLQ = this.emx.getPbData().aLQ();
                if (view != null) {
                    boolean z = aLQ.rt() == null || aLQ.rt().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.ekS > 1000) {
                            this.ekT = true;
                            aU(view);
                        } else {
                            this.ekT = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            e(view, this.ekT);
                        } else {
                            d(view, this.ekT);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        d(view, this.ekT);
                    } else if (motionEvent.getAction() == 3) {
                        d(view, this.ekT);
                    }
                }
            }
        }
        return false;
    }

    private void d(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), t.a.praise_animation_scale2));
            new Handler().postDelayed(new bv(this), 200L);
        }
    }

    private void e(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), t.a.praise_animation_scale3));
            new Handler().postDelayed(new bw(this), 600L);
        }
    }

    private void aU(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), t.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void aaQ() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, 11017)));
        } else if (aVar.sZ() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.sZ();
            int intValue = ((Integer) sparseArray.get(ex.etQ)).intValue();
            if (intValue == ex.etR) {
                if (!this.eng.bjS()) {
                    this.enh.aPm();
                    int intValue2 = ((Integer) sparseArray.get(t.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(t.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(t.g.tag_del_post_type)).intValue();
                    this.eng.a(this.emx.getPbData().aLP().getId(), this.emx.getPbData().aLP().getName(), this.emx.getPbData().aLQ().getId(), (String) sparseArray.get(t.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == ex.etS || intValue == ex.etU) {
                if (this.emx.aOl() != null) {
                    this.emx.aOl().og(dh.eph);
                }
                if (intValue == ex.etS) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == ex.etT) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.enV).oW()));
            }
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (sparseArray.get(t.g.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(t.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(t.g.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(t.g.tag_user_mute_thread_id);
        }
        if (sparseArray.get(t.g.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(t.g.tag_user_mute_post_id);
        }
        if (sparseArray.get(t.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(t.g.tag_user_mute_msg);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.enx);
        userMuteAddAndDelCustomMessage.setTag(this.enx);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean oQ(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bn.al(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.tS().getString("bubble_link", ""))) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(t.j.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void hX(boolean z) {
        this.enq = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aMX() {
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aLR;
        int s;
        if (this.emx == null || this.emx.getPbData() == null || this.emx.getPbData().aLR() == null || (s = com.baidu.tbadk.core.util.y.s((aLR = this.emx.getPbData().aLR()))) == 0) {
            return "";
        }
        int aPv = this.enh.aPv();
        com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(aLR, aPv);
        if (qVar == null || qVar.getAuthor() == null) {
            return "";
        }
        if (this.emx.oV(qVar.getAuthor().getUserId())) {
            return qVar.getId();
        }
        for (int i = aPv - 1; i != 0; i--) {
            com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(aLR, i);
            if (qVar2 == null || qVar2.getAuthor() == null || qVar2.getAuthor().getUserId() == null) {
                break;
            } else if (this.emx.oV(qVar2.getAuthor().getUserId())) {
                return qVar2.getId();
            }
        }
        for (int i2 = aPv + 1; i2 < s; i2++) {
            com.baidu.tieba.tbadkCore.data.q qVar3 = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(aLR, i2);
            if (qVar3 == null || qVar3.getAuthor() == null || qVar3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.emx.oV(qVar3.getAuthor().getUserId())) {
                return qVar3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void F(Context context, String str) {
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bi.vx().c(getPageContext(), new String[]{str})) {
            com.baidu.tieba.pb.b.a(oP(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.emx.getPbData().aLP().getId(), this.emx.getPbData().aLP().getName(), this.emx.getPbData().aLQ().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, String str2, String str3, String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cB(getResources().getString(t.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cB(getResources().getString(t.j.make_sure_hide));
        }
        aVar.a(getResources().getString(t.j.alert_yes_button), new bx(this, j, str, str2, str3, str4));
        aVar.b(getResources().getString(t.j.alert_no_button), new by(this, j, str, str2, str3, str4));
        aVar.ar(false);
        aVar.b(getPageContext());
        aVar.sX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b oR(String str) {
        String str2;
        if (this.emx.getPbData() == null || this.emx.getPbData().aLR() == null || this.emx.getPbData().aLR().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i < this.emx.getPbData().aLR().size()) {
                if (str.equals(this.emx.getPbData().aLR().get(i).getId())) {
                    break;
                }
                i++;
            } else {
                i = 0;
                break;
            }
        }
        com.baidu.tieba.tbadkCore.data.q qVar = this.emx.getPbData().aLR().get(i);
        if (qVar.aAk() == null || qVar.aAk().Ia() == null) {
            return null;
        }
        Iterator<com.baidu.tbadk.widget.richText.c> it = qVar.aAk().Ia().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.If() != null) {
                    str2 = next.If().Iu();
                }
            }
        }
        a(str2, 0, bVar);
        com.baidu.tieba.pb.data.i.a(qVar, bVar);
        return bVar;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.emQ) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.emQ = false;
        } else if (aMY()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.emQ) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.emQ = false;
        } else if (aMY()) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void hY(boolean z) {
        this.ent = z;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a005";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.emx != null) {
            if (this.emx.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(this.emx.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.h.b.c(this.emx.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aMY() {
        return (!this.emO && this.enX == -1 && this.enY == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            this.eoa = mVar;
            this.emO = true;
            this.enh.aPa();
            this.enh.pa(this.enZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMZ() {
        if (this.eoa != null) {
            if (this.enX == -1) {
                showToast(t.j.pb_manga_not_prev_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eoa.getCartoonId(), this.enX, 0)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNa() {
        if (this.eoa != null) {
            if (this.enY == -1) {
                showToast(t.j.pb_manga_not_next_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eoa.getCartoonId(), this.enY, 0)));
            finish();
        }
    }

    public int aNb() {
        return this.enX;
    }

    public int aNc() {
        return this.enY;
    }

    private void aot() {
        if (this.emx != null && this.emx.getPbData() != null && this.emx.getPbData().aLQ() != null && this.emx.getPbData().aLQ().sn()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNd() {
        if (this.emx != null && this.emx.getPbData() != null && this.emx.getPbData().aLQ() != null && this.emx.getPbData().aLQ().sn()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aNe() {
        if (this.emR) {
            this.ene = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.emx.getPbData() != null && this.emx.getPbData().aLQ() != null && this.emx.getPbData().aLQ().rl() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.emx.getPbData().aLQ().rl().getThreadId(), this.emx.getPbData().aLQ().rl().getTaskId(), this.emx.getPbData().aLQ().rl().getForumId(), this.emx.getPbData().aLQ().rl().getForumName(), this.emx.getPbData().aLQ().rx(), this.emx.getPbData().aLQ().ry())));
            this.emQ = true;
            finish();
        }
    }

    public boolean aNf() {
        return this.emR;
    }

    public String aNg() {
        return this.enb;
    }

    public PbInterviewStatusView.a aNh() {
        return this.enf;
    }

    public void hZ(boolean z) {
        this.enc = z;
    }

    public boolean aNi() {
        if (this.emx != null) {
            return this.emx.aNP();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNj() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cB(getResources().getString(t.j.mute_is_super_member_function));
        aVar.a(t.j.open_now, new bz(this));
        aVar.b(t.j.cancel, new ca(this));
        aVar.b(this.env).sX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fI(String str) {
        if (str == null) {
            str = "";
        }
        if (this.env != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.env.getPageActivity());
            aVar.cB(str);
            aVar.b(t.j.know, new cb(this));
            aVar.b(this.env).sX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.enh.ayk();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.env.getPageActivity());
        if (com.baidu.tbadk.core.util.ba.isEmpty(str)) {
            aVar.cB(this.env.getResources().getString(t.j.block_mute_message_alert, str2));
        } else {
            aVar.cB(str);
        }
        aVar.a(t.j.confirm, new cc(this, userMuteAddAndDelCustomMessage));
        aVar.b(t.j.cancel, new cd(this));
        aVar.b(this.env).sX();
    }
}
