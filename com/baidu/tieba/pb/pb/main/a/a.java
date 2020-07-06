package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a {
    private com.baidu.tieba.pb.a.c eor;
    private PbFragment klP;
    private View koU = null;
    private View koV = null;
    private TextView koW = null;
    private View koX = null;
    private View koY = null;
    private View koZ = null;
    private Button kmK = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.klP = pbFragment;
        this.eor = cVar;
        initView();
    }

    private void initView() {
        this.koU = LayoutInflater.from(this.klP.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.koU.setOnTouchListener(this.eor);
        this.koV = this.koU.findViewById(R.id.pb_head_activity_join_number_container);
        this.koV.setVisibility(8);
        this.koW = (TextView) this.koU.findViewById(R.id.pb_head_activity_join_number);
        this.koX = this.koU.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.koY = this.koU.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.koU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean sv(boolean z) {
        boolean z2;
        if (this.kmK != null && this.kmK.getVisibility() == 0) {
            if (this.koX != null) {
                this.koX.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.koX != null) {
                this.koX.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.koZ == null || this.koZ.getVisibility() == 8) && z2 && z) {
            this.koY.setVisibility(0);
        } else {
            this.koY.setVisibility(8);
        }
        return z2;
    }

    public void e(com.baidu.tieba.pb.data.e eVar, boolean z) {
        boolean sv = sv(z);
        if (eVar != null && eVar.getPage() != null && eVar.getPage().aRg() == 0 && z) {
            if (sv) {
                this.koY.setVisibility(0);
                return;
            } else {
                this.koY.setVisibility(8);
                return;
            }
        }
        this.koY.setVisibility(8);
    }

    public void z(com.baidu.tieba.pb.data.e eVar) {
        ArrayList<com.baidu.tbadk.core.data.a> aSz = eVar.cGO().aSz();
        if (aSz != null && aSz.size() > 0) {
            this.koW.setText(String.valueOf(aSz.get(0).aQg()));
            this.koV.setVisibility(0);
        } else {
            this.koV.setVisibility(8);
        }
        an.setBackgroundResource(this.koV, R.drawable.activity_join_num_bg);
        an.setViewTextColor(this.koW, R.color.cp_link_tip_d, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.koU);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.koU);
        }
    }

    public void onChangeSkinType(int i) {
        this.klP.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.koU);
    }

    public View cNl() {
        return this.koU;
    }
}
