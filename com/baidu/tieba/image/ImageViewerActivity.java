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
    private String gAO;
    private String gAP;
    private com.baidu.tbadk.core.dialog.f gBA;
    private float gBI;
    private TextView gBa;
    private MultiImageView gBb;
    private ArrayList<String> gBd;
    private a gBe;
    private e gBf;
    private i gBg;
    private boolean gBm;
    private boolean gBn;
    private int gBo;
    private boolean gBp;
    private float gBq;
    private com.baidu.tieba.c.d gBr;
    private boolean gBs;
    private boolean gBt;
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
    private boolean gBc = true;
    private boolean gBh = false;
    private boolean gBi = true;
    private com.baidu.tieba.image.a gBj = null;
    private boolean gBk = false;
    private boolean gBl = false;
    private boolean cox = false;
    private int Ur = 0;
    private boolean gBu = false;
    private boolean gAQ = false;
    private boolean gBv = false;
    private List<com.baidu.tbadk.core.dialog.f> eiW = null;
    private final CustomMessageListener gBB = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
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
        public void aqT() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gBa, 8);
            if (ImageViewerActivity.this.gBb != null) {
                ImageViewerActivity.this.gBb.eu(false);
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void aqU() {
            TiebaStatic.log(new am("c13341").T("obj_param1", ImageViewerActivity.this.gBb.getItemNum()).T("obj_param2", ImageViewerActivity.this.gBb.getCurrentMaxIndex()));
            TiebaStatic.log(new am("c13377").bJ("obj_type", "2"));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void aqV() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 0);
            if (ImageViewerActivity.this.gBb != null && !ImageViewerActivity.this.gBb.akp()) {
                ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gBa, 0);
                ImageViewerActivity.this.gBb.eu(true);
            }
        }
    };
    private UrlDragImageView.b cdi = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void akJ() {
            TiebaStatic.log(new am("c10351").bJ("tid", ImageViewerActivity.this.ctx).bJ("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final View.OnClickListener gBC = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                ImageViewerActivity.this.showToast(d.j.neterror);
                return;
            }
            TiebaStatic.log(new am("pb_onlyowner_click").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).T("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
            TiebaStatic.log(new am("c13338").T("obj_locate", ImageViewerActivity.this.mIsSeeHost ? 1 : 2));
            ImageViewerActivity.this.gBm = true;
            if (ImageViewerActivity.this.gBa != null) {
                ImageViewerActivity.this.gBa.setEnabled(false);
            }
            ImageViewerActivity.this.j(d.xN((String) v.c(ImageViewerActivity.this.gBd, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
        }
    };
    private i.b gBD = new i.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            ImageViewerActivity.this.gBb.jf(ImageViewerActivity.this.bpx());
            ImageViewerActivity.this.aQB();
        }
    };
    private i.b gBE = new i.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            g.aM(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.gBb.getCurrentImageUrl());
            ImageViewerActivity.this.aQB();
            ImageViewerActivity.this.uE(1);
        }
    };
    private i.b gBF = new i.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            String currentImageUrl = ImageViewerActivity.this.gBb.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.cmC);
                intent.putExtra(com.baidu.tbadk.imageManager.d.cmD, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            ImageViewerActivity.this.aQB();
            ImageViewerActivity.this.uE(2);
        }
    };
    private i.b gBG = new i.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
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
                ImageViewerActivity.this.aQB();
                ImageViewerActivity.this.uE(3);
            }
        }
    };
    private i.b gBH = new i.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            if (ImageViewerActivity.this.gBb != null) {
                if (!com.baidu.tbadk.plugins.c.b(ImageViewerActivity.this.getPageContext(), "com.baidu.tieba.pluginCore")) {
                    ImageViewerActivity.this.aQB();
                    return;
                }
                UrlDragImageView currentUrlDragImageView = ImageViewerActivity.this.gBb.getCurrentUrlDragImageView();
                if (currentUrlDragImageView != null) {
                    ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                    String str = "";
                    String str2 = "";
                    if (imageUrlData != null) {
                        str = imageUrlData.imageUrl;
                        str2 = com.baidu.tbadk.core.util.d.c.mK(str);
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = ImageViewerActivity.this.gBb.getCurrentImageUrl();
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
                    ImageViewerActivity.this.aQB();
                    ImageViewerActivity.this.uE(4);
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (ImageViewerActivity.this.gBv && ImageViewerActivity.this.gBb != null) {
                boolean akp = ImageViewerActivity.this.gBb.akp();
                if (!akp) {
                    com.baidu.tieba.t.a.G(ImageViewerActivity.this.gBa, 100);
                    i = 1;
                } else {
                    com.baidu.tieba.t.a.H(ImageViewerActivity.this.gBa, 100);
                    i = 2;
                }
                ImageViewerActivity.this.gBb.g(akp ? false : true, 100);
                TiebaStatic.log(new am("c13397").T("obj_type", i));
                return;
            }
            TiebaStatic.log(new am("c13341").T("obj_param1", ImageViewerActivity.this.gBb.getItemNum()).T("obj_param2", ImageViewerActivity.this.gBb.getCurrentMaxIndex()));
            TiebaStatic.log(new am("c13377").bJ("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean gBJ = true;
    private View.OnTouchListener cfr = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.gBI = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.gBJ = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.gBI = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.gBJ = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener gBK = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.byG();
            ImageViewerActivity.this.show();
            TiebaStatic.log(new am("c13269").bJ("uid", ImageViewerActivity.this.mUserId).bJ(ImageViewerConfig.FORUM_ID, ImageViewerActivity.this.ele).bJ("tid", ImageViewerActivity.this.ctx));
            return true;
        }
    };
    private BaseViewPager.a gBL = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void hF(int i) {
            if (i == 0) {
                ImageViewerActivity.this.gBf.byn();
            } else if (ImageViewerActivity.this.byA() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.gBf.byo();
            }
        }
    };
    private ViewPager.OnPageChangeListener bUY = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.gBf != null && i > ImageViewerActivity.this.gBb.getItemNum() - 5) {
                ImageViewerActivity.this.gBf.byn();
            }
            ImageViewerActivity.this.gBg.e(ImageViewerActivity.this.gBd, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.byB();
            ImageViewerActivity.this.byH();
            ImageViewerActivity.this.uF(i);
            if (ImageViewerActivity.this.gBg.byI() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.gBg.uG(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.gBg.byJ() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.gBg.uH(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.byC()) {
                ImageViewerActivity.this.gBj.byb();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.gBb.getItemNum() - 1) {
                ImageViewerActivity.this.gBh = false;
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
            if (ImageViewerActivity.this.gBd != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.gBd.size()) {
                ImageViewerActivity.this.gBg.an(i, (String) ImageViewerActivity.this.gBd.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.gBb.getItemNum() - 1) {
                if (!ImageViewerActivity.this.gBJ || !ImageViewerActivity.this.gBp || (!ImageViewerActivity.this.gBh && !ImageViewerActivity.this.byC() && (ImageViewerActivity.this.gBb.getItemNum() != 1 || !ImageViewerActivity.this.cox))) {
                    ImageViewerActivity.this.gBh = true;
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
        this.gBo = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(d.h.image_activity_2);
        blp();
        if (com.baidu.tbadk.core.util.g.acb()) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
        this.gAP = d.xN((String) v.c(this.gBd, this.mIndex));
        if (d.xO((String) v.c(this.gBd, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        j(this.gAP, this.mIsSeeHost, false);
        MessageManager.getInstance().registerListener(this.gBB);
        registerListener(this.bND);
        registerListener(this.bNE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, boolean z, boolean z2) {
        this.gBf = new e(this.gBd, this.ceA, this.ele, this.fjU, this.ctx, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.gBf.setSourceImageRectInScreen(this.gAO);
        this.gBf.lP(this.gBc);
        this.gBf.lQ(z);
        this.gBf.xP(this.gAP);
        this.gBf.lO(this.gAQ);
        this.gBf.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.gBb != null) {
                    if (ImageViewerActivity.this.gBm) {
                        if (!z5) {
                            ImageViewerActivity.this.gBb.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(d.j.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.gBm = false;
                    if (ImageViewerActivity.this.gBa != null) {
                        ImageViewerActivity.this.gBa.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.gBb.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.gBb.getItemNum();
                        ImageViewerActivity.this.gBb.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.gBb.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.gBb.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.gBj != null) {
                        ImageViewerActivity.this.gBj.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.gBb.setUrlData(arrayList);
                    ImageViewerActivity.this.gBb.setAssistUrls(ImageViewerActivity.this.ceA);
                    ImageViewerActivity.this.gBb.setHasNext(z3);
                    ImageViewerActivity.this.gBb.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.gBb.getItemNum()) {
                        ImageViewerActivity.this.gBb.jd(ImageViewerActivity.this.gBb.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.gBb.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList.size() >= 400 && ImageViewerActivity.this.gBb.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.gBb.setUrlData(arrayList);
                        ImageViewerActivity.this.gBb.setCurrentItem(ImageViewerActivity.this.gBb.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.byB();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.gBb.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.gBj.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.gBj.bxX()) {
                    ImageViewerActivity.this.gBb.setAddSize(1);
                } else {
                    ImageViewerActivity.this.gBb.setAddSize(0);
                }
            }

            @Override // com.baidu.tieba.image.e.b
            public void am(int i, String str2) {
                ImageViewerActivity.this.gBm = false;
                if (ImageViewerActivity.this.gBa != null) {
                    ImageViewerActivity.this.gBa.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.gBd.size();
                    ImageViewerActivity.this.byB();
                }
            }
        });
        this.gBf.lR(true);
        this.gBf.byn();
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
            this.gBe = new a(this.gBb.getCurrentImageUrl(), this.gBb.getCurrentImageData());
            this.gBe.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gBb.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.gBb.hN(i);
        super.onChangeSkinType(i);
        this.gBo = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gBb.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gBb.onResume();
        this.mIsLogin = com.baidu.tbadk.n.a.isLogin();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.gBb.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gBB);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.anq().anr();
        this.gBg.e(this.gBd, this.mIndex, this.mIndex);
        this.gBg.byK();
        String str = "";
        if (this.gBj != null) {
            str = this.gBj.getAdId();
        }
        this.gBg.d(this.gBb.getPageCount(), str, this.ele, this.ctx);
        this.gBb.onDestroy();
        if (this.gBe != null) {
            this.gBe.cancel();
            this.gBe = null;
        }
        com.baidu.tbadk.download.d.alN().jq(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.gBo);
        if (this.gBr != null) {
            this.gBr.aSs();
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

    private void blp() {
        this.mStatusBarView = findViewById(d.g.statusbar_view);
        aBC();
        initViewPager();
        byB();
        aXp();
        byF();
        this.gBg.e(this.gBd, this.mIndex, this.mIndex);
    }

    private void aBC() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.gBa = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(d.g.see_host_image_txt);
        if (this.gBt) {
            setViewVisibility(this.gBa, 8);
        }
        if (this.gBn) {
            if (this.mIsSeeHost) {
                this.gBa.setText(d.j.album_all_thread);
            } else {
                this.gBa.setText(d.j.view_host);
            }
            this.gBa.setOnClickListener(this.gBC);
        } else {
            setViewVisibility(this.gBa, 8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, d.C0236d.transparent));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, d.C0236d.cp_btn_a));
        this.mTitleView.setTextSize(0, l.h(this, d.e.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, d.C0236d.cp_mask_d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long byA() {
        ImageUrlData imageUrlData;
        String str = (String) v.c(this.gBd, this.mIndex);
        if (this.ceA == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.ceA.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byB() {
        String str;
        if (this.gBd != null) {
            String str2 = ("" + byA()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (this.mFrom != null && !this.gBu && byA() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new am("c13316").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom));
                this.gBu = true;
            }
            if (byC()) {
                byD();
            } else {
                xQ(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean byC() {
        if (this.gBi && this.gBj != null && this.gBj.bxX()) {
            return this.gBb.getItemNum() != 1 && this.mIndex == this.gBb.getItemNum() + (-1);
        }
        return false;
    }

    private void xQ(String str) {
        this.mTitleView.setText(str);
        if (this.gBn && !this.gBt) {
            if (this.mIsSeeHost) {
                this.gBa.setText(d.j.album_all_thread);
            } else {
                this.gBa.setText(d.j.view_host);
            }
        }
    }

    private void byD() {
        this.mTitleView.setText("");
        setViewVisibility(this.gBa, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.gBb == null) {
            this.gBb = (MultiImageView) findViewById(d.g.viewpager);
        } else {
            this.gBb.init();
        }
        this.gBb.setIsFromCDN(this.cdq);
        this.gBb.setIsCanDrag(this.cds);
        this.gBb.setIsHotSort(this.cdt);
        this.gBb.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.gBb.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.gBb.setOnPageChangeListener(this.bUY);
        this.gBb.setUrlData(this.gBd);
        this.gBb.setAssistUrls(this.ceA);
        this.gBb.setOuterOnTouchListener(this.cfr);
        this.gBb.setItemOnclickListener(this.mOnClickListener);
        this.gBb.setItemOnLongClickListener(this.gBK);
        this.gBb.setCurrentItem(bpx(), false);
        this.gBb.setOnScrollOutListener(this.gBL);
        this.gBj = new com.baidu.tieba.image.a(this.cdq, this.gBi, getPageContext(), this.ele, this.ctx);
        this.gBj.setDragToExitListener(this.cfe);
        this.gBb.a(this.gBj);
        this.gBb.setOriImgSelectedCallback(this.cdi);
        this.gBb.setDragToExitListener(this.cfe);
        this.gBb.setUserId(this.mUserId);
        this.gBb.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.gBp = ImageViewerActivity.this.gBq - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.gBq = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        TiebaStatic.log(new am("c13340").bJ("uid", this.mUserId).bJ("post_id", this.ctx).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, byE()));
    }

    private int byE() {
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

    private void byF() {
        if (this.eiR == null) {
            this.eiS = new com.baidu.tbadk.core.dialog.i(this);
        }
        if (this.eiW == null) {
            this.eiW = new ArrayList();
        }
        byG();
        this.eiR = new com.baidu.tbadk.core.dialog.g(getPageContext(), this.eiS.abk());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byG() {
        this.eiW.clear();
        String je = this.gBb.je(bpx());
        if (je != null) {
            this.gBw = new com.baidu.tbadk.core.dialog.f(je, this.eiS);
            this.gBw.a(this.gBD);
            this.eiW.add(this.gBw);
        }
        this.gBy = new com.baidu.tbadk.core.dialog.f(getString(d.j.save_to_local), this.eiS);
        this.gBy.a(this.gBG);
        this.eiW.add(this.gBy);
        this.gBz = new com.baidu.tbadk.core.dialog.f(getString(d.j.save_to_emotion), this.eiS);
        this.gBz.a(this.gBF);
        this.eiW.add(this.gBz);
        this.gBx = new com.baidu.tbadk.core.dialog.f(getString(d.j.identify_image), this.eiS);
        this.gBx.a(this.gBE);
        this.eiW.add(this.gBx);
        this.gBA = new com.baidu.tbadk.core.dialog.f(getString(d.j.image_share), this.eiS);
        this.gBA.a(this.gBH);
        this.eiW.add(this.gBA);
        this.eiS.a(new i.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.19
            @Override // com.baidu.tbadk.core.dialog.i.a
            public void onClick() {
                ImageViewerActivity.this.aQB();
            }
        });
        this.eiS.P(this.eiW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQB() {
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

    private void aXp() {
        if (!this.gBt) {
            if (this.gBr == null) {
                this.gBr = new com.baidu.tieba.c.d(getPageContext(), this.gBa);
                this.gBr.oK(d.f.pic_sign_tip);
                this.gBr.oJ(48);
                this.gBr.aa(true);
                this.gBr.oL(5000);
                this.gBr.oN(-l.h(getPageContext().getPageActivity(), d.e.tbds26));
                this.gBr.o(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ImageViewerActivity.this.gBr != null) {
                            ImageViewerActivity.this.gBr.aSs();
                        }
                    }
                });
            }
            this.gBr.cu(getPageContext().getString(d.j.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bpx() {
        int S = v.S(this.gBd);
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
        this.gBg = new i();
        boolean isLogin = com.baidu.tbadk.n.a.isLogin();
        String bduss = com.baidu.tbadk.n.a.getBduss();
        String tbs = com.baidu.tbadk.n.a.getTbs();
        String stoken = com.baidu.tbadk.n.a.getStoken();
        if (bundle != null) {
            this.gBv = bundle.getBoolean(ImageViewerConfig.ABTEST);
            this.gBd = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.ele = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.ctx = bundle.getString("tid");
            this.fjU = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.cdq = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.gBc = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.gBi = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.cds = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.cdt = bundle.getBoolean(ImageViewerConfig.IS_HOT_SORT, false);
            this.gBn = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.gAO = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            this.gAQ = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
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
            this.gBs = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.gBt = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.gBv = intent.getBooleanExtra(ImageViewerConfig.ABTEST, false);
                this.gBd = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.ele = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.ctx = intent.getStringExtra("tid");
                this.fjU = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.cdq = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.gBc = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.gBi = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.cds = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.cdt = intent.getBooleanExtra(ImageViewerConfig.IS_HOT_SORT, false);
                this.gBn = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.gBs = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.gBt = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.gAO = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                this.gAQ = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
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
        this.gBg.b(bundle, getIntent());
        this.mCount = v.S(this.gBd);
        if (this.gAO != null) {
            String str = (String) v.c(this.gBd, this.mIndex);
            if (!StringUtils.isNull(str) && this.ceA != null && (imageUrlData = this.ceA.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.gAO);
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
        bundle.putBoolean(ImageViewerConfig.ABTEST, this.gBv);
        bundle.putStringArrayList("url", this.gBd);
        bundle.putInt("index", this.mIndex);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.ele);
        bundle.putString("tid", this.ctx);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.fjU);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.gBc);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.cds);
        bundle.putBoolean(ImageViewerConfig.IS_HOT_SORT, this.cdt);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.gBn);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.gBi);
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.gAO);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.gBs);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.gBt);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.gAQ);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.n.a.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.n.a.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.n.a.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.n.a.getTbs());
        this.gBg.Y(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.gBb.setCurrentItem(this.mIndex, false);
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
            ImageViewerActivity.this.gBe = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.gBe = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uF(int i) {
        if (this.gBb != null) {
            this.gBb.jc(i);
            setViewVisibility(this.gBa, (this.gBb.akp() || byC()) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byH() {
        if (byC()) {
            this.gBl = this.mNavigationBar.getVisibility() == 0;
            this.gBk = true;
        } else if (this.gBk) {
            this.mNavigationBar.setVisibility(this.gBl ? 0 : 8);
            this.gBk = false;
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
        return this.gBv;
    }
}
