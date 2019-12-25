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
/* loaded from: classes10.dex */
public class c extends a {
    private d kMS;
    private HorizontalListView kuo;
    private View mRootView;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.kMS.b(cVar);
    }

    public c(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.kuo = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.kMS = new d();
        this.kuo.setAdapter((ListAdapter) this.kMS);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        bdh();
    }

    public void eE(List<String> list) {
        if (!v.isEmpty(list)) {
            this.kMS.setData(list);
            this.kMS.notifyDataSetChanged();
        }
    }

    public void bdh() {
        this.kMS.notifyDataSetChanged();
    }
}
