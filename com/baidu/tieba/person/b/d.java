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
    public TextView Ru;
    public int aoZ;
    public View bTh;
    public HTypeListView eZK;
    public e eZL;
    public TbPageContext mG;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.aoZ = 3;
        this.rootView = view;
        this.mG = tbPageContext;
        this.bTh = view.findViewById(d.h.divider_view_under_photo_album);
        this.Ru = (TextView) view.findViewById(d.h.text_view_photo_album);
        this.eZK = (HTypeListView) view.findViewById(d.h.listview_photo_album);
        this.eZL = new e(this.mG, this.eZK);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.eZL.setDatas(cB(fVar.getPhotoAlbum()));
        }
    }

    private List<com.baidu.adp.widget.ListView.f> cB(List<com.baidu.adp.widget.ListView.f> list) {
        if (v.t(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.f(this.mG.getPageActivity(), d.f.ds32), l.f(this.mG.getPageActivity(), d.f.ds120));
            v.a(arrayList, 0, dVar);
            v.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void DW() {
        if (this.aoZ != TbadkCoreApplication.getInst().getSkinType()) {
            this.aoZ = TbadkCoreApplication.getInst().getSkinType();
            aj.k(this.rootView, d.e.cp_bg_line_d);
            aj.k(this.bTh, d.e.cp_bg_line_c);
            aj.c(this.Ru, d.e.cp_cont_d, 1);
            this.eZL.notifyDataSetChanged();
        }
    }
}
