package com.baidu.tieba.person.b;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.person.a.ae;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class n extends x.a {
    public View aAh;
    public TextView aUx;
    public View aXO;
    public int aik;
    public HorizontalListView dAC;
    public o dAD;

    public n(View view, Context context) {
        super(view);
        this.aik = 3;
        this.aAh = view;
        this.aXO = view.findViewById(t.g.divider_view_under_photo_album);
        this.aUx = (TextView) view.findViewById(t.g.text_view_photo_album);
        this.dAC = (HorizontalListView) view.findViewById(t.g.listview_photo_album);
        this.dAD = new o(context);
        this.dAC.setAdapter((ListAdapter) this.dAD);
        this.dAC.setDisableParentEvent(false);
    }

    public void a(ae aeVar) {
        if (aeVar != null) {
            this.dAD.setData(aeVar.getPhotoAlbum());
            this.dAD.notifyDataSetChanged();
        }
    }

    public void aCv() {
        if (this.aik != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.aik = TbadkCoreApplication.m411getInst().getSkinType();
            at.l(this.aAh, t.d.cp_bg_line_d);
            at.l(this.aXO, t.d.cp_bg_line_c);
            at.b(this.aUx, t.d.cp_cont_f, 1);
            this.dAD.notifyDataSetChanged();
        }
    }
}
