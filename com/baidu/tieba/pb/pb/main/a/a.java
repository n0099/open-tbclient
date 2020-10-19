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
/* loaded from: classes22.dex */
public class a {
    private com.baidu.tieba.pb.a.c eTx;
    private PbFragment lin;
    private View llt = null;
    private View llu = null;
    private TextView llv = null;
    private View llw = null;
    private View llx = null;
    private View lly = null;
    private Button lji = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lin = pbFragment;
        this.eTx = cVar;
        initView();
    }

    private void initView() {
        this.llt = LayoutInflater.from(this.lin.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.llt.setOnTouchListener(this.eTx);
        this.llu = this.llt.findViewById(R.id.pb_head_activity_join_number_container);
        this.llu.setVisibility(8);
        this.llv = (TextView) this.llt.findViewById(R.id.pb_head_activity_join_number);
        this.llw = this.llt.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.llx = this.llt.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.llt.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean uA(boolean z) {
        boolean z2;
        if (this.lji != null && this.lji.getVisibility() == 0) {
            if (this.llw != null) {
                this.llw.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.llw != null) {
                this.llw.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.lly == null || this.lly.getVisibility() == 8) && z2 && z) {
            this.llx.setVisibility(0);
        } else {
            this.llx.setVisibility(8);
        }
        return z2;
    }

    public void e(f fVar, boolean z) {
        boolean uA = uA(z);
        if (fVar != null && fVar.getPage() != null && fVar.getPage().bgY() == 0 && z) {
            if (uA) {
                this.llx.setVisibility(0);
                return;
            } else {
                this.llx.setVisibility(8);
                return;
            }
        }
        this.llx.setVisibility(8);
    }

    public void z(f fVar) {
        ArrayList<com.baidu.tbadk.core.data.a> bir = fVar.dcA().bir();
        if (bir != null && bir.size() > 0) {
            this.llv.setText(String.valueOf(bir.get(0).bfW()));
            this.llu.setVisibility(0);
        } else {
            this.llu.setVisibility(8);
        }
        ap.setBackgroundResource(this.llu, R.drawable.activity_join_num_bg);
        ap.setViewTextColor(this.llv, R.color.cp_link_tip_d, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.llt);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.llt);
        }
    }

    public void onChangeSkinType(int i) {
        this.lin.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.llt);
    }

    public View djc() {
        return this.llt;
    }
}
