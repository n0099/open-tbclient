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
    private TBSpecificationBtn jAV;
    private FrameLayout jAW;
    private TextView jAX;
    private TextView jAY;
    private com.baidu.tieba.newinterest.c.a jAZ;
    private NoScrollGridView jBa;
    private com.baidu.tieba.newinterest.a.a jBb;
    private a jBc;
    private View mRootView;

    /* loaded from: classes10.dex */
    public interface a {
        void dR(List<b> list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jAZ = new com.baidu.tieba.newinterest.c.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        initUI();
        bYI();
        return this.mRootView;
    }

    private void initUI() {
        this.jBa = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
        this.jAV = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
        this.jAX = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
        this.jAX.setTypeface(Typeface.DEFAULT_BOLD);
        this.jAY = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
        this.jAW = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jAV.setTextSize(R.dimen.tbds42);
        this.jAV.setConfig(bVar);
        this.jAV.setText(getResources().getString(R.string.select_interest_introduce));
        this.jAV.setEnabled(false);
        this.jAV.setOnClickListener(this);
        this.jBb = new com.baidu.tieba.newinterest.a.a(this.jAZ.cBb(), getContext());
        this.jBa.setAdapter((ListAdapter) this.jBb);
    }

    private void bYI() {
        this.jBb.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jBc != null) {
            this.jBc.dR(this.jBb.cAU());
            an anVar = new an("c13682");
            anVar.ag("obj_type", 2);
            anVar.ag("obj_locate", 5);
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tieba.newinterest.a.a.b
    public void zL(int i) {
        if (i > 0 && !this.jAV.isEnabled()) {
            this.jAV.setEnabled(true);
            this.jAV.setText(getString(R.string.next_step));
        } else if (i == 0) {
            this.jAV.setEnabled(false);
            this.jAV.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public void a(a aVar) {
        this.jBc = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.jAX, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jAY, (int) R.color.cp_cont_j);
        am.setBackgroundColor(this.jAW, R.color.cp_bg_line_d);
        this.jBb.notifyDataSetChanged();
    }
}
