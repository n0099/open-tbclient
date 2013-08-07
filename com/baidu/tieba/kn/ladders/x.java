package com.baidu.tieba.kn.ladders;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    final LinearLayout f1201a;
    final LinearLayout b;
    final View c;
    final WebView d;
    final TextView e;
    final ImageView f;
    final TextView g;
    final TextView h;
    final ViewPager i;
    final IndicatorView j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(KnTabActivity knTabActivity) {
        this.c = knTabActivity.findViewById(R.id.title);
        this.e = (TextView) knTabActivity.findViewById(R.id.title2);
        this.g = (TextView) knTabActivity.findViewById(R.id.kn_ladders);
        this.h = (TextView) knTabActivity.findViewById(R.id.kn_pk);
        this.i = (ViewPager) knTabActivity.findViewById(R.id.pager);
        this.d = (WebView) knTabActivity.findViewById(R.id.web);
        this.j = (IndicatorView) knTabActivity.findViewById(R.id.indicator);
        this.f1201a = (LinearLayout) knTabActivity.findViewById(R.id.root);
        this.b = (LinearLayout) knTabActivity.findViewById(R.id.root2);
        this.f = (ImageView) knTabActivity.findViewById(R.id.refresh);
        this.g.setOnClickListener(knTabActivity);
        this.h.setOnClickListener(knTabActivity);
        this.f.setOnClickListener(knTabActivity);
    }
}
