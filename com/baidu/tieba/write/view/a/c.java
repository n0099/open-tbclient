package com.baidu.tieba.write.view.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.e;
import com.baidu.tieba.write.write.f;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends a {
    private View mRootView;
    private HorizontalListView nJv;
    private f ocq;

    public void a(e eVar) {
        this.ocq.b(eVar);
    }

    public c(com.baidu.adp.base.f fVar) {
        super(fVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.nJv = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.ocq = new f();
        this.nJv.setAdapter((ListAdapter) this.ocq);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        bZn();
    }

    public void gk(List<String> list) {
        if (!x.isEmpty(list)) {
            this.ocq.setData(list);
            this.ocq.notifyDataSetChanged();
        }
    }

    public void bZn() {
        this.ocq.notifyDataSetChanged();
    }
}
