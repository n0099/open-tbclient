package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.o;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private TbPageContext mTbPageContext;
    private HTypeListView mnL;
    private c mnM;
    private b mnN;
    private a mnO;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.mnL = hTypeListView;
        MT();
    }

    private void MT() {
        this.mnM = new c(this.mTbPageContext, o.ahE);
        this.mnN = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.mnW);
        this.mnO = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.mnz);
        this.boM.add(this.mnM);
        this.boM.add(this.mnN);
        this.boM.add(this.mnO);
        this.mnL.addAdapters(this.boM);
    }

    public void setDatas(List<n> list) {
        if (this.mnL != null) {
            this.mnL.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.mnL != null && (this.mnL.getAdapter() instanceof TypeAdapter)) {
            ((TypeAdapter) this.mnL.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.mnM.H(onClickListener);
        this.mnN.H(onClickListener);
    }
}
