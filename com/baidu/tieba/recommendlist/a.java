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
import com.baidu.live.v.c;
import com.baidu.tieba.recommendlist.adapter.RecommendPagerAdapter;
import com.baidu.tieba.recommendlist.data.e;
import com.baidu.tieba.recommendlist.model.b;
import com.baidu.tieba.recommendlist.view.AlaRecommendLiveListView;
import com.baidu.tieba.recommendlist.view.RecommendViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener, b, d, com.baidu.live.v.a {
    private View aFz;
    private CommonEmptyView bFa;
    private ViewGroup bJN;
    private int cardWidth;
    private float cwD;
    private LoadMoreFooter gGO;
    private com.baidu.live.v.b gYk;
    private TbListCommonPullView hAC;
    private float lTd;
    private ValueAnimator mAnimator;
    private ViewGroup mBf;
    private RecommendViewPager mBh;
    private AlaRecommendLiveListView mBi;
    private View mBj;
    private int mBk;
    private float mBl;
    private List<AbsDelegateAdapter> mBm;
    private c mBn;
    private final int mBo = 100;
    private int mBp;
    private com.baidu.tieba.recommendlist.model.b mBq;
    private TextView mBr;
    private boolean mBs;
    private w mBt;
    private LinearLayout mBu;
    private View mBv;
    private View mBw;
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
            this.mBk = this.mScreenWidth;
            dBN();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.d.AZ().getBoolean("ala_recommend_live_first_show", true)) {
                this.mShowType = 1;
            }
        }
    }

    @Override // com.baidu.live.v.a
    public void a(c cVar) {
        this.mBn = cVar;
    }

    @Override // com.baidu.live.v.a
    public void n(w wVar) {
        this.mBt = wVar;
    }

    @Override // com.baidu.live.v.a
    public void D(int i, int i2) {
        this.mOrientation = i2;
        if (i2 == 2) {
            this.mBj.setVisibility(8);
            if (isOpen()) {
                onClose();
                return;
            }
            return;
        }
        this.mBj.setVisibility(0);
    }

    @Override // com.baidu.live.v.a
    public d Pk() {
        return this;
    }

    @Override // com.baidu.live.v.a
    public b Pl() {
        return this;
    }

    @Override // com.baidu.live.v.a
    public void a(com.baidu.live.v.b bVar) {
        this.gYk = bVar;
    }

    @Override // com.baidu.live.v.a
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (viewGroup != null) {
            this.bJN = viewGroup;
            this.mBf = viewGroup2;
            dBO();
            dBM();
            if (!this.mBs && com.baidu.live.aa.a.PQ().bod != null && this.mShowType != 1) {
                long j = com.baidu.live.d.AZ().getLong("ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int PW = com.baidu.live.aa.a.PQ().PW();
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > PW) {
                    this.mShowType = 2;
                }
            }
            this.mBp = com.baidu.live.aa.a.PQ().PZ();
            Io(0);
        }
    }

    @Override // com.baidu.live.v.a
    public void Dm() {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
        if (this.bJN != null) {
            this.bJN.removeView(this.mBh);
            this.bJN.removeView(this.mBv);
        }
        this.mBn = null;
        if (this.mBs) {
            com.baidu.live.d.AZ().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.mBt = null;
        if (this.mBq != null) {
            this.mBq.reset();
        }
    }

    @Override // com.baidu.live.v.a
    public void onDestroy() {
        Dm();
        if (this.mBq != null) {
            this.mBq.onDestroy();
        }
    }

    private void dBM() {
        if (this.aFz == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mBk, -1);
            this.aFz = LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_content_layout, (ViewGroup) null);
            this.aFz.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aFz.findViewById(a.f.right_layout).setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            }
            this.mBw = this.aFz.findViewById(a.f.block_view);
            this.mBw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.mBu = (LinearLayout) this.aFz.findViewById(a.f.listView_layout);
            this.mBi = (AlaRecommendLiveListView) this.aFz.findViewById(a.f.recommendLiveListView);
            this.hAC = new AlaListViewPullView(this.mContext);
            this.gGO = new LoadMoreFooter(this.mContext);
            this.gGO.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
            this.gGO.setFooterHeight(this.cardWidth / 2);
            this.gGO.createView();
            LY();
            this.mBi.addAdapters(this.mBm);
            this.mBi.setPullRefresh(this.hAC);
            this.hAC.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.recommendlist.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.Io(0);
                    if (!z) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_RECOMMEND, "pushfresh"));
                    }
                }
            });
            this.mBi.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.recommendlist.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.gGO.isLoading() && a.this.mBq != null && a.this.mBq.hasMore && i + i2 > i3 - 2) {
                        a.this.bOX();
                        a.this.Io(1);
                    }
                }
            });
        }
        if (this.mBv == null) {
            this.mBv = new View(this.mContext);
            this.mBv.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha65));
            this.mBv.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mBv.setAlpha(0.0f);
        }
        this.bJN.addView(this.mBv);
        if (this.mBh == null) {
            this.mBh = new RecommendViewPager(this.mTbPageContext.getPageActivity());
            this.mBh.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mBh.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.recommendlist.a.4
                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    if (a.this.isOpen() && i == 0) {
                        a.this.mBv.setAlpha(f);
                    }
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    if (i == 0 && a.this.mBh != null) {
                        if (a.this.mBh.getCurrentItem() != 0) {
                            a.this.dBQ();
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
            arrayList.add(this.aFz);
            this.mBh.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.mBk, -1);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = -this.mBk;
            this.mBh.setLayoutParams(layoutParams2);
        }
        this.bJN.addView(this.mBh);
        this.mBh.setCurrentItem(1, false);
        if (this.mBq == null) {
            this.mBq = new com.baidu.tieba.recommendlist.model.b(this.mTbPageContext);
            this.mBq.a(new b.a() { // from class: com.baidu.tieba.recommendlist.a.5
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

    private void dBN() {
        this.cardWidth = ((((this.mBk - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds340);
        }
    }

    private void LY() {
        if (this.mBm == null) {
            this.mBm = new ArrayList();
            this.mBm.add(new com.baidu.tieba.recommendlist.adapter.d(this.mContext, e.mCc));
            this.mBm.add(new com.baidu.tieba.recommendlist.adapter.b(this.mContext, com.baidu.tieba.recommendlist.data.b.mBX));
            this.mBm.add(new com.baidu.tieba.recommendlist.adapter.c(this.mContext, com.baidu.tieba.recommendlist.data.c.mBZ, this.cardWidth));
        }
    }

    private void dBO() {
        this.mBj = LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_header_entrance, (ViewGroup) null);
        this.mBj.setId(a.f.ala_sdk_recommend_more_id);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.f.ala_head_line_entry_id);
        this.mBj.setLayoutParams(layoutParams);
        if (this.mBf != null) {
            this.mBf.addView(this.mBj);
        }
        ((TextView) this.mBj.findViewById(a.f.tv_recommend_entrance)).setText(com.baidu.live.aa.a.PQ().PX());
        this.mBj.setOnClickListener(this);
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
                this.cwD = motionEvent.getY(i);
                this.lTd = this.mDownX;
                this.mBl = this.cwD;
                break;
            case 1:
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                float f = this.mDownX - x;
                float f2 = this.cwD - y;
                if (Math.abs(f) < this.mTouchSlop && Math.abs(f2) < this.mTouchSlop && x > 0.0f && x < this.mScreenWidth - this.mBk) {
                    onClose();
                    return true;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mBh.getLayoutParams();
                if (f > this.mTouchSlop) {
                    wK(true);
                    dBP();
                    return true;
                } else if (layoutParams.rightMargin > (-this.mBk)) {
                    onClose();
                    return true;
                }
                break;
            case 2:
                float x2 = motionEvent.getX(i);
                float y2 = motionEvent.getY(i);
                float f3 = this.lTd - x2;
                float f4 = this.mBl - y2;
                this.lTd = x2;
                this.mBl = y2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mBh.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.mBh.setLayoutParams(layoutParams2);
                        this.mBv.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.mBk));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.mBk)) {
                        layoutParams2.rightMargin = i3;
                        this.mBh.setLayoutParams(layoutParams2);
                        this.mBv.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mBk));
                        return true;
                    } else if (i3 < (-this.mBk)) {
                        layoutParams2.rightMargin = -this.mBk;
                        this.mBh.setLayoutParams(layoutParams2);
                        this.mBv.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mBk));
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
        if (motionEvent == null || this.mOrientation == 2 || this.gYk == null) {
            return false;
        }
        return this.gYk.Pm();
    }

    private void dBP() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "left_slide"));
    }

    public void wK(boolean z) {
        if ((this.mAnimator == null || !this.mAnimator.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            wL(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mBh.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                ac(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.mBk)));
            }
            if (this.mBn != null) {
                this.mBn.cr(true);
            }
            if (!this.mBs) {
                this.mBs = true;
            }
            this.mBi.completePullRefresh();
            if (z) {
                Io(0);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", UbcStatConstant.Page.LIVE_RECOMMEND, ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Io(int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            b(CommonEmptyView.ImgType.NO_NET);
            return;
        }
        hideNoDataView();
        long j = 0;
        if (this.mBt != null && this.mBt.mLiveInfo != null) {
            j = this.mBt.mLiveInfo.live_id;
        }
        this.mBq.f(j, i, this.mBp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(List<IAdapterData> list, int i) {
        if (this.mBq.hasMore) {
            bTh();
        } else if (i == 1) {
            bTh();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.mBi.setData(list);
        if (this.mBm != null) {
            for (AbsDelegateAdapter absDelegateAdapter : this.mBm) {
                if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.c) {
                    ((com.baidu.tieba.recommendlist.adapter.c) absDelegateAdapter).setAlaLiveShowData(this.mBt);
                } else if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.b) {
                    ((com.baidu.tieba.recommendlist.adapter.b) absDelegateAdapter).setAlaLiveShowData(this.mBt);
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
        this.mBi.completePullRefresh();
        s(list, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.mBq != null && !this.mBq.bBW()) {
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                BdUtilHelper.showToast(this.mContext, a.h.recommend_live_net_weak);
            }
            this.mBi.completePullRefresh();
            return;
        }
        if (this.bFa == null) {
            this.bFa = new CommonEmptyView(this.mContext);
            ImageView imageView = (ImageView) this.bFa.findViewById(a.f.sdk_cev_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
            imageView.setLayoutParams(layoutParams);
            ((TextView) this.bFa.findViewById(a.f.sdk_cev_title)).setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
            this.mBr = (TextView) this.bFa.findViewById(a.f.sdk_cev_refresh_btn);
            this.mBr.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize22));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBr.getLayoutParams();
            layoutParams2.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds152);
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds54);
            layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds30);
            this.mBr.setLayoutParams(layoutParams2);
            if (this.mBu != null) {
                this.bFa.addToParent(this.mBu);
            }
        }
        this.bFa.reset();
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
        this.bFa.setTitle(i);
        this.bFa.setRefreshButton(this.mContext.getResources().getString(a.h.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hideNoDataView();
                a.this.mBi.startPullRefresh();
            }
        });
        this.bFa.setup(imgType, CommonEmptyView.StyleType.DARK);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
            this.mBr.setBackgroundResource(a.e.ala_recommend_live_empty_refresh_btn_selector);
        }
        this.bFa.setVisibility(0);
        this.mBi.completePullRefresh();
        this.mBi.setData(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bFa != null) {
            this.bFa.setVisibility(8);
        }
    }

    @Override // com.baidu.live.v.a
    public void close() {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (this.mBn != null) {
            this.mBn.cr(false);
        }
        wL(false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mBh.getLayoutParams();
        layoutParams.rightMargin = -this.mBk;
        this.mBh.setLayoutParams(layoutParams);
        this.mBh.setCurrentItem(1, false);
        this.mBv.setAlpha(0.0f);
    }

    @Override // com.baidu.live.v.a
    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.mBh.getLayoutParams()).rightMargin > (-this.mBk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBQ() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.mBh.getLayoutParams()).rightMargin * 1.0f) / this.mBk);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.mBv.setAlpha(abs);
    }

    @Override // com.baidu.live.v.a
    public void onClose() {
        if (this.mAnimator == null || !this.mAnimator.isRunning()) {
            wL(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mBh.getLayoutParams();
            if (layoutParams.rightMargin > (-this.mBk)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.mBk;
                ac(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.mBk)));
            }
            if (this.mBn != null) {
                this.mBn.cr(false);
            }
            this.mBi.completePullRefresh();
        }
    }

    private void ac(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.mAnimator = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.recommendlist.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.mBh.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.mBv.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.mBk));
                a.this.mBh.setLayoutParams(layoutParams);
            }
        });
        this.mAnimator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recommendlist.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.mBh.setCurrentItem(1, false);
                if (i2 == 0) {
                    a.this.mBv.setAlpha(1.0f);
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
        if (view == this.mBj) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "recommend_icon"));
            wK(true);
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
    public boolean Oa() {
        return false;
    }

    public void bTh() {
        if (this.gGO != null) {
            this.gGO.endLoadData();
            this.mBi.setNextPage(null);
        }
    }

    public void bOX() {
        if (this.gGO != null) {
            if (this.gGO.getView().getParent() == null) {
                this.mBi.setNextPage(this.gGO);
            }
            this.gGO.showLoadView();
        }
    }

    private void wL(boolean z) {
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
                RP("followtab_show");
            }
            if (z3) {
                RP("hottab_show");
            }
        }
    }

    private void RP(String str) {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.LIVE_RECOMMEND, str));
    }
}
