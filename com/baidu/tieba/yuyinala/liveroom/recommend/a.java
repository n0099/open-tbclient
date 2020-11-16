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
    private View aDO;
    private CommonEmptyView bDp;
    private ViewGroup bIc;
    private List<AbsDelegateAdapter> biN;
    private int cardWidth;
    private float cuT;
    private LoadMoreFooter gGv;
    private TbListCommonPullView hAj;
    private float lTt;
    private ValueAnimator mAnimator;
    private ViewGroup mBD;
    private View mBG;
    private int mBH;
    private float mBI;
    private final int mBL;
    private TextView mBO;
    private boolean mBP;
    private w mBQ;
    private View mBS;
    private View mBT;
    private Context mContext;
    private float mDownX;
    private int mOrientation;
    private int mScreenWidth;
    private int mShowType;
    private int mTouchSlop;
    private RecommendViewPager oaj;
    private AlaRecommendLiveListView oak;
    private InterfaceC0915a oal;
    private com.baidu.tieba.yuyinala.liveroom.recommend.model.b oam;
    private AlaLiveView oan;
    private FrameLayout oao;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.recommend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0915a {
        void ct(boolean z);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mBL = 100;
        if (tbPageContext != null) {
            this.mContext = getPageContext().getPageActivity();
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.mBH = this.mScreenWidth;
            dBr();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.d.Aq().getBoolean("yuyin_ala_recommend_live_first_show", true)) {
                this.mShowType = 1;
            }
        }
    }

    public void a(InterfaceC0915a interfaceC0915a) {
        this.oal = interfaceC0915a;
    }

    public void n(w wVar) {
        this.mBQ = wVar;
    }

    public void D(int i, int i2) {
        this.mOrientation = i2;
        if (i2 == 2) {
            this.mBG.setVisibility(8);
            if (isOpen()) {
                onClose();
                return;
            }
            return;
        }
        this.mBG.setVisibility(0);
    }

    public void a(AlaLiveView alaLiveView) {
        this.oan = alaLiveView;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void at(ViewGroup viewGroup) {
        super.at(viewGroup);
        if (viewGroup != null) {
            this.bIc = viewGroup;
            this.mBD = (ViewGroup) this.bIc.findViewById(a.f.ala_live_header_view);
            dBs();
            dBq();
            if (!this.mBP && com.baidu.live.aa.a.Ph().bms != null && this.mShowType != 1) {
                long j = com.baidu.live.d.Aq().getLong("yuyin_ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int Pn = com.baidu.live.aa.a.Ph().Pn();
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > Pn) {
                    this.mShowType = 2;
                }
            }
            IP(0);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void CD() {
        super.CD();
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
        if (this.bIc != null) {
            this.bIc.removeView(this.oaj);
            this.bIc.removeView(this.mBS);
        }
        this.oal = null;
        if (this.mBP) {
            com.baidu.live.d.Aq().putLong("yuyin_ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.mBQ = null;
        if (this.oam != null) {
            this.oam.reset();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        CD();
        if (this.oam != null) {
            this.oam.onDestroy();
        }
    }

    private void dBq() {
        if (this.aDO == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mBH, -1);
            this.aDO = LayoutInflater.from(this.mContext).inflate(a.g.yuyinala_recommend_live_content_layout, (ViewGroup) null);
            this.aDO.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aDO.findViewById(a.f.right_layout).setPadding(0, BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity()), 0, 0);
            }
            this.mBT = this.aDO.findViewById(a.f.block_view);
            this.mBT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.oao = (FrameLayout) this.aDO.findViewById(a.f.listView_layout);
            this.oak = (AlaRecommendLiveListView) this.aDO.findViewById(a.f.recommendLiveListView);
            this.hAj = new AlaListViewPullView(this.mContext);
            this.oak.setPullRefresh(this.hAj);
            this.gGv = new LoadMoreFooter(this.mContext);
            this.gGv.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
            this.gGv.setFooterHeight(this.cardWidth / 2);
            this.gGv.createView();
            Lp();
            this.oak.addAdapters(this.biN);
            this.hAj.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.IP(0);
                    if (!z) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, a.this.mBQ.aHZ.croom_id);
                        } catch (Exception e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "more_room", "pushfresh"));
                    }
                }
            });
            this.oak.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.gGv.isLoading() && a.this.oam != null && a.this.oam.hasMore && i + i2 > i3 - 2) {
                        a.this.bOq();
                        a.this.IP(1);
                    }
                }
            });
        }
        if (this.mBS == null) {
            this.mBS = new View(this.mContext);
            this.mBS.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha65));
            this.mBS.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mBS.setAlpha(0.0f);
        }
        this.bIc.addView(this.mBS);
        if (this.oaj == null) {
            this.oaj = new RecommendViewPager(getPageContext().getPageActivity());
            this.oaj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.oaj.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.4
                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    if (a.this.isOpen() && i == 0) {
                        a.this.mBS.setAlpha(f);
                    }
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    if (i == 0 && a.this.oaj != null) {
                        if (a.this.oaj.getCurrentItem() == 0) {
                            a.this.close();
                        } else {
                            a.this.dBu();
                        }
                    }
                }
            });
            ArrayList arrayList = new ArrayList();
            Space space = new Space(getPageContext().getPageActivity());
            space.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            arrayList.add(space);
            arrayList.add(this.aDO);
            this.oaj.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.mBH, -1);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = -this.mBH;
            this.oaj.setLayoutParams(layoutParams2);
        }
        this.bIc.addView(this.oaj);
        this.oaj.setCurrentItem(1, false);
        if (this.oam == null) {
            this.oam = new com.baidu.tieba.yuyinala.liveroom.recommend.model.b(getPageContext());
            this.oam.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.5
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

    private void dBr() {
        this.cardWidth = ((((this.mBH - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds340);
        }
    }

    private void Lp() {
        if (this.biN == null) {
            this.biN = new ArrayList();
            this.biN.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.b(this.mContext, c.mCA));
            this.biN.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a(this.mContext, com.baidu.tieba.yuyinala.liveroom.recommend.data.a.mCx, this.cardWidth, getPageContext()));
        }
    }

    private void dBs() {
        this.mBG = LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_recommend_live_header_entrance, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds14);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        this.mBG.setLayoutParams(layoutParams);
        if (this.mBD != null) {
            this.mBD.addView(this.mBG);
        }
        this.mBG.setOnClickListener(this);
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
                this.cuT = motionEvent.getY(i);
                this.lTt = this.mDownX;
                this.mBI = this.cuT;
                break;
            case 1:
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                float f = this.mDownX - x;
                float f2 = this.cuT - y;
                if (Math.abs(f) < this.mTouchSlop && Math.abs(f2) < this.mTouchSlop && x > 0.0f && x < this.mScreenWidth - this.mBH) {
                    onClose();
                    return true;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oaj.getLayoutParams();
                if (f > this.mTouchSlop) {
                    wN(true);
                    dBt();
                    return true;
                } else if (layoutParams.rightMargin > (-this.mBH)) {
                    onClose();
                    return true;
                }
                break;
            case 2:
                float x2 = motionEvent.getX(i);
                float y2 = motionEvent.getY(i);
                float f3 = this.lTt - x2;
                float f4 = this.mBI - y2;
                this.lTt = x2;
                this.mBI = y2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.oaj.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.oaj.setLayoutParams(layoutParams2);
                        this.mBS.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.mBH));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.mBH)) {
                        layoutParams2.rightMargin = i3;
                        this.oaj.setLayoutParams(layoutParams2);
                        this.mBS.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mBH));
                        return true;
                    } else if (i3 < (-this.mBH)) {
                        layoutParams2.rightMargin = -this.mBH;
                        this.oaj.setLayoutParams(layoutParams2);
                        this.mBS.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mBH));
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
        if (motionEvent == null || this.mOrientation == 2) {
            return false;
        }
        if (this.oan != null) {
            if (this.oan.getKeyboardVisibility()) {
                return false;
            }
            if (!this.oan.chs()) {
                close();
                return false;
            } else if (this.oan.getScrollX() != 0) {
                close();
                return false;
            }
        }
        return true;
    }

    private void dBt() {
    }

    public void wN(boolean z) {
        if ((this.mAnimator == null || !this.mAnimator.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            wO(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oaj.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                ae(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.mBH)));
            }
            if (this.oal != null) {
                this.oal.ct(true);
            }
            if (!this.mBP) {
                this.mBP = true;
            }
            this.oak.completePullRefresh();
            if (z) {
                IP(0);
            }
            dYl();
        }
    }

    private void dYl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.mBQ.aHZ.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", "more_room", null).setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IP(int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            b(CommonEmptyView.ImgType.NO_NET);
            return;
        }
        hideNoDataView();
        long j = 0;
        if (this.mBQ != null && this.mBQ.mLiveInfo != null) {
            j = this.mBQ.mLiveInfo.live_id;
        }
        this.oam.x(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<IAdapterData> list, int i, int i2) {
        if (this.oam.hasMore) {
            bSA();
        } else if (i2 == 1) {
            bSA();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.oak.setData(list);
        if (this.biN != null) {
            Iterator<AbsDelegateAdapter> it = this.biN.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbsDelegateAdapter next = it.next();
                if (next instanceof com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) {
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).MO(i);
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).setAlaLiveShowData(this.mBQ);
                    break;
                }
            }
        }
        if ((this.mShowType == 1 || this.mShowType == 2) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            if (this.mShowType == 1) {
                com.baidu.live.d.Aq().putBoolean("yuyin_ala_recommend_live_first_show", false);
            } else {
                com.baidu.live.d.Aq().putLong("yuyin_ala_recommend_live_last_show", System.currentTimeMillis());
            }
            this.mShowType = 0;
        }
        this.oak.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.oak != null) {
            if (this.oak != null && this.oak.getAdapter() != null && this.oak.getAdapter().getCount() > 0) {
                this.oak.completePullRefresh();
            } else if (this.oam != null && !this.oam.bBm() && this.oak != null) {
                if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                    BdUtilHelper.showToast(this.mContext, a.h.recommend_live_net_weak);
                }
                this.oak.completePullRefresh();
            } else {
                if (this.bDp == null) {
                    this.bDp = new CommonEmptyView(this.mContext);
                    ImageView imageView = (ImageView) this.bDp.findViewById(a.f.sdk_cev_img);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                    layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
                    layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
                    imageView.setLayoutParams(layoutParams);
                    ((TextView) this.bDp.findViewById(a.f.sdk_cev_title)).setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
                    this.mBO = (TextView) this.bDp.findViewById(a.f.sdk_cev_refresh_btn);
                    this.mBO.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize22));
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBO.getLayoutParams();
                    layoutParams2.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds152);
                    layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds54);
                    layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds30);
                    this.mBO.setLayoutParams(layoutParams2);
                    if (this.oao != null) {
                        this.bDp.addToParent(this.oao);
                    }
                }
                this.bDp.reset();
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
                this.bDp.setTitle(i);
                this.bDp.setRefreshButton(this.mContext.getResources().getString(a.h.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.hideNoDataView();
                        a.this.oak.startPullRefresh();
                    }
                });
                this.bDp.setup(imgType, CommonEmptyView.StyleType.DARK);
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
                    this.mBO.setBackgroundResource(a.e.ala_recommend_live_empty_refresh_btn_selector);
                }
                this.bDp.setVisibility(0);
                this.oak.completePullRefresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bDp != null) {
            this.bDp.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (this.oal != null) {
            this.oal.ct(false);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oaj.getLayoutParams();
        layoutParams.rightMargin = -this.mBH;
        this.oaj.setLayoutParams(layoutParams);
        this.oaj.setCurrentItem(1, false);
        this.mBS.setAlpha(0.0f);
    }

    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.oaj.getLayoutParams()).rightMargin > (-this.mBH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBu() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.oaj.getLayoutParams()).rightMargin * 1.0f) / this.mBH);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.mBS.setAlpha(abs);
    }

    public void onClose() {
        if (this.mAnimator == null || !this.mAnimator.isRunning()) {
            wO(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oaj.getLayoutParams();
            if (layoutParams.rightMargin > (-this.mBH)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.mBH;
                ae(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.mBH)));
            }
            if (this.oal != null) {
                this.oal.ct(false);
            }
            this.oak.completePullRefresh();
        }
    }

    private void ae(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.mAnimator = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.oaj.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.mBS.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.mBH));
                a.this.oaj.setLayoutParams(layoutParams);
            }
        });
        this.mAnimator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.oaj.setCurrentItem(1, false);
                if (i2 == 0) {
                    a.this.mBS.setAlpha(1.0f);
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
        if (view == this.mBG) {
            wN(true);
            dYm();
        }
    }

    private void dYm() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.mBQ.aHZ.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "moreroom_clk").setContentExt(jSONObject));
    }

    @Override // com.baidu.live.liveroom.g.b
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (ad(motionEvent) && isOpen()) {
            return d(motionEvent, motionEvent.getActionIndex());
        }
        return false;
    }

    @Override // com.baidu.live.liveroom.g.b
    public boolean Nr() {
        return false;
    }

    public void bSA() {
        if (this.gGv != null) {
            this.gGv.endLoadData();
            this.oak.setNextPage(null);
        }
    }

    public void bOq() {
        if (this.gGv != null) {
            if (this.gGv.getView().getParent() == null) {
                this.oak.setNextPage(this.gGv);
            }
            this.gGv.showLoadView();
        }
    }

    private void wO(boolean z) {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            UtilHelper.changeStatusBarIconAndTextColor(z, (Activity) this.mContext);
        }
    }
}
