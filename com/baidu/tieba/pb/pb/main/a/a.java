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
/* loaded from: classes16.dex */
public class a {
    private com.baidu.tieba.pb.a.c eFf;
    private PbFragment kKt;
    private View kNz = null;
    private View kNA = null;
    private TextView kNB = null;
    private View kNC = null;
    private View kND = null;
    private View kNE = null;
    private Button kLo = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.kKt = pbFragment;
        this.eFf = cVar;
        initView();
    }

    private void initView() {
        this.kNz = LayoutInflater.from(this.kKt.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.kNz.setOnTouchListener(this.eFf);
        this.kNA = this.kNz.findViewById(R.id.pb_head_activity_join_number_container);
        this.kNA.setVisibility(8);
        this.kNB = (TextView) this.kNz.findViewById(R.id.pb_head_activity_join_number);
        this.kNC = this.kNz.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.kND = this.kNz.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.kNz.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean tK(boolean z) {
        boolean z2;
        if (this.kLo != null && this.kLo.getVisibility() == 0) {
            if (this.kNC != null) {
                this.kNC.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.kNC != null) {
                this.kNC.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.kNE == null || this.kNE.getVisibility() == 8) && z2 && z) {
            this.kND.setVisibility(0);
        } else {
            this.kND.setVisibility(8);
        }
        return z2;
    }

    public void e(f fVar, boolean z) {
        boolean tK = tK(z);
        if (fVar != null && fVar.getPage() != null && fVar.getPage().bdv() == 0 && z) {
            if (tK) {
                this.kND.setVisibility(0);
                return;
            } else {
                this.kND.setVisibility(8);
                return;
            }
        }
        this.kND.setVisibility(8);
    }

    public void z(f fVar) {
        ArrayList<com.baidu.tbadk.core.data.a> beO = fVar.cVl().beO();
        if (beO != null && beO.size() > 0) {
            this.kNB.setText(String.valueOf(beO.get(0).bct()));
            this.kNA.setVisibility(0);
        } else {
            this.kNA.setVisibility(8);
        }
        ap.setBackgroundResource(this.kNA, R.drawable.activity_join_num_bg);
        ap.setViewTextColor(this.kNB, R.color.cp_link_tip_d, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.kNz);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.kNz);
        }
    }

    public void onChangeSkinType(int i) {
        this.kKt.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.kNz);
    }

    public View dbO() {
        return this.kNz;
    }
}
