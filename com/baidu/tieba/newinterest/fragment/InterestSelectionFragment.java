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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.a.a;
import com.baidu.tieba.newinterest.data.b;
import com.baidu.tieba.view.NoScrollGridView;
import java.util.List;
/* loaded from: classes10.dex */
public class InterestSelectionFragment extends BaseFragment implements a.b {
    private TBSpecificationBtn jzP;
    private FrameLayout jzQ;
    private TextView jzR;
    private TextView jzS;
    private com.baidu.tieba.newinterest.c.a jzT;
    private NoScrollGridView jzU;
    private com.baidu.tieba.newinterest.a.a jzV;
    private a jzW;
    private View mRootView;

    /* loaded from: classes10.dex */
    public interface a {
        void dP(List<b> list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jzT = new com.baidu.tieba.newinterest.c.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        initUI();
        cAH();
        return this.mRootView;
    }

    private void initUI() {
        this.jzU = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
        this.jzP = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
        this.jzR = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
        this.jzR.setTypeface(Typeface.DEFAULT_BOLD);
        this.jzS = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
        this.jzQ = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jzP.setTextSize(R.dimen.tbds42);
        this.jzP.setConfig(bVar);
        this.jzP.setText(getResources().getString(R.string.select_interest_introduce));
        this.jzP.setEnabled(false);
        this.jzP.setOnClickListener(this);
        this.jzV = new com.baidu.tieba.newinterest.a.a(this.jzT.cAL(), getContext());
        this.jzU.setAdapter((ListAdapter) this.jzV);
    }

    private void cAH() {
        this.jzV.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jzW != null) {
            this.jzW.dP(this.jzV.cAD());
            an anVar = new an("c13682");
            anVar.ag("obj_type", 2);
            anVar.ag("obj_locate", 5);
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tieba.newinterest.a.a.b
    public void zJ(int i) {
        if (i > 0 && !this.jzP.isEnabled()) {
            this.jzP.setEnabled(true);
            this.jzP.setText(getString(R.string.next_step));
        } else if (i == 0) {
            this.jzP.setEnabled(false);
            this.jzP.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public void a(a aVar) {
        this.jzW = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.jzR, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jzS, (int) R.color.cp_cont_j);
        am.setBackgroundColor(this.jzQ, R.color.cp_bg_line_d);
        this.jzV.notifyDataSetChanged();
    }
}
