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
    private com.baidu.tieba.write.write.d hIq;
    private HorizontalListView hsd;
    private View mRootView;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.hIq.b(cVar);
    }

    public d(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.h.pic_sticker_view, (ViewGroup) null);
        this.hsd = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.hIq = new com.baidu.tieba.write.write.d();
        this.hsd.setAdapter((ListAdapter) this.hIq);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        aj.t(this.mRootView, d.C0141d.cp_bg_line_d);
    }

    public void dT(List<String> list) {
        if (!v.E(list)) {
            this.hIq.setData(list);
            this.hIq.notifyDataSetChanged();
        }
    }

    public void bHu() {
        this.hIq.notifyDataSetChanged();
    }
}
