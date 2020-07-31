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
    private TBSpecificationBtn kcN;
    private FrameLayout kcO;
    private TextView kcP;
    private TextView kcQ;
    private com.baidu.tieba.newinterest.c.a kcR;
    private NoScrollGridView kcS;
    private com.baidu.tieba.newinterest.a.a kcT;
    private a kcU;
    private View mRootView;

    /* loaded from: classes17.dex */
    public interface a {
        void el(List<b> list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kcR = new com.baidu.tieba.newinterest.c.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        initUI();
        cfu();
        return this.mRootView;
    }

    private void initUI() {
        this.kcS = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
        this.kcN = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
        this.kcP = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
        this.kcP.setTypeface(Typeface.DEFAULT_BOLD);
        this.kcQ = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
        this.kcO = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.kcN.setTextSize(R.dimen.tbds42);
        this.kcN.setConfig(bVar);
        this.kcN.setText(getResources().getString(R.string.select_interest_introduce));
        this.kcN.setEnabled(false);
        this.kcN.setOnClickListener(this);
        this.kcT = new com.baidu.tieba.newinterest.a.a(this.kcR.cJb(), getContext());
        this.kcS.setAdapter((ListAdapter) this.kcT);
    }

    private void cfu() {
        this.kcT.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kcU != null) {
            this.kcU.el(this.kcT.cIU());
            ap apVar = new ap("c13682");
            apVar.ah("obj_type", 2);
            apVar.ah("obj_locate", 5);
            TiebaStatic.log(apVar);
        }
    }

    @Override // com.baidu.tieba.newinterest.a.a.b
    public void Bm(int i) {
        if (i > 0 && !this.kcN.isEnabled()) {
            this.kcN.setEnabled(true);
            this.kcN.setText(getString(R.string.next_step));
        } else if (i == 0) {
            this.kcN.setEnabled(false);
            this.kcN.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public void a(a aVar) {
        this.kcU = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.kcP, R.color.cp_cont_b);
        ao.setViewTextColor(this.kcQ, R.color.cp_cont_j);
        ao.setBackgroundColor(this.kcO, R.color.cp_bg_line_d);
        this.kcT.notifyDataSetChanged();
    }
}
