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
/* loaded from: classes7.dex */
public class InterestSelectionFragment extends BaseFragment implements a.b {
    private TBSpecificationBtn lHk;
    private FrameLayout lHl;
    private TextView lHm;
    private TextView lHn;
    private com.baidu.tieba.newinterest.b.a lHo;
    private NoScrollGridView lHp;
    private com.baidu.tieba.newinterest.adapter.a lHq;
    private a lHr;
    private View mRootView;

    /* loaded from: classes7.dex */
    public interface a {
        void fe(List<b> list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lHo = new com.baidu.tieba.newinterest.b.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        initUI();
        cGY();
        return this.mRootView;
    }

    private void initUI() {
        this.lHp = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
        this.lHk = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
        this.lHm = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
        this.lHm.setTypeface(Typeface.DEFAULT_BOLD);
        this.lHn = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
        this.lHl = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.lHk.setTextSize(R.dimen.tbds42);
        this.lHk.setConfig(aVar);
        this.lHk.setText(getResources().getString(R.string.select_interest_introduce));
        this.lHk.setEnabled(false);
        this.lHk.setOnClickListener(this);
        this.lHq = new com.baidu.tieba.newinterest.adapter.a(this.lHo.djJ(), getContext());
        this.lHp.setAdapter((ListAdapter) this.lHq);
    }

    private void cGY() {
        this.lHq.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lHr != null) {
            this.lHr.fe(this.lHq.djC());
            ar arVar = new ar("c13682");
            arVar.aq("obj_type", 2);
            arVar.aq("obj_locate", 5);
            TiebaStatic.log(arVar);
        }
    }

    @Override // com.baidu.tieba.newinterest.adapter.a.b
    public void Fm(int i) {
        if (i > 0 && !this.lHk.isEnabled()) {
            this.lHk.setEnabled(true);
            this.lHk.setText(getString(R.string.next_step));
        } else if (i == 0) {
            this.lHk.setEnabled(false);
            this.lHk.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public void a(a aVar) {
        this.lHr = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setViewTextColor(this.lHm, R.color.CAM_X0105);
        ap.setViewTextColor(this.lHn, R.color.CAM_X0107);
        ap.setBackgroundColor(this.lHl, R.color.CAM_X0201);
        this.lHq.notifyDataSetChanged();
    }
}
