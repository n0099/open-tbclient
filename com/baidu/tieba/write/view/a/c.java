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
    private HorizontalListView mHY;
    private View mRootView;
    private f ncC;

    public void a(e eVar) {
        this.ncC.b(eVar);
    }

    public c(com.baidu.adp.base.e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.mHY = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.ncC = new f();
        this.mHY.setAdapter((ListAdapter) this.ncC);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        bLQ();
    }

    public void fK(List<String> list) {
        if (!y.isEmpty(list)) {
            this.ncC.setData(list);
            this.ncC.notifyDataSetChanged();
        }
    }

    public void bLQ() {
        this.ncC.notifyDataSetChanged();
    }
}
