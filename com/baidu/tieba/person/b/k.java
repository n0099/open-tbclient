package com.baidu.tieba.person.b;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.n;
import com.baidu.tieba.person.a.aa;
/* loaded from: classes.dex */
public class k extends x.a {
    public TextView aNy;
    public int afY;
    public View cQc;
    public HorizontalListView cQd;
    public l cQe;
    public View rootView;

    public k(View view, Context context) {
        super(view);
        this.afY = 3;
        this.rootView = view;
        this.cQc = view.findViewById(n.f.divider_view_under_photo_album);
        this.aNy = (TextView) view.findViewById(n.f.text_view_photo_album);
        this.cQd = (HorizontalListView) view.findViewById(n.f.listview_photo_album);
        this.cQe = new l(context);
        this.cQd.setAdapter((ListAdapter) this.cQe);
        this.cQd.setDisableParentEvent(false);
    }

    public void a(aa aaVar) {
        if (aaVar != null) {
            this.cQe.setData(aaVar.getPhotoAlbum());
            this.cQe.notifyDataSetChanged();
        }
    }

    public void aos() {
        if (this.afY != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.afY = TbadkCoreApplication.m411getInst().getSkinType();
            as.j(this.rootView, n.c.cp_bg_line_d);
            as.j(this.cQc, n.c.cp_bg_line_c);
            as.b(this.aNy, n.c.cp_cont_f, 1);
            this.cQe.notifyDataSetChanged();
        }
    }
}
