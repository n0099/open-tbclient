package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.d;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends j.a {
    public TextView Ri;
    public int apS;
    public View bSE;
    public HTypeListView feM;
    public d feN;
    public TbPageContext mF;
    public View rootView;

    public c(View view, TbPageContext tbPageContext) {
        super(view);
        this.apS = 3;
        this.rootView = view;
        this.mF = tbPageContext;
        this.bSE = view.findViewById(d.h.divider_view_under_photo_album);
        this.Ri = (TextView) view.findViewById(d.h.text_view_photo_album);
        this.feM = (HTypeListView) view.findViewById(d.h.listview_photo_album);
        this.feN = new com.baidu.tieba.person.a.d(this.mF, this.feM);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.feN.setDatas(cG(eVar.getPhotoAlbum()));
        }
    }

    private List<f> cG(List<f> list) {
        if (v.u(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            h hVar = new h(k.g(this.mF.getPageActivity(), d.f.ds32), k.g(this.mF.getPageActivity(), d.f.ds120));
            v.a(arrayList, 0, hVar);
            v.b(arrayList, hVar);
            return arrayList;
        }
        return list;
    }

    public void Es() {
        if (this.apS != TbadkCoreApplication.getInst().getSkinType()) {
            this.apS = TbadkCoreApplication.getInst().getSkinType();
            aj.k(this.rootView, d.e.cp_bg_line_d);
            aj.k(this.bSE, d.e.cp_bg_line_c);
            aj.c(this.Ri, d.e.cp_cont_d, 1);
            this.feN.notifyDataSetChanged();
        }
    }
}
