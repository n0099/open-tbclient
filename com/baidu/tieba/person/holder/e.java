package com.baidu.tieba.person.holder;

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
import com.baidu.tieba.person.a.g;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends y.a {
    public TextView Ra;
    public TbPageContext ajF;
    public int amL;
    public View bAP;
    public HTypeListView eCm;
    public com.baidu.tieba.person.a.f eCn;
    public View rootView;

    public e(View view, TbPageContext tbPageContext) {
        super(view);
        this.amL = 3;
        this.rootView = view;
        this.ajF = tbPageContext;
        this.bAP = view.findViewById(w.h.divider_view_under_photo_album);
        this.Ra = (TextView) view.findViewById(w.h.text_view_photo_album);
        this.eCm = (HTypeListView) view.findViewById(w.h.listview_photo_album);
        this.eCn = new com.baidu.tieba.person.a.f(this.ajF, this.eCm);
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.eCn.setDatas(ch(gVar.getPhotoAlbum()));
        }
    }

    private List<v> ch(List<v> list) {
        if (x.p(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b(k.g(this.ajF.getPageActivity(), w.f.ds32), k.g(this.ajF.getPageActivity(), w.f.ds120));
            x.a(arrayList, 0, bVar);
            x.b(arrayList, bVar);
            return arrayList;
        }
        return list;
    }

    public void aQg() {
        if (this.amL != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.amL = TbadkCoreApplication.m9getInst().getSkinType();
            aq.k(this.rootView, w.e.cp_bg_line_d);
            aq.k(this.bAP, w.e.cp_bg_line_c);
            aq.c(this.Ra, w.e.cp_cont_d, 1);
            this.eCn.notifyDataSetChanged();
        }
    }
}
