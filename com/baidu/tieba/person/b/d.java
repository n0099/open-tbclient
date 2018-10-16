package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.a.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends q.a {
    public int aHp;
    public TextView aiy;
    public View cVL;
    public e giA;
    public HTypeListView giz;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.aHp = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.cVL = view.findViewById(e.g.divider_view_under_photo_album);
        this.aiy = (TextView) view.findViewById(e.g.text_view_photo_album);
        this.giz = (HTypeListView) view.findViewById(e.g.listview_photo_album);
        this.giA = new com.baidu.tieba.person.a.e(this.mPageContext, this.giz);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.giA.setDatas(dp(fVar.getPhotoAlbum()));
        }
    }

    private List<h> dp(List<h> list) {
        if (v.I(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.h(this.mPageContext.getPageActivity(), e.C0175e.ds32), l.h(this.mPageContext.getPageActivity(), e.C0175e.ds120));
            v.a(arrayList, 0, dVar);
            v.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void Mc() {
        if (this.aHp != TbadkCoreApplication.getInst().getSkinType()) {
            this.aHp = TbadkCoreApplication.getInst().getSkinType();
            al.j(this.rootView, e.d.cp_bg_line_d);
            al.j(this.cVL, e.d.cp_bg_line_c);
            al.c(this.aiy, e.d.cp_cont_d, 1);
            this.giA.notifyDataSetChanged();
        }
    }
}
