package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.a.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends v.a {
    public int bUM;
    public TextView buc;
    public View hKE;
    public HTypeListView hKF;
    public e hKG;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.bUM = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.hKE = view.findViewById(d.g.divider_view_under_photo_album);
        this.buc = (TextView) view.findViewById(d.g.text_view_photo_album);
        this.hKF = (HTypeListView) view.findViewById(d.g.listview_photo_album);
        this.hKG = new e(this.mPageContext, this.hKF);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.hKG.setDatas(dE(fVar.getPhotoAlbum()));
        }
    }

    private List<m> dE(List<m> list) {
        if (com.baidu.tbadk.core.util.v.S(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.h(this.mPageContext.getPageActivity(), d.e.ds32), l.h(this.mPageContext.getPageActivity(), d.e.ds120));
            com.baidu.tbadk.core.util.v.a(arrayList, 0, dVar);
            com.baidu.tbadk.core.util.v.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void ank() {
        if (this.bUM != TbadkCoreApplication.getInst().getSkinType()) {
            this.bUM = TbadkCoreApplication.getInst().getSkinType();
            al.l(this.rootView, d.C0277d.cp_bg_line_d);
            al.l(this.hKE, d.C0277d.cp_bg_line_c);
            al.d(this.buc, d.C0277d.cp_cont_d, 1);
            this.hKG.notifyDataSetChanged();
        }
    }
}
