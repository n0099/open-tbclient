package com.baidu.tieba.yuyinala.liveroom.recommend;

import android.animation.Animator;
import android.animation.ValueAnimator;
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
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdLog;
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
    private View aDL;
    private CommonEmptyView bMk;
    private ViewGroup bRb;
    private List<AbsDelegateAdapter> bns;
    private float cEl;
    private int cardWidth;
    private ValueAnimator dwJ;
    private int fop;
    private LoadMoreFooter gZJ;
    private TbListCommonPullView hWe;
    private Context mContext;
    private float mDownX;
    private int mOrientation;
    private int mScreenWidth;
    private int mTouchSlop;
    private float mrv;
    private boolean naA;
    private ab naB;
    private FrameLayout naC;
    private View naD;
    private View naE;
    private ViewGroup nao;
    private View nar;
    private int nas;
    private float nau;
    private TextView naz;
    private RecommendViewPager oyn;
    private AlaRecommendLiveListView oyo;
    private InterfaceC0934a oyp;
    private com.baidu.tieba.yuyinala.liveroom.recommend.model.b oyq;
    private AlaLiveView oyr;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.recommend.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0934a {
        void cP(boolean z);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        if (tbPageContext != null) {
            this.mContext = getPageContext().getPageActivity();
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.nas = this.mScreenWidth;
            coM();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.d.xc().getBoolean("yuyin_ala_recommend_live_first_show", true)) {
                this.fop = 1;
            }
        }
    }

    public void a(InterfaceC0934a interfaceC0934a) {
        this.oyp = interfaceC0934a;
    }

    public void o(ab abVar) {
        this.naB = abVar;
    }

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

    public void a(AlaLiveView alaLiveView) {
        this.oyr = alaLiveView;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        if (viewGroup != null) {
            this.bRb = viewGroup;
            this.nao = (ViewGroup) this.bRb.findViewById(a.f.ala_live_header_view);
            dEU();
            dET();
            if (!this.naA && com.baidu.live.ae.a.Qj().buX != null && this.fop != 1) {
                long j = com.baidu.live.d.xc().getLong("yuyin_ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int Qq = com.baidu.live.ae.a.Qj().Qq();
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > Qq) {
                    this.fop = 2;
                }
            }
            In(0);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Ar() {
        super.Ar();
        if (this.dwJ != null && this.dwJ.isRunning()) {
            this.dwJ.cancel();
            this.dwJ = null;
        }
        if (this.bRb != null) {
            this.bRb.removeView(this.oyn);
            this.bRb.removeView(this.naD);
        }
        this.oyp = null;
        if (this.naA) {
            com.baidu.live.d.xc().putLong("yuyin_ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.naB = null;
        if (this.oyq != null) {
            this.oyq.reset();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        Ar();
        if (this.oyq != null) {
            this.oyq.onDestroy();
        }
    }

    private void dET() {
        if (this.aDL == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.nas, -1);
            this.aDL = LayoutInflater.from(this.mContext).inflate(a.g.yuyinala_recommend_live_content_layout, (ViewGroup) null);
            this.aDL.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aDL.findViewById(a.f.right_layout).setPadding(0, BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity()), 0, 0);
            }
            this.naE = this.aDL.findViewById(a.f.block_view);
            this.naE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.naC = (FrameLayout) this.aDL.findViewById(a.f.listView_layout);
            this.oyo = (AlaRecommendLiveListView) this.aDL.findViewById(a.f.recommendLiveListView);
            this.hWe = new AlaListViewPullView(this.mContext);
            this.oyo.setPullRefresh(this.hWe);
            this.gZJ = new LoadMoreFooter(this.mContext);
            this.gZJ.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
            this.gZJ.setFooterHeight(this.cardWidth / 2);
            this.gZJ.createView();
            Kw();
            this.oyo.addAdapters(this.bns);
            this.hWe.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.3
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.In(0);
                    if (!z) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, a.this.naB.aIU.croom_id);
                        } catch (Exception e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "more_room", "pushfresh"));
                    }
                }
            });
            this.oyo.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.4
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.gZJ.isLoading() && a.this.oyq != null && a.this.oyq.hasMore && i + i2 > i3 - 2) {
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
        if (this.oyn == null) {
            this.oyn = new RecommendViewPager(getPageContext().getPageActivity());
            this.oyn.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.oyn.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.5
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
                    if (i == 0 && a.this.oyn != null) {
                        if (a.this.oyn.getCurrentItem() == 0) {
                            a.this.close();
                        } else {
                            a.this.dEW();
                        }
                    }
                }
            });
            ArrayList arrayList = new ArrayList();
            Space space = new Space(getPageContext().getPageActivity());
            space.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            arrayList.add(space);
            arrayList.add(this.aDL);
            this.oyn.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.nas, -1);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = -this.nas;
            this.oyn.setLayoutParams(layoutParams2);
        }
        this.bRb.addView(this.oyn);
        this.oyn.setCurrentItem(1, false);
        if (this.oyq == null) {
            this.oyq = new com.baidu.tieba.yuyinala.liveroom.recommend.model.b(getPageContext());
            this.oyq.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.6
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

    private void coM() {
        this.cardWidth = ((((this.nas - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds340);
        }
    }

    private void Kw() {
        if (this.bns == null) {
            this.bns = new ArrayList();
            this.bns.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.b(this.mContext, c.nbp));
            this.bns.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a(this.mContext, com.baidu.tieba.yuyinala.liveroom.recommend.data.a.nbl, this.cardWidth, getPageContext()));
        }
    }

    private void dEU() {
        this.nar = LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_recommend_live_header_entrance, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds14);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        this.nar.setLayoutParams(layoutParams);
        if (this.nao != null) {
            this.nao.addView(this.nar);
        }
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
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oyn.getLayoutParams();
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
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.oyn.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.oyn.setLayoutParams(layoutParams2);
                        this.naD.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.nas));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.nas)) {
                        layoutParams2.rightMargin = i3;
                        this.oyn.setLayoutParams(layoutParams2);
                        this.naD.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.nas));
                        return true;
                    } else if (i3 < (-this.nas)) {
                        layoutParams2.rightMargin = -this.nas;
                        this.oyn.setLayoutParams(layoutParams2);
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
        if (motionEvent == null || this.mOrientation == 2) {
            return false;
        }
        if (this.oyr != null) {
            if (this.oyr.getKeyboardVisibility()) {
                return false;
            }
            if (!this.oyr.clt()) {
                close();
                return false;
            } else if (this.oyr.getScrollX() != 0) {
                close();
                return false;
            }
        }
        return true;
    }

    private void dEV() {
    }

    public void xH(boolean z) {
        if ((this.dwJ == null || !this.dwJ.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oyn.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                ad(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.nas)));
            }
            if (this.oyp != null) {
                this.oyp.cP(true);
            }
            if (!this.naA) {
                this.naA = true;
            }
            this.oyo.completePullRefresh();
            if (z) {
                In(0);
            }
            ebM();
        }
    }

    private void ebM() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.naB.aIU.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", "more_room", null).setContentExt(jSONObject));
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
        this.oyq.z(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<IAdapterData> list, int i, int i2) {
        if (this.oyq.hasMore) {
            bVL();
        } else if (i2 == 1) {
            bVL();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.oyo.setData(list);
        if (this.bns != null) {
            Iterator<AbsDelegateAdapter> it = this.bns.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbsDelegateAdapter next = it.next();
                if (next instanceof com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) {
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).Mi(i);
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).setAlaLiveShowData(this.naB);
                    break;
                }
            }
        }
        if ((this.fop == 1 || this.fop == 2) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            if (this.fop == 1) {
                com.baidu.live.d.xc().putBoolean("yuyin_ala_recommend_live_first_show", false);
            } else {
                com.baidu.live.d.xc().putLong("yuyin_ala_recommend_live_last_show", System.currentTimeMillis());
            }
            this.fop = 0;
        }
        this.oyo.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.oyo != null) {
            if (this.oyo != null && this.oyo.getAdapter() != null && this.oyo.getAdapter().getCount() > 0) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.oyo != null) {
                            a.this.oyo.completePullRefresh();
                        }
                    }
                }, 1000L);
            } else if (this.oyq != null && !this.oyq.isDataEmpty() && this.oyo != null) {
                if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                    BdUtilHelper.showToast(this.mContext, a.h.recommend_live_net_weak);
                }
                this.oyo.completePullRefresh();
            } else {
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
                this.bMk.setRefreshButton(this.mContext.getResources().getString(a.h.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.hideNoDataView();
                        a.this.oyo.startPullRefresh();
                    }
                });
                this.bMk.setup(imgType, CommonEmptyView.StyleType.DARK);
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
                    this.naz.setBackgroundResource(a.e.ala_recommend_live_empty_refresh_btn_selector);
                }
                this.bMk.setVisibility(0);
                this.oyo.completePullRefresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bMk != null) {
            this.bMk.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        if (this.dwJ != null && this.dwJ.isRunning()) {
            this.dwJ.cancel();
        }
        if (this.oyp != null) {
            this.oyp.cP(false);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oyn.getLayoutParams();
        layoutParams.rightMargin = -this.nas;
        this.oyn.setLayoutParams(layoutParams);
        this.oyn.setCurrentItem(1, false);
        this.naD.setAlpha(0.0f);
    }

    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.oyn.getLayoutParams()).rightMargin > (-this.nas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEW() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.oyn.getLayoutParams()).rightMargin * 1.0f) / this.nas);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.naD.setAlpha(abs);
    }

    public void onClose() {
        if (this.dwJ == null || !this.dwJ.isRunning()) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oyn.getLayoutParams();
            if (layoutParams.rightMargin > (-this.nas)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.nas;
                ad(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.nas)));
            }
            if (this.oyp != null) {
                this.oyp.cP(false);
            }
            this.oyo.completePullRefresh();
        }
    }

    private void ad(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.dwJ = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.dwJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.oyn.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.naD.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.nas));
                a.this.oyn.setLayoutParams(layoutParams);
            }
        });
        this.dwJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.oyn.setCurrentItem(1, false);
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
            xH(true);
            ebN();
        }
    }

    private void ebN() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.naB.aIU.croom_id);
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
    public boolean Nc() {
        return false;
    }

    public void bVL() {
        if (this.gZJ != null) {
            this.gZJ.endLoadData();
            this.oyo.setNextPage(null);
        }
    }

    public void bRy() {
        if (this.gZJ != null) {
            if (this.gZJ.getView().getParent() == null) {
                this.oyo.setNextPage(this.gZJ);
            }
            this.gZJ.showLoadView();
        }
    }
}
