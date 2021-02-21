package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.a.f;
import com.baidu.tieba.person.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class PersonInfoUserPicsHolder extends TypeAdapter.ViewHolder {
    public int ajU;
    public TextView eHx;
    public View jTx;
    public TbPageContext mPageContext;
    public HTypeListView msW;
    public e msX;
    public View rootView;

    public PersonInfoUserPicsHolder(View view, TbPageContext tbPageContext) {
        super(view);
        this.ajU = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.jTx = view.findViewById(R.id.divider_view_under_photo_album);
        this.eHx = (TextView) view.findViewById(R.id.text_view_photo_album);
        this.msW = (HTypeListView) view.findViewById(R.id.listview_photo_album);
        this.msX = new e(this.mPageContext, this.msW);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.msX.setDatas(fs(fVar.getPhotoAlbum()));
        }
    }

    private List<n> fs(List<n> list) {
        if (y.getCount(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            d dVar = new d(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds120));
            y.add(arrayList, 0, dVar);
            y.add(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void dwx() {
        if (this.ajU != TbadkCoreApplication.getInst().getSkinType()) {
            this.ajU = TbadkCoreApplication.getInst().getSkinType();
            ap.setBackgroundColor(this.rootView, R.color.CAM_X0201);
            ap.setBackgroundColor(this.jTx, R.color.CAM_X0204);
            ap.setViewTextColor(this.eHx, R.color.CAM_X0109, 1);
            this.msX.notifyDataSetChanged();
        }
    }
}
