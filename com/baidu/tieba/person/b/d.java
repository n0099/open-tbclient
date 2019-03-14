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
    public int bUK;
    public TextView btZ;
    public View hKS;
    public HTypeListView hKT;
    public e hKU;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.bUK = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.hKS = view.findViewById(d.g.divider_view_under_photo_album);
        this.btZ = (TextView) view.findViewById(d.g.text_view_photo_album);
        this.hKT = (HTypeListView) view.findViewById(d.g.listview_photo_album);
        this.hKU = new e(this.mPageContext, this.hKT);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.hKU.setDatas(dH(fVar.getPhotoAlbum()));
        }
    }

    private List<m> dH(List<m> list) {
        if (com.baidu.tbadk.core.util.v.S(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.h(this.mPageContext.getPageActivity(), d.e.ds32), l.h(this.mPageContext.getPageActivity(), d.e.ds120));
            com.baidu.tbadk.core.util.v.a(arrayList, 0, dVar);
            com.baidu.tbadk.core.util.v.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void ann() {
        if (this.bUK != TbadkCoreApplication.getInst().getSkinType()) {
            this.bUK = TbadkCoreApplication.getInst().getSkinType();
            al.l(this.rootView, d.C0277d.cp_bg_line_d);
            al.l(this.hKS, d.C0277d.cp_bg_line_c);
            al.d(this.btZ, d.C0277d.cp_cont_d, 1);
            this.hKU.notifyDataSetChanged();
        }
    }
}
