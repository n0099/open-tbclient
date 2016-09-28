package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.f;
import com.baidu.tieba.person.a.g;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends y.a {
    public TbPageContext GM;
    public TextView MN;
    public View aAy;
    public int ahV;
    public View ben;
    public HTypeListView eEO;
    public f eEP;

    public e(View view, TbPageContext tbPageContext) {
        super(view);
        this.ahV = 3;
        this.aAy = view;
        this.GM = tbPageContext;
        this.ben = view.findViewById(r.g.divider_view_under_photo_album);
        this.MN = (TextView) view.findViewById(r.g.text_view_photo_album);
        this.eEO = (HTypeListView) view.findViewById(r.g.listview_photo_album);
        this.eEP = new f(this.GM, this.eEO);
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.eEP.setDatas(cC(gVar.getPhotoAlbum()));
        }
    }

    private List<v> cC(List<v> list) {
        if (com.baidu.tbadk.core.util.y.s(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b(k.e(this.GM.getPageActivity(), r.e.ds32), k.e(this.GM.getPageActivity(), r.e.ds120));
            com.baidu.tbadk.core.util.y.a(arrayList, 0, bVar);
            com.baidu.tbadk.core.util.y.b(arrayList, bVar);
            return arrayList;
        }
        return list;
    }

    public void aSM() {
        if (this.ahV != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.ahV = TbadkCoreApplication.m9getInst().getSkinType();
            av.l(this.aAy, r.d.cp_bg_line_d);
            av.l(this.ben, r.d.cp_bg_line_c);
            av.c(this.MN, r.d.cp_cont_d, 1);
            this.eEP.notifyDataSetChanged();
        }
    }
}
