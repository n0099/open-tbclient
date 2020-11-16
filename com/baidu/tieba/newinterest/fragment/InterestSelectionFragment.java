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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.a.a;
import com.baidu.tieba.newinterest.data.b;
import com.baidu.tieba.view.NoScrollGridView;
import java.util.List;
/* loaded from: classes22.dex */
public class InterestSelectionFragment extends BaseFragment implements a.b {
    private TBSpecificationBtn liN;
    private FrameLayout liO;
    private TextView liP;
    private TextView liQ;
    private com.baidu.tieba.newinterest.c.a liR;
    private NoScrollGridView liS;
    private com.baidu.tieba.newinterest.a.a liT;
    private a liU;
    private View mRootView;

    /* loaded from: classes22.dex */
    public interface a {
        void eV(List<b> list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.liR = new com.baidu.tieba.newinterest.c.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        initUI();
        cBW();
        return this.mRootView;
    }

    private void initUI() {
        this.liS = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
        this.liN = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
        this.liP = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
        this.liP.setTypeface(Typeface.DEFAULT_BOLD);
        this.liQ = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
        this.liO = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.liN.setTextSize(R.dimen.tbds42);
        this.liN.setConfig(aVar);
        this.liN.setText(getResources().getString(R.string.select_interest_introduce));
        this.liN.setEnabled(false);
        this.liN.setOnClickListener(this);
        this.liT = new com.baidu.tieba.newinterest.a.a(this.liR.dgm(), getContext());
        this.liS.setAdapter((ListAdapter) this.liT);
    }

    private void cBW() {
        this.liT.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.liU != null) {
            this.liU.eV(this.liT.dgf());
            ar arVar = new ar("c13682");
            arVar.ak("obj_type", 2);
            arVar.ak("obj_locate", 5);
            TiebaStatic.log(arVar);
        }
    }

    @Override // com.baidu.tieba.newinterest.a.a.b
    public void FQ(int i) {
        if (i > 0 && !this.liN.isEnabled()) {
            this.liN.setEnabled(true);
            this.liN.setText(getString(R.string.next_step));
        } else if (i == 0) {
            this.liN.setEnabled(false);
            this.liN.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public void a(a aVar) {
        this.liU = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setViewTextColor(this.liP, R.color.CAM_X0105);
        ap.setViewTextColor(this.liQ, R.color.CAM_X0107);
        ap.setBackgroundColor(this.liO, R.color.CAM_X0201);
        this.liT.notifyDataSetChanged();
    }
}
