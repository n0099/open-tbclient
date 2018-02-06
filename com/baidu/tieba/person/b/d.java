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
    public TextView aIe;
    public int bfL;
    public View dfQ;
    public HTypeListView giB;
    public e giC;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.bfL = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.dfQ = view.findViewById(d.g.divider_view_under_photo_album);
        this.aIe = (TextView) view.findViewById(d.g.text_view_photo_album);
        this.giB = (HTypeListView) view.findViewById(d.g.listview_photo_album);
        this.giC = new e(this.mPageContext, this.giB);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.giC.setDatas(da(fVar.getPhotoAlbum()));
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
        if (this.bfL != TbadkCoreApplication.getInst().getSkinType()) {
            this.bfL = TbadkCoreApplication.getInst().getSkinType();
            aj.t(this.rootView, d.C0140d.cp_bg_line_d);
            aj.t(this.dfQ, d.C0140d.cp_bg_line_c);
            aj.e(this.aIe, d.C0140d.cp_cont_d, 1);
            this.giC.notifyDataSetChanged();
        }
    }
}
