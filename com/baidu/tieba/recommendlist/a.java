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
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.data.ab;
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
import com.baidu.live.y.c;
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
public class a implements View.OnClickListener, b, d, com.baidu.live.y.a {
    private View aDL;
    private CommonEmptyView bMk;
    private ViewGroup bRb;
    private float cEl;
    private int cardWidth;
    private ValueAnimator dwJ;
    private int fop;
    private LoadMoreFooter gZJ;
    private TbListCommonPullView hWe;
    private com.baidu.live.y.b htg;
    private Context mContext;
    private float mDownX;
    private int mOrientation;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;
    private int mTouchSlop;
    private float mrv;
    private boolean naA;
    private ab naB;
    private FrameLayout naC;
    private View naD;
    private View naE;
    private ViewGroup nao;
    private RecommendViewPager nap;
    private AlaRecommendLiveListView naq;
    private View nar;
    private int nas;
    private float nau;
    private List<AbsDelegateAdapter> nav;
    private c naw;
    private int nax;
    private com.baidu.tieba.recommendlist.model.b nay;
    private TextView naz;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.mTbPageContext = tbPageContext;
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.nas = this.mScreenWidth;
            coM();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.d.xc().getBoolean("ala_recommend_live_first_show", true)) {
                this.fop = 1;
            }
        }
    }

    @Override // com.baidu.live.y.a
    public void a(c cVar) {
        this.naw = cVar;
    }

    @Override // com.baidu.live.y.a
    public void o(ab abVar) {
        this.naB = abVar;
    }

    @Override // com.baidu.live.y.a
    public void C(int i, int i2) {
        this.mOrientation = i2;
        if (i2 == 2) {
            this.nar.setVisibility(8);
            if (isOpen()) {
                onClose();
                return;
            }
            return;
        }
        this.nar.setVisibility(0);
    }

    @Override // com.baidu.live.y.a
    public d PC() {
        return this;
    }

    @Override // com.baidu.live.y.a
    public b PD() {
        return this;
    }

    @Override // com.baidu.live.y.a
    public void a(com.baidu.live.y.b bVar) {
        this.htg = bVar;
    }

    @Override // com.baidu.live.y.a
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (viewGroup != null) {
            this.bRb = viewGroup;
            this.nao = viewGroup2;
            dEU();
            dET();
            if (!this.naA && com.baidu.live.ae.a.Qj().buX != null && this.fop != 1) {
                long j = com.baidu.live.d.xc().getLong("ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int Qq = com.baidu.live.ae.a.Qj().Qq();
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > Qq) {
                    this.fop = 2;
                }
            }
            this.nax = com.baidu.live.ae.a.Qj().Qt();
            In(0);
        }
    }

    @Override // com.baidu.live.y.a
    public void Ar() {
        if (this.dwJ != null && this.dwJ.isRunning()) {
            this.dwJ.cancel();
            this.dwJ = null;
        }
        if (this.bRb != null) {
            this.bRb.removeView(this.nap);
            this.bRb.removeView(this.naD);
        }
        this.naw = null;
        if (this.naA) {
            com.baidu.live.d.xc().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.naB = null;
        if (this.nay != null) {
            this.nay.reset();
        }
    }

    @Override // com.baidu.live.y.a
    public void onDestroy() {
        Ar();
        if (this.nay != null) {
            this.nay.onDestroy();
        }
    }

    private void dET() {
        if (this.aDL == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.nas, -1);
            this.aDL = LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_content_layout, (ViewGroup) null);
            this.aDL.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aDL.findViewById(a.f.right_layout).setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            }
            this.naE = this.aDL.findViewById(a.f.block_view);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80);
            if (com.baidu.live.ae.a.Qj().Qu() == 1) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds128);
            }
            ViewGroup.LayoutParams layoutParams2 = this.naE.getLayoutParams();
            layoutParams2.width = dimensionPixelSize;
            this.naE.setLayoutParams(layoutParams2);
            this.naE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.naC = (FrameLayout) this.aDL.findViewById(a.f.listView_layout);
            this.naq = (AlaRecommendLiveListView) this.aDL.findViewById(a.f.recommendLiveListView);
            this.hWe = new AlaListViewPullView(this.mContext);
            this.gZJ = new LoadMoreFooter(this.mContext);
            this.gZJ.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
            this.gZJ.setFooterHeight(this.cardWidth / 2);
            this.gZJ.createView();
            Kw();
            this.naq.addAdapters(this.nav);
            this.naq.setPullRefresh(this.hWe);
            this.hWe.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.recommendlist.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.In(0);
                    if (!z) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_RECOMMEND, "pushfresh"));
                    }
                }
            });
            this.naq.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.recommendlist.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.gZJ.isLoading() && a.this.nay != null && a.this.nay.hasMore && i + i2 > i3 - 2) {
                        a.this.bRy();
                        a.this.In(1);
                    }
                }
            });
        }
        if (this.naD == null) {
            this.naD = new View(this.mContext);
            this.naD.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha65));
            this.naD.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.naD.setAlpha(0.0f);
        }
        this.bRb.addView(this.naD);
        if (this.nap == null) {
            this.nap = new RecommendViewPager(this.mTbPageContext.getPageActivity());
            this.nap.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.nap.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.recommendlist.a.4
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    if (a.this.isOpen() && i == 0) {
                        a.this.naD.setAlpha(f);
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    if (i == 0 && a.this.nap != null) {
                        if (a.this.nap.getCurrentItem() != 0) {
                            a.this.dEW();
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
            arrayList.add(this.aDL);
            this.nap.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.nas, -1);
            layoutParams3.gravity = 5;
            layoutParams3.rightMargin = -this.nas;
            this.nap.setLayoutParams(layoutParams3);
        }
        this.bRb.addView(this.nap);
        this.nap.setCurrentItem(1, false);
        if (this.nay == null) {
            this.nay = new com.baidu.tieba.recommendlist.model.b(this.mTbPageContext);
            this.nay.a(new b.a() { // from class: com.baidu.tieba.recommendlist.a.5
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

    private void coM() {
        if (com.baidu.live.ae.a.Qj().Qu() == 1) {
            this.cardWidth = ((((this.nas - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds128)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds14)) / 2;
            if (this.cardWidth <= 0) {
                this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds260);
                return;
            }
            return;
        }
        this.cardWidth = ((((this.nas - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds340);
        }
    }

    private void Kw() {
        if (this.nav == null) {
            this.nav = new ArrayList();
            this.nav.add(new e(this.mContext, g.nbp));
            this.nav.add(new com.baidu.tieba.recommendlist.adapter.b(this.mContext, com.baidu.tieba.recommendlist.data.b.nbj));
            this.nav.add(new com.baidu.tieba.recommendlist.adapter.c(this.mContext, com.baidu.tieba.recommendlist.data.d.nbl, this.cardWidth));
            this.nav.add(new com.baidu.tieba.recommendlist.adapter.d(this.mContext, f.nbo, this.cardWidth));
        }
    }

    private void dEU() {
        this.nar = LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_header_entrance, (ViewGroup) null);
        this.nar.setId(a.f.ala_sdk_recommend_more_id);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.f.ala_head_line_entry_id);
        this.nar.setLayoutParams(layoutParams);
        if (this.nao != null) {
            this.nao.addView(this.nar);
        }
        ((TextView) this.nar.findViewById(a.f.tv_recommend_entrance)).setText(com.baidu.live.ae.a.Qj().Qr());
        this.nar.setOnClickListener(this);
    }

    @Override // com.baidu.live.liveroom.g.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!ad(motionEvent)) {
            return false;
        }
        if (this.dwJ != null && this.dwJ.isRunning()) {
            return true;
        }
        return e(motionEvent, motionEvent.getActionIndex());
    }

    private boolean e(MotionEvent motionEvent, int i) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mDownX = motionEvent.getX(i);
                this.cEl = motionEvent.getY(i);
                this.mrv = this.mDownX;
                this.nau = this.cEl;
                break;
            case 1:
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                float f = this.mDownX - x;
                float f2 = this.cEl - y;
                if (Math.abs(f) < this.mTouchSlop && Math.abs(f2) < this.mTouchSlop && x > 0.0f && x < this.mScreenWidth - this.nas) {
                    onClose();
                    return true;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nap.getLayoutParams();
                if (f > this.mTouchSlop) {
                    xH(true);
                    dEV();
                    return true;
                } else if (layoutParams.rightMargin > (-this.nas)) {
                    onClose();
                    return true;
                }
                break;
            case 2:
                float x2 = motionEvent.getX(i);
                float y2 = motionEvent.getY(i);
                float f3 = this.mrv - x2;
                float f4 = this.nau - y2;
                this.mrv = x2;
                this.nau = y2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.nap.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.nap.setLayoutParams(layoutParams2);
                        this.naD.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.nas));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.nas)) {
                        layoutParams2.rightMargin = i3;
                        this.nap.setLayoutParams(layoutParams2);
                        this.naD.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.nas));
                        return true;
                    } else if (i3 < (-this.nas)) {
                        layoutParams2.rightMargin = -this.nas;
                        this.nap.setLayoutParams(layoutParams2);
                        this.naD.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.nas));
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
        if (motionEvent == null || this.mOrientation == 2 || this.htg == null) {
            return false;
        }
        return this.htg.PE();
    }

    private void dEV() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "left_slide"));
    }

    public void xH(boolean z) {
        if ((this.dwJ == null || !this.dwJ.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            xI(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nap.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                ad(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.nas)));
            }
            if (this.naw != null) {
                this.naw.cP(true);
            }
            if (!this.naA) {
                this.naA = true;
            }
            this.naq.completePullRefresh();
            if (z) {
                In(0);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", UbcStatConstant.Page.LIVE_RECOMMEND, ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void In(int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            b(CommonEmptyView.ImgType.NO_NET);
            return;
        }
        hideNoDataView();
        long j = 0;
        if (this.naB != null && this.naB.mLiveInfo != null) {
            j = this.naB.mLiveInfo.live_id;
        }
        this.nay.g(j, i, this.nax);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(List<IAdapterData> list, int i) {
        if (this.nay.hasMore) {
            bVL();
        } else if (i == 1) {
            bVL();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.naq.setData(list);
        if (this.nav != null) {
            for (AbsDelegateAdapter absDelegateAdapter : this.nav) {
                if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.c) {
                    ((com.baidu.tieba.recommendlist.adapter.c) absDelegateAdapter).setAlaLiveShowData(this.naB);
                } else if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.d) {
                    ((com.baidu.tieba.recommendlist.adapter.d) absDelegateAdapter).setAlaLiveShowData(this.naB);
                } else if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.b) {
                    ((com.baidu.tieba.recommendlist.adapter.b) absDelegateAdapter).setAlaLiveShowData(this.naB);
                }
            }
        }
        if ((this.fop == 1 || this.fop == 2) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            if (this.fop == 1) {
                com.baidu.live.d.xc().putBoolean("ala_recommend_live_first_show", false);
            } else {
                com.baidu.live.d.xc().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
            }
            this.fop = 0;
        }
        this.naq.completePullRefresh();
        s(list, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.nay != null && !this.nay.isDataEmpty()) {
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                BdUtilHelper.showToast(this.mContext, a.h.recommend_live_net_weak);
            }
            this.naq.completePullRefresh();
            return;
        }
        if (this.bMk == null) {
            this.bMk = new CommonEmptyView(this.mContext);
            ImageView imageView = (ImageView) this.bMk.findViewById(a.f.sdk_cev_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
            imageView.setLayoutParams(layoutParams);
            ((TextView) this.bMk.findViewById(a.f.sdk_cev_title)).setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
            this.naz = (TextView) this.bMk.findViewById(a.f.sdk_cev_refresh_btn);
            this.naz.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize22));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.naz.getLayoutParams();
            layoutParams2.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds152);
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds54);
            layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds30);
            this.naz.setLayoutParams(layoutParams2);
            if (this.naC != null) {
                this.bMk.addToParent(this.naC);
            }
        }
        this.bMk.reset();
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
        this.bMk.setTitle(i);
        this.bMk.setRefreshButton(this.mContext.getResources().getString(a.h.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hideNoDataView();
                a.this.naq.startPullRefresh();
            }
        });
        this.bMk.setup(imgType, CommonEmptyView.StyleType.DARK);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
            this.naz.setBackgroundResource(a.e.ala_recommend_live_empty_refresh_btn_selector);
        }
        this.bMk.setVisibility(0);
        this.naq.completePullRefresh();
        this.naq.setData(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bMk != null) {
            this.bMk.setVisibility(8);
        }
    }

    @Override // com.baidu.live.y.a
    public void close() {
        if (this.dwJ != null && this.dwJ.isRunning()) {
            this.dwJ.cancel();
        }
        if (this.naw != null) {
            this.naw.cP(false);
        }
        xI(false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nap.getLayoutParams();
        layoutParams.rightMargin = -this.nas;
        this.nap.setLayoutParams(layoutParams);
        this.nap.setCurrentItem(1, false);
        this.naD.setAlpha(0.0f);
    }

    @Override // com.baidu.live.y.a
    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.nap.getLayoutParams()).rightMargin > (-this.nas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEW() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.nap.getLayoutParams()).rightMargin * 1.0f) / this.nas);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.naD.setAlpha(abs);
    }

    @Override // com.baidu.live.y.a
    public void onClose() {
        if (this.dwJ == null || !this.dwJ.isRunning()) {
            xI(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nap.getLayoutParams();
            if (layoutParams.rightMargin > (-this.nas)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.nas;
                ad(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.nas)));
            }
            if (this.naw != null) {
                this.naw.cP(false);
            }
            this.naq.completePullRefresh();
        }
    }

    private void ad(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.dwJ = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.dwJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.recommendlist.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.nap.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.naD.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.nas));
                a.this.nap.setLayoutParams(layoutParams);
            }
        });
        this.dwJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recommendlist.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.nap.setCurrentItem(1, false);
                if (i2 == 0) {
                    a.this.naD.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.dwJ.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nar) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "recommend_icon"));
            xH(true);
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
    public boolean Nc() {
        return false;
    }

    public void bVL() {
        if (this.gZJ != null) {
            this.gZJ.endLoadData();
            this.naq.setNextPage(null);
        }
    }

    public void bRy() {
        if (this.gZJ != null) {
            if (this.gZJ.getView().getParent() == null) {
                this.naq.setNextPage(this.gZJ);
            }
            this.gZJ.showLoadView();
        }
    }

    private void xI(boolean z) {
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
                Sg("followtab_show");
            }
            if (z2) {
                Sg("hottab_show");
            }
        }
    }

    private void Sg(String str) {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.LIVE_RECOMMEND, str));
    }
}
