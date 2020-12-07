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
/* loaded from: classes22.dex */
public class a {
    private com.baidu.tieba.pb.a.c fos;
    private PbFragment lOS;
    private View lSc = null;
    private View lSd = null;
    private TextView lSe = null;
    private View lSf = null;
    private View lSg = null;
    private View lSh = null;
    private Button lPN = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lOS = pbFragment;
        this.fos = cVar;
        initView();
    }

    private void initView() {
        this.lSc = LayoutInflater.from(this.lOS.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.lSc.setOnTouchListener(this.fos);
        this.lSd = this.lSc.findViewById(R.id.pb_head_activity_join_number_container);
        this.lSd.setVisibility(8);
        this.lSe = (TextView) this.lSc.findViewById(R.id.pb_head_activity_join_number);
        this.lSf = this.lSc.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.lSg = this.lSc.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.lSc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean vG(boolean z) {
        boolean z2;
        if (this.lPN != null && this.lPN.getVisibility() == 0) {
            if (this.lSf != null) {
                this.lSf.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.lSf != null) {
                this.lSf.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.lSh == null || this.lSh.getVisibility() == 8) && z2 && z) {
            this.lSg.setVisibility(0);
        } else {
            this.lSg.setVisibility(8);
        }
        return z2;
    }

    public void e(com.baidu.tieba.pb.data.f fVar, boolean z) {
        boolean vG = vG(z);
        if (fVar != null && fVar.getPage() != null && fVar.getPage().bnG() == 0 && z) {
            if (vG) {
                this.lSg.setVisibility(0);
                return;
            } else {
                this.lSg.setVisibility(8);
                return;
            }
        }
        this.lSg.setVisibility(8);
    }

    public void B(com.baidu.tieba.pb.data.f fVar) {
        ArrayList<com.baidu.tbadk.core.data.b> boZ = fVar.dmT().boZ();
        if (boZ != null && boZ.size() > 0) {
            this.lSe.setText(String.valueOf(boZ.get(0).bmB()));
            this.lSd.setVisibility(0);
        } else {
            this.lSd.setVisibility(8);
        }
        ap.setBackgroundResource(this.lSd, R.drawable.activity_join_num_bg);
        ap.setViewTextColor(this.lSe, R.color.CAM_X0305, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.lSc);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.lSc);
        }
    }

    public void onChangeSkinType(int i) {
        this.lOS.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lSc);
    }

    public View dtC() {
        return this.lSc;
    }
}
