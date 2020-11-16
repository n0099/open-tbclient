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
/* loaded from: classes21.dex */
public class a {
    private com.baidu.tieba.pb.a.c fgS;
    private PbFragment lBf;
    private View lEl = null;
    private View lEm = null;
    private TextView lEn = null;
    private View lEo = null;
    private View lEp = null;
    private View lEq = null;
    private Button lCa = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lBf = pbFragment;
        this.fgS = cVar;
        initView();
    }

    private void initView() {
        this.lEl = LayoutInflater.from(this.lBf.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.lEl.setOnTouchListener(this.fgS);
        this.lEm = this.lEl.findViewById(R.id.pb_head_activity_join_number_container);
        this.lEm.setVisibility(8);
        this.lEn = (TextView) this.lEl.findViewById(R.id.pb_head_activity_join_number);
        this.lEo = this.lEl.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.lEp = this.lEl.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.lEl.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean vd(boolean z) {
        boolean z2;
        if (this.lCa != null && this.lCa.getVisibility() == 0) {
            if (this.lEo != null) {
                this.lEo.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.lEo != null) {
                this.lEo.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.lEq == null || this.lEq.getVisibility() == 8) && z2 && z) {
            this.lEp.setVisibility(0);
        } else {
            this.lEp.setVisibility(8);
        }
        return z2;
    }

    public void e(f fVar, boolean z) {
        boolean vd = vd(z);
        if (fVar != null && fVar.getPage() != null && fVar.getPage().bkt() == 0 && z) {
            if (vd) {
                this.lEp.setVisibility(0);
                return;
            } else {
                this.lEp.setVisibility(8);
                return;
            }
        }
        this.lEp.setVisibility(8);
    }

    public void B(f fVar) {
        ArrayList<com.baidu.tbadk.core.data.b> blM = fVar.dhH().blM();
        if (blM != null && blM.size() > 0) {
            this.lEn.setText(String.valueOf(blM.get(0).bjr()));
            this.lEm.setVisibility(0);
        } else {
            this.lEm.setVisibility(8);
        }
        ap.setBackgroundResource(this.lEm, R.drawable.activity_join_num_bg);
        ap.setViewTextColor(this.lEn, R.color.CAM_X0305, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.lEl);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.lEl);
        }
    }

    public void onChangeSkinType(int i) {
        this.lBf.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lEl);
    }

    public View dol() {
        return this.lEl;
    }
}
