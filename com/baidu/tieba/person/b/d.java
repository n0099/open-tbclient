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
/* loaded from: classes8.dex */
public class d extends v.a {
    public int MA;
    public TextView cGB;
    public View jbL;
    public HTypeListView jbM;
    public e jbN;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.MA = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.jbL = view.findViewById(R.id.divider_view_under_photo_album);
        this.cGB = (TextView) view.findViewById(R.id.text_view_photo_album);
        this.jbM = (HTypeListView) view.findViewById(R.id.listview_photo_album);
        this.jbN = new e(this.mPageContext, this.jbM);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.jbN.setDatas(dP(fVar.getPhotoAlbum()));
        }
    }

    private List<m> dP(List<m> list) {
        if (com.baidu.tbadk.core.util.v.getCount(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds120));
            com.baidu.tbadk.core.util.v.add(arrayList, 0, dVar);
            com.baidu.tbadk.core.util.v.add(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void csw() {
        if (this.MA != TbadkCoreApplication.getInst().getSkinType()) {
            this.MA = TbadkCoreApplication.getInst().getSkinType();
            am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.jbL, R.color.cp_bg_line_c);
            am.setViewTextColor(this.cGB, R.color.cp_cont_d, 1);
            this.jbN.notifyDataSetChanged();
        }
    }
}
