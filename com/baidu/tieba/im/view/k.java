package com.baidu.tieba.im.view;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends RelativeLayout {
    private int bjs;
    private int bjt;
    private m bju;
    private int bjv;
    private int bjw;
    private o bjx;
    private Context mContext;
    private int mWidth;
    private int rd;

    public void setOnItemClickListener(o oVar) {
        this.bjx = oVar;
    }

    public k(Context context) {
        super(context);
        this.mContext = context;
        addView(c(new ArrayList<>(), -2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = com.baidu.tieba.im.util.i.k(this.mContext, t.ds14);
        setLayoutParams(layoutParams);
        setBackgroundResource(u.bg_bottombar_meun_float);
        this.bjs = com.baidu.tieba.im.util.i.k(this.mContext, t.ds36);
        this.bjt = com.baidu.tieba.im.util.i.k(this.mContext, t.ds200);
        this.rd = com.baidu.tieba.im.util.i.k(this.mContext, t.ds504);
    }

    private ListView c(List<com.baidu.tieba.im.data.f> list, int i) {
        ListView listView = new ListView(this.mContext);
        listView.setLayoutParams(new RelativeLayout.LayoutParams(i, -2));
        listView.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        listView.setDivider(null);
        listView.setDividerHeight(0);
        this.bju = new m(this.mContext, list);
        listView.setAdapter((ListAdapter) this.bju);
        listView.setOnItemClickListener(new l(this));
        return listView;
    }

    public void a(int i, int i2, List<com.baidu.tieba.im.data.f> list) {
        if (list != null) {
            this.bjw = i;
            this.bjv = i2;
            this.mWidth = ae(list);
            removeAllViews();
            addView(c(list, this.mWidth));
        }
    }

    private int ae(List<com.baidu.tieba.im.data.f> list) {
        Paint paint = new Paint(1);
        paint.setColor(this.mContext.getResources().getColor(17170443));
        paint.setTextSize(com.baidu.tieba.im.util.i.k(this.mContext, t.ds32));
        int i = 0;
        float f = 0.0f;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                float measureText = paint.measureText(list.get(i2).getName());
                if (measureText > f) {
                    f = measureText;
                }
                i = i2 + 1;
            } else {
                return (int) Math.min(Math.max((this.bjs * 2) + f, this.bjt), this.rd);
            }
        }
    }

    public void N(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int width = (iArr == null || iArr.length != 2) ? 0 : (iArr[0] + (view.getWidth() / 2)) - (this.mWidth / 2);
            if (this.bjv == this.bjw - 1) {
                width = ((iArr[0] + view.getWidth()) - com.baidu.tieba.im.util.i.k(this.mContext, t.ds20)) - this.mWidth;
            }
            if (width <= 0) {
                width = com.baidu.tieba.im.util.i.k(this.mContext, t.ds20);
            }
            layoutParams.leftMargin = width;
            setLayoutParams(layoutParams);
            setVisibility(0);
            dt(true);
        }
    }

    public void RT() {
        setVisibility(8);
        dt(false);
    }

    public void RU() {
        setVisibility(8);
    }

    public void dt(boolean z) {
        if (z) {
            startAnimation(AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.p.sub_menu_up));
        } else {
            startAnimation(AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.p.sub_menu_down));
        }
    }
}
