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
    private PbFragment lUg;
    private View lXp = null;
    private View lXq = null;
    private TextView lXr = null;
    private View lXs = null;
    private View lXt = null;
    private View lXu = null;
    private Button lVb = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lUg = pbFragment;
        this.fyb = cVar;
        initView();
    }

    private void initView() {
        this.lXp = LayoutInflater.from(this.lUg.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.lXp.setOnTouchListener(this.fyb);
        this.lXq = this.lXp.findViewById(R.id.pb_head_activity_join_number_container);
        this.lXq.setVisibility(8);
        this.lXr = (TextView) this.lXp.findViewById(R.id.pb_head_activity_join_number);
        this.lXs = this.lXp.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.lXt = this.lXp.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.lXp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean vH(boolean z) {
        boolean z2;
        if (this.lVb != null && this.lVb.getVisibility() == 0) {
            if (this.lXs != null) {
                this.lXs.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.lXs != null) {
                this.lXs.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.lXu == null || this.lXu.getVisibility() == 8) && z2 && z) {
            this.lXt.setVisibility(0);
        } else {
            this.lXt.setVisibility(8);
        }
        return z2;
    }

    public void e(com.baidu.tieba.pb.data.f fVar, boolean z) {
        boolean vH = vH(z);
        if (fVar != null && fVar.getPage() != null && fVar.getPage().bqh() == 0 && z) {
            if (vH) {
                this.lXt.setVisibility(0);
                return;
            } else {
                this.lXt.setVisibility(8);
                return;
            }
        }
        this.lXt.setVisibility(8);
    }

    public void B(com.baidu.tieba.pb.data.f fVar) {
        ArrayList<com.baidu.tbadk.core.data.b> brB = fVar.dmF().brB();
        if (brB != null && brB.size() > 0) {
            this.lXr.setText(String.valueOf(brB.get(0).bpd()));
            this.lXq.setVisibility(0);
        } else {
            this.lXq.setVisibility(8);
        }
        ao.setBackgroundResource(this.lXq, R.drawable.activity_join_num_bg);
        ao.setViewTextColor(this.lXr, R.color.CAM_X0305, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.lXp);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.lXp);
        }
    }

    public void onChangeSkinType(int i) {
        this.lUg.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lXp);
    }

    public View dtt() {
        return this.lXp;
    }
}
