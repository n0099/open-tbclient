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
/* loaded from: classes22.dex */
public class a {
    private com.baidu.tieba.pb.a.c fbT;
    private PbFragment luQ;
    private View lxW = null;
    private View lxX = null;
    private TextView lxY = null;
    private View lxZ = null;
    private View lya = null;
    private View lyb = null;
    private Button lvL = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.luQ = pbFragment;
        this.fbT = cVar;
        initView();
    }

    private void initView() {
        this.lxW = LayoutInflater.from(this.luQ.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.lxW.setOnTouchListener(this.fbT);
        this.lxX = this.lxW.findViewById(R.id.pb_head_activity_join_number_container);
        this.lxX.setVisibility(8);
        this.lxY = (TextView) this.lxW.findViewById(R.id.pb_head_activity_join_number);
        this.lxZ = this.lxW.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.lya = this.lxW.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.lxW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean uR(boolean z) {
        boolean z2;
        if (this.lvL != null && this.lvL.getVisibility() == 0) {
            if (this.lxZ != null) {
                this.lxZ.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.lxZ != null) {
                this.lxZ.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.lyb == null || this.lyb.getVisibility() == 8) && z2 && z) {
            this.lya.setVisibility(0);
        } else {
            this.lya.setVisibility(8);
        }
        return z2;
    }

    public void e(f fVar, boolean z) {
        boolean uR = uR(z);
        if (fVar != null && fVar.getPage() != null && fVar.getPage().biR() == 0 && z) {
            if (uR) {
                this.lya.setVisibility(0);
                return;
            } else {
                this.lya.setVisibility(8);
                return;
            }
        }
        this.lya.setVisibility(8);
    }

    public void z(f fVar) {
        ArrayList<com.baidu.tbadk.core.data.a> bkk = fVar.dfI().bkk();
        if (bkk != null && bkk.size() > 0) {
            this.lxY.setText(String.valueOf(bkk.get(0).bhP()));
            this.lxX.setVisibility(0);
        } else {
            this.lxX.setVisibility(8);
        }
        ap.setBackgroundResource(this.lxX, R.drawable.activity_join_num_bg);
        ap.setViewTextColor(this.lxY, R.color.cp_link_tip_d, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.lxW);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.lxW);
        }
    }

    public void onChangeSkinType(int i) {
        this.luQ.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lxW);
    }

    public View dmj() {
        return this.lxW;
    }
}
