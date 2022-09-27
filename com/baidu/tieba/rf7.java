package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class rf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LabelRecommendActivity a;
    public ViewGroup b;
    public View c;
    public TextView d;
    public NoNetworkView e;
    public TextView f;
    public BdListView g;
    public mf7 h;
    public qf7 i;
    public View.OnClickListener j;
    public List<nf7> k;
    public List<Integer> l;
    public View.OnClickListener m;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rf7 a;

        public a(rf7 rf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rf7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof nf7)) {
                Integer valueOf = Integer.valueOf(((nf7) view2.getTag()).a);
                if (this.a.l.contains(valueOf)) {
                    this.a.l.remove(valueOf);
                } else {
                    this.a.l.add(valueOf);
                }
                this.a.i();
            }
        }
    }

    public rf7(LabelRecommendActivity labelRecommendActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {labelRecommendActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new a(this);
        if (labelRecommendActivity == null) {
            return;
        }
        this.a = labelRecommendActivity;
        g();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public List<Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList(this.l);
            arrayList.add(0, Integer.valueOf(this.i.b()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d003f);
            this.b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f0925ce);
            this.c = this.a.findViewById(R.id.obfuscated_res_0x7f091f7f);
            this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091f01);
            this.e = (NoNetworkView) this.a.findViewById(R.id.obfuscated_res_0x7f0925c6);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091f98);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.c.getLayoutParams().height = UtilHelper.getStatusBarHeight();
            }
            l(0, 0);
            this.g = (BdListView) this.a.findViewById(R.id.obfuscated_res_0x7f091333);
            mf7 mf7Var = new mf7(this.a.getPageContext().getPageActivity());
            this.h = mf7Var;
            mf7Var.b(this.m);
            qf7 qf7Var = new qf7(this.a.getPageContext().getPageActivity());
            this.i = qf7Var;
            this.g.addHeaderView(qf7Var.a());
            this.g.setAdapter((ListAdapter) this.h);
            h();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f, (int) R.drawable.color_sub_lable_selector);
            SkinManager.setBackgroundResource(this.f, R.drawable.bule_bg_commen_label_button);
            this.e.d(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (nf7 nf7Var : this.k) {
                if (nf7Var != null) {
                    nf7Var.c = this.l.contains(Integer.valueOf(nf7Var.a));
                }
            }
            this.h.a(this.k);
            l(this.l.size(), this.k.size());
        }
    }

    public void j(of7 of7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, of7Var) == null) || of7Var == null || of7Var.b() == null || of7Var.a() == null) {
            return;
        }
        for (nf7 nf7Var : of7Var.a()) {
            if (nf7Var != null) {
                nf7Var.c = false;
            }
        }
        this.k.clear();
        this.k.addAll(of7Var.a());
        this.i.d(of7Var.b());
        this.h.a(this.k);
        this.g.setVisibility(0);
        l(0, this.k.size());
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.j = onClickListener;
            this.d.setOnClickListener(onClickListener);
        }
    }

    public final void l(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            this.f.setEnabled(i > 0);
            this.f.setText(this.a.getString(R.string.obfuscated_res_0x7f0f120e, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            this.f.setOnClickListener(i > 0 ? this.j : null);
        }
    }
}
