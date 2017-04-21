package com.baidu.tieba.pb.pb.main;

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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
import com.baidu.tieba.pb.pb.main.cv;
import com.baidu.tieba.pb.pb.main.cy;
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
    private com.baidu.adp.lib.e.b<ImageView> aNs;
    private com.baidu.adp.lib.e.b<TextView> aNt;
    private com.baidu.adp.lib.e.b<View> aNu;
    private com.baidu.adp.lib.e.b<View> aNv;
    private com.baidu.adp.lib.e.b<LinearLayout> aNw;
    private com.baidu.adp.lib.e.b<GifView> aNx;
    private com.baidu.adp.lib.e.b<TbImageView> amf;
    private VoiceManager bOT;
    private com.baidu.tbadk.h.a bPs;
    private com.baidu.tieba.e.c bSv;
    private com.baidu.tieba.pb.pb.main.a.f ekO;
    private boolean ekZ;
    private String ekt;
    private Runnable elA;
    private boolean elW;
    private com.baidu.tieba.pb.pb.main.b ela;
    private dp eln;
    private boolean els;
    private com.baidu.tieba.tbadkCore.data.e elt;
    private com.baidu.tbadk.editortools.pb.c elu;
    private com.baidu.adp.base.g elx;
    private com.baidu.tbadk.core.view.h ely;
    private BdUniqueId elz;
    private String emh;
    private com.baidu.tbadk.core.data.n emi;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean ekN = false;
    private boolean ekP = false;
    private boolean ekQ = false;
    private boolean dLt = false;
    private int ekR = 0;
    private com.baidu.tbadk.core.dialog.c ekS = null;
    private long bGX = -1;
    private long aGG = 0;
    private long ekT = 0;
    private long createTime = 0;
    private long aGy = 0;
    private boolean ekU = false;
    private com.baidu.tbadk.j.e ekV = null;
    private long ekW = 0;
    private boolean ekX = false;
    private boolean ekY = false;
    private String aAW = null;
    private boolean elb = false;
    private boolean elc = false;
    private String eld = "";
    private boolean ele = true;
    private boolean elf = false;
    private String source = "";
    private PbInterviewStatusView.a elg = new i(this);
    private final Handler mHandler = new Handler(new t(this));
    private PbModel ekv = null;
    private com.baidu.tbadk.baseEditMark.a dHE = null;
    private ForumManageModel elh = null;
    private ey eli = null;
    public final com.baidu.tieba.pb.pb.main.a.a elj = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean elk = false;
    private boolean ell = false;
    private boolean elm = false;
    private boolean elo = false;
    private boolean elp = false;
    private boolean elq = false;
    private boolean elr = false;
    private boolean elv = false;
    private com.baidu.tbadk.editortools.pb.b aBa = new ae(this);
    private boolean elw = false;
    private int cDT = -1;
    private int elB = -1;
    private final CustomMessageListener elC = new ap(this, CmdConfigCustom.PB_RESET_EDITOR_TOOL);
    CustomMessageListener bPM = new ba(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private CustomMessageListener elD = new bl(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener dqU = new bu(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener drr = new cf(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener elE = new cg(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener aOm = new j(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
    private CustomMessageListener cQV = new k(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private cv.a elF = new l(this);
    private View.OnClickListener dqT = new m(this);
    private CustomMessageListener elG = new n(this, CmdConfigCustom.CMD_SEND_GIFT_SUCCESS);
    private boolean elH = false;
    private PraiseModel elI = new PraiseModel(getPageContext(), new o(this));
    private long elJ = 0;
    private boolean elK = true;
    private f.a elL = new p(this);
    private CustomMessageListener baa = new q(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener elM = new r(this, CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED);
    private com.baidu.tieba.pb.a.d ejB = new com.baidu.tieba.pb.a.d(new s(this));
    private CustomMessageListener elN = new u(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener elO = new v(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener elP = new w(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    public a.b dVo = new x(this);
    public final View.OnClickListener bQO = new y(this);
    private final NewWriteModel.d aBg = new z(this);
    private final PbModel.a elQ = new aa(this);
    private CustomMessageListener elR = new ab(this, CmdConfigCustom.CMD_WX_SHARE_SUCCESS);
    private CustomMessageListener elS = new ac(this, CmdConfigCustom.CMD_TTS_OPTION_PB);
    private final a.InterfaceC0028a elT = new ad(this);
    private final AbsListView.OnScrollListener mOnScrollListener = new af(this);
    private final com.baidu.adp.base.f elU = new ag(this);
    private final c elV = new ah(this);
    private final ab.b aYD = new ai(this);
    private final BdListView.e elX = new aj(this);
    private int elY = 0;
    private final TbRichTextView.e aNM = new ak(this);
    boolean elZ = false;
    PostData ema = null;
    private final c.b emb = new al(this);
    private final View.OnLongClickListener atn = new am(this);
    private final NoNetworkView.a bOn = new an(this);
    public View.OnTouchListener aOj = new ao(this);
    private a.InterfaceC0055a aRo = new aq(this);
    private final c.a emc = new ar(this);
    private String emd = null;
    private final cy.a eme = new as(this);
    private int emf = -1;
    private int emg = -1;
    private CustomMessageListener emj = new at(this, CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST);
    private final CustomMessageListener bPQ = new au(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> emB;
        public ConcurrentHashMap<String, ImageUrlData> emC;
        public boolean emE;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean emD = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes.dex */
    public interface c {
    }

    public void iq(boolean z) {
        this.ekX = z;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.pb.c aLn() {
        return this.elu;
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        if (jVar.aKW() != null) {
            String id = jVar.aKW().getId();
            ArrayList<PostData> aKA = this.ekv.getPbData().aKA();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aKA.size()) {
                    break;
                }
                PostData postData = aKA.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aLa = jVar.aLa();
                    postData.rX(jVar.getTotalCount());
                    if (postData.bjm() != null) {
                        postData.bjm().clear();
                        postData.bjm().addAll(aLa);
                    }
                }
            }
            this.eli.k(this.ekv.getPbData());
        }
    }

    public void aLo() {
        com.baidu.tieba.pb.data.f pbData;
        com.baidu.tbadk.core.data.bi aKy;
        if (!this.elH) {
            if (!com.baidu.adp.lib.util.k.hB()) {
                showToast(w.l.no_network_guide);
            } else if (this.elK) {
                this.elH = true;
                if (this.ekv != null && (pbData = this.ekv.getPbData()) != null && (aKy = pbData.aKy()) != null) {
                    int isLike = aKy.se() == null ? 0 : aKy.se().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10796").aa("tid", aKy.getId()));
                    }
                    if (this.elI != null) {
                        this.elI.a(aKy.sE(), aKy.getId(), isLike, "pb");
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
                cVar.cc(w.l.operation);
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
                cVar.d(getPageContext()).tT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void io(int i) {
        com.baidu.tbadk.core.data.bi aKy;
        String sb;
        String w;
        if (this.ekv != null && this.ekv.getPbData() != null && (aKy = this.ekv.getPbData().aKy()) != null) {
            if (i == 1) {
                PraiseData se = aKy.se();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (se == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aKy.a(praiseData);
                    } else {
                        aKy.se().getUser().add(0, metaData);
                        aKy.se().setNum(aKy.se().getNum() + 1);
                        aKy.se().setIsLike(i);
                    }
                }
                if (aKy.se() != null) {
                    if (aKy.se().getNum() < 1) {
                        w = getResources().getString(w.l.frs_item_praise_text);
                    } else {
                        w = com.baidu.tbadk.core.util.au.w(aKy.se().getNum());
                    }
                    this.eli.P(w, true);
                }
            } else if (aKy.se() != null) {
                aKy.se().setIsLike(i);
                aKy.se().setNum(aKy.se().getNum() - 1);
                ArrayList<MetaData> user = aKy.se().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aKy.se().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aKy.se().getNum() < 1) {
                    sb = getResources().getString(w.l.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(aKy.se().getNum())).toString();
                }
                this.eli.P(sb, false);
            }
            if (this.ekv.aMD()) {
                this.eli.aOh().notifyDataSetChanged();
            } else {
                this.eli.l(this.ekv.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apU && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        if (this.ekv != null && this.ekv.getPbData() != null && this.eli != null) {
            this.eli.d(this.ekv.getPbData(), this.ekv.aMD(), this.ekv.aMU());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bPs == null) {
                this.bPs = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.bPs.ao(updateAttentionMessage.getData().toUid, this.ekv.getPbData().getForumId());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.ekv.p(bundle);
        if (this.bOT != null) {
            this.bOT.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.elu.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.elx = getPageContext();
        Intent intent = getIntent();
        if (intent != null) {
            this.bGX = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.eld = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.eld)) {
                this.ekP = true;
            }
            this.emf = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.emg = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.emh = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            this.elp = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
            if (aLI()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.au.isEmpty(this.source) ? "" : this.source;
            this.elB = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            this.ekZ = intent.getBooleanExtra("is_from_push", false);
        } else {
            this.bGX = System.currentTimeMillis();
        }
        this.ekT = System.currentTimeMillis();
        this.aGy = this.ekT - this.bGX;
        super.onCreate(bundle);
        this.ekR = 0;
        r(bundle);
        if (this.ekv != null && this.ekv.getPbData() != null) {
            this.ekv.getPbData().nt(this.source);
        }
        initUI();
        if (intent != null && this.eli != null) {
            this.eli.eqY = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
            if (!StringUtils.isNull(intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME))) {
                if (this.elA == null) {
                    this.elA = new ax(this, intent);
                }
                getSafeHandler().postDelayed(this.elA, 1500L);
            }
        }
        this.bOT = new VoiceManager();
        this.bOT.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.pb.l lVar = new com.baidu.tbadk.editortools.pb.l();
        lVar.setForumName(this.ekv.aMC());
        if (this.ekv.getPbData() != null && this.ekv.getPbData().aKx() != null) {
            lVar.setForumId(this.ekv.getPbData().aKx().getId());
        }
        lVar.setFrom("pb");
        lVar.a(this.ekv);
        this.elu = (com.baidu.tbadk.editortools.pb.c) lVar.aN(getActivity());
        this.elu.d(this);
        this.elu.a(this.aBg);
        this.elu.a(this.aBa);
        this.elu.a(this, bundle);
        this.elu.Dn().c(new com.baidu.tbadk.editortools.w(getActivity()));
        this.elu.Dn().bD(true);
        ir(true);
        this.eli.setEditorTools(this.elu.Dn());
        this.elu.a(this.ekv.aML(), this.ekv.getThreadID(), this.ekv.aNe());
        registerListener(this.dqU);
        if (!this.ekv.aMI()) {
            this.elu.fx(this.ekv.getThreadID());
        }
        if (this.ekv.aNf()) {
            this.elu.fv(getPageContext().getString(w.l.pb_reply_hint_from_smart_frs));
        } else {
            this.elu.fv(getPageContext().getString(w.l.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.ekT;
        registerListener(this.elD);
        registerListener(this.drr);
        registerListener(this.elE);
        registerListener(this.aOm);
        registerListener(this.bPM);
        registerListener(this.elC);
        this.elt = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.fxG);
        this.elt.biN();
        registerListener(this.elG);
        registerListener(this.baa);
        if (this.ekv != null) {
            this.ekv.aMW();
        }
        if (TbadkCoreApplication.m9getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.elM);
        registerListener(this.elS);
        registerListener(this.elR);
        registerListener(this.emj);
        this.ela = new com.baidu.tieba.pb.pb.main.b(this.ekv, this);
        if (this.eli != null && this.eli.aOL() != null && this.eli.aOM() != null) {
            this.ekO = new com.baidu.tieba.pb.pb.main.a.f(getActivity(), this.eli.aOL(), this.eli.aOM());
            this.ekO.a(this.elL);
        }
        if (this.ekN && this.eli != null && this.eli.aOM() != null) {
            this.eli.aOM().setVisibility(8);
        }
        this.ely = new com.baidu.tbadk.core.view.h();
        this.ely.ajz = 1000L;
        registerListener(this.elP);
        registerListener(this.elN);
        registerListener(this.elO);
        this.elz = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.elz;
        userMuteAddAndDelCustomMessage.setTag(this.elz);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.elz;
        userMuteCheckCustomMessage.setTag(this.elz);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public String aLp() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.f aLq() {
        return this.ekO;
    }

    private void ir(boolean z) {
        this.elu.bG(z);
        this.elu.bH(z);
        this.elu.bI(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bOT != null) {
            this.bOT.onStart(getPageContext());
        }
    }

    public ey aLr() {
        return this.eli;
    }

    public PbModel aLs() {
        return this.ekv;
    }

    public void nu(String str) {
        if (this.ekv != null && !StringUtils.isNull(str) && this.eli != null) {
            this.eli.aOi();
            this.eli.jc(true);
            this.ekv.nu(str);
            this.elb = true;
            this.eli.axI();
            this.eli.aOE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.m9getInst().isReadMenuDialogOnTop()) {
            this.ekQ = false;
        } else {
            this.ekQ = true;
        }
        super.onPause();
        if (this.eli.aNP() != null && this.eli.aNP().aLk() != null) {
            this.eli.aNP().aLk().onPause();
        }
        BdListView listView = getListView();
        this.ekR = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.ekR == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.bOT != null) {
            this.bOT.onPause(getPageContext());
        }
        if (this.eli != null) {
            this.eli.onPause();
        }
        if (!this.ekv.aMI()) {
            this.elu.fw(this.ekv.getThreadID());
        }
        if (this.ekv != null) {
            this.ekv.aMX();
        }
        MessageManager.getInstance().unRegisterListener(this.cQV);
        ams();
        MessageManager.getInstance().unRegisterListener(this.elN);
        MessageManager.getInstance().unRegisterListener(this.elO);
        MessageManager.getInstance().unRegisterListener(this.elP);
        MessageManager.getInstance().unRegisterListener(this.bPQ);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aLt() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.ekv.getPbData(), this.ekv.aMD(), this.ekv.aMU());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.ekQ = false;
        super.onResume();
        if (this.elf) {
            this.elf = false;
            aLO();
        }
        if (this.eli.aNP() != null && this.eli.aNP().aLk() != null) {
            this.eli.aNP().aLk().onResume();
        }
        if (aLt()) {
            this.ekW = System.currentTimeMillis();
        } else {
            this.ekW = -1L;
        }
        if (this.eli != null && this.eli.getView() != null) {
            if (!this.dLt) {
                aLG();
            } else {
                hideLoadingView(this.eli.getView());
            }
            this.eli.onResume();
        }
        if (this.ekR == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.eli != null) {
            noNetworkView = this.eli.aNQ();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.hk()) {
            noNetworkView.aL(false);
        }
        if (this.bOT != null) {
            this.bOT.onResume(getPageContext());
        }
        registerListener(this.cQV);
        this.els = false;
        aLN();
        registerListener(this.elN);
        registerListener(this.elO);
        registerListener(this.elP);
        registerListener(this.bPQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.eli.iQ(z);
        if (this.eln != null) {
            this.eln.iC(z);
        }
        if (z && this.els) {
            this.eli.aOn();
            this.ekv.iy(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ekW > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10804").aa("obj_duration", new StringBuilder(String.valueOf(System.currentTimeMillis() - this.ekW)).toString()));
            this.ekW = 0L;
        }
        if (this.elu != null && this.elu.Dn() != null && this.elu.Dn().getVisibility() != 0) {
            this.elu.DX();
        }
        if (aLr().aNT() != null) {
            aLr().aNT().onStop();
        }
        if (this.eli.erm != null && !this.eli.erm.UI()) {
            this.eli.erm.axZ();
        }
        if (this.ekv != null && this.ekv.getPbData() != null && this.ekv.getPbData().aKx() != null && this.ekv.getPbData().aKy() != null) {
            com.baidu.tbadk.distribute.a.CX().a(getPageContext().getPageActivity(), "pb", this.ekv.getPbData().aKx().getId(), com.baidu.adp.lib.g.b.c(this.ekv.getPbData().aKy().getId(), 0L));
        }
        if (this.bOT != null) {
            this.bOT.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.ela != null) {
            this.ela.destroy();
        }
        if (this.elo && this.ekv != null) {
            a(this.ekv.getPbData(), -2, 0, false, false);
        }
        if (!this.ekU && this.eli != null) {
            this.ekU = true;
            this.eli.aOD();
            a(false, (PostData) null);
        }
        if (this.ekv != null) {
            this.ekv.cancelLoadData();
            this.ekv.destory();
        }
        if (this.elu != null) {
            this.elu.onDestroy();
        }
        if (this.elh != null) {
            this.elh.cancelLoadData();
        }
        if (this.eli != null) {
            this.eli.onDestroy();
            if (this.eli.erm != null) {
                this.eli.erm.axZ();
            }
        }
        if (this.ekV != null) {
            this.ekV.onDestroy();
        }
        if (this.ekO != null) {
            this.ekO.Yh();
        }
        super.onDestroy();
        if (this.bOT != null) {
            this.bOT.onDestory(getPageContext());
        }
        if (this.bPs != null) {
            this.bPs.destory();
        }
        this.eli.axI();
        MessageManager.getInstance().unRegisterListener(this.elN);
        MessageManager.getInstance().unRegisterListener(this.elO);
        MessageManager.getInstance().unRegisterListener(this.elP);
        MessageManager.getInstance().unRegisterListener(this.elz);
        this.elx = null;
        this.ely = null;
        com.baidu.tieba.recapp.d.a.bbv().bbx();
        if (this.elA != null) {
            getSafeHandler().removeCallbacks(this.elA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        cn aOh;
        ArrayList<PostData> aMe;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.ye() && this.eli != null && (aOh = this.eli.aOh()) != null && (aMe = aOh.aMe()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aMe.iterator();
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
                        bVar.bsN = id;
                        bVar.bxd = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.YQ == 1 && !TextUtils.isEmpty(id)) {
                    next.YQ = 2;
                    a.b bVar2 = new a.b();
                    bVar2.bsN = id;
                    bVar2.bxd = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.ekv == null || this.ekv.getPbData() == null || this.ekv.getPbData().aKx() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.ekv.getPbData().aKx().getFirst_class();
                    str2 = this.ekv.getPbData().aKx().getSecond_class();
                    str = this.ekv.getPbData().aKx().getId();
                    str4 = this.ekv.getThreadID();
                }
                com.baidu.tieba.recapp.y.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.yi());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eli.onChangeSkinType(i);
        if (this.elu != null && this.elu.Dn() != null) {
            this.elu.Dn().onChangeSkinType(i);
        }
        if (this.eli.aNQ() != null) {
            this.eli.aNQ().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.eli = new ey(this, this.bQO, this.ejB);
        this.bSv = new com.baidu.tieba.e.c(getActivity());
        this.bSv.a(this.emc);
        this.bSv.a(this.aRo);
        this.eli.setOnScrollListener(this.mOnScrollListener);
        this.eli.d(this.elX);
        this.eli.a(this.aYD);
        this.eli.ik(com.baidu.tbadk.core.q.po().pu());
        this.eli.setOnImageClickListener(this.aNM);
        this.eli.a(this.atn);
        this.eli.h(this.bOn);
        this.eli.a(this.elV);
        this.eli.iQ(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aV(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(w.h.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.fyi == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.q.po().pu()) {
                    return false;
                }
                return ny(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.eli != null) {
            if (z && (!this.dLt || this.elw)) {
                aLG();
            } else {
                hideLoadingView(this.eli.getView());
            }
            this.elw = false;
        }
    }

    private void aLu() {
        if (this.ekS == null) {
            this.ekS = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.ekS.a(new String[]{getPageContext().getString(w.l.call_phone), getPageContext().getString(w.l.sms_phone), getPageContext().getString(w.l.search_in_baidu)}, new ay(this)).cd(c.a.aaR).ce(17).d(getPageContext());
        }
    }

    private void r(Bundle bundle) {
        this.ekv = new PbModel(this);
        this.ekv.a(this.elQ);
        if (this.ekv.aNc() != null) {
            this.ekv.aNc().a(this.eme);
        }
        if (this.ekv.aNb() != null) {
            this.ekv.aNb().a(this.elF);
        }
        if (bundle != null) {
            this.ekv.initWithBundle(bundle);
        } else {
            this.ekv.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.ekv.iB(true);
        }
        ep.aNL().O(this.ekv.aMB(), this.ekv.getIsFromMark());
        if (StringUtils.isNull(this.ekv.getThreadID())) {
            finish();
        } else {
            this.ekv.FC();
        }
    }

    private void initData(Bundle bundle) {
        this.dHE = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dHE != null) {
            this.dHE.a(this.elT);
        }
        this.elh = new ForumManageModel(this);
        this.elh.setLoadDataCallBack(this.elU);
        this.eli.a(new az(this));
        this.elI.setUniqueId(getUniqueId());
        this.elI.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.eli.avw();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(w.h.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.elz;
        userMuteCheckCustomMessage.setTag(this.elz);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.bY(w.l.go_setting_float_window_permission);
        aVar.bZ(w.l.step_to_setting_float_permission);
        aVar.a(w.l.go_and_setting, new bb(this));
        aVar.b(w.l.cancel, new bc(this));
        aVar.b(getPageContext()).tQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aLv() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.ekv != null && this.ekv.getPbData() != null) {
            com.baidu.tieba.pb.data.f pbData = this.ekv.getPbData();
            if (pbData.aKx() != null) {
                sb.append("forum_name=").append(nv(pbData.aKx().getName()));
                sb.append("&");
            }
            if (pbData.aKy() != null) {
                com.baidu.tbadk.core.data.bi aKy = pbData.aKy();
                sb.append("thread_id=").append(aKy.getId());
                sb.append("&");
                sb.append("thread_title=").append(nv(aKy.getTitle()));
                if (aKy.getAuthor() != null && aKy.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aKy.getAuthor().getPortrait());
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

    private String nv(String str) {
        return URLEncoder.encode(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3090=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        PostData postData;
        if (!checkUpIsLogin() || sparseArray == null || !(sparseArray.get(w.h.tag_clip_board) instanceof PostData) || (postData = (PostData) sparseArray.get(w.h.tag_clip_board)) == null || this.ekv == null || this.ekv.getPbData() == null || postData.bjp() <= 1) {
            return;
        }
        String threadID = this.ekv.getThreadID();
        String id = postData.getId();
        int aKI = this.ekv.getPbData() != null ? this.ekv.getPbData().aKI() : 0;
        b nz = nz(id);
        if (nz != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, aKI, postData.aQc(), this.ekv.getPbData().rb(), false, postData.getAuthor() != null ? postData.getAuthor().getIconInfo() : null).addBigImageData(nz.emB, nz.emC, nz.emD, nz.index)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aLw() {
        if (this.ekv.getPbData() == null || this.ekv.getPbData().aKy() == null) {
            return -1;
        }
        return this.ekv.getPbData().aKy().sS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean is(boolean z) {
        if (this.ekv == null || this.ekv.getPbData() == null) {
            return false;
        }
        return ((this.ekv.getPbData().aKI() != 0) || this.ekv.getPbData().aKy() == null || this.ekv.getPbData().aKy().getAuthor() == null || TextUtils.equals(this.ekv.getPbData().aKy().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean it(boolean z) {
        if (z) {
            return true;
        }
        if (this.ekv == null || this.ekv.getPbData() == null) {
            return false;
        }
        return this.ekv.getPbData().aKI() != 0;
    }

    private boolean iu(boolean z) {
        return (z || this.ekv == null || this.ekv.getPbData() == null || this.ekv.getPbData().aKI() == 0) ? false : true;
    }

    public void aLx() {
        if (this.ekv != null && this.ekv.getPbData() != null && this.ekv.getPbData().aKy() != null && this.ekv.getPbData().aKy().getAuthor() != null) {
            com.baidu.tbadk.core.data.bi aKy = this.ekv.getPbData().aKy();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aKy.getAuthor().getUserId());
            GodUserData godUserData = aKy.getAuthor().getGodUserData();
            boolean z = equals && godUserData != null && godUserData.isCanSendCall();
            dt dtVar = new dt();
            if (this.ekv.getPbData().aKI() == 1) {
                dtVar.epj = true;
                dtVar.epi = true;
                dtVar.epo = aKy.sk() == 1;
                dtVar.epn = aKy.sl() == 1;
            } else {
                dtVar.epj = false;
                dtVar.epi = false;
            }
            dtVar.eph = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteShareActivityConfig.class);
            dtVar.epf = TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            dtVar.epk = it(equals);
            dtVar.epl = aLy();
            dtVar.epm = iu(equals);
            dtVar.epg = this.ekv.aMD();
            dtVar.eiR = this.dHE != null ? this.dHE.oe() : false;
            dtVar.epe = is(equals);
            dtVar.epc = equals && this.eli.aOv();
            dtVar.epd = z;
            dtVar.isHostOnly = this.ekv.getHostMode();
            if (aKy.sF() == null) {
                dtVar.epp = false;
            } else {
                dtVar.epp = true;
            }
            this.eli.erm.a(dtVar);
        }
    }

    private boolean aLy() {
        if (this.ekv != null && this.ekv.aMD()) {
            return this.ekv.amV() == null || this.ekv.amV().ro() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(View view) {
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
        if (fVar != null && this.ekv != null) {
            eg egVar = new eg(getUniqueId());
            egVar.pbData = fVar;
            egVar.threadId = this.ekv.getThreadID();
            egVar.postId = this.ekv.getPostId();
            egVar.eqs = i;
            egVar.eqt = i2;
            egVar.eqr = this.ekv.getHostMode();
            egVar.eiR = this.ekv.oe();
            egVar.isSquence = this.ekv.aMD();
            egVar.loadType = this.ekv.aMZ();
            egVar.equ = z;
            egVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, egVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, boolean z2) {
        if (fVar != null && this.ekv != null) {
            eg egVar = new eg(getUniqueId());
            egVar.pbData = fVar;
            egVar.threadId = this.ekv.getThreadID();
            egVar.postId = this.ekv.getPostId();
            egVar.eqs = i;
            egVar.eqr = this.ekv.getHostMode();
            egVar.eiR = this.ekv.oe();
            egVar.isSquence = this.ekv.aMD();
            egVar.loadType = this.ekv.aMZ();
            egVar.equ = z;
            egVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, egVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        axq();
    }

    public void a(boolean z, MarkData markData) {
        this.eli.aOo();
        this.ekv.iA(z);
        if (this.dHE != null) {
            this.dHE.ae(z);
            if (markData != null) {
                this.dHE.a(markData);
            }
        }
        if (this.ekv.oe()) {
            aLE();
        } else {
            this.eli.k(this.ekv.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oh(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nw(String str) {
        if (!StringUtils.isNull(str) && this.ekv != null) {
            String threadID = this.ekv.getThreadID();
            String id = this.ekv.getPbData().aKx().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(w.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.ekv.aMI()) {
                    antiData.setBlock_forum_name(this.ekv.getPbData().aKx().getName());
                    antiData.setBlock_forum_id(this.ekv.getPbData().aKx().getId());
                    antiData.setUser_name(this.ekv.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.ekv.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.sd(i)) {
            AntiHelper.aq(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            fD(str);
        } else {
            this.eli.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.eli.a(0, bVar.AM, bVar.fAq, z);
            if (bVar.AM) {
                if (bVar.fAo == 1) {
                    ArrayList<PostData> aKA = this.ekv.getPbData().aKA();
                    int size = aKA.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aKA.get(i).getId())) {
                            i++;
                        } else {
                            aKA.remove(i);
                            break;
                        }
                    }
                    this.eli.k(this.ekv.getPbData());
                } else if (bVar.fAo == 0) {
                    aLz();
                } else if (bVar.fAo == 2) {
                    ArrayList<PostData> aKA2 = this.ekv.getPbData().aKA();
                    int size2 = aKA2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aKA2.get(i2).bjm().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aKA2.get(i2).bjm().get(i3).getId())) {
                                i3++;
                            } else {
                                aKA2.get(i2).bjm().remove(i3);
                                aKA2.get(i2).bjo();
                                z2 = true;
                                break;
                            }
                        }
                        aKA2.get(i2).qe(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.eli.k(this.ekv.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.f fVar) {
        if (fVar != null) {
            this.eli.a(this.elh.getLoadDataMode(), fVar.AM, fVar.fAq, false);
            if (fVar.AM) {
                this.elk = true;
                if (i == 2 || i == 3) {
                    this.ell = true;
                    this.elm = false;
                } else if (i == 4 || i == 5) {
                    this.ell = false;
                    this.elm = true;
                }
                if (i == 2) {
                    this.ekv.getPbData().aKy().bU(1);
                    this.ekv.setIsGood(1);
                } else if (i == 3) {
                    this.ekv.getPbData().aKy().bU(0);
                    this.ekv.setIsGood(0);
                } else if (i == 4) {
                    this.ekv.getPbData().aKy().bT(1);
                    this.ekv.hb(1);
                } else if (i == 5) {
                    this.ekv.getPbData().aKy().bT(0);
                    this.ekv.hb(0);
                }
                this.eli.d(this.ekv.getPbData(), this.ekv.aMD());
                com.baidu.tieba.c.a.a(getPageContext(), 2, i);
            }
        }
    }

    private void aLz() {
        if (this.ekv.aME() || this.ekv.aMF()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.ekv.getThreadID());
            setResult(-1, intent);
        }
        if (aLF()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLA() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aKG;
        if (this.eli != null) {
            this.eli.axI();
        }
        if (this.ekv != null && this.ekv.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.ekv.getPbData().aKy().getId();
            historyMessage.forumName = this.ekv.getPbData().aKx().getName();
            historyMessage.threadName = this.ekv.getPbData().aKy().getTitle();
            ArrayList<PostData> aKA = this.ekv.getPbData().aKA();
            int aOq = this.eli != null ? this.eli.aOq() : 0;
            if (aKA != null && aOq >= 0 && aOq < aKA.size()) {
                historyMessage.postID = aKA.get(aOq).getId();
            }
            historyMessage.isHostOnly = this.ekv.getHostMode();
            historyMessage.isSquence = this.ekv.aMD();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.elu != null) {
            this.elu.onDestroy();
        }
        if (this.ekv != null && (this.ekv.aME() || this.ekv.aMF() || this.ekv.aMG())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.ekv.getThreadID());
            if (this.elk) {
                if (this.elm) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.ekv.axz());
                }
                if (this.ell) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.ekv.getIsGood());
                }
            }
            if (this.ekv.getPbData() != null && System.currentTimeMillis() - this.ekT >= 40000 && (aKG = this.ekv.getPbData().aKG()) != null && !com.baidu.tbadk.core.util.x.q(aKG.getDataList())) {
                intent.putExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA, aKG);
                intent.putExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, this.elB);
            }
            setResult(-1, intent);
        }
        if (aLF()) {
            if (this.ekv != null && this.eli != null && this.eli.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.ekv.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.m9getInst().getDefaultBubble());
                    }
                    if (!pbData.aKF() && !this.elb) {
                        ep.aNL().a(this.ekv.getPbData(), this.eli.getListView().onSaveInstanceState(), this.ekv.aMD(), this.ekv.getHostMode());
                    }
                }
            } else {
                ep.aNL().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.eli == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.eli.oz(i)) {
            return true;
        }
        switch (i) {
            case 4:
                if (this.eli.aMw()) {
                    this.eli.aMy();
                    return true;
                }
                return super.onKeyDown(i, keyEvent);
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oi(int i) {
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
        this.elu.onActivityResult(i, i2, intent);
        if (aLr().aNT() != null) {
            aLr().aNT().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aLD();
                    return;
                case 13008:
                    ep.aNL().reset();
                    this.mHandler.postDelayed(new be(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.ekv != null) {
                        a(aLC(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    R(intent);
                    return;
                case 24006:
                    Q(intent);
                    return;
                case 24007:
                    if (aLw() == 1) {
                        aLB();
                        return;
                    }
                    return;
                case 24008:
                    this.eli.ip(false);
                    if (this.ekv.getPbData() != null && this.ekv.getPbData().aKy() != null && this.ekv.getPbData().aKy().sI() != null) {
                        this.ekv.getPbData().aKy().sI().setStatus(2);
                        break;
                    }
                    break;
                case 25001:
                    break;
                default:
                    return;
            }
            if (this.ela != null) {
                this.ela.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aLr() != null && aLn() != null && aLr().aNV() && com.baidu.tbadk.editortools.pb.a.DK().getStatus() == 1) {
                    com.baidu.tbadk.editortools.pb.a.DK().setStatus(0);
                    if (this.eli != null) {
                        this.eli.aNU();
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
    public void aLB() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.ekv.getPbData() != null && this.ekv.getPbData().aKy() != null && this.ekv.getPbData().aKy().sz() != null && this.ekv.getPbData().aKy().sz().size() > 0 && this.ekv.getPbData().aKy().sz().get(0) != null) {
            this.mAwardActId = this.ekv.getPbData().aKy().sz().get(0).pJ();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.ekv.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void Q(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra(GetLotteryChanceActivityConfig.KEY_ACTION, 0)) {
                case 1:
                    arR();
                    return;
                case 2:
                    this.eli.aOf();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aLC() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bD = this.ekv.getPbData().bD(getPageContext().getPageActivity());
        PostData aNW = this.eli.aNW();
        String str = "";
        if (aNW != null) {
            str = aNW.getId();
            String bN = aNW.bN(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(bN)) {
                bD[1] = bN;
            }
        }
        String sE = this.ekv.getPbData().aKy().sE();
        if (sE != null && sE.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bD[1]);
        shareFromPBMsgData.setImageUrl(bD[0]);
        shareFromPBMsgData.setForumName(this.ekv.getPbData().aKx().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.ekv.getPbData().aKy().getId());
        shareFromPBMsgData.setTitle(this.ekv.getPbData().aKy().getTitle());
        return shareFromPBMsgData;
    }

    private void R(Intent intent) {
        a(aLC(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.ekv != null && this.ekv.getPbData() != null && this.ekv.getPbData().aKy() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gq gqVar = new gq(getPageContext().getPageActivity());
            gqVar.setData(shareFromPBMsgData);
            aVar.cb(1);
            aVar.v(gqVar);
            aVar.a(w.l.share, new bf(this, gqVar, j, str, str2, shareFromPBMsgData));
            aVar.b(w.l.alert_no_button, new bg(this, gqVar));
            aVar.aw(true);
            aVar.b(getPageContext()).tQ();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                gqVar.G(shareFromPBMsgData.getImageUrl(), this.ekv.getPbData().aKJ() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.ekv != null && this.ekv.getPbData() != null && this.ekv.getPbData().aKy() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gq gqVar = new gq(getPageContext().getPageActivity());
            gqVar.setData(shareFromPBMsgData);
            aVar.cb(1);
            aVar.v(gqVar);
            aVar.a(w.l.share, new bh(this, gqVar, i, str, j, shareFromPBMsgData));
            aVar.b(w.l.alert_no_button, new bi(this, gqVar));
            aVar.aw(true);
            aVar.b(getPageContext()).tQ();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                gqVar.G(shareFromPBMsgData.getImageUrl(), this.ekv.getPbData().aKJ() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLD() {
        MarkData ot;
        if (this.dHE != null && (ot = this.ekv.ot(this.eli.aOr())) != null) {
            if (!ot.isApp() || (ot = this.ekv.ot(this.eli.aOr() + 1)) != null) {
                this.eli.aOm();
                this.dHE.a(ot);
                if (!this.dHE.oe()) {
                    this.dHE.og();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.dHE.of();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLE() {
        com.baidu.tieba.pb.data.f pbData = this.ekv.getPbData();
        this.ekv.iA(true);
        pbData.ns(this.dHE.od());
        this.eli.k(pbData);
    }

    private boolean aLF() {
        if (this.ekv == null) {
            return true;
        }
        if (this.ekv.oe()) {
            MarkData aMQ = this.ekv.aMQ();
            if (aMQ == null || !this.ekv.getIsFromMark()) {
                return true;
            }
            MarkData ot = this.ekv.ot(this.eli.aOr());
            if (ot == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aMQ);
                setResult(-1, intent);
                return true;
            } else if (ot.getPostId() == null || ot.getPostId().equals(aMQ.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aMQ);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cE(String.format(getPageContext().getString(w.l.alert_update_mark), Integer.valueOf(ot.getFloor())));
                aVar.a(w.l.confirm, new bj(this, ot, aMQ, aVar));
                aVar.b(w.l.alert_no_button, new bk(this, aMQ, aVar));
                aVar.a(new bm(this, aMQ, aVar));
                aVar.b(getPageContext());
                aVar.tQ();
                return false;
            }
        } else if (this.ekv.getPbData() == null || this.ekv.getPbData().aKA() == null || this.ekv.getPbData().aKA().size() <= 0 || !this.ekv.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.eli == null) {
            return null;
        }
        return this.eli.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int IR() {
        if (this.eli == null) {
            return 0;
        }
        return this.eli.aOy();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> IS() {
        if (this.aNs == null) {
            this.aNs = new com.baidu.adp.lib.e.b<>(new bn(this), 8, 0);
        }
        return this.aNs;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> IT() {
        if (this.aNt == null) {
            this.aNt = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aNt;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> IU() {
        if (this.aNx == null) {
            this.aNx = new com.baidu.adp.lib.e.b<>(new bo(this), 20, 0);
        }
        return this.aNx;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IV() {
        if (this.aNv == null) {
            this.aNv = new com.baidu.adp.lib.e.b<>(new bp(this), 8, 0);
        }
        return this.aNv;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IX() {
        if (this.aNu == null) {
            this.aNu = com.baidu.tieba.graffiti.d.o(getPageContext().getPageActivity(), 6);
        }
        return this.aNu;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xt() {
        if (this.amf == null) {
            this.amf = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.amf;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Y(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.ekY = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        if (gr.nK(str) && this.ekv != null && this.ekv.getThreadID() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11664").s("obj_param1", 1).aa("post_id", this.ekv.getThreadID()));
        }
        gr.aOU().g(getPageContext(), str);
        this.ekY = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        gr.aOU().g(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.ekY = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ac(Context context, String str) {
        com.baidu.tbadk.core.util.bb.wn().c(getPageContext(), new String[]{str});
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.ekY = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ab(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        TbRichTextData tbRichTextData;
        int a2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.ekv.getPbData();
            TbRichText am = am(str, i);
            if (am != null && (tbRichTextData = am.Io().get(this.elY)) != null) {
                bVar.emB = new ArrayList<>();
                bVar.emC = new ConcurrentHashMap<>();
                if (!tbRichTextData.Iu().IG()) {
                    bVar.emE = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    bVar.emB.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.postId = am.getPostId();
                    imageUrlData.mIsReserver = this.ekv.aMP();
                    imageUrlData.mIsSeeHost = this.ekv.getHostMode();
                    bVar.emC.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aKx() != null) {
                            bVar.forumName = pbData.aKx().getName();
                            bVar.forumId = pbData.aKx().getId();
                        }
                        if (pbData.aKy() != null) {
                            bVar.threadId = pbData.aKy().getId();
                        }
                        bVar.emD = pbData.aKJ() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.emE = true;
                int size = pbData.aKA().size();
                this.elZ = false;
                bVar.index = -1;
                int i2 = 0;
                int i3 = i;
                while (i2 < size) {
                    PostData postData = pbData.aKA().get(i2);
                    TbRichText axm = postData.axm();
                    if (!ex.g(postData)) {
                        a2 = a(axm, am, i3, i, bVar.emB, bVar.emC);
                    } else {
                        a2 = a(postData, i3, bVar.emB, bVar.emC);
                    }
                    i2++;
                    i3 = a2;
                }
                if (bVar.emB.size() > 0) {
                    bVar.lastId = bVar.emB.get(bVar.emB.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aKx() != null) {
                        bVar.forumName = pbData.aKx().getName();
                        bVar.forumId = pbData.aKx().getId();
                    }
                    if (pbData.aKy() != null) {
                        bVar.threadId = pbData.aKy().getId();
                    }
                    bVar.emD = pbData.aKJ() == 1;
                }
                bVar.index = i3;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Iu() == null) {
            return null;
        }
        return tbRichTextData.Iu().IK();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Iu() == null) {
            return 0L;
        }
        return tbRichTextData.Iu().getOriginalSize();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo Iu;
        if (tbRichText == tbRichText2) {
            this.elZ = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.Io().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Io().get(i6) == null || tbRichText.Io().get(i6).getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int width = tbRichText.Io().get(i6).Iu().getWidth();
                    int height = tbRichText.Io().get(i6).Iu().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Io().get(i6).Iu().IG()) {
                        if (tbRichText == tbRichText2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Io().get(i6);
                        String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                        if (!TextUtils.isEmpty(c2)) {
                            arrayList.add(c2);
                            if (tbRichTextData != null && (Iu = tbRichTextData.Iu()) != null) {
                                String II = Iu.II();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = II;
                                imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.ekv.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.ekv.aMP();
                                imageUrlData.mIsSeeHost = this.ekv.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.elZ) {
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
        com.baidu.tieba.tbadkCore.data.h bjx;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> biR;
        if (postData != null && arrayList != null && concurrentHashMap != null && (biR = (bjx = postData.bjx()).biR()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == biR.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = biR.get(i3);
                if (jVar != null) {
                    String biY = jVar.biY();
                    if (!com.baidu.tbadk.core.util.au.isEmpty(biY)) {
                        arrayList.add(biY);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = biY;
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        imageUrlData.originalUrl = jVar.biW();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.ekv.getThreadID(), -1L);
                        imageUrlData.mIsReserver = this.ekv.aMP();
                        imageUrlData.mIsSeeHost = this.ekv.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bjx.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(biY, imageUrlData);
                        }
                        if (!this.elZ) {
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
            if (postData.getId() != null && postData.getId().equals(this.ekv.sx())) {
                z = true;
            }
            MarkData e = this.ekv.e(postData);
            if (e != null) {
                this.eli.aOm();
                if (this.dHE != null) {
                    this.dHE.a(e);
                    if (!z) {
                        this.dHE.og();
                    } else {
                        this.dHE.of();
                    }
                }
            }
        }
    }

    private TbRichText am(String str, int i) {
        if (this.ekv == null || this.ekv.getPbData() == null || str == null || i < 0) {
            return null;
        }
        return a(this.ekv.getPbData().aKA(), str, i);
    }

    private long nx(String str) {
        ArrayList<PostData> aKA;
        com.baidu.tieba.pb.data.f pbData = this.ekv.getPbData();
        if (pbData != null && (aKA = pbData.aKA()) != null && !aKA.isEmpty()) {
            Iterator<PostData> it = aKA.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bjx = next.bjx();
                if (bjx != null && bjx.fxO) {
                    Iterator<TbRichTextData> it2 = next.axm().Io().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.IC().getLink().equals(str)) {
                            return bjx.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> Io;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText axm = arrayList.get(i2).axm();
            if (axm != null && (Io = axm.Io()) != null) {
                int size = Io.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Io.get(i4) != null && Io.get(i4).getType() == 8) {
                        i3++;
                        if (Io.get(i4).Iu().II().equals(str)) {
                            int width = Io.get(i4).Iu().getWidth();
                            int height = Io.get(i4).Iu().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.elY = i4;
                            return axm;
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
            this.ekt = str;
            if (this.ekS == null) {
                aLu();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.ekS.cg(1).setVisibility(8);
            } else {
                this.ekS.cg(1).setVisibility(0);
            }
            this.ekS.tT();
            this.ekY = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bOT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axq() {
        hideNetRefreshView(this.eli.getView());
        aLG();
        if (this.ekv.FC()) {
            this.eli.aOm();
        }
    }

    private void aLG() {
        showLoadingView(this.eli.getView(), false, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds400));
        View EZ = getLoadingView().EZ();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EZ.getLayoutParams();
        layoutParams.addRule(3, this.eli.aOL().getId());
        EZ.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaq() {
        if (this.bOT != null) {
            this.bOT.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arR() {
        if (this.ekv.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.ekv.getPbData();
            String name = pbData.aKx().getName();
            String title = pbData.aKy().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.ekv.getThreadID() + "?share=9105&fr=share&see_lz=" + (this.ekv.getHostMode() ? 1 : 0);
            String[] bD = pbData.bD(getPageContext().getPageActivity());
            String str2 = bD[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = bD[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (aLw() == 1) {
                if (pbData != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10399").aa("fid", pbData.getForumId()).aa("tid", pbData.getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
                }
            } else if (aLw() == 2 && pbData != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10406").aa("fid", pbData.getForumId()).aa("tid", pbData.getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(w.l.share_content_tpl), title, name, str3);
            com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
            hVar.title = title;
            hVar.content = format;
            hVar.linkUrl = str;
            hVar.asg = true;
            hVar.extData = this.ekv.getThreadID();
            if (parse != null) {
                hVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), hVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(w.l.forum_friend, w.g.icon_unite_share_baf, new bq(this));
            shareDialogConfig.setCopyLinkListener(new br(this, hVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> IW() {
        if (this.aNw == null) {
            this.aNw = new com.baidu.adp.lib.e.b<>(new bs(this), 15, 0);
        }
        return this.aNw;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.eli.aOg() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10517").s("obj_locate", 2).aa("fid", this.ekv.getPbData().getForumId()));
            } else {
                com.baidu.tbadk.core.data.bi aKy = this.ekv.getPbData().aKy();
                if (view != null) {
                    boolean z = aKy.se() == null || aKy.se().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.elJ > 1000) {
                            this.elK = true;
                            aX(view);
                        } else {
                            this.elK = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            e(view, this.elK);
                        } else {
                            d(view, this.elK);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        d(view, this.elK);
                    } else if (motionEvent.getAction() == 3) {
                        d(view, this.elK);
                    }
                }
            }
        }
        return false;
    }

    private void d(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.praise_animation_scale2));
            new Handler().postDelayed(new bt(this), 200L);
        }
    }

    private void e(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.praise_animation_scale3));
            new Handler().postDelayed(new bv(this), 600L);
        }
    }

    private void aX(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void aar() {
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
        } else if (aVar.tS() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.tS();
            int intValue = ((Integer) sparseArray.get(ey.esX)).intValue();
            if (intValue == ey.esY) {
                if (!this.elh.bkb()) {
                    this.eli.aOj();
                    int intValue2 = ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue();
                    this.elh.a(this.ekv.getPbData().aKx().getId(), this.ekv.getPbData().aKx().getName(), this.ekv.getPbData().aKy().getId(), (String) sparseArray.get(w.h.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == ey.esZ || intValue == ey.etb) {
                if (this.ekv.aNc() != null) {
                    this.ekv.aNc().om(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ey.esZ) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == ey.eta) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.emd).pE()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.elz);
        userMuteAddAndDelCustomMessage.setTag(this.elz);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean ny(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bg.aK(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.uL().getString("bubble_link", ""))) {
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

    public void iv(boolean z) {
        this.els = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aLH() {
        ArrayList<PostData> aKA;
        int p;
        if (this.ekv == null || this.ekv.getPbData() == null || this.ekv.getPbData().aKA() == null || (p = com.baidu.tbadk.core.util.x.p((aKA = this.ekv.getPbData().aKA()))) == 0) {
            return "";
        }
        int aOq = this.eli.aOq();
        PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(aKA, aOq);
        if (postData == null || postData.getAuthor() == null) {
            return "";
        }
        if (this.ekv.nC(postData.getAuthor().getUserId())) {
            return postData.getId();
        }
        for (int i = aOq - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.x.c(aKA, i);
            if (postData2 == null || postData2.getAuthor() == null || postData2.getAuthor().getUserId() == null) {
                break;
            } else if (this.ekv.nC(postData2.getAuthor().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = aOq + 1; i2 < p; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.x.c(aKA, i2);
            if (postData3 == null || postData3.getAuthor() == null || postData3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.ekv.nC(postData3.getAuthor().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ad(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.bb.wn().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.b.a(nx(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.ekv.getPbData().aKx().getId(), this.ekv.getPbData().aKx().getName(), this.ekv.getPbData().aKy().getTid());
            }
            this.ekY = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, String str2, String str3, String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cE(getResources().getString(w.l.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cE(getResources().getString(w.l.make_sure_hide));
        }
        aVar.a(getResources().getString(w.l.alert_yes_button), new bw(this, j, str, str2, str3, str4));
        aVar.b(getResources().getString(w.l.alert_no_button), new bx(this, j, str, str2, str3, str4));
        aVar.aw(false);
        aVar.b(getPageContext());
        aVar.tQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b nz(String str) {
        String str2;
        if (this.ekv.getPbData() == null || this.ekv.getPbData().aKA() == null || this.ekv.getPbData().aKA().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i < this.ekv.getPbData().aKA().size()) {
                if (str.equals(this.ekv.getPbData().aKA().get(i).getId())) {
                    break;
                }
                i++;
            } else {
                i = 0;
                break;
            }
        }
        PostData postData = this.ekv.getPbData().aKA().get(i);
        if (postData.axm() == null || postData.axm().Io() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.axm().Io().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.Iu() != null) {
                    str2 = next.Iu().II();
                }
            }
        }
        a(str2, 0, bVar);
        com.baidu.tieba.pb.data.g.a(postData, bVar);
        return bVar;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.ekP) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.ekP = false;
        } else if (aLI()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.ekP) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.ekP = false;
        } else if (aLI()) {
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
        if (pageStayDurationItem != null && this.ekv != null) {
            if (this.ekv.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.ekv.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.ekv.getThreadID(), 0L));
            if (this.ekZ) {
                pageStayDurationItem.objParam1 = "1";
            }
        }
        return pageStayDurationItem;
    }

    public boolean aLI() {
        return (!this.ekN && this.emf == -1 && this.emg == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.emi = nVar;
            this.ekN = true;
            this.eli.aNX();
            this.eli.nI(this.emh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLJ() {
        if (this.emi != null) {
            if (this.emf == -1) {
                showToast(w.l.pb_manga_not_prev_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.emi.getCartoonId(), this.emf, 0)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLK() {
        if (this.emi != null) {
            if (this.emg == -1) {
                showToast(w.l.pb_manga_not_next_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.emi.getCartoonId(), this.emg, 0)));
            finish();
        }
    }

    public int aLL() {
        return this.emf;
    }

    public int aLM() {
        return this.emg;
    }

    private void ams() {
        if (this.ekv != null && this.ekv.getPbData() != null && this.ekv.getPbData().aKy() != null && this.ekv.getPbData().aKy().tb()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aLN() {
        if (this.ekv != null && this.ekv.getPbData() != null && this.ekv.getPbData().aKy() != null && this.ekv.getPbData().aKy().tb()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aLO() {
        if (this.ekQ) {
            this.elf = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.ekv.getPbData() != null && this.ekv.getPbData().aKy() != null && this.ekv.getPbData().aKy().rX() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.ekv.getPbData().aKy().rX().getThreadId(), this.ekv.getPbData().aKy().rX().getTaskId(), this.ekv.getPbData().aKy().rX().getForumId(), this.ekv.getPbData().aKy().rX().getForumName(), this.ekv.getPbData().aKy().sk(), this.ekv.getPbData().aKy().sl())));
            this.ekP = true;
            finish();
        }
    }

    public boolean aLP() {
        return this.ekQ;
    }

    public String aLQ() {
        return this.eld;
    }

    public PbInterviewStatusView.a aLR() {
        return this.elg;
    }

    public void iw(boolean z) {
        this.ele = z;
    }

    public boolean aLS() {
        if (this.ekv != null) {
            return this.ekv.aME();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLT() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cE(getResources().getString(w.l.mute_is_super_member_function));
        aVar.a(w.l.open_now, new by(this));
        aVar.b(w.l.cancel, new bz(this));
        aVar.b(this.elx).tQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD(String str) {
        if (str == null) {
            str = "";
        }
        if (this.elx != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.elx.getPageActivity());
            aVar.cE(str);
            aVar.b(w.l.know, new ca(this));
            aVar.b(this.elx).tQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eli.avw();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.elx.getPageActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.cE(this.elx.getResources().getString(w.l.block_mute_message_alert, str2));
        } else {
            aVar.cE(str);
        }
        aVar.a(w.l.confirm, new cb(this, userMuteAddAndDelCustomMessage));
        aVar.b(w.l.cancel, new cc(this));
        aVar.b(this.elx).tQ();
    }

    public void aLU() {
        if (this.ekv != null && this.ekv.getPbData() != null && this.ekv.getPbData().aKy() != null && this.ekv.getPbData().aKy().ts() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bZ(w.l.channel_open_push_message);
            aVar.a(w.l.need_channel_push, new cd(this));
            aVar.b(w.l.not_need_channel_push, new ce(this));
            aVar.b(getPageContext());
            aVar.tQ();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.b
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.b[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.b.class);
            for (int i = 0; i < objArr.length; i++) {
                if (gr.nK(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_pb_wenxue)) != null) {
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
            this.elc = true;
        } else {
            this.elc = false;
        }
        if (this.eli != null) {
            this.eli.onConfigurationChanged(configuration);
        }
        if (this.eln != null) {
            this.eln.dismiss();
        }
    }
}
