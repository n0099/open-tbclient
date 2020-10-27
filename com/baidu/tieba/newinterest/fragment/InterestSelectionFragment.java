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
    private FrameLayout lcA;
    private TextView lcB;
    private TextView lcC;
    private com.baidu.tieba.newinterest.c.a lcD;
    private NoScrollGridView lcE;
    private com.baidu.tieba.newinterest.a.a lcF;
    private a lcG;
    private TBSpecificationBtn lcz;
    private View mRootView;

    /* loaded from: classes23.dex */
    public interface a {
        void eN(List<b> list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lcD = new com.baidu.tieba.newinterest.c.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        initUI();
        czR();
        return this.mRootView;
    }

    private void initUI() {
        this.lcE = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
        this.lcz = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
        this.lcB = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
        this.lcB.setTypeface(Typeface.DEFAULT_BOLD);
        this.lcC = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
        this.lcA = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.lcz.setTextSize(R.dimen.tbds42);
        this.lcz.setConfig(aVar);
        this.lcz.setText(getResources().getString(R.string.select_interest_introduce));
        this.lcz.setEnabled(false);
        this.lcz.setOnClickListener(this);
        this.lcF = new com.baidu.tieba.newinterest.a.a(this.lcD.den(), getContext());
        this.lcE.setAdapter((ListAdapter) this.lcF);
    }

    private void czR() {
        this.lcF.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lcG != null) {
            this.lcG.eN(this.lcF.deg());
            aq aqVar = new aq("c13682");
            aqVar.aj("obj_type", 2);
            aqVar.aj("obj_locate", 5);
            TiebaStatic.log(aqVar);
        }
    }

    @Override // com.baidu.tieba.newinterest.a.a.b
    public void Ff(int i) {
        if (i > 0 && !this.lcz.isEnabled()) {
            this.lcz.setEnabled(true);
            this.lcz.setText(getString(R.string.next_step));
        } else if (i == 0) {
            this.lcz.setEnabled(false);
            this.lcz.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public void a(a aVar) {
        this.lcG = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.lcB, R.color.cp_cont_b);
        ap.setViewTextColor(this.lcC, R.color.cp_cont_j);
        ap.setBackgroundColor(this.lcA, R.color.cp_bg_line_d);
        this.lcF.notifyDataSetChanged();
    }
}
