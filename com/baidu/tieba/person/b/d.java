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
    public int aku;
    public TextView eAz;
    public View jQN;
    public TbPageContext mPageContext;
    public HTypeListView mjc;
    public e mjd;
    public View rootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.aku = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.jQN = view.findViewById(R.id.divider_view_under_photo_album);
        this.eAz = (TextView) view.findViewById(R.id.text_view_photo_album);
        this.mjc = (HTypeListView) view.findViewById(R.id.listview_photo_album);
        this.mjd = new e(this.mPageContext, this.mjc);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.mjd.setDatas(fu(fVar.getPhotoAlbum()));
        }
    }

    private List<q> fu(List<q> list) {
        if (y.getCount(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds120));
            y.add(arrayList, 0, dVar);
            y.add(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void dyj() {
        if (this.aku != TbadkCoreApplication.getInst().getSkinType()) {
            this.aku = TbadkCoreApplication.getInst().getSkinType();
            ap.setBackgroundColor(this.rootView, R.color.CAM_X0201);
            ap.setBackgroundColor(this.jQN, R.color.CAM_X0204);
            ap.setViewTextColor(this.eAz, R.color.CAM_X0109, 1);
            this.mjd.notifyDataSetChanged();
        }
    }
}
