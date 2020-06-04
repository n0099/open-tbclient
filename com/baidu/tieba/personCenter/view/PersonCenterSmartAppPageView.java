package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class PersonCenterSmartAppPageView extends LinearLayout {
    private List<PersonCenterSmartAppItemView> knA;
    private int knB;
    private List<com.baidu.tieba.personCenter.c.c> mDataList;

    public PersonCenterSmartAppPageView(Context context) {
        this(context, null);
    }

    public PersonCenterSmartAppPageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PersonCenterSmartAppPageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.knB = 4;
        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        setLayoutParams(layoutParams);
        setOrientation(0);
        this.mDataList = new ArrayList();
        this.knA = new ArrayList();
        for (int i2 = 0; i2 < this.knB; i2++) {
            PersonCenterSmartAppItemView personCenterSmartAppItemView = new PersonCenterSmartAppItemView(getContext());
            addView(personCenterSmartAppItemView, new LinearLayout.LayoutParams(0, -1, 1.0f));
            personCenterSmartAppItemView.setVisibility(4);
            this.knA.add(personCenterSmartAppItemView);
        }
        onChangeSkinType();
    }

    public void c(com.baidu.tieba.personCenter.c.c cVar) {
        if (cVar != null && this.mDataList.size() != this.knB) {
            this.mDataList.add(cVar);
            PersonCenterSmartAppItemView personCenterSmartAppItemView = (PersonCenterSmartAppItemView) v.getItem(this.knA, this.mDataList.size() - 1);
            personCenterSmartAppItemView.b(cVar);
            personCenterSmartAppItemView.setVisibility(0);
        }
    }

    public boolean cNG() {
        return this.mDataList.size() < this.knB;
    }

    public void onChangeSkinType() {
        for (PersonCenterSmartAppItemView personCenterSmartAppItemView : this.knA) {
            if (personCenterSmartAppItemView != null) {
                personCenterSmartAppItemView.onChangeSkinType();
            }
        }
    }
}
