package com.baidu.tieba.newinterest.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.a.a;
import com.baidu.tieba.newinterest.data.b;
import com.baidu.tieba.view.NoScrollGridView;
import java.util.List;
/* loaded from: classes23.dex */
public class InterestSelectionFragment extends BaseFragment implements a.b {
    private TBSpecificationBtn kQb;
    private FrameLayout kQc;
    private TextView kQd;
    private TextView kQe;
    private com.baidu.tieba.newinterest.c.a kQf;
    private NoScrollGridView kQg;
    private com.baidu.tieba.newinterest.a.a kQh;
    private a kQi;
    private View mRootView;

    /* loaded from: classes23.dex */
    public interface a {
        void eE(List<b> list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kQf = new com.baidu.tieba.newinterest.c.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        initUI();
        cwK();
        return this.mRootView;
    }

    private void initUI() {
        this.kQg = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
        this.kQb = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
        this.kQd = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
        this.kQd.setTypeface(Typeface.DEFAULT_BOLD);
        this.kQe = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
        this.kQc = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.kQb.setTextSize(R.dimen.tbds42);
        this.kQb.setConfig(aVar);
        this.kQb.setText(getResources().getString(R.string.select_interest_introduce));
        this.kQb.setEnabled(false);
        this.kQb.setOnClickListener(this);
        this.kQh = new com.baidu.tieba.newinterest.a.a(this.kQf.dbf(), getContext());
        this.kQg.setAdapter((ListAdapter) this.kQh);
    }

    private void cwK() {
        this.kQh.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kQi != null) {
            this.kQi.eE(this.kQh.daY());
            aq aqVar = new aq("c13682");
            aqVar.aj("obj_type", 2);
            aqVar.aj("obj_locate", 5);
            TiebaStatic.log(aqVar);
        }
    }

    @Override // com.baidu.tieba.newinterest.a.a.b
    public void EM(int i) {
        if (i > 0 && !this.kQb.isEnabled()) {
            this.kQb.setEnabled(true);
            this.kQb.setText(getString(R.string.next_step));
        } else if (i == 0) {
            this.kQb.setEnabled(false);
            this.kQb.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public void a(a aVar) {
        this.kQi = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.kQd, R.color.cp_cont_b);
        ap.setViewTextColor(this.kQe, R.color.cp_cont_j);
        ap.setBackgroundColor(this.kQc, R.color.cp_bg_line_d);
        this.kQh.notifyDataSetChanged();
    }
}
