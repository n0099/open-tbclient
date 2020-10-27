package com.baidu.tieba.write.view.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.e;
import com.baidu.tieba.write.write.f;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends a {
    private View mRootView;
    private f nEA;
    private HorizontalListView nkj;

    public void a(e eVar) {
        this.nEA.b(eVar);
    }

    public c(com.baidu.adp.base.e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.nkj = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.nEA = new f();
        this.nkj.setAdapter((ListAdapter) this.nEA);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        bRf();
    }

    public void fV(List<String> list) {
        if (!y.isEmpty(list)) {
            this.nEA.setData(list);
            this.nEA.notifyDataSetChanged();
        }
    }

    public void bRf() {
        this.nEA.notifyDataSetChanged();
    }
}
