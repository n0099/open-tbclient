package com.baidu.tieba.write.view.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.d;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends a {
    private d jKr;
    private HorizontalListView jrI;
    private View mRootView;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.jKr.b(cVar);
    }

    public c(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.jrI = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.jKr = new d();
        this.jrI.setAdapter((ListAdapter) this.jKr);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        al.l(this.mRootView, R.color.cp_bg_line_d);
    }

    public void ex(List<String> list) {
        if (!v.aa(list)) {
            this.jKr.setData(list);
            this.jKr.notifyDataSetChanged();
        }
    }

    public void cym() {
        this.jKr.notifyDataSetChanged();
    }
}
