package com.baidu.tieba.yuyinala.person.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class PersonPageIndicator extends LinearLayout {
    private View hDb;
    private FrameLayout hDc;
    private ViewPager.OnPageChangeListener hDd;
    private LinearLayout hDe;
    private ViewPager mViewPager;

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
        this.hDb = findViewById(a.f.indicator);
        this.hDc = (FrameLayout) findViewById(a.f.indicator_wrapper);
        this.hDe = (LinearLayout) findViewById(a.f.tab_view_layout);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hDb.setBackgroundResource(a.e.ala_person_indicator_bg_hk);
        } else {
            this.hDb.setBackgroundResource(a.e.ala_person_indicator_bg_qm);
        }
    }

    public void setIndicatorMargin(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hDc.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.hDc.setLayoutParams(layoutParams);
    }

    public void setViewPager(ViewPager viewPager, final int i) {
        this.mViewPager = viewPager;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonPageIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f <= 0.0f || i2 >= PersonPageIndicator.this.hDe.getChildCount() - 1) {
                    PersonPageIndicator.this.hDb.getLayoutParams().width = PersonPageIndicator.this.hDe.getChildAt(i2).getMeasuredWidth();
                } else {
                    View childAt = PersonPageIndicator.this.hDe.getChildAt(i2);
                    View childAt2 = PersonPageIndicator.this.hDe.getChildAt(i2 + 1);
                    PersonPageIndicator.this.hDb.getLayoutParams().width = (int) (((childAt2.getWidth() - childAt.getWidth()) * f) + childAt.getWidth());
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PersonPageIndicator.this.hDb.getLayoutParams();
                layoutParams.leftMargin = (int) ((((i * i2) + (i / 2)) - (PersonPageIndicator.this.hDb.getLayoutParams().width / 2)) + (i * f));
                PersonPageIndicator.this.hDb.setLayoutParams(layoutParams);
                if (PersonPageIndicator.this.hDd != null) {
                    PersonPageIndicator.this.hDd.onPageScrolled(i2, f, i3);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (PersonPageIndicator.this.hDd != null) {
                    PersonPageIndicator.this.hDd.onPageSelected(i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                if (PersonPageIndicator.this.hDd != null) {
                    PersonPageIndicator.this.hDd.onPageScrollStateChanged(i2);
                }
            }
        });
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hDd = onPageChangeListener;
    }
}
