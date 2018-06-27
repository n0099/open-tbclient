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
    public TextView abu;
    public int azP;
    public View cEZ;
    public HTypeListView fTC;
    public e fTD;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.azP = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.cEZ = view.findViewById(d.g.divider_view_under_photo_album);
        this.abu = (TextView) view.findViewById(d.g.text_view_photo_album);
        this.fTC = (HTypeListView) view.findViewById(d.g.listview_photo_album);
        this.fTD = new e(this.mPageContext, this.fTC);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.fTD.setDatas(de(fVar.getPhotoAlbum()));
        }
    }

    private List<h> de(List<h> list) {
        if (w.z(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.e(this.mPageContext.getPageActivity(), d.e.ds32), l.e(this.mPageContext.getPageActivity(), d.e.ds120));
            w.a(arrayList, 0, dVar);
            w.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void IT() {
        if (this.azP != TbadkCoreApplication.getInst().getSkinType()) {
            this.azP = TbadkCoreApplication.getInst().getSkinType();
            am.j(this.rootView, d.C0142d.cp_bg_line_d);
            am.j(this.cEZ, d.C0142d.cp_bg_line_c);
            am.c(this.abu, d.C0142d.cp_cont_d, 1);
            this.fTD.notifyDataSetChanged();
        }
    }
}
