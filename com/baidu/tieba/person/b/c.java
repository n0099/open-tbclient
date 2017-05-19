package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.d;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends y.a {
    public TextView QL;
    public TbPageContext ajr;
    public int ane;
    public View bDa;
    public HTypeListView eyk;
    public d eyl;
    public View rootView;

    public c(View view, TbPageContext tbPageContext) {
        super(view);
        this.ane = 3;
        this.rootView = view;
        this.ajr = tbPageContext;
        this.bDa = view.findViewById(w.h.divider_view_under_photo_album);
        this.QL = (TextView) view.findViewById(w.h.text_view_photo_album);
        this.eyk = (HTypeListView) view.findViewById(w.h.listview_photo_album);
        this.eyl = new d(this.ajr, this.eyk);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.eyl.setDatas(bY(eVar.getPhotoAlbum()));
        }
    }

    private List<v> bY(List<v> list) {
        if (x.q(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.personCenter.b.b bVar = new com.baidu.tieba.personCenter.b.b(k.g(this.ajr.getPageActivity(), w.f.ds32), k.g(this.ajr.getPageActivity(), w.f.ds120));
            x.a(arrayList, 0, bVar);
            x.b(arrayList, bVar);
            return arrayList;
        }
        return list;
    }

    public void aOH() {
        if (this.ane != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.ane = TbadkCoreApplication.m9getInst().getSkinType();
            aq.k(this.rootView, w.e.cp_bg_line_d);
            aq.k(this.bDa, w.e.cp_bg_line_c);
            aq.c(this.QL, w.e.cp_cont_d, 1);
            this.eyl.notifyDataSetChanged();
        }
    }
}
