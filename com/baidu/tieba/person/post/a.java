package com.baidu.tieba.person.post;

import android.support.v4.view.ViewPager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ViewPager f1656a;

    public a(PersonPostActivity personPostActivity) {
        personPostActivity.setContentView(R.layout.person_post_activity);
        this.f1656a = (ViewPager) personPostActivity.findViewById(R.id.pager);
    }
}
