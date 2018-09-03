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
import com.baidu.tieba.f;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends q.a {
    public TextView aaX;
    public int azF;
    public View cHD;
    public HTypeListView fTH;
    public e fTI;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.azF = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.cHD = view.findViewById(f.g.divider_view_under_photo_album);
        this.aaX = (TextView) view.findViewById(f.g.text_view_photo_album);
        this.fTH = (HTypeListView) view.findViewById(f.g.listview_photo_album);
        this.fTI = new e(this.mPageContext, this.fTH);
    }

    public void a(com.baidu.tieba.person.a.f fVar) {
        if (fVar != null) {
            this.fTI.setDatas(da(fVar.getPhotoAlbum()));
        }
    }

    private List<h> da(List<h> list) {
        if (w.y(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.f(this.mPageContext.getPageActivity(), f.e.ds32), l.f(this.mPageContext.getPageActivity(), f.e.ds120));
            w.a(arrayList, 0, dVar);
            w.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void IO() {
        if (this.azF != TbadkCoreApplication.getInst().getSkinType()) {
            this.azF = TbadkCoreApplication.getInst().getSkinType();
            am.j(this.rootView, f.d.cp_bg_line_d);
            am.j(this.cHD, f.d.cp_bg_line_c);
            am.c(this.aaX, f.d.cp_cont_d, 1);
            this.fTI.notifyDataSetChanged();
        }
    }
}
