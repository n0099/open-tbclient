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
    private com.baidu.tieba.newinterest.c.a liA;
    private NoScrollGridView liB;
    private com.baidu.tieba.newinterest.a.a liC;
    private a liD;
    private TBSpecificationBtn liw;
    private FrameLayout lix;
    private TextView liy;
    private TextView liz;
    private View mRootView;

    /* loaded from: classes23.dex */
    public interface a {
        void eV(List<b> list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.liA = new com.baidu.tieba.newinterest.c.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        initUI();
        cCs();
        return this.mRootView;
    }

    private void initUI() {
        this.liB = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
        this.liw = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
        this.liy = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
        this.liy.setTypeface(Typeface.DEFAULT_BOLD);
        this.liz = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
        this.lix = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.liw.setTextSize(R.dimen.tbds42);
        this.liw.setConfig(aVar);
        this.liw.setText(getResources().getString(R.string.select_interest_introduce));
        this.liw.setEnabled(false);
        this.liw.setOnClickListener(this);
        this.liC = new com.baidu.tieba.newinterest.a.a(this.liA.dgP(), getContext());
        this.liB.setAdapter((ListAdapter) this.liC);
    }

    private void cCs() {
        this.liC.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.liD != null) {
            this.liD.eV(this.liC.dgI());
            aq aqVar = new aq("c13682");
            aqVar.al("obj_type", 2);
            aqVar.al("obj_locate", 5);
            TiebaStatic.log(aqVar);
        }
    }

    @Override // com.baidu.tieba.newinterest.a.a.b
    public void Fs(int i) {
        if (i > 0 && !this.liw.isEnabled()) {
            this.liw.setEnabled(true);
            this.liw.setText(getString(R.string.next_step));
        } else if (i == 0) {
            this.liw.setEnabled(false);
            this.liw.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public void a(a aVar) {
        this.liD = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.liy, R.color.cp_cont_b);
        ap.setViewTextColor(this.liz, R.color.cp_cont_j);
        ap.setBackgroundColor(this.lix, R.color.cp_bg_line_d);
        this.liC.notifyDataSetChanged();
    }
}
