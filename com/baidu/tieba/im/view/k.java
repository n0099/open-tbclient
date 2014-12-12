package com.baidu.tieba.im.view;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.baidu.tieba.im.data.c;
import com.baidu.tieba.im.util.i;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends RelativeLayout {
    private int boQ;
    private int boR;
    private m boS;
    private int boT;
    private int boU;
    private o boV;
    private Context mContext;
    private int mWidth;
    private int qX;

    public void setOnItemClickListener(o oVar) {
        this.boV = oVar;
    }

    public k(Context context) {
        super(context);
        this.mContext = context;
        addView(d(new ArrayList<>(), -2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = i.j(this.mContext, u.ds14);
        setLayoutParams(layoutParams);
        setBackgroundResource(v.bg_bottombar_meun_float);
        this.boQ = i.j(this.mContext, u.ds36);
        this.boR = i.j(this.mContext, u.ds200);
        this.qX = i.j(this.mContext, u.ds504);
    }

    private ListView d(List<c> list, int i) {
        ListView listView = new ListView(this.mContext);
        listView.setLayoutParams(new RelativeLayout.LayoutParams(i, -2));
        listView.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        listView.setDivider(null);
        listView.setDividerHeight(0);
        this.boS = new m(this.mContext, list);
        listView.setAdapter((ListAdapter) this.boS);
        listView.setOnItemClickListener(new l(this));
        return listView;
    }

    public void a(int i, int i2, List<c> list) {
        if (list != null) {
            this.boU = i;
            this.boT = i2;
            this.mWidth = aB(list);
            removeAllViews();
            addView(d(list, this.mWidth));
        }
    }

    private int aB(List<c> list) {
        Paint paint = new Paint(1);
        paint.setColor(this.mContext.getResources().getColor(17170443));
        paint.setTextSize(i.j(this.mContext, u.ds32));
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
                return (int) Math.min(Math.max((this.boQ * 2) + f, this.boR), this.qX);
            }
        }
    }

    public void H(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int width = (iArr == null || iArr.length != 2) ? 0 : (iArr[0] + (view.getWidth() / 2)) - (this.mWidth / 2);
            if (this.boT == this.boU - 1) {
                width = ((iArr[0] + view.getWidth()) - i.j(this.mContext, u.ds20)) - this.mWidth;
            }
            if (width <= 0) {
                width = i.j(this.mContext, u.ds20);
            }
            layoutParams.leftMargin = width;
            setLayoutParams(layoutParams);
            setVisibility(0);
            dg(true);
        }
    }

    public void To() {
        setVisibility(8);
        dg(false);
    }

    public void Tp() {
        setVisibility(8);
    }

    public void dg(boolean z) {
        if (z) {
            startAnimation(AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.q.sub_menu_up));
        } else {
            startAnimation(AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.q.sub_menu_down));
        }
    }
}
