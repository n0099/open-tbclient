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
    private com.baidu.tieba.pb.a.c fhK;
    private PbFragment lAN;
    private View lDT = null;
    private View lDU = null;
    private TextView lDV = null;
    private View lDW = null;
    private View lDX = null;
    private View lDY = null;
    private Button lBI = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lAN = pbFragment;
        this.fhK = cVar;
        initView();
    }

    private void initView() {
        this.lDT = LayoutInflater.from(this.lAN.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.lDT.setOnTouchListener(this.fhK);
        this.lDU = this.lDT.findViewById(R.id.pb_head_activity_join_number_container);
        this.lDU.setVisibility(8);
        this.lDV = (TextView) this.lDT.findViewById(R.id.pb_head_activity_join_number);
        this.lDW = this.lDT.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.lDX = this.lDT.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.lDT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean va(boolean z) {
        boolean z2;
        if (this.lBI != null && this.lBI.getVisibility() == 0) {
            if (this.lDW != null) {
                this.lDW.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.lDW != null) {
                this.lDW.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.lDY == null || this.lDY.getVisibility() == 8) && z2 && z) {
            this.lDX.setVisibility(0);
        } else {
            this.lDX.setVisibility(8);
        }
        return z2;
    }

    public void e(f fVar, boolean z) {
        boolean va = va(z);
        if (fVar != null && fVar.getPage() != null && fVar.getPage().blr() == 0 && z) {
            if (va) {
                this.lDX.setVisibility(0);
                return;
            } else {
                this.lDX.setVisibility(8);
                return;
            }
        }
        this.lDX.setVisibility(8);
    }

    public void z(f fVar) {
        ArrayList<com.baidu.tbadk.core.data.a> bmK = fVar.dik().bmK();
        if (bmK != null && bmK.size() > 0) {
            this.lDV.setText(String.valueOf(bmK.get(0).bkp()));
            this.lDU.setVisibility(0);
        } else {
            this.lDU.setVisibility(8);
        }
        ap.setBackgroundResource(this.lDU, R.drawable.activity_join_num_bg);
        ap.setViewTextColor(this.lDV, R.color.cp_link_tip_d, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.lDT);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.lDT);
        }
    }

    public void onChangeSkinType(int i) {
        this.lAN.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lDT);
    }

    public View doM() {
        return this.lDT;
    }
}
