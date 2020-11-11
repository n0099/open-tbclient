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
    private f nKu;
    private HorizontalListView nqg;

    public void a(e eVar) {
        this.nKu.b(eVar);
    }

    public c(com.baidu.adp.base.e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.nqg = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.nKu = new f();
        this.nqg.setAdapter((ListAdapter) this.nKu);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        bTE();
    }

    public void gd(List<String> list) {
        if (!y.isEmpty(list)) {
            this.nKu.setData(list);
            this.nKu.notifyDataSetChanged();
        }
    }

    public void bTE() {
        this.nKu.notifyDataSetChanged();
    }
}
