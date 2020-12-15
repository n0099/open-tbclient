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
    private HorizontalListView nFq;
    private f oad;

    public void a(e eVar) {
        this.oad.b(eVar);
    }

    public c(com.baidu.adp.base.e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.nFq = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.oad = new f();
        this.nFq.setAdapter((ListAdapter) this.oad);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        bWI();
    }

    public void gr(List<String> list) {
        if (!y.isEmpty(list)) {
            this.oad.setData(list);
            this.oad.notifyDataSetChanged();
        }
    }

    public void bWI() {
        this.oad.notifyDataSetChanged();
    }
}
