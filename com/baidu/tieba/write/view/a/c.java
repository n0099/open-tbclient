package com.baidu.tieba.write.view.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.f;
import com.baidu.tieba.write.write.d;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends a {
    private HorizontalListView hgf;
    private d hxF;
    private View mRootView;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.hxF.b(cVar);
    }

    public c(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(f.h.pic_sticker_view, (ViewGroup) null);
        this.hgf = (HorizontalListView) this.mRootView.findViewById(f.g.horizontal_list);
        this.hxF = new d();
        this.hgf.setAdapter((ListAdapter) this.hxF);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        am.j(this.mRootView, f.d.cp_bg_line_d);
    }

    public void dS(List<String> list) {
        if (!w.z(list)) {
            this.hxF.setData(list);
            this.hxF.notifyDataSetChanged();
        }
    }

    public void bHe() {
        this.hxF.notifyDataSetChanged();
    }
}
