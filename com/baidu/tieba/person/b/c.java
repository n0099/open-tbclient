package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.d;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends j.a {
    public TextView Sg;
    public int aqm;
    public View bPK;
    public HTypeListView fgu;
    public d fgv;
    public TbPageContext oV;
    public View rootView;

    public c(View view, TbPageContext tbPageContext) {
        super(view);
        this.aqm = 3;
        this.rootView = view;
        this.oV = tbPageContext;
        this.bPK = view.findViewById(d.h.divider_view_under_photo_album);
        this.Sg = (TextView) view.findViewById(d.h.text_view_photo_album);
        this.fgu = (HTypeListView) view.findViewById(d.h.listview_photo_album);
        this.fgv = new com.baidu.tieba.person.a.d(this.oV, this.fgu);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.fgv.setDatas(cJ(eVar.getPhotoAlbum()));
        }
    }

    private List<f> cJ(List<f> list) {
        if (u.u(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            h hVar = new h(k.g(this.oV.getPageActivity(), d.f.ds32), k.g(this.oV.getPageActivity(), d.f.ds120));
            u.a(arrayList, 0, hVar);
            u.b(arrayList, hVar);
            return arrayList;
        }
        return list;
    }

    public void Eu() {
        if (this.aqm != TbadkCoreApplication.getInst().getSkinType()) {
            this.aqm = TbadkCoreApplication.getInst().getSkinType();
            ai.k(this.rootView, d.e.cp_bg_line_d);
            ai.k(this.bPK, d.e.cp_bg_line_c);
            ai.c(this.Sg, d.e.cp_cont_d, 1);
            this.fgv.notifyDataSetChanged();
        }
    }
}
