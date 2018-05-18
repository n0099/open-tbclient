package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.a.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends q.a {
    public TextView Ti;
    public int aqQ;
    public View cyC;
    public HTypeListView fEg;
    public e fEh;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view2, TbPageContext tbPageContext) {
        super(view2);
        this.aqQ = 3;
        this.rootView = view2;
        this.mPageContext = tbPageContext;
        this.cyC = view2.findViewById(d.g.divider_view_under_photo_album);
        this.Ti = (TextView) view2.findViewById(d.g.text_view_photo_album);
        this.fEg = (HTypeListView) view2.findViewById(d.g.listview_photo_album);
        this.fEh = new e(this.mPageContext, this.fEg);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.fEh.setDatas(cV(fVar.getPhotoAlbum()));
        }
    }

    private List<h> cV(List<h> list) {
        if (v.v(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.e(this.mPageContext.getPageActivity(), d.e.ds32), l.e(this.mPageContext.getPageActivity(), d.e.ds120));
            v.a(arrayList, 0, dVar);
            v.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void EW() {
        if (this.aqQ != TbadkCoreApplication.getInst().getSkinType()) {
            this.aqQ = TbadkCoreApplication.getInst().getSkinType();
            ak.j(this.rootView, d.C0126d.cp_bg_line_d);
            ak.j(this.cyC, d.C0126d.cp_bg_line_c);
            ak.c(this.Ti, d.C0126d.cp_cont_d, 1);
            this.fEh.notifyDataSetChanged();
        }
    }
}
