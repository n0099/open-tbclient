package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ak {
    private List<com.baidu.adp.widget.ListView.a> bei = new ArrayList();
    private BaseFragmentActivity cSp;
    private d dyA;
    private HTypeListView dyy;
    private ai dyz;
    private BdUniqueId mId;

    public ak(BaseFragmentActivity baseFragmentActivity, HTypeListView hTypeListView) {
        this.cSp = baseFragmentActivity;
        this.dyy = hTypeListView;
        this.mId = baseFragmentActivity.getUniqueId();
        acu();
    }

    private void acu() {
        this.dyz = new ai(this.cSp, com.baidu.tbadk.data.i.aoj);
        this.dyA = new d(this.cSp, com.baidu.tieba.person.data.b.dzh);
        this.bei.add(this.dyz);
        this.bei.add(this.dyA);
        this.dyy.g(this.bei);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.v> list) {
        if (this.dyy != null) {
            this.dyy.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.dyy != null && (this.dyy.getAdapter() instanceof com.baidu.adp.widget.ListView.y)) {
            ((com.baidu.adp.widget.ListView.y) this.dyy.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.dyz.I(onClickListener);
        this.dyA.I(onClickListener);
    }
}
