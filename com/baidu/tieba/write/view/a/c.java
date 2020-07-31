package com.baidu.tieba.write.view.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.d;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends a {
    private View mRootView;
    private HorizontalListView mgi;
    private d mzY;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.mzY.b(cVar);
    }

    public c(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.mgi = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.mzY = new d();
        this.mgi.setAdapter((ListAdapter) this.mzY);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        bBl();
    }

    public void ft(List<String> list) {
        if (!x.isEmpty(list)) {
            this.mzY.setData(list);
            this.mzY.notifyDataSetChanged();
        }
    }

    public void bBl() {
        this.mzY.notifyDataSetChanged();
    }
}
