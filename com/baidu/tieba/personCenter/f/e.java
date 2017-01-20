package com.baidu.tieba.personCenter.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e {
    private ImageView ezO;

    public e(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(r.j.item_person_center_extra_red_tip_view, (ViewGroup) null);
        this.ezO = (ImageView) inflate.findViewById(r.h.person_center_red_tip_extra_img);
        viewGroup.addView(inflate);
    }

    public void pa(int i) {
        this.ezO.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        ap.c(this.ezO, r.g.icon_news_down_bar_one, i);
    }
}
