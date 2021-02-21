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
import com.baidu.tieba.newinterest.adapter.a;
import com.baidu.tieba.newinterest.data.b;
import com.baidu.tieba.view.NoScrollGridView;
import java.util.List;
/* loaded from: classes8.dex */
public class InterestSelectionFragment extends BaseFragment implements a.b {
    private TBSpecificationBtn lFi;
    private FrameLayout lFj;
    private TextView lFk;
    private TextView lFl;
    private com.baidu.tieba.newinterest.b.a lFm;
    private NoScrollGridView lFn;
    private com.baidu.tieba.newinterest.adapter.a lFo;
    private a lFp;
    private View mRootView;

    /* loaded from: classes8.dex */
    public interface a {
        void fe(List<b> list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lFm = new com.baidu.tieba.newinterest.b.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        initUI();
        cGS();
        return this.mRootView;
    }

    private void initUI() {
        this.lFn = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
        this.lFi = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
        this.lFk = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
        this.lFk.setTypeface(Typeface.DEFAULT_BOLD);
        this.lFl = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
        this.lFj = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.lFi.setTextSize(R.dimen.tbds42);
        this.lFi.setConfig(aVar);
        this.lFi.setText(getResources().getString(R.string.select_interest_introduce));
        this.lFi.setEnabled(false);
        this.lFi.setOnClickListener(this);
        this.lFo = new com.baidu.tieba.newinterest.adapter.a(this.lFm.djA(), getContext());
        this.lFn.setAdapter((ListAdapter) this.lFo);
    }

    private void cGS() {
        this.lFo.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lFp != null) {
            this.lFp.fe(this.lFo.djt());
            ar arVar = new ar("c13682");
            arVar.ap("obj_type", 2);
            arVar.ap("obj_locate", 5);
            TiebaStatic.log(arVar);
        }
    }

    @Override // com.baidu.tieba.newinterest.adapter.a.b
    public void Fj(int i) {
        if (i > 0 && !this.lFi.isEnabled()) {
            this.lFi.setEnabled(true);
            this.lFi.setText(getString(R.string.next_step));
        } else if (i == 0) {
            this.lFi.setEnabled(false);
            this.lFi.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public void a(a aVar) {
        this.lFp = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setViewTextColor(this.lFk, R.color.CAM_X0105);
        ap.setViewTextColor(this.lFl, R.color.CAM_X0107);
        ap.setBackgroundColor(this.lFj, R.color.CAM_X0201);
        this.lFo.notifyDataSetChanged();
    }
}
