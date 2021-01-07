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
    private ViewGroup mVc;
    private View mVf;
    private int mVg;
    private float mVh;
    private final int mVk;
    private TextView mVn;
    private boolean mVo;
    private x mVp;
    private FrameLayout mVq;
    private View mVr;
    private View mVs;
    private float mmJ;
    private RecommendViewPager osD;
    private AlaRecommendLiveListView osE;
    private InterfaceC0945a osF;
    private com.baidu.tieba.yuyinala.liveroom.recommend.model.b osG;
    private AlaLiveView osH;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.recommend.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0945a {
        void cK(boolean z);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mVk = 100;
        if (tbPageContext != null) {
            this.mContext = getPageContext().getPageActivity();
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.mVg = this.mScreenWidth;
            crz();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.d.Ba().getBoolean("yuyin_ala_recommend_live_first_show", true)) {
                this.fqH = 1;
            }
        }
    }

    public void a(InterfaceC0945a interfaceC0945a) {
        this.osF = interfaceC0945a;
    }

    public void o(x xVar) {
        this.mVp = xVar;
    }

    public void C(int i, int i2) {
        this.mOrientation = i2;
        if (i2 == 2) {
            this.mVf.setVisibility(8);
            if (isOpen()) {
                onClose();
                return;
            }
            return;
        }
        this.mVf.setVisibility(0);
    }

    public void a(AlaLiveView alaLiveView) {
        this.osH = alaLiveView;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        if (viewGroup != null) {
            this.bRX = viewGroup;
            this.mVc = (ViewGroup) this.bRX.findViewById(a.f.ala_live_header_view);
            dGu();
            dGt();
            if (!this.mVo && com.baidu.live.af.a.SE().bwi != null && this.fqH != 1) {
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
            this.bRX.removeView(this.osD);
            this.bRX.removeView(this.mVr);
        }
        this.osF = null;
        if (this.mVo) {
            com.baidu.live.d.Ba().putLong("yuyin_ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.mVp = null;
        if (this.osG != null) {
            this.osG.reset();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        DC();
        if (this.osG != null) {
            this.osG.onDestroy();
        }
    }

    private void dGt() {
        if (this.aGL == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mVg, -1);
            this.aGL = LayoutInflater.from(this.mContext).inflate(a.g.yuyinala_recommend_live_content_layout, (ViewGroup) null);
            this.aGL.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aGL.findViewById(a.f.right_layout).setPadding(0, BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity()), 0, 0);
            }
            this.mVs = this.aGL.findViewById(a.f.block_view);
            this.mVs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.mVq = (FrameLayout) this.aGL.findViewById(a.f.listView_layout);
            this.osE = (AlaRecommendLiveListView) this.aGL.findViewById(a.f.recommendLiveListView);
            this.hWc = new AlaListViewPullView(this.mContext);
            this.osE.setPullRefresh(this.hWc);
            this.hbr = new LoadMoreFooter(this.mContext);
            this.hbr.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
            this.hbr.setFooterHeight(this.cardWidth / 2);
            this.hbr.createView();
            MT();
            this.osE.addAdapters(this.boM);
            this.hWc.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.JA(0);
                    if (!z) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, a.this.mVp.aLl.croom_id);
                        } catch (Exception e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "more_room", "pushfresh"));
                    }
                }
            });
            this.osE.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.hbr.isLoading() && a.this.osG != null && a.this.osG.hasMore && i + i2 > i3 - 2) {
                        a.this.bUF();
                        a.this.JA(1);
                    }
                }
            });
        }
        if (this.mVr == null) {
            this.mVr = new View(this.mContext);
            this.mVr.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha65));
            this.mVr.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mVr.setAlpha(0.0f);
        }
        this.bRX.addView(this.mVr);
        if (this.osD == null) {
            this.osD = new RecommendViewPager(getPageContext().getPageActivity());
            this.osD.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.osD.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.4
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    if (a.this.isOpen() && i == 0) {
                        a.this.mVr.setAlpha(f);
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    if (i == 0 && a.this.osD != null) {
                        if (a.this.osD.getCurrentItem() == 0) {
                            a.this.close();
                        } else {
                            a.this.dGw();
                        }
                    }
                }
            });
            ArrayList arrayList = new ArrayList();
            Space space = new Space(getPageContext().getPageActivity());
            space.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            arrayList.add(space);
            arrayList.add(this.aGL);
            this.osD.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.mVg, -1);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = -this.mVg;
            this.osD.setLayoutParams(layoutParams2);
        }
        this.bRX.addView(this.osD);
        this.osD.setCurrentItem(1, false);
        if (this.osG == null) {
            this.osG = new com.baidu.tieba.yuyinala.liveroom.recommend.model.b(getPageContext());
            this.osG.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.5
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

    private void crz() {
        this.cardWidth = ((((this.mVg - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds340);
        }
    }

    private void MT() {
        if (this.boM == null) {
            this.boM = new ArrayList();
            this.boM.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.b(this.mContext, c.mWd));
            this.boM.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a(this.mContext, com.baidu.tieba.yuyinala.liveroom.recommend.data.a.mVZ, this.cardWidth, getPageContext()));
        }
    }

    private void dGu() {
        this.mVf = LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_recommend_live_header_entrance, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds14);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        this.mVf.setLayoutParams(layoutParams);
        if (this.mVc != null) {
            this.mVc.addView(this.mVf);
        }
        this.mVf.setOnClickListener(this);
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
                this.mmJ = this.mDownX;
                this.mVh = this.cGB;
                break;
            case 1:
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                float f = this.mDownX - x;
                float f2 = this.cGB - y;
                if (Math.abs(f) < this.mTouchSlop && Math.abs(f2) < this.mTouchSlop && x > 0.0f && x < this.mScreenWidth - this.mVg) {
                    onClose();
                    return true;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.osD.getLayoutParams();
                if (f > this.mTouchSlop) {
                    xs(true);
                    dGv();
                    return true;
                } else if (layoutParams.rightMargin > (-this.mVg)) {
                    onClose();
                    return true;
                }
                break;
            case 2:
                float x2 = motionEvent.getX(i);
                float y2 = motionEvent.getY(i);
                float f3 = this.mmJ - x2;
                float f4 = this.mVh - y2;
                this.mmJ = x2;
                this.mVh = y2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.osD.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.osD.setLayoutParams(layoutParams2);
                        this.mVr.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.mVg));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.mVg)) {
                        layoutParams2.rightMargin = i3;
                        this.osD.setLayoutParams(layoutParams2);
                        this.mVr.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mVg));
                        return true;
                    } else if (i3 < (-this.mVg)) {
                        layoutParams2.rightMargin = -this.mVg;
                        this.osD.setLayoutParams(layoutParams2);
                        this.mVr.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mVg));
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
        if (this.osH != null) {
            if (this.osH.getKeyboardVisibility()) {
                return false;
            }
            if (!this.osH.cog()) {
                close();
                return false;
            } else if (this.osH.getScrollX() != 0) {
                close();
                return false;
            }
        }
        return true;
    }

    private void dGv() {
    }

    public void xs(boolean z) {
        if ((this.dzn == null || !this.dzn.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            xt(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.osD.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                af(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.mVg)));
            }
            if (this.osF != null) {
                this.osF.cK(true);
            }
            if (!this.mVo) {
                this.mVo = true;
            }
            this.osE.completePullRefresh();
            if (z) {
                JA(0);
            }
            edj();
        }
    }

    private void edj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.mVp.aLl.croom_id);
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
        if (this.mVp != null && this.mVp.mLiveInfo != null) {
            j = this.mVp.mLiveInfo.live_id;
        }
        this.osG.B(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<IAdapterData> list, int i, int i2) {
        if (this.osG.hasMore) {
            bYR();
        } else if (i2 == 1) {
            bYR();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.osE.setData(list);
        if (this.boM != null) {
            Iterator<AbsDelegateAdapter> it = this.boM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbsDelegateAdapter next = it.next();
                if (next instanceof com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) {
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).Nt(i);
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).setAlaLiveShowData(this.mVp);
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
        this.osE.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.osE != null) {
            if (this.osE != null && this.osE.getAdapter() != null && this.osE.getAdapter().getCount() > 0) {
                this.osE.completePullRefresh();
            } else if (this.osG != null && !this.osG.isDataEmpty() && this.osE != null) {
                if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                    BdUtilHelper.showToast(this.mContext, a.h.recommend_live_net_weak);
                }
                this.osE.completePullRefresh();
            } else {
                if (this.bNm == null) {
                    this.bNm = new CommonEmptyView(this.mContext);
                    ImageView imageView = (ImageView) this.bNm.findViewById(a.f.sdk_cev_img);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                    layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
                    layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
                    imageView.setLayoutParams(layoutParams);
                    ((TextView) this.bNm.findViewById(a.f.sdk_cev_title)).setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
                    this.mVn = (TextView) this.bNm.findViewById(a.f.sdk_cev_refresh_btn);
                    this.mVn.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize22));
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mVn.getLayoutParams();
                    layoutParams2.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds152);
                    layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds54);
                    layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds30);
                    this.mVn.setLayoutParams(layoutParams2);
                    if (this.mVq != null) {
                        this.bNm.addToParent(this.mVq);
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
                        a.this.osE.startPullRefresh();
                    }
                });
                this.bNm.setup(imgType, CommonEmptyView.StyleType.DARK);
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
                    this.mVn.setBackgroundResource(a.e.ala_recommend_live_empty_refresh_btn_selector);
                }
                this.bNm.setVisibility(0);
                this.osE.completePullRefresh();
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
        if (this.osF != null) {
            this.osF.cK(false);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.osD.getLayoutParams();
        layoutParams.rightMargin = -this.mVg;
        this.osD.setLayoutParams(layoutParams);
        this.osD.setCurrentItem(1, false);
        this.mVr.setAlpha(0.0f);
    }

    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.osD.getLayoutParams()).rightMargin > (-this.mVg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGw() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.osD.getLayoutParams()).rightMargin * 1.0f) / this.mVg);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.mVr.setAlpha(abs);
    }

    public void onClose() {
        if (this.dzn == null || !this.dzn.isRunning()) {
            xt(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.osD.getLayoutParams();
            if (layoutParams.rightMargin > (-this.mVg)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.mVg;
                af(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.mVg)));
            }
            if (this.osF != null) {
                this.osF.cK(false);
            }
            this.osE.completePullRefresh();
        }
    }

    private void af(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.dzn = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.dzn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.osD.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.mVr.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.mVg));
                a.this.osD.setLayoutParams(layoutParams);
            }
        });
        this.dzn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.osD.setCurrentItem(1, false);
                if (i2 == 0) {
                    a.this.mVr.setAlpha(1.0f);
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
        if (view == this.mVf) {
            xs(true);
            edk();
        }
    }

    private void edk() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.mVp.aLl.croom_id);
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

    public void bYR() {
        if (this.hbr != null) {
            this.hbr.endLoadData();
            this.osE.setNextPage(null);
        }
    }

    public void bUF() {
        if (this.hbr != null) {
            if (this.hbr.getView().getParent() == null) {
                this.osE.setNextPage(this.hbr);
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
