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
    public int aIf;
    public TextView ajl;
    public View cWR;
    public HTypeListView gjW;
    public e gjX;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.aIf = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.cWR = view.findViewById(e.g.divider_view_under_photo_album);
        this.ajl = (TextView) view.findViewById(e.g.text_view_photo_album);
        this.gjW = (HTypeListView) view.findViewById(e.g.listview_photo_album);
        this.gjX = new com.baidu.tieba.person.a.e(this.mPageContext, this.gjW);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.gjX.setDatas(dn(fVar.getPhotoAlbum()));
        }
    }

    private List<h> dn(List<h> list) {
        if (v.H(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.h(this.mPageContext.getPageActivity(), e.C0200e.ds32), l.h(this.mPageContext.getPageActivity(), e.C0200e.ds120));
            v.a(arrayList, 0, dVar);
            v.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void Mo() {
        if (this.aIf != TbadkCoreApplication.getInst().getSkinType()) {
            this.aIf = TbadkCoreApplication.getInst().getSkinType();
            al.j(this.rootView, e.d.cp_bg_line_d);
            al.j(this.cWR, e.d.cp_bg_line_c);
            al.c(this.ajl, e.d.cp_cont_d, 1);
            this.gjX.notifyDataSetChanged();
        }
    }
}
