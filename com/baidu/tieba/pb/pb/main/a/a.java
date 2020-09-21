package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class a {
    private com.baidu.tieba.pb.a.c eHq;
    private PbFragment kTa;
    private View kWg = null;
    private View kWh = null;
    private TextView kWi = null;
    private View kWj = null;
    private View kWk = null;
    private View kWl = null;
    private Button kTV = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.kTa = pbFragment;
        this.eHq = cVar;
        initView();
    }

    private void initView() {
        this.kWg = LayoutInflater.from(this.kTa.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.kWg.setOnTouchListener(this.eHq);
        this.kWh = this.kWg.findViewById(R.id.pb_head_activity_join_number_container);
        this.kWh.setVisibility(8);
        this.kWi = (TextView) this.kWg.findViewById(R.id.pb_head_activity_join_number);
        this.kWj = this.kWg.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.kWk = this.kWg.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.kWg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean tT(boolean z) {
        boolean z2;
        if (this.kTV != null && this.kTV.getVisibility() == 0) {
            if (this.kWj != null) {
                this.kWj.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.kWj != null) {
                this.kWj.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.kWl == null || this.kWl.getVisibility() == 8) && z2 && z) {
            this.kWk.setVisibility(0);
        } else {
            this.kWk.setVisibility(8);
        }
        return z2;
    }

    public void e(f fVar, boolean z) {
        boolean tT = tT(z);
        if (fVar != null && fVar.getPage() != null && fVar.getPage().bep() == 0 && z) {
            if (tT) {
                this.kWk.setVisibility(0);
                return;
            } else {
                this.kWk.setVisibility(8);
                return;
            }
        }
        this.kWk.setVisibility(8);
    }

    public void z(f fVar) {
        ArrayList<com.baidu.tbadk.core.data.a> bfI = fVar.cYR().bfI();
        if (bfI != null && bfI.size() > 0) {
            this.kWi.setText(String.valueOf(bfI.get(0).bdn()));
            this.kWh.setVisibility(0);
        } else {
            this.kWh.setVisibility(8);
        }
        ap.setBackgroundResource(this.kWh, R.drawable.activity_join_num_bg);
        ap.setViewTextColor(this.kWi, R.color.cp_link_tip_d, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.kWg);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.kWg);
        }
    }

    public void onChangeSkinType(int i) {
        this.kTa.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.kWg);
    }

    public View dft() {
        return this.kWg;
    }
}
