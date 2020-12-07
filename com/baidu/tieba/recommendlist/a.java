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
import com.baidu.live.z.c;
import com.baidu.tieba.recommendlist.adapter.RecommendPagerAdapter;
import com.baidu.tieba.recommendlist.data.e;
import com.baidu.tieba.recommendlist.model.b;
import com.baidu.tieba.recommendlist.view.AlaRecommendLiveListView;
import com.baidu.tieba.recommendlist.view.RecommendViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener, b, d, com.baidu.live.z.a {
    private View aGu;
    private CommonEmptyView bIx;
    private ViewGroup bNk;
    private float cBL;
    private int cardWidth;
    private LoadMoreFooter gPC;
    private TbListCommonPullView hJO;
    private com.baidu.live.z.b hhv;
    private ValueAnimator mAnimator;
    private Context mContext;
    private float mDownX;
    private int mOrientation;
    private ViewGroup mPN;
    private RecommendViewPager mPO;
    private AlaRecommendLiveListView mPP;
    private View mPQ;
    private int mPR;
    private float mPS;
    private List<AbsDelegateAdapter> mPT;
    private c mPU;
    private final int mPV = 100;
    private int mPW;
    private com.baidu.tieba.recommendlist.model.b mPX;
    private TextView mPY;
    private boolean mPZ;
    private w mQa;
    private LinearLayout mQb;
    private View mQc;
    private View mQd;
    private int mScreenWidth;
    private int mShowType;
    private TbPageContext mTbPageContext;
    private int mTouchSlop;
    private float mhy;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.mTbPageContext = tbPageContext;
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.mPR = this.mScreenWidth;
            coE();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.d.BM().getBoolean("ala_recommend_live_first_show", true)) {
                this.mShowType = 1;
            }
        }
    }

    @Override // com.baidu.live.z.a
    public void a(c cVar) {
        this.mPU = cVar;
    }

    @Override // com.baidu.live.z.a
    public void n(w wVar) {
        this.mQa = wVar;
    }

    @Override // com.baidu.live.z.a
    public void C(int i, int i2) {
        this.mOrientation = i2;
        if (i2 == 2) {
            this.mPQ.setVisibility(8);
            if (isOpen()) {
                onClose();
                return;
            }
            return;
        }
        this.mPQ.setVisibility(0);
    }

    @Override // com.baidu.live.z.a
    public d QV() {
        return this;
    }

    @Override // com.baidu.live.z.a
    public b QW() {
        return this;
    }

    @Override // com.baidu.live.z.a
    public void a(com.baidu.live.z.b bVar) {
        this.hhv = bVar;
    }

    @Override // com.baidu.live.z.a
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (viewGroup != null) {
            this.bNk = viewGroup;
            this.mPN = viewGroup2;
            dGD();
            dGC();
            if (!this.mPZ && com.baidu.live.ae.a.RB().brA != null && this.mShowType != 1) {
                long j = com.baidu.live.d.BM().getLong("ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int RH = com.baidu.live.ae.a.RB().RH();
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > RH) {
                    this.mShowType = 2;
                }
            }
            this.mPW = com.baidu.live.ae.a.RB().RK();
            JG(0);
        }
    }

    @Override // com.baidu.live.z.a
    public void En() {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
        if (this.bNk != null) {
            this.bNk.removeView(this.mPO);
            this.bNk.removeView(this.mQc);
        }
        this.mPU = null;
        if (this.mPZ) {
            com.baidu.live.d.BM().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.mQa = null;
        if (this.mPX != null) {
            this.mPX.reset();
        }
    }

    @Override // com.baidu.live.z.a
    public void onDestroy() {
        En();
        if (this.mPX != null) {
            this.mPX.onDestroy();
        }
    }

    private void dGC() {
        if (this.aGu == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mPR, -1);
            this.aGu = LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_content_layout, (ViewGroup) null);
            this.aGu.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aGu.findViewById(a.f.right_layout).setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            }
            this.mQd = this.aGu.findViewById(a.f.block_view);
            this.mQd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.mQb = (LinearLayout) this.aGu.findViewById(a.f.listView_layout);
            this.mPP = (AlaRecommendLiveListView) this.aGu.findViewById(a.f.recommendLiveListView);
            this.hJO = new AlaListViewPullView(this.mContext);
            this.gPC = new LoadMoreFooter(this.mContext);
            this.gPC.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
            this.gPC.setFooterHeight(this.cardWidth / 2);
            this.gPC.createView();
            Nt();
            this.mPP.addAdapters(this.mPT);
            this.mPP.setPullRefresh(this.hJO);
            this.hJO.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.recommendlist.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.JG(0);
                    if (!z) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_RECOMMEND, "pushfresh"));
                    }
                }
            });
            this.mPP.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.recommendlist.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.gPC.isLoading() && a.this.mPX != null && a.this.mPX.hasMore && i + i2 > i3 - 2) {
                        a.this.bSb();
                        a.this.JG(1);
                    }
                }
            });
        }
        if (this.mQc == null) {
            this.mQc = new View(this.mContext);
            this.mQc.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha65));
            this.mQc.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mQc.setAlpha(0.0f);
        }
        this.bNk.addView(this.mQc);
        if (this.mPO == null) {
            this.mPO = new RecommendViewPager(this.mTbPageContext.getPageActivity());
            this.mPO.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mPO.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.recommendlist.a.4
                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    if (a.this.isOpen() && i == 0) {
                        a.this.mQc.setAlpha(f);
                    }
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    if (i == 0 && a.this.mPO != null) {
                        if (a.this.mPO.getCurrentItem() != 0) {
                            a.this.dGF();
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
            arrayList.add(this.aGu);
            this.mPO.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.mPR, -1);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = -this.mPR;
            this.mPO.setLayoutParams(layoutParams2);
        }
        this.bNk.addView(this.mPO);
        this.mPO.setCurrentItem(1, false);
        if (this.mPX == null) {
            this.mPX = new com.baidu.tieba.recommendlist.model.b(this.mTbPageContext);
            this.mPX.a(new b.a() { // from class: com.baidu.tieba.recommendlist.a.5
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

    private void coE() {
        this.cardWidth = ((((this.mPR - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds340);
        }
    }

    private void Nt() {
        if (this.mPT == null) {
            this.mPT = new ArrayList();
            this.mPT.add(new com.baidu.tieba.recommendlist.adapter.d(this.mContext, e.mQC));
            this.mPT.add(new com.baidu.tieba.recommendlist.adapter.b(this.mContext, com.baidu.tieba.recommendlist.data.b.mQx));
            this.mPT.add(new com.baidu.tieba.recommendlist.adapter.c(this.mContext, com.baidu.tieba.recommendlist.data.c.mQz, this.cardWidth));
        }
    }

    private void dGD() {
        this.mPQ = LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_header_entrance, (ViewGroup) null);
        this.mPQ.setId(a.f.ala_sdk_recommend_more_id);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.f.ala_head_line_entry_id);
        this.mPQ.setLayoutParams(layoutParams);
        if (this.mPN != null) {
            this.mPN.addView(this.mPQ);
        }
        ((TextView) this.mPQ.findViewById(a.f.tv_recommend_entrance)).setText(com.baidu.live.ae.a.RB().RI());
        this.mPQ.setOnClickListener(this);
    }

    @Override // com.baidu.live.liveroom.g.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!ad(motionEvent)) {
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
                this.cBL = motionEvent.getY(i);
                this.mhy = this.mDownX;
                this.mPS = this.cBL;
                break;
            case 1:
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                float f = this.mDownX - x;
                float f2 = this.cBL - y;
                if (Math.abs(f) < this.mTouchSlop && Math.abs(f2) < this.mTouchSlop && x > 0.0f && x < this.mScreenWidth - this.mPR) {
                    onClose();
                    return true;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPO.getLayoutParams();
                if (f > this.mTouchSlop) {
                    xr(true);
                    dGE();
                    return true;
                } else if (layoutParams.rightMargin > (-this.mPR)) {
                    onClose();
                    return true;
                }
                break;
            case 2:
                float x2 = motionEvent.getX(i);
                float y2 = motionEvent.getY(i);
                float f3 = this.mhy - x2;
                float f4 = this.mPS - y2;
                this.mhy = x2;
                this.mPS = y2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mPO.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.mPO.setLayoutParams(layoutParams2);
                        this.mQc.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.mPR));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.mPR)) {
                        layoutParams2.rightMargin = i3;
                        this.mPO.setLayoutParams(layoutParams2);
                        this.mQc.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mPR));
                        return true;
                    } else if (i3 < (-this.mPR)) {
                        layoutParams2.rightMargin = -this.mPR;
                        this.mPO.setLayoutParams(layoutParams2);
                        this.mQc.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mPR));
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

    private boolean ad(MotionEvent motionEvent) {
        if (motionEvent == null || this.mOrientation == 2 || this.hhv == null) {
            return false;
        }
        return this.hhv.QX();
    }

    private void dGE() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "left_slide"));
    }

    public void xr(boolean z) {
        if ((this.mAnimator == null || !this.mAnimator.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            xs(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPO.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                ad(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.mPR)));
            }
            if (this.mPU != null) {
                this.mPU.cH(true);
            }
            if (!this.mPZ) {
                this.mPZ = true;
            }
            this.mPP.completePullRefresh();
            if (z) {
                JG(0);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", UbcStatConstant.Page.LIVE_RECOMMEND, ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JG(int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            b(CommonEmptyView.ImgType.NO_NET);
            return;
        }
        hideNoDataView();
        long j = 0;
        if (this.mQa != null && this.mQa.mLiveInfo != null) {
            j = this.mQa.mLiveInfo.live_id;
        }
        this.mPX.g(j, i, this.mPW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(List<IAdapterData> list, int i) {
        if (this.mPX.hasMore) {
            bWk();
        } else if (i == 1) {
            bWk();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.mPP.setData(list);
        if (this.mPT != null) {
            for (AbsDelegateAdapter absDelegateAdapter : this.mPT) {
                if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.c) {
                    ((com.baidu.tieba.recommendlist.adapter.c) absDelegateAdapter).setAlaLiveShowData(this.mQa);
                } else if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.b) {
                    ((com.baidu.tieba.recommendlist.adapter.b) absDelegateAdapter).setAlaLiveShowData(this.mQa);
                }
            }
        }
        if ((this.mShowType == 1 || this.mShowType == 2) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            if (this.mShowType == 1) {
                com.baidu.live.d.BM().putBoolean("ala_recommend_live_first_show", false);
            } else {
                com.baidu.live.d.BM().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
            }
            this.mShowType = 0;
        }
        this.mPP.completePullRefresh();
        s(list, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.mPX != null && !this.mPX.bEO()) {
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                BdUtilHelper.showToast(this.mContext, a.h.recommend_live_net_weak);
            }
            this.mPP.completePullRefresh();
            return;
        }
        if (this.bIx == null) {
            this.bIx = new CommonEmptyView(this.mContext);
            ImageView imageView = (ImageView) this.bIx.findViewById(a.f.sdk_cev_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
            imageView.setLayoutParams(layoutParams);
            ((TextView) this.bIx.findViewById(a.f.sdk_cev_title)).setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
            this.mPY = (TextView) this.bIx.findViewById(a.f.sdk_cev_refresh_btn);
            this.mPY.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize22));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mPY.getLayoutParams();
            layoutParams2.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds152);
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds54);
            layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds30);
            this.mPY.setLayoutParams(layoutParams2);
            if (this.mQb != null) {
                this.bIx.addToParent(this.mQb);
            }
        }
        this.bIx.reset();
        switch (imgType) {
            case NO_NET:
                i = a.h.recommend_live_no_net;
                break;
            case SERVER_ERROR:
                i = a.h.recommend_live_no_response;
                break;
            default:
                i = a.h.recommend_live_no_data;
                break;
        }
        this.bIx.setTitle(i);
        this.bIx.setRefreshButton(this.mContext.getResources().getString(a.h.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hideNoDataView();
                a.this.mPP.startPullRefresh();
            }
        });
        this.bIx.setup(imgType, CommonEmptyView.StyleType.DARK);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
            this.mPY.setBackgroundResource(a.e.ala_recommend_live_empty_refresh_btn_selector);
        }
        this.bIx.setVisibility(0);
        this.mPP.completePullRefresh();
        this.mPP.setData(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bIx != null) {
            this.bIx.setVisibility(8);
        }
    }

    @Override // com.baidu.live.z.a
    public void close() {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (this.mPU != null) {
            this.mPU.cH(false);
        }
        xs(false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPO.getLayoutParams();
        layoutParams.rightMargin = -this.mPR;
        this.mPO.setLayoutParams(layoutParams);
        this.mPO.setCurrentItem(1, false);
        this.mQc.setAlpha(0.0f);
    }

    @Override // com.baidu.live.z.a
    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.mPO.getLayoutParams()).rightMargin > (-this.mPR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGF() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.mPO.getLayoutParams()).rightMargin * 1.0f) / this.mPR);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.mQc.setAlpha(abs);
    }

    @Override // com.baidu.live.z.a
    public void onClose() {
        if (this.mAnimator == null || !this.mAnimator.isRunning()) {
            xs(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPO.getLayoutParams();
            if (layoutParams.rightMargin > (-this.mPR)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.mPR;
                ad(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.mPR)));
            }
            if (this.mPU != null) {
                this.mPU.cH(false);
            }
            this.mPP.completePullRefresh();
        }
    }

    private void ad(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.mAnimator = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.recommendlist.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.mPO.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.mQc.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.mPR));
                a.this.mPO.setLayoutParams(layoutParams);
            }
        });
        this.mAnimator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recommendlist.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.mPO.setCurrentItem(1, false);
                if (i2 == 0) {
                    a.this.mQc.setAlpha(1.0f);
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
        if (view == this.mPQ) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "recommend_icon"));
            xr(true);
        }
    }

    @Override // com.baidu.live.liveroom.g.b
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (ad(motionEvent) && isOpen()) {
            return d(motionEvent, motionEvent.getActionIndex());
        }
        return false;
    }

    @Override // com.baidu.live.liveroom.g.b
    public boolean PK() {
        return false;
    }

    public void bWk() {
        if (this.gPC != null) {
            this.gPC.endLoadData();
            this.mPP.setNextPage(null);
        }
    }

    public void bSb() {
        if (this.gPC != null) {
            if (this.gPC.getView().getParent() == null) {
                this.mPP.setNextPage(this.gPC);
            }
            this.gPC.showLoadView();
        }
    }

    private void xs(boolean z) {
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
                Sz("followtab_show");
            }
            if (z3) {
                Sz("hottab_show");
            }
        }
    }

    private void Sz(String str) {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.LIVE_RECOMMEND, str));
    }
}
