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
    private HorizontalListView gRm;
    private com.baidu.tieba.write.write.d hgf;
    private View mRootView;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.hgf.b(cVar);
    }

    public d(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.bkJ.getPageActivity()).inflate(d.h.pic_sticker_view, (ViewGroup) null);
        this.gRm = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.hgf = new com.baidu.tieba.write.write.d();
        this.gRm.setAdapter((ListAdapter) this.hgf);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        aj.k(this.mRootView, d.C0082d.cp_bg_line_d);
    }

    public void dZ(List<String> list) {
        if (!v.w(list)) {
            this.hgf.setData(list);
            this.hgf.notifyDataSetChanged();
        }
    }

    public void bGF() {
        this.hgf.notifyDataSetChanged();
    }
}
