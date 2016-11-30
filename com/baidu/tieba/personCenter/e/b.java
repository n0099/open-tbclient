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
    public int aiA;
    public ImageView eMg;
    public TextView eMh;
    public ImageView eMi;
    public LinearLayout eMj;

    public b(View view) {
        super(view);
        this.aiA = -1;
        aB(view);
    }

    private void aB(View view) {
        if (view != null) {
            this.eMg = (ImageView) view.findViewById(r.g.person_center_list_item_icon_img);
            this.eMh = (TextView) view.findViewById(r.g.person_center_list_item_title_txt);
            this.eMi = (ImageView) view.findViewById(r.g.person_center_list_item_arrow_img);
            this.eMj = (LinearLayout) view.findViewById(r.g.person_center_list_item_extra_container);
            this.eMj.setTag(new c());
        }
    }
}
