package com.baidu.tieba.person.b;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.person.a.ae;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class n extends x.a {
    public TextView aQR;
    public View aUc;
    public int ahU;
    public View azA;
    public HorizontalListView dgd;
    public o dge;

    public n(View view, Context context) {
        super(view);
        this.ahU = 3;
        this.azA = view;
        this.aUc = view.findViewById(t.g.divider_view_under_photo_album);
        this.aQR = (TextView) view.findViewById(t.g.text_view_photo_album);
        this.dgd = (HorizontalListView) view.findViewById(t.g.listview_photo_album);
        this.dge = new o(context);
        this.dgd.setAdapter((ListAdapter) this.dge);
        this.dgd.setDisableParentEvent(false);
    }

    public void a(ae aeVar) {
        if (aeVar != null) {
            this.dge.setData(aeVar.getPhotoAlbum());
            this.dge.notifyDataSetChanged();
        }
    }

    public void auP() {
        if (this.ahU != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.ahU = TbadkCoreApplication.m411getInst().getSkinType();
            ar.l(this.azA, t.d.cp_bg_line_d);
            ar.l(this.aUc, t.d.cp_bg_line_c);
            ar.b(this.aQR, t.d.cp_cont_f, 1);
            this.dge.notifyDataSetChanged();
        }
    }
}
