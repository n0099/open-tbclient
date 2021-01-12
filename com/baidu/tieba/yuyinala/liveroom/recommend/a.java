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
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a implements View.OnClickListener, b, d {
    private View aBY;
    private CommonEmptyView bIA;
    private ViewGroup bNl;
    private List<AbsDelegateAdapter> bjZ;
    private float cBP;
    private int cardWidth;
    private ValueAnimator duB;
    private int flX;
    private LoadMoreFooter gWL;
    private TbListCommonPullView hRv;
    private Context mContext;
    private float mDownX;
    private int mOrientation;
    private TextView mQC;
    private boolean mQD;
    private x mQE;
    private FrameLayout mQF;
    private View mQG;
    private View mQH;
    private ViewGroup mQr;
    private View mQu;
    private int mQv;
    private float mQw;
    private final int mQz;
    private int mScreenWidth;
    private int mTouchSlop;
    private float mie;
    private RecommendViewPager onW;
    private AlaRecommendLiveListView onX;
    private InterfaceC0928a onY;
    private com.baidu.tieba.yuyinala.liveroom.recommend.model.b onZ;
    private AlaLiveView ooa;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.recommend.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0928a {
        void cG(boolean z);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mQz = 100;
        if (tbPageContext != null) {
            this.mContext = getPageContext().getPageActivity();
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.mQv = this.mScreenWidth;
            cnH();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.d.xf().getBoolean("yuyin_ala_recommend_live_first_show", true)) {
                this.flX = 1;
            }
        }
    }

    public void a(InterfaceC0928a interfaceC0928a) {
        this.onY = interfaceC0928a;
    }

    public void o(x xVar) {
        this.mQE = xVar;
    }

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

    public void a(AlaLiveView alaLiveView) {
        this.ooa = alaLiveView;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        if (viewGroup != null) {
            this.bNl = viewGroup;
            this.mQr = (ViewGroup) this.bNl.findViewById(a.f.ala_live_header_view);
            dCC();
            dCB();
            if (!this.mQD && com.baidu.live.af.a.OJ().bru != null && this.flX != 1) {
                long j = com.baidu.live.d.xf().getLong("yuyin_ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int OP = com.baidu.live.af.a.OJ().OP();
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > OP) {
                    this.flX = 2;
                }
            }
            HT(0);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void zH() {
        super.zH();
        if (this.duB != null && this.duB.isRunning()) {
            this.duB.cancel();
            this.duB = null;
        }
        if (this.bNl != null) {
            this.bNl.removeView(this.onW);
            this.bNl.removeView(this.mQG);
        }
        this.onY = null;
        if (this.mQD) {
            com.baidu.live.d.xf().putLong("yuyin_ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.mQE = null;
        if (this.onZ != null) {
            this.onZ.reset();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        zH();
        if (this.onZ != null) {
            this.onZ.onDestroy();
        }
    }

    private void dCB() {
        if (this.aBY == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mQv, -1);
            this.aBY = LayoutInflater.from(this.mContext).inflate(a.g.yuyinala_recommend_live_content_layout, (ViewGroup) null);
            this.aBY.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aBY.findViewById(a.f.right_layout).setPadding(0, BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity()), 0, 0);
            }
            this.mQH = this.aBY.findViewById(a.f.block_view);
            this.mQH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.mQF = (FrameLayout) this.aBY.findViewById(a.f.listView_layout);
            this.onX = (AlaRecommendLiveListView) this.aBY.findViewById(a.f.recommendLiveListView);
            this.hRv = new AlaListViewPullView(this.mContext);
            this.onX.setPullRefresh(this.hRv);
            this.gWL = new LoadMoreFooter(this.mContext);
            this.gWL.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
            this.gWL.setFooterHeight(this.cardWidth / 2);
            this.gWL.createView();
            IY();
            this.onX.addAdapters(this.bjZ);
            this.hRv.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.HT(0);
                    if (!z) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, a.this.mQE.aGy.croom_id);
                        } catch (Exception e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "more_room", "pushfresh"));
                    }
                }
            });
            this.onX.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.gWL.isLoading() && a.this.onZ != null && a.this.onZ.hasMore && i + i2 > i3 - 2) {
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
        if (this.onW == null) {
            this.onW = new RecommendViewPager(getPageContext().getPageActivity());
            this.onW.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.onW.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.4
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
                    if (i == 0 && a.this.onW != null) {
                        if (a.this.onW.getCurrentItem() == 0) {
                            a.this.close();
                        } else {
                            a.this.dCE();
                        }
                    }
                }
            });
            ArrayList arrayList = new ArrayList();
            Space space = new Space(getPageContext().getPageActivity());
            space.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            arrayList.add(space);
            arrayList.add(this.aBY);
            this.onW.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.mQv, -1);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = -this.mQv;
            this.onW.setLayoutParams(layoutParams2);
        }
        this.bNl.addView(this.onW);
        this.onW.setCurrentItem(1, false);
        if (this.onZ == null) {
            this.onZ = new com.baidu.tieba.yuyinala.liveroom.recommend.model.b(getPageContext());
            this.onZ.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.5
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

    private void cnH() {
        this.cardWidth = ((((this.mQv - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds340);
        }
    }

    private void IY() {
        if (this.bjZ == null) {
            this.bjZ = new ArrayList();
            this.bjZ.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.b(this.mContext, c.mRs));
            this.bjZ.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a(this.mContext, com.baidu.tieba.yuyinala.liveroom.recommend.data.a.mRo, this.cardWidth, getPageContext()));
        }
    }

    private void dCC() {
        this.mQu = LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_recommend_live_header_entrance, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds14);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        this.mQu.setLayoutParams(layoutParams);
        if (this.mQr != null) {
            this.mQr.addView(this.mQu);
        }
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
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.onW.getLayoutParams();
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
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.onW.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.onW.setLayoutParams(layoutParams2);
                        this.mQG.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.mQv));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.mQv)) {
                        layoutParams2.rightMargin = i3;
                        this.onW.setLayoutParams(layoutParams2);
                        this.mQG.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mQv));
                        return true;
                    } else if (i3 < (-this.mQv)) {
                        layoutParams2.rightMargin = -this.mQv;
                        this.onW.setLayoutParams(layoutParams2);
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
        if (motionEvent == null || this.mOrientation == 2) {
            return false;
        }
        if (this.ooa != null) {
            if (this.ooa.getKeyboardVisibility()) {
                return false;
            }
            if (!this.ooa.cko()) {
                close();
                return false;
            } else if (this.ooa.getScrollX() != 0) {
                close();
                return false;
            }
        }
        return true;
    }

    private void dCD() {
    }

    public void xo(boolean z) {
        if ((this.duB == null || !this.duB.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            xp(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.onW.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                af(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.mQv)));
            }
            if (this.onY != null) {
                this.onY.cG(true);
            }
            if (!this.mQD) {
                this.mQD = true;
            }
            this.onX.completePullRefresh();
            if (z) {
                HT(0);
            }
            dZr();
        }
    }

    private void dZr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.mQE.aGy.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", "more_room", null).setContentExt(jSONObject));
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
        this.onZ.B(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<IAdapterData> list, int i, int i2) {
        if (this.onZ.hasMore) {
            bUZ();
        } else if (i2 == 1) {
            bUZ();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.onX.setData(list);
        if (this.bjZ != null) {
            Iterator<AbsDelegateAdapter> it = this.bjZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbsDelegateAdapter next = it.next();
                if (next instanceof com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) {
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).LM(i);
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).setAlaLiveShowData(this.mQE);
                    break;
                }
            }
        }
        if ((this.flX == 1 || this.flX == 2) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            if (this.flX == 1) {
                com.baidu.live.d.xf().putBoolean("yuyin_ala_recommend_live_first_show", false);
            } else {
                com.baidu.live.d.xf().putLong("yuyin_ala_recommend_live_last_show", System.currentTimeMillis());
            }
            this.flX = 0;
        }
        this.onX.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.onX != null) {
            if (this.onX != null && this.onX.getAdapter() != null && this.onX.getAdapter().getCount() > 0) {
                this.onX.completePullRefresh();
            } else if (this.onZ != null && !this.onZ.isDataEmpty() && this.onX != null) {
                if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                    BdUtilHelper.showToast(this.mContext, a.h.recommend_live_net_weak);
                }
                this.onX.completePullRefresh();
            } else {
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
                this.bIA.setRefreshButton(this.mContext.getResources().getString(a.h.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.hideNoDataView();
                        a.this.onX.startPullRefresh();
                    }
                });
                this.bIA.setup(imgType, CommonEmptyView.StyleType.DARK);
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
                    this.mQC.setBackgroundResource(a.e.ala_recommend_live_empty_refresh_btn_selector);
                }
                this.bIA.setVisibility(0);
                this.onX.completePullRefresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bIA != null) {
            this.bIA.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        if (this.duB != null && this.duB.isRunning()) {
            this.duB.cancel();
        }
        if (this.onY != null) {
            this.onY.cG(false);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.onW.getLayoutParams();
        layoutParams.rightMargin = -this.mQv;
        this.onW.setLayoutParams(layoutParams);
        this.onW.setCurrentItem(1, false);
        this.mQG.setAlpha(0.0f);
    }

    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.onW.getLayoutParams()).rightMargin > (-this.mQv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCE() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.onW.getLayoutParams()).rightMargin * 1.0f) / this.mQv);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.mQG.setAlpha(abs);
    }

    public void onClose() {
        if (this.duB == null || !this.duB.isRunning()) {
            xp(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.onW.getLayoutParams();
            if (layoutParams.rightMargin > (-this.mQv)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.mQv;
                af(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.mQv)));
            }
            if (this.onY != null) {
                this.onY.cG(false);
            }
            this.onX.completePullRefresh();
        }
    }

    private void af(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.duB = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.duB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.onW.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.mQG.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.mQv));
                a.this.onW.setLayoutParams(layoutParams);
            }
        });
        this.duB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.onW.setCurrentItem(1, false);
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
            xo(true);
            dZs();
        }
    }

    private void dZs() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.mQE.aGy.croom_id);
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
    public boolean LE() {
        return false;
    }

    public void bUZ() {
        if (this.gWL != null) {
            this.gWL.endLoadData();
            this.onX.setNextPage(null);
        }
    }

    public void bQN() {
        if (this.gWL != null) {
            if (this.gWL.getView().getParent() == null) {
                this.onX.setNextPage(this.gWL);
            }
            this.gWL.showLoadView();
        }
    }

    private void xp(boolean z) {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            UtilHelper.changeStatusBarIconAndTextColor(z, (Activity) this.mContext);
        }
    }
}
