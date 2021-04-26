package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.j0.g2.e.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class PersonCenterSmartAppPageView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public List<c> f20475e;

    /* renamed from: f  reason: collision with root package name */
    public List<PersonCenterSmartAppItemView> f20476f;

    /* renamed from: g  reason: collision with root package name */
    public int f20477g;

    public PersonCenterSmartAppPageView(Context context) {
        this(context, null);
    }

    public void a(c cVar) {
        if (cVar == null || this.f20475e.size() == this.f20477g) {
            return;
        }
        this.f20475e.add(cVar);
        PersonCenterSmartAppItemView personCenterSmartAppItemView = (PersonCenterSmartAppItemView) ListUtils.getItem(this.f20476f, this.f20475e.size() - 1);
        personCenterSmartAppItemView.a(cVar);
        personCenterSmartAppItemView.setVisibility(0);
    }

    public boolean b() {
        return this.f20475e.size() < this.f20477g;
    }

    public void c() {
        for (PersonCenterSmartAppItemView personCenterSmartAppItemView : this.f20476f) {
            if (personCenterSmartAppItemView != null) {
                personCenterSmartAppItemView.c();
            }
        }
    }

    public PersonCenterSmartAppPageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PersonCenterSmartAppPageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20477g = 4;
        ViewGroup.LayoutParams layoutParams = new ViewPager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        setLayoutParams(layoutParams);
        setOrientation(0);
        this.f20475e = new ArrayList();
        this.f20476f = new ArrayList();
        for (int i3 = 0; i3 < this.f20477g; i3++) {
            PersonCenterSmartAppItemView personCenterSmartAppItemView = new PersonCenterSmartAppItemView(getContext());
            addView(personCenterSmartAppItemView, new LinearLayout.LayoutParams(0, -1, 1.0f));
            personCenterSmartAppItemView.setVisibility(4);
            this.f20476f.add(personCenterSmartAppItemView);
        }
        c();
    }
}
