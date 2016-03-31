package com.baidu.tieba.pb.pb.main;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
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
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.ReadPbServiceConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.b.a;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.df;
import com.baidu.tieba.pb.pb.main.p;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.f.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.k;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, com.baidu.tbadk.widget.richText.m {
    private static String dgt = "tbgametype";
    private com.baidu.adp.lib.f.b<ImageView> aIH;
    private com.baidu.adp.lib.f.b<TextView> aII;
    private com.baidu.adp.lib.f.b<View> aIJ;
    private com.baidu.adp.lib.f.b<View> aIK;
    private com.baidu.adp.lib.f.b<LinearLayout> aIL;
    private com.baidu.adp.lib.f.b<GifView> aIM;
    private com.baidu.adp.lib.f.b<TbImageView> ahC;
    private VoiceManager bja;
    private String dfD;
    private m dgB;
    private dn dgJ;
    private boolean dgN;
    private com.baidu.tieba.tbadkCore.data.f dgO;
    private com.baidu.tbadk.editortools.d.e dgP;
    private PbLotteryHttpResponseMessage dgR;
    private com.baidu.tieba.b.a dgl;
    private com.baidu.tbadk.core.dialog.a dgv;
    private boolean dhg;
    private String dhr;
    private com.baidu.tbadk.core.data.k dhs;
    private long mAwardActId;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean dgk = false;
    private boolean dgm = false;
    private boolean dgn = false;
    private boolean dbx = false;
    private com.baidu.tbadk.core.dialog.a dgo = null;
    private String dgp = null;
    private String bfq = null;
    private String dgq = null;
    private String dgr = null;
    private String mPackageName = null;
    private int dgs = 0;
    private com.baidu.tbadk.core.dialog.c dgu = null;
    SparseArray<String> bkI = null;
    private long bbg = -1;
    private long aBB = 0;
    private long dgw = 0;
    private long createTime = 0;
    private long aBt = 0;
    private boolean dgx = false;
    private com.baidu.tbadk.performanceLog.e dgy = null;
    private long dgz = 0;
    private boolean dgA = false;
    private String avB = null;
    private final Handler mHandler = new Handler(new q(this));
    private df dfV = null;
    private com.baidu.tbadk.baseEditMark.a cOZ = null;
    private com.baidu.tieba.tbadkCore.f.a dgC = null;
    private UserMuteAddAndDelModel dgD = null;
    private com.baidu.tieba.usermute.k dgE = null;
    private eu dgF = null;
    public final com.baidu.tieba.pb.pb.main.a.a dgG = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean dgH = false;
    private boolean dgI = false;
    private boolean dgK = false;
    private boolean dgL = false;
    private boolean dgM = false;
    private boolean bka = false;
    private boolean dgQ = false;
    private com.baidu.tbadk.editortools.d.c avF = new ab(this);
    private final CustomMessageListener dgS = new am(this, CmdConfigCustom.PB_RESET_EDITOR_TOOL);
    private CustomMessageListener bxy = new ax(this, CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED);
    private CustomMessageListener biZ = new bi(this, CmdConfigCustom.PB_LOAD_DRAFT);
    private CustomMessageListener cBW = new bt(this, CmdConfigCustom.UPDATE_PB_SUBPB_CMD);
    private CustomMessageListener dgT = new ce(this, CmdConfigCustom.PB_ADAPTER_CHANGE_CMD);
    private CustomMessageListener cam = new ck(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    private HttpMessageListener dgU = new cl(this, CmdConfigHttp.PB_LOTTERY_HTTP_CMD);
    private df.b dgV = new r(this);
    private View.OnClickListener cBv = new s(this);
    private CustomMessageListener dgW = new t(this, CmdConfigCustom.CMD_SEND_GIFT_SUCCESS);
    private boolean biR = false;
    private com.baidu.tieba.tbadkCore.ae bjd = new com.baidu.tieba.tbadkCore.ae(getPageContext(), new u(this));
    private long bjp = 0;
    private boolean bjq = true;
    private CustomMessageListener bkX = new v(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener dgX = new w(this, CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED);
    private com.baidu.tieba.pb.a.c dds = new com.baidu.tieba.pb.a.c(new x(this));
    private UserMuteAddAndDelModel.a dgY = new y(this);
    private k.a dgZ = new z(this);
    public a.b cYh = new aa(this);
    public final View.OnClickListener boQ = new ac(this);
    private final a.d avL = new ad(this);
    private final df.c dha = new ae(this);
    private CustomMessageListener dhb = new af(this, CmdConfigCustom.CMD_WX_SHARE_SUCCESS);
    private CustomMessageListener dhc = new ag(this, CmdConfigCustom.CMD_TTS_OPTION_PB);
    private final a.InterfaceC0041a dhd = new ah(this);
    private final AbsListView.OnScrollListener IE = new ai(this);
    private final com.baidu.adp.base.g dhe = new aj(this);
    private final c dhf = new ak(this);
    private final s.a aOt = new al(this);
    private final BdListView.e dhh = new an(this);
    private final BdListView.h dhi = new ao(this);
    private int dhj = 0;
    private final TbRichTextView.d aJc = new ap(this);
    boolean dhk = false;
    com.baidu.tieba.tbadkCore.data.s dhl = null;
    private final c.b dhm = new aq(this);
    private final View.OnLongClickListener aoa = new ar(this);
    private final NoNetworkView.a bit = new as(this);
    public View.OnTouchListener aJt = new at(this);
    private a.InterfaceC0059a aZg = new au(this);
    private String dhn = null;
    private final df.a dho = new av(this);
    private int dhp = -1;
    private int dhq = -1;

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> dhK;
        public ConcurrentHashMap<String, ImageUrlData> dhL;
        public boolean dhN;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean dhM = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes.dex */
    public interface c {
        void fZ(boolean z);
    }

    public void fT(boolean z) {
        this.dgA = z;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.d.e awd() {
        return this.dgP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean awe() {
        return (this.dfV == null || this.dfV.getPbData() == null || !this.dfV.getPbData().avA()) ? false : true;
    }

    public void awf() {
        if (checkUpIsLogin()) {
            if (this.dgF != null) {
                this.dgF.amI();
                this.dgF.ayk();
            }
            if (this.dfV == null || this.dfV.getPbData() == null || this.dfV.getPbData().avu() == null) {
                lS(5);
            }
            com.baidu.tieba.pb.data.e pbData = this.dfV.getPbData();
            if (pbData.avu().isLike() == 0) {
                lS(2);
            } else if (!isProgressBarShown()) {
                if (pbData.avu() != null && pbData.avv() != null && pbData.avv().tw() != null && pbData.avv().tw().size() > 0 && pbData.avv().tw().get(0) != null) {
                    String id = pbData.avu().getId();
                    String id2 = pbData.avv().getId();
                    int activityId = pbData.avv().tw().get(0).getActivityId();
                    int qY = pbData.avv().tw().get(0).qY();
                    int qZ = pbData.avv().tw().get(0).qZ();
                    if (MessageManager.getInstance().findMessage(CmdConfigHttp.PB_LOTTERY_HTTP_CMD, getUniqueId()) == null || MessageManager.getInstance().findMessage(CmdConfigHttp.PB_LOTTERY_HTTP_CMD, getUniqueId()).size() == 0) {
                        if (!awe()) {
                            showProgressBar(true, 0, 0);
                        }
                        sendMessage(new PbLotteryRequestMessage(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), id, id2, 0, activityId, qY, qZ));
                        return;
                    }
                }
                lS(5);
            } else {
                return;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10396").ac("fid", pbData.getForumId()).ac("tid", pbData.getThreadId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i, String str) {
        awi().ayh().H(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lS(int i) {
        awi().ayh().H(i, null);
    }

    public void J(int i, String str) {
        int type;
        if (this.dgR != null) {
            type = this.dgR.getType();
        } else {
            type = getType();
        }
        switch (type) {
            case 0:
                c(true, this.dgR);
                break;
            case 1:
                b(true, this.dgR);
                break;
            case 2:
                a(true, this.dgR);
                break;
            case 3:
                awg();
                break;
            case 4:
                b(this.dgR);
                break;
            default:
                a(this.dgR);
                break;
        }
        this.dgR = null;
    }

    private int getType() {
        return (this.dfV == null || this.dfV.getPbData() == null || this.dfV.getPbData().avu() == null || this.dfV.getPbData().avu().isLike() != 0) ? 5 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage) {
        if (pbLotteryHttpResponseMessage == null) {
            showToast(t.j.neterror);
        } else if (pbLotteryHttpResponseMessage.hasError()) {
            if (!StringUtils.isNULL(pbLotteryHttpResponseMessage.getErrorString())) {
                showToast(pbLotteryHttpResponseMessage.getErrorString());
            } else {
                showToast(t.j.neterror);
            }
        } else if (pbLotteryHttpResponseMessage.getLotteryInfo() != null && !StringUtils.isNULL(pbLotteryHttpResponseMessage.getLotteryInfo().getStatusMsg())) {
            showToast(pbLotteryHttpResponseMessage.getLotteryInfo().getStatusMsg());
        } else {
            showToast(t.j.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage) {
        p pVar = new p(getActivity());
        p.c cVar = new p.c();
        cVar.bLb = getPageContext();
        cVar.dgf = getResources().getString(t.j.no_attention_on_forum);
        cVar.dgg = getResources().getString(t.j.attention_before_lottery);
        cVar.dgb = getResources().getString(t.j.cancel);
        cVar.dgc = getResources().getString(t.j.attention);
        cVar.dgd = new aw(this);
        cVar.dge = new ay(this, z);
        pVar.a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awg() {
        p pVar = new p(getActivity());
        p.c cVar = new p.c();
        cVar.bLb = getPageContext();
        cVar.dgf = getResources().getString(t.j.no_lottery_chance_tip);
        cVar.dgg = getResources().getString(t.j.get_more_lottery_chance_tip);
        cVar.dgb = null;
        cVar.dgc = getResources().getString(t.j.confirm);
        cVar.dgd = null;
        cVar.dge = new az(this);
        pVar.a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage) {
        PbLotteryRequestMessage pbLotteryRequestMessage = (PbLotteryRequestMessage) pbLotteryHttpResponseMessage.getOrginalMessage().getExtra();
        if (!this.dgn && pbLotteryRequestMessage != null && this.dfV != null && this.dfV.getPbData() != null && this.dfV.getPbData().avu() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GetLotteryChanceActivityConfig(getPageContext().getPageActivity(), pbLotteryHttpResponseMessage.getLotteryInfo().avq(), 24006, this.dfV.getPbData().avu().getName(), pbLotteryRequestMessage.getForumId(), pbLotteryRequestMessage.getThreadId(), pbLotteryRequestMessage.getAwardActId(), this.dfV.getPbData().avu().getSigned())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage) {
        String string;
        p pVar = new p(getActivity());
        p.d dVar = new p.d();
        dVar.bLb = getPageContext();
        dVar.dgh = getResources().getString(t.j.aiyaya);
        dVar.dgi = getResources().getString(t.j.not_win_lottery_tip);
        int chanceCount = (int) pbLotteryHttpResponseMessage.getLotteryInfo().avq().getChanceCount();
        dVar.dgj = lT(chanceCount);
        dVar.dgb = getResources().getString(t.j.cancel);
        if (chanceCount <= 0) {
            string = getResources().getString(t.j.add_lottery_chance);
        } else {
            string = getResources().getString(t.j.continue_lottery_tip);
        }
        dVar.dgc = string;
        dVar.dgd = new ba(this);
        dVar.dge = new bb(this, pbLotteryHttpResponseMessage, z);
        pVar.a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awa() {
        awi().ayh().awa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage) {
        p pVar = new p(getActivity());
        p.a aVar = new p.a();
        aVar.bLb = getPageContext();
        aVar.dfY = getResources().getString(t.j.congratulation_to_get_lottery);
        aVar.dfZ = getResources().getString(t.j.lottery_detail, pbLotteryHttpResponseMessage.getLotteryInfo().avp().avo());
        aVar.dga = pbLotteryHttpResponseMessage.getLotteryInfo().avp().avn();
        aVar.dgb = getResources().getString(t.j.cancel);
        aVar.dgc = getResources().getString(t.j.check_immediately);
        aVar.dgd = new bc(this);
        aVar.dge = new bd(this, pbLotteryHttpResponseMessage);
        pVar.a(aVar);
    }

    private CharSequence lT(int i) {
        String string = getResources().getString(t.j.enable_lottery_chance_tip, Integer.valueOf(i));
        SpannableString spannableString = new SpannableString(string);
        int indexOf = string.indexOf(String.valueOf(i));
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_h)), indexOf, String.valueOf(i).length() + indexOf, 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lU(int i) {
        if (this.dfV != null && this.dfV.getPbData() != null && this.dfV.getPbData().avu() != null) {
            this.dfV.getPbData().avu().setLike(i);
            com.baidu.tieba.tbadkCore.x xVar = new com.baidu.tieba.tbadkCore.x();
            xVar.setLike(i);
            xVar.setUserLevel(-1);
            xVar.setLevelName("");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, xVar));
        }
    }

    public void b(com.baidu.tieba.pb.data.g gVar) {
        if (gVar.avI() != null) {
            String id = gVar.avI().getId();
            ArrayList<com.baidu.tieba.tbadkCore.data.s> avw = this.dfV.getPbData().avw();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= avw.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.s sVar = avw.get(i2);
                if (sVar.getId() == null || !sVar.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> avM = gVar.avM();
                    sVar.pr(gVar.getTotalCount());
                    if (sVar.aTo() != null) {
                        sVar.aTo().clear();
                        sVar.aTo().addAll(avM);
                    }
                }
            }
            this.dgF.j(this.dfV.getPbData());
        }
    }

    public void awh() {
        com.baidu.tieba.pb.data.e pbData;
        com.baidu.tbadk.core.data.as avv;
        if (!this.biR) {
            if (!com.baidu.adp.lib.util.k.jw()) {
                showToast(t.j.no_network_guide);
            } else if (this.bjq) {
                this.biR = true;
                if (this.dfV != null && (pbData = this.dfV.getPbData()) != null && (avv = pbData.avv()) != null) {
                    int isLike = avv.getPraise() == null ? 0 : avv.getPraise().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10796").ac("tid", avv.getId()));
                    }
                    if (this.bjd != null) {
                        this.bjd.a(avv.tB(), avv.getId(), isLike, "pb");
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
                cVar.cd(t.j.operation);
                int i = -1;
                if (sparseArray.get(t.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(t.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(t.j.delete);
                    strArr[1] = z ? getResources().getString(t.j.un_mute) : getResources().getString(t.j.mute);
                    cVar.a(strArr, new be(this, sparseArray, z, str2, str));
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(t.j.un_mute) : getResources().getString(t.j.mute);
                    cVar.a(strArr2, new bf(this, sparseArray, z, str2, str));
                }
                cVar.d(getPageContext()).us();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gB(int i) {
        com.baidu.tbadk.core.data.as avv;
        String sb;
        String A;
        if (this.dfV != null && this.dfV.getPbData() != null && (avv = this.dfV.getPbData().avv()) != null) {
            if (i == 1) {
                PraiseData praise = avv.getPraise();
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
                        avv.setPraise(praiseData);
                    } else {
                        avv.getPraise().getUser().add(0, metaData);
                        avv.getPraise().setNum(avv.getPraise().getNum() + 1);
                        avv.getPraise().setIsLike(i);
                    }
                }
                if (avv.getPraise() != null) {
                    if (avv.getPraise().getNum() < 1) {
                        A = getResources().getString(t.j.frs_item_praise_text);
                    } else {
                        A = com.baidu.tbadk.core.util.ay.A(avv.getPraise().getNum());
                    }
                    this.dgF.E(A, true);
                }
            } else if (avv.getPraise() != null) {
                avv.getPraise().setIsLike(i);
                avv.getPraise().setNum(avv.getPraise().getNum() - 1);
                ArrayList<MetaData> user = avv.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            avv.getPraise().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (avv.getPraise().getNum() < 1) {
                    sb = getResources().getString(t.j.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(avv.getPraise().getNum())).toString();
                }
                this.dgF.E(sb, false);
            }
            if (this.dfV.axe()) {
                this.dgF.ayy().notifyDataSetChanged();
            } else {
                this.dgF.k(this.dfV.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.tieba.tbadkCore.data.s a2;
        if (this.dfV != null && this.dfV.getPbData() != null && (a2 = a(this.dfV.getPbData(), this.dfV.axe(), this.dfV.axt())) != null) {
            a(a2, updateAttentionMessage);
            if (this.dgF != null && this.dfV != null) {
                this.dgF.c(this.dfV.getPbData(), this.dfV.axe(), this.dfV.axt());
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.s sVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        int i2;
        if (sVar != null && sVar.getAuthor() != null && sVar.getAuthor().getUserId() != null && sVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = sVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
                i2 = 1;
            } else {
                i = fansNum - 1;
                i2 = 0;
            }
            sVar.getAuthor().setFansNum(i);
            if (sVar.getAuthor().getGodUserData() != null) {
                sVar.getAuthor().getGodUserData().setFollowed(i2);
                sVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }

    private com.baidu.tieba.tbadkCore.data.s a(com.baidu.tieba.pb.data.e eVar, boolean z, int i) {
        if (z) {
            if (eVar == null || eVar.avw() == null || eVar.avw().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.s sVar = eVar.avw().get(0);
            if (sVar.aTs() != 1) {
                return b(eVar);
            }
            return sVar;
        }
        return b(eVar);
    }

    private com.baidu.tieba.tbadkCore.data.s b(com.baidu.tieba.pb.data.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.avv() == null || eVar.avv().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.s sVar = new com.baidu.tieba.tbadkCore.data.s();
        MetaData author = eVar.avv().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = eVar.avv().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        sVar.ps(1);
        sVar.setId(eVar.avv().tB());
        sVar.setTitle(eVar.avv().getTitle());
        sVar.setTime(eVar.avv().getCreateTime());
        sVar.setAuthor(metaData);
        return sVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.dfV.o(bundle);
        if (this.bja != null) {
            this.bja.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.dgP.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bbg = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(intent.getStringExtra("from"))) {
                this.dgm = true;
            }
            this.dhp = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.dhq = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.dhr = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            if (awE()) {
                setUseStyleImmersiveSticky(false);
            }
            this.dgL = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
        } else {
            this.bbg = System.currentTimeMillis();
        }
        this.dgw = System.currentTimeMillis();
        this.aBt = this.dgw - this.bbg;
        super.onCreate(bundle);
        this.dgs = 0;
        p(bundle);
        pU();
        if (intent != null && this.dgF != null) {
            this.dgF.dkB = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
        }
        this.bja = new VoiceManager();
        this.bja.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.d.n nVar = new com.baidu.tbadk.editortools.d.n();
        nVar.setForumName(this.dfV.axd());
        if (this.dfV.getPbData() != null && this.dfV.getPbData().avu() != null) {
            nVar.setForumId(this.dfV.getPbData().avu().getId());
        }
        nVar.setFrom("pb");
        nVar.a(this.dfV);
        this.dgP = (com.baidu.tbadk.editortools.d.e) nVar.ah(getActivity());
        this.dgP.d(this);
        this.dgP.a(this.avL);
        this.dgP.a(this.avF);
        this.dgP.a(this, bundle);
        this.dgP.Dh().c(new com.baidu.tbadk.editortools.z(getActivity()));
        fU(true);
        this.dgF.setEditorTools(this.dgP.Dh());
        this.dgP.a(this.dfV.axl(), this.dfV.getThreadID(), this.dfV.axa());
        registerListener(this.biZ);
        if (!this.dfV.axi()) {
            this.dgP.fz(this.dfV.getThreadID());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.dgw;
        registerListener(this.bxy);
        registerListener(this.cBW);
        registerListener(this.dgT);
        registerListener(this.dgS);
        this.dgU.setSelfListener(true);
        registerListener(this.dgU);
        this.dgO = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.epf);
        this.dgO.aSP();
        registerListener(this.dgW);
        registerListener(this.bkX);
        if (this.dfV != null) {
            this.dfV.axw();
        }
        if (TbadkCoreApplication.m411getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.dgX);
        registerListener(this.dhc);
        registerListener(this.dhb);
        this.dgB = new m(this.dfV, this);
    }

    private void fU(boolean z) {
        this.dgP.bs(z);
        this.dgP.bt(z);
        this.dgP.bu(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
        if (this.dgP != null && this.dgP.Dh() != null) {
            this.dgP.Dh().Dt();
        }
        if (this.dgF != null) {
            this.dgF.Dt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bja != null) {
            this.bja.onStart(getPageContext());
        }
    }

    public eu awi() {
        return this.dgF;
    }

    public df awj() {
        return this.dfV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.m411getInst().isReadMenuDialogOnTop()) {
            this.dgn = false;
        } else {
            this.dgn = true;
        }
        super.onPause();
        if (this.dgF.ayh() != null && this.dgF.ayh().avZ() != null) {
            this.dgF.ayh().avZ().onPause();
        }
        BdListView listView = getListView();
        this.dgs = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.dgs == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.bja != null) {
            this.bja.onPause(getPageContext());
        }
        if (this.dgF != null) {
            this.dgF.onPause();
        }
        if (!this.dfV.axi()) {
            this.dgP.fy(this.dfV.getThreadID());
        }
        if (this.dfV != null) {
            this.dfV.axx();
        }
        MessageManager.getInstance().unRegisterListener(this.cam);
        awJ();
    }

    private boolean awk() {
        com.baidu.tieba.tbadkCore.data.s a2 = a(this.dfV.getPbData(), this.dfV.axe(), this.dfV.axt());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.dgn = false;
        super.onResume();
        if (this.dgF.ayh() != null && this.dgF.ayh().avZ() != null) {
            this.dgF.ayh().avZ().onResume();
        }
        if (awk()) {
            this.dgz = System.currentTimeMillis();
        } else {
            this.dgz = -1L;
        }
        if (this.dgF != null && this.dgF.getView() != null) {
            if (!this.dbx) {
                awA();
            } else {
                hideLoadingView(this.dgF.getView());
            }
        }
        if (this.dgs == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.dgF != null) {
            noNetworkView = this.dgF.ayi();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.jf()) {
            noNetworkView.az(false);
        }
        if (this.bja != null) {
            this.bja.onResume(getPageContext());
        }
        registerListener(this.cam);
        this.dgN = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.dgF.gm(z);
        if (this.dgJ != null) {
            this.dgJ.gf(z);
        }
        if (z && this.dgN) {
            this.dgF.ayF();
            this.dfV.gb(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dgz > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10804").ac("obj_duration", new StringBuilder(String.valueOf(System.currentTimeMillis() - this.dgz)).toString()));
            this.dgz = 0L;
        }
        if (this.dgP != null && this.dgP.Dh() != null && this.dgP.Dh().getVisibility() != 0) {
            this.dgP.DW();
        }
        if (this.dgF.dkF != null && !this.dgF.dkF.azx()) {
            this.dgF.dkF.anl();
        }
        if (this.dfV != null && this.dfV.getPbData() != null && this.dfV.getPbData().avu() != null && this.dfV.getPbData().avv() != null) {
            com.baidu.tbadk.distribute.a.CR().b(getPageContext().getPageActivity(), "pb", this.dfV.getPbData().avu().getId(), com.baidu.adp.lib.h.b.c(this.dfV.getPbData().avv().getId(), 0L));
        }
        if (this.bja != null) {
            this.bja.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dgB != null) {
            this.dgB.destroy();
        }
        if (this.dgK && this.dfV != null) {
            a(this.dfV.getPbData(), -2, false, false);
        }
        if (!this.dgx) {
            this.dgx = true;
            this.dgF.azc();
        }
        this.dgE.onDestroy();
        this.dfV.cancelLoadData();
        this.dfV.destory();
        this.dgP.onDestroy();
        this.dgC.cancelLoadData();
        this.dgF.onDestroy();
        if (this.dgF.dkF != null) {
            this.dgF.dkF.anl();
        }
        if (this.dgy != null) {
            this.dgy.onDestroy();
        }
        super.onDestroy();
        if (this.bja != null) {
            this.bja.onDestory(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dgF.onChangeSkinType(i);
        if (this.dgP != null && this.dgP.Dh() != null) {
            this.dgP.Dh().onChangeSkinType(i);
        }
        if (this.dgF.ayi() != null) {
            this.dgF.ayi().onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awl() {
        this.dgJ = new dn(getPageContext(), this.boQ);
        this.dgJ.gf(this.mIsLogin);
    }

    private void pU() {
        this.dgF = new eu(this, this.boQ, this.dds);
        this.dgl = new com.baidu.tieba.b.a();
        this.dgl.a(this.aZg);
        this.dgF.setOnScrollListener(this.IE);
        this.dgF.c(this.dhh);
        this.dgF.a(this.dhi);
        this.dgF.a(this.aOt);
        this.dgF.fQ(com.baidu.tbadk.core.l.qE().qK());
        this.dgF.fR(com.baidu.tbadk.core.l.qE().qG());
        this.dgF.setOnImageClickListener(this.aJc);
        this.dgF.a(this.aoa);
        this.dgF.f(this.bit);
        this.dgF.a(this.dhf);
        this.dgF.gm(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aJ(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(t.g.tag_clip_board);
            if (obj instanceof com.baidu.tieba.tbadkCore.data.s) {
                com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) obj;
                if (TextUtils.isEmpty(sVar.getBimg_url()) || !com.baidu.tbadk.core.l.qE().qK()) {
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
        if (this.dgF != null) {
            if (z && !this.dbx) {
                awA();
            } else {
                hideLoadingView(this.dgF.getView());
            }
        }
    }

    private void awm() {
        if (this.dgu == null) {
            this.dgu = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            this.dgu.a(new String[]{getPageContext().getString(t.j.call_phone), getPageContext().getString(t.j.sms_phone), getPageContext().getString(t.j.search_in_baidu)}, new bg(this)).ce(c.a.WU).cf(17).d(getPageContext());
        }
    }

    private void p(Bundle bundle) {
        this.dfV = new df(this);
        this.dfV.a(this.dha);
        this.dfV.a(this.dho);
        this.dfV.a(this.dgV);
        this.dfV.axu();
        if (bundle != null) {
            this.dfV.initWithBundle(bundle);
        } else {
            this.dfV.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra("request_code", -1) == 18003) {
            this.dfV.ge(true);
        }
        en.aya().D(this.dfV.axc(), this.dfV.getIsFromMark());
        if (StringUtils.isNull(this.dfV.getThreadID())) {
            finish();
        } else {
            this.dfV.FG();
        }
    }

    private void initData(Bundle bundle) {
        this.cOZ = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.cOZ != null) {
            this.cOZ.a(this.dhd);
        }
        this.dgC = new com.baidu.tieba.tbadkCore.f.a(this);
        this.dgC.setLoadDataCallBack(this.dhe);
        this.dgD = new UserMuteAddAndDelModel(getPageContext());
        this.dgD.a(this.dgY);
        this.dgE = new com.baidu.tieba.usermute.k(getPageContext(), this.dgZ);
        this.dgF.a(new bh(this));
        this.bjd.setUniqueId(getUniqueId());
        this.bjd.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = (String) sparseArray.get(t.g.tag_user_mute_mute_userid);
        this.dgF.akp();
        this.dgE.a(com.baidu.adp.lib.h.b.c(currentAccount, 0L), com.baidu.adp.lib.h.b.c(str, 0L), sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awn() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.bZ(t.j.go_setting_float_window_permission);
        aVar.ca(t.j.step_to_setting_float_permission);
        aVar.a(t.j.go_and_setting, new bj(this));
        aVar.b(t.j.cancel, new bk(this));
        aVar.b(getPageContext()).up();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int awo() {
        if (this.dfV.getPbData() == null || this.dfV.getPbData().avv() == null) {
            return -1;
        }
        return this.dfV.getPbData().avv().tI();
    }

    public boolean fV(boolean z) {
        return z && this.dgF.ayP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fW(boolean z) {
        if (this.dfV == null || this.dfV.getPbData() == null) {
            return false;
        }
        return ((this.dfV.getPbData().avB() != 0) || this.dfV.getPbData().avv() == null || this.dfV.getPbData().avv().getAuthor() == null || TextUtils.equals(this.dfV.getPbData().avv().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void awp() {
        if (this.dfV != null && this.dfV.getPbData() != null && this.dfV.getPbData().avv() != null && this.dfV.getPbData().avv().getAuthor() != null) {
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.dfV.getPbData().avv().getAuthor().getUserId());
            this.dgF.dkF.a(this.dfV.axe(), this.cOZ != null ? this.cOZ.pu() : false, fW(equals), fV(equals));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(View view) {
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
    public void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, boolean z2) {
        if (eVar != null && this.dfV != null) {
            eh ehVar = new eh(getUniqueId());
            ehVar.pbData = eVar;
            ehVar.threadId = this.dfV.getThreadID();
            ehVar.postId = this.dfV.getPostId();
            ehVar.dke = i;
            ehVar.dkd = this.dfV.getHostMode();
            ehVar.dde = this.dfV.pu();
            ehVar.isSquence = this.dfV.axe();
            ehVar.loadType = this.dfV.axz();
            ehVar.dkf = z;
            ehVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, ehVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.e eVar, int i, boolean z, boolean z2) {
        if (eVar != null && this.dfV != null) {
            eh ehVar = new eh(getUniqueId());
            ehVar.pbData = eVar;
            ehVar.threadId = this.dfV.getThreadID();
            ehVar.postId = this.dfV.getPostId();
            ehVar.dke = i;
            ehVar.dkd = this.dfV.getHostMode();
            ehVar.dde = this.dfV.pu();
            ehVar.isSquence = this.dfV.axe();
            ehVar.loadType = this.dfV.axz();
            ehVar.dkf = z;
            ehVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, ehVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        amr();
    }

    public void a(boolean z, MarkData markData) {
        this.dgF.ayH();
        this.dfV.gd(z);
        if (this.cOZ != null) {
            this.cOZ.X(z);
            if (markData != null) {
                this.cOZ.a(markData);
            }
        }
        if (this.dfV.pu()) {
            awv();
        } else {
            this.dgF.j(this.dfV.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lN(String str) {
        if (!StringUtils.isNull(str) && this.dfV != null) {
            String threadID = this.dfV.getThreadID();
            String id = this.dfV.getPbData().avu().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(t.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.dfV.axi()) {
                    antiData.setBlock_forum_name(this.dfV.getPbData().avu().getName());
                    antiData.setBlock_forum_id(this.dfV.getPbData().avu().getId());
                    antiData.setUser_name(this.dfV.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.dfV.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.e.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.pB(i)) {
            AntiHelper.O(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            this.dgD.fE(str);
        } else {
            this.dgF.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        int i = 0;
        if (bVar != null) {
            this.dgF.a(0, bVar.AU, bVar.erS, true);
            if (bVar.AU) {
                if (bVar.erQ == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> avw = this.dfV.getPbData().avw();
                    int size = avw.size();
                    while (true) {
                        if (i < size) {
                            if (!bVar.mPostId.equals(avw.get(i).getId())) {
                                i++;
                            } else {
                                avw.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.dgF.j(this.dfV.getPbData());
                } else if (bVar.erQ == 0) {
                    awq();
                } else if (bVar.erQ == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> avw2 = this.dfV.getPbData().avw();
                    int size2 = avw2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < avw2.get(i2).aTo().size()) {
                                if (!bVar.mPostId.equals(avw2.get(i2).aTo().get(i3).getId())) {
                                    i3++;
                                } else {
                                    avw2.get(i2).aTo().remove(i3);
                                    avw2.get(i2).aTq();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData avE = this.dfV.getPbData().avE();
                        com.baidu.tieba.tbadkCore.data.s sVar = avw2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.data.s> aTr = sVar.aTr();
                        int size3 = aTr.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!bVar.mPostId.equals(avw2.get(i2).aTr().get(i4).getId())) {
                                    i4++;
                                } else {
                                    aTr.remove(i4);
                                    avE.decreaseAlreadyCount();
                                    if (sVar.aTy() > aTr.size()) {
                                        sVar.pu(aTr.size());
                                    }
                                    if (aTr.size() > 0) {
                                        com.baidu.tieba.tbadkCore.data.s sVar2 = aTr.get(aTr.size() - 1);
                                        avE.setLastAdditionTime(sVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a amn = sVar2.amn();
                                        String str = "";
                                        if (amn != null) {
                                            str = amn.toString();
                                        }
                                        avE.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a amn2 = sVar.amn();
                                        String str2 = "";
                                        if (amn2 != null) {
                                            str2 = amn2.toString();
                                        }
                                        avE.setLastAdditionContent(str2);
                                    }
                                    awB();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.dgF.j(this.dfV.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.d dVar) {
        this.dgF.a(1, dVar.AU, dVar.erS, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.f fVar) {
        this.dgF.a(this.dgC.getLoadDataMode(), fVar.AU, fVar.erS, false);
        this.dgF.Y(fVar.erU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, a.f fVar) {
        if (fVar != null) {
            this.dgF.a(this.dgC.getLoadDataMode(), fVar.AU, fVar.erS, true);
            if (fVar.AU) {
                this.dgI = true;
                if (i == 2) {
                    this.dfV.getPbData().avv().bX(1);
                    this.dfV.setIsGood(1);
                } else if (i == 3) {
                    this.dfV.getPbData().avv().bX(0);
                    this.dfV.setIsGood(0);
                } else if (i == 4) {
                    this.dfV.getPbData().avv().bW(1);
                    this.dfV.lX(1);
                } else if (i == 5) {
                    this.dfV.getPbData().avv().bW(0);
                    this.dfV.lX(0);
                }
                this.dgF.a(this.dfV.getPbData(), this.dfV.axe(), true);
            }
        }
    }

    private void awq() {
        if (this.dfV.axf()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.dfV.getThreadID());
            setResult(-1, intent);
        }
        if (aww()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awr() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dgF != null) {
            this.dgF.amI();
        }
        if (this.dfV != null && this.dfV.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.dfV.getPbData().avv().getId();
            historyMessage.forumName = this.dfV.getPbData().avu().getName();
            historyMessage.threadName = this.dfV.getPbData().avv().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.data.s> avw = this.dfV.getPbData().avw();
            int ayM = this.dgF != null ? this.dgF.ayM() : 0;
            if (avw != null && ayM >= 0 && ayM < avw.size()) {
                historyMessage.postID = avw.get(ayM).getId();
            }
            historyMessage.isHostOnly = this.dfV.getHostMode();
            historyMessage.isSquence = this.dfV.axe();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.dfV != null && this.dfV.axf()) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.dfV.getThreadID());
            if (this.dgI) {
                intent.putExtra("type", 2);
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.dfV.axh());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.dfV.getIsGood());
            }
            setResult(-1, intent);
        }
        if (aww()) {
            if (this.dfV != null && this.dgF != null && this.dgF.Mg() != null) {
                com.baidu.tieba.pb.data.e pbData = this.dfV.getPbData();
                if (pbData != null && pbData.getUserData() != null) {
                    pbData.getUserData().setBimg_url(TbadkCoreApplication.m411getInst().getDefaultBubble());
                }
                if (!pbData.avA()) {
                    en.aya().a(this.dfV.getPbData(), this.dgF.Mg().onSaveInstanceState(), this.dfV.axe(), this.dfV.getHostMode());
                }
            } else {
                en.aya().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.dgF != null && this.dgF.ayJ()) {
                    this.dgF.ayL();
                    return true;
                }
                finish();
                break;
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lV(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.dgP.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    awu();
                    return;
                case 13008:
                    en.aya().reset();
                    this.mHandler.postDelayed(new bl(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.dfV != null) {
                        a(awt(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    i(intent);
                    return;
                case 24006:
                    q(intent);
                    return;
                case 24007:
                    if (awo() == 1) {
                        aws();
                        return;
                    }
                    return;
                case 24008:
                    this.dgF.gx(false);
                    break;
                case 25001:
                    break;
                default:
                    return;
            }
            if (this.dgB != null) {
                this.dgB.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && awi() != null && awd() != null && awi().ayl() && com.baidu.tbadk.editortools.d.b.DI().getStatus() == 1) {
                    com.baidu.tbadk.editortools.d.b.DI().setStatus(0);
                    if (this.dgF != null) {
                        this.dgF.ayk();
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
    public void aws() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.dfV.getPbData() != null && this.dfV.getPbData().avv() != null && this.dfV.getPbData().avv().tw() != null && this.dfV.getPbData().avv().tw().size() > 0 && this.dfV.getPbData().avv().tw().get(0) != null) {
            this.mAwardActId = this.dfV.getPbData().avv().tw().get(0).qY();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.h.b.c(this.dfV.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void q(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra("key_action", 0)) {
                case 1:
                    Rf();
                    return;
                case 2:
                    this.dgF.ayw();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData awt() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] aD = this.dfV.getPbData().aD(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.data.s aym = this.dgF.aym();
        String str = "";
        if (aym != null) {
            str = aym.getId();
            String aO = aym.aO(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(aO)) {
                aD[1] = aO;
            }
        }
        String tB = this.dfV.getPbData().avv().tB();
        if (tB != null && tB.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(aD[1]);
        shareFromPBMsgData.setImageUrl(aD[0]);
        shareFromPBMsgData.setForumName(this.dfV.getPbData().avu().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.dfV.getPbData().avv().getId());
        shareFromPBMsgData.setTitle(this.dfV.getPbData().avv().getTitle());
        return shareFromPBMsgData;
    }

    private void i(Intent intent) {
        a(awt(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.dfV != null && this.dfV.getPbData() != null && this.dfV.getPbData().avv() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gn gnVar = new gn(getPageContext().getPageActivity());
            gnVar.setData(shareFromPBMsgData);
            aVar.cc(1);
            aVar.z(gnVar);
            aVar.a(t.j.share, new bm(this, gnVar, j, str, str2, shareFromPBMsgData));
            aVar.b(t.j.alert_no_button, new bn(this, gnVar));
            aVar.an(true);
            aVar.b(getPageContext()).up();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                gnVar.y(shareFromPBMsgData.getImageUrl(), this.dfV.getPbData().avC() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (this.dfV != null && this.dfV.getPbData() != null && this.dfV.getPbData().avv() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            gn gnVar = new gn(getPageContext().getPageActivity());
            gnVar.setData(shareFromPBMsgData);
            aVar.cc(1);
            aVar.z(gnVar);
            aVar.a(t.j.share, new bo(this, gnVar, i, str, j, shareFromPBMsgData));
            aVar.b(t.j.alert_no_button, new bp(this, gnVar));
            aVar.an(true);
            aVar.b(getPageContext()).up();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                gnVar.y(shareFromPBMsgData.getImageUrl(), this.dfV.getPbData().avC() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awu() {
        MarkData me;
        if (this.cOZ != null && (me = this.dfV.me(this.dgF.ayN())) != null) {
            if (!me.isApp() || (me = this.dfV.me(this.dgF.ayN() + 1)) != null) {
                this.dgF.ayE();
                this.cOZ.a(me);
                if (!this.cOZ.pu()) {
                    this.cOZ.pw();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.cOZ.pv();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awv() {
        com.baidu.tieba.pb.data.e pbData = this.dfV.getPbData();
        this.dfV.gd(true);
        pbData.lK(this.cOZ.ps());
        this.dgF.j(pbData);
    }

    private boolean aww() {
        if (this.dfV == null) {
            return true;
        }
        if (this.dfV.pu()) {
            MarkData axp = this.dfV.axp();
            if (axp == null || !this.dfV.getIsFromMark()) {
                return true;
            }
            MarkData me = this.dfV.me(this.dgF.ayN());
            if (me == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, axp);
                setResult(-1, intent);
                return true;
            } else if (me.getPostId() == null || me.getPostId().equals(axp.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, axp);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cC(String.format(getPageContext().getString(t.j.alert_update_mark), Integer.valueOf(me.getFloor())));
                aVar.a(t.j.alert_yes_btn, new bq(this, me, axp, aVar));
                aVar.b(t.j.alert_no_button, new br(this, axp, aVar));
                aVar.a(new bs(this, axp, aVar));
                aVar.b(getPageContext());
                aVar.up();
                return false;
            }
        } else if (this.dfV.getPbData() == null || this.dfV.getPbData().avw() == null || this.dfV.getPbData().avw().size() <= 0 || !this.dfV.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: Mg */
    public BdListView getListView() {
        if (this.dgF == null) {
            return null;
        }
        return this.dgF.Mg();
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public int IN() {
        if (this.dgF == null) {
            return 0;
        }
        return this.dgF.ayT();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int xH() {
        if (this.dgF == null) {
            return 0;
        }
        return this.dgF.RV();
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<ImageView> IO() {
        if (this.aIH == null) {
            this.aIH = new com.baidu.adp.lib.f.b<>(new bu(this), 8, 0);
        }
        return this.aIH;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<TextView> IP() {
        if (this.aII == null) {
            this.aII = TbRichTextView.g(getPageContext().getPageActivity(), 8);
        }
        return this.aII;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<GifView> IQ() {
        if (this.aIM == null) {
            this.aIM = new com.baidu.adp.lib.f.b<>(new bv(this), 20, 0);
        }
        return this.aIM;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> IR() {
        if (this.aIK == null) {
            this.aIK = new com.baidu.adp.lib.f.b<>(new bw(this), 8, 0);
        }
        return this.aIK;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> IT() {
        if (this.aIJ == null) {
            this.aIJ = com.baidu.tieba.graffiti.e.j(getPageContext().getPageActivity(), 6);
        }
        return this.aIJ;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> xI() {
        if (this.ahC == null) {
            this.ahC = UserIconBox.e(getPageContext().getPageActivity(), 8);
        }
        return this.ahC;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void y(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    public boolean lO(String str) {
        Map<String, String> dE;
        if (!TextUtils.isEmpty(str) && (dE = com.baidu.tbadk.core.util.bg.dE(com.baidu.tbadk.core.util.bg.dF(str))) != null) {
            String str2 = dE.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return lO(com.baidu.adp.lib.util.j.aV(str2));
            }
            String str3 = dE.get(dgt);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void z(Context context, String str) {
        M(context, str);
    }

    private void M(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (lQ(str) || z) {
                boolean m = com.baidu.adp.lib.util.k.m(context, "com.qiyi.video");
                lR(str);
                if (m) {
                    awx();
                } else {
                    awy();
                }
            } else if (lO(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else if (lP(str)) {
                com.baidu.tbadk.core.util.bg.wM().a(getPageContext(), new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.bg.wM().c(getPageContext(), new String[]{str});
            }
        }
    }

    private boolean lP(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }

    private boolean lQ(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }

    private void lR(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.dgq = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.dgr = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.bfq = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.dgp = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void awx() {
        if (TextUtils.isEmpty(this.dgq) || TextUtils.isEmpty(this.dgr) || TextUtils.isEmpty(this.mPackageName)) {
            if (!TextUtils.isEmpty(this.dgp)) {
                com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), false, this.dgp);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(this.dgq));
        intent.setAction(this.dgr);
        intent.setPackage(this.mPackageName);
        if (intent.resolveActivity(getPageContext().getPageActivity().getPackageManager()) != null) {
            if (!com.baidu.adp.lib.h.i.b(getPageContext().getPageActivity(), intent) && !TextUtils.isEmpty(this.dgp)) {
                com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), false, this.dgp);
            }
        } else if (!TextUtils.isEmpty(this.dgp)) {
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), false, this.dgp);
        }
    }

    private void awy() {
        if (!com.baidu.adp.lib.util.i.jg()) {
            if (!TextUtils.isEmpty(this.dgp)) {
                com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), false, this.dgp);
                return;
            }
            return;
        }
        if (this.dgo == null) {
            this.dgo = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.dgo.ca(t.j.download_iqiyi_app_dialog);
            this.dgo.a(t.j.install_app, new bx(this));
            this.dgo.b(t.j.webpage_play, new by(this));
            this.dgo.an(false);
        }
        this.dgo.b(getPageContext()).up();
    }

    private com.baidu.tbadk.core.dialog.a awz() {
        if (this.dgv == null) {
            this.dgv = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.dgv.cB(getPageContext().getString(t.j.download_baidu_video_dialog));
            this.dgv.a(getPageContext().getString(t.j.install), new bz(this));
            this.dgv.b(getPageContext().getString(t.j.cancel), new ca(this));
            this.dgv.am(true);
            this.dgv.b(getPageContext());
            this.dgv.an(false);
        }
        this.dgv.up();
        return this.dgv;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void A(Context context, String str) {
        M(context, str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void C(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra("title", "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            awz();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void B(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        com.baidu.tbadk.widget.richText.c cVar;
        int a2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.e pbData = this.dfV.getPbData();
            com.baidu.tbadk.widget.richText.a am = am(str, i);
            if (am != null && (cVar = am.Im().get(this.dhj)) != null) {
                bVar.dhK = new ArrayList<>();
                bVar.dhL = new ConcurrentHashMap<>();
                if (!cVar.Ir().IC()) {
                    bVar.dhN = false;
                    String e = e(cVar);
                    bVar.dhK.add(e);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = c(cVar);
                    imageUrlData.originalSize = d(cVar);
                    imageUrlData.postId = am.getPostId();
                    imageUrlData.mIsReserver = this.dfV.axo();
                    imageUrlData.mIsSeeHost = this.dfV.getHostMode();
                    bVar.dhL.put(e, imageUrlData);
                    if (pbData != null) {
                        if (pbData.avu() != null) {
                            bVar.forumName = pbData.avu().getName();
                            bVar.forumId = pbData.avu().getId();
                        }
                        if (pbData.avv() != null) {
                            bVar.threadId = pbData.avv().getId();
                        }
                        bVar.dhM = pbData.avC() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.dhN = true;
                int size = pbData.avw().size();
                this.dhk = false;
                bVar.index = -1;
                int i2 = i;
                for (int i3 = 0; i3 < size; i3++) {
                    com.baidu.tieba.tbadkCore.data.s sVar = pbData.avw().get(i3);
                    com.baidu.tbadk.widget.richText.a amn = sVar.amn();
                    if (!et.g(sVar)) {
                        a2 = a(amn, am, i2, i, bVar.dhK, bVar.dhL);
                    } else {
                        a2 = a(sVar, i2, bVar.dhK, bVar.dhL);
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> aTr = sVar.aTr();
                    i2 = a2;
                    for (int i4 = 0; i4 < aTr.size(); i4++) {
                        i2 = a(aTr.get(i4).amn(), am, i2, i, bVar.dhK, bVar.dhL);
                    }
                }
                if (bVar.dhK.size() > 0) {
                    bVar.lastId = bVar.dhK.get(bVar.dhK.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.avu() != null) {
                        bVar.forumName = pbData.avu().getName();
                        bVar.forumId = pbData.avu().getId();
                    }
                    if (pbData.avv() != null) {
                        bVar.threadId = pbData.avv().getId();
                    }
                    bVar.dhM = pbData.avC() == 1;
                }
                bVar.index = i2;
            }
        }
    }

    private String c(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.Ir() == null) {
            return null;
        }
        return cVar.Ir().IG();
    }

    private long d(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null || cVar.Ir() == null) {
            return 0L;
        }
        return cVar.Ir().getOriginalSize();
    }

    private int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.g Ir;
        if (aVar == aVar2) {
            this.dhk = true;
        }
        if (aVar != null) {
            int size = aVar.Im().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.Im().get(i6) == null || aVar.Im().get(i6).getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int width = aVar.Im().get(i6).Ir().getWidth();
                    int height = aVar.Im().get(i6).Ir().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.Im().get(i6).Ir().IC()) {
                        if (aVar == aVar2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.Im().get(i6);
                        String e = e(cVar);
                        if (!TextUtils.isEmpty(e)) {
                            arrayList.add(e);
                            if (cVar != null && (Ir = cVar.Ir()) != null) {
                                String IE = Ir.IE();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = IE;
                                int i9 = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.urlType = i9;
                                imageUrlData.urlType = i9;
                                imageUrlData.originalUrl = c(cVar);
                                imageUrlData.originalSize = d(cVar);
                                imageUrlData.postId = aVar.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.h.b.c(this.dfV.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.dfV.axo();
                                imageUrlData.mIsSeeHost = this.dfV.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(e, imageUrlData);
                                }
                            }
                        }
                        if (!this.dhk) {
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
        ArrayList<com.baidu.tieba.tbadkCore.data.k> aSS;
        if (sVar != null && arrayList != null && concurrentHashMap != null && (aSS = sVar.aTC().aSS()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == aSS.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = aSS.get(i3);
                if (kVar != null) {
                    String aSY = kVar.aSY();
                    if (!com.baidu.tbadk.core.util.ay.isEmpty(aSY)) {
                        arrayList.add(aSY);
                        if (!this.dhk) {
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
            if (sVar.getId() != null && sVar.getId().equals(this.dfV.tv())) {
                z = true;
            }
            MarkData e = this.dfV.e(sVar);
            if (e != null) {
                this.dgF.ayE();
                if (this.cOZ != null) {
                    this.cOZ.a(e);
                    if (!z) {
                        this.cOZ.pw();
                    } else {
                        this.cOZ.pv();
                    }
                }
            }
        }
    }

    private com.baidu.tbadk.widget.richText.a am(String str, int i) {
        if (this.dfV == null || this.dfV.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.e pbData = this.dfV.getPbData();
        com.baidu.tbadk.widget.richText.a a2 = a(pbData.avw(), str, i);
        if (a2 == null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.s> avw = pbData.avw();
            int size = avw.size();
            for (int i2 = 0; i2 < size; i2++) {
                a2 = a(avw.get(i2).aTr(), str, i);
                if (a2 != null) {
                    return a2;
                }
            }
            return a2;
        }
        return a2;
    }

    private long lS(String str) {
        ArrayList<com.baidu.tieba.tbadkCore.data.s> avw;
        com.baidu.tieba.pb.data.e pbData = this.dfV.getPbData();
        if (pbData != null && (avw = pbData.avw()) != null && !avw.isEmpty()) {
            Iterator<com.baidu.tieba.tbadkCore.data.s> it = avw.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.s next = it.next();
                com.baidu.tieba.tbadkCore.data.i aTC = next.aTC();
                if (aTC != null && aTC.epn) {
                    Iterator<com.baidu.tbadk.widget.richText.c> it2 = next.amn().Im().iterator();
                    while (it2.hasNext()) {
                        com.baidu.tbadk.widget.richText.c next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.Iz().getLink().equals(str)) {
                            return aTC.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> Im;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a amn = arrayList.get(i2).amn();
            if (amn != null && (Im = amn.Im()) != null) {
                int size = Im.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Im.get(i4) != null && Im.get(i4).getType() == 8) {
                        i3++;
                        if (Im.get(i4).Ir().IE().equals(str)) {
                            int width = Im.get(i4).Ir().getWidth();
                            int height = Im.get(i4).Ir().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.dhj = i4;
                            return amn;
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

    private String e(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        com.baidu.tbadk.widget.richText.g Ir = cVar.Ir();
        if (Ir != null) {
            if (!StringUtils.isNull(Ir.IB())) {
                return Ir.IB();
            }
            if (Ir.getHeight() * Ir.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Ir.getHeight() * Ir.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Ir.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Ir.getHeight())));
            } else {
                float width = Ir.getWidth() / Ir.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.ay.aU(Ir.getSrc()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void d(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.dfD = str;
            if (this.dgu == null) {
                awm();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.dgu.ch(1).setVisibility(8);
            } else {
                this.dgu.ch(1).setVisibility(0);
            }
            this.dgu.us();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bja;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amr() {
        hideNetRefreshView(this.dgF.getView());
        awA();
        if (this.dfV.FG()) {
            this.dgF.ayE();
        }
    }

    private void awA() {
        showLoadingView(this.dgF.getView());
        View Fg = getLoadingView().Fg();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Fg.getLayoutParams();
        layoutParams.addRule(3, this.dgF.azm().getId());
        Fg.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qn() {
        if (this.bja != null) {
            this.bja.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rf() {
        if (this.dfV.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.e pbData = this.dfV.getPbData();
            String name = pbData.avu().getName();
            String title = pbData.avv().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.dfV.getThreadID() + "?share=9105&fr=share";
            String[] aD = pbData.aD(getPageContext().getPageActivity());
            String str2 = aD[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = aD[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (awo() == 1) {
                if (pbData != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10399").ac("fid", pbData.getForumId()).ac("tid", pbData.getThreadId()).ac("uid", currentAccount));
                }
            } else if (awo() == 2 && pbData != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10406").ac("fid", pbData.getForumId()).ac("tid", pbData.getThreadId()).ac("uid", currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(t.j.share_content_tpl), title, name, str3);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.linkUrl = str;
            fVar.amX = true;
            fVar.extData = this.dfV.getThreadID();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(t.j.share_tieba_qunzu, t.f.icon_unite_share_qunzu, new cb(this));
            shareDialogConfig.addOutsideTextView(t.j.forum_friend, t.f.icon_unite_share_baf, new cc(this));
            shareDialogConfig.setCopyLinkListener(new cd(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<LinearLayout> IS() {
        if (this.aIL == null) {
            this.aIL = new com.baidu.adp.lib.f.b<>(new cf(this), 15, 0);
        }
        return this.aIL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awB() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.pb.data.e pbData = this.dfV.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.sf().isIfAddition();
            AdditionData avE = pbData.avE();
            boolean z3 = avE == null ? false : isIfAddition;
            if (z3) {
                z = avE.getAlreadyCount() != avE.getTotalCount();
                if (!TextUtils.isEmpty(avE.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.pb.main.b.e eVar = this.dgF.dkF;
            if (!z3 || !z) {
                z2 = false;
            }
            eVar.gz(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.dgF.ayx() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10517").r("obj_locate", 2).ac("fid", this.dfV.getPbData().getForumId()));
            } else {
                com.baidu.tbadk.core.data.as avv = this.dfV.getPbData().avv();
                if (view != null) {
                    boolean z = avv.getPraise() == null || avv.getPraise().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.bjp > 1000) {
                            this.bjq = true;
                            X(view);
                        } else {
                            this.bjq = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            e(view, this.bjq);
                        } else {
                            d(view, this.bjq);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        d(view, this.bjq);
                    } else if (motionEvent.getAction() == 3) {
                        d(view, this.bjq);
                    }
                }
            }
        }
        return false;
    }

    private void d(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), t.a.praise_animation_scale2));
            new Handler().postDelayed(new cg(this), 200L);
        }
    }

    private void e(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), t.a.praise_animation_scale3));
            new Handler().postDelayed(new ch(this), 600L);
        }
    }

    private void X(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), t.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void QY() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, 11017)));
        } else if (aVar.ur() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.ur();
            int intValue = ((Integer) sparseArray.get(eu.dmq)).intValue();
            if (intValue == eu.dmr) {
                if (!this.dgC.aUn()) {
                    this.dgF.ayB();
                    int intValue2 = ((Integer) sparseArray.get(t.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(t.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(t.g.tag_del_post_type)).intValue();
                    this.dgC.a(this.dfV.getPbData().avu().getId(), this.dfV.getPbData().avu().getName(), this.dfV.getPbData().avv().getId(), (String) sparseArray.get(t.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == eu.dms || intValue == eu.dmu) {
                this.dfV.mf(df.djr);
                if (intValue == eu.dms) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == eu.dmt) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.dhn).qT()));
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
        this.dgD.a(z, str, str2, str3, str4, UserMuteAddAndDelModel.From.PB, str5);
    }

    private boolean lT(String str) {
        String string;
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bl.ad(getPageContext().getPageActivity())) {
            if (StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.vk().getString("bubble_link", ""))) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(t.j.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void fX(boolean z) {
        this.dgN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String awC() {
        ArrayList<com.baidu.tieba.tbadkCore.data.s> avw;
        int p;
        if (this.dfV == null || this.dfV.getPbData() == null || this.dfV.getPbData().avw() == null || (p = com.baidu.tbadk.core.util.y.p((avw = this.dfV.getPbData().avw()))) == 0) {
            return "";
        }
        int ayM = this.dgF.ayM();
        com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.b(avw, ayM);
        if (sVar == null || sVar.getAuthor() == null) {
            return "";
        }
        if (this.dfV.lY(sVar.getAuthor().getUserId())) {
            return sVar.getId();
        }
        for (int i = ayM - 1; i != 0; i--) {
            com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.b(avw, i);
            if (sVar2 == null || sVar2.getAuthor() == null || sVar2.getAuthor().getUserId() == null) {
                break;
            } else if (this.dfV.lY(sVar2.getAuthor().getUserId())) {
                return sVar2.getId();
            }
        }
        for (int i2 = ayM + 1; i2 < p; i2++) {
            com.baidu.tieba.tbadkCore.data.s sVar3 = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.b(avw, i2);
            if (sVar3 == null || sVar3.getAuthor() == null || sVar3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.dfV.lY(sVar3.getAuthor().getUserId())) {
                return sVar3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void D(Context context, String str) {
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bg.wM().c(getPageContext(), new String[]{str})) {
            com.baidu.tieba.pb.b.a(lS(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.dfV.getPbData().avu().getId(), this.dfV.getPbData().avu().getName(), this.dfV.getPbData().avv().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, String str2, String str3, String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cC(getResources().getString(t.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cC(getResources().getString(t.j.make_sure_hide));
        }
        aVar.a(getResources().getString(t.j.alert_yes_button), new ci(this, j, str, str2, str3, str4));
        aVar.b(getResources().getString(t.j.alert_no_button), new cj(this, j, str, str2, str3, str4));
        aVar.an(false);
        aVar.b(getPageContext());
        aVar.up();
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
        if (this.dfV.getPbData() == null || this.dfV.getPbData().avw() == null || this.dfV.getPbData().avw().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i < this.dfV.getPbData().avw().size()) {
                if (str.equals(this.dfV.getPbData().avw().get(i).getId())) {
                    break;
                }
                i++;
            } else {
                i = 0;
                break;
            }
        }
        com.baidu.tieba.tbadkCore.data.s sVar = this.dfV.getPbData().avw().get(i);
        if (sVar.amn() == null || sVar.amn().Im() == null) {
            return null;
        }
        Iterator<com.baidu.tbadk.widget.richText.c> it = sVar.amn().Im().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.Ir() != null) {
                    str2 = next.Ir().IE();
                }
            }
        }
        a(str2, 0, bVar);
        a(sVar, bVar);
        return bVar;
    }

    private void a(com.baidu.tieba.tbadkCore.data.s sVar, b bVar) {
        if (sVar != null && sVar.amn() != null && sVar.amn().Im() != null && bVar != null && bVar.dhK != null && bVar.dhL != null && sVar.amn().Im().size() != 0) {
            String str = (String) com.baidu.tbadk.core.util.y.b(bVar.dhK, bVar.index);
            if (!StringUtils.isNull(str)) {
                bVar.dhK = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.dhL;
                bVar.dhL = new ConcurrentHashMap<>();
                Iterator<com.baidu.tbadk.widget.richText.c> it = sVar.amn().Im().iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null && next.getType() == 8) {
                        String e = e(next);
                        if (!StringUtils.isNull(e) && concurrentHashMap.get(e) != null) {
                            bVar.dhK.add(e);
                            bVar.dhL.put(e, concurrentHashMap.get(e));
                        }
                    }
                }
                bVar.index = com.baidu.tbadk.core.util.y.a(bVar.dhK, str);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.dgm) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.dgm = false;
        } else if (awE()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.dgm) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.dgm = false;
        } else if (awE()) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public boolean awD() {
        return this.dgQ;
    }

    public void fY(boolean z) {
        this.dgQ = z;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a005";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.dfV != null) {
            if (this.dfV.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(this.dfV.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.h.b.c(this.dfV.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean awE() {
        return (!this.dgk && this.dhp == -1 && this.dhq == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.k kVar) {
        if (kVar != null) {
            this.dhs = kVar;
            this.dgk = true;
            this.dgF.ayn();
            this.dgF.md(this.dhr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awF() {
        if (this.dhs != null) {
            if (this.dhp == -1) {
                showToast(t.j.pb_manga_not_prev_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.dhs.getCartoonId(), this.dhp, 0)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awG() {
        if (this.dhs != null) {
            if (this.dhq == -1) {
                showToast(t.j.pb_manga_not_next_exist);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.dhs.getCartoonId(), this.dhq, 0)));
            finish();
        }
    }

    public int awH() {
        return this.dhp;
    }

    public int awI() {
        return this.dhq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awJ() {
        if (this.dfV != null && this.dfV.getPbData() != null && this.dfV.getPbData().avv() != null && this.dfV.getPbData().avv().tO()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }
}
