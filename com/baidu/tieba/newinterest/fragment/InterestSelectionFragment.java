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
    private TBSpecificationBtn lEU;
    private FrameLayout lEV;
    private TextView lEW;
    private TextView lEX;
    private com.baidu.tieba.newinterest.b.a lEY;
    private NoScrollGridView lEZ;
    private com.baidu.tieba.newinterest.adapter.a lFa;
    private a lFb;
    private View mRootView;

    /* loaded from: classes8.dex */
    public interface a {
        void fe(List<b> list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lEY = new com.baidu.tieba.newinterest.b.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        initUI();
        cGL();
        return this.mRootView;
    }

    private void initUI() {
        this.lEZ = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
        this.lEU = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
        this.lEW = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
        this.lEW.setTypeface(Typeface.DEFAULT_BOLD);
        this.lEX = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
        this.lEV = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.lEU.setTextSize(R.dimen.tbds42);
        this.lEU.setConfig(aVar);
        this.lEU.setText(getResources().getString(R.string.select_interest_introduce));
        this.lEU.setEnabled(false);
        this.lEU.setOnClickListener(this);
        this.lFa = new com.baidu.tieba.newinterest.adapter.a(this.lEY.djt(), getContext());
        this.lEZ.setAdapter((ListAdapter) this.lFa);
    }

    private void cGL() {
        this.lFa.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lFb != null) {
            this.lFb.fe(this.lFa.djm());
            ar arVar = new ar("c13682");
            arVar.ap("obj_type", 2);
            arVar.ap("obj_locate", 5);
            TiebaStatic.log(arVar);
        }
    }

    @Override // com.baidu.tieba.newinterest.adapter.a.b
    public void Fj(int i) {
        if (i > 0 && !this.lEU.isEnabled()) {
            this.lEU.setEnabled(true);
            this.lEU.setText(getString(R.string.next_step));
        } else if (i == 0) {
            this.lEU.setEnabled(false);
            this.lEU.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public void a(a aVar) {
        this.lFb = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setViewTextColor(this.lEW, R.color.CAM_X0105);
        ap.setViewTextColor(this.lEX, R.color.CAM_X0107);
        ap.setBackgroundColor(this.lEV, R.color.CAM_X0201);
        this.lFa.notifyDataSetChanged();
    }
}
