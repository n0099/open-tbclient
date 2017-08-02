package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.k;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private HTypeListView aXy;
    private b fcX;
    private a fcY;
    private com.baidu.tieba.personCenter.a.b fcZ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;

    public d(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.aXy = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        initAdapters();
    }

    private void initAdapters() {
        this.fcX = new b(this.mTbPageContext, k.azI);
        this.fcY = new a(this.mTbPageContext, com.baidu.tieba.person.data.a.fdb);
        this.fcZ = new com.baidu.tieba.personCenter.a.b(this.mTbPageContext.getPageActivity(), h.fcH);
        this.mAdapters.add(this.fcX);
        this.mAdapters.add(this.fcY);
        this.mAdapters.add(this.fcZ);
        this.aXy.addAdapters(this.mAdapters);
    }

    public void setDatas(List<f> list) {
        if (this.aXy != null) {
            this.aXy.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.aXy != null && (this.aXy.getAdapter() instanceof j)) {
            ((j) this.aXy.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.fcX.t(onClickListener);
        this.fcY.t(onClickListener);
    }
}
