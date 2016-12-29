package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.g;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends y.a {
    public TbPageContext GO;
    public TextView MK;
    public View aAK;
    public int aib;
    public View bgG;
    public HTypeListView eoS;
    public com.baidu.tieba.person.a.f eoT;

    public e(View view, TbPageContext tbPageContext) {
        super(view);
        this.aib = 3;
        this.aAK = view;
        this.GO = tbPageContext;
        this.bgG = view.findViewById(r.g.divider_view_under_photo_album);
        this.MK = (TextView) view.findViewById(r.g.text_view_photo_album);
        this.eoS = (HTypeListView) view.findViewById(r.g.listview_photo_album);
        this.eoT = new com.baidu.tieba.person.a.f(this.GO, this.eoS);
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.eoT.setDatas(cv(gVar.getPhotoAlbum()));
        }
    }

    private List<v> cv(List<v> list) {
        if (x.s(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b(k.e(this.GO.getPageActivity(), r.e.ds32), k.e(this.GO.getPageActivity(), r.e.ds120));
            x.a(arrayList, 0, bVar);
            x.b(arrayList, bVar);
            return arrayList;
        }
        return list;
    }

    public void aOD() {
        if (this.aib != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.aib = TbadkCoreApplication.m9getInst().getSkinType();
            ar.l(this.aAK, r.d.cp_bg_line_d);
            ar.l(this.bgG, r.d.cp_bg_line_c);
            ar.c(this.MK, r.d.cp_cont_d, 1);
            this.eoT.notifyDataSetChanged();
        }
    }
}
