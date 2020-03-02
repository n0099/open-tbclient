package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a {
    private com.baidu.tieba.pb.a.c dqK;
    private PbFragment iNC;
    private View iQz = null;
    private View iQA = null;
    private TextView iQB = null;
    private View iQC = null;
    private View iQD = null;
    private View iQE = null;
    private Button iOv = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.iNC = pbFragment;
        this.dqK = cVar;
        initView();
    }

    private void initView() {
        this.iQz = LayoutInflater.from(this.iNC.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.iQz.setOnTouchListener(this.dqK);
        this.iQA = this.iQz.findViewById(R.id.pb_head_activity_join_number_container);
        this.iQA.setVisibility(8);
        this.iQB = (TextView) this.iQz.findViewById(R.id.pb_head_activity_join_number);
        this.iQC = this.iQz.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.iQD = this.iQz.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.iQz.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean qy(boolean z) {
        boolean z2;
        if (this.iOv != null && this.iOv.getVisibility() == 0) {
            if (this.iQC != null) {
                this.iQC.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.iQC != null) {
                this.iQC.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.iQE == null || this.iQE.getVisibility() == 8) && z2 && z) {
            this.iQD.setVisibility(0);
        } else {
            this.iQD.setVisibility(8);
        }
        return z2;
    }

    public void e(com.baidu.tieba.pb.data.e eVar, boolean z) {
        boolean qy = qy(z);
        if (eVar != null && eVar.getPage() != null && eVar.getPage().aBl() == 0 && z) {
            if (qy) {
                this.iQD.setVisibility(0);
                return;
            } else {
                this.iQD.setVisibility(8);
                return;
            }
        }
        this.iQD.setVisibility(8);
    }

    public void v(com.baidu.tieba.pb.data.e eVar) {
        ArrayList<com.baidu.tbadk.core.data.b> aCz = eVar.cku().aCz();
        if (aCz != null && aCz.size() > 0) {
            this.iQB.setText(String.valueOf(aCz.get(0).aAn()));
            this.iQA.setVisibility(0);
        } else {
            this.iQA.setVisibility(8);
        }
        am.setBackgroundResource(this.iQA, R.drawable.activity_join_num_bg);
        am.setViewTextColor(this.iQB, R.color.cp_link_tip_d, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.iQz);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.iQz);
        }
    }

    public void onChangeSkinType(int i) {
        this.iNC.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.iQz);
    }

    public View cqH() {
        return this.iQz;
    }
}
