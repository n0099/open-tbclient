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
    private f nLV;
    private HorizontalListView nrn;

    public void a(e eVar) {
        this.nLV.b(eVar);
    }

    public c(com.baidu.adp.base.e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.nrn = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.nLV = new f();
        this.nrn.setAdapter((ListAdapter) this.nLV);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        bSX();
    }

    public void gd(List<String> list) {
        if (!y.isEmpty(list)) {
            this.nLV.setData(list);
            this.nLV.notifyDataSetChanged();
        }
    }

    public void bSX() {
        this.nLV.notifyDataSetChanged();
    }
}
