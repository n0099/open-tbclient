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
    private Map<String, ImageUrlData> dte;
    private String ema;
    private String emb;
    private ImageView fjT;
    private View gqb;
    private String hRB;
    private String hRC;
    private TextView hRR;
    private MultiImageView hRS;
    private ArrayList<String> hRT;
    private e hRU;
    private i hRV;
    private j hRW;
    private boolean hRX;
    private float hRY;
    private com.baidu.tieba.c.d hRZ;
    private int hSd;
    private boolean hSe;
    private float hSr;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private String mPostId;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private a hSa = null;
    private boolean hSb = false;
    private boolean hSc = false;
    private int Ev = 0;
    private boolean isRight = false;
    private boolean hSf = false;
    private boolean hSg = false;
    private boolean hSh = true;
    private boolean drW = true;
    private boolean hSi = true;
    private boolean mIsSeeHost = false;
    private boolean hSj = false;
    private boolean hSk = false;
    private boolean hSl = false;
    private boolean hRD = false;
    private boolean hSm = true;
    private boolean hSn = false;
    private boolean drU = false;
    private boolean hSo = true;
    private boolean hRE = false;
    private final CustomMessageListener hSp = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null && !StringUtils.isNull(lVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(lVar);
                if (StringUtils.isNull(lVar.dvC)) {
                    ba.aGE().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink});
                } else {
                    ba.aGE().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink, lVar.dvC});
                }
            }
        }
    };
    private DragImageView.d dtF = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.hRR, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gqb, 8);
            if (ImageViewerActivity.this.hRS != null) {
                ImageViewerActivity.this.hRS.gq(false);
            }
            ImageViewerActivity.this.caD();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new an("c13341").X("obj_param1", ImageViewerActivity.this.hRS.getItemNum()).X(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.hRS.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void aSD() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 0);
            if (!ImageViewerActivity.this.hSn || !TbadkCoreApplication.isLogin()) {
                ImageViewerActivity.this.gqb.setVisibility(8);
            } else {
                ImageViewerActivity.this.gqb.setVisibility(0);
            }
            if (ImageViewerActivity.this.hRS != null && !ImageViewerActivity.this.hRS.aMN()) {
                ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.hRR, 0);
                if (ImageViewerActivity.this.hSo) {
                    ImageViewerActivity.this.hRS.gq(true);
                } else {
                    ImageViewerActivity.this.hRS.gq(false);
                }
            }
        }
    };
    private UrlDragImageView.b drN = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void aNf() {
            TiebaStatic.log(new an("c10351").cy("tid", ImageViewerActivity.this.Pj).cy("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final View.OnClickListener hSq = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.showToast(R.string.neterror);
                return;
            }
            TiebaStatic.log(new an("pb_onlyowner_click").X("obj_source", 2).X("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
            TiebaStatic.log(new an("c13338").X("obj_locate", ImageViewerActivity.this.mIsSeeHost ? 1 : 2));
            ImageViewerActivity.this.hSe = true;
            if (ImageViewerActivity.this.hRR != null) {
                ImageViewerActivity.this.hRR.setEnabled(false);
            }
            ImageViewerActivity.this.k(d.DN((String) v.getItem(ImageViewerActivity.this.hRT, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (ImageViewerActivity.this.hSn && ImageViewerActivity.this.hRS != null) {
                boolean aMN = ImageViewerActivity.this.hRS.aMN();
                if (ImageViewerActivity.this.hRR == null) {
                    i = 0;
                } else if (!aMN) {
                    com.baidu.tieba.v.a.v(ImageViewerActivity.this.hRR, 100);
                    i = 1;
                } else {
                    com.baidu.tieba.v.a.w(ImageViewerActivity.this.hRR, 100);
                    i = 2;
                }
                ImageViewerActivity.this.hRS.n(aMN ? false : true, 100);
                TiebaStatic.log(new an("c13397").X("obj_type", i));
                return;
            }
            TiebaStatic.log(new an("c13341").X("obj_param1", ImageViewerActivity.this.hRS.getItemNum()).X(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.hRS.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").cy("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean hSs = true;
    private View.OnTouchListener dtR = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.hSr = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.hSs = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.hSr = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.hSs = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener hSt = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.hRW != null) {
                ImageViewerActivity.this.hRW.byb();
                ImageViewerActivity.this.hRW.show();
                ImageViewerActivity.this.hRW.ch(view);
            }
            TiebaStatic.log(new an("c13269").cy("uid", ImageViewerActivity.this.mUserId).cy("fid", ImageViewerActivity.this.ema).cy("tid", ImageViewerActivity.this.Pj));
            return true;
        }
    };
    private BaseViewPager.a hSu = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.hRU.cai();
            } else if (ImageViewerActivity.this.cay() != 1) {
                ImageViewerActivity.this.hRU.caj();
            }
        }
    };
    private ViewPager.OnPageChangeListener aZS = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.hRU != null && i > ImageViewerActivity.this.hRS.getItemNum() - 5) {
                ImageViewerActivity.this.hRU.cai();
            }
            ImageViewerActivity.this.hRV.d(ImageViewerActivity.this.hRT, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.caz();
            ImageViewerActivity.this.caE();
            ImageViewerActivity.this.xg(i);
            if (ImageViewerActivity.this.hRV.caG() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.hRV.xh(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.hRV.caH() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.hRV.xi(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.caA()) {
                ImageViewerActivity.this.hSa.bZW();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.hRS.getItemNum() - 1) {
                ImageViewerActivity.this.hSg = false;
            }
            if (ImageViewerActivity.this.hRW != null) {
                ImageViewerActivity.this.hRW.caJ();
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
            if (ImageViewerActivity.this.hRS != null) {
                dragImageView = ImageViewerActivity.this.hRS.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.cay() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.hRT != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.hRT.size()) {
                ImageViewerActivity.this.hRV.aM(i, (String) ImageViewerActivity.this.hRT.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.hRS.getItemNum() - 1) {
                if (!ImageViewerActivity.this.hSs || !ImageViewerActivity.this.hRX || (!ImageViewerActivity.this.hSg && !ImageViewerActivity.this.caA() && (ImageViewerActivity.this.hRS.getItemNum() != 1 || !ImageViewerActivity.this.isRight))) {
                    ImageViewerActivity.this.hSg = true;
                } else {
                    ImageViewerActivity.this.showToast(R.string.last_page);
                }
            }
        }
    };
    private CustomMessageListener ddt = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.dte != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.dte.values()) {
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
    private CustomMessageListener ddv = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.dte != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.dte.values()) {
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
        com.baidu.tbadk.mutiprocess.g.aQd().init(TbadkCoreApplication.getInst());
        this.hSd = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        bMT();
        k(this.hRC, this.mIsSeeHost, false);
        registerListener(this.hSp);
        registerListener(this.ddt);
        registerListener(this.ddv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.hRU = new e(this.hRT, this.dte, this.ema, this.emb, this.Pj, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.hRU.setSourceImageRectInScreen(this.hRB);
        this.hRU.om(this.hSm);
        this.hRU.on(z);
        this.hRU.DP(this.hRC);
        this.hRU.ol(this.hRD);
        this.hRU.setPostId(this.mPostId);
        this.hRU.op(this.hRE);
        this.hRU.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.hRS != null) {
                    if (ImageViewerActivity.this.hSe) {
                        if (!z5) {
                            ImageViewerActivity.this.hRS.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.hSe = false;
                    if (ImageViewerActivity.this.hRR != null) {
                        ImageViewerActivity.this.hRR.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.hRS.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.hRS.getItemNum();
                        ImageViewerActivity.this.hRS.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.hRS.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.hRS.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.hSa != null) {
                        ImageViewerActivity.this.hSa.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.hRS.setUrlData(arrayList);
                    ImageViewerActivity.this.hRS.setAssistUrls(ImageViewerActivity.this.dte);
                    ImageViewerActivity.this.hRS.setHasNext(z3);
                    ImageViewerActivity.this.hRS.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.hRS.getItemNum()) {
                        ImageViewerActivity.this.hRS.mb(ImageViewerActivity.this.hRS.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.hRS.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.hRS.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.hRS.setUrlData(arrayList);
                        ImageViewerActivity.this.hRS.setCurrentItem(ImageViewerActivity.this.hRS.getCurrentItem() - 200, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.caz();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.hRS.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.hSa.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.hSa.bZS()) {
                    ImageViewerActivity.this.hRS.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.hRS.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void aL(int i, String str2) {
                ImageViewerActivity.this.hSe = false;
                if (ImageViewerActivity.this.hRR != null) {
                    ImageViewerActivity.this.hRR.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.hRT != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.hRT.size();
                    }
                    ImageViewerActivity.this.caz();
                }
            }
        });
        this.hRU.oo(true);
        this.hRU.cai();
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
        this.hRS.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.hRS.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.hSd = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hRS.onPause();
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
        this.hRS.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.Pj, 0L);
        if (uniqueId != null && j > 0) {
            q.a(com.baidu.tbadk.BdToken.b.cGS, uniqueId.getId(), j);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.hRS.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2 = null;
        MessageManager.getInstance().unRegisterListener(this.hSp);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.aPO().releaseBlockBitmapPool();
        this.hRV.d(this.hRT, this.mIndex, this.mIndex);
        this.hRV.caI();
        String str3 = "";
        if (this.hSa != null) {
            str3 = this.hSa.getAdId();
        }
        if (this.hRU != null) {
            str = this.hRU.aDQ();
            str2 = this.hRU.aDR();
        } else {
            str = null;
        }
        this.hRV.a(this.hRS.getPageCount(), str3, this.ema, this.Pj, str, str2);
        if (this.hRW != null) {
            this.hRW.release();
        }
        this.hRS.onDestroy();
        com.baidu.tbadk.download.d.aOn().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.hSd);
        caD();
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

    private void bMT() {
        bcH();
        initViewPager();
        caz();
        bzf();
        cav();
        this.hRW = new j(this);
        this.hRW.j(this.hRS);
        this.hRV.d(this.hRT, this.mIndex, this.mIndex);
    }

    private void cav() {
        if (com.baidu.tbadk.core.util.g.aFK()) {
            this.mStatusBarView = findViewById(R.id.statusbar_view);
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
    }

    private void bcH() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        caw();
        bgd();
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
        if (d.DO((String) v.getItem(this.hRT, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void caw() {
        this.gqb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gqb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.fjT = (ImageView) this.gqb.findViewById(R.id.widget_navi_back_button);
        SvgManager.aGA().a(this.fjT, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.hSn && TbadkCoreApplication.isLogin()) {
            this.gqb.setVisibility(0);
        } else {
            this.gqb.setVisibility(8);
        }
    }

    private void bgd() {
        if (!this.hSk && !this.hSj) {
            this.hRR = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(R.id.see_host_image_txt);
            if (this.hSi) {
                this.hRR.setText(this.mIsSeeHost ? R.string.album_all_thread : R.string.view_host);
                this.hRR.setOnClickListener(this.hSq);
                return;
            }
            setViewVisibility(this.hRR, 8);
        }
    }

    public Map<String, ImageUrlData> cax() {
        return this.dte;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cay() {
        ImageUrlData imageUrlData;
        String str = (String) v.getItem(this.hRT, this.mIndex);
        if (this.dte == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.dte.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caz() {
        String str;
        if (this.hRT != null) {
            String str2 = ("" + cay()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.hSf && cay() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new an("c13316").cy("obj_source", this.mFrom));
                this.hSf = true;
            }
            if (caA()) {
                caB();
            } else {
                DQ(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean caA() {
        if (this.hSh && this.hSa != null && this.hSa.bZS()) {
            return this.hRS.getItemNum() != 1 && this.mIndex == this.hRS.getItemNum() + (-1);
        }
        return false;
    }

    private void DQ(String str) {
        this.mTitleView.setText(str);
        if (this.hSi && !this.hSj && this.hRR != null) {
            this.hRR.setText(this.mIsSeeHost ? R.string.album_all_thread : R.string.view_host);
        }
    }

    private void caB() {
        this.mTitleView.setText("");
        setViewVisibility(this.hRR, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.hRS == null) {
            this.hRS = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.hRS.init();
        }
        this.hRS.setIsFromCDN(this.drU);
        this.hRS.setIsCanDrag(this.drW);
        this.hRS.setIsBJHThread(this.hSk);
        this.hRS.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.hRS.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.hRS.setOnPageChangeListener(this.aZS);
        this.hRS.setUrlData(this.hRT);
        this.hRS.setAssistUrls(this.dte);
        this.hRS.setOuterOnTouchListener(this.dtR);
        this.hRS.setItemOnclickListener(this.mOnClickListener);
        this.hRS.setItemOnLongClickListener(this.hSt);
        this.hRS.setCurrentItem(bRz(), false);
        this.hRS.setOnScrollOutListener(this.hSu);
        this.hSa = new a(this.drU, this.hSh, getPageContext(), this.ema, this.Pj);
        this.hSa.setDragToExitListener(this.dtF);
        this.hRS.a(this.hSa);
        this.hRS.setOriImgSelectedCallback(this.drN);
        this.hRS.setDragToExitListener(this.dtF);
        this.hRS.setUserId(this.mUserId);
        this.hRS.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.hRX = ImageViewerActivity.this.hRY - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.hRY = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        this.hRS.setShowBottomContainer(this.hSo);
        TiebaStatic.log(new an("c13340").cy("uid", this.mUserId).cy("post_id", this.Pj).X("obj_source", caC()));
    }

    private int caC() {
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

    private void bzf() {
        if (!this.hSj && this.hRR != null) {
            if (this.hRZ == null) {
                this.hRZ = new com.baidu.tieba.c.d(getPageContext(), this.hRR);
                this.hRZ.ck(R.drawable.pic_sign_tip);
                this.hRZ.cj(48);
                this.hRZ.setUseDirectOffset(true);
                this.hRZ.cl(5000);
                this.hRZ.rz(-com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.hRZ.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.caD();
                    }
                });
            }
            this.hRZ.aj(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caD() {
        if (this.hRZ != null) {
            this.hRZ.zx();
        }
    }

    public int bRz() {
        int count = v.getCount(this.hRT);
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
        this.hRV = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.hSk = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.hSn = bundle.getBoolean("abtest");
            this.hRT = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.ema = bundle.getString("fid");
            this.Pj = bundle.getString("tid");
            this.emb = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.drU = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.hSm = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.hSh = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.drW = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.hSi = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.hRB = bundle.getString("source_rect_in_screen");
            this.hRD = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.hSo = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.hRE = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.dte = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.dte.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.hSl = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.hSj = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.hSk = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.hSn = intent.getBooleanExtra("abtest", false);
                this.hRT = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.ema = intent.getStringExtra("fid");
                this.Pj = intent.getStringExtra("tid");
                this.emb = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.drU = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.hSm = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.hSh = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.drW = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.hSi = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.hSo = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.hRE = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.hSl = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.hSj = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.hRB = intent.getStringExtra("source_rect_in_screen");
                this.hRD = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.dte = (Map) serializableExtra;
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
        this.hRV.b(bundle, getIntent());
        this.mCount = v.getCount(this.hRT);
        if (this.hRB != null) {
            String str = (String) v.getItem(this.hRT, this.mIndex);
            if (!StringUtils.isNull(str) && this.dte != null && (imageUrlData = this.dte.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.hRB);
            }
        }
        this.hRC = this.hSk ? null : d.DN((String) v.getItem(this.hRT, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new an("c13337").cy("obj_type", "2"));
        } else {
            TiebaStatic.log(new an("c13337").cy("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.hSk);
        bundle.putBoolean("abtest", this.hSn);
        bundle.putStringArrayList("url", this.hRT);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.ema);
        bundle.putString("tid", this.Pj);
        bundle.putString("fname", this.emb);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.hSm);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.drW);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.hSi);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.hSh);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.hSo);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.hRE);
        if (this.dte instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.dte.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.dte instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.dte.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.hRB);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.hSl);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.hSj);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.hRD);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        this.hRV.ar(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.hRS.setCurrentItem(this.mIndex, false);
        SvgManager.aGA().a(this.fjT, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xg(int i) {
        if (this.hRS != null) {
            this.hRS.ma(i);
            setViewVisibility(this.hRR, (this.hRS.aMN() || caA()) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caE() {
        if (caA()) {
            this.hSc = this.mNavigationBar.getVisibility() == 0;
            this.hSb = true;
        } else if (this.hSb) {
            this.mNavigationBar.setVisibility(this.hSc ? 0 : 8);
            this.hSb = false;
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
                return com.baidu.tbadk.m.e.aQV().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.ema, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.Pj, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.vE(TbadkCoreApplication.getInst().getAdAdSense().dlX);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.coreExtra.view.a
    public boolean aME() {
        return this.hSn;
    }

    public boolean caF() {
        return this.hSk;
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
