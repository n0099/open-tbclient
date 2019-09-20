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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.q;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
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
    private String bXN;
    private boolean cnO;
    private boolean cnQ;
    private boolean cnR;
    private Map<String, ImageUrlData> coZ;
    private com.baidu.tbadk.core.dialog.i eFc;
    private k eFd;
    private String eHo;
    private com.baidu.tbadk.core.dialog.g eYq;
    private String fHC;
    private String haN;
    private String haO;
    private com.baidu.tbadk.core.dialog.g hbA;
    private com.baidu.tbadk.core.dialog.g hbB;
    private com.baidu.tbadk.core.dialog.g hbC;
    private float hbK;
    private TextView hba;
    private MultiImageView hbb;
    private ArrayList<String> hbd;
    private a hbe;
    private e hbf;
    private i hbg;
    private boolean hbm;
    private boolean hbn;
    private int hbo;
    private boolean hbp;
    private float hbq;
    private com.baidu.tieba.c.d hbr;
    private boolean hbs;
    private boolean hbt;
    private com.baidu.tieba.ueg.c hbx;
    private com.baidu.tbadk.core.dialog.g hby;
    private com.baidu.tbadk.core.dialog.g hbz;
    private String mFrom;
    private boolean mIsSeeHost;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean hbc = true;
    private boolean hbh = false;
    private boolean hbi = true;
    private com.baidu.tieba.image.a hbj = null;
    private boolean hbk = false;
    private boolean hbl = false;
    private boolean cza = false;
    private int Sv = 0;
    private boolean hbu = false;
    private boolean haP = false;
    private boolean hbv = false;
    private String hbw = null;
    private List<com.baidu.tbadk.core.dialog.g> eFh = null;
    private final CustomMessageListener hbD = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k) && (kVar = (com.baidu.tbadk.data.k) customResponsedMessage.getData()) != null && !StringUtils.isNull(kVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(kVar);
                if (StringUtils.isNull(kVar.crU)) {
                    ba.ajK().c(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    ba.ajK().c(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.crU});
                }
            }
        }
    };
    private DragImageView.d cpD = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void axv() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.hba, 8);
            if (ImageViewerActivity.this.hbb != null) {
                ImageViewerActivity.this.hbb.eX(false);
            }
            ImageViewerActivity.this.bJV();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void axw() {
            TiebaStatic.log(new an("c13341").P("obj_param1", ImageViewerActivity.this.hbb.getItemNum()).P("obj_param2", ImageViewerActivity.this.hbb.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").bT("obj_type", "2"));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void axx() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 0);
            if (ImageViewerActivity.this.hbb != null && !ImageViewerActivity.this.hbb.aqH()) {
                ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.hba, 0);
                ImageViewerActivity.this.hbb.eX(true);
            }
        }
    };
    private UrlDragImageView.b cnG = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void arb() {
            TiebaStatic.log(new an("c10351").bT("tid", ImageViewerActivity.this.bXN).bT("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final View.OnClickListener hbE = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jQ()) {
                ImageViewerActivity.this.showToast(R.string.neterror);
                return;
            }
            TiebaStatic.log(new an("pb_onlyowner_click").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).P("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
            TiebaStatic.log(new an("c13338").P("obj_locate", ImageViewerActivity.this.mIsSeeHost ? 1 : 2));
            ImageViewerActivity.this.hbm = true;
            if (ImageViewerActivity.this.hba != null) {
                ImageViewerActivity.this.hba.setEnabled(false);
            }
            ImageViewerActivity.this.k(d.Am((String) v.c(ImageViewerActivity.this.hbd, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
        }
    };
    private k.b hbF = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.22
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            ImageViewerActivity.this.hbb.kc(ImageViewerActivity.this.bAP());
            ImageViewerActivity.this.bao();
        }
    };
    private k.b hbG = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.23
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aH(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.hbb.getCurrentImageUrl());
            ImageViewerActivity.this.bao();
            ImageViewerActivity.this.wo(1);
        }
    };
    private k.b hbH = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = ImageViewerActivity.this.hbb.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.cxf);
                intent.putExtra(com.baidu.tbadk.imageManager.d.cxg, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            ImageViewerActivity.this.bao();
            ImageViewerActivity.this.wo(2);
        }
    };
    private k.b eYr = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
            if (ImageViewerActivity.this.mPermissionJudgement == null) {
                ImageViewerActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
            }
            ImageViewerActivity.this.mPermissionJudgement.ake();
            ImageViewerActivity.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!ImageViewerActivity.this.mPermissionJudgement.ad(pageActivity)) {
                ImageViewerActivity.this.saveImage();
                ImageViewerActivity.this.bao();
                ImageViewerActivity.this.wo(3);
            }
        }
    };
    private k.b hbI = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            UrlDragImageView currentUrlDragImageView;
            if (ImageViewerActivity.this.hbb != null && (currentUrlDragImageView = ImageViewerActivity.this.hbb.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.e.c.ol(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = ImageViewerActivity.this.hbb.getCurrentImageUrl();
                    str2 = as.ol(str);
                }
                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                if (imageUrlData != null) {
                    long j = imageUrlData.threadId;
                    if (j > 0) {
                        eVar.linkUrl = "http://tieba.baidu.com/p/" + j + "?fr=share";
                    }
                }
                if (!aq.isEmpty(str)) {
                    eVar.imageUri = Uri.parse(str);
                    eVar.shareType = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString("path", TbConfig.IMAGE_CACHE_DIR_NAME);
                    bundle.putString("name", str2);
                    bundle.putBoolean("formatData", true);
                    bundle.putBoolean("isSubDir", true);
                    bundle.putBoolean("isSdcard", false);
                    bundle.putBoolean("isSavedCache", true);
                    eVar.clH = bundle;
                }
                ImageViewerActivity.this.sendMessage(new CustomMessage(2001276, new ShareDialogConfig(ImageViewerActivity.this.getActivity(), eVar, false)));
                ImageViewerActivity.this.bao();
                ImageViewerActivity.this.wo(4);
            }
        }
    };
    private k.b hbJ = new AnonymousClass5();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (ImageViewerActivity.this.hbv && ImageViewerActivity.this.hbb != null) {
                boolean aqH = ImageViewerActivity.this.hbb.aqH();
                if (!aqH) {
                    com.baidu.tieba.t.a.I(ImageViewerActivity.this.hba, 100);
                    i = 1;
                } else {
                    com.baidu.tieba.t.a.J(ImageViewerActivity.this.hba, 100);
                    i = 2;
                }
                ImageViewerActivity.this.hbb.g(aqH ? false : true, 100);
                TiebaStatic.log(new an("c13397").P("obj_type", i));
                return;
            }
            TiebaStatic.log(new an("c13341").P("obj_param1", ImageViewerActivity.this.hbb.getItemNum()).P("obj_param2", ImageViewerActivity.this.hbb.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").bT("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean hbL = true;
    private View.OnTouchListener cpQ = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.hbK = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.hbL = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.hbK = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.hbL = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener hbM = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.bgh();
            ImageViewerActivity.this.show();
            ImageViewerActivity.this.cj(view);
            TiebaStatic.log(new an("c13269").bT("uid", ImageViewerActivity.this.mUserId).bT("fid", ImageViewerActivity.this.eHo).bT("tid", ImageViewerActivity.this.bXN));
            return true;
        }
    };
    private BaseViewPager.a hbN = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void iB(int i) {
            if (i == 0) {
                ImageViewerActivity.this.hbf.bJD();
            } else if (ImageViewerActivity.this.bJQ() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.hbf.bJE();
            }
        }
    };
    private ViewPager.OnPageChangeListener cfa = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.hbf != null && i > ImageViewerActivity.this.hbb.getItemNum() - 5) {
                ImageViewerActivity.this.hbf.bJD();
            }
            ImageViewerActivity.this.hbg.e(ImageViewerActivity.this.hbd, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.bJR();
            ImageViewerActivity.this.bJW();
            ImageViewerActivity.this.wp(i);
            if (ImageViewerActivity.this.hbg.bKa() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.hbg.wq(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.hbg.bKb() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.hbg.wr(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.bJS()) {
                ImageViewerActivity.this.hbj.bJr();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.hbb.getItemNum() - 1) {
                ImageViewerActivity.this.hbh = false;
            }
            ImageViewerActivity.this.hbw = null;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.Sv) {
                ImageViewerActivity.this.Sv = i;
                ImageViewerActivity.this.cza = true;
            } else if (i < ImageViewerActivity.this.Sv) {
                ImageViewerActivity.this.Sv = i;
                ImageViewerActivity.this.cza = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.hbd != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.hbd.size()) {
                ImageViewerActivity.this.hbg.as(i, (String) ImageViewerActivity.this.hbd.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.hbb.getItemNum() - 1) {
                if (!ImageViewerActivity.this.hbL || !ImageViewerActivity.this.hbp || (!ImageViewerActivity.this.hbh && !ImageViewerActivity.this.bJS() && (ImageViewerActivity.this.hbb.getItemNum() != 1 || !ImageViewerActivity.this.cza))) {
                    ImageViewerActivity.this.hbh = true;
                } else {
                    ImageViewerActivity.this.showToast(R.string.last_page);
                }
            }
        }
    };
    private CustomMessageListener bXt = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.coZ != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.coZ.values()) {
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
    private CustomMessageListener bXu = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.coZ != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.coZ.values()) {
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
    private CustomMessageListener hbO = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && !ImageViewerActivity.this.isFinishing() && (nVar = (n) customResponsedMessage.getData()) != null) {
                nVar.jjG = null;
                if (!TextUtils.isEmpty(nVar.jjI) && !TextUtils.isEmpty(nVar.jjF) && nVar.jjF.equals(ImageViewerActivity.this.hbw)) {
                    ImageViewerActivity.this.hbb.setCurrentImageQRInfo(nVar.jjI);
                    ImageViewerActivity.this.Aq(nVar.jjI);
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
        com.baidu.tbadk.n.b.auq().c(TbadkCoreApplication.getInst());
        this.hbo = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        bvM();
        if (com.baidu.tbadk.core.util.g.aid()) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
        this.haO = d.Am((String) v.c(this.hbd, this.mIndex));
        if (d.An((String) v.c(this.hbd, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        k(this.haO, this.mIsSeeHost, false);
        MessageManager.getInstance().registerListener(this.hbD);
        registerListener(this.bXt);
        registerListener(this.bXu);
        registerListener(this.hbO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.hbf = new e(this.hbd, this.coZ, this.eHo, this.fHC, this.bXN, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.hbf.setSourceImageRectInScreen(this.haN);
        this.hbf.mW(this.hbc);
        this.hbf.mX(z);
        this.hbf.Ao(this.haO);
        this.hbf.mV(this.haP);
        this.hbf.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.hbb != null) {
                    if (ImageViewerActivity.this.hbm) {
                        if (!z5) {
                            ImageViewerActivity.this.hbb.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.hbm = false;
                    if (ImageViewerActivity.this.hba != null) {
                        ImageViewerActivity.this.hba.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.hbb.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.hbb.getItemNum();
                        ImageViewerActivity.this.hbb.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.hbb.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.hbb.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.hbj != null) {
                        ImageViewerActivity.this.hbj.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.hbb.setUrlData(arrayList);
                    ImageViewerActivity.this.hbb.setAssistUrls(ImageViewerActivity.this.coZ);
                    ImageViewerActivity.this.hbb.setHasNext(z3);
                    ImageViewerActivity.this.hbb.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.hbb.getItemNum()) {
                        ImageViewerActivity.this.hbb.ka(ImageViewerActivity.this.hbb.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.hbb.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList.size() >= 400 && ImageViewerActivity.this.hbb.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.hbb.setUrlData(arrayList);
                        ImageViewerActivity.this.hbb.setCurrentItem(ImageViewerActivity.this.hbb.getCurrentItem() - 200, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.bJR();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.hbb.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.hbj.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.hbj.bJn()) {
                    ImageViewerActivity.this.hbb.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.q.a.b("a008", "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.hbb.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void ar(int i, String str2) {
                ImageViewerActivity.this.hbm = false;
                if (ImageViewerActivity.this.hba != null) {
                    ImageViewerActivity.this.hba.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.hbd.size();
                    ImageViewerActivity.this.bJR();
                }
            }
        });
        this.hbf.mY(true);
        this.hbf.bJD();
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
            this.hbe = new a(this.hbb.getCurrentImageUrl(), this.hbb.getCurrentImageData());
            this.hbe.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hbb.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.hbb.iJ(i);
        super.onChangeSkinType(i);
        this.hbo = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hbb.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long e = com.baidu.adp.lib.g.b.e(this.bXN, 0L);
        if (uniqueId != null && e > 0) {
            q.m(uniqueId.getId(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hbb.onResume();
        this.mIsLogin = com.baidu.tbadk.n.a.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long e = com.baidu.adp.lib.g.b.e(this.bXN, 0L);
        if (uniqueId != null && e > 0) {
            q.a(com.baidu.tbadk.BdToken.b.byt, uniqueId.getId(), e);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.hbb.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hbx != null && !this.hbx.isCancelled()) {
            this.hbx.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.hbD);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.atK().atL();
        this.hbg.e(this.hbd, this.mIndex, this.mIndex);
        this.hbg.bKc();
        String str = "";
        if (this.hbj != null) {
            str = this.hbj.getAdId();
        }
        this.hbg.e(this.hbb.getPageCount(), str, this.eHo, this.bXN);
        this.hbb.onDestroy();
        if (this.hbe != null) {
            this.hbe.cancel();
            this.hbe = null;
        }
        com.baidu.tbadk.download.d.asg().kn(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.hbo);
        bJV();
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

    private void bvM() {
        this.mStatusBarView = findViewById(R.id.statusbar_view);
        aJX();
        initViewPager();
        bJR();
        bho();
        bgg();
        this.hbg.e(this.hbd, this.mIndex, this.mIndex);
    }

    private void aJX() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.hba = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(R.id.see_host_image_txt);
        if (this.hbt) {
            setViewVisibility(this.hba, 8);
        }
        if (this.hbn) {
            if (this.mIsSeeHost) {
                this.hba.setText(R.string.album_all_thread);
            } else {
                this.hba.setText(R.string.view_host);
            }
            this.hba.setOnClickListener(this.hbE);
        } else {
            setViewVisibility(this.hba, 8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, l.g(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long bJQ() {
        ImageUrlData imageUrlData;
        String str = (String) v.c(this.hbd, this.mIndex);
        if (this.coZ == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.coZ.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJR() {
        String str;
        if (this.hbd != null) {
            String str2 = ("" + bJQ()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (this.mFrom != null && !this.hbu && bJQ() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new an("c13316").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom));
                this.hbu = true;
            }
            if (bJS()) {
                bJT();
            } else {
                Ap(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJS() {
        if (this.hbi && this.hbj != null && this.hbj.bJn()) {
            return this.hbb.getItemNum() != 1 && this.mIndex == this.hbb.getItemNum() + (-1);
        }
        return false;
    }

    private void Ap(String str) {
        this.mTitleView.setText(str);
        if (this.hbn && !this.hbt) {
            if (this.mIsSeeHost) {
                this.hba.setText(R.string.album_all_thread);
            } else {
                this.hba.setText(R.string.view_host);
            }
        }
    }

    private void bJT() {
        this.mTitleView.setText("");
        setViewVisibility(this.hba, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.hbb == null) {
            this.hbb = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.hbb.init();
        }
        this.hbb.setIsFromCDN(this.cnO);
        this.hbb.setIsCanDrag(this.cnQ);
        this.hbb.setIsHotSort(this.cnR);
        this.hbb.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.hbb.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.hbb.setOnPageChangeListener(this.cfa);
        this.hbb.setUrlData(this.hbd);
        this.hbb.setAssistUrls(this.coZ);
        this.hbb.setOuterOnTouchListener(this.cpQ);
        this.hbb.setItemOnclickListener(this.mOnClickListener);
        this.hbb.setItemOnLongClickListener(this.hbM);
        this.hbb.setCurrentItem(bAP(), false);
        this.hbb.setOnScrollOutListener(this.hbN);
        this.hbj = new com.baidu.tieba.image.a(this.cnO, this.hbi, getPageContext(), this.eHo, this.bXN);
        this.hbj.setDragToExitListener(this.cpD);
        this.hbb.a(this.hbj);
        this.hbb.setOriImgSelectedCallback(this.cnG);
        this.hbb.setDragToExitListener(this.cpD);
        this.hbb.setUserId(this.mUserId);
        this.hbb.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.hbp = ImageViewerActivity.this.hbq - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.hbq = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        TiebaStatic.log(new an("c13340").bT("uid", this.mUserId).bT("post_id", this.bXN).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bJU()));
    }

    private int bJU() {
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

    private void bgg() {
        if (this.eFc == null) {
            this.eFd = new k(this);
        }
        if (this.eFh == null) {
            this.eFh = new ArrayList();
        }
        bgh();
        this.eFc = new com.baidu.tbadk.core.dialog.i(getPageContext(), this.eFd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgh() {
        this.eFh.clear();
        String kb = this.hbb.kb(bAP());
        if (kb != null) {
            this.hby = new com.baidu.tbadk.core.dialog.g(kb, this.eFd);
            this.hby.a(this.hbF);
            this.eFh.add(this.hby);
        }
        this.eYq = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.eFd);
        this.eYq.a(this.eYr);
        this.eFh.add(this.eYq);
        this.hbA = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.eFd);
        this.hbA.a(this.hbH);
        this.eFh.add(this.hbA);
        this.hbz = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.eFd);
        this.hbz.a(this.hbG);
        this.eFh.add(this.hbz);
        String currentImageQRInfo = this.hbb.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.hbC = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.eFd);
            this.hbC.a(this.hbJ);
            this.eFh.add(this.hbC);
        }
        this.hbB = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.eFd);
        this.hbB.a(this.hbI);
        this.eFh.add(this.hbB);
        this.eFd.a(new k.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                ImageViewerActivity.this.bao();
            }
        });
        this.eFd.W(this.eFh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bao() {
        if (this.eFc != null && this.eFc.isShowing()) {
            this.eFc.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show() {
        if (this.eFc != null && !isFinishing()) {
            this.eFc.showDialog();
        }
    }

    /* renamed from: com.baidu.tieba.image.ImageViewerActivity$5  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass5 implements k.b {
        AnonymousClass5() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = ImageViewerActivity.this.hbb.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (l.kt()) {
                    if (ImageViewerActivity.this.hbx != null && !ImageViewerActivity.this.hbx.isCancelled()) {
                        ImageViewerActivity.this.hbx.cancel();
                    }
                    ImageViewerActivity.this.hbx = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.5.1
                        @Override // com.baidu.tieba.ueg.c.a
                        public void bJX() {
                            ImageViewerActivity.this.openUrl(currentImageQRInfo);
                        }

                        @Override // com.baidu.tieba.ueg.c.a
                        public void bJY() {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ImageViewerActivity.this.getPageContext().getPageActivity());
                            aVar.dX(true);
                            aVar.mP(ImageViewerActivity.this.getString(R.string.qr_url_jump_external_title));
                            aVar.dW(true);
                            aVar.mQ(ImageViewerActivity.this.getString(R.string.qr_url_jump_external_message));
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
                            aVar.dQ(false);
                            aVar.dR(false);
                            aVar.b(ImageViewerActivity.this.getPageContext()).agO();
                        }

                        @Override // com.baidu.tieba.ueg.c.a
                        public void bJZ() {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ImageViewerActivity.this.getPageContext().getPageActivity());
                            aVar.mP(null);
                            aVar.dW(true);
                            aVar.mQ(ImageViewerActivity.this.getString(R.string.qr_url_risk_forbid));
                            aVar.a(ImageViewerActivity.this.getPageContext().getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.5.1.3
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                    aVar2.dismiss();
                                }
                            });
                            aVar.dQ(false);
                            aVar.dR(false);
                            aVar.b(ImageViewerActivity.this.getPageContext()).agO();
                        }

                        @Override // com.baidu.tieba.ueg.c.a
                        public void onError(String str) {
                            l.showToast(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.getPageContext().getResources().getString(R.string.qr_scan_error));
                        }
                    });
                    ImageViewerActivity.this.hbx.setPriority(3);
                    ImageViewerActivity.this.hbx.execute(new String[0]);
                    ImageViewerActivity.this.bao();
                    ImageViewerActivity.this.wo(5);
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
    public void wo(int i) {
        TiebaStatic.log(new an("c13270").bT("uid", this.mUserId).P("obj_type", i));
    }

    private void bho() {
        if (!this.hbt) {
            if (this.hbr == null) {
                this.hbr = new com.baidu.tieba.c.d(getPageContext(), this.hba);
                this.hbr.qf(R.drawable.pic_sign_tip);
                this.hbr.qe(48);
                this.hbr.S(true);
                this.hbr.qg(5000);
                this.hbr.qi(-l.g(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.hbr.q(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.bJV();
                    }
                });
            }
            this.hbr.cJ(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJV() {
        if (this.hbr != null) {
            this.hbr.bcf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bAP() {
        int Z = v.Z(this.hbd);
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
        this.hbg = new i();
        boolean isLogin = com.baidu.tbadk.n.a.isLogin();
        String bduss = com.baidu.tbadk.n.a.getBduss();
        String tbs = com.baidu.tbadk.n.a.getTbs();
        String stoken = com.baidu.tbadk.n.a.getStoken();
        if (bundle != null) {
            this.hbv = bundle.getBoolean(ImageViewerConfig.ABTEST);
            this.hbd = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.eHo = bundle.getString("fid");
            this.bXN = bundle.getString("tid");
            this.fHC = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.cnO = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.hbc = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.hbi = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.cnQ = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.cnR = bundle.getBoolean(ImageViewerConfig.IS_HOT_SORT, false);
            this.hbn = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.haN = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            this.haP = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            if (serializable instanceof Map) {
                this.coZ = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.coZ.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.hbs = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.hbt = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.hbv = intent.getBooleanExtra(ImageViewerConfig.ABTEST, false);
                this.hbd = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.eHo = intent.getStringExtra("fid");
                this.bXN = intent.getStringExtra("tid");
                this.fHC = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.cnO = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.hbc = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.hbi = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.cnQ = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.cnR = intent.getBooleanExtra(ImageViewerConfig.IS_HOT_SORT, false);
                this.hbn = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.hbs = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.hbt = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.haN = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                this.haP = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.coZ = (Map) serializableExtra;
                }
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.n.a.fy(isLogin);
        com.baidu.tbadk.n.a.rb(bduss);
        com.baidu.tbadk.n.a.setStoken(stoken);
        com.baidu.tbadk.n.a.setTbs(tbs);
        this.hbg.b(bundle, getIntent());
        this.mCount = v.Z(this.hbd);
        if (this.haN != null) {
            String str = (String) v.c(this.hbd, this.mIndex);
            if (!StringUtils.isNull(str) && this.coZ != null && (imageUrlData = this.coZ.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.haN);
            }
        }
        if (this.mIsSeeHost) {
            TiebaStatic.log(new an("c13337").bT("obj_type", "2"));
        } else {
            TiebaStatic.log(new an("c13337").bT("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.ABTEST, this.hbv);
        bundle.putStringArrayList("url", this.hbd);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.eHo);
        bundle.putString("tid", this.bXN);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.fHC);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.hbc);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.cnQ);
        bundle.putBoolean(ImageViewerConfig.IS_HOT_SORT, this.cnR);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.hbn);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.hbi);
        bundle.putString("user_id", this.mUserId);
        if (this.coZ instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.coZ.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.coZ instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.coZ.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.haN);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.hbs);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.hbt);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.haP);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.n.a.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.n.a.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.n.a.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.n.a.getTbs());
        this.hbg.Z(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.hbb.setCurrentItem(this.mIndex, false);
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
            String ol;
            if (this.mUrl != null && ImageViewerActivity.this.coZ != null) {
                Iterator it = ImageViewerActivity.this.coZ.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ap.ajr().nY(ol) + "/" + as.ol(imageUrlData.originalUrl);
                    int[] nA = m.nA(str);
                    if (nA != null && nA.length == 2 && nA[0] > 0 && m.e(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
                        return ImageViewerActivity.this.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (m.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                    case -2:
                        return m.aih();
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
            ImageViewerActivity.this.hbe = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.hbe = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aq(String str) {
        int i;
        boolean z = false;
        if (this.eFc != null && !isFinishing() && this.eFc.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.hbC = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.eFd);
            this.hbC.a(this.hbJ);
            int i2 = 0;
            while (true) {
                if (i2 < this.eFh.size()) {
                    if (this.hbz == null || this.eFh.get(i2) != this.hbz || (i = i2 + 1) > this.eFh.size()) {
                        i2++;
                    } else {
                        this.eFh.add(i, this.hbC);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.eFh.add(this.hbC);
            }
            this.eFd.W(this.eFh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                n nVar = new n();
                nVar.type = 0;
                nVar.jjG = imageBitmap;
                String currentImageUrl = this.hbb.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    nVar.jjF = String.valueOf(System.currentTimeMillis()) + as.ol(currentImageUrl);
                } else {
                    nVar.jjF = String.valueOf(BdUniqueId.gen().getId());
                }
                this.hbw = nVar.jjF;
                sendMessage(new CustomMessage(2921403, nVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wp(int i) {
        if (this.hbb != null) {
            this.hbb.jZ(i);
            setViewVisibility(this.hba, (this.hbb.aqH() || bJS()) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJW() {
        if (bJS()) {
            this.hbl = this.mNavigationBar.getVisibility() == 0;
            this.hbk = true;
        } else if (this.hbk) {
            this.mNavigationBar.setVisibility(this.hbl ? 0 : 8);
            this.hbk = false;
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
            public boolean avh() {
                return false;
            }

            @Override // com.baidu.tbadk.o.b
            public int avi() {
                return com.baidu.tbadk.o.e.avn().avq();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.e(this.eHo, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.e(this.bXN, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.rf(TbadkCoreApplication.getInst().getAdAdSense().cgM);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.coreExtra.view.a
    public boolean aqy() {
        return this.hbv;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (aq.isEmpty(this.bXN)) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.e(this.bXN, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }
}
