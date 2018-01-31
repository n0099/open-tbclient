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
    private com.baidu.tieba.write.write.d hHh;
    private HorizontalListView hrb;
    private View mRootView;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.hHh.b(cVar);
    }

    public d(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.bYo.getPageActivity()).inflate(d.h.pic_sticker_view, (ViewGroup) null);
        this.hrb = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.hHh = new com.baidu.tieba.write.write.d();
        this.hrb.setAdapter((ListAdapter) this.hHh);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        aj.t(this.mRootView, d.C0108d.cp_bg_line_d);
    }

    public void dN(List<String> list) {
        if (!v.E(list)) {
            this.hHh.setData(list);
            this.hHh.notifyDataSetChanged();
        }
    }

    public void bGH() {
        this.hHh.notifyDataSetChanged();
    }
}
