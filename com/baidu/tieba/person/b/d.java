package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.f;
import com.baidu.tieba.person.a.g;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends y.a {
    public TextView Ru;
    public TbPageContext ajU;
    public int amZ;
    public View bCZ;
    public HTypeListView eCx;
    public f eCy;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.amZ = 3;
        this.rootView = view;
        this.ajU = tbPageContext;
        this.bCZ = view.findViewById(w.h.divider_view_under_photo_album);
        this.Ru = (TextView) view.findViewById(w.h.text_view_photo_album);
        this.eCx = (HTypeListView) view.findViewById(w.h.listview_photo_album);
        this.eCy = new f(this.ajU, this.eCx);
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.eCy.setDatas(ch(gVar.getPhotoAlbum()));
        }
    }

    private List<v> ch(List<v> list) {
        if (x.p(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b(k.g(this.ajU.getPageActivity(), w.f.ds32), k.g(this.ajU.getPageActivity(), w.f.ds120));
            x.a(arrayList, 0, bVar);
            x.b(arrayList, bVar);
            return arrayList;
        }
        return list;
    }

    public void aRq() {
        if (this.amZ != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.amZ = TbadkCoreApplication.m9getInst().getSkinType();
            aq.k(this.rootView, w.e.cp_bg_line_d);
            aq.k(this.bCZ, w.e.cp_bg_line_c);
            aq.c(this.Ru, w.e.cp_cont_d, 1);
            this.eCy.notifyDataSetChanged();
        }
    }
}
