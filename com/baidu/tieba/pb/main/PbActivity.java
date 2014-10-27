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
    private static String aPY = "tbgametype";
    private com.baidu.adp.lib.e.b<TbImageView> Iu;
    private com.baidu.adp.lib.e.b<ImageView> abM;
    private com.baidu.adp.lib.e.b<TextView> abN;
    private com.baidu.adp.lib.e.b<View> abO;
    private com.baidu.adp.lib.e.b<LinearLayout> abP;
    private com.baidu.adp.lib.e.b<GifView> abQ;
    private VoiceManager ayo;
    private com.baidu.tieba.location.d ays;
    private String ayx;
    private String buA;
    private VoiceData.VoiceModel buB;
    private String buR;
    private String buq;
    private AlertDialog buz;
    private boolean aiJ = false;
    private com.baidu.tbadk.core.dialog.a bus = null;
    private String but = null;
    private String ato = null;
    private String buu = null;
    private String buv = null;
    private String mPackageName = null;
    private int buw = 0;
    private com.baidu.tbadk.core.dialog.i bux = null;
    SparseArray<String> buy = null;
    private long aAK = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private WriteData aAM = new WriteData();
    private long Zb = 0;
    private long createTime = 0;
    private long Zc = 0;
    private boolean buC = false;
    private com.baidu.tbadk.performanceLog.a buD = null;
    public long buE = System.currentTimeMillis();
    private String buF = null;
    private final Handler mHandler = new Handler(new b(this));
    private bn buG = null;
    private com.baidu.tieba.model.aj buH = null;
    private com.baidu.tieba.model.ar ayz = null;
    private com.baidu.tieba.model.ad buI = null;
    private com.baidu.tieba.pb.sub.e buJ = null;
    private com.baidu.tieba.model.v buK = null;
    private bv buL = null;
    public final com.baidu.tieba.pb.main.a.a buM = new com.baidu.tieba.pb.main.a.a(this);
    private boolean buN = false;
    private boolean buO = false;
    private MorePopupWindow buP = null;
    private bu buQ = null;
    private boolean aAj = false;
    private com.baidu.tieba.location.i ayD = new x(this);
    private com.baidu.tieba.location.j ayE = new ai(this);
    private boolean ayt = false;
    private df ayI = new df(this, new at(this));
    private long ayT = 0;
    private boolean ayU = true;
    public final View.OnClickListener aCW = new ba(this);
    private final bq buS = new bc(this);
    private final com.baidu.tieba.model.al buT = new bd(this);
    private final AbsListView.OnScrollListener uN = new be(this);
    private final AbsListView.OnScrollListener buU = new c(this);
    private final com.baidu.tieba.pb.sub.g buV = new d(this);
    private final com.baidu.tieba.model.as ayC = new e(this);
    private final com.baidu.adp.base.h buW = new f(this);
    private final bg buX = new g(this);
    private final com.baidu.adp.widget.ListView.f aQz = new h(this);
    private final com.baidu.adp.widget.ListView.aa buY = new i(this);
    private final com.baidu.adp.widget.ListView.ad buZ = new j(this);
    private final DialogInterface.OnClickListener bal = new k(this);
    private final com.baidu.adp.base.h bva = new l(this);
    private AlertDialog ayG = null;
    private final cw bvb = new n(this);
    private int bvc = 0;
    private final com.baidu.tbadk.widget.richText.s acf = new o(this);
    boolean bvd = false;
    com.baidu.tieba.data.ak bve = null;
    private final DialogInterface.OnClickListener bvf = new p(this);
    private final View.OnLongClickListener NU = new q(this);
    private final com.baidu.tbadk.core.view.u aBc = new r(this);
    com.baidu.tbadk.coreExtra.share.d aIb = null;

    static {
        HM();
        VY();
        CustomMessageTask customMessageTask = new CustomMessageTask(2004001, new m());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        VZ();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m251getInst().isGpuOpen();
    }

    private static void HM() {
        com.baidu.tieba.ai.a(302001, pbPageSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, com.baidu.tieba.ai.s("c/f/pb/page", 302001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.location.d.Su();
    }

    private static void VY() {
        com.baidu.tieba.ai.b(2004003, cx.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ew() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this)));
    }

    public void Ex() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this)) {
            showToast(com.baidu.tieba.y.location_system_permission_prompt);
        } else if (!TbadkApplication.m251getInst().getLocationShared()) {
            Ey();
        } else if (this.ays.St()) {
            Ew();
        } else {
            this.ays.dx(false);
            if (this.buL.EO() != null) {
                this.buL.EO().setLocationViewVisibility(0);
                this.buL.EO().setLocationInfoViewState(1);
            }
            this.ays.Sr();
        }
    }

    private void Ey() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.aX(com.baidu.tieba.y.location_app_permission_prompt).a(com.baidu.tieba.y.isopen, new s(this)).b(com.baidu.tieba.y.cancel, new t(this)).kT();
        aVar.kW();
    }

    public void Ez() {
        if (this.buL.EO() != null) {
            if (this.ays.Sv()) {
                this.buL.EO().setLocationViewVisibility(0);
                if (this.ays.St()) {
                    this.ayD.a(com.baidu.tieba.location.c.So().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.m.isNetOk()) {
                    this.buL.EO().setLocationInfoViewState(1);
                    this.ays.Sr();
                    return;
                } else {
                    this.buL.EO().setLocationInfoViewState(0);
                    return;
                }
            }
            this.buL.EO().setLocationViewVisibility(8);
        }
    }

    private static void VZ() {
        com.baidu.tbadk.core.util.bf.mR().a(new u());
    }

    private void Bq() {
        this.buL.Bt();
        this.buL.Xn();
    }

    private void Br() {
        this.buL.Bs();
        this.buL.Xp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wa() {
        com.baidu.tieba.data.ah pbData;
        com.baidu.tbadk.core.data.q zK;
        if (!this.ayt) {
            if (!com.baidu.adp.lib.util.m.isNetOk()) {
                showToast(com.baidu.tieba.y.no_network_guide);
            } else if (this.ayU) {
                this.ayt = true;
                if (this.buG != null && (pbData = this.buG.getPbData()) != null && (zK = pbData.zK()) != null) {
                    int isLike = zK.getPraise() == null ? 0 : zK.getPraise().getIsLike();
                    if (this.ayI != null) {
                        this.ayI.a(zK.kG(), zK.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eD(int i) {
        com.baidu.tbadk.core.data.q zK;
        String sb;
        String sb2;
        if (this.buG != null && this.buG.getPbData() != null && (zK = this.buG.getPbData().zK()) != null) {
            if (i == 1) {
                PraiseData praise = zK.getPraise();
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
                        zK.setPraise(praiseData);
                    } else {
                        zK.getPraise().getUser().add(0, metaData);
                        zK.getPraise().setNum(zK.getPraise().getNum() + 1);
                        zK.getPraise().setIsLike(i);
                    }
                }
                if (zK.getPraise() != null) {
                    if (zK.getPraise().getNum() < 1) {
                        sb2 = getResources().getString(com.baidu.tieba.y.frs_item_praise_text);
                    } else {
                        sb2 = new StringBuilder(String.valueOf(zK.getPraise().getNum())).toString();
                    }
                    this.buL.B(sb2, true);
                }
            } else if (zK.getPraise() != null) {
                zK.getPraise().setIsLike(i);
                zK.getPraise().setNum(zK.getPraise().getNum() - 1);
                ArrayList<MetaData> user = zK.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkApplication.getCurrentAccountObj().getID())) {
                            zK.getPraise().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (zK.getPraise().getNum() < 1) {
                    sb = getResources().getString(com.baidu.tieba.y.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(zK.getPraise().getNum())).toString();
                }
                this.buL.B(sb, false);
            }
            if (this.buG.WG()) {
                this.buL.Xt().notifyDataSetChanged();
            } else {
                this.buL.f(this.buG.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.buG.saveToBundle(bundle);
        if (this.buG.WJ()) {
            this.buJ.saveToBundle(bundle);
        }
        if (this.ayo != null) {
            this.ayo.onSaveInstanceState(this);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ayx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.aAK = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aAK = System.currentTimeMillis();
        }
        this.buw = 0;
        initUI();
        this.ayo = new VoiceManager();
        this.ayo.onCreate(this);
        d(bundle);
        addGlobalLayoutListener();
        this.createTime = System.currentTimeMillis() - this.aAK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.buL != null) {
            if (this.buL.EO() != null) {
                this.buL.EO().BE();
            }
            if (this.buL.Xo() != null && this.buL.Xo().EO() != null) {
                this.buL.Xo().EO().BE();
            }
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.ayo != null) {
            this.ayo.onStart(this);
        }
    }

    public bn Wb() {
        return this.buG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.aiJ = true;
        super.onPause();
        BdListView listView = getListView();
        this.buw = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.buw == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.ayo != null) {
            this.ayo.onPause(this);
        }
        if (this.buL != null) {
            this.buL.onPause();
        }
        if (!this.buG.WJ()) {
            WriteData EC = this.ayz.EC();
            if (EC == null) {
                EC = new WriteData(1);
                EC.setThreadId(this.buG.WF());
                EC.setWriteImagesInfo(this.writeImagesInfo);
            }
            EC.setContent(this.buL.EU());
            if (this.aAM != null && this.aAM.getIsBaobao()) {
                EC.setBaobaoContent(this.aAM.getBaobaoContent());
                EC.setBaobaoImagesInfo(this.baobaoImagesInfo);
                EC.setIsBaobao(true);
            }
            com.baidu.tieba.util.l.b(this.buG.WF(), EC);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        this.aiJ = false;
        super.onResume();
        if (this.buw == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView Xg = this.buL.Xg();
        if (Xg != null && Xg.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            Xg.Z(false);
        }
        if (this.ayo != null) {
            this.ayo.onResume(this);
        }
        if (this.buL.EO() != null) {
            this.buL.EO().refresh();
        }
    }

    @Override // com.baidu.tieba.util.m
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!com.baidu.tbadk.core.util.ay.aA(writeData.getContent()) && com.baidu.tbadk.core.util.ay.aA(this.buL.EU())) {
                this.buA = writeData.getContent();
                this.buL.fc(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                this.buL.a(this.writeImagesInfo, true);
            }
            if (TbadkApplication.m251getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.aAM.setIsBaobao(writeData.getIsBaobao());
                this.aAM.setBaobaoContent(writeData.getBaobaoContent());
                this.aAM.setBaobaoImagesInfo(this.baobaoImagesInfo);
                this.buL.setBaobaoUris(this.baobaoImagesInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.buL.EO() != null && this.buL.EO().getVisibility() != 0) {
            Wd();
            this.buL.Xj();
        }
        if (!this.buL.XJ()) {
            this.buL.XL();
        }
        this.buL.bxj.Yr();
        if (this.buG != null && this.buG.getPbData() != null && this.buG.getPbData().zJ() != null && this.buG.getPbData().zK() != null) {
            com.baidu.tbadk.distribute.a.ra().a(this, "pb", this.buG.getPbData().zJ().getId(), com.baidu.adp.lib.g.c.a(this.buG.getPbData().zK().getId(), 0L));
        }
        if (this.ayo != null) {
            this.ayo.onStop(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (!this.buC) {
            this.buC = true;
            this.buL.Yk();
        }
        this.buG.cancelLoadData();
        this.buG.xY();
        this.ayz.cancelLoadData();
        this.buI.cancelLoadData();
        this.ays.cancelLoadData();
        this.buJ.cancelLoadData();
        this.buJ.xY();
        this.buK.cancelLoadData();
        this.buL.onDestroy();
        if (this.buD != null) {
            this.buD.onDestroy();
        }
        super.onDestroy();
        if (this.ayo != null) {
            this.ayo.onDestory(this);
        }
    }

    public void Wc() {
        if (this.buL.EO() != null) {
            this.buL.EO().setContent(this.buA == null ? "" : this.buA);
            if (this.buB != null) {
                this.buL.EO().BO();
            }
            this.buL.a(this.writeImagesInfo, true);
            this.buL.setBaobaoUris(this.baobaoImagesInfo);
            if (this.buA != null || this.buB != null) {
                this.buL.EO().BX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wd() {
        if (this.buL.EO() != null) {
            this.buA = this.buL.EO().getContent();
            this.buB = this.buL.getAudioData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.buL.onChangeSkinType(i);
        if (this.buP != null) {
            this.buP.onChangeSkinType(this, i, com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.bg_collect));
        }
        if (this.buL.Xg() != null) {
            this.buL.Xg().onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void We() {
        this.buQ = new bu(this, this.aCW);
        this.buP = new MorePopupWindow(this, this.buQ.getView(), getResources().getDrawable(com.baidu.tieba.u.bg_collect), null);
        this.buP.setTouchInterceptor(new v(this));
        this.buP.onChangeSkinType(this, TbadkApplication.m251getInst().getSkinType(), com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.bg_collect));
    }

    private void initUI() {
        this.buL = new bv(this, this.aCW);
        this.buL.setOnActionListener(new w(this));
        this.buL.setOnScrollListener(this.uN);
        this.buL.a(this.buU);
        this.buL.c(this.buY);
        this.buL.a(this.buZ);
        this.buL.e(this.bal);
        this.buL.a(this.aQz);
        this.buL.dX(com.baidu.tbadk.core.k.js().jw());
        this.buL.dY(com.baidu.tbadk.core.k.js().ju());
        this.buL.setOnImageClickListener(this.acf);
        this.buL.b(this.NU);
        this.buL.a(this.bvb);
        this.buL.f(this.aBc);
        this.buL.a(this.buX);
        showLoadingView(this.buL.getView(), true);
    }

    private void Wf() {
        if (this.bux == null) {
            this.bux = new com.baidu.tbadk.core.dialog.i(this);
            this.bux.a(new Object[]{getString(com.baidu.tieba.y.call_phone), getString(com.baidu.tieba.y.sms_phone), getString(com.baidu.tieba.y.search_in_baidu)}, new y(this)).bd(com.baidu.tbadk.core.dialog.k.BH).be(80).kZ();
        }
    }

    private void d(Bundle bundle) {
        this.buG = new bn(this);
        this.buG.a(this.buS);
        this.buH = new com.baidu.tieba.model.aj(this);
        this.buH.a(this.buT);
        this.ayz = new com.baidu.tieba.model.ar(this);
        this.ayz.a(this.ayC);
        this.buI = new com.baidu.tieba.model.ad(this);
        this.buI.setLoadDataCallBack(this.bva);
        this.buJ = new com.baidu.tieba.pb.sub.e(this);
        this.buJ.a(this.buV);
        this.buK = new com.baidu.tieba.model.v(this);
        this.buK.setLoadDataCallBack(this.buW);
        this.ays = new com.baidu.tieba.location.d(this);
        this.ays.a(this.ayD);
        this.ays.a(this.ayE);
        if (bundle != null) {
            this.buG.initWithBundle(bundle);
        } else {
            this.buG.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, -1) == 18003) {
            this.buG.ec(true);
        }
        bs.WZ().A(this.buG.WD(), this.buG.getIsFromMark());
        if (!this.buG.WJ()) {
            this.buL.XA();
            this.buG.tL();
        } else {
            if (bundle != null) {
                this.buJ.initWithBundle(bundle);
            } else {
                this.buJ.initWithIntent(getIntent());
            }
            this.buR = this.buJ.zV();
            String stType = this.buJ.getStType();
            if (stType != null && (("mention".equals(this.buJ.getStType()) || stType.equals("person_post_reply")) && this.buR != null)) {
                this.buL.XN();
            } else {
                this.buL.XG();
            }
            this.buJ.YP();
        }
        this.buL.a(new z(this));
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.ayx = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!this.buG.WJ()) {
            com.baidu.tieba.util.l.a(this.buG.WF(), this);
        }
        this.ayI.setUniqueId(getUniqueId());
        this.ayI.registerListener();
    }

    public void Wg() {
        this.buL.bxj.e(this.buG.WG(), this.buH.zN());
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
        Wr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Boolean bool) {
        com.baidu.tieba.data.ah pbData;
        String str = null;
        if (this.buG != null && (pbData = this.buG.getPbData()) != null && pbData.zJ() != null) {
            str = pbData.zJ().getName();
        }
        if (com.baidu.tieba.e.b.b(str, bool)) {
            Br();
        } else {
            Bq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Boolean bool) {
        if (com.baidu.tieba.e.b.b(str, bool)) {
            Br();
        } else {
            Bq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            if (!this.buG.WJ()) {
                antiData.setBlock_forum_name(this.buG.getPbData().zJ().getName());
                antiData.setBlock_forum_id(this.buG.getPbData().zJ().getId());
                antiData.setUser_name(this.buG.getPbData().getUserData().getUserName());
                antiData.setUser_id(this.buG.getPbData().getUserData().getUserId());
            } else {
                antiData.setBlock_forum_name(this.buJ.YK().Aw().getName());
                antiData.setBlock_forum_id(this.buJ.YK().Aw().getId());
                antiData.setUser_name(TbadkApplication.getCurrentAccountName());
                antiData.setUser_id(TbadkApplication.getCurrentAccount());
            }
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        this.buL.showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.x xVar) {
        int i = 0;
        if (xVar != null) {
            this.buL.a(0, xVar.qa, xVar.boO, true);
            if (xVar.qa) {
                if (xVar.boK == 1) {
                    ArrayList<com.baidu.tieba.data.ak> zL = this.buG.getPbData().zL();
                    int size = zL.size();
                    while (true) {
                        if (i < size) {
                            if (!xVar.mPostId.equals(zL.get(i).getId())) {
                                i++;
                            } else {
                                zL.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.buL.e(this.buG.getPbData());
                } else if (xVar.boK == 0) {
                    Wh();
                } else if (xVar.boK == 2) {
                    ArrayList<com.baidu.tieba.data.ak> zL2 = this.buG.getPbData().zL();
                    int size2 = zL2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < zL2.get(i2).Ab().size()) {
                                if (!xVar.mPostId.equals(zL2.get(i2).Ab().get(i3).getId())) {
                                    i3++;
                                } else {
                                    zL2.get(i2).Ab().remove(i3);
                                    zL2.get(i2).Ac();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData zR = this.buG.getPbData().zR();
                        com.baidu.tieba.data.ak akVar = zL2.get(i2);
                        ArrayList<com.baidu.tieba.data.ak> Ad = akVar.Ad();
                        int size3 = Ad.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!xVar.mPostId.equals(zL2.get(i2).Ad().get(i4).getId())) {
                                    i4++;
                                } else {
                                    Ad.remove(i4);
                                    zR.decreaseAlreadyCount();
                                    if (akVar.Ak() > Ad.size()) {
                                        akVar.eh(Ad.size());
                                    }
                                    if (Ad.size() > 0) {
                                        com.baidu.tieba.data.ak akVar2 = Ad.get(Ad.size() - 1);
                                        zR.setLastAdditionTime(akVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a Af = akVar2.Af();
                                        String str = "";
                                        if (Af != null) {
                                            str = Af.toString();
                                        }
                                        zR.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a Af2 = akVar.Af();
                                        String str2 = "";
                                        if (Af2 != null) {
                                            str2 = Af2.toString();
                                        }
                                        zR.setLastAdditionContent(str2);
                                    }
                                    Ws();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.buL.e(this.buG.getPbData());
                    }
                    if (this.buL.XJ()) {
                        this.buJ.hb(xVar.mPostId);
                        this.buL.a(this.buJ.YK(), this.buG.getPbData().zQ());
                        if (!z) {
                            String zV = this.buJ.zV();
                            while (i < size2) {
                                if (!zV.equals(zL2.get(i).getId())) {
                                    i++;
                                } else {
                                    zL2.get(i).Ac();
                                    this.buL.e(this.buG.getPbData());
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
        this.buL.a(1, zVar.qa, zVar.boO, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.ab abVar) {
        this.buL.a(this.buK.getLoadDataMode(), abVar.qa, abVar.boO, false);
        this.buL.B(abVar.boR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.model.ab abVar) {
        if (abVar != null) {
            this.buL.a(this.buK.getLoadDataMode(), abVar.qa, abVar.boO, true);
            if (abVar.qa) {
                this.buO = true;
                if (i == 2) {
                    this.buG.getPbData().zK().aU(1);
                    this.buG.setIsGood(1);
                } else if (i == 3) {
                    this.buG.getPbData().zK().aU(0);
                    this.buG.setIsGood(0);
                } else if (i == 4) {
                    this.buG.getPbData().zK().aT(1);
                    this.buG.gK(1);
                } else if (i == 5) {
                    this.buG.getPbData().zK().aT(0);
                    this.buG.gK(0);
                }
                this.buL.a(this.buG.getPbData(), this.buG.WG(), true);
            }
        }
    }

    private void Wh() {
        if (this.buG.WH()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.buG.WF());
            setResult(-1, intent);
        }
        if (Wn()) {
            super.closeActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wi() {
        super.closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        this.buL.Yd();
        if (this.buG != null && this.buG.getPbData() != null) {
            com.baidu.tieba.pb.history.f fVar = new com.baidu.tieba.pb.history.f(this);
            com.baidu.tieba.data.ai aiVar = new com.baidu.tieba.data.ai();
            aiVar.setThreadId(this.buG.getPbData().zK().getId());
            aiVar.setForumName(this.buG.getPbData().zJ().getName());
            aiVar.ex(this.buG.getPbData().zK().getTitle());
            ArrayList<com.baidu.tieba.data.ak> zL = this.buG.getPbData().zL();
            int XP = this.buL.XP();
            if (zL != null && XP >= 0 && XP < zL.size()) {
                aiVar.ey(zL.get(XP).getId());
            }
            aiVar.bt(this.buG.getHostMode());
            aiVar.bu(this.buG.WG());
            fVar.a((com.baidu.tieba.pb.history.f) aiVar);
        }
        if (this.buG != null && this.buG.WH()) {
            Intent intent = new Intent();
            if (this.buO) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.buG.WF());
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.buG.WI());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.buG.getIsGood());
            }
            setResult(-1, intent);
        }
        if (Wn()) {
            if (this.buG != null && this.buL != null && this.buL.ud() != null) {
                com.baidu.tieba.data.ah pbData = this.buG.getPbData();
                if (pbData != null && pbData.getUserData() != null) {
                    pbData.getUserData().setBimg_url(TbadkApplication.m251getInst().getDefaultBubble());
                }
                bs.WZ().a(this.buG.getPbData(), this.buL.ud().onSaveInstanceState(), this.buG.WG(), this.buG.getHostMode());
            } else {
                bs.WZ().reset();
            }
            super.closeActivity();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.buP != null) {
                    com.baidu.adp.lib.g.j.a(this.buP, this);
                }
                if (this.buL.ej(this.buG.WJ())) {
                    EA();
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
        String format;
        int size;
        int size2;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    eX(null);
                    return;
                case 11009:
                    Wl();
                    return;
                case LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_11_025 /* 11025 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this, 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this, 12005, true)));
                    return;
                case 11027:
                    eX(this.buL.XR());
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
                        Wk();
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            this.buL.XO();
                            this.ayz.dI(false);
                            return;
                        }
                        this.buI.gS(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    Wk();
                    ArrayList<String> p = com.baidu.tieba.util.i.p(intent);
                    if (p != null) {
                        this.buL.o(p);
                        return;
                    }
                    return;
                case 12005:
                    Wk();
                    new Handler().postDelayed(new aa(this), 200L);
                    ArrayList<String> p2 = com.baidu.tieba.util.i.p(intent);
                    if (p2 != null) {
                        this.buL.C(p2);
                        return;
                    }
                    return;
                case 12006:
                    WriteData EC = this.ayz.EC();
                    if (EC != null) {
                        EC.deleteUploadedTempImages();
                    }
                    this.aAM.setIsBaobao(false);
                    this.aAM.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.ayz.b((WriteData) null);
                    this.ayz.dI(false);
                    this.buL.bQ(true);
                    if (this.buL.XJ()) {
                        this.buJ.YN();
                    } else {
                        if (this.buG != null && this.buG.WM()) {
                            this.buL.XA();
                        }
                        if (this.buG != null && this.buG.WF() != null && !this.buG.WJ()) {
                            com.baidu.tieba.util.l.b(this.buG.WF(), (WriteData) null);
                        }
                    }
                    this.buL.a(this.writeImagesInfo, true);
                    return;
                case 12009:
                case 12010:
                    Wk();
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
                    AdditionData zR = this.buG.getPbData().zR();
                    int totalCount = zR.getTotalCount();
                    int alreadyCount = zR.getAlreadyCount() + 1;
                    if (totalCount != alreadyCount) {
                        format = String.format(getString(com.baidu.tieba.y.write_addition_success), Integer.valueOf(totalCount - alreadyCount));
                    } else {
                        format = String.format(getString(com.baidu.tieba.y.write_addition_success1), new Object[0]);
                    }
                    com.baidu.adp.lib.util.m.showToast(this, format);
                    bs.WZ().reset();
                    this.mHandler.postDelayed(new ab(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.buG != null) {
                        a(Wj(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getIntExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0));
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
                ED();
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
                Wk();
                return;
        }
    }

    private ShareFromPBMsgData Wj() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] N = this.buG.getPbData().N(this);
        com.baidu.tieba.data.ak Xi = this.buL.Xi();
        String str = "";
        if (Xi != null) {
            str = Xi.getId();
            String R = Xi.R(this);
            if (!com.baidu.adp.lib.util.l.aA(R)) {
                N[1] = R;
            }
        }
        String kG = this.buG.getPbData().zK().kG();
        if (kG != null && kG.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(N[1]);
        shareFromPBMsgData.setImageUrl(N[0]);
        shareFromPBMsgData.setForumName(this.buG.getPbData().zJ().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.buG.getPbData().zK().getId());
        shareFromPBMsgData.setTitle(this.buG.getPbData().zK().getTitle());
        return shareFromPBMsgData;
    }

    private void l(Intent intent) {
        a(Wj(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.buG != null && this.buG.getPbData() != null && this.buG.getPbData().zK() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
            aVar.bf(this.buG.getPbData().zK().getTitle());
            cy cyVar = new cy(this);
            cyVar.setData(shareFromPBMsgData);
            aVar.j(cyVar);
            aVar.a(com.baidu.tieba.y.share, new ac(this, j, str, str2, cyVar, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.y.alert_no_button, new ad(this, cyVar));
            aVar.P(false);
            aVar.kT().kW();
            if (!com.baidu.adp.lib.util.l.aA(shareFromPBMsgData.getImageUrl())) {
                cyVar.C(shareFromPBMsgData.getImageUrl(), this.buG.getPbData().yU() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, int i2) {
        if (this.buG != null && this.buG.getPbData() != null && this.buG.getPbData().zK() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
            aVar.bf(this.buG.getPbData().zK().getTitle());
            cy cyVar = new cy(this);
            cyVar.setData(shareFromPBMsgData);
            aVar.j(cyVar);
            aVar.a(com.baidu.tieba.y.share, new ae(this, i, str, i2, cyVar, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.y.alert_no_button, new af(this, cyVar));
            aVar.P(false);
            aVar.kT().kW();
            if (!com.baidu.adp.lib.util.l.aA(shareFromPBMsgData.getImageUrl())) {
                cyVar.C(shareFromPBMsgData.getImageUrl(), this.buG.getPbData().yU() == 1);
            }
        }
    }

    private void e(Intent intent) {
        a(intent, true);
    }

    private void g(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ayx;
        if (!TextUtils.isEmpty(str)) {
            try {
                int bl = com.baidu.tbadk.core.util.d.bl(str);
                if (bl != 0) {
                    Bitmap a = com.baidu.tbadk.core.util.d.a(str, com.baidu.adp.lib.util.m.dip2px(this, com.baidu.adp.lib.util.m.n(this)), com.baidu.adp.lib.util.m.dip2px(this, com.baidu.adp.lib.util.m.o(this)));
                    Bitmap e = com.baidu.tbadk.core.util.d.e(a, bl);
                    if (a != e) {
                        a.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.ayx, e, 100);
                    e.recycle();
                }
            } catch (Exception e2) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            this.buL.a(this.writeImagesInfo, true);
        }
        if (this.buL.EO() != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            this.buL.EO().er(23);
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
                    this.buL.a(this.writeImagesInfo, z);
                }
            }
            if (this.buL.EO() != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                this.buL.EO().er(23);
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
                this.buL.setBaobaoUris(this.baobaoImagesInfo);
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    if (this.buL.EO() != null) {
                        this.buL.EO().er(50);
                    }
                    this.aAM.setIsBaobao(true);
                    this.aAM.setBaobaoContent(stringExtra2);
                    this.aAM.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.aAM.setIsBaobao(false);
                this.aAM.setBaobaoContent("");
                this.aAM.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void ED() {
        new ag(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EB() {
        if (this.ayG == null) {
            String[] strArr = {getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.y.operation));
            builder.setItems(strArr, new ah(this));
            this.ayG = builder.create();
            this.ayG.setCanceledOnTouchOutside(true);
        }
    }

    private void Wk() {
        if (this.buN) {
            this.buN = false;
            new Handler().postDelayed(new aj(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wl() {
        MarkData gQ = this.buG.gQ(this.buL.XP());
        if (gQ != null) {
            this.buL.XA();
            this.buH.b(gQ);
            if (!this.buH.zN()) {
                this.buH.TI();
                TiebaStatic.eventStat(this, "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.buH.TJ();
            TiebaStatic.eventStat(this, "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(String str) {
        VoiceData.VoiceModel Xq;
        if (this.ayz.EC() == null) {
            if (!this.buG.WJ()) {
                this.ayz.b(this.buG.gW(str));
            } else {
                this.ayz.b(this.buJ.EC());
            }
        }
        if (this.ayz.EC() != null) {
            if (!this.buG.WJ()) {
                this.ayz.EC().setWriteImagesInfo(this.writeImagesInfo);
                this.ayz.dI(this.writeImagesInfo.size() > 0);
                if (this.aAM.getIsBaobao()) {
                    this.ayz.EC().setIsBaobao(true);
                    this.ayz.EC().setBaobaoContent(this.aAM.getBaobaoContent());
                    this.ayz.EC().setBaobaoImagesInfo(this.baobaoImagesInfo);
                } else {
                    this.ayz.EC().setIsBaobao(false);
                }
            }
            if (this.buL.EO() != null) {
                this.ayz.EC().setHasLocationData(this.buL.EO().getLocationInfoViewState() == 2);
            }
            if (str == null) {
                this.ayz.EC().setContent(this.buL.EU());
                Xq = this.buL.getAudioData();
                this.buL.BQ();
            } else {
                this.ayz.EC().setContent(this.buL.XQ());
                this.ayz.EC().setRepostId(this.buL.XS());
                Xq = this.buL.Xq();
                this.buL.Xr();
            }
            if (Xq != null) {
                if (Xq.getId() != null) {
                    this.ayz.EC().setVoice(Xq.getId());
                    this.ayz.EC().setVoiceDuringTime(Xq.duration);
                } else {
                    this.ayz.EC().setVoice(null);
                    this.ayz.EC().setVoiceDuringTime(-1);
                }
            } else {
                this.ayz.EC().setVoice(null);
                this.ayz.EC().setVoiceDuringTime(-1);
            }
            if (!this.ayz.TS()) {
                showToast(com.baidu.tieba.y.write_img_limit);
            } else if (this.ayz.TR()) {
                this.buL.ET();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wm() {
        com.baidu.tieba.data.ah pbData = this.buG.getPbData();
        this.buG.eb(true);
        pbData.ew(this.buH.zO());
        this.buL.e(pbData);
    }

    private boolean Wn() {
        if (this.buG == null) {
            return true;
        }
        if (this.buG.zN()) {
            MarkData WR = this.buG.WR();
            if (WR == null || !this.buG.getIsFromMark()) {
                return true;
            }
            MarkData gQ = this.buG.gQ(this.buL.XP());
            if (gQ == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, WR);
                setResult(-1, intent);
                Wi();
                return true;
            } else if (gQ.getPostId() == null || gQ.getPostId().equals(WR.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, WR);
                setResult(-1, intent2);
                Wi();
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
                aVar.bg(String.format(getString(com.baidu.tieba.y.alert_update_mark), Integer.valueOf(gQ.getFloor())));
                aVar.a(com.baidu.tieba.y.alert_yes_btn, new ak(this, gQ, WR));
                aVar.b(com.baidu.tieba.y.alert_no_button, new al(this, WR));
                aVar.kT();
                aVar.kW();
                return false;
            }
        } else if (this.buG.getPbData() == null || this.buG.getPbData().zL() == null || this.buG.getPbData().zL().size() <= 0 || !this.buG.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.ae
    /* renamed from: ud */
    public BdListView getListView() {
        if (this.buL == null) {
            return null;
        }
        return this.buL.ud();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int vN() {
        if (this.buL == null) {
            return 0;
        }
        return this.buL.XW();
    }

    @Override // com.baidu.tbadk.core.view.ae
    public int nC() {
        if (this.buL == null) {
            return 0;
        }
        return this.buL.Eu();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<ImageView> vO() {
        if (this.abM == null) {
            this.abM = new com.baidu.adp.lib.e.b<>(new am(this), 8, 0);
        }
        return this.abM;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<TextView> vP() {
        if (this.abN == null) {
            this.abN = TbRichTextView.i(this, 8);
        }
        return this.abN;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<GifView> vQ() {
        if (this.abQ == null) {
            this.abQ = new com.baidu.adp.lib.e.b<>(new an(this), 20, 0);
        }
        return this.abQ;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<View> vR() {
        if (this.abO == null) {
            this.abO = new com.baidu.adp.lib.e.b<>(new ao(this), 8, 0);
        }
        return this.abO;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public com.baidu.adp.lib.e.b<TbImageView> nD() {
        if (this.Iu == null) {
            this.Iu = UserIconBox.f(this, 8);
        }
        return this.Iu;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void s(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this, str, null)));
    }

    public boolean fB(String str) {
        Map<String, String> bT;
        if (!TextUtils.isEmpty(str) && (bT = com.baidu.tbadk.core.util.bf.bT(com.baidu.tbadk.core.util.bf.bU(str))) != null) {
            String str2 = bT.get(ImageViewerConfig.URL);
            if (!TextUtils.isEmpty(str2)) {
                return fB(com.baidu.adp.lib.util.l.aD(str2));
            }
            String str3 = bT.get(aPY);
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
                    Wo();
                } else {
                    Wp();
                }
            } else if (fB(str)) {
                com.baidu.tbadk.game.a.a(getApplicationContext(), null, str, null);
            } else {
                com.baidu.tbadk.core.util.bf.mR().b(context, new String[]{str});
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
                            this.buu = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.buv = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.ato = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.but = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void Wo() {
        if (TextUtils.isEmpty(this.buu) || TextUtils.isEmpty(this.buv) || TextUtils.isEmpty(this.mPackageName)) {
            if (!TextUtils.isEmpty(this.but)) {
                com.baidu.tbadk.browser.a.i(this, this.but);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(this.buu));
        intent.setAction(this.buv);
        intent.setPackage(this.mPackageName);
        if (intent.resolveActivity(getPackageManager()) != null) {
            if (!com.baidu.adp.lib.g.i.a(this, intent) && !TextUtils.isEmpty(this.but)) {
                com.baidu.tbadk.browser.a.i(this, this.but);
            }
        } else if (!TextUtils.isEmpty(this.but)) {
            com.baidu.tbadk.browser.a.i(this, this.but);
        }
    }

    private void Wp() {
        if (!com.baidu.adp.lib.util.j.fi()) {
            if (!TextUtils.isEmpty(this.but)) {
                com.baidu.tbadk.browser.a.i(this, this.but);
                return;
            }
            return;
        }
        if (this.bus == null) {
            this.bus = new com.baidu.tbadk.core.dialog.a(this);
            this.bus.aX(com.baidu.tieba.y.download_iqiyi_app_dialog);
            this.bus.a(com.baidu.tieba.y.install_app, new ap(this));
            this.bus.b(com.baidu.tieba.y.webpage_play, new aq(this));
            this.bus.P(false);
        }
        this.bus.kT().kW();
    }

    private DialogInterface Wq() {
        if (this.buz == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.y.download_baidu_video_dialog));
            builder.setPositiveButton(getString(com.baidu.tieba.y.install), new ar(this));
            builder.setNegativeButton(getString(com.baidu.tieba.y.cancel), new as(this));
            builder.setCancelable(true);
            this.buz = builder.create();
            this.buz.setCanceledOnTouchOutside(false);
        }
        com.baidu.adp.lib.g.j.a(this.buz, this);
        return this.buz;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void u(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (gU(str) || z) {
                boolean h = com.baidu.adp.lib.util.m.h(context, "com.qiyi.video");
                gV(str);
                if (h) {
                    Wo();
                    return;
                } else {
                    Wp();
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
            Wq();
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
            this.bvd = true;
        }
        if (aVar != null) {
            int size = aVar.vy().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.vy().get(i6) != null && aVar.vy().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.vy().get(i6).vD().getWidth();
                    int height = aVar.vy().get(i6).vD().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.vy().get(i6).vD().vK()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        arrayList.add(b(aVar.vy().get(i6)));
                        if (!this.bvd) {
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
            if (akVar.getId() != null && akVar.getId().equals(this.buG.kD())) {
                z = true;
            }
            MarkData d = this.buG.d(akVar);
            if (d != null && gJ(11009)) {
                this.buL.XA();
                this.buH.b(d);
                if (!z) {
                    this.buH.TI();
                } else {
                    this.buH.TJ();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a K(String str, int i) {
        if (this.buG == null || this.buG.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.data.ah pbData = this.buG.getPbData();
        com.baidu.tbadk.widget.richText.a a = a(pbData.zL(), str, i);
        if (a == null) {
            ArrayList<com.baidu.tieba.data.ak> zL = pbData.zL();
            int size = zL.size();
            for (int i2 = 0; i2 < size; i2++) {
                a = a(zL.get(i2).Ad(), str, i);
                if (a != null) {
                    return a;
                }
            }
            return a;
        }
        return a;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.data.ak> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> vy;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a Af = arrayList.get(i2).Af();
            if (Af != null && (vy = Af.vy()) != null) {
                int size = vy.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (vy.get(i4) != null && vy.get(i4).getType() == 8) {
                        i3++;
                        if (vy.get(i4).vD().vL().equals(str)) {
                            int width = vy.get(i4).vD().getWidth();
                            int height = vy.get(i4).vD().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.bvc = i4;
                            return Af;
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
        com.baidu.tbadk.widget.richText.g vD = cVar.vD();
        if (vD != null) {
            if (!StringUtils.isNull(vD.vJ())) {
                return vD.vJ();
            }
            if (vD.getHeight() * vD.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (vD.getHeight() * vD.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (vD.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * vD.getHeight())));
            } else {
                float width = vD.getWidth() / vD.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.ay.aC(vD.getSrc()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void b(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.buq = str;
            if (this.bux == null) {
                Wf();
            }
            com.baidu.tbadk.core.i.l(this, "pb_show_phonedialog");
            if (str2.equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT)) {
                this.bux.bg(1).setVisibility(8);
            } else {
                this.bux.bg(1).setVisibility(0);
            }
            this.bux.la();
        }
    }

    @Override // com.baidu.tbadk.core.voice.o
    public VoiceManager getVoiceManager() {
        return this.ayo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wr() {
        hideNetRefreshView(this.buL.getView());
        showLoadingView(this.buL.getView(), true);
        if (this.buG.tL()) {
            this.buL.XA();
        }
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m b(VoiceData.VoiceModel voiceModel) {
        View Yf;
        View findViewWithTag;
        if (!this.buL.XJ() || (Yf = this.buL.Yf()) == null || (findViewWithTag = Yf.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (com.baidu.tbadk.core.voice.m) findViewWithTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EA() {
        if (this.ayo != null) {
            this.ayo.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hv() {
        if (this.buG.Tr()) {
            TiebaStatic.eventStat(this, "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.data.ah pbData = this.buG.getPbData();
            String name = pbData.zJ().getName();
            String title = pbData.zK().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.buG.WF() + "?share=9105&fr=share";
            String[] N = pbData.N(this);
            String str2 = N[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String format = MessageFormat.format(getResources().getString(com.baidu.tieba.y.share_content_tpl), title, name, N[1]);
            com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
            hVar.title = title;
            hVar.content = format;
            hVar.MW = str;
            if (parse != null) {
                hVar.MX = parse;
            }
            this.aIb = new com.baidu.tbadk.coreExtra.share.d(this);
            this.aIb.a(hVar, true);
            this.aIb.a(getShareMtjStatInfo());
            this.aIb.ai(true);
            TextView t = this.aIb.t(com.baidu.tieba.y.share_tieba_qunzu, com.baidu.tieba.u.icon_unite_share_qunzu);
            this.aIb.a(t);
            TextView t2 = this.aIb.t(com.baidu.tieba.y.forum_friend, com.baidu.tieba.u.icon_unite_share_baf);
            this.aIb.a(t2);
            t2.setOnClickListener(new au(this));
            t.setOnClickListener(new av(this));
            this.aIb.b(new aw(this, hVar));
            this.aIb.show();
        }
    }

    private SparseArray<String> getShareMtjStatInfo() {
        if (this.buy == null) {
            this.buy = new SparseArray<>(7);
            this.buy.put(2, "pb_wx_timeline");
            this.buy.put(3, "pb_wx_friend");
            this.buy.put(4, "pb_qq_zone");
            this.buy.put(5, "pb_tencent_weibo");
            this.buy.put(6, "pb_sina_weibo");
            this.buy.put(7, "pb_renren");
        }
        return this.buy;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<LinearLayout> vS() {
        if (this.abP == null) {
            this.abP = new com.baidu.adp.lib.e.b<>(new ax(this), 15, 0);
        }
        return this.abP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ws() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.data.ah pbData = this.buG.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.jZ().isIfAddition();
            AdditionData zR = pbData.zR();
            boolean z3 = zR == null ? false : isIfAddition;
            if (z3) {
                z = zR.getAlreadyCount() != zR.getTotalCount();
                if (!TextUtils.isEmpty(zR.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.main.b.a aVar = this.buL.bxj;
            if (!z3 || !z) {
                z2 = false;
            }
            aVar.el(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.buL.Xm() == view) {
            com.baidu.tbadk.core.data.q zK = this.buG.getPbData().zK();
            View childAt = ((ViewGroup) view).getChildAt(0);
            if (childAt != null) {
                boolean z = zK.getPraise() == null || zK.getPraise().getIsLike() == 0;
                if (motionEvent.getAction() == 0) {
                    if (System.currentTimeMillis() - this.ayT > 1000) {
                        this.ayU = true;
                        z(childAt);
                    } else {
                        this.ayU = false;
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (z) {
                        d(childAt, this.ayU);
                    } else {
                        c(childAt, this.ayU);
                    }
                } else if (motionEvent.getAction() == 2) {
                    c(childAt, this.ayU);
                } else if (motionEvent.getAction() == 3) {
                    c(childAt, this.ayU);
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

    public void FG() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.m.b(this, getCurrentFocus());
        }
    }
}
