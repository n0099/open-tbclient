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
    private TBSpecificationBtn lwm;
    private FrameLayout lwn;
    private TextView lwo;
    private TextView lwp;
    private com.baidu.tieba.newinterest.c.a lwq;
    private NoScrollGridView lwr;
    private com.baidu.tieba.newinterest.a.a lws;
    private a lwt;
    private View mRootView;

    /* loaded from: classes23.dex */
    public interface a {
        void fg(List<b> list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lwq = new com.baidu.tieba.newinterest.c.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        initUI();
        cGp();
        return this.mRootView;
    }

    private void initUI() {
        this.lwr = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
        this.lwm = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
        this.lwo = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
        this.lwo.setTypeface(Typeface.DEFAULT_BOLD);
        this.lwp = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
        this.lwn = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.lwm.setTextSize(R.dimen.tbds42);
        this.lwm.setConfig(aVar);
        this.lwm.setText(getResources().getString(R.string.select_interest_introduce));
        this.lwm.setEnabled(false);
        this.lwm.setOnClickListener(this);
        this.lws = new com.baidu.tieba.newinterest.a.a(this.lwq.dly(), getContext());
        this.lwr.setAdapter((ListAdapter) this.lws);
    }

    private void cGp() {
        this.lws.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lwt != null) {
            this.lwt.fg(this.lws.dlr());
            ar arVar = new ar("c13682");
            arVar.al("obj_type", 2);
            arVar.al("obj_locate", 5);
            TiebaStatic.log(arVar);
        }
    }

    @Override // com.baidu.tieba.newinterest.a.a.b
    public void GF(int i) {
        if (i > 0 && !this.lwm.isEnabled()) {
            this.lwm.setEnabled(true);
            this.lwm.setText(getString(R.string.next_step));
        } else if (i == 0) {
            this.lwm.setEnabled(false);
            this.lwm.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public void a(a aVar) {
        this.lwt = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setViewTextColor(this.lwo, R.color.CAM_X0105);
        ap.setViewTextColor(this.lwp, R.color.CAM_X0107);
        ap.setBackgroundColor(this.lwn, R.color.CAM_X0201);
        this.lws.notifyDataSetChanged();
    }
}
