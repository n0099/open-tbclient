package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.a.f;
import com.baidu.tieba.person.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class PersonInfoUserPicsHolder extends TypeAdapter.ViewHolder {
    public int akW;
    public TextView eKc;
    public View jQM;
    public TbPageContext mPageContext;
    public HTypeListView mok;
    public e mol;
    public View rootView;

    public PersonInfoUserPicsHolder(View view, TbPageContext tbPageContext) {
        super(view);
        this.akW = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.jQM = view.findViewById(R.id.divider_view_under_photo_album);
        this.eKc = (TextView) view.findViewById(R.id.text_view_photo_album);
        this.mok = (HTypeListView) view.findViewById(R.id.listview_photo_album);
        this.mol = new e(this.mPageContext, this.mok);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.mol.setDatas(fu(fVar.getPhotoAlbum()));
        }
    }

    private List<n> fu(List<n> list) {
        if (x.getCount(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            d dVar = new d(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds120));
            x.add(arrayList, 0, dVar);
            x.add(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    public void dxY() {
        if (this.akW != TbadkCoreApplication.getInst().getSkinType()) {
            this.akW = TbadkCoreApplication.getInst().getSkinType();
            ao.setBackgroundColor(this.rootView, R.color.CAM_X0201);
            ao.setBackgroundColor(this.jQM, R.color.CAM_X0204);
            ao.setViewTextColor(this.eKc, R.color.CAM_X0109, 1);
            this.mol.notifyDataSetChanged();
        }
    }
}
