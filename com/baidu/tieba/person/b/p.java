package com.baidu.tieba.person.b;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.person.a.ah;
import com.baidu.tieba.person.data.s;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class p extends y.a {
    public TextView KC;
    public View aXd;
    public int aeK;
    public View axa;
    public HorizontalListView emw;
    public ah emx;

    public p(View view, Context context) {
        super(view);
        this.aeK = 3;
        this.axa = view;
        this.aXd = view.findViewById(u.g.divider_view_under_hi_album);
        this.KC = (TextView) view.findViewById(u.g.text_view_hi_album);
        this.emw = (HorizontalListView) view.findViewById(u.g.listview_user_hi_album);
        this.emx = new ah(context);
        this.emw.setAdapter((ListAdapter) this.emx);
    }

    public void a(s sVar) {
        if (sVar != null) {
            this.emx.setData(sVar.aLn());
            this.emx.notifyDataSetChanged();
        }
    }

    public void aLM() {
        if (this.aeK != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.aeK = TbadkCoreApplication.m9getInst().getSkinType();
            av.l(this.axa, u.d.cp_bg_line_d);
            av.l(this.aXd, u.d.cp_bg_line_c);
            av.c(this.KC, u.d.cp_cont_f, 1);
            this.emx.notifyDataSetChanged();
        }
    }
}
