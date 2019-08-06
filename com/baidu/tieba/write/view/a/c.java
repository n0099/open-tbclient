package com.baidu.tieba.write.view.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.d;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends a {
    private d jSB;
    private HorizontalListView jza;
    private View mRootView;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.jSB.b(cVar);
    }

    public c(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.jza = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.jSB = new d();
        this.jza.setAdapter((ListAdapter) this.jSB);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        am.l(this.mRootView, R.color.cp_bg_line_d);
    }

    public void ez(List<String> list) {
        if (!v.aa(list)) {
            this.jSB.setData(list);
            this.jSB.notifyDataSetChanged();
        }
    }

    public void cBE() {
        this.jSB.notifyDataSetChanged();
    }
}
