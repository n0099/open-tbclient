package com.baidu.tieba.recommendlist;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.data.r;
import com.baidu.live.liveroom.g.b;
import com.baidu.live.liveroom.g.d;
import com.baidu.live.r.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.AlaListViewPullView;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.recommendlist.adapter.RecommendPagerAdapter;
import com.baidu.tieba.recommendlist.model.b;
import com.baidu.tieba.recommendlist.view.AlaRecommendLiveListView;
import com.baidu.tieba.recommendlist.view.RecommendViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class a implements View.OnClickListener, b, d, com.baidu.live.r.a {
    private View aAQ;
    private List<AbsDelegateAdapter> bbw;
    private CommonEmptyView bpE;
    private int cardWidth;
    private ViewGroup fZy;
    private TbListCommonPullView gQd;
    private LoadMoreFooter gbu;
    private com.baidu.live.r.b goH;
    private View lKA;
    private int lKB;
    private float lKC;
    private c lKD;
    private final int lKE = 100;
    private com.baidu.tieba.recommendlist.model.b lKF;
    private TextView lKG;
    private boolean lKH;
    private r lKI;
    private FrameLayout lKJ;
    private View lKK;
    private View lKL;
    private ViewGroup lKx;
    private RecommendViewPager lKy;
    private AlaRecommendLiveListView lKz;
    private float lcB;
    private ValueAnimator mAnimator;
    private Context mContext;
    private float mDownX;
    private float mDownY;
    private int mOrientation;
    private int mScreenWidth;
    private int mShowType;
    private TbPageContext mTbPageContext;
    private int mTouchSlop;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.mTbPageContext = tbPageContext;
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.lKB = this.mScreenWidth;
            doJ();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.c.AD().getBoolean("ala_recommend_live_first_show", true)) {
                this.mShowType = 1;
            }
        }
    }

    @Override // com.baidu.live.r.a
    public void a(c cVar) {
        this.lKD = cVar;
    }

    @Override // com.baidu.live.r.a
    public void o(r rVar) {
        this.lKI = rVar;
    }

    @Override // com.baidu.live.r.a
    public void D(int i, int i2) {
        this.mOrientation = i2;
        if (i2 == 2) {
            this.lKA.setVisibility(8);
            if (isOpen()) {
                onClose();
                return;
            }
            return;
        }
        this.lKA.setVisibility(0);
    }

    @Override // com.baidu.live.r.a
    public d Mz() {
        return this;
    }

    @Override // com.baidu.live.r.a
    public b MA() {
        return this;
    }

    @Override // com.baidu.live.r.a
    public void a(com.baidu.live.r.b bVar) {
        this.goH = bVar;
    }

    @Override // com.baidu.live.r.a
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (viewGroup != null) {
            this.fZy = viewGroup;
            this.lKx = viewGroup2;
            doK();
            doI();
            if (!this.lKH && com.baidu.live.w.a.Nk().beJ != null && this.mShowType != 1) {
                long j = com.baidu.live.c.AD().getLong("ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int i = com.baidu.live.w.a.Nk().beJ.aHw;
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > i) {
                    this.mShowType = 2;
                }
            }
            GB(0);
        }
    }

    @Override // com.baidu.live.r.a
    public void BB() {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
        if (this.fZy != null) {
            this.fZy.removeView(this.lKy);
            this.fZy.removeView(this.lKK);
        }
        this.lKD = null;
        if (this.lKH) {
            com.baidu.live.c.AD().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.lKI = null;
        if (this.lKF != null) {
            this.lKF.reset();
        }
    }

    @Override // com.baidu.live.r.a
    public void onDestroy() {
        BB();
        if (this.lKF != null) {
            this.lKF.onDestroy();
        }
    }

    private void doI() {
        if (this.aAQ == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.lKB, -1);
            this.aAQ = LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_content_layout, (ViewGroup) null);
            this.aAQ.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aAQ.findViewById(a.g.right_layout).setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            }
            this.lKL = this.aAQ.findViewById(a.g.block_view);
            this.lKL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.lKJ = (FrameLayout) this.aAQ.findViewById(a.g.listView_layout);
            this.lKz = (AlaRecommendLiveListView) this.aAQ.findViewById(a.g.recommendLiveListView);
            this.gQd = new AlaListViewPullView(this.mContext);
            this.lKz.setPullRefresh(this.gQd);
            this.gbu = new LoadMoreFooter(this.mContext);
            this.gbu.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
            this.gbu.setFooterHeight(this.cardWidth / 2);
            this.gbu.createView();
            Jv();
            this.lKz.addAdapters(this.bbw);
            this.gQd.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.recommendlist.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.GB(0);
                    if (!z) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "your_recommend", "pushfresh"));
                    }
                }
            });
            this.lKz.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.recommendlist.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.gbu.isLoading() && a.this.lKF != null && a.this.lKF.hasMore && i + i2 > i3 - 2) {
                        a.this.bFT();
                        a.this.GB(1);
                    }
                }
            });
        }
        if (this.lKK == null) {
            this.lKK = new View(this.mContext);
            this.lKK.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha65));
            this.lKK.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.lKK.setAlpha(0.0f);
        }
        this.fZy.addView(this.lKK);
        if (this.lKy == null) {
            this.lKy = new RecommendViewPager(this.mTbPageContext.getPageActivity());
            this.lKy.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.lKy.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.recommendlist.a.4
                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    if (a.this.isOpen() && i == 0) {
                        a.this.lKK.setAlpha(f);
                    }
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    if (i == 0 && a.this.lKy != null) {
                        if (a.this.lKy.getCurrentItem() != 0) {
                            a.this.doM();
                        } else {
                            a.this.close();
                        }
                    }
                }
            });
            ArrayList arrayList = new ArrayList();
            Space space = new Space(this.mTbPageContext.getPageActivity());
            space.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            arrayList.add(space);
            arrayList.add(this.aAQ);
            this.lKy.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.lKB, -1);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = -this.lKB;
            this.lKy.setLayoutParams(layoutParams2);
        }
        this.fZy.addView(this.lKy);
        this.lKy.setCurrentItem(1, false);
        if (this.lKF == null) {
            this.lKF = new com.baidu.tieba.recommendlist.model.b(this.mTbPageContext);
            this.lKF.a(new b.a() { // from class: com.baidu.tieba.recommendlist.a.5
                @Override // com.baidu.tieba.recommendlist.model.b.a
                public void g(List<IAdapterData> list, int i, int i2) {
                    a.this.f(list, i, i2);
                }

                @Override // com.baidu.tieba.recommendlist.model.b.a
                public void onFail(int i, String str) {
                    a.this.b(CommonEmptyView.ImgType.SERVER_ERROR);
                }
            });
        }
    }

    private void doJ() {
        this.cardWidth = ((((this.lKB - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds340);
        }
    }

    private void Jv() {
        if (this.bbw == null) {
            this.bbw = new ArrayList();
            this.bbw.add(new com.baidu.tieba.recommendlist.adapter.b(this.mContext, com.baidu.tieba.recommendlist.data.c.lLe));
            this.bbw.add(new com.baidu.tieba.recommendlist.adapter.a(this.mContext, com.baidu.tieba.recommendlist.data.a.lLb, this.cardWidth));
        }
    }

    private void doK() {
        this.lKA = LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_header_entrance, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
        this.lKA.setLayoutParams(layoutParams);
        if (this.lKx != null) {
            this.lKx.addView(this.lKA);
        }
        this.lKA.setOnClickListener(this);
    }

    @Override // com.baidu.live.liveroom.g.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!ac(motionEvent)) {
            return false;
        }
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            return true;
        }
        return d(motionEvent, motionEvent.getActionIndex());
    }

    private boolean d(MotionEvent motionEvent, int i) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mDownX = motionEvent.getX(i);
                this.mDownY = motionEvent.getY(i);
                this.lcB = this.mDownX;
                this.lKC = this.mDownY;
                break;
            case 1:
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                float f = this.mDownX - x;
                float f2 = this.mDownY - y;
                if (Math.abs(f) < this.mTouchSlop && Math.abs(f2) < this.mTouchSlop && x > 0.0f && x < this.mScreenWidth - this.lKB) {
                    onClose();
                    return true;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lKy.getLayoutParams();
                if (f > this.mTouchSlop) {
                    vv(true);
                    doL();
                    return true;
                } else if (layoutParams.rightMargin > (-this.lKB)) {
                    onClose();
                    return true;
                }
                break;
            case 2:
                float x2 = motionEvent.getX(i);
                float y2 = motionEvent.getY(i);
                float f3 = this.lcB - x2;
                float f4 = this.lKC - y2;
                this.lcB = x2;
                this.lKC = y2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.lKy.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.lKy.setLayoutParams(layoutParams2);
                        this.lKK.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.lKB));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.lKB)) {
                        layoutParams2.rightMargin = i3;
                        this.lKy.setLayoutParams(layoutParams2);
                        this.lKK.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.lKB));
                        return true;
                    } else if (i3 < (-this.lKB)) {
                        layoutParams2.rightMargin = -this.lKB;
                        this.lKy.setLayoutParams(layoutParams2);
                        this.lKK.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.lKB));
                        return false;
                    }
                }
                break;
            case 3:
                close();
                break;
        }
        return false;
    }

    private boolean ac(MotionEvent motionEvent) {
        if (motionEvent == null || this.mOrientation == 2 || this.goH == null) {
            return false;
        }
        return this.goH.MB();
    }

    private void doL() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "left_slide"));
    }

    public void vv(boolean z) {
        if ((this.mAnimator == null || !this.mAnimator.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            vw(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lKy.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                Z(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.lKB)));
            }
            if (this.lKD != null) {
                this.lKD.ck(true);
            }
            if (!this.lKH) {
                this.lKH = true;
            }
            this.lKz.completePullRefresh();
            if (z) {
                GB(0);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1429", LogConfig.KEY_ACCESS, "your_recommend", ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GB(int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            b(CommonEmptyView.ImgType.NO_NET);
            return;
        }
        hideNoDataView();
        long j = 0;
        if (this.lKI != null && this.lKI.mLiveInfo != null) {
            j = this.lKI.mLiveInfo.live_id;
        }
        this.lKF.m(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<IAdapterData> list, int i, int i2) {
        if (this.lKF.hasMore) {
            bKi();
        } else if (i2 == 1) {
            bKi();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.lKz.setData(list);
        if (this.bbw != null) {
            Iterator<AbsDelegateAdapter> it = this.bbw.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbsDelegateAdapter next = it.next();
                if (next instanceof com.baidu.tieba.recommendlist.adapter.a) {
                    ((com.baidu.tieba.recommendlist.adapter.a) next).GC(i);
                    ((com.baidu.tieba.recommendlist.adapter.a) next).e(this.lKI);
                    break;
                }
            }
        }
        if ((this.mShowType == 1 || this.mShowType == 2) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            if (this.mShowType == 1) {
                com.baidu.live.c.AD().putBoolean("ala_recommend_live_first_show", false);
            } else {
                com.baidu.live.c.AD().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
            }
            this.mShowType = 0;
        }
        this.lKz.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.lKF != null && !this.lKF.btQ()) {
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                BdUtilHelper.showToast(this.mContext, a.i.recommend_live_net_weak);
            }
            this.lKz.completePullRefresh();
            return;
        }
        if (this.bpE == null) {
            this.bpE = new CommonEmptyView(this.mContext);
            ImageView imageView = (ImageView) this.bpE.findViewById(a.g.sdk_cev_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds180);
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds180);
            imageView.setLayoutParams(layoutParams);
            ((TextView) this.bpE.findViewById(a.g.sdk_cev_title)).setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
            this.lKG = (TextView) this.bpE.findViewById(a.g.sdk_cev_refresh_btn);
            this.lKG.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize22));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lKG.getLayoutParams();
            layoutParams2.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds152);
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds54);
            layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds30);
            this.lKG.setLayoutParams(layoutParams2);
            if (this.lKJ != null) {
                this.bpE.addToParent(this.lKJ);
            }
        }
        this.bpE.reset();
        switch (imgType) {
            case NO_NET:
                i = a.i.recommend_live_no_net;
                break;
            case SERVER_ERROR:
                i = a.i.recommend_live_no_response;
                break;
            default:
                i = a.i.recommend_live_no_data;
                break;
        }
        this.bpE.setTitle(i);
        this.bpE.setRefreshButton(this.mContext.getResources().getString(a.i.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hideNoDataView();
                a.this.lKz.startPullRefresh();
            }
        });
        this.bpE.setup(imgType, CommonEmptyView.StyleType.DARK);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.lKG.setBackgroundResource(a.f.ala_recommend_live_empty_refresh_btn_selector);
        }
        this.bpE.setVisibility(0);
        this.lKz.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bpE != null) {
            this.bpE.setVisibility(8);
        }
    }

    @Override // com.baidu.live.r.a
    public void close() {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (this.lKD != null) {
            this.lKD.ck(false);
        }
        vw(false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lKy.getLayoutParams();
        layoutParams.rightMargin = -this.lKB;
        this.lKy.setLayoutParams(layoutParams);
        this.lKy.setCurrentItem(1, false);
        this.lKK.setAlpha(0.0f);
    }

    @Override // com.baidu.live.r.a
    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.lKy.getLayoutParams()).rightMargin > (-this.lKB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doM() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.lKy.getLayoutParams()).rightMargin * 1.0f) / this.lKB);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.lKK.setAlpha(abs);
    }

    @Override // com.baidu.live.r.a
    public void onClose() {
        if (this.mAnimator == null || !this.mAnimator.isRunning()) {
            vw(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lKy.getLayoutParams();
            if (layoutParams.rightMargin > (-this.lKB)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.lKB;
                Z(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.lKB)));
            }
            if (this.lKD != null) {
                this.lKD.ck(false);
            }
            this.lKz.completePullRefresh();
        }
    }

    private void Z(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.mAnimator = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.recommendlist.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.lKy.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.lKK.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.lKB));
                a.this.lKy.setLayoutParams(layoutParams);
            }
        });
        this.mAnimator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recommendlist.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.lKy.setCurrentItem(1, false);
                if (i2 == 0) {
                    a.this.lKK.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mAnimator.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lKA) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "recommend_icon"));
            vv(true);
        }
    }

    @Override // com.baidu.live.liveroom.g.b
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (ac(motionEvent) && isOpen()) {
            return d(motionEvent, motionEvent.getActionIndex());
        }
        return false;
    }

    @Override // com.baidu.live.liveroom.g.b
    public boolean Lz() {
        return false;
    }

    public void bKi() {
        if (this.gbu != null) {
            this.gbu.endLoadData();
            this.lKz.setNextPage(null);
        }
    }

    public void bFT() {
        if (this.gbu != null) {
            if (this.gbu.getView().getParent() == null) {
                this.lKz.setNextPage(this.gbu);
            }
            this.gbu.showLoadView();
        }
    }

    private void vw(boolean z) {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            UtilHelper.changeStatusBarIconAndTextColor(z, (Activity) this.mContext);
        }
    }
}
