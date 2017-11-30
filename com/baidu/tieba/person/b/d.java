package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.a.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends j.a {
    public TextView Si;
    public int apA;
    public View cjj;
    public HTypeListView frf;
    public e frg;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.apA = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.cjj = view.findViewById(d.g.divider_view_under_photo_album);
        this.Si = (TextView) view.findViewById(d.g.text_view_photo_album);
        this.frf = (HTypeListView) view.findViewById(d.g.listview_photo_album);
        this.frg = new e(this.mPageContext, this.frf);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.frg.setDatas(cQ(fVar.getPhotoAlbum()));
        }
    }

    private List<com.baidu.adp.widget.ListView.f> cQ(List<com.baidu.adp.widget.ListView.f> list) {
        if (v.v(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.f(this.mPageContext.getPageActivity(), d.e.ds32), l.f(this.mPageContext.getPageActivity(), d.e.ds120));
            v.a(arrayList, 0, dVar);
            v.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void Ex() {
        if (this.apA != TbadkCoreApplication.getInst().getSkinType()) {
            this.apA = TbadkCoreApplication.getInst().getSkinType();
            aj.k(this.rootView, d.C0082d.cp_bg_line_d);
            aj.k(this.cjj, d.C0082d.cp_bg_line_c);
            aj.c(this.Si, d.C0082d.cp_cont_d, 1);
            this.frg.notifyDataSetChanged();
        }
    }
}
