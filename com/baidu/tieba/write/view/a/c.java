package com.baidu.tieba.write.view.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.d;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends a {
    private HorizontalListView iYL;
    private d jrn;
    private View mRootView;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.jrn.b(cVar);
    }

    public c(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.h.pic_sticker_view, (ViewGroup) null);
        this.iYL = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.jrn = new com.baidu.tieba.write.write.d();
        this.iYL.setAdapter((ListAdapter) this.jrn);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
    }

    public void en(List<String> list) {
        if (!v.T(list)) {
            this.jrn.setData(list);
            this.jrn.notifyDataSetChanged();
        }
    }

    public void cqf() {
        this.jrn.notifyDataSetChanged();
    }
}
