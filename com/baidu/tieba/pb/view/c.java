package com.baidu.tieba.pb.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.a.f;
/* loaded from: classes2.dex */
public class c {
    private EMTextView eYh;
    private BdTypeRecyclerView jlj;
    private LinearLayout kSH;
    private com.baidu.tieba.pb.pb.adapter.b lYi;
    private View mkw;
    private f mkx;

    public c(TbPageContext<?> tbPageContext) {
        init(tbPageContext.getPageActivity());
        this.lYi = new com.baidu.tieba.pb.pb.adapter.b(tbPageContext, this.jlj);
        this.mkx = new f(this.jlj, this.lYi);
        onChangeSkinType();
    }

    private void init(Context context) {
        this.kSH = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recom_thread_info_layout, (ViewGroup) null);
        this.eYh = (EMTextView) this.kSH.findViewById(R.id.tv_title);
        this.jlj = (BdTypeRecyclerView) this.kSH.findViewById(R.id.pb_recom_info_list);
        this.jlj.setLayoutManager(new LinearLayoutManager(context));
        this.jlj.setFadingEdgeLength(0);
        this.jlj.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.jlj.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.jlj.setNestedScrollingEnabled(false);
        this.mkw = new View(context);
    }

    public void H(com.baidu.tieba.pb.data.f fVar) {
        this.mkx.H(fVar);
    }

    public void HP(int i) {
        this.jlj.removeFooterView(this.mkw);
        this.mkw.setLayoutParams(new ViewGroup.LayoutParams(1, i));
        this.jlj.addFooterView(this.mkw);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.kSH, R.color.CAM_X0204);
        ao.setViewTextColor(this.eYh, R.color.CAM_X0105);
        this.lYi.onChangeSkinType();
    }

    public View getView() {
        return this.kSH;
    }

    public void setScrollable(boolean z) {
        this.jlj.setNestedScrollingEnabled(z);
    }
}
