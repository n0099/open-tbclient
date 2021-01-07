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
/* loaded from: classes8.dex */
public class InterestSelectionFragment extends BaseFragment implements a.b {
    private com.baidu.tieba.newinterest.b.a lBA;
    private NoScrollGridView lBB;
    private com.baidu.tieba.newinterest.adapter.a lBC;
    private a lBD;
    private TBSpecificationBtn lBw;
    private FrameLayout lBx;
    private TextView lBy;
    private TextView lBz;
    private View mRootView;

    /* loaded from: classes8.dex */
    public interface a {
        void fg(List<b> list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lBA = new com.baidu.tieba.newinterest.b.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        initUI();
        cJq();
        return this.mRootView;
    }

    private void initUI() {
        this.lBB = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
        this.lBw = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
        this.lBy = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
        this.lBy.setTypeface(Typeface.DEFAULT_BOLD);
        this.lBz = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
        this.lBx = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.lBw.setTextSize(R.dimen.tbds42);
        this.lBw.setConfig(aVar);
        this.lBw.setText(getResources().getString(R.string.select_interest_introduce));
        this.lBw.setEnabled(false);
        this.lBw.setOnClickListener(this);
        this.lBC = new com.baidu.tieba.newinterest.adapter.a(this.lBA.dlk(), getContext());
        this.lBB.setAdapter((ListAdapter) this.lBC);
    }

    private void cJq() {
        this.lBC.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lBD != null) {
            this.lBD.fg(this.lBC.dld());
            aq aqVar = new aq("c13682");
            aqVar.an("obj_type", 2);
            aqVar.an("obj_locate", 5);
            TiebaStatic.log(aqVar);
        }
    }

    @Override // com.baidu.tieba.newinterest.adapter.a.b
    public void Gx(int i) {
        if (i > 0 && !this.lBw.isEnabled()) {
            this.lBw.setEnabled(true);
            this.lBw.setText(getString(R.string.next_step));
        } else if (i == 0) {
            this.lBw.setEnabled(false);
            this.lBw.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public void a(a aVar) {
        this.lBD = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ao.setViewTextColor(this.lBy, R.color.CAM_X0105);
        ao.setViewTextColor(this.lBz, R.color.CAM_X0107);
        ao.setBackgroundColor(this.lBx, R.color.CAM_X0201);
        this.lBC.notifyDataSetChanged();
    }
}
