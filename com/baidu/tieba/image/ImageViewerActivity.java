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
import com.baidu.tbadk.data.l;
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
    private String Pj;
    private Map<String, ImageUrlData> dtf;
    private String emb;
    private String emc;
    private ImageView fjU;
    private View gqd;
    private String hRD;
    private String hRE;
    private TextView hRT;
    private MultiImageView hRU;
    private ArrayList<String> hRV;
    private e hRW;
    private i hRX;
    private j hRY;
    private boolean hRZ;
    private float hSa;
    private com.baidu.tieba.c.d hSb;
    private int hSf;
    private boolean hSg;
    private float hSt;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private String mPostId;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private a hSc = null;
    private boolean hSd = false;
    private boolean hSe = false;
    private int Ev = 0;
    private boolean isRight = false;
    private boolean hSh = false;
    private boolean hSi = false;
    private boolean hSj = true;
    private boolean drX = true;
    private boolean hSk = true;
    private boolean mIsSeeHost = false;
    private boolean hSl = false;
    private boolean hSm = false;
    private boolean hSn = false;
    private boolean hRF = false;
    private boolean hSo = true;
    private boolean hSp = false;
    private boolean drV = false;
    private boolean hSq = true;
    private boolean hRG = false;
    private final CustomMessageListener hSr = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null && !StringUtils.isNull(lVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(lVar);
                if (StringUtils.isNull(lVar.dvD)) {
                    ba.aGG().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink});
                } else {
                    ba.aGG().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink, lVar.dvD});
                }
            }
        }
    };
    private DragImageView.d dtG = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.hRT, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gqd, 8);
            if (ImageViewerActivity.this.hRU != null) {
                ImageViewerActivity.this.hRU.gq(false);
            }
            ImageViewerActivity.this.caF();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new an("c13341").X("obj_param1", ImageViewerActivity.this.hRU.getItemNum()).X(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.hRU.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void aSF() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 0);
            if (!ImageViewerActivity.this.hSp || !TbadkCoreApplication.isLogin()) {
                ImageViewerActivity.this.gqd.setVisibility(8);
            } else {
                ImageViewerActivity.this.gqd.setVisibility(0);
            }
            if (ImageViewerActivity.this.hRU != null && !ImageViewerActivity.this.hRU.aMP()) {
                ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.hRT, 0);
                if (ImageViewerActivity.this.hSq) {
                    ImageViewerActivity.this.hRU.gq(true);
                } else {
                    ImageViewerActivity.this.hRU.gq(false);
                }
            }
        }
    };
    private UrlDragImageView.b drO = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void aNh() {
            TiebaStatic.log(new an("c10351").cy("tid", ImageViewerActivity.this.Pj).cy("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final View.OnClickListener hSs = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.showToast(R.string.neterror);
                return;
            }
            TiebaStatic.log(new an("pb_onlyowner_click").X("obj_source", 2).X("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
            TiebaStatic.log(new an("c13338").X("obj_locate", ImageViewerActivity.this.mIsSeeHost ? 1 : 2));
            ImageViewerActivity.this.hSg = true;
            if (ImageViewerActivity.this.hRT != null) {
                ImageViewerActivity.this.hRT.setEnabled(false);
            }
            ImageViewerActivity.this.k(d.DN((String) v.getItem(ImageViewerActivity.this.hRV, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (ImageViewerActivity.this.hSp && ImageViewerActivity.this.hRU != null) {
                boolean aMP = ImageViewerActivity.this.hRU.aMP();
                if (ImageViewerActivity.this.hRT == null) {
                    i = 0;
                } else if (!aMP) {
                    com.baidu.tieba.v.a.v(ImageViewerActivity.this.hRT, 100);
                    i = 1;
                } else {
                    com.baidu.tieba.v.a.w(ImageViewerActivity.this.hRT, 100);
                    i = 2;
                }
                ImageViewerActivity.this.hRU.n(aMP ? false : true, 100);
                TiebaStatic.log(new an("c13397").X("obj_type", i));
                return;
            }
            TiebaStatic.log(new an("c13341").X("obj_param1", ImageViewerActivity.this.hRU.getItemNum()).X(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.hRU.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").cy("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean hSu = true;
    private View.OnTouchListener dtS = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.hSt = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.hSu = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.hSt = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.hSu = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener hSv = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.hRY != null) {
                ImageViewerActivity.this.hRY.byd();
                ImageViewerActivity.this.hRY.show();
                ImageViewerActivity.this.hRY.ch(view);
            }
            TiebaStatic.log(new an("c13269").cy("uid", ImageViewerActivity.this.mUserId).cy("fid", ImageViewerActivity.this.emb).cy("tid", ImageViewerActivity.this.Pj));
            return true;
        }
    };
    private BaseViewPager.a hSw = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.hRW.cak();
            } else if (ImageViewerActivity.this.caA() != 1) {
                ImageViewerActivity.this.hRW.cal();
            }
        }
    };
    private ViewPager.OnPageChangeListener aZT = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.hRW != null && i > ImageViewerActivity.this.hRU.getItemNum() - 5) {
                ImageViewerActivity.this.hRW.cak();
            }
            ImageViewerActivity.this.hRX.d(ImageViewerActivity.this.hRV, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.caB();
            ImageViewerActivity.this.caG();
            ImageViewerActivity.this.xg(i);
            if (ImageViewerActivity.this.hRX.caI() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.hRX.xh(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.hRX.caJ() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.hRX.xi(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.caC()) {
                ImageViewerActivity.this.hSc.bZY();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.hRU.getItemNum() - 1) {
                ImageViewerActivity.this.hSi = false;
            }
            if (ImageViewerActivity.this.hRY != null) {
                ImageViewerActivity.this.hRY.caL();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.Ev) {
                ImageViewerActivity.this.Ev = i;
                ImageViewerActivity.this.isRight = true;
            } else if (i < ImageViewerActivity.this.Ev) {
                ImageViewerActivity.this.Ev = i;
                ImageViewerActivity.this.isRight = false;
            }
            if (ImageViewerActivity.this.hRU != null) {
                dragImageView = ImageViewerActivity.this.hRU.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.caA() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.hRV != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.hRV.size()) {
                ImageViewerActivity.this.hRX.aM(i, (String) ImageViewerActivity.this.hRV.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.hRU.getItemNum() - 1) {
                if (!ImageViewerActivity.this.hSu || !ImageViewerActivity.this.hRZ || (!ImageViewerActivity.this.hSi && !ImageViewerActivity.this.caC() && (ImageViewerActivity.this.hRU.getItemNum() != 1 || !ImageViewerActivity.this.isRight))) {
                    ImageViewerActivity.this.hSi = true;
                } else {
                    ImageViewerActivity.this.showToast(R.string.last_page);
                }
            }
        }
    };
    private CustomMessageListener ddv = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.dtf != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.dtf.values()) {
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
    private CustomMessageListener ddw = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.dtf != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.dtf.values()) {
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
        com.baidu.tbadk.mutiprocess.g.aQf().init(TbadkCoreApplication.getInst());
        this.hSf = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        bMV();
        k(this.hRE, this.mIsSeeHost, false);
        registerListener(this.hSr);
        registerListener(this.ddv);
        registerListener(this.ddw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.hRW = new e(this.hRV, this.dtf, this.emb, this.emc, this.Pj, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.hRW.setSourceImageRectInScreen(this.hRD);
        this.hRW.om(this.hSo);
        this.hRW.on(z);
        this.hRW.DP(this.hRE);
        this.hRW.ol(this.hRF);
        this.hRW.setPostId(this.mPostId);
        this.hRW.op(this.hRG);
        this.hRW.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.hRU != null) {
                    if (ImageViewerActivity.this.hSg) {
                        if (!z5) {
                            ImageViewerActivity.this.hRU.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.hSg = false;
                    if (ImageViewerActivity.this.hRT != null) {
                        ImageViewerActivity.this.hRT.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.hRU.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.hRU.getItemNum();
                        ImageViewerActivity.this.hRU.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.hRU.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.hRU.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.hSc != null) {
                        ImageViewerActivity.this.hSc.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.hRU.setUrlData(arrayList);
                    ImageViewerActivity.this.hRU.setAssistUrls(ImageViewerActivity.this.dtf);
                    ImageViewerActivity.this.hRU.setHasNext(z3);
                    ImageViewerActivity.this.hRU.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.hRU.getItemNum()) {
                        ImageViewerActivity.this.hRU.mb(ImageViewerActivity.this.hRU.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.hRU.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.hRU.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.hRU.setUrlData(arrayList);
                        ImageViewerActivity.this.hRU.setCurrentItem(ImageViewerActivity.this.hRU.getCurrentItem() - 200, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.caB();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.hRU.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.hSc.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.hSc.bZU()) {
                    ImageViewerActivity.this.hRU.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.hRU.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void aL(int i, String str2) {
                ImageViewerActivity.this.hSg = false;
                if (ImageViewerActivity.this.hRT != null) {
                    ImageViewerActivity.this.hRT.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.hRV != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.hRV.size();
                    }
                    ImageViewerActivity.this.caB();
                }
            }
        });
        this.hRW.oo(true);
        this.hRW.cak();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        if (!k.isFastDoubleClick()) {
            TiebaStatic.log(new an("c13377").cy("obj_type", "4"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hRU.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.hRU.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.hSf = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hRU.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.Pj, 0L);
        if (uniqueId != null && j > 0) {
            q.q(uniqueId.getId(), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hRU.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.Pj, 0L);
        if (uniqueId != null && j > 0) {
            q.a(com.baidu.tbadk.BdToken.b.cGT, uniqueId.getId(), j);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.hRU.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2 = null;
        MessageManager.getInstance().unRegisterListener(this.hSr);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.aPQ().releaseBlockBitmapPool();
        this.hRX.d(this.hRV, this.mIndex, this.mIndex);
        this.hRX.caK();
        String str3 = "";
        if (this.hSc != null) {
            str3 = this.hSc.getAdId();
        }
        if (this.hRW != null) {
            str = this.hRW.aDS();
            str2 = this.hRW.aDT();
        } else {
            str = null;
        }
        this.hRX.a(this.hRU.getPageCount(), str3, this.emb, this.Pj, str, str2);
        if (this.hRY != null) {
            this.hRY.release();
        }
        this.hRU.onDestroy();
        com.baidu.tbadk.download.d.aOp().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.hSf);
        caF();
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

    private void bMV() {
        bcJ();
        initViewPager();
        caB();
        bzh();
        cax();
        this.hRY = new j(this);
        this.hRY.j(this.hRU);
        this.hRX.d(this.hRV, this.mIndex, this.mIndex);
    }

    private void cax() {
        if (com.baidu.tbadk.core.util.g.aFM()) {
            this.mStatusBarView = findViewById(R.id.statusbar_view);
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
    }

    private void bcJ() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        cay();
        bgf();
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
        if (d.DO((String) v.getItem(this.hRV, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void cay() {
        this.gqd = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gqd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.fjU = (ImageView) this.gqd.findViewById(R.id.widget_navi_back_button);
        SvgManager.aGC().a(this.fjU, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.hSp && TbadkCoreApplication.isLogin()) {
            this.gqd.setVisibility(0);
        } else {
            this.gqd.setVisibility(8);
        }
    }

    private void bgf() {
        if (!this.hSm && !this.hSl) {
            this.hRT = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(R.id.see_host_image_txt);
            if (this.hSk) {
                this.hRT.setText(this.mIsSeeHost ? R.string.album_all_thread : R.string.view_host);
                this.hRT.setOnClickListener(this.hSs);
                return;
            }
            setViewVisibility(this.hRT, 8);
        }
    }

    public Map<String, ImageUrlData> caz() {
        return this.dtf;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long caA() {
        ImageUrlData imageUrlData;
        String str = (String) v.getItem(this.hRV, this.mIndex);
        if (this.dtf == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.dtf.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caB() {
        String str;
        if (this.hRV != null) {
            String str2 = ("" + caA()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.hSh && caA() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new an("c13316").cy("obj_source", this.mFrom));
                this.hSh = true;
            }
            if (caC()) {
                caD();
            } else {
                DQ(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean caC() {
        if (this.hSj && this.hSc != null && this.hSc.bZU()) {
            return this.hRU.getItemNum() != 1 && this.mIndex == this.hRU.getItemNum() + (-1);
        }
        return false;
    }

    private void DQ(String str) {
        this.mTitleView.setText(str);
        if (this.hSk && !this.hSl && this.hRT != null) {
            this.hRT.setText(this.mIsSeeHost ? R.string.album_all_thread : R.string.view_host);
        }
    }

    private void caD() {
        this.mTitleView.setText("");
        setViewVisibility(this.hRT, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.hRU == null) {
            this.hRU = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.hRU.init();
        }
        this.hRU.setIsFromCDN(this.drV);
        this.hRU.setIsCanDrag(this.drX);
        this.hRU.setIsBJHThread(this.hSm);
        this.hRU.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.hRU.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.hRU.setOnPageChangeListener(this.aZT);
        this.hRU.setUrlData(this.hRV);
        this.hRU.setAssistUrls(this.dtf);
        this.hRU.setOuterOnTouchListener(this.dtS);
        this.hRU.setItemOnclickListener(this.mOnClickListener);
        this.hRU.setItemOnLongClickListener(this.hSv);
        this.hRU.setCurrentItem(bRB(), false);
        this.hRU.setOnScrollOutListener(this.hSw);
        this.hSc = new a(this.drV, this.hSj, getPageContext(), this.emb, this.Pj);
        this.hSc.setDragToExitListener(this.dtG);
        this.hRU.a(this.hSc);
        this.hRU.setOriImgSelectedCallback(this.drO);
        this.hRU.setDragToExitListener(this.dtG);
        this.hRU.setUserId(this.mUserId);
        this.hRU.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.hRZ = ImageViewerActivity.this.hSa - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.hSa = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        this.hRU.setShowBottomContainer(this.hSq);
        TiebaStatic.log(new an("c13340").cy("uid", this.mUserId).cy("post_id", this.Pj).X("obj_source", caE()));
    }

    private int caE() {
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

    private void bzh() {
        if (!this.hSl && this.hRT != null) {
            if (this.hSb == null) {
                this.hSb = new com.baidu.tieba.c.d(getPageContext(), this.hRT);
                this.hSb.ck(R.drawable.pic_sign_tip);
                this.hSb.cj(48);
                this.hSb.setUseDirectOffset(true);
                this.hSb.cl(5000);
                this.hSb.rz(-com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.hSb.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.caF();
                    }
                });
            }
            this.hSb.aj(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caF() {
        if (this.hSb != null) {
            this.hSb.zz();
        }
    }

    public int bRB() {
        int count = v.getCount(this.hRV);
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
        this.hRX = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.hSm = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.hSp = bundle.getBoolean("abtest");
            this.hRV = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.emb = bundle.getString("fid");
            this.Pj = bundle.getString("tid");
            this.emc = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.drV = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.hSo = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.hSj = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.drX = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.hSk = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.hRD = bundle.getString("source_rect_in_screen");
            this.hRF = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.hSq = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.hRG = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.dtf = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.dtf.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.hSn = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.hSl = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.hSm = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.hSp = intent.getBooleanExtra("abtest", false);
                this.hRV = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.emb = intent.getStringExtra("fid");
                this.Pj = intent.getStringExtra("tid");
                this.emc = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.drV = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.hSo = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.hSj = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.drX = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.hSk = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.hSq = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.hRG = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.hSn = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.hSl = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.hRD = intent.getStringExtra("source_rect_in_screen");
                this.hRF = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.dtf = (Map) serializableExtra;
                }
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.mutiprocess.f.gM(isLogin);
        com.baidu.tbadk.mutiprocess.f.setBduss(bduss);
        com.baidu.tbadk.mutiprocess.f.setStoken(stoken);
        com.baidu.tbadk.mutiprocess.f.setTbs(tbs);
        this.hRX.b(bundle, getIntent());
        this.mCount = v.getCount(this.hRV);
        if (this.hRD != null) {
            String str = (String) v.getItem(this.hRV, this.mIndex);
            if (!StringUtils.isNull(str) && this.dtf != null && (imageUrlData = this.dtf.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.hRD);
            }
        }
        this.hRE = this.hSm ? null : d.DN((String) v.getItem(this.hRV, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new an("c13337").cy("obj_type", "2"));
        } else {
            TiebaStatic.log(new an("c13337").cy("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.hSm);
        bundle.putBoolean("abtest", this.hSp);
        bundle.putStringArrayList("url", this.hRV);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.emb);
        bundle.putString("tid", this.Pj);
        bundle.putString("fname", this.emc);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.hSo);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.drX);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.hSk);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.hSj);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.hSq);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.hRG);
        if (this.dtf instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.dtf.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.dtf instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.dtf.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.hRD);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.hSn);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.hSl);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.hRF);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        this.hRX.ar(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.hRU.setCurrentItem(this.mIndex, false);
        SvgManager.aGC().a(this.fjU, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xg(int i) {
        if (this.hRU != null) {
            this.hRU.ma(i);
            setViewVisibility(this.hRT, (this.hRU.aMP() || caC()) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caG() {
        if (caC()) {
            this.hSe = this.mNavigationBar.getVisibility() == 0;
            this.hSd = true;
        } else if (this.hSd) {
            this.mNavigationBar.setVisibility(this.hSe ? 0 : 8);
            this.hSd = false;
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
                return com.baidu.tbadk.m.e.aQX().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.emb, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.Pj, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.vE(TbadkCoreApplication.getInst().getAdAdSense().dlY);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.coreExtra.view.a
    public boolean aMG() {
        return this.hSp;
    }

    public boolean caH() {
        return this.hSm;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (aq.isEmpty(this.Pj)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.Pj, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }
}
