package com.baidu.tieba.pb.pb.main;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.view.t;
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
import com.baidu.tieba.d.c;
import com.baidu.tieba.pb.pb.main.a.f;
import com.baidu.tieba.pb.pb.main.cq;
import com.baidu.tieba.pb.pb.main.ct;
import com.baidu.tieba.pb.pb.main.dh;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.f.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.togetherhi.TogetherHiLivingView;
import com.baidu.tieba.u;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, com.baidu.tbadk.widget.richText.m {
    private com.baidu.adp.lib.f.b<ImageView> aGa;
    private com.baidu.adp.lib.f.b<TextView> aGb;
    private com.baidu.adp.lib.f.b<View> aGc;
    private com.baidu.adp.lib.f.b<View> aGd;
    private com.baidu.adp.lib.f.b<LinearLayout> aGe;
    private com.baidu.adp.lib.f.b<GifView> aGf;
    private com.baidu.adp.lib.f.b<View> aGg;
    private com.baidu.adp.lib.f.b<TbImageView> aeH;
    private VoiceManager bEE;
    private com.baidu.tieba.d.c bEe;
    private com.baidu.tbadk.e.a bEk;
    private com.baidu.tieba.pb.pb.main.a.f eaK;
    private com.baidu.tbadk.core.dialog.a eaP;
    private com.baidu.tieba.pb.pb.main.b eaV;
    private String eaq;
    private boolean ebG;
    private String ebR;
    private com.baidu.tbadk.core.data.m ebS;
    private Cdo ebe;
    private boolean ebi;
    private com.baidu.tieba.tbadkCore.data.f ebj;
    private com.baidu.tbadk.editortools.d.e ebk;
    private com.baidu.adp.base.h ebn;
    private com.baidu.tbadk.core.view.h ebo;
    private BdUniqueId ebp;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean eaJ = false;
    private boolean eaL = false;
    private boolean eaM = false;
    private boolean dCV = false;
    private int eaN = 0;
    private com.baidu.tbadk.core.dialog.c eaO = null;
    private long bvA = -1;
    private long azk = 0;
    private long eaQ = 0;
    private long createTime = 0;
    private long azc = 0;
    private boolean eaR = false;
    private com.baidu.tbadk.performanceLog.e eaS = null;
    private long eaT = 0;
    private boolean eaU = false;
    private String atf = null;
    private String eaW = "";
    private boolean eaX = true;
    private boolean eaY = false;
    private String source = "";
    private PbInterviewStatusView.a eaZ = new i(this);
    private final Handler mHandler = new Handler(new t(this));
    private dh eas = null;
    private com.baidu.tbadk.baseEditMark.a dzj = null;
    private com.baidu.tieba.tbadkCore.f.a eba = null;
    private ew ebb = null;
    public final com.baidu.tieba.pb.pb.main.a.a ebc = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean ebd = false;
    private boolean ebf = false;
    private boolean ebg = false;
    private boolean ebh = false;
    private boolean bDv = false;
    private boolean ebl = false;
    private com.baidu.tbadk.editortools.d.c atj = new ae(this);
    private boolean ebm = false;
    private int cxL = -1;
    private final CustomMessageListener ebq = new ap(this, CmdConfigCustom.PB_RESET_EDITOR_TOOL);
    private CustomMessageListener bXf = new ba(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener dkR = new bl(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener dlt = new bu(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener ebr = new cc(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener aGV = new cd(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
    private CustomMessageListener cIQ = new j(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private HttpMessageListener bcl = new k(this, CmdConfigHttp.PB_ECOMM_RECOMMEND_HTTP_CMD);
    private cq.a ebs = new l(this);
    private View.OnClickListener dkQ = new m(this);
    private CustomMessageListener ebt = new n(this, CmdConfigCustom.CMD_SEND_GIFT_SUCCESS);
    private boolean ebu = false;
    private com.baidu.tieba.tbadkCore.aj bEB = new com.baidu.tieba.tbadkCore.aj(getPageContext(), new o(this));
    private long dYO = 0;
    private boolean dYP = true;
    private f.a ebv = new p(this);
    private CustomMessageListener bcm = new q(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener ebw = new r(this, CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED);
    private com.baidu.tieba.pb.a.d dYQ = new com.baidu.tieba.pb.a.d(new s(this));
    private CustomMessageListener ebx = new u(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener eby = new v(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener ebz = new w(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    public a.b dLr = new x(this);
    public final View.OnClickListener bGw = new y(this);
    private final a.d atp = new z(this);
    private final dh.a ebA = new aa(this);
    private CustomMessageListener ebB = new ab(this, CmdConfigCustom.CMD_WX_SHARE_SUCCESS);
    private CustomMessageListener ebC = new ac(this, CmdConfigCustom.CMD_TTS_OPTION_PB);
    private final a.InterfaceC0032a ebD = new ad(this);
    private final AbsListView.OnScrollListener zw = new af(this);
    private final com.baidu.adp.base.g ebE = new ag(this);
    private final c ebF = new ah(this);
    private final t.b aOV = new ai(this);
    private final BdListView.e ebH = new aj(this);
    private int ebI = 0;
    private final TbRichTextView.d aGw = new ak(this);
    boolean ebJ = false;
    com.baidu.tieba.tbadkCore.data.s ebK = null;
    private final c.b ebL = new al(this);
    private final View.OnLongClickListener alj = new am(this);
    private final NoNetworkView.a bCV = new an(this);
    public View.OnTouchListener aGS = new ao(this);
    private c.InterfaceC0055c aZA = new aq(this);
    private final c.a ebM = new ar(this);
    private String ebN = null;
    private final ct.a ebO = new as(this);
    private int ebP = -1;
    private int ebQ = -1;

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> ech;
        public ConcurrentHashMap<String, ImageUrlData> eci;
        public boolean eck;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean ecj = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes.dex */
    public interface c {
        void hF(boolean z);
    }

    public void hw(boolean z) {
        this.eaU = z;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m10getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.d.e aHJ() {
        return this.ebk;
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        if (mVar.aHp() != null) {
            String id = mVar.aHp().getId();
            ArrayList<com.baidu.tieba.tbadkCore.data.s> aGZ = this.eas.getPbData().aGZ();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aGZ.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.s sVar = aGZ.get(i2);
                if (sVar.getId() == null || !sVar.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> aHt = mVar.aHt();
                    sVar.qX(mVar.getTotalCount());
                    if (sVar.bfx() != null) {
                        sVar.bfx().clear();
                        sVar.bfx().addAll(aHt);
                    }
                }
            }
            this.ebb.j(this.eas.getPbData());
        }
    }

    public void aHK() {
        com.baidu.tieba.pb.data.h pbData;
        com.baidu.tbadk.core.data.be aGY;
        if (!this.ebu) {
            if (!com.baidu.adp.lib.util.k.fH()) {
                showToast(u.j.no_network_guide);
            } else if (this.dYP) {
                this.ebu = true;
                if (this.eas != null && (pbData = this.eas.getPbData()) != null && (aGY = pbData.aGY()) != null) {
                    int isLike = aGY.qp() == null ? 0 : aGY.qp().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10796").ab("tid", aGY.getId()));
                    }
                    if (this.bEB != null) {
                        this.bEB.a(aGY.qL(), aGY.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        String string;
        if ((sparseArray.get(u.g.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(u.g.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(u.g.tag_check_mute_from) instanceof Integer)) {
            String str = (String) sparseArray.get(u.g.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(u.g.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(u.g.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
                cVar.bP(u.j.operation);
                int i = -1;
                if (sparseArray.get(u.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(u.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(u.j.delete);
                    if (z) {
                        string = getResources().getString(u.j.un_mute);
                    } else {
                        string = getResources().getString(u.j.mute);
                    }
                    strArr[1] = string;
                    cVar.a(strArr, new at(this, sparseArray, z, str2, str));
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(u.j.un_mute) : getResources().getString(u.j.mute);
                    cVar.a(strArr2, new au(this, sparseArray, z, str2, str));
                }
                cVar.d(getPageContext()).rV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hl(int i) {
        com.baidu.tbadk.core.data.be aGY;
        String sb;
        String y;
        if (this.eas != null && this.eas.getPbData() != null && (aGY = this.eas.getPbData().aGY()) != null) {
            if (i == 1) {
                PraiseData qp = aGY.qp();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (qp == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aGY.a(praiseData);
                    } else {
                        aGY.qp().getUser().add(0, metaData);
                        aGY.qp().setNum(aGY.qp().getNum() + 1);
                        aGY.qp().setIsLike(i);
                    }
                }
                if (aGY.qp() != null) {
                    if (aGY.qp().getNum() < 1) {
                        y = getResources().getString(u.j.frs_item_praise_text);
                    } else {
                        y = com.baidu.tbadk.core.util.ba.y(aGY.qp().getNum());
                    }
                    this.ebb.I(y, true);
                }
            } else if (aGY.qp() != null) {
                aGY.qp().setIsLike(i);
                aGY.qp().setNum(aGY.qp().getNum() - 1);
                ArrayList<MetaData> user = aGY.qp().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aGY.qp().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aGY.qp().getNum() < 1) {
                    sb = getResources().getString(u.j.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(aGY.qp().getNum())).toString();
                }
                this.ebb.I(sb, false);
            }
            if (this.eas.aIX()) {
                this.ebb.aKs().notifyDataSetChanged();
            } else {
                this.ebb.k(this.eas.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.tieba.tbadkCore.data.s a2;
        if (this.eas != null && this.eas.getPbData() != null && (a2 = com.baidu.tieba.pb.data.i.a(this.eas.getPbData(), this.eas.aIX(), this.eas.aJm())) != null) {
            com.baidu.tieba.pb.data.i.a(a2, updateAttentionMessage);
            if (this.ebb != null && this.eas != null) {
                this.ebb.c(this.eas.getPbData(), this.eas.aIX(), this.eas.aJm());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bEk == null) {
                this.bEk = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bEk.ap(updateAttentionMessage.getData().toUid, this.eas.getPbData().getForumId());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eas.n(bundle);
        if (this.bEE != null) {
            this.bEE.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.ebk.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.ebn = getPageContext();
        Intent intent = getIntent();
        if (intent != null) {
            this.bvA = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.eaW = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.eaW)) {
                this.eaL = true;
            }
            this.ebP = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.ebQ = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.ebR = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            if (aIg()) {
                setUseStyleImmersiveSticky(false);
            }
            this.ebg = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ba.isEmpty(this.source) ? "" : this.source;
        } else {
            this.bvA = System.currentTimeMillis();
        }
        this.eaQ = System.currentTimeMillis();
        this.azc = this.eaQ - this.bvA;
        super.onCreate(bundle);
        this.eaN = 0;
        p(bundle);
        initUI();
        if (intent != null && this.ebb != null) {
            this.ebb.efP = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
        }
        this.bEE = new VoiceManager();
        this.bEE.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.d.n nVar = new com.baidu.tbadk.editortools.d.n();
        nVar.setForumName(this.eas.aIW());
        if (this.eas.getPbData() != null && this.eas.getPbData().aGX() != null) {
            nVar.setForumId(this.eas.getPbData().aGX().getId());
        }
        nVar.setFrom("pb");
        nVar.a(this.eas);
        this.ebk = (com.baidu.tbadk.editortools.d.e) nVar.af(getActivity());
        this.ebk.d(this);
        this.ebk.a(this.atp);
        this.ebk.a(this.atj);
        this.ebk.a(this, bundle);
        this.ebk.Bl().c(new com.baidu.tbadk.editortools.z(getActivity()));
        this.ebk.Bl().bx(true);
        hy(true);
        this.ebb.setEditorTools(this.ebk.Bl());
        this.ebk.a(this.eas.aJd(), this.eas.getThreadID(), this.eas.aIT());
        registerListener(this.dkR);
        registerListener(this.bcl);
        if (!this.eas.aJa()) {
            this.ebk.fA(this.eas.getThreadID());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.eaQ;
        registerListener(this.bXf);
        registerListener(this.dlt);
        registerListener(this.ebr);
        registerListener(this.aGV);
        registerListener(this.ebq);
        this.ebj = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.fkf);
        this.ebj.beY();
        registerListener(this.ebt);
        registerListener(this.bcm);
        if (this.eas != null) {
            this.eas.aJo();
        }
        if (TbadkCoreApplication.m10getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.ebw);
        registerListener(this.ebC);
        registerListener(this.ebB);
        this.eaV = new com.baidu.tieba.pb.pb.main.b(this.eas, this);
        if (this.ebb != null && this.ebb.aLd() != null && this.ebb.aLe() != null) {
            this.eaK = new com.baidu.tieba.pb.pb.main.a.f(getActivity(), this.ebb.aLd(), this.ebb.aLe());
            this.eaK.a(this.ebv);
            this.eaK.ii(this.ebb.aLj());
        }
        if (aIg() && this.ebb != null && this.ebb.aLe() != null) {
            this.ebb.aLe().setVisibility(8);
        }
        this.ebo = new com.baidu.tbadk.core.view.h();
        this.ebo.abS = 1000L;
        registerListener(this.ebz);
        registerListener(this.ebx);
        registerListener(this.eby);
        this.ebp = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.ebp;
        userMuteAddAndDelCustomMessage.setTag(this.ebp);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.ebp;
        userMuteCheckCustomMessage.setTag(this.ebp);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public String aHL() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.f aHM() {
        return this.eaK;
    }

    private void hy(boolean z) {
        this.ebk.bA(z);
        this.ebk.bB(z);
        this.ebk.bC(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
        if (this.ebk != null && this.ebk.Bl() != null) {
            this.ebk.Bl().Bx();
        }
        if (this.ebb != null) {
            this.ebb.Bx();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bEE != null) {
            this.bEE.onStart(getPageContext());
        }
    }

    public ew aHN() {
        return this.ebb;
    }

    public dh aHO() {
        return this.eas;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.m10getInst().isReadMenuDialogOnTop()) {
            this.eaM = false;
        } else {
            this.eaM = true;
        }
        super.onPause();
        if (this.ebb.aKd() != null && this.ebb.aKd().aHG() != null) {
            this.ebb.aKd().aHG().onPause();
        }
        BdListView listView = getListView();
        this.eaN = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.eaN == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.bEE != null) {
            this.bEE.onPause(getPageContext());
        }
        if (this.ebb != null) {
            this.ebb.onPause();
        }
        if (!this.eas.aJa()) {
            this.ebk.fz(this.eas.getThreadID());
        }
        if (this.eas != null) {
            this.eas.aJp();
        }
        MessageManager.getInstance().unRegisterListener(this.cIQ);
        ajF();
        MessageManager.getInstance().unRegisterListener(this.ebx);
        MessageManager.getInstance().unRegisterListener(this.eby);
        MessageManager.getInstance().unRegisterListener(this.ebz);
    }

    private boolean aHP() {
        com.baidu.tieba.tbadkCore.data.s a2 = com.baidu.tieba.pb.data.i.a(this.eas.getPbData(), this.eas.aIX(), this.eas.aJm());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eaM = false;
        super.onResume();
        if (this.eaY) {
            this.eaY = false;
            aIm();
        }
        if (this.ebb.aKd() != null && this.ebb.aKd().aHG() != null) {
            this.ebb.aKd().aHG().onResume();
        }
        if (aHP()) {
            this.eaT = System.currentTimeMillis();
        } else {
            this.eaT = -1L;
        }
        if (this.ebb != null && this.ebb.getView() != null) {
            if (!this.dCV) {
                aId();
            } else {
                hideLoadingView(this.ebb.getView());
            }
            this.ebb.onResume();
        }
        if (this.eaN == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.ebb != null) {
            noNetworkView = this.ebb.aKe();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.fq()) {
            noNetworkView.aF(false);
        }
        if (this.bEE != null) {
            this.bEE.onResume(getPageContext());
        }
        registerListener(this.cIQ);
        this.ebi = false;
        aIl();
        registerListener(this.ebx);
        registerListener(this.eby);
        registerListener(this.ebz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.ebb.hU(z);
        if (this.ebe != null) {
            this.ebe.hL(z);
        }
        if (z && this.ebi) {
            this.ebb.aKz();
            this.eas.hH(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eaT > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10804").ab("obj_duration", new StringBuilder(String.valueOf(System.currentTimeMillis() - this.eaT)).toString()));
            this.eaT = 0L;
        }
        if (this.ebk != null && this.ebk.Bl() != null && this.ebk.Bl().getVisibility() != 0) {
            this.ebk.BZ();
        }
        if (this.ebb.efS != null && !this.ebb.efS.aLq()) {
            this.ebb.efS.awi();
        }
        if (this.eas != null && this.eas.getPbData() != null && this.eas.getPbData().aGX() != null && this.eas.getPbData().aGY() != null) {
            com.baidu.tbadk.distribute.a.AU().b(getPageContext().getPageActivity(), "pb", this.eas.getPbData().aGX().getId(), com.baidu.adp.lib.h.b.c(this.eas.getPbData().aGY().getId(), 0L));
        }
        if (this.bEE != null) {
            this.bEE.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eaV != null) {
            this.eaV.destroy();
        }
        if (this.ebf && this.eas != null) {
            a(this.eas.getPbData(), -2, 0, false, false);
        }
        if (!this.eaR && this.ebb != null) {
            this.eaR = true;
            this.ebb.aKT();
        }
        if (this.eas != null) {
            this.eas.cancelLoadData();
            this.eas.destory();
        }
        if (this.ebk != null) {
            this.ebk.onDestroy();
        }
        if (this.eba != null) {
            this.eba.cancelLoadData();
        }
        if (this.ebb != null) {
            this.ebb.onDestroy();
            if (this.ebb.efS != null) {
                this.ebb.efS.awi();
            }
        }
        if (this.eaS != null) {
            this.eaS.onDestroy();
        }
        if (this.eaK != null) {
            this.eaK.Xz();
        }
        super.onDestroy();
        if (this.bEE != null) {
            this.bEE.onDestory(getPageContext());
        }
        if (this.bEk != null) {
            this.bEk.destory();
        }
        this.ebb.avR();
        MessageManager.getInstance().unRegisterListener(this.ebx);
        MessageManager.getInstance().unRegisterListener(this.eby);
        MessageManager.getInstance().unRegisterListener(this.ebz);
        MessageManager.getInstance().unRegisterListener(this.ebp);
        this.ebn = null;
        this.ebo = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ebb.onChangeSkinType(i);
        if (this.ebk != null && this.ebk.Bl() != null) {
            this.ebk.Bl().onChangeSkinType(i);
        }
        if (this.ebb.aKe() != null) {
            this.ebb.aKe().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.ebb = new ew(this, this.bGw, this.dYQ);
        this.bEe = new com.baidu.tieba.d.c(getActivity());
        this.bEe.a(this.ebM);
        this.bEe.a(this.aZA);
        this.ebb.setOnScrollListener(this.zw);
        this.ebb.c(this.ebH);
        this.ebb.a(this.aOV);
        this.ebb.hr(com.baidu.tbadk.core.l.nL().nR());
        this.ebb.hs(com.baidu.tbadk.core.l.nL().nN());
        this.ebb.setOnImageClickListener(this.aGw);
        this.ebb.a(this.alj);
        this.ebb.g(this.bCV);
        this.ebb.a(this.ebF);
        this.ebb.hU(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aV(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(u.g.tag_clip_board);
            if (obj instanceof com.baidu.tieba.tbadkCore.data.s) {
                com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) obj;
                if (TextUtils.isEmpty(sVar.getBimg_url()) || !com.baidu.tbadk.core.l.nL().nR()) {
                    return false;
                }
                return oh(sVar.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.ebb != null) {
            if (z && (!this.dCV || this.ebm)) {
                aId();
            } else {
                hideLoadingView(this.ebb.getView());
            }
            this.ebm = false;
        }
    }

    private void aHQ() {
        if (this.eaO == null) {
            this.eaO = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.eaO.a(new String[]{getPageContext().getString(u.j.call_phone), getPageContext().getString(u.j.sms_phone), getPageContext().getString(u.j.search_in_baidu)}, new av(this)).bQ(c.a.Th).bR(17).d(getPageContext());
        }
    }

    private void p(Bundle bundle) {
        this.eas = new dh(this);
        this.eas.a(this.ebA);
        if (this.eas.aJu() != null) {
            this.eas.aJu().a(this.ebO);
        }
        if (this.eas.aJt() != null) {
            this.eas.aJt().a(this.ebs);
        }
        if (bundle != null) {
            this.eas.initWithBundle(bundle);
        } else {
            this.eas.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra("request_code", -1) == 18003) {
            this.eas.hK(true);
        }
        ep.aJZ().H(this.eas.aIV(), this.eas.getIsFromMark());
        if (StringUtils.isNull(this.eas.getThreadID())) {
            finish();
        } else {
            this.eas.DG();
        }
    }

    private void initData(Bundle bundle) {
        this.dzj = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dzj != null) {
            this.dzj.a(this.ebD);
        }
        this.eba = new com.baidu.tieba.tbadkCore.f.a(this);
        this.eba.setLoadDataCallBack(this.ebE);
        this.ebb.a(new aw(this));
        this.bEB.setUniqueId(getUniqueId());
        this.bEB.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.ebb.atw();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.h.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.h.b.c((String) sparseArray.get(u.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.ebp;
        userMuteCheckCustomMessage.setTag(this.ebp);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.bL(u.j.go_setting_float_window_permission);
        aVar.bM(u.j.step_to_setting_float_permission);
        aVar.a(u.j.go_and_setting, new ax(this));
        aVar.b(u.j.cancel, new ay(this));
        aVar.b(getPageContext()).rS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aHS() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.eas != null && this.eas.getPbData() != null) {
            com.baidu.tieba.pb.data.h pbData = this.eas.getPbData();
            if (pbData.aGX() != null) {
                sb.append("forum_name=").append(od(pbData.aGX().getName()));
                sb.append("&");
            }
            if (pbData.aGY() != null) {
                com.baidu.tbadk.core.data.be aGY = pbData.aGY();
                sb.append("thread_id=").append(aGY.getId());
                sb.append("&");
                sb.append("thread_title=").append(od(aGY.getTitle()));
                if (aGY.getAuthor() != null && aGY.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aGY.getAuthor().getPortrait());
                }
            }
        }
        return sb.toString();
    }

    private String od(String str) {
        return str == null ? "" : URLEncoder.encode(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        com.baidu.tieba.tbadkCore.data.s sVar;
        ArrayList<IconData> arrayList;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(u.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.s) && (sVar = (com.baidu.tieba.tbadkCore.data.s) sparseArray.get(u.g.tag_clip_board)) != null && this.eas != null && this.eas.getPbData() != null && sVar.bfB() > 1) {
            String threadID = this.eas.getThreadID();
            String id = sVar.getId();
            int i = 0;
            if (this.eas.getPbData() != null) {
                i = this.eas.getPbData().aHf();
            }
            b oi = oi(id);
            if (oi != null) {
                SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
                SmallTailInfo aMg = sVar.aMg();
                AntiData pc = this.eas.getPbData().pc();
                if (sVar.getAuthor() != null) {
                    arrayList = sVar.getAuthor().getIconInfo();
                } else {
                    arrayList = null;
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i, aMg, pc, false, arrayList).addBigImageData(oi.ech, oi.eci, oi.ecj, oi.index)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aHT() {
        if (this.eas.getPbData() == null || this.eas.getPbData().aGY() == null) {
            return -1;
        }
        return this.eas.getPbData().aGY().qZ();
    }

    private boolean hz(boolean z) {
        if (this.eas == null || this.eas.getPbData() == null) {
            return false;
        }
        return (this.eas.getPbData().aHf() != 0) && !z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hA(boolean z) {
        if (this.eas == null || this.eas.getPbData() == null) {
            return false;
        }
        return ((this.eas.getPbData().aHf() != 0) || this.eas.getPbData().aGY() == null || this.eas.getPbData().aGY().getAuthor() == null || TextUtils.equals(this.eas.getPbData().aGY().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void aHU() {
        if (this.eas != null && this.eas.getPbData() != null && this.eas.getPbData().aGY() != null && this.eas.getPbData().aGY().getAuthor() != null) {
            com.baidu.tbadk.core.data.be aGY = this.eas.getPbData().aGY();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aGY.getAuthor().getUserId());
            boolean hA = hA(equals);
            boolean hz = hz(equals);
            boolean z = equals && this.ebb.aKH();
            GodUserData godUserData = aGY.getAuthor().getGodUserData();
            this.ebb.efS.a(this.eas.aIX(), this.dzj != null ? this.dzj.mA() : false, hA, z, hz, equals && godUserData != null && godUserData.isCanSendCall());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.tbadkCore.data.s sVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (sVar = (com.baidu.tieba.tbadkCore.data.s) sparseArray.get(u.g.tag_clip_board)) != null) {
            d(sVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.h hVar, int i, int i2, boolean z, boolean z2) {
        if (hVar != null && this.eas != null) {
            eg egVar = new eg(getUniqueId());
            egVar.pbData = hVar;
            egVar.threadId = this.eas.getThreadID();
            egVar.postId = this.eas.getPostId();
            egVar.efk = i;
            egVar.efl = i2;
            egVar.efj = this.eas.getHostMode();
            egVar.dYB = this.eas.mA();
            egVar.isSquence = this.eas.aIX();
            egVar.loadType = this.eas.aJr();
            egVar.efm = z;
            egVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, egVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, boolean z2) {
        if (hVar != null && this.eas != null) {
            eg egVar = new eg(getUniqueId());
            egVar.pbData = hVar;
            egVar.threadId = this.eas.getThreadID();
            egVar.postId = this.eas.getPostId();
            egVar.efk = i;
            egVar.efj = this.eas.getHostMode();
            egVar.dYB = this.eas.mA();
            egVar.isSquence = this.eas.aIX();
            egVar.loadType = this.eas.aJr();
            egVar.efm = z;
            egVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, egVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        Pu();
    }

    public void a(boolean z, MarkData markData) {
        this.ebb.aKB();
        this.eas.hJ(z);
        if (this.dzj != null) {
            this.dzj.ab(z);
            if (markData != null) {
                this.dzj.a(markData);
            }
        }
        if (this.eas.mA()) {
            aIa();
        } else {
            this.ebb.j(this.eas.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ny(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oe(String str) {
        if (!StringUtils.isNull(str) && this.eas != null) {
            String threadID = this.eas.getThreadID();
            String id = this.eas.getPbData().aGX().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(u.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData)) {
                if (!this.eas.aJa()) {
                    antiData.setBlock_forum_name(this.eas.getPbData().aGX().getName());
                    antiData.setBlock_forum_id(this.eas.getPbData().aGX().getId());
                    antiData.setUser_name(this.eas.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.eas.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.rg(i)) {
            AntiHelper.O(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            fF(str);
        } else {
            this.ebb.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        int i = 0;
        if (bVar != null) {
            this.ebb.a(0, bVar.rJ, bVar.fmU, true);
            if (bVar.rJ) {
                if (bVar.fmS == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> aGZ = this.eas.getPbData().aGZ();
                    int size = aGZ.size();
                    while (true) {
                        if (i < size) {
                            if (!bVar.mPostId.equals(aGZ.get(i).getId())) {
                                i++;
                            } else {
                                aGZ.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.ebb.j(this.eas.getPbData());
                } else if (bVar.fmS == 0) {
                    aHV();
                } else if (bVar.fmS == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> aGZ2 = this.eas.getPbData().aGZ();
                    int size2 = aGZ2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < aGZ2.get(i2).bfx().size()) {
                                if (!bVar.mPostId.equals(aGZ2.get(i2).bfx().get(i3).getId())) {
                                    i3++;
                                } else {
                                    aGZ2.get(i2).bfx().remove(i3);
                                    aGZ2.get(i2).bfz();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData aHi = this.eas.getPbData().aHi();
                        com.baidu.tieba.tbadkCore.data.s sVar = aGZ2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.data.s> bfA = sVar.bfA();
                        int size3 = bfA.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!bVar.mPostId.equals(aGZ2.get(i2).bfA().get(i4).getId())) {
                                    i4++;
                                } else {
                                    bfA.remove(i4);
                                    aHi.decreaseAlreadyCount();
                                    if (sVar.bfH() > bfA.size()) {
                                        sVar.qZ(bfA.size());
                                    }
                                    if (bfA.size() > 0) {
                                        com.baidu.tieba.tbadkCore.data.s sVar2 = bfA.get(bfA.size() - 1);
                                        aHi.setLastAdditionTime(sVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a avx = sVar2.avx();
                                        String str = "";
                                        if (avx != null) {
                                            str = avx.toString();
                                        }
                                        aHi.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a avx2 = sVar.avx();
                                        String str2 = "";
                                        if (avx2 != null) {
                                            str2 = avx2.toString();
                                        }
                                        aHi.setLastAdditionContent(str2);
                                    }
                                    aIe();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.ebb.j(this.eas.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, a.f fVar) {
        if (fVar != null) {
            this.ebb.a(this.eba.getLoadDataMode(), fVar.rJ, fVar.fmU, true);
            if (fVar.rJ) {
                this.ebd = true;
                if (i == 2) {
                    this.eas.getPbData().aGY().bJ(1);
                    this.eas.setIsGood(1);
                } else if (i == 3) {
                    this.eas.getPbData().aGY().bJ(0);
                    this.eas.setIsGood(0);
                } else if (i == 4) {
                    this.eas.getPbData().aGY().bI(1);
                    this.eas.nD(1);
                } else if (i == 5) {
                    this.eas.getPbData().aGY().bI(0);
                    this.eas.nD(0);
                }
                this.ebb.a(this.eas.getPbData(), this.eas.aIX(), true);
            }
        }
    }

    private void aHV() {
        if (this.eas.aIY()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.eas.getThreadID());
            setResult(-1, intent);
        }
        if (aIb()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHW() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.ebb != null) {
            this.ebb.avR();
        }
        if (this.eas != null && this.eas.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.eas.getPbData().aGY().getId();
            historyMessage.forumName = this.eas.getPbData().aGX().getName();
            historyMessage.threadName = this.eas.getPbData().aGY().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.data.s> aGZ = this.eas.getPbData().aGZ();
            int aKE = this.ebb != null ? this.ebb.aKE() : 0;
            if (aGZ != null && aKE >= 0 && aKE < aGZ.size()) {
                historyMessage.postID = aGZ.get(aKE).getId();
            }
            historyMessage.isHostOnly = this.eas.getHostMode();
            historyMessage.isSquence = this.eas.aIX();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.ebk != null) {
            this.ebk.onDestroy();
        }
        if (this.eas != null && this.eas.aIY()) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.eas.getThreadID());
            if (this.ebd) {
                intent.putExtra("type", 2);
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.eas.avI());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.eas.getIsGood());
            }
            setResult(-1, intent);
        }
        if (aIb()) {
            if (this.eas != null && this.ebb != null && this.ebb.LN() != null) {
                com.baidu.tieba.pb.data.h pbData = this.eas.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.m10getInst().getDefaultBubble());
                    }
                    if (!pbData.aHe()) {
                        ep.aJZ().a(this.eas.getPbData(), this.ebb.LN().onSaveInstanceState(), this.eas.aIX(), this.eas.getHostMode());
                    }
                }
            } else {
                ep.aJZ().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.ebb != null && this.ebb.aIP()) {
                    this.ebb.aIR();
                    return true;
                }
                return super.onKeyDown(i, keyEvent);
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nz(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m10getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(u.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.ebk.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aHZ();
                    return;
                case 13008:
                    ep.aJZ().reset();
                    this.mHandler.postDelayed(new az(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.eas != null) {
                        a(aHY(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    w(intent);
                    return;
                case 24006:
                    v(intent);
                    return;
                case 24007:
                    if (aHT() == 1) {
                        aHX();
                        return;
                    }
                    return;
                case 24008:
                    this.ebb.hx(false);
                    if (this.eas.getPbData() != null && this.eas.getPbData().aGY() != null && this.eas.getPbData().aGY().qO() != null) {
                        this.eas.getPbData().aGY().qO().setStatus(2);
                        break;
                    }
                    break;
                case 25001:
                    break;
                default:
                    return;
            }
            if (this.eaV != null) {
                this.eaV.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aHN() != null && aHJ() != null && aHN().aKh() && com.baidu.tbadk.editortools.d.b.BM().getStatus() == 1) {
                    com.baidu.tbadk.editortools.d.b.BM().setStatus(0);
                    if (this.ebb != null) {
                        this.ebb.aKg();
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
    public void aHX() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.eas.getPbData() != null && this.eas.getPbData().aGY() != null && this.eas.getPbData().aGY().qG() != null && this.eas.getPbData().aGY().qG().size() > 0 && this.eas.getPbData().aGY().qG().get(0) != null) {
            this.mAwardActId = this.eas.getPbData().aGY().qG().get(0).of();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.h.b.c(this.eas.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void v(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra("key_action", 0)) {
                case 1:
                    abq();
                    return;
                case 2:
                    this.ebb.aKp();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aHY() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] aM = this.eas.getPbData().aM(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.data.s aKi = this.ebb.aKi();
        String str = "";
        if (aKi != null) {
            str = aKi.getId();
            String aW = aKi.aW(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(aW)) {
                aM[1] = aW;
            }
        }
        String qL = this.eas.getPbData().aGY().qL();
        if (qL != null && qL.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(aM[1]);
        shareFromPBMsgData.setImageUrl(aM[0]);
        shareFromPBMsgData.setForumName(this.eas.getPbData().aGX().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.eas.getPbData().aGY().getId());
        shareFromPBMsgData.setTitle(this.eas.getPbData().aGY().getTitle());
        return shareFromPBMsgData;
    }

    private void w(Intent intent) {
        a(aHY(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.eas != null && this.eas.getPbData() != null && this.eas.getPbData().aGY() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gl glVar = new gl(getPageContext().getPageActivity());
            glVar.setData(shareFromPBMsgData);
            aVar.bO(1);
            aVar.y(glVar);
            aVar.a(u.j.share, new bb(this, glVar, j, str, str2, shareFromPBMsgData));
            aVar.b(u.j.alert_no_button, new bc(this, glVar));
            aVar.aq(true);
            aVar.b(getPageContext()).rS();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                glVar.A(shareFromPBMsgData.getImageUrl(), this.eas.getPbData().aHg() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.eas != null && this.eas.getPbData() != null && this.eas.getPbData().aGY() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gl glVar = new gl(getPageContext().getPageActivity());
            glVar.setData(shareFromPBMsgData);
            aVar.bO(1);
            aVar.y(glVar);
            aVar.a(u.j.share, new bd(this, glVar, i, str, j, shareFromPBMsgData));
            aVar.b(u.j.alert_no_button, new be(this, glVar));
            aVar.aq(true);
            aVar.b(getPageContext()).rS();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                glVar.A(shareFromPBMsgData.getImageUrl(), this.eas.getPbData().aHg() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHZ() {
        MarkData nK;
        if (this.dzj != null && (nK = this.eas.nK(this.ebb.aKF())) != null) {
            if (!nK.isApp() || (nK = this.eas.nK(this.ebb.aKF() + 1)) != null) {
                this.ebb.aKy();
                this.dzj.a(nK);
                if (!this.dzj.mA()) {
                    this.dzj.mC();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.dzj.mB();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIa() {
        com.baidu.tieba.pb.data.h pbData = this.eas.getPbData();
        this.eas.hJ(true);
        pbData.oa(this.dzj.mz());
        this.ebb.j(pbData);
    }

    private boolean aIb() {
        if (this.eas == null) {
            return true;
        }
        if (this.eas.mA()) {
            MarkData aJi = this.eas.aJi();
            if (aJi == null || !this.eas.getIsFromMark()) {
                return true;
            }
            MarkData nK = this.eas.nK(this.ebb.aKF());
            if (nK == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aJi);
                setResult(-1, intent);
                return true;
            } else if (nK.getPostId() == null || nK.getPostId().equals(aJi.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aJi);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cz(String.format(getPageContext().getString(u.j.alert_update_mark), Integer.valueOf(nK.getFloor())));
                aVar.a(u.j.alert_yes_btn, new bf(this, nK, aJi, aVar));
                aVar.b(u.j.alert_no_button, new bg(this, aJi, aVar));
                aVar.a(new bh(this, aJi, aVar));
                aVar.b(getPageContext());
                aVar.rS();
                return false;
            }
        } else if (this.eas.getPbData() == null || this.eas.getPbData().aGZ() == null || this.eas.getPbData().aGZ().size() <= 0 || !this.eas.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: LN */
    public BdListView getListView() {
        if (this.ebb == null) {
            return null;
        }
        return this.ebb.LN();
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public int He() {
        if (this.ebb == null) {
            return 0;
        }
        return this.ebb.aKL();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vA() {
        if (this.ebb == null) {
            return 0;
        }
        return this.ebb.WJ();
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<ImageView> Hf() {
        if (this.aGa == null) {
            this.aGa = new com.baidu.adp.lib.f.b<>(new bi(this), 8, 0);
        }
        return this.aGa;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<TextView> Hg() {
        if (this.aGb == null) {
            this.aGb = TbRichTextView.h(getPageContext().getPageActivity(), 8);
        }
        return this.aGb;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<GifView> Hh() {
        if (this.aGf == null) {
            this.aGf = new com.baidu.adp.lib.f.b<>(new bj(this), 20, 0);
        }
        return this.aGf;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> Hi() {
        if (this.aGd == null) {
            this.aGd = new com.baidu.adp.lib.f.b<>(new bk(this), 8, 0);
        }
        return this.aGd;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> Hk() {
        if (this.aGc == null) {
            this.aGc = com.baidu.tieba.graffiti.e.createGraffitiViewPool(getPageContext().getPageActivity(), 6);
        }
        return this.aGc;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> fj(int i) {
        if (this.aGg == null) {
            if (i == 1) {
                this.aGg = com.baidu.tieba.togetherhi.ds.createGraffitiViewPool(getPageContext().getPageActivity(), 6);
            } else {
                this.aGg = TogetherHiLivingView.createGraffitiViewPool(getPageContext().getPageActivity(), 6);
            }
        }
        return this.aGg;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> vB() {
        if (this.aeH == null) {
            this.aeH = UserIconBox.e(getPageContext().getPageActivity(), 8);
        }
        return this.aeH;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void A(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void B(Context context, String str) {
        gm.aLl().h(getPageContext(), str);
    }

    private com.baidu.tbadk.core.dialog.a aIc() {
        if (this.eaP == null) {
            this.eaP = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.eaP.cy(getPageContext().getString(u.j.download_baidu_video_dialog));
            this.eaP.a(getPageContext().getString(u.j.install), new bm(this));
            this.eaP.b(getPageContext().getString(u.j.cancel), new bn(this));
            this.eaP.ap(true);
            this.eaP.b(getPageContext());
            this.eaP.aq(false);
        }
        this.eaP.rS();
        return this.eaP;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void C(Context context, String str) {
        gm.aLl().h(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void E(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra("title", "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            aIc();
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
            com.baidu.tieba.pb.data.h pbData = this.eas.getPbData();
            com.baidu.tbadk.widget.richText.a az = az(str, i);
            if (az != null && (cVar = az.GD().get(this.ebI)) != null) {
                bVar.ech = new ArrayList<>();
                bVar.eci = new ConcurrentHashMap<>();
                if (!cVar.GI().GU()) {
                    bVar.eck = false;
                    String c2 = com.baidu.tieba.pb.data.i.c(cVar);
                    bVar.ech.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(cVar);
                    imageUrlData.originalSize = e(cVar);
                    imageUrlData.postId = az.getPostId();
                    imageUrlData.mIsReserver = this.eas.aJh();
                    imageUrlData.mIsSeeHost = this.eas.getHostMode();
                    bVar.eci.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aGX() != null) {
                            bVar.forumName = pbData.aGX().getName();
                            bVar.forumId = pbData.aGX().getId();
                        }
                        if (pbData.aGY() != null) {
                            bVar.threadId = pbData.aGY().getId();
                        }
                        bVar.ecj = pbData.aHg() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.eck = true;
                int size = pbData.aGZ().size();
                this.ebJ = false;
                bVar.index = -1;
                int i2 = i;
                for (int i3 = 0; i3 < size; i3++) {
                    com.baidu.tieba.tbadkCore.data.s sVar = pbData.aGZ().get(i3);
                    com.baidu.tbadk.widget.richText.a avx = sVar.avx();
                    if (!ev.g(sVar)) {
                        a2 = a(avx, az, i2, i, bVar.ech, bVar.eci);
                    } else {
                        a2 = a(sVar, i2, bVar.ech, bVar.eci);
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> bfA = sVar.bfA();
                    i2 = a2;
                    for (int i4 = 0; i4 < bfA.size(); i4++) {
                        i2 = a(bfA.get(i4).avx(), az, i2, i, bVar.ech, bVar.eci);
                    }
                }
                if (bVar.ech.size() > 0) {
                    bVar.lastId = bVar.ech.get(bVar.ech.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aGX() != null) {
                        bVar.forumName = pbData.aGX().getName();
                        bVar.forumId = pbData.aGX().getId();
                    }
                    if (pbData.aGY() != null) {
                        bVar.threadId = pbData.aGY().getId();
                    }
                    bVar.ecj = pbData.aHg() == 1;
                }
                bVar.index = i2;
            }
        }
    }

    private String d(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.GI() == null) {
            return null;
        }
        return cVar.GI().GX();
    }

    private long e(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.GI() == null) {
            return 0L;
        }
        return cVar.GI().getOriginalSize();
    }

    private int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.g GI;
        if (aVar == aVar2) {
            this.ebJ = true;
        }
        if (aVar != null) {
            int size = aVar.GD().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.GD().get(i6) == null || aVar.GD().get(i6).getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int width = aVar.GD().get(i6).GI().getWidth();
                    int height = aVar.GD().get(i6).GI().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.GD().get(i6).GI().GU()) {
                        if (aVar == aVar2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.GD().get(i6);
                        String c2 = com.baidu.tieba.pb.data.i.c(cVar);
                        if (!TextUtils.isEmpty(c2)) {
                            arrayList.add(c2);
                            if (cVar != null && (GI = cVar.GI()) != null) {
                                String GV = GI.GV();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = GV;
                                int i9 = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.urlType = i9;
                                imageUrlData.urlType = i9;
                                imageUrlData.originalUrl = d(cVar);
                                imageUrlData.originalSize = e(cVar);
                                imageUrlData.postId = aVar.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.h.b.c(this.eas.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.eas.aJh();
                                imageUrlData.mIsSeeHost = this.eas.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.ebJ) {
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

    private int a(com.baidu.tieba.tbadkCore.data.s sVar, int i, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        ArrayList<com.baidu.tieba.tbadkCore.data.k> bfb;
        if (sVar != null && arrayList != null && concurrentHashMap != null && (bfb = sVar.bfL().bfb()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bfb.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = bfb.get(i3);
                if (kVar != null) {
                    String bfi = kVar.bfi();
                    if (!com.baidu.tbadk.core.util.ba.isEmpty(bfi)) {
                        arrayList.add(bfi);
                        if (!this.ebJ) {
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
    public void d(com.baidu.tieba.tbadkCore.data.s sVar) {
        if (sVar != null) {
            boolean z = false;
            if (sVar.getId() != null && sVar.getId().equals(this.eas.qE())) {
                z = true;
            }
            MarkData e = this.eas.e(sVar);
            if (e != null) {
                this.ebb.aKy();
                if (this.dzj != null) {
                    this.dzj.a(e);
                    if (!z) {
                        this.dzj.mC();
                    } else {
                        this.dzj.mB();
                    }
                }
            }
        }
    }

    private com.baidu.tbadk.widget.richText.a az(String str, int i) {
        if (this.eas == null || this.eas.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.h pbData = this.eas.getPbData();
        com.baidu.tbadk.widget.richText.a a2 = a(pbData.aGZ(), str, i);
        if (a2 == null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.s> aGZ = pbData.aGZ();
            int size = aGZ.size();
            for (int i2 = 0; i2 < size; i2++) {
                a2 = a(aGZ.get(i2).bfA(), str, i);
                if (a2 != null) {
                    return a2;
                }
            }
            return a2;
        }
        return a2;
    }

    private long og(String str) {
        ArrayList<com.baidu.tieba.tbadkCore.data.s> aGZ;
        com.baidu.tieba.pb.data.h pbData = this.eas.getPbData();
        if (pbData != null && (aGZ = pbData.aGZ()) != null && !aGZ.isEmpty()) {
            Iterator<com.baidu.tieba.tbadkCore.data.s> it = aGZ.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.s next = it.next();
                com.baidu.tieba.tbadkCore.data.i bfL = next.bfL();
                if (bfL != null && bfL.fkn) {
                    Iterator<com.baidu.tbadk.widget.richText.c> it2 = next.avx().GD().iterator();
                    while (it2.hasNext()) {
                        com.baidu.tbadk.widget.richText.c next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.GQ().getLink().equals(str)) {
                            return bfL.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> GD;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a avx = arrayList.get(i2).avx();
            if (avx != null && (GD = avx.GD()) != null) {
                int size = GD.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (GD.get(i4) != null && GD.get(i4).getType() == 8) {
                        i3++;
                        if (GD.get(i4).GI().GV().equals(str)) {
                            int width = GD.get(i4).GI().getWidth();
                            int height = GD.get(i4).GI().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.ebI = i4;
                            return avx;
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
            this.eaq = str;
            if (this.eaO == null) {
                aHQ();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.eaO.bT(1).setVisibility(8);
            } else {
                this.eaO.bT(1).setVisibility(0);
            }
            this.eaO.rV();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bEE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pu() {
        hideNetRefreshView(this.ebb.getView());
        aId();
        if (this.eas.DG()) {
            this.ebb.aKy();
        }
    }

    private void aId() {
        showLoadingView(this.ebb.getView(), false, TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds400));
        View Dg = getLoadingView().Dg();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Dg.getLayoutParams();
        layoutParams.addRule(3, this.ebb.aLd().getId());
        Dg.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VR() {
        if (this.bEE != null) {
            this.bEE.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nA(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abq() {
        if (this.eas.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.h pbData = this.eas.getPbData();
            String name = pbData.aGX().getName();
            String title = pbData.aGY().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.eas.getThreadID() + "?share=9105&fr=share";
            String[] aM = pbData.aM(getPageContext().getPageActivity());
            String str2 = aM[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = aM[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (aHT() == 1) {
                if (pbData != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10399").ab("fid", pbData.getForumId()).ab("tid", pbData.getThreadId()).ab("uid", currentAccount));
                }
            } else if (aHT() == 2 && pbData != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10406").ab("fid", pbData.getForumId()).ab("tid", pbData.getThreadId()).ab("uid", currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(u.j.share_content_tpl), title, name, str3);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.linkUrl = str;
            fVar.akf = true;
            fVar.extData = this.eas.getThreadID();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(u.j.share_tieba_qunzu, u.f.icon_unite_share_qunzu, new bo(this));
            shareDialogConfig.addOutsideTextView(u.j.forum_friend, u.f.icon_unite_share_baf, new bp(this));
            shareDialogConfig.setCopyLinkListener(new bq(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<LinearLayout> Hj() {
        if (this.aGe == null) {
            this.aGe = new com.baidu.adp.lib.f.b<>(new br(this), 15, 0);
        }
        return this.aGe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIe() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.pb.data.h pbData = this.eas.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.pc().isIfAddition();
            AdditionData aHi = pbData.aHi();
            boolean z3 = aHi == null ? false : isIfAddition;
            if (z3) {
                z = aHi.getAlreadyCount() != aHi.getTotalCount();
                if (!TextUtils.isEmpty(aHi.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.pb.main.b.e eVar = this.ebb.efS;
            if (!z3 || !z) {
                z2 = false;
            }
            eVar.ij(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.ebb.aKr() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10517").s("obj_locate", 2).ab("fid", this.eas.getPbData().getForumId()));
            } else {
                com.baidu.tbadk.core.data.be aGY = this.eas.getPbData().aGY();
                if (view != null) {
                    boolean z = aGY.qp() == null || aGY.qp().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.dYO > 1000) {
                            this.dYP = true;
                            aU(view);
                        } else {
                            this.dYP = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            f(view, this.dYP);
                        } else {
                            e(view, this.dYP);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        e(view, this.dYP);
                    } else if (motionEvent.getAction() == 3) {
                        e(view, this.dYP);
                    }
                }
            }
        }
        return false;
    }

    private void e(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), u.a.praise_animation_scale2));
            new Handler().postDelayed(new bs(this), 200L);
        }
    }

    private void f(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), u.a.praise_animation_scale3));
            new Handler().postDelayed(new bt(this), 600L);
        }
    }

    private void aU(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), u.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void VT() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m10getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(u.j.login_to_use), true, 11017)));
        } else if (aVar.rU() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.rU();
            int intValue = ((Integer) sparseArray.get(ew.ehJ)).intValue();
            if (intValue == ew.ehK) {
                if (!this.eba.bgr()) {
                    this.ebb.aKv();
                    int intValue2 = ((Integer) sparseArray.get(u.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(u.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(u.g.tag_del_post_type)).intValue();
                    this.eba.a(this.eas.getPbData().aGX().getId(), this.eas.getPbData().aGX().getName(), this.eas.getPbData().aGY().getId(), (String) sparseArray.get(u.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == ew.ehL || intValue == ew.ehN) {
                if (this.eas.aJu() != null) {
                    this.eas.aJu().nC(dh.edc);
                }
                if (intValue == ew.ehL) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == ew.ehM) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.ebN).oa()));
            }
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (sparseArray.get(u.g.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(u.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(u.g.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(u.g.tag_user_mute_thread_id);
        }
        if (sparseArray.get(u.g.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(u.g.tag_user_mute_post_id);
        }
        if (sparseArray.get(u.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(u.g.tag_user_mute_msg);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.ebp);
        userMuteAddAndDelCustomMessage.setTag(this.ebp);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean oh(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bn.ab(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.sN().getString("bubble_link", ""))) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.m10getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(u.j.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void hB(boolean z) {
        this.ebi = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aIf() {
        ArrayList<com.baidu.tieba.tbadkCore.data.s> aGZ;
        int s;
        if (this.eas == null || this.eas.getPbData() == null || this.eas.getPbData().aGZ() == null || (s = com.baidu.tbadk.core.util.y.s((aGZ = this.eas.getPbData().aGZ()))) == 0) {
            return "";
        }
        int aKE = this.ebb.aKE();
        com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(aGZ, aKE);
        if (sVar == null || sVar.getAuthor() == null) {
            return "";
        }
        if (this.eas.om(sVar.getAuthor().getUserId())) {
            return sVar.getId();
        }
        for (int i = aKE - 1; i != 0; i--) {
            com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(aGZ, i);
            if (sVar2 == null || sVar2.getAuthor() == null || sVar2.getAuthor().getUserId() == null) {
                break;
            } else if (this.eas.om(sVar2.getAuthor().getUserId())) {
                return sVar2.getId();
            }
        }
        for (int i2 = aKE + 1; i2 < s; i2++) {
            com.baidu.tieba.tbadkCore.data.s sVar3 = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(aGZ, i2);
            if (sVar3 == null || sVar3.getAuthor() == null || sVar3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.eas.om(sVar3.getAuthor().getUserId())) {
                return sVar3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void F(Context context, String str) {
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bi.us().c(getPageContext(), new String[]{str})) {
            com.baidu.tieba.pb.b.a(og(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.eas.getPbData().aGX().getId(), this.eas.getPbData().aGX().getName(), this.eas.getPbData().aGY().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, String str2, String str3, String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cz(getResources().getString(u.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cz(getResources().getString(u.j.make_sure_hide));
        }
        aVar.a(getResources().getString(u.j.alert_yes_button), new bv(this, j, str, str2, str3, str4));
        aVar.b(getResources().getString(u.j.alert_no_button), new bw(this, j, str, str2, str3, str4));
        aVar.aq(false);
        aVar.b(getPageContext());
        aVar.rS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b oi(String str) {
        String str2;
        if (this.eas.getPbData() == null || this.eas.getPbData().aGZ() == null || this.eas.getPbData().aGZ().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i < this.eas.getPbData().aGZ().size()) {
                if (str.equals(this.eas.getPbData().aGZ().get(i).getId())) {
                    break;
                }
                i++;
            } else {
                i = 0;
                break;
            }
        }
        com.baidu.tieba.tbadkCore.data.s sVar = this.eas.getPbData().aGZ().get(i);
        if (sVar.avx() == null || sVar.avx().GD() == null) {
            return null;
        }
        Iterator<com.baidu.tbadk.widget.richText.c> it = sVar.avx().GD().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.GI() != null) {
                    str2 = next.GI().GV();
                }
            }
        }
        a(str2, 0, bVar);
        com.baidu.tieba.pb.data.i.a(sVar, bVar);
        return bVar;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eaL) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.eaL = false;
        } else if (aIg()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eaL) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.eaL = false;
        } else if (aIg()) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void hC(boolean z) {
        this.ebl = z;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a005";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.eas != null) {
            if (this.eas.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(this.eas.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.h.b.c(this.eas.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aIg() {
        return (!this.eaJ && this.ebP == -1 && this.ebQ == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            this.ebS = mVar;
            this.eaJ = true;
            this.ebb.aKj();
            this.ebb.or(this.ebR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIh() {
        if (this.ebS != null) {
            if (this.ebP == -1) {
                showToast(u.j.pb_manga_not_prev_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.ebS.getCartoonId(), this.ebP, 0)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIi() {
        if (this.ebS != null) {
            if (this.ebQ == -1) {
                showToast(u.j.pb_manga_not_next_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.ebS.getCartoonId(), this.ebQ, 0)));
            finish();
        }
    }

    public int aIj() {
        return this.ebP;
    }

    public int aIk() {
        return this.ebQ;
    }

    private void ajF() {
        if (this.eas != null && this.eas.getPbData() != null && this.eas.getPbData().aGY() != null && this.eas.getPbData().aGY().rh()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIl() {
        if (this.eas != null && this.eas.getPbData() != null && this.eas.getPbData().aGY() != null && this.eas.getPbData().aGY().rh()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aIm() {
        if (this.eaM) {
            this.eaY = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.eas.getPbData() != null && this.eas.getPbData().aGY() != null && this.eas.getPbData().aGY().qh() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.eas.getPbData().aGY().qh().getThreadId(), this.eas.getPbData().aGY().qh().getTaskId(), this.eas.getPbData().aGY().qh().getForumId(), this.eas.getPbData().aGY().qh().getForumName(), this.eas.getPbData().aGY().qt(), this.eas.getPbData().aGY().qu())));
            this.eaL = true;
            finish();
        }
    }

    public boolean aIn() {
        return this.eaM;
    }

    public String aIo() {
        return this.eaW;
    }

    public PbInterviewStatusView.a aIp() {
        return this.eaZ;
    }

    public void hD(boolean z) {
        this.eaX = z;
    }

    public boolean aIq() {
        if (this.eas != null) {
            return this.eas.aIY();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cz(getResources().getString(u.j.mute_is_super_member_function));
        aVar.a(u.j.open_now, new bx(this));
        aVar.b(u.j.cancel, new by(this));
        aVar.b(this.ebn).rS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fF(String str) {
        if (str == null) {
            str = "";
        }
        if (this.ebn != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ebn.getPageActivity());
            aVar.cz(str);
            aVar.b(u.j.know, new bz(this));
            aVar.b(this.ebn).rS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.ebb.atw();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ebn.getPageActivity());
        if (com.baidu.tbadk.core.util.ba.isEmpty(str)) {
            aVar.cz(this.ebn.getResources().getString(u.j.block_mute_message_alert, str2));
        } else {
            aVar.cz(str);
        }
        aVar.a(u.j.confirm, new ca(this, userMuteAddAndDelCustomMessage));
        aVar.b(u.j.cancel, new cb(this));
        aVar.b(this.ebn).rS();
    }
}
