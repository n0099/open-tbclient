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
/* loaded from: classes6.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> implements com.baidu.tbadk.coreExtra.view.a {
    private String OG;
    private Map<String, ImageUrlData> doW;
    private String fKa;
    private ImageView fgN;
    private View goa;
    private String gxD;
    private String hPD;
    private String hPE;
    private TextView hPT;
    private MultiImageView hPU;
    private ArrayList<String> hPV;
    private e hPW;
    private i hPX;
    private j hPY;
    private boolean hPZ;
    private float hQa;
    private com.baidu.tieba.c.d hQb;
    private int hQf;
    private boolean hQg;
    private float hQt;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private String mPostId;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private a hQc = null;
    private boolean hQd = false;
    private boolean hQe = false;
    private int Ec = 0;
    private boolean isRight = false;
    private boolean hQh = false;
    private boolean hQi = false;
    private boolean hQj = true;
    private boolean dnN = true;
    private boolean hQk = true;
    private boolean mIsSeeHost = false;
    private boolean hQl = false;
    private boolean hQm = false;
    private boolean hQn = false;
    private boolean hPF = false;
    private boolean hQo = true;
    private boolean hQp = false;
    private boolean dnL = false;
    private boolean hQq = true;
    private boolean hPG = false;
    private final CustomMessageListener hQr = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null && !StringUtils.isNull(lVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(lVar);
                if (StringUtils.isNull(lVar.drv)) {
                    ba.aEt().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink});
                } else {
                    ba.aEt().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink, lVar.drv});
                }
            }
        }
    };
    private DragImageView.d dpx = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.hPT, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.goa, 8);
            if (ImageViewerActivity.this.hPU != null) {
                ImageViewerActivity.this.hPU.gj(false);
            }
            ImageViewerActivity.this.bZc();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new an("c13341").Z("obj_param1", ImageViewerActivity.this.hPU.getItemNum()).Z(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.hPU.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void aQm() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 0);
            if (!ImageViewerActivity.this.hQp || !TbadkCoreApplication.isLogin()) {
                ImageViewerActivity.this.goa.setVisibility(8);
            } else {
                ImageViewerActivity.this.goa.setVisibility(0);
            }
            if (ImageViewerActivity.this.hPU != null && !ImageViewerActivity.this.hPU.aKr()) {
                ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.hPT, 0);
                if (ImageViewerActivity.this.hQq) {
                    ImageViewerActivity.this.hPU.gj(true);
                } else {
                    ImageViewerActivity.this.hPU.gj(false);
                }
            }
        }
    };
    private UrlDragImageView.b dnE = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void aKJ() {
            TiebaStatic.log(new an("c10351").cp("tid", ImageViewerActivity.this.OG).cp("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final View.OnClickListener hQs = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.showToast(R.string.neterror);
                return;
            }
            TiebaStatic.log(new an("pb_onlyowner_click").Z("obj_source", 2).Z("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
            TiebaStatic.log(new an("c13338").Z("obj_locate", ImageViewerActivity.this.mIsSeeHost ? 1 : 2));
            ImageViewerActivity.this.hQg = true;
            if (ImageViewerActivity.this.hPT != null) {
                ImageViewerActivity.this.hPT.setEnabled(false);
            }
            ImageViewerActivity.this.k(d.Dx((String) v.getItem(ImageViewerActivity.this.hPV, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (ImageViewerActivity.this.hQp && ImageViewerActivity.this.hPU != null) {
                boolean aKr = ImageViewerActivity.this.hPU.aKr();
                if (ImageViewerActivity.this.hPT == null) {
                    i = 0;
                } else if (!aKr) {
                    com.baidu.tieba.u.a.v(ImageViewerActivity.this.hPT, 100);
                    i = 1;
                } else {
                    com.baidu.tieba.u.a.w(ImageViewerActivity.this.hPT, 100);
                    i = 2;
                }
                ImageViewerActivity.this.hPU.m(aKr ? false : true, 100);
                TiebaStatic.log(new an("c13397").Z("obj_type", i));
                return;
            }
            TiebaStatic.log(new an("c13341").Z("obj_param1", ImageViewerActivity.this.hPU.getItemNum()).Z(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.hPU.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").cp("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean hQu = true;
    private View.OnTouchListener dpJ = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.hQt = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.hQu = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.hQt = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.hQu = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener hQv = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.hPY != null) {
                ImageViewerActivity.this.hPY.bwx();
                ImageViewerActivity.this.hPY.show();
                ImageViewerActivity.this.hPY.ch(view);
            }
            TiebaStatic.log(new an("c13269").cp("uid", ImageViewerActivity.this.mUserId).cp("fid", ImageViewerActivity.this.fKa).cp("tid", ImageViewerActivity.this.OG));
            return true;
        }
    };
    private BaseViewPager.a hQw = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.hPW.bYH();
            } else if (ImageViewerActivity.this.bYX() != 1) {
                ImageViewerActivity.this.hPW.bYI();
            }
        }
    };
    private ViewPager.OnPageChangeListener aVG = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.hPW != null && i > ImageViewerActivity.this.hPU.getItemNum() - 5) {
                ImageViewerActivity.this.hPW.bYH();
            }
            ImageViewerActivity.this.hPX.d(ImageViewerActivity.this.hPV, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.bYY();
            ImageViewerActivity.this.bZd();
            ImageViewerActivity.this.xa(i);
            if (ImageViewerActivity.this.hPX.bZf() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.hPX.xb(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.hPX.bZg() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.hPX.xc(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.bYZ()) {
                ImageViewerActivity.this.hQc.bYv();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.hPU.getItemNum() - 1) {
                ImageViewerActivity.this.hQi = false;
            }
            if (ImageViewerActivity.this.hPY != null) {
                ImageViewerActivity.this.hPY.bZi();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.Ec) {
                ImageViewerActivity.this.Ec = i;
                ImageViewerActivity.this.isRight = true;
            } else if (i < ImageViewerActivity.this.Ec) {
                ImageViewerActivity.this.Ec = i;
                ImageViewerActivity.this.isRight = false;
            }
            if (ImageViewerActivity.this.hPU != null) {
                dragImageView = ImageViewerActivity.this.hPU.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.bYX() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.hPV != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.hPV.size()) {
                ImageViewerActivity.this.hPX.aM(i, (String) ImageViewerActivity.this.hPV.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.hPU.getItemNum() - 1) {
                if (!ImageViewerActivity.this.hQu || !ImageViewerActivity.this.hPZ || (!ImageViewerActivity.this.hQi && !ImageViewerActivity.this.bYZ() && (ImageViewerActivity.this.hPU.getItemNum() != 1 || !ImageViewerActivity.this.isRight))) {
                    ImageViewerActivity.this.hQi = true;
                } else {
                    ImageViewerActivity.this.showToast(R.string.last_page);
                }
            }
        }
    };
    private CustomMessageListener cZp = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.doW != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.doW.values()) {
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
    private CustomMessageListener cZq = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.doW != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.doW.values()) {
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
        com.baidu.tbadk.mutiprocess.g.aNJ().init(TbadkCoreApplication.getInst());
        this.hQf = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        bLq();
        k(this.hPE, this.mIsSeeHost, false);
        registerListener(this.hQr);
        registerListener(this.cZp);
        registerListener(this.cZq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.hPW = new e(this.hPV, this.doW, this.fKa, this.gxD, this.OG, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.hPW.setSourceImageRectInScreen(this.hPD);
        this.hPW.ok(this.hQo);
        this.hPW.ol(z);
        this.hPW.Dz(this.hPE);
        this.hPW.oj(this.hPF);
        this.hPW.setPostId(this.mPostId);
        this.hPW.on(this.hPG);
        this.hPW.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.hPU != null) {
                    if (ImageViewerActivity.this.hQg) {
                        if (!z5) {
                            ImageViewerActivity.this.hPU.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.hQg = false;
                    if (ImageViewerActivity.this.hPT != null) {
                        ImageViewerActivity.this.hPT.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.hPU.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.hPU.getItemNum();
                        ImageViewerActivity.this.hPU.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.hPU.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.hPU.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.hQc != null) {
                        ImageViewerActivity.this.hQc.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.hPU.setUrlData(arrayList);
                    ImageViewerActivity.this.hPU.setAssistUrls(ImageViewerActivity.this.doW);
                    ImageViewerActivity.this.hPU.setHasNext(z3);
                    ImageViewerActivity.this.hPU.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.hPU.getItemNum()) {
                        ImageViewerActivity.this.hPU.lJ(ImageViewerActivity.this.hPU.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.hPU.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.hPU.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.hPU.setUrlData(arrayList);
                        ImageViewerActivity.this.hPU.setCurrentItem(ImageViewerActivity.this.hPU.getCurrentItem() - 200, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.bYY();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.hPU.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.hQc.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.hQc.bYr()) {
                    ImageViewerActivity.this.hPU.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.r.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.hPU.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void aL(int i, String str2) {
                ImageViewerActivity.this.hQg = false;
                if (ImageViewerActivity.this.hPT != null) {
                    ImageViewerActivity.this.hPT.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.hPV != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.hPV.size();
                    }
                    ImageViewerActivity.this.bYY();
                }
            }
        });
        this.hPW.om(true);
        this.hPW.bYH();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        if (!k.isFastDoubleClick()) {
            TiebaStatic.log(new an("c13377").cp("obj_type", "4"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hPU.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.hPU.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.hQf = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hPU.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.OG, 0L);
        if (uniqueId != null && j > 0) {
            q.q(uniqueId.getId(), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hPU.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.OG, 0L);
        if (uniqueId != null && j > 0) {
            q.a(com.baidu.tbadk.BdToken.b.cCU, uniqueId.getId(), j);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.hPU.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2 = null;
        MessageManager.getInstance().unRegisterListener(this.hQr);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.aNs().releaseBlockBitmapPool();
        this.hPX.d(this.hPV, this.mIndex, this.mIndex);
        this.hPX.bZh();
        String str3 = "";
        if (this.hQc != null) {
            str3 = this.hQc.getAdId();
        }
        if (this.hPW != null) {
            str = this.hPW.aBD();
            str2 = this.hPW.aBE();
        } else {
            str = null;
        }
        this.hPX.a(this.hPU.getPageCount(), str3, this.fKa, this.OG, str, str2);
        if (this.hPY != null) {
            this.hPY.release();
        }
        this.hPU.onDestroy();
        com.baidu.tbadk.download.d.aLR().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.hQf);
        bZc();
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

    private void bLq() {
        bas();
        initViewPager();
        bYY();
        bxD();
        bYU();
        this.hPY = new j(this);
        this.hPY.j(this.hPU);
        this.hPX.d(this.hPV, this.mIndex, this.mIndex);
    }

    private void bYU() {
        if (com.baidu.tbadk.core.util.g.aDA()) {
            this.mStatusBarView = findViewById(R.id.statusbar_view);
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
    }

    private void bas() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        bYV();
        bdT();
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
        if (d.Dy((String) v.getItem(this.hPV, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void bYV() {
        this.goa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.goa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.fgN = (ImageView) this.goa.findViewById(R.id.widget_navi_back_button);
        SvgManager.aEp().a(this.fgN, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.hQp && TbadkCoreApplication.isLogin()) {
            this.goa.setVisibility(0);
        } else {
            this.goa.setVisibility(8);
        }
    }

    private void bdT() {
        if (!this.hQm && !this.hQl) {
            this.hPT = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(R.id.see_host_image_txt);
            if (this.hQk) {
                this.hPT.setText(this.mIsSeeHost ? R.string.album_all_thread : R.string.view_host);
                this.hPT.setOnClickListener(this.hQs);
                return;
            }
            setViewVisibility(this.hPT, 8);
        }
    }

    public Map<String, ImageUrlData> bYW() {
        return this.doW;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long bYX() {
        ImageUrlData imageUrlData;
        String str = (String) v.getItem(this.hPV, this.mIndex);
        if (this.doW == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.doW.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYY() {
        String str;
        if (this.hPV != null) {
            String str2 = ("" + bYX()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.hQh && bYX() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new an("c13316").cp("obj_source", this.mFrom));
                this.hQh = true;
            }
            if (bYZ()) {
                bZa();
            } else {
                DA(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bYZ() {
        if (this.hQj && this.hQc != null && this.hQc.bYr()) {
            return this.hPU.getItemNum() != 1 && this.mIndex == this.hPU.getItemNum() + (-1);
        }
        return false;
    }

    private void DA(String str) {
        this.mTitleView.setText(str);
        if (this.hQk && !this.hQl && this.hPT != null) {
            this.hPT.setText(this.mIsSeeHost ? R.string.album_all_thread : R.string.view_host);
        }
    }

    private void bZa() {
        this.mTitleView.setText("");
        setViewVisibility(this.hPT, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.hPU == null) {
            this.hPU = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.hPU.init();
        }
        this.hPU.setIsFromCDN(this.dnL);
        this.hPU.setIsCanDrag(this.dnN);
        this.hPU.setIsBJHThread(this.hQm);
        this.hPU.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.hPU.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.hPU.setOnPageChangeListener(this.aVG);
        this.hPU.setUrlData(this.hPV);
        this.hPU.setAssistUrls(this.doW);
        this.hPU.setOuterOnTouchListener(this.dpJ);
        this.hPU.setItemOnclickListener(this.mOnClickListener);
        this.hPU.setItemOnLongClickListener(this.hQv);
        this.hPU.setCurrentItem(bPY(), false);
        this.hPU.setOnScrollOutListener(this.hQw);
        this.hQc = new a(this.dnL, this.hQj, getPageContext(), this.fKa, this.OG);
        this.hQc.setDragToExitListener(this.dpx);
        this.hPU.a(this.hQc);
        this.hPU.setOriImgSelectedCallback(this.dnE);
        this.hPU.setDragToExitListener(this.dpx);
        this.hPU.setUserId(this.mUserId);
        this.hPU.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.hPZ = ImageViewerActivity.this.hQa - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.hQa = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        this.hPU.setShowBottomContainer(this.hQq);
        TiebaStatic.log(new an("c13340").cp("uid", this.mUserId).cp("post_id", this.OG).Z("obj_source", bZb()));
    }

    private int bZb() {
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

    private void bxD() {
        if (!this.hQl && this.hPT != null) {
            if (this.hQb == null) {
                this.hQb = new com.baidu.tieba.c.d(getPageContext(), this.hPT);
                this.hQb.bU(R.drawable.pic_sign_tip);
                this.hQb.bT(48);
                this.hQb.setUseDirectOffset(true);
                this.hQb.bV(5000);
                this.hQb.rs(-com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.hQb.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.bZc();
                    }
                });
            }
            this.hQb.Y(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZc() {
        if (this.hQb != null) {
            this.hQb.xg();
        }
    }

    public int bPY() {
        int count = v.getCount(this.hPV);
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
        this.hPX = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.hQm = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.hQp = bundle.getBoolean("abtest");
            this.hPV = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.fKa = bundle.getString("fid");
            this.OG = bundle.getString("tid");
            this.gxD = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.dnL = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.hQo = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.hQj = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.dnN = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.hQk = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.hPD = bundle.getString("source_rect_in_screen");
            this.hPF = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.hQq = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.hPG = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.doW = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.doW.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.hQn = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.hQl = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.hQm = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.hQp = intent.getBooleanExtra("abtest", false);
                this.hPV = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.fKa = intent.getStringExtra("fid");
                this.OG = intent.getStringExtra("tid");
                this.gxD = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.dnL = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.hQo = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.hQj = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.dnN = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.hQk = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.hQq = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.hPG = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.hQn = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.hQl = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.hPD = intent.getStringExtra("source_rect_in_screen");
                this.hPF = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.doW = (Map) serializableExtra;
                }
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.mutiprocess.f.gF(isLogin);
        com.baidu.tbadk.mutiprocess.f.setBduss(bduss);
        com.baidu.tbadk.mutiprocess.f.setStoken(stoken);
        com.baidu.tbadk.mutiprocess.f.setTbs(tbs);
        this.hPX.b(bundle, getIntent());
        this.mCount = v.getCount(this.hPV);
        if (this.hPD != null) {
            String str = (String) v.getItem(this.hPV, this.mIndex);
            if (!StringUtils.isNull(str) && this.doW != null && (imageUrlData = this.doW.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.hPD);
            }
        }
        this.hPE = this.hQm ? null : d.Dx((String) v.getItem(this.hPV, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new an("c13337").cp("obj_type", "2"));
        } else {
            TiebaStatic.log(new an("c13337").cp("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.hQm);
        bundle.putBoolean("abtest", this.hQp);
        bundle.putStringArrayList("url", this.hPV);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.fKa);
        bundle.putString("tid", this.OG);
        bundle.putString("fname", this.gxD);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.hQo);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.dnN);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.hQk);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.hQj);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.hQq);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.hPG);
        if (this.doW instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.doW.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.doW instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.doW.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.hPD);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.hQn);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.hQl);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.hPF);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        this.hPX.ar(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.hPU.setCurrentItem(this.mIndex, false);
        SvgManager.aEp().a(this.fgN, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xa(int i) {
        if (this.hPU != null) {
            this.hPU.lI(i);
            setViewVisibility(this.hPT, (this.hPU.aKr() || bYZ()) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZd() {
        if (bYZ()) {
            this.hQe = this.mNavigationBar.getVisibility() == 0;
            this.hQd = true;
        } else if (this.hQd) {
            this.mNavigationBar.setVisibility(this.hQe ? 0 : 8);
            this.hQd = false;
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
                return com.baidu.tbadk.m.e.aOF().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.fKa, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.OG, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.vk(TbadkCoreApplication.getInst().getAdAdSense().dhR);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.coreExtra.view.a
    public boolean aKi() {
        return this.hQp;
    }

    public boolean bZe() {
        return this.hQm;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (aq.isEmpty(this.OG)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.OG, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }
}
