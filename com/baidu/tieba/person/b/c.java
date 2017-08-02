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
    public TextView QF;
    public TbPageContext ako;
    public int aoR;
    public View bNR;
    public HTypeListView fdp;
    public d fdq;
    public View rootView;

    public c(View view, TbPageContext tbPageContext) {
        super(view);
        this.aoR = 3;
        this.rootView = view;
        this.ako = tbPageContext;
        this.bNR = view.findViewById(d.h.divider_view_under_photo_album);
        this.QF = (TextView) view.findViewById(d.h.text_view_photo_album);
        this.fdp = (HTypeListView) view.findViewById(d.h.listview_photo_album);
        this.fdq = new com.baidu.tieba.person.a.d(this.ako, this.fdp);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.fdq.setDatas(cG(eVar.getPhotoAlbum()));
        }
    }

    private List<f> cG(List<f> list) {
        if (u.u(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            h hVar = new h(k.g(this.ako.getPageActivity(), d.f.ds32), k.g(this.ako.getPageActivity(), d.f.ds120));
            u.a(arrayList, 0, hVar);
            u.b(arrayList, hVar);
            return arrayList;
        }
        return list;
    }

    public void Em() {
        if (this.aoR != TbadkCoreApplication.getInst().getSkinType()) {
            this.aoR = TbadkCoreApplication.getInst().getSkinType();
            ai.k(this.rootView, d.e.cp_bg_line_d);
            ai.k(this.bNR, d.e.cp_bg_line_c);
            ai.c(this.QF, d.e.cp_cont_d, 1);
            this.fdq.notifyDataSetChanged();
        }
    }
}
