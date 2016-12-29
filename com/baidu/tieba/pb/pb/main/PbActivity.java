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
import com.baidu.tbadk.core.view.z;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d.a;
import com.baidu.tieba.d.c;
import com.baidu.tieba.pb.pb.main.a.j;
import com.baidu.tieba.pb.pb.main.cq;
import com.baidu.tieba.pb.pb.main.ct;
import com.baidu.tieba.pb.pb.main.dc;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.f.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.b, com.baidu.tbadk.widget.richText.m {
    private com.baidu.adp.lib.f.b<ImageView> aIV;
    private com.baidu.adp.lib.f.b<TextView> aIW;
    private com.baidu.adp.lib.f.b<View> aIX;
    private com.baidu.adp.lib.f.b<View> aIY;
    private com.baidu.adp.lib.f.b<LinearLayout> aIZ;
    private com.baidu.adp.lib.f.b<GifView> aJa;
    private com.baidu.adp.lib.f.b<TbImageView> ahl;
    private com.baidu.tieba.d.c bBN;
    private com.baidu.tbadk.e.a byF;
    private VoiceManager byf;
    private com.baidu.tieba.pb.pb.main.a.j dYS;
    private com.baidu.tbadk.core.dialog.a dYX;
    private String dYy;
    private com.baidu.tbadk.core.view.h dZA;
    private BdUniqueId dZB;
    private Runnable dZC;
    private boolean dZU;
    private com.baidu.tieba.pb.pb.main.b dZe;
    private dj dZp;
    private boolean dZu;
    private com.baidu.tieba.tbadkCore.data.f dZv;
    private com.baidu.tbadk.editortools.e.e dZw;
    private com.baidu.adp.base.h dZz;
    private String eaf;
    private com.baidu.tbadk.core.data.n eag;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean dYR = false;
    private boolean dYT = false;
    private boolean dYU = false;
    private boolean dAL = false;
    private int dYV = 0;
    private com.baidu.tbadk.core.dialog.c dYW = null;
    private long bpV = -1;
    private long aCf = 0;
    private long dYY = 0;
    private long createTime = 0;
    private long aBX = 0;
    private boolean dYZ = false;
    private com.baidu.tbadk.performanceLog.e dZa = null;
    private long dZb = 0;
    private boolean dZc = false;
    private boolean dZd = false;
    private String awf = null;
    private String dZf = "";
    private boolean dZg = true;
    private boolean dZh = false;
    private String source = "";
    private PbInterviewStatusView.a dZi = new i(this);
    private final Handler mHandler = new Handler(new t(this));
    private dc dYA = null;
    private com.baidu.tbadk.baseEditMark.a dxb = null;
    private com.baidu.tieba.tbadkCore.f.a dZj = null;
    private er dZk = null;
    public final com.baidu.tieba.pb.pb.main.a.a dZl = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean dZm = false;
    private boolean dZn = false;
    private boolean dZo = false;
    private boolean dZq = false;
    private boolean dZr = false;
    private boolean dZs = false;
    private boolean dZt = false;
    private boolean dZx = false;
    private com.baidu.tbadk.editortools.e.c awj = new ae(this);
    private boolean dZy = false;
    private int cuD = -1;
    private final CustomMessageListener dZD = new ap(this, CmdConfigCustom.PB_RESET_EDITOR_TOOL);
    CustomMessageListener byX = new ba(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private CustomMessageListener bTg = new bl(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener dgB = new bu(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener dgY = new ce(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener dZE = new cf(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener aJQ = new j(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
    private CustomMessageListener cGK = new k(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private cq.a dZF = new l(this);
    private View.OnClickListener dgA = new m(this);
    private CustomMessageListener dZG = new n(this, CmdConfigCustom.CMD_SEND_GIFT_SUCCESS);
    private boolean dZH = false;
    private com.baidu.tieba.tbadkCore.ag dZI = new com.baidu.tieba.tbadkCore.ag(getPageContext(), new o(this));
    private long dXn = 0;
    private boolean dXo = true;
    private j.a dZJ = new p(this);
    private CustomMessageListener bIg = new q(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener dZK = new r(this, CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED);
    private com.baidu.tieba.pb.a.d dXp = new com.baidu.tieba.pb.a.d(new s(this));
    private CustomMessageListener dZL = new u(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener dZM = new v(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener dZN = new w(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    public a.b dJO = new x(this);
    public final View.OnClickListener bzZ = new y(this);
    private final b.d awp = new z(this);
    private final dc.a dZO = new aa(this);
    private CustomMessageListener dZP = new ab(this, CmdConfigCustom.CMD_WX_SHARE_SUCCESS);
    private CustomMessageListener dZQ = new ac(this, CmdConfigCustom.CMD_TTS_OPTION_PB);
    private final a.InterfaceC0032a dZR = new ad(this);
    private final AbsListView.OnScrollListener BM = new af(this);
    private final com.baidu.adp.base.g dZS = new ag(this);
    private final c dZT = new ah(this);
    private final z.b aWB = new ai(this);
    private final BdListView.e dZV = new aj(this);
    private int dZW = 0;
    private final TbRichTextView.e aJq = new ak(this);
    boolean dZX = false;
    com.baidu.tieba.tbadkCore.data.q dZY = null;
    private final c.b dZZ = new al(this);
    private final View.OnLongClickListener aou = new am(this);
    private final NoNetworkView.a aSE = new an(this);
    public View.OnTouchListener aJN = new ao(this);
    private a.InterfaceC0057a aMk = new aq(this);
    private final c.a eaa = new ar(this);
    private String eab = null;
    private final ct.a eac = new as(this);
    private int ead = -1;
    private int eae = -1;
    private final CustomMessageListener bzb = new at(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public boolean eaB;
        public ArrayList<String> eay;
        public ConcurrentHashMap<String, ImageUrlData> eaz;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean eaA = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes.dex */
    public interface c {
    }

    public void ib(boolean z) {
        this.dZc = z;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.e.e aIX() {
        return this.dZw;
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        if (jVar.aIF() != null) {
            String id = jVar.aIF().getId();
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aIm = this.dYA.getPbData().aIm();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aIm.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.q qVar = aIm.get(i2);
                if (qVar.getId() == null || !qVar.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.data.q> aIJ = jVar.aIJ();
                    qVar.rh(jVar.getTotalCount());
                    if (qVar.bfX() != null) {
                        qVar.bfX().clear();
                        qVar.bfX().addAll(aIJ);
                    }
                }
            }
            this.dZk.j(this.dYA.getPbData());
        }
    }

    public void aIY() {
        com.baidu.tieba.pb.data.f pbData;
        com.baidu.tbadk.core.data.bg aIl;
        if (!this.dZH) {
            if (!com.baidu.adp.lib.util.k.gD()) {
                showToast(r.j.no_network_guide);
            } else if (this.dXo) {
                this.dZH = true;
                if (this.dYA != null && (pbData = this.dYA.getPbData()) != null && (aIl = pbData.aIl()) != null) {
                    int isLike = aIl.rv() == null ? 0 : aIl.rv().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.at("c10796").ab("tid", aIl.getId()));
                    }
                    if (this.dZI != null) {
                        this.dZI.a(aIl.rV(), aIl.getId(), isLike, "pb");
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
                cVar.ce(r.j.operation);
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
                    cVar.a(strArr, new au(this, sparseArray, z, str2, str));
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(r.j.un_mute) : getResources().getString(r.j.mute);
                    cVar.a(strArr2, new av(this, sparseArray, z, str2, str));
                }
                cVar.d(getPageContext()).te();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(int i) {
        com.baidu.tbadk.core.data.bg aIl;
        String sb;
        String y;
        if (this.dYA != null && this.dYA.getPbData() != null && (aIl = this.dYA.getPbData().aIl()) != null) {
            if (i == 1) {
                PraiseData rv = aIl.rv();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rv == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aIl.a(praiseData);
                    } else {
                        aIl.rv().getUser().add(0, metaData);
                        aIl.rv().setNum(aIl.rv().getNum() + 1);
                        aIl.rv().setIsLike(i);
                    }
                }
                if (aIl.rv() != null) {
                    if (aIl.rv().getNum() < 1) {
                        y = getResources().getString(r.j.frs_item_praise_text);
                    } else {
                        y = com.baidu.tbadk.core.util.av.y(aIl.rv().getNum());
                    }
                    this.dZk.O(y, true);
                }
            } else if (aIl.rv() != null) {
                aIl.rv().setIsLike(i);
                aIl.rv().setNum(aIl.rv().getNum() - 1);
                ArrayList<MetaData> user = aIl.rv().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aIl.rv().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aIl.rv().getNum() < 1) {
                    sb = getResources().getString(r.j.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(aIl.rv().getNum())).toString();
                }
                this.dZk.O(sb, false);
            }
            if (this.dYA.aKl()) {
                this.dZk.aLQ().notifyDataSetChanged();
            } else {
                this.dZk.k(this.dYA.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().akZ && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().akY && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        if (this.dYA != null && this.dYA.getPbData() != null && this.dZk != null) {
            this.dZk.d(this.dYA.getPbData(), this.dYA.aKl(), this.dYA.aKB());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.byF == null) {
                this.byF = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.byF.aq(updateAttentionMessage.getData().toUid, this.dYA.getPbData().getForumId());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.dYA.n(bundle);
        if (this.byf != null) {
            this.byf.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.dZw.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.dZz = getPageContext();
        Intent intent = getIntent();
        if (intent != null) {
            this.bpV = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.dZf = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.dZf)) {
                this.dYT = true;
            }
            this.ead = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.eae = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.eaf = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            if (aJu()) {
                setUseStyleImmersiveSticky(false);
            }
            this.dZr = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.av.isEmpty(this.source) ? "" : this.source;
        } else {
            this.bpV = System.currentTimeMillis();
        }
        this.dYY = System.currentTimeMillis();
        this.aBX = this.dYY - this.bpV;
        super.onCreate(bundle);
        this.dYV = 0;
        p(bundle);
        if (this.dYA != null && this.dYA.getPbData() != null) {
            this.dYA.getPbData().hi(this.source);
        }
        initUI();
        if (intent != null && this.dZk != null) {
            this.dZk.eeD = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
            if (intent.getBooleanExtra(PbActivityConfig.BIG_PIC_TYPE, false)) {
                if (this.dZC == null) {
                    this.dZC = new aw(this);
                }
                getSafeHandler().postDelayed(this.dZC, 500L);
            }
        }
        this.byf = new VoiceManager();
        this.byf.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.e.n nVar = new com.baidu.tbadk.editortools.e.n();
        nVar.setForumName(this.dYA.aKk());
        if (this.dYA.getPbData() != null && this.dYA.getPbData().aIk() != null) {
            nVar.setForumId(this.dYA.getPbData().aIk().getId());
        }
        nVar.setFrom("pb");
        nVar.a(this.dYA);
        this.dZw = (com.baidu.tbadk.editortools.e.e) nVar.al(getActivity());
        this.dZw.d(this);
        this.dZw.a(this.awp);
        this.dZw.a(this.awj);
        this.dZw.a(this, bundle);
        this.dZw.CB().c(new com.baidu.tbadk.editortools.w(getActivity()));
        this.dZw.CB().bC(true);
        ic(true);
        this.dZk.setEditorTools(this.dZw.CB());
        this.dZw.a(this.dYA.aKs(), this.dYA.getThreadID(), this.dYA.aKK());
        registerListener(this.dgB);
        if (!this.dYA.aKp()) {
            this.dZw.fF(this.dYA.getThreadID());
        }
        if (this.dYA.aKL()) {
            this.dZw.fD(getPageContext().getString(r.j.pb_reply_hint_from_smart_frs));
        } else {
            this.dZw.fD(getPageContext().getString(r.j.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.dYY;
        registerListener(this.bTg);
        registerListener(this.dgY);
        registerListener(this.dZE);
        registerListener(this.aJQ);
        registerListener(this.byX);
        registerListener(this.dZD);
        this.dZv = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.ffW);
        this.dZv.bfy();
        registerListener(this.dZG);
        registerListener(this.bIg);
        if (this.dYA != null) {
            this.dYA.aKD();
        }
        if (TbadkCoreApplication.m9getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.dZK);
        registerListener(this.dZQ);
        registerListener(this.dZP);
        this.dZe = new com.baidu.tieba.pb.pb.main.b(this.dYA, this);
        if (this.dZk != null && this.dZk.aMr() != null && this.dZk.aMs() != null) {
            this.dYS = new com.baidu.tieba.pb.pb.main.a.j(getActivity(), this.dZk.aMr(), this.dZk.aMs());
            this.dYS.a(this.dZJ);
        }
        if (this.dYR && this.dZk != null && this.dZk.aMs() != null) {
            this.dZk.aMs().setVisibility(8);
        }
        this.dZA = new com.baidu.tbadk.core.view.h();
        this.dZA.aeK = 1000L;
        registerListener(this.dZN);
        registerListener(this.dZL);
        registerListener(this.dZM);
        this.dZB = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.dZB;
        userMuteAddAndDelCustomMessage.setTag(this.dZB);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.dZB;
        userMuteCheckCustomMessage.setTag(this.dZB);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public String aIZ() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.j aJa() {
        return this.dYS;
    }

    private void ic(boolean z) {
        this.dZw.bF(z);
        this.dZw.bG(z);
        this.dZw.bH(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.byf != null) {
            this.byf.onStart(getPageContext());
        }
    }

    public er aJb() {
        return this.dZk;
    }

    public dc aJc() {
        return this.dYA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.m9getInst().isReadMenuDialogOnTop()) {
            this.dYU = false;
        } else {
            this.dYU = true;
        }
        super.onPause();
        if (this.dZk.aLy() != null && this.dZk.aLy().aIU() != null) {
            this.dZk.aLy().aIU().onPause();
        }
        BdListView listView = getListView();
        this.dYV = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.dYV == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.byf != null) {
            this.byf.onPause(getPageContext());
        }
        if (this.dZk != null) {
            this.dZk.onPause();
        }
        if (!this.dYA.aKp()) {
            this.dZw.fE(this.dYA.getThreadID());
        }
        if (this.dYA != null) {
            this.dYA.aKE();
        }
        MessageManager.getInstance().unRegisterListener(this.cGK);
        ald();
        MessageManager.getInstance().unRegisterListener(this.dZL);
        MessageManager.getInstance().unRegisterListener(this.dZM);
        MessageManager.getInstance().unRegisterListener(this.dZN);
        MessageManager.getInstance().unRegisterListener(this.bzb);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aJd() {
        com.baidu.tieba.tbadkCore.data.q a2 = com.baidu.tieba.pb.data.g.a(this.dYA.getPbData(), this.dYA.aKl(), this.dYA.aKB());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.dYU = false;
        super.onResume();
        if (this.dZh) {
            this.dZh = false;
            aJA();
        }
        if (this.dZk.aLy() != null && this.dZk.aLy().aIU() != null) {
            this.dZk.aLy().aIU().onResume();
        }
        if (aJd()) {
            this.dZb = System.currentTimeMillis();
        } else {
            this.dZb = -1L;
        }
        if (this.dZk != null && this.dZk.getView() != null) {
            if (!this.dAL) {
                aJs();
            } else {
                hideLoadingView(this.dZk.getView());
            }
            this.dZk.onResume();
        }
        if (this.dYV == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.dZk != null) {
            noNetworkView = this.dZk.aLz();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.gm()) {
            noNetworkView.aK(false);
        }
        if (this.byf != null) {
            this.byf.onResume(getPageContext());
        }
        registerListener(this.cGK);
        this.dZu = false;
        aJz();
        registerListener(this.dZL);
        registerListener(this.dZM);
        registerListener(this.dZN);
        registerListener(this.bzb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.dZk.iC(z);
        if (this.dZp != null) {
            this.dZp.io(z);
        }
        if (z && this.dZu) {
            this.dZk.aLV();
            this.dYA.ik(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dZb > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.at("c10804").ab("obj_duration", new StringBuilder(String.valueOf(System.currentTimeMillis() - this.dZb)).toString()));
            this.dZb = 0L;
        }
        if (this.dZw != null && this.dZw.CB() != null && this.dZw.CB().getVisibility() != 0) {
            this.dZw.Dl();
        }
        if (aJb().aLC() != null) {
            aJb().aLC().onStop();
        }
        if (this.dZk.eeG != null && !this.dZk.eeG.aMH()) {
            this.dZk.eeG.awC();
        }
        if (this.dYA != null && this.dYA.getPbData() != null && this.dYA.getPbData().aIk() != null && this.dYA.getPbData().aIl() != null) {
            com.baidu.tbadk.distribute.a.Ck().b(getPageContext().getPageActivity(), "pb", this.dYA.getPbData().aIk().getId(), com.baidu.adp.lib.h.b.c(this.dYA.getPbData().aIl().getId(), 0L));
        }
        if (this.byf != null) {
            this.byf.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.dZe != null) {
            this.dZe.destroy();
        }
        if (this.dZq && this.dYA != null) {
            a(this.dYA.getPbData(), -2, 0, false, false);
        }
        if (!this.dYZ && this.dZk != null) {
            this.dYZ = true;
            this.dZk.aMj();
            a(false, (com.baidu.tieba.tbadkCore.data.q) null);
        }
        if (this.dYA != null) {
            this.dYA.cancelLoadData();
            this.dYA.destory();
        }
        if (this.dZw != null) {
            this.dZw.onDestroy();
        }
        if (this.dZj != null) {
            this.dZj.cancelLoadData();
        }
        if (this.dZk != null) {
            this.dZk.onDestroy();
            if (this.dZk.eeG != null) {
                this.dZk.eeG.awC();
            }
        }
        if (this.dZa != null) {
            this.dZa.onDestroy();
        }
        if (this.dYS != null) {
            this.dYS.Up();
        }
        super.onDestroy();
        if (this.byf != null) {
            this.byf.onDestory(getPageContext());
        }
        if (this.byF != null) {
            this.byF.destory();
        }
        this.dZk.awl();
        MessageManager.getInstance().unRegisterListener(this.dZL);
        MessageManager.getInstance().unRegisterListener(this.dZM);
        MessageManager.getInstance().unRegisterListener(this.dZN);
        MessageManager.getInstance().unRegisterListener(this.dZB);
        this.dZz = null;
        this.dZA = null;
        com.baidu.tieba.recapp.c.a.aYn().aYp();
        if (this.dZC != null) {
            getSafeHandler().removeCallbacks(this.dZC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.tieba.tbadkCore.data.q qVar) {
        cj aLQ;
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aJM;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xs() && this.dZk != null && (aLQ = this.dZk.aLQ()) != null && (aJM = aLQ.aJM()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.baidu.tieba.tbadkCore.data.q> it = aJM.iterator();
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
                        bVar.bae = id;
                        bVar.bed = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.Ua == 1 && !TextUtils.isEmpty(id)) {
                    next.Ua = 2;
                    a.b bVar2 = new a.b();
                    bVar2.bae = id;
                    bVar2.bed = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.dYA == null || this.dYA.getPbData() == null || this.dYA.getPbData().aIk() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.dYA.getPbData().aIk().getFirst_class();
                    str2 = this.dYA.getPbData().aIk().getSecond_class();
                    str = this.dYA.getPbData().aIk().getId();
                    str4 = this.dYA.getThreadID();
                }
                com.baidu.tieba.recapp.l.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.xu());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dZk.onChangeSkinType(i);
        if (this.dZw != null && this.dZw.CB() != null) {
            this.dZw.CB().onChangeSkinType(i);
        }
        if (this.dZk.aLz() != null) {
            this.dZk.aLz().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.dZk = new er(this, this.bzZ, this.dXp);
        this.bBN = new com.baidu.tieba.d.c(getActivity());
        this.bBN.a(this.eaa);
        this.bBN.a(this.aMk);
        this.dZk.setOnScrollListener(this.BM);
        this.dZk.c(this.dZV);
        this.dZk.a(this.aWB);
        this.dZk.hX(com.baidu.tbadk.core.l.oJ().oP());
        this.dZk.setOnImageClickListener(this.aJq);
        this.dZk.a(this.aou);
        this.dZk.g(this.aSE);
        this.dZk.a(this.dZT);
        this.dZk.iC(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aR(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(r.g.tag_clip_board);
            if (obj instanceof com.baidu.tieba.tbadkCore.data.q) {
                com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) obj;
                if (com.baidu.tieba.tbadkCore.data.q.fgy == qVar.getType() || TextUtils.isEmpty(qVar.getBimg_url()) || !com.baidu.tbadk.core.l.oJ().oP()) {
                    return false;
                }
                return nT(qVar.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.dZk != null) {
            if (z && (!this.dAL || this.dZy)) {
                aJs();
            } else {
                hideLoadingView(this.dZk.getView());
            }
            this.dZy = false;
        }
    }

    private void aJe() {
        if (this.dYW == null) {
            this.dYW = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.dYW.a(new String[]{getPageContext().getString(r.j.call_phone), getPageContext().getString(r.j.sms_phone), getPageContext().getString(r.j.search_in_baidu)}, new ax(this)).cf(c.a.VZ).cg(17).d(getPageContext());
        }
    }

    private void p(Bundle bundle) {
        this.dYA = new dc(this);
        this.dYA.a(this.dZO);
        if (this.dYA.aKJ() != null) {
            this.dYA.aKJ().a(this.eac);
        }
        if (this.dYA.aKI() != null) {
            this.dYA.aKI().a(this.dZF);
        }
        if (bundle != null) {
            this.dYA.initWithBundle(bundle);
        } else {
            this.dYA.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra("request_code", -1) == 18003) {
            this.dYA.in(true);
        }
        ej.aLu().N(this.dYA.aKj(), this.dYA.getIsFromMark());
        if (StringUtils.isNull(this.dYA.getThreadID())) {
            finish();
        } else {
            this.dYA.EN();
        }
    }

    private void initData(Bundle bundle) {
        this.dxb = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dxb != null) {
            this.dxb.a(this.dZR);
        }
        this.dZj = new com.baidu.tieba.tbadkCore.f.a(this);
        this.dZj.setLoadDataCallBack(this.dZS);
        this.dZk.a(new ay(this));
        this.dZI.setUniqueId(getUniqueId());
        this.dZI.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.dZk.aub();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.h.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.h.b.c((String) sparseArray.get(r.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.dZB;
        userMuteCheckCustomMessage.setTag(this.dZB);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJf() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.ca(r.j.go_setting_float_window_permission);
        aVar.cb(r.j.step_to_setting_float_permission);
        aVar.a(r.j.go_and_setting, new az(this));
        aVar.b(r.j.cancel, new bb(this));
        aVar.b(getPageContext()).tb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aJg() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.dYA != null && this.dYA.getPbData() != null) {
            com.baidu.tieba.pb.data.f pbData = this.dYA.getPbData();
            if (pbData.aIk() != null) {
                sb.append("forum_name=").append(nQ(pbData.aIk().getName()));
                sb.append("&");
            }
            if (pbData.aIl() != null) {
                com.baidu.tbadk.core.data.bg aIl = pbData.aIl();
                sb.append("thread_id=").append(aIl.getId());
                sb.append("&");
                sb.append("thread_title=").append(nQ(aIl.getTitle()));
                if (aIl.getAuthor() != null && aIl.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aIl.getAuthor().getPortrait());
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

    private String nQ(String str) {
        return URLEncoder.encode(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3021=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        com.baidu.tieba.tbadkCore.data.q qVar;
        if (!checkUpIsLogin() || sparseArray == null || !(sparseArray.get(r.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.q) || (qVar = (com.baidu.tieba.tbadkCore.data.q) sparseArray.get(r.g.tag_clip_board)) == null || this.dYA == null || this.dYA.getPbData() == null || qVar.bga() <= 1) {
            return;
        }
        String threadID = this.dYA.getThreadID();
        String id = qVar.getId();
        int aIu = this.dYA.getPbData() != null ? this.dYA.getPbData().aIu() : 0;
        b nU = nU(id);
        if (nU != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, aIu, qVar.aNF(), this.dYA.getPbData().qt(), false, qVar.getAuthor() != null ? qVar.getAuthor().getIconInfo() : null).addBigImageData(nU.eay, nU.eaz, nU.eaA, nU.index)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aJh() {
        if (this.dYA.getPbData() == null || this.dYA.getPbData().aIl() == null) {
            return -1;
        }
        return this.dYA.getPbData().aIl().sh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean id(boolean z) {
        if (this.dYA == null || this.dYA.getPbData() == null) {
            return false;
        }
        return ((this.dYA.getPbData().aIu() != 0) || this.dYA.getPbData().aIl() == null || this.dYA.getPbData().aIl().getAuthor() == null || TextUtils.equals(this.dYA.getPbData().aIl().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean ie(boolean z) {
        if (z) {
            return true;
        }
        if (this.dYA == null || this.dYA.getPbData() == null) {
            return false;
        }
        return this.dYA.getPbData().aIu() != 0;
    }

    /* renamed from: if  reason: not valid java name */
    private boolean m22if(boolean z) {
        return (z || this.dYA == null || this.dYA.getPbData() == null || this.dYA.getPbData().aIu() == 0) ? false : true;
    }

    public void aJi() {
        boolean z = true;
        if (this.dYA != null && this.dYA.getPbData() != null && this.dYA.getPbData().aIl() != null && this.dYA.getPbData().aIl().getAuthor() != null) {
            com.baidu.tbadk.core.data.bg aIl = this.dYA.getPbData().aIl();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aIl.getAuthor().getUserId());
            GodUserData godUserData = aIl.getAuthor().getGodUserData();
            boolean z2 = equals && godUserData != null && godUserData.isCanSendCall();
            dn dnVar = new dn();
            if (!this.dYA.getPbData().aIr() && TbadkCoreApplication.m9getInst().isTTSCanUse()) {
                dnVar.ecR = true;
            }
            if (this.dYA.getPbData().aIu() == 1) {
                dnVar.ecU = true;
                dnVar.ecT = true;
                dnVar.ecZ = aIl.rA() == 1;
                dnVar.ecY = aIl.rB() == 1;
            } else {
                dnVar.ecU = false;
                dnVar.ecT = false;
            }
            dnVar.ecS = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteShareActivityConfig.class);
            dnVar.ecP = TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            dnVar.ecV = ie(equals);
            dnVar.ecW = aJj();
            dnVar.ecX = m22if(equals);
            dnVar.ecQ = this.dYA.aKl();
            dnVar.dXc = this.dxb != null ? this.dxb.nz() : false;
            dnVar.ecO = id(equals);
            if (!equals || !this.dZk.aMa()) {
                z = false;
            }
            dnVar.ecM = z;
            dnVar.ecN = z2;
            this.dZk.eeG.a(dnVar);
        }
    }

    private boolean aJj() {
        if (this.dYA != null && this.dYA.aKl()) {
            return this.dYA.alG() == null || this.dYA.alG().qF() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(View view) {
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
    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, boolean z2) {
        if (fVar != null && this.dYA != null) {
            ea eaVar = new ea(getUniqueId());
            eaVar.pbData = fVar;
            eaVar.threadId = this.dYA.getThreadID();
            eaVar.postId = this.dYA.getPostId();
            eaVar.edY = i;
            eaVar.edZ = i2;
            eaVar.edX = this.dYA.getHostMode();
            eaVar.dXc = this.dYA.nz();
            eaVar.isSquence = this.dYA.aKl();
            eaVar.loadType = this.dYA.aKG();
            eaVar.eea = z;
            eaVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, eaVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, boolean z2) {
        if (fVar != null && this.dYA != null) {
            ea eaVar = new ea(getUniqueId());
            eaVar.pbData = fVar;
            eaVar.threadId = this.dYA.getThreadID();
            eaVar.postId = this.dYA.getPostId();
            eaVar.edY = i;
            eaVar.edX = this.dYA.getHostMode();
            eaVar.dXc = this.dYA.nz();
            eaVar.isSquence = this.dYA.aKl();
            eaVar.loadType = this.dYA.aKG();
            eaVar.eea = z;
            eaVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, eaVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        avT();
    }

    public void a(boolean z, MarkData markData) {
        this.dZk.aLW();
        this.dYA.im(z);
        if (this.dxb != null) {
            this.dxb.ad(z);
            if (markData != null) {
                this.dxb.a(markData);
            }
        }
        if (this.dYA.nz()) {
            aJp();
        } else {
            this.dZk.j(this.dYA.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nx(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nR(String str) {
        if (!StringUtils.isNull(str) && this.dYA != null) {
            String threadID = this.dYA.getThreadID();
            String id = this.dYA.getPbData().aIk().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(r.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.dYA.aKp()) {
                    antiData.setBlock_forum_name(this.dYA.getPbData().aIk().getName());
                    antiData.setBlock_forum_id(this.dYA.getPbData().aIk().getId());
                    antiData.setUser_name(this.dYA.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.dYA.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.f.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.rp(i)) {
            AntiHelper.S(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            fL(str);
        } else {
            this.dZk.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.dZk.a(0, bVar.uc, bVar.fiH, z);
            if (bVar.uc) {
                if (bVar.fiF == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.q> aIm = this.dYA.getPbData().aIm();
                    int size = aIm.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aIm.get(i).getId())) {
                            i++;
                        } else {
                            aIm.remove(i);
                            break;
                        }
                    }
                    this.dZk.j(this.dYA.getPbData());
                } else if (bVar.fiF == 0) {
                    aJk();
                } else if (bVar.fiF == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.q> aIm2 = this.dYA.getPbData().aIm();
                    int size2 = aIm2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aIm2.get(i2).bfX().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aIm2.get(i2).bfX().get(i3).getId())) {
                                i3++;
                            } else {
                                aIm2.get(i2).bfX().remove(i3);
                                aIm2.get(i2).bfZ();
                                z2 = true;
                                break;
                            }
                        }
                        aIm2.get(i2).qk(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.dZk.j(this.dYA.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, a.f fVar) {
        if (fVar != null) {
            this.dZk.a(this.dZj.getLoadDataMode(), fVar.uc, fVar.fiH, false);
            if (fVar.uc) {
                this.dZm = true;
                if (i == 2 || i == 3) {
                    this.dZn = true;
                    this.dZo = false;
                } else if (i == 4 || i == 5) {
                    this.dZn = false;
                    this.dZo = true;
                }
                if (i == 2) {
                    this.dYA.getPbData().aIl().bX(1);
                    this.dYA.setIsGood(1);
                } else if (i == 3) {
                    this.dYA.getPbData().aIl().bX(0);
                    this.dYA.setIsGood(0);
                } else if (i == 4) {
                    this.dYA.getPbData().aIl().bW(1);
                    this.dYA.nD(1);
                } else if (i == 5) {
                    this.dYA.getPbData().aIl().bW(0);
                    this.dYA.nD(0);
                }
                this.dZk.a(this.dYA.getPbData(), this.dYA.aKl(), true);
                com.baidu.tieba.c.a.a(getPageContext(), 2, i);
            }
        }
    }

    private void aJk() {
        if (this.dYA.aKm() || this.dYA.aKn()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.dYA.getThreadID());
            setResult(-1, intent);
        }
        if (aJq()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJl() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aIs;
        if (this.dZk != null) {
            this.dZk.awl();
        }
        if (this.dYA != null && this.dYA.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.dYA.getPbData().aIl().getId();
            historyMessage.forumName = this.dYA.getPbData().aIk().getName();
            historyMessage.threadName = this.dYA.getPbData().aIl().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aIm = this.dYA.getPbData().aIm();
            int aLY = this.dZk != null ? this.dZk.aLY() : 0;
            if (aIm != null && aLY >= 0 && aLY < aIm.size()) {
                historyMessage.postID = aIm.get(aLY).getId();
            }
            historyMessage.isHostOnly = this.dYA.getHostMode();
            historyMessage.isSquence = this.dYA.aKl();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.dZw != null) {
            this.dZw.onDestroy();
        }
        if (this.dYA != null && (this.dYA.aKm() || this.dYA.aKn())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.dYA.getThreadID());
            if (this.dZm) {
                if (this.dZo) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.dYA.awc());
                }
                if (this.dZn) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.dYA.getIsGood());
                }
            }
            if (this.dYA.getPbData() != null && System.currentTimeMillis() - this.dYY >= 40000 && (aIs = this.dYA.getPbData().aIs()) != null && !com.baidu.tbadk.core.util.x.t(aIs.getDataList())) {
                intent.putExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA, aIs);
            }
            setResult(-1, intent);
        }
        if (aJq()) {
            if (this.dYA != null && this.dZk != null && this.dZk.Pv() != null) {
                com.baidu.tieba.pb.data.f pbData = this.dYA.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.m9getInst().getDefaultBubble());
                    }
                    if (!pbData.aIr()) {
                        ej.aLu().a(this.dYA.getPbData(), this.dZk.Pv().onSaveInstanceState(), this.dYA.aKl(), this.dYA.getHostMode());
                    }
                }
            } else {
                ej.aLu().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.dZk != null && this.dZk.aKe()) {
                    this.dZk.aKg();
                    return true;
                }
                return super.onKeyDown(i, keyEvent);
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ny(int i) {
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
        this.dZw.onActivityResult(i, i2, intent);
        if (aJb().aLC() != null) {
            aJb().aLC().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aJo();
                    return;
                case 13008:
                    ej.aLu().reset();
                    this.mHandler.postDelayed(new bd(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.dYA != null) {
                        a(aJn(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                    if (aJh() == 1) {
                        aJm();
                        return;
                    }
                    return;
                case 24008:
                    this.dZk.ia(false);
                    if (this.dYA.getPbData() != null && this.dYA.getPbData().aIl() != null && this.dYA.getPbData().aIl().rY() != null) {
                        this.dYA.getPbData().aIl().rY().setStatus(2);
                        break;
                    }
                    break;
                case 25001:
                    break;
                default:
                    return;
            }
            if (this.dZe != null) {
                this.dZe.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aJb() != null && aIX() != null && aJb().aLE() && com.baidu.tbadk.editortools.e.b.CY().getStatus() == 1) {
                    com.baidu.tbadk.editortools.e.b.CY().setStatus(0);
                    if (this.dZk != null) {
                        this.dZk.aLD();
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
    public void aJm() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.dYA.getPbData() != null && this.dYA.getPbData().aIl() != null && this.dYA.getPbData().aIl().rQ() != null && this.dYA.getPbData().aIl().rQ().size() > 0 && this.dYA.getPbData().aIl().rQ().get(0) != null) {
            this.mAwardActId = this.dYA.getPbData().aIl().rQ().get(0).pe();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.h.b.c(this.dYA.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void t(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra("key_action", 0)) {
                case 1:
                    acJ();
                    return;
                case 2:
                    this.dZk.aLO();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aJn() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bh = this.dYA.getPbData().bh(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.data.q aLF = this.dZk.aLF();
        String str = "";
        if (aLF != null) {
            str = aLF.getId();
            String bt = aLF.bt(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(bt)) {
                bh[1] = bt;
            }
        }
        String rV = this.dYA.getPbData().aIl().rV();
        if (rV != null && rV.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bh[1]);
        shareFromPBMsgData.setImageUrl(bh[0]);
        shareFromPBMsgData.setForumName(this.dYA.getPbData().aIk().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.dYA.getPbData().aIl().getId());
        shareFromPBMsgData.setTitle(this.dYA.getPbData().aIl().getTitle());
        return shareFromPBMsgData;
    }

    private void u(Intent intent) {
        a(aJn(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.dYA != null && this.dYA.getPbData() != null && this.dYA.getPbData().aIl() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gi giVar = new gi(getPageContext().getPageActivity());
            giVar.setData(shareFromPBMsgData);
            aVar.cd(1);
            aVar.z(giVar);
            aVar.a(r.j.share, new be(this, giVar, j, str, str2, shareFromPBMsgData));
            aVar.b(r.j.alert_no_button, new bf(this, giVar));
            aVar.av(true);
            aVar.b(getPageContext()).tb();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                giVar.G(shareFromPBMsgData.getImageUrl(), this.dYA.getPbData().aIv() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.dYA != null && this.dYA.getPbData() != null && this.dYA.getPbData().aIl() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gi giVar = new gi(getPageContext().getPageActivity());
            giVar.setData(shareFromPBMsgData);
            aVar.cd(1);
            aVar.z(giVar);
            aVar.a(r.j.share, new bg(this, giVar, i, str, j, shareFromPBMsgData));
            aVar.b(r.j.alert_no_button, new bh(this, giVar));
            aVar.av(true);
            aVar.b(getPageContext()).tb();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                giVar.G(shareFromPBMsgData.getImageUrl(), this.dYA.getPbData().aIv() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJo() {
        MarkData nK;
        if (this.dxb != null && (nK = this.dYA.nK(this.dZk.aLZ())) != null) {
            if (!nK.isApp() || (nK = this.dYA.nK(this.dZk.aLZ() + 1)) != null) {
                this.dZk.aLU();
                this.dxb.a(nK);
                if (!this.dxb.nz()) {
                    this.dxb.nB();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.dxb.nA();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJp() {
        com.baidu.tieba.pb.data.f pbData = this.dYA.getPbData();
        this.dYA.im(true);
        pbData.nM(this.dxb.ny());
        this.dZk.j(pbData);
    }

    private boolean aJq() {
        if (this.dYA == null) {
            return true;
        }
        if (this.dYA.nz()) {
            MarkData aKx = this.dYA.aKx();
            if (aKx == null || !this.dYA.getIsFromMark()) {
                return true;
            }
            MarkData nK = this.dYA.nK(this.dZk.aLZ());
            if (nK == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aKx);
                setResult(-1, intent);
                return true;
            } else if (nK.getPostId() == null || nK.getPostId().equals(aKx.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aKx);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cG(String.format(getPageContext().getString(r.j.alert_update_mark), Integer.valueOf(nK.getFloor())));
                aVar.a(r.j.alert_yes_btn, new bi(this, nK, aKx, aVar));
                aVar.b(r.j.alert_no_button, new bj(this, aKx, aVar));
                aVar.a(new bk(this, aKx, aVar));
                aVar.b(getPageContext());
                aVar.tb();
                return false;
            }
        } else if (this.dYA.getPbData() == null || this.dYA.getPbData().aIm() == null || this.dYA.getPbData().aIm().size() <= 0 || !this.dYA.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: Pv */
    public BdListView getListView() {
        if (this.dZk == null) {
            return null;
        }
        return this.dZk.Pv();
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public int Ia() {
        if (this.dZk == null) {
            return 0;
        }
        return this.dZk.aMe();
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<ImageView> Ib() {
        if (this.aIV == null) {
            this.aIV = new com.baidu.adp.lib.f.b<>(new bm(this), 8, 0);
        }
        return this.aIV;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<TextView> Ic() {
        if (this.aIW == null) {
            this.aIW = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.aIW;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<GifView> Id() {
        if (this.aJa == null) {
            this.aJa = new com.baidu.adp.lib.f.b<>(new bn(this), 20, 0);
        }
        return this.aJa;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> Ie() {
        if (this.aIY == null) {
            this.aIY = new com.baidu.adp.lib.f.b<>(new bo(this), 8, 0);
        }
        return this.aIY;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> Ig() {
        if (this.aIX == null) {
            this.aIX = com.baidu.tieba.graffiti.e.l(getPageContext().getPageActivity(), 6);
        }
        return this.aIX;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> wF() {
        if (this.ahl == null) {
            this.ahl = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.ahl;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void A(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.dZd = true;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void B(Context context, String str) {
        if (gj.oe(str) && this.dYA != null && this.dYA.getThreadID() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11664").s("obj_param1", 1).ab("post_id", this.dYA.getThreadID()));
        }
        gj.aMA().h(getPageContext(), str);
        this.dZd = true;
    }

    private com.baidu.tbadk.core.dialog.a aJr() {
        if (this.dYX == null) {
            this.dYX = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.dYX.cF(getPageContext().getString(r.j.download_baidu_video_dialog));
            this.dYX.a(getPageContext().getString(r.j.install), new bp(this));
            this.dYX.b(getPageContext().getString(r.j.cancel), new bq(this));
            this.dYX.au(true);
            this.dYX.b(getPageContext());
            this.dYX.av(false);
        }
        this.dYX.tb();
        return this.dYX;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void C(Context context, String str) {
        gj.aMA().h(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.dZd = true;
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
            aJr();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.dZd = true;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void D(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        com.baidu.tbadk.widget.richText.c cVar;
        int a2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.dYA.getPbData();
            com.baidu.tbadk.widget.richText.a at = at(str, i);
            if (at != null && (cVar = at.Hy().get(this.dZW)) != null) {
                bVar.eay = new ArrayList<>();
                bVar.eaz = new ConcurrentHashMap<>();
                if (!cVar.HD().HP()) {
                    bVar.eaB = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(cVar);
                    bVar.eay.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(cVar);
                    imageUrlData.originalSize = e(cVar);
                    imageUrlData.postId = at.getPostId();
                    imageUrlData.mIsReserver = this.dYA.aKw();
                    imageUrlData.mIsSeeHost = this.dYA.getHostMode();
                    bVar.eaz.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aIk() != null) {
                            bVar.forumName = pbData.aIk().getName();
                            bVar.forumId = pbData.aIk().getId();
                        }
                        if (pbData.aIl() != null) {
                            bVar.threadId = pbData.aIl().getId();
                        }
                        bVar.eaA = pbData.aIv() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.eaB = true;
                int size = pbData.aIm().size();
                this.dZX = false;
                bVar.index = -1;
                int i2 = 0;
                int i3 = i;
                while (i2 < size) {
                    com.baidu.tieba.tbadkCore.data.q qVar = pbData.aIm().get(i2);
                    com.baidu.tbadk.widget.richText.a avP = qVar.avP();
                    if (!eq.h(qVar)) {
                        a2 = a(avP, at, i3, i, bVar.eay, bVar.eaz);
                    } else {
                        a2 = a(qVar, i3, bVar.eay, bVar.eaz);
                    }
                    i2++;
                    i3 = a2;
                }
                if (bVar.eay.size() > 0) {
                    bVar.lastId = bVar.eay.get(bVar.eay.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aIk() != null) {
                        bVar.forumName = pbData.aIk().getName();
                        bVar.forumId = pbData.aIk().getId();
                    }
                    if (pbData.aIl() != null) {
                        bVar.threadId = pbData.aIl().getId();
                    }
                    bVar.eaA = pbData.aIv() == 1;
                }
                bVar.index = i3;
            }
        }
    }

    private String d(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.HD() == null) {
            return null;
        }
        return cVar.HD().HT();
    }

    private long e(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.HD() == null) {
            return 0L;
        }
        return cVar.HD().getOriginalSize();
    }

    private int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.g HD;
        if (aVar == aVar2) {
            this.dZX = true;
        }
        if (aVar != null) {
            int size = aVar.Hy().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.Hy().get(i6) == null || aVar.Hy().get(i6).getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int width = aVar.Hy().get(i6).HD().getWidth();
                    int height = aVar.Hy().get(i6).HD().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.Hy().get(i6).HD().HP()) {
                        if (aVar == aVar2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.Hy().get(i6);
                        String c2 = com.baidu.tieba.pb.data.g.c(cVar);
                        if (!TextUtils.isEmpty(c2)) {
                            arrayList.add(c2);
                            if (cVar != null && (HD = cVar.HD()) != null) {
                                String HR = HD.HR();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = HR;
                                imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.originalUrl = d(cVar);
                                imageUrlData.originalSize = e(cVar);
                                imageUrlData.postId = aVar.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.h.b.c(this.dYA.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.dYA.aKw();
                                imageUrlData.mIsSeeHost = this.dYA.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.dZX) {
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
        ArrayList<com.baidu.tieba.tbadkCore.data.k> bfC;
        if (qVar != null && arrayList != null && concurrentHashMap != null && (bfC = qVar.bgi().bfC()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bfC.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = bfC.get(i3);
                if (kVar != null) {
                    String bfJ = kVar.bfJ();
                    if (!com.baidu.tbadk.core.util.av.isEmpty(bfJ)) {
                        arrayList.add(bfJ);
                        if (!this.dZX) {
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
            if (qVar.getId() != null && qVar.getId().equals(this.dYA.rO())) {
                z = true;
            }
            MarkData f = this.dYA.f(qVar);
            if (f != null) {
                this.dZk.aLU();
                if (this.dxb != null) {
                    this.dxb.a(f);
                    if (!z) {
                        this.dxb.nB();
                    } else {
                        this.dxb.nA();
                    }
                }
            }
        }
    }

    private com.baidu.tbadk.widget.richText.a at(String str, int i) {
        if (this.dYA == null || this.dYA.getPbData() == null || str == null || i < 0) {
            return null;
        }
        return a(this.dYA.getPbData().aIm(), str, i);
    }

    private long nS(String str) {
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aIm;
        com.baidu.tieba.pb.data.f pbData = this.dYA.getPbData();
        if (pbData != null && (aIm = pbData.aIm()) != null && !aIm.isEmpty()) {
            Iterator<com.baidu.tieba.tbadkCore.data.q> it = aIm.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.q next = it.next();
                com.baidu.tieba.tbadkCore.data.i bgi = next.bgi();
                if (bgi != null && bgi.fge) {
                    Iterator<com.baidu.tbadk.widget.richText.c> it2 = next.avP().Hy().iterator();
                    while (it2.hasNext()) {
                        com.baidu.tbadk.widget.richText.c next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.HL().getLink().equals(str)) {
                            return bgi.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> Hy;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a avP = arrayList.get(i2).avP();
            if (avP != null && (Hy = avP.Hy()) != null) {
                int size = Hy.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Hy.get(i4) != null && Hy.get(i4).getType() == 8) {
                        i3++;
                        if (Hy.get(i4).HD().HR().equals(str)) {
                            int width = Hy.get(i4).HD().getWidth();
                            int height = Hy.get(i4).HD().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.dZW = i4;
                            return avP;
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
            this.dYy = str;
            if (this.dYW == null) {
                aJe();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.dYW.ci(1).setVisibility(8);
            } else {
                this.dYW.ci(1).setVisibility(0);
            }
            this.dYW.te();
            this.dZd = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.byf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avT() {
        hideNetRefreshView(this.dZk.getView());
        aJs();
        if (this.dYA.EN()) {
            this.dZk.aLU();
        }
    }

    private void aJs() {
        showLoadingView(this.dZk.getView(), false, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds400));
        View En = getLoadingView().En();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) En.getLayoutParams();
        layoutParams.addRule(3, this.dZk.aMr().getId());
        En.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WD() {
        if (this.byf != null) {
            this.byf.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acJ() {
        if (this.dYA.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.dYA.getPbData();
            String name = pbData.aIk().getName();
            String title = pbData.aIl().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.dYA.getThreadID() + "?share=9105&fr=share&see_lz=" + (this.dYA.getHostMode() ? 1 : 0);
            String[] bh = pbData.bh(getPageContext().getPageActivity());
            String str2 = bh[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = bh[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (aJh() == 1) {
                if (pbData != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.at("c10399").ab("fid", pbData.getForumId()).ab("tid", pbData.getThreadId()).ab(SapiAccountManager.SESSION_UID, currentAccount));
                }
            } else if (aJh() == 2 && pbData != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.at("c10406").ab("fid", pbData.getForumId()).ab("tid", pbData.getThreadId()).ab(SapiAccountManager.SESSION_UID, currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(r.j.share_content_tpl), title, name, str3);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.linkUrl = str;
            fVar.ano = true;
            fVar.extData = this.dYA.getThreadID();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(r.j.forum_friend, r.f.icon_unite_share_baf, new br(this));
            shareDialogConfig.setCopyLinkListener(new bs(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<LinearLayout> If() {
        if (this.aIZ == null) {
            this.aIZ = new com.baidu.adp.lib.f.b<>(new bt(this), 15, 0);
        }
        return this.aIZ;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.dZk.aLP() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.at("c10517").s("obj_locate", 2).ab("fid", this.dYA.getPbData().getForumId()));
            } else {
                com.baidu.tbadk.core.data.bg aIl = this.dYA.getPbData().aIl();
                if (view != null) {
                    boolean z = aIl.rv() == null || aIl.rv().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.dXn > 1000) {
                            this.dXo = true;
                            aT(view);
                        } else {
                            this.dXo = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            e(view, this.dXo);
                        } else {
                            d(view, this.dXo);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        d(view, this.dXo);
                    } else if (motionEvent.getAction() == 3) {
                        d(view, this.dXo);
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

    private void aT(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), r.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void WE() {
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
        } else if (aVar.td() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.td();
            int intValue = ((Integer) sparseArray.get(er.egl)).intValue();
            if (intValue == er.egm) {
                if (!this.dZj.bgO()) {
                    this.dZk.aLR();
                    int intValue2 = ((Integer) sparseArray.get(r.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(r.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(r.g.tag_del_post_type)).intValue();
                    this.dZj.a(this.dYA.getPbData().aIk().getId(), this.dYA.getPbData().aIk().getName(), this.dYA.getPbData().aIl().getId(), (String) sparseArray.get(r.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == er.egn || intValue == er.egp) {
                if (this.dYA.aKJ() != null) {
                    this.dYA.aKJ().nC(dc.ebn);
                }
                if (intValue == er.egn) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == er.ego) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.eab).oZ()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.dZB);
        userMuteAddAndDelCustomMessage.setTag(this.dZB);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean nT(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bh.ai(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.tW().getString("bubble_link", ""))) {
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

    public void ig(boolean z) {
        this.dZu = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aJt() {
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aIm;
        int s;
        if (this.dYA == null || this.dYA.getPbData() == null || this.dYA.getPbData().aIm() == null || (s = com.baidu.tbadk.core.util.x.s((aIm = this.dYA.getPbData().aIm()))) == 0) {
            return "";
        }
        int aLY = this.dZk.aLY();
        com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(aIm, aLY);
        if (qVar == null || qVar.getAuthor() == null) {
            return "";
        }
        if (this.dYA.nX(qVar.getAuthor().getUserId())) {
            return qVar.getId();
        }
        for (int i = aLY - 1; i != 0; i--) {
            com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(aIm, i);
            if (qVar2 == null || qVar2.getAuthor() == null || qVar2.getAuthor().getUserId() == null) {
                break;
            } else if (this.dYA.nX(qVar2.getAuthor().getUserId())) {
                return qVar2.getId();
            }
        }
        for (int i2 = aLY + 1; i2 < s; i2++) {
            com.baidu.tieba.tbadkCore.data.q qVar3 = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(aIm, i2);
            if (qVar3 == null || qVar3.getAuthor() == null || qVar3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.dYA.nX(qVar3.getAuthor().getUserId())) {
                return qVar3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void F(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.bc.vz().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.b.a(nS(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.dYA.getPbData().aIk().getId(), this.dYA.getPbData().aIk().getName(), this.dYA.getPbData().aIl().getTid());
            }
            this.dZd = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, String str2, String str3, String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cG(getResources().getString(r.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cG(getResources().getString(r.j.make_sure_hide));
        }
        aVar.a(getResources().getString(r.j.alert_yes_button), new bx(this, j, str, str2, str3, str4));
        aVar.b(getResources().getString(r.j.alert_no_button), new by(this, j, str, str2, str3, str4));
        aVar.av(false);
        aVar.b(getPageContext());
        aVar.tb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b nU(String str) {
        String str2;
        if (this.dYA.getPbData() == null || this.dYA.getPbData().aIm() == null || this.dYA.getPbData().aIm().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i < this.dYA.getPbData().aIm().size()) {
                if (str.equals(this.dYA.getPbData().aIm().get(i).getId())) {
                    break;
                }
                i++;
            } else {
                i = 0;
                break;
            }
        }
        com.baidu.tieba.tbadkCore.data.q qVar = this.dYA.getPbData().aIm().get(i);
        if (qVar.avP() == null || qVar.avP().Hy() == null) {
            return null;
        }
        Iterator<com.baidu.tbadk.widget.richText.c> it = qVar.avP().Hy().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.HD() != null) {
                    str2 = next.HD().HR();
                }
            }
        }
        a(str2, 0, bVar);
        com.baidu.tieba.pb.data.g.a(qVar, bVar);
        return bVar;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.dYT) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.dYT = false;
        } else if (aJu()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.dYT) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.dYT = false;
        } else if (aJu()) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void ih(boolean z) {
        this.dZx = z;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a005";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.dYA != null) {
            if (this.dYA.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(this.dYA.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.h.b.c(this.dYA.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aJu() {
        return (!this.dYR && this.ead == -1 && this.eae == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.eag = nVar;
            this.dYR = true;
            this.dZk.aLG();
            this.dZk.od(this.eaf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJv() {
        if (this.eag != null) {
            if (this.ead == -1) {
                showToast(r.j.pb_manga_not_prev_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eag.getCartoonId(), this.ead, 0)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJw() {
        if (this.eag != null) {
            if (this.eae == -1) {
                showToast(r.j.pb_manga_not_next_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eag.getCartoonId(), this.eae, 0)));
            finish();
        }
    }

    public int aJx() {
        return this.ead;
    }

    public int aJy() {
        return this.eae;
    }

    private void ald() {
        if (this.dYA != null && this.dYA.getPbData() != null && this.dYA.getPbData().aIl() != null && this.dYA.getPbData().aIl().sq()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aJz() {
        if (this.dYA != null && this.dYA.getPbData() != null && this.dYA.getPbData().aIl() != null && this.dYA.getPbData().aIl().sq()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aJA() {
        if (this.dYU) {
            this.dZh = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.dYA.getPbData() != null && this.dYA.getPbData().aIl() != null && this.dYA.getPbData().aIl().ro() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.dYA.getPbData().aIl().ro().getThreadId(), this.dYA.getPbData().aIl().ro().getTaskId(), this.dYA.getPbData().aIl().ro().getForumId(), this.dYA.getPbData().aIl().ro().getForumName(), this.dYA.getPbData().aIl().rA(), this.dYA.getPbData().aIl().rB())));
            this.dYT = true;
            finish();
        }
    }

    public boolean aJB() {
        return this.dYU;
    }

    public String aJC() {
        return this.dZf;
    }

    public PbInterviewStatusView.a aJD() {
        return this.dZi;
    }

    public void ii(boolean z) {
        this.dZg = z;
    }

    public boolean aJE() {
        if (this.dYA != null) {
            return this.dYA.aKm();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cG(getResources().getString(r.j.mute_is_super_member_function));
        aVar.a(r.j.open_now, new bz(this));
        aVar.b(r.j.cancel, new ca(this));
        aVar.b(this.dZz).tb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fL(String str) {
        if (str == null) {
            str = "";
        }
        if (this.dZz != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dZz.getPageActivity());
            aVar.cG(str);
            aVar.b(r.j.know, new cb(this));
            aVar.b(this.dZz).tb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.dZk.aub();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dZz.getPageActivity());
        if (com.baidu.tbadk.core.util.av.isEmpty(str)) {
            aVar.cG(this.dZz.getResources().getString(r.j.block_mute_message_alert, str2));
        } else {
            aVar.cG(str);
        }
        aVar.a(r.j.confirm, new cc(this, userMuteAddAndDelCustomMessage));
        aVar.b(r.j.cancel, new cd(this));
        aVar.b(this.dZz).tb();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.b
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.h[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.h.class);
            for (int i = 0; i < objArr.length; i++) {
                if (gj.oe(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_pb_wenxue)) != null) {
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
