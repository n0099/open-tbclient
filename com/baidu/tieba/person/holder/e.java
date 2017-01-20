package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.g;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends y.a {
    public TbPageContext FY;
    public TextView LX;
    public int ahp;
    public View btH;
    public HTypeListView eyN;
    public com.baidu.tieba.person.a.f eyO;
    public View rootView;

    public e(View view, TbPageContext tbPageContext) {
        super(view);
        this.ahp = 3;
        this.rootView = view;
        this.FY = tbPageContext;
        this.btH = view.findViewById(r.h.divider_view_under_photo_album);
        this.LX = (TextView) view.findViewById(r.h.text_view_photo_album);
        this.eyN = (HTypeListView) view.findViewById(r.h.listview_photo_album);
        this.eyO = new com.baidu.tieba.person.a.f(this.FY, this.eyN);
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.eyO.setDatas(cA(gVar.getPhotoAlbum()));
        }
    }

    private List<v> cA(List<v> list) {
        if (w.r(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b(k.e(this.FY.getPageActivity(), r.f.ds32), k.e(this.FY.getPageActivity(), r.f.ds120));
            w.a(arrayList, 0, bVar);
            w.b(arrayList, bVar);
            return arrayList;
        }
        return list;
    }

    public void aQD() {
        if (this.ahp != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.ahp = TbadkCoreApplication.m9getInst().getSkinType();
            ap.k(this.rootView, r.e.cp_bg_line_d);
            ap.k(this.btH, r.e.cp_bg_line_c);
            ap.c(this.LX, r.e.cp_cont_d, 1);
            this.eyO.notifyDataSetChanged();
        }
    }
}
