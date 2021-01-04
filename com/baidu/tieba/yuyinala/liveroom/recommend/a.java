package com.baidu.tieba.yuyinala.liveroom.recommend;

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
import com.baidu.live.adp.lib.util.BdLog;
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
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a implements View.OnClickListener, b, d {
    private View aGL;
    private CommonEmptyView bNm;
    private ViewGroup bRX;
    private List<AbsDelegateAdapter> boM;
    private float cGB;
    private int cardWidth;
    private ValueAnimator dzn;
    private int fqH;
    private TbListCommonPullView hWc;
    private LoadMoreFooter hbr;
    private Context mContext;
    private float mDownX;
    private int mOrientation;
    private int mScreenWidth;
    private int mTouchSlop;
    private ViewGroup mVd;
    private View mVg;
    private int mVh;
    private float mVi;
    private final int mVl;
    private TextView mVo;
    private boolean mVp;
    private x mVq;
    private FrameLayout mVr;
    private View mVs;
    private View mVt;
    private float mmK;
    private RecommendViewPager osE;
    private AlaRecommendLiveListView osF;
    private InterfaceC0907a osG;
    private com.baidu.tieba.yuyinala.liveroom.recommend.model.b osH;
    private AlaLiveView osI;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.recommend.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0907a {
        void cK(boolean z);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mVl = 100;
        if (tbPageContext != null) {
            this.mContext = getPageContext().getPageActivity();
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.mVh = this.mScreenWidth;
            cry();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.d.Ba().getBoolean("yuyin_ala_recommend_live_first_show", true)) {
                this.fqH = 1;
            }
        }
    }

    public void a(InterfaceC0907a interfaceC0907a) {
        this.osG = interfaceC0907a;
    }

    public void o(x xVar) {
        this.mVq = xVar;
    }

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

    public void a(AlaLiveView alaLiveView) {
        this.osI = alaLiveView;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        if (viewGroup != null) {
            this.bRX = viewGroup;
            this.mVd = (ViewGroup) this.bRX.findViewById(a.f.ala_live_header_view);
            dGt();
            dGs();
            if (!this.mVp && com.baidu.live.af.a.SE().bwi != null && this.fqH != 1) {
                long j = com.baidu.live.d.Ba().getLong("yuyin_ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int SK = com.baidu.live.af.a.SE().SK();
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > SK) {
                    this.fqH = 2;
                }
            }
            JA(0);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void DC() {
        super.DC();
        if (this.dzn != null && this.dzn.isRunning()) {
            this.dzn.cancel();
            this.dzn = null;
        }
        if (this.bRX != null) {
            this.bRX.removeView(this.osE);
            this.bRX.removeView(this.mVs);
        }
        this.osG = null;
        if (this.mVp) {
            com.baidu.live.d.Ba().putLong("yuyin_ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.mVq = null;
        if (this.osH != null) {
            this.osH.reset();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        DC();
        if (this.osH != null) {
            this.osH.onDestroy();
        }
    }

    private void dGs() {
        if (this.aGL == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mVh, -1);
            this.aGL = LayoutInflater.from(this.mContext).inflate(a.g.yuyinala_recommend_live_content_layout, (ViewGroup) null);
            this.aGL.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aGL.findViewById(a.f.right_layout).setPadding(0, BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity()), 0, 0);
            }
            this.mVt = this.aGL.findViewById(a.f.block_view);
            this.mVt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.mVr = (FrameLayout) this.aGL.findViewById(a.f.listView_layout);
            this.osF = (AlaRecommendLiveListView) this.aGL.findViewById(a.f.recommendLiveListView);
            this.hWc = new AlaListViewPullView(this.mContext);
            this.osF.setPullRefresh(this.hWc);
            this.hbr = new LoadMoreFooter(this.mContext);
            this.hbr.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
            this.hbr.setFooterHeight(this.cardWidth / 2);
            this.hbr.createView();
            MT();
            this.osF.addAdapters(this.boM);
            this.hWc.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.JA(0);
                    if (!z) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, a.this.mVq.aLl.croom_id);
                        } catch (Exception e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "more_room", "pushfresh"));
                    }
                }
            });
            this.osF.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.hbr.isLoading() && a.this.osH != null && a.this.osH.hasMore && i + i2 > i3 - 2) {
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
        if (this.osE == null) {
            this.osE = new RecommendViewPager(getPageContext().getPageActivity());
            this.osE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.osE.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.4
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
                    if (i == 0 && a.this.osE != null) {
                        if (a.this.osE.getCurrentItem() == 0) {
                            a.this.close();
                        } else {
                            a.this.dGv();
                        }
                    }
                }
            });
            ArrayList arrayList = new ArrayList();
            Space space = new Space(getPageContext().getPageActivity());
            space.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            arrayList.add(space);
            arrayList.add(this.aGL);
            this.osE.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.mVh, -1);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = -this.mVh;
            this.osE.setLayoutParams(layoutParams2);
        }
        this.bRX.addView(this.osE);
        this.osE.setCurrentItem(1, false);
        if (this.osH == null) {
            this.osH = new com.baidu.tieba.yuyinala.liveroom.recommend.model.b(getPageContext());
            this.osH.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.5
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

    private void cry() {
        this.cardWidth = ((((this.mVh - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds340);
        }
    }

    private void MT() {
        if (this.boM == null) {
            this.boM = new ArrayList();
            this.boM.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.b(this.mContext, c.mWe));
            this.boM.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a(this.mContext, com.baidu.tieba.yuyinala.liveroom.recommend.data.a.mWa, this.cardWidth, getPageContext()));
        }
    }

    private void dGt() {
        this.mVg = LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_recommend_live_header_entrance, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds14);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        this.mVg.setLayoutParams(layoutParams);
        if (this.mVd != null) {
            this.mVd.addView(this.mVg);
        }
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
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.osE.getLayoutParams();
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
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.osE.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.osE.setLayoutParams(layoutParams2);
                        this.mVs.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.mVh));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.mVh)) {
                        layoutParams2.rightMargin = i3;
                        this.osE.setLayoutParams(layoutParams2);
                        this.mVs.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mVh));
                        return true;
                    } else if (i3 < (-this.mVh)) {
                        layoutParams2.rightMargin = -this.mVh;
                        this.osE.setLayoutParams(layoutParams2);
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
        if (motionEvent == null || this.mOrientation == 2) {
            return false;
        }
        if (this.osI != null) {
            if (this.osI.getKeyboardVisibility()) {
                return false;
            }
            if (!this.osI.cof()) {
                close();
                return false;
            } else if (this.osI.getScrollX() != 0) {
                close();
                return false;
            }
        }
        return true;
    }

    private void dGu() {
    }

    public void xs(boolean z) {
        if ((this.dzn == null || !this.dzn.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            xt(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.osE.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                af(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.mVh)));
            }
            if (this.osG != null) {
                this.osG.cK(true);
            }
            if (!this.mVp) {
                this.mVp = true;
            }
            this.osF.completePullRefresh();
            if (z) {
                JA(0);
            }
            edi();
        }
    }

    private void edi() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.mVq.aLl.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", "more_room", null).setContentExt(jSONObject));
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
        this.osH.B(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<IAdapterData> list, int i, int i2) {
        if (this.osH.hasMore) {
            bYQ();
        } else if (i2 == 1) {
            bYQ();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.osF.setData(list);
        if (this.boM != null) {
            Iterator<AbsDelegateAdapter> it = this.boM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbsDelegateAdapter next = it.next();
                if (next instanceof com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) {
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).Nt(i);
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).setAlaLiveShowData(this.mVq);
                    break;
                }
            }
        }
        if ((this.fqH == 1 || this.fqH == 2) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            if (this.fqH == 1) {
                com.baidu.live.d.Ba().putBoolean("yuyin_ala_recommend_live_first_show", false);
            } else {
                com.baidu.live.d.Ba().putLong("yuyin_ala_recommend_live_last_show", System.currentTimeMillis());
            }
            this.fqH = 0;
        }
        this.osF.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.osF != null) {
            if (this.osF != null && this.osF.getAdapter() != null && this.osF.getAdapter().getCount() > 0) {
                this.osF.completePullRefresh();
            } else if (this.osH != null && !this.osH.isDataEmpty() && this.osF != null) {
                if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                    BdUtilHelper.showToast(this.mContext, a.h.recommend_live_net_weak);
                }
                this.osF.completePullRefresh();
            } else {
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
                this.bNm.setRefreshButton(this.mContext.getResources().getString(a.h.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.hideNoDataView();
                        a.this.osF.startPullRefresh();
                    }
                });
                this.bNm.setup(imgType, CommonEmptyView.StyleType.DARK);
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
                    this.mVo.setBackgroundResource(a.e.ala_recommend_live_empty_refresh_btn_selector);
                }
                this.bNm.setVisibility(0);
                this.osF.completePullRefresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bNm != null) {
            this.bNm.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        if (this.dzn != null && this.dzn.isRunning()) {
            this.dzn.cancel();
        }
        if (this.osG != null) {
            this.osG.cK(false);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.osE.getLayoutParams();
        layoutParams.rightMargin = -this.mVh;
        this.osE.setLayoutParams(layoutParams);
        this.osE.setCurrentItem(1, false);
        this.mVs.setAlpha(0.0f);
    }

    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.osE.getLayoutParams()).rightMargin > (-this.mVh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGv() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.osE.getLayoutParams()).rightMargin * 1.0f) / this.mVh);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.mVs.setAlpha(abs);
    }

    public void onClose() {
        if (this.dzn == null || !this.dzn.isRunning()) {
            xt(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.osE.getLayoutParams();
            if (layoutParams.rightMargin > (-this.mVh)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.mVh;
                af(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.mVh)));
            }
            if (this.osG != null) {
                this.osG.cK(false);
            }
            this.osF.completePullRefresh();
        }
    }

    private void af(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.dzn = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.dzn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.osE.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.mVs.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.mVh));
                a.this.osE.setLayoutParams(layoutParams);
            }
        });
        this.dzn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.osE.setCurrentItem(1, false);
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
            xs(true);
            edj();
        }
    }

    private void edj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.mVq.aLl.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "moreroom_clk").setContentExt(jSONObject));
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
            this.osF.setNextPage(null);
        }
    }

    public void bUE() {
        if (this.hbr != null) {
            if (this.hbr.getView().getParent() == null) {
                this.osF.setNextPage(this.hbr);
            }
            this.hbr.showLoadView();
        }
    }

    private void xt(boolean z) {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            UtilHelper.changeStatusBarIconAndTextColor(z, (Activity) this.mContext);
        }
    }
}
