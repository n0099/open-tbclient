package com.baidu.tieba.im.view;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n extends RelativeLayout {
    private int a;
    private int b;
    private int c;
    private int d;
    private Context e;
    private p f;
    private int g;
    private int h;
    private r i;

    public void setOnItemClickListener(r rVar) {
        this.i = rVar;
    }

    public n(Context context) {
        super(context);
        this.e = context;
        addView(a(new ArrayList<>(), -2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = com.baidu.tieba.im.d.j.a(this.e, com.baidu.tieba.s.ds14);
        setLayoutParams(layoutParams);
        setBackgroundResource(com.baidu.tieba.t.bg_bottombar_meun_float);
        this.a = com.baidu.tieba.im.d.j.a(this.e, com.baidu.tieba.s.ds36);
        this.c = com.baidu.tieba.im.d.j.a(this.e, com.baidu.tieba.s.ds200);
        this.b = com.baidu.tieba.im.d.j.a(this.e, com.baidu.tieba.s.ds504);
    }

    private ListView a(List<com.baidu.tieba.im.data.l> list, int i) {
        ListView listView = new ListView(this.e);
        listView.setLayoutParams(new RelativeLayout.LayoutParams(i, -2));
        listView.setCacheColorHint(this.e.getResources().getColor(17170445));
        listView.setDivider(null);
        listView.setDividerHeight(0);
        this.f = new p(this.e, list);
        listView.setAdapter((ListAdapter) this.f);
        listView.setOnItemClickListener(new o(this));
        return listView;
    }

    public void a(int i, int i2, List<com.baidu.tieba.im.data.l> list) {
        if (list != null) {
            this.h = i;
            this.g = i2;
            this.d = a(list);
            removeAllViews();
            addView(a(list, this.d));
        }
    }

    private int a(List<com.baidu.tieba.im.data.l> list) {
        Paint paint = new Paint(1);
        paint.setColor(this.e.getResources().getColor(17170443));
        paint.setTextSize(com.baidu.tieba.im.d.j.a(this.e, com.baidu.tieba.s.ds32));
        int i = 0;
        float f = 0.0f;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                float measureText = paint.measureText(list.get(i2).b());
                if (measureText > f) {
                    f = measureText;
                }
                i = i2 + 1;
            } else {
                return (int) Math.min(Math.max((this.a * 2) + f, this.c), this.b);
            }
        }
    }

    public void a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int width = (iArr == null || iArr.length != 2) ? 0 : (iArr[0] + (view.getWidth() / 2)) - (this.d / 2);
            if (this.g == this.h - 1) {
                width = ((iArr[0] + view.getWidth()) - com.baidu.tieba.im.d.j.a(this.e, com.baidu.tieba.s.ds20)) - this.d;
            }
            if (width <= 0) {
                width = com.baidu.tieba.im.d.j.a(this.e, com.baidu.tieba.s.ds20);
            }
            layoutParams.leftMargin = width;
            setLayoutParams(layoutParams);
            setVisibility(0);
            a(true);
        }
    }

    public void a() {
        setVisibility(8);
        a(false);
    }

    public void b() {
        setVisibility(8);
    }

    public void a(boolean z) {
        if (z) {
            startAnimation(AnimationUtils.loadAnimation(this.e, com.baidu.tieba.o.sub_menu_up));
        } else {
            startAnimation(AnimationUtils.loadAnimation(this.e, com.baidu.tieba.o.sub_menu_down));
        }
    }
}
