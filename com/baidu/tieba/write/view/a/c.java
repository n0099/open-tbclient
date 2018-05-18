package com.baidu.tieba.write.view.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.d;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends a {
    private HorizontalListView gPi;
    private d hgs;
    private View mRootView;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.hgs.b(cVar);
    }

    public c(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.i.pic_sticker_view, (ViewGroup) null);
        this.gPi = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.hgs = new com.baidu.tieba.write.write.d();
        this.gPi.setAdapter((ListAdapter) this.hgs);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        ak.j(this.mRootView, d.C0126d.cp_bg_line_d);
    }

    public void dN(List<String> list) {
        if (!v.w(list)) {
            this.hgs.setData(list);
            this.hgs.notifyDataSetChanged();
        }
    }

    public void bCJ() {
        this.hgs.notifyDataSetChanged();
    }
}
