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
/* loaded from: classes16.dex */
public class a {
    private com.baidu.tieba.pb.a.c eFj;
    private PbFragment kKA;
    private View kNG = null;
    private View kNH = null;
    private TextView kNI = null;
    private View kNJ = null;
    private View kNK = null;
    private View kNL = null;
    private Button kLv = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.kKA = pbFragment;
        this.eFj = cVar;
        initView();
    }

    private void initView() {
        this.kNG = LayoutInflater.from(this.kKA.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.kNG.setOnTouchListener(this.eFj);
        this.kNH = this.kNG.findViewById(R.id.pb_head_activity_join_number_container);
        this.kNH.setVisibility(8);
        this.kNI = (TextView) this.kNG.findViewById(R.id.pb_head_activity_join_number);
        this.kNJ = this.kNG.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.kNK = this.kNG.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.kNG.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean tM(boolean z) {
        boolean z2;
        if (this.kLv != null && this.kLv.getVisibility() == 0) {
            if (this.kNJ != null) {
                this.kNJ.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.kNJ != null) {
                this.kNJ.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.kNL == null || this.kNL.getVisibility() == 8) && z2 && z) {
            this.kNK.setVisibility(0);
        } else {
            this.kNK.setVisibility(8);
        }
        return z2;
    }

    public void e(f fVar, boolean z) {
        boolean tM = tM(z);
        if (fVar != null && fVar.getPage() != null && fVar.getPage().bdv() == 0 && z) {
            if (tM) {
                this.kNK.setVisibility(0);
                return;
            } else {
                this.kNK.setVisibility(8);
                return;
            }
        }
        this.kNK.setVisibility(8);
    }

    public void z(f fVar) {
        ArrayList<com.baidu.tbadk.core.data.a> beO = fVar.cVm().beO();
        if (beO != null && beO.size() > 0) {
            this.kNI.setText(String.valueOf(beO.get(0).bct()));
            this.kNH.setVisibility(0);
        } else {
            this.kNH.setVisibility(8);
        }
        ap.setBackgroundResource(this.kNH, R.drawable.activity_join_num_bg);
        ap.setViewTextColor(this.kNI, R.color.cp_link_tip_d, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.kNG);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.kNG);
        }
    }

    public void onChangeSkinType(int i) {
        this.kKA.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.kNG);
    }

    public View dbP() {
        return this.kNG;
    }
}
