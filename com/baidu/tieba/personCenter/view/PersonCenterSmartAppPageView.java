package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class PersonCenterSmartAppPageView extends LinearLayout {
    private List<com.baidu.tieba.personCenter.c.c> mDataList;
    private List<PersonCenterSmartAppItemView> mlV;
    private int mlW;

    public PersonCenterSmartAppPageView(Context context) {
        this(context, null);
    }

    public PersonCenterSmartAppPageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PersonCenterSmartAppPageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mlW = 4;
        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        setLayoutParams(layoutParams);
        setOrientation(0);
        this.mDataList = new ArrayList();
        this.mlV = new ArrayList();
        for (int i2 = 0; i2 < this.mlW; i2++) {
            PersonCenterSmartAppItemView personCenterSmartAppItemView = new PersonCenterSmartAppItemView(getContext());
            addView(personCenterSmartAppItemView, new LinearLayout.LayoutParams(0, -1, 1.0f));
            personCenterSmartAppItemView.setVisibility(4);
            this.mlV.add(personCenterSmartAppItemView);
        }
        onChangeSkinType();
    }

    public void c(com.baidu.tieba.personCenter.c.c cVar) {
        if (cVar != null && this.mDataList.size() != this.mlW) {
            this.mDataList.add(cVar);
            PersonCenterSmartAppItemView personCenterSmartAppItemView = (PersonCenterSmartAppItemView) x.getItem(this.mlV, this.mDataList.size() - 1);
            personCenterSmartAppItemView.b(cVar);
            personCenterSmartAppItemView.setVisibility(0);
        }
    }

    public boolean duB() {
        return this.mDataList.size() < this.mlW;
    }

    public void onChangeSkinType() {
        for (PersonCenterSmartAppItemView personCenterSmartAppItemView : this.mlV) {
            if (personCenterSmartAppItemView != null) {
                personCenterSmartAppItemView.onChangeSkinType();
            }
        }
    }
}
