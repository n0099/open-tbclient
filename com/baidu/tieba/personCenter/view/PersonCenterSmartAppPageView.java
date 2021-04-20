package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.i0.g2.e.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PersonCenterSmartAppPageView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public List<c> f19961e;

    /* renamed from: f  reason: collision with root package name */
    public List<PersonCenterSmartAppItemView> f19962f;

    /* renamed from: g  reason: collision with root package name */
    public int f19963g;

    public PersonCenterSmartAppPageView(Context context) {
        this(context, null);
    }

    public void a(c cVar) {
        if (cVar == null || this.f19961e.size() == this.f19963g) {
            return;
        }
        this.f19961e.add(cVar);
        PersonCenterSmartAppItemView personCenterSmartAppItemView = (PersonCenterSmartAppItemView) ListUtils.getItem(this.f19962f, this.f19961e.size() - 1);
        personCenterSmartAppItemView.a(cVar);
        personCenterSmartAppItemView.setVisibility(0);
    }

    public boolean b() {
        return this.f19961e.size() < this.f19963g;
    }

    public void c() {
        for (PersonCenterSmartAppItemView personCenterSmartAppItemView : this.f19962f) {
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
        this.f19963g = 4;
        ViewGroup.LayoutParams layoutParams = new ViewPager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        setLayoutParams(layoutParams);
        setOrientation(0);
        this.f19961e = new ArrayList();
        this.f19962f = new ArrayList();
        for (int i2 = 0; i2 < this.f19963g; i2++) {
            PersonCenterSmartAppItemView personCenterSmartAppItemView = new PersonCenterSmartAppItemView(getContext());
            addView(personCenterSmartAppItemView, new LinearLayout.LayoutParams(0, -1, 1.0f));
            personCenterSmartAppItemView.setVisibility(4);
            this.f19962f.add(personCenterSmartAppItemView);
        }
        c();
    }
}
