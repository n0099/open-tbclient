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
    private View aFz;
    private CommonEmptyView bFa;
    private ViewGroup bJN;
    private List<AbsDelegateAdapter> bky;
    private int cardWidth;
    private float cwD;
    private LoadMoreFooter gGO;
    private TbListCommonPullView hAC;
    private float lTd;
    private ValueAnimator mAnimator;
    private ViewGroup mBf;
    private View mBj;
    private int mBk;
    private float mBl;
    private final int mBo;
    private TextView mBr;
    private boolean mBs;
    private w mBt;
    private View mBv;
    private View mBw;
    private Context mContext;
    private float mDownX;
    private int mOrientation;
    private int mScreenWidth;
    private int mShowType;
    private int mTouchSlop;
    private RecommendViewPager nYG;
    private AlaRecommendLiveListView nYH;
    private InterfaceC0912a nYI;
    private com.baidu.tieba.yuyinala.liveroom.recommend.model.b nYJ;
    private AlaLiveView nYK;
    private FrameLayout nYL;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.recommend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0912a {
        void cr(boolean z);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mBo = 100;
        if (tbPageContext != null) {
            this.mContext = getPageContext().getPageActivity();
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.mBk = this.mScreenWidth;
            dBN();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.d.AZ().getBoolean("yuyin_ala_recommend_live_first_show", true)) {
                this.mShowType = 1;
            }
        }
    }

    public void a(InterfaceC0912a interfaceC0912a) {
        this.nYI = interfaceC0912a;
    }

    public void n(w wVar) {
        this.mBt = wVar;
    }

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

    public void a(AlaLiveView alaLiveView) {
        this.nYK = alaLiveView;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void ax(ViewGroup viewGroup) {
        super.ax(viewGroup);
        if (viewGroup != null) {
            this.bJN = viewGroup;
            this.mBf = (ViewGroup) this.bJN.findViewById(a.f.ala_live_header_view);
            dBO();
            dBM();
            if (!this.mBs && com.baidu.live.aa.a.PQ().bod != null && this.mShowType != 1) {
                long j = com.baidu.live.d.AZ().getLong("yuyin_ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int PW = com.baidu.live.aa.a.PQ().PW();
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > PW) {
                    this.mShowType = 2;
                }
            }
            Io(0);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Dm() {
        super.Dm();
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
        if (this.bJN != null) {
            this.bJN.removeView(this.nYG);
            this.bJN.removeView(this.mBv);
        }
        this.nYI = null;
        if (this.mBs) {
            com.baidu.live.d.AZ().putLong("yuyin_ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.mBt = null;
        if (this.nYJ != null) {
            this.nYJ.reset();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        Dm();
        if (this.nYJ != null) {
            this.nYJ.onDestroy();
        }
    }

    private void dBM() {
        if (this.aFz == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mBk, -1);
            this.aFz = LayoutInflater.from(this.mContext).inflate(a.g.yuyinala_recommend_live_content_layout, (ViewGroup) null);
            this.aFz.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aFz.findViewById(a.f.right_layout).setPadding(0, BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity()), 0, 0);
            }
            this.mBw = this.aFz.findViewById(a.f.block_view);
            this.mBw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.nYL = (FrameLayout) this.aFz.findViewById(a.f.listView_layout);
            this.nYH = (AlaRecommendLiveListView) this.aFz.findViewById(a.f.recommendLiveListView);
            this.hAC = new AlaListViewPullView(this.mContext);
            this.nYH.setPullRefresh(this.hAC);
            this.gGO = new LoadMoreFooter(this.mContext);
            this.gGO.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
            this.gGO.setFooterHeight(this.cardWidth / 2);
            this.gGO.createView();
            LY();
            this.nYH.addAdapters(this.bky);
            this.hAC.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.2
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.Io(0);
                    if (!z) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, a.this.mBt.aJK.croom_id);
                        } catch (Exception e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "more_room", "pushfresh"));
                    }
                }
            });
            this.nYH.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.gGO.isLoading() && a.this.nYJ != null && a.this.nYJ.hasMore && i + i2 > i3 - 2) {
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
        if (this.nYG == null) {
            this.nYG = new RecommendViewPager(getPageContext().getPageActivity());
            this.nYG.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.nYG.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.4
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
                    if (i == 0 && a.this.nYG != null) {
                        if (a.this.nYG.getCurrentItem() == 0) {
                            a.this.close();
                        } else {
                            a.this.dBQ();
                        }
                    }
                }
            });
            ArrayList arrayList = new ArrayList();
            Space space = new Space(getPageContext().getPageActivity());
            space.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            arrayList.add(space);
            arrayList.add(this.aFz);
            this.nYG.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.mBk, -1);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = -this.mBk;
            this.nYG.setLayoutParams(layoutParams2);
        }
        this.bJN.addView(this.nYG);
        this.nYG.setCurrentItem(1, false);
        if (this.nYJ == null) {
            this.nYJ = new com.baidu.tieba.yuyinala.liveroom.recommend.model.b(getPageContext());
            this.nYJ.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.5
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

    private void dBN() {
        this.cardWidth = ((((this.mBk - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds340);
        }
    }

    private void LY() {
        if (this.bky == null) {
            this.bky = new ArrayList();
            this.bky.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.b(this.mContext, c.mCc));
            this.bky.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a(this.mContext, com.baidu.tieba.yuyinala.liveroom.recommend.data.a.mBZ, this.cardWidth, getPageContext()));
        }
    }

    private void dBO() {
        this.mBj = LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_recommend_live_header_entrance, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds14);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        this.mBj.setLayoutParams(layoutParams);
        if (this.mBf != null) {
            this.mBf.addView(this.mBj);
        }
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
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nYG.getLayoutParams();
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
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.nYG.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.nYG.setLayoutParams(layoutParams2);
                        this.mBv.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.mBk));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.mBk)) {
                        layoutParams2.rightMargin = i3;
                        this.nYG.setLayoutParams(layoutParams2);
                        this.mBv.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mBk));
                        return true;
                    } else if (i3 < (-this.mBk)) {
                        layoutParams2.rightMargin = -this.mBk;
                        this.nYG.setLayoutParams(layoutParams2);
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
        if (motionEvent == null || this.mOrientation == 2) {
            return false;
        }
        if (this.nYK != null) {
            if (this.nYK.getKeyboardVisibility()) {
                return false;
            }
            if (!this.nYK.chZ()) {
                close();
                return false;
            } else if (this.nYK.getScrollX() != 0) {
                close();
                return false;
            }
        }
        return true;
    }

    private void dBP() {
    }

    public void wK(boolean z) {
        if ((this.mAnimator == null || !this.mAnimator.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            wL(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nYG.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                ac(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.mBk)));
            }
            if (this.nYI != null) {
                this.nYI.cr(true);
            }
            if (!this.mBs) {
                this.mBs = true;
            }
            this.nYH.completePullRefresh();
            if (z) {
                Io(0);
            }
            dYm();
        }
    }

    private void dYm() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.mBt.aJK.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", "more_room", null).setContentExt(jSONObject));
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
        this.nYJ.x(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<IAdapterData> list, int i, int i2) {
        if (this.nYJ.hasMore) {
            bTh();
        } else if (i2 == 1) {
            bTh();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.nYH.setData(list);
        if (this.bky != null) {
            Iterator<AbsDelegateAdapter> it = this.bky.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbsDelegateAdapter next = it.next();
                if (next instanceof com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) {
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).Ml(i);
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).setAlaLiveShowData(this.mBt);
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
        this.nYH.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.nYH != null) {
            if (this.nYH != null && this.nYH.getAdapter() != null && this.nYH.getAdapter().getCount() > 0) {
                this.nYH.completePullRefresh();
            } else if (this.nYJ != null && !this.nYJ.bBW() && this.nYH != null) {
                if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                    BdUtilHelper.showToast(this.mContext, a.h.recommend_live_net_weak);
                }
                this.nYH.completePullRefresh();
            } else {
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
                    if (this.nYL != null) {
                        this.bFa.addToParent(this.nYL);
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
                this.bFa.setRefreshButton(this.mContext.getResources().getString(a.h.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.hideNoDataView();
                        a.this.nYH.startPullRefresh();
                    }
                });
                this.bFa.setup(imgType, CommonEmptyView.StyleType.DARK);
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
                    this.mBr.setBackgroundResource(a.e.ala_recommend_live_empty_refresh_btn_selector);
                }
                this.bFa.setVisibility(0);
                this.nYH.completePullRefresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bFa != null) {
            this.bFa.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (this.nYI != null) {
            this.nYI.cr(false);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nYG.getLayoutParams();
        layoutParams.rightMargin = -this.mBk;
        this.nYG.setLayoutParams(layoutParams);
        this.nYG.setCurrentItem(1, false);
        this.mBv.setAlpha(0.0f);
    }

    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.nYG.getLayoutParams()).rightMargin > (-this.mBk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBQ() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.nYG.getLayoutParams()).rightMargin * 1.0f) / this.mBk);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.mBv.setAlpha(abs);
    }

    public void onClose() {
        if (this.mAnimator == null || !this.mAnimator.isRunning()) {
            wL(false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nYG.getLayoutParams();
            if (layoutParams.rightMargin > (-this.mBk)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.mBk;
                ac(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.mBk)));
            }
            if (this.nYI != null) {
                this.nYI.cr(false);
            }
            this.nYH.completePullRefresh();
        }
    }

    private void ac(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.mAnimator = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.nYG.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.mBv.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.mBk));
                a.this.nYG.setLayoutParams(layoutParams);
            }
        });
        this.mAnimator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.nYG.setCurrentItem(1, false);
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
            wK(true);
            dYn();
        }
    }

    private void dYn() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.mBt.aJK.croom_id);
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
    public boolean Oa() {
        return false;
    }

    public void bTh() {
        if (this.gGO != null) {
            this.gGO.endLoadData();
            this.nYH.setNextPage(null);
        }
    }

    public void bOX() {
        if (this.gGO != null) {
            if (this.gGO.getView().getParent() == null) {
                this.nYH.setNextPage(this.gGO);
            }
            this.gGO.showLoadView();
        }
    }

    private void wL(boolean z) {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            UtilHelper.changeStatusBarIconAndTextColor(z, (Activity) this.mContext);
        }
    }
}
