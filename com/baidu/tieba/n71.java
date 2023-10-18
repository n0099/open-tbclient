package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.p71;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class n71 extends p71 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup b;
    public FrameLayout c;
    public FrameLayout d;
    public Context e;
    public View f;
    public List<a> g;
    public int h;

    /* loaded from: classes7.dex */
    public interface c {
        void onItemClick(View view2);
    }

    public View i(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return null;
        }
        return (View) invokeL.objValue;
    }

    /* loaded from: classes7.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public LinearLayout c;
        public n71 d;
        public final /* synthetic */ n71 e;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;
            public final /* synthetic */ d b;

            public a(d dVar, a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.b.d.dismiss();
                    c cVar = this.a.e;
                    if (cVar != null) {
                        cVar.onItemClick(view2);
                    }
                }
            }
        }

        public d(n71 n71Var, View view2, n71 n71Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n71Var, view2, n71Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = n71Var;
            if (view2 != null) {
                this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091001);
                this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091000);
                this.c = (LinearLayout) view2;
                this.d = n71Var2;
            }
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, aVar) != null) || aVar == null) {
                return;
            }
            this.a.setText(aVar.a);
            if (aVar.c > 0) {
                this.a.setTextColor(this.e.c.getResources().getColor(aVar.c));
            }
            if (!TextUtils.isEmpty(aVar.b)) {
                this.b.setVisibility(0);
                this.b.setText(aVar.b);
            } else {
                this.b.setVisibility(8);
            }
            if (aVar.d > 0) {
                this.b.setTextColor(this.e.c.getResources().getColor(aVar.d));
            }
            this.c.setOnClickListener(new a(this, aVar));
        }
    }

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CharSequence a;
        public CharSequence b;
        public int c;
        public int d;
        public c e;

        public a(CharSequence charSequence, int i, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {charSequence, Integer.valueOf(i), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = -1;
            this.d = -1;
            this.a = charSequence;
            this.c = i;
            this.e = cVar;
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends p71.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<a> f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = new ArrayList();
            f(false);
            g(false);
        }

        @Override // com.baidu.tieba.p71.a
        public p71 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                n71 n71Var = (n71) super.a();
                n71Var.l(this.f);
                return n71Var;
            }
            return (p71) invokeV.objValue;
        }

        public b s(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                if (aVar != null) {
                    tx0.b(this.f, aVar);
                }
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n71(Context context) {
        super(context, R.style.obfuscated_res_0x7f100143);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new ArrayList();
        this.h = 2;
    }

    public final void l(List<a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.g.clear();
            if (list != null) {
                tx0.c(this.g, list);
            }
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            k();
            a().p(this.b);
        }
    }

    public final LinearLayout g(a aVar, LinearLayout linearLayout, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, aVar, linearLayout, i)) == null) {
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.e).inflate(R.layout.nad_item_hv_dialog, (ViewGroup) linearLayout, false);
            linearLayout2.setBackground(getContext().getResources().getDrawable(i));
            new d(this, linearLayout2, this).a(aVar);
            return linearLayout2;
        }
        return (LinearLayout) invokeLLI.objValue;
    }

    public final void h(List<a> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || list == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.e);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        int size = list.size();
        if (size == 0) {
            return;
        }
        if (size == 1) {
            linearLayout.setOrientation(0);
            linearLayout.addView(g(list.get(0), linearLayout, R.drawable.nad_auto_orientation_dialog_btn_left_right_corner_bg_selector));
        } else if (size == this.h) {
            linearLayout.setOrientation(0);
            linearLayout.addView(g(list.get(0), linearLayout, R.drawable.nad_auto_orientation_dialog_btn_left_corner_bg_selector));
            linearLayout.addView(j(0));
            linearLayout.addView(g(list.get(1), linearLayout, R.drawable.nad_auto_orientation_dialog_btn_right_corner_bg_selector));
        } else {
            linearLayout.setOrientation(1);
            for (int i = 0; i < list.size(); i++) {
                if (i < list.size() - 1) {
                    linearLayout.addView(g(list.get(i), linearLayout, R.drawable.nad_auto_orientation_dialog_btn_bg_selector));
                    linearLayout.addView(j(1));
                } else if (i == list.size() - 1) {
                    linearLayout.addView(g(list.get(i), linearLayout, R.drawable.nad_auto_orientation_dialog_btn_left_right_corner_bg_selector));
                }
            }
        }
        this.d.removeAllViews();
        this.d.addView(linearLayout);
    }

    public final View j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            View view2 = new View(this.e);
            view2.setBackgroundColor(this.c.getResources().getColor(R.color.nad_dialog_gray));
            if (i == 1) {
                view2.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            } else {
                view2.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
            }
            return view2;
        }
        return (View) invokeI.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context context = getContext();
            this.e = context;
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.nad_view_hv_dialog, a().c(), false);
            this.b = viewGroup;
            this.c = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f091002);
            this.f = this.b.findViewById(R.id.obfuscated_res_0x7f091003);
            this.d = (FrameLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090fff);
            View i = i(this.c);
            if (i != null) {
                this.c.addView(i);
            }
            m();
            h(this.g);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f.setBackgroundColor(getContext().getResources().getColor(R.color.nad_dialog_gray));
        }
    }
}
