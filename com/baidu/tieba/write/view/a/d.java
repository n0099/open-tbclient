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
    private com.baidu.tieba.write.write.d hGN;
    private HorizontalListView hqH;
    private View mRootView;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.hGN.b(cVar);
    }

    public d(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.bYg.getPageActivity()).inflate(d.h.pic_sticker_view, (ViewGroup) null);
        this.hqH = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.hGN = new com.baidu.tieba.write.write.d();
        this.hqH.setAdapter((ListAdapter) this.hGN);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        aj.t(this.mRootView, d.C0107d.cp_bg_line_d);
    }

    public void dN(List<String> list) {
        if (!v.E(list)) {
            this.hGN.setData(list);
            this.hGN.notifyDataSetChanged();
        }
    }

    public void bGF() {
        this.hGN.notifyDataSetChanged();
    }
}
