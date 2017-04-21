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
    private ImageView eDA;

    public e(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(w.j.item_person_center_extra_red_tip_view, (ViewGroup) null);
        this.eDA = (ImageView) inflate.findViewById(w.h.person_center_red_tip_extra_img);
        viewGroup.addView(inflate);
    }

    public void pa(int i) {
        this.eDA.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        aq.c(this.eDA, w.g.icon_news_down_bar_one, i);
    }
}
