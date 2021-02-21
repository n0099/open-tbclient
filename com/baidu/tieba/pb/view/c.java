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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.a.g;
/* loaded from: classes2.dex */
public class c {
    private EMTextView eVM;
    private BdTypeRecyclerView jmy;
    private LinearLayout kWt;
    private com.baidu.tieba.pb.pb.adapter.b mcW;
    private View mph;
    private g mpi;

    public c(TbPageContext<?> tbPageContext) {
        init(tbPageContext.getPageActivity());
        this.mcW = new com.baidu.tieba.pb.pb.adapter.b(tbPageContext, this.jmy);
        this.mpi = new g(this.jmy, this.mcW);
        onChangeSkinType();
    }

    private void init(Context context) {
        this.kWt = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recom_thread_info_layout, (ViewGroup) null);
        this.eVM = (EMTextView) this.kWt.findViewById(R.id.tv_title);
        this.jmy = (BdTypeRecyclerView) this.kWt.findViewById(R.id.pb_recom_info_list);
        this.jmy.setLayoutManager(new LinearLayoutManager(context));
        this.jmy.setFadingEdgeLength(0);
        this.jmy.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.jmy.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.jmy.setNestedScrollingEnabled(false);
        this.mph = new View(context);
    }

    public void H(f fVar) {
        this.mpi.H(fVar);
    }

    public void GB(int i) {
        this.jmy.removeFooterView(this.mph);
        this.mph.setLayoutParams(new ViewGroup.LayoutParams(1, i));
        this.jmy.addFooterView(this.mph);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.kWt, R.color.CAM_X0204);
        ap.setViewTextColor(this.eVM, R.color.CAM_X0105);
        this.mcW.onChangeSkinType();
    }

    public View getView() {
        return this.kWt;
    }

    public void setScrollable(boolean z) {
        this.jmy.setNestedScrollingEnabled(z);
    }
}
