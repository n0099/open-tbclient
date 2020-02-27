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
/* loaded from: classes13.dex */
public class c extends a {
    private d kRe;
    private HorizontalListView kyR;
    private View mRootView;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.kRe.b(cVar);
    }

    public c(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.kyR = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.kRe = new d();
        this.kyR.setAdapter((ListAdapter) this.kRe);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        bfK();
    }

    public void ez(List<String> list) {
        if (!v.isEmpty(list)) {
            this.kRe.setData(list);
            this.kRe.notifyDataSetChanged();
        }
    }

    public void bfK() {
        this.kRe.notifyDataSetChanged();
    }
}
