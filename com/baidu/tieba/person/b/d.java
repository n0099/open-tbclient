package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.a.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends r.a {
    public TextView aHU;
    public int bfC;
    public View dfH;
    public HTypeListView giG;
    public e giH;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.bfC = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.dfH = view.findViewById(d.g.divider_view_under_photo_album);
        this.aHU = (TextView) view.findViewById(d.g.text_view_photo_album);
        this.giG = (HTypeListView) view.findViewById(d.g.listview_photo_album);
        this.giH = new e(this.mPageContext, this.giG);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.giH.setDatas(da(fVar.getPhotoAlbum()));
        }
    }

    private List<i> da(List<i> list) {
        if (v.D(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.t(this.mPageContext.getPageActivity(), d.e.ds32), l.t(this.mPageContext.getPageActivity(), d.e.ds120));
            v.a(arrayList, 0, dVar);
            v.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void Mv() {
        if (this.bfC != TbadkCoreApplication.getInst().getSkinType()) {
            this.bfC = TbadkCoreApplication.getInst().getSkinType();
            aj.t(this.rootView, d.C0141d.cp_bg_line_d);
            aj.t(this.dfH, d.C0141d.cp_bg_line_c);
            aj.e(this.aHU, d.C0141d.cp_cont_d, 1);
            this.giH.notifyDataSetChanged();
        }
    }
}
