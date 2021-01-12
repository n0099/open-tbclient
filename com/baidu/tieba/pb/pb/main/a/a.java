package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.tieba.pb.a.c ftt;
    private PbFragment lPC;
    private View lSL = null;
    private View lSM = null;
    private TextView lSN = null;
    private View lSO = null;
    private View lSP = null;
    private View lSQ = null;
    private Button lQx = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lPC = pbFragment;
        this.ftt = cVar;
        initView();
    }

    private void initView() {
        this.lSL = LayoutInflater.from(this.lPC.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.lSL.setOnTouchListener(this.ftt);
        this.lSM = this.lSL.findViewById(R.id.pb_head_activity_join_number_container);
        this.lSM.setVisibility(8);
        this.lSN = (TextView) this.lSL.findViewById(R.id.pb_head_activity_join_number);
        this.lSO = this.lSL.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.lSP = this.lSL.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.lSL.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean vD(boolean z) {
        boolean z2;
        if (this.lQx != null && this.lQx.getVisibility() == 0) {
            if (this.lSO != null) {
                this.lSO.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.lSO != null) {
                this.lSO.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.lSQ == null || this.lSQ.getVisibility() == 8) && z2 && z) {
            this.lSP.setVisibility(0);
        } else {
            this.lSP.setVisibility(8);
        }
        return z2;
    }

    public void e(com.baidu.tieba.pb.data.f fVar, boolean z) {
        boolean vD = vD(z);
        if (fVar != null && fVar.getPage() != null && fVar.getPage().bmn() == 0 && z) {
            if (vD) {
                this.lSP.setVisibility(0);
                return;
            } else {
                this.lSP.setVisibility(8);
                return;
            }
        }
        this.lSP.setVisibility(8);
    }

    public void B(com.baidu.tieba.pb.data.f fVar) {
        ArrayList<com.baidu.tbadk.core.data.b> bnH = fVar.diN().bnH();
        if (bnH != null && bnH.size() > 0) {
            this.lSN.setText(String.valueOf(bnH.get(0).blj()));
            this.lSM.setVisibility(0);
        } else {
            this.lSM.setVisibility(8);
        }
        ao.setBackgroundResource(this.lSM, R.drawable.activity_join_num_bg);
        ao.setViewTextColor(this.lSN, R.color.CAM_X0305, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.lSL);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.lSL);
        }
    }

    public void onChangeSkinType(int i) {
        this.lPC.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lSL);
    }

    public View dpB() {
        return this.lSL;
    }
}
