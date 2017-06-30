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
import com.baidu.tbadk.KuangFloatingViewController;
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.e.a;
import com.baidu.tieba.e.c;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.a.f;
import com.baidu.tieba.pb.pb.main.dm;
import com.baidu.tieba.pb.pb.main.dv;
import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.ew;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
import com.baidu.tieba.pb.share.AddExperiencedModel;
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
import tbclient.MemeInfo;
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.b, com.baidu.tbadk.widget.richText.d {
    private com.baidu.adp.lib.e.b<ImageView> aOX;
    private com.baidu.adp.lib.e.b<TextView> aOY;
    private com.baidu.adp.lib.e.b<View> aOZ;
    private com.baidu.adp.lib.e.b<View> aPa;
    private com.baidu.adp.lib.e.b<LinearLayout> aPb;
    private com.baidu.adp.lib.e.b<GifView> aPc;
    private com.baidu.adp.lib.e.b<TbImageView> anq;
    private com.baidu.tbadk.h.a ccC;
    private VoiceManager cci;
    private com.baidu.tieba.e.c cfe;
    private com.baidu.tbadk.core.dialog.a euC;
    private boolean euJ;
    private com.baidu.tieba.pb.pb.main.b euL;
    private com.baidu.tieba.pb.pb.main.emotion.model.a euR;
    private eu euZ;
    private String euc;
    private com.baidu.tieba.pb.pb.main.a.f euw;
    private boolean evS;
    private boolean eve;
    private com.baidu.tieba.tbadkCore.data.e evg;
    private com.baidu.tbadk.editortools.pb.c evh;
    private com.baidu.adp.base.g evk;
    private com.baidu.tbadk.core.view.h evl;
    private BdUniqueId evm;
    private Runnable evn;
    private hs evp;
    private com.baidu.adp.widget.a.a evq;
    private String evr;
    private TbRichTextMemeInfo evs;
    private String ewe;
    private com.baidu.tbadk.core.data.o ewf;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean euv = false;
    private boolean eux = false;
    private boolean euy = false;
    private boolean dTL = false;
    private boolean euz = true;
    private int euA = 0;
    private com.baidu.tbadk.core.dialog.c euB = null;
    private long bTh = -1;
    private long aHL = 0;
    private long euD = 0;
    private long createTime = 0;
    private long aHD = 0;
    private boolean euE = false;
    private com.baidu.tbadk.j.e euF = null;
    private long euG = 0;
    private boolean euH = false;
    private boolean euI = false;
    private long euK = 0;
    private String aBJ = null;
    private boolean euM = false;
    private boolean euN = false;
    private String euO = "";
    private boolean euP = true;
    private boolean euQ = false;
    private String source = "";
    private PbInterviewStatusView.a euS = new i(this);
    private final Handler mHandler = new Handler(new t(this));
    private PbModel eue = null;
    private com.baidu.tbadk.baseEditMark.a dPW = null;
    private ForumManageModel euT = null;
    private gg euU = null;
    public final com.baidu.tieba.pb.pb.main.a.a euV = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean euW = false;
    private boolean euX = false;
    private boolean euY = false;
    private boolean eva = false;
    private boolean evb = false;
    private boolean evc = false;
    private boolean evd = false;
    private boolean evf = false;
    private boolean evi = false;
    private com.baidu.tbadk.editortools.pb.b aBN = new ae(this);
    private boolean evj = false;
    private int mLastScrollState = -1;
    private int evo = 4;
    private boolean ccO = false;
    private int evt = -1;
    private final ew.a evu = new ap(this);
    private final CustomMessageListener evv = new ba(this, CmdConfigCustom.PB_RESET_EDITOR_TOOL);
    CustomMessageListener ccZ = new bl(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private CustomMessageListener evw = new bw(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener dzg = new ch(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener dzC = new cq(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener evx = new j(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener cYr = new k(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private dm.a evy = new l(this);
    private View.OnClickListener dzf = new m(this);
    CustomMessageListener cIw = new n(this, CmdConfigCustom.CMD_SHOW_NICK_NAME_ACT);
    private CustomMessageListener evz = new o(this, CmdConfigCustom.CMD_SEND_GIFT_SUCCESS);
    private SuggestEmotionModel.a evA = new p(this);
    private com.baidu.tieba.pb.pb.main.emotion.a evB = new q(this);
    private boolean evC = false;
    private PraiseModel evD = new PraiseModel(getPageContext(), new r(this));
    private long evE = 0;
    private boolean evF = true;
    private f.a evG = new s(this);
    private CustomMessageListener bdP = new u(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CheckRealNameModel.a bkl = new v(this);
    private CustomMessageListener evH = new w(this, CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED);
    private com.baidu.tieba.pb.a.d aPs = new com.baidu.tieba.pb.a.d(new x(this));
    private CustomMessageListener evI = new y(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener evJ = new z(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener evK = new aa(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    public CustomMessageListener evL = new ab(this, CmdConfigCustom.PB_FIRST_FLOOR_PRAISE);
    private CustomMessageListener cdk = new ac(this, CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED);
    public a.b edT = new ad(this);
    public final View.OnClickListener cdH = new af(this);
    private final NewWriteModel.d aBU = new ag(this);
    private final PbModel.a evM = new ah(this);
    private CustomMessageListener evN = new ai(this, CmdConfigCustom.CMD_WX_SHARE_SUCCESS);
    private CustomMessageListener evO = new aj(this, CmdConfigCustom.CMD_TTS_OPTION_PB);
    private final a.InterfaceC0035a evP = new ak(this);
    private final AbsListView.OnScrollListener mOnScrollListener = new al(this);
    private final com.baidu.adp.base.f evQ = new am(this);
    private final c evR = new an(this);
    private final ae.b aXU = new ao(this);
    private final BdListView.e evT = new aq(this);
    private int evU = 0;
    private final TbRichTextView.e aPr = new ar(this);
    boolean evV = false;
    PostData evW = null;
    private final c.b evX = new as(this);
    private final c.b evY = new at(this);
    private final View.OnLongClickListener aue = new au(this);
    private final NoNetworkView.a bzE = new av(this);
    public View.OnTouchListener aKv = new aw(this);
    private a.InterfaceC0062a bQR = new ax(this);
    private final c.a evZ = new ay(this);
    private String ewa = null;
    private final dv.a ewb = new az(this);
    private int ewc = -1;
    private int ewd = -1;
    private CustomMessageListener ewg = new bb(this, CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST);
    private final CustomMessageListener cdd = new bc(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);
    private f.b IG = new bd(this);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public boolean ewB;
        public ArrayList<String> ewy;
        public ConcurrentHashMap<String, ImageUrlData> ewz;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean ewA = false;
        public boolean ewC = false;
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

    public com.baidu.tbadk.editortools.pb.c aNu() {
        return this.evh;
    }

    public void b(com.baidu.tieba.pb.data.n nVar) {
        if (nVar.aNd() != null) {
            String id = nVar.aNd().getId();
            ArrayList<PostData> aMx = this.eue.getPbData().aMx();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aMx.size()) {
                    break;
                }
                PostData postData = aMx.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aNh = nVar.aNh();
                    postData.sE(nVar.getTotalCount());
                    if (postData.bmr() != null) {
                        postData.bmr().clear();
                        postData.bmr().addAll(aNh);
                    }
                }
            }
            this.euU.l(this.eue.getPbData());
            c(nVar);
        }
    }

    public void aNv() {
        com.baidu.tieba.pb.data.f pbData;
        com.baidu.tbadk.core.data.bm aMv;
        if (!this.evC) {
            if (!com.baidu.adp.lib.util.k.hA()) {
                showToast(w.l.no_network_guide);
            } else if (this.evF) {
                this.evC = true;
                if (this.eue != null && (pbData = this.eue.getPbData()) != null && (aMv = pbData.aMv()) != null) {
                    int isLike = aMv.rh() == null ? 0 : aMv.rh().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10796").Z("tid", aMv.getId()));
                    }
                    if (this.evD != null) {
                        this.evD.a(aMv.rH(), aMv.getId(), isLike, "pb");
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
                    cVar.a(strArr, new be(this, sparseArray, z, str2, str));
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(w.l.un_mute) : getResources().getString(w.l.mute);
                    cVar.a(strArr2, new bf(this, sparseArray, z, str2, str));
                }
                cVar.d(getPageContext()).td();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iO(int i) {
        com.baidu.tbadk.core.data.bm aMv;
        String sb;
        String y;
        if (this.eue != null && this.eue.getPbData() != null && (aMv = this.eue.getPbData().aMv()) != null) {
            if (i == 1) {
                PraiseData rh = aMv.rh();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rh == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aMv.a(praiseData);
                    } else {
                        aMv.rh().getUser().add(0, metaData);
                        aMv.rh().setNum(aMv.rh().getNum() + 1);
                        aMv.rh().setIsLike(i);
                    }
                }
                if (aMv.rh() != null) {
                    if (aMv.rh().getNum() < 1) {
                        y = getResources().getString(w.l.frs_item_praise_text);
                    } else {
                        y = com.baidu.tbadk.core.util.aw.y(aMv.rh().getNum());
                    }
                    this.euU.R(y, true);
                }
            } else if (aMv.rh() != null) {
                aMv.rh().setIsLike(i);
                aMv.rh().setNum(aMv.rh().getNum() - 1);
                ArrayList<MetaData> user = aMv.rh().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aMv.rh().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aMv.rh().getNum() < 1) {
                    sb = getResources().getString(w.l.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(aMv.rh().getNum())).toString();
                }
                this.euU.R(sb, false);
            }
            if (this.eue.aOK()) {
                this.euU.aQs().notifyDataSetChanged();
            } else {
                this.euU.m(this.eue.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().aqH && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        if (this.eue != null && this.eue.getPbData() != null && this.euU != null) {
            this.euU.d(this.eue.getPbData(), this.eue.aOK(), this.eue.aPa());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eue.p(bundle);
        if (this.cci != null) {
            this.cci.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.evh.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.evk = getPageContext();
        Intent intent = getIntent();
        if (intent != null) {
            this.bTh = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.euO = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.euO)) {
                this.eux = true;
            }
            this.ewc = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.ewd = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.ewe = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            this.evb = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
            this.evf = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_GOD_REPLY, false);
            if (aNU()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.aw.isEmpty(this.source) ? "" : this.source;
            this.evt = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            this.euJ = intent.getBooleanExtra("is_from_push", false);
        } else {
            this.bTh = System.currentTimeMillis();
        }
        this.euD = System.currentTimeMillis();
        this.aHD = this.euD - this.bTh;
        super.onCreate(bundle);
        this.mSwipeBackLayout.setOnSlidingStateChangeListener(this.IG);
        this.euA = 0;
        r(bundle);
        if (this.eue != null && this.eue.getPbData() != null) {
            this.eue.getPbData().oF(this.source);
        }
        initUI();
        if (intent != null && this.euU != null) {
            this.euU.eBH = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
            if (!StringUtils.isNull(intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME))) {
                if (this.evn == null) {
                    this.evn = new bg(this, intent);
                }
                getSafeHandler().postDelayed(this.evn, 1500L);
            }
        }
        this.cci = new VoiceManager();
        this.cci.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.pb.l lVar = new com.baidu.tbadk.editortools.pb.l();
        lVar.setForumName(this.eue.aOJ());
        if (this.eue.getPbData() != null && this.eue.getPbData().aMt() != null) {
            lVar.setForumId(this.eue.getPbData().aMt().getId());
        }
        lVar.setFrom("pb");
        lVar.a(this.eue);
        this.evh = (com.baidu.tbadk.editortools.pb.c) lVar.aQ(getActivity());
        this.evh.d(this);
        this.evh.a(this.aBU);
        this.evh.a(this.aBN);
        this.evh.a(this, bundle);
        this.evh.CG().c(new com.baidu.tbadk.editortools.w(getActivity()));
        this.evh.CG().bB(true);
        iB(true);
        this.euU.setEditorTools(this.evh.CG());
        this.evh.a(this.eue.aOR(), this.eue.getThreadID(), this.eue.aPn());
        registerListener(this.dzg);
        if (!this.eue.aOO()) {
            this.evh.fM(this.eue.getThreadID());
        }
        if (this.eue.aPo()) {
            this.evh.fK(getPageContext().getString(w.l.pb_reply_hint_from_smart_frs));
        } else {
            this.evh.fK(getPageContext().getString(w.l.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.euD;
        registerListener(this.evw);
        registerListener(this.dzC);
        registerListener(this.evx);
        registerListener(this.ccZ);
        registerListener(this.evL);
        registerListener(this.evv);
        this.evg = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.fLF);
        this.evg.blV();
        registerListener(this.evz);
        registerListener(this.bdP);
        if (this.eue != null) {
            this.eue.aPc();
        }
        if (TbadkCoreApplication.m9getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.evH);
        registerListener(this.evO);
        registerListener(this.evN);
        registerListener(this.ewg);
        registerListener(this.cdk);
        this.euL = new com.baidu.tieba.pb.pb.main.b(this.eue, this);
        if (this.euU != null && this.euU.aQR() != null && this.euU.aQS() != null) {
            this.euw = new com.baidu.tieba.pb.pb.main.a.f(getActivity(), this.euU.aQR(), this.euU.aQS());
            this.euw.a(this.evG);
        }
        if (this.euv && this.euU != null && this.euU.aQS() != null) {
            this.euU.aQS().setVisibility(8);
        }
        this.evl = new com.baidu.tbadk.core.view.h();
        this.evl.aju = 1000L;
        registerListener(this.evK);
        registerListener(this.evI);
        registerListener(this.evJ);
        this.evm = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.evm;
        userMuteAddAndDelCustomMessage.setTag(this.evm);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.evm;
        userMuteCheckCustomMessage.setTag(this.evm);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eue.aPl().a(this.bkl);
        if (this.euO != null && this.euO.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c12264").r("obj_type", 2).Z("tid", this.eue.getThreadID()));
            KuangFloatingViewController.getInstance().showFloatingView();
        }
    }

    public String aNw() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.f aNx() {
        return this.euw;
    }

    private void iB(boolean z) {
        this.evh.bF(z);
        this.evh.bG(z);
        this.evh.bH(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cci != null) {
            this.cci.onStart(getPageContext());
        }
    }

    public gg aNy() {
        return this.euU;
    }

    public PbModel aNz() {
        return this.eue;
    }

    public void oH(String str) {
        if (this.eue != null && !StringUtils.isNull(str) && this.euU != null) {
            this.euU.aQt();
            this.euU.js(true);
            this.eue.oH(str);
            this.euM = true;
            this.euU.azw();
            this.euU.aQN();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.m9getInst().isReadMenuDialogOnTop()) {
            this.euy = false;
        } else {
            this.euy = true;
        }
        super.onPause();
        if (this.euU.aQa() != null && this.euU.aQa().aNr() != null) {
            this.euU.aQa().aNr().onPause();
        }
        BdListView listView = getListView();
        this.euA = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.euA == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.cci != null) {
            this.cci.onPause(getPageContext());
        }
        if (this.euU != null) {
            this.euU.onPause();
        }
        if (!this.eue.aOO()) {
            this.evh.fL(this.eue.getThreadID());
        }
        if (this.eue != null) {
            this.eue.aPd();
        }
        MessageManager.getInstance().unRegisterListener(this.cYr);
        anR();
        MessageManager.getInstance().unRegisterListener(this.evI);
        MessageManager.getInstance().unRegisterListener(this.evJ);
        MessageManager.getInstance().unRegisterListener(this.evK);
        MessageManager.getInstance().unRegisterListener(this.cdd);
        MessageManager.getInstance().unRegisterListener(this.cIw);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aNA() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.eue.getPbData(), this.eue.aOK(), this.eue.aPa());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.euy = false;
        super.onResume();
        if (this.euQ) {
            this.euQ = false;
            aOa();
        }
        if (this.euU.aQa() != null && this.euU.aQa().aNr() != null) {
            this.euU.aQa().aNr().onResume();
        }
        if (aNA()) {
            this.euG = System.currentTimeMillis();
        } else {
            this.euG = -1L;
        }
        if (this.euU != null && this.euU.getView() != null) {
            if (!this.dTL) {
                aNR();
            } else {
                hideLoadingView(this.euU.getView());
            }
            this.euU.onResume();
        }
        if (this.euA == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.euU != null) {
            noNetworkView = this.euU.aQb();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.hj()) {
            noNetworkView.aK(false);
        }
        if (this.cci != null) {
            this.cci.onResume(getPageContext());
        }
        registerListener(this.cYr);
        this.eve = false;
        aNZ();
        registerListener(this.evI);
        registerListener(this.evJ);
        registerListener(this.evK);
        registerListener(this.cdd);
        registerListener(this.cIw);
        if (this.ccO) {
            US();
            this.ccO = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.euU.jj(z);
        if (this.euZ != null) {
            this.euZ.iS(z);
        }
        if (z && this.eve) {
            this.euU.aQy();
            this.eue.iN(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.euG > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10804").Z("obj_duration", new StringBuilder(String.valueOf(System.currentTimeMillis() - this.euG)).toString()));
            this.euG = 0L;
        }
        if (this.evh != null && this.evh.CG() != null && this.evh.CG().getVisibility() != 0) {
            this.evh.Dp();
        }
        if (aNy().aQe() != null) {
            aNy().aQe().onStop();
        }
        if (this.euU.eBR != null && !this.euU.eBR.Ww()) {
            this.euU.eBR.azN();
        }
        if (this.eue != null && this.eue.getPbData() != null && this.eue.getPbData().aMt() != null && this.eue.getPbData().aMv() != null) {
            com.baidu.tbadk.distribute.a.Cq().a(getPageContext().getPageActivity(), "pb", this.eue.getPbData().aMt().getId(), com.baidu.adp.lib.g.b.c(this.eue.getPbData().aMv().getId(), 0L));
        }
        if (this.cci != null) {
            this.cci.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.euL != null) {
            this.euL.destroy();
        }
        if (this.eva && this.eue != null) {
            a(this.eue.getPbData(), -2, 0, false, false);
        }
        if (!this.euE && this.euU != null) {
            this.euE = true;
            this.euU.aQM();
            a(false, (PostData) null);
        }
        if (this.eue != null) {
            this.eue.cancelLoadData();
            this.eue.destory();
            if (this.eue.aPk() != null) {
                this.eue.aPk().onDestroy();
            }
        }
        if (this.evh != null) {
            this.evh.onDestroy();
        }
        if (this.euT != null) {
            this.euT.cancelLoadData();
        }
        if (this.euU != null) {
            this.euU.onDestroy();
            if (this.euU.eBR != null) {
                this.euU.eBR.azN();
            }
        }
        if (this.euF != null) {
            this.euF.onDestroy();
        }
        if (this.euw != null) {
            this.euw.GR();
        }
        super.onDestroy();
        if (this.cci != null) {
            this.cci.onDestory(getPageContext());
        }
        if (this.ccC != null) {
            this.ccC.destory();
        }
        this.euU.azw();
        MessageManager.getInstance().unRegisterListener(this.evI);
        MessageManager.getInstance().unRegisterListener(this.evJ);
        MessageManager.getInstance().unRegisterListener(this.evK);
        MessageManager.getInstance().unRegisterListener(this.evm);
        MessageManager.getInstance().unRegisterListener(this.evL);
        MessageManager.getInstance().unRegisterListener(this.cdk);
        this.evk = null;
        this.evl = null;
        com.baidu.tieba.recapp.d.a.bex().bez();
        if (this.evn != null) {
            getSafeHandler().removeCallbacks(this.evn);
        }
        if (this.euR != null) {
            this.euR.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        dc aQs;
        ArrayList<PostData> aOv;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xD() && this.euU != null && (aQs = this.euU.aQs()) != null && (aOv = aQs.aOv()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aOv.iterator();
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
                        bVar.bxN = id;
                        bVar.bDR = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.Yf == 1 && !TextUtils.isEmpty(id)) {
                    next.Yf = 2;
                    a.b bVar2 = new a.b();
                    bVar2.bxN = id;
                    bVar2.bDR = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.eue == null || this.eue.getPbData() == null || this.eue.getPbData().aMt() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.eue.getPbData().aMt().getFirst_class();
                    str2 = this.eue.getPbData().aMt().getSecond_class();
                    str = this.eue.getPbData().aMt().getId();
                    str4 = this.eue.getThreadID();
                }
                com.baidu.tieba.recapp.ad.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.xG());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.euU.onChangeSkinType(i);
        if (this.evh != null && this.evh.CG() != null) {
            this.evh.CG().onChangeSkinType(i);
        }
        if (this.euU.aQb() != null) {
            this.euU.aQb().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.euU = new gg(this, this.cdH, this.aPs);
        this.cfe = new com.baidu.tieba.e.c(getActivity());
        this.cfe.a(this.evZ);
        this.cfe.a(this.bQR);
        this.euU.setOnScrollListener(this.mOnScrollListener);
        this.euU.d(this.evT);
        this.euU.a(this.aXU);
        this.euU.iv(com.baidu.tbadk.core.r.oK().oQ());
        this.euU.setOnImageClickListener(this.aPr);
        this.euU.a(this.aue);
        this.euU.c(this.bzE);
        this.euU.a(this.evR);
        this.euU.jj(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aU(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(w.h.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.fMi == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.r.oK().oQ()) {
                    return false;
                }
                return oL(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.euU != null) {
            if (z && (!this.dTL || this.evj)) {
                aNR();
            } else {
                hideLoadingView(this.euU.getView());
            }
            this.evj = false;
        }
    }

    private void aNB() {
        if (this.euB == null) {
            this.euB = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.euB.a(new String[]{getPageContext().getString(w.l.call_phone), getPageContext().getString(w.l.sms_phone), getPageContext().getString(w.l.search_in_baidu)}, new bh(this)).cc(c.a.aam).cd(17).d(getPageContext());
        }
    }

    private void r(Bundle bundle) {
        this.eue = new PbModel(this);
        this.eue.a(this.evM);
        if (this.eue.aPi() != null) {
            this.eue.aPi().a(this.ewb);
        }
        if (this.eue.aPh() != null) {
            this.eue.aPh().a(this.evy);
        }
        if (this.eue.aPk() != null) {
            this.eue.aPk().a(this.evu);
        }
        if (bundle != null) {
            this.eue.initWithBundle(bundle);
        } else {
            this.eue.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.eue.iR(true);
        }
        fp.aPV().Q(this.eue.aOI(), this.eue.getIsFromMark());
        if (StringUtils.isNull(this.eue.getThreadID())) {
            finish();
        } else {
            this.eue.EX();
        }
    }

    private void initData(Bundle bundle) {
        this.dPW = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dPW != null) {
            this.dPW.a(this.evP);
        }
        this.euT = new ForumManageModel(this);
        this.euT.setLoadDataCallBack(this.evQ);
        this.euU.a(new bi(this));
        this.evD.setUniqueId(getUniqueId());
        this.evD.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.euU.Qx();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(w.h.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.evm;
        userMuteCheckCustomMessage.setTag(this.evm);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.bX(w.l.go_setting_float_window_permission);
        aVar.bY(w.l.step_to_setting_float_permission);
        aVar.a(w.l.go_and_setting, new bj(this));
        aVar.b(w.l.cancel, new bk(this));
        aVar.b(getPageContext()).ta();
    }

    public PostData aV(View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(w.h.tag_clip_board)) != null && !com.baidu.tieba.pb.i.d(postData)) {
            if (postData.bmH()) {
                postData.cG(postData.bmG() - 1);
            } else {
                postData.cG(postData.bmG() + 1);
            }
            postData.lS(!postData.bmH());
            ((PbFloorAgreeView) view).a(postData.bmH(), postData.bmG(), true);
            int i = postData.bmH() ? 0 : 1;
            this.eue.aPj().a(postData.getId(), i, new bm(this, i, view));
            return postData;
        }
        return null;
    }

    public com.baidu.tbadk.core.util.au aNC() {
        return new com.baidu.tbadk.core.util.au("c12003").Z("tid", this.eue.eyr).r("obj_type", 0).Z("fid", this.eue.getForumId()).r("obj_param1", this.eue.getPbData().aMv().getThreadType() == 40 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aND() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.eue != null && this.eue.getPbData() != null) {
            com.baidu.tieba.pb.data.f pbData = this.eue.getPbData();
            if (pbData.aMt() != null) {
                sb.append("forum_name=").append(oI(pbData.aMt().getName()));
                sb.append("&");
            }
            if (pbData.aMv() != null) {
                com.baidu.tbadk.core.data.bm aMv = pbData.aMv();
                sb.append("thread_id=").append(aMv.getId());
                sb.append("&");
                sb.append("thread_title=").append(oI(aMv.getTitle()));
                if (aMv.getAuthor() != null && aMv.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aMv.getAuthor().getPortrait());
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
            getSafeHandler().postDelayed(new bn(this, iArr, measuredHeight, str, str2), 500L);
        }
    }

    private String oI(String str) {
        return URLEncoder.encode(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        PostData postData;
        ArrayList<IconData> arrayList;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(w.h.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(w.h.tag_clip_board)) != null && this.eue != null && this.eue.getPbData() != null && postData.bmu() > 1) {
            String threadID = this.eue.getThreadID();
            String id = postData.getId();
            int i = 0;
            if (this.eue.getPbData() != null) {
                i = this.eue.getPbData().aMG();
            }
            b oM = oM(id);
            if (oM != null) {
                SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
                SmallTailInfo aSA = postData.aSA();
                AntiData qe = this.eue.getPbData().qe();
                if (postData.getAuthor() != null) {
                    arrayList = postData.getAuthor().getIconInfo();
                } else {
                    arrayList = null;
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i, aSA, qe, false, arrayList).addBigImageData(oM.ewy, oM.ewz, oM.ewA, oM.index)));
            }
        }
    }

    public void f(View view, int i, boolean z) {
        gc gcVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.k.hA()) {
                showToast(w.l.no_network_guide);
            } else if (aNz() != null && aNz().getPbData() != null && aNz().getPbData().aMS() != null && !com.baidu.tieba.pb.i.N(aNz().getPbData().aMv())) {
                com.baidu.tieba.pb.data.m aMS = aNz().getPbData().aMS();
                if (view == null || !(view.getTag(w.h.pb_main_thread_praise_view) instanceof gc)) {
                    gcVar = null;
                } else {
                    gcVar = (gc) view.getTag(w.h.pb_main_thread_praise_view);
                }
                if (aMS != null) {
                    int i2 = -1;
                    if (z) {
                        aMS.oC(i);
                    } else if (aMS.aMY()) {
                        aMS.aNa();
                        i2 = 1;
                    } else {
                        aMS.oD(i);
                        i2 = 0;
                    }
                    bo boVar = new bo(this);
                    if (this.eue != null && this.eue.aPj() != null) {
                        String str = "";
                        if (this.eue.getPbData() != null && this.eue.getPbData().aMv() != null) {
                            str = this.eue.getPbData().aMv().rH();
                        }
                        if (this.eue.getPbData() != null) {
                            this.eue.getPbData().a(aMS);
                        }
                        if (z) {
                            this.eue.aPj().a(str, 3, i, this.eue.getForumId(), boVar);
                        } else {
                            this.eue.aPj().a(str, i2, 3, i, this.eue.getForumId(), boVar);
                            com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                            lVar.ese = i2;
                            lVar.esf = aMS;
                            lVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_AGREE_CHANGED, lVar));
                        }
                    }
                    if (gcVar != null) {
                        gcVar.b(aMS);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aNE() {
        if (this.eue.getPbData() == null || this.eue.getPbData().aMv() == null) {
            return -1;
        }
        return this.eue.getPbData().aMv().rV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNF() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.ph(this.eue.getForumId()) && this.eue.getPbData() != null && this.eue.getPbData().aMt() != null) {
            if (this.eue.getPbData().aMt().isLike() == 1) {
                aNS();
                this.eue.aPm().bM(this.eue.getForumId(), this.eue.getThreadID());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iC(boolean z) {
        if (this.eue == null || this.eue.getPbData() == null) {
            return false;
        }
        return ((this.eue.getPbData().aMG() != 0) || this.eue.getPbData().aMv() == null || this.eue.getPbData().aMv().getAuthor() == null || TextUtils.equals(this.eue.getPbData().aMv().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean iD(boolean z) {
        if (z) {
            return true;
        }
        if (this.eue == null || this.eue.getPbData() == null) {
            return false;
        }
        return this.eue.getPbData().aMG() != 0;
    }

    private boolean iE(boolean z) {
        return (z || this.eue == null || this.eue.getPbData() == null || this.eue.getPbData().aMG() == 0) ? false : true;
    }

    public void aNG() {
        if (this.eue != null && this.eue.getPbData() != null && this.eue.getPbData().aMv() != null && this.eue.getPbData().aMv().getAuthor() != null) {
            if (this.euU != null) {
                this.euU.aQc();
            }
            com.baidu.tbadk.core.data.bm aMv = this.eue.getPbData().aMv();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aMv.getAuthor().getUserId());
            GodUserData godUserData = aMv.getAuthor().getGodUserData();
            boolean z = equals && godUserData != null && godUserData.isCanSendCall();
            fa faVar = new fa();
            if (this.eue.getPbData().aMG() == 1) {
                faVar.eAf = true;
                faVar.eAe = true;
                faVar.eAk = aMv.rm() == 1;
                faVar.eAj = aMv.rn() == 1;
            } else {
                faVar.eAf = false;
                faVar.eAe = false;
            }
            faVar.eAd = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteShareActivityConfig.class);
            faVar.eAb = TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            faVar.eAg = iD(equals);
            faVar.eAh = aNH();
            faVar.eAi = iE(equals);
            faVar.eAc = this.eue.aOK();
            faVar.esq = this.dPW != null ? this.dPW.nz() : false;
            faVar.eAa = iC(equals);
            faVar.ezY = equals && this.euU.aQE();
            faVar.ezZ = z;
            faVar.isHostOnly = this.eue.getHostMode();
            if (aMv.rI() == null) {
                faVar.eAl = false;
            } else {
                faVar.eAl = true;
            }
            this.euU.eBR.a(faVar);
        }
    }

    private boolean aNH() {
        if (this.eue != null && this.eue.aOK()) {
            return this.eue.aov() == null || this.eue.aov().qr() != 0;
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
            h(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, boolean z2) {
        if (fVar != null && this.eue != null) {
            fg fgVar = new fg(getUniqueId());
            fgVar.pbData = fVar;
            fgVar.threadId = this.eue.getThreadID();
            fgVar.postId = this.eue.getPostId();
            fgVar.eAL = i;
            fgVar.eAM = i2;
            fgVar.eAK = this.eue.getHostMode();
            fgVar.esq = this.eue.nz();
            fgVar.isSquence = this.eue.aOK();
            fgVar.loadType = this.eue.aPf();
            fgVar.eAN = z;
            fgVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, fgVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aNI() {
        if (aNy() == null || aNy().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aNy().getListView();
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
        if (fVar != null && this.eue != null) {
            fg fgVar = new fg(getUniqueId());
            fgVar.pbData = fVar;
            fgVar.threadId = this.eue.getThreadID();
            fgVar.postId = this.eue.getPostId();
            fgVar.eAL = i;
            fgVar.eAK = this.eue.getHostMode();
            fgVar.esq = this.eue.nz();
            fgVar.isSquence = this.eue.aOK();
            fgVar.loadType = this.eue.aPf();
            fgVar.eAN = z;
            fgVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, fgVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        US();
    }

    public void a(boolean z, MarkData markData) {
        this.euU.aQz();
        this.eue.iQ(z);
        if (this.dPW != null) {
            this.dPW.ac(z);
            if (markData != null) {
                this.dPW.a(markData);
            }
        }
        if (this.eue.nz()) {
            aNO();
        } else {
            this.euU.l(this.eue.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oG(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oJ(String str) {
        if (!StringUtils.isNull(str) && this.eue != null) {
            String threadID = this.eue.getThreadID();
            String id = this.eue.getPbData().aMt().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(w.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.eue.aOO()) {
                    antiData.setBlock_forum_name(this.eue.getPbData().aMt().getName());
                    antiData.setBlock_forum_id(this.eue.getPbData().aMt().getId());
                    antiData.setUser_name(this.eue.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.eue.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.sK(i)) {
            AntiHelper.ar(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            fS(str);
        } else {
            this.euU.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.euU.a(0, bVar.AM, bVar.fOw, z);
            if (bVar.AM) {
                if (bVar.fOu == 1) {
                    ArrayList<PostData> aMx = this.eue.getPbData().aMx();
                    int size = aMx.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aMx.get(i).getId())) {
                            i++;
                        } else {
                            aMx.remove(i);
                            break;
                        }
                    }
                    this.euU.l(this.eue.getPbData());
                } else if (bVar.fOu == 0) {
                    aNJ();
                } else if (bVar.fOu == 2) {
                    ArrayList<PostData> aMx2 = this.eue.getPbData().aMx();
                    int size2 = aMx2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aMx2.get(i2).bmr().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aMx2.get(i2).bmr().get(i3).getId())) {
                                i3++;
                            } else {
                                aMx2.get(i2).bmr().remove(i3);
                                aMx2.get(i2).bmt();
                                z2 = true;
                                break;
                            }
                        }
                        aMx2.get(i2).rk(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.euU.l(this.eue.getPbData());
                    }
                    a(bVar, this.euU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.f fVar) {
        if (fVar != null) {
            this.euU.a(this.euT.getLoadDataMode(), fVar.AM, fVar.fOw, false);
            if (fVar.AM) {
                this.euW = true;
                if (i == 2 || i == 3) {
                    this.euX = true;
                    this.euY = false;
                } else if (i == 4 || i == 5) {
                    this.euX = false;
                    this.euY = true;
                }
                if (i == 2) {
                    this.eue.getPbData().aMv().bT(1);
                    this.eue.setIsGood(1);
                } else if (i == 3) {
                    this.eue.getPbData().aMv().bT(0);
                    this.eue.setIsGood(0);
                } else if (i == 4) {
                    this.eue.getPbData().aMv().bS(1);
                    this.eue.hy(1);
                } else if (i == 5) {
                    this.eue.getPbData().aMv().bS(0);
                    this.eue.hy(0);
                }
                this.euU.d(this.eue.getPbData(), this.eue.aOK());
                com.baidu.tieba.c.a.a(getPageContext(), 2, i);
            }
        }
    }

    private void aNJ() {
        if (this.eue.aOL() || this.eue.aOM()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.eue.getThreadID());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.eue.getThreadID()));
        if (aNP()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNK() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aMD;
        if (this.euU != null) {
            this.euU.azw();
        }
        if (this.eue != null && this.eue.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.eue.getPbData().aMv().getId();
            historyMessage.forumName = this.eue.getPbData().aMt().getName();
            historyMessage.threadName = this.eue.getPbData().aMv().getTitle();
            ArrayList<PostData> aMx = this.eue.getPbData().aMx();
            int aQB = this.euU != null ? this.euU.aQB() : 0;
            if (aMx != null && aQB >= 0 && aQB < aMx.size()) {
                historyMessage.postID = aMx.get(aQB).getId();
            }
            historyMessage.isHostOnly = this.eue.getHostMode();
            historyMessage.isSquence = this.eue.aOK();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.evh != null) {
            this.evh.onDestroy();
        }
        if (this.euz && aNy() != null) {
            aNy().aRa();
        }
        if (this.eue != null && (this.eue.aOL() || this.eue.aOM())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.eue.getThreadID());
            if (this.euW) {
                if (this.euY) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.eue.azn());
                }
                if (this.euX) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.eue.getIsGood());
                }
            }
            if (this.eue.getPbData() != null && System.currentTimeMillis() - this.euD >= 40000 && (aMD = this.eue.getPbData().aMD()) != null && !com.baidu.tbadk.core.util.z.t(aMD.getDataList())) {
                intent.putExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA, aMD);
                intent.putExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, this.evt);
            }
            setResult(-1, intent);
        }
        if (aNP()) {
            if (this.eue != null && this.euU != null && this.euU.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.eue.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.m9getInst().getDefaultBubble());
                    }
                    if (!pbData.aMB() && !this.euM) {
                        fp.aPV().a(this.eue.getPbData(), this.euU.getListView().onSaveInstanceState(), this.eue.aOK(), this.eue.getHostMode());
                    }
                }
            } else {
                fp.aPV().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.euU == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.euU.pb(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oH(int i) {
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
        this.evh.onActivityResult(i, i2, intent);
        if (this.euR != null) {
            this.euR.onActivityResult(i, i2, intent);
        }
        if (aNy().aQe() != null) {
            aNy().aQe().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aNN();
                    return;
                case 13008:
                    fp.aPV().reset();
                    this.mHandler.postDelayed(new bp(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.eue != null) {
                        a(aNM(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    U(intent);
                    return;
                case 24006:
                    T(intent);
                    return;
                case 24007:
                    if (aNE() == 1) {
                        aNL();
                    }
                    String stringExtra = intent.getStringExtra("share_to");
                    if (!AddExperiencedModel.WEIXIN_FRIEND.equals(stringExtra) && !AddExperiencedModel.WEIXIN_TIMELINE.equals(stringExtra)) {
                        aNF();
                        return;
                    }
                    return;
                case 24008:
                    this.euU.iA(false);
                    if (this.eue.getPbData() != null && this.eue.getPbData().aMv() != null && this.eue.getPbData().aMv().rL() != null) {
                        this.eue.getPbData().aMv().rL().setStatus(2);
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
            if (this.euL != null) {
                this.euL.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aNy() != null && aNu() != null && aNy().aQf() && com.baidu.tbadk.editortools.pb.a.Dc().getStatus() == 1) {
                    com.baidu.tbadk.editortools.pb.a.Dc().setStatus(0);
                    if (this.euU != null) {
                        this.euU.aOk();
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
            if (this.euR == null) {
                this.euR = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.euR.b(this.aBN);
                this.euR.c(this.aBU);
            }
            this.euR.a(emotionImageData, aNz(), aNz().getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNL() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.eue.getPbData() != null && this.eue.getPbData().aMv() != null && this.eue.getPbData().aMv().rC() != null && this.eue.getPbData().aMv().rC().size() > 0 && this.eue.getPbData().aMv().rC().get(0) != null) {
            this.mAwardActId = this.eue.getPbData().aMv().rC().get(0).pf();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.eue.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void T(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra(GetLotteryChanceActivityConfig.KEY_ACTION, 0)) {
                case 1:
                    oJ(2);
                    return;
                case 2:
                    this.euU.aQq();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aNM() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bD = this.eue.getPbData().bD(getPageContext().getPageActivity());
        PostData aQg = this.euU.aQg();
        String str = "";
        if (aQg != null) {
            str = aQg.getId();
            String bO = aQg.bO(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(bO)) {
                bD[1] = bO;
            }
        }
        String rH = this.eue.getPbData().aMv().rH();
        if (rH != null && rH.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bD[1]);
        shareFromPBMsgData.setImageUrl(bD[0]);
        shareFromPBMsgData.setForumName(this.eue.getPbData().aMt().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.eue.getPbData().aMv().getId());
        shareFromPBMsgData.setTitle(this.eue.getPbData().aMv().getTitle());
        return shareFromPBMsgData;
    }

    private void U(Intent intent) {
        b(aNM(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void b(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.eue != null && this.eue.getPbData() != null && this.eue.getPbData().aMv() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            ht htVar = new ht(getPageContext().getPageActivity());
            htVar.setData(shareFromPBMsgData);
            aVar.ca(1);
            aVar.v(htVar);
            aVar.a(w.l.share, new bq(this, htVar, j, str, str2, shareFromPBMsgData));
            aVar.b(w.l.alert_no_button, new br(this, htVar));
            aVar.at(true);
            aVar.b(getPageContext()).ta();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                htVar.I(shareFromPBMsgData.getImageUrl(), this.eue.getPbData().aMH() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.eue != null && this.eue.getPbData() != null && this.eue.getPbData().aMv() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            ht htVar = new ht(getPageContext().getPageActivity());
            htVar.setData(shareFromPBMsgData);
            aVar.ca(1);
            aVar.v(htVar);
            aVar.a(w.l.share, new bs(this, htVar, i, str, j, shareFromPBMsgData));
            aVar.b(w.l.alert_no_button, new bt(this, htVar));
            aVar.at(true);
            aVar.b(getPageContext()).ta();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                htVar.I(shareFromPBMsgData.getImageUrl(), this.eue.getPbData().aMH() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNN() {
        MarkData oW;
        if (this.dPW != null && (oW = this.eue.oW(this.euU.aQC())) != null) {
            if (!oW.isApp() || (oW = this.eue.oW(this.euU.aQC() + 1)) != null) {
                this.euU.aQx();
                this.dPW.a(oW);
                if (!this.dPW.nz()) {
                    this.dPW.nB();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.dPW.nA();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNO() {
        com.baidu.tieba.pb.data.f pbData = this.eue.getPbData();
        this.eue.iQ(true);
        pbData.oE(this.dPW.ny());
        this.euU.l(pbData);
    }

    private boolean aNP() {
        if (this.eue == null) {
            return true;
        }
        if (this.eue.nz()) {
            MarkData aOW = this.eue.aOW();
            if (aOW == null || !this.eue.getIsFromMark()) {
                return true;
            }
            MarkData oW = this.eue.oW(this.euU.aQC());
            if (oW == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aOW);
                setResult(-1, intent);
                return true;
            } else if (oW.getPostId() == null || oW.getPostId().equals(aOW.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aOW);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cI(getPageContext().getString(w.l.alert_update_mark));
                aVar.a(w.l.alert_yes_btn, new bu(this, oW, aOW, aVar));
                aVar.b(w.l.alert_no_button, new bv(this, aOW, aVar));
                aVar.a(new bx(this, aOW, aVar));
                aVar.b(getPageContext());
                aVar.ta();
                return false;
            }
        } else if (this.eue.getPbData() == null || this.eue.getPbData().aMx() == null || this.eue.getPbData().aMx().size() <= 0 || !this.eue.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.euU == null) {
            return null;
        }
        return this.euU.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int Iy() {
        if (this.euU == null) {
            return 0;
        }
        return this.euU.aQH();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> Iz() {
        if (this.aOX == null) {
            this.aOX = new com.baidu.adp.lib.e.b<>(new by(this), 8, 0);
        }
        return this.aOX;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> IA() {
        if (this.aOY == null) {
            this.aOY = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aOY;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> IB() {
        if (this.aPc == null) {
            this.aPc = new com.baidu.adp.lib.e.b<>(new bz(this), 20, 0);
        }
        return this.aPc;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IC() {
        if (this.aPa == null) {
            this.aPa = new com.baidu.adp.lib.e.b<>(new ca(this), 8, 0);
        }
        return this.aPa;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IE() {
        if (this.aOZ == null) {
            this.aOZ = com.baidu.tieba.graffiti.d.p(getPageContext().getPageActivity(), 6);
        }
        return this.aOZ;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wU() {
        if (this.anq == null) {
            this.anq = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.anq;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.euI = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        if (hu.oX(str) && this.eue != null && this.eue.getThreadID() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11664").r("obj_param1", 1).Z("post_id", this.eue.getThreadID()));
        }
        hu.aRe().f(getPageContext(), str);
        this.euI = true;
    }

    private com.baidu.tbadk.core.dialog.a aNQ() {
        if (this.euC == null) {
            this.euC = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.euC.cH(getPageContext().getString(w.l.download_baidu_video_dialog));
            this.euC.a(getPageContext().getString(w.l.install), new cb(this));
            this.euC.b(getPageContext().getString(w.l.cancel), new cc(this));
            this.euC.as(true);
            this.euC.b(getPageContext());
            this.euC.at(false);
        }
        this.euC.ta();
        return this.euC;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ab(Context context, String str) {
        hu.aRe().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.euI = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ad(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra(VrPlayerActivityConfig.TITLE, "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            aNQ();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.euI = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ac(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.eue.getPbData();
            TbRichText ap = ap(str, i);
            if (ap != null && (tbRichTextData = ap.HU().get(this.evU)) != null) {
                if (tbRichTextData.getType() == 20 || tbRichTextData.getType() == 17) {
                    bVar.ewC = true;
                    return;
                }
                bVar.ewy = new ArrayList<>();
                bVar.ewz = new ConcurrentHashMap<>();
                if (!tbRichTextData.Ia().In()) {
                    bVar.ewB = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    bVar.ewy.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.postId = ap.getPostId();
                    imageUrlData.mIsReserver = this.eue.aOV();
                    imageUrlData.mIsSeeHost = this.eue.getHostMode();
                    bVar.ewz.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aMt() != null) {
                            bVar.forumName = pbData.aMt().getName();
                            bVar.forumId = pbData.aMt().getId();
                        }
                        if (pbData.aMv() != null) {
                            bVar.threadId = pbData.aMv().getId();
                        }
                        bVar.ewA = pbData.aMH() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.ewB = true;
                int size = pbData.aMx().size();
                this.evV = false;
                bVar.index = -1;
                if (pbData.aMC() != null) {
                    PostData aMC = pbData.aMC();
                    TbRichText azb = aMC.azb();
                    if (!gf.k(aMC)) {
                        i2 = a(azb, ap, i, i, bVar.ewy, bVar.ewz);
                    } else {
                        i2 = a(aMC, i, bVar.ewy, bVar.ewz);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aMx().get(i4);
                    if (postData.getId() == null || pbData.aMC() == null || pbData.aMC().getId() == null || !postData.getId().equals(pbData.aMC().getId())) {
                        TbRichText azb2 = postData.azb();
                        if (!gf.k(postData)) {
                            i3 = a(azb2, ap, i3, i, bVar.ewy, bVar.ewz);
                        } else {
                            i3 = a(postData, i3, bVar.ewy, bVar.ewz);
                        }
                    }
                }
                if (bVar.ewy.size() > 0) {
                    bVar.lastId = bVar.ewy.get(bVar.ewy.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aMt() != null) {
                        bVar.forumName = pbData.aMt().getName();
                        bVar.forumId = pbData.aMt().getId();
                    }
                    if (pbData.aMv() != null) {
                        bVar.threadId = pbData.aMv().getId();
                    }
                    bVar.ewA = pbData.aMH() == 1;
                }
                bVar.index = i3;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Ia() == null) {
            return null;
        }
        return tbRichTextData.Ia().Ir();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Ia() == null) {
            return 0L;
        }
        return tbRichTextData.Ia().getOriginalSize();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo Ia;
        if (tbRichText == tbRichText2) {
            this.evV = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.HU().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.HU().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ah = (int) com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst());
                    int width = tbRichTextData.Ia().getWidth() * ah;
                    int height = ah * tbRichTextData.Ia().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.Ia().In()) {
                        if (tbRichText == tbRichText2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else if (tbRichTextData.getType() == 20) {
                        i3 = i8;
                        i4 = i7;
                    } else {
                        String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                        if (!TextUtils.isEmpty(c2)) {
                            arrayList.add(c2);
                            if (tbRichTextData != null && (Ia = tbRichTextData.Ia()) != null) {
                                String Ip = Ia.Ip();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = Ip;
                                imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eue.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.eue.aOV();
                                imageUrlData.mIsSeeHost = this.eue.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.evV) {
                            i4 = i7 + 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    }
                }
                i6++;
                i = i4;
                i5 = i3;
            }
        }
        return i;
    }

    private int a(PostData postData, int i, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        com.baidu.tieba.tbadkCore.data.h bmC;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> blZ;
        if (postData != null && arrayList != null && concurrentHashMap != null && (blZ = (bmC = postData.bmC()).blZ()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == blZ.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = blZ.get(i3);
                if (jVar != null) {
                    String bme = jVar.bme();
                    if (!com.baidu.tbadk.core.util.aw.isEmpty(bme)) {
                        arrayList.add(bme);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bme;
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        imageUrlData.originalUrl = jVar.bmd();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eue.getThreadID(), -1L);
                        imageUrlData.mIsReserver = this.eue.aOV();
                        imageUrlData.mIsSeeHost = this.eue.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bmC.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bme, imageUrlData);
                        }
                        if (!this.evV) {
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
    public void h(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.eue.rA())) {
                z = true;
            }
            MarkData j = this.eue.j(postData);
            if (j != null) {
                this.euU.aQx();
                if (this.dPW != null) {
                    this.dPW.a(j);
                    if (!z) {
                        this.dPW.nB();
                    } else {
                        this.dPW.nA();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText ap(String str, int i) {
        TbRichText tbRichText = null;
        if (this.eue == null || this.eue.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.eue.getPbData();
        if (pbData.aMC() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aMC());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            return a(pbData.aMx(), str, i);
        }
        return tbRichText;
    }

    private long oK(String str) {
        ArrayList<PostData> aMx;
        com.baidu.tieba.pb.data.f pbData = this.eue.getPbData();
        if (pbData != null && (aMx = pbData.aMx()) != null && !aMx.isEmpty()) {
            Iterator<PostData> it = aMx.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bmC = next.bmC();
                if (bmC != null && bmC.fLN) {
                    Iterator<TbRichTextData> it2 = next.azb().HU().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.Ij().getLink().equals(str)) {
                            return bmC.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> HU;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText azb = arrayList.get(i2).azb();
            if (azb != null && (HU = azb.HU()) != null) {
                int size = HU.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (HU.get(i4) != null && HU.get(i4).getType() == 8) {
                        i3++;
                        if (HU.get(i4).Ia().Ip().equals(str)) {
                            int ah = (int) com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst());
                            int width = HU.get(i4).Ia().getWidth() * ah;
                            int height = HU.get(i4).Ia().getHeight() * ah;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.evU = i4;
                            return azb;
                        } else if (i3 <= i) {
                            i4++;
                            i3 = i3;
                        }
                    } else {
                        if (HU.get(i4) != null && HU.get(i4).Ig() != null && (HU.get(i4).getType() == 20 || HU.get(i4).getType() == 17)) {
                            i3++;
                            MemeInfo memeInfo = HU.get(i4).Ig().memeInfo;
                            if (memeInfo == null || TextUtils.isEmpty(memeInfo.pic_url)) {
                                return null;
                            }
                            if (memeInfo.pic_url.equals(str)) {
                                if (memeInfo.width.intValue() >= 80 && memeInfo.height.intValue() >= 80) {
                                    if (memeInfo.height.intValue() * memeInfo.width.intValue() >= 10000) {
                                        this.evU = i4;
                                        return azb;
                                    }
                                }
                                return null;
                            } else if (i3 > i) {
                                break;
                            }
                        }
                        i4++;
                        i3 = i3;
                    }
                }
                continue;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void f(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.euc = str;
            if (this.euB == null) {
                aNB();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.euB.cf(1).setVisibility(8);
            } else {
                this.euB.cf(1).setVisibility(0);
            }
            this.euB.td();
            this.euI = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cci;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void US() {
        hideNetRefreshView(this.euU.getView());
        aNR();
        if (this.eue.EX()) {
            this.euU.aQx();
        }
    }

    private void aNR() {
        showLoadingView(this.euU.getView(), false, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds400));
        View Eu = getLoadingView().Eu();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Eu.getLayoutParams();
        layoutParams.addRule(3, this.euU.aQR().getId());
        Eu.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aei() {
        if (this.cci != null) {
            this.cci.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oI(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oJ(int i) {
        if (this.eue.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.eue.getPbData();
            String name = pbData.aMt().getName();
            String title = pbData.aMv().getTitle();
            int i2 = this.eue.getHostMode() ? 1 : 0;
            boolean z = false;
            if (pbData != null && pbData.aMt() != null) {
                if ((pbData.aMt().isLike() == 1) && AddExperiencedModel.ph(pbData.getForumId())) {
                    z = true;
                }
            }
            String str = "http://tieba.baidu.com/p/" + this.eue.getThreadID() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bD = pbData.bD(getPageContext().getPageActivity());
            String str2 = bD[0];
            if (!StringUtils.isNull(str2) && str2.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                str2 = str2.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = bD[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (aNE() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10399").Z("fid", pbData.getForumId()).Z("tid", pbData.getThreadId()).Z(SapiAccountManager.SESSION_UID, currentAccount));
            } else if (aNE() == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10406").Z("fid", pbData.getForumId()).Z("tid", pbData.getThreadId()).Z(SapiAccountManager.SESSION_UID, currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(w.l.share_content_tpl), title, name, str3);
            com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
            hVar.title = title;
            hVar.content = format;
            hVar.linkUrl = str;
            hVar.asU = true;
            hVar.asX = z;
            hVar.extData = this.eue.getThreadID();
            hVar.atd = 3;
            hVar.atc = i;
            hVar.fid = this.eue.getForumId();
            if (parse != null) {
                hVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), hVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(w.l.forum_friend, w.g.icon_unite_share_baf, new cd(this));
            shareDialogConfig.setCopyLinkListener(new ce(this, hVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private void aNS() {
        com.baidu.tbadk.util.x.a(new cf(this), new cg(this));
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> ID() {
        if (this.aPb == null) {
            this.aPb = new com.baidu.adp.lib.e.b<>(new ci(this), 15, 0);
        }
        return this.aPb;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.euU.aQr() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10517").r("obj_locate", 2).Z("fid", this.eue.getPbData().getForumId()));
            } else {
                com.baidu.tbadk.core.data.bm aMv = this.eue.getPbData().aMv();
                if (view != null) {
                    boolean z = aMv.rh() == null || aMv.rh().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.evE > 1000) {
                            this.evF = true;
                            aX(view);
                        } else {
                            this.evF = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            h(view, this.evF);
                        } else {
                            g(view, this.evF);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        g(view, this.evF);
                    } else if (motionEvent.getAction() == 3) {
                        g(view, this.evF);
                    }
                }
            }
        }
        return false;
    }

    private void g(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.praise_animation_scale2));
            new Handler().postDelayed(new cj(this), 200L);
        }
    }

    private void h(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.praise_animation_scale3));
            new Handler().postDelayed(new ck(this), 600L);
        }
    }

    private void aX(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.w onGetPreLoadListView() {
        return getListView();
    }

    public void aej() {
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
        } else if (aVar.tc() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.tc();
            int intValue = ((Integer) sparseArray.get(gg.eDJ)).intValue();
            if (intValue == gg.eDK) {
                if (!this.euT.bng()) {
                    this.euU.aQu();
                    int intValue2 = ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue();
                    this.euT.a(this.eue.getPbData().aMt().getId(), this.eue.getPbData().aMt().getName(), this.eue.getPbData().aMv().getId(), (String) sparseArray.get(w.h.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == gg.eDL || intValue == gg.eDN) {
                if (this.eue.aPi() != null) {
                    this.eue.aPi().oN(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == gg.eDL) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == gg.eDM) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.ewa).pa()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.evm);
        userMuteAddAndDelCustomMessage.setTag(this.evm);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean oL(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bl.aN(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("bubble_link", ""))) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), getResources().getString(w.l.editor_privilege), String.valueOf(string) + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void iF(boolean z) {
        this.eve = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aNT() {
        ArrayList<PostData> aMx;
        int s;
        if (this.eue == null || this.eue.getPbData() == null || this.eue.getPbData().aMx() == null || (s = com.baidu.tbadk.core.util.z.s((aMx = this.eue.getPbData().aMx()))) == 0) {
            return "";
        }
        if (this.eue.aOV()) {
            Iterator<PostData> it = aMx.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bmu() == 1) {
                    return next.getId();
                }
            }
        }
        int aQB = this.euU.aQB();
        PostData postData = (PostData) com.baidu.tbadk.core.util.z.c(aMx, aQB);
        if (postData == null || postData.getAuthor() == null) {
            return "";
        }
        if (this.eue.oQ(postData.getAuthor().getUserId())) {
            return postData.getId();
        }
        for (int i = aQB - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.z.c(aMx, i);
            if (postData2 == null || postData2.getAuthor() == null || postData2.getAuthor().getUserId() == null) {
                break;
            } else if (this.eue.oQ(postData2.getAuthor().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = aQB + 1; i2 < s; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.z.c(aMx, i2);
            if (postData3 == null || postData3.getAuthor() == null || postData3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.eue.oQ(postData3.getAuthor().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ae(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.be.vP().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.b.a(oK(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.eue.getPbData().aMt().getId(), this.eue.getPbData().aMt().getName(), this.eue.getPbData().aMv().getTid());
            }
            this.euI = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, String str2, String str3, String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cI(getResources().getString(w.l.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cI(getResources().getString(w.l.make_sure_hide));
        }
        aVar.a(getResources().getString(w.l.alert_yes_button), new cl(this, j, str, str2, str3, str4));
        aVar.b(getResources().getString(w.l.alert_no_button), new cm(this, j, str, str2, str3, str4));
        aVar.at(false);
        aVar.b(getPageContext());
        aVar.ta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b oM(String str) {
        String str2;
        if (this.eue.getPbData() == null || this.eue.getPbData().aMx() == null || this.eue.getPbData().aMx().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i < this.eue.getPbData().aMx().size()) {
                if (str.equals(this.eue.getPbData().aMx().get(i).getId())) {
                    break;
                }
                i++;
            } else {
                i = 0;
                break;
            }
        }
        PostData postData = this.eue.getPbData().aMx().get(i);
        if (postData.azb() == null || postData.azb().HU() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.azb().HU().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.Ia() != null) {
                    str2 = next.Ia().Ip();
                }
            }
        }
        a(str2, 0, bVar);
        com.baidu.tieba.pb.data.g.a(postData, bVar);
        return bVar;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eux) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.eux = false;
        } else if (aNU()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eux) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.eux = false;
        } else if (aNU()) {
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
        if (pageStayDurationItem != null && this.eue != null) {
            if (this.eue.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eue.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eue.getThreadID(), 0L));
            if (this.euJ) {
                pageStayDurationItem.objParam1 = "1";
            }
        }
        return pageStayDurationItem;
    }

    public boolean aNU() {
        return (!this.euv && this.ewc == -1 && this.ewd == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null) {
            this.ewf = oVar;
            this.euv = true;
            this.euU.aQi();
            this.euU.oV(this.ewe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNV() {
        if (this.ewf != null) {
            if (this.ewc == -1) {
                showToast(w.l.pb_manga_not_prev_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.ewf.getCartoonId(), this.ewc, 0)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNW() {
        if (this.ewf != null) {
            if (this.ewd == -1) {
                showToast(w.l.pb_manga_not_next_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.ewf.getCartoonId(), this.ewd, 0)));
            finish();
        }
    }

    public int aNX() {
        return this.ewc;
    }

    public int aNY() {
        return this.ewd;
    }

    private void anR() {
        if (this.eue != null && this.eue.getPbData() != null && this.eue.getPbData().aMv() != null && this.eue.getPbData().aMv().se()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aNZ() {
        if (this.eue != null && this.eue.getPbData() != null && this.eue.getPbData().aMv() != null && this.eue.getPbData().aMv().se()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aOa() {
        if (this.euy) {
            this.euQ = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.eue.getPbData() != null && this.eue.getPbData().aMv() != null && this.eue.getPbData().aMv().ra() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.eue.getPbData().aMv().ra().getThreadId(), this.eue.getPbData().aMv().ra().getTaskId(), this.eue.getPbData().aMv().ra().getForumId(), this.eue.getPbData().aMv().ra().getForumName(), this.eue.getPbData().aMv().rm(), this.eue.getPbData().aMv().rn())));
            this.eux = true;
            finish();
        }
    }

    public boolean aOb() {
        return this.euy;
    }

    public String aOc() {
        return this.euO;
    }

    public PbInterviewStatusView.a aOd() {
        return this.euS;
    }

    public void iG(boolean z) {
        this.euP = z;
    }

    public boolean aOe() {
        if (this.eue != null) {
            return this.eue.aOL();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOf() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cI(getResources().getString(w.l.mute_is_super_member_function));
        aVar.a(w.l.open_now, new cn(this));
        aVar.b(w.l.cancel, new co(this));
        aVar.b(this.evk).ta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fS(String str) {
        if (str == null) {
            str = "";
        }
        if (this.evk != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.evk.getPageActivity());
            aVar.cI(str);
            aVar.b(w.l.know, new cp(this));
            aVar.b(this.evk).ta();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.euU.Qx();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.evk.getPageActivity());
        if (com.baidu.tbadk.core.util.aw.isEmpty(str)) {
            aVar.cI(this.evk.getResources().getString(w.l.block_mute_message_alert, str2));
        } else {
            aVar.cI(str);
        }
        aVar.a(w.l.confirm, new cr(this, userMuteAddAndDelCustomMessage));
        aVar.b(w.l.cancel, new cs(this));
        aVar.b(this.evk).ta();
    }

    public void aOg() {
        if (this.eue != null && this.eue.getPbData() != null && this.eue.getPbData().aMv() != null && this.eue.getPbData().aMv().sv() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bY(w.l.channel_open_push_message);
            aVar.a(w.l.need_channel_push, new ct(this));
            aVar.b(w.l.not_need_channel_push, new cu(this));
            aVar.b(getPageContext());
            aVar.ta();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.b
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.b[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.b.class);
            for (int i = 0; i < objArr.length; i++) {
                if (hu.oX(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_pb_wenxue)) != null) {
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
            this.euN = true;
        } else {
            this.euN = false;
        }
        if (this.euU != null) {
            this.euU.onConfigurationChanged(configuration);
        }
        if (this.euZ != null) {
            this.euZ.dismiss();
        }
    }

    public boolean aOh() {
        if (this.eue != null) {
            return this.eue.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, gg ggVar) {
        boolean z;
        List<PostData> list = this.eue.getPbData().aMF().ess;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bmr().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bmr().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bmr().remove(i2);
                    list.get(i).bmt();
                    z = true;
                    break;
                }
            }
            list.get(i).rk(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            ggVar.l(this.eue.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.n nVar) {
        String id = nVar.aNd().getId();
        List<PostData> list = this.eue.getPbData().aMF().ess;
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
                ArrayList<PostData> aNh = nVar.aNh();
                postData.sE(nVar.getTotalCount());
                if (postData.bmr() != null) {
                    postData.bmr().clear();
                    postData.bmr().addAll(aNh);
                }
            }
        }
        this.euU.l(this.eue.getPbData());
    }

    public boolean aOi() {
        boolean z = true;
        if (this.eue == null) {
            return false;
        }
        switch (this.eue.aPq()) {
            case 1:
            case 2:
                break;
            default:
                if (this.eue.getPbData() != null && this.eue.getPbData().aMv() != null && this.eue.getPbData().aMv().sC() && StringUtils.isNull(this.eue.getForumId())) {
                    z = false;
                    break;
                }
                break;
        }
        return z;
    }

    public void aOj() {
        if (this.euU != null) {
            this.euU.aQc();
            aej();
        }
    }

    public void aOk() {
        if (this.euU != null) {
            this.euU.aOk();
        }
    }

    public PostData aMC() {
        return this.euU.c(this.eue.eyH, this.eue.aOK());
    }
}
