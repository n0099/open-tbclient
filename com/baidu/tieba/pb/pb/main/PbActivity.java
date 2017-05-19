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
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.a.f;
import com.baidu.tieba.pb.pb.main.da;
import com.baidu.tieba.pb.pb.main.di;
import com.baidu.tieba.pb.pb.main.ee;
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
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.b, com.baidu.tbadk.widget.richText.d {
    private com.baidu.adp.lib.e.b<ImageView> aNK;
    private com.baidu.adp.lib.e.b<TextView> aNL;
    private com.baidu.adp.lib.e.b<View> aNM;
    private com.baidu.adp.lib.e.b<View> aNN;
    private com.baidu.adp.lib.e.b<LinearLayout> aNO;
    private com.baidu.adp.lib.e.b<GifView> aNP;
    private com.baidu.adp.lib.e.b<TbImageView> amv;
    private com.baidu.tbadk.h.a bOH;
    private VoiceManager bOm;
    private com.baidu.tieba.e.c bRf;
    private String efC;
    private com.baidu.tieba.pb.pb.main.a.f efX;
    private boolean egD;
    private com.baidu.tieba.tbadkCore.data.e egF;
    private com.baidu.tbadk.editortools.pb.c egG;
    private com.baidu.adp.base.g egJ;
    private com.baidu.tbadk.core.view.h egK;
    private BdUniqueId egL;
    private Runnable egM;
    private com.baidu.tbadk.core.dialog.a egd;
    private boolean egk;
    private com.baidu.tieba.pb.pb.main.b egl;
    private ec egy;
    private boolean ehk;
    private String ehv;
    private com.baidu.tbadk.core.data.n ehw;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean efW = false;
    private boolean efY = false;
    private boolean efZ = false;
    private boolean dFR = false;
    private boolean ega = true;
    private int egb = 0;
    private com.baidu.tbadk.core.dialog.c egc = null;
    private long bGR = -1;
    private long aGK = 0;
    private long ege = 0;
    private long createTime = 0;
    private long aGC = 0;
    private boolean egf = false;
    private com.baidu.tbadk.j.e egg = null;
    private long egh = 0;
    private boolean egi = false;
    private boolean egj = false;
    private String aAU = null;
    private boolean egm = false;
    private boolean egn = false;
    private String ego = "";
    private boolean egp = true;
    private boolean egq = false;
    private String source = "";
    private PbInterviewStatusView.a egr = new i(this);
    private final Handler mHandler = new Handler(new t(this));
    private PbModel efE = null;
    private com.baidu.tbadk.baseEditMark.a dCb = null;
    private ForumManageModel egs = null;
    private fm egt = null;
    public final com.baidu.tieba.pb.pb.main.a.a egu = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean egv = false;
    private boolean egw = false;
    private boolean egx = false;
    private boolean egz = false;
    private boolean egA = false;
    private boolean egB = false;
    private boolean egC = false;
    private boolean egE = false;
    private boolean egH = false;
    private com.baidu.tbadk.editortools.pb.b aAY = new ae(this);
    private boolean egI = false;
    private int cyd = -1;
    private int egN = 4;
    private int egO = -1;
    private final ee.a egP = new ap(this);
    private final CustomMessageListener egQ = new ba(this, CmdConfigCustom.PB_RESET_EDITOR_TOOL);
    CustomMessageListener bPc = new bl(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private CustomMessageListener egR = new bv(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener dkY = new cf(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener dlv = new cj(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener egS = new j(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener aOF = new k(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
    private CustomMessageListener cKX = new l(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private da.a egT = new m(this);
    private View.OnClickListener dkX = new n(this);
    private CustomMessageListener egU = new o(this, CmdConfigCustom.CMD_SEND_GIFT_SUCCESS);
    private boolean egV = false;
    private PraiseModel egW = new PraiseModel(getPageContext(), new p(this));
    private long egX = 0;
    private boolean egY = true;
    private f.a egZ = new q(this);
    private CustomMessageListener bax = new r(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener eha = new s(this, CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED);
    private com.baidu.tieba.pb.a.d eeF = new com.baidu.tieba.pb.a.d(new u(this));
    private CustomMessageListener ehb = new v(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener ehc = new w(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener ehd = new x(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    public a.b dPZ = new y(this);
    public final View.OnClickListener bPI = new z(this);
    private final NewWriteModel.d aBf = new aa(this);
    private final PbModel.a ehe = new ab(this);
    private CustomMessageListener ehf = new ac(this, CmdConfigCustom.CMD_WX_SHARE_SUCCESS);
    private CustomMessageListener ehg = new ad(this, CmdConfigCustom.CMD_TTS_OPTION_PB);
    private final a.InterfaceC0033a ehh = new af(this);
    private final AbsListView.OnScrollListener mOnScrollListener = new ag(this);
    private final com.baidu.adp.base.f ehi = new ah(this);
    private final c ehj = new ai(this);
    private final ae.b aYZ = new aj(this);
    private final BdListView.e ehl = new ak(this);
    private int ehm = 0;
    private final TbRichTextView.e aOe = new al(this);
    boolean ehn = false;
    PostData eho = null;
    private final c.b ehp = new am(this);
    private final View.OnLongClickListener atr = new an(this);
    private final NoNetworkView.a bNr = new ao(this);
    public View.OnTouchListener aJt = new aq(this);
    private a.InterfaceC0059a aRJ = new ar(this);
    private final c.a ehq = new as(this);
    private String ehr = null;
    private final di.a ehs = new at(this);
    private int eht = -1;
    private int ehu = -1;
    private CustomMessageListener ehx = new au(this, CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST);
    private final CustomMessageListener bPg = new av(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> ehP;
        public ConcurrentHashMap<String, ImageUrlData> ehQ;
        public boolean ehS;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean ehR = false;
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

    public com.baidu.tbadk.editortools.pb.c aII() {
        return this.egG;
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        if (lVar.aIr() != null) {
            String id = lVar.aIr().getId();
            ArrayList<PostData> aHI = this.efE.getPbData().aHI();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aHI.size()) {
                    break;
                }
                PostData postData = aHI.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aIv = lVar.aIv();
                    postData.rP(lVar.getTotalCount());
                    if (postData.bgJ() != null) {
                        postData.bgJ().clear();
                        postData.bgJ().addAll(aIv);
                    }
                }
            }
            this.egt.l(this.efE.getPbData());
            c(lVar);
        }
    }

    public void aIJ() {
        com.baidu.tieba.pb.data.f pbData;
        com.baidu.tbadk.core.data.bk aHG;
        if (!this.egV) {
            if (!com.baidu.adp.lib.util.k.hB()) {
                showToast(w.l.no_network_guide);
            } else if (this.egY) {
                this.egV = true;
                if (this.efE != null && (pbData = this.efE.getPbData()) != null && (aHG = pbData.aHG()) != null) {
                    int isLike = aHG.ro() == null ? 0 : aHG.ro().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10796").aa("tid", aHG.getId()));
                    }
                    if (this.egW != null) {
                        this.egW.a(aHG.rO(), aHG.getId(), isLike, "pb");
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
                cVar.ca(w.l.operation);
                int i = -1;
                if (sparseArray.get(w.h.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(w.h.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(w.l.delete);
                    strArr[1] = z ? getResources().getString(w.l.un_mute) : getResources().getString(w.l.mute);
                    cVar.a(strArr, new aw(this, sparseArray, z, str2, str));
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(w.l.un_mute) : getResources().getString(w.l.mute);
                    cVar.a(strArr2, new ax(this, sparseArray, z, str2, str));
                }
                cVar.d(getPageContext()).tg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ie(int i) {
        com.baidu.tbadk.core.data.bk aHG;
        String sb;
        String x;
        if (this.efE != null && this.efE.getPbData() != null && (aHG = this.efE.getPbData().aHG()) != null) {
            if (i == 1) {
                PraiseData ro = aHG.ro();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (ro == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aHG.a(praiseData);
                    } else {
                        aHG.ro().getUser().add(0, metaData);
                        aHG.ro().setNum(aHG.ro().getNum() + 1);
                        aHG.ro().setIsLike(i);
                    }
                }
                if (aHG.ro() != null) {
                    if (aHG.ro().getNum() < 1) {
                        x = getResources().getString(w.l.frs_item_praise_text);
                    } else {
                        x = com.baidu.tbadk.core.util.au.x(aHG.ro().getNum());
                    }
                    this.egt.P(x, true);
                }
            } else if (aHG.ro() != null) {
                aHG.ro().setIsLike(i);
                aHG.ro().setNum(aHG.ro().getNum() - 1);
                ArrayList<MetaData> user = aHG.ro().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aHG.ro().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aHG.ro().getNum() < 1) {
                    sb = getResources().getString(w.l.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(aHG.ro().getNum())).toString();
                }
                this.egt.P(sb, false);
            }
            if (this.efE.aJT()) {
                this.egt.aLy().notifyDataSetChanged();
            } else {
                this.egt.m(this.efE.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apW && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        if (this.efE != null && this.efE.getPbData() != null && this.egt != null) {
            this.egt.d(this.efE.getPbData(), this.efE.aJT(), this.efE.aKj());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bOH == null) {
                this.bOH = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.bOH.ao(updateAttentionMessage.getData().toUid, this.efE.getPbData().getForumId());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.efE.p(bundle);
        if (this.bOm != null) {
            this.bOm.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.egG.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.egJ = getPageContext();
        Intent intent = getIntent();
        if (intent != null) {
            this.bGR = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.ego = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.ego)) {
                this.efY = true;
            }
            this.eht = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.ehu = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.ehv = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            this.egA = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
            this.egE = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_GOD_REPLY, false);
            if (aJf()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.au.isEmpty(this.source) ? "" : this.source;
            this.egO = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            this.egk = intent.getBooleanExtra("is_from_push", false);
        } else {
            this.bGR = System.currentTimeMillis();
        }
        this.ege = System.currentTimeMillis();
        this.aGC = this.ege - this.bGR;
        super.onCreate(bundle);
        this.egb = 0;
        r(bundle);
        if (this.efE != null && this.efE.getPbData() != null) {
            this.efE.getPbData().nz(this.source);
        }
        initUI();
        if (intent != null && this.egt != null) {
            this.egt.emE = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
            if (!StringUtils.isNull(intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME))) {
                if (this.egM == null) {
                    this.egM = new ay(this, intent);
                }
                getSafeHandler().postDelayed(this.egM, 1500L);
            }
        }
        this.bOm = new VoiceManager();
        this.bOm.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.pb.l lVar = new com.baidu.tbadk.editortools.pb.l();
        lVar.setForumName(this.efE.aJS());
        if (this.efE.getPbData() != null && this.efE.getPbData().aHE() != null) {
            lVar.setForumId(this.efE.getPbData().aHE().getId());
        }
        lVar.setFrom("pb");
        lVar.a(this.efE);
        this.egG = (com.baidu.tbadk.editortools.pb.c) lVar.aQ(getActivity());
        this.egG.d(this);
        this.egG.a(this.aBf);
        this.egG.a(this.aAY);
        this.egG.a(this, bundle);
        this.egG.Cs().c(new com.baidu.tbadk.editortools.w(getActivity()));
        this.egG.Cs().bD(true);
        hR(true);
        this.egt.setEditorTools(this.egG.Cs());
        this.egG.a(this.efE.aKa(), this.efE.getThreadID(), this.efE.aKu());
        registerListener(this.dkY);
        if (!this.efE.aJX()) {
            this.egG.fu(this.efE.getThreadID());
        }
        if (this.efE.aKv()) {
            this.egG.fs(getPageContext().getString(w.l.pb_reply_hint_from_smart_frs));
        } else {
            this.egG.fs(getPageContext().getString(w.l.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.ege;
        registerListener(this.egR);
        registerListener(this.dlv);
        registerListener(this.egS);
        registerListener(this.aOF);
        registerListener(this.bPc);
        registerListener(this.egQ);
        this.egF = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.ftK);
        this.egF.bgk();
        registerListener(this.egU);
        registerListener(this.bax);
        if (this.efE != null) {
            this.efE.aKl();
        }
        if (TbadkCoreApplication.m9getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.eha);
        registerListener(this.ehg);
        registerListener(this.ehf);
        registerListener(this.ehx);
        this.egl = new com.baidu.tieba.pb.pb.main.b(this.efE, this);
        if (this.egt != null && this.egt.aLZ() != null && this.egt.aMa() != null) {
            this.efX = new com.baidu.tieba.pb.pb.main.a.f(getActivity(), this.egt.aLZ(), this.egt.aMa());
            this.efX.a(this.egZ);
        }
        if (this.efW && this.egt != null && this.egt.aMa() != null) {
            this.egt.aMa().setVisibility(8);
        }
        this.egK = new com.baidu.tbadk.core.view.h();
        this.egK.aiW = 1000L;
        registerListener(this.ehd);
        registerListener(this.ehb);
        registerListener(this.ehc);
        this.egL = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.egL;
        userMuteAddAndDelCustomMessage.setTag(this.egL);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.egL;
        userMuteCheckCustomMessage.setTag(this.egL);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public String aIK() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.f aIL() {
        return this.efX;
    }

    private void hR(boolean z) {
        this.egG.bG(z);
        this.egG.bH(z);
        this.egG.bI(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bOm != null) {
            this.bOm.onStart(getPageContext());
        }
    }

    public fm aIM() {
        return this.egt;
    }

    public PbModel aIN() {
        return this.efE;
    }

    public void nB(String str) {
        if (this.efE != null && !StringUtils.isNull(str) && this.egt != null) {
            this.egt.aLz();
            this.egt.iH(true);
            this.efE.nB(str);
            this.egm = true;
            this.egt.auE();
            this.egt.aLV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.m9getInst().isReadMenuDialogOnTop()) {
            this.efZ = false;
        } else {
            this.efZ = true;
        }
        super.onPause();
        if (this.egt.aLg() != null && this.egt.aLg().aIF() != null) {
            this.egt.aLg().aIF().onPause();
        }
        BdListView listView = getListView();
        this.egb = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.egb == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.bOm != null) {
            this.bOm.onPause(getPageContext());
        }
        if (this.egt != null) {
            this.egt.onPause();
        }
        if (!this.efE.aJX()) {
            this.egG.ft(this.efE.getThreadID());
        }
        if (this.efE != null) {
            this.efE.aKm();
        }
        MessageManager.getInstance().unRegisterListener(this.cKX);
        ajh();
        MessageManager.getInstance().unRegisterListener(this.ehb);
        MessageManager.getInstance().unRegisterListener(this.ehc);
        MessageManager.getInstance().unRegisterListener(this.ehd);
        MessageManager.getInstance().unRegisterListener(this.bPg);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aIO() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.efE.getPbData(), this.efE.aJT(), this.efE.aKj());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.efZ = false;
        super.onResume();
        if (this.egq) {
            this.egq = false;
            aJl();
        }
        if (this.egt.aLg() != null && this.egt.aLg().aIF() != null) {
            this.egt.aLg().aIF().onResume();
        }
        if (aIO()) {
            this.egh = System.currentTimeMillis();
        } else {
            this.egh = -1L;
        }
        if (this.egt != null && this.egt.getView() != null) {
            if (!this.dFR) {
                aJd();
            } else {
                hideLoadingView(this.egt.getView());
            }
            this.egt.onResume();
        }
        if (this.egb == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.egt != null) {
            noNetworkView = this.egt.aLh();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.hk()) {
            noNetworkView.aK(false);
        }
        if (this.bOm != null) {
            this.bOm.onResume(getPageContext());
        }
        registerListener(this.cKX);
        this.egD = false;
        aJk();
        registerListener(this.ehb);
        registerListener(this.ehc);
        registerListener(this.ehd);
        registerListener(this.bPg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.egt.iw(z);
        if (this.egy != null) {
            this.egy.ih(z);
        }
        if (z && this.egD) {
            this.egt.aLE();
            this.efE.ic(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.egh > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10804").aa("obj_duration", new StringBuilder(String.valueOf(System.currentTimeMillis() - this.egh)).toString()));
            this.egh = 0L;
        }
        if (this.egG != null && this.egG.Cs() != null && this.egG.Cs().getVisibility() != 0) {
            this.egG.Db();
        }
        if (aIM().aLk() != null) {
            aIM().aLk().onStop();
        }
        if (this.egt.emS != null && !this.egt.emS.Ub()) {
            this.egt.emS.auV();
        }
        if (this.efE != null && this.efE.getPbData() != null && this.efE.getPbData().aHE() != null && this.efE.getPbData().aHG() != null) {
            com.baidu.tbadk.distribute.a.Cc().a(getPageContext().getPageActivity(), "pb", this.efE.getPbData().aHE().getId(), com.baidu.adp.lib.g.b.c(this.efE.getPbData().aHG().getId(), 0L));
        }
        if (this.bOm != null) {
            this.bOm.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.egl != null) {
            this.egl.destroy();
        }
        if (this.egz && this.efE != null) {
            a(this.efE.getPbData(), -2, 0, false, false);
        }
        if (!this.egf && this.egt != null) {
            this.egf = true;
            this.egt.aLU();
            a(false, (PostData) null);
        }
        if (this.efE != null) {
            this.efE.cancelLoadData();
            this.efE.destory();
            if (this.efE.aKt() != null) {
                this.efE.aKt().onDestroy();
            }
        }
        if (this.egG != null) {
            this.egG.onDestroy();
        }
        if (this.egs != null) {
            this.egs.cancelLoadData();
        }
        if (this.egt != null) {
            this.egt.onDestroy();
            if (this.egt.emS != null) {
                this.egt.emS.auV();
            }
        }
        if (this.egg != null) {
            this.egg.onDestroy();
        }
        if (this.efX != null) {
            this.efX.GA();
        }
        super.onDestroy();
        if (this.bOm != null) {
            this.bOm.onDestory(getPageContext());
        }
        if (this.bOH != null) {
            this.bOH.destory();
        }
        this.egt.auE();
        MessageManager.getInstance().unRegisterListener(this.ehb);
        MessageManager.getInstance().unRegisterListener(this.ehc);
        MessageManager.getInstance().unRegisterListener(this.ehd);
        MessageManager.getInstance().unRegisterListener(this.egL);
        this.egJ = null;
        this.egK = null;
        com.baidu.tieba.recapp.d.a.aYU().aYW();
        if (this.egM != null) {
            getSafeHandler().removeCallbacks(this.egM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        cq aLy;
        ArrayList<PostData> aJD;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xs() && this.egt != null && (aLy = this.egt.aLy()) != null && (aJD = aLy.aJD()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aJD.iterator();
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
                        bVar.btk = id;
                        bVar.bxb = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.Yi == 1 && !TextUtils.isEmpty(id)) {
                    next.Yi = 2;
                    a.b bVar2 = new a.b();
                    bVar2.btk = id;
                    bVar2.bxb = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.efE == null || this.efE.getPbData() == null || this.efE.getPbData().aHE() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.efE.getPbData().aHE().getFirst_class();
                    str2 = this.efE.getPbData().aHE().getSecond_class();
                    str = this.efE.getPbData().aHE().getId();
                    str4 = this.efE.getThreadID();
                }
                com.baidu.tieba.recapp.aa.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.xw());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.egt.onChangeSkinType(i);
        if (this.egG != null && this.egG.Cs() != null) {
            this.egG.Cs().onChangeSkinType(i);
        }
        if (this.egt.aLh() != null) {
            this.egt.aLh().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.egt = new fm(this, this.bPI, this.eeF);
        this.bRf = new com.baidu.tieba.e.c(getActivity());
        this.bRf.a(this.ehq);
        this.bRf.a(this.aRJ);
        this.egt.setOnScrollListener(this.mOnScrollListener);
        this.egt.d(this.ehl);
        this.egt.a(this.aYZ);
        this.egt.hL(com.baidu.tbadk.core.r.oV().pb());
        this.egt.setOnImageClickListener(this.aOe);
        this.egt.a(this.atr);
        this.egt.h(this.bNr);
        this.egt.a(this.ehj);
        this.egt.iw(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aR(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(w.h.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.fun == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.r.oV().pb()) {
                    return false;
                }
                return nF(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.egt != null) {
            if (z && (!this.dFR || this.egI)) {
                aJd();
            } else {
                hideLoadingView(this.egt.getView());
            }
            this.egI = false;
        }
    }

    private void aIP() {
        if (this.egc == null) {
            this.egc = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.egc.a(new String[]{getPageContext().getString(w.l.call_phone), getPageContext().getString(w.l.sms_phone), getPageContext().getString(w.l.search_in_baidu)}, new az(this)).cb(c.a.aam).cc(17).d(getPageContext());
        }
    }

    private void r(Bundle bundle) {
        this.efE = new PbModel(this);
        this.efE.a(this.ehe);
        if (this.efE.aKr() != null) {
            this.efE.aKr().a(this.ehs);
        }
        if (this.efE.aKq() != null) {
            this.efE.aKq().a(this.egT);
        }
        if (this.efE.aKt() != null) {
            this.efE.aKt().a(this.egP);
        }
        if (bundle != null) {
            this.efE.initWithBundle(bundle);
        } else {
            this.efE.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.efE.ig(true);
        }
        ex.aLb().O(this.efE.aJR(), this.efE.getIsFromMark());
        if (StringUtils.isNull(this.efE.getThreadID())) {
            finish();
        } else {
            this.efE.EG();
        }
    }

    private void initData(Bundle bundle) {
        this.dCb = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dCb != null) {
            this.dCb.a(this.ehh);
        }
        this.egs = new ForumManageModel(this);
        this.egs.setLoadDataCallBack(this.ehi);
        this.egt.a(new bb(this));
        this.egW.setUniqueId(getUniqueId());
        this.egW.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.egt.asr();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(w.h.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.egL;
        userMuteCheckCustomMessage.setTag(this.egL);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.bW(w.l.go_setting_float_window_permission);
        aVar.bX(w.l.step_to_setting_float_permission);
        aVar.a(w.l.go_and_setting, new bc(this));
        aVar.b(w.l.cancel, new bd(this));
        aVar.b(getPageContext()).td();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aIQ() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.efE != null && this.efE.getPbData() != null) {
            com.baidu.tieba.pb.data.f pbData = this.efE.getPbData();
            if (pbData.aHE() != null) {
                sb.append("forum_name=").append(nC(pbData.aHE().getName()));
                sb.append("&");
            }
            if (pbData.aHG() != null) {
                com.baidu.tbadk.core.data.bk aHG = pbData.aHG();
                sb.append("thread_id=").append(aHG.getId());
                sb.append("&");
                sb.append("thread_title=").append(nC(aHG.getTitle()));
                if (aHG.getAuthor() != null && aHG.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aHG.getAuthor().getPortrait());
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
            getSafeHandler().postDelayed(new be(this, iArr, measuredHeight, str, str2), 500L);
        }
    }

    private String nC(String str) {
        return URLEncoder.encode(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        PostData postData;
        ArrayList<IconData> arrayList;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(w.h.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(w.h.tag_clip_board)) != null && this.efE != null && this.efE.getPbData() != null && postData.bgM() > 1) {
            String threadID = this.efE.getThreadID();
            String id = postData.getId();
            int i = 0;
            if (this.efE.getPbData() != null) {
                i = this.efE.getPbData().aHR();
            }
            b nG = nG(id);
            if (nG != null) {
                SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
                SmallTailInfo aNs = postData.aNs();
                AntiData ql = this.efE.getPbData().ql();
                if (postData.getAuthor() != null) {
                    arrayList = postData.getAuthor().getIconInfo();
                } else {
                    arrayList = null;
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i, aNs, ql, false, arrayList).addBigImageData(nG.ehP, nG.ehQ, nG.ehR, nG.index)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aIR() {
        if (this.efE.getPbData() == null || this.efE.getPbData().aHG() == null) {
            return -1;
        }
        return this.efE.getPbData().aHG().sc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hS(boolean z) {
        if (this.efE == null || this.efE.getPbData() == null) {
            return false;
        }
        return ((this.efE.getPbData().aHR() != 0) || this.efE.getPbData().aHG() == null || this.efE.getPbData().aHG().getAuthor() == null || TextUtils.equals(this.efE.getPbData().aHG().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean hT(boolean z) {
        if (z) {
            return true;
        }
        if (this.efE == null || this.efE.getPbData() == null) {
            return false;
        }
        return this.efE.getPbData().aHR() != 0;
    }

    private boolean hU(boolean z) {
        return (z || this.efE == null || this.efE.getPbData() == null || this.efE.getPbData().aHR() == 0) ? false : true;
    }

    public void aIS() {
        if (this.efE != null && this.efE.getPbData() != null && this.efE.getPbData().aHG() != null && this.efE.getPbData().aHG().getAuthor() != null) {
            com.baidu.tbadk.core.data.bk aHG = this.efE.getPbData().aHG();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aHG.getAuthor().getUserId());
            GodUserData godUserData = aHG.getAuthor().getGodUserData();
            boolean z = equals && godUserData != null && godUserData.isCanSendCall();
            ei eiVar = new ei();
            if (this.efE.getPbData().aHR() == 1) {
                eiVar.elh = true;
                eiVar.elg = true;
                eiVar.elm = aHG.ru() == 1;
                eiVar.ell = aHG.rv() == 1;
            } else {
                eiVar.elh = false;
                eiVar.elg = false;
            }
            eiVar.elf = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteShareActivityConfig.class);
            eiVar.eld = TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            eiVar.eli = hT(equals);
            eiVar.elj = aIT();
            eiVar.elk = hU(equals);
            eiVar.ele = this.efE.aJT();
            eiVar.edS = this.dCb != null ? this.dCb.nL() : false;
            eiVar.elc = hS(equals);
            eiVar.ela = equals && this.egt.aLM();
            eiVar.elb = z;
            eiVar.isHostOnly = this.efE.getHostMode();
            if (aHG.rP() == null) {
                eiVar.eln = false;
            } else {
                eiVar.eln = true;
            }
            this.egt.emS.a(eiVar);
        }
    }

    private boolean aIT() {
        if (this.efE != null && this.efE.aJT()) {
            return this.efE.ajK() == null || this.efE.ajK().qy() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(w.h.tag_clip_board)) != null) {
            f(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, boolean z2) {
        if (fVar != null && this.efE != null) {
            eo eoVar = new eo(getUniqueId());
            eoVar.pbData = fVar;
            eoVar.threadId = this.efE.getThreadID();
            eoVar.postId = this.efE.getPostId();
            eoVar.elN = i;
            eoVar.elO = i2;
            eoVar.elM = this.efE.getHostMode();
            eoVar.edS = this.efE.nL();
            eoVar.isSquence = this.efE.aJT();
            eoVar.loadType = this.efE.aKo();
            eoVar.elP = z;
            eoVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, eoVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aIU() {
        if (aIM() == null || aIM().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aIM().getListView();
        List<com.baidu.adp.widget.ListView.v> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.v vVar = data.get(i);
            if ((vVar instanceof com.baidu.tieba.pb.data.j) && ((com.baidu.tieba.pb.data.j) vVar).mType == 0) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, boolean z2) {
        if (fVar != null && this.efE != null) {
            eo eoVar = new eo(getUniqueId());
            eoVar.pbData = fVar;
            eoVar.threadId = this.efE.getThreadID();
            eoVar.postId = this.efE.getPostId();
            eoVar.elN = i;
            eoVar.elM = this.efE.getHostMode();
            eoVar.edS = this.efE.nL();
            eoVar.isSquence = this.efE.aJT();
            eoVar.loadType = this.efE.aKo();
            eoVar.elP = z;
            eoVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, eoVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        aum();
    }

    public void a(boolean z, MarkData markData) {
        this.egt.aLF();
        this.efE.m15if(z);
        if (this.dCb != null) {
            this.dCb.ad(z);
            if (markData != null) {
                this.dCb.a(markData);
            }
        }
        if (this.efE.nL()) {
            aJa();
        } else {
            this.egt.l(this.efE.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nX(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nD(String str) {
        if (!StringUtils.isNull(str) && this.efE != null) {
            String threadID = this.efE.getThreadID();
            String id = this.efE.getPbData().aHE().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(w.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.efE.aJX()) {
                    antiData.setBlock_forum_name(this.efE.getPbData().aHE().getName());
                    antiData.setBlock_forum_id(this.efE.getPbData().aHE().getId());
                    antiData.setUser_name(this.efE.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.efE.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.rV(i)) {
            AntiHelper.aq(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            fA(str);
        } else {
            this.egt.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.egt.a(0, bVar.AM, bVar.fwz, z);
            if (bVar.AM) {
                if (bVar.fwx == 1) {
                    ArrayList<PostData> aHI = this.efE.getPbData().aHI();
                    int size = aHI.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aHI.get(i).getId())) {
                            i++;
                        } else {
                            aHI.remove(i);
                            break;
                        }
                    }
                    this.egt.l(this.efE.getPbData());
                } else if (bVar.fwx == 0) {
                    aIV();
                } else if (bVar.fwx == 2) {
                    ArrayList<PostData> aHI2 = this.efE.getPbData().aHI();
                    int size2 = aHI2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aHI2.get(i2).bgJ().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aHI2.get(i2).bgJ().get(i3).getId())) {
                                i3++;
                            } else {
                                aHI2.get(i2).bgJ().remove(i3);
                                aHI2.get(i2).bgL();
                                z2 = true;
                                break;
                            }
                        }
                        aHI2.get(i2).pY(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.egt.l(this.efE.getPbData());
                    }
                    a(bVar, this.egt);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.f fVar) {
        if (fVar != null) {
            this.egt.a(this.egs.getLoadDataMode(), fVar.AM, fVar.fwz, false);
            if (fVar.AM) {
                this.egv = true;
                if (i == 2 || i == 3) {
                    this.egw = true;
                    this.egx = false;
                } else if (i == 4 || i == 5) {
                    this.egw = false;
                    this.egx = true;
                }
                if (i == 2) {
                    this.efE.getPbData().aHG().bS(1);
                    this.efE.setIsGood(1);
                } else if (i == 3) {
                    this.efE.getPbData().aHG().bS(0);
                    this.efE.setIsGood(0);
                } else if (i == 4) {
                    this.efE.getPbData().aHG().bR(1);
                    this.efE.gX(1);
                } else if (i == 5) {
                    this.efE.getPbData().aHG().bR(0);
                    this.efE.gX(0);
                }
                this.egt.d(this.efE.getPbData(), this.efE.aJT());
                com.baidu.tieba.c.a.a(getPageContext(), 2, i);
            }
        }
    }

    private void aIV() {
        if (this.efE.aJU() || this.efE.aJV()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.efE.getThreadID());
            setResult(-1, intent);
        }
        if (aJb()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIW() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aHO;
        if (this.egt != null) {
            this.egt.auE();
        }
        if (this.efE != null && this.efE.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.efE.getPbData().aHG().getId();
            historyMessage.forumName = this.efE.getPbData().aHE().getName();
            historyMessage.threadName = this.efE.getPbData().aHG().getTitle();
            ArrayList<PostData> aHI = this.efE.getPbData().aHI();
            int aLH = this.egt != null ? this.egt.aLH() : 0;
            if (aHI != null && aLH >= 0 && aLH < aHI.size()) {
                historyMessage.postID = aHI.get(aLH).getId();
            }
            historyMessage.isHostOnly = this.efE.getHostMode();
            historyMessage.isSquence = this.efE.aJT();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.egG != null) {
            this.egG.onDestroy();
        }
        if (this.ega && aIM() != null) {
            aIM().aMi();
        }
        if (this.efE != null && (this.efE.aJU() || this.efE.aJV())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.efE.getThreadID());
            if (this.egv) {
                if (this.egx) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.efE.auv());
                }
                if (this.egw) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.efE.getIsGood());
                }
            }
            if (this.efE.getPbData() != null && System.currentTimeMillis() - this.ege >= 40000 && (aHO = this.efE.getPbData().aHO()) != null && !com.baidu.tbadk.core.util.x.r(aHO.getDataList())) {
                intent.putExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA, aHO);
                intent.putExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, this.egO);
            }
            setResult(-1, intent);
        }
        if (aJb()) {
            if (this.efE != null && this.egt != null && this.egt.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.efE.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.m9getInst().getDefaultBubble());
                    }
                    if (!pbData.aHM() && !this.egm) {
                        ex.aLb().a(this.efE.getPbData(), this.egt.getListView().onSaveInstanceState(), this.efE.aJT(), this.efE.getHostMode());
                    }
                }
            } else {
                ex.aLb().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.egt == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.egt.oq(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nY(int i) {
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
        this.egG.onActivityResult(i, i2, intent);
        if (aIM().aLk() != null) {
            aIM().aLk().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aIZ();
                    return;
                case 13008:
                    ex.aLb().reset();
                    this.mHandler.postDelayed(new bf(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.efE != null) {
                        a(aIY(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                    if (aIR() == 1) {
                        aIX();
                        return;
                    }
                    return;
                case 24008:
                    this.egt.hQ(false);
                    if (this.efE.getPbData() != null && this.efE.getPbData().aHG() != null && this.efE.getPbData().aHG().rS() != null) {
                        this.efE.getPbData().aHG().rS().setStatus(2);
                        break;
                    }
                    break;
                case 25001:
                    break;
                case 25012:
                    intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
                    intent.getStringExtra("KEY_FORUM_NAME");
                    return;
                default:
                    return;
            }
            if (this.egl != null) {
                this.egl.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aIM() != null && aII() != null && aIM().aLm() && com.baidu.tbadk.editortools.pb.a.CO().getStatus() == 1) {
                    com.baidu.tbadk.editortools.pb.a.CO().setStatus(0);
                    if (this.egt != null) {
                        this.egt.aLl();
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
    public void aIX() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.efE.getPbData() != null && this.efE.getPbData().aHG() != null && this.efE.getPbData().aHG().rJ() != null && this.efE.getPbData().aHG().rJ().size() > 0 && this.efE.getPbData().aHG().rJ().get(0) != null) {
            this.mAwardActId = this.efE.getPbData().aHG().rJ().get(0).pq();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.efE.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void S(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra(GetLotteryChanceActivityConfig.KEY_ACTION, 0)) {
                case 1:
                    oa(2);
                    return;
                case 2:
                    this.egt.aLw();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aIY() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bJ = this.efE.getPbData().bJ(getPageContext().getPageActivity());
        PostData aLn = this.egt.aLn();
        String str = "";
        if (aLn != null) {
            str = aLn.getId();
            String bT = aLn.bT(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(bT)) {
                bJ[1] = bT;
            }
        }
        String rO = this.efE.getPbData().aHG().rO();
        if (rO != null && rO.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bJ[1]);
        shareFromPBMsgData.setImageUrl(bJ[0]);
        shareFromPBMsgData.setForumName(this.efE.getPbData().aHE().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.efE.getPbData().aHG().getId());
        shareFromPBMsgData.setTitle(this.efE.getPbData().aHG().getTitle());
        return shareFromPBMsgData;
    }

    private void T(Intent intent) {
        a(aIY(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.efE != null && this.efE.getPbData() != null && this.efE.getPbData().aHG() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gz gzVar = new gz(getPageContext().getPageActivity());
            gzVar.setData(shareFromPBMsgData);
            aVar.bZ(1);
            aVar.v(gzVar);
            aVar.a(w.l.share, new bg(this, gzVar, j, str, str2, shareFromPBMsgData));
            aVar.b(w.l.alert_no_button, new bh(this, gzVar));
            aVar.at(true);
            aVar.b(getPageContext()).td();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                gzVar.G(shareFromPBMsgData.getImageUrl(), this.efE.getPbData().aHS() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.efE != null && this.efE.getPbData() != null && this.efE.getPbData().aHG() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gz gzVar = new gz(getPageContext().getPageActivity());
            gzVar.setData(shareFromPBMsgData);
            aVar.bZ(1);
            aVar.v(gzVar);
            aVar.a(w.l.share, new bi(this, gzVar, i, str, j, shareFromPBMsgData));
            aVar.b(w.l.alert_no_button, new bj(this, gzVar));
            aVar.at(true);
            aVar.b(getPageContext()).td();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                gzVar.G(shareFromPBMsgData.getImageUrl(), this.efE.getPbData().aHS() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIZ() {
        MarkData ol;
        if (this.dCb != null && (ol = this.efE.ol(this.egt.aLI())) != null) {
            if (!ol.isApp() || (ol = this.efE.ol(this.egt.aLI() + 1)) != null) {
                this.egt.aLD();
                this.dCb.a(ol);
                if (!this.dCb.nL()) {
                    this.dCb.nN();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.dCb.nM();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJa() {
        com.baidu.tieba.pb.data.f pbData = this.efE.getPbData();
        this.efE.m15if(true);
        pbData.ny(this.dCb.nK());
        this.egt.l(pbData);
    }

    private boolean aJb() {
        if (this.efE == null) {
            return true;
        }
        if (this.efE.nL()) {
            MarkData aKf = this.efE.aKf();
            if (aKf == null || !this.efE.getIsFromMark()) {
                return true;
            }
            MarkData ol = this.efE.ol(this.egt.aLI());
            if (ol == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aKf);
                setResult(-1, intent);
                return true;
            } else if (ol.getPostId() == null || ol.getPostId().equals(aKf.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aKf);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cC(getPageContext().getString(w.l.alert_update_mark));
                aVar.a(w.l.alert_yes_btn, new bk(this, ol, aKf, aVar));
                aVar.b(w.l.alert_no_button, new bm(this, aKf, aVar));
                aVar.a(new bn(this, aKf, aVar));
                aVar.b(getPageContext());
                aVar.td();
                return false;
            }
        } else if (this.efE.getPbData() == null || this.efE.getPbData().aHI() == null || this.efE.getPbData().aHI().size() <= 0 || !this.efE.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.egt == null) {
            return null;
        }
        return this.egt.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int If() {
        if (this.egt == null) {
            return 0;
        }
        return this.egt.aLP();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> Ig() {
        if (this.aNK == null) {
            this.aNK = new com.baidu.adp.lib.e.b<>(new bo(this), 8, 0);
        }
        return this.aNK;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> Ih() {
        if (this.aNL == null) {
            this.aNL = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aNL;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> Ii() {
        if (this.aNP == null) {
            this.aNP = new com.baidu.adp.lib.e.b<>(new bp(this), 20, 0);
        }
        return this.aNP;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Ij() {
        if (this.aNN == null) {
            this.aNN = new com.baidu.adp.lib.e.b<>(new bq(this), 8, 0);
        }
        return this.aNN;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Il() {
        if (this.aNM == null) {
            this.aNM = com.baidu.tieba.graffiti.d.o(getPageContext().getPageActivity(), 6);
        }
        return this.aNM;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wG() {
        if (this.amv == null) {
            this.amv = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.amv;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Y(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.egj = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        if (ha.nQ(str) && this.efE != null && this.efE.getThreadID() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11664").s("obj_param1", 1).aa("post_id", this.efE.getThreadID()));
        }
        ha.aMj().f(getPageContext(), str);
        this.egj = true;
    }

    private com.baidu.tbadk.core.dialog.a aJc() {
        if (this.egd == null) {
            this.egd = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.egd.cB(getPageContext().getString(w.l.download_baidu_video_dialog));
            this.egd.a(getPageContext().getString(w.l.install), new br(this));
            this.egd.b(getPageContext().getString(w.l.cancel), new bs(this));
            this.egd.as(true);
            this.egd.b(getPageContext());
            this.egd.at(false);
        }
        this.egd.td();
        return this.egd;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        ha.aMj().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.egj = true;
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
            aJc();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.egj = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ab(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.efE.getPbData();
            TbRichText an = an(str, i);
            if (an != null && (tbRichTextData = an.HC().get(this.ehm)) != null) {
                bVar.ehP = new ArrayList<>();
                bVar.ehQ = new ConcurrentHashMap<>();
                if (!tbRichTextData.HI().HU()) {
                    bVar.ehS = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    bVar.ehP.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.postId = an.getPostId();
                    imageUrlData.mIsReserver = this.efE.aKe();
                    imageUrlData.mIsSeeHost = this.efE.getHostMode();
                    bVar.ehQ.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aHE() != null) {
                            bVar.forumName = pbData.aHE().getName();
                            bVar.forumId = pbData.aHE().getId();
                        }
                        if (pbData.aHG() != null) {
                            bVar.threadId = pbData.aHG().getId();
                        }
                        bVar.ehR = pbData.aHS() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.ehS = true;
                int size = pbData.aHI().size();
                this.ehn = false;
                bVar.index = -1;
                if (pbData.aHN() != null) {
                    PostData aHN = pbData.aHN();
                    TbRichText aui = aHN.aui();
                    if (!fl.h(aHN)) {
                        i2 = a(aui, an, i, i, bVar.ehP, bVar.ehQ);
                    } else {
                        i2 = a(aHN, i, bVar.ehP, bVar.ehQ);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aHI().get(i4);
                    if (postData.getId() == null || pbData.aHN() == null || pbData.aHN().getId() == null || !postData.getId().equals(pbData.aHN().getId())) {
                        TbRichText aui2 = postData.aui();
                        if (!fl.h(postData)) {
                            i3 = a(aui2, an, i3, i, bVar.ehP, bVar.ehQ);
                        } else {
                            i3 = a(postData, i3, bVar.ehP, bVar.ehQ);
                        }
                    }
                }
                if (bVar.ehP.size() > 0) {
                    bVar.lastId = bVar.ehP.get(bVar.ehP.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aHE() != null) {
                        bVar.forumName = pbData.aHE().getName();
                        bVar.forumId = pbData.aHE().getId();
                    }
                    if (pbData.aHG() != null) {
                        bVar.threadId = pbData.aHG().getId();
                    }
                    bVar.ehR = pbData.aHS() == 1;
                }
                bVar.index = i3;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.HI() == null) {
            return null;
        }
        return tbRichTextData.HI().HY();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.HI() == null) {
            return 0L;
        }
        return tbRichTextData.HI().getOriginalSize();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo HI;
        if (tbRichText == tbRichText2) {
            this.ehn = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.HC().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.HC().get(i6) == null || tbRichText.HC().get(i6).getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int width = tbRichText.HC().get(i6).HI().getWidth();
                    int height = tbRichText.HC().get(i6).HI().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.HC().get(i6).HI().HU()) {
                        if (tbRichText == tbRichText2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.HC().get(i6);
                        String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                        if (!TextUtils.isEmpty(c2)) {
                            arrayList.add(c2);
                            if (tbRichTextData != null && (HI = tbRichTextData.HI()) != null) {
                                String HW = HI.HW();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = HW;
                                imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.efE.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.efE.aKe();
                                imageUrlData.mIsSeeHost = this.efE.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.ehn) {
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
        com.baidu.tieba.tbadkCore.data.h bgU;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bgo;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bgo = (bgU = postData.bgU()).bgo()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bgo.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bgo.get(i3);
                if (jVar != null) {
                    String bgv = jVar.bgv();
                    if (!com.baidu.tbadk.core.util.au.isEmpty(bgv)) {
                        arrayList.add(bgv);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bgv;
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        imageUrlData.originalUrl = jVar.bgt();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.efE.getThreadID(), -1L);
                        imageUrlData.mIsReserver = this.efE.aKe();
                        imageUrlData.mIsSeeHost = this.efE.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bgU.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bgv, imageUrlData);
                        }
                        if (!this.ehn) {
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
    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.efE.rH())) {
                z = true;
            }
            MarkData g = this.efE.g(postData);
            if (g != null) {
                this.egt.aLD();
                if (this.dCb != null) {
                    this.dCb.a(g);
                    if (!z) {
                        this.dCb.nN();
                    } else {
                        this.dCb.nM();
                    }
                }
            }
        }
    }

    private TbRichText an(String str, int i) {
        TbRichText tbRichText = null;
        if (this.efE == null || this.efE.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.efE.getPbData();
        if (pbData.aHN() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aHN());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            return a(pbData.aHI(), str, i);
        }
        return tbRichText;
    }

    private long nE(String str) {
        ArrayList<PostData> aHI;
        com.baidu.tieba.pb.data.f pbData = this.efE.getPbData();
        if (pbData != null && (aHI = pbData.aHI()) != null && !aHI.isEmpty()) {
            Iterator<PostData> it = aHI.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bgU = next.bgU();
                if (bgU != null && bgU.ftS) {
                    Iterator<TbRichTextData> it2 = next.aui().HC().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.HQ().getLink().equals(str)) {
                            return bgU.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> HC;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText aui = arrayList.get(i2).aui();
            if (aui != null && (HC = aui.HC()) != null) {
                int size = HC.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (HC.get(i4) != null && HC.get(i4).getType() == 8) {
                        i3++;
                        if (HC.get(i4).HI().HW().equals(str)) {
                            int width = HC.get(i4).HI().getWidth();
                            int height = HC.get(i4).HI().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.ehm = i4;
                            return aui;
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
            this.efC = str;
            if (this.egc == null) {
                aIP();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.egc.ce(1).setVisibility(8);
            } else {
                this.egc.ce(1).setVisibility(0);
            }
            this.egc.tg();
            this.egj = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bOm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aum() {
        hideNetRefreshView(this.egt.getView());
        aJd();
        if (this.efE.EG()) {
            this.egt.aLD();
        }
    }

    private void aJd() {
        showLoadingView(this.egt.getView(), false, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds400));
        View Ed = getLoadingView().Ed();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Ed.getLayoutParams();
        layoutParams.addRule(3, this.egt.aLZ().getId());
        Ed.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zo() {
        if (this.bOm != null) {
            this.bOm.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nZ(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa(int i) {
        if (this.efE.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.efE.getPbData();
            String name = pbData.aHE().getName();
            String title = pbData.aHG().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.efE.getThreadID() + "?share=9105&fr=share&see_lz=" + (this.efE.getHostMode() ? 1 : 0);
            String[] bJ = pbData.bJ(getPageContext().getPageActivity());
            String str2 = bJ[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = bJ[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (aIR() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10399").aa("fid", pbData.getForumId()).aa("tid", pbData.getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
            } else if (aIR() == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10406").aa("fid", pbData.getForumId()).aa("tid", pbData.getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(w.l.share_content_tpl), title, name, str3);
            com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
            hVar.title = title;
            hVar.content = format;
            hVar.linkUrl = str;
            hVar.asi = true;
            hVar.extData = this.efE.getThreadID();
            hVar.asq = 3;
            hVar.asp = i;
            if (parse != null) {
                hVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), hVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(w.l.forum_friend, w.g.icon_unite_share_baf, new bt(this));
            shareDialogConfig.setCopyLinkListener(new bu(this, hVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> Ik() {
        if (this.aNO == null) {
            this.aNO = new com.baidu.adp.lib.e.b<>(new bw(this), 15, 0);
        }
        return this.aNO;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.egt.aLx() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10517").s("obj_locate", 2).aa("fid", this.efE.getPbData().getForumId()));
            } else {
                com.baidu.tbadk.core.data.bk aHG = this.efE.getPbData().aHG();
                if (view != null) {
                    boolean z = aHG.ro() == null || aHG.ro().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.egX > 1000) {
                            this.egY = true;
                            aT(view);
                        } else {
                            this.egY = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            f(view, this.egY);
                        } else {
                            e(view, this.egY);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        e(view, this.egY);
                    } else if (motionEvent.getAction() == 3) {
                        e(view, this.egY);
                    }
                }
            }
        }
        return false;
    }

    private void e(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.praise_animation_scale2));
            new Handler().postDelayed(new bx(this), 200L);
        }
    }

    private void f(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.praise_animation_scale3));
            new Handler().postDelayed(new by(this), 600L);
        }
    }

    private void aT(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void Zp() {
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
        } else if (aVar.tf() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.tf();
            int intValue = ((Integer) sparseArray.get(fm.eoG)).intValue();
            if (intValue == fm.eoH) {
                if (!this.egs.bhy()) {
                    this.egt.aLA();
                    int intValue2 = ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue();
                    this.egs.a(this.efE.getPbData().aHE().getId(), this.efE.getPbData().aHE().getName(), this.efE.getPbData().aHG().getId(), (String) sparseArray.get(w.h.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == fm.eoI || intValue == fm.eoK) {
                if (this.efE.aKr() != null) {
                    this.efE.aKr().od(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == fm.eoI) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == fm.eoJ) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.ehr).pl()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.egL);
        userMuteAddAndDelCustomMessage.setTag(this.egL);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean nF(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bg.aN(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.tX().getString("bubble_link", ""))) {
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

    public void hV(boolean z) {
        this.egD = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aJe() {
        ArrayList<PostData> aHI;
        int q;
        if (this.efE == null || this.efE.getPbData() == null || this.efE.getPbData().aHI() == null || (q = com.baidu.tbadk.core.util.x.q((aHI = this.efE.getPbData().aHI()))) == 0) {
            return "";
        }
        if (this.efE.aKe()) {
            Iterator<PostData> it = aHI.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bgM() == 1) {
                    return next.getId();
                }
            }
        }
        int aLH = this.egt.aLH();
        PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(aHI, aLH);
        if (postData == null || postData.getAuthor() == null) {
            return "";
        }
        if (this.efE.nJ(postData.getAuthor().getUserId())) {
            return postData.getId();
        }
        for (int i = aLH - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.x.c(aHI, i);
            if (postData2 == null || postData2.getAuthor() == null || postData2.getAuthor().getUserId() == null) {
                break;
            } else if (this.efE.nJ(postData2.getAuthor().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = aLH + 1; i2 < q; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.x.c(aHI, i2);
            if (postData3 == null || postData3.getAuthor() == null || postData3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.efE.nJ(postData3.getAuthor().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ad(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.bb.vB().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.b.a(nE(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.efE.getPbData().aHE().getId(), this.efE.getPbData().aHE().getName(), this.efE.getPbData().aHG().getTid());
            }
            this.egj = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, String str2, String str3, String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cC(getResources().getString(w.l.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cC(getResources().getString(w.l.make_sure_hide));
        }
        aVar.a(getResources().getString(w.l.alert_yes_button), new bz(this, j, str, str2, str3, str4));
        aVar.b(getResources().getString(w.l.alert_no_button), new ca(this, j, str, str2, str3, str4));
        aVar.at(false);
        aVar.b(getPageContext());
        aVar.td();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b nG(String str) {
        String str2;
        if (this.efE.getPbData() == null || this.efE.getPbData().aHI() == null || this.efE.getPbData().aHI().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i < this.efE.getPbData().aHI().size()) {
                if (str.equals(this.efE.getPbData().aHI().get(i).getId())) {
                    break;
                }
                i++;
            } else {
                i = 0;
                break;
            }
        }
        PostData postData = this.efE.getPbData().aHI().get(i);
        if (postData.aui() == null || postData.aui().HC() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.aui().HC().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.HI() != null) {
                    str2 = next.HI().HW();
                }
            }
        }
        a(str2, 0, bVar);
        com.baidu.tieba.pb.data.g.a(postData, bVar);
        return bVar;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.efY) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.efY = false;
        } else if (aJf()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.efY) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.efY = false;
        } else if (aJf()) {
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
        if (pageStayDurationItem != null && this.efE != null) {
            if (this.efE.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.efE.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.efE.getThreadID(), 0L));
            if (this.egk) {
                pageStayDurationItem.objParam1 = "1";
            }
        }
        return pageStayDurationItem;
    }

    public boolean aJf() {
        return (!this.efW && this.eht == -1 && this.ehu == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.ehw = nVar;
            this.efW = true;
            this.egt.aLo();
            this.egt.nO(this.ehv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJg() {
        if (this.ehw != null) {
            if (this.eht == -1) {
                showToast(w.l.pb_manga_not_prev_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.ehw.getCartoonId(), this.eht, 0)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJh() {
        if (this.ehw != null) {
            if (this.ehu == -1) {
                showToast(w.l.pb_manga_not_next_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.ehw.getCartoonId(), this.ehu, 0)));
            finish();
        }
    }

    public int aJi() {
        return this.eht;
    }

    public int aJj() {
        return this.ehu;
    }

    private void ajh() {
        if (this.efE != null && this.efE.getPbData() != null && this.efE.getPbData().aHG() != null && this.efE.getPbData().aHG().sl()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aJk() {
        if (this.efE != null && this.efE.getPbData() != null && this.efE.getPbData().aHG() != null && this.efE.getPbData().aHG().sl()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aJl() {
        if (this.efZ) {
            this.egq = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.efE.getPbData() != null && this.efE.getPbData().aHG() != null && this.efE.getPbData().aHG().rh() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.efE.getPbData().aHG().rh().getThreadId(), this.efE.getPbData().aHG().rh().getTaskId(), this.efE.getPbData().aHG().rh().getForumId(), this.efE.getPbData().aHG().rh().getForumName(), this.efE.getPbData().aHG().ru(), this.efE.getPbData().aHG().rv())));
            this.efY = true;
            finish();
        }
    }

    public boolean aJm() {
        return this.efZ;
    }

    public String aJn() {
        return this.ego;
    }

    public PbInterviewStatusView.a aJo() {
        return this.egr;
    }

    public void hW(boolean z) {
        this.egp = z;
    }

    public boolean aJp() {
        if (this.efE != null) {
            return this.efE.aJU();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJq() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cC(getResources().getString(w.l.mute_is_super_member_function));
        aVar.a(w.l.open_now, new cb(this));
        aVar.b(w.l.cancel, new cc(this));
        aVar.b(this.egJ).td();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fA(String str) {
        if (str == null) {
            str = "";
        }
        if (this.egJ != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.egJ.getPageActivity());
            aVar.cC(str);
            aVar.b(w.l.know, new cd(this));
            aVar.b(this.egJ).td();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.egt.asr();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.egJ.getPageActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.cC(this.egJ.getResources().getString(w.l.block_mute_message_alert, str2));
        } else {
            aVar.cC(str);
        }
        aVar.a(w.l.confirm, new ce(this, userMuteAddAndDelCustomMessage));
        aVar.b(w.l.cancel, new cg(this));
        aVar.b(this.egJ).td();
    }

    public void aJr() {
        if (this.efE != null && this.efE.getPbData() != null && this.efE.getPbData().aHG() != null && this.efE.getPbData().aHG().sC() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bX(w.l.channel_open_push_message);
            aVar.a(w.l.need_channel_push, new ch(this));
            aVar.b(w.l.not_need_channel_push, new ci(this));
            aVar.b(getPageContext());
            aVar.td();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.b
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.b[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.b.class);
            for (int i = 0; i < objArr.length; i++) {
                if (ha.nQ(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_pb_wenxue)) != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                    spannableStringBuilder2.setSpan(new com.baidu.tbadk.widget.h(drawable), 0, "#4%2&@#907$12#@96476)w7we9e~@$%&&".length(), 33);
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
            this.egn = true;
        } else {
            this.egn = false;
        }
        if (this.egt != null) {
            this.egt.onConfigurationChanged(configuration);
        }
        if (this.egy != null) {
            this.egy.dismiss();
        }
    }

    public boolean aJs() {
        if (this.efE != null) {
            return this.efE.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, fm fmVar) {
        boolean z;
        List<PostData> list = this.efE.getPbData().aHQ().edU;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bgJ().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bgJ().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bgJ().remove(i2);
                    list.get(i).bgL();
                    z = true;
                    break;
                }
            }
            list.get(i).pY(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            fmVar.l(this.efE.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.l lVar) {
        String id = lVar.aIr().getId();
        List<PostData> list = this.efE.getPbData().aHQ().edU;
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
                ArrayList<PostData> aIv = lVar.aIv();
                postData.rP(lVar.getTotalCount());
                if (postData.bgJ() != null) {
                    postData.bgJ().clear();
                    postData.bgJ().addAll(aIv);
                }
            }
        }
        this.egt.l(this.efE.getPbData());
    }

    public boolean aJt() {
        boolean z = true;
        if (this.efE == null) {
            return false;
        }
        switch (this.efE.aKx()) {
            case 1:
            case 2:
                break;
            default:
                if (this.efE.getPbData() != null && this.efE.getPbData().aHG() != null && this.efE.getPbData().aHG().sG() && StringUtils.isNull(this.efE.getForumId())) {
                    z = false;
                    break;
                }
                break;
        }
        return z;
    }
}
