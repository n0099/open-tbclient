package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.tieba.pb.a.c fvK;
    private PbFragment lYN;
    private View mcb = null;
    private View mcc = null;
    private TextView mcd = null;
    private View mce = null;
    private View mcf = null;
    private View mcg = null;
    private Button lZI = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lYN = pbFragment;
        this.fvK = cVar;
        initView();
    }

    private void initView() {
        this.mcb = LayoutInflater.from(this.lYN.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.mcb.setOnTouchListener(this.fvK);
        this.mcc = this.mcb.findViewById(R.id.pb_head_activity_join_number_container);
        this.mcc.setVisibility(8);
        this.mcd = (TextView) this.mcb.findViewById(R.id.pb_head_activity_join_number);
        this.mce = this.mcb.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.mcf = this.mcb.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.mcb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean vT(boolean z) {
        boolean z2;
        if (this.lZI != null && this.lZI.getVisibility() == 0) {
            if (this.mce != null) {
                this.mce.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.mce != null) {
                this.mce.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.mcg == null || this.mcg.getVisibility() == 8) && z2 && z) {
            this.mcf.setVisibility(0);
        } else {
            this.mcf.setVisibility(8);
        }
        return z2;
    }

    public void e(com.baidu.tieba.pb.data.f fVar, boolean z) {
        boolean vT = vT(z);
        if (fVar != null && fVar.getPage() != null && fVar.getPage().bmG() == 0 && z) {
            if (vT) {
                this.mcf.setVisibility(0);
                return;
            } else {
                this.mcf.setVisibility(8);
                return;
            }
        }
        this.mcf.setVisibility(8);
    }

    public void B(com.baidu.tieba.pb.data.f fVar) {
        ArrayList<com.baidu.tbadk.core.data.b> boa = fVar.dlg().boa();
        if (boa != null && boa.size() > 0) {
            this.mcd.setText(String.valueOf(boa.get(0).blB()));
            this.mcc.setVisibility(0);
        } else {
            this.mcc.setVisibility(8);
        }
        ap.setBackgroundResource(this.mcc, R.drawable.activity_join_num_bg);
        ap.setViewTextColor(this.mcd, R.color.CAM_X0305, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.mcb);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.mcb);
        }
    }

    public void onChangeSkinType(int i) {
        this.lYN.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mcb);
    }

    public View drW() {
        return this.mcb;
    }
}
