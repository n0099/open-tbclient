package com.baidu.tieba.pb.main;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, com.baidu.tbadk.core.view.ar, com.baidu.tbadk.core.voice.o, com.baidu.tbadk.widget.richText.j, com.baidu.tieba.tbadkCore.am {
    private static String byC = "tbgametype";
    private com.baidu.adp.lib.e.b<TbImageView> Ny;
    private boolean ZD;
    private com.baidu.tieba.tbadkCore.location.d aAD;
    private String aAI;
    private com.baidu.adp.lib.e.b<ImageView> ajD;
    private com.baidu.adp.lib.e.b<TextView> ajE;
    private com.baidu.adp.lib.e.b<View> ajF;
    private com.baidu.adp.lib.e.b<LinearLayout> ajG;
    private com.baidu.adp.lib.e.b<GifView> ajH;
    private AlertDialog byE;
    private VoiceData.VoiceModel byF;
    private String byU;
    private String mPhoneNumber;
    private String mPostContent;
    private VoiceManager mVoiceManager;
    private boolean aqe = false;
    private boolean aBJ = true;
    private boolean byw = false;
    private com.baidu.tbadk.core.dialog.a byx = null;
    private String byy = null;
    private String mDownloadUrl = null;
    private String byz = null;
    private String byA = null;
    private String mPackageName = null;
    private int byB = 0;
    private com.baidu.tbadk.core.dialog.i byD = null;
    SparseArray<String> aJa = null;
    private long aCo = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private WriteData aCr = new WriteData();
    private long agu = 0;
    private long createTime = 0;
    private long agv = 0;
    private boolean byG = false;
    private com.baidu.tbadk.performanceLog.h byH = null;
    public long aCy = System.currentTimeMillis();
    private String byI = null;
    private final Handler mHandler = new Handler(new b(this));
    private bq byJ = null;
    private com.baidu.tbadk.baseEditMark.e byK = null;
    private com.baidu.tieba.tbadkCore.f.a aAK = null;
    private com.baidu.tieba.model.m byL = null;
    private com.baidu.tieba.pb.sub.e byM = null;
    private com.baidu.tieba.tbadkCore.e.a byN = null;
    private bz byO = null;
    public final com.baidu.tieba.pb.main.a.a byP = new com.baidu.tieba.pb.main.a.a(this);
    private boolean byQ = false;
    private boolean byR = false;
    private MorePopupWindow byS = null;
    private by byT = null;
    private boolean aBL = false;
    private com.baidu.tieba.tbadkCore.location.i aAO = new ai(this);
    private com.baidu.tieba.tbadkCore.location.j aAP = new at(this);
    private boolean aAE = false;
    private com.baidu.tieba.tbadkCore.ao aAT = new com.baidu.tieba.tbadkCore.ao(getPageContext(), new bb(this));
    private long praiseStopTime = 0;
    private boolean isPraiseToServer = true;
    public final View.OnClickListener aEH = new bc(this);
    private final bt byV = new be(this);
    private final com.baidu.tbadk.baseEditMark.g byW = new bf(this);
    private final AbsListView.OnScrollListener wT = new c(this);
    private final AbsListView.OnScrollListener byX = new d(this);
    private final com.baidu.tieba.pb.sub.g byY = new e(this);
    private final com.baidu.tieba.tbadkCore.f.c aCB = new f(this);
    private final com.baidu.adp.base.i byZ = new g(this);
    private final bh bza = new h(this);
    private final com.baidu.adp.widget.ListView.g aSr = new i(this);
    private final com.baidu.adp.widget.ListView.ab bzb = new j(this);
    private final com.baidu.adp.widget.ListView.ae bzc = new k(this);
    private final DialogInterface.OnClickListener bet = new l(this);
    private final com.baidu.adp.base.i bzd = new n(this);
    private AlertDialog aAR = null;
    private final da bze = new o(this);
    private int bzf = 0;
    private final com.baidu.tbadk.widget.richText.s ajW = new p(this);
    boolean bzg = false;
    com.baidu.tieba.tbadkCore.b.k bzh = null;
    private final DialogInterface.OnClickListener bzi = new q(this);
    private final View.OnLongClickListener TL = new r(this);
    private final com.baidu.tbadk.core.view.ad aCN = new s(this);
    com.baidu.tbadk.coreExtra.share.d aIX = null;

    static {
        Je();
        Ww();
        CustomMessageTask customMessageTask = new CustomMessageTask(2004001, new m());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2004005, new x());
        customMessageTask2.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        Wx();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m255getInst().isGpuOpen();
    }

    private static void Je() {
        com.baidu.tieba.tbadkCore.a.a.a(302001, pbPageSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.O("c/f/pb/page", 302001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.location.d.ahE();
    }

    private static void Ww() {
        com.baidu.tieba.tbadkCore.a.a.b(2004003, db.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EQ() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void ER() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.z.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m255getInst().getLocationShared()) {
            ES();
        } else if (this.aAD.ahD()) {
            EQ();
        } else {
            this.aAD.ex(false);
            if (this.byO.Fh() != null) {
                this.byO.Fh().setLocationViewVisibility(0);
                this.byO.Fh().setLocationInfoViewState(1);
            }
            this.aAD.ahB();
        }
    }

    private void ES() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bt(com.baidu.tieba.z.location_app_permission_prompt).a(com.baidu.tieba.z.isopen, new t(this)).b(com.baidu.tieba.z.cancel, new u(this)).b(getPageContext());
        aVar.nU();
    }

    public void ET() {
        if (this.byO.Fh() != null) {
            if (this.aAD.ahF()) {
                this.byO.Fh().setLocationViewVisibility(0);
                if (this.aAD.ahD()) {
                    this.aAO.a(com.baidu.tieba.tbadkCore.location.c.ahy().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.l.isNetOk()) {
                    this.byO.Fh().setLocationInfoViewState(1);
                    this.aAD.ahB();
                    return;
                } else {
                    this.byO.Fh().setLocationInfoViewState(0);
                    return;
                }
            }
            this.byO.Fh().setLocationViewVisibility(8);
        }
    }

    private static void Wx() {
        com.baidu.tbadk.core.util.bh.pK().a(new v());
    }

    private void Wy() {
        this.byO.Yo();
        this.byO.XN();
    }

    private void Wz() {
        this.byO.Yp();
        this.byO.XP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WA() {
        com.baidu.tieba.tbadkCore.b.i pbData;
        com.baidu.tbadk.core.data.w agE;
        if (!this.aAE) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                showToast(com.baidu.tieba.z.no_network_guide);
            } else if (this.isPraiseToServer) {
                this.aAE = true;
                if (this.byJ != null && (pbData = this.byJ.getPbData()) != null && (agE = pbData.agE()) != null) {
                    int isLike = agE.getPraise() == null ? 0 : agE.getPraise().getIsLike();
                    if (this.aAT != null) {
                        this.aAT.a(agE.nD(), agE.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eB(int i) {
        com.baidu.tbadk.core.data.w agE;
        String sb;
        String p;
        if (this.byJ != null && this.byJ.getPbData() != null && (agE = this.byJ.getPbData().agE()) != null) {
            if (i == 1) {
                PraiseData praise = agE.getPraise();
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
                        agE.setPraise(praiseData);
                    } else {
                        agE.getPraise().getUser().add(0, metaData);
                        agE.getPraise().setNum(agE.getPraise().getNum() + 1);
                        agE.getPraise().setIsLike(i);
                    }
                }
                if (agE.getPraise() != null) {
                    if (agE.getPraise().getNum() < 1) {
                        p = getResources().getString(com.baidu.tieba.z.frs_item_praise_text);
                    } else {
                        p = com.baidu.tbadk.core.util.ba.p(agE.getPraise().getNum());
                    }
                    this.byO.z(p, true);
                }
            } else if (agE.getPraise() != null) {
                agE.getPraise().setIsLike(i);
                agE.getPraise().setNum(agE.getPraise().getNum() - 1);
                ArrayList<MetaData> user = agE.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            agE.getPraise().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (agE.getPraise().getNum() < 1) {
                    sb = getResources().getString(com.baidu.tieba.z.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(agE.getPraise().getNum())).toString();
                }
                this.byO.z(sb, false);
            }
            if (this.byJ.Xg()) {
                this.byO.XT().notifyDataSetChanged();
            } else {
                this.byO.f(this.byJ.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.byJ.saveToBundle(bundle);
        if (this.byJ.Xj()) {
            this.byM.saveToBundle(bundle);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aAI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.aCo = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aCo = System.currentTimeMillis();
        }
        this.byB = 0;
        initUI();
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initData(bundle);
        addGlobalLayoutListener();
        this.createTime = System.currentTimeMillis() - this.aCo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.byO != null) {
            if (this.byO.Fh() != null) {
                this.byO.Fh().afl();
            }
            if (this.byO.XO() != null && this.byO.XO().Fh() != null) {
                this.byO.XO().Fh().afl();
            }
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStart(getPageContext());
        }
    }

    public bq WB() {
        return this.byJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.aqe = true;
        super.onPause();
        BdListView listView = getListView();
        this.byB = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.byB == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
        if (this.byO != null) {
            this.byO.onPause();
        }
        if (!this.byJ.Xj()) {
            WriteData EV = this.aAK.EV();
            if (EV == null) {
                EV = new WriteData(1);
                EV.setThreadId(this.byJ.Xf());
                EV.setWriteImagesInfo(this.writeImagesInfo);
            }
            EV.setContent(this.byO.Fo());
            if (this.aCr != null && this.aCr.getIsBaobao()) {
                EV.setBaobaoContent(this.aCr.getBaobaoContent());
                EV.setBaobaoImagesInfo(this.baobaoImagesInfo);
                EV.setIsBaobao(true);
            }
            com.baidu.tieba.tbadkCore.al.b(this.byJ.Xf(), EV);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        this.aqe = false;
        super.onResume();
        if (this.byB == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView XG = this.byO.XG();
        if (XG != null && XG.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            XG.aq(false);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
        if (this.byO.Fh() != null) {
            this.byO.Fh().refresh();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!com.baidu.tbadk.core.util.ba.isEmpty(writeData.getContent()) && com.baidu.tbadk.core.util.ba.isEmpty(this.byO.Fo())) {
                this.mPostContent = writeData.getContent();
                this.byO.fx(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                this.byO.a(this.writeImagesInfo, true);
            }
            if (TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.aCr.setIsBaobao(writeData.getIsBaobao());
                this.aCr.setBaobaoContent(writeData.getBaobaoContent());
                this.aCr.setBaobaoImagesInfo(this.baobaoImagesInfo);
                this.byO.setBaobaoUris(this.baobaoImagesInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.byO.Fh() != null && this.byO.Fh().getVisibility() != 0) {
            WD();
            this.byO.XJ();
        }
        if (!this.byO.Yj()) {
            this.byO.Yl();
        }
        this.byO.bBo.YS();
        if (this.byJ != null && this.byJ.getPbData() != null && this.byJ.getPbData().aej() != null && this.byJ.getPbData().agE() != null) {
            com.baidu.tbadk.distribute.a.uD().a(getPageContext().getPageActivity(), "pb", this.byJ.getPbData().aej().getId(), com.baidu.adp.lib.g.c.a(this.byJ.getPbData().agE().getId(), 0L));
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (!this.byG) {
            this.byG = true;
            this.byO.YL();
        }
        this.byJ.cancelLoadData();
        this.byJ.destory();
        this.aAK.cancelLoadData();
        this.byL.cancelLoadData();
        this.aAD.cancelLoadData();
        this.byM.cancelLoadData();
        this.byM.destory();
        this.byN.cancelLoadData();
        this.byO.onDestroy();
        if (this.byH != null) {
            this.byH.onDestroy();
        }
        super.onDestroy();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
    }

    public void WC() {
        if (this.byO.Fh() != null) {
            this.byO.Fh().setContent(this.mPostContent == null ? "" : this.mPostContent);
            if (this.byF != null) {
                this.byO.Fh().afv();
            }
            this.byO.a(this.writeImagesInfo, true);
            this.byO.setBaobaoUris(this.baobaoImagesInfo);
            if (!StringUtils.isNull(this.mPostContent) || this.byF != null) {
                this.byO.Fh().afB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WD() {
        if (this.byO.Fh() != null) {
            this.mPostContent = this.byO.Fh().getContent();
            this.byF = this.byO.getAudioData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.byO.onChangeSkinType(i);
        if (this.byS != null) {
            this.byS.onChangeSkinType(this, i, com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.bg_collect));
        }
        if (this.byO.XG() != null) {
            this.byO.XG().onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WE() {
        this.byT = new by(this, this.aEH);
        this.byS = new MorePopupWindow(getPageContext().getPageActivity(), this.byT.getView(), getResources().getDrawable(com.baidu.tieba.v.bg_collect), null);
        this.byS.setTouchInterceptor(new w(this));
        this.byS.onChangeSkinType(this, TbadkCoreApplication.m255getInst().getSkinType(), com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.bg_collect));
    }

    private void initUI() {
        this.byO = new bz(this, this.aEH);
        this.byO.setOnActionListener(new y(this));
        this.byO.setOnScrollListener(this.wT);
        this.byO.a(this.byX);
        this.byO.c(this.bzb);
        this.byO.a(this.bzc);
        this.byO.b(this.bet);
        this.byO.a(this.aSr);
        this.byO.dI(com.baidu.tbadk.core.l.mc().mg());
        this.byO.dJ(com.baidu.tbadk.core.l.mc().me());
        this.byO.setOnImageClickListener(this.ajW);
        this.byO.b(this.TL);
        this.byO.a(this.bze);
        this.byO.f(this.aCN);
        this.byO.a(this.bza);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.byO != null) {
            if (z && !this.byw) {
                if (this.aBJ) {
                    this.aBJ = false;
                    showLoadingView(this.byO.getView(), true);
                    return;
                }
                return;
            }
            hideLoadingView(this.byO.getView());
        }
    }

    private void WF() {
        if (this.byD == null) {
            this.byD = new com.baidu.tbadk.core.dialog.i(getPageContext().getPageActivity());
            this.byD.a(new Object[]{getPageContext().getString(com.baidu.tieba.z.call_phone), getPageContext().getString(com.baidu.tieba.z.sms_phone), getPageContext().getString(com.baidu.tieba.z.search_in_baidu)}, new z(this)).bz(com.baidu.tbadk.core.dialog.k.FR).bA(80).e(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        this.byJ = new bq(this);
        this.byJ.a(this.byV);
        this.byK = new com.baidu.tbadk.baseEditMark.e(this);
        this.byK.a(this.byW);
        this.aAK = new com.baidu.tieba.tbadkCore.f.a(this);
        this.aAK.a(this.aCB);
        this.byL = new com.baidu.tieba.model.m(this);
        this.byL.setLoadDataCallBack(this.bzd);
        this.byM = new com.baidu.tieba.pb.sub.e(this);
        this.byM.a(this.byY);
        this.byN = new com.baidu.tieba.tbadkCore.e.a(this);
        this.byN.setLoadDataCallBack(this.byZ);
        this.aAD = new com.baidu.tieba.tbadkCore.location.d(this);
        this.aAD.a(this.aAO);
        this.aAD.a(this.aAP);
        if (bundle != null) {
            this.byJ.initWithBundle(bundle);
        } else {
            this.byJ.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, -1) == 18003) {
            this.byJ.dN(true);
        }
        bv.Xz().y(this.byJ.Xd(), this.byJ.getIsFromMark());
        if (!this.byJ.Xj()) {
            this.byO.Ya();
            this.byJ.xv();
        } else {
            if (bundle != null) {
                this.byM.initWithBundle(bundle);
            } else {
                this.byM.initWithIntent(getIntent());
            }
            this.byU = this.byM.lt();
            String stType = this.byM.getStType();
            if (stType != null && (("mention".equals(this.byM.getStType()) || stType.equals("person_post_reply")) && this.byU != null)) {
                this.byO.Yn();
            } else {
                this.byO.Yg();
            }
            this.byM.Zm();
        }
        this.byO.a(new aa(this));
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aAI = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!this.byJ.Xj()) {
            com.baidu.tieba.tbadkCore.al.a(this.byJ.Xf(), this);
        }
        this.aAT.setUniqueId(getUniqueId());
        this.aAT.registerListener();
    }

    public void WG() {
        this.byO.bBo.f(this.byJ.Xg(), this.byK.li());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.tbadkCore.b.k kVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (kVar = (com.baidu.tieba.tbadkCore.b.k) sparseArray.get(com.baidu.tieba.w.tag_clip_board)) != null) {
            a(kVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        WR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Boolean bool) {
        com.baidu.tieba.tbadkCore.b.i pbData;
        String str = null;
        if (this.byJ != null && (pbData = this.byJ.getPbData()) != null && pbData.aej() != null) {
            str = pbData.aej().getName();
        }
        if (com.baidu.tieba.tbadkCore.aa.b(str, bool)) {
            Wz();
        } else {
            Wy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Boolean bool) {
        if (com.baidu.tieba.tbadkCore.aa.b(str, bool)) {
            Wz();
        } else {
            Wy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, com.baidu.tieba.tbadkCore.f.f fVar) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            if (!this.byJ.Xj()) {
                antiData.setBlock_forum_name(this.byJ.getPbData().aej().getName());
                antiData.setBlock_forum_id(this.byJ.getPbData().aej().getId());
                antiData.setUser_name(this.byJ.getPbData().getUserData().getUserName());
                antiData.setUser_id(this.byJ.getPbData().getUserData().getUserId());
            } else {
                antiData.setBlock_forum_name(this.byM.Zh().ahg().getName());
                antiData.setBlock_forum_id(this.byM.Zh().ahg().getId());
                antiData.setUser_name(TbadkCoreApplication.getCurrentAccountName());
                antiData.setUser_id(TbadkCoreApplication.getCurrentAccount());
            }
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.tieba.tbadkCore.f.g.d(getPageContext().getPageActivity(), fVar.getErrorString(), fVar.aie(), fVar.aif());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            if (!this.byJ.Xj()) {
                antiData.setBlock_forum_name(this.byJ.getPbData().aej().getName());
                antiData.setBlock_forum_id(this.byJ.getPbData().aej().getId());
                antiData.setUser_name(this.byJ.getPbData().getUserData().getUserName());
                antiData.setUser_id(this.byJ.getPbData().getUserData().getUserId());
            } else {
                antiData.setBlock_forum_name(this.byM.Zh().ahg().getName());
                antiData.setBlock_forum_id(this.byM.Zh().ahg().getId());
                antiData.setUser_name(TbadkCoreApplication.getCurrentAccountName());
                antiData.setUser_id(TbadkCoreApplication.getCurrentAccount());
            }
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        this.byO.showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.e.c cVar) {
        int i = 0;
        if (cVar != null) {
            this.byO.a(0, cVar.pW, cVar.bYH, true);
            if (cVar.pW) {
                if (cVar.bYF == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.b.k> agF = this.byJ.getPbData().agF();
                    int size = agF.size();
                    while (true) {
                        if (i < size) {
                            if (!cVar.mPostId.equals(agF.get(i).getId())) {
                                i++;
                            } else {
                                agF.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.byO.e(this.byJ.getPbData());
                } else if (cVar.bYF == 0) {
                    WH();
                } else if (cVar.bYF == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.b.k> agF2 = this.byJ.getPbData().agF();
                    int size2 = agF2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < agF2.get(i2).agQ().size()) {
                                if (!cVar.mPostId.equals(agF2.get(i2).agQ().get(i3).getId())) {
                                    i3++;
                                } else {
                                    agF2.get(i2).agQ().remove(i3);
                                    agF2.get(i2).agR();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData agH = this.byJ.getPbData().agH();
                        com.baidu.tieba.tbadkCore.b.k kVar = agF2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.b.k> agS = kVar.agS();
                        int size3 = agS.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!cVar.mPostId.equals(agF2.get(i2).agS().get(i4).getId())) {
                                    i4++;
                                } else {
                                    agS.remove(i4);
                                    agH.decreaseAlreadyCount();
                                    if (kVar.agZ() > agS.size()) {
                                        kVar.hP(agS.size());
                                    }
                                    if (agS.size() > 0) {
                                        com.baidu.tieba.tbadkCore.b.k kVar2 = agS.get(agS.size() - 1);
                                        agH.setLastAdditionTime(kVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a agU = kVar2.agU();
                                        String str = "";
                                        if (agU != null) {
                                            str = agU.toString();
                                        }
                                        agH.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a agU2 = kVar.agU();
                                        String str2 = "";
                                        if (agU2 != null) {
                                            str2 = agU2.toString();
                                        }
                                        agH.setLastAdditionContent(str2);
                                    }
                                    WS();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.byO.e(this.byJ.getPbData());
                    }
                    if (this.byO.Yj()) {
                        this.byM.hA(cVar.mPostId);
                        this.byO.a(this.byM.Zh(), this.byJ.getPbData().agG());
                        if (!z) {
                            String lt = this.byM.lt();
                            while (i < size2) {
                                if (!lt.equals(agF2.get(i).getId())) {
                                    i++;
                                } else {
                                    agF2.get(i).agR();
                                    this.byO.e(this.byJ.getPbData());
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.e.e eVar) {
        this.byO.a(1, eVar.pW, eVar.bYH, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.e.g gVar) {
        this.byO.a(this.byN.getLoadDataMode(), gVar.pW, gVar.bYH, false);
        this.byO.H(gVar.bYJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.tbadkCore.e.g gVar) {
        if (gVar != null) {
            this.byO.a(this.byN.getLoadDataMode(), gVar.pW, gVar.bYH, true);
            if (gVar.pW) {
                this.byR = true;
                if (i == 2) {
                    this.byJ.getPbData().agE().bq(1);
                    this.byJ.setIsGood(1);
                } else if (i == 3) {
                    this.byJ.getPbData().agE().bq(0);
                    this.byJ.setIsGood(0);
                } else if (i == 4) {
                    this.byJ.getPbData().agE().bp(1);
                    this.byJ.gQ(1);
                } else if (i == 5) {
                    this.byJ.getPbData().agE().bp(0);
                    this.byJ.gQ(0);
                }
                this.byO.a(this.byJ.getPbData(), this.byJ.Xg(), true);
            }
        }
    }

    private void WH() {
        if (this.byJ.Xh()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.byJ.Xf());
            setResult(-1, intent);
        }
        if (WN()) {
            super.closeActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WI() {
        super.closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        this.byO.YE();
        if (this.byJ != null && this.byJ.getPbData() != null) {
            com.baidu.tbadk.b.a aVar = new com.baidu.tbadk.b.a(this);
            com.baidu.tbadk.b.b bVar = new com.baidu.tbadk.b.b();
            bVar.setThreadId(this.byJ.getPbData().agE().getId());
            bVar.setForumName(this.byJ.getPbData().aej().getName());
            bVar.bF(this.byJ.getPbData().agE().getTitle());
            ArrayList<com.baidu.tieba.tbadkCore.b.k> agF = this.byJ.getPbData().agF();
            int Yr = this.byO.Yr();
            if (agF != null && Yr >= 0 && Yr < agF.size()) {
                bVar.bG(agF.get(Yr).getId());
            }
            bVar.Z(this.byJ.getHostMode());
            bVar.aa(this.byJ.Xg());
            aVar.a((com.baidu.tbadk.b.a) bVar);
        }
        if (this.byJ != null && this.byJ.Xh()) {
            Intent intent = new Intent();
            if (this.byR) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.byJ.Xf());
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.byJ.Xi());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.byJ.getIsGood());
            }
            setResult(-1, intent);
        }
        if (WN()) {
            if (this.byJ != null && this.byO != null && this.byO.getListView() != null) {
                com.baidu.tieba.tbadkCore.b.i pbData = this.byJ.getPbData();
                if (pbData != null && pbData.getUserData() != null) {
                    pbData.getUserData().setBimg_url(TbadkCoreApplication.m255getInst().getDefaultBubble());
                }
                bv.Xz().a(this.byJ.getPbData(), this.byO.getListView().onSaveInstanceState(), this.byJ.Xg(), this.byJ.getHostMode());
            } else {
                bv.Xz().reset();
            }
            super.closeActivity();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.byS != null) {
                    com.baidu.adp.lib.g.k.a(this.byS, getPageContext().getPageActivity());
                }
                if (this.byO.dU(this.byJ.Xj())) {
                    stopVoice();
                    return true;
                }
                closeActivity();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean gP(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int size;
        int size2;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    fs(null);
                    return;
                case 11009:
                    WL();
                    return;
                case LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_11_025 /* 11025 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(getPageContext().getPageActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(getPageContext().getPageActivity(), 12005, true)));
                    return;
                case 11027:
                    fs(this.byO.Yt());
                    return;
                case 12001:
                    L(intent);
                    if (this.writeImagesInfo != null && this.writeImagesInfo.size() - 1 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size2 = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
                        return;
                    }
                    return;
                case 12002:
                    J(intent);
                    return;
                case 12003:
                    if (intent != null) {
                        WK();
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            this.byO.Yq();
                            this.aAK.ey(false);
                            return;
                        }
                        this.byL.hq(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    WK();
                    ArrayList<String> T = com.baidu.tieba.tbadkCore.util.i.T(intent);
                    if (T != null) {
                        this.byO.z(T);
                        return;
                    }
                    return;
                case 12005:
                    WK();
                    new Handler().postDelayed(new ab(this), 200L);
                    ArrayList<String> T2 = com.baidu.tieba.tbadkCore.util.i.T(intent);
                    if (T2 != null) {
                        this.byO.I(T2);
                        return;
                    }
                    return;
                case 12006:
                    WriteData EV = this.aAK.EV();
                    if (EV != null) {
                        EV.deleteUploadedTempImages();
                    }
                    this.aCr.setIsBaobao(false);
                    this.aCr.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.aAK.c((WriteData) null);
                    this.aAK.ey(false);
                    this.byO.bD(true);
                    if (this.byO.Yj()) {
                        this.byM.Zk();
                    } else {
                        if (this.byJ != null && this.byJ.Xm()) {
                            this.byO.Ya();
                        }
                        if (this.byJ != null && this.byJ.Xf() != null && !this.byJ.Xj()) {
                            com.baidu.tieba.tbadkCore.al.b(this.byJ.Xf(), (WriteData) null);
                        }
                    }
                    this.byO.a(this.writeImagesInfo, true);
                    return;
                case 12009:
                case 12010:
                    WK();
                    if (i == 12010) {
                        L(intent);
                        return;
                    }
                    return;
                case 12012:
                    K(intent);
                    return;
                case 12013:
                    M(intent);
                    return;
                case 13008:
                    bv.Xz().reset();
                    this.mHandler.postDelayed(new ac(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.byJ != null) {
                        a(WJ(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getIntExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0));
                        return;
                    }
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                    return;
                case 23007:
                    R(intent);
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                EW();
                return;
            case 12002:
                if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                    this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    return;
                }
                return;
            case 12003:
            case 12004:
            case 12005:
            case 12006:
            case 12007:
            case 12008:
            default:
                return;
            case 12009:
            case 12010:
                WK();
                return;
        }
    }

    private ShareFromPBMsgData WJ() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] aw = this.byJ.getPbData().aw(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.b.k XI = this.byO.XI();
        String str = "";
        if (XI != null) {
            str = XI.getId();
            String az = XI.az(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(az)) {
                aw[1] = az;
            }
        }
        String nD = this.byJ.getPbData().agE().nD();
        if (nD != null && nD.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(aw[1]);
        shareFromPBMsgData.setImageUrl(aw[0]);
        shareFromPBMsgData.setForumName(this.byJ.getPbData().aej().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.byJ.getPbData().agE().getId());
        shareFromPBMsgData.setTitle(this.byJ.getPbData().agE().getTitle());
        return shareFromPBMsgData;
    }

    private void R(Intent intent) {
        a(WJ(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.byJ != null && this.byJ.getPbData() != null && this.byJ.getPbData().agE() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bX(this.byJ.getPbData().agE().getTitle());
            dc dcVar = new dc(getPageContext().getPageActivity());
            dcVar.setData(shareFromPBMsgData);
            aVar.j(dcVar);
            aVar.a(com.baidu.tieba.z.share, new ad(this, j, str, str2, dcVar, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.z.alert_no_button, new ae(this, dcVar));
            aVar.ag(false);
            aVar.b(getPageContext()).nU();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                dcVar.A(shareFromPBMsgData.getImageUrl(), this.byJ.getPbData().Ci() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, int i2) {
        if (this.byJ != null && this.byJ.getPbData() != null && this.byJ.getPbData().agE() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bX(this.byJ.getPbData().agE().getTitle());
            dc dcVar = new dc(getPageContext().getPageActivity());
            dcVar.setData(shareFromPBMsgData);
            aVar.j(dcVar);
            aVar.a(com.baidu.tieba.z.share, new af(this, i, str, i2, dcVar, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.z.alert_no_button, new ag(this, dcVar));
            aVar.ag(false);
            aVar.b(getPageContext()).nU();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                dcVar.A(shareFromPBMsgData.getImageUrl(), this.byJ.getPbData().Ci() == 1);
            }
        }
    }

    private void J(Intent intent) {
        a(intent, true);
    }

    private void L(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aAI;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cd = com.baidu.tbadk.core.util.d.cd(str);
                if (cd != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.d.b(str, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.M(getPageContext().getPageActivity())), com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.N(getPageContext().getPageActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.d.h(b, cd);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.aAI, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            this.byO.a(this.writeImagesInfo, true);
        }
        if (this.byO.Fh() != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            this.byO.Fh().hH(23);
        }
    }

    private void K(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    this.byO.a(this.writeImagesInfo, z);
                }
            }
            if (this.byO.Fh() != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                this.byO.Fh().hH(23);
            }
        }
    }

    private void M(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            if (stringExtra != null && stringExtra2 != null) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(stringExtra);
                this.baobaoImagesInfo.clear();
                this.baobaoImagesInfo.addChooseFile(imageFileInfo);
                this.byO.setBaobaoUris(this.baobaoImagesInfo);
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    if (this.byO.Fh() != null) {
                        this.byO.Fh().hH(50);
                    }
                    this.aCr.setIsBaobao(true);
                    this.aCr.setBaobaoContent(stringExtra2);
                    this.aCr.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.aCr.setIsBaobao(false);
                this.aCr.setBaobaoContent("");
                this.aCr.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void EW() {
        new ah(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EU() {
        if (this.aAR == null) {
            String[] strArr = {getPageContext().getString(com.baidu.tieba.z.take_photo), getPageContext().getString(com.baidu.tieba.z.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
            builder.setTitle(getPageContext().getString(com.baidu.tieba.z.operation));
            builder.setItems(strArr, new aj(this));
            this.aAR = builder.create();
            this.aAR.setCanceledOnTouchOutside(true);
        }
    }

    private void WK() {
        if (this.byQ) {
            this.byQ = false;
            new Handler().postDelayed(new ak(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WL() {
        MarkData gW = this.byJ.gW(this.byO.Yr());
        if (gW != null) {
            this.byO.Ya();
            this.byK.b(gW);
            if (!this.byK.li()) {
                this.byK.ll();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.byK.lm();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(String str) {
        VoiceData.VoiceModel XQ;
        if (this.aAK.EV() == null) {
            if (!this.byJ.Xj()) {
                this.aAK.c(this.byJ.hv(str));
            } else {
                this.aAK.c(this.byM.EV());
            }
        }
        if (this.aAK.EV() != null) {
            if (!this.byJ.Xj()) {
                this.aAK.EV().setWriteImagesInfo(this.writeImagesInfo);
                this.aAK.ey(this.writeImagesInfo.size() > 0);
                if (this.aCr.getIsBaobao()) {
                    this.aAK.EV().setIsBaobao(true);
                    this.aAK.EV().setBaobaoContent(this.aCr.getBaobaoContent());
                    this.aAK.EV().setBaobaoImagesInfo(this.baobaoImagesInfo);
                } else {
                    this.aAK.EV().setIsBaobao(false);
                }
            }
            if (this.byO.Fh() != null) {
                this.aAK.EV().setHasLocationData(this.byO.Fh().getLocationInfoViewState() == 2);
            }
            if (str == null) {
                this.aAK.EV().setContent(this.byO.Fo());
                XQ = this.byO.getAudioData();
                this.byO.Fq();
            } else {
                this.aAK.EV().setContent(this.byO.Ys());
                this.aAK.EV().setRepostId(this.byO.Yu());
                XQ = this.byO.XQ();
                this.byO.XR();
            }
            if (XQ != null) {
                if (XQ.getId() != null) {
                    this.aAK.EV().setVoice(XQ.getId());
                    this.aAK.EV().setVoiceDuringTime(XQ.duration);
                } else {
                    this.aAK.EV().setVoice(null);
                    this.aAK.EV().setVoiceDuringTime(-1);
                }
            } else {
                this.aAK.EV().setVoice(null);
                this.aAK.EV().setVoiceDuringTime(-1);
            }
            if (!this.aAK.aic()) {
                showToast(com.baidu.tieba.z.write_img_limit);
            } else if (this.aAK.aib()) {
                this.byO.Fn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WM() {
        com.baidu.tieba.tbadkCore.b.i pbData = this.byJ.getPbData();
        this.byJ.dM(true);
        pbData.ig(this.byK.lk());
        this.byO.e(pbData);
    }

    private boolean WN() {
        if (this.byJ == null) {
            return true;
        }
        if (this.byJ.li()) {
            MarkData Xr = this.byJ.Xr();
            if (Xr == null || !this.byJ.getIsFromMark()) {
                return true;
            }
            MarkData gW = this.byJ.gW(this.byO.Yr());
            if (gW == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, Xr);
                setResult(-1, intent);
                WI();
                return true;
            } else if (gW.getPostId() == null || gW.getPostId().equals(Xr.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, Xr);
                setResult(-1, intent2);
                WI();
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.bY(String.format(getPageContext().getString(com.baidu.tieba.z.alert_update_mark), Integer.valueOf(gW.getFloor())));
                aVar.a(com.baidu.tieba.z.alert_yes_btn, new al(this, gW, Xr));
                aVar.b(com.baidu.tieba.z.alert_no_button, new am(this, Xr));
                aVar.b(getPageContext());
                aVar.nU();
                return false;
            }
        } else if (this.byJ.getPbData() == null || this.byJ.getPbData().agF() == null || this.byJ.getPbData().agF().size() <= 0 || !this.byJ.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.ar
    public BdListView getListView() {
        if (this.byO == null) {
            return null;
        }
        return this.byO.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int getRichTextViewId() {
        if (this.byO == null) {
            return 0;
        }
        return this.byO.Yx();
    }

    @Override // com.baidu.tbadk.core.view.ar
    public int qD() {
        if (this.byO == null) {
            return 0;
        }
        return this.byO.EO();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<ImageView> getImageViewPool() {
        if (this.ajD == null) {
            this.ajD = new com.baidu.adp.lib.e.b<>(new an(this), 8, 0);
        }
        return this.ajD;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<TextView> getTextViewPool() {
        if (this.ajE == null) {
            this.ajE = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.ajE;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<GifView> getGifViewPool() {
        if (this.ajH == null) {
            this.ajH = new com.baidu.adp.lib.e.b<>(new ao(this), 20, 0);
        }
        return this.ajH;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<View> getVoiceViewPool() {
        if (this.ajF == null) {
            this.ajF = new com.baidu.adp.lib.e.b<>(new ap(this), 8, 0);
        }
        return this.ajF;
    }

    @Override // com.baidu.tbadk.core.view.ar
    public com.baidu.adp.lib.e.b<TbImageView> qE() {
        if (this.Ny == null) {
            this.Ny = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.Ny;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    public boolean hs(String str) {
        Map<String, String> cL;
        if (!TextUtils.isEmpty(str) && (cL = com.baidu.tbadk.core.util.bh.cL(com.baidu.tbadk.core.util.bh.cM(str))) != null) {
            String str2 = cL.get(ImageViewerConfig.URL);
            if (!TextUtils.isEmpty(str2)) {
                return hs(com.baidu.adp.lib.util.k.aF(str2));
            }
            String str3 = cL.get(byC);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onLinkClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (ht(str) || z) {
                boolean u = com.baidu.adp.lib.util.l.u(context, "com.qiyi.video");
                hu(str);
                if (u) {
                    WO();
                } else {
                    WP();
                }
            } else if (hs(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                com.baidu.tbadk.core.util.bh.pK().b(getPageContext(), new String[]{str});
            }
        }
    }

    private boolean ht(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }

    private void hu(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(";")) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.byz = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.byA = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.mDownloadUrl = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.byy = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void WO() {
        if (TextUtils.isEmpty(this.byz) || TextUtils.isEmpty(this.byA) || TextUtils.isEmpty(this.mPackageName)) {
            if (!TextUtils.isEmpty(this.byy)) {
                com.baidu.tbadk.browser.a.b(getPageContext().getPageActivity(), false, this.byy);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(this.byz));
        intent.setAction(this.byA);
        intent.setPackage(this.mPackageName);
        if (intent.resolveActivity(getPageContext().getPageActivity().getPackageManager()) != null) {
            if (!com.baidu.adp.lib.g.j.e(getPageContext().getPageActivity(), intent) && !TextUtils.isEmpty(this.byy)) {
                com.baidu.tbadk.browser.a.b(getPageContext().getPageActivity(), false, this.byy);
            }
        } else if (!TextUtils.isEmpty(this.byy)) {
            com.baidu.tbadk.browser.a.b(getPageContext().getPageActivity(), false, this.byy);
        }
    }

    private void WP() {
        if (!com.baidu.adp.lib.util.i.fh()) {
            if (!TextUtils.isEmpty(this.byy)) {
                com.baidu.tbadk.browser.a.b(getPageContext().getPageActivity(), false, this.byy);
                return;
            }
            return;
        }
        if (this.byx == null) {
            this.byx = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.byx.bt(com.baidu.tieba.z.download_iqiyi_app_dialog);
            this.byx.a(com.baidu.tieba.z.install_app, new aq(this));
            this.byx.b(com.baidu.tieba.z.webpage_play, new ar(this));
            this.byx.ag(false);
        }
        this.byx.b(getPageContext()).nU();
    }

    private DialogInterface WQ() {
        if (this.byE == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
            builder.setTitle(getPageContext().getString(com.baidu.tieba.z.download_baidu_video_dialog));
            builder.setPositiveButton(getPageContext().getString(com.baidu.tieba.z.install), new as(this));
            builder.setNegativeButton(getPageContext().getString(com.baidu.tieba.z.cancel), new au(this));
            builder.setCancelable(true);
            this.byE = builder.create();
            this.byE.setCanceledOnTouchOutside(false);
        }
        com.baidu.adp.lib.g.k.a(this.byE, getPageContext());
        return this.byE;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onVideoClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (ht(str) || z) {
                boolean u = com.baidu.adp.lib.util.l.u(context, "com.qiyi.video");
                hu(str);
                if (u) {
                    WO();
                    return;
                } else {
                    WP();
                    return;
                }
            }
            com.baidu.tbadk.browser.a.y(getPageContext().getPageActivity(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onVideoP2PClicked(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra("title", "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            WQ();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onSongClicked(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList) {
        int i3;
        int i4;
        if (aVar == aVar2) {
            this.bzg = true;
        }
        if (aVar != null) {
            int size = aVar.zL().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.zL().get(i6) != null && aVar.zL().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.zL().get(i6).zQ().getWidth();
                    int height = aVar.zL().get(i6).zQ().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.zL().get(i6).zQ().zX()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        arrayList.add(b(aVar.zL().get(i6)));
                        if (!this.bzg) {
                            i4 = i7 + 1;
                            i3 = i5;
                        }
                    }
                    i6++;
                    i7 = i4;
                    i5 = i3;
                }
                i3 = i5;
                i4 = i7;
                i6++;
                i7 = i4;
                i5 = i3;
            }
            return i7;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.tbadkCore.b.k kVar) {
        if (kVar != null) {
            boolean z = false;
            if (kVar.getId() != null && kVar.getId().equals(this.byJ.nx())) {
                z = true;
            }
            MarkData c = this.byJ.c(kVar);
            if (c != null && gP(11009)) {
                this.byO.Ya();
                this.byK.b(c);
                if (!z) {
                    this.byK.ll();
                } else {
                    this.byK.lm();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a R(String str, int i) {
        if (this.byJ == null || this.byJ.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.tbadkCore.b.i pbData = this.byJ.getPbData();
        com.baidu.tbadk.widget.richText.a a = a(pbData.agF(), str, i);
        if (a == null) {
            ArrayList<com.baidu.tieba.tbadkCore.b.k> agF = pbData.agF();
            int size = agF.size();
            for (int i2 = 0; i2 < size; i2++) {
                a = a(agF.get(i2).agS(), str, i);
                if (a != null) {
                    return a;
                }
            }
            return a;
        }
        return a;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.b.k> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> zL;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a agU = arrayList.get(i2).agU();
            if (agU != null && (zL = agU.zL()) != null) {
                int size = zL.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (zL.get(i4) != null && zL.get(i4).getType() == 8) {
                        i3++;
                        if (zL.get(i4).zQ().zY().equals(str)) {
                            int width = zL.get(i4).zQ().getWidth();
                            int height = zL.get(i4).zQ().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.bzf = i4;
                            return agU;
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

    /* JADX INFO: Access modifiers changed from: private */
    public String b(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        com.baidu.tbadk.widget.richText.g zQ = cVar.zQ();
        if (zQ != null) {
            if (!StringUtils.isNull(zQ.zW())) {
                return zQ.zW();
            }
            if (zQ.getHeight() * zQ.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (zQ.getHeight() * zQ.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (zQ.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * zQ.getHeight())));
            } else {
                float width = zQ.getWidth() / zQ.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.ba.aE(zQ.getSrc()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onPhoneClicked(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mPhoneNumber = str;
            if (this.byD == null) {
                WF();
            }
            com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "pb_show_phonedialog");
            if (str2.equals("2")) {
                this.byD.bC(1).setVisibility(8);
            } else {
                this.byD.bC(1).setVisibility(0);
            }
            this.byD.nW();
        }
    }

    @Override // com.baidu.tbadk.core.voice.o
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WR() {
        hideNetRefreshView(this.byO.getView());
        showLoadingView(this.byO.getView(), true);
        if (this.byJ.xv()) {
            this.byO.Ya();
        }
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m getRealView(VoiceData.VoiceModel voiceModel) {
        View YG;
        View findViewWithTag;
        if (!this.byO.Yj() || (YG = this.byO.YG()) == null || (findViewWithTag = YG.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (com.baidu.tbadk.core.voice.m) findViewWithTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVoice() {
        if (this.mVoiceManager != null) {
            this.mVoiceManager.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showShareDialog() {
        if (this.byJ.Ui()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.tbadkCore.b.i pbData = this.byJ.getPbData();
            String name = pbData.aej().getName();
            String title = pbData.agE().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.byJ.Xf() + "?share=9105&fr=share";
            String[] aw = pbData.aw(getPageContext().getPageActivity());
            String str2 = aw[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String format = MessageFormat.format(getResources().getString(com.baidu.tieba.z.share_content_tpl), title, name, aw[1]);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.SJ = str;
            if (parse != null) {
                fVar.SL = parse;
            }
            this.aIX = new com.baidu.tbadk.coreExtra.share.d(getPageContext().getPageActivity());
            this.aIX.a(fVar, true);
            this.aIX.a(getShareMtjStatInfo());
            this.aIX.aw(true);
            TextView w = this.aIX.w(com.baidu.tieba.z.share_tieba_qunzu, com.baidu.tieba.v.icon_unite_share_qunzu);
            this.aIX.a(w);
            TextView w2 = this.aIX.w(com.baidu.tieba.z.forum_friend, com.baidu.tieba.v.icon_unite_share_baf);
            this.aIX.a(w2);
            w2.setOnClickListener(new av(this));
            w.setOnClickListener(new aw(this));
            this.aIX.c(new ax(this, fVar));
            this.aIX.show();
        }
    }

    private SparseArray<String> getShareMtjStatInfo() {
        if (this.aJa == null) {
            this.aJa = new SparseArray<>(7);
            this.aJa.put(2, "pb_wx_timeline");
            this.aJa.put(3, "pb_wx_friend");
            this.aJa.put(4, "pb_qq_zone");
            this.aJa.put(5, "pb_tencent_weibo");
            this.aJa.put(6, "pb_sina_weibo");
            this.aJa.put(7, "pb_renren");
        }
        return this.aJa;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool() {
        if (this.ajG == null) {
            this.ajG = new com.baidu.adp.lib.e.b<>(new ay(this), 15, 0);
        }
        return this.ajG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WS() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.tbadkCore.b.i pbData = this.byJ.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.mP().isIfAddition();
            AdditionData agH = pbData.agH();
            boolean z3 = agH == null ? false : isIfAddition;
            if (z3) {
                z = agH.getAlreadyCount() != agH.getTotalCount();
                if (!TextUtils.isEmpty(agH.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.main.b.a aVar = this.byO.bBo;
            if (!z3 || !z) {
                z2 = false;
            }
            aVar.dW(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.byO.XM() == view) {
            com.baidu.tbadk.core.data.w agE = this.byJ.getPbData().agE();
            View childAt = ((ViewGroup) view).getChildAt(0);
            if (childAt != null) {
                boolean z = agE.getPraise() == null || agE.getPraise().getIsLike() == 0;
                if (motionEvent.getAction() == 0) {
                    if (System.currentTimeMillis() - this.praiseStopTime > 1000) {
                        this.isPraiseToServer = true;
                        praiseAnimDown(childAt);
                    } else {
                        this.isPraiseToServer = false;
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (z) {
                        praiseAnimUp(childAt, this.isPraiseToServer);
                    } else {
                        praiseAnimCancel(childAt, this.isPraiseToServer);
                    }
                } else if (motionEvent.getAction() == 2) {
                    praiseAnimCancel(childAt, this.isPraiseToServer);
                } else if (motionEvent.getAction() == 3) {
                    praiseAnimCancel(childAt, this.isPraiseToServer);
                }
            }
        }
        return false;
    }

    private void praiseAnimCancel(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), com.baidu.tieba.q.praise_animation_scale2));
            new Handler().postDelayed(new az(this), 200L);
        }
    }

    private void praiseAnimUp(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), com.baidu.tieba.q.praise_animation_scale3));
            new Handler().postDelayed(new ba(this), 600L);
        }
    }

    private void praiseAnimDown(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), com.baidu.tieba.q.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void FM() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }
}
