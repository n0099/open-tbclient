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
/* loaded from: classes10.dex */
public class a implements View.OnClickListener, com.baidu.live.aa.a, b, d {
    private View aBY;
    private CommonEmptyView bIA;
    private ViewGroup bNl;
    private float cBP;
    private int cardWidth;
    private ValueAnimator duB;
    private int flX;
    private LoadMoreFooter gWL;
    private TbListCommonPullView hRv;
    private com.baidu.live.aa.b hoI;
    private Context mContext;
    private float mDownX;
    private int mOrientation;
    private int mQA;
    private com.baidu.tieba.recommendlist.model.b mQB;
    private TextView mQC;
    private boolean mQD;
    private x mQE;
    private FrameLayout mQF;
    private View mQG;
    private View mQH;
    private ViewGroup mQr;
    private RecommendViewPager mQs;
    private AlaRecommendLiveListView mQt;
    private View mQu;
    private int mQv;
    private float mQw;
    private List<AbsDelegateAdapter> mQx;
    private c mQy;
    private final int mQz = 100;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;
    private int mTouchSlop;
    private float mie;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.mTbPageContext = tbPageContext;
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.mQv = this.mScreenWidth;
            cnH();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.d.xf().getBoolean("ala_recommend_live_first_show", true)) {
                this.flX = 1;
            }
        }
    }

    @Override // com.baidu.live.aa.a
    public void a(c cVar) {
        this.mQy = cVar;
    }

    @Override // com.baidu.live.aa.a
    public void o(x xVar) {
        this.mQE = xVar;
    }

    @Override // com.baidu.live.aa.a
    public void C(int i, int i2) {
        this.mOrientation = i2;
        if (i2 == 2) {
            this.mQu.setVisibility(8);
            if (isOpen()) {
                onClose();
                return;
            }
            return;
        }
        this.mQu.setVisibility(0);
    }

    @Override // com.baidu.live.aa.a
    public d Od() {
        return this;
    }

    @Override // com.baidu.live.aa.a
    public b Oe() {
        return this;
    }

    @Override // com.baidu.live.aa.a
    public void a(com.baidu.live.aa.b bVar) {
        this.hoI = bVar;
    }

    @Override // com.baidu.live.aa.a
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (viewGroup != null) {
            this.bNl = viewGroup;
            this.mQr = viewGroup2;
            dCC();
            dCB();
            if (!this.mQD && com.baidu.live.af.a.OJ().bru != null && this.flX != 1) {
                long j = com.baidu.live.d.xf().getLong("ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int OP = com.baidu.live.af.a.OJ().OP();
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > OP) {
                    this.flX = 2;
                }
            }
            this.mQA = com.baidu.live.af.a.OJ().OS();
            HT(0);
        }
    }

    @Override // com.baidu.live.aa.a
    public void zH() {
        if (this.duB != null && this.duB.isRunning()) {
            this.duB.cancel();
            this.duB = null;
        }
        if (this.bNl != null) {
            this.bNl.removeView(this.mQs);
            this.bNl.removeView(this.mQG);
        }
        this.mQy = null;
        if (this.mQD) {
            com.baidu.live.d.xf().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.mQE = null;
        if (this.mQB != null) {
            this.mQB.reset();
        }
    }

    @Override // com.baidu.live.aa.a
    public void onDestroy() {
        zH();
        if (this.mQB != null) {
            this.mQB.onDestroy();
        }
    }

    private void dCB() {
        if (this.aBY == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mQv, -1);
            this.aBY = LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_content_layout, (ViewGroup) null);
            this.aBY.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aBY.findViewById(a.f.right_layout).setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            }
            this.mQH = this.aBY.findViewById(a.f.block_view);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80);
            if (com.baidu.live.af.a.OJ().OT() == 1) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds128);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mQH.getLayoutParams();
            layoutParams2.width = dimensionPixelSize;
            this.mQH.setLayoutParams(layoutParams2);
            this.mQH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.mQF = (FrameLayout) this.aBY.findViewById(a.f.listView_layout);
            this.mQt = (AlaRecommendLiveListView) this.aBY.findViewById(a.f.recommendLiveListView);
            this.hRv = new AlaListViewPullView(this.mContext);
            this.gWL = new LoadMoreFooter(this.mContext);
            this.gWL.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
            this.gWL.setFooterHeight(this.cardWidth / 2);
            this.gWL.createView();
            IY();
            this.mQt.addAdapters(this.mQx);
            this.mQt.setPullRefresh(this.hRv);
            this.hRv.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.recommendlist.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.HT(0);
                    if (!z) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_RECOMMEND, "pushfresh"));
                    }
                }
            });
            this.mQt.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.recommendlist.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.gWL.isLoading() && a.this.mQB != null && a.this.mQB.hasMore && i + i2 > i3 - 2) {
                        a.this.bQN();
                        a.this.HT(1);
                    }
                }
            });
        }
        if (this.mQG == null) {
            this.mQG = new View(this.mContext);
            this.mQG.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha65));
            this.mQG.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mQG.setAlpha(0.0f);
        }
        this.bNl.addView(this.mQG);
        if (this.mQs == null) {
            this.mQs = new RecommendViewPager(this.mTbPageContext.getPageActivity());
            this.mQs.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mQs.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.recommendlist.a.4
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    if (a.this.isOpen() && i == 0) {
                        a.this.mQG.setAlpha(f);
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    if (i == 0 && a.this.mQs != null) {
                        if (a.this.mQs.getCurrentItem() != 0) {
                            a.this.dCE();
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
            arrayList.add(this.aBY);
            this.mQs.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.mQv, -1);
            layoutParams3.gravity = 5;
            layoutParams3.rightMargin = -this.mQv;
            this.mQs.setLayoutParams(layoutParams3);
        }
        this.bNl.addView(this.mQs);
        this.mQs.setCurrentItem(1, false);
        if (this.mQB == null) {
            this.mQB = new com.baidu.tieba.recommendlist.model.b(this.mTbPageContext);
            this.mQB.a(new b.a() { // from class: com.baidu.tieba.recommendlist.a.5
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

    private void cnH() {
        if (com.baidu.live.af.a.OJ().OT() == 1) {
            this.cardWidth = ((((this.mQv - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds128)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds14)) / 2;
            if (this.cardWidth <= 0) {
                this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds260);
                return;
            }
            return;
        }
        this.cardWidth = ((((this.mQv - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds340);
        }
    }

    private void IY() {
        if (this.mQx == null) {
            this.mQx = new ArrayList();
            this.mQx.add(new e(this.mContext, g.mRs));
            this.mQx.add(new com.baidu.tieba.recommendlist.adapter.b(this.mContext, com.baidu.tieba.recommendlist.data.b.mRm));
            this.mQx.add(new com.baidu.tieba.recommendlist.adapter.c(this.mContext, com.baidu.tieba.recommendlist.data.d.mRo, this.cardWidth));
            this.mQx.add(new com.baidu.tieba.recommendlist.adapter.d(this.mContext, f.mRr, this.cardWidth));
        }
    }

    private void dCC() {
        this.mQu = LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_header_entrance, (ViewGroup) null);
        this.mQu.setId(a.f.ala_sdk_recommend_more_id);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.f.ala_head_line_entry_id);
        this.mQu.setLayoutParams(layoutParams);
        if (this.mQr != null) {
            this.mQr.addView(this.mQu);
        }
        ((TextView) this.mQu.findViewById(a.f.tv_recommend_entrance)).setText(com.baidu.live.af.a.OJ().OQ());
        this.mQu.setOnClickListener(this);
    }

    @Override // com.baidu.live.liveroom.g.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!ad(motionEvent)) {
            return false;
        }
        if (this.duB != null && this.duB.isRunning()) {
            return true;
        }
        return e(motionEvent, motionEvent.getActionIndex());
    }

    private boolean e(MotionEvent motionEvent, int i) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mDownX = motionEvent.getX(i);
                this.cBP = motionEvent.getY(i);
                this.mie = this.mDownX;
                this.mQw = this.cBP;
                break;
            case 1:
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                float f = this.mDownX - x;
                float f2 = this.cBP - y;
                if (Math.abs(f) < this.mTouchSlop && Math.abs(f2) < this.mTouchSlop && x > 0.0f && x < this.mScreenWidth - this.mQv) {
                    onClose();
                    return true;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mQs.getLayoutParams();
                if (f > this.mTouchSlop) {
                    xo(true);
                    dCD();
                    return true;
                } else if (layoutParams.rightMargin > (-this.mQv)) {
                    onClose();
                    return true;
                }
                break;
            case 2:
                float x2 = motionEvent.getX(i);
                float y2 = motionEvent.getY(i);
                float f3 = this.mie - x2;
                float f4 = this.mQw - y2;
                this.mie = x2;
                this.mQw = y2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mQs.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.mQs.setLayoutParams(layoutParams2);
                        this.mQG.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.mQv));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.mQv)) {
                        layoutParams2.rightMargin = i3;
                        this.mQs.setLayoutParams(layoutParams2);
                        this.mQG.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mQv));
                        return true;
                    } else if (i3 < (-this.mQv)) {
                        layoutParams2.rightMargin = -this.mQv;
                        this.mQs.setLayoutParams(layoutParams2);
                        this.mQG.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mQv));
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
        if (motionEvent == null || this.mOrientation == 2 || this.hoI == null) {
            return false;
        }
        return this.hoI.Of();
    }

    private void dCD() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "left_slide"));
    }

    public void xo(boolean z) {
        if ((this.duB == null || !this.duB.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            xp(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mQs.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                af(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.mQv)));
            }
            if (this.mQy != null) {
                this.mQy.cG(true);
            }
            if (!this.mQD) {
                this.mQD = true;
            }
            this.mQt.completePullRefresh();
            if (z) {
                HT(0);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", UbcStatConstant.Page.LIVE_RECOMMEND, ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HT(int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            b(CommonEmptyView.ImgType.NO_NET);
            return;
        }
        hideNoDataView();
        long j = 0;
        if (this.mQE != null && this.mQE.mLiveInfo != null) {
            j = this.mQE.mLiveInfo.live_id;
        }
        this.mQB.g(j, i, this.mQA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(List<IAdapterData> list, int i) {
        if (this.mQB.hasMore) {
            bUZ();
        } else if (i == 1) {
            bUZ();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.mQt.setData(list);
        if (this.mQx != null) {
            for (AbsDelegateAdapter absDelegateAdapter : this.mQx) {
                if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.c) {
                    ((com.baidu.tieba.recommendlist.adapter.c) absDelegateAdapter).setAlaLiveShowData(this.mQE);
                } else if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.d) {
                    ((com.baidu.tieba.recommendlist.adapter.d) absDelegateAdapter).setAlaLiveShowData(this.mQE);
                } else if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.b) {
                    ((com.baidu.tieba.recommendlist.adapter.b) absDelegateAdapter).setAlaLiveShowData(this.mQE);
                }
            }
        }
        if ((this.flX == 1 || this.flX == 2) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            if (this.flX == 1) {
                com.baidu.live.d.xf().putBoolean("ala_recommend_live_first_show", false);
            } else {
                com.baidu.live.d.xf().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
            }
            this.flX = 0;
        }
        this.mQt.completePullRefresh();
        s(list, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.mQB != null && !this.mQB.isDataEmpty()) {
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                BdUtilHelper.showToast(this.mContext, a.h.recommend_live_net_weak);
            }
            this.mQt.completePullRefresh();
            return;
        }
        if (this.bIA == null) {
            this.bIA = new CommonEmptyView(this.mContext);
            ImageView imageView = (ImageView) this.bIA.findViewById(a.f.sdk_cev_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
            imageView.setLayoutParams(layoutParams);
            ((TextView) this.bIA.findViewById(a.f.sdk_cev_title)).setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
            this.mQC = (TextView) this.bIA.findViewById(a.f.sdk_cev_refresh_btn);
            this.mQC.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize22));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mQC.getLayoutParams();
            layoutParams2.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds152);
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds54);
            layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds30);
            this.mQC.setLayoutParams(layoutParams2);
            if (this.mQF != null) {
                this.bIA.addToParent(this.mQF);
            }
        }
        this.bIA.reset();
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
        this.bIA.setTitle(i);
        this.bIA.setRefreshButton(this.mContext.getResources().getString(a.h.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hideNoDataView();
                a.this.mQt.startPullRefresh();
            }
        });
        this.bIA.setup(imgType, CommonEmptyView.StyleType.DARK);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
            this.mQC.setBackgroundResource(a.e.ala_recommend_live_empty_refresh_btn_selector);
        }
        this.bIA.setVisibility(0);
        this.mQt.completePullRefresh();
        this.mQt.setData(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bIA != null) {
            this.bIA.setVisibility(8);
        }
    }

    @Override // com.baidu.live.aa.a
    public void close() {
        if (this.duB != null && this.duB.isRunning()) {
            this.duB.cancel();
        }
        if (this.mQy != null) {
            this.mQy.cG(false);
        }
        xp(false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mQs.getLayoutParams();
        layoutParams.rightMargin = -this.mQv;
        this.mQs.setLayoutParams(layoutParams);
        this.mQs.setCurrentItem(1, false);
        this.mQG.setAlpha(0.0f);
    }

    @Override // com.baidu.live.aa.a
    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.mQs.getLayoutParams()).rightMargin > (-this.mQv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCE() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.mQs.getLayoutParams()).rightMargin * 1.0f) / this.mQv);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.mQG.setAlpha(abs);
    }

    @Override // com.baidu.live.aa.a
    public void onClose() {
        if (this.duB == null || !this.duB.isRunning()) {
            xp(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mQs.getLayoutParams();
            if (layoutParams.rightMargin > (-this.mQv)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.mQv;
                af(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.mQv)));
            }
            if (this.mQy != null) {
                this.mQy.cG(false);
            }
            this.mQt.completePullRefresh();
        }
    }

    private void af(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.duB = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.duB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.recommendlist.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.mQs.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.mQG.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.mQv));
                a.this.mQs.setLayoutParams(layoutParams);
            }
        });
        this.duB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recommendlist.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.mQs.setCurrentItem(1, false);
                if (i2 == 0) {
                    a.this.mQG.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.duB.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mQu) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "recommend_icon"));
            xo(true);
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
    public boolean LE() {
        return false;
    }

    public void bUZ() {
        if (this.gWL != null) {
            this.gWL.endLoadData();
            this.mQt.setNextPage(null);
        }
    }

    public void bQN() {
        if (this.gWL != null) {
            if (this.gWL.getView().getParent() == null) {
                this.mQt.setNextPage(this.gWL);
            }
            this.gWL.showLoadView();
        }
    }

    private void xp(boolean z) {
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
                QY("followtab_show");
            }
            if (z2) {
                QY("hottab_show");
            }
        }
    }

    private void QY(String str) {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.LIVE_RECOMMEND, str));
    }
}
