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
    private com.baidu.tieba.pb.a.c dqJ;
    private PbFragment iNA;
    private View iQx = null;
    private View iQy = null;
    private TextView iQz = null;
    private View iQA = null;
    private View iQB = null;
    private View iQC = null;
    private Button iOt = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.iNA = pbFragment;
        this.dqJ = cVar;
        initView();
    }

    private void initView() {
        this.iQx = LayoutInflater.from(this.iNA.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.iQx.setOnTouchListener(this.dqJ);
        this.iQy = this.iQx.findViewById(R.id.pb_head_activity_join_number_container);
        this.iQy.setVisibility(8);
        this.iQz = (TextView) this.iQx.findViewById(R.id.pb_head_activity_join_number);
        this.iQA = this.iQx.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.iQB = this.iQx.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.iQx.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean qy(boolean z) {
        boolean z2;
        if (this.iOt != null && this.iOt.getVisibility() == 0) {
            if (this.iQA != null) {
                this.iQA.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.iQA != null) {
                this.iQA.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.iQC == null || this.iQC.getVisibility() == 8) && z2 && z) {
            this.iQB.setVisibility(0);
        } else {
            this.iQB.setVisibility(8);
        }
        return z2;
    }

    public void e(com.baidu.tieba.pb.data.e eVar, boolean z) {
        boolean qy = qy(z);
        if (eVar != null && eVar.getPage() != null && eVar.getPage().aBj() == 0 && z) {
            if (qy) {
                this.iQB.setVisibility(0);
                return;
            } else {
                this.iQB.setVisibility(8);
                return;
            }
        }
        this.iQB.setVisibility(8);
    }

    public void v(com.baidu.tieba.pb.data.e eVar) {
        ArrayList<com.baidu.tbadk.core.data.b> aCx = eVar.cks().aCx();
        if (aCx != null && aCx.size() > 0) {
            this.iQz.setText(String.valueOf(aCx.get(0).aAl()));
            this.iQy.setVisibility(0);
        } else {
            this.iQy.setVisibility(8);
        }
        am.setBackgroundResource(this.iQy, R.drawable.activity_join_num_bg);
        am.setViewTextColor(this.iQz, R.color.cp_link_tip_d, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.iQx);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.iQx);
        }
    }

    public void onChangeSkinType(int i) {
        this.iNA.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.iQx);
    }

    public View cqF() {
        return this.iQx;
    }
}
