package com.baidu.tieba.pb.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.a.f;
/* loaded from: classes22.dex */
public class c {
    private EMTextView eOk;
    private BdTypeRecyclerView iYU;
    private LinearLayout kNb;
    private com.baidu.tieba.pb.pb.a.c lSU;
    private View mfh;
    private f mfi;

    public c(TbPageContext<?> tbPageContext) {
        init(tbPageContext.getPageActivity());
        this.lSU = new com.baidu.tieba.pb.pb.a.c(tbPageContext, this.iYU);
        this.mfi = new f(this.iYU, this.lSU);
        onChangeSkinType();
    }

    private void init(Context context) {
        this.kNb = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recom_thread_info_layout, (ViewGroup) null);
        this.eOk = (EMTextView) this.kNb.findViewById(R.id.tv_title);
        this.iYU = (BdTypeRecyclerView) this.kNb.findViewById(R.id.pb_recom_info_list);
        this.iYU.setLayoutManager(new LinearLayoutManager(context));
        this.iYU.setFadingEdgeLength(0);
        this.iYU.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.iYU.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.iYU.setNestedScrollingEnabled(false);
        this.mfh = new View(context);
    }

    public void H(com.baidu.tieba.pb.data.f fVar) {
        this.mfi.H(fVar);
    }

    public void HW(int i) {
        this.iYU.removeFooterView(this.mfh);
        this.mfh.setLayoutParams(new ViewGroup.LayoutParams(1, i));
        this.iYU.addFooterView(this.mfh);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.kNb, R.color.CAM_X0204);
        ap.setViewTextColor(this.eOk, R.color.CAM_X0105);
        this.lSU.onChangeSkinType();
    }

    public View getView() {
        return this.kNb;
    }

    public void setScrollable(boolean z) {
        this.iYU.setNestedScrollingEnabled(z);
    }
}
