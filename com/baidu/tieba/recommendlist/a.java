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
    private View aAO;
    private List<AbsDelegateAdapter> bbu;
    private CommonEmptyView bpB;
    private int cardWidth;
    private ViewGroup fZu;
    private TbListCommonPullView gPZ;
    private LoadMoreFooter gbq;
    private com.baidu.live.r.b goD;
    private ViewGroup lKk;
    private RecommendViewPager lKl;
    private AlaRecommendLiveListView lKm;
    private View lKn;
    private int lKo;
    private float lKp;
    private c lKq;
    private final int lKr = 100;
    private com.baidu.tieba.recommendlist.model.b lKs;
    private TextView lKt;
    private boolean lKu;
    private r lKv;
    private FrameLayout lKw;
    private View lKx;
    private View lKy;
    private float lcu;
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
            this.lKo = this.mScreenWidth;
            doG();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.c.AD().getBoolean("ala_recommend_live_first_show", true)) {
                this.mShowType = 1;
            }
        }
    }

    @Override // com.baidu.live.r.a
    public void a(c cVar) {
        this.lKq = cVar;
    }

    @Override // com.baidu.live.r.a
    public void o(r rVar) {
        this.lKv = rVar;
    }

    @Override // com.baidu.live.r.a
    public void D(int i, int i2) {
        this.mOrientation = i2;
        if (i2 == 2) {
            this.lKn.setVisibility(8);
            if (isOpen()) {
                onClose();
                return;
            }
            return;
        }
        this.lKn.setVisibility(0);
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
        this.goD = bVar;
    }

    @Override // com.baidu.live.r.a
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (viewGroup != null) {
            this.fZu = viewGroup;
            this.lKk = viewGroup2;
            doH();
            doF();
            if (!this.lKu && com.baidu.live.w.a.Nk().beH != null && this.mShowType != 1) {
                long j = com.baidu.live.c.AD().getLong("ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int i = com.baidu.live.w.a.Nk().beH.aHu;
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
        if (this.fZu != null) {
            this.fZu.removeView(this.lKl);
            this.fZu.removeView(this.lKx);
        }
        this.lKq = null;
        if (this.lKu) {
            com.baidu.live.c.AD().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.lKv = null;
        if (this.lKs != null) {
            this.lKs.reset();
        }
    }

    @Override // com.baidu.live.r.a
    public void onDestroy() {
        BB();
        if (this.lKs != null) {
            this.lKs.onDestroy();
        }
    }

    private void doF() {
        if (this.aAO == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.lKo, -1);
            this.aAO = LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_content_layout, (ViewGroup) null);
            this.aAO.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aAO.findViewById(a.g.right_layout).setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            }
            this.lKy = this.aAO.findViewById(a.g.block_view);
            this.lKy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.lKw = (FrameLayout) this.aAO.findViewById(a.g.listView_layout);
            this.lKm = (AlaRecommendLiveListView) this.aAO.findViewById(a.g.recommendLiveListView);
            this.gPZ = new AlaListViewPullView(this.mContext);
            this.lKm.setPullRefresh(this.gPZ);
            this.gbq = new LoadMoreFooter(this.mContext);
            this.gbq.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
            this.gbq.setFooterHeight(this.cardWidth / 2);
            this.gbq.createView();
            Jv();
            this.lKm.addAdapters(this.bbu);
            this.gPZ.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.recommendlist.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.GB(0);
                    if (!z) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "your_recommend", "pushfresh"));
                    }
                }
            });
            this.lKm.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.recommendlist.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.gbq.isLoading() && a.this.lKs != null && a.this.lKs.hasMore && i + i2 > i3 - 2) {
                        a.this.bFS();
                        a.this.GB(1);
                    }
                }
            });
        }
        if (this.lKx == null) {
            this.lKx = new View(this.mContext);
            this.lKx.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha65));
            this.lKx.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.lKx.setAlpha(0.0f);
        }
        this.fZu.addView(this.lKx);
        if (this.lKl == null) {
            this.lKl = new RecommendViewPager(this.mTbPageContext.getPageActivity());
            this.lKl.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.lKl.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.recommendlist.a.4
                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    if (a.this.isOpen() && i == 0) {
                        a.this.lKx.setAlpha(f);
                    }
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    if (i == 0 && a.this.lKl != null) {
                        if (a.this.lKl.getCurrentItem() != 0) {
                            a.this.doJ();
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
            arrayList.add(this.aAO);
            this.lKl.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.lKo, -1);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = -this.lKo;
            this.lKl.setLayoutParams(layoutParams2);
        }
        this.fZu.addView(this.lKl);
        this.lKl.setCurrentItem(1, false);
        if (this.lKs == null) {
            this.lKs = new com.baidu.tieba.recommendlist.model.b(this.mTbPageContext);
            this.lKs.a(new b.a() { // from class: com.baidu.tieba.recommendlist.a.5
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

    private void doG() {
        this.cardWidth = ((((this.lKo - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds340);
        }
    }

    private void Jv() {
        if (this.bbu == null) {
            this.bbu = new ArrayList();
            this.bbu.add(new com.baidu.tieba.recommendlist.adapter.b(this.mContext, com.baidu.tieba.recommendlist.data.c.lKR));
            this.bbu.add(new com.baidu.tieba.recommendlist.adapter.a(this.mContext, com.baidu.tieba.recommendlist.data.a.lKO, this.cardWidth));
        }
    }

    private void doH() {
        this.lKn = LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_header_entrance, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
        this.lKn.setLayoutParams(layoutParams);
        if (this.lKk != null) {
            this.lKk.addView(this.lKn);
        }
        this.lKn.setOnClickListener(this);
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
                this.lcu = this.mDownX;
                this.lKp = this.mDownY;
                break;
            case 1:
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                float f = this.mDownX - x;
                float f2 = this.mDownY - y;
                if (Math.abs(f) < this.mTouchSlop && Math.abs(f2) < this.mTouchSlop && x > 0.0f && x < this.mScreenWidth - this.lKo) {
                    onClose();
                    return true;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lKl.getLayoutParams();
                if (f > this.mTouchSlop) {
                    vt(true);
                    doI();
                    return true;
                } else if (layoutParams.rightMargin > (-this.lKo)) {
                    onClose();
                    return true;
                }
                break;
            case 2:
                float x2 = motionEvent.getX(i);
                float y2 = motionEvent.getY(i);
                float f3 = this.lcu - x2;
                float f4 = this.lKp - y2;
                this.lcu = x2;
                this.lKp = y2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.lKl.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.lKl.setLayoutParams(layoutParams2);
                        this.lKx.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.lKo));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.lKo)) {
                        layoutParams2.rightMargin = i3;
                        this.lKl.setLayoutParams(layoutParams2);
                        this.lKx.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.lKo));
                        return true;
                    } else if (i3 < (-this.lKo)) {
                        layoutParams2.rightMargin = -this.lKo;
                        this.lKl.setLayoutParams(layoutParams2);
                        this.lKx.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.lKo));
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
        if (motionEvent == null || this.mOrientation == 2 || this.goD == null) {
            return false;
        }
        return this.goD.MB();
    }

    private void doI() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "left_slide"));
    }

    public void vt(boolean z) {
        if ((this.mAnimator == null || !this.mAnimator.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            vu(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lKl.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                Z(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.lKo)));
            }
            if (this.lKq != null) {
                this.lKq.cj(true);
            }
            if (!this.lKu) {
                this.lKu = true;
            }
            this.lKm.completePullRefresh();
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
        if (this.lKv != null && this.lKv.mLiveInfo != null) {
            j = this.lKv.mLiveInfo.live_id;
        }
        this.lKs.m(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<IAdapterData> list, int i, int i2) {
        if (this.lKs.hasMore) {
            bKh();
        } else if (i2 == 1) {
            bKh();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.lKm.setData(list);
        if (this.bbu != null) {
            Iterator<AbsDelegateAdapter> it = this.bbu.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbsDelegateAdapter next = it.next();
                if (next instanceof com.baidu.tieba.recommendlist.adapter.a) {
                    ((com.baidu.tieba.recommendlist.adapter.a) next).GC(i);
                    ((com.baidu.tieba.recommendlist.adapter.a) next).e(this.lKv);
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
        this.lKm.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.lKs != null && !this.lKs.btP()) {
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                BdUtilHelper.showToast(this.mContext, a.i.recommend_live_net_weak);
            }
            this.lKm.completePullRefresh();
            return;
        }
        if (this.bpB == null) {
            this.bpB = new CommonEmptyView(this.mContext);
            ImageView imageView = (ImageView) this.bpB.findViewById(a.g.sdk_cev_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds180);
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds180);
            imageView.setLayoutParams(layoutParams);
            ((TextView) this.bpB.findViewById(a.g.sdk_cev_title)).setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
            this.lKt = (TextView) this.bpB.findViewById(a.g.sdk_cev_refresh_btn);
            this.lKt.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize22));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lKt.getLayoutParams();
            layoutParams2.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds152);
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds54);
            layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds30);
            this.lKt.setLayoutParams(layoutParams2);
            if (this.lKw != null) {
                this.bpB.addToParent(this.lKw);
            }
        }
        this.bpB.reset();
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
        this.bpB.setTitle(i);
        this.bpB.setRefreshButton(this.mContext.getResources().getString(a.i.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hideNoDataView();
                a.this.lKm.startPullRefresh();
            }
        });
        this.bpB.setup(imgType, CommonEmptyView.StyleType.DARK);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.lKt.setBackgroundResource(a.f.ala_recommend_live_empty_refresh_btn_selector);
        }
        this.bpB.setVisibility(0);
        this.lKm.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bpB != null) {
            this.bpB.setVisibility(8);
        }
    }

    @Override // com.baidu.live.r.a
    public void close() {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (this.lKq != null) {
            this.lKq.cj(false);
        }
        vu(false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lKl.getLayoutParams();
        layoutParams.rightMargin = -this.lKo;
        this.lKl.setLayoutParams(layoutParams);
        this.lKl.setCurrentItem(1, false);
        this.lKx.setAlpha(0.0f);
    }

    @Override // com.baidu.live.r.a
    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.lKl.getLayoutParams()).rightMargin > (-this.lKo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doJ() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.lKl.getLayoutParams()).rightMargin * 1.0f) / this.lKo);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.lKx.setAlpha(abs);
    }

    @Override // com.baidu.live.r.a
    public void onClose() {
        if (this.mAnimator == null || !this.mAnimator.isRunning()) {
            vu(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lKl.getLayoutParams();
            if (layoutParams.rightMargin > (-this.lKo)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.lKo;
                Z(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.lKo)));
            }
            if (this.lKq != null) {
                this.lKq.cj(false);
            }
            this.lKm.completePullRefresh();
        }
    }

    private void Z(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.mAnimator = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.recommendlist.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.lKl.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.lKx.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.lKo));
                a.this.lKl.setLayoutParams(layoutParams);
            }
        });
        this.mAnimator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recommendlist.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.lKl.setCurrentItem(1, false);
                if (i2 == 0) {
                    a.this.lKx.setAlpha(1.0f);
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
        if (view == this.lKn) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "recommend_icon"));
            vt(true);
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

    public void bKh() {
        if (this.gbq != null) {
            this.gbq.endLoadData();
            this.lKm.setNextPage(null);
        }
    }

    public void bFS() {
        if (this.gbq != null) {
            if (this.gbq.getView().getParent() == null) {
                this.lKm.setNextPage(this.gbq);
            }
            this.gbq.showLoadView();
        }
    }

    private void vu(boolean z) {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            UtilHelper.changeStatusBarIconAndTextColor(z, (Activity) this.mContext);
        }
    }
}
