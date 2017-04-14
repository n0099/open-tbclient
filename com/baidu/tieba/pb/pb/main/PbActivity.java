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
    private com.baidu.adp.lib.e.b<ImageView> aNq;
    private com.baidu.adp.lib.e.b<TextView> aNr;
    private com.baidu.adp.lib.e.b<View> aNs;
    private com.baidu.adp.lib.e.b<View> aNt;
    private com.baidu.adp.lib.e.b<LinearLayout> aNu;
    private com.baidu.adp.lib.e.b<GifView> aNv;
    private com.baidu.adp.lib.e.b<TbImageView> amf;
    private VoiceManager bMC;
    private com.baidu.tbadk.h.a bNb;
    private com.baidu.tieba.e.c bQe;
    private boolean eiJ;
    private com.baidu.tieba.pb.pb.main.b eiK;
    private dp eiX;
    private String eid;
    private com.baidu.tieba.pb.pb.main.a.f eiy;
    private boolean ejG;
    private String ejR;
    private com.baidu.tbadk.core.data.n ejS;
    private boolean ejc;
    private com.baidu.tieba.tbadkCore.data.e ejd;
    private com.baidu.tbadk.editortools.pb.c eje;
    private com.baidu.adp.base.g ejh;
    private com.baidu.tbadk.core.view.h eji;
    private BdUniqueId ejj;
    private Runnable ejk;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean eix = false;
    private boolean eiz = false;
    private boolean eiA = false;
    private boolean dJd = false;
    private int eiB = 0;
    private com.baidu.tbadk.core.dialog.c eiC = null;
    private long bEG = -1;
    private long aGE = 0;
    private long eiD = 0;
    private long createTime = 0;
    private long aGw = 0;
    private boolean eiE = false;
    private com.baidu.tbadk.j.e eiF = null;
    private long eiG = 0;
    private boolean eiH = false;
    private boolean eiI = false;
    private String aAU = null;
    private boolean eiL = false;
    private boolean eiM = false;
    private String eiN = "";
    private boolean eiO = true;
    private boolean eiP = false;
    private String source = "";
    private PbInterviewStatusView.a eiQ = new i(this);
    private final Handler mHandler = new Handler(new t(this));
    private PbModel eif = null;
    private com.baidu.tbadk.baseEditMark.a dFo = null;
    private ForumManageModel eiR = null;
    private ey eiS = null;
    public final com.baidu.tieba.pb.pb.main.a.a eiT = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean eiU = false;
    private boolean eiV = false;
    private boolean eiW = false;
    private boolean eiY = false;
    private boolean eiZ = false;
    private boolean eja = false;
    private boolean ejb = false;
    private boolean ejf = false;
    private com.baidu.tbadk.editortools.pb.b aAY = new ae(this);
    private boolean ejg = false;
    private int cBC = -1;
    private int ejl = -1;
    private final CustomMessageListener ejm = new ap(this, CmdConfigCustom.PB_RESET_EDITOR_TOOL);
    CustomMessageListener bNv = new ba(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private CustomMessageListener ejn = new bl(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener doD = new bu(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener dpa = new cf(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener ejo = new cg(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener aOk = new j(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
    private CustomMessageListener cOE = new k(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private cv.a ejp = new l(this);
    private View.OnClickListener doC = new m(this);
    private CustomMessageListener ejq = new n(this, CmdConfigCustom.CMD_SEND_GIFT_SUCCESS);
    private boolean ejr = false;
    private PraiseModel ejs = new PraiseModel(getPageContext(), new o(this));
    private long ejt = 0;
    private boolean eju = true;
    private f.a ejv = new p(this);
    private CustomMessageListener aZX = new q(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener ejw = new r(this, CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED);
    private com.baidu.tieba.pb.a.d ehl = new com.baidu.tieba.pb.a.d(new s(this));
    private CustomMessageListener ejx = new u(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener ejy = new v(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener ejz = new w(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    public a.b dSY = new x(this);
    public final View.OnClickListener bOx = new y(this);
    private final NewWriteModel.d aBe = new z(this);
    private final PbModel.a ejA = new aa(this);
    private CustomMessageListener ejB = new ab(this, CmdConfigCustom.CMD_WX_SHARE_SUCCESS);
    private CustomMessageListener ejC = new ac(this, CmdConfigCustom.CMD_TTS_OPTION_PB);
    private final a.InterfaceC0028a ejD = new ad(this);
    private final AbsListView.OnScrollListener mOnScrollListener = new af(this);
    private final com.baidu.adp.base.f ejE = new ag(this);
    private final c ejF = new ah(this);
    private final ab.b aYA = new ai(this);
    private final BdListView.e ejH = new aj(this);
    private int ejI = 0;
    private final TbRichTextView.e aNK = new ak(this);
    boolean ejJ = false;
    PostData ejK = null;
    private final c.b ejL = new al(this);
    private final View.OnLongClickListener atl = new am(this);
    private final NoNetworkView.a bLW = new an(this);
    public View.OnTouchListener aOh = new ao(this);
    private a.InterfaceC0055a aRm = new aq(this);
    private final c.a ejM = new ar(this);
    private String ejN = null;
    private final cy.a ejO = new as(this);
    private int ejP = -1;
    private int ejQ = -1;
    private CustomMessageListener ejT = new at(this, CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST);
    private final CustomMessageListener bNz = new au(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> ekl;
        public ConcurrentHashMap<String, ImageUrlData> ekm;
        public boolean eko;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean ekn = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes.dex */
    public interface c {
    }

    public void ig(boolean z) {
        this.eiH = z;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.pb.c aKm() {
        return this.eje;
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        if (jVar.aJV() != null) {
            String id = jVar.aJV().getId();
            ArrayList<PostData> aJz = this.eif.getPbData().aJz();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aJz.size()) {
                    break;
                }
                PostData postData = aJz.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aJZ = jVar.aJZ();
                    postData.rR(jVar.getTotalCount());
                    if (postData.bil() != null) {
                        postData.bil().clear();
                        postData.bil().addAll(aJZ);
                    }
                }
            }
            this.eiS.k(this.eif.getPbData());
        }
    }

    public void aKn() {
        com.baidu.tieba.pb.data.f pbData;
        com.baidu.tbadk.core.data.bi aJx;
        if (!this.ejr) {
            if (!com.baidu.adp.lib.util.k.hA()) {
                showToast(w.l.no_network_guide);
            } else if (this.eju) {
                this.ejr = true;
                if (this.eif != null && (pbData = this.eif.getPbData()) != null && (aJx = pbData.aJx()) != null) {
                    int isLike = aJx.se() == null ? 0 : aJx.se().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10796").aa("tid", aJx.getId()));
                    }
                    if (this.ejs != null) {
                        this.ejs.a(aJx.sE(), aJx.getId(), isLike, "pb");
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
    public void ii(int i) {
        com.baidu.tbadk.core.data.bi aJx;
        String sb;
        String w;
        if (this.eif != null && this.eif.getPbData() != null && (aJx = this.eif.getPbData().aJx()) != null) {
            if (i == 1) {
                PraiseData se = aJx.se();
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
                        aJx.a(praiseData);
                    } else {
                        aJx.se().getUser().add(0, metaData);
                        aJx.se().setNum(aJx.se().getNum() + 1);
                        aJx.se().setIsLike(i);
                    }
                }
                if (aJx.se() != null) {
                    if (aJx.se().getNum() < 1) {
                        w = getResources().getString(w.l.frs_item_praise_text);
                    } else {
                        w = com.baidu.tbadk.core.util.au.w(aJx.se().getNum());
                    }
                    this.eiS.P(w, true);
                }
            } else if (aJx.se() != null) {
                aJx.se().setIsLike(i);
                aJx.se().setNum(aJx.se().getNum() - 1);
                ArrayList<MetaData> user = aJx.se().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aJx.se().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aJx.se().getNum() < 1) {
                    sb = getResources().getString(w.l.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(aJx.se().getNum())).toString();
                }
                this.eiS.P(sb, false);
            }
            if (this.eif.aLC()) {
                this.eiS.aNg().notifyDataSetChanged();
            } else {
                this.eiS.l(this.eif.getPbData());
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
        if (this.eif != null && this.eif.getPbData() != null && this.eiS != null) {
            this.eiS.d(this.eif.getPbData(), this.eif.aLC(), this.eif.aLT());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bNb == null) {
                this.bNb = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.bNb.ao(updateAttentionMessage.getData().toUid, this.eif.getPbData().getForumId());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eif.p(bundle);
        if (this.bMC != null) {
            this.bMC.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.eje.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.ejh = getPageContext();
        Intent intent = getIntent();
        if (intent != null) {
            this.bEG = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.eiN = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.eiN)) {
                this.eiz = true;
            }
            this.ejP = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.ejQ = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.ejR = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            this.eiZ = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
            if (aKI()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.au.isEmpty(this.source) ? "" : this.source;
            this.ejl = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            this.eiJ = intent.getBooleanExtra("is_from_push", false);
        } else {
            this.bEG = System.currentTimeMillis();
        }
        this.eiD = System.currentTimeMillis();
        this.aGw = this.eiD - this.bEG;
        super.onCreate(bundle);
        this.eiB = 0;
        r(bundle);
        if (this.eif != null && this.eif.getPbData() != null) {
            this.eif.getPbData().ns(this.source);
        }
        initUI();
        if (intent != null && this.eiS != null) {
            this.eiS.eoH = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
            if (!StringUtils.isNull(intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME))) {
                if (this.ejk == null) {
                    this.ejk = new ax(this, intent);
                }
                getSafeHandler().postDelayed(this.ejk, 1500L);
            }
        }
        this.bMC = new VoiceManager();
        this.bMC.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.pb.l lVar = new com.baidu.tbadk.editortools.pb.l();
        lVar.setForumName(this.eif.aLB());
        if (this.eif.getPbData() != null && this.eif.getPbData().aJw() != null) {
            lVar.setForumId(this.eif.getPbData().aJw().getId());
        }
        lVar.setFrom("pb");
        lVar.a(this.eif);
        this.eje = (com.baidu.tbadk.editortools.pb.c) lVar.aN(getActivity());
        this.eje.d(this);
        this.eje.a(this.aBe);
        this.eje.a(this.aAY);
        this.eje.a(this, bundle);
        this.eje.Dn().c(new com.baidu.tbadk.editortools.w(getActivity()));
        this.eje.Dn().bD(true);
        ih(true);
        this.eiS.setEditorTools(this.eje.Dn());
        this.eje.a(this.eif.aLK(), this.eif.getThreadID(), this.eif.aMd());
        registerListener(this.doD);
        if (!this.eif.aLH()) {
            this.eje.fx(this.eif.getThreadID());
        }
        if (this.eif.aMe()) {
            this.eje.fv(getPageContext().getString(w.l.pb_reply_hint_from_smart_frs));
        } else {
            this.eje.fv(getPageContext().getString(w.l.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.eiD;
        registerListener(this.ejn);
        registerListener(this.dpa);
        registerListener(this.ejo);
        registerListener(this.aOk);
        registerListener(this.bNv);
        registerListener(this.ejm);
        this.ejd = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.fvp);
        this.ejd.bhM();
        registerListener(this.ejq);
        registerListener(this.aZX);
        if (this.eif != null) {
            this.eif.aLV();
        }
        if (TbadkCoreApplication.m9getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.ejw);
        registerListener(this.ejC);
        registerListener(this.ejB);
        registerListener(this.ejT);
        this.eiK = new com.baidu.tieba.pb.pb.main.b(this.eif, this);
        if (this.eiS != null && this.eiS.aNK() != null && this.eiS.aNL() != null) {
            this.eiy = new com.baidu.tieba.pb.pb.main.a.f(getActivity(), this.eiS.aNK(), this.eiS.aNL());
            this.eiy.a(this.ejv);
        }
        if (this.eix && this.eiS != null && this.eiS.aNL() != null) {
            this.eiS.aNL().setVisibility(8);
        }
        this.eji = new com.baidu.tbadk.core.view.h();
        this.eji.ajy = 1000L;
        registerListener(this.ejz);
        registerListener(this.ejx);
        registerListener(this.ejy);
        this.ejj = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.ejj;
        userMuteAddAndDelCustomMessage.setTag(this.ejj);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.ejj;
        userMuteCheckCustomMessage.setTag(this.ejj);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public String aKo() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.f aKp() {
        return this.eiy;
    }

    private void ih(boolean z) {
        this.eje.bG(z);
        this.eje.bH(z);
        this.eje.bI(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bMC != null) {
            this.bMC.onStart(getPageContext());
        }
    }

    public ey aKq() {
        return this.eiS;
    }

    public PbModel aKr() {
        return this.eif;
    }

    public void nt(String str) {
        if (this.eif != null && !StringUtils.isNull(str) && this.eiS != null) {
            this.eiS.aNh();
            this.eiS.iS(true);
            this.eif.nt(str);
            this.eiL = true;
            this.eiS.awH();
            this.eiS.aND();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.m9getInst().isReadMenuDialogOnTop()) {
            this.eiA = false;
        } else {
            this.eiA = true;
        }
        super.onPause();
        if (this.eiS.aMO() != null && this.eiS.aMO().aKj() != null) {
            this.eiS.aMO().aKj().onPause();
        }
        BdListView listView = getListView();
        this.eiB = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.eiB == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.bMC != null) {
            this.bMC.onPause(getPageContext());
        }
        if (this.eiS != null) {
            this.eiS.onPause();
        }
        if (!this.eif.aLH()) {
            this.eje.fw(this.eif.getThreadID());
        }
        if (this.eif != null) {
            this.eif.aLW();
        }
        MessageManager.getInstance().unRegisterListener(this.cOE);
        alr();
        MessageManager.getInstance().unRegisterListener(this.ejx);
        MessageManager.getInstance().unRegisterListener(this.ejy);
        MessageManager.getInstance().unRegisterListener(this.ejz);
        MessageManager.getInstance().unRegisterListener(this.bNz);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aKs() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.eif.getPbData(), this.eif.aLC(), this.eif.aLT());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eiA = false;
        super.onResume();
        if (this.eiP) {
            this.eiP = false;
            aKO();
        }
        if (this.eiS.aMO() != null && this.eiS.aMO().aKj() != null) {
            this.eiS.aMO().aKj().onResume();
        }
        if (aKs()) {
            this.eiG = System.currentTimeMillis();
        } else {
            this.eiG = -1L;
        }
        if (this.eiS != null && this.eiS.getView() != null) {
            if (!this.dJd) {
                aKG();
            } else {
                hideLoadingView(this.eiS.getView());
            }
            this.eiS.onResume();
        }
        if (this.eiB == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.eiS != null) {
            noNetworkView = this.eiS.aMP();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.hj()) {
            noNetworkView.aL(false);
        }
        if (this.bMC != null) {
            this.bMC.onResume(getPageContext());
        }
        registerListener(this.cOE);
        this.ejc = false;
        aKN();
        registerListener(this.ejx);
        registerListener(this.ejy);
        registerListener(this.ejz);
        registerListener(this.bNz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.eiS.iG(z);
        if (this.eiX != null) {
            this.eiX.is(z);
        }
        if (z && this.ejc) {
            this.eiS.aNm();
            this.eif.io(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eiG > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10804").aa("obj_duration", new StringBuilder(String.valueOf(System.currentTimeMillis() - this.eiG)).toString()));
            this.eiG = 0L;
        }
        if (this.eje != null && this.eje.Dn() != null && this.eje.Dn().getVisibility() != 0) {
            this.eje.DX();
        }
        if (aKq().aMS() != null) {
            aKq().aMS().onStop();
        }
        if (this.eiS.eoV != null && !this.eiS.eoV.TH()) {
            this.eiS.eoV.awY();
        }
        if (this.eif != null && this.eif.getPbData() != null && this.eif.getPbData().aJw() != null && this.eif.getPbData().aJx() != null) {
            com.baidu.tbadk.distribute.a.CX().a(getPageContext().getPageActivity(), "pb", this.eif.getPbData().aJw().getId(), com.baidu.adp.lib.g.b.c(this.eif.getPbData().aJx().getId(), 0L));
        }
        if (this.bMC != null) {
            this.bMC.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.eiK != null) {
            this.eiK.destroy();
        }
        if (this.eiY && this.eif != null) {
            a(this.eif.getPbData(), -2, 0, false, false);
        }
        if (!this.eiE && this.eiS != null) {
            this.eiE = true;
            this.eiS.aNC();
            a(false, (PostData) null);
        }
        if (this.eif != null) {
            this.eif.cancelLoadData();
            this.eif.destory();
        }
        if (this.eje != null) {
            this.eje.onDestroy();
        }
        if (this.eiR != null) {
            this.eiR.cancelLoadData();
        }
        if (this.eiS != null) {
            this.eiS.onDestroy();
            if (this.eiS.eoV != null) {
                this.eiS.eoV.awY();
            }
        }
        if (this.eiF != null) {
            this.eiF.onDestroy();
        }
        if (this.eiy != null) {
            this.eiy.Xg();
        }
        super.onDestroy();
        if (this.bMC != null) {
            this.bMC.onDestory(getPageContext());
        }
        if (this.bNb != null) {
            this.bNb.destory();
        }
        this.eiS.awH();
        MessageManager.getInstance().unRegisterListener(this.ejx);
        MessageManager.getInstance().unRegisterListener(this.ejy);
        MessageManager.getInstance().unRegisterListener(this.ejz);
        MessageManager.getInstance().unRegisterListener(this.ejj);
        this.ejh = null;
        this.eji = null;
        com.baidu.tieba.recapp.d.a.bau().baw();
        if (this.ejk != null) {
            getSafeHandler().removeCallbacks(this.ejk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        cn aNg;
        ArrayList<PostData> aLd;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.ye() && this.eiS != null && (aNg = this.eiS.aNg()) != null && (aLd = aNg.aLd()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aLd.iterator();
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
                        bVar.bqw = id;
                        bVar.buM = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.YP == 1 && !TextUtils.isEmpty(id)) {
                    next.YP = 2;
                    a.b bVar2 = new a.b();
                    bVar2.bqw = id;
                    bVar2.buM = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.eif == null || this.eif.getPbData() == null || this.eif.getPbData().aJw() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.eif.getPbData().aJw().getFirst_class();
                    str2 = this.eif.getPbData().aJw().getSecond_class();
                    str = this.eif.getPbData().aJw().getId();
                    str4 = this.eif.getThreadID();
                }
                com.baidu.tieba.recapp.y.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.yi());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eiS.onChangeSkinType(i);
        if (this.eje != null && this.eje.Dn() != null) {
            this.eje.Dn().onChangeSkinType(i);
        }
        if (this.eiS.aMP() != null) {
            this.eiS.aMP().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.eiS = new ey(this, this.bOx, this.ehl);
        this.bQe = new com.baidu.tieba.e.c(getActivity());
        this.bQe.a(this.ejM);
        this.bQe.a(this.aRm);
        this.eiS.setOnScrollListener(this.mOnScrollListener);
        this.eiS.d(this.ejH);
        this.eiS.a(this.aYA);
        this.eiS.ia(com.baidu.tbadk.core.q.po().pu());
        this.eiS.setOnImageClickListener(this.aNK);
        this.eiS.a(this.atl);
        this.eiS.h(this.bLW);
        this.eiS.a(this.ejF);
        this.eiS.iG(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aV(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(w.h.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.fvR == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.q.po().pu()) {
                    return false;
                }
                return nx(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.eiS != null) {
            if (z && (!this.dJd || this.ejg)) {
                aKG();
            } else {
                hideLoadingView(this.eiS.getView());
            }
            this.ejg = false;
        }
    }

    private void aKt() {
        if (this.eiC == null) {
            this.eiC = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.eiC.a(new String[]{getPageContext().getString(w.l.call_phone), getPageContext().getString(w.l.sms_phone), getPageContext().getString(w.l.search_in_baidu)}, new ay(this)).cd(c.a.aaQ).ce(17).d(getPageContext());
        }
    }

    private void r(Bundle bundle) {
        this.eif = new PbModel(this);
        this.eif.a(this.ejA);
        if (this.eif.aMb() != null) {
            this.eif.aMb().a(this.ejO);
        }
        if (this.eif.aMa() != null) {
            this.eif.aMa().a(this.ejp);
        }
        if (bundle != null) {
            this.eif.initWithBundle(bundle);
        } else {
            this.eif.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.eif.ir(true);
        }
        ep.aMK().O(this.eif.aLA(), this.eif.getIsFromMark());
        if (StringUtils.isNull(this.eif.getThreadID())) {
            finish();
        } else {
            this.eif.FC();
        }
    }

    private void initData(Bundle bundle) {
        this.dFo = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dFo != null) {
            this.dFo.a(this.ejD);
        }
        this.eiR = new ForumManageModel(this);
        this.eiR.setLoadDataCallBack(this.ejE);
        this.eiS.a(new az(this));
        this.ejs.setUniqueId(getUniqueId());
        this.ejs.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.eiS.auv();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(w.h.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.ejj;
        userMuteCheckCustomMessage.setTag(this.ejj);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKu() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.bY(w.l.go_setting_float_window_permission);
        aVar.bZ(w.l.step_to_setting_float_permission);
        aVar.a(w.l.go_and_setting, new bb(this));
        aVar.b(w.l.cancel, new bc(this));
        aVar.b(getPageContext()).tQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aKv() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.eif != null && this.eif.getPbData() != null) {
            com.baidu.tieba.pb.data.f pbData = this.eif.getPbData();
            if (pbData.aJw() != null) {
                sb.append("forum_name=").append(nu(pbData.aJw().getName()));
                sb.append("&");
            }
            if (pbData.aJx() != null) {
                com.baidu.tbadk.core.data.bi aJx = pbData.aJx();
                sb.append("thread_id=").append(aJx.getId());
                sb.append("&");
                sb.append("thread_title=").append(nu(aJx.getTitle()));
                if (aJx.getAuthor() != null && aJx.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aJx.getAuthor().getPortrait());
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

    private String nu(String str) {
        return URLEncoder.encode(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3090=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        PostData postData;
        if (!checkUpIsLogin() || sparseArray == null || !(sparseArray.get(w.h.tag_clip_board) instanceof PostData) || (postData = (PostData) sparseArray.get(w.h.tag_clip_board)) == null || this.eif == null || this.eif.getPbData() == null || postData.bio() <= 1) {
            return;
        }
        String threadID = this.eif.getThreadID();
        String id = postData.getId();
        int aJH = this.eif.getPbData() != null ? this.eif.getPbData().aJH() : 0;
        b ny = ny(id);
        if (ny != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, aJH, postData.aPb(), this.eif.getPbData().rb(), false, postData.getAuthor() != null ? postData.getAuthor().getIconInfo() : null).addBigImageData(ny.ekl, ny.ekm, ny.ekn, ny.index)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aKw() {
        if (this.eif.getPbData() == null || this.eif.getPbData().aJx() == null) {
            return -1;
        }
        return this.eif.getPbData().aJx().sS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ii(boolean z) {
        if (this.eif == null || this.eif.getPbData() == null) {
            return false;
        }
        return ((this.eif.getPbData().aJH() != 0) || this.eif.getPbData().aJx() == null || this.eif.getPbData().aJx().getAuthor() == null || TextUtils.equals(this.eif.getPbData().aJx().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean ij(boolean z) {
        if (z) {
            return true;
        }
        if (this.eif == null || this.eif.getPbData() == null) {
            return false;
        }
        return this.eif.getPbData().aJH() != 0;
    }

    private boolean ik(boolean z) {
        return (z || this.eif == null || this.eif.getPbData() == null || this.eif.getPbData().aJH() == 0) ? false : true;
    }

    public void aKx() {
        if (this.eif != null && this.eif.getPbData() != null && this.eif.getPbData().aJx() != null && this.eif.getPbData().aJx().getAuthor() != null) {
            com.baidu.tbadk.core.data.bi aJx = this.eif.getPbData().aJx();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aJx.getAuthor().getUserId());
            GodUserData godUserData = aJx.getAuthor().getGodUserData();
            boolean z = equals && godUserData != null && godUserData.isCanSendCall();
            dt dtVar = new dt();
            if (this.eif.getPbData().aJH() == 1) {
                dtVar.emQ = true;
                dtVar.emP = true;
                dtVar.emV = aJx.sk() == 1;
                dtVar.emU = aJx.sl() == 1;
            } else {
                dtVar.emQ = false;
                dtVar.emP = false;
            }
            dtVar.emO = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteShareActivityConfig.class);
            dtVar.emM = TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            dtVar.emR = ij(equals);
            dtVar.emS = aKy();
            dtVar.emT = ik(equals);
            dtVar.emN = this.eif.aLC();
            dtVar.egB = this.dFo != null ? this.dFo.oe() : false;
            dtVar.emL = ii(equals);
            dtVar.emJ = equals && this.eiS.aNu();
            dtVar.emK = z;
            dtVar.isHostOnly = this.eif.getHostMode();
            if (aJx.sF() == null) {
                dtVar.emW = false;
            } else {
                dtVar.emW = true;
            }
            this.eiS.eoV.a(dtVar);
        }
    }

    private boolean aKy() {
        if (this.eif != null && this.eif.aLC()) {
            return this.eif.alU() == null || this.eif.alU().ro() != 0;
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
        if (fVar != null && this.eif != null) {
            eg egVar = new eg(getUniqueId());
            egVar.pbData = fVar;
            egVar.threadId = this.eif.getThreadID();
            egVar.postId = this.eif.getPostId();
            egVar.eoa = i;
            egVar.eob = i2;
            egVar.enZ = this.eif.getHostMode();
            egVar.egB = this.eif.oe();
            egVar.isSquence = this.eif.aLC();
            egVar.loadType = this.eif.aLY();
            egVar.eoc = z;
            egVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, egVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, boolean z2) {
        if (fVar != null && this.eif != null) {
            eg egVar = new eg(getUniqueId());
            egVar.pbData = fVar;
            egVar.threadId = this.eif.getThreadID();
            egVar.postId = this.eif.getPostId();
            egVar.eoa = i;
            egVar.enZ = this.eif.getHostMode();
            egVar.egB = this.eif.oe();
            egVar.isSquence = this.eif.aLC();
            egVar.loadType = this.eif.aLY();
            egVar.eoc = z;
            egVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, egVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        awp();
    }

    public void a(boolean z, MarkData markData) {
        this.eiS.aNn();
        this.eif.iq(z);
        if (this.dFo != null) {
            this.dFo.ae(z);
            if (markData != null) {
                this.dFo.a(markData);
            }
        }
        if (this.eif.oe()) {
            aKE();
        } else {
            this.eiS.k(this.eif.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ob(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nv(String str) {
        if (!StringUtils.isNull(str) && this.eif != null) {
            String threadID = this.eif.getThreadID();
            String id = this.eif.getPbData().aJw().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(w.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.eif.aLH()) {
                    antiData.setBlock_forum_name(this.eif.getPbData().aJw().getName());
                    antiData.setBlock_forum_id(this.eif.getPbData().aJw().getId());
                    antiData.setUser_name(this.eif.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.eif.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.rX(i)) {
            AntiHelper.aq(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            fD(str);
        } else {
            this.eiS.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.eiS.a(0, bVar.AJ, bVar.fya, z);
            if (bVar.AJ) {
                if (bVar.fxY == 1) {
                    ArrayList<PostData> aJz = this.eif.getPbData().aJz();
                    int size = aJz.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aJz.get(i).getId())) {
                            i++;
                        } else {
                            aJz.remove(i);
                            break;
                        }
                    }
                    this.eiS.k(this.eif.getPbData());
                } else if (bVar.fxY == 0) {
                    aKz();
                } else if (bVar.fxY == 2) {
                    ArrayList<PostData> aJz2 = this.eif.getPbData().aJz();
                    int size2 = aJz2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aJz2.get(i2).bil().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aJz2.get(i2).bil().get(i3).getId())) {
                                i3++;
                            } else {
                                aJz2.get(i2).bil().remove(i3);
                                aJz2.get(i2).bin();
                                z2 = true;
                                break;
                            }
                        }
                        aJz2.get(i2).qd(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.eiS.k(this.eif.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.f fVar) {
        if (fVar != null) {
            this.eiS.a(this.eiR.getLoadDataMode(), fVar.AJ, fVar.fya, false);
            if (fVar.AJ) {
                this.eiU = true;
                if (i == 2 || i == 3) {
                    this.eiV = true;
                    this.eiW = false;
                } else if (i == 4 || i == 5) {
                    this.eiV = false;
                    this.eiW = true;
                }
                if (i == 2) {
                    this.eif.getPbData().aJx().bU(1);
                    this.eif.setIsGood(1);
                } else if (i == 3) {
                    this.eif.getPbData().aJx().bU(0);
                    this.eif.setIsGood(0);
                } else if (i == 4) {
                    this.eif.getPbData().aJx().bT(1);
                    this.eif.gV(1);
                } else if (i == 5) {
                    this.eif.getPbData().aJx().bT(0);
                    this.eif.gV(0);
                }
                this.eiS.d(this.eif.getPbData(), this.eif.aLC());
                com.baidu.tieba.c.a.a(getPageContext(), 2, i);
            }
        }
    }

    private void aKz() {
        if (this.eif.aLD() || this.eif.aLE()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.eif.getThreadID());
            setResult(-1, intent);
        }
        if (aKF()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKA() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aJF;
        if (this.eiS != null) {
            this.eiS.awH();
        }
        if (this.eif != null && this.eif.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.eif.getPbData().aJx().getId();
            historyMessage.forumName = this.eif.getPbData().aJw().getName();
            historyMessage.threadName = this.eif.getPbData().aJx().getTitle();
            ArrayList<PostData> aJz = this.eif.getPbData().aJz();
            int aNp = this.eiS != null ? this.eiS.aNp() : 0;
            if (aJz != null && aNp >= 0 && aNp < aJz.size()) {
                historyMessage.postID = aJz.get(aNp).getId();
            }
            historyMessage.isHostOnly = this.eif.getHostMode();
            historyMessage.isSquence = this.eif.aLC();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.eje != null) {
            this.eje.onDestroy();
        }
        if (this.eif != null && (this.eif.aLD() || this.eif.aLE() || this.eif.aLF())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.eif.getThreadID());
            if (this.eiU) {
                if (this.eiW) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.eif.awy());
                }
                if (this.eiV) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.eif.getIsGood());
                }
            }
            if (this.eif.getPbData() != null && System.currentTimeMillis() - this.eiD >= 40000 && (aJF = this.eif.getPbData().aJF()) != null && !com.baidu.tbadk.core.util.x.q(aJF.getDataList())) {
                intent.putExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA, aJF);
                intent.putExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, this.ejl);
            }
            setResult(-1, intent);
        }
        if (aKF()) {
            if (this.eif != null && this.eiS != null && this.eiS.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.eif.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.m9getInst().getDefaultBubble());
                    }
                    if (!pbData.aJE() && !this.eiL) {
                        ep.aMK().a(this.eif.getPbData(), this.eiS.getListView().onSaveInstanceState(), this.eif.aLC(), this.eif.getHostMode());
                    }
                }
            } else {
                ep.aMK().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.eiS == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.eiS.ot(i)) {
            return true;
        }
        switch (i) {
            case 4:
                if (this.eiS.aLv()) {
                    this.eiS.aLx();
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
            TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(w.l.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.eje.onActivityResult(i, i2, intent);
        if (aKq().aMS() != null) {
            aKq().aMS().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aKD();
                    return;
                case 13008:
                    ep.aMK().reset();
                    this.mHandler.postDelayed(new be(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.eif != null) {
                        a(aKC(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                    if (aKw() == 1) {
                        aKB();
                        return;
                    }
                    return;
                case 24008:
                    this.eiS.m24if(false);
                    if (this.eif.getPbData() != null && this.eif.getPbData().aJx() != null && this.eif.getPbData().aJx().sI() != null) {
                        this.eif.getPbData().aJx().sI().setStatus(2);
                        break;
                    }
                    break;
                case 25001:
                    break;
                default:
                    return;
            }
            if (this.eiK != null) {
                this.eiK.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aKq() != null && aKm() != null && aKq().aMU() && com.baidu.tbadk.editortools.pb.a.DK().getStatus() == 1) {
                    com.baidu.tbadk.editortools.pb.a.DK().setStatus(0);
                    if (this.eiS != null) {
                        this.eiS.aMT();
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
    public void aKB() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.eif.getPbData() != null && this.eif.getPbData().aJx() != null && this.eif.getPbData().aJx().sz() != null && this.eif.getPbData().aJx().sz().size() > 0 && this.eif.getPbData().aJx().sz().get(0) != null) {
            this.mAwardActId = this.eif.getPbData().aJx().sz().get(0).pJ();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.eif.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void P(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra(GetLotteryChanceActivityConfig.KEY_ACTION, 0)) {
                case 1:
                    aqQ();
                    return;
                case 2:
                    this.eiS.aNe();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aKC() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bD = this.eif.getPbData().bD(getPageContext().getPageActivity());
        PostData aMV = this.eiS.aMV();
        String str = "";
        if (aMV != null) {
            str = aMV.getId();
            String bN = aMV.bN(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(bN)) {
                bD[1] = bN;
            }
        }
        String sE = this.eif.getPbData().aJx().sE();
        if (sE != null && sE.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bD[1]);
        shareFromPBMsgData.setImageUrl(bD[0]);
        shareFromPBMsgData.setForumName(this.eif.getPbData().aJw().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.eif.getPbData().aJx().getId());
        shareFromPBMsgData.setTitle(this.eif.getPbData().aJx().getTitle());
        return shareFromPBMsgData;
    }

    private void Q(Intent intent) {
        a(aKC(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.eif != null && this.eif.getPbData() != null && this.eif.getPbData().aJx() != null) {
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
                gqVar.G(shareFromPBMsgData.getImageUrl(), this.eif.getPbData().aJI() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.eif != null && this.eif.getPbData() != null && this.eif.getPbData().aJx() != null) {
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
                gqVar.G(shareFromPBMsgData.getImageUrl(), this.eif.getPbData().aJI() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKD() {
        MarkData on;
        if (this.dFo != null && (on = this.eif.on(this.eiS.aNq())) != null) {
            if (!on.isApp() || (on = this.eif.on(this.eiS.aNq() + 1)) != null) {
                this.eiS.aNl();
                this.dFo.a(on);
                if (!this.dFo.oe()) {
                    this.dFo.og();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.dFo.of();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKE() {
        com.baidu.tieba.pb.data.f pbData = this.eif.getPbData();
        this.eif.iq(true);
        pbData.nr(this.dFo.od());
        this.eiS.k(pbData);
    }

    private boolean aKF() {
        if (this.eif == null) {
            return true;
        }
        if (this.eif.oe()) {
            MarkData aLP = this.eif.aLP();
            if (aLP == null || !this.eif.getIsFromMark()) {
                return true;
            }
            MarkData on = this.eif.on(this.eiS.aNq());
            if (on == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aLP);
                setResult(-1, intent);
                return true;
            } else if (on.getPostId() == null || on.getPostId().equals(aLP.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aLP);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cE(String.format(getPageContext().getString(w.l.alert_update_mark), Integer.valueOf(on.getFloor())));
                aVar.a(w.l.confirm, new bj(this, on, aLP, aVar));
                aVar.b(w.l.alert_no_button, new bk(this, aLP, aVar));
                aVar.a(new bm(this, aLP, aVar));
                aVar.b(getPageContext());
                aVar.tQ();
                return false;
            }
        } else if (this.eif.getPbData() == null || this.eif.getPbData().aJz() == null || this.eif.getPbData().aJz().size() <= 0 || !this.eif.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.eiS == null) {
            return null;
        }
        return this.eiS.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int IR() {
        if (this.eiS == null) {
            return 0;
        }
        return this.eiS.aNx();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> IS() {
        if (this.aNq == null) {
            this.aNq = new com.baidu.adp.lib.e.b<>(new bn(this), 8, 0);
        }
        return this.aNq;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> IT() {
        if (this.aNr == null) {
            this.aNr = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aNr;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> IU() {
        if (this.aNv == null) {
            this.aNv = new com.baidu.adp.lib.e.b<>(new bo(this), 20, 0);
        }
        return this.aNv;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IV() {
        if (this.aNt == null) {
            this.aNt = new com.baidu.adp.lib.e.b<>(new bp(this), 8, 0);
        }
        return this.aNt;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IX() {
        if (this.aNs == null) {
            this.aNs = com.baidu.tieba.graffiti.d.o(getPageContext().getPageActivity(), 6);
        }
        return this.aNs;
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
        this.eiI = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        if (gr.nJ(str) && this.eif != null && this.eif.getThreadID() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11664").s("obj_param1", 1).aa("post_id", this.eif.getThreadID()));
        }
        gr.aNT().g(getPageContext(), str);
        this.eiI = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        gr.aNT().g(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.eiI = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ac(Context context, String str) {
        com.baidu.tbadk.core.util.bb.wn().c(getPageContext(), new String[]{str});
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.eiI = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ab(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        TbRichTextData tbRichTextData;
        int a2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.eif.getPbData();
            TbRichText am = am(str, i);
            if (am != null && (tbRichTextData = am.Io().get(this.ejI)) != null) {
                bVar.ekl = new ArrayList<>();
                bVar.ekm = new ConcurrentHashMap<>();
                if (!tbRichTextData.Iu().IG()) {
                    bVar.eko = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    bVar.ekl.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.postId = am.getPostId();
                    imageUrlData.mIsReserver = this.eif.aLO();
                    imageUrlData.mIsSeeHost = this.eif.getHostMode();
                    bVar.ekm.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aJw() != null) {
                            bVar.forumName = pbData.aJw().getName();
                            bVar.forumId = pbData.aJw().getId();
                        }
                        if (pbData.aJx() != null) {
                            bVar.threadId = pbData.aJx().getId();
                        }
                        bVar.ekn = pbData.aJI() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.eko = true;
                int size = pbData.aJz().size();
                this.ejJ = false;
                bVar.index = -1;
                int i2 = 0;
                int i3 = i;
                while (i2 < size) {
                    PostData postData = pbData.aJz().get(i2);
                    TbRichText awl = postData.awl();
                    if (!ex.g(postData)) {
                        a2 = a(awl, am, i3, i, bVar.ekl, bVar.ekm);
                    } else {
                        a2 = a(postData, i3, bVar.ekl, bVar.ekm);
                    }
                    i2++;
                    i3 = a2;
                }
                if (bVar.ekl.size() > 0) {
                    bVar.lastId = bVar.ekl.get(bVar.ekl.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aJw() != null) {
                        bVar.forumName = pbData.aJw().getName();
                        bVar.forumId = pbData.aJw().getId();
                    }
                    if (pbData.aJx() != null) {
                        bVar.threadId = pbData.aJx().getId();
                    }
                    bVar.ekn = pbData.aJI() == 1;
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
            this.ejJ = true;
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
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eif.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.eif.aLO();
                                imageUrlData.mIsSeeHost = this.eif.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.ejJ) {
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
        com.baidu.tieba.tbadkCore.data.h biw;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bhQ;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bhQ = (biw = postData.biw()).bhQ()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bhQ.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bhQ.get(i3);
                if (jVar != null) {
                    String bhX = jVar.bhX();
                    if (!com.baidu.tbadk.core.util.au.isEmpty(bhX)) {
                        arrayList.add(bhX);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bhX;
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        imageUrlData.originalUrl = jVar.bhV();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eif.getThreadID(), -1L);
                        imageUrlData.mIsReserver = this.eif.aLO();
                        imageUrlData.mIsSeeHost = this.eif.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = biw.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bhX, imageUrlData);
                        }
                        if (!this.ejJ) {
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
            if (postData.getId() != null && postData.getId().equals(this.eif.sx())) {
                z = true;
            }
            MarkData e = this.eif.e(postData);
            if (e != null) {
                this.eiS.aNl();
                if (this.dFo != null) {
                    this.dFo.a(e);
                    if (!z) {
                        this.dFo.og();
                    } else {
                        this.dFo.of();
                    }
                }
            }
        }
    }

    private TbRichText am(String str, int i) {
        if (this.eif == null || this.eif.getPbData() == null || str == null || i < 0) {
            return null;
        }
        return a(this.eif.getPbData().aJz(), str, i);
    }

    private long nw(String str) {
        ArrayList<PostData> aJz;
        com.baidu.tieba.pb.data.f pbData = this.eif.getPbData();
        if (pbData != null && (aJz = pbData.aJz()) != null && !aJz.isEmpty()) {
            Iterator<PostData> it = aJz.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h biw = next.biw();
                if (biw != null && biw.fvx) {
                    Iterator<TbRichTextData> it2 = next.awl().Io().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.IC().getLink().equals(str)) {
                            return biw.getTemplateId();
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
            TbRichText awl = arrayList.get(i2).awl();
            if (awl != null && (Io = awl.Io()) != null) {
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
                            this.ejI = i4;
                            return awl;
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
            this.eid = str;
            if (this.eiC == null) {
                aKt();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.eiC.cg(1).setVisibility(8);
            } else {
                this.eiC.cg(1).setVisibility(0);
            }
            this.eiC.tT();
            this.eiI = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bMC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awp() {
        hideNetRefreshView(this.eiS.getView());
        aKG();
        if (this.eif.FC()) {
            this.eiS.aNl();
        }
    }

    private void aKG() {
        showLoadingView(this.eiS.getView(), false, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds400));
        View EZ = getLoadingView().EZ();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EZ.getLayoutParams();
        layoutParams.addRule(3, this.eiS.aNK().getId());
        EZ.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zp() {
        if (this.bMC != null) {
            this.bMC.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void od(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqQ() {
        if (this.eif.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.eif.getPbData();
            String name = pbData.aJw().getName();
            String title = pbData.aJx().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.eif.getThreadID() + "?share=9105&fr=share&see_lz=" + (this.eif.getHostMode() ? 1 : 0);
            String[] bD = pbData.bD(getPageContext().getPageActivity());
            String str2 = bD[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = bD[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (aKw() == 1) {
                if (pbData != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10399").aa("fid", pbData.getForumId()).aa("tid", pbData.getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
                }
            } else if (aKw() == 2 && pbData != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10406").aa("fid", pbData.getForumId()).aa("tid", pbData.getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(w.l.share_content_tpl), title, name, str3);
            com.baidu.tbadk.coreExtra.share.g gVar = new com.baidu.tbadk.coreExtra.share.g();
            gVar.title = title;
            gVar.content = format;
            gVar.linkUrl = str;
            gVar.ase = true;
            gVar.extData = this.eif.getThreadID();
            if (parse != null) {
                gVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), gVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(w.l.forum_friend, w.g.icon_unite_share_baf, new bq(this));
            shareDialogConfig.setCopyLinkListener(new br(this, gVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> IW() {
        if (this.aNu == null) {
            this.aNu = new com.baidu.adp.lib.e.b<>(new bs(this), 15, 0);
        }
        return this.aNu;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.eiS.aNf() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10517").s("obj_locate", 2).aa("fid", this.eif.getPbData().getForumId()));
            } else {
                com.baidu.tbadk.core.data.bi aJx = this.eif.getPbData().aJx();
                if (view != null) {
                    boolean z = aJx.se() == null || aJx.se().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.ejt > 1000) {
                            this.eju = true;
                            aX(view);
                        } else {
                            this.eju = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            e(view, this.eju);
                        } else {
                            d(view, this.eju);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        d(view, this.eju);
                    } else if (motionEvent.getAction() == 3) {
                        d(view, this.eju);
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

    public void Zq() {
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
            int intValue = ((Integer) sparseArray.get(ey.eqG)).intValue();
            if (intValue == ey.eqH) {
                if (!this.eiR.bja()) {
                    this.eiS.aNi();
                    int intValue2 = ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue();
                    this.eiR.a(this.eif.getPbData().aJw().getId(), this.eif.getPbData().aJw().getName(), this.eif.getPbData().aJx().getId(), (String) sparseArray.get(w.h.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == ey.eqI || intValue == ey.eqK) {
                if (this.eif.aMb() != null) {
                    this.eif.aMb().og(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ey.eqI) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == ey.eqJ) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.ejN).pE()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.ejj);
        userMuteAddAndDelCustomMessage.setTag(this.ejj);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean nx(String str) {
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

    public void il(boolean z) {
        this.ejc = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aKH() {
        ArrayList<PostData> aJz;
        int p;
        if (this.eif == null || this.eif.getPbData() == null || this.eif.getPbData().aJz() == null || (p = com.baidu.tbadk.core.util.x.p((aJz = this.eif.getPbData().aJz()))) == 0) {
            return "";
        }
        int aNp = this.eiS.aNp();
        PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(aJz, aNp);
        if (postData == null || postData.getAuthor() == null) {
            return "";
        }
        if (this.eif.nB(postData.getAuthor().getUserId())) {
            return postData.getId();
        }
        for (int i = aNp - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.x.c(aJz, i);
            if (postData2 == null || postData2.getAuthor() == null || postData2.getAuthor().getUserId() == null) {
                break;
            } else if (this.eif.nB(postData2.getAuthor().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = aNp + 1; i2 < p; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.x.c(aJz, i2);
            if (postData3 == null || postData3.getAuthor() == null || postData3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.eif.nB(postData3.getAuthor().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ad(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.bb.wn().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.b.a(nw(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.eif.getPbData().aJw().getId(), this.eif.getPbData().aJw().getName(), this.eif.getPbData().aJx().getTid());
            }
            this.eiI = true;
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
    public b ny(String str) {
        String str2;
        if (this.eif.getPbData() == null || this.eif.getPbData().aJz() == null || this.eif.getPbData().aJz().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i < this.eif.getPbData().aJz().size()) {
                if (str.equals(this.eif.getPbData().aJz().get(i).getId())) {
                    break;
                }
                i++;
            } else {
                i = 0;
                break;
            }
        }
        PostData postData = this.eif.getPbData().aJz().get(i);
        if (postData.awl() == null || postData.awl().Io() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.awl().Io().iterator();
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
        if (this.eiz) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.eiz = false;
        } else if (aKI()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eiz) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.eiz = false;
        } else if (aKI()) {
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
        if (pageStayDurationItem != null && this.eif != null) {
            if (this.eif.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eif.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eif.getThreadID(), 0L));
            if (this.eiJ) {
                pageStayDurationItem.objParam1 = "1";
            }
        }
        return pageStayDurationItem;
    }

    public boolean aKI() {
        return (!this.eix && this.ejP == -1 && this.ejQ == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.ejS = nVar;
            this.eix = true;
            this.eiS.aMW();
            this.eiS.nH(this.ejR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKJ() {
        if (this.ejS != null) {
            if (this.ejP == -1) {
                showToast(w.l.pb_manga_not_prev_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.ejS.getCartoonId(), this.ejP, 0)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKK() {
        if (this.ejS != null) {
            if (this.ejQ == -1) {
                showToast(w.l.pb_manga_not_next_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.ejS.getCartoonId(), this.ejQ, 0)));
            finish();
        }
    }

    public int aKL() {
        return this.ejP;
    }

    public int aKM() {
        return this.ejQ;
    }

    private void alr() {
        if (this.eif != null && this.eif.getPbData() != null && this.eif.getPbData().aJx() != null && this.eif.getPbData().aJx().tb()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aKN() {
        if (this.eif != null && this.eif.getPbData() != null && this.eif.getPbData().aJx() != null && this.eif.getPbData().aJx().tb()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aKO() {
        if (this.eiA) {
            this.eiP = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.eif.getPbData() != null && this.eif.getPbData().aJx() != null && this.eif.getPbData().aJx().rX() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.eif.getPbData().aJx().rX().getThreadId(), this.eif.getPbData().aJx().rX().getTaskId(), this.eif.getPbData().aJx().rX().getForumId(), this.eif.getPbData().aJx().rX().getForumName(), this.eif.getPbData().aJx().sk(), this.eif.getPbData().aJx().sl())));
            this.eiz = true;
            finish();
        }
    }

    public boolean aKP() {
        return this.eiA;
    }

    public String aKQ() {
        return this.eiN;
    }

    public PbInterviewStatusView.a aKR() {
        return this.eiQ;
    }

    public void im(boolean z) {
        this.eiO = z;
    }

    public boolean aKS() {
        if (this.eif != null) {
            return this.eif.aLD();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKT() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cE(getResources().getString(w.l.mute_is_super_member_function));
        aVar.a(w.l.open_now, new by(this));
        aVar.b(w.l.cancel, new bz(this));
        aVar.b(this.ejh).tQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD(String str) {
        if (str == null) {
            str = "";
        }
        if (this.ejh != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ejh.getPageActivity());
            aVar.cE(str);
            aVar.b(w.l.know, new ca(this));
            aVar.b(this.ejh).tQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eiS.auv();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ejh.getPageActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.cE(this.ejh.getResources().getString(w.l.block_mute_message_alert, str2));
        } else {
            aVar.cE(str);
        }
        aVar.a(w.l.confirm, new cb(this, userMuteAddAndDelCustomMessage));
        aVar.b(w.l.cancel, new cc(this));
        aVar.b(this.ejh).tQ();
    }

    public void aKU() {
        if (this.eif != null && this.eif.getPbData() != null && this.eif.getPbData().aJx() != null && this.eif.getPbData().aJx().ts() != null) {
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
                if (gr.nJ(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_pb_wenxue)) != null) {
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
            this.eiM = true;
        } else {
            this.eiM = false;
        }
        if (this.eiS != null) {
            this.eiS.onConfigurationChanged(configuration);
        }
        if (this.eiX != null) {
            this.eiX.dismiss();
        }
    }
}
