package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.a.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class d extends af.a {
    public int ajq;
    public TextView epn;
    public View jvk;
    public HTypeListView lOF;
    public e lOG;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.ajq = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.jvk = view.findViewById(R.id.divider_view_under_photo_album);
        this.epn = (TextView) view.findViewById(R.id.text_view_photo_album);
        this.lOF = (HTypeListView) view.findViewById(R.id.listview_photo_album);
        this.lOG = new e(this.mPageContext, this.lOF);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.lOG.setDatas(fa(fVar.getPhotoAlbum()));
        }
    }

    private List<q> fa(List<q> list) {
        if (y.getCount(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds120));
            y.add(arrayList, 0, dVar);
            y.add(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void dqO() {
        if (this.ajq != TbadkCoreApplication.getInst().getSkinType()) {
            this.ajq = TbadkCoreApplication.getInst().getSkinType();
            ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.jvk, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.epn, R.color.cp_cont_d, 1);
            this.lOG.notifyDataSetChanged();
        }
    }
}
