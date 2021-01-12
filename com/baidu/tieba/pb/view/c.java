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
    private EMTextView eTw;
    private BdTypeRecyclerView jgC;
    private LinearLayout kOc;
    private com.baidu.tieba.pb.pb.adapter.b lTD;
    private View mfP;
    private f mfQ;

    public c(TbPageContext<?> tbPageContext) {
        init(tbPageContext.getPageActivity());
        this.lTD = new com.baidu.tieba.pb.pb.adapter.b(tbPageContext, this.jgC);
        this.mfQ = new f(this.jgC, this.lTD);
        onChangeSkinType();
    }

    private void init(Context context) {
        this.kOc = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recom_thread_info_layout, (ViewGroup) null);
        this.eTw = (EMTextView) this.kOc.findViewById(R.id.tv_title);
        this.jgC = (BdTypeRecyclerView) this.kOc.findViewById(R.id.pb_recom_info_list);
        this.jgC.setLayoutManager(new LinearLayoutManager(context));
        this.jgC.setFadingEdgeLength(0);
        this.jgC.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.jgC.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.jgC.setNestedScrollingEnabled(false);
        this.mfP = new View(context);
    }

    public void H(com.baidu.tieba.pb.data.f fVar) {
        this.mfQ.H(fVar);
    }

    public void Gj(int i) {
        this.jgC.removeFooterView(this.mfP);
        this.mfP.setLayoutParams(new ViewGroup.LayoutParams(1, i));
        this.jgC.addFooterView(this.mfP);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.kOc, R.color.CAM_X0204);
        ao.setViewTextColor(this.eTw, R.color.CAM_X0105);
        this.lTD.onChangeSkinType();
    }

    public View getView() {
        return this.kOc;
    }

    public void setScrollable(boolean z) {
        this.jgC.setNestedScrollingEnabled(z);
    }
}
