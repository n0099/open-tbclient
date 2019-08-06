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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bb;
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
    private String bWU;
    private boolean cmS;
    private boolean cmU;
    private boolean cmV;
    private Map<String, ImageUrlData> coe;
    private com.baidu.tbadk.core.dialog.i eDt;
    private k eDu;
    private String eFF;
    private com.baidu.tbadk.core.dialog.g eWK;
    private String fFN;
    private String gYT;
    private String gYU;
    private com.baidu.tieba.ueg.c gZD;
    private com.baidu.tbadk.core.dialog.g gZE;
    private com.baidu.tbadk.core.dialog.g gZF;
    private com.baidu.tbadk.core.dialog.g gZG;
    private com.baidu.tbadk.core.dialog.g gZH;
    private com.baidu.tbadk.core.dialog.g gZI;
    private float gZQ;
    private TextView gZg;
    private MultiImageView gZh;
    private ArrayList<String> gZj;
    private a gZk;
    private e gZl;
    private i gZm;
    private boolean gZs;
    private boolean gZt;
    private int gZu;
    private boolean gZv;
    private float gZw;
    private com.baidu.tieba.c.d gZx;
    private boolean gZy;
    private boolean gZz;
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
    private boolean gZi = true;
    private boolean gZn = false;
    private boolean gZo = true;
    private com.baidu.tieba.image.a gZp = null;
    private boolean gZq = false;
    private boolean gZr = false;
    private boolean cye = false;
    private int Sw = 0;
    private boolean gZA = false;
    private boolean gYV = false;
    private boolean gZB = false;
    private String gZC = null;
    private List<com.baidu.tbadk.core.dialog.g> eDy = null;
    private final CustomMessageListener gZJ = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k) && (kVar = (com.baidu.tbadk.data.k) customResponsedMessage.getData()) != null && !StringUtils.isNull(kVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(kVar);
                if (StringUtils.isNull(kVar.cqZ)) {
                    bb.ajE().c(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    bb.ajE().c(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.cqZ});
                }
            }
        }
    };
    private DragImageView.d coI = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void axj() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gZg, 8);
            if (ImageViewerActivity.this.gZh != null) {
                ImageViewerActivity.this.gZh.eU(false);
            }
            ImageViewerActivity.this.bJi();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void axk() {
            TiebaStatic.log(new an("c13341").P("obj_param1", ImageViewerActivity.this.gZh.getItemNum()).P("obj_param2", ImageViewerActivity.this.gZh.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").bT("obj_type", "2"));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void axl() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 0);
            if (ImageViewerActivity.this.gZh != null && !ImageViewerActivity.this.gZh.aqv()) {
                ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gZg, 0);
                ImageViewerActivity.this.gZh.eU(true);
            }
        }
    };
    private UrlDragImageView.b cmK = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void aqP() {
            TiebaStatic.log(new an("c10351").bT("tid", ImageViewerActivity.this.bWU).bT("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final View.OnClickListener gZK = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jQ()) {
                ImageViewerActivity.this.showToast(R.string.neterror);
                return;
            }
            TiebaStatic.log(new an("pb_onlyowner_click").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).P("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
            TiebaStatic.log(new an("c13338").P("obj_locate", ImageViewerActivity.this.mIsSeeHost ? 1 : 2));
            ImageViewerActivity.this.gZs = true;
            if (ImageViewerActivity.this.gZg != null) {
                ImageViewerActivity.this.gZg.setEnabled(false);
            }
            ImageViewerActivity.this.k(d.zN((String) v.c(ImageViewerActivity.this.gZj, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
        }
    };
    private k.b gZL = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.22
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            ImageViewerActivity.this.gZh.jZ(ImageViewerActivity.this.bAb());
            ImageViewerActivity.this.aZK();
        }
    };
    private k.b gZM = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.23
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aA(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.gZh.getCurrentImageUrl());
            ImageViewerActivity.this.aZK();
            ImageViewerActivity.this.wl(1);
        }
    };
    private k.b gZN = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = ImageViewerActivity.this.gZh.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.cwj);
                intent.putExtra(com.baidu.tbadk.imageManager.d.cwk, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            ImageViewerActivity.this.aZK();
            ImageViewerActivity.this.wl(2);
        }
    };
    private k.b eWL = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
            if (ImageViewerActivity.this.mPermissionJudgement == null) {
                ImageViewerActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            ImageViewerActivity.this.mPermissionJudgement.ajS();
            ImageViewerActivity.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!ImageViewerActivity.this.mPermissionJudgement.ad(pageActivity)) {
                ImageViewerActivity.this.saveImage();
                ImageViewerActivity.this.aZK();
                ImageViewerActivity.this.wl(3);
            }
        }
    };
    private k.b gZO = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            UrlDragImageView currentUrlDragImageView;
            if (ImageViewerActivity.this.gZh != null && (currentUrlDragImageView = ImageViewerActivity.this.gZh.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.d.c.oj(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = ImageViewerActivity.this.gZh.getCurrentImageUrl();
                    str2 = at.oj(str);
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
                    eVar.ckM = bundle;
                }
                ImageViewerActivity.this.sendMessage(new CustomMessage(2001276, new ShareDialogConfig(ImageViewerActivity.this.getActivity(), eVar, false)));
                ImageViewerActivity.this.aZK();
                ImageViewerActivity.this.wl(4);
            }
        }
    };
    private k.b gZP = new AnonymousClass5();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (ImageViewerActivity.this.gZB && ImageViewerActivity.this.gZh != null) {
                boolean aqv = ImageViewerActivity.this.gZh.aqv();
                if (!aqv) {
                    com.baidu.tieba.t.a.I(ImageViewerActivity.this.gZg, 100);
                    i = 1;
                } else {
                    com.baidu.tieba.t.a.J(ImageViewerActivity.this.gZg, 100);
                    i = 2;
                }
                ImageViewerActivity.this.gZh.g(aqv ? false : true, 100);
                TiebaStatic.log(new an("c13397").P("obj_type", i));
                return;
            }
            TiebaStatic.log(new an("c13341").P("obj_param1", ImageViewerActivity.this.gZh.getItemNum()).P("obj_param2", ImageViewerActivity.this.gZh.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").bT("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean gZR = true;
    private View.OnTouchListener coV = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.gZQ = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.gZR = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.gZQ = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.gZR = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener gZS = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.bfD();
            ImageViewerActivity.this.show();
            ImageViewerActivity.this.cj(view);
            TiebaStatic.log(new an("c13269").bT("uid", ImageViewerActivity.this.mUserId).bT("fid", ImageViewerActivity.this.eFF).bT("tid", ImageViewerActivity.this.bWU));
            return true;
        }
    };
    private BaseViewPager.a gZT = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void iy(int i) {
            if (i == 0) {
                ImageViewerActivity.this.gZl.bIQ();
            } else if (ImageViewerActivity.this.bJd() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.gZl.bIR();
            }
        }
    };
    private ViewPager.OnPageChangeListener ceh = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.gZl != null && i > ImageViewerActivity.this.gZh.getItemNum() - 5) {
                ImageViewerActivity.this.gZl.bIQ();
            }
            ImageViewerActivity.this.gZm.e(ImageViewerActivity.this.gZj, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.bJe();
            ImageViewerActivity.this.bJj();
            ImageViewerActivity.this.wm(i);
            if (ImageViewerActivity.this.gZm.bJn() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.gZm.wn(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.gZm.bJo() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.gZm.wo(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.bJf()) {
                ImageViewerActivity.this.gZp.bIE();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.gZh.getItemNum() - 1) {
                ImageViewerActivity.this.gZn = false;
            }
            ImageViewerActivity.this.gZC = null;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.Sw) {
                ImageViewerActivity.this.Sw = i;
                ImageViewerActivity.this.cye = true;
            } else if (i < ImageViewerActivity.this.Sw) {
                ImageViewerActivity.this.Sw = i;
                ImageViewerActivity.this.cye = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.gZj != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.gZj.size()) {
                ImageViewerActivity.this.gZm.as(i, (String) ImageViewerActivity.this.gZj.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.gZh.getItemNum() - 1) {
                if (!ImageViewerActivity.this.gZR || !ImageViewerActivity.this.gZv || (!ImageViewerActivity.this.gZn && !ImageViewerActivity.this.bJf() && (ImageViewerActivity.this.gZh.getItemNum() != 1 || !ImageViewerActivity.this.cye))) {
                    ImageViewerActivity.this.gZn = true;
                } else {
                    ImageViewerActivity.this.showToast(R.string.last_page);
                }
            }
        }
    };
    private CustomMessageListener bWA = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.coe != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.coe.values()) {
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
    private CustomMessageListener bWB = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.coe != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.coe.values()) {
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
    private CustomMessageListener gZU = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && !ImageViewerActivity.this.isFinishing() && (nVar = (n) customResponsedMessage.getData()) != null) {
                nVar.jhk = null;
                if (!TextUtils.isEmpty(nVar.jhm) && !TextUtils.isEmpty(nVar.jhj) && nVar.jhj.equals(ImageViewerActivity.this.gZC)) {
                    ImageViewerActivity.this.gZh.setCurrentImageQRInfo(nVar.jhm);
                    ImageViewerActivity.this.zR(nVar.jhm);
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
        com.baidu.tbadk.n.b.aue().c(TbadkCoreApplication.getInst());
        this.gZu = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        buY();
        if (com.baidu.tbadk.core.util.g.ahZ()) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
        this.gYU = d.zN((String) v.c(this.gZj, this.mIndex));
        if (d.zO((String) v.c(this.gZj, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        k(this.gYU, this.mIsSeeHost, false);
        MessageManager.getInstance().registerListener(this.gZJ);
        registerListener(this.bWA);
        registerListener(this.bWB);
        registerListener(this.gZU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.gZl = new e(this.gZj, this.coe, this.eFF, this.fFN, this.bWU, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.gZl.setSourceImageRectInScreen(this.gYT);
        this.gZl.mT(this.gZi);
        this.gZl.mU(z);
        this.gZl.zP(this.gYU);
        this.gZl.mS(this.gYV);
        this.gZl.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.gZh != null) {
                    if (ImageViewerActivity.this.gZs) {
                        if (!z5) {
                            ImageViewerActivity.this.gZh.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.gZs = false;
                    if (ImageViewerActivity.this.gZg != null) {
                        ImageViewerActivity.this.gZg.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.gZh.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.gZh.getItemNum();
                        ImageViewerActivity.this.gZh.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.gZh.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.gZh.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.gZp != null) {
                        ImageViewerActivity.this.gZp.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.gZh.setUrlData(arrayList);
                    ImageViewerActivity.this.gZh.setAssistUrls(ImageViewerActivity.this.coe);
                    ImageViewerActivity.this.gZh.setHasNext(z3);
                    ImageViewerActivity.this.gZh.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.gZh.getItemNum()) {
                        ImageViewerActivity.this.gZh.jX(ImageViewerActivity.this.gZh.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.gZh.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList.size() >= 400 && ImageViewerActivity.this.gZh.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.gZh.setUrlData(arrayList);
                        ImageViewerActivity.this.gZh.setCurrentItem(ImageViewerActivity.this.gZh.getCurrentItem() - 200, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.bJe();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.gZh.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.gZp.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.gZp.bIA()) {
                    ImageViewerActivity.this.gZh.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.q.a.b("a008", "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.gZh.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void ar(int i, String str2) {
                ImageViewerActivity.this.gZs = false;
                if (ImageViewerActivity.this.gZg != null) {
                    ImageViewerActivity.this.gZg.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.gZj.size();
                    ImageViewerActivity.this.bJe();
                }
            }
        });
        this.gZl.mV(true);
        this.gZl.bIQ();
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
            this.gZk = new a(this.gZh.getCurrentImageUrl(), this.gZh.getCurrentImageData());
            this.gZk.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gZh.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.gZh.iG(i);
        super.onChangeSkinType(i);
        this.gZu = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gZh.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long c = com.baidu.adp.lib.g.b.c(this.bWU, 0L);
        if (uniqueId != null && c > 0) {
            q.m(uniqueId.getId(), c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gZh.onResume();
        this.mIsLogin = com.baidu.tbadk.n.a.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long c = com.baidu.adp.lib.g.b.c(this.bWU, 0L);
        if (uniqueId != null && c > 0) {
            q.a(com.baidu.tbadk.BdToken.b.bxV, uniqueId.getId(), c);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.gZh.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gZD != null && !this.gZD.isCancelled()) {
            this.gZD.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.gZJ);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.aty().atz();
        this.gZm.e(this.gZj, this.mIndex, this.mIndex);
        this.gZm.bJp();
        String str = "";
        if (this.gZp != null) {
            str = this.gZp.getAdId();
        }
        this.gZm.d(this.gZh.getPageCount(), str, this.eFF, this.bWU);
        this.gZh.onDestroy();
        if (this.gZk != null) {
            this.gZk.cancel();
            this.gZk = null;
        }
        com.baidu.tbadk.download.d.arU().kk(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.gZu);
        bJi();
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

    private void buY() {
        this.mStatusBarView = findViewById(R.id.statusbar_view);
        aJt();
        initViewPager();
        bJe();
        bgI();
        bfC();
        this.gZm.e(this.gZj, this.mIndex, this.mIndex);
    }

    private void aJt() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.gZg = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(R.id.see_host_image_txt);
        if (this.gZz) {
            setViewVisibility(this.gZg, 8);
        }
        if (this.gZt) {
            if (this.mIsSeeHost) {
                this.gZg.setText(R.string.album_all_thread);
            } else {
                this.gZg.setText(R.string.view_host);
            }
            this.gZg.setOnClickListener(this.gZK);
        } else {
            setViewVisibility(this.gZg, 8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_btn_a));
        this.mTitleView.setTextSize(0, l.g(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long bJd() {
        ImageUrlData imageUrlData;
        String str = (String) v.c(this.gZj, this.mIndex);
        if (this.coe == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.coe.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJe() {
        String str;
        if (this.gZj != null) {
            String str2 = ("" + bJd()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (this.mFrom != null && !this.gZA && bJd() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new an("c13316").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom));
                this.gZA = true;
            }
            if (bJf()) {
                bJg();
            } else {
                zQ(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJf() {
        if (this.gZo && this.gZp != null && this.gZp.bIA()) {
            return this.gZh.getItemNum() != 1 && this.mIndex == this.gZh.getItemNum() + (-1);
        }
        return false;
    }

    private void zQ(String str) {
        this.mTitleView.setText(str);
        if (this.gZt && !this.gZz) {
            if (this.mIsSeeHost) {
                this.gZg.setText(R.string.album_all_thread);
            } else {
                this.gZg.setText(R.string.view_host);
            }
        }
    }

    private void bJg() {
        this.mTitleView.setText("");
        setViewVisibility(this.gZg, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.gZh == null) {
            this.gZh = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.gZh.init();
        }
        this.gZh.setIsFromCDN(this.cmS);
        this.gZh.setIsCanDrag(this.cmU);
        this.gZh.setIsHotSort(this.cmV);
        this.gZh.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.gZh.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.gZh.setOnPageChangeListener(this.ceh);
        this.gZh.setUrlData(this.gZj);
        this.gZh.setAssistUrls(this.coe);
        this.gZh.setOuterOnTouchListener(this.coV);
        this.gZh.setItemOnclickListener(this.mOnClickListener);
        this.gZh.setItemOnLongClickListener(this.gZS);
        this.gZh.setCurrentItem(bAb(), false);
        this.gZh.setOnScrollOutListener(this.gZT);
        this.gZp = new com.baidu.tieba.image.a(this.cmS, this.gZo, getPageContext(), this.eFF, this.bWU);
        this.gZp.setDragToExitListener(this.coI);
        this.gZh.a(this.gZp);
        this.gZh.setOriImgSelectedCallback(this.cmK);
        this.gZh.setDragToExitListener(this.coI);
        this.gZh.setUserId(this.mUserId);
        this.gZh.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.gZv = ImageViewerActivity.this.gZw - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.gZw = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        TiebaStatic.log(new an("c13340").bT("uid", this.mUserId).bT("post_id", this.bWU).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bJh()));
    }

    private int bJh() {
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

    private void bfC() {
        if (this.eDt == null) {
            this.eDu = new k(this);
        }
        if (this.eDy == null) {
            this.eDy = new ArrayList();
        }
        bfD();
        this.eDt = new com.baidu.tbadk.core.dialog.i(getPageContext(), this.eDu.ahd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfD() {
        this.eDy.clear();
        String jY = this.gZh.jY(bAb());
        if (jY != null) {
            this.gZE = new com.baidu.tbadk.core.dialog.g(jY, this.eDu);
            this.gZE.a(this.gZL);
            this.eDy.add(this.gZE);
        }
        this.eWK = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.eDu);
        this.eWK.a(this.eWL);
        this.eDy.add(this.eWK);
        this.gZG = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.eDu);
        this.gZG.a(this.gZN);
        this.eDy.add(this.gZG);
        this.gZF = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.eDu);
        this.gZF.a(this.gZM);
        this.eDy.add(this.gZF);
        String currentImageQRInfo = this.gZh.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.gZI = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.eDu);
            this.gZI.a(this.gZP);
            this.eDy.add(this.gZI);
        }
        this.gZH = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.eDu);
        this.gZH.a(this.gZO);
        this.eDy.add(this.gZH);
        this.eDu.a(new k.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                ImageViewerActivity.this.aZK();
            }
        });
        this.eDu.W(this.eDy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZK() {
        if (this.eDt != null && this.eDt.isShowing()) {
            this.eDt.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show() {
        if (this.eDt != null && !isFinishing()) {
            this.eDt.showDialog();
        }
    }

    /* renamed from: com.baidu.tieba.image.ImageViewerActivity$5  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass5 implements k.b {
        AnonymousClass5() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = ImageViewerActivity.this.gZh.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (l.kt()) {
                    if (ImageViewerActivity.this.gZD != null && !ImageViewerActivity.this.gZD.isCancelled()) {
                        ImageViewerActivity.this.gZD.cancel();
                    }
                    ImageViewerActivity.this.gZD = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.5.1
                        @Override // com.baidu.tieba.ueg.c.a
                        public void bJk() {
                            ImageViewerActivity.this.openUrl(currentImageQRInfo);
                        }

                        @Override // com.baidu.tieba.ueg.c.a
                        public void bJl() {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ImageViewerActivity.this.getPageContext().getPageActivity());
                            aVar.dX(true);
                            aVar.mN(ImageViewerActivity.this.getString(R.string.qr_url_jump_external_title));
                            aVar.dW(true);
                            aVar.mO(ImageViewerActivity.this.getString(R.string.qr_url_jump_external_message));
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
                            aVar.b(ImageViewerActivity.this.getPageContext()).agK();
                        }

                        @Override // com.baidu.tieba.ueg.c.a
                        public void bJm() {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ImageViewerActivity.this.getPageContext().getPageActivity());
                            aVar.mN(null);
                            aVar.dW(true);
                            aVar.mO(ImageViewerActivity.this.getString(R.string.qr_url_risk_forbid));
                            aVar.a(ImageViewerActivity.this.getPageContext().getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.5.1.3
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                    aVar2.dismiss();
                                }
                            });
                            aVar.dQ(false);
                            aVar.dR(false);
                            aVar.b(ImageViewerActivity.this.getPageContext()).agK();
                        }

                        @Override // com.baidu.tieba.ueg.c.a
                        public void onError(String str) {
                            l.showToast(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.getPageContext().getResources().getString(R.string.qr_scan_error));
                        }
                    });
                    ImageViewerActivity.this.gZD.setPriority(3);
                    ImageViewerActivity.this.gZD.execute(new String[0]);
                    ImageViewerActivity.this.aZK();
                    ImageViewerActivity.this.wl(5);
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
    public void wl(int i) {
        TiebaStatic.log(new an("c13270").bT("uid", this.mUserId).P("obj_type", i));
    }

    private void bgI() {
        if (!this.gZz) {
            if (this.gZx == null) {
                this.gZx = new com.baidu.tieba.c.d(getPageContext(), this.gZg);
                this.gZx.qc(R.drawable.pic_sign_tip);
                this.gZx.qb(48);
                this.gZx.S(true);
                this.gZx.qd(UIMsg.m_AppUI.MSG_APP_GPS);
                this.gZx.qf(-l.g(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.gZx.q(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.bJi();
                    }
                });
            }
            this.gZx.cI(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJi() {
        if (this.gZx != null) {
            this.gZx.bbB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bAb() {
        int Z = v.Z(this.gZj);
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
        this.gZm = new i();
        boolean isLogin = com.baidu.tbadk.n.a.isLogin();
        String bduss = com.baidu.tbadk.n.a.getBduss();
        String tbs = com.baidu.tbadk.n.a.getTbs();
        String stoken = com.baidu.tbadk.n.a.getStoken();
        if (bundle != null) {
            this.gZB = bundle.getBoolean(ImageViewerConfig.ABTEST);
            this.gZj = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.eFF = bundle.getString("fid");
            this.bWU = bundle.getString("tid");
            this.fFN = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.cmS = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.gZi = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.gZo = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.cmU = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.cmV = bundle.getBoolean(ImageViewerConfig.IS_HOT_SORT, false);
            this.gZt = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.gYT = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            this.gYV = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            if (serializable instanceof Map) {
                this.coe = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.coe.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.gZy = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.gZz = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.gZB = intent.getBooleanExtra(ImageViewerConfig.ABTEST, false);
                this.gZj = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.eFF = intent.getStringExtra("fid");
                this.bWU = intent.getStringExtra("tid");
                this.fFN = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.cmS = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.gZi = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.gZo = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.cmU = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.cmV = intent.getBooleanExtra(ImageViewerConfig.IS_HOT_SORT, false);
                this.gZt = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.gZy = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.gZz = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.gYT = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                this.gYV = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.coe = (Map) serializableExtra;
                }
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.n.a.fv(isLogin);
        com.baidu.tbadk.n.a.qQ(bduss);
        com.baidu.tbadk.n.a.setStoken(stoken);
        com.baidu.tbadk.n.a.setTbs(tbs);
        this.gZm.b(bundle, getIntent());
        this.mCount = v.Z(this.gZj);
        if (this.gYT != null) {
            String str = (String) v.c(this.gZj, this.mIndex);
            if (!StringUtils.isNull(str) && this.coe != null && (imageUrlData = this.coe.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.gYT);
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
        bundle.putBoolean(ImageViewerConfig.ABTEST, this.gZB);
        bundle.putStringArrayList("url", this.gZj);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.eFF);
        bundle.putString("tid", this.bWU);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.fFN);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.gZi);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.cmU);
        bundle.putBoolean(ImageViewerConfig.IS_HOT_SORT, this.cmV);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.gZt);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.gZo);
        bundle.putString("user_id", this.mUserId);
        if (this.coe instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.coe.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.coe instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.coe.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.gYT);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.gZy);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.gZz);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.gYV);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.n.a.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.n.a.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.n.a.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.n.a.getTbs());
        this.gZm.Z(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.gZh.setCurrentItem(this.mIndex, false);
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
            String oj;
            if (this.mUrl != null && ImageViewerActivity.this.coe != null) {
                Iterator it = ImageViewerActivity.this.coe.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ap.ajl().nW(oj) + "/" + at.oj(imageUrlData.originalUrl);
                    int[] ny = m.ny(str);
                    if (ny != null && ny.length == 2 && ny[0] > 0 && m.e(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
                        return ImageViewerActivity.this.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (m.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                    case -2:
                        return m.aid();
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
            ImageViewerActivity.this.gZk = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.gZk = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zR(String str) {
        int i;
        boolean z = false;
        if (this.eDt != null && !isFinishing() && this.eDt.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.gZI = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.eDu);
            this.gZI.a(this.gZP);
            int i2 = 0;
            while (true) {
                if (i2 < this.eDy.size()) {
                    if (this.gZF == null || this.eDy.get(i2) != this.gZF || (i = i2 + 1) > this.eDy.size()) {
                        i2++;
                    } else {
                        this.eDy.add(i, this.gZI);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.eDy.add(this.gZI);
            }
            this.eDu.W(this.eDy);
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
                nVar.jhk = imageBitmap;
                String currentImageUrl = this.gZh.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    nVar.jhj = String.valueOf(System.currentTimeMillis()) + at.oj(currentImageUrl);
                } else {
                    nVar.jhj = String.valueOf(BdUniqueId.gen().getId());
                }
                this.gZC = nVar.jhj;
                sendMessage(new CustomMessage(2921403, nVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wm(int i) {
        if (this.gZh != null) {
            this.gZh.jW(i);
            setViewVisibility(this.gZg, (this.gZh.aqv() || bJf()) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJj() {
        if (bJf()) {
            this.gZr = this.mNavigationBar.getVisibility() == 0;
            this.gZq = true;
        } else if (this.gZq) {
            this.mNavigationBar.setVisibility(this.gZr ? 0 : 8);
            this.gZq = false;
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
            public boolean auV() {
                return false;
            }

            @Override // com.baidu.tbadk.o.b
            public int auW() {
                return com.baidu.tbadk.o.e.avb().ave();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eFF, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.bWU, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.qU(TbadkCoreApplication.getInst().getAdAdSense().cfT);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.coreExtra.view.a
    public boolean aqm() {
        return this.gZB;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (aq.isEmpty(this.bWU)) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.c(this.bWU, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }
}
