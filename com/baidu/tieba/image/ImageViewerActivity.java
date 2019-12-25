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
/* loaded from: classes5.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> implements com.baidu.tbadk.coreExtra.view.a {
    private String OC;
    private Map<String, ImageUrlData> doL;
    private String fGQ;
    private ImageView fdH;
    private View gkR;
    private String gut;
    private int hMC;
    private boolean hMD;
    private float hMQ;
    private String hMa;
    private String hMb;
    private TextView hMq;
    private MultiImageView hMr;
    private ArrayList<String> hMs;
    private e hMt;
    private i hMu;
    private j hMv;
    private boolean hMw;
    private float hMx;
    private com.baidu.tieba.c.d hMy;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private String mPostId;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private a hMz = null;
    private boolean hMA = false;
    private boolean hMB = false;
    private int DX = 0;
    private boolean isRight = false;
    private boolean hME = false;
    private boolean hMF = false;
    private boolean hMG = true;
    private boolean dnC = true;
    private boolean hMH = true;
    private boolean mIsSeeHost = false;
    private boolean hMI = false;
    private boolean hMJ = false;
    private boolean hMK = false;
    private boolean hMc = false;
    private boolean hML = true;
    private boolean hMM = false;
    private boolean dnA = false;
    private boolean hMN = true;
    private boolean hMd = false;
    private final CustomMessageListener hMO = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null && !StringUtils.isNull(lVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(lVar);
                if (StringUtils.isNull(lVar.drj)) {
                    ba.aEa().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink});
                } else {
                    ba.aEa().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink, lVar.drj});
                }
            }
        }
    };
    private DragImageView.d dpm = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.hMq, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gkR, 8);
            if (ImageViewerActivity.this.hMr != null) {
                ImageViewerActivity.this.hMr.ge(false);
            }
            ImageViewerActivity.this.bXT();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new an("c13341").Z("obj_param1", ImageViewerActivity.this.hMr.getItemNum()).Z(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.hMr.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void aPT() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 0);
            if (!ImageViewerActivity.this.hMM || !TbadkCoreApplication.isLogin()) {
                ImageViewerActivity.this.gkR.setVisibility(8);
            } else {
                ImageViewerActivity.this.gkR.setVisibility(0);
            }
            if (ImageViewerActivity.this.hMr != null && !ImageViewerActivity.this.hMr.aJY()) {
                ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.hMq, 0);
                if (ImageViewerActivity.this.hMN) {
                    ImageViewerActivity.this.hMr.ge(true);
                } else {
                    ImageViewerActivity.this.hMr.ge(false);
                }
            }
        }
    };
    private UrlDragImageView.b dnt = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void aKq() {
            TiebaStatic.log(new an("c10351").cp("tid", ImageViewerActivity.this.OC).cp("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final View.OnClickListener hMP = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.showToast(R.string.neterror);
                return;
            }
            TiebaStatic.log(new an("pb_onlyowner_click").Z("obj_source", 2).Z("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
            TiebaStatic.log(new an("c13338").Z("obj_locate", ImageViewerActivity.this.mIsSeeHost ? 1 : 2));
            ImageViewerActivity.this.hMD = true;
            if (ImageViewerActivity.this.hMq != null) {
                ImageViewerActivity.this.hMq.setEnabled(false);
            }
            ImageViewerActivity.this.k(d.Dn((String) v.getItem(ImageViewerActivity.this.hMs, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (ImageViewerActivity.this.hMM && ImageViewerActivity.this.hMr != null) {
                boolean aJY = ImageViewerActivity.this.hMr.aJY();
                if (ImageViewerActivity.this.hMq == null) {
                    i = 0;
                } else if (!aJY) {
                    com.baidu.tieba.u.a.v(ImageViewerActivity.this.hMq, 100);
                    i = 1;
                } else {
                    com.baidu.tieba.u.a.w(ImageViewerActivity.this.hMq, 100);
                    i = 2;
                }
                ImageViewerActivity.this.hMr.l(aJY ? false : true, 100);
                TiebaStatic.log(new an("c13397").Z("obj_type", i));
                return;
            }
            TiebaStatic.log(new an("c13341").Z("obj_param1", ImageViewerActivity.this.hMr.getItemNum()).Z(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.hMr.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").cp("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean hMR = true;
    private View.OnTouchListener dpy = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.hMQ = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.hMR = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.hMQ = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.hMR = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener hMS = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.hMv != null) {
                ImageViewerActivity.this.hMv.bvv();
                ImageViewerActivity.this.hMv.show();
                ImageViewerActivity.this.hMv.cc(view);
            }
            TiebaStatic.log(new an("c13269").cp("uid", ImageViewerActivity.this.mUserId).cp("fid", ImageViewerActivity.this.fGQ).cp("tid", ImageViewerActivity.this.OC));
            return true;
        }
    };
    private BaseViewPager.a hMT = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.hMt.bXy();
            } else if (ImageViewerActivity.this.bXO() != 1) {
                ImageViewerActivity.this.hMt.bXz();
            }
        }
    };
    private ViewPager.OnPageChangeListener aUO = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.hMt != null && i > ImageViewerActivity.this.hMr.getItemNum() - 5) {
                ImageViewerActivity.this.hMt.bXy();
            }
            ImageViewerActivity.this.hMu.d(ImageViewerActivity.this.hMs, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.bXP();
            ImageViewerActivity.this.bXU();
            ImageViewerActivity.this.wV(i);
            if (ImageViewerActivity.this.hMu.bXW() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.hMu.wW(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.hMu.bXX() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.hMu.wX(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.bXQ()) {
                ImageViewerActivity.this.hMz.bXm();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.hMr.getItemNum() - 1) {
                ImageViewerActivity.this.hMF = false;
            }
            if (ImageViewerActivity.this.hMv != null) {
                ImageViewerActivity.this.hMv.bXZ();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.DX) {
                ImageViewerActivity.this.DX = i;
                ImageViewerActivity.this.isRight = true;
            } else if (i < ImageViewerActivity.this.DX) {
                ImageViewerActivity.this.DX = i;
                ImageViewerActivity.this.isRight = false;
            }
            if (ImageViewerActivity.this.hMr != null) {
                dragImageView = ImageViewerActivity.this.hMr.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.bXO() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.hMs != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.hMs.size()) {
                ImageViewerActivity.this.hMu.aG(i, (String) ImageViewerActivity.this.hMs.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.hMr.getItemNum() - 1) {
                if (!ImageViewerActivity.this.hMR || !ImageViewerActivity.this.hMw || (!ImageViewerActivity.this.hMF && !ImageViewerActivity.this.bXQ() && (ImageViewerActivity.this.hMr.getItemNum() != 1 || !ImageViewerActivity.this.isRight))) {
                    ImageViewerActivity.this.hMF = true;
                } else {
                    ImageViewerActivity.this.showToast(R.string.last_page);
                }
            }
        }
    };
    private CustomMessageListener cZf = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.doL != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.doL.values()) {
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
    private CustomMessageListener cZg = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.doL != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.doL.values()) {
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
        com.baidu.tbadk.mutiprocess.g.aNq().e(TbadkCoreApplication.getInst());
        this.hMC = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        bKl();
        k(this.hMb, this.mIsSeeHost, false);
        registerListener(this.hMO);
        registerListener(this.cZf);
        registerListener(this.cZg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.hMt = new e(this.hMs, this.doL, this.fGQ, this.gut, this.OC, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.hMt.setSourceImageRectInScreen(this.hMa);
        this.hMt.nY(this.hML);
        this.hMt.nZ(z);
        this.hMt.Dp(this.hMb);
        this.hMt.nX(this.hMc);
        this.hMt.setPostId(this.mPostId);
        this.hMt.ob(this.hMd);
        this.hMt.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.hMr != null) {
                    if (ImageViewerActivity.this.hMD) {
                        if (!z5) {
                            ImageViewerActivity.this.hMr.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.hMD = false;
                    if (ImageViewerActivity.this.hMq != null) {
                        ImageViewerActivity.this.hMq.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.hMr.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.hMr.getItemNum();
                        ImageViewerActivity.this.hMr.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.hMr.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.hMr.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.hMz != null) {
                        ImageViewerActivity.this.hMz.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.hMr.setUrlData(arrayList);
                    ImageViewerActivity.this.hMr.setAssistUrls(ImageViewerActivity.this.doL);
                    ImageViewerActivity.this.hMr.setHasNext(z3);
                    ImageViewerActivity.this.hMr.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.hMr.getItemNum()) {
                        ImageViewerActivity.this.hMr.lJ(ImageViewerActivity.this.hMr.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.hMr.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.hMr.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.hMr.setUrlData(arrayList);
                        ImageViewerActivity.this.hMr.setCurrentItem(ImageViewerActivity.this.hMr.getCurrentItem() - 200, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.bXP();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.hMr.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.hMz.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.hMz.bXi()) {
                    ImageViewerActivity.this.hMr.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.r.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.hMr.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void aF(int i, String str2) {
                ImageViewerActivity.this.hMD = false;
                if (ImageViewerActivity.this.hMq != null) {
                    ImageViewerActivity.this.hMq.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.hMs != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.hMs.size();
                    }
                    ImageViewerActivity.this.bXP();
                }
            }
        });
        this.hMt.oa(true);
        this.hMt.bXy();
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
        this.hMr.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.hMr.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.hMC = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hMr.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.OC, 0L);
        if (uniqueId != null && j > 0) {
            q.q(uniqueId.getId(), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hMr.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.OC, 0L);
        if (uniqueId != null && j > 0) {
            q.a(com.baidu.tbadk.BdToken.b.cCJ, uniqueId.getId(), j);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.hMr.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2 = null;
        MessageManager.getInstance().unRegisterListener(this.hMO);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.aMZ().releaseBlockBitmapPool();
        this.hMu.d(this.hMs, this.mIndex, this.mIndex);
        this.hMu.bXY();
        String str3 = "";
        if (this.hMz != null) {
            str3 = this.hMz.getAdId();
        }
        if (this.hMt != null) {
            str = this.hMt.aBk();
            str2 = this.hMt.aBl();
        } else {
            str = null;
        }
        this.hMu.a(this.hMr.getPageCount(), str3, this.fGQ, this.OC, str, str2);
        if (this.hMv != null) {
            this.hMv.release();
        }
        this.hMr.onDestroy();
        com.baidu.tbadk.download.d.aLy().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.hMC);
        bXT();
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

    private void bKl() {
        aZT();
        initViewPager();
        bXP();
        bwB();
        bXL();
        this.hMv = new j(this);
        this.hMv.j(this.hMr);
        this.hMu.d(this.hMs, this.mIndex, this.mIndex);
    }

    private void bXL() {
        if (com.baidu.tbadk.core.util.g.aDh()) {
            this.mStatusBarView = findViewById(R.id.statusbar_view);
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
    }

    private void aZT() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        bXM();
        bdy();
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
        if (d.Do((String) v.getItem(this.hMs, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void bXM() {
        this.gkR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gkR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.fdH = (ImageView) this.gkR.findViewById(R.id.widget_navi_back_button);
        SvgManager.aDW().a(this.fdH, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.hMM && TbadkCoreApplication.isLogin()) {
            this.gkR.setVisibility(0);
        } else {
            this.gkR.setVisibility(8);
        }
    }

    private void bdy() {
        if (!this.hMJ && !this.hMI) {
            this.hMq = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(R.id.see_host_image_txt);
            if (this.hMH) {
                this.hMq.setText(this.mIsSeeHost ? R.string.album_all_thread : R.string.view_host);
                this.hMq.setOnClickListener(this.hMP);
                return;
            }
            setViewVisibility(this.hMq, 8);
        }
    }

    public Map<String, ImageUrlData> bXN() {
        return this.doL;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long bXO() {
        ImageUrlData imageUrlData;
        String str = (String) v.getItem(this.hMs, this.mIndex);
        if (this.doL == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.doL.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXP() {
        String str;
        if (this.hMs != null) {
            String str2 = ("" + bXO()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.hME && bXO() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new an("c13316").cp("obj_source", this.mFrom));
                this.hME = true;
            }
            if (bXQ()) {
                bXR();
            } else {
                Dq(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bXQ() {
        if (this.hMG && this.hMz != null && this.hMz.bXi()) {
            return this.hMr.getItemNum() != 1 && this.mIndex == this.hMr.getItemNum() + (-1);
        }
        return false;
    }

    private void Dq(String str) {
        this.mTitleView.setText(str);
        if (this.hMH && !this.hMI && this.hMq != null) {
            this.hMq.setText(this.mIsSeeHost ? R.string.album_all_thread : R.string.view_host);
        }
    }

    private void bXR() {
        this.mTitleView.setText("");
        setViewVisibility(this.hMq, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.hMr == null) {
            this.hMr = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.hMr.init();
        }
        this.hMr.setIsFromCDN(this.dnA);
        this.hMr.setIsCanDrag(this.dnC);
        this.hMr.setIsBJHThread(this.hMJ);
        this.hMr.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.hMr.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.hMr.setOnPageChangeListener(this.aUO);
        this.hMr.setUrlData(this.hMs);
        this.hMr.setAssistUrls(this.doL);
        this.hMr.setOuterOnTouchListener(this.dpy);
        this.hMr.setItemOnclickListener(this.mOnClickListener);
        this.hMr.setItemOnLongClickListener(this.hMS);
        this.hMr.setCurrentItem(bOP(), false);
        this.hMr.setOnScrollOutListener(this.hMT);
        this.hMz = new a(this.dnA, this.hMG, getPageContext(), this.fGQ, this.OC);
        this.hMz.setDragToExitListener(this.dpm);
        this.hMr.a(this.hMz);
        this.hMr.setOriImgSelectedCallback(this.dnt);
        this.hMr.setDragToExitListener(this.dpm);
        this.hMr.setUserId(this.mUserId);
        this.hMr.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.hMw = ImageViewerActivity.this.hMx - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.hMx = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        this.hMr.setShowBottomContainer(this.hMN);
        TiebaStatic.log(new an("c13340").cp("uid", this.mUserId).cp("post_id", this.OC).Z("obj_source", bXS()));
    }

    private int bXS() {
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

    private void bwB() {
        if (!this.hMI && this.hMq != null) {
            if (this.hMy == null) {
                this.hMy = new com.baidu.tieba.c.d(getPageContext(), this.hMq);
                this.hMy.bT(R.drawable.pic_sign_tip);
                this.hMy.bS(48);
                this.hMy.setUseDirectOffset(true);
                this.hMy.bU(5000);
                this.hMy.rn(-com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.hMy.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.bXT();
                    }
                });
            }
            this.hMy.Z(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXT() {
        if (this.hMy != null) {
            this.hMy.wP();
        }
    }

    public int bOP() {
        int count = v.getCount(this.hMs);
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
        this.hMu = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.hMJ = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.hMM = bundle.getBoolean("abtest");
            this.hMs = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.fGQ = bundle.getString("fid");
            this.OC = bundle.getString("tid");
            this.gut = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.dnA = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.hML = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.hMG = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.dnC = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.hMH = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.hMa = bundle.getString("source_rect_in_screen");
            this.hMc = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.hMN = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.hMd = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.doL = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.doL.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.hMK = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.hMI = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.hMJ = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.hMM = intent.getBooleanExtra("abtest", false);
                this.hMs = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.fGQ = intent.getStringExtra("fid");
                this.OC = intent.getStringExtra("tid");
                this.gut = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.dnA = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.hML = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.hMG = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.dnC = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.hMH = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.hMN = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.hMd = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.hMK = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.hMI = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.hMa = intent.getStringExtra("source_rect_in_screen");
                this.hMc = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.doL = (Map) serializableExtra;
                }
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.mutiprocess.f.gA(isLogin);
        com.baidu.tbadk.mutiprocess.f.setBduss(bduss);
        com.baidu.tbadk.mutiprocess.f.setStoken(stoken);
        com.baidu.tbadk.mutiprocess.f.setTbs(tbs);
        this.hMu.b(bundle, getIntent());
        this.mCount = v.getCount(this.hMs);
        if (this.hMa != null) {
            String str = (String) v.getItem(this.hMs, this.mIndex);
            if (!StringUtils.isNull(str) && this.doL != null && (imageUrlData = this.doL.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.hMa);
            }
        }
        this.hMb = this.hMJ ? null : d.Dn((String) v.getItem(this.hMs, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new an("c13337").cp("obj_type", "2"));
        } else {
            TiebaStatic.log(new an("c13337").cp("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.hMJ);
        bundle.putBoolean("abtest", this.hMM);
        bundle.putStringArrayList("url", this.hMs);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.fGQ);
        bundle.putString("tid", this.OC);
        bundle.putString("fname", this.gut);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.hML);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.dnC);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.hMH);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.hMG);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.hMN);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.hMd);
        if (this.doL instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.doL.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.doL instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.doL.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.hMa);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.hMK);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.hMI);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.hMc);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        this.hMu.ar(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.hMr.setCurrentItem(this.mIndex, false);
        SvgManager.aDW().a(this.fdH, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wV(int i) {
        if (this.hMr != null) {
            this.hMr.lI(i);
            setViewVisibility(this.hMq, (this.hMr.aJY() || bXQ()) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXU() {
        if (bXQ()) {
            this.hMB = this.mNavigationBar.getVisibility() == 0;
            this.hMA = true;
        } else if (this.hMA) {
            this.mNavigationBar.setVisibility(this.hMB ? 0 : 8);
            this.hMA = false;
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
                return com.baidu.tbadk.m.e.aOm().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.fGQ, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.OC, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.vf(TbadkCoreApplication.getInst().getAdAdSense().dhF);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.coreExtra.view.a
    public boolean aJP() {
        return this.hMM;
    }

    public boolean bXV() {
        return this.hMJ;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (aq.isEmpty(this.OC)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.OC, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }
}
