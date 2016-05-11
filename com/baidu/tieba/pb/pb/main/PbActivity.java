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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.c.c;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.a.f;
import com.baidu.tieba.pb.pb.main.cj;
import com.baidu.tieba.pb.pb.main.cn;
import com.baidu.tieba.pb.pb.main.cw;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.f.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.togetherhi.TogetherHiLivingView;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.k;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, com.baidu.tbadk.widget.richText.m {
    private com.baidu.adp.lib.f.b<ImageView> aEI;
    private com.baidu.adp.lib.f.b<TextView> aEJ;
    private com.baidu.adp.lib.f.b<View> aEK;
    private com.baidu.adp.lib.f.b<View> aEL;
    private com.baidu.adp.lib.f.b<LinearLayout> aEM;
    private com.baidu.adp.lib.f.b<GifView> aEN;
    private com.baidu.adp.lib.f.b<View> aEO;
    private com.baidu.adp.lib.f.b<TbImageView> adv;
    private VoiceManager beZ;
    private com.baidu.tieba.c.c bgJ;
    private com.baidu.tbadk.core.dialog.a diD;
    private com.baidu.tieba.pb.pb.main.b diJ;
    private dd diU;
    private boolean diY;
    private com.baidu.tieba.tbadkCore.data.f diZ;
    private String dif;
    private com.baidu.tieba.pb.pb.main.a.f diy;
    private String djC;
    private com.baidu.tbadk.core.data.k djD;
    private com.baidu.tbadk.editortools.d.e dja;
    private boolean djr;
    private long mAwardActId;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean dix = false;
    private boolean diz = false;
    private boolean diA = false;
    private boolean cST = false;
    private int diB = 0;
    private com.baidu.tbadk.core.dialog.c diC = null;
    private long aXp = -1;
    private long axE = 0;
    private long diE = 0;
    private long createTime = 0;
    private long axw = 0;
    private boolean diF = false;
    private com.baidu.tbadk.performanceLog.e diG = null;
    private long diH = 0;
    private boolean diI = false;
    private String arA = null;
    private String diK = "";
    private boolean diL = true;
    private boolean diM = false;
    private PbInterviewStatusView.a diN = new h(this);
    private final Handler mHandler = new Handler(new s(this));
    private cw dih = null;
    private com.baidu.tbadk.baseEditMark.a cPW = null;
    private com.baidu.tieba.tbadkCore.f.a diO = null;
    private UserMuteAddAndDelModel diP = null;
    private com.baidu.tieba.usermute.k diQ = null;
    private el diR = null;
    public final com.baidu.tieba.pb.pb.main.a.a diS = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean diT = false;
    private boolean diV = false;
    private boolean diW = false;
    private boolean diX = false;
    private boolean bfZ = false;
    private boolean djb = false;
    private com.baidu.tbadk.editortools.d.c arE = new ad(this);
    private boolean djc = false;
    private int bQV = -1;
    private final CustomMessageListener djd = new ao(this, CmdConfigCustom.PB_RESET_EDITOR_TOOL);
    private CustomMessageListener bxB = new az(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener beY = new bk(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener cCW = new bt(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener dje = new bu(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener aFC = new bv(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
    private CustomMessageListener caR = new i(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private cj.a djf = new j(this);
    private View.OnClickListener cCv = new k(this);
    private CustomMessageListener djg = new l(this, CmdConfigCustom.CMD_SEND_GIFT_SUCCESS);
    private boolean beQ = false;
    private com.baidu.tieba.tbadkCore.af bfd = new com.baidu.tieba.tbadkCore.af(getPageContext(), new m(this));
    private long bfp = 0;
    private boolean bfq = true;
    private f.a djh = new n(this);
    private CustomMessageListener bhc = new o(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener dji = new p(this, CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED);
    private com.baidu.tieba.pb.a.d dfM = new com.baidu.tieba.pb.a.d(new q(this));
    private UserMuteAddAndDelModel.a djj = new r(this);
    private k.a djk = new t(this);
    public a.b daz = new u(this);
    public final View.OnClickListener bjV = new v(this);
    private final a.d arK = new w(this);
    private final cw.a djl = new x(this);
    private CustomMessageListener djm = new y(this, CmdConfigCustom.CMD_WX_SHARE_SUCCESS);
    private CustomMessageListener djn = new z(this, CmdConfigCustom.CMD_TTS_OPTION_PB);
    private final a.InterfaceC0032a djo = new aa(this);
    private final AbsListView.OnScrollListener yW = new ab(this);
    private final com.baidu.adp.base.g djp = new ac(this);
    private final c djq = new ae(this);
    private final t.b aKD = new af(this);
    private final BdListView.e djs = new ag(this);
    private int djt = 0;
    private final TbRichTextView.d aFe = new ah(this);
    boolean dju = false;
    com.baidu.tieba.tbadkCore.data.s djv = null;
    private final c.b djw = new ai(this);
    private final View.OnLongClickListener ajO = new aj(this);
    private final NoNetworkView.a bes = new ak(this);
    public View.OnTouchListener aFz = new al(this);
    private c.InterfaceC0053c aVi = new am(this);
    private final c.a djx = new an(this);
    private String djy = null;
    private final cn.a djz = new ap(this);
    private int djA = -1;
    private int djB = -1;

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> djS;
        public ConcurrentHashMap<String, ImageUrlData> djT;
        public boolean djV;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean djU = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes.dex */
    public interface c {
        void gB(boolean z);
    }

    public void gu(boolean z) {
        this.diI = z;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m11getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.d.e awr() {
        return this.dja;
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        if (hVar.avO() != null) {
            String id = hVar.avO().getId();
            ArrayList<com.baidu.tieba.tbadkCore.data.s> avC = this.dih.getPbData().avC();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= avC.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.s sVar = avC.get(i2);
                if (sVar.getId() == null || !sVar.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> avS = hVar.avS();
                    sVar.pn(hVar.getTotalCount());
                    if (sVar.aTO() != null) {
                        sVar.aTO().clear();
                        sVar.aTO().addAll(avS);
                    }
                }
            }
            this.diR.j(this.dih.getPbData());
        }
    }

    public void aws() {
        com.baidu.tieba.pb.data.e pbData;
        com.baidu.tbadk.core.data.ax avB;
        if (!this.beQ) {
            if (!com.baidu.adp.lib.util.k.fH()) {
                showToast(t.j.no_network_guide);
            } else if (this.bfq) {
                this.beQ = true;
                if (this.dih != null && (pbData = this.dih.getPbData()) != null && (avB = pbData.avB()) != null) {
                    int isLike = avB.getPraise() == null ? 0 : avB.getPraise().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10796").ac("tid", avB.getId()));
                    }
                    if (this.bfd != null) {
                        this.bfd.a(avB.qZ(), avB.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        if ((sparseArray.get(t.g.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(t.g.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(t.g.tag_check_mute_from) instanceof Integer)) {
            String str = (String) sparseArray.get(t.g.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(t.g.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(t.g.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
                cVar.bP(t.j.operation);
                int i = -1;
                if (sparseArray.get(t.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(t.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(t.j.delete);
                    strArr[1] = z ? getResources().getString(t.j.un_mute) : getResources().getString(t.j.mute);
                    cVar.a(strArr, new aq(this, sparseArray, z, str2, str));
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(t.j.un_mute) : getResources().getString(t.j.mute);
                    cVar.a(strArr2, new ar(this, sparseArray, z, str2, str));
                }
                cVar.d(getPageContext()).rX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh(int i) {
        com.baidu.tbadk.core.data.ax avB;
        String sb;
        String B;
        if (this.dih != null && this.dih.getPbData() != null && (avB = this.dih.getPbData().avB()) != null) {
            if (i == 1) {
                PraiseData praise = avB.getPraise();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (praise == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        avB.setPraise(praiseData);
                    } else {
                        avB.getPraise().getUser().add(0, metaData);
                        avB.getPraise().setNum(avB.getPraise().getNum() + 1);
                        avB.getPraise().setIsLike(i);
                    }
                }
                if (avB.getPraise() != null) {
                    if (avB.getPraise().getNum() < 1) {
                        B = getResources().getString(t.j.frs_item_praise_text);
                    } else {
                        B = com.baidu.tbadk.core.util.ay.B(avB.getPraise().getNum());
                    }
                    this.diR.G(B, true);
                }
            } else if (avB.getPraise() != null) {
                avB.getPraise().setIsLike(i);
                avB.getPraise().setNum(avB.getPraise().getNum() - 1);
                ArrayList<MetaData> user = avB.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            avB.getPraise().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (avB.getPraise().getNum() < 1) {
                    sb = getResources().getString(t.j.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(avB.getPraise().getNum())).toString();
                }
                this.diR.G(sb, false);
            }
            if (this.dih.axB()) {
                this.diR.ayU().notifyDataSetChanged();
            } else {
                this.diR.k(this.dih.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.tieba.tbadkCore.data.s a2;
        if (this.dih != null && this.dih.getPbData() != null && (a2 = com.baidu.tieba.pb.data.f.a(this.dih.getPbData(), this.dih.axB(), this.dih.getRequestType())) != null) {
            com.baidu.tieba.pb.data.f.a(a2, updateAttentionMessage);
            if (this.diR != null && this.dih != null) {
                this.diR.c(this.dih.getPbData(), this.dih.axB(), this.dih.getRequestType());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.dih.p(bundle);
        if (this.beZ != null) {
            this.beZ.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.dja.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.aXp = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.diK = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.diK)) {
                this.diz = true;
            }
            this.djA = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.djB = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.djC = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            if (awM()) {
                setUseStyleImmersiveSticky(false);
            }
            this.diW = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
        } else {
            this.aXp = System.currentTimeMillis();
        }
        this.diE = System.currentTimeMillis();
        this.axw = this.diE - this.aXp;
        super.onCreate(bundle);
        this.diB = 0;
        q(bundle);
        nq();
        if (intent != null && this.diR != null) {
            this.diR.dmW = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
        }
        this.beZ = new VoiceManager();
        this.beZ.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.d.n nVar = new com.baidu.tbadk.editortools.d.n();
        nVar.setForumName(this.dih.axA());
        if (this.dih.getPbData() != null && this.dih.getPbData().avA() != null) {
            nVar.setForumId(this.dih.getPbData().avA().getId());
        }
        nVar.setFrom("pb");
        nVar.a(this.dih);
        this.dja = (com.baidu.tbadk.editortools.d.e) nVar.ag(getActivity());
        this.dja.d(this);
        this.dja.a(this.arK);
        this.dja.a(this.arE);
        this.dja.a(this, bundle);
        this.dja.Bb().c(new com.baidu.tbadk.editortools.z(getActivity()));
        gv(true);
        this.diR.setEditorTools(this.dja.Bb());
        this.dja.a(this.dih.axI(), this.dih.getThreadID(), this.dih.axx());
        registerListener(this.beY);
        if (!this.dih.axF()) {
            this.dja.fw(this.dih.getThreadID());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.diE;
        registerListener(this.bxB);
        registerListener(this.cCW);
        registerListener(this.dje);
        registerListener(this.aFC);
        registerListener(this.djd);
        this.diZ = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.esp);
        this.diZ.aTq();
        registerListener(this.djg);
        registerListener(this.bhc);
        if (this.dih != null) {
            this.dih.axR();
        }
        if (TbadkCoreApplication.m11getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.dji);
        registerListener(this.djn);
        registerListener(this.djm);
        this.diJ = new com.baidu.tieba.pb.pb.main.b(this.dih, this);
        if (this.diR != null && this.diR.azE() != null && this.diR.azF() != null) {
            this.diy = new com.baidu.tieba.pb.pb.main.a.f(getActivity(), this.diR.azE(), this.diR.azF());
            this.diy.a(this.djh);
        }
        if (awM() && this.diR != null && this.diR.azF() != null) {
            this.diR.azF().setVisibility(8);
        }
    }

    private void gv(boolean z) {
        this.dja.by(z);
        this.dja.bz(z);
        this.dja.bA(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
        if (this.dja != null && this.dja.Bb() != null) {
            this.dja.Bb().Bn();
        }
        if (this.diR != null) {
            this.diR.Bn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.beZ != null) {
            this.beZ.onStart(getPageContext());
        }
    }

    public el awt() {
        return this.diR;
    }

    public cw awu() {
        return this.dih;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.m11getInst().isReadMenuDialogOnTop()) {
            this.diA = false;
        } else {
            this.diA = true;
        }
        super.onPause();
        if (this.diR.ayE() != null && this.diR.ayE().awp() != null) {
            this.diR.ayE().awp().onPause();
        }
        BdListView listView = getListView();
        this.diB = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.diB == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.beZ != null) {
            this.beZ.onPause(getPageContext());
        }
        if (this.diR != null) {
            this.diR.onPause();
        }
        if (!this.dih.axF()) {
            this.dja.fv(this.dih.getThreadID());
        }
        if (this.dih != null) {
            this.dih.axS();
        }
        MessageManager.getInstance().unRegisterListener(this.caR);
        awR();
    }

    private boolean awv() {
        com.baidu.tieba.tbadkCore.data.s a2 = com.baidu.tieba.pb.data.f.a(this.dih.getPbData(), this.dih.axB(), this.dih.getRequestType());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.diA = false;
        super.onResume();
        if (this.diM) {
            this.diM = false;
            awS();
        }
        if (this.diR.ayE() != null && this.diR.ayE().awp() != null) {
            this.diR.ayE().awp().onResume();
        }
        if (awv()) {
            this.diH = System.currentTimeMillis();
        } else {
            this.diH = -1L;
        }
        if (this.diR != null && this.diR.getView() != null) {
            if (!this.cST) {
                awI();
            } else {
                hideLoadingView(this.diR.getView());
            }
        }
        if (this.diB == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.diR != null) {
            noNetworkView = this.diR.ayF();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.fq()) {
            noNetworkView.aE(false);
        }
        if (this.beZ != null) {
            this.beZ.onResume(getPageContext());
        }
        registerListener(this.caR);
        this.diY = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.diR.gP(z);
        if (this.diU != null) {
            this.diU.gI(z);
        }
        if (z && this.diY) {
            this.diR.azb();
            this.dih.gE(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.diH > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10804").ac("obj_duration", new StringBuilder(String.valueOf(System.currentTimeMillis() - this.diH)).toString()));
            this.diH = 0L;
        }
        if (this.dja != null && this.dja.Bb() != null && this.dja.Bb().getVisibility() != 0) {
            this.dja.BP();
        }
        if (this.diR.dmZ != null && !this.diR.dmZ.azO()) {
            this.diR.dmZ.anh();
        }
        if (this.dih != null && this.dih.getPbData() != null && this.dih.getPbData().avA() != null && this.dih.getPbData().avB() != null) {
            com.baidu.tbadk.distribute.a.AK().b(getPageContext().getPageActivity(), "pb", this.dih.getPbData().avA().getId(), com.baidu.adp.lib.h.b.c(this.dih.getPbData().avB().getId(), 0L));
        }
        if (this.beZ != null) {
            this.beZ.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.diJ != null) {
            this.diJ.destroy();
        }
        if (this.diV && this.dih != null) {
            a(this.dih.getPbData(), -2, 0, false, false);
        }
        if (!this.diF && this.diR != null) {
            this.diF = true;
            this.diR.azu();
        }
        if (this.diQ != null) {
            this.diQ.onDestroy();
        }
        if (this.dih != null) {
            this.dih.cancelLoadData();
            this.dih.destory();
        }
        if (this.dja != null) {
            this.dja.onDestroy();
        }
        if (this.diO != null) {
            this.diO.cancelLoadData();
        }
        if (this.diR != null) {
            this.diR.onDestroy();
            if (this.diR.dmZ != null) {
                this.diR.dmZ.anh();
            }
        }
        if (this.diG != null) {
            this.diG.onDestroy();
        }
        if (this.diy != null) {
            this.diy.RP();
        }
        super.onDestroy();
        if (this.beZ != null) {
            this.beZ.onDestory(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.diR.onChangeSkinType(i);
        if (this.dja != null && this.dja.Bb() != null) {
            this.dja.Bb().onChangeSkinType(i);
        }
        if (this.diR.ayF() != null) {
            this.diR.ayF().onChangeSkinType(getPageContext(), i);
        }
    }

    private void nq() {
        this.diR = new el(this, this.bjV, this.dfM);
        this.bgJ = new com.baidu.tieba.c.c(getActivity());
        this.bgJ.a(this.djx);
        this.bgJ.a(this.aVi);
        this.diR.setOnScrollListener(this.yW);
        this.diR.c(this.djs);
        this.diR.a(this.aKD);
        this.diR.gq(com.baidu.tbadk.core.l.ob().oh());
        this.diR.gr(com.baidu.tbadk.core.l.ob().od());
        this.diR.setOnImageClickListener(this.aFe);
        this.diR.a(this.ajO);
        this.diR.g(this.bes);
        this.diR.a(this.djq);
        this.diR.gP(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aN(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(t.g.tag_clip_board);
            if (obj instanceof com.baidu.tieba.tbadkCore.data.s) {
                com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) obj;
                if (TextUtils.isEmpty(sVar.getBimg_url()) || !com.baidu.tbadk.core.l.ob().oh()) {
                    return false;
                }
                return lT(sVar.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.diR != null) {
            if (z && (!this.cST || this.djc)) {
                awI();
            } else {
                hideLoadingView(this.diR.getView());
            }
            this.djc = false;
        }
    }

    private void aww() {
        if (this.diC == null) {
            this.diC = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.diC.a(new String[]{getPageContext().getString(t.j.call_phone), getPageContext().getString(t.j.sms_phone), getPageContext().getString(t.j.search_in_baidu)}, new as(this)).bQ(c.a.Si).bR(17).d(getPageContext());
        }
    }

    private void q(Bundle bundle) {
        this.dih = new cw(this);
        this.dih.a(this.djl);
        if (this.dih.axX() != null) {
            this.dih.axX().a(this.djz);
        }
        if (this.dih.axW() != null) {
            this.dih.axW().a(this.djf);
        }
        if (bundle != null) {
            this.dih.initWithBundle(bundle);
        } else {
            this.dih.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra("request_code", -1) == 18003) {
            this.dih.gH(true);
        }
        ee.ayA().F(this.dih.axz(), this.dih.getIsFromMark());
        if (StringUtils.isNull(this.dih.getThreadID())) {
            finish();
        } else {
            this.dih.Dy();
        }
    }

    private void initData(Bundle bundle) {
        this.cPW = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.cPW != null) {
            this.cPW.a(this.djo);
        }
        this.diO = new com.baidu.tieba.tbadkCore.f.a(this);
        this.diO.setLoadDataCallBack(this.djp);
        this.diP = new UserMuteAddAndDelModel(getPageContext());
        this.diP.a(this.djj);
        this.diQ = new com.baidu.tieba.usermute.k(getPageContext(), this.djk);
        this.diR.a(new at(this));
        this.bfd.setUniqueId(getUniqueId());
        this.bfd.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = (String) sparseArray.get(t.g.tag_user_mute_mute_userid);
        this.diR.akv();
        this.diQ.a(com.baidu.adp.lib.h.b.c(currentAccount, 0L), com.baidu.adp.lib.h.b.c(str, 0L), sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.bL(t.j.go_setting_float_window_permission);
        aVar.bM(t.j.step_to_setting_float_permission);
        aVar.a(t.j.go_and_setting, new au(this));
        aVar.b(t.j.cancel, new av(this));
        aVar.b(getPageContext()).rU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        com.baidu.tieba.tbadkCore.data.s sVar;
        ArrayList<IconData> arrayList;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(t.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.s) && (sVar = (com.baidu.tieba.tbadkCore.data.s) sparseArray.get(t.g.tag_clip_board)) != null && sVar.aTS() > 1) {
            String threadID = this.dih.getThreadID();
            String id = sVar.getId();
            int i = 0;
            if (this.dih.getPbData() != null) {
                i = this.dih.getPbData().avH();
            }
            b lU = lU(id);
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo aAC = sVar.aAC();
            AntiData pz = this.dih.getPbData().pz();
            if (sVar.getAuthor() != null) {
                arrayList = sVar.getAuthor().getIconInfo();
            } else {
                arrayList = null;
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i, aAC, pz, false, arrayList).addBigImageData(lU.djS, lU.djT, lU.djU, lU.index)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int awy() {
        if (this.dih.getPbData() == null || this.dih.getPbData().avB() == null) {
            return -1;
        }
        return this.dih.getPbData().avB().rg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean gw(boolean z) {
        if (this.dih == null || this.dih.getPbData() == null) {
            return false;
        }
        return ((this.dih.getPbData().avH() != 0) || this.dih.getPbData().avB() == null || this.dih.getPbData().avB().getAuthor() == null || TextUtils.equals(this.dih.getPbData().avB().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void awz() {
        if (this.dih != null && this.dih.getPbData() != null && this.dih.getPbData().avB() != null && this.dih.getPbData().avB().getAuthor() != null) {
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.dih.getPbData().avB().getAuthor().getUserId());
            this.diR.dmZ.b(this.dih.axB(), this.cPW != null ? this.cPW.mP() : false, gw(equals), equals && this.diR.azi());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.tbadkCore.data.s sVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (sVar = (com.baidu.tieba.tbadkCore.data.s) sparseArray.get(t.g.tag_clip_board)) != null) {
            d(sVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.e eVar, int i, int i2, boolean z, boolean z2) {
        if (eVar != null && this.dih != null) {
            dy dyVar = new dy(getUniqueId());
            dyVar.pbData = eVar;
            dyVar.threadId = this.dih.getThreadID();
            dyVar.postId = this.dih.getPostId();
            dyVar.dmC = i;
            dyVar.dmD = i2;
            dyVar.dmB = this.dih.getHostMode();
            dyVar.dfy = this.dih.mP();
            dyVar.isSquence = this.dih.axB();
            dyVar.loadType = this.dih.axU();
            dyVar.dmE = z;
            dyVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, dyVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, boolean z2) {
        if (eVar != null && this.dih != null) {
            dy dyVar = new dy(getUniqueId());
            dyVar.pbData = eVar;
            dyVar.threadId = this.dih.getThreadID();
            dyVar.postId = this.dih.getPostId();
            dyVar.dmC = i;
            dyVar.dmB = this.dih.getHostMode();
            dyVar.dfy = this.dih.mP();
            dyVar.isSquence = this.dih.axB();
            dyVar.loadType = this.dih.axU();
            dyVar.dmE = z;
            dyVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, dyVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        amA();
    }

    public void a(boolean z, MarkData markData) {
        this.diR.azd();
        this.dih.gG(z);
        if (this.cPW != null) {
            this.cPW.aa(z);
            if (markData != null) {
                this.cPW.a(markData);
            }
        }
        if (this.dih.mP()) {
            awF();
        } else {
            this.diR.j(this.dih.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lJ(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lR(String str) {
        if (!StringUtils.isNull(str) && this.dih != null) {
            String threadID = this.dih.getThreadID();
            String id = this.dih.getPbData().avA().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(t.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData)) {
                if (!this.dih.axF()) {
                    antiData.setBlock_forum_name(this.dih.getPbData().avA().getName());
                    antiData.setBlock_forum_id(this.dih.getPbData().avA().getId());
                    antiData.setUser_name(this.dih.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.dih.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.e.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.pw(i)) {
            AntiHelper.O(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            this.diP.fB(str);
        } else {
            this.diR.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        int i = 0;
        if (bVar != null) {
            this.diR.a(0, bVar.rg, bVar.evb, true);
            if (bVar.rg) {
                if (bVar.euZ == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> avC = this.dih.getPbData().avC();
                    int size = avC.size();
                    while (true) {
                        if (i < size) {
                            if (!bVar.mPostId.equals(avC.get(i).getId())) {
                                i++;
                            } else {
                                avC.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.diR.j(this.dih.getPbData());
                } else if (bVar.euZ == 0) {
                    awA();
                } else if (bVar.euZ == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> avC2 = this.dih.getPbData().avC();
                    int size2 = avC2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < avC2.get(i2).aTO().size()) {
                                if (!bVar.mPostId.equals(avC2.get(i2).aTO().get(i3).getId())) {
                                    i3++;
                                } else {
                                    avC2.get(i2).aTO().remove(i3);
                                    avC2.get(i2).aTQ();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData avK = this.dih.getPbData().avK();
                        com.baidu.tieba.tbadkCore.data.s sVar = avC2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.data.s> aTR = sVar.aTR();
                        int size3 = aTR.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!bVar.mPostId.equals(avC2.get(i2).aTR().get(i4).getId())) {
                                    i4++;
                                } else {
                                    aTR.remove(i4);
                                    avK.decreaseAlreadyCount();
                                    if (sVar.aTY() > aTR.size()) {
                                        sVar.pp(aTR.size());
                                    }
                                    if (aTR.size() > 0) {
                                        com.baidu.tieba.tbadkCore.data.s sVar2 = aTR.get(aTR.size() - 1);
                                        avK.setLastAdditionTime(sVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a amw = sVar2.amw();
                                        String str = "";
                                        if (amw != null) {
                                            str = amw.toString();
                                        }
                                        avK.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a amw2 = sVar.amw();
                                        String str2 = "";
                                        if (amw2 != null) {
                                            str2 = amw2.toString();
                                        }
                                        avK.setLastAdditionContent(str2);
                                    }
                                    awJ();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.diR.j(this.dih.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, a.f fVar) {
        if (fVar != null) {
            this.diR.a(this.diO.getLoadDataMode(), fVar.rg, fVar.evb, true);
            if (fVar.rg) {
                this.diT = true;
                if (i == 2) {
                    this.dih.getPbData().avB().bJ(1);
                    this.dih.setIsGood(1);
                } else if (i == 3) {
                    this.dih.getPbData().avB().bJ(0);
                    this.dih.setIsGood(0);
                } else if (i == 4) {
                    this.dih.getPbData().avB().bI(1);
                    this.dih.lN(1);
                } else if (i == 5) {
                    this.dih.getPbData().avB().bI(0);
                    this.dih.lN(0);
                }
                this.diR.a(this.dih.getPbData(), this.dih.axB(), true);
            }
        }
    }

    private void awA() {
        if (this.dih.axC()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.dih.getThreadID());
            setResult(-1, intent);
        }
        if (awG()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awB() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.diR != null) {
            this.diR.amQ();
        }
        if (this.dih != null && this.dih.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.dih.getPbData().avB().getId();
            historyMessage.forumName = this.dih.getPbData().avA().getName();
            historyMessage.threadName = this.dih.getPbData().avB().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.data.s> avC = this.dih.getPbData().avC();
            int azf = this.diR != null ? this.diR.azf() : 0;
            if (avC != null && azf >= 0 && azf < avC.size()) {
                historyMessage.postID = avC.get(azf).getId();
            }
            historyMessage.isHostOnly = this.dih.getHostMode();
            historyMessage.isSquence = this.dih.axB();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.dja != null) {
            this.dja.onDestroy();
        }
        if (this.dih != null && this.dih.axC()) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.dih.getThreadID());
            if (this.diT) {
                intent.putExtra("type", 2);
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.dih.axE());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.dih.getIsGood());
            }
            setResult(-1, intent);
        }
        if (awG()) {
            if (this.dih != null && this.diR != null && this.diR.KP() != null) {
                com.baidu.tieba.pb.data.e pbData = this.dih.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.m11getInst().getDefaultBubble());
                    }
                    if (!pbData.avG()) {
                        ee.ayA().a(this.dih.getPbData(), this.diR.KP().onSaveInstanceState(), this.dih.axB(), this.dih.getHostMode());
                    }
                }
            } else {
                ee.ayA().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.diR != null && this.diR.axt()) {
                    this.diR.axv();
                    return true;
                }
                finish();
                break;
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lK(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m11getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.dja.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    awE();
                    return;
                case 13008:
                    ee.ayA().reset();
                    this.mHandler.postDelayed(new aw(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.dih != null) {
                        a(awD(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    j(intent);
                    return;
                case 24006:
                    s(intent);
                    return;
                case 24007:
                    if (awy() == 1) {
                        awC();
                        return;
                    }
                    return;
                case 24008:
                    this.diR.gt(false);
                    break;
                case 25001:
                    break;
                default:
                    return;
            }
            if (this.diJ != null) {
                this.diJ.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && awt() != null && awr() != null && awt().ayI() && com.baidu.tbadk.editortools.d.b.BC().getStatus() == 1) {
                    com.baidu.tbadk.editortools.d.b.BC().setStatus(0);
                    if (this.diR != null) {
                        this.diR.ayH();
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
    public void awC() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.dih.getPbData() != null && this.dih.getPbData().avB() != null && this.dih.getPbData().avB().qU() != null && this.dih.getPbData().avB().qU().size() > 0 && this.dih.getPbData().avB().qU().get(0) != null) {
            this.mAwardActId = this.dih.getPbData().avB().qU().get(0).ov();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.h.b.c(this.dih.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void s(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra("key_action", 0)) {
                case 1:
                    Qg();
                    return;
                case 2:
                    this.diR.ayS();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData awD() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] aJ = this.dih.getPbData().aJ(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.data.s ayJ = this.diR.ayJ();
        String str = "";
        if (ayJ != null) {
            str = ayJ.getId();
            String aU = ayJ.aU(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(aU)) {
                aJ[1] = aU;
            }
        }
        String qZ = this.dih.getPbData().avB().qZ();
        if (qZ != null && qZ.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(aJ[1]);
        shareFromPBMsgData.setImageUrl(aJ[0]);
        shareFromPBMsgData.setForumName(this.dih.getPbData().avA().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.dih.getPbData().avB().getId());
        shareFromPBMsgData.setTitle(this.dih.getPbData().avB().getTitle());
        return shareFromPBMsgData;
    }

    private void j(Intent intent) {
        a(awD(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.dih != null && this.dih.getPbData() != null && this.dih.getPbData().avB() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            ga gaVar = new ga(getPageContext().getPageActivity());
            gaVar.setData(shareFromPBMsgData);
            aVar.bO(1);
            aVar.z(gaVar);
            aVar.a(t.j.share, new ax(this, gaVar, j, str, str2, shareFromPBMsgData));
            aVar.b(t.j.alert_no_button, new ay(this, gaVar));
            aVar.aq(true);
            aVar.b(getPageContext()).rU();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                gaVar.z(shareFromPBMsgData.getImageUrl(), this.dih.getPbData().avI() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.dih != null && this.dih.getPbData() != null && this.dih.getPbData().avB() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            ga gaVar = new ga(getPageContext().getPageActivity());
            gaVar.setData(shareFromPBMsgData);
            aVar.bO(1);
            aVar.z(gaVar);
            aVar.a(t.j.share, new ba(this, gaVar, i, str, j, shareFromPBMsgData));
            aVar.b(t.j.alert_no_button, new bb(this, gaVar));
            aVar.aq(true);
            aVar.b(getPageContext()).rU();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                gaVar.z(shareFromPBMsgData.getImageUrl(), this.dih.getPbData().avI() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awE() {
        MarkData lU;
        if (this.cPW != null && (lU = this.dih.lU(this.diR.azg())) != null) {
            if (!lU.isApp() || (lU = this.dih.lU(this.diR.azg() + 1)) != null) {
                this.diR.aza();
                this.cPW.a(lU);
                if (!this.cPW.mP()) {
                    this.cPW.mR();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.cPW.mQ();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awF() {
        com.baidu.tieba.pb.data.e pbData = this.dih.getPbData();
        this.dih.gG(true);
        pbData.lO(this.cPW.mO());
        this.diR.j(pbData);
    }

    private boolean awG() {
        if (this.dih == null) {
            return true;
        }
        if (this.dih.mP()) {
            MarkData axM = this.dih.axM();
            if (axM == null || !this.dih.getIsFromMark()) {
                return true;
            }
            MarkData lU = this.dih.lU(this.diR.azg());
            if (lU == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, axM);
                setResult(-1, intent);
                return true;
            } else if (lU.getPostId() == null || lU.getPostId().equals(axM.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, axM);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cA(String.format(getPageContext().getString(t.j.alert_update_mark), Integer.valueOf(lU.getFloor())));
                aVar.a(t.j.alert_yes_btn, new bc(this, lU, axM, aVar));
                aVar.b(t.j.alert_no_button, new bd(this, axM, aVar));
                aVar.a(new be(this, axM, aVar));
                aVar.b(getPageContext());
                aVar.rU();
                return false;
            }
        } else if (this.dih.getPbData() == null || this.dih.getPbData().avC() == null || this.dih.getPbData().avC().size() <= 0 || !this.dih.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: KP */
    public BdListView getListView() {
        if (this.diR == null) {
            return null;
        }
        return this.diR.KP();
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public int Hd() {
        if (this.diR == null) {
            return 0;
        }
        return this.diR.azm();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vx() {
        if (this.diR == null) {
            return 0;
        }
        return this.diR.QW();
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<ImageView> He() {
        if (this.aEI == null) {
            this.aEI = new com.baidu.adp.lib.f.b<>(new bf(this), 8, 0);
        }
        return this.aEI;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<TextView> Hf() {
        if (this.aEJ == null) {
            this.aEJ = TbRichTextView.h(getPageContext().getPageActivity(), 8);
        }
        return this.aEJ;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<GifView> Hg() {
        if (this.aEN == null) {
            this.aEN = new com.baidu.adp.lib.f.b<>(new bg(this), 20, 0);
        }
        return this.aEN;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> Hh() {
        if (this.aEL == null) {
            this.aEL = new com.baidu.adp.lib.f.b<>(new bh(this), 8, 0);
        }
        return this.aEL;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> Hj() {
        if (this.aEK == null) {
            this.aEK = com.baidu.tieba.graffiti.e.createGraffitiViewPool(getPageContext().getPageActivity(), 6);
        }
        return this.aEK;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> ff(int i) {
        if (this.aEO == null) {
            if (i == 1) {
                this.aEO = com.baidu.tieba.togetherhi.ds.createGraffitiViewPool(getPageContext().getPageActivity(), 6);
            } else {
                this.aEO = TogetherHiLivingView.createGraffitiViewPool(getPageContext().getPageActivity(), 6);
            }
        }
        return this.aEO;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> vy() {
        if (this.adv == null) {
            this.adv = UserIconBox.e(getPageContext().getPageActivity(), 8);
        }
        return this.adv;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void z(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void A(Context context, String str) {
        gb.azJ().g(getPageContext(), str);
    }

    private com.baidu.tbadk.core.dialog.a awH() {
        if (this.diD == null) {
            this.diD = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.diD.cz(getPageContext().getString(t.j.download_baidu_video_dialog));
            this.diD.a(getPageContext().getString(t.j.install), new bi(this));
            this.diD.b(getPageContext().getString(t.j.cancel), new bj(this));
            this.diD.ap(true);
            this.diD.b(getPageContext());
            this.diD.aq(false);
        }
        this.diD.rU();
        return this.diD;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void B(Context context, String str) {
        gb.azJ().g(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void D(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra("title", "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            awH();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void C(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        com.baidu.tbadk.widget.richText.c cVar;
        int a2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.e pbData = this.dih.getPbData();
            com.baidu.tbadk.widget.richText.a ar = ar(str, i);
            if (ar != null && (cVar = ar.GC().get(this.djt)) != null) {
                bVar.djS = new ArrayList<>();
                bVar.djT = new ConcurrentHashMap<>();
                if (!cVar.GH().GT()) {
                    bVar.djV = false;
                    String c2 = com.baidu.tieba.pb.data.f.c(cVar);
                    bVar.djS.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(cVar);
                    imageUrlData.originalSize = e(cVar);
                    imageUrlData.postId = ar.getPostId();
                    imageUrlData.mIsReserver = this.dih.axL();
                    imageUrlData.mIsSeeHost = this.dih.getHostMode();
                    bVar.djT.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.avA() != null) {
                            bVar.forumName = pbData.avA().getName();
                            bVar.forumId = pbData.avA().getId();
                        }
                        if (pbData.avB() != null) {
                            bVar.threadId = pbData.avB().getId();
                        }
                        bVar.djU = pbData.avI() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.djV = true;
                int size = pbData.avC().size();
                this.dju = false;
                bVar.index = -1;
                int i2 = i;
                for (int i3 = 0; i3 < size; i3++) {
                    com.baidu.tieba.tbadkCore.data.s sVar = pbData.avC().get(i3);
                    com.baidu.tbadk.widget.richText.a amw = sVar.amw();
                    if (!ek.g(sVar)) {
                        a2 = a(amw, ar, i2, i, bVar.djS, bVar.djT);
                    } else {
                        a2 = a(sVar, i2, bVar.djS, bVar.djT);
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> aTR = sVar.aTR();
                    i2 = a2;
                    for (int i4 = 0; i4 < aTR.size(); i4++) {
                        i2 = a(aTR.get(i4).amw(), ar, i2, i, bVar.djS, bVar.djT);
                    }
                }
                if (bVar.djS.size() > 0) {
                    bVar.lastId = bVar.djS.get(bVar.djS.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.avA() != null) {
                        bVar.forumName = pbData.avA().getName();
                        bVar.forumId = pbData.avA().getId();
                    }
                    if (pbData.avB() != null) {
                        bVar.threadId = pbData.avB().getId();
                    }
                    bVar.djU = pbData.avI() == 1;
                }
                bVar.index = i2;
            }
        }
    }

    private String d(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.GH() == null) {
            return null;
        }
        return cVar.GH().GW();
    }

    private long e(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.GH() == null) {
            return 0L;
        }
        return cVar.GH().getOriginalSize();
    }

    private int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.g GH;
        if (aVar == aVar2) {
            this.dju = true;
        }
        if (aVar != null) {
            int size = aVar.GC().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.GC().get(i6) == null || aVar.GC().get(i6).getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int width = aVar.GC().get(i6).GH().getWidth();
                    int height = aVar.GC().get(i6).GH().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.GC().get(i6).GH().GT()) {
                        if (aVar == aVar2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.GC().get(i6);
                        String c2 = com.baidu.tieba.pb.data.f.c(cVar);
                        if (!TextUtils.isEmpty(c2)) {
                            arrayList.add(c2);
                            if (cVar != null && (GH = cVar.GH()) != null) {
                                String GU = GH.GU();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = GU;
                                int i9 = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.urlType = i9;
                                imageUrlData.urlType = i9;
                                imageUrlData.originalUrl = d(cVar);
                                imageUrlData.originalSize = e(cVar);
                                imageUrlData.postId = aVar.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.h.b.c(this.dih.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.dih.axL();
                                imageUrlData.mIsSeeHost = this.dih.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.dju) {
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
        ArrayList<com.baidu.tieba.tbadkCore.data.k> aTt;
        if (sVar != null && arrayList != null && concurrentHashMap != null && (aTt = sVar.aUc().aTt()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == aTt.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = aTt.get(i3);
                if (kVar != null) {
                    String aTz = kVar.aTz();
                    if (!com.baidu.tbadk.core.util.ay.isEmpty(aTz)) {
                        arrayList.add(aTz);
                        if (!this.dju) {
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
            if (sVar.getId() != null && sVar.getId().equals(this.dih.qT())) {
                z = true;
            }
            MarkData e = this.dih.e(sVar);
            if (e != null) {
                this.diR.aza();
                if (this.cPW != null) {
                    this.cPW.a(e);
                    if (!z) {
                        this.cPW.mR();
                    } else {
                        this.cPW.mQ();
                    }
                }
            }
        }
    }

    private com.baidu.tbadk.widget.richText.a ar(String str, int i) {
        if (this.dih == null || this.dih.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.e pbData = this.dih.getPbData();
        com.baidu.tbadk.widget.richText.a a2 = a(pbData.avC(), str, i);
        if (a2 == null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.s> avC = pbData.avC();
            int size = avC.size();
            for (int i2 = 0; i2 < size; i2++) {
                a2 = a(avC.get(i2).aTR(), str, i);
                if (a2 != null) {
                    return a2;
                }
            }
            return a2;
        }
        return a2;
    }

    private long lS(String str) {
        ArrayList<com.baidu.tieba.tbadkCore.data.s> avC;
        com.baidu.tieba.pb.data.e pbData = this.dih.getPbData();
        if (pbData != null && (avC = pbData.avC()) != null && !avC.isEmpty()) {
            Iterator<com.baidu.tieba.tbadkCore.data.s> it = avC.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.s next = it.next();
                com.baidu.tieba.tbadkCore.data.i aUc = next.aUc();
                if (aUc != null && aUc.esx) {
                    Iterator<com.baidu.tbadk.widget.richText.c> it2 = next.amw().GC().iterator();
                    while (it2.hasNext()) {
                        com.baidu.tbadk.widget.richText.c next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.GP().getLink().equals(str)) {
                            return aUc.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> GC;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a amw = arrayList.get(i2).amw();
            if (amw != null && (GC = amw.GC()) != null) {
                int size = GC.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (GC.get(i4) != null && GC.get(i4).getType() == 8) {
                        i3++;
                        if (GC.get(i4).GH().GU().equals(str)) {
                            int width = GC.get(i4).GH().getWidth();
                            int height = GC.get(i4).GH().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.djt = i4;
                            return amw;
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
            this.dif = str;
            if (this.diC == null) {
                aww();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.diC.bT(1).setVisibility(8);
            } else {
                this.diC.bT(1).setVisibility(0);
            }
            this.diC.rX();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.beZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amA() {
        hideNetRefreshView(this.diR.getView());
        awI();
        if (this.dih.Dy()) {
            this.diR.aza();
        }
    }

    private void awI() {
        showLoadingView(this.diR.getView(), false, TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds400));
        View CY = getLoadingView().CY();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) CY.getLayoutParams();
        layoutParams.addRule(3, this.diR.azE().getId());
        CY.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pk() {
        if (this.beZ != null) {
            this.beZ.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qg() {
        if (this.dih.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.e pbData = this.dih.getPbData();
            String name = pbData.avA().getName();
            String title = pbData.avB().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.dih.getThreadID() + "?share=9105&fr=share";
            String[] aJ = pbData.aJ(getPageContext().getPageActivity());
            String str2 = aJ[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = aJ[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (awy() == 1) {
                if (pbData != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10399").ac("fid", pbData.getForumId()).ac("tid", pbData.getThreadId()).ac("uid", currentAccount));
                }
            } else if (awy() == 2 && pbData != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10406").ac("fid", pbData.getForumId()).ac("tid", pbData.getThreadId()).ac("uid", currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(t.j.share_content_tpl), title, name, str3);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.linkUrl = str;
            fVar.aiK = true;
            fVar.extData = this.dih.getThreadID();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(t.j.share_tieba_qunzu, t.f.icon_unite_share_qunzu, new bl(this));
            shareDialogConfig.addOutsideTextView(t.j.forum_friend, t.f.icon_unite_share_baf, new bm(this));
            shareDialogConfig.setCopyLinkListener(new bn(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<LinearLayout> Hi() {
        if (this.aEM == null) {
            this.aEM = new com.baidu.adp.lib.f.b<>(new bo(this), 15, 0);
        }
        return this.aEM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awJ() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.pb.data.e pbData = this.dih.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.pz().isIfAddition();
            AdditionData avK = pbData.avK();
            boolean z3 = avK == null ? false : isIfAddition;
            if (z3) {
                z = avK.getAlreadyCount() != avK.getTotalCount();
                if (!TextUtils.isEmpty(avK.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.pb.main.b.e eVar = this.diR.dmZ;
            if (!z3 || !z) {
                z2 = false;
            }
            eVar.hd(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.diR.ayT() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10517").s("obj_locate", 2).ac("fid", this.dih.getPbData().getForumId()));
            } else {
                com.baidu.tbadk.core.data.ax avB = this.dih.getPbData().avB();
                if (view != null) {
                    boolean z = avB.getPraise() == null || avB.getPraise().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.bfp > 1000) {
                            this.bfq = true;
                            aa(view);
                        } else {
                            this.bfq = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            e(view, this.bfq);
                        } else {
                            d(view, this.bfq);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        d(view, this.bfq);
                    } else if (motionEvent.getAction() == 3) {
                        d(view, this.bfq);
                    }
                }
            }
        }
        return false;
    }

    private void d(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), t.a.praise_animation_scale2));
            new Handler().postDelayed(new bp(this), 200L);
        }
    }

    private void e(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), t.a.praise_animation_scale3));
            new Handler().postDelayed(new bq(this), 600L);
        }
    }

    private void aa(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), t.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void PY() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.a(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m11getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, 11017)));
        } else if (aVar.rW() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.rW();
            int intValue = ((Integer) sparseArray.get(el.doJ)).intValue();
            if (intValue == el.doK) {
                if (!this.diO.aUI()) {
                    this.diR.ayX();
                    int intValue2 = ((Integer) sparseArray.get(t.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(t.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(t.g.tag_del_post_type)).intValue();
                    this.diO.a(this.dih.getPbData().avA().getId(), this.dih.getPbData().avA().getName(), this.dih.getPbData().avB().getId(), (String) sparseArray.get(t.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == el.doL || intValue == el.doN) {
                if (this.dih.axX() != null) {
                    this.dih.axX().lM(cw.dkX);
                }
                if (intValue == el.doL) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == el.doM) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.djy).oq()));
            }
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (sparseArray.get(t.g.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(t.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(t.g.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(t.g.tag_user_mute_thread_id);
        }
        if (sparseArray.get(t.g.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(t.g.tag_user_mute_post_id);
        }
        if (sparseArray.get(t.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(t.g.tag_user_mute_msg);
        }
        this.diP.a(z, str, str2, str3, str4, UserMuteAddAndDelModel.From.PB, str5);
    }

    private boolean lT(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bl.ac(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.sQ().getString("bubble_link", ""))) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.m11getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(t.j.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void gx(boolean z) {
        this.diY = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String awK() {
        ArrayList<com.baidu.tieba.tbadkCore.data.s> avC;
        int r;
        if (this.dih == null || this.dih.getPbData() == null || this.dih.getPbData().avC() == null || (r = com.baidu.tbadk.core.util.y.r((avC = this.dih.getPbData().avC()))) == 0) {
            return "";
        }
        int azf = this.diR.azf();
        com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(avC, azf);
        if (sVar == null || sVar.getAuthor() == null) {
            return "";
        }
        if (this.dih.lY(sVar.getAuthor().getUserId())) {
            return sVar.getId();
        }
        for (int i = azf - 1; i != 0; i--) {
            com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(avC, i);
            if (sVar2 == null || sVar2.getAuthor() == null || sVar2.getAuthor().getUserId() == null) {
                break;
            } else if (this.dih.lY(sVar2.getAuthor().getUserId())) {
                return sVar2.getId();
            }
        }
        for (int i2 = azf + 1; i2 < r; i2++) {
            com.baidu.tieba.tbadkCore.data.s sVar3 = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(avC, i2);
            if (sVar3 == null || sVar3.getAuthor() == null || sVar3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.dih.lY(sVar3.getAuthor().getUserId())) {
                return sVar3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void E(Context context, String str) {
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bg.us().c(getPageContext(), new String[]{str})) {
            com.baidu.tieba.pb.b.a(lS(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.dih.getPbData().avA().getId(), this.dih.getPbData().avA().getName(), this.dih.getPbData().avB().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, String str2, String str3, String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cA(getResources().getString(t.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cA(getResources().getString(t.j.make_sure_hide));
        }
        aVar.a(getResources().getString(t.j.alert_yes_button), new br(this, j, str, str2, str3, str4));
        aVar.b(getResources().getString(t.j.alert_no_button), new bs(this, j, str, str2, str3, str4));
        aVar.aq(false);
        aVar.b(getPageContext());
        aVar.rU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b lU(String str) {
        String str2;
        if (this.dih.getPbData() == null || this.dih.getPbData().avC() == null || this.dih.getPbData().avC().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i < this.dih.getPbData().avC().size()) {
                if (str.equals(this.dih.getPbData().avC().get(i).getId())) {
                    break;
                }
                i++;
            } else {
                i = 0;
                break;
            }
        }
        com.baidu.tieba.tbadkCore.data.s sVar = this.dih.getPbData().avC().get(i);
        if (sVar.amw() == null || sVar.amw().GC() == null) {
            return null;
        }
        Iterator<com.baidu.tbadk.widget.richText.c> it = sVar.amw().GC().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.GH() != null) {
                    str2 = next.GH().GU();
                }
            }
        }
        a(str2, 0, bVar);
        com.baidu.tieba.pb.data.f.a(sVar, bVar);
        return bVar;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.diz) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.diz = false;
        } else if (awM()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.diz) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.diz = false;
        } else if (awM()) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public boolean awL() {
        return this.djb;
    }

    public void gy(boolean z) {
        this.djb = z;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a005";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.dih != null) {
            if (this.dih.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(this.dih.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.h.b.c(this.dih.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean awM() {
        return (!this.dix && this.djA == -1 && this.djB == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.k kVar) {
        if (kVar != null) {
            this.djD = kVar;
            this.dix = true;
            this.diR.ayK();
            this.diR.md(this.djC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awN() {
        if (this.djD != null) {
            if (this.djA == -1) {
                showToast(t.j.pb_manga_not_prev_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.djD.getCartoonId(), this.djA, 0)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awO() {
        if (this.djD != null) {
            if (this.djB == -1) {
                showToast(t.j.pb_manga_not_next_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.djD.getCartoonId(), this.djB, 0)));
            finish();
        }
    }

    public int awP() {
        return this.djA;
    }

    public int awQ() {
        return this.djB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awR() {
        if (this.dih != null && this.dih.getPbData() != null && this.dih.getPbData().avB() != null && this.dih.getPbData().avB().rm()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    public void awS() {
        if (this.diA) {
            this.diM = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.dih.getPbData() != null && this.dih.getPbData().avB() != null && this.dih.getPbData().avB().qF() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.dih.getPbData().avB().qF().getThreadId(), this.dih.getPbData().avB().qF().getTaskId(), this.dih.getPbData().avB().qF().getForumId(), this.dih.getPbData().avB().qF().getForumName())));
            this.diz = true;
            finish();
        }
    }

    public boolean awT() {
        return this.diA;
    }

    public String awU() {
        return this.diK;
    }

    public PbInterviewStatusView.a awV() {
        return this.diN;
    }

    public void gz(boolean z) {
        this.diL = z;
    }
}
