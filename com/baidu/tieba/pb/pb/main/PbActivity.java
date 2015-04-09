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
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, com.baidu.tbadk.core.dialog.d, com.baidu.tbadk.core.view.ao, com.baidu.tbadk.core.voice.j, com.baidu.tbadk.widget.richText.j, com.baidu.tieba.tbadkCore.ap {
    private static String bHY = "tbgametype";
    private com.baidu.adp.lib.e.b<TbImageView> Zi;
    private com.baidu.tieba.tbadkCore.location.e aHD;
    private String aHI;
    private boolean akH;
    private com.baidu.adp.lib.e.b<ImageView> asK;
    private com.baidu.adp.lib.e.b<TextView> asL;
    private com.baidu.adp.lib.e.b<View> asM;
    private com.baidu.adp.lib.e.b<LinearLayout> asN;
    private com.baidu.adp.lib.e.b<GifView> asO;
    private com.baidu.tbadk.core.dialog.a bIa;
    private VoiceData.VoiceModel bIb;
    private String bIr;
    private boolean mIsFromCDN;
    private String mPhoneNumber;
    private String mPostContent;
    private VoiceManager mVoiceManager;
    private boolean bHS = false;
    private boolean aIO = true;
    private boolean bGe = false;
    private com.baidu.tbadk.core.dialog.a bHT = null;
    private String bHU = null;
    private String mDownloadUrl = null;
    private String bHV = null;
    private String bHW = null;
    private String mPackageName = null;
    private int bHX = 0;
    private com.baidu.tbadk.core.dialog.e bHZ = null;
    SparseArray<String> aQA = null;
    private long aCO = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private WriteData bIc = new WriteData();
    private long apB = 0;
    private long createTime = 0;
    private long apC = 0;
    private boolean bId = false;
    private com.baidu.tbadk.performanceLog.h bIe = null;
    public long aJq = System.currentTimeMillis();
    private String bIf = null;
    private final Handler mHandler = new Handler(new b(this));
    private br bIg = null;
    private com.baidu.tbadk.baseEditMark.a bIh = null;
    private com.baidu.tieba.tbadkCore.writeModel.a aHK = null;
    private com.baidu.tieba.pb.c.a bIi = null;
    private com.baidu.tieba.pb.pb.sub.e bIj = null;
    private com.baidu.tieba.tbadkCore.h.a bIk = null;
    private cj bIl = null;
    public final com.baidu.tieba.pb.pb.main.a.a bIm = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean bIn = false;
    private boolean bIo = false;
    private MorePopupWindow bIp = null;
    private ci bIq = null;
    private boolean aIQ = false;
    private CustomMessageListener aPK = new m(this, 2001276);
    private com.baidu.tieba.tbadkCore.location.j aHP = new x(this);
    private com.baidu.tieba.tbadkCore.location.k aHQ = new ai(this);
    private boolean aHE = false;
    private com.baidu.tieba.tbadkCore.ar aHT = new com.baidu.tieba.tbadkCore.ar(getPageContext(), new at(this));
    private long praiseStopTime = 0;
    private boolean isPraiseToServer = true;
    private com.baidu.tieba.pb.b.d bIs = new com.baidu.tieba.pb.b.d(new ba(this));
    public final View.OnClickListener aLK = new bb(this);
    private final bv bIt = new bd(this);
    private final com.baidu.tbadk.baseEditMark.b bIu = new be(this);
    private final AbsListView.OnScrollListener HK = new c(this);
    private final AbsListView.OnScrollListener bIv = new d(this);
    private final com.baidu.adp.widget.ListView.x bIw = new e(this);
    private final com.baidu.tieba.pb.pb.sub.g bIx = new f(this);
    private final com.baidu.tieba.tbadkCore.writeModel.e bIy = new g(this);
    private final com.baidu.adp.base.i bIz = new h(this);
    private final bg bIA = new i(this);
    private final com.baidu.tbadk.core.view.ae ayF = new j(this);
    private final com.baidu.adp.widget.ListView.x bIB = new k(this);
    private final com.baidu.adp.widget.ListView.aa bIC = new l(this);
    private final com.baidu.tbadk.core.dialog.h bhr = new n(this);
    private final com.baidu.adp.base.i bID = new o(this);
    private final dh bIE = new p(this);
    private int bIF = 0;
    private final com.baidu.tbadk.widget.richText.s atd = new q(this);
    boolean bIG = false;
    com.baidu.tieba.tbadkCore.c.j bIH = null;
    private final com.baidu.tbadk.core.dialog.h bII = new r(this);
    private final View.OnLongClickListener aey = new s(this);
    private final com.baidu.tbadk.core.view.y aJH = new t(this);

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IO() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void IP() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.y.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            IQ();
        } else if (this.aHD.anv()) {
            IO();
        } else {
            this.aHD.eP(false);
            if (this.bIl.Je() != null) {
                this.bIl.Je().setLocationViewVisibility(0);
                this.bIl.Je().setLocationInfoViewState(1);
            }
            this.aHD.ant();
        }
    }

    private void IQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bx(com.baidu.tieba.y.location_app_permission_prompt).a(com.baidu.tieba.y.isopen, new u(this)).b(com.baidu.tieba.y.cancel, new v(this)).b(getPageContext());
        aVar.re();
    }

    public void IR() {
        if (this.bIl.Je() != null) {
            if (this.aHD.anx()) {
                this.bIl.Je().setLocationViewVisibility(0);
                if (this.aHD.anv()) {
                    this.aHP.a(com.baidu.tieba.tbadkCore.location.d.anq().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.n.isNetOk()) {
                    this.bIl.Je().setLocationInfoViewState(1);
                    this.aHD.ant();
                    return;
                } else {
                    this.bIl.Je().setLocationInfoViewState(0);
                    return;
                }
            }
            this.bIl.Je().setLocationViewVisibility(8);
        }
    }

    private void Zr() {
        this.bIl.abm();
        this.bIl.aaL();
    }

    private void Zs() {
        this.bIl.abn();
        this.bIl.aaN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zt() {
        com.baidu.tieba.pb.a.b pbData;
        com.baidu.tbadk.core.data.w Zb;
        if (!this.aHE) {
            if (!com.baidu.adp.lib.util.n.isNetOk()) {
                showToast(com.baidu.tieba.y.no_network_guide);
            } else if (this.isPraiseToServer) {
                this.aHE = true;
                if (this.bIg != null && (pbData = this.bIg.getPbData()) != null && (Zb = pbData.Zb()) != null) {
                    int isLike = Zb.getPraise() == null ? 0 : Zb.getPraise().getIsLike();
                    if (this.aHT != null) {
                        this.aHT.a(Zb.qM(), Zb.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(int i) {
        com.baidu.tbadk.core.data.w Zb;
        String sb;
        String p;
        if (this.bIg != null && this.bIg.getPbData() != null && (Zb = this.bIg.getPbData().Zb()) != null) {
            if (i == 1) {
                PraiseData praise = Zb.getPraise();
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
                        Zb.setPraise(praiseData);
                    } else {
                        Zb.getPraise().getUser().add(0, metaData);
                        Zb.getPraise().setNum(Zb.getPraise().getNum() + 1);
                        Zb.getPraise().setIsLike(i);
                    }
                }
                if (Zb.getPraise() != null) {
                    if (Zb.getPraise().getNum() < 1) {
                        p = getResources().getString(com.baidu.tieba.y.frs_item_praise_text);
                    } else {
                        p = com.baidu.tbadk.core.util.bd.p(Zb.getPraise().getNum());
                    }
                    this.bIl.z(p, true);
                }
            } else if (Zb.getPraise() != null) {
                Zb.getPraise().setIsLike(i);
                Zb.getPraise().setNum(Zb.getPraise().getNum() - 1);
                ArrayList<MetaData> user = Zb.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            Zb.getPraise().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (Zb.getPraise().getNum() < 1) {
                    sb = getResources().getString(com.baidu.tieba.y.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(Zb.getPraise().getNum())).toString();
                }
                this.bIl.z(sb, false);
            }
            if (this.bIg.aab()) {
                this.bIl.aaR().notifyDataSetChanged();
            } else {
                this.bIl.f(this.bIg.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bIg.saveToBundle(bundle);
        if (this.bIg.aae()) {
            this.bIj.saveToBundle(bundle);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aHI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.aCO = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aCO = System.currentTimeMillis();
        }
        this.bHX = 0;
        initUI();
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initData(bundle);
        addGlobalLayoutListener();
        this.createTime = System.currentTimeMillis() - this.aCO;
        registerListener(this.aPK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.bIl != null) {
            if (this.bIl.Je() != null) {
                this.bIl.Je().alM();
            }
            if (this.bIl.aaM() != null && this.bIl.aaM().Je() != null) {
                this.bIl.aaM().Je().alM();
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

    public br Zu() {
        return this.bIg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.bHS = true;
        super.onPause();
        BdListView listView = getListView();
        this.bHX = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.bHX == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
        if (this.bIl != null) {
            this.bIl.onPause();
        }
        if (!this.bIg.aae()) {
            WriteData IS = this.aHK.IS();
            if (IS == null) {
                IS = new WriteData(1);
                IS.setThreadId(this.bIg.aaa());
                IS.setWriteImagesInfo(this.writeImagesInfo);
            }
            IS.setContent(this.bIl.Jl());
            if (this.bIc != null && this.bIc.getIsBaobao()) {
                IS.setBaobaoContent(this.bIc.getBaobaoContent());
                IS.setBaobaoImagesInfo(this.baobaoImagesInfo);
                IS.setIsBaobao(true);
            }
            com.baidu.tieba.tbadkCore.ao.b(this.bIg.aaa(), IS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        this.bHS = false;
        super.onResume();
        if (this.bHX == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView aaE = this.bIl.aaE();
        if (aaE != null && aaE.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            aaE.am(false);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
        if (this.bIl.Je() != null) {
            this.bIl.Je().refresh();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ap
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!com.baidu.tbadk.core.util.bd.isEmpty(writeData.getContent()) && com.baidu.tbadk.core.util.bd.isEmpty(this.bIl.Jl())) {
                this.mPostContent = writeData.getContent();
                this.bIl.fJ(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                this.bIl.a(this.writeImagesInfo, true);
            }
            if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.bIc.setIsBaobao(writeData.getIsBaobao());
                this.bIc.setBaobaoContent(writeData.getBaobaoContent());
                this.bIc.setBaobaoImagesInfo(this.baobaoImagesInfo);
                this.bIl.setBaobaoUris(this.baobaoImagesInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bIl.Je() != null && this.bIl.Je().getVisibility() != 0) {
            Zw();
            this.bIl.aaH();
        }
        if (!this.bIl.abg()) {
            this.bIl.abi();
        }
        this.bIl.bLc.Wy();
        if (this.bIg != null && this.bIg.getPbData() != null && this.bIg.getPbData().Za() != null && this.bIg.getPbData().Zb() != null) {
            com.baidu.tbadk.distribute.a.yk().a(getPageContext().getPageActivity(), "pb", this.bIg.getPbData().Za().getId(), com.baidu.adp.lib.g.c.a(this.bIg.getPbData().Zb().getId(), 0L));
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (!this.bId) {
            this.bId = true;
            this.bIl.abK();
        }
        this.bIg.cancelLoadData();
        this.bIg.destory();
        this.aHK.cancelLoadData();
        this.bIi.cancelLoadData();
        this.aHD.cancelLoadData();
        this.bIj.cancelLoadData();
        this.bIj.destory();
        this.bIk.cancelLoadData();
        this.bIl.onDestroy();
        if (this.bIe != null) {
            this.bIe.onDestroy();
        }
        super.onDestroy();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
    }

    public void Zv() {
        if (this.bIl.Je() != null) {
            this.bIl.Je().setContent(this.mPostContent == null ? "" : this.mPostContent);
            if (this.bIb != null) {
                this.bIl.Je().alW();
            }
            this.bIl.a(this.writeImagesInfo, true);
            this.bIl.setBaobaoUris(this.baobaoImagesInfo);
            if (!StringUtils.isNull(this.mPostContent)) {
                this.bIl.Je().Cf();
                this.bIl.Je().amc();
                this.bIl.dS(false);
            } else if (this.writeImagesInfo != null && this.writeImagesInfo.size() >= 1) {
                this.bIl.Je().cmP.hideAll();
                this.bIl.Je().setVisibility(0);
                this.bIl.Je().amc();
                this.bIl.Je().ir(23);
            } else if (this.bIb != null) {
                this.bIl.Je().cmP.hideAll();
                this.bIl.Je().setVisibility(0);
                this.bIl.Je().amc();
                this.bIl.Je().ir(5);
            } else if (this.baobaoImagesInfo != null && this.baobaoImagesInfo.size() >= 1) {
                this.bIl.Je().cmP.hideAll();
                this.bIl.Je().setVisibility(0);
                this.bIl.Je().amc();
                this.bIl.Je().ir(50);
            } else {
                this.bIl.Je().Cf();
                this.bIl.dS(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zw() {
        if (this.bIl.Je() != null) {
            this.mPostContent = this.bIl.Je().getContent();
            this.bIb = this.bIl.getAudioData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bIl.onChangeSkinType(i);
        if (this.bIp != null) {
            this.bIp.onChangeSkinType(this, i, com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.bg_collect));
        }
        if (this.bIl.aaE() != null) {
            this.bIl.aaE().onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zx() {
        this.bIq = new ci(this, this.aLK);
        this.bIp = new MorePopupWindow(getPageContext().getPageActivity(), this.bIq.getView(), getResources().getDrawable(com.baidu.tieba.u.bg_collect), null);
        this.bIp.setTouchInterceptor(new w(this));
        this.bIp.onChangeSkinType(this, TbadkCoreApplication.m411getInst().getSkinType(), com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.bg_collect));
    }

    private void initUI() {
        this.bIl = new cj(this, this.aLK, this.bIs);
        this.bIl.setOnActionListener(new y(this));
        this.bIl.setOnScrollListener(this.HK);
        this.bIl.a(this.bIv);
        this.bIl.d(this.bIw);
        this.bIl.c(this.bIB);
        this.bIl.a(this.bIC);
        this.bIl.b(this.bhr);
        this.bIl.a(this.ayF);
        this.bIl.dH(com.baidu.tbadk.core.n.px().pB());
        this.bIl.dI(com.baidu.tbadk.core.n.px().pz());
        this.bIl.setOnImageClickListener(this.atd);
        this.bIl.a(this.aey);
        this.bIl.a(this.bIE);
        this.bIl.f(this.aJH);
        this.bIl.a(this.bIA);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.bIl != null) {
            if (z && !this.bGe) {
                if (this.aIO) {
                    this.aIO = false;
                    showLoadingView(this.bIl.getView(), true);
                    return;
                }
                return;
            }
            hideLoadingView(this.bIl.getView());
        }
    }

    private void Zy() {
        if (this.bHZ == null) {
            this.bHZ = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
            this.bHZ.a(new String[]{getPageContext().getString(com.baidu.tieba.y.call_phone), getPageContext().getString(com.baidu.tieba.y.sms_phone), getPageContext().getString(com.baidu.tieba.y.search_in_baidu)}, new z(this)).bz(com.baidu.tbadk.core.dialog.g.RB).bA(17).d(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        this.bIg = new br(this);
        this.bIg.a(this.bIt);
        this.bIh = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.bIh != null) {
            this.bIh.a(this.bIu);
        }
        this.aHK = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aHK.a(this.bIy);
        this.bIi = new com.baidu.tieba.pb.c.a(this);
        this.bIi.setLoadDataCallBack(this.bID);
        this.bIj = new com.baidu.tieba.pb.pb.sub.e(this);
        this.bIj.a(this.bIx);
        this.bIk = new com.baidu.tieba.tbadkCore.h.a(this);
        this.bIk.setLoadDataCallBack(this.bIz);
        this.aHD = new com.baidu.tieba.tbadkCore.location.e(this);
        this.aHD.a(this.aHP);
        this.aHD.a(this.aHQ);
        if (bundle != null) {
            this.bIg.initWithBundle(bundle);
        } else {
            this.bIg.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, -1) == 18003) {
            this.bIg.dN(true);
        }
        ce.aaw().y(this.bIg.ZY(), this.bIg.getIsFromMark());
        if (!this.bIg.aae()) {
            this.bIl.aaX();
            this.bIg.AZ();
        } else {
            if (bundle != null) {
                this.bIj.initWithBundle(bundle);
            } else {
                this.bIj.initWithIntent(getIntent());
            }
            this.bIr = this.bIj.Yp();
            String stType = this.bIj.getStType();
            if (stType != null && (("mention".equals(this.bIj.getStType()) || stType.equals("person_post_reply")) && this.bIr != null)) {
                this.bIl.abl();
            } else {
                this.bIl.abd();
            }
            this.bIj.ack();
        }
        this.bIl.a(new aa(this));
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aHI = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!this.bIg.aae()) {
            com.baidu.tieba.tbadkCore.ao.a(this.bIg.aaa(), this);
        }
        this.aHT.setUniqueId(getUniqueId());
        this.aHT.registerListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dE(boolean z) {
        if (this.bIg == null || this.bIg.getPbData() == null) {
            return false;
        }
        return ((this.bIg.getPbData().Ze() != 0) || this.bIg.getPbData().Zb() == null || this.bIg.getPbData().Zb().getAuthor() == null || TextUtils.equals(this.bIg.getPbData().Zb().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void Zz() {
        if (this.bIg != null && this.bIg.getPbData() != null && this.bIg.getPbData().Zb() != null && this.bIg.getPbData().Zb().getAuthor() != null) {
            this.bIl.bLc.c(this.bIg.aab(), this.bIh != null ? this.bIh.oQ() : false, dE(TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.bIg.getPbData().Zb().getAuthor().getUserId())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.tbadkCore.c.j jVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (jVar = (com.baidu.tieba.tbadkCore.c.j) sparseArray.get(com.baidu.tieba.v.tag_clip_board)) != null) {
            b(jVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        ZK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Boolean bool) {
        com.baidu.tieba.pb.a.b pbData;
        String str = null;
        if (this.bIg != null && (pbData = this.bIg.getPbData()) != null && pbData.Za() != null) {
            str = pbData.Za().getName();
        }
        if (com.baidu.tieba.tbadkCore.ad.b(str, bool)) {
            Zs();
        } else {
            Zr();
        }
    }

    private void a(String str, Boolean bool) {
        if (com.baidu.tieba.tbadkCore.ad.b(str, bool)) {
            Zs();
        } else {
            Zr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hH(String str) {
        if (!StringUtils.isNull(str) && this.bIg != null) {
            String aaa = this.bIg.aaa();
            String id = this.bIg.getPbData().Za().getId();
            sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(com.baidu.tieba.y.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + aaa + "&pid=" + str, true)));
        }
    }

    public void a(boolean z, int i, String str, com.baidu.tieba.pb.a.c cVar) {
        stopVoice();
        this.bIl.showToast(str);
        this.bIl.abj();
        if (!z) {
            if ((i == 4 || i == 28) && this.bIg.aae()) {
                finish();
            }
        } else if (cVar != null) {
            String Yp = this.bIj.Yp();
            ArrayList<com.baidu.tieba.tbadkCore.c.j> Zc = this.bIg.getPbData().Zc();
            int i2 = 0;
            while (true) {
                if (i2 >= Zc.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.c.j jVar = Zc.get(i2);
                if (jVar.getId() == null || !jVar.getId().equals(Yp)) {
                    i2++;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.c.j> Zl = cVar.Zl();
                    jVar.it(cVar.getTotalCount());
                    if (jVar.amM() != null) {
                        jVar.amM().clear();
                        jVar.amM().addAll(Zl);
                    }
                }
            }
            String stType = this.bIj.getStType();
            if (stType != null && (("mention".equals(this.bIj.getStType()) || stType.equals("person_post_reply")) && this.bIr != null)) {
                this.bIl.a(cVar, this.bIg.getPbData().Ze(), this.bIr, cVar.Zk() > 1, this.bIj.acf() == 1);
            } else {
                this.bIl.a(cVar, this.bIg.getPbData().Ze());
            }
            AntiData Zp = cVar.Zp();
            if (Zp != null) {
                Boolean valueOf = Boolean.valueOf(Zp.isIfvoice());
                this.bIf = Zp.getVoice_message();
                if (cVar.Zo() != null) {
                    a(cVar.Zo().getName(), valueOf);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            if (!this.bIg.aae()) {
                antiData.setBlock_forum_name(this.bIg.getPbData().Za().getName());
                antiData.setBlock_forum_id(this.bIg.getPbData().Za().getId());
                antiData.setUser_name(this.bIg.getPbData().getUserData().getUserName());
                antiData.setUser_id(this.bIg.getPbData().getUserData().getUserId());
            } else {
                antiData.setBlock_forum_name(this.bIj.ace().Zo().getName());
                antiData.setBlock_forum_id(this.bIj.ace().Zo().getId());
                antiData.setUser_name(TbadkCoreApplication.getCurrentAccountName());
                antiData.setUser_id(TbadkCoreApplication.getCurrentAccount());
            }
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.tieba.tbadkCore.writeModel.h.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            if (!this.bIg.aae()) {
                antiData.setBlock_forum_name(this.bIg.getPbData().Za().getName());
                antiData.setBlock_forum_id(this.bIg.getPbData().Za().getId());
                antiData.setUser_name(this.bIg.getPbData().getUserData().getUserName());
                antiData.setUser_id(this.bIg.getPbData().getUserData().getUserId());
            } else {
                antiData.setBlock_forum_name(this.bIj.ace().Zo().getName());
                antiData.setBlock_forum_id(this.bIj.ace().Zo().getId());
                antiData.setUser_name(TbadkCoreApplication.getCurrentAccountName());
                antiData.setUser_id(TbadkCoreApplication.getCurrentAccount());
            }
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        this.bIl.showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.h.c cVar) {
        int i = 0;
        if (cVar != null) {
            this.bIl.a(0, cVar.AM, cVar.cpS, true);
            if (cVar.AM) {
                if (cVar.cpQ == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.c.j> Zc = this.bIg.getPbData().Zc();
                    int size = Zc.size();
                    while (true) {
                        if (i < size) {
                            if (!cVar.mPostId.equals(Zc.get(i).getId())) {
                                i++;
                            } else {
                                Zc.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.bIl.e(this.bIg.getPbData());
                } else if (cVar.cpQ == 0) {
                    ZA();
                } else if (cVar.cpQ == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.c.j> Zc2 = this.bIg.getPbData().Zc();
                    int size2 = Zc2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < Zc2.get(i2).amM().size()) {
                                if (!cVar.mPostId.equals(Zc2.get(i2).amM().get(i3).getId())) {
                                    i3++;
                                } else {
                                    Zc2.get(i2).amM().remove(i3);
                                    Zc2.get(i2).amN();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData Zg = this.bIg.getPbData().Zg();
                        com.baidu.tieba.tbadkCore.c.j jVar = Zc2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.c.j> amO = jVar.amO();
                        int size3 = amO.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!cVar.mPostId.equals(Zc2.get(i2).amO().get(i4).getId())) {
                                    i4++;
                                } else {
                                    amO.remove(i4);
                                    Zg.decreaseAlreadyCount();
                                    if (jVar.amV() > amO.size()) {
                                        jVar.iv(amO.size());
                                    }
                                    if (amO.size() > 0) {
                                        com.baidu.tieba.tbadkCore.c.j jVar2 = amO.get(amO.size() - 1);
                                        Zg.setLastAdditionTime(jVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a amQ = jVar2.amQ();
                                        String str = "";
                                        if (amQ != null) {
                                            str = amQ.toString();
                                        }
                                        Zg.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a amQ2 = jVar.amQ();
                                        String str2 = "";
                                        if (amQ2 != null) {
                                            str2 = amQ2.toString();
                                        }
                                        Zg.setLastAdditionContent(str2);
                                    }
                                    ZL();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.bIl.e(this.bIg.getPbData());
                    }
                    if (this.bIl.abg()) {
                        this.bIj.hR(cVar.mPostId);
                        this.bIl.a(this.bIj.ace(), this.bIg.getPbData().Ze());
                        if (!z) {
                            String Yp = this.bIj.Yp();
                            while (i < size2) {
                                if (!Yp.equals(Zc2.get(i).getId())) {
                                    i++;
                                } else {
                                    Zc2.get(i).amN();
                                    this.bIl.e(this.bIg.getPbData());
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
    public void a(com.baidu.tieba.tbadkCore.h.e eVar) {
        this.bIl.a(1, eVar.AM, eVar.cpS, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.h.g gVar) {
        this.bIl.a(this.bIk.getLoadDataMode(), gVar.AM, gVar.cpS, false);
        this.bIl.N(gVar.cpU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.tbadkCore.h.g gVar) {
        if (gVar != null) {
            this.bIl.a(this.bIk.getLoadDataMode(), gVar.AM, gVar.cpS, true);
            if (gVar.AM) {
                this.bIo = true;
                if (i == 2) {
                    this.bIg.getPbData().Zb().bu(1);
                    this.bIg.setIsGood(1);
                } else if (i == 3) {
                    this.bIg.getPbData().Zb().bu(0);
                    this.bIg.setIsGood(0);
                } else if (i == 4) {
                    this.bIg.getPbData().Zb().bt(1);
                    this.bIg.hl(1);
                } else if (i == 5) {
                    this.bIg.getPbData().Zb().bt(0);
                    this.bIg.hl(0);
                }
                this.bIl.a(this.bIg.getPbData(), this.bIg.aab(), true);
            }
        }
    }

    private void ZA() {
        if (this.bIg.aac()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.bIg.aaa());
            setResult(-1, intent);
        }
        if (ZG()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZB() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        this.bIl.abC();
        if (this.bIg != null && this.bIg.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.bIg.getPbData().Zb().getId();
            historyMessage.forumName = this.bIg.getPbData().Za().getName();
            historyMessage.threadName = this.bIg.getPbData().Zb().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.c.j> Zc = this.bIg.getPbData().Zc();
            int abp = this.bIl.abp();
            if (Zc != null && abp >= 0 && abp < Zc.size()) {
                historyMessage.postID = Zc.get(abp).getId();
            }
            historyMessage.isHostOnly = this.bIg.getHostMode();
            historyMessage.isSquence = this.bIg.aab();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.bIg != null && this.bIg.aac()) {
            Intent intent = new Intent();
            if (this.bIo) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.bIg.aaa());
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.bIg.aad());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.bIg.getIsGood());
            }
            setResult(-1, intent);
        }
        if (ZG()) {
            if (this.bIg != null && this.bIl != null && this.bIl.getListView() != null) {
                com.baidu.tieba.pb.a.b pbData = this.bIg.getPbData();
                if (pbData != null && pbData.getUserData() != null) {
                    pbData.getUserData().setBimg_url(TbadkCoreApplication.m411getInst().getDefaultBubble());
                }
                ce.aaw().a(this.bIg.getPbData(), this.bIl.getListView().onSaveInstanceState(), this.bIg.aab(), this.bIg.getHostMode());
            } else {
                ce.aaw().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.bIp != null) {
                    com.baidu.adp.lib.g.k.a(this.bIp, getPageContext().getPageActivity());
                }
                if (this.bIl.dV(this.bIg.aae())) {
                    stopVoice();
                    return true;
                }
                finish();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hj(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.y.login_to_use), true, i)));
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
                    fG(null);
                    return;
                case 11009:
                    ZE();
                    return;
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(getPageContext().getPageActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(getPageContext().getPageActivity(), 12005, true)));
                    return;
                case 11027:
                    fG(this.bIl.abr());
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            J(intent);
                            return;
                        } else {
                            S(intent);
                            return;
                        }
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        ZD();
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            this.bIl.abo();
                            this.aHK.eQ(false);
                            return;
                        }
                        this.bIi.hG(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    ZD();
                    ArrayList<String> V = com.baidu.tieba.tbadkCore.util.i.V(intent);
                    if (V != null) {
                        this.bIl.v(V);
                        return;
                    }
                    return;
                case 12005:
                    ZD();
                    new Handler().postDelayed(new ab(this), 200L);
                    ArrayList<String> V2 = com.baidu.tieba.tbadkCore.util.i.V(intent);
                    if (V2 != null) {
                        this.bIl.O(V2);
                        return;
                    }
                    return;
                case 12006:
                    WriteData IS = this.aHK.IS();
                    if (IS != null) {
                        IS.deleteUploadedTempImages();
                    }
                    this.bIc.setIsBaobao(false);
                    this.bIc.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.aHK.c((WriteData) null);
                    this.aHK.eQ(false);
                    this.bIl.bK(true);
                    if (this.bIl.abg()) {
                        this.bIj.aci();
                    } else {
                        if (this.bIg != null && this.bIg.aah()) {
                            this.bIl.aaX();
                        }
                        if (this.bIg != null && this.bIg.aaa() != null && !this.bIg.aae()) {
                            com.baidu.tieba.tbadkCore.ao.b(this.bIg.aaa(), (WriteData) null);
                        }
                    }
                    this.bIl.a(this.writeImagesInfo, true);
                    return;
                case 12009:
                case 12010:
                    ZD();
                    if (i == 12010) {
                        L(intent);
                        return;
                    }
                    return;
                case 12012:
                    K(intent);
                    return;
                case 12013:
                    T(intent);
                    return;
                case 13008:
                    ce.aaw().reset();
                    this.mHandler.postDelayed(new ac(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.bIg != null) {
                        a(ZC(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getIntExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0));
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
                IT();
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
                ZD();
                return;
        }
    }

    private ShareFromPBMsgData ZC() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] ay = this.bIg.getPbData().ay(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.c.j aaG = this.bIl.aaG();
        String str = "";
        if (aaG != null) {
            str = aaG.getId();
            String aF = aaG.aF(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.m.isEmpty(aF)) {
                ay[1] = aF;
            }
        }
        String qM = this.bIg.getPbData().Zb().qM();
        if (qM != null && qM.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(ay[1]);
        shareFromPBMsgData.setImageUrl(ay[0]);
        shareFromPBMsgData.setForumName(this.bIg.getPbData().Za().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.bIg.getPbData().Zb().getId());
        shareFromPBMsgData.setTitle(this.bIg.getPbData().Zb().getTitle());
        return shareFromPBMsgData;
    }

    private void R(Intent intent) {
        a(ZC(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.bIg != null && this.bIg.getPbData() != null && this.bIg.getPbData().Zb() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bZ(this.bIg.getPbData().Zb().getTitle());
            dj djVar = new dj(getPageContext().getPageActivity());
            djVar.setData(shareFromPBMsgData);
            aVar.j(djVar);
            aVar.a(com.baidu.tieba.y.share, new ad(this, djVar, j, str, str2, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.y.alert_no_button, new ae(this, djVar));
            aVar.ad(false);
            aVar.b(getPageContext()).re();
            if (!com.baidu.adp.lib.util.m.isEmpty(shareFromPBMsgData.getImageUrl())) {
                djVar.v(shareFromPBMsgData.getImageUrl(), this.bIg.getPbData().Zf() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, int i2) {
        if (this.bIg != null && this.bIg.getPbData() != null && this.bIg.getPbData().Zb() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bZ(this.bIg.getPbData().Zb().getTitle());
            dj djVar = new dj(getPageContext().getPageActivity());
            djVar.setData(shareFromPBMsgData);
            aVar.j(djVar);
            aVar.a(com.baidu.tieba.y.share, new af(this, djVar, i, str, i2, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.y.alert_no_button, new ag(this, djVar));
            aVar.ad(false);
            aVar.b(getPageContext()).re();
            if (!com.baidu.adp.lib.util.m.isEmpty(shareFromPBMsgData.getImageUrl())) {
                djVar.v(shareFromPBMsgData.getImageUrl(), this.bIg.getPbData().Zf() == 1);
            }
        }
    }

    private void S(Intent intent) {
        a(intent, true);
    }

    private void J(Intent intent) {
        int size;
        int size2;
        L(intent);
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() - 1 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size2 = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    private void L(Intent intent) {
        this.aHI = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aHI;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cf = com.baidu.tbadk.core.util.c.cf(str);
                if (cf != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.M(getPageContext().getPageActivity())), com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.N(getPageContext().getPageActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.c.h(b, cf);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.o.a(TbConfig.LOCAL_CAMERA_DIR, this.aHI, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            this.bIl.a(this.writeImagesInfo, true);
        }
        if (this.bIl.Je() != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            this.bIl.Je().ir(23);
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
                    this.bIl.a(this.writeImagesInfo, z);
                }
            }
            if (this.bIl.Je() != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                this.bIl.Je().ir(23);
            }
        }
    }

    private void T(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            if (stringExtra != null && stringExtra2 != null) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(stringExtra);
                this.baobaoImagesInfo.clear();
                this.baobaoImagesInfo.addChooseFile(imageFileInfo);
                this.bIl.setBaobaoUris(this.baobaoImagesInfo);
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    if (this.bIl.Je() != null) {
                        this.bIl.Je().ir(50);
                    }
                    this.bIc.setIsBaobao(true);
                    this.bIc.setBaobaoContent(stringExtra2);
                    this.bIc.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.bIc.setIsBaobao(false);
                this.bIc.setBaobaoContent("");
                this.bIc.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void IT() {
        new ah(this).execute(new Void[0]);
    }

    private void ZD() {
        if (this.bIn) {
            this.bIn = false;
            new Handler().postDelayed(new aj(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZE() {
        MarkData hr;
        if (this.bIh != null && (hr = this.bIg.hr(this.bIl.abp())) != null) {
            this.bIl.aaX();
            this.bIh.a(hr);
            if (!this.bIh.oQ()) {
                this.bIh.oS();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.bIh.oR();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fG(String str) {
        VoiceData.VoiceModel aaO;
        if (this.aHK.IS() == null) {
            if (!this.bIg.aae()) {
                this.aHK.c(this.bIg.hL(str));
            } else {
                this.aHK.c(this.bIj.IS());
            }
        }
        if (this.aHK.IS() != null) {
            if (!this.bIg.aae()) {
                this.aHK.IS().setWriteImagesInfo(this.writeImagesInfo);
                this.aHK.eQ(this.writeImagesInfo.size() > 0);
                if (this.bIc.getIsBaobao()) {
                    this.aHK.IS().setIsBaobao(true);
                    this.aHK.IS().setBaobaoContent(this.bIc.getBaobaoContent());
                    this.aHK.IS().setBaobaoImagesInfo(this.baobaoImagesInfo);
                } else {
                    this.aHK.IS().setIsBaobao(false);
                }
            }
            if (this.bIl.Je() != null) {
                this.aHK.IS().setHasLocationData(this.bIl.Je().getLocationInfoViewState() == 2);
            }
            if (str == null) {
                this.aHK.IS().setContent(this.bIl.Jl());
                aaO = this.bIl.getAudioData();
                this.bIl.Jn();
            } else {
                this.aHK.IS().setContent(this.bIl.abq());
                this.aHK.IS().setRepostId(this.bIl.abs());
                aaO = this.bIl.aaO();
                this.bIl.aaP();
            }
            if (aaO != null) {
                if (aaO.getId() != null) {
                    this.aHK.IS().setVoice(aaO.getId());
                    this.aHK.IS().setVoiceDuringTime(aaO.duration);
                } else {
                    this.aHK.IS().setVoice(null);
                    this.aHK.IS().setVoiceDuringTime(-1);
                }
            } else {
                this.aHK.IS().setVoice(null);
                this.aHK.IS().setVoiceDuringTime(-1);
            }
            if (!this.aHK.anR()) {
                showToast(com.baidu.tieba.y.write_img_limit);
            } else if (this.aHK.anP()) {
                this.bIl.Jk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZF() {
        com.baidu.tieba.pb.a.b pbData = this.bIg.getPbData();
        this.bIg.dM(true);
        pbData.hF(this.bIh.oP());
        this.bIl.e(pbData);
    }

    private boolean ZG() {
        if (this.bIg == null) {
            return true;
        }
        if (this.bIg.oQ()) {
            MarkData aan = this.bIg.aan();
            if (aan == null || !this.bIg.getIsFromMark()) {
                return true;
            }
            MarkData hr = this.bIg.hr(this.bIl.abp());
            if (hr == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aan);
                setResult(-1, intent);
                return true;
            } else if (hr.getPostId() == null || hr.getPostId().equals(aan.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aan);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.ca(String.format(getPageContext().getString(com.baidu.tieba.y.alert_update_mark), Integer.valueOf(hr.getFloor())));
                aVar.a(com.baidu.tieba.y.alert_yes_btn, new ak(this, hr, aan));
                aVar.b(com.baidu.tieba.y.alert_no_button, new al(this, aan));
                aVar.b(getPageContext());
                aVar.re();
                return false;
            }
        } else if (this.bIg.getPbData() == null || this.bIg.getPbData().Zc() == null || this.bIg.getPbData().Zc().size() <= 0 || !this.bIg.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.ao
    public BdListView getListView() {
        if (this.bIl == null) {
            return null;
        }
        return this.bIl.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int getRichTextViewId() {
        if (this.bIl == null) {
            return 0;
        }
        return this.bIl.abv();
    }

    @Override // com.baidu.tbadk.core.view.ao
    public int tS() {
        if (this.bIl == null) {
            return 0;
        }
        return this.bIl.Ko();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<ImageView> getImageViewPool() {
        if (this.asK == null) {
            this.asK = new com.baidu.adp.lib.e.b<>(new am(this), 8, 0);
        }
        return this.asK;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<TextView> getTextViewPool() {
        if (this.asL == null) {
            this.asL = TbRichTextView.h(getPageContext().getPageActivity(), 8);
        }
        return this.asL;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<GifView> getGifViewPool() {
        if (this.asO == null) {
            this.asO = new com.baidu.adp.lib.e.b<>(new an(this), 20, 0);
        }
        return this.asO;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<View> getVoiceViewPool() {
        if (this.asM == null) {
            this.asM = new com.baidu.adp.lib.e.b<>(new ao(this), 8, 0);
        }
        return this.asM;
    }

    @Override // com.baidu.tbadk.core.view.ao
    public com.baidu.adp.lib.e.b<TbImageView> tT() {
        if (this.Zi == null) {
            this.Zi = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.Zi;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    public boolean hI(String str) {
        Map<String, String> cQ;
        if (!TextUtils.isEmpty(str) && (cQ = com.baidu.tbadk.core.util.bk.cQ(com.baidu.tbadk.core.util.bk.cR(str))) != null) {
            String str2 = cQ.get(ImageViewerConfig.URL);
            if (!TextUtils.isEmpty(str2)) {
                return hI(com.baidu.adp.lib.util.m.aN(str2));
            }
            String str3 = cQ.get(bHY);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onLinkClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (hJ(str) || z) {
                boolean u = com.baidu.adp.lib.util.n.u(context, "com.qiyi.video");
                hK(str);
                if (u) {
                    ZH();
                } else {
                    ZI();
                }
            } else if (hI(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                com.baidu.tbadk.core.util.bk.tl().b(getPageContext(), new String[]{str});
            }
        }
    }

    private boolean hJ(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }

    private void hK(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(";")) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.bHV = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.bHW = split[i].substring(indexOf2 + 1, split[i].length());
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
                        this.bHU = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void ZH() {
        if (TextUtils.isEmpty(this.bHV) || TextUtils.isEmpty(this.bHW) || TextUtils.isEmpty(this.mPackageName)) {
            if (!TextUtils.isEmpty(this.bHU)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.bHU);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(this.bHV));
        intent.setAction(this.bHW);
        intent.setPackage(this.mPackageName);
        if (intent.resolveActivity(getPageContext().getPageActivity().getPackageManager()) != null) {
            if (!com.baidu.adp.lib.g.j.e(getPageContext().getPageActivity(), intent) && !TextUtils.isEmpty(this.bHU)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.bHU);
            }
        } else if (!TextUtils.isEmpty(this.bHU)) {
            com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.bHU);
        }
    }

    private void ZI() {
        if (!com.baidu.adp.lib.util.k.iI()) {
            if (!TextUtils.isEmpty(this.bHU)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.bHU);
                return;
            }
            return;
        }
        if (this.bHT == null) {
            this.bHT = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.bHT.bx(com.baidu.tieba.y.download_iqiyi_app_dialog);
            this.bHT.a(com.baidu.tieba.y.install_app, new ap(this));
            this.bHT.b(com.baidu.tieba.y.webpage_play, new aq(this));
            this.bHT.ad(false);
        }
        this.bHT.b(getPageContext()).re();
    }

    private com.baidu.tbadk.core.dialog.a ZJ() {
        if (this.bIa == null) {
            this.bIa = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.bIa.bZ(getPageContext().getString(com.baidu.tieba.y.download_baidu_video_dialog));
            this.bIa.a(getPageContext().getString(com.baidu.tieba.y.install), new ar(this));
            this.bIa.b(getPageContext().getString(com.baidu.tieba.y.cancel), new as(this));
            this.bIa.ac(true);
            this.bIa.b(getPageContext());
            this.bIa.ad(false);
        }
        this.bIa.re();
        return this.bIa;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onVideoClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (hJ(str) || z) {
                boolean u = com.baidu.adp.lib.util.n.u(context, "com.qiyi.video");
                hK(str);
                if (u) {
                    ZH();
                    return;
                } else {
                    ZI();
                    return;
                }
            }
            com.baidu.tbadk.browser.f.x(getPageContext().getPageActivity(), str);
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
            ZJ();
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
        com.baidu.tbadk.widget.richText.g DG;
        if (aVar == aVar2) {
            this.bIG = true;
        }
        if (aVar != null) {
            int size = aVar.DB().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.DB().get(i6) != null && aVar.DB().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.DB().get(i6).DG().getWidth();
                    int height = aVar.DB().get(i6).DG().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.DB().get(i6).DG().DN()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.DB().get(i6);
                        String b = b(cVar);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && cVar != null && (DG = cVar.DG()) != null) {
                            String DO = DG.DO();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = DO;
                            int i8 = this.mIsFromCDN ? 17 : 18;
                            imageUrlData.urlType = i8;
                            imageUrlData.urlType = i8;
                            if (hashMap != null) {
                                hashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.bIG) {
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
    public void b(com.baidu.tieba.tbadkCore.c.j jVar) {
        if (jVar != null) {
            boolean z = false;
            if (jVar.getId() != null && jVar.getId().equals(this.bIg.qI())) {
                z = true;
            }
            MarkData d = this.bIg.d(jVar);
            if (d != null && hj(11009)) {
                this.bIl.aaX();
                if (this.bIh != null) {
                    this.bIh.a(d);
                    if (!z) {
                        this.bIh.oS();
                    } else {
                        this.bIh.oR();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a O(String str, int i) {
        if (this.bIg == null || this.bIg.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.a.b pbData = this.bIg.getPbData();
        com.baidu.tbadk.widget.richText.a a = a(pbData.Zc(), str, i);
        if (a == null) {
            ArrayList<com.baidu.tieba.tbadkCore.c.j> Zc = pbData.Zc();
            int size = Zc.size();
            for (int i2 = 0; i2 < size; i2++) {
                a = a(Zc.get(i2).amO(), str, i);
                if (a != null) {
                    return a;
                }
            }
            return a;
        }
        return a;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.c.j> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> DB;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a amQ = arrayList.get(i2).amQ();
            if (amQ != null && (DB = amQ.DB()) != null) {
                int size = DB.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (DB.get(i4) != null && DB.get(i4).getType() == 8) {
                        i3++;
                        if (DB.get(i4).DG().DO().equals(str)) {
                            int width = DB.get(i4).DG().getWidth();
                            int height = DB.get(i4).DG().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.bIF = i4;
                            return amQ;
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
        com.baidu.tbadk.widget.richText.g DG = cVar.DG();
        if (DG != null) {
            if (!StringUtils.isNull(DG.DM())) {
                return DG.DM();
            }
            if (DG.getHeight() * DG.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (DG.getHeight() * DG.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (DG.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * DG.getHeight())));
            } else {
                float width = DG.getWidth() / DG.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.bd.aM(DG.getSrc()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onPhoneClicked(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mPhoneNumber = str;
            if (this.bHZ == null) {
                Zy();
            }
            com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "pb_show_phonedialog");
            if (str2.equals("2")) {
                this.bHZ.bC(1).setVisibility(8);
            } else {
                this.bHZ.bC(1).setVisibility(0);
            }
            this.bHZ.rg();
        }
    }

    @Override // com.baidu.tbadk.core.voice.j
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZK() {
        hideNetRefreshView(this.bIl.getView());
        showLoadingView(this.bIl.getView(), true);
        if (this.bIg.AZ()) {
            this.bIl.aaX();
        }
    }

    @Override // com.baidu.tbadk.core.voice.j
    public com.baidu.tbadk.core.voice.i getRealView(VoiceData.VoiceModel voiceModel) {
        View abF;
        View findViewWithTag;
        if (!this.bIl.abg() || (abF = this.bIl.abF()) == null || (findViewWithTag = abF.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (com.baidu.tbadk.core.voice.i) findViewWithTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVoice() {
        if (this.mVoiceManager != null) {
            this.mVoiceManager.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showShareDialog() {
        if (this.bIg.aam()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.a.b pbData = this.bIg.getPbData();
            String name = pbData.Za().getName();
            String title = pbData.Zb().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.bIg.aaa() + "?share=9105&fr=share";
            String[] ay = pbData.ay(getPageContext().getPageActivity());
            String str2 = ay[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String format = MessageFormat.format(getResources().getString(com.baidu.tieba.y.share_content_tpl), title, name, ay[1]);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.adu = str;
            if (parse != null) {
                fVar.adv = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true, oX());
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(com.baidu.tieba.y.share_tieba_qunzu, com.baidu.tieba.u.icon_unite_share_qunzu, new au(this));
            shareDialogConfig.addOutsideTextView(com.baidu.tieba.y.forum_friend, com.baidu.tieba.u.icon_unite_share_baf, new av(this));
            shareDialogConfig.setCopyLinkListener(new aw(this, fVar));
            sendMessage(new CustomMessage(2001283, shareDialogConfig));
        }
    }

    private SparseArray<String> oX() {
        if (this.aQA == null) {
            this.aQA = new SparseArray<>(7);
            this.aQA.put(2, "pb_wx_timeline");
            this.aQA.put(3, "pb_wx_friend");
            this.aQA.put(4, "pb_qq_zone");
            this.aQA.put(5, "pb_tencent_weibo");
            this.aQA.put(6, "pb_sina_weibo");
            this.aQA.put(7, "pb_renren");
        }
        return this.aQA;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool() {
        if (this.asN == null) {
            this.asN = new com.baidu.adp.lib.e.b<>(new ax(this), 15, 0);
        }
        return this.asN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZL() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.pb.a.b pbData = this.bIg.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.qe().isIfAddition();
            AdditionData Zg = pbData.Zg();
            boolean z3 = Zg == null ? false : isIfAddition;
            if (z3) {
                z = Zg.getAlreadyCount() != Zg.getTotalCount();
                if (!TextUtils.isEmpty(Zg.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.pb.main.b.a aVar = this.bIl.bLc;
            if (!z3 || !z) {
                z2 = false;
            }
            aVar.dX(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bIl.aaK() == view) {
            com.baidu.tbadk.core.data.w Zb = this.bIg.getPbData().Zb();
            if (view != null) {
                boolean z = Zb.getPraise() == null || Zb.getPraise().getIsLike() == 0;
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
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), com.baidu.tieba.p.praise_animation_scale2));
            new Handler().postDelayed(new ay(this), 200L);
        }
    }

    private void praiseAnimUp(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), com.baidu.tieba.p.praise_animation_scale3));
            new Handler().postDelayed(new az(this), 600L);
        }
    }

    private void praiseAnimDown(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), com.baidu.tieba.p.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void Jz() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.n.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.y.login_to_use), true, 11017)));
        } else if (!this.bIk.anB()) {
            this.bIl.aaT();
            if (aVar.rf() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.rf();
                String str = (String) sparseArray.get(com.baidu.tieba.v.tag_del_post_id);
                int intValue = ((Integer) sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue();
                int intValue2 = ((Integer) sparseArray.get(com.baidu.tieba.v.tag_del_post_type)).intValue();
                if (this.bIg.aae()) {
                    if (this.bIj != null && this.bIj.ace() != null && this.bIj.ace().Zo() != null && this.bIj.ace().Zq() != null) {
                        this.bIk.a(this.bIj.ace().Zo().getId(), this.bIj.ace().Zo().getName(), this.bIj.ace().Zq().getId(), str, intValue2, intValue, booleanValue);
                        return;
                    }
                    return;
                }
                this.bIk.a(this.bIg.getPbData().Za().getId(), this.bIg.getPbData().Za().getName(), this.bIg.getPbData().Zb().getId(), str, intValue2, intValue, booleanValue);
            }
        }
    }
}
