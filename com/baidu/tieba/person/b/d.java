package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.a.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends q.a {
    public int aLF;
    public TextView amN;
    public View ddC;
    public HTypeListView gqM;
    public e gqN;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.aLF = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.ddC = view.findViewById(e.g.divider_view_under_photo_album);
        this.amN = (TextView) view.findViewById(e.g.text_view_photo_album);
        this.gqM = (HTypeListView) view.findViewById(e.g.listview_photo_album);
        this.gqN = new com.baidu.tieba.person.a.e(this.mPageContext, this.gqM);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.gqN.setDatas(dr(fVar.getPhotoAlbum()));
        }
    }

    private List<h> dr(List<h> list) {
        if (v.H(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds32), l.h(this.mPageContext.getPageActivity(), e.C0210e.ds120));
            v.a(arrayList, 0, dVar);
            v.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void Ns() {
        if (this.aLF != TbadkCoreApplication.getInst().getSkinType()) {
            this.aLF = TbadkCoreApplication.getInst().getSkinType();
            al.j(this.rootView, e.d.cp_bg_line_d);
            al.j(this.ddC, e.d.cp_bg_line_c);
            al.c(this.amN, e.d.cp_cont_d, 1);
            this.gqN.notifyDataSetChanged();
        }
    }
}
