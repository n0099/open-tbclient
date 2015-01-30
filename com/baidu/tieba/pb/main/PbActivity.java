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
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, com.baidu.tbadk.core.view.as, com.baidu.tbadk.core.voice.o, com.baidu.tbadk.widget.richText.j, com.baidu.tieba.tbadkCore.am {
    private static String bAl = "tbgametype";
    private com.baidu.adp.lib.e.b<TbImageView> NY;
    private com.baidu.tieba.tbadkCore.location.d aBF;
    private String aBK;
    private boolean aae;
    private com.baidu.adp.lib.e.b<ImageView> akg;
    private com.baidu.adp.lib.e.b<TextView> akh;
    private com.baidu.adp.lib.e.b<View> aki;
    private com.baidu.adp.lib.e.b<LinearLayout> akj;
    private com.baidu.adp.lib.e.b<GifView> akk;
    private String bAD;
    private AlertDialog bAn;
    private VoiceData.VoiceModel bAo;
    private String mPhoneNumber;
    private String mPostContent;
    private VoiceManager mVoiceManager;
    private boolean arh = false;
    private boolean aCK = true;
    private boolean bAf = false;
    private com.baidu.tbadk.core.dialog.a bAg = null;
    private String bAh = null;
    private String mDownloadUrl = null;
    private String bAi = null;
    private String bAj = null;
    private String mPackageName = null;
    private int bAk = 0;
    private com.baidu.tbadk.core.dialog.i bAm = null;
    SparseArray<String> aKk = null;
    private long aDp = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private WriteData aDs = new WriteData();
    private long agS = 0;
    private long createTime = 0;
    private long agT = 0;
    private boolean bAp = false;
    private com.baidu.tbadk.performanceLog.h bAq = null;
    public long aDz = System.currentTimeMillis();
    private String bAr = null;
    private final Handler mHandler = new Handler(new b(this));
    private bq bAs = null;
    private com.baidu.tbadk.baseEditMark.e bAt = null;
    private com.baidu.tieba.tbadkCore.f.a aBM = null;
    private com.baidu.tieba.model.m bAu = null;
    private com.baidu.tieba.pb.sub.e bAv = null;
    private com.baidu.tieba.tbadkCore.e.a bAw = null;
    private bz bAx = null;
    public final com.baidu.tieba.pb.main.a.a bAy = new com.baidu.tieba.pb.main.a.a(this);
    private boolean bAz = false;
    private boolean bAA = false;
    private MorePopupWindow bAB = null;
    private by bAC = null;
    private boolean aCM = false;
    private com.baidu.tieba.tbadkCore.location.i aBQ = new ai(this);
    private com.baidu.tieba.tbadkCore.location.j aBR = new at(this);
    private boolean aBG = false;
    private com.baidu.tieba.tbadkCore.ao aBU = new com.baidu.tieba.tbadkCore.ao(getPageContext(), new bb(this));
    private long praiseStopTime = 0;
    private boolean isPraiseToServer = true;
    public com.baidu.tieba.b.e bAE = new bc(this);
    public final View.OnClickListener aFK = new bd(this);
    private final bt bAF = new bf(this);
    private final com.baidu.tbadk.baseEditMark.g bAG = new c(this);
    private final AbsListView.OnScrollListener wT = new d(this);
    private final AbsListView.OnScrollListener bAH = new e(this);
    private final com.baidu.tieba.pb.sub.g bAI = new f(this);
    private final com.baidu.tieba.tbadkCore.f.c aDC = new g(this);
    private final com.baidu.adp.base.i bAJ = new h(this);
    private final bh bAK = new i(this);
    private final com.baidu.adp.widget.ListView.g aTB = new j(this);
    private final com.baidu.adp.widget.ListView.ab bAL = new k(this);
    private final com.baidu.adp.widget.ListView.ae bAM = new l(this);
    private final DialogInterface.OnClickListener bfO = new n(this);
    private final com.baidu.adp.base.i bAN = new o(this);
    private final cz bAO = new p(this);
    private int bAP = 0;
    private final com.baidu.tbadk.widget.richText.s akz = new q(this);
    boolean bAQ = false;
    com.baidu.tieba.tbadkCore.b.k bAR = null;
    private final DialogInterface.OnClickListener bAS = new r(this);
    private final View.OnLongClickListener Uq = new s(this);
    private final com.baidu.tbadk.core.view.ad aDO = new t(this);
    com.baidu.tbadk.coreExtra.share.d aKh = null;

    static {
        JC();
        Xb();
        CustomMessageTask customMessageTask = new CustomMessageTask(2004001, new m());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2004005, new x());
        customMessageTask2.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        Xc();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m255getInst().isGpuOpen();
    }

    private static void JC() {
        com.baidu.tieba.tbadkCore.a.a.a(302001, pbPageSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.O("c/f/pb/page", 302001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.location.d.aii();
    }

    private static void Xb() {
        com.baidu.tieba.tbadkCore.a.a.b(2004003, da.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fp() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Fq() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.z.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m255getInst().getLocationShared()) {
            Fr();
        } else if (this.aBF.aih()) {
            Fp();
        } else {
            this.aBF.eE(false);
            if (this.bAx.FF() != null) {
                this.bAx.FF().setLocationViewVisibility(0);
                this.bAx.FF().setLocationInfoViewState(1);
            }
            this.aBF.aif();
        }
    }

    private void Fr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.by(com.baidu.tieba.z.location_app_permission_prompt).a(com.baidu.tieba.z.isopen, new u(this)).b(com.baidu.tieba.z.cancel, new v(this)).b(getPageContext());
        aVar.nX();
    }

    public void Fs() {
        if (this.bAx.FF() != null) {
            if (this.aBF.aij()) {
                this.bAx.FF().setLocationViewVisibility(0);
                if (this.aBF.aih()) {
                    this.aBQ.a(com.baidu.tieba.tbadkCore.location.c.aic().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.l.isNetOk()) {
                    this.bAx.FF().setLocationInfoViewState(1);
                    this.aBF.aif();
                    return;
                } else {
                    this.bAx.FF().setLocationInfoViewState(0);
                    return;
                }
            }
            this.bAx.FF().setLocationViewVisibility(8);
        }
    }

    private static void Xc() {
        com.baidu.tbadk.core.util.bm.pV().a(new w());
    }

    private void Xd() {
        this.bAx.YT();
        this.bAx.Ys();
    }

    private void Xe() {
        this.bAx.YU();
        this.bAx.Yu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xf() {
        com.baidu.tieba.tbadkCore.b.i pbData;
        com.baidu.tbadk.core.data.x ahj;
        if (!this.aBG) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                showToast(com.baidu.tieba.z.no_network_guide);
            } else if (this.isPraiseToServer) {
                this.aBG = true;
                if (this.bAs != null && (pbData = this.bAs.getPbData()) != null && (ahj = pbData.ahj()) != null) {
                    int isLike = ahj.getPraise() == null ? 0 : ahj.getPraise().getIsLike();
                    if (this.aBU != null) {
                        this.aBU.a(ahj.nF(), ahj.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(int i) {
        com.baidu.tbadk.core.data.x ahj;
        if (this.bAs != null && this.bAs.getPbData() != null && (ahj = this.bAs.getPbData().ahj()) != null) {
            if (i == 1) {
                PraiseData praise = ahj.getPraise();
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
                        ahj.setPraise(praiseData);
                    } else {
                        ahj.getPraise().getUser().add(0, metaData);
                        ahj.getPraise().setNum(ahj.getPraise().getNum() + 1);
                        ahj.getPraise().setIsLike(i);
                    }
                }
                if (ahj.getPraise() != null) {
                    this.bAx.d(ahj.getPraise().getNum(), true);
                }
            } else if (ahj.getPraise() != null) {
                ahj.getPraise().setIsLike(i);
                ahj.getPraise().setNum(ahj.getPraise().getNum() - 1);
                ArrayList<MetaData> user = ahj.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            ahj.getPraise().getUser().remove(next);
                            break;
                        }
                    }
                }
                this.bAx.d(ahj.getPraise().getNum(), false);
            }
            if (this.bAs.XL()) {
                this.bAx.Yy().notifyDataSetChanged();
            } else {
                this.bAx.f(this.bAs.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bAs.saveToBundle(bundle);
        if (this.bAs.XO()) {
            this.bAv.saveToBundle(bundle);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aBK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.aDp = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aDp = System.currentTimeMillis();
        }
        this.bAk = 0;
        initUI();
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initData(bundle);
        addGlobalLayoutListener();
        this.createTime = System.currentTimeMillis() - this.aDp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.bAx != null) {
            if (this.bAx.FF() != null) {
                this.bAx.FF().afP();
            }
            if (this.bAx.Yt() != null && this.bAx.Yt().FF() != null) {
                this.bAx.Yt().FF().afP();
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

    public bq Xg() {
        return this.bAs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.arh = true;
        super.onPause();
        BdListView listView = getListView();
        this.bAk = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.bAk == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
        if (this.bAx != null) {
            this.bAx.onPause();
        }
        if (!this.bAs.XO()) {
            WriteData Ft = this.aBM.Ft();
            if (Ft == null) {
                Ft = new WriteData(1);
                Ft.setThreadId(this.bAs.XK());
                Ft.setWriteImagesInfo(this.writeImagesInfo);
            }
            Ft.setContent(this.bAx.FM());
            if (this.aDs != null && this.aDs.getIsBaobao()) {
                Ft.setBaobaoContent(this.aDs.getBaobaoContent());
                Ft.setBaobaoImagesInfo(this.baobaoImagesInfo);
                Ft.setIsBaobao(true);
            }
            com.baidu.tieba.tbadkCore.al.b(this.bAs.XK(), Ft);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        this.arh = false;
        super.onResume();
        if (this.bAk == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView Yl = this.bAx.Yl();
        if (Yl != null && Yl.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            Yl.as(false);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
        if (this.bAx.FF() != null) {
            this.bAx.FF().refresh();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!com.baidu.tbadk.core.util.bf.isEmpty(writeData.getContent()) && com.baidu.tbadk.core.util.bf.isEmpty(this.bAx.FM())) {
                this.mPostContent = writeData.getContent();
                this.bAx.fC(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                this.bAx.a(this.writeImagesInfo, true);
            }
            if (TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.aDs.setIsBaobao(writeData.getIsBaobao());
                this.aDs.setBaobaoContent(writeData.getBaobaoContent());
                this.aDs.setBaobaoImagesInfo(this.baobaoImagesInfo);
                this.bAx.setBaobaoUris(this.baobaoImagesInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bAx.FF() != null && this.bAx.FF().getVisibility() != 0) {
            Xi();
            this.bAx.Yo();
        }
        if (!this.bAx.YO()) {
            this.bAx.YQ();
        }
        this.bAx.bCY.Zx();
        if (this.bAs != null && this.bAs.getPbData() != null && this.bAs.getPbData().aeN() != null && this.bAs.getPbData().ahj() != null) {
            com.baidu.tbadk.distribute.a.uU().a(getPageContext().getPageActivity(), "pb", this.bAs.getPbData().aeN().getId(), com.baidu.adp.lib.g.c.a(this.bAs.getPbData().ahj().getId(), 0L));
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (!this.bAp) {
            this.bAp = true;
            this.bAx.Zq();
        }
        this.bAs.cancelLoadData();
        this.bAs.destory();
        this.aBM.cancelLoadData();
        this.bAu.cancelLoadData();
        this.aBF.cancelLoadData();
        this.bAv.cancelLoadData();
        this.bAv.destory();
        this.bAw.cancelLoadData();
        this.bAx.onDestroy();
        if (this.bAq != null) {
            this.bAq.onDestroy();
        }
        super.onDestroy();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
    }

    public void Xh() {
        if (this.bAx.FF() != null) {
            this.bAx.FF().setContent(this.mPostContent == null ? "" : this.mPostContent);
            if (this.bAo != null) {
                this.bAx.FF().afZ();
            }
            this.bAx.a(this.writeImagesInfo, true);
            this.bAx.setBaobaoUris(this.baobaoImagesInfo);
            if (!StringUtils.isNull(this.mPostContent) || this.bAo != null) {
                this.bAx.FF().agf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xi() {
        if (this.bAx.FF() != null) {
            this.mPostContent = this.bAx.FF().getContent();
            this.bAo = this.bAx.getAudioData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bAx.onChangeSkinType(i);
        if (this.bAB != null) {
            this.bAB.onChangeSkinType(this, i, com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.bg_collect));
        }
        if (this.bAx.Yl() != null) {
            this.bAx.Yl().onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xj() {
        this.bAC = new by(this, this.aFK);
        this.bAB = new MorePopupWindow(getPageContext().getPageActivity(), this.bAC.getView(), getResources().getDrawable(com.baidu.tieba.v.bg_collect), null);
        this.bAB.setTouchInterceptor(new y(this));
        this.bAB.onChangeSkinType(this, TbadkCoreApplication.m255getInst().getSkinType(), com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.bg_collect));
    }

    private void initUI() {
        this.bAx = new bz(this, this.aFK, this.bAE);
        this.bAx.setOnActionListener(new z(this));
        this.bAx.setOnScrollListener(this.wT);
        this.bAx.a(this.bAH);
        this.bAx.c(this.bAL);
        this.bAx.a(this.bAM);
        this.bAx.c(this.bfO);
        this.bAx.a(this.aTB);
        this.bAx.dO(com.baidu.tbadk.core.l.mc().mg());
        this.bAx.dP(com.baidu.tbadk.core.l.mc().me());
        this.bAx.setOnImageClickListener(this.akz);
        this.bAx.b(this.Uq);
        this.bAx.a(this.bAO);
        this.bAx.f(this.aDO);
        this.bAx.a(this.bAK);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.bAx != null) {
            if (z && !this.bAf) {
                if (this.aCK) {
                    this.aCK = false;
                    showLoadingView(this.bAx.getView(), true);
                    return;
                }
                return;
            }
            hideLoadingView(this.bAx.getView());
        }
    }

    private void Xk() {
        if (this.bAm == null) {
            this.bAm = new com.baidu.tbadk.core.dialog.i(getPageContext().getPageActivity());
            this.bAm.a(new Object[]{getPageContext().getString(com.baidu.tieba.z.call_phone), getPageContext().getString(com.baidu.tieba.z.sms_phone), getPageContext().getString(com.baidu.tieba.z.search_in_baidu)}, new aa(this)).bE(com.baidu.tbadk.core.dialog.k.FX).bF(80).e(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        this.bAs = new bq(this);
        this.bAs.a(this.bAF);
        this.bAt = new com.baidu.tbadk.baseEditMark.e(this);
        this.bAt.a(this.bAG);
        this.aBM = new com.baidu.tieba.tbadkCore.f.a(this);
        this.aBM.a(this.aDC);
        this.bAu = new com.baidu.tieba.model.m(this);
        this.bAu.setLoadDataCallBack(this.bAN);
        this.bAv = new com.baidu.tieba.pb.sub.e(this);
        this.bAv.a(this.bAI);
        this.bAw = new com.baidu.tieba.tbadkCore.e.a(this);
        this.bAw.setLoadDataCallBack(this.bAJ);
        this.aBF = new com.baidu.tieba.tbadkCore.location.d(this);
        this.aBF.a(this.aBQ);
        this.aBF.a(this.aBR);
        if (bundle != null) {
            this.bAs.initWithBundle(bundle);
        } else {
            this.bAs.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, -1) == 18003) {
            this.bAs.dT(true);
        }
        bv.Ye().y(this.bAs.XI(), this.bAs.getIsFromMark());
        if (!this.bAs.XO()) {
            this.bAx.YF();
            this.bAs.xL();
        } else {
            if (bundle != null) {
                this.bAv.initWithBundle(bundle);
            } else {
                this.bAv.initWithIntent(getIntent());
            }
            this.bAD = this.bAv.lt();
            String stType = this.bAv.getStType();
            if (stType != null && (("mention".equals(this.bAv.getStType()) || stType.equals("person_post_reply")) && this.bAD != null)) {
                this.bAx.YS();
            } else {
                this.bAx.YL();
            }
            this.bAv.ZR();
        }
        this.bAx.a(new ab(this));
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aBK = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!this.bAs.XO()) {
            com.baidu.tieba.tbadkCore.al.a(this.bAs.XK(), this);
        }
        this.aBU.setUniqueId(getUniqueId());
        this.aBU.registerListener();
    }

    public void Xl() {
        this.bAx.bCY.g(this.bAs.XL(), this.bAt.li());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(View view) {
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
        Xw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Boolean bool) {
        com.baidu.tieba.tbadkCore.b.i pbData;
        String str = null;
        if (this.bAs != null && (pbData = this.bAs.getPbData()) != null && pbData.aeN() != null) {
            str = pbData.aeN().getName();
        }
        if (com.baidu.tieba.tbadkCore.aa.b(str, bool)) {
            Xe();
        } else {
            Xd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Boolean bool) {
        if (com.baidu.tieba.tbadkCore.aa.b(str, bool)) {
            Xe();
        } else {
            Xd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, com.baidu.tieba.tbadkCore.f.f fVar) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            if (!this.bAs.XO()) {
                antiData.setBlock_forum_name(this.bAs.getPbData().aeN().getName());
                antiData.setBlock_forum_id(this.bAs.getPbData().aeN().getId());
                antiData.setUser_name(this.bAs.getPbData().getUserData().getUserName());
                antiData.setUser_id(this.bAs.getPbData().getUserData().getUserId());
            } else {
                antiData.setBlock_forum_name(this.bAv.ZM().ahL().getName());
                antiData.setBlock_forum_id(this.bAv.ZM().ahL().getId());
                antiData.setUser_name(TbadkCoreApplication.getCurrentAccountName());
                antiData.setUser_id(TbadkCoreApplication.getCurrentAccount());
            }
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.tieba.tbadkCore.f.g.d(getPageContext().getPageActivity(), fVar.getErrorString(), fVar.aiI(), fVar.aiJ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            if (!this.bAs.XO()) {
                antiData.setBlock_forum_name(this.bAs.getPbData().aeN().getName());
                antiData.setBlock_forum_id(this.bAs.getPbData().aeN().getId());
                antiData.setUser_name(this.bAs.getPbData().getUserData().getUserName());
                antiData.setUser_id(this.bAs.getPbData().getUserData().getUserId());
            } else {
                antiData.setBlock_forum_name(this.bAv.ZM().ahL().getName());
                antiData.setBlock_forum_id(this.bAv.ZM().ahL().getId());
                antiData.setUser_name(TbadkCoreApplication.getCurrentAccountName());
                antiData.setUser_id(TbadkCoreApplication.getCurrentAccount());
            }
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        this.bAx.showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.e.c cVar) {
        int i = 0;
        if (cVar != null) {
            this.bAx.a(0, cVar.qb, cVar.caA, true);
            if (cVar.qb) {
                if (cVar.cay == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.b.k> ahk = this.bAs.getPbData().ahk();
                    int size = ahk.size();
                    while (true) {
                        if (i < size) {
                            if (!cVar.mPostId.equals(ahk.get(i).getId())) {
                                i++;
                            } else {
                                ahk.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.bAx.e(this.bAs.getPbData());
                } else if (cVar.cay == 0) {
                    Xm();
                } else if (cVar.cay == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.b.k> ahk2 = this.bAs.getPbData().ahk();
                    int size2 = ahk2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < ahk2.get(i2).ahv().size()) {
                                if (!cVar.mPostId.equals(ahk2.get(i2).ahv().get(i3).getId())) {
                                    i3++;
                                } else {
                                    ahk2.get(i2).ahv().remove(i3);
                                    ahk2.get(i2).ahw();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData ahm = this.bAs.getPbData().ahm();
                        com.baidu.tieba.tbadkCore.b.k kVar = ahk2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.b.k> ahx = kVar.ahx();
                        int size3 = ahx.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!cVar.mPostId.equals(ahk2.get(i2).ahx().get(i4).getId())) {
                                    i4++;
                                } else {
                                    ahx.remove(i4);
                                    ahm.decreaseAlreadyCount();
                                    if (kVar.ahE() > ahx.size()) {
                                        kVar.hY(ahx.size());
                                    }
                                    if (ahx.size() > 0) {
                                        com.baidu.tieba.tbadkCore.b.k kVar2 = ahx.get(ahx.size() - 1);
                                        ahm.setLastAdditionTime(kVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a ahz = kVar2.ahz();
                                        String str = "";
                                        if (ahz != null) {
                                            str = ahz.toString();
                                        }
                                        ahm.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a ahz2 = kVar.ahz();
                                        String str2 = "";
                                        if (ahz2 != null) {
                                            str2 = ahz2.toString();
                                        }
                                        ahm.setLastAdditionContent(str2);
                                    }
                                    Xx();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.bAx.e(this.bAs.getPbData());
                    }
                    if (this.bAx.YO()) {
                        this.bAv.hH(cVar.mPostId);
                        this.bAx.a(this.bAv.ZM(), this.bAs.getPbData().ahl());
                        if (!z) {
                            String lt = this.bAv.lt();
                            while (i < size2) {
                                if (!lt.equals(ahk2.get(i).getId())) {
                                    i++;
                                } else {
                                    ahk2.get(i).ahw();
                                    this.bAx.e(this.bAs.getPbData());
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
        this.bAx.a(1, eVar.qb, eVar.caA, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.e.g gVar) {
        this.bAx.a(this.bAw.getLoadDataMode(), gVar.qb, gVar.caA, false);
        this.bAx.I(gVar.caC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.tbadkCore.e.g gVar) {
        if (gVar != null) {
            this.bAx.a(this.bAw.getLoadDataMode(), gVar.qb, gVar.caA, true);
            if (gVar.qb) {
                this.bAA = true;
                if (i == 2) {
                    this.bAs.getPbData().ahj().bv(1);
                    this.bAs.setIsGood(1);
                } else if (i == 3) {
                    this.bAs.getPbData().ahj().bv(0);
                    this.bAs.setIsGood(0);
                } else if (i == 4) {
                    this.bAs.getPbData().ahj().bu(1);
                    this.bAs.gZ(1);
                } else if (i == 5) {
                    this.bAs.getPbData().ahj().bu(0);
                    this.bAs.gZ(0);
                }
                this.bAx.a(this.bAs.getPbData(), this.bAs.XL(), true);
            }
        }
    }

    private void Xm() {
        if (this.bAs.XM()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.bAs.XK());
            setResult(-1, intent);
        }
        if (Xs()) {
            super.closeActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xn() {
        super.closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        this.bAx.Zj();
        if (this.bAs != null && this.bAs.getPbData() != null) {
            com.baidu.tbadk.b.a aVar = new com.baidu.tbadk.b.a(this);
            com.baidu.tbadk.b.b bVar = new com.baidu.tbadk.b.b();
            bVar.setThreadId(this.bAs.getPbData().ahj().getId());
            bVar.setForumName(this.bAs.getPbData().aeN().getName());
            bVar.bD(this.bAs.getPbData().ahj().getTitle());
            ArrayList<com.baidu.tieba.tbadkCore.b.k> ahk = this.bAs.getPbData().ahk();
            int YW = this.bAx.YW();
            if (ahk != null && YW >= 0 && YW < ahk.size()) {
                bVar.bE(ahk.get(YW).getId());
            }
            bVar.Z(this.bAs.getHostMode());
            bVar.aa(this.bAs.XL());
            aVar.a((com.baidu.tbadk.b.a) bVar);
        }
        if (this.bAs != null && this.bAs.XM()) {
            Intent intent = new Intent();
            if (this.bAA) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.bAs.XK());
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.bAs.XN());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.bAs.getIsGood());
            }
            setResult(-1, intent);
        }
        if (Xs()) {
            if (this.bAs != null && this.bAx != null && this.bAx.getListView() != null) {
                com.baidu.tieba.tbadkCore.b.i pbData = this.bAs.getPbData();
                if (pbData != null && pbData.getUserData() != null) {
                    pbData.getUserData().setBimg_url(TbadkCoreApplication.m255getInst().getDefaultBubble());
                }
                bv.Ye().a(this.bAs.getPbData(), this.bAx.getListView().onSaveInstanceState(), this.bAs.XL(), this.bAs.getHostMode());
            } else {
                bv.Ye().reset();
            }
            super.closeActivity();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.bAB != null) {
                    com.baidu.adp.lib.g.k.a(this.bAB, getPageContext().getPageActivity());
                }
                if (this.bAx.ea(this.bAs.XO())) {
                    stopVoice();
                    return true;
                }
                closeActivity();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean gY(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    fx(null);
                    return;
                case 11009:
                    Xq();
                    return;
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(getPageContext().getPageActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(getPageContext().getPageActivity(), 12005, true)));
                    return;
                case 11027:
                    fx(this.bAx.YY());
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            K(intent);
                            return;
                        } else {
                            J(intent);
                            return;
                        }
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        Xp();
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            this.bAx.YV();
                            this.aBM.eF(false);
                            return;
                        }
                        this.bAu.hx(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    Xp();
                    ArrayList<String> W = com.baidu.tieba.tbadkCore.util.i.W(intent);
                    if (W != null) {
                        this.bAx.A(W);
                        return;
                    }
                    return;
                case 12005:
                    Xp();
                    new Handler().postDelayed(new ac(this), 200L);
                    ArrayList<String> W2 = com.baidu.tieba.tbadkCore.util.i.W(intent);
                    if (W2 != null) {
                        this.bAx.J(W2);
                        return;
                    }
                    return;
                case 12006:
                    WriteData Ft = this.aBM.Ft();
                    if (Ft != null) {
                        Ft.deleteUploadedTempImages();
                    }
                    this.aDs.setIsBaobao(false);
                    this.aDs.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.aBM.c((WriteData) null);
                    this.aBM.eF(false);
                    this.bAx.bG(true);
                    if (this.bAx.YO()) {
                        this.bAv.ZP();
                    } else {
                        if (this.bAs != null && this.bAs.XR()) {
                            this.bAx.YF();
                        }
                        if (this.bAs != null && this.bAs.XK() != null && !this.bAs.XO()) {
                            com.baidu.tieba.tbadkCore.al.b(this.bAs.XK(), (WriteData) null);
                        }
                    }
                    this.bAx.a(this.writeImagesInfo, true);
                    return;
                case 12009:
                case 12010:
                    Xp();
                    if (i == 12010) {
                        M(intent);
                        return;
                    }
                    return;
                case 12012:
                    L(intent);
                    return;
                case 12013:
                    N(intent);
                    return;
                case 13008:
                    bv.Ye().reset();
                    this.mHandler.postDelayed(new ad(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.bAs != null) {
                        a(Xo(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getIntExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0));
                        return;
                    }
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                    return;
                case 23007:
                    T(intent);
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                Fu();
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
                Xp();
                return;
        }
    }

    private ShareFromPBMsgData Xo() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] ax = this.bAs.getPbData().ax(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.b.k Yn = this.bAx.Yn();
        String str = "";
        if (Yn != null) {
            str = Yn.getId();
            String aA = Yn.aA(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(aA)) {
                ax[1] = aA;
            }
        }
        String nF = this.bAs.getPbData().ahj().nF();
        if (nF != null && nF.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(ax[1]);
        shareFromPBMsgData.setImageUrl(ax[0]);
        shareFromPBMsgData.setForumName(this.bAs.getPbData().aeN().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.bAs.getPbData().ahj().getId());
        shareFromPBMsgData.setTitle(this.bAs.getPbData().ahj().getTitle());
        return shareFromPBMsgData;
    }

    private void T(Intent intent) {
        a(Xo(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.bAs != null && this.bAs.getPbData() != null && this.bAs.getPbData().ahj() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bV(this.bAs.getPbData().ahj().getTitle());
            db dbVar = new db(getPageContext().getPageActivity());
            dbVar.setData(shareFromPBMsgData);
            aVar.j(dbVar);
            aVar.a(com.baidu.tieba.z.share, new ae(this, j, str, str2, dbVar, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.z.alert_no_button, new af(this, dbVar));
            aVar.ai(false);
            aVar.b(getPageContext()).nX();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                dbVar.z(shareFromPBMsgData.getImageUrl(), this.bAs.getPbData().CH() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, int i2) {
        if (this.bAs != null && this.bAs.getPbData() != null && this.bAs.getPbData().ahj() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bV(this.bAs.getPbData().ahj().getTitle());
            db dbVar = new db(getPageContext().getPageActivity());
            dbVar.setData(shareFromPBMsgData);
            aVar.j(dbVar);
            aVar.a(com.baidu.tieba.z.share, new ag(this, i, str, i2, dbVar, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.z.alert_no_button, new ah(this, dbVar));
            aVar.ai(false);
            aVar.b(getPageContext()).nX();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                dbVar.z(shareFromPBMsgData.getImageUrl(), this.bAs.getPbData().CH() == 1);
            }
        }
    }

    private void J(Intent intent) {
        a(intent, true);
    }

    private void K(Intent intent) {
        int size;
        int size2;
        M(intent);
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() - 1 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size2 = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    private void M(Intent intent) {
        this.aBK = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aBK;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cb = com.baidu.tbadk.core.util.d.cb(str);
                if (cb != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.d.b(str, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.M(getPageContext().getPageActivity())), com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.N(getPageContext().getPageActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.d.h(b, cb);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.aBK, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            this.bAx.a(this.writeImagesInfo, true);
        }
        if (this.bAx.FF() != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            this.bAx.FF().hQ(23);
        }
    }

    private void L(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    this.bAx.a(this.writeImagesInfo, z);
                }
            }
            if (this.bAx.FF() != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                this.bAx.FF().hQ(23);
            }
        }
    }

    private void N(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            if (stringExtra != null && stringExtra2 != null) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(stringExtra);
                this.baobaoImagesInfo.clear();
                this.baobaoImagesInfo.addChooseFile(imageFileInfo);
                this.bAx.setBaobaoUris(this.baobaoImagesInfo);
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    if (this.bAx.FF() != null) {
                        this.bAx.FF().hQ(50);
                    }
                    this.aDs.setIsBaobao(true);
                    this.aDs.setBaobaoContent(stringExtra2);
                    this.aDs.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.aDs.setIsBaobao(false);
                this.aDs.setBaobaoContent("");
                this.aDs.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void Fu() {
        new aj(this).execute(new Void[0]);
    }

    private void Xp() {
        if (this.bAz) {
            this.bAz = false;
            new Handler().postDelayed(new ak(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xq() {
        MarkData hf = this.bAs.hf(this.bAx.YW());
        if (hf != null) {
            this.bAx.YF();
            this.bAt.b(hf);
            if (!this.bAt.li()) {
                this.bAt.ll();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.bAt.lm();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(String str) {
        VoiceData.VoiceModel Yv;
        if (this.aBM.Ft() == null) {
            if (!this.bAs.XO()) {
                this.aBM.c(this.bAs.hC(str));
            } else {
                this.aBM.c(this.bAv.Ft());
            }
        }
        if (this.aBM.Ft() != null) {
            if (!this.bAs.XO()) {
                this.aBM.Ft().setWriteImagesInfo(this.writeImagesInfo);
                this.aBM.eF(this.writeImagesInfo.size() > 0);
                if (this.aDs.getIsBaobao()) {
                    this.aBM.Ft().setIsBaobao(true);
                    this.aBM.Ft().setBaobaoContent(this.aDs.getBaobaoContent());
                    this.aBM.Ft().setBaobaoImagesInfo(this.baobaoImagesInfo);
                } else {
                    this.aBM.Ft().setIsBaobao(false);
                }
            }
            if (this.bAx.FF() != null) {
                this.aBM.Ft().setHasLocationData(this.bAx.FF().getLocationInfoViewState() == 2);
            }
            if (str == null) {
                this.aBM.Ft().setContent(this.bAx.FM());
                Yv = this.bAx.getAudioData();
                this.bAx.FO();
            } else {
                this.aBM.Ft().setContent(this.bAx.YX());
                this.aBM.Ft().setRepostId(this.bAx.YZ());
                Yv = this.bAx.Yv();
                this.bAx.Yw();
            }
            if (Yv != null) {
                if (Yv.getId() != null) {
                    this.aBM.Ft().setVoice(Yv.getId());
                    this.aBM.Ft().setVoiceDuringTime(Yv.duration);
                } else {
                    this.aBM.Ft().setVoice(null);
                    this.aBM.Ft().setVoiceDuringTime(-1);
                }
            } else {
                this.aBM.Ft().setVoice(null);
                this.aBM.Ft().setVoiceDuringTime(-1);
            }
            if (!this.aBM.aiG()) {
                showToast(com.baidu.tieba.z.write_img_limit);
            } else if (this.aBM.aiF()) {
                this.bAx.FL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xr() {
        com.baidu.tieba.tbadkCore.b.i pbData = this.bAs.getPbData();
        this.bAs.dS(true);
        pbData.in(this.bAt.lk());
        this.bAx.e(pbData);
    }

    private boolean Xs() {
        if (this.bAs == null) {
            return true;
        }
        if (this.bAs.li()) {
            MarkData XW = this.bAs.XW();
            if (XW == null || !this.bAs.getIsFromMark()) {
                return true;
            }
            MarkData hf = this.bAs.hf(this.bAx.YW());
            if (hf == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, XW);
                setResult(-1, intent);
                Xn();
                return true;
            } else if (hf.getPostId() == null || hf.getPostId().equals(XW.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, XW);
                setResult(-1, intent2);
                Xn();
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.bW(String.format(getPageContext().getString(com.baidu.tieba.z.alert_update_mark), Integer.valueOf(hf.getFloor())));
                aVar.a(com.baidu.tieba.z.alert_yes_btn, new al(this, hf, XW));
                aVar.b(com.baidu.tieba.z.alert_no_button, new am(this, XW));
                aVar.b(getPageContext());
                aVar.nX();
                return false;
            }
        } else if (this.bAs.getPbData() == null || this.bAs.getPbData().ahk() == null || this.bAs.getPbData().ahk().size() <= 0 || !this.bAs.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.as
    public BdListView getListView() {
        if (this.bAx == null) {
            return null;
        }
        return this.bAx.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int getRichTextViewId() {
        if (this.bAx == null) {
            return 0;
        }
        return this.bAx.Zc();
    }

    @Override // com.baidu.tbadk.core.view.as
    public int qO() {
        if (this.bAx == null) {
            return 0;
        }
        return this.bAx.Fn();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<ImageView> getImageViewPool() {
        if (this.akg == null) {
            this.akg = new com.baidu.adp.lib.e.b<>(new an(this), 8, 0);
        }
        return this.akg;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<TextView> getTextViewPool() {
        if (this.akh == null) {
            this.akh = TbRichTextView.h(getPageContext().getPageActivity(), 8);
        }
        return this.akh;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<GifView> getGifViewPool() {
        if (this.akk == null) {
            this.akk = new com.baidu.adp.lib.e.b<>(new ao(this), 20, 0);
        }
        return this.akk;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<View> getVoiceViewPool() {
        if (this.aki == null) {
            this.aki = new com.baidu.adp.lib.e.b<>(new ap(this), 8, 0);
        }
        return this.aki;
    }

    @Override // com.baidu.tbadk.core.view.as
    public com.baidu.adp.lib.e.b<TbImageView> qP() {
        if (this.NY == null) {
            this.NY = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.NY;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    public boolean hz(String str) {
        Map<String, String> cK;
        if (!TextUtils.isEmpty(str) && (cK = com.baidu.tbadk.core.util.bm.cK(com.baidu.tbadk.core.util.bm.cL(str))) != null) {
            String str2 = cK.get(ImageViewerConfig.URL);
            if (!TextUtils.isEmpty(str2)) {
                return hz(com.baidu.adp.lib.util.k.aF(str2));
            }
            String str3 = cK.get(bAl);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onLinkClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (hA(str) || z) {
                boolean u = com.baidu.adp.lib.util.l.u(context, "com.qiyi.video");
                hB(str);
                if (u) {
                    Xt();
                } else {
                    Xu();
                }
            } else if (hz(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                com.baidu.tbadk.core.util.bm.pV().b(getPageContext(), new String[]{str});
            }
        }
    }

    private boolean hA(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }

    private void hB(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(";")) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.bAi = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.bAj = split[i].substring(indexOf2 + 1, split[i].length());
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
                        this.bAh = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void Xt() {
        if (TextUtils.isEmpty(this.bAi) || TextUtils.isEmpty(this.bAj) || TextUtils.isEmpty(this.mPackageName)) {
            if (!TextUtils.isEmpty(this.bAh)) {
                com.baidu.tbadk.browser.a.b(getPageContext().getPageActivity(), false, this.bAh);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(this.bAi));
        intent.setAction(this.bAj);
        intent.setPackage(this.mPackageName);
        if (intent.resolveActivity(getPageContext().getPageActivity().getPackageManager()) != null) {
            if (!com.baidu.adp.lib.g.j.e(getPageContext().getPageActivity(), intent) && !TextUtils.isEmpty(this.bAh)) {
                com.baidu.tbadk.browser.a.b(getPageContext().getPageActivity(), false, this.bAh);
            }
        } else if (!TextUtils.isEmpty(this.bAh)) {
            com.baidu.tbadk.browser.a.b(getPageContext().getPageActivity(), false, this.bAh);
        }
    }

    private void Xu() {
        if (!com.baidu.adp.lib.util.i.fg()) {
            if (!TextUtils.isEmpty(this.bAh)) {
                com.baidu.tbadk.browser.a.b(getPageContext().getPageActivity(), false, this.bAh);
                return;
            }
            return;
        }
        if (this.bAg == null) {
            this.bAg = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.bAg.by(com.baidu.tieba.z.download_iqiyi_app_dialog);
            this.bAg.a(com.baidu.tieba.z.install_app, new aq(this));
            this.bAg.b(com.baidu.tieba.z.webpage_play, new ar(this));
            this.bAg.ai(false);
        }
        this.bAg.b(getPageContext()).nX();
    }

    private DialogInterface Xv() {
        if (this.bAn == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
            builder.setTitle(getPageContext().getString(com.baidu.tieba.z.download_baidu_video_dialog));
            builder.setPositiveButton(getPageContext().getString(com.baidu.tieba.z.install), new as(this));
            builder.setNegativeButton(getPageContext().getString(com.baidu.tieba.z.cancel), new au(this));
            builder.setCancelable(true);
            this.bAn = builder.create();
            this.bAn.setCanceledOnTouchOutside(false);
        }
        com.baidu.adp.lib.g.k.a(this.bAn, getPageContext());
        return this.bAn;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onVideoClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (hA(str) || z) {
                boolean u = com.baidu.adp.lib.util.l.u(context, "com.qiyi.video");
                hB(str);
                if (u) {
                    Xt();
                    return;
                } else {
                    Xu();
                    return;
                }
            }
            com.baidu.tbadk.browser.a.x(getPageContext().getPageActivity(), str);
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
            Xv();
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
            this.bAQ = true;
        }
        if (aVar != null) {
            int size = aVar.Af().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.Af().get(i6) != null && aVar.Af().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.Af().get(i6).Ak().getWidth();
                    int height = aVar.Af().get(i6).Ak().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.Af().get(i6).Ak().Ar()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        arrayList.add(b(aVar.Af().get(i6)));
                        if (!this.bAQ) {
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
            if (kVar.getId() != null && kVar.getId().equals(this.bAs.nz())) {
                z = true;
            }
            MarkData c = this.bAs.c(kVar);
            if (c != null && gY(11009)) {
                this.bAx.YF();
                this.bAt.b(c);
                if (!z) {
                    this.bAt.ll();
                } else {
                    this.bAt.lm();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a R(String str, int i) {
        if (this.bAs == null || this.bAs.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.tbadkCore.b.i pbData = this.bAs.getPbData();
        com.baidu.tbadk.widget.richText.a a = a(pbData.ahk(), str, i);
        if (a == null) {
            ArrayList<com.baidu.tieba.tbadkCore.b.k> ahk = pbData.ahk();
            int size = ahk.size();
            for (int i2 = 0; i2 < size; i2++) {
                a = a(ahk.get(i2).ahx(), str, i);
                if (a != null) {
                    return a;
                }
            }
            return a;
        }
        return a;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.b.k> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> Af;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a ahz = arrayList.get(i2).ahz();
            if (ahz != null && (Af = ahz.Af()) != null) {
                int size = Af.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Af.get(i4) != null && Af.get(i4).getType() == 8) {
                        i3++;
                        if (Af.get(i4).Ak().As().equals(str)) {
                            int width = Af.get(i4).Ak().getWidth();
                            int height = Af.get(i4).Ak().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.bAP = i4;
                            return ahz;
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
        com.baidu.tbadk.widget.richText.g Ak = cVar.Ak();
        if (Ak != null) {
            if (!StringUtils.isNull(Ak.Aq())) {
                return Ak.Aq();
            }
            if (Ak.getHeight() * Ak.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Ak.getHeight() * Ak.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Ak.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Ak.getHeight())));
            } else {
                float width = Ak.getWidth() / Ak.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.bf.aE(Ak.getSrc()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onPhoneClicked(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mPhoneNumber = str;
            if (this.bAm == null) {
                Xk();
            }
            com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "pb_show_phonedialog");
            if (str2.equals("2")) {
                this.bAm.bH(1).setVisibility(8);
            } else {
                this.bAm.bH(1).setVisibility(0);
            }
            this.bAm.nZ();
        }
    }

    @Override // com.baidu.tbadk.core.voice.o
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xw() {
        hideNetRefreshView(this.bAx.getView());
        showLoadingView(this.bAx.getView(), true);
        if (this.bAs.xL()) {
            this.bAx.YF();
        }
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m getRealView(VoiceData.VoiceModel voiceModel) {
        View Zl;
        View findViewWithTag;
        if (!this.bAx.YO() || (Zl = this.bAx.Zl()) == null || (findViewWithTag = Zl.findViewWithTag(voiceModel)) == null) {
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
        if (this.bAs.UF()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.tbadkCore.b.i pbData = this.bAs.getPbData();
            String name = pbData.aeN().getName();
            String title = pbData.ahj().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.bAs.XK() + "?share=9105&fr=share";
            String[] ax = pbData.ax(getPageContext().getPageActivity());
            String str2 = ax[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String format = MessageFormat.format(getResources().getString(com.baidu.tieba.z.share_content_tpl), title, name, ax[1]);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.Tq = str;
            if (parse != null) {
                fVar.Tr = parse;
            }
            this.aKh = new com.baidu.tbadk.coreExtra.share.d(getPageContext().getPageActivity());
            this.aKh.a(fVar, true);
            this.aKh.a(getShareMtjStatInfo());
            this.aKh.ay(true);
            TextView w = this.aKh.w(com.baidu.tieba.z.share_tieba_qunzu, com.baidu.tieba.v.icon_unite_share_qunzu);
            this.aKh.a(w);
            TextView w2 = this.aKh.w(com.baidu.tieba.z.forum_friend, com.baidu.tieba.v.icon_unite_share_baf);
            this.aKh.a(w2);
            w2.setOnClickListener(new av(this));
            w.setOnClickListener(new aw(this));
            this.aKh.d(new ax(this, fVar));
            this.aKh.show();
        }
    }

    private SparseArray<String> getShareMtjStatInfo() {
        if (this.aKk == null) {
            this.aKk = new SparseArray<>(7);
            this.aKk.put(2, "pb_wx_timeline");
            this.aKk.put(3, "pb_wx_friend");
            this.aKk.put(4, "pb_qq_zone");
            this.aKk.put(5, "pb_tencent_weibo");
            this.aKk.put(6, "pb_sina_weibo");
            this.aKk.put(7, "pb_renren");
        }
        return this.aKk;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool() {
        if (this.akj == null) {
            this.akj = new com.baidu.adp.lib.e.b<>(new ay(this), 15, 0);
        }
        return this.akj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xx() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.tbadkCore.b.i pbData = this.bAs.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.mR().isIfAddition();
            AdditionData ahm = pbData.ahm();
            boolean z3 = ahm == null ? false : isIfAddition;
            if (z3) {
                z = ahm.getAlreadyCount() != ahm.getTotalCount();
                if (!TextUtils.isEmpty(ahm.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.main.b.a aVar = this.bAx.bCY;
            if (!z3 || !z) {
                z2 = false;
            }
            aVar.ec(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bAx.Yr() == view) {
            com.baidu.tbadk.core.data.x ahj = this.bAs.getPbData().ahj();
            View childAt = ((ViewGroup) view).getChildAt(0);
            if (childAt != null) {
                boolean z = ahj.getPraise() == null || ahj.getPraise().getIsLike() == 0;
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

    public void Gj() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }
}
