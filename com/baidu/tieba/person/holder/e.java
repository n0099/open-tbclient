package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.f;
import com.baidu.tieba.person.a.g;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends y.a {
    public TbPageContext GO;
    public TextView MN;
    public View aBq;
    public int aiA;
    public View bhn;
    public HTypeListView eLn;
    public f eLo;

    public e(View view, TbPageContext tbPageContext) {
        super(view);
        this.aiA = 3;
        this.aBq = view;
        this.GO = tbPageContext;
        this.bhn = view.findViewById(r.g.divider_view_under_photo_album);
        this.MN = (TextView) view.findViewById(r.g.text_view_photo_album);
        this.eLn = (HTypeListView) view.findViewById(r.g.listview_photo_album);
        this.eLo = new f(this.GO, this.eLn);
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.eLo.setDatas(cE(gVar.getPhotoAlbum()));
        }
    }

    private List<v> cE(List<v> list) {
        if (x.s(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b(k.e(this.GO.getPageActivity(), r.e.ds32), k.e(this.GO.getPageActivity(), r.e.ds120));
            x.a(arrayList, 0, bVar);
            x.b(arrayList, bVar);
            return arrayList;
        }
        return list;
    }

    public void aUT() {
        if (this.aiA != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.aiA = TbadkCoreApplication.m9getInst().getSkinType();
            at.l(this.aBq, r.d.cp_bg_line_d);
            at.l(this.bhn, r.d.cp_bg_line_c);
            at.c(this.MN, r.d.cp_cont_d, 1);
            this.eLo.notifyDataSetChanged();
        }
    }
}
