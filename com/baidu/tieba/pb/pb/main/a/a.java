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
    private com.baidu.tieba.pb.a.c efF;
    private PbFragment jQT;
    private View jTY = null;
    private View jTZ = null;
    private TextView jUa = null;
    private View jUb = null;
    private View jUc = null;
    private View jUd = null;
    private Button jRO = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.jQT = pbFragment;
        this.efF = cVar;
        initView();
    }

    private void initView() {
        this.jTY = LayoutInflater.from(this.jQT.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.jTY.setOnTouchListener(this.efF);
        this.jTZ = this.jTY.findViewById(R.id.pb_head_activity_join_number_container);
        this.jTZ.setVisibility(8);
        this.jUa = (TextView) this.jTY.findViewById(R.id.pb_head_activity_join_number);
        this.jUb = this.jTY.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.jUc = this.jTY.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.jTY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean sh(boolean z) {
        boolean z2;
        if (this.jRO != null && this.jRO.getVisibility() == 0) {
            if (this.jUb != null) {
                this.jUb.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.jUb != null) {
                this.jUb.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.jUd == null || this.jUd.getVisibility() == 8) && z2 && z) {
            this.jUc.setVisibility(0);
        } else {
            this.jUc.setVisibility(8);
        }
        return z2;
    }

    public void e(com.baidu.tieba.pb.data.e eVar, boolean z) {
        boolean sh = sh(z);
        if (eVar != null && eVar.getPage() != null && eVar.getPage().aPu() == 0 && z) {
            if (sh) {
                this.jUc.setVisibility(0);
                return;
            } else {
                this.jUc.setVisibility(8);
                return;
            }
        }
        this.jUc.setVisibility(8);
    }

    public void y(com.baidu.tieba.pb.data.e eVar) {
        ArrayList<com.baidu.tbadk.core.data.a> aQI = eVar.cCi().aQI();
        if (aQI != null && aQI.size() > 0) {
            this.jUa.setText(String.valueOf(aQI.get(0).aOw()));
            this.jTZ.setVisibility(0);
        } else {
            this.jTZ.setVisibility(8);
        }
        am.setBackgroundResource(this.jTZ, R.drawable.activity_join_num_bg);
        am.setViewTextColor(this.jUa, R.color.cp_link_tip_d, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.jTY);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.jTY);
        }
    }

    public void onChangeSkinType(int i) {
        this.jQT.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.jTY);
    }

    public View cID() {
        return this.jTY;
    }
}
