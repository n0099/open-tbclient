package com.baidu.tieba.yuyinala.person.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes11.dex */
public class PersonPageIndicator extends LinearLayout {
    private ViewPager Zk;
    private View hYO;
    private FrameLayout hYP;
    private ViewPager.OnPageChangeListener hYQ;
    private LinearLayout hYR;

    public PersonPageIndicator(Context context) {
        super(context);
        init();
    }

    public PersonPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PersonPageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.ala_person_page_indicator, this);
        this.hYO = findViewById(a.f.indicator);
        this.hYP = (FrameLayout) findViewById(a.f.indicator_wrapper);
        this.hYR = (LinearLayout) findViewById(a.f.tab_view_layout);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hYO.setBackgroundResource(a.e.ala_person_indicator_bg_hk);
        } else {
            this.hYO.setBackgroundResource(a.e.ala_person_indicator_bg_qm);
        }
    }

    public void setIndicatorMargin(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hYP.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.hYP.setLayoutParams(layoutParams);
    }

    public void setViewPager(ViewPager viewPager, final int i) {
        this.Zk = viewPager;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonPageIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f <= 0.0f || i2 >= PersonPageIndicator.this.hYR.getChildCount() - 1) {
                    PersonPageIndicator.this.hYO.getLayoutParams().width = PersonPageIndicator.this.hYR.getChildAt(i2).getMeasuredWidth();
                } else {
                    View childAt = PersonPageIndicator.this.hYR.getChildAt(i2);
                    View childAt2 = PersonPageIndicator.this.hYR.getChildAt(i2 + 1);
                    PersonPageIndicator.this.hYO.getLayoutParams().width = (int) (((childAt2.getWidth() - childAt.getWidth()) * f) + childAt.getWidth());
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PersonPageIndicator.this.hYO.getLayoutParams();
                layoutParams.leftMargin = (int) ((((i * i2) + (i / 2)) - (PersonPageIndicator.this.hYO.getLayoutParams().width / 2)) + (i * f));
                PersonPageIndicator.this.hYO.setLayoutParams(layoutParams);
                if (PersonPageIndicator.this.hYQ != null) {
                    PersonPageIndicator.this.hYQ.onPageScrolled(i2, f, i3);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (PersonPageIndicator.this.hYQ != null) {
                    PersonPageIndicator.this.hYQ.onPageSelected(i2);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                if (PersonPageIndicator.this.hYQ != null) {
                    PersonPageIndicator.this.hYQ.onPageScrollStateChanged(i2);
                }
            }
        });
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hYQ = onPageChangeListener;
    }
}
