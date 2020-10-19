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
import com.baidu.live.data.u;
import com.baidu.live.liveroom.g.b;
import com.baidu.live.liveroom.g.d;
import com.baidu.live.sdk.a;
import com.baidu.live.t.c;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.AlaListViewPullView;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.recommendlist.adapter.RecommendPagerAdapter;
import com.baidu.tieba.recommendlist.data.e;
import com.baidu.tieba.recommendlist.model.b;
import com.baidu.tieba.recommendlist.view.AlaRecommendLiveListView;
import com.baidu.tieba.recommendlist.view.RecommendViewPager;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener, b, d, com.baidu.live.t.a {
    private View aEB;
    private ViewGroup bBk;
    private CommonEmptyView bwB;
    private int cardWidth;
    private float cif;
    private com.baidu.live.t.b gGq;
    private LoadMoreFooter gqW;
    private TbListCommonPullView hiJ;
    private float lAK;
    private ValueAnimator mAnimator;
    private Context mContext;
    private float mDownX;
    private int mOrientation;
    private int mScreenWidth;
    private int mShowType;
    private TbPageContext mTbPageContext;
    private int mTouchSlop;
    private ViewGroup miM;
    private RecommendViewPager miN;
    private AlaRecommendLiveListView miO;
    private View miP;
    private int miQ;
    private float miR;
    private List<AbsDelegateAdapter> miS;
    private c miT;
    private final int miU = 100;
    private com.baidu.tieba.recommendlist.model.b miV;
    private TextView miW;
    private boolean miX;
    private u miY;
    private LinearLayout miZ;
    private View mja;
    private View mjb;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.mTbPageContext = tbPageContext;
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.miQ = this.mScreenWidth;
            dwe();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.c.AZ().getBoolean("ala_recommend_live_first_show", true)) {
                this.mShowType = 1;
            }
        }
    }

    @Override // com.baidu.live.t.a
    public void a(c cVar) {
        this.miT = cVar;
    }

    @Override // com.baidu.live.t.a
    public void p(u uVar) {
        this.miY = uVar;
    }

    @Override // com.baidu.live.t.a
    public void D(int i, int i2) {
        this.mOrientation = i2;
        if (i2 == 2) {
            this.miP.setVisibility(8);
            if (isOpen()) {
                onClose();
                return;
            }
            return;
        }
        this.miP.setVisibility(0);
    }

    @Override // com.baidu.live.t.a
    public d Om() {
        return this;
    }

    @Override // com.baidu.live.t.a
    public b On() {
        return this;
    }

    @Override // com.baidu.live.t.a
    public void a(com.baidu.live.t.b bVar) {
        this.gGq = bVar;
    }

    @Override // com.baidu.live.t.a
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (viewGroup != null) {
            this.bBk = viewGroup;
            this.miM = viewGroup2;
            dwf();
            dwd();
            if (!this.miX && com.baidu.live.x.a.OS().blo != null && this.mShowType != 1) {
                long j = com.baidu.live.c.AZ().getLong("ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int i = com.baidu.live.x.a.OS().blo.aLR;
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > i) {
                    this.mShowType = 2;
                }
            }
            HI(0);
        }
    }

    @Override // com.baidu.live.t.a
    public void CN() {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
        if (this.bBk != null) {
            this.bBk.removeView(this.miN);
            this.bBk.removeView(this.mja);
        }
        this.miT = null;
        if (this.miX) {
            com.baidu.live.c.AZ().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.miY = null;
        if (this.miV != null) {
            this.miV.reset();
        }
    }

    @Override // com.baidu.live.t.a
    public void onDestroy() {
        CN();
        if (this.miV != null) {
            this.miV.onDestroy();
        }
    }

    private void dwd() {
        if (this.aEB == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.miQ, -1);
            this.aEB = LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_content_layout, (ViewGroup) null);
            this.aEB.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aEB.findViewById(a.g.right_layout).setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            }
            this.mjb = this.aEB.findViewById(a.g.block_view);
            this.mjb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.miZ = (LinearLayout) this.aEB.findViewById(a.g.listView_layout);
            this.miO = (AlaRecommendLiveListView) this.aEB.findViewById(a.g.recommendLiveListView);
            this.hiJ = new AlaListViewPullView(this.mContext);
            this.gqW = new LoadMoreFooter(this.mContext);
            this.gqW.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
            this.gqW.setFooterHeight(this.cardWidth / 2);
            this.gqW.createView();
            Le();
            this.miO.addAdapters(this.miS);
            this.miO.setPullRefresh(this.hiJ);
            this.hiJ.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.recommendlist.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.HI(0);
                    if (!z) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "your_recommend", "pushfresh"));
                    }
                }
            });
            this.miO.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.recommendlist.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.gqW.isLoading() && a.this.miV != null && a.this.miV.hasMore && i + i2 > i3 - 2) {
                        a.this.bJV();
                        a.this.HI(1);
                    }
                }
            });
        }
        if (this.mja == null) {
            this.mja = new View(this.mContext);
            this.mja.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha65));
            this.mja.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mja.setAlpha(0.0f);
        }
        this.bBk.addView(this.mja);
        if (this.miN == null) {
            this.miN = new RecommendViewPager(this.mTbPageContext.getPageActivity());
            this.miN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.miN.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.recommendlist.a.4
                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    if (a.this.isOpen() && i == 0) {
                        a.this.mja.setAlpha(f);
                    }
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    if (i == 0 && a.this.miN != null) {
                        if (a.this.miN.getCurrentItem() != 0) {
                            a.this.dwh();
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
            arrayList.add(this.aEB);
            this.miN.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.miQ, -1);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = -this.miQ;
            this.miN.setLayoutParams(layoutParams2);
        }
        this.bBk.addView(this.miN);
        this.miN.setCurrentItem(1, false);
        if (this.miV == null) {
            this.miV = new com.baidu.tieba.recommendlist.model.b(this.mTbPageContext);
            this.miV.a(new b.a() { // from class: com.baidu.tieba.recommendlist.a.5
                @Override // com.baidu.tieba.recommendlist.model.b.a
                public void s(List<IAdapterData> list, int i) {
                    a.this.r(list, i);
                }

                @Override // com.baidu.tieba.recommendlist.model.b.a
                public void onFail(int i, String str) {
                    a.this.b(CommonEmptyView.ImgType.SERVER_ERROR);
                }
            });
        }
    }

    private void dwe() {
        this.cardWidth = ((((this.miQ - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds340);
        }
    }

    private void Le() {
        if (this.miS == null) {
            this.miS = new ArrayList();
            this.miS.add(new com.baidu.tieba.recommendlist.adapter.d(this.mContext, e.mjF));
            this.miS.add(new com.baidu.tieba.recommendlist.adapter.b(this.mContext, com.baidu.tieba.recommendlist.data.b.mjA));
            this.miS.add(new com.baidu.tieba.recommendlist.adapter.c(this.mContext, com.baidu.tieba.recommendlist.data.c.mjC, this.cardWidth));
        }
    }

    private void dwf() {
        this.miP = LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_header_entrance, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
        this.miP.setLayoutParams(layoutParams);
        if (this.miM != null) {
            this.miM.addView(this.miP);
        }
        this.miP.setOnClickListener(this);
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
                this.cif = motionEvent.getY(i);
                this.lAK = this.mDownX;
                this.miR = this.cif;
                break;
            case 1:
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                float f = this.mDownX - x;
                float f2 = this.cif - y;
                if (Math.abs(f) < this.mTouchSlop && Math.abs(f2) < this.mTouchSlop && x > 0.0f && x < this.mScreenWidth - this.miQ) {
                    onClose();
                    return true;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.miN.getLayoutParams();
                if (f > this.mTouchSlop) {
                    wk(true);
                    dwg();
                    return true;
                } else if (layoutParams.rightMargin > (-this.miQ)) {
                    onClose();
                    return true;
                }
                break;
            case 2:
                float x2 = motionEvent.getX(i);
                float y2 = motionEvent.getY(i);
                float f3 = this.lAK - x2;
                float f4 = this.miR - y2;
                this.lAK = x2;
                this.miR = y2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.miN.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.miN.setLayoutParams(layoutParams2);
                        this.mja.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.miQ));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.miQ)) {
                        layoutParams2.rightMargin = i3;
                        this.miN.setLayoutParams(layoutParams2);
                        this.mja.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.miQ));
                        return true;
                    } else if (i3 < (-this.miQ)) {
                        layoutParams2.rightMargin = -this.miQ;
                        this.miN.setLayoutParams(layoutParams2);
                        this.mja.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.miQ));
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
        if (motionEvent == null || this.mOrientation == 2 || this.gGq == null) {
            return false;
        }
        return this.gGq.Oo();
    }

    private void dwg() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "left_slide"));
    }

    public void wk(boolean z) {
        if ((this.mAnimator == null || !this.mAnimator.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            wl(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.miN.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                ab(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.miQ)));
            }
            if (this.miT != null) {
                this.miT.co(true);
            }
            if (!this.miX) {
                this.miX = true;
            }
            this.miO.completePullRefresh();
            if (z) {
                HI(0);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", "your_recommend", ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HI(int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            b(CommonEmptyView.ImgType.NO_NET);
            return;
        }
        hideNoDataView();
        long j = 0;
        if (this.miY != null && this.miY.mLiveInfo != null) {
            j = this.miY.mLiveInfo.live_id;
        }
        this.miV.t(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(List<IAdapterData> list, int i) {
        if (this.miV.hasMore) {
            bOc();
        } else if (i == 1) {
            bOc();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.miO.setData(list);
        if (this.miS != null) {
            for (AbsDelegateAdapter absDelegateAdapter : this.miS) {
                if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.c) {
                    ((com.baidu.tieba.recommendlist.adapter.c) absDelegateAdapter).g(this.miY);
                } else if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.b) {
                    ((com.baidu.tieba.recommendlist.adapter.b) absDelegateAdapter).g(this.miY);
                }
            }
        }
        if ((this.mShowType == 1 || this.mShowType == 2) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            if (this.mShowType == 1) {
                com.baidu.live.c.AZ().putBoolean("ala_recommend_live_first_show", false);
            } else {
                com.baidu.live.c.AZ().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
            }
            this.mShowType = 0;
        }
        this.miO.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.miV != null && !this.miV.bxE()) {
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                BdUtilHelper.showToast(this.mContext, a.i.recommend_live_net_weak);
            }
            this.miO.completePullRefresh();
            return;
        }
        if (this.bwB == null) {
            this.bwB = new CommonEmptyView(this.mContext);
            ImageView imageView = (ImageView) this.bwB.findViewById(a.g.sdk_cev_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds180);
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds180);
            imageView.setLayoutParams(layoutParams);
            ((TextView) this.bwB.findViewById(a.g.sdk_cev_title)).setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
            this.miW = (TextView) this.bwB.findViewById(a.g.sdk_cev_refresh_btn);
            this.miW.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize22));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.miW.getLayoutParams();
            layoutParams2.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds152);
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds54);
            layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds30);
            this.miW.setLayoutParams(layoutParams2);
            if (this.miZ != null) {
                this.bwB.addToParent(this.miZ);
            }
        }
        this.bwB.reset();
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
        this.bwB.setTitle(i);
        this.bwB.setRefreshButton(this.mContext.getResources().getString(a.i.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hideNoDataView();
                a.this.miO.startPullRefresh();
            }
        });
        this.bwB.setup(imgType, CommonEmptyView.StyleType.DARK);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
            this.miW.setBackgroundResource(a.f.ala_recommend_live_empty_refresh_btn_selector);
        }
        this.bwB.setVisibility(0);
        this.miO.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bwB != null) {
            this.bwB.setVisibility(8);
        }
    }

    @Override // com.baidu.live.t.a
    public void close() {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (this.miT != null) {
            this.miT.co(false);
        }
        wl(false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.miN.getLayoutParams();
        layoutParams.rightMargin = -this.miQ;
        this.miN.setLayoutParams(layoutParams);
        this.miN.setCurrentItem(1, false);
        this.mja.setAlpha(0.0f);
    }

    @Override // com.baidu.live.t.a
    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.miN.getLayoutParams()).rightMargin > (-this.miQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwh() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.miN.getLayoutParams()).rightMargin * 1.0f) / this.miQ);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.mja.setAlpha(abs);
    }

    @Override // com.baidu.live.t.a
    public void onClose() {
        if (this.mAnimator == null || !this.mAnimator.isRunning()) {
            wl(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.miN.getLayoutParams();
            if (layoutParams.rightMargin > (-this.miQ)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.miQ;
                ab(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.miQ)));
            }
            if (this.miT != null) {
                this.miT.co(false);
            }
            this.miO.completePullRefresh();
        }
    }

    private void ab(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.mAnimator = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.recommendlist.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.miN.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.mja.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.miQ));
                a.this.miN.setLayoutParams(layoutParams);
            }
        });
        this.mAnimator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recommendlist.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.miN.setCurrentItem(1, false);
                if (i2 == 0) {
                    a.this.mja.setAlpha(1.0f);
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
        if (view == this.miP) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "recommend_icon"));
            wk(true);
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
    public boolean Ng() {
        return false;
    }

    public void bOc() {
        if (this.gqW != null) {
            this.gqW.endLoadData();
            this.miO.setNextPage(null);
        }
    }

    public void bJV() {
        if (this.gqW != null) {
            if (this.gqW.getView().getParent() == null) {
                this.miO.setNextPage(this.gqW);
            }
            this.gqW.showLoadView();
        }
    }

    private void wl(boolean z) {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            UtilHelper.changeStatusBarIconAndTextColor(z, (Activity) this.mContext);
        }
    }
}
