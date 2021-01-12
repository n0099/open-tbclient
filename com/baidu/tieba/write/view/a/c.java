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
/* loaded from: classes7.dex */
public class c extends a {
    private View mRootView;
    private HorizontalListView nEP;
    private f nXJ;

    public void a(e eVar) {
        this.nXJ.b(eVar);
    }

    public c(com.baidu.adp.base.f fVar) {
        super(fVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.nEP = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.nXJ = new f();
        this.nEP.setAdapter((ListAdapter) this.nXJ);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        bVw();
    }

    public void gk(List<String> list) {
        if (!x.isEmpty(list)) {
            this.nXJ.setData(list);
            this.nXJ.notifyDataSetChanged();
        }
    }

    public void bVw() {
        this.nXJ.notifyDataSetChanged();
    }
}
