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
    public int aph;
    public View caM;
    public HTypeListView fii;
    public e fij;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.aph = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.caM = view.findViewById(d.g.divider_view_under_photo_album);
        this.Rz = (TextView) view.findViewById(d.g.text_view_photo_album);
        this.fii = (HTypeListView) view.findViewById(d.g.listview_photo_album);
        this.fij = new e(this.mPageContext, this.fii);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.fij.setDatas(cD(fVar.getPhotoAlbum()));
        }
    }

    private List<com.baidu.adp.widget.ListView.f> cD(List<com.baidu.adp.widget.ListView.f> list) {
        if (v.u(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.f(this.mPageContext.getPageActivity(), d.e.ds32), l.f(this.mPageContext.getPageActivity(), d.e.ds120));
            v.a(arrayList, 0, dVar);
            v.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void Eq() {
        if (this.aph != TbadkCoreApplication.getInst().getSkinType()) {
            this.aph = TbadkCoreApplication.getInst().getSkinType();
            aj.k(this.rootView, d.C0080d.cp_bg_line_d);
            aj.k(this.caM, d.C0080d.cp_bg_line_c);
            aj.c(this.Rz, d.C0080d.cp_cont_d, 1);
            this.fij.notifyDataSetChanged();
        }
    }
}
