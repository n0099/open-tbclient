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
    private LoadMoreFooter gZv;
    private TbListCommonPullView hVQ;
    private com.baidu.live.y.b hsS;
    private Context mContext;
    private float mDownX;
    private int mOrientation;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;
    private int mTouchSlop;
    private ViewGroup mZO;
    private RecommendViewPager mZP;
    private AlaRecommendLiveListView mZQ;
    private View mZR;
    private int mZS;
    private float mZT;
    private List<AbsDelegateAdapter> mZU;
    private c mZV;
    private int mZW;
    private com.baidu.tieba.recommendlist.model.b mZX;
    private TextView mZY;
    private boolean mZZ;
    private float mrg;
    private ab naa;
    private FrameLayout nab;
    private View nac;
    private View nad;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.mTbPageContext = tbPageContext;
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.mZS = this.mScreenWidth;
            coF();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.d.xc().getBoolean("ala_recommend_live_first_show", true)) {
                this.fop = 1;
            }
        }
    }

    @Override // com.baidu.live.y.a
    public void a(c cVar) {
        this.mZV = cVar;
    }

    @Override // com.baidu.live.y.a
    public void o(ab abVar) {
        this.naa = abVar;
    }

    @Override // com.baidu.live.y.a
    public void C(int i, int i2) {
        this.mOrientation = i2;
        if (i2 == 2) {
            this.mZR.setVisibility(8);
            if (isOpen()) {
                onClose();
                return;
            }
            return;
        }
        this.mZR.setVisibility(0);
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
        this.hsS = bVar;
    }

    @Override // com.baidu.live.y.a
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (viewGroup != null) {
            this.bRb = viewGroup;
            this.mZO = viewGroup2;
            dEM();
            dEL();
            if (!this.mZZ && com.baidu.live.ae.a.Qj().buX != null && this.fop != 1) {
                long j = com.baidu.live.d.xc().getLong("ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int Qq = com.baidu.live.ae.a.Qj().Qq();
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > Qq) {
                    this.fop = 2;
                }
            }
            this.mZW = com.baidu.live.ae.a.Qj().Qt();
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
            this.bRb.removeView(this.mZP);
            this.bRb.removeView(this.nac);
        }
        this.mZV = null;
        if (this.mZZ) {
            com.baidu.live.d.xc().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.naa = null;
        if (this.mZX != null) {
            this.mZX.reset();
        }
    }

    @Override // com.baidu.live.y.a
    public void onDestroy() {
        Ar();
        if (this.mZX != null) {
            this.mZX.onDestroy();
        }
    }

    private void dEL() {
        if (this.aDL == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mZS, -1);
            this.aDL = LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_content_layout, (ViewGroup) null);
            this.aDL.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aDL.findViewById(a.f.right_layout).setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            }
            this.nad = this.aDL.findViewById(a.f.block_view);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80);
            if (com.baidu.live.ae.a.Qj().Qu() == 1) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds128);
            }
            ViewGroup.LayoutParams layoutParams2 = this.nad.getLayoutParams();
            layoutParams2.width = dimensionPixelSize;
            this.nad.setLayoutParams(layoutParams2);
            this.nad.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.nab = (FrameLayout) this.aDL.findViewById(a.f.listView_layout);
            this.mZQ = (AlaRecommendLiveListView) this.aDL.findViewById(a.f.recommendLiveListView);
            this.hVQ = new AlaListViewPullView(this.mContext);
            this.gZv = new LoadMoreFooter(this.mContext);
            this.gZv.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
            this.gZv.setFooterHeight(this.cardWidth / 2);
            this.gZv.createView();
            Kw();
            this.mZQ.addAdapters(this.mZU);
            this.mZQ.setPullRefresh(this.hVQ);
            this.hVQ.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.recommendlist.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.In(0);
                    if (!z) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_RECOMMEND, "pushfresh"));
                    }
                }
            });
            this.mZQ.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.recommendlist.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.gZv.isLoading() && a.this.mZX != null && a.this.mZX.hasMore && i + i2 > i3 - 2) {
                        a.this.bRr();
                        a.this.In(1);
                    }
                }
            });
        }
        if (this.nac == null) {
            this.nac = new View(this.mContext);
            this.nac.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha65));
            this.nac.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.nac.setAlpha(0.0f);
        }
        this.bRb.addView(this.nac);
        if (this.mZP == null) {
            this.mZP = new RecommendViewPager(this.mTbPageContext.getPageActivity());
            this.mZP.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mZP.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.recommendlist.a.4
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    if (a.this.isOpen() && i == 0) {
                        a.this.nac.setAlpha(f);
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    if (i == 0 && a.this.mZP != null) {
                        if (a.this.mZP.getCurrentItem() != 0) {
                            a.this.dEO();
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
            this.mZP.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.mZS, -1);
            layoutParams3.gravity = 5;
            layoutParams3.rightMargin = -this.mZS;
            this.mZP.setLayoutParams(layoutParams3);
        }
        this.bRb.addView(this.mZP);
        this.mZP.setCurrentItem(1, false);
        if (this.mZX == null) {
            this.mZX = new com.baidu.tieba.recommendlist.model.b(this.mTbPageContext);
            this.mZX.a(new b.a() { // from class: com.baidu.tieba.recommendlist.a.5
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

    private void coF() {
        if (com.baidu.live.ae.a.Qj().Qu() == 1) {
            this.cardWidth = ((((this.mZS - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds128)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds14)) / 2;
            if (this.cardWidth <= 0) {
                this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds260);
                return;
            }
            return;
        }
        this.cardWidth = ((((this.mZS - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds340);
        }
    }

    private void Kw() {
        if (this.mZU == null) {
            this.mZU = new ArrayList();
            this.mZU.add(new e(this.mContext, g.naP));
            this.mZU.add(new com.baidu.tieba.recommendlist.adapter.b(this.mContext, com.baidu.tieba.recommendlist.data.b.naJ));
            this.mZU.add(new com.baidu.tieba.recommendlist.adapter.c(this.mContext, com.baidu.tieba.recommendlist.data.d.naL, this.cardWidth));
            this.mZU.add(new com.baidu.tieba.recommendlist.adapter.d(this.mContext, f.naO, this.cardWidth));
        }
    }

    private void dEM() {
        this.mZR = LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_header_entrance, (ViewGroup) null);
        this.mZR.setId(a.f.ala_sdk_recommend_more_id);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.f.ala_head_line_entry_id);
        this.mZR.setLayoutParams(layoutParams);
        if (this.mZO != null) {
            this.mZO.addView(this.mZR);
        }
        ((TextView) this.mZR.findViewById(a.f.tv_recommend_entrance)).setText(com.baidu.live.ae.a.Qj().Qr());
        this.mZR.setOnClickListener(this);
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
                this.mrg = this.mDownX;
                this.mZT = this.cEl;
                break;
            case 1:
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                float f = this.mDownX - x;
                float f2 = this.cEl - y;
                if (Math.abs(f) < this.mTouchSlop && Math.abs(f2) < this.mTouchSlop && x > 0.0f && x < this.mScreenWidth - this.mZS) {
                    onClose();
                    return true;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mZP.getLayoutParams();
                if (f > this.mTouchSlop) {
                    xH(true);
                    dEN();
                    return true;
                } else if (layoutParams.rightMargin > (-this.mZS)) {
                    onClose();
                    return true;
                }
                break;
            case 2:
                float x2 = motionEvent.getX(i);
                float y2 = motionEvent.getY(i);
                float f3 = this.mrg - x2;
                float f4 = this.mZT - y2;
                this.mrg = x2;
                this.mZT = y2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mZP.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.mZP.setLayoutParams(layoutParams2);
                        this.nac.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.mZS));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.mZS)) {
                        layoutParams2.rightMargin = i3;
                        this.mZP.setLayoutParams(layoutParams2);
                        this.nac.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mZS));
                        return true;
                    } else if (i3 < (-this.mZS)) {
                        layoutParams2.rightMargin = -this.mZS;
                        this.mZP.setLayoutParams(layoutParams2);
                        this.nac.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mZS));
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
        if (motionEvent == null || this.mOrientation == 2 || this.hsS == null) {
            return false;
        }
        return this.hsS.PE();
    }

    private void dEN() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "left_slide"));
    }

    public void xH(boolean z) {
        if ((this.dwJ == null || !this.dwJ.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            xI(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mZP.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                ad(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.mZS)));
            }
            if (this.mZV != null) {
                this.mZV.cP(true);
            }
            if (!this.mZZ) {
                this.mZZ = true;
            }
            this.mZQ.completePullRefresh();
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
        if (this.naa != null && this.naa.mLiveInfo != null) {
            j = this.naa.mLiveInfo.live_id;
        }
        this.mZX.g(j, i, this.mZW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(List<IAdapterData> list, int i) {
        if (this.mZX.hasMore) {
            bVE();
        } else if (i == 1) {
            bVE();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.mZQ.setData(list);
        if (this.mZU != null) {
            for (AbsDelegateAdapter absDelegateAdapter : this.mZU) {
                if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.c) {
                    ((com.baidu.tieba.recommendlist.adapter.c) absDelegateAdapter).setAlaLiveShowData(this.naa);
                } else if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.d) {
                    ((com.baidu.tieba.recommendlist.adapter.d) absDelegateAdapter).setAlaLiveShowData(this.naa);
                } else if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.b) {
                    ((com.baidu.tieba.recommendlist.adapter.b) absDelegateAdapter).setAlaLiveShowData(this.naa);
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
        this.mZQ.completePullRefresh();
        s(list, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.mZX != null && !this.mZX.isDataEmpty()) {
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                BdUtilHelper.showToast(this.mContext, a.h.recommend_live_net_weak);
            }
            this.mZQ.completePullRefresh();
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
            this.mZY = (TextView) this.bMk.findViewById(a.f.sdk_cev_refresh_btn);
            this.mZY.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize22));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mZY.getLayoutParams();
            layoutParams2.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds152);
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds54);
            layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds30);
            this.mZY.setLayoutParams(layoutParams2);
            if (this.nab != null) {
                this.bMk.addToParent(this.nab);
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
                a.this.mZQ.startPullRefresh();
            }
        });
        this.bMk.setup(imgType, CommonEmptyView.StyleType.DARK);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
            this.mZY.setBackgroundResource(a.e.ala_recommend_live_empty_refresh_btn_selector);
        }
        this.bMk.setVisibility(0);
        this.mZQ.completePullRefresh();
        this.mZQ.setData(new ArrayList());
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
        if (this.mZV != null) {
            this.mZV.cP(false);
        }
        xI(false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mZP.getLayoutParams();
        layoutParams.rightMargin = -this.mZS;
        this.mZP.setLayoutParams(layoutParams);
        this.mZP.setCurrentItem(1, false);
        this.nac.setAlpha(0.0f);
    }

    @Override // com.baidu.live.y.a
    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.mZP.getLayoutParams()).rightMargin > (-this.mZS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEO() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.mZP.getLayoutParams()).rightMargin * 1.0f) / this.mZS);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.nac.setAlpha(abs);
    }

    @Override // com.baidu.live.y.a
    public void onClose() {
        if (this.dwJ == null || !this.dwJ.isRunning()) {
            xI(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mZP.getLayoutParams();
            if (layoutParams.rightMargin > (-this.mZS)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.mZS;
                ad(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.mZS)));
            }
            if (this.mZV != null) {
                this.mZV.cP(false);
            }
            this.mZQ.completePullRefresh();
        }
    }

    private void ad(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.dwJ = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.dwJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.recommendlist.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.mZP.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.nac.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.mZS));
                a.this.mZP.setLayoutParams(layoutParams);
            }
        });
        this.dwJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recommendlist.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.mZP.setCurrentItem(1, false);
                if (i2 == 0) {
                    a.this.nac.setAlpha(1.0f);
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
        if (view == this.mZR) {
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

    public void bVE() {
        if (this.gZv != null) {
            this.gZv.endLoadData();
            this.mZQ.setNextPage(null);
        }
    }

    public void bRr() {
        if (this.gZv != null) {
            if (this.gZv.getView().getParent() == null) {
                this.mZQ.setNextPage(this.gZv);
            }
            this.gZv.showLoadView();
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
                RU("followtab_show");
            }
            if (z2) {
                RU("hottab_show");
            }
        }
    }

    private void RU(String str) {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.LIVE_RECOMMEND, str));
    }
}
