package com.baidu.tieba.person.b;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.person.a.ah;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class p extends y.a {
    public TextView KC;
    public View aTI;
    public int aej;
    public View awk;
    public HorizontalListView dDK;
    public ah dDL;

    public p(View view, Context context) {
        super(view);
        this.aej = 3;
        this.awk = view;
        this.aTI = view.findViewById(t.g.divider_view_under_hi_album);
        this.KC = (TextView) view.findViewById(t.g.text_view_hi_album);
        this.dDK = (HorizontalListView) view.findViewById(t.g.listview_user_hi_album);
        this.dDL = new ah(context);
        this.dDK.setAdapter((ListAdapter) this.dDL);
    }

    public void a(com.baidu.tieba.person.data.s sVar) {
        if (sVar != null) {
            this.dDL.setData(sVar.aCu());
            this.dDL.notifyDataSetChanged();
        }
    }

    public void aCQ() {
        if (this.aej != TbadkCoreApplication.m11getInst().getSkinType()) {
            this.aej = TbadkCoreApplication.m11getInst().getSkinType();
            at.l(this.awk, t.d.cp_bg_line_d);
            at.l(this.aTI, t.d.cp_bg_line_c);
            at.c(this.KC, t.d.cp_cont_f, 1);
            this.dDL.notifyDataSetChanged();
        }
    }
}
