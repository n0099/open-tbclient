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
/* loaded from: classes8.dex */
public class c extends a {
    private View mRootView;
    private HorizontalListView nPa;
    private f oiq;

    public void a(e eVar) {
        this.oiq.b(eVar);
    }

    public c(com.baidu.adp.base.f fVar) {
        super(fVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.nPa = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.oiq = new f();
        this.nPa.setAdapter((ListAdapter) this.oiq);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        bWh();
    }

    public void gi(List<String> list) {
        if (!y.isEmpty(list)) {
            this.oiq.setData(list);
            this.oiq.notifyDataSetChanged();
        }
    }

    public void bWh() {
        this.oiq.notifyDataSetChanged();
    }
}
