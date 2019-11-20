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
    private Map<String, ImageUrlData> cBd;
    private String cma;
    private boolean czS;
    private boolean czU;
    private boolean czV;
    private com.baidu.tbadk.core.dialog.i eMS;
    private k eMT;
    private String ePc;
    private String fGa;
    private com.baidu.tbadk.core.dialog.g fak;
    private String gXZ;
    private int gYA;
    private boolean gYB;
    private float gYC;
    private com.baidu.tieba.c.d gYD;
    private boolean gYE;
    private boolean gYF;
    private com.baidu.tieba.ueg.c gYJ;
    private com.baidu.tbadk.core.dialog.g gYK;
    private com.baidu.tbadk.core.dialog.g gYL;
    private com.baidu.tbadk.core.dialog.g gYM;
    private com.baidu.tbadk.core.dialog.g gYN;
    private com.baidu.tbadk.core.dialog.g gYO;
    private float gYW;
    private String gYa;
    private TextView gYm;
    private MultiImageView gYn;
    private ArrayList<String> gYp;
    private a gYq;
    private e gYr;
    private i gYs;
    private boolean gYy;
    private boolean gYz;
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
    private boolean gYo = true;
    private boolean gYt = false;
    private boolean gYu = true;
    private com.baidu.tieba.image.a gYv = null;
    private boolean gYw = false;
    private boolean gYx = false;
    private boolean isRight = false;
    private int Bq = 0;
    private boolean gYG = false;
    private boolean gYb = false;
    private boolean gYH = false;
    private String gYI = null;
    private List<com.baidu.tbadk.core.dialog.g> eMX = null;
    private final CustomMessageListener gYP = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k) && (kVar = (com.baidu.tbadk.data.k) customResponsedMessage.getData()) != null && !StringUtils.isNull(kVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(kVar);
                if (StringUtils.isNull(kVar.cDn)) {
                    ba.amO().b(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    ba.amO().b(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.cDn});
                }
            }
        }
    };
    private DragImageView.d cBB = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gYm, 8);
            if (ImageViewerActivity.this.gYn != null) {
                ImageViewerActivity.this.gYn.eS(false);
            }
            ImageViewerActivity.this.bGD();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new an("c13341").O("obj_param1", ImageViewerActivity.this.gYn.getItemNum()).O(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.gYn.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").bS("obj_type", "2"));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void aya() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 0);
            if (ImageViewerActivity.this.gYn != null && !ImageViewerActivity.this.gYn.asz()) {
                ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gYm, 0);
                ImageViewerActivity.this.gYn.eS(true);
            }
        }
    };
    private UrlDragImageView.b czL = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void asR() {
            TiebaStatic.log(new an("c10351").bS("tid", ImageViewerActivity.this.cma).bS("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final View.OnClickListener gYQ = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.showToast(R.string.neterror);
                return;
            }
            TiebaStatic.log(new an("pb_onlyowner_click").O("obj_source", 2).O("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
            TiebaStatic.log(new an("c13338").O("obj_locate", ImageViewerActivity.this.mIsSeeHost ? 1 : 2));
            ImageViewerActivity.this.gYy = true;
            if (ImageViewerActivity.this.gYm != null) {
                ImageViewerActivity.this.gYm.setEnabled(false);
            }
            ImageViewerActivity.this.k(d.yE((String) v.getItem(ImageViewerActivity.this.gYp, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
        }
    };
    private k.b gYR = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.22
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            ImageViewerActivity.this.gYn.jy(ImageViewerActivity.this.bxy());
            ImageViewerActivity.this.bap();
        }
    };
    private k.b gYS = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.23
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aE(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.gYn.getCurrentImageUrl());
            ImageViewerActivity.this.bap();
            ImageViewerActivity.this.uT(1);
        }
    };
    private k.b gYT = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = ImageViewerActivity.this.gYn.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            ImageViewerActivity.this.bap();
            ImageViewerActivity.this.uT(2);
        }
    };
    private k.b fal = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
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
                ImageViewerActivity.this.bap();
                ImageViewerActivity.this.uT(3);
            }
        }
    };
    private k.b gYU = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            UrlDragImageView currentUrlDragImageView;
            if (ImageViewerActivity.this.gYn != null && (currentUrlDragImageView = ImageViewerActivity.this.gYn.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.e.c.getNameMd5FromUrl(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = ImageViewerActivity.this.gYn.getCurrentImageUrl();
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
                    eVar.cxQ = bundle;
                }
                ImageViewerActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(ImageViewerActivity.this.getActivity(), eVar, false)));
                ImageViewerActivity.this.bap();
                ImageViewerActivity.this.uT(4);
            }
        }
    };
    private k.b gYV = new AnonymousClass5();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (ImageViewerActivity.this.gYH && ImageViewerActivity.this.gYn != null) {
                boolean asz = ImageViewerActivity.this.gYn.asz();
                if (!asz) {
                    com.baidu.tieba.t.a.x(ImageViewerActivity.this.gYm, 100);
                    i = 1;
                } else {
                    com.baidu.tieba.t.a.y(ImageViewerActivity.this.gYm, 100);
                    i = 2;
                }
                ImageViewerActivity.this.gYn.h(asz ? false : true, 100);
                TiebaStatic.log(new an("c13397").O("obj_type", i));
                return;
            }
            TiebaStatic.log(new an("c13341").O("obj_param1", ImageViewerActivity.this.gYn.getItemNum()).O(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.gYn.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").bS("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean gYX = true;
    private View.OnTouchListener cBN = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.gYW = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.gYX = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.gYW = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.gYX = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener gYY = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.bdZ();
            ImageViewerActivity.this.show();
            ImageViewerActivity.this.cg(view);
            TiebaStatic.log(new an("c13269").bS("uid", ImageViewerActivity.this.mUserId).bS("fid", ImageViewerActivity.this.ePc).bS("tid", ImageViewerActivity.this.cma));
            return true;
        }
    };
    private BaseViewPager.a gYZ = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.gYr.bGl();
            } else if (ImageViewerActivity.this.bGy() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.gYr.bGm();
            }
        }
    };
    private ViewPager.OnPageChangeListener csv = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.gYr != null && i > ImageViewerActivity.this.gYn.getItemNum() - 5) {
                ImageViewerActivity.this.gYr.bGl();
            }
            ImageViewerActivity.this.gYs.d(ImageViewerActivity.this.gYp, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.bGz();
            ImageViewerActivity.this.bGE();
            ImageViewerActivity.this.uU(i);
            if (ImageViewerActivity.this.gYs.bGI() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.gYs.uV(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.gYs.bGJ() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.gYs.uW(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.bGA()) {
                ImageViewerActivity.this.gYv.bFZ();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.gYn.getItemNum() - 1) {
                ImageViewerActivity.this.gYt = false;
            }
            ImageViewerActivity.this.gYI = null;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.Bq) {
                ImageViewerActivity.this.Bq = i;
                ImageViewerActivity.this.isRight = true;
            } else if (i < ImageViewerActivity.this.Bq) {
                ImageViewerActivity.this.Bq = i;
                ImageViewerActivity.this.isRight = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.gYp != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.gYp.size()) {
                ImageViewerActivity.this.gYs.ar(i, (String) ImageViewerActivity.this.gYp.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.gYn.getItemNum() - 1) {
                if (!ImageViewerActivity.this.gYX || !ImageViewerActivity.this.gYB || (!ImageViewerActivity.this.gYt && !ImageViewerActivity.this.bGA() && (ImageViewerActivity.this.gYn.getItemNum() != 1 || !ImageViewerActivity.this.isRight))) {
                    ImageViewerActivity.this.gYt = true;
                } else {
                    ImageViewerActivity.this.showToast(R.string.last_page);
                }
            }
        }
    };
    private CustomMessageListener clG = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.cBd != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.cBd.values()) {
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
    private CustomMessageListener clH = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.cBd != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.cBd.values()) {
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
    private CustomMessageListener gZa = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && !ImageViewerActivity.this.isFinishing() && (nVar = (n) customResponsedMessage.getData()) != null) {
                nVar.jiD = null;
                if (!TextUtils.isEmpty(nVar.jiF) && !TextUtils.isEmpty(nVar.jiC) && nVar.jiC.equals(ImageViewerActivity.this.gYI)) {
                    ImageViewerActivity.this.gYn.setCurrentImageQRInfo(nVar.jiF);
                    ImageViewerActivity.this.yI(nVar.jiF);
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
        com.baidu.tbadk.n.b.avH().d(TbadkCoreApplication.getInst());
        this.gYA = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        bsP();
        if (com.baidu.tbadk.core.util.g.alV()) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
        this.gYa = d.yE((String) v.getItem(this.gYp, this.mIndex));
        if (d.yF((String) v.getItem(this.gYp, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        k(this.gYa, this.mIsSeeHost, false);
        MessageManager.getInstance().registerListener(this.gYP);
        registerListener(this.clG);
        registerListener(this.clH);
        registerListener(this.gZa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.gYr = new e(this.gYp, this.cBd, this.ePc, this.fGa, this.cma, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.gYr.setSourceImageRectInScreen(this.gXZ);
        this.gYr.mK(this.gYo);
        this.gYr.mL(z);
        this.gYr.yG(this.gYa);
        this.gYr.mJ(this.gYb);
        this.gYr.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.gYn != null) {
                    if (ImageViewerActivity.this.gYy) {
                        if (!z5) {
                            ImageViewerActivity.this.gYn.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.gYy = false;
                    if (ImageViewerActivity.this.gYm != null) {
                        ImageViewerActivity.this.gYm.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.gYn.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.gYn.getItemNum();
                        ImageViewerActivity.this.gYn.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.gYn.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.gYn.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.gYv != null) {
                        ImageViewerActivity.this.gYv.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.gYn.setUrlData(arrayList);
                    ImageViewerActivity.this.gYn.setAssistUrls(ImageViewerActivity.this.cBd);
                    ImageViewerActivity.this.gYn.setHasNext(z3);
                    ImageViewerActivity.this.gYn.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.gYn.getItemNum()) {
                        ImageViewerActivity.this.gYn.jw(ImageViewerActivity.this.gYn.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.gYn.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList.size() >= 400 && ImageViewerActivity.this.gYn.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.gYn.setUrlData(arrayList);
                        ImageViewerActivity.this.gYn.setCurrentItem(ImageViewerActivity.this.gYn.getCurrentItem() - 200, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.bGz();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.gYn.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.gYv.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.gYv.bFV()) {
                    ImageViewerActivity.this.gYn.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.q.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.gYn.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void aq(int i, String str2) {
                ImageViewerActivity.this.gYy = false;
                if (ImageViewerActivity.this.gYm != null) {
                    ImageViewerActivity.this.gYm.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.gYp.size();
                    ImageViewerActivity.this.bGz();
                }
            }
        });
        this.gYr.mM(true);
        this.gYr.bGl();
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
            this.gYq = new a(this.gYn.getCurrentImageUrl(), this.gYn.getCurrentImageData());
            this.gYq.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gYn.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.gYn.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.gYA = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gYn.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.g.b.toLong(this.cma, 0L);
        if (uniqueId != null && j > 0) {
            q.k(uniqueId.getId(), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gYn.onResume();
        this.mIsLogin = com.baidu.tbadk.n.a.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.g.b.toLong(this.cma, 0L);
        if (uniqueId != null && j > 0) {
            q.a(com.baidu.tbadk.BdToken.b.bQi, uniqueId.getId(), j);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.gYn.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gYJ != null && !this.gYJ.isCancelled()) {
            this.gYJ.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.gYP);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.avs().releaseBlockBitmapPool();
        this.gYs.d(this.gYp, this.mIndex, this.mIndex);
        this.gYs.bGK();
        String str = "";
        if (this.gYv != null) {
            str = this.gYv.getAdId();
        }
        this.gYs.e(this.gYn.getPageCount(), str, this.ePc, this.cma);
        this.gYn.onDestroy();
        if (this.gYq != null) {
            this.gYq.cancel();
            this.gYq = null;
        }
        com.baidu.tbadk.download.d.atT().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.gYA);
        bGD();
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

    private void bsP() {
        this.mStatusBarView = findViewById(R.id.statusbar_view);
        aJv();
        initViewPager();
        bGz();
        bfg();
        bdY();
        this.gYs.d(this.gYp, this.mIndex, this.mIndex);
    }

    private void aJv() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.gYm = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(R.id.see_host_image_txt);
        if (this.gYF) {
            setViewVisibility(this.gYm, 8);
        }
        if (this.gYz) {
            if (this.mIsSeeHost) {
                this.gYm.setText(R.string.album_all_thread);
            } else {
                this.gYm.setText(R.string.view_host);
            }
            this.gYm.setOnClickListener(this.gYQ);
        } else {
            setViewVisibility(this.gYm, 8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long bGy() {
        ImageUrlData imageUrlData;
        String str = (String) v.getItem(this.gYp, this.mIndex);
        if (this.cBd == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.cBd.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGz() {
        String str;
        if (this.gYp != null) {
            String str2 = ("" + bGy()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.gYG && bGy() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new an("c13316").bS("obj_source", this.mFrom));
                this.gYG = true;
            }
            if (bGA()) {
                bGB();
            } else {
                yH(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bGA() {
        if (this.gYu && this.gYv != null && this.gYv.bFV()) {
            return this.gYn.getItemNum() != 1 && this.mIndex == this.gYn.getItemNum() + (-1);
        }
        return false;
    }

    private void yH(String str) {
        this.mTitleView.setText(str);
        if (this.gYz && !this.gYF) {
            if (this.mIsSeeHost) {
                this.gYm.setText(R.string.album_all_thread);
            } else {
                this.gYm.setText(R.string.view_host);
            }
        }
    }

    private void bGB() {
        this.mTitleView.setText("");
        setViewVisibility(this.gYm, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.gYn == null) {
            this.gYn = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.gYn.init();
        }
        this.gYn.setIsFromCDN(this.czS);
        this.gYn.setIsCanDrag(this.czU);
        this.gYn.setIsHotSort(this.czV);
        this.gYn.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.gYn.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.gYn.setOnPageChangeListener(this.csv);
        this.gYn.setUrlData(this.gYp);
        this.gYn.setAssistUrls(this.cBd);
        this.gYn.setOuterOnTouchListener(this.cBN);
        this.gYn.setItemOnclickListener(this.mOnClickListener);
        this.gYn.setItemOnLongClickListener(this.gYY);
        this.gYn.setCurrentItem(bxy(), false);
        this.gYn.setOnScrollOutListener(this.gYZ);
        this.gYv = new com.baidu.tieba.image.a(this.czS, this.gYu, getPageContext(), this.ePc, this.cma);
        this.gYv.setDragToExitListener(this.cBB);
        this.gYn.a(this.gYv);
        this.gYn.setOriImgSelectedCallback(this.czL);
        this.gYn.setDragToExitListener(this.cBB);
        this.gYn.setUserId(this.mUserId);
        this.gYn.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.gYB = ImageViewerActivity.this.gYC - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.gYC = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        TiebaStatic.log(new an("c13340").bS("uid", this.mUserId).bS("post_id", this.cma).O("obj_source", bGC()));
    }

    private int bGC() {
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

    private void bdY() {
        if (this.eMS == null) {
            this.eMT = new k(this);
        }
        if (this.eMX == null) {
            this.eMX = new ArrayList();
        }
        bdZ();
        this.eMS = new com.baidu.tbadk.core.dialog.i(getPageContext(), this.eMT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdZ() {
        this.eMX.clear();
        String jx = this.gYn.jx(bxy());
        if (jx != null) {
            this.gYK = new com.baidu.tbadk.core.dialog.g(jx, this.eMT);
            this.gYK.a(this.gYR);
            this.eMX.add(this.gYK);
        }
        this.fak = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.eMT);
        this.fak.a(this.fal);
        this.eMX.add(this.fak);
        this.gYM = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.eMT);
        this.gYM.a(this.gYT);
        this.eMX.add(this.gYM);
        this.gYL = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.eMT);
        this.gYL.a(this.gYS);
        this.eMX.add(this.gYL);
        String currentImageQRInfo = this.gYn.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.gYO = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.eMT);
            this.gYO.a(this.gYV);
            this.eMX.add(this.gYO);
        }
        this.gYN = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.eMT);
        this.gYN.a(this.gYU);
        this.eMX.add(this.gYN);
        this.eMT.a(new k.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                ImageViewerActivity.this.bap();
            }
        });
        this.eMT.at(this.eMX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bap() {
        if (this.eMS != null && this.eMS.isShowing()) {
            this.eMS.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show() {
        if (this.eMS != null && !isFinishing()) {
            this.eMS.showDialog();
        }
    }

    /* renamed from: com.baidu.tieba.image.ImageViewerActivity$5  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass5 implements k.b {
        AnonymousClass5() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = ImageViewerActivity.this.gYn.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (l.isNetOk()) {
                    if (ImageViewerActivity.this.gYJ != null && !ImageViewerActivity.this.gYJ.isCancelled()) {
                        ImageViewerActivity.this.gYJ.cancel();
                    }
                    ImageViewerActivity.this.gYJ = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.5.1
                        @Override // com.baidu.tieba.ueg.c.a
                        public void bGF() {
                            ImageViewerActivity.this.openUrl(currentImageQRInfo);
                        }

                        @Override // com.baidu.tieba.ueg.c.a
                        public void bGG() {
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
                            aVar.b(ImageViewerActivity.this.getPageContext()).akM();
                        }

                        @Override // com.baidu.tieba.ueg.c.a
                        public void bGH() {
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
                            aVar.b(ImageViewerActivity.this.getPageContext()).akM();
                        }

                        @Override // com.baidu.tieba.ueg.c.a
                        public void onError(String str) {
                            l.showToast(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.getPageContext().getResources().getString(R.string.qr_scan_error));
                        }
                    });
                    ImageViewerActivity.this.gYJ.setPriority(3);
                    ImageViewerActivity.this.gYJ.execute(new String[0]);
                    ImageViewerActivity.this.bap();
                    ImageViewerActivity.this.uT(5);
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
    public void uT(int i) {
        TiebaStatic.log(new an("c13270").bS("uid", this.mUserId).O("obj_type", i));
    }

    private void bfg() {
        if (!this.gYF) {
            if (this.gYD == null) {
                this.gYD = new com.baidu.tieba.c.d(getPageContext(), this.gYm);
                this.gYD.bB(R.drawable.pic_sign_tip);
                this.gYD.bA(48);
                this.gYD.setUseDirectOffset(true);
                this.gYD.bC(5000);
                this.gYD.pg(-l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.gYD.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.bGD();
                    }
                });
            }
            this.gYD.R(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGD() {
        if (this.gYD != null) {
            this.gYD.uQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bxy() {
        int count = v.getCount(this.gYp);
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
        this.gYs = new i();
        boolean isLogin = com.baidu.tbadk.n.a.isLogin();
        String bduss = com.baidu.tbadk.n.a.getBduss();
        String tbs = com.baidu.tbadk.n.a.getTbs();
        String stoken = com.baidu.tbadk.n.a.getStoken();
        if (bundle != null) {
            this.gYH = bundle.getBoolean("abtest");
            this.gYp = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.ePc = bundle.getString("fid");
            this.cma = bundle.getString("tid");
            this.fGa = bundle.getString("fname");
            this.czS = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.gYo = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.gYu = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.czU = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.czV = bundle.getBoolean(ImageViewerConfig.IS_HOT_SORT, false);
            this.gYz = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.gXZ = bundle.getString("source_rect_in_screen");
            this.gYb = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            if (serializable instanceof Map) {
                this.cBd = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.cBd.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.gYE = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.gYF = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.gYH = intent.getBooleanExtra("abtest", false);
                this.gYp = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.ePc = intent.getStringExtra("fid");
                this.cma = intent.getStringExtra("tid");
                this.fGa = intent.getStringExtra("fname");
                this.czS = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.gYo = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.gYu = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.czU = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.czV = intent.getBooleanExtra(ImageViewerConfig.IS_HOT_SORT, false);
                this.gYz = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.gYE = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.gYF = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.gXZ = intent.getStringExtra("source_rect_in_screen");
                this.gYb = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.cBd = (Map) serializableExtra;
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
        this.gYs.b(bundle, getIntent());
        this.mCount = v.getCount(this.gYp);
        if (this.gXZ != null) {
            String str = (String) v.getItem(this.gYp, this.mIndex);
            if (!StringUtils.isNull(str) && this.cBd != null && (imageUrlData = this.cBd.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.gXZ);
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
        bundle.putBoolean("abtest", this.gYH);
        bundle.putStringArrayList("url", this.gYp);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.ePc);
        bundle.putString("tid", this.cma);
        bundle.putString("fname", this.fGa);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.gYo);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.czU);
        bundle.putBoolean(ImageViewerConfig.IS_HOT_SORT, this.czV);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.gYz);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.gYu);
        bundle.putString("user_id", this.mUserId);
        if (this.cBd instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.cBd.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.cBd instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.cBd.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.gXZ);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.gYE);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.gYF);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.gYb);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.n.a.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.n.a.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.n.a.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.n.a.getTbs());
        this.gYs.Y(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.gYn.setCurrentItem(this.mIndex, false);
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
            if (this.mUrl != null && ImageViewerActivity.this.cBd != null) {
                Iterator it = ImageViewerActivity.this.cBd.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ap.amJ().nQ(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(imageUrlData.originalUrl);
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
            ImageViewerActivity.this.gYq = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.gYq = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yI(String str) {
        int i;
        boolean z = false;
        if (this.eMS != null && !isFinishing() && this.eMS.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.gYO = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.eMT);
            this.gYO.a(this.gYV);
            int i2 = 0;
            while (true) {
                if (i2 < this.eMX.size()) {
                    if (this.gYL == null || this.eMX.get(i2) != this.gYL || (i = i2 + 1) > this.eMX.size()) {
                        i2++;
                    } else {
                        this.eMX.add(i, this.gYO);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.eMX.add(this.gYO);
            }
            this.eMT.at(this.eMX);
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
                nVar.jiD = imageBitmap;
                String currentImageUrl = this.gYn.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    nVar.jiC = String.valueOf(System.currentTimeMillis()) + as.getNameMd5FromUrl(currentImageUrl);
                } else {
                    nVar.jiC = String.valueOf(BdUniqueId.gen().getId());
                }
                this.gYI = nVar.jiC;
                sendMessage(new CustomMessage(2921403, nVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uU(int i) {
        if (this.gYn != null) {
            this.gYn.jv(i);
            setViewVisibility(this.gYm, (this.gYn.asz() || bGA()) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGE() {
        if (bGA()) {
            this.gYx = this.mNavigationBar.getVisibility() == 0;
            this.gYw = true;
        } else if (this.gYw) {
            this.mNavigationBar.setVisibility(this.gYx ? 0 : 8);
            this.gYw = false;
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
                return com.baidu.tbadk.o.e.awx().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.toLong(this.ePc, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.toLong(this.cma, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.qd(TbadkCoreApplication.getInst().getAdAdSense().ctT);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.coreExtra.view.a
    public boolean asq() {
        return this.gYH;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (aq.isEmpty(this.cma)) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.toLong(this.cma, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }
}
