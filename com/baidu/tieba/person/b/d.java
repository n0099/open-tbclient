package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.a.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends v.a {
    public TextView bBh;
    public int ccJ;
    public View icI;
    public HTypeListView icJ;
    public e icK;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.ccJ = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.icI = view.findViewById(R.id.divider_view_under_photo_album);
        this.bBh = (TextView) view.findViewById(R.id.text_view_photo_album);
        this.icJ = (HTypeListView) view.findViewById(R.id.listview_photo_album);
        this.icK = new e(this.mPageContext, this.icJ);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.icK.setDatas(dM(fVar.getPhotoAlbum()));
        }
    }

    private List<m> dM(List<m> list) {
        if (com.baidu.tbadk.core.util.v.Z(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.g(this.mPageContext.getPageActivity(), R.dimen.ds32), l.g(this.mPageContext.getPageActivity(), R.dimen.ds120));
            com.baidu.tbadk.core.util.v.a(arrayList, 0, dVar);
            com.baidu.tbadk.core.util.v.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void asn() {
        if (this.ccJ != TbadkCoreApplication.getInst().getSkinType()) {
            this.ccJ = TbadkCoreApplication.getInst().getSkinType();
            al.l(this.rootView, R.color.cp_bg_line_d);
            al.l(this.icI, R.color.cp_bg_line_c);
            al.f(this.bBh, R.color.cp_cont_d, 1);
            this.icK.notifyDataSetChanged();
        }
    }
}
