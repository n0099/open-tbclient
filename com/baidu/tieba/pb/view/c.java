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
    private EMTextView eXl;
    private BdTypeRecyclerView joh;
    private LinearLayout kYv;
    private com.baidu.tieba.pb.pb.adapter.b meZ;
    private View mrj;
    private g mrk;

    public c(TbPageContext<?> tbPageContext) {
        init(tbPageContext.getPageActivity());
        this.meZ = new com.baidu.tieba.pb.pb.adapter.b(tbPageContext, this.joh);
        this.mrk = new g(this.joh, this.meZ);
        onChangeSkinType();
    }

    private void init(Context context) {
        this.kYv = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recom_thread_info_layout, (ViewGroup) null);
        this.eXl = (EMTextView) this.kYv.findViewById(R.id.tv_title);
        this.joh = (BdTypeRecyclerView) this.kYv.findViewById(R.id.pb_recom_info_list);
        this.joh.setLayoutManager(new LinearLayoutManager(context));
        this.joh.setFadingEdgeLength(0);
        this.joh.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.joh.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.joh.setNestedScrollingEnabled(false);
        this.mrj = new View(context);
    }

    public void H(f fVar) {
        this.mrk.H(fVar);
    }

    public void GE(int i) {
        this.joh.removeFooterView(this.mrj);
        this.mrj.setLayoutParams(new ViewGroup.LayoutParams(1, i));
        this.joh.addFooterView(this.mrj);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.kYv, R.color.CAM_X0204);
        ap.setViewTextColor(this.eXl, R.color.CAM_X0105);
        this.meZ.onChangeSkinType();
    }

    public View getView() {
        return this.kYv;
    }

    public void setScrollable(boolean z) {
        this.joh.setNestedScrollingEnabled(z);
    }
}
