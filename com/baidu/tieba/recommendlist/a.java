package com.baidu.tieba.recommendlist;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
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
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.aa.c;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.data.x;
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
import com.baidu.tieba.recommendlist.adapter.RecommendPagerAdapter;
import com.baidu.tieba.recommendlist.adapter.e;
import com.baidu.tieba.recommendlist.data.f;
import com.baidu.tieba.recommendlist.data.g;
import com.baidu.tieba.recommendlist.model.b;
import com.baidu.tieba.recommendlist.view.AlaRecommendLiveListView;
import com.baidu.tieba.recommendlist.view.RecommendViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class a implements View.OnClickListener, com.baidu.live.aa.a, b, d {
    private View aGL;
    private CommonEmptyView bNm;
    private ViewGroup bRX;
    private float cGB;
    private int cardWidth;
    private ValueAnimator dzn;
    private int fqH;
    private TbListCommonPullView hWc;
    private LoadMoreFooter hbr;
    private com.baidu.live.aa.b hto;
    private Context mContext;
    private float mDownX;
    private int mOrientation;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;
    private int mTouchSlop;
    private ViewGroup mVd;
    private RecommendViewPager mVe;
    private AlaRecommendLiveListView mVf;
    private View mVg;
    private int mVh;
    private float mVi;
    private List<AbsDelegateAdapter> mVj;
    private c mVk;
    private final int mVl = 100;
    private int mVm;
    private com.baidu.tieba.recommendlist.model.b mVn;
    private TextView mVo;
    private boolean mVp;
    private x mVq;
    private FrameLayout mVr;
    private View mVs;
    private View mVt;
    private float mmK;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.mTbPageContext = tbPageContext;
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.mVh = this.mScreenWidth;
            cry();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.d.Ba().getBoolean("ala_recommend_live_first_show", true)) {
                this.fqH = 1;
            }
        }
    }

    @Override // com.baidu.live.aa.a
    public void a(c cVar) {
        this.mVk = cVar;
    }

    @Override // com.baidu.live.aa.a
    public void o(x xVar) {
        this.mVq = xVar;
    }

    @Override // com.baidu.live.aa.a
    public void C(int i, int i2) {
        this.mOrientation = i2;
        if (i2 == 2) {
            this.mVg.setVisibility(8);
            if (isOpen()) {
                onClose();
                return;
            }
            return;
        }
        this.mVg.setVisibility(0);
    }

    @Override // com.baidu.live.aa.a
    public d RY() {
        return this;
    }

    @Override // com.baidu.live.aa.a
    public b RZ() {
        return this;
    }

    @Override // com.baidu.live.aa.a
    public void a(com.baidu.live.aa.b bVar) {
        this.hto = bVar;
    }

    @Override // com.baidu.live.aa.a
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (viewGroup != null) {
            this.bRX = viewGroup;
            this.mVd = viewGroup2;
            dGt();
            dGs();
            if (!this.mVp && com.baidu.live.af.a.SE().bwi != null && this.fqH != 1) {
                long j = com.baidu.live.d.Ba().getLong("ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int SK = com.baidu.live.af.a.SE().SK();
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > SK) {
                    this.fqH = 2;
                }
            }
            this.mVm = com.baidu.live.af.a.SE().SN();
            JA(0);
        }
    }

    @Override // com.baidu.live.aa.a
    public void DC() {
        if (this.dzn != null && this.dzn.isRunning()) {
            this.dzn.cancel();
            this.dzn = null;
        }
        if (this.bRX != null) {
            this.bRX.removeView(this.mVe);
            this.bRX.removeView(this.mVs);
        }
        this.mVk = null;
        if (this.mVp) {
            com.baidu.live.d.Ba().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.mVq = null;
        if (this.mVn != null) {
            this.mVn.reset();
        }
    }

    @Override // com.baidu.live.aa.a
    public void onDestroy() {
        DC();
        if (this.mVn != null) {
            this.mVn.onDestroy();
        }
    }

    private void dGs() {
        if (this.aGL == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mVh, -1);
            this.aGL = LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_content_layout, (ViewGroup) null);
            this.aGL.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aGL.findViewById(a.f.right_layout).setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            }
            this.mVt = this.aGL.findViewById(a.f.block_view);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80);
            if (com.baidu.live.af.a.SE().SO() == 1) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds128);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mVt.getLayoutParams();
            layoutParams2.width = dimensionPixelSize;
            this.mVt.setLayoutParams(layoutParams2);
            this.mVt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.mVr = (FrameLayout) this.aGL.findViewById(a.f.listView_layout);
            this.mVf = (AlaRecommendLiveListView) this.aGL.findViewById(a.f.recommendLiveListView);
            this.hWc = new AlaListViewPullView(this.mContext);
            this.hbr = new LoadMoreFooter(this.mContext);
            this.hbr.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
            this.hbr.setFooterHeight(this.cardWidth / 2);
            this.hbr.createView();
            MT();
            this.mVf.addAdapters(this.mVj);
            this.mVf.setPullRefresh(this.hWc);
            this.hWc.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.recommendlist.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.JA(0);
                    if (!z) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_RECOMMEND, "pushfresh"));
                    }
                }
            });
            this.mVf.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.recommendlist.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.hbr.isLoading() && a.this.mVn != null && a.this.mVn.hasMore && i + i2 > i3 - 2) {
                        a.this.bUE();
                        a.this.JA(1);
                    }
                }
            });
        }
        if (this.mVs == null) {
            this.mVs = new View(this.mContext);
            this.mVs.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha65));
            this.mVs.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mVs.setAlpha(0.0f);
        }
        this.bRX.addView(this.mVs);
        if (this.mVe == null) {
            this.mVe = new RecommendViewPager(this.mTbPageContext.getPageActivity());
            this.mVe.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mVe.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.recommendlist.a.4
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    if (a.this.isOpen() && i == 0) {
                        a.this.mVs.setAlpha(f);
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    if (i == 0 && a.this.mVe != null) {
                        if (a.this.mVe.getCurrentItem() != 0) {
                            a.this.dGv();
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
            arrayList.add(this.aGL);
            this.mVe.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.mVh, -1);
            layoutParams3.gravity = 5;
            layoutParams3.rightMargin = -this.mVh;
            this.mVe.setLayoutParams(layoutParams3);
        }
        this.bRX.addView(this.mVe);
        this.mVe.setCurrentItem(1, false);
        if (this.mVn == null) {
            this.mVn = new com.baidu.tieba.recommendlist.model.b(this.mTbPageContext);
            this.mVn.a(new b.a() { // from class: com.baidu.tieba.recommendlist.a.5
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

    private void cry() {
        if (com.baidu.live.af.a.SE().SO() == 1) {
            this.cardWidth = ((((this.mVh - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds128)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds14)) / 2;
            if (this.cardWidth <= 0) {
                this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds260);
                return;
            }
            return;
        }
        this.cardWidth = ((((this.mVh - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds340);
        }
    }

    private void MT() {
        if (this.mVj == null) {
            this.mVj = new ArrayList();
            this.mVj.add(new e(this.mContext, g.mWe));
            this.mVj.add(new com.baidu.tieba.recommendlist.adapter.b(this.mContext, com.baidu.tieba.recommendlist.data.b.mVY));
            this.mVj.add(new com.baidu.tieba.recommendlist.adapter.c(this.mContext, com.baidu.tieba.recommendlist.data.d.mWa, this.cardWidth));
            this.mVj.add(new com.baidu.tieba.recommendlist.adapter.d(this.mContext, f.mWd, this.cardWidth));
        }
    }

    private void dGt() {
        this.mVg = LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_header_entrance, (ViewGroup) null);
        this.mVg.setId(a.f.ala_sdk_recommend_more_id);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.f.ala_head_line_entry_id);
        this.mVg.setLayoutParams(layoutParams);
        if (this.mVd != null) {
            this.mVd.addView(this.mVg);
        }
        ((TextView) this.mVg.findViewById(a.f.tv_recommend_entrance)).setText(com.baidu.live.af.a.SE().SL());
        this.mVg.setOnClickListener(this);
    }

    @Override // com.baidu.live.liveroom.g.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!ad(motionEvent)) {
            return false;
        }
        if (this.dzn != null && this.dzn.isRunning()) {
            return true;
        }
        return e(motionEvent, motionEvent.getActionIndex());
    }

    private boolean e(MotionEvent motionEvent, int i) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mDownX = motionEvent.getX(i);
                this.cGB = motionEvent.getY(i);
                this.mmK = this.mDownX;
                this.mVi = this.cGB;
                break;
            case 1:
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                float f = this.mDownX - x;
                float f2 = this.cGB - y;
                if (Math.abs(f) < this.mTouchSlop && Math.abs(f2) < this.mTouchSlop && x > 0.0f && x < this.mScreenWidth - this.mVh) {
                    onClose();
                    return true;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mVe.getLayoutParams();
                if (f > this.mTouchSlop) {
                    xs(true);
                    dGu();
                    return true;
                } else if (layoutParams.rightMargin > (-this.mVh)) {
                    onClose();
                    return true;
                }
                break;
            case 2:
                float x2 = motionEvent.getX(i);
                float y2 = motionEvent.getY(i);
                float f3 = this.mmK - x2;
                float f4 = this.mVi - y2;
                this.mmK = x2;
                this.mVi = y2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mVe.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.mVe.setLayoutParams(layoutParams2);
                        this.mVs.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.mVh));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.mVh)) {
                        layoutParams2.rightMargin = i3;
                        this.mVe.setLayoutParams(layoutParams2);
                        this.mVs.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mVh));
                        return true;
                    } else if (i3 < (-this.mVh)) {
                        layoutParams2.rightMargin = -this.mVh;
                        this.mVe.setLayoutParams(layoutParams2);
                        this.mVs.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mVh));
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
        if (motionEvent == null || this.mOrientation == 2 || this.hto == null) {
            return false;
        }
        return this.hto.Sa();
    }

    private void dGu() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "left_slide"));
    }

    public void xs(boolean z) {
        if ((this.dzn == null || !this.dzn.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            xt(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mVe.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                af(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.mVh)));
            }
            if (this.mVk != null) {
                this.mVk.cK(true);
            }
            if (!this.mVp) {
                this.mVp = true;
            }
            this.mVf.completePullRefresh();
            if (z) {
                JA(0);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", UbcStatConstant.Page.LIVE_RECOMMEND, ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JA(int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            b(CommonEmptyView.ImgType.NO_NET);
            return;
        }
        hideNoDataView();
        long j = 0;
        if (this.mVq != null && this.mVq.mLiveInfo != null) {
            j = this.mVq.mLiveInfo.live_id;
        }
        this.mVn.g(j, i, this.mVm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(List<IAdapterData> list, int i) {
        if (this.mVn.hasMore) {
            bYQ();
        } else if (i == 1) {
            bYQ();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.mVf.setData(list);
        if (this.mVj != null) {
            for (AbsDelegateAdapter absDelegateAdapter : this.mVj) {
                if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.c) {
                    ((com.baidu.tieba.recommendlist.adapter.c) absDelegateAdapter).setAlaLiveShowData(this.mVq);
                } else if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.d) {
                    ((com.baidu.tieba.recommendlist.adapter.d) absDelegateAdapter).setAlaLiveShowData(this.mVq);
                } else if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.b) {
                    ((com.baidu.tieba.recommendlist.adapter.b) absDelegateAdapter).setAlaLiveShowData(this.mVq);
                }
            }
        }
        if ((this.fqH == 1 || this.fqH == 2) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            if (this.fqH == 1) {
                com.baidu.live.d.Ba().putBoolean("ala_recommend_live_first_show", false);
            } else {
                com.baidu.live.d.Ba().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
            }
            this.fqH = 0;
        }
        this.mVf.completePullRefresh();
        s(list, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.mVn != null && !this.mVn.isDataEmpty()) {
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                BdUtilHelper.showToast(this.mContext, a.h.recommend_live_net_weak);
            }
            this.mVf.completePullRefresh();
            return;
        }
        if (this.bNm == null) {
            this.bNm = new CommonEmptyView(this.mContext);
            ImageView imageView = (ImageView) this.bNm.findViewById(a.f.sdk_cev_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
            imageView.setLayoutParams(layoutParams);
            ((TextView) this.bNm.findViewById(a.f.sdk_cev_title)).setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
            this.mVo = (TextView) this.bNm.findViewById(a.f.sdk_cev_refresh_btn);
            this.mVo.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize22));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mVo.getLayoutParams();
            layoutParams2.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds152);
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds54);
            layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds30);
            this.mVo.setLayoutParams(layoutParams2);
            if (this.mVr != null) {
                this.bNm.addToParent(this.mVr);
            }
        }
        this.bNm.reset();
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
        this.bNm.setTitle(i);
        this.bNm.setRefreshButton(this.mContext.getResources().getString(a.h.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hideNoDataView();
                a.this.mVf.startPullRefresh();
            }
        });
        this.bNm.setup(imgType, CommonEmptyView.StyleType.DARK);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
            this.mVo.setBackgroundResource(a.e.ala_recommend_live_empty_refresh_btn_selector);
        }
        this.bNm.setVisibility(0);
        this.mVf.completePullRefresh();
        this.mVf.setData(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bNm != null) {
            this.bNm.setVisibility(8);
        }
    }

    @Override // com.baidu.live.aa.a
    public void close() {
        if (this.dzn != null && this.dzn.isRunning()) {
            this.dzn.cancel();
        }
        if (this.mVk != null) {
            this.mVk.cK(false);
        }
        xt(false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mVe.getLayoutParams();
        layoutParams.rightMargin = -this.mVh;
        this.mVe.setLayoutParams(layoutParams);
        this.mVe.setCurrentItem(1, false);
        this.mVs.setAlpha(0.0f);
    }

    @Override // com.baidu.live.aa.a
    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.mVe.getLayoutParams()).rightMargin > (-this.mVh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGv() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.mVe.getLayoutParams()).rightMargin * 1.0f) / this.mVh);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.mVs.setAlpha(abs);
    }

    @Override // com.baidu.live.aa.a
    public void onClose() {
        if (this.dzn == null || !this.dzn.isRunning()) {
            xt(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mVe.getLayoutParams();
            if (layoutParams.rightMargin > (-this.mVh)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.mVh;
                af(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.mVh)));
            }
            if (this.mVk != null) {
                this.mVk.cK(false);
            }
            this.mVf.completePullRefresh();
        }
    }

    private void af(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.dzn = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.dzn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.recommendlist.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.mVe.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.mVs.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.mVh));
                a.this.mVe.setLayoutParams(layoutParams);
            }
        });
        this.dzn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recommendlist.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.mVe.setCurrentItem(1, false);
                if (i2 == 0) {
                    a.this.mVs.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.dzn.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mVg) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "recommend_icon"));
            xs(true);
        }
    }

    @Override // com.baidu.live.liveroom.g.b
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (ad(motionEvent) && isOpen()) {
            return e(motionEvent, motionEvent.getActionIndex());
        }
        return false;
    }

    @Override // com.baidu.live.liveroom.g.b
    public boolean Pz() {
        return false;
    }

    public void bYQ() {
        if (this.hbr != null) {
            this.hbr.endLoadData();
            this.mVf.setNextPage(null);
        }
    }

    public void bUE() {
        if (this.hbr != null) {
            if (this.hbr.getView().getParent() == null) {
                this.mVf.setNextPage(this.hbr);
            }
            this.hbr.showLoadView();
        }
    }

    private void xt(boolean z) {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            UtilHelper.changeStatusBarIconAndTextColor(z, (Activity) this.mContext);
        }
    }

    private void s(List<IAdapterData> list, int i) {
        boolean z;
        if (i == 0 && !ListUtils.isEmpty(list)) {
            Iterator<IAdapterData> it = list.iterator();
            boolean z2 = false;
            boolean z3 = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                IAdapterData next = it.next();
                if (next instanceof g) {
                    int i2 = ((g) next).type;
                    if (i2 == 0) {
                        if (z2) {
                            z3 = true;
                            break;
                        }
                        z = z2;
                        z3 = true;
                        z2 = z;
                    } else if (1 == i2) {
                        if (z3) {
                            z2 = true;
                            break;
                        } else {
                            z = true;
                            z2 = z;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (z3) {
                Sh("followtab_show");
            }
            if (z2) {
                Sh("hottab_show");
            }
        }
    }

    private void Sh(String str) {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.LIVE_RECOMMEND, str));
    }
}
