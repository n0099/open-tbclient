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
    private com.baidu.tieba.pb.a.c fxj;
    private PbFragment maS;
    private View med = null;
    private View mee = null;
    private TextView mef = null;
    private View meg = null;
    private View meh = null;
    private View mei = null;
    private Button mbN = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.maS = pbFragment;
        this.fxj = cVar;
        initView();
    }

    private void initView() {
        this.med = LayoutInflater.from(this.maS.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.med.setOnTouchListener(this.fxj);
        this.mee = this.med.findViewById(R.id.pb_head_activity_join_number_container);
        this.mee.setVisibility(8);
        this.mef = (TextView) this.med.findViewById(R.id.pb_head_activity_join_number);
        this.meg = this.med.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.meh = this.med.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.med.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean vT(boolean z) {
        boolean z2;
        if (this.mbN != null && this.mbN.getVisibility() == 0) {
            if (this.meg != null) {
                this.meg.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.meg != null) {
                this.meg.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.mei == null || this.mei.getVisibility() == 8) && z2 && z) {
            this.meh.setVisibility(0);
        } else {
            this.meh.setVisibility(8);
        }
        return z2;
    }

    public void e(com.baidu.tieba.pb.data.f fVar, boolean z) {
        boolean vT = vT(z);
        if (fVar != null && fVar.getPage() != null && fVar.getPage().bmI() == 0 && z) {
            if (vT) {
                this.meh.setVisibility(0);
                return;
            } else {
                this.meh.setVisibility(8);
                return;
            }
        }
        this.meh.setVisibility(8);
    }

    public void B(com.baidu.tieba.pb.data.f fVar) {
        ArrayList<com.baidu.tbadk.core.data.b> boc = fVar.dlp().boc();
        if (boc != null && boc.size() > 0) {
            this.mef.setText(String.valueOf(boc.get(0).blD()));
            this.mee.setVisibility(0);
        } else {
            this.mee.setVisibility(8);
        }
        ap.setBackgroundResource(this.mee, R.drawable.activity_join_num_bg);
        ap.setViewTextColor(this.mef, R.color.CAM_X0305, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.med);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.med);
        }
    }

    public void onChangeSkinType(int i) {
        this.maS.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.med);
    }

    public View dsf() {
        return this.med;
    }
}
