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
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a implements View.OnClickListener, b, d {
    private View aFl;
    private CommonEmptyView bNK;
    private ViewGroup bSB;
    private List<AbsDelegateAdapter> boS;
    private float cFL;
    private int cardWidth;
    private ValueAnimator dyk;
    private int fpQ;
    private TbListCommonPullView hXN;
    private LoadMoreFooter hbs;
    private Context mContext;
    private float mDownX;
    private int mOrientation;
    private int mScreenWidth;
    private int mTouchSlop;
    private int mXq;
    private float mty;
    private TextView ncD;
    private boolean ncE;
    private ab ncF;
    private FrameLayout ncG;
    private View ncH;
    private View ncI;
    private ViewGroup ncu;
    private View ncx;
    private float ncy;
    private RecommendViewPager oAs;
    private AlaRecommendLiveListView oAt;
    private InterfaceC0940a oAu;
    private com.baidu.tieba.yuyinala.liveroom.recommend.model.b oAv;
    private AlaLiveView oAw;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.recommend.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0940a {
        void cP(boolean z);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        if (tbPageContext != null) {
            this.mContext = getPageContext().getPageActivity();
            this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
            this.mXq = this.mScreenWidth;
            coS();
            this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            if (com.baidu.live.d.xf().getBoolean("yuyin_ala_recommend_live_first_show", true)) {
                this.fpQ = 1;
            }
        }
    }

    public void a(InterfaceC0940a interfaceC0940a) {
        this.oAu = interfaceC0940a;
    }

    public void o(ab abVar) {
        this.ncF = abVar;
    }

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

    public void a(AlaLiveView alaLiveView) {
        this.oAw = alaLiveView;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        if (viewGroup != null) {
            this.bSB = viewGroup;
            this.ncu = (ViewGroup) this.bSB.findViewById(a.f.ala_live_header_view);
            dFc();
            dFb();
            if (!this.ncE && com.baidu.live.ae.a.Qm().bwx != null && this.fpQ != 1) {
                long j = com.baidu.live.d.xf().getLong("yuyin_ala_recommend_live_last_show", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int Qt = com.baidu.live.ae.a.Qm().Qt();
                if (j != 0 && ((float) (currentTimeMillis - j)) / 8.64E7f > Qt) {
                    this.fpQ = 2;
                }
            }
            Ir(0);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Au() {
        super.Au();
        if (this.dyk != null && this.dyk.isRunning()) {
            this.dyk.cancel();
            this.dyk = null;
        }
        if (this.bSB != null) {
            this.bSB.removeView(this.oAs);
            this.bSB.removeView(this.ncH);
        }
        this.oAu = null;
        if (this.ncE) {
            com.baidu.live.d.xf().putLong("yuyin_ala_recommend_live_last_show", System.currentTimeMillis());
        }
        this.ncF = null;
        if (this.oAv != null) {
            this.oAv.reset();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        Au();
        if (this.oAv != null) {
            this.oAv.onDestroy();
        }
    }

    private void dFb() {
        if (this.aFl == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mXq, -1);
            this.aFl = LayoutInflater.from(this.mContext).inflate(a.g.yuyinala_recommend_live_content_layout, (ViewGroup) null);
            this.aFl.setLayoutParams(layoutParams);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.aFl.findViewById(a.f.right_layout).setPadding(0, BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity()), 0, 0);
            }
            this.ncI = this.aFl.findViewById(a.f.block_view);
            this.ncI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClose();
                }
            });
            this.ncG = (FrameLayout) this.aFl.findViewById(a.f.listView_layout);
            this.oAt = (AlaRecommendLiveListView) this.aFl.findViewById(a.f.recommendLiveListView);
            this.hXN = new AlaListViewPullView(this.mContext);
            this.oAt.setPullRefresh(this.hXN);
            this.hbs = new LoadMoreFooter(this.mContext);
            this.hbs.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
            this.hbs.setFooterHeight(this.cardWidth / 2);
            this.hbs.createView();
            Kz();
            this.oAt.addAdapters(this.boS);
            this.hXN.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.3
                @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
                public void onListPullRefresh(boolean z) {
                    a.this.Ir(0);
                    if (!z) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, a.this.ncF.aKu.croom_id);
                        } catch (Exception e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "more_room", "pushfresh"));
                    }
                }
            });
            this.oAt.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.4
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!a.this.hbs.isLoading() && a.this.oAv != null && a.this.oAv.hasMore && i + i2 > i3 - 2) {
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
        if (this.oAs == null) {
            this.oAs = new RecommendViewPager(getPageContext().getPageActivity());
            this.oAs.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.oAs.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.5
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
                    if (i == 0 && a.this.oAs != null) {
                        if (a.this.oAs.getCurrentItem() == 0) {
                            a.this.close();
                        } else {
                            a.this.dFe();
                        }
                    }
                }
            });
            ArrayList arrayList = new ArrayList();
            Space space = new Space(getPageContext().getPageActivity());
            space.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            arrayList.add(space);
            arrayList.add(this.aFl);
            this.oAs.setAdapter(new RecommendPagerAdapter(arrayList));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.mXq, -1);
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = -this.mXq;
            this.oAs.setLayoutParams(layoutParams2);
        }
        this.bSB.addView(this.oAs);
        this.oAs.setCurrentItem(1, false);
        if (this.oAv == null) {
            this.oAv = new com.baidu.tieba.yuyinala.liveroom.recommend.model.b(getPageContext());
            this.oAv.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.6
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

    private void coS() {
        this.cardWidth = ((((this.mXq - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds80)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds340);
        }
    }

    private void Kz() {
        if (this.boS == null) {
            this.boS = new ArrayList();
            this.boS.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.b(this.mContext, c.ndt));
            this.boS.add(new com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a(this.mContext, com.baidu.tieba.yuyinala.liveroom.recommend.data.a.ndp, this.cardWidth, getPageContext()));
        }
    }

    private void dFc() {
        this.ncx = LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_recommend_live_header_entrance, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds44));
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds14);
        layoutParams.addRule(11);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        this.ncx.setLayoutParams(layoutParams);
        if (this.ncu != null) {
            this.ncu.addView(this.ncx);
        }
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
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oAs.getLayoutParams();
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
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.oAs.getLayoutParams();
                if (f3 > 0.0f) {
                    int i2 = (int) (layoutParams2.rightMargin + f3);
                    if (i2 <= 0) {
                        layoutParams2.rightMargin = i2;
                        this.oAs.setLayoutParams(layoutParams2);
                        this.ncH.setAlpha(1.0f - Math.abs((i2 * 1.0f) / this.mXq));
                    }
                    return true;
                } else if (f3 <= 0.0f) {
                    int i3 = (int) (layoutParams2.rightMargin + f3);
                    if (i3 >= (-this.mXq)) {
                        layoutParams2.rightMargin = i3;
                        this.oAs.setLayoutParams(layoutParams2);
                        this.ncH.setAlpha(1.0f - Math.abs((i3 * 1.0f) / this.mXq));
                        return true;
                    } else if (i3 < (-this.mXq)) {
                        layoutParams2.rightMargin = -this.mXq;
                        this.oAs.setLayoutParams(layoutParams2);
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
        if (motionEvent == null || this.mOrientation == 2) {
            return false;
        }
        if (this.oAw != null) {
            if (this.oAw.getKeyboardVisibility()) {
                return false;
            }
            if (!this.oAw.clz()) {
                close();
                return false;
            } else if (this.oAw.getScrollX() != 0) {
                close();
                return false;
            }
        }
        return true;
    }

    private void dFd() {
    }

    public void xH(boolean z) {
        if ((this.dyk == null || !this.dyk.isRunning()) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oAs.getLayoutParams();
            if (layoutParams.rightMargin < 0) {
                int i = layoutParams.rightMargin;
                ad(i, 0, (int) (100.0f * ((Math.abs(0 - i) * 1.0f) / this.mXq)));
            }
            if (this.oAu != null) {
                this.oAu.cP(true);
            }
            if (!this.ncE) {
                this.ncE = true;
            }
            this.oAt.completePullRefresh();
            if (z) {
                Ir(0);
            }
            ebU();
        }
    }

    private void ebU() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ncF.aKu.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", "more_room", null).setContentExt(jSONObject));
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
        this.oAv.z(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<IAdapterData> list, int i, int i2) {
        if (this.oAv.hasMore) {
            bVR();
        } else if (i2 == 1) {
            bVR();
        }
        if (ListUtils.isEmpty(list)) {
            b(CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        hideNoDataView();
        this.oAt.setData(list);
        if (this.boS != null) {
            Iterator<AbsDelegateAdapter> it = this.boS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbsDelegateAdapter next = it.next();
                if (next instanceof com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) {
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).Mm(i);
                    ((com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a) next).setAlaLiveShowData(this.ncF);
                    break;
                }
            }
        }
        if ((this.fpQ == 1 || this.fpQ == 2) && UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
            if (this.fpQ == 1) {
                com.baidu.live.d.xf().putBoolean("yuyin_ala_recommend_live_first_show", false);
            } else {
                com.baidu.live.d.xf().putLong("yuyin_ala_recommend_live_last_show", System.currentTimeMillis());
            }
            this.fpQ = 0;
        }
        this.oAt.completePullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonEmptyView.ImgType imgType) {
        int i;
        if (this.oAt != null) {
            if (this.oAt != null && this.oAt.getAdapter() != null && this.oAt.getAdapter().getCount() > 0) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.oAt != null) {
                            a.this.oAt.completePullRefresh();
                        }
                    }
                }, 1000L);
            } else if (this.oAv != null && !this.oAv.isDataEmpty() && this.oAt != null) {
                if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                    BdUtilHelper.showToast(this.mContext, a.h.recommend_live_net_weak);
                }
                this.oAt.completePullRefresh();
            } else {
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
                this.bNK.setRefreshButton(this.mContext.getResources().getString(a.h.recommend_live_refresh), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.hideNoDataView();
                        a.this.oAt.startPullRefresh();
                    }
                });
                this.bNK.setup(imgType, CommonEmptyView.StyleType.DARK);
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
                    this.ncD.setBackgroundResource(a.e.ala_recommend_live_empty_refresh_btn_selector);
                }
                this.bNK.setVisibility(0);
                this.oAt.completePullRefresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bNK != null) {
            this.bNK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        if (this.dyk != null && this.dyk.isRunning()) {
            this.dyk.cancel();
        }
        if (this.oAu != null) {
            this.oAu.cP(false);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oAs.getLayoutParams();
        layoutParams.rightMargin = -this.mXq;
        this.oAs.setLayoutParams(layoutParams);
        this.oAs.setCurrentItem(1, false);
        this.ncH.setAlpha(0.0f);
    }

    public boolean isOpen() {
        return ((FrameLayout.LayoutParams) this.oAs.getLayoutParams()).rightMargin > (-this.mXq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFe() {
        float abs = 1.0f - Math.abs((((FrameLayout.LayoutParams) this.oAs.getLayoutParams()).rightMargin * 1.0f) / this.mXq);
        if (abs < 0.0f) {
            abs = 0.0f;
        } else if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.ncH.setAlpha(abs);
    }

    public void onClose() {
        if (this.dyk == null || !this.dyk.isRunning()) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oAs.getLayoutParams();
            if (layoutParams.rightMargin > (-this.mXq)) {
                int i = layoutParams.rightMargin;
                int i2 = -this.mXq;
                ad(i, i2, (int) (100.0f * ((Math.abs(i2 - i) * 1.0f) / this.mXq)));
            }
            if (this.oAu != null) {
                this.oAu.cP(false);
            }
            this.oAt.completePullRefresh();
        }
    }

    private void ad(final int i, final int i2, int i3) {
        final int i4 = i2 - i;
        this.dyk = ValueAnimator.ofInt(i, i2).setDuration(i3);
        this.dyk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.oAs.getLayoutParams();
                layoutParams.rightMargin = ((int) (animatedFraction * i4)) + i;
                a.this.ncH.setAlpha(1.0f - Math.abs((layoutParams.rightMargin * 1.0f) / a.this.mXq));
                a.this.oAs.setLayoutParams(layoutParams);
            }
        });
        this.dyk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.a.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.oAs.setCurrentItem(1, false);
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
            xH(true);
            ebV();
        }
    }

    private void ebV() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ncF.aKu.croom_id);
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
    public boolean Nf() {
        return false;
    }

    public void bVR() {
        if (this.hbs != null) {
            this.hbs.endLoadData();
            this.oAt.setNextPage(null);
        }
    }

    public void bRE() {
        if (this.hbs != null) {
            if (this.hbs.getView().getParent() == null) {
                this.oAt.setNextPage(this.hbs);
            }
            this.hbs.showLoadView();
        }
    }
}
