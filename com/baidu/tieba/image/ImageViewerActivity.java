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
    private String ahL;
    private Map<String, ImageUrlData> dTA;
    private String eQf;
    private String eQg;
    private ImageView fOY;
    private View hal;
    private i iDA;
    private j iDB;
    private boolean iDC;
    private float iDD;
    private com.baidu.tieba.c.d iDE;
    private int iDI;
    private boolean iDJ;
    private float iDW;
    private String iDg;
    private String iDh;
    private TextView iDw;
    private MultiImageView iDx;
    private ArrayList<String> iDy;
    private e iDz;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private String mPostId;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private a iDF = null;
    private boolean iDG = false;
    private boolean iDH = false;
    private int XM = 0;
    private boolean isRight = false;
    private boolean iDK = false;
    private boolean iDL = false;
    private boolean iDM = true;
    private boolean dSt = true;
    private boolean iDN = true;
    private boolean mIsSeeHost = false;
    private boolean iDO = false;
    private boolean iDP = false;
    private boolean iDQ = false;
    private boolean iDi = false;
    private boolean iDR = true;
    private boolean iDS = false;
    private boolean dSr = false;
    private boolean iDT = true;
    private boolean iDj = false;
    private final CustomMessageListener iDU = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.j jVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && (jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData()) != null && !StringUtils.isNull(jVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(jVar);
                if (StringUtils.isNull(jVar.dVK)) {
                    ba.aOY().b(ImageViewerActivity.this.getPageContext(), new String[]{jVar.mLink});
                } else {
                    ba.aOY().b(ImageViewerActivity.this.getPageContext(), new String[]{jVar.mLink, jVar.dVK});
                }
            }
        }
    };
    private DragImageView.d dUb = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.o(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.o(ImageViewerActivity.this.iDw, 8);
            ImageViewerActivity.this.o(ImageViewerActivity.this.hal, 8);
            if (ImageViewerActivity.this.iDx != null) {
                ImageViewerActivity.this.iDx.hp(false);
            }
            ImageViewerActivity.this.clA();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new an("c13341").af("obj_param1", ImageViewerActivity.this.iDx.getItemNum()).af(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.iDx.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void baT() {
            ImageViewerActivity.this.o(ImageViewerActivity.this.mTitleView, 0);
            if (!ImageViewerActivity.this.iDS || !TbadkCoreApplication.isLogin()) {
                ImageViewerActivity.this.hal.setVisibility(8);
            } else {
                ImageViewerActivity.this.hal.setVisibility(0);
            }
            if (ImageViewerActivity.this.iDx != null) {
                boolean aVr = ImageViewerActivity.this.iDx.aVr();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !aVr) {
                    ImageViewerActivity.this.o(ImageViewerActivity.this.iDw, 0);
                    if (ImageViewerActivity.this.iDT) {
                        ImageViewerActivity.this.iDx.hp(true);
                    } else {
                        ImageViewerActivity.this.iDx.hp(false);
                    }
                }
            }
        }
    };
    private UrlDragImageView.b dSk = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void aVJ() {
            TiebaStatic.log(new an("c10351").cI("tid", ImageViewerActivity.this.ahL).cI("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final View.OnClickListener iDV = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.showToast(R.string.neterror);
                return;
            }
            TiebaStatic.log(new an("pb_onlyowner_click").af("obj_source", 2).af("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
            TiebaStatic.log(new an("c13338").af("obj_locate", ImageViewerActivity.this.mIsSeeHost ? 1 : 2));
            ImageViewerActivity.this.iDJ = true;
            if (ImageViewerActivity.this.iDw != null) {
                ImageViewerActivity.this.iDw.setEnabled(false);
            }
            ImageViewerActivity.this.k(d.Fw((String) v.getItem(ImageViewerActivity.this.iDy, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (ImageViewerActivity.this.iDS && ImageViewerActivity.this.iDx != null) {
                boolean aVr = ImageViewerActivity.this.iDx.aVr();
                if (ImageViewerActivity.this.iDw == null) {
                    i = 0;
                } else if (!aVr) {
                    com.baidu.tieba.v.a.w(ImageViewerActivity.this.iDw, 100);
                    i = 1;
                } else {
                    com.baidu.tieba.v.a.x(ImageViewerActivity.this.iDw, 100);
                    i = 2;
                }
                ImageViewerActivity.this.iDx.o(aVr ? false : true, 100);
                TiebaStatic.log(new an("c13397").af("obj_type", i));
                return;
            }
            TiebaStatic.log(new an("c13341").af("obj_param1", ImageViewerActivity.this.iDx.getItemNum()).af(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.iDx.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").cI("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean iDX = true;
    private View.OnTouchListener dUn = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.iDW = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.iDX = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.iDW = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.iDX = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener iDY = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.iDB != null) {
                ImageViewerActivity.this.iDB.bIe();
                ImageViewerActivity.this.iDB.show();
                ImageViewerActivity.this.iDB.cp(view);
            }
            TiebaStatic.log(new an("c13269").cI("uid", ImageViewerActivity.this.mUserId).cI("fid", ImageViewerActivity.this.eQf).cI("tid", ImageViewerActivity.this.ahL));
            return true;
        }
    };
    private BaseViewPager.a iDZ = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.iDz.clf();
            } else if (ImageViewerActivity.this.clv() != 1) {
                ImageViewerActivity.this.iDz.clg();
            }
        }
    };
    private ViewPager.OnPageChangeListener byI = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.iDz != null && i > ImageViewerActivity.this.iDx.getItemNum() - 5) {
                ImageViewerActivity.this.iDz.clf();
            }
            ImageViewerActivity.this.iDA.e(ImageViewerActivity.this.iDy, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.clw();
            ImageViewerActivity.this.clB();
            ImageViewerActivity.this.xO(i);
            if (ImageViewerActivity.this.iDA.clD() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.iDA.xP(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.iDA.clE() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.iDA.xQ(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.clx()) {
                ImageViewerActivity.this.iDF.ckT();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.iDx.getItemNum() - 1) {
                ImageViewerActivity.this.iDL = false;
            }
            if (ImageViewerActivity.this.iDB != null) {
                ImageViewerActivity.this.iDB.clG();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.XM) {
                ImageViewerActivity.this.XM = i;
                ImageViewerActivity.this.isRight = true;
            } else if (i < ImageViewerActivity.this.XM) {
                ImageViewerActivity.this.XM = i;
                ImageViewerActivity.this.isRight = false;
            }
            if (ImageViewerActivity.this.iDx != null) {
                dragImageView = ImageViewerActivity.this.iDx.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.clv() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.iDy != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.iDy.size()) {
                ImageViewerActivity.this.iDA.bb(i, (String) ImageViewerActivity.this.iDy.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.iDx.getItemNum() - 1) {
                if (!ImageViewerActivity.this.iDX || !ImageViewerActivity.this.iDC || (!ImageViewerActivity.this.iDL && !ImageViewerActivity.this.clx() && (ImageViewerActivity.this.iDx.getItemNum() != 1 || !ImageViewerActivity.this.isRight))) {
                    ImageViewerActivity.this.iDL = true;
                } else {
                    ImageViewerActivity.this.showToast(R.string.last_page);
                }
            }
        }
    };
    private CustomMessageListener dDu = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.dTA != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.dTA.values()) {
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
    private CustomMessageListener dDv = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.dTA != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.dTA.values()) {
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
        com.baidu.tbadk.mutiprocess.g.aYB().init(TbadkCoreApplication.getInst());
        this.iDI = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        bXL();
        k(this.iDh, this.mIsSeeHost, false);
        registerListener(this.iDU);
        registerListener(this.dDu);
        registerListener(this.dDv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.iDz = new e(this.iDy, this.dTA, this.eQf, this.eQg, this.ahL, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.iDz.setSourceImageRectInScreen(this.iDg);
        this.iDz.pw(this.iDR);
        this.iDz.px(z);
        this.iDz.Fy(this.iDh);
        this.iDz.pv(this.iDi);
        this.iDz.setPostId(this.mPostId);
        this.iDz.pz(this.iDj);
        this.iDz.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.iDx != null) {
                    if (ImageViewerActivity.this.iDJ) {
                        if (!z5) {
                            ImageViewerActivity.this.iDx.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.iDJ = false;
                    if (ImageViewerActivity.this.iDw != null) {
                        ImageViewerActivity.this.iDw.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.iDx.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.iDx.getItemNum();
                        ImageViewerActivity.this.iDx.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.iDx.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.iDx.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.iDF != null) {
                        ImageViewerActivity.this.iDF.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.iDx.setUrlData(arrayList);
                    ImageViewerActivity.this.iDx.setAssistUrls(ImageViewerActivity.this.dTA);
                    ImageViewerActivity.this.iDx.setHasNext(z3);
                    ImageViewerActivity.this.iDx.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.iDx.getItemNum()) {
                        ImageViewerActivity.this.iDx.mp(ImageViewerActivity.this.iDx.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.iDx.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.iDx.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.iDx.setUrlData(arrayList);
                        ImageViewerActivity.this.iDx.setCurrentItem(ImageViewerActivity.this.iDx.getCurrentItem() - 200, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.clw();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.iDx.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.iDF.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.iDF.ckP()) {
                    ImageViewerActivity.this.iDx.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.iDx.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void ba(int i, String str2) {
                ImageViewerActivity.this.iDJ = false;
                if (ImageViewerActivity.this.iDw != null) {
                    ImageViewerActivity.this.iDw.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.iDy != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.iDy.size();
                    }
                    ImageViewerActivity.this.clw();
                }
            }
        });
        this.iDz.py(true);
        this.iDz.clf();
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
        this.iDx.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.iDx.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.iDI = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.iDx.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.ahL, 0L);
        if (uniqueId != null && j > 0) {
            q.q(uniqueId.getId(), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.iDx.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.ahL, 0L);
        if (uniqueId != null && j > 0) {
            q.a(com.baidu.tbadk.BdToken.b.dgg, uniqueId.getId(), j);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.iDx.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2 = null;
        MessageManager.getInstance().unRegisterListener(this.iDU);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.aYm().releaseBlockBitmapPool();
        this.iDA.e(this.iDy, this.mIndex, this.mIndex);
        this.iDA.clF();
        String str3 = "";
        if (this.iDF != null) {
            str3 = this.iDF.getAdId();
        }
        if (this.iDz != null) {
            str = this.iDz.aMk();
            str2 = this.iDz.aMl();
        } else {
            str = null;
        }
        this.iDA.a(this.iDx.getPageCount(), str3, this.eQf, this.ahL, str, str2);
        if (this.iDB != null) {
            this.iDB.release();
        }
        this.iDx.onDestroy();
        com.baidu.tbadk.download.d.aWL().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.iDI);
        clA();
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

    private void bXL() {
        blF();
        initViewPager();
        clw();
        bJq();
        cls();
        this.iDB = new j(this);
        this.iDB.j(this.iDx);
        this.iDA.e(this.iDy, this.mIndex, this.mIndex);
    }

    private void cls() {
        if (com.baidu.tbadk.core.util.g.aOe()) {
            this.mStatusBarView = findViewById(R.id.statusbar_view);
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
    }

    private void blF() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        clt();
        bpC();
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
        if (d.Fx((String) v.getItem(this.iDy, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void clt() {
        this.hal = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hal.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.fOY = (ImageView) this.hal.findViewById(R.id.widget_navi_back_button);
        SvgManager.aOU().a(this.fOY, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.iDS && TbadkCoreApplication.isLogin()) {
            this.hal.setVisibility(0);
        } else {
            this.hal.setVisibility(8);
        }
    }

    private void bpC() {
        if (!this.iDP && !this.iDO) {
            this.iDw = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(R.id.see_host_image_txt);
            if (this.iDN) {
                this.iDw.setText(this.mIsSeeHost ? R.string.album_all_thread : R.string.view_host);
                this.iDw.setOnClickListener(this.iDV);
                return;
            }
            o(this.iDw, 8);
        }
    }

    public Map<String, ImageUrlData> clu() {
        return this.dTA;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long clv() {
        ImageUrlData imageUrlData;
        String str = (String) v.getItem(this.iDy, this.mIndex);
        if (this.dTA == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.dTA.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clw() {
        String str;
        if (this.iDy != null) {
            String str2 = ("" + clv()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.iDK && clv() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new an("c13316").cI("obj_source", this.mFrom));
                this.iDK = true;
            }
            if (clx()) {
                cly();
            } else {
                Fz(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean clx() {
        if (this.iDM && this.iDF != null && this.iDF.ckP()) {
            return this.iDx.getItemNum() != 1 && this.mIndex == this.iDx.getItemNum() + (-1);
        }
        return false;
    }

    private void Fz(String str) {
        this.mTitleView.setText(str);
        if (this.iDN && !this.iDO && this.iDw != null) {
            this.iDw.setText(this.mIsSeeHost ? R.string.album_all_thread : R.string.view_host);
        }
    }

    private void cly() {
        this.mTitleView.setText("");
        o(this.iDw, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.iDx == null) {
            this.iDx = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.iDx.init();
        }
        this.iDx.setIsFromCDN(this.dSr);
        this.iDx.setIsCanDrag(this.dSt);
        this.iDx.setIsBJHThread(this.iDP);
        this.iDx.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.iDx.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.iDx.setOnPageChangeListener(this.byI);
        this.iDx.setUrlData(this.iDy);
        this.iDx.setAssistUrls(this.dTA);
        this.iDx.setOuterOnTouchListener(this.dUn);
        this.iDx.setItemOnclickListener(this.mOnClickListener);
        this.iDx.setItemOnLongClickListener(this.iDY);
        this.iDx.setCurrentItem(cct(), false);
        this.iDx.setOnScrollOutListener(this.iDZ);
        this.iDF = new a(this.dSr, this.iDM, getPageContext(), this.eQf, this.ahL);
        this.iDF.setDragToExitListener(this.dUb);
        this.iDx.a(this.iDF);
        this.iDx.setOriImgSelectedCallback(this.dSk);
        this.iDx.setDragToExitListener(this.dUb);
        this.iDx.setUserId(this.mUserId);
        this.iDx.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.iDC = ImageViewerActivity.this.iDD - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.iDD = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        this.iDx.setShowBottomContainer(this.iDT);
        TiebaStatic.log(new an("c13340").cI("uid", this.mUserId).cI("post_id", this.ahL).af("obj_source", clz()));
    }

    private int clz() {
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

    private void bJq() {
        if (!this.iDO && this.iDw != null) {
            if (this.iDE == null) {
                this.iDE = new com.baidu.tieba.c.d(getPageContext(), this.iDw);
                this.iDE.cz(R.drawable.pic_sign_tip);
                this.iDE.cy(48);
                this.iDE.setUseDirectOffset(true);
                this.iDE.cA(5000);
                this.iDE.rS(-l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.iDE.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.clA();
                    }
                });
            }
            this.iDE.al(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clA() {
        if (this.iDE != null) {
            this.iDE.EE();
        }
    }

    public int cct() {
        int count = v.getCount(this.iDy);
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
        this.iDA = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.iDP = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.iDS = bundle.getBoolean("abtest");
            this.iDy = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.eQf = bundle.getString("fid");
            this.ahL = bundle.getString("tid");
            this.eQg = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.dSr = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.iDR = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.iDM = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.dSt = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.iDN = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.iDg = bundle.getString("source_rect_in_screen");
            this.iDi = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.iDT = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.iDj = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.dTA = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.dTA.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.iDQ = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.iDO = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.iDP = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.iDS = intent.getBooleanExtra("abtest", false);
                this.iDy = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.eQf = intent.getStringExtra("fid");
                this.ahL = intent.getStringExtra("tid");
                this.eQg = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.dSr = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.iDR = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.iDM = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.dSt = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.iDN = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.iDT = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.iDj = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.iDQ = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.iDO = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.iDg = intent.getStringExtra("source_rect_in_screen");
                this.iDi = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.dTA = (Map) serializableExtra;
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
        this.iDA.b(bundle, getIntent());
        this.mCount = v.getCount(this.iDy);
        if (this.iDg != null) {
            String str = (String) v.getItem(this.iDy, this.mIndex);
            if (!StringUtils.isNull(str) && this.dTA != null && (imageUrlData = this.dTA.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.iDg);
            }
        }
        this.iDh = this.iDP ? null : d.Fw((String) v.getItem(this.iDy, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new an("c13337").cI("obj_type", "2"));
        } else {
            TiebaStatic.log(new an("c13337").cI("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.iDP);
        bundle.putBoolean("abtest", this.iDS);
        bundle.putStringArrayList("url", this.iDy);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.eQf);
        bundle.putString("tid", this.ahL);
        bundle.putString("fname", this.eQg);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.iDR);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.dSt);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.iDN);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.iDM);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.iDT);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.iDj);
        if (this.dTA instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.dTA.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.dTA instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.dTA.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.iDg);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.iDQ);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.iDO);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.iDi);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        this.iDA.ar(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.iDx.setCurrentItem(this.mIndex, false);
        SvgManager.aOU().a(this.fOY, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xO(int i) {
        if (this.iDx != null) {
            this.iDx.mo(i);
            o(this.iDw, (this.iDx.aVr() || clx()) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clB() {
        if (clx()) {
            this.iDH = this.mNavigationBar.getVisibility() == 0;
            this.iDG = true;
        } else if (this.iDG) {
            this.mNavigationBar.setVisibility(this.iDH ? 0 : 8);
            this.iDG = false;
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
                return com.baidu.tbadk.m.e.aZm().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.eQf, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.ahL, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.wV(TbadkCoreApplication.getInst().getAdAdSense().dMt);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.coreExtra.view.a
    public boolean aVi() {
        return this.iDS;
    }

    public boolean clC() {
        return this.iDP;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (aq.isEmpty(this.ahL)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.ahL, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }
}
