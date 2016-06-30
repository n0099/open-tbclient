package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ak {
    private List<com.baidu.adp.widget.ListView.a> bAz = new ArrayList();
    private BaseFragmentActivity bfw;
    private HTypeListView egU;
    private ai egV;
    private c egW;
    private BdUniqueId mId;

    public ak(BaseFragmentActivity baseFragmentActivity, HTypeListView hTypeListView) {
        this.bfw = baseFragmentActivity;
        this.egU = hTypeListView;
        this.mId = baseFragmentActivity.getUniqueId();
        akG();
    }

    private void akG() {
        this.egV = new ai(this.bfw, com.baidu.tbadk.data.k.aoZ);
        this.egW = new c(this.bfw, com.baidu.tieba.person.data.b.ehL);
        this.bAz.add(this.egV);
        this.bAz.add(this.egW);
        this.egU.g(this.bAz);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.v> list) {
        if (this.egU != null) {
            this.egU.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.egU != null && (this.egU.getAdapter() instanceof com.baidu.adp.widget.ListView.y)) {
            ((com.baidu.adp.widget.ListView.y) this.egU.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.egV.I(onClickListener);
        this.egW.I(onClickListener);
    }
}
