package com.baidu.tieba.write.view.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends a {
    private com.baidu.tieba.write.write.d hID;
    private HorizontalListView hsq;
    private View mRootView;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.hID.b(cVar);
    }

    public d(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.h.pic_sticker_view, (ViewGroup) null);
        this.hsq = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.hID = new com.baidu.tieba.write.write.d();
        this.hsq.setAdapter((ListAdapter) this.hID);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        aj.t(this.mRootView, d.C0140d.cp_bg_line_d);
    }

    public void dT(List<String> list) {
        if (!v.E(list)) {
            this.hID.setData(list);
            this.hID.notifyDataSetChanged();
        }
    }

    public void bHv() {
        this.hID.notifyDataSetChanged();
    }
}
