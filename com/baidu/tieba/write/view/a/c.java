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
    private HorizontalListView mXJ;
    private f nsb;

    public void a(e eVar) {
        this.nsb.b(eVar);
    }

    public c(com.baidu.adp.base.e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.mXJ = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.nsb = new f();
        this.mXJ.setAdapter((ListAdapter) this.nsb);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        bOA();
    }

    public void fN(List<String> list) {
        if (!y.isEmpty(list)) {
            this.nsb.setData(list);
            this.nsb.notifyDataSetChanged();
        }
    }

    public void bOA() {
        this.nsb.notifyDataSetChanged();
    }
}
