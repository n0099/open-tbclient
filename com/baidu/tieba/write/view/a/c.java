package com.baidu.tieba.write.view.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.d;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends a {
    private HorizontalListView lYO;
    private View mRootView;
    private d mrV;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.mrV.b(cVar);
    }

    public c(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.lYO = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.mrV = new d();
        this.lYO.setAdapter((ListAdapter) this.mrV);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        bxV();
    }

    public void fk(List<String> list) {
        if (!w.isEmpty(list)) {
            this.mrV.setData(list);
            this.mrV.notifyDataSetChanged();
        }
    }

    public void bxV() {
        this.mrV.notifyDataSetChanged();
    }
}
