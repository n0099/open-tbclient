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
    private HTypeListView cWo;
    private c icj;
    private b ick;
    private a icl;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.cWo = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.icj = new c(this.mTbPageContext, m.Xj);
        this.ick = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.ict);
        this.icl = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.ibT);
        this.mAdapters.add(this.icj);
        this.mAdapters.add(this.ick);
        this.mAdapters.add(this.icl);
        this.cWo.addAdapters(this.mAdapters);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.cWo != null) {
            this.cWo.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.cWo != null && (this.cWo.getAdapter() instanceof v)) {
            ((v) this.cWo.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.icj.z(onClickListener);
        this.ick.z(onClickListener);
    }
}
