package com.baidu.tieba.kn.ladders;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    ViewPager f1190a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    View f;
    View g;
    FrameLayout h;
    LinearLayout i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(View.OnClickListener onClickListener, View view) {
        this.f1190a = (ViewPager) view.findViewById(R.id.banner);
        this.h = (FrameLayout) view.findViewById(R.id.banner_parent);
        this.i = (LinearLayout) view.findViewById(R.id.banner_default);
        this.e = (TextView) view.findViewById(R.id.banner_text);
        this.b = (TextView) view.findViewById(R.id.tab_1);
        this.c = (TextView) view.findViewById(R.id.tab_2);
        this.d = (TextView) view.findViewById(R.id.tab_3);
        this.f = view.findViewById(R.id.pre);
        this.g = view.findViewById(R.id.next);
        this.b.setOnClickListener(onClickListener);
        this.c.setOnClickListener(onClickListener);
        this.d.setOnClickListener(onClickListener);
        this.f.setOnClickListener(onClickListener);
        this.g.setOnClickListener(onClickListener);
    }
}
