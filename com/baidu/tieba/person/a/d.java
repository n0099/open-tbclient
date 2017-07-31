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
    private HTypeListView aYJ;
    private b fej;
    private a fek;
    private com.baidu.tieba.personCenter.a.b fel;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;

    public d(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.aYJ = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        initAdapters();
    }

    private void initAdapters() {
        this.fej = new b(this.mTbPageContext, k.aAZ);
        this.fek = new a(this.mTbPageContext, com.baidu.tieba.person.data.a.fen);
        this.fel = new com.baidu.tieba.personCenter.a.b(this.mTbPageContext.getPageActivity(), h.fdT);
        this.mAdapters.add(this.fej);
        this.mAdapters.add(this.fek);
        this.mAdapters.add(this.fel);
        this.aYJ.addAdapters(this.mAdapters);
    }

    public void setDatas(List<f> list) {
        if (this.aYJ != null) {
            this.aYJ.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.aYJ != null && (this.aYJ.getAdapter() instanceof j)) {
            ((j) this.aYJ.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.fej.t(onClickListener);
        this.fek.t(onClickListener);
    }
}
