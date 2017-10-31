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
    public TextView Rz;
    public int api;
    public View caz;
    public HTypeListView fhL;
    public e fhM;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.api = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.caz = view.findViewById(d.g.divider_view_under_photo_album);
        this.Rz = (TextView) view.findViewById(d.g.text_view_photo_album);
        this.fhL = (HTypeListView) view.findViewById(d.g.listview_photo_album);
        this.fhM = new e(this.mPageContext, this.fhL);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.fhM.setDatas(cC(fVar.getPhotoAlbum()));
        }
    }

    private List<com.baidu.adp.widget.ListView.f> cC(List<com.baidu.adp.widget.ListView.f> list) {
        if (v.u(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.f(this.mPageContext.getPageActivity(), d.e.ds32), l.f(this.mPageContext.getPageActivity(), d.e.ds120));
            v.a(arrayList, 0, dVar);
            v.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void Ee() {
        if (this.api != TbadkCoreApplication.getInst().getSkinType()) {
            this.api = TbadkCoreApplication.getInst().getSkinType();
            aj.k(this.rootView, d.C0080d.cp_bg_line_d);
            aj.k(this.caz, d.C0080d.cp_bg_line_c);
            aj.c(this.Rz, d.C0080d.cp_cont_d, 1);
            this.fhM.notifyDataSetChanged();
        }
    }
}
