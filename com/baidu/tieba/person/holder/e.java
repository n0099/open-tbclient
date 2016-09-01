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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends y.a {
    public TbPageContext GM;
    public TextView MO;
    public View aAV;
    public int ait;
    public View bdU;
    public HTypeListView eCL;
    public f eCM;

    public e(View view, TbPageContext tbPageContext) {
        super(view);
        this.ait = 3;
        this.aAV = view;
        this.GM = tbPageContext;
        this.bdU = view.findViewById(t.g.divider_view_under_photo_album);
        this.MO = (TextView) view.findViewById(t.g.text_view_photo_album);
        this.eCL = (HTypeListView) view.findViewById(t.g.listview_photo_album);
        this.eCM = new f(this.GM, this.eCL);
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.eCM.setDatas(cB(gVar.getPhotoAlbum()));
        }
    }

    private List<v> cB(List<v> list) {
        if (com.baidu.tbadk.core.util.y.s(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b(k.e(this.GM.getPageActivity(), t.e.ds32), k.e(this.GM.getPageActivity(), t.e.ds120));
            com.baidu.tbadk.core.util.y.a(arrayList, 0, bVar);
            com.baidu.tbadk.core.util.y.b(arrayList, bVar);
            return arrayList;
        }
        return list;
    }

    public void aSo() {
        if (this.ait != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.ait = TbadkCoreApplication.m9getInst().getSkinType();
            av.l(this.aAV, t.d.cp_bg_line_d);
            av.l(this.bdU, t.d.cp_bg_line_c);
            av.c(this.MO, t.d.cp_cont_d, 1);
            this.eCM.notifyDataSetChanged();
        }
    }
}
