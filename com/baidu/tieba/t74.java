package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.games.view.recommend.listmode.ListRecommendAdapter;
import com.baidu.swan.games.view.recommend.listmode.ListRecommendDivider;
import com.baidu.tieba.j33;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class t74 extends m74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j33 j;
    public View k;
    public View l;
    public ImageView m;
    public View n;
    public RecyclerView o;
    public ListRecommendAdapter p;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t74 a;

        public a(t74 t74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t74Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.c != null) {
                    this.a.c.b();
                }
                this.a.B();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ListRecommendAdapter.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t74 a;

        public b(t74 t74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t74Var;
        }

        @Override // com.baidu.swan.games.view.recommend.listmode.ListRecommendAdapter.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.c != null) {
                    this.a.c.u(i);
                }
                this.a.y();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t74 a;

        public c(t74 t74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t74Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.b != null && this.a.c != null) {
                    this.a.c.o();
                }
                this.a.y();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t74 a;

        public d(t74 t74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t74Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.y();
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t74 a;

        public e(t74 t74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t74Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.n.getLayoutParams();
                layoutParams.width = this.a.l.getWidth();
                int height = this.a.l.getHeight();
                layoutParams.height = height;
                layoutParams.topMargin = -height;
                this.a.n.setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t74(@NonNull Context context, @NonNull p74 p74Var) {
        super(context, p74Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, p74Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (p74) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.m74, com.baidu.tieba.n74
    public void d(u74 u74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, u74Var) == null) {
            super.d(u74Var);
            this.p.g(u74Var);
            D();
        }
    }

    public final void A(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            view2.setOnClickListener(new a(this));
            this.p.f(new b(this));
            this.k.findViewById(R.id.obfuscated_res_0x7f09204c).setOnClickListener(new c(this));
            this.m.setOnClickListener(new d(this));
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C();
            j33 j33Var = this.j;
            if (j33Var != null) {
                j33Var.show();
            }
        }
    }

    public final void y() {
        j33 j33Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (j33Var = this.j) != null) {
            j33Var.dismiss();
        }
    }

    public final void C() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean a2 = mn2.M().a();
            this.n.setVisibility(8);
            ImageView imageView = this.m;
            if (a2) {
                i = R.drawable.obfuscated_res_0x7f081231;
            } else {
                i = R.drawable.obfuscated_res_0x7f081230;
            }
            imageView.setImageResource(i);
            if (a2) {
                this.l.post(new e(this));
            }
        }
    }

    public final void D() {
        boolean z;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SwanAppActivity activity = sp2.U().getActivity();
            if (activity != null && activity.i0()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                f = 2.5f;
            } else {
                f = 5.0f;
            }
            float min = Math.min(f, this.o.getAdapter().getItemCount());
            Resources resources = this.a.getResources();
            float dimension = resources.getDimension(R.dimen.obfuscated_res_0x7f070722);
            float dimension2 = resources.getDimension(R.dimen.obfuscated_res_0x7f070721);
            float dimension3 = resources.getDimension(R.dimen.obfuscated_res_0x7f07072d);
            Pair<Integer, Integer> x = sp2.U().x();
            this.o.getLayoutParams().width = (int) Math.min(dimension3, ((Integer) x.first).intValue());
            this.o.getLayoutParams().height = (int) Math.min((int) ((min * (resources.getDimension(R.dimen.obfuscated_res_0x7f070729) + dimension)) + dimension2), ((Integer) x.second).intValue() * 0.67f);
            this.o.requestLayout();
        }
    }

    @Override // com.baidu.tieba.m74
    @SuppressLint({"InflateParams"})
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            View i = super.i();
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0859, (ViewGroup) null);
            this.k = inflate;
            this.l = inflate.findViewById(R.id.obfuscated_res_0x7f09204b);
            this.n = this.k.findViewById(R.id.obfuscated_res_0x7f09204e);
            this.m = (ImageView) this.k.findViewById(R.id.obfuscated_res_0x7f09204a);
            z();
            RecyclerView recyclerView = (RecyclerView) this.k.findViewById(R.id.obfuscated_res_0x7f09204d);
            this.o = recyclerView;
            recyclerView.setItemAnimator(null);
            this.o.setLayoutManager(new LinearLayoutManager(this.a));
            this.o.addItemDecoration(new ListRecommendDivider(this.a));
            ListRecommendAdapter listRecommendAdapter = new ListRecommendAdapter(this.a);
            this.p = listRecommendAdapter;
            this.o.setAdapter(listRecommendAdapter);
            A(i);
            return i;
        }
        return (View) invokeV.objValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            j33.a aVar = new j33.a(this.a);
            aVar.m(true);
            aVar.f(true);
            aVar.k(false);
            aVar.j();
            aVar.b();
            aVar.p(17170445);
            aVar.W(this.k);
            aVar.t(false);
            this.j = aVar.c();
            og3.b(sp2.U().getActivity(), this.j);
        }
    }
}
