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
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
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
import com.baidu.tbadk.core.view.z;
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
import com.baidu.tieba.pb.pb.main.a.j;
import com.baidu.tieba.pb.pb.main.cr;
import com.baidu.tieba.pb.pb.main.cu;
import com.baidu.tieba.pb.pb.main.dj;
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
    private com.baidu.adp.lib.f.b<ImageView> aJD;
    private com.baidu.adp.lib.f.b<TextView> aJE;
    private com.baidu.adp.lib.f.b<View> aJF;
    private com.baidu.adp.lib.f.b<View> aJG;
    private com.baidu.adp.lib.f.b<LinearLayout> aJH;
    private com.baidu.adp.lib.f.b<GifView> aJI;
    private com.baidu.adp.lib.f.b<View> aJJ;
    private com.baidu.adp.lib.f.b<TbImageView> ahK;
    private VoiceManager bRV;
    private com.baidu.tbadk.e.a bSw;
    private com.baidu.tieba.d.c bVF;
    private com.baidu.tbadk.core.dialog.a euC;
    private com.baidu.tieba.pb.pb.main.b euJ;
    private dq euU;
    private boolean euZ;
    private String eud;
    private com.baidu.tieba.pb.pb.main.a.j eux;
    private String evJ;
    private com.baidu.tbadk.core.data.n evK;
    private com.baidu.tieba.tbadkCore.data.f eva;
    private com.baidu.tbadk.editortools.e.e evb;
    private com.baidu.adp.base.h eve;
    private com.baidu.tbadk.core.view.h evf;
    private BdUniqueId evg;
    private boolean evy;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean euw = false;
    private boolean euy = false;
    private boolean euz = false;
    private boolean dWi = false;
    private int euA = 0;
    private com.baidu.tbadk.core.dialog.c euB = null;
    private long bJR = -1;
    private long aCL = 0;
    private long euD = 0;
    private long createTime = 0;
    private long aCD = 0;
    private boolean euE = false;
    private com.baidu.tbadk.performanceLog.e euF = null;
    private long euG = 0;
    private boolean euH = false;
    private boolean euI = false;
    private String awI = null;
    private String euK = "";
    private boolean euL = true;
    private boolean euM = false;
    private String source = "";
    private PbInterviewStatusView.a euN = new i(this);
    private final Handler mHandler = new Handler(new t(this));
    private dj euf = null;
    private com.baidu.tbadk.baseEditMark.a dSz = null;
    private com.baidu.tieba.tbadkCore.f.a euO = null;
    private ey euP = null;
    public final com.baidu.tieba.pb.pb.main.a.a euQ = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean euR = false;
    private boolean euS = false;
    private boolean euT = false;
    private boolean euV = false;
    private boolean euW = false;
    private boolean euX = false;
    private boolean euY = false;
    private boolean evc = false;
    private com.baidu.tbadk.editortools.e.c awM = new ae(this);
    private boolean evd = false;
    private int cPx = -1;
    private final CustomMessageListener evh = new ap(this, CmdConfigCustom.PB_RESET_EDITOR_TOOL);
    CustomMessageListener bSN = new ba(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private CustomMessageListener cnV = new bl(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener dDD = new bu(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener dEa = new cf(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener evi = new cg(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener aKz = new j(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
    private CustomMessageListener dbA = new k(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private HttpMessageListener bqP = new l(this, CmdConfigHttp.PB_ECOMM_RECOMMEND_HTTP_CMD);
    private cr.a evj = new m(this);
    private View.OnClickListener dDC = new n(this);
    private CustomMessageListener evk = new o(this, CmdConfigCustom.CMD_SEND_GIFT_SUCCESS);
    private boolean evl = false;
    private com.baidu.tieba.tbadkCore.ah evm = new com.baidu.tieba.tbadkCore.ah(getPageContext(), new p(this));
    private long esR = 0;
    private boolean esS = true;
    private j.a evn = new q(this);
    private CustomMessageListener bqQ = new r(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener evo = new s(this, CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED);
    private com.baidu.tieba.pb.a.d esT = new com.baidu.tieba.pb.a.d(new u(this));
    private CustomMessageListener evp = new v(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener evq = new w(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener evr = new x(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    public a.b efh = new y(this);
    public final View.OnClickListener bTO = new z(this);
    private final b.d awS = new aa(this);
    private final dj.a evs = new ab(this);
    private CustomMessageListener evt = new ac(this, CmdConfigCustom.CMD_WX_SHARE_SUCCESS);
    private CustomMessageListener evu = new ad(this, CmdConfigCustom.CMD_TTS_OPTION_PB);
    private final a.InterfaceC0032a evv = new af(this);
    private final AbsListView.OnScrollListener BL = new ag(this);
    private final com.baidu.adp.base.g evw = new ah(this);
    private final c evx = new ai(this);
    private final z.b aXk = new aj(this);
    private final BdListView.e evz = new ak(this);
    private int evA = 0;
    private final TbRichTextView.e aJZ = new al(this);
    boolean evB = false;
    com.baidu.tieba.tbadkCore.data.q evC = null;
    private final c.b evD = new am(this);
    private final View.OnLongClickListener aoS = new an(this);
    private final NoNetworkView.a aTn = new ao(this);
    public View.OnTouchListener aKw = new aq(this);
    private a.InterfaceC0058a aMT = new ar(this);
    private final c.a evE = new as(this);
    private String evF = null;
    private final cu.a evG = new at(this);
    private int evH = -1;
    private int evI = -1;
    private final CustomMessageListener bSQ = new au(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> ewc;
        public ConcurrentHashMap<String, ImageUrlData> ewd;
        public boolean ewf;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean ewe = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes.dex */
    public interface c {
    }

    public void in(boolean z) {
        this.euH = z;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.e.e aOY() {
        return this.evb;
    }

    public void b(com.baidu.tieba.pb.data.n nVar) {
        if (nVar.aOG() != null) {
            String id = nVar.aOG().getId();
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aOm = this.euf.getPbData().aOm();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aOm.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.q qVar = aOm.get(i2);
                if (qVar.getId() == null || !qVar.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.data.q> aOK = nVar.aOK();
                    qVar.se(nVar.getTotalCount());
                    if (qVar.bmi() != null) {
                        qVar.bmi().clear();
                        qVar.bmi().addAll(aOK);
                    }
                }
            }
            this.euP.j(this.euf.getPbData());
        }
    }

    public void aOZ() {
        com.baidu.tieba.pb.data.h pbData;
        com.baidu.tbadk.core.data.bk aOl;
        if (!this.evl) {
            if (!com.baidu.adp.lib.util.k.gD()) {
                showToast(r.j.no_network_guide);
            } else if (this.esS) {
                this.evl = true;
                if (this.euf != null && (pbData = this.euf.getPbData()) != null && (aOl = pbData.aOl()) != null) {
                    int isLike = aOl.rH() == null ? 0 : aOl.rH().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10796").ab("tid", aOl.getId()));
                    }
                    if (this.evm != null) {
                        this.evm.a(aOl.se(), aOl.getId(), isLike, "pb");
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
                cVar.cd(r.j.operation);
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
                cVar.d(getPageContext()).tt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void im(int i) {
        com.baidu.tbadk.core.data.bk aOl;
        String sb;
        String y;
        if (this.euf != null && this.euf.getPbData() != null && (aOl = this.euf.getPbData().aOl()) != null) {
            if (i == 1) {
                PraiseData rH = aOl.rH();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rH == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aOl.a(praiseData);
                    } else {
                        aOl.rH().getUser().add(0, metaData);
                        aOl.rH().setNum(aOl.rH().getNum() + 1);
                        aOl.rH().setIsLike(i);
                    }
                }
                if (aOl.rH() != null) {
                    if (aOl.rH().getNum() < 1) {
                        y = getResources().getString(r.j.frs_item_praise_text);
                    } else {
                        y = com.baidu.tbadk.core.util.ax.y(aOl.rH().getNum());
                    }
                    this.euP.N(y, true);
                }
            } else if (aOl.rH() != null) {
                aOl.rH().setIsLike(i);
                aOl.rH().setNum(aOl.rH().getNum() - 1);
                ArrayList<MetaData> user = aOl.rH().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aOl.rH().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aOl.rH().getNum() < 1) {
                    sb = getResources().getString(r.j.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(aOl.rH().getNum())).toString();
                }
                this.euP.N(sb, false);
            }
            if (this.euf.aQp()) {
                this.euP.aRW().notifyDataSetChanged();
            } else {
                this.euP.k(this.euf.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().aly && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().alx && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        if (this.euf != null && this.euf.getPbData() != null && this.euP != null) {
            this.euP.d(this.euf.getPbData(), this.euf.aQp(), this.euf.aQE());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bSw == null) {
                this.bSw = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bSw.aq(updateAttentionMessage.getData().toUid, this.euf.getPbData().getForumId());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.euf.n(bundle);
        if (this.bRV != null) {
            this.bRV.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.evb.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eve = getPageContext();
        Intent intent = getIntent();
        if (intent != null) {
            this.bJR = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.euK = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.euK)) {
                this.euy = true;
            }
            this.evH = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.evI = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.evJ = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            if (aPv()) {
                setUseStyleImmersiveSticky(false);
            }
            this.euW = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ax.isEmpty(this.source) ? "" : this.source;
        } else {
            this.bJR = System.currentTimeMillis();
        }
        this.euD = System.currentTimeMillis();
        this.aCD = this.euD - this.bJR;
        super.onCreate(bundle);
        this.euA = 0;
        p(bundle);
        if (this.euf != null && this.euf.getPbData() != null) {
            this.euf.getPbData().hn(this.source);
        }
        initUI();
        if (intent != null && this.euP != null) {
            this.euP.eAu = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
        }
        this.bRV = new VoiceManager();
        this.bRV.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.e.n nVar = new com.baidu.tbadk.editortools.e.n();
        nVar.setForumName(this.euf.aQo());
        if (this.euf.getPbData() != null && this.euf.getPbData().aOk() != null) {
            nVar.setForumId(this.euf.getPbData().aOk().getId());
        }
        nVar.setFrom("pb");
        nVar.a(this.euf);
        this.evb = (com.baidu.tbadk.editortools.e.e) nVar.an(getActivity());
        this.evb.d(this);
        this.evb.a(this.awS);
        this.evb.a(this.awM);
        this.evb.a(this, bundle);
        this.evb.CO().c(new com.baidu.tbadk.editortools.z(getActivity()));
        this.evb.CO().bC(true);
        io(true);
        this.euP.setEditorTools(this.evb.CO());
        this.evb.a(this.euf.aQv(), this.euf.getThreadID(), this.euf.aQl());
        registerListener(this.dDD);
        registerListener(this.bqP);
        if (!this.euf.aQs()) {
            this.evb.fJ(this.euf.getThreadID());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.euD;
        registerListener(this.cnV);
        registerListener(this.dEa);
        registerListener(this.evi);
        registerListener(this.aKz);
        registerListener(this.bSN);
        registerListener(this.evh);
        this.eva = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.fBR);
        this.eva.blJ();
        registerListener(this.evk);
        registerListener(this.bqQ);
        if (this.euf != null) {
            this.euf.aQG();
        }
        if (TbadkCoreApplication.m9getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.evo);
        registerListener(this.evu);
        registerListener(this.evt);
        this.euJ = new com.baidu.tieba.pb.pb.main.b(this.euf, this);
        if (this.euP != null && this.euP.aSy() != null && this.euP.aSz() != null) {
            this.eux = new com.baidu.tieba.pb.pb.main.a.j(getActivity(), this.euP.aSy(), this.euP.aSz());
            this.eux.a(this.evn);
            this.eux.je(this.euP.aSF());
        }
        if (this.euw && this.euP != null && this.euP.aSz() != null) {
            this.euP.aSz().setVisibility(8);
        }
        this.evf = new com.baidu.tbadk.core.view.h();
        this.evf.afr = 1000L;
        registerListener(this.evr);
        registerListener(this.evp);
        registerListener(this.evq);
        this.evg = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.evg;
        userMuteAddAndDelCustomMessage.setTag(this.evg);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.evg;
        userMuteCheckCustomMessage.setTag(this.evg);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public String aPa() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.j aPb() {
        return this.eux;
    }

    private void io(boolean z) {
        this.evb.bF(z);
        this.evb.bG(z);
        this.evb.bH(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
        if (this.evb != null && this.evb.CO() != null) {
            this.evb.CO().Da();
        }
        if (this.euP != null) {
            this.euP.Da();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bRV != null) {
            this.bRV.onStart(getPageContext());
        }
    }

    public ey aPc() {
        return this.euP;
    }

    public dj aPd() {
        return this.euf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.m9getInst().isReadMenuDialogOnTop()) {
            this.euz = false;
        } else {
            this.euz = true;
        }
        super.onPause();
        if (this.euP.aRE() != null && this.euP.aRE().aOV() != null) {
            this.euP.aRE().aOV().onPause();
        }
        BdListView listView = getListView();
        this.euA = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.euA == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.bRV != null) {
            this.bRV.onPause(getPageContext());
        }
        if (this.euP != null) {
            this.euP.onPause();
        }
        if (!this.euf.aQs()) {
            this.evb.fI(this.euf.getThreadID());
        }
        if (this.euf != null) {
            this.euf.aQH();
        }
        MessageManager.getInstance().unRegisterListener(this.dbA);
        aqB();
        MessageManager.getInstance().unRegisterListener(this.evp);
        MessageManager.getInstance().unRegisterListener(this.evq);
        MessageManager.getInstance().unRegisterListener(this.evr);
        MessageManager.getInstance().unRegisterListener(this.bSQ);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aPe() {
        com.baidu.tieba.tbadkCore.data.q a2 = com.baidu.tieba.pb.data.i.a(this.euf.getPbData(), this.euf.aQp(), this.euf.aQE());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.euz = false;
        super.onResume();
        if (this.euM) {
            this.euM = false;
            aPB();
        }
        if (this.euP.aRE() != null && this.euP.aRE().aOV() != null) {
            this.euP.aRE().aOV().onResume();
        }
        if (aPe()) {
            this.euG = System.currentTimeMillis();
        } else {
            this.euG = -1L;
        }
        if (this.euP != null && this.euP.getView() != null) {
            if (!this.dWi) {
                aPt();
            } else {
                hideLoadingView(this.euP.getView());
            }
            this.euP.onResume();
        }
        if (this.euA == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.euP != null) {
            noNetworkView = this.euP.aRF();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.gm()) {
            noNetworkView.aJ(false);
        }
        if (this.bRV != null) {
            this.bRV.onResume(getPageContext());
        }
        registerListener(this.dbA);
        this.euZ = false;
        aPA();
        registerListener(this.evp);
        registerListener(this.evq);
        registerListener(this.evr);
        registerListener(this.bSQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.euP.iQ(z);
        if (this.euU != null) {
            this.euU.iB(z);
        }
        if (z && this.euZ) {
            this.euP.aSb();
            this.euf.ix(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.euG > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10804").ab("obj_duration", new StringBuilder(String.valueOf(System.currentTimeMillis() - this.euG)).toString()));
            this.euG = 0L;
        }
        if (this.evb != null && this.evb.CO() != null && this.evb.CO().getVisibility() != 0) {
            this.evb.DC();
        }
        if (aPc().aRI() != null) {
            aPc().aRI().onStop();
        }
        if (this.euP.eAx != null && !this.euP.eAx.aSQ()) {
            this.euP.eAx.aDp();
        }
        if (this.euf != null && this.euf.getPbData() != null && this.euf.getPbData().aOk() != null && this.euf.getPbData().aOl() != null) {
            com.baidu.tbadk.distribute.a.Cx().b(getPageContext().getPageActivity(), "pb", this.euf.getPbData().aOk().getId(), com.baidu.adp.lib.h.b.c(this.euf.getPbData().aOl().getId(), 0L));
        }
        if (this.bRV != null) {
            this.bRV.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.euJ != null) {
            this.euJ.destroy();
        }
        if (this.euV && this.euf != null) {
            a(this.euf.getPbData(), -2, 0, false, false);
        }
        if (!this.euE && this.euP != null) {
            this.euE = true;
            this.euP.aSp();
            a(false, (com.baidu.tieba.tbadkCore.data.q) null);
        }
        if (this.euf != null) {
            this.euf.cancelLoadData();
            this.euf.destory();
        }
        if (this.evb != null) {
            this.evb.onDestroy();
        }
        if (this.euO != null) {
            this.euO.cancelLoadData();
        }
        if (this.euP != null) {
            this.euP.onDestroy();
            if (this.euP.eAx != null) {
                this.euP.eAx.aDp();
            }
        }
        if (this.euF != null) {
            this.euF.onDestroy();
        }
        if (this.eux != null) {
            this.eux.aac();
        }
        super.onDestroy();
        if (this.bRV != null) {
            this.bRV.onDestory(getPageContext());
        }
        if (this.bSw != null) {
            this.bSw.destory();
        }
        this.euP.aCY();
        MessageManager.getInstance().unRegisterListener(this.evp);
        MessageManager.getInstance().unRegisterListener(this.evq);
        MessageManager.getInstance().unRegisterListener(this.evr);
        MessageManager.getInstance().unRegisterListener(this.evg);
        this.eve = null;
        this.evf = null;
        com.baidu.tieba.recapp.c.a.beA().beC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.tieba.tbadkCore.data.q qVar) {
        ck aRW;
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aPN;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xF() && this.euP != null && (aRW = this.euP.aRW()) != null && (aPN = aRW.aPN()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.baidu.tieba.tbadkCore.data.q> it = aPN.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.q next = it.next();
                String id = next.getId();
                i++;
                if (z) {
                    if (next == qVar) {
                        a.b bVar = new a.b();
                        bVar.bNJ = id;
                        bVar.beM = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.UB == 1 && !TextUtils.isEmpty(id)) {
                    next.UB = 2;
                    a.b bVar2 = new a.b();
                    bVar2.bNJ = id;
                    bVar2.beM = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.euf == null || this.euf.getPbData() == null || this.euf.getPbData().aOk() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.euf.getPbData().aOk().getFirst_class();
                    str2 = this.euf.getPbData().aOk().getSecond_class();
                    str = this.euf.getPbData().aOk().getId();
                    str4 = this.euf.getThreadID();
                }
                com.baidu.tieba.recapp.g.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.xG());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.euP.onChangeSkinType(i);
        if (this.evb != null && this.evb.CO() != null) {
            this.evb.CO().onChangeSkinType(i);
        }
        if (this.euP.aRF() != null) {
            this.euP.aRF().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.euP = new ey(this, this.bTO, this.esT);
        this.bVF = new com.baidu.tieba.d.c(getActivity());
        this.bVF.a(this.evE);
        this.bVF.a(this.aMT);
        this.euP.setOnScrollListener(this.BL);
        this.euP.c(this.evz);
        this.euP.a(this.aXk);
        this.euP.ij(com.baidu.tbadk.core.l.oJ().oP());
        this.euP.setOnImageClickListener(this.aJZ);
        this.euP.a(this.aoS);
        this.euP.g(this.aTn);
        this.euP.a(this.evx);
        this.euP.iQ(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aS(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(r.g.tag_clip_board);
            if (obj instanceof com.baidu.tieba.tbadkCore.data.q) {
                com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) obj;
                if (com.baidu.tieba.tbadkCore.data.q.fCt == qVar.getType() || TextUtils.isEmpty(qVar.getBimg_url()) || !com.baidu.tbadk.core.l.oJ().oP()) {
                    return false;
                }
                return ps(qVar.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.euP != null) {
            if (z && (!this.dWi || this.evd)) {
                aPt();
            } else {
                hideLoadingView(this.euP.getView());
            }
            this.evd = false;
        }
    }

    private void aPf() {
        if (this.euB == null) {
            this.euB = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.euB.a(new String[]{getPageContext().getString(r.j.call_phone), getPageContext().getString(r.j.sms_phone), getPageContext().getString(r.j.search_in_baidu)}, new ax(this)).ce(c.a.WF).cf(17).d(getPageContext());
        }
    }

    private void p(Bundle bundle) {
        this.euf = new dj(this);
        this.euf.a(this.evs);
        if (this.euf.aQM() != null) {
            this.euf.aQM().a(this.evG);
        }
        if (this.euf.aQL() != null) {
            this.euf.aQL().a(this.evj);
        }
        if (bundle != null) {
            this.euf.initWithBundle(bundle);
        } else {
            this.euf.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra("request_code", -1) == 18003) {
            this.euf.iA(true);
        }
        eq.aRA().M(this.euf.aQn(), this.euf.getIsFromMark());
        if (StringUtils.isNull(this.euf.getThreadID())) {
            finish();
        } else {
            this.euf.Ff();
        }
    }

    private void initData(Bundle bundle) {
        this.dSz = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dSz != null) {
            this.dSz.a(this.evv);
        }
        this.euO = new com.baidu.tieba.tbadkCore.f.a(this);
        this.euO.setLoadDataCallBack(this.evw);
        this.euP.a(new ay(this));
        this.evm.setUniqueId(getUniqueId());
        this.evm.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.euP.aAF();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.h.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.h.b.c((String) sparseArray.get(r.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.evg;
        userMuteCheckCustomMessage.setTag(this.evg);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPg() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.bZ(r.j.go_setting_float_window_permission);
        aVar.ca(r.j.step_to_setting_float_permission);
        aVar.a(r.j.go_and_setting, new az(this));
        aVar.b(r.j.cancel, new bb(this));
        aVar.b(getPageContext()).tq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aPh() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.euf != null && this.euf.getPbData() != null) {
            com.baidu.tieba.pb.data.h pbData = this.euf.getPbData();
            if (pbData.aOk() != null) {
                sb.append("forum_name=").append(pp(pbData.aOk().getName()));
                sb.append("&");
            }
            if (pbData.aOl() != null) {
                com.baidu.tbadk.core.data.bk aOl = pbData.aOl();
                sb.append("thread_id=").append(aOl.getId());
                sb.append("&");
                sb.append("thread_title=").append(pp(aOl.getTitle()));
                if (aOl.getAuthor() != null && aOl.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aOl.getAuthor().getPortrait());
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, String str, String str2) {
        if (view != null && str != null && str2 != null) {
            int[] iArr = new int[2];
            int measuredHeight = view.getMeasuredHeight();
            view.getLocationOnScreen(iArr);
            getSafeHandler().postDelayed(new bc(this, iArr, measuredHeight, str, str2), 500L);
        }
    }

    private String pp(String str) {
        return URLEncoder.encode(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        com.baidu.tieba.tbadkCore.data.q qVar;
        ArrayList<IconData> arrayList;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(r.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.q) && (qVar = (com.baidu.tieba.tbadkCore.data.q) sparseArray.get(r.g.tag_clip_board)) != null && this.euf != null && this.euf.getPbData() != null && qVar.bml() > 1) {
            String threadID = this.euf.getThreadID();
            String id = qVar.getId();
            int i = 0;
            if (this.euf.getPbData() != null) {
                i = this.euf.getPbData().aOt();
            }
            b pt = pt(id);
            if (pt != null) {
                SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
                SmallTailInfo aTO = qVar.aTO();
                AntiData qs = this.euf.getPbData().qs();
                if (qVar.getAuthor() != null) {
                    arrayList = qVar.getAuthor().getIconInfo();
                } else {
                    arrayList = null;
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i, aTO, qs, false, arrayList).addBigImageData(pt.ewc, pt.ewd, pt.ewe, pt.index)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aPi() {
        if (this.euf.getPbData() == null || this.euf.getPbData().aOl() == null) {
            return -1;
        }
        return this.euf.getPbData().aOl().ss();
    }

    private boolean ip(boolean z) {
        if (this.euf == null || this.euf.getPbData() == null) {
            return false;
        }
        return (this.euf.getPbData().aOt() != 0) && !z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iq(boolean z) {
        if (this.euf == null || this.euf.getPbData() == null) {
            return false;
        }
        return ((this.euf.getPbData().aOt() != 0) || this.euf.getPbData().aOl() == null || this.euf.getPbData().aOl().getAuthor() == null || TextUtils.equals(this.euf.getPbData().aOl().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean ir(boolean z) {
        if (z) {
            return true;
        }
        if (this.euf == null || this.euf.getPbData() == null) {
            return false;
        }
        return this.euf.getPbData().aOt() != 0;
    }

    private boolean is(boolean z) {
        return (z || this.euf == null || this.euf.getPbData() == null || this.euf.getPbData().aOt() == 0) ? false : true;
    }

    public void aPj() {
        boolean z = true;
        if (this.euf != null && this.euf.getPbData() != null && this.euf.getPbData().aOl() != null && this.euf.getPbData().aOl().getAuthor() != null) {
            com.baidu.tbadk.core.data.bk aOl = this.euf.getPbData().aOl();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aOl.getAuthor().getUserId());
            GodUserData godUserData = aOl.getAuthor().getGodUserData();
            boolean z2 = equals && godUserData != null && godUserData.isCanSendCall();
            du duVar = new du();
            if (!this.euf.getPbData().aOr() && TbadkCoreApplication.m9getInst().isTTSCanUse()) {
                duVar.eyF = true;
            }
            if (this.euf.getPbData().aOt() == 1) {
                duVar.eyI = true;
                duVar.eyH = true;
                duVar.eyN = aOl.rL() == 1;
                duVar.eyM = aOl.rM() == 1;
            } else {
                duVar.eyI = false;
                duVar.eyH = false;
            }
            duVar.eyG = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteShareActivityConfig.class);
            duVar.eyD = TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            duVar.eyJ = ir(equals);
            duVar.eyK = aPk();
            duVar.eyL = is(equals);
            duVar.eyE = this.euf.aQp();
            duVar.esE = this.dSz != null ? this.dSz.nz() : false;
            duVar.eyC = iq(equals);
            if (!equals || !this.euP.aSg()) {
                z = false;
            }
            duVar.eyz = z;
            duVar.eyA = ip(equals);
            duVar.eyB = z2;
            this.euP.eAx.a(duVar);
        }
    }

    private boolean aPk() {
        if (this.euf != null && this.euf.aQp()) {
            return this.euf.are() == null || this.euf.are().qE() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.tbadkCore.data.q qVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (qVar = (com.baidu.tieba.tbadkCore.data.q) sparseArray.get(r.g.tag_clip_board)) != null) {
            e(qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.h hVar, int i, int i2, boolean z, boolean z2) {
        if (hVar != null && this.euf != null) {
            eh ehVar = new eh(getUniqueId());
            ehVar.pbData = hVar;
            ehVar.threadId = this.euf.getThreadID();
            ehVar.postId = this.euf.getPostId();
            ehVar.ezP = i;
            ehVar.ezQ = i2;
            ehVar.ezO = this.euf.getHostMode();
            ehVar.esE = this.euf.nz();
            ehVar.isSquence = this.euf.aQp();
            ehVar.loadType = this.euf.aQJ();
            ehVar.ezR = z;
            ehVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, ehVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, boolean z2) {
        if (hVar != null && this.euf != null) {
            eh ehVar = new eh(getUniqueId());
            ehVar.pbData = hVar;
            ehVar.threadId = this.euf.getThreadID();
            ehVar.postId = this.euf.getPostId();
            ehVar.ezP = i;
            ehVar.ezO = this.euf.getHostMode();
            ehVar.esE = this.euf.nz();
            ehVar.isSquence = this.euf.aQp();
            ehVar.loadType = this.euf.aQJ();
            ehVar.ezR = z;
            ehVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, ehVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        VB();
    }

    public void a(boolean z, MarkData markData) {
        this.euP.aSc();
        this.euf.iz(z);
        if (this.dSz != null) {
            this.dSz.ad(z);
            if (markData != null) {
                this.dSz.a(markData);
            }
        }
        if (this.euf.nz()) {
            aPq();
        } else {
            this.euP.j(this.euf.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ov(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pq(String str) {
        if (!StringUtils.isNull(str) && this.euf != null) {
            String threadID = this.euf.getThreadID();
            String id = this.euf.getPbData().aOk().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(r.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData)) {
                if (!this.euf.aQs()) {
                    antiData.setBlock_forum_name(this.euf.getPbData().aOk().getName());
                    antiData.setBlock_forum_id(this.euf.getPbData().aOk().getId());
                    antiData.setUser_name(this.euf.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.euf.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.f.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.sm(i)) {
            AntiHelper.S(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            fP(str);
        } else {
            this.euP.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.euP.a(0, bVar.uc, bVar.fEA, z);
            if (bVar.uc) {
                if (bVar.fEy == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.q> aOm = this.euf.getPbData().aOm();
                    int size = aOm.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aOm.get(i).getId())) {
                            i++;
                        } else {
                            aOm.remove(i);
                            break;
                        }
                    }
                    this.euP.j(this.euf.getPbData());
                } else if (bVar.fEy == 0) {
                    aPl();
                } else if (bVar.fEy == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.q> aOm2 = this.euf.getPbData().aOm();
                    int size2 = aOm2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aOm2.get(i2).bmi().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aOm2.get(i2).bmi().get(i3).getId())) {
                                i3++;
                            } else {
                                aOm2.get(i2).bmi().remove(i3);
                                aOm2.get(i2).bmk();
                                z2 = true;
                                break;
                            }
                        }
                        aOm2.get(i2).rG(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.euP.j(this.euf.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, a.f fVar) {
        if (fVar != null) {
            this.euP.a(this.euO.getLoadDataMode(), fVar.uc, fVar.fEA, false);
            if (fVar.uc) {
                this.euR = true;
                if (i == 2 || i == 3) {
                    this.euS = true;
                    this.euT = false;
                } else if (i == 4 || i == 5) {
                    this.euS = false;
                    this.euT = true;
                }
                if (i == 2) {
                    this.euf.getPbData().aOl().bW(1);
                    this.euf.setIsGood(1);
                } else if (i == 3) {
                    this.euf.getPbData().aOl().bW(0);
                    this.euf.setIsGood(0);
                } else if (i == 4) {
                    this.euf.getPbData().aOl().bV(1);
                    this.euf.oB(1);
                } else if (i == 5) {
                    this.euf.getPbData().aOl().bV(0);
                    this.euf.oB(0);
                }
                this.euP.a(this.euf.getPbData(), this.euf.aQp(), true);
                com.baidu.tieba.c.a.a(getPageContext(), 2, i);
            }
        }
    }

    private void aPl() {
        if (this.euf.aQq()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.euf.getThreadID());
            setResult(-1, intent);
        }
        if (aPr()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPm() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.euP != null) {
            this.euP.aCY();
        }
        if (this.euf != null && this.euf.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.euf.getPbData().aOl().getId();
            historyMessage.forumName = this.euf.getPbData().aOk().getName();
            historyMessage.threadName = this.euf.getPbData().aOl().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aOm = this.euf.getPbData().aOm();
            int aSe = this.euP != null ? this.euP.aSe() : 0;
            if (aOm != null && aSe >= 0 && aSe < aOm.size()) {
                historyMessage.postID = aOm.get(aSe).getId();
            }
            historyMessage.isHostOnly = this.euf.getHostMode();
            historyMessage.isSquence = this.euf.aQp();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.evb != null) {
            this.evb.onDestroy();
        }
        if (this.euf != null && this.euf.aQq()) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.euf.getThreadID());
            if (this.euR) {
                if (this.euT) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.euf.aCP());
                }
                if (this.euS) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.euf.getIsGood());
                }
            }
            setResult(-1, intent);
        }
        if (aPr()) {
            if (this.euf != null && this.euP != null && this.euP.PW() != null) {
                com.baidu.tieba.pb.data.h pbData = this.euf.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.m9getInst().getDefaultBubble());
                    }
                    if (!pbData.aOr()) {
                        eq.aRA().a(this.euf.getPbData(), this.euP.PW().onSaveInstanceState(), this.euf.aQp(), this.euf.getHostMode());
                    }
                }
            } else {
                eq.aRA().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.euP != null && this.euP.aQh()) {
                    this.euP.aQj();
                    return true;
                }
                return super.onKeyDown(i, keyEvent);
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ow(int i) {
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
        this.evb.onActivityResult(i, i2, intent);
        if (aPc().aRI() != null) {
            aPc().aRI().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aPp();
                    return;
                case 13008:
                    eq.aRA().reset();
                    this.mHandler.postDelayed(new bd(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.euf != null) {
                        a(aPo(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    u(intent);
                    return;
                case 24006:
                    t(intent);
                    return;
                case 24007:
                    if (aPi() == 1) {
                        aPn();
                        return;
                    }
                    return;
                case 24008:
                    this.euP.im(false);
                    if (this.euf.getPbData() != null && this.euf.getPbData().aOl() != null && this.euf.getPbData().aOl().sh() != null) {
                        this.euf.getPbData().aOl().sh().setStatus(2);
                        break;
                    }
                    break;
                case 25001:
                    break;
                default:
                    return;
            }
            if (this.euJ != null) {
                this.euJ.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aPc() != null && aOY() != null && aPc().aRK() && com.baidu.tbadk.editortools.e.b.Dp().getStatus() == 1) {
                    com.baidu.tbadk.editortools.e.b.Dp().setStatus(0);
                    if (this.euP != null) {
                        this.euP.aRJ();
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
    public void aPn() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.euf.getPbData() != null && this.euf.getPbData().aOl() != null && this.euf.getPbData().aOl().rZ() != null && this.euf.getPbData().aOl().rZ().size() > 0 && this.euf.getPbData().aOl().rZ().get(0) != null) {
            this.mAwardActId = this.euf.getPbData().aOl().rZ().get(0).pe();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.h.b.c(this.euf.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void t(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra("key_action", 0)) {
                case 1:
                    aik();
                    return;
                case 2:
                    this.euP.aRU();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aPo() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bi = this.euf.getPbData().bi(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.data.q aRL = this.euP.aRL();
        String str = "";
        if (aRL != null) {
            str = aRL.getId();
            String bu = aRL.bu(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(bu)) {
                bi[1] = bu;
            }
        }
        String se = this.euf.getPbData().aOl().se();
        if (se != null && se.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bi[1]);
        shareFromPBMsgData.setImageUrl(bi[0]);
        shareFromPBMsgData.setForumName(this.euf.getPbData().aOk().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.euf.getPbData().aOl().getId());
        shareFromPBMsgData.setTitle(this.euf.getPbData().aOl().getTitle());
        return shareFromPBMsgData;
    }

    private void u(Intent intent) {
        a(aPo(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.euf != null && this.euf.getPbData() != null && this.euf.getPbData().aOl() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gp gpVar = new gp(getPageContext().getPageActivity());
            gpVar.setData(shareFromPBMsgData);
            aVar.cc(1);
            aVar.z(gpVar);
            aVar.a(r.j.share, new be(this, gpVar, j, str, str2, shareFromPBMsgData));
            aVar.b(r.j.alert_no_button, new bf(this, gpVar));
            aVar.au(true);
            aVar.b(getPageContext()).tq();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                gpVar.F(shareFromPBMsgData.getImageUrl(), this.euf.getPbData().aOu() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.euf != null && this.euf.getPbData() != null && this.euf.getPbData().aOl() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gp gpVar = new gp(getPageContext().getPageActivity());
            gpVar.setData(shareFromPBMsgData);
            aVar.cc(1);
            aVar.z(gpVar);
            aVar.a(r.j.share, new bg(this, gpVar, i, str, j, shareFromPBMsgData));
            aVar.b(r.j.alert_no_button, new bh(this, gpVar));
            aVar.au(true);
            aVar.b(getPageContext()).tq();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                gpVar.F(shareFromPBMsgData.getImageUrl(), this.euf.getPbData().aOu() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPp() {
        MarkData oI;
        if (this.dSz != null && (oI = this.euf.oI(this.euP.aSf())) != null) {
            if (!oI.isApp() || (oI = this.euf.oI(this.euP.aSf() + 1)) != null) {
                this.euP.aSa();
                this.dSz.a(oI);
                if (!this.dSz.nz()) {
                    this.dSz.nB();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.dSz.nA();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPq() {
        com.baidu.tieba.pb.data.h pbData = this.euf.getPbData();
        this.euf.iz(true);
        pbData.pl(this.dSz.ny());
        this.euP.j(pbData);
    }

    private boolean aPr() {
        if (this.euf == null) {
            return true;
        }
        if (this.euf.nz()) {
            MarkData aQA = this.euf.aQA();
            if (aQA == null || !this.euf.getIsFromMark()) {
                return true;
            }
            MarkData oI = this.euf.oI(this.euP.aSf());
            if (oI == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aQA);
                setResult(-1, intent);
                return true;
            } else if (oI.getPostId() == null || oI.getPostId().equals(aQA.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aQA);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cF(String.format(getPageContext().getString(r.j.alert_update_mark), Integer.valueOf(oI.getFloor())));
                aVar.a(r.j.alert_yes_btn, new bi(this, oI, aQA, aVar));
                aVar.b(r.j.alert_no_button, new bj(this, aQA, aVar));
                aVar.a(new bk(this, aQA, aVar));
                aVar.b(getPageContext());
                aVar.tq();
                return false;
            }
        } else if (this.euf.getPbData() == null || this.euf.getPbData().aOm() == null || this.euf.getPbData().aOm().size() <= 0 || !this.euf.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: PW */
    public BdListView getListView() {
        if (this.euP == null) {
            return null;
        }
        return this.euP.PW();
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public int IF() {
        if (this.euP == null) {
            return 0;
        }
        return this.euP.aSk();
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<ImageView> IG() {
        if (this.aJD == null) {
            this.aJD = new com.baidu.adp.lib.f.b<>(new bm(this), 8, 0);
        }
        return this.aJD;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<TextView> IH() {
        if (this.aJE == null) {
            this.aJE = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.aJE;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<GifView> II() {
        if (this.aJI == null) {
            this.aJI = new com.baidu.adp.lib.f.b<>(new bn(this), 20, 0);
        }
        return this.aJI;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> IJ() {
        if (this.aJG == null) {
            this.aJG = new com.baidu.adp.lib.f.b<>(new bo(this), 8, 0);
        }
        return this.aJG;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> IL() {
        if (this.aJF == null) {
            this.aJF = com.baidu.tieba.graffiti.e.createGraffitiViewPool(getPageContext().getPageActivity(), 6);
        }
        return this.aJF;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> fB(int i) {
        if (this.aJJ == null) {
            if (i == 1) {
                this.aJJ = com.baidu.tieba.togetherhi.ds.createGraffitiViewPool(getPageContext().getPageActivity(), 6);
            } else {
                this.aJJ = TogetherHiLivingView.createGraffitiViewPool(getPageContext().getPageActivity(), 6);
            }
        }
        return this.aJJ;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> wS() {
        if (this.ahK == null) {
            this.ahK = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.ahK;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void A(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.euI = true;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void B(Context context, String str) {
        if (gq.pD(str) && this.euf != null && this.euf.getThreadID() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11664").s("obj_param1", 1).ab("post_id", this.euf.getThreadID()));
        }
        gq.aSH().h(getPageContext(), str);
        this.euI = true;
    }

    private com.baidu.tbadk.core.dialog.a aPs() {
        if (this.euC == null) {
            this.euC = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.euC.cE(getPageContext().getString(r.j.download_baidu_video_dialog));
            this.euC.a(getPageContext().getString(r.j.install), new bp(this));
            this.euC.b(getPageContext().getString(r.j.cancel), new bq(this));
            this.euC.at(true);
            this.euC.b(getPageContext());
            this.euC.au(false);
        }
        this.euC.tq();
        return this.euC;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void C(Context context, String str) {
        gq.aSH().h(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.euI = true;
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
            aPs();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.euI = true;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void D(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        com.baidu.tbadk.widget.richText.c cVar;
        int a2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.h pbData = this.euf.getPbData();
            com.baidu.tbadk.widget.richText.a ay = ay(str, i);
            if (ay != null && (cVar = ay.Ic().get(this.evA)) != null) {
                bVar.ewc = new ArrayList<>();
                bVar.ewd = new ConcurrentHashMap<>();
                if (!cVar.Ih().Iu()) {
                    bVar.ewf = false;
                    String c2 = com.baidu.tieba.pb.data.i.c(cVar);
                    bVar.ewc.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(cVar);
                    imageUrlData.originalSize = e(cVar);
                    imageUrlData.postId = ay.getPostId();
                    imageUrlData.mIsReserver = this.euf.aQz();
                    imageUrlData.mIsSeeHost = this.euf.getHostMode();
                    bVar.ewd.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aOk() != null) {
                            bVar.forumName = pbData.aOk().getName();
                            bVar.forumId = pbData.aOk().getId();
                        }
                        if (pbData.aOl() != null) {
                            bVar.threadId = pbData.aOl().getId();
                        }
                        bVar.ewe = pbData.aOu() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.ewf = true;
                int size = pbData.aOm().size();
                this.evB = false;
                bVar.index = -1;
                int i2 = 0;
                int i3 = i;
                while (i2 < size) {
                    com.baidu.tieba.tbadkCore.data.q qVar = pbData.aOm().get(i2);
                    com.baidu.tbadk.widget.richText.a aCE = qVar.aCE();
                    if (!ex.h(qVar)) {
                        a2 = a(aCE, ay, i3, i, bVar.ewc, bVar.ewd);
                    } else {
                        a2 = a(qVar, i3, bVar.ewc, bVar.ewd);
                    }
                    i2++;
                    i3 = a2;
                }
                if (bVar.ewc.size() > 0) {
                    bVar.lastId = bVar.ewc.get(bVar.ewc.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aOk() != null) {
                        bVar.forumName = pbData.aOk().getName();
                        bVar.forumId = pbData.aOk().getId();
                    }
                    if (pbData.aOl() != null) {
                        bVar.threadId = pbData.aOl().getId();
                    }
                    bVar.ewe = pbData.aOu() == 1;
                }
                bVar.index = i3;
            }
        }
    }

    private String d(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.Ih() == null) {
            return null;
        }
        return cVar.Ih().Iy();
    }

    private long e(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.Ih() == null) {
            return 0L;
        }
        return cVar.Ih().getOriginalSize();
    }

    private int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.g Ih;
        if (aVar == aVar2) {
            this.evB = true;
        }
        if (aVar != null) {
            int size = aVar.Ic().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.Ic().get(i6) == null || aVar.Ic().get(i6).getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int width = aVar.Ic().get(i6).Ih().getWidth();
                    int height = aVar.Ic().get(i6).Ih().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.Ic().get(i6).Ih().Iu()) {
                        if (aVar == aVar2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.Ic().get(i6);
                        String c2 = com.baidu.tieba.pb.data.i.c(cVar);
                        if (!TextUtils.isEmpty(c2)) {
                            arrayList.add(c2);
                            if (cVar != null && (Ih = cVar.Ih()) != null) {
                                String Iw = Ih.Iw();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = Iw;
                                imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.originalUrl = d(cVar);
                                imageUrlData.originalSize = e(cVar);
                                imageUrlData.postId = aVar.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.h.b.c(this.euf.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.euf.aQz();
                                imageUrlData.mIsSeeHost = this.euf.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.evB) {
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
        ArrayList<com.baidu.tieba.tbadkCore.data.k> blN;
        if (qVar != null && arrayList != null && concurrentHashMap != null && (blN = qVar.bmt().blN()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == blN.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = blN.get(i3);
                if (kVar != null) {
                    String blU = kVar.blU();
                    if (!com.baidu.tbadk.core.util.ax.isEmpty(blU)) {
                        arrayList.add(blU);
                        if (!this.evB) {
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
    public void e(com.baidu.tieba.tbadkCore.data.q qVar) {
        if (qVar != null) {
            boolean z = false;
            if (qVar.getId() != null && qVar.getId().equals(this.euf.rX())) {
                z = true;
            }
            MarkData f = this.euf.f(qVar);
            if (f != null) {
                this.euP.aSa();
                if (this.dSz != null) {
                    this.dSz.a(f);
                    if (!z) {
                        this.dSz.nB();
                    } else {
                        this.dSz.nA();
                    }
                }
            }
        }
    }

    private com.baidu.tbadk.widget.richText.a ay(String str, int i) {
        if (this.euf == null || this.euf.getPbData() == null || str == null || i < 0) {
            return null;
        }
        return a(this.euf.getPbData().aOm(), str, i);
    }

    private long pr(String str) {
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aOm;
        com.baidu.tieba.pb.data.h pbData = this.euf.getPbData();
        if (pbData != null && (aOm = pbData.aOm()) != null && !aOm.isEmpty()) {
            Iterator<com.baidu.tieba.tbadkCore.data.q> it = aOm.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.q next = it.next();
                com.baidu.tieba.tbadkCore.data.i bmt = next.bmt();
                if (bmt != null && bmt.fBZ) {
                    Iterator<com.baidu.tbadk.widget.richText.c> it2 = next.aCE().Ic().iterator();
                    while (it2.hasNext()) {
                        com.baidu.tbadk.widget.richText.c next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.Ip().getLink().equals(str)) {
                            return bmt.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> Ic;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a aCE = arrayList.get(i2).aCE();
            if (aCE != null && (Ic = aCE.Ic()) != null) {
                int size = Ic.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Ic.get(i4) != null && Ic.get(i4).getType() == 8) {
                        i3++;
                        if (Ic.get(i4).Ih().Iw().equals(str)) {
                            int width = Ic.get(i4).Ih().getWidth();
                            int height = Ic.get(i4).Ih().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.evA = i4;
                            return aCE;
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
            this.eud = str;
            if (this.euB == null) {
                aPf();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.euB.ch(1).setVisibility(8);
            } else {
                this.euB.ch(1).setVisibility(0);
            }
            this.euB.tt();
            this.euI = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bRV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VB() {
        hideNetRefreshView(this.euP.getView());
        aPt();
        if (this.euf.Ff()) {
            this.euP.aSa();
        }
    }

    private void aPt() {
        showLoadingView(this.euP.getView(), false, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds400));
        View EF = getLoadingView().EF();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EF.getLayoutParams();
        layoutParams.addRule(3, this.euP.aSy().getId());
        EF.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acp() {
        if (this.bRV != null) {
            this.bRV.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ox(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aik() {
        if (this.euf.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.h pbData = this.euf.getPbData();
            String name = pbData.aOk().getName();
            String title = pbData.aOl().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.euf.getThreadID() + "?share=9105&fr=share";
            String[] bi = pbData.bi(getPageContext().getPageActivity());
            String str2 = bi[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = bi[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (aPi() == 1) {
                if (pbData != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10399").ab("fid", pbData.getForumId()).ab("tid", pbData.getThreadId()).ab("uid", currentAccount));
                }
            } else if (aPi() == 2 && pbData != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10406").ab("fid", pbData.getForumId()).ab("tid", pbData.getThreadId()).ab("uid", currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(r.j.share_content_tpl), title, name, str3);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.linkUrl = str;
            fVar.anL = true;
            fVar.extData = this.euf.getThreadID();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(r.j.share_tieba_qunzu, r.f.icon_unite_share_qunzu, new br(this));
            shareDialogConfig.addOutsideTextView(r.j.forum_friend, r.f.icon_unite_share_baf, new bs(this));
            shareDialogConfig.setCopyLinkListener(new bt(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<LinearLayout> IK() {
        if (this.aJH == null) {
            this.aJH = new com.baidu.adp.lib.f.b<>(new bv(this), 15, 0);
        }
        return this.aJH;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.euP.aRV() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10517").s("obj_locate", 2).ab("fid", this.euf.getPbData().getForumId()));
            } else {
                com.baidu.tbadk.core.data.bk aOl = this.euf.getPbData().aOl();
                if (view != null) {
                    boolean z = aOl.rH() == null || aOl.rH().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.esR > 1000) {
                            this.esS = true;
                            aU(view);
                        } else {
                            this.esS = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            e(view, this.esS);
                        } else {
                            d(view, this.esS);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        d(view, this.esS);
                    } else if (motionEvent.getAction() == 3) {
                        d(view, this.esS);
                    }
                }
            }
        }
        return false;
    }

    private void d(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), r.a.praise_animation_scale2));
            new Handler().postDelayed(new bw(this), 200L);
        }
    }

    private void e(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), r.a.praise_animation_scale3));
            new Handler().postDelayed(new bx(this), 600L);
        }
    }

    private void aU(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), r.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void acq() {
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
        } else if (aVar.ts() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.ts();
            int intValue = ((Integer) sparseArray.get(ey.eCf)).intValue();
            if (intValue == ey.eCg) {
                if (!this.euO.bmU()) {
                    this.euP.aRX();
                    int intValue2 = ((Integer) sparseArray.get(r.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(r.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(r.g.tag_del_post_type)).intValue();
                    this.euO.a(this.euf.getPbData().aOk().getId(), this.euf.getPbData().aOk().getName(), this.euf.getPbData().aOl().getId(), (String) sparseArray.get(r.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == ey.eCh || intValue == ey.eCj) {
                if (this.euf.aQM() != null) {
                    this.euf.aQM().oA(dj.ewY);
                }
                if (intValue == ey.eCh) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == ey.eCi) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.evF).oZ()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.evg);
        userMuteAddAndDelCustomMessage.setTag(this.evg);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean ps(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bk.ak(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.um().getString("bubble_link", ""))) {
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

    public void it(boolean z) {
        this.euZ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aPu() {
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aOm;
        int s;
        if (this.euf == null || this.euf.getPbData() == null || this.euf.getPbData().aOm() == null || (s = com.baidu.tbadk.core.util.x.s((aOm = this.euf.getPbData().aOm()))) == 0) {
            return "";
        }
        int aSe = this.euP.aSe();
        com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(aOm, aSe);
        if (qVar == null || qVar.getAuthor() == null) {
            return "";
        }
        if (this.euf.px(qVar.getAuthor().getUserId())) {
            return qVar.getId();
        }
        for (int i = aSe - 1; i != 0; i--) {
            com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(aOm, i);
            if (qVar2 == null || qVar2.getAuthor() == null || qVar2.getAuthor().getUserId() == null) {
                break;
            } else if (this.euf.px(qVar2.getAuthor().getUserId())) {
                return qVar2.getId();
            }
        }
        for (int i2 = aSe + 1; i2 < s; i2++) {
            com.baidu.tieba.tbadkCore.data.q qVar3 = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(aOm, i2);
            if (qVar3 == null || qVar3.getAuthor() == null || qVar3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.euf.px(qVar3.getAuthor().getUserId())) {
                return qVar3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void F(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.bf.vP().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.b.a(pr(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.euf.getPbData().aOk().getId(), this.euf.getPbData().aOk().getName(), this.euf.getPbData().aOl().getTid());
            }
            this.euI = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, String str2, String str3, String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cF(getResources().getString(r.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cF(getResources().getString(r.j.make_sure_hide));
        }
        aVar.a(getResources().getString(r.j.alert_yes_button), new by(this, j, str, str2, str3, str4));
        aVar.b(getResources().getString(r.j.alert_no_button), new bz(this, j, str, str2, str3, str4));
        aVar.au(false);
        aVar.b(getPageContext());
        aVar.tq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b pt(String str) {
        String str2;
        if (this.euf.getPbData() == null || this.euf.getPbData().aOm() == null || this.euf.getPbData().aOm().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i < this.euf.getPbData().aOm().size()) {
                if (str.equals(this.euf.getPbData().aOm().get(i).getId())) {
                    break;
                }
                i++;
            } else {
                i = 0;
                break;
            }
        }
        com.baidu.tieba.tbadkCore.data.q qVar = this.euf.getPbData().aOm().get(i);
        if (qVar.aCE() == null || qVar.aCE().Ic() == null) {
            return null;
        }
        Iterator<com.baidu.tbadk.widget.richText.c> it = qVar.aCE().Ic().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.Ih() != null) {
                    str2 = next.Ih().Iw();
                }
            }
        }
        a(str2, 0, bVar);
        com.baidu.tieba.pb.data.i.a(qVar, bVar);
        return bVar;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.euy) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.euy = false;
        } else if (aPv()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.euy) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.euy = false;
        } else if (aPv()) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void iu(boolean z) {
        this.evc = z;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a005";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.euf != null) {
            if (this.euf.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(this.euf.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.h.b.c(this.euf.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aPv() {
        return (!this.euw && this.evH == -1 && this.evI == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.evK = nVar;
            this.euw = true;
            this.euP.aRM();
            this.euP.pC(this.evJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPw() {
        if (this.evK != null) {
            if (this.evH == -1) {
                showToast(r.j.pb_manga_not_prev_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.evK.getCartoonId(), this.evH, 0)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPx() {
        if (this.evK != null) {
            if (this.evI == -1) {
                showToast(r.j.pb_manga_not_next_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.evK.getCartoonId(), this.evI, 0)));
            finish();
        }
    }

    public int aPy() {
        return this.evH;
    }

    public int aPz() {
        return this.evI;
    }

    private void aqB() {
        if (this.euf != null && this.euf.getPbData() != null && this.euf.getPbData().aOl() != null && this.euf.getPbData().aOl().sB()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aPA() {
        if (this.euf != null && this.euf.getPbData() != null && this.euf.getPbData().aOl() != null && this.euf.getPbData().aOl().sB()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aPB() {
        if (this.euz) {
            this.euM = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.euf.getPbData() != null && this.euf.getPbData().aOl() != null && this.euf.getPbData().aOl().rz() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.euf.getPbData().aOl().rz().getThreadId(), this.euf.getPbData().aOl().rz().getTaskId(), this.euf.getPbData().aOl().rz().getForumId(), this.euf.getPbData().aOl().rz().getForumName(), this.euf.getPbData().aOl().rL(), this.euf.getPbData().aOl().rM())));
            this.euy = true;
            finish();
        }
    }

    public boolean aPC() {
        return this.euz;
    }

    public String aPD() {
        return this.euK;
    }

    public PbInterviewStatusView.a aPE() {
        return this.euN;
    }

    public void iv(boolean z) {
        this.euL = z;
    }

    public boolean aPF() {
        if (this.euf != null) {
            return this.euf.aQq();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPG() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cF(getResources().getString(r.j.mute_is_super_member_function));
        aVar.a(r.j.open_now, new ca(this));
        aVar.b(r.j.cancel, new cb(this));
        aVar.b(this.eve).tq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(String str) {
        if (str == null) {
            str = "";
        }
        if (this.eve != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eve.getPageActivity());
            aVar.cF(str);
            aVar.b(r.j.know, new cc(this));
            aVar.b(this.eve).tq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.euP.aAF();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eve.getPageActivity());
        if (com.baidu.tbadk.core.util.ax.isEmpty(str)) {
            aVar.cF(this.eve.getResources().getString(r.j.block_mute_message_alert, str2));
        } else {
            aVar.cF(str);
        }
        aVar.a(r.j.confirm, new cd(this, userMuteAddAndDelCustomMessage));
        aVar.b(r.j.cancel, new ce(this));
        aVar.b(this.eve).tq();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.b
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.h[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.h.class);
            for (int i = 0; i < objArr.length; i++) {
                if (gq.pD(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_pb_wenxue)) != null) {
                    int i2 = -((int) ((tbRichTextView.getLineSpacing() - 1.0f) * textView.getLineHeight()));
                    drawable.setBounds(0, i2, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight() + i2);
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                    spannableStringBuilder2.setSpan(new com.baidu.tbadk.widget.f(drawable), 0, "#4%2&@#907$12#@96476)w7we9e~@$%&&".length(), 18);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                    spannableStringBuilder.setSpan(objArr[i], spannableStringBuilder.getSpanStart(objArr[i]), spannableStringBuilder.length(), 18);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                    spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                    return;
                }
            }
        }
    }
}
