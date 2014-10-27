package com.baidu.tieba.square;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.square.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class CarouselRecommendView<T extends y> extends FrameLayout {
    private static int CAROUSEL_FREQUENCY = 5000;
    public static final int CAROUSEL_NEXT = 0;
    public static final String MODULE_NAME = "carousel_recommend";
    private List<T> dataCache;
    private View mCarouselBottomLine;
    private Context mContext;
    private String mGameRefId;
    private float mHWProportion;
    private Handler mHandler;
    private int mHeight;
    private IndicatorView mIndicator;
    private boolean mIsForGameCenter;
    private CarouselRecommendView<T>.n mPageAdapter;
    private ViewPager mPager;
    public View.OnTouchListener mTouchListener;
    private int mViewBottomPadding;
    private int mViewHorizontalPadding;
    private int mViewTopPadding;
    private int mWidth;

    public CarouselRecommendView(Context context, boolean z) {
        this(context, null, z);
    }

    public View getViewPagerBottomLine() {
        return this.mCarouselBottomLine;
    }

    public CarouselRecommendView(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.mContext = null;
        this.mPager = null;
        this.mIndicator = null;
        this.mPageAdapter = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mHWProportion = 0.3043478f;
        this.mIsForGameCenter = true;
        this.dataCache = new ArrayList();
        this.mHandler = new l(this);
        this.mTouchListener = new m(this);
        this.mContext = context;
        this.mIsForGameCenter = z;
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.w.carousel_topics_recommend, this, true);
        this.mPager = (ViewPager) findViewById(com.baidu.tieba.v.carousel_pager);
        if (z) {
            this.mCarouselBottomLine = findViewById(com.baidu.tieba.v.carousel_bottom_line);
            this.mIndicator = (IndicatorView) findViewById(com.baidu.tieba.v.carousel_indicator_for_game_center);
        } else {
            this.mIndicator = (IndicatorView) findViewById(com.baidu.tieba.v.carousel_indicator);
        }
        this.mIndicator.setVisibility(0);
        this.mPager.setOnTouchListener(this.mTouchListener);
        if (this.mIsForGameCenter) {
            this.mWidth = com.baidu.adp.lib.util.m.n(context);
            this.mHeight = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds330);
        } else {
            this.mViewTopPadding = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.square_caroucel_paddingTop);
            this.mViewBottomPadding = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.square_caroucel_paddingBottom);
            this.mViewHorizontalPadding = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.square_page_padding);
            this.mWidth = com.baidu.adp.lib.util.m.n(context) - (this.mViewHorizontalPadding * 2);
            this.mHeight = (int) (0.5f + (this.mWidth * this.mHWProportion));
            setPadding(this.mViewHorizontalPadding, this.mViewTopPadding, this.mViewHorizontalPadding, this.mViewBottomPadding);
        }
        ViewGroup.LayoutParams layoutParams = this.mPager.getLayoutParams();
        layoutParams.width = this.mWidth;
        layoutParams.height = this.mHeight;
        this.mPager.setLayoutParams(layoutParams);
        this.mPageAdapter = new n(this.mContext);
    }

    public CarouselRecommendView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, true);
    }

    public boolean setData(List<T> list) {
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return false;
        }
        this.dataCache.clear();
        this.dataCache = list;
        setVisibility(0);
        int size = this.dataCache.size();
        if (size > 1) {
            this.dataCache.add(list.get(0));
            this.dataCache.add(0, list.get(list.size() - 1));
        }
        this.mPageAdapter.setData(this.dataCache);
        this.mPager.setAdapter(this.mPageAdapter);
        this.mPager.setOnPageChangeListener(new p(this, null));
        this.mPager.setCurrentItem(size > 1 ? 1 : 0, false);
        this.mPager.invalidate();
        if (size > 1) {
            this.mIndicator.setVisibility(0);
            this.mIndicator.setCount(this.dataCache.size() - 2);
            this.mIndicator.setPosition(0.0f);
        } else {
            this.mIndicator.setVisibility(8);
        }
        startMarqueen();
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.mPageAdapter != null) {
            this.mPageAdapter.onChangeSkinType(i);
        }
    }

    public void startMarqueen() {
        this.mHandler.removeMessages(0);
        this.mHandler.sendEmptyMessageDelayed(0, CAROUSEL_FREQUENCY);
    }

    public void stopMarqueen() {
        this.mHandler.removeMessages(0);
    }

    public CarouselRecommendView<T>.n getPagerAdapter() {
        return this.mPageAdapter;
    }

    public void setGameRefId(String str) {
        this.mGameRefId = str;
    }

    /* loaded from: classes.dex */
    public class n extends PagerAdapter implements com.baidu.tbadk.imageManager.d, com.baidu.tieba.view.s {
        private View agA;
        private Context mContext;
        private List<T> bMn = null;
        private int count = 0;
        private List<View> bMo = new ArrayList();
        public List<TbImageView> bMp = new ArrayList();

        public n(Context context) {
            CarouselRecommendView.this = r3;
            this.mContext = null;
            this.mContext = context;
        }

        private void a(TbImageView tbImageView, T t, int i) {
            if (tbImageView != null && t != null && t.kJ() != null) {
                tbImageView.a(t.kJ().trim(), 10, CarouselRecommendView.this.mWidth - (CarouselRecommendView.this.mViewHorizontalPadding * 2), (CarouselRecommendView.this.mHeight - CarouselRecommendView.this.mViewTopPadding) - CarouselRecommendView.this.mViewBottomPadding, false);
                tbImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                tbImageView.setOnClickListener(new o(this, t, tbImageView, i));
                this.bMp.add(tbImageView);
            }
        }

        public void setData(List<T> list) {
            clear();
            if (list != null && list.size() != 0) {
                this.count = list.size();
                this.bMn = list;
                int i = 0;
                while (i < this.count) {
                    TbImageView tbImageView = (TbImageView) com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.carousel_topics_recommend_item, null);
                    tbImageView.setSupportNoImage(false);
                    if (!CarouselRecommendView.this.mIsForGameCenter) {
                        tbImageView.setDrawerType(1);
                        tbImageView.setGifIconSupport(false);
                        tbImageView.setDrawBorder(true);
                    }
                    a(tbImageView, (TbImageView) list.get(i), i > 0 ? i - 1 : 0);
                    this.bMo.add(tbImageView);
                    i++;
                }
                notifyDataSetChanged();
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (this.bMo == null) {
                return 0;
            }
            return this.bMo.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.bMo.get(i);
            view.setTag(Integer.valueOf(i));
            view.invalidate();
            viewGroup.addView(view);
            return view;
        }

        public void onChangeSkinType(int i) {
            if (this.bMp != null && this.bMp.size() > 0) {
                for (TbImageView tbImageView : this.bMp) {
                    tbImageView.invalidate();
                }
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private void clear() {
            this.bMo.clear();
            this.count = 0;
            this.bMn = null;
            notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.view.s
        public void adn() {
        }

        @Override // com.baidu.tieba.view.s
        public void g(View view, int i, int i2) {
        }

        @Override // com.baidu.tbadk.imageManager.d
        public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
            HeadImageView headImageView;
            if (this.agA != null && (headImageView = (HeadImageView) this.agA.findViewWithTag(str)) != null) {
                headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER);
                headImageView.invalidate();
            }
        }
    }
}
