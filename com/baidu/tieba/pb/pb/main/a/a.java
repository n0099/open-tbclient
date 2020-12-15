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
    private PbFragment lOU;
    private View lSe = null;
    private View lSf = null;
    private TextView lSg = null;
    private View lSh = null;
    private View lSi = null;
    private View lSj = null;
    private Button lPP = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lOU = pbFragment;
        this.fos = cVar;
        initView();
    }

    private void initView() {
        this.lSe = LayoutInflater.from(this.lOU.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.lSe.setOnTouchListener(this.fos);
        this.lSf = this.lSe.findViewById(R.id.pb_head_activity_join_number_container);
        this.lSf.setVisibility(8);
        this.lSg = (TextView) this.lSe.findViewById(R.id.pb_head_activity_join_number);
        this.lSh = this.lSe.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.lSi = this.lSe.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.lSe.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean vG(boolean z) {
        boolean z2;
        if (this.lPP != null && this.lPP.getVisibility() == 0) {
            if (this.lSh != null) {
                this.lSh.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.lSh != null) {
                this.lSh.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.lSj == null || this.lSj.getVisibility() == 8) && z2 && z) {
            this.lSi.setVisibility(0);
        } else {
            this.lSi.setVisibility(8);
        }
        return z2;
    }

    public void e(com.baidu.tieba.pb.data.f fVar, boolean z) {
        boolean vG = vG(z);
        if (fVar != null && fVar.getPage() != null && fVar.getPage().bnG() == 0 && z) {
            if (vG) {
                this.lSi.setVisibility(0);
                return;
            } else {
                this.lSi.setVisibility(8);
                return;
            }
        }
        this.lSi.setVisibility(8);
    }

    public void B(com.baidu.tieba.pb.data.f fVar) {
        ArrayList<com.baidu.tbadk.core.data.b> boZ = fVar.dmU().boZ();
        if (boZ != null && boZ.size() > 0) {
            this.lSg.setText(String.valueOf(boZ.get(0).bmB()));
            this.lSf.setVisibility(0);
        } else {
            this.lSf.setVisibility(8);
        }
        ap.setBackgroundResource(this.lSf, R.drawable.activity_join_num_bg);
        ap.setViewTextColor(this.lSg, R.color.CAM_X0305, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.lSe);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.lSe);
        }
    }

    public void onChangeSkinType(int i) {
        this.lOU.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lSe);
    }

    public View dtD() {
        return this.lSe;
    }
}
