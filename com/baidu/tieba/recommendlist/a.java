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
import com.baidu.live.data.w;
import com.baidu.live.liveroom.g.b;
import com.baidu.live.liveroom.g.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.AlaListViewPullView;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.c;
import com.baidu.tieba.recommendlist.adapter.RecommendPagerAdapter;
import com.baidu.tieba.recommendlist.data.e;
import com.baidu.tieba.recommendlist.model.b;
import com.baidu.tieba.recommendlist.view.AlaRecommendLiveListView;
import com.baidu.tieba.recommendlist.view.RecommendViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener, b, d, com.baidu.live.u.a {
    private View aEJ;
    private ViewGroup bEg;
    private CommonEmptyView byP;
    private int cardWidth;
    private float cqF;
    private LoadMoreFooter gBa;
    private com.baidu.live.u.b gSf;
    private TbListCommonPullView huF;
    private float lNh;
    private ValueAnimator mAnimator;
    private Context mContext;
    private float mDownX;
    private int mOrientation;
    private int mScreenWidth;
    private int mShowType;
    private TbPageContext mTbPageContext;
    private int mTouchSlop;
    private ViewGroup mvj;
    private RecommendViewPager mvk;
    private AlaRecommendLiveListView mvl;
    private View mvm;
    private int mvn;
    private float mvo;
    private List<AbsDelegateAdapter> mvp;
    private c mvq;
    private final int mvr = 100;
    private int mvs;
    private com.baidu.tieba.recommendlist.model.b mvt;
    private TextView mvu;
    private boolean mvv;
    private w mvw;
    private LinearLayout mvx;
    private View mvy;
    private View mvz;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.mTbPageContext = tbPageContext;
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.mvn = this.mScreenWidth;
            dzl();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.d.AZ().getBoolean("ala_recommend_live_first_show", true)) {
                this.mShowType = 1;
            }
        }
    }

    @Override // com.baidu.live.u.a
    public void a(c cVar) {
        this.mvq = cVar;
    }

    @Override // com.baidu.live.u.a
    public void o(w wVar) {
        this.mvw = wVar;
    }

    @Override // com.baidu.live.u.a
    public void D(int i, int i2) {
        this.mOrientation = i2;
        if (i2 == 2) {
            this.mvm.setVisibility(8);
            if (isOpen()) {
                onClose();
                return;
            }
            return;
        }
        this.mvm.setVisibility(0);
    }

    @Override // com.baidu.live.u.a
    public d OK() {
        return this;
    }

    @Override // com.baidu.live.u.a
    public b OL() {
        return this;
    }

    @Override // com.baidu.live.u.a
    public void a(com.baidu.live.u.b bVar) {
        this.gSf = bVar;
    }

    @Override // com.baidu.live.u.a
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (viewGroup != null) {
            this.bEg = viewGroup;
            this.mvj = viewGroup2;
            dzm();
            dzk();
            if (!this.mvv && com.baidu.live.z.a.Pq().bmJ != null && this.mShowType != 1) {
                long j = com.baidu.live.d.AZ().getLong("ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int Pv = com.baidu.live.z.a.Pq().Pv();
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > Pv) {
                    this.mShowType = 2;
                }
            }
            this.mvs = com.baidu.live.z.a.Pq().Py();
            Ib(0);
        }
    }

    @Override // com.baidu.live.u.a
    public void CT() {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
        if (this.bEg != null) {
            this.bEg.removeView(this.mvk);
            this.bEg.removeView(this.mvy);
        }
        this.mvq = null;
        if (this.mvv) {
            com.baidu.live.d.AZ().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.mvw = null;
        if (this.mvt != null) {
            this.mvt.reset();
        }
    }

    @Override // com.baidu.live.u.a
    public void onDestroy() {
        CT();
        if (this.mvt != null) {
            this.mvt.onDestroy();
        }
    }

    private void dzk() {
        if (this.aEJ == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mvn, -1);
            this.aEJ = LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_content_layout, (ViewGroup) null);
            this.aEJ.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aEJ.findViewById(a.g.right_layout).setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            }
            this.mvz = this.aEJ.findViewById(a.g.block_view);
            this.mvz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.mvx = (LinearLayout) this.aEJ.findViewById(a.g.listView_layout);
            this.mvl = (AlaRecommendLiveListView) this.aEJ.findViewById(a.g.recommendLiveListView);
            this.huF = new AlaListViewPullView(this.mContext);
            this.gBa = new LoadMoreFooter(this.mContext);
            this.gBa.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
            this.gBa.setFooterHeight(this.cardWidth / 2);
            this.gBa.createView();
            Ly();
            this.mvl.addAdapters(this.mvp);
            this.mvl.setPullRefresh(this.huF);
            this.huF.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.recommendlist.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.Ib(0);
                    if (!z) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_RECOMMEND, "pushfresh"));
                    }
                }
            });
            this.mvl.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.recommendlist.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.gBa.isLoading() && a.this.mvt != null && a.this.mvt.hasMore && i + i2 > i3 - 2) {
                        a.this.bMx();
                        a.this.Ib(1);
                    }
                }
            });
        }
        if (this.mvy == null) {
            this.mvy = new View(this.mContext);
            this.mvy.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha65));
            this.mvy.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mvy.setAlpha(0.0f);
        }
        this.bEg.addView(this.mvy);
        if (this.mvk == null) {
            this.mvk = new RecommendViewPager(this.mTbPageContext.getPageActivity());
            this.mvk.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mvk.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.recommendlist.a.4
                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    if (a.this.isOpen() && i == 0) {
                        a.this.mvy.setAlpha(f);
                    }
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    if (i == 0 && a.this.mvk != null) {
                        if (a.this.mvk.getCurrentItem() != 0) {
                            a.this.dzo();
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
            arrayList.add(this.aEJ);
            this.mvk.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.mvn, -1);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = -this.mvn;
            this.mvk.setLayoutParams(layoutParams2);
        }
        this.bEg.addView(this.mvk);
        this.mvk.setCurrentItem(1, false);
        if (this.mvt == null) {
            this.mvt = new com.baidu.tieba.recommendlist.model.b(this.mTbPageContext);
            this.mvt.a(new b.a() { // from class: com.baidu.tieba.recommendlist.a.5
                @Override // com.baidu.tieba.recommendlist.model.b.a
                public void t(List<IAdapterData> list, int i) {
                    a.this.r(list, i);
                }

                @Override // com.baidu.tieba.recommendlist.model.b.a
                public void onFail(int i, String str) {
                    a.this.b(CommonEmptyView.ImgType.SERVER_ERROR);
                }
            });
        }
    }

    private void dzl() {
        this.cardWidth = ((((this.mvn - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds340);
        }
    }

    private void Ly() {
        if (this.mvp == null) {
            this.mvp = new ArrayList();
            this.mvp.add(new com.baidu.tieba.recommendlist.adapter.d(this.mContext, e.mwf));
            this.mvp.add(new com.baidu.tieba.recommendlist.adapter.b(this.mContext, com.baidu.tieba.recommendlist.data.b.mwa));
            this.mvp.add(new com.baidu.tieba.recommendlist.adapter.c(this.mContext, com.baidu.tieba.recommendlist.data.c.mwc, this.cardWidth));
        }
    }

    private void dzm() {
        this.mvm = LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_header_entrance, (ViewGroup) null);
        this.mvm.setId(a.g.ala_sdk_recommend_more_id);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.g.ala_head_line_entry_id);
        this.mvm.setLayoutParams(layoutParams);
        if (this.mvj != null) {
            this.mvj.addView(this.mvm);
        }
        ((TextView) this.mvm.findViewById(a.g.tv_recommend_entrance)).setText(com.baidu.live.z.a.Pq().Pw());
        this.mvm.setOnClickListener(this);
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
                this.cqF = motionEvent.getY(i);
                this.lNh = this.mDownX;
                this.mvo = this.cqF;
                break;
            case 1:
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                float f = this.mDownX - x;
                float f2 = this.cqF - y;
                if (Math.abs(f) < this.mTouchSlop && Math.abs(f2) < this.mTouchSlop && x > 0.0f && x < this.mScreenWidth - this.mvn) {
                    onClose();
                    return true;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mvk.getLayoutParams();
                if (f > this.mTouchSlop) {
                    wB(true);
                    dzn();
                    return true;
                } else if (layoutParams.rightMargin > (-this.mvn)) {
                    onClose();
                    return true;
                }
                break;
            case 2:
                float x2 = motionEvent.getX(i);
                float y2 = motionEvent.getY(i);
                float f3 = this.lNh - x2;
                float f4 = this.mvo - y2;
                this.lNh = x2;
                this.mvo = y2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mvk.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.mvk.setLayoutParams(layoutParams2);
                        this.mvy.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.mvn));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.mvn)) {
                        layoutParams2.rightMargin = i3;
                        this.mvk.setLayoutParams(layoutParams2);
                        this.mvy.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mvn));
                        return true;
                    } else if (i3 < (-this.mvn)) {
                        layoutParams2.rightMargin = -this.mvn;
                        this.mvk.setLayoutParams(layoutParams2);
                        this.mvy.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mvn));
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
        if (motionEvent == null || this.mOrientation == 2 || this.gSf == null) {
            return false;
        }
        return this.gSf.OM();
    }

    private void dzn() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "left_slide"));
    }

    public void wB(boolean z) {
        if ((this.mAnimator == null || !this.mAnimator.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            wC(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mvk.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                ac(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.mvn)));
            }
            if (this.mvq != null) {
                this.mvq.cq(true);
            }
            if (!this.mvv) {
                this.mvv = true;
            }
            this.mvl.completePullRefresh();
            if (z) {
                Ib(0);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", UbcStatConstant.Page.LIVE_RECOMMEND, ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ib(int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            b(CommonEmptyView.ImgType.NO_NET);
            return;
        }
        hideNoDataView();
        long j = 0;
        if (this.mvw != null && this.mvw.mLiveInfo != null) {
            j = this.mvw.mLiveInfo.live_id;
        }
        this.mvt.d(j, i, this.mvs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(List<IAdapterData> list, int i) {
        if (this.mvt.hasMore) {
            bQH();
        } else if (i == 1) {
            bQH();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.mvl.setData(list);
        if (this.mvp != null) {
            for (AbsDelegateAdapter absDelegateAdapter : this.mvp) {
                if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.c) {
                    ((com.baidu.tieba.recommendlist.adapter.c) absDelegateAdapter).setAlaLiveShowData(this.mvw);
                } else if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.b) {
                    ((com.baidu.tieba.recommendlist.adapter.b) absDelegateAdapter).setAlaLiveShowData(this.mvw);
                }
            }
        }
        if ((this.mShowType == 1 || this.mShowType == 2) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            if (this.mShowType == 1) {
                com.baidu.live.d.AZ().putBoolean("ala_recommend_live_first_show", false);
            } else {
                com.baidu.live.d.AZ().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
            }
            this.mShowType = 0;
        }
        this.mvl.completePullRefresh();
        s(list, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.mvt != null && !this.mvt.bzx()) {
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                BdUtilHelper.showToast(this.mContext, a.i.recommend_live_net_weak);
            }
            this.mvl.completePullRefresh();
            return;
        }
        if (this.byP == null) {
            this.byP = new CommonEmptyView(this.mContext);
            ImageView imageView = (ImageView) this.byP.findViewById(a.g.sdk_cev_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds180);
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds180);
            imageView.setLayoutParams(layoutParams);
            ((TextView) this.byP.findViewById(a.g.sdk_cev_title)).setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
            this.mvu = (TextView) this.byP.findViewById(a.g.sdk_cev_refresh_btn);
            this.mvu.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize22));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mvu.getLayoutParams();
            layoutParams2.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds152);
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds54);
            layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds30);
            this.mvu.setLayoutParams(layoutParams2);
            if (this.mvx != null) {
                this.byP.addToParent(this.mvx);
            }
        }
        this.byP.reset();
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
        this.byP.setTitle(i);
        this.byP.setRefreshButton(this.mContext.getResources().getString(a.i.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hideNoDataView();
                a.this.mvl.startPullRefresh();
            }
        });
        this.byP.setup(imgType, CommonEmptyView.StyleType.DARK);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
            this.mvu.setBackgroundResource(a.f.ala_recommend_live_empty_refresh_btn_selector);
        }
        this.byP.setVisibility(0);
        this.mvl.completePullRefresh();
        this.mvl.setData(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.byP != null) {
            this.byP.setVisibility(8);
        }
    }

    @Override // com.baidu.live.u.a
    public void close() {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (this.mvq != null) {
            this.mvq.cq(false);
        }
        wC(false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mvk.getLayoutParams();
        layoutParams.rightMargin = -this.mvn;
        this.mvk.setLayoutParams(layoutParams);
        this.mvk.setCurrentItem(1, false);
        this.mvy.setAlpha(0.0f);
    }

    @Override // com.baidu.live.u.a
    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.mvk.getLayoutParams()).rightMargin > (-this.mvn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzo() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.mvk.getLayoutParams()).rightMargin * 1.0f) / this.mvn);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.mvy.setAlpha(abs);
    }

    @Override // com.baidu.live.u.a
    public void onClose() {
        if (this.mAnimator == null || !this.mAnimator.isRunning()) {
            wC(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mvk.getLayoutParams();
            if (layoutParams.rightMargin > (-this.mvn)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.mvn;
                ac(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.mvn)));
            }
            if (this.mvq != null) {
                this.mvq.cq(false);
            }
            this.mvl.completePullRefresh();
        }
    }

    private void ac(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.mAnimator = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.recommendlist.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.mvk.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.mvy.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.mvn));
                a.this.mvk.setLayoutParams(layoutParams);
            }
        });
        this.mAnimator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recommendlist.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.mvk.setCurrentItem(1, false);
                if (i2 == 0) {
                    a.this.mvy.setAlpha(1.0f);
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
        if (view == this.mvm) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "recommend_icon"));
            wB(true);
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
    public boolean NA() {
        return false;
    }

    public void bQH() {
        if (this.gBa != null) {
            this.gBa.endLoadData();
            this.mvl.setNextPage(null);
        }
    }

    public void bMx() {
        if (this.gBa != null) {
            if (this.gBa.getView().getParent() == null) {
                this.mvl.setNextPage(this.gBa);
            }
            this.gBa.showLoadView();
        }
    }

    private void wC(boolean z) {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            UtilHelper.changeStatusBarIconAndTextColor(z, (Activity) this.mContext);
        }
    }

    private void s(List<IAdapterData> list, int i) {
        boolean z;
        boolean z2;
        if (i == 0 && !ListUtils.isEmpty(list)) {
            Iterator<IAdapterData> it = list.iterator();
            boolean z3 = false;
            boolean z4 = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                IAdapterData next = it.next();
                if (next instanceof e) {
                    int i2 = ((e) next).type;
                    if (i2 == 0) {
                        if (z3) {
                            z4 = true;
                            break;
                        }
                        z = z3;
                        z2 = true;
                        z4 = z2;
                        z3 = z;
                    } else if (1 == i2) {
                        if (z4) {
                            z3 = true;
                            break;
                        }
                        z = true;
                        z2 = z4;
                        z4 = z2;
                        z3 = z;
                    }
                }
                z = z3;
                z2 = z4;
                z4 = z2;
                z3 = z;
            }
            if (z4) {
                Ry("followtab_show");
            }
            if (z3) {
                Ry("hottab_show");
            }
        }
    }

    private void Ry(String str) {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.LIVE_RECOMMEND, str));
    }
}
