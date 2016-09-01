package com.baidu.tieba.personCenter.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.personCenter.b.c;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends y.a {
    public int ait;
    public ImageView eDD;
    public TextView eDE;
    public ImageView eDF;
    public LinearLayout eDG;

    public b(View view) {
        super(view);
        this.ait = -1;
        aD(view);
    }

    private void aD(View view) {
        if (view != null) {
            this.eDD = (ImageView) view.findViewById(t.g.person_center_list_item_icon_img);
            this.eDE = (TextView) view.findViewById(t.g.person_center_list_item_title_txt);
            this.eDF = (ImageView) view.findViewById(t.g.person_center_list_item_arrow_img);
            this.eDG = (LinearLayout) view.findViewById(t.g.person_center_list_item_extra_container);
            this.eDG.setTag(new c());
        }
    }
}
