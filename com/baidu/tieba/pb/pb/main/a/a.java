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
/* loaded from: classes7.dex */
public class a {
    private com.baidu.tieba.pb.a.c dmA;
    private PbFragment iMg;
    private View iPc = null;
    private View iPd = null;
    private TextView iPe = null;
    private View iPf = null;
    private View iPg = null;
    private View iPh = null;
    private Button iMZ = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.iMg = pbFragment;
        this.dmA = cVar;
        initView();
    }

    private void initView() {
        this.iPc = LayoutInflater.from(this.iMg.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.iPc.setOnTouchListener(this.dmA);
        this.iPd = this.iPc.findViewById(R.id.pb_head_activity_join_number_container);
        this.iPd.setVisibility(8);
        this.iPe = (TextView) this.iPc.findViewById(R.id.pb_head_activity_join_number);
        this.iPf = this.iPc.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.iPg = this.iPc.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.iPc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean qv(boolean z) {
        boolean z2;
        if (this.iMZ != null && this.iMZ.getVisibility() == 0) {
            if (this.iPf != null) {
                this.iPf.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.iPf != null) {
                this.iPf.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.iPh == null || this.iPh.getVisibility() == 8) && z2 && z) {
            this.iPg.setVisibility(0);
        } else {
            this.iPg.setVisibility(8);
        }
        return z2;
    }

    public void e(f fVar, boolean z) {
        boolean qv = qv(z);
        if (fVar != null && fVar.getPage() != null && fVar.getPage().ayS() == 0 && z) {
            if (qv) {
                this.iPg.setVisibility(0);
                return;
            } else {
                this.iPg.setVisibility(8);
                return;
            }
        }
        this.iPg.setVisibility(8);
    }

    public void u(f fVar) {
        ArrayList<com.baidu.tbadk.core.data.b> aAi = fVar.ciS().aAi();
        if (aAi != null && aAi.size() > 0) {
            this.iPe.setText(String.valueOf(aAi.get(0).axX()));
            this.iPd.setVisibility(0);
        } else {
            this.iPd.setVisibility(8);
        }
        am.setBackgroundResource(this.iPd, R.drawable.activity_join_num_bg);
        am.setViewTextColor(this.iPe, R.color.cp_link_tip_d, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.iPc);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.iPc);
        }
    }

    public void onChangeSkinType(int i) {
        this.iMg.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.iPc);
    }

    public View cpn() {
        return this.iPc;
    }
}
