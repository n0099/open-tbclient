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
/* loaded from: classes23.dex */
public class InterestSelectionFragment extends BaseFragment implements a.b {
    private TBSpecificationBtn lwo;
    private FrameLayout lwp;
    private TextView lwq;
    private TextView lwr;
    private com.baidu.tieba.newinterest.c.a lws;
    private NoScrollGridView lwt;
    private com.baidu.tieba.newinterest.a.a lwu;
    private a lwv;
    private View mRootView;

    /* loaded from: classes23.dex */
    public interface a {
        void fg(List<b> list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lws = new com.baidu.tieba.newinterest.c.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        initUI();
        cGq();
        return this.mRootView;
    }

    private void initUI() {
        this.lwt = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
        this.lwo = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
        this.lwq = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
        this.lwq.setTypeface(Typeface.DEFAULT_BOLD);
        this.lwr = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
        this.lwp = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.lwo.setTextSize(R.dimen.tbds42);
        this.lwo.setConfig(aVar);
        this.lwo.setText(getResources().getString(R.string.select_interest_introduce));
        this.lwo.setEnabled(false);
        this.lwo.setOnClickListener(this);
        this.lwu = new com.baidu.tieba.newinterest.a.a(this.lws.dlz(), getContext());
        this.lwt.setAdapter((ListAdapter) this.lwu);
    }

    private void cGq() {
        this.lwu.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lwv != null) {
            this.lwv.fg(this.lwu.dls());
            ar arVar = new ar("c13682");
            arVar.al("obj_type", 2);
            arVar.al("obj_locate", 5);
            TiebaStatic.log(arVar);
        }
    }

    @Override // com.baidu.tieba.newinterest.a.a.b
    public void GF(int i) {
        if (i > 0 && !this.lwo.isEnabled()) {
            this.lwo.setEnabled(true);
            this.lwo.setText(getString(R.string.next_step));
        } else if (i == 0) {
            this.lwo.setEnabled(false);
            this.lwo.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public void a(a aVar) {
        this.lwv = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setViewTextColor(this.lwq, R.color.CAM_X0105);
        ap.setViewTextColor(this.lwr, R.color.CAM_X0107);
        ap.setBackgroundColor(this.lwp, R.color.CAM_X0201);
        this.lwu.notifyDataSetChanged();
    }
}
