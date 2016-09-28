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
    public int ahV;
    public ImageView eFH;
    public TextView eFI;
    public ImageView eFJ;
    public LinearLayout eFK;

    public b(View view) {
        super(view);
        this.ahV = -1;
        aC(view);
    }

    private void aC(View view) {
        if (view != null) {
            this.eFH = (ImageView) view.findViewById(r.g.person_center_list_item_icon_img);
            this.eFI = (TextView) view.findViewById(r.g.person_center_list_item_title_txt);
            this.eFJ = (ImageView) view.findViewById(r.g.person_center_list_item_arrow_img);
            this.eFK = (LinearLayout) view.findViewById(r.g.person_center_list_item_extra_container);
            this.eFK.setTag(new c());
        }
    }
}
