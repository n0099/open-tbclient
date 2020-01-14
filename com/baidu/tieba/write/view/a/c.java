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
/* loaded from: classes11.dex */
public class c extends a {
    private d kQy;
    private HorizontalListView kxW;
    private View mRootView;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.kQy.b(cVar);
    }

    public c(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.kxW = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.kQy = new d();
        this.kxW.setAdapter((ListAdapter) this.kQy);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        bdC();
    }

    public void eE(List<String> list) {
        if (!v.isEmpty(list)) {
            this.kQy.setData(list);
            this.kQy.notifyDataSetChanged();
        }
    }

    public void bdC() {
        this.kQy.notifyDataSetChanged();
    }
}
