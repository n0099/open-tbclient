package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private HTypeListView blB;
    private d exU;
    private a exV;
    private com.baidu.tieba.personCenter.a.b exW;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;

    public f(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.blB = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        initAdapters();
    }

    private void initAdapters() {
        this.exU = new d(this.mTbPageContext, com.baidu.tbadk.data.k.ask);
        this.exV = new a(this.mTbPageContext, com.baidu.tieba.person.data.a.eyg);
        this.exW = new com.baidu.tieba.personCenter.a.b(this.mTbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.ezv);
        this.mAdapters.add(this.exU);
        this.mAdapters.add(this.exV);
        this.mAdapters.add(this.exW);
        this.blB.addAdapters(this.mAdapters);
    }

    public void setDatas(List<v> list) {
        if (this.blB != null) {
            this.blB.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.blB != null && (this.blB.getAdapter() instanceof y)) {
            ((y) this.blB.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.exU.w(onClickListener);
        this.exV.w(onClickListener);
    }
}
