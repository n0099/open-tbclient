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
    private View aGu;
    private CommonEmptyView bIx;
    private ViewGroup bNk;
    private List<AbsDelegateAdapter> bnf;
    private float cBL;
    private int cardWidth;
    private LoadMoreFooter gPC;
    private TbListCommonPullView hJO;
    private ValueAnimator mAnimator;
    private Context mContext;
    private float mDownX;
    private int mOrientation;
    private ViewGroup mPN;
    private View mPQ;
    private int mPR;
    private float mPS;
    private final int mPV;
    private TextView mPY;
    private boolean mPZ;
    private w mQa;
    private View mQc;
    private View mQd;
    private int mScreenWidth;
    private int mShowType;
    private int mTouchSlop;
    private float mhy;
    private RecommendViewPager opj;
    private AlaRecommendLiveListView opk;
    private InterfaceC0932a opl;
    private com.baidu.tieba.yuyinala.liveroom.recommend.model.b opm;
    private AlaLiveView opn;
    private FrameLayout opo;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.recommend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0932a {
        void cH(boolean z);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPV = 100;
        if (tbPageContext != null) {
            this.mContext = getPageContext().getPageActivity();
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.mPR = this.mScreenWidth;
            coE();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.d.BM().getBoolean("yuyin_ala_recommend_live_first_show", true)) {
                this.mShowType = 1;
            }
        }
    }

    public void a(InterfaceC0932a interfaceC0932a) {
        this.opl = interfaceC0932a;
    }

    public void n(w wVar) {
        this.mQa = wVar;
    }

    public void C(int i, int i2) {
        this.mOrientation = i2;
        if (i2 == 2) {
            this.mPQ.setVisibility(8);
            if (isOpen()) {
                onClose();
                return;
            }
            return;
        }
        this.mPQ.setVisibility(0);
    }

    public void a(AlaLiveView alaLiveView) {
        this.opn = alaLiveView;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void at(ViewGroup viewGroup) {
        super.at(viewGroup);
        if (viewGroup != null) {
            this.bNk = viewGroup;
            this.mPN = (ViewGroup) this.bNk.findViewById(a.f.ala_live_header_view);
            dGD();
            dGC();
            if (!this.mPZ && com.baidu.live.ae.a.RB().brA != null && this.mShowType != 1) {
                long j = com.baidu.live.d.BM().getLong("yuyin_ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int RH = com.baidu.live.ae.a.RB().RH();
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > RH) {
                    this.mShowType = 2;
                }
            }
            JG(0);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void En() {
        super.En();
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
        if (this.bNk != null) {
            this.bNk.removeView(this.opj);
            this.bNk.removeView(this.mQc);
        }
        this.opl = null;
        if (this.mPZ) {
            com.baidu.live.d.BM().putLong("yuyin_ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.mQa = null;
        if (this.opm != null) {
            this.opm.reset();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        En();
        if (this.opm != null) {
            this.opm.onDestroy();
        }
    }

    private void dGC() {
        if (this.aGu == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPR, -1);
            this.aGu = LayoutInflater.from(this.mContext).inflate(a.g.yuyinala_recommend_live_content_layout, (ViewGroup) null);
            this.aGu.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aGu.findViewById(a.f.right_layout).setPadding(0, BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity()), 0, 0);
            }
            this.mQd = this.aGu.findViewById(a.f.block_view);
            this.mQd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.opo = (FrameLayout) this.aGu.findViewById(a.f.listView_layout);
            this.opk = (AlaRecommendLiveListView) this.aGu.findViewById(a.f.recommendLiveListView);
            this.hJO = new AlaListViewPullView(this.mContext);
            this.opk.setPullRefresh(this.hJO);
            this.gPC = new LoadMoreFooter(this.mContext);
            this.gPC.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
            this.gPC.setFooterHeight(this.cardWidth / 2);
            this.gPC.createView();
            Nt();
            this.opk.addAdapters(this.bnf);
            this.hJO.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.JG(0);
                    if (!z) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, a.this.mQa.aKL.croom_id);
                        } catch (Exception e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "more_room", "pushfresh"));
                    }
                }
            });
            this.opk.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.gPC.isLoading() && a.this.opm != null && a.this.opm.hasMore && i + i2 > i3 - 2) {
                        a.this.bSb();
                        a.this.JG(1);
                    }
                }
            });
        }
        if (this.mQc == null) {
            this.mQc = new View(this.mContext);
            this.mQc.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha65));
            this.mQc.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mQc.setAlpha(0.0f);
        }
        this.bNk.addView(this.mQc);
        if (this.opj == null) {
            this.opj = new RecommendViewPager(getPageContext().getPageActivity());
            this.opj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.opj.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.4
                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    if (a.this.isOpen() && i == 0) {
                        a.this.mQc.setAlpha(f);
                    }
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    if (i == 0 && a.this.opj != null) {
                        if (a.this.opj.getCurrentItem() == 0) {
                            a.this.close();
                        } else {
                            a.this.dGF();
                        }
                    }
                }
            });
            ArrayList arrayList = new ArrayList();
            Space space = new Space(getPageContext().getPageActivity());
            space.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            arrayList.add(space);
            arrayList.add(this.aGu);
            this.opj.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.mPR, -1);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = -this.mPR;
            this.opj.setLayoutParams(layoutParams2);
        }
        this.bNk.addView(this.opj);
        this.opj.setCurrentItem(1, false);
        if (this.opm == null) {
            this.opm = new com.baidu.tieba.yuyinala.liveroom.recommend.model.b(getPageContext());
            this.opm.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.5
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

    private void coE() {
        this.cardWidth = ((((this.mPR - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds340);
        }
    }

    private void Nt() {
        if (this.bnf == null) {
            this.bnf = new ArrayList();
            this.bnf.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.b(this.mContext, c.mQC));
            this.bnf.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a(this.mContext, com.baidu.tieba.yuyinala.liveroom.recommend.data.a.mQz, this.cardWidth, getPageContext()));
        }
    }

    private void dGD() {
        this.mPQ = LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_recommend_live_header_entrance, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds14);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        this.mPQ.setLayoutParams(layoutParams);
        if (this.mPN != null) {
            this.mPN.addView(this.mPQ);
        }
        this.mPQ.setOnClickListener(this);
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
                this.cBL = motionEvent.getY(i);
                this.mhy = this.mDownX;
                this.mPS = this.cBL;
                break;
            case 1:
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                float f = this.mDownX - x;
                float f2 = this.cBL - y;
                if (Math.abs(f) < this.mTouchSlop && Math.abs(f2) < this.mTouchSlop && x > 0.0f && x < this.mScreenWidth - this.mPR) {
                    onClose();
                    return true;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.opj.getLayoutParams();
                if (f > this.mTouchSlop) {
                    xr(true);
                    dGE();
                    return true;
                } else if (layoutParams.rightMargin > (-this.mPR)) {
                    onClose();
                    return true;
                }
                break;
            case 2:
                float x2 = motionEvent.getX(i);
                float y2 = motionEvent.getY(i);
                float f3 = this.mhy - x2;
                float f4 = this.mPS - y2;
                this.mhy = x2;
                this.mPS = y2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.opj.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.opj.setLayoutParams(layoutParams2);
                        this.mQc.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.mPR));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.mPR)) {
                        layoutParams2.rightMargin = i3;
                        this.opj.setLayoutParams(layoutParams2);
                        this.mQc.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mPR));
                        return true;
                    } else if (i3 < (-this.mPR)) {
                        layoutParams2.rightMargin = -this.mPR;
                        this.opj.setLayoutParams(layoutParams2);
                        this.mQc.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mPR));
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
        if (this.opn != null) {
            if (this.opn.getKeyboardVisibility()) {
                return false;
            }
            if (!this.opn.cln()) {
                close();
                return false;
            } else if (this.opn.getScrollX() != 0) {
                close();
                return false;
            }
        }
        return true;
    }

    private void dGE() {
    }

    public void xr(boolean z) {
        if ((this.mAnimator == null || !this.mAnimator.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            xs(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.opj.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                ad(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.mPR)));
            }
            if (this.opl != null) {
                this.opl.cH(true);
            }
            if (!this.mPZ) {
                this.mPZ = true;
            }
            this.opk.completePullRefresh();
            if (z) {
                JG(0);
            }
            edP();
        }
    }

    private void edP() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.mQa.aKL.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", "more_room", null).setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JG(int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            b(CommonEmptyView.ImgType.NO_NET);
            return;
        }
        hideNoDataView();
        long j = 0;
        if (this.mQa != null && this.mQa.mLiveInfo != null) {
            j = this.mQa.mLiveInfo.live_id;
        }
        this.opm.z(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<IAdapterData> list, int i, int i2) {
        if (this.opm.hasMore) {
            bWk();
        } else if (i2 == 1) {
            bWk();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.opk.setData(list);
        if (this.bnf != null) {
            Iterator<AbsDelegateAdapter> it = this.bnf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbsDelegateAdapter next = it.next();
                if (next instanceof com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) {
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).NG(i);
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).setAlaLiveShowData(this.mQa);
                    break;
                }
            }
        }
        if ((this.mShowType == 1 || this.mShowType == 2) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            if (this.mShowType == 1) {
                com.baidu.live.d.BM().putBoolean("yuyin_ala_recommend_live_first_show", false);
            } else {
                com.baidu.live.d.BM().putLong("yuyin_ala_recommend_live_last_show", System.currentTimeMillis());
            }
            this.mShowType = 0;
        }
        this.opk.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.opk != null) {
            if (this.opk != null && this.opk.getAdapter() != null && this.opk.getAdapter().getCount() > 0) {
                this.opk.completePullRefresh();
            } else if (this.opm != null && !this.opm.bEO() && this.opk != null) {
                if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                    BdUtilHelper.showToast(this.mContext, a.h.recommend_live_net_weak);
                }
                this.opk.completePullRefresh();
            } else {
                if (this.bIx == null) {
                    this.bIx = new CommonEmptyView(this.mContext);
                    ImageView imageView = (ImageView) this.bIx.findViewById(a.f.sdk_cev_img);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                    layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
                    layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
                    imageView.setLayoutParams(layoutParams);
                    ((TextView) this.bIx.findViewById(a.f.sdk_cev_title)).setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
                    this.mPY = (TextView) this.bIx.findViewById(a.f.sdk_cev_refresh_btn);
                    this.mPY.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize22));
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mPY.getLayoutParams();
                    layoutParams2.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds152);
                    layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds54);
                    layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds30);
                    this.mPY.setLayoutParams(layoutParams2);
                    if (this.opo != null) {
                        this.bIx.addToParent(this.opo);
                    }
                }
                this.bIx.reset();
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
                this.bIx.setTitle(i);
                this.bIx.setRefreshButton(this.mContext.getResources().getString(a.h.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.hideNoDataView();
                        a.this.opk.startPullRefresh();
                    }
                });
                this.bIx.setup(imgType, CommonEmptyView.StyleType.DARK);
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
                    this.mPY.setBackgroundResource(a.e.ala_recommend_live_empty_refresh_btn_selector);
                }
                this.bIx.setVisibility(0);
                this.opk.completePullRefresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bIx != null) {
            this.bIx.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (this.opl != null) {
            this.opl.cH(false);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.opj.getLayoutParams();
        layoutParams.rightMargin = -this.mPR;
        this.opj.setLayoutParams(layoutParams);
        this.opj.setCurrentItem(1, false);
        this.mQc.setAlpha(0.0f);
    }

    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.opj.getLayoutParams()).rightMargin > (-this.mPR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGF() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.opj.getLayoutParams()).rightMargin * 1.0f) / this.mPR);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.mQc.setAlpha(abs);
    }

    public void onClose() {
        if (this.mAnimator == null || !this.mAnimator.isRunning()) {
            xs(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.opj.getLayoutParams();
            if (layoutParams.rightMargin > (-this.mPR)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.mPR;
                ad(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.mPR)));
            }
            if (this.opl != null) {
                this.opl.cH(false);
            }
            this.opk.completePullRefresh();
        }
    }

    private void ad(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.mAnimator = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.opj.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.mQc.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.mPR));
                a.this.opj.setLayoutParams(layoutParams);
            }
        });
        this.mAnimator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.opj.setCurrentItem(1, false);
                if (i2 == 0) {
                    a.this.mQc.setAlpha(1.0f);
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
        if (view == this.mPQ) {
            xr(true);
            edQ();
        }
    }

    private void edQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.mQa.aKL.croom_id);
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
    public boolean PK() {
        return false;
    }

    public void bWk() {
        if (this.gPC != null) {
            this.gPC.endLoadData();
            this.opk.setNextPage(null);
        }
    }

    public void bSb() {
        if (this.gPC != null) {
            if (this.gPC.getView().getParent() == null) {
                this.opk.setNextPage(this.gPC);
            }
            this.gPC.showLoadView();
        }
    }

    private void xs(boolean z) {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            UtilHelper.changeStatusBarIconAndTextColor(z, (Activity) this.mContext);
        }
    }
}
