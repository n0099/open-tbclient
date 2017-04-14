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
    public TextView Rs;
    public TbPageContext ajT;
    public int amZ;
    public View bAI;
    public HTypeListView eAh;
    public f eAi;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.amZ = 3;
        this.rootView = view;
        this.ajT = tbPageContext;
        this.bAI = view.findViewById(w.h.divider_view_under_photo_album);
        this.Rs = (TextView) view.findViewById(w.h.text_view_photo_album);
        this.eAh = (HTypeListView) view.findViewById(w.h.listview_photo_album);
        this.eAi = new f(this.ajT, this.eAh);
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.eAi.setDatas(cg(gVar.getPhotoAlbum()));
        }
    }

    private List<v> cg(List<v> list) {
        if (x.p(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b(k.g(this.ajT.getPageActivity(), w.f.ds32), k.g(this.ajT.getPageActivity(), w.f.ds120));
            x.a(arrayList, 0, bVar);
            x.b(arrayList, bVar);
            return arrayList;
        }
        return list;
    }

    public void aQp() {
        if (this.amZ != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.amZ = TbadkCoreApplication.m9getInst().getSkinType();
            aq.k(this.rootView, w.e.cp_bg_line_d);
            aq.k(this.bAI, w.e.cp_bg_line_c);
            aq.c(this.Rs, w.e.cp_cont_d, 1);
            this.eAi.notifyDataSetChanged();
        }
    }
}
