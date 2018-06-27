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
    private HorizontalListView heP;
    private d hww;
    private View mRootView;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.hww.b(cVar);
    }

    public c(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.i.pic_sticker_view, (ViewGroup) null);
        this.heP = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.hww = new com.baidu.tieba.write.write.d();
        this.heP.setAdapter((ListAdapter) this.hww);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        am.j(this.mRootView, d.C0142d.cp_bg_line_d);
    }

    public void dW(List<String> list) {
        if (!w.A(list)) {
            this.hww.setData(list);
            this.hww.notifyDataSetChanged();
        }
    }

    public void bIp() {
        this.hww.notifyDataSetChanged();
    }
}
