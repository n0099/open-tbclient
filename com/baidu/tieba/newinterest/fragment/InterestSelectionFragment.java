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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NoScrollGridView;
import d.a.n0.a2.a.a;
import d.a.n0.a2.c.b;
import java.util.List;
/* loaded from: classes4.dex */
public class InterestSelectionFragment extends BaseFragment implements a.c {

    /* renamed from: e  reason: collision with root package name */
    public View f18704e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f18705f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f18706g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18707h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f18708i;
    public d.a.n0.a2.e.a j;
    public NoScrollGridView k;
    public d.a.n0.a2.a.a l;
    public a m;
    public int n;

    /* loaded from: classes4.dex */
    public interface a {
        void a(List<b> list);
    }

    public static InterestSelectionFragment D0(int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("scene", i2);
        InterestSelectionFragment interestSelectionFragment = new InterestSelectionFragment();
        interestSelectionFragment.setArguments(bundle);
        return interestSelectionFragment;
    }

    @Override // d.a.n0.a2.a.a.c
    public void C0(int i2) {
        if (i2 > 0 && !this.f18705f.isEnabled()) {
            this.f18705f.setEnabled(true);
            this.f18705f.setText(getString(R.string.next_step));
        } else if (i2 == 0) {
            this.f18705f.setEnabled(false);
            this.f18705f.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public final void E0() {
        this.k = (NoScrollGridView) this.f18704e.findViewById(R.id.interest_selection_grid_view);
        this.f18705f = (TBSpecificationBtn) this.f18704e.findViewById(R.id.interest_selected_btn);
        TextView textView = (TextView) this.f18704e.findViewById(R.id.interest_selection_title);
        this.f18707h = textView;
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        this.f18708i = (TextView) this.f18704e.findViewById(R.id.interest_selection_desc);
        this.f18706g = (FrameLayout) this.f18704e.findViewById(R.id.bottom_select_layout);
        d.a.m0.r.f0.m.a aVar = new d.a.m0.r.f0.m.a();
        this.f18705f.setTextSize(R.dimen.tbds42);
        this.f18705f.setConfig(aVar);
        this.f18705f.setText(getResources().getString(R.string.select_interest_introduce));
        this.f18705f.setEnabled(false);
        this.f18705f.setOnClickListener(this);
        d.a.n0.a2.a.a aVar2 = new d.a.n0.a2.a.a(this.j.c(), getContext());
        this.l = aVar2;
        this.k.setAdapter((ListAdapter) aVar2);
    }

    public final void F0() {
        this.l.g(this);
    }

    public void G0(a aVar) {
        this.m = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        SkinManager.setBackgroundColor(this.f18704e, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f18707h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f18708i, R.color.CAM_X0107);
        SkinManager.setBackgroundColor(this.f18706g, R.color.CAM_X0201);
        this.l.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar = this.m;
        if (aVar != null) {
            aVar.a(this.l.f());
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 5);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j = new d.a.n0.a2.e.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f18704e = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        E0();
        F0();
        if (getArguments() != null) {
            this.n = getArguments().getInt("scene");
        }
        return this.f18704e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getFragmentManager().getFragments().size() == 1) {
            d.a.n0.a2.d.a.b(1, this.n);
        }
    }
}
