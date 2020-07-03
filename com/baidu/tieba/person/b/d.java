package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.a.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class d extends ad.a {
    public int ahx;
    public TextView dDu;
    public View kEY;
    public HTypeListView kEZ;
    public e kFa;
    public TbPageContext mPageContext;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.ahx = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.kEY = view.findViewById(R.id.divider_view_under_photo_album);
        this.dDu = (TextView) view.findViewById(R.id.text_view_photo_album);
        this.kEZ = (HTypeListView) view.findViewById(R.id.listview_photo_album);
        this.kFa = new e(this.mPageContext, this.kEZ);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.kFa.setDatas(es(fVar.getPhotoAlbum()));
        }
    }

    private List<q> es(List<q> list) {
        if (w.getCount(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds120));
            w.add(arrayList, 0, dVar);
            w.add(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void cRF() {
        if (this.ahx != TbadkCoreApplication.getInst().getSkinType()) {
            this.ahx = TbadkCoreApplication.getInst().getSkinType();
            an.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
            an.setBackgroundColor(this.kEY, R.color.cp_bg_line_c);
            an.setViewTextColor(this.dDu, R.color.cp_cont_d, 1);
            this.kFa.notifyDataSetChanged();
        }
    }
}
