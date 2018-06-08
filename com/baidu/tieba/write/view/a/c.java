package com.baidu.tieba.write.view.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.d;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends a {
    private HorizontalListView haK;
    private d hsn;
    private View mRootView;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.hsn.b(cVar);
    }

    public c(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.i.pic_sticker_view, (ViewGroup) null);
        this.haK = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.hsn = new com.baidu.tieba.write.write.d();
        this.haK.setAdapter((ListAdapter) this.hsn);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        al.j(this.mRootView, d.C0141d.cp_bg_line_d);
    }

    public void dT(List<String> list) {
        if (!w.z(list)) {
            this.hsn.setData(list);
            this.hsn.notifyDataSetChanged();
        }
    }

    public void bHO() {
        this.hsn.notifyDataSetChanged();
    }
}
