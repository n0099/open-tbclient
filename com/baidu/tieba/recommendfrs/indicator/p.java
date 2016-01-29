package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class p extends RelativeLayout {
    private TextView YG;
    private TextView dFW;
    private View mRootView;

    public p(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(t.h.tab_item_view, this);
        this.YG = (TextView) this.mRootView.findViewById(t.g.tab_item_textview);
        this.dFW = (TextView) this.mRootView.findViewById(t.g.tab_item_red_tip);
    }

    public TextView getTextView() {
        return this.YG;
    }

    public TextView getRedTipView() {
        return this.dFW;
    }

    public void uv() {
        ar.k(this.dFW, t.f.icon_news_down_bar_one);
    }
}
