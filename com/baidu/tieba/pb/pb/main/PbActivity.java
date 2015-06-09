package com.baidu.tieba.pb.pb.main;

import android.content.ActivityNotFoundException;
import android.content.Context;
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
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, com.baidu.tbadk.core.dialog.d, com.baidu.tbadk.core.view.at, com.baidu.tbadk.core.voice.j, com.baidu.tbadk.widget.richText.j, com.baidu.tieba.tbadkCore.ap {
    private static String bKo = "tbgametype";
    private com.baidu.tieba.tbadkCore.location.e aJN;
    private String aJS;
    private com.baidu.adp.lib.e.b<TbImageView> aaj;
    private boolean alI;
    private com.baidu.adp.lib.e.b<ImageView> auq;
    private com.baidu.adp.lib.e.b<TextView> aur;
    private com.baidu.adp.lib.e.b<View> aus;
    private com.baidu.adp.lib.e.b<LinearLayout> aut;
    private com.baidu.adp.lib.e.b<GifView> auu;
    private com.baidu.tbadk.core.dialog.a bKq;
    private VoiceData.VoiceModel bKr;
    private boolean mIsFromCDN;
    private String mPhoneNumber;
    private String mPostContent;
    private VoiceManager mVoiceManager;
    private boolean bKi = false;
    private boolean aKX = true;
    private boolean bIV = false;
    private com.baidu.tbadk.core.dialog.a bKj = null;
    private String bKk = null;
    private String mDownloadUrl = null;
    private String bKl = null;
    private String bKm = null;
    private String mPackageName = null;
    private int bKn = 0;
    private com.baidu.tbadk.core.dialog.e bKp = null;
    SparseArray<String> aSM = null;
    private long aEQ = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private WriteData bKs = new WriteData();
    private long aqD = 0;
    private long createTime = 0;
    private long aqE = 0;
    private boolean bKt = false;
    private com.baidu.tbadk.performanceLog.h bKu = null;
    private String bKv = null;
    private final Handler mHandler = new Handler(new b(this));
    private bo bKw = null;
    private com.baidu.tbadk.baseEditMark.a bKx = null;
    private com.baidu.tieba.tbadkCore.writeModel.a aJU = null;
    private com.baidu.tieba.pb.c.a bKy = null;
    private com.baidu.tieba.tbadkCore.h.a bKz = null;
    private ch bKA = null;
    public final com.baidu.tieba.pb.pb.main.a.a bKB = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean bKC = false;
    private boolean bKD = false;
    private MorePopupWindow bKE = null;
    private cf bKF = null;
    private boolean aKZ = false;
    private CustomMessageListener aRW = new m(this, 2001276);
    private CustomMessageListener bKG = new x(this, 2004007);
    private com.baidu.tieba.tbadkCore.location.j aJY = new ai(this);
    private com.baidu.tieba.tbadkCore.location.k aJZ = new at(this);
    private boolean aJO = false;
    private com.baidu.tieba.tbadkCore.ar aKc = new com.baidu.tieba.tbadkCore.ar(getPageContext(), new ay(this));
    private long praiseStopTime = 0;
    private boolean isPraiseToServer = true;
    private com.baidu.tieba.pb.b.d bKH = new com.baidu.tieba.pb.b.d(new az(this));
    public com.baidu.tbadk.core.dialog.d bHa = new ba(this);
    public final View.OnClickListener aNV = new bb(this);
    private final bs bKI = new c(this);
    private final com.baidu.tbadk.baseEditMark.b bKJ = new d(this);
    private final AbsListView.OnScrollListener HA = new e(this);
    private final com.baidu.tieba.tbadkCore.writeModel.e bKK = new f(this);
    private final com.baidu.adp.base.i bKL = new g(this);
    private final bd bKM = new h(this);
    private final com.baidu.tbadk.core.view.aj aAr = new i(this);
    private final com.baidu.adp.widget.ListView.x bKN = new j(this);
    private final com.baidu.adp.widget.ListView.aa bKO = new k(this);
    private final com.baidu.tbadk.core.dialog.h bjY = new l(this);
    private final com.baidu.adp.base.i bKP = new n(this);
    private int bKQ = 0;
    private final com.baidu.tbadk.widget.richText.s auJ = new o(this);
    boolean bKR = false;
    com.baidu.tieba.tbadkCore.data.j bKS = null;
    private final com.baidu.tbadk.core.dialog.h bKT = new p(this);
    private final View.OnLongClickListener afC = new q(this);
    private final com.baidu.tbadk.core.view.ad aLP = new r(this);

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        if (cVar.aaB() != null) {
            String id = cVar.aaB().getId();
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aau = this.bKw.getPbData().aau();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aau.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = aau.get(i2);
                if (jVar.getId() == null || !jVar.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.data.j> aaD = cVar.aaD();
                    jVar.iP(cVar.getTotalCount());
                    if (jVar.aoz() != null) {
                        jVar.aoz().clear();
                        jVar.aoz().addAll(aaD);
                    }
                }
            }
            this.bKA.e(this.bKw.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void JQ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.t.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            JR();
        } else if (this.aJN.apn()) {
            JP();
        } else {
            this.aJN.fi(false);
            if (this.bKA.Kj() != null) {
                this.bKA.Kj().setLocationViewVisibility(0);
                this.bKA.Kj().setLocationInfoViewState(1);
            }
            this.aJN.apl();
        }
    }

    private void JR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bu(com.baidu.tieba.t.location_app_permission_prompt).a(com.baidu.tieba.t.isopen, new s(this)).b(com.baidu.tieba.t.cancel, new t(this)).b(getPageContext());
        aVar.rL();
    }

    public void JS() {
        if (this.bKA.Kj() != null) {
            if (this.aJN.app()) {
                this.bKA.Kj().setLocationViewVisibility(0);
                if (this.aJN.apn()) {
                    this.aJY.a(com.baidu.tieba.tbadkCore.location.d.api().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.n.isNetOk()) {
                    this.bKA.Kj().setLocationInfoViewState(1);
                    this.aJN.apl();
                    return;
                } else {
                    this.bKA.Kj().setLocationInfoViewState(0);
                    return;
                }
            }
            this.bKA.Kj().setLocationViewVisibility(8);
        }
    }

    private void aaJ() {
        this.bKA.acl();
    }

    private void aaK() {
        this.bKA.acm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaL() {
        com.baidu.tieba.pb.a.b pbData;
        com.baidu.tbadk.core.data.w aat;
        if (!this.aJO) {
            if (!com.baidu.adp.lib.util.n.isNetOk()) {
                showToast(com.baidu.tieba.t.no_network_guide);
            } else if (this.isPraiseToServer) {
                this.aJO = true;
                if (this.bKw != null && (pbData = this.bKw.getPbData()) != null && (aat = pbData.aat()) != null) {
                    int isLike = aat.getPraise() == null ? 0 : aat.getPraise().getIsLike();
                    if (this.aKc != null) {
                        this.aKc.a(aat.rs(), aat.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eS(int i) {
        com.baidu.tbadk.core.data.w aat;
        String sb;
        String q;
        if (this.bKw != null && this.bKw.getPbData() != null && (aat = this.bKw.getPbData().aat()) != null) {
            if (i == 1) {
                PraiseData praise = aat.getPraise();
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
                        aat.setPraise(praiseData);
                    } else {
                        aat.getPraise().getUser().add(0, metaData);
                        aat.getPraise().setNum(aat.getPraise().getNum() + 1);
                        aat.getPraise().setIsLike(i);
                    }
                }
                if (aat.getPraise() != null) {
                    if (aat.getPraise().getNum() < 1) {
                        q = getResources().getString(com.baidu.tieba.t.frs_item_praise_text);
                    } else {
                        q = com.baidu.tbadk.core.util.bb.q(aat.getPraise().getNum());
                    }
                    this.bKA.z(q, true);
                }
            } else if (aat.getPraise() != null) {
                aat.getPraise().setIsLike(i);
                aat.getPraise().setNum(aat.getPraise().getNum() - 1);
                ArrayList<MetaData> user = aat.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aat.getPraise().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aat.getPraise().getNum() < 1) {
                    sb = getResources().getString(com.baidu.tieba.t.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(aat.getPraise().getNum())).toString();
                }
                this.bKA.z(sb, false);
            }
            if (this.bKw.abq()) {
                this.bKA.acb().notifyDataSetChanged();
            } else {
                this.bKA.f(this.bKw.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bKw.saveToBundle(bundle);
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aJS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.aEQ = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aEQ = System.currentTimeMillis();
        }
        this.bKn = 0;
        initUI();
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initData(bundle);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.aEQ;
        registerListener(this.aRW);
        registerListener(this.bKG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.bKA != null && this.bKA.Kj() != null) {
            this.bKA.Kj().anz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStart(getPageContext());
        }
    }

    public bo aaM() {
        return this.bKw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.bKi = true;
        super.onPause();
        BdListView listView = getListView();
        this.bKn = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.bKn == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
        if (this.bKA != null) {
            this.bKA.onPause();
        }
        if (!this.bKw.abt()) {
            WriteData JT = this.aJU.JT();
            if (JT == null) {
                JT = new WriteData(1);
                JT.setThreadId(this.bKw.abp());
                JT.setWriteImagesInfo(this.writeImagesInfo);
            }
            JT.setContent(this.bKA.Kq());
            if (this.bKs != null && this.bKs.getIsBaobao()) {
                JT.setBaobaoContent(this.bKs.getBaobaoContent());
                JT.setBaobaoImagesInfo(this.baobaoImagesInfo);
                JT.setIsBaobao(true);
            }
            com.baidu.tieba.tbadkCore.ao.b(this.bKw.abp(), JT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        this.bKi = false;
        super.onResume();
        if (this.bKn == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView abT = this.bKA.abT();
        if (abT != null && abT.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            abT.at(false);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
        if (this.bKA.Kj() != null) {
            this.bKA.Kj().refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.bKA.ec(z);
        if (this.bKF != null) {
            this.bKF.eb(z);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ap
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!com.baidu.tbadk.core.util.bb.isEmpty(writeData.getContent()) && com.baidu.tbadk.core.util.bb.isEmpty(this.bKA.Kq())) {
                this.mPostContent = writeData.getContent();
                this.bKA.gj(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                this.bKA.a(this.writeImagesInfo, true);
            }
            if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.bKs.setIsBaobao(writeData.getIsBaobao());
                this.bKs.setBaobaoContent(writeData.getBaobaoContent());
                this.bKs.setBaobaoImagesInfo(this.baobaoImagesInfo);
                this.bKA.setBaobaoUris(this.baobaoImagesInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bKA.Kj() != null && this.bKA.Kj().getVisibility() != 0) {
            aaO();
            this.bKA.abW();
        }
        this.bKA.bNj.XR();
        if (this.bKw != null && this.bKw.getPbData() != null && this.bKw.getPbData().aas() != null && this.bKw.getPbData().aat() != null) {
            com.baidu.tbadk.distribute.a.yY().a(getPageContext().getPageActivity(), "pb", this.bKw.getPbData().aas().getId(), com.baidu.adp.lib.g.c.c(this.bKw.getPbData().aat().getId(), 0L));
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (!this.bKt) {
            this.bKt = true;
            this.bKA.acA();
        }
        this.bKw.cancelLoadData();
        this.bKw.destory();
        this.aJU.cancelLoadData();
        this.bKy.cancelLoadData();
        this.aJN.cancelLoadData();
        this.bKz.cancelLoadData();
        this.bKA.onDestroy();
        if (this.bKu != null) {
            this.bKu.onDestroy();
        }
        super.onDestroy();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
    }

    public void aaN() {
        if (this.bKA.Kj() != null) {
            this.bKA.Kj().setContent(this.mPostContent == null ? "" : this.mPostContent);
            if (this.bKr != null) {
                this.bKA.Kj().anJ();
            }
            this.bKA.a(this.writeImagesInfo, true);
            this.bKA.setBaobaoUris(this.baobaoImagesInfo);
            if (!StringUtils.isNull(this.mPostContent)) {
                this.bKA.Kj().CR();
                this.bKA.Kj().anP();
                this.bKA.ef(false);
            } else if (this.writeImagesInfo != null && this.writeImagesInfo.size() >= 1) {
                this.bKA.Kj().cqP.hideAll();
                this.bKA.Kj().setVisibility(0);
                this.bKA.Kj().anP();
                this.bKA.Kj().iN(23);
            } else if (this.bKr != null) {
                this.bKA.Kj().cqP.hideAll();
                this.bKA.Kj().setVisibility(0);
                this.bKA.Kj().anP();
                this.bKA.Kj().iN(5);
            } else if (this.baobaoImagesInfo != null && this.baobaoImagesInfo.size() >= 1) {
                this.bKA.Kj().cqP.hideAll();
                this.bKA.Kj().setVisibility(0);
                this.bKA.Kj().anP();
                this.bKA.Kj().iN(50);
            } else {
                this.bKA.Kj().CR();
                this.bKA.ef(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaO() {
        if (this.bKA.Kj() != null) {
            this.mPostContent = this.bKA.Kj().getContent();
            this.bKr = this.bKA.getAudioData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bKA.onChangeSkinType(i);
        if (this.bKE != null) {
            this.bKE.onChangeSkinType(this, i, com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.bg_collect));
        }
        if (this.bKA.abT() != null) {
            this.bKA.abT().onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaP() {
        this.bKF = new cf(getPageContext(), this.aNV);
        this.bKF.eb(this.mIsLogin);
        this.bKE = new MorePopupWindow(getPageContext().getPageActivity(), this.bKF.getView(), getResources().getDrawable(com.baidu.tieba.p.bg_collect), null);
        this.bKE.setTouchInterceptor(new u(this));
        this.bKE.onChangeSkinType(this, TbadkCoreApplication.m411getInst().getSkinType(), com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.bg_collect));
    }

    private void initUI() {
        this.bKA = new ch(this, this.aNV, this.bKH);
        this.bKA.setOnActionListener(new v(this));
        this.bKA.setOnScrollListener(this.HA);
        this.bKA.c(this.bKN);
        this.bKA.a(this.bKO);
        this.bKA.b(this.bjY);
        this.bKA.a(this.aAr);
        this.bKA.setIsShowImage(com.baidu.tbadk.core.n.qc().qg());
        this.bKA.dT(com.baidu.tbadk.core.n.qc().qe());
        this.bKA.setOnImageClickListener(this.auJ);
        this.bKA.a(this.afC);
        this.bKA.f(this.aLP);
        this.bKA.a(this.bKM);
        this.bKA.ec(this.mIsLogin);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.bKA != null) {
            if (z && !this.bIV) {
                if (this.aKX) {
                    this.aKX = false;
                    showLoadingView(this.bKA.getView(), true);
                    return;
                }
                return;
            }
            hideLoadingView(this.bKA.getView());
        }
    }

    private void aaQ() {
        if (this.bKp == null) {
            this.bKp = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
            this.bKp.a(new String[]{getPageContext().getString(com.baidu.tieba.t.call_phone), getPageContext().getString(com.baidu.tieba.t.sms_phone), getPageContext().getString(com.baidu.tieba.t.search_in_baidu)}, new w(this)).by(com.baidu.tbadk.core.dialog.g.Sa).bz(17).d(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        this.bKw = new bo(this);
        this.bKw.a(this.bKI);
        this.bKx = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.bKx != null) {
            this.bKx.a(this.bKJ);
        }
        this.aJU = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aJU.a(this.bKK);
        this.bKy = new com.baidu.tieba.pb.c.a(this);
        this.bKy.setLoadDataCallBack(this.bKP);
        this.bKz = new com.baidu.tieba.tbadkCore.h.a(this);
        this.bKz.setLoadDataCallBack(this.bKL);
        this.aJN = new com.baidu.tieba.tbadkCore.location.e(this);
        this.aJN.a(this.aJY);
        this.aJN.a(this.aJZ);
        if (bundle != null) {
            this.bKw.initWithBundle(bundle);
        } else {
            this.bKw.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.c.REQUEST_CODE, -1) == 18003) {
            this.bKw.dY(true);
        }
        cb.abL().y(this.bKw.abn(), this.bKw.getIsFromMark());
        this.bKA.acg();
        this.bKw.BM();
        this.bKA.a(new y(this));
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aJS = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!this.bKw.abt()) {
            com.baidu.tieba.tbadkCore.ao.a(this.bKw.abp(), this);
        }
        this.aKc.setUniqueId(getUniqueId());
        this.aKc.registerListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dQ(boolean z) {
        if (this.bKw == null || this.bKw.getPbData() == null) {
            return false;
        }
        return ((this.bKw.getPbData().aaw() != 0) || this.bKw.getPbData().aat() == null || this.bKw.getPbData().aat().getAuthor() == null || TextUtils.equals(this.bKw.getPbData().aat().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void aaR() {
        if (this.bKw != null && this.bKw.getPbData() != null && this.bKw.getPbData().aat() != null && this.bKw.getPbData().aat().getAuthor() != null) {
            this.bKA.bNj.c(this.bKw.abq(), this.bKx != null ? this.bKx.pq() : false, dQ(TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.bKw.getPbData().aat().getAuthor().getUserId())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.tbadkCore.data.j jVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (jVar = (com.baidu.tieba.tbadkCore.data.j) sparseArray.get(com.baidu.tieba.q.tag_clip_board)) != null) {
            b(jVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        abc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Boolean bool) {
        com.baidu.tieba.pb.a.b pbData;
        String str = null;
        if (this.bKw != null && (pbData = this.bKw.getPbData()) != null && pbData.aas() != null) {
            str = pbData.aas().getName();
        }
        if (com.baidu.tieba.tbadkCore.ad.a(str, bool)) {
            aaK();
        } else {
            aaJ();
        }
    }

    public void a(boolean z, MarkData markData) {
        this.bKA.acj();
        this.bKw.dX(z);
        if (this.bKx != null) {
            this.bKx.Z(z);
            if (markData != null) {
                this.bKx.a(markData);
            }
        }
        if (this.bKw.pq()) {
            aaX();
        } else {
            this.bKA.e(this.bKw.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void im(String str) {
        if (!StringUtils.isNull(str) && this.bKw != null) {
            String abp = this.bKw.abp();
            String id = this.bKw.getPbData().aas().getId();
            sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(com.baidu.tieba.t.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + abp + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            if (!this.bKw.abt()) {
                antiData.setBlock_forum_name(this.bKw.getPbData().aas().getName());
                antiData.setBlock_forum_id(this.bKw.getPbData().aas().getId());
                antiData.setUser_name(this.bKw.getPbData().getUserData().getUserName());
                antiData.setUser_id(this.bKw.getPbData().getUserData().getUserId());
            }
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.tieba.tbadkCore.writeModel.h.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            if (!this.bKw.abt()) {
                antiData.setBlock_forum_name(this.bKw.getPbData().aas().getName());
                antiData.setBlock_forum_id(this.bKw.getPbData().aas().getId());
                antiData.setUser_name(this.bKw.getPbData().getUserData().getUserName());
                antiData.setUser_id(this.bKw.getPbData().getUserData().getUserId());
            }
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        this.bKA.showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.h.c cVar) {
        int i = 0;
        if (cVar != null) {
            this.bKA.a(0, cVar.AA, cVar.ctU, true);
            if (cVar.AA) {
                if (cVar.ctS == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.j> aau = this.bKw.getPbData().aau();
                    int size = aau.size();
                    while (true) {
                        if (i < size) {
                            if (!cVar.mPostId.equals(aau.get(i).getId())) {
                                i++;
                            } else {
                                aau.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.bKA.e(this.bKw.getPbData());
                } else if (cVar.ctS == 0) {
                    aaS();
                } else if (cVar.ctS == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.j> aau2 = this.bKw.getPbData().aau();
                    int size2 = aau2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < aau2.get(i2).aoz().size()) {
                                if (!cVar.mPostId.equals(aau2.get(i2).aoz().get(i3).getId())) {
                                    i3++;
                                } else {
                                    aau2.get(i2).aoz().remove(i3);
                                    aau2.get(i2).aoA();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData aay = this.bKw.getPbData().aay();
                        com.baidu.tieba.tbadkCore.data.j jVar = aau2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.data.j> aoB = jVar.aoB();
                        int size3 = aoB.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!cVar.mPostId.equals(aau2.get(i2).aoB().get(i4).getId())) {
                                    i4++;
                                } else {
                                    aoB.remove(i4);
                                    aay.decreaseAlreadyCount();
                                    if (jVar.aoI() > aoB.size()) {
                                        jVar.iR(aoB.size());
                                    }
                                    if (aoB.size() > 0) {
                                        com.baidu.tieba.tbadkCore.data.j jVar2 = aoB.get(aoB.size() - 1);
                                        aay.setLastAdditionTime(jVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a aoD = jVar2.aoD();
                                        String str = "";
                                        if (aoD != null) {
                                            str = aoD.toString();
                                        }
                                        aay.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a aoD2 = jVar.aoD();
                                        String str2 = "";
                                        if (aoD2 != null) {
                                            str2 = aoD2.toString();
                                        }
                                        aay.setLastAdditionContent(str2);
                                    }
                                    abd();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.bKA.e(this.bKw.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.h.e eVar) {
        this.bKA.a(1, eVar.AA, eVar.ctU, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.h.g gVar) {
        this.bKA.a(this.bKz.getLoadDataMode(), gVar.AA, gVar.ctU, false);
        this.bKA.K(gVar.ctW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.tbadkCore.h.g gVar) {
        if (gVar != null) {
            this.bKA.a(this.bKz.getLoadDataMode(), gVar.AA, gVar.ctU, true);
            if (gVar.AA) {
                this.bKD = true;
                if (i == 2) {
                    this.bKw.getPbData().aat().br(1);
                    this.bKw.setIsGood(1);
                } else if (i == 3) {
                    this.bKw.getPbData().aat().br(0);
                    this.bKw.setIsGood(0);
                } else if (i == 4) {
                    this.bKw.getPbData().aat().bq(1);
                    this.bKw.hz(1);
                } else if (i == 5) {
                    this.bKw.getPbData().aat().bq(0);
                    this.bKw.hz(0);
                }
                this.bKA.a(this.bKw.getPbData(), this.bKw.abq(), true);
            }
        }
    }

    private void aaS() {
        if (this.bKw.abr()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.bKw.abp());
            setResult(-1, intent);
        }
        if (aaY()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaT() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        this.bKA.acx();
        if (this.bKw != null && this.bKw.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.bKw.getPbData().aat().getId();
            historyMessage.forumName = this.bKw.getPbData().aas().getName();
            historyMessage.threadName = this.bKw.getPbData().aat().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aau = this.bKw.getPbData().aau();
            int aco = this.bKA.aco();
            if (aau != null && aco >= 0 && aco < aau.size()) {
                historyMessage.postID = aau.get(aco).getId();
            }
            historyMessage.isHostOnly = this.bKw.getHostMode();
            historyMessage.isSquence = this.bKw.abq();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.bKw != null && this.bKw.abr()) {
            Intent intent = new Intent();
            if (this.bKD) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.bKw.abp());
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.bKw.abs());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.bKw.getIsGood());
            }
            setResult(-1, intent);
        }
        if (aaY()) {
            if (this.bKw != null && this.bKA != null && this.bKA.getListView() != null) {
                com.baidu.tieba.pb.a.b pbData = this.bKw.getPbData();
                if (pbData != null && pbData.getUserData() != null) {
                    pbData.getUserData().setBimg_url(TbadkCoreApplication.m411getInst().getDefaultBubble());
                }
                cb.abL().a(this.bKw.getPbData(), this.bKA.getListView().onSaveInstanceState(), this.bKw.abq(), this.bKw.getHostMode());
            } else {
                cb.abL().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.bKE != null) {
                    com.baidu.adp.lib.g.k.a(this.bKE, getPageContext().getPageActivity());
                }
                if (this.bKA.eh(this.bKw.abt())) {
                    stopVoice();
                    return true;
                }
                finish();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hx(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.t.login_to_use), true, i)));
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
                    gg(null);
                    return;
                case 11009:
                    aaW();
                    return;
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(getPageContext().getPageActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(getPageContext().getPageActivity(), 12005, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            I(intent);
                            return;
                        } else {
                            R(intent);
                            return;
                        }
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        aaV();
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            this.bKA.acn();
                            this.aJU.fj(false);
                            return;
                        }
                        this.bKy.il(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    aaV();
                    ArrayList<String> U = com.baidu.tieba.tbadkCore.util.i.U(intent);
                    if (U != null) {
                        this.bKA.u(U);
                        return;
                    }
                    return;
                case 12006:
                    WriteData JT = this.aJU.JT();
                    if (JT != null) {
                        JT.deleteUploadedTempImages();
                    }
                    this.bKs.setIsBaobao(false);
                    this.bKs.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.aJU.c((WriteData) null);
                    this.aJU.fj(false);
                    this.bKA.bT(true);
                    if (this.bKw != null && this.bKw.abw()) {
                        this.bKA.acg();
                    }
                    if (this.bKw != null && this.bKw.abp() != null && !this.bKw.abt()) {
                        com.baidu.tieba.tbadkCore.ao.b(this.bKw.abp(), (WriteData) null);
                    }
                    this.bKA.a(this.writeImagesInfo, true);
                    return;
                case 12009:
                case 12010:
                    aaV();
                    if (i == 12010) {
                        K(intent);
                        return;
                    }
                    return;
                case 12012:
                    J(intent);
                    return;
                case 12013:
                    S(intent);
                    return;
                case 13008:
                    cb.abL().reset();
                    this.mHandler.postDelayed(new z(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.bKw != null) {
                        a(aaU(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getIntExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0));
                        return;
                    }
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                    return;
                case 23007:
                    Q(intent);
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                JU();
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
                aaV();
                return;
        }
    }

    private ShareFromPBMsgData aaU() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] aC = this.bKw.getPbData().aC(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.data.j abV = this.bKA.abV();
        String str = "";
        if (abV != null) {
            str = abV.getId();
            String aK = abV.aK(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.m.isEmpty(aK)) {
                aC[1] = aK;
            }
        }
        String rs = this.bKw.getPbData().aat().rs();
        if (rs != null && rs.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(aC[1]);
        shareFromPBMsgData.setImageUrl(aC[0]);
        shareFromPBMsgData.setForumName(this.bKw.getPbData().aas().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.bKw.getPbData().aat().getId());
        shareFromPBMsgData.setTitle(this.bKw.getPbData().aat().getTitle());
        return shareFromPBMsgData;
    }

    private void Q(Intent intent) {
        a(aaU(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.bKw != null && this.bKw.getPbData() != null && this.bKw.getPbData().aat() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            dc dcVar = new dc(getPageContext().getPageActivity());
            dcVar.setData(shareFromPBMsgData);
            aVar.bw(1);
            aVar.l(dcVar);
            aVar.a(com.baidu.tieba.t.share, new aa(this, dcVar, j, str, str2, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.t.alert_no_button, new ab(this, dcVar));
            aVar.ah(false);
            aVar.b(getPageContext()).rL();
            if (!com.baidu.adp.lib.util.m.isEmpty(shareFromPBMsgData.getImageUrl())) {
                dcVar.v(shareFromPBMsgData.getImageUrl(), this.bKw.getPbData().aax() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, int i2) {
        if (this.bKw != null && this.bKw.getPbData() != null && this.bKw.getPbData().aat() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            dc dcVar = new dc(getPageContext().getPageActivity());
            dcVar.setData(shareFromPBMsgData);
            aVar.bw(1);
            aVar.l(dcVar);
            aVar.a(com.baidu.tieba.t.share, new ac(this, dcVar, i, str, i2, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.t.alert_no_button, new ad(this, dcVar));
            aVar.ah(false);
            aVar.b(getPageContext()).rL();
            if (!com.baidu.adp.lib.util.m.isEmpty(shareFromPBMsgData.getImageUrl())) {
                dcVar.v(shareFromPBMsgData.getImageUrl(), this.bKw.getPbData().aax() == 1);
            }
        }
    }

    private void R(Intent intent) {
        a(intent, true);
    }

    private void I(Intent intent) {
        int size;
        int size2;
        K(intent);
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() - 1 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size2 = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    private void K(Intent intent) {
        this.aJS = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aJS;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cu = com.baidu.tbadk.core.util.c.cu(str);
                if (cu != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.M(getPageContext().getPageActivity())), com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.N(getPageContext().getPageActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.c.h(b, cu);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.o.a(TbConfig.LOCAL_CAMERA_DIR, this.aJS, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            this.bKA.a(this.writeImagesInfo, true);
        }
        if (this.bKA.Kj() != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            this.bKA.Kj().iN(23);
        }
    }

    private void J(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    this.bKA.a(this.writeImagesInfo, z);
                }
            }
            if (this.bKA.Kj() != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                this.bKA.Kj().iN(23);
            }
        }
    }

    private void S(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            if (stringExtra != null && stringExtra2 != null) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(stringExtra);
                this.baobaoImagesInfo.clear();
                this.baobaoImagesInfo.addChooseFile(imageFileInfo);
                this.bKA.setBaobaoUris(this.baobaoImagesInfo);
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    if (this.bKA.Kj() != null) {
                        this.bKA.Kj().iN(50);
                    }
                    this.bKs.setIsBaobao(true);
                    this.bKs.setBaobaoContent(stringExtra2);
                    this.bKs.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.bKs.setIsBaobao(false);
                this.bKs.setBaobaoContent("");
                this.bKs.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void JU() {
        new ae(this).execute(new Void[0]);
    }

    private void aaV() {
        if (this.bKC) {
            this.bKC = false;
            new Handler().postDelayed(new af(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaW() {
        MarkData hF;
        if (this.bKx != null && (hF = this.bKw.hF(this.bKA.aco())) != null) {
            this.bKA.acg();
            this.bKx.a(hF);
            if (!this.bKx.pq()) {
                this.bKx.ps();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.bKx.pr();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gg(String str) {
        VoiceData.VoiceModel voiceModel;
        if (this.aJU.JT() == null && !this.bKw.abt()) {
            this.aJU.c(this.bKw.iq(str));
        }
        if (this.aJU.JT() != null) {
            if (!this.bKw.abt()) {
                this.aJU.JT().setWriteImagesInfo(this.writeImagesInfo);
                this.aJU.fj(this.writeImagesInfo.size() > 0);
                if (this.bKs.getIsBaobao()) {
                    this.aJU.JT().setIsBaobao(true);
                    this.aJU.JT().setBaobaoContent(this.bKs.getBaobaoContent());
                    this.aJU.JT().setBaobaoImagesInfo(this.baobaoImagesInfo);
                } else {
                    this.aJU.JT().setIsBaobao(false);
                }
            }
            if (this.bKA.Kj() != null) {
                this.aJU.JT().setHasLocationData(this.bKA.Kj().getLocationInfoViewState() == 2);
            }
            if (str == null) {
                this.aJU.JT().setContent(this.bKA.Kq());
                voiceModel = this.bKA.getAudioData();
                this.bKA.Ks();
            } else {
                voiceModel = null;
            }
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.aJU.JT().setVoice(voiceModel.getId());
                    this.aJU.JT().setVoiceDuringTime(voiceModel.duration);
                } else {
                    this.aJU.JT().setVoice(null);
                    this.aJU.JT().setVoiceDuringTime(-1);
                }
            } else {
                this.aJU.JT().setVoice(null);
                this.aJU.JT().setVoiceDuringTime(-1);
            }
            if (!this.aJU.apK()) {
                showToast(com.baidu.tieba.t.write_img_limit);
            } else if (this.aJU.apI()) {
                this.bKA.Kp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaX() {
        com.baidu.tieba.pb.a.b pbData = this.bKw.getPbData();
        this.bKw.dX(true);
        pbData.ik(this.bKx.pp());
        this.bKA.e(pbData);
    }

    private boolean aaY() {
        if (this.bKw == null) {
            return true;
        }
        if (this.bKw.pq()) {
            MarkData abC = this.bKw.abC();
            if (abC == null || !this.bKw.getIsFromMark()) {
                return true;
            }
            MarkData hF = this.bKw.hF(this.bKA.aco());
            if (hF == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, abC);
                setResult(-1, intent);
                return true;
            } else if (hF.getPostId() == null || hF.getPostId().equals(abC.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, abC);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cn(String.format(getPageContext().getString(com.baidu.tieba.t.alert_update_mark), Integer.valueOf(hF.getFloor())));
                aVar.a(com.baidu.tieba.t.alert_yes_btn, new ag(this, hF, abC));
                aVar.b(com.baidu.tieba.t.alert_no_button, new ah(this, abC));
                aVar.a(new aj(this, abC));
                aVar.b(getPageContext());
                aVar.rL();
                return false;
            }
        } else if (this.bKw.getPbData() == null || this.bKw.getPbData().aau() == null || this.bKw.getPbData().aau().size() <= 0 || !this.bKw.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.at
    public BdListView getListView() {
        if (this.bKA == null) {
            return null;
        }
        return this.bKA.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int getRichTextViewId() {
        if (this.bKA == null) {
            return 0;
        }
        return this.bKA.acr();
    }

    @Override // com.baidu.tbadk.core.view.at
    public int uB() {
        if (this.bKA == null) {
            return 0;
        }
        return this.bKA.Lu();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<ImageView> getImageViewPool() {
        if (this.auq == null) {
            this.auq = new com.baidu.adp.lib.e.b<>(new ak(this), 8, 0);
        }
        return this.auq;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<TextView> getTextViewPool() {
        if (this.aur == null) {
            this.aur = TbRichTextView.h(getPageContext().getPageActivity(), 8);
        }
        return this.aur;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<GifView> getGifViewPool() {
        if (this.auu == null) {
            this.auu = new com.baidu.adp.lib.e.b<>(new al(this), 20, 0);
        }
        return this.auu;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<View> getVoiceViewPool() {
        if (this.aus == null) {
            this.aus = new com.baidu.adp.lib.e.b<>(new am(this), 8, 0);
        }
        return this.aus;
    }

    @Override // com.baidu.tbadk.core.view.at
    public com.baidu.adp.lib.e.b<TbImageView> uC() {
        if (this.aaj == null) {
            this.aaj = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.aaj;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    public boolean in(String str) {
        Map<String, String> de;
        if (!TextUtils.isEmpty(str) && (de = com.baidu.tbadk.core.util.bi.de(com.baidu.tbadk.core.util.bi.df(str))) != null) {
            String str2 = de.get(ImageViewerConfig.URL);
            if (!TextUtils.isEmpty(str2)) {
                return in(com.baidu.adp.lib.util.m.aW(str2));
            }
            String str3 = de.get(bKo);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onLinkClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (io(str) || z) {
                boolean u = com.baidu.adp.lib.util.n.u(context, "com.qiyi.video");
                ip(str);
                if (u) {
                    aaZ();
                } else {
                    aba();
                }
            } else if (in(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                com.baidu.tbadk.core.util.bi.tO().b(getPageContext(), new String[]{str});
            }
        }
    }

    private boolean io(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }

    private void ip(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(";")) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.bKl = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.bKm = split[i].substring(indexOf2 + 1, split[i].length());
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
                        this.bKk = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void aaZ() {
        if (TextUtils.isEmpty(this.bKl) || TextUtils.isEmpty(this.bKm) || TextUtils.isEmpty(this.mPackageName)) {
            if (!TextUtils.isEmpty(this.bKk)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.bKk);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(this.bKl));
        intent.setAction(this.bKm);
        intent.setPackage(this.mPackageName);
        if (intent.resolveActivity(getPageContext().getPageActivity().getPackageManager()) != null) {
            if (!com.baidu.adp.lib.g.j.e(getPageContext().getPageActivity(), intent) && !TextUtils.isEmpty(this.bKk)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.bKk);
            }
        } else if (!TextUtils.isEmpty(this.bKk)) {
            com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.bKk);
        }
    }

    private void aba() {
        if (!com.baidu.adp.lib.util.k.iY()) {
            if (!TextUtils.isEmpty(this.bKk)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.bKk);
                return;
            }
            return;
        }
        if (this.bKj == null) {
            this.bKj = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.bKj.bu(com.baidu.tieba.t.download_iqiyi_app_dialog);
            this.bKj.a(com.baidu.tieba.t.install_app, new an(this));
            this.bKj.b(com.baidu.tieba.t.webpage_play, new ao(this));
            this.bKj.ah(false);
        }
        this.bKj.b(getPageContext()).rL();
    }

    private com.baidu.tbadk.core.dialog.a abb() {
        if (this.bKq == null) {
            this.bKq = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.bKq.cm(getPageContext().getString(com.baidu.tieba.t.download_baidu_video_dialog));
            this.bKq.a(getPageContext().getString(com.baidu.tieba.t.install), new ap(this));
            this.bKq.b(getPageContext().getString(com.baidu.tieba.t.cancel), new aq(this));
            this.bKq.ag(true);
            this.bKq.b(getPageContext());
            this.bKq.ah(false);
        }
        this.bKq.rL();
        return this.bKq;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onVideoClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (io(str) || z) {
                boolean u = com.baidu.adp.lib.util.n.u(context, "com.qiyi.video");
                ip(str);
                if (u) {
                    aaZ();
                    return;
                } else {
                    aba();
                    return;
                }
            }
            com.baidu.tbadk.core.util.bi.tO().b(getPageContext(), new String[]{str});
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
            abb();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onSongClicked(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, HashMap<String, ImageUrlData> hashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.g Er;
        if (aVar == aVar2) {
            this.bKR = true;
        }
        if (aVar != null) {
            int size = aVar.Em().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.Em().get(i6) != null && aVar.Em().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.Em().get(i6).Er().getWidth();
                    int height = aVar.Em().get(i6).Er().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.Em().get(i6).Er().Ey()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.Em().get(i6);
                        String b = b(cVar);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && cVar != null && (Er = cVar.Er()) != null) {
                            String Ez = Er.Ez();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Ez;
                            int i8 = this.mIsFromCDN ? 17 : 18;
                            imageUrlData.urlType = i8;
                            imageUrlData.urlType = i8;
                            if (hashMap != null) {
                                hashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.bKR) {
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
    public void b(com.baidu.tieba.tbadkCore.data.j jVar) {
        if (jVar != null) {
            boolean z = false;
            if (jVar.getId() != null && jVar.getId().equals(this.bKw.ro())) {
                z = true;
            }
            MarkData c = this.bKw.c(jVar);
            if (c != null) {
                this.bKA.acg();
                if (this.bKx != null) {
                    this.bKx.a(c);
                    if (!z) {
                        this.bKx.ps();
                    } else {
                        this.bKx.pr();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a O(String str, int i) {
        if (this.bKw == null || this.bKw.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.a.b pbData = this.bKw.getPbData();
        com.baidu.tbadk.widget.richText.a a = a(pbData.aau(), str, i);
        if (a == null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aau = pbData.aau();
            int size = aau.size();
            for (int i2 = 0; i2 < size; i2++) {
                a = a(aau.get(i2).aoB(), str, i);
                if (a != null) {
                    return a;
                }
            }
            return a;
        }
        return a;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.data.j> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> Em;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a aoD = arrayList.get(i2).aoD();
            if (aoD != null && (Em = aoD.Em()) != null) {
                int size = Em.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Em.get(i4) != null && Em.get(i4).getType() == 8) {
                        i3++;
                        if (Em.get(i4).Er().Ez().equals(str)) {
                            int width = Em.get(i4).Er().getWidth();
                            int height = Em.get(i4).Er().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.bKQ = i4;
                            return aoD;
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
        com.baidu.tbadk.widget.richText.g Er = cVar.Er();
        if (Er != null) {
            if (!StringUtils.isNull(Er.Ex())) {
                return Er.Ex();
            }
            if (Er.getHeight() * Er.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Er.getHeight() * Er.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Er.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Er.getHeight())));
            } else {
                float width = Er.getWidth() / Er.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.bb.aV(Er.getSrc()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onPhoneClicked(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mPhoneNumber = str;
            if (this.bKp == null) {
                aaQ();
            }
            com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "pb_show_phonedialog");
            if (str2.equals("2")) {
                this.bKp.bB(1).setVisibility(8);
            } else {
                this.bKp.bB(1).setVisibility(0);
            }
            this.bKp.rN();
        }
    }

    @Override // com.baidu.tbadk.core.voice.j
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abc() {
        hideNetRefreshView(this.bKA.getView());
        showLoadingView(this.bKA.getView(), true);
        if (this.bKw.BM()) {
            this.bKA.acg();
        }
    }

    @Override // com.baidu.tbadk.core.voice.j
    public com.baidu.tbadk.core.voice.i getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVoice() {
        if (this.mVoiceManager != null) {
            this.mVoiceManager.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showShareDialog() {
        if (this.bKw.abB()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.a.b pbData = this.bKw.getPbData();
            String name = pbData.aas().getName();
            String title = pbData.aat().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.bKw.abp() + "?share=9105&fr=share";
            String[] aC = pbData.aC(getPageContext().getPageActivity());
            String str2 = aC[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String format = MessageFormat.format(getResources().getString(com.baidu.tieba.t.share_content_tpl), title, name, aC[1]);
            com.baidu.tbadk.coreExtra.share.g gVar = new com.baidu.tbadk.coreExtra.share.g();
            gVar.title = title;
            gVar.content = format;
            gVar.linkUrl = str;
            if (parse != null) {
                gVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), gVar, true, pB());
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(com.baidu.tieba.t.share_tieba_qunzu, com.baidu.tieba.p.icon_unite_share_qunzu, new ar(this));
            shareDialogConfig.addOutsideTextView(com.baidu.tieba.t.forum_friend, com.baidu.tieba.p.icon_unite_share_baf, new as(this));
            shareDialogConfig.setCopyLinkListener(new au(this, gVar));
            sendMessage(new CustomMessage(2001283, shareDialogConfig));
        }
    }

    private SparseArray<String> pB() {
        if (this.aSM == null) {
            this.aSM = new SparseArray<>(7);
            this.aSM.put(2, "pb_wx_timeline");
            this.aSM.put(3, "pb_wx_friend");
            this.aSM.put(4, "pb_qq_zone");
            this.aSM.put(5, "pb_tencent_weibo");
            this.aSM.put(6, "pb_sina_weibo");
            this.aSM.put(7, "pb_renren");
        }
        return this.aSM;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool() {
        if (this.aut == null) {
            this.aut = new com.baidu.adp.lib.e.b<>(new av(this), 15, 0);
        }
        return this.aut;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abd() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.pb.a.b pbData = this.bKw.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.qK().isIfAddition();
            AdditionData aay = pbData.aay();
            boolean z3 = aay == null ? false : isIfAddition;
            if (z3) {
                z = aay.getAlreadyCount() != aay.getTotalCount();
                if (!TextUtils.isEmpty(aay.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.pb.main.b.a aVar = this.bKA.bNj;
            if (!z3 || !z) {
                z2 = false;
            }
            aVar.ej(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bKA.abZ() == view && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.core.data.w aat = this.bKw.getPbData().aat();
            if (view != null) {
                boolean z = aat.getPraise() == null || aat.getPraise().getIsLike() == 0;
                if (motionEvent.getAction() == 0) {
                    if (System.currentTimeMillis() - this.praiseStopTime > 1000) {
                        this.isPraiseToServer = true;
                        praiseAnimDown(view);
                    } else {
                        this.isPraiseToServer = false;
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (z) {
                        praiseAnimUp(view, this.isPraiseToServer);
                    } else {
                        praiseAnimCancel(view, this.isPraiseToServer);
                    }
                } else if (motionEvent.getAction() == 2) {
                    praiseAnimCancel(view, this.isPraiseToServer);
                } else if (motionEvent.getAction() == 3) {
                    praiseAnimCancel(view, this.isPraiseToServer);
                }
            }
        }
        return false;
    }

    private void praiseAnimCancel(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), com.baidu.tieba.k.praise_animation_scale2));
            new Handler().postDelayed(new aw(this), 200L);
        }
    }

    private void praiseAnimUp(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), com.baidu.tieba.k.praise_animation_scale3));
            new Handler().postDelayed(new ax(this), 600L);
        }
    }

    private void praiseAnimDown(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), com.baidu.tieba.k.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void KE() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.n.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.t.login_to_use), true, 11017)));
        } else if (!this.bKz.apt()) {
            this.bKA.acd();
            if (aVar.rM() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.rM();
                int intValue = ((Integer) sparseArray.get(com.baidu.tieba.q.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.q.tag_del_post_is_self)).booleanValue();
                int intValue2 = ((Integer) sparseArray.get(com.baidu.tieba.q.tag_del_post_type)).intValue();
                this.bKz.a(this.bKw.getPbData().aas().getId(), this.bKw.getPbData().aas().getName(), this.bKw.getPbData().aat().getId(), (String) sparseArray.get(com.baidu.tieba.q.tag_del_post_id), intValue2, intValue, booleanValue);
            }
        }
    }
}
