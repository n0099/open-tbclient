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
    public ImageView eDl;
    public TextView eDm;
    public ImageView eDn;
    public LinearLayout eDo;

    public b(View view) {
        super(view);
        this.amZ = -1;
        Y(view);
    }

    private void Y(View view) {
        if (view != null) {
            this.eDl = (ImageView) view.findViewById(w.h.person_center_list_item_icon_img);
            this.eDm = (TextView) view.findViewById(w.h.person_center_list_item_title_txt);
            this.eDn = (ImageView) view.findViewById(w.h.person_center_list_item_arrow_img);
            this.eDo = (LinearLayout) view.findViewById(w.h.person_center_list_item_extra_container);
            this.eDo.setTag(new c());
        }
    }
}
