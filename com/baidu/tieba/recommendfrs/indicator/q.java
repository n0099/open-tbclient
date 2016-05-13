package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class q extends RelativeLayout {
    private TextView Sm;
    private TextView eaS;
    private View mRootView;

    public q(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(t.h.tab_item_view, this);
        this.Sm = (TextView) this.mRootView.findViewById(t.g.tab_item_textview);
        this.eaS = (TextView) this.mRootView.findViewById(t.g.tab_item_red_tip);
    }

    public TextView getTextView() {
        return this.Sm;
    }

    public TextView getRedTipView() {
        return this.eaS;
    }

    public void sg() {
        at.k(this.eaS, t.f.icon_news_down_bar_one);
    }
}
