package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a {
    private com.baidu.tieba.pb.a.c dmm;
    private PbFragment iIC;
    private View iLy = null;
    private View iLz = null;
    private TextView iLA = null;
    private View iLB = null;
    private View iLC = null;
    private View iLD = null;
    private Button iJv = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.iIC = pbFragment;
        this.dmm = cVar;
        initView();
    }

    private void initView() {
        this.iLy = LayoutInflater.from(this.iIC.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.iLy.setOnTouchListener(this.dmm);
        this.iLz = this.iLy.findViewById(R.id.pb_head_activity_join_number_container);
        this.iLz.setVisibility(8);
        this.iLA = (TextView) this.iLy.findViewById(R.id.pb_head_activity_join_number);
        this.iLB = this.iLy.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.iLC = this.iLy.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.iLy.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean qj(boolean z) {
        boolean z2;
        if (this.iJv != null && this.iJv.getVisibility() == 0) {
            if (this.iLB != null) {
                this.iLB.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.iLB != null) {
                this.iLB.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.iLD == null || this.iLD.getVisibility() == 8) && z2 && z) {
            this.iLC.setVisibility(0);
        } else {
            this.iLC.setVisibility(8);
        }
        return z2;
    }

    public void e(f fVar, boolean z) {
        boolean qj = qj(z);
        if (fVar != null && fVar.getPage() != null && fVar.getPage().ayz() == 0 && z) {
            if (qj) {
                this.iLC.setVisibility(0);
                return;
            } else {
                this.iLC.setVisibility(8);
                return;
            }
        }
        this.iLC.setVisibility(8);
    }

    public void u(f fVar) {
        ArrayList<com.baidu.tbadk.core.data.b> azP = fVar.chK().azP();
        if (azP != null && azP.size() > 0) {
            this.iLA.setText(String.valueOf(azP.get(0).axE()));
            this.iLz.setVisibility(0);
        } else {
            this.iLz.setVisibility(8);
        }
        am.setBackgroundResource(this.iLz, R.drawable.activity_join_num_bg);
        am.setViewTextColor(this.iLA, R.color.cp_link_tip_d, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.iLy);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.iLy);
        }
    }

    public void onChangeSkinType(int i) {
        this.iIC.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.iLy);
    }

    public View cog() {
        return this.iLy;
    }
}
