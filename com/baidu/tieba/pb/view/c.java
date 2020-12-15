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
    private BdTypeRecyclerView iYW;
    private LinearLayout kNd;
    private com.baidu.tieba.pb.pb.a.c lSW;
    private View mfj;
    private f mfk;

    public c(TbPageContext<?> tbPageContext) {
        init(tbPageContext.getPageActivity());
        this.lSW = new com.baidu.tieba.pb.pb.a.c(tbPageContext, this.iYW);
        this.mfk = new f(this.iYW, this.lSW);
        onChangeSkinType();
    }

    private void init(Context context) {
        this.kNd = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recom_thread_info_layout, (ViewGroup) null);
        this.eOk = (EMTextView) this.kNd.findViewById(R.id.tv_title);
        this.iYW = (BdTypeRecyclerView) this.kNd.findViewById(R.id.pb_recom_info_list);
        this.iYW.setLayoutManager(new LinearLayoutManager(context));
        this.iYW.setFadingEdgeLength(0);
        this.iYW.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.iYW.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.iYW.setNestedScrollingEnabled(false);
        this.mfj = new View(context);
    }

    public void H(com.baidu.tieba.pb.data.f fVar) {
        this.mfk.H(fVar);
    }

    public void HW(int i) {
        this.iYW.removeFooterView(this.mfj);
        this.mfj.setLayoutParams(new ViewGroup.LayoutParams(1, i));
        this.iYW.addFooterView(this.mfj);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.kNd, R.color.CAM_X0204);
        ap.setViewTextColor(this.eOk, R.color.CAM_X0105);
        this.lSW.onChangeSkinType();
    }

    public View getView() {
        return this.kNd;
    }

    public void setScrollable(boolean z) {
        this.iYW.setNestedScrollingEnabled(z);
    }
}
