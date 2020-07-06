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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.a.a;
import com.baidu.tieba.newinterest.data.b;
import com.baidu.tieba.view.NoScrollGridView;
import java.util.List;
/* loaded from: classes10.dex */
public class InterestSelectionFragment extends BaseFragment implements a.b {
    private TBSpecificationBtn jUo;
    private FrameLayout jUp;
    private TextView jUq;
    private TextView jUr;
    private com.baidu.tieba.newinterest.c.a jUs;
    private NoScrollGridView jUt;
    private com.baidu.tieba.newinterest.a.a jUu;
    private a jUv;
    private View mRootView;

    /* loaded from: classes10.dex */
    public interface a {
        void ef(List<b> list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jUs = new com.baidu.tieba.newinterest.c.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        initUI();
        cbW();
        return this.mRootView;
    }

    private void initUI() {
        this.jUt = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
        this.jUo = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
        this.jUq = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
        this.jUq.setTypeface(Typeface.DEFAULT_BOLD);
        this.jUr = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
        this.jUp = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jUo.setTextSize(R.dimen.tbds42);
        this.jUo.setConfig(bVar);
        this.jUo.setText(getResources().getString(R.string.select_interest_introduce));
        this.jUo.setEnabled(false);
        this.jUo.setOnClickListener(this);
        this.jUu = new com.baidu.tieba.newinterest.a.a(this.jUs.cFs(), getContext());
        this.jUt.setAdapter((ListAdapter) this.jUu);
    }

    private void cbW() {
        this.jUu.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jUv != null) {
            this.jUv.ef(this.jUu.cFl());
            ao aoVar = new ao("c13682");
            aoVar.ag("obj_type", 2);
            aoVar.ag("obj_locate", 5);
            TiebaStatic.log(aoVar);
        }
    }

    @Override // com.baidu.tieba.newinterest.a.a.b
    public void AN(int i) {
        if (i > 0 && !this.jUo.isEnabled()) {
            this.jUo.setEnabled(true);
            this.jUo.setText(getString(R.string.next_step));
        } else if (i == 0) {
            this.jUo.setEnabled(false);
            this.jUo.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public void a(a aVar) {
        this.jUv = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        an.setViewTextColor(this.jUq, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.jUr, (int) R.color.cp_cont_j);
        an.setBackgroundColor(this.jUp, R.color.cp_bg_line_d);
        this.jUu.notifyDataSetChanged();
    }
}
