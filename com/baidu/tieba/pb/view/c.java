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
    private BdTypeRecyclerView jmj;
    private LinearLayout kWf;
    private com.baidu.tieba.pb.pb.adapter.b mcH;
    private View moS;
    private g moT;

    public c(TbPageContext<?> tbPageContext) {
        init(tbPageContext.getPageActivity());
        this.mcH = new com.baidu.tieba.pb.pb.adapter.b(tbPageContext, this.jmj);
        this.moT = new g(this.jmj, this.mcH);
        onChangeSkinType();
    }

    private void init(Context context) {
        this.kWf = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recom_thread_info_layout, (ViewGroup) null);
        this.eVM = (EMTextView) this.kWf.findViewById(R.id.tv_title);
        this.jmj = (BdTypeRecyclerView) this.kWf.findViewById(R.id.pb_recom_info_list);
        this.jmj.setLayoutManager(new LinearLayoutManager(context));
        this.jmj.setFadingEdgeLength(0);
        this.jmj.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.jmj.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.jmj.setNestedScrollingEnabled(false);
        this.moS = new View(context);
    }

    public void H(f fVar) {
        this.moT.H(fVar);
    }

    public void GB(int i) {
        this.jmj.removeFooterView(this.moS);
        this.moS.setLayoutParams(new ViewGroup.LayoutParams(1, i));
        this.jmj.addFooterView(this.moS);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.kWf, R.color.CAM_X0204);
        ap.setViewTextColor(this.eVM, R.color.CAM_X0105);
        this.mcH.onChangeSkinType();
    }

    public View getView() {
        return this.kWf;
    }

    public void setScrollable(boolean z) {
        this.jmj.setNestedScrollingEnabled(z);
    }
}
