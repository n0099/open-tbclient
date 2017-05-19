package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.j;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private HTypeListView buC;
    private b exQ;
    private a exR;
    private com.baidu.tieba.personCenter.a.b exS;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;

    public d(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.buC = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        initAdapters();
    }

    private void initAdapters() {
        this.exQ = new b(this.mTbPageContext, j.axU);
        this.exR = new a(this.mTbPageContext, com.baidu.tieba.person.data.a.exU);
        this.exS = new com.baidu.tieba.personCenter.a.b(this.mTbPageContext.getPageActivity(), com.baidu.tieba.personCenter.b.b.eyF);
        this.mAdapters.add(this.exQ);
        this.mAdapters.add(this.exR);
        this.mAdapters.add(this.exS);
        this.buC.addAdapters(this.mAdapters);
    }

    public void setDatas(List<v> list) {
        if (this.buC != null) {
            this.buC.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.buC != null && (this.buC.getAdapter() instanceof y)) {
            ((y) this.buC.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.exQ.u(onClickListener);
        this.exR.u(onClickListener);
    }
}
