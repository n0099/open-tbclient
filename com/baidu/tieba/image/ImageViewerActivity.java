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
import com.baidu.mapapi.UIMsg;
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
/* loaded from: classes3.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> implements com.baidu.tbadk.coreExtra.view.a {
    private boolean cds;
    private boolean cdu;
    private boolean cdv;
    private Map<String, ImageUrlData> ceC;
    private String ctw;
    private com.baidu.tbadk.core.dialog.i eiA;
    private com.baidu.tbadk.core.dialog.g eiz;
    private String ekM;
    private String fjF;
    private String gAA;
    private String gAB;
    private TextView gAN;
    private MultiImageView gAO;
    private ArrayList<String> gAQ;
    private a gAR;
    private e gAS;
    private i gAT;
    private boolean gAZ;
    private boolean gBa;
    private int gBb;
    private boolean gBc;
    private float gBd;
    private com.baidu.tieba.c.d gBe;
    private boolean gBf;
    private boolean gBg;
    private com.baidu.tbadk.core.dialog.f gBj;
    private com.baidu.tbadk.core.dialog.f gBk;
    private com.baidu.tbadk.core.dialog.f gBl;
    private com.baidu.tbadk.core.dialog.f gBm;
    private com.baidu.tbadk.core.dialog.f gBn;
    private float gBv;
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
    private boolean gAP = true;
    private boolean gAU = false;
    private boolean gAV = true;
    private com.baidu.tieba.image.a gAW = null;
    private boolean gAX = false;
    private boolean gAY = false;
    private boolean coz = false;
    private int Us = 0;
    private boolean gBh = false;
    private boolean gAC = false;
    private boolean gBi = false;
    private List<com.baidu.tbadk.core.dialog.f> eiE = null;
    private final CustomMessageListener gBo = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null && !StringUtils.isNull(kVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(kVar);
                if (StringUtils.isNull(kVar.chw)) {
                    ba.adA().c(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    ba.adA().c(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.chw});
                }
            }
        }
    };
    private DragImageView.d cfg = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void aqP() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gAN, 8);
            if (ImageViewerActivity.this.gAO != null) {
                ImageViewerActivity.this.gAO.eu(false);
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void aqQ() {
            TiebaStatic.log(new am("c13341").T("obj_param1", ImageViewerActivity.this.gAO.getItemNum()).T("obj_param2", ImageViewerActivity.this.gAO.getCurrentMaxIndex()));
            TiebaStatic.log(new am("c13377").bJ("obj_type", "2"));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void aqR() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 0);
            if (ImageViewerActivity.this.gAO != null && !ImageViewerActivity.this.gAO.akl()) {
                ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gAN, 0);
                ImageViewerActivity.this.gAO.eu(true);
            }
        }
    };
    private UrlDragImageView.b cdk = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void akF() {
            TiebaStatic.log(new am("c10351").bJ("tid", ImageViewerActivity.this.ctw).bJ("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final View.OnClickListener gBp = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                ImageViewerActivity.this.showToast(d.j.neterror);
                return;
            }
            TiebaStatic.log(new am("pb_onlyowner_click").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).T("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
            TiebaStatic.log(new am("c13338").T("obj_locate", ImageViewerActivity.this.mIsSeeHost ? 1 : 2));
            ImageViewerActivity.this.gAZ = true;
            if (ImageViewerActivity.this.gAN != null) {
                ImageViewerActivity.this.gAN.setEnabled(false);
            }
            ImageViewerActivity.this.j(d.xK((String) v.c(ImageViewerActivity.this.gAQ, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
        }
    };
    private i.b gBq = new i.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            ImageViewerActivity.this.gAO.je(ImageViewerActivity.this.bpt());
            ImageViewerActivity.this.aQy();
        }
    };
    private i.b gBr = new i.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            g.aL(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.gAO.getCurrentImageUrl());
            ImageViewerActivity.this.aQy();
            ImageViewerActivity.this.uA(1);
        }
    };
    private i.b gBs = new i.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            String currentImageUrl = ImageViewerActivity.this.gAO.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.cmE);
                intent.putExtra(com.baidu.tbadk.imageManager.d.cmF, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            ImageViewerActivity.this.aQy();
            ImageViewerActivity.this.uA(2);
        }
    };
    private i.b gBt = new i.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
            if (ImageViewerActivity.this.mPermissionJudgement == null) {
                ImageViewerActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            ImageViewerActivity.this.mPermissionJudgement.adN();
            ImageViewerActivity.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!ImageViewerActivity.this.mPermissionJudgement.Y(pageActivity)) {
                ImageViewerActivity.this.saveImage();
                ImageViewerActivity.this.aQy();
                ImageViewerActivity.this.uA(3);
            }
        }
    };
    private i.b gBu = new i.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            UrlDragImageView currentUrlDragImageView;
            if (ImageViewerActivity.this.gAO != null && (currentUrlDragImageView = ImageViewerActivity.this.gAO.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.d.c.mL(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = ImageViewerActivity.this.gAO.getCurrentImageUrl();
                    str2 = as.mL(str);
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
                    bundle.putString("path", TbConfig.IMAGE_CACHE_DIR_NAME);
                    bundle.putString("name", str2);
                    bundle.putBoolean("formatData", true);
                    bundle.putBoolean("isSubDir", true);
                    bundle.putBoolean("isSdcard", false);
                    bundle.putBoolean("isSavedCache", true);
                    dVar.cbx = bundle;
                }
                ImageViewerActivity.this.sendMessage(new CustomMessage(2001276, new ShareDialogConfig(ImageViewerActivity.this.getActivity(), dVar, false)));
                ImageViewerActivity.this.aQy();
                ImageViewerActivity.this.uA(4);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (ImageViewerActivity.this.gBi && ImageViewerActivity.this.gAO != null) {
                boolean akl = ImageViewerActivity.this.gAO.akl();
                if (!akl) {
                    com.baidu.tieba.t.a.G(ImageViewerActivity.this.gAN, 100);
                    i = 1;
                } else {
                    com.baidu.tieba.t.a.H(ImageViewerActivity.this.gAN, 100);
                    i = 2;
                }
                ImageViewerActivity.this.gAO.g(akl ? false : true, 100);
                TiebaStatic.log(new am("c13397").T("obj_type", i));
                return;
            }
            TiebaStatic.log(new am("c13341").T("obj_param1", ImageViewerActivity.this.gAO.getItemNum()).T("obj_param2", ImageViewerActivity.this.gAO.getCurrentMaxIndex()));
            TiebaStatic.log(new am("c13377").bJ("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean gBw = true;
    private View.OnTouchListener cft = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.gBv = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.gBw = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.gBv = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.gBw = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener gBx = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.byC();
            ImageViewerActivity.this.show();
            TiebaStatic.log(new am("c13269").bJ("uid", ImageViewerActivity.this.mUserId).bJ(ImageViewerConfig.FORUM_ID, ImageViewerActivity.this.ekM).bJ("tid", ImageViewerActivity.this.ctw));
            return true;
        }
    };
    private BaseViewPager.a gBy = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void hE(int i) {
            if (i == 0) {
                ImageViewerActivity.this.gAS.byj();
            } else if (ImageViewerActivity.this.byw() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.gAS.byk();
            }
        }
    };
    private ViewPager.OnPageChangeListener bVb = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.gAS != null && i > ImageViewerActivity.this.gAO.getItemNum() - 5) {
                ImageViewerActivity.this.gAS.byj();
            }
            ImageViewerActivity.this.gAT.e(ImageViewerActivity.this.gAQ, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.byx();
            ImageViewerActivity.this.byD();
            ImageViewerActivity.this.uB(i);
            if (ImageViewerActivity.this.gAT.byE() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.gAT.uC(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.gAT.byF() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.gAT.uD(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.byy()) {
                ImageViewerActivity.this.gAW.bxX();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.gAO.getItemNum() - 1) {
                ImageViewerActivity.this.gAU = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.Us) {
                ImageViewerActivity.this.Us = i;
                ImageViewerActivity.this.coz = true;
            } else if (i < ImageViewerActivity.this.Us) {
                ImageViewerActivity.this.Us = i;
                ImageViewerActivity.this.coz = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.gAQ != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.gAQ.size()) {
                ImageViewerActivity.this.gAT.ap(i, (String) ImageViewerActivity.this.gAQ.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.gAO.getItemNum() - 1) {
                if (!ImageViewerActivity.this.gBw || !ImageViewerActivity.this.gBc || (!ImageViewerActivity.this.gAU && !ImageViewerActivity.this.byy() && (ImageViewerActivity.this.gAO.getItemNum() != 1 || !ImageViewerActivity.this.coz))) {
                    ImageViewerActivity.this.gAU = true;
                } else {
                    ImageViewerActivity.this.showToast(d.j.last_page);
                }
            }
        }
    };
    private CustomMessageListener bNG = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.ceC != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.ceC.values()) {
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
    private CustomMessageListener bNH = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.ceC != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.ceC.values()) {
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
        this.gBb = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(d.h.image_activity_2);
        bll();
        if (com.baidu.tbadk.core.util.g.abY()) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
        this.gAB = d.xK((String) v.c(this.gAQ, this.mIndex));
        if (d.xL((String) v.c(this.gAQ, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        j(this.gAB, this.mIsSeeHost, false);
        MessageManager.getInstance().registerListener(this.gBo);
        registerListener(this.bNG);
        registerListener(this.bNH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, boolean z, boolean z2) {
        this.gAS = new e(this.gAQ, this.ceC, this.ekM, this.fjF, this.ctw, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.gAS.setSourceImageRectInScreen(this.gAA);
        this.gAS.lP(this.gAP);
        this.gAS.lQ(z);
        this.gAS.xM(this.gAB);
        this.gAS.lO(this.gAC);
        this.gAS.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.gAO != null) {
                    if (ImageViewerActivity.this.gAZ) {
                        if (!z5) {
                            ImageViewerActivity.this.gAO.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(d.j.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.gAZ = false;
                    if (ImageViewerActivity.this.gAN != null) {
                        ImageViewerActivity.this.gAN.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.gAO.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.gAO.getItemNum();
                        ImageViewerActivity.this.gAO.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.gAO.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.gAO.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.gAW != null) {
                        ImageViewerActivity.this.gAW.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.gAO.setUrlData(arrayList);
                    ImageViewerActivity.this.gAO.setAssistUrls(ImageViewerActivity.this.ceC);
                    ImageViewerActivity.this.gAO.setHasNext(z3);
                    ImageViewerActivity.this.gAO.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.gAO.getItemNum()) {
                        ImageViewerActivity.this.gAO.jc(ImageViewerActivity.this.gAO.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.gAO.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList.size() >= 400 && ImageViewerActivity.this.gAO.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.gAO.setUrlData(arrayList);
                        ImageViewerActivity.this.gAO.setCurrentItem(ImageViewerActivity.this.gAO.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.byx();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.gAO.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.gAW.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.gAW.bxT()) {
                    ImageViewerActivity.this.gAO.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.q.a.b("a008", "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.gAO.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void ao(int i, String str2) {
                ImageViewerActivity.this.gAZ = false;
                if (ImageViewerActivity.this.gAN != null) {
                    ImageViewerActivity.this.gAN.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.gAQ.size();
                    ImageViewerActivity.this.byx();
                }
            }
        });
        this.gAS.lR(true);
        this.gAS.byj();
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
            this.gAR = new a(this.gAO.getCurrentImageUrl(), this.gAO.getCurrentImageData());
            this.gAR.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gAO.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.gAO.hM(i);
        super.onChangeSkinType(i);
        this.gBb = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gAO.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gAO.onResume();
        this.mIsLogin = com.baidu.tbadk.n.a.isLogin();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.gAO.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gBo);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.anm().ann();
        this.gAT.e(this.gAQ, this.mIndex, this.mIndex);
        this.gAT.byG();
        String str = "";
        if (this.gAW != null) {
            str = this.gAW.getAdId();
        }
        this.gAT.d(this.gAO.getPageCount(), str, this.ekM, this.ctw);
        this.gAO.onDestroy();
        if (this.gAR != null) {
            this.gAR.cancel();
            this.gAR = null;
        }
        com.baidu.tbadk.download.d.alJ().jp(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.gBb);
        if (this.gBe != null) {
            this.gBe.aSp();
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

    private void bll() {
        this.mStatusBarView = findViewById(d.g.statusbar_view);
        aBy();
        initViewPager();
        byx();
        aXm();
        byB();
        this.gAT.e(this.gAQ, this.mIndex, this.mIndex);
    }

    private void aBy() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.gAN = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(d.g.see_host_image_txt);
        if (this.gBg) {
            setViewVisibility(this.gAN, 8);
        }
        if (this.gBa) {
            if (this.mIsSeeHost) {
                this.gAN.setText(d.j.album_all_thread);
            } else {
                this.gAN.setText(d.j.view_host);
            }
            this.gAN.setOnClickListener(this.gBp);
        } else {
            setViewVisibility(this.gAN, 8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, d.C0277d.transparent));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, d.C0277d.cp_btn_a));
        this.mTitleView.setTextSize(0, l.h(this, d.e.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, d.C0277d.cp_mask_d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long byw() {
        ImageUrlData imageUrlData;
        String str = (String) v.c(this.gAQ, this.mIndex);
        if (this.ceC == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.ceC.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byx() {
        String str;
        if (this.gAQ != null) {
            String str2 = ("" + byw()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (this.mFrom != null && !this.gBh && byw() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new am("c13316").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom));
                this.gBh = true;
            }
            if (byy()) {
                byz();
            } else {
                xN(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean byy() {
        if (this.gAV && this.gAW != null && this.gAW.bxT()) {
            return this.gAO.getItemNum() != 1 && this.mIndex == this.gAO.getItemNum() + (-1);
        }
        return false;
    }

    private void xN(String str) {
        this.mTitleView.setText(str);
        if (this.gBa && !this.gBg) {
            if (this.mIsSeeHost) {
                this.gAN.setText(d.j.album_all_thread);
            } else {
                this.gAN.setText(d.j.view_host);
            }
        }
    }

    private void byz() {
        this.mTitleView.setText("");
        setViewVisibility(this.gAN, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.gAO == null) {
            this.gAO = (MultiImageView) findViewById(d.g.viewpager);
        } else {
            this.gAO.init();
        }
        this.gAO.setIsFromCDN(this.cds);
        this.gAO.setIsCanDrag(this.cdu);
        this.gAO.setIsHotSort(this.cdv);
        this.gAO.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.gAO.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.gAO.setOnPageChangeListener(this.bVb);
        this.gAO.setUrlData(this.gAQ);
        this.gAO.setAssistUrls(this.ceC);
        this.gAO.setOuterOnTouchListener(this.cft);
        this.gAO.setItemOnclickListener(this.mOnClickListener);
        this.gAO.setItemOnLongClickListener(this.gBx);
        this.gAO.setCurrentItem(bpt(), false);
        this.gAO.setOnScrollOutListener(this.gBy);
        this.gAW = new com.baidu.tieba.image.a(this.cds, this.gAV, getPageContext(), this.ekM, this.ctw);
        this.gAW.setDragToExitListener(this.cfg);
        this.gAO.a(this.gAW);
        this.gAO.setOriImgSelectedCallback(this.cdk);
        this.gAO.setDragToExitListener(this.cfg);
        this.gAO.setUserId(this.mUserId);
        this.gAO.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.gBc = ImageViewerActivity.this.gBd - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.gBd = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        TiebaStatic.log(new am("c13340").bJ("uid", this.mUserId).bJ("post_id", this.ctw).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, byA()));
    }

    private int byA() {
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

    private void byB() {
        if (this.eiz == null) {
            this.eiA = new com.baidu.tbadk.core.dialog.i(this);
        }
        if (this.eiE == null) {
            this.eiE = new ArrayList();
        }
        byC();
        this.eiz = new com.baidu.tbadk.core.dialog.g(getPageContext(), this.eiA.abh());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byC() {
        this.eiE.clear();
        String jd = this.gAO.jd(bpt());
        if (jd != null) {
            this.gBj = new com.baidu.tbadk.core.dialog.f(jd, this.eiA);
            this.gBj.a(this.gBq);
            this.eiE.add(this.gBj);
        }
        this.gBl = new com.baidu.tbadk.core.dialog.f(getString(d.j.save_to_local), this.eiA);
        this.gBl.a(this.gBt);
        this.eiE.add(this.gBl);
        this.gBm = new com.baidu.tbadk.core.dialog.f(getString(d.j.save_to_emotion), this.eiA);
        this.gBm.a(this.gBs);
        this.eiE.add(this.gBm);
        this.gBk = new com.baidu.tbadk.core.dialog.f(getString(d.j.identify_image), this.eiA);
        this.gBk.a(this.gBr);
        this.eiE.add(this.gBk);
        this.gBn = new com.baidu.tbadk.core.dialog.f(getString(d.j.image_share), this.eiA);
        this.gBn.a(this.gBu);
        this.eiE.add(this.gBn);
        this.eiA.a(new i.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.19
            @Override // com.baidu.tbadk.core.dialog.i.a
            public void onClick() {
                ImageViewerActivity.this.aQy();
            }
        });
        this.eiA.P(this.eiE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQy() {
        if (this.eiz != null && this.eiz.isShowing()) {
            this.eiz.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show() {
        if (this.eiz != null && !isFinishing()) {
            this.eiz.showDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uA(int i) {
        TiebaStatic.log(new am("c13270").bJ("uid", this.mUserId).T(VideoPlayActivityConfig.OBJ_ID, i));
    }

    private void aXm() {
        if (!this.gBg) {
            if (this.gBe == null) {
                this.gBe = new com.baidu.tieba.c.d(getPageContext(), this.gAN);
                this.gBe.oG(d.f.pic_sign_tip);
                this.gBe.oF(48);
                this.gBe.aa(true);
                this.gBe.oH(UIMsg.m_AppUI.MSG_APP_GPS);
                this.gBe.oJ(-l.h(getPageContext().getPageActivity(), d.e.tbds26));
                this.gBe.o(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ImageViewerActivity.this.gBe != null) {
                            ImageViewerActivity.this.gBe.aSp();
                        }
                    }
                });
            }
            this.gBe.cv(getPageContext().getString(d.j.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bpt() {
        int S = v.S(this.gAQ);
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
        this.gAT = new i();
        boolean isLogin = com.baidu.tbadk.n.a.isLogin();
        String bduss = com.baidu.tbadk.n.a.getBduss();
        String tbs = com.baidu.tbadk.n.a.getTbs();
        String stoken = com.baidu.tbadk.n.a.getStoken();
        if (bundle != null) {
            this.gBi = bundle.getBoolean(ImageViewerConfig.ABTEST);
            this.gAQ = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.ekM = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.ctw = bundle.getString("tid");
            this.fjF = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.cds = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.gAP = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.gAV = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.cdu = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.cdv = bundle.getBoolean(ImageViewerConfig.IS_HOT_SORT, false);
            this.gBa = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.gAA = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            this.gAC = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            if (serializable instanceof Map) {
                this.ceC = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.ceC.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.gBf = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.gBg = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.gBi = intent.getBooleanExtra(ImageViewerConfig.ABTEST, false);
                this.gAQ = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.ekM = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.ctw = intent.getStringExtra("tid");
                this.fjF = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.cds = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.gAP = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.gAV = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.cdu = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.cdv = intent.getBooleanExtra(ImageViewerConfig.IS_HOT_SORT, false);
                this.gBa = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.gBf = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.gBg = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.gAA = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                this.gAC = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.ceC = (Map) serializableExtra;
                }
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.n.a.eV(isLogin);
        com.baidu.tbadk.n.a.ps(bduss);
        com.baidu.tbadk.n.a.setStoken(stoken);
        com.baidu.tbadk.n.a.setTbs(tbs);
        this.gAT.b(bundle, getIntent());
        this.mCount = v.S(this.gAQ);
        if (this.gAA != null) {
            String str = (String) v.c(this.gAQ, this.mIndex);
            if (!StringUtils.isNull(str) && this.ceC != null && (imageUrlData = this.ceC.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.gAA);
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
        bundle.putBoolean(ImageViewerConfig.ABTEST, this.gBi);
        bundle.putStringArrayList("url", this.gAQ);
        bundle.putInt("index", this.mIndex);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.ekM);
        bundle.putString("tid", this.ctw);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.fjF);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.gAP);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.cdu);
        bundle.putBoolean(ImageViewerConfig.IS_HOT_SORT, this.cdv);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.gBa);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.gAV);
        bundle.putString("user_id", this.mUserId);
        if (this.ceC instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.ceC.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.ceC instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.ceC.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.gAA);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.gBf);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.gBg);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.gAC);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.n.a.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.n.a.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.n.a.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.n.a.getTbs());
        this.gAT.Y(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.gAO.setCurrentItem(this.mIndex, false);
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
            String mL;
            if (this.mUrl != null && ImageViewerActivity.this.ceC != null) {
                Iterator it = ImageViewerActivity.this.ceC.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ao.adh().mC(mL) + "/" + as.mL(imageUrlData.originalUrl);
                    int[] mf = m.mf(str);
                    if (mf != null && mf.length == 2 && mf[0] > 0 && m.e(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
                        return ImageViewerActivity.this.getPageContext().getString(d.j.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (m.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                    case -2:
                        return m.acb();
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
            ImageViewerActivity.this.gAR = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.gAR = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uB(int i) {
        if (this.gAO != null) {
            this.gAO.jb(i);
            setViewVisibility(this.gAN, (this.gAO.akl() || byy()) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byD() {
        if (byy()) {
            this.gAY = this.mNavigationBar.getVisibility() == 0;
            this.gAX = true;
        } else if (this.gAX) {
            this.mNavigationBar.setVisibility(this.gAY ? 0 : 8);
            this.gAX = false;
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
            public boolean aoH() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int aoI() {
                return com.baidu.tbadk.pageStayDuration.e.aoM().aoP();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.ekM, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.ctw, 0L));
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.coreExtra.view.a
    public boolean akd() {
        return this.gBi;
    }
}
