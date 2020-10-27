package com.baidu.tieba.yuyinala.liveroom.recommend;

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
import com.baidu.live.adp.lib.util.BdLog;
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
import com.baidu.tieba.yuyinala.liveroom.recommend.adapter.RecommendPagerAdapter;
import com.baidu.tieba.yuyinala.liveroom.recommend.data.c;
import com.baidu.tieba.yuyinala.liveroom.recommend.model.b;
import com.baidu.tieba.yuyinala.liveroom.recommend.view.AlaRecommendLiveListView;
import com.baidu.tieba.yuyinala.liveroom.recommend.view.RecommendViewPager;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a implements View.OnClickListener, b, d {
    private View aEJ;
    private ViewGroup bEg;
    private List<AbsDelegateAdapter> bje;
    private CommonEmptyView byP;
    private int cardWidth;
    private float cqF;
    private LoadMoreFooter gBa;
    private TbListCommonPullView huF;
    private float lNh;
    private ValueAnimator mAnimator;
    private Context mContext;
    private float mDownX;
    private int mOrientation;
    private int mScreenWidth;
    private int mShowType;
    private int mTouchSlop;
    private ViewGroup mvj;
    private View mvm;
    private int mvn;
    private float mvo;
    private final int mvr;
    private TextView mvu;
    private boolean mvv;
    private w mvw;
    private View mvy;
    private View mvz;
    private RecommendViewPager nRu;
    private AlaRecommendLiveListView nRv;
    private InterfaceC0896a nRw;
    private com.baidu.tieba.yuyinala.liveroom.recommend.model.b nRx;
    private AlaLiveView nRy;
    private FrameLayout nRz;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.recommend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0896a {
        void cq(boolean z);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mvr = 100;
        if (tbPageContext != null) {
            this.mContext = getPageContext().getPageActivity();
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.mvn = this.mScreenWidth;
            dzl();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.d.AZ().getBoolean("yuyin_ala_recommend_live_first_show", true)) {
                this.mShowType = 1;
            }
        }
    }

    public void a(InterfaceC0896a interfaceC0896a) {
        this.nRw = interfaceC0896a;
    }

    public void o(w wVar) {
        this.mvw = wVar;
    }

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

    public void a(AlaLiveView alaLiveView) {
        this.nRy = alaLiveView;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void av(ViewGroup viewGroup) {
        super.av(viewGroup);
        if (viewGroup != null) {
            this.bEg = viewGroup;
            this.mvj = (ViewGroup) this.bEg.findViewById(a.g.ala_live_header_view);
            dzm();
            dzk();
            if (!this.mvv && com.baidu.live.z.a.Pq().bmJ != null && this.mShowType != 1) {
                long j = com.baidu.live.d.AZ().getLong("yuyin_ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int Pv = com.baidu.live.z.a.Pq().Pv();
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > Pv) {
                    this.mShowType = 2;
                }
            }
            Ib(0);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void CT() {
        super.CT();
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
        if (this.bEg != null) {
            this.bEg.removeView(this.nRu);
            this.bEg.removeView(this.mvy);
        }
        this.nRw = null;
        if (this.mvv) {
            com.baidu.live.d.AZ().putLong("yuyin_ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.mvw = null;
        if (this.nRx != null) {
            this.nRx.reset();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        CT();
        if (this.nRx != null) {
            this.nRx.onDestroy();
        }
    }

    private void dzk() {
        if (this.aEJ == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mvn, -1);
            this.aEJ = LayoutInflater.from(this.mContext).inflate(a.h.yuyinala_recommend_live_content_layout, (ViewGroup) null);
            this.aEJ.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aEJ.findViewById(a.g.right_layout).setPadding(0, BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity()), 0, 0);
            }
            this.mvz = this.aEJ.findViewById(a.g.block_view);
            this.mvz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.nRz = (FrameLayout) this.aEJ.findViewById(a.g.listView_layout);
            this.nRv = (AlaRecommendLiveListView) this.aEJ.findViewById(a.g.recommendLiveListView);
            this.huF = new AlaListViewPullView(this.mContext);
            this.nRv.setPullRefresh(this.huF);
            this.gBa = new LoadMoreFooter(this.mContext);
            this.gBa.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
            this.gBa.setFooterHeight(this.cardWidth / 2);
            this.gBa.createView();
            Ly();
            this.nRv.addAdapters(this.bje);
            this.huF.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.Ib(0);
                    if (!z) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, a.this.mvw.aIS.croom_id);
                        } catch (Exception e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "more_room", "pushfresh"));
                    }
                }
            });
            this.nRv.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.gBa.isLoading() && a.this.nRx != null && a.this.nRx.hasMore && i + i2 > i3 - 2) {
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
        if (this.nRu == null) {
            this.nRu = new RecommendViewPager(getPageContext().getPageActivity());
            this.nRu.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.nRu.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.4
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
                    if (i == 0 && a.this.nRu != null) {
                        if (a.this.nRu.getCurrentItem() == 0) {
                            a.this.close();
                        } else {
                            a.this.dzo();
                        }
                    }
                }
            });
            ArrayList arrayList = new ArrayList();
            Space space = new Space(getPageContext().getPageActivity());
            space.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            arrayList.add(space);
            arrayList.add(this.aEJ);
            this.nRu.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.mvn, -1);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = -this.mvn;
            this.nRu.setLayoutParams(layoutParams2);
        }
        this.bEg.addView(this.nRu);
        this.nRu.setCurrentItem(1, false);
        if (this.nRx == null) {
            this.nRx = new com.baidu.tieba.yuyinala.liveroom.recommend.model.b(getPageContext());
            this.nRx.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.5
                @Override // com.baidu.tieba.yuyinala.liveroom.recommend.model.b.a
                public void h(List<IAdapterData> list, int i, int i2) {
                    a.this.g(list, i, i2);
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.recommend.model.b.a
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
        if (this.bje == null) {
            this.bje = new ArrayList();
            this.bje.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.b(this.mContext, c.mwf));
            this.bje.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a(this.mContext, com.baidu.tieba.yuyinala.liveroom.recommend.data.a.mwc, this.cardWidth, getPageContext()));
        }
    }

    private void dzm() {
        this.mvm = LayoutInflater.from(this.mContext).inflate(a.h.yuyin_ala_recommend_live_header_entrance, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds14);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
        this.mvm.setLayoutParams(layoutParams);
        if (this.mvj != null) {
            this.mvj.addView(this.mvm);
        }
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
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nRu.getLayoutParams();
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
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.nRu.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.nRu.setLayoutParams(layoutParams2);
                        this.mvy.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.mvn));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.mvn)) {
                        layoutParams2.rightMargin = i3;
                        this.nRu.setLayoutParams(layoutParams2);
                        this.mvy.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mvn));
                        return true;
                    } else if (i3 < (-this.mvn)) {
                        layoutParams2.rightMargin = -this.mvn;
                        this.nRu.setLayoutParams(layoutParams2);
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
        if (motionEvent == null || this.mOrientation == 2) {
            return false;
        }
        if (this.nRy != null) {
            if (this.nRy.getKeyboardVisibility()) {
                return false;
            }
            if (!this.nRy.cfw()) {
                close();
                return false;
            } else if (this.nRy.getScrollX() != 0) {
                close();
                return false;
            }
        }
        return true;
    }

    private void dzn() {
    }

    public void wB(boolean z) {
        if ((this.mAnimator == null || !this.mAnimator.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            wC(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nRu.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                ac(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.mvn)));
            }
            if (this.nRw != null) {
                this.nRw.cq(true);
            }
            if (!this.mvv) {
                this.mvv = true;
            }
            this.nRv.completePullRefresh();
            if (z) {
                Ib(0);
            }
            dVx();
        }
    }

    private void dVx() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.mvw.aIS.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", "more_room", null).setContentExt(jSONObject));
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
        this.nRx.t(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<IAdapterData> list, int i, int i2) {
        if (this.nRx.hasMore) {
            bQH();
        } else if (i2 == 1) {
            bQH();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.nRv.setData(list);
        if (this.bje != null) {
            Iterator<AbsDelegateAdapter> it = this.bje.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbsDelegateAdapter next = it.next();
                if (next instanceof com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) {
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).LU(i);
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).setAlaLiveShowData(this.mvw);
                    break;
                }
            }
        }
        if ((this.mShowType == 1 || this.mShowType == 2) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            if (this.mShowType == 1) {
                com.baidu.live.d.AZ().putBoolean("yuyin_ala_recommend_live_first_show", false);
            } else {
                com.baidu.live.d.AZ().putLong("yuyin_ala_recommend_live_last_show", System.currentTimeMillis());
            }
            this.mShowType = 0;
        }
        this.nRv.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.nRv != null) {
            if (this.nRv != null && this.nRv.getAdapter() != null && this.nRv.getAdapter().getCount() > 0) {
                this.nRv.completePullRefresh();
            } else if (this.nRx != null && !this.nRx.bzx() && this.nRv != null) {
                if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                    BdUtilHelper.showToast(this.mContext, a.i.recommend_live_net_weak);
                }
                this.nRv.completePullRefresh();
            } else {
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
                    if (this.nRz != null) {
                        this.byP.addToParent(this.nRz);
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
                this.byP.setRefreshButton(this.mContext.getResources().getString(a.i.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.hideNoDataView();
                        a.this.nRv.startPullRefresh();
                    }
                });
                this.byP.setup(imgType, CommonEmptyView.StyleType.DARK);
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
                    this.mvu.setBackgroundResource(a.f.ala_recommend_live_empty_refresh_btn_selector);
                }
                this.byP.setVisibility(0);
                this.nRv.completePullRefresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.byP != null) {
            this.byP.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (this.nRw != null) {
            this.nRw.cq(false);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nRu.getLayoutParams();
        layoutParams.rightMargin = -this.mvn;
        this.nRu.setLayoutParams(layoutParams);
        this.nRu.setCurrentItem(1, false);
        this.mvy.setAlpha(0.0f);
    }

    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.nRu.getLayoutParams()).rightMargin > (-this.mvn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzo() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.nRu.getLayoutParams()).rightMargin * 1.0f) / this.mvn);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.mvy.setAlpha(abs);
    }

    public void onClose() {
        if (this.mAnimator == null || !this.mAnimator.isRunning()) {
            wC(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nRu.getLayoutParams();
            if (layoutParams.rightMargin > (-this.mvn)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.mvn;
                ac(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.mvn)));
            }
            if (this.nRw != null) {
                this.nRw.cq(false);
            }
            this.nRv.completePullRefresh();
        }
    }

    private void ac(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.mAnimator = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.nRu.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.mvy.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.mvn));
                a.this.nRu.setLayoutParams(layoutParams);
            }
        });
        this.mAnimator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.nRu.setCurrentItem(1, false);
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
            wB(true);
            dVy();
        }
    }

    private void dVy() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.mvw.aIS.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "moreroom_clk").setContentExt(jSONObject));
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
            this.nRv.setNextPage(null);
        }
    }

    public void bMx() {
        if (this.gBa != null) {
            if (this.gBa.getView().getParent() == null) {
                this.nRv.setNextPage(this.gBa);
            }
            this.gBa.showLoadView();
        }
    }

    private void wC(boolean z) {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            UtilHelper.changeStatusBarIconAndTextColor(z, (Activity) this.mContext);
        }
    }
}
