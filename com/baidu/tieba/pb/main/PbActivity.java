package com.baidu.tieba.pb.main;

import android.app.Activity;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.BaobaoSdkDelegate;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.frs.df;
import com.baidu.tieba.util.AntiHelper;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity implements View.OnTouchListener, com.baidu.tbadk.core.view.ae, com.baidu.tbadk.core.voice.o, com.baidu.tbadk.widget.richText.j, com.baidu.tieba.util.m {
    private static String aQm = "tbgametype";
    private com.baidu.adp.lib.e.b<TbImageView> Iv;
    private com.baidu.adp.lib.e.b<ImageView> abR;
    private com.baidu.adp.lib.e.b<TextView> abS;
    private com.baidu.adp.lib.e.b<View> abT;
    private com.baidu.adp.lib.e.b<LinearLayout> abU;
    private com.baidu.adp.lib.e.b<GifView> abV;
    private com.baidu.tieba.location.d ayB;
    private String ayG;
    private VoiceManager ayx;
    private String buE;
    private AlertDialog buN;
    private String buO;
    private VoiceData.VoiceModel buP;
    private String bvf;
    private boolean aiS = false;
    private boolean aAr = true;
    private boolean buG = false;
    private com.baidu.tbadk.core.dialog.a buH = null;
    private String buI = null;
    private String atx = null;
    private String buJ = null;
    private String buK = null;
    private String mPackageName = null;
    private int buL = 0;
    private com.baidu.tbadk.core.dialog.i buM = null;
    SparseArray<String> aIo = null;
    private long aAU = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private WriteData aAW = new WriteData();
    private long Zf = 0;
    private long createTime = 0;
    private long Zg = 0;
    private boolean buQ = false;
    private com.baidu.tbadk.performanceLog.a buR = null;
    public long buS = System.currentTimeMillis();
    private String buT = null;
    private final Handler mHandler = new Handler(new b(this));
    private bn buU = null;
    private com.baidu.tieba.model.aj buV = null;
    private com.baidu.tieba.model.ar ayI = null;
    private com.baidu.tieba.model.ad buW = null;
    private com.baidu.tieba.pb.sub.e buX = null;
    private com.baidu.tieba.model.v buY = null;
    private bv buZ = null;
    public final com.baidu.tieba.pb.main.a.a bva = new com.baidu.tieba.pb.main.a.a(this);
    private boolean bvb = false;
    private boolean bvc = false;
    private MorePopupWindow bvd = null;
    private bu bve = null;
    private boolean aAt = false;
    private com.baidu.tieba.location.i ayM = new x(this);
    private com.baidu.tieba.location.j ayN = new ai(this);
    private boolean ayC = false;
    private df ayR = new df(this, new at(this));
    private long azc = 0;
    private boolean azd = true;
    public final View.OnClickListener aDg = new ba(this);
    private final bq bvg = new bc(this);
    private final com.baidu.tieba.model.al bvh = new bd(this);
    private final AbsListView.OnScrollListener uN = new be(this);
    private final AbsListView.OnScrollListener bvi = new c(this);
    private final com.baidu.tieba.pb.sub.g bvj = new d(this);
    private final com.baidu.tieba.model.as ayL = new e(this);
    private final com.baidu.adp.base.h bvk = new f(this);
    private final bg bvl = new g(this);
    private final com.baidu.adp.widget.ListView.f aQN = new h(this);
    private final com.baidu.adp.widget.ListView.aa bvm = new i(this);
    private final com.baidu.adp.widget.ListView.ad bvn = new j(this);
    private final DialogInterface.OnClickListener baA = new k(this);
    private final com.baidu.adp.base.h bvo = new l(this);
    private AlertDialog ayP = null;
    private final cw bvp = new n(this);
    private int bvq = 0;
    private final com.baidu.tbadk.widget.richText.s ack = new o(this);
    boolean bvr = false;
    com.baidu.tieba.data.ak bvs = null;
    private final DialogInterface.OnClickListener bvt = new p(this);
    private final View.OnLongClickListener NY = new q(this);
    private final com.baidu.tbadk.core.view.u aBm = new r(this);
    com.baidu.tbadk.coreExtra.share.d aIl = null;

    static {
        HQ();
        Wb();
        CustomMessageTask customMessageTask = new CustomMessageTask(2004001, new m());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        Wc();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m251getInst().isGpuOpen();
    }

    private static void HQ() {
        com.baidu.tieba.ai.a(302001, pbPageSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, com.baidu.tieba.ai.s("c/f/pb/page", 302001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.location.d.Sx();
    }

    private static void Wb() {
        com.baidu.tieba.ai.b(2004003, cx.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ey() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this)));
    }

    public void Ez() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this)) {
            showToast(com.baidu.tieba.y.location_system_permission_prompt);
        } else if (!TbadkApplication.m251getInst().getLocationShared()) {
            EA();
        } else if (this.ayB.Sw()) {
            Ey();
        } else {
            this.ayB.dx(false);
            if (this.buZ.EQ() != null) {
                this.buZ.EQ().setLocationViewVisibility(0);
                this.buZ.EQ().setLocationInfoViewState(1);
            }
            this.ayB.Su();
        }
    }

    private void EA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.aX(com.baidu.tieba.y.location_app_permission_prompt).a(com.baidu.tieba.y.isopen, new s(this)).b(com.baidu.tieba.y.cancel, new t(this)).kT();
        aVar.kW();
    }

    public void EB() {
        if (this.buZ.EQ() != null) {
            if (this.ayB.Sy()) {
                this.buZ.EQ().setLocationViewVisibility(0);
                if (this.ayB.Sw()) {
                    this.ayM.a(com.baidu.tieba.location.c.Sr().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.m.isNetOk()) {
                    this.buZ.EQ().setLocationInfoViewState(1);
                    this.ayB.Su();
                    return;
                } else {
                    this.buZ.EQ().setLocationInfoViewState(0);
                    return;
                }
            }
            this.buZ.EQ().setLocationViewVisibility(8);
        }
    }

    private static void Wc() {
        com.baidu.tbadk.core.util.bg.mR().a(new u());
    }

    private void Bs() {
        this.buZ.Bv();
        this.buZ.Xq();
    }

    private void Bt() {
        this.buZ.Bu();
        this.buZ.Xs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wd() {
        com.baidu.tieba.data.ah pbData;
        com.baidu.tbadk.core.data.q zM;
        if (!this.ayC) {
            if (!com.baidu.adp.lib.util.m.isNetOk()) {
                showToast(com.baidu.tieba.y.no_network_guide);
            } else if (this.azd) {
                this.ayC = true;
                if (this.buU != null && (pbData = this.buU.getPbData()) != null && (zM = pbData.zM()) != null) {
                    int isLike = zM.getPraise() == null ? 0 : zM.getPraise().getIsLike();
                    if (this.ayR != null) {
                        this.ayR.a(zM.kG(), zM.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eD(int i) {
        com.baidu.tbadk.core.data.q zM;
        String sb;
        String sb2;
        if (this.buU != null && this.buU.getPbData() != null && (zM = this.buU.getPbData().zM()) != null) {
            if (i == 1) {
                PraiseData praise = zM.getPraise();
                AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
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
                        zM.setPraise(praiseData);
                    } else {
                        zM.getPraise().getUser().add(0, metaData);
                        zM.getPraise().setNum(zM.getPraise().getNum() + 1);
                        zM.getPraise().setIsLike(i);
                    }
                }
                if (zM.getPraise() != null) {
                    if (zM.getPraise().getNum() < 1) {
                        sb2 = getResources().getString(com.baidu.tieba.y.frs_item_praise_text);
                    } else {
                        sb2 = new StringBuilder(String.valueOf(zM.getPraise().getNum())).toString();
                    }
                    this.buZ.B(sb2, true);
                }
            } else if (zM.getPraise() != null) {
                zM.getPraise().setIsLike(i);
                zM.getPraise().setNum(zM.getPraise().getNum() - 1);
                ArrayList<MetaData> user = zM.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkApplication.getCurrentAccountObj().getID())) {
                            zM.getPraise().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (zM.getPraise().getNum() < 1) {
                    sb = getResources().getString(com.baidu.tieba.y.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(zM.getPraise().getNum())).toString();
                }
                this.buZ.B(sb, false);
            }
            if (this.buU.WJ()) {
                this.buZ.Xw().notifyDataSetChanged();
            } else {
                this.buZ.f(this.buU.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.buU.saveToBundle(bundle);
        if (this.buU.WM()) {
            this.buX.saveToBundle(bundle);
        }
        if (this.ayx != null) {
            this.ayx.onSaveInstanceState(this);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ayG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.aAU = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aAU = System.currentTimeMillis();
        }
        this.buL = 0;
        initUI();
        this.ayx = new VoiceManager();
        this.ayx.onCreate(this);
        d(bundle);
        addGlobalLayoutListener();
        this.createTime = System.currentTimeMillis() - this.aAU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.buZ != null) {
            if (this.buZ.EQ() != null) {
                this.buZ.EQ().BG();
            }
            if (this.buZ.Xr() != null && this.buZ.Xr().EQ() != null) {
                this.buZ.Xr().EQ().BG();
            }
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.ayx != null) {
            this.ayx.onStart(this);
        }
    }

    public bn We() {
        return this.buU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.aiS = true;
        super.onPause();
        BdListView listView = getListView();
        this.buL = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.buL == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.ayx != null) {
            this.ayx.onPause(this);
        }
        if (this.buZ != null) {
            this.buZ.onPause();
        }
        if (!this.buU.WM()) {
            WriteData EE = this.ayI.EE();
            if (EE == null) {
                EE = new WriteData(1);
                EE.setThreadId(this.buU.WI());
                EE.setWriteImagesInfo(this.writeImagesInfo);
            }
            EE.setContent(this.buZ.EW());
            if (this.aAW != null && this.aAW.getIsBaobao()) {
                EE.setBaobaoContent(this.aAW.getBaobaoContent());
                EE.setBaobaoImagesInfo(this.baobaoImagesInfo);
                EE.setIsBaobao(true);
            }
            com.baidu.tieba.util.l.b(this.buU.WI(), EE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        this.aiS = false;
        super.onResume();
        if (this.buL == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView Xj = this.buZ.Xj();
        if (Xj != null && Xj.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            Xj.Z(false);
        }
        if (this.ayx != null) {
            this.ayx.onResume(this);
        }
        if (this.buZ.EQ() != null) {
            this.buZ.EQ().refresh();
        }
    }

    @Override // com.baidu.tieba.util.m
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!com.baidu.tbadk.core.util.az.aA(writeData.getContent()) && com.baidu.tbadk.core.util.az.aA(this.buZ.EW())) {
                this.buO = writeData.getContent();
                this.buZ.fc(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                this.buZ.a(this.writeImagesInfo, true);
            }
            if (TbadkApplication.m251getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.aAW.setIsBaobao(writeData.getIsBaobao());
                this.aAW.setBaobaoContent(writeData.getBaobaoContent());
                this.aAW.setBaobaoImagesInfo(this.baobaoImagesInfo);
                this.buZ.setBaobaoUris(this.baobaoImagesInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.buZ.EQ() != null && this.buZ.EQ().getVisibility() != 0) {
            Wg();
            this.buZ.Xm();
        }
        if (!this.buZ.XM()) {
            this.buZ.XO();
        }
        this.buZ.bxx.Yu();
        if (this.buU != null && this.buU.getPbData() != null && this.buU.getPbData().zL() != null && this.buU.getPbData().zM() != null) {
            com.baidu.tbadk.distribute.a.rc().a(this, "pb", this.buU.getPbData().zL().getId(), com.baidu.adp.lib.g.c.a(this.buU.getPbData().zM().getId(), 0L));
        }
        if (this.ayx != null) {
            this.ayx.onStop(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (!this.buQ) {
            this.buQ = true;
            this.buZ.Yn();
        }
        this.buU.cancelLoadData();
        this.buU.ya();
        this.ayI.cancelLoadData();
        this.buW.cancelLoadData();
        this.ayB.cancelLoadData();
        this.buX.cancelLoadData();
        this.buX.ya();
        this.buY.cancelLoadData();
        this.buZ.onDestroy();
        if (this.buR != null) {
            this.buR.onDestroy();
        }
        super.onDestroy();
        if (this.ayx != null) {
            this.ayx.onDestory(this);
        }
    }

    public void Wf() {
        if (this.buZ.EQ() != null) {
            this.buZ.EQ().setContent(this.buO == null ? "" : this.buO);
            if (this.buP != null) {
                this.buZ.EQ().BQ();
            }
            this.buZ.a(this.writeImagesInfo, true);
            this.buZ.setBaobaoUris(this.baobaoImagesInfo);
            if (!StringUtils.isNull(this.buO) || this.buP != null) {
                this.buZ.EQ().BZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wg() {
        if (this.buZ.EQ() != null) {
            this.buO = this.buZ.EQ().getContent();
            this.buP = this.buZ.getAudioData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.buZ.onChangeSkinType(i);
        if (this.bvd != null) {
            this.bvd.onChangeSkinType(this, i, com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.bg_collect));
        }
        if (this.buZ.Xj() != null) {
            this.buZ.Xj().onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wh() {
        this.bve = new bu(this, this.aDg);
        this.bvd = new MorePopupWindow(this, this.bve.getView(), getResources().getDrawable(com.baidu.tieba.u.bg_collect), null);
        this.bvd.setTouchInterceptor(new v(this));
        this.bvd.onChangeSkinType(this, TbadkApplication.m251getInst().getSkinType(), com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.bg_collect));
    }

    private void initUI() {
        this.buZ = new bv(this, this.aDg);
        this.buZ.setOnActionListener(new w(this));
        this.buZ.setOnScrollListener(this.uN);
        this.buZ.a(this.bvi);
        this.buZ.c(this.bvm);
        this.buZ.a(this.bvn);
        this.buZ.e(this.baA);
        this.buZ.a(this.aQN);
        this.buZ.dX(com.baidu.tbadk.core.l.js().jw());
        this.buZ.dY(com.baidu.tbadk.core.l.js().ju());
        this.buZ.setOnImageClickListener(this.ack);
        this.buZ.b(this.NY);
        this.buZ.a(this.bvp);
        this.buZ.f(this.aBm);
        this.buZ.a(this.bvl);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.buG) {
            if (this.aAr) {
                this.aAr = false;
                showLoadingView(this.buZ.getView(), true);
                return;
            }
            return;
        }
        hideLoadingView(this.buZ.getView());
    }

    private void Wi() {
        if (this.buM == null) {
            this.buM = new com.baidu.tbadk.core.dialog.i(this);
            this.buM.a(new Object[]{getString(com.baidu.tieba.y.call_phone), getString(com.baidu.tieba.y.sms_phone), getString(com.baidu.tieba.y.search_in_baidu)}, new y(this)).bd(com.baidu.tbadk.core.dialog.k.BI).be(80).kZ();
        }
    }

    private void d(Bundle bundle) {
        this.buU = new bn(this);
        this.buU.a(this.bvg);
        this.buV = new com.baidu.tieba.model.aj(this);
        this.buV.a(this.bvh);
        this.ayI = new com.baidu.tieba.model.ar(this);
        this.ayI.a(this.ayL);
        this.buW = new com.baidu.tieba.model.ad(this);
        this.buW.setLoadDataCallBack(this.bvo);
        this.buX = new com.baidu.tieba.pb.sub.e(this);
        this.buX.a(this.bvj);
        this.buY = new com.baidu.tieba.model.v(this);
        this.buY.setLoadDataCallBack(this.bvk);
        this.ayB = new com.baidu.tieba.location.d(this);
        this.ayB.a(this.ayM);
        this.ayB.a(this.ayN);
        if (bundle != null) {
            this.buU.initWithBundle(bundle);
        } else {
            this.buU.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, -1) == 18003) {
            this.buU.ec(true);
        }
        bs.Xc().A(this.buU.WG(), this.buU.getIsFromMark());
        if (!this.buU.WM()) {
            this.buZ.XD();
            this.buU.tN();
        } else {
            if (bundle != null) {
                this.buX.initWithBundle(bundle);
            } else {
                this.buX.initWithIntent(getIntent());
            }
            this.bvf = this.buX.zX();
            String stType = this.buX.getStType();
            if (stType != null && (("mention".equals(this.buX.getStType()) || stType.equals("person_post_reply")) && this.bvf != null)) {
                this.buZ.XQ();
            } else {
                this.buZ.XJ();
            }
            this.buX.YS();
        }
        this.buZ.a(new z(this));
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.ayG = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!this.buU.WM()) {
            com.baidu.tieba.util.l.a(this.buU.WI(), this);
        }
        this.ayR.setUniqueId(getUniqueId());
        this.ayR.registerListener();
    }

    public void Wj() {
        this.buZ.bxx.e(this.buU.WJ(), this.buV.zP());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.data.ak akVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (akVar = (com.baidu.tieba.data.ak) sparseArray.get(com.baidu.tieba.v.tag_clip_board)) != null) {
            b(akVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        Wu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Boolean bool) {
        com.baidu.tieba.data.ah pbData;
        String str = null;
        if (this.buU != null && (pbData = this.buU.getPbData()) != null && pbData.zL() != null) {
            str = pbData.zL().getName();
        }
        if (com.baidu.tieba.e.b.b(str, bool)) {
            Bt();
        } else {
            Bs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Boolean bool) {
        if (com.baidu.tieba.e.b.b(str, bool)) {
            Bt();
        } else {
            Bs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            if (!this.buU.WM()) {
                antiData.setBlock_forum_name(this.buU.getPbData().zL().getName());
                antiData.setBlock_forum_id(this.buU.getPbData().zL().getId());
                antiData.setUser_name(this.buU.getPbData().getUserData().getUserName());
                antiData.setUser_id(this.buU.getPbData().getUserData().getUserId());
            } else {
                antiData.setBlock_forum_name(this.buX.YN().Ay().getName());
                antiData.setBlock_forum_id(this.buX.YN().Ay().getId());
                antiData.setUser_name(TbadkApplication.getCurrentAccountName());
                antiData.setUser_id(TbadkApplication.getCurrentAccount());
            }
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        this.buZ.showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.x xVar) {
        int i = 0;
        if (xVar != null) {
            this.buZ.a(0, xVar.qa, xVar.bpc, true);
            if (xVar.qa) {
                if (xVar.boY == 1) {
                    ArrayList<com.baidu.tieba.data.ak> zN = this.buU.getPbData().zN();
                    int size = zN.size();
                    while (true) {
                        if (i < size) {
                            if (!xVar.mPostId.equals(zN.get(i).getId())) {
                                i++;
                            } else {
                                zN.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.buZ.e(this.buU.getPbData());
                } else if (xVar.boY == 0) {
                    Wk();
                } else if (xVar.boY == 2) {
                    ArrayList<com.baidu.tieba.data.ak> zN2 = this.buU.getPbData().zN();
                    int size2 = zN2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < zN2.get(i2).Ad().size()) {
                                if (!xVar.mPostId.equals(zN2.get(i2).Ad().get(i3).getId())) {
                                    i3++;
                                } else {
                                    zN2.get(i2).Ad().remove(i3);
                                    zN2.get(i2).Ae();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData zT = this.buU.getPbData().zT();
                        com.baidu.tieba.data.ak akVar = zN2.get(i2);
                        ArrayList<com.baidu.tieba.data.ak> Af = akVar.Af();
                        int size3 = Af.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!xVar.mPostId.equals(zN2.get(i2).Af().get(i4).getId())) {
                                    i4++;
                                } else {
                                    Af.remove(i4);
                                    zT.decreaseAlreadyCount();
                                    if (akVar.Am() > Af.size()) {
                                        akVar.eh(Af.size());
                                    }
                                    if (Af.size() > 0) {
                                        com.baidu.tieba.data.ak akVar2 = Af.get(Af.size() - 1);
                                        zT.setLastAdditionTime(akVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a Ah = akVar2.Ah();
                                        String str = "";
                                        if (Ah != null) {
                                            str = Ah.toString();
                                        }
                                        zT.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a Ah2 = akVar.Ah();
                                        String str2 = "";
                                        if (Ah2 != null) {
                                            str2 = Ah2.toString();
                                        }
                                        zT.setLastAdditionContent(str2);
                                    }
                                    Wv();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.buZ.e(this.buU.getPbData());
                    }
                    if (this.buZ.XM()) {
                        this.buX.hb(xVar.mPostId);
                        this.buZ.a(this.buX.YN(), this.buU.getPbData().zS());
                        if (!z) {
                            String zX = this.buX.zX();
                            while (i < size2) {
                                if (!zX.equals(zN2.get(i).getId())) {
                                    i++;
                                } else {
                                    zN2.get(i).Ae();
                                    this.buZ.e(this.buU.getPbData());
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
    public void a(com.baidu.tieba.model.z zVar) {
        this.buZ.a(1, zVar.qa, zVar.bpc, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.ab abVar) {
        this.buZ.a(this.buY.getLoadDataMode(), abVar.qa, abVar.bpc, false);
        this.buZ.C(abVar.bpf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.model.ab abVar) {
        if (abVar != null) {
            this.buZ.a(this.buY.getLoadDataMode(), abVar.qa, abVar.bpc, true);
            if (abVar.qa) {
                this.bvc = true;
                if (i == 2) {
                    this.buU.getPbData().zM().aU(1);
                    this.buU.setIsGood(1);
                } else if (i == 3) {
                    this.buU.getPbData().zM().aU(0);
                    this.buU.setIsGood(0);
                } else if (i == 4) {
                    this.buU.getPbData().zM().aT(1);
                    this.buU.gK(1);
                } else if (i == 5) {
                    this.buU.getPbData().zM().aT(0);
                    this.buU.gK(0);
                }
                this.buZ.a(this.buU.getPbData(), this.buU.WJ(), true);
            }
        }
    }

    private void Wk() {
        if (this.buU.WK()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.buU.WI());
            setResult(-1, intent);
        }
        if (Wq()) {
            super.closeActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wl() {
        super.closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        this.buZ.Yg();
        if (this.buU != null && this.buU.getPbData() != null) {
            com.baidu.tieba.pb.history.f fVar = new com.baidu.tieba.pb.history.f(this);
            com.baidu.tieba.data.ai aiVar = new com.baidu.tieba.data.ai();
            aiVar.setThreadId(this.buU.getPbData().zM().getId());
            aiVar.setForumName(this.buU.getPbData().zL().getName());
            aiVar.ex(this.buU.getPbData().zM().getTitle());
            ArrayList<com.baidu.tieba.data.ak> zN = this.buU.getPbData().zN();
            int XS = this.buZ.XS();
            if (zN != null && XS >= 0 && XS < zN.size()) {
                aiVar.ey(zN.get(XS).getId());
            }
            aiVar.bt(this.buU.getHostMode());
            aiVar.bu(this.buU.WJ());
            fVar.a((com.baidu.tieba.pb.history.f) aiVar);
        }
        if (this.buU != null && this.buU.WK()) {
            Intent intent = new Intent();
            if (this.bvc) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.buU.WI());
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.buU.WL());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.buU.getIsGood());
            }
            setResult(-1, intent);
        }
        if (Wq()) {
            if (this.buU != null && this.buZ != null && this.buZ.uf() != null) {
                com.baidu.tieba.data.ah pbData = this.buU.getPbData();
                if (pbData != null && pbData.getUserData() != null) {
                    pbData.getUserData().setBimg_url(TbadkApplication.m251getInst().getDefaultBubble());
                }
                bs.Xc().a(this.buU.getPbData(), this.buZ.uf().onSaveInstanceState(), this.buU.WJ(), this.buU.getHostMode());
            } else {
                bs.Xc().reset();
            }
            super.closeActivity();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.bvd != null) {
                    com.baidu.adp.lib.g.j.a(this.bvd, this);
                }
                if (this.buZ.ej(this.buU.WM())) {
                    EC();
                    return true;
                }
                closeActivity();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean gJ(int i) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, i);
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
                    eX(null);
                    return;
                case 11009:
                    Wo();
                    return;
                case LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_11_025 /* 11025 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this, 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this, 12005, true)));
                    return;
                case 11027:
                    eX(this.buZ.XU());
                    return;
                case 12001:
                    g(intent);
                    if (this.writeImagesInfo != null && this.writeImagesInfo.size() - 1 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size2 = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this, 12012, this.writeImagesInfo, size)));
                        return;
                    }
                    return;
                case 12002:
                    e(intent);
                    return;
                case 12003:
                    if (intent != null) {
                        Wn();
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            this.buZ.XR();
                            this.ayI.dI(false);
                            return;
                        }
                        this.buW.gS(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    Wn();
                    ArrayList<String> p = com.baidu.tieba.util.i.p(intent);
                    if (p != null) {
                        this.buZ.p(p);
                        return;
                    }
                    return;
                case 12005:
                    Wn();
                    new Handler().postDelayed(new aa(this), 200L);
                    ArrayList<String> p2 = com.baidu.tieba.util.i.p(intent);
                    if (p2 != null) {
                        this.buZ.D(p2);
                        return;
                    }
                    return;
                case 12006:
                    WriteData EE = this.ayI.EE();
                    if (EE != null) {
                        EE.deleteUploadedTempImages();
                    }
                    this.aAW.setIsBaobao(false);
                    this.aAW.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.ayI.b((WriteData) null);
                    this.ayI.dI(false);
                    this.buZ.bQ(true);
                    if (this.buZ.XM()) {
                        this.buX.YQ();
                    } else {
                        if (this.buU != null && this.buU.WP()) {
                            this.buZ.XD();
                        }
                        if (this.buU != null && this.buU.WI() != null && !this.buU.WM()) {
                            com.baidu.tieba.util.l.b(this.buU.WI(), (WriteData) null);
                        }
                    }
                    this.buZ.a(this.writeImagesInfo, true);
                    return;
                case 12009:
                case 12010:
                    Wn();
                    if (i == 12010) {
                        g(intent);
                        return;
                    }
                    return;
                case 12012:
                    f(intent);
                    return;
                case 12013:
                    h(intent);
                    return;
                case 13008:
                    bs.Xc().reset();
                    this.mHandler.postDelayed(new ab(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.buU != null) {
                        a(Wm(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getIntExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0));
                        return;
                    }
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                    return;
                case 23007:
                    l(intent);
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                EF();
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
                Wn();
                return;
        }
    }

    private ShareFromPBMsgData Wm() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] N = this.buU.getPbData().N(this);
        com.baidu.tieba.data.ak Xl = this.buZ.Xl();
        String str = "";
        if (Xl != null) {
            str = Xl.getId();
            String R = Xl.R(this);
            if (!com.baidu.adp.lib.util.l.aA(R)) {
                N[1] = R;
            }
        }
        String kG = this.buU.getPbData().zM().kG();
        if (kG != null && kG.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(N[1]);
        shareFromPBMsgData.setImageUrl(N[0]);
        shareFromPBMsgData.setForumName(this.buU.getPbData().zL().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.buU.getPbData().zM().getId());
        shareFromPBMsgData.setTitle(this.buU.getPbData().zM().getTitle());
        return shareFromPBMsgData;
    }

    private void l(Intent intent) {
        a(Wm(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.buU != null && this.buU.getPbData() != null && this.buU.getPbData().zM() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
            aVar.bf(this.buU.getPbData().zM().getTitle());
            cy cyVar = new cy(this);
            cyVar.setData(shareFromPBMsgData);
            aVar.j(cyVar);
            aVar.a(com.baidu.tieba.y.share, new ac(this, j, str, str2, cyVar, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.y.alert_no_button, new ad(this, cyVar));
            aVar.P(false);
            aVar.kT().kW();
            if (!com.baidu.adp.lib.util.l.aA(shareFromPBMsgData.getImageUrl())) {
                cyVar.C(shareFromPBMsgData.getImageUrl(), this.buU.getPbData().yW() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, int i2) {
        if (this.buU != null && this.buU.getPbData() != null && this.buU.getPbData().zM() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
            aVar.bf(this.buU.getPbData().zM().getTitle());
            cy cyVar = new cy(this);
            cyVar.setData(shareFromPBMsgData);
            aVar.j(cyVar);
            aVar.a(com.baidu.tieba.y.share, new ae(this, i, str, i2, cyVar, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.y.alert_no_button, new af(this, cyVar));
            aVar.P(false);
            aVar.kT().kW();
            if (!com.baidu.adp.lib.util.l.aA(shareFromPBMsgData.getImageUrl())) {
                cyVar.C(shareFromPBMsgData.getImageUrl(), this.buU.getPbData().yW() == 1);
            }
        }
    }

    private void e(Intent intent) {
        a(intent, true);
    }

    private void g(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ayG;
        if (!TextUtils.isEmpty(str)) {
            try {
                int bl = com.baidu.tbadk.core.util.d.bl(str);
                if (bl != 0) {
                    Bitmap a = com.baidu.tbadk.core.util.d.a(str, com.baidu.adp.lib.util.m.dip2px(this, com.baidu.adp.lib.util.m.n(this)), com.baidu.adp.lib.util.m.dip2px(this, com.baidu.adp.lib.util.m.o(this)));
                    Bitmap e = com.baidu.tbadk.core.util.d.e(a, bl);
                    if (a != e) {
                        a.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.ayG, e, 100);
                    e.recycle();
                }
            } catch (Exception e2) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            this.buZ.a(this.writeImagesInfo, true);
        }
        if (this.buZ.EQ() != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            this.buZ.EQ().er(23);
        }
    }

    private void f(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    this.buZ.a(this.writeImagesInfo, z);
                }
            }
            if (this.buZ.EQ() != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                this.buZ.EQ().er(23);
            }
        }
    }

    private void h(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(BaobaoSdkDelegate.KEY_BITMAPPATH);
            String stringExtra2 = intent.getStringExtra(BaobaoSdkDelegate.KEY_CONTENT);
            if (stringExtra != null && stringExtra2 != null) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(stringExtra);
                this.baobaoImagesInfo.clear();
                this.baobaoImagesInfo.addChooseFile(imageFileInfo);
                this.buZ.setBaobaoUris(this.baobaoImagesInfo);
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    if (this.buZ.EQ() != null) {
                        this.buZ.EQ().er(50);
                    }
                    this.aAW.setIsBaobao(true);
                    this.aAW.setBaobaoContent(stringExtra2);
                    this.aAW.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.aAW.setIsBaobao(false);
                this.aAW.setBaobaoContent("");
                this.aAW.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void EF() {
        new ag(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ED() {
        if (this.ayP == null) {
            String[] strArr = {getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.y.operation));
            builder.setItems(strArr, new ah(this));
            this.ayP = builder.create();
            this.ayP.setCanceledOnTouchOutside(true);
        }
    }

    private void Wn() {
        if (this.bvb) {
            this.bvb = false;
            new Handler().postDelayed(new aj(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wo() {
        MarkData gQ = this.buU.gQ(this.buZ.XS());
        if (gQ != null) {
            this.buZ.XD();
            this.buV.b(gQ);
            if (!this.buV.zP()) {
                this.buV.TL();
                TiebaStatic.eventStat(this, "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.buV.TM();
            TiebaStatic.eventStat(this, "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(String str) {
        VoiceData.VoiceModel Xt;
        if (this.ayI.EE() == null) {
            if (!this.buU.WM()) {
                this.ayI.b(this.buU.gW(str));
            } else {
                this.ayI.b(this.buX.EE());
            }
        }
        if (this.ayI.EE() != null) {
            if (!this.buU.WM()) {
                this.ayI.EE().setWriteImagesInfo(this.writeImagesInfo);
                this.ayI.dI(this.writeImagesInfo.size() > 0);
                if (this.aAW.getIsBaobao()) {
                    this.ayI.EE().setIsBaobao(true);
                    this.ayI.EE().setBaobaoContent(this.aAW.getBaobaoContent());
                    this.ayI.EE().setBaobaoImagesInfo(this.baobaoImagesInfo);
                } else {
                    this.ayI.EE().setIsBaobao(false);
                }
            }
            if (this.buZ.EQ() != null) {
                this.ayI.EE().setHasLocationData(this.buZ.EQ().getLocationInfoViewState() == 2);
            }
            if (str == null) {
                this.ayI.EE().setContent(this.buZ.EW());
                Xt = this.buZ.getAudioData();
                this.buZ.BS();
            } else {
                this.ayI.EE().setContent(this.buZ.XT());
                this.ayI.EE().setRepostId(this.buZ.XV());
                Xt = this.buZ.Xt();
                this.buZ.Xu();
            }
            if (Xt != null) {
                if (Xt.getId() != null) {
                    this.ayI.EE().setVoice(Xt.getId());
                    this.ayI.EE().setVoiceDuringTime(Xt.duration);
                } else {
                    this.ayI.EE().setVoice(null);
                    this.ayI.EE().setVoiceDuringTime(-1);
                }
            } else {
                this.ayI.EE().setVoice(null);
                this.ayI.EE().setVoiceDuringTime(-1);
            }
            if (!this.ayI.TV()) {
                showToast(com.baidu.tieba.y.write_img_limit);
            } else if (this.ayI.TU()) {
                this.buZ.EV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wp() {
        com.baidu.tieba.data.ah pbData = this.buU.getPbData();
        this.buU.eb(true);
        pbData.ew(this.buV.zQ());
        this.buZ.e(pbData);
    }

    private boolean Wq() {
        if (this.buU == null) {
            return true;
        }
        if (this.buU.zP()) {
            MarkData WU = this.buU.WU();
            if (WU == null || !this.buU.getIsFromMark()) {
                return true;
            }
            MarkData gQ = this.buU.gQ(this.buZ.XS());
            if (gQ == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, WU);
                setResult(-1, intent);
                Wl();
                return true;
            } else if (gQ.getPostId() == null || gQ.getPostId().equals(WU.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, WU);
                setResult(-1, intent2);
                Wl();
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
                aVar.bg(String.format(getString(com.baidu.tieba.y.alert_update_mark), Integer.valueOf(gQ.getFloor())));
                aVar.a(com.baidu.tieba.y.alert_yes_btn, new ak(this, gQ, WU));
                aVar.b(com.baidu.tieba.y.alert_no_button, new al(this, WU));
                aVar.kT();
                aVar.kW();
                return false;
            }
        } else if (this.buU.getPbData() == null || this.buU.getPbData().zN() == null || this.buU.getPbData().zN().size() <= 0 || !this.buU.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.ae
    /* renamed from: uf */
    public BdListView getListView() {
        if (this.buZ == null) {
            return null;
        }
        return this.buZ.uf();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int vP() {
        if (this.buZ == null) {
            return 0;
        }
        return this.buZ.XZ();
    }

    @Override // com.baidu.tbadk.core.view.ae
    public int nC() {
        if (this.buZ == null) {
            return 0;
        }
        return this.buZ.Ew();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<ImageView> vQ() {
        if (this.abR == null) {
            this.abR = new com.baidu.adp.lib.e.b<>(new am(this), 8, 0);
        }
        return this.abR;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<TextView> vR() {
        if (this.abS == null) {
            this.abS = TbRichTextView.i(this, 8);
        }
        return this.abS;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<GifView> vS() {
        if (this.abV == null) {
            this.abV = new com.baidu.adp.lib.e.b<>(new an(this), 20, 0);
        }
        return this.abV;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<View> vT() {
        if (this.abT == null) {
            this.abT = new com.baidu.adp.lib.e.b<>(new ao(this), 8, 0);
        }
        return this.abT;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public com.baidu.adp.lib.e.b<TbImageView> nD() {
        if (this.Iv == null) {
            this.Iv = UserIconBox.f(this, 8);
        }
        return this.Iv;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void s(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this, str, null)));
    }

    public boolean fB(String str) {
        Map<String, String> bT;
        if (!TextUtils.isEmpty(str) && (bT = com.baidu.tbadk.core.util.bg.bT(com.baidu.tbadk.core.util.bg.bU(str))) != null) {
            String str2 = bT.get(ImageViewerConfig.URL);
            if (!TextUtils.isEmpty(str2)) {
                return fB(com.baidu.adp.lib.util.l.aD(str2));
            }
            String str3 = bT.get(aQm);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void t(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (gU(str) || z) {
                boolean h = com.baidu.adp.lib.util.m.h(context, "com.qiyi.video");
                gV(str);
                if (h) {
                    Wr();
                } else {
                    Ws();
                }
            } else if (fB(str)) {
                com.baidu.tbadk.game.a.a(getApplicationContext(), null, str, null);
            } else {
                com.baidu.tbadk.core.util.bg.mR().b(context, new String[]{str});
            }
        }
    }

    private boolean gU(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }

    private void gV(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(";")) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.buJ = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.buK = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.atx = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.buI = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void Wr() {
        if (TextUtils.isEmpty(this.buJ) || TextUtils.isEmpty(this.buK) || TextUtils.isEmpty(this.mPackageName)) {
            if (!TextUtils.isEmpty(this.buI)) {
                com.baidu.tbadk.browser.a.i(this, this.buI);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(this.buJ));
        intent.setAction(this.buK);
        intent.setPackage(this.mPackageName);
        if (intent.resolveActivity(getPackageManager()) != null) {
            if (!com.baidu.adp.lib.g.i.a(this, intent) && !TextUtils.isEmpty(this.buI)) {
                com.baidu.tbadk.browser.a.i(this, this.buI);
            }
        } else if (!TextUtils.isEmpty(this.buI)) {
            com.baidu.tbadk.browser.a.i(this, this.buI);
        }
    }

    private void Ws() {
        if (!com.baidu.adp.lib.util.j.fi()) {
            if (!TextUtils.isEmpty(this.buI)) {
                com.baidu.tbadk.browser.a.i(this, this.buI);
                return;
            }
            return;
        }
        if (this.buH == null) {
            this.buH = new com.baidu.tbadk.core.dialog.a(this);
            this.buH.aX(com.baidu.tieba.y.download_iqiyi_app_dialog);
            this.buH.a(com.baidu.tieba.y.install_app, new ap(this));
            this.buH.b(com.baidu.tieba.y.webpage_play, new aq(this));
            this.buH.P(false);
        }
        this.buH.kT().kW();
    }

    private DialogInterface Wt() {
        if (this.buN == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.y.download_baidu_video_dialog));
            builder.setPositiveButton(getString(com.baidu.tieba.y.install), new ar(this));
            builder.setNegativeButton(getString(com.baidu.tieba.y.cancel), new as(this));
            builder.setCancelable(true);
            this.buN = builder.create();
            this.buN.setCanceledOnTouchOutside(false);
        }
        com.baidu.adp.lib.g.j.a(this.buN, this);
        return this.buN;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void u(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (gU(str) || z) {
                boolean h = com.baidu.adp.lib.util.m.h(context, "com.qiyi.video");
                gV(str);
                if (h) {
                    Wr();
                    return;
                } else {
                    Ws();
                    return;
                }
            }
            com.baidu.tbadk.browser.a.i(this, str);
            TiebaStatic.eventStat(this, "pb_video", "pbclick", 1, new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void w(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra("title", "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Wt();
        }
        TiebaStatic.eventStat(this, "baidu_video", "click", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void v(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList) {
        int i3;
        int i4;
        if (aVar == aVar2) {
            this.bvr = true;
        }
        if (aVar != null) {
            int size = aVar.vA().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.vA().get(i6) != null && aVar.vA().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.vA().get(i6).vF().getWidth();
                    int height = aVar.vA().get(i6).vF().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.vA().get(i6).vF().vM()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        arrayList.add(b(aVar.vA().get(i6)));
                        if (!this.bvr) {
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
    public void b(com.baidu.tieba.data.ak akVar) {
        if (akVar != null) {
            boolean z = false;
            if (akVar.getId() != null && akVar.getId().equals(this.buU.kD())) {
                z = true;
            }
            MarkData d = this.buU.d(akVar);
            if (d != null && gJ(11009)) {
                this.buZ.XD();
                this.buV.b(d);
                if (!z) {
                    this.buV.TL();
                } else {
                    this.buV.TM();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a K(String str, int i) {
        if (this.buU == null || this.buU.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.data.ah pbData = this.buU.getPbData();
        com.baidu.tbadk.widget.richText.a a = a(pbData.zN(), str, i);
        if (a == null) {
            ArrayList<com.baidu.tieba.data.ak> zN = pbData.zN();
            int size = zN.size();
            for (int i2 = 0; i2 < size; i2++) {
                a = a(zN.get(i2).Af(), str, i);
                if (a != null) {
                    return a;
                }
            }
            return a;
        }
        return a;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.data.ak> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> vA;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a Ah = arrayList.get(i2).Ah();
            if (Ah != null && (vA = Ah.vA()) != null) {
                int size = vA.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (vA.get(i4) != null && vA.get(i4).getType() == 8) {
                        i3++;
                        if (vA.get(i4).vF().vN().equals(str)) {
                            int width = vA.get(i4).vF().getWidth();
                            int height = vA.get(i4).vF().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.bvq = i4;
                            return Ah;
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
        com.baidu.tbadk.widget.richText.g vF = cVar.vF();
        if (vF != null) {
            if (!StringUtils.isNull(vF.vL())) {
                return vF.vL();
            }
            if (vF.getHeight() * vF.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (vF.getHeight() * vF.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (vF.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * vF.getHeight())));
            } else {
                float width = vF.getWidth() / vF.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.az.aC(vF.getSrc()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void b(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.buE = str;
            if (this.buM == null) {
                Wi();
            }
            com.baidu.tbadk.core.j.l(this, "pb_show_phonedialog");
            if (str2.equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT)) {
                this.buM.bg(1).setVisibility(8);
            } else {
                this.buM.bg(1).setVisibility(0);
            }
            this.buM.la();
        }
    }

    @Override // com.baidu.tbadk.core.voice.o
    public VoiceManager getVoiceManager() {
        return this.ayx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wu() {
        hideNetRefreshView(this.buZ.getView());
        showLoadingView(this.buZ.getView(), true);
        if (this.buU.tN()) {
            this.buZ.XD();
        }
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m b(VoiceData.VoiceModel voiceModel) {
        View Yi;
        View findViewWithTag;
        if (!this.buZ.XM() || (Yi = this.buZ.Yi()) == null || (findViewWithTag = Yi.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (com.baidu.tbadk.core.voice.m) findViewWithTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EC() {
        if (this.ayx != null) {
            this.ayx.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hw() {
        if (this.buU.Tu()) {
            TiebaStatic.eventStat(this, "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.data.ah pbData = this.buU.getPbData();
            String name = pbData.zL().getName();
            String title = pbData.zM().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.buU.WI() + "?share=9105&fr=share";
            String[] N = pbData.N(this);
            String str2 = N[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String format = MessageFormat.format(getResources().getString(com.baidu.tieba.y.share_content_tpl), title, name, N[1]);
            com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
            hVar.title = title;
            hVar.content = format;
            hVar.Na = str;
            if (parse != null) {
                hVar.Nb = parse;
            }
            this.aIl = new com.baidu.tbadk.coreExtra.share.d(this);
            this.aIl.a(hVar, true);
            this.aIl.a(getShareMtjStatInfo());
            this.aIl.ai(true);
            TextView t = this.aIl.t(com.baidu.tieba.y.share_tieba_qunzu, com.baidu.tieba.u.icon_unite_share_qunzu);
            this.aIl.a(t);
            TextView t2 = this.aIl.t(com.baidu.tieba.y.forum_friend, com.baidu.tieba.u.icon_unite_share_baf);
            this.aIl.a(t2);
            t2.setOnClickListener(new au(this));
            t.setOnClickListener(new av(this));
            this.aIl.b(new aw(this, hVar));
            this.aIl.show();
        }
    }

    private SparseArray<String> getShareMtjStatInfo() {
        if (this.aIo == null) {
            this.aIo = new SparseArray<>(7);
            this.aIo.put(2, "pb_wx_timeline");
            this.aIo.put(3, "pb_wx_friend");
            this.aIo.put(4, "pb_qq_zone");
            this.aIo.put(5, "pb_tencent_weibo");
            this.aIo.put(6, "pb_sina_weibo");
            this.aIo.put(7, "pb_renren");
        }
        return this.aIo;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<LinearLayout> vU() {
        if (this.abU == null) {
            this.abU = new com.baidu.adp.lib.e.b<>(new ax(this), 15, 0);
        }
        return this.abU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wv() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.data.ah pbData = this.buU.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.jZ().isIfAddition();
            AdditionData zT = pbData.zT();
            boolean z3 = zT == null ? false : isIfAddition;
            if (z3) {
                z = zT.getAlreadyCount() != zT.getTotalCount();
                if (!TextUtils.isEmpty(zT.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.main.b.a aVar = this.buZ.bxx;
            if (!z3 || !z) {
                z2 = false;
            }
            aVar.el(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.buZ.Xp() == view) {
            com.baidu.tbadk.core.data.q zM = this.buU.getPbData().zM();
            View childAt = ((ViewGroup) view).getChildAt(0);
            if (childAt != null) {
                boolean z = zM.getPraise() == null || zM.getPraise().getIsLike() == 0;
                if (motionEvent.getAction() == 0) {
                    if (System.currentTimeMillis() - this.azc > 1000) {
                        this.azd = true;
                        z(childAt);
                    } else {
                        this.azd = false;
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (z) {
                        d(childAt, this.azd);
                    } else {
                        c(childAt, this.azd);
                    }
                } else if (motionEvent.getAction() == 2) {
                    c(childAt, this.azd);
                } else if (motionEvent.getAction() == 3) {
                    c(childAt, this.azd);
                }
            }
        }
        return false;
    }

    private void c(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.p.praise_animation_scale2));
            new Handler().postDelayed(new ay(this), 200L);
        }
    }

    private void d(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.p.praise_animation_scale3));
            new Handler().postDelayed(new az(this), 600L);
        }
    }

    private void z(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.p.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void FI() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.m.b(this, getCurrentFocus());
        }
    }
}
