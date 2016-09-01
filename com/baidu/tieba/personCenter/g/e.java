package com.baidu.tieba.personCenter.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e {
    private ImageView eDS;

    public e(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(t.h.item_person_center_extra_red_tip_view, (ViewGroup) null);
        this.eDS = (ImageView) inflate.findViewById(t.g.person_center_red_tip_extra_img);
        viewGroup.addView(inflate);
    }

    public void oL(int i) {
        this.eDS.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        av.c(this.eDS, t.f.icon_news_down_bar_one, i);
    }
}
