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
    public int amL;
    public ImageView eCY;
    public TextView eCZ;
    public ImageView eDa;
    public LinearLayout eDb;

    public b(View view) {
        super(view);
        this.amL = -1;
        Y(view);
    }

    private void Y(View view) {
        if (view != null) {
            this.eCY = (ImageView) view.findViewById(w.h.person_center_list_item_icon_img);
            this.eCZ = (TextView) view.findViewById(w.h.person_center_list_item_title_txt);
            this.eDa = (ImageView) view.findViewById(w.h.person_center_list_item_arrow_img);
            this.eDb = (LinearLayout) view.findViewById(w.h.person_center_list_item_extra_container);
            this.eDb.setTag(new c());
        }
    }
}
