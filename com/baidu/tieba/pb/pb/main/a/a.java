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
    private com.baidu.tieba.pb.a.c fvK;
    private PbFragment lYy;
    private View mbM = null;
    private View mbN = null;
    private TextView mbO = null;
    private View mbP = null;
    private View mbQ = null;
    private View mbR = null;
    private Button lZt = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lYy = pbFragment;
        this.fvK = cVar;
        initView();
    }

    private void initView() {
        this.mbM = LayoutInflater.from(this.lYy.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.mbM.setOnTouchListener(this.fvK);
        this.mbN = this.mbM.findViewById(R.id.pb_head_activity_join_number_container);
        this.mbN.setVisibility(8);
        this.mbO = (TextView) this.mbM.findViewById(R.id.pb_head_activity_join_number);
        this.mbP = this.mbM.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.mbQ = this.mbM.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.mbM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean vT(boolean z) {
        boolean z2;
        if (this.lZt != null && this.lZt.getVisibility() == 0) {
            if (this.mbP != null) {
                this.mbP.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.mbP != null) {
                this.mbP.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.mbR == null || this.mbR.getVisibility() == 8) && z2 && z) {
            this.mbQ.setVisibility(0);
        } else {
            this.mbQ.setVisibility(8);
        }
        return z2;
    }

    public void e(com.baidu.tieba.pb.data.f fVar, boolean z) {
        boolean vT = vT(z);
        if (fVar != null && fVar.getPage() != null && fVar.getPage().bmG() == 0 && z) {
            if (vT) {
                this.mbQ.setVisibility(0);
                return;
            } else {
                this.mbQ.setVisibility(8);
                return;
            }
        }
        this.mbQ.setVisibility(8);
    }

    public void B(com.baidu.tieba.pb.data.f fVar) {
        ArrayList<com.baidu.tbadk.core.data.b> boa = fVar.dkZ().boa();
        if (boa != null && boa.size() > 0) {
            this.mbO.setText(String.valueOf(boa.get(0).blB()));
            this.mbN.setVisibility(0);
        } else {
            this.mbN.setVisibility(8);
        }
        ap.setBackgroundResource(this.mbN, R.drawable.activity_join_num_bg);
        ap.setViewTextColor(this.mbO, R.color.CAM_X0305, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.mbM);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.mbM);
        }
    }

    public void onChangeSkinType(int i) {
        this.lYy.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mbM);
    }

    public View drP() {
        return this.mbM;
    }
}
