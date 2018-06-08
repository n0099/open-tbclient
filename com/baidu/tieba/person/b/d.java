package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.a.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends q.a {
    public TextView abq;
    public int ayX;
    public View cHf;
    public HTypeListView fPA;
    public e fPB;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.ayX = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.cHf = view.findViewById(d.g.divider_view_under_photo_album);
        this.abq = (TextView) view.findViewById(d.g.text_view_photo_album);
        this.fPA = (HTypeListView) view.findViewById(d.g.listview_photo_album);
        this.fPB = new e(this.mPageContext, this.fPA);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.fPB.setDatas(da(fVar.getPhotoAlbum()));
        }
    }

    private List<h> da(List<h> list) {
        if (w.y(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.e(this.mPageContext.getPageActivity(), d.e.ds32), l.e(this.mPageContext.getPageActivity(), d.e.ds120));
            w.a(arrayList, 0, dVar);
            w.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void IB() {
        if (this.ayX != TbadkCoreApplication.getInst().getSkinType()) {
            this.ayX = TbadkCoreApplication.getInst().getSkinType();
            al.j(this.rootView, d.C0141d.cp_bg_line_d);
            al.j(this.cHf, d.C0141d.cp_bg_line_c);
            al.c(this.abq, d.C0141d.cp_cont_d, 1);
            this.fPB.notifyDataSetChanged();
        }
    }
}
