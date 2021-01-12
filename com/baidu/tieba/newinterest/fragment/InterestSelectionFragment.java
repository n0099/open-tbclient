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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.adapter.a;
import com.baidu.tieba.newinterest.data.b;
import com.baidu.tieba.view.NoScrollGridView;
import java.util.List;
/* loaded from: classes7.dex */
public class InterestSelectionFragment extends BaseFragment implements a.b {
    private TBSpecificationBtn lwQ;
    private FrameLayout lwR;
    private TextView lwS;
    private TextView lwT;
    private com.baidu.tieba.newinterest.b.a lwU;
    private NoScrollGridView lwV;
    private com.baidu.tieba.newinterest.adapter.a lwW;
    private a lwX;
    private View mRootView;

    /* loaded from: classes7.dex */
    public interface a {
        void fg(List<b> list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lwU = new com.baidu.tieba.newinterest.b.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        initUI();
        cFy();
        return this.mRootView;
    }

    private void initUI() {
        this.lwV = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
        this.lwQ = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
        this.lwS = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
        this.lwS.setTypeface(Typeface.DEFAULT_BOLD);
        this.lwT = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
        this.lwR = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.lwQ.setTextSize(R.dimen.tbds42);
        this.lwQ.setConfig(aVar);
        this.lwQ.setText(getResources().getString(R.string.select_interest_introduce));
        this.lwQ.setEnabled(false);
        this.lwQ.setOnClickListener(this);
        this.lwW = new com.baidu.tieba.newinterest.adapter.a(this.lwU.dhs(), getContext());
        this.lwV.setAdapter((ListAdapter) this.lwW);
    }

    private void cFy() {
        this.lwW.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lwX != null) {
            this.lwX.fg(this.lwW.dhl());
            aq aqVar = new aq("c13682");
            aqVar.an("obj_type", 2);
            aqVar.an("obj_locate", 5);
            TiebaStatic.log(aqVar);
        }
    }

    @Override // com.baidu.tieba.newinterest.adapter.a.b
    public void ER(int i) {
        if (i > 0 && !this.lwQ.isEnabled()) {
            this.lwQ.setEnabled(true);
            this.lwQ.setText(getString(R.string.next_step));
        } else if (i == 0) {
            this.lwQ.setEnabled(false);
            this.lwQ.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public void a(a aVar) {
        this.lwX = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ao.setViewTextColor(this.lwS, R.color.CAM_X0105);
        ao.setViewTextColor(this.lwT, R.color.CAM_X0107);
        ao.setBackgroundColor(this.lwR, R.color.CAM_X0201);
        this.lwW.notifyDataSetChanged();
    }
}
