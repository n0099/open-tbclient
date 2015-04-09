package com.baidu.tieba.im.view;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.baidu.tieba.im.util.i;
import com.baidu.tieba.p;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private int BQ;
    private int boh;
    private int boi;
    private c boj;
    private int bok;
    private int bol;
    private e bom;
    private Context mContext;
    private int mWidth;

    public void setOnItemClickListener(e eVar) {
        this.bom = eVar;
    }

    public a(Context context) {
        super(context);
        this.mContext = context;
        addView(e(new ArrayList<>(), -2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = i.j(this.mContext, t.ds14);
        setLayoutParams(layoutParams);
        setBackgroundResource(u.bg_bottombar_meun_float);
        this.boh = i.j(this.mContext, t.ds36);
        this.boi = i.j(this.mContext, t.ds200);
        this.BQ = i.j(this.mContext, t.ds504);
    }

    private ListView e(List<com.baidu.tieba.im.data.d> list, int i) {
        ListView listView = new ListView(this.mContext);
        listView.setLayoutParams(new RelativeLayout.LayoutParams(i, -2));
        listView.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        listView.setDivider(null);
        listView.setDividerHeight(0);
        this.boj = new c(this.mContext, list);
        listView.setAdapter((ListAdapter) this.boj);
        listView.setOnItemClickListener(new b(this));
        return listView;
    }

    public void a(int i, int i2, List<com.baidu.tieba.im.data.d> list) {
        if (list != null) {
            this.bol = i;
            this.bok = i2;
            this.mWidth = aK(list);
            removeAllViews();
            addView(e(list, this.mWidth));
        }
    }

    private int aK(List<com.baidu.tieba.im.data.d> list) {
        Paint paint = new Paint(1);
        paint.setColor(this.mContext.getResources().getColor(17170443));
        paint.setTextSize(i.j(this.mContext, t.ds32));
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
                return (int) Math.min(Math.max((this.boh * 2) + f, this.boi), this.BQ);
            }
        }
    }

    public void F(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int width = (iArr == null || iArr.length != 2) ? 0 : (iArr[0] + (view.getWidth() / 2)) - (this.mWidth / 2);
            if (this.bok == this.bol - 1) {
                width = ((iArr[0] + view.getWidth()) - i.j(this.mContext, t.ds20)) - this.mWidth;
            }
            if (width <= 0) {
                width = i.j(this.mContext, t.ds20);
            }
            layoutParams.leftMargin = width;
            setLayoutParams(layoutParams);
            setVisibility(0);
            cW(true);
        }
    }

    public void TS() {
        setVisibility(8);
        cW(false);
    }

    public void TT() {
        setVisibility(8);
    }

    public void cW(boolean z) {
        if (z) {
            startAnimation(AnimationUtils.loadAnimation(this.mContext, p.sub_menu_up));
        } else {
            startAnimation(AnimationUtils.loadAnimation(this.mContext, p.sub_menu_down));
        }
    }
}
