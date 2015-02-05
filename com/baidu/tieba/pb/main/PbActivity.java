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
    private static String bAk = "tbgametype";
    private com.baidu.adp.lib.e.b<TbImageView> NV;
    private com.baidu.tieba.tbadkCore.location.d aBC;
    private String aBH;
    private boolean aab;
    private com.baidu.adp.lib.e.b<ImageView> akd;
    private com.baidu.adp.lib.e.b<TextView> ake;
    private com.baidu.adp.lib.e.b<View> akf;
    private com.baidu.adp.lib.e.b<LinearLayout> akg;
    private com.baidu.adp.lib.e.b<GifView> akh;
    private String bAC;
    private AlertDialog bAm;
    private VoiceData.VoiceModel bAn;
    private String mPhoneNumber;
    private String mPostContent;
    private VoiceManager mVoiceManager;
    private boolean are = false;
    private boolean aCH = true;
    private boolean bAe = false;
    private com.baidu.tbadk.core.dialog.a bAf = null;
    private String bAg = null;
    private String mDownloadUrl = null;
    private String bAh = null;
    private String bAi = null;
    private String mPackageName = null;
    private int bAj = 0;
    private com.baidu.tbadk.core.dialog.i bAl = null;
    SparseArray<String> aKh = null;
    private long aDm = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private WriteData aDp = new WriteData();
    private long agP = 0;
    private long createTime = 0;
    private long agQ = 0;
    private boolean bAo = false;
    private com.baidu.tbadk.performanceLog.h bAp = null;
    public long aDw = System.currentTimeMillis();
    private String bAq = null;
    private final Handler mHandler = new Handler(new b(this));
    private bq bAr = null;
    private com.baidu.tbadk.baseEditMark.e bAs = null;
    private com.baidu.tieba.tbadkCore.f.a aBJ = null;
    private com.baidu.tieba.model.m bAt = null;
    private com.baidu.tieba.pb.sub.e bAu = null;
    private com.baidu.tieba.tbadkCore.e.a bAv = null;
    private bz bAw = null;
    public final com.baidu.tieba.pb.main.a.a bAx = new com.baidu.tieba.pb.main.a.a(this);
    private boolean bAy = false;
    private boolean bAz = false;
    private MorePopupWindow bAA = null;
    private by bAB = null;
    private boolean aCJ = false;
    private com.baidu.tieba.tbadkCore.location.i aBN = new ai(this);
    private com.baidu.tieba.tbadkCore.location.j aBO = new at(this);
    private boolean aBD = false;
    private com.baidu.tieba.tbadkCore.ao aBR = new com.baidu.tieba.tbadkCore.ao(getPageContext(), new bb(this));
    private long praiseStopTime = 0;
    private boolean isPraiseToServer = true;
    public com.baidu.tieba.b.e bAD = new bc(this);
    public final View.OnClickListener aFH = new bd(this);
    private final bt bAE = new bf(this);
    private final com.baidu.tbadk.baseEditMark.g bAF = new c(this);
    private final AbsListView.OnScrollListener wQ = new d(this);
    private final AbsListView.OnScrollListener bAG = new e(this);
    private final com.baidu.tieba.pb.sub.g bAH = new f(this);
    private final com.baidu.tieba.tbadkCore.f.c aDz = new g(this);
    private final com.baidu.adp.base.i bAI = new h(this);
    private final bh bAJ = new i(this);
    private final com.baidu.adp.widget.ListView.g aTA = new j(this);
    private final com.baidu.adp.widget.ListView.ab bAK = new k(this);
    private final com.baidu.adp.widget.ListView.ae bAL = new l(this);
    private final DialogInterface.OnClickListener bfN = new n(this);
    private final com.baidu.adp.base.i bAM = new o(this);
    private final cz bAN = new p(this);
    private int bAO = 0;
    private final com.baidu.tbadk.widget.richText.s akw = new q(this);
    boolean bAP = false;
    com.baidu.tieba.tbadkCore.b.k bAQ = null;
    private final DialogInterface.OnClickListener bAR = new r(this);
    private final View.OnLongClickListener Un = new s(this);
    private final com.baidu.tbadk.core.view.ad aDL = new t(this);
    com.baidu.tbadk.coreExtra.share.d aKe = null;

    static {
        Jx();
        WW();
        CustomMessageTask customMessageTask = new CustomMessageTask(2004001, new m());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2004005, new x());
        customMessageTask2.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        WX();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m255getInst().isGpuOpen();
    }

    private static void Jx() {
        com.baidu.tieba.tbadkCore.a.a.a(302001, pbPageSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.O("c/f/pb/page", 302001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.location.d.aid();
    }

    private static void WW() {
        com.baidu.tieba.tbadkCore.a.a.b(2004003, da.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fj() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Fk() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.z.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m255getInst().getLocationShared()) {
            Fl();
        } else if (this.aBC.aic()) {
            Fj();
        } else {
            this.aBC.eE(false);
            if (this.bAw.Fz() != null) {
                this.bAw.Fz().setLocationViewVisibility(0);
                this.bAw.Fz().setLocationInfoViewState(1);
            }
            this.aBC.aia();
        }
    }

    private void Fl() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.by(com.baidu.tieba.z.location_app_permission_prompt).a(com.baidu.tieba.z.isopen, new u(this)).b(com.baidu.tieba.z.cancel, new v(this)).b(getPageContext());
        aVar.nQ();
    }

    public void Fm() {
        if (this.bAw.Fz() != null) {
            if (this.aBC.aie()) {
                this.bAw.Fz().setLocationViewVisibility(0);
                if (this.aBC.aic()) {
                    this.aBN.a(com.baidu.tieba.tbadkCore.location.c.ahX().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.l.isNetOk()) {
                    this.bAw.Fz().setLocationInfoViewState(1);
                    this.aBC.aia();
                    return;
                } else {
                    this.bAw.Fz().setLocationInfoViewState(0);
                    return;
                }
            }
            this.bAw.Fz().setLocationViewVisibility(8);
        }
    }

    private static void WX() {
        com.baidu.tbadk.core.util.bm.pO().a(new w());
    }

    private void WY() {
        this.bAw.YO();
        this.bAw.Yn();
    }

    private void WZ() {
        this.bAw.YP();
        this.bAw.Yp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xa() {
        com.baidu.tieba.tbadkCore.b.i pbData;
        com.baidu.tbadk.core.data.x ahe;
        if (!this.aBD) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                showToast(com.baidu.tieba.z.no_network_guide);
            } else if (this.isPraiseToServer) {
                this.aBD = true;
                if (this.bAr != null && (pbData = this.bAr.getPbData()) != null && (ahe = pbData.ahe()) != null) {
                    int isLike = ahe.getPraise() == null ? 0 : ahe.getPraise().getIsLike();
                    if (this.aBR != null) {
                        this.aBR.a(ahe.ny(), ahe.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(int i) {
        com.baidu.tbadk.core.data.x ahe;
        if (this.bAr != null && this.bAr.getPbData() != null && (ahe = this.bAr.getPbData().ahe()) != null) {
            if (i == 1) {
                PraiseData praise = ahe.getPraise();
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
                        ahe.setPraise(praiseData);
                    } else {
                        ahe.getPraise().getUser().add(0, metaData);
                        ahe.getPraise().setNum(ahe.getPraise().getNum() + 1);
                        ahe.getPraise().setIsLike(i);
                    }
                }
                if (ahe.getPraise() != null) {
                    this.bAw.d(ahe.getPraise().getNum(), true);
                }
            } else if (ahe.getPraise() != null) {
                ahe.getPraise().setIsLike(i);
                ahe.getPraise().setNum(ahe.getPraise().getNum() - 1);
                ArrayList<MetaData> user = ahe.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            ahe.getPraise().getUser().remove(next);
                            break;
                        }
                    }
                }
                this.bAw.d(ahe.getPraise().getNum(), false);
            }
            if (this.bAr.XG()) {
                this.bAw.Yt().notifyDataSetChanged();
            } else {
                this.bAw.f(this.bAr.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bAr.saveToBundle(bundle);
        if (this.bAr.XJ()) {
            this.bAu.saveToBundle(bundle);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aBH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.aDm = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aDm = System.currentTimeMillis();
        }
        this.bAj = 0;
        initUI();
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initData(bundle);
        addGlobalLayoutListener();
        this.createTime = System.currentTimeMillis() - this.aDm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.bAw != null) {
            if (this.bAw.Fz() != null) {
                this.bAw.Fz().afK();
            }
            if (this.bAw.Yo() != null && this.bAw.Yo().Fz() != null) {
                this.bAw.Yo().Fz().afK();
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

    public bq Xb() {
        return this.bAr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.are = true;
        super.onPause();
        BdListView listView = getListView();
        this.bAj = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.bAj == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
        if (this.bAw != null) {
            this.bAw.onPause();
        }
        if (!this.bAr.XJ()) {
            WriteData Fn = this.aBJ.Fn();
            if (Fn == null) {
                Fn = new WriteData(1);
                Fn.setThreadId(this.bAr.XF());
                Fn.setWriteImagesInfo(this.writeImagesInfo);
            }
            Fn.setContent(this.bAw.FG());
            if (this.aDp != null && this.aDp.getIsBaobao()) {
                Fn.setBaobaoContent(this.aDp.getBaobaoContent());
                Fn.setBaobaoImagesInfo(this.baobaoImagesInfo);
                Fn.setIsBaobao(true);
            }
            com.baidu.tieba.tbadkCore.al.b(this.bAr.XF(), Fn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        this.are = false;
        super.onResume();
        if (this.bAj == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView Yg = this.bAw.Yg();
        if (Yg != null && Yg.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            Yg.as(false);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
        if (this.bAw.Fz() != null) {
            this.bAw.Fz().refresh();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!com.baidu.tbadk.core.util.bf.isEmpty(writeData.getContent()) && com.baidu.tbadk.core.util.bf.isEmpty(this.bAw.FG())) {
                this.mPostContent = writeData.getContent();
                this.bAw.fz(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                this.bAw.a(this.writeImagesInfo, true);
            }
            if (TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.aDp.setIsBaobao(writeData.getIsBaobao());
                this.aDp.setBaobaoContent(writeData.getBaobaoContent());
                this.aDp.setBaobaoImagesInfo(this.baobaoImagesInfo);
                this.bAw.setBaobaoUris(this.baobaoImagesInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bAw.Fz() != null && this.bAw.Fz().getVisibility() != 0) {
            Xd();
            this.bAw.Yj();
        }
        if (!this.bAw.YJ()) {
            this.bAw.YL();
        }
        this.bAw.bCX.Zs();
        if (this.bAr != null && this.bAr.getPbData() != null && this.bAr.getPbData().aeI() != null && this.bAr.getPbData().ahe() != null) {
            com.baidu.tbadk.distribute.a.uO().a(getPageContext().getPageActivity(), "pb", this.bAr.getPbData().aeI().getId(), com.baidu.adp.lib.g.c.a(this.bAr.getPbData().ahe().getId(), 0L));
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (!this.bAo) {
            this.bAo = true;
            this.bAw.Zl();
        }
        this.bAr.cancelLoadData();
        this.bAr.destory();
        this.aBJ.cancelLoadData();
        this.bAt.cancelLoadData();
        this.aBC.cancelLoadData();
        this.bAu.cancelLoadData();
        this.bAu.destory();
        this.bAv.cancelLoadData();
        this.bAw.onDestroy();
        if (this.bAp != null) {
            this.bAp.onDestroy();
        }
        super.onDestroy();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
    }

    public void Xc() {
        if (this.bAw.Fz() != null) {
            this.bAw.Fz().setContent(this.mPostContent == null ? "" : this.mPostContent);
            if (this.bAn != null) {
                this.bAw.Fz().afU();
            }
            this.bAw.a(this.writeImagesInfo, true);
            this.bAw.setBaobaoUris(this.baobaoImagesInfo);
            if (!StringUtils.isNull(this.mPostContent) || this.bAn != null) {
                this.bAw.Fz().aga();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xd() {
        if (this.bAw.Fz() != null) {
            this.mPostContent = this.bAw.Fz().getContent();
            this.bAn = this.bAw.getAudioData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bAw.onChangeSkinType(i);
        if (this.bAA != null) {
            this.bAA.onChangeSkinType(this, i, com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.bg_collect));
        }
        if (this.bAw.Yg() != null) {
            this.bAw.Yg().onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xe() {
        this.bAB = new by(this, this.aFH);
        this.bAA = new MorePopupWindow(getPageContext().getPageActivity(), this.bAB.getView(), getResources().getDrawable(com.baidu.tieba.v.bg_collect), null);
        this.bAA.setTouchInterceptor(new y(this));
        this.bAA.onChangeSkinType(this, TbadkCoreApplication.m255getInst().getSkinType(), com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.bg_collect));
    }

    private void initUI() {
        this.bAw = new bz(this, this.aFH, this.bAD);
        this.bAw.setOnActionListener(new z(this));
        this.bAw.setOnScrollListener(this.wQ);
        this.bAw.a(this.bAG);
        this.bAw.c(this.bAK);
        this.bAw.a(this.bAL);
        this.bAw.c(this.bfN);
        this.bAw.a(this.aTA);
        this.bAw.dO(com.baidu.tbadk.core.l.lV().lZ());
        this.bAw.dP(com.baidu.tbadk.core.l.lV().lX());
        this.bAw.setOnImageClickListener(this.akw);
        this.bAw.b(this.Un);
        this.bAw.a(this.bAN);
        this.bAw.f(this.aDL);
        this.bAw.a(this.bAJ);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.bAw != null) {
            if (z && !this.bAe) {
                if (this.aCH) {
                    this.aCH = false;
                    showLoadingView(this.bAw.getView(), true);
                    return;
                }
                return;
            }
            hideLoadingView(this.bAw.getView());
        }
    }

    private void Xf() {
        if (this.bAl == null) {
            this.bAl = new com.baidu.tbadk.core.dialog.i(getPageContext().getPageActivity());
            this.bAl.a(new Object[]{getPageContext().getString(com.baidu.tieba.z.call_phone), getPageContext().getString(com.baidu.tieba.z.sms_phone), getPageContext().getString(com.baidu.tieba.z.search_in_baidu)}, new aa(this)).bE(com.baidu.tbadk.core.dialog.k.FU).bF(80).e(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        this.bAr = new bq(this);
        this.bAr.a(this.bAE);
        this.bAs = new com.baidu.tbadk.baseEditMark.e(this);
        this.bAs.a(this.bAF);
        this.aBJ = new com.baidu.tieba.tbadkCore.f.a(this);
        this.aBJ.a(this.aDz);
        this.bAt = new com.baidu.tieba.model.m(this);
        this.bAt.setLoadDataCallBack(this.bAM);
        this.bAu = new com.baidu.tieba.pb.sub.e(this);
        this.bAu.a(this.bAH);
        this.bAv = new com.baidu.tieba.tbadkCore.e.a(this);
        this.bAv.setLoadDataCallBack(this.bAI);
        this.aBC = new com.baidu.tieba.tbadkCore.location.d(this);
        this.aBC.a(this.aBN);
        this.aBC.a(this.aBO);
        if (bundle != null) {
            this.bAr.initWithBundle(bundle);
        } else {
            this.bAr.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, -1) == 18003) {
            this.bAr.dT(true);
        }
        bv.XZ().y(this.bAr.XD(), this.bAr.getIsFromMark());
        if (!this.bAr.XJ()) {
            this.bAw.YA();
            this.bAr.xF();
        } else {
            if (bundle != null) {
                this.bAu.initWithBundle(bundle);
            } else {
                this.bAu.initWithIntent(getIntent());
            }
            this.bAC = this.bAu.lm();
            String stType = this.bAu.getStType();
            if (stType != null && (("mention".equals(this.bAu.getStType()) || stType.equals("person_post_reply")) && this.bAC != null)) {
                this.bAw.YN();
            } else {
                this.bAw.YG();
            }
            this.bAu.ZM();
        }
        this.bAw.a(new ab(this));
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aBH = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!this.bAr.XJ()) {
            com.baidu.tieba.tbadkCore.al.a(this.bAr.XF(), this);
        }
        this.aBR.setUniqueId(getUniqueId());
        this.aBR.registerListener();
    }

    public void Xg() {
        this.bAw.bCX.g(this.bAr.XG(), this.bAs.lb());
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
        Xr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Boolean bool) {
        com.baidu.tieba.tbadkCore.b.i pbData;
        String str = null;
        if (this.bAr != null && (pbData = this.bAr.getPbData()) != null && pbData.aeI() != null) {
            str = pbData.aeI().getName();
        }
        if (com.baidu.tieba.tbadkCore.aa.b(str, bool)) {
            WZ();
        } else {
            WY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Boolean bool) {
        if (com.baidu.tieba.tbadkCore.aa.b(str, bool)) {
            WZ();
        } else {
            WY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, com.baidu.tieba.tbadkCore.f.f fVar) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            if (!this.bAr.XJ()) {
                antiData.setBlock_forum_name(this.bAr.getPbData().aeI().getName());
                antiData.setBlock_forum_id(this.bAr.getPbData().aeI().getId());
                antiData.setUser_name(this.bAr.getPbData().getUserData().getUserName());
                antiData.setUser_id(this.bAr.getPbData().getUserData().getUserId());
            } else {
                antiData.setBlock_forum_name(this.bAu.ZH().ahG().getName());
                antiData.setBlock_forum_id(this.bAu.ZH().ahG().getId());
                antiData.setUser_name(TbadkCoreApplication.getCurrentAccountName());
                antiData.setUser_id(TbadkCoreApplication.getCurrentAccount());
            }
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.tieba.tbadkCore.f.g.d(getPageContext().getPageActivity(), fVar.getErrorString(), fVar.aiD(), fVar.aiE());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            if (!this.bAr.XJ()) {
                antiData.setBlock_forum_name(this.bAr.getPbData().aeI().getName());
                antiData.setBlock_forum_id(this.bAr.getPbData().aeI().getId());
                antiData.setUser_name(this.bAr.getPbData().getUserData().getUserName());
                antiData.setUser_id(this.bAr.getPbData().getUserData().getUserId());
            } else {
                antiData.setBlock_forum_name(this.bAu.ZH().ahG().getName());
                antiData.setBlock_forum_id(this.bAu.ZH().ahG().getId());
                antiData.setUser_name(TbadkCoreApplication.getCurrentAccountName());
                antiData.setUser_id(TbadkCoreApplication.getCurrentAccount());
            }
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        this.bAw.showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.e.c cVar) {
        int i = 0;
        if (cVar != null) {
            this.bAw.a(0, cVar.qb, cVar.caz, true);
            if (cVar.qb) {
                if (cVar.cax == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.b.k> ahf = this.bAr.getPbData().ahf();
                    int size = ahf.size();
                    while (true) {
                        if (i < size) {
                            if (!cVar.mPostId.equals(ahf.get(i).getId())) {
                                i++;
                            } else {
                                ahf.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.bAw.e(this.bAr.getPbData());
                } else if (cVar.cax == 0) {
                    Xh();
                } else if (cVar.cax == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.b.k> ahf2 = this.bAr.getPbData().ahf();
                    int size2 = ahf2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < ahf2.get(i2).ahq().size()) {
                                if (!cVar.mPostId.equals(ahf2.get(i2).ahq().get(i3).getId())) {
                                    i3++;
                                } else {
                                    ahf2.get(i2).ahq().remove(i3);
                                    ahf2.get(i2).ahr();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData ahh = this.bAr.getPbData().ahh();
                        com.baidu.tieba.tbadkCore.b.k kVar = ahf2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.b.k> ahs = kVar.ahs();
                        int size3 = ahs.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!cVar.mPostId.equals(ahf2.get(i2).ahs().get(i4).getId())) {
                                    i4++;
                                } else {
                                    ahs.remove(i4);
                                    ahh.decreaseAlreadyCount();
                                    if (kVar.ahz() > ahs.size()) {
                                        kVar.hY(ahs.size());
                                    }
                                    if (ahs.size() > 0) {
                                        com.baidu.tieba.tbadkCore.b.k kVar2 = ahs.get(ahs.size() - 1);
                                        ahh.setLastAdditionTime(kVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a ahu = kVar2.ahu();
                                        String str = "";
                                        if (ahu != null) {
                                            str = ahu.toString();
                                        }
                                        ahh.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a ahu2 = kVar.ahu();
                                        String str2 = "";
                                        if (ahu2 != null) {
                                            str2 = ahu2.toString();
                                        }
                                        ahh.setLastAdditionContent(str2);
                                    }
                                    Xs();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.bAw.e(this.bAr.getPbData());
                    }
                    if (this.bAw.YJ()) {
                        this.bAu.hE(cVar.mPostId);
                        this.bAw.a(this.bAu.ZH(), this.bAr.getPbData().ahg());
                        if (!z) {
                            String lm = this.bAu.lm();
                            while (i < size2) {
                                if (!lm.equals(ahf2.get(i).getId())) {
                                    i++;
                                } else {
                                    ahf2.get(i).ahr();
                                    this.bAw.e(this.bAr.getPbData());
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
        this.bAw.a(1, eVar.qb, eVar.caz, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.e.g gVar) {
        this.bAw.a(this.bAv.getLoadDataMode(), gVar.qb, gVar.caz, false);
        this.bAw.I(gVar.caB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.tbadkCore.e.g gVar) {
        if (gVar != null) {
            this.bAw.a(this.bAv.getLoadDataMode(), gVar.qb, gVar.caz, true);
            if (gVar.qb) {
                this.bAz = true;
                if (i == 2) {
                    this.bAr.getPbData().ahe().bv(1);
                    this.bAr.setIsGood(1);
                } else if (i == 3) {
                    this.bAr.getPbData().ahe().bv(0);
                    this.bAr.setIsGood(0);
                } else if (i == 4) {
                    this.bAr.getPbData().ahe().bu(1);
                    this.bAr.gZ(1);
                } else if (i == 5) {
                    this.bAr.getPbData().ahe().bu(0);
                    this.bAr.gZ(0);
                }
                this.bAw.a(this.bAr.getPbData(), this.bAr.XG(), true);
            }
        }
    }

    private void Xh() {
        if (this.bAr.XH()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.bAr.XF());
            setResult(-1, intent);
        }
        if (Xn()) {
            super.closeActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xi() {
        super.closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        this.bAw.Ze();
        if (this.bAr != null && this.bAr.getPbData() != null) {
            com.baidu.tbadk.b.a aVar = new com.baidu.tbadk.b.a(this);
            com.baidu.tbadk.b.b bVar = new com.baidu.tbadk.b.b();
            bVar.setThreadId(this.bAr.getPbData().ahe().getId());
            bVar.setForumName(this.bAr.getPbData().aeI().getName());
            bVar.bA(this.bAr.getPbData().ahe().getTitle());
            ArrayList<com.baidu.tieba.tbadkCore.b.k> ahf = this.bAr.getPbData().ahf();
            int YR = this.bAw.YR();
            if (ahf != null && YR >= 0 && YR < ahf.size()) {
                bVar.bB(ahf.get(YR).getId());
            }
            bVar.Z(this.bAr.getHostMode());
            bVar.aa(this.bAr.XG());
            aVar.a((com.baidu.tbadk.b.a) bVar);
        }
        if (this.bAr != null && this.bAr.XH()) {
            Intent intent = new Intent();
            if (this.bAz) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.bAr.XF());
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.bAr.XI());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.bAr.getIsGood());
            }
            setResult(-1, intent);
        }
        if (Xn()) {
            if (this.bAr != null && this.bAw != null && this.bAw.getListView() != null) {
                com.baidu.tieba.tbadkCore.b.i pbData = this.bAr.getPbData();
                if (pbData != null && pbData.getUserData() != null) {
                    pbData.getUserData().setBimg_url(TbadkCoreApplication.m255getInst().getDefaultBubble());
                }
                bv.XZ().a(this.bAr.getPbData(), this.bAw.getListView().onSaveInstanceState(), this.bAr.XG(), this.bAr.getHostMode());
            } else {
                bv.XZ().reset();
            }
            super.closeActivity();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.bAA != null) {
                    com.baidu.adp.lib.g.k.a(this.bAA, getPageContext().getPageActivity());
                }
                if (this.bAw.ea(this.bAr.XJ())) {
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
                    fu(null);
                    return;
                case 11009:
                    Xl();
                    return;
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(getPageContext().getPageActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(getPageContext().getPageActivity(), 12005, true)));
                    return;
                case 11027:
                    fu(this.bAw.YT());
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
                        Xk();
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            this.bAw.YQ();
                            this.aBJ.eF(false);
                            return;
                        }
                        this.bAt.hu(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    Xk();
                    ArrayList<String> W = com.baidu.tieba.tbadkCore.util.i.W(intent);
                    if (W != null) {
                        this.bAw.A(W);
                        return;
                    }
                    return;
                case 12005:
                    Xk();
                    new Handler().postDelayed(new ac(this), 200L);
                    ArrayList<String> W2 = com.baidu.tieba.tbadkCore.util.i.W(intent);
                    if (W2 != null) {
                        this.bAw.J(W2);
                        return;
                    }
                    return;
                case 12006:
                    WriteData Fn = this.aBJ.Fn();
                    if (Fn != null) {
                        Fn.deleteUploadedTempImages();
                    }
                    this.aDp.setIsBaobao(false);
                    this.aDp.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.aBJ.c((WriteData) null);
                    this.aBJ.eF(false);
                    this.bAw.bG(true);
                    if (this.bAw.YJ()) {
                        this.bAu.ZK();
                    } else {
                        if (this.bAr != null && this.bAr.XM()) {
                            this.bAw.YA();
                        }
                        if (this.bAr != null && this.bAr.XF() != null && !this.bAr.XJ()) {
                            com.baidu.tieba.tbadkCore.al.b(this.bAr.XF(), (WriteData) null);
                        }
                    }
                    this.bAw.a(this.writeImagesInfo, true);
                    return;
                case 12009:
                case 12010:
                    Xk();
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
                    bv.XZ().reset();
                    this.mHandler.postDelayed(new ad(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.bAr != null) {
                        a(Xj(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getIntExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0));
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
                Fo();
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
                Xk();
                return;
        }
    }

    private ShareFromPBMsgData Xj() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] ax = this.bAr.getPbData().ax(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.b.k Yi = this.bAw.Yi();
        String str = "";
        if (Yi != null) {
            str = Yi.getId();
            String aA = Yi.aA(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(aA)) {
                ax[1] = aA;
            }
        }
        String ny = this.bAr.getPbData().ahe().ny();
        if (ny != null && ny.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(ax[1]);
        shareFromPBMsgData.setImageUrl(ax[0]);
        shareFromPBMsgData.setForumName(this.bAr.getPbData().aeI().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.bAr.getPbData().ahe().getId());
        shareFromPBMsgData.setTitle(this.bAr.getPbData().ahe().getTitle());
        return shareFromPBMsgData;
    }

    private void T(Intent intent) {
        a(Xj(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.bAr != null && this.bAr.getPbData() != null && this.bAr.getPbData().ahe() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bS(this.bAr.getPbData().ahe().getTitle());
            db dbVar = new db(getPageContext().getPageActivity());
            dbVar.setData(shareFromPBMsgData);
            aVar.j(dbVar);
            aVar.a(com.baidu.tieba.z.share, new ae(this, j, str, str2, dbVar, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.z.alert_no_button, new af(this, dbVar));
            aVar.ai(false);
            aVar.b(getPageContext()).nQ();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                dbVar.z(shareFromPBMsgData.getImageUrl(), this.bAr.getPbData().CB() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, int i2) {
        if (this.bAr != null && this.bAr.getPbData() != null && this.bAr.getPbData().ahe() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bS(this.bAr.getPbData().ahe().getTitle());
            db dbVar = new db(getPageContext().getPageActivity());
            dbVar.setData(shareFromPBMsgData);
            aVar.j(dbVar);
            aVar.a(com.baidu.tieba.z.share, new ag(this, i, str, i2, dbVar, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.z.alert_no_button, new ah(this, dbVar));
            aVar.ai(false);
            aVar.b(getPageContext()).nQ();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                dbVar.z(shareFromPBMsgData.getImageUrl(), this.bAr.getPbData().CB() == 1);
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
        this.aBH = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aBH;
        if (!TextUtils.isEmpty(str)) {
            try {
                int bY = com.baidu.tbadk.core.util.d.bY(str);
                if (bY != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.d.b(str, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.M(getPageContext().getPageActivity())), com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.N(getPageContext().getPageActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.d.h(b, bY);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.aBH, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            this.bAw.a(this.writeImagesInfo, true);
        }
        if (this.bAw.Fz() != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            this.bAw.Fz().hQ(23);
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
                    this.bAw.a(this.writeImagesInfo, z);
                }
            }
            if (this.bAw.Fz() != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                this.bAw.Fz().hQ(23);
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
                this.bAw.setBaobaoUris(this.baobaoImagesInfo);
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    if (this.bAw.Fz() != null) {
                        this.bAw.Fz().hQ(50);
                    }
                    this.aDp.setIsBaobao(true);
                    this.aDp.setBaobaoContent(stringExtra2);
                    this.aDp.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.aDp.setIsBaobao(false);
                this.aDp.setBaobaoContent("");
                this.aDp.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void Fo() {
        new aj(this).execute(new Void[0]);
    }

    private void Xk() {
        if (this.bAy) {
            this.bAy = false;
            new Handler().postDelayed(new ak(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xl() {
        MarkData hf = this.bAr.hf(this.bAw.YR());
        if (hf != null) {
            this.bAw.YA();
            this.bAs.b(hf);
            if (!this.bAs.lb()) {
                this.bAs.le();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.bAs.lf();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fu(String str) {
        VoiceData.VoiceModel Yq;
        if (this.aBJ.Fn() == null) {
            if (!this.bAr.XJ()) {
                this.aBJ.c(this.bAr.hz(str));
            } else {
                this.aBJ.c(this.bAu.Fn());
            }
        }
        if (this.aBJ.Fn() != null) {
            if (!this.bAr.XJ()) {
                this.aBJ.Fn().setWriteImagesInfo(this.writeImagesInfo);
                this.aBJ.eF(this.writeImagesInfo.size() > 0);
                if (this.aDp.getIsBaobao()) {
                    this.aBJ.Fn().setIsBaobao(true);
                    this.aBJ.Fn().setBaobaoContent(this.aDp.getBaobaoContent());
                    this.aBJ.Fn().setBaobaoImagesInfo(this.baobaoImagesInfo);
                } else {
                    this.aBJ.Fn().setIsBaobao(false);
                }
            }
            if (this.bAw.Fz() != null) {
                this.aBJ.Fn().setHasLocationData(this.bAw.Fz().getLocationInfoViewState() == 2);
            }
            if (str == null) {
                this.aBJ.Fn().setContent(this.bAw.FG());
                Yq = this.bAw.getAudioData();
                this.bAw.FI();
            } else {
                this.aBJ.Fn().setContent(this.bAw.YS());
                this.aBJ.Fn().setRepostId(this.bAw.YU());
                Yq = this.bAw.Yq();
                this.bAw.Yr();
            }
            if (Yq != null) {
                if (Yq.getId() != null) {
                    this.aBJ.Fn().setVoice(Yq.getId());
                    this.aBJ.Fn().setVoiceDuringTime(Yq.duration);
                } else {
                    this.aBJ.Fn().setVoice(null);
                    this.aBJ.Fn().setVoiceDuringTime(-1);
                }
            } else {
                this.aBJ.Fn().setVoice(null);
                this.aBJ.Fn().setVoiceDuringTime(-1);
            }
            if (!this.aBJ.aiB()) {
                showToast(com.baidu.tieba.z.write_img_limit);
            } else if (this.aBJ.aiA()) {
                this.bAw.FF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xm() {
        com.baidu.tieba.tbadkCore.b.i pbData = this.bAr.getPbData();
        this.bAr.dS(true);
        pbData.il(this.bAs.ld());
        this.bAw.e(pbData);
    }

    private boolean Xn() {
        if (this.bAr == null) {
            return true;
        }
        if (this.bAr.lb()) {
            MarkData XR = this.bAr.XR();
            if (XR == null || !this.bAr.getIsFromMark()) {
                return true;
            }
            MarkData hf = this.bAr.hf(this.bAw.YR());
            if (hf == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, XR);
                setResult(-1, intent);
                Xi();
                return true;
            } else if (hf.getPostId() == null || hf.getPostId().equals(XR.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, XR);
                setResult(-1, intent2);
                Xi();
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.bT(String.format(getPageContext().getString(com.baidu.tieba.z.alert_update_mark), Integer.valueOf(hf.getFloor())));
                aVar.a(com.baidu.tieba.z.alert_yes_btn, new al(this, hf, XR));
                aVar.b(com.baidu.tieba.z.alert_no_button, new am(this, XR));
                aVar.b(getPageContext());
                aVar.nQ();
                return false;
            }
        } else if (this.bAr.getPbData() == null || this.bAr.getPbData().ahf() == null || this.bAr.getPbData().ahf().size() <= 0 || !this.bAr.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.as
    public BdListView getListView() {
        if (this.bAw == null) {
            return null;
        }
        return this.bAw.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int getRichTextViewId() {
        if (this.bAw == null) {
            return 0;
        }
        return this.bAw.YX();
    }

    @Override // com.baidu.tbadk.core.view.as
    public int qI() {
        if (this.bAw == null) {
            return 0;
        }
        return this.bAw.Fh();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<ImageView> getImageViewPool() {
        if (this.akd == null) {
            this.akd = new com.baidu.adp.lib.e.b<>(new an(this), 8, 0);
        }
        return this.akd;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<TextView> getTextViewPool() {
        if (this.ake == null) {
            this.ake = TbRichTextView.h(getPageContext().getPageActivity(), 8);
        }
        return this.ake;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<GifView> getGifViewPool() {
        if (this.akh == null) {
            this.akh = new com.baidu.adp.lib.e.b<>(new ao(this), 20, 0);
        }
        return this.akh;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<View> getVoiceViewPool() {
        if (this.akf == null) {
            this.akf = new com.baidu.adp.lib.e.b<>(new ap(this), 8, 0);
        }
        return this.akf;
    }

    @Override // com.baidu.tbadk.core.view.as
    public com.baidu.adp.lib.e.b<TbImageView> qJ() {
        if (this.NV == null) {
            this.NV = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.NV;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    public boolean hw(String str) {
        Map<String, String> cH;
        if (!TextUtils.isEmpty(str) && (cH = com.baidu.tbadk.core.util.bm.cH(com.baidu.tbadk.core.util.bm.cI(str))) != null) {
            String str2 = cH.get(ImageViewerConfig.URL);
            if (!TextUtils.isEmpty(str2)) {
                return hw(com.baidu.adp.lib.util.k.aF(str2));
            }
            String str3 = cH.get(bAk);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onLinkClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (hx(str) || z) {
                boolean u = com.baidu.adp.lib.util.l.u(context, "com.qiyi.video");
                hy(str);
                if (u) {
                    Xo();
                } else {
                    Xp();
                }
            } else if (hw(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                com.baidu.tbadk.core.util.bm.pO().b(getPageContext(), new String[]{str});
            }
        }
    }

    private boolean hx(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }

    private void hy(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(";")) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.bAh = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.bAi = split[i].substring(indexOf2 + 1, split[i].length());
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
                        this.bAg = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void Xo() {
        if (TextUtils.isEmpty(this.bAh) || TextUtils.isEmpty(this.bAi) || TextUtils.isEmpty(this.mPackageName)) {
            if (!TextUtils.isEmpty(this.bAg)) {
                com.baidu.tbadk.browser.a.b(getPageContext().getPageActivity(), false, this.bAg);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(this.bAh));
        intent.setAction(this.bAi);
        intent.setPackage(this.mPackageName);
        if (intent.resolveActivity(getPageContext().getPageActivity().getPackageManager()) != null) {
            if (!com.baidu.adp.lib.g.j.e(getPageContext().getPageActivity(), intent) && !TextUtils.isEmpty(this.bAg)) {
                com.baidu.tbadk.browser.a.b(getPageContext().getPageActivity(), false, this.bAg);
            }
        } else if (!TextUtils.isEmpty(this.bAg)) {
            com.baidu.tbadk.browser.a.b(getPageContext().getPageActivity(), false, this.bAg);
        }
    }

    private void Xp() {
        if (!com.baidu.adp.lib.util.i.fg()) {
            if (!TextUtils.isEmpty(this.bAg)) {
                com.baidu.tbadk.browser.a.b(getPageContext().getPageActivity(), false, this.bAg);
                return;
            }
            return;
        }
        if (this.bAf == null) {
            this.bAf = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.bAf.by(com.baidu.tieba.z.download_iqiyi_app_dialog);
            this.bAf.a(com.baidu.tieba.z.install_app, new aq(this));
            this.bAf.b(com.baidu.tieba.z.webpage_play, new ar(this));
            this.bAf.ai(false);
        }
        this.bAf.b(getPageContext()).nQ();
    }

    private DialogInterface Xq() {
        if (this.bAm == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
            builder.setTitle(getPageContext().getString(com.baidu.tieba.z.download_baidu_video_dialog));
            builder.setPositiveButton(getPageContext().getString(com.baidu.tieba.z.install), new as(this));
            builder.setNegativeButton(getPageContext().getString(com.baidu.tieba.z.cancel), new au(this));
            builder.setCancelable(true);
            this.bAm = builder.create();
            this.bAm.setCanceledOnTouchOutside(false);
        }
        com.baidu.adp.lib.g.k.a(this.bAm, getPageContext());
        return this.bAm;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onVideoClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (hx(str) || z) {
                boolean u = com.baidu.adp.lib.util.l.u(context, "com.qiyi.video");
                hy(str);
                if (u) {
                    Xo();
                    return;
                } else {
                    Xp();
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
            Xq();
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
            this.bAP = true;
        }
        if (aVar != null) {
            int size = aVar.zZ().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.zZ().get(i6) != null && aVar.zZ().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.zZ().get(i6).Ae().getWidth();
                    int height = aVar.zZ().get(i6).Ae().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.zZ().get(i6).Ae().Al()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        arrayList.add(b(aVar.zZ().get(i6)));
                        if (!this.bAP) {
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
            if (kVar.getId() != null && kVar.getId().equals(this.bAr.ns())) {
                z = true;
            }
            MarkData c = this.bAr.c(kVar);
            if (c != null && gY(11009)) {
                this.bAw.YA();
                this.bAs.b(c);
                if (!z) {
                    this.bAs.le();
                } else {
                    this.bAs.lf();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a R(String str, int i) {
        if (this.bAr == null || this.bAr.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.tbadkCore.b.i pbData = this.bAr.getPbData();
        com.baidu.tbadk.widget.richText.a a = a(pbData.ahf(), str, i);
        if (a == null) {
            ArrayList<com.baidu.tieba.tbadkCore.b.k> ahf = pbData.ahf();
            int size = ahf.size();
            for (int i2 = 0; i2 < size; i2++) {
                a = a(ahf.get(i2).ahs(), str, i);
                if (a != null) {
                    return a;
                }
            }
            return a;
        }
        return a;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.b.k> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> zZ;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a ahu = arrayList.get(i2).ahu();
            if (ahu != null && (zZ = ahu.zZ()) != null) {
                int size = zZ.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (zZ.get(i4) != null && zZ.get(i4).getType() == 8) {
                        i3++;
                        if (zZ.get(i4).Ae().Am().equals(str)) {
                            int width = zZ.get(i4).Ae().getWidth();
                            int height = zZ.get(i4).Ae().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.bAO = i4;
                            return ahu;
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
        com.baidu.tbadk.widget.richText.g Ae = cVar.Ae();
        if (Ae != null) {
            if (!StringUtils.isNull(Ae.Ak())) {
                return Ae.Ak();
            }
            if (Ae.getHeight() * Ae.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Ae.getHeight() * Ae.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Ae.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Ae.getHeight())));
            } else {
                float width = Ae.getWidth() / Ae.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.bf.aE(Ae.getSrc()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onPhoneClicked(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mPhoneNumber = str;
            if (this.bAl == null) {
                Xf();
            }
            com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "pb_show_phonedialog");
            if (str2.equals("2")) {
                this.bAl.bH(1).setVisibility(8);
            } else {
                this.bAl.bH(1).setVisibility(0);
            }
            this.bAl.nS();
        }
    }

    @Override // com.baidu.tbadk.core.voice.o
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xr() {
        hideNetRefreshView(this.bAw.getView());
        showLoadingView(this.bAw.getView(), true);
        if (this.bAr.xF()) {
            this.bAw.YA();
        }
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m getRealView(VoiceData.VoiceModel voiceModel) {
        View Zg;
        View findViewWithTag;
        if (!this.bAw.YJ() || (Zg = this.bAw.Zg()) == null || (findViewWithTag = Zg.findViewWithTag(voiceModel)) == null) {
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
        if (this.bAr.UA()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.tbadkCore.b.i pbData = this.bAr.getPbData();
            String name = pbData.aeI().getName();
            String title = pbData.ahe().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.bAr.XF() + "?share=9105&fr=share";
            String[] ax = pbData.ax(getPageContext().getPageActivity());
            String str2 = ax[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String format = MessageFormat.format(getResources().getString(com.baidu.tieba.z.share_content_tpl), title, name, ax[1]);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.Tn = str;
            if (parse != null) {
                fVar.To = parse;
            }
            this.aKe = new com.baidu.tbadk.coreExtra.share.d(getPageContext().getPageActivity());
            this.aKe.a(fVar, true);
            this.aKe.a(getShareMtjStatInfo());
            this.aKe.ay(true);
            TextView w = this.aKe.w(com.baidu.tieba.z.share_tieba_qunzu, com.baidu.tieba.v.icon_unite_share_qunzu);
            this.aKe.a(w);
            TextView w2 = this.aKe.w(com.baidu.tieba.z.forum_friend, com.baidu.tieba.v.icon_unite_share_baf);
            this.aKe.a(w2);
            w2.setOnClickListener(new av(this));
            w.setOnClickListener(new aw(this));
            this.aKe.d(new ax(this, fVar));
            this.aKe.show();
        }
    }

    private SparseArray<String> getShareMtjStatInfo() {
        if (this.aKh == null) {
            this.aKh = new SparseArray<>(7);
            this.aKh.put(2, "pb_wx_timeline");
            this.aKh.put(3, "pb_wx_friend");
            this.aKh.put(4, "pb_qq_zone");
            this.aKh.put(5, "pb_tencent_weibo");
            this.aKh.put(6, "pb_sina_weibo");
            this.aKh.put(7, "pb_renren");
        }
        return this.aKh;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool() {
        if (this.akg == null) {
            this.akg = new com.baidu.adp.lib.e.b<>(new ay(this), 15, 0);
        }
        return this.akg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xs() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.tbadkCore.b.i pbData = this.bAr.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.mK().isIfAddition();
            AdditionData ahh = pbData.ahh();
            boolean z3 = ahh == null ? false : isIfAddition;
            if (z3) {
                z = ahh.getAlreadyCount() != ahh.getTotalCount();
                if (!TextUtils.isEmpty(ahh.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.main.b.a aVar = this.bAw.bCX;
            if (!z3 || !z) {
                z2 = false;
            }
            aVar.ec(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bAw.Ym() == view) {
            com.baidu.tbadk.core.data.x ahe = this.bAr.getPbData().ahe();
            View childAt = ((ViewGroup) view).getChildAt(0);
            if (childAt != null) {
                boolean z = ahe.getPraise() == null || ahe.getPraise().getIsLike() == 0;
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

    public void Gd() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }
}
