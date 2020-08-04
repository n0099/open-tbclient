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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.a.a;
import com.baidu.tieba.newinterest.data.b;
import com.baidu.tieba.view.NoScrollGridView;
import java.util.List;
/* loaded from: classes17.dex */
public class InterestSelectionFragment extends BaseFragment implements a.b {
    private TBSpecificationBtn kcP;
    private FrameLayout kcQ;
    private TextView kcR;
    private TextView kcS;
    private com.baidu.tieba.newinterest.c.a kcT;
    private NoScrollGridView kcU;
    private com.baidu.tieba.newinterest.a.a kcV;
    private a kcW;
    private View mRootView;

    /* loaded from: classes17.dex */
    public interface a {
        void el(List<b> list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kcT = new com.baidu.tieba.newinterest.c.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        initUI();
        cfu();
        return this.mRootView;
    }

    private void initUI() {
        this.kcU = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
        this.kcP = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
        this.kcR = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
        this.kcR.setTypeface(Typeface.DEFAULT_BOLD);
        this.kcS = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
        this.kcQ = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.kcP.setTextSize(R.dimen.tbds42);
        this.kcP.setConfig(bVar);
        this.kcP.setText(getResources().getString(R.string.select_interest_introduce));
        this.kcP.setEnabled(false);
        this.kcP.setOnClickListener(this);
        this.kcV = new com.baidu.tieba.newinterest.a.a(this.kcT.cJb(), getContext());
        this.kcU.setAdapter((ListAdapter) this.kcV);
    }

    private void cfu() {
        this.kcV.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kcW != null) {
            this.kcW.el(this.kcV.cIU());
            ap apVar = new ap("c13682");
            apVar.ah("obj_type", 2);
            apVar.ah("obj_locate", 5);
            TiebaStatic.log(apVar);
        }
    }

    @Override // com.baidu.tieba.newinterest.a.a.b
    public void Bm(int i) {
        if (i > 0 && !this.kcP.isEnabled()) {
            this.kcP.setEnabled(true);
            this.kcP.setText(getString(R.string.next_step));
        } else if (i == 0) {
            this.kcP.setEnabled(false);
            this.kcP.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public void a(a aVar) {
        this.kcW = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.kcR, R.color.cp_cont_b);
        ao.setViewTextColor(this.kcS, R.color.cp_cont_j);
        ao.setBackgroundColor(this.kcQ, R.color.cp_bg_line_d);
        this.kcV.notifyDataSetChanged();
    }
}
