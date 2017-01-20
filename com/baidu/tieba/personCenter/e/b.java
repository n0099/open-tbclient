package com.baidu.tieba.personCenter.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.personCenter.b.c;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends y.a {
    public int ahp;
    public TextView ezA;
    public ImageView ezB;
    public LinearLayout ezC;
    public ImageView ezz;

    public b(View view) {
        super(view);
        this.ahp = -1;
        aa(view);
    }

    private void aa(View view) {
        if (view != null) {
            this.ezz = (ImageView) view.findViewById(r.h.person_center_list_item_icon_img);
            this.ezA = (TextView) view.findViewById(r.h.person_center_list_item_title_txt);
            this.ezB = (ImageView) view.findViewById(r.h.person_center_list_item_arrow_img);
            this.ezC = (LinearLayout) view.findViewById(r.h.person_center_list_item_extra_container);
            this.ezC.setTag(new c());
        }
    }
}
