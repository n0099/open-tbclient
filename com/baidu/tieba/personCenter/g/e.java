package com.baidu.tieba.personCenter.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e {
    private ImageView eFW;

    public e(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(r.h.item_person_center_extra_red_tip_view, (ViewGroup) null);
        this.eFW = (ImageView) inflate.findViewById(r.g.person_center_red_tip_extra_img);
        viewGroup.addView(inflate);
    }

    public void oV(int i) {
        this.eFW.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        av.c(this.eFW, r.f.icon_news_down_bar_one, i);
    }
}
