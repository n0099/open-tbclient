package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ql5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public fm5 b;

    /* loaded from: classes5.dex */
    public class a implements vl5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ql5 a;

        /* renamed from: com.baidu.tieba.ql5$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC0397a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0397a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a.b == null) {
                    return;
                }
                this.a.a.b.f();
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a.b == null) {
                    return;
                }
                this.a.a.b.A();
                this.a.a.b.f();
            }
        }

        public a(ql5 ql5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ql5Var;
        }

        @Override // com.baidu.tieba.vl5
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                SkinManager.setBackgroundResource(view2, R.drawable.person_birthday_select_top_bg);
                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09191e);
                textView.setOnClickListener(new View$OnClickListenerC0397a(this));
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1, TbadkCoreApplication.getInst().getSkinType());
                TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09191d);
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, 1, TbadkCoreApplication.getInst().getSkinType());
                textView2.setOnClickListener(new b(this));
            }
        }
    }

    public ql5(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activity;
    }

    public final vl5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (vl5) invokeV.objValue;
    }

    public void c(am5 am5Var) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, am5Var) == null) || (activity = this.a) == null || activity.isFinishing()) {
            return;
        }
        if (this.b == null) {
            tl5 tl5Var = new tl5(this.a, am5Var);
            tl5Var.k(R.layout.obfuscated_res_0x7f0d06f3, b());
            tl5Var.p(new boolean[]{true, true, true, false, false, false});
            tl5Var.j(this.a.getString(R.string.obfuscated_res_0x7f0f0ea3), this.a.getString(R.string.obfuscated_res_0x7f0f0ea0), this.a.getString(R.string.obfuscated_res_0x7f0f0e9d), this.a.getString(R.string.obfuscated_res_0x7f0f0e9e), this.a.getString(R.string.obfuscated_res_0x7f0f0e9f), this.a.getString(R.string.obfuscated_res_0x7f0f0ea1));
            tl5Var.l(2.0f);
            tl5Var.b(false);
            tl5Var.i(SkinManager.getColor(R.color.CAM_X0206));
            tl5Var.m(SkinManager.getColor(R.color.CAM_X0105));
            tl5Var.n(SkinManager.getColor(R.color.CAM_X0109));
            tl5Var.d(SkinManager.getColor(R.color.black_alpha30));
            tl5Var.e(SkinManager.getColor(R.color.CAM_X0201));
            tl5Var.c(false);
            tl5Var.h((ViewGroup) this.a.findViewById(16908290));
            this.b = tl5Var.a();
        }
        this.b.u();
    }
}
