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
    private LoadMoreFooter gZv;
    private TbListCommonPullView hVQ;
    private Context mContext;
    private float mDownX;
    private int mOrientation;
    private int mScreenWidth;
    private int mTouchSlop;
    private ViewGroup mZO;
    private View mZR;
    private int mZS;
    private float mZT;
    private TextView mZY;
    private boolean mZZ;
    private float mrg;
    private ab naa;
    private FrameLayout nab;
    private View nac;
    private View nad;
    private RecommendViewPager oxN;
    private AlaRecommendLiveListView oxO;
    private InterfaceC0932a oxP;
    private com.baidu.tieba.yuyinala.liveroom.recommend.model.b oxQ;
    private AlaLiveView oxR;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.recommend.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0932a {
        void cP(boolean z);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        if (tbPageContext != null) {
            this.mContext = getPageContext().getPageActivity();
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.mZS = this.mScreenWidth;
            coF();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.d.xc().getBoolean("yuyin_ala_recommend_live_first_show", true)) {
                this.fop = 1;
            }
        }
    }

    public void a(InterfaceC0932a interfaceC0932a) {
        this.oxP = interfaceC0932a;
    }

    public void o(ab abVar) {
        this.naa = abVar;
    }

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

    public void a(AlaLiveView alaLiveView) {
        this.oxR = alaLiveView;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        if (viewGroup != null) {
            this.bRb = viewGroup;
            this.mZO = (ViewGroup) this.bRb.findViewById(a.f.ala_live_header_view);
            dEM();
            dEL();
            if (!this.mZZ && com.baidu.live.ae.a.Qj().buX != null && this.fop != 1) {
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
            this.bRb.removeView(this.oxN);
            this.bRb.removeView(this.nac);
        }
        this.oxP = null;
        if (this.mZZ) {
            com.baidu.live.d.xc().putLong("yuyin_ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.naa = null;
        if (this.oxQ != null) {
            this.oxQ.reset();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        Ar();
        if (this.oxQ != null) {
            this.oxQ.onDestroy();
        }
    }

    private void dEL() {
        if (this.aDL == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mZS, -1);
            this.aDL = LayoutInflater.from(this.mContext).inflate(a.g.yuyinala_recommend_live_content_layout, (ViewGroup) null);
            this.aDL.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aDL.findViewById(a.f.right_layout).setPadding(0, BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity()), 0, 0);
            }
            this.nad = this.aDL.findViewById(a.f.block_view);
            this.nad.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.nab = (FrameLayout) this.aDL.findViewById(a.f.listView_layout);
            this.oxO = (AlaRecommendLiveListView) this.aDL.findViewById(a.f.recommendLiveListView);
            this.hVQ = new AlaListViewPullView(this.mContext);
            this.oxO.setPullRefresh(this.hVQ);
            this.gZv = new LoadMoreFooter(this.mContext);
            this.gZv.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
            this.gZv.setFooterHeight(this.cardWidth / 2);
            this.gZv.createView();
            Kw();
            this.oxO.addAdapters(this.bns);
            this.hVQ.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.3
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.In(0);
                    if (!z) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, a.this.naa.aIU.croom_id);
                        } catch (Exception e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "more_room", "pushfresh"));
                    }
                }
            });
            this.oxO.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.4
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.gZv.isLoading() && a.this.oxQ != null && a.this.oxQ.hasMore && i + i2 > i3 - 2) {
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
        if (this.oxN == null) {
            this.oxN = new RecommendViewPager(getPageContext().getPageActivity());
            this.oxN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.oxN.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.5
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
                    if (i == 0 && a.this.oxN != null) {
                        if (a.this.oxN.getCurrentItem() == 0) {
                            a.this.close();
                        } else {
                            a.this.dEO();
                        }
                    }
                }
            });
            ArrayList arrayList = new ArrayList();
            Space space = new Space(getPageContext().getPageActivity());
            space.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            arrayList.add(space);
            arrayList.add(this.aDL);
            this.oxN.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.mZS, -1);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = -this.mZS;
            this.oxN.setLayoutParams(layoutParams2);
        }
        this.bRb.addView(this.oxN);
        this.oxN.setCurrentItem(1, false);
        if (this.oxQ == null) {
            this.oxQ = new com.baidu.tieba.yuyinala.liveroom.recommend.model.b(getPageContext());
            this.oxQ.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.6
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

    private void coF() {
        this.cardWidth = ((((this.mZS - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds340);
        }
    }

    private void Kw() {
        if (this.bns == null) {
            this.bns = new ArrayList();
            this.bns.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.b(this.mContext, c.naP));
            this.bns.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a(this.mContext, com.baidu.tieba.yuyinala.liveroom.recommend.data.a.naL, this.cardWidth, getPageContext()));
        }
    }

    private void dEM() {
        this.mZR = LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_recommend_live_header_entrance, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds14);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        this.mZR.setLayoutParams(layoutParams);
        if (this.mZO != null) {
            this.mZO.addView(this.mZR);
        }
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
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oxN.getLayoutParams();
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
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.oxN.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.oxN.setLayoutParams(layoutParams2);
                        this.nac.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.mZS));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.mZS)) {
                        layoutParams2.rightMargin = i3;
                        this.oxN.setLayoutParams(layoutParams2);
                        this.nac.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mZS));
                        return true;
                    } else if (i3 < (-this.mZS)) {
                        layoutParams2.rightMargin = -this.mZS;
                        this.oxN.setLayoutParams(layoutParams2);
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
        if (motionEvent == null || this.mOrientation == 2) {
            return false;
        }
        if (this.oxR != null) {
            if (this.oxR.getKeyboardVisibility()) {
                return false;
            }
            if (!this.oxR.clm()) {
                close();
                return false;
            } else if (this.oxR.getScrollX() != 0) {
                close();
                return false;
            }
        }
        return true;
    }

    private void dEN() {
    }

    public void xH(boolean z) {
        if ((this.dwJ == null || !this.dwJ.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oxN.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                ad(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.mZS)));
            }
            if (this.oxP != null) {
                this.oxP.cP(true);
            }
            if (!this.mZZ) {
                this.mZZ = true;
            }
            this.oxO.completePullRefresh();
            if (z) {
                In(0);
            }
            ebE();
        }
    }

    private void ebE() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.naa.aIU.croom_id);
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
        if (this.naa != null && this.naa.mLiveInfo != null) {
            j = this.naa.mLiveInfo.live_id;
        }
        this.oxQ.z(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<IAdapterData> list, int i, int i2) {
        if (this.oxQ.hasMore) {
            bVE();
        } else if (i2 == 1) {
            bVE();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.oxO.setData(list);
        if (this.bns != null) {
            Iterator<AbsDelegateAdapter> it = this.bns.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbsDelegateAdapter next = it.next();
                if (next instanceof com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) {
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).Mh(i);
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).setAlaLiveShowData(this.naa);
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
        this.oxO.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.oxO != null) {
            if (this.oxO != null && this.oxO.getAdapter() != null && this.oxO.getAdapter().getCount() > 0) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.oxO != null) {
                            a.this.oxO.completePullRefresh();
                        }
                    }
                }, 1000L);
            } else if (this.oxQ != null && !this.oxQ.isDataEmpty() && this.oxO != null) {
                if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                    BdUtilHelper.showToast(this.mContext, a.h.recommend_live_net_weak);
                }
                this.oxO.completePullRefresh();
            } else {
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
                this.bMk.setRefreshButton(this.mContext.getResources().getString(a.h.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.hideNoDataView();
                        a.this.oxO.startPullRefresh();
                    }
                });
                this.bMk.setup(imgType, CommonEmptyView.StyleType.DARK);
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
                    this.mZY.setBackgroundResource(a.e.ala_recommend_live_empty_refresh_btn_selector);
                }
                this.bMk.setVisibility(0);
                this.oxO.completePullRefresh();
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
        if (this.oxP != null) {
            this.oxP.cP(false);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oxN.getLayoutParams();
        layoutParams.rightMargin = -this.mZS;
        this.oxN.setLayoutParams(layoutParams);
        this.oxN.setCurrentItem(1, false);
        this.nac.setAlpha(0.0f);
    }

    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.oxN.getLayoutParams()).rightMargin > (-this.mZS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEO() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.oxN.getLayoutParams()).rightMargin * 1.0f) / this.mZS);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.nac.setAlpha(abs);
    }

    public void onClose() {
        if (this.dwJ == null || !this.dwJ.isRunning()) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oxN.getLayoutParams();
            if (layoutParams.rightMargin > (-this.mZS)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.mZS;
                ad(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.mZS)));
            }
            if (this.oxP != null) {
                this.oxP.cP(false);
            }
            this.oxO.completePullRefresh();
        }
    }

    private void ad(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.dwJ = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.dwJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.oxN.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.nac.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.mZS));
                a.this.oxN.setLayoutParams(layoutParams);
            }
        });
        this.dwJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.oxN.setCurrentItem(1, false);
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
            xH(true);
            ebF();
        }
    }

    private void ebF() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.naa.aIU.croom_id);
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

    public void bVE() {
        if (this.gZv != null) {
            this.gZv.endLoadData();
            this.oxO.setNextPage(null);
        }
    }

    public void bRr() {
        if (this.gZv != null) {
            if (this.gZv.getView().getParent() == null) {
                this.oxO.setNextPage(this.gZv);
            }
            this.gZv.showLoadView();
        }
    }
}
