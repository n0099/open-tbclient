package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.m;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class e {
    private HTypeListView cWm;
    private c icf;
    private b icg;
    private a ich;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.cWm = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.icf = new c(this.mTbPageContext, m.Xk);
        this.icg = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.icp);
        this.ich = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.ibP);
        this.mAdapters.add(this.icf);
        this.mAdapters.add(this.icg);
        this.mAdapters.add(this.ich);
        this.cWm.addAdapters(this.mAdapters);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.cWm != null) {
            this.cWm.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.cWm != null && (this.cWm.getAdapter() instanceof v)) {
            ((v) this.cWm.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.icf.z(onClickListener);
        this.icg.z(onClickListener);
    }
}
