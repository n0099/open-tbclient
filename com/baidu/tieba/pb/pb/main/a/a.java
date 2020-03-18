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
    private com.baidu.tieba.pb.a.c drk;
    private PbFragment iPp;
    private View iSm = null;
    private View iSn = null;
    private TextView iSo = null;
    private View iSp = null;
    private View iSq = null;
    private View iSr = null;
    private Button iQi = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.iPp = pbFragment;
        this.drk = cVar;
        initView();
    }

    private void initView() {
        this.iSm = LayoutInflater.from(this.iPp.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.iSm.setOnTouchListener(this.drk);
        this.iSn = this.iSm.findViewById(R.id.pb_head_activity_join_number_container);
        this.iSn.setVisibility(8);
        this.iSo = (TextView) this.iSm.findViewById(R.id.pb_head_activity_join_number);
        this.iSp = this.iSm.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.iSq = this.iSm.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.iSm.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean qE(boolean z) {
        boolean z2;
        if (this.iQi != null && this.iQi.getVisibility() == 0) {
            if (this.iSp != null) {
                this.iSp.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.iSp != null) {
                this.iSp.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.iSr == null || this.iSr.getVisibility() == 8) && z2 && z) {
            this.iSq.setVisibility(0);
        } else {
            this.iSq.setVisibility(8);
        }
        return z2;
    }

    public void e(com.baidu.tieba.pb.data.e eVar, boolean z) {
        boolean qE = qE(z);
        if (eVar != null && eVar.getPage() != null && eVar.getPage().aBo() == 0 && z) {
            if (qE) {
                this.iSq.setVisibility(0);
                return;
            } else {
                this.iSq.setVisibility(8);
                return;
            }
        }
        this.iSq.setVisibility(8);
    }

    public void v(com.baidu.tieba.pb.data.e eVar) {
        ArrayList<com.baidu.tbadk.core.data.b> aCC = eVar.ckP().aCC();
        if (aCC != null && aCC.size() > 0) {
            this.iSo.setText(String.valueOf(aCC.get(0).aAq()));
            this.iSn.setVisibility(0);
        } else {
            this.iSn.setVisibility(8);
        }
        am.setBackgroundResource(this.iSn, R.drawable.activity_join_num_bg);
        am.setViewTextColor(this.iSo, R.color.cp_link_tip_d, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.iSm);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.iSm);
        }
    }

    public void onChangeSkinType(int i) {
        this.iPp.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.iSm);
    }

    public View crd() {
        return this.iSm;
    }
}
