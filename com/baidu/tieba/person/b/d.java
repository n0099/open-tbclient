package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.a.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends v.a {
    public TextView bUf;
    public int csg;
    public View ijU;
    public HTypeListView ijV;
    public e ijW;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.csg = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.ijU = view.findViewById(R.id.divider_view_under_photo_album);
        this.bUf = (TextView) view.findViewById(R.id.text_view_photo_album);
        this.ijV = (HTypeListView) view.findViewById(R.id.listview_photo_album);
        this.ijW = new e(this.mPageContext, this.ijV);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.ijW.setDatas(ea(fVar.getPhotoAlbum()));
        }
    }

    private List<m> ea(List<m> list) {
        if (com.baidu.tbadk.core.util.v.getCount(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds120));
            com.baidu.tbadk.core.util.v.add(arrayList, 0, dVar);
            com.baidu.tbadk.core.util.v.add(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void avq() {
        if (this.csg != TbadkCoreApplication.getInst().getSkinType()) {
            this.csg = TbadkCoreApplication.getInst().getSkinType();
            am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.ijU, R.color.cp_bg_line_c);
            am.setViewTextColor(this.bUf, R.color.cp_cont_d, 1);
            this.ijW.notifyDataSetChanged();
        }
    }
}
