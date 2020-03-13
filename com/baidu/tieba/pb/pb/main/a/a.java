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
    private com.baidu.tieba.pb.a.c dqX;
    private PbFragment iNO;
    private View iQL = null;
    private View iQM = null;
    private TextView iQN = null;
    private View iQO = null;
    private View iQP = null;
    private View iQQ = null;
    private Button iOH = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.iNO = pbFragment;
        this.dqX = cVar;
        initView();
    }

    private void initView() {
        this.iQL = LayoutInflater.from(this.iNO.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.iQL.setOnTouchListener(this.dqX);
        this.iQM = this.iQL.findViewById(R.id.pb_head_activity_join_number_container);
        this.iQM.setVisibility(8);
        this.iQN = (TextView) this.iQL.findViewById(R.id.pb_head_activity_join_number);
        this.iQO = this.iQL.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.iQP = this.iQL.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.iQL.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean qy(boolean z) {
        boolean z2;
        if (this.iOH != null && this.iOH.getVisibility() == 0) {
            if (this.iQO != null) {
                this.iQO.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.iQO != null) {
                this.iQO.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.iQQ == null || this.iQQ.getVisibility() == 8) && z2 && z) {
            this.iQP.setVisibility(0);
        } else {
            this.iQP.setVisibility(8);
        }
        return z2;
    }

    public void e(com.baidu.tieba.pb.data.e eVar, boolean z) {
        boolean qy = qy(z);
        if (eVar != null && eVar.getPage() != null && eVar.getPage().aBl() == 0 && z) {
            if (qy) {
                this.iQP.setVisibility(0);
                return;
            } else {
                this.iQP.setVisibility(8);
                return;
            }
        }
        this.iQP.setVisibility(8);
    }

    public void v(com.baidu.tieba.pb.data.e eVar) {
        ArrayList<com.baidu.tbadk.core.data.b> aCz = eVar.ckv().aCz();
        if (aCz != null && aCz.size() > 0) {
            this.iQN.setText(String.valueOf(aCz.get(0).aAn()));
            this.iQM.setVisibility(0);
        } else {
            this.iQM.setVisibility(8);
        }
        am.setBackgroundResource(this.iQM, R.drawable.activity_join_num_bg);
        am.setViewTextColor(this.iQN, R.color.cp_link_tip_d, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.iQL);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.iQL);
        }
    }

    public void onChangeSkinType(int i) {
        this.iNO.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.iQL);
    }

    public View cqI() {
        return this.iQL;
    }
}
