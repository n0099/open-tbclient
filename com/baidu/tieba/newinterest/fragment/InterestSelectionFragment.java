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
/* loaded from: classes22.dex */
public class InterestSelectionFragment extends BaseFragment implements a.b {
    private TBSpecificationBtn kAQ;
    private FrameLayout kAR;
    private TextView kAS;
    private TextView kAT;
    private com.baidu.tieba.newinterest.c.a kAU;
    private NoScrollGridView kAV;
    private com.baidu.tieba.newinterest.a.a kAW;
    private a kAX;
    private View mRootView;

    /* loaded from: classes22.dex */
    public interface a {
        void eB(List<b> list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kAU = new com.baidu.tieba.newinterest.c.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        initUI();
        ctn();
        return this.mRootView;
    }

    private void initUI() {
        this.kAV = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
        this.kAQ = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
        this.kAS = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
        this.kAS.setTypeface(Typeface.DEFAULT_BOLD);
        this.kAT = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
        this.kAR = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.kAQ.setTextSize(R.dimen.tbds42);
        this.kAQ.setConfig(aVar);
        this.kAQ.setText(getResources().getString(R.string.select_interest_introduce));
        this.kAQ.setEnabled(false);
        this.kAQ.setOnClickListener(this);
        this.kAW = new com.baidu.tieba.newinterest.a.a(this.kAU.cXw(), getContext());
        this.kAV.setAdapter((ListAdapter) this.kAW);
    }

    private void ctn() {
        this.kAW.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kAX != null) {
            this.kAX.eB(this.kAW.cXp());
            aq aqVar = new aq("c13682");
            aqVar.ai("obj_type", 2);
            aqVar.ai("obj_locate", 5);
            TiebaStatic.log(aqVar);
        }
    }

    @Override // com.baidu.tieba.newinterest.a.a.b
    public void Eg(int i) {
        if (i > 0 && !this.kAQ.isEnabled()) {
            this.kAQ.setEnabled(true);
            this.kAQ.setText(getString(R.string.next_step));
        } else if (i == 0) {
            this.kAQ.setEnabled(false);
            this.kAQ.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public void a(a aVar) {
        this.kAX = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.kAS, R.color.cp_cont_b);
        ap.setViewTextColor(this.kAT, R.color.cp_cont_j);
        ap.setBackgroundColor(this.kAR, R.color.cp_bg_line_d);
        this.kAW.notifyDataSetChanged();
    }
}
