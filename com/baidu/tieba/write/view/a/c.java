package com.baidu.tieba.write.view.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.e;
import com.baidu.tieba.write.write.d;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends a {
    private d hOZ;
    private HorizontalListView hwU;
    private View mRootView;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.hOZ.b(cVar);
    }

    public c(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(e.h.pic_sticker_view, (ViewGroup) null);
        this.hwU = (HorizontalListView) this.mRootView.findViewById(e.g.horizontal_list);
        this.hOZ = new d();
        this.hwU.setAdapter((ListAdapter) this.hOZ);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        al.j(this.mRootView, e.d.cp_bg_line_d);
    }

    public void ef(List<String> list) {
        if (!v.I(list)) {
            this.hOZ.setData(list);
            this.hOZ.notifyDataSetChanged();
        }
    }

    public void bMG() {
        this.hOZ.notifyDataSetChanged();
    }
}
