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
    private static String bHL = "tbgametype";
    private com.baidu.adp.lib.e.b<TbImageView> Zg;
    private String aHA;
    private com.baidu.tieba.tbadkCore.location.e aHv;
    private boolean akz;
    private com.baidu.adp.lib.e.b<ImageView> asC;
    private com.baidu.adp.lib.e.b<TextView> asD;
    private com.baidu.adp.lib.e.b<View> asE;
    private com.baidu.adp.lib.e.b<LinearLayout> asF;
    private com.baidu.adp.lib.e.b<GifView> asG;
    private com.baidu.tbadk.core.dialog.a bHN;
    private VoiceData.VoiceModel bHO;
    private String bIe;
    private boolean mIsFromCDN;
    private String mPhoneNumber;
    private String mPostContent;
    private VoiceManager mVoiceManager;
    private boolean bHF = false;
    private boolean aIG = true;
    private boolean bFR = false;
    private com.baidu.tbadk.core.dialog.a bHG = null;
    private String bHH = null;
    private String mDownloadUrl = null;
    private String bHI = null;
    private String bHJ = null;
    private String mPackageName = null;
    private int bHK = 0;
    private com.baidu.tbadk.core.dialog.e bHM = null;
    SparseArray<String> aQj = null;
    private long aCG = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private WriteData bHP = new WriteData();
    private long apt = 0;
    private long createTime = 0;
    private long apu = 0;
    private boolean bHQ = false;
    private com.baidu.tbadk.performanceLog.h bHR = null;
    public long aJi = System.currentTimeMillis();
    private String bHS = null;
    private final Handler mHandler = new Handler(new b(this));
    private bq bHT = null;
    private com.baidu.tbadk.baseEditMark.a bHU = null;
    private com.baidu.tieba.tbadkCore.writeModel.a aHC = null;
    private com.baidu.tieba.pb.c.a bHV = null;
    private com.baidu.tieba.pb.pb.sub.e bHW = null;
    private com.baidu.tieba.tbadkCore.h.a bHX = null;
    private ci bHY = null;
    public final com.baidu.tieba.pb.pb.main.a.a bHZ = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean bIa = false;
    private boolean bIb = false;
    private MorePopupWindow bIc = null;
    private ch bId = null;
    private boolean aII = false;
    private CustomMessageListener aPt = new m(this, 2001276);
    private com.baidu.tieba.tbadkCore.location.j aHH = new x(this);
    private com.baidu.tieba.tbadkCore.location.k aHI = new ai(this);
    private boolean aHw = false;
    private com.baidu.tieba.tbadkCore.ar aHL = new com.baidu.tieba.tbadkCore.ar(getPageContext(), new at(this));
    private long praiseStopTime = 0;
    private boolean isPraiseToServer = true;
    private com.baidu.tieba.pb.b.d bIf = new com.baidu.tieba.pb.b.d(new az(this));
    public final View.OnClickListener aLA = new ba(this);
    private final bu bIg = new bc(this);
    private final com.baidu.tbadk.baseEditMark.b bIh = new bd(this);
    private final AbsListView.OnScrollListener HI = new c(this);
    private final AbsListView.OnScrollListener bIi = new d(this);
    private final com.baidu.tieba.pb.pb.sub.g bIj = new e(this);
    private final com.baidu.tieba.tbadkCore.writeModel.e bIk = new f(this);
    private final com.baidu.adp.base.i bIl = new g(this);
    private final bf bIm = new h(this);
    private final com.baidu.tbadk.core.view.ae ayx = new i(this);
    private final com.baidu.adp.widget.ListView.x bIn = new j(this);
    private final com.baidu.adp.widget.ListView.aa bIo = new k(this);
    private final com.baidu.tbadk.core.dialog.h bhb = new l(this);
    private final com.baidu.adp.base.i bIp = new n(this);
    private final dg bIq = new o(this);
    private int bIr = 0;
    private final com.baidu.tbadk.widget.richText.s asV = new p(this);
    boolean bIs = false;
    com.baidu.tieba.tbadkCore.c.j bIt = null;
    private final com.baidu.tbadk.core.dialog.h bIu = new q(this);
    private final View.OnLongClickListener aeq = new r(this);
    private final com.baidu.tbadk.core.view.y aJx = new s(this);

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void II() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void IJ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.y.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            IK();
        } else if (this.aHv.ang()) {
            II();
        } else {
            this.aHv.eR(false);
            if (this.bHY.IY() != null) {
                this.bHY.IY().setLocationViewVisibility(0);
                this.bHY.IY().setLocationInfoViewState(1);
            }
            this.aHv.ane();
        }
    }

    private void IK() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bx(com.baidu.tieba.y.location_app_permission_prompt).a(com.baidu.tieba.y.isopen, new t(this)).b(com.baidu.tieba.y.cancel, new u(this)).b(getPageContext());
        aVar.re();
    }

    public void IL() {
        if (this.bHY.IY() != null) {
            if (this.aHv.ani()) {
                this.bHY.IY().setLocationViewVisibility(0);
                if (this.aHv.ang()) {
                    this.aHH.a(com.baidu.tieba.tbadkCore.location.d.anb().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.n.isNetOk()) {
                    this.bHY.IY().setLocationInfoViewState(1);
                    this.aHv.ane();
                    return;
                } else {
                    this.bHY.IY().setLocationInfoViewState(0);
                    return;
                }
            }
            this.bHY.IY().setLocationViewVisibility(8);
        }
    }

    private void Ze() {
        this.bHY.aaY();
        this.bHY.aay();
    }

    private void Zf() {
        this.bHY.aaZ();
        this.bHY.aaA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zg() {
        com.baidu.tieba.pb.a.b pbData;
        com.baidu.tbadk.core.data.w YP;
        if (!this.aHw) {
            if (!com.baidu.adp.lib.util.n.isNetOk()) {
                showToast(com.baidu.tieba.y.no_network_guide);
            } else if (this.isPraiseToServer) {
                this.aHw = true;
                if (this.bHT != null && (pbData = this.bHT.getPbData()) != null && (YP = pbData.YP()) != null) {
                    int isLike = YP.getPraise() == null ? 0 : YP.getPraise().getIsLike();
                    if (this.aHL != null) {
                        this.aHL.a(YP.qM(), YP.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(int i) {
        com.baidu.tbadk.core.data.w YP;
        String sb;
        String p;
        if (this.bHT != null && this.bHT.getPbData() != null && (YP = this.bHT.getPbData().YP()) != null) {
            if (i == 1) {
                PraiseData praise = YP.getPraise();
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
                        YP.setPraise(praiseData);
                    } else {
                        YP.getPraise().getUser().add(0, metaData);
                        YP.getPraise().setNum(YP.getPraise().getNum() + 1);
                        YP.getPraise().setIsLike(i);
                    }
                }
                if (YP.getPraise() != null) {
                    if (YP.getPraise().getNum() < 1) {
                        p = getResources().getString(com.baidu.tieba.y.frs_item_praise_text);
                    } else {
                        p = com.baidu.tbadk.core.util.bd.p(YP.getPraise().getNum());
                    }
                    this.bHY.z(p, true);
                }
            } else if (YP.getPraise() != null) {
                YP.getPraise().setIsLike(i);
                YP.getPraise().setNum(YP.getPraise().getNum() - 1);
                ArrayList<MetaData> user = YP.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            YP.getPraise().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (YP.getPraise().getNum() < 1) {
                    sb = getResources().getString(com.baidu.tieba.y.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(YP.getPraise().getNum())).toString();
                }
                this.bHY.z(sb, false);
            }
            if (this.bHT.ZO()) {
                this.bHY.aaE().notifyDataSetChanged();
            } else {
                this.bHY.f(this.bHT.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bHT.saveToBundle(bundle);
        if (this.bHT.ZR()) {
            this.bHW.saveToBundle(bundle);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aHA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.aCG = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aCG = System.currentTimeMillis();
        }
        this.bHK = 0;
        initUI();
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initData(bundle);
        addGlobalLayoutListener();
        this.createTime = System.currentTimeMillis() - this.aCG;
        registerListener(this.aPt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.bHY != null) {
            if (this.bHY.IY() != null) {
                this.bHY.IY().alx();
            }
            if (this.bHY.aaz() != null && this.bHY.aaz().IY() != null) {
                this.bHY.aaz().IY().alx();
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

    public bq Zh() {
        return this.bHT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.bHF = true;
        super.onPause();
        BdListView listView = getListView();
        this.bHK = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.bHK == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
        if (this.bHY != null) {
            this.bHY.onPause();
        }
        if (!this.bHT.ZR()) {
            WriteData IM = this.aHC.IM();
            if (IM == null) {
                IM = new WriteData(1);
                IM.setThreadId(this.bHT.ZN());
                IM.setWriteImagesInfo(this.writeImagesInfo);
            }
            IM.setContent(this.bHY.Jf());
            if (this.bHP != null && this.bHP.getIsBaobao()) {
                IM.setBaobaoContent(this.bHP.getBaobaoContent());
                IM.setBaobaoImagesInfo(this.baobaoImagesInfo);
                IM.setIsBaobao(true);
            }
            com.baidu.tieba.tbadkCore.ao.b(this.bHT.ZN(), IM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        this.bHF = false;
        super.onResume();
        if (this.bHK == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView aar = this.bHY.aar();
        if (aar != null && aar.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            aar.am(false);
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
        if (this.bHY.IY() != null) {
            this.bHY.IY().refresh();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ap
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!com.baidu.tbadk.core.util.bd.isEmpty(writeData.getContent()) && com.baidu.tbadk.core.util.bd.isEmpty(this.bHY.Jf())) {
                this.mPostContent = writeData.getContent();
                this.bHY.fG(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                this.bHY.a(this.writeImagesInfo, true);
            }
            if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.bHP.setIsBaobao(writeData.getIsBaobao());
                this.bHP.setBaobaoContent(writeData.getBaobaoContent());
                this.bHP.setBaobaoImagesInfo(this.baobaoImagesInfo);
                this.bHY.setBaobaoUris(this.baobaoImagesInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bHY.IY() != null && this.bHY.IY().getVisibility() != 0) {
            Zj();
            this.bHY.aau();
        }
        if (!this.bHY.aaT()) {
            this.bHY.aaV();
        }
        this.bHY.bKN.Wl();
        if (this.bHT != null && this.bHT.getPbData() != null && this.bHT.getPbData().YO() != null && this.bHT.getPbData().YP() != null) {
            com.baidu.tbadk.distribute.a.ye().a(getPageContext().getPageActivity(), "pb", this.bHT.getPbData().YO().getId(), com.baidu.adp.lib.g.c.a(this.bHT.getPbData().YP().getId(), 0L));
        }
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (!this.bHQ) {
            this.bHQ = true;
            this.bHY.abv();
        }
        this.bHT.cancelLoadData();
        this.bHT.destory();
        this.aHC.cancelLoadData();
        this.bHV.cancelLoadData();
        this.aHv.cancelLoadData();
        this.bHW.cancelLoadData();
        this.bHW.destory();
        this.bHX.cancelLoadData();
        this.bHY.onDestroy();
        if (this.bHR != null) {
            this.bHR.onDestroy();
        }
        super.onDestroy();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
    }

    public void Zi() {
        if (this.bHY.IY() != null) {
            this.bHY.IY().setContent(this.mPostContent == null ? "" : this.mPostContent);
            if (this.bHO != null) {
                this.bHY.IY().alH();
            }
            this.bHY.a(this.writeImagesInfo, true);
            this.bHY.setBaobaoUris(this.baobaoImagesInfo);
            if (!StringUtils.isNull(this.mPostContent)) {
                this.bHY.IY().BZ();
                this.bHY.IY().alN();
                this.bHY.dU(false);
            } else if (this.writeImagesInfo != null && this.writeImagesInfo.size() >= 1) {
                this.bHY.IY().cmz.hideAll();
                this.bHY.IY().setVisibility(0);
                this.bHY.IY().alN();
                this.bHY.IY().io(23);
            } else if (this.bHO != null) {
                this.bHY.IY().cmz.hideAll();
                this.bHY.IY().setVisibility(0);
                this.bHY.IY().alN();
                this.bHY.IY().io(5);
            } else if (this.baobaoImagesInfo != null && this.baobaoImagesInfo.size() >= 1) {
                this.bHY.IY().cmz.hideAll();
                this.bHY.IY().setVisibility(0);
                this.bHY.IY().alN();
                this.bHY.IY().io(50);
            } else {
                this.bHY.IY().BZ();
                this.bHY.dU(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zj() {
        if (this.bHY.IY() != null) {
            this.mPostContent = this.bHY.IY().getContent();
            this.bHO = this.bHY.getAudioData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bHY.onChangeSkinType(i);
        if (this.bIc != null) {
            this.bIc.onChangeSkinType(this, i, com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.bg_collect));
        }
        if (this.bHY.aar() != null) {
            this.bHY.aar().onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zk() {
        this.bId = new ch(this, this.aLA);
        this.bIc = new MorePopupWindow(getPageContext().getPageActivity(), this.bId.getView(), getResources().getDrawable(com.baidu.tieba.u.bg_collect), null);
        this.bIc.setTouchInterceptor(new v(this));
        this.bIc.onChangeSkinType(this, TbadkCoreApplication.m411getInst().getSkinType(), com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.bg_collect));
    }

    private void initUI() {
        this.bHY = new ci(this, this.aLA, this.bIf);
        this.bHY.setOnActionListener(new w(this));
        this.bHY.setOnScrollListener(this.HI);
        this.bHY.a(this.bIi);
        this.bHY.c(this.bIn);
        this.bHY.a(this.bIo);
        this.bHY.b(this.bhb);
        this.bHY.a(this.ayx);
        this.bHY.dJ(com.baidu.tbadk.core.n.px().pB());
        this.bHY.dK(com.baidu.tbadk.core.n.px().pz());
        this.bHY.setOnImageClickListener(this.asV);
        this.bHY.a(this.aeq);
        this.bHY.a(this.bIq);
        this.bHY.f(this.aJx);
        this.bHY.a(this.bIm);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.bHY != null) {
            if (z && !this.bFR) {
                if (this.aIG) {
                    this.aIG = false;
                    showLoadingView(this.bHY.getView(), true);
                    return;
                }
                return;
            }
            hideLoadingView(this.bHY.getView());
        }
    }

    private void Zl() {
        if (this.bHM == null) {
            this.bHM = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
            this.bHM.a(new String[]{getPageContext().getString(com.baidu.tieba.y.call_phone), getPageContext().getString(com.baidu.tieba.y.sms_phone), getPageContext().getString(com.baidu.tieba.y.search_in_baidu)}, new y(this)).bz(com.baidu.tbadk.core.dialog.g.Rz).bA(17).d(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        this.bHT = new bq(this);
        this.bHT.a(this.bIg);
        this.bHU = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.bHU != null) {
            this.bHU.a(this.bIh);
        }
        this.aHC = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aHC.a(this.bIk);
        this.bHV = new com.baidu.tieba.pb.c.a(this);
        this.bHV.setLoadDataCallBack(this.bIp);
        this.bHW = new com.baidu.tieba.pb.pb.sub.e(this);
        this.bHW.a(this.bIj);
        this.bHX = new com.baidu.tieba.tbadkCore.h.a(this);
        this.bHX.setLoadDataCallBack(this.bIl);
        this.aHv = new com.baidu.tieba.tbadkCore.location.e(this);
        this.aHv.a(this.aHH);
        this.aHv.a(this.aHI);
        if (bundle != null) {
            this.bHT.initWithBundle(bundle);
        } else {
            this.bHT.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, -1) == 18003) {
            this.bHT.dP(true);
        }
        cd.aaj().y(this.bHT.ZL(), this.bHT.getIsFromMark());
        if (!this.bHT.ZR()) {
            this.bHY.aaK();
            this.bHT.AT();
        } else {
            if (bundle != null) {
                this.bHW.initWithBundle(bundle);
            } else {
                this.bHW.initWithIntent(getIntent());
            }
            this.bIe = this.bHW.Yd();
            String stType = this.bHW.getStType();
            if (stType != null && (("mention".equals(this.bHW.getStType()) || stType.equals("person_post_reply")) && this.bIe != null)) {
                this.bHY.aaX();
            } else {
                this.bHY.aaQ();
            }
            this.bHW.abV();
        }
        this.bHY.a(new z(this));
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aHA = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!this.bHT.ZR()) {
            com.baidu.tieba.tbadkCore.ao.a(this.bHT.ZN(), this);
        }
        this.aHL.setUniqueId(getUniqueId());
        this.aHL.registerListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dG(boolean z) {
        if (this.bHT == null || this.bHT.getPbData() == null) {
            return false;
        }
        return ((this.bHT.getPbData().YS() != 0) || this.bHT.getPbData().YP() == null || this.bHT.getPbData().YP().getAuthor() == null || TextUtils.equals(this.bHT.getPbData().YP().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void Zm() {
        if (this.bHT != null && this.bHT.getPbData() != null && this.bHT.getPbData().YP() != null && this.bHT.getPbData().YP().getAuthor() != null) {
            this.bHY.bKN.c(this.bHT.ZO(), this.bHU != null ? this.bHU.oQ() : false, dG(TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.bHT.getPbData().YP().getAuthor().getUserId())));
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
        Zx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Boolean bool) {
        com.baidu.tieba.pb.a.b pbData;
        String str = null;
        if (this.bHT != null && (pbData = this.bHT.getPbData()) != null && pbData.YO() != null) {
            str = pbData.YO().getName();
        }
        if (com.baidu.tieba.tbadkCore.ad.b(str, bool)) {
            Zf();
        } else {
            Ze();
        }
    }

    private void a(String str, Boolean bool) {
        if (com.baidu.tieba.tbadkCore.ad.b(str, bool)) {
            Zf();
        } else {
            Ze();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hE(String str) {
        if (!StringUtils.isNull(str) && this.bHT != null) {
            String ZN = this.bHT.ZN();
            String id = this.bHT.getPbData().YO().getId();
            sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(com.baidu.tieba.y.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + ZN + "&pid=" + str, true)));
        }
    }

    public void a(boolean z, int i, String str, com.baidu.tieba.pb.a.c cVar) {
        stopVoice();
        this.bHY.showToast(str);
        this.bHY.aaW();
        if (!z) {
            if ((i == 4 || i == 28) && this.bHT.ZR()) {
                finish();
            }
        } else if (cVar != null) {
            String Yd = this.bHW.Yd();
            ArrayList<com.baidu.tieba.tbadkCore.c.j> YQ = this.bHT.getPbData().YQ();
            int i2 = 0;
            while (true) {
                if (i2 >= YQ.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.c.j jVar = YQ.get(i2);
                if (jVar.getId() == null || !jVar.getId().equals(Yd)) {
                    i2++;
                } else {
                    ArrayList<com.baidu.tieba.tbadkCore.c.j> YZ = cVar.YZ();
                    jVar.iq(cVar.getTotalCount());
                    if (jVar.amx() != null) {
                        jVar.amx().clear();
                        jVar.amx().addAll(YZ);
                    }
                }
            }
            String stType = this.bHW.getStType();
            if (stType != null && (("mention".equals(this.bHW.getStType()) || stType.equals("person_post_reply")) && this.bIe != null)) {
                this.bHY.a(cVar, this.bHT.getPbData().YS(), this.bIe, cVar.YY() > 1, this.bHW.abQ() == 1);
            } else {
                this.bHY.a(cVar, this.bHT.getPbData().YS());
            }
            AntiData Zc = cVar.Zc();
            if (Zc != null) {
                Boolean valueOf = Boolean.valueOf(Zc.isIfvoice());
                this.bHS = Zc.getVoice_message();
                if (cVar.Zb() != null) {
                    a(cVar.Zb().getName(), valueOf);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            if (!this.bHT.ZR()) {
                antiData.setBlock_forum_name(this.bHT.getPbData().YO().getName());
                antiData.setBlock_forum_id(this.bHT.getPbData().YO().getId());
                antiData.setUser_name(this.bHT.getPbData().getUserData().getUserName());
                antiData.setUser_id(this.bHT.getPbData().getUserData().getUserId());
            } else {
                antiData.setBlock_forum_name(this.bHW.abP().Zb().getName());
                antiData.setBlock_forum_id(this.bHW.abP().Zb().getId());
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
            if (!this.bHT.ZR()) {
                antiData.setBlock_forum_name(this.bHT.getPbData().YO().getName());
                antiData.setBlock_forum_id(this.bHT.getPbData().YO().getId());
                antiData.setUser_name(this.bHT.getPbData().getUserData().getUserName());
                antiData.setUser_id(this.bHT.getPbData().getUserData().getUserId());
            } else {
                antiData.setBlock_forum_name(this.bHW.abP().Zb().getName());
                antiData.setBlock_forum_id(this.bHW.abP().Zb().getId());
                antiData.setUser_name(TbadkCoreApplication.getCurrentAccountName());
                antiData.setUser_id(TbadkCoreApplication.getCurrentAccount());
            }
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        this.bHY.showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.h.c cVar) {
        int i = 0;
        if (cVar != null) {
            this.bHY.a(0, cVar.AM, cVar.cpC, true);
            if (cVar.AM) {
                if (cVar.cpA == 1) {
                    ArrayList<com.baidu.tieba.tbadkCore.c.j> YQ = this.bHT.getPbData().YQ();
                    int size = YQ.size();
                    while (true) {
                        if (i < size) {
                            if (!cVar.mPostId.equals(YQ.get(i).getId())) {
                                i++;
                            } else {
                                YQ.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.bHY.e(this.bHT.getPbData());
                } else if (cVar.cpA == 0) {
                    Zn();
                } else if (cVar.cpA == 2) {
                    ArrayList<com.baidu.tieba.tbadkCore.c.j> YQ2 = this.bHT.getPbData().YQ();
                    int size2 = YQ2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < YQ2.get(i2).amx().size()) {
                                if (!cVar.mPostId.equals(YQ2.get(i2).amx().get(i3).getId())) {
                                    i3++;
                                } else {
                                    YQ2.get(i2).amx().remove(i3);
                                    YQ2.get(i2).amy();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData YU = this.bHT.getPbData().YU();
                        com.baidu.tieba.tbadkCore.c.j jVar = YQ2.get(i2);
                        ArrayList<com.baidu.tieba.tbadkCore.c.j> amz = jVar.amz();
                        int size3 = amz.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!cVar.mPostId.equals(YQ2.get(i2).amz().get(i4).getId())) {
                                    i4++;
                                } else {
                                    amz.remove(i4);
                                    YU.decreaseAlreadyCount();
                                    if (jVar.amG() > amz.size()) {
                                        jVar.is(amz.size());
                                    }
                                    if (amz.size() > 0) {
                                        com.baidu.tieba.tbadkCore.c.j jVar2 = amz.get(amz.size() - 1);
                                        YU.setLastAdditionTime(jVar2.getTime() / 1000);
                                        com.baidu.tbadk.widget.richText.a amB = jVar2.amB();
                                        String str = "";
                                        if (amB != null) {
                                            str = amB.toString();
                                        }
                                        YU.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a amB2 = jVar.amB();
                                        String str2 = "";
                                        if (amB2 != null) {
                                            str2 = amB2.toString();
                                        }
                                        YU.setLastAdditionContent(str2);
                                    }
                                    Zy();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.bHY.e(this.bHT.getPbData());
                    }
                    if (this.bHY.aaT()) {
                        this.bHW.hO(cVar.mPostId);
                        this.bHY.a(this.bHW.abP(), this.bHT.getPbData().YS());
                        if (!z) {
                            String Yd = this.bHW.Yd();
                            while (i < size2) {
                                if (!Yd.equals(YQ2.get(i).getId())) {
                                    i++;
                                } else {
                                    YQ2.get(i).amy();
                                    this.bHY.e(this.bHT.getPbData());
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
        this.bHY.a(1, eVar.AM, eVar.cpC, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.h.g gVar) {
        this.bHY.a(this.bHX.getLoadDataMode(), gVar.AM, gVar.cpC, false);
        this.bHY.L(gVar.cpE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.tbadkCore.h.g gVar) {
        if (gVar != null) {
            this.bHY.a(this.bHX.getLoadDataMode(), gVar.AM, gVar.cpC, true);
            if (gVar.AM) {
                this.bIb = true;
                if (i == 2) {
                    this.bHT.getPbData().YP().bu(1);
                    this.bHT.setIsGood(1);
                } else if (i == 3) {
                    this.bHT.getPbData().YP().bu(0);
                    this.bHT.setIsGood(0);
                } else if (i == 4) {
                    this.bHT.getPbData().YP().bt(1);
                    this.bHT.hj(1);
                } else if (i == 5) {
                    this.bHT.getPbData().YP().bt(0);
                    this.bHT.hj(0);
                }
                this.bHY.a(this.bHT.getPbData(), this.bHT.ZO(), true);
            }
        }
    }

    private void Zn() {
        if (this.bHT.ZP()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.bHT.ZN());
            setResult(-1, intent);
        }
        if (Zt()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zo() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        this.bHY.abo();
        if (this.bHT != null && this.bHT.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.bHT.getPbData().YP().getId();
            historyMessage.forumName = this.bHT.getPbData().YO().getName();
            historyMessage.threadName = this.bHT.getPbData().YP().getTitle();
            ArrayList<com.baidu.tieba.tbadkCore.c.j> YQ = this.bHT.getPbData().YQ();
            int abb = this.bHY.abb();
            if (YQ != null && abb >= 0 && abb < YQ.size()) {
                historyMessage.postID = YQ.get(abb).getId();
            }
            historyMessage.isHostOnly = this.bHT.getHostMode();
            historyMessage.isSquence = this.bHT.ZO();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.bHT != null && this.bHT.ZP()) {
            Intent intent = new Intent();
            if (this.bIb) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.bHT.ZN());
                intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.bHT.ZQ());
                intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.bHT.getIsGood());
            }
            setResult(-1, intent);
        }
        if (Zt()) {
            if (this.bHT != null && this.bHY != null && this.bHY.getListView() != null) {
                com.baidu.tieba.pb.a.b pbData = this.bHT.getPbData();
                if (pbData != null && pbData.getUserData() != null) {
                    pbData.getUserData().setBimg_url(TbadkCoreApplication.m411getInst().getDefaultBubble());
                }
                cd.aaj().a(this.bHT.getPbData(), this.bHY.getListView().onSaveInstanceState(), this.bHT.ZO(), this.bHT.getHostMode());
            } else {
                cd.aaj().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.bIc != null) {
                    com.baidu.adp.lib.g.k.a(this.bIc, getPageContext().getPageActivity());
                }
                if (this.bHY.dX(this.bHT.ZR())) {
                    stopVoice();
                    return true;
                }
                finish();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hh(int i) {
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
                    fD(null);
                    return;
                case 11009:
                    Zr();
                    return;
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(getPageContext().getPageActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(getPageContext().getPageActivity(), 12005, true)));
                    return;
                case 11027:
                    fD(this.bHY.abd());
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
                        Zq();
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            this.bHY.aba();
                            this.aHC.eS(false);
                            return;
                        }
                        this.bHV.hD(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    Zq();
                    ArrayList<String> V = com.baidu.tieba.tbadkCore.util.i.V(intent);
                    if (V != null) {
                        this.bHY.v(V);
                        return;
                    }
                    return;
                case 12005:
                    Zq();
                    new Handler().postDelayed(new aa(this), 200L);
                    ArrayList<String> V2 = com.baidu.tieba.tbadkCore.util.i.V(intent);
                    if (V2 != null) {
                        this.bHY.M(V2);
                        return;
                    }
                    return;
                case 12006:
                    WriteData IM = this.aHC.IM();
                    if (IM != null) {
                        IM.deleteUploadedTempImages();
                    }
                    this.bHP.setIsBaobao(false);
                    this.bHP.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.aHC.c((WriteData) null);
                    this.aHC.eS(false);
                    this.bHY.bK(true);
                    if (this.bHY.aaT()) {
                        this.bHW.abT();
                    } else {
                        if (this.bHT != null && this.bHT.ZU()) {
                            this.bHY.aaK();
                        }
                        if (this.bHT != null && this.bHT.ZN() != null && !this.bHT.ZR()) {
                            com.baidu.tieba.tbadkCore.ao.b(this.bHT.ZN(), (WriteData) null);
                        }
                    }
                    this.bHY.a(this.writeImagesInfo, true);
                    return;
                case 12009:
                case 12010:
                    Zq();
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
                    cd.aaj().reset();
                    this.mHandler.postDelayed(new ab(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.bHT != null) {
                        a(Zp(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getIntExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0));
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
                IN();
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
                Zq();
                return;
        }
    }

    private ShareFromPBMsgData Zp() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] ay = this.bHT.getPbData().ay(getPageContext().getPageActivity());
        com.baidu.tieba.tbadkCore.c.j aat = this.bHY.aat();
        String str = "";
        if (aat != null) {
            str = aat.getId();
            String aF = aat.aF(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.m.isEmpty(aF)) {
                ay[1] = aF;
            }
        }
        String qM = this.bHT.getPbData().YP().qM();
        if (qM != null && qM.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(ay[1]);
        shareFromPBMsgData.setImageUrl(ay[0]);
        shareFromPBMsgData.setForumName(this.bHT.getPbData().YO().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.bHT.getPbData().YP().getId());
        shareFromPBMsgData.setTitle(this.bHT.getPbData().YP().getTitle());
        return shareFromPBMsgData;
    }

    private void R(Intent intent) {
        a(Zp(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.bHT != null && this.bHT.getPbData() != null && this.bHT.getPbData().YP() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bZ(this.bHT.getPbData().YP().getTitle());
            di diVar = new di(getPageContext().getPageActivity());
            diVar.setData(shareFromPBMsgData);
            aVar.j(diVar);
            aVar.a(com.baidu.tieba.y.share, new ac(this, diVar, j, str, str2, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.y.alert_no_button, new ad(this, diVar));
            aVar.ad(false);
            aVar.b(getPageContext()).re();
            if (!com.baidu.adp.lib.util.m.isEmpty(shareFromPBMsgData.getImageUrl())) {
                diVar.v(shareFromPBMsgData.getImageUrl(), this.bHT.getPbData().YT() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, int i2) {
        if (this.bHT != null && this.bHT.getPbData() != null && this.bHT.getPbData().YP() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bZ(this.bHT.getPbData().YP().getTitle());
            di diVar = new di(getPageContext().getPageActivity());
            diVar.setData(shareFromPBMsgData);
            aVar.j(diVar);
            aVar.a(com.baidu.tieba.y.share, new ae(this, diVar, i, str, i2, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.y.alert_no_button, new af(this, diVar));
            aVar.ad(false);
            aVar.b(getPageContext()).re();
            if (!com.baidu.adp.lib.util.m.isEmpty(shareFromPBMsgData.getImageUrl())) {
                diVar.v(shareFromPBMsgData.getImageUrl(), this.bHT.getPbData().YT() == 1);
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
        this.aHA = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aHA;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cf = com.baidu.tbadk.core.util.c.cf(str);
                if (cf != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.M(getPageContext().getPageActivity())), com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.N(getPageContext().getPageActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.c.h(b, cf);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.o.a(TbConfig.LOCAL_CAMERA_DIR, this.aHA, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            this.bHY.a(this.writeImagesInfo, true);
        }
        if (this.bHY.IY() != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            this.bHY.IY().io(23);
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
                    this.bHY.a(this.writeImagesInfo, z);
                }
            }
            if (this.bHY.IY() != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                this.bHY.IY().io(23);
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
                this.bHY.setBaobaoUris(this.baobaoImagesInfo);
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    if (this.bHY.IY() != null) {
                        this.bHY.IY().io(50);
                    }
                    this.bHP.setIsBaobao(true);
                    this.bHP.setBaobaoContent(stringExtra2);
                    this.bHP.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.bHP.setIsBaobao(false);
                this.bHP.setBaobaoContent("");
                this.bHP.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void IN() {
        new ag(this).execute(new Void[0]);
    }

    private void Zq() {
        if (this.bIa) {
            this.bIa = false;
            new Handler().postDelayed(new ah(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zr() {
        MarkData hp;
        if (this.bHU != null && (hp = this.bHT.hp(this.bHY.abb())) != null) {
            this.bHY.aaK();
            this.bHU.a(hp);
            if (!this.bHU.oQ()) {
                this.bHU.oS();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.bHU.oR();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD(String str) {
        VoiceData.VoiceModel aaB;
        if (this.aHC.IM() == null) {
            if (!this.bHT.ZR()) {
                this.aHC.c(this.bHT.hI(str));
            } else {
                this.aHC.c(this.bHW.IM());
            }
        }
        if (this.aHC.IM() != null) {
            if (!this.bHT.ZR()) {
                this.aHC.IM().setWriteImagesInfo(this.writeImagesInfo);
                this.aHC.eS(this.writeImagesInfo.size() > 0);
                if (this.bHP.getIsBaobao()) {
                    this.aHC.IM().setIsBaobao(true);
                    this.aHC.IM().setBaobaoContent(this.bHP.getBaobaoContent());
                    this.aHC.IM().setBaobaoImagesInfo(this.baobaoImagesInfo);
                } else {
                    this.aHC.IM().setIsBaobao(false);
                }
            }
            if (this.bHY.IY() != null) {
                this.aHC.IM().setHasLocationData(this.bHY.IY().getLocationInfoViewState() == 2);
            }
            if (str == null) {
                this.aHC.IM().setContent(this.bHY.Jf());
                aaB = this.bHY.getAudioData();
                this.bHY.Jh();
            } else {
                this.aHC.IM().setContent(this.bHY.abc());
                this.aHC.IM().setRepostId(this.bHY.abe());
                aaB = this.bHY.aaB();
                this.bHY.aaC();
            }
            if (aaB != null) {
                if (aaB.getId() != null) {
                    this.aHC.IM().setVoice(aaB.getId());
                    this.aHC.IM().setVoiceDuringTime(aaB.duration);
                } else {
                    this.aHC.IM().setVoice(null);
                    this.aHC.IM().setVoiceDuringTime(-1);
                }
            } else {
                this.aHC.IM().setVoice(null);
                this.aHC.IM().setVoiceDuringTime(-1);
            }
            if (!this.aHC.anC()) {
                showToast(com.baidu.tieba.y.write_img_limit);
            } else if (this.aHC.anA()) {
                this.bHY.Je();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zs() {
        com.baidu.tieba.pb.a.b pbData = this.bHT.getPbData();
        this.bHT.dO(true);
        pbData.hC(this.bHU.oP());
        this.bHY.e(pbData);
    }

    private boolean Zt() {
        if (this.bHT == null) {
            return true;
        }
        if (this.bHT.oQ()) {
            MarkData aaa = this.bHT.aaa();
            if (aaa == null || !this.bHT.getIsFromMark()) {
                return true;
            }
            MarkData hp = this.bHT.hp(this.bHY.abb());
            if (hp == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aaa);
                setResult(-1, intent);
                return true;
            } else if (hp.getPostId() == null || hp.getPostId().equals(aaa.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aaa);
                setResult(-1, intent2);
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.ca(String.format(getPageContext().getString(com.baidu.tieba.y.alert_update_mark), Integer.valueOf(hp.getFloor())));
                aVar.a(com.baidu.tieba.y.alert_yes_btn, new aj(this, hp, aaa));
                aVar.b(com.baidu.tieba.y.alert_no_button, new ak(this, aaa));
                aVar.b(getPageContext());
                aVar.re();
                return false;
            }
        } else if (this.bHT.getPbData() == null || this.bHT.getPbData().YQ() == null || this.bHT.getPbData().YQ().size() <= 0 || !this.bHT.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.ao
    public BdListView getListView() {
        if (this.bHY == null) {
            return null;
        }
        return this.bHY.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int getRichTextViewId() {
        if (this.bHY == null) {
            return 0;
        }
        return this.bHY.abh();
    }

    @Override // com.baidu.tbadk.core.view.ao
    public int tS() {
        if (this.bHY == null) {
            return 0;
        }
        return this.bHY.Kh();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<ImageView> getImageViewPool() {
        if (this.asC == null) {
            this.asC = new com.baidu.adp.lib.e.b<>(new al(this), 8, 0);
        }
        return this.asC;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<TextView> getTextViewPool() {
        if (this.asD == null) {
            this.asD = TbRichTextView.h(getPageContext().getPageActivity(), 8);
        }
        return this.asD;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<GifView> getGifViewPool() {
        if (this.asG == null) {
            this.asG = new com.baidu.adp.lib.e.b<>(new am(this), 20, 0);
        }
        return this.asG;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<View> getVoiceViewPool() {
        if (this.asE == null) {
            this.asE = new com.baidu.adp.lib.e.b<>(new an(this), 8, 0);
        }
        return this.asE;
    }

    @Override // com.baidu.tbadk.core.view.ao
    public com.baidu.adp.lib.e.b<TbImageView> tT() {
        if (this.Zg == null) {
            this.Zg = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.Zg;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    public boolean hF(String str) {
        Map<String, String> cQ;
        if (!TextUtils.isEmpty(str) && (cQ = com.baidu.tbadk.core.util.bk.cQ(com.baidu.tbadk.core.util.bk.cR(str))) != null) {
            String str2 = cQ.get(ImageViewerConfig.URL);
            if (!TextUtils.isEmpty(str2)) {
                return hF(com.baidu.adp.lib.util.m.aN(str2));
            }
            String str3 = cQ.get(bHL);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onLinkClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (hG(str) || z) {
                boolean u = com.baidu.adp.lib.util.n.u(context, "com.qiyi.video");
                hH(str);
                if (u) {
                    Zu();
                } else {
                    Zv();
                }
            } else if (hF(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                com.baidu.tbadk.core.util.bk.tl().b(getPageContext(), new String[]{str});
            }
        }
    }

    private boolean hG(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }

    private void hH(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(";")) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.bHI = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.bHJ = split[i].substring(indexOf2 + 1, split[i].length());
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
                        this.bHH = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void Zu() {
        if (TextUtils.isEmpty(this.bHI) || TextUtils.isEmpty(this.bHJ) || TextUtils.isEmpty(this.mPackageName)) {
            if (!TextUtils.isEmpty(this.bHH)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.bHH);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(this.bHI));
        intent.setAction(this.bHJ);
        intent.setPackage(this.mPackageName);
        if (intent.resolveActivity(getPageContext().getPageActivity().getPackageManager()) != null) {
            if (!com.baidu.adp.lib.g.j.e(getPageContext().getPageActivity(), intent) && !TextUtils.isEmpty(this.bHH)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.bHH);
            }
        } else if (!TextUtils.isEmpty(this.bHH)) {
            com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.bHH);
        }
    }

    private void Zv() {
        if (!com.baidu.adp.lib.util.k.iI()) {
            if (!TextUtils.isEmpty(this.bHH)) {
                com.baidu.tbadk.browser.f.b(getPageContext().getPageActivity(), false, this.bHH);
                return;
            }
            return;
        }
        if (this.bHG == null) {
            this.bHG = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.bHG.bx(com.baidu.tieba.y.download_iqiyi_app_dialog);
            this.bHG.a(com.baidu.tieba.y.install_app, new ao(this));
            this.bHG.b(com.baidu.tieba.y.webpage_play, new ap(this));
            this.bHG.ad(false);
        }
        this.bHG.b(getPageContext()).re();
    }

    private com.baidu.tbadk.core.dialog.a Zw() {
        if (this.bHN == null) {
            this.bHN = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.bHN.bZ(getPageContext().getString(com.baidu.tieba.y.download_baidu_video_dialog));
            this.bHN.a(getPageContext().getString(com.baidu.tieba.y.install), new aq(this));
            this.bHN.b(getPageContext().getString(com.baidu.tieba.y.cancel), new ar(this));
            this.bHN.ac(true);
            this.bHN.b(getPageContext());
            this.bHN.ad(false);
        }
        this.bHN.re();
        return this.bHN;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onVideoClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (hG(str) || z) {
                boolean u = com.baidu.adp.lib.util.n.u(context, "com.qiyi.video");
                hH(str);
                if (u) {
                    Zu();
                    return;
                } else {
                    Zv();
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
            Zw();
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
        com.baidu.tbadk.widget.richText.g DA;
        if (aVar == aVar2) {
            this.bIs = true;
        }
        if (aVar != null) {
            int size = aVar.Dv().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.Dv().get(i6) != null && aVar.Dv().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.Dv().get(i6).DA().getWidth();
                    int height = aVar.Dv().get(i6).DA().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.Dv().get(i6).DA().DH()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.Dv().get(i6);
                        String b = b(cVar);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && cVar != null && (DA = cVar.DA()) != null) {
                            String DI = DA.DI();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = DI;
                            int i8 = this.mIsFromCDN ? 17 : 18;
                            imageUrlData.urlType = i8;
                            imageUrlData.urlType = i8;
                            if (hashMap != null) {
                                hashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.bIs) {
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
            if (jVar.getId() != null && jVar.getId().equals(this.bHT.qI())) {
                z = true;
            }
            MarkData d = this.bHT.d(jVar);
            if (d != null && hh(11009)) {
                this.bHY.aaK();
                if (this.bHU != null) {
                    this.bHU.a(d);
                    if (!z) {
                        this.bHU.oS();
                    } else {
                        this.bHU.oR();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a O(String str, int i) {
        if (this.bHT == null || this.bHT.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.a.b pbData = this.bHT.getPbData();
        com.baidu.tbadk.widget.richText.a a = a(pbData.YQ(), str, i);
        if (a == null) {
            ArrayList<com.baidu.tieba.tbadkCore.c.j> YQ = pbData.YQ();
            int size = YQ.size();
            for (int i2 = 0; i2 < size; i2++) {
                a = a(YQ.get(i2).amz(), str, i);
                if (a != null) {
                    return a;
                }
            }
            return a;
        }
        return a;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.tbadkCore.c.j> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> Dv;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a amB = arrayList.get(i2).amB();
            if (amB != null && (Dv = amB.Dv()) != null) {
                int size = Dv.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Dv.get(i4) != null && Dv.get(i4).getType() == 8) {
                        i3++;
                        if (Dv.get(i4).DA().DI().equals(str)) {
                            int width = Dv.get(i4).DA().getWidth();
                            int height = Dv.get(i4).DA().getHeight();
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.bIr = i4;
                            return amB;
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
        com.baidu.tbadk.widget.richText.g DA = cVar.DA();
        if (DA != null) {
            if (!StringUtils.isNull(DA.DG())) {
                return DA.DG();
            }
            if (DA.getHeight() * DA.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (DA.getHeight() * DA.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (DA.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * DA.getHeight())));
            } else {
                float width = DA.getWidth() / DA.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.bd.aM(DA.getSrc()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onPhoneClicked(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mPhoneNumber = str;
            if (this.bHM == null) {
                Zl();
            }
            com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "pb_show_phonedialog");
            if (str2.equals("2")) {
                this.bHM.bC(1).setVisibility(8);
            } else {
                this.bHM.bC(1).setVisibility(0);
            }
            this.bHM.rg();
        }
    }

    @Override // com.baidu.tbadk.core.voice.j
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zx() {
        hideNetRefreshView(this.bHY.getView());
        showLoadingView(this.bHY.getView(), true);
        if (this.bHT.AT()) {
            this.bHY.aaK();
        }
    }

    @Override // com.baidu.tbadk.core.voice.j
    public com.baidu.tbadk.core.voice.i getRealView(VoiceData.VoiceModel voiceModel) {
        View abq;
        View findViewWithTag;
        if (!this.bHY.aaT() || (abq = this.bHY.abq()) == null || (findViewWithTag = abq.findViewWithTag(voiceModel)) == null) {
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
        if (this.bHT.ZZ()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.a.b pbData = this.bHT.getPbData();
            String name = pbData.YO().getName();
            String title = pbData.YP().getTitle();
            String str = "http://tieba.baidu.com/p/" + this.bHT.ZN() + "?share=9105&fr=share";
            String[] ay = pbData.ay(getPageContext().getPageActivity());
            String str2 = ay[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String format = MessageFormat.format(getResources().getString(com.baidu.tieba.y.share_content_tpl), title, name, ay[1]);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = title;
            fVar.content = format;
            fVar.adm = str;
            if (parse != null) {
                fVar.adn = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true, oX());
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(com.baidu.tieba.y.share_tieba_qunzu, com.baidu.tieba.u.icon_unite_share_qunzu, new as(this));
            shareDialogConfig.addOutsideTextView(com.baidu.tieba.y.forum_friend, com.baidu.tieba.u.icon_unite_share_baf, new au(this));
            shareDialogConfig.setCopyLinkListener(new av(this, fVar));
            sendMessage(new CustomMessage(2001283, shareDialogConfig));
        }
    }

    private SparseArray<String> oX() {
        if (this.aQj == null) {
            this.aQj = new SparseArray<>(7);
            this.aQj.put(2, "pb_wx_timeline");
            this.aQj.put(3, "pb_wx_friend");
            this.aQj.put(4, "pb_qq_zone");
            this.aQj.put(5, "pb_tencent_weibo");
            this.aQj.put(6, "pb_sina_weibo");
            this.aQj.put(7, "pb_renren");
        }
        return this.aQj;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool() {
        if (this.asF == null) {
            this.asF = new com.baidu.adp.lib.e.b<>(new aw(this), 15, 0);
        }
        return this.asF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zy() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.pb.a.b pbData = this.bHT.getPbData();
        if (pbData != null) {
            boolean isIfAddition = pbData.qe().isIfAddition();
            AdditionData YU = pbData.YU();
            boolean z3 = YU == null ? false : isIfAddition;
            if (z3) {
                z = YU.getAlreadyCount() != YU.getTotalCount();
                if (!TextUtils.isEmpty(YU.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            com.baidu.tieba.pb.pb.main.b.a aVar = this.bHY.bKN;
            if (!z3 || !z) {
                z2 = false;
            }
            aVar.dZ(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bHY.aax() == view) {
            com.baidu.tbadk.core.data.w YP = this.bHT.getPbData().YP();
            if (view != null) {
                boolean z = YP.getPraise() == null || YP.getPraise().getIsLike() == 0;
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
            new Handler().postDelayed(new ax(this), 200L);
        }
    }

    private void praiseAnimUp(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), com.baidu.tieba.p.praise_animation_scale3));
            new Handler().postDelayed(new ay(this), 600L);
        }
    }

    private void praiseAnimDown(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), com.baidu.tieba.p.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    public void Jt() {
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
        } else if (!this.bHX.anm()) {
            this.bHY.aaG();
            if (aVar.rf() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.rf();
                String str = (String) sparseArray.get(com.baidu.tieba.v.tag_del_post_id);
                int intValue = ((Integer) sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue();
                int intValue2 = ((Integer) sparseArray.get(com.baidu.tieba.v.tag_del_post_type)).intValue();
                if (this.bHT.ZR()) {
                    if (this.bHW != null && this.bHW.abP() != null && this.bHW.abP().Zb() != null && this.bHW.abP().Zd() != null) {
                        this.bHX.a(this.bHW.abP().Zb().getId(), this.bHW.abP().Zb().getName(), this.bHW.abP().Zd().getId(), str, intValue2, intValue, booleanValue);
                        return;
                    }
                    return;
                }
                this.bHX.a(this.bHT.getPbData().YO().getId(), this.bHT.getPbData().YO().getName(), this.bHT.getPbData().YP().getId(), str, intValue2, intValue, booleanValue);
            }
        }
    }
}
