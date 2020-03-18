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
/* loaded from: classes13.dex */
public class c extends a {
    private HorizontalListView kAM;
    private d kSV;
    private View mRootView;

    public void a(com.baidu.tieba.write.write.c cVar) {
        this.kSV.b(cVar);
    }

    public c(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_sticker_view, (ViewGroup) null);
        this.kAM = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.kSV = new d();
        this.kAM.setAdapter((ListAdapter) this.kSV);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        bfS();
    }

    public void ez(List<String> list) {
        if (!v.isEmpty(list)) {
            this.kSV.setData(list);
            this.kSV.notifyDataSetChanged();
        }
    }

    public void bfS() {
        this.kSV.notifyDataSetChanged();
    }
}
