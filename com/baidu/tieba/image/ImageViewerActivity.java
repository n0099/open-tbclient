package com.baidu.tieba.image;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
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
import com.baidu.adp.BdUniqueId;
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
import com.baidu.tbadk.BdToken.p;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
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
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.image.e;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.n;
import com.baidu.tieba.ueg.c;
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
    private String bVM;
    private boolean clA;
    private boolean clB;
    private boolean cly;
    private Map<String, ImageUrlData> cmK;
    private String eAC;
    private com.baidu.tbadk.core.dialog.g eRA;
    private com.baidu.tbadk.core.dialog.i eyp;
    private k eyq;
    private String fAb;
    private String gRR;
    private String gRS;
    private com.baidu.tieba.ueg.c gSB;
    private com.baidu.tbadk.core.dialog.g gSC;
    private com.baidu.tbadk.core.dialog.g gSD;
    private com.baidu.tbadk.core.dialog.g gSE;
    private com.baidu.tbadk.core.dialog.g gSF;
    private com.baidu.tbadk.core.dialog.g gSG;
    private float gSO;
    private TextView gSe;
    private MultiImageView gSf;
    private ArrayList<String> gSh;
    private a gSi;
    private e gSj;
    private i gSk;
    private boolean gSq;
    private boolean gSr;
    private int gSs;
    private boolean gSt;
    private float gSu;
    private com.baidu.tieba.c.d gSv;
    private boolean gSw;
    private boolean gSx;
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
    private boolean gSg = true;
    private boolean gSl = false;
    private boolean gSm = true;
    private com.baidu.tieba.image.a gSn = null;
    private boolean gSo = false;
    private boolean gSp = false;
    private boolean cwI = false;
    private int Se = 0;
    private boolean gSy = false;
    private boolean gRT = false;
    private boolean gSz = false;
    private String gSA = null;
    private List<com.baidu.tbadk.core.dialog.g> eyu = null;
    private final CustomMessageListener gSH = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k) && (kVar = (com.baidu.tbadk.data.k) customResponsedMessage.getData()) != null && !StringUtils.isNull(kVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(kVar);
                if (StringUtils.isNull(kVar.cpG)) {
                    ba.aiz().c(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    ba.aiz().c(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.cpG});
                }
            }
        }
    };
    private DragImageView.d cno = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void avW() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gSe, 8);
            if (ImageViewerActivity.this.gSf != null) {
                ImageViewerActivity.this.gSf.eQ(false);
            }
            ImageViewerActivity.this.bGn();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void avX() {
            TiebaStatic.log(new am("c13341").P("obj_param1", ImageViewerActivity.this.gSf.getItemNum()).P("obj_param2", ImageViewerActivity.this.gSf.getCurrentMaxIndex()));
            TiebaStatic.log(new am("c13377").bT("obj_type", "2"));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void avY() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 0);
            if (ImageViewerActivity.this.gSf != null && !ImageViewerActivity.this.gSf.apo()) {
                ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gSe, 0);
                ImageViewerActivity.this.gSf.eQ(true);
            }
        }
    };
    private UrlDragImageView.b clq = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void apI() {
            TiebaStatic.log(new am("c10351").bT("tid", ImageViewerActivity.this.bVM).bT("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final View.OnClickListener gSI = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jG()) {
                ImageViewerActivity.this.showToast(R.string.neterror);
                return;
            }
            TiebaStatic.log(new am("pb_onlyowner_click").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).P("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
            TiebaStatic.log(new am("c13338").P("obj_locate", ImageViewerActivity.this.mIsSeeHost ? 1 : 2));
            ImageViewerActivity.this.gSq = true;
            if (ImageViewerActivity.this.gSe != null) {
                ImageViewerActivity.this.gSe.setEnabled(false);
            }
            ImageViewerActivity.this.j(d.zb((String) v.c(ImageViewerActivity.this.gSh, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
        }
    };
    private k.b gSJ = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.22
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            ImageViewerActivity.this.gSf.jS(ImageViewerActivity.this.bxj());
            ImageViewerActivity.this.aXK();
        }
    };
    private k.b gSK = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.23
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.az(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.gSf.getCurrentImageUrl());
            ImageViewerActivity.this.aXK();
            ImageViewerActivity.this.vH(1);
        }
    };
    private k.b gSL = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = ImageViewerActivity.this.gSf.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.cuO);
                intent.putExtra(com.baidu.tbadk.imageManager.d.cuP, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            ImageViewerActivity.this.aXK();
            ImageViewerActivity.this.vH(2);
        }
    };
    private k.b eRB = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
            if (ImageViewerActivity.this.mPermissionJudgement == null) {
                ImageViewerActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            ImageViewerActivity.this.mPermissionJudgement.aiM();
            ImageViewerActivity.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!ImageViewerActivity.this.mPermissionJudgement.aa(pageActivity)) {
                ImageViewerActivity.this.saveImage();
                ImageViewerActivity.this.aXK();
                ImageViewerActivity.this.vH(3);
            }
        }
    };
    private k.b gSM = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            UrlDragImageView currentUrlDragImageView;
            if (ImageViewerActivity.this.gSf != null && (currentUrlDragImageView = ImageViewerActivity.this.gSf.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.d.c.nS(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = ImageViewerActivity.this.gSf.getCurrentImageUrl();
                    str2 = as.nS(str);
                }
                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                if (imageUrlData != null) {
                    long j = imageUrlData.threadId;
                    if (j > 0) {
                        eVar.linkUrl = "http://tieba.baidu.com/p/" + j + "?fr=share";
                    }
                }
                if (!ap.isEmpty(str)) {
                    eVar.imageUri = Uri.parse(str);
                    eVar.shareType = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString("path", TbConfig.IMAGE_CACHE_DIR_NAME);
                    bundle.putString("name", str2);
                    bundle.putBoolean("formatData", true);
                    bundle.putBoolean("isSubDir", true);
                    bundle.putBoolean("isSdcard", false);
                    bundle.putBoolean("isSavedCache", true);
                    eVar.cjA = bundle;
                }
                ImageViewerActivity.this.sendMessage(new CustomMessage(2001276, new ShareDialogConfig(ImageViewerActivity.this.getActivity(), eVar, false)));
                ImageViewerActivity.this.aXK();
                ImageViewerActivity.this.vH(4);
            }
        }
    };
    private k.b gSN = new AnonymousClass5();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (ImageViewerActivity.this.gSz && ImageViewerActivity.this.gSf != null) {
                boolean apo = ImageViewerActivity.this.gSf.apo();
                if (!apo) {
                    com.baidu.tieba.t.a.I(ImageViewerActivity.this.gSe, 100);
                    i = 1;
                } else {
                    com.baidu.tieba.t.a.J(ImageViewerActivity.this.gSe, 100);
                    i = 2;
                }
                ImageViewerActivity.this.gSf.g(apo ? false : true, 100);
                TiebaStatic.log(new am("c13397").P("obj_type", i));
                return;
            }
            TiebaStatic.log(new am("c13341").P("obj_param1", ImageViewerActivity.this.gSf.getItemNum()).P("obj_param2", ImageViewerActivity.this.gSf.getCurrentMaxIndex()));
            TiebaStatic.log(new am("c13377").bT("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean gSP = true;
    private View.OnTouchListener cnC = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.gSO = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.gSP = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.gSO = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.gSP = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener gSQ = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.bdz();
            ImageViewerActivity.this.show();
            ImageViewerActivity.this.cf(view);
            TiebaStatic.log(new am("c13269").bT("uid", ImageViewerActivity.this.mUserId).bT("fid", ImageViewerActivity.this.eAC).bT("tid", ImageViewerActivity.this.bVM));
            return true;
        }
    };
    private BaseViewPager.a gSR = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void is(int i) {
            if (i == 0) {
                ImageViewerActivity.this.gSj.bFV();
            } else if (ImageViewerActivity.this.bGi() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.gSj.bFW();
            }
        }
    };
    private ViewPager.OnPageChangeListener ccY = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.gSj != null && i > ImageViewerActivity.this.gSf.getItemNum() - 5) {
                ImageViewerActivity.this.gSj.bFV();
            }
            ImageViewerActivity.this.gSk.e(ImageViewerActivity.this.gSh, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.bGj();
            ImageViewerActivity.this.bGo();
            ImageViewerActivity.this.vI(i);
            if (ImageViewerActivity.this.gSk.bGs() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.gSk.vJ(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.gSk.bGt() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.gSk.vK(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.bGk()) {
                ImageViewerActivity.this.gSn.bFJ();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.gSf.getItemNum() - 1) {
                ImageViewerActivity.this.gSl = false;
            }
            ImageViewerActivity.this.gSA = null;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.Se) {
                ImageViewerActivity.this.Se = i;
                ImageViewerActivity.this.cwI = true;
            } else if (i < ImageViewerActivity.this.Se) {
                ImageViewerActivity.this.Se = i;
                ImageViewerActivity.this.cwI = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.gSh != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.gSh.size()) {
                ImageViewerActivity.this.gSk.as(i, (String) ImageViewerActivity.this.gSh.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.gSf.getItemNum() - 1) {
                if (!ImageViewerActivity.this.gSP || !ImageViewerActivity.this.gSt || (!ImageViewerActivity.this.gSl && !ImageViewerActivity.this.bGk() && (ImageViewerActivity.this.gSf.getItemNum() != 1 || !ImageViewerActivity.this.cwI))) {
                    ImageViewerActivity.this.gSl = true;
                } else {
                    ImageViewerActivity.this.showToast(R.string.last_page);
                }
            }
        }
    };
    private CustomMessageListener bVt = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.cmK != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.cmK.values()) {
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
    private CustomMessageListener bVu = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.cmK != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.cmK.values()) {
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
    private CustomMessageListener gSS = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && !ImageViewerActivity.this.isFinishing() && (nVar = (n) customResponsedMessage.getData()) != null) {
                nVar.iZM = null;
                if (!TextUtils.isEmpty(nVar.iZO) && !TextUtils.isEmpty(nVar.iZL) && nVar.iZL.equals(ImageViewerActivity.this.gSA)) {
                    ImageViewerActivity.this.gSf.setCurrentImageQRInfo(nVar.iZO);
                    ImageViewerActivity.this.zf(nVar.iZO);
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
        com.baidu.tbadk.n.b.asU().c(TbadkCoreApplication.getInst());
        this.gSs = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        bsK();
        if (com.baidu.tbadk.core.util.g.agV()) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
        this.gRS = d.zb((String) v.c(this.gSh, this.mIndex));
        if (d.zc((String) v.c(this.gSh, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        j(this.gRS, this.mIsSeeHost, false);
        MessageManager.getInstance().registerListener(this.gSH);
        registerListener(this.bVt);
        registerListener(this.bVu);
        registerListener(this.gSS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, boolean z, boolean z2) {
        this.gSj = new e(this.gSh, this.cmK, this.eAC, this.fAb, this.bVM, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.gSj.setSourceImageRectInScreen(this.gRR);
        this.gSj.mF(this.gSg);
        this.gSj.mG(z);
        this.gSj.zd(this.gRS);
        this.gSj.mE(this.gRT);
        this.gSj.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.gSf != null) {
                    if (ImageViewerActivity.this.gSq) {
                        if (!z5) {
                            ImageViewerActivity.this.gSf.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.gSq = false;
                    if (ImageViewerActivity.this.gSe != null) {
                        ImageViewerActivity.this.gSe.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.gSf.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.gSf.getItemNum();
                        ImageViewerActivity.this.gSf.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.gSf.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.gSf.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.gSn != null) {
                        ImageViewerActivity.this.gSn.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.gSf.setUrlData(arrayList);
                    ImageViewerActivity.this.gSf.setAssistUrls(ImageViewerActivity.this.cmK);
                    ImageViewerActivity.this.gSf.setHasNext(z3);
                    ImageViewerActivity.this.gSf.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.gSf.getItemNum()) {
                        ImageViewerActivity.this.gSf.jQ(ImageViewerActivity.this.gSf.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.gSf.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList.size() >= 400 && ImageViewerActivity.this.gSf.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.gSf.setUrlData(arrayList);
                        ImageViewerActivity.this.gSf.setCurrentItem(ImageViewerActivity.this.gSf.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.bGj();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.gSf.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.gSn.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.gSn.bFF()) {
                    ImageViewerActivity.this.gSf.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.q.a.b("a008", "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.gSf.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void ar(int i, String str2) {
                ImageViewerActivity.this.gSq = false;
                if (ImageViewerActivity.this.gSe != null) {
                    ImageViewerActivity.this.gSe.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.gSh.size();
                    ImageViewerActivity.this.bGj();
                }
            }
        });
        this.gSj.mH(true);
        this.gSj.bFV();
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
            this.gSi = new a(this.gSf.getCurrentImageUrl(), this.gSf.getCurrentImageData());
            this.gSi.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gSf.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.gSf.iA(i);
        super.onChangeSkinType(i);
        this.gSs = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gSf.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long c = com.baidu.adp.lib.g.b.c(this.bVM, 0L);
        if (uniqueId != null && c > 0) {
            p.m(uniqueId.getId(), c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gSf.onResume();
        this.mIsLogin = com.baidu.tbadk.n.a.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long c = com.baidu.adp.lib.g.b.c(this.bVM, 0L);
        if (uniqueId != null && c > 0) {
            p.a(com.baidu.tbadk.BdToken.b.bxe, uniqueId.getId(), c);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.gSf.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gSB != null && !this.gSB.isCancelled()) {
            this.gSB.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.gSH);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.asp().asq();
        this.gSk.e(this.gSh, this.mIndex, this.mIndex);
        this.gSk.bGu();
        String str = "";
        if (this.gSn != null) {
            str = this.gSn.getAdId();
        }
        this.gSk.d(this.gSf.getPageCount(), str, this.eAC, this.bVM);
        this.gSf.onDestroy();
        if (this.gSi != null) {
            this.gSi.cancel();
            this.gSi = null;
        }
        com.baidu.tbadk.download.d.aqM().kd(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.gSs);
        bGn();
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

    private void bsK() {
        this.mStatusBarView = findViewById(R.id.statusbar_view);
        aHR();
        initViewPager();
        bGj();
        beC();
        bdy();
        this.gSk.e(this.gSh, this.mIndex, this.mIndex);
    }

    private void aHR() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.gSe = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(R.id.see_host_image_txt);
        if (this.gSx) {
            setViewVisibility(this.gSe, 8);
        }
        if (this.gSr) {
            if (this.mIsSeeHost) {
                this.gSe.setText(R.string.album_all_thread);
            } else {
                this.gSe.setText(R.string.view_host);
            }
            this.gSe.setOnClickListener(this.gSI);
        } else {
            setViewVisibility(this.gSe, 8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_btn_a));
        this.mTitleView.setTextSize(0, l.g(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long bGi() {
        ImageUrlData imageUrlData;
        String str = (String) v.c(this.gSh, this.mIndex);
        if (this.cmK == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.cmK.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGj() {
        String str;
        if (this.gSh != null) {
            String str2 = ("" + bGi()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (this.mFrom != null && !this.gSy && bGi() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new am("c13316").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom));
                this.gSy = true;
            }
            if (bGk()) {
                bGl();
            } else {
                ze(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bGk() {
        if (this.gSm && this.gSn != null && this.gSn.bFF()) {
            return this.gSf.getItemNum() != 1 && this.mIndex == this.gSf.getItemNum() + (-1);
        }
        return false;
    }

    private void ze(String str) {
        this.mTitleView.setText(str);
        if (this.gSr && !this.gSx) {
            if (this.mIsSeeHost) {
                this.gSe.setText(R.string.album_all_thread);
            } else {
                this.gSe.setText(R.string.view_host);
            }
        }
    }

    private void bGl() {
        this.mTitleView.setText("");
        setViewVisibility(this.gSe, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.gSf == null) {
            this.gSf = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.gSf.init();
        }
        this.gSf.setIsFromCDN(this.cly);
        this.gSf.setIsCanDrag(this.clA);
        this.gSf.setIsHotSort(this.clB);
        this.gSf.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.gSf.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.gSf.setOnPageChangeListener(this.ccY);
        this.gSf.setUrlData(this.gSh);
        this.gSf.setAssistUrls(this.cmK);
        this.gSf.setOuterOnTouchListener(this.cnC);
        this.gSf.setItemOnclickListener(this.mOnClickListener);
        this.gSf.setItemOnLongClickListener(this.gSQ);
        this.gSf.setCurrentItem(bxj(), false);
        this.gSf.setOnScrollOutListener(this.gSR);
        this.gSn = new com.baidu.tieba.image.a(this.cly, this.gSm, getPageContext(), this.eAC, this.bVM);
        this.gSn.setDragToExitListener(this.cno);
        this.gSf.a(this.gSn);
        this.gSf.setOriImgSelectedCallback(this.clq);
        this.gSf.setDragToExitListener(this.cno);
        this.gSf.setUserId(this.mUserId);
        this.gSf.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.gSt = ImageViewerActivity.this.gSu - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.gSu = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        TiebaStatic.log(new am("c13340").bT("uid", this.mUserId).bT("post_id", this.bVM).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bGm()));
    }

    private int bGm() {
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

    private void bdy() {
        if (this.eyp == null) {
            this.eyq = new k(this);
        }
        if (this.eyu == null) {
            this.eyu = new ArrayList();
        }
        bdz();
        this.eyp = new com.baidu.tbadk.core.dialog.i(getPageContext(), this.eyq.afZ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdz() {
        this.eyu.clear();
        String jR = this.gSf.jR(bxj());
        if (jR != null) {
            this.gSC = new com.baidu.tbadk.core.dialog.g(jR, this.eyq);
            this.gSC.a(this.gSJ);
            this.eyu.add(this.gSC);
        }
        this.eRA = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.eyq);
        this.eRA.a(this.eRB);
        this.eyu.add(this.eRA);
        this.gSE = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.eyq);
        this.gSE.a(this.gSL);
        this.eyu.add(this.gSE);
        this.gSD = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.eyq);
        this.gSD.a(this.gSK);
        this.eyu.add(this.gSD);
        String currentImageQRInfo = this.gSf.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.gSG = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.eyq);
            this.gSG.a(this.gSN);
            this.eyu.add(this.gSG);
        }
        this.gSF = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.eyq);
        this.gSF.a(this.gSM);
        this.eyu.add(this.gSF);
        this.eyq.a(new k.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                ImageViewerActivity.this.aXK();
            }
        });
        this.eyq.W(this.eyu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXK() {
        if (this.eyp != null && this.eyp.isShowing()) {
            this.eyp.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show() {
        if (this.eyp != null && !isFinishing()) {
            this.eyp.showDialog();
        }
    }

    /* renamed from: com.baidu.tieba.image.ImageViewerActivity$5  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass5 implements k.b {
        AnonymousClass5() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = ImageViewerActivity.this.gSf.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (l.ki()) {
                    if (ImageViewerActivity.this.gSB != null && !ImageViewerActivity.this.gSB.isCancelled()) {
                        ImageViewerActivity.this.gSB.cancel();
                    }
                    ImageViewerActivity.this.gSB = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.5.1
                        @Override // com.baidu.tieba.ueg.c.a
                        public void bGp() {
                            ImageViewerActivity.this.openUrl(currentImageQRInfo);
                        }

                        @Override // com.baidu.tieba.ueg.c.a
                        public void bGq() {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ImageViewerActivity.this.getPageContext().getPageActivity());
                            aVar.dT(true);
                            aVar.mC(ImageViewerActivity.this.getString(R.string.qr_url_jump_external_title));
                            aVar.dS(true);
                            aVar.mD(ImageViewerActivity.this.getString(R.string.qr_url_jump_external_message));
                            aVar.a(ImageViewerActivity.this.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.5.1.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                    aVar2.dismiss();
                                    ImageViewerActivity.this.openUrl(currentImageQRInfo);
                                }
                            });
                            aVar.b(ImageViewerActivity.this.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.5.1.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                    aVar2.dismiss();
                                }
                            });
                            aVar.dM(false);
                            aVar.dN(false);
                            aVar.b(ImageViewerActivity.this.getPageContext()).afG();
                        }

                        @Override // com.baidu.tieba.ueg.c.a
                        public void bGr() {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ImageViewerActivity.this.getPageContext().getPageActivity());
                            aVar.mC(null);
                            aVar.dS(true);
                            aVar.mD(ImageViewerActivity.this.getString(R.string.qr_url_risk_forbid));
                            aVar.a(ImageViewerActivity.this.getPageContext().getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.5.1.3
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                    aVar2.dismiss();
                                }
                            });
                            aVar.dM(false);
                            aVar.dN(false);
                            aVar.b(ImageViewerActivity.this.getPageContext()).afG();
                        }

                        @Override // com.baidu.tieba.ueg.c.a
                        public void onError(String str) {
                            l.showToast(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.getPageContext().getResources().getString(R.string.qr_scan_error));
                        }
                    });
                    ImageViewerActivity.this.gSB.setPriority(3);
                    ImageViewerActivity.this.gSB.execute(new String[0]);
                    ImageViewerActivity.this.aXK();
                    ImageViewerActivity.this.vH(5);
                    return;
                }
                l.showToast(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.getPageContext().getResources().getString(R.string.network_not_available));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vH(int i) {
        TiebaStatic.log(new am("c13270").bT("uid", this.mUserId).P("obj_type", i));
    }

    private void beC() {
        if (!this.gSx) {
            if (this.gSv == null) {
                this.gSv = new com.baidu.tieba.c.d(getPageContext(), this.gSe);
                this.gSv.pK(R.drawable.pic_sign_tip);
                this.gSv.pJ(48);
                this.gSv.S(true);
                this.gSv.pL(UIMsg.m_AppUI.MSG_APP_GPS);
                this.gSv.pN(-l.g(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.gSv.q(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.bGn();
                    }
                });
            }
            this.gSv.cH(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGn() {
        if (this.gSv != null) {
            this.gSv.aZA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bxj() {
        int Z = v.Z(this.gSh);
        if (Z > 0) {
            if (this.mIndex >= Z) {
                this.mIndex = Z - 1;
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
        this.gSk = new i();
        boolean isLogin = com.baidu.tbadk.n.a.isLogin();
        String bduss = com.baidu.tbadk.n.a.getBduss();
        String tbs = com.baidu.tbadk.n.a.getTbs();
        String stoken = com.baidu.tbadk.n.a.getStoken();
        if (bundle != null) {
            this.gSz = bundle.getBoolean(ImageViewerConfig.ABTEST);
            this.gSh = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.eAC = bundle.getString("fid");
            this.bVM = bundle.getString("tid");
            this.fAb = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.cly = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.gSg = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.gSm = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.clA = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.clB = bundle.getBoolean(ImageViewerConfig.IS_HOT_SORT, false);
            this.gSr = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.gRR = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            this.gRT = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            if (serializable instanceof Map) {
                this.cmK = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.cmK.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.gSw = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.gSx = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.gSz = intent.getBooleanExtra(ImageViewerConfig.ABTEST, false);
                this.gSh = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.eAC = intent.getStringExtra("fid");
                this.bVM = intent.getStringExtra("tid");
                this.fAb = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.cly = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.gSg = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.gSm = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.clA = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.clB = intent.getBooleanExtra(ImageViewerConfig.IS_HOT_SORT, false);
                this.gSr = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.gSw = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.gSx = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.gRR = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                this.gRT = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.cmK = (Map) serializableExtra;
                }
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.n.a.fr(isLogin);
        com.baidu.tbadk.n.a.qz(bduss);
        com.baidu.tbadk.n.a.setStoken(stoken);
        com.baidu.tbadk.n.a.setTbs(tbs);
        this.gSk.b(bundle, getIntent());
        this.mCount = v.Z(this.gSh);
        if (this.gRR != null) {
            String str = (String) v.c(this.gSh, this.mIndex);
            if (!StringUtils.isNull(str) && this.cmK != null && (imageUrlData = this.cmK.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.gRR);
            }
        }
        if (this.mIsSeeHost) {
            TiebaStatic.log(new am("c13337").bT("obj_type", "2"));
        } else {
            TiebaStatic.log(new am("c13337").bT("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.ABTEST, this.gSz);
        bundle.putStringArrayList("url", this.gSh);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.eAC);
        bundle.putString("tid", this.bVM);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.fAb);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.gSg);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.clA);
        bundle.putBoolean(ImageViewerConfig.IS_HOT_SORT, this.clB);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.gSr);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.gSm);
        bundle.putString("user_id", this.mUserId);
        if (this.cmK instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.cmK.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.cmK instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.cmK.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.gRR);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.gSw);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.gSx);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.gRT);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.n.a.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.n.a.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.n.a.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.n.a.getTbs());
        this.gSk.Z(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.gSf.setCurrentItem(this.mIndex, false);
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
            String nS;
            if (this.mUrl != null && ImageViewerActivity.this.cmK != null) {
                Iterator it = ImageViewerActivity.this.cmK.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ao.aig().nJ(nS) + "/" + as.nS(imageUrlData.originalUrl);
                    int[] nm = m.nm(str);
                    if (nm != null && nm.length == 2 && nm[0] > 0 && m.e(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
                        return ImageViewerActivity.this.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (m.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                    case -2:
                        return m.agZ();
                    case 0:
                        return ImageViewerActivity.this.getPageContext().getString(R.string.save_image_to_album);
                }
            }
            return ImageViewerActivity.this.getPageContext().getString(R.string.save_fail);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            ImageViewerActivity.this.showToast(str);
            ImageViewerActivity.this.gSi = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.gSi = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zf(String str) {
        int i;
        boolean z = false;
        if (this.eyp != null && !isFinishing() && this.eyp.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.gSG = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.eyq);
            this.gSG.a(this.gSN);
            int i2 = 0;
            while (true) {
                if (i2 < this.eyu.size()) {
                    if (this.gSD == null || this.eyu.get(i2) != this.gSD || (i = i2 + 1) > this.eyu.size()) {
                        i2++;
                    } else {
                        this.eyu.add(i, this.gSG);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.eyu.add(this.gSG);
            }
            this.eyq.W(this.eyu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cf(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                n nVar = new n();
                nVar.type = 0;
                nVar.iZM = imageBitmap;
                String currentImageUrl = this.gSf.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    nVar.iZL = String.valueOf(System.currentTimeMillis()) + as.nS(currentImageUrl);
                } else {
                    nVar.iZL = String.valueOf(BdUniqueId.gen().getId());
                }
                this.gSA = nVar.iZL;
                sendMessage(new CustomMessage(2921403, nVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vI(int i) {
        if (this.gSf != null) {
            this.gSf.jP(i);
            setViewVisibility(this.gSe, (this.gSf.apo() || bGk()) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGo() {
        if (bGk()) {
            this.gSp = this.mNavigationBar.getVisibility() == 0;
            this.gSo = true;
        } else if (this.gSo) {
            this.mNavigationBar.setVisibility(this.gSp ? 0 : 8);
            this.gSo = false;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a008";
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public com.baidu.tbadk.o.b getPageStayFilter() {
        return new com.baidu.tbadk.o.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
            @Override // com.baidu.tbadk.o.b
            public boolean atL() {
                return false;
            }

            @Override // com.baidu.tbadk.o.b
            public int atM() {
                return com.baidu.tbadk.o.e.atQ().atT();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eAC, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.bVM, 0L));
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.coreExtra.view.a
    public boolean ape() {
        return this.gSz;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (ap.isEmpty(this.bVM)) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.c(this.bVM, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }
}
