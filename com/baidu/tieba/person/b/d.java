package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.a.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class d extends aa.a {
    public int agt;
    public TextView dyo;
    public View klm;
    public HTypeListView kln;
    public e klo;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.agt = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.klm = view.findViewById(R.id.divider_view_under_photo_album);
        this.dyo = (TextView) view.findViewById(R.id.text_view_photo_album);
        this.kln = (HTypeListView) view.findViewById(R.id.listview_photo_album);
        this.klo = new e(this.mPageContext, this.kln);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.klo.setDatas(ee(fVar.getPhotoAlbum()));
        }
    }

    private List<o> ee(List<o> list) {
        if (v.getCount(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds120));
            v.add(arrayList, 0, dVar);
            v.add(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void cNo() {
        if (this.agt != TbadkCoreApplication.getInst().getSkinType()) {
            this.agt = TbadkCoreApplication.getInst().getSkinType();
            am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.klm, R.color.cp_bg_line_c);
            am.setViewTextColor(this.dyo, R.color.cp_cont_d, 1);
            this.klo.notifyDataSetChanged();
        }
    }
}
