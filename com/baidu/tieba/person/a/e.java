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
    private HTypeListView cXR;
    private c ijD;
    private b ijE;
    private a ijF;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.cXR = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.ijD = new c(this.mTbPageContext, m.XE);
        this.ijE = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.ijN);
        this.ijF = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.ijn);
        this.mAdapters.add(this.ijD);
        this.mAdapters.add(this.ijE);
        this.mAdapters.add(this.ijF);
        this.cXR.addAdapters(this.mAdapters);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.cXR != null) {
            this.cXR.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.cXR != null && (this.cXR.getAdapter() instanceof v)) {
            ((v) this.cXR.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.ijD.B(onClickListener);
        this.ijE.B(onClickListener);
    }
}
