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
    private HTypeListView cWn;
    private c ici;
    private b icj;
    private a ick;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.cWn = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.ici = new c(this.mTbPageContext, m.Xk);
        this.icj = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.ics);
        this.ick = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.ibS);
        this.mAdapters.add(this.ici);
        this.mAdapters.add(this.icj);
        this.mAdapters.add(this.ick);
        this.cWn.addAdapters(this.mAdapters);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.cWn != null) {
            this.cWn.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.cWn != null && (this.cWn.getAdapter() instanceof v)) {
            ((v) this.cWn.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.ici.z(onClickListener);
        this.icj.z(onClickListener);
    }
}
