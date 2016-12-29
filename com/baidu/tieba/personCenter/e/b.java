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
    public int aib;
    public ImageView epC;
    public TextView epD;
    public ImageView epE;
    public LinearLayout epF;

    public b(View view) {
        super(view);
        this.aib = -1;
        aB(view);
    }

    private void aB(View view) {
        if (view != null) {
            this.epC = (ImageView) view.findViewById(r.g.person_center_list_item_icon_img);
            this.epD = (TextView) view.findViewById(r.g.person_center_list_item_title_txt);
            this.epE = (ImageView) view.findViewById(r.g.person_center_list_item_arrow_img);
            this.epF = (LinearLayout) view.findViewById(r.g.person_center_list_item_extra_container);
            this.epF.setTag(new c());
        }
    }
}
