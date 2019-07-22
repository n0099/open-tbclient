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
    private String bWO;
    private boolean cmL;
    private boolean cmN;
    private boolean cmO;
    private Map<String, ImageUrlData> cnX;
    private com.baidu.tbadk.core.dialog.i eDm;
    private k eDn;
    private String eFy;
    private com.baidu.tbadk.core.dialog.g eWA;
    private String fEZ;
    private boolean gYA;
    private boolean gYB;
    private int gYC;
    private boolean gYD;
    private float gYE;
    private com.baidu.tieba.c.d gYF;
    private boolean gYG;
    private boolean gYH;
    private com.baidu.tieba.ueg.c gYL;
    private com.baidu.tbadk.core.dialog.g gYM;
    private com.baidu.tbadk.core.dialog.g gYN;
    private com.baidu.tbadk.core.dialog.g gYO;
    private com.baidu.tbadk.core.dialog.g gYP;
    private com.baidu.tbadk.core.dialog.g gYQ;
    private float gYY;
    private String gYb;
    private String gYc;
    private TextView gYo;
    private MultiImageView gYp;
    private ArrayList<String> gYr;
    private a gYs;
    private e gYt;
    private i gYu;
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
    private boolean gYq = true;
    private boolean gYv = false;
    private boolean gYw = true;
    private com.baidu.tieba.image.a gYx = null;
    private boolean gYy = false;
    private boolean gYz = false;
    private boolean cxX = false;
    private int Sw = 0;
    private boolean gYI = false;
    private boolean gYd = false;
    private boolean gYJ = false;
    private String gYK = null;
    private List<com.baidu.tbadk.core.dialog.g> eDr = null;
    private final CustomMessageListener gYR = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k) && (kVar = (com.baidu.tbadk.data.k) customResponsedMessage.getData()) != null && !StringUtils.isNull(kVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(kVar);
                if (StringUtils.isNull(kVar.cqS)) {
                    bb.ajC().c(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    bb.ajC().c(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.cqS});
                }
            }
        }
    };
    private DragImageView.d coB = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void axh() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gYo, 8);
            if (ImageViewerActivity.this.gYp != null) {
                ImageViewerActivity.this.gYp.eU(false);
            }
            ImageViewerActivity.this.bIU();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void axi() {
            TiebaStatic.log(new an("c13341").P("obj_param1", ImageViewerActivity.this.gYp.getItemNum()).P("obj_param2", ImageViewerActivity.this.gYp.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").bT("obj_type", "2"));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void axj() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 0);
            if (ImageViewerActivity.this.gYp != null && !ImageViewerActivity.this.gYp.aqt()) {
                ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gYo, 0);
                ImageViewerActivity.this.gYp.eU(true);
            }
        }
    };
    private UrlDragImageView.b cmD = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void aqN() {
            TiebaStatic.log(new an("c10351").bT("tid", ImageViewerActivity.this.bWO).bT("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final View.OnClickListener gYS = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jQ()) {
                ImageViewerActivity.this.showToast(R.string.neterror);
                return;
            }
            TiebaStatic.log(new an("pb_onlyowner_click").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).P("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
            TiebaStatic.log(new an("c13338").P("obj_locate", ImageViewerActivity.this.mIsSeeHost ? 1 : 2));
            ImageViewerActivity.this.gYA = true;
            if (ImageViewerActivity.this.gYo != null) {
                ImageViewerActivity.this.gYo.setEnabled(false);
            }
            ImageViewerActivity.this.k(d.zM((String) v.c(ImageViewerActivity.this.gYr, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
        }
    };
    private k.b gYT = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.22
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            ImageViewerActivity.this.gYp.jY(ImageViewerActivity.this.bzN());
            ImageViewerActivity.this.aZI();
        }
    };
    private k.b gYU = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.23
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aA(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.gYp.getCurrentImageUrl());
            ImageViewerActivity.this.aZI();
            ImageViewerActivity.this.wj(1);
        }
    };
    private k.b gYV = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = ImageViewerActivity.this.gYp.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.cwc);
                intent.putExtra(com.baidu.tbadk.imageManager.d.cwd, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            ImageViewerActivity.this.aZI();
            ImageViewerActivity.this.wj(2);
        }
    };
    private k.b eWB = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
            if (ImageViewerActivity.this.mPermissionJudgement == null) {
                ImageViewerActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            ImageViewerActivity.this.mPermissionJudgement.ajQ();
            ImageViewerActivity.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!ImageViewerActivity.this.mPermissionJudgement.ad(pageActivity)) {
                ImageViewerActivity.this.saveImage();
                ImageViewerActivity.this.aZI();
                ImageViewerActivity.this.wj(3);
            }
        }
    };
    private k.b gYW = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            UrlDragImageView currentUrlDragImageView;
            if (ImageViewerActivity.this.gYp != null && (currentUrlDragImageView = ImageViewerActivity.this.gYp.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.d.c.oj(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = ImageViewerActivity.this.gYp.getCurrentImageUrl();
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
                    eVar.ckF = bundle;
                }
                ImageViewerActivity.this.sendMessage(new CustomMessage(2001276, new ShareDialogConfig(ImageViewerActivity.this.getActivity(), eVar, false)));
                ImageViewerActivity.this.aZI();
                ImageViewerActivity.this.wj(4);
            }
        }
    };
    private k.b gYX = new AnonymousClass5();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (ImageViewerActivity.this.gYJ && ImageViewerActivity.this.gYp != null) {
                boolean aqt = ImageViewerActivity.this.gYp.aqt();
                if (!aqt) {
                    com.baidu.tieba.t.a.I(ImageViewerActivity.this.gYo, 100);
                    i = 1;
                } else {
                    com.baidu.tieba.t.a.J(ImageViewerActivity.this.gYo, 100);
                    i = 2;
                }
                ImageViewerActivity.this.gYp.g(aqt ? false : true, 100);
                TiebaStatic.log(new an("c13397").P("obj_type", i));
                return;
            }
            TiebaStatic.log(new an("c13341").P("obj_param1", ImageViewerActivity.this.gYp.getItemNum()).P("obj_param2", ImageViewerActivity.this.gYp.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").bT("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean gYZ = true;
    private View.OnTouchListener coO = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.gYY = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.gYZ = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.gYY = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.gYZ = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener gZa = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.bfB();
            ImageViewerActivity.this.show();
            ImageViewerActivity.this.ci(view);
            TiebaStatic.log(new an("c13269").bT("uid", ImageViewerActivity.this.mUserId).bT("fid", ImageViewerActivity.this.eFy).bT("tid", ImageViewerActivity.this.bWO));
            return true;
        }
    };
    private BaseViewPager.a gZb = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void iy(int i) {
            if (i == 0) {
                ImageViewerActivity.this.gYt.bIC();
            } else if (ImageViewerActivity.this.bIP() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.gYt.bID();
            }
        }
    };
    private ViewPager.OnPageChangeListener cea = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.gYt != null && i > ImageViewerActivity.this.gYp.getItemNum() - 5) {
                ImageViewerActivity.this.gYt.bIC();
            }
            ImageViewerActivity.this.gYu.e(ImageViewerActivity.this.gYr, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.bIQ();
            ImageViewerActivity.this.bIV();
            ImageViewerActivity.this.wk(i);
            if (ImageViewerActivity.this.gYu.bIZ() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.gYu.wl(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.gYu.bJa() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.gYu.wm(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.bIR()) {
                ImageViewerActivity.this.gYx.bIq();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.gYp.getItemNum() - 1) {
                ImageViewerActivity.this.gYv = false;
            }
            ImageViewerActivity.this.gYK = null;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.Sw) {
                ImageViewerActivity.this.Sw = i;
                ImageViewerActivity.this.cxX = true;
            } else if (i < ImageViewerActivity.this.Sw) {
                ImageViewerActivity.this.Sw = i;
                ImageViewerActivity.this.cxX = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.gYr != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.gYr.size()) {
                ImageViewerActivity.this.gYu.as(i, (String) ImageViewerActivity.this.gYr.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.gYp.getItemNum() - 1) {
                if (!ImageViewerActivity.this.gYZ || !ImageViewerActivity.this.gYD || (!ImageViewerActivity.this.gYv && !ImageViewerActivity.this.bIR() && (ImageViewerActivity.this.gYp.getItemNum() != 1 || !ImageViewerActivity.this.cxX))) {
                    ImageViewerActivity.this.gYv = true;
                } else {
                    ImageViewerActivity.this.showToast(R.string.last_page);
                }
            }
        }
    };
    private CustomMessageListener bWu = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.cnX != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.cnX.values()) {
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
    private CustomMessageListener bWv = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.cnX != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.cnX.values()) {
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
    private CustomMessageListener gZc = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && !ImageViewerActivity.this.isFinishing() && (nVar = (n) customResponsedMessage.getData()) != null) {
                nVar.jgd = null;
                if (!TextUtils.isEmpty(nVar.jgf) && !TextUtils.isEmpty(nVar.jgc) && nVar.jgc.equals(ImageViewerActivity.this.gYK)) {
                    ImageViewerActivity.this.gYp.setCurrentImageQRInfo(nVar.jgf);
                    ImageViewerActivity.this.zQ(nVar.jgf);
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
        com.baidu.tbadk.n.b.auc().c(TbadkCoreApplication.getInst());
        this.gYC = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        buL();
        if (com.baidu.tbadk.core.util.g.ahX()) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
        this.gYc = d.zM((String) v.c(this.gYr, this.mIndex));
        if (d.zN((String) v.c(this.gYr, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        k(this.gYc, this.mIsSeeHost, false);
        MessageManager.getInstance().registerListener(this.gYR);
        registerListener(this.bWu);
        registerListener(this.bWv);
        registerListener(this.gZc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.gYt = new e(this.gYr, this.cnX, this.eFy, this.fEZ, this.bWO, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.gYt.setSourceImageRectInScreen(this.gYb);
        this.gYt.mT(this.gYq);
        this.gYt.mU(z);
        this.gYt.zO(this.gYc);
        this.gYt.mS(this.gYd);
        this.gYt.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.gYp != null) {
                    if (ImageViewerActivity.this.gYA) {
                        if (!z5) {
                            ImageViewerActivity.this.gYp.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.gYA = false;
                    if (ImageViewerActivity.this.gYo != null) {
                        ImageViewerActivity.this.gYo.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.gYp.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.gYp.getItemNum();
                        ImageViewerActivity.this.gYp.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.gYp.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.gYp.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.gYx != null) {
                        ImageViewerActivity.this.gYx.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.gYp.setUrlData(arrayList);
                    ImageViewerActivity.this.gYp.setAssistUrls(ImageViewerActivity.this.cnX);
                    ImageViewerActivity.this.gYp.setHasNext(z3);
                    ImageViewerActivity.this.gYp.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.gYp.getItemNum()) {
                        ImageViewerActivity.this.gYp.jW(ImageViewerActivity.this.gYp.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.gYp.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList.size() >= 400 && ImageViewerActivity.this.gYp.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.gYp.setUrlData(arrayList);
                        ImageViewerActivity.this.gYp.setCurrentItem(ImageViewerActivity.this.gYp.getCurrentItem() - 200, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.bIQ();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.gYp.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.gYx.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.gYx.bIm()) {
                    ImageViewerActivity.this.gYp.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.q.a.b("a008", "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.gYp.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void ar(int i, String str2) {
                ImageViewerActivity.this.gYA = false;
                if (ImageViewerActivity.this.gYo != null) {
                    ImageViewerActivity.this.gYo.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.gYr.size();
                    ImageViewerActivity.this.bIQ();
                }
            }
        });
        this.gYt.mV(true);
        this.gYt.bIC();
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
            this.gYs = new a(this.gYp.getCurrentImageUrl(), this.gYp.getCurrentImageData());
            this.gYs.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gYp.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.gYp.iG(i);
        super.onChangeSkinType(i);
        this.gYC = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gYp.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long c = com.baidu.adp.lib.g.b.c(this.bWO, 0L);
        if (uniqueId != null && c > 0) {
            q.m(uniqueId.getId(), c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gYp.onResume();
        this.mIsLogin = com.baidu.tbadk.n.a.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long c = com.baidu.adp.lib.g.b.c(this.bWO, 0L);
        if (uniqueId != null && c > 0) {
            q.a(com.baidu.tbadk.BdToken.b.bxV, uniqueId.getId(), c);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.gYp.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gYL != null && !this.gYL.isCancelled()) {
            this.gYL.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.gYR);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.atw().atx();
        this.gYu.e(this.gYr, this.mIndex, this.mIndex);
        this.gYu.bJb();
        String str = "";
        if (this.gYx != null) {
            str = this.gYx.getAdId();
        }
        this.gYu.d(this.gYp.getPageCount(), str, this.eFy, this.bWO);
        this.gYp.onDestroy();
        if (this.gYs != null) {
            this.gYs.cancel();
            this.gYs = null;
        }
        com.baidu.tbadk.download.d.arS().kj(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.gYC);
        bIU();
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

    private void buL() {
        this.mStatusBarView = findViewById(R.id.statusbar_view);
        aJr();
        initViewPager();
        bIQ();
        bgF();
        bfA();
        this.gYu.e(this.gYr, this.mIndex, this.mIndex);
    }

    private void aJr() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.gYo = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(R.id.see_host_image_txt);
        if (this.gYH) {
            setViewVisibility(this.gYo, 8);
        }
        if (this.gYB) {
            if (this.mIsSeeHost) {
                this.gYo.setText(R.string.album_all_thread);
            } else {
                this.gYo.setText(R.string.view_host);
            }
            this.gYo.setOnClickListener(this.gYS);
        } else {
            setViewVisibility(this.gYo, 8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_btn_a));
        this.mTitleView.setTextSize(0, l.g(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long bIP() {
        ImageUrlData imageUrlData;
        String str = (String) v.c(this.gYr, this.mIndex);
        if (this.cnX == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.cnX.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIQ() {
        String str;
        if (this.gYr != null) {
            String str2 = ("" + bIP()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (this.mFrom != null && !this.gYI && bIP() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new an("c13316").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom));
                this.gYI = true;
            }
            if (bIR()) {
                bIS();
            } else {
                zP(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIR() {
        if (this.gYw && this.gYx != null && this.gYx.bIm()) {
            return this.gYp.getItemNum() != 1 && this.mIndex == this.gYp.getItemNum() + (-1);
        }
        return false;
    }

    private void zP(String str) {
        this.mTitleView.setText(str);
        if (this.gYB && !this.gYH) {
            if (this.mIsSeeHost) {
                this.gYo.setText(R.string.album_all_thread);
            } else {
                this.gYo.setText(R.string.view_host);
            }
        }
    }

    private void bIS() {
        this.mTitleView.setText("");
        setViewVisibility(this.gYo, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.gYp == null) {
            this.gYp = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.gYp.init();
        }
        this.gYp.setIsFromCDN(this.cmL);
        this.gYp.setIsCanDrag(this.cmN);
        this.gYp.setIsHotSort(this.cmO);
        this.gYp.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.gYp.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.gYp.setOnPageChangeListener(this.cea);
        this.gYp.setUrlData(this.gYr);
        this.gYp.setAssistUrls(this.cnX);
        this.gYp.setOuterOnTouchListener(this.coO);
        this.gYp.setItemOnclickListener(this.mOnClickListener);
        this.gYp.setItemOnLongClickListener(this.gZa);
        this.gYp.setCurrentItem(bzN(), false);
        this.gYp.setOnScrollOutListener(this.gZb);
        this.gYx = new com.baidu.tieba.image.a(this.cmL, this.gYw, getPageContext(), this.eFy, this.bWO);
        this.gYx.setDragToExitListener(this.coB);
        this.gYp.a(this.gYx);
        this.gYp.setOriImgSelectedCallback(this.cmD);
        this.gYp.setDragToExitListener(this.coB);
        this.gYp.setUserId(this.mUserId);
        this.gYp.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.gYD = ImageViewerActivity.this.gYE - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.gYE = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        TiebaStatic.log(new an("c13340").bT("uid", this.mUserId).bT("post_id", this.bWO).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bIT()));
    }

    private int bIT() {
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

    private void bfA() {
        if (this.eDm == null) {
            this.eDn = new k(this);
        }
        if (this.eDr == null) {
            this.eDr = new ArrayList();
        }
        bfB();
        this.eDm = new com.baidu.tbadk.core.dialog.i(getPageContext(), this.eDn.ahb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfB() {
        this.eDr.clear();
        String jX = this.gYp.jX(bzN());
        if (jX != null) {
            this.gYM = new com.baidu.tbadk.core.dialog.g(jX, this.eDn);
            this.gYM.a(this.gYT);
            this.eDr.add(this.gYM);
        }
        this.eWA = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.eDn);
        this.eWA.a(this.eWB);
        this.eDr.add(this.eWA);
        this.gYO = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.eDn);
        this.gYO.a(this.gYV);
        this.eDr.add(this.gYO);
        this.gYN = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.eDn);
        this.gYN.a(this.gYU);
        this.eDr.add(this.gYN);
        String currentImageQRInfo = this.gYp.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.gYQ = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.eDn);
            this.gYQ.a(this.gYX);
            this.eDr.add(this.gYQ);
        }
        this.gYP = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.eDn);
        this.gYP.a(this.gYW);
        this.eDr.add(this.gYP);
        this.eDn.a(new k.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                ImageViewerActivity.this.aZI();
            }
        });
        this.eDn.W(this.eDr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZI() {
        if (this.eDm != null && this.eDm.isShowing()) {
            this.eDm.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show() {
        if (this.eDm != null && !isFinishing()) {
            this.eDm.showDialog();
        }
    }

    /* renamed from: com.baidu.tieba.image.ImageViewerActivity$5  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass5 implements k.b {
        AnonymousClass5() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = ImageViewerActivity.this.gYp.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (l.kt()) {
                    if (ImageViewerActivity.this.gYL != null && !ImageViewerActivity.this.gYL.isCancelled()) {
                        ImageViewerActivity.this.gYL.cancel();
                    }
                    ImageViewerActivity.this.gYL = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.5.1
                        @Override // com.baidu.tieba.ueg.c.a
                        public void bIW() {
                            ImageViewerActivity.this.openUrl(currentImageQRInfo);
                        }

                        @Override // com.baidu.tieba.ueg.c.a
                        public void bIX() {
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
                            aVar.b(ImageViewerActivity.this.getPageContext()).agI();
                        }

                        @Override // com.baidu.tieba.ueg.c.a
                        public void bIY() {
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
                            aVar.b(ImageViewerActivity.this.getPageContext()).agI();
                        }

                        @Override // com.baidu.tieba.ueg.c.a
                        public void onError(String str) {
                            l.showToast(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.getPageContext().getResources().getString(R.string.qr_scan_error));
                        }
                    });
                    ImageViewerActivity.this.gYL.setPriority(3);
                    ImageViewerActivity.this.gYL.execute(new String[0]);
                    ImageViewerActivity.this.aZI();
                    ImageViewerActivity.this.wj(5);
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
    public void wj(int i) {
        TiebaStatic.log(new an("c13270").bT("uid", this.mUserId).P("obj_type", i));
    }

    private void bgF() {
        if (!this.gYH) {
            if (this.gYF == null) {
                this.gYF = new com.baidu.tieba.c.d(getPageContext(), this.gYo);
                this.gYF.qb(R.drawable.pic_sign_tip);
                this.gYF.qa(48);
                this.gYF.S(true);
                this.gYF.qc(UIMsg.m_AppUI.MSG_APP_GPS);
                this.gYF.qe(-l.g(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.gYF.q(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.bIU();
                    }
                });
            }
            this.gYF.cI(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIU() {
        if (this.gYF != null) {
            this.gYF.bbz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bzN() {
        int Z = v.Z(this.gYr);
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
        this.gYu = new i();
        boolean isLogin = com.baidu.tbadk.n.a.isLogin();
        String bduss = com.baidu.tbadk.n.a.getBduss();
        String tbs = com.baidu.tbadk.n.a.getTbs();
        String stoken = com.baidu.tbadk.n.a.getStoken();
        if (bundle != null) {
            this.gYJ = bundle.getBoolean(ImageViewerConfig.ABTEST);
            this.gYr = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.eFy = bundle.getString("fid");
            this.bWO = bundle.getString("tid");
            this.fEZ = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.cmL = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.gYq = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.gYw = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.cmN = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.cmO = bundle.getBoolean(ImageViewerConfig.IS_HOT_SORT, false);
            this.gYB = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.gYb = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            this.gYd = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            if (serializable instanceof Map) {
                this.cnX = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.cnX.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.gYG = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.gYH = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.gYJ = intent.getBooleanExtra(ImageViewerConfig.ABTEST, false);
                this.gYr = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.eFy = intent.getStringExtra("fid");
                this.bWO = intent.getStringExtra("tid");
                this.fEZ = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.cmL = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.gYq = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.gYw = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.cmN = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.cmO = intent.getBooleanExtra(ImageViewerConfig.IS_HOT_SORT, false);
                this.gYB = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.gYG = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.gYH = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.gYb = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                this.gYd = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.cnX = (Map) serializableExtra;
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
        this.gYu.b(bundle, getIntent());
        this.mCount = v.Z(this.gYr);
        if (this.gYb != null) {
            String str = (String) v.c(this.gYr, this.mIndex);
            if (!StringUtils.isNull(str) && this.cnX != null && (imageUrlData = this.cnX.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.gYb);
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
        bundle.putBoolean(ImageViewerConfig.ABTEST, this.gYJ);
        bundle.putStringArrayList("url", this.gYr);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.eFy);
        bundle.putString("tid", this.bWO);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.fEZ);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.gYq);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.cmN);
        bundle.putBoolean(ImageViewerConfig.IS_HOT_SORT, this.cmO);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.gYB);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.gYw);
        bundle.putString("user_id", this.mUserId);
        if (this.cnX instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.cnX.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.cnX instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.cnX.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.gYb);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.gYG);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.gYH);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.gYd);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.n.a.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.n.a.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.n.a.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.n.a.getTbs());
        this.gYu.Z(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.gYp.setCurrentItem(this.mIndex, false);
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
            if (this.mUrl != null && ImageViewerActivity.this.cnX != null) {
                Iterator it = ImageViewerActivity.this.cnX.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ap.ajj().nW(oj) + "/" + at.oj(imageUrlData.originalUrl);
                    int[] ny = m.ny(str);
                    if (ny != null && ny.length == 2 && ny[0] > 0 && m.e(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
                        return ImageViewerActivity.this.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (m.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                    case -2:
                        return m.aib();
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
            ImageViewerActivity.this.gYs = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.gYs = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zQ(String str) {
        int i;
        boolean z = false;
        if (this.eDm != null && !isFinishing() && this.eDm.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.gYQ = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.eDn);
            this.gYQ.a(this.gYX);
            int i2 = 0;
            while (true) {
                if (i2 < this.eDr.size()) {
                    if (this.gYN == null || this.eDr.get(i2) != this.gYN || (i = i2 + 1) > this.eDr.size()) {
                        i2++;
                    } else {
                        this.eDr.add(i, this.gYQ);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.eDr.add(this.gYQ);
            }
            this.eDn.W(this.eDr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                n nVar = new n();
                nVar.type = 0;
                nVar.jgd = imageBitmap;
                String currentImageUrl = this.gYp.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    nVar.jgc = String.valueOf(System.currentTimeMillis()) + at.oj(currentImageUrl);
                } else {
                    nVar.jgc = String.valueOf(BdUniqueId.gen().getId());
                }
                this.gYK = nVar.jgc;
                sendMessage(new CustomMessage(2921403, nVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wk(int i) {
        if (this.gYp != null) {
            this.gYp.jV(i);
            setViewVisibility(this.gYo, (this.gYp.aqt() || bIR()) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIV() {
        if (bIR()) {
            this.gYz = this.mNavigationBar.getVisibility() == 0;
            this.gYy = true;
        } else if (this.gYy) {
            this.mNavigationBar.setVisibility(this.gYz ? 0 : 8);
            this.gYy = false;
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
            public boolean auT() {
                return false;
            }

            @Override // com.baidu.tbadk.o.b
            public int auU() {
                return com.baidu.tbadk.o.e.auZ().avc();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eFy, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.bWO, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.qU(TbadkCoreApplication.getInst().getAdAdSense().cfM);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.coreExtra.view.a
    public boolean aqk() {
        return this.gYJ;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (aq.isEmpty(this.bWO)) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.c(this.bWO, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }
}
