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
    private PbFragment kuM;
    private View kxS = null;
    private View kxT = null;
    private TextView kxU = null;
    private View kxV = null;
    private View kxW = null;
    private View kxX = null;
    private Button kvH = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.kuM = pbFragment;
        this.euG = cVar;
        initView();
    }

    private void initView() {
        this.kxS = LayoutInflater.from(this.kuM.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.kxS.setOnTouchListener(this.euG);
        this.kxT = this.kxS.findViewById(R.id.pb_head_activity_join_number_container);
        this.kxT.setVisibility(8);
        this.kxU = (TextView) this.kxS.findViewById(R.id.pb_head_activity_join_number);
        this.kxV = this.kxS.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.kxW = this.kxS.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.kxS.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean tb(boolean z) {
        boolean z2;
        if (this.kvH != null && this.kvH.getVisibility() == 0) {
            if (this.kxV != null) {
                this.kxV.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.kxV != null) {
                this.kxV.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.kxX == null || this.kxX.getVisibility() == 8) && z2 && z) {
            this.kxW.setVisibility(0);
        } else {
            this.kxW.setVisibility(8);
        }
        return z2;
    }

    public void e(f fVar, boolean z) {
        boolean tb = tb(z);
        if (fVar != null && fVar.getPage() != null && fVar.getPage().aVc() == 0 && z) {
            if (tb) {
                this.kxW.setVisibility(0);
                return;
            } else {
                this.kxW.setVisibility(8);
                return;
            }
        }
        this.kxW.setVisibility(8);
    }

    public void z(f fVar) {
        ArrayList<com.baidu.tbadk.core.data.a> aWv = fVar.cKx().aWv();
        if (aWv != null && aWv.size() > 0) {
            this.kxU.setText(String.valueOf(aWv.get(0).aUc()));
            this.kxT.setVisibility(0);
        } else {
            this.kxT.setVisibility(8);
        }
        ao.setBackgroundResource(this.kxT, R.drawable.activity_join_num_bg);
        ao.setViewTextColor(this.kxU, R.color.cp_link_tip_d, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.kxS);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.kxS);
        }
    }

    public void onChangeSkinType(int i) {
        this.kuM.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.kxS);
    }

    public View cQY() {
        return this.kxS;
    }
}
