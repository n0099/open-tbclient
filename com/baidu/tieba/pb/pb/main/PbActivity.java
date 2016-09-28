package com.baidu.tieba.pb.pb.main;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
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
import com.baidu.tbadk.core.view.y;
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
import com.baidu.tieba.d.a;
import com.baidu.tieba.d.c;
import com.baidu.tieba.pb.pb.main.a.f;
import com.baidu.tieba.pb.pb.main.cq;
import com.baidu.tieba.pb.pb.main.ct;
import com.baidu.tieba.pb.pb.main.dh;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.d.a;
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
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.b, com.baidu.tbadk.widget.richText.m {
    private com.baidu.adp.lib.f.b<ImageView> aIL;
    private com.baidu.adp.lib.f.b<TextView> aIM;
    private com.baidu.adp.lib.f.b<View> aIN;
    private com.baidu.adp.lib.f.b<View> aIO;
    private com.baidu.adp.lib.f.b<LinearLayout> aIP;
    private com.baidu.adp.lib.f.b<GifView> aIQ;
    private com.baidu.adp.lib.f.b<View> aIR;
    private com.baidu.adp.lib.f.b<TbImageView> ahk;
    private com.baidu.tieba.d.c bPA;
    private com.baidu.tbadk.e.a bPH;
    private VoiceManager bQb;
    private com.baidu.tieba.pb.pb.main.a.f eoN;
    private com.baidu.tbadk.core.dialog.a eoS;
    private com.baidu.tieba.pb.pb.main.b eoY;
    private String eot;
    private boolean epN;
    private String epY;
    private com.baidu.tbadk.core.data.m epZ;
    private Cdo epj;
    private boolean epn;
    private com.baidu.tieba.tbadkCore.data.f epo;
    private com.baidu.tbadk.editortools.e.e epp;
    private com.baidu.adp.base.h eps;
    private com.baidu.tbadk.core.view.h ept;
    private BdUniqueId epu;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean eoM = false;
    private boolean eoO = false;
    private boolean eoP = false;
    private boolean dQG = false;
    private int eoQ = 0;
    private com.baidu.tbadk.core.dialog.c eoR = null;
    private long bGX = -1;
    private long aBU = 0;
    private long eoT = 0;
    private long createTime = 0;
    private long aBM = 0;
    private boolean eoU = false;
    private com.baidu.tbadk.performanceLog.e eoV = null;
    private long eoW = 0;
    private boolean eoX = false;
    private String avP = null;
    private String eoZ = "";
    private boolean epa = true;
    private boolean epb = false;
    private String source = "";
    private PbInterviewStatusView.a epc = new i(this);
    private final Handler mHandler = new Handler(new t(this));
    private String mForumId = null;
    private String mThreadId = null;
    private dh eov = null;
    private com.baidu.tbadk.baseEditMark.a dMU = null;
    private com.baidu.tieba.tbadkCore.f.a epd = null;
    private ex epe = null;
    public final com.baidu.tieba.pb.pb.main.a.a epf = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean epg = false;
    private boolean eph = false;
    private boolean epi = false;
    private boolean epk = false;
    private boolean epl = false;
    private boolean epm = false;
    private boolean bOT = false;
    private boolean epq = false;
    private com.baidu.tbadk.editortools.e.c avT = new ae(this);
    private boolean epr = false;
    private int cKh = -1;
    private final CustomMessageListener epv = new ap(this, CmdConfigCustom.PB_RESET_EDITOR_TOOL);
    CustomMessageListener bPQ = new ba(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private CustomMessageListener ciO = new bl(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener dxZ = new bu(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener dyw = new ce(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener epw = new cf(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener aJG = new j(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
    private CustomMessageListener cVP = new k(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private HttpMessageListener bnU = new l(this, CmdConfigHttp.PB_ECOMM_RECOMMEND_HTTP_CMD);
    private cq.a epx = new m(this);
    private View.OnClickListener dxY = new n(this);
    private CustomMessageListener epy = new o(this, CmdConfigCustom.CMD_SEND_GIFT_SUCCESS);
    private boolean epz = false;
    private com.baidu.tieba.tbadkCore.ai bQa = new com.baidu.tieba.tbadkCore.ai(getPageContext(), new p(this));
    private long epA = 0;
    private boolean epB = true;
    private f.a epC = new q(this);
    private CustomMessageListener bnV = new r(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener epD = new s(this, CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED);
    private com.baidu.tieba.pb.a.d emU = new com.baidu.tieba.pb.a.d(new u(this));
    private CustomMessageListener epE = new v(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener epF = new w(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener epG = new x(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    public a.b dZi = new y(this);
    public final View.OnClickListener bRx = new z(this);
    private final b.d avZ = new aa(this);
    private final dh.a epH = new ab(this);
    private CustomMessageListener epI = new ac(this, CmdConfigCustom.CMD_WX_SHARE_SUCCESS);
    private CustomMessageListener epJ = new ad(this, CmdConfigCustom.CMD_TTS_OPTION_PB);
    private final a.InterfaceC0032a epK = new af(this);
    private final AbsListView.OnScrollListener BL = new ag(this);
    private final com.baidu.adp.base.g epL = new ah(this);
    private final c epM = new ai(this);
    private final y.b aUZ = new aj(this);
    private final BdListView.e epO = new ak(this);
    private int epP = 0;
    private final TbRichTextView.e aJh = new al(this);
    boolean epQ = false;
    com.baidu.tieba.tbadkCore.data.q epR = null;
    private final c.b epS = new am(this);
    private final View.OnLongClickListener anY = new an(this);
    private final NoNetworkView.a aRn = new ao(this);
    public View.OnTouchListener aJD = new aq(this);
    private a.InterfaceC0058a aMy = new ar(this);
    private final c.a epT = new as(this);
    private String epU = null;
    private final ct.a epV = new at(this);
    private int epW = -1;
    private int epX = -1;
    private final CustomMessageListener bPT = new au(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> eqo;
        public ConcurrentHashMap<String, ImageUrlData> eqp;
        public boolean eqr;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean eqq = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes.dex */
    public interface c {
        void id(boolean z);
    }

    public void hV(boolean z) {
        this.eoX = z;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.e.e aNg() {
        return this.epp;
    }

    public void b(com.baidu.tieba.pb.data.n nVar) {
        if (nVar.aMN() != null) {
            String id = nVar.aMN().getId();
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aMt = this.eov.getPbData().aMt();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aMt.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.q qVar = aMt.get(i2);
                if (qVar.getId() == null || !qVar.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.data.q> aMR = nVar.aMR();
                    qVar.rL(nVar.getTotalCount());
                    if (qVar.bjK() != null) {
                        qVar.bjK().clear();
                        qVar.bjK().addAll(aMR);
                    }
                }
            }
            this.epe.j(this.eov.getPbData());
        }
    }

    public void aNh() {
        com.baidu.tieba.pb.data.h pbData;
        com.baidu.tbadk.core.data.bi aMs;
        if (!this.epz) {
            if (!com.baidu.adp.lib.util.k.gD()) {
                showToast(r.j.no_network_guide);
            } else if (this.epB) {
                this.epz = true;
                if (this.eov != null && (pbData = this.eov.getPbData()) != null && (aMs = pbData.aMs()) != null) {
                    int isLike = aMs.rF() == null ? 0 : aMs.rF().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c10796").ab("tid", aMs.getId()));
                    }
                    if (this.bQa != null) {
                        this.bQa.a(aMs.sc(), aMs.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        String string;
        if ((sparseArray.get(r.g.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(r.g.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(r.g.tag_check_mute_from) instanceof Integer)) {
            String str = (String) sparseArray.get(r.g.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(r.g.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(r.g.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
                cVar.cc(r.j.operation);
                int i = -1;
                if (sparseArray.get(r.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(r.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(r.j.delete);
                    if (z) {
                        string = getResources().getString(r.j.un_mute);
                    } else {
                        string = getResources().getString(r.j.mute);
                    }
                    strArr[1] = string;
                    cVar.a(strArr, new av(this, sparseArray, z, str2, str));
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(r.j.un_mute) : getResources().getString(r.j.mute);
                    cVar.a(strArr2, new aw(this, sparseArray, z, str2, str));
                }
                cVar.d(getPageContext()).tp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hS(int i) {
        com.baidu.tbadk.core.data.bi aMs;
        String sb;
        String z;
        if (this.eov != null && this.eov.getPbData() != null && (aMs = this.eov.getPbData().aMs()) != null) {
            if (i == 1) {
                PraiseData rF = aMs.rF();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rF == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aMs.a(praiseData);
                    } else {
                        aMs.rF().getUser().add(0, metaData);
                        aMs.rF().setNum(aMs.rF().getNum() + 1);
                        aMs.rF().setIsLike(i);
                    }
                }
                if (aMs.rF() != null) {
                    if (aMs.rF().getNum() < 1) {
                        z = getResources().getString(r.j.frs_item_praise_text);
                    } else {
                        z = com.baidu.tbadk.core.util.az.z(aMs.rF().getNum());
                    }
                    this.epe.N(z, true);
                }
            } else if (aMs.rF() != null) {
                aMs.rF().setIsLike(i);
                aMs.rF().setNum(aMs.rF().getNum() - 1);
                ArrayList<MetaData> user = aMs.rF().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aMs.rF().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aMs.rF().getNum() < 1) {
                    sb = getResources().getString(r.j.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(aMs.rF().getNum())).toString();
                }
                this.epe.N(sb, false);
            }
            if (this.eov.aOw()) {
                this.epe.aPS().notifyDataSetChanged();
            } else {
                this.epe.k(this.eov.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().akE && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().akC && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.tieba.tbadkCore.data.q a2;
        if (this.eov != null && this.eov.getPbData() != null && (a2 = com.baidu.tieba.pb.data.i.a(this.eov.getPbData(), this.eov.aOw(), this.eov.aOL())) != null) {
            com.baidu.tieba.pb.data.i.a(a2, updateAttentionMessage);
            if (this.epe != null && this.eov != null) {
                this.epe.c(this.eov.getPbData(), this.eov.aOw(), this.eov.aOL());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bPH == null) {
                this.bPH = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bPH.ap(updateAttentionMessage.getData().toUid, this.eov.getPbData().getForumId());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eov.n(bundle);
        if (this.bQb != null) {
            this.bQb.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.epp.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eps = getPageContext();
        Intent intent = getIntent();
        if (intent != null) {
            this.bGX = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.eoZ = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.eoZ)) {
                this.eoO = true;
            }
            this.epW = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.epX = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.epY = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            if (aNE()) {
                setUseStyleImmersiveSticky(false);
            }
            this.epl = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.az.isEmpty(this.source) ? "" : this.source;
        } else {
            this.bGX = System.currentTimeMillis();
        }
        this.eoT = System.currentTimeMillis();
        this.aBM = this.eoT - this.bGX;
        super.onCreate(bundle);
        this.eoQ = 0;
        p(bundle);
        if (this.eov != null && this.eov.getPbData() != null) {
            this.eov.getPbData().hm(this.source);
        }
        initUI();
        if (intent != null && this.epe != null) {
            this.epe.eud = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
        }
        this.bQb = new VoiceManager();
        this.bQb.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.e.n nVar = new com.baidu.tbadk.editortools.e.n();
        nVar.setForumName(this.eov.aOv());
        if (this.eov.getPbData() != null && this.eov.getPbData().aMr() != null) {
            nVar.setForumId(this.eov.getPbData().aMr().getId());
        }
        nVar.setFrom("pb");
        nVar.a(this.eov);
        this.epp = (com.baidu.tbadk.editortools.e.e) nVar.an(getActivity());
        this.epp.d(this);
        this.epp.a(this.avZ);
        this.epp.a(this.avT);
        this.epp.a(this, bundle);
        this.epp.CG().c(new com.baidu.tbadk.editortools.z(getActivity()));
        this.epp.CG().by(true);
        hX(true);
        this.epe.setEditorTools(this.epp.CG());
        this.epp.a(this.eov.aOC(), this.eov.getThreadID(), this.eov.aOs());
        registerListener(this.dxZ);
        registerListener(this.bnU);
        if (!this.eov.aOz()) {
            this.epp.fG(this.eov.getThreadID());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.eoT;
        registerListener(this.ciO);
        registerListener(this.dyw);
        registerListener(this.epw);
        registerListener(this.aJG);
        registerListener(this.bPQ);
        registerListener(this.epv);
        this.epo = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.fuF);
        this.epo.bjo();
        registerListener(this.epy);
        registerListener(this.bnV);
        if (this.eov != null) {
            this.eov.aON();
        }
        if (TbadkCoreApplication.m9getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.epD);
        registerListener(this.epJ);
        registerListener(this.epI);
        this.eoY = new com.baidu.tieba.pb.pb.main.b(this.eov, this);
        if (this.epe != null && this.epe.aQD() != null && this.epe.aQE() != null) {
            this.eoN = new com.baidu.tieba.pb.pb.main.a.f(getActivity(), this.epe.aQD(), this.epe.aQE());
            this.eoN.a(this.epC);
            this.eoN.iG(this.epe.aQJ());
        }
        if (aNE() && this.epe != null && this.epe.aQE() != null) {
            this.epe.aQE().setVisibility(8);
        }
        this.ept = new com.baidu.tbadk.core.view.h();
        this.ept.aeT = 1000L;
        registerListener(this.epG);
        registerListener(this.epE);
        registerListener(this.epF);
        this.epu = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.epu;
        userMuteAddAndDelCustomMessage.setTag(this.epu);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.epu;
        userMuteCheckCustomMessage.setTag(this.epu);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public String aNi() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.f aNj() {
        return this.eoN;
    }

    private void hX(boolean z) {
        this.epp.bB(z);
        this.epp.bC(z);
        this.epp.bD(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
        if (this.epp != null && this.epp.CG() != null) {
            this.epp.CG().CS();
        }
        if (this.epe != null) {
            this.epe.CS();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bQb != null) {
            this.bQb.onStart(getPageContext());
        }
    }

    public ex aNk() {
        return this.epe;
    }

    public dh aNl() {
        return this.eov;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.m9getInst().isReadMenuDialogOnTop()) {
            this.eoP = false;
        } else {
            this.eoP = true;
        }
        super.onPause();
        if (this.epe.aPD() != null && this.epe.aPD().aNd() != null) {
            this.epe.aPD().aNd().onPause();
        }
        BdListView listView = getListView();
        this.eoQ = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.eoQ == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.bQb != null) {
            this.bQb.onPause(getPageContext());
        }
        if (this.epe != null) {
            this.epe.onPause();
        }
        if (!this.eov.aOz()) {
            this.epp.fF(this.eov.getThreadID());
        }
        if (this.eov != null) {
            this.eov.aOO();
        }
        MessageManager.getInstance().unRegisterListener(this.cVP);
        aoH();
        MessageManager.getInstance().unRegisterListener(this.epE);
        MessageManager.getInstance().unRegisterListener(this.epF);
        MessageManager.getInstance().unRegisterListener(this.epG);
        MessageManager.getInstance().unRegisterListener(this.bPT);
    }

    private boolean aNm() {
        com.baidu.tieba.tbadkCore.data.q a2 = com.baidu.tieba.pb.data.i.a(this.eov.getPbData(), this.eov.aOw(), this.eov.aOL());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eoP = false;
        super.onResume();
        if (this.epb) {
            this.epb = false;
            aNK();
        }
        if (this.epe.aPD() != null && this.epe.aPD().aNd() != null) {
            this.epe.aPD().aNd().onResume();
        }
        if (aNm()) {
            this.eoW = System.currentTimeMillis();
        } else {
            this.eoW = -1L;
        }
        if (this.epe != null && this.epe.getView() != null) {
            if (!this.dQG) {
                aNB();
            } else {
                hideLoadingView(this.epe.getView());
            }
            this.epe.onResume();
        }
        if (this.eoQ == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.epe != null) {
            noNetworkView = this.epe.aPE();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.gm()) {
            noNetworkView.aG(false);
        }
        if (this.bQb != null) {
            this.bQb.onResume(getPageContext());
        }
        registerListener(this.cVP);
        this.epn = false;
        aNJ();
        registerListener(this.epE);
        registerListener(this.epF);
        registerListener(this.epG);
        registerListener(this.bPT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.epe.is(z);
        if (this.epj != null) {
            this.epj.ij(z);
        }
        if (z && this.epn) {
            this.epe.aPZ();
            this.eov.m17if(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eoW > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c10804").ab("obj_duration", new StringBuilder(String.valueOf(System.currentTimeMillis() - this.eoW)).toString()));
            this.eoW = 0L;
        }
        if (this.epp != null && this.epp.CG() != null && this.epp.CG().getVisibility() != 0) {
            this.epp.Du();
        }
        if (this.epe.eug != null && !this.epe.eug.aQQ()) {
            this.epe.eug.aBt();
        }
        if (this.eov != null && this.eov.getPbData() != null && this.eov.getPbData().aMr() != null && this.eov.getPbData().aMs() != null) {
            com.baidu.tbadk.distribute.a.Cp().b(getPageContext().getPageActivity(), "pb", this.eov.getPbData().aMr().getId(), com.baidu.adp.lib.h.b.c(this.eov.getPbData().aMs().getId(), 0L));
        }
        if (this.bQb != null) {
            this.bQb.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eoY != null) {
            this.eoY.destroy();
        }
        if (this.epk && this.eov != null) {
            a(this.eov.getPbData(), -2, 0, false, false);
        }
        if (!this.eoU && this.epe != null) {
            this.eoU = true;
            this.epe.aQt();
            aNn();
        }
        if (this.eov != null) {
            this.eov.cancelLoadData();
            this.eov.destory();
        }
        if (this.epp != null) {
            this.epp.onDestroy();
        }
        if (this.epd != null) {
            this.epd.cancelLoadData();
        }
        if (this.epe != null) {
            this.epe.onDestroy();
            if (this.epe.eug != null) {
                this.epe.eug.aBt();
            }
        }
        if (this.eoV != null) {
            this.eoV.onDestroy();
        }
        if (this.eoN != null) {
            this.eoN.Za();
        }
        super.onDestroy();
        if (this.bQb != null) {
            this.bQb.onDestory(getPageContext());
        }
        if (this.bPH != null) {
            this.bPH.destory();
        }
        this.epe.aBc();
        MessageManager.getInstance().unRegisterListener(this.epE);
        MessageManager.getInstance().unRegisterListener(this.epF);
        MessageManager.getInstance().unRegisterListener(this.epG);
        MessageManager.getInstance().unRegisterListener(this.epu);
        this.eps = null;
        this.ept = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNn() {
        cj aPS;
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aNW;
        String str;
        String str2;
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xB() && this.epe != null && (aPS = this.epe.aPS()) != null && (aNW = aPS.aNW()) != null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (com.baidu.tieba.tbadkCore.data.q qVar : aNW) {
                String id = qVar.getId();
                i++;
                if (qVar.Ue == 1 && !TextUtils.isEmpty(id)) {
                    qVar.Ue = 2;
                    a.b bVar = new a.b();
                    bVar.bKQ = id;
                    bVar.bbO = i;
                    arrayList.add(bVar);
                }
            }
            if (arrayList.size() > 0) {
                if (this.eov == null || this.eov.getPbData() == null || this.eov.getPbData().aMr() == null) {
                    str = null;
                    str2 = null;
                } else {
                    String first_class = this.eov.getPbData().aMr().getFirst_class();
                    str = this.eov.getPbData().aMr().getSecond_class();
                    str2 = first_class;
                }
                com.baidu.tieba.recapp.g.sendPB(str2, str, this.mForumId, this.mThreadId, arrayList, adAdSense.xC());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.epe.onChangeSkinType(i);
        if (this.epp != null && this.epp.CG() != null) {
            this.epp.CG().onChangeSkinType(i);
        }
        if (this.epe.aPE() != null) {
            this.epe.aPE().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.epe = new ex(this, this.bRx, this.emU);
        this.bPA = new com.baidu.tieba.d.c(getActivity());
        this.bPA.a(this.epT);
        this.bPA.a(this.aMy);
        this.epe.setOnScrollListener(this.BL);
        this.epe.c(this.epO);
        this.epe.a(this.aUZ);
        this.epe.hQ(com.baidu.tbadk.core.l.oH().oN());
        this.epe.hR(com.baidu.tbadk.core.l.oH().oJ());
        this.epe.setOnImageClickListener(this.aJh);
        this.epe.a(this.anY);
        this.epe.g(this.aRn);
        this.epe.a(this.epM);
        this.epe.is(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aT(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(r.g.tag_clip_board);
            if (obj instanceof com.baidu.tieba.tbadkCore.data.q) {
                com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) obj;
                if (com.baidu.tieba.tbadkCore.data.q.fvi == qVar.getType() || TextUtils.isEmpty(qVar.getBimg_url()) || !com.baidu.tbadk.core.l.oH().oN()) {
                    return false;
                }
                return pf(qVar.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.epe != null) {
            if (z && (!this.dQG || this.epr)) {
                aNB();
            } else {
                hideLoadingView(this.epe.getView());
            }
            this.epr = false;
        }
    }

    private void aNo() {
        if (this.eoR == null) {
            this.eoR = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.eoR.a(new String[]{getPageContext().getString(r.j.call_phone), getPageContext().getString(r.j.sms_phone), getPageContext().getString(r.j.search_in_baidu)}, new ax(this)).cd(c.a.Wh).ce(17).d(getPageContext());
        }
    }

    private void p(Bundle bundle) {
        this.eov = new dh(this);
        this.eov.a(this.epH);
        if (this.eov.aOT() != null) {
            this.eov.aOT().a(this.epV);
        }
        if (this.eov.aOS() != null) {
            this.eov.aOS().a(this.epx);
        }
        if (bundle != null) {
            this.eov.initWithBundle(bundle);
        } else {
            this.eov.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra("request_code", -1) == 18003) {
            this.eov.ii(true);
        }
        ep.aPz().M(this.eov.aOu(), this.eov.getIsFromMark());
        if (StringUtils.isNull(this.eov.getThreadID())) {
            finish();
        } else {
            this.eov.Fa();
        }
    }

    private void initData(Bundle bundle) {
        this.dMU = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dMU != null) {
            this.dMU.a(this.epK);
        }
        this.epd = new com.baidu.tieba.tbadkCore.f.a(this);
        this.epd.setLoadDataCallBack(this.epL);
        this.epe.a(new ay(this));
        this.bQa.setUniqueId(getUniqueId());
        this.bQa.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.epe.ayI();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.h.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.h.b.c((String) sparseArray.get(r.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.epu;
        userMuteCheckCustomMessage.setTag(this.epu);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.bY(r.j.go_setting_float_window_permission);
        aVar.bZ(r.j.step_to_setting_float_permission);
        aVar.a(r.j.go_and_setting, new az(this));
        aVar.b(r.j.cancel, new bb(this));
        aVar.b(getPageContext()).tm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aNq() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.eov != null && this.eov.getPbData() != null) {
            com.baidu.tieba.pb.data.h pbData = this.eov.getPbData();
            if (pbData.aMr() != null) {
                sb.append("forum_name=").append(pc(pbData.aMr().getName()));
                sb.append("&");
            }
            if (pbData.aMs() != null) {
                com.baidu.tbadk.core.data.bi aMs = pbData.aMs();
                sb.append("thread_id=").append(aMs.getId());
                sb.append("&");
                sb.append("thread_title=").append(pc(aMs.getTitle()));
                if (aMs.getAuthor() != null && aMs.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aMs.getAuthor().getPortrait());
                }
            }
        }
        return sb.toString();
    }

    private String pc(String str) {
        return URLEncoder.encode(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        com.baidu.tieba.tbadkCore.data.q qVar;
        ArrayList<IconData> arrayList;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(r.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.q) && (qVar = (com.baidu.tieba.tbadkCore.data.q) sparseArray.get(r.g.tag_clip_board)) != null && this.eov != null && this.eov.getPbData() != null && qVar.bjO() > 1) {
            String threadID = this.eov.getThreadID();
            String id = qVar.getId();
            int i = 0;
            if (this.eov.getPbData() != null) {
                i = this.eov.getPbData().aMz();
            }
            b pg = pg(id);
            if (pg != null) {
                SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
                SmallTailInfo aRG = qVar.aRG();
                AntiData qq = this.eov.getPbData().qq();
                if (qVar.getAuthor() != null) {
                    arrayList = qVar.getAuthor().getIconInfo();
                } else {
                    arrayList = null;
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i, aRG, qq, false, arrayList).addBigImageData(pg.eqo, pg.eqp, pg.eqq, pg.index)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aNr() {
        if (this.eov.getPbData() == null || this.eov.getPbData().aMs() == null) {
            return -1;
        }
        return this.eov.getPbData().aMs().sq();
    }

    private boolean hY(boolean z) {
        if (this.eov == null || this.eov.getPbData() == null) {
            return false;
        }
        return (this.eov.getPbData().aMz() != 0) && !z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hZ(boolean z) {
        if (this.eov == null || this.eov.getPbData() == null) {
            return false;
        }
        return ((this.eov.getPbData().aMz() != 0) || this.eov.getPbData().aMs() == null || this.eov.getPbData().aMs().getAuthor() == null || TextUtils.equals(this.eov.getPbData().aMs().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void aNs() {
        if (this.eov != null && this.eov.getPbData() != null && this.eov.getPbData().aMs() != null && this.eov.getPbData().aMs().getAuthor() != null) {
            com.baidu.tbadk.core.data.bi aMs = this.eov.getPbData().aMs();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aMs.getAuthor().getUserId());
            boolean hZ = hZ(equals);
            boolean hY = hY(equals);
            boolean z = equals && this.epe.aQh();
            GodUserData godUserData = aMs.getAuthor().getGodUserData();
            this.epe.eug.a(this.eov.aOw(), this.dMU != null ? this.dMU.nv() : false, hZ, z, hY, equals && godUserData != null && godUserData.isCanSendCall());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.tbadkCore.data.q qVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (qVar = (com.baidu.tieba.tbadkCore.data.q) sparseArray.get(r.g.tag_clip_board)) != null) {
            d(qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.h hVar, int i, int i2, boolean z, boolean z2) {
        if (hVar != null && this.eov != null) {
            eg egVar = new eg(getUniqueId());
            egVar.pbData = hVar;
            egVar.threadId = this.eov.getThreadID();
            egVar.postId = this.eov.getPostId();
            egVar.ety = i;
            egVar.etz = i2;
            egVar.etx = this.eov.getHostMode();
            egVar.emH = this.eov.nv();
            egVar.isSquence = this.eov.aOw();
            egVar.loadType = this.eov.aOQ();
            egVar.etA = z;
            egVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, egVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, boolean z2) {
        if (hVar != null && this.eov != null) {
            eg egVar = new eg(getUniqueId());
            egVar.pbData = hVar;
            egVar.threadId = this.eov.getThreadID();
            egVar.postId = this.eov.getPostId();
            egVar.ety = i;
            egVar.etx = this.eov.getHostMode();
            egVar.emH = this.eov.nv();
            egVar.isSquence = this.eov.aOw();
            egVar.loadType = this.eov.aOQ();
            egVar.etA = z;
            egVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, egVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        Uz();
    }

    public void a(boolean z, MarkData markData) {
        this.epe.aQb();
        this.eov.ih(z);
        if (this.dMU != null) {
            this.dMU.ad(z);
            if (markData != null) {
                this.dMU.a(markData);
            }
        }
        if (this.eov.nv()) {
            aNy();
        } else {
            this.epe.j(this.eov.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ol(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pd(String str) {
        if (!StringUtils.isNull(str) && this.eov != null) {
            String threadID = this.eov.getThreadID();
            String id = this.eov.getPbData().aMr().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(r.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData)) {
                if (!this.eov.aOz()) {
                    antiData.setBlock_forum_name(this.eov.getPbData().aMr().getName());
                    antiData.setBlock_forum_id(this.eov.getPbData().aMr().getId());
                    antiData.setUser_name(this.eov.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.eov.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.f.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.rU(i)) {
            AntiHelper.R(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            fM(str);
        } else {
            this.epe.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar, boolean z) {
        if (bVar != null) {
            this.epe.a(0, bVar.ub, bVar.fxv, z);
            if (bVar.ub) {
                if (bVar.fxt == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.q> aMt = this.eov.getPbData().aMt();
                    int size = aMt.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (!bVar.mPostId.equals(aMt.get(i).getId())) {
                                i++;
                            } else {
                                aMt.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.epe.j(this.eov.getPbData());
                } else if (bVar.fxt == 0) {
                    aNt();
                } else if (bVar.fxt == 2) {
                    boolean z2 = false;
                    ArrayList<com.baidu.tieba.tbadkCore.data.q> aMt2 = this.eov.getPbData().aMt();
                    int size2 = aMt2.size();
                    for (int i2 = 0; i2 < size2 && !z2; i2++) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 < aMt2.get(i2).bjK().size()) {
                                if (!bVar.mPostId.equals(aMt2.get(i2).bjK().get(i4).getId())) {
                                    i3 = i4 + 1;
                                } else {
                                    aMt2.get(i2).bjK().remove(i4);
                                    aMt2.get(i2).bjM();
                                    z2 = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData aMC = this.eov.getPbData().aMC();
                        com.baidu.tieba.tbadkCore.data.q qVar = aMt2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.data.q> bjN = qVar.bjN();
                        int size3 = bjN.size();
                        int i5 = 0;
                        while (true) {
                            if (i5 < size3) {
                                if (!bVar.mPostId.equals(aMt2.get(i2).bjN().get(i5).getId())) {
                                    i5++;
                                } else {
                                    bjN.remove(i5);
                                    aMC.decreaseAlreadyCount();
                                    if (qVar.bjU() > bjN.size()) {
                                        qVar.rN(bjN.size());
                                    }
                                    if (bjN.size() > 0) {
                                        com.baidu.tieba.tbadkCore.data.q qVar2 = bjN.get(bjN.size() - 1);
                                        aMC.setLastAdditionTime(qVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a aAI = qVar2.aAI();
                                        String str = "";
                                        if (aAI != null) {
                                            str = aAI.toString();
                                        }
                                        aMC.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a aAI2 = qVar.aAI();
                                        String str2 = "";
                                        if (aAI2 != null) {
                                            str2 = aAI2.toString();
                                        }
                                        aMC.setLastAdditionContent(str2);
                                    }
                                    aNC();
                                    z2 = true;
                                }
                            }
                        }
                    }
                    if (z2) {
                        this.epe.j(this.eov.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, a.f fVar) {
        if (fVar != null) {
            this.epe.a(this.epd.getLoadDataMode(), fVar.ub, fVar.fxv, false);
            if (fVar.ub) {
                this.epg = true;
                if (i == 2 || i == 3) {
                    this.eph = true;
                    this.epi = false;
                } else if (i == 4 || i == 5) {
                    this.eph = false;
                    this.epi = true;
                }
                if (i == 2) {
                    this.eov.getPbData().aMs().bW(1);
                    this.eov.setIsGood(1);
                } else if (i == 3) {
                    this.eov.getPbData().aMs().bW(0);
                    this.eov.setIsGood(0);
                } else if (i == 4) {
                    this.eov.getPbData().aMs().bV(1);
                    this.eov.or(1);
                } else if (i == 5) {
                    this.eov.getPbData().aMs().bV(0);
                    this.eov.or(0);
                }
                this.epe.a(this.eov.getPbData(), this.eov.aOw(), true);
                com.baidu.tieba.c.a.a(getPageContext(), 2, i);
            }
        }
    }

    private void aNt() {
        if (this.eov.aOx()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.eov.getThreadID());
            setResult(-1, intent);
        }
        if (aNz()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNu() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.epe != null) {
            this.epe.aBc();
        }
        if (this.eov != null && this.eov.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.eov.getPbData().aMs().getId();
            historyMessage.forumName = this.eov.getPbData().aMr().getName();
            historyMessage.threadName = this.eov.getPbData().aMs().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aMt = this.eov.getPbData().aMt();
            int aQe = this.epe != null ? this.epe.aQe() : 0;
            if (aMt != null && aQe >= 0 && aQe < aMt.size()) {
                historyMessage.postID = aMt.get(aQe).getId();
            }
            historyMessage.isHostOnly = this.eov.getHostMode();
            historyMessage.isSquence = this.eov.aOw();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.epp != null) {
            this.epp.onDestroy();
        }
        if (this.eov != null && this.eov.aOx()) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.eov.getThreadID());
            if (this.epg) {
                if (this.epi) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.eov.aAT());
                }
                if (this.eph) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.eov.getIsGood());
                }
            }
            setResult(-1, intent);
        }
        if (aNz()) {
            if (this.eov != null && this.epe != null && this.epe.OU() != null) {
                com.baidu.tieba.pb.data.h pbData = this.eov.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.m9getInst().getDefaultBubble());
                    }
                    if (!pbData.aMy()) {
                        ep.aPz().a(this.eov.getPbData(), this.epe.OU().onSaveInstanceState(), this.eov.aOw(), this.eov.getHostMode());
                    }
                }
            } else {
                ep.aPz().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.epe != null && this.epe.aOo()) {
                    this.epe.aOq();
                    return true;
                }
                return super.onKeyDown(i, keyEvent);
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean om(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(r.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.epp.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aNx();
                    return;
                case 13008:
                    ep.aPz().reset();
                    this.mHandler.postDelayed(new bc(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.eov != null) {
                        a(aNw(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                    if (aNr() == 1) {
                        aNv();
                        return;
                    }
                    return;
                case 24008:
                    this.epe.hW(false);
                    if (this.eov.getPbData() != null && this.eov.getPbData().aMs() != null && this.eov.getPbData().aMs().sf() != null) {
                        this.eov.getPbData().aMs().sf().setStatus(2);
                        break;
                    }
                    break;
                case 25001:
                    break;
                default:
                    return;
            }
            if (this.eoY != null) {
                this.eoY.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aNk() != null && aNg() != null && aNk().aPH() && com.baidu.tbadk.editortools.e.b.Dh().getStatus() == 1) {
                    com.baidu.tbadk.editortools.e.b.Dh().setStatus(0);
                    if (this.epe != null) {
                        this.epe.aPG();
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
    public void aNv() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.eov.getPbData() != null && this.eov.getPbData().aMs() != null && this.eov.getPbData().aMs().rX() != null && this.eov.getPbData().aMs().rX().size() > 0 && this.eov.getPbData().aMs().rX().get(0) != null) {
            this.mAwardActId = this.eov.getPbData().aMs().rX().get(0).pc();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.h.b.c(this.eov.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void u(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra("key_action", 0)) {
                case 1:
                    agp();
                    return;
                case 2:
                    this.epe.aPP();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aNw() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] aW = this.eov.getPbData().aW(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.data.q aPI = this.epe.aPI();
        String str = "";
        if (aPI != null) {
            str = aPI.getId();
            String bg = aPI.bg(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(bg)) {
                aW[1] = bg;
            }
        }
        String sc = this.eov.getPbData().aMs().sc();
        if (sc != null && sc.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(aW[1]);
        shareFromPBMsgData.setImageUrl(aW[0]);
        shareFromPBMsgData.setForumName(this.eov.getPbData().aMr().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.eov.getPbData().aMs().getId());
        shareFromPBMsgData.setTitle(this.eov.getPbData().aMs().getTitle());
        return shareFromPBMsgData;
    }

    private void v(Intent intent) {
        a(aNw(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.eov != null && this.eov.getPbData() != null && this.eov.getPbData().aMs() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gm gmVar = new gm(getPageContext().getPageActivity());
            gmVar.setData(shareFromPBMsgData);
            aVar.cb(1);
            aVar.z(gmVar);
            aVar.a(r.j.share, new bd(this, gmVar, j, str, str2, shareFromPBMsgData));
            aVar.b(r.j.alert_no_button, new be(this, gmVar));
            aVar.ar(true);
            aVar.b(getPageContext()).tm();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                gmVar.F(shareFromPBMsgData.getImageUrl(), this.eov.getPbData().aMA() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.eov != null && this.eov.getPbData() != null && this.eov.getPbData().aMs() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gm gmVar = new gm(getPageContext().getPageActivity());
            gmVar.setData(shareFromPBMsgData);
            aVar.cb(1);
            aVar.z(gmVar);
            aVar.a(r.j.share, new bf(this, gmVar, i, str, j, shareFromPBMsgData));
            aVar.b(r.j.alert_no_button, new bg(this, gmVar));
            aVar.ar(true);
            aVar.b(getPageContext()).tm();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                gmVar.F(shareFromPBMsgData.getImageUrl(), this.eov.getPbData().aMA() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNx() {
        MarkData oy;
        if (this.dMU != null && (oy = this.eov.oy(this.epe.aQf())) != null) {
            if (!oy.isApp() || (oy = this.eov.oy(this.epe.aQf() + 1)) != null) {
                this.epe.aPY();
                this.dMU.a(oy);
                if (!this.dMU.nv()) {
                    this.dMU.nx();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.dMU.nw();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNy() {
        com.baidu.tieba.pb.data.h pbData = this.eov.getPbData();
        this.eov.ih(true);
        pbData.oY(this.dMU.nu());
        this.epe.j(pbData);
    }

    private boolean aNz() {
        if (this.eov == null) {
            return true;
        }
        if (this.eov.nv()) {
            MarkData aOH = this.eov.aOH();
            if (aOH == null || !this.eov.getIsFromMark()) {
                return true;
            }
            MarkData oy = this.eov.oy(this.epe.aQf());
            if (oy == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aOH);
                setResult(-1, intent);
                return true;
            } else if (oy.getPostId() == null || oy.getPostId().equals(aOH.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aOH);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cD(String.format(getPageContext().getString(r.j.alert_update_mark), Integer.valueOf(oy.getFloor())));
                aVar.a(r.j.alert_yes_btn, new bh(this, oy, aOH, aVar));
                aVar.b(r.j.alert_no_button, new bi(this, aOH, aVar));
                aVar.a(new bj(this, aOH, aVar));
                aVar.b(getPageContext());
                aVar.tm();
                return false;
            }
        } else if (this.eov.getPbData() == null || this.eov.getPbData().aMt() == null || this.eov.getPbData().aMt().size() <= 0 || !this.eov.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: OU */
    public BdListView getListView() {
        if (this.epe == null) {
            return null;
        }
        return this.epe.OU();
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public int IC() {
        if (this.epe == null) {
            return 0;
        }
        return this.epe.aQl();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int wN() {
        if (this.epe == null) {
            return 0;
        }
        return this.epe.abS();
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<ImageView> ID() {
        if (this.aIL == null) {
            this.aIL = new com.baidu.adp.lib.f.b<>(new bk(this), 8, 0);
        }
        return this.aIL;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<TextView> IE() {
        if (this.aIM == null) {
            this.aIM = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.aIM;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<GifView> IF() {
        if (this.aIQ == null) {
            this.aIQ = new com.baidu.adp.lib.f.b<>(new bm(this), 20, 0);
        }
        return this.aIQ;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> IG() {
        if (this.aIO == null) {
            this.aIO = new com.baidu.adp.lib.f.b<>(new bn(this), 8, 0);
        }
        return this.aIO;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> II() {
        if (this.aIN == null) {
            this.aIN = com.baidu.tieba.graffiti.e.createGraffitiViewPool(getPageContext().getPageActivity(), 6);
        }
        return this.aIN;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> fy(int i) {
        if (this.aIR == null) {
            if (i == 1) {
                this.aIR = com.baidu.tieba.togetherhi.ds.createGraffitiViewPool(getPageContext().getPageActivity(), 6);
            } else {
                this.aIR = TogetherHiLivingView.createGraffitiViewPool(getPageContext().getPageActivity(), 6);
            }
        }
        return this.aIR;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> wO() {
        if (this.ahk == null) {
            this.ahk = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.ahk;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void A(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void B(Context context, String str) {
        if (gn.pq(str) && this.eov != null && this.eov.getThreadID() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c11664").s("obj_param1", 1).ab("post_id", this.eov.getThreadID()));
        }
        gn.aQL().h(getPageContext(), str);
    }

    private com.baidu.tbadk.core.dialog.a aNA() {
        if (this.eoS == null) {
            this.eoS = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.eoS.cC(getPageContext().getString(r.j.download_baidu_video_dialog));
            this.eoS.a(getPageContext().getString(r.j.install), new bo(this));
            this.eoS.b(getPageContext().getString(r.j.cancel), new bp(this));
            this.eoS.aq(true);
            this.eoS.b(getPageContext());
            this.eoS.ar(false);
        }
        this.eoS.tm();
        return this.eoS;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void C(Context context, String str) {
        gn.aQL().h(getPageContext(), str);
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
            aNA();
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
            com.baidu.tieba.pb.data.h pbData = this.eov.getPbData();
            com.baidu.tbadk.widget.richText.a ay = ay(str, i);
            if (ay != null && (cVar = ay.HZ().get(this.epP)) != null) {
                bVar.eqo = new ArrayList<>();
                bVar.eqp = new ConcurrentHashMap<>();
                if (!cVar.Ie().Ir()) {
                    bVar.eqr = false;
                    String c2 = com.baidu.tieba.pb.data.i.c(cVar);
                    bVar.eqo.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(cVar);
                    imageUrlData.originalSize = e(cVar);
                    imageUrlData.postId = ay.getPostId();
                    imageUrlData.mIsReserver = this.eov.aOG();
                    imageUrlData.mIsSeeHost = this.eov.getHostMode();
                    bVar.eqp.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aMr() != null) {
                            bVar.forumName = pbData.aMr().getName();
                            bVar.forumId = pbData.aMr().getId();
                        }
                        if (pbData.aMs() != null) {
                            bVar.threadId = pbData.aMs().getId();
                        }
                        bVar.eqq = pbData.aMA() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.eqr = true;
                int size = pbData.aMt().size();
                this.epQ = false;
                bVar.index = -1;
                int i2 = i;
                for (int i3 = 0; i3 < size; i3++) {
                    com.baidu.tieba.tbadkCore.data.q qVar = pbData.aMt().get(i3);
                    com.baidu.tbadk.widget.richText.a aAI = qVar.aAI();
                    if (!ew.g(qVar)) {
                        a2 = a(aAI, ay, i2, i, bVar.eqo, bVar.eqp);
                    } else {
                        a2 = a(qVar, i2, bVar.eqo, bVar.eqp);
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.q> bjN = qVar.bjN();
                    i2 = a2;
                    for (int i4 = 0; i4 < bjN.size(); i4++) {
                        i2 = a(bjN.get(i4).aAI(), ay, i2, i, bVar.eqo, bVar.eqp);
                    }
                }
                if (bVar.eqo.size() > 0) {
                    bVar.lastId = bVar.eqo.get(bVar.eqo.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aMr() != null) {
                        bVar.forumName = pbData.aMr().getName();
                        bVar.forumId = pbData.aMr().getId();
                    }
                    if (pbData.aMs() != null) {
                        bVar.threadId = pbData.aMs().getId();
                    }
                    bVar.eqq = pbData.aMA() == 1;
                }
                bVar.index = i2;
            }
        }
    }

    private String d(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.Ie() == null) {
            return null;
        }
        return cVar.Ie().Iv();
    }

    private long e(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.Ie() == null) {
            return 0L;
        }
        return cVar.Ie().getOriginalSize();
    }

    private int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.g Ie;
        if (aVar == aVar2) {
            this.epQ = true;
        }
        if (aVar != null) {
            int size = aVar.HZ().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.HZ().get(i6) == null || aVar.HZ().get(i6).getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int width = aVar.HZ().get(i6).Ie().getWidth();
                    int height = aVar.HZ().get(i6).Ie().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.HZ().get(i6).Ie().Ir()) {
                        if (aVar == aVar2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.HZ().get(i6);
                        String c2 = com.baidu.tieba.pb.data.i.c(cVar);
                        if (!TextUtils.isEmpty(c2)) {
                            arrayList.add(c2);
                            if (cVar != null && (Ie = cVar.Ie()) != null) {
                                String It = Ie.It();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = It;
                                int i9 = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.urlType = i9;
                                imageUrlData.urlType = i9;
                                imageUrlData.originalUrl = d(cVar);
                                imageUrlData.originalSize = e(cVar);
                                imageUrlData.postId = aVar.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.h.b.c(this.eov.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.eov.aOG();
                                imageUrlData.mIsSeeHost = this.eov.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.epQ) {
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
        com.baidu.tieba.tbadkCore.data.i bjY;
        ArrayList<com.baidu.tieba.tbadkCore.data.k> bjr;
        if (qVar != null && arrayList != null && concurrentHashMap != null && (bjr = (bjY = qVar.bjY()).bjr()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bjr.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = bjr.get(i3);
                if (kVar != null) {
                    String bjy = kVar.bjy();
                    if (!com.baidu.tbadk.core.util.az.isEmpty(bjy)) {
                        arrayList.add(bjy);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bjy;
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        if (qVar.aAI() != null) {
                            imageUrlData.postId = qVar.aAI().getPostId();
                        }
                        imageUrlData.threadId = com.baidu.adp.lib.h.b.c(this.eov.getThreadID(), -1L);
                        imageUrlData.mIsReserver = this.eov.aOG();
                        imageUrlData.mIsSeeHost = this.eov.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bjY.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bjy, imageUrlData);
                        }
                        if (!this.epQ) {
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
            if (qVar.getId() != null && qVar.getId().equals(this.eov.rV())) {
                z = true;
            }
            MarkData e = this.eov.e(qVar);
            if (e != null) {
                this.epe.aPY();
                if (this.dMU != null) {
                    this.dMU.a(e);
                    if (!z) {
                        this.dMU.nx();
                    } else {
                        this.dMU.nw();
                    }
                }
            }
        }
    }

    private com.baidu.tbadk.widget.richText.a ay(String str, int i) {
        if (this.eov == null || this.eov.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.h pbData = this.eov.getPbData();
        com.baidu.tbadk.widget.richText.a a2 = a(pbData.aMt(), str, i);
        if (a2 == null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aMt = pbData.aMt();
            int size = aMt.size();
            for (int i2 = 0; i2 < size; i2++) {
                a2 = a(aMt.get(i2).bjN(), str, i);
                if (a2 != null) {
                    return a2;
                }
            }
            return a2;
        }
        return a2;
    }

    private long pe(String str) {
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aMt;
        com.baidu.tieba.pb.data.h pbData = this.eov.getPbData();
        if (pbData != null && (aMt = pbData.aMt()) != null && !aMt.isEmpty()) {
            Iterator<com.baidu.tieba.tbadkCore.data.q> it = aMt.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.q next = it.next();
                com.baidu.tieba.tbadkCore.data.i bjY = next.bjY();
                if (bjY != null && bjY.fuN) {
                    Iterator<com.baidu.tbadk.widget.richText.c> it2 = next.aAI().HZ().iterator();
                    while (it2.hasNext()) {
                        com.baidu.tbadk.widget.richText.c next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.Im().getLink().equals(str)) {
                            return bjY.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> HZ;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a aAI = arrayList.get(i2).aAI();
            if (aAI != null && (HZ = aAI.HZ()) != null) {
                int size = HZ.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (HZ.get(i4) != null && HZ.get(i4).getType() == 8) {
                        i3++;
                        if (HZ.get(i4).Ie().It().equals(str)) {
                            int width = HZ.get(i4).Ie().getWidth();
                            int height = HZ.get(i4).Ie().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.epP = i4;
                            return aAI;
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
            this.eot = str;
            if (this.eoR == null) {
                aNo();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.eoR.cg(1).setVisibility(8);
            } else {
                this.eoR.cg(1).setVisibility(0);
            }
            this.eoR.tp();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bQb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uz() {
        hideNetRefreshView(this.epe.getView());
        aNB();
        if (this.eov.Fa()) {
            this.epe.aPY();
        }
    }

    private void aNB() {
        showLoadingView(this.epe.getView(), false, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds400));
        View EA = getLoadingView().EA();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EA.getLayoutParams();
        layoutParams.addRule(3, this.epe.aQD().getId());
        EA.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abb() {
        if (this.bQb != null) {
            this.bQb.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void on(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agp() {
        if (this.eov.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.h pbData = this.eov.getPbData();
            String name = pbData.aMr().getName();
            String title = pbData.aMs().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.eov.getThreadID() + "?share=9105&fr=share";
            String[] aW = pbData.aW(getPageContext().getPageActivity());
            String str2 = aW[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = aW[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (aNr() == 1) {
                if (pbData != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c10399").ab("fid", pbData.getForumId()).ab("tid", pbData.getThreadId()).ab("uid", currentAccount));
                }
            } else if (aNr() == 2 && pbData != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c10406").ab("fid", pbData.getForumId()).ab("tid", pbData.getThreadId()).ab("uid", currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(r.j.share_content_tpl), title, name, str3);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.linkUrl = str;
            fVar.amS = true;
            fVar.extData = this.eov.getThreadID();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(r.j.share_tieba_qunzu, r.f.icon_unite_share_qunzu, new bq(this));
            shareDialogConfig.addOutsideTextView(r.j.forum_friend, r.f.icon_unite_share_baf, new br(this));
            shareDialogConfig.setCopyLinkListener(new bs(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<LinearLayout> IH() {
        if (this.aIP == null) {
            this.aIP = new com.baidu.adp.lib.f.b<>(new bt(this), 15, 0);
        }
        return this.aIP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNC() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.pb.data.h pbData = this.eov.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.qq().isIfAddition();
            AdditionData aMC = pbData.aMC();
            boolean z3 = aMC == null ? false : isIfAddition;
            if (z3) {
                z = aMC.getAlreadyCount() != aMC.getTotalCount();
                if (!TextUtils.isEmpty(aMC.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.pb.main.b.e eVar = this.epe.eug;
            if (!z3 || !z) {
                z2 = false;
            }
            eVar.iH(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.epe.aPR() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c10517").s("obj_locate", 2).ab("fid", this.eov.getPbData().getForumId()));
            } else {
                com.baidu.tbadk.core.data.bi aMs = this.eov.getPbData().aMs();
                if (view != null) {
                    boolean z = aMs.rF() == null || aMs.rF().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.epA > 1000) {
                            this.epB = true;
                            aV(view);
                        } else {
                            this.epB = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            e(view, this.epB);
                        } else {
                            d(view, this.epB);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        d(view, this.epB);
                    } else if (motionEvent.getAction() == 3) {
                        d(view, this.epB);
                    }
                }
            }
        }
        return false;
    }

    private void d(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), r.a.praise_animation_scale2));
            new Handler().postDelayed(new bv(this), 200L);
        }
    }

    private void e(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), r.a.praise_animation_scale3));
            new Handler().postDelayed(new bw(this), 600L);
        }
    }

    private void aV(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), r.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void abd() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(r.j.login_to_use), true, 11017)));
        } else if (aVar.to() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.to();
            int intValue = ((Integer) sparseArray.get(ex.evY)).intValue();
            if (intValue == ex.evZ) {
                if (!this.epd.bkE()) {
                    this.epe.aPV();
                    int intValue2 = ((Integer) sparseArray.get(r.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(r.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(r.g.tag_del_post_type)).intValue();
                    this.epd.a(this.eov.getPbData().aMr().getId(), this.eov.getPbData().aMr().getName(), this.eov.getPbData().aMs().getId(), (String) sparseArray.get(r.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == ex.ewa || intValue == ex.ewc) {
                if (this.eov.aOT() != null) {
                    this.eov.aOT().oq(dh.erf);
                }
                if (intValue == ex.ewa) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == ex.ewb) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.epU).oX()));
            }
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (sparseArray.get(r.g.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(r.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(r.g.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(r.g.tag_user_mute_thread_id);
        }
        if (sparseArray.get(r.g.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(r.g.tag_user_mute_post_id);
        }
        if (sparseArray.get(r.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(r.g.tag_user_mute_msg);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.epu);
        userMuteAddAndDelCustomMessage.setTag(this.epu);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean pf(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bm.ak(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.uh().getString("bubble_link", ""))) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(r.j.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void ia(boolean z) {
        this.epn = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aND() {
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aMt;
        int s;
        if (this.eov == null || this.eov.getPbData() == null || this.eov.getPbData().aMt() == null || (s = com.baidu.tbadk.core.util.y.s((aMt = this.eov.getPbData().aMt()))) == 0) {
            return "";
        }
        int aQe = this.epe.aQe();
        com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(aMt, aQe);
        if (qVar == null || qVar.getAuthor() == null) {
            return "";
        }
        if (this.eov.pk(qVar.getAuthor().getUserId())) {
            return qVar.getId();
        }
        for (int i = aQe - 1; i != 0; i--) {
            com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(aMt, i);
            if (qVar2 == null || qVar2.getAuthor() == null || qVar2.getAuthor().getUserId() == null) {
                break;
            } else if (this.eov.pk(qVar2.getAuthor().getUserId())) {
                return qVar2.getId();
            }
        }
        for (int i2 = aQe + 1; i2 < s; i2++) {
            com.baidu.tieba.tbadkCore.data.q qVar3 = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(aMt, i2);
            if (qVar3 == null || qVar3.getAuthor() == null || qVar3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.eov.pk(qVar3.getAuthor().getUserId())) {
                return qVar3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void F(Context context, String str) {
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bh.vL().c(getPageContext(), new String[]{str})) {
            com.baidu.tieba.pb.b.a(pe(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.eov.getPbData().aMr().getId(), this.eov.getPbData().aMr().getName(), this.eov.getPbData().aMs().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, String str2, String str3, String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cD(getResources().getString(r.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cD(getResources().getString(r.j.make_sure_hide));
        }
        aVar.a(getResources().getString(r.j.alert_yes_button), new bx(this, j, str, str2, str3, str4));
        aVar.b(getResources().getString(r.j.alert_no_button), new by(this, j, str, str2, str3, str4));
        aVar.ar(false);
        aVar.b(getPageContext());
        aVar.tm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b pg(String str) {
        String str2;
        if (this.eov.getPbData() == null || this.eov.getPbData().aMt() == null || this.eov.getPbData().aMt().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i < this.eov.getPbData().aMt().size()) {
                if (str.equals(this.eov.getPbData().aMt().get(i).getId())) {
                    break;
                }
                i++;
            } else {
                i = 0;
                break;
            }
        }
        com.baidu.tieba.tbadkCore.data.q qVar = this.eov.getPbData().aMt().get(i);
        if (qVar.aAI() == null || qVar.aAI().HZ() == null) {
            return null;
        }
        Iterator<com.baidu.tbadk.widget.richText.c> it = qVar.aAI().HZ().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.Ie() != null) {
                    str2 = next.Ie().It();
                }
            }
        }
        a(str2, 0, bVar);
        com.baidu.tieba.pb.data.i.a(qVar, bVar);
        return bVar;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eoO) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.eoO = false;
        } else if (aNE()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eoO) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.eoO = false;
        } else if (aNE()) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void ib(boolean z) {
        this.epq = z;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a005";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.eov != null) {
            if (this.eov.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(this.eov.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.h.b.c(this.eov.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aNE() {
        return (!this.eoM && this.epW == -1 && this.epX == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            this.epZ = mVar;
            this.eoM = true;
            this.epe.aPJ();
            this.epe.pp(this.epY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNF() {
        if (this.epZ != null) {
            if (this.epW == -1) {
                showToast(r.j.pb_manga_not_prev_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.epZ.getCartoonId(), this.epW, 0)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNG() {
        if (this.epZ != null) {
            if (this.epX == -1) {
                showToast(r.j.pb_manga_not_next_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.epZ.getCartoonId(), this.epX, 0)));
            finish();
        }
    }

    public int aNH() {
        return this.epW;
    }

    public int aNI() {
        return this.epX;
    }

    private void aoH() {
        if (this.eov != null && this.eov.getPbData() != null && this.eov.getPbData().aMs() != null && this.eov.getPbData().aMs().sz()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNJ() {
        if (this.eov != null && this.eov.getPbData() != null && this.eov.getPbData().aMs() != null && this.eov.getPbData().aMs().sz()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aNK() {
        if (this.eoP) {
            this.epb = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.eov.getPbData() != null && this.eov.getPbData().aMs() != null && this.eov.getPbData().aMs().rx() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.eov.getPbData().aMs().rx().getThreadId(), this.eov.getPbData().aMs().rx().getTaskId(), this.eov.getPbData().aMs().rx().getForumId(), this.eov.getPbData().aMs().rx().getForumName(), this.eov.getPbData().aMs().rJ(), this.eov.getPbData().aMs().rK())));
            this.eoO = true;
            finish();
        }
    }

    public boolean aNL() {
        return this.eoP;
    }

    public String aNM() {
        return this.eoZ;
    }

    public PbInterviewStatusView.a aNN() {
        return this.epc;
    }

    public void ic(boolean z) {
        this.epa = z;
    }

    public boolean aNO() {
        if (this.eov != null) {
            return this.eov.aOx();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNP() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cD(getResources().getString(r.j.mute_is_super_member_function));
        aVar.a(r.j.open_now, new bz(this));
        aVar.b(r.j.cancel, new ca(this));
        aVar.b(this.eps).tm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fM(String str) {
        if (str == null) {
            str = "";
        }
        if (this.eps != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eps.getPageActivity());
            aVar.cD(str);
            aVar.b(r.j.know, new cb(this));
            aVar.b(this.eps).tm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.epe.ayI();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eps.getPageActivity());
        if (com.baidu.tbadk.core.util.az.isEmpty(str)) {
            aVar.cD(this.eps.getResources().getString(r.j.block_mute_message_alert, str2));
        } else {
            aVar.cD(str);
        }
        aVar.a(r.j.confirm, new cc(this, userMuteAddAndDelCustomMessage));
        aVar.b(r.j.cancel, new cd(this));
        aVar.b(this.eps).tm();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.b
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.h[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.h.class);
            for (int i = 0; i < objArr.length; i++) {
                if (gn.pq(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.av.getDrawable(r.f.icon_pb_wenxue)) != null) {
                    int i2 = -((int) ((tbRichTextView.getLineSpacing() - 1.0f) * textView.getLineHeight()));
                    drawable.setBounds(0, i2, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight() + i2);
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                    spannableStringBuilder2.setSpan(new com.baidu.tbadk.widget.f(drawable), 0, "#4%2&@#907$12#@96476)w7we9e~@$%&&".length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                    spannableStringBuilder.setSpan(objArr[i], spannableStringBuilder.getSpanStart(objArr[i]), spannableStringBuilder.length(), 17);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                    spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                    return;
                }
            }
        }
    }
}
