package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.a.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class d extends ad.a {
    public int aho;
    public TextView dJr;
    public View kOa;
    public HTypeListView kOb;
    public e kOc;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.aho = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.kOa = view.findViewById(R.id.divider_view_under_photo_album);
        this.dJr = (TextView) view.findViewById(R.id.text_view_photo_album);
        this.kOb = (HTypeListView) view.findViewById(R.id.listview_photo_album);
        this.kOc = new e(this.mPageContext, this.kOb);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.kOc.setDatas(ey(fVar.getPhotoAlbum()));
        }
    }

    private List<q> ey(List<q> list) {
        if (x.getCount(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds120));
            x.add(arrayList, 0, dVar);
            x.add(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void cVw() {
        if (this.aho != TbadkCoreApplication.getInst().getSkinType()) {
            this.aho = TbadkCoreApplication.getInst().getSkinType();
            ao.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
            ao.setBackgroundColor(this.kOa, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.dJr, R.color.cp_cont_d, 1);
            this.kOc.notifyDataSetChanged();
        }
    }
}
