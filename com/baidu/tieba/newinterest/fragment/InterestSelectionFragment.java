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
/* loaded from: classes17.dex */
public class InterestSelectionFragment extends BaseFragment implements a.b {
    private TBSpecificationBtn ksr;
    private FrameLayout kss;
    private TextView kst;
    private TextView ksu;
    private com.baidu.tieba.newinterest.c.a ksv;
    private NoScrollGridView ksw;
    private com.baidu.tieba.newinterest.a.a ksx;
    private a ksy;
    private View mRootView;

    /* loaded from: classes17.dex */
    public interface a {
        void et(List<b> list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ksv = new com.baidu.tieba.newinterest.c.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        initUI();
        cqa();
        return this.mRootView;
    }

    private void initUI() {
        this.ksw = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
        this.ksr = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
        this.kst = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
        this.kst.setTypeface(Typeface.DEFAULT_BOLD);
        this.ksu = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
        this.kss = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.ksr.setTextSize(R.dimen.tbds42);
        this.ksr.setConfig(aVar);
        this.ksr.setText(getResources().getString(R.string.select_interest_introduce));
        this.ksr.setEnabled(false);
        this.ksr.setOnClickListener(this);
        this.ksx = new com.baidu.tieba.newinterest.a.a(this.ksv.cTR(), getContext());
        this.ksw.setAdapter((ListAdapter) this.ksx);
    }

    private void cqa() {
        this.ksx.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ksy != null) {
            this.ksy.et(this.ksx.cTK());
            aq aqVar = new aq("c13682");
            aqVar.ai("obj_type", 2);
            aqVar.ai("obj_locate", 5);
            TiebaStatic.log(aqVar);
        }
    }

    @Override // com.baidu.tieba.newinterest.a.a.b
    public void DF(int i) {
        if (i > 0 && !this.ksr.isEnabled()) {
            this.ksr.setEnabled(true);
            this.ksr.setText(getString(R.string.next_step));
        } else if (i == 0) {
            this.ksr.setEnabled(false);
            this.ksr.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public void a(a aVar) {
        this.ksy = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.kst, R.color.cp_cont_b);
        ap.setViewTextColor(this.ksu, R.color.cp_cont_j);
        ap.setBackgroundColor(this.kss, R.color.cp_bg_line_d);
        this.ksx.notifyDataSetChanged();
    }
}
