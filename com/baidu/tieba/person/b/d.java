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
/* loaded from: classes9.dex */
public class d extends v.a {
    public int MH;
    public TextView cGN;
    public View jft;
    public HTypeListView jfu;
    public e jfv;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.MH = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.jft = view.findViewById(R.id.divider_view_under_photo_album);
        this.cGN = (TextView) view.findViewById(R.id.text_view_photo_album);
        this.jfu = (HTypeListView) view.findViewById(R.id.listview_photo_album);
        this.jfv = new e(this.mPageContext, this.jfu);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.jfv.setDatas(dP(fVar.getPhotoAlbum()));
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

    public void ctF() {
        if (this.MH != TbadkCoreApplication.getInst().getSkinType()) {
            this.MH = TbadkCoreApplication.getInst().getSkinType();
            am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.jft, R.color.cp_bg_line_c);
            am.setViewTextColor(this.cGN, R.color.cp_cont_d, 1);
            this.jfv.notifyDataSetChanged();
        }
    }
}
