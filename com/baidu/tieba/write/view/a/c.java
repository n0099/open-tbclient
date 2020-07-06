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
    private HorizontalListView lYR;
    private View mRootView;
    private d mrY;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.mrY.b(cVar);
    }

    public c(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.lYR = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.mrY = new d();
        this.lYR.setAdapter((ListAdapter) this.mrY);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        bxW();
    }

    public void fk(List<String> list) {
        if (!w.isEmpty(list)) {
            this.mrY.setData(list);
            this.mrY.notifyDataSetChanged();
        }
    }

    public void bxW() {
        this.mrY.notifyDataSetChanged();
    }
}
