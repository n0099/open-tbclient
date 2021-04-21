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
import d.b.j0.z1.a.a;
import d.b.j0.z1.c.b;
import java.util.List;
/* loaded from: classes3.dex */
public class InterestSelectionFragment extends BaseFragment implements a.c {

    /* renamed from: e  reason: collision with root package name */
    public View f19050e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f19051f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f19052g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19053h;
    public TextView i;
    public d.b.j0.z1.e.a j;
    public NoScrollGridView k;
    public d.b.j0.z1.a.a l;
    public a m;
    public int n;

    /* loaded from: classes3.dex */
    public interface a {
        void a(List<b> list);
    }

    public static InterestSelectionFragment E0(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("scene", i);
        InterestSelectionFragment interestSelectionFragment = new InterestSelectionFragment();
        interestSelectionFragment.setArguments(bundle);
        return interestSelectionFragment;
    }

    @Override // d.b.j0.z1.a.a.c
    public void C0(int i) {
        if (i > 0 && !this.f19051f.isEnabled()) {
            this.f19051f.setEnabled(true);
            this.f19051f.setText(getString(R.string.next_step));
        } else if (i == 0) {
            this.f19051f.setEnabled(false);
            this.f19051f.setText(getResources().getString(R.string.select_interest_introduce));
        }
    }

    public final void F0() {
        this.k = (NoScrollGridView) this.f19050e.findViewById(R.id.interest_selection_grid_view);
        this.f19051f = (TBSpecificationBtn) this.f19050e.findViewById(R.id.interest_selected_btn);
        TextView textView = (TextView) this.f19050e.findViewById(R.id.interest_selection_title);
        this.f19053h = textView;
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        this.i = (TextView) this.f19050e.findViewById(R.id.interest_selection_desc);
        this.f19052g = (FrameLayout) this.f19050e.findViewById(R.id.bottom_select_layout);
        d.b.i0.r.f0.m.a aVar = new d.b.i0.r.f0.m.a();
        this.f19051f.setTextSize(R.dimen.tbds42);
        this.f19051f.setConfig(aVar);
        this.f19051f.setText(getResources().getString(R.string.select_interest_introduce));
        this.f19051f.setEnabled(false);
        this.f19051f.setOnClickListener(this);
        d.b.j0.z1.a.a aVar2 = new d.b.j0.z1.a.a(this.j.c(), getContext());
        this.l = aVar2;
        this.k.setAdapter((ListAdapter) aVar2);
    }

    public final void G0() {
        this.l.g(this);
    }

    public void H0(a aVar) {
        this.m = aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setBackgroundColor(this.f19050e, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f19053h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0107);
        SkinManager.setBackgroundColor(this.f19052g, R.color.CAM_X0201);
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
        this.j = new d.b.j0.z1.e.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f19050e = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
        F0();
        G0();
        if (getArguments() != null) {
            this.n = getArguments().getInt("scene");
        }
        return this.f19050e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getFragmentManager().getFragments().size() == 1) {
            d.b.j0.z1.d.a.b(1, this.n);
        }
    }
}
