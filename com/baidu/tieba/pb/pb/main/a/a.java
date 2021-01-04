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
    private com.baidu.tieba.pb.a.c fyb;
    private PbFragment lUh;
    private View lXq = null;
    private View lXr = null;
    private TextView lXs = null;
    private View lXt = null;
    private View lXu = null;
    private View lXv = null;
    private Button lVc = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lUh = pbFragment;
        this.fyb = cVar;
        initView();
    }

    private void initView() {
        this.lXq = LayoutInflater.from(this.lUh.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.lXq.setOnTouchListener(this.fyb);
        this.lXr = this.lXq.findViewById(R.id.pb_head_activity_join_number_container);
        this.lXr.setVisibility(8);
        this.lXs = (TextView) this.lXq.findViewById(R.id.pb_head_activity_join_number);
        this.lXt = this.lXq.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.lXu = this.lXq.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.lXq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean vH(boolean z) {
        boolean z2;
        if (this.lVc != null && this.lVc.getVisibility() == 0) {
            if (this.lXt != null) {
                this.lXt.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.lXt != null) {
                this.lXt.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.lXv == null || this.lXv.getVisibility() == 8) && z2 && z) {
            this.lXu.setVisibility(0);
        } else {
            this.lXu.setVisibility(8);
        }
        return z2;
    }

    public void e(com.baidu.tieba.pb.data.f fVar, boolean z) {
        boolean vH = vH(z);
        if (fVar != null && fVar.getPage() != null && fVar.getPage().bqg() == 0 && z) {
            if (vH) {
                this.lXu.setVisibility(0);
                return;
            } else {
                this.lXu.setVisibility(8);
                return;
            }
        }
        this.lXu.setVisibility(8);
    }

    public void B(com.baidu.tieba.pb.data.f fVar) {
        ArrayList<com.baidu.tbadk.core.data.b> brA = fVar.dmE().brA();
        if (brA != null && brA.size() > 0) {
            this.lXs.setText(String.valueOf(brA.get(0).bpc()));
            this.lXr.setVisibility(0);
        } else {
            this.lXr.setVisibility(8);
        }
        ao.setBackgroundResource(this.lXr, R.drawable.activity_join_num_bg);
        ao.setViewTextColor(this.lXs, R.color.CAM_X0305, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.lXq);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.lXq);
        }
    }

    public void onChangeSkinType(int i) {
        this.lUh.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lXq);
    }

    public View dts() {
        return this.lXq;
    }
}
