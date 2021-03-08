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
/* loaded from: classes10.dex */
public class a implements View.OnClickListener, b, d, com.baidu.live.y.a {
    private View aFl;
    private CommonEmptyView bNK;
    private ViewGroup bSB;
    private float cFL;
    private int cardWidth;
    private ValueAnimator dyk;
    private int fpQ;
    private TbListCommonPullView hXN;
    private LoadMoreFooter hbs;
    private com.baidu.live.y.b huP;
    private Context mContext;
    private float mDownX;
    private int mOrientation;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;
    private int mTouchSlop;
    private int mXq;
    private float mty;
    private c ncA;
    private int ncB;
    private com.baidu.tieba.recommendlist.model.b ncC;
    private TextView ncD;
    private boolean ncE;
    private ab ncF;
    private FrameLayout ncG;
    private View ncH;
    private View ncI;
    private ViewGroup ncu;
    private RecommendViewPager ncv;
    private AlaRecommendLiveListView ncw;
    private View ncx;
    private float ncy;
    private List<AbsDelegateAdapter> ncz;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.mTbPageContext = tbPageContext;
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.mXq = this.mScreenWidth;
            coS();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.d.xf().getBoolean("ala_recommend_live_first_show", true)) {
                this.fpQ = 1;
            }
        }
    }

    @Override // com.baidu.live.y.a
    public void a(c cVar) {
        this.ncA = cVar;
    }

    @Override // com.baidu.live.y.a
    public void o(ab abVar) {
        this.ncF = abVar;
    }

    @Override // com.baidu.live.y.a
    public void C(int i, int i2) {
        this.mOrientation = i2;
        if (i2 == 2) {
            this.ncx.setVisibility(8);
            if (isOpen()) {
                onClose();
                return;
            }
            return;
        }
        this.ncx.setVisibility(0);
    }

    @Override // com.baidu.live.y.a
    public d PF() {
        return this;
    }

    @Override // com.baidu.live.y.a
    public b PG() {
        return this;
    }

    @Override // com.baidu.live.y.a
    public void a(com.baidu.live.y.b bVar) {
        this.huP = bVar;
    }

    @Override // com.baidu.live.y.a
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (viewGroup != null) {
            this.bSB = viewGroup;
            this.ncu = viewGroup2;
            dFc();
            dFb();
            if (!this.ncE && com.baidu.live.ae.a.Qm().bwx != null && this.fpQ != 1) {
                long j = com.baidu.live.d.xf().getLong("ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int Qt = com.baidu.live.ae.a.Qm().Qt();
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > Qt) {
                    this.fpQ = 2;
                }
            }
            this.ncB = com.baidu.live.ae.a.Qm().Qw();
            Ir(0);
        }
    }

    @Override // com.baidu.live.y.a
    public void Au() {
        if (this.dyk != null && this.dyk.isRunning()) {
            this.dyk.cancel();
            this.dyk = null;
        }
        if (this.bSB != null) {
            this.bSB.removeView(this.ncv);
            this.bSB.removeView(this.ncH);
        }
        this.ncA = null;
        if (this.ncE) {
            com.baidu.live.d.xf().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.ncF = null;
        if (this.ncC != null) {
            this.ncC.reset();
        }
    }

    @Override // com.baidu.live.y.a
    public void onDestroy() {
        Au();
        if (this.ncC != null) {
            this.ncC.onDestroy();
        }
    }

    private void dFb() {
        if (this.aFl == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mXq, -1);
            this.aFl = LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_content_layout, (ViewGroup) null);
            this.aFl.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aFl.findViewById(a.f.right_layout).setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            }
            this.ncI = this.aFl.findViewById(a.f.block_view);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80);
            if (com.baidu.live.ae.a.Qm().Qx() == 1) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds128);
            }
            ViewGroup.LayoutParams layoutParams2 = this.ncI.getLayoutParams();
            layoutParams2.width = dimensionPixelSize;
            this.ncI.setLayoutParams(layoutParams2);
            this.ncI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.ncG = (FrameLayout) this.aFl.findViewById(a.f.listView_layout);
            this.ncw = (AlaRecommendLiveListView) this.aFl.findViewById(a.f.recommendLiveListView);
            this.hXN = new AlaListViewPullView(this.mContext);
            this.hbs = new LoadMoreFooter(this.mContext);
            this.hbs.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
            this.hbs.setFooterHeight(this.cardWidth / 2);
            this.hbs.createView();
            Kz();
            this.ncw.addAdapters(this.ncz);
            this.ncw.setPullRefresh(this.hXN);
            this.hXN.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.recommendlist.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.Ir(0);
                    if (!z) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_RECOMMEND, "pushfresh"));
                    }
                }
            });
            this.ncw.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.recommendlist.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.hbs.isLoading() && a.this.ncC != null && a.this.ncC.hasMore && i + i2 > i3 - 2) {
                        a.this.bRE();
                        a.this.Ir(1);
                    }
                }
            });
        }
        if (this.ncH == null) {
            this.ncH = new View(this.mContext);
            this.ncH.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha65));
            this.ncH.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.ncH.setAlpha(0.0f);
        }
        this.bSB.addView(this.ncH);
        if (this.ncv == null) {
            this.ncv = new RecommendViewPager(this.mTbPageContext.getPageActivity());
            this.ncv.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.ncv.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.recommendlist.a.4
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    if (a.this.isOpen() && i == 0) {
                        a.this.ncH.setAlpha(f);
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    if (i == 0 && a.this.ncv != null) {
                        if (a.this.ncv.getCurrentItem() != 0) {
                            a.this.dFe();
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
            arrayList.add(this.aFl);
            this.ncv.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.mXq, -1);
            layoutParams3.gravity = 5;
            layoutParams3.rightMargin = -this.mXq;
            this.ncv.setLayoutParams(layoutParams3);
        }
        this.bSB.addView(this.ncv);
        this.ncv.setCurrentItem(1, false);
        if (this.ncC == null) {
            this.ncC = new com.baidu.tieba.recommendlist.model.b(this.mTbPageContext);
            this.ncC.a(new b.a() { // from class: com.baidu.tieba.recommendlist.a.5
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

    private void coS() {
        if (com.baidu.live.ae.a.Qm().Qx() == 1) {
            this.cardWidth = ((((this.mXq - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds128)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds14)) / 2;
            if (this.cardWidth <= 0) {
                this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds260);
                return;
            }
            return;
        }
        this.cardWidth = ((((this.mXq - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds340);
        }
    }

    private void Kz() {
        if (this.ncz == null) {
            this.ncz = new ArrayList();
            this.ncz.add(new e(this.mContext, g.ndt));
            this.ncz.add(new com.baidu.tieba.recommendlist.adapter.b(this.mContext, com.baidu.tieba.recommendlist.data.b.ndn));
            this.ncz.add(new com.baidu.tieba.recommendlist.adapter.c(this.mContext, com.baidu.tieba.recommendlist.data.d.ndp, this.cardWidth));
            this.ncz.add(new com.baidu.tieba.recommendlist.adapter.d(this.mContext, f.nds, this.cardWidth));
        }
    }

    private void dFc() {
        this.ncx = LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_header_entrance, (ViewGroup) null);
        this.ncx.setId(a.f.ala_sdk_recommend_more_id);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.f.ala_head_line_entry_id);
        this.ncx.setLayoutParams(layoutParams);
        if (this.ncu != null) {
            this.ncu.addView(this.ncx);
        }
        ((TextView) this.ncx.findViewById(a.f.tv_recommend_entrance)).setText(com.baidu.live.ae.a.Qm().Qu());
        this.ncx.setOnClickListener(this);
    }

    @Override // com.baidu.live.liveroom.g.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!ad(motionEvent)) {
            return false;
        }
        if (this.dyk != null && this.dyk.isRunning()) {
            return true;
        }
        return e(motionEvent, motionEvent.getActionIndex());
    }

    private boolean e(MotionEvent motionEvent, int i) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mDownX = motionEvent.getX(i);
                this.cFL = motionEvent.getY(i);
                this.mty = this.mDownX;
                this.ncy = this.cFL;
                break;
            case 1:
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                float f = this.mDownX - x;
                float f2 = this.cFL - y;
                if (Math.abs(f) < this.mTouchSlop && Math.abs(f2) < this.mTouchSlop && x > 0.0f && x < this.mScreenWidth - this.mXq) {
                    onClose();
                    return true;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ncv.getLayoutParams();
                if (f > this.mTouchSlop) {
                    xH(true);
                    dFd();
                    return true;
                } else if (layoutParams.rightMargin > (-this.mXq)) {
                    onClose();
                    return true;
                }
                break;
            case 2:
                float x2 = motionEvent.getX(i);
                float y2 = motionEvent.getY(i);
                float f3 = this.mty - x2;
                float f4 = this.ncy - y2;
                this.mty = x2;
                this.ncy = y2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ncv.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.ncv.setLayoutParams(layoutParams2);
                        this.ncH.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.mXq));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.mXq)) {
                        layoutParams2.rightMargin = i3;
                        this.ncv.setLayoutParams(layoutParams2);
                        this.ncH.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mXq));
                        return true;
                    } else if (i3 < (-this.mXq)) {
                        layoutParams2.rightMargin = -this.mXq;
                        this.ncv.setLayoutParams(layoutParams2);
                        this.ncH.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mXq));
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
        if (motionEvent == null || this.mOrientation == 2 || this.huP == null) {
            return false;
        }
        return this.huP.PH();
    }

    private void dFd() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "left_slide"));
    }

    public void xH(boolean z) {
        if ((this.dyk == null || !this.dyk.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            xI(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ncv.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                ad(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.mXq)));
            }
            if (this.ncA != null) {
                this.ncA.cP(true);
            }
            if (!this.ncE) {
                this.ncE = true;
            }
            this.ncw.completePullRefresh();
            if (z) {
                Ir(0);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", UbcStatConstant.Page.LIVE_RECOMMEND, ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ir(int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            b(CommonEmptyView.ImgType.NO_NET);
            return;
        }
        hideNoDataView();
        long j = 0;
        if (this.ncF != null && this.ncF.mLiveInfo != null) {
            j = this.ncF.mLiveInfo.live_id;
        }
        this.ncC.g(j, i, this.ncB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(List<IAdapterData> list, int i) {
        if (this.ncC.hasMore) {
            bVR();
        } else if (i == 1) {
            bVR();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.ncw.setData(list);
        if (this.ncz != null) {
            for (AbsDelegateAdapter absDelegateAdapter : this.ncz) {
                if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.c) {
                    ((com.baidu.tieba.recommendlist.adapter.c) absDelegateAdapter).setAlaLiveShowData(this.ncF);
                } else if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.d) {
                    ((com.baidu.tieba.recommendlist.adapter.d) absDelegateAdapter).setAlaLiveShowData(this.ncF);
                } else if (absDelegateAdapter instanceof com.baidu.tieba.recommendlist.adapter.b) {
                    ((com.baidu.tieba.recommendlist.adapter.b) absDelegateAdapter).setAlaLiveShowData(this.ncF);
                }
            }
        }
        if ((this.fpQ == 1 || this.fpQ == 2) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            if (this.fpQ == 1) {
                com.baidu.live.d.xf().putBoolean("ala_recommend_live_first_show", false);
            } else {
                com.baidu.live.d.xf().putLong("ala_recommend_live_last_show", System.currentTimeMillis());
            }
            this.fpQ = 0;
        }
        this.ncw.completePullRefresh();
        s(list, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.ncC != null && !this.ncC.isDataEmpty()) {
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                BdUtilHelper.showToast(this.mContext, a.h.recommend_live_net_weak);
            }
            this.ncw.completePullRefresh();
            return;
        }
        if (this.bNK == null) {
            this.bNK = new CommonEmptyView(this.mContext);
            ImageView imageView = (ImageView) this.bNK.findViewById(a.f.sdk_cev_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
            imageView.setLayoutParams(layoutParams);
            ((TextView) this.bNK.findViewById(a.f.sdk_cev_title)).setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
            this.ncD = (TextView) this.bNK.findViewById(a.f.sdk_cev_refresh_btn);
            this.ncD.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize22));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ncD.getLayoutParams();
            layoutParams2.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds152);
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds54);
            layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds30);
            this.ncD.setLayoutParams(layoutParams2);
            if (this.ncG != null) {
                this.bNK.addToParent(this.ncG);
            }
        }
        this.bNK.reset();
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
        this.bNK.setTitle(i);
        this.bNK.setRefreshButton(this.mContext.getResources().getString(a.h.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hideNoDataView();
                a.this.ncw.startPullRefresh();
            }
        });
        this.bNK.setup(imgType, CommonEmptyView.StyleType.DARK);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
            this.ncD.setBackgroundResource(a.e.ala_recommend_live_empty_refresh_btn_selector);
        }
        this.bNK.setVisibility(0);
        this.ncw.completePullRefresh();
        this.ncw.setData(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bNK != null) {
            this.bNK.setVisibility(8);
        }
    }

    @Override // com.baidu.live.y.a
    public void close() {
        if (this.dyk != null && this.dyk.isRunning()) {
            this.dyk.cancel();
        }
        if (this.ncA != null) {
            this.ncA.cP(false);
        }
        xI(false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ncv.getLayoutParams();
        layoutParams.rightMargin = -this.mXq;
        this.ncv.setLayoutParams(layoutParams);
        this.ncv.setCurrentItem(1, false);
        this.ncH.setAlpha(0.0f);
    }

    @Override // com.baidu.live.y.a
    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.ncv.getLayoutParams()).rightMargin > (-this.mXq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFe() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.ncv.getLayoutParams()).rightMargin * 1.0f) / this.mXq);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.ncH.setAlpha(abs);
    }

    @Override // com.baidu.live.y.a
    public void onClose() {
        if (this.dyk == null || !this.dyk.isRunning()) {
            xI(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ncv.getLayoutParams();
            if (layoutParams.rightMargin > (-this.mXq)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.mXq;
                ad(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.mXq)));
            }
            if (this.ncA != null) {
                this.ncA.cP(false);
            }
            this.ncw.completePullRefresh();
        }
    }

    private void ad(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.dyk = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.dyk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.recommendlist.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.ncv.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.ncH.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.mXq));
                a.this.ncv.setLayoutParams(layoutParams);
            }
        });
        this.dyk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recommendlist.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.ncv.setCurrentItem(1, false);
                if (i2 == 0) {
                    a.this.ncH.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.dyk.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ncx) {
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
    public boolean Nf() {
        return false;
    }

    public void bVR() {
        if (this.hbs != null) {
            this.hbs.endLoadData();
            this.ncw.setNextPage(null);
        }
    }

    public void bRE() {
        if (this.hbs != null) {
            if (this.hbs.getView().getParent() == null) {
                this.ncw.setNextPage(this.hbs);
            }
            this.hbs.showLoadView();
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
                Sm("followtab_show");
            }
            if (z2) {
                Sm("hottab_show");
            }
        }
    }

    private void Sm(String str) {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.LIVE_RECOMMEND, str));
    }
}
