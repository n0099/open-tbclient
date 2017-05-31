package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.d;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.h;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends z.a {
    public TextView Qy;
    public TbPageContext ajh;
    public int ana;
    public View bIP;
    public HTypeListView eHc;
    public d eHd;
    public View rootView;

    public c(View view, TbPageContext tbPageContext) {
        super(view);
        this.ana = 3;
        this.rootView = view;
        this.ajh = tbPageContext;
        this.bIP = view.findViewById(w.h.divider_view_under_photo_album);
        this.Qy = (TextView) view.findViewById(w.h.text_view_photo_album);
        this.eHc = (HTypeListView) view.findViewById(w.h.listview_photo_album);
        this.eHd = new d(this.ajh, this.eHc);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.eHd.setDatas(ca(eVar.getPhotoAlbum()));
        }
    }

    private List<v> ca(List<v> list) {
        if (x.q(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            h hVar = new h(k.g(this.ajh.getPageActivity(), w.f.ds32), k.g(this.ajh.getPageActivity(), w.f.ds120));
            x.a(arrayList, 0, hVar);
            x.b(arrayList, hVar);
            return arrayList;
        }
        return list;
    }

    public void aPX() {
        if (this.ana != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.ana = TbadkCoreApplication.m9getInst().getSkinType();
            aq.k(this.rootView, w.e.cp_bg_line_d);
            aq.k(this.bIP, w.e.cp_bg_line_c);
            aq.c(this.Qy, w.e.cp_cont_d, 1);
            this.eHd.notifyDataSetChanged();
        }
    }
}
