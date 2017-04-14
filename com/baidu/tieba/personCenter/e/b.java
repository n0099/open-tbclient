package com.baidu.tieba.personCenter.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.personCenter.b.c;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends y.a {
    public int amZ;
    public ImageView eAV;
    public TextView eAW;
    public ImageView eAX;
    public LinearLayout eAY;

    public b(View view) {
        super(view);
        this.amZ = -1;
        Y(view);
    }

    private void Y(View view) {
        if (view != null) {
            this.eAV = (ImageView) view.findViewById(w.h.person_center_list_item_icon_img);
            this.eAW = (TextView) view.findViewById(w.h.person_center_list_item_title_txt);
            this.eAX = (ImageView) view.findViewById(w.h.person_center_list_item_arrow_img);
            this.eAY = (LinearLayout) view.findViewById(w.h.person_center_list_item_extra_container);
            this.eAY.setTag(new c());
        }
    }
}
