package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.j0.g2.e.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PersonCenterSmartAppPageView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public List<c> f19969e;

    /* renamed from: f  reason: collision with root package name */
    public List<PersonCenterSmartAppItemView> f19970f;

    /* renamed from: g  reason: collision with root package name */
    public int f19971g;

    public PersonCenterSmartAppPageView(Context context) {
        this(context, null);
    }

    public void a(c cVar) {
        if (cVar == null || this.f19969e.size() == this.f19971g) {
            return;
        }
        this.f19969e.add(cVar);
        PersonCenterSmartAppItemView personCenterSmartAppItemView = (PersonCenterSmartAppItemView) ListUtils.getItem(this.f19970f, this.f19969e.size() - 1);
        personCenterSmartAppItemView.a(cVar);
        personCenterSmartAppItemView.setVisibility(0);
    }

    public boolean b() {
        return this.f19969e.size() < this.f19971g;
    }

    public void c() {
        for (PersonCenterSmartAppItemView personCenterSmartAppItemView : this.f19970f) {
            if (personCenterSmartAppItemView != null) {
                personCenterSmartAppItemView.c();
            }
        }
    }

    public PersonCenterSmartAppPageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PersonCenterSmartAppPageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19971g = 4;
        ViewGroup.LayoutParams layoutParams = new ViewPager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        setLayoutParams(layoutParams);
        setOrientation(0);
        this.f19969e = new ArrayList();
        this.f19970f = new ArrayList();
        for (int i2 = 0; i2 < this.f19971g; i2++) {
            PersonCenterSmartAppItemView personCenterSmartAppItemView = new PersonCenterSmartAppItemView(getContext());
            addView(personCenterSmartAppItemView, new LinearLayout.LayoutParams(0, -1, 1.0f));
            personCenterSmartAppItemView.setVisibility(4);
            this.f19970f.add(personCenterSmartAppItemView);
        }
        c();
    }
}
