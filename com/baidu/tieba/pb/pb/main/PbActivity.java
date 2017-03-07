package com.baidu.tieba.pb.pb.main;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.sapi2.SapiAccountManager;
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
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
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
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.e.a;
import com.baidu.tieba.e.c;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.a.f;
import com.baidu.tieba.pb.pb.main.cx;
import com.baidu.tieba.pb.pb.main.da;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.w;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.b, com.baidu.tbadk.widget.richText.d {
    private com.baidu.adp.lib.e.b<ImageView> aNa;
    private com.baidu.adp.lib.e.b<TextView> aNb;
    private com.baidu.adp.lib.e.b<View> aNc;
    private com.baidu.adp.lib.e.b<View> aNd;
    private com.baidu.adp.lib.e.b<LinearLayout> aNe;
    private com.baidu.adp.lib.e.b<GifView> aNf;
    private com.baidu.adp.lib.e.b<TbImageView> alR;
    private VoiceManager bMM;
    private com.baidu.tbadk.e.a bNm;
    private com.baidu.tieba.e.c bQp;
    private String ejX;
    private com.baidu.tieba.pb.pb.main.b ekE;
    private dr ekR;
    private boolean ekW;
    private com.baidu.tieba.tbadkCore.data.e ekX;
    private com.baidu.tbadk.editortools.pb.c ekY;
    private com.baidu.tieba.pb.pb.main.a.f eks;
    private com.baidu.tbadk.core.dialog.a ekx;
    private boolean elA;
    private String elL;
    private com.baidu.tbadk.core.data.n elM;
    private com.baidu.adp.base.g elb;
    private com.baidu.tbadk.core.view.h elc;
    private BdUniqueId eld;
    private Runnable ele;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean ekr = false;
    private boolean ekt = false;
    private boolean eku = false;
    private boolean dMB = false;
    private int ekv = 0;
    private com.baidu.tbadk.core.dialog.c ekw = null;
    private long bEN = -1;
    private long aGp = 0;
    private long eky = 0;
    private long createTime = 0;
    private long aGh = 0;
    private boolean ekz = false;
    private com.baidu.tbadk.performanceLog.e ekA = null;
    private long ekB = 0;
    private boolean ekC = false;
    private boolean ekD = false;
    private String aAE = null;
    private boolean ekF = false;
    private boolean ekG = false;
    private String ekH = "";
    private boolean ekI = true;
    private boolean ekJ = false;
    private String source = "";
    private PbInterviewStatusView.a ekK = new i(this);
    private final Handler mHandler = new Handler(new t(this));
    private PbModel ejZ = null;
    private com.baidu.tbadk.baseEditMark.a dIP = null;
    private ForumManageModel ekL = null;
    private fa ekM = null;
    public final com.baidu.tieba.pb.pb.main.a.a ekN = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean ekO = false;
    private boolean ekP = false;
    private boolean ekQ = false;
    private boolean ekS = false;
    private boolean ekT = false;
    private boolean ekU = false;
    private boolean ekV = false;
    private boolean ekZ = false;
    private com.baidu.tbadk.editortools.pb.b aAI = new ae(this);
    private boolean ela = false;
    private int cDd = -1;
    private int elf = -1;
    private final CustomMessageListener elg = new ap(this, CmdConfigCustom.PB_RESET_EDITOR_TOOL);
    CustomMessageListener bNG = new ba(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private CustomMessageListener elh = new bl(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener dqe = new bu(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener dqB = new cf(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener eli = new ci(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener aNU = new j(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
    private CustomMessageListener cQh = new k(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private cx.a elj = new l(this);
    private View.OnClickListener dqd = new m(this);
    private CustomMessageListener elk = new n(this, CmdConfigCustom.CMD_SEND_GIFT_SUCCESS);
    private boolean ell = false;
    private PraiseModel elm = new PraiseModel(getPageContext(), new o(this));
    private long eln = 0;
    private boolean elo = true;
    private f.a elp = new p(this);
    private CustomMessageListener bad = new q(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener elq = new r(this, CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED);
    private com.baidu.tieba.pb.a.d ejf = new com.baidu.tieba.pb.a.d(new s(this));
    private CustomMessageListener elr = new u(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener els = new v(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener elt = new w(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    public a.b dVF = new x(this);
    public final View.OnClickListener bOI = new y(this);
    private final NewWriteModel.d aAO = new z(this);
    private final PbModel.a elu = new aa(this);
    private CustomMessageListener elv = new ab(this, CmdConfigCustom.CMD_WX_SHARE_SUCCESS);
    private CustomMessageListener elw = new ac(this, CmdConfigCustom.CMD_TTS_OPTION_PB);
    private final a.InterfaceC0030a elx = new ad(this);
    private final AbsListView.OnScrollListener mOnScrollListener = new af(this);
    private final com.baidu.adp.base.f ely = new ag(this);
    private final c elz = new ah(this);
    private final ab.b aYm = new ai(this);
    private final BdListView.e elB = new aj(this);
    private int elC = 0;
    private final TbRichTextView.e aNu = new ak(this);
    boolean elD = false;
    PostData elE = null;
    private final c.b elF = new al(this);
    private final View.OnLongClickListener asV = new am(this);
    private final NoNetworkView.a bMe = new an(this);
    public View.OnTouchListener aNR = new ao(this);
    private a.InterfaceC0056a aQW = new aq(this);
    private final c.a elG = new ar(this);
    private String elH = null;
    private final da.a elI = new as(this);
    private int elJ = -1;
    private int elK = -1;
    private CustomMessageListener elN = new at(this, CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST);
    private final CustomMessageListener bNK = new au(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> emf;
        public ConcurrentHashMap<String, ImageUrlData> emg;
        public boolean emi;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean emh = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes.dex */
    public interface c {
    }

    public void ih(boolean z) {
        this.ekC = z;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.pb.c aKf() {
        return this.ekY;
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        if (jVar.aJO() != null) {
            String id = jVar.aJO().getId();
            ArrayList<PostData> aJs = this.ejZ.getPbData().aJs();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aJs.size()) {
                    break;
                }
                PostData postData = aJs.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aJS = jVar.aJS();
                    postData.rT(jVar.getTotalCount());
                    if (postData.bhA() != null) {
                        postData.bhA().clear();
                        postData.bhA().addAll(aJS);
                    }
                }
            }
            this.ekM.k(this.ejZ.getPbData());
        }
    }

    public void aKg() {
        com.baidu.tieba.pb.data.f pbData;
        com.baidu.tbadk.core.data.bj aJq;
        if (!this.ell) {
            if (!com.baidu.adp.lib.util.k.hv()) {
                showToast(w.l.no_network_guide);
            } else if (this.elo) {
                this.ell = true;
                if (this.ejZ != null && (pbData = this.ejZ.getPbData()) != null && (aJq = pbData.aJq()) != null) {
                    int isLike = aJq.rG() == null ? 0 : aJq.rG().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10796").Z("tid", aJq.getId()));
                    }
                    if (this.elm != null) {
                        this.elm.a(aJq.sg(), aJq.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        String string;
        if ((sparseArray.get(w.h.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(w.h.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(w.h.tag_check_mute_from) instanceof Integer)) {
            String str = (String) sparseArray.get(w.h.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(w.h.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(w.h.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
                cVar.bZ(w.l.operation);
                int i = -1;
                if (sparseArray.get(w.h.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(w.h.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(w.l.delete);
                    if (z) {
                        string = getResources().getString(w.l.un_mute);
                    } else {
                        string = getResources().getString(w.l.mute);
                    }
                    strArr[1] = string;
                    cVar.a(strArr, new av(this, sparseArray, z, str2, str));
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(w.l.un_mute) : getResources().getString(w.l.mute);
                    cVar.a(strArr2, new aw(this, sparseArray, z, str2, str));
                }
                cVar.d(getPageContext()).tv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m18if(int i) {
        com.baidu.tbadk.core.data.bj aJq;
        String sb;
        String w;
        if (this.ejZ != null && this.ejZ.getPbData() != null && (aJq = this.ejZ.getPbData().aJq()) != null) {
            if (i == 1) {
                PraiseData rG = aJq.rG();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rG == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aJq.a(praiseData);
                    } else {
                        aJq.rG().getUser().add(0, metaData);
                        aJq.rG().setNum(aJq.rG().getNum() + 1);
                        aJq.rG().setIsLike(i);
                    }
                }
                if (aJq.rG() != null) {
                    if (aJq.rG().getNum() < 1) {
                        w = getResources().getString(w.l.frs_item_praise_text);
                    } else {
                        w = com.baidu.tbadk.core.util.au.w(aJq.rG().getNum());
                    }
                    this.ekM.P(w, true);
                }
            } else if (aJq.rG() != null) {
                aJq.rG().setIsLike(i);
                aJq.rG().setNum(aJq.rG().getNum() - 1);
                ArrayList<MetaData> user = aJq.rG().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aJq.rG().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aJq.rG().getNum() < 1) {
                    sb = getResources().getString(w.l.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(aJq.rG().getNum())).toString();
                }
                this.ekM.P(sb, false);
            }
            if (this.ejZ.aLu()) {
                this.ekM.aMX().notifyDataSetChanged();
            } else {
                this.ekM.l(this.ejZ.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apE && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        if (this.ejZ != null && this.ejZ.getPbData() != null && this.ekM != null) {
            this.ekM.d(this.ejZ.getPbData(), this.ejZ.aLu(), this.ejZ.aLK());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bNm == null) {
                this.bNm = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bNm.an(updateAttentionMessage.getData().toUid, this.ejZ.getPbData().getForumId());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.ejZ.o(bundle);
        if (this.bMM != null) {
            this.bMM.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.ekY.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.elb = getPageContext();
        Intent intent = getIntent();
        if (intent != null) {
            this.bEN = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.ekH = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.ekH)) {
                this.ekt = true;
            }
            this.elJ = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.elK = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.elL = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            this.ekT = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
            if (aKC()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.au.isEmpty(this.source) ? "" : this.source;
            this.elf = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
        } else {
            this.bEN = System.currentTimeMillis();
        }
        this.eky = System.currentTimeMillis();
        this.aGh = this.eky - this.bEN;
        super.onCreate(bundle);
        this.ekv = 0;
        q(bundle);
        if (this.ejZ != null && this.ejZ.getPbData() != null) {
            this.ejZ.getPbData().nm(this.source);
        }
        initUI();
        if (intent != null && this.ekM != null) {
            this.ekM.eqy = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
            if (!StringUtils.isNull(intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME))) {
                if (this.ele == null) {
                    this.ele = new ax(this, intent);
                }
                getSafeHandler().postDelayed(this.ele, 1500L);
            }
        }
        this.bMM = new VoiceManager();
        this.bMM.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.pb.l lVar = new com.baidu.tbadk.editortools.pb.l();
        lVar.setForumName(this.ejZ.aLt());
        if (this.ejZ.getPbData() != null && this.ejZ.getPbData().aJp() != null) {
            lVar.setForumId(this.ejZ.getPbData().aJp().getId());
        }
        lVar.setFrom("pb");
        lVar.a(this.ejZ);
        this.ekY = (com.baidu.tbadk.editortools.pb.c) lVar.aL(getActivity());
        this.ekY.d(this);
        this.ekY.a(this.aAO);
        this.ekY.a(this.aAI);
        this.ekY.a(this, bundle);
        this.ekY.CP().c(new com.baidu.tbadk.editortools.w(getActivity()));
        this.ekY.CP().bB(true);
        ii(true);
        this.ekM.setEditorTools(this.ekY.CP());
        this.ekY.a(this.ejZ.aLB(), this.ejZ.getThreadID(), this.ejZ.aLU());
        registerListener(this.dqe);
        if (!this.ejZ.aLy()) {
            this.ekY.fr(this.ejZ.getThreadID());
        }
        if (this.ejZ.aLV()) {
            this.ekY.fp(getPageContext().getString(w.l.pb_reply_hint_from_smart_frs));
        } else {
            this.ekY.fp(getPageContext().getString(w.l.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.eky;
        registerListener(this.elh);
        registerListener(this.dqB);
        registerListener(this.eli);
        registerListener(this.aNU);
        registerListener(this.bNG);
        registerListener(this.elg);
        this.ekX = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.ftG);
        this.ekX.bhb();
        registerListener(this.elk);
        registerListener(this.bad);
        if (this.ejZ != null) {
            this.ejZ.aLM();
        }
        if (TbadkCoreApplication.m9getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.elq);
        registerListener(this.elw);
        registerListener(this.elv);
        registerListener(this.elN);
        this.ekE = new com.baidu.tieba.pb.pb.main.b(this.ejZ, this);
        if (this.ekM != null && this.ekM.aNB() != null && this.ekM.aNC() != null) {
            this.eks = new com.baidu.tieba.pb.pb.main.a.f(getActivity(), this.ekM.aNB(), this.ekM.aNC());
            this.eks.a(this.elp);
        }
        if (this.ekr && this.ekM != null && this.ekM.aNC() != null) {
            this.ekM.aNC().setVisibility(8);
        }
        this.elc = new com.baidu.tbadk.core.view.h();
        this.elc.ajk = 1000L;
        registerListener(this.elt);
        registerListener(this.elr);
        registerListener(this.els);
        this.eld = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eld;
        userMuteAddAndDelCustomMessage.setTag(this.eld);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eld;
        userMuteCheckCustomMessage.setTag(this.eld);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public String aKh() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.f aKi() {
        return this.eks;
    }

    private void ii(boolean z) {
        this.ekY.bE(z);
        this.ekY.bF(z);
        this.ekY.bG(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bMM != null) {
            this.bMM.onStart(getPageContext());
        }
    }

    public fa aKj() {
        return this.ekM;
    }

    public PbModel aKk() {
        return this.ejZ;
    }

    public void nn(String str) {
        if (this.ejZ != null && !StringUtils.isNull(str) && this.ekM != null) {
            this.ekM.aMY();
            this.ekM.iT(true);
            this.ejZ.nn(str);
            this.ekF = true;
            this.ekM.awO();
            this.ekM.aNu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.m9getInst().isReadMenuDialogOnTop()) {
            this.eku = false;
        } else {
            this.eku = true;
        }
        super.onPause();
        if (this.ekM.aMF() != null && this.ekM.aMF().aKc() != null) {
            this.ekM.aMF().aKc().onPause();
        }
        BdListView listView = getListView();
        this.ekv = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.ekv == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.bMM != null) {
            this.bMM.onPause(getPageContext());
        }
        if (this.ekM != null) {
            this.ekM.onPause();
        }
        if (!this.ejZ.aLy()) {
            this.ekY.fq(this.ejZ.getThreadID());
        }
        if (this.ejZ != null) {
            this.ejZ.aLN();
        }
        MessageManager.getInstance().unRegisterListener(this.cQh);
        alx();
        MessageManager.getInstance().unRegisterListener(this.elr);
        MessageManager.getInstance().unRegisterListener(this.els);
        MessageManager.getInstance().unRegisterListener(this.elt);
        MessageManager.getInstance().unRegisterListener(this.bNK);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aKl() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.ejZ.getPbData(), this.ejZ.aLu(), this.ejZ.aLK());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eku = false;
        super.onResume();
        if (this.ekJ) {
            this.ekJ = false;
            aKI();
        }
        if (this.ekM.aMF() != null && this.ekM.aMF().aKc() != null) {
            this.ekM.aMF().aKc().onResume();
        }
        if (aKl()) {
            this.ekB = System.currentTimeMillis();
        } else {
            this.ekB = -1L;
        }
        if (this.ekM != null && this.ekM.getView() != null) {
            if (!this.dMB) {
                aKA();
            } else {
                hideLoadingView(this.ekM.getView());
            }
            this.ekM.onResume();
        }
        if (this.ekv == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.ekM != null) {
            noNetworkView = this.ekM.aMG();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.he()) {
            noNetworkView.aJ(false);
        }
        if (this.bMM != null) {
            this.bMM.onResume(getPageContext());
        }
        registerListener(this.cQh);
        this.ekW = false;
        aKH();
        registerListener(this.elr);
        registerListener(this.els);
        registerListener(this.elt);
        registerListener(this.bNK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.ekM.iH(z);
        if (this.ekR != null) {
            this.ekR.it(z);
        }
        if (z && this.ekW) {
            this.ekM.aNd();
            this.ejZ.ip(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ekB > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10804").Z("obj_duration", new StringBuilder(String.valueOf(System.currentTimeMillis() - this.ekB)).toString()));
            this.ekB = 0L;
        }
        if (this.ekY != null && this.ekY.CP() != null && this.ekY.CP().getVisibility() != 0) {
            this.ekY.Dz();
        }
        if (aKj().aMJ() != null) {
            aKj().aMJ().onStop();
        }
        if (this.ekM.eqM != null && !this.ekM.eqM.Tj()) {
            this.ekM.eqM.axf();
        }
        if (this.ejZ != null && this.ejZ.getPbData() != null && this.ejZ.getPbData().aJp() != null && this.ejZ.getPbData().aJq() != null) {
            com.baidu.tbadk.distribute.a.Cz().b(getPageContext().getPageActivity(), "pb", this.ejZ.getPbData().aJp().getId(), com.baidu.adp.lib.g.b.c(this.ejZ.getPbData().aJq().getId(), 0L));
        }
        if (this.bMM != null) {
            this.bMM.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.ekE != null) {
            this.ekE.destroy();
        }
        if (this.ekS && this.ejZ != null) {
            a(this.ejZ.getPbData(), -2, 0, false, false);
        }
        if (!this.ekz && this.ekM != null) {
            this.ekz = true;
            this.ekM.aNt();
            a(false, (PostData) null);
        }
        if (this.ejZ != null) {
            this.ejZ.cancelLoadData();
            this.ejZ.destory();
        }
        if (this.ekY != null) {
            this.ekY.onDestroy();
        }
        if (this.ekL != null) {
            this.ekL.cancelLoadData();
        }
        if (this.ekM != null) {
            this.ekM.onDestroy();
            if (this.ekM.eqM != null) {
                this.ekM.eqM.axf();
            }
        }
        if (this.ekA != null) {
            this.ekA.onDestroy();
        }
        if (this.eks != null) {
            this.eks.WI();
        }
        super.onDestroy();
        if (this.bMM != null) {
            this.bMM.onDestory(getPageContext());
        }
        if (this.bNm != null) {
            this.bNm.destory();
        }
        this.ekM.awO();
        MessageManager.getInstance().unRegisterListener(this.elr);
        MessageManager.getInstance().unRegisterListener(this.els);
        MessageManager.getInstance().unRegisterListener(this.elt);
        MessageManager.getInstance().unRegisterListener(this.eld);
        this.elb = null;
        this.elc = null;
        com.baidu.tieba.recapp.c.a.aZL().aZN();
        if (this.ele != null) {
            getSafeHandler().removeCallbacks(this.ele);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        cp aMX;
        ArrayList<PostData> aKV;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xI() && this.ekM != null && (aMX = this.ekM.aMX()) != null && (aKV = aMX.aKV()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aKV.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostData next = it.next();
                String id = next.getId();
                i++;
                if (z) {
                    if (next == postData) {
                        a.b bVar = new a.b();
                        bVar.bqD = id;
                        bVar.buU = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.Yz == 1 && !TextUtils.isEmpty(id)) {
                    next.Yz = 2;
                    a.b bVar2 = new a.b();
                    bVar2.bqD = id;
                    bVar2.buU = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.ejZ == null || this.ejZ.getPbData() == null || this.ejZ.getPbData().aJp() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.ejZ.getPbData().aJp().getFirst_class();
                    str2 = this.ejZ.getPbData().aJp().getSecond_class();
                    str = this.ejZ.getPbData().aJp().getId();
                    str4 = this.ejZ.getThreadID();
                }
                com.baidu.tieba.recapp.t.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.xM());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ekM.onChangeSkinType(i);
        if (this.ekY != null && this.ekY.CP() != null) {
            this.ekY.CP().onChangeSkinType(i);
        }
        if (this.ekM.aMG() != null) {
            this.ekM.aMG().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.ekM = new fa(this, this.bOI, this.ejf);
        this.bQp = new com.baidu.tieba.e.c(getActivity());
        this.bQp.a(this.elG);
        this.bQp.a(this.aQW);
        this.ekM.setOnScrollListener(this.mOnScrollListener);
        this.ekM.d(this.elB);
        this.ekM.a(this.aYm);
        this.ekM.ib(com.baidu.tbadk.core.l.oQ().oW());
        this.ekM.setOnImageClickListener(this.aNu);
        this.ekM.a(this.asV);
        this.ekM.h(this.bMe);
        this.ekM.a(this.elz);
        this.ekM.iH(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aX(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(w.h.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.fui == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.l.oQ().oW()) {
                    return false;
                }
                return nr(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.ekM != null) {
            if (z && (!this.dMB || this.ela)) {
                aKA();
            } else {
                hideLoadingView(this.ekM.getView());
            }
            this.ela = false;
        }
    }

    private void aKm() {
        if (this.ekw == null) {
            this.ekw = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.ekw.a(new String[]{getPageContext().getString(w.l.call_phone), getPageContext().getString(w.l.sms_phone), getPageContext().getString(w.l.search_in_baidu)}, new ay(this)).ca(c.a.aaA).cb(17).d(getPageContext());
        }
    }

    private void q(Bundle bundle) {
        this.ejZ = new PbModel(this);
        this.ejZ.a(this.elu);
        if (this.ejZ.aLS() != null) {
            this.ejZ.aLS().a(this.elI);
        }
        if (this.ejZ.aLR() != null) {
            this.ejZ.aLR().a(this.elj);
        }
        if (bundle != null) {
            this.ejZ.initWithBundle(bundle);
        } else {
            this.ejZ.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra("request_code", -1) == 18003) {
            this.ejZ.is(true);
        }
        er.aMB().O(this.ejZ.aLs(), this.ejZ.getIsFromMark());
        if (StringUtils.isNull(this.ejZ.getThreadID())) {
            finish();
        } else {
            this.ejZ.Fe();
        }
    }

    private void initData(Bundle bundle) {
        this.dIP = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dIP != null) {
            this.dIP.a(this.elx);
        }
        this.ekL = new ForumManageModel(this);
        this.ekL.setLoadDataCallBack(this.ely);
        this.ekM.a(new az(this));
        this.elm.setUniqueId(getUniqueId());
        this.elm.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.ekM.auC();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(w.h.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.eld;
        userMuteCheckCustomMessage.setTag(this.eld);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKn() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.bV(w.l.go_setting_float_window_permission);
        aVar.bW(w.l.step_to_setting_float_permission);
        aVar.a(w.l.go_and_setting, new bb(this));
        aVar.b(w.l.cancel, new bc(this));
        aVar.b(getPageContext()).ts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aKo() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.ejZ != null && this.ejZ.getPbData() != null) {
            com.baidu.tieba.pb.data.f pbData = this.ejZ.getPbData();
            if (pbData.aJp() != null) {
                sb.append("forum_name=").append(no(pbData.aJp().getName()));
                sb.append("&");
            }
            if (pbData.aJq() != null) {
                com.baidu.tbadk.core.data.bj aJq = pbData.aJq();
                sb.append("thread_id=").append(aJq.getId());
                sb.append("&");
                sb.append("thread_title=").append(no(aJq.getTitle()));
                if (aJq.getAuthor() != null && aJq.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aJq.getAuthor().getPortrait());
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
            getSafeHandler().postDelayed(new bd(this, iArr, measuredHeight, str, str2), 500L);
        }
    }

    private String no(String str) {
        return URLEncoder.encode(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3092=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        PostData postData;
        if (!checkUpIsLogin() || sparseArray == null || !(sparseArray.get(w.h.tag_clip_board) instanceof PostData) || (postData = (PostData) sparseArray.get(w.h.tag_clip_board)) == null || this.ejZ == null || this.ejZ.getPbData() == null || postData.bhD() <= 1) {
            return;
        }
        String threadID = this.ejZ.getThreadID();
        String id = postData.getId();
        int aJA = this.ejZ.getPbData() != null ? this.ejZ.getPbData().aJA() : 0;
        b ns = ns(id);
        if (ns != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, aJA, postData.aOS(), this.ejZ.getPbData().qE(), false, postData.getAuthor() != null ? postData.getAuthor().getIconInfo() : null).addBigImageData(ns.emf, ns.emg, ns.emh, ns.index)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aKp() {
        if (this.ejZ.getPbData() == null || this.ejZ.getPbData().aJq() == null) {
            return -1;
        }
        return this.ejZ.getPbData().aJq().su();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ij(boolean z) {
        if (this.ejZ == null || this.ejZ.getPbData() == null) {
            return false;
        }
        return ((this.ejZ.getPbData().aJA() != 0) || this.ejZ.getPbData().aJq() == null || this.ejZ.getPbData().aJq().getAuthor() == null || TextUtils.equals(this.ejZ.getPbData().aJq().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean ik(boolean z) {
        if (z) {
            return true;
        }
        if (this.ejZ == null || this.ejZ.getPbData() == null) {
            return false;
        }
        return this.ejZ.getPbData().aJA() != 0;
    }

    private boolean il(boolean z) {
        return (z || this.ejZ == null || this.ejZ.getPbData() == null || this.ejZ.getPbData().aJA() == 0) ? false : true;
    }

    public void aKq() {
        if (this.ejZ != null && this.ejZ.getPbData() != null && this.ejZ.getPbData().aJq() != null && this.ejZ.getPbData().aJq().getAuthor() != null) {
            com.baidu.tbadk.core.data.bj aJq = this.ejZ.getPbData().aJq();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aJq.getAuthor().getUserId());
            GodUserData godUserData = aJq.getAuthor().getGodUserData();
            boolean z = equals && godUserData != null && godUserData.isCanSendCall();
            dv dvVar = new dv();
            if (this.ejZ.getPbData().aJA() == 1) {
                dvVar.eoJ = true;
                dvVar.eoI = true;
                dvVar.eoO = aJq.rM() == 1;
                dvVar.eoN = aJq.rN() == 1;
            } else {
                dvVar.eoJ = false;
                dvVar.eoI = false;
            }
            dvVar.eoH = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteShareActivityConfig.class);
            dvVar.eoF = TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            dvVar.eoK = ik(equals);
            dvVar.eoL = aKr();
            dvVar.eoM = il(equals);
            dvVar.eoG = this.ejZ.aLu();
            dvVar.eiu = this.dIP != null ? this.dIP.nH() : false;
            dvVar.eoE = ij(equals);
            dvVar.eoC = equals && this.ekM.aNl();
            dvVar.eoD = z;
            dvVar.isHostOnly = this.ejZ.getHostMode();
            if (aJq.sh() == null) {
                dvVar.eoP = false;
            } else {
                dvVar.eoP = true;
            }
            this.ekM.eqM.a(dvVar);
        }
    }

    private boolean aKr() {
        if (this.ejZ != null && this.ejZ.aLu()) {
            return this.ejZ.ama() == null || this.ejZ.ama().qR() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(w.h.tag_clip_board)) != null) {
            d(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, boolean z2) {
        if (fVar != null && this.ejZ != null) {
            ei eiVar = new ei(getUniqueId());
            eiVar.pbData = fVar;
            eiVar.threadId = this.ejZ.getThreadID();
            eiVar.postId = this.ejZ.getPostId();
            eiVar.epS = i;
            eiVar.epT = i2;
            eiVar.epR = this.ejZ.getHostMode();
            eiVar.eiu = this.ejZ.nH();
            eiVar.isSquence = this.ejZ.aLu();
            eiVar.loadType = this.ejZ.aLP();
            eiVar.epU = z;
            eiVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, eiVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, boolean z2) {
        if (fVar != null && this.ejZ != null) {
            ei eiVar = new ei(getUniqueId());
            eiVar.pbData = fVar;
            eiVar.threadId = this.ejZ.getThreadID();
            eiVar.postId = this.ejZ.getPostId();
            eiVar.epS = i;
            eiVar.epR = this.ejZ.getHostMode();
            eiVar.eiu = this.ejZ.nH();
            eiVar.isSquence = this.ejZ.aLu();
            eiVar.loadType = this.ejZ.aLP();
            eiVar.epU = z;
            eiVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, eiVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        aww();
    }

    public void a(boolean z, MarkData markData) {
        this.ekM.aNe();
        this.ejZ.ir(z);
        if (this.dIP != null) {
            this.dIP.ac(z);
            if (markData != null) {
                this.dIP.a(markData);
            }
        }
        if (this.ejZ.nH()) {
            aKx();
        } else {
            this.ekM.k(this.ejZ.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean od(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void np(String str) {
        if (!StringUtils.isNull(str) && this.ejZ != null) {
            String threadID = this.ejZ.getThreadID();
            String id = this.ejZ.getPbData().aJp().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(w.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.ejZ.aLy()) {
                    antiData.setBlock_forum_name(this.ejZ.getPbData().aJp().getName());
                    antiData.setBlock_forum_id(this.ejZ.getPbData().aJp().getId());
                    antiData.setUser_name(this.ejZ.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.ejZ.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.e.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.rZ(i)) {
            AntiHelper.an(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            fx(str);
        } else {
            this.ekM.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.ekM.a(0, bVar.Bi, bVar.fwq, z);
            if (bVar.Bi) {
                if (bVar.fwo == 1) {
                    ArrayList<PostData> aJs = this.ejZ.getPbData().aJs();
                    int size = aJs.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aJs.get(i).getId())) {
                            i++;
                        } else {
                            aJs.remove(i);
                            break;
                        }
                    }
                    this.ekM.k(this.ejZ.getPbData());
                } else if (bVar.fwo == 0) {
                    aKs();
                } else if (bVar.fwo == 2) {
                    ArrayList<PostData> aJs2 = this.ejZ.getPbData().aJs();
                    int size2 = aJs2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aJs2.get(i2).bhA().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aJs2.get(i2).bhA().get(i3).getId())) {
                                i3++;
                            } else {
                                aJs2.get(i2).bhA().remove(i3);
                                aJs2.get(i2).bhC();
                                z2 = true;
                                break;
                            }
                        }
                        aJs2.get(i2).pM(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.ekM.k(this.ejZ.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.f fVar) {
        if (fVar != null) {
            this.ekM.a(this.ekL.getLoadDataMode(), fVar.Bi, fVar.fwq, false);
            if (fVar.Bi) {
                this.ekO = true;
                if (i == 2 || i == 3) {
                    this.ekP = true;
                    this.ekQ = false;
                } else if (i == 4 || i == 5) {
                    this.ekP = false;
                    this.ekQ = true;
                }
                if (i == 2) {
                    this.ejZ.getPbData().aJq().bR(1);
                    this.ejZ.setIsGood(1);
                } else if (i == 3) {
                    this.ejZ.getPbData().aJq().bR(0);
                    this.ejZ.setIsGood(0);
                } else if (i == 4) {
                    this.ejZ.getPbData().aJq().bQ(1);
                    this.ejZ.gS(1);
                } else if (i == 5) {
                    this.ejZ.getPbData().aJq().bQ(0);
                    this.ejZ.gS(0);
                }
                this.ekM.d(this.ejZ.getPbData(), this.ejZ.aLu());
                com.baidu.tieba.c.a.a(getPageContext(), 2, i);
            }
        }
    }

    private void aKs() {
        if (this.ejZ.aLv() || this.ejZ.aLw()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.ejZ.getThreadID());
            setResult(-1, intent);
        }
        if (aKy()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKt() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aJy;
        if (this.ekM != null) {
            this.ekM.awO();
        }
        if (this.ejZ != null && this.ejZ.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.ejZ.getPbData().aJq().getId();
            historyMessage.forumName = this.ejZ.getPbData().aJp().getName();
            historyMessage.threadName = this.ejZ.getPbData().aJq().getTitle();
            ArrayList<PostData> aJs = this.ejZ.getPbData().aJs();
            int aNg = this.ekM != null ? this.ekM.aNg() : 0;
            if (aJs != null && aNg >= 0 && aNg < aJs.size()) {
                historyMessage.postID = aJs.get(aNg).getId();
            }
            historyMessage.isHostOnly = this.ejZ.getHostMode();
            historyMessage.isSquence = this.ejZ.aLu();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.ekY != null) {
            this.ekY.onDestroy();
        }
        if (this.ejZ != null && (this.ejZ.aLv() || this.ejZ.aLw())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.ejZ.getThreadID());
            if (this.ekO) {
                if (this.ekQ) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.ejZ.awF());
                }
                if (this.ekP) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.ejZ.getIsGood());
                }
            }
            if (this.ejZ.getPbData() != null && System.currentTimeMillis() - this.eky >= 40000 && (aJy = this.ejZ.getPbData().aJy()) != null && !com.baidu.tbadk.core.util.x.q(aJy.getDataList())) {
                intent.putExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA, aJy);
                intent.putExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, this.elf);
            }
            setResult(-1, intent);
        }
        if (aKy()) {
            if (this.ejZ != null && this.ekM != null && this.ekM.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.ejZ.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.m9getInst().getDefaultBubble());
                    }
                    if (!pbData.aJx() && !this.ekF) {
                        er.aMB().a(this.ejZ.getPbData(), this.ekM.getListView().onSaveInstanceState(), this.ejZ.aLu(), this.ejZ.getHostMode());
                    }
                }
            } else {
                er.aMB().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.ekM == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.ekM.ov(i)) {
            return true;
        }
        switch (i) {
            case 4:
                if (this.ekM.aLn()) {
                    this.ekM.aLp();
                    return true;
                }
                return super.onKeyDown(i, keyEvent);
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oe(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(w.l.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.ekY.onActivityResult(i, i2, intent);
        if (aKj().aMJ() != null) {
            aKj().aMJ().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aKw();
                    return;
                case 13008:
                    er.aMB().reset();
                    this.mHandler.postDelayed(new be(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.ejZ != null) {
                        a(aKv(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    Q(intent);
                    return;
                case 24006:
                    P(intent);
                    return;
                case 24007:
                    if (aKp() == 1) {
                        aKu();
                        return;
                    }
                    return;
                case 24008:
                    this.ekM.ig(false);
                    if (this.ejZ.getPbData() != null && this.ejZ.getPbData().aJq() != null && this.ejZ.getPbData().aJq().sk() != null) {
                        this.ejZ.getPbData().aJq().sk().setStatus(2);
                        break;
                    }
                    break;
                case 25001:
                    break;
                default:
                    return;
            }
            if (this.ekE != null) {
                this.ekE.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aKj() != null && aKf() != null && aKj().aML() && com.baidu.tbadk.editortools.pb.a.Dm().getStatus() == 1) {
                    com.baidu.tbadk.editortools.pb.a.Dm().setStatus(0);
                    if (this.ekM != null) {
                        this.ekM.aMK();
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
    public void aKu() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.ejZ.getPbData() != null && this.ejZ.getPbData().aJq() != null && this.ejZ.getPbData().aJq().sb() != null && this.ejZ.getPbData().aJq().sb().size() > 0 && this.ejZ.getPbData().aJq().sb().get(0) != null) {
            this.mAwardActId = this.ejZ.getPbData().aJq().sb().get(0).pl();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.ejZ.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void P(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra("key_action", 0)) {
                case 1:
                    aqX();
                    return;
                case 2:
                    this.ekM.aMV();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aKv() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bK = this.ejZ.getPbData().bK(getPageContext().getPageActivity());
        PostData aMM = this.ekM.aMM();
        String str = "";
        if (aMM != null) {
            str = aMM.getId();
            String bT = aMM.bT(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(bT)) {
                bK[1] = bT;
            }
        }
        String sg = this.ejZ.getPbData().aJq().sg();
        if (sg != null && sg.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bK[1]);
        shareFromPBMsgData.setImageUrl(bK[0]);
        shareFromPBMsgData.setForumName(this.ejZ.getPbData().aJp().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.ejZ.getPbData().aJq().getId());
        shareFromPBMsgData.setTitle(this.ejZ.getPbData().aJq().getTitle());
        return shareFromPBMsgData;
    }

    private void Q(Intent intent) {
        a(aKv(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.ejZ != null && this.ejZ.getPbData() != null && this.ejZ.getPbData().aJq() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gs gsVar = new gs(getPageContext().getPageActivity());
            gsVar.setData(shareFromPBMsgData);
            aVar.bY(1);
            aVar.v(gsVar);
            aVar.a(w.l.share, new bf(this, gsVar, j, str, str2, shareFromPBMsgData));
            aVar.b(w.l.alert_no_button, new bg(this, gsVar));
            aVar.au(true);
            aVar.b(getPageContext()).ts();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                gsVar.G(shareFromPBMsgData.getImageUrl(), this.ejZ.getPbData().aJB() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.ejZ != null && this.ejZ.getPbData() != null && this.ejZ.getPbData().aJq() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gs gsVar = new gs(getPageContext().getPageActivity());
            gsVar.setData(shareFromPBMsgData);
            aVar.bY(1);
            aVar.v(gsVar);
            aVar.a(w.l.share, new bh(this, gsVar, i, str, j, shareFromPBMsgData));
            aVar.b(w.l.alert_no_button, new bi(this, gsVar));
            aVar.au(true);
            aVar.b(getPageContext()).ts();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                gsVar.G(shareFromPBMsgData.getImageUrl(), this.ejZ.getPbData().aJB() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKw() {
        MarkData op;
        if (this.dIP != null && (op = this.ejZ.op(this.ekM.aNh())) != null) {
            if (!op.isApp() || (op = this.ejZ.op(this.ekM.aNh() + 1)) != null) {
                this.ekM.aNc();
                this.dIP.a(op);
                if (!this.dIP.nH()) {
                    this.dIP.nJ();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.dIP.nI();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKx() {
        com.baidu.tieba.pb.data.f pbData = this.ejZ.getPbData();
        this.ejZ.ir(true);
        pbData.nl(this.dIP.nG());
        this.ekM.k(pbData);
    }

    private boolean aKy() {
        if (this.ejZ == null) {
            return true;
        }
        if (this.ejZ.nH()) {
            MarkData aLG = this.ejZ.aLG();
            if (aLG == null || !this.ejZ.getIsFromMark()) {
                return true;
            }
            MarkData op = this.ejZ.op(this.ekM.aNh());
            if (op == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aLG);
                setResult(-1, intent);
                return true;
            } else if (op.getPostId() == null || op.getPostId().equals(aLG.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aLG);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cx(String.format(getPageContext().getString(w.l.alert_update_mark), Integer.valueOf(op.getFloor())));
                aVar.a(w.l.alert_yes_btn, new bj(this, op, aLG, aVar));
                aVar.b(w.l.alert_no_button, new bk(this, aLG, aVar));
                aVar.a(new bm(this, aLG, aVar));
                aVar.b(getPageContext());
                aVar.ts();
                return false;
            }
        } else if (this.ejZ.getPbData() == null || this.ejZ.getPbData().aJs() == null || this.ejZ.getPbData().aJs().size() <= 0 || !this.ejZ.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.ekM == null) {
            return null;
        }
        return this.ekM.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int Is() {
        if (this.ekM == null) {
            return 0;
        }
        return this.ekM.aNo();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> It() {
        if (this.aNa == null) {
            this.aNa = new com.baidu.adp.lib.e.b<>(new bn(this), 8, 0);
        }
        return this.aNa;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> Iu() {
        if (this.aNb == null) {
            this.aNb = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aNb;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> Iv() {
        if (this.aNf == null) {
            this.aNf = new com.baidu.adp.lib.e.b<>(new bo(this), 20, 0);
        }
        return this.aNf;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Iw() {
        if (this.aNd == null) {
            this.aNd = new com.baidu.adp.lib.e.b<>(new bp(this), 8, 0);
        }
        return this.aNd;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Iy() {
        if (this.aNc == null) {
            this.aNc = com.baidu.tieba.graffiti.d.o(getPageContext().getPageActivity(), 6);
        }
        return this.aNc;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wX() {
        if (this.alR == null) {
            this.alR = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.alR;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void U(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.ekD = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void V(Context context, String str) {
        if (gt.nD(str) && this.ejZ != null && this.ejZ.getThreadID() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11664").s("obj_param1", 1).Z("post_id", this.ejZ.getThreadID()));
        }
        gt.aNK().g(getPageContext(), str);
        this.ekD = true;
    }

    private com.baidu.tbadk.core.dialog.a aKz() {
        if (this.ekx == null) {
            this.ekx = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.ekx.cw(getPageContext().getString(w.l.download_baidu_video_dialog));
            this.ekx.a(getPageContext().getString(w.l.install), new bq(this));
            this.ekx.b(getPageContext().getString(w.l.cancel), new br(this));
            this.ekx.at(true);
            this.ekx.b(getPageContext());
            this.ekx.au(false);
        }
        this.ekx.ts();
        return this.ekx;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void W(Context context, String str) {
        gt.aNK().g(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.ekD = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Y(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra(VrPlayerActivityConfig.TITLE, "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            aKz();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.ekD = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void X(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        TbRichTextData tbRichTextData;
        int a2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.ejZ.getPbData();
            TbRichText am = am(str, i);
            if (am != null && (tbRichTextData = am.HP().get(this.elC)) != null) {
                bVar.emf = new ArrayList<>();
                bVar.emg = new ConcurrentHashMap<>();
                if (!tbRichTextData.HV().Ih()) {
                    bVar.emi = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    bVar.emf.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.postId = am.getPostId();
                    imageUrlData.mIsReserver = this.ejZ.aLF();
                    imageUrlData.mIsSeeHost = this.ejZ.getHostMode();
                    bVar.emg.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aJp() != null) {
                            bVar.forumName = pbData.aJp().getName();
                            bVar.forumId = pbData.aJp().getId();
                        }
                        if (pbData.aJq() != null) {
                            bVar.threadId = pbData.aJq().getId();
                        }
                        bVar.emh = pbData.aJB() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.emi = true;
                int size = pbData.aJs().size();
                this.elD = false;
                bVar.index = -1;
                int i2 = 0;
                int i3 = i;
                while (i2 < size) {
                    PostData postData = pbData.aJs().get(i2);
                    TbRichText aws = postData.aws();
                    if (!ez.g(postData)) {
                        a2 = a(aws, am, i3, i, bVar.emf, bVar.emg);
                    } else {
                        a2 = a(postData, i3, bVar.emf, bVar.emg);
                    }
                    i2++;
                    i3 = a2;
                }
                if (bVar.emf.size() > 0) {
                    bVar.lastId = bVar.emf.get(bVar.emf.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aJp() != null) {
                        bVar.forumName = pbData.aJp().getName();
                        bVar.forumId = pbData.aJp().getId();
                    }
                    if (pbData.aJq() != null) {
                        bVar.threadId = pbData.aJq().getId();
                    }
                    bVar.emh = pbData.aJB() == 1;
                }
                bVar.index = i3;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.HV() == null) {
            return null;
        }
        return tbRichTextData.HV().Il();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.HV() == null) {
            return 0L;
        }
        return tbRichTextData.HV().getOriginalSize();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo HV;
        if (tbRichText == tbRichText2) {
            this.elD = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.HP().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.HP().get(i6) == null || tbRichText.HP().get(i6).getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int width = tbRichText.HP().get(i6).HV().getWidth();
                    int height = tbRichText.HP().get(i6).HV().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.HP().get(i6).HV().Ih()) {
                        if (tbRichText == tbRichText2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.HP().get(i6);
                        String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                        if (!TextUtils.isEmpty(c2)) {
                            arrayList.add(c2);
                            if (tbRichTextData != null && (HV = tbRichTextData.HV()) != null) {
                                String Ij = HV.Ij();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = Ij;
                                imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.ejZ.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.ejZ.aLF();
                                imageUrlData.mIsSeeHost = this.ejZ.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.elD) {
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

    private int a(PostData postData, int i, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        com.baidu.tieba.tbadkCore.data.h bhL;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bhf;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bhf = (bhL = postData.bhL()).bhf()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bhf.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bhf.get(i3);
                if (jVar != null) {
                    String bhm = jVar.bhm();
                    if (!com.baidu.tbadk.core.util.au.isEmpty(bhm)) {
                        arrayList.add(bhm);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bhm;
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        imageUrlData.originalUrl = jVar.bhk();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.ejZ.getThreadID(), -1L);
                        imageUrlData.mIsReserver = this.ejZ.aLF();
                        imageUrlData.mIsSeeHost = this.ejZ.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bhL.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bhm, imageUrlData);
                        }
                        if (!this.elD) {
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
    public void d(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.ejZ.rZ())) {
                z = true;
            }
            MarkData e = this.ejZ.e(postData);
            if (e != null) {
                this.ekM.aNc();
                if (this.dIP != null) {
                    this.dIP.a(e);
                    if (!z) {
                        this.dIP.nJ();
                    } else {
                        this.dIP.nI();
                    }
                }
            }
        }
    }

    private TbRichText am(String str, int i) {
        if (this.ejZ == null || this.ejZ.getPbData() == null || str == null || i < 0) {
            return null;
        }
        return a(this.ejZ.getPbData().aJs(), str, i);
    }

    private long nq(String str) {
        ArrayList<PostData> aJs;
        com.baidu.tieba.pb.data.f pbData = this.ejZ.getPbData();
        if (pbData != null && (aJs = pbData.aJs()) != null && !aJs.isEmpty()) {
            Iterator<PostData> it = aJs.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bhL = next.bhL();
                if (bhL != null && bhL.ftO) {
                    Iterator<TbRichTextData> it2 = next.aws().HP().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.Id().getLink().equals(str)) {
                            return bhL.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> HP;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText aws = arrayList.get(i2).aws();
            if (aws != null && (HP = aws.HP()) != null) {
                int size = HP.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (HP.get(i4) != null && HP.get(i4).getType() == 8) {
                        i3++;
                        if (HP.get(i4).HV().Ij().equals(str)) {
                            int width = HP.get(i4).HV().getWidth();
                            int height = HP.get(i4).HV().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.elC = i4;
                            return aws;
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

    @Override // com.baidu.tbadk.widget.richText.d
    public void f(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.ejX = str;
            if (this.ekw == null) {
                aKm();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.ekw.cd(1).setVisibility(8);
            } else {
                this.ekw.cd(1).setVisibility(0);
            }
            this.ekw.tv();
            this.ekD = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bMM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aww() {
        hideNetRefreshView(this.ekM.getView());
        aKA();
        if (this.ejZ.Fe()) {
            this.ekM.aNc();
        }
    }

    private void aKA() {
        showLoadingView(this.ekM.getView(), false, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds400));
        View EB = getLoadingView().EB();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EB.getLayoutParams();
        layoutParams.addRule(3, this.ekM.aNB().getId());
        EB.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YT() {
        if (this.bMM != null) {
            this.bMM.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void of(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqX() {
        if (this.ejZ.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.ejZ.getPbData();
            String name = pbData.aJp().getName();
            String title = pbData.aJq().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.ejZ.getThreadID() + "?share=9105&fr=share&see_lz=" + (this.ejZ.getHostMode() ? 1 : 0);
            String[] bK = pbData.bK(getPageContext().getPageActivity());
            String str2 = bK[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = bK[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (aKp() == 1) {
                if (pbData != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10399").Z("fid", pbData.getForumId()).Z("tid", pbData.getThreadId()).Z(SapiAccountManager.SESSION_UID, currentAccount));
                }
            } else if (aKp() == 2 && pbData != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10406").Z("fid", pbData.getForumId()).Z("tid", pbData.getThreadId()).Z(SapiAccountManager.SESSION_UID, currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(w.l.share_content_tpl), title, name, str3);
            com.baidu.tbadk.coreExtra.share.g gVar = new com.baidu.tbadk.coreExtra.share.g();
            gVar.title = title;
            gVar.content = format;
            gVar.linkUrl = str;
            gVar.arO = true;
            gVar.extData = this.ejZ.getThreadID();
            if (parse != null) {
                gVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), gVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(w.l.forum_friend, w.g.icon_unite_share_baf, new bs(this));
            shareDialogConfig.setCopyLinkListener(new bt(this, gVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> Ix() {
        if (this.aNe == null) {
            this.aNe = new com.baidu.adp.lib.e.b<>(new bv(this), 15, 0);
        }
        return this.aNe;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.ekM.aMW() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10517").s("obj_locate", 2).Z("fid", this.ejZ.getPbData().getForumId()));
            } else {
                com.baidu.tbadk.core.data.bj aJq = this.ejZ.getPbData().aJq();
                if (view != null) {
                    boolean z = aJq.rG() == null || aJq.rG().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.eln > 1000) {
                            this.elo = true;
                            aZ(view);
                        } else {
                            this.elo = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            e(view, this.elo);
                        } else {
                            d(view, this.elo);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        d(view, this.elo);
                    } else if (motionEvent.getAction() == 3) {
                        d(view, this.elo);
                    }
                }
            }
        }
        return false;
    }

    private void d(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.praise_animation_scale2));
            new Handler().postDelayed(new bw(this), 200L);
        }
    }

    private void e(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.praise_animation_scale3));
            new Handler().postDelayed(new bx(this), 600L);
        }
    }

    private void aZ(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void YU() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(w.l.login_to_use), true, 11017)));
        } else if (aVar.tu() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.tu();
            int intValue = ((Integer) sparseArray.get(fa.esx)).intValue();
            if (intValue == fa.esy) {
                if (!this.ekL.bip()) {
                    this.ekM.aMZ();
                    int intValue2 = ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue();
                    this.ekL.a(this.ejZ.getPbData().aJp().getId(), this.ejZ.getPbData().aJp().getName(), this.ejZ.getPbData().aJq().getId(), (String) sparseArray.get(w.h.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == fa.esz || intValue == fa.esB) {
                if (this.ejZ.aLS() != null) {
                    this.ejZ.aLS().oi(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == fa.esz) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == fa.esA) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.elH).pg()));
            }
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (sparseArray.get(w.h.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(w.h.tag_user_mute_mute_username);
        }
        if (sparseArray.get(w.h.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(w.h.tag_user_mute_thread_id);
        }
        if (sparseArray.get(w.h.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(w.h.tag_user_mute_post_id);
        }
        if (sparseArray.get(w.h.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(w.h.tag_user_mute_msg);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.eld);
        userMuteAddAndDelCustomMessage.setTag(this.eld);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean nr(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bg.aI(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.uo().getString("bubble_link", ""))) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(w.l.editor_privilege), String.valueOf(string) + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void im(boolean z) {
        this.ekW = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aKB() {
        ArrayList<PostData> aJs;
        int p;
        if (this.ejZ == null || this.ejZ.getPbData() == null || this.ejZ.getPbData().aJs() == null || (p = com.baidu.tbadk.core.util.x.p((aJs = this.ejZ.getPbData().aJs()))) == 0) {
            return "";
        }
        int aNg = this.ekM.aNg();
        PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(aJs, aNg);
        if (postData == null || postData.getAuthor() == null) {
            return "";
        }
        if (this.ejZ.nv(postData.getAuthor().getUserId())) {
            return postData.getId();
        }
        for (int i = aNg - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.x.c(aJs, i);
            if (postData2 == null || postData2.getAuthor() == null || postData2.getAuthor().getUserId() == null) {
                break;
            } else if (this.ejZ.nv(postData2.getAuthor().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = aNg + 1; i2 < p; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.x.c(aJs, i2);
            if (postData3 == null || postData3.getAuthor() == null || postData3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.ejZ.nv(postData3.getAuthor().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.bb.vQ().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.b.a(nq(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.ejZ.getPbData().aJp().getId(), this.ejZ.getPbData().aJp().getName(), this.ejZ.getPbData().aJq().getTid());
            }
            this.ekD = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, String str2, String str3, String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cx(getResources().getString(w.l.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cx(getResources().getString(w.l.make_sure_hide));
        }
        aVar.a(getResources().getString(w.l.alert_yes_button), new by(this, j, str, str2, str3, str4));
        aVar.b(getResources().getString(w.l.alert_no_button), new bz(this, j, str, str2, str3, str4));
        aVar.au(false);
        aVar.b(getPageContext());
        aVar.ts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b ns(String str) {
        String str2;
        if (this.ejZ.getPbData() == null || this.ejZ.getPbData().aJs() == null || this.ejZ.getPbData().aJs().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i < this.ejZ.getPbData().aJs().size()) {
                if (str.equals(this.ejZ.getPbData().aJs().get(i).getId())) {
                    break;
                }
                i++;
            } else {
                i = 0;
                break;
            }
        }
        PostData postData = this.ejZ.getPbData().aJs().get(i);
        if (postData.aws() == null || postData.aws().HP() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.aws().HP().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.HV() != null) {
                    str2 = next.HV().Ij();
                }
            }
        }
        a(str2, 0, bVar);
        com.baidu.tieba.pb.data.g.a(postData, bVar);
        return bVar;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.ekt) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.ekt = false;
        } else if (aKC()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.ekt) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.ekt = false;
        } else if (aKC()) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a005";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.ejZ != null) {
            if (this.ejZ.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.ejZ.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.ejZ.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aKC() {
        return (!this.ekr && this.elJ == -1 && this.elK == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.elM = nVar;
            this.ekr = true;
            this.ekM.aMN();
            this.ekM.nB(this.elL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKD() {
        if (this.elM != null) {
            if (this.elJ == -1) {
                showToast(w.l.pb_manga_not_prev_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.elM.getCartoonId(), this.elJ, 0)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKE() {
        if (this.elM != null) {
            if (this.elK == -1) {
                showToast(w.l.pb_manga_not_next_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.elM.getCartoonId(), this.elK, 0)));
            finish();
        }
    }

    public int aKF() {
        return this.elJ;
    }

    public int aKG() {
        return this.elK;
    }

    private void alx() {
        if (this.ejZ != null && this.ejZ.getPbData() != null && this.ejZ.getPbData().aJq() != null && this.ejZ.getPbData().aJq().sD()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aKH() {
        if (this.ejZ != null && this.ejZ.getPbData() != null && this.ejZ.getPbData().aJq() != null && this.ejZ.getPbData().aJq().sD()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aKI() {
        if (this.eku) {
            this.ekJ = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.ejZ.getPbData() != null && this.ejZ.getPbData().aJq() != null && this.ejZ.getPbData().aJq().rz() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.ejZ.getPbData().aJq().rz().getThreadId(), this.ejZ.getPbData().aJq().rz().getTaskId(), this.ejZ.getPbData().aJq().rz().getForumId(), this.ejZ.getPbData().aJq().rz().getForumName(), this.ejZ.getPbData().aJq().rM(), this.ejZ.getPbData().aJq().rN())));
            this.ekt = true;
            finish();
        }
    }

    public boolean aKJ() {
        return this.eku;
    }

    public String aKK() {
        return this.ekH;
    }

    public PbInterviewStatusView.a aKL() {
        return this.ekK;
    }

    public void in(boolean z) {
        this.ekI = z;
    }

    public boolean aKM() {
        if (this.ejZ != null) {
            return this.ejZ.aLv();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKN() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cx(getResources().getString(w.l.mute_is_super_member_function));
        aVar.a(w.l.open_now, new ca(this));
        aVar.b(w.l.cancel, new cb(this));
        aVar.b(this.elb).ts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(String str) {
        if (str == null) {
            str = "";
        }
        if (this.elb != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.elb.getPageActivity());
            aVar.cx(str);
            aVar.b(w.l.know, new cc(this));
            aVar.b(this.elb).ts();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.ekM.auC();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.elb.getPageActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.cx(this.elb.getResources().getString(w.l.block_mute_message_alert, str2));
        } else {
            aVar.cx(str);
        }
        aVar.a(w.l.confirm, new cd(this, userMuteAddAndDelCustomMessage));
        aVar.b(w.l.cancel, new ce(this));
        aVar.b(this.elb).ts();
    }

    public void aKO() {
        if (this.ejZ != null && this.ejZ.getPbData() != null && this.ejZ.getPbData().aJq() != null && this.ejZ.getPbData().aJq().sU() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bW(w.l.channel_open_push_message);
            aVar.a(w.l.need_channel_push, new cg(this));
            aVar.b(w.l.not_need_channel_push, new ch(this));
            aVar.b(getPageContext());
            aVar.ts();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.b
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.b[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.b.class);
            for (int i = 0; i < objArr.length; i++) {
                if (gt.nD(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_pb_wenxue)) != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                    spannableStringBuilder2.setSpan(new com.baidu.tbadk.widget.g(drawable), 0, "#4%2&@#907$12#@96476)w7we9e~@$%&&".length(), 33);
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

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            this.ekG = true;
        } else {
            this.ekG = false;
        }
        if (this.ekM != null) {
            this.ekM.onConfigurationChanged(configuration);
        }
        if (this.ekR != null) {
            this.ekR.dismiss();
        }
    }
}
