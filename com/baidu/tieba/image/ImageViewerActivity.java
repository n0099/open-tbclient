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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.q;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
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
    private boolean cAJ;
    private boolean cAL;
    private boolean cAM;
    private Map<String, ImageUrlData> cBU;
    private String cmS;
    private com.baidu.tbadk.core.dialog.i eNJ;
    private k eNK;
    private String ePT;
    private String fGR;
    private com.baidu.tbadk.core.dialog.g fbb;
    private String gYQ;
    private String gYR;
    private com.baidu.tieba.ueg.c gZA;
    private com.baidu.tbadk.core.dialog.g gZB;
    private com.baidu.tbadk.core.dialog.g gZC;
    private com.baidu.tbadk.core.dialog.g gZD;
    private com.baidu.tbadk.core.dialog.g gZE;
    private com.baidu.tbadk.core.dialog.g gZF;
    private float gZN;
    private TextView gZd;
    private MultiImageView gZe;
    private ArrayList<String> gZg;
    private a gZh;
    private e gZi;
    private i gZj;
    private boolean gZp;
    private boolean gZq;
    private int gZr;
    private boolean gZs;
    private float gZt;
    private com.baidu.tieba.c.d gZu;
    private boolean gZv;
    private boolean gZw;
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
    private boolean gZf = true;
    private boolean gZk = false;
    private boolean gZl = true;
    private com.baidu.tieba.image.a gZm = null;
    private boolean gZn = false;
    private boolean gZo = false;
    private boolean isRight = false;
    private int BQ = 0;
    private boolean gZx = false;
    private boolean gYS = false;
    private boolean gZy = false;
    private String gZz = null;
    private List<com.baidu.tbadk.core.dialog.g> eNO = null;
    private final CustomMessageListener gZG = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k) && (kVar = (com.baidu.tbadk.data.k) customResponsedMessage.getData()) != null && !StringUtils.isNull(kVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(kVar);
                if (StringUtils.isNull(kVar.cEe)) {
                    ba.amQ().b(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    ba.amQ().b(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.cEe});
                }
            }
        }
    };
    private DragImageView.d cCs = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gZd, 8);
            if (ImageViewerActivity.this.gZe != null) {
                ImageViewerActivity.this.gZe.eS(false);
            }
            ImageViewerActivity.this.bGF();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new an("c13341").O("obj_param1", ImageViewerActivity.this.gZe.getItemNum()).O(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.gZe.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").bS("obj_type", "2"));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void ayc() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 0);
            if (ImageViewerActivity.this.gZe != null && !ImageViewerActivity.this.gZe.asB()) {
                ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gZd, 0);
                ImageViewerActivity.this.gZe.eS(true);
            }
        }
    };
    private UrlDragImageView.b cAC = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void asT() {
            TiebaStatic.log(new an("c10351").bS("tid", ImageViewerActivity.this.cmS).bS("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final View.OnClickListener gZH = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.showToast(R.string.neterror);
                return;
            }
            TiebaStatic.log(new an("pb_onlyowner_click").O("obj_source", 2).O("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
            TiebaStatic.log(new an("c13338").O("obj_locate", ImageViewerActivity.this.mIsSeeHost ? 1 : 2));
            ImageViewerActivity.this.gZp = true;
            if (ImageViewerActivity.this.gZd != null) {
                ImageViewerActivity.this.gZd.setEnabled(false);
            }
            ImageViewerActivity.this.k(d.yE((String) v.getItem(ImageViewerActivity.this.gZg, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
        }
    };
    private k.b gZI = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.22
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            ImageViewerActivity.this.gZe.jz(ImageViewerActivity.this.bxA());
            ImageViewerActivity.this.bar();
        }
    };
    private k.b gZJ = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.23
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aE(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.gZe.getCurrentImageUrl());
            ImageViewerActivity.this.bar();
            ImageViewerActivity.this.uU(1);
        }
    };
    private k.b gZK = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = ImageViewerActivity.this.gZe.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            ImageViewerActivity.this.bar();
            ImageViewerActivity.this.uU(2);
        }
    };
    private k.b fbc = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
            if (ImageViewerActivity.this.mPermissionJudgement == null) {
                ImageViewerActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
            }
            ImageViewerActivity.this.mPermissionJudgement.clearRequestPermissionList();
            ImageViewerActivity.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!ImageViewerActivity.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                ImageViewerActivity.this.saveImage();
                ImageViewerActivity.this.bar();
                ImageViewerActivity.this.uU(3);
            }
        }
    };
    private k.b gZL = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            UrlDragImageView currentUrlDragImageView;
            if (ImageViewerActivity.this.gZe != null && (currentUrlDragImageView = ImageViewerActivity.this.gZe.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.e.c.getNameMd5FromUrl(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = ImageViewerActivity.this.gZe.getCurrentImageUrl();
                    str2 = as.getNameMd5FromUrl(str);
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
                    eVar.cyH = bundle;
                }
                ImageViewerActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(ImageViewerActivity.this.getActivity(), eVar, false)));
                ImageViewerActivity.this.bar();
                ImageViewerActivity.this.uU(4);
            }
        }
    };
    private k.b gZM = new AnonymousClass5();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (ImageViewerActivity.this.gZy && ImageViewerActivity.this.gZe != null) {
                boolean asB = ImageViewerActivity.this.gZe.asB();
                if (!asB) {
                    com.baidu.tieba.t.a.x(ImageViewerActivity.this.gZd, 100);
                    i = 1;
                } else {
                    com.baidu.tieba.t.a.y(ImageViewerActivity.this.gZd, 100);
                    i = 2;
                }
                ImageViewerActivity.this.gZe.h(asB ? false : true, 100);
                TiebaStatic.log(new an("c13397").O("obj_type", i));
                return;
            }
            TiebaStatic.log(new an("c13341").O("obj_param1", ImageViewerActivity.this.gZe.getItemNum()).O(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.gZe.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").bS("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean gZO = true;
    private View.OnTouchListener cCE = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.gZN = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.gZO = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.gZN = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.gZO = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener gZP = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.beb();
            ImageViewerActivity.this.show();
            ImageViewerActivity.this.cg(view);
            TiebaStatic.log(new an("c13269").bS("uid", ImageViewerActivity.this.mUserId).bS("fid", ImageViewerActivity.this.ePT).bS("tid", ImageViewerActivity.this.cmS));
            return true;
        }
    };
    private BaseViewPager.a gZQ = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.gZi.bGn();
            } else if (ImageViewerActivity.this.bGA() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.gZi.bGo();
            }
        }
    };
    private ViewPager.OnPageChangeListener ctm = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.gZi != null && i > ImageViewerActivity.this.gZe.getItemNum() - 5) {
                ImageViewerActivity.this.gZi.bGn();
            }
            ImageViewerActivity.this.gZj.d(ImageViewerActivity.this.gZg, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.bGB();
            ImageViewerActivity.this.bGG();
            ImageViewerActivity.this.uV(i);
            if (ImageViewerActivity.this.gZj.bGK() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.gZj.uW(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.gZj.bGL() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.gZj.uX(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.bGC()) {
                ImageViewerActivity.this.gZm.bGb();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.gZe.getItemNum() - 1) {
                ImageViewerActivity.this.gZk = false;
            }
            ImageViewerActivity.this.gZz = null;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.BQ) {
                ImageViewerActivity.this.BQ = i;
                ImageViewerActivity.this.isRight = true;
            } else if (i < ImageViewerActivity.this.BQ) {
                ImageViewerActivity.this.BQ = i;
                ImageViewerActivity.this.isRight = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.gZg != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.gZg.size()) {
                ImageViewerActivity.this.gZj.as(i, (String) ImageViewerActivity.this.gZg.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.gZe.getItemNum() - 1) {
                if (!ImageViewerActivity.this.gZO || !ImageViewerActivity.this.gZs || (!ImageViewerActivity.this.gZk && !ImageViewerActivity.this.bGC() && (ImageViewerActivity.this.gZe.getItemNum() != 1 || !ImageViewerActivity.this.isRight))) {
                    ImageViewerActivity.this.gZk = true;
                } else {
                    ImageViewerActivity.this.showToast(R.string.last_page);
                }
            }
        }
    };
    private CustomMessageListener cmy = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.cBU != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.cBU.values()) {
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
    private CustomMessageListener cmz = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.cBU != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.cBU.values()) {
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
    private CustomMessageListener gZR = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && !ImageViewerActivity.this.isFinishing() && (nVar = (n) customResponsedMessage.getData()) != null) {
                nVar.jju = null;
                if (!TextUtils.isEmpty(nVar.jjw) && !TextUtils.isEmpty(nVar.jjt) && nVar.jjt.equals(ImageViewerActivity.this.gZz)) {
                    ImageViewerActivity.this.gZe.setCurrentImageQRInfo(nVar.jjw);
                    ImageViewerActivity.this.yI(nVar.jjw);
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
        com.baidu.tbadk.n.b.avJ().d(TbadkCoreApplication.getInst());
        this.gZr = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        bsR();
        if (com.baidu.tbadk.core.util.g.alX()) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
        this.gYR = d.yE((String) v.getItem(this.gZg, this.mIndex));
        if (d.yF((String) v.getItem(this.gZg, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        k(this.gYR, this.mIsSeeHost, false);
        MessageManager.getInstance().registerListener(this.gZG);
        registerListener(this.cmy);
        registerListener(this.cmz);
        registerListener(this.gZR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.gZi = new e(this.gZg, this.cBU, this.ePT, this.fGR, this.cmS, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.gZi.setSourceImageRectInScreen(this.gYQ);
        this.gZi.mK(this.gZf);
        this.gZi.mL(z);
        this.gZi.yG(this.gYR);
        this.gZi.mJ(this.gYS);
        this.gZi.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.gZe != null) {
                    if (ImageViewerActivity.this.gZp) {
                        if (!z5) {
                            ImageViewerActivity.this.gZe.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.gZp = false;
                    if (ImageViewerActivity.this.gZd != null) {
                        ImageViewerActivity.this.gZd.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.gZe.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.gZe.getItemNum();
                        ImageViewerActivity.this.gZe.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.gZe.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.gZe.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.gZm != null) {
                        ImageViewerActivity.this.gZm.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.gZe.setUrlData(arrayList);
                    ImageViewerActivity.this.gZe.setAssistUrls(ImageViewerActivity.this.cBU);
                    ImageViewerActivity.this.gZe.setHasNext(z3);
                    ImageViewerActivity.this.gZe.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.gZe.getItemNum()) {
                        ImageViewerActivity.this.gZe.jx(ImageViewerActivity.this.gZe.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.gZe.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList.size() >= 400 && ImageViewerActivity.this.gZe.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.gZe.setUrlData(arrayList);
                        ImageViewerActivity.this.gZe.setCurrentItem(ImageViewerActivity.this.gZe.getCurrentItem() - 200, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.bGB();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.gZe.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.gZm.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.gZm.bFX()) {
                    ImageViewerActivity.this.gZe.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.q.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.gZe.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void ar(int i, String str2) {
                ImageViewerActivity.this.gZp = false;
                if (ImageViewerActivity.this.gZd != null) {
                    ImageViewerActivity.this.gZd.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.gZg.size();
                    ImageViewerActivity.this.bGB();
                }
            }
        });
        this.gZi.mM(true);
        this.gZi.bGn();
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
            this.gZh = new a(this.gZe.getCurrentImageUrl(), this.gZe.getCurrentImageData());
            this.gZh.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gZe.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.gZe.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.gZr = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gZe.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.g.b.toLong(this.cmS, 0L);
        if (uniqueId != null && j > 0) {
            q.m(uniqueId.getId(), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gZe.onResume();
        this.mIsLogin = com.baidu.tbadk.n.a.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.g.b.toLong(this.cmS, 0L);
        if (uniqueId != null && j > 0) {
            q.a(com.baidu.tbadk.BdToken.b.bQZ, uniqueId.getId(), j);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.gZe.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gZA != null && !this.gZA.isCancelled()) {
            this.gZA.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.gZG);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.avu().releaseBlockBitmapPool();
        this.gZj.d(this.gZg, this.mIndex, this.mIndex);
        this.gZj.bGM();
        String str = "";
        if (this.gZm != null) {
            str = this.gZm.getAdId();
        }
        this.gZj.e(this.gZe.getPageCount(), str, this.ePT, this.cmS);
        this.gZe.onDestroy();
        if (this.gZh != null) {
            this.gZh.cancel();
            this.gZh = null;
        }
        com.baidu.tbadk.download.d.atV().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.gZr);
        bGF();
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

    private void bsR() {
        this.mStatusBarView = findViewById(R.id.statusbar_view);
        aJx();
        initViewPager();
        bGB();
        bfi();
        bea();
        this.gZj.d(this.gZg, this.mIndex, this.mIndex);
    }

    private void aJx() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.gZd = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(R.id.see_host_image_txt);
        if (this.gZw) {
            setViewVisibility(this.gZd, 8);
        }
        if (this.gZq) {
            if (this.mIsSeeHost) {
                this.gZd.setText(R.string.album_all_thread);
            } else {
                this.gZd.setText(R.string.view_host);
            }
            this.gZd.setOnClickListener(this.gZH);
        } else {
            setViewVisibility(this.gZd, 8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long bGA() {
        ImageUrlData imageUrlData;
        String str = (String) v.getItem(this.gZg, this.mIndex);
        if (this.cBU == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.cBU.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGB() {
        String str;
        if (this.gZg != null) {
            String str2 = ("" + bGA()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.gZx && bGA() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new an("c13316").bS("obj_source", this.mFrom));
                this.gZx = true;
            }
            if (bGC()) {
                bGD();
            } else {
                yH(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bGC() {
        if (this.gZl && this.gZm != null && this.gZm.bFX()) {
            return this.gZe.getItemNum() != 1 && this.mIndex == this.gZe.getItemNum() + (-1);
        }
        return false;
    }

    private void yH(String str) {
        this.mTitleView.setText(str);
        if (this.gZq && !this.gZw) {
            if (this.mIsSeeHost) {
                this.gZd.setText(R.string.album_all_thread);
            } else {
                this.gZd.setText(R.string.view_host);
            }
        }
    }

    private void bGD() {
        this.mTitleView.setText("");
        setViewVisibility(this.gZd, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.gZe == null) {
            this.gZe = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.gZe.init();
        }
        this.gZe.setIsFromCDN(this.cAJ);
        this.gZe.setIsCanDrag(this.cAL);
        this.gZe.setIsHotSort(this.cAM);
        this.gZe.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.gZe.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.gZe.setOnPageChangeListener(this.ctm);
        this.gZe.setUrlData(this.gZg);
        this.gZe.setAssistUrls(this.cBU);
        this.gZe.setOuterOnTouchListener(this.cCE);
        this.gZe.setItemOnclickListener(this.mOnClickListener);
        this.gZe.setItemOnLongClickListener(this.gZP);
        this.gZe.setCurrentItem(bxA(), false);
        this.gZe.setOnScrollOutListener(this.gZQ);
        this.gZm = new com.baidu.tieba.image.a(this.cAJ, this.gZl, getPageContext(), this.ePT, this.cmS);
        this.gZm.setDragToExitListener(this.cCs);
        this.gZe.a(this.gZm);
        this.gZe.setOriImgSelectedCallback(this.cAC);
        this.gZe.setDragToExitListener(this.cCs);
        this.gZe.setUserId(this.mUserId);
        this.gZe.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.gZs = ImageViewerActivity.this.gZt - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.gZt = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        TiebaStatic.log(new an("c13340").bS("uid", this.mUserId).bS("post_id", this.cmS).O("obj_source", bGE()));
    }

    private int bGE() {
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

    private void bea() {
        if (this.eNJ == null) {
            this.eNK = new k(this);
        }
        if (this.eNO == null) {
            this.eNO = new ArrayList();
        }
        beb();
        this.eNJ = new com.baidu.tbadk.core.dialog.i(getPageContext(), this.eNK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beb() {
        this.eNO.clear();
        String jy = this.gZe.jy(bxA());
        if (jy != null) {
            this.gZB = new com.baidu.tbadk.core.dialog.g(jy, this.eNK);
            this.gZB.a(this.gZI);
            this.eNO.add(this.gZB);
        }
        this.fbb = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.eNK);
        this.fbb.a(this.fbc);
        this.eNO.add(this.fbb);
        this.gZD = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.eNK);
        this.gZD.a(this.gZK);
        this.eNO.add(this.gZD);
        this.gZC = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.eNK);
        this.gZC.a(this.gZJ);
        this.eNO.add(this.gZC);
        String currentImageQRInfo = this.gZe.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.gZF = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.eNK);
            this.gZF.a(this.gZM);
            this.eNO.add(this.gZF);
        }
        this.gZE = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.eNK);
        this.gZE.a(this.gZL);
        this.eNO.add(this.gZE);
        this.eNK.a(new k.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                ImageViewerActivity.this.bar();
            }
        });
        this.eNK.at(this.eNO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bar() {
        if (this.eNJ != null && this.eNJ.isShowing()) {
            this.eNJ.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show() {
        if (this.eNJ != null && !isFinishing()) {
            this.eNJ.showDialog();
        }
    }

    /* renamed from: com.baidu.tieba.image.ImageViewerActivity$5  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass5 implements k.b {
        AnonymousClass5() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = ImageViewerActivity.this.gZe.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (l.isNetOk()) {
                    if (ImageViewerActivity.this.gZA != null && !ImageViewerActivity.this.gZA.isCancelled()) {
                        ImageViewerActivity.this.gZA.cancel();
                    }
                    ImageViewerActivity.this.gZA = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.5.1
                        @Override // com.baidu.tieba.ueg.c.a
                        public void bGH() {
                            ImageViewerActivity.this.openUrl(currentImageQRInfo);
                        }

                        @Override // com.baidu.tieba.ueg.c.a
                        public void bGI() {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ImageViewerActivity.this.getPageContext().getPageActivity());
                            aVar.setTitleShowCenter(true);
                            aVar.nm(ImageViewerActivity.this.getString(R.string.qr_url_jump_external_title));
                            aVar.setMessageShowCenter(true);
                            aVar.nn(ImageViewerActivity.this.getString(R.string.qr_url_jump_external_message));
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
                            aVar.eg(false);
                            aVar.eh(false);
                            aVar.b(ImageViewerActivity.this.getPageContext()).akO();
                        }

                        @Override // com.baidu.tieba.ueg.c.a
                        public void bGJ() {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ImageViewerActivity.this.getPageContext().getPageActivity());
                            aVar.nm(null);
                            aVar.setMessageShowCenter(true);
                            aVar.nn(ImageViewerActivity.this.getString(R.string.qr_url_risk_forbid));
                            aVar.a(ImageViewerActivity.this.getPageContext().getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.5.1.3
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                    aVar2.dismiss();
                                }
                            });
                            aVar.eg(false);
                            aVar.eh(false);
                            aVar.b(ImageViewerActivity.this.getPageContext()).akO();
                        }

                        @Override // com.baidu.tieba.ueg.c.a
                        public void onError(String str) {
                            l.showToast(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.getPageContext().getResources().getString(R.string.qr_scan_error));
                        }
                    });
                    ImageViewerActivity.this.gZA.setPriority(3);
                    ImageViewerActivity.this.gZA.execute(new String[0]);
                    ImageViewerActivity.this.bar();
                    ImageViewerActivity.this.uU(5);
                    return;
                }
                l.showToast(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.getPageContext().getResources().getString(R.string.network_not_available));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uU(int i) {
        TiebaStatic.log(new an("c13270").bS("uid", this.mUserId).O("obj_type", i));
    }

    private void bfi() {
        if (!this.gZw) {
            if (this.gZu == null) {
                this.gZu = new com.baidu.tieba.c.d(getPageContext(), this.gZd);
                this.gZu.bB(R.drawable.pic_sign_tip);
                this.gZu.bA(48);
                this.gZu.setUseDirectOffset(true);
                this.gZu.bC(5000);
                this.gZu.ph(-l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.gZu.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.bGF();
                    }
                });
            }
            this.gZu.R(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGF() {
        if (this.gZu != null) {
            this.gZu.uP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bxA() {
        int count = v.getCount(this.gZg);
        if (count > 0) {
            if (this.mIndex >= count) {
                this.mIndex = count - 1;
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
        this.gZj = new i();
        boolean isLogin = com.baidu.tbadk.n.a.isLogin();
        String bduss = com.baidu.tbadk.n.a.getBduss();
        String tbs = com.baidu.tbadk.n.a.getTbs();
        String stoken = com.baidu.tbadk.n.a.getStoken();
        if (bundle != null) {
            this.gZy = bundle.getBoolean("abtest");
            this.gZg = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.ePT = bundle.getString("fid");
            this.cmS = bundle.getString("tid");
            this.fGR = bundle.getString("fname");
            this.cAJ = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.gZf = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.gZl = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.cAL = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.cAM = bundle.getBoolean(ImageViewerConfig.IS_HOT_SORT, false);
            this.gZq = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.gYQ = bundle.getString("source_rect_in_screen");
            this.gYS = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            if (serializable instanceof Map) {
                this.cBU = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.cBU.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.gZv = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.gZw = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.gZy = intent.getBooleanExtra("abtest", false);
                this.gZg = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.ePT = intent.getStringExtra("fid");
                this.cmS = intent.getStringExtra("tid");
                this.fGR = intent.getStringExtra("fname");
                this.cAJ = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.gZf = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.gZl = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.cAL = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.cAM = intent.getBooleanExtra(ImageViewerConfig.IS_HOT_SORT, false);
                this.gZq = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.gZv = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.gZw = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.gYQ = intent.getStringExtra("source_rect_in_screen");
                this.gYS = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.cBU = (Map) serializableExtra;
                }
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.n.a.fp(isLogin);
        com.baidu.tbadk.n.a.dj(bduss);
        com.baidu.tbadk.n.a.setStoken(stoken);
        com.baidu.tbadk.n.a.setTbs(tbs);
        this.gZj.b(bundle, getIntent());
        this.mCount = v.getCount(this.gZg);
        if (this.gYQ != null) {
            String str = (String) v.getItem(this.gZg, this.mIndex);
            if (!StringUtils.isNull(str) && this.cBU != null && (imageUrlData = this.cBU.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.gYQ);
            }
        }
        if (this.mIsSeeHost) {
            TiebaStatic.log(new an("c13337").bS("obj_type", "2"));
        } else {
            TiebaStatic.log(new an("c13337").bS("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("abtest", this.gZy);
        bundle.putStringArrayList("url", this.gZg);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.ePT);
        bundle.putString("tid", this.cmS);
        bundle.putString("fname", this.fGR);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.gZf);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.cAL);
        bundle.putBoolean(ImageViewerConfig.IS_HOT_SORT, this.cAM);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.gZq);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.gZl);
        bundle.putString("user_id", this.mUserId);
        if (this.cBU instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.cBU.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.cBU instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.cBU.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.gYQ);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.gZv);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.gZw);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.gYS);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.n.a.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.n.a.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.n.a.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.n.a.getTbs());
        this.gZj.Y(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.gZe.setCurrentItem(this.mIndex, false);
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
            String nameMd5FromUrl;
            if (this.mUrl != null && ImageViewerActivity.this.cBU != null) {
                Iterator it = ImageViewerActivity.this.cBU.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ap.amL().nQ(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = m.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && m.copyImageFile(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
                        return ImageViewerActivity.this.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (m.saveImageFileByUser(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                    case -2:
                        return m.getSdErrorString();
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
            ImageViewerActivity.this.gZh = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.gZh = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yI(String str) {
        int i;
        boolean z = false;
        if (this.eNJ != null && !isFinishing() && this.eNJ.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.gZF = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.eNK);
            this.gZF.a(this.gZM);
            int i2 = 0;
            while (true) {
                if (i2 < this.eNO.size()) {
                    if (this.gZC == null || this.eNO.get(i2) != this.gZC || (i = i2 + 1) > this.eNO.size()) {
                        i2++;
                    } else {
                        this.eNO.add(i, this.gZF);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.eNO.add(this.gZF);
            }
            this.eNK.at(this.eNO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                n nVar = new n();
                nVar.type = 0;
                nVar.jju = imageBitmap;
                String currentImageUrl = this.gZe.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    nVar.jjt = String.valueOf(System.currentTimeMillis()) + as.getNameMd5FromUrl(currentImageUrl);
                } else {
                    nVar.jjt = String.valueOf(BdUniqueId.gen().getId());
                }
                this.gZz = nVar.jjt;
                sendMessage(new CustomMessage(2921403, nVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uV(int i) {
        if (this.gZe != null) {
            this.gZe.jw(i);
            setViewVisibility(this.gZd, (this.gZe.asB() || bGC()) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGG() {
        if (bGC()) {
            this.gZo = this.mNavigationBar.getVisibility() == 0;
            this.gZn = true;
        } else if (this.gZn) {
            this.mNavigationBar.setVisibility(this.gZo ? 0 : 8);
            this.gZn = false;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.BIGIMAGE;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public com.baidu.tbadk.o.b getPageStayFilter() {
        return new com.baidu.tbadk.o.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
            @Override // com.baidu.tbadk.o.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.o.b
            public int getMaxCost() {
                return com.baidu.tbadk.o.e.awz().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.toLong(this.ePT, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.toLong(this.cmS, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.qd(TbadkCoreApplication.getInst().getAdAdSense().cuL);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.coreExtra.view.a
    public boolean ass() {
        return this.gZy;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (aq.isEmpty(this.cmS)) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.toLong(this.cmS, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }
}
