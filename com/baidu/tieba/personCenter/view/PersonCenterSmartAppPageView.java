package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class PersonCenterSmartAppPageView extends LinearLayout {
    private List<PersonCenterSmartAppItemView> ieO;
    private int ieP;
    private List<com.baidu.tieba.personCenter.data.c> mDataList;

    public PersonCenterSmartAppPageView(Context context) {
        this(context, null);
    }

    public PersonCenterSmartAppPageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PersonCenterSmartAppPageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ieP = 4;
        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        setLayoutParams(layoutParams);
        setOrientation(0);
        this.mDataList = new ArrayList();
        this.ieO = new ArrayList();
        for (int i2 = 0; i2 < this.ieP; i2++) {
            PersonCenterSmartAppItemView personCenterSmartAppItemView = new PersonCenterSmartAppItemView(getContext());
            addView(personCenterSmartAppItemView, new LinearLayout.LayoutParams(0, -1, 1.0f));
            personCenterSmartAppItemView.setVisibility(4);
            this.ieO.add(personCenterSmartAppItemView);
        }
        onChangeSkinType();
    }

    public void c(com.baidu.tieba.personCenter.data.c cVar) {
        if (cVar != null && this.mDataList.size() != this.ieP) {
            this.mDataList.add(cVar);
            PersonCenterSmartAppItemView personCenterSmartAppItemView = (PersonCenterSmartAppItemView) v.c(this.ieO, this.mDataList.size() - 1);
            personCenterSmartAppItemView.b(cVar);
            personCenterSmartAppItemView.setVisibility(0);
        }
    }

    public boolean bYy() {
        return this.mDataList.size() < this.ieP;
    }

    public void onChangeSkinType() {
        for (PersonCenterSmartAppItemView personCenterSmartAppItemView : this.ieO) {
            if (personCenterSmartAppItemView != null) {
                personCenterSmartAppItemView.onChangeSkinType();
            }
        }
    }
}
