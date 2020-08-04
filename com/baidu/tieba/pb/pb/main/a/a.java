package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class a {
    private com.baidu.tieba.pb.a.c euG;
    private PbFragment kuO;
    private View kxU = null;
    private View kxV = null;
    private TextView kxW = null;
    private View kxX = null;
    private View kxY = null;
    private View kxZ = null;
    private Button kvJ = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.kuO = pbFragment;
        this.euG = cVar;
        initView();
    }

    private void initView() {
        this.kxU = LayoutInflater.from(this.kuO.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.kxU.setOnTouchListener(this.euG);
        this.kxV = this.kxU.findViewById(R.id.pb_head_activity_join_number_container);
        this.kxV.setVisibility(8);
        this.kxW = (TextView) this.kxU.findViewById(R.id.pb_head_activity_join_number);
        this.kxX = this.kxU.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.kxY = this.kxU.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.kxU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean tb(boolean z) {
        boolean z2;
        if (this.kvJ != null && this.kvJ.getVisibility() == 0) {
            if (this.kxX != null) {
                this.kxX.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.kxX != null) {
                this.kxX.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.kxZ == null || this.kxZ.getVisibility() == 8) && z2 && z) {
            this.kxY.setVisibility(0);
        } else {
            this.kxY.setVisibility(8);
        }
        return z2;
    }

    public void e(f fVar, boolean z) {
        boolean tb = tb(z);
        if (fVar != null && fVar.getPage() != null && fVar.getPage().aVc() == 0 && z) {
            if (tb) {
                this.kxY.setVisibility(0);
                return;
            } else {
                this.kxY.setVisibility(8);
                return;
            }
        }
        this.kxY.setVisibility(8);
    }

    public void z(f fVar) {
        ArrayList<com.baidu.tbadk.core.data.a> aWv = fVar.cKx().aWv();
        if (aWv != null && aWv.size() > 0) {
            this.kxW.setText(String.valueOf(aWv.get(0).aUc()));
            this.kxV.setVisibility(0);
        } else {
            this.kxV.setVisibility(8);
        }
        ao.setBackgroundResource(this.kxV, R.drawable.activity_join_num_bg);
        ao.setViewTextColor(this.kxW, R.color.cp_link_tip_d, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.kxU);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.kxU);
        }
    }

    public void onChangeSkinType(int i) {
        this.kuO.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.kxU);
    }

    public View cQY() {
        return this.kxU;
    }
}
