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
    private String bVL;
    private boolean clA;
    private boolean clx;
    private boolean clz;
    private Map<String, ImageUrlData> cmJ;
    private String eAC;
    private com.baidu.tbadk.core.dialog.g eRA;
    private com.baidu.tbadk.core.dialog.i eyp;
    private k eyq;
    private String fAb;
    private String gRP;
    private String gRQ;
    private com.baidu.tbadk.core.dialog.g gSA;
    private com.baidu.tbadk.core.dialog.g gSB;
    private com.baidu.tbadk.core.dialog.g gSC;
    private com.baidu.tbadk.core.dialog.g gSD;
    private com.baidu.tbadk.core.dialog.g gSE;
    private float gSM;
    private TextView gSc;
    private MultiImageView gSd;
    private ArrayList<String> gSf;
    private a gSg;
    private e gSh;
    private i gSi;
    private boolean gSo;
    private boolean gSp;
    private int gSq;
    private boolean gSr;
    private float gSs;
    private com.baidu.tieba.c.d gSt;
    private boolean gSu;
    private boolean gSv;
    private com.baidu.tieba.ueg.c gSz;
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
    private boolean gSe = true;
    private boolean gSj = false;
    private boolean gSk = true;
    private com.baidu.tieba.image.a gSl = null;
    private boolean gSm = false;
    private boolean gSn = false;
    private boolean cwH = false;
    private int Sf = 0;
    private boolean gSw = false;
    private boolean gRR = false;
    private boolean gSx = false;
    private String gSy = null;
    private List<com.baidu.tbadk.core.dialog.g> eyu = null;
    private final CustomMessageListener gSF = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k) && (kVar = (com.baidu.tbadk.data.k) customResponsedMessage.getData()) != null && !StringUtils.isNull(kVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(kVar);
                if (StringUtils.isNull(kVar.cpF)) {
                    ba.aiz().c(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    ba.aiz().c(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.cpF});
                }
            }
        }
    };
    private DragImageView.d cnn = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void avW() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gSc, 8);
            if (ImageViewerActivity.this.gSd != null) {
                ImageViewerActivity.this.gSd.eQ(false);
            }
            ImageViewerActivity.this.bGm();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void avX() {
            TiebaStatic.log(new am("c13341").P("obj_param1", ImageViewerActivity.this.gSd.getItemNum()).P("obj_param2", ImageViewerActivity.this.gSd.getCurrentMaxIndex()));
            TiebaStatic.log(new am("c13377").bT("obj_type", "2"));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void avY() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 0);
            if (ImageViewerActivity.this.gSd != null && !ImageViewerActivity.this.gSd.apo()) {
                ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gSc, 0);
                ImageViewerActivity.this.gSd.eQ(true);
            }
        }
    };
    private UrlDragImageView.b clp = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void apI() {
            TiebaStatic.log(new am("c10351").bT("tid", ImageViewerActivity.this.bVL).bT("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final View.OnClickListener gSG = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jG()) {
                ImageViewerActivity.this.showToast(R.string.neterror);
                return;
            }
            TiebaStatic.log(new am("pb_onlyowner_click").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).P("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
            TiebaStatic.log(new am("c13338").P("obj_locate", ImageViewerActivity.this.mIsSeeHost ? 1 : 2));
            ImageViewerActivity.this.gSo = true;
            if (ImageViewerActivity.this.gSc != null) {
                ImageViewerActivity.this.gSc.setEnabled(false);
            }
            ImageViewerActivity.this.j(d.yZ((String) v.c(ImageViewerActivity.this.gSf, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
        }
    };
    private k.b gSH = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.22
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            ImageViewerActivity.this.gSd.jS(ImageViewerActivity.this.bxi());
            ImageViewerActivity.this.aXK();
        }
    };
    private k.b gSI = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.23
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.az(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.gSd.getCurrentImageUrl());
            ImageViewerActivity.this.aXK();
            ImageViewerActivity.this.vH(1);
        }
    };
    private k.b gSJ = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = ImageViewerActivity.this.gSd.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.cuN);
                intent.putExtra(com.baidu.tbadk.imageManager.d.cuO, currentImageUrl);
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
    private k.b gSK = new k.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            UrlDragImageView currentUrlDragImageView;
            if (ImageViewerActivity.this.gSd != null && (currentUrlDragImageView = ImageViewerActivity.this.gSd.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.d.c.nT(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = ImageViewerActivity.this.gSd.getCurrentImageUrl();
                    str2 = as.nT(str);
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
                    eVar.cjz = bundle;
                }
                ImageViewerActivity.this.sendMessage(new CustomMessage(2001276, new ShareDialogConfig(ImageViewerActivity.this.getActivity(), eVar, false)));
                ImageViewerActivity.this.aXK();
                ImageViewerActivity.this.vH(4);
            }
        }
    };
    private k.b gSL = new AnonymousClass5();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (ImageViewerActivity.this.gSx && ImageViewerActivity.this.gSd != null) {
                boolean apo = ImageViewerActivity.this.gSd.apo();
                if (!apo) {
                    com.baidu.tieba.t.a.I(ImageViewerActivity.this.gSc, 100);
                    i = 1;
                } else {
                    com.baidu.tieba.t.a.J(ImageViewerActivity.this.gSc, 100);
                    i = 2;
                }
                ImageViewerActivity.this.gSd.g(apo ? false : true, 100);
                TiebaStatic.log(new am("c13397").P("obj_type", i));
                return;
            }
            TiebaStatic.log(new am("c13341").P("obj_param1", ImageViewerActivity.this.gSd.getItemNum()).P("obj_param2", ImageViewerActivity.this.gSd.getCurrentMaxIndex()));
            TiebaStatic.log(new am("c13377").bT("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean gSN = true;
    private View.OnTouchListener cnB = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.gSM = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.gSN = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.gSM = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.gSN = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener gSO = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.bdz();
            ImageViewerActivity.this.show();
            ImageViewerActivity.this.cf(view);
            TiebaStatic.log(new am("c13269").bT("uid", ImageViewerActivity.this.mUserId).bT("fid", ImageViewerActivity.this.eAC).bT("tid", ImageViewerActivity.this.bVL));
            return true;
        }
    };
    private BaseViewPager.a gSP = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void is(int i) {
            if (i == 0) {
                ImageViewerActivity.this.gSh.bFU();
            } else if (ImageViewerActivity.this.bGh() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.gSh.bFV();
            }
        }
    };
    private ViewPager.OnPageChangeListener ccX = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.gSh != null && i > ImageViewerActivity.this.gSd.getItemNum() - 5) {
                ImageViewerActivity.this.gSh.bFU();
            }
            ImageViewerActivity.this.gSi.e(ImageViewerActivity.this.gSf, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.bGi();
            ImageViewerActivity.this.bGn();
            ImageViewerActivity.this.vI(i);
            if (ImageViewerActivity.this.gSi.bGr() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.gSi.vJ(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.gSi.bGs() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.gSi.vK(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.bGj()) {
                ImageViewerActivity.this.gSl.bFI();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.gSd.getItemNum() - 1) {
                ImageViewerActivity.this.gSj = false;
            }
            ImageViewerActivity.this.gSy = null;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.Sf) {
                ImageViewerActivity.this.Sf = i;
                ImageViewerActivity.this.cwH = true;
            } else if (i < ImageViewerActivity.this.Sf) {
                ImageViewerActivity.this.Sf = i;
                ImageViewerActivity.this.cwH = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.gSf != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.gSf.size()) {
                ImageViewerActivity.this.gSi.as(i, (String) ImageViewerActivity.this.gSf.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.gSd.getItemNum() - 1) {
                if (!ImageViewerActivity.this.gSN || !ImageViewerActivity.this.gSr || (!ImageViewerActivity.this.gSj && !ImageViewerActivity.this.bGj() && (ImageViewerActivity.this.gSd.getItemNum() != 1 || !ImageViewerActivity.this.cwH))) {
                    ImageViewerActivity.this.gSj = true;
                } else {
                    ImageViewerActivity.this.showToast(R.string.last_page);
                }
            }
        }
    };
    private CustomMessageListener bVs = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.cmJ != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.cmJ.values()) {
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
    private CustomMessageListener bVt = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.cmJ != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.cmJ.values()) {
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
    private CustomMessageListener gSQ = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && !ImageViewerActivity.this.isFinishing() && (nVar = (n) customResponsedMessage.getData()) != null) {
                nVar.iZI = null;
                if (!TextUtils.isEmpty(nVar.iZK) && !TextUtils.isEmpty(nVar.iZH) && nVar.iZH.equals(ImageViewerActivity.this.gSy)) {
                    ImageViewerActivity.this.gSd.setCurrentImageQRInfo(nVar.iZK);
                    ImageViewerActivity.this.zd(nVar.iZK);
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
        this.gSq = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        bsI();
        if (com.baidu.tbadk.core.util.g.agV()) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
        this.gRQ = d.yZ((String) v.c(this.gSf, this.mIndex));
        if (d.za((String) v.c(this.gSf, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        j(this.gRQ, this.mIsSeeHost, false);
        MessageManager.getInstance().registerListener(this.gSF);
        registerListener(this.bVs);
        registerListener(this.bVt);
        registerListener(this.gSQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, boolean z, boolean z2) {
        this.gSh = new e(this.gSf, this.cmJ, this.eAC, this.fAb, this.bVL, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.gSh.setSourceImageRectInScreen(this.gRP);
        this.gSh.mE(this.gSe);
        this.gSh.mF(z);
        this.gSh.zb(this.gRQ);
        this.gSh.mD(this.gRR);
        this.gSh.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.gSd != null) {
                    if (ImageViewerActivity.this.gSo) {
                        if (!z5) {
                            ImageViewerActivity.this.gSd.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.gSo = false;
                    if (ImageViewerActivity.this.gSc != null) {
                        ImageViewerActivity.this.gSc.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.gSd.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.gSd.getItemNum();
                        ImageViewerActivity.this.gSd.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.gSd.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.gSd.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.gSl != null) {
                        ImageViewerActivity.this.gSl.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.gSd.setUrlData(arrayList);
                    ImageViewerActivity.this.gSd.setAssistUrls(ImageViewerActivity.this.cmJ);
                    ImageViewerActivity.this.gSd.setHasNext(z3);
                    ImageViewerActivity.this.gSd.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.gSd.getItemNum()) {
                        ImageViewerActivity.this.gSd.jQ(ImageViewerActivity.this.gSd.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.gSd.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList.size() >= 400 && ImageViewerActivity.this.gSd.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.gSd.setUrlData(arrayList);
                        ImageViewerActivity.this.gSd.setCurrentItem(ImageViewerActivity.this.gSd.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.bGi();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.gSd.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.gSl.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.gSl.bFE()) {
                    ImageViewerActivity.this.gSd.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.q.a.b("a008", "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.gSd.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void ar(int i, String str2) {
                ImageViewerActivity.this.gSo = false;
                if (ImageViewerActivity.this.gSc != null) {
                    ImageViewerActivity.this.gSc.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.gSf.size();
                    ImageViewerActivity.this.bGi();
                }
            }
        });
        this.gSh.mG(true);
        this.gSh.bFU();
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
            this.gSg = new a(this.gSd.getCurrentImageUrl(), this.gSd.getCurrentImageData());
            this.gSg.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gSd.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.gSd.iA(i);
        super.onChangeSkinType(i);
        this.gSq = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gSd.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long c = com.baidu.adp.lib.g.b.c(this.bVL, 0L);
        if (uniqueId != null && c > 0) {
            p.m(uniqueId.getId(), c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gSd.onResume();
        this.mIsLogin = com.baidu.tbadk.n.a.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long c = com.baidu.adp.lib.g.b.c(this.bVL, 0L);
        if (uniqueId != null && c > 0) {
            p.a(com.baidu.tbadk.BdToken.b.bxe, uniqueId.getId(), c);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.gSd.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gSz != null && !this.gSz.isCancelled()) {
            this.gSz.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.gSF);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.asp().asq();
        this.gSi.e(this.gSf, this.mIndex, this.mIndex);
        this.gSi.bGt();
        String str = "";
        if (this.gSl != null) {
            str = this.gSl.getAdId();
        }
        this.gSi.d(this.gSd.getPageCount(), str, this.eAC, this.bVL);
        this.gSd.onDestroy();
        if (this.gSg != null) {
            this.gSg.cancel();
            this.gSg = null;
        }
        com.baidu.tbadk.download.d.aqM().kd(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.gSq);
        bGm();
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

    private void bsI() {
        this.mStatusBarView = findViewById(R.id.statusbar_view);
        aHR();
        initViewPager();
        bGi();
        beC();
        bdy();
        this.gSi.e(this.gSf, this.mIndex, this.mIndex);
    }

    private void aHR() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.gSc = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(R.id.see_host_image_txt);
        if (this.gSv) {
            setViewVisibility(this.gSc, 8);
        }
        if (this.gSp) {
            if (this.mIsSeeHost) {
                this.gSc.setText(R.string.album_all_thread);
            } else {
                this.gSc.setText(R.string.view_host);
            }
            this.gSc.setOnClickListener(this.gSG);
        } else {
            setViewVisibility(this.gSc, 8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_btn_a));
        this.mTitleView.setTextSize(0, l.g(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long bGh() {
        ImageUrlData imageUrlData;
        String str = (String) v.c(this.gSf, this.mIndex);
        if (this.cmJ == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.cmJ.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGi() {
        String str;
        if (this.gSf != null) {
            String str2 = ("" + bGh()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (this.mFrom != null && !this.gSw && bGh() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new am("c13316").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom));
                this.gSw = true;
            }
            if (bGj()) {
                bGk();
            } else {
                zc(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bGj() {
        if (this.gSk && this.gSl != null && this.gSl.bFE()) {
            return this.gSd.getItemNum() != 1 && this.mIndex == this.gSd.getItemNum() + (-1);
        }
        return false;
    }

    private void zc(String str) {
        this.mTitleView.setText(str);
        if (this.gSp && !this.gSv) {
            if (this.mIsSeeHost) {
                this.gSc.setText(R.string.album_all_thread);
            } else {
                this.gSc.setText(R.string.view_host);
            }
        }
    }

    private void bGk() {
        this.mTitleView.setText("");
        setViewVisibility(this.gSc, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.gSd == null) {
            this.gSd = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.gSd.init();
        }
        this.gSd.setIsFromCDN(this.clx);
        this.gSd.setIsCanDrag(this.clz);
        this.gSd.setIsHotSort(this.clA);
        this.gSd.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.gSd.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.gSd.setOnPageChangeListener(this.ccX);
        this.gSd.setUrlData(this.gSf);
        this.gSd.setAssistUrls(this.cmJ);
        this.gSd.setOuterOnTouchListener(this.cnB);
        this.gSd.setItemOnclickListener(this.mOnClickListener);
        this.gSd.setItemOnLongClickListener(this.gSO);
        this.gSd.setCurrentItem(bxi(), false);
        this.gSd.setOnScrollOutListener(this.gSP);
        this.gSl = new com.baidu.tieba.image.a(this.clx, this.gSk, getPageContext(), this.eAC, this.bVL);
        this.gSl.setDragToExitListener(this.cnn);
        this.gSd.a(this.gSl);
        this.gSd.setOriImgSelectedCallback(this.clp);
        this.gSd.setDragToExitListener(this.cnn);
        this.gSd.setUserId(this.mUserId);
        this.gSd.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.gSr = ImageViewerActivity.this.gSs - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.gSs = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        TiebaStatic.log(new am("c13340").bT("uid", this.mUserId).bT("post_id", this.bVL).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bGl()));
    }

    private int bGl() {
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
        String jR = this.gSd.jR(bxi());
        if (jR != null) {
            this.gSA = new com.baidu.tbadk.core.dialog.g(jR, this.eyq);
            this.gSA.a(this.gSH);
            this.eyu.add(this.gSA);
        }
        this.eRA = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.eyq);
        this.eRA.a(this.eRB);
        this.eyu.add(this.eRA);
        this.gSC = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.eyq);
        this.gSC.a(this.gSJ);
        this.eyu.add(this.gSC);
        this.gSB = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.eyq);
        this.gSB.a(this.gSI);
        this.eyu.add(this.gSB);
        String currentImageQRInfo = this.gSd.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.gSE = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.eyq);
            this.gSE.a(this.gSL);
            this.eyu.add(this.gSE);
        }
        this.gSD = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.eyq);
        this.gSD.a(this.gSK);
        this.eyu.add(this.gSD);
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
            final String currentImageQRInfo = ImageViewerActivity.this.gSd.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (l.ki()) {
                    if (ImageViewerActivity.this.gSz != null && !ImageViewerActivity.this.gSz.isCancelled()) {
                        ImageViewerActivity.this.gSz.cancel();
                    }
                    ImageViewerActivity.this.gSz = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.5.1
                        @Override // com.baidu.tieba.ueg.c.a
                        public void bGo() {
                            ImageViewerActivity.this.openUrl(currentImageQRInfo);
                        }

                        @Override // com.baidu.tieba.ueg.c.a
                        public void bGp() {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ImageViewerActivity.this.getPageContext().getPageActivity());
                            aVar.dT(true);
                            aVar.mD(ImageViewerActivity.this.getString(R.string.qr_url_jump_external_title));
                            aVar.dS(true);
                            aVar.mE(ImageViewerActivity.this.getString(R.string.qr_url_jump_external_message));
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
                        public void bGq() {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ImageViewerActivity.this.getPageContext().getPageActivity());
                            aVar.mD(null);
                            aVar.dS(true);
                            aVar.mE(ImageViewerActivity.this.getString(R.string.qr_url_risk_forbid));
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
                    ImageViewerActivity.this.gSz.setPriority(3);
                    ImageViewerActivity.this.gSz.execute(new String[0]);
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
        if (!this.gSv) {
            if (this.gSt == null) {
                this.gSt = new com.baidu.tieba.c.d(getPageContext(), this.gSc);
                this.gSt.pK(R.drawable.pic_sign_tip);
                this.gSt.pJ(48);
                this.gSt.S(true);
                this.gSt.pL(UIMsg.m_AppUI.MSG_APP_GPS);
                this.gSt.pN(-l.g(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.gSt.q(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.bGm();
                    }
                });
            }
            this.gSt.cH(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGm() {
        if (this.gSt != null) {
            this.gSt.aZA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bxi() {
        int Z = v.Z(this.gSf);
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
        this.gSi = new i();
        boolean isLogin = com.baidu.tbadk.n.a.isLogin();
        String bduss = com.baidu.tbadk.n.a.getBduss();
        String tbs = com.baidu.tbadk.n.a.getTbs();
        String stoken = com.baidu.tbadk.n.a.getStoken();
        if (bundle != null) {
            this.gSx = bundle.getBoolean(ImageViewerConfig.ABTEST);
            this.gSf = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.eAC = bundle.getString("fid");
            this.bVL = bundle.getString("tid");
            this.fAb = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.clx = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.gSe = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.gSk = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.clz = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.clA = bundle.getBoolean(ImageViewerConfig.IS_HOT_SORT, false);
            this.gSp = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.gRP = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            this.gRR = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            if (serializable instanceof Map) {
                this.cmJ = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.cmJ.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.gSu = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.gSv = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.gSx = intent.getBooleanExtra(ImageViewerConfig.ABTEST, false);
                this.gSf = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.eAC = intent.getStringExtra("fid");
                this.bVL = intent.getStringExtra("tid");
                this.fAb = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.clx = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.gSe = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.gSk = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.clz = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.clA = intent.getBooleanExtra(ImageViewerConfig.IS_HOT_SORT, false);
                this.gSp = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.gSu = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.gSv = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.gRP = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                this.gRR = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.cmJ = (Map) serializableExtra;
                }
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.n.a.fr(isLogin);
        com.baidu.tbadk.n.a.qA(bduss);
        com.baidu.tbadk.n.a.setStoken(stoken);
        com.baidu.tbadk.n.a.setTbs(tbs);
        this.gSi.b(bundle, getIntent());
        this.mCount = v.Z(this.gSf);
        if (this.gRP != null) {
            String str = (String) v.c(this.gSf, this.mIndex);
            if (!StringUtils.isNull(str) && this.cmJ != null && (imageUrlData = this.cmJ.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.gRP);
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
        bundle.putBoolean(ImageViewerConfig.ABTEST, this.gSx);
        bundle.putStringArrayList("url", this.gSf);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.eAC);
        bundle.putString("tid", this.bVL);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.fAb);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.gSe);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.clz);
        bundle.putBoolean(ImageViewerConfig.IS_HOT_SORT, this.clA);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.gSp);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.gSk);
        bundle.putString("user_id", this.mUserId);
        if (this.cmJ instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.cmJ.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.cmJ instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.cmJ.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.gRP);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.gSu);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.gSv);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.gRR);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.n.a.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.n.a.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.n.a.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.n.a.getTbs());
        this.gSi.Z(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.gSd.setCurrentItem(this.mIndex, false);
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
            String nT;
            if (this.mUrl != null && ImageViewerActivity.this.cmJ != null) {
                Iterator it = ImageViewerActivity.this.cmJ.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ao.aig().nK(nT) + "/" + as.nT(imageUrlData.originalUrl);
                    int[] nn = m.nn(str);
                    if (nn != null && nn.length == 2 && nn[0] > 0 && m.e(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
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
            ImageViewerActivity.this.gSg = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.gSg = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zd(String str) {
        int i;
        boolean z = false;
        if (this.eyp != null && !isFinishing() && this.eyp.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.gSE = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.eyq);
            this.gSE.a(this.gSL);
            int i2 = 0;
            while (true) {
                if (i2 < this.eyu.size()) {
                    if (this.gSB == null || this.eyu.get(i2) != this.gSB || (i = i2 + 1) > this.eyu.size()) {
                        i2++;
                    } else {
                        this.eyu.add(i, this.gSE);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.eyu.add(this.gSE);
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
                nVar.iZI = imageBitmap;
                String currentImageUrl = this.gSd.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    nVar.iZH = String.valueOf(System.currentTimeMillis()) + as.nT(currentImageUrl);
                } else {
                    nVar.iZH = String.valueOf(BdUniqueId.gen().getId());
                }
                this.gSy = nVar.iZH;
                sendMessage(new CustomMessage(2921403, nVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vI(int i) {
        if (this.gSd != null) {
            this.gSd.jP(i);
            setViewVisibility(this.gSc, (this.gSd.apo() || bGj()) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGn() {
        if (bGj()) {
            this.gSn = this.mNavigationBar.getVisibility() == 0;
            this.gSm = true;
        } else if (this.gSm) {
            this.mNavigationBar.setVisibility(this.gSn ? 0 : 8);
            this.gSm = false;
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
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.bVL, 0L));
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.coreExtra.view.a
    public boolean ape() {
        return this.gSx;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (ap.isEmpty(this.bVL)) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.c(this.bVL, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }
}
