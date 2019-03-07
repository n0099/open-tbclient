package com.baidu.tieba.image;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.image.e;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes3.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> implements com.baidu.tbadk.coreExtra.view.a {
    private boolean cdq;
    private boolean cds;
    private boolean cdt;
    private Map<String, ImageUrlData> ceA;
    private String ctx;
    private com.baidu.tbadk.core.dialog.g eiR;
    private com.baidu.tbadk.core.dialog.i eiS;
    private String ele;
    private String fjU;
    private String gAN;
    private String gAO;
    private TextView gAZ;
    private float gBH;
    private MultiImageView gBa;
    private ArrayList<String> gBc;
    private a gBd;
    private e gBe;
    private i gBf;
    private boolean gBl;
    private boolean gBm;
    private int gBn;
    private boolean gBo;
    private float gBp;
    private com.baidu.tieba.c.d gBq;
    private boolean gBr;
    private boolean gBs;
    private com.baidu.tbadk.core.dialog.f gBv;
    private com.baidu.tbadk.core.dialog.f gBw;
    private com.baidu.tbadk.core.dialog.f gBx;
    private com.baidu.tbadk.core.dialog.f gBy;
    private com.baidu.tbadk.core.dialog.f gBz;
    private String mFrom;
    private boolean mIsSeeHost;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean gBb = true;
    private boolean gBg = false;
    private boolean gBh = true;
    private com.baidu.tieba.image.a gBi = null;
    private boolean gBj = false;
    private boolean gBk = false;
    private boolean cox = false;
    private int Ur = 0;
    private boolean gBt = false;
    private boolean gAP = false;
    private boolean gBu = false;
    private List<com.baidu.tbadk.core.dialog.f> eiW = null;
    private final CustomMessageListener gBA = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null && !StringUtils.isNull(kVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(kVar);
                if (StringUtils.isNull(kVar.chu)) {
                    ba.adD().c(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    ba.adD().c(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.chu});
                }
            }
        }
    };
    private DragImageView.d cfe = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void aqS() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gAZ, 8);
            if (ImageViewerActivity.this.gBa != null) {
                ImageViewerActivity.this.gBa.eu(false);
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void aqT() {
            TiebaStatic.log(new am("c13341").T("obj_param1", ImageViewerActivity.this.gBa.getItemNum()).T("obj_param2", ImageViewerActivity.this.gBa.getCurrentMaxIndex()));
            TiebaStatic.log(new am("c13377").bJ("obj_type", "2"));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void aqU() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 0);
            if (ImageViewerActivity.this.gBa != null && !ImageViewerActivity.this.gBa.akp()) {
                ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gAZ, 0);
                ImageViewerActivity.this.gBa.eu(true);
            }
        }
    };
    private UrlDragImageView.b cdi = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void akJ() {
            TiebaStatic.log(new am("c10351").bJ("tid", ImageViewerActivity.this.ctx).bJ("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final View.OnClickListener gBB = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                ImageViewerActivity.this.showToast(d.j.neterror);
                return;
            }
            TiebaStatic.log(new am("pb_onlyowner_click").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).T("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
            TiebaStatic.log(new am("c13338").T("obj_locate", ImageViewerActivity.this.mIsSeeHost ? 1 : 2));
            ImageViewerActivity.this.gBl = true;
            if (ImageViewerActivity.this.gAZ != null) {
                ImageViewerActivity.this.gAZ.setEnabled(false);
            }
            ImageViewerActivity.this.j(d.xM((String) v.c(ImageViewerActivity.this.gBc, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
        }
    };
    private i.b gBC = new i.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            ImageViewerActivity.this.gBa.jf(ImageViewerActivity.this.bpw());
            ImageViewerActivity.this.aQA();
        }
    };
    private i.b gBD = new i.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            g.aM(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.gBa.getCurrentImageUrl());
            ImageViewerActivity.this.aQA();
            ImageViewerActivity.this.uE(1);
        }
    };
    private i.b gBE = new i.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            String currentImageUrl = ImageViewerActivity.this.gBa.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.cmC);
                intent.putExtra(com.baidu.tbadk.imageManager.d.cmD, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            ImageViewerActivity.this.aQA();
            ImageViewerActivity.this.uE(2);
        }
    };
    private i.b gBF = new i.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
            if (ImageViewerActivity.this.mPermissionJudgement == null) {
                ImageViewerActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            ImageViewerActivity.this.mPermissionJudgement.adQ();
            ImageViewerActivity.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!ImageViewerActivity.this.mPermissionJudgement.Y(pageActivity)) {
                ImageViewerActivity.this.saveImage();
                ImageViewerActivity.this.aQA();
                ImageViewerActivity.this.uE(3);
            }
        }
    };
    private i.b gBG = new i.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            if (ImageViewerActivity.this.gBa != null) {
                if (!com.baidu.tbadk.plugins.c.b(ImageViewerActivity.this.getPageContext(), "com.baidu.tieba.pluginCore")) {
                    ImageViewerActivity.this.aQA();
                    return;
                }
                UrlDragImageView currentUrlDragImageView = ImageViewerActivity.this.gBa.getCurrentUrlDragImageView();
                if (currentUrlDragImageView != null) {
                    ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                    String str = "";
                    String str2 = "";
                    if (imageUrlData != null) {
                        str = imageUrlData.imageUrl;
                        str2 = com.baidu.tbadk.core.util.d.c.mK(str);
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = ImageViewerActivity.this.gBa.getCurrentImageUrl();
                        str2 = as.mK(str);
                    }
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    if (imageUrlData != null) {
                        long j = imageUrlData.threadId;
                        if (j > 0) {
                            dVar.linkUrl = "http://tieba.baidu.com/p/" + j + "?fr=share";
                        }
                    }
                    if (!ap.isEmpty(str)) {
                        dVar.imageUri = Uri.parse(str);
                        dVar.shareType = 1;
                        Bundle bundle = new Bundle();
                        bundle.putString(ClientCookie.PATH_ATTR, TbConfig.IMAGE_CACHE_DIR_NAME);
                        bundle.putString("name", str2);
                        bundle.putBoolean("formatData", true);
                        bundle.putBoolean("isSubDir", true);
                        bundle.putBoolean("isSdcard", false);
                        bundle.putBoolean("isSavedCache", true);
                        dVar.cbv = bundle;
                    }
                    ImageViewerActivity.this.sendMessage(new CustomMessage(2001276, new ShareDialogConfig(ImageViewerActivity.this.getActivity(), dVar, false)));
                    ImageViewerActivity.this.aQA();
                    ImageViewerActivity.this.uE(4);
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (ImageViewerActivity.this.gBu && ImageViewerActivity.this.gBa != null) {
                boolean akp = ImageViewerActivity.this.gBa.akp();
                if (!akp) {
                    com.baidu.tieba.t.a.G(ImageViewerActivity.this.gAZ, 100);
                    i = 1;
                } else {
                    com.baidu.tieba.t.a.H(ImageViewerActivity.this.gAZ, 100);
                    i = 2;
                }
                ImageViewerActivity.this.gBa.g(akp ? false : true, 100);
                TiebaStatic.log(new am("c13397").T("obj_type", i));
                return;
            }
            TiebaStatic.log(new am("c13341").T("obj_param1", ImageViewerActivity.this.gBa.getItemNum()).T("obj_param2", ImageViewerActivity.this.gBa.getCurrentMaxIndex()));
            TiebaStatic.log(new am("c13377").bJ("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean gBI = true;
    private View.OnTouchListener cfr = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.gBH = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.gBI = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.gBH = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.gBI = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener gBJ = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.byF();
            ImageViewerActivity.this.show();
            TiebaStatic.log(new am("c13269").bJ("uid", ImageViewerActivity.this.mUserId).bJ(ImageViewerConfig.FORUM_ID, ImageViewerActivity.this.ele).bJ("tid", ImageViewerActivity.this.ctx));
            return true;
        }
    };
    private BaseViewPager.a gBK = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void hF(int i) {
            if (i == 0) {
                ImageViewerActivity.this.gBe.bym();
            } else if (ImageViewerActivity.this.byz() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.gBe.byn();
            }
        }
    };
    private ViewPager.OnPageChangeListener bUY = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.gBe != null && i > ImageViewerActivity.this.gBa.getItemNum() - 5) {
                ImageViewerActivity.this.gBe.bym();
            }
            ImageViewerActivity.this.gBf.e(ImageViewerActivity.this.gBc, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.byA();
            ImageViewerActivity.this.byG();
            ImageViewerActivity.this.uF(i);
            if (ImageViewerActivity.this.gBf.byH() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.gBf.uG(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.gBf.byI() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.gBf.uH(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.byB()) {
                ImageViewerActivity.this.gBi.bya();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.gBa.getItemNum() - 1) {
                ImageViewerActivity.this.gBg = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.Ur) {
                ImageViewerActivity.this.Ur = i;
                ImageViewerActivity.this.cox = true;
            } else if (i < ImageViewerActivity.this.Ur) {
                ImageViewerActivity.this.Ur = i;
                ImageViewerActivity.this.cox = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.gBc != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.gBc.size()) {
                ImageViewerActivity.this.gBf.an(i, (String) ImageViewerActivity.this.gBc.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.gBa.getItemNum() - 1) {
                if (!ImageViewerActivity.this.gBI || !ImageViewerActivity.this.gBo || (!ImageViewerActivity.this.gBg && !ImageViewerActivity.this.byB() && (ImageViewerActivity.this.gBa.getItemNum() != 1 || !ImageViewerActivity.this.cox))) {
                    ImageViewerActivity.this.gBg = true;
                } else {
                    ImageViewerActivity.this.showToast(d.j.last_page);
                }
            }
        }
    };
    private CustomMessageListener bND = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.ceA != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.ceA.values()) {
                    if (imageUrlData != null) {
                        String valueOf = String.valueOf(imageUrlData.threadId);
                        String valueOf2 = String.valueOf(imageUrlData.postId);
                        if (agreeData.threadId.equals(valueOf) && agreeData.postId.equals(valueOf2) && (agreeData2 = imageUrlData.agreeData) != null) {
                            agreeData2.agreeType = agreeData.agreeType;
                            agreeData2.hasAgree = agreeData.hasAgree;
                            agreeData2.diffAgreeNum = agreeData.diffAgreeNum;
                            agreeData2.agreeNum = agreeData.agreeNum;
                            agreeData2.disAgreeNum = agreeData.disAgreeNum;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener bNE = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.ceA != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.ceA.values()) {
                    if (imageUrlData != null) {
                        String valueOf = String.valueOf(imageUrlData.threadId);
                        String valueOf2 = String.valueOf(imageUrlData.postId);
                        if (agreeData.threadId.equals(valueOf) && agreeData.postId.equals(valueOf2) && (agreeData2 = imageUrlData.agreeData) != null) {
                            agreeData2.agreeType = agreeData.agreeType;
                            agreeData2.hasAgree = agreeData.hasAgree;
                            agreeData2.diffAgreeNum = agreeData.diffAgreeNum;
                            agreeData2.agreeNum = agreeData.agreeNum;
                            agreeData2.disAgreeNum = agreeData.disAgreeNum;
                        }
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewVisibility(View view, int i) {
        if (view != null) {
            view.clearAnimation();
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 28 && (UtilHelper.hasNotchAndroidP(this) || UtilHelper.hasNotchAtHuawei(this))) {
            setUseStyleImmersiveSticky(false);
        }
        super.onCreate(bundle);
        this.gBn = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(d.h.image_activity_2);
        blo();
        if (com.baidu.tbadk.core.util.g.acb()) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
        this.gAO = d.xM((String) v.c(this.gBc, this.mIndex));
        if (d.xN((String) v.c(this.gBc, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        j(this.gAO, this.mIsSeeHost, false);
        MessageManager.getInstance().registerListener(this.gBA);
        registerListener(this.bND);
        registerListener(this.bNE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, boolean z, boolean z2) {
        this.gBe = new e(this.gBc, this.ceA, this.ele, this.fjU, this.ctx, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.gBe.setSourceImageRectInScreen(this.gAN);
        this.gBe.lP(this.gBb);
        this.gBe.lQ(z);
        this.gBe.xO(this.gAO);
        this.gBe.lO(this.gAP);
        this.gBe.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.gBa != null) {
                    if (ImageViewerActivity.this.gBl) {
                        if (!z5) {
                            ImageViewerActivity.this.gBa.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(d.j.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.gBl = false;
                    if (ImageViewerActivity.this.gAZ != null) {
                        ImageViewerActivity.this.gAZ.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.gBa.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.gBa.getItemNum();
                        ImageViewerActivity.this.gBa.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.gBa.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.gBa.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.gBi != null) {
                        ImageViewerActivity.this.gBi.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.gBa.setUrlData(arrayList);
                    ImageViewerActivity.this.gBa.setAssistUrls(ImageViewerActivity.this.ceA);
                    ImageViewerActivity.this.gBa.setHasNext(z3);
                    ImageViewerActivity.this.gBa.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.gBa.getItemNum()) {
                        ImageViewerActivity.this.gBa.jd(ImageViewerActivity.this.gBa.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.gBa.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList.size() >= 400 && ImageViewerActivity.this.gBa.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.gBa.setUrlData(arrayList);
                        ImageViewerActivity.this.gBa.setCurrentItem(ImageViewerActivity.this.gBa.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.byA();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.gBa.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.gBi.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.gBi.bxW()) {
                    ImageViewerActivity.this.gBa.setAddSize(1);
                } else {
                    ImageViewerActivity.this.gBa.setAddSize(0);
                }
            }

            @Override // com.baidu.tieba.image.e.b
            public void am(int i, String str2) {
                ImageViewerActivity.this.gBl = false;
                if (ImageViewerActivity.this.gAZ != null) {
                    ImageViewerActivity.this.gAZ.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.gBc.size();
                    ImageViewerActivity.this.byA();
                }
            }
        });
        this.gBe.lR(true);
        this.gBe.bym();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.gBd = new a(this.gBa.getCurrentImageUrl(), this.gBa.getCurrentImageData());
            this.gBd.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gBa.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.gBa.hN(i);
        super.onChangeSkinType(i);
        this.gBn = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gBa.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gBa.onResume();
        this.mIsLogin = com.baidu.tbadk.n.a.isLogin();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.gBa.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gBA);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.anq().anr();
        this.gBf.e(this.gBc, this.mIndex, this.mIndex);
        this.gBf.byJ();
        String str = "";
        if (this.gBi != null) {
            str = this.gBi.getAdId();
        }
        this.gBf.d(this.gBa.getPageCount(), str, this.ele, this.ctx);
        this.gBa.onDestroy();
        if (this.gBd != null) {
            this.gBd.cancel();
            this.gBd = null;
        }
        com.baidu.tbadk.download.d.alN().jq(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.gBn);
        if (this.gBq != null) {
            this.gBq.aSr();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Intent intent = new Intent();
            intent.putExtra("index", this.mIndex);
            setResult(-1, intent);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void blo() {
        this.mStatusBarView = findViewById(d.g.statusbar_view);
        aBB();
        initViewPager();
        byA();
        aXo();
        byE();
        this.gBf.e(this.gBc, this.mIndex, this.mIndex);
    }

    private void aBB() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.gAZ = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(d.g.see_host_image_txt);
        if (this.gBs) {
            setViewVisibility(this.gAZ, 8);
        }
        if (this.gBm) {
            if (this.mIsSeeHost) {
                this.gAZ.setText(d.j.album_all_thread);
            } else {
                this.gAZ.setText(d.j.view_host);
            }
            this.gAZ.setOnClickListener(this.gBB);
        } else {
            setViewVisibility(this.gAZ, 8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, d.C0236d.transparent));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, d.C0236d.cp_btn_a));
        this.mTitleView.setTextSize(0, l.h(this, d.e.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, d.C0236d.cp_mask_d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long byz() {
        ImageUrlData imageUrlData;
        String str = (String) v.c(this.gBc, this.mIndex);
        if (this.ceA == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.ceA.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byA() {
        String str;
        if (this.gBc != null) {
            String str2 = ("" + byz()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (this.mFrom != null && !this.gBt && byz() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new am("c13316").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom));
                this.gBt = true;
            }
            if (byB()) {
                byC();
            } else {
                xP(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean byB() {
        if (this.gBh && this.gBi != null && this.gBi.bxW()) {
            return this.gBa.getItemNum() != 1 && this.mIndex == this.gBa.getItemNum() + (-1);
        }
        return false;
    }

    private void xP(String str) {
        this.mTitleView.setText(str);
        if (this.gBm && !this.gBs) {
            if (this.mIsSeeHost) {
                this.gAZ.setText(d.j.album_all_thread);
            } else {
                this.gAZ.setText(d.j.view_host);
            }
        }
    }

    private void byC() {
        this.mTitleView.setText("");
        setViewVisibility(this.gAZ, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.gBa == null) {
            this.gBa = (MultiImageView) findViewById(d.g.viewpager);
        } else {
            this.gBa.init();
        }
        this.gBa.setIsFromCDN(this.cdq);
        this.gBa.setIsCanDrag(this.cds);
        this.gBa.setIsHotSort(this.cdt);
        this.gBa.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.gBa.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.gBa.setOnPageChangeListener(this.bUY);
        this.gBa.setUrlData(this.gBc);
        this.gBa.setAssistUrls(this.ceA);
        this.gBa.setOuterOnTouchListener(this.cfr);
        this.gBa.setItemOnclickListener(this.mOnClickListener);
        this.gBa.setItemOnLongClickListener(this.gBJ);
        this.gBa.setCurrentItem(bpw(), false);
        this.gBa.setOnScrollOutListener(this.gBK);
        this.gBi = new com.baidu.tieba.image.a(this.cdq, this.gBh, getPageContext(), this.ele, this.ctx);
        this.gBi.setDragToExitListener(this.cfe);
        this.gBa.a(this.gBi);
        this.gBa.setOriImgSelectedCallback(this.cdi);
        this.gBa.setDragToExitListener(this.cfe);
        this.gBa.setUserId(this.mUserId);
        this.gBa.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.gBo = ImageViewerActivity.this.gBp - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.gBp = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        TiebaStatic.log(new am("c13340").bJ("uid", this.mUserId).bJ("post_id", this.ctx).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, byD()));
    }

    private int byD() {
        if (StringUtils.isNULL(this.mFrom)) {
            return 7;
        }
        if (this.mFrom.equals("pb")) {
            return 5;
        }
        if (this.mFrom.equals("frs")) {
            return 3;
        }
        return this.mFrom.equals("index") ? 1 : 7;
    }

    private void byE() {
        if (this.eiR == null) {
            this.eiS = new com.baidu.tbadk.core.dialog.i(this);
        }
        if (this.eiW == null) {
            this.eiW = new ArrayList();
        }
        byF();
        this.eiR = new com.baidu.tbadk.core.dialog.g(getPageContext(), this.eiS.abk());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byF() {
        this.eiW.clear();
        String je = this.gBa.je(bpw());
        if (je != null) {
            this.gBv = new com.baidu.tbadk.core.dialog.f(je, this.eiS);
            this.gBv.a(this.gBC);
            this.eiW.add(this.gBv);
        }
        this.gBx = new com.baidu.tbadk.core.dialog.f(getString(d.j.save_to_local), this.eiS);
        this.gBx.a(this.gBF);
        this.eiW.add(this.gBx);
        this.gBy = new com.baidu.tbadk.core.dialog.f(getString(d.j.save_to_emotion), this.eiS);
        this.gBy.a(this.gBE);
        this.eiW.add(this.gBy);
        this.gBw = new com.baidu.tbadk.core.dialog.f(getString(d.j.identify_image), this.eiS);
        this.gBw.a(this.gBD);
        this.eiW.add(this.gBw);
        this.gBz = new com.baidu.tbadk.core.dialog.f(getString(d.j.image_share), this.eiS);
        this.gBz.a(this.gBG);
        this.eiW.add(this.gBz);
        this.eiS.a(new i.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.19
            @Override // com.baidu.tbadk.core.dialog.i.a
            public void onClick() {
                ImageViewerActivity.this.aQA();
            }
        });
        this.eiS.P(this.eiW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQA() {
        if (this.eiR != null && this.eiR.isShowing()) {
            this.eiR.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show() {
        if (this.eiR != null && !isFinishing()) {
            this.eiR.showDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uE(int i) {
        TiebaStatic.log(new am("c13270").bJ("uid", this.mUserId).T(VideoPlayActivityConfig.OBJ_ID, i));
    }

    private void aXo() {
        if (!this.gBs) {
            if (this.gBq == null) {
                this.gBq = new com.baidu.tieba.c.d(getPageContext(), this.gAZ);
                this.gBq.oK(d.f.pic_sign_tip);
                this.gBq.oJ(48);
                this.gBq.aa(true);
                this.gBq.oL(5000);
                this.gBq.oN(-l.h(getPageContext().getPageActivity(), d.e.tbds26));
                this.gBq.o(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ImageViewerActivity.this.gBq != null) {
                            ImageViewerActivity.this.gBq.aSr();
                        }
                    }
                });
            }
            this.gBq.cu(getPageContext().getString(d.j.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bpw() {
        int S = v.S(this.gBc);
        if (S > 0) {
            if (this.mIndex >= S) {
                this.mIndex = S - 1;
            } else if (this.mIndex < 0) {
                this.mIndex = 0;
            }
        } else {
            this.mIndex = 0;
        }
        return this.mIndex;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: java.util.Map<java.lang.String, com.baidu.tbadk.coreExtra.view.ImageUrlData> */
    /* JADX WARN: Multi-variable type inference failed */
    private void initData(Bundle bundle) {
        ImageUrlData imageUrlData;
        this.gBf = new i();
        boolean isLogin = com.baidu.tbadk.n.a.isLogin();
        String bduss = com.baidu.tbadk.n.a.getBduss();
        String tbs = com.baidu.tbadk.n.a.getTbs();
        String stoken = com.baidu.tbadk.n.a.getStoken();
        if (bundle != null) {
            this.gBu = bundle.getBoolean(ImageViewerConfig.ABTEST);
            this.gBc = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.ele = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.ctx = bundle.getString("tid");
            this.fjU = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.cdq = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.gBb = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.gBh = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.cds = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.cdt = bundle.getBoolean(ImageViewerConfig.IS_HOT_SORT, false);
            this.gBm = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.gAN = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            this.gAP = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            if (serializable instanceof Map) {
                this.ceA = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.ceA.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.gBr = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.gBs = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.gBu = intent.getBooleanExtra(ImageViewerConfig.ABTEST, false);
                this.gBc = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.ele = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.ctx = intent.getStringExtra("tid");
                this.fjU = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.cdq = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.gBb = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.gBh = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.cds = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.cdt = intent.getBooleanExtra(ImageViewerConfig.IS_HOT_SORT, false);
                this.gBm = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.gBr = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.gBs = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.gAN = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                this.gAP = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.ceA = (Map) serializableExtra;
                }
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.n.a.eV(isLogin);
        com.baidu.tbadk.n.a.pr(bduss);
        com.baidu.tbadk.n.a.setStoken(stoken);
        com.baidu.tbadk.n.a.setTbs(tbs);
        this.gBf.b(bundle, getIntent());
        this.mCount = v.S(this.gBc);
        if (this.gAN != null) {
            String str = (String) v.c(this.gBc, this.mIndex);
            if (!StringUtils.isNull(str) && this.ceA != null && (imageUrlData = this.ceA.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.gAN);
            }
        }
        if (this.mIsSeeHost) {
            TiebaStatic.log(new am("c13337").bJ("obj_type", "2"));
        } else {
            TiebaStatic.log(new am("c13337").bJ("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.ABTEST, this.gBu);
        bundle.putStringArrayList("url", this.gBc);
        bundle.putInt("index", this.mIndex);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.ele);
        bundle.putString("tid", this.ctx);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.fjU);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.gBb);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.cds);
        bundle.putBoolean(ImageViewerConfig.IS_HOT_SORT, this.cdt);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.gBm);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.gBh);
        bundle.putString("user_id", this.mUserId);
        if (this.ceA instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.ceA.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.ceA instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.ceA.entrySet()) {
                if (entry2 != null && (entry2.getValue() instanceof ImageUrlData) && (entry2.getKey() instanceof String)) {
                    try {
                        concurrentHashMap.put(entry2.getKey(), OrmObject.jsonStrWithObject(entry2.getValue()));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, concurrentHashMap);
        }
        bundle.putString("from", this.mFrom);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(ImageViewerConfig.SEE_HOST, this.mIsSeeHost);
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.gAN);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.gBr);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.gBs);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.gAP);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.n.a.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.n.a.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.n.a.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.n.a.getTbs());
        this.gBf.Y(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.gBa.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        byte[] mData;
        String mUrl;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.mData = null;
            this.mUrl = str;
            this.mData = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            ImageUrlData imageUrlData;
            String mK;
            if (this.mUrl != null && ImageViewerActivity.this.ceA != null) {
                Iterator it = ImageViewerActivity.this.ceA.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        imageUrlData = null;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (entry != null && entry.getKey() != null && entry.getValue() != null && ((String) entry.getKey()).contains(this.mUrl)) {
                        imageUrlData = (ImageUrlData) entry.getValue();
                        break;
                    }
                }
                if (imageUrlData != null) {
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ao.adk().mB(mK) + "/" + as.mK(imageUrlData.originalUrl);
                    int[] me = m.me(str);
                    if (me != null && me.length == 2 && me[0] > 0 && m.e(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
                        return ImageViewerActivity.this.getPageContext().getString(d.j.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (m.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                    case -2:
                        return m.ace();
                    case 0:
                        return ImageViewerActivity.this.getPageContext().getString(d.j.save_image_to_album);
                }
            }
            return ImageViewerActivity.this.getPageContext().getString(d.j.save_fail);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            ImageViewerActivity.this.showToast(str);
            ImageViewerActivity.this.gBd = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.gBd = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uF(int i) {
        if (this.gBa != null) {
            this.gBa.jc(i);
            setViewVisibility(this.gAZ, (this.gBa.akp() || byB()) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byG() {
        if (byB()) {
            this.gBk = this.mNavigationBar.getVisibility() == 0;
            this.gBj = true;
        } else if (this.gBj) {
            this.mNavigationBar.setVisibility(this.gBk ? 0 : 8);
            this.gBj = false;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a008";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean aoL() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int aoM() {
                return com.baidu.tbadk.pageStayDuration.e.aoQ().aoT();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.ele, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.ctx, 0L));
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.coreExtra.view.a
    public boolean akh() {
        return this.gBu;
    }
}
