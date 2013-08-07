package com.baidu.tieba.recommend;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    ViewPager f1655a;
    FrameLayout b;
    IndicatorView c;
    TextView d;
    TextView e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(Activity activity) {
        this.f1655a = (ViewPager) activity.findViewById(R.id.view_pager);
        this.c = (IndicatorView) activity.findViewById(R.id.indicator);
        this.d = (TextView) activity.findViewById(R.id.feature);
        this.e = (TextView) activity.findViewById(R.id.explore);
        this.b = (FrameLayout) activity.findViewById(R.id.title);
    }
}
