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
    private d kQt;
    private HorizontalListView kxR;
    private View mRootView;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.kQt.b(cVar);
    }

    public c(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.kxR = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.kQt = new d();
        this.kxR.setAdapter((ListAdapter) this.kQt);
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
            this.kQt.setData(list);
            this.kQt.notifyDataSetChanged();
        }
    }

    public void bdC() {
        this.kQt.notifyDataSetChanged();
    }
}
