package com.baidu.tieba.image;

import android.content.Intent;
import android.content.res.Configuration;
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
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.image.e;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> implements com.baidu.tbadk.coreExtra.view.a {
    private String ahO;
    private Map<String, ImageUrlData> dTF;
    private String eQk;
    private String eQl;
    private ImageView fPd;
    private View har;
    private TextView iDC;
    private MultiImageView iDD;
    private ArrayList<String> iDE;
    private e iDF;
    private i iDG;
    private j iDH;
    private boolean iDI;
    private float iDJ;
    private com.baidu.tieba.c.d iDK;
    private int iDO;
    private boolean iDP;
    private String iDm;
    private String iDn;
    private float iEc;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private String mPostId;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private a iDL = null;
    private boolean iDM = false;
    private boolean iDN = false;
    private int XP = 0;
    private boolean isRight = false;
    private boolean iDQ = false;
    private boolean iDR = false;
    private boolean iDS = true;
    private boolean dSy = true;
    private boolean iDT = true;
    private boolean mIsSeeHost = false;
    private boolean iDU = false;
    private boolean iDV = false;
    private boolean iDW = false;
    private boolean iDo = false;
    private boolean iDX = true;
    private boolean iDY = false;
    private boolean dSw = false;
    private boolean iDZ = true;
    private boolean iDp = false;
    private final CustomMessageListener iEa = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.j jVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && (jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData()) != null && !StringUtils.isNull(jVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(jVar);
                if (StringUtils.isNull(jVar.dVP)) {
                    ba.aOV().b(ImageViewerActivity.this.getPageContext(), new String[]{jVar.mLink});
                } else {
                    ba.aOV().b(ImageViewerActivity.this.getPageContext(), new String[]{jVar.mLink, jVar.dVP});
                }
            }
        }
    };
    private DragImageView.d dUg = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.o(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.o(ImageViewerActivity.this.iDC, 8);
            ImageViewerActivity.this.o(ImageViewerActivity.this.har, 8);
            if (ImageViewerActivity.this.iDD != null) {
                ImageViewerActivity.this.iDD.hp(false);
            }
            ImageViewerActivity.this.clz();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new an("c13341").af("obj_param1", ImageViewerActivity.this.iDD.getItemNum()).af(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.iDD.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void baR() {
            ImageViewerActivity.this.o(ImageViewerActivity.this.mTitleView, 0);
            if (!ImageViewerActivity.this.iDY || !TbadkCoreApplication.isLogin()) {
                ImageViewerActivity.this.har.setVisibility(8);
            } else {
                ImageViewerActivity.this.har.setVisibility(0);
            }
            if (ImageViewerActivity.this.iDD != null) {
                boolean aVp = ImageViewerActivity.this.iDD.aVp();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !aVp) {
                    ImageViewerActivity.this.o(ImageViewerActivity.this.iDC, 0);
                    if (ImageViewerActivity.this.iDZ) {
                        ImageViewerActivity.this.iDD.hp(true);
                    } else {
                        ImageViewerActivity.this.iDD.hp(false);
                    }
                }
            }
        }
    };
    private UrlDragImageView.b dSp = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void aVH() {
            TiebaStatic.log(new an("c10351").cI("tid", ImageViewerActivity.this.ahO).cI("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final View.OnClickListener iEb = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.showToast(R.string.neterror);
                return;
            }
            TiebaStatic.log(new an("pb_onlyowner_click").af("obj_source", 2).af("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
            TiebaStatic.log(new an("c13338").af("obj_locate", ImageViewerActivity.this.mIsSeeHost ? 1 : 2));
            ImageViewerActivity.this.iDP = true;
            if (ImageViewerActivity.this.iDC != null) {
                ImageViewerActivity.this.iDC.setEnabled(false);
            }
            ImageViewerActivity.this.k(d.Fz((String) v.getItem(ImageViewerActivity.this.iDE, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (ImageViewerActivity.this.iDY && ImageViewerActivity.this.iDD != null) {
                boolean aVp = ImageViewerActivity.this.iDD.aVp();
                if (ImageViewerActivity.this.iDC == null) {
                    i = 0;
                } else if (!aVp) {
                    com.baidu.tieba.v.a.w(ImageViewerActivity.this.iDC, 100);
                    i = 1;
                } else {
                    com.baidu.tieba.v.a.x(ImageViewerActivity.this.iDC, 100);
                    i = 2;
                }
                ImageViewerActivity.this.iDD.o(aVp ? false : true, 100);
                TiebaStatic.log(new an("c13397").af("obj_type", i));
                return;
            }
            TiebaStatic.log(new an("c13341").af("obj_param1", ImageViewerActivity.this.iDD.getItemNum()).af(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.iDD.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").cI("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean iEd = true;
    private View.OnTouchListener dUs = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.iEc = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.iEd = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.iEc = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.iEd = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener iEe = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.iDH != null) {
                ImageViewerActivity.this.iDH.bId();
                ImageViewerActivity.this.iDH.show();
                ImageViewerActivity.this.iDH.cp(view);
            }
            TiebaStatic.log(new an("c13269").cI("uid", ImageViewerActivity.this.mUserId).cI("fid", ImageViewerActivity.this.eQk).cI("tid", ImageViewerActivity.this.ahO));
            return true;
        }
    };
    private BaseViewPager.a iEf = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.iDF.cle();
            } else if (ImageViewerActivity.this.clu() != 1) {
                ImageViewerActivity.this.iDF.clf();
            }
        }
    };
    private ViewPager.OnPageChangeListener byN = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.iDF != null && i > ImageViewerActivity.this.iDD.getItemNum() - 5) {
                ImageViewerActivity.this.iDF.cle();
            }
            ImageViewerActivity.this.iDG.e(ImageViewerActivity.this.iDE, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.clv();
            ImageViewerActivity.this.clA();
            ImageViewerActivity.this.xO(i);
            if (ImageViewerActivity.this.iDG.clC() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.iDG.xP(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.iDG.clD() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.iDG.xQ(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.clw()) {
                ImageViewerActivity.this.iDL.ckS();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.iDD.getItemNum() - 1) {
                ImageViewerActivity.this.iDR = false;
            }
            if (ImageViewerActivity.this.iDH != null) {
                ImageViewerActivity.this.iDH.clF();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.XP) {
                ImageViewerActivity.this.XP = i;
                ImageViewerActivity.this.isRight = true;
            } else if (i < ImageViewerActivity.this.XP) {
                ImageViewerActivity.this.XP = i;
                ImageViewerActivity.this.isRight = false;
            }
            if (ImageViewerActivity.this.iDD != null) {
                dragImageView = ImageViewerActivity.this.iDD.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.clu() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.iDE != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.iDE.size()) {
                ImageViewerActivity.this.iDG.bb(i, (String) ImageViewerActivity.this.iDE.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.iDD.getItemNum() - 1) {
                if (!ImageViewerActivity.this.iEd || !ImageViewerActivity.this.iDI || (!ImageViewerActivity.this.iDR && !ImageViewerActivity.this.clw() && (ImageViewerActivity.this.iDD.getItemNum() != 1 || !ImageViewerActivity.this.isRight))) {
                    ImageViewerActivity.this.iDR = true;
                } else {
                    ImageViewerActivity.this.showToast(R.string.last_page);
                }
            }
        }
    };
    private CustomMessageListener dDy = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.dTF != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.dTF.values()) {
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
    private CustomMessageListener dDz = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.dTF != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.dTF.values()) {
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
    public void o(View view, int i) {
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
        com.baidu.tbadk.mutiprocess.g.aYz().init(TbadkCoreApplication.getInst());
        this.iDO = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        bXK();
        k(this.iDn, this.mIsSeeHost, false);
        registerListener(this.iEa);
        registerListener(this.dDy);
        registerListener(this.dDz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.iDF = new e(this.iDE, this.dTF, this.eQk, this.eQl, this.ahO, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.iDF.setSourceImageRectInScreen(this.iDm);
        this.iDF.pw(this.iDX);
        this.iDF.px(z);
        this.iDF.FB(this.iDn);
        this.iDF.pv(this.iDo);
        this.iDF.setPostId(this.mPostId);
        this.iDF.pz(this.iDp);
        this.iDF.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.iDD != null) {
                    if (ImageViewerActivity.this.iDP) {
                        if (!z5) {
                            ImageViewerActivity.this.iDD.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.iDP = false;
                    if (ImageViewerActivity.this.iDC != null) {
                        ImageViewerActivity.this.iDC.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.iDD.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.iDD.getItemNum();
                        ImageViewerActivity.this.iDD.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.iDD.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.iDD.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.iDL != null) {
                        ImageViewerActivity.this.iDL.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.iDD.setUrlData(arrayList);
                    ImageViewerActivity.this.iDD.setAssistUrls(ImageViewerActivity.this.dTF);
                    ImageViewerActivity.this.iDD.setHasNext(z3);
                    ImageViewerActivity.this.iDD.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.iDD.getItemNum()) {
                        ImageViewerActivity.this.iDD.mp(ImageViewerActivity.this.iDD.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.iDD.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.iDD.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.iDD.setUrlData(arrayList);
                        ImageViewerActivity.this.iDD.setCurrentItem(ImageViewerActivity.this.iDD.getCurrentItem() - 200, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.clv();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.iDD.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.iDL.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.iDL.ckO()) {
                    ImageViewerActivity.this.iDD.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.iDD.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void ba(int i, String str2) {
                ImageViewerActivity.this.iDP = false;
                if (ImageViewerActivity.this.iDC != null) {
                    ImageViewerActivity.this.iDC.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.iDE != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.iDE.size();
                    }
                    ImageViewerActivity.this.clv();
                }
            }
        });
        this.iDF.py(true);
        this.iDF.cle();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        if (!k.isFastDoubleClick()) {
            TiebaStatic.log(new an("c13377").cI("obj_type", "4"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.iDD.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.iDD.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.iDO = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.iDD.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.ahO, 0L);
        if (uniqueId != null && j > 0) {
            q.q(uniqueId.getId(), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.iDD.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.ahO, 0L);
        if (uniqueId != null && j > 0) {
            q.a(com.baidu.tbadk.BdToken.b.dgl, uniqueId.getId(), j);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.iDD.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2 = null;
        MessageManager.getInstance().unRegisterListener(this.iEa);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.aYk().releaseBlockBitmapPool();
        this.iDG.e(this.iDE, this.mIndex, this.mIndex);
        this.iDG.clE();
        String str3 = "";
        if (this.iDL != null) {
            str3 = this.iDL.getAdId();
        }
        if (this.iDF != null) {
            str = this.iDF.aMi();
            str2 = this.iDF.aMj();
        } else {
            str = null;
        }
        this.iDG.a(this.iDD.getPageCount(), str3, this.eQk, this.ahO, str, str2);
        if (this.iDH != null) {
            this.iDH.release();
        }
        this.iDD.onDestroy();
        com.baidu.tbadk.download.d.aWJ().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.iDO);
        clz();
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

    private void bXK() {
        blD();
        initViewPager();
        clv();
        bJp();
        clr();
        this.iDH = new j(this);
        this.iDH.j(this.iDD);
        this.iDG.e(this.iDE, this.mIndex, this.mIndex);
    }

    private void clr() {
        if (com.baidu.tbadk.core.util.g.aOc()) {
            this.mStatusBarView = findViewById(R.id.statusbar_view);
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
    }

    private void blD() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        cls();
        bpA();
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
        if (d.FA((String) v.getItem(this.iDE, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void cls() {
        this.har = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.har.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.fPd = (ImageView) this.har.findViewById(R.id.widget_navi_back_button);
        SvgManager.aOR().a(this.fPd, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.iDY && TbadkCoreApplication.isLogin()) {
            this.har.setVisibility(0);
        } else {
            this.har.setVisibility(8);
        }
    }

    private void bpA() {
        if (!this.iDV && !this.iDU) {
            this.iDC = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(R.id.see_host_image_txt);
            if (this.iDT) {
                this.iDC.setText(this.mIsSeeHost ? R.string.album_all_thread : R.string.view_host);
                this.iDC.setOnClickListener(this.iEb);
                return;
            }
            o(this.iDC, 8);
        }
    }

    public Map<String, ImageUrlData> clt() {
        return this.dTF;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long clu() {
        ImageUrlData imageUrlData;
        String str = (String) v.getItem(this.iDE, this.mIndex);
        if (this.dTF == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.dTF.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clv() {
        String str;
        if (this.iDE != null) {
            String str2 = ("" + clu()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.iDQ && clu() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new an("c13316").cI("obj_source", this.mFrom));
                this.iDQ = true;
            }
            if (clw()) {
                clx();
            } else {
                FC(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean clw() {
        if (this.iDS && this.iDL != null && this.iDL.ckO()) {
            return this.iDD.getItemNum() != 1 && this.mIndex == this.iDD.getItemNum() + (-1);
        }
        return false;
    }

    private void FC(String str) {
        this.mTitleView.setText(str);
        if (this.iDT && !this.iDU && this.iDC != null) {
            this.iDC.setText(this.mIsSeeHost ? R.string.album_all_thread : R.string.view_host);
        }
    }

    private void clx() {
        this.mTitleView.setText("");
        o(this.iDC, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.iDD == null) {
            this.iDD = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.iDD.init();
        }
        this.iDD.setIsFromCDN(this.dSw);
        this.iDD.setIsCanDrag(this.dSy);
        this.iDD.setIsBJHThread(this.iDV);
        this.iDD.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.iDD.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.iDD.setOnPageChangeListener(this.byN);
        this.iDD.setUrlData(this.iDE);
        this.iDD.setAssistUrls(this.dTF);
        this.iDD.setOuterOnTouchListener(this.dUs);
        this.iDD.setItemOnclickListener(this.mOnClickListener);
        this.iDD.setItemOnLongClickListener(this.iEe);
        this.iDD.setCurrentItem(ccs(), false);
        this.iDD.setOnScrollOutListener(this.iEf);
        this.iDL = new a(this.dSw, this.iDS, getPageContext(), this.eQk, this.ahO);
        this.iDL.setDragToExitListener(this.dUg);
        this.iDD.a(this.iDL);
        this.iDD.setOriImgSelectedCallback(this.dSp);
        this.iDD.setDragToExitListener(this.dUg);
        this.iDD.setUserId(this.mUserId);
        this.iDD.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.iDI = ImageViewerActivity.this.iDJ - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.iDJ = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        this.iDD.setShowBottomContainer(this.iDZ);
        TiebaStatic.log(new an("c13340").cI("uid", this.mUserId).cI("post_id", this.ahO).af("obj_source", cly()));
    }

    private int cly() {
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

    private void bJp() {
        if (!this.iDU && this.iDC != null) {
            if (this.iDK == null) {
                this.iDK = new com.baidu.tieba.c.d(getPageContext(), this.iDC);
                this.iDK.cz(R.drawable.pic_sign_tip);
                this.iDK.cy(48);
                this.iDK.setUseDirectOffset(true);
                this.iDK.cA(5000);
                this.iDK.rS(-l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.iDK.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.clz();
                    }
                });
            }
            this.iDK.al(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clz() {
        if (this.iDK != null) {
            this.iDK.ED();
        }
    }

    public int ccs() {
        int count = v.getCount(this.iDE);
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
        this.iDG = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.iDV = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.iDY = bundle.getBoolean("abtest");
            this.iDE = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.eQk = bundle.getString("fid");
            this.ahO = bundle.getString("tid");
            this.eQl = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.dSw = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.iDX = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.iDS = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.dSy = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.iDT = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.iDm = bundle.getString("source_rect_in_screen");
            this.iDo = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.iDZ = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.iDp = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.dTF = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.dTF.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.iDW = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.iDU = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.iDV = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.iDY = intent.getBooleanExtra("abtest", false);
                this.iDE = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.eQk = intent.getStringExtra("fid");
                this.ahO = intent.getStringExtra("tid");
                this.eQl = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.dSw = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.iDX = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.iDS = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.dSy = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.iDT = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.iDZ = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.iDp = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.iDW = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.iDU = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.iDm = intent.getStringExtra("source_rect_in_screen");
                this.iDo = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.dTF = (Map) serializableExtra;
                }
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.mutiprocess.f.hL(isLogin);
        com.baidu.tbadk.mutiprocess.f.setBduss(bduss);
        com.baidu.tbadk.mutiprocess.f.setStoken(stoken);
        com.baidu.tbadk.mutiprocess.f.setTbs(tbs);
        this.iDG.b(bundle, getIntent());
        this.mCount = v.getCount(this.iDE);
        if (this.iDm != null) {
            String str = (String) v.getItem(this.iDE, this.mIndex);
            if (!StringUtils.isNull(str) && this.dTF != null && (imageUrlData = this.dTF.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.iDm);
            }
        }
        this.iDn = this.iDV ? null : d.Fz((String) v.getItem(this.iDE, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new an("c13337").cI("obj_type", "2"));
        } else {
            TiebaStatic.log(new an("c13337").cI("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.iDV);
        bundle.putBoolean("abtest", this.iDY);
        bundle.putStringArrayList("url", this.iDE);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.eQk);
        bundle.putString("tid", this.ahO);
        bundle.putString("fname", this.eQl);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.iDX);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.dSy);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.iDT);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.iDS);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.iDZ);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.iDp);
        if (this.dTF instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.dTF.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.dTF instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.dTF.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.iDm);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.iDW);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.iDU);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.iDo);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        this.iDG.ar(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.iDD.setCurrentItem(this.mIndex, false);
        SvgManager.aOR().a(this.fPd, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xO(int i) {
        if (this.iDD != null) {
            this.iDD.mo(i);
            o(this.iDC, (this.iDD.aVp() || clw()) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clA() {
        if (clw()) {
            this.iDN = this.mNavigationBar.getVisibility() == 0;
            this.iDM = true;
        } else if (this.iDM) {
            this.mNavigationBar.setVisibility(this.iDN ? 0 : 8);
            this.iDM = false;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.BIGIMAGE;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.aZk().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.eQk, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.ahO, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.wY(TbadkCoreApplication.getInst().getAdAdSense().dMx);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.coreExtra.view.a
    public boolean aVg() {
        return this.iDY;
    }

    public boolean clB() {
        return this.iDV;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (aq.isEmpty(this.ahO)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.ahO, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }
}
