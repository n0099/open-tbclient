package com.baidu.tieba.personCenter.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e {
    private ImageView eBk;

    public e(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(w.j.item_person_center_extra_red_tip_view, (ViewGroup) null);
        this.eBk = (ImageView) inflate.findViewById(w.h.person_center_red_tip_extra_img);
        viewGroup.addView(inflate);
    }

    public void oU(int i) {
        this.eBk.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        aq.c(this.eBk, w.g.icon_news_down_bar_one, i);
    }
}
