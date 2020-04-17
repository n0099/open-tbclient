package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.y;
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
public class d extends y.a {
    public int afT;
    public TextView dkk;
    public View jSk;
    public HTypeListView jSl;
    public e jSm;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.afT = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.jSk = view.findViewById(R.id.divider_view_under_photo_album);
        this.dkk = (TextView) view.findViewById(R.id.text_view_photo_album);
        this.jSl = (HTypeListView) view.findViewById(R.id.listview_photo_album);
        this.jSm = new e(this.mPageContext, this.jSl);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.jSm.setDatas(dW(fVar.getPhotoAlbum()));
        }
    }

    private List<m> dW(List<m> list) {
        if (v.getCount(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds120));
            v.add(arrayList, 0, dVar);
            v.add(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void cGb() {
        if (this.afT != TbadkCoreApplication.getInst().getSkinType()) {
            this.afT = TbadkCoreApplication.getInst().getSkinType();
            am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.jSk, R.color.cp_bg_line_c);
            am.setViewTextColor(this.dkk, R.color.cp_cont_d, 1);
            this.jSm.notifyDataSetChanged();
        }
    }
}
