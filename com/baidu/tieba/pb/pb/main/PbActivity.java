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
    private static String bKn = "tbgametype";
    private com.baidu.tieba.tbadkCore.location.e aJM;
    private String aJR;
    private com.baidu.adp.lib.e.b<TbImageView> aaj;
    private boolean alI;
    private com.baidu.adp.lib.e.b<ImageView> auq;
    private com.baidu.adp.lib.e.b<TextView> aur;
    private com.baidu.adp.lib.e.b<View> aus;
    private com.baidu.adp.lib.e.b<LinearLayout> aut;
    private com.baidu.adp.lib.e.b<GifView> auu;
    private com.baidu.tbadk.core.dialog.a bKp;
    private VoiceData.VoiceModel bKq;
    private boolean mIsFromCDN;
    private String mPhoneNumber;
    private String mPostContent;
    private VoiceManager mVoiceManager;
    private boolean bKh = false;
    private boolean aKW = true;
    private boolean bIU = false;
    private com.baidu.tbadk.core.dialog.a bKi = null;
    private String bKj = null;
    private String mDownloadUrl = null;
    private String bKk = null;
    private String bKl = null;
    private String mPackageName = null;
    private int bKm = 0;
    private com.baidu.tbadk.core.dialog.e bKo = null;
    SparseArray<String> aSL = null;
    private long aEP = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private WriteData bKr = new WriteData();
    private long aqD = 0;
    private long createTime = 0;
    private long aqE = 0;
    private boolean bKs = false;
    private com.baidu.tbadk.performanceLog.h bKt = null;
    private String bKu = null;
    private final Handler mHandler = new Handler(new b(this));
    private bo bKv = null;
    private com.baidu.tbadk.baseEditMark.a bKw = null;
    private com.baidu.tieba.tbadkCore.writeModel.a aJT = null;
    private com.baidu.tieba.pb.c.a bKx = null;
    private com.baidu.tieba.tbadkCore.h.a bKy = null;
    private ch bKz = null;
    public final com.baidu.tieba.pb.pb.main.a.a bKA = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean bKB = false;
    private boolean bKC = false;
    private MorePopupWindow bKD = null;
    private cf bKE = null;
    private boolean aKY = false;
    private CustomMessageListener aRV = new m(this, 2001276);
    private CustomMessageListener bKF = new x(this, 2004007);
    private com.baidu.tieba.tbadkCore.location.j aJX = new ai(this);
    private com.baidu.tieba.tbadkCore.location.k aJY = new at(this);
    private boolean aJN = false;
    private com.baidu.tieba.tbadkCore.ar aKb = new com.baidu.tieba.tbadkCore.ar(getPageContext(), new ay(this));
    private long praiseStopTime = 0;
    private boolean isPraiseToServer = true;
    private com.baidu.tieba.pb.b.d bKG = new com.baidu.tieba.pb.b.d(new az(this));
    public com.baidu.tbadk.core.dialog.d bGZ = new ba(this);
    public final View.OnClickListener aNU = new bb(this);
    private final bs bKH = new c(this);
    private final com.baidu.tbadk.baseEditMark.b bKI = new d(this);
    private final AbsListView.OnScrollListener HA = new e(this);
    private final com.baidu.tieba.tbadkCore.writeModel.e bKJ = new f(this);
    private final com.baidu.adp.base.i bKK = new g(this);
    private final bd bKL = new h(this);
    private final com.baidu.tbadk.core.view.aj aAq = new i(this);
    private final com.baidu.adp.widget.ListView.x bKM = new j(this);
    private final com.baidu.adp.widget.ListView.aa bKN = new k(this);
    private final com.baidu.tbadk.core.dialog.h bjX = new l(this);
    private final com.baidu.adp.base.i bKO = new n(this);
    private int bKP = 0;
    private final com.baidu.tbadk.widget.richText.s auJ = new o(this);
    boolean bKQ = false;
    com.baidu.tieba.tbadkCore.data.j bKR = null;
    private final com.baidu.tbadk.core.dialog.h bKS = new p(this);
    private final View.OnLongClickListener afC = new q(this);
    private final com.baidu.tbadk.core.view.ad aLO = new r(this);

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        if (cVar.aaA() != null) {
            String id = cVar.aaA().getId();
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aat = this.bKv.getPbData().aat();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aat.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = aat.get(i2);
                if (jVar.getId() == null || !jVar.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.data.j> aaC = cVar.aaC();
                    jVar.iP(cVar.getTotalCount());
                    if (jVar.aoy() != null) {
                        jVar.aoy().clear();
                        jVar.aoy().addAll(aaC);
                    }
                }
            }
            this.bKz.e(this.bKv.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JO() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void JP() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.t.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            JQ();
        } else if (this.aJM.apm()) {
            JO();
        } else {
            this.aJM.fi(false);
            if (this.bKz.Ki() != null) {
                this.bKz.Ki().setLocationViewVisibility(0);
                this.bKz.Ki().setLocationInfoViewState(1);
            }
            this.aJM.apk();
        }
    }

    private void JQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bu(com.baidu.tieba.t.location_app_permission_prompt).a(com.baidu.tieba.t.isopen, new s(this)).b(com.baidu.tieba.t.cancel, new t(this)).b(getPageContext());
        aVar.rL();
    }

    public void JR() {
        if (this.bKz.Ki() != null) {
            if (this.aJM.apo()) {
                this.bKz.Ki().setLocationViewVisibility(0);
                if (this.aJM.apm()) {
                    this.aJX.a(com.baidu.tieba.tbadkCore.location.d.aph().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.n.isNetOk()) {
                    this.bKz.Ki().setLocationInfoViewState(1);
                    this.aJM.apk();
                    return;
                } else {
                    this.bKz.Ki().setLocationInfoViewState(0);
                    return;
                }
            }
            this.bKz.Ki().setLocationViewVisibility(8);
        }
    }

    private void aaI() {
        this.bKz.ack();
    }

    private void aaJ() {
        this.bKz.acl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaK() {
        com.baidu.tieba.pb.a.b pbData;
        com.baidu.tbadk.core.data.w aas;
        if (!this.aJN) {
            if (!com.baidu.adp.lib.util.n.isNetOk()) {
                showToast(com.baidu.tieba.t.no_network_guide);
            } else if (this.isPraiseToServer) {
                this.aJN = true;
                if (this.bKv != null && (pbData = this.bKv.getPbData()) != null && (aas = pbData.aas()) != null) {
                    int isLike = aas.getPraise() == null ? 0 : aas.getPraise().getIsLike();
                    if (this.aKb != null) {
                        this.aKb.a(aas.rs(), aas.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eS(int i) {
        com.baidu.tbadk.core.data.w aas;
        String sb;
        String q;
        if (this.bKv != null && this.bKv.getPbData() != null && (aas = this.bKv.getPbData().aas()) != null) {
            if (i == 1) {
                PraiseData praise = aas.getPraise();
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
                        aas.setPraise(praiseData);
                    } else {
                        aas.getPraise().getUser().add(0, metaData);
                        aas.getPraise().setNum(aas.getPraise().getNum() + 1);
                        aas.getPraise().setIsLike(i);
                    }
                }
                if (aas.getPraise() != null) {
                    if (aas.getPraise().getNum() < 1) {
                        q = getResources().getString(com.baidu.tieba.t.frs_item_praise_text);
                    } else {
                        q = com.baidu.tbadk.core.util.bb.q(aas.getPraise().getNum());
                    }
                    this.bKz.z(q, true);
                }
            } else if (aas.getPraise() != null) {
                aas.getPraise().setIsLike(i);
                aas.getPraise().setNum(aas.getPraise().getNum() - 1);
                ArrayList<MetaData> user = aas.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aas.getPraise().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aas.getPraise().getNum() < 1) {
                    sb = getResources().getString(com.baidu.tieba.t.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(aas.getPraise().getNum())).toString();
                }
                this.bKz.z(sb, false);
            }
            if (this.bKv.abp()) {
                this.bKz.aca().notifyDataSetChanged();
            } else {
                this.bKz.f(this.bKv.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bKv.saveToBundle(bundle);
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aJR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.aEP = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aEP = System.currentTimeMillis();
        }
        this.bKm = 0;
        initUI();
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initData(bundle);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.aEP;
        registerListener(this.aRV);
        registerListener(this.bKF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.bKz != null && this.bKz.Ki() != null) {
            this.bKz.Ki().any();
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

    public bo aaL() {
        return this.bKv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.bKh = true;
        super.onPause();
        BdListView listView = getListView();
        this.bKm = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.bKm == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
        if (this.bKz != null) {
            this.bKz.onPause();
        }
        if (!this.bKv.abs()) {
            WriteData JS = this.aJT.JS();
            if (JS == null) {
                JS = new WriteData(1);
                JS.setThreadId(this.bKv.abo());
                JS.setWriteImagesInfo(this.writeImagesInfo);
            }
            JS.setContent(this.bKz.Kp());
            if (this.bKr != null && this.bKr.getIsBaobao()) {
                JS.setBaobaoContent(this.bKr.getBaobaoContent());
                JS.setBaobaoImagesInfo(this.baobaoImagesInfo);
                JS.setIsBaobao(true);
            }
            com.baidu.tieba.tbadkCore.ao.b(this.bKv.abo(), JS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        this.bKh = false;
        super.onResume();
        if (this.bKm == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView abS = this.bKz.abS();
        if (abS != null && abS.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            abS.at(false);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
        if (this.bKz.Ki() != null) {
            this.bKz.Ki().refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.bKz.ec(z);
        if (this.bKE != null) {
            this.bKE.eb(z);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ap
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!com.baidu.tbadk.core.util.bb.isEmpty(writeData.getContent()) && com.baidu.tbadk.core.util.bb.isEmpty(this.bKz.Kp())) {
                this.mPostContent = writeData.getContent();
                this.bKz.gj(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                this.bKz.a(this.writeImagesInfo, true);
            }
            if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.bKr.setIsBaobao(writeData.getIsBaobao());
                this.bKr.setBaobaoContent(writeData.getBaobaoContent());
                this.bKr.setBaobaoImagesInfo(this.baobaoImagesInfo);
                this.bKz.setBaobaoUris(this.baobaoImagesInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bKz.Ki() != null && this.bKz.Ki().getVisibility() != 0) {
            aaN();
            this.bKz.abV();
        }
        this.bKz.bNi.XQ();
        if (this.bKv != null && this.bKv.getPbData() != null && this.bKv.getPbData().aar() != null && this.bKv.getPbData().aas() != null) {
            com.baidu.tbadk.distribute.a.yX().a(getPageContext().getPageActivity(), "pb", this.bKv.getPbData().aar().getId(), com.baidu.adp.lib.g.c.c(this.bKv.getPbData().aas().getId(), 0L));
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (!this.bKs) {
            this.bKs = true;
            this.bKz.acz();
        }
        this.bKv.cancelLoadData();
        this.bKv.destory();
        this.aJT.cancelLoadData();
        this.bKx.cancelLoadData();
        this.aJM.cancelLoadData();
        this.bKy.cancelLoadData();
        this.bKz.onDestroy();
        if (this.bKt != null) {
            this.bKt.onDestroy();
        }
        super.onDestroy();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
    }

    public void aaM() {
        if (this.bKz.Ki() != null) {
            this.bKz.Ki().setContent(this.mPostContent == null ? "" : this.mPostContent);
            if (this.bKq != null) {
                this.bKz.Ki().anI();
            }
            this.bKz.a(this.writeImagesInfo, true);
            this.bKz.setBaobaoUris(this.baobaoImagesInfo);
            if (!StringUtils.isNull(this.mPostContent)) {
                this.bKz.Ki().CQ();
                this.bKz.Ki().anO();
                this.bKz.ef(false);
            } else if (this.writeImagesInfo != null && this.writeImagesInfo.size() >= 1) {
                this.bKz.Ki().cqO.hideAll();
                this.bKz.Ki().setVisibility(0);
                this.bKz.Ki().anO();
                this.bKz.Ki().iN(23);
            } else if (this.bKq != null) {
                this.bKz.Ki().cqO.hideAll();
                this.bKz.Ki().setVisibility(0);
                this.bKz.Ki().anO();
                this.bKz.Ki().iN(5);
            } else if (this.baobaoImagesInfo != null && this.baobaoImagesInfo.size() >= 1) {
                this.bKz.Ki().cqO.hideAll();
                this.bKz.Ki().setVisibility(0);
                this.bKz.Ki().anO();
                this.bKz.Ki().iN(50);
            } else {
                this.bKz.Ki().CQ();
                this.bKz.ef(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaN() {
        if (this.bKz.Ki() != null) {
            this.mPostContent = this.bKz.Ki().getContent();
            this.bKq = this.bKz.getAudioData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bKz.onChangeSkinType(i);
        if (this.bKD != null) {
            this.bKD.onChangeSkinType(this, i, com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.bg_collect));
        }
        if (this.bKz.abS() != null) {
            this.bKz.abS().onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaO() {
        this.bKE = new cf(getPageContext(), this.aNU);
        this.bKE.eb(this.mIsLogin);
        this.bKD = new MorePopupWindow(getPageContext().getPageActivity(), this.bKE.getView(), getResources().getDrawable(com.baidu.tieba.p.bg_collect), null);
        this.bKD.setTouchInterceptor(new u(this));
        this.bKD.onChangeSkinType(this, TbadkCoreApplication.m411getInst().getSkinType(), com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.bg_collect));
    }

    private void initUI() {
        this.bKz = new ch(this, this.aNU, this.bKG);
        this.bKz.setOnActionListener(new v(this));
        this.bKz.setOnScrollListener(this.HA);
        this.bKz.c(this.bKM);
        this.bKz.a(this.bKN);
        this.bKz.b(this.bjX);
        this.bKz.a(this.aAq);
        this.bKz.setIsShowImage(com.baidu.tbadk.core.n.qc().qg());
        this.bKz.dT(com.baidu.tbadk.core.n.qc().qe());
        this.bKz.setOnImageClickListener(this.auJ);
        this.bKz.a(this.afC);
        this.bKz.f(this.aLO);
        this.bKz.a(this.bKL);
        this.bKz.ec(this.mIsLogin);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.bKz != null) {
            if (z && !this.bIU) {
                if (this.aKW) {
                    this.aKW = false;
                    showLoadingView(this.bKz.getView(), true);
                    return;
                }
                return;
            }
            hideLoadingView(this.bKz.getView());
        }
    }

    private void aaP() {
        if (this.bKo == null) {
            this.bKo = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
            this.bKo.a(new String[]{getPageContext().getString(com.baidu.tieba.t.call_phone), getPageContext().getString(com.baidu.tieba.t.sms_phone), getPageContext().getString(com.baidu.tieba.t.search_in_baidu)}, new w(this)).by(com.baidu.tbadk.core.dialog.g.Sa).bz(17).d(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        this.bKv = new bo(this);
        this.bKv.a(this.bKH);
        this.bKw = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.bKw != null) {
            this.bKw.a(this.bKI);
        }
        this.aJT = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aJT.a(this.bKJ);
        this.bKx = new com.baidu.tieba.pb.c.a(this);
        this.bKx.setLoadDataCallBack(this.bKO);
        this.bKy = new com.baidu.tieba.tbadkCore.h.a(this);
        this.bKy.setLoadDataCallBack(this.bKK);
        this.aJM = new com.baidu.tieba.tbadkCore.location.e(this);
        this.aJM.a(this.aJX);
        this.aJM.a(this.aJY);
        if (bundle != null) {
            this.bKv.initWithBundle(bundle);
        } else {
            this.bKv.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.c.REQUEST_CODE, -1) == 18003) {
            this.bKv.dY(true);
        }
        cb.abK().y(this.bKv.abm(), this.bKv.getIsFromMark());
        this.bKz.acf();
        this.bKv.BL();
        this.bKz.a(new y(this));
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aJR = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!this.bKv.abs()) {
            com.baidu.tieba.tbadkCore.ao.a(this.bKv.abo(), this);
        }
        this.aKb.setUniqueId(getUniqueId());
        this.aKb.registerListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dQ(boolean z) {
        if (this.bKv == null || this.bKv.getPbData() == null) {
            return false;
        }
        return ((this.bKv.getPbData().aav() != 0) || this.bKv.getPbData().aas() == null || this.bKv.getPbData().aas().getAuthor() == null || TextUtils.equals(this.bKv.getPbData().aas().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void aaQ() {
        if (this.bKv != null && this.bKv.getPbData() != null && this.bKv.getPbData().aas() != null && this.bKv.getPbData().aas().getAuthor() != null) {
            this.bKz.bNi.c(this.bKv.abp(), this.bKw != null ? this.bKw.pq() : false, dQ(TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.bKv.getPbData().aas().getAuthor().getUserId())));
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
        abb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Boolean bool) {
        com.baidu.tieba.pb.a.b pbData;
        String str = null;
        if (this.bKv != null && (pbData = this.bKv.getPbData()) != null && pbData.aar() != null) {
            str = pbData.aar().getName();
        }
        if (com.baidu.tieba.tbadkCore.ad.a(str, bool)) {
            aaJ();
        } else {
            aaI();
        }
    }

    public void a(boolean z, MarkData markData) {
        this.bKz.aci();
        this.bKv.dX(z);
        if (this.bKw != null) {
            this.bKw.Z(z);
            if (markData != null) {
                this.bKw.a(markData);
            }
        }
        if (this.bKv.pq()) {
            aaW();
        } else {
            this.bKz.e(this.bKv.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void im(String str) {
        if (!StringUtils.isNull(str) && this.bKv != null) {
            String abo = this.bKv.abo();
            String id = this.bKv.getPbData().aar().getId();
            sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(com.baidu.tieba.t.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + abo + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            if (!this.bKv.abs()) {
                antiData.setBlock_forum_name(this.bKv.getPbData().aar().getName());
                antiData.setBlock_forum_id(this.bKv.getPbData().aar().getId());
                antiData.setUser_name(this.bKv.getPbData().getUserData().getUserName());
                antiData.setUser_id(this.bKv.getPbData().getUserData().getUserId());
            }
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.tieba.tbadkCore.writeModel.h.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            if (!this.bKv.abs()) {
                antiData.setBlock_forum_name(this.bKv.getPbData().aar().getName());
                antiData.setBlock_forum_id(this.bKv.getPbData().aar().getId());
                antiData.setUser_name(this.bKv.getPbData().getUserData().getUserName());
                antiData.setUser_id(this.bKv.getPbData().getUserData().getUserId());
            }
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        this.bKz.showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.h.c cVar) {
        int i = 0;
        if (cVar != null) {
            this.bKz.a(0, cVar.AA, cVar.ctT, true);
            if (cVar.AA) {
                if (cVar.ctR == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.j> aat = this.bKv.getPbData().aat();
                    int size = aat.size();
                    while (true) {
                        if (i < size) {
                            if (!cVar.mPostId.equals(aat.get(i).getId())) {
                                i++;
                            } else {
                                aat.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.bKz.e(this.bKv.getPbData());
                } else if (cVar.ctR == 0) {
                    aaR();
                } else if (cVar.ctR == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.data.j> aat2 = this.bKv.getPbData().aat();
                    int size2 = aat2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < aat2.get(i2).aoy().size()) {
                                if (!cVar.mPostId.equals(aat2.get(i2).aoy().get(i3).getId())) {
                                    i3++;
                                } else {
                                    aat2.get(i2).aoy().remove(i3);
                                    aat2.get(i2).aoz();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData aax = this.bKv.getPbData().aax();
                        com.baidu.tieba.tbadkCore.data.j jVar = aat2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.data.j> aoA = jVar.aoA();
                        int size3 = aoA.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!cVar.mPostId.equals(aat2.get(i2).aoA().get(i4).getId())) {
                                    i4++;
                                } else {
                                    aoA.remove(i4);
                                    aax.decreaseAlreadyCount();
                                    if (jVar.aoH() > aoA.size()) {
                                        jVar.iR(aoA.size());
                                    }
                                    if (aoA.size() > 0) {
                                        com.baidu.tieba.tbadkCore.data.j jVar2 = aoA.get(aoA.size() - 1);
                                        aax.setLastAdditionTime(jVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a aoC = jVar2.aoC();
                                        String str = "";
                                        if (aoC != null) {
                                            str = aoC.toString();
                                        }
                                        aax.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a aoC2 = jVar.aoC();
                                        String str2 = "";
                                        if (aoC2 != null) {
                                            str2 = aoC2.toString();
                                        }
                                        aax.setLastAdditionContent(str2);
                                    }
                                    abc();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.bKz.e(this.bKv.getPbData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.h.e eVar) {
        this.bKz.a(1, eVar.AA, eVar.ctT, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.h.g gVar) {
        this.bKz.a(this.bKy.getLoadDataMode(), gVar.AA, gVar.ctT, false);
        this.bKz.K(gVar.ctV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.tbadkCore.h.g gVar) {
        if (gVar != null) {
            this.bKz.a(this.bKy.getLoadDataMode(), gVar.AA, gVar.ctT, true);
            if (gVar.AA) {
                this.bKC = true;
                if (i == 2) {
                    this.bKv.getPbData().aas().br(1);
                    this.bKv.setIsGood(1);
                } else if (i == 3) {
                    this.bKv.getPbData().aas().br(0);
                    this.bKv.setIsGood(0);
                } else if (i == 4) {
                    this.bKv.getPbData().aas().bq(1);
                    this.bKv.hz(1);
                } else if (i == 5) {
                    this.bKv.getPbData().aas().bq(0);
                    this.bKv.hz(0);
                }
                this.bKz.a(this.bKv.getPbData(), this.bKv.abp(), true);
            }
        }
    }

    private void aaR() {
        if (this.bKv.abq()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.bKv.abo());
            setResult(-1, intent);
        }
        if (aaX()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaS() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        this.bKz.acw();
        if (this.bKv != null && this.bKv.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.bKv.getPbData().aas().getId();
            historyMessage.forumName = this.bKv.getPbData().aar().getName();
            historyMessage.threadName = this.bKv.getPbData().aas().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aat = this.bKv.getPbData().aat();
            int acn = this.bKz.acn();
            if (aat != null && acn >= 0 && acn < aat.size()) {
                historyMessage.postID = aat.get(acn).getId();
            }
            historyMessage.isHostOnly = this.bKv.getHostMode();
            historyMessage.isSquence = this.bKv.abp();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.bKv != null && this.bKv.abq()) {
            Intent intent = new Intent();
            if (this.bKC) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.bKv.abo());
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.bKv.abr());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.bKv.getIsGood());
            }
            setResult(-1, intent);
        }
        if (aaX()) {
            if (this.bKv != null && this.bKz != null && this.bKz.getListView() != null) {
                com.baidu.tieba.pb.a.b pbData = this.bKv.getPbData();
                if (pbData != null && pbData.getUserData() != null) {
                    pbData.getUserData().setBimg_url(TbadkCoreApplication.m411getInst().getDefaultBubble());
                }
                cb.abK().a(this.bKv.getPbData(), this.bKz.getListView().onSaveInstanceState(), this.bKv.abp(), this.bKv.getHostMode());
            } else {
                cb.abK().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.bKD != null) {
                    com.baidu.adp.lib.g.k.a(this.bKD, getPageContext().getPageActivity());
                }
                if (this.bKz.eh(this.bKv.abs())) {
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
                    aaV();
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
                        aaU();
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            this.bKz.acm();
                            this.aJT.fj(false);
                            return;
                        }
                        this.bKx.il(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    aaU();
                    ArrayList<String> U = com.baidu.tieba.tbadkCore.util.i.U(intent);
                    if (U != null) {
                        this.bKz.u(U);
                        return;
                    }
                    return;
                case 12006:
                    WriteData JS = this.aJT.JS();
                    if (JS != null) {
                        JS.deleteUploadedTempImages();
                    }
                    this.bKr.setIsBaobao(false);
                    this.bKr.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.aJT.c((WriteData) null);
                    this.aJT.fj(false);
                    this.bKz.bT(true);
                    if (this.bKv != null && this.bKv.abv()) {
                        this.bKz.acf();
                    }
                    if (this.bKv != null && this.bKv.abo() != null && !this.bKv.abs()) {
                        com.baidu.tieba.tbadkCore.ao.b(this.bKv.abo(), (WriteData) null);
                    }
                    this.bKz.a(this.writeImagesInfo, true);
                    return;
                case 12009:
                case 12010:
                    aaU();
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
                    cb.abK().reset();
                    this.mHandler.postDelayed(new z(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.bKv != null) {
                        a(aaT(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getIntExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0));
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
                JT();
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
                aaU();
                return;
        }
    }

    private ShareFromPBMsgData aaT() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] aC = this.bKv.getPbData().aC(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.data.j abU = this.bKz.abU();
        String str = "";
        if (abU != null) {
            str = abU.getId();
            String aK = abU.aK(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.m.isEmpty(aK)) {
                aC[1] = aK;
            }
        }
        String rs = this.bKv.getPbData().aas().rs();
        if (rs != null && rs.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(aC[1]);
        shareFromPBMsgData.setImageUrl(aC[0]);
        shareFromPBMsgData.setForumName(this.bKv.getPbData().aar().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.bKv.getPbData().aas().getId());
        shareFromPBMsgData.setTitle(this.bKv.getPbData().aas().getTitle());
        return shareFromPBMsgData;
    }

    private void Q(Intent intent) {
        a(aaT(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.bKv != null && this.bKv.getPbData() != null && this.bKv.getPbData().aas() != null) {
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
                dcVar.v(shareFromPBMsgData.getImageUrl(), this.bKv.getPbData().aaw() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, int i2) {
        if (this.bKv != null && this.bKv.getPbData() != null && this.bKv.getPbData().aas() != null) {
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
                dcVar.v(shareFromPBMsgData.getImageUrl(), this.bKv.getPbData().aaw() == 1);
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
        this.aJR = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aJR;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cu = com.baidu.tbadk.core.util.c.cu(str);
                if (cu != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.M(getPageContext().getPageActivity())), com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.N(getPageContext().getPageActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.c.h(b, cu);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.o.a(TbConfig.LOCAL_CAMERA_DIR, this.aJR, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            this.bKz.a(this.writeImagesInfo, true);
        }
        if (this.bKz.Ki() != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            this.bKz.Ki().iN(23);
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
                    this.bKz.a(this.writeImagesInfo, z);
                }
            }
            if (this.bKz.Ki() != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                this.bKz.Ki().iN(23);
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
                this.bKz.setBaobaoUris(this.baobaoImagesInfo);
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    if (this.bKz.Ki() != null) {
                        this.bKz.Ki().iN(50);
                    }
                    this.bKr.setIsBaobao(true);
                    this.bKr.setBaobaoContent(stringExtra2);
                    this.bKr.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.bKr.setIsBaobao(false);
                this.bKr.setBaobaoContent("");
                this.bKr.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void JT() {
        new ae(this).execute(new Void[0]);
    }

    private void aaU() {
        if (this.bKB) {
            this.bKB = false;
            new Handler().postDelayed(new af(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaV() {
        MarkData hF;
        if (this.bKw != null && (hF = this.bKv.hF(this.bKz.acn())) != null) {
            this.bKz.acf();
            this.bKw.a(hF);
            if (!this.bKw.pq()) {
                this.bKw.ps();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.bKw.pr();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gg(String str) {
        VoiceData.VoiceModel voiceModel;
        if (this.aJT.JS() == null && !this.bKv.abs()) {
            this.aJT.c(this.bKv.iq(str));
        }
        if (this.aJT.JS() != null) {
            if (!this.bKv.abs()) {
                this.aJT.JS().setWriteImagesInfo(this.writeImagesInfo);
                this.aJT.fj(this.writeImagesInfo.size() > 0);
                if (this.bKr.getIsBaobao()) {
                    this.aJT.JS().setIsBaobao(true);
                    this.aJT.JS().setBaobaoContent(this.bKr.getBaobaoContent());
                    this.aJT.JS().setBaobaoImagesInfo(this.baobaoImagesInfo);
                } else {
                    this.aJT.JS().setIsBaobao(false);
                }
            }
            if (this.bKz.Ki() != null) {
                this.aJT.JS().setHasLocationData(this.bKz.Ki().getLocationInfoViewState() == 2);
            }
            if (str == null) {
                this.aJT.JS().setContent(this.bKz.Kp());
                voiceModel = this.bKz.getAudioData();
                this.bKz.Kr();
            } else {
                voiceModel = null;
            }
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.aJT.JS().setVoice(voiceModel.getId());
                    this.aJT.JS().setVoiceDuringTime(voiceModel.duration);
                } else {
                    this.aJT.JS().setVoice(null);
                    this.aJT.JS().setVoiceDuringTime(-1);
                }
            } else {
                this.aJT.JS().setVoice(null);
                this.aJT.JS().setVoiceDuringTime(-1);
            }
            if (!this.aJT.apJ()) {
                showToast(com.baidu.tieba.t.write_img_limit);
            } else if (this.aJT.apH()) {
                this.bKz.Ko();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaW() {
        com.baidu.tieba.pb.a.b pbData = this.bKv.getPbData();
        this.bKv.dX(true);
        pbData.ik(this.bKw.pp());
        this.bKz.e(pbData);
    }

    private boolean aaX() {
        if (this.bKv == null) {
            return true;
        }
        if (this.bKv.pq()) {
            MarkData abB = this.bKv.abB();
            if (abB == null || !this.bKv.getIsFromMark()) {
                return true;
            }
            MarkData hF = this.bKv.hF(this.bKz.acn());
            if (hF == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, abB);
                setResult(-1, intent);
                return true;
            } else if (hF.getPostId() == null || hF.getPostId().equals(abB.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, abB);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cn(String.format(getPageContext().getString(com.baidu.tieba.t.alert_update_mark), Integer.valueOf(hF.getFloor())));
                aVar.a(com.baidu.tieba.t.alert_yes_btn, new ag(this, hF, abB));
                aVar.b(com.baidu.tieba.t.alert_no_button, new ah(this, abB));
                aVar.a(new aj(this, abB));
                aVar.b(getPageContext());
                aVar.rL();
                return false;
            }
        } else if (this.bKv.getPbData() == null || this.bKv.getPbData().aat() == null || this.bKv.getPbData().aat().size() <= 0 || !this.bKv.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.at
    public BdListView getListView() {
        if (this.bKz == null) {
            return null;
        }
        return this.bKz.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int getRichTextViewId() {
        if (this.bKz == null) {
            return 0;
        }
        return this.bKz.acq();
    }

    @Override // com.baidu.tbadk.core.view.at
    public int uB() {
        if (this.bKz == null) {
            return 0;
        }
        return this.bKz.Lt();
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
            String str3 = de.get(bKn);
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
                    aaY();
                } else {
                    aaZ();
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
                            this.bKk = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.bKl = split[i].substring(indexOf2 + 1, split[i].length());
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
                        this.bKj = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void aaY() {
        if (TextUtils.isEmpty(this.bKk) || TextUtils.isEmpty(this.bKl) || TextUtils.isEmpty(this.mPackageName)) {
            if (!TextUtils.isEmpty(this.bKj)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.bKj);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(this.bKk));
        intent.setAction(this.bKl);
        intent.setPackage(this.mPackageName);
        if (intent.resolveActivity(getPageContext().getPageActivity().getPackageManager()) != null) {
            if (!com.baidu.adp.lib.g.j.e(getPageContext().getPageActivity(), intent) && !TextUtils.isEmpty(this.bKj)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.bKj);
            }
        } else if (!TextUtils.isEmpty(this.bKj)) {
            com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.bKj);
        }
    }

    private void aaZ() {
        if (!com.baidu.adp.lib.util.k.iY()) {
            if (!TextUtils.isEmpty(this.bKj)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.bKj);
                return;
            }
            return;
        }
        if (this.bKi == null) {
            this.bKi = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.bKi.bu(com.baidu.tieba.t.download_iqiyi_app_dialog);
            this.bKi.a(com.baidu.tieba.t.install_app, new an(this));
            this.bKi.b(com.baidu.tieba.t.webpage_play, new ao(this));
            this.bKi.ah(false);
        }
        this.bKi.b(getPageContext()).rL();
    }

    private com.baidu.tbadk.core.dialog.a aba() {
        if (this.bKp == null) {
            this.bKp = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.bKp.cm(getPageContext().getString(com.baidu.tieba.t.download_baidu_video_dialog));
            this.bKp.a(getPageContext().getString(com.baidu.tieba.t.install), new ap(this));
            this.bKp.b(getPageContext().getString(com.baidu.tieba.t.cancel), new aq(this));
            this.bKp.ag(true);
            this.bKp.b(getPageContext());
            this.bKp.ah(false);
        }
        this.bKp.rL();
        return this.bKp;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onVideoClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (io(str) || z) {
                boolean u = com.baidu.adp.lib.util.n.u(context, "com.qiyi.video");
                ip(str);
                if (u) {
                    aaY();
                    return;
                } else {
                    aaZ();
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
            aba();
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
        com.baidu.tbadk.widget.richText.g Eq;
        if (aVar == aVar2) {
            this.bKQ = true;
        }
        if (aVar != null) {
            int size = aVar.El().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.El().get(i6) != null && aVar.El().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.El().get(i6).Eq().getWidth();
                    int height = aVar.El().get(i6).Eq().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.El().get(i6).Eq().Ex()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.El().get(i6);
                        String b = b(cVar);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && cVar != null && (Eq = cVar.Eq()) != null) {
                            String Ey = Eq.Ey();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Ey;
                            int i8 = this.mIsFromCDN ? 17 : 18;
                            imageUrlData.urlType = i8;
                            imageUrlData.urlType = i8;
                            if (hashMap != null) {
                                hashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.bKQ) {
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
            if (jVar.getId() != null && jVar.getId().equals(this.bKv.ro())) {
                z = true;
            }
            MarkData c = this.bKv.c(jVar);
            if (c != null) {
                this.bKz.acf();
                if (this.bKw != null) {
                    this.bKw.a(c);
                    if (!z) {
                        this.bKw.ps();
                    } else {
                        this.bKw.pr();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a O(String str, int i) {
        if (this.bKv == null || this.bKv.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.a.b pbData = this.bKv.getPbData();
        com.baidu.tbadk.widget.richText.a a = a(pbData.aat(), str, i);
        if (a == null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aat = pbData.aat();
            int size = aat.size();
            for (int i2 = 0; i2 < size; i2++) {
                a = a(aat.get(i2).aoA(), str, i);
                if (a != null) {
                    return a;
                }
            }
            return a;
        }
        return a;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.data.j> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> El;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a aoC = arrayList.get(i2).aoC();
            if (aoC != null && (El = aoC.El()) != null) {
                int size = El.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (El.get(i4) != null && El.get(i4).getType() == 8) {
                        i3++;
                        if (El.get(i4).Eq().Ey().equals(str)) {
                            int width = El.get(i4).Eq().getWidth();
                            int height = El.get(i4).Eq().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.bKP = i4;
                            return aoC;
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
        com.baidu.tbadk.widget.richText.g Eq = cVar.Eq();
        if (Eq != null) {
            if (!StringUtils.isNull(Eq.Ew())) {
                return Eq.Ew();
            }
            if (Eq.getHeight() * Eq.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Eq.getHeight() * Eq.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Eq.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Eq.getHeight())));
            } else {
                float width = Eq.getWidth() / Eq.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.bb.aV(Eq.getSrc()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onPhoneClicked(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mPhoneNumber = str;
            if (this.bKo == null) {
                aaP();
            }
            com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "pb_show_phonedialog");
            if (str2.equals("2")) {
                this.bKo.bB(1).setVisibility(8);
            } else {
                this.bKo.bB(1).setVisibility(0);
            }
            this.bKo.rN();
        }
    }

    @Override // com.baidu.tbadk.core.voice.j
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abb() {
        hideNetRefreshView(this.bKz.getView());
        showLoadingView(this.bKz.getView(), true);
        if (this.bKv.BL()) {
            this.bKz.acf();
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
        if (this.bKv.abA()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.a.b pbData = this.bKv.getPbData();
            String name = pbData.aar().getName();
            String title = pbData.aas().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.bKv.abo() + "?share=9105&fr=share";
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
        if (this.aSL == null) {
            this.aSL = new SparseArray<>(7);
            this.aSL.put(2, "pb_wx_timeline");
            this.aSL.put(3, "pb_wx_friend");
            this.aSL.put(4, "pb_qq_zone");
            this.aSL.put(5, "pb_tencent_weibo");
            this.aSL.put(6, "pb_sina_weibo");
            this.aSL.put(7, "pb_renren");
        }
        return this.aSL;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool() {
        if (this.aut == null) {
            this.aut = new com.baidu.adp.lib.e.b<>(new av(this), 15, 0);
        }
        return this.aut;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abc() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.pb.a.b pbData = this.bKv.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.qK().isIfAddition();
            AdditionData aax = pbData.aax();
            boolean z3 = aax == null ? false : isIfAddition;
            if (z3) {
                z = aax.getAlreadyCount() != aax.getTotalCount();
                if (!TextUtils.isEmpty(aax.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.pb.main.b.a aVar = this.bKz.bNi;
            if (!z3 || !z) {
                z2 = false;
            }
            aVar.ej(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bKz.abY() == view && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.core.data.w aas = this.bKv.getPbData().aas();
            if (view != null) {
                boolean z = aas.getPraise() == null || aas.getPraise().getIsLike() == 0;
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

    public void KD() {
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
        } else if (!this.bKy.aps()) {
            this.bKz.acc();
            if (aVar.rM() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.rM();
                int intValue = ((Integer) sparseArray.get(com.baidu.tieba.q.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.q.tag_del_post_is_self)).booleanValue();
                int intValue2 = ((Integer) sparseArray.get(com.baidu.tieba.q.tag_del_post_type)).intValue();
                this.bKy.a(this.bKv.getPbData().aar().getId(), this.bKv.getPbData().aar().getName(), this.bKv.getPbData().aas().getId(), (String) sparseArray.get(com.baidu.tieba.q.tag_del_post_id), intValue2, intValue, booleanValue);
            }
        }
    }
}
