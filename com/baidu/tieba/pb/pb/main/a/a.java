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
    private com.baidu.tieba.pb.a.c dRh;
    private PbFragment jzy;
    private View jCv = null;
    private View jCw = null;
    private TextView jCx = null;
    private View jCy = null;
    private View jCz = null;
    private View jCA = null;
    private Button jAr = null;

    public a(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.jzy = pbFragment;
        this.dRh = cVar;
        initView();
    }

    private void initView() {
        this.jCv = LayoutInflater.from(this.jzy.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.jCv.setOnTouchListener(this.dRh);
        this.jCw = this.jCv.findViewById(R.id.pb_head_activity_join_number_container);
        this.jCw.setVisibility(8);
        this.jCx = (TextView) this.jCv.findViewById(R.id.pb_head_activity_join_number);
        this.jCy = this.jCv.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.jCz = this.jCv.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.jCv.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public boolean rI(boolean z) {
        boolean z2;
        if (this.jAr != null && this.jAr.getVisibility() == 0) {
            if (this.jCy != null) {
                this.jCy.setVisibility(0);
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            if (this.jCy != null) {
                this.jCy.setVisibility(8);
            }
            z2 = false;
        }
        if ((this.jCA == null || this.jCA.getVisibility() == 8) && z2 && z) {
            this.jCz.setVisibility(0);
        } else {
            this.jCz.setVisibility(8);
        }
        return z2;
    }

    public void e(com.baidu.tieba.pb.data.e eVar, boolean z) {
        boolean rI = rI(z);
        if (eVar != null && eVar.getPage() != null && eVar.getPage().aJB() == 0 && z) {
            if (rI) {
                this.jCz.setVisibility(0);
                return;
            } else {
                this.jCz.setVisibility(8);
                return;
            }
        }
        this.jCz.setVisibility(8);
    }

    public void v(com.baidu.tieba.pb.data.e eVar) {
        ArrayList<com.baidu.tbadk.core.data.b> aKP = eVar.cvu().aKP();
        if (aKP != null && aKP.size() > 0) {
            this.jCx.setText(String.valueOf(aKP.get(0).aID()));
            this.jCw.setVisibility(0);
        } else {
            this.jCw.setVisibility(8);
        }
        am.setBackgroundResource(this.jCw, R.drawable.activity_join_num_bg);
        am.setViewTextColor(this.jCx, R.color.cp_link_tip_d, 1);
    }

    public void b(BdTypeListView bdTypeListView) {
        bdTypeListView.addHeaderView(this.jCv);
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.jCv);
        }
    }

    public void onChangeSkinType(int i) {
        this.jzy.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.jCv);
    }

    public View cBJ() {
        return this.jCv;
    }
}
