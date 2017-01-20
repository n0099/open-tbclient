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
import com.baidu.tbadk.core.view.aa;
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
import com.baidu.tieba.f.a;
import com.baidu.tieba.f.c;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.a.f;
import com.baidu.tieba.pb.pb.main.cy;
import com.baidu.tieba.pb.pb.main.db;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.b, com.baidu.tbadk.widget.richText.d {
    private com.baidu.adp.lib.e.b<ImageView> aHC;
    private com.baidu.adp.lib.e.b<TextView> aHD;
    private com.baidu.adp.lib.e.b<View> aHE;
    private com.baidu.adp.lib.e.b<View> aHF;
    private com.baidu.adp.lib.e.b<LinearLayout> aHG;
    private com.baidu.adp.lib.e.b<GifView> aHH;
    private com.baidu.adp.lib.e.b<TbImageView> agy;
    private VoiceManager bFE;
    private com.baidu.tbadk.e.a bGe;
    private com.baidu.tieba.f.c bJg;
    private com.baidu.tieba.pb.pb.main.a.f ehA;
    private com.baidu.tbadk.core.dialog.a ehF;
    private com.baidu.tieba.pb.pb.main.b ehM;
    private Runnable ehS;
    private String ehf;
    private boolean eiH;
    private String eiS;
    private com.baidu.tbadk.core.data.o eiT;
    private dq eia;
    private boolean eif;
    private com.baidu.tieba.tbadkCore.data.e eig;
    private com.baidu.tbadk.editortools.pb.c eih;
    private com.baidu.adp.base.g eik;
    private com.baidu.tbadk.core.view.h eil;
    private BdUniqueId eim;
    private Runnable ein;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean ehz = false;
    private boolean ehB = false;
    private boolean ehC = false;
    private boolean dJT = false;
    private int ehD = 0;
    private com.baidu.tbadk.core.dialog.c ehE = null;
    private long bxH = -1;
    private long aAX = 0;
    private long ehG = 0;
    private long createTime = 0;
    private long aAP = 0;
    private boolean ehH = false;
    private com.baidu.tbadk.performanceLog.e ehI = null;
    private long ehJ = 0;
    private boolean ehK = false;
    private boolean ehL = false;
    private String avj = null;
    private boolean ehN = false;
    private boolean ehO = false;
    private String ehP = "";
    private boolean ehQ = true;
    private boolean ehR = false;
    private String source = "";
    private PbInterviewStatusView.a ehT = new i(this);
    private final Handler mHandler = new Handler(new t(this));
    private PbModel ehh = null;
    private com.baidu.tbadk.baseEditMark.a dGi = null;
    private ForumManageModel ehU = null;
    private ez ehV = null;
    public final com.baidu.tieba.pb.pb.main.a.a ehW = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean ehX = false;
    private boolean ehY = false;
    private boolean ehZ = false;
    private boolean eib = false;
    private boolean eic = false;
    private boolean eid = false;
    private boolean eie = false;
    private boolean eii = false;
    private com.baidu.tbadk.editortools.pb.b avn = new ae(this);
    private boolean eij = false;
    private int cBH = -1;
    private final CustomMessageListener eio = new ap(this, CmdConfigCustom.PB_RESET_EDITOR_TOOL);
    CustomMessageListener bGx = new ba(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private CustomMessageListener bZD = new bl(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener dnK = new bv(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener doi = new cf(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener eip = new cj(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener aIx = new j(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
    private CustomMessageListener cNS = new k(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private cy.a eiq = new l(this);
    private View.OnClickListener dnJ = new m(this);
    private CustomMessageListener eir = new n(this, CmdConfigCustom.CMD_SEND_GIFT_SUCCESS);
    private boolean eis = false;
    private PraiseModel eit = new PraiseModel(getPageContext(), new o(this));
    private long eiu = 0;
    private boolean eiv = true;
    private f.a eiw = new p(this);
    private CustomMessageListener aTR = new q(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener eix = new r(this, CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED);
    private com.baidu.tieba.pb.a.d egn = new com.baidu.tieba.pb.a.d(new s(this));
    private CustomMessageListener eiy = new u(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener eiz = new v(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener eiA = new w(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    public a.b dSL = new x(this);
    public final View.OnClickListener bHz = new y(this);
    private final NewWriteModel.d avt = new z(this);
    private final PbModel.a eiB = new aa(this);
    private CustomMessageListener eiC = new ab(this, CmdConfigCustom.CMD_WX_SHARE_SUCCESS);
    private CustomMessageListener eiD = new ac(this, CmdConfigCustom.CMD_TTS_OPTION_PB);
    private final a.InterfaceC0031a eiE = new ad(this);
    private final AbsListView.OnScrollListener mOnScrollListener = new af(this);
    private final com.baidu.adp.base.f eiF = new ag(this);
    private final c eiG = new ah(this);
    private final aa.b aSb = new ai(this);
    private final BdListView.e eiI = new aj(this);
    private int eiJ = 0;
    private final TbRichTextView.e aHX = new ak(this);
    boolean eiK = false;
    com.baidu.tieba.tbadkCore.data.p eiL = null;
    private final c.b eiM = new al(this);
    private final View.OnLongClickListener anA = new am(this);
    private final NoNetworkView.a bEW = new an(this);
    public View.OnTouchListener aIu = new ao(this);
    private a.InterfaceC0057a aLl = new aq(this);
    private final c.a eiN = new ar(this);
    private String eiO = null;
    private final db.a eiP = new as(this);
    private int eiQ = -1;
    private int eiR = -1;
    private CustomMessageListener eiU = new at(this, CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST);
    private final CustomMessageListener bGB = new au(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> ejn;
        public ConcurrentHashMap<String, ImageUrlData> ejo;
        public boolean ejq;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean ejp = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes.dex */
    public interface c {
    }

    public void im(boolean z) {
        this.ehK = z;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.pb.c aKK() {
        return this.eih;
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        if (jVar.aKw() != null) {
            String id = jVar.aKw().getId();
            ArrayList<com.baidu.tieba.tbadkCore.data.p> aKb = this.ehh.getPbData().aKb();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aKb.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.p pVar = aKb.get(i2);
                if (pVar.getId() == null || !pVar.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.data.p> aKA = jVar.aKA();
                    pVar.rU(jVar.getTotalCount());
                    if (pVar.bhN() != null) {
                        pVar.bhN().clear();
                        pVar.bhN().addAll(aKA);
                    }
                }
            }
            this.ehV.j(this.ehh.getPbData());
        }
    }

    public void aKL() {
        com.baidu.tieba.pb.data.f pbData;
        com.baidu.tbadk.core.data.bh aJZ;
        if (!this.eis) {
            if (!com.baidu.adp.lib.util.k.gB()) {
                showToast(r.l.no_network_guide);
            } else if (this.eiv) {
                this.eis = true;
                if (this.ehh != null && (pbData = this.ehh.getPbData()) != null && (aJZ = pbData.aJZ()) != null) {
                    int isLike = aJZ.rn() == null ? 0 : aJZ.rn().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10796").ab("tid", aJZ.getId()));
                    }
                    if (this.eit != null) {
                        this.eit.a(aJZ.rM(), aJZ.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        String string;
        if ((sparseArray.get(r.h.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(r.h.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(r.h.tag_check_mute_from) instanceof Integer)) {
            String str = (String) sparseArray.get(r.h.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(r.h.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(r.h.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
                cVar.cd(r.l.operation);
                int i = -1;
                if (sparseArray.get(r.h.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(r.h.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(r.l.delete);
                    if (z) {
                        string = getResources().getString(r.l.un_mute);
                    } else {
                        string = getResources().getString(r.l.mute);
                    }
                    strArr[1] = string;
                    cVar.a(strArr, new av(this, sparseArray, z, str2, str));
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(r.l.un_mute) : getResources().getString(r.l.mute);
                    cVar.a(strArr2, new aw(this, sparseArray, z, str2, str));
                }
                cVar.d(getPageContext()).sY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ij(int i) {
        com.baidu.tbadk.core.data.bh aJZ;
        String sb;
        String w;
        if (this.ehh != null && this.ehh.getPbData() != null && (aJZ = this.ehh.getPbData().aJZ()) != null) {
            if (i == 1) {
                PraiseData rn = aJZ.rn();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rn == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aJZ.a(praiseData);
                    } else {
                        aJZ.rn().getUser().add(0, metaData);
                        aJZ.rn().setNum(aJZ.rn().getNum() + 1);
                        aJZ.rn().setIsLike(i);
                    }
                }
                if (aJZ.rn() != null) {
                    if (aJZ.rn().getNum() < 1) {
                        w = getResources().getString(r.l.frs_item_praise_text);
                    } else {
                        w = com.baidu.tbadk.core.util.at.w(aJZ.rn().getNum());
                    }
                    this.ehV.O(w, true);
                }
            } else if (aJZ.rn() != null) {
                aJZ.rn().setIsLike(i);
                aJZ.rn().setNum(aJZ.rn().getNum() - 1);
                ArrayList<MetaData> user = aJZ.rn().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aJZ.rn().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aJZ.rn().getNum() < 1) {
                    sb = getResources().getString(r.l.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(aJZ.rn().getNum())).toString();
                }
                this.ehV.O(sb, false);
            }
            if (this.ehh.aLY()) {
                this.ehV.aNE().notifyDataSetChanged();
            } else {
                this.ehV.k(this.ehh.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().akj && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        if (this.ehh != null && this.ehh.getPbData() != null && this.ehV != null) {
            this.ehV.d(this.ehh.getPbData(), this.ehh.aLY(), this.ehh.aMo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bGe == null) {
                this.bGe = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bGe.aq(updateAttentionMessage.getData().toUid, this.ehh.getPbData().getForumId());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.ehh.o(bundle);
        if (this.bFE != null) {
            this.bFE.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.eih.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eik = getPageContext();
        Intent intent = getIntent();
        if (intent != null) {
            this.bxH = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.ehP = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.ehP)) {
                this.ehB = true;
            }
            this.eiQ = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.eiR = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.eiS = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            this.eic = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
            if (aLh()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.at.isEmpty(this.source) ? "" : this.source;
        } else {
            this.bxH = System.currentTimeMillis();
        }
        this.ehG = System.currentTimeMillis();
        this.aAP = this.ehG - this.bxH;
        super.onCreate(bundle);
        this.ehD = 0;
        q(bundle);
        if (this.ehh != null && this.ehh.getPbData() != null) {
            this.ehh.getPbData().oe(this.source);
        }
        initUI();
        if (intent != null && this.ehV != null) {
            this.ehV.enz = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
            if (intent.getBooleanExtra(PbActivityConfig.BIG_PIC_TYPE, false)) {
                if (this.ein == null) {
                    this.ein = new ax(this);
                }
                getSafeHandler().postDelayed(this.ein, 500L);
            }
        }
        this.bFE = new VoiceManager();
        this.bFE.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.pb.l lVar = new com.baidu.tbadk.editortools.pb.l();
        lVar.setForumName(this.ehh.aLX());
        if (this.ehh.getPbData() != null && this.ehh.getPbData().aJY() != null) {
            lVar.setForumId(this.ehh.getPbData().aJY().getId());
        }
        lVar.setFrom("pb");
        lVar.a(this.ehh);
        this.eih = (com.baidu.tbadk.editortools.pb.c) lVar.an(getActivity());
        this.eih.d(this);
        this.eih.a(this.avt);
        this.eih.a(this.avn);
        this.eih.a(this, bundle);
        this.eih.Cw().c(new com.baidu.tbadk.editortools.w(getActivity()));
        this.eih.Cw().bC(true);
        in(true);
        this.ehV.setEditorTools(this.eih.Cw());
        this.eih.a(this.ehh.aMf(), this.ehh.getThreadID(), this.ehh.aMx());
        registerListener(this.dnK);
        if (!this.ehh.aMc()) {
            this.eih.fC(this.ehh.getThreadID());
        }
        if (this.ehh.aMy()) {
            this.eih.fA(getPageContext().getString(r.l.pb_reply_hint_from_smart_frs));
        } else {
            this.eih.fA(getPageContext().getString(r.l.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.ehG;
        registerListener(this.bZD);
        registerListener(this.doi);
        registerListener(this.eip);
        registerListener(this.aIx);
        registerListener(this.bGx);
        registerListener(this.eio);
        this.eig = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.fpk);
        this.eig.bho();
        registerListener(this.eir);
        registerListener(this.aTR);
        if (this.ehh != null) {
            this.ehh.aMq();
        }
        if (TbadkCoreApplication.m9getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.eix);
        registerListener(this.eiD);
        registerListener(this.eiC);
        registerListener(this.eiU);
        this.ehM = new com.baidu.tieba.pb.pb.main.b(this.ehh, this);
        if (this.ehV != null && this.ehV.aOh() != null && this.ehV.aOi() != null) {
            this.ehA = new com.baidu.tieba.pb.pb.main.a.f(getActivity(), this.ehV.aOh(), this.ehV.aOi());
            this.ehA.a(this.eiw);
        }
        if (this.ehz && this.ehV != null && this.ehV.aOi() != null) {
            this.ehV.aOi().setVisibility(8);
        }
        this.eil = new com.baidu.tbadk.core.view.h();
        this.eil.adV = 1000L;
        registerListener(this.eiA);
        registerListener(this.eiy);
        registerListener(this.eiz);
        this.eim = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eim;
        userMuteAddAndDelCustomMessage.setTag(this.eim);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eim;
        userMuteCheckCustomMessage.setTag(this.eim);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        if (intent != null && intent.getBooleanExtra(PbActivityConfig.BIG_PIC_TYPE, false)) {
            if (this.ehS == null) {
                this.ehS = new ay(this);
            }
            getSafeHandler().postDelayed(this.ehS, 500L);
        }
    }

    public String aKM() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.f aKN() {
        return this.ehA;
    }

    private void in(boolean z) {
        this.eih.bF(z);
        this.eih.bG(z);
        this.eih.bH(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bFE != null) {
            this.bFE.onStart(getPageContext());
        }
    }

    public ez aKO() {
        return this.ehV;
    }

    public PbModel aKP() {
        return this.ehh;
    }

    public void og(String str) {
        if (this.ehh != null && !StringUtils.isNull(str) && this.ehV != null) {
            this.ehV.aNF();
            this.ehV.iY(true);
            this.ehh.og(str);
            this.ehN = true;
            this.ehV.axs();
            this.ehV.aOa();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.m9getInst().isReadMenuDialogOnTop()) {
            this.ehC = false;
        } else {
            this.ehC = true;
        }
        super.onPause();
        if (this.ehV.aNm() != null && this.ehV.aNm().aKH() != null) {
            this.ehV.aNm().aKH().onPause();
        }
        BdListView listView = getListView();
        this.ehD = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.ehD == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.bFE != null) {
            this.bFE.onPause(getPageContext());
        }
        if (this.ehV != null) {
            this.ehV.onPause();
        }
        if (!this.ehh.aMc()) {
            this.eih.fB(this.ehh.getThreadID());
        }
        if (this.ehh != null) {
            this.ehh.aMr();
        }
        MessageManager.getInstance().unRegisterListener(this.cNS);
        amk();
        MessageManager.getInstance().unRegisterListener(this.eiy);
        MessageManager.getInstance().unRegisterListener(this.eiz);
        MessageManager.getInstance().unRegisterListener(this.eiA);
        MessageManager.getInstance().unRegisterListener(this.bGB);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aKQ() {
        com.baidu.tieba.tbadkCore.data.p a2 = com.baidu.tieba.pb.data.g.a(this.ehh.getPbData(), this.ehh.aLY(), this.ehh.aMo());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.ehC = false;
        super.onResume();
        if (this.ehR) {
            this.ehR = false;
            aLn();
        }
        if (this.ehV.aNm() != null && this.ehV.aNm().aKH() != null) {
            this.ehV.aNm().aKH().onResume();
        }
        if (aKQ()) {
            this.ehJ = System.currentTimeMillis();
        } else {
            this.ehJ = -1L;
        }
        if (this.ehV != null && this.ehV.getView() != null) {
            if (!this.dJT) {
                aLf();
            } else {
                hideLoadingView(this.ehV.getView());
            }
            this.ehV.onResume();
        }
        if (this.ehD == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.ehV != null) {
            noNetworkView = this.ehV.aNn();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.gk()) {
            noNetworkView.aK(false);
        }
        if (this.bFE != null) {
            this.bFE.onResume(getPageContext());
        }
        registerListener(this.cNS);
        this.eif = false;
        aLm();
        registerListener(this.eiy);
        registerListener(this.eiz);
        registerListener(this.eiA);
        registerListener(this.bGB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.ehV.iM(z);
        if (this.eia != null) {
            this.eia.iy(z);
        }
        if (z && this.eif) {
            this.ehV.aNK();
            this.ehh.iu(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ehJ > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10804").ab("obj_duration", new StringBuilder(String.valueOf(System.currentTimeMillis() - this.ehJ)).toString()));
            this.ehJ = 0L;
        }
        if (this.eih != null && this.eih.Cw() != null && this.eih.Cw().getVisibility() != 0) {
            this.eih.Dg();
        }
        if (aKO().aNq() != null) {
            aKO().aNq().onStop();
        }
        if (this.ehV.enK != null && !this.ehV.enK.aOz()) {
            this.ehV.enK.axJ();
        }
        if (this.ehh != null && this.ehh.getPbData() != null && this.ehh.getPbData().aJY() != null && this.ehh.getPbData().aJZ() != null) {
            com.baidu.tbadk.distribute.a.Cg().b(getPageContext().getPageActivity(), "pb", this.ehh.getPbData().aJY().getId(), com.baidu.adp.lib.g.b.c(this.ehh.getPbData().aJZ().getId(), 0L));
        }
        if (this.bFE != null) {
            this.bFE.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.ehM != null) {
            this.ehM.destroy();
        }
        if (this.eib && this.ehh != null) {
            a(this.ehh.getPbData(), -2, 0, false, false);
        }
        if (!this.ehH && this.ehV != null) {
            this.ehH = true;
            this.ehV.aNZ();
            a(false, (com.baidu.tieba.tbadkCore.data.p) null);
        }
        if (this.ehh != null) {
            this.ehh.cancelLoadData();
            this.ehh.destory();
        }
        if (this.eih != null) {
            this.eih.onDestroy();
        }
        if (this.ehU != null) {
            this.ehU.cancelLoadData();
        }
        if (this.ehV != null) {
            this.ehV.onDestroy();
            if (this.ehV.enK != null) {
                this.ehV.enK.axJ();
            }
        }
        if (this.ehI != null) {
            this.ehI.onDestroy();
        }
        if (this.ehA != null) {
            this.ehA.VK();
        }
        super.onDestroy();
        if (this.bFE != null) {
            this.bFE.onDestory(getPageContext());
        }
        if (this.bGe != null) {
            this.bGe.destory();
        }
        this.ehV.axs();
        MessageManager.getInstance().unRegisterListener(this.eiy);
        MessageManager.getInstance().unRegisterListener(this.eiz);
        MessageManager.getInstance().unRegisterListener(this.eiA);
        MessageManager.getInstance().unRegisterListener(this.eim);
        this.eik = null;
        this.eil = null;
        com.baidu.tieba.recapp.c.a.bad().baf();
        if (this.ehS != null) {
            getSafeHandler().removeCallbacks(this.ehS);
        }
        if (this.ein != null) {
            getSafeHandler().removeCallbacks(this.ein);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.tieba.tbadkCore.data.p pVar) {
        cq aNE;
        ArrayList<com.baidu.tieba.tbadkCore.data.p> aLA;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xm() && this.ehV != null && (aNE = this.ehV.aNE()) != null && (aLA = aNE.aLA()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.baidu.tieba.tbadkCore.data.p> it = aLA.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.p next = it.next();
                String id = next.getId();
                i++;
                if (z) {
                    if (next == pVar) {
                        a.b bVar = new a.b();
                        bVar.bjU = id;
                        bVar.bnY = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.Tn == 1 && !TextUtils.isEmpty(id)) {
                    next.Tn = 2;
                    a.b bVar2 = new a.b();
                    bVar2.bjU = id;
                    bVar2.bnY = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.ehh == null || this.ehh.getPbData() == null || this.ehh.getPbData().aJY() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.ehh.getPbData().aJY().getFirst_class();
                    str2 = this.ehh.getPbData().aJY().getSecond_class();
                    str = this.ehh.getPbData().aJY().getId();
                    str4 = this.ehh.getThreadID();
                }
                com.baidu.tieba.recapp.r.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.xq());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ehV.onChangeSkinType(i);
        if (this.eih != null && this.eih.Cw() != null) {
            this.eih.Cw().onChangeSkinType(i);
        }
        if (this.ehV.aNn() != null) {
            this.ehV.aNn().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.ehV = new ez(this, this.bHz, this.egn);
        this.bJg = new com.baidu.tieba.f.c(getActivity());
        this.bJg.a(this.eiN);
        this.bJg.a(this.aLl);
        this.ehV.setOnScrollListener(this.mOnScrollListener);
        this.ehV.d(this.eiI);
        this.ehV.a(this.aSb);
        this.ehV.ii(com.baidu.tbadk.core.l.oC().oI());
        this.ehV.setOnImageClickListener(this.aHX);
        this.ehV.a(this.anA);
        this.ehV.h(this.bEW);
        this.ehV.a(this.eiG);
        this.ehV.iM(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aY(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(r.h.tag_clip_board);
            if (obj instanceof com.baidu.tieba.tbadkCore.data.p) {
                com.baidu.tieba.tbadkCore.data.p pVar = (com.baidu.tieba.tbadkCore.data.p) obj;
                if (com.baidu.tieba.tbadkCore.data.p.fpN == pVar.getType() || TextUtils.isEmpty(pVar.getBimg_url()) || !com.baidu.tbadk.core.l.oC().oI()) {
                    return false;
                }
                return ok(pVar.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.ehV != null) {
            if (z && (!this.dJT || this.eij)) {
                aLf();
            } else {
                hideLoadingView(this.ehV.getView());
            }
            this.eij = false;
        }
    }

    private void aKR() {
        if (this.ehE == null) {
            this.ehE = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.ehE.a(new String[]{getPageContext().getString(r.l.call_phone), getPageContext().getString(r.l.sms_phone), getPageContext().getString(r.l.search_in_baidu)}, new az(this)).ce(c.a.Vp).cf(17).d(getPageContext());
        }
    }

    private void q(Bundle bundle) {
        this.ehh = new PbModel(this);
        this.ehh.a(this.eiB);
        if (this.ehh.aMw() != null) {
            this.ehh.aMw().a(this.eiP);
        }
        if (this.ehh.aMv() != null) {
            this.ehh.aMv().a(this.eiq);
        }
        if (bundle != null) {
            this.ehh.initWithBundle(bundle);
        } else {
            this.ehh.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra("request_code", -1) == 18003) {
            this.ehh.ix(true);
        }
        eq.aNi().N(this.ehh.aLW(), this.ehh.getIsFromMark());
        if (StringUtils.isNull(this.ehh.getThreadID())) {
            finish();
        } else {
            this.ehh.EH();
        }
    }

    private void initData(Bundle bundle) {
        this.dGi = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dGi != null) {
            this.dGi.a(this.eiE);
        }
        this.ehU = new ForumManageModel(this);
        this.ehU.setLoadDataCallBack(this.eiF);
        this.ehV.a(new bb(this));
        this.eit.setUniqueId(getUniqueId());
        this.eit.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.ehV.avh();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(r.h.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.eim;
        userMuteCheckCustomMessage.setTag(this.eim);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.bZ(r.l.go_setting_float_window_permission);
        aVar.ca(r.l.step_to_setting_float_permission);
        aVar.a(r.l.go_and_setting, new bc(this));
        aVar.b(r.l.cancel, new bd(this));
        aVar.b(getPageContext()).sV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aKT() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.ehh != null && this.ehh.getPbData() != null) {
            com.baidu.tieba.pb.data.f pbData = this.ehh.getPbData();
            if (pbData.aJY() != null) {
                sb.append("forum_name=").append(oh(pbData.aJY().getName()));
                sb.append("&");
            }
            if (pbData.aJZ() != null) {
                com.baidu.tbadk.core.data.bh aJZ = pbData.aJZ();
                sb.append("thread_id=").append(aJZ.getId());
                sb.append("&");
                sb.append("thread_title=").append(oh(aJZ.getTitle()));
                if (aJZ.getAuthor() != null && aJZ.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aJZ.getAuthor().getPortrait());
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

    private String oh(String str) {
        return URLEncoder.encode(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3091=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        com.baidu.tieba.tbadkCore.data.p pVar;
        if (!checkUpIsLogin() || sparseArray == null || !(sparseArray.get(r.h.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.p) || (pVar = (com.baidu.tieba.tbadkCore.data.p) sparseArray.get(r.h.tag_clip_board)) == null || this.ehh == null || this.ehh.getPbData() == null || pVar.bhQ() <= 1) {
            return;
        }
        String threadID = this.ehh.getThreadID();
        String id = pVar.getId();
        int aKj = this.ehh.getPbData() != null ? this.ehh.getPbData().aKj() : 0;
        b ol = ol(id);
        if (ol != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, aKj, pVar.aPB(), this.ehh.getPbData().qm(), false, pVar.getAuthor() != null ? pVar.getAuthor().getIconInfo() : null).addBigImageData(ol.ejn, ol.ejo, ol.ejp, ol.index)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aKU() {
        if (this.ehh.getPbData() == null || this.ehh.getPbData().aJZ() == null) {
            return -1;
        }
        return this.ehh.getPbData().aJZ().rZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean io(boolean z) {
        if (this.ehh == null || this.ehh.getPbData() == null) {
            return false;
        }
        return ((this.ehh.getPbData().aKj() != 0) || this.ehh.getPbData().aJZ() == null || this.ehh.getPbData().aJZ().getAuthor() == null || TextUtils.equals(this.ehh.getPbData().aJZ().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean ip(boolean z) {
        if (z) {
            return true;
        }
        if (this.ehh == null || this.ehh.getPbData() == null) {
            return false;
        }
        return this.ehh.getPbData().aKj() != 0;
    }

    private boolean iq(boolean z) {
        return (z || this.ehh == null || this.ehh.getPbData() == null || this.ehh.getPbData().aKj() == 0) ? false : true;
    }

    public void aKV() {
        if (this.ehh != null && this.ehh.getPbData() != null && this.ehh.getPbData().aJZ() != null && this.ehh.getPbData().aJZ().getAuthor() != null) {
            com.baidu.tbadk.core.data.bh aJZ = this.ehh.getPbData().aJZ();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aJZ.getAuthor().getUserId());
            GodUserData godUserData = aJZ.getAuthor().getGodUserData();
            boolean z = equals && godUserData != null && godUserData.isCanSendCall();
            du duVar = new du();
            if (!this.ehh.getPbData().aKg() && TbadkCoreApplication.m9getInst().isTTSCanUse()) {
                duVar.elJ = true;
            }
            if (this.ehh.getPbData().aKj() == 1) {
                duVar.elM = true;
                duVar.elL = true;
                duVar.elR = aJZ.rs() == 1;
                duVar.elQ = aJZ.rt() == 1;
            } else {
                duVar.elM = false;
                duVar.elL = false;
            }
            duVar.elK = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteShareActivityConfig.class);
            duVar.elH = TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            duVar.elN = ip(equals);
            duVar.elO = aKW();
            duVar.elP = iq(equals);
            duVar.elI = this.ehh.aLY();
            duVar.efY = this.dGi != null ? this.dGi.nt() : false;
            duVar.elG = io(equals);
            duVar.elE = equals && this.ehV.aNP();
            duVar.elF = z;
            duVar.isHostOnly = this.ehh.getHostMode();
            if (aJZ.rN() == null) {
                duVar.elS = false;
            } else {
                duVar.elS = true;
            }
            this.ehV.enK.a(duVar);
        }
    }

    private boolean aKW() {
        if (this.ehh != null && this.ehh.aLY()) {
            return this.ehh.amN() == null || this.ehh.amN().qy() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.tbadkCore.data.p pVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (pVar = (com.baidu.tieba.tbadkCore.data.p) sparseArray.get(r.h.tag_clip_board)) != null) {
            d(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, boolean z2) {
        if (fVar != null && this.ehh != null) {
            eh ehVar = new eh(getUniqueId());
            ehVar.pbData = fVar;
            ehVar.threadId = this.ehh.getThreadID();
            ehVar.postId = this.ehh.getPostId();
            ehVar.emS = i;
            ehVar.emT = i2;
            ehVar.emR = this.ehh.getHostMode();
            ehVar.efY = this.ehh.nt();
            ehVar.isSquence = this.ehh.aLY();
            ehVar.loadType = this.ehh.aMt();
            ehVar.emU = z;
            ehVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, ehVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, boolean z2) {
        if (fVar != null && this.ehh != null) {
            eh ehVar = new eh(getUniqueId());
            ehVar.pbData = fVar;
            ehVar.threadId = this.ehh.getThreadID();
            ehVar.postId = this.ehh.getPostId();
            ehVar.emS = i;
            ehVar.emR = this.ehh.getHostMode();
            ehVar.efY = this.ehh.nt();
            ehVar.isSquence = this.ehh.aLY();
            ehVar.loadType = this.ehh.aMt();
            ehVar.emU = z;
            ehVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, ehVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        axa();
    }

    public void a(boolean z, MarkData markData) {
        this.ehV.aNL();
        this.ehh.iw(z);
        if (this.dGi != null) {
            this.dGi.ad(z);
            if (markData != null) {
                this.dGi.a(markData);
            }
        }
        if (this.ehh.nt()) {
            aLc();
        } else {
            this.ehV.j(this.ehh.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean op(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi(String str) {
        if (!StringUtils.isNull(str) && this.ehh != null) {
            String threadID = this.ehh.getThreadID();
            String id = this.ehh.getPbData().aJY().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(r.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.ehh.aMc()) {
                    antiData.setBlock_forum_name(this.ehh.getPbData().aJY().getName());
                    antiData.setBlock_forum_id(this.ehh.getPbData().aJY().getId());
                    antiData.setUser_name(this.ehh.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.ehh.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.sa(i)) {
            AntiHelper.T(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            fI(str);
        } else {
            this.ehV.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.ehV.a(0, bVar.tT, bVar.frT, z);
            if (bVar.tT) {
                if (bVar.frR == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.p> aKb = this.ehh.getPbData().aKb();
                    int size = aKb.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aKb.get(i).getId())) {
                            i++;
                        } else {
                            aKb.remove(i);
                            break;
                        }
                    }
                    this.ehV.j(this.ehh.getPbData());
                } else if (bVar.frR == 0) {
                    aKX();
                } else if (bVar.frR == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.p> aKb2 = this.ehh.getPbData().aKb();
                    int size2 = aKb2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aKb2.get(i2).bhN().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aKb2.get(i2).bhN().get(i3).getId())) {
                                i3++;
                            } else {
                                aKb2.get(i2).bhN().remove(i3);
                                aKb2.get(i2).bhP();
                                z2 = true;
                                break;
                            }
                        }
                        aKb2.get(i2).qE(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.ehV.j(this.ehh.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.f fVar) {
        if (fVar != null) {
            this.ehV.a(this.ehU.getLoadDataMode(), fVar.tT, fVar.frT, false);
            if (fVar.tT) {
                this.ehX = true;
                if (i == 2 || i == 3) {
                    this.ehY = true;
                    this.ehZ = false;
                } else if (i == 4 || i == 5) {
                    this.ehY = false;
                    this.ehZ = true;
                }
                if (i == 2) {
                    this.ehh.getPbData().aJZ().bW(1);
                    this.ehh.setIsGood(1);
                } else if (i == 3) {
                    this.ehh.getPbData().aJZ().bW(0);
                    this.ehh.setIsGood(0);
                } else if (i == 4) {
                    this.ehh.getPbData().aJZ().bV(1);
                    this.ehh.gV(1);
                } else if (i == 5) {
                    this.ehh.getPbData().aJZ().bV(0);
                    this.ehh.gV(0);
                }
                this.ehV.a(this.ehh.getPbData(), this.ehh.aLY(), true);
                com.baidu.tieba.c.a.a(getPageContext(), 2, i);
            }
        }
    }

    private void aKX() {
        if (this.ehh.aLZ() || this.ehh.aMa()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.ehh.getThreadID());
            setResult(-1, intent);
        }
        if (aLd()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKY() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aKh;
        if (this.ehV != null) {
            this.ehV.axs();
        }
        if (this.ehh != null && this.ehh.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.ehh.getPbData().aJZ().getId();
            historyMessage.forumName = this.ehh.getPbData().aJY().getName();
            historyMessage.threadName = this.ehh.getPbData().aJZ().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.data.p> aKb = this.ehh.getPbData().aKb();
            int aNN = this.ehV != null ? this.ehV.aNN() : 0;
            if (aKb != null && aNN >= 0 && aNN < aKb.size()) {
                historyMessage.postID = aKb.get(aNN).getId();
            }
            historyMessage.isHostOnly = this.ehh.getHostMode();
            historyMessage.isSquence = this.ehh.aLY();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.eih != null) {
            this.eih.onDestroy();
        }
        if (this.ehh != null && (this.ehh.aLZ() || this.ehh.aMa())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.ehh.getThreadID());
            if (this.ehX) {
                if (this.ehZ) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.ehh.axj());
                }
                if (this.ehY) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.ehh.getIsGood());
                }
            }
            if (this.ehh.getPbData() != null && System.currentTimeMillis() - this.ehG >= 40000 && (aKh = this.ehh.getPbData().aKh()) != null && !com.baidu.tbadk.core.util.w.s(aKh.getDataList())) {
                intent.putExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA, aKh);
            }
            setResult(-1, intent);
        }
        if (aLd()) {
            if (this.ehh != null && this.ehV != null && this.ehV.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.ehh.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.m9getInst().getDefaultBubble());
                    }
                    if (!pbData.aKg() && !this.ehN) {
                        eq.aNi().a(this.ehh.getPbData(), this.ehV.getListView().onSaveInstanceState(), this.ehh.aLY(), this.ehh.getHostMode());
                    }
                }
            } else {
                eq.aNi().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.ehV == null) {
            return super.onKeyDown(i, keyEvent);
        }
        switch (i) {
            case 4:
                if (this.ehV.aLR()) {
                    this.ehV.aLT();
                    return true;
                } else if (this.ehV.aNV()) {
                    return true;
                } else {
                    return super.onKeyDown(i, keyEvent);
                }
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oq(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(r.l.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.eih.onActivityResult(i, i2, intent);
        if (aKO().aNq() != null) {
            aKO().aNq().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aLb();
                    return;
                case 13008:
                    eq.aNi().reset();
                    this.mHandler.postDelayed(new bf(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.ehh != null) {
                        a(aLa(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                    if (aKU() == 1) {
                        aKZ();
                        return;
                    }
                    return;
                case 24008:
                    this.ehV.il(false);
                    if (this.ehh.getPbData() != null && this.ehh.getPbData().aJZ() != null && this.ehh.getPbData().aJZ().rQ() != null) {
                        this.ehh.getPbData().aJZ().rQ().setStatus(2);
                        break;
                    }
                    break;
                case 25001:
                    break;
                default:
                    return;
            }
            if (this.ehM != null) {
                this.ehM.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aKO() != null && aKK() != null && aKO().aNs() && com.baidu.tbadk.editortools.pb.a.CT().getStatus() == 1) {
                    com.baidu.tbadk.editortools.pb.a.CT().setStatus(0);
                    if (this.ehV != null) {
                        this.ehV.aNr();
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
    public void aKZ() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.ehh.getPbData() != null && this.ehh.getPbData().aJZ() != null && this.ehh.getPbData().aJZ().rH() != null && this.ehh.getPbData().aJZ().rH().size() > 0 && this.ehh.getPbData().aJZ().rH().get(0) != null) {
            this.mAwardActId = this.ehh.getPbData().aJZ().rH().get(0).oX();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.ehh.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void t(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra("key_action", 0)) {
                case 1:
                    adT();
                    return;
                case 2:
                    this.ehV.aNC();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aLa() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bm = this.ehh.getPbData().bm(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.data.p aNt = this.ehV.aNt();
        String str = "";
        if (aNt != null) {
            str = aNt.getId();
            String bv = aNt.bv(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(bv)) {
                bm[1] = bv;
            }
        }
        String rM = this.ehh.getPbData().aJZ().rM();
        if (rM != null && rM.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bm[1]);
        shareFromPBMsgData.setImageUrl(bm[0]);
        shareFromPBMsgData.setForumName(this.ehh.getPbData().aJY().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.ehh.getPbData().aJZ().getId());
        shareFromPBMsgData.setTitle(this.ehh.getPbData().aJZ().getTitle());
        return shareFromPBMsgData;
    }

    private void u(Intent intent) {
        a(aLa(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.ehh != null && this.ehh.getPbData() != null && this.ehh.getPbData().aJZ() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gs gsVar = new gs(getPageContext().getPageActivity());
            gsVar.setData(shareFromPBMsgData);
            aVar.cc(1);
            aVar.x(gsVar);
            aVar.a(r.l.share, new bg(this, gsVar, j, str, str2, shareFromPBMsgData));
            aVar.b(r.l.alert_no_button, new bh(this, gsVar));
            aVar.av(true);
            aVar.b(getPageContext()).sV();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                gsVar.F(shareFromPBMsgData.getImageUrl(), this.ehh.getPbData().aKk() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.ehh != null && this.ehh.getPbData() != null && this.ehh.getPbData().aJZ() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gs gsVar = new gs(getPageContext().getPageActivity());
            gsVar.setData(shareFromPBMsgData);
            aVar.cc(1);
            aVar.x(gsVar);
            aVar.a(r.l.share, new bi(this, gsVar, i, str, j, shareFromPBMsgData));
            aVar.b(r.l.alert_no_button, new bj(this, gsVar));
            aVar.av(true);
            aVar.b(getPageContext()).sV();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                gsVar.F(shareFromPBMsgData.getImageUrl(), this.ehh.getPbData().aKk() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLb() {
        MarkData oB;
        if (this.dGi != null && (oB = this.ehh.oB(this.ehV.aNO())) != null) {
            if (!oB.isApp() || (oB = this.ehh.oB(this.ehV.aNO() + 1)) != null) {
                this.ehV.aNJ();
                this.dGi.a(oB);
                if (!this.dGi.nt()) {
                    this.dGi.nv();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.dGi.nu();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLc() {
        com.baidu.tieba.pb.data.f pbData = this.ehh.getPbData();
        this.ehh.iw(true);
        pbData.od(this.dGi.ns());
        this.ehV.j(pbData);
    }

    private boolean aLd() {
        if (this.ehh == null) {
            return true;
        }
        if (this.ehh.nt()) {
            MarkData aMk = this.ehh.aMk();
            if (aMk == null || !this.ehh.getIsFromMark()) {
                return true;
            }
            MarkData oB = this.ehh.oB(this.ehV.aNO());
            if (oB == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aMk);
                setResult(-1, intent);
                return true;
            } else if (oB.getPostId() == null || oB.getPostId().equals(aMk.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aMk);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cE(String.format(getPageContext().getString(r.l.alert_update_mark), Integer.valueOf(oB.getFloor())));
                aVar.a(r.l.alert_yes_btn, new bk(this, oB, aMk, aVar));
                aVar.b(r.l.alert_no_button, new bm(this, aMk, aVar));
                aVar.a(new bn(this, aMk, aVar));
                aVar.b(getPageContext());
                aVar.sV();
                return false;
            }
        } else if (this.ehh.getPbData() == null || this.ehh.getPbData().aKb() == null || this.ehh.getPbData().aKb().size() <= 0 || !this.ehh.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.ehV == null) {
            return null;
        }
        return this.ehV.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int HS() {
        if (this.ehV == null) {
            return 0;
        }
        return this.ehV.aNT();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> HT() {
        if (this.aHC == null) {
            this.aHC = new com.baidu.adp.lib.e.b<>(new bo(this), 8, 0);
        }
        return this.aHC;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> HU() {
        if (this.aHD == null) {
            this.aHD = TbRichTextView.j(getPageContext().getPageActivity(), 8);
        }
        return this.aHD;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> HV() {
        if (this.aHH == null) {
            this.aHH = new com.baidu.adp.lib.e.b<>(new bp(this), 20, 0);
        }
        return this.aHH;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> HW() {
        if (this.aHF == null) {
            this.aHF = new com.baidu.adp.lib.e.b<>(new bq(this), 8, 0);
        }
        return this.aHF;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> HY() {
        if (this.aHE == null) {
            this.aHE = com.baidu.tieba.graffiti.d.m(getPageContext().getPageActivity(), 6);
        }
        return this.aHE;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wA() {
        if (this.agy == null) {
            this.agy = UserIconBox.h(getPageContext().getPageActivity(), 8);
        }
        return this.agy;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void A(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.ehL = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void B(Context context, String str) {
        if (gt.ov(str) && this.ehh != null && this.ehh.getThreadID() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11664").s("obj_param1", 1).ab("post_id", this.ehh.getThreadID()));
        }
        gt.aOs().h(getPageContext(), str);
        this.ehL = true;
    }

    private com.baidu.tbadk.core.dialog.a aLe() {
        if (this.ehF == null) {
            this.ehF = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.ehF.cD(getPageContext().getString(r.l.download_baidu_video_dialog));
            this.ehF.a(getPageContext().getString(r.l.install), new br(this));
            this.ehF.b(getPageContext().getString(r.l.cancel), new bs(this));
            this.ehF.au(true);
            this.ehF.b(getPageContext());
            this.ehF.av(false);
        }
        this.ehF.sV();
        return this.ehF;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void C(Context context, String str) {
        gt.aOs().h(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.ehL = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void E(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra(VrPlayerActivityConfig.TITLE, "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            aLe();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.ehL = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void D(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        TbRichTextData tbRichTextData;
        int a2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.ehh.getPbData();
            TbRichText at = at(str, i);
            if (at != null && (tbRichTextData = at.Hq().get(this.eiJ)) != null) {
                bVar.ejn = new ArrayList<>();
                bVar.ejo = new ConcurrentHashMap<>();
                if (!tbRichTextData.Hv().HH()) {
                    bVar.ejq = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    bVar.ejn.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.postId = at.getPostId();
                    imageUrlData.mIsReserver = this.ehh.aMj();
                    imageUrlData.mIsSeeHost = this.ehh.getHostMode();
                    bVar.ejo.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aJY() != null) {
                            bVar.forumName = pbData.aJY().getName();
                            bVar.forumId = pbData.aJY().getId();
                        }
                        if (pbData.aJZ() != null) {
                            bVar.threadId = pbData.aJZ().getId();
                        }
                        bVar.ejp = pbData.aKk() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.ejq = true;
                int size = pbData.aKb().size();
                this.eiK = false;
                bVar.index = -1;
                int i2 = 0;
                int i3 = i;
                while (i2 < size) {
                    com.baidu.tieba.tbadkCore.data.p pVar = pbData.aKb().get(i2);
                    TbRichText awW = pVar.awW();
                    if (!ey.g(pVar)) {
                        a2 = a(awW, at, i3, i, bVar.ejn, bVar.ejo);
                    } else {
                        a2 = a(pVar, i3, bVar.ejn, bVar.ejo);
                    }
                    i2++;
                    i3 = a2;
                }
                if (bVar.ejn.size() > 0) {
                    bVar.lastId = bVar.ejn.get(bVar.ejn.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aJY() != null) {
                        bVar.forumName = pbData.aJY().getName();
                        bVar.forumId = pbData.aJY().getId();
                    }
                    if (pbData.aJZ() != null) {
                        bVar.threadId = pbData.aJZ().getId();
                    }
                    bVar.ejp = pbData.aKk() == 1;
                }
                bVar.index = i3;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Hv() == null) {
            return null;
        }
        return tbRichTextData.Hv().HL();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Hv() == null) {
            return 0L;
        }
        return tbRichTextData.Hv().getOriginalSize();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo Hv;
        if (tbRichText == tbRichText2) {
            this.eiK = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.Hq().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Hq().get(i6) == null || tbRichText.Hq().get(i6).getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int width = tbRichText.Hq().get(i6).Hv().getWidth();
                    int height = tbRichText.Hq().get(i6).Hv().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Hq().get(i6).Hv().HH()) {
                        if (tbRichText == tbRichText2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Hq().get(i6);
                        String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                        if (!TextUtils.isEmpty(c2)) {
                            arrayList.add(c2);
                            if (tbRichTextData != null && (Hv = tbRichTextData.Hv()) != null) {
                                String HJ = Hv.HJ();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = HJ;
                                imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.ehh.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.ehh.aMj();
                                imageUrlData.mIsSeeHost = this.ehh.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.eiK) {
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

    private int a(com.baidu.tieba.tbadkCore.data.p pVar, int i, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        com.baidu.tieba.tbadkCore.data.h bhY;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bhs;
        if (pVar != null && arrayList != null && concurrentHashMap != null && (bhs = (bhY = pVar.bhY()).bhs()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bhs.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bhs.get(i3);
                if (jVar != null) {
                    String bhz = jVar.bhz();
                    if (!com.baidu.tbadk.core.util.at.isEmpty(bhz)) {
                        arrayList.add(bhz);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bhz;
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        imageUrlData.originalUrl = jVar.bhx();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(pVar.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.ehh.getThreadID(), -1L);
                        imageUrlData.mIsReserver = this.ehh.aMj();
                        imageUrlData.mIsSeeHost = this.ehh.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bhY.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bhz, imageUrlData);
                        }
                        if (!this.eiK) {
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
    public void d(com.baidu.tieba.tbadkCore.data.p pVar) {
        if (pVar != null) {
            boolean z = false;
            if (pVar.getId() != null && pVar.getId().equals(this.ehh.rF())) {
                z = true;
            }
            MarkData e = this.ehh.e(pVar);
            if (e != null) {
                this.ehV.aNJ();
                if (this.dGi != null) {
                    this.dGi.a(e);
                    if (!z) {
                        this.dGi.nv();
                    } else {
                        this.dGi.nu();
                    }
                }
            }
        }
    }

    private TbRichText at(String str, int i) {
        if (this.ehh == null || this.ehh.getPbData() == null || str == null || i < 0) {
            return null;
        }
        return a(this.ehh.getPbData().aKb(), str, i);
    }

    private long oj(String str) {
        ArrayList<com.baidu.tieba.tbadkCore.data.p> aKb;
        com.baidu.tieba.pb.data.f pbData = this.ehh.getPbData();
        if (pbData != null && (aKb = pbData.aKb()) != null && !aKb.isEmpty()) {
            Iterator<com.baidu.tieba.tbadkCore.data.p> it = aKb.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.p next = it.next();
                com.baidu.tieba.tbadkCore.data.h bhY = next.bhY();
                if (bhY != null && bhY.fpt) {
                    Iterator<TbRichTextData> it2 = next.awW().Hq().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.HD().getLink().equals(str)) {
                            return bhY.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<com.baidu.tieba.tbadkCore.data.p> arrayList, String str, int i) {
        ArrayList<TbRichTextData> Hq;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText awW = arrayList.get(i2).awW();
            if (awW != null && (Hq = awW.Hq()) != null) {
                int size = Hq.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Hq.get(i4) != null && Hq.get(i4).getType() == 8) {
                        i3++;
                        if (Hq.get(i4).Hv().HJ().equals(str)) {
                            int width = Hq.get(i4).Hv().getWidth();
                            int height = Hq.get(i4).Hv().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.eiJ = i4;
                            return awW;
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
    public void d(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.ehf = str;
            if (this.ehE == null) {
                aKR();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.ehE.ch(1).setVisibility(8);
            } else {
                this.ehE.ch(1).setVisibility(0);
            }
            this.ehE.sY();
            this.ehL = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bFE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axa() {
        hideNetRefreshView(this.ehV.getView());
        aLf();
        if (this.ehh.EH()) {
            this.ehV.aNJ();
        }
    }

    private void aLf() {
        showLoadingView(this.ehV.getView(), false, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds400));
        View Ei = getLoadingView().Ei();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Ei.getLayoutParams();
        layoutParams.addRule(3, this.ehV.aOh().getId());
        Ei.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XU() {
        if (this.bFE != null) {
            this.bFE.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void or(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adT() {
        if (this.ehh.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.ehh.getPbData();
            String name = pbData.aJY().getName();
            String title = pbData.aJZ().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.ehh.getThreadID() + "?share=9105&fr=share&see_lz=" + (this.ehh.getHostMode() ? 1 : 0);
            String[] bm = pbData.bm(getPageContext().getPageActivity());
            String str2 = bm[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = bm[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (aKU() == 1) {
                if (pbData != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10399").ab("fid", pbData.getForumId()).ab("tid", pbData.getThreadId()).ab(SapiAccountManager.SESSION_UID, currentAccount));
                }
            } else if (aKU() == 2 && pbData != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10406").ab("fid", pbData.getForumId()).ab("tid", pbData.getThreadId()).ab(SapiAccountManager.SESSION_UID, currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(r.l.share_content_tpl), title, name, str3);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.linkUrl = str;
            fVar.amu = true;
            fVar.extData = this.ehh.getThreadID();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(r.l.forum_friend, r.g.icon_unite_share_baf, new bt(this));
            shareDialogConfig.setCopyLinkListener(new bu(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> HX() {
        if (this.aHG == null) {
            this.aHG = new com.baidu.adp.lib.e.b<>(new bw(this), 15, 0);
        }
        return this.aHG;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.ehV.aND() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10517").s("obj_locate", 2).ab("fid", this.ehh.getPbData().getForumId()));
            } else {
                com.baidu.tbadk.core.data.bh aJZ = this.ehh.getPbData().aJZ();
                if (view != null) {
                    boolean z = aJZ.rn() == null || aJZ.rn().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.eiu > 1000) {
                            this.eiv = true;
                            ba(view);
                        } else {
                            this.eiv = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            e(view, this.eiv);
                        } else {
                            d(view, this.eiv);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        d(view, this.eiv);
                    } else if (motionEvent.getAction() == 3) {
                        d(view, this.eiv);
                    }
                }
            }
        }
        return false;
    }

    private void d(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), r.a.praise_animation_scale2));
            new Handler().postDelayed(new bx(this), 200L);
        }
    }

    private void e(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), r.a.praise_animation_scale3));
            new Handler().postDelayed(new by(this), 600L);
        }
    }

    private void ba(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), r.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void XV() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(r.l.login_to_use), true, 11017)));
        } else if (aVar.sX() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.sX();
            int intValue = ((Integer) sparseArray.get(ez.epr)).intValue();
            if (intValue == ez.eps) {
                if (!this.ehU.biz()) {
                    this.ehV.aNG();
                    int intValue2 = ((Integer) sparseArray.get(r.h.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(r.h.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(r.h.tag_del_post_type)).intValue();
                    this.ehU.a(this.ehh.getPbData().aJY().getId(), this.ehh.getPbData().aJY().getName(), this.ehh.getPbData().aJZ().getId(), (String) sparseArray.get(r.h.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == ez.ept || intValue == ez.epv) {
                if (this.ehh.aMw() != null) {
                    this.ehh.aMw().ou(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ez.ept) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == ez.epu) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.eiO).oS()));
            }
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (sparseArray.get(r.h.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(r.h.tag_user_mute_mute_username);
        }
        if (sparseArray.get(r.h.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(r.h.tag_user_mute_thread_id);
        }
        if (sparseArray.get(r.h.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(r.h.tag_user_mute_post_id);
        }
        if (sparseArray.get(r.h.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(r.h.tag_user_mute_msg);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.eim);
        userMuteAddAndDelCustomMessage.setTag(this.eim);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean ok(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bf.ak(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.tQ().getString("bubble_link", ""))) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(r.l.editor_privilege), String.valueOf(string) + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void ir(boolean z) {
        this.eif = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aLg() {
        ArrayList<com.baidu.tieba.tbadkCore.data.p> aKb;
        int r;
        if (this.ehh == null || this.ehh.getPbData() == null || this.ehh.getPbData().aKb() == null || (r = com.baidu.tbadk.core.util.w.r((aKb = this.ehh.getPbData().aKb()))) == 0) {
            return "";
        }
        int aNN = this.ehV.aNN();
        com.baidu.tieba.tbadkCore.data.p pVar = (com.baidu.tieba.tbadkCore.data.p) com.baidu.tbadk.core.util.w.c(aKb, aNN);
        if (pVar == null || pVar.getAuthor() == null) {
            return "";
        }
        if (this.ehh.oo(pVar.getAuthor().getUserId())) {
            return pVar.getId();
        }
        for (int i = aNN - 1; i != 0; i--) {
            com.baidu.tieba.tbadkCore.data.p pVar2 = (com.baidu.tieba.tbadkCore.data.p) com.baidu.tbadk.core.util.w.c(aKb, i);
            if (pVar2 == null || pVar2.getAuthor() == null || pVar2.getAuthor().getUserId() == null) {
                break;
            } else if (this.ehh.oo(pVar2.getAuthor().getUserId())) {
                return pVar2.getId();
            }
        }
        for (int i2 = aNN + 1; i2 < r; i2++) {
            com.baidu.tieba.tbadkCore.data.p pVar3 = (com.baidu.tieba.tbadkCore.data.p) com.baidu.tbadk.core.util.w.c(aKb, i2);
            if (pVar3 == null || pVar3.getAuthor() == null || pVar3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.ehh.oo(pVar3.getAuthor().getUserId())) {
                return pVar3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void F(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.ba.vt().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.b.a(oj(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.ehh.getPbData().aJY().getId(), this.ehh.getPbData().aJY().getName(), this.ehh.getPbData().aJZ().getTid());
            }
            this.ehL = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, String str2, String str3, String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cE(getResources().getString(r.l.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cE(getResources().getString(r.l.make_sure_hide));
        }
        aVar.a(getResources().getString(r.l.alert_yes_button), new bz(this, j, str, str2, str3, str4));
        aVar.b(getResources().getString(r.l.alert_no_button), new ca(this, j, str, str2, str3, str4));
        aVar.av(false);
        aVar.b(getPageContext());
        aVar.sV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b ol(String str) {
        String str2;
        if (this.ehh.getPbData() == null || this.ehh.getPbData().aKb() == null || this.ehh.getPbData().aKb().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i < this.ehh.getPbData().aKb().size()) {
                if (str.equals(this.ehh.getPbData().aKb().get(i).getId())) {
                    break;
                }
                i++;
            } else {
                i = 0;
                break;
            }
        }
        com.baidu.tieba.tbadkCore.data.p pVar = this.ehh.getPbData().aKb().get(i);
        if (pVar.awW() == null || pVar.awW().Hq() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = pVar.awW().Hq().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.Hv() != null) {
                    str2 = next.Hv().HJ();
                }
            }
        }
        a(str2, 0, bVar);
        com.baidu.tieba.pb.data.g.a(pVar, bVar);
        return bVar;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.ehB) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.ehB = false;
        } else if (aLh()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.ehB) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.ehB = false;
        } else if (aLh()) {
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
        if (pageStayDurationItem != null && this.ehh != null) {
            if (this.ehh.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.ehh.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.ehh.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aLh() {
        return (!this.ehz && this.eiQ == -1 && this.eiR == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null) {
            this.eiT = oVar;
            this.ehz = true;
            this.ehV.aNu();
            this.ehV.ou(this.eiS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLi() {
        if (this.eiT != null) {
            if (this.eiQ == -1) {
                showToast(r.l.pb_manga_not_prev_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eiT.getCartoonId(), this.eiQ, 0)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLj() {
        if (this.eiT != null) {
            if (this.eiR == -1) {
                showToast(r.l.pb_manga_not_next_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eiT.getCartoonId(), this.eiR, 0)));
            finish();
        }
    }

    public int aLk() {
        return this.eiQ;
    }

    public int aLl() {
        return this.eiR;
    }

    private void amk() {
        if (this.ehh != null && this.ehh.getPbData() != null && this.ehh.getPbData().aJZ() != null && this.ehh.getPbData().aJZ().si()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aLm() {
        if (this.ehh != null && this.ehh.getPbData() != null && this.ehh.getPbData().aJZ() != null && this.ehh.getPbData().aJZ().si()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aLn() {
        if (this.ehC) {
            this.ehR = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.ehh.getPbData() != null && this.ehh.getPbData().aJZ() != null && this.ehh.getPbData().aJZ().rg() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.ehh.getPbData().aJZ().rg().getThreadId(), this.ehh.getPbData().aJZ().rg().getTaskId(), this.ehh.getPbData().aJZ().rg().getForumId(), this.ehh.getPbData().aJZ().rg().getForumName(), this.ehh.getPbData().aJZ().rs(), this.ehh.getPbData().aJZ().rt())));
            this.ehB = true;
            finish();
        }
    }

    public boolean aLo() {
        return this.ehC;
    }

    public String aLp() {
        return this.ehP;
    }

    public PbInterviewStatusView.a aLq() {
        return this.ehT;
    }

    public void is(boolean z) {
        this.ehQ = z;
    }

    public boolean aLr() {
        if (this.ehh != null) {
            return this.ehh.aLZ();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLs() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cE(getResources().getString(r.l.mute_is_super_member_function));
        aVar.a(r.l.open_now, new cb(this));
        aVar.b(r.l.cancel, new cc(this));
        aVar.b(this.eik).sV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fI(String str) {
        if (str == null) {
            str = "";
        }
        if (this.eik != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eik.getPageActivity());
            aVar.cE(str);
            aVar.b(r.l.know, new cd(this));
            aVar.b(this.eik).sV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.ehV.avh();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eik.getPageActivity());
        if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
            aVar.cE(this.eik.getResources().getString(r.l.block_mute_message_alert, str2));
        } else {
            aVar.cE(str);
        }
        aVar.a(r.l.confirm, new ce(this, userMuteAddAndDelCustomMessage));
        aVar.b(r.l.cancel, new cg(this));
        aVar.b(this.eik).sV();
    }

    public void aLt() {
        if (this.ehh != null && this.ehh.getPbData() != null && this.ehh.getPbData().aJZ() != null && this.ehh.getPbData().aJZ().sz() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.ca(r.l.channel_open_push_message);
            aVar.a(r.l.need_channel_push, new ch(this));
            aVar.b(r.l.not_need_channel_push, new ci(this));
            aVar.b(getPageContext());
            aVar.sV();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.b
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.b[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.b.class);
            for (int i = 0; i < objArr.length; i++) {
                if (gt.ov(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_pb_wenxue)) != null) {
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

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            this.ehO = true;
        } else {
            this.ehO = false;
        }
        if (this.ehV != null) {
            this.ehV.onConfigurationChanged(configuration);
        }
        if (this.eia != null) {
            this.eia.dismiss();
        }
    }
}
