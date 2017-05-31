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
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.f;
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
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tbadk.data.IconData;
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
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.Cdo;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.a.f;
import com.baidu.tieba.pb.pb.main.df;
import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.en;
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
import java.io.Serializable;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.b, com.baidu.tbadk.widget.richText.d {
    private com.baidu.adp.lib.e.b<ImageView> aNH;
    private com.baidu.adp.lib.e.b<TextView> aNI;
    private com.baidu.adp.lib.e.b<View> aNJ;
    private com.baidu.adp.lib.e.b<View> aNK;
    private com.baidu.adp.lib.e.b<LinearLayout> aNL;
    private com.baidu.adp.lib.e.b<GifView> aNM;
    private com.baidu.adp.lib.e.b<TbImageView> ams;
    private VoiceManager bTZ;
    private com.baidu.tbadk.h.a bUu;
    private com.baidu.tieba.e.c bwH;
    private com.baidu.tbadk.core.dialog.a elC;
    private boolean elJ;
    private com.baidu.tieba.pb.pb.main.b elL;
    private com.baidu.tieba.pb.pb.main.emotion.model.b elR;
    private el elZ;
    private String elc;
    private com.baidu.tieba.pb.pb.main.a.f elw;
    private boolean emO;
    private String emZ;
    private boolean eme;
    private com.baidu.tieba.tbadkCore.data.e emg;
    private com.baidu.tbadk.editortools.pb.c emh;
    private com.baidu.adp.base.g emk;
    private com.baidu.tbadk.core.view.h eml;
    private BdUniqueId emm;
    private Runnable emn;
    private com.baidu.tbadk.core.data.n ena;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean elv = false;
    private boolean elx = false;
    private boolean ely = false;
    private boolean dLm = false;
    private boolean elz = true;
    private int elA = 0;
    private com.baidu.tbadk.core.dialog.c elB = null;
    private long bMF = -1;
    private long aGx = 0;
    private long elD = 0;
    private long createTime = 0;
    private long aGp = 0;
    private boolean elE = false;
    private com.baidu.tbadk.j.e elF = null;
    private long elG = 0;
    private boolean elH = false;
    private boolean elI = false;
    private long elK = 0;
    private String aAG = null;
    private boolean elM = false;
    private boolean elN = false;
    private String elO = "";
    private boolean elP = true;
    private boolean elQ = false;
    private String source = "";
    private PbInterviewStatusView.a elS = new i(this);
    private final Handler mHandler = new Handler(new t(this));
    private PbModel ele = null;
    private com.baidu.tbadk.baseEditMark.a dHz = null;
    private ForumManageModel elT = null;
    private fx elU = null;
    public final com.baidu.tieba.pb.pb.main.a.a elV = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean elW = false;
    private boolean elX = false;
    private boolean elY = false;
    private boolean ema = false;
    private boolean emb = false;
    private boolean emc = false;
    private boolean emd = false;
    private boolean emf = false;
    private boolean emi = false;
    private com.baidu.tbadk.editortools.pb.b aAK = new ae(this);
    private boolean emj = false;
    private int mLastScrollState = -1;
    private int emo = 4;
    private int emp = -1;
    private final en.a emq = new ap(this);
    private final CustomMessageListener emr = new ba(this, CmdConfigCustom.PB_RESET_EDITOR_TOOL);
    CustomMessageListener bUQ = new bl(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private CustomMessageListener ems = new bw(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener dqs = new cf(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener dqP = new cn(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener emt = new j(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener cQv = new k(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private df.a emu = new l(this);
    private View.OnClickListener dqr = new m(this);
    private CustomMessageListener emv = new n(this, CmdConfigCustom.CMD_SEND_GIFT_SUCCESS);
    private SuggestEmotionModel.a emw = new o(this);
    private com.baidu.tieba.pb.pb.main.emotion.a emx = new p(this);
    private boolean emy = false;
    private PraiseModel emz = new PraiseModel(getPageContext(), new q(this));
    private long emA = 0;
    private boolean emB = true;
    private f.a emC = new r(this);
    private CustomMessageListener bbM = new s(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CheckRealNameModel.a bhd = new u(this);
    private CustomMessageListener emD = new v(this, CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED);
    private com.baidu.tieba.pb.a.d aOc = new com.baidu.tieba.pb.a.d(new w(this));
    private CustomMessageListener emE = new x(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener emF = new y(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener emG = new z(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    public CustomMessageListener emH = new aa(this, CmdConfigCustom.PB_FIRST_FLOOR_PRAISE);
    public a.b dVv = new ab(this);
    public final View.OnClickListener bVy = new ac(this);
    private final NewWriteModel.d aAR = new ad(this);
    private final PbModel.a emI = new af(this);
    private CustomMessageListener emJ = new ag(this, CmdConfigCustom.CMD_WX_SHARE_SUCCESS);
    private CustomMessageListener emK = new ah(this, CmdConfigCustom.CMD_TTS_OPTION_PB);
    private final a.InterfaceC0033a emL = new ai(this);
    private final AbsListView.OnScrollListener mOnScrollListener = new aj(this);
    private final com.baidu.adp.base.f emM = new ak(this);
    private final c emN = new al(this);
    private final ae.b aWB = new am(this);
    private final BdListView.e emP = new an(this);
    private int emQ = 0;
    private final TbRichTextView.e aOb = new ao(this);
    boolean emR = false;
    PostData emS = null;
    private final c.b emT = new aq(this);
    private final View.OnLongClickListener atb = new ar(this);
    private final NoNetworkView.a byu = new as(this);
    public View.OnTouchListener aJg = new at(this);
    private a.InterfaceC0059a bwT = new au(this);
    private final c.a emU = new av(this);
    private String emV = null;
    private final Cdo.a emW = new aw(this);
    private int emX = -1;
    private int emY = -1;
    private CustomMessageListener enb = new ax(this, CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST);
    private final CustomMessageListener bUU = new ay(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);
    private f.b IH = new az(this);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> ent;
        public ConcurrentHashMap<String, ImageUrlData> enu;
        public boolean enw;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean env = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes.dex */
    public interface c {
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.pb.c aJA() {
        return this.emh;
    }

    public void b(com.baidu.tieba.pb.data.n nVar) {
        if (nVar.aJj() != null) {
            String id = nVar.aJj().getId();
            ArrayList<PostData> aID = this.ele.getPbData().aID();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aID.size()) {
                    break;
                }
                PostData postData = aID.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aJn = nVar.aJn();
                    postData.sl(nVar.getTotalCount());
                    if (postData.bid() != null) {
                        postData.bid().clear();
                        postData.bid().addAll(aJn);
                    }
                }
            }
            this.elU.l(this.ele.getPbData());
            c(nVar);
        }
    }

    public void aJB() {
        com.baidu.tieba.pb.data.f pbData;
        com.baidu.tbadk.core.data.bl aIB;
        if (!this.emy) {
            if (!com.baidu.adp.lib.util.k.hB()) {
                showToast(w.l.no_network_guide);
            } else if (this.emB) {
                this.emy = true;
                if (this.ele != null && (pbData = this.ele.getPbData()) != null && (aIB = pbData.aIB()) != null) {
                    int isLike = aIB.rk() == null ? 0 : aIB.rk().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10796").Z("tid", aIB.getId()));
                    }
                    if (this.emz != null) {
                        this.emz.a(aIB.rK(), aIB.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        if ((sparseArray.get(w.h.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(w.h.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(w.h.tag_check_mute_from) instanceof Integer)) {
            String str = (String) sparseArray.get(w.h.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(w.h.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(w.h.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
                cVar.cb(w.l.operation);
                int i = -1;
                if (sparseArray.get(w.h.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(w.h.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(w.l.delete);
                    strArr[1] = z ? getResources().getString(w.l.un_mute) : getResources().getString(w.l.mute);
                    cVar.a(strArr, new bb(this, sparseArray, z, str2, str));
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(w.l.un_mute) : getResources().getString(w.l.mute);
                    cVar.a(strArr2, new bc(this, sparseArray, z, str2, str));
                }
                cVar.d(getPageContext()).tf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iC(int i) {
        com.baidu.tbadk.core.data.bl aIB;
        String sb;
        String x;
        if (this.ele != null && this.ele.getPbData() != null && (aIB = this.ele.getPbData().aIB()) != null) {
            if (i == 1) {
                PraiseData rk = aIB.rk();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rk == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aIB.a(praiseData);
                    } else {
                        aIB.rk().getUser().add(0, metaData);
                        aIB.rk().setNum(aIB.rk().getNum() + 1);
                        aIB.rk().setIsLike(i);
                    }
                }
                if (aIB.rk() != null) {
                    if (aIB.rk().getNum() < 1) {
                        x = getResources().getString(w.l.frs_item_praise_text);
                    } else {
                        x = com.baidu.tbadk.core.util.au.x(aIB.rk().getNum());
                    }
                    this.elU.M(x, true);
                }
            } else if (aIB.rk() != null) {
                aIB.rk().setIsLike(i);
                aIB.rk().setNum(aIB.rk().getNum() - 1);
                ArrayList<MetaData> user = aIB.rk().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aIB.rk().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aIB.rk().getNum() < 1) {
                    sb = getResources().getString(w.l.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(aIB.rk().getNum())).toString();
                }
                this.elU.M(sb, false);
            }
            if (this.ele.aKN()) {
                this.elU.aMu().notifyDataSetChanged();
            } else {
                this.elU.m(this.ele.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apG && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        if (this.ele != null && this.ele.getPbData() != null && this.elU != null) {
            this.elU.d(this.ele.getPbData(), this.ele.aKN(), this.ele.aLd());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bUu == null) {
                this.bUu = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.bUu.an(updateAttentionMessage.getData().toUid, this.ele.getPbData().getForumId());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.ele.p(bundle);
        if (this.bTZ != null) {
            this.bTZ.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.emh.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.emk = getPageContext();
        Intent intent = getIntent();
        if (intent != null) {
            this.bMF = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.elO = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.elO)) {
                this.elx = true;
            }
            this.emX = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.emY = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.emZ = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            this.emb = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
            this.emf = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_GOD_REPLY, false);
            if (aJX()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.au.isEmpty(this.source) ? "" : this.source;
            this.emp = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            this.elJ = intent.getBooleanExtra("is_from_push", false);
        } else {
            this.bMF = System.currentTimeMillis();
        }
        this.elD = System.currentTimeMillis();
        this.aGp = this.elD - this.bMF;
        super.onCreate(bundle);
        this.mSwipeBackLayout.setOnSlidingStateChangeListener(this.IH);
        this.elA = 0;
        r(bundle);
        if (this.ele != null && this.ele.getPbData() != null) {
            this.ele.getPbData().nL(this.source);
        }
        initUI();
        if (intent != null && this.elU != null) {
            this.elU.esw = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
            if (!StringUtils.isNull(intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME))) {
                if (this.emn == null) {
                    this.emn = new bd(this, intent);
                }
                getSafeHandler().postDelayed(this.emn, 1500L);
            }
        }
        this.bTZ = new VoiceManager();
        this.bTZ.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.pb.l lVar = new com.baidu.tbadk.editortools.pb.l();
        lVar.setForumName(this.ele.aKM());
        if (this.ele.getPbData() != null && this.ele.getPbData().aIz() != null) {
            lVar.setForumId(this.ele.getPbData().aIz().getId());
        }
        lVar.setFrom("pb");
        lVar.a(this.ele);
        this.emh = (com.baidu.tbadk.editortools.pb.c) lVar.aQ(getActivity());
        this.emh.d(this);
        this.emh.a(this.aAR);
        this.emh.a(this.aAK);
        this.emh.a(this, bundle);
        this.emh.Cm().c(new com.baidu.tbadk.editortools.w(getActivity()));
        this.emh.Cm().bA(true);
        m18if(true);
        this.elU.setEditorTools(this.emh.Cm());
        this.emh.a(this.ele.aKU(), this.ele.getThreadID(), this.ele.aLp());
        registerListener(this.dqs);
        if (!this.ele.aKR()) {
            this.emh.fs(this.ele.getThreadID());
        }
        if (this.ele.aLq()) {
            this.emh.fq(getPageContext().getString(w.l.pb_reply_hint_from_smart_frs));
        } else {
            this.emh.fq(getPageContext().getString(w.l.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.elD;
        registerListener(this.ems);
        registerListener(this.dqP);
        registerListener(this.emt);
        registerListener(this.bUQ);
        registerListener(this.emH);
        registerListener(this.emr);
        this.emg = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.fBB);
        this.emg.bhH();
        registerListener(this.emv);
        registerListener(this.bbM);
        if (this.ele != null) {
            this.ele.aLf();
        }
        if (TbadkCoreApplication.m9getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.emD);
        registerListener(this.emK);
        registerListener(this.emJ);
        registerListener(this.enb);
        this.elL = new com.baidu.tieba.pb.pb.main.b(this.ele, this);
        if (this.elU != null && this.elU.aMT() != null && this.elU.aMU() != null) {
            this.elw = new com.baidu.tieba.pb.pb.main.a.f(getActivity(), this.elU.aMT(), this.elU.aMU());
            this.elw.a(this.emC);
        }
        if (this.elv && this.elU != null && this.elU.aMU() != null) {
            this.elU.aMU().setVisibility(8);
        }
        this.eml = new com.baidu.tbadk.core.view.h();
        this.eml.aiM = 1000L;
        registerListener(this.emG);
        registerListener(this.emE);
        registerListener(this.emF);
        this.emm = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.emm;
        userMuteAddAndDelCustomMessage.setTag(this.emm);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.emm;
        userMuteCheckCustomMessage.setTag(this.emm);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.ele.aLo().a(this.bhd);
    }

    public String aJC() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.f aJD() {
        return this.elw;
    }

    /* renamed from: if  reason: not valid java name */
    private void m18if(boolean z) {
        this.emh.bD(z);
        this.emh.bE(z);
        this.emh.bF(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bTZ != null) {
            this.bTZ.onStart(getPageContext());
        }
    }

    public fx aJE() {
        return this.elU;
    }

    public PbModel aJF() {
        return this.ele;
    }

    public void nN(String str) {
        if (this.ele != null && !StringUtils.isNull(str) && this.elU != null) {
            this.elU.aMv();
            this.elU.iW(true);
            this.ele.nN(str);
            this.elM = true;
            this.elU.avy();
            this.elU.aMP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.m9getInst().isReadMenuDialogOnTop()) {
            this.ely = false;
        } else {
            this.ely = true;
        }
        super.onPause();
        if (this.elU.aMc() != null && this.elU.aMc().aJx() != null) {
            this.elU.aMc().aJx().onPause();
        }
        BdListView listView = getListView();
        this.elA = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.elA == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.bTZ != null) {
            this.bTZ.onPause(getPageContext());
        }
        if (this.elU != null) {
            this.elU.onPause();
        }
        if (!this.ele.aKR()) {
            this.emh.fr(this.ele.getThreadID());
        }
        if (this.ele != null) {
            this.ele.aLg();
        }
        MessageManager.getInstance().unRegisterListener(this.cQv);
        akg();
        MessageManager.getInstance().unRegisterListener(this.emE);
        MessageManager.getInstance().unRegisterListener(this.emF);
        MessageManager.getInstance().unRegisterListener(this.emG);
        MessageManager.getInstance().unRegisterListener(this.bUU);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aJG() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.ele.getPbData(), this.ele.aKN(), this.ele.aLd());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.ely = false;
        super.onResume();
        if (this.elQ) {
            this.elQ = false;
            aKd();
        }
        if (this.elU.aMc() != null && this.elU.aMc().aJx() != null) {
            this.elU.aMc().aJx().onResume();
        }
        if (aJG()) {
            this.elG = System.currentTimeMillis();
        } else {
            this.elG = -1L;
        }
        if (this.elU != null && this.elU.getView() != null) {
            if (!this.dLm) {
                aJV();
            } else {
                hideLoadingView(this.elU.getView());
            }
            this.elU.onResume();
        }
        if (this.elA == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.elU != null) {
            noNetworkView = this.elU.aMd();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.hk()) {
            noNetworkView.aJ(false);
        }
        if (this.bTZ != null) {
            this.bTZ.onResume(getPageContext());
        }
        registerListener(this.cQv);
        this.eme = false;
        aKc();
        registerListener(this.emE);
        registerListener(this.emF);
        registerListener(this.emG);
        registerListener(this.bUU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.elU.iN(z);
        if (this.elZ != null) {
            this.elZ.iw(z);
        }
        if (z && this.eme) {
            this.elU.aMA();
            this.ele.ir(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.elG > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10804").Z("obj_duration", new StringBuilder(String.valueOf(System.currentTimeMillis() - this.elG)).toString()));
            this.elG = 0L;
        }
        if (this.emh != null && this.emh.Cm() != null && this.emh.Cm().getVisibility() != 0) {
            this.emh.CV();
        }
        if (aJE().aMg() != null) {
            aJE().aMg().onStop();
        }
        if (this.elU.esG != null && !this.elU.esG.Vf()) {
            this.elU.esG.avP();
        }
        if (this.ele != null && this.ele.getPbData() != null && this.ele.getPbData().aIz() != null && this.ele.getPbData().aIB() != null) {
            com.baidu.tbadk.distribute.a.BW().a(getPageContext().getPageActivity(), "pb", this.ele.getPbData().aIz().getId(), com.baidu.adp.lib.g.b.c(this.ele.getPbData().aIB().getId(), 0L));
        }
        if (this.bTZ != null) {
            this.bTZ.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.elL != null) {
            this.elL.destroy();
        }
        if (this.ema && this.ele != null) {
            a(this.ele.getPbData(), -2, 0, false, false);
        }
        if (!this.elE && this.elU != null) {
            this.elE = true;
            this.elU.aMO();
            a(false, (PostData) null);
        }
        if (this.ele != null) {
            this.ele.cancelLoadData();
            this.ele.destory();
            if (this.ele.aLn() != null) {
                this.ele.aLn().onDestroy();
            }
        }
        if (this.emh != null) {
            this.emh.onDestroy();
        }
        if (this.elT != null) {
            this.elT.cancelLoadData();
        }
        if (this.elU != null) {
            this.elU.onDestroy();
            if (this.elU.esG != null) {
                this.elU.esG.avP();
            }
        }
        if (this.elF != null) {
            this.elF.onDestroy();
        }
        if (this.elw != null) {
            this.elw.Gu();
        }
        super.onDestroy();
        if (this.bTZ != null) {
            this.bTZ.onDestory(getPageContext());
        }
        if (this.bUu != null) {
            this.bUu.destory();
        }
        this.elU.avy();
        MessageManager.getInstance().unRegisterListener(this.emE);
        MessageManager.getInstance().unRegisterListener(this.emF);
        MessageManager.getInstance().unRegisterListener(this.emG);
        MessageManager.getInstance().unRegisterListener(this.emm);
        MessageManager.getInstance().unRegisterListener(this.emH);
        this.emk = null;
        this.eml = null;
        com.baidu.tieba.recapp.d.a.ban().bap();
        if (this.emn != null) {
            getSafeHandler().removeCallbacks(this.emn);
        }
        if (this.elR != null) {
            this.elR.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        cv aMu;
        ArrayList<PostData> aKy;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xl() && this.elU != null && (aMu = this.elU.aMu()) != null && (aKy = aMu.aKy()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aKy.iterator();
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
                        bVar.mPid = id;
                        bVar.bCY = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.Ye == 1 && !TextUtils.isEmpty(id)) {
                    next.Ye = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.bCY = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.ele == null || this.ele.getPbData() == null || this.ele.getPbData().aIz() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.ele.getPbData().aIz().getFirst_class();
                    str2 = this.ele.getPbData().aIz().getSecond_class();
                    str = this.ele.getPbData().aIz().getId();
                    str4 = this.ele.getThreadID();
                }
                com.baidu.tieba.recapp.ac.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.xp());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.elU.onChangeSkinType(i);
        if (this.emh != null && this.emh.Cm() != null) {
            this.emh.Cm().onChangeSkinType(i);
        }
        if (this.elU.aMd() != null) {
            this.elU.aMd().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.elU = new fx(this, this.bVy, this.aOc);
        this.bwH = new com.baidu.tieba.e.c(getActivity());
        this.bwH.a(this.emU);
        this.bwH.a(this.bwT);
        this.elU.setOnScrollListener(this.mOnScrollListener);
        this.elU.d(this.emP);
        this.elU.a(this.aWB);
        this.elU.hZ(com.baidu.tbadk.core.r.oN().oT());
        this.elU.setOnImageClickListener(this.aOb);
        this.elU.a(this.atb);
        this.elU.c(this.byu);
        this.elU.a(this.emN);
        this.elU.iN(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aS(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(w.h.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.fCe == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.r.oN().oT()) {
                    return false;
                }
                return nR(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.elU != null) {
            if (z && (!this.dLm || this.emj)) {
                aJV();
            } else {
                hideLoadingView(this.elU.getView());
            }
            this.emj = false;
        }
    }

    private void aJH() {
        if (this.elB == null) {
            this.elB = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.elB.a(new String[]{getPageContext().getString(w.l.call_phone), getPageContext().getString(w.l.sms_phone), getPageContext().getString(w.l.search_in_baidu)}, new be(this)).cc(c.a.aal).cd(17).d(getPageContext());
        }
    }

    private void r(Bundle bundle) {
        this.ele = new PbModel(this);
        this.ele.a(this.emI);
        if (this.ele.aLl() != null) {
            this.ele.aLl().a(this.emW);
        }
        if (this.ele.aLk() != null) {
            this.ele.aLk().a(this.emu);
        }
        if (this.ele.aLn() != null) {
            this.ele.aLn().a(this.emq);
        }
        if (bundle != null) {
            this.ele.initWithBundle(bundle);
        } else {
            this.ele.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.ele.iv(true);
        }
        fg.aLX().L(this.ele.aKL(), this.ele.getIsFromMark());
        if (StringUtils.isNull(this.ele.getThreadID())) {
            finish();
        } else {
            this.ele.EA();
        }
    }

    private void initData(Bundle bundle) {
        this.dHz = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dHz != null) {
            this.dHz.a(this.emL);
        }
        this.elT = new ForumManageModel(this);
        this.elT.setLoadDataCallBack(this.emM);
        this.elU.a(new bf(this));
        this.emz.setUniqueId(getUniqueId());
        this.emz.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.elU.Pd();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(w.h.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.emm;
        userMuteCheckCustomMessage.setTag(this.emm);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oj() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.bX(w.l.go_setting_float_window_permission);
        aVar.bY(w.l.step_to_setting_float_permission);
        aVar.a(w.l.go_and_setting, new bg(this));
        aVar.b(w.l.cancel, new bh(this));
        aVar.b(getPageContext()).tc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aJI() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.ele != null && this.ele.getPbData() != null) {
            com.baidu.tieba.pb.data.f pbData = this.ele.getPbData();
            if (pbData.aIz() != null) {
                sb.append("forum_name=").append(nO(pbData.aIz().getName()));
                sb.append("&");
            }
            if (pbData.aIB() != null) {
                com.baidu.tbadk.core.data.bl aIB = pbData.aIB();
                sb.append("thread_id=").append(aIB.getId());
                sb.append("&");
                sb.append("thread_title=").append(nO(aIB.getTitle()));
                if (aIB.getAuthor() != null && aIB.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aIB.getAuthor().getPortrait());
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
            getSafeHandler().postDelayed(new bi(this, iArr, measuredHeight, str, str2), 500L);
        }
    }

    private String nO(String str) {
        return URLEncoder.encode(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        PostData postData;
        ArrayList<IconData> arrayList;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(w.h.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(w.h.tag_clip_board)) != null && this.ele != null && this.ele.getPbData() != null && postData.big() > 1) {
            String threadID = this.ele.getThreadID();
            String id = postData.getId();
            int i = 0;
            if (this.ele.getPbData() != null) {
                i = this.ele.getPbData().aIM();
            }
            b nS = nS(id);
            if (nS != null) {
                SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
                SmallTailInfo aOB = postData.aOB();
                AntiData qh = this.ele.getPbData().qh();
                if (postData.getAuthor() != null) {
                    arrayList = postData.getAuthor().getIconInfo();
                } else {
                    arrayList = null;
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i, aOB, qh, false, arrayList).addBigImageData(nS.ent, nS.enu, nS.env, nS.index)));
            }
        }
    }

    public void f(View view, int i, boolean z) {
        ft ftVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.k.hB()) {
                showToast(w.l.no_network_guide);
            } else if (aJF() != null && aJF().getPbData() != null && aJF().getPbData().aIY() != null && !com.baidu.tieba.pb.e.M(aJF().getPbData().aIB())) {
                com.baidu.tieba.pb.data.m aIY = aJF().getPbData().aIY();
                if (view == null || !(view.getTag(w.h.pb_main_thread_praise_view) instanceof ft)) {
                    ftVar = null;
                } else {
                    ftVar = (ft) view.getTag(w.h.pb_main_thread_praise_view);
                }
                if (aIY != null) {
                    int i2 = -1;
                    if (z) {
                        aIY.om(i);
                    } else if (aIY.aJe()) {
                        aIY.aJg();
                        i2 = 1;
                    } else {
                        aIY.on(i);
                        i2 = 0;
                    }
                    if (this.ele != null && this.ele.aLm() != null) {
                        String str = "";
                        if (this.ele.getPbData() != null && this.ele.getPbData().aIB() != null) {
                            str = this.ele.getPbData().aIB().rK();
                        }
                        if (this.ele.getPbData() != null) {
                            this.ele.getPbData().a(aIY);
                        }
                        if (z) {
                            this.ele.aLm().d(str, 3, i, this.ele.getForumId());
                        } else {
                            this.ele.aLm().a(str, i2, 3, i, this.ele.getForumId());
                            com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                            lVar.ejg = i2;
                            lVar.ejh = aIY;
                            lVar.apb = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_AGREE_CHANGED, lVar));
                        }
                    }
                    if (ftVar != null) {
                        ftVar.b(aIY);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aJJ() {
        if (this.ele.getPbData() == null || this.ele.getPbData().aIB() == null) {
            return -1;
        }
        return this.ele.getPbData().aIB().rY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ig(boolean z) {
        if (this.ele == null || this.ele.getPbData() == null) {
            return false;
        }
        return ((this.ele.getPbData().aIM() != 0) || this.ele.getPbData().aIB() == null || this.ele.getPbData().aIB().getAuthor() == null || TextUtils.equals(this.ele.getPbData().aIB().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean ih(boolean z) {
        if (z) {
            return true;
        }
        if (this.ele == null || this.ele.getPbData() == null) {
            return false;
        }
        return this.ele.getPbData().aIM() != 0;
    }

    private boolean ii(boolean z) {
        return (z || this.ele == null || this.ele.getPbData() == null || this.ele.getPbData().aIM() == 0) ? false : true;
    }

    public void aJK() {
        if (this.ele != null && this.ele.getPbData() != null && this.ele.getPbData().aIB() != null && this.ele.getPbData().aIB().getAuthor() != null) {
            if (this.elU != null) {
                this.elU.aMe();
            }
            com.baidu.tbadk.core.data.bl aIB = this.ele.getPbData().aIB();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aIB.getAuthor().getUserId());
            GodUserData godUserData = aIB.getAuthor().getGodUserData();
            boolean z = equals && godUserData != null && godUserData.isCanSendCall();
            er erVar = new er();
            if (this.ele.getPbData().aIM() == 1) {
                erVar.eqU = true;
                erVar.eqT = true;
                erVar.eqZ = aIB.rq() == 1;
                erVar.eqY = aIB.rr() == 1;
            } else {
                erVar.eqU = false;
                erVar.eqT = false;
            }
            erVar.eqS = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteShareActivityConfig.class);
            erVar.eqQ = TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            erVar.eqV = ih(equals);
            erVar.eqW = aJL();
            erVar.eqX = ii(equals);
            erVar.eqR = this.ele.aKN();
            erVar.ejs = this.dHz != null ? this.dHz.nD() : false;
            erVar.eqP = ig(equals);
            erVar.eqN = equals && this.elU.aMG();
            erVar.eqO = z;
            erVar.isHostOnly = this.ele.getHostMode();
            if (aIB.rL() == null) {
                erVar.era = false;
            } else {
                erVar.era = true;
            }
            this.elU.esG.a(erVar);
        }
    }

    private boolean aJL() {
        if (this.ele != null && this.ele.aKN()) {
            return this.ele.akK() == null || this.ele.akK().qu() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(w.h.tag_clip_board)) != null) {
            g(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, boolean z2) {
        if (fVar != null && this.ele != null) {
            ex exVar = new ex(getUniqueId());
            exVar.pbData = fVar;
            exVar.threadId = this.ele.getThreadID();
            exVar.postId = this.ele.getPostId();
            exVar.erA = i;
            exVar.erB = i2;
            exVar.erz = this.ele.getHostMode();
            exVar.ejs = this.ele.nD();
            exVar.isSquence = this.ele.aKN();
            exVar.loadType = this.ele.aLi();
            exVar.erC = z;
            exVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, exVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aJM() {
        if (aJE() == null || aJE().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aJE().getListView();
        List<com.baidu.adp.widget.ListView.v> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.v vVar = data.get(i);
            if ((vVar instanceof com.baidu.tieba.pb.data.k) && ((com.baidu.tieba.pb.data.k) vVar).mType == 0) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, boolean z2) {
        if (fVar != null && this.ele != null) {
            ex exVar = new ex(getUniqueId());
            exVar.pbData = fVar;
            exVar.threadId = this.ele.getThreadID();
            exVar.postId = this.ele.getPostId();
            exVar.erA = i;
            exVar.erz = this.ele.getHostMode();
            exVar.ejs = this.ele.nD();
            exVar.isSquence = this.ele.aKN();
            exVar.loadType = this.ele.aLi();
            exVar.erC = z;
            exVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, exVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        Tq();
    }

    public void a(boolean z, MarkData markData) {
        this.elU.aMB();
        this.ele.iu(z);
        if (this.dHz != null) {
            this.dHz.ac(z);
            if (markData != null) {
                this.dHz.a(markData);
            }
        }
        if (this.ele.nD()) {
            aJS();
        } else {
            this.elU.l(this.ele.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oq(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nP(String str) {
        if (!StringUtils.isNull(str) && this.ele != null) {
            String threadID = this.ele.getThreadID();
            String id = this.ele.getPbData().aIz().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(w.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.ele.aKR()) {
                    antiData.setBlock_forum_name(this.ele.getPbData().aIz().getName());
                    antiData.setBlock_forum_id(this.ele.getPbData().aIz().getId());
                    antiData.setUser_name(this.ele.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.ele.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.sr(i)) {
            AntiHelper.ap(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            fy(str);
        } else {
            this.elU.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.elU.a(0, bVar.AM, bVar.fEr, z);
            if (bVar.AM) {
                if (bVar.fEp == 1) {
                    ArrayList<PostData> aID = this.ele.getPbData().aID();
                    int size = aID.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aID.get(i).getId())) {
                            i++;
                        } else {
                            aID.remove(i);
                            break;
                        }
                    }
                    this.elU.l(this.ele.getPbData());
                } else if (bVar.fEp == 0) {
                    aJN();
                } else if (bVar.fEp == 2) {
                    ArrayList<PostData> aID2 = this.ele.getPbData().aID();
                    int size2 = aID2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aID2.get(i2).bid().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aID2.get(i2).bid().get(i3).getId())) {
                                i3++;
                            } else {
                                aID2.get(i2).bid().remove(i3);
                                aID2.get(i2).bif();
                                z2 = true;
                                break;
                            }
                        }
                        aID2.get(i2).qm(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.elU.l(this.ele.getPbData());
                    }
                    a(bVar, this.elU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.f fVar) {
        if (fVar != null) {
            this.elU.a(this.elT.getLoadDataMode(), fVar.AM, fVar.fEr, false);
            if (fVar.AM) {
                this.elW = true;
                if (i == 2 || i == 3) {
                    this.elX = true;
                    this.elY = false;
                } else if (i == 4 || i == 5) {
                    this.elX = false;
                    this.elY = true;
                }
                if (i == 2) {
                    this.ele.getPbData().aIB().bT(1);
                    this.ele.setIsGood(1);
                } else if (i == 3) {
                    this.ele.getPbData().aIB().bT(0);
                    this.ele.setIsGood(0);
                } else if (i == 4) {
                    this.ele.getPbData().aIB().bS(1);
                    this.ele.hv(1);
                } else if (i == 5) {
                    this.ele.getPbData().aIB().bS(0);
                    this.ele.hv(0);
                }
                this.elU.d(this.ele.getPbData(), this.ele.aKN());
                com.baidu.tieba.c.a.a(getPageContext(), 2, i);
            }
        }
    }

    private void aJN() {
        if (this.ele.aKO() || this.ele.aKP()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.ele.getThreadID());
            setResult(-1, intent);
        }
        if (aJT()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJO() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aIJ;
        if (this.elU != null) {
            this.elU.avy();
        }
        if (this.ele != null && this.ele.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.ele.getPbData().aIB().getId();
            historyMessage.forumName = this.ele.getPbData().aIz().getName();
            historyMessage.threadName = this.ele.getPbData().aIB().getTitle();
            ArrayList<PostData> aID = this.ele.getPbData().aID();
            int aMD = this.elU != null ? this.elU.aMD() : 0;
            if (aID != null && aMD >= 0 && aMD < aID.size()) {
                historyMessage.postID = aID.get(aMD).getId();
            }
            historyMessage.isHostOnly = this.ele.getHostMode();
            historyMessage.isSquence = this.ele.aKN();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.emh != null) {
            this.emh.onDestroy();
        }
        if (this.elz && aJE() != null) {
            aJE().aNc();
        }
        if (this.ele != null && (this.ele.aKO() || this.ele.aKP())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.ele.getThreadID());
            if (this.elW) {
                if (this.elY) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.ele.avp());
                }
                if (this.elX) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.ele.getIsGood());
                }
            }
            if (this.ele.getPbData() != null && System.currentTimeMillis() - this.elD >= 40000 && (aIJ = this.ele.getPbData().aIJ()) != null && !com.baidu.tbadk.core.util.x.r(aIJ.getDataList())) {
                intent.putExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA, aIJ);
                intent.putExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, this.emp);
            }
            setResult(-1, intent);
        }
        if (aJT()) {
            if (this.ele != null && this.elU != null && this.elU.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.ele.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.m9getInst().getDefaultBubble());
                    }
                    if (!pbData.aIH() && !this.elM) {
                        fg.aLX().a(this.ele.getPbData(), this.elU.getListView().onSaveInstanceState(), this.ele.aKN(), this.ele.getHostMode());
                    }
                }
            } else {
                fg.aLX().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.elU == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.elU.oK(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean or(int i) {
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
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.emh.onActivityResult(i, i2, intent);
        if (this.elR != null) {
            this.elR.onActivityResult(i, i2, intent);
        }
        if (aJE().aMg() != null) {
            aJE().aMg().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aJR();
                    return;
                case 13008:
                    fg.aLX().reset();
                    this.mHandler.postDelayed(new bj(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.ele != null) {
                        a(aJQ(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    T(intent);
                    return;
                case 24006:
                    S(intent);
                    return;
                case 24007:
                    if (aJJ() == 1) {
                        aJP();
                        return;
                    }
                    return;
                case 24008:
                    this.elU.ie(false);
                    if (this.ele.getPbData() != null && this.ele.getPbData().aIB() != null && this.ele.getPbData().aIB().rO() != null) {
                        this.ele.getPbData().aIB().rO().setStatus(2);
                        break;
                    }
                    break;
                case 25001:
                    break;
                case 25012:
                    intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
                    intent.getStringExtra("KEY_FORUM_NAME");
                    return;
                case 25016:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        a(emotionImageData);
                        return;
                    }
                    return;
                default:
                    return;
            }
            if (this.elL != null) {
                this.elL.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aJE() != null && aJA() != null && aJE().aMh() && com.baidu.tbadk.editortools.pb.a.CI().getStatus() == 1) {
                    com.baidu.tbadk.editortools.pb.a.CI().setStatus(0);
                    if (this.elU != null) {
                        this.elU.aKn();
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
    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null) {
            if (this.elR == null) {
                this.elR = new com.baidu.tieba.pb.pb.main.emotion.model.b(this);
                this.elR.b(this.aAK);
                this.elR.c(this.aAR);
            }
            this.elR.a(emotionImageData, aJF(), aJF().getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJP() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.ele.getPbData() != null && this.ele.getPbData().aIB() != null && this.ele.getPbData().aIB().rF() != null && this.ele.getPbData().aIB().rF().size() > 0 && this.ele.getPbData().aIB().rF().get(0) != null) {
            this.mAwardActId = this.ele.getPbData().aIB().rF().get(0).pi();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.ele.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void S(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra(GetLotteryChanceActivityConfig.KEY_ACTION, 0)) {
                case 1:
                    ot(2);
                    return;
                case 2:
                    this.elU.aMs();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aJQ() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bJ = this.ele.getPbData().bJ(getPageContext().getPageActivity());
        PostData aMi = this.elU.aMi();
        String str = "";
        if (aMi != null) {
            str = aMi.getId();
            String bU = aMi.bU(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(bU)) {
                bJ[1] = bU;
            }
        }
        String rK = this.ele.getPbData().aIB().rK();
        if (rK != null && rK.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bJ[1]);
        shareFromPBMsgData.setImageUrl(bJ[0]);
        shareFromPBMsgData.setForumName(this.ele.getPbData().aIz().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.ele.getPbData().aIB().getId());
        shareFromPBMsgData.setTitle(this.ele.getPbData().aIB().getTitle());
        return shareFromPBMsgData;
    }

    private void T(Intent intent) {
        b(aJQ(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void b(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.ele != null && this.ele.getPbData() != null && this.ele.getPbData().aIB() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            hh hhVar = new hh(getPageContext().getPageActivity());
            hhVar.setData(shareFromPBMsgData);
            aVar.ca(1);
            aVar.v(hhVar);
            aVar.a(w.l.share, new bk(this, hhVar, j, str, str2, shareFromPBMsgData));
            aVar.b(w.l.alert_no_button, new bm(this, hhVar));
            aVar.as(true);
            aVar.b(getPageContext()).tc();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                hhVar.D(shareFromPBMsgData.getImageUrl(), this.ele.getPbData().aIN() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.ele != null && this.ele.getPbData() != null && this.ele.getPbData().aIB() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            hh hhVar = new hh(getPageContext().getPageActivity());
            hhVar.setData(shareFromPBMsgData);
            aVar.ca(1);
            aVar.v(hhVar);
            aVar.a(w.l.share, new bn(this, hhVar, i, str, j, shareFromPBMsgData));
            aVar.b(w.l.alert_no_button, new bo(this, hhVar));
            aVar.as(true);
            aVar.b(getPageContext()).tc();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                hhVar.D(shareFromPBMsgData.getImageUrl(), this.ele.getPbData().aIN() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJR() {
        MarkData oF;
        if (this.dHz != null && (oF = this.ele.oF(this.elU.aME())) != null) {
            if (!oF.isApp() || (oF = this.ele.oF(this.elU.aME() + 1)) != null) {
                this.elU.aMz();
                this.dHz.a(oF);
                if (!this.dHz.nD()) {
                    this.dHz.nF();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.dHz.nE();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJS() {
        com.baidu.tieba.pb.data.f pbData = this.ele.getPbData();
        this.ele.iu(true);
        pbData.nK(this.dHz.nC());
        this.elU.l(pbData);
    }

    private boolean aJT() {
        if (this.ele == null) {
            return true;
        }
        if (this.ele.nD()) {
            MarkData aKZ = this.ele.aKZ();
            if (aKZ == null || !this.ele.getIsFromMark()) {
                return true;
            }
            MarkData oF = this.ele.oF(this.elU.aME());
            if (oF == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aKZ);
                setResult(-1, intent);
                return true;
            } else if (oF.getPostId() == null || oF.getPostId().equals(aKZ.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aKZ);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cB(getPageContext().getString(w.l.alert_update_mark));
                aVar.a(w.l.alert_yes_btn, new bp(this, oF, aKZ, aVar));
                aVar.b(w.l.alert_no_button, new bq(this, aKZ, aVar));
                aVar.a(new br(this, aKZ, aVar));
                aVar.b(getPageContext());
                aVar.tc();
                return false;
            }
        } else if (this.ele.getPbData() == null || this.ele.getPbData().aID() == null || this.ele.getPbData().aID().size() <= 0 || !this.ele.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.elU == null) {
            return null;
        }
        return this.elU.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int Ia() {
        if (this.elU == null) {
            return 0;
        }
        return this.elU.aMJ();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> Ib() {
        if (this.aNH == null) {
            this.aNH = new com.baidu.adp.lib.e.b<>(new bs(this), 8, 0);
        }
        return this.aNH;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> Ic() {
        if (this.aNI == null) {
            this.aNI = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aNI;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> Id() {
        if (this.aNM == null) {
            this.aNM = new com.baidu.adp.lib.e.b<>(new bt(this), 20, 0);
        }
        return this.aNM;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Ie() {
        if (this.aNK == null) {
            this.aNK = new com.baidu.adp.lib.e.b<>(new bu(this), 8, 0);
        }
        return this.aNK;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Ig() {
        if (this.aNJ == null) {
            this.aNJ = com.baidu.tieba.graffiti.d.o(getPageContext().getPageActivity(), 6);
        }
        return this.aNJ;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wC() {
        if (this.ams == null) {
            this.ams = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.ams;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Y(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.elI = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        if (hi.oc(str) && this.ele != null && this.ele.getThreadID() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11664").r("obj_param1", 1).Z("post_id", this.ele.getThreadID()));
        }
        hi.aNf().f(getPageContext(), str);
        this.elI = true;
    }

    private com.baidu.tbadk.core.dialog.a aJU() {
        if (this.elC == null) {
            this.elC = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.elC.cA(getPageContext().getString(w.l.download_baidu_video_dialog));
            this.elC.a(getPageContext().getString(w.l.install), new bv(this));
            this.elC.b(getPageContext().getString(w.l.cancel), new bx(this));
            this.elC.ar(true);
            this.elC.b(getPageContext());
            this.elC.as(false);
        }
        this.elC.tc();
        return this.elC;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        hi.aNf().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.elI = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ac(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra(VrPlayerActivityConfig.TITLE, "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            aJU();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.elI = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ab(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.ele.getPbData();
            TbRichText an = an(str, i);
            if (an != null && (tbRichTextData = an.Hx().get(this.emQ)) != null) {
                bVar.ent = new ArrayList<>();
                bVar.enu = new ConcurrentHashMap<>();
                if (!tbRichTextData.HD().HP()) {
                    bVar.enw = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    bVar.ent.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.postId = an.getPostId();
                    imageUrlData.mIsReserver = this.ele.aKY();
                    imageUrlData.mIsSeeHost = this.ele.getHostMode();
                    bVar.enu.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aIz() != null) {
                            bVar.forumName = pbData.aIz().getName();
                            bVar.forumId = pbData.aIz().getId();
                        }
                        if (pbData.aIB() != null) {
                            bVar.threadId = pbData.aIB().getId();
                        }
                        bVar.env = pbData.aIN() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.enw = true;
                int size = pbData.aID().size();
                this.emR = false;
                bVar.index = -1;
                if (pbData.aII() != null) {
                    PostData aII = pbData.aII();
                    TbRichText avd = aII.avd();
                    if (!fw.i(aII)) {
                        i2 = a(avd, an, i, i, bVar.ent, bVar.enu);
                    } else {
                        i2 = a(aII, i, bVar.ent, bVar.enu);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aID().get(i4);
                    if (postData.getId() == null || pbData.aII() == null || pbData.aII().getId() == null || !postData.getId().equals(pbData.aII().getId())) {
                        TbRichText avd2 = postData.avd();
                        if (!fw.i(postData)) {
                            i3 = a(avd2, an, i3, i, bVar.ent, bVar.enu);
                        } else {
                            i3 = a(postData, i3, bVar.ent, bVar.enu);
                        }
                    }
                }
                if (bVar.ent.size() > 0) {
                    bVar.lastId = bVar.ent.get(bVar.ent.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aIz() != null) {
                        bVar.forumName = pbData.aIz().getName();
                        bVar.forumId = pbData.aIz().getId();
                    }
                    if (pbData.aIB() != null) {
                        bVar.threadId = pbData.aIB().getId();
                    }
                    bVar.env = pbData.aIN() == 1;
                }
                bVar.index = i3;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.HD() == null) {
            return null;
        }
        return tbRichTextData.HD().HT();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.HD() == null) {
            return 0L;
        }
        return tbRichTextData.HD().getOriginalSize();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo HD;
        if (tbRichText == tbRichText2) {
            this.emR = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.Hx().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Hx().get(i6) == null || tbRichText.Hx().get(i6).getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int width = tbRichText.Hx().get(i6).HD().getWidth();
                    int height = tbRichText.Hx().get(i6).HD().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Hx().get(i6).HD().HP()) {
                        if (tbRichText == tbRichText2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Hx().get(i6);
                        String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                        if (!TextUtils.isEmpty(c2)) {
                            arrayList.add(c2);
                            if (tbRichTextData != null && (HD = tbRichTextData.HD()) != null) {
                                String HR = HD.HR();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = HR;
                                imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.ele.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.ele.aKY();
                                imageUrlData.mIsSeeHost = this.ele.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.emR) {
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
        com.baidu.tieba.tbadkCore.data.h bio;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bhL;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bhL = (bio = postData.bio()).bhL()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bhL.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bhL.get(i3);
                if (jVar != null) {
                    String bhQ = jVar.bhQ();
                    if (!com.baidu.tbadk.core.util.au.isEmpty(bhQ)) {
                        arrayList.add(bhQ);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bhQ;
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        imageUrlData.originalUrl = jVar.bhP();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.ele.getThreadID(), -1L);
                        imageUrlData.mIsReserver = this.ele.aKY();
                        imageUrlData.mIsSeeHost = this.ele.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bio.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bhQ, imageUrlData);
                        }
                        if (!this.emR) {
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
    public void g(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.ele.rD())) {
                z = true;
            }
            MarkData h = this.ele.h(postData);
            if (h != null) {
                this.elU.aMz();
                if (this.dHz != null) {
                    this.dHz.a(h);
                    if (!z) {
                        this.dHz.nF();
                    } else {
                        this.dHz.nE();
                    }
                }
            }
        }
    }

    private TbRichText an(String str, int i) {
        TbRichText tbRichText = null;
        if (this.ele == null || this.ele.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.ele.getPbData();
        if (pbData.aII() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aII());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            return a(pbData.aID(), str, i);
        }
        return tbRichText;
    }

    private long nQ(String str) {
        ArrayList<PostData> aID;
        com.baidu.tieba.pb.data.f pbData = this.ele.getPbData();
        if (pbData != null && (aID = pbData.aID()) != null && !aID.isEmpty()) {
            Iterator<PostData> it = aID.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bio = next.bio();
                if (bio != null && bio.fBJ) {
                    Iterator<TbRichTextData> it2 = next.avd().Hx().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.HL().getLink().equals(str)) {
                            return bio.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> Hx;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText avd = arrayList.get(i2).avd();
            if (avd != null && (Hx = avd.Hx()) != null) {
                int size = Hx.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Hx.get(i4) != null && Hx.get(i4).getType() == 8) {
                        i3++;
                        if (Hx.get(i4).HD().HR().equals(str)) {
                            int width = Hx.get(i4).HD().getWidth();
                            int height = Hx.get(i4).HD().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.emQ = i4;
                            return avd;
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
            this.elc = str;
            if (this.elB == null) {
                aJH();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.elB.cf(1).setVisibility(8);
            } else {
                this.elB.cf(1).setVisibility(0);
            }
            this.elB.tf();
            this.elI = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bTZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tq() {
        hideNetRefreshView(this.elU.getView());
        aJV();
        if (this.ele.EA()) {
            this.elU.aMz();
        }
    }

    private void aJV() {
        showLoadingView(this.elU.getView(), false, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds400));
        View DX = getLoadingView().DX();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) DX.getLayoutParams();
        layoutParams.addRule(3, this.elU.aMT().getId());
        DX.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aas() {
        if (this.bTZ != null) {
            this.bTZ.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void os(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ot(int i) {
        if (this.ele.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.ele.getPbData();
            String name = pbData.aIz().getName();
            String title = pbData.aIB().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.ele.getThreadID() + "?share=9105&fr=share&see_lz=" + (this.ele.getHostMode() ? 1 : 0);
            String[] bJ = pbData.bJ(getPageContext().getPageActivity());
            String str2 = bJ[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = bJ[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (aJJ() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10399").Z("fid", pbData.getForumId()).Z("tid", pbData.getThreadId()).Z(SapiAccountManager.SESSION_UID, currentAccount));
            } else if (aJJ() == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10406").Z("fid", pbData.getForumId()).Z("tid", pbData.getThreadId()).Z(SapiAccountManager.SESSION_UID, currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(w.l.share_content_tpl), title, name, str3);
            com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
            hVar.title = title;
            hVar.content = format;
            hVar.linkUrl = str;
            hVar.arS = true;
            hVar.extData = this.ele.getThreadID();
            hVar.asa = 3;
            hVar.arZ = i;
            if (parse != null) {
                hVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), hVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(w.l.forum_friend, w.g.icon_unite_share_baf, new by(this));
            shareDialogConfig.setCopyLinkListener(new bz(this, hVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> If() {
        if (this.aNL == null) {
            this.aNL = new com.baidu.adp.lib.e.b<>(new ca(this), 15, 0);
        }
        return this.aNL;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.elU.aMt() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10517").r("obj_locate", 2).Z("fid", this.ele.getPbData().getForumId()));
            } else {
                com.baidu.tbadk.core.data.bl aIB = this.ele.getPbData().aIB();
                if (view != null) {
                    boolean z = aIB.rk() == null || aIB.rk().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.emA > 1000) {
                            this.emB = true;
                            aU(view);
                        } else {
                            this.emB = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            h(view, this.emB);
                        } else {
                            g(view, this.emB);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        g(view, this.emB);
                    } else if (motionEvent.getAction() == 3) {
                        g(view, this.emB);
                    }
                }
            }
        }
        return false;
    }

    private void g(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.praise_animation_scale2));
            new Handler().postDelayed(new cb(this), 200L);
        }
    }

    private void h(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.praise_animation_scale3));
            new Handler().postDelayed(new cc(this), 600L);
        }
    }

    private void aU(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.w onGetPreLoadListView() {
        return getListView();
    }

    public void aat() {
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
        } else if (aVar.te() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.te();
            int intValue = ((Integer) sparseArray.get(fx.euw)).intValue();
            if (intValue == fx.eux) {
                if (!this.elT.biS()) {
                    this.elU.aMw();
                    int intValue2 = ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue();
                    this.elT.a(this.ele.getPbData().aIz().getId(), this.ele.getPbData().aIz().getName(), this.ele.getPbData().aIB().getId(), (String) sparseArray.get(w.h.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == fx.euy || intValue == fx.euA) {
                if (this.ele.aLl() != null) {
                    this.ele.aLl().ow(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == fx.euy) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == fx.euz) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.emV).pd()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.emm);
        userMuteAddAndDelCustomMessage.setTag(this.emm);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean nR(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bh.aN(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("bubble_link", ""))) {
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

    public void ij(boolean z) {
        this.eme = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aJW() {
        ArrayList<PostData> aID;
        int q;
        if (this.ele == null || this.ele.getPbData() == null || this.ele.getPbData().aID() == null || (q = com.baidu.tbadk.core.util.x.q((aID = this.ele.getPbData().aID()))) == 0) {
            return "";
        }
        if (this.ele.aKY()) {
            Iterator<PostData> it = aID.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.big() == 1) {
                    return next.getId();
                }
            }
        }
        int aMD = this.elU.aMD();
        PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(aID, aMD);
        if (postData == null || postData.getAuthor() == null) {
            return "";
        }
        if (this.ele.nV(postData.getAuthor().getUserId())) {
            return postData.getId();
        }
        for (int i = aMD - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.x.c(aID, i);
            if (postData2 == null || postData2.getAuthor() == null || postData2.getAuthor().getUserId() == null) {
                break;
            } else if (this.ele.nV(postData2.getAuthor().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = aMD + 1; i2 < q; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.x.c(aID, i2);
            if (postData3 == null || postData3.getAuthor() == null || postData3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.ele.nV(postData3.getAuthor().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ad(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.bb.vy().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.b.a(nQ(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.ele.getPbData().aIz().getId(), this.ele.getPbData().aIz().getName(), this.ele.getPbData().aIB().getTid());
            }
            this.elI = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, String str2, String str3, String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cB(getResources().getString(w.l.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cB(getResources().getString(w.l.make_sure_hide));
        }
        aVar.a(getResources().getString(w.l.alert_yes_button), new cd(this, j, str, str2, str3, str4));
        aVar.b(getResources().getString(w.l.alert_no_button), new ce(this, j, str, str2, str3, str4));
        aVar.as(false);
        aVar.b(getPageContext());
        aVar.tc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b nS(String str) {
        String str2;
        if (this.ele.getPbData() == null || this.ele.getPbData().aID() == null || this.ele.getPbData().aID().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i < this.ele.getPbData().aID().size()) {
                if (str.equals(this.ele.getPbData().aID().get(i).getId())) {
                    break;
                }
                i++;
            } else {
                i = 0;
                break;
            }
        }
        PostData postData = this.ele.getPbData().aID().get(i);
        if (postData.avd() == null || postData.avd().Hx() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.avd().Hx().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.HD() != null) {
                    str2 = next.HD().HR();
                }
            }
        }
        a(str2, 0, bVar);
        com.baidu.tieba.pb.data.g.a(postData, bVar);
        return bVar;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.elx) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.elx = false;
        } else if (aJX()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.elx) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.elx = false;
        } else if (aJX()) {
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
        if (pageStayDurationItem != null && this.ele != null) {
            if (this.ele.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.ele.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.ele.getThreadID(), 0L));
            if (this.elJ) {
                pageStayDurationItem.objParam1 = "1";
            }
        }
        return pageStayDurationItem;
    }

    public boolean aJX() {
        return (!this.elv && this.emX == -1 && this.emY == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.ena = nVar;
            this.elv = true;
            this.elU.aMk();
            this.elU.oa(this.emZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJY() {
        if (this.ena != null) {
            if (this.emX == -1) {
                showToast(w.l.pb_manga_not_prev_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.ena.getCartoonId(), this.emX, 0)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJZ() {
        if (this.ena != null) {
            if (this.emY == -1) {
                showToast(w.l.pb_manga_not_next_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.ena.getCartoonId(), this.emY, 0)));
            finish();
        }
    }

    public int aKa() {
        return this.emX;
    }

    public int aKb() {
        return this.emY;
    }

    private void akg() {
        if (this.ele != null && this.ele.getPbData() != null && this.ele.getPbData().aIB() != null && this.ele.getPbData().aIB().sh()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aKc() {
        if (this.ele != null && this.ele.getPbData() != null && this.ele.getPbData().aIB() != null && this.ele.getPbData().aIB().sh()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aKd() {
        if (this.ely) {
            this.elQ = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.ele.getPbData() != null && this.ele.getPbData().aIB() != null && this.ele.getPbData().aIB().rd() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.ele.getPbData().aIB().rd().getThreadId(), this.ele.getPbData().aIB().rd().getTaskId(), this.ele.getPbData().aIB().rd().getForumId(), this.ele.getPbData().aIB().rd().getForumName(), this.ele.getPbData().aIB().rq(), this.ele.getPbData().aIB().rr())));
            this.elx = true;
            finish();
        }
    }

    public boolean aKe() {
        return this.ely;
    }

    public String aKf() {
        return this.elO;
    }

    public PbInterviewStatusView.a aKg() {
        return this.elS;
    }

    public void ik(boolean z) {
        this.elP = z;
    }

    public boolean aKh() {
        if (this.ele != null) {
            return this.ele.aKO();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKi() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cB(getResources().getString(w.l.mute_is_super_member_function));
        aVar.a(w.l.open_now, new cg(this));
        aVar.b(w.l.cancel, new ch(this));
        aVar.b(this.emk).tc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fy(String str) {
        if (str == null) {
            str = "";
        }
        if (this.emk != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.emk.getPageActivity());
            aVar.cB(str);
            aVar.b(w.l.know, new ci(this));
            aVar.b(this.emk).tc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.elU.Pd();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.emk.getPageActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.cB(this.emk.getResources().getString(w.l.block_mute_message_alert, str2));
        } else {
            aVar.cB(str);
        }
        aVar.a(w.l.confirm, new cj(this, userMuteAddAndDelCustomMessage));
        aVar.b(w.l.cancel, new ck(this));
        aVar.b(this.emk).tc();
    }

    public void aKj() {
        if (this.ele != null && this.ele.getPbData() != null && this.ele.getPbData().aIB() != null && this.ele.getPbData().aIB().sx() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bY(w.l.channel_open_push_message);
            aVar.a(w.l.need_channel_push, new cl(this));
            aVar.b(w.l.not_need_channel_push, new cm(this));
            aVar.b(getPageContext());
            aVar.tc();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.b
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.b[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.b.class);
            for (int i = 0; i < objArr.length; i++) {
                if (hi.oc(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_pb_wenxue)) != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                    spannableStringBuilder2.setSpan(new com.baidu.tbadk.widget.i(drawable), 0, "#4%2&@#907$12#@96476)w7we9e~@$%&&".length(), 33);
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
            this.elN = true;
        } else {
            this.elN = false;
        }
        if (this.elU != null) {
            this.elU.onConfigurationChanged(configuration);
        }
        if (this.elZ != null) {
            this.elZ.dismiss();
        }
    }

    public boolean aKk() {
        if (this.ele != null) {
            return this.ele.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, fx fxVar) {
        boolean z;
        List<PostData> list = this.ele.getPbData().aIL().eju;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bid().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bid().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bid().remove(i2);
                    list.get(i).bif();
                    z = true;
                    break;
                }
            }
            list.get(i).qm(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            fxVar.l(this.ele.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.n nVar) {
        String id = nVar.aJj().getId();
        List<PostData> list = this.ele.getPbData().aIL().eju;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            PostData postData = list.get(i2);
            if (postData.getId() == null || !postData.getId().equals(id)) {
                i = i2 + 1;
            } else {
                ArrayList<PostData> aJn = nVar.aJn();
                postData.sl(nVar.getTotalCount());
                if (postData.bid() != null) {
                    postData.bid().clear();
                    postData.bid().addAll(aJn);
                }
            }
        }
        this.elU.l(this.ele.getPbData());
    }

    public boolean aKl() {
        boolean z = true;
        if (this.ele == null) {
            return false;
        }
        switch (this.ele.aLs()) {
            case 1:
            case 2:
                break;
            default:
                if (this.ele.getPbData() != null && this.ele.getPbData().aIB() != null && this.ele.getPbData().aIB().sE() && StringUtils.isNull(this.ele.getForumId())) {
                    z = false;
                    break;
                }
                break;
        }
        return z;
    }

    public void aKm() {
        if (this.elU != null) {
            this.elU.aMe();
            aat();
        }
    }

    public void aKn() {
        if (this.elU != null) {
            this.elU.aKn();
        }
    }

    public PostData aII() {
        return this.elU.c(this.ele.epx, this.ele.aKN());
    }
}
