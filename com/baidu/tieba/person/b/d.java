package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.a.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends q.a {
    public TextView aaW;
    public int azI;
    public View cHG;
    public HTypeListView fTP;
    public e fTQ;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.azI = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.cHG = view.findViewById(d.g.divider_view_under_photo_album);
        this.aaW = (TextView) view.findViewById(d.g.text_view_photo_album);
        this.fTP = (HTypeListView) view.findViewById(d.g.listview_photo_album);
        this.fTQ = new e(this.mPageContext, this.fTP);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.fTQ.setDatas(da(fVar.getPhotoAlbum()));
        }
    }

    private List<h> da(List<h> list) {
        if (w.y(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.f(this.mPageContext.getPageActivity(), d.e.ds32), l.f(this.mPageContext.getPageActivity(), d.e.ds120));
            w.a(arrayList, 0, dVar);
            w.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void IO() {
        if (this.azI != TbadkCoreApplication.getInst().getSkinType()) {
            this.azI = TbadkCoreApplication.getInst().getSkinType();
            am.j(this.rootView, d.C0140d.cp_bg_line_d);
            am.j(this.cHG, d.C0140d.cp_bg_line_c);
            am.c(this.aaW, d.C0140d.cp_cont_d, 1);
            this.fTQ.notifyDataSetChanged();
        }
    }
}
