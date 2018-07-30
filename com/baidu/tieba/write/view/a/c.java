package com.baidu.tieba.write.view.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.d;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends a {
    private HorizontalListView hge;
    private d hxD;
    private View mRootView;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.hxD.b(cVar);
    }

    public c(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.h.pic_sticker_view, (ViewGroup) null);
        this.hge = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.hxD = new com.baidu.tieba.write.write.d();
        this.hge.setAdapter((ListAdapter) this.hxD);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        am.j(this.mRootView, d.C0140d.cp_bg_line_d);
    }

    public void dS(List<String> list) {
        if (!w.z(list)) {
            this.hxD.setData(list);
            this.hxD.notifyDataSetChanged();
        }
    }

    public void bHa() {
        this.hxD.notifyDataSetChanged();
    }
}
