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
    private com.baidu.tieba.pb.a.c dRm;
    private PbFragment jzC;
    private View jCz = null;
    private View jCA = null;
    private TextView jCB = null;
    private View jCC = null;
    private View jCD = null;
    private View jCE = null;
    private Button jAv = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.jzC = pbFragment;
        this.dRm = cVar;
        initView();
    }

    private void initView() {
        this.jCz = LayoutInflater.from(this.jzC.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.jCz.setOnTouchListener(this.dRm);
        this.jCA = this.jCz.findViewById(R.id.pb_head_activity_join_number_container);
        this.jCA.setVisibility(8);
        this.jCB = (TextView) this.jCz.findViewById(R.id.pb_head_activity_join_number);
        this.jCC = this.jCz.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.jCD = this.jCz.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.jCz.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean rI(boolean z) {
        boolean z2;
        if (this.jAv != null && this.jAv.getVisibility() == 0) {
            if (this.jCC != null) {
                this.jCC.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.jCC != null) {
                this.jCC.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.jCE == null || this.jCE.getVisibility() == 8) && z2 && z) {
            this.jCD.setVisibility(0);
        } else {
            this.jCD.setVisibility(8);
        }
        return z2;
    }

    public void e(com.baidu.tieba.pb.data.e eVar, boolean z) {
        boolean rI = rI(z);
        if (eVar != null && eVar.getPage() != null && eVar.getPage().aJz() == 0 && z) {
            if (rI) {
                this.jCD.setVisibility(0);
                return;
            } else {
                this.jCD.setVisibility(8);
                return;
            }
        }
        this.jCD.setVisibility(8);
    }

    public void v(com.baidu.tieba.pb.data.e eVar) {
        ArrayList<com.baidu.tbadk.core.data.b> aKN = eVar.cvr().aKN();
        if (aKN != null && aKN.size() > 0) {
            this.jCB.setText(String.valueOf(aKN.get(0).aIB()));
            this.jCA.setVisibility(0);
        } else {
            this.jCA.setVisibility(8);
        }
        am.setBackgroundResource(this.jCA, R.drawable.activity_join_num_bg);
        am.setViewTextColor(this.jCB, R.color.cp_link_tip_d, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.jCz);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.jCz);
        }
    }

    public void onChangeSkinType(int i) {
        this.jzC.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.jCz);
    }

    public View cBG() {
        return this.jCz;
    }
}
