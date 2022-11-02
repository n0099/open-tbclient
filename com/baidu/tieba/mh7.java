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
public class mh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LabelRecommendActivity a;
    public ViewGroup b;
    public View c;
    public TextView d;
    public NoNetworkView e;
    public TextView f;
    public BdListView g;
    public hh7 h;
    public lh7 i;
    public View.OnClickListener j;
    public List<ih7> k;
    public List<Integer> l;
    public View.OnClickListener m;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh7 a;

        public a(mh7 mh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mh7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof ih7)) {
                Integer valueOf = Integer.valueOf(((ih7) view2.getTag()).a);
                if (this.a.l.contains(valueOf)) {
                    this.a.l.remove(valueOf);
                } else {
                    this.a.l.add(valueOf);
                }
                this.a.i();
            }
        }
    }

    public mh7(LabelRecommendActivity labelRecommendActivity) {
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

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.j = onClickListener;
            this.d.setOnClickListener(onClickListener);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d003f);
            this.b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f09260e);
            this.c = this.a.findViewById(R.id.obfuscated_res_0x7f091fcb);
            this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091f4c);
            this.e = (NoNetworkView) this.a.findViewById(R.id.obfuscated_res_0x7f092606);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091fe4);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.c.getLayoutParams().height = UtilHelper.getStatusBarHeight();
            }
            l(0, 0);
            this.g = (BdListView) this.a.findViewById(R.id.obfuscated_res_0x7f091361);
            hh7 hh7Var = new hh7(this.a.getPageContext().getPageActivity());
            this.h = hh7Var;
            hh7Var.b(this.m);
            lh7 lh7Var = new lh7(this.a.getPageContext().getPageActivity());
            this.i = lh7Var;
            this.g.addHeaderView(lh7Var.a());
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
            for (ih7 ih7Var : this.k) {
                if (ih7Var != null) {
                    ih7Var.c = this.l.contains(Integer.valueOf(ih7Var.a));
                }
            }
            this.h.a(this.k);
            l(this.l.size(), this.k.size());
        }
    }

    public void j(jh7 jh7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, jh7Var) == null) && jh7Var != null && jh7Var.b() != null && jh7Var.a() != null) {
            for (ih7 ih7Var : jh7Var.a()) {
                if (ih7Var != null) {
                    ih7Var.c = false;
                }
            }
            this.k.clear();
            this.k.addAll(jh7Var.a());
            this.i.d(jh7Var.b());
            this.h.a(this.k);
            this.g.setVisibility(0);
            l(0, this.k.size());
        }
    }

    public final void l(int i, int i2) {
        boolean z;
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            TextView textView = this.f;
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            textView.setEnabled(z);
            this.f.setText(this.a.getString(R.string.obfuscated_res_0x7f0f1241, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            TextView textView2 = this.f;
            if (i > 0) {
                onClickListener = this.j;
            } else {
                onClickListener = null;
            }
            textView2.setOnClickListener(onClickListener);
        }
    }
}
