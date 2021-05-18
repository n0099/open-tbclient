package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.k0.g2.e.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class PersonCenterSmartAppPageView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public List<c> f19763e;

    /* renamed from: f  reason: collision with root package name */
    public List<PersonCenterSmartAppItemView> f19764f;

    /* renamed from: g  reason: collision with root package name */
    public int f19765g;

    public PersonCenterSmartAppPageView(Context context) {
        this(context, null);
    }

    public void a(c cVar) {
        if (cVar == null || this.f19763e.size() == this.f19765g) {
            return;
        }
        this.f19763e.add(cVar);
        PersonCenterSmartAppItemView personCenterSmartAppItemView = (PersonCenterSmartAppItemView) ListUtils.getItem(this.f19764f, this.f19763e.size() - 1);
        personCenterSmartAppItemView.a(cVar);
        personCenterSmartAppItemView.setVisibility(0);
    }

    public boolean b() {
        return this.f19763e.size() < this.f19765g;
    }

    public void c() {
        for (PersonCenterSmartAppItemView personCenterSmartAppItemView : this.f19764f) {
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
        this.f19765g = 4;
        ViewGroup.LayoutParams layoutParams = new ViewPager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        setLayoutParams(layoutParams);
        setOrientation(0);
        this.f19763e = new ArrayList();
        this.f19764f = new ArrayList();
        for (int i3 = 0; i3 < this.f19765g; i3++) {
            PersonCenterSmartAppItemView personCenterSmartAppItemView = new PersonCenterSmartAppItemView(getContext());
            addView(personCenterSmartAppItemView, new LinearLayout.LayoutParams(0, -1, 1.0f));
            personCenterSmartAppItemView.setVisibility(4);
            this.f19764f.add(personCenterSmartAppItemView);
        }
        c();
    }
}
