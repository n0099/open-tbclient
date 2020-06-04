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
    private com.baidu.tieba.pb.a.c efF;
    private PbFragment jRZ;
    private View jVe = null;
    private View jVf = null;
    private TextView jVg = null;
    private View jVh = null;
    private View jVi = null;
    private View jVj = null;
    private Button jSU = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.jRZ = pbFragment;
        this.efF = cVar;
        initView();
    }

    private void initView() {
        this.jVe = LayoutInflater.from(this.jRZ.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.jVe.setOnTouchListener(this.efF);
        this.jVf = this.jVe.findViewById(R.id.pb_head_activity_join_number_container);
        this.jVf.setVisibility(8);
        this.jVg = (TextView) this.jVe.findViewById(R.id.pb_head_activity_join_number);
        this.jVh = this.jVe.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.jVi = this.jVe.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.jVe.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean sh(boolean z) {
        boolean z2;
        if (this.jSU != null && this.jSU.getVisibility() == 0) {
            if (this.jVh != null) {
                this.jVh.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.jVh != null) {
                this.jVh.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.jVj == null || this.jVj.getVisibility() == 8) && z2 && z) {
            this.jVi.setVisibility(0);
        } else {
            this.jVi.setVisibility(8);
        }
        return z2;
    }

    public void e(com.baidu.tieba.pb.data.e eVar, boolean z) {
        boolean sh = sh(z);
        if (eVar != null && eVar.getPage() != null && eVar.getPage().aPu() == 0 && z) {
            if (sh) {
                this.jVi.setVisibility(0);
                return;
            } else {
                this.jVi.setVisibility(8);
                return;
            }
        }
        this.jVi.setVisibility(8);
    }

    public void y(com.baidu.tieba.pb.data.e eVar) {
        ArrayList<com.baidu.tbadk.core.data.a> aQI = eVar.cCy().aQI();
        if (aQI != null && aQI.size() > 0) {
            this.jVg.setText(String.valueOf(aQI.get(0).aOw()));
            this.jVf.setVisibility(0);
        } else {
            this.jVf.setVisibility(8);
        }
        am.setBackgroundResource(this.jVf, R.drawable.activity_join_num_bg);
        am.setViewTextColor(this.jVg, R.color.cp_link_tip_d, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.jVe);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.jVe);
        }
    }

    public void onChangeSkinType(int i) {
        this.jRZ.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.jVe);
    }

    public View cIT() {
        return this.jVe;
    }
}
