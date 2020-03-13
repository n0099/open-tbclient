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
    private Map<String, ImageUrlData> dts;
    private String emo;
    private String emp;
    private ImageView fkh;
    private View gqq;
    private String hRP;
    private String hRQ;
    private float hSF;
    private TextView hSf;
    private MultiImageView hSg;
    private ArrayList<String> hSh;
    private e hSi;
    private i hSj;
    private j hSk;
    private boolean hSl;
    private float hSm;
    private com.baidu.tieba.c.d hSn;
    private int hSr;
    private boolean hSs;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private String mPostId;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private a hSo = null;
    private boolean hSp = false;
    private boolean hSq = false;
    private int Ev = 0;
    private boolean isRight = false;
    private boolean hSt = false;
    private boolean hSu = false;
    private boolean hSv = true;
    private boolean dsk = true;
    private boolean hSw = true;
    private boolean mIsSeeHost = false;
    private boolean hSx = false;
    private boolean hSy = false;
    private boolean hSz = false;
    private boolean hRR = false;
    private boolean hSA = true;
    private boolean hSB = false;
    private boolean dsi = false;
    private boolean hSC = true;
    private boolean hRS = false;
    private final CustomMessageListener hSD = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null && !StringUtils.isNull(lVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(lVar);
                if (StringUtils.isNull(lVar.dvQ)) {
                    ba.aGG().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink});
                } else {
                    ba.aGG().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink, lVar.dvQ});
                }
            }
        }
    };
    private DragImageView.d dtT = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.hSf, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gqq, 8);
            if (ImageViewerActivity.this.hSg != null) {
                ImageViewerActivity.this.hSg.gq(false);
            }
            ImageViewerActivity.this.caG();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new an("c13341").X("obj_param1", ImageViewerActivity.this.hSg.getItemNum()).X(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.hSg.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void aSG() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 0);
            if (!ImageViewerActivity.this.hSB || !TbadkCoreApplication.isLogin()) {
                ImageViewerActivity.this.gqq.setVisibility(8);
            } else {
                ImageViewerActivity.this.gqq.setVisibility(0);
            }
            if (ImageViewerActivity.this.hSg != null && !ImageViewerActivity.this.hSg.aMQ()) {
                ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.hSf, 0);
                if (ImageViewerActivity.this.hSC) {
                    ImageViewerActivity.this.hSg.gq(true);
                } else {
                    ImageViewerActivity.this.hSg.gq(false);
                }
            }
        }
    };
    private UrlDragImageView.b dsb = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void aNi() {
            TiebaStatic.log(new an("c10351").cy("tid", ImageViewerActivity.this.Pj).cy("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final View.OnClickListener hSE = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.showToast(R.string.neterror);
                return;
            }
            TiebaStatic.log(new an("pb_onlyowner_click").X("obj_source", 2).X("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
            TiebaStatic.log(new an("c13338").X("obj_locate", ImageViewerActivity.this.mIsSeeHost ? 1 : 2));
            ImageViewerActivity.this.hSs = true;
            if (ImageViewerActivity.this.hSf != null) {
                ImageViewerActivity.this.hSf.setEnabled(false);
            }
            ImageViewerActivity.this.k(d.DO((String) v.getItem(ImageViewerActivity.this.hSh, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (ImageViewerActivity.this.hSB && ImageViewerActivity.this.hSg != null) {
                boolean aMQ = ImageViewerActivity.this.hSg.aMQ();
                if (ImageViewerActivity.this.hSf == null) {
                    i = 0;
                } else if (!aMQ) {
                    com.baidu.tieba.v.a.v(ImageViewerActivity.this.hSf, 100);
                    i = 1;
                } else {
                    com.baidu.tieba.v.a.w(ImageViewerActivity.this.hSf, 100);
                    i = 2;
                }
                ImageViewerActivity.this.hSg.n(aMQ ? false : true, 100);
                TiebaStatic.log(new an("c13397").X("obj_type", i));
                return;
            }
            TiebaStatic.log(new an("c13341").X("obj_param1", ImageViewerActivity.this.hSg.getItemNum()).X(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.hSg.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").cy("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean hSG = true;
    private View.OnTouchListener duf = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.hSF = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.hSG = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.hSF = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.hSG = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener hSH = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.hSk != null) {
                ImageViewerActivity.this.hSk.bye();
                ImageViewerActivity.this.hSk.show();
                ImageViewerActivity.this.hSk.ch(view);
            }
            TiebaStatic.log(new an("c13269").cy("uid", ImageViewerActivity.this.mUserId).cy("fid", ImageViewerActivity.this.emo).cy("tid", ImageViewerActivity.this.Pj));
            return true;
        }
    };
    private BaseViewPager.a hSI = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.hSi.cal();
            } else if (ImageViewerActivity.this.caB() != 1) {
                ImageViewerActivity.this.hSi.cam();
            }
        }
    };
    private ViewPager.OnPageChangeListener aZU = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.hSi != null && i > ImageViewerActivity.this.hSg.getItemNum() - 5) {
                ImageViewerActivity.this.hSi.cal();
            }
            ImageViewerActivity.this.hSj.d(ImageViewerActivity.this.hSh, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.caC();
            ImageViewerActivity.this.caH();
            ImageViewerActivity.this.xg(i);
            if (ImageViewerActivity.this.hSj.caJ() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.hSj.xh(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.hSj.caK() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.hSj.xi(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.caD()) {
                ImageViewerActivity.this.hSo.bZZ();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.hSg.getItemNum() - 1) {
                ImageViewerActivity.this.hSu = false;
            }
            if (ImageViewerActivity.this.hSk != null) {
                ImageViewerActivity.this.hSk.caM();
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
            if (ImageViewerActivity.this.hSg != null) {
                dragImageView = ImageViewerActivity.this.hSg.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.caB() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.hSh != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.hSh.size()) {
                ImageViewerActivity.this.hSj.aM(i, (String) ImageViewerActivity.this.hSh.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.hSg.getItemNum() - 1) {
                if (!ImageViewerActivity.this.hSG || !ImageViewerActivity.this.hSl || (!ImageViewerActivity.this.hSu && !ImageViewerActivity.this.caD() && (ImageViewerActivity.this.hSg.getItemNum() != 1 || !ImageViewerActivity.this.isRight))) {
                    ImageViewerActivity.this.hSu = true;
                } else {
                    ImageViewerActivity.this.showToast(R.string.last_page);
                }
            }
        }
    };
    private CustomMessageListener ddI = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.dts != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.dts.values()) {
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
    private CustomMessageListener ddJ = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.dts != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.dts.values()) {
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
        com.baidu.tbadk.mutiprocess.g.aQg().init(TbadkCoreApplication.getInst());
        this.hSr = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        bMW();
        k(this.hRQ, this.mIsSeeHost, false);
        registerListener(this.hSD);
        registerListener(this.ddI);
        registerListener(this.ddJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.hSi = new e(this.hSh, this.dts, this.emo, this.emp, this.Pj, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.hSi.setSourceImageRectInScreen(this.hRP);
        this.hSi.om(this.hSA);
        this.hSi.on(z);
        this.hSi.DQ(this.hRQ);
        this.hSi.ol(this.hRR);
        this.hSi.setPostId(this.mPostId);
        this.hSi.op(this.hRS);
        this.hSi.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.hSg != null) {
                    if (ImageViewerActivity.this.hSs) {
                        if (!z5) {
                            ImageViewerActivity.this.hSg.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.hSs = false;
                    if (ImageViewerActivity.this.hSf != null) {
                        ImageViewerActivity.this.hSf.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.hSg.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.hSg.getItemNum();
                        ImageViewerActivity.this.hSg.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.hSg.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.hSg.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.hSo != null) {
                        ImageViewerActivity.this.hSo.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.hSg.setUrlData(arrayList);
                    ImageViewerActivity.this.hSg.setAssistUrls(ImageViewerActivity.this.dts);
                    ImageViewerActivity.this.hSg.setHasNext(z3);
                    ImageViewerActivity.this.hSg.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.hSg.getItemNum()) {
                        ImageViewerActivity.this.hSg.mb(ImageViewerActivity.this.hSg.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.hSg.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.hSg.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.hSg.setUrlData(arrayList);
                        ImageViewerActivity.this.hSg.setCurrentItem(ImageViewerActivity.this.hSg.getCurrentItem() - 200, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.caC();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.hSg.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.hSo.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.hSo.bZV()) {
                    ImageViewerActivity.this.hSg.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.hSg.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void aL(int i, String str2) {
                ImageViewerActivity.this.hSs = false;
                if (ImageViewerActivity.this.hSf != null) {
                    ImageViewerActivity.this.hSf.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.hSh != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.hSh.size();
                    }
                    ImageViewerActivity.this.caC();
                }
            }
        });
        this.hSi.oo(true);
        this.hSi.cal();
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
        this.hSg.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.hSg.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.hSr = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hSg.onPause();
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
        this.hSg.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.Pj, 0L);
        if (uniqueId != null && j > 0) {
            q.a(com.baidu.tbadk.BdToken.b.cGU, uniqueId.getId(), j);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.hSg.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2 = null;
        MessageManager.getInstance().unRegisterListener(this.hSD);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.aPR().releaseBlockBitmapPool();
        this.hSj.d(this.hSh, this.mIndex, this.mIndex);
        this.hSj.caL();
        String str3 = "";
        if (this.hSo != null) {
            str3 = this.hSo.getAdId();
        }
        if (this.hSi != null) {
            str = this.hSi.aDS();
            str2 = this.hSi.aDT();
        } else {
            str = null;
        }
        this.hSj.a(this.hSg.getPageCount(), str3, this.emo, this.Pj, str, str2);
        if (this.hSk != null) {
            this.hSk.release();
        }
        this.hSg.onDestroy();
        com.baidu.tbadk.download.d.aOq().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.hSr);
        caG();
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

    private void bMW() {
        bcK();
        initViewPager();
        caC();
        bzi();
        cay();
        this.hSk = new j(this);
        this.hSk.j(this.hSg);
        this.hSj.d(this.hSh, this.mIndex, this.mIndex);
    }

    private void cay() {
        if (com.baidu.tbadk.core.util.g.aFM()) {
            this.mStatusBarView = findViewById(R.id.statusbar_view);
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
    }

    private void bcK() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        caz();
        bgg();
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
        if (d.DP((String) v.getItem(this.hSh, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void caz() {
        this.gqq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gqq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.fkh = (ImageView) this.gqq.findViewById(R.id.widget_navi_back_button);
        SvgManager.aGC().a(this.fkh, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.hSB && TbadkCoreApplication.isLogin()) {
            this.gqq.setVisibility(0);
        } else {
            this.gqq.setVisibility(8);
        }
    }

    private void bgg() {
        if (!this.hSy && !this.hSx) {
            this.hSf = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(R.id.see_host_image_txt);
            if (this.hSw) {
                this.hSf.setText(this.mIsSeeHost ? R.string.album_all_thread : R.string.view_host);
                this.hSf.setOnClickListener(this.hSE);
                return;
            }
            setViewVisibility(this.hSf, 8);
        }
    }

    public Map<String, ImageUrlData> caA() {
        return this.dts;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long caB() {
        ImageUrlData imageUrlData;
        String str = (String) v.getItem(this.hSh, this.mIndex);
        if (this.dts == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.dts.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caC() {
        String str;
        if (this.hSh != null) {
            String str2 = ("" + caB()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.hSt && caB() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new an("c13316").cy("obj_source", this.mFrom));
                this.hSt = true;
            }
            if (caD()) {
                caE();
            } else {
                DR(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean caD() {
        if (this.hSv && this.hSo != null && this.hSo.bZV()) {
            return this.hSg.getItemNum() != 1 && this.mIndex == this.hSg.getItemNum() + (-1);
        }
        return false;
    }

    private void DR(String str) {
        this.mTitleView.setText(str);
        if (this.hSw && !this.hSx && this.hSf != null) {
            this.hSf.setText(this.mIsSeeHost ? R.string.album_all_thread : R.string.view_host);
        }
    }

    private void caE() {
        this.mTitleView.setText("");
        setViewVisibility(this.hSf, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.hSg == null) {
            this.hSg = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.hSg.init();
        }
        this.hSg.setIsFromCDN(this.dsi);
        this.hSg.setIsCanDrag(this.dsk);
        this.hSg.setIsBJHThread(this.hSy);
        this.hSg.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.hSg.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.hSg.setOnPageChangeListener(this.aZU);
        this.hSg.setUrlData(this.hSh);
        this.hSg.setAssistUrls(this.dts);
        this.hSg.setOuterOnTouchListener(this.duf);
        this.hSg.setItemOnclickListener(this.mOnClickListener);
        this.hSg.setItemOnLongClickListener(this.hSH);
        this.hSg.setCurrentItem(bRC(), false);
        this.hSg.setOnScrollOutListener(this.hSI);
        this.hSo = new a(this.dsi, this.hSv, getPageContext(), this.emo, this.Pj);
        this.hSo.setDragToExitListener(this.dtT);
        this.hSg.a(this.hSo);
        this.hSg.setOriImgSelectedCallback(this.dsb);
        this.hSg.setDragToExitListener(this.dtT);
        this.hSg.setUserId(this.mUserId);
        this.hSg.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.hSl = ImageViewerActivity.this.hSm - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.hSm = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        this.hSg.setShowBottomContainer(this.hSC);
        TiebaStatic.log(new an("c13340").cy("uid", this.mUserId).cy("post_id", this.Pj).X("obj_source", caF()));
    }

    private int caF() {
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

    private void bzi() {
        if (!this.hSx && this.hSf != null) {
            if (this.hSn == null) {
                this.hSn = new com.baidu.tieba.c.d(getPageContext(), this.hSf);
                this.hSn.ck(R.drawable.pic_sign_tip);
                this.hSn.cj(48);
                this.hSn.setUseDirectOffset(true);
                this.hSn.cl(5000);
                this.hSn.rz(-com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.hSn.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.caG();
                    }
                });
            }
            this.hSn.aj(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caG() {
        if (this.hSn != null) {
            this.hSn.zz();
        }
    }

    public int bRC() {
        int count = v.getCount(this.hSh);
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
        this.hSj = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.hSy = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.hSB = bundle.getBoolean("abtest");
            this.hSh = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.emo = bundle.getString("fid");
            this.Pj = bundle.getString("tid");
            this.emp = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.dsi = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.hSA = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.hSv = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.dsk = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.hSw = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.hRP = bundle.getString("source_rect_in_screen");
            this.hRR = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.hSC = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.hRS = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.dts = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.dts.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.hSz = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.hSx = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.hSy = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.hSB = intent.getBooleanExtra("abtest", false);
                this.hSh = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.emo = intent.getStringExtra("fid");
                this.Pj = intent.getStringExtra("tid");
                this.emp = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.dsi = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.hSA = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.hSv = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.dsk = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.hSw = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.hSC = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.hRS = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.hSz = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.hSx = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.hRP = intent.getStringExtra("source_rect_in_screen");
                this.hRR = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.dts = (Map) serializableExtra;
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
        this.hSj.b(bundle, getIntent());
        this.mCount = v.getCount(this.hSh);
        if (this.hRP != null) {
            String str = (String) v.getItem(this.hSh, this.mIndex);
            if (!StringUtils.isNull(str) && this.dts != null && (imageUrlData = this.dts.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.hRP);
            }
        }
        this.hRQ = this.hSy ? null : d.DO((String) v.getItem(this.hSh, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new an("c13337").cy("obj_type", "2"));
        } else {
            TiebaStatic.log(new an("c13337").cy("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.hSy);
        bundle.putBoolean("abtest", this.hSB);
        bundle.putStringArrayList("url", this.hSh);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.emo);
        bundle.putString("tid", this.Pj);
        bundle.putString("fname", this.emp);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.hSA);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.dsk);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.hSw);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.hSv);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.hSC);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.hRS);
        if (this.dts instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.dts.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.dts instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.dts.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.hRP);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.hSz);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.hSx);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.hRR);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        this.hSj.ar(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.hSg.setCurrentItem(this.mIndex, false);
        SvgManager.aGC().a(this.fkh, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xg(int i) {
        if (this.hSg != null) {
            this.hSg.ma(i);
            setViewVisibility(this.hSf, (this.hSg.aMQ() || caD()) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caH() {
        if (caD()) {
            this.hSq = this.mNavigationBar.getVisibility() == 0;
            this.hSp = true;
        } else if (this.hSp) {
            this.mNavigationBar.setVisibility(this.hSq ? 0 : 8);
            this.hSp = false;
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
                return com.baidu.tbadk.m.e.aQY().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.emo, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.Pj, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.vF(TbadkCoreApplication.getInst().getAdAdSense().dml);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.coreExtra.view.a
    public boolean aMH() {
        return this.hSB;
    }

    public boolean caI() {
        return this.hSy;
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
