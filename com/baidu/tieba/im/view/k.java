package com.baidu.tieba.im.view;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.baidu.tieba.im.data.d;
import com.baidu.tieba.im.util.i;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends RelativeLayout {
    private int bqn;
    private int bqo;
    private m bqp;
    private int bqq;
    private int bqr;
    private o bqs;
    private Context mContext;
    private int mWidth;
    private int rc;

    public void setOnItemClickListener(o oVar) {
        this.bqs = oVar;
    }

    public k(Context context) {
        super(context);
        this.mContext = context;
        addView(d(new ArrayList<>(), -2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = i.i(this.mContext, u.ds14);
        setLayoutParams(layoutParams);
        setBackgroundResource(v.bg_bottombar_meun_float);
        this.bqn = i.i(this.mContext, u.ds36);
        this.bqo = i.i(this.mContext, u.ds200);
        this.rc = i.i(this.mContext, u.ds504);
    }

    private ListView d(List<d> list, int i) {
        ListView listView = new ListView(this.mContext);
        listView.setLayoutParams(new RelativeLayout.LayoutParams(i, -2));
        listView.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        listView.setDivider(null);
        listView.setDividerHeight(0);
        this.bqp = new m(this.mContext, list);
        listView.setAdapter((ListAdapter) this.bqp);
        listView.setOnItemClickListener(new l(this));
        return listView;
    }

    public void a(int i, int i2, List<d> list) {
        if (list != null) {
            this.bqr = i;
            this.bqq = i2;
            this.mWidth = aE(list);
            removeAllViews();
            addView(d(list, this.mWidth));
        }
    }

    private int aE(List<d> list) {
        Paint paint = new Paint(1);
        paint.setColor(this.mContext.getResources().getColor(17170443));
        paint.setTextSize(i.i(this.mContext, u.ds32));
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
                return (int) Math.min(Math.max((this.bqn * 2) + f, this.bqo), this.rc);
            }
        }
    }

    public void J(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int width = (iArr == null || iArr.length != 2) ? 0 : (iArr[0] + (view.getWidth() / 2)) - (this.mWidth / 2);
            if (this.bqq == this.bqr - 1) {
                width = ((iArr[0] + view.getWidth()) - i.i(this.mContext, u.ds20)) - this.mWidth;
            }
            if (width <= 0) {
                width = i.i(this.mContext, u.ds20);
            }
            layoutParams.leftMargin = width;
            setLayoutParams(layoutParams);
            setVisibility(0);
            dl(true);
        }
    }

    public void TK() {
        setVisibility(8);
        dl(false);
    }

    public void TL() {
        setVisibility(8);
    }

    public void dl(boolean z) {
        if (z) {
            startAnimation(AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.q.sub_menu_up));
        } else {
            startAnimation(AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.q.sub_menu_down));
        }
    }
}
