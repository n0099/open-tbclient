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
import com.baidu.tieba.recommendlist.model.b;
import com.baidu.tieba.recommendlist.view.AlaRecommendLiveListView;
import com.baidu.tieba.recommendlist.view.RecommendViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener, b, d, com.baidu.live.t.a {
    private View aBw;
    private float bVQ;
    private List<AbsDelegateAdapter> bdV;
    private CommonEmptyView bsN;
    private int cardWidth;
    private TbListCommonPullView gTL;
    private ViewGroup gcM;
    private LoadMoreFooter geH;
    private com.baidu.live.t.b grV;
    private TextView lTA;
    private boolean lTB;
    private u lTC;
    private FrameLayout lTD;
    private View lTE;
    private View lTF;
    private ViewGroup lTr;
    private RecommendViewPager lTs;
    private AlaRecommendLiveListView lTt;
    private View lTu;
    private int lTv;
    private float lTw;
    private c lTx;
    private final int lTy = 100;
    private com.baidu.tieba.recommendlist.model.b lTz;
    private float lls;
    private ValueAnimator mAnimator;
    private Context mContext;
    private float mDownX;
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
            this.lTv = this.mScreenWidth;
            dst();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.c.AR().getBoolean("ala_recommend_live_first_show", true)) {
                this.mShowType = 1;
            }
        }
    }

    @Override // com.baidu.live.t.a
    public void a(c cVar) {
        this.lTx = cVar;
    }

    @Override // com.baidu.live.t.a
    public void p(u uVar) {
        this.lTC = uVar;
    }

    @Override // com.baidu.live.t.a
    public void D(int i, int i2) {
        this.mOrientation = i2;
        if (i2 == 2) {
            this.lTu.setVisibility(8);
            if (isOpen()) {
                onClose();
                return;
            }
            return;
        }
        this.lTu.setVisibility(0);
    }

    @Override // com.baidu.live.t.a
    public d Nh() {
        return this;
    }

    @Override // com.baidu.live.t.a
    public b Ni() {
        return this;
    }

    @Override // com.baidu.live.t.a
    public void a(com.baidu.live.t.b bVar) {
        this.grV = bVar;
    }

    @Override // com.baidu.live.t.a
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (viewGroup != null) {
            this.gcM = viewGroup;
            this.lTr = viewGroup2;
            dsu();
            dss();
            if (!this.lTB && com.baidu.live.x.a.NN().bhy != null && this.mShowType != 1) {
                long j = com.baidu.live.c.AR().getLong("ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int i = com.baidu.live.x.a.NN().bhy.aIN;
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > i) {
                    this.mShowType = 2;
                }
            }
            Hc(0);
        }
    }

    @Override // com.baidu.live.t.a
    public void BQ() {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
        if (this.gcM != null) {
            this.gcM.removeView(this.lTs);
            this.gcM.removeView(this.lTE);
        }
        this.lTx = null;
        if (this.lTB) {
            com.baidu.live.c.AR().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.lTC = null;
        if (this.lTz != null) {
            this.lTz.reset();
        }
    }

    @Override // com.baidu.live.t.a
    public void onDestroy() {
        BQ();
        if (this.lTz != null) {
            this.lTz.onDestroy();
        }
    }

    private void dss() {
        if (this.aBw == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.lTv, -1);
            this.aBw = LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_content_layout, (ViewGroup) null);
            this.aBw.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aBw.findViewById(a.g.right_layout).setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            }
            this.lTF = this.aBw.findViewById(a.g.block_view);
            this.lTF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.lTD = (FrameLayout) this.aBw.findViewById(a.g.listView_layout);
            this.lTt = (AlaRecommendLiveListView) this.aBw.findViewById(a.g.recommendLiveListView);
            this.gTL = new AlaListViewPullView(this.mContext);
            this.lTt.setPullRefresh(this.gTL);
            this.geH = new LoadMoreFooter(this.mContext);
            this.geH.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
            this.geH.setFooterHeight(this.cardWidth / 2);
            this.geH.createView();
            JZ();
            this.lTt.addAdapters(this.bdV);
            this.gTL.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.recommendlist.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.Hc(0);
                    if (!z) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "your_recommend", "pushfresh"));
                    }
                }
            });
            this.lTt.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.recommendlist.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.geH.isLoading() && a.this.lTz != null && a.this.lTz.hasMore && i + i2 > i3 - 2) {
                        a.this.bHj();
                        a.this.Hc(1);
                    }
                }
            });
        }
        if (this.lTE == null) {
            this.lTE = new View(this.mContext);
            this.lTE.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha65));
            this.lTE.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.lTE.setAlpha(0.0f);
        }
        this.gcM.addView(this.lTE);
        if (this.lTs == null) {
            this.lTs = new RecommendViewPager(this.mTbPageContext.getPageActivity());
            this.lTs.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.lTs.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.recommendlist.a.4
                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    if (a.this.isOpen() && i == 0) {
                        a.this.lTE.setAlpha(f);
                    }
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    if (i == 0 && a.this.lTs != null) {
                        if (a.this.lTs.getCurrentItem() != 0) {
                            a.this.dsw();
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
            arrayList.add(this.aBw);
            this.lTs.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.lTv, -1);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = -this.lTv;
            this.lTs.setLayoutParams(layoutParams2);
        }
        this.gcM.addView(this.lTs);
        this.lTs.setCurrentItem(1, false);
        if (this.lTz == null) {
            this.lTz = new com.baidu.tieba.recommendlist.model.b(this.mTbPageContext);
            this.lTz.a(new b.a() { // from class: com.baidu.tieba.recommendlist.a.5
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

    private void dst() {
        this.cardWidth = ((((this.lTv - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds340);
        }
    }

    private void JZ() {
        if (this.bdV == null) {
            this.bdV = new ArrayList();
            this.bdV.add(new com.baidu.tieba.recommendlist.adapter.b(this.mContext, com.baidu.tieba.recommendlist.data.c.lTY));
            this.bdV.add(new com.baidu.tieba.recommendlist.adapter.a(this.mContext, com.baidu.tieba.recommendlist.data.a.lTV, this.cardWidth));
        }
    }

    private void dsu() {
        this.lTu = LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_header_entrance, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
        this.lTu.setLayoutParams(layoutParams);
        if (this.lTr != null) {
            this.lTr.addView(this.lTu);
        }
        this.lTu.setOnClickListener(this);
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
                this.bVQ = motionEvent.getY(i);
                this.lls = this.mDownX;
                this.lTw = this.bVQ;
                break;
            case 1:
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                float f = this.mDownX - x;
                float f2 = this.bVQ - y;
                if (Math.abs(f) < this.mTouchSlop && Math.abs(f2) < this.mTouchSlop && x > 0.0f && x < this.mScreenWidth - this.lTv) {
                    onClose();
                    return true;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lTs.getLayoutParams();
                if (f > this.mTouchSlop) {
                    vD(true);
                    dsv();
                    return true;
                } else if (layoutParams.rightMargin > (-this.lTv)) {
                    onClose();
                    return true;
                }
                break;
            case 2:
                float x2 = motionEvent.getX(i);
                float y2 = motionEvent.getY(i);
                float f3 = this.lls - x2;
                float f4 = this.lTw - y2;
                this.lls = x2;
                this.lTw = y2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.lTs.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.lTs.setLayoutParams(layoutParams2);
                        this.lTE.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.lTv));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.lTv)) {
                        layoutParams2.rightMargin = i3;
                        this.lTs.setLayoutParams(layoutParams2);
                        this.lTE.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.lTv));
                        return true;
                    } else if (i3 < (-this.lTv)) {
                        layoutParams2.rightMargin = -this.lTv;
                        this.lTs.setLayoutParams(layoutParams2);
                        this.lTE.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.lTv));
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
        if (motionEvent == null || this.mOrientation == 2 || this.grV == null) {
            return false;
        }
        return this.grV.Nj();
    }

    private void dsv() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "left_slide"));
    }

    public void vD(boolean z) {
        if ((this.mAnimator == null || !this.mAnimator.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            vE(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lTs.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                ab(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.lTv)));
            }
            if (this.lTx != null) {
                this.lTx.cl(true);
            }
            if (!this.lTB) {
                this.lTB = true;
            }
            this.lTt.completePullRefresh();
            if (z) {
                Hc(0);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", "your_recommend", ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hc(int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            b(CommonEmptyView.ImgType.NO_NET);
            return;
        }
        hideNoDataView();
        long j = 0;
        if (this.lTC != null && this.lTC.mLiveInfo != null) {
            j = this.lTC.mLiveInfo.live_id;
        }
        this.lTz.p(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<IAdapterData> list, int i, int i2) {
        if (this.lTz.hasMore) {
            bLs();
        } else if (i2 == 1) {
            bLs();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.lTt.setData(list);
        if (this.bdV != null) {
            Iterator<AbsDelegateAdapter> it = this.bdV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbsDelegateAdapter next = it.next();
                if (next instanceof com.baidu.tieba.recommendlist.adapter.a) {
                    ((com.baidu.tieba.recommendlist.adapter.a) next).Hd(i);
                    ((com.baidu.tieba.recommendlist.adapter.a) next).f(this.lTC);
                    break;
                }
            }
        }
        if ((this.mShowType == 1 || this.mShowType == 2) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            if (this.mShowType == 1) {
                com.baidu.live.c.AR().putBoolean("ala_recommend_live_first_show", false);
            } else {
                com.baidu.live.c.AR().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
            }
            this.mShowType = 0;
        }
        this.lTt.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.lTz != null && !this.lTz.buU()) {
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                BdUtilHelper.showToast(this.mContext, a.i.recommend_live_net_weak);
            }
            this.lTt.completePullRefresh();
            return;
        }
        if (this.bsN == null) {
            this.bsN = new CommonEmptyView(this.mContext);
            ImageView imageView = (ImageView) this.bsN.findViewById(a.g.sdk_cev_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds180);
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds180);
            imageView.setLayoutParams(layoutParams);
            ((TextView) this.bsN.findViewById(a.g.sdk_cev_title)).setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
            this.lTA = (TextView) this.bsN.findViewById(a.g.sdk_cev_refresh_btn);
            this.lTA.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize22));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lTA.getLayoutParams();
            layoutParams2.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds152);
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds54);
            layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds30);
            this.lTA.setLayoutParams(layoutParams2);
            if (this.lTD != null) {
                this.bsN.addToParent(this.lTD);
            }
        }
        this.bsN.reset();
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
        this.bsN.setTitle(i);
        this.bsN.setRefreshButton(this.mContext.getResources().getString(a.i.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hideNoDataView();
                a.this.lTt.startPullRefresh();
            }
        });
        this.bsN.setup(imgType, CommonEmptyView.StyleType.DARK);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.lTA.setBackgroundResource(a.f.ala_recommend_live_empty_refresh_btn_selector);
        }
        this.bsN.setVisibility(0);
        this.lTt.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bsN != null) {
            this.bsN.setVisibility(8);
        }
    }

    @Override // com.baidu.live.t.a
    public void close() {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (this.lTx != null) {
            this.lTx.cl(false);
        }
        vE(false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lTs.getLayoutParams();
        layoutParams.rightMargin = -this.lTv;
        this.lTs.setLayoutParams(layoutParams);
        this.lTs.setCurrentItem(1, false);
        this.lTE.setAlpha(0.0f);
    }

    @Override // com.baidu.live.t.a
    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.lTs.getLayoutParams()).rightMargin > (-this.lTv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsw() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.lTs.getLayoutParams()).rightMargin * 1.0f) / this.lTv);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.lTE.setAlpha(abs);
    }

    @Override // com.baidu.live.t.a
    public void onClose() {
        if (this.mAnimator == null || !this.mAnimator.isRunning()) {
            vE(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lTs.getLayoutParams();
            if (layoutParams.rightMargin > (-this.lTv)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.lTv;
                ab(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.lTv)));
            }
            if (this.lTx != null) {
                this.lTx.cl(false);
            }
            this.lTt.completePullRefresh();
        }
    }

    private void ab(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.mAnimator = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.recommendlist.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.lTs.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.lTE.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.lTv));
                a.this.lTs.setLayoutParams(layoutParams);
            }
        });
        this.mAnimator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recommendlist.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.lTs.setCurrentItem(1, false);
                if (i2 == 0) {
                    a.this.lTE.setAlpha(1.0f);
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
        if (view == this.lTu) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "recommend_icon"));
            vD(true);
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
    public boolean Mb() {
        return false;
    }

    public void bLs() {
        if (this.geH != null) {
            this.geH.endLoadData();
            this.lTt.setNextPage(null);
        }
    }

    public void bHj() {
        if (this.geH != null) {
            if (this.geH.getView().getParent() == null) {
                this.lTt.setNextPage(this.geH);
            }
            this.geH.showLoadView();
        }
    }

    private void vE(boolean z) {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            UtilHelper.changeStatusBarIconAndTextColor(z, (Activity) this.mContext);
        }
    }
}
